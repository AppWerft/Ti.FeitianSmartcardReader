// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.slib;

import gnu.expr.ModuleInfo;
import gnu.mapping.Symbol;
import gnu.mapping.Promise;
import gnu.mapping.Values;
import gnu.lists.Consumer;
import gnu.mapping.CallContext;
import gnu.mapping.SimpleSymbol;
import gnu.math.IntNum;
import gnu.expr.ModuleMethod;
import gnu.expr.ModuleBody;

public class XStrings extends ModuleBody
{
    public static final ModuleMethod substring;
    public static final ModuleMethod string$Mnlength;
    static final IntNum Lit0;
    public static XStrings $instance;
    static final SimpleSymbol Lit1;
    static final SimpleSymbol Lit2;
    
    private static void $runBody$() {
        final CallContext $ctx;
        final Consumer $result = ($ctx = CallContext.getInstance()).consumer;
    }
    
    public static Object substring(final Object string, final Object start) {
        return substring(string, start, XStrings.Lit0);
    }
    
    public static Object substring(final Object string, final Object start, final Object length) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //     4: if_acmpne       11
        //     7: iconst_1       
        //     8: goto            12
        //    11: iconst_0       
        //    12: istore_3        /* x */
        //    13: iload_3         /* x */
        //    14: ifeq            24
        //    17: iload_3         /* x */
        //    18: ifeq            64
        //    21: goto            58
        //    24: aload_1         /* start */
        //    25: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //    28: if_acmpne       35
        //    31: iconst_1       
        //    32: goto            36
        //    35: iconst_0       
        //    36: istore          x
        //    38: iload           x
        //    40: ifeq            51
        //    43: iload           x
        //    45: ifeq            64
        //    48: goto            58
        //    51: aload_2         /* length */
        //    52: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //    55: if_acmpne       64
        //    58: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //    61: goto            156
        //    64: aload_0         /* string */
        //    65: ldc             Ljava/lang/String;.class
        //    67: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    70: dup            
        //    71: astore          5
        //    73: checkcast       Ljava/lang/String;
        //    76: astore          s
        //    78: aload           s
        //    80: invokevirtual   java/lang/String.length:()I
        //    83: istore          slen
        //    85: aload_1         /* start */
        //    86: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //    89: dup            
        //    90: astore          7
        //    92: checkcast       Ljava/lang/Number;
        //    95: invokevirtual   java/lang/Number.intValue:()I
        //    98: istore          sindex
        //   100: iload           sindex
        //   102: iconst_1       
        //   103: isub           
        //   104: istore          index
        //   106: aload_2         /* length */
        //   107: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   110: dup            
        //   111: astore          9
        //   113: checkcast       Ljava/lang/Number;
        //   116: invokevirtual   java/lang/Number.intValue:()I
        //   119: istore          len
        //   121: iload           slen
        //   123: iload           index
        //   125: isub           
        //   126: istore          avail
        //   128: iload           len
        //   130: iload           avail
        //   132: if_icmple       140
        //   135: iload           avail
        //   137: goto            142
        //   140: iload           len
        //   142: istore          rlen
        //   144: aload           s
        //   146: iload           index
        //   148: iload           index
        //   150: iload           rlen
        //   152: iadd           
        //   153: invokevirtual   java/lang/String.substring:(II)Ljava/lang/String;
        //   156: areturn        
        //   157: new             Lgnu/mapping/WrongType;
        //   160: dup_x1         
        //   161: swap           
        //   162: ldc             "s"
        //   164: bipush          -2
        //   166: aload           5
        //   168: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   171: athrow         
        //   172: new             Lgnu/mapping/WrongType;
        //   175: dup_x1         
        //   176: swap           
        //   177: ldc             "sindex"
        //   179: bipush          -2
        //   181: aload           7
        //   183: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   186: athrow         
        //   187: new             Lgnu/mapping/WrongType;
        //   190: dup_x1         
        //   191: swap           
        //   192: ldc             "len"
        //   194: bipush          -2
        //   196: aload           9
        //   198: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   201: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  73     76     157    172    Ljava/lang/ClassCastException;
        //  92     98     172    187    Ljava/lang/ClassCastException;
        //  113    119    187    202    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 99 out of bounds for length 99
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
    
    public static Object stringLength(final Object string) {
        return (string == Values.empty) ? Values.empty : Integer.valueOf(((String)Promise.force(string, String.class)).length());
    }
    
    static {
        Lit2 = Symbol.valueOf("string-length");
        Lit1 = Symbol.valueOf("substring");
        Lit0 = IntNum.valueOf(Integer.MAX_VALUE);
        XStrings.$instance = new XStrings();
        final XStrings $instance = XStrings.$instance;
        substring = new ModuleMethod($instance, 1, XStrings.Lit1, 12290);
        string$Mnlength = new ModuleMethod($instance, 3, XStrings.Lit2, 4097);
        $runBody$();
    }
    
    public XStrings() {
        ModuleInfo.register(this);
    }
    
    @Override
    public int match1(final ModuleMethod moduleMethod, final Object o, final CallContext ctx) {
        if (moduleMethod.selector == 3) {
            ctx.value1 = o;
            ctx.proc = moduleMethod;
            ctx.pc = 1;
            return 0;
        }
        return super.match1(moduleMethod, o, ctx);
    }
    
    @Override
    public int match2(final ModuleMethod moduleMethod, final Object o, final Object o2, final CallContext ctx) {
        if (moduleMethod.selector == 1) {
            ctx.value1 = o;
            ctx.value2 = o2;
            ctx.proc = moduleMethod;
            ctx.pc = 2;
            return 0;
        }
        return super.match2(moduleMethod, o, o2, ctx);
    }
    
    @Override
    public int match3(final ModuleMethod moduleMethod, final Object o, final Object o2, final Object o3, final CallContext ctx) {
        if (moduleMethod.selector == 1) {
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
    public void apply(final CallContext callContext) {
        final int pc = callContext.pc;
        ModuleMethod.applyError();
    }
    
    @Override
    public Object apply1(final ModuleMethod method, final Object o) {
        if (method.selector == 3) {
            return stringLength(o);
        }
        return super.apply1(method, o);
    }
    
    @Override
    public Object apply2(final ModuleMethod method, final Object arg1, final Object arg2) {
        if (method.selector == 1) {
            return substring(arg1, arg2);
        }
        return super.apply2(method, arg1, arg2);
    }
    
    @Override
    public Object apply3(final ModuleMethod method, final Object o, final Object o2, final Object o3) {
        if (method.selector == 1) {
            return substring(o, o2, o3);
        }
        return super.apply3(method, o, o2, o3);
    }
}
