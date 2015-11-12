/*
 * generated by Xtext
 */
grammar InternalResults;

options {
	superClass=AbstractInternalAntlrParser;
	
}

@lexer::header {
package org.osate.results.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

@parser::header {
package org.osate.results.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.osate.results.services.ResultsGrammarAccess;

}

@parser::members {

 	private ResultsGrammarAccess grammarAccess;
 	
    public InternalResultsParser(TokenStream input, ResultsGrammarAccess grammarAccess) {
        this(input);
        this.grammarAccess = grammarAccess;
        registerRules(grammarAccess.getGrammar());
    }
    
    @Override
    protected String getFirstRuleName() {
    	return "ResultReports";	
   	}
   	
   	@Override
   	protected ResultsGrammarAccess getGrammarAccess() {
   		return grammarAccess;
   	}
}

@rulecatch { 
    catch (RecognitionException re) { 
        recover(input,re); 
        appendSkippedTokens();
    } 
}




// Entry rule entryRuleResultReports
entryRuleResultReports returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getResultReportsRule()); }
	 iv_ruleResultReports=ruleResultReports 
	 { $current=$iv_ruleResultReports.current; } 
	 EOF 
;

// Rule ResultReports
ruleResultReports returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(
    { 
        newCompositeNode(grammarAccess.getResultReportsAccess().getResultReportParserRuleCall_0()); 
    }
    this_ResultReport_0=ruleResultReport
    { 
        $current = $this_ResultReport_0.current; 
        afterParserOrEnumRuleCall();
    }

    |
    { 
        newCompositeNode(grammarAccess.getResultReportsAccess().getResultReportCollectionParserRuleCall_1()); 
    }
    this_ResultReportCollection_1=ruleResultReportCollection
    { 
        $current = $this_ResultReportCollection_1.current; 
        afterParserOrEnumRuleCall();
    }

    |
    { 
        newCompositeNode(grammarAccess.getResultReportsAccess().getIssuesReportParserRuleCall_2()); 
    }
    this_IssuesReport_2=ruleIssuesReport
    { 
        $current = $this_IssuesReport_2.current; 
        afterParserOrEnumRuleCall();
    }
)
;





// Entry rule entryRuleResultReportCollection
entryRuleResultReportCollection returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getResultReportCollectionRule()); }
	 iv_ruleResultReportCollection=ruleResultReportCollection 
	 { $current=$iv_ruleResultReportCollection.current; } 
	 EOF 
;

// Rule ResultReportCollection
ruleResultReportCollection returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(	otherlv_0='reports' 
    {
    	newLeafNode(otherlv_0, grammarAccess.getResultReportCollectionAccess().getReportsKeyword_0());
    }
(
(
		lv_name_1_0=RULE_ID
		{
			newLeafNode(lv_name_1_0, grammarAccess.getResultReportCollectionAccess().getNameIDTerminalRuleCall_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getResultReportCollectionRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"name",
        		lv_name_1_0, 
        		"ID");
	    }

)
)(	otherlv_2=':' 
    {
    	newLeafNode(otherlv_2, grammarAccess.getResultReportCollectionAccess().getColonKeyword_2_0());
    }
(
(
		lv_title_3_0=RULE_STRING
		{
			newLeafNode(lv_title_3_0, grammarAccess.getResultReportCollectionAccess().getTitleSTRINGTerminalRuleCall_2_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getResultReportCollectionRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"title",
        		lv_title_3_0, 
        		"STRING");
	    }

)
))?	otherlv_4='[' 
    {
    	newLeafNode(otherlv_4, grammarAccess.getResultReportCollectionAccess().getLeftSquareBracketKeyword_3());
    }
	otherlv_5='target' 
    {
    	newLeafNode(otherlv_5, grammarAccess.getResultReportCollectionAccess().getTargetKeyword_4());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getResultReportCollectionRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getResultReportCollectionAccess().getTargetEObjectCrossReference_5_0()); 
	    }
		ruleURIID		{ 
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_7='description' 
    {
    	newLeafNode(otherlv_7, grammarAccess.getResultReportCollectionAccess().getDescriptionKeyword_6_0());
    }
(
(
		lv_decription_8_0=RULE_STRING
		{
			newLeafNode(lv_decription_8_0, grammarAccess.getResultReportCollectionAccess().getDecriptionSTRINGTerminalRuleCall_6_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getResultReportCollectionRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"decription",
        		lv_decription_8_0, 
        		"STRING");
	    }

)
))?(
(
		{ 
	        newCompositeNode(grammarAccess.getResultReportCollectionAccess().getContentResultReportParserRuleCall_7_0()); 
	    }
		lv_content_9_0=ruleResultReport		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getResultReportCollectionRule());
	        }
       		add(
       			$current, 
       			"content",
        		lv_content_9_0, 
        		"ResultReport");
	        afterParserOrEnumRuleCall();
	    }

)
)*(	otherlv_10='issues' 
    {
    	newLeafNode(otherlv_10, grammarAccess.getResultReportCollectionAccess().getIssuesKeyword_8_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getResultReportCollectionAccess().getIssuesReportIssueParserRuleCall_8_1_0()); 
	    }
		lv_issues_11_0=ruleReportIssue		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getResultReportCollectionRule());
	        }
       		add(
       			$current, 
       			"issues",
        		lv_issues_11_0, 
        		"ReportIssue");
	        afterParserOrEnumRuleCall();
	    }

)
)*)?	otherlv_12=']' 
    {
    	newLeafNode(otherlv_12, grammarAccess.getResultReportCollectionAccess().getRightSquareBracketKeyword_9());
    }
)
;





// Entry rule entryRuleResultReport
entryRuleResultReport returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getResultReportRule()); }
	 iv_ruleResultReport=ruleResultReport 
	 { $current=$iv_ruleResultReport.current; } 
	 EOF 
;

// Rule ResultReport
ruleResultReport returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(	otherlv_0='report' 
    {
    	newLeafNode(otherlv_0, grammarAccess.getResultReportAccess().getReportKeyword_0());
    }
(
(
		lv_name_1_0=RULE_ID
		{
			newLeafNode(lv_name_1_0, grammarAccess.getResultReportAccess().getNameIDTerminalRuleCall_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getResultReportRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"name",
        		lv_name_1_0, 
        		"ID");
	    }

)
)(	otherlv_2=':' 
    {
    	newLeafNode(otherlv_2, grammarAccess.getResultReportAccess().getColonKeyword_2_0());
    }
(
(
		lv_title_3_0=RULE_STRING
		{
			newLeafNode(lv_title_3_0, grammarAccess.getResultReportAccess().getTitleSTRINGTerminalRuleCall_2_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getResultReportRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"title",
        		lv_title_3_0, 
        		"STRING");
	    }

)
))?	otherlv_4='[' 
    {
    	newLeafNode(otherlv_4, grammarAccess.getResultReportAccess().getLeftSquareBracketKeyword_3());
    }
	otherlv_5='target' 
    {
    	newLeafNode(otherlv_5, grammarAccess.getResultReportAccess().getTargetKeyword_4());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getResultReportRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getResultReportAccess().getTargetEObjectCrossReference_5_0()); 
	    }
		ruleURIID		{ 
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_7='description' 
    {
    	newLeafNode(otherlv_7, grammarAccess.getResultReportAccess().getDescriptionKeyword_6_0());
    }
(
(
		lv_decription_8_0=RULE_STRING
		{
			newLeafNode(lv_decription_8_0, grammarAccess.getResultReportAccess().getDecriptionSTRINGTerminalRuleCall_6_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getResultReportRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"decription",
        		lv_decription_8_0, 
        		"STRING");
	    }

)
))?(	otherlv_9='heading' 
    {
    	newLeafNode(otherlv_9, grammarAccess.getResultReportAccess().getHeadingKeyword_7_0());
    }
(
(
		lv_heading_10_0=RULE_STRING
		{
			newLeafNode(lv_heading_10_0, grammarAccess.getResultReportAccess().getHeadingSTRINGTerminalRuleCall_7_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getResultReportRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"heading",
        		lv_heading_10_0, 
        		"STRING");
	    }

)
)(
(
		{ 
	        newCompositeNode(grammarAccess.getResultReportAccess().getContentResultContributorParserRuleCall_7_2_0()); 
	    }
		lv_content_11_0=ruleResultContributor		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getResultReportRule());
	        }
       		add(
       			$current, 
       			"content",
        		lv_content_11_0, 
        		"ResultContributor");
	        afterParserOrEnumRuleCall();
	    }

)
)*)?(	otherlv_12='results' 
    {
    	newLeafNode(otherlv_12, grammarAccess.getResultReportAccess().getResultsKeyword_8_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getResultReportAccess().getResultDataResultDataParserRuleCall_8_1_0()); 
	    }
		lv_resultData_13_0=ruleResultData		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getResultReportRule());
	        }
       		add(
       			$current, 
       			"resultData",
        		lv_resultData_13_0, 
        		"ResultData");
	        afterParserOrEnumRuleCall();
	    }

)
)+)?(	otherlv_14='issues' 
    {
    	newLeafNode(otherlv_14, grammarAccess.getResultReportAccess().getIssuesKeyword_9_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getResultReportAccess().getIssuesReportIssueParserRuleCall_9_1_0()); 
	    }
		lv_issues_15_0=ruleReportIssue		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getResultReportRule());
	        }
       		add(
       			$current, 
       			"issues",
        		lv_issues_15_0, 
        		"ReportIssue");
	        afterParserOrEnumRuleCall();
	    }

)
)*)?	otherlv_16=']' 
    {
    	newLeafNode(otherlv_16, grammarAccess.getResultReportAccess().getRightSquareBracketKeyword_10());
    }
)
;





// Entry rule entryRuleIssuesReport
entryRuleIssuesReport returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getIssuesReportRule()); }
	 iv_ruleIssuesReport=ruleIssuesReport 
	 { $current=$iv_ruleIssuesReport.current; } 
	 EOF 
;

// Rule IssuesReport
ruleIssuesReport returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(	otherlv_0='issues' 
    {
    	newLeafNode(otherlv_0, grammarAccess.getIssuesReportAccess().getIssuesKeyword_0());
    }
(
(
		lv_name_1_0=RULE_ID
		{
			newLeafNode(lv_name_1_0, grammarAccess.getIssuesReportAccess().getNameIDTerminalRuleCall_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getIssuesReportRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"name",
        		lv_name_1_0, 
        		"ID");
	    }

)
)(	otherlv_2=':' 
    {
    	newLeafNode(otherlv_2, grammarAccess.getIssuesReportAccess().getColonKeyword_2_0());
    }
(
(
		lv_title_3_0=RULE_STRING
		{
			newLeafNode(lv_title_3_0, grammarAccess.getIssuesReportAccess().getTitleSTRINGTerminalRuleCall_2_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getIssuesReportRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"title",
        		lv_title_3_0, 
        		"STRING");
	    }

)
))?	otherlv_4='[' 
    {
    	newLeafNode(otherlv_4, grammarAccess.getIssuesReportAccess().getLeftSquareBracketKeyword_3());
    }
	otherlv_5='target' 
    {
    	newLeafNode(otherlv_5, grammarAccess.getIssuesReportAccess().getTargetKeyword_4());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getIssuesReportRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getIssuesReportAccess().getTargetEObjectCrossReference_5_0()); 
	    }
		ruleURIID		{ 
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_7='description' 
    {
    	newLeafNode(otherlv_7, grammarAccess.getIssuesReportAccess().getDescriptionKeyword_6_0());
    }
(
(
		lv_decription_8_0=RULE_STRING
		{
			newLeafNode(lv_decription_8_0, grammarAccess.getIssuesReportAccess().getDecriptionSTRINGTerminalRuleCall_6_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getIssuesReportRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"decription",
        		lv_decription_8_0, 
        		"STRING");
	    }

)
))?(
(
		{ 
	        newCompositeNode(grammarAccess.getIssuesReportAccess().getIssuesReportIssueParserRuleCall_7_0()); 
	    }
		lv_issues_9_0=ruleReportIssue		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getIssuesReportRule());
	        }
       		add(
       			$current, 
       			"issues",
        		lv_issues_9_0, 
        		"ReportIssue");
	        afterParserOrEnumRuleCall();
	    }

)
)*	otherlv_10=']' 
    {
    	newLeafNode(otherlv_10, grammarAccess.getIssuesReportAccess().getRightSquareBracketKeyword_8());
    }
)
;







// Entry rule entryRuleResultContributor
entryRuleResultContributor returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getResultContributorRule()); }
	 iv_ruleResultContributor=ruleResultContributor 
	 { $current=$iv_ruleResultContributor.current; } 
	 EOF 
;

// Rule ResultContributor
ruleResultContributor returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(	otherlv_0='contributor' 
    {
    	newLeafNode(otherlv_0, grammarAccess.getResultContributorAccess().getContributorKeyword_0());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getResultContributorRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getResultContributorAccess().getContributorEObjectCrossReference_1_0()); 
	    }
		ruleURIID		{ 
	        afterParserOrEnumRuleCall();
	    }

)
)	otherlv_2='[' 
    {
    	newLeafNode(otherlv_2, grammarAccess.getResultContributorAccess().getLeftSquareBracketKeyword_2());
    }
	otherlv_3='data' 
    {
    	newLeafNode(otherlv_3, grammarAccess.getResultContributorAccess().getDataKeyword_3());
    }
(
(
		lv_cell_4_0=RULE_STRING
		{
			newLeafNode(lv_cell_4_0, grammarAccess.getResultContributorAccess().getCellSTRINGTerminalRuleCall_4_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getResultContributorRule());
	        }
       		addWithLastConsumed(
       			$current, 
       			"cell",
        		lv_cell_4_0, 
        		"STRING");
	    }

)
)+(	otherlv_5='issues' 
    {
    	newLeafNode(otherlv_5, grammarAccess.getResultContributorAccess().getIssuesKeyword_5_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getResultContributorAccess().getIssuesReportIssueParserRuleCall_5_1_0()); 
	    }
		lv_issues_6_0=ruleReportIssue		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getResultContributorRule());
	        }
       		add(
       			$current, 
       			"issues",
        		lv_issues_6_0, 
        		"ReportIssue");
	        afterParserOrEnumRuleCall();
	    }

)
)*)?(
(
		{ 
	        newCompositeNode(grammarAccess.getResultContributorAccess().getSubcontributorResultContributorParserRuleCall_6_0()); 
	    }
		lv_subcontributor_7_0=ruleResultContributor		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getResultContributorRule());
	        }
       		add(
       			$current, 
       			"subcontributor",
        		lv_subcontributor_7_0, 
        		"ResultContributor");
	        afterParserOrEnumRuleCall();
	    }

)
)*	otherlv_8=']' 
    {
    	newLeafNode(otherlv_8, grammarAccess.getResultContributorAccess().getRightSquareBracketKeyword_7());
    }
)
;





// Entry rule entryRuleReportIssue
entryRuleReportIssue returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getReportIssueRule()); }
	 iv_ruleReportIssue=ruleReportIssue 
	 { $current=$iv_ruleReportIssue.current; } 
	 EOF 
;

// Rule ReportIssue
ruleReportIssue returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
(
		{ 
	        newCompositeNode(grammarAccess.getReportIssueAccess().getIssueTypeReportIssueTypeEnumRuleCall_0_0()); 
	    }
		lv_issueType_0_0=ruleReportIssueType		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getReportIssueRule());
	        }
       		set(
       			$current, 
       			"issueType",
        		lv_issueType_0_0, 
        		"ReportIssueType");
	        afterParserOrEnumRuleCall();
	    }

)
)(
(
		lv_title_1_0=RULE_STRING
		{
			newLeafNode(lv_title_1_0, grammarAccess.getReportIssueAccess().getTitleSTRINGTerminalRuleCall_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getReportIssueRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"title",
        		lv_title_1_0, 
        		"STRING");
	    }

)
)(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getReportIssueRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getReportIssueAccess().getTargetEObjectCrossReference_2_0()); 
	    }
		ruleURIID		{ 
	        afterParserOrEnumRuleCall();
	    }

)
))
;





// Entry rule entryRuleResultData
entryRuleResultData returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getResultDataRule()); }
	 iv_ruleResultData=ruleResultData 
	 { $current=$iv_ruleResultData.current; } 
	 EOF 
;

// Rule ResultData
ruleResultData returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
(
		lv_name_0_0=RULE_ID
		{
			newLeafNode(lv_name_0_0, grammarAccess.getResultDataAccess().getNameIDTerminalRuleCall_0_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getResultDataRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"name",
        		lv_name_0_0, 
        		"ID");
	    }

)
)	otherlv_1='=' 
    {
    	newLeafNode(otherlv_1, grammarAccess.getResultDataAccess().getEqualsSignKeyword_1());
    }
(
(
		lv_value_2_0=RULE_STRING
		{
			newLeafNode(lv_value_2_0, grammarAccess.getResultDataAccess().getValueSTRINGTerminalRuleCall_2_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getResultDataRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"value",
        		lv_value_2_0, 
        		"STRING");
	    }

)
))
;





// Entry rule entryRuleURIID
entryRuleURIID returns [String current=null] 
	:
	{ newCompositeNode(grammarAccess.getURIIDRule()); } 
	 iv_ruleURIID=ruleURIID 
	 { $current=$iv_ruleURIID.current.getText(); }  
	 EOF 
;

// Rule URIID
ruleURIID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
    this_STRING_0=RULE_STRING    {
		$current.merge(this_STRING_0);
    }

    { 
    newLeafNode(this_STRING_0, grammarAccess.getURIIDAccess().getSTRINGTerminalRuleCall()); 
    }

    ;





// Rule ReportIssueType
ruleReportIssueType returns [Enumerator current=null] 
    @init { enterRule(); }
    @after { leaveRule(); }:
((	enumLiteral_0='error' 
	{
        $current = grammarAccess.getReportIssueTypeAccess().getERROREnumLiteralDeclaration_0().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_0, grammarAccess.getReportIssueTypeAccess().getERROREnumLiteralDeclaration_0()); 
    }
)
    |(	enumLiteral_1='warning' 
	{
        $current = grammarAccess.getReportIssueTypeAccess().getWARNINGEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_1, grammarAccess.getReportIssueTypeAccess().getWARNINGEnumLiteralDeclaration_1()); 
    }
)
    |(	enumLiteral_2='info' 
	{
        $current = grammarAccess.getReportIssueTypeAccess().getINFOEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_2, grammarAccess.getReportIssueTypeAccess().getINFOEnumLiteralDeclaration_2()); 
    }
)
    |(	enumLiteral_3='success' 
	{
        $current = grammarAccess.getReportIssueTypeAccess().getSUCCESSEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_3, grammarAccess.getReportIssueTypeAccess().getSUCCESSEnumLiteralDeclaration_3()); 
    }
)
    |(	enumLiteral_4='fail' 
	{
        $current = grammarAccess.getReportIssueTypeAccess().getFAILEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_4, grammarAccess.getReportIssueTypeAccess().getFAILEnumLiteralDeclaration_4()); 
    }
)
    |(	enumLiteral_5='unknown' 
	{
        $current = grammarAccess.getReportIssueTypeAccess().getUNKNOWNEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_5, grammarAccess.getReportIssueTypeAccess().getUNKNOWNEnumLiteralDeclaration_5()); 
    }
));



RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

RULE_INT : ('0'..'9')+;

RULE_STRING : ('"' ('\\' .|~(('\\'|'"')))* '"'|'\'' ('\\' .|~(('\\'|'\'')))* '\'');

RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

RULE_WS : (' '|'\t'|'\r'|'\n')+;

RULE_ANY_OTHER : .;


