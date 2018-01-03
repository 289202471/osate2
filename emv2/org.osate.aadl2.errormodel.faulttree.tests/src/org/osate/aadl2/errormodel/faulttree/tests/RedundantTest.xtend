package org.osate.aadl2.errormodel.faulttree.tests

import org.eclipse.core.runtime.Path
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.util.Files
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.AadlPackage
import org.osate.aadl2.SystemImplementation
import org.osate.aadl2.errormodel.faulttree.generation.CreateFTAModel
import org.osate.aadl2.errormodel.tests.ErrorModelUiInjectorProvider
import org.osate.aadl2.instantiation.InstantiateModel
import org.osate.core.test.OsateTest

import static org.junit.Assert.*
import org.eclipse.emf.ecore.util.EcoreUtil

@RunWith(typeof(XtextRunner))
@InjectWith(typeof(ErrorModelUiInjectorProvider))
class RedundantTest extends OsateTest {
	override getProjectName() {
		"RedundantTest"
	}
	
	

/**
-- composite error behavior specification
-- Does not pick up contributions from CPU, memory, bus since they do not affect the FailStop state of voter.
-- Those are propagated as flows through outgoing propagations rather than related to state.
-- The composite error behavior expression can be expanded to include them
 * We are generating FailStop.
 */
	@Test
	def void redundantfta() {
		val aadlFile = "redundant.aadl"
		val state = "state FailStop"
		createFiles(aadlFile -> aadlText) // TODO add all files to workspace
		suppressSerialization
		val result = testFile(aadlFile /*, referencedFile1, referencedFile2, etc. */ )

		// get the correct package
		val pkg = result.resource.contents.head as AadlPackage
		val cls = pkg.ownedPublicSection.ownedClassifiers
		assertTrue('', cls.exists[name == 'main.compositestate'])

		// instantiate
		val sysImpl = cls.findFirst[name == 'main.compositestate'] as SystemImplementation
		val instance = InstantiateModel::buildInstanceModelFile(sysImpl)
//		assertEquals("fta_main_i_Instance", instance.name)

		
		val ft = CreateFTAModel.createTransformedFTA(instance,state)
		val uri = EcoreUtil.getURI(ft)
		val file = workspaceRoot.getFile(new Path(uri.toPlatformString(true)))
		val actual = Files.readStreamIntoString(file.contents)
		assertEquals('error', expected.trim, actual.trim)
		
	}

	val aadlText = '''
package redundant
public

data mydata
end mydata;

processor cpu
annex EMV2 {**
	use types errorlibrary;
 	use behavior ErrorLibrary::FailStop;
	error propagations
		bindings: out propagation {ServiceError};
	flows
		cpufail : error source  bindings{ServiceError};
	end propagations;
**};
end cpu;

memory mem
annex EMV2 {**
	use types errorlibrary;
 	use behavior ErrorLibrary::FailStop;
	error propagations
		bindings: out propagation {ServiceError};
	flows
		memfail : error source  bindings{ServiceError};
	end propagations;
**};
end mem;


bus transport
annex EMV2 {**
	use types errorlibrary;
 	use behavior ErrorLibrary::FailStop;
	error propagations
		bindings: out propagation {ServiceError};
	flows
		busfail : error source  bindings{ServiceError};
	end propagations;
**};
end transport;

device sensor
features
	valueout : out data port mydata;
annex EMV2{**
 	use types ErrorLibrary;
 	use behavior ErrorLibrary::FailStop;
 	error propagations
 		valueout : out propagation {SequenceOmission, LateDelivery, OutOfRange};
 	flows
 		ef0 : error source valueout{LateDelivery};
 		ef1 : error source valueout{OutOfRange};
 	end propagations;
 **};
end sensor;

device actuator
features
	valuein : in data port mydata;
	effect: out feature;
annex EMV2{**
 	use types ErrorLibrary;
 	use behavior ErrorLibrary::FailStop;
 	error propagations
 		valuein : in propagation {ItemOmission,ValueCorruption,InconsistentValue};
 		effect: out propagation {ServiceOmission};
 	end propagations;
 	
 	component error behavior
 	propagations
 		t0 : Operational -[ valuein{ItemOmission}]-> effect{ServiceOmission};
 		t1 : Operational -[ valuein{ValueCorruption}]-> effect{ServiceOmission};
 		t2 : Operational -[ valuein{InconsistentValue}]-> effect{ServiceOmission};
 	end component;
 **};
end actuator;


thread voter_thr
features
	valuein1 : in data port mydata;
	valuein2 : in data port mydata;
	valueout : out data port mydata;
annex EMV2{**
 	use types ErrorLibrary;
 	use behavior ErrorLibrary::FailStop;
 	error propagations
 		valuein1 : in propagation {LateDelivery, OutOfRange};
 		valuein2 : in propagation {LateDelivery, OutOfRange};
 		valueout : out propagation {ItemOmission,ValueCorruption,InconsistentValue};
 		processor: in propagation {ServiceError}; 
 		memory   : in propagation {ServiceError};
 	flows
 		ef1 : error path valuein1{LateDelivery,OutOfRange} -> valueout{ItemOmission};
 		ef2 : error path valuein2{LateDelivery,OutOfRange} -> valueout{ItemOmission};
 		ef3 : error path processor{ServiceError} -> valueout{ItemOmission};
 		ef4 : error path memory{ServiceError} -> valueout{ValueCorruption};
 		ef5 : error source valueout{InconsistentValue};
 	end propagations;
 **};
end voter_thr;

process voter
features
	valuein1 : in data port mydata;
	valuein2 : in data port mydata;
	valueout : out data port mydata;
end voter;

process implementation voter.i
subcomponents
	thr : thread voter_thr;
connections
	c0 : port valuein1 -> thr.valuein1;
	c1 : port valuein2 -> thr.valuein2;
	c2 : port thr.valueout -> valueout;
end voter.i;

system main

end main;


-- composite error behavior specification
-- Does not pick up contributions from CPU, memory, bus since they do not affect the FailStop state of voter.
-- Those are propagated as flows through outgoing propagations rather than related to state.
-- The composite error behavior expression can be expanded to include them
system implementation main.compositestate
subcomponents
	sensor1 : device sensor;
	sensor2 : device sensor;
	voter   : process voter.i;
	actuator : device actuator;
	
	cpu : processor cpu;
	mem : memory mem;
	
	mybus : bus transport;
connections
	c0 : port sensor1.valueout -> voter.valuein1;
	c1 : port sensor2.valueout -> voter.valuein2;
	c2 : port voter.valueout -> actuator.valuein;
properties
	actual_processor_binding => (reference (cpu)) applies to voter;
	actual_memory_binding => (reference (mem)) applies to voter;
	Actual_Connection_Binding => (reference (mybus)) applies to c0;
	Actual_Connection_Binding => (reference (mybus)) applies to c1;
	Actual_Connection_Binding => (reference (mybus)) applies to c2;
annex EMV2{**
 	use types ErrorLibrary;
 	use behavior ErrorLibrary::FailStop;

 	composite error behavior 
 	states
 		[ sensor1.failstop and sensor2.failstop or actuator.failstop or voter.thr.FailStop]-> FailStop;
  	end composite;
 **};
end main.compositestate;

end redundant;
	'''

	val expected = '''
<?xml version="1.0" encoding="ASCII"?>
<FaultTree:FaultTree xmi:version="2.0" xmlns:xmi="http://www.omg.org/XMI" xmlns:FaultTree="http://www.aadl.info/FaultTree" name="redundant_main_compositestate-failstop" description="Top Level Failure" root="//@events.5">
  <events name="sensor1-failure" description="Component 'sensor1' failure event 'Failure'" referenceCount="1">
    <relatedInstanceObject href="../../redundant_main_compositestate_Instance.aaxl2#//@componentInstance.1"/>
    <relatedEMV2Object href="../../../../../plugin/org.osate.aadl2.errormodel.contrib/resources/packages/ErrorLibrary.aadl#/0/@ownedPublicSection/@ownedAnnexLibrary.0/@parsedAnnexLibrary/@behaviors.0/@events.0"/>
  </events>
  <events name="sensor2-failure" description="Component 'sensor2' failure event 'Failure'" referenceCount="1">
    <relatedInstanceObject href="../../redundant_main_compositestate_Instance.aaxl2#//@componentInstance.2"/>
    <relatedEMV2Object href="../../../../../plugin/org.osate.aadl2.errormodel.contrib/resources/packages/ErrorLibrary.aadl#/0/@ownedPublicSection/@ownedAnnexLibrary.0/@parsedAnnexLibrary/@behaviors.0/@events.0"/>
  </events>
  <events name="Intermediate1" subEvents="//@events.0 //@events.1" referenceCount="1" type="Intermediate" subEventLogic="And">
    <relatedInstanceObject href="../../redundant_main_compositestate_Instance.aaxl2#/"/>
    <relatedEMV2Object href="../../../redundant.aadl#/0/@ownedPublicSection/@ownedClassifier.10/@ownedAnnexSubclause.0/@parsedAnnexSubclause/@states.0/@condition/@operands.0/@operands.0"/>
  </events>
  <events name="actuator-failure" description="Component 'actuator' failure event 'Failure'" referenceCount="1">
    <relatedInstanceObject href="../../redundant_main_compositestate_Instance.aaxl2#//@componentInstance.3"/>
    <relatedEMV2Object href="../../../../../plugin/org.osate.aadl2.errormodel.contrib/resources/packages/ErrorLibrary.aadl#/0/@ownedPublicSection/@ownedAnnexLibrary.0/@parsedAnnexLibrary/@behaviors.0/@events.0"/>
  </events>
  <events name="voter.thr-failure" description="Component 'voter.thr' failure event 'Failure'" referenceCount="1">
    <relatedInstanceObject href="../../redundant_main_compositestate_Instance.aaxl2#//@componentInstance.5/@componentInstance.0"/>
    <relatedEMV2Object href="../../../../../plugin/org.osate.aadl2.errormodel.contrib/resources/packages/ErrorLibrary.aadl#/0/@ownedPublicSection/@ownedAnnexLibrary.0/@parsedAnnexLibrary/@behaviors.0/@events.0"/>
  </events>
  <events name="redundant_main_compositestate-failstop" subEvents="//@events.2 //@events.3 //@events.4" referenceCount="1" type="Intermediate" subEventLogic="Xor">
    <relatedInstanceObject href="../../redundant_main_compositestate_Instance.aaxl2#/"/>
    <relatedEMV2Object href="../../../redundant.aadl#/0/@ownedPublicSection/@ownedClassifier.10/@ownedAnnexSubclause.0/@parsedAnnexSubclause/@states.0/@condition"/>
  </events>
  <instanceRoot href="../../redundant_main_compositestate_Instance.aaxl2#/"/>
</FaultTree:FaultTree>
	'''

}