
/*
* generated by Xtext
*/
lexer grammar InternalSandboxLexer;


@header {
package org.osate.xtext.aadl2.sandbox.ui.contentassist.antlr.lexer;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.Lexer;
}




KEYWORD_8 : ('I'|'i')('N'|'n')('S'|'s')('T'|'t')('A'|'a')('N'|'n')('C'|'c')('E'|'e');

KEYWORD_7 : ('S'|'s')('A'|'a')('N'|'n')('D'|'d')('B'|'b')('O'|'o')('X'|'x');

KEYWORD_6 : ('S'|'s')('Y'|'y')('S'|'s')('T'|'t')('E'|'e')('M'|'m');

KEYWORD_5 : ('F'|'f')('R'|'r')('O'|'o')('M'|'m');

KEYWORD_3 : ':'':';

KEYWORD_4 : ('T'|'t')('O'|'o');

KEYWORD_1 : '.';

KEYWORD_2 : ';';



RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

RULE_INT : ('0'..'9')+;

RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'u'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'u'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

RULE_WS : (' '|'\t'|'\r'|'\n')+;

RULE_ANY_OTHER : .;



