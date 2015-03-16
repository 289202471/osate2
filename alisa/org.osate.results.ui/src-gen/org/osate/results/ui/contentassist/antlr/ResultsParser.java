/*
* generated by Xtext
*/
package org.osate.results.ui.contentassist.antlr;

import java.util.Collection;
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.RecognitionException;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ui.editor.contentassist.antlr.AbstractContentAssistParser;
import org.eclipse.xtext.ui.editor.contentassist.antlr.FollowElement;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;

import com.google.inject.Inject;

import org.osate.results.services.ResultsGrammarAccess;

public class ResultsParser extends AbstractContentAssistParser {
	
	@Inject
	private ResultsGrammarAccess grammarAccess;
	
	private Map<AbstractElement, String> nameMappings;
	
	@Override
	protected org.osate.results.ui.contentassist.antlr.internal.InternalResultsParser createParser() {
		org.osate.results.ui.contentassist.antlr.internal.InternalResultsParser result = new org.osate.results.ui.contentassist.antlr.internal.InternalResultsParser(null);
		result.setGrammarAccess(grammarAccess);
		return result;
	}
	
	@Override
	protected String getRuleName(AbstractElement element) {
		if (nameMappings == null) {
			nameMappings = new HashMap<AbstractElement, String>() {
				private static final long serialVersionUID = 1L;
				{
					put(grammarAccess.getResultReportsAccess().getAlternatives(), "rule__ResultReports__Alternatives");
					put(grammarAccess.getResultIssueHolderAccess().getAlternatives(), "rule__ResultIssueHolder__Alternatives");
					put(grammarAccess.getReportIssueTypeAccess().getAlternatives(), "rule__ReportIssueType__Alternatives");
					put(grammarAccess.getResultReportCollectionAccess().getGroup(), "rule__ResultReportCollection__Group__0");
					put(grammarAccess.getResultReportCollectionAccess().getGroup_2(), "rule__ResultReportCollection__Group_2__0");
					put(grammarAccess.getResultReportCollectionAccess().getGroup_6(), "rule__ResultReportCollection__Group_6__0");
					put(grammarAccess.getResultReportCollectionAccess().getGroup_8(), "rule__ResultReportCollection__Group_8__0");
					put(grammarAccess.getResultReportAccess().getGroup(), "rule__ResultReport__Group__0");
					put(grammarAccess.getResultReportAccess().getGroup_2(), "rule__ResultReport__Group_2__0");
					put(grammarAccess.getResultReportAccess().getGroup_6(), "rule__ResultReport__Group_6__0");
					put(grammarAccess.getResultReportAccess().getGroup_7(), "rule__ResultReport__Group_7__0");
					put(grammarAccess.getResultReportAccess().getGroup_8(), "rule__ResultReport__Group_8__0");
					put(grammarAccess.getResultReportAccess().getGroup_9(), "rule__ResultReport__Group_9__0");
					put(grammarAccess.getIssuesReportAccess().getGroup(), "rule__IssuesReport__Group__0");
					put(grammarAccess.getIssuesReportAccess().getGroup_2(), "rule__IssuesReport__Group_2__0");
					put(grammarAccess.getIssuesReportAccess().getGroup_6(), "rule__IssuesReport__Group_6__0");
					put(grammarAccess.getResultContributorAccess().getGroup(), "rule__ResultContributor__Group__0");
					put(grammarAccess.getResultContributorAccess().getGroup_5(), "rule__ResultContributor__Group_5__0");
					put(grammarAccess.getReportIssueAccess().getGroup(), "rule__ReportIssue__Group__0");
					put(grammarAccess.getResultDataAccess().getGroup(), "rule__ResultData__Group__0");
					put(grammarAccess.getResultReportCollectionAccess().getNameAssignment_1(), "rule__ResultReportCollection__NameAssignment_1");
					put(grammarAccess.getResultReportCollectionAccess().getTitleAssignment_2_1(), "rule__ResultReportCollection__TitleAssignment_2_1");
					put(grammarAccess.getResultReportCollectionAccess().getTargetAssignment_5(), "rule__ResultReportCollection__TargetAssignment_5");
					put(grammarAccess.getResultReportCollectionAccess().getDecriptionAssignment_6_1(), "rule__ResultReportCollection__DecriptionAssignment_6_1");
					put(grammarAccess.getResultReportCollectionAccess().getContentAssignment_7(), "rule__ResultReportCollection__ContentAssignment_7");
					put(grammarAccess.getResultReportCollectionAccess().getIssuesAssignment_8_1(), "rule__ResultReportCollection__IssuesAssignment_8_1");
					put(grammarAccess.getResultReportAccess().getNameAssignment_1(), "rule__ResultReport__NameAssignment_1");
					put(grammarAccess.getResultReportAccess().getTitleAssignment_2_1(), "rule__ResultReport__TitleAssignment_2_1");
					put(grammarAccess.getResultReportAccess().getTargetAssignment_5(), "rule__ResultReport__TargetAssignment_5");
					put(grammarAccess.getResultReportAccess().getDecriptionAssignment_6_1(), "rule__ResultReport__DecriptionAssignment_6_1");
					put(grammarAccess.getResultReportAccess().getHeadingAssignment_7_1(), "rule__ResultReport__HeadingAssignment_7_1");
					put(grammarAccess.getResultReportAccess().getContentAssignment_7_2(), "rule__ResultReport__ContentAssignment_7_2");
					put(grammarAccess.getResultReportAccess().getResultDataAssignment_8_1(), "rule__ResultReport__ResultDataAssignment_8_1");
					put(grammarAccess.getResultReportAccess().getIssuesAssignment_9_1(), "rule__ResultReport__IssuesAssignment_9_1");
					put(grammarAccess.getIssuesReportAccess().getNameAssignment_1(), "rule__IssuesReport__NameAssignment_1");
					put(grammarAccess.getIssuesReportAccess().getTitleAssignment_2_1(), "rule__IssuesReport__TitleAssignment_2_1");
					put(grammarAccess.getIssuesReportAccess().getTargetAssignment_5(), "rule__IssuesReport__TargetAssignment_5");
					put(grammarAccess.getIssuesReportAccess().getDecriptionAssignment_6_1(), "rule__IssuesReport__DecriptionAssignment_6_1");
					put(grammarAccess.getIssuesReportAccess().getIssuesAssignment_7(), "rule__IssuesReport__IssuesAssignment_7");
					put(grammarAccess.getResultContributorAccess().getContributorAssignment_1(), "rule__ResultContributor__ContributorAssignment_1");
					put(grammarAccess.getResultContributorAccess().getCellAssignment_4(), "rule__ResultContributor__CellAssignment_4");
					put(grammarAccess.getResultContributorAccess().getIssuesAssignment_5_1(), "rule__ResultContributor__IssuesAssignment_5_1");
					put(grammarAccess.getResultContributorAccess().getSubcontributorAssignment_6(), "rule__ResultContributor__SubcontributorAssignment_6");
					put(grammarAccess.getReportIssueAccess().getIssueTypeAssignment_0(), "rule__ReportIssue__IssueTypeAssignment_0");
					put(grammarAccess.getReportIssueAccess().getTitleAssignment_1(), "rule__ReportIssue__TitleAssignment_1");
					put(grammarAccess.getReportIssueAccess().getTargetAssignment_2(), "rule__ReportIssue__TargetAssignment_2");
					put(grammarAccess.getResultDataAccess().getNameAssignment_0(), "rule__ResultData__NameAssignment_0");
					put(grammarAccess.getResultDataAccess().getValueAssignment_2(), "rule__ResultData__ValueAssignment_2");
				}
			};
		}
		return nameMappings.get(element);
	}
	
	@Override
	protected Collection<FollowElement> getFollowElements(AbstractInternalContentAssistParser parser) {
		try {
			org.osate.results.ui.contentassist.antlr.internal.InternalResultsParser typedParser = (org.osate.results.ui.contentassist.antlr.internal.InternalResultsParser) parser;
			typedParser.entryRuleResultReports();
			return typedParser.getFollowElements();
		} catch(RecognitionException ex) {
			throw new RuntimeException(ex);
		}		
	}
	
	@Override
	protected String[] getInitialHiddenTokens() {
		return new String[] { "RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT" };
	}
	
	public ResultsGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}
	
	public void setGrammarAccess(ResultsGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
}
