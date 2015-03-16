package org.osate.results.serializer;

import com.google.inject.Inject;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AbstractElementAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.TokenAlias;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynNavigable;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynTransition;
import org.eclipse.xtext.serializer.sequencer.AbstractSyntacticSequencer;
import org.osate.results.services.ResultsGrammarAccess;

@SuppressWarnings("all")
public class ResultsSyntacticSequencer extends AbstractSyntacticSequencer {

	protected ResultsGrammarAccess grammarAccess;
	protected AbstractElementAlias match_ResultContributor_IssuesKeyword_5_0_q;
	protected AbstractElementAlias match_ResultReportCollection_IssuesKeyword_8_0_q;
	protected AbstractElementAlias match_ResultReport_IssuesKeyword_9_0_q;
	
	@Inject
	protected void init(IGrammarAccess access) {
		grammarAccess = (ResultsGrammarAccess) access;
		match_ResultContributor_IssuesKeyword_5_0_q = new TokenAlias(false, true, grammarAccess.getResultContributorAccess().getIssuesKeyword_5_0());
		match_ResultReportCollection_IssuesKeyword_8_0_q = new TokenAlias(false, true, grammarAccess.getResultReportCollectionAccess().getIssuesKeyword_8_0());
		match_ResultReport_IssuesKeyword_9_0_q = new TokenAlias(false, true, grammarAccess.getResultReportAccess().getIssuesKeyword_9_0());
	}
	
	@Override
	protected String getUnassignedRuleCallToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		return "";
	}
	
	
	@Override
	protected void emitUnassignedTokens(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		if (transition.getAmbiguousSyntaxes().isEmpty()) return;
		List<INode> transitionNodes = collectNodes(fromNode, toNode);
		for (AbstractElementAlias syntax : transition.getAmbiguousSyntaxes()) {
			List<INode> syntaxNodes = getNodesFor(transitionNodes, syntax);
			if(match_ResultContributor_IssuesKeyword_5_0_q.equals(syntax))
				emit_ResultContributor_IssuesKeyword_5_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_ResultReportCollection_IssuesKeyword_8_0_q.equals(syntax))
				emit_ResultReportCollection_IssuesKeyword_8_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_ResultReport_IssuesKeyword_9_0_q.equals(syntax))
				emit_ResultReport_IssuesKeyword_9_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else acceptNodes(getLastNavigableState(), syntaxNodes);
		}
	}

	/**
	 * Syntax:
	 *     'issues'?
	 */
	protected void emit_ResultContributor_IssuesKeyword_5_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     'issues'?
	 */
	protected void emit_ResultReportCollection_IssuesKeyword_8_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     'issues'?
	 */
	protected void emit_ResultReport_IssuesKeyword_9_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
}
