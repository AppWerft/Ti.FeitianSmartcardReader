// 
// Decompiled by Procyon v0.5.36
// 

package kawa.lib.kawa;

import kawa.standard.syntax_case;
import kawa.lang.SyntaxForms;
import kawa.lang.TemplateScope;
import gnu.expr.ModuleInfo;
import gnu.lists.Pair;
import kawa.lang.SyntaxRule;
import gnu.mapping.Symbol;
import gnu.expr.SetExp;
import gnu.mapping.WrongType;
import gnu.expr.IfExp;
import gnu.expr.BeginExp;
import gnu.kawa.functions.MakeSplice;
import gnu.mapping.Procedure;
import gnu.kawa.functions.Map;
import gnu.kawa.reflect.Invoke;
import gnu.lists.LList;
import gnu.expr.ApplyExp;
import gnu.bytecode.Type;
import gnu.expr.Compilation;
import gnu.expr.InlineCalls;
import gnu.expr.QuoteExp;
import gnu.expr.ReferenceExp;
import gnu.expr.Declaration;
import gnu.mapping.Promise;
import gnu.expr.Expression;
import gnu.lists.Consumer;
import gnu.mapping.CallContext;
import gnu.lists.PairWithPosition;
import kawa.lang.SyntaxRules;
import kawa.lang.SyntaxTemplate;
import kawa.lang.SyntaxPattern;
import gnu.mapping.SimpleSymbol;
import gnu.bytecode.ClassType;
import gnu.kawa.reflect.StaticFieldLocation;
import kawa.lang.Macro;
import gnu.expr.ModuleMethod;
import gnu.expr.ModuleBody;

public class expressions extends ModuleBody
{
    public static final ModuleMethod $Mn$Grexp;
    public static final ModuleMethod get$Mnvisitor;
    public static final ModuleMethod get$Mncompilation;
    public static final ModuleMethod visit$Mnexp;
    public static final Macro syntax$Mnas$Mnexp;
    public static final Macro define$Mnvalidate;
    public static final ModuleMethod apply$Mnexp;
    public static final ModuleMethod begin$Mnexp;
    public static final ModuleMethod if$Mnexp;
    public static final ModuleMethod set$Mnexp;
    public static final ModuleMethod apply$Mnto$Mnargs$Mnexp;
    public static final Class Declaration;
    public static final Class Expression;
    public static final Class ApplyExp;
    public static final Class QuoteExp;
    public static final Class ReferenceExp;
    public static final Class Compilation;
    public static final Class Type;
    public static final StaticFieldLocation $Prvt$define;
    public static final StaticFieldLocation $Prvt$cond;
    public static final StaticFieldLocation $Prvt$let;
    public static final StaticFieldLocation $Prvt$else;
    static final ClassType Lit0;
    public static expressions $instance;
    static final SimpleSymbol Lit1;
    static final SimpleSymbol Lit2;
    static final SimpleSymbol Lit3;
    static final SimpleSymbol Lit4;
    static final SimpleSymbol Lit5;
    static final SyntaxPattern Lit6;
    static final SyntaxTemplate Lit7;
    static final SimpleSymbol Lit8;
    static final SimpleSymbol Lit9;
    static final SimpleSymbol Lit10;
    static final SimpleSymbol Lit11;
    static final SimpleSymbol Lit12;
    static final SimpleSymbol Lit13;
    static final SyntaxRules Lit14;
    static final Object[] Lit15;
    static final SimpleSymbol Lit16;
    static final SimpleSymbol Lit17;
    static final PairWithPosition Lit18;
    static final SimpleSymbol Lit19;
    static final SimpleSymbol Lit20;
    static final SimpleSymbol Lit21;
    static final SimpleSymbol Lit22;
    static final SimpleSymbol Lit23;
    
    private static void $runBody$() {
        final CallContext $ctx;
        final Consumer $result = ($ctx = CallContext.getInstance()).consumer;
    }
    
    public static Expression $To$Exp(final Object obj) {
        return (obj instanceof Expression) ? ((Expression)Promise.force(obj, Expression.class)) : ((obj instanceof Declaration) ? new ReferenceExp((Declaration)Promise.force(obj, Declaration.class)) : gnu.expr.QuoteExp.getInstance(obj));
    }
    
    public static InlineCalls getVisitor() {
        return InlineCalls.currentVisitor.get();
    }
    
    public static Compilation getCompilation() {
        return getVisitor().getCompilation();
    }
    
    public static Expression visitExp(final Expression exp) {
        return visitExp(exp, null);
    }
    
    public static Expression visitExp(final Expression exp, final Type required) {
        return getVisitor().visit(exp, required);
    }
    
    public static ApplyExp applyExp$V(final Object func, final Object[] argsArray) {
        final LList args = LList.makeList(argsArray, 0);
        final Invoke make = Invoke.make;
        final int n = 2;
        final Expression $To$Exp = $To$Exp(func);
        final Object map1 = Map.map1(expressions.$Mn$Grexp, args);
        final int count;
        final Object[] target = new Object[(count = MakeSplice.count(map1)) + n];
        target[0] = expressions.ApplyExp;
        target[1] = $To$Exp;
        MakeSplice.copyTo(target, 2, count, map1);
        return (ApplyExp)Promise.force(make.applyN(target), ApplyExp.class);
    }
    
    public static Object applyToArgsExp$V(final Object func, final Object[] argsArray) {
        final LList args = LList.makeList(argsArray, 0);
        final Expression fexp = $To$Exp(func);
        final Compilation comp = getCompilation();
        final Expression applyFunction = comp.applyFunction(fexp);
        Object o;
        if (applyFunction == null) {
            final Invoke make = Invoke.make;
            final int n = 2;
            final Expression $To$Exp = $To$Exp(func);
            final Object map1 = Map.map1(expressions.$Mn$Grexp, args);
            final int count;
            final Object[] target = new Object[(count = MakeSplice.count(map1)) + n];
            target[0] = expressions.ApplyExp;
            target[1] = $To$Exp;
            MakeSplice.copyTo(target, 2, count, map1);
            o = make.applyN(target);
        }
        else {
            final Invoke make2 = Invoke.make;
            final int n2 = 3;
            final Expression $To$Exp2 = $To$Exp(func);
            final Object map2 = Map.map1(expressions.$Mn$Grexp, args);
            final int count2;
            final Object[] target2 = new Object[(count2 = MakeSplice.count(map2)) + n2];
            target2[0] = expressions.ApplyExp;
            target2[1] = applyFunction;
            target2[2] = $To$Exp2;
            MakeSplice.copyTo(target2, 3, count2, map2);
            o = make2.applyN(target2);
        }
        return o;
    }
    
    public static BeginExp beginExp$V(final Object[] argsArray) {
        final LList args = LList.makeList(argsArray, 0);
        final int n = 0;
        final Object map1 = Map.map1(expressions.$Mn$Grexp, args);
        final int count;
        final Expression[] array = new Expression[(count = MakeSplice.count(map1)) + n];
        MakeSplice.copyTo(array, 0, count, map1, expressions.Lit0);
        return new BeginExp(array);
    }
    
    public static IfExp ifExp(final Object a, final Object b) {
        return ifExp(a, b, null);
    }
    
    public static IfExp ifExp(final Object a, final Object b, final Object c) {
        final Expression $To$Exp = $To$Exp(a);
        final Expression $To$Exp2 = $To$Exp(b);
        Label_0030: {
            if (c != null) {
                break Label_0030;
            }
            final Object force = Promise.force(c, Expression.class);
            try {
                Expression $To$Exp3 = (Expression)force;
                return new IfExp($To$Exp, $To$Exp2, $To$Exp3);
                $To$Exp3 = $To$Exp(c);
                return new IfExp($To$Exp, $To$Exp2, $To$Exp3);
            }
            catch (ClassCastException ex) {
                throw new WrongType(ex, "gnu.expr.IfExp.<init>(gnu.expr.Expression,gnu.expr.Expression,gnu.expr.Expression)", 3, force);
            }
        }
    }
    
    public static SetExp setExp(final Declaration var, final Object val) {
        final SetExp se = new SetExp(var, $To$Exp(val));
        se.setContextDecl(var);
        var.setCanWrite(true);
        se.setBinding(var);
        var.noteValueFromSet(se);
        return se;
    }
    
    static {
        Lit23 = Symbol.valueOf("quasiquote");
        Lit22 = Symbol.valueOf("$lookup$");
        Lit21 = Symbol.valueOf("else");
        Lit20 = Symbol.valueOf("visitor");
        Lit19 = Symbol.valueOf("eq?");
        Lit18 = PairWithPosition.make(null, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/expressions.scm", 340017);
        Lit17 = Symbol.valueOf("ex");
        Lit16 = Symbol.valueOf("::");
        Lit15 = new Object[0];
        Lit14 = new SyntaxRules(expressions.Lit15, new SyntaxRule[] { new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007<\f\u000f\f\u0017\f\u001f\b\r' \b\b", expressions.Lit15, 5, "expressions.scm:76"), "\u0001\u0001\u0001\u0001\u0003", "\u0011\u0018\u0004\u00f9\t\u0003\t\u000b\u0011\u0018\f\u0011\u0018\u0014\u0011\u0018\u001c\u0011\u0018\f\u0011\u0018$\t\u0013\u0011\u0018\f\u0011\u0018,\t\u001b\u00184\u0011\u0018\f\u0011\u0018<\b\u0011\u0018D\u0099\b\u0011\u0018L\u0011\u0018\f\u0011\u0018<\b\u0011\u0018T\u0011%#\u0018\\\b\u0011\u0018T\u0011\u0018d±A\u0011\u0018l\u0011\u0018L\b\u000bQ9\u0011\u0018t\t\u000b\u0018|\u0018\u0084\b\u000b\b\u0011\u0018\u008c\b\u0011\u0018\u0094)\u0011\u0018\u009c\b\u000b\b\u0013", new Object[] { Symbol.valueOf("define"), expressions.Lit16, Symbol.valueOf("gnu.expr.ApplyExp"), expressions.Lit20, Symbol.valueOf("gnu.expr.InlineCalls"), Symbol.valueOf("gnu.bytecode.Type"), PairWithPosition.make(expressions.Lit16, PairWithPosition.make(Symbol.valueOf("gnu.mapping.Procedure"), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/expressions.scm", 331797), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/expressions.scm", 331795), Symbol.valueOf("gnu.expr.Expression"), Symbol.valueOf("let"), expressions.Lit17, Symbol.valueOf("cond"), PairWithPosition.make(PairWithPosition.make(expressions.Lit21, expressions.Lit18, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/expressions.scm", 340011), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/expressions.scm", 340011), PairWithPosition.make(PairWithPosition.make(expressions.Lit19, PairWithPosition.make(expressions.Lit17, expressions.Lit18, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/expressions.scm", 344093), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/expressions.scm", 344088), expressions.Lit18, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/expressions.scm", 344087), expressions.Lit19, expressions.Lit22, Pair.make(Pair.make(expressions.Lit23, Pair.make(Symbol.valueOf("visitArgs"), LList.Empty)), LList.Empty), PairWithPosition.make(expressions.Lit20, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/expressions.scm", 356391), expressions.Lit21, PairWithPosition.make(expressions.Lit22, Pair.make(expressions.Lit20, Pair.make(Pair.make(expressions.Lit23, Pair.make(Symbol.valueOf("visit"), LList.Empty)), LList.Empty)), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/expressions.scm", 368665), PairWithPosition.make(expressions.Lit22, Pair.make(expressions.Lit17, Pair.make(Pair.make(expressions.Lit23, Pair.make(Symbol.valueOf("maybeSetLine"), LList.Empty)), LList.Empty)), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/expressions.scm", 368680) }, 1) }, 5, Lit13 = Symbol.valueOf("define-validate"));
        Lit12 = Symbol.valueOf("set-exp");
        Lit11 = Symbol.valueOf("if-exp");
        Lit10 = Symbol.valueOf("begin-exp");
        Lit9 = Symbol.valueOf("apply-to-args-exp");
        Lit8 = Symbol.valueOf("apply-exp");
        Lit7 = new SyntaxTemplate("\u0001", "\u0003", expressions.Lit15, 0);
        Lit6 = new SyntaxPattern("\f\u0018\f\u0007\b", expressions.Lit15, 1, "expressions.scm:41");
        Lit5 = Symbol.valueOf("syntax-as-exp");
        Lit4 = Symbol.valueOf("visit-exp");
        Lit3 = Symbol.valueOf("get-compilation");
        Lit2 = Symbol.valueOf("get-visitor");
        Lit1 = Symbol.valueOf("->exp");
        Lit0 = ClassType.make("gnu.expr.Expression");
        Type = Type.class;
        Compilation = Compilation.class;
        ReferenceExp = ReferenceExp.class;
        QuoteExp = QuoteExp.class;
        ApplyExp = ApplyExp.class;
        Expression = Expression.class;
        Declaration = Declaration.class;
        expressions.$instance = new expressions();
        $Prvt$define = StaticFieldLocation.make("kawa.lib.prim_syntax", "define");
        $Prvt$cond = StaticFieldLocation.make("kawa.lib.std_syntax", "cond");
        $Prvt$let = StaticFieldLocation.make("kawa.lib.std_syntax", "let");
        $Prvt$else = StaticFieldLocation.make("kawa.lib.std_syntax", "else");
        final expressions $instance = expressions.$instance;
        $Mn$Grexp = new ModuleMethod($instance, 1, expressions.Lit1, 4097);
        get$Mnvisitor = new ModuleMethod($instance, 2, expressions.Lit2, 0);
        get$Mncompilation = new ModuleMethod($instance, 3, expressions.Lit3, 0);
        visit$Mnexp = new ModuleMethod($instance, 4, expressions.Lit4, 8193);
        final SimpleSymbol lit5 = expressions.Lit5;
        final ModuleMethod expander = new ModuleMethod(expressions.$instance, 6, null, 4097);
        expander.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/expressions.scm:39");
        syntax$Mnas$Mnexp = Macro.make(lit5, expander, "kawa.lib.kawa.expressions");
        apply$Mnexp = new ModuleMethod($instance, 7, expressions.Lit8, -4095);
        apply$Mnto$Mnargs$Mnexp = new ModuleMethod($instance, 8, expressions.Lit9, -4095);
        begin$Mnexp = new ModuleMethod($instance, 9, expressions.Lit10, -4096);
        if$Mnexp = new ModuleMethod($instance, 10, expressions.Lit11, 12290);
        set$Mnexp = new ModuleMethod($instance, 12, expressions.Lit12, 8194);
        define$Mnvalidate = Macro.make(expressions.Lit13, expressions.Lit14, "kawa.lib.kawa.expressions");
        $runBody$();
    }
    
    public expressions() {
        ModuleInfo.register(this);
    }
    
    static Object lambda1(final Object form) {
        final Object[] allocVars = SyntaxPattern.allocVars(1, null);
        return expressions.Lit6.match(form, allocVars, 0) ? SyntaxForms.rewrite(expressions.Lit7.execute(allocVars, TemplateScope.make())) : syntax_case.error("syntax-case", form);
    }
    
    @Override
    public int match0(final ModuleMethod proc, final CallContext ctx) {
        switch (proc.selector) {
            case 3: {
                ctx.proc = proc;
                return ctx.pc = 0;
            }
            case 2: {
                ctx.proc = proc;
                return ctx.pc = 0;
            }
            default: {
                return super.match0(proc, ctx);
            }
        }
    }
    
    @Override
    public int match1(final ModuleMethod moduleMethod, final Object o, final CallContext ctx) {
        switch (moduleMethod.selector) {
            case 6: {
                ctx.value1 = o;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 4: {
                final Object force = Promise.force(o, Expression.class);
                if (!(force instanceof Expression)) {
                    return -786431;
                }
                ctx.value1 = force;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 1: {
                ctx.value1 = o;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            default: {
                return super.match1(moduleMethod, o, ctx);
            }
        }
    }
    
    @Override
    public int match2(final ModuleMethod moduleMethod, final Object o, final Object o2, final CallContext ctx) {
        switch (moduleMethod.selector) {
            case 12: {
                final Object force = Promise.force(o, Declaration.class);
                if (!(force instanceof Declaration)) {
                    return -786431;
                }
                ctx.value1 = force;
                ctx.value2 = o2;
                ctx.proc = moduleMethod;
                ctx.pc = 2;
                return 0;
            }
            case 10: {
                ctx.value1 = o;
                ctx.value2 = o2;
                ctx.proc = moduleMethod;
                ctx.pc = 2;
                return 0;
            }
            case 4: {
                final Object force2 = Promise.force(o, Expression.class);
                if (!(force2 instanceof Expression)) {
                    return -786431;
                }
                ctx.value1 = force2;
                final Object force3 = Promise.force(o2, Type.class);
                if (!(force3 instanceof Type)) {
                    return -786430;
                }
                ctx.value2 = force3;
                ctx.proc = moduleMethod;
                ctx.pc = 2;
                return 0;
            }
            default: {
                return super.match2(moduleMethod, o, o2, ctx);
            }
        }
    }
    
    @Override
    public int match3(final ModuleMethod moduleMethod, final Object o, final Object o2, final Object o3, final CallContext ctx) {
        if (moduleMethod.selector == 10) {
            ctx.value1 = o;
            ctx.value2 = o2;
            ctx.value3 = o3;
            ctx.proc = moduleMethod;
            ctx.pc = 3;
            return 0;
        }
        return super.match3(moduleMethod, o, o2, o3, ctx);
    }
    
    @Override
    public int matchN(final ModuleMethod moduleMethod, final Object[] array, final CallContext ctx) {
        switch (moduleMethod.selector) {
            case 9: {
                ctx.values = array;
                ctx.proc = moduleMethod;
                ctx.pc = 5;
                return 0;
            }
            case 8: {
                ctx.values = array;
                ctx.proc = moduleMethod;
                ctx.pc = 5;
                return 0;
            }
            case 7: {
                ctx.values = array;
                ctx.proc = moduleMethod;
                ctx.pc = 5;
                return 0;
            }
            default: {
                return super.matchN(moduleMethod, array, ctx);
            }
        }
    }
    
    @Override
    public void apply(final CallContext callContext) {
        final int pc = callContext.pc;
        ModuleMethod.applyError();
    }
    
    @Override
    public Object apply0(final ModuleMethod method) {
        switch (method.selector) {
            case 2: {
                return getVisitor();
            }
            case 3: {
                return getCompilation();
            }
            default: {
                return super.apply0(method);
            }
        }
    }
    
    @Override
    public Object apply1(final ModuleMethod method, final Object argValue) {
    Label_0062_Outer:
        while (true) {
            while (true) {
                switch (method.selector) {
                    case 1: {
                        return $To$Exp(argValue);
                    }
                    case 4: {
                        final Object force = Promise.force(argValue, Expression.class);
                        try {
                            return visitExp((Expression)force);
                            return super.apply1(method, argValue);
                            return lambda1(argValue);
                        }
                        catch (ClassCastException ex) {
                            throw new WrongType(ex, "visit-exp", 1, argValue);
                        }
                        break;
                    }
                    case 6: {
                        continue;
                    }
                    default: {
                        continue Label_0062_Outer;
                    }
                }
                break;
            }
            break;
        }
    }
    
    @Override
    public Object apply2(final ModuleMethod p0, final Object p1, final Object p2) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        gnu/expr/ModuleMethod.selector:I
        //     4: lookupswitch {
        //                4: 40
        //               10: 63
        //               12: 69
        //          default: 83
        //        }
        //    40: aload_2        
        //    41: ldc             Lgnu/expr/Expression;.class
        //    43: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    46: checkcast       Lgnu/expr/Expression;
        //    49: aload_3        
        //    50: ldc_w           Lgnu/bytecode/Type;.class
        //    53: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    56: checkcast       Lgnu/bytecode/Type;
        //    59: invokestatic    kawa/lib/kawa/expressions.visitExp:(Lgnu/expr/Expression;Lgnu/bytecode/Type;)Lgnu/expr/Expression;
        //    62: areturn        
        //    63: aload_2        
        //    64: aload_3        
        //    65: invokestatic    kawa/lib/kawa/expressions.ifExp:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/expr/IfExp;
        //    68: areturn        
        //    69: aload_2        
        //    70: ldc             Lgnu/expr/Declaration;.class
        //    72: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    75: checkcast       Lgnu/expr/Declaration;
        //    78: aload_3        
        //    79: invokestatic    kawa/lib/kawa/expressions.setExp:(Lgnu/expr/Declaration;Ljava/lang/Object;)Lgnu/expr/SetExp;
        //    82: areturn        
        //    83: aload_0        
        //    84: aload_1        
        //    85: aload_2        
        //    86: aload_3        
        //    87: invokespecial   gnu/expr/ModuleBody.apply2:(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    90: areturn        
        //    91: new             Lgnu/mapping/WrongType;
        //    94: dup_x1         
        //    95: swap           
        //    96: ldc_w           "visit-exp"
        //    99: iconst_1       
        //   100: aload_2        
        //   101: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   104: athrow         
        //   105: new             Lgnu/mapping/WrongType;
        //   108: dup_x1         
        //   109: swap           
        //   110: ldc_w           "visit-exp"
        //   113: iconst_2       
        //   114: aload_3        
        //   115: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   118: athrow         
        //   119: new             Lgnu/mapping/WrongType;
        //   122: dup_x1         
        //   123: swap           
        //   124: ldc_w           "set-exp"
        //   127: iconst_1       
        //   128: aload_2        
        //   129: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   132: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  46     49     91     105    Ljava/lang/ClassCastException;
        //  56     59     105    119    Ljava/lang/ClassCastException;
        //  75     78     119    133    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 54 out of bounds for length 54
        //     at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
        //     at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
        //     at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:248)
        //     at java.base/java.util.Objects.checkIndex(Objects.java:372)
        //     at java.base/java.util.ArrayList.get(ArrayList.java:458)
        //     at com.strobel.decompiler.ast.AstBuilder.convertToAst(AstBuilder.java:3321)
        //     at com.strobel.decompiler.ast.AstBuilder.build(AstBuilder.java:113)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:211)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:675)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:552)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:150)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:125)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:330)
        //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:251)
        //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:126)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    @Override
    public Object apply3(final ModuleMethod method, final Object o, final Object o2, final Object o3) {
        if (method.selector == 10) {
            return ifExp(o, o2, o3);
        }
        return super.apply3(method, o, o2, o3);
    }
    
    @Override
    public Object applyN(final ModuleMethod method, final Object[] array) {
        switch (method.selector) {
            case 7: {
                final Object func = array[0];
                int n = array.length - 1;
                final Object[] argsArray = new Object[n];
                while (--n >= 0) {
                    argsArray[n] = array[n + 1];
                }
                return applyExp$V(func, argsArray);
            }
            case 8: {
                final Object func2 = array[0];
                int n2 = array.length - 1;
                final Object[] argsArray2 = new Object[n2];
                while (--n2 >= 0) {
                    argsArray2[n2] = array[n2 + 1];
                }
                return applyToArgsExp$V(func2, argsArray2);
            }
            case 9: {
                return beginExp$V(array);
            }
            default: {
                return super.applyN(method, array);
            }
        }
    }
}
