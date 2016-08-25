/**
 * Copyright 2015 Carnegie Mellon University. All Rights Reserved.
 *
 * NO WARRANTY. THIS CARNEGIE MELLON UNIVERSITY AND SOFTWARE ENGINEERING INSTITUTE
 * MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO
 * WARRANTIES OF ANY KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING,
 * BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE OR MERCHANTABILITY,
 * EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON
 * UNIVERSITY DOES NOT MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM
 * PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 *
 * Released under the Eclipse Public License (http://www.eclipse.org/org/documents/epl-v10.php)
 *
 * See COPYRIGHT file for full details.
 */

/*
 * generated by Xtext
 */
package org.osate.assure.generator

import org.osate.assure.assure.AssureFactory
import java.util.Collections
import java.util.List
import org.osate.verify.verify.VerificationPlan
import org.osate.alisa.workbench.alisa.AssuranceTask
import org.osate.alisa.workbench.alisa.AssurancePlan
import org.osate.verify.util.IVerifyGlobalReferenceFinder
import com.google.inject.Inject
import org.osate.aadl2.ComponentClassifier
import org.osate.alisa.workbench.alisa.AssuranceCase
import org.osate.aadl2.ComponentType
import org.osate.aadl2.ComponentImplementation
import org.eclipse.emf.common.util.UniqueEList
import org.osate.assure.assure.ClaimResult
import org.osate.verify.verify.Claim
import org.osate.assure.assure.VerificationExpr
import org.osate.verify.verify.ArgumentExpr
import org.osate.verify.verify.AllExpr
import org.osate.verify.verify.ThenExpr
import org.osate.verify.verify.ElseExpr
import org.osate.verify.verify.RefExpr
import org.osate.assure.assure.VerificationResultState
import org.osate.assure.assure.VerificationExecutionState
import org.osate.verify.verify.VerificationActivity
import org.osate.assure.assure.VerificationResult
import org.osate.verify.verify.VerificationValidation
import org.osate.verify.verify.VerificationPrecondition
import org.osate.verify.verify.VerificationCondition
import org.osate.assure.assure.AssuranceCaseResult
import org.osate.assure.assure.ModelResult
import org.osate.aadl2.util.Aadl2Util
import org.eclipse.emf.common.util.EList
import org.eclipse.emf.common.util.BasicEList
import org.osate.reqspec.reqSpec.SystemRequirementSet
import org.osate.reqspec.reqSpec.RequirementSet

import static extension org.osate.reqspec.util.ReqSpecUtilExtension.*
import static extension org.osate.verify.util.VerifyUtilExtension.*
import static extension org.osate.alisa.workbench.util.AlisaWorkbenchUtilExtension.*
import static extension org.osate.alisa.common.util.CommonUtilExtension.*
import org.osate.reqspec.reqSpec.Requirement
import org.osate.reqspec.reqSpec.GlobalRequirementSet
import org.osate.assure.assure.VerificationActivityResult
import org.osate.assure.assure.QualifiedVAReference
import org.osate.assure.assure.NestedClaimReference
import org.osate.assure.assure.ValidationResult
import org.osate.assure.assure.PreconditionResult
import org.osate.aadl2.NamedElement
import org.osate.assure.assure.QualifiedClaimReference
import org.osate.assure.assure.SubsystemResult
import org.osate.aadl2.Subcomponent
import org.osate.alisa.workbench.util.IAlisaGlobalReferenceFinder
import com.google.inject.ImplementedBy



@ImplementedBy(AssureConstructor)
interface IAssureConstructor {
	def AssuranceCaseResult generateFullAssuranceCase(AssuranceCase acs);
}


/**
 * Generates code from your model files on save.
 * 
 * see http://www.eclipse.org/Xtext/documentation.html#TutorialCodeGeneration
 */
class AssureConstructor implements IAssureConstructor{

// Needs to be synched with Alisa Generator.

	val factory = AssureFactory.eINSTANCE

//	var List<SelectionCategory> selectionFilter = Collections.EMPTY_LIST
//	var List<RequirementCategory> requirementFilter = Collections.EMPTY_LIST
//	var List<VerificationCategory> verificationFilter = Collections.EMPTY_LIST

	
//	var Iterable<VerificationPlan> allPlans = null
	
	
	
	var EList<VerificationPlan> globalPlans

	var EList<Claim> globalClaims
	

//	def constructAssuranceTask(AssuranceTask at) {
//		selectionFilter = at.selectionFilter
//		requirementFilter = at.requirementFilter
//		verificationFilter = at.verificationFilter
//		at.assurancePlan?.constructCase
//	}

	override generateFullAssuranceCase(AssuranceCase acs) {
		globalPlans = new BasicEList()
		globalClaims = new BasicEList()
		acs.constructAssuranceCaseResult
	}

	//Same as generateAssuranceCase(AssuranceCase acp)
	def constructAssuranceCaseResult(AssuranceCase acs) {
		//Revisit later
//		if (acp.assureGlobal.isEmpty){
//			allPlans = referenceFinder.getGlobalReqVerificationPlans(acp)
//		} else {
//			allPlans = acp.assureGlobal
//		}

		
		var AssuranceCaseResult acr = factory.createAssuranceCaseResult
		acr.name = acs.name
		acr.metrics = factory.createMetrics
		acr.metrics.tbdCount = 0
		
		val mrs = acr.modelResult
		
		for (acp : acs.assurancePlans) {
			//For each assurance Plan we add a model result
			
			System.out.println("AssureConstructor constructAssuranceCaseResult: 0000");
			
			val modelResultInstance = acp.constructModelResult
			if(modelResultInstance != null)
				mrs.add(modelResultInstance)
		}
		
		acr
	}
	
	def constructModelResult(AssurancePlan acp) {
		var Iterable<VerificationPlan> myplans = Collections.EMPTY_LIST
			
		var ComponentClassifier cc
		if (acp != null) {
			myplans = acp.assure
			cc = acp.target
			if (myplans.empty && !Aadl2Util.isNull(cc)) {
				myplans = cc.getVerificationPlans(acp)
			}
		}
		
//		'''	
//			model «acp.assuranceCase.name».«acp.name»
//			for «acp.target.getQualifiedName»
//				[
//				tbdcount 0
//				«APparts»
//				]
//		'''

		var ModelResult mr = factory.createModelResult
		mr.plan = acp
		mr.target = acp.target
		mr.metrics = factory.createMetrics
		mr.metrics.tbdCount = 0
		
		
		//Replaces
//		val APparts = doAssurancePlanParts(acp, myplans, cc)
//		if(APparts.length == 0) return ''''''
		doAssurancePlanClaimResultsParts(acp, myplans, cc, mr.claimResult, mr.subsystemResult, mr.subAssuranceCase)
		//doSubsystemResult(acp, myplans, cc, mr.subsystemResult, mr.subAssuranceCase)
		
		System.out.println("AssureConstructor constructModelResult: 1111");
		
		if(mr.claimResult.length == 0 && mr.subsystemResult.length == 0 && mr.subAssuranceCase.length == 0) return null
		
		mr
	}
	
	//Need to collect all ClaimResults and add to claimResultList
	def void doAssurancePlanClaimResultsParts(AssurancePlan assurancePlan, Iterable<VerificationPlan> vplans, 
		ComponentClassifier cc, EList<ClaimResult> claimResultList, EList<SubsystemResult> subsystemResultList, 
		EList<AssuranceCaseResult> subAssuranceCaseList
	) {
		// first collect any global and self includes
		val selfPlans = new BasicEList()
		val selfClaims = new BasicEList()
		val globalPlansTop = globalPlans.size
		val globalClaimsTop = globalClaims.size
		
		//val EList<ClaimResult> returnList =  new BasicEList()
		
		for (vplan : vplans) {
			val reqs = vplan.requirementSet
			if (reqs instanceof SystemRequirementSet) {
				val includes = reqs.include
				for (incl : includes) {
					if (incl.include instanceof RequirementSet) {
						if (incl.componentCategory.matchingCategory(cc.category)) {
							val plans = referenceFinder.
								getAllVerificationPlansForRequirements(incl.include as RequirementSet, vplan)
							if (incl.self) {
								selfPlans.addAll(plans)
							} else {
								globalPlans.addAll(plans)
							}
						}
					} else {
						val greq = incl.include as Requirement
						val greqs = greq.containingRequirementSet
						val plans = referenceFinder.getAllVerificationPlansForRequirements(greqs, vplan)
						for (vp : plans) {
							for (claim : vp.claim) {
								if (claim.requirement.name.equals(greq.name)) {
									if (incl.self) {
										selfClaims.add(claim)
									} else {
										globalClaims.add(claim)
									}
								}
							}
						}
					}
				}
			} else if (reqs instanceof GlobalRequirementSet){
					globalPlans.add(vplan)
			}
		}
		

		
//			«FOR vplan : vplans»
//				«FOR claim : vplan.claim»
//					«IF claim.evaluateRequirementFilter(filter)»
//					«claim.generate()»
//					«ENDIF»
//				«ENDFOR»
//			«ENDFOR»
		for (vplan : vplans) {
			for (claim : vplan.claim) {
					claim.generateClaimResult(claimResultList)		
			}
		}
			
//			«FOR vplan : selfPlans»
//				«IF vplan.requirementSet instanceof SystemRequirementSet»
//				«FOR claim : vplan.claim.filter[cl|cl.requirement?.componentCategory.matchingCategory(cc.category)]»
//				«IF claim.evaluateRequirementFilter(filter)»
//				«claim.generateAll(cc)»
//				«ENDIF»
//				«ENDFOR»
//				«ENDIF»
//			«ENDFOR»
		for (vplan : selfPlans) {
			if(vplan.requirementSet instanceof SystemRequirementSet) {
				for (claim : vplan.claim.filter[cl|cl.requirement?.componentCategory.matchingCategory(cc.category)]) {
						claim.generateAllClaimResult(cc, claimResultList)		
				}
			}
		}


//			«FOR claim : selfClaims.filter[cl|cl.requirement?.componentCategory.matchingCategory(cc.category)]»
//				«IF claim.evaluateRequirementFilter(filter)»
//				«claim.generateAll(cc)»
//				«ENDIF»
//			«ENDFOR»
		for (claim : selfClaims.filter[cl|cl.requirement?.componentCategory.matchingCategory(cc.category)]) {
			claim.generateAllClaimResult(cc, claimResultList)		
		}

//			«FOR vplan : globalPlans»
//				«FOR claim : vplan.claim.filter[cl|cl.requirement?.componentCategory.matchingCategory(cc.category)]»
//					«IF claim.evaluateRequirementFilter(filter)»
//					«claim.generateAll(cc)»
//					«ENDIF»
//				«ENDFOR»
//			«ENDFOR»
		for (vplan : globalPlans) {
			for(claim : vplan.claim.filter[cl|cl.requirement?.componentCategory.matchingCategory(cc.category)]){
				claim.generateAllClaimResult(cc, claimResultList)
			}
		}


//			«FOR claim : globalClaims.filter[cl|cl.requirement?.componentCategory.matchingCategory(cc.category)]»
//				«IF claim.evaluateRequirementFilter(filter)»
//				«claim.generateAll(cc)»
//				«ENDIF»
//			«ENDFOR»

		for (claim : globalClaims.filter[cl|cl.requirement?.componentCategory.matchingCategory(cc.category)]) {
			claim.generateAllClaimResult(cc, claimResultList)
		}

//			«IF cc instanceof ComponentImplementation»
//				«FOR subc : cc.allSubcomponents»
//					«subc.generateSubsystemPlans(assurancePlan)»
//				«ENDFOR»
//			«ENDIF»

		if(cc instanceof ComponentImplementation){
			for(subc : cc.allSubcomponents){
				subc.generateSubsystemPlans(assurancePlan, subsystemResultList, subAssuranceCaseList)
			}
		}
		
		var plansize = globalPlans.size
		while (plansize > globalPlansTop) {
			globalPlans.remove(plansize - 1)
			plansize = plansize - 1
		}
		var claimsize = globalClaims.size
		while (claimsize > globalClaimsTop) {
			globalClaims.remove(claimsize - 1)
			claimsize = claimsize - 1
		}
	}
	
	//def CharSequence generateAll(Claim claim, ComponentClassifier cc)
	def void generateAllClaimResult(Claim claim, ComponentClassifier cc, EList<ClaimResult> claimResultlist) {
//		«IF cc instanceof ComponentImplementation && claim.requirement.connections»
//		«FOR conn : (cc as ComponentImplementation).crossConnections»
//		«claim.generate(conn.name)»
//		«ENDFOR»
//		«ELSE»
//		«claim.generate()»
//		«ENDIF»
		if(cc instanceof ComponentImplementation && claim.requirement.connections){
			for(conn : (cc as ComponentImplementation).crossConnections){
				claim.generateClaimResult(claimResultlist, conn)
			}
		}else {
			claim.generateClaimResult(claimResultlist)
		}

		
	}
	
	
	def void generateClaimResult(Claim claim, EList<ClaimResult> claimResultlist) {
		claim.generateClaimResult(claimResultlist, claim.requirement.targetElement)
	}
	
	//def CharSequence generate(Claim claim, String forTargetElement) does same.
	//Add to claimResultlist for claim
	def void generateClaimResult(Claim claim, EList<ClaimResult> claimResultlist, NamedElement forTargetElement) {
		val claimvas = doGenerateVA(claim)
//		val subclaims = if(claim.subclaim != null) doGenerateSubclaims(claim) else ''''''
//		val claimassert = if(claim.assert != null) claim.assert.generate else ''''''
		if(claimvas.length == 0 && claim.subclaim == null && claim.assert == null) return
//		'''
//		claim «claim.constructClaimReference»
//		[
//			tbdcount 0
//			«IF forTargetElement != null»
//			for «forTargetElement»
//			«ENDIF»
//			«IF claim.assert != null»
//			«claimassert»
//			«ELSE»
//			«claimvas»
//			«ENDIF»
//		]
//		'''
		
		val ClaimResult claimResult = factory.createClaimResult
		
		//QualifiedClaimReference
		val QualifiedClaimReference qcr = factory.createQualifiedClaimReference
		qcr.verificationPlan = claim.containingVerificationPlan
		val NestedClaimReference ncr = factory.createNestedClaimReference
		ncr.requirement = claim.requirement
		qcr.requirement = constructClaimReferencePath(claim, ncr)
		claimResult.targetReference = qcr
		//------------//QualifiedClaimReference
		
		claimResult.metrics = factory.createMetrics
		claimResult.metrics.tbdCount = 0
		
		if(forTargetElement != null){
			claimResult.modelElement = forTargetElement
		}
		
		//val subclaims = if(claim.subclaim != null) doGenerateSubclaims(claim) else ''''''
		if(claim.subclaim != null) {
			for (subclaim : claim?.subclaim) {
				//claimResult.subClaimResult += subclaim.construct //Does the same as next line with no targetElement
				generateClaimResult(subclaim, claimResult.subClaimResult, claim.requirement.targetElement)
			}
		}
		
		
		if(claim.assert != null){
			//TODO: Need to check
			claimResult.verificationActivityResult.construct(claim.assert)
			
			
		} else {
			for(claimva : claimvas) {
				claimResult.verificationActivityResult.add(claimva)
			}
		}
		
		claimResultlist.add(claimResult)
		
	}
	
	@Inject IAlisaGlobalReferenceFinder refFinder
	
	
	//subAssuranceCaseList could be null because SubsystemResult doesn't have subAssuranceCase. 
	//Let's see if it is used when null
	def void generateSubsystemPlans(Subcomponent subc, AssurancePlan parentap, 
		EList<SubsystemResult> subsystemResultList, EList<AssuranceCaseResult> subAssuranceCaseList
	) {
		val cc = subc.allClassifier
		if(subc.isAssumeSubsystem(parentap)){
			subc.generateSubsystemGlobalOnly(parentap, subsystemResultList)
			return
		} 
		switch (cc) {
			ComponentType:
				subc.generateSubsystemGlobalOnly(parentap, subsystemResultList)
			ComponentImplementation: {
				val subacs = refFinder.getAssuranceCases(cc)
				if (subacs.empty) {
					subc.generateSubsystemVerificationPlansGlobals(parentap, subsystemResultList)
				} else {
				
				//This is for adding subAssuranceCases
//				'''
//				«FOR subac : subacs»
//				«subac.generateAssuranceCase»
//				«ENDFOR»
//				'''	
					for(subac : subacs){
						
						subAssuranceCaseList.add(subac.constructAssuranceCaseResult)
					}
				}
			}
		}
	}
	
	
	/**
	 * sub: system of interest as subcomponent of another system
	 */
	def void generateSubsystemVerificationPlansGlobals(Subcomponent sub,AssurancePlan mp, EList<SubsystemResult> subsystemResultList) {
		var Iterable<VerificationPlan> myplans = Collections.EMPTY_LIST
		var ComponentClassifier cc
		if (!Aadl2Util.isNull(sub)) {
			cc = sub.allClassifier
			if (!Aadl2Util.isNull(cc)) {
				myplans = cc.getVerificationPlans(mp);
			}
		}
		
//		'''	
//			subsystem «sub.name» 
//			[
//			tbdcount 0
//			«APparts»
//			]
//		'''

		
		val SubsystemResult ssr = factory.createSubsystemResult
		ssr.targetSystem = sub
		ssr.metrics = factory.createMetrics
		ssr.metrics.tbdCount = 0
		
		
		//Replaces
//		val APparts = doAssurancePlanParts(mp, myplans, cc)
		doAssurancePlanClaimResultsParts(mp, myplans, cc, ssr.claimResult, ssr.subsystemResult, null)
		//doSubsystemResult(mp, myplans, cc, ssr.subsystemResult, null)
		
//		if(APparts.length == 0) return ''''''
//		if(claimResults.length == 0 && subsystemResults.length == 0) return null


		
		
		subsystemResultList.add(ssr)

	}
	
	/**
	 * sub: system of interest as subcomponent of another system only for global requirements from enclosing case
	 * Otherwiase it was marked as assume, i.e., local assurance case/verification plans are not executed
	 */
	def void generateSubsystemGlobalOnly(Subcomponent sub, AssurancePlan mp, EList<SubsystemResult> subsystemResultList) {
		var Iterable<VerificationPlan> myplans = Collections.EMPTY_LIST
		
		//		'''	
//			subsystem «sub.name» 
//			[
//			tbdcount 0
//			«APparts»
//			]
//		'''
	
		val SubsystemResult ssr = factory.createSubsystemResult
		ssr.targetSystem = sub
		ssr.metrics = factory.createMetrics
		ssr.metrics.tbdCount = 0
		
		
		//Replaces
//		val APparts = doAssurancePlanParts(mp, myplans, sub.allClassifier)
		doAssurancePlanClaimResultsParts(mp, myplans, sub.allClassifier, ssr.claimResult, ssr.subsystemResult, null)
		//doSubsystemResult(mp, myplans, sub.allClassifier, ssr.subsystemResult, null)
		
//		if(APparts.length == 0) return ''''''
//		if(claimResults.length == 0 && subsystemResults.length == 0) return null
		
		
		subsystemResultList.add(ssr)
	}
	
	//From Alisa Generator
	def boolean isAssumeSubsystem(Subcomponent subc, AssurancePlan parentacp) {
		if(parentacp == null) return false
		if(parentacp.assumeAll) return true
		val assumes = parentacp.assumeSubsystems
		for (sub : assumes) {
			if(sub.name.equalsIgnoreCase(subc.name)) return true;
		}
		return false
	}

	def doGenerateVA(Claim claim) {
		val EList<VerificationActivityResult> returnList = new BasicEList()
//		'''
//			«FOR va : claim.activities»
//				«va.doGenerate»
//			«ENDFOR»
//		'''
		for (va : claim.activities) {
			addVAR(va, returnList);
		}
		
		returnList
	}
	
	def void addVAR(VerificationActivity va, EList<VerificationActivityResult> vaList) {
		val vaResult = factory.createVerificationActivityResult
		
		//QualifiedVAReference
		val QualifiedVAReference qvr = factory.createQualifiedVAReference
		qvr.verificationPlan = va.containingVerificationPlan
		
		val NestedClaimReference ncr = factory.createNestedClaimReference
		val claim = va.containingClaim
		ncr.requirement = claim.requirement
		
		qvr.requirement = constructClaimReferencePath(claim, ncr)
		
		qvr.verificationActivity = va
		vaResult.targetReference = qvr
		//-----------QualifiedVAReference END
		
		
		vaResult.executionState = VerificationExecutionState.TODO
		vaResult.resultState = VerificationResultState.TBD
		vaResult.metrics = factory.createMetrics
		vaResult.metrics.tbdCount = 0
		
		if(va.method?.precondition != null){
			vaResult.preconditionResult = doConstruct(va.method.precondition, va)
		}
		
		if(va.method?.validation != null){
			vaResult.validationResult = doConstruct(va.method.validation, va)
		}
		
		vaList.add(vaResult)
	}
	
	def NestedClaimReference constructClaimReferencePath(Claim claim, NestedClaimReference ncr){
		val parent = claim.eContainer
		if (parent instanceof Claim){
			val NestedClaimReference parentNcr = factory.createNestedClaimReference
			parentNcr.requirement = parent.requirement
			return constructClaimReferencePath(parent, parentNcr)
		}
		return ncr
	}
	
//	def construct(AssuranceCase acs) {
		//Revisit later
//		if (acp.assureGlobal.isEmpty){
//			allPlans = referenceFinder.getGlobalReqVerificationPlans(acp)
//		} else {
//			allPlans = acp.assureGlobal
//		}
//		acp.target.construct(acp, false)
//	}

//	def constructCase(AssurancePlan acp) {
		//Revisit later
//		if (acp.assureGlobal.isEmpty){
//			allPlans = referenceFinder.getGlobalReqVerificationPlans(acp)
//		} else {
//			allPlans = acp.assureGlobal
//		}
//		acp.target.construct(acp, false)
//	}

//	def constructSystemEvidence(ComponentClassifier cc, AssurancePlan parentacp) {
//		cc.construct(parentacp, true)
//	}

	@Inject extension IVerifyGlobalReferenceFinder referenceFinder

//	/**
//	 * if systemEvidence is true then acp is the parent acp. Therefore we need to find the verification plans for the system.
//	 */
//	def AssuranceCase construct(ComponentClassifier cc, AssurancePlan acp, boolean systemEvidence) {
//		var Iterable<VerificationPlan> myplans = Collections.EMPTY_LIST
//		if (!systemEvidence){
//			myplans = acp.assureOwn
//		}
//		if (myplans.empty){
//		 myplans = cc.getVerificationPlans(acp);
//		}
//		var AssuranceCase acase = null
//		if (!myplans.empty) {
//			acase = factory.createAssuranceCase
//			acase.name = acp.name
//			acase.target = acp
//			acase.metrics = factory.createMetrics
//			for (myplan : myplans) {
//				for (claim : (myplan as VerificationPlan).claim) {
//					if (claim.evaluateRequirementFilter(requirementFilter))
//						acase.claimResult += claim.construct
//				}
//			}
//			for (myplan : allPlans) {
//				for (claim : (myplan as VerificationPlan).claim) {
//					if (claim.evaluateRequirementFilter(requirementFilter))
//						acase.claimResult += claim.construct
//				}
//			}
//			for (subci : cc.subcomponentClassifiers) {
//				acase.subAssuranceCase += subci.filterplans(acp)
//			}
//		}
//		acase
//	}
//
//	def AssuranceCase filterplans(ComponentClassifier cc, AssurancePlan parentacp) {
//		if(cc instanceof ComponentType || cc.skipAssuranceplans(parentacp)) return null
//		val subacp = cc.getSubsystemAssuranceplan(parentacp)
//		if (subacp != null) {
//			subacp.constructCase
//		} else {
//			cc.constructSystemEvidence(parentacp)
//		}
//	}
//
//	def subcomponentClassifiers(ComponentClassifier cl) {
//		if (cl instanceof ComponentImplementation) {
//			val List<ComponentClassifier> result = new UniqueEList<ComponentClassifier>()
//			result += cl.allSubcomponents.map[sub|sub.classifier]
//			result
//		} else {
//			Collections.emptyList
//		}
//	}
//
//	def boolean skipAssuranceplans(ComponentClassifier cc, AssurancePlan parentacp) {
//		if (parentacp.assumeAll) return true
//		val assumes = parentacp.assumeSubsystems
//		for (cl : assumes) {
//			if(cc.isSameorExtends(cl)) return true;
//		}
//		return false
//	}
//
//	def AssurancePlan getSubsystemAssuranceplan(ComponentClassifier cc, AssurancePlan parentacp) {
//		val assure = parentacp.assureSubsystemPlans
//		for (ap : assure) {
//			if(cc.isSameorExtends(ap.target)) return ap;
//		}
//		return null
//	}



//Does same as generateClaimResult(Claim claim, EList<ClaimResult> claimResultlist)
//	def ClaimResult construct(Claim claim) {
//		val claimresult = factory.createClaimResult
//		
//		//claimresult.target = claim.requirement
//		//QualifiedClaimReference
//		val QualifiedClaimReference qcr = factory.createQualifiedClaimReference
//		qcr.verificationPlan = claim.containingVerificationPlan
//		val NestedClaimReference ncr = factory.createNestedClaimReference
//		ncr.requirement = claim.requirement
//		qcr.requirement = constructClaimReferencePath(claim, ncr)
//		claimresult.targetReference = qcr
//		//------------//QualifiedClaimReference
//		
//		
//		
//		claimresult.metrics = factory.createMetrics
//		for (subclaim : claim?.subclaim) {
//			claimresult.subClaimResult += subclaim.construct
//		}
//		if (claim.assert != null) {
//			claimresult.verificationActivityResult.construct(claim.assert)
//		} else {
//			for (va : claim.activities) {
//				claimresult.verificationActivityResult.doConstruct(va)
//			}
//		}
//		claimresult
//	}

	def void construct(List<VerificationExpr> arl, ArgumentExpr expr) {
		switch expr {
			AllExpr: arl.doConstruct(expr)
			ThenExpr: arl.doConstruct(expr)
			ElseExpr: arl.doConstruct(expr)
			RefExpr: arl.doConstruct(expr)
		}
	}

	def void doConstruct(List<VerificationExpr> arl, AllExpr expr) {
		for (subexpr : expr.elements) {
			arl.construct(subexpr)
		}
	}

	def void doConstruct(List<VerificationExpr> arl, ThenExpr expr) {
		val thenres = factory.createThenResult
		thenres.metrics = factory.createMetrics
		thenres.metrics.tbdCount = 0
		thenres.first.construct(expr.left)
		thenres.second.construct(expr.successor)
		if (thenres.first.empty) return;
		if (thenres.second.empty) {
			arl += thenres.first
		} else {
			arl += thenres
		}
	}

	def void doConstruct(List<VerificationExpr> arl, ElseExpr expr) {
		val elseres = factory.createElseResult
		elseres.metrics = factory.createMetrics
		elseres.metrics.tbdCount = 0
		elseres.first.construct(expr.left)
		elseres.error.construct(expr.error)
		if(expr.fail != null) elseres.fail.construct(expr.fail)
		if(expr.timeout != null) elseres.timeout.construct(expr.timeout)
		
		if (elseres.first.empty) return;
		if (elseres.error.empty && elseres.fail.empty && elseres.timeout.empty){
			arl += elseres.first
		} else {
			arl += elseres
		}
	}

	//Seems almost the same as addVA refactor later
	def void doConstruct(List<VerificationExpr> arl, RefExpr expr) {
		val va = expr.verification
		
		if(va == null) return;
		
//		«IF va.evaluateVerificationActivityFilter(filter) && va.evaluateVerificationMethodFilter(filter) »
//				verification «va.constructVerificationActivityReference»
//				[
//					executionstate todo
//					resultstate tbd
//					tbdcount 0
//					«IF va.method?.precondition != null»
//						precondition «va.method.fullyQualifiedName»
//						[
//							executionstate todo
//							resultstate tbd
//							tbdcount 0
//						]
//					«ENDIF»
//					«IF va.method?.validation != null»
//						validation «va.method.fullyQualifiedName»
//						[
//							executionstate todo
//							resultstate tbd
//							tbdcount 0
//						]
//					«ENDIF»
//				]
//		«ENDIF»
		
		//if (va.evaluateSelectionFilter(selectionFilter) && va.evaluateVerificationFilter(verificationFilter)) {
			val vr = factory.createVerificationActivityResult
			vr.resultState = VerificationResultState.TBD
			vr.executionState = VerificationExecutionState.TODO
			
			//vr.target = expr.verification
			//QualifiedVAReference
			val QualifiedVAReference qvr = factory.createQualifiedVAReference
			qvr.verificationPlan = va.containingVerificationPlan
			
			val NestedClaimReference ncr = factory.createNestedClaimReference
			val claim = va.containingClaim
			ncr.requirement = claim.requirement
			
			qvr.requirement = constructClaimReferencePath(claim, ncr)
			
			qvr.verificationActivity = va
			vr.targetReference = qvr
			//-----------QualifiedVAReference END
		
		
		
			vr.metrics = factory.createMetrics
			vr.metrics.tbdCount = 0
			arl += vr
			
			
			if(va.method?.precondition != null){
				vr.preconditionResult = doConstruct(va.method.precondition, va)
			}
		
			if(va.method?.validation != null){
				vr.validationResult = doConstruct(va.method.validation, va)
			}

		//}
	}

	//mnam: not called?
//	def void doConstruct(List<VerificationExpr> arl, VerificationActivity expr) {
//		//if (expr.evaluateSelectionFilter(selectionFilter)) {
//		val vr = factory.createVerificationActivityResult
//		vr.resultState = VerificationResultState.TBD
//		vr.executionState = VerificationExecutionState.TODO
//		vr.target = expr
//		vr.metrics = factory.createMetrics
//		val cond = expr.method?.precondition
//		if (cond != null) {
//			vr.preconditionResult = doConstruct(cond)
//		}
//		//}
//	}

	//in use
	def VerificationResult doConstruct( VerificationCondition vc, VerificationActivity va) {
		var VerificationResult vcr
		switch (vc) {
			VerificationValidation: {
				vcr = factory.createValidationResult()
				(vcr as ValidationResult).target = va.method
			}
			VerificationPrecondition: {
				vcr = factory.createPreconditionResult()
				(vcr as PreconditionResult).target = va.method
			}
		}
		vcr.resultState = VerificationResultState.TBD
		vcr.executionState = VerificationExecutionState.TODO
		vcr.metrics = factory.createMetrics
		vcr.metrics.tbdCount = 0
		return vcr
	}

	
}