// 
// Decompiled by Procyon v0.5.36
// 

package kawa.lib;

import gnu.mapping.Promise;
import gnu.expr.ModuleInfo;
import gnu.mapping.Procedure;
import gnu.mapping.Symbol;
import gnu.math.IntNum;
import kawa.SourceMethodType;
import gnu.text.Char;
import gnu.lists.Consumer;
import gnu.mapping.CallContext;
import gnu.mapping.SimpleSymbol;
import gnu.expr.ModuleMethod;
import gnu.expr.ModuleBody;

public class characters extends ModuleBody
{
    public static final ModuleMethod char$Qu;
    public static final ModuleMethod char$Mn$Grinteger;
    public static final ModuleMethod integer$Mn$Grchar;
    public static final ModuleMethod digit$Mnvalue;
    public static characters $instance;
    static final SimpleSymbol Lit0;
    static final SimpleSymbol Lit1;
    static final SimpleSymbol Lit2;
    static final SimpleSymbol Lit3;
    
    private static void $runBody$() {
        final CallContext $ctx;
        final Consumer $result = ($ctx = CallContext.getInstance()).consumer;
    }
    
    public static boolean isChar(final Object x) {
        final boolean x2 = x instanceof Char;
        return x2 ? x2 : (x instanceof Character);
    }
    
    @SourceMethodType({ "", "character" })
    public static int char$To$Integer(final int ch) {
        return ch;
    }
    
    @SourceMethodType({ "character" })
    public static int integer$To$Char(final int n) {
        return n;
    }
    
    @SourceMethodType({ "", "character" })
    public static Object digitValue(final int ch) {
        final int r = Character.digit(char$To$Integer(ch), 10);
        return (r < 0) ? Boolean.FALSE : IntNum.make(r);
    }
    
    static {
        Lit3 = Symbol.valueOf("digit-value");
        Lit2 = Symbol.valueOf("integer->char");
        Lit1 = Symbol.valueOf("char->integer");
        Lit0 = Symbol.valueOf("char?");
        characters.$instance = new characters();
        final characters $instance = characters.$instance;
        char$Qu = new ModuleMethod($instance, 1, characters.Lit0, 4097);
        final ModuleMethod char$Mn$Grinteger2 = new ModuleMethod($instance, 2, characters.Lit1, 4097);
        char$Mn$Grinteger2.setProperty(Procedure.validateApplyKey, "kawa.lib.compile_misc:charToIntegerValidateApply");
        char$Mn$Grinteger = char$Mn$Grinteger2;
        final ModuleMethod integer$Mn$Grchar2 = new ModuleMethod($instance, 3, characters.Lit2, 4097);
        integer$Mn$Grchar2.setProperty(Procedure.validateApplyKey, "kawa.lib.compile_misc:integerToCharValidateApply");
        integer$Mn$Grchar = integer$Mn$Grchar2;
        digit$Mnvalue = new ModuleMethod($instance, 4, characters.Lit3, 4097);
        $runBody$();
    }
    
    public characters() {
        ModuleInfo.register(this);
    }
    
    @Override
    public int match1(final ModuleMethod proc, final Object arg1, final CallContext ctx) {
        switch (proc.selector) {
            case 4: {
                final Object force = Promise.force(arg1);
                if (Char.checkCharOrEof(force) >= 0) {
                    ctx.value1 = force;
                    ctx.proc = proc;
                    ctx.pc = 1;
                    return 0;
                }
                return -786431;
            }
            case 3: {
                ctx.value1 = Promise.force(arg1);
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 2: {
                final Object force2 = Promise.force(arg1);
                if (Char.checkCharOrEof(force2) >= 0) {
                    ctx.value1 = force2;
                    ctx.proc = proc;
                    ctx.pc = 1;
                    return 0;
                }
                return -786431;
            }
            case 1: {
                ctx.value1 = arg1;
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            default: {
                return super.match1(proc, arg1, ctx);
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
        //                2: 36
        //                3: 53
        //                4: 67
        //                5: 84
        //          default: 95
        //        }
        //    36: aload_2        
        //    37: invokestatic    kawa/lib/characters.isChar:(Ljava/lang/Object;)Z
        //    40: ifeq            49
        //    43: getstatic       java/lang/Boolean.TRUE:Ljava/lang/Boolean;
        //    46: goto            52
        //    49: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //    52: areturn        
        //    53: aload_2        
        //    54: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //    57: invokestatic    gnu/text/Char.castToCharacter:(Ljava/lang/Object;)I
        //    60: invokestatic    kawa/lib/characters.char$To$Integer:(I)I
        //    63: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //    66: areturn        
        //    67: aload_2        
        //    68: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //    71: checkcast       Ljava/lang/Number;
        //    74: invokevirtual   java/lang/Number.intValue:()I
        //    77: invokestatic    kawa/lib/characters.integer$To$Char:(I)I
        //    80: invokestatic    gnu/text/Char.make:(I)Lgnu/text/Char;
        //    83: areturn        
        //    84: aload_2        
        //    85: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //    88: invokestatic    gnu/text/Char.castToCharacter:(Ljava/lang/Object;)I
        //    91: invokestatic    kawa/lib/characters.digitValue:(I)Ljava/lang/Object;
        //    94: areturn        
        //    95: aload_0        
        //    96: aload_1        
        //    97: aload_2        
        //    98: invokespecial   gnu/expr/ModuleBody.apply1:(Lgnu/expr/ModuleMethod;Ljava/lang/Object;)Ljava/lang/Object;
        //   101: areturn        
        //   102: new             Lgnu/mapping/WrongType;
        //   105: dup_x1         
        //   106: swap           
        //   107: ldc             "char->integer"
        //   109: iconst_1       
        //   110: aload_2        
        //   111: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   114: athrow         
        //   115: new             Lgnu/mapping/WrongType;
        //   118: dup_x1         
        //   119: swap           
        //   120: ldc             "integer->char"
        //   122: iconst_1       
        //   123: aload_2        
        //   124: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   127: athrow         
        //   128: new             Lgnu/mapping/WrongType;
        //   131: dup_x1         
        //   132: swap           
        //   133: ldc             "digit-value"
        //   135: iconst_1       
        //   136: aload_2        
        //   137: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   140: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  57     60     102    115    Ljava/lang/ClassCastException;
        //  71     77     115    128    Ljava/lang/ClassCastException;
        //  88     91     128    141    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 57 out of bounds for length 57
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
