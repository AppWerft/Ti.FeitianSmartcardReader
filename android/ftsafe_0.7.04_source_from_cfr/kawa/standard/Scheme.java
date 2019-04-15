/*
 * Decompiled with CFR 0.139.
 */
package kawa.standard;

import gnu.bytecode.ClassType;
import gnu.bytecode.PrimType;
import gnu.bytecode.Type;
import gnu.expr.Compilation;
import gnu.expr.Declaration;
import gnu.expr.Expression;
import gnu.expr.Language;
import gnu.kawa.format.AbstractFormat;
import gnu.kawa.functions.Apply;
import gnu.kawa.functions.ApplyToArgs;
import gnu.kawa.functions.DisplayFormat;
import gnu.kawa.functions.IsEq;
import gnu.kawa.functions.IsEqual;
import gnu.kawa.functions.IsEqv;
import gnu.kawa.functions.Map;
import gnu.kawa.functions.Not;
import gnu.kawa.functions.NumberCompare;
import gnu.kawa.functions.NumberPredicate;
import gnu.kawa.io.CharArrayInPort;
import gnu.kawa.io.InPort;
import gnu.kawa.lispexpr.GenArrayType;
import gnu.kawa.lispexpr.LangPrimType;
import gnu.kawa.lispexpr.LispLanguage;
import gnu.kawa.lispexpr.LispReader;
import gnu.kawa.lispexpr.ReadTable;
import gnu.kawa.lispexpr.ReadTableEntry;
import gnu.kawa.lispexpr.ReaderDispatch;
import gnu.kawa.lispexpr.ReaderDispatchSyntaxQuote;
import gnu.kawa.lispexpr.ReaderParens;
import gnu.kawa.lispexpr.ReaderQuote;
import gnu.kawa.reflect.InstanceOf;
import gnu.kawa.reflect.LazyType;
import gnu.kawa.reflect.MultValuesType;
import gnu.kawa.servlet.HttpRequestContext;
import gnu.mapping.Environment;
import gnu.mapping.Namespace;
import gnu.mapping.SimpleEnvironment;
import gnu.mapping.Symbol;
import gnu.mapping.WrappedException;
import gnu.text.Lexer;
import gnu.text.SourceMessages;
import gnu.text.SyntaxException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import kawa.lang.Eval;

public class Scheme
extends LispLanguage {
    public static final int FOLLOW_R5RS = 5;
    public static final int FOLLOW_R6RS = 6;
    public static final int FOLLOW_R7RS = 7;
    int standardToFollow;
    public static final Environment nullEnvironment = Environment.make("null-environment");
    public static final Environment r4Environment = Environment.make("r4rs-environment", nullEnvironment);
    public static final Environment r5Environment = Environment.make("r5rs-environment", r4Environment);
    public static final Environment r6Environment = Environment.make("r6rs-environment", r5Environment);
    protected static final SimpleEnvironment kawaEnvironment = Environment.make("kawa-environment", r6Environment);
    public static final Scheme instance = new Scheme(kawaEnvironment);
    public static final Scheme r5rsInstance = Scheme.newStandardInstance(5);
    public static final Scheme r6rsInstance = Scheme.newStandardInstance(6);
    public static final Scheme r7rsInstance = Scheme.newStandardInstance(7);
    public static final LangPrimType booleanType = new LangPrimType(Type.booleanType, instance);
    public static final ApplyToArgs applyToArgs = new ApplyToArgs("apply-to-args", instance);
    public static final Apply apply = new Apply("apply", applyToArgs);
    public static final InstanceOf instanceOf = new InstanceOf(instance, "instance?");
    public static final Not not = new Not(instance, "not");
    public static final IsEq isEq = new IsEq(instance, "eq?");
    public static final IsEqv isEqv = new IsEqv(instance, "eqv?", isEq);
    public static final IsEqual isEqual = new IsEqual(instance, "equal?");
    public static final Map map = new Map(true, applyToArgs, isEq);
    public static final Map forEach = new Map(false, applyToArgs, isEq);
    public static final NumberCompare numEqu = NumberCompare.make(instance, "=", 8);
    public static final NumberCompare numGrt = NumberCompare.make(instance, ">", 16);
    public static final NumberCompare numGEq = NumberCompare.make(instance, ">=", 24);
    public static final NumberCompare numLss = NumberCompare.make(instance, "<", 4);
    public static final NumberCompare numLEq = NumberCompare.make(instance, "<=", 12);
    public static final NumberPredicate isOdd = new NumberPredicate(instance, "odd?", 1);
    public static final NumberPredicate isEven = new NumberPredicate(instance, "even?", 2);
    private static final String[] uniformVectorTags = new String[]{"s8", "s16", "s32", "s64", "u8", "u16", "u32", "u64", "f32", "f64"};
    public static final String emptyStringLeft = new String();
    public static final String emptyStringRight = new String();
    private HashMap<String, Type> types;
    private HashMap<Type, String> typeToStringMap;

    public int getStandardToFollow() {
        return this.standardToFollow;
    }

    public static Scheme getInstance() {
        return instance;
    }

    private static Scheme newStandardInstance(int standardToFollow) {
        Scheme instance = new Scheme(kawaEnvironment);
        instance.standardToFollow = standardToFollow;
        return instance;
    }

    public static synchronized Scheme getR5rsInstance() {
        return r5rsInstance;
    }

    public static synchronized Scheme getR6rsInstance() {
        return r6rsInstance;
    }

    public static synchronized Scheme getR7rsInstance() {
        return r7rsInstance;
    }

    public static Environment builtin() {
        return kawaEnvironment;
    }

    private void initScheme() {
        this.environ = nullEnvironment;
        this.defSntxStFld("lambda", "kawa.standard.SchemeCompilation", "lambda");
        this.defSntxStFld("$bracket-apply$", "gnu.kawa.lispexpr.BracketApply", "instance");
        this.defSntxStFld("$bracket-list$", "kawa.lib.syntax");
        this.defSntxStFld("$string$", "kawa.lib.syntax");
        this.defSntxStFld("$string-with-default-format$", "kawa.lib.syntax");
        this.defSntxStFld("$format$", "kawa.lib.syntax");
        this.defSntxStFld("$sprintf$", "kawa.lib.syntax");
        this.defSntxStFld("define-simple-constructor", "kawa.lib.syntax");
        this.defAliasStFld("$<<$", "kawa.standard.Scheme", "emptyStringLeft");
        this.defAliasStFld("$>>$", "kawa.standard.Scheme", "emptyStringRight");
        this.defSntxStFld("$xml-element$", "gnu.kawa.lispexpr.MakeXmlElement", "makeXml");
        this.defProcStFld("$xml-attribute$", "gnu.kawa.xml.MakeAttribute", "makeAttributeS");
        this.defProcStFld("$xml-text$", "gnu.kawa.xml.MakeText", "makeText");
        this.defProcStFld("$xml-CDATA$", "gnu.kawa.xml.MakeCDATA", "makeCDATA");
        this.defProcStFld("$xml-comment$", "gnu.kawa.xml.CommentConstructor", "commentConstructor");
        this.defProcStFld("$xml-processing-instruction$", "gnu.kawa.xml.MakeProcInst", "makeProcInst");
        this.defSntxStFld("$resolve-qname$", "gnu.kawa.lispexpr.ResolveNamespace", "resolveQName");
        this.defSntxStFld("quote", "kawa.lang.Quote", "plainQuote");
        this.defSntxStFld("define", "kawa.lib.prim_syntax");
        this.defSntxStFld("!", "kawa.standard.MatchDef", "matchDef");
        this.defSntxStFld("if", "kawa.lib.prim_syntax");
        this.defSntxStFld("set!", "kawa.standard.set_b", "set");
        this.defSntxStFld("cond", "kawa.lib.std_syntax");
        this.defSntxStFld("...", "kawa.lib.std_syntax");
        this.defSntxStFld("_", "kawa.lib.std_syntax");
        this.defSntxStFld("?", "kawa.lib.std_syntax");
        this.defSntxStFld("=>", "kawa.lib.std_syntax");
        this.defSntxStFld("else", "kawa.lib.std_syntax");
        this.defSntxStFld("unquote", "kawa.lib.std_syntax");
        this.defSntxStFld("unquote-splicing", "kawa.lib.std_syntax");
        this.defSntxStFld("case", "kawa.lib.case_syntax");
        this.defSntxStFld("and", "kawa.lib.std_syntax");
        this.defSntxStFld("or", "kawa.lib.std_syntax");
        this.defSntxStFld("let", "kawa.lib.std_syntax");
        this.defSntxStFld("let*", "kawa.lib.std_syntax");
        this.defSntxStFld("letrec", "kawa.lib.prim_syntax");
        this.defSntxStFld("letrec*", "kawa.lib.prim_syntax", "letrec");
        this.defSntxStFld("begin", "kawa.standard.begin", "begin");
        this.defSntxStFld("do", "kawa.lib.std_syntax");
        this.defSntxStFld("lazy", "kawa.lib.std_syntax");
        this.defSntxStFld("delay-force", "kawa.lib.std_syntax");
        this.defSntxStFld("delay", "kawa.lib.std_syntax");
        this.defSntxStFld("quasiquote", "kawa.lang.Quote", "quasiQuote");
        this.defSntxStFld("define-syntax", "kawa.lib.prim_syntax");
        this.defSntxStFld("let-syntax", "kawa.standard.let_syntax", "let_syntax");
        this.defSntxStFld("letrec-syntax", "kawa.standard.let_syntax", "letrec_syntax");
        this.defSntxStFld("syntax-rules", "kawa.standard.syntax_rules", "syntax_rules");
        nullEnvironment.setLocked();
        this.environ = r4Environment;
        this.defProcStFld("not", "kawa.standard.Scheme");
        this.defProcStFld("boolean?", "kawa.lib.misc");
        this.defProcStFld("boolean=?", "kawa.lib.misc");
        this.defProcStFld("eq?", "kawa.standard.Scheme", "isEq");
        this.defProcStFld("eqv?", "kawa.standard.Scheme", "isEqv");
        this.defProcStFld("equal?", "kawa.standard.Scheme", "isEqual");
        this.defProcStFld("pair?", "kawa.lib.lists");
        this.defProcStFld("cons", "kawa.lib.lists");
        this.defProcStFld("car", "kawa.lib.lists");
        this.defProcStFld("cdr", "kawa.lib.lists");
        this.defProcStFld("set-car!", "kawa.lib.lists");
        this.defProcStFld("set-cdr!", "kawa.lib.lists");
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
        this.defProcStFld("null?", "kawa.lib.lists");
        this.defProcStFld("list?", "kawa.lib.lists");
        this.defProcStFld("make-list", "kawa.lib.lists");
        this.defProcStFld("length", "kawa.lib.lists");
        this.defProcStFld("append", "kawa.standard.append", "append");
        this.defProcStFld("reverse", "kawa.lib.lists");
        this.defProcStFld("reverse!", "kawa.lib.lists");
        this.defProcStFld("list-tail", "kawa.lib.lists");
        this.defProcStFld("list-ref", "kawa.lib.lists");
        this.defProcStFld("list-set!", "kawa.lib.lists");
        this.defProcStFld("list-copy", "kawa.lib.lists");
        this.defProcStFld("memq", "kawa.lib.lists");
        this.defProcStFld("memv", "kawa.lib.lists");
        this.defProcStFld("member", "kawa.lib.lists");
        this.defProcStFld("assq", "kawa.lib.lists");
        this.defProcStFld("assv", "kawa.lib.lists");
        this.defProcStFld("assoc", "kawa.lib.lists");
        this.defProcStFld("symbol?", "kawa.lib.misc");
        this.defProcStFld("symbol->string", "kawa.lib.misc");
        this.defProcStFld("string->symbol", "kawa.lib.misc");
        this.defProcStFld("symbol=?", "kawa.lib.misc");
        this.defProcStFld("symbol-local-name", "kawa.lib.misc");
        this.defProcStFld("symbol-namespace", "kawa.lib.misc");
        this.defProcStFld("symbol-namespace-uri", "kawa.lib.misc");
        this.defProcStFld("symbol-prefix", "kawa.lib.misc");
        this.defProcStFld("namespace-uri", "kawa.lib.misc");
        this.defProcStFld("namespace-prefix", "kawa.lib.misc");
        this.defProcStFld("number?", "kawa.lib.numbers");
        this.defProcStFld("quantity?", "kawa.lib.numbers");
        this.defProcStFld("complex?", "kawa.lib.numbers");
        this.defProcStFld("real?", "kawa.lib.numbers");
        this.defProcStFld("rational?", "kawa.lib.numbers");
        this.defProcStFld("integer?", "kawa.lib.numbers");
        this.defProcStFld("exact-integer?", "kawa.lib.numbers");
        this.defProcStFld("exact?", "kawa.lib.numbers");
        this.defProcStFld("inexact?", "kawa.lib.numbers");
        this.defProcStFld("=", "kawa.standard.Scheme", "numEqu");
        this.defProcStFld("<", "kawa.standard.Scheme", "numLss");
        this.defProcStFld(">", "kawa.standard.Scheme", "numGrt");
        this.defProcStFld("<=", "kawa.standard.Scheme", "numLEq");
        this.defProcStFld(">=", "kawa.standard.Scheme", "numGEq");
        this.defProcStFld("zero?", "kawa.lib.numbers");
        this.defProcStFld("positive?", "kawa.lib.numbers");
        this.defProcStFld("negative?", "kawa.lib.numbers");
        this.defProcStFld("odd?", "kawa.standard.Scheme", "isOdd");
        this.defProcStFld("even?", "kawa.standard.Scheme", "isEven");
        this.defProcStFld("max", "kawa.lib.numbers");
        this.defProcStFld("min", "kawa.lib.numbers");
        this.defProcStFld("+", "gnu.kawa.functions.AddOp", "$Pl");
        this.defProcStFld("-", "gnu.kawa.functions.AddOp", "$Mn");
        this.defProcStFld("*", "gnu.kawa.functions.MultiplyOp", "$St");
        this.defProcStFld("/", "gnu.kawa.functions.DivideOp", "$Sl");
        this.defProcStFld("abs", "kawa.lib.numbers");
        this.defProcStFld("quotient", "gnu.kawa.functions.DivideOp", "quotient");
        this.defProcStFld("truncate-quotient", "gnu.kawa.functions.DivideOp", "quotient");
        this.defProcStFld("remainder", "gnu.kawa.functions.DivideOp", "remainder");
        this.defProcStFld("truncate-remainder", "gnu.kawa.functions.DivideOp", "remainder");
        this.defProcStFld("modulo", "gnu.kawa.functions.DivideOp", "modulo");
        this.defProcStFld("floor-quotient", "gnu.kawa.functions.DivideOp", "floorQuotient");
        this.defProcStFld("floor-remainder", "gnu.kawa.functions.DivideOp", "modulo");
        this.defProcStFld("div", "gnu.kawa.functions.DivideOp", "div");
        this.defProcStFld("mod", "gnu.kawa.functions.DivideOp", "mod");
        this.defProcStFld("div0", "gnu.kawa.functions.DivideOp", "div0");
        this.defProcStFld("mod0", "gnu.kawa.functions.DivideOp", "mod0");
        this.defProcStFld("floor/", "kawa.lib.numbers");
        this.defProcStFld("truncate/", "kawa.lib.numbers");
        this.defProcStFld("div-and-mod", "kawa.lib.numbers");
        this.defProcStFld("div0-and-mod0", "kawa.lib.numbers");
        this.defProcStFld("gcd", "kawa.lib.numbers");
        this.defProcStFld("lcm", "kawa.lib.numbers");
        this.defProcStFld("numerator", "kawa.lib.numbers");
        this.defProcStFld("denominator", "kawa.lib.numbers");
        this.defProcStFld("floor", "kawa.lib.numbers");
        this.defProcStFld("ceiling", "kawa.lib.numbers");
        this.defProcStFld("truncate", "kawa.lib.numbers");
        this.defProcStFld("round", "kawa.lib.numbers");
        this.defProcStFld("rationalize", "kawa.lib.numbers");
        this.defProcStFld("exp", "kawa.lib.numbers");
        this.defProcStFld("log", "kawa.lib.numbers");
        this.defProcStFld("sin", "kawa.lib.numbers");
        this.defProcStFld("cos", "kawa.lib.numbers");
        this.defProcStFld("tan", "kawa.lib.numbers");
        this.defProcStFld("asin", "kawa.lib.numbers");
        this.defProcStFld("acos", "kawa.lib.numbers");
        this.defProcStFld("atan", "kawa.lib.numbers");
        this.defProcStFld("sinh", "kawa.lib.numbers");
        this.defProcStFld("cosh", "kawa.lib.numbers");
        this.defProcStFld("tanh", "kawa.lib.numbers");
        this.defProcStFld("asinh", "kawa.lib.numbers");
        this.defProcStFld("acosh", "kawa.lib.numbers");
        this.defProcStFld("atanh", "kawa.lib.numbers");
        this.defProcStFld("sqrt", "kawa.lib.numbers");
        this.defProcStFld("square", "kawa.lib.numbers");
        this.defProcStFld("expt", "kawa.standard.expt");
        this.defProcStFld("make-rectangular", "kawa.lib.numbers");
        this.defProcStFld("make-polar", "kawa.lib.numbers");
        this.defProcStFld("real-part", "kawa.lib.numbers");
        this.defProcStFld("imag-part", "kawa.lib.numbers");
        this.defProcStFld("magnitude", "kawa.lib.numbers");
        this.defProcStFld("angle", "kawa.lib.numbers");
        this.defProcStFld("inexact", "kawa.lib.numbers");
        this.defProcStFld("exact", "kawa.lib.numbers");
        this.defProcStFld("exact->inexact", "kawa.lib.numbers");
        this.defProcStFld("inexact->exact", "kawa.lib.numbers");
        this.defProcStFld("number->string", "kawa.lib.numbers");
        this.defProcStFld("string->number", "kawa.lib.numbers");
        this.defProcStFld("char?", "kawa.lib.characters");
        this.defProcStFld("char=?", "kawa.lib.strings");
        this.defProcStFld("char<?", "kawa.lib.strings");
        this.defProcStFld("char>?", "kawa.lib.strings");
        this.defProcStFld("char<=?", "kawa.lib.strings");
        this.defProcStFld("char>=?", "kawa.lib.strings");
        this.defProcStFld("char-ci=?", "kawa.lib.strings");
        this.defProcStFld("char-ci<?", "kawa.lib.strings");
        this.defProcStFld("char-ci>?", "kawa.lib.strings");
        this.defProcStFld("char-ci<=?", "kawa.lib.strings");
        this.defProcStFld("char-ci>=?", "kawa.lib.strings");
        this.defProcStFld("char-alphabetic?", "kawa.lib.rnrs.unicode");
        this.defProcStFld("char-numeric?", "kawa.lib.rnrs.unicode");
        this.defProcStFld("char-whitespace?", "kawa.lib.rnrs.unicode");
        this.defProcStFld("char-upper-case?", "kawa.lib.rnrs.unicode");
        this.defProcStFld("char-lower-case?", "kawa.lib.rnrs.unicode");
        this.defProcStFld("char-title-case?", "kawa.lib.rnrs.unicode");
        this.defProcStFld("digit-value", "kawa.lib.characters");
        this.defProcStFld("char->integer", "kawa.lib.characters");
        this.defProcStFld("integer->char", "kawa.lib.characters");
        this.defProcStFld("char-upcase", "kawa.lib.rnrs.unicode");
        this.defProcStFld("char-downcase", "kawa.lib.rnrs.unicode");
        this.defProcStFld("char-titlecase", "kawa.lib.rnrs.unicode");
        this.defProcStFld("char-foldcase", "kawa.lib.rnrs.unicode");
        this.defProcStFld("char-general-category", "kawa.lib.rnrs.unicode");
        this.defProcStFld("string?", "kawa.lib.strings");
        this.defProcStFld("make-string", "kawa.lib.strings");
        this.defProcStFld("string-length", "kawa.lib.strings");
        this.defProcStFld("string-ref", "kawa.lib.strings");
        this.defProcStFld("string-set!", "kawa.lib.strings");
        this.defProcStFld("string=?", "kawa.lib.strings");
        this.defProcStFld("string<?", "kawa.lib.strings");
        this.defProcStFld("string>?", "kawa.lib.strings");
        this.defProcStFld("string<=?", "kawa.lib.strings");
        this.defProcStFld("string>=?", "kawa.lib.strings");
        this.defProcStFld("string-ci=?", "kawa.lib.strings");
        this.defProcStFld("string-ci<?", "kawa.lib.strings");
        this.defProcStFld("string-ci>?", "kawa.lib.strings");
        this.defProcStFld("string-ci<=?", "kawa.lib.strings");
        this.defProcStFld("string-ci>=?", "kawa.lib.strings");
        this.defProcStFld("string-normalize-nfd", "kawa.lib.rnrs.unicode");
        this.defProcStFld("string-normalize-nfkd", "kawa.lib.rnrs.unicode");
        this.defProcStFld("string-normalize-nfc", "kawa.lib.rnrs.unicode");
        this.defProcStFld("string-normalize-nfkc", "kawa.lib.rnrs.unicode");
        this.defProcStFld("substring", "kawa.lib.strings");
        this.defProcStFld("string-append", "kawa.lib.strings");
        this.defProcStFld("string-append!", "kawa.lib.strings");
        this.defProcStFld("string-replace!", "kawa.lib.strings");
        this.defProcStFld("string->list", "kawa.lib.strings");
        this.defProcStFld("list->string", "kawa.lib.strings");
        this.defProcStFld("string-copy", "kawa.lib.strings");
        this.defProcStFld("string-copy!", "kawa.lib.strings");
        this.defProcStFld("string-fill!", "kawa.lib.strings");
        this.defProcStFld("vector?", "kawa.lib.vectors");
        this.defProcStFld("make-vector", "kawa.lib.vectors");
        this.defProcStFld("vector-length", "kawa.lib.vectors");
        this.defProcStFld("vector-ref", "kawa.lib.vectors");
        this.defProcStFld("vector-set!", "kawa.lib.vectors");
        this.defProcStFld("list->vector", "kawa.lib.vectors");
        this.defProcStFld("vector->list", "kawa.lib.vectors");
        this.defProcStFld("vector->string", "kawa.lib.vectors");
        this.defProcStFld("string->vector", "kawa.lib.vectors");
        this.defProcStFld("vector-copy", "kawa.lib.vectors");
        this.defProcStFld("vector-copy!", "kawa.lib.vectors");
        this.defProcStFld("vector-fill!", "kawa.lib.vectors");
        this.defProcStFld("vector-append", "kawa.standard.vector_append", "vectorAppend");
        this.defProcStFld("values-append", "gnu.kawa.functions.AppendValues", "appendValues");
        this.defProcStFld("procedure?", "kawa.lib.misc");
        this.defProcStFld("apply", "kawa.standard.Scheme", "apply");
        this.defProcStFld("map", "kawa.standard.Scheme", "map");
        this.defProcStFld("for-each", "kawa.standard.Scheme", "forEach");
        this.defProcStFld("call-with-current-continuation", "gnu.kawa.functions.CallCC", "callcc");
        this.defProcStFld("call/cc", "gnu.kawa.functions.CallCC", "callcc");
        this.defProcStFld("force", "kawa.lib.misc");
        this.defProcStFld("force*", "kawa.lib.misc");
        this.defProcStFld("eager", "kawa.lib.misc");
        this.defProcStFld("promise?", "kawa.lib.misc");
        this.defProcStFld("make-promise", "kawa.lib.misc");
        this.defProcStFld("promise-set-value!", "kawa.lib.misc");
        this.defProcStFld("promise-set-alias!", "kawa.lib.misc");
        this.defProcStFld("promise-set-exception!", "kawa.lib.misc");
        this.defProcStFld("promise-set-thunk!", "kawa.lib.misc");
        this.defProcStFld("call-with-port", "kawa.lib.ports");
        this.defProcStFld("call-with-input-file", "kawa.lib.ports");
        this.defProcStFld("call-with-output-file", "kawa.lib.ports");
        this.defProcStFld("input-port?", "kawa.lib.ports");
        this.defProcStFld("output-port?", "kawa.lib.ports");
        this.defProcStFld("textual-port?", "kawa.lib.ports");
        this.defProcStFld("binary-port?", "kawa.lib.ports");
        this.defProcStFld("port?", "kawa.lib.ports");
        this.defProcStFld("input-port-open?", "kawa.lib.ports");
        this.defProcStFld("output-port-open?", "kawa.lib.ports");
        this.defProcStFld("current-input-port", "kawa.lib.ports");
        this.defProcStFld("current-output-port", "kawa.lib.ports");
        this.defProcStFld("with-input-from-file", "kawa.lib.ports");
        this.defProcStFld("with-output-to-file", "kawa.lib.ports");
        this.defProcStFld("open-input-file", "kawa.lib.ports");
        this.defProcStFld("open-binary-input-file", "kawa.lib.ports");
        this.defProcStFld("open-output-file", "kawa.lib.ports");
        this.defProcStFld("open-binary-output-file", "kawa.lib.ports");
        this.defProcStFld("close-port", "kawa.lib.ports");
        this.defProcStFld("close-input-port", "kawa.lib.ports");
        this.defProcStFld("close-output-port", "kawa.lib.ports");
        this.defProcStFld("read", "kawa.lib.ports");
        this.defProcStFld("read-line", "kawa.lib.ports");
        this.defProcStFld("read-char", "kawa.lib.ports");
        this.defProcStFld("peek-char", "kawa.lib.ports");
        this.defProcStFld("eof-object?", "kawa.lib.ports");
        this.defProcStFld("eof-object", "kawa.lib.ports");
        this.defProcStFld("read-string", "kawa.lib.ports");
        this.defProcStFld("read-u8", "kawa.lib.ports");
        this.defProcStFld("peek-u8", "kawa.lib.ports");
        this.defProcStFld("u8-ready?", "kawa.lib.ports");
        this.defProcStFld("read-bytevector", "kawa.lib.ports");
        this.defProcStFld("read-bytevector!", "kawa.lib.ports");
        this.defProcStFld("char-ready?", "kawa.lib.ports");
        this.defProcStFld("write", "kawa.lib.ports");
        this.defProcStFld("write-simple", "kawa.lib.ports");
        this.defProcStFld("write-shared", "kawa.lib.ports");
        this.defProcStFld("write-with-shared-structure", "kawa.lib.ports");
        this.defProcStFld("display", "kawa.lib.ports");
        this.defProcStFld("print-as-xml", "gnu.xquery.lang.XQuery", "writeFormat");
        this.defProcStFld("write-char", "kawa.lib.ports");
        this.defProcStFld("write-string", "kawa.lib.ports");
        this.defProcStFld("write-u8", "kawa.lib.ports");
        this.defProcStFld("write-bytevector", "kawa.lib.ports");
        this.defProcStFld("newline", "kawa.lib.ports");
        this.defProcStFld("load", "kawa.standard.load", "load");
        this.defProcStFld("load-relative", "kawa.standard.load", "loadRelative");
        this.defProcStFld("transcript-off", "kawa.lib.ports");
        this.defProcStFld("transcript-on", "kawa.lib.ports");
        this.defProcStFld("call-with-input-string", "kawa.lib.ports");
        this.defProcStFld("open-input-string", "kawa.lib.ports");
        this.defProcStFld("open-output-string", "kawa.lib.ports");
        this.defProcStFld("get-output-string", "kawa.lib.ports");
        this.defProcStFld("open-input-bytevector", "kawa.lib.ports");
        this.defProcStFld("open-output-bytevector", "kawa.lib.ports");
        this.defProcStFld("get-output-bytevector", "kawa.lib.ports");
        this.defProcStFld("call-with-output-string", "kawa.lib.ports");
        this.defProcStFld("flush-output-port", "kawa.lib.ports");
        this.defProcStFld("force-output", "kawa.lib.ports");
        this.defProcStFld("port-line", "kawa.lib.ports");
        this.defProcStFld("set-port-line!", "kawa.lib.ports");
        this.defProcStFld("port-column", "kawa.lib.ports");
        this.defProcStFld("current-error-port", "kawa.lib.ports");
        this.defProcStFld("input-port-line-number", "kawa.lib.ports");
        this.defProcStFld("set-input-port-line-number!", "kawa.lib.ports");
        this.defProcStFld("input-port-column-number", "kawa.lib.ports");
        this.defProcStFld("input-port-read-state", "kawa.lib.ports");
        this.defProcStFld("default-prompter", "kawa.Shell", "defaultPrompter");
        this.defProcStFld("input-port-prompter", "kawa.lib.ports");
        this.defProcStFld("set-input-port-prompter!", "kawa.lib.ports");
        this.defAliasStFld("input-prompt1", "gnu.kawa.io.CheckConsole", "prompt1");
        this.defAliasStFld("input-prompt2", "gnu.kawa.io.CheckConsole", "prompt2");
        this.defProcStFld("base-uri", "kawa.lib.misc");
        this.defProcStFld("domterm-load-stylesheet", "kawa.lib.kawa.domterm");
        this.defProcStFld("syntax-error", "kawa.standard.syntax_error", "syntax_error");
        this.defProcStFld("report-syntax-error", "kawa.lib.prim_syntax");
        r4Environment.setLocked();
        this.environ = r5Environment;
        this.defProcStFld("values", "kawa.lib.misc");
        this.defProcStFld("call-with-values", "gnu.kawa.functions.CallWithValues", "callWithValues");
        this.defSntxStFld("let-values", "kawa.lib.syntax");
        this.defSntxStFld("let*-values", "kawa.lib.syntax");
        this.defSntxStFld("define-values", "kawa.lib.syntax");
        this.defSntxStFld("case-lambda", "kawa.lib.syntax");
        this.defSntxStFld("receive", "gnu.kawa.slib.receive");
        this.defProcStFld("eval", "kawa.lib.scheme.eval");
        this.defProcStFld("repl", "kawa.standard.SchemeCompilation", "repl");
        this.defProcStFld("scheme-report-environment", "kawa.lib.misc");
        this.defProcStFld("environment", "kawa.lib.scheme.eval");
        this.defProcStFld("null-environment", "kawa.lib.misc");
        this.defProcStFld("interaction-environment", "kawa.lib.misc");
        this.defProcStFld("dynamic-wind", "kawa.lib.misc");
        r5Environment.setLocked();
        this.environ = r6Environment;
        this.defProcStFld("vector-map", "kawa.lib.vectors");
        this.defProcStFld("vector-for-each", "kawa.lib.vectors");
        this.defProcStFld("string-map", "kawa.lib.strings");
        this.defProcStFld("srfi-13-string-for-each", "kawa.lib.strings");
        this.defProcStFld("string-for-each", "kawa.lib.strings");
        this.defProcStFld("real-valued?", "kawa.lib.numbers");
        this.defProcStFld("rational-valued?", "kawa.lib.numbers");
        this.defProcStFld("integer-valued?", "kawa.lib.numbers");
        this.defProcStFld("finite?", "kawa.lib.numbers");
        this.defProcStFld("infinite?", "kawa.lib.numbers");
        this.defProcStFld("nan?", "kawa.lib.numbers");
        this.defProcStFld("exact-integer-sqrt", "kawa.lib.numbers");
        r6Environment.setLocked();
        this.environ = kawaEnvironment;
        this.defSntxStFld("define-private", "kawa.lib.prim_syntax");
        this.defSntxStFld("define-constant", "kawa.lib.prim_syntax");
        this.defSntxStFld("define-early-constant", "kawa.lib.prim_syntax");
        this.defSntxStFld("define-autoload", "kawa.standard.define_autoload", "define_autoload");
        this.defSntxStFld("define-autoloads-from-file", "kawa.standard.define_autoload", "define_autoloads_from_file");
        this.defProcStFld("exit", "kawa.lib.rnrs.programs");
        this.defProcStFld("emergency-exit", "kawa.lib.rnrs.programs");
        this.defProcStFld("command-line", "kawa.lib.rnrs.programs");
        this.defAliasStFld("command-line-arguments", "gnu.expr.ApplicationMainSupport", "commandLineArguments");
        this.defProcStFld("bitwise-arithmetic-shift", "gnu.kawa.functions.BitwiseOp", "ashift");
        this.defProcStFld("arithmetic-shift", "gnu.kawa.functions.BitwiseOp", "ashift");
        this.defProcStFld("ash", "gnu.kawa.functions.BitwiseOp", "ashift");
        this.defProcStFld("bitwise-arithmetic-shift-left", "gnu.kawa.functions.BitwiseOp", "ashiftl");
        this.defProcStFld("bitwise-arithmetic-shift-right", "gnu.kawa.functions.BitwiseOp", "ashiftr");
        this.defProcStFld("bitwise-and", "gnu.kawa.functions.BitwiseOp", "and");
        this.defProcStFld("logand", "gnu.kawa.functions.BitwiseOp", "and");
        this.defProcStFld("bitwise-ior", "gnu.kawa.functions.BitwiseOp", "ior");
        this.defProcStFld("logior", "gnu.kawa.functions.BitwiseOp", "ior");
        this.defProcStFld("bitwise-xor", "gnu.kawa.functions.BitwiseOp", "xor");
        this.defProcStFld("logxor", "gnu.kawa.functions.BitwiseOp", "xor");
        this.defProcStFld("bitwise-if", "kawa.lib.numbers");
        this.defProcStFld("bitwise-not", "gnu.kawa.functions.BitwiseOp", "not");
        this.defProcStFld("lognot", "gnu.kawa.functions.BitwiseOp", "not");
        this.defProcStFld("logop", "kawa.lib.numbers");
        this.defProcStFld("bitwise-bit-set?", "kawa.lib.numbers");
        this.defProcStFld("logtest", "kawa.lib.numbers");
        this.defProcStFld("bitwise-bit-count", "kawa.lib.numbers");
        this.defProcStFld("logcount", "kawa.lib.numbers");
        this.defProcStFld("bitwise-copy-bit", "kawa.lib.numbers");
        this.defProcStFld("bitwise-copy-bit-field", "kawa.lib.numbers");
        this.defProcStFld("bitwise-bit-field", "kawa.lib.numbers");
        this.defProcStFld("bit-extract", "kawa.lib.numbers", Language.mangleNameIfNeeded("bitwise-bit-field"));
        this.defProcStFld("bitwise-length", "kawa.lib.numbers");
        this.defProcStFld("integer-length", "kawa.lib.numbers", "bitwise$Mnlength");
        this.defProcStFld("bitwise-first-bit-set", "kawa.lib.numbers");
        this.defProcStFld("bitwise-rotate-bit-field", "kawa.lib.numbers");
        this.defProcStFld("bitwise-reverse-bit-field", "kawa.lib.numbers");
        this.defProcStFld("string-upcase!", "kawa.lib.strings");
        this.defProcStFld("string-downcase!", "kawa.lib.strings");
        this.defProcStFld("string-capitalize!", "kawa.lib.strings");
        this.defProcStFld("string-upcase", "kawa.lib.rnrs.unicode");
        this.defProcStFld("string-downcase", "kawa.lib.rnrs.unicode");
        this.defProcStFld("string-titlecase", "kawa.lib.rnrs.unicode");
        this.defProcStFld("string-foldcase", "kawa.lib.rnrs.unicode");
        this.defProcStFld("string-capitalize", "kawa.lib.strings");
        this.defSntxStFld("primitive-virtual-method", "kawa.standard.prim_method", "virtual_method");
        this.defSntxStFld("primitive-static-method", "kawa.standard.prim_method", "static_method");
        this.defSntxStFld("primitive-interface-method", "kawa.standard.prim_method", "interface_method");
        this.defSntxStFld("primitive-constructor", "kawa.lib.reflection");
        this.defSntxStFld("primitive-op1", "kawa.standard.prim_method", "op1");
        this.defSntxStFld("primitive-get-field", "kawa.lib.reflection");
        this.defSntxStFld("primitive-set-field", "kawa.lib.reflection");
        this.defSntxStFld("primitive-get-static", "kawa.lib.reflection");
        this.defSntxStFld("primitive-set-static", "kawa.lib.reflection");
        this.defSntxStFld("primitive-array-new", "kawa.lib.reflection");
        this.defSntxStFld("primitive-array-get", "kawa.lib.reflection");
        this.defSntxStFld("primitive-array-set", "kawa.lib.reflection");
        this.defSntxStFld("primitive-array-length", "kawa.lib.reflection");
        this.defProcStFld("subtype?", "kawa.lib.reflection");
        this.defProcStFld("primitive-throw", "gnu.kawa.reflect.Throw", "primitiveThrow");
        this.defSntxStFld("try-finally", "kawa.lib.syntax");
        this.defSntxStFld("try-catch", "kawa.lib.prim_syntax");
        this.defProcStFld("throw", "kawa.lib.exceptions");
        this.defProcStFld("catch", "kawa.lib.exceptions");
        this.defProcStFld("error", "kawa.lib.exceptions");
        this.defProcStFld("error-object?", "kawa.lib.exceptions");
        this.defProcStFld("error-object-message", "kawa.lib.exceptions");
        this.defProcStFld("error-object-irritants", "kawa.lib.exceptions");
        this.defProcStFld("file-error?", "kawa.lib.exceptions");
        this.defProcStFld("read-error?", "kawa.lib.exceptions");
        this.defProcStFld("raise", "kawa.lib.exceptions");
        this.defProcStFld("raise-continuable", "kawa.lib.exceptions");
        this.defProcStFld("with-exception-handler", "kawa.lib.exceptions");
        this.defSntxStFld("guard", "kawa.lib.exceptions");
        this.defProcStFld("as", "gnu.kawa.functions.Convert", "as");
        this.defProcStFld("instance?", "kawa.standard.Scheme", "instanceOf");
        this.defSntxStFld("synchronized", "kawa.lib.syntax");
        this.defSntxStFld("object", "kawa.standard.object", "objectSyntax");
        this.defSntxStFld("define-class", "kawa.standard.define_class", "define_class");
        this.defSntxStFld("define-simple-class", "kawa.standard.define_class", "define_simple_class");
        this.defSntxStFld("this", "kawa.standard.thisRef", "thisSyntax");
        this.defProcStFld("make", "gnu.kawa.reflect.Invoke", "make");
        this.defProcStFld("slot-ref", "gnu.kawa.reflect.SlotGet", "slotRef");
        this.defProcStFld("slot-set!", "gnu.kawa.reflect.SlotSet", "set$Mnfield$Ex");
        this.defProcStFld("field", "gnu.kawa.reflect.SlotGet");
        this.defProcStFld("class-methods", "gnu.kawa.reflect.ClassMethods", "classMethods");
        this.defProcStFld("static-field", "gnu.kawa.reflect.SlotGet", "staticField");
        this.defProcStFld("invoke", "gnu.kawa.reflect.Invoke", "invoke");
        this.defProcStFld("invoke-static", "gnu.kawa.reflect.Invoke", "invokeStatic");
        this.defProcStFld("invoke-special", "gnu.kawa.reflect.Invoke", "invokeSpecial");
        this.defSntxStFld("define-macro", "kawa.lib.syntax");
        this.defSntxStFld("%define-macro", "kawa.standard.define_syntax", "define_macro");
        this.defSntxStFld("define-syntax-case", "kawa.lib.syntax");
        this.defSntxStFld("syntax-case", "kawa.standard.syntax_case", "syntax_case");
        this.defSntxStFld("define-rewrite-syntax", "kawa.standard.define_syntax", "define_rewrite_syntax");
        this.defSntxStFld("syntax", "kawa.standard.syntax", "syntax");
        this.defSntxStFld("quasisyntax", "kawa.standard.syntax", "quasiSyntax");
        this.defProcStFld("syntax->datum", "kawa.lib.std_syntax");
        this.defProcStFld("syntax-object->datum", "kawa.lib.std_syntax");
        this.defProcStFld("datum->syntax-object", "kawa.lib.std_syntax");
        this.defProcStFld("datum->syntax", "kawa.lib.std_syntax");
        this.defProcStFld("syntax->expression", "kawa.lib.prim_syntax");
        this.defProcStFld("syntax-body->expression", "kawa.lib.prim_syntax");
        this.defProcStFld("generate-temporaries", "kawa.lib.std_syntax");
        this.defSntxStFld("with-syntax", "kawa.lib.std_syntax");
        this.defProcStFld("identifier?", "kawa.lib.std_syntax");
        this.defProcStFld("free-identifier=?", "kawa.lib.std_syntax");
        this.defProcStFld("bound-identifier=?", "kawa.lib.std_syntax");
        this.defProcStFld("syntax-source", "kawa.lib.std_syntax");
        this.defProcStFld("syntax-line", "kawa.lib.std_syntax");
        this.defProcStFld("syntax-column", "kawa.lib.std_syntax");
        this.defSntxStFld("begin-for-syntax", "kawa.lib.syntax");
        this.defSntxStFld("define-for-syntax", "kawa.lib.syntax");
        this.defSntxStFld("include", "kawa.standard.Include", "include");
        this.defSntxStFld("include-relative", "kawa.standard.Include", "includeRelative");
        this.defSntxStFld("include-ci", "kawa.standard.Include", "includeCi");
        this.defProcStFld("file-exists?", "kawa.lib.files");
        this.defProcStFld("file-directory?", "kawa.lib.files");
        this.defProcStFld("file-readable?", "kawa.lib.files");
        this.defProcStFld("file-writable?", "kawa.lib.files");
        this.defProcStFld("delete-file", "kawa.lib.files");
        this.defProcStFld("system-tmpdir", "kawa.lib.files");
        this.defProcStFld("make-temporary-file", "kawa.lib.files");
        this.defProcStFld("rename-file", "kawa.lib.files");
        this.defProcStFld("copy-file", "kawa.lib.files");
        this.defProcStFld("create-directory", "kawa.lib.files");
        this.defProcStFld("->pathname", "kawa.lib.files");
        this.define("port-char-encoding", Boolean.TRUE);
        this.define("symbol-read-case", "");
        this.defProcStFld("system", "kawa.lib.system");
        this.defProcStFld("make-process", "kawa.lib.system");
        this.defProcStFld("pipe-process", "kawa.lib.system");
        this.defProcStFld("run-process", "gnu.kawa.functions.RunProcess", "instance");
        this.defProcStFld("process-exit-wait", "kawa.lib.system");
        this.defProcStFld("process-exit-ok?", "kawa.lib.system");
        this.defProcStFld(LispLanguage.constructNamespace.getSymbol("cmd"), "kawa.lib.system", "cmd");
        this.defProcStFld(LispLanguage.constructNamespace.getSymbol("`"), "kawa.lib.system", "cmd");
        this.defProcStFld(LispLanguage.constructNamespace.getSymbol("sh"), "kawa.lib.system", "sh");
        this.defProcStFld("tokenize-string-to-string-array", "kawa.lib.system");
        this.defProcStFld("tokenize-string-using-shell", "kawa.lib.system");
        this.defProcStFld("command-parse", "kawa.lib.system");
        this.defProcStFld("process-command-line-assignments", "kawa.lib.system");
        this.defProcStFld("get-environment-variable", "kawa.lib.system");
        this.defProcStFld("get-environment-variables", "kawa.lib.system");
        this.defProcStFld("current-path", "kawa.lib.ports");
        this.defProcStFld("current-second", "kawa.lib.system");
        this.defProcStFld("current-jiffy", "kawa.lib.system");
        this.defProcStFld("jiffies-per-second", "kawa.lib.system");
        this.defProcStFld("features", "kawa.lib.misc");
        this.defProcStFld("record-accessor", "kawa.lib.reflection");
        this.defProcStFld("record-modifier", "kawa.lib.reflection");
        this.defProcStFld("record-predicate", "kawa.lib.reflection");
        this.defProcStFld("record-constructor", "kawa.lib.reflection");
        this.defProcStFld("make-record-type", "kawa.lib.reflection");
        this.defProcStFld("record-type-descriptor", "kawa.lib.reflection");
        this.defProcStFld("record-type-name", "kawa.lib.reflection");
        this.defProcStFld("record-type-field-names", "kawa.lib.reflection");
        this.defProcStFld("record?", "kawa.lib.reflection");
        this.defSntxStFld("define-record-type", "kawa.lib.DefineRecordType");
        this.defSntxStFld("when", "kawa.lib.syntax");
        this.defSntxStFld("unless", "kawa.lib.syntax");
        this.defSntxStFld("fluid-let", "kawa.standard.fluid_let", "fluid_let");
        this.defSntxStFld("constant-fold", "kawa.standard.constant_fold", "constant_fold");
        this.defProcStFld("make-parameter", "kawa.lib.parameters");
        this.defSntxStFld("parameterize", "kawa.lib.parameterize");
        this.defProcStFld("compile-file", "kawa.lib.system");
        this.defProcStFld("environment-bound?", "kawa.lib.misc");
        this.defProcStFld("scheme-implementation-version", "kawa.lib.misc");
        this.defProcStFld("scheme-window", "kawa.lib.windows");
        this.defSntxStFld("define-procedure", "kawa.lib.std_syntax");
        this.defProcStFld("add-procedure-properties", "kawa.lib.misc");
        this.defProcStFld("make-procedure", "gnu.kawa.functions.MakeProcedure", "makeProcedure");
        this.defProcStFld("procedure-property", "kawa.lib.misc");
        this.defProcStFld("set-procedure-property!", "kawa.lib.misc");
        this.defSntxStFld("provide", "kawa.lib.misc_syntax");
        this.defSntxStFld("test-begin", "kawa.lib.misc_syntax");
        this.defProcStFld("quantity->number", "kawa.lib.numbers");
        this.defProcStFld("quantity->unit", "kawa.lib.numbers");
        this.defProcStFld("make-quantity", "kawa.lib.numbers");
        this.defSntxStFld("define-namespace", "gnu.kawa.lispexpr.DefineNamespace", "define_namespace");
        this.defSntxStFld("define-xml-namespace", "gnu.kawa.lispexpr.DefineNamespace", "define_xml_namespace");
        this.defSntxStFld("define-private-namespace", "gnu.kawa.lispexpr.DefineNamespace", "define_private_namespace");
        this.defSntxStFld("define-unit", "kawa.standard.define_unit", "define_unit");
        this.defSntxStFld("define-base-unit", "kawa.standard.define_unit", "define_base_unit");
        this.defProcStFld("duration", "kawa.lib.numbers");
        this.defProcStFld("gentemp", "kawa.lib.misc");
        this.defSntxStFld("defmacro", "kawa.lib.syntax");
        this.defProcStFld("setter", "gnu.kawa.functions.Setter", "setter");
        this.defSntxStFld("resource-url", "kawa.lib.misc_syntax");
        this.defSntxStFld("module-uri", "kawa.lib.misc_syntax");
        this.defSntxStFld("future", "kawa.lib.thread");
        this.defProcStFld("sleep", "kawa.lib.thread");
        this.defProcStFld("runnable", "kawa.lib.thread");
        this.defSntxStFld("trace", "kawa.lib.trace");
        this.defSntxStFld("untrace", "kawa.lib.trace");
        this.defSntxStFld("disassemble", "kawa.lib.trace");
        this.defProcStFld("format", "gnu.kawa.functions.Format");
        this.defProcStFld("parse-format", "gnu.kawa.functions.ParseFormat", "parseFormat");
        this.defProcStFld("make-element", "gnu.kawa.xml.MakeElement", "makeElementS");
        this.defProcStFld("make-attribute", "gnu.kawa.xml.MakeAttribute", "makeAttributeS");
        this.defProcStFld("map-values", "gnu.kawa.functions.ValuesMap", "valuesMap");
        this.defProcStFld("children", "gnu.kawa.xml.Children", "children");
        this.defProcStFld("attributes", "gnu.kawa.xml.Attributes");
        this.defProcStFld("unescaped-data", "gnu.kawa.xml.MakeUnescapedData", "unescapedData");
        this.defProcStFld("keyword?", "kawa.lib.keywords");
        this.defProcStFld("keyword->string", "kawa.lib.keywords");
        this.defProcStFld("string->keyword", "kawa.lib.keywords");
        this.defSntxStFld("location", "kawa.standard.location", "location");
        this.defSntxStFld("define-library", "kawa.standard.define_library", "define_library");
        this.defSntxStFld("define-alias", "kawa.standard.define_alias", "define_alias");
        this.defSntxStFld("define-private-alias", "kawa.standard.define_alias", "define_private_alias");
        this.defSntxStFld("define-variable", "kawa.lib.prim_syntax");
        this.defSntxStFld("define-member-alias", "kawa.standard.define_member_alias", "define_member_alias");
        this.defSntxStFld("define-enum", "gnu.kawa.slib.enums");
        this.defSntxStFld("import", "kawa.standard.ImportFromLibrary", "instance");
        this.defSntxStFld("require", "kawa.standard.require", "require");
        this.defSntxStFld("module-name", "kawa.standard.module_name", "module_name");
        this.defSntxStFld("module-extends", "kawa.standard.module_extends", "module_extends");
        this.defSntxStFld("module-implements", "kawa.standard.module_implements", "module_implements");
        this.defSntxStFld("module-static", "kawa.standard.module_static", "module_static");
        this.defSntxStFld("module-export", "kawa.standard.export", "module_export");
        this.defSntxStFld("export", "kawa.standard.export", "export");
        this.defSntxStFld("module-compile-options", "kawa.standard.module_compile_options", "module_compile_options");
        this.defSntxStFld("with-compile-options", "kawa.standard.with_compile_options", "with_compile_options");
        this.defProcStFld("array?", "kawa.lib.arrays");
        this.defProcStFld("array-rank", "kawa.lib.arrays");
        this.defProcStFld("array-size", "kawa.lib.arrays");
        this.defProcStFld("make-array", "kawa.lib.arrays");
        this.defAliasStFld("array", "gnu.kawa.lispexpr.GenArrayType", "generalInstance");
        this.defProcStFld("array-start", "kawa.lib.arrays");
        this.defProcStFld("array-end", "kawa.lib.arrays");
        this.defProcStFld("shape", "kawa.lib.arrays");
        this.defProcStFld("array-ref", "gnu.kawa.functions.ArrayRef", "arrayRef");
        this.defProcStFld("array-set!", "gnu.kawa.functions.ArraySet", "arraySet");
        this.defProcStFld("array-fill!", "kawa.lib.arrays");
        this.defProcStFld("array-copy!", "kawa.lib.arrays");
        this.defProcStFld("share-array", "kawa.lib.arrays");
        this.defProcStFld("array-index-ref", "kawa.lib.arrays");
        this.defProcStFld("array-index-share", "kawa.lib.arrays");
        this.defProcStFld("array-transform", "kawa.lib.arrays");
        this.defProcStFld("array-reshape", "kawa.lib.arrays");
        this.defProcStFld("array-flatten", "kawa.lib.arrays");
        this.defProcStFld("array->vector", "kawa.lib.arrays");
        this.defProcStFld("index-array", "kawa.lib.arrays");
        this.defProcStFld("build-array", "kawa.lib.arrays");
        this.defProcStFld("format-array", "kawa.lib.arrays");
        int i = uniformVectorTags.length;
        while (--i >= 0) {
            String tag = uniformVectorTags[i];
            this.defAliasStFld(tag + "vector", "gnu.kawa.lispexpr.LangObjType", tag + "vectorType");
            this.defProcStFld(tag + "vector?", "kawa.lib.uniform");
            this.defProcStFld("make-" + tag + "vector", "kawa.lib.uniform");
            this.defProcStFld(tag + "vector-length", "kawa.lib.uniform");
            this.defProcStFld(tag + "vector-ref", "kawa.lib.uniform");
            this.defProcStFld(tag + "vector-set!", "kawa.lib.uniform");
            this.defProcStFld(tag + "vector->list", "kawa.lib.uniform");
            this.defProcStFld("list->" + tag + "vector", "kawa.lib.uniform");
        }
        this.defAliasStFld("bytevector", "gnu.kawa.lispexpr.LangObjType", "u8vectorType");
        this.defProcStFld("bytevector?", "kawa.lib.bytevectors");
        this.defProcStFld("make-bytevector", "kawa.lib.bytevectors");
        this.defProcStFld("bytevector-length", "kawa.lib.bytevectors");
        this.defProcStFld("bytevector-u8-ref", "kawa.lib.bytevectors");
        this.defProcStFld("bytevector-u8-set!", "kawa.lib.bytevectors");
        this.defProcStFld("bytevector-copy", "kawa.lib.bytevectors");
        this.defProcStFld("bytevector-copy!", "kawa.lib.bytevectors");
        this.defProcStFld("bytevector-append", "kawa.lib.bytevectors");
        this.defProcStFld("utf8->string", "kawa.lib.bytevectors");
        this.defProcStFld("string->utf8", "kawa.lib.bytevectors");
        this.defSntxStFld("cut", "gnu.kawa.slib.cut");
        this.defSntxStFld("cute", "gnu.kawa.slib.cut");
        this.defSntxStFld("scan", "kawa.standard.Scan", "scan");
        this.defSntxStFld("cond-expand", "kawa.standard.IfFeature", "condExpand");
        this.defAliasStFld("*print-base*", "gnu.kawa.functions.DisplayFormat", "outBase");
        this.defAliasStFld("*print-radix*", "gnu.kawa.functions.DisplayFormat", "outRadix");
        this.defAliasStFld("*print-right-margin*", "gnu.kawa.io.PrettyWriter", "lineLengthLoc");
        this.defAliasStFld("*print-miser-width*", "gnu.kawa.io.PrettyWriter", "miserWidthLoc");
        this.defAliasStFld("*print-circle*", "gnu.kawa.io.PrettyWriter", "isSharing");
        this.defAliasStFld("*print-xml-indent*", "gnu.xml.XMLPrinter", "indentLoc");
        this.defAliasStFld("html", "gnu.kawa.xml.XmlNamespace", "HTML");
        this.defAliasStFld("unit", "gnu.kawa.lispexpr.LispLanguage", "unitNamespace");
        this.defAliasStFld("$entity$", "gnu.kawa.lispexpr.LispLanguage", "entityNamespace");
        this.defAliasStFld("$construct$", "gnu.kawa.lispexpr.LispLanguage", "constructNamespace");
        this.defAliasStFld("dynamic", "gnu.kawa.lispexpr.LangObjType", "dynamicType");
        this.defAliasStFld("path", "gnu.kawa.lispexpr.LangObjType", "pathType");
        this.defAliasStFld("filepath", "gnu.kawa.lispexpr.LangObjType", "filepathType");
        this.defAliasStFld("URI", "gnu.kawa.lispexpr.LangObjType", "URIType");
        this.defProcStFld("resolve-uri", "kawa.lib.files");
        this.defAliasStFld("sequence", "gnu.kawa.lispexpr.LangObjType", "sequenceType");
        this.defAliasStFld("constant-vector", "gnu.kawa.lispexpr.LangObjType", "constVectorType");
        this.defAliasStFld("vector", "gnu.kawa.lispexpr.LangObjType", "vectorType");
        this.defAliasStFld("string", "gnu.kawa.lispexpr.LangObjType", "stringType");
        this.defAliasStFld("list", "gnu.kawa.lispexpr.LangObjType", "listType");
        this.defAliasStFld("regex", "gnu.kawa.lispexpr.LangObjType", "regexType");
        this.defProcStFld("path?", "kawa.lib.files");
        this.defProcStFld("filepath?", "kawa.lib.files");
        this.defProcStFld("URI?", "kawa.lib.files");
        this.defProcStFld("absolute-path?", "kawa.lib.files");
        this.defProcStFld("path-scheme", "kawa.lib.files");
        this.defProcStFld("path-authority", "kawa.lib.files");
        this.defProcStFld("path-user-info", "kawa.lib.files");
        this.defProcStFld("path-host", "kawa.lib.files");
        this.defProcStFld("path-port", "kawa.lib.files");
        this.defProcStFld("path-file", "kawa.lib.files");
        this.defProcStFld("path-parent", "kawa.lib.files");
        this.defProcStFld("path-directory", "kawa.lib.files");
        this.defProcStFld("path-last", "kawa.lib.files");
        this.defProcStFld("path-extension", "kawa.lib.files");
        this.defProcStFld("path-fragment", "kawa.lib.files");
        this.defProcStFld("path-query", "kawa.lib.files");
        this.defProcStFld("path-bytes", "kawa.lib.files");
        this.defProcStFld("path-data", "kawa.lib.files");
        this.defProcStFld(LispLanguage.constructNamespace.getSymbol("PD"), "kawa.lib.files", "PD");
        this.defProcStFld(LispLanguage.constructNamespace.getSymbol("<"), "kawa.lib.files", "PD");
        this.defProcStFld(LispLanguage.constructNamespace.getSymbol(">"), "kawa.lib.files", "set_PD");
        this.defProcStFld(LispLanguage.constructNamespace.getSymbol(">>"), "kawa.lib.files", "append_PD");
        this.defProcStFld("annotation", "gnu.kawa.reflect.MakeAnnotation", "instance");
        kawaEnvironment.setLocked();
        int withServlets = HttpRequestContext.importServletDefinitions;
        if (withServlets > 0) {
            try {
                this.loadClass(withServlets > 1 ? "gnu.kawa.servlet.servlets" : "gnu.kawa.servlet.HTTP");
            }
            catch (Exception ex) {
                // empty catch block
            }
        }
    }

    public Scheme() {
        this.environ = kawaEnvironment;
        this.userEnv = this.getNewEnvironment();
    }

    protected Scheme(Environment env) {
        this.environ = env;
    }

    @Override
    public String getName() {
        switch (this.standardToFollow) {
            case 5: {
                return "Scheme-r5rs";
            }
            case 6: {
                return "Scheme-r6rs";
            }
            case 7: {
                return "Scheme-r7rs";
            }
        }
        return "Scheme";
    }

    @Override
    public String getCompilationClass() {
        return "kawa.standard.SchemeCompilation";
    }

    public static Object eval(String string, Environment env) {
        return Scheme.eval(new CharArrayInPort(string), env);
    }

    public static Object eval(InPort port, Environment env) {
        SourceMessages messages = new SourceMessages();
        try {
            LispReader lexer = (LispReader)Language.getDefaultLanguage().getLexer(port, messages);
            Object body = ReaderParens.readList(lexer, null, 0, 1, -1, -1);
            if (messages.seenErrors()) {
                throw new SyntaxException(messages);
            }
            return Eval.evalBody(body, env, messages);
        }
        catch (SyntaxException e) {
            throw new RuntimeException("eval: errors while compiling:\n" + e.getMessages().toString(20));
        }
        catch (IOException e) {
            throw new RuntimeException("eval: I/O exception: " + e.toString());
        }
        catch (Throwable ex) {
            throw WrappedException.rethrow(ex);
        }
    }

    public static Object eval(Object sexpr, Environment env) {
        try {
            return Eval.eval(sexpr, env);
        }
        catch (Throwable ex) {
            throw WrappedException.rethrow(ex);
        }
    }

    @Override
    public AbstractFormat getFormat(boolean readable) {
        return readable ? DisplayFormat.schemeWriteFormat : DisplayFormat.schemeDisplayFormat;
    }

    @Override
    public LispReader getLexer(InPort inp, SourceMessages messages) {
        LispReader reader = super.getLexer(inp, messages);
        if (reader.getReadCase() == '\u0000' && this.standardToFollow == 5) {
            reader.setReadCase('D');
        }
        return reader;
    }

    @Override
    public int getNamespaceOf(Declaration decl) {
        return 3;
    }

    public static Type getTypeValue(Expression exp) {
        return Scheme.getInstance().getTypeFor(exp);
    }

    @Override
    protected synchronized HashMap<String, Type> getTypeMap() {
        if (this.types == null) {
            this.types = new HashMap(128);
            this.types.put("boolean", booleanType);
            this.types.put("parameter", Compilation.typeLocationProc);
            this.types.putAll(super.getTypeMap());
            int i = uniformVectorTags.length;
            while (--i >= 0) {
                String tag = uniformVectorTags[i];
                String cname = "gnu.lists." + tag.toUpperCase() + "Vector";
                this.types.put(tag + "vector", ClassType.make(cname));
            }
        }
        return this.types;
    }

    @Override
    public String formatType(Type type) {
        String str;
        if (type instanceof LazyType) {
            LazyType ltype = (LazyType)type;
            return this.formatType(ltype.getRawType()) + '[' + this.formatType(ltype.getValueType()) + ']';
        }
        if (type instanceof MultValuesType) {
            MultValuesType mtype = (MultValuesType)type;
            StringBuilder sbuf = new StringBuilder();
            sbuf.append("values[");
            int n = mtype.getValueCount();
            for (int i = 0; i < n; ++i) {
                Type etype;
                if (i > 0) {
                    sbuf.append(' ');
                }
                sbuf.append((etype = mtype.getValueType(i)) == null ? "unspecified" : this.formatType(etype));
            }
            sbuf.append(']');
            return sbuf.toString();
        }
        if (type instanceof GenArrayType) {
            Type elementType;
            GenArrayType atype = (GenArrayType)type;
            StringBuilder sbuf = new StringBuilder("array");
            int rank = atype.rank();
            if (rank >= 0) {
                sbuf.append(rank);
            }
            if ((elementType = atype.getComponentType()) != null && elementType != Type.objectType) {
                sbuf.append('[');
                sbuf.append(this.formatType(elementType));
                sbuf.append(']');
            }
            return sbuf.toString();
        }
        if (this.typeToStringMap == null) {
            this.typeToStringMap = new HashMap();
            for (Map.Entry<String, Type> e : this.getTypeMap().entrySet()) {
                this.typeToStringMap.put(e.getValue(), e.getKey());
            }
        }
        if ((str = this.typeToStringMap.get(type)) != null) {
            return str;
        }
        return super.formatType(type);
    }

    public static Type exp2Type(Expression exp) {
        return Scheme.getInstance().getTypeFor(exp);
    }

    public Symbol asSymbol(String ident) {
        return Namespace.EmptyNamespace.getSymbol(ident);
    }

    public boolean appendBodyValues() {
        return false;
    }

    @Override
    public boolean keywordsAreSelfEvaluating() {
        return false;
    }

    @Override
    public ReadTable createReadTable() {
        ReadTable tab = ReadTable.createInitial();
        int std = this.standardToFollow;
        ReaderDispatch dispatchTable = (ReaderDispatch)tab.lookup(35);
        ReaderDispatchSyntaxQuote sentry = new ReaderDispatchSyntaxQuote();
        dispatchTable.set(39, sentry);
        dispatchTable.set(96, sentry);
        dispatchTable.set(44, sentry);
        tab.putReaderCtorFld("path", "gnu.kawa.lispexpr.LangObjType", "pathType");
        tab.putReaderCtorFld("filepath", "gnu.kawa.lispexpr.LangObjType", "filepathType");
        tab.putReaderCtorFld("URI", "gnu.kawa.lispexpr.LangObjType", "URIType");
        tab.putReaderCtor("symbol", ClassType.make("gnu.mapping.Symbol"));
        tab.putReaderCtor("namespace", ClassType.make("gnu.mapping.Namespace"));
        tab.putReaderCtorFld("duration", "kawa.lib.numbers", "duration");
        if (std != 5 && std != 6 && std != 7) {
            tab.postfixLookupOperator = (char)58;
            tab.setFinalColonIsKeyword(true);
            tab.extraFlags = 8;
            tab.set(64, new ReaderQuote(LispLanguage.splice_sym, 6));
        }
        return tab;
    }

    public static void registerEnvironment() {
        Language.setDefaults(Scheme.getInstance());
    }

    static {
        instance.initScheme();
    }
}

