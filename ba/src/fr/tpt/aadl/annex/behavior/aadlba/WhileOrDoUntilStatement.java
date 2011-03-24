/**
 * AADL-BA-FrontEnd
 * 
 * Copyright © 2011 Télécom ParisTech and CNRS
 * 
 * Télécom ParisTech/LTCI
 * 
 * Authors: see AUTHORS
 * 
 * This program is free software: you can redistribute it and/or modify 
 * it under the terms of the Eclipse Public License as published by Eclipse,
 * either version 1.0 of the License, or (at your option) any later version.
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * Eclipse Public License for more details.
 * You should have received a copy of the Eclipse Public License
 * along with this program.  If not, see 
 * http://www.eclipse.org/org/documents/epl-v10.php
 */

/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package fr.tpt.aadl.annex.behavior.aadlba;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>While Or Do Until Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.WhileOrDoUntilStatement#getLogicalValueExpression <em>Logical Value Expression</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.WhileOrDoUntilStatement#isDoUntil <em>Do Until</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getWhileOrDoUntilStatement()
 * @model
 * @generated
 */
public interface WhileOrDoUntilStatement extends LoopStatement {
	/**
	 * Returns the value of the '<em><b>Logical Value Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Logical Value Expression</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Logical Value Expression</em>' containment reference.
	 * @see #setLogicalValueExpression(ValueExpression)
	 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getWhileOrDoUntilStatement_LogicalValueExpression()
	 * @model containment="true" required="true"
	 * @generated
	 */
	ValueExpression getLogicalValueExpression();

	/**
	 * Sets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.WhileOrDoUntilStatement#getLogicalValueExpression <em>Logical Value Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Logical Value Expression</em>' containment reference.
	 * @see #getLogicalValueExpression()
	 * @generated
	 */
	void setLogicalValueExpression(ValueExpression value);

	/**
	 * Returns the value of the '<em><b>Do Until</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Do Until</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Do Until</em>' attribute.
	 * @see #setDoUntil(boolean)
	 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getWhileOrDoUntilStatement_DoUntil()
	 * @model default="false" dataType="fr.tpt.aadl.annex.behavior.aadlba.Boolean"
	 * @generated
	 */
	boolean isDoUntil();

	/**
	 * Sets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.WhileOrDoUntilStatement#isDoUntil <em>Do Until</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Do Until</em>' attribute.
	 * @see #isDoUntil()
	 * @generated
	 */
	void setDoUntil(boolean value);

} // WhileOrDoUntilStatement
