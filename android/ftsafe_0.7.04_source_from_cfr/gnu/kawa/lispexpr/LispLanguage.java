/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.lispexpr;

import gnu.bytecode.ClassType;
import gnu.bytecode.Field;
import gnu.bytecode.ObjectType;
import gnu.bytecode.PrimType;
import gnu.bytecode.Type;
import gnu.expr.Compilation;
import gnu.expr.Declaration;
import gnu.expr.Expression;
import gnu.expr.Keyword;
import gnu.expr.Language;
import gnu.expr.ModuleExp;
import gnu.expr.ModuleInfo;
import gnu.expr.QuoteExp;
import gnu.expr.ScopeExp;
import gnu.kawa.io.InPort;
import gnu.kawa.io.TtyInPort;
import gnu.kawa.lispexpr.LangObjType;
import gnu.kawa.lispexpr.LangPrimType;
import gnu.kawa.lispexpr.LispReader;
import gnu.kawa.lispexpr.ReadTable;
import gnu.kawa.reflect.StaticFieldLocation;
import gnu.lists.Sequence;
import gnu.mapping.Environment;
import gnu.mapping.EnvironmentKey;
import gnu.mapping.Namespace;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Symbol;
import gnu.text.Lexer;
import gnu.text.SourceLocator;
import gnu.text.SourceMessages;
import gnu.text.SyntaxException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import kawa.lang.Syntax;
import kawa.lang.Translator;
import kawa.standard.begin;

public abstract class LispLanguage
extends Language {
    public static final String quote_str = "quote";
    public static final String unquote_str = "unquote";
    public static final String unquotesplicing_str = "unquote-splicing";
    public static final String quasiquote_str = "quasiquote";
    public static final Symbol quasiquote_sym = Namespace.EmptyNamespace.getSymbol("quasiquote");
    public static final SimpleSymbol dots3_sym = Symbol.valueOf("...");
    public static final String splice_str = "$splice$";
    public static final Symbol splice_sym = Namespace.EmptyNamespace.getSymbol("$splice$");
    public static final Symbol lookup_sym = Namespace.EmptyNamespace.getSymbol("$lookup$");
    public static final Symbol bracket_list_sym = Namespace.EmptyNamespace.getSymbol("$bracket-list$");
    public static final Symbol bracket_apply_sym = Namespace.EmptyNamespace.getSymbol("$bracket-apply$");
    public static StaticFieldLocation getNamedPartLocation = new StaticFieldLocation("gnu.kawa.functions.GetNamedPart", "getNamedPart");
    public static final Namespace unitNamespace;
    public static final Namespace constructNamespace;
    public static final Namespace entityNamespace;
    protected ReadTable defaultReadTable;
    private HashMap<String, Type> types;
    private HashMap<Type, String> typeToStringMap;

    public abstract ReadTable createReadTable();

    @Override
    public LispReader getLexer(InPort inp, SourceMessages messages) {
        return new LispReader(inp, messages);
    }

    @Override
    public String getCompilationClass() {
        return "kawa.lang.Translator";
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean parse(Compilation comp, int options) throws IOException, SyntaxException {
        InPort in;
        Translator tr = (Translator)comp;
        Lexer lexer = tr.lexer;
        ModuleExp mexp = tr.getModule();
        LispReader reader = (LispReader)lexer;
        Compilation saveComp = Compilation.setSaveCurrent(tr);
        InPort inPort = in = reader == null ? null : reader.getPort();
        if (in instanceof TtyInPort) {
            ((TtyInPort)in).resetAndKeep();
        }
        try {
            if (tr.pendingForm != null) {
                tr.scanForm(tr.pendingForm, mexp);
                tr.pendingForm = null;
            }
            while (reader != null) {
                boolean bl;
                int ch;
                Object sexp = reader.readCommand();
                if (Translator.listLength(sexp) == 2 && Translator.safeCar(sexp) == begin.begin && Translator.safeCar(Translator.safeCdr(sexp)) == Sequence.eofValue && (options & 132) != 0) {
                    bl = false;
                    return bl;
                }
                if (sexp == Sequence.eofValue) {
                    if ((options & 4) == 0) break;
                    bl = false;
                    return bl;
                }
                while ((ch = lexer.read()) == 32 || ch == 9 || ch == 13) {
                }
                if (ch == 41) {
                    lexer.fatal("An unexpected close paren was read.");
                }
                if (ch != 10) {
                    lexer.unread(ch);
                }
                tr.scanForm(sexp, mexp);
                if ((options & 4) != 0) {
                    if (ch >= 0 && ch != 10 && lexer.isInteractive()) continue;
                    break;
                }
                if ((options & 8) == 0 || tr.getState() < 2) continue;
                boolean bl2 = true;
                return bl2;
            }
            tr.finishModule(mexp);
            tr.setState(4);
        }
        finally {
            if (in instanceof TtyInPort) {
                ((TtyInPort)in).setKeepAll(false);
            }
            Compilation.restoreCurrent(saveComp);
        }
        return true;
    }

    @Override
    public void resolve(Compilation comp) {
        ModuleInfo subinfo;
        String mainName;
        Translator tr = (Translator)comp;
        ModuleExp mexp = tr.getModule();
        tr.resolveModule(mexp);
        if (tr.subModuleMap != null && (subinfo = (ModuleInfo)tr.subModuleMap.get(mainName = tr.mainClass.getName())) != null && (mexp.body != QuoteExp.voidExp || mexp.firstDecl() != null)) {
            ModuleExp submodule;
            tr.error('e', "module has both statements and a submodule with the same name: " + tr.mainClass.getName(), (submodule = subinfo.getModuleExpRaw()) != null ? submodule : mexp);
        }
    }

    @Override
    public Declaration declFromField(ModuleExp mod, Object fvalue, Field fld) {
        boolean isFinal;
        Declaration fdecl = super.declFromField(mod, fvalue, fld);
        boolean bl = isFinal = (fld.getModifiers() & 16) != 0;
        if (isFinal && fvalue instanceof Syntax) {
            fdecl.setSyntax();
        }
        return fdecl;
    }

    protected void defSntxStFld(String name, String cname, String fname) {
        Object property = this.hasSeparateFunctionNamespace() ? EnvironmentKey.FUNCTION : null;
        StaticFieldLocation loc = StaticFieldLocation.define(this.environ, this.environ.getSymbol(name), property, cname, fname);
        loc.setSyntax();
    }

    protected void defSntxStFld(String name, String cname) {
        this.defSntxStFld(name, cname, LispLanguage.mangleNameIfNeeded(name));
    }

    public boolean keywordsAreSelfEvaluating() {
        return true;
    }

    public boolean selfEvaluatingSymbol(Object obj) {
        return obj instanceof Keyword;
    }

    public static Symbol langSymbolToSymbol(Object sym) {
        return ((LispLanguage)Language.getDefaultLanguage()).fromLangSymbol(sym);
    }

    protected Symbol fromLangSymbol(Object sym) {
        if (sym instanceof String) {
            return this.getSymbol((String)sym);
        }
        return (Symbol)sym;
    }

    protected synchronized HashMap<String, Type> getTypeMap() {
        if (this.types == null) {
            this.types = new HashMap<K, V>(64);
            this.types.put("void", LangPrimType.voidType);
            this.types.put("int", LangPrimType.intType);
            this.types.put("char", LangPrimType.charType);
            this.types.put("character", LangPrimType.characterType);
            this.types.put("character-or-eof", LangPrimType.characterOrEofType);
            this.types.put("byte", LangPrimType.byteType);
            this.types.put("short", LangPrimType.shortType);
            this.types.put("long", LangPrimType.longType);
            this.types.put("float", LangPrimType.floatType);
            this.types.put("double", LangPrimType.doubleType);
            this.types.put("ubyte", LangPrimType.unsignedByteType);
            this.types.put("ushort", LangPrimType.unsignedShortType);
            this.types.put("uint", LangPrimType.unsignedIntType);
            this.types.put("ulong", LangPrimType.unsignedLongType);
            this.types.put("never-returns", Type.neverReturnsType);
            this.types.put("dynamic", LangObjType.dynamicType);
            this.types.put("Object", Type.objectType);
            this.types.put("String", Type.toStringType);
            this.types.put("object", Type.objectType);
            this.types.put("number", LangObjType.numericType);
            this.types.put("quantity", ClassType.make("gnu.math.Quantity"));
            this.types.put("complex", ClassType.make("gnu.math.Complex"));
            this.types.put("real", LangObjType.realType);
            this.types.put("rational", LangObjType.rationalType);
            this.types.put("integer", LangObjType.integerType);
            this.types.put("symbol", ClassType.make("gnu.mapping.Symbol"));
            this.types.put("simple-symbol", ClassType.make("gnu.mapping.SimpleSymbol"));
            this.types.put("namespace", ClassType.make("gnu.mapping.Namespace"));
            this.types.put("keyword", ClassType.make("gnu.expr.Keyword"));
            this.types.put("pair", ClassType.make("gnu.lists.Pair"));
            this.types.put("pair-with-position", ClassType.make("gnu.lists.PairWithPosition"));
            this.types.put("constant-string", ClassType.make("java.lang.String"));
            this.types.put("abstract-string", ClassType.make("gnu.lists.CharSeq"));
            this.types.put("vector", LangObjType.vectorType);
            this.types.put("string", LangObjType.stringType);
            this.types.put("empty-list", ClassType.make("gnu.lists.EmptyList"));
            this.types.put("sequence", LangObjType.sequenceType);
            this.types.put("list", LangObjType.listType);
            this.types.put("function", ClassType.make("gnu.mapping.Procedure"));
            this.types.put("procedure", LangObjType.procedureType);
            this.types.put("input-port", ClassType.make("gnu.kawa.io.InPort"));
            this.types.put("output-port", ClassType.make("gnu.kawa.io.OutPort"));
            this.types.put("string-output-port", ClassType.make("gnu.kawa.io.CharArrayOutPort"));
            this.types.put("string-input-port", ClassType.make("gnu.kawa.io.CharArrayInPort"));
            this.types.put("record", ClassType.make("kawa.lang.Record"));
            this.types.put("type", LangObjType.typeType);
            this.types.put("class-type", LangObjType.typeClassType);
            this.types.put("class", LangObjType.typeClass);
            this.types.put("promise", LangObjType.promiseType);
            this.types.put("document", ClassType.make("gnu.kawa.xml.KDocument"));
            this.types.put("readtable", ClassType.make("gnu.kawa.lispexpr.ReadTable"));
            this.types.put("string-cursor", LangPrimType.stringCursorType);
        }
        return this.types;
    }

    public Type getPackageStyleType(String name) {
        int colon = name.indexOf(58);
        if (colon > 0) {
            String lang = name.substring(0, colon);
            Language interp = Language.getInstance(lang);
            if (interp == null) {
                throw new RuntimeException("unknown type '" + name + "' - unknown language '" + lang + '\'');
            }
            Type type = interp.getNamedType(name.substring(colon + 1));
            if (type != null) {
                this.types.put(name, type);
            }
            return type;
        }
        return null;
    }

    @Override
    public Type getNamedType(String name) {
        Type type = this.getTypeMap().get(name);
        return type != null ? type : this.getPackageStyleType(name);
    }

    @Override
    public Type getTypeFor(Class clas) {
        String name = clas.getName();
        if (clas.isPrimitive()) {
            return this.getNamedType(name);
        }
        if ("java.lang.String".equals(name)) {
            return Type.toStringType;
        }
        LangObjType t = LangObjType.getInstanceFromClass(name);
        if (t != null) {
            return t;
        }
        return super.getTypeFor(clas);
    }

    @Override
    public String getPrimaryPrompt() {
        return "#|kawa:%N|# ";
    }

    @Override
    public String getSecondaryPrompt() {
        return "#|%P.%N|# ";
    }

    static {
        getNamedPartLocation.setProcedure();
        unitNamespace = Namespace.valueOf("http://kawa.gnu.org/unit", "unit");
        constructNamespace = Namespace.valueOf("http://kawa.gnu.org/construct", "$construct$");
        entityNamespace = Namespace.valueOf("http://kawa.gnu.org/entity", "$entity$");
    }
}

