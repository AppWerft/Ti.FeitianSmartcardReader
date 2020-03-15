// 
// Decompiled by Procyon v0.5.36
// 

package gnu.q2.lang;

import gnu.lists.FString;
import gnu.text.Lexer;
import gnu.kawa.lispexpr.ReaderQuote;
import gnu.kawa.lispexpr.LispLanguage;
import gnu.kawa.lispexpr.ReaderNestedComment;
import gnu.kawa.lispexpr.ReaderIgnoreRestOfLine;
import gnu.kawa.lispexpr.ReaderDispatch;
import gnu.kawa.lispexpr.ReadTable;
import gnu.expr.Language;
import gnu.kawa.lispexpr.LispReader;
import gnu.text.SourceMessages;
import gnu.kawa.io.InPort;
import gnu.mapping.Environment;
import gnu.expr.ModuleBody;
import gnu.mapping.SimpleEnvironment;
import kawa.standard.Scheme;

public class Q2 extends Scheme
{
    static Q2 instance;
    static final Object emptyForm;
    protected static final SimpleEnvironment q2Environment;
    
    public Q2() {
        this.environ = Q2.q2Environment;
        ModuleBody.setMainPrintValues(true);
    }
    
    protected Q2(final Environment env) {
        super(env);
    }
    
    public static Q2 getQ2Instance() {
        if (Q2.instance == null) {
            new Q2();
        }
        return Q2.instance;
    }
    
    public void initQ2() {
        this.defSntxStFld(";", "gnu.q2.lang.Operator", "SEMI");
        this.defSntxStFld("+", "gnu.q2.lang.Operator", "PLUS");
        this.defSntxStFld("-", "gnu.q2.lang.Operator", "MINUS");
        this.defSntxStFld("*", "gnu.q2.lang.Operator", "STAR");
        this.defSntxStFld("/", "gnu.q2.lang.Operator", "SLASH");
        this.defSntxStFld("<", "gnu.q2.lang.Operator", "LT");
        this.defSntxStFld(">", "gnu.q2.lang.Operator", "GT");
        this.defSntxStFld("==", "gnu.q2.lang.Operator", "EQ");
        this.defSntxStFld("<=", "gnu.q2.lang.Operator", "LE");
        this.defSntxStFld(">=", "gnu.q2.lang.Operator", "GE");
        this.defSntxStFld(":=", "gnu.q2.lang.Operator", "ASSIGN");
        this.defSntxStFld("?>", "gnu.q2.lang.Operator", "IF_THEN");
    }
    
    @Override
    public String getName() {
        return "Q2";
    }
    
    @Override
    public LispReader getLexer(final InPort inp, final SourceMessages messages) {
        final Q2Read lexer = new Q2Read(inp, messages);
        return lexer;
    }
    
    @Override
    public String getCompilationClass() {
        return "gnu.q2.lang.Q2Translator";
    }
    
    public static void registerEnvironment() {
        Language.setDefaults(new Q2());
    }
    
    @Override
    public boolean appendBodyValues() {
        return true;
    }
    
    @Override
    public String getPrimaryPrompt() {
        return "#|Q2:%N|# ";
    }
    
    @Override
    public String getSecondaryPrompt() {
        return "#|%P.%N|# ";
    }
    
    @Override
    public ReadTable createReadTable() {
        final ReadTable rt = ReadTable.createInitial();
        rt.set(40, new Q2Read.ReadTableEntry());
        rt.set(59, new Q2Read.ReadTableEntry());
        final ReaderDispatch rdispatch = ReaderDispatch.create(rt, false);
        rt.set(35, rdispatch);
        rdispatch.set(32, ReaderIgnoreRestOfLine.getInstance());
        rdispatch.set(91, new ReaderNestedComment('#', '[', ']', '#'));
        rt.setFinalColonIsKeyword(true);
        rt.postfixLookupOperator = ':';
        rt.set(64, new ReaderQuote(LispLanguage.splice_sym, 6));
        return rt;
    }
    
    public static int compareIndentation(final int indentation1, final int indentation2) {
        final int numTabs1 = indentation1 >>> 16;
        final int numTabs2 = indentation1 >>> 16;
        final int numSpaces1 = indentation1 & 0xFF;
        final int numSpaces2 = indentation2 & 0xFF;
        if (numTabs1 == numTabs2) {
            return numSpaces1 - numSpaces2;
        }
        if ((numTabs1 < numTabs2 && numSpaces1 <= numSpaces2) || (numTabs1 > numTabs2 && numSpaces1 >= numSpaces2)) {
            return 8 * (numTabs1 - numTabs2);
        }
        return Integer.MIN_VALUE;
    }
    
    static {
        emptyForm = new FString();
        q2Environment = Environment.make("q2-environment", Scheme.kawaEnvironment);
        Q2.instance = new Q2();
        final Environment saveEnv = Environment.setSaveCurrent(Q2.q2Environment);
        try {
            Q2.instance.initQ2();
        }
        finally {
            Environment.restoreCurrent(saveEnv);
        }
    }
}
