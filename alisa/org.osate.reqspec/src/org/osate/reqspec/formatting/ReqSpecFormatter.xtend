/*
 * generated by Xtext
 */
package org.osate.reqspec.formatting

import org.eclipse.xtext.formatting.impl.AbstractDeclarativeFormatter
import org.eclipse.xtext.formatting.impl.FormattingConfig
 import com.google.inject.Inject;
 import org.osate.reqspec.services.ReqSpecGrammarAccess

/**
 * This class contains custom formatting description.
 * 
 * see : http://www.eclipse.org/Xtext/documentation.html#formatting
 * on how and when to use it 
 * 
 * Also see {@link org.eclipse.xtext.xtext.XtextFormattingTokenSerializer} as an example
 */
class ReqSpecFormatter extends AbstractDeclarativeFormatter {

	@Inject extension ReqSpecGrammarAccess
	
	override protected void configureFormatting(FormattingConfig c) {
		c.setAutoLinewrap(120);
		c.setWrappedLineIndentation(2);
		c.setLinewrap(0, 1, 2).before(SL_COMMENTRule)
		c.setLinewrap(0, 1, 2).before(ML_COMMENTRule)
		c.setLinewrap(0, 1, 1).after(ML_COMMENTRule)
	    for ( pair : findKeywordPairs("[", "]")) {
		      c.setIndentationIncrement().after(pair.first);
		      c.setLinewrap().after(pair.first);
		      c.setIndentationDecrement().before(pair.second);
		      c.setLinewrap().before(pair.second);
		    }
		    // top-level objects get newline at end
		c.setLinewrap(1,2,2).after(stakeholderGoalsRule);
		c.setLinewrap(1,2,2).after(reqDocumentRule);
		c.setLinewrap(1,2,2).after(systemRequirementsRule);
//		c.setLinewrap().before(reqSpecFolderRule);
		for (kw : findKeywords("goal","requirement","requirements","folder","section",'constants')) {
			c.setLinewrap().before(kw);
		}
		for (kw : findKeywords("description","assert","rationale",
		"refines","conflicts","mitigates","stakeholder","see")) {
			c.setLinewrap().before(kw);
		}
	}
}
