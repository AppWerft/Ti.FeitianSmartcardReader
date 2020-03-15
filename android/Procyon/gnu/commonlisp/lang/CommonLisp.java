// 
// Decompiled by Procyon v0.5.36
// 

package gnu.commonlisp.lang;

import gnu.kawa.functions.DisplayFormat;
import gnu.expr.Keyword;
import gnu.bytecode.Type;
import gnu.mapping.LocationEnumeration;
import kawa.standard.let;
import gnu.kawa.reflect.InstanceOf;
import gnu.kawa.functions.IsEqual;
import gnu.expr.Language;
import kawa.standard.begin;
import kawa.lang.Syntax;
import kawa.lang.Lambda;
import kawa.standard.Scheme;
import gnu.math.Numeric;
import gnu.text.Char;
import gnu.math.IntNum;
import gnu.kawa.lispexpr.LangPrimType;
import gnu.kawa.format.AbstractFormat;
import gnu.mapping.Symbol;
import gnu.kawa.functions.IsEqv;
import gnu.kawa.functions.IsEq;
import gnu.kawa.functions.Not;
import gnu.kawa.functions.NumberCompare;
import gnu.mapping.Environment;

public class CommonLisp extends Lisp2
{
    static boolean charIsInt;
    public static final CommonLisp instance;
    public static final Environment clispEnvironment;
    public static final NumberCompare numEqu;
    public static final NumberCompare numGrt;
    public static final NumberCompare numGEq;
    public static final NumberCompare numLss;
    public static final NumberCompare numLEq;
    public static final Not not;
    public static final IsEq isEq;
    public static final IsEqv isEqv;
    public static final Symbol internalKeyword;
    public static final Symbol inheritedKeyword;
    public static final Symbol externalKeyword;
    public static final AbstractFormat writeFormat;
    public static final AbstractFormat displayFormat;
    LangPrimType booleanType;
    
    public static Object getCharacter(final int c) {
        if (CommonLisp.charIsInt) {
            return IntNum.make(c);
        }
        return Char.make((char)c);
    }
    
    public static Numeric asNumber(final Object arg) {
        if (arg instanceof Char) {
            return IntNum.make(((Char)arg).intValue());
        }
        return (Numeric)arg;
    }
    
    public static char asChar(final Object x) {
        if (x instanceof Char) {
            return ((Char)x).charValue();
        }
        int i;
        if (x instanceof Numeric) {
            i = ((Numeric)x).intValue();
        }
        else {
            i = -1;
        }
        if (i < 0 || i > 65535) {
            throw new ClassCastException("not a character value");
        }
        return (char)i;
    }
    
    @Override
    public String getName() {
        return "CommonLisp";
    }
    
    public CommonLisp() {
        this.environ = CommonLisp.clispEnvironment;
    }
    
    void initLisp() {
        final LocationEnumeration e = Scheme.builtin().enumerateAllLocations();
        while (e.hasMoreElements()) {
            this.importLocation(e.nextLocation());
        }
        try {
            this.loadClass("kawa.lib.prim_syntax");
            this.loadClass("kawa.lib.std_syntax");
            this.loadClass("kawa.lib.lists");
            this.loadClass("kawa.lib.strings");
            this.loadClass("gnu.commonlisp.lisp.PrimOps");
        }
        catch (ClassNotFoundException ex) {}
        final OrdinaryLambda lambda = new OrdinaryLambda();
        lambda.setKeywords(Lisp2.asSymbol("&optional"), Lisp2.asSymbol("&rest"), Lisp2.asSymbol("&key"), Lisp2.asSymbol("&allow-other-keys"), Lisp2.asSymbol("&aux"), Lisp2.asSymbol("&body"));
        lambda.defaultDefault = CommonLisp.nilExpr;
        this.defun("lambda", lambda);
        this.defun("defun", new defun(lambda));
        this.defun("defvar", new defvar(false));
        this.defun("defconst", new defvar(true));
        this.defun("defsubst", new defun(lambda));
        this.defun("function", new function(lambda));
        this.defun("setq", new setq());
        this.defun("prog1", new prog1("prog1", 1));
        this.defun("prog2", prog1.prog2);
        this.defun("progn", new begin());
        this.defun("unwind-protect", new UnwindProtect());
        this.defun("null", CommonLisp.not);
        this.defun("eq", new IsEq(this, "eq"));
        this.defun("equal", new IsEqual(this, "equal"));
        this.defun("typep", new InstanceOf(this));
        this.defProcStFld("the", "gnu.kawa.functions.Convert", "as");
        this.defun("%flet", new let("flet", true));
        this.defProcStFld("princ", "gnu.commonlisp.lisp.PrimOps");
        this.defProcStFld("prin1", "gnu.commonlisp.lisp.PrimOps");
        this.defAliasStFld("*package*", "gnu.kawa.lispexpr.LispPackage", "currentPackage");
        this.defProcStFld("=", "gnu.commonlisp.lang.CommonLisp", "numEqu");
        this.defProcStFld("<", "gnu.commonlisp.lang.CommonLisp", "numLss");
        this.defProcStFld(">", "gnu.commonlisp.lang.CommonLisp", "numGrt");
        this.defProcStFld("<=", "gnu.commonlisp.lang.CommonLisp", "numLEq");
        this.defProcStFld(">=", "gnu.commonlisp.lang.CommonLisp", "numGEq");
        this.defProcStFld("not", "gnu.commonlisp.lang.CommonLisp");
        this.defProcStFld("eq?", "gnu.commonlisp.lang.CommonLisp", "isEq");
        this.defProcStFld("eqv?", "gnu.commonlisp.lang.CommonLisp", "isEqv");
        this.defProcStFld("functionp", "gnu.commonlisp.lisp.PrimOps");
        this.defProcStFld("car", "gnu.commonlisp.lisp.primitives");
        this.defProcStFld("first", "gnu.commonlisp.lisp.primitives");
        this.defProcStFld("cdr", "gnu.commonlisp.lisp.primitives");
        this.defProcStFld("caar", "kawa.lib.lists");
        this.defProcStFld("cadr", "kawa.lib.lists");
        this.defProcStFld("cdar", "kawa.lib.lists");
        this.defProcStFld("cddr", "kawa.lib.lists");
        this.defProcStFld("caaar", "kawa.lib.lists");
        this.defProcStFld("caadr", "kawa.lib.lists");
        this.defProcStFld("cadar", "kawa.lib.lists");
        this.defProcStFld("caddr", "kawa.lib.lists");
        this.defProcStFld("cdaar", "kawa.lib.lists");
        this.defProcStFld("cdadr", "kawa.lib.lists");
        this.defProcStFld("cddar", "kawa.lib.lists");
        this.defProcStFld("cdddr", "kawa.lib.lists");
        this.defProcStFld("caaaar", "kawa.lib.lists");
        this.defProcStFld("caaadr", "kawa.lib.lists");
        this.defProcStFld("caadar", "kawa.lib.lists");
        this.defProcStFld("caaddr", "kawa.lib.lists");
        this.defProcStFld("cadaar", "kawa.lib.lists");
        this.defProcStFld("cadadr", "kawa.lib.lists");
        this.defProcStFld("caddar", "kawa.lib.lists");
        this.defProcStFld("cadddr", "kawa.lib.lists");
        this.defProcStFld("cdaaar", "kawa.lib.lists");
        this.defProcStFld("cdaadr", "kawa.lib.lists");
        this.defProcStFld("cdadar", "kawa.lib.lists");
        this.defProcStFld("cdaddr", "kawa.lib.lists");
        this.defProcStFld("cddaar", "kawa.lib.lists");
        this.defProcStFld("cddadr", "kawa.lib.lists");
        this.defProcStFld("cdddar", "kawa.lib.lists");
        this.defProcStFld("cddddr", "kawa.lib.lists");
        this.defProcStFld("rest", "gnu.commonlisp.lisp.primitives");
        this.defProcStFld("second", "gnu.commonlisp.lisp.primitives");
        this.defProcStFld("third", "gnu.commonlisp.lisp.primitives");
        this.defProcStFld("nthcdr", "gnu.commonlisp.lisp.primitives");
        this.defProcStFld("nth", "gnu.commonlisp.lisp.primitives");
        this.defProcStFld("1-", "gnu.commonlisp.lisp.primitives");
        this.defProcStFld("1+", "gnu.commonlisp.lisp.primitives");
        this.defProcStFld("acons", "gnu.commonlisp.lisp.primitives");
        this.defProcStFld("listp", "gnu.commonlisp.lisp.primitives");
        this.defProcStFld("numberp", "gnu.commonlisp.lisp.primitives");
        this.defProcStFldAs("zerop", "kawa.lib.numbers", "zero?");
        this.defProcStFldAs("consp", "kawa.lib.lists", "pair?");
        this.defProcStFld("atom", "gnu.commonlisp.lisp.primitives");
        this.defProcStFld("eql", "gnu.commonlisp.lisp.primitives");
        this.defProcStFld("member", "gnu.commonlisp.lisp.primitives");
        this.defProcStFld("complement", "gnu.commonlisp.lisp.primitives");
        this.defProcStFld("apply", "gnu.commonlisp.lisp.primitives");
        this.defProcStFld("funcall", "gnu.commonlisp.lisp.primitives");
        this.defProcStFld("minusp", "gnu.commonlisp.lisp.primitives");
        this.defProcStFld("plusp", "gnu.commonlisp.lisp.primitives");
        this.defProcStFld("flet", "gnu.commonlisp.lisp.primitives");
        this.defProcStFld("labels", "gnu.commonlisp.lisp.primitives");
        this.defProcStFld("multiple-value-bind", "gnu.commonlisp.lisp.primitives");
        this.defProcStFld("floor", "gnu.commonlisp.lisp.primitives");
    }
    
    public static CommonLisp getInstance() {
        return CommonLisp.instance;
    }
    
    public static void registerEnvironment() {
        Language.setDefaults(CommonLisp.instance);
    }
    
    @Override
    public AbstractFormat getFormat(final boolean readable) {
        return readable ? CommonLisp.writeFormat : CommonLisp.displayFormat;
    }
    
    @Override
    public Type getTypeFor(String name) {
        if (name == "t") {
            name = "java.lang.Object";
        }
        return super.getTypeFor(name);
    }
    
    @Override
    public Type getTypeFor(final Class clas) {
        if (clas.isPrimitive()) {
            return this.getNamedType(clas.getName());
        }
        return Type.make(clas);
    }
    
    @Override
    public Type getNamedType(final String name) {
        if (name.equals("boolean")) {
            if (this.booleanType == null) {
                this.booleanType = new LangPrimType(Type.booleanType, this);
            }
            return this.booleanType;
        }
        return super.getNamedType(name);
    }
    
    static {
        CommonLisp.charIsInt = false;
        clispEnvironment = Environment.make("clisp-environment");
        internalKeyword = Keyword.make("INTERNAL");
        inheritedKeyword = Keyword.make("INHERITED");
        externalKeyword = Keyword.make("EXTERNAL");
        (instance = new CommonLisp()).define("t", CommonLisp.TRUE);
        CommonLisp.instance.define("nil", CommonLisp.FALSE);
        not = new Not(CommonLisp.instance, "not");
        numEqu = NumberCompare.make(CommonLisp.instance, "=", 8);
        numGrt = NumberCompare.make(CommonLisp.instance, ">", 16);
        numGEq = NumberCompare.make(CommonLisp.instance, ">=", 24);
        numLss = NumberCompare.make(CommonLisp.instance, "<", 4);
        numLEq = NumberCompare.make(CommonLisp.instance, "<=", 12);
        isEq = new IsEq(CommonLisp.instance, "eq?");
        isEqv = new IsEqv(CommonLisp.instance, "eqv?", CommonLisp.isEq);
        final Environment saveEnv = Environment.setSaveCurrent(CommonLisp.clispEnvironment);
        try {
            CommonLisp.instance.initLisp();
        }
        finally {
            Environment.restoreCurrent(saveEnv);
        }
        writeFormat = new DisplayFormat(true, 'C');
        displayFormat = new DisplayFormat(false, 'C');
    }
}
