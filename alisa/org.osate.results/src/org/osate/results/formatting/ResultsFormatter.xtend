/*
 * generated by Xtext
 */
package org.osate.results.formatting

import org.eclipse.xtext.formatting.impl.AbstractDeclarativeFormatter
import org.eclipse.xtext.formatting.impl.FormattingConfig
import com.google.inject.Inject
import org.osate.results.services.ResultsGrammarAccess

// import com.google.inject.Inject;
// import org.osate.results.services.ResultsGrammarAccess

/**
 * This class contains custom formatting description.
 * 
 * see : http://www.eclipse.org/Xtext/documentation.html#formatting
 * on how and when to use it 
 * 
 * Also see {@link org.eclipse.xtext.xtext.XtextFormattingTokenSerializer} as an example
 */
class ResultsFormatter extends AbstractDeclarativeFormatter {

	@Inject extension ResultsGrammarAccess
	
	override protected void configureFormatting(FormattingConfig c) {
		c.setAutoLinewrap(120);
		c.setWrappedLineIndentation(2);
		c.setLinewrap(0, 1, 2).before(SL_COMMENTRule)
		c.setLinewrap(0, 1, 2).before(ML_COMMENTRule)
		c.setLinewrap(0, 1, 1).after(ML_COMMENTRule)
		for (pair : findKeywordPairs("[", "]")) {
			c.setIndentationIncrement().after(pair.first);
			c.setLinewrap().after(pair.first);
			c.setIndentationDecrement().before(pair.second);
			c.setLinewrap().before(pair.second);
		}
		c.setLinewrap().after(resultReportRule);
		c.setLinewrap().after(resultReportCollectionRule);
		c.setLinewrap().after(issuesReportRule);
		c.setLinewrap().after(resultContributorRule);
		for (kw : findKeywords("description","heading","data","target","result","issues")) {
			c.setLinewrap().before(kw);
		}
	}
}
