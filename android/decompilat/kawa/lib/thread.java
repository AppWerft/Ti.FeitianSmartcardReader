// 
// Decompiled by Procyon v0.5.36
// 

package kawa.lib;

import gnu.kawa.lispexpr.LangObjType;
import gnu.mapping.Promise;
import gnu.expr.ModuleInfo;
import kawa.lang.SyntaxPattern;
import kawa.lang.SyntaxRule;
import gnu.mapping.Symbol;
import gnu.mapping.RunnableClosure;
import gnu.mapping.Future;
import gnu.mapping.Procedure;
import kawa.standard.sleep;
import gnu.math.Quantity;
import gnu.lists.Consumer;
import gnu.mapping.CallContext;
import kawa.lang.SyntaxRules;
import gnu.mapping.SimpleSymbol;
import gnu.expr.ModuleMethod;
import kawa.lang.Macro;
import gnu.kawa.reflect.StaticFieldLocation;
import gnu.expr.ModuleBody;

public class thread extends ModuleBody
{
    public static final StaticFieldLocation $Prvt$lambda;
    public static final Macro future;
    public static final ModuleMethod sleep;
    public static final ModuleMethod runnable;
    public static final ModuleMethod $Prvt$$Pcmake$Mnfuture;
    public static thread $instance;
    static final SimpleSymbol Lit0;
    static final SimpleSymbol Lit1;
    static final SyntaxRules Lit2;
    static final SimpleSymbol Lit3;
    static final SimpleSymbol Lit4;
    static final Object[] Lit5;
    
    private static void $runBody$() {
        final CallContext $ctx;
        final Consumer $result = ($ctx = CallContext.getInstance()).consumer;
    }
    
    public static void sleep(final Quantity time) {
        kawa.standard.sleep.sleep(time);
    }
    
    public static Future $PcMakeFuture(final Procedure p) {
        final Future f = new Future(p);
        f.start();
        return f;
    }
    
    public static RunnableClosure runnable(final Procedure p) {
        return new RunnableClosure(p);
    }
    
    static {
        Lit5 = new Object[0];
        Lit4 = Symbol.valueOf("runnable");
        Lit3 = Symbol.valueOf("%make-future");
        Lit2 = new SyntaxRules(thread.Lit5, new SyntaxRule[] { new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\b", thread.Lit5, 1, "thread.scm:13"), "\u0001", "\u0011\u0018\u0004\b\u0011\u0018\f\t\u0010\b\u0003", new Object[] { thread.Lit3, Symbol.valueOf("lambda") }, 0) }, 1, Lit1 = Symbol.valueOf("future"));
        Lit0 = Symbol.valueOf("sleep");
        thread.$instance = new thread();
        $Prvt$lambda = StaticFieldLocation.make("kawa.standard.SchemeCompilation", "lambda");
        final thread $instance = thread.$instance;
        sleep = new ModuleMethod($instance, 1, thread.Lit0, 4097);
        future = Macro.make(thread.Lit1, thread.Lit2, "kawa.lib.thread");
        $Prvt$$Pcmake$Mnfuture = new ModuleMethod($instance, 2, thread.Lit3, 4097);
        runnable = new ModuleMethod($instance, 3, thread.Lit4, 4097);
        $runBody$();
    }
    
    public thread() {
        ModuleInfo.register(this);
    }
    
    @Override
    public int match1(final ModuleMethod moduleMethod, final Object o, final CallContext ctx) {
        switch (moduleMethod.selector) {
            case 3: {
                final Object force = Promise.force(o, Procedure.class);
                if (LangObjType.coerceToProcedureOrNull(force) != null) {
                    ctx.value1 = force;
                    ctx.proc = moduleMethod;
                    ctx.pc = 1;
                    return 0;
                }
                return -786431;
            }
            case 2: {
                final Object force2 = Promise.force(o, Procedure.class);
                if (LangObjType.coerceToProcedureOrNull(force2) != null) {
                    ctx.value1 = force2;
                    ctx.proc = moduleMethod;
                    ctx.pc = 1;
                    return 0;
                }
                return -786431;
            }
            case 1: {
                final Object force3 = Promise.force(o, Quantity.class);
                if (!(force3 instanceof Quantity)) {
                    return -786431;
                }
                ctx.value1 = force3;
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
    public void apply(final CallContext callContext) {
        final int pc = callContext.pc;
        ModuleMethod.applyError();
    }
    
    @Override
    public Object apply1(final ModuleMethod p0, final Object p1) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        gnu/expr/ModuleMethod.selector:I
        //     4: tableswitch {
        //                2: 32
        //                3: 48
        //                4: 61
        //          default: 74
        //        }
        //    32: aload_2        
        //    33: ldc             Lgnu/math/Quantity;.class
        //    35: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    38: checkcast       Lgnu/math/Quantity;
        //    41: invokestatic    kawa/lib/thread.sleep:(Lgnu/math/Quantity;)V
        //    44: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //    47: areturn        
        //    48: aload_2        
        //    49: ldc             Lgnu/mapping/Procedure;.class
        //    51: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    54: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceToProcedure:(Ljava/lang/Object;)Lgnu/mapping/Procedure;
        //    57: invokestatic    kawa/lib/thread.$PcMakeFuture:(Lgnu/mapping/Procedure;)Lgnu/mapping/Future;
        //    60: areturn        
        //    61: aload_2        
        //    62: ldc             Lgnu/mapping/Procedure;.class
        //    64: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    67: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceToProcedure:(Ljava/lang/Object;)Lgnu/mapping/Procedure;
        //    70: invokestatic    kawa/lib/thread.runnable:(Lgnu/mapping/Procedure;)Lgnu/mapping/RunnableClosure;
        //    73: areturn        
        //    74: aload_0        
        //    75: aload_1        
        //    76: aload_2        
        //    77: invokespecial   gnu/expr/ModuleBody.apply1:(Lgnu/expr/ModuleMethod;Ljava/lang/Object;)Ljava/lang/Object;
        //    80: areturn        
        //    81: new             Lgnu/mapping/WrongType;
        //    84: dup_x1         
        //    85: swap           
        //    86: ldc             "sleep"
        //    88: iconst_1       
        //    89: aload_2        
        //    90: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //    93: athrow         
        //    94: new             Lgnu/mapping/WrongType;
        //    97: dup_x1         
        //    98: swap           
        //    99: ldc             "%make-future"
        //   101: iconst_1       
        //   102: aload_2        
        //   103: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   106: athrow         
        //   107: new             Lgnu/mapping/WrongType;
        //   110: dup_x1         
        //   111: swap           
        //   112: ldc             "runnable"
        //   114: iconst_1       
        //   115: aload_2        
        //   116: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   119: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  38     41     81     94     Ljava/lang/ClassCastException;
        //  54     57     94     107    Ljava/lang/ClassCastException;
        //  67     70     107    120    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 51 out of bounds for length 51
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
}
