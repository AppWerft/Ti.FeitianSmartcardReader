/*
 * Decompiled with CFR 0.139.
 */
package gnu.q2.lang;

import gnu.expr.Language;
import gnu.expr.ModuleBody;
import gnu.kawa.io.InPort;
import gnu.kawa.lispexpr.LispLanguage;
import gnu.kawa.lispexpr.LispReader;
import gnu.kawa.lispexpr.ReadTable;
import gnu.kawa.lispexpr.ReaderDispatch;
import gnu.kawa.lispexpr.ReaderIgnoreRestOfLine;
import gnu.kawa.lispexpr.ReaderNestedComment;
import gnu.kawa.lispexpr.ReaderQuote;
import gnu.lists.FString;
import gnu.mapping.Environment;
import gnu.mapping.SimpleEnvironment;
import gnu.mapping.Symbol;
import gnu.q2.lang.Q2Read;
import gnu.text.Lexer;
import gnu.text.SourceMessages;
import kawa.standard.Scheme;

public class Q2
extends Scheme {
    static Q2 instance;
    static final Object emptyForm;
    protected static final SimpleEnvironment q2Environment;

    public Q2() {
        this.environ = q2Environment;
        ModuleBody.setMainPrintValues(true);
    }

    protected Q2(Environment env) {
        super(env);
    }

    public static Q2 getQ2Instance() {
        if (instance == null) {
            new Q2();
        }
        return instance;
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
    public LispReader getLexer(InPort inp, SourceMessages messages) {
        Q2Read lexer = new Q2Read(inp, messages);
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
        ReadTable rt = ReadTable.createInitial();
        rt.set(40, new Q2Read.ReadTableEntry());
        rt.set(59, new Q2Read.ReadTableEntry());
        ReaderDispatch rdispatch = ReaderDispatch.create(rt, false);
        rt.set(35, rdispatch);
        rdispatch.set(32, ReaderIgnoreRestOfLine.getInstance());
        rdispatch.set(91, new ReaderNestedComment('#', '[', ']', '#'));
        rt.setFinalColonIsKeyword(true);
        rt.postfixLookupOperator = (char)58;
        rt.set(64, new ReaderQuote(LispLanguage.splice_sym, 6));
        return rt;
    }

    public static int compareIndentation(int indentation1, int indentation2) {
        int numTabs1 = indentation1 >>> 16;
        int numTabs2 = indentation1 >>> 16;
        int numSpaces1 = indentation1 & 255;
        int numSpaces2 = indentation2 & 255;
        if (numTabs1 == numTabs2) {
            return numSpaces1 - numSpaces2;
        }
        if (numTabs1 < numTabs2 && numSpaces1 <= numSpaces2 || numTabs1 > numTabs2 && numSpaces1 >= numSpaces2) {
            return 8 * (numTabs1 - numTabs2);
        }
        return Integer.MIN_VALUE;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    static {
        emptyForm = new FString();
        q2Environment = Environment.make("q2-environment", Scheme.kawaEnvironment);
        instance = new Q2();
        Environment saveEnv = Environment.setSaveCurrent(q2Environment);
        try {
            instance.initQ2();
        }
        finally {
            Environment.restoreCurrent(saveEnv);
        }
    }
}

