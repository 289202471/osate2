/**
 */
package org.osate.verify.verify.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.osate.verify.verify.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.osate.verify.verify.VerifyPackage
 * @generated
 */
public class VerifyAdapterFactory extends AdapterFactoryImpl
{
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static VerifyPackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VerifyAdapterFactory()
  {
    if (modelPackage == null)
    {
      modelPackage = VerifyPackage.eINSTANCE;
    }
  }

  /**
   * Returns whether this factory is applicable for the type of the object.
   * <!-- begin-user-doc -->
   * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
   * <!-- end-user-doc -->
   * @return whether this factory is applicable for the type of the object.
   * @generated
   */
  @Override
  public boolean isFactoryForType(Object object)
  {
    if (object == modelPackage)
    {
      return true;
    }
    if (object instanceof EObject)
    {
      return ((EObject)object).eClass().getEPackage() == modelPackage;
    }
    return false;
  }

  /**
   * The switch that delegates to the <code>createXXX</code> methods.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected VerifySwitch<Adapter> modelSwitch =
    new VerifySwitch<Adapter>()
    {
      @Override
      public Adapter caseVerification(Verification object)
      {
        return createVerificationAdapter();
      }
      @Override
      public Adapter caseVerificationPlan(VerificationPlan object)
      {
        return createVerificationPlanAdapter();
      }
      @Override
      public Adapter caseClaim(Claim object)
      {
        return createClaimAdapter();
      }
      @Override
      public Adapter caseArgumentExpr(ArgumentExpr object)
      {
        return createArgumentExprAdapter();
      }
      @Override
      public Adapter caseVerificationActivity(VerificationActivity object)
      {
        return createVerificationActivityAdapter();
      }
      @Override
      public Adapter caseVerificationCondition(VerificationCondition object)
      {
        return createVerificationConditionAdapter();
      }
      @Override
      public Adapter caseVerificationMethodRegistry(VerificationMethodRegistry object)
      {
        return createVerificationMethodRegistryAdapter();
      }
      @Override
      public Adapter caseFormalParameter(FormalParameter object)
      {
        return createFormalParameterAdapter();
      }
      @Override
      public Adapter caseVerificationMethod(VerificationMethod object)
      {
        return createVerificationMethodAdapter();
      }
      @Override
      public Adapter caseMethodType(MethodType object)
      {
        return createMethodTypeAdapter();
      }
      @Override
      public Adapter caseResoluteMethod(ResoluteMethod object)
      {
        return createResoluteMethodAdapter();
      }
      @Override
      public Adapter caseJavaMethod(JavaMethod object)
      {
        return createJavaMethodAdapter();
      }
      @Override
      public Adapter caseManualMethod(ManualMethod object)
      {
        return createManualMethodAdapter();
      }
      @Override
      public Adapter casePluginMethod(PluginMethod object)
      {
        return createPluginMethodAdapter();
      }
      @Override
      public Adapter caseThenExpr(ThenExpr object)
      {
        return createThenExprAdapter();
      }
      @Override
      public Adapter caseElseExpr(ElseExpr object)
      {
        return createElseExprAdapter();
      }
      @Override
      public Adapter caseAllExpr(AllExpr object)
      {
        return createAllExprAdapter();
      }
      @Override
      public Adapter caseRefExpr(RefExpr object)
      {
        return createRefExprAdapter();
      }
      @Override
      public Adapter caseVerificationValidation(VerificationValidation object)
      {
        return createVerificationValidationAdapter();
      }
      @Override
      public Adapter caseVerificationPrecondition(VerificationPrecondition object)
      {
        return createVerificationPreconditionAdapter();
      }
      @Override
      public Adapter defaultCase(EObject object)
      {
        return createEObjectAdapter();
      }
    };

  /**
   * Creates an adapter for the <code>target</code>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param target the object to adapt.
   * @return the adapter for the <code>target</code>.
   * @generated
   */
  @Override
  public Adapter createAdapter(Notifier target)
  {
    return modelSwitch.doSwitch((EObject)target);
  }


  /**
   * Creates a new adapter for an object of class '{@link org.osate.verify.verify.Verification <em>Verification</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.verify.verify.Verification
   * @generated
   */
  public Adapter createVerificationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.verify.verify.VerificationPlan <em>Verification Plan</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.verify.verify.VerificationPlan
   * @generated
   */
  public Adapter createVerificationPlanAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.verify.verify.Claim <em>Claim</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.verify.verify.Claim
   * @generated
   */
  public Adapter createClaimAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.verify.verify.ArgumentExpr <em>Argument Expr</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.verify.verify.ArgumentExpr
   * @generated
   */
  public Adapter createArgumentExprAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.verify.verify.VerificationActivity <em>Verification Activity</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.verify.verify.VerificationActivity
   * @generated
   */
  public Adapter createVerificationActivityAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.verify.verify.VerificationCondition <em>Verification Condition</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.verify.verify.VerificationCondition
   * @generated
   */
  public Adapter createVerificationConditionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.verify.verify.VerificationMethodRegistry <em>Verification Method Registry</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.verify.verify.VerificationMethodRegistry
   * @generated
   */
  public Adapter createVerificationMethodRegistryAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.verify.verify.FormalParameter <em>Formal Parameter</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.verify.verify.FormalParameter
   * @generated
   */
  public Adapter createFormalParameterAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.verify.verify.VerificationMethod <em>Verification Method</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.verify.verify.VerificationMethod
   * @generated
   */
  public Adapter createVerificationMethodAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.verify.verify.MethodType <em>Method Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.verify.verify.MethodType
   * @generated
   */
  public Adapter createMethodTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.verify.verify.ResoluteMethod <em>Resolute Method</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.verify.verify.ResoluteMethod
   * @generated
   */
  public Adapter createResoluteMethodAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.verify.verify.JavaMethod <em>Java Method</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.verify.verify.JavaMethod
   * @generated
   */
  public Adapter createJavaMethodAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.verify.verify.ManualMethod <em>Manual Method</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.verify.verify.ManualMethod
   * @generated
   */
  public Adapter createManualMethodAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.verify.verify.PluginMethod <em>Plugin Method</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.verify.verify.PluginMethod
   * @generated
   */
  public Adapter createPluginMethodAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.verify.verify.ThenExpr <em>Then Expr</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.verify.verify.ThenExpr
   * @generated
   */
  public Adapter createThenExprAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.verify.verify.ElseExpr <em>Else Expr</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.verify.verify.ElseExpr
   * @generated
   */
  public Adapter createElseExprAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.verify.verify.AllExpr <em>All Expr</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.verify.verify.AllExpr
   * @generated
   */
  public Adapter createAllExprAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.verify.verify.RefExpr <em>Ref Expr</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.verify.verify.RefExpr
   * @generated
   */
  public Adapter createRefExprAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.verify.verify.VerificationValidation <em>Verification Validation</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.verify.verify.VerificationValidation
   * @generated
   */
  public Adapter createVerificationValidationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.verify.verify.VerificationPrecondition <em>Verification Precondition</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.verify.verify.VerificationPrecondition
   * @generated
   */
  public Adapter createVerificationPreconditionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for the default case.
   * <!-- begin-user-doc -->
   * This default implementation returns null.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @generated
   */
  public Adapter createEObjectAdapter()
  {
    return null;
  }

} //VerifyAdapterFactory
