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
		c.setLinewrap(1,2,2).after(systemRequirementSetRule);
		c.setLinewrap(1,2,2).after(systemRequirementRule);
		c.setLinewrap(1,2,2).after(globalRequirementSetRule);
		c.setLinewrap(1,2,2).before(globalRequirementRule);
		c.setLinewrap(1,2,2).before(docRequirementRule);
		c.setLinewrap(1,2,2).before(documentSectionRule);
		c.setLinewrap(1,2,2).before(goalRule);
		c.setLinewrap(1,2,2).before(docGoalRule);
		c.setLinewrap(1,2,2).before(informalPredicateRule);
		c.setLinewrap(1,2,2).before(valuePredicateRule);
		c.setLinewrap(1,2,2).before(uncertaintyRule);
		c.setLinewrap(1,2,2).before(rationaleRule);
		
		for (kw : findKeywords("val", "compute","description","category","property","type","rationale",
		"refines","conflicts","decomposes","mitigates","inherits","evolves","stakeholder","see","issues")) {
			c.setLinewrap().before(kw);
		}
	}
}
