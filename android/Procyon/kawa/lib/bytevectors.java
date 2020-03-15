// 
// Decompiled by Procyon v0.5.36
// 

package kawa.lib;

import gnu.mapping.Promise;
import gnu.expr.ModuleInfo;
import gnu.mapping.Symbol;
import gnu.math.UByte;
import gnu.lists.ByteVector;
import gnu.lists.U8Vector;
import gnu.lists.Consumer;
import gnu.mapping.CallContext;
import gnu.mapping.SimpleSymbol;
import gnu.expr.ModuleMethod;
import gnu.expr.ModuleBody;

public class bytevectors extends ModuleBody
{
    public static final ModuleMethod bytevector$Qu;
    public static final ModuleMethod make$Mnbytevector;
    public static final ModuleMethod bytevector$Mnlength;
    public static final ModuleMethod bytevector$Mnu8$Mnref;
    public static final ModuleMethod bytevector$Mnu8$Mnset$Ex;
    public static final ModuleMethod bytevector$Mncopy;
    public static final ModuleMethod bytevector$Mncopy$Ex;
    public static final ModuleMethod bytevector$Mnappend;
    public static final ModuleMethod utf8$Mn$Grstring;
    public static final ModuleMethod string$Mn$Grutf8;
    public static bytevectors $instance;
    static final SimpleSymbol Lit0;
    static final SimpleSymbol Lit1;
    static final SimpleSymbol Lit2;
    static final SimpleSymbol Lit3;
    static final SimpleSymbol Lit4;
    static final SimpleSymbol Lit5;
    static final SimpleSymbol Lit6;
    static final SimpleSymbol Lit7;
    static final SimpleSymbol Lit8;
    static final SimpleSymbol Lit9;
    
    private static void $runBody$() {
        final CallContext $ctx;
        final Consumer $result = ($ctx = CallContext.getInstance()).consumer;
    }
    
    public static boolean isBytevector(final Object x) {
        return x instanceof U8Vector;
    }
    
    public static U8Vector makeBytevector(final int n) {
        return makeBytevector(n, 0);
    }
    
    public static U8Vector makeBytevector(final int n, final int init) {
        return new U8Vector(n, (byte)init);
    }
    
    public static int bytevectorLength(final U8Vector v) {
        return v.size();
    }
    
    public static int bytevectorU8Ref(final U8Vector v, final int i) {
        return v.getInt(i);
    }
    
    public static void bytevectorU8Set$Ex(final U8Vector v, final int i, final int x) {
        v.setByte(i, (byte)x);
    }
    
    public static U8Vector bytevectorCopy(final U8Vector u8Vector) {
        return bytevectorCopy(u8Vector, 0);
    }
    
    public static U8Vector bytevectorCopy(final U8Vector v, final int start) {
        return bytevectorCopy(v, start, v.size());
    }
    
    public static U8Vector bytevectorCopy(final U8Vector v, final int start, final int end) {
        final U8Vector result = new U8Vector(end - start);
        result.copyFrom(0, v, start, end);
        return result;
    }
    
    public static void bytevectorCopy$Ex(final U8Vector u8Vector, final int n, final U8Vector u8Vector2) {
        bytevectorCopy$Ex(u8Vector, n, u8Vector2, 0);
    }
    
    public static void bytevectorCopy$Ex(final U8Vector to, final int at, final U8Vector from, final int start) {
        bytevectorCopy$Ex(to, at, from, start, from.size());
    }
    
    public static void bytevectorCopy$Ex(final U8Vector to, final int at, final U8Vector from, final int start, final int end) {
        to.copyFrom(at, from, start, end);
    }
    
    public static Object bytevectorAppend(final U8Vector... bvs) {
        final int nbvs = bvs.length;
        int sz = 0;
        for (int i = 0; i < nbvs; ++i) {
            sz += bvs[i].size();
        }
        final int size = sz;
        final U8Vector result = new U8Vector(size);
        for (final U8Vector bv : bvs) {
            final int bvlength = bv.size();
            final int off;
            result.copyFrom(off, bv, 0, bvlength);
            off += bvlength;
        }
        return result;
    }
    
    public static CharSequence utf8$To$String(final U8Vector u8Vector) {
        return utf8$To$String(u8Vector, 0);
    }
    
    public static CharSequence utf8$To$String(final U8Vector v, final int start) {
        return utf8$To$String(v, start, v.size());
    }
    
    public static CharSequence utf8$To$String(final U8Vector v, final int start, final int end) {
        return v.toUtf8(start, end - start);
    }
    
    public static U8Vector string$To$Utf8(final CharSequence charSequence) {
        return string$To$Utf8(charSequence, 0);
    }
    
    public static U8Vector string$To$Utf8(final CharSequence v, final int start) {
        return string$To$Utf8(v, start, v.length());
    }
    
    public static U8Vector string$To$Utf8(final CharSequence v, final int start, final int end) {
        return new U8Vector(v.toString().substring(start, end).getBytes("UTF-8"));
    }
    
    static {
        Lit9 = Symbol.valueOf("string->utf8");
        Lit8 = Symbol.valueOf("utf8->string");
        Lit7 = Symbol.valueOf("bytevector-append");
        Lit6 = Symbol.valueOf("bytevector-copy!");
        Lit5 = Symbol.valueOf("bytevector-copy");
        Lit4 = Symbol.valueOf("bytevector-u8-set!");
        Lit3 = Symbol.valueOf("bytevector-u8-ref");
        Lit2 = Symbol.valueOf("bytevector-length");
        Lit1 = Symbol.valueOf("make-bytevector");
        Lit0 = Symbol.valueOf("bytevector?");
        bytevectors.$instance = new bytevectors();
        final bytevectors $instance = bytevectors.$instance;
        bytevector$Qu = new ModuleMethod($instance, 1, bytevectors.Lit0, 4097);
        make$Mnbytevector = new ModuleMethod($instance, 2, bytevectors.Lit1, 8193);
        bytevector$Mnlength = new ModuleMethod($instance, 4, bytevectors.Lit2, 4097);
        bytevector$Mnu8$Mnref = new ModuleMethod($instance, 5, bytevectors.Lit3, 8194);
        bytevector$Mnu8$Mnset$Ex = new ModuleMethod($instance, 6, bytevectors.Lit4, 12291);
        bytevector$Mncopy = new ModuleMethod($instance, 7, bytevectors.Lit5, 12289);
        bytevector$Mncopy$Ex = new ModuleMethod($instance, 10, bytevectors.Lit6, 20483);
        bytevector$Mnappend = new ModuleMethod($instance, 13, bytevectors.Lit7, -4096);
        utf8$Mn$Grstring = new ModuleMethod($instance, 14, bytevectors.Lit8, 12289);
        string$Mn$Grutf8 = new ModuleMethod($instance, 17, bytevectors.Lit9, 12289);
        $runBody$();
    }
    
    public bytevectors() {
        ModuleInfo.register(this);
    }
    
    @Override
    public int match1(final ModuleMethod proc, final Object arg1, final CallContext ctx) {
        switch (proc.selector) {
            case 17: {
                final Object force = Promise.force(arg1, CharSequence.class);
                if (force instanceof CharSequence) {
                    ctx.value1 = force;
                    ctx.proc = proc;
                    ctx.pc = 1;
                    return 0;
                }
                return -786431;
            }
            case 14: {
                final Object force2 = Promise.force(arg1, U8Vector.class);
                if (force2 instanceof U8Vector) {
                    ctx.value1 = force2;
                    ctx.proc = proc;
                    ctx.pc = 1;
                    return 0;
                }
                return -786431;
            }
            case 7: {
                final Object force3 = Promise.force(arg1, U8Vector.class);
                if (force3 instanceof U8Vector) {
                    ctx.value1 = force3;
                    ctx.proc = proc;
                    ctx.pc = 1;
                    return 0;
                }
                return -786431;
            }
            case 4: {
                final Object force4 = Promise.force(arg1, U8Vector.class);
                if (force4 instanceof U8Vector) {
                    ctx.value1 = force4;
                    ctx.proc = proc;
                    ctx.pc = 1;
                    return 0;
                }
                return -786431;
            }
            case 2: {
                ctx.value1 = Promise.force(arg1);
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
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
    public int match2(final ModuleMethod moduleMethod, final Object o, final Object o2, final CallContext ctx) {
        switch (moduleMethod.selector) {
            case 17: {
                final Object force = Promise.force(o, CharSequence.class);
                if (force instanceof CharSequence) {
                    ctx.value1 = force;
                    ctx.value2 = Promise.force(o2);
                    ctx.proc = moduleMethod;
                    ctx.pc = 2;
                    return 0;
                }
                return -786431;
            }
            case 14: {
                final Object force2 = Promise.force(o, U8Vector.class);
                if (force2 instanceof U8Vector) {
                    ctx.value1 = force2;
                    ctx.value2 = Promise.force(o2);
                    ctx.proc = moduleMethod;
                    ctx.pc = 2;
                    return 0;
                }
                return -786431;
            }
            case 7: {
                final Object force3 = Promise.force(o, U8Vector.class);
                if (force3 instanceof U8Vector) {
                    ctx.value1 = force3;
                    ctx.value2 = Promise.force(o2);
                    ctx.proc = moduleMethod;
                    ctx.pc = 2;
                    return 0;
                }
                return -786431;
            }
            case 5: {
                final Object force4 = Promise.force(o, U8Vector.class);
                if (force4 instanceof U8Vector) {
                    ctx.value1 = force4;
                    ctx.value2 = Promise.force(o2);
                    ctx.proc = moduleMethod;
                    ctx.pc = 2;
                    return 0;
                }
                return -786431;
            }
            case 2: {
                ctx.value1 = Promise.force(o);
                ctx.value2 = Promise.force(o2);
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
        switch (moduleMethod.selector) {
            case 17: {
                final Object force = Promise.force(o, CharSequence.class);
                if (force instanceof CharSequence) {
                    ctx.value1 = force;
                    ctx.value2 = Promise.force(o2);
                    ctx.value3 = Promise.force(o3);
                    ctx.proc = moduleMethod;
                    ctx.pc = 3;
                    return 0;
                }
                return -786431;
            }
            case 14: {
                final Object force2 = Promise.force(o, U8Vector.class);
                if (force2 instanceof U8Vector) {
                    ctx.value1 = force2;
                    ctx.value2 = Promise.force(o2);
                    ctx.value3 = Promise.force(o3);
                    ctx.proc = moduleMethod;
                    ctx.pc = 3;
                    return 0;
                }
                return -786431;
            }
            case 10: {
                final Object force3 = Promise.force(o, U8Vector.class);
                if (!(force3 instanceof U8Vector)) {
                    return -786431;
                }
                ctx.value1 = force3;
                ctx.value2 = Promise.force(o2);
                final Object force4 = Promise.force(o3, U8Vector.class);
                if (force4 instanceof U8Vector) {
                    ctx.value3 = force4;
                    ctx.proc = moduleMethod;
                    ctx.pc = 3;
                    return 0;
                }
                return -786429;
            }
            case 7: {
                final Object force5 = Promise.force(o, U8Vector.class);
                if (force5 instanceof U8Vector) {
                    ctx.value1 = force5;
                    ctx.value2 = Promise.force(o2);
                    ctx.value3 = Promise.force(o3);
                    ctx.proc = moduleMethod;
                    ctx.pc = 3;
                    return 0;
                }
                return -786431;
            }
            case 6: {
                final Object force6 = Promise.force(o, U8Vector.class);
                if (force6 instanceof U8Vector) {
                    ctx.value1 = force6;
                    ctx.value2 = Promise.force(o2);
                    ctx.value3 = Promise.force(o3);
                    ctx.proc = moduleMethod;
                    ctx.pc = 3;
                    return 0;
                }
                return -786431;
            }
            default: {
                return super.match3(moduleMethod, o, o2, o3, ctx);
            }
        }
    }
    
    @Override
    public int match4(final ModuleMethod moduleMethod, final Object o, final Object o2, final Object o3, final Object o4, final CallContext ctx) {
        if (moduleMethod.selector != 10) {
            return super.match4(moduleMethod, o, o2, o3, o4, ctx);
        }
        final Object force = Promise.force(o, U8Vector.class);
        if (!(force instanceof U8Vector)) {
            return -786431;
        }
        ctx.value1 = force;
        ctx.value2 = Promise.force(o2);
        final Object force2 = Promise.force(o3, U8Vector.class);
        if (force2 instanceof U8Vector) {
            ctx.value3 = force2;
            ctx.value4 = Promise.force(o4);
            ctx.proc = moduleMethod;
            ctx.pc = 4;
            return 0;
        }
        return -786429;
    }
    
    @Override
    public int matchN(final ModuleMethod proc, final Object[] args, final CallContext ctx) {
        switch (proc.selector) {
            case 13: {
                ctx.values = args;
                ctx.proc = proc;
                ctx.pc = 5;
                return 0;
            }
            case 10: {
                ctx.values = args;
                ctx.proc = proc;
                ctx.pc = 5;
                return 0;
            }
            default: {
                return super.matchN(proc, args, ctx);
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
        //     4: lookupswitch {
        //                1: 64
        //                2: 81
        //                4: 95
        //                7: 111
        //               14: 124
        //               17: 137
        //          default: 150
        //        }
        //    64: aload_2        
        //    65: invokestatic    kawa/lib/bytevectors.isBytevector:(Ljava/lang/Object;)Z
        //    68: ifeq            77
        //    71: getstatic       java/lang/Boolean.TRUE:Ljava/lang/Boolean;
        //    74: goto            80
        //    77: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //    80: areturn        
        //    81: aload_2        
        //    82: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //    85: checkcast       Ljava/lang/Number;
        //    88: invokevirtual   java/lang/Number.intValue:()I
        //    91: invokestatic    kawa/lib/bytevectors.makeBytevector:(I)Lgnu/lists/U8Vector;
        //    94: areturn        
        //    95: aload_2        
        //    96: ldc             Lgnu/lists/U8Vector;.class
        //    98: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   101: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceToU8Vector:(Ljava/lang/Object;)Lgnu/lists/U8Vector;
        //   104: invokestatic    kawa/lib/bytevectors.bytevectorLength:(Lgnu/lists/U8Vector;)I
        //   107: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //   110: areturn        
        //   111: aload_2        
        //   112: ldc             Lgnu/lists/U8Vector;.class
        //   114: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   117: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceToU8Vector:(Ljava/lang/Object;)Lgnu/lists/U8Vector;
        //   120: invokestatic    kawa/lib/bytevectors.bytevectorCopy:(Lgnu/lists/U8Vector;)Lgnu/lists/U8Vector;
        //   123: areturn        
        //   124: aload_2        
        //   125: ldc             Lgnu/lists/U8Vector;.class
        //   127: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   130: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceToU8Vector:(Ljava/lang/Object;)Lgnu/lists/U8Vector;
        //   133: invokestatic    kawa/lib/bytevectors.utf8$To$String:(Lgnu/lists/U8Vector;)Ljava/lang/CharSequence;
        //   136: areturn        
        //   137: aload_2        
        //   138: ldc             Ljava/lang/CharSequence;.class
        //   140: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   143: checkcast       Ljava/lang/CharSequence;
        //   146: invokestatic    kawa/lib/bytevectors.string$To$Utf8:(Ljava/lang/CharSequence;)Lgnu/lists/U8Vector;
        //   149: areturn        
        //   150: aload_0        
        //   151: aload_1        
        //   152: aload_2        
        //   153: invokespecial   gnu/expr/ModuleBody.apply1:(Lgnu/expr/ModuleMethod;Ljava/lang/Object;)Ljava/lang/Object;
        //   156: areturn        
        //   157: new             Lgnu/mapping/WrongType;
        //   160: dup_x1         
        //   161: swap           
        //   162: ldc_w           "make-bytevector"
        //   165: iconst_1       
        //   166: aload_2        
        //   167: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   170: athrow         
        //   171: new             Lgnu/mapping/WrongType;
        //   174: dup_x1         
        //   175: swap           
        //   176: ldc_w           "bytevector-length"
        //   179: iconst_1       
        //   180: aload_2        
        //   181: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   184: athrow         
        //   185: new             Lgnu/mapping/WrongType;
        //   188: dup_x1         
        //   189: swap           
        //   190: ldc_w           "bytevector-copy"
        //   193: iconst_1       
        //   194: aload_2        
        //   195: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   198: athrow         
        //   199: new             Lgnu/mapping/WrongType;
        //   202: dup_x1         
        //   203: swap           
        //   204: ldc_w           "utf8->string"
        //   207: iconst_1       
        //   208: aload_2        
        //   209: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   212: athrow         
        //   213: new             Lgnu/mapping/WrongType;
        //   216: dup_x1         
        //   217: swap           
        //   218: ldc_w           "string->utf8"
        //   221: iconst_1       
        //   222: aload_2        
        //   223: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   226: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  85     91     157    171    Ljava/lang/ClassCastException;
        //  101    104    171    185    Ljava/lang/ClassCastException;
        //  117    120    185    199    Ljava/lang/ClassCastException;
        //  130    133    199    213    Ljava/lang/ClassCastException;
        //  143    146    213    227    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 86 out of bounds for length 86
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
    public Object apply2(final ModuleMethod p0, final Object p1, final Object p2) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        gnu/expr/ModuleMethod.selector:I
        //     4: lookupswitch {
        //                2: 56
        //                5: 80
        //                7: 106
        //               14: 129
        //               17: 152
        //          default: 175
        //        }
        //    56: aload_2        
        //    57: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //    60: checkcast       Ljava/lang/Number;
        //    63: invokevirtual   java/lang/Number.intValue:()I
        //    66: aload_3        
        //    67: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //    70: checkcast       Ljava/lang/Number;
        //    73: invokevirtual   java/lang/Number.intValue:()I
        //    76: invokestatic    kawa/lib/bytevectors.makeBytevector:(II)Lgnu/lists/U8Vector;
        //    79: areturn        
        //    80: aload_2        
        //    81: ldc             Lgnu/lists/U8Vector;.class
        //    83: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    86: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceToU8Vector:(Ljava/lang/Object;)Lgnu/lists/U8Vector;
        //    89: aload_3        
        //    90: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //    93: checkcast       Ljava/lang/Number;
        //    96: invokevirtual   java/lang/Number.intValue:()I
        //    99: invokestatic    kawa/lib/bytevectors.bytevectorU8Ref:(Lgnu/lists/U8Vector;I)I
        //   102: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //   105: areturn        
        //   106: aload_2        
        //   107: ldc             Lgnu/lists/U8Vector;.class
        //   109: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   112: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceToU8Vector:(Ljava/lang/Object;)Lgnu/lists/U8Vector;
        //   115: aload_3        
        //   116: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   119: checkcast       Ljava/lang/Number;
        //   122: invokevirtual   java/lang/Number.intValue:()I
        //   125: invokestatic    kawa/lib/bytevectors.bytevectorCopy:(Lgnu/lists/U8Vector;I)Lgnu/lists/U8Vector;
        //   128: areturn        
        //   129: aload_2        
        //   130: ldc             Lgnu/lists/U8Vector;.class
        //   132: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   135: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceToU8Vector:(Ljava/lang/Object;)Lgnu/lists/U8Vector;
        //   138: aload_3        
        //   139: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   142: checkcast       Ljava/lang/Number;
        //   145: invokevirtual   java/lang/Number.intValue:()I
        //   148: invokestatic    kawa/lib/bytevectors.utf8$To$String:(Lgnu/lists/U8Vector;I)Ljava/lang/CharSequence;
        //   151: areturn        
        //   152: aload_2        
        //   153: ldc             Ljava/lang/CharSequence;.class
        //   155: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   158: checkcast       Ljava/lang/CharSequence;
        //   161: aload_3        
        //   162: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   165: checkcast       Ljava/lang/Number;
        //   168: invokevirtual   java/lang/Number.intValue:()I
        //   171: invokestatic    kawa/lib/bytevectors.string$To$Utf8:(Ljava/lang/CharSequence;I)Lgnu/lists/U8Vector;
        //   174: areturn        
        //   175: aload_0        
        //   176: aload_1        
        //   177: aload_2        
        //   178: aload_3        
        //   179: invokespecial   gnu/expr/ModuleBody.apply2:(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   182: areturn        
        //   183: new             Lgnu/mapping/WrongType;
        //   186: dup_x1         
        //   187: swap           
        //   188: ldc_w           "make-bytevector"
        //   191: iconst_1       
        //   192: aload_2        
        //   193: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   196: athrow         
        //   197: new             Lgnu/mapping/WrongType;
        //   200: dup_x1         
        //   201: swap           
        //   202: ldc_w           "make-bytevector"
        //   205: iconst_2       
        //   206: aload_3        
        //   207: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   210: athrow         
        //   211: new             Lgnu/mapping/WrongType;
        //   214: dup_x1         
        //   215: swap           
        //   216: ldc_w           "bytevector-u8-ref"
        //   219: iconst_1       
        //   220: aload_2        
        //   221: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   224: athrow         
        //   225: new             Lgnu/mapping/WrongType;
        //   228: dup_x1         
        //   229: swap           
        //   230: ldc_w           "bytevector-u8-ref"
        //   233: iconst_2       
        //   234: aload_3        
        //   235: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   238: athrow         
        //   239: new             Lgnu/mapping/WrongType;
        //   242: dup_x1         
        //   243: swap           
        //   244: ldc_w           "bytevector-copy"
        //   247: iconst_1       
        //   248: aload_2        
        //   249: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   252: athrow         
        //   253: new             Lgnu/mapping/WrongType;
        //   256: dup_x1         
        //   257: swap           
        //   258: ldc_w           "bytevector-copy"
        //   261: iconst_2       
        //   262: aload_3        
        //   263: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   266: athrow         
        //   267: new             Lgnu/mapping/WrongType;
        //   270: dup_x1         
        //   271: swap           
        //   272: ldc_w           "utf8->string"
        //   275: iconst_1       
        //   276: aload_2        
        //   277: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   280: athrow         
        //   281: new             Lgnu/mapping/WrongType;
        //   284: dup_x1         
        //   285: swap           
        //   286: ldc_w           "utf8->string"
        //   289: iconst_2       
        //   290: aload_3        
        //   291: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   294: athrow         
        //   295: new             Lgnu/mapping/WrongType;
        //   298: dup_x1         
        //   299: swap           
        //   300: ldc_w           "string->utf8"
        //   303: iconst_1       
        //   304: aload_2        
        //   305: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   308: athrow         
        //   309: new             Lgnu/mapping/WrongType;
        //   312: dup_x1         
        //   313: swap           
        //   314: ldc_w           "string->utf8"
        //   317: iconst_2       
        //   318: aload_3        
        //   319: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   322: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  60     66     183    197    Ljava/lang/ClassCastException;
        //  70     76     197    211    Ljava/lang/ClassCastException;
        //  86     89     211    225    Ljava/lang/ClassCastException;
        //  93     99     225    239    Ljava/lang/ClassCastException;
        //  112    115    239    253    Ljava/lang/ClassCastException;
        //  119    125    253    267    Ljava/lang/ClassCastException;
        //  135    138    267    281    Ljava/lang/ClassCastException;
        //  142    148    281    295    Ljava/lang/ClassCastException;
        //  158    161    295    309    Ljava/lang/ClassCastException;
        //  165    171    309    323    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 140 out of bounds for length 140
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
    public Object apply3(final ModuleMethod p0, final Object p1, final Object p2, final Object p3) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        gnu/expr/ModuleMethod.selector:I
        //     4: lookupswitch {
        //                6: 56
        //                7: 93
        //               10: 127
        //               14: 163
        //               17: 197
        //          default: 231
        //        }
        //    56: aload_2        
        //    57: ldc             Lgnu/lists/U8Vector;.class
        //    59: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    62: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceToU8Vector:(Ljava/lang/Object;)Lgnu/lists/U8Vector;
        //    65: aload_3        
        //    66: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //    69: checkcast       Ljava/lang/Number;
        //    72: invokevirtual   java/lang/Number.intValue:()I
        //    75: aload           4
        //    77: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //    80: checkcast       Ljava/lang/Number;
        //    83: invokevirtual   java/lang/Number.intValue:()I
        //    86: invokestatic    kawa/lib/bytevectors.bytevectorU8Set$Ex:(Lgnu/lists/U8Vector;II)V
        //    89: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //    92: areturn        
        //    93: aload_2        
        //    94: ldc             Lgnu/lists/U8Vector;.class
        //    96: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    99: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceToU8Vector:(Ljava/lang/Object;)Lgnu/lists/U8Vector;
        //   102: aload_3        
        //   103: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   106: checkcast       Ljava/lang/Number;
        //   109: invokevirtual   java/lang/Number.intValue:()I
        //   112: aload           4
        //   114: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   117: checkcast       Ljava/lang/Number;
        //   120: invokevirtual   java/lang/Number.intValue:()I
        //   123: invokestatic    kawa/lib/bytevectors.bytevectorCopy:(Lgnu/lists/U8Vector;II)Lgnu/lists/U8Vector;
        //   126: areturn        
        //   127: aload_2        
        //   128: ldc             Lgnu/lists/U8Vector;.class
        //   130: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   133: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceToU8Vector:(Ljava/lang/Object;)Lgnu/lists/U8Vector;
        //   136: aload_3        
        //   137: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   140: checkcast       Ljava/lang/Number;
        //   143: invokevirtual   java/lang/Number.intValue:()I
        //   146: aload           4
        //   148: ldc             Lgnu/lists/U8Vector;.class
        //   150: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   153: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceToU8Vector:(Ljava/lang/Object;)Lgnu/lists/U8Vector;
        //   156: invokestatic    kawa/lib/bytevectors.bytevectorCopy$Ex:(Lgnu/lists/U8Vector;ILgnu/lists/U8Vector;)V
        //   159: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //   162: areturn        
        //   163: aload_2        
        //   164: ldc             Lgnu/lists/U8Vector;.class
        //   166: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   169: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceToU8Vector:(Ljava/lang/Object;)Lgnu/lists/U8Vector;
        //   172: aload_3        
        //   173: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   176: checkcast       Ljava/lang/Number;
        //   179: invokevirtual   java/lang/Number.intValue:()I
        //   182: aload           4
        //   184: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   187: checkcast       Ljava/lang/Number;
        //   190: invokevirtual   java/lang/Number.intValue:()I
        //   193: invokestatic    kawa/lib/bytevectors.utf8$To$String:(Lgnu/lists/U8Vector;II)Ljava/lang/CharSequence;
        //   196: areturn        
        //   197: aload_2        
        //   198: ldc             Ljava/lang/CharSequence;.class
        //   200: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   203: checkcast       Ljava/lang/CharSequence;
        //   206: aload_3        
        //   207: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   210: checkcast       Ljava/lang/Number;
        //   213: invokevirtual   java/lang/Number.intValue:()I
        //   216: aload           4
        //   218: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   221: checkcast       Ljava/lang/Number;
        //   224: invokevirtual   java/lang/Number.intValue:()I
        //   227: invokestatic    kawa/lib/bytevectors.string$To$Utf8:(Ljava/lang/CharSequence;II)Lgnu/lists/U8Vector;
        //   230: areturn        
        //   231: aload_0        
        //   232: aload_1        
        //   233: aload_2        
        //   234: aload_3        
        //   235: aload           4
        //   237: invokespecial   gnu/expr/ModuleBody.apply3:(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   240: areturn        
        //   241: new             Lgnu/mapping/WrongType;
        //   244: dup_x1         
        //   245: swap           
        //   246: ldc_w           "bytevector-u8-set!"
        //   249: iconst_1       
        //   250: aload_2        
        //   251: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   254: athrow         
        //   255: new             Lgnu/mapping/WrongType;
        //   258: dup_x1         
        //   259: swap           
        //   260: ldc_w           "bytevector-u8-set!"
        //   263: iconst_2       
        //   264: aload_3        
        //   265: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   268: athrow         
        //   269: new             Lgnu/mapping/WrongType;
        //   272: dup_x1         
        //   273: swap           
        //   274: ldc_w           "bytevector-u8-set!"
        //   277: iconst_3       
        //   278: aload           4
        //   280: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   283: athrow         
        //   284: new             Lgnu/mapping/WrongType;
        //   287: dup_x1         
        //   288: swap           
        //   289: ldc_w           "bytevector-copy"
        //   292: iconst_1       
        //   293: aload_2        
        //   294: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   297: athrow         
        //   298: new             Lgnu/mapping/WrongType;
        //   301: dup_x1         
        //   302: swap           
        //   303: ldc_w           "bytevector-copy"
        //   306: iconst_2       
        //   307: aload_3        
        //   308: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   311: athrow         
        //   312: new             Lgnu/mapping/WrongType;
        //   315: dup_x1         
        //   316: swap           
        //   317: ldc_w           "bytevector-copy"
        //   320: iconst_3       
        //   321: aload           4
        //   323: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   326: athrow         
        //   327: new             Lgnu/mapping/WrongType;
        //   330: dup_x1         
        //   331: swap           
        //   332: ldc_w           "bytevector-copy!"
        //   335: iconst_1       
        //   336: aload_2        
        //   337: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   340: athrow         
        //   341: new             Lgnu/mapping/WrongType;
        //   344: dup_x1         
        //   345: swap           
        //   346: ldc_w           "bytevector-copy!"
        //   349: iconst_2       
        //   350: aload_3        
        //   351: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   354: athrow         
        //   355: new             Lgnu/mapping/WrongType;
        //   358: dup_x1         
        //   359: swap           
        //   360: ldc_w           "bytevector-copy!"
        //   363: iconst_3       
        //   364: aload           4
        //   366: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   369: athrow         
        //   370: new             Lgnu/mapping/WrongType;
        //   373: dup_x1         
        //   374: swap           
        //   375: ldc_w           "utf8->string"
        //   378: iconst_1       
        //   379: aload_2        
        //   380: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   383: athrow         
        //   384: new             Lgnu/mapping/WrongType;
        //   387: dup_x1         
        //   388: swap           
        //   389: ldc_w           "utf8->string"
        //   392: iconst_2       
        //   393: aload_3        
        //   394: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   397: athrow         
        //   398: new             Lgnu/mapping/WrongType;
        //   401: dup_x1         
        //   402: swap           
        //   403: ldc_w           "utf8->string"
        //   406: iconst_3       
        //   407: aload           4
        //   409: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   412: athrow         
        //   413: new             Lgnu/mapping/WrongType;
        //   416: dup_x1         
        //   417: swap           
        //   418: ldc_w           "string->utf8"
        //   421: iconst_1       
        //   422: aload_2        
        //   423: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   426: athrow         
        //   427: new             Lgnu/mapping/WrongType;
        //   430: dup_x1         
        //   431: swap           
        //   432: ldc_w           "string->utf8"
        //   435: iconst_2       
        //   436: aload_3        
        //   437: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   440: athrow         
        //   441: new             Lgnu/mapping/WrongType;
        //   444: dup_x1         
        //   445: swap           
        //   446: ldc_w           "string->utf8"
        //   449: iconst_3       
        //   450: aload           4
        //   452: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   455: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  62     65     241    255    Ljava/lang/ClassCastException;
        //  69     75     255    269    Ljava/lang/ClassCastException;
        //  80     86     269    284    Ljava/lang/ClassCastException;
        //  99     102    284    298    Ljava/lang/ClassCastException;
        //  106    112    298    312    Ljava/lang/ClassCastException;
        //  117    123    312    327    Ljava/lang/ClassCastException;
        //  133    136    327    341    Ljava/lang/ClassCastException;
        //  140    146    341    355    Ljava/lang/ClassCastException;
        //  153    156    355    370    Ljava/lang/ClassCastException;
        //  169    172    370    384    Ljava/lang/ClassCastException;
        //  176    182    384    398    Ljava/lang/ClassCastException;
        //  187    193    398    413    Ljava/lang/ClassCastException;
        //  203    206    413    427    Ljava/lang/ClassCastException;
        //  210    216    427    441    Ljava/lang/ClassCastException;
        //  221    227    441    456    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 202 out of bounds for length 202
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
    public Object apply4(final ModuleMethod p0, final Object p1, final Object p2, final Object p3, final Object p4) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        gnu/expr/ModuleMethod.selector:I
        //     4: bipush          10
        //     6: if_icmpne       59
        //     9: goto            12
        //    12: aload_2        
        //    13: ldc             Lgnu/lists/U8Vector;.class
        //    15: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    18: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceToU8Vector:(Ljava/lang/Object;)Lgnu/lists/U8Vector;
        //    21: aload_3        
        //    22: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //    25: checkcast       Ljava/lang/Number;
        //    28: invokevirtual   java/lang/Number.intValue:()I
        //    31: aload           4
        //    33: ldc             Lgnu/lists/U8Vector;.class
        //    35: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    38: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceToU8Vector:(Ljava/lang/Object;)Lgnu/lists/U8Vector;
        //    41: aload           5
        //    43: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //    46: checkcast       Ljava/lang/Number;
        //    49: invokevirtual   java/lang/Number.intValue:()I
        //    52: invokestatic    kawa/lib/bytevectors.bytevectorCopy$Ex:(Lgnu/lists/U8Vector;ILgnu/lists/U8Vector;I)V
        //    55: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //    58: areturn        
        //    59: aload_0        
        //    60: aload_1        
        //    61: aload_2        
        //    62: aload_3        
        //    63: aload           4
        //    65: aload           5
        //    67: invokespecial   gnu/expr/ModuleBody.apply4:(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    70: areturn        
        //    71: new             Lgnu/mapping/WrongType;
        //    74: dup_x1         
        //    75: swap           
        //    76: ldc_w           "bytevector-copy!"
        //    79: iconst_1       
        //    80: aload_2        
        //    81: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //    84: athrow         
        //    85: new             Lgnu/mapping/WrongType;
        //    88: dup_x1         
        //    89: swap           
        //    90: ldc_w           "bytevector-copy!"
        //    93: iconst_2       
        //    94: aload_3        
        //    95: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //    98: athrow         
        //    99: new             Lgnu/mapping/WrongType;
        //   102: dup_x1         
        //   103: swap           
        //   104: ldc_w           "bytevector-copy!"
        //   107: iconst_3       
        //   108: aload           4
        //   110: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   113: athrow         
        //   114: new             Lgnu/mapping/WrongType;
        //   117: dup_x1         
        //   118: swap           
        //   119: ldc_w           "bytevector-copy!"
        //   122: iconst_4       
        //   123: aload           5
        //   125: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   128: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  18     21     71     85     Ljava/lang/ClassCastException;
        //  25     31     85     99     Ljava/lang/ClassCastException;
        //  38     41     99     114    Ljava/lang/ClassCastException;
        //  46     52     114    129    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 64 out of bounds for length 64
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
    public Object applyN(final ModuleMethod p0, final Object[] p1) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        gnu/expr/ModuleMethod.selector:I
        //     4: tableswitch {
        //               20: 36
        //               21: 185
        //               22: 185
        //               23: 147
        //          default: 185
        //        }
        //    36: aload_2        
        //    37: arraylength    
        //    38: iconst_3       
        //    39: isub           
        //    40: istore_3       
        //    41: aload_2        
        //    42: iconst_0       
        //    43: aaload         
        //    44: ldc             Lgnu/lists/U8Vector;.class
        //    46: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    49: dup            
        //    50: astore          4
        //    52: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceToU8Vector:(Ljava/lang/Object;)Lgnu/lists/U8Vector;
        //    55: aload_2        
        //    56: iconst_1       
        //    57: aaload         
        //    58: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //    61: dup            
        //    62: astore          4
        //    64: checkcast       Ljava/lang/Number;
        //    67: invokevirtual   java/lang/Number.intValue:()I
        //    70: aload_2        
        //    71: iconst_2       
        //    72: aaload         
        //    73: ldc             Lgnu/lists/U8Vector;.class
        //    75: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    78: dup            
        //    79: astore          4
        //    81: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceToU8Vector:(Ljava/lang/Object;)Lgnu/lists/U8Vector;
        //    84: iload_3        
        //    85: ifgt            94
        //    88: invokestatic    kawa/lib/bytevectors.bytevectorCopy$Ex:(Lgnu/lists/U8Vector;ILgnu/lists/U8Vector;)V
        //    91: goto            143
        //    94: iinc            3, -1
        //    97: aload_2        
        //    98: iconst_3       
        //    99: aaload         
        //   100: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   103: dup            
        //   104: astore          4
        //   106: checkcast       Ljava/lang/Number;
        //   109: invokevirtual   java/lang/Number.intValue:()I
        //   112: iload_3        
        //   113: ifgt            122
        //   116: invokestatic    kawa/lib/bytevectors.bytevectorCopy$Ex:(Lgnu/lists/U8Vector;ILgnu/lists/U8Vector;I)V
        //   119: goto            143
        //   122: iinc            3, -1
        //   125: aload_2        
        //   126: iconst_4       
        //   127: aaload         
        //   128: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   131: dup            
        //   132: astore          4
        //   134: checkcast       Ljava/lang/Number;
        //   137: invokevirtual   java/lang/Number.intValue:()I
        //   140: invokestatic    kawa/lib/bytevectors.bytevectorCopy$Ex:(Lgnu/lists/U8Vector;ILgnu/lists/U8Vector;II)V
        //   143: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //   146: areturn        
        //   147: aload_2        
        //   148: arraylength    
        //   149: istore          4
        //   151: iload           4
        //   153: anewarray       Lgnu/lists/U8Vector;
        //   156: goto            173
        //   159: dup            
        //   160: iload           4
        //   162: aload_2        
        //   163: iload           4
        //   165: aaload         
        //   166: dup            
        //   167: astore          5
        //   169: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceToU8Vector:(Ljava/lang/Object;)Lgnu/lists/U8Vector;
        //   172: aastore        
        //   173: iinc            4, -1
        //   176: iload           4
        //   178: ifge            159
        //   181: invokestatic    kawa/lib/bytevectors.bytevectorAppend:([Lgnu/lists/U8Vector;)Ljava/lang/Object;
        //   184: areturn        
        //   185: aload_0        
        //   186: aload_1        
        //   187: aload_2        
        //   188: invokespecial   gnu/expr/ModuleBody.applyN:(Lgnu/expr/ModuleMethod;[Ljava/lang/Object;)Ljava/lang/Object;
        //   191: areturn        
        //   192: new             Lgnu/mapping/WrongType;
        //   195: dup_x1         
        //   196: swap           
        //   197: ldc_w           "bytevector-copy!"
        //   200: iconst_1       
        //   201: aload           4
        //   203: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   206: athrow         
        //   207: new             Lgnu/mapping/WrongType;
        //   210: dup_x1         
        //   211: swap           
        //   212: ldc_w           "bytevector-copy!"
        //   215: iconst_2       
        //   216: aload           4
        //   218: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   221: athrow         
        //   222: new             Lgnu/mapping/WrongType;
        //   225: dup_x1         
        //   226: swap           
        //   227: ldc_w           "bytevector-copy!"
        //   230: iconst_3       
        //   231: aload           4
        //   233: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   236: athrow         
        //   237: new             Lgnu/mapping/WrongType;
        //   240: dup_x1         
        //   241: swap           
        //   242: ldc_w           "bytevector-copy!"
        //   245: iconst_4       
        //   246: aload           4
        //   248: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   251: athrow         
        //   252: new             Lgnu/mapping/WrongType;
        //   255: dup_x1         
        //   256: swap           
        //   257: ldc_w           "bytevector-copy!"
        //   260: iconst_5       
        //   261: aload           4
        //   263: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   266: athrow         
        //   267: new             Lgnu/mapping/WrongType;
        //   270: dup_x1         
        //   271: swap           
        //   272: ldc_w           "bytevector-append"
        //   275: iconst_0       
        //   276: aload           5
        //   278: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   281: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  52     55     192    207    Ljava/lang/ClassCastException;
        //  64     70     207    222    Ljava/lang/ClassCastException;
        //  81     84     222    237    Ljava/lang/ClassCastException;
        //  106    112    237    252    Ljava/lang/ClassCastException;
        //  134    140    252    267    Ljava/lang/ClassCastException;
        //  169    172    267    282    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 134 out of bounds for length 134
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
