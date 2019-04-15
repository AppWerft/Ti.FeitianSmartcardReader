/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.slib;

import gnu.bytecode.ClassType;
import gnu.bytecode.Field;
import gnu.bytecode.Type;
import gnu.expr.ApplyExp;
import gnu.expr.BeginExp;
import gnu.expr.ClassExp;
import gnu.expr.Compilation;
import gnu.expr.Declaration;
import gnu.expr.Expression;
import gnu.expr.IfExp;
import gnu.expr.KawaConvert;
import gnu.expr.Keyword;
import gnu.expr.LambdaExp;
import gnu.expr.Language;
import gnu.expr.LetExp;
import gnu.expr.ModuleBody;
import gnu.expr.ModuleExp;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.expr.NameLookup;
import gnu.expr.QuoteExp;
import gnu.expr.ReferenceExp;
import gnu.expr.SetExp;
import gnu.expr.Special;
import gnu.kawa.functions.Convert;
import gnu.kawa.functions.Format;
import gnu.kawa.functions.GetNamedPart;
import gnu.kawa.functions.IsEqv;
import gnu.kawa.functions.NumberCompare;
import gnu.kawa.lispexpr.LangObjType;
import gnu.lists.Consumer;
import gnu.lists.EmptyList;
import gnu.lists.EofClass;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.lists.PairWithPosition;
import gnu.mapping.CallContext;
import gnu.mapping.Environment;
import gnu.mapping.Procedure;
import gnu.mapping.Promise;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Symbol;
import gnu.mapping.Values;
import gnu.mapping.WrongType;
import gnu.math.IntNum;
import gnu.math.Numeric;
import gnu.text.Char;
import gnu.text.Lexer;
import gnu.text.SourceMessages;
import kawa.lang.Macro;
import kawa.lang.Quote;
import kawa.lang.SyntaxPattern;
import kawa.lang.SyntaxRule;
import kawa.lang.SyntaxRules;
import kawa.lang.Translator;
import kawa.lib.exceptions;
import kawa.lib.lists;
import kawa.lib.misc;
import kawa.lib.numbers;

public class syntaxutils
extends ModuleBody {
    public static final ModuleMethod expand;
    public static final Macro $Prvt$typecase$Pc;
    public static final Macro $Prvt$$Ex;
    static final Keyword Lit0;
    static final PairWithPosition Lit1;
    static final Keyword Lit2;
    static final PairWithPosition Lit3;
    static final PairWithPosition Lit4;
    static final PairWithPosition Lit5;
    static final IntNum Lit6;
    static final IntNum Lit7;
    static final PairWithPosition Lit8;
    static final PairWithPosition Lit9;
    static final PairWithPosition Lit10;
    static final PairWithPosition Lit11;
    static final PairWithPosition Lit12;
    static final PairWithPosition Lit13;
    static final SimpleSymbol Lit14;
    static final PairWithPosition Lit15;
    static final PairWithPosition Lit16;
    static final PairWithPosition Lit17;
    static final PairWithPosition Lit18;
    static final PairWithPosition Lit19;
    static final PairWithPosition Lit20;
    public static syntaxutils $instance;
    static final SimpleSymbol Lit21;
    static final SyntaxRules Lit22;
    static final SimpleSymbol Lit23;
    static final SyntaxRules Lit24;
    static final SimpleSymbol Lit25;
    static final Object[] Lit26;
    static final SimpleSymbol Lit27;
    static final SimpleSymbol Lit28;
    static final SimpleSymbol Lit29;
    static final Object[] Lit30;
    static final SimpleSymbol Lit31;
    static final SimpleSymbol Lit32;
    static final SimpleSymbol Lit33;
    static final SimpleSymbol Lit34;
    static final SimpleSymbol Lit35;
    static final SimpleSymbol Lit36;

    private static void $runBody$() {
        CallContext $ctx = CallContext.getInstance();
        Consumer $result = $ctx.consumer;
    }

    public static Object expand$V(Object sexp, Object[] argsArray) {
        Object object2 = Keyword.searchForKeyword(argsArray, 0, Lit0);
        if (object2 == Special.dfault) {
            object2 = misc.interactionEnvironment();
        }
        Object env = object2;
        return syntaxutils.unrewrite(syntaxutils.rewriteForm$V(Quote.append$V(new Object[]{Lit1, Quote.consX$V(new Object[]{sexp, LList.Empty})}), new Object[]{Lit0, env}));
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    static Object unrewrite(Expression exp) {
        Object object2;
        IfExp exp10;
        Expression eclause2222;
        if (exp instanceof LetExp) {
            Expression expression = exp;
            LetExp exp2 = (LetExp)expression;
            object2 = syntaxutils.unrewriteLet(exp2);
            return object2;
        }
        if (exp instanceof QuoteExp) {
            Expression expression = exp;
            QuoteExp exp3 = (QuoteExp)expression;
            object2 = syntaxutils.unrewriteQuote(exp3);
            return object2;
        }
        if (exp instanceof SetExp) {
            Expression expression = exp;
            SetExp exp4 = (SetExp)expression;
            object2 = Quote.append$V(new Object[]{Lit3, Quote.consX$V(new Object[]{exp4.getSymbol(), Quote.consX$V(new Object[]{syntaxutils.unrewrite(exp4.getNewValue()), LList.Empty})})});
            return object2;
        }
        if (exp instanceof ClassExp) {
            Expression expression = exp;
            ClassExp exp5 = (ClassExp)expression;
            object2 = syntaxutils.unrewriteClass(exp5);
            return object2;
        }
        if (exp instanceof LambdaExp) {
            Expression expression = exp;
            LambdaExp exp6 = (LambdaExp)expression;
            object2 = Quote.append$V(new Object[]{Lit4, Quote.consX$V(new Object[]{syntaxutils.unrewriteArglist(exp6), Quote.consX$V(new Object[]{syntaxutils.unrewrite(exp6.body), LList.Empty})})});
            return object2;
        }
        if (exp instanceof ReferenceExp) {
            Expression expression = exp;
            ReferenceExp exp7 = (ReferenceExp)expression;
            object2 = exp7.getSymbol();
            return object2;
        }
        if (exp instanceof ApplyExp) {
            Expression expression = exp;
            ApplyExp exp8 = (ApplyExp)expression;
            object2 = syntaxutils.unrewriteApply(exp8);
            return object2;
        }
        if (exp instanceof BeginExp) {
            Expression expression = exp;
            BeginExp exp9 = (BeginExp)expression;
            object2 = Quote.append$V(new Object[]{Lit1, syntaxutils.unrewrite$St(exp9.getExpressions())});
            return object2;
        }
        if (!(exp instanceof IfExp)) {
            object2 = exp;
            return object2;
        }
        Expression expression = exp;
        try {
            exp10 = (IfExp)expression;
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "exp", -2, (Object)eclause2222);
        }
        Object[] arrobject = new Object[2];
        arrobject[0] = Lit5;
        Object[] arrobject2 = new Object[2];
        arrobject2[0] = syntaxutils.unrewrite(exp10.getTest());
        Object[] arrobject3 = new Object[2];
        arrobject3[0] = syntaxutils.unrewrite(exp10.getThenClause());
        Object[] arrobject4 = new Object[2];
        eclause2222 = exp10.getElseClause();
        arrobject4[0] = eclause2222 == null ? LList.Empty : LList.list1(syntaxutils.unrewrite(eclause2222));
        arrobject4[1] = LList.Empty;
        arrobject3[1] = Quote.append$V(arrobject4);
        arrobject2[1] = Quote.consX$V(arrobject3);
        arrobject[1] = Quote.consX$V(arrobject2);
        object2 = Quote.append$V(arrobject);
        return object2;
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "exp", -2, (Object)eclause2222);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "exp", -2, (Object)eclause2222);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "exp", -2, (Object)eclause2222);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "exp", -2, (Object)eclause2222);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "exp", -2, (Object)eclause2222);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "exp", -2, (Object)eclause2222);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "exp", -2, (Object)eclause2222);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "exp", -2, (Object)eclause2222);
        }
    }

    static Expression rewriteForm$V(Object exp, Object[] argsArray) {
        Compilation saved$Mncomp;
        Expression expression;
        Translator translator;
        Language lang;
        SourceMessages messages;
        NameLookup namelookup;
        Object object2 = Keyword.searchForKeyword(argsArray, 0, Lit2);
        if (object2 == Special.dfault) {
            object2 = Language.getDefaultLanguage();
        }
        Object object3 = Promise.force(object2, Language.class);
        try {
            lang = (Language)object3;
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "rewrite-form", 2, (Object)namelookup);
        }
        Object object4 = Keyword.searchForKeyword(argsArray, 0, Lit0);
        if (object4 == Special.dfault) {
            object4 = misc.interactionEnvironment();
        }
        Object env = object4;
        Object object5 = Promise.force(env, Environment.class);
        try {
            namelookup = NameLookup.getInstance((Environment)object5, lang);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "gnu.expr.NameLookup.getInstance(gnu.mapping.Environment,gnu.expr.Language)", 1, (Object)messages);
        }
        messages = new SourceMessages();
        Compilation compilation = lang.getCompilation(messages, namelookup);
        try {
            translator = (Translator)compilation;
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "translator", -2, (Object)saved$Mncomp);
        }
        translator.pushNewModule(null);
        saved$Mncomp = Compilation.setSaveCurrent(translator);
        try {
            expression = translator.rewrite(exp);
            Object var10_9 = null;
        }
        catch (Throwable throwable) {
            Object var10_10 = null;
            Compilation.restoreCurrent(saved$Mncomp);
            throw throwable;
        }
        Compilation.restoreCurrent(saved$Mncomp);
        {
        }
        return expression;
    }

    static Object unrewriteLet(LetExp exp) {
        IntNum i;
        Declaration decl;
        Object[] arrobject = new Object[2];
        arrobject[0] = Lit11;
        Object[] arrobject2 = new Object[2];
        LList pack = LList.Empty;
        Declaration declaration = exp.firstDecl();
        IntNum intNum = i = Lit6;
        while ((decl = declaration) != null) {
            Pair v = LList.list2(decl.getSymbol(), syntaxutils.unrewrite(decl.getInitValue()));
            pack = lists.cons(v, pack);
            declaration = decl.nextDecl();
            intNum = IntNum.add(i, 1);
        }
        arrobject2[0] = lists.reverse$Ex(pack);
        arrobject2[1] = Quote.consX$V(new Object[]{syntaxutils.unrewrite(exp.getBody()), LList.Empty});
        arrobject[1] = Quote.consX$V(arrobject2);
        return Quote.append$V(arrobject);
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    static Object unrewriteQuote(QuoteExp exp) {
        Object val;
        Object object2;
        void name2222;
        block33 : {
            String string;
            Object name2222;
            block32 : {
                Class val2;
                block31 : {
                    Type val22;
                    block30 : {
                        Object val3;
                        Object object3;
                        block25 : {
                            block29 : {
                                block28 : {
                                    block27 : {
                                        block26 : {
                                            int val4;
                                            block24 : {
                                                boolean val5;
                                                val = exp.getValue();
                                                if (Numeric.asNumericOrNull(val) != null) {
                                                    Object object4 = Promise.force(val, Numeric.class);
                                                    Numeric val6 = LangObjType.coerceNumeric(object4);
                                                    object3 = val6;
                                                }
                                                if (!(val instanceof Boolean)) break block24;
                                                val3 = Promise.force(val);
                                                try {
                                                    boolean bl = val5 = KawaConvert.isTrue(val3);
                                                }
                                                catch (ClassCastException classCastException) {
                                                    throw new WrongType(classCastException, "val", -2, (Object)name2222);
                                                }
                                                object3 = val5 ? Boolean.TRUE : Boolean.FALSE;
                                                break block25;
                                            }
                                            if (!(val instanceof Char)) break block26;
                                            val3 = Promise.force(val);
                                            try {
                                                val4 = Char.castToCharacter(val3);
                                            }
                                            catch (ClassCastException classCastException) {
                                                throw new WrongType(classCastException, "val", -2, (Object)name2222);
                                            }
                                            object3 = Char.make(val4);
                                            break block25;
                                        }
                                        if (val instanceof Keyword) {
                                            val3 = Promise.force(val, Keyword.class);
                                            Keyword val7 = (Keyword)val3;
                                            object3 = val7;
                                        }
                                        if (val instanceof CharSequence) {
                                            val3 = Promise.force(val, CharSequence.class);
                                            CharSequence val8 = (CharSequence)val3;
                                            object3 = val8;
                                        }
                                        if (!IsEqv.apply(val, Special.undefined)) break block27;
                                        object3 = val;
                                        break block25;
                                    }
                                    if (!IsEqv.apply(val, EofClass.eofValue)) break block28;
                                    object3 = val;
                                    break block25;
                                }
                                if (!IsEqv.apply(val, Special.abstractSpecial)) break block29;
                                object3 = val;
                                break block25;
                            }
                            if (!IsEqv.apply(val, Special.nativeSpecial)) break block30;
                            object3 = val;
                        }
                        object2 = val3 = object3;
                        return object2;
                    }
                    if (!(val instanceof Type)) break block31;
                    Object val3 = Promise.force(val, Type.class);
                    try {
                        val22 = (Type)val3;
                    }
                    catch (ClassCastException classCastException) {
                        throw new WrongType(classCastException, "val", -2, name2222);
                    }
                    string = val22.getName();
                    break block32;
                }
                if (!(val instanceof Class)) break block33;
                name2222 = Promise.force(val, Class.class);
                try {
                    val2 = (Class)name2222;
                }
                catch (ClassCastException classCastException) {
                    throw new WrongType(classCastException, "val", -2, name2222);
                }
                string = val2.getName();
            }
            name2222 = string;
            object2 = misc.string$To$Symbol(Format.formatToString(0, "<~a>", name2222));
            return object2;
        }
        if (IsEqv.apply(val, Values.empty)) {
            object2 = exp;
            return object2;
        }
        object2 = Quote.append$V(new Object[]{Lit12, Quote.consX$V(new Object[]{val, LList.Empty})});
        return object2;
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "val", -2, (Object)name2222);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "val", -2, (Object)name2222);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "val", -2, (Object)name2222);
        }
    }

    static Object unrewriteClass(ClassExp exp) {
        return Quote.append$V(new Object[]{Lit13, Quote.consX$V(new Object[]{syntaxutils.unrewrite$St(exp.supers), Quote.append$V(new Object[]{syntaxutils.lambda1loop(exp.firstDecl()), Quote.append$V(new Object[]{syntaxutils.lambda2loop(exp.firstChild), LList.Empty})})})});
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    static Object unrewriteArglist(LambdaExp exp) {
        Object decl;
        IntNum intNum;
        Object object2;
        Object object3;
        int min = exp.min_args;
        boolean rest$Qu = numbers.isNegative(IntNum.make(exp.max_args));
        boolean key$Qu = exp.keywords != null;
        int opt = exp.opt_args;
        LList required = LList.Empty;
        LList optional = LList.Empty;
        LList key = LList.Empty;
        Object rest = Boolean.FALSE;
        Declaration declaration = exp.firstDecl();
        IntNum intNum2 = intNum = Lit6;
        while ((decl = declaration) != null) {
            void i;
            Object var = ((Declaration)decl).getSymbol();
            if (IntNum.compare((IntNum)i, min) < 0) {
                required = lists.cons(var, required);
            } else if (IntNum.compare((IntNum)i, (long)min + (long)opt) < 0) {
                optional = lists.cons(var, optional);
            } else if (rest$Qu && IntNum.compare((IntNum)i, (long)min + (long)opt) == 0) {
                rest = var;
            } else if (key$Qu && IntNum.compare((IntNum)i, IntNum.add(IntNum.add(rest$Qu ? Lit7 : Lit6, min + opt), exp.keywords.length)) < 0) {
                key = lists.cons(var, key);
            } else {
                boolean x = ((Declaration)decl).isThisParameter();
                if (!x) {
                    Type.NeverReturns neverReturns = exceptions.error("nyi");
                    throw Special.reachedUnexpected;
                }
            }
            declaration = ((Declaration)decl).nextDecl();
            intNum2 = IntNum.add((IntNum)i, 1);
        }
        Object[] arrobject = new Object[2];
        decl = Promise.force(required, LList.class);
        try {
            arrobject[0] = lists.reverse((LList)decl);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "reverse", 1, decl);
        }
        Object[] arrobject2 = new Object[2];
        if (numbers.isZero(opt)) {
            object3 = LList.Empty;
        } else {
            Object[] arrobject3 = new Object[2];
            arrobject3[0] = Lit8;
            decl = Promise.force(optional, LList.class);
            arrobject3[1] = lists.reverse((LList)decl);
            object3 = Quote.append$V(arrobject3);
        }
        arrobject2[0] = object3;
        Object[] arrobject4 = new Object[2];
        arrobject4[0] = rest$Qu ? Quote.append$V(new Object[]{Lit9, Quote.consX$V(new Object[]{rest, LList.Empty})}) : LList.Empty;
        Object[] arrobject5 = new Object[2];
        if (key$Qu) {
            Object[] arrobject6 = new Object[2];
            arrobject6[0] = Lit10;
            decl = Promise.force(key, LList.class);
            arrobject6[1] = lists.reverse((LList)decl);
            object2 = Quote.append$V(arrobject6);
        } else {
            object2 = LList.Empty;
        }
        arrobject5[0] = object2;
        arrobject5[1] = LList.Empty;
        arrobject4[1] = Quote.append$V(arrobject5);
        arrobject2[1] = Quote.append$V(arrobject4);
        arrobject[1] = Quote.append$V(arrobject2);
        return Quote.append$V(arrobject);
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "reverse", 1, decl);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "reverse", 1, decl);
        }
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    static Object unrewriteApply(ApplyExp exp) {
        Declaration declaration;
        Object object2;
        Boolean x;
        Expression fun = exp.getFunction();
        LList args = syntaxutils.unrewrite$St(exp.getArgs());
        if (fun instanceof ReferenceExp) {
            Expression expression = fun;
            ReferenceExp fun2 = (ReferenceExp)expression;
            declaration = fun2.getBinding();
        } else {
            declaration = null;
        }
        Declaration fbinding = declaration;
        Declaration apply$Mnto$Mnargs = Declaration.getDeclarationFromStatic("kawa.standard.Scheme", "applyToArgs");
        Object fval = exp.getFunctionValue();
        if (fbinding != null && apply$Mnto$Mnargs != null && fbinding.field == apply$Mnto$Mnargs.field) {
            object2 = args;
            return object2;
        }
        Object object3 = fval instanceof Convert ? Quote.append$V(new Object[]{Lit19, args}) : (fval instanceof GetNamedPart ? Quote.append$V(new Object[]{Lit20, args}) : (x = Boolean.FALSE));
        if (KawaConvert.isTrue(x)) {
            object2 = x;
            return object2;
        }
        object2 = Quote.consX$V(new Object[]{syntaxutils.unrewrite(fun), args});
        return object2;
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "fun", -2, fval);
        }
    }

    static LList unrewrite$St(Expression[] exps) {
        LList pack = LList.Empty;
        IntNum i = Lit6;
        Integer len = exps.length;
        while (!NumberCompare.$Eq(i, len)) {
            Object v = syntaxutils.unrewrite(exps[((Number)i).intValue()]);
            pack = lists.cons(v, pack);
            i = IntNum.add(i, 1);
        }
        return lists.reverse$Ex(pack);
    }

    public static Object lambda1loop(Declaration decl) {
        LList lList;
        block2 : {
            do {
                if (decl == null) {
                    lList = LList.Empty;
                    break block2;
                }
                if (decl.getType() != Compilation.typeProcedure) break;
                decl = decl.nextDecl();
            } while (true);
            lList = lists.cons(LList.list3(decl.getSymbol(), Lit14, decl.getType()), syntaxutils.lambda1loop(decl.nextDecl()));
        }
        return lList;
    }

    public static Object lambda2loop(LambdaExp child) {
        return child == null ? LList.Empty : lists.cons(syntaxutils.unrewriteMethod(child), syntaxutils.lambda2loop(child.nextSibling));
    }

    static Pair unrewriteMethod(LambdaExp exp) {
        boolean x;
        Declaration decl = exp.nameDecl;
        String name = exp.getName();
        boolean bl = x = decl != null ? decl.getFlag(Declaration.STATIC_SPECIFIED) : false;
        boolean static$Qu = x ? x : name == "$clinit$";
        boolean private$Qu = decl != null ? decl.getFlag(Declaration.PRIVATE_ACCESS) : false;
        boolean protected$Qu = decl != null ? decl.getFlag(Declaration.PROTECTED_ACCESS) : false;
        Object[] arrobject = new Object[2];
        arrobject[0] = static$Qu ? Lit15 : LList.Empty;
        Object[] arrobject2 = new Object[2];
        arrobject2[0] = (private$Qu ? private$Qu : protected$Qu) ? Quote.append$V(new Object[]{Lit16, Quote.consX$V(new Object[]{private$Qu ? Lit17 : Lit18, LList.Empty})}) : LList.Empty;
        arrobject2[1] = Quote.consX$V(new Object[]{syntaxutils.unrewrite(exp.body), LList.Empty});
        arrobject[1] = Quote.append$V(arrobject2);
        return Pair.make(Quote.consX$V(new Object[]{name, Quote.append$V(new Object[]{syntaxutils.unrewriteArglist(exp), LList.Empty})}), Quote.append$V(arrobject));
    }

    public static {
        Lit36 = Symbol.valueOf("lambda");
        Lit35 = Symbol.valueOf("as");
        Lit34 = Symbol.valueOf("else");
        Lit33 = Symbol.valueOf("let");
        Lit32 = Symbol.valueOf("cond");
        Lit31 = Symbol.valueOf("begin");
        Object[] arrobject = new Object[1];
        Lit30 = arrobject;
        Lit29 = Symbol.valueOf("or");
        arrobject[0] = Lit29;
        Lit28 = Symbol.valueOf("quote");
        Lit27 = Symbol.valueOf("eql");
        Lit26 = new Object[0];
        Lit25 = Symbol.valueOf("expand");
        Lit23 = Symbol.valueOf("!");
        Lit24 = new SyntaxRules(Lit26, new SyntaxRule[]{new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\f\u000f\r\u0017\u0010\b\b", Lit26, 3, "syntaxutils.scm:49"), "\u0001\u0001\u0003", "\u0011\u0018\u0004\t\u000b)\u0011\u0018\f\b\u0003\b\u0015\u0013", new Object[]{Symbol.valueOf("invoke"), Lit28}, 1)}, 3, Lit23);
        SyntaxRule[] arrsyntaxRule = new SyntaxRule[6];
        arrsyntaxRule[0] = new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007<\f\u0002\r\u000f\b\b\b\r\u0017\u0010\b\b", new Object[]{Boolean.TRUE}, 3, "syntaxutils.scm:17"), "\u0001\u0003\u0003", "\u0011\u0018\u0004\b\r\u000b", new Object[]{Lit31}, 1);
        Object[] arrobject2 = new Object[5];
        arrobject2[0] = Lit32;
        arrobject2[1] = Symbol.valueOf("eqv?");
        arrobject2[2] = Lit28;
        arrobject2[3] = Lit34;
        Lit21 = Symbol.valueOf("typecase%");
        arrobject2[4] = Lit21;
        arrsyntaxRule[1] = new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\\,\f\u0002\f\u000f\b\r\u0017\u0010\b\b\r\u001f\u0018\b\b", new Object[]{Lit27}, 4, "syntaxutils.scm:19"), "\u0001\u0001\u0003\u0003", "\u0011\u0018\u0004yY\u0011\u0018\f\t\u0003\b\u0011\u0018\u0014\b\u000b\b\u0015\u0013\b\u0011\u0018\u001c\b\u0011\u0018$\t\u0003\b\u001d\u001b", arrobject2, 1);
        arrsyntaxRule[2] = new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\\,\f\u0002\f\u000f\b\r\u0017\u0010\b\b\r\u001f\u0018\b\b", Lit30, 4, "syntaxutils.scm:22"), "\u0001\u0001\u0003\u0003", "\u0011\u0018\u0004\t\u0003)\t\u000b\b\u0015\u0013\b\u001d\u001b", new Object[]{Lit21}, 1);
        arrsyntaxRule[3] = new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007l<\f\u0002\r\u000f\b\b\b\r\u0017\u0010\b\b\r\u001f\u0018\b\b", Lit30, 4, "syntaxutils.scm:24"), "\u0001\u0003\u0003\u0003", "\u0011\u0018\u0004\u0091\b\u0011\u0018\f\b\u0011\u0018\u0014\u0011\b\u0003\b\u0011\u0018\u001c\b\u0015\u0013\b\u0011\u0018$\t\u0003I\r\t\u000b\b\u0011\u0018\f\b\u0003\b\t,\b\u0011\u0018$\t\u0003\b\u001d\u001b", new Object[]{Lit33, Symbol.valueOf("f"), Lit36, Lit31, Lit21, Boolean.TRUE}, 1);
        Object[] arrobject3 = new Object[7];
        arrobject3[0] = Lit32;
        arrobject3[1] = Symbol.valueOf("instance?");
        arrobject3[2] = Lit33;
        Lit14 = Symbol.valueOf("::");
        arrobject3[3] = Lit14;
        arrobject3[4] = Lit31;
        arrobject3[5] = Lit34;
        arrobject3[6] = Lit21;
        arrsyntaxRule[4] = new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007<\f\u000f\r\u0017\u0010\b\b\r\u001f\u0018\b\b", Lit26, 4, "syntaxutils.scm:29"), "\u0001\u0001\u0003\u0003", "\u0011\u0018\u0004\u00f19\u0011\u0018\f\t\u0003\b\u000b\b\u0011\u0018\u0014Q\b\t\u0003\u0011\u0018\u001c\t\u000b\b\u0003\b\u0011\u0018$\b\u0015\u0013\b\u0011\u0018,\b\u0011\u00184\t\u0003\b\u001d\u001b", arrobject3, 1);
        arrsyntaxRule[5] = new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\b", Lit26, 1, "syntaxutils.scm:34"), "\u0001", "\u0011\u0018\u0004\t\f\t\u0003\b\u0011\u0018\u0014\u0011\u0018\u001c\b\u0011\u0018$\u0011\u0018,\b\u0003", new Object[]{Symbol.valueOf("error"), "typecase% failed", Lit23, Symbol.valueOf("getClass"), Lit35, Symbol.valueOf("<object>")}, 0);
        Lit22 = new SyntaxRules(new Object[]{Lit27, Lit29}, arrsyntaxRule, 4, Lit21);
        Lit20 = PairWithPosition.make(Symbol.valueOf(":"), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/syntaxutils.scm", 913424);
        Lit19 = PairWithPosition.make(Lit35, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/syntaxutils.scm", 905232);
        Lit18 = PairWithPosition.make(Lit28, PairWithPosition.make(Symbol.valueOf("protected"), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/syntaxutils.scm", 827441), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/syntaxutils.scm", 827441);
        Lit17 = PairWithPosition.make(Lit28, PairWithPosition.make(Symbol.valueOf("private"), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/syntaxutils.scm", 827431), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/syntaxutils.scm", 827431);
        Lit16 = PairWithPosition.make(Keyword.make("access"), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/syntaxutils.scm", 827406);
        Lit15 = PairWithPosition.make(Keyword.make("allocation"), PairWithPosition.make(PairWithPosition.make(Lit28, PairWithPosition.make(Symbol.valueOf("static"), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/syntaxutils.scm", 819236), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/syntaxutils.scm", 819236), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/syntaxutils.scm", 819235), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/syntaxutils.scm", 819222);
        Lit13 = PairWithPosition.make(Symbol.valueOf("class"), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/syntaxutils.scm", 708612);
        Lit12 = PairWithPosition.make(Lit28, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/syntaxutils.scm", 696332);
        Lit11 = PairWithPosition.make(Lit33, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/syntaxutils.scm", 618500);
        Lit10 = PairWithPosition.make(Special.key, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/syntaxutils.scm", 573462);
        Lit9 = PairWithPosition.make(Special.rest, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/syntaxutils.scm", 565271);
        Lit8 = PairWithPosition.make(Special.optional, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/syntaxutils.scm", 561165);
        Lit7 = IntNum.valueOf(1);
        Lit6 = IntNum.valueOf(0);
        Lit5 = PairWithPosition.make(Symbol.valueOf("if"), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/syntaxutils.scm", 409607);
        Lit4 = PairWithPosition.make(Lit36, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/syntaxutils.scm", 385031);
        Lit3 = PairWithPosition.make(Symbol.valueOf("set"), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/syntaxutils.scm", 372743);
        Lit2 = Keyword.make("lang");
        Lit1 = PairWithPosition.make(Lit31, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/syntaxutils.scm", 278557);
        Lit0 = Keyword.make("env");
        $instance = new syntaxutils();
        $Prvt$typecase$Pc = Macro.make(Lit21, Lit22, "gnu.kawa.slib.syntaxutils");
        $Prvt$$Ex = Macro.make(Lit23, Lit24, "gnu.kawa.slib.syntaxutils");
        syntaxutils syntaxutils2 = $instance;
        expand = new ModuleMethod(syntaxutils2, 1, Lit25, -4095);
        syntaxutils.$runBody$();
    }

    public syntaxutils() {
        ModuleInfo.register(this);
    }

    public int matchN(ModuleMethod moduleMethod, Object[] arrobject, CallContext callContext) {
        if (moduleMethod.selector == 1) {
            callContext.values = arrobject;
            callContext.proc = moduleMethod;
            callContext.pc = 5;
            return 0;
        }
        return super.matchN(moduleMethod, arrobject, callContext);
    }

    public void apply(CallContext callContext) {
        ModuleMethod.applyError();
    }

    public Object applyN(ModuleMethod moduleMethod, Object[] arrobject) {
        if (moduleMethod.selector == 1) {
            int n = arrobject.length - 1;
            Object[] arrobject2 = new Object[n];
            while (--n >= 0) {
                arrobject2 = arrobject2;
                arrobject2[n] = arrobject[n + 1];
            }
            return syntaxutils.expand$V(arrobject[0], arrobject2);
        }
        return super.applyN(moduleMethod, arrobject);
    }
}

