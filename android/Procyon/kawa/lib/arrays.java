// 
// Decompiled by Procyon v0.5.36
// 

package kawa.lib;

import gnu.kawa.lispexpr.LangObjType;
import gnu.mapping.Promise;
import gnu.expr.ModuleInfo;
import gnu.mapping.Symbol;
import gnu.kawa.functions.ArrayPrint;
import gnu.expr.Special;
import gnu.kawa.functions.Format;
import gnu.lists.GeneralArray;
import gnu.lists.Range;
import gnu.lists.FlattenedArray;
import gnu.lists.AVector;
import gnu.lists.ComposedArray;
import gnu.mapping.Procedure;
import gnu.lists.SimpleVector;
import gnu.lists.FVector;
import gnu.kawa.functions.Arrays;
import gnu.lists.Array;
import gnu.lists.Consumer;
import gnu.mapping.CallContext;
import gnu.mapping.SimpleSymbol;
import gnu.expr.ModuleMethod;
import gnu.expr.ModuleBody;

public class arrays extends ModuleBody
{
    public static final Class $Lsarray$Gr;
    public static final ModuleMethod array$Qu;
    public static final ModuleMethod shape;
    public static final ModuleMethod make$Mnarray;
    public static final ModuleMethod array;
    public static final ModuleMethod array$Mnrank;
    public static final ModuleMethod array$Mnsize;
    public static final ModuleMethod array$Mnstart;
    public static final ModuleMethod array$Mnend;
    public static final ModuleMethod share$Mnarray;
    public static final ModuleMethod array$Mnindex$Mnref;
    public static final ModuleMethod array$Mnindex$Mnshare;
    public static final ModuleMethod array$Mnflatten;
    public static final ModuleMethod array$Mn$Grvector;
    public static final ModuleMethod index$Mnarray;
    public static final ModuleMethod array$Mncopy$Ex;
    public static final ModuleMethod array$Mnfill$Ex;
    public static final ModuleMethod array$Mntransform;
    public static final ModuleMethod build$Mnarray;
    public static final ModuleMethod array$Mnreshape;
    public static final ModuleMethod format$Mnarray;
    public static arrays $instance;
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
    static final SimpleSymbol Lit10;
    static final SimpleSymbol Lit11;
    static final SimpleSymbol Lit12;
    static final SimpleSymbol Lit13;
    static final SimpleSymbol Lit14;
    static final SimpleSymbol Lit15;
    static final SimpleSymbol Lit16;
    static final SimpleSymbol Lit17;
    static final SimpleSymbol Lit18;
    static final SimpleSymbol Lit19;
    
    private static void $runBody$() {
        final CallContext $ctx;
        final Consumer $result = ($ctx = CallContext.getInstance()).consumer;
    }
    
    public static boolean isArray(final Object x) {
        return x instanceof Array;
    }
    
    public static Array shape(final Object... args) {
        return Arrays.shape(args);
    }
    
    public static Array makeArray(final Array shape, final Object... obj) {
        return Arrays.makeFromValues(shape, obj);
    }
    
    public static Array array(final Array shape, final Object... vals) {
        return Arrays.makeSimple(shape, new FVector(vals));
    }
    
    public static int arrayRank(final Array array) {
        return array.rank();
    }
    
    public static int arraySize(final Array arr) {
        return arr.getSize();
    }
    
    public static int arrayStart(final Array array, final int k) {
        return array.getLowBound(k);
    }
    
    public static int arrayEnd(final Array array, final int k) {
        return array.getLowBound(k) + array.getSize(k);
    }
    
    public static Array shareArray(final Array array, final Array shape, final Procedure mapper) {
        return Arrays.shareArray(array, shape, mapper);
    }
    
    public static Object arrayIndexRef(final Array arr, final Object... indexes) {
        return ComposedArray.generalIndex(arr, false, indexes);
    }
    
    public static Object arrayIndexShare(final Array arr, final Object... indexes) {
        return ComposedArray.generalIndex(arr, true, indexes);
    }
    
    public static SimpleVector<Object> arrayFlatten(final Array arr) {
        return gnu.lists.Arrays.flattenCopy((Array<Object>)arr, true);
    }
    
    public static AVector<Object> array$To$Vector(final Array arr) {
        return FlattenedArray.flatten((Array<Object>)arr);
    }
    
    public static Array indexArray(final Array shape) {
        final GeneralArray arr = Arrays.allocateArray(shape);
        arr.setBase(Range.zeroAndUp);
        return arr;
    }
    
    public static void arrayCopy$Ex(final Array dst, final Array src) {
        gnu.lists.Arrays.copy(dst, (Array<Object>)src);
    }
    
    public static void arrayFill$Ex(final Array arr, final Object value) {
        gnu.lists.Arrays.fill(arr, value);
    }
    
    public static Array arrayTransform(final Array arr, final Array shape, final Procedure mapper) {
        return Arrays.getTransformed((Array<Object>)arr, mapper, shape);
    }
    
    public static Array buildArray(final Array shape, final Procedure proc) {
        return Arrays.getBuiltArray(shape, proc);
    }
    
    public static Array arrayReshape(final Array arr, final Array shape) {
        final GeneralArray result = Arrays.allocateArray(shape);
        final AVector vec = FlattenedArray.flatten((Array<Object>)arr);
        final int vsz = vec.size();
        final int sz = result.getSize();
        if (sz != vsz) {
            exceptions.error(Format.formatToString(0, "shape requires ~d elements but argument has ~d", sz, vsz));
            throw Special.reachedUnexpected;
        }
        result.setBase(vec);
        return result;
    }
    
    public static CharSequence formatArray(final Object value) {
        return formatArray(value, null);
    }
    
    public static CharSequence formatArray(final Object value, final CharSequence elementFormat) {
        return ArrayPrint.print(value, (elementFormat == null) ? null : elementFormat.toString());
    }
    
    static {
        Lit19 = Symbol.valueOf("format-array");
        Lit18 = Symbol.valueOf("array-reshape");
        Lit17 = Symbol.valueOf("build-array");
        Lit16 = Symbol.valueOf("array-transform");
        Lit15 = Symbol.valueOf("array-fill!");
        Lit14 = Symbol.valueOf("array-copy!");
        Lit13 = Symbol.valueOf("index-array");
        Lit12 = Symbol.valueOf("array->vector");
        Lit11 = Symbol.valueOf("array-flatten");
        Lit10 = Symbol.valueOf("array-index-share");
        Lit9 = Symbol.valueOf("array-index-ref");
        Lit8 = Symbol.valueOf("share-array");
        Lit7 = Symbol.valueOf("array-end");
        Lit6 = Symbol.valueOf("array-start");
        Lit5 = Symbol.valueOf("array-size");
        Lit4 = Symbol.valueOf("array-rank");
        Lit3 = Symbol.valueOf("array");
        Lit2 = Symbol.valueOf("make-array");
        Lit1 = Symbol.valueOf("shape");
        Lit0 = Symbol.valueOf("array?");
        $Lsarray$Gr = Array.class;
        arrays.$instance = new arrays();
        final arrays $instance = arrays.$instance;
        array$Qu = new ModuleMethod($instance, 1, arrays.Lit0, 4097);
        shape = new ModuleMethod($instance, 2, arrays.Lit1, -4096);
        make$Mnarray = new ModuleMethod($instance, 3, arrays.Lit2, -4095);
        array = new ModuleMethod($instance, 4, arrays.Lit3, -4095);
        array$Mnrank = new ModuleMethod($instance, 5, arrays.Lit4, 4097);
        array$Mnsize = new ModuleMethod($instance, 6, arrays.Lit5, 4097);
        array$Mnstart = new ModuleMethod($instance, 7, arrays.Lit6, 8194);
        array$Mnend = new ModuleMethod($instance, 8, arrays.Lit7, 8194);
        share$Mnarray = new ModuleMethod($instance, 9, arrays.Lit8, 12291);
        array$Mnindex$Mnref = new ModuleMethod($instance, 10, arrays.Lit9, -4095);
        array$Mnindex$Mnshare = new ModuleMethod($instance, 11, arrays.Lit10, -4095);
        array$Mnflatten = new ModuleMethod($instance, 12, arrays.Lit11, 4097);
        array$Mn$Grvector = new ModuleMethod($instance, 13, arrays.Lit12, 4097);
        index$Mnarray = new ModuleMethod($instance, 14, arrays.Lit13, 4097);
        array$Mncopy$Ex = new ModuleMethod($instance, 15, arrays.Lit14, 8194);
        array$Mnfill$Ex = new ModuleMethod($instance, 16, arrays.Lit15, 8194);
        array$Mntransform = new ModuleMethod($instance, 17, arrays.Lit16, 12291);
        build$Mnarray = new ModuleMethod($instance, 18, arrays.Lit17, 8194);
        array$Mnreshape = new ModuleMethod($instance, 19, arrays.Lit18, 8194);
        format$Mnarray = new ModuleMethod($instance, 20, arrays.Lit19, 8193);
        $runBody$();
    }
    
    public arrays() {
        ModuleInfo.register(this);
    }
    
    @Override
    public int match1(final ModuleMethod moduleMethod, final Object o, final CallContext ctx) {
        switch (moduleMethod.selector) {
            case 20: {
                ctx.value1 = o;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 14: {
                final Object force = Promise.force(o, Array.class);
                if (!(force instanceof Array)) {
                    return -786431;
                }
                ctx.value1 = force;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 13: {
                final Object force2 = Promise.force(o, Array.class);
                if (!(force2 instanceof Array)) {
                    return -786431;
                }
                ctx.value1 = force2;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 12: {
                final Object force3 = Promise.force(o, Array.class);
                if (!(force3 instanceof Array)) {
                    return -786431;
                }
                ctx.value1 = force3;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 6: {
                final Object force4 = Promise.force(o, Array.class);
                if (!(force4 instanceof Array)) {
                    return -786431;
                }
                ctx.value1 = force4;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 5: {
                final Object force5 = Promise.force(o, Array.class);
                if (!(force5 instanceof Array)) {
                    return -786431;
                }
                ctx.value1 = force5;
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
            case 20: {
                ctx.value1 = o;
                final Object force = Promise.force(o2, CharSequence.class);
                if (force instanceof CharSequence) {
                    ctx.value2 = force;
                    ctx.proc = moduleMethod;
                    ctx.pc = 2;
                    return 0;
                }
                return -786430;
            }
            case 19: {
                final Object force2 = Promise.force(o, Array.class);
                if (!(force2 instanceof Array)) {
                    return -786431;
                }
                ctx.value1 = force2;
                final Object force3 = Promise.force(o2, Array.class);
                if (!(force3 instanceof Array)) {
                    return -786430;
                }
                ctx.value2 = force3;
                ctx.proc = moduleMethod;
                ctx.pc = 2;
                return 0;
            }
            case 18: {
                final Object force4 = Promise.force(o, Array.class);
                if (!(force4 instanceof Array)) {
                    return -786431;
                }
                ctx.value1 = force4;
                final Object force5 = Promise.force(o2, Procedure.class);
                if (LangObjType.coerceToProcedureOrNull(force5) != null) {
                    ctx.value2 = force5;
                    ctx.proc = moduleMethod;
                    ctx.pc = 2;
                    return 0;
                }
                return -786430;
            }
            case 16: {
                final Object force6 = Promise.force(o, Array.class);
                if (!(force6 instanceof Array)) {
                    return -786431;
                }
                ctx.value1 = force6;
                ctx.value2 = o2;
                ctx.proc = moduleMethod;
                ctx.pc = 2;
                return 0;
            }
            case 15: {
                final Object force7 = Promise.force(o, Array.class);
                if (!(force7 instanceof Array)) {
                    return -786431;
                }
                ctx.value1 = force7;
                final Object force8 = Promise.force(o2, Array.class);
                if (!(force8 instanceof Array)) {
                    return -786430;
                }
                ctx.value2 = force8;
                ctx.proc = moduleMethod;
                ctx.pc = 2;
                return 0;
            }
            case 8: {
                final Object force9 = Promise.force(o, Array.class);
                if (!(force9 instanceof Array)) {
                    return -786431;
                }
                ctx.value1 = force9;
                ctx.value2 = Promise.force(o2);
                ctx.proc = moduleMethod;
                ctx.pc = 2;
                return 0;
            }
            case 7: {
                final Object force10 = Promise.force(o, Array.class);
                if (!(force10 instanceof Array)) {
                    return -786431;
                }
                ctx.value1 = force10;
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
    public int match3(final ModuleMethod proc, final Object arg1, final Object arg2, final Object arg3, final CallContext ctx) {
        switch (proc.selector) {
            case 17: {
                final Object force = Promise.force(arg1, Array.class);
                if (!(force instanceof Array)) {
                    return -786431;
                }
                ctx.value1 = force;
                final Object force2 = Promise.force(arg2, Array.class);
                if (!(force2 instanceof Array)) {
                    return -786430;
                }
                ctx.value2 = force2;
                final Object force3 = Promise.force(arg3, Procedure.class);
                if (LangObjType.coerceToProcedureOrNull(force3) != null) {
                    ctx.value3 = force3;
                    ctx.proc = proc;
                    ctx.pc = 3;
                    return 0;
                }
                return -786429;
            }
            case 9: {
                final Object force4 = Promise.force(arg1, Array.class);
                if (!(force4 instanceof Array)) {
                    return -786431;
                }
                ctx.value1 = force4;
                final Object force5 = Promise.force(arg2, Array.class);
                if (!(force5 instanceof Array)) {
                    return -786430;
                }
                ctx.value2 = force5;
                final Object force6 = Promise.force(arg3, Procedure.class);
                if (LangObjType.coerceToProcedureOrNull(force6) != null) {
                    ctx.value3 = force6;
                    ctx.proc = proc;
                    ctx.pc = 3;
                    return 0;
                }
                return -786429;
            }
            default: {
                return super.match3(proc, arg1, arg2, arg3, ctx);
            }
        }
    }
    
    @Override
    public int matchN(final ModuleMethod moduleMethod, final Object[] array, final CallContext ctx) {
        switch (moduleMethod.selector) {
            case 11: {
                ctx.values = array;
                ctx.proc = moduleMethod;
                ctx.pc = 5;
                return 0;
            }
            case 10: {
                ctx.values = array;
                ctx.proc = moduleMethod;
                ctx.pc = 5;
                return 0;
            }
            case 4: {
                ctx.values = array;
                ctx.proc = moduleMethod;
                ctx.pc = 5;
                return 0;
            }
            case 3: {
                ctx.values = array;
                ctx.proc = moduleMethod;
                ctx.pc = 5;
                return 0;
            }
            case 2: {
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
    public Object apply1(final ModuleMethod p0, final Object p1) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        gnu/expr/ModuleMethod.selector:I
        //     4: lookupswitch {
        //                1: 72
        //                5: 89
        //                6: 105
        //               12: 121
        //               13: 134
        //               14: 147
        //               20: 160
        //          default: 165
        //        }
        //    72: aload_2        
        //    73: invokestatic    kawa/lib/arrays.isArray:(Ljava/lang/Object;)Z
        //    76: ifeq            85
        //    79: getstatic       java/lang/Boolean.TRUE:Ljava/lang/Boolean;
        //    82: goto            88
        //    85: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //    88: areturn        
        //    89: aload_2        
        //    90: ldc             Lgnu/lists/Array;.class
        //    92: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    95: checkcast       Lgnu/lists/Array;
        //    98: invokestatic    kawa/lib/arrays.arrayRank:(Lgnu/lists/Array;)I
        //   101: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //   104: areturn        
        //   105: aload_2        
        //   106: ldc             Lgnu/lists/Array;.class
        //   108: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   111: checkcast       Lgnu/lists/Array;
        //   114: invokestatic    kawa/lib/arrays.arraySize:(Lgnu/lists/Array;)I
        //   117: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //   120: areturn        
        //   121: aload_2        
        //   122: ldc             Lgnu/lists/Array;.class
        //   124: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   127: checkcast       Lgnu/lists/Array;
        //   130: invokestatic    kawa/lib/arrays.arrayFlatten:(Lgnu/lists/Array;)Lgnu/lists/SimpleVector;
        //   133: areturn        
        //   134: aload_2        
        //   135: ldc             Lgnu/lists/Array;.class
        //   137: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   140: checkcast       Lgnu/lists/Array;
        //   143: invokestatic    kawa/lib/arrays.array$To$Vector:(Lgnu/lists/Array;)Lgnu/lists/AVector;
        //   146: areturn        
        //   147: aload_2        
        //   148: ldc             Lgnu/lists/Array;.class
        //   150: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   153: checkcast       Lgnu/lists/Array;
        //   156: invokestatic    kawa/lib/arrays.indexArray:(Lgnu/lists/Array;)Lgnu/lists/Array;
        //   159: areturn        
        //   160: aload_2        
        //   161: invokestatic    kawa/lib/arrays.formatArray:(Ljava/lang/Object;)Ljava/lang/CharSequence;
        //   164: areturn        
        //   165: aload_0        
        //   166: aload_1        
        //   167: aload_2        
        //   168: invokespecial   gnu/expr/ModuleBody.apply1:(Lgnu/expr/ModuleMethod;Ljava/lang/Object;)Ljava/lang/Object;
        //   171: areturn        
        //   172: new             Lgnu/mapping/WrongType;
        //   175: dup_x1         
        //   176: swap           
        //   177: ldc_w           "array-rank"
        //   180: iconst_1       
        //   181: aload_2        
        //   182: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   185: athrow         
        //   186: new             Lgnu/mapping/WrongType;
        //   189: dup_x1         
        //   190: swap           
        //   191: ldc_w           "array-size"
        //   194: iconst_1       
        //   195: aload_2        
        //   196: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   199: athrow         
        //   200: new             Lgnu/mapping/WrongType;
        //   203: dup_x1         
        //   204: swap           
        //   205: ldc_w           "array-flatten"
        //   208: iconst_1       
        //   209: aload_2        
        //   210: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   213: athrow         
        //   214: new             Lgnu/mapping/WrongType;
        //   217: dup_x1         
        //   218: swap           
        //   219: ldc_w           "array->vector"
        //   222: iconst_1       
        //   223: aload_2        
        //   224: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   227: athrow         
        //   228: new             Lgnu/mapping/WrongType;
        //   231: dup_x1         
        //   232: swap           
        //   233: ldc_w           "index-array"
        //   236: iconst_1       
        //   237: aload_2        
        //   238: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   241: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  95     98     172    186    Ljava/lang/ClassCastException;
        //  111    114    186    200    Ljava/lang/ClassCastException;
        //  127    130    200    214    Ljava/lang/ClassCastException;
        //  140    143    214    228    Ljava/lang/ClassCastException;
        //  153    156    228    242    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 90 out of bounds for length 90
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
        //     4: tableswitch {
        //               14: 76
        //               15: 102
        //               16: 230
        //               17: 230
        //               18: 230
        //               19: 230
        //               20: 230
        //               21: 230
        //               22: 128
        //               23: 153
        //               24: 230
        //               25: 170
        //               26: 193
        //               27: 215
        //          default: 230
        //        }
        //    76: aload_2        
        //    77: ldc             Lgnu/lists/Array;.class
        //    79: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    82: checkcast       Lgnu/lists/Array;
        //    85: aload_3        
        //    86: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //    89: checkcast       Ljava/lang/Number;
        //    92: invokevirtual   java/lang/Number.intValue:()I
        //    95: invokestatic    kawa/lib/arrays.arrayStart:(Lgnu/lists/Array;I)I
        //    98: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //   101: areturn        
        //   102: aload_2        
        //   103: ldc             Lgnu/lists/Array;.class
        //   105: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   108: checkcast       Lgnu/lists/Array;
        //   111: aload_3        
        //   112: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   115: checkcast       Ljava/lang/Number;
        //   118: invokevirtual   java/lang/Number.intValue:()I
        //   121: invokestatic    kawa/lib/arrays.arrayEnd:(Lgnu/lists/Array;I)I
        //   124: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //   127: areturn        
        //   128: aload_2        
        //   129: ldc             Lgnu/lists/Array;.class
        //   131: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   134: checkcast       Lgnu/lists/Array;
        //   137: aload_3        
        //   138: ldc             Lgnu/lists/Array;.class
        //   140: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   143: checkcast       Lgnu/lists/Array;
        //   146: invokestatic    kawa/lib/arrays.arrayCopy$Ex:(Lgnu/lists/Array;Lgnu/lists/Array;)V
        //   149: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //   152: areturn        
        //   153: aload_2        
        //   154: ldc             Lgnu/lists/Array;.class
        //   156: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   159: checkcast       Lgnu/lists/Array;
        //   162: aload_3        
        //   163: invokestatic    kawa/lib/arrays.arrayFill$Ex:(Lgnu/lists/Array;Ljava/lang/Object;)V
        //   166: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //   169: areturn        
        //   170: aload_2        
        //   171: ldc             Lgnu/lists/Array;.class
        //   173: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   176: checkcast       Lgnu/lists/Array;
        //   179: aload_3        
        //   180: ldc_w           Lgnu/mapping/Procedure;.class
        //   183: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   186: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceToProcedure:(Ljava/lang/Object;)Lgnu/mapping/Procedure;
        //   189: invokestatic    kawa/lib/arrays.buildArray:(Lgnu/lists/Array;Lgnu/mapping/Procedure;)Lgnu/lists/Array;
        //   192: areturn        
        //   193: aload_2        
        //   194: ldc             Lgnu/lists/Array;.class
        //   196: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   199: checkcast       Lgnu/lists/Array;
        //   202: aload_3        
        //   203: ldc             Lgnu/lists/Array;.class
        //   205: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   208: checkcast       Lgnu/lists/Array;
        //   211: invokestatic    kawa/lib/arrays.arrayReshape:(Lgnu/lists/Array;Lgnu/lists/Array;)Lgnu/lists/Array;
        //   214: areturn        
        //   215: aload_2        
        //   216: aload_3        
        //   217: ldc_w           Ljava/lang/CharSequence;.class
        //   220: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   223: checkcast       Ljava/lang/CharSequence;
        //   226: invokestatic    kawa/lib/arrays.formatArray:(Ljava/lang/Object;Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
        //   229: areturn        
        //   230: aload_0        
        //   231: aload_1        
        //   232: aload_2        
        //   233: aload_3        
        //   234: invokespecial   gnu/expr/ModuleBody.apply2:(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   237: areturn        
        //   238: new             Lgnu/mapping/WrongType;
        //   241: dup_x1         
        //   242: swap           
        //   243: ldc_w           "array-start"
        //   246: iconst_1       
        //   247: aload_2        
        //   248: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   251: athrow         
        //   252: new             Lgnu/mapping/WrongType;
        //   255: dup_x1         
        //   256: swap           
        //   257: ldc_w           "array-start"
        //   260: iconst_2       
        //   261: aload_3        
        //   262: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   265: athrow         
        //   266: new             Lgnu/mapping/WrongType;
        //   269: dup_x1         
        //   270: swap           
        //   271: ldc_w           "array-end"
        //   274: iconst_1       
        //   275: aload_2        
        //   276: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   279: athrow         
        //   280: new             Lgnu/mapping/WrongType;
        //   283: dup_x1         
        //   284: swap           
        //   285: ldc_w           "array-end"
        //   288: iconst_2       
        //   289: aload_3        
        //   290: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   293: athrow         
        //   294: new             Lgnu/mapping/WrongType;
        //   297: dup_x1         
        //   298: swap           
        //   299: ldc_w           "array-copy!"
        //   302: iconst_1       
        //   303: aload_2        
        //   304: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   307: athrow         
        //   308: new             Lgnu/mapping/WrongType;
        //   311: dup_x1         
        //   312: swap           
        //   313: ldc_w           "array-copy!"
        //   316: iconst_2       
        //   317: aload_3        
        //   318: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   321: athrow         
        //   322: new             Lgnu/mapping/WrongType;
        //   325: dup_x1         
        //   326: swap           
        //   327: ldc_w           "array-fill!"
        //   330: iconst_1       
        //   331: aload_2        
        //   332: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   335: athrow         
        //   336: new             Lgnu/mapping/WrongType;
        //   339: dup_x1         
        //   340: swap           
        //   341: ldc_w           "build-array"
        //   344: iconst_1       
        //   345: aload_2        
        //   346: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   349: athrow         
        //   350: new             Lgnu/mapping/WrongType;
        //   353: dup_x1         
        //   354: swap           
        //   355: ldc_w           "build-array"
        //   358: iconst_2       
        //   359: aload_3        
        //   360: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   363: athrow         
        //   364: new             Lgnu/mapping/WrongType;
        //   367: dup_x1         
        //   368: swap           
        //   369: ldc_w           "array-reshape"
        //   372: iconst_1       
        //   373: aload_2        
        //   374: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   377: athrow         
        //   378: new             Lgnu/mapping/WrongType;
        //   381: dup_x1         
        //   382: swap           
        //   383: ldc_w           "array-reshape"
        //   386: iconst_2       
        //   387: aload_3        
        //   388: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   391: athrow         
        //   392: new             Lgnu/mapping/WrongType;
        //   395: dup_x1         
        //   396: swap           
        //   397: ldc_w           "format-array"
        //   400: iconst_2       
        //   401: aload_3        
        //   402: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   405: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  82     85     238    252    Ljava/lang/ClassCastException;
        //  89     95     252    266    Ljava/lang/ClassCastException;
        //  108    111    266    280    Ljava/lang/ClassCastException;
        //  115    121    280    294    Ljava/lang/ClassCastException;
        //  134    137    294    308    Ljava/lang/ClassCastException;
        //  143    146    308    322    Ljava/lang/ClassCastException;
        //  159    162    322    336    Ljava/lang/ClassCastException;
        //  176    179    336    350    Ljava/lang/ClassCastException;
        //  186    189    350    364    Ljava/lang/ClassCastException;
        //  199    202    364    378    Ljava/lang/ClassCastException;
        //  208    211    378    392    Ljava/lang/ClassCastException;
        //  223    226    392    406    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 173 out of bounds for length 173
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
        //                9: 32
        //               17: 65
        //          default: 98
        //        }
        //    32: aload_2        
        //    33: ldc             Lgnu/lists/Array;.class
        //    35: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    38: checkcast       Lgnu/lists/Array;
        //    41: aload_3        
        //    42: ldc             Lgnu/lists/Array;.class
        //    44: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    47: checkcast       Lgnu/lists/Array;
        //    50: aload           4
        //    52: ldc_w           Lgnu/mapping/Procedure;.class
        //    55: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    58: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceToProcedure:(Ljava/lang/Object;)Lgnu/mapping/Procedure;
        //    61: invokestatic    kawa/lib/arrays.shareArray:(Lgnu/lists/Array;Lgnu/lists/Array;Lgnu/mapping/Procedure;)Lgnu/lists/Array;
        //    64: areturn        
        //    65: aload_2        
        //    66: ldc             Lgnu/lists/Array;.class
        //    68: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    71: checkcast       Lgnu/lists/Array;
        //    74: aload_3        
        //    75: ldc             Lgnu/lists/Array;.class
        //    77: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    80: checkcast       Lgnu/lists/Array;
        //    83: aload           4
        //    85: ldc_w           Lgnu/mapping/Procedure;.class
        //    88: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    91: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceToProcedure:(Ljava/lang/Object;)Lgnu/mapping/Procedure;
        //    94: invokestatic    kawa/lib/arrays.arrayTransform:(Lgnu/lists/Array;Lgnu/lists/Array;Lgnu/mapping/Procedure;)Lgnu/lists/Array;
        //    97: areturn        
        //    98: aload_0        
        //    99: aload_1        
        //   100: aload_2        
        //   101: aload_3        
        //   102: aload           4
        //   104: invokespecial   gnu/expr/ModuleBody.apply3:(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   107: areturn        
        //   108: new             Lgnu/mapping/WrongType;
        //   111: dup_x1         
        //   112: swap           
        //   113: ldc_w           "share-array"
        //   116: iconst_1       
        //   117: aload_2        
        //   118: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   121: athrow         
        //   122: new             Lgnu/mapping/WrongType;
        //   125: dup_x1         
        //   126: swap           
        //   127: ldc_w           "share-array"
        //   130: iconst_2       
        //   131: aload_3        
        //   132: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   135: athrow         
        //   136: new             Lgnu/mapping/WrongType;
        //   139: dup_x1         
        //   140: swap           
        //   141: ldc_w           "share-array"
        //   144: iconst_3       
        //   145: aload           4
        //   147: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   150: athrow         
        //   151: new             Lgnu/mapping/WrongType;
        //   154: dup_x1         
        //   155: swap           
        //   156: ldc_w           "array-transform"
        //   159: iconst_1       
        //   160: aload_2        
        //   161: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   164: athrow         
        //   165: new             Lgnu/mapping/WrongType;
        //   168: dup_x1         
        //   169: swap           
        //   170: ldc_w           "array-transform"
        //   173: iconst_2       
        //   174: aload_3        
        //   175: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   178: athrow         
        //   179: new             Lgnu/mapping/WrongType;
        //   182: dup_x1         
        //   183: swap           
        //   184: ldc_w           "array-transform"
        //   187: iconst_3       
        //   188: aload           4
        //   190: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   193: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  38     41     108    122    Ljava/lang/ClassCastException;
        //  47     50     122    136    Ljava/lang/ClassCastException;
        //  58     61     136    151    Ljava/lang/ClassCastException;
        //  71     74     151    165    Ljava/lang/ClassCastException;
        //  80     83     165    179    Ljava/lang/ClassCastException;
        //  91     94     179    194    Ljava/lang/ClassCastException;
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
    public Object applyN(final ModuleMethod p0, final Object[] p1) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        gnu/expr/ModuleMethod.selector:I
        //     4: tableswitch {
        //                4: 60
        //                5: 65
        //                6: 109
        //                7: 241
        //                8: 241
        //                9: 241
        //               10: 241
        //               11: 241
        //               12: 153
        //               13: 197
        //          default: 241
        //        }
        //    60: aload_2        
        //    61: invokestatic    kawa/lib/arrays.shape:([Ljava/lang/Object;)Lgnu/lists/Array;
        //    64: areturn        
        //    65: aload_2        
        //    66: iconst_0       
        //    67: aaload         
        //    68: ldc             Lgnu/lists/Array;.class
        //    70: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    73: dup            
        //    74: astore_3       
        //    75: checkcast       Lgnu/lists/Array;
        //    78: aload_2        
        //    79: arraylength    
        //    80: iconst_1       
        //    81: isub           
        //    82: istore_3       
        //    83: iload_3        
        //    84: anewarray       Ljava/lang/Object;
        //    87: goto            98
        //    90: dup            
        //    91: iload_3        
        //    92: aload_2        
        //    93: iload_3        
        //    94: iconst_1       
        //    95: iadd           
        //    96: aaload         
        //    97: aastore        
        //    98: iinc            3, -1
        //   101: iload_3        
        //   102: ifge            90
        //   105: invokestatic    kawa/lib/arrays.makeArray:(Lgnu/lists/Array;[Ljava/lang/Object;)Lgnu/lists/Array;
        //   108: areturn        
        //   109: aload_2        
        //   110: iconst_0       
        //   111: aaload         
        //   112: ldc             Lgnu/lists/Array;.class
        //   114: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   117: dup            
        //   118: astore_3       
        //   119: checkcast       Lgnu/lists/Array;
        //   122: aload_2        
        //   123: arraylength    
        //   124: iconst_1       
        //   125: isub           
        //   126: istore_3       
        //   127: iload_3        
        //   128: anewarray       Ljava/lang/Object;
        //   131: goto            142
        //   134: dup            
        //   135: iload_3        
        //   136: aload_2        
        //   137: iload_3        
        //   138: iconst_1       
        //   139: iadd           
        //   140: aaload         
        //   141: aastore        
        //   142: iinc            3, -1
        //   145: iload_3        
        //   146: ifge            134
        //   149: invokestatic    kawa/lib/arrays.array:(Lgnu/lists/Array;[Ljava/lang/Object;)Lgnu/lists/Array;
        //   152: areturn        
        //   153: aload_2        
        //   154: iconst_0       
        //   155: aaload         
        //   156: ldc             Lgnu/lists/Array;.class
        //   158: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   161: dup            
        //   162: astore_3       
        //   163: checkcast       Lgnu/lists/Array;
        //   166: aload_2        
        //   167: arraylength    
        //   168: iconst_1       
        //   169: isub           
        //   170: istore_3       
        //   171: iload_3        
        //   172: anewarray       Ljava/lang/Object;
        //   175: goto            186
        //   178: dup            
        //   179: iload_3        
        //   180: aload_2        
        //   181: iload_3        
        //   182: iconst_1       
        //   183: iadd           
        //   184: aaload         
        //   185: aastore        
        //   186: iinc            3, -1
        //   189: iload_3        
        //   190: ifge            178
        //   193: invokestatic    kawa/lib/arrays.arrayIndexRef:(Lgnu/lists/Array;[Ljava/lang/Object;)Ljava/lang/Object;
        //   196: areturn        
        //   197: aload_2        
        //   198: iconst_0       
        //   199: aaload         
        //   200: ldc             Lgnu/lists/Array;.class
        //   202: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   205: dup            
        //   206: astore_3       
        //   207: checkcast       Lgnu/lists/Array;
        //   210: aload_2        
        //   211: arraylength    
        //   212: iconst_1       
        //   213: isub           
        //   214: istore_3       
        //   215: iload_3        
        //   216: anewarray       Ljava/lang/Object;
        //   219: goto            230
        //   222: dup            
        //   223: iload_3        
        //   224: aload_2        
        //   225: iload_3        
        //   226: iconst_1       
        //   227: iadd           
        //   228: aaload         
        //   229: aastore        
        //   230: iinc            3, -1
        //   233: iload_3        
        //   234: ifge            222
        //   237: invokestatic    kawa/lib/arrays.arrayIndexShare:(Lgnu/lists/Array;[Ljava/lang/Object;)Ljava/lang/Object;
        //   240: areturn        
        //   241: aload_0        
        //   242: aload_1        
        //   243: aload_2        
        //   244: invokespecial   gnu/expr/ModuleBody.applyN:(Lgnu/expr/ModuleMethod;[Ljava/lang/Object;)Ljava/lang/Object;
        //   247: areturn        
        //   248: new             Lgnu/mapping/WrongType;
        //   251: dup_x1         
        //   252: swap           
        //   253: ldc_w           "make-array"
        //   256: iconst_1       
        //   257: aload_3        
        //   258: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   261: athrow         
        //   262: new             Lgnu/mapping/WrongType;
        //   265: dup_x1         
        //   266: swap           
        //   267: ldc_w           "array"
        //   270: iconst_1       
        //   271: aload_3        
        //   272: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   275: athrow         
        //   276: new             Lgnu/mapping/WrongType;
        //   279: dup_x1         
        //   280: swap           
        //   281: ldc_w           "array-index-ref"
        //   284: iconst_1       
        //   285: aload_3        
        //   286: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   289: athrow         
        //   290: new             Lgnu/mapping/WrongType;
        //   293: dup_x1         
        //   294: swap           
        //   295: ldc_w           "array-index-share"
        //   298: iconst_1       
        //   299: aload_3        
        //   300: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   303: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  75     78     248    262    Ljava/lang/ClassCastException;
        //  119    122    262    276    Ljava/lang/ClassCastException;
        //  163    166    276    290    Ljava/lang/ClassCastException;
        //  207    210    290    304    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 159 out of bounds for length 159
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
