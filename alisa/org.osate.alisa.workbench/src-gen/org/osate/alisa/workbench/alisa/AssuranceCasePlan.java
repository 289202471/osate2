/**
 */
package org.osate.alisa.workbench.alisa;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.osate.aadl2.ComponentImplementation;

import org.osate.alisa.common.common.Description;
import org.osate.alisa.common.common.FinalValue;

import org.osate.verify.verify.VerificationPlan;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Assurance Case Plan</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.osate.alisa.workbench.alisa.AssuranceCasePlan#getName <em>Name</em>}</li>
 *   <li>{@link org.osate.alisa.workbench.alisa.AssuranceCasePlan#getTitle <em>Title</em>}</li>
 *   <li>{@link org.osate.alisa.workbench.alisa.AssuranceCasePlan#getSystem <em>System</em>}</li>
 *   <li>{@link org.osate.alisa.workbench.alisa.AssuranceCasePlan#getDescription <em>Description</em>}</li>
 *   <li>{@link org.osate.alisa.workbench.alisa.AssuranceCasePlan#getConstant <em>Constant</em>}</li>
 *   <li>{@link org.osate.alisa.workbench.alisa.AssuranceCasePlan#getPlans <em>Plans</em>}</li>
 *   <li>{@link org.osate.alisa.workbench.alisa.AssuranceCasePlan#getSelectionFilter <em>Selection Filter</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.osate.alisa.workbench.alisa.AlisaPackage#getAssuranceCasePlan()
 * @model
 * @generated
 */
public interface AssuranceCasePlan extends EObject
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see org.osate.alisa.workbench.alisa.AlisaPackage#getAssuranceCasePlan_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.osate.alisa.workbench.alisa.AssuranceCasePlan#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Title</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Title</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Title</em>' attribute.
   * @see #setTitle(String)
   * @see org.osate.alisa.workbench.alisa.AlisaPackage#getAssuranceCasePlan_Title()
   * @model
   * @generated
   */
  String getTitle();

  /**
   * Sets the value of the '{@link org.osate.alisa.workbench.alisa.AssuranceCasePlan#getTitle <em>Title</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Title</em>' attribute.
   * @see #getTitle()
   * @generated
   */
  void setTitle(String value);

  /**
   * Returns the value of the '<em><b>System</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>System</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>System</em>' reference.
   * @see #setSystem(ComponentImplementation)
   * @see org.osate.alisa.workbench.alisa.AlisaPackage#getAssuranceCasePlan_System()
   * @model
   * @generated
   */
  ComponentImplementation getSystem();

  /**
   * Sets the value of the '{@link org.osate.alisa.workbench.alisa.AssuranceCasePlan#getSystem <em>System</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>System</em>' reference.
   * @see #getSystem()
   * @generated
   */
  void setSystem(ComponentImplementation value);

  /**
   * Returns the value of the '<em><b>Description</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Description</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Description</em>' containment reference.
   * @see #setDescription(Description)
   * @see org.osate.alisa.workbench.alisa.AlisaPackage#getAssuranceCasePlan_Description()
   * @model containment="true"
   * @generated
   */
  Description getDescription();

  /**
   * Sets the value of the '{@link org.osate.alisa.workbench.alisa.AssuranceCasePlan#getDescription <em>Description</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Description</em>' containment reference.
   * @see #getDescription()
   * @generated
   */
  void setDescription(Description value);

  /**
   * Returns the value of the '<em><b>Constant</b></em>' containment reference list.
   * The list contents are of type {@link org.osate.alisa.common.common.FinalValue}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Constant</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Constant</em>' containment reference list.
   * @see org.osate.alisa.workbench.alisa.AlisaPackage#getAssuranceCasePlan_Constant()
   * @model containment="true"
   * @generated
   */
  EList<FinalValue> getConstant();

  /**
   * Returns the value of the '<em><b>Plans</b></em>' reference list.
   * The list contents are of type {@link org.osate.verify.verify.VerificationPlan}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Plans</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Plans</em>' reference list.
   * @see org.osate.alisa.workbench.alisa.AlisaPackage#getAssuranceCasePlan_Plans()
   * @model
   * @generated
   */
  EList<VerificationPlan> getPlans();

  /**
   * Returns the value of the '<em><b>Selection Filter</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Selection Filter</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Selection Filter</em>' containment reference.
   * @see #setSelectionFilter(SelectionConditionExpr)
   * @see org.osate.alisa.workbench.alisa.AlisaPackage#getAssuranceCasePlan_SelectionFilter()
   * @model containment="true"
   * @generated
   */
  SelectionConditionExpr getSelectionFilter();

  /**
   * Sets the value of the '{@link org.osate.alisa.workbench.alisa.AssuranceCasePlan#getSelectionFilter <em>Selection Filter</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Selection Filter</em>' containment reference.
   * @see #getSelectionFilter()
   * @generated
   */
  void setSelectionFilter(SelectionConditionExpr value);

} // AssuranceCasePlan