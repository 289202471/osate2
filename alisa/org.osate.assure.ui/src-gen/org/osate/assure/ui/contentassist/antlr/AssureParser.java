/*
 * generated by Xtext
 */
package org.osate.assure.ui.contentassist.antlr;

import java.util.Collection;
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.RecognitionException;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ui.editor.contentassist.antlr.AbstractContentAssistParser;
import org.eclipse.xtext.ui.editor.contentassist.antlr.FollowElement;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;

import com.google.inject.Inject;

import org.osate.assure.services.AssureGrammarAccess;

public class AssureParser extends AbstractContentAssistParser {
	
	@Inject
	private AssureGrammarAccess grammarAccess;
	
	private Map<AbstractElement, String> nameMappings;
	
	@Override
	protected org.osate.assure.ui.contentassist.antlr.internal.InternalAssureParser createParser() {
		org.osate.assure.ui.contentassist.antlr.internal.InternalAssureParser result = new org.osate.assure.ui.contentassist.antlr.internal.InternalAssureParser(null);
		result.setGrammarAccess(grammarAccess);
		return result;
	}
	
	@Override
	protected String getRuleName(AbstractElement element) {
		if (nameMappings == null) {
			nameMappings = new HashMap<AbstractElement, String>() {
				private static final long serialVersionUID = 1L;
				{
					put(grammarAccess.getAssuranceCaseAccess().getAlternatives_3(), "rule__AssuranceCase__Alternatives_3");
					put(grammarAccess.getConditionResultAccess().getAlternatives_0(), "rule__ConditionResult__Alternatives_0");
					put(grammarAccess.getAssureResultAccess().getAlternatives(), "rule__AssureResult__Alternatives");
					put(grammarAccess.getVerificationExprAccess().getAlternatives(), "rule__VerificationExpr__Alternatives");
					put(grammarAccess.getElseTypeAccess().getAlternatives(), "rule__ElseType__Alternatives");
					put(grammarAccess.getResultIssueTypeAccess().getAlternatives(), "rule__ResultIssueType__Alternatives");
					put(grammarAccess.getVerificationResultStateAccess().getAlternatives(), "rule__VerificationResultState__Alternatives");
					put(grammarAccess.getVerificationExecutionStateAccess().getAlternatives(), "rule__VerificationExecutionState__Alternatives");
					put(grammarAccess.getAssuranceCaseAccess().getGroup(), "rule__AssuranceCase__Group__0");
					put(grammarAccess.getAssuranceCaseAccess().getGroup_3_1(), "rule__AssuranceCase__Group_3_1__0");
					put(grammarAccess.getAssuranceCaseAccess().getGroup_6(), "rule__AssuranceCase__Group_6__0");
					put(grammarAccess.getClaimResultAccess().getGroup(), "rule__ClaimResult__Group__0");
					put(grammarAccess.getClaimResultAccess().getGroup_4(), "rule__ClaimResult__Group_4__0");
					put(grammarAccess.getConditionResultAccess().getGroup(), "rule__ConditionResult__Group__0");
					put(grammarAccess.getConditionResultAccess().getGroup_0_0(), "rule__ConditionResult__Group_0_0__0");
					put(grammarAccess.getConditionResultAccess().getGroup_0_1(), "rule__ConditionResult__Group_0_1__0");
					put(grammarAccess.getConditionResultAccess().getGroup_7(), "rule__ConditionResult__Group_7__0");
					put(grammarAccess.getConditionResultAccess().getGroup_8(), "rule__ConditionResult__Group_8__0");
					put(grammarAccess.getConditionResultAccess().getGroup_10(), "rule__ConditionResult__Group_10__0");
					put(grammarAccess.getVerificationActivityResultAccess().getGroup(), "rule__VerificationActivityResult__Group__0");
					put(grammarAccess.getVerificationActivityResultAccess().getGroup_8(), "rule__VerificationActivityResult__Group_8__0");
					put(grammarAccess.getVerificationActivityResultAccess().getGroup_9(), "rule__VerificationActivityResult__Group_9__0");
					put(grammarAccess.getVerificationActivityResultAccess().getGroup_11(), "rule__VerificationActivityResult__Group_11__0");
					put(grammarAccess.getElseResultAccess().getGroup(), "rule__ElseResult__Group__0");
					put(grammarAccess.getElseResultAccess().getGroup_2(), "rule__ElseResult__Group_2__0");
					put(grammarAccess.getElseResultAccess().getGroup_3(), "rule__ElseResult__Group_3__0");
					put(grammarAccess.getElseResultAccess().getGroup_4(), "rule__ElseResult__Group_4__0");
					put(grammarAccess.getThenResultAccess().getGroup(), "rule__ThenResult__Group__0");
					put(grammarAccess.getMetricsAccess().getGroup(), "rule__Metrics__Group__0");
					put(grammarAccess.getMetricsAccess().getGroup_0(), "rule__Metrics__Group_0__0");
					put(grammarAccess.getMetricsAccess().getGroup_1(), "rule__Metrics__Group_1__0");
					put(grammarAccess.getMetricsAccess().getGroup_2(), "rule__Metrics__Group_2__0");
					put(grammarAccess.getMetricsAccess().getGroup_3(), "rule__Metrics__Group_3__0");
					put(grammarAccess.getMetricsAccess().getGroup_4(), "rule__Metrics__Group_4__0");
					put(grammarAccess.getMetricsAccess().getGroup_5(), "rule__Metrics__Group_5__0");
					put(grammarAccess.getMetricsAccess().getGroup_6(), "rule__Metrics__Group_6__0");
					put(grammarAccess.getMetricsAccess().getGroup_7(), "rule__Metrics__Group_7__0");
					put(grammarAccess.getMetricsAccess().getGroup_8(), "rule__Metrics__Group_8__0");
					put(grammarAccess.getMetricsAccess().getGroup_9(), "rule__Metrics__Group_9__0");
					put(grammarAccess.getResultIssueAccess().getGroup(), "rule__ResultIssue__Group__0");
					put(grammarAccess.getResultIssueAccess().getGroup_1(), "rule__ResultIssue__Group_1__0");
					put(grammarAccess.getResultIssueAccess().getGroup_3(), "rule__ResultIssue__Group_3__0");
					put(grammarAccess.getResultIssueAccess().getGroup_4(), "rule__ResultIssue__Group_4__0");
					put(grammarAccess.getResultIssueAccess().getGroup_5(), "rule__ResultIssue__Group_5__0");
					put(grammarAccess.getAadlClassifierReferenceAccess().getGroup(), "rule__AadlClassifierReference__Group__0");
					put(grammarAccess.getAadlClassifierReferenceAccess().getGroup_1(), "rule__AadlClassifierReference__Group_1__0");
					put(grammarAccess.getAadlClassifierReferenceAccess().getGroup_2(), "rule__AadlClassifierReference__Group_2__0");
					put(grammarAccess.getQualifiedNameAccess().getGroup(), "rule__QualifiedName__Group__0");
					put(grammarAccess.getQualifiedNameAccess().getGroup_1(), "rule__QualifiedName__Group_1__0");
					put(grammarAccess.getAssuranceCaseAccess().getNameAssignment_1(), "rule__AssuranceCase__NameAssignment_1");
					put(grammarAccess.getAssuranceCaseAccess().getTargetAssignment_3_0(), "rule__AssuranceCase__TargetAssignment_3_0");
					put(grammarAccess.getAssuranceCaseAccess().getTargetSystemAssignment_3_1_1(), "rule__AssuranceCase__TargetSystemAssignment_3_1_1");
					put(grammarAccess.getAssuranceCaseAccess().getMetricsAssignment_5(), "rule__AssuranceCase__MetricsAssignment_5");
					put(grammarAccess.getAssuranceCaseAccess().getMessageAssignment_6_1(), "rule__AssuranceCase__MessageAssignment_6_1");
					put(grammarAccess.getAssuranceCaseAccess().getClaimResultAssignment_7(), "rule__AssuranceCase__ClaimResultAssignment_7");
					put(grammarAccess.getAssuranceCaseAccess().getSubAssuranceCaseAssignment_8(), "rule__AssuranceCase__SubAssuranceCaseAssignment_8");
					put(grammarAccess.getClaimResultAccess().getTargetAssignment_1(), "rule__ClaimResult__TargetAssignment_1");
					put(grammarAccess.getClaimResultAccess().getMetricsAssignment_3(), "rule__ClaimResult__MetricsAssignment_3");
					put(grammarAccess.getClaimResultAccess().getMessageAssignment_4_1(), "rule__ClaimResult__MessageAssignment_4_1");
					put(grammarAccess.getClaimResultAccess().getSubClaimResultAssignment_5(), "rule__ClaimResult__SubClaimResultAssignment_5");
					put(grammarAccess.getClaimResultAccess().getVerificationActivityResultAssignment_6(), "rule__ClaimResult__VerificationActivityResultAssignment_6");
					put(grammarAccess.getConditionResultAccess().getTargetAssignment_1(), "rule__ConditionResult__TargetAssignment_1");
					put(grammarAccess.getConditionResultAccess().getExecutionStateAssignment_4(), "rule__ConditionResult__ExecutionStateAssignment_4");
					put(grammarAccess.getConditionResultAccess().getResultStateAssignment_6(), "rule__ConditionResult__ResultStateAssignment_6");
					put(grammarAccess.getConditionResultAccess().getIssuesAssignment_7_2(), "rule__ConditionResult__IssuesAssignment_7_2");
					put(grammarAccess.getConditionResultAccess().getResultReportAssignment_8_1(), "rule__ConditionResult__ResultReportAssignment_8_1");
					put(grammarAccess.getConditionResultAccess().getMetricsAssignment_9(), "rule__ConditionResult__MetricsAssignment_9");
					put(grammarAccess.getConditionResultAccess().getMessageAssignment_10_1(), "rule__ConditionResult__MessageAssignment_10_1");
					put(grammarAccess.getVerificationActivityResultAccess().getTargetAssignment_2(), "rule__VerificationActivityResult__TargetAssignment_2");
					put(grammarAccess.getVerificationActivityResultAccess().getExecutionStateAssignment_5(), "rule__VerificationActivityResult__ExecutionStateAssignment_5");
					put(grammarAccess.getVerificationActivityResultAccess().getResultStateAssignment_7(), "rule__VerificationActivityResult__ResultStateAssignment_7");
					put(grammarAccess.getVerificationActivityResultAccess().getIssuesAssignment_8_2(), "rule__VerificationActivityResult__IssuesAssignment_8_2");
					put(grammarAccess.getVerificationActivityResultAccess().getResultReportAssignment_9_1(), "rule__VerificationActivityResult__ResultReportAssignment_9_1");
					put(grammarAccess.getVerificationActivityResultAccess().getMetricsAssignment_10(), "rule__VerificationActivityResult__MetricsAssignment_10");
					put(grammarAccess.getVerificationActivityResultAccess().getMessageAssignment_11_1(), "rule__VerificationActivityResult__MessageAssignment_11_1");
					put(grammarAccess.getVerificationActivityResultAccess().getConditionResultAssignment_12(), "rule__VerificationActivityResult__ConditionResultAssignment_12");
					put(grammarAccess.getElseResultAccess().getFirstAssignment_1(), "rule__ElseResult__FirstAssignment_1");
					put(grammarAccess.getElseResultAccess().getOtherAssignment_2_1(), "rule__ElseResult__OtherAssignment_2_1");
					put(grammarAccess.getElseResultAccess().getFailAssignment_3_1(), "rule__ElseResult__FailAssignment_3_1");
					put(grammarAccess.getElseResultAccess().getTimeoutAssignment_4_1(), "rule__ElseResult__TimeoutAssignment_4_1");
					put(grammarAccess.getElseResultAccess().getDidFailAssignment_6(), "rule__ElseResult__DidFailAssignment_6");
					put(grammarAccess.getElseResultAccess().getMetricsAssignment_7(), "rule__ElseResult__MetricsAssignment_7");
					put(grammarAccess.getThenResultAccess().getFirstAssignment_1(), "rule__ThenResult__FirstAssignment_1");
					put(grammarAccess.getThenResultAccess().getSecondAssignment_3(), "rule__ThenResult__SecondAssignment_3");
					put(grammarAccess.getThenResultAccess().getDidThenFailAssignment_5(), "rule__ThenResult__DidThenFailAssignment_5");
					put(grammarAccess.getThenResultAccess().getMetricsAssignment_6(), "rule__ThenResult__MetricsAssignment_6");
					put(grammarAccess.getMetricsAccess().getTbdCountAssignment_0_1(), "rule__Metrics__TbdCountAssignment_0_1");
					put(grammarAccess.getMetricsAccess().getSuccessCountAssignment_1_1(), "rule__Metrics__SuccessCountAssignment_1_1");
					put(grammarAccess.getMetricsAccess().getFailCountAssignment_2_1(), "rule__Metrics__FailCountAssignment_2_1");
					put(grammarAccess.getMetricsAccess().getTimeoutCountAssignment_3_1(), "rule__Metrics__TimeoutCountAssignment_3_1");
					put(grammarAccess.getMetricsAccess().getOtherCountAssignment_4_1(), "rule__Metrics__OtherCountAssignment_4_1");
					put(grammarAccess.getMetricsAccess().getDidelseCountAssignment_5_1(), "rule__Metrics__DidelseCountAssignment_5_1");
					put(grammarAccess.getMetricsAccess().getThenskipCountAssignment_6_1(), "rule__Metrics__ThenskipCountAssignment_6_1");
					put(grammarAccess.getMetricsAccess().getPreconditionfailCountAssignment_7_1(), "rule__Metrics__PreconditionfailCountAssignment_7_1");
					put(grammarAccess.getMetricsAccess().getValidationfailCountAssignment_8_1(), "rule__Metrics__ValidationfailCountAssignment_8_1");
					put(grammarAccess.getMetricsAccess().getWeightAssignment_9_1(), "rule__Metrics__WeightAssignment_9_1");
					put(grammarAccess.getResultIssueAccess().getIssueTypeAssignment_0(), "rule__ResultIssue__IssueTypeAssignment_0");
					put(grammarAccess.getResultIssueAccess().getNameAssignment_1_1(), "rule__ResultIssue__NameAssignment_1_1");
					put(grammarAccess.getResultIssueAccess().getMessageAssignment_2(), "rule__ResultIssue__MessageAssignment_2");
					put(grammarAccess.getResultIssueAccess().getExceptionTypeAssignment_3_1(), "rule__ResultIssue__ExceptionTypeAssignment_3_1");
					put(grammarAccess.getResultIssueAccess().getTargetAssignment_4_1(), "rule__ResultIssue__TargetAssignment_4_1");
					put(grammarAccess.getResultIssueAccess().getIssuesAssignment_5_1(), "rule__ResultIssue__IssuesAssignment_5_1");
				}
			};
		}
		return nameMappings.get(element);
	}
	
	@Override
	protected Collection<FollowElement> getFollowElements(AbstractInternalContentAssistParser parser) {
		try {
			org.osate.assure.ui.contentassist.antlr.internal.InternalAssureParser typedParser = (org.osate.assure.ui.contentassist.antlr.internal.InternalAssureParser) parser;
			typedParser.entryRuleAssuranceCase();
			return typedParser.getFollowElements();
		} catch(RecognitionException ex) {
			throw new RuntimeException(ex);
		}		
	}
	
	@Override
	protected String[] getInitialHiddenTokens() {
		return new String[] { "RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT" };
	}
	
	public AssureGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}
	
	public void setGrammarAccess(AssureGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
}
