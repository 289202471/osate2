/*******************************************************************************
 * Copyright (c) 2011 SEI (http://www.sei.cmu.edu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.osate.aadl2.modelsupport.util;

import java.io.StringReader;
import java.util.Arrays;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.linking.ILinker;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.parser.IParser;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.impl.ListBasedDiagnosticConsumer;
import org.osate.aadl2.AnnexLibrary;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.PackageSection;

/**
 * Wraps a (partial) Xtext parser in a Osate Annex {@link IParser}.
 * 
 * @author Peter Feiler
 */
public class XtextAnnexParserWrapper  {

	private  ParserRule libraryParserRule;
	private  ParserRule subclauseParserRule;
	private IParser xtextParser;
	
	public XtextAnnexParserWrapper(IParser parser, ParserRule libraryRule, ParserRule subclauseRule){
		this.xtextParser = parser;
		this.libraryParserRule = libraryRule;
		this.subclauseParserRule = subclauseRule;
	}
	
	public EObject parseLibrary(EObject element, String editString, int line, int offset) {
		return parse(element, editString, libraryParserRule, line, offset);
	}
	
	public EObject parseSubclause(EObject element, String editString, int line, int offset) {
		return parse(element, editString, subclauseParserRule, line, offset);
	}

	public EObject parse(EObject element, String editString, ParserRule parserRule, int line, int offset) {
		
		try {
			
			
			final ListBasedDiagnosticConsumer consumer = new ListBasedDiagnosticConsumer();
			// add lines in front to get right offset
//			editString = prependLines(editString, line);
			editString = genWhitespace(offset)+editString;
			IParseResult parseResult = xtextParser.parse(parserRule, new StringReader(editString));
			if (isValidParseResult(parseResult, element)) {
				PackageSection pack = (PackageSection) element.eContainer();
				EList<AnnexLibrary>al = pack.getOwnedAnnexLibraries();
				AnnexLibrary resal = (AnnexLibrary)parseResult.getRootASTElement();
				resal.setName(((NamedElement)element).getName());
				al.add(al.indexOf(element), resal);
				al.remove(element);
//				element.eResource().getContents().add(parseResult.getRootASTElement());
				ILinker linker = ((XtextResource)resal.eResource()).getLinker();
				linker.linkModel(parseResult.getRootASTElement(), consumer);
					resal.eResource().getErrors().addAll(consumer.getResult(Severity.ERROR));
					resal.eResource().getWarnings().addAll(consumer.getResult(Severity.WARNING));
				return resal;
			} else {
				element.eResource().getErrors().addAll(consumer.getResult(Severity.ERROR));
				element.eResource().getWarnings().addAll(consumer.getResult(Severity.WARNING));
				return null;
			}
		} catch (Exception exc) {
			return null;
		}
	}

	private boolean isValidParseResult(IParseResult parseResult, EObject semanticElement) {
		EObject rootASTElement = parseResult.getRootASTElement();
		return !parseResult.hasSyntaxErrors() && rootASTElement != null && semanticElement != null
//				&& semanticElement.eClass() == rootASTElement.eClass()
				;
	}
	
	protected String prependLines(String s, int lines){
		for (int i = 0; i < lines; i++) {
			s = "\n\r"+s;
		}
		return s;
	}
	
	protected String genWhitespace(int length){
		char [] array = new char[length];
		Arrays.fill(array,' ');
		return new String(array);
	}


}
