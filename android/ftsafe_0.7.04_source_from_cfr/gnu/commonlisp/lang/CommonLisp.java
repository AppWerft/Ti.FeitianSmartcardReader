/*
 * Decompiled with CFR 0.139.
 */
package gnu.commonlisp.lang;

import gnu.bytecode.PrimType;
import gnu.bytecode.Type;
import gnu.commonlisp.lang.Lisp2;
import gnu.commonlisp.lang.OrdinaryLambda;
import gnu.commonlisp.lang.UnwindProtect;
import gnu.commonlisp.lang.defun;
import gnu.commonlisp.lang.defvar;
import gnu.commonlisp.lang.function;
import gnu.commonlisp.lang.prog1;
import gnu.commonlisp.lang.setq;
import gnu.expr.Expression;
import gnu.expr.Keyword;
import gnu.expr.Language;
import gnu.kawa.format.AbstractFormat;
import gnu.kawa.functions.DisplayFormat;
import gnu.kawa.functions.IsEq;
import gnu.kawa.functions.IsEqual;
import gnu.kawa.functions.IsEqv;
import gnu.kawa.functions.Not;
import gnu.kawa.functions.NumberCompare;
import gnu.kawa.lispexpr.LangPrimType;
import gnu.kawa.reflect.InstanceOf;
import gnu.lists.LList;
import gnu.mapping.Environment;
import gnu.mapping.Location;
import gnu.mapping.LocationEnumeration;
import gnu.mapping.Symbol;
import gnu.math.IntNum;
import gnu.math.Numeric;
import gnu.text.Char;
import kawa.lang.Lambda;
import kawa.lang.Syntax;
import kawa.standard.Scheme;
import kawa.standard.begin;
import kawa.standard.let;

public class CommonLisp
extends Lisp2 {
    static boolean charIsInt = false;
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

    public static Object getCharacter(int c) {
        if (charIsInt) {
            return IntNum.make(c);
        }
        return Char.make((char)c);
    }

    public static Numeric asNumber(Object arg) {
        if (arg instanceof Char) {
            return IntNum.make(((Char)arg).intValue());
        }
        return (Numeric)arg;
    }

    public static char asChar(Object x) {
        if (x instanceof Char) {
            return ((Char)x).charValue();
        }
        int i = x instanceof Numeric ? ((Numeric)x).intValue() : -1;
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
        this.environ = clispEnvironment;
    }

    void initLisp() {
        LocationEnumeration e = Scheme.builtin().enumerateAllLocations();
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
        catch (ClassNotFoundException ex) {
            // empty catch block
        }
        OrdinaryLambda lambda = new OrdinaryLambda();
        lambda.setKeywords(CommonLisp.asSymbol("&optional"), CommonLisp.asSymbol("&rest"), CommonLisp.asSymbol("&key"), CommonLisp.asSymbol("&allow-other-keys"), CommonLisp.asSymbol("&aux"), CommonLisp.asSymbol("&body"));
        lambda.defaultDefault = nilExpr;
        this.defun("lambda", (Object)lambda);
        this.defun("defun", (Object)new defun(lambda));
        this.defun("defvar", (Object)new defvar(false));
        this.defun("defconst", (Object)new defvar(true));
        this.defun("defsubst", (Object)new defun(lambda));
        this.defun("function", (Object)new function(lambda));
        this.defun("setq", (Object)new setq());
        this.defun("prog1", (Object)new prog1("prog1", 1));
        this.defun("prog2", (Object)prog1.prog2);
        this.defun("progn", (Object)new begin());
        this.defun("unwind-protect", (Object)new UnwindProtect());
        this.defun("null", (Object)not);
        this.defun("eq", (Object)new IsEq(this, "eq"));
        this.defun("equal", (Object)new IsEqual(this, "equal"));
        this.defun("typep", (Object)new InstanceOf(this));
        this.defProcStFld("the", "gnu.kawa.functions.Convert", "as");
        this.defun("%flet", (Object)new let("flet", true));
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
        return instance;
    }

    public static void registerEnvironment() {
        Language.setDefaults(instance);
    }

    @Override
    public AbstractFormat getFormat(boolean readable) {
        return readable ? writeFormat : displayFormat;
    }

    @Override
    public Type getTypeFor(String name) {
        if (name == "t") {
            name = "java.lang.Object";
        }
        return super.getTypeFor(name);
    }

    @Override
    public Type getTypeFor(Class clas) {
        if (clas.isPrimitive()) {
            return this.getNamedType(clas.getName());
        }
        return Type.make(clas);
    }

    @Override
    public Type getNamedType(String name) {
        if (name.equals("boolean")) {
            if (this.booleanType == null) {
                this.booleanType = new LangPrimType(Type.booleanType, this);
            }
            return this.booleanType;
        }
        return super.getNamedType(name);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    static {
        clispEnvironment = Environment.make("clisp-environment");
        internalKeyword = Keyword.make("INTERNAL");
        inheritedKeyword = Keyword.make("INHERITED");
        externalKeyword = Keyword.make("EXTERNAL");
        instance = new CommonLisp();
        instance.define("t", TRUE);
        instance.define("nil", FALSE);
        not = new Not(instance, "not");
        numEqu = NumberCompare.make(instance, "=", 8);
        numGrt = NumberCompare.make(instance, ">", 16);
        numGEq = NumberCompare.make(instance, ">=", 24);
        numLss = NumberCompare.make(instance, "<", 4);
        numLEq = NumberCompare.make(instance, "<=", 12);
        isEq = new IsEq(instance, "eq?");
        isEqv = new IsEqv(instance, "eqv?", isEq);
        Environment saveEnv = Environment.setSaveCurrent(clispEnvironment);
        try {
            instance.initLisp();
        }
        finally {
            Environment.restoreCurrent(saveEnv);
        }
        writeFormat = new DisplayFormat(true, 'C');
        displayFormat = new DisplayFormat(false, 'C');
    }
}

