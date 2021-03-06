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
package org.osate.categories.ui.contentassist.antlr;

import java.util.Collection;
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.RecognitionException;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ui.editor.contentassist.antlr.AbstractContentAssistParser;
import org.eclipse.xtext.ui.editor.contentassist.antlr.FollowElement;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;

import com.google.inject.Inject;

import org.osate.categories.services.CategoriesGrammarAccess;

public class CategoriesParser extends AbstractContentAssistParser {
	
	@Inject
	private CategoriesGrammarAccess grammarAccess;
	
	private Map<AbstractElement, String> nameMappings;
	
	@Override
	protected org.osate.categories.ui.contentassist.antlr.internal.InternalCategoriesParser createParser() {
		org.osate.categories.ui.contentassist.antlr.internal.InternalCategoriesParser result = new org.osate.categories.ui.contentassist.antlr.internal.InternalCategoriesParser(null);
		result.setGrammarAccess(grammarAccess);
		return result;
	}
	
	@Override
	protected String getRuleName(AbstractElement element) {
		if (nameMappings == null) {
			nameMappings = new HashMap<AbstractElement, String>() {
				private static final long serialVersionUID = 1L;
				{
					put(grammarAccess.getCategoriesDefinitionsAccess().getGroup(), "rule__CategoriesDefinitions__Group__0");
					put(grammarAccess.getCategoriesAccess().getGroup(), "rule__Categories__Group__0");
					put(grammarAccess.getCategoryFilterAccess().getGroup(), "rule__CategoryFilter__Group__0");
					put(grammarAccess.getCatRefAccess().getGroup(), "rule__CatRef__Group__0");
					put(grammarAccess.getCategoriesDefinitionsAccess().getCategoriesAssignment_0(), "rule__CategoriesDefinitions__CategoriesAssignment_0");
					put(grammarAccess.getCategoriesDefinitionsAccess().getCategoryFiltersAssignment_1(), "rule__CategoriesDefinitions__CategoryFiltersAssignment_1");
					put(grammarAccess.getCategoriesAccess().getNameAssignment_0(), "rule__Categories__NameAssignment_0");
					put(grammarAccess.getCategoriesAccess().getCategoryAssignment_2(), "rule__Categories__CategoryAssignment_2");
					put(grammarAccess.getCategoryAccess().getNameAssignment(), "rule__Category__NameAssignment");
					put(grammarAccess.getCategoryFilterAccess().getNameAssignment_1(), "rule__CategoryFilter__NameAssignment_1");
					put(grammarAccess.getCategoryFilterAccess().getCategoryAssignment_3(), "rule__CategoryFilter__CategoryAssignment_3");
					put(grammarAccess.getCategoryFilterAccess().getAnyCategoryAssignment_4(), "rule__CategoryFilter__AnyCategoryAssignment_4");
				}
			};
		}
		return nameMappings.get(element);
	}
	
	@Override
	protected Collection<FollowElement> getFollowElements(AbstractInternalContentAssistParser parser) {
		try {
			org.osate.categories.ui.contentassist.antlr.internal.InternalCategoriesParser typedParser = (org.osate.categories.ui.contentassist.antlr.internal.InternalCategoriesParser) parser;
			typedParser.entryRuleCategoriesDefinitions();
			return typedParser.getFollowElements();
		} catch(RecognitionException ex) {
			throw new RuntimeException(ex);
		}		
	}
	
	@Override
	protected String[] getInitialHiddenTokens() {
		return new String[] { "RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT" };
	}
	
	public CategoriesGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}
	
	public void setGrammarAccess(CategoriesGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
}
