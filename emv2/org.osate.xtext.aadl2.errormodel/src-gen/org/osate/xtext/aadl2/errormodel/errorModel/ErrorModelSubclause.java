/**
 */
package org.osate.xtext.aadl2.errormodel.errorModel;

import org.eclipse.emf.common.util.EList;

import org.osate.aadl2.AnnexSubclause;
import org.osate.aadl2.PropertyAssociation;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Subclause</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelSubclause#getUseTypes <em>Use Types</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelSubclause#getTypeEquivalence <em>Type Equivalence</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelSubclause#getUseTypeMappingSet <em>Use Type Mapping Set</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelSubclause#getUseBehavior <em>Use Behavior</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelSubclause#getPropagations <em>Propagations</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelSubclause#getFlows <em>Flows</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelSubclause#getUseTransformation <em>Use Transformation</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelSubclause#getEvents <em>Events</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelSubclause#getTransitions <em>Transitions</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelSubclause#getOutgoingPropagationConditions <em>Outgoing Propagation Conditions</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelSubclause#getErrorDetections <em>Error Detections</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelSubclause#getErrorStateToModeMappings <em>Error State To Mode Mappings</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelSubclause#getStates <em>States</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelSubclause#getTypeTransformationSet <em>Type Transformation Set</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelSubclause#getConnectionErrorSources <em>Connection Error Sources</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelSubclause#getPoints <em>Points</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelSubclause#getConnections <em>Connections</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelSubclause#getProperties <em>Properties</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getErrorModelSubclause()
 * @model
 * @generated
 */
public interface ErrorModelSubclause extends AnnexSubclause, TypeUseContext
{
  /**
   * Returns the value of the '<em><b>Use Types</b></em>' reference list.
   * The list contents are of type {@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelLibrary}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Use Types</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Use Types</em>' reference list.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getErrorModelSubclause_UseTypes()
   * @model
   * @generated
   */
  EList<ErrorModelLibrary> getUseTypes();

  /**
   * Returns the value of the '<em><b>Type Equivalence</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type Equivalence</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type Equivalence</em>' reference.
   * @see #setTypeEquivalence(TypeMappingSet)
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getErrorModelSubclause_TypeEquivalence()
   * @model
   * @generated
   */
  TypeMappingSet getTypeEquivalence();

  /**
   * Sets the value of the '{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelSubclause#getTypeEquivalence <em>Type Equivalence</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type Equivalence</em>' reference.
   * @see #getTypeEquivalence()
   * @generated
   */
  void setTypeEquivalence(TypeMappingSet value);

  /**
   * Returns the value of the '<em><b>Use Type Mapping Set</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Use Type Mapping Set</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Use Type Mapping Set</em>' reference.
   * @see #setUseTypeMappingSet(TypeMappingSet)
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getErrorModelSubclause_UseTypeMappingSet()
   * @model
   * @generated
   */
  TypeMappingSet getUseTypeMappingSet();

  /**
   * Sets the value of the '{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelSubclause#getUseTypeMappingSet <em>Use Type Mapping Set</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Use Type Mapping Set</em>' reference.
   * @see #getUseTypeMappingSet()
   * @generated
   */
  void setUseTypeMappingSet(TypeMappingSet value);

  /**
   * Returns the value of the '<em><b>Use Behavior</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Use Behavior</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Use Behavior</em>' reference.
   * @see #setUseBehavior(ErrorBehaviorStateMachine)
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getErrorModelSubclause_UseBehavior()
   * @model
   * @generated
   */
  ErrorBehaviorStateMachine getUseBehavior();

  /**
   * Sets the value of the '{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelSubclause#getUseBehavior <em>Use Behavior</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Use Behavior</em>' reference.
   * @see #getUseBehavior()
   * @generated
   */
  void setUseBehavior(ErrorBehaviorStateMachine value);

  /**
   * Returns the value of the '<em><b>Propagations</b></em>' containment reference list.
   * The list contents are of type {@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorPropagation}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Propagations</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Propagations</em>' containment reference list.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getErrorModelSubclause_Propagations()
   * @model containment="true"
   * @generated
   */
  EList<ErrorPropagation> getPropagations();

  /**
   * Returns the value of the '<em><b>Flows</b></em>' containment reference list.
   * The list contents are of type {@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorFlow}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Flows</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Flows</em>' containment reference list.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getErrorModelSubclause_Flows()
   * @model containment="true"
   * @generated
   */
  EList<ErrorFlow> getFlows();

  /**
   * Returns the value of the '<em><b>Use Transformation</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Use Transformation</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Use Transformation</em>' reference.
   * @see #setUseTransformation(TypeTransformationSet)
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getErrorModelSubclause_UseTransformation()
   * @model
   * @generated
   */
  TypeTransformationSet getUseTransformation();

  /**
   * Sets the value of the '{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelSubclause#getUseTransformation <em>Use Transformation</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Use Transformation</em>' reference.
   * @see #getUseTransformation()
   * @generated
   */
  void setUseTransformation(TypeTransformationSet value);

  /**
   * Returns the value of the '<em><b>Events</b></em>' containment reference list.
   * The list contents are of type {@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorEvent}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Events</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Events</em>' containment reference list.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getErrorModelSubclause_Events()
   * @model containment="true"
   * @generated
   */
  EList<ErrorBehaviorEvent> getEvents();

  /**
   * Returns the value of the '<em><b>Transitions</b></em>' containment reference list.
   * The list contents are of type {@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorTransition}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Transitions</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Transitions</em>' containment reference list.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getErrorModelSubclause_Transitions()
   * @model containment="true"
   * @generated
   */
  EList<ErrorBehaviorTransition> getTransitions();

  /**
   * Returns the value of the '<em><b>Outgoing Propagation Conditions</b></em>' containment reference list.
   * The list contents are of type {@link org.osate.xtext.aadl2.errormodel.errorModel.OutgoingPropagationCondition}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Outgoing Propagation Conditions</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Outgoing Propagation Conditions</em>' containment reference list.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getErrorModelSubclause_OutgoingPropagationConditions()
   * @model containment="true"
   * @generated
   */
  EList<OutgoingPropagationCondition> getOutgoingPropagationConditions();

  /**
   * Returns the value of the '<em><b>Error Detections</b></em>' containment reference list.
   * The list contents are of type {@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorDetection}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Error Detections</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Error Detections</em>' containment reference list.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getErrorModelSubclause_ErrorDetections()
   * @model containment="true"
   * @generated
   */
  EList<ErrorDetection> getErrorDetections();

  /**
   * Returns the value of the '<em><b>Error State To Mode Mappings</b></em>' containment reference list.
   * The list contents are of type {@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorStateToModeMapping}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Error State To Mode Mappings</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Error State To Mode Mappings</em>' containment reference list.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getErrorModelSubclause_ErrorStateToModeMappings()
   * @model containment="true"
   * @generated
   */
  EList<ErrorStateToModeMapping> getErrorStateToModeMappings();

  /**
   * Returns the value of the '<em><b>States</b></em>' containment reference list.
   * The list contents are of type {@link org.osate.xtext.aadl2.errormodel.errorModel.CompositeState}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>States</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>States</em>' containment reference list.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getErrorModelSubclause_States()
   * @model containment="true"
   * @generated
   */
  EList<CompositeState> getStates();

  /**
   * Returns the value of the '<em><b>Type Transformation Set</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type Transformation Set</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type Transformation Set</em>' reference.
   * @see #setTypeTransformationSet(TypeTransformationSet)
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getErrorModelSubclause_TypeTransformationSet()
   * @model
   * @generated
   */
  TypeTransformationSet getTypeTransformationSet();

  /**
   * Sets the value of the '{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelSubclause#getTypeTransformationSet <em>Type Transformation Set</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type Transformation Set</em>' reference.
   * @see #getTypeTransformationSet()
   * @generated
   */
  void setTypeTransformationSet(TypeTransformationSet value);

  /**
   * Returns the value of the '<em><b>Connection Error Sources</b></em>' containment reference list.
   * The list contents are of type {@link org.osate.xtext.aadl2.errormodel.errorModel.ConnectionErrorSource}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Connection Error Sources</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Connection Error Sources</em>' containment reference list.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getErrorModelSubclause_ConnectionErrorSources()
   * @model containment="true"
   * @generated
   */
  EList<ConnectionErrorSource> getConnectionErrorSources();

  /**
   * Returns the value of the '<em><b>Points</b></em>' containment reference list.
   * The list contents are of type {@link org.osate.xtext.aadl2.errormodel.errorModel.PropagationPoint}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Points</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Points</em>' containment reference list.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getErrorModelSubclause_Points()
   * @model containment="true"
   * @generated
   */
  EList<PropagationPoint> getPoints();

  /**
   * Returns the value of the '<em><b>Connections</b></em>' containment reference list.
   * The list contents are of type {@link org.osate.xtext.aadl2.errormodel.errorModel.PropagationPointConnection}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Connections</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Connections</em>' containment reference list.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getErrorModelSubclause_Connections()
   * @model containment="true"
   * @generated
   */
  EList<PropagationPointConnection> getConnections();

  /**
   * Returns the value of the '<em><b>Properties</b></em>' containment reference list.
   * The list contents are of type {@link org.osate.aadl2.PropertyAssociation}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Properties</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Properties</em>' containment reference list.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getErrorModelSubclause_Properties()
   * @model containment="true"
   * @generated
   */
  EList<PropertyAssociation> getProperties();

} // ErrorModelSubclause
