// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.lispexpr;

import gnu.bytecode.ClassType;
import gnu.expr.Keyword;
import gnu.mapping.EnvironmentKey;
import kawa.lang.Syntax;
import gnu.expr.Declaration;
import gnu.bytecode.Field;
import gnu.text.SourceLocator;
import gnu.expr.QuoteExp;
import gnu.expr.ModuleInfo;
import gnu.text.SyntaxException;
import java.io.IOException;
import gnu.expr.ModuleExp;
import gnu.text.Lexer;
import gnu.lists.Sequence;
import kawa.standard.begin;
import gnu.expr.ScopeExp;
import gnu.kawa.io.TtyInPort;
import kawa.lang.Translator;
import gnu.expr.Compilation;
import gnu.text.SourceMessages;
import gnu.kawa.io.InPort;
import gnu.bytecode.Type;
import java.util.HashMap;
import gnu.mapping.Namespace;
import gnu.kawa.reflect.StaticFieldLocation;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Symbol;
import gnu.expr.Language;

public abstract class LispLanguage extends Language
{
    public static final String quote_str = "quote";
    public static final String unquote_str = "unquote";
    public static final String unquotesplicing_str = "unquote-splicing";
    public static final String quasiquote_str = "quasiquote";
    public static final Symbol quasiquote_sym;
    public static final SimpleSymbol dots3_sym;
    public static final String splice_str = "$splice$";
    public static final Symbol splice_sym;
    public static final Symbol lookup_sym;
    public static final Symbol bracket_list_sym;
    public static final Symbol bracket_apply_sym;
    public static StaticFieldLocation getNamedPartLocation;
    public static final Namespace unitNamespace;
    public static final Namespace constructNamespace;
    public static final Namespace entityNamespace;
    protected ReadTable defaultReadTable;
    private HashMap<String, Type> types;
    private HashMap<Type, String> typeToStringMap;
    
    public abstract ReadTable createReadTable();
    
    @Override
    public LispReader getLexer(final InPort inp, final SourceMessages messages) {
        return new LispReader(inp, messages);
    }
    
    @Override
    public String getCompilationClass() {
        return "kawa.lang.Translator";
    }
    
    @Override
    public boolean parse(final Compilation comp, final int options) throws IOException, SyntaxException {
        final Translator tr = (Translator)comp;
        final Lexer lexer = tr.lexer;
        final ModuleExp mexp = tr.getModule();
        final LispReader reader = (LispReader)lexer;
        final Compilation saveComp = Compilation.setSaveCurrent(tr);
        final InPort in = (reader == null) ? null : reader.getPort();
        if (in instanceof TtyInPort) {
            ((TtyInPort)in).resetAndKeep();
        }
        try {
            if (tr.pendingForm != null) {
                tr.scanForm(tr.pendingForm, mexp);
                tr.pendingForm = null;
            }
            while (true) {
                while (reader != null) {
                    final Object sexp = reader.readCommand();
                    if (Translator.listLength(sexp) == 2 && Translator.safeCar(sexp) == begin.begin && Translator.safeCar(Translator.safeCdr(sexp)) == Sequence.eofValue && (options & 0x84) != 0x0) {
                        return false;
                    }
                    if (sexp != Sequence.eofValue) {
                        int ch;
                        do {
                            ch = lexer.read();
                        } while (ch == 32 || ch == 9 || ch == 13);
                        if (ch == 41) {
                            lexer.fatal("An unexpected close paren was read.");
                        }
                        if (ch != 10) {
                            lexer.unread(ch);
                        }
                        tr.scanForm(sexp, mexp);
                        if ((options & 0x4) != 0x0) {
                            if (ch < 0 || ch == 10) {
                                break;
                            }
                            if (!lexer.isInteractive()) {
                                break;
                            }
                            continue;
                        }
                        else {
                            if ((options & 0x8) != 0x0 && tr.getState() >= 2) {
                                return true;
                            }
                            continue;
                        }
                        continue;
                    }
                    if ((options & 0x4) != 0x0) {
                        return false;
                    }
                    tr.finishModule(mexp);
                    tr.setState(4);
                    return true;
                }
                continue;
            }
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
    public void resolve(final Compilation comp) {
        final Translator tr = (Translator)comp;
        final ModuleExp mexp = tr.getModule();
        tr.resolveModule(mexp);
        if (tr.subModuleMap != null) {
            final String mainName = tr.mainClass.getName();
            final ModuleInfo subinfo = tr.subModuleMap.get(mainName);
            if (subinfo != null && (mexp.body != QuoteExp.voidExp || mexp.firstDecl() != null)) {
                final ModuleExp submodule = subinfo.getModuleExpRaw();
                tr.error('e', "module has both statements and a submodule with the same name: " + tr.mainClass.getName(), (submodule != null) ? submodule : mexp);
            }
        }
    }
    
    @Override
    public Declaration declFromField(final ModuleExp mod, final Object fvalue, final Field fld) {
        final Declaration fdecl = super.declFromField(mod, fvalue, fld);
        final boolean isFinal = (fld.getModifiers() & 0x10) != 0x0;
        if (isFinal && fvalue instanceof Syntax) {
            fdecl.setSyntax();
        }
        return fdecl;
    }
    
    protected void defSntxStFld(final String name, final String cname, final String fname) {
        final Object property = this.hasSeparateFunctionNamespace() ? EnvironmentKey.FUNCTION : null;
        final StaticFieldLocation loc = StaticFieldLocation.define(this.environ, this.environ.getSymbol(name), property, cname, fname);
        loc.setSyntax();
    }
    
    protected void defSntxStFld(final String name, final String cname) {
        this.defSntxStFld(name, cname, Language.mangleNameIfNeeded(name));
    }
    
    public boolean keywordsAreSelfEvaluating() {
        return true;
    }
    
    public boolean selfEvaluatingSymbol(final Object obj) {
        return obj instanceof Keyword;
    }
    
    public static Symbol langSymbolToSymbol(final Object sym) {
        return ((LispLanguage)Language.getDefaultLanguage()).fromLangSymbol(sym);
    }
    
    protected Symbol fromLangSymbol(final Object sym) {
        if (sym instanceof String) {
            return this.getSymbol((String)sym);
        }
        return (Symbol)sym;
    }
    
    protected synchronized HashMap<String, Type> getTypeMap() {
        if (this.types == null) {
            (this.types = new HashMap<String, Type>(64)).put("void", LangPrimType.voidType);
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
    
    public Type getPackageStyleType(final String name) {
        final int colon = name.indexOf(58);
        if (colon <= 0) {
            return null;
        }
        final String lang = name.substring(0, colon);
        final Language interp = Language.getInstance(lang);
        if (interp == null) {
            throw new RuntimeException("unknown type '" + name + "' - unknown language '" + lang + '\'');
        }
        final Type type = interp.getNamedType(name.substring(colon + 1));
        if (type != null) {
            this.types.put(name, type);
        }
        return type;
    }
    
    @Override
    public Type getNamedType(final String name) {
        final Type type = this.getTypeMap().get(name);
        return (type != null) ? type : this.getPackageStyleType(name);
    }
    
    @Override
    public Type getTypeFor(final Class clas) {
        final String name = clas.getName();
        if (clas.isPrimitive()) {
            return this.getNamedType(name);
        }
        if ("java.lang.String".equals(name)) {
            return Type.toStringType;
        }
        final Type t = LangObjType.getInstanceFromClass(name);
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
        quasiquote_sym = Namespace.EmptyNamespace.getSymbol("quasiquote");
        dots3_sym = Symbol.valueOf("...");
        splice_sym = Namespace.EmptyNamespace.getSymbol("$splice$");
        lookup_sym = Namespace.EmptyNamespace.getSymbol("$lookup$");
        bracket_list_sym = Namespace.EmptyNamespace.getSymbol("$bracket-list$");
        bracket_apply_sym = Namespace.EmptyNamespace.getSymbol("$bracket-apply$");
        (LispLanguage.getNamedPartLocation = new StaticFieldLocation("gnu.kawa.functions.GetNamedPart", "getNamedPart")).setProcedure();
        unitNamespace = Namespace.valueOf("http://kawa.gnu.org/unit", "unit");
        constructNamespace = Namespace.valueOf("http://kawa.gnu.org/construct", "$construct$");
        entityNamespace = Namespace.valueOf("http://kawa.gnu.org/entity", "$entity$");
    }
}
