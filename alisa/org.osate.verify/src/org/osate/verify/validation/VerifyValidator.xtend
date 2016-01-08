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
package org.osate.verify.validation

import com.google.inject.Inject
import java.util.ArrayList
import java.util.List
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.xtext.validation.Check
import org.eclipse.xtext.validation.CheckType
import org.osate.alisa.common.validation.CommonValidator
import org.osate.reqspec.reqSpec.SystemRequirements
import org.osate.verify.util.IVerifyGlobalReferenceFinder
import org.osate.verify.util.VerificationMethodDispatchers
import org.osate.verify.verify.Claim
import org.osate.verify.verify.JavaMethod
import org.osate.verify.verify.PluginMethod
import org.osate.verify.verify.Verification
import org.osate.verify.verify.VerificationActivity
import org.osate.verify.verify.VerificationCondition
import org.osate.verify.verify.VerificationMethodRegistry
import org.osate.verify.verify.VerificationPlan
import org.osate.verify.verify.VerifyPackage

import static org.osate.verify.util.VerifyUtilExtension.*

/**
 * Custom validation rules. 
 * 
 * see http://www.eclipse.org/Xtext/documentation.html#validation
 */
class VerifyValidator extends CommonValidator {

	public static val INCORRECT_METHOD_PATH = "org.osate.verify.incorrectMethodPath"
	public static val INCORRECT_METHOD_REFERENCE = "org.osate.verify.incorrectMethodReference"
	public static val MISSING_METHOD_REFERENCE = "org.osate.verify.missingMethodReference"
	public static val INCORRECT_METHOD_ID = "org.osate.verify.incorrectMethodID"
	public static val CLAIM_MISSING_REQUIREMENT = "org.osate.verify.claimMissingRequirement"
	public static val CLAIM_INVALID_REQUIREMENT = "org.osate.verify.claimInvalidRequirement"
	public static val MISSING_CLAIM_FOR_REQ = "org.osate.verify.missingClaimForReq"
	public static val CLAIM_REQ_FOR_NOT_VP_FOR = "org.osate.verify.claimReqForNotVpFor"
	public static val ILLEGAL_OBJECT_FOR_FILETYPE = "org.osate.verify.illegal.object.for.filetype"

	override protected List<EPackage> getEPackages() {
	    val List<EPackage> result = new ArrayList<EPackage>(super.getEPackages())
	    result.add(VerifyPackage.eINSTANCE)
	    result.add(EPackage.Registry.INSTANCE.getEPackage("http://aadl.info/AADL/2.0"))
		return result
	}
	
	@Inject IVerifyGlobalReferenceFinder verifyGlobalRefFinder

	@Check
	def checkMethodPath(JavaMethod method) {
		val result = VerificationMethodDispatchers.eInstance.methodExists(method)
		if (result != null) {
			warning("Could not find method: " + result, VerifyPackage.Literals.JAVA_METHOD__METHOD_PATH,
				INCORRECT_METHOD_PATH)
		}
	}

	@Check
	def checkMethodID(PluginMethod method) {
		val result = VerificationMethodDispatchers.eInstance.dispatchVerificationMethod(method, null, null)
		if (result == null) {
			warning('Plugin verification method ID not found', VerifyPackage.Literals.PLUGIN_METHOD__METHOD_ID,
				INCORRECT_METHOD_ID)
		}
	}

	@Check
	def checkMethodReference(VerificationCondition cond) {
		if (cond.method == null) {
			warning('Verification precondition or validation should have a verification method reference',
				VerifyPackage.Literals.VERIFICATION_CONDITION__METHOD, MISSING_METHOD_REFERENCE)
		}
	}

	@Check
	def checkMissingMethodReference(VerificationActivity va) {
		if (va.method == null) {
			warning('Verification activity should have a method reference',
				VerifyPackage.Literals.VERIFICATION_ACTIVITY__METHOD, MISSING_METHOD_REFERENCE)
		}
	}

	@Check
	def checkInvalidRequirementForClaim(Claim cl) {
		if (cl.requirement == null) {
			warning('Claim is missing requirement', VerifyPackage.Literals.CLAIM__REQUIREMENT,
				CLAIM_MISSING_REQUIREMENT)
		} else {
			val sysreqs = containingVerificationPlan(cl).requirements
			if (!sysreqs.content.contains(cl.requirement)) {
				error(
					'Requirement ' + cl.requirement.name + ' does not exist in ' + sysreqs.name + '.',
					cl,
					VerifyPackage.Literals.CLAIM__REQUIREMENT,
					CLAIM_INVALID_REQUIREMENT
				)
			}
		}
	}

	@Check(CheckType.NORMAL)
	def checkClaimsForRequirement(VerificationPlan vp) {
		val systemRequirements = vp.requirements
		val requirements = systemRequirements.content
		requirements.forEach [ req |
			if (!vp.claim.exists[claim|claim.requirement === req]) {
				error('No claim for requirement ' + req.name, vp, VerifyPackage.Literals.VERIFICATION_PLAN__NAME,
					MISSING_CLAIM_FOR_REQ, req.name, EcoreUtil.getURI(req).toString())
			}
		]
	}

	@Check(CheckType.FAST)
	def void checkFileTypeContents(Verification verification) {
		val verificationURI = EcoreUtil.getURI(verification)
		val fileExt = verificationURI.fileExtension.toLowerCase
		val contents = verification.contents
		switch fileExt {
			case "verify": {
				contents.forEach [ content |
					switch content {
						VerificationPlan: {
						}
						VerificationMethodRegistry:
							fileTypeError(fileExt, "verification methods", content)
						default:
							fileTypeError(fileExt, content.class.name, content)
					}
				]
			}
			case "methodregistry": {
				contents.forEach [ content |
					switch content {
						VerificationMethodRegistry: {
						}
						VerificationPlan:
							fileTypeError(fileExt, "verification plan", content)
						default:
							fileTypeError(fileExt, content.class.name, content)
					}
				]
			}
			default: {
			}
		}
	}

	// TODO: This method overload calls the quickfix which does not work as expected, commenting out for the immediate future
//	def void fileTypeError(String fileType, String partName, EObject part, URI verificationURI){
//		error( partName +" not allowed in '"+ fileType + "' file.", part, null, ILLEGAL_OBJECT_FOR_FILETYPE, partName, verificationURI.toString())
//	}
	def void fileTypeError(String fileType, String partName, EObject part) {
		warning(partName + " not allowed in '" + fileType + "' file.", part, null)
	}

	@Check(CheckType.NORMAL)
	def void checkVerificationPlanUniqueToComponentClassifier(VerificationPlan vp) {
		val sysReq = vp.requirements
		if (sysReq instanceof SystemRequirements) {
			val vps = verifyGlobalRefFinder.getAllVerificationPlansForRequirements(sysReq, vp)
			if (vps.size > 1) {
				error("Other Verification Plans exist for '" + sysReq.name +
					"'. Only one Verification Plans is allowed for a specific System Requirements.", vp,
					VerifyPackage.Literals.VERIFICATION_PLAN__REQUIREMENTS)
			}
		}
	}

}
