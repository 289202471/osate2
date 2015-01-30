package org.osate.organization.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.osate.organization.services.OrganizationGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalOrganizationParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'organization'", "'stakeholder'", "'['", "'title'", "'description'", "'role'", "'email'", "'phone'", "']'"
    };
    public static final int T__19=19;
    public static final int RULE_ID=4;
    public static final int RULE_STRING=5;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_INT=6;
    public static final int RULE_WS=9;
    public static final int RULE_SL_COMMENT=8;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=7;

    // delegates
    // delegators


        public InternalOrganizationParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalOrganizationParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalOrganizationParser.tokenNames; }
    public String getGrammarFileName() { return "../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g"; }



     	private OrganizationGrammarAccess grammarAccess;
     	
        public InternalOrganizationParser(TokenStream input, OrganizationGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Organization";	
       	}
       	
       	@Override
       	protected OrganizationGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleOrganization"
    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:67:1: entryRuleOrganization returns [EObject current=null] : iv_ruleOrganization= ruleOrganization EOF ;
    public final EObject entryRuleOrganization() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOrganization = null;


        try {
            // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:68:2: (iv_ruleOrganization= ruleOrganization EOF )
            // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:69:2: iv_ruleOrganization= ruleOrganization EOF
            {
             newCompositeNode(grammarAccess.getOrganizationRule()); 
            pushFollow(FOLLOW_ruleOrganization_in_entryRuleOrganization75);
            iv_ruleOrganization=ruleOrganization();

            state._fsp--;

             current =iv_ruleOrganization; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleOrganization85); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOrganization"


    // $ANTLR start "ruleOrganization"
    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:76:1: ruleOrganization returns [EObject current=null] : (otherlv_0= 'organization' ( (lv_name_1_0= RULE_ID ) ) ( (lv_stakeholder_2_0= ruleStakeholder ) )+ ) ;
    public final EObject ruleOrganization() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        EObject lv_stakeholder_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:79:28: ( (otherlv_0= 'organization' ( (lv_name_1_0= RULE_ID ) ) ( (lv_stakeholder_2_0= ruleStakeholder ) )+ ) )
            // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:80:1: (otherlv_0= 'organization' ( (lv_name_1_0= RULE_ID ) ) ( (lv_stakeholder_2_0= ruleStakeholder ) )+ )
            {
            // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:80:1: (otherlv_0= 'organization' ( (lv_name_1_0= RULE_ID ) ) ( (lv_stakeholder_2_0= ruleStakeholder ) )+ )
            // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:80:3: otherlv_0= 'organization' ( (lv_name_1_0= RULE_ID ) ) ( (lv_stakeholder_2_0= ruleStakeholder ) )+
            {
            otherlv_0=(Token)match(input,11,FOLLOW_11_in_ruleOrganization122); 

                	newLeafNode(otherlv_0, grammarAccess.getOrganizationAccess().getOrganizationKeyword_0());
                
            // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:84:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:85:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:85:1: (lv_name_1_0= RULE_ID )
            // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:86:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleOrganization139); 

            			newLeafNode(lv_name_1_0, grammarAccess.getOrganizationAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getOrganizationRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }

            // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:102:2: ( (lv_stakeholder_2_0= ruleStakeholder ) )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==12) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:103:1: (lv_stakeholder_2_0= ruleStakeholder )
            	    {
            	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:103:1: (lv_stakeholder_2_0= ruleStakeholder )
            	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:104:3: lv_stakeholder_2_0= ruleStakeholder
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getOrganizationAccess().getStakeholderStakeholderParserRuleCall_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleStakeholder_in_ruleOrganization165);
            	    lv_stakeholder_2_0=ruleStakeholder();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getOrganizationRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"stakeholder",
            	            		lv_stakeholder_2_0, 
            	            		"Stakeholder");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOrganization"


    // $ANTLR start "entryRuleStakeholder"
    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:128:1: entryRuleStakeholder returns [EObject current=null] : iv_ruleStakeholder= ruleStakeholder EOF ;
    public final EObject entryRuleStakeholder() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStakeholder = null;


        try {
            // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:129:2: (iv_ruleStakeholder= ruleStakeholder EOF )
            // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:130:2: iv_ruleStakeholder= ruleStakeholder EOF
            {
             newCompositeNode(grammarAccess.getStakeholderRule()); 
            pushFollow(FOLLOW_ruleStakeholder_in_entryRuleStakeholder202);
            iv_ruleStakeholder=ruleStakeholder();

            state._fsp--;

             current =iv_ruleStakeholder; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStakeholder212); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStakeholder"


    // $ANTLR start "ruleStakeholder"
    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:137:1: ruleStakeholder returns [EObject current=null] : (otherlv_0= 'stakeholder' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '[' ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'title' ( (lv_title_5_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'description' ( (lv_description_7_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'role' ( (lv_role_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'email' ( (lv_email_11_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'phone' ( (lv_phone_13_0= RULE_STRING ) ) ) ) ) ) )* ) ) ) otherlv_14= ']' )? ) ;
    public final EObject ruleStakeholder() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token lv_title_5_0=null;
        Token otherlv_6=null;
        Token lv_description_7_0=null;
        Token otherlv_8=null;
        Token lv_role_9_0=null;
        Token otherlv_10=null;
        Token lv_email_11_0=null;
        Token otherlv_12=null;
        Token lv_phone_13_0=null;
        Token otherlv_14=null;

         enterRule(); 
            
        try {
            // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:140:28: ( (otherlv_0= 'stakeholder' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '[' ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'title' ( (lv_title_5_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'description' ( (lv_description_7_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'role' ( (lv_role_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'email' ( (lv_email_11_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'phone' ( (lv_phone_13_0= RULE_STRING ) ) ) ) ) ) )* ) ) ) otherlv_14= ']' )? ) )
            // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:141:1: (otherlv_0= 'stakeholder' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '[' ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'title' ( (lv_title_5_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'description' ( (lv_description_7_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'role' ( (lv_role_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'email' ( (lv_email_11_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'phone' ( (lv_phone_13_0= RULE_STRING ) ) ) ) ) ) )* ) ) ) otherlv_14= ']' )? )
            {
            // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:141:1: (otherlv_0= 'stakeholder' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '[' ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'title' ( (lv_title_5_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'description' ( (lv_description_7_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'role' ( (lv_role_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'email' ( (lv_email_11_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'phone' ( (lv_phone_13_0= RULE_STRING ) ) ) ) ) ) )* ) ) ) otherlv_14= ']' )? )
            // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:141:3: otherlv_0= 'stakeholder' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '[' ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'title' ( (lv_title_5_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'description' ( (lv_description_7_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'role' ( (lv_role_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'email' ( (lv_email_11_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'phone' ( (lv_phone_13_0= RULE_STRING ) ) ) ) ) ) )* ) ) ) otherlv_14= ']' )?
            {
            otherlv_0=(Token)match(input,12,FOLLOW_12_in_ruleStakeholder249); 

                	newLeafNode(otherlv_0, grammarAccess.getStakeholderAccess().getStakeholderKeyword_0());
                
            // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:145:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:146:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:146:1: (lv_name_1_0= RULE_ID )
            // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:147:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleStakeholder266); 

            			newLeafNode(lv_name_1_0, grammarAccess.getStakeholderAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getStakeholderRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }

            // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:163:2: (otherlv_2= '[' ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'title' ( (lv_title_5_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'description' ( (lv_description_7_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'role' ( (lv_role_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'email' ( (lv_email_11_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'phone' ( (lv_phone_13_0= RULE_STRING ) ) ) ) ) ) )* ) ) ) otherlv_14= ']' )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==13) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:163:4: otherlv_2= '[' ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'title' ( (lv_title_5_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'description' ( (lv_description_7_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'role' ( (lv_role_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'email' ( (lv_email_11_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'phone' ( (lv_phone_13_0= RULE_STRING ) ) ) ) ) ) )* ) ) ) otherlv_14= ']'
                    {
                    otherlv_2=(Token)match(input,13,FOLLOW_13_in_ruleStakeholder284); 

                        	newLeafNode(otherlv_2, grammarAccess.getStakeholderAccess().getLeftSquareBracketKeyword_2_0());
                        
                    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:167:1: ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'title' ( (lv_title_5_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'description' ( (lv_description_7_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'role' ( (lv_role_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'email' ( (lv_email_11_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'phone' ( (lv_phone_13_0= RULE_STRING ) ) ) ) ) ) )* ) ) )
                    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:169:1: ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'title' ( (lv_title_5_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'description' ( (lv_description_7_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'role' ( (lv_role_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'email' ( (lv_email_11_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'phone' ( (lv_phone_13_0= RULE_STRING ) ) ) ) ) ) )* ) )
                    {
                    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:169:1: ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'title' ( (lv_title_5_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'description' ( (lv_description_7_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'role' ( (lv_role_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'email' ( (lv_email_11_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'phone' ( (lv_phone_13_0= RULE_STRING ) ) ) ) ) ) )* ) )
                    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:170:2: ( ( ({...}? => ( ({...}? => (otherlv_4= 'title' ( (lv_title_5_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'description' ( (lv_description_7_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'role' ( (lv_role_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'email' ( (lv_email_11_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'phone' ( (lv_phone_13_0= RULE_STRING ) ) ) ) ) ) )* )
                    {
                     
                    	  getUnorderedGroupHelper().enter(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1());
                    	
                    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:173:2: ( ( ({...}? => ( ({...}? => (otherlv_4= 'title' ( (lv_title_5_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'description' ( (lv_description_7_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'role' ( (lv_role_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'email' ( (lv_email_11_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'phone' ( (lv_phone_13_0= RULE_STRING ) ) ) ) ) ) )* )
                    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:174:3: ( ({...}? => ( ({...}? => (otherlv_4= 'title' ( (lv_title_5_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'description' ( (lv_description_7_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'role' ( (lv_role_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'email' ( (lv_email_11_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'phone' ( (lv_phone_13_0= RULE_STRING ) ) ) ) ) ) )*
                    {
                    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:174:3: ( ({...}? => ( ({...}? => (otherlv_4= 'title' ( (lv_title_5_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'description' ( (lv_description_7_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'role' ( (lv_role_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'email' ( (lv_email_11_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'phone' ( (lv_phone_13_0= RULE_STRING ) ) ) ) ) ) )*
                    loop2:
                    do {
                        int alt2=6;
                        int LA2_0 = input.LA(1);

                        if ( LA2_0 ==14 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1(), 0) ) {
                            alt2=1;
                        }
                        else if ( LA2_0 ==15 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1(), 1) ) {
                            alt2=2;
                        }
                        else if ( LA2_0 ==16 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1(), 2) ) {
                            alt2=3;
                        }
                        else if ( LA2_0 ==17 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1(), 3) ) {
                            alt2=4;
                        }
                        else if ( LA2_0 ==18 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1(), 4) ) {
                            alt2=5;
                        }


                        switch (alt2) {
                    	case 1 :
                    	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:176:4: ({...}? => ( ({...}? => (otherlv_4= 'title' ( (lv_title_5_0= RULE_STRING ) ) ) ) ) )
                    	    {
                    	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:176:4: ({...}? => ( ({...}? => (otherlv_4= 'title' ( (lv_title_5_0= RULE_STRING ) ) ) ) ) )
                    	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:177:5: {...}? => ( ({...}? => (otherlv_4= 'title' ( (lv_title_5_0= RULE_STRING ) ) ) ) )
                    	    {
                    	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1(), 0) ) {
                    	        throw new FailedPredicateException(input, "ruleStakeholder", "getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1(), 0)");
                    	    }
                    	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:177:110: ( ({...}? => (otherlv_4= 'title' ( (lv_title_5_0= RULE_STRING ) ) ) ) )
                    	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:178:6: ({...}? => (otherlv_4= 'title' ( (lv_title_5_0= RULE_STRING ) ) ) )
                    	    {
                    	     
                    	    	 				  getUnorderedGroupHelper().select(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1(), 0);
                    	    	 				
                    	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:181:6: ({...}? => (otherlv_4= 'title' ( (lv_title_5_0= RULE_STRING ) ) ) )
                    	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:181:7: {...}? => (otherlv_4= 'title' ( (lv_title_5_0= RULE_STRING ) ) )
                    	    {
                    	    if ( !((true)) ) {
                    	        throw new FailedPredicateException(input, "ruleStakeholder", "true");
                    	    }
                    	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:181:16: (otherlv_4= 'title' ( (lv_title_5_0= RULE_STRING ) ) )
                    	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:181:18: otherlv_4= 'title' ( (lv_title_5_0= RULE_STRING ) )
                    	    {
                    	    otherlv_4=(Token)match(input,14,FOLLOW_14_in_ruleStakeholder342); 

                    	        	newLeafNode(otherlv_4, grammarAccess.getStakeholderAccess().getTitleKeyword_2_1_0_0());
                    	        
                    	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:185:1: ( (lv_title_5_0= RULE_STRING ) )
                    	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:186:1: (lv_title_5_0= RULE_STRING )
                    	    {
                    	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:186:1: (lv_title_5_0= RULE_STRING )
                    	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:187:3: lv_title_5_0= RULE_STRING
                    	    {
                    	    lv_title_5_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleStakeholder359); 

                    	    			newLeafNode(lv_title_5_0, grammarAccess.getStakeholderAccess().getTitleSTRINGTerminalRuleCall_2_1_0_1_0()); 
                    	    		

                    	    	        if (current==null) {
                    	    	            current = createModelElement(grammarAccess.getStakeholderRule());
                    	    	        }
                    	           		setWithLastConsumed(
                    	           			current, 
                    	           			"title",
                    	            		lv_title_5_0, 
                    	            		"STRING");
                    	    	    

                    	    }


                    	    }


                    	    }


                    	    }

                    	     
                    	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1());
                    	    	 				

                    	    }


                    	    }


                    	    }
                    	    break;
                    	case 2 :
                    	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:210:4: ({...}? => ( ({...}? => (otherlv_6= 'description' ( (lv_description_7_0= RULE_STRING ) ) ) ) ) )
                    	    {
                    	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:210:4: ({...}? => ( ({...}? => (otherlv_6= 'description' ( (lv_description_7_0= RULE_STRING ) ) ) ) ) )
                    	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:211:5: {...}? => ( ({...}? => (otherlv_6= 'description' ( (lv_description_7_0= RULE_STRING ) ) ) ) )
                    	    {
                    	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1(), 1) ) {
                    	        throw new FailedPredicateException(input, "ruleStakeholder", "getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1(), 1)");
                    	    }
                    	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:211:110: ( ({...}? => (otherlv_6= 'description' ( (lv_description_7_0= RULE_STRING ) ) ) ) )
                    	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:212:6: ({...}? => (otherlv_6= 'description' ( (lv_description_7_0= RULE_STRING ) ) ) )
                    	    {
                    	     
                    	    	 				  getUnorderedGroupHelper().select(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1(), 1);
                    	    	 				
                    	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:215:6: ({...}? => (otherlv_6= 'description' ( (lv_description_7_0= RULE_STRING ) ) ) )
                    	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:215:7: {...}? => (otherlv_6= 'description' ( (lv_description_7_0= RULE_STRING ) ) )
                    	    {
                    	    if ( !((true)) ) {
                    	        throw new FailedPredicateException(input, "ruleStakeholder", "true");
                    	    }
                    	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:215:16: (otherlv_6= 'description' ( (lv_description_7_0= RULE_STRING ) ) )
                    	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:215:18: otherlv_6= 'description' ( (lv_description_7_0= RULE_STRING ) )
                    	    {
                    	    otherlv_6=(Token)match(input,15,FOLLOW_15_in_ruleStakeholder432); 

                    	        	newLeafNode(otherlv_6, grammarAccess.getStakeholderAccess().getDescriptionKeyword_2_1_1_0());
                    	        
                    	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:219:1: ( (lv_description_7_0= RULE_STRING ) )
                    	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:220:1: (lv_description_7_0= RULE_STRING )
                    	    {
                    	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:220:1: (lv_description_7_0= RULE_STRING )
                    	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:221:3: lv_description_7_0= RULE_STRING
                    	    {
                    	    lv_description_7_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleStakeholder449); 

                    	    			newLeafNode(lv_description_7_0, grammarAccess.getStakeholderAccess().getDescriptionSTRINGTerminalRuleCall_2_1_1_1_0()); 
                    	    		

                    	    	        if (current==null) {
                    	    	            current = createModelElement(grammarAccess.getStakeholderRule());
                    	    	        }
                    	           		setWithLastConsumed(
                    	           			current, 
                    	           			"description",
                    	            		lv_description_7_0, 
                    	            		"STRING");
                    	    	    

                    	    }


                    	    }


                    	    }


                    	    }

                    	     
                    	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1());
                    	    	 				

                    	    }


                    	    }


                    	    }
                    	    break;
                    	case 3 :
                    	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:244:4: ({...}? => ( ({...}? => (otherlv_8= 'role' ( (lv_role_9_0= RULE_STRING ) ) ) ) ) )
                    	    {
                    	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:244:4: ({...}? => ( ({...}? => (otherlv_8= 'role' ( (lv_role_9_0= RULE_STRING ) ) ) ) ) )
                    	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:245:5: {...}? => ( ({...}? => (otherlv_8= 'role' ( (lv_role_9_0= RULE_STRING ) ) ) ) )
                    	    {
                    	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1(), 2) ) {
                    	        throw new FailedPredicateException(input, "ruleStakeholder", "getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1(), 2)");
                    	    }
                    	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:245:110: ( ({...}? => (otherlv_8= 'role' ( (lv_role_9_0= RULE_STRING ) ) ) ) )
                    	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:246:6: ({...}? => (otherlv_8= 'role' ( (lv_role_9_0= RULE_STRING ) ) ) )
                    	    {
                    	     
                    	    	 				  getUnorderedGroupHelper().select(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1(), 2);
                    	    	 				
                    	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:249:6: ({...}? => (otherlv_8= 'role' ( (lv_role_9_0= RULE_STRING ) ) ) )
                    	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:249:7: {...}? => (otherlv_8= 'role' ( (lv_role_9_0= RULE_STRING ) ) )
                    	    {
                    	    if ( !((true)) ) {
                    	        throw new FailedPredicateException(input, "ruleStakeholder", "true");
                    	    }
                    	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:249:16: (otherlv_8= 'role' ( (lv_role_9_0= RULE_STRING ) ) )
                    	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:249:18: otherlv_8= 'role' ( (lv_role_9_0= RULE_STRING ) )
                    	    {
                    	    otherlv_8=(Token)match(input,16,FOLLOW_16_in_ruleStakeholder522); 

                    	        	newLeafNode(otherlv_8, grammarAccess.getStakeholderAccess().getRoleKeyword_2_1_2_0());
                    	        
                    	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:253:1: ( (lv_role_9_0= RULE_STRING ) )
                    	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:254:1: (lv_role_9_0= RULE_STRING )
                    	    {
                    	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:254:1: (lv_role_9_0= RULE_STRING )
                    	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:255:3: lv_role_9_0= RULE_STRING
                    	    {
                    	    lv_role_9_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleStakeholder539); 

                    	    			newLeafNode(lv_role_9_0, grammarAccess.getStakeholderAccess().getRoleSTRINGTerminalRuleCall_2_1_2_1_0()); 
                    	    		

                    	    	        if (current==null) {
                    	    	            current = createModelElement(grammarAccess.getStakeholderRule());
                    	    	        }
                    	           		setWithLastConsumed(
                    	           			current, 
                    	           			"role",
                    	            		lv_role_9_0, 
                    	            		"STRING");
                    	    	    

                    	    }


                    	    }


                    	    }


                    	    }

                    	     
                    	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1());
                    	    	 				

                    	    }


                    	    }


                    	    }
                    	    break;
                    	case 4 :
                    	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:278:4: ({...}? => ( ({...}? => (otherlv_10= 'email' ( (lv_email_11_0= RULE_STRING ) ) ) ) ) )
                    	    {
                    	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:278:4: ({...}? => ( ({...}? => (otherlv_10= 'email' ( (lv_email_11_0= RULE_STRING ) ) ) ) ) )
                    	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:279:5: {...}? => ( ({...}? => (otherlv_10= 'email' ( (lv_email_11_0= RULE_STRING ) ) ) ) )
                    	    {
                    	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1(), 3) ) {
                    	        throw new FailedPredicateException(input, "ruleStakeholder", "getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1(), 3)");
                    	    }
                    	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:279:110: ( ({...}? => (otherlv_10= 'email' ( (lv_email_11_0= RULE_STRING ) ) ) ) )
                    	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:280:6: ({...}? => (otherlv_10= 'email' ( (lv_email_11_0= RULE_STRING ) ) ) )
                    	    {
                    	     
                    	    	 				  getUnorderedGroupHelper().select(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1(), 3);
                    	    	 				
                    	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:283:6: ({...}? => (otherlv_10= 'email' ( (lv_email_11_0= RULE_STRING ) ) ) )
                    	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:283:7: {...}? => (otherlv_10= 'email' ( (lv_email_11_0= RULE_STRING ) ) )
                    	    {
                    	    if ( !((true)) ) {
                    	        throw new FailedPredicateException(input, "ruleStakeholder", "true");
                    	    }
                    	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:283:16: (otherlv_10= 'email' ( (lv_email_11_0= RULE_STRING ) ) )
                    	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:283:18: otherlv_10= 'email' ( (lv_email_11_0= RULE_STRING ) )
                    	    {
                    	    otherlv_10=(Token)match(input,17,FOLLOW_17_in_ruleStakeholder612); 

                    	        	newLeafNode(otherlv_10, grammarAccess.getStakeholderAccess().getEmailKeyword_2_1_3_0());
                    	        
                    	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:287:1: ( (lv_email_11_0= RULE_STRING ) )
                    	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:288:1: (lv_email_11_0= RULE_STRING )
                    	    {
                    	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:288:1: (lv_email_11_0= RULE_STRING )
                    	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:289:3: lv_email_11_0= RULE_STRING
                    	    {
                    	    lv_email_11_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleStakeholder629); 

                    	    			newLeafNode(lv_email_11_0, grammarAccess.getStakeholderAccess().getEmailSTRINGTerminalRuleCall_2_1_3_1_0()); 
                    	    		

                    	    	        if (current==null) {
                    	    	            current = createModelElement(grammarAccess.getStakeholderRule());
                    	    	        }
                    	           		setWithLastConsumed(
                    	           			current, 
                    	           			"email",
                    	            		lv_email_11_0, 
                    	            		"STRING");
                    	    	    

                    	    }


                    	    }


                    	    }


                    	    }

                    	     
                    	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1());
                    	    	 				

                    	    }


                    	    }


                    	    }
                    	    break;
                    	case 5 :
                    	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:312:4: ({...}? => ( ({...}? => (otherlv_12= 'phone' ( (lv_phone_13_0= RULE_STRING ) ) ) ) ) )
                    	    {
                    	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:312:4: ({...}? => ( ({...}? => (otherlv_12= 'phone' ( (lv_phone_13_0= RULE_STRING ) ) ) ) ) )
                    	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:313:5: {...}? => ( ({...}? => (otherlv_12= 'phone' ( (lv_phone_13_0= RULE_STRING ) ) ) ) )
                    	    {
                    	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1(), 4) ) {
                    	        throw new FailedPredicateException(input, "ruleStakeholder", "getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1(), 4)");
                    	    }
                    	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:313:110: ( ({...}? => (otherlv_12= 'phone' ( (lv_phone_13_0= RULE_STRING ) ) ) ) )
                    	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:314:6: ({...}? => (otherlv_12= 'phone' ( (lv_phone_13_0= RULE_STRING ) ) ) )
                    	    {
                    	     
                    	    	 				  getUnorderedGroupHelper().select(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1(), 4);
                    	    	 				
                    	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:317:6: ({...}? => (otherlv_12= 'phone' ( (lv_phone_13_0= RULE_STRING ) ) ) )
                    	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:317:7: {...}? => (otherlv_12= 'phone' ( (lv_phone_13_0= RULE_STRING ) ) )
                    	    {
                    	    if ( !((true)) ) {
                    	        throw new FailedPredicateException(input, "ruleStakeholder", "true");
                    	    }
                    	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:317:16: (otherlv_12= 'phone' ( (lv_phone_13_0= RULE_STRING ) ) )
                    	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:317:18: otherlv_12= 'phone' ( (lv_phone_13_0= RULE_STRING ) )
                    	    {
                    	    otherlv_12=(Token)match(input,18,FOLLOW_18_in_ruleStakeholder702); 

                    	        	newLeafNode(otherlv_12, grammarAccess.getStakeholderAccess().getPhoneKeyword_2_1_4_0());
                    	        
                    	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:321:1: ( (lv_phone_13_0= RULE_STRING ) )
                    	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:322:1: (lv_phone_13_0= RULE_STRING )
                    	    {
                    	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:322:1: (lv_phone_13_0= RULE_STRING )
                    	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:323:3: lv_phone_13_0= RULE_STRING
                    	    {
                    	    lv_phone_13_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleStakeholder719); 

                    	    			newLeafNode(lv_phone_13_0, grammarAccess.getStakeholderAccess().getPhoneSTRINGTerminalRuleCall_2_1_4_1_0()); 
                    	    		

                    	    	        if (current==null) {
                    	    	            current = createModelElement(grammarAccess.getStakeholderRule());
                    	    	        }
                    	           		setWithLastConsumed(
                    	           			current, 
                    	           			"phone",
                    	            		lv_phone_13_0, 
                    	            		"STRING");
                    	    	    

                    	    }


                    	    }


                    	    }


                    	    }

                    	     
                    	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1());
                    	    	 				

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop2;
                        }
                    } while (true);


                    }


                    }

                     
                    	  getUnorderedGroupHelper().leave(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1());
                    	

                    }

                    otherlv_14=(Token)match(input,19,FOLLOW_19_in_ruleStakeholder777); 

                        	newLeafNode(otherlv_14, grammarAccess.getStakeholderAccess().getRightSquareBracketKeyword_2_2());
                        

                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStakeholder"

    // Delegated rules


 

    public static final BitSet FOLLOW_ruleOrganization_in_entryRuleOrganization75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOrganization85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleOrganization122 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleOrganization139 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_ruleStakeholder_in_ruleOrganization165 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_ruleStakeholder_in_entryRuleStakeholder202 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStakeholder212 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_ruleStakeholder249 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleStakeholder266 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_13_in_ruleStakeholder284 = new BitSet(new long[]{0x00000000000FC000L});
    public static final BitSet FOLLOW_14_in_ruleStakeholder342 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleStakeholder359 = new BitSet(new long[]{0x00000000000FC000L});
    public static final BitSet FOLLOW_15_in_ruleStakeholder432 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleStakeholder449 = new BitSet(new long[]{0x00000000000FC000L});
    public static final BitSet FOLLOW_16_in_ruleStakeholder522 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleStakeholder539 = new BitSet(new long[]{0x00000000000FC000L});
    public static final BitSet FOLLOW_17_in_ruleStakeholder612 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleStakeholder629 = new BitSet(new long[]{0x00000000000FC000L});
    public static final BitSet FOLLOW_18_in_ruleStakeholder702 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleStakeholder719 = new BitSet(new long[]{0x00000000000FC000L});
    public static final BitSet FOLLOW_19_in_ruleStakeholder777 = new BitSet(new long[]{0x0000000000000002L});

}