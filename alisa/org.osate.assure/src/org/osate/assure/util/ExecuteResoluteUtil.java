package org.osate.assure.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.osate.aadl2.BooleanLiteral;
import org.osate.aadl2.ComponentCategory;
import org.osate.aadl2.Element;
import org.osate.aadl2.IntegerLiteral;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.RealLiteral;
import org.osate.aadl2.StringLiteral;
import org.osate.aadl2.UnitLiteral;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.result.Diagnostic;
import org.osate.result.util.ResultUtil;

import com.rockwellcollins.atc.resolute.analysis.execution.EvaluationContext;
import com.rockwellcollins.atc.resolute.analysis.execution.FeatureToConnectionsMap;
import com.rockwellcollins.atc.resolute.analysis.execution.NamedElementComparator;
import com.rockwellcollins.atc.resolute.analysis.execution.ResoluteEvaluator;
import com.rockwellcollins.atc.resolute.analysis.execution.ResoluteFailException;
import com.rockwellcollins.atc.resolute.analysis.execution.ResoluteProver;
import com.rockwellcollins.atc.resolute.analysis.results.ClaimResult;
import com.rockwellcollins.atc.resolute.analysis.results.ResoluteResult;
import com.rockwellcollins.atc.resolute.analysis.values.IntValue;
import com.rockwellcollins.atc.resolute.analysis.values.NamedElementValue;
import com.rockwellcollins.atc.resolute.analysis.values.RealValue;
import com.rockwellcollins.atc.resolute.analysis.values.ResoluteValue;
import com.rockwellcollins.atc.resolute.analysis.values.StringValue;
import com.rockwellcollins.atc.resolute.analysis.views.ResoluteResultContentProvider;
import com.rockwellcollins.atc.resolute.resolute.BinaryExpr;
import com.rockwellcollins.atc.resolute.resolute.BoolExpr;
import com.rockwellcollins.atc.resolute.resolute.ClaimArg;
import com.rockwellcollins.atc.resolute.resolute.ClaimString;
import com.rockwellcollins.atc.resolute.resolute.ClaimText;
import com.rockwellcollins.atc.resolute.resolute.ClaimTextVar;
import com.rockwellcollins.atc.resolute.resolute.ConstantDefinition;
import com.rockwellcollins.atc.resolute.resolute.FailExpr;
import com.rockwellcollins.atc.resolute.resolute.FnCallExpr;
import com.rockwellcollins.atc.resolute.resolute.FunctionDefinition;
import com.rockwellcollins.atc.resolute.resolute.IntExpr;
import com.rockwellcollins.atc.resolute.resolute.LetBinding;
import com.rockwellcollins.atc.resolute.resolute.NestedDotID;
import com.rockwellcollins.atc.resolute.resolute.RealExpr;
import com.rockwellcollins.atc.resolute.resolute.ResoluteFactory;
import com.rockwellcollins.atc.resolute.resolute.StringExpr;
import com.rockwellcollins.atc.resolute.resolute.ThisExpr;
import com.rockwellcollins.atc.resolute.validation.BaseType;

public class ExecuteResoluteUtil {
	public static ExecuteResoluteUtil eInstance = new ExecuteResoluteUtil();

	public void tryLoad() throws NoClassDefFoundError {
		// Nothing needed since static initialization of this class already
		// tries to load Resolute
		FunctionDefinition fn = ResoluteFactory.eINSTANCE.createFunctionDefinition();
		fn.setName("dummy");
	}

	/**
	 * interface with Resolute
	 * we initialize the sets on demand. See populate function.
	 * We reset the sets and maps on an evaluation run.
	 */
	private SystemInstance systemroot;
	private Map<String, SortedSet<NamedElement>> sets;
	private FeatureToConnectionsMap featToConnsMap;

	private void initializeResoluteContext(SystemInstance si) {
		if (systemroot != si) {
			systemroot = si;
			sets = new HashMap<String, SortedSet<NamedElement>>();
			initializeSets(systemroot, sets);
			featToConnsMap = new FeatureToConnectionsMap(systemroot);
		}
	}

	private void initializeSets(ComponentInstance ci, Map<String, SortedSet<NamedElement>> sets) {
		if (ci == null) {
			return;
		}

		addToSet(sets, getCategoryName(ci.getCategory()), ci);
		addToSet(sets, "component", ci);

		for (ComponentInstance sub : ci.getComponentInstances()) {
			initializeSets(sub, sets);
		}

		for (ConnectionInstance conn : ci.getConnectionInstances()) {
			addToSet(sets, "connection", conn);
		}
	}

	private String getCategoryName(ComponentCategory category) {
		return new BaseType(category).toString();
	}

	private void addToSet(Map<String, SortedSet<NamedElement>> sets, String name, NamedElement ne) {
		SortedSet<NamedElement> set = sets.get(name);
		if (set == null) {
			set = new TreeSet<NamedElement>(new NamedElementComparator());
			sets.put(name, set);
		}
		set.add(ne);
	}

	public ExecuteResoluteUtil() {
	}

	/**
	 * invokes Resolute claim function on targetComponent or targetElement if not null.
	 * instanceroot is used to initialize the Resolute evaluation context.
	 * targetComponent is the evaluation context
	 * targetElement is the model element within the component instance or null.
	 * parameterObjects is a list of additional parameters of types RealLiteral, IntegerLiteral, StringLiteral, BooleanLiteral
	 * parameterObjects can be null or an empty list.
	 * The return value is an Issue object with subissues for the list of issues returned in the Resolute ClaimResult.
	 * If the proof fails then the top Issue is set to FAIL, if successful it is set to SUCCESS
	 */
	public Diagnostic executeResoluteFunctionOnce(EObject fundef, final SystemInstance instanceroot,
			final ComponentInstance targetComponent, final InstanceObject targetElement,
			List<PropertyExpression> parameterObjects) {
		FunctionDefinition fd = (FunctionDefinition) fundef;
		initializeResoluteContext(instanceroot);
		EvaluationContext context = new EvaluationContext(targetComponent, sets, featToConnsMap);
		// check for claim function
		FnCallExpr fcncall = createWrapperFunctionCall(fd, targetComponent, targetElement, parameterObjects);
		if (fcncall != null) {
			// using com.rockwellcollins.atc.resolute.analysis.results.ClaimResult
			ResoluteProver prover = new ResoluteProver(context) {

				@Override
				protected ResoluteEvaluator createResoluteEvaluator() {
					return new ResoluteEvaluator(context, varStack.peek()) {
						@Override
						public ResoluteValue caseThisExpr(ThisExpr object) {
							// We prepare a thisexpr with either the component instance as context object or a single reference to a model element
							// See createWrapperFunctionCall
							NamedElement curr = context.getThisInstance();
							if (object.getSub() != null) {
								curr = object.getSub().getBase();
							}
							return new NamedElementValue(curr);
						}

						@Override
						public ResoluteValue caseFailExpr(FailExpr object) {
							throw new ResoluteFailException(createFailMsg(object), null);
						}

						private String createFailMsg(FailExpr object) {
							String str = "unknown failure";

							if (object.getVal() instanceof BinaryExpr) {
								BinaryExpr binExpr = (BinaryExpr) object.getVal();
								Object val = doSwitch(binExpr);
								StringValue strVal = (StringValue) val;
								str = strVal.getString();
							}

							if (object.getVal() instanceof StringExpr) {
								StringExpr stringExpr = (StringExpr) object.getVal();
								str = stringExpr.getVal().getValue();
							}

							if (!object.getFailmsg().isEmpty()) {
								str = createClaimText(object.getFailmsg());
							}

							return str.replaceAll("\"", "");
						}

						private String createClaimText(EList<ClaimText> claimBody) {
							StringBuilder text = new StringBuilder();

							for (Element claim : claimBody) {
								if (claim instanceof ClaimArg) {
									ClaimTextVar claimArg = ((ClaimArg) claim).getArg();
									UnitLiteral claimArgUnit = ((ClaimArg) claim).getUnit();
									// text.append("'");
									@SuppressWarnings("unlikely-arg-type")
									ResoluteValue val = varStack.peek().get(claimArg);
									if (val == null) {
										if (claimArg instanceof ConstantDefinition) {
											val = doSwitch(((ConstantDefinition) claimArg).getExpr());
										} else if (claimArg instanceof LetBinding) {
											val = doSwitch(((LetBinding) claimArg).getExpr());
										}
									}
									if (claimArgUnit != null) {
										if (val instanceof IntValue) {
											IntValue ival = (IntValue) val;
											long sval = ival.getScaledInt(claimArgUnit);
											if (sval != 0 && ival.getInt() != 0) {
												val = new IntValue(sval);
											} else {
												val = new RealValue(ival.getScaledIntAsDouble(claimArgUnit));
											}
										} else if (val instanceof RealValue) {
											val = new RealValue(((RealValue) val).getScaledReal(claimArgUnit));
										}
									}
									text.append(val);
									if (claimArgUnit != null) {
										text.append(" " + claimArgUnit.getName());
									}
									// text.append("'");
								} else if (claim instanceof ClaimString) {
									text.append(((ClaimString) claim).getStr());
								} else {
									throw new IllegalArgumentException("Unknown claim type: " + claim.getClass());
								}
							}

							return text.toString();
						}

					};
				}

			};
			try {
				ResoluteResult res = prover.doSwitch(fcncall);
				return doResoluteResults(res);
			} catch (ResoluteFailException e) {
				return ResultUtil.createFailure(e.getMessage(), targetElement);
			}
		} else {
			return ResultUtil.createError("Could not find Resolute Function " + fd.getName(), fd);
		}
	}

	private FnCallExpr createWrapperFunctionCall(FunctionDefinition fd, ComponentInstance evalContext,
			InstanceObject io,
			List<PropertyExpression> params) {
		ResoluteFactory factory = ResoluteFactory.eINSTANCE;
		FnCallExpr call = factory.createFnCallExpr();
		call.setFn(fd);
		call.getArgs().add(createInstanceObjectReference(evalContext, io));
		if (params != null) {
			addParams(call, params);
		}
		return call;
	}

	private ThisExpr createInstanceObjectReference(ComponentInstance evalContext, InstanceObject io) {
		ResoluteFactory factory = ResoluteFactory.eINSTANCE;
		NestedDotID nid = null;
		if (io != null) {
			nid = factory.createNestedDotID();
			nid.setBase(io);
		}
		ThisExpr te = factory.createThisExpr();
		te.setSub(nid);
		return te;
	}

	private void addParams(FnCallExpr call, List<PropertyExpression> params) {
		for (PropertyExpression p : params) {
			if (p instanceof RealLiteral) {
				RealExpr realval = ResoluteFactory.eINSTANCE.createRealExpr();
				realval.setVal((RealLiteral) p);
				call.getArgs().add(realval);
			} else if (p instanceof IntegerLiteral) {
				IntExpr intval = ResoluteFactory.eINSTANCE.createIntExpr();
				intval.setVal((IntegerLiteral) p);
				call.getArgs().add(intval);
			} else if (p instanceof StringLiteral) {
				StringExpr stringval = ResoluteFactory.eINSTANCE.createStringExpr();
				stringval.setVal((StringLiteral) p);
				call.getArgs().add(stringval);
			} else if (p instanceof BooleanLiteral) {
				BoolExpr boolval = ResoluteFactory.eINSTANCE.createBoolExpr();
				boolval.setVal((BooleanLiteral) p);
				call.getArgs().add(boolval);
			}
		}
	}

	static private ResoluteResultContentProvider resoluteContent = new ResoluteResultContentProvider();

	private Diagnostic doResoluteResults(ResoluteResult resRes) {
		Diagnostic ri = null;
		if (resRes instanceof ClaimResult) {
			ClaimResult rr = (ClaimResult) resRes;
			if (rr.isValid()) {
				ri = ResultUtil.createSuccess(rr.getText(), rr.getLocation());
			} else {
				ri = ResultUtil.createFailure(rr.getText(), rr.getLocation());
			}
			Object[] subrrs = resoluteContent.getChildren(rr);
			for (Object subrr : subrrs) {
				ClaimResult subclaim = (ClaimResult) subrr;
				// in the future we may need to create an intermediary Result object
				ri.getIssues().add(doResoluteResults(subclaim));
			}
		}
		return ri;
	}

}