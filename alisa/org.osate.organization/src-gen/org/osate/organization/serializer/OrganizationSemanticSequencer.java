package org.osate.organization.serializer;

import com.google.inject.Inject;
import com.google.inject.Provider;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.serializer.acceptor.ISemanticSequenceAcceptor;
import org.eclipse.xtext.serializer.diagnostic.ISemanticSequencerDiagnosticProvider;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.Acceptor;
import org.eclipse.xtext.serializer.sequencer.AbstractDelegatingSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.GenericSequencer;
import org.eclipse.xtext.serializer.sequencer.ISemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService;
import org.osate.organization.organization.Organization;
import org.osate.organization.organization.OrganizationPackage;
import org.osate.organization.organization.Stakeholder;
import org.osate.organization.services.OrganizationGrammarAccess;

@SuppressWarnings("all")
public class OrganizationSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private OrganizationGrammarAccess grammarAccess;
	
	public void createSequence(EObject context, EObject semanticObject) {
		if(semanticObject.eClass().getEPackage() == OrganizationPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case OrganizationPackage.ORGANIZATION:
				if(context == grammarAccess.getOrganizationRule()) {
					sequence_Organization(context, (Organization) semanticObject); 
					return; 
				}
				else break;
			case OrganizationPackage.STAKEHOLDER:
				if(context == grammarAccess.getStakeholderRule()) {
					sequence_Stakeholder(context, (Stakeholder) semanticObject); 
					return; 
				}
				else break;
			}
		if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Constraint:
	 *     (name=ID stakeholder+=Stakeholder+)
	 */
	protected void sequence_Organization(EObject context, Organization semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID (title=STRING? description=STRING? role=STRING? email=STRING? phone=STRING?)?)
	 */
	protected void sequence_Stakeholder(EObject context, Stakeholder semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
}