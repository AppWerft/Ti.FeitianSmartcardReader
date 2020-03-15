// 
// Decompiled by Procyon v0.5.36
// 

package kawa.lib.rnrs;

import gnu.kawa.lispexpr.LangObjType;
import gnu.expr.ModuleInfo;
import gnu.mapping.Symbol;
import gnu.mapping.Values;
import gnu.kawa.functions.IsEqv;
import gnu.expr.KawaConvert;
import gnu.kawa.functions.Apply;
import gnu.mapping.WrongType;
import gnu.mapping.Promise;
import kawa.standard.Scheme;
import gnu.lists.Pair;
import kawa.lang.Continuation;
import gnu.lists.LList;
import gnu.mapping.Procedure;
import gnu.lists.Consumer;
import gnu.mapping.CallContext;
import gnu.mapping.SimpleSymbol;
import gnu.kawa.reflect.StaticFieldLocation;
import gnu.expr.ModuleMethod;
import gnu.expr.ModuleBody;

public class lists extends ModuleBody
{
    public static final ModuleMethod find;
    public static final ModuleMethod for$Mnall;
    public static final ModuleMethod exists;
    public static final ModuleMethod filter;
    public static final ModuleMethod partition;
    public static final ModuleMethod fold$Mnleft;
    public static final ModuleMethod fold$Mnright;
    public static final ModuleMethod remp;
    public static final ModuleMethod remove;
    public static final ModuleMethod remv;
    public static final ModuleMethod remq;
    public static final ModuleMethod memp;
    public static final StaticFieldLocation member;
    public static final StaticFieldLocation memv;
    public static final StaticFieldLocation memq;
    public static final ModuleMethod assp;
    public static final StaticFieldLocation assoc;
    public static final StaticFieldLocation assv;
    public static final StaticFieldLocation assq;
    public static final ModuleMethod cons$St;
    public static lists $instance;
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
    
    private static void $runBody$() {
        final CallContext $ctx;
        final Consumer $result = ($ctx = CallContext.getInstance()).consumer;
    }
    
    public static Object find(final Procedure proc, final LList lst) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: astore_2        /* list */
        //     2: aload_2         /* list */
        //     3: invokestatic    kawa/lib/lists.isNull:(Ljava/lang/Object;)Z
        //     6: ifeq            15
        //     9: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //    12: goto            64
        //    15: aload_2         /* list */
        //    16: ldc             Lgnu/lists/Pair;.class
        //    18: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    21: dup            
        //    22: astore          4
        //    24: checkcast       Lgnu/lists/Pair;
        //    27: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    30: astore_3        /* x */
        //    31: aload_0         /* proc */
        //    32: aload_3         /* x */
        //    33: invokevirtual   gnu/mapping/Procedure.apply1:(Ljava/lang/Object;)Ljava/lang/Object;
        //    36: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //    39: ifeq            46
        //    42: aload_3         /* x */
        //    43: goto            64
        //    46: aload_2         /* list */
        //    47: ldc             Lgnu/lists/Pair;.class
        //    49: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    52: dup            
        //    53: astore          4
        //    55: checkcast       Lgnu/lists/Pair;
        //    58: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    61: goto            1
        //    64: areturn        
        //    65: new             Lgnu/mapping/WrongType;
        //    68: dup_x1         
        //    69: swap           
        //    70: ldc             "car"
        //    72: iconst_1       
        //    73: aload           4
        //    75: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //    78: athrow         
        //    79: new             Lgnu/mapping/WrongType;
        //    82: dup_x1         
        //    83: swap           
        //    84: ldc             "cdr"
        //    86: iconst_1       
        //    87: aload           4
        //    89: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //    92: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  24     27     65     79     Ljava/lang/ClassCastException;
        //  55     58     79     93     Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0064:
        //     at com.strobel.decompiler.ast.Error.expressionLinkedFromMultipleLocations(Error.java:27)
        //     at com.strobel.decompiler.ast.AstOptimizer.mergeDisparateObjectInitializations(AstOptimizer.java:2596)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:235)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:42)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:214)
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
    
    public static Object forAll$V(final Procedure proc, final LList list1, final Object[] argsArray) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: iconst_0       
        //     2: invokestatic    gnu/lists/LList.makeList:([Ljava/lang/Object;I)Lgnu/lists/LList;
        //     5: dup            
        //     6: astore          4
        //     8: astore_3        /* lists */
        //     9: aload_3         /* lists */
        //    10: invokestatic    kawa/lib/lists.isPair:(Ljava/lang/Object;)Z
        //    13: ifeq            215
        //    16: aload_1         /* list1 */
        //    17: aload_3         /* lists */
        //    18: invokestatic    kawa/lib/lists.cons:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //    21: invokestatic    kawa/lib/rnrs/lists.$PcCars$PlCdrs:(Lgnu/lists/LList;)Ljava/lang/Object;
        //    24: astore          4
        //    26: iconst_0       
        //    27: istore          5
        //    29: aload           4
        //    31: iload           5
        //    33: invokestatic    gnu/mapping/Values.incrPos:(Ljava/lang/Object;I)I
        //    36: istore          5
        //    38: aload           4
        //    40: iload           5
        //    42: invokestatic    gnu/mapping/Values.getFromPos:(Ljava/lang/Object;I)Ljava/lang/Object;
        //    45: astore          6
        //    47: aload           4
        //    49: iload           5
        //    51: invokestatic    gnu/mapping/Values.incrPos:(Ljava/lang/Object;I)I
        //    54: istore          5
        //    56: aload           4
        //    58: iload           5
        //    60: invokestatic    gnu/mapping/Values.getFromPosFinal:(Ljava/lang/Object;I)Ljava/lang/Object;
        //    63: astore          tails
        //    65: aload           heads
        //    67: invokestatic    kawa/lib/lists.isPair:(Ljava/lang/Object;)Z
        //    70: ifeq            77
        //    73: iconst_0       
        //    74: goto            78
        //    77: iconst_1       
        //    78: istore          x
        //    80: iload           x
        //    82: ifeq            102
        //    85: iload           x
        //    87: ifeq            96
        //    90: getstatic       java/lang/Boolean.TRUE:Ljava/lang/Boolean;
        //    93: goto            334
        //    96: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //    99: goto            334
        //   102: aload           heads
        //   104: aload           tails
        //   106: astore          10
        //   108: astore          heads
        //   110: aload           tails
        //   112: ldc             Lgnu/lists/LList;.class
        //   114: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   117: dup            
        //   118: astore          12
        //   120: checkcast       Lgnu/lists/LList;
        //   123: invokestatic    kawa/lib/rnrs/lists.$PcCars$PlCdrs:(Lgnu/lists/LList;)Ljava/lang/Object;
        //   126: astore          11
        //   128: iconst_0       
        //   129: istore          12
        //   131: aload           11
        //   133: iload           12
        //   135: invokestatic    gnu/mapping/Values.incrPos:(Ljava/lang/Object;I)I
        //   138: istore          12
        //   140: aload           11
        //   142: iload           12
        //   144: invokestatic    gnu/mapping/Values.getFromPos:(Ljava/lang/Object;I)Ljava/lang/Object;
        //   147: astore          13
        //   149: aload           11
        //   151: iload           12
        //   153: invokestatic    gnu/mapping/Values.incrPos:(Ljava/lang/Object;I)I
        //   156: istore          12
        //   158: aload           11
        //   160: iload           12
        //   162: invokestatic    gnu/mapping/Values.getFromPosFinal:(Ljava/lang/Object;I)Ljava/lang/Object;
        //   165: astore          next$Mntails
        //   167: aload           next$Mnheads
        //   169: invokestatic    kawa/lib/lists.isPair:(Ljava/lang/Object;)Z
        //   172: ifeq            203
        //   175: getstatic       kawa/standard/Scheme.apply:Lgnu/kawa/functions/Apply;
        //   178: aload_0         /* proc */
        //   179: aload           heads
        //   181: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   184: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //   187: ifeq            197
        //   190: aload           next$Mnheads
        //   192: aload           next$Mntails
        //   194: goto            106
        //   197: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //   200: goto            334
        //   203: getstatic       kawa/standard/Scheme.apply:Lgnu/kawa/functions/Apply;
        //   206: aload_0         /* proc */
        //   207: aload           heads
        //   209: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   212: goto            334
        //   215: aload_1         /* list1 */
        //   216: invokestatic    kawa/lib/lists.isNull:(Ljava/lang/Object;)Z
        //   219: istore          x
        //   221: iload           x
        //   223: ifeq            243
        //   226: iload           x
        //   228: ifeq            237
        //   231: getstatic       java/lang/Boolean.TRUE:Ljava/lang/Boolean;
        //   234: goto            334
        //   237: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //   240: goto            334
        //   243: aload_1         /* list1 */
        //   244: dup            
        //   245: astore          5
        //   247: checkcast       Lgnu/lists/Pair;
        //   250: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   253: aload_1         /* list1 */
        //   254: dup            
        //   255: astore          5
        //   257: checkcast       Lgnu/lists/Pair;
        //   260: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   263: astore          6
        //   265: astore          head
        //   267: aload           tail
        //   269: invokestatic    kawa/lib/lists.isNull:(Ljava/lang/Object;)Z
        //   272: ifeq            284
        //   275: aload_0         /* proc */
        //   276: aload           head
        //   278: invokevirtual   gnu/mapping/Procedure.apply1:(Ljava/lang/Object;)Ljava/lang/Object;
        //   281: goto            334
        //   284: aload_0         /* proc */
        //   285: aload           head
        //   287: invokevirtual   gnu/mapping/Procedure.apply1:(Ljava/lang/Object;)Ljava/lang/Object;
        //   290: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //   293: ifeq            331
        //   296: aload           tail
        //   298: ldc             Lgnu/lists/Pair;.class
        //   300: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   303: dup            
        //   304: astore          7
        //   306: checkcast       Lgnu/lists/Pair;
        //   309: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   312: aload           tail
        //   314: ldc             Lgnu/lists/Pair;.class
        //   316: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   319: dup            
        //   320: astore          7
        //   322: checkcast       Lgnu/lists/Pair;
        //   325: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   328: goto            263
        //   331: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //   334: areturn        
        //   335: new             Lgnu/mapping/WrongType;
        //   338: dup_x1         
        //   339: swap           
        //   340: ldc             "%cars+cdrs"
        //   342: iconst_0       
        //   343: aload           12
        //   345: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   348: athrow         
        //   349: new             Lgnu/mapping/WrongType;
        //   352: dup_x1         
        //   353: swap           
        //   354: ldc             "car"
        //   356: iconst_1       
        //   357: aload           5
        //   359: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   362: athrow         
        //   363: new             Lgnu/mapping/WrongType;
        //   366: dup_x1         
        //   367: swap           
        //   368: ldc             "cdr"
        //   370: iconst_1       
        //   371: aload           5
        //   373: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   376: athrow         
        //   377: new             Lgnu/mapping/WrongType;
        //   380: dup_x1         
        //   381: swap           
        //   382: ldc             "car"
        //   384: iconst_1       
        //   385: aload           7
        //   387: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   390: athrow         
        //   391: new             Lgnu/mapping/WrongType;
        //   394: dup_x1         
        //   395: swap           
        //   396: ldc             "cdr"
        //   398: iconst_1       
        //   399: aload           7
        //   401: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   404: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  120    123    335    349    Ljava/lang/ClassCastException;
        //  247    250    349    363    Ljava/lang/ClassCastException;
        //  257    260    363    377    Ljava/lang/ClassCastException;
        //  306    309    377    391    Ljava/lang/ClassCastException;
        //  322    325    391    405    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    static Object $PcCars$PlCdrs(final LList lists) {
        final CallContext $ctx;
        final Continuation cont = new Continuation($ctx = CallContext.getInstance());
        Object handleException = null;
        try {
            final Continuation abort = cont;
            public class lists$frame4 extends ModuleBody
            {
                Continuation abort;
                
                public Object lambda7recur(final Object lists) {
                    // 
                    // This method could not be decompiled.
                    // 
                    // Original Bytecode:
                    // 
                    //     1: invokestatic    kawa/lib/lists.isPair:(Ljava/lang/Object;)Z
                    //     4: ifeq            198
                    //     7: aload_1         /* lists */
                    //     8: ldc             Lgnu/lists/Pair;.class
                    //    10: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                    //    13: dup            
                    //    14: astore_3       
                    //    15: checkcast       Lgnu/lists/Pair;
                    //    18: invokestatic    kawa/lib/rnrs/lists.car$PlCdr:(Lgnu/lists/Pair;)Lgnu/mapping/Values;
                    //    21: astore_2       
                    //    22: iconst_0       
                    //    23: istore_3       
                    //    24: aload_2        
                    //    25: iload_3        
                    //    26: invokestatic    gnu/mapping/Values.incrPos:(Ljava/lang/Object;I)I
                    //    29: istore_3       
                    //    30: aload_2        
                    //    31: iload_3        
                    //    32: invokestatic    gnu/mapping/Values.getFromPos:(Ljava/lang/Object;I)Ljava/lang/Object;
                    //    35: astore          4
                    //    37: aload_2        
                    //    38: iload_3        
                    //    39: invokestatic    gnu/mapping/Values.incrPos:(Ljava/lang/Object;I)I
                    //    42: istore_3       
                    //    43: aload_2        
                    //    44: iload_3        
                    //    45: invokestatic    gnu/mapping/Values.getFromPosFinal:(Ljava/lang/Object;I)Ljava/lang/Object;
                    //    48: astore          other$Mnlists
                    //    50: aload           list
                    //    52: invokestatic    kawa/lib/lists.isNull:(Ljava/lang/Object;)Z
                    //    55: ifeq            74
                    //    58: aload_0         /* this */
                    //    59: getfield        kawa/lib/rnrs/lists$frame4.abort:Lkawa/lang/Continuation;
                    //    62: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
                    //    65: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
                    //    68: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                    //    71: goto            207
                    //    74: aload           list
                    //    76: ldc             Lgnu/lists/Pair;.class
                    //    78: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                    //    81: dup            
                    //    82: astore          7
                    //    84: checkcast       Lgnu/lists/Pair;
                    //    87: invokestatic    kawa/lib/rnrs/lists.car$PlCdr:(Lgnu/lists/Pair;)Lgnu/mapping/Values;
                    //    90: astore          6
                    //    92: iconst_0       
                    //    93: istore          7
                    //    95: aload           6
                    //    97: iload           7
                    //    99: invokestatic    gnu/mapping/Values.incrPos:(Ljava/lang/Object;I)I
                    //   102: istore          7
                    //   104: aload           6
                    //   106: iload           7
                    //   108: invokestatic    gnu/mapping/Values.getFromPos:(Ljava/lang/Object;I)Ljava/lang/Object;
                    //   111: astore          8
                    //   113: aload           6
                    //   115: iload           7
                    //   117: invokestatic    gnu/mapping/Values.incrPos:(Ljava/lang/Object;I)I
                    //   120: istore          7
                    //   122: aload           6
                    //   124: iload           7
                    //   126: invokestatic    gnu/mapping/Values.getFromPosFinal:(Ljava/lang/Object;I)Ljava/lang/Object;
                    //   129: astore          d
                    //   131: aload_0         /* this */
                    //   132: aload           other$Mnlists
                    //   134: invokevirtual   kawa/lib/rnrs/lists$frame4.lambda7recur:(Ljava/lang/Object;)Ljava/lang/Object;
                    //   137: astore          10
                    //   139: iconst_0       
                    //   140: istore          11
                    //   142: aload           10
                    //   144: iload           11
                    //   146: invokestatic    gnu/mapping/Values.incrPos:(Ljava/lang/Object;I)I
                    //   149: istore          11
                    //   151: aload           10
                    //   153: iload           11
                    //   155: invokestatic    gnu/mapping/Values.getFromPos:(Ljava/lang/Object;I)Ljava/lang/Object;
                    //   158: astore          12
                    //   160: aload           10
                    //   162: iload           11
                    //   164: invokestatic    gnu/mapping/Values.incrPos:(Ljava/lang/Object;I)I
                    //   167: istore          11
                    //   169: aload           10
                    //   171: iload           11
                    //   173: invokestatic    gnu/mapping/Values.getFromPosFinal:(Ljava/lang/Object;I)Ljava/lang/Object;
                    //   176: astore          cdrs
                    //   178: aload           a
                    //   180: aload           cars
                    //   182: invokestatic    kawa/lib/lists.cons:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
                    //   185: aload           d
                    //   187: aload           cdrs
                    //   189: invokestatic    kawa/lib/lists.cons:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
                    //   192: invokestatic    gnu/mapping/Values.values2:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/mapping/Values$Values2;
                    //   195: goto            207
                    //   198: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
                    //   201: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
                    //   204: invokestatic    gnu/mapping/Values.values2:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/mapping/Values$Values2;
                    //   207: areturn        
                    //   208: new             Lgnu/mapping/WrongType;
                    //   211: dup_x1         
                    //   212: swap           
                    //   213: ldc             "car+cdr"
                    //   215: iconst_0       
                    //   216: aload_3        
                    //   217: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                    //   220: athrow         
                    //   221: new             Lgnu/mapping/WrongType;
                    //   224: dup_x1         
                    //   225: swap           
                    //   226: ldc             "car+cdr"
                    //   228: iconst_0       
                    //   229: aload           7
                    //   231: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                    //   234: athrow         
                    //    Exceptions:
                    //  Try           Handler
                    //  Start  End    Start  End    Type                          
                    //  -----  -----  -----  -----  ------------------------------
                    //  15     18     208    221    Ljava/lang/ClassCastException;
                    //  84     87     221    235    Ljava/lang/ClassCastException;
                    // 
                    // The error that occurred was:
                    // 
                    // java.lang.NullPointerException
                    // 
                    throw new IllegalStateException("An error occurred while decompiling this method.");
                }
            }
            final lists$frame4 $heapFrame = new lists$frame4();
            $heapFrame.abort = abort;
            $heapFrame.lambda7recur(lists);
            cont.invoked = true;
        }
        finally {
            handleException = Continuation.handleException(loadexception(java.lang.Throwable.class), cont);
        }
        return handleException;
    }
    
    public static Object exists$V(final Procedure proc, final LList list1, final Object[] argsArray) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: iconst_0       
        //     2: invokestatic    gnu/lists/LList.makeList:([Ljava/lang/Object;I)Lgnu/lists/LList;
        //     5: dup            
        //     6: astore          4
        //     8: astore_3        /* lists */
        //     9: aload_3         /* lists */
        //    10: invokestatic    kawa/lib/lists.isPair:(Ljava/lang/Object;)Z
        //    13: ifeq            170
        //    16: aload_1         /* list1 */
        //    17: aload_3         /* lists */
        //    18: invokestatic    kawa/lib/lists.cons:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //    21: invokestatic    kawa/lib/rnrs/lists.$PcCars$PlCdrs:(Lgnu/lists/LList;)Ljava/lang/Object;
        //    24: astore          4
        //    26: iconst_0       
        //    27: istore          5
        //    29: aload           4
        //    31: iload           5
        //    33: invokestatic    gnu/mapping/Values.incrPos:(Ljava/lang/Object;I)I
        //    36: istore          5
        //    38: aload           4
        //    40: iload           5
        //    42: invokestatic    gnu/mapping/Values.getFromPos:(Ljava/lang/Object;I)Ljava/lang/Object;
        //    45: astore          6
        //    47: aload           4
        //    49: iload           5
        //    51: invokestatic    gnu/mapping/Values.incrPos:(Ljava/lang/Object;I)I
        //    54: istore          5
        //    56: aload           4
        //    58: iload           5
        //    60: invokestatic    gnu/mapping/Values.getFromPosFinal:(Ljava/lang/Object;I)Ljava/lang/Object;
        //    63: astore          tails
        //    65: aload           heads
        //    67: invokestatic    kawa/lib/lists.isPair:(Ljava/lang/Object;)Z
        //    70: ifeq            164
        //    73: aload           heads
        //    75: aload           tails
        //    77: astore          9
        //    79: astore          heads
        //    81: aload           tails
        //    83: ldc             Lgnu/lists/LList;.class
        //    85: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    88: dup            
        //    89: astore          11
        //    91: checkcast       Lgnu/lists/LList;
        //    94: invokestatic    kawa/lib/rnrs/lists.$PcCars$PlCdrs$SlPair:(Lgnu/lists/LList;)Lgnu/lists/Pair;
        //    97: astore          split
        //    99: aload           split
        //   101: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   104: astore          next$Mnheads
        //   106: aload           split
        //   108: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   111: astore          next$Mntails
        //   113: aload           next$Mnheads
        //   115: invokestatic    kawa/lib/lists.isPair:(Ljava/lang/Object;)Z
        //   118: ifeq            152
        //   121: getstatic       kawa/standard/Scheme.apply:Lgnu/kawa/functions/Apply;
        //   124: aload_0         /* proc */
        //   125: aload           heads
        //   127: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   130: astore          x
        //   132: aload           x
        //   134: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //   137: ifeq            145
        //   140: aload           x
        //   142: goto            277
        //   145: aload           next$Mnheads
        //   147: aload           next$Mntails
        //   149: goto            77
        //   152: getstatic       kawa/standard/Scheme.apply:Lgnu/kawa/functions/Apply;
        //   155: aload_0         /* proc */
        //   156: aload           heads
        //   158: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   161: goto            277
        //   164: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //   167: goto            277
        //   170: aload_1         /* list1 */
        //   171: invokestatic    kawa/lib/lists.isNull:(Ljava/lang/Object;)Z
        //   174: ifne            274
        //   177: aload_1         /* list1 */
        //   178: dup            
        //   179: astore          4
        //   181: checkcast       Lgnu/lists/Pair;
        //   184: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   187: aload_1         /* list1 */
        //   188: dup            
        //   189: astore          4
        //   191: checkcast       Lgnu/lists/Pair;
        //   194: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   197: astore          5
        //   199: astore          head
        //   201: aload           tail
        //   203: invokestatic    kawa/lib/lists.isNull:(Ljava/lang/Object;)Z
        //   206: ifeq            218
        //   209: aload_0         /* proc */
        //   210: aload           head
        //   212: invokevirtual   gnu/mapping/Procedure.apply1:(Ljava/lang/Object;)Ljava/lang/Object;
        //   215: goto            277
        //   218: aload_0         /* proc */
        //   219: aload           head
        //   221: invokevirtual   gnu/mapping/Procedure.apply1:(Ljava/lang/Object;)Ljava/lang/Object;
        //   224: astore          x
        //   226: aload           x
        //   228: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //   231: ifeq            239
        //   234: aload           x
        //   236: goto            277
        //   239: aload           tail
        //   241: ldc             Lgnu/lists/Pair;.class
        //   243: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   246: dup            
        //   247: astore          7
        //   249: checkcast       Lgnu/lists/Pair;
        //   252: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   255: aload           tail
        //   257: ldc             Lgnu/lists/Pair;.class
        //   259: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   262: dup            
        //   263: astore          7
        //   265: checkcast       Lgnu/lists/Pair;
        //   268: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   271: goto            197
        //   274: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //   277: areturn        
        //   278: new             Lgnu/mapping/WrongType;
        //   281: dup_x1         
        //   282: swap           
        //   283: ldc             "%cars+cdrs/pair"
        //   285: iconst_0       
        //   286: aload           11
        //   288: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   291: athrow         
        //   292: new             Lgnu/mapping/WrongType;
        //   295: dup_x1         
        //   296: swap           
        //   297: ldc             "car"
        //   299: iconst_1       
        //   300: aload           4
        //   302: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   305: athrow         
        //   306: new             Lgnu/mapping/WrongType;
        //   309: dup_x1         
        //   310: swap           
        //   311: ldc             "cdr"
        //   313: iconst_1       
        //   314: aload           4
        //   316: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   319: athrow         
        //   320: new             Lgnu/mapping/WrongType;
        //   323: dup_x1         
        //   324: swap           
        //   325: ldc             "car"
        //   327: iconst_1       
        //   328: aload           7
        //   330: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   333: athrow         
        //   334: new             Lgnu/mapping/WrongType;
        //   337: dup_x1         
        //   338: swap           
        //   339: ldc             "cdr"
        //   341: iconst_1       
        //   342: aload           7
        //   344: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   347: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  91     94     278    292    Ljava/lang/ClassCastException;
        //  181    184    292    306    Ljava/lang/ClassCastException;
        //  191    194    306    320    Ljava/lang/ClassCastException;
        //  249    252    320    334    Ljava/lang/ClassCastException;
        //  265    268    334    348    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    static Pair $PcCars$PlCdrs$SlPair(final LList lists) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokestatic    kawa/lib/rnrs/lists.$PcCars$PlCdrs:(Lgnu/lists/LList;)Ljava/lang/Object;
        //     4: astore_1       
        //     5: iconst_0       
        //     6: istore_2       
        //     7: aload_1        
        //     8: iload_2        
        //     9: invokestatic    gnu/mapping/Values.incrPos:(Ljava/lang/Object;I)I
        //    12: istore_2       
        //    13: aload_1        
        //    14: iload_2        
        //    15: invokestatic    gnu/mapping/Values.getFromPos:(Ljava/lang/Object;I)Ljava/lang/Object;
        //    18: astore_3       
        //    19: aload_1        
        //    20: iload_2        
        //    21: invokestatic    gnu/mapping/Values.incrPos:(Ljava/lang/Object;I)I
        //    24: istore_2       
        //    25: aload_1        
        //    26: iload_2        
        //    27: invokestatic    gnu/mapping/Values.getFromPosFinal:(Ljava/lang/Object;I)Ljava/lang/Object;
        //    30: astore          cdrs
        //    32: aload_3        
        //    33: aload           cdrs
        //    35: invokestatic    kawa/lib/lists.cons:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //    38: areturn        
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public static Object filter(final Procedure proc, final LList lst) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
        //     4: astore_3       
        //     5: astore_2        /* list */
        //     6: aload_2         /* list */
        //     7: invokestatic    kawa/lib/lists.isNull:(Ljava/lang/Object;)Z
        //    10: ifeq            31
        //    13: aload_3         /* res */
        //    14: ldc             Lgnu/lists/LList;.class
        //    16: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    19: dup            
        //    20: astore          4
        //    22: checkcast       Lgnu/lists/LList;
        //    25: invokestatic    kawa/lib/lists.reverse$Ex:(Lgnu/lists/LList;)Lgnu/lists/LList;
        //    28: goto            94
        //    31: aload_2         /* list */
        //    32: ldc             Lgnu/lists/Pair;.class
        //    34: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    37: dup            
        //    38: astore          5
        //    40: checkcast       Lgnu/lists/Pair;
        //    43: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    46: astore          4
        //    48: aload_2         /* list */
        //    49: ldc             Lgnu/lists/Pair;.class
        //    51: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    54: dup            
        //    55: astore          6
        //    57: checkcast       Lgnu/lists/Pair;
        //    60: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    63: astore          tail
        //    65: aload_0         /* proc */
        //    66: aload           head
        //    68: invokevirtual   gnu/mapping/Procedure.apply1:(Ljava/lang/Object;)Ljava/lang/Object;
        //    71: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //    74: ifeq            88
        //    77: aload           tail
        //    79: aload           head
        //    81: aload_3         /* res */
        //    82: invokestatic    kawa/lib/lists.cons:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //    85: goto            4
        //    88: aload           tail
        //    90: astore_2        /* list */
        //    91: goto            6
        //    94: areturn        
        //    95: new             Lgnu/mapping/WrongType;
        //    98: dup_x1         
        //    99: swap           
        //   100: ldc             "reverse!"
        //   102: iconst_1       
        //   103: aload           4
        //   105: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   108: athrow         
        //   109: new             Lgnu/mapping/WrongType;
        //   112: dup_x1         
        //   113: swap           
        //   114: ldc             "car"
        //   116: iconst_1       
        //   117: aload           5
        //   119: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   122: athrow         
        //   123: new             Lgnu/mapping/WrongType;
        //   126: dup_x1         
        //   127: swap           
        //   128: ldc             "cdr"
        //   130: iconst_1       
        //   131: aload           6
        //   133: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   136: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  22     25     95     109    Ljava/lang/ClassCastException;
        //  40     43     109    123    Ljava/lang/ClassCastException;
        //  57     60     123    137    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public static Object partition(final Procedure proc, final LList lst) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
        //     4: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
        //     7: astore          4
        //     9: astore_3       
        //    10: astore_2        /* list */
        //    11: aload_2         /* list */
        //    12: invokestatic    kawa/lib/lists.isNull:(Ljava/lang/Object;)Z
        //    15: ifeq            55
        //    18: aload_3         /* in */
        //    19: ldc             Lgnu/lists/LList;.class
        //    21: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    24: dup            
        //    25: astore          5
        //    27: checkcast       Lgnu/lists/LList;
        //    30: invokestatic    kawa/lib/lists.reverse$Ex:(Lgnu/lists/LList;)Lgnu/lists/LList;
        //    33: aload           out
        //    35: ldc             Lgnu/lists/LList;.class
        //    37: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    40: dup            
        //    41: astore          5
        //    43: checkcast       Lgnu/lists/LList;
        //    46: invokestatic    kawa/lib/lists.reverse$Ex:(Lgnu/lists/LList;)Lgnu/lists/LList;
        //    49: invokestatic    gnu/mapping/Values.values2:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/mapping/Values$Values2;
        //    52: goto            129
        //    55: aload_2         /* list */
        //    56: ldc             Lgnu/lists/Pair;.class
        //    58: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    61: dup            
        //    62: astore          6
        //    64: checkcast       Lgnu/lists/Pair;
        //    67: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    70: astore          5
        //    72: aload_2         /* list */
        //    73: ldc             Lgnu/lists/Pair;.class
        //    75: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    78: dup            
        //    79: astore          7
        //    81: checkcast       Lgnu/lists/Pair;
        //    84: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    87: astore          tail
        //    89: aload_0         /* proc */
        //    90: aload           head
        //    92: invokevirtual   gnu/mapping/Procedure.apply1:(Ljava/lang/Object;)Ljava/lang/Object;
        //    95: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //    98: ifeq            114
        //   101: aload           tail
        //   103: aload           head
        //   105: aload_3         /* in */
        //   106: invokestatic    kawa/lib/lists.cons:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //   109: astore_3        /* in */
        //   110: astore_2        /* list */
        //   111: goto            11
        //   114: aload           tail
        //   116: aload           head
        //   118: aload           out
        //   120: invokestatic    kawa/lib/lists.cons:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //   123: astore          out
        //   125: astore_2        /* list */
        //   126: goto            11
        //   129: areturn        
        //   130: new             Lgnu/mapping/WrongType;
        //   133: dup_x1         
        //   134: swap           
        //   135: ldc             "reverse!"
        //   137: iconst_1       
        //   138: aload           5
        //   140: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   143: athrow         
        //   144: new             Lgnu/mapping/WrongType;
        //   147: dup_x1         
        //   148: swap           
        //   149: ldc             "reverse!"
        //   151: iconst_1       
        //   152: aload           5
        //   154: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   157: athrow         
        //   158: new             Lgnu/mapping/WrongType;
        //   161: dup_x1         
        //   162: swap           
        //   163: ldc             "car"
        //   165: iconst_1       
        //   166: aload           6
        //   168: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   171: athrow         
        //   172: new             Lgnu/mapping/WrongType;
        //   175: dup_x1         
        //   176: swap           
        //   177: ldc             "cdr"
        //   179: iconst_1       
        //   180: aload           7
        //   182: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   185: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  27     30     130    144    Ljava/lang/ClassCastException;
        //  43     46     144    158    Ljava/lang/ClassCastException;
        //  64     67     158    172    Ljava/lang/ClassCastException;
        //  81     84     172    186    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public static Object foldLeft$V(final Procedure combine, final Object nil, final LList list1, final Object[] argsArray) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: iconst_0       
        //     2: invokestatic    gnu/lists/LList.makeList:([Ljava/lang/Object;I)Lgnu/lists/LList;
        //     5: dup            
        //     6: astore          5
        //     8: astore          lists
        //    10: aload           lists
        //    12: invokestatic    kawa/lib/lists.isPair:(Ljava/lang/Object;)Z
        //    15: ifeq            115
        //    18: aload_2         /* list1 */
        //    19: aload           lists
        //    21: invokestatic    kawa/lib/lists.cons:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //    24: aload_1         /* nil */
        //    25: astore          6
        //    27: astore          lists
        //    29: aload           lists
        //    31: ldc             Lgnu/lists/LList;.class
        //    33: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    36: dup            
        //    37: astore          8
        //    39: checkcast       Lgnu/lists/LList;
        //    42: invokestatic    kawa/lib/rnrs/lists.$PcCars$PlCdrs:(Lgnu/lists/LList;)Ljava/lang/Object;
        //    45: astore          7
        //    47: iconst_0       
        //    48: istore          8
        //    50: aload           7
        //    52: iload           8
        //    54: invokestatic    gnu/mapping/Values.incrPos:(Ljava/lang/Object;I)I
        //    57: istore          8
        //    59: aload           7
        //    61: iload           8
        //    63: invokestatic    gnu/mapping/Values.getFromPos:(Ljava/lang/Object;I)Ljava/lang/Object;
        //    66: astore          9
        //    68: aload           7
        //    70: iload           8
        //    72: invokestatic    gnu/mapping/Values.incrPos:(Ljava/lang/Object;I)I
        //    75: istore          8
        //    77: aload           7
        //    79: iload           8
        //    81: invokestatic    gnu/mapping/Values.getFromPosFinal:(Ljava/lang/Object;I)Ljava/lang/Object;
        //    84: astore          cdrs
        //    86: aload           cars
        //    88: invokestatic    kawa/lib/lists.isNull:(Ljava/lang/Object;)Z
        //    91: ifeq            99
        //    94: aload           ans
        //    96: goto            175
        //    99: aload           cdrs
        //   101: getstatic       kawa/standard/Scheme.apply:Lgnu/kawa/functions/Apply;
        //   104: aload_0         /* combine */
        //   105: aload           ans
        //   107: aload           cars
        //   109: invokevirtual   gnu/mapping/Procedure.apply3:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   112: goto            25
        //   115: aload_2         /* list1 */
        //   116: aload_1         /* nil */
        //   117: astore          6
        //   119: astore          list
        //   121: aload           list
        //   123: invokestatic    kawa/lib/lists.isNull:(Ljava/lang/Object;)Z
        //   126: ifeq            134
        //   129: aload           ans
        //   131: goto            175
        //   134: aload           list
        //   136: ldc             Lgnu/lists/Pair;.class
        //   138: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   141: dup            
        //   142: astore          7
        //   144: checkcast       Lgnu/lists/Pair;
        //   147: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   150: aload_0         /* combine */
        //   151: aload           ans
        //   153: aload           list
        //   155: ldc             Lgnu/lists/Pair;.class
        //   157: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   160: dup            
        //   161: astore          7
        //   163: checkcast       Lgnu/lists/Pair;
        //   166: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   169: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   172: goto            117
        //   175: areturn        
        //   176: new             Lgnu/mapping/WrongType;
        //   179: dup_x1         
        //   180: swap           
        //   181: ldc             "%cars+cdrs"
        //   183: iconst_0       
        //   184: aload           8
        //   186: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   189: athrow         
        //   190: new             Lgnu/mapping/WrongType;
        //   193: dup_x1         
        //   194: swap           
        //   195: ldc             "cdr"
        //   197: iconst_1       
        //   198: aload           7
        //   200: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   203: athrow         
        //   204: new             Lgnu/mapping/WrongType;
        //   207: dup_x1         
        //   208: swap           
        //   209: ldc             "car"
        //   211: iconst_1       
        //   212: aload           7
        //   214: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   217: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  39     42     176    190    Ljava/lang/ClassCastException;
        //  144    147    190    204    Ljava/lang/ClassCastException;
        //  163    166    204    218    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public static Object foldRight$V(final Procedure combine, final Object nil, final LList list1, final Object[] argsArray) {
        public class lists$frame extends ModuleBody
        {
            Procedure combine;
            Object nil;
            
            public Object lambda1recur(final Object lists) {
                final Object cdrs = lists.$PcCdrs(lists);
                if (lists.isNull(cdrs)) {
                    return this.nil;
                }
                final Apply apply = Scheme.apply;
                final Procedure combine = this.combine;
                final Object force = Promise.force(lists, LList.class);
                try {
                    return apply.apply2(combine, lists.$PcCars$Pl((LList)force, this.lambda1recur(cdrs)));
                }
                catch (ClassCastException ex) {
                    throw new WrongType(ex, "%cars+", 0, force);
                }
            }
            
            public Object lambda2recur(final Object list) {
                // 
                // This method could not be decompiled.
                // 
                // Original Bytecode:
                // 
                //     1: invokestatic    kawa/lib/lists.isNull:(Ljava/lang/Object;)Z
                //     4: ifeq            14
                //     7: aload_0         /* this */
                //     8: getfield        kawa/lib/rnrs/lists$frame.nil:Ljava/lang/Object;
                //    11: goto            55
                //    14: aload_1         /* list */
                //    15: ldc             Lgnu/lists/Pair;.class
                //    17: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //    20: dup            
                //    21: astore_3       
                //    22: checkcast       Lgnu/lists/Pair;
                //    25: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
                //    28: astore_2        /* head */
                //    29: aload_0         /* this */
                //    30: getfield        kawa/lib/rnrs/lists$frame.combine:Lgnu/mapping/Procedure;
                //    33: aload_2         /* head */
                //    34: aload_0         /* this */
                //    35: aload_1         /* list */
                //    36: ldc             Lgnu/lists/Pair;.class
                //    38: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //    41: dup            
                //    42: astore_3       
                //    43: checkcast       Lgnu/lists/Pair;
                //    46: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
                //    49: invokevirtual   kawa/lib/rnrs/lists$frame.lambda2recur:(Ljava/lang/Object;)Ljava/lang/Object;
                //    52: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                //    55: areturn        
                //    56: new             Lgnu/mapping/WrongType;
                //    59: dup_x1         
                //    60: swap           
                //    61: ldc             "car"
                //    63: iconst_1       
                //    64: aload_3        
                //    65: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //    68: athrow         
                //    69: new             Lgnu/mapping/WrongType;
                //    72: dup_x1         
                //    73: swap           
                //    74: ldc             "cdr"
                //    76: iconst_1       
                //    77: aload_3        
                //    78: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //    81: athrow         
                //    Exceptions:
                //  Try           Handler
                //  Start  End    Start  End    Type                          
                //  -----  -----  -----  -----  ------------------------------
                //  22     25     56     69     Ljava/lang/ClassCastException;
                //  43     46     69     82     Ljava/lang/ClassCastException;
                // 
                // The error that occurred was:
                // 
                // java.lang.IllegalStateException: Expression is linked from several locations: Label_0055:
                //     at com.strobel.decompiler.ast.Error.expressionLinkedFromMultipleLocations(Error.java:27)
                //     at com.strobel.decompiler.ast.AstOptimizer.mergeDisparateObjectInitializations(AstOptimizer.java:2596)
                //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:235)
                //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:42)
                //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:214)
                //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
                //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
                //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:675)
                //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:552)
                //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
                //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
                //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:150)
                //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:670)
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
        final lists$frame $heapFrame = new lists$frame();
        $heapFrame.combine = combine;
        $heapFrame.nil = nil;
        final LList lists = LList.makeList(argsArray, 0);
        return kawa.lib.lists.isPair(lists) ? $heapFrame.lambda1recur(kawa.lib.lists.cons(list1, lists)) : $heapFrame.lambda2recur(list1);
    }
    
    static Object $PcCdrs(final Object lists) {
        final CallContext $ctx;
        final Continuation cont = new Continuation($ctx = CallContext.getInstance());
        Object handleException = null;
        try {
            final Continuation abort = cont;
            public class lists$frame5 extends ModuleBody
            {
                Continuation abort;
                
                public Object lambda8recur(final Object lists) {
                    // 
                    // This method could not be decompiled.
                    // 
                    // Original Bytecode:
                    // 
                    //     1: invokestatic    kawa/lib/lists.isPair:(Ljava/lang/Object;)Z
                    //     4: ifeq            80
                    //     7: aload_1         /* lists */
                    //     8: ldc             Lgnu/lists/Pair;.class
                    //    10: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                    //    13: dup            
                    //    14: astore_3       
                    //    15: checkcast       Lgnu/lists/Pair;
                    //    18: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
                    //    21: astore_2        /* lis */
                    //    22: aload_2         /* lis */
                    //    23: invokestatic    kawa/lib/lists.isNull:(Ljava/lang/Object;)Z
                    //    26: ifeq            42
                    //    29: aload_0         /* this */
                    //    30: getfield        kawa/lib/rnrs/lists$frame5.abort:Lkawa/lang/Continuation;
                    //    33: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
                    //    36: invokevirtual   gnu/mapping/Procedure.apply1:(Ljava/lang/Object;)Ljava/lang/Object;
                    //    39: goto            83
                    //    42: aload_2         /* lis */
                    //    43: ldc             Lgnu/lists/Pair;.class
                    //    45: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                    //    48: dup            
                    //    49: astore_3       
                    //    50: checkcast       Lgnu/lists/Pair;
                    //    53: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
                    //    56: aload_0         /* this */
                    //    57: aload_1         /* lists */
                    //    58: ldc             Lgnu/lists/Pair;.class
                    //    60: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                    //    63: dup            
                    //    64: astore_3       
                    //    65: checkcast       Lgnu/lists/Pair;
                    //    68: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
                    //    71: invokevirtual   kawa/lib/rnrs/lists$frame5.lambda8recur:(Ljava/lang/Object;)Ljava/lang/Object;
                    //    74: invokestatic    kawa/lib/lists.cons:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
                    //    77: goto            83
                    //    80: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
                    //    83: areturn        
                    //    84: new             Lgnu/mapping/WrongType;
                    //    87: dup_x1         
                    //    88: swap           
                    //    89: ldc             "car"
                    //    91: iconst_1       
                    //    92: aload_3        
                    //    93: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                    //    96: athrow         
                    //    97: new             Lgnu/mapping/WrongType;
                    //   100: dup_x1         
                    //   101: swap           
                    //   102: ldc             "cdr"
                    //   104: iconst_1       
                    //   105: aload_3        
                    //   106: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                    //   109: athrow         
                    //   110: new             Lgnu/mapping/WrongType;
                    //   113: dup_x1         
                    //   114: swap           
                    //   115: ldc             "cdr"
                    //   117: iconst_1       
                    //   118: aload_3        
                    //   119: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                    //   122: athrow         
                    //    Exceptions:
                    //  Try           Handler
                    //  Start  End    Start  End    Type                          
                    //  -----  -----  -----  -----  ------------------------------
                    //  15     18     84     97     Ljava/lang/ClassCastException;
                    //  50     53     97     110    Ljava/lang/ClassCastException;
                    //  65     68     110    123    Ljava/lang/ClassCastException;
                    // 
                    // The error that occurred was:
                    // 
                    // java.lang.IndexOutOfBoundsException: Index 63 out of bounds for length 63
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
                    //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:670)
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
            final lists$frame5 $heapFrame = new lists$frame5();
            $heapFrame.abort = abort;
            $heapFrame.lambda8recur(lists);
            cont.invoked = true;
        }
        finally {
            handleException = Continuation.handleException(loadexception(java.lang.Throwable.class), cont);
        }
        return handleException;
    }
    
    static LList $PcCars$Pl(final LList lists, final Object lastElt) {
        public class lists$frame6 extends ModuleBody
        {
            Object last$Mnelt;
            
            public Object lambda9recur(final Object lists) {
                Label_0035: {
                    if (!lists.isPair(lists)) {
                        break Label_0035;
                    }
                    final Object caar = lists.caar(lists);
                    final Object force = Promise.force(lists, Pair.class);
                    try {
                        return lists.cons(caar, this.lambda9recur(lists.cdr((Pair)force)));
                        pair = LList.list1(this.last$Mnelt);
                        return pair;
                    }
                    catch (ClassCastException ex) {
                        throw new WrongType(ex, "cdr", 1, force);
                    }
                }
            }
        }
        final lists$frame6 $heapFrame = new lists$frame6();
        $heapFrame.last$Mnelt = lastElt;
        return (LList)Promise.force($heapFrame.lambda9recur(lists), LList.class);
    }
    
    public static LList remp(final Procedure proc, final LList lst) {
        return (LList)Promise.force(filter(complement(proc), lst), LList.class);
    }
    
    static Procedure complement(final Procedure proc) {
        public class lists$frame3 extends ModuleBody
        {
            Procedure proc;
            final ModuleMethod lambda$Fn4;
            
            public lists$frame3() {
                final ModuleMethod lambda$Fn4 = new ModuleMethod(this, 4, null, 4097);
                lambda$Fn4.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/rnrs/lists.scm:16");
                this.lambda$Fn4 = lambda$Fn4;
            }
            
            boolean lambda6(final Object x) {
                return !KawaConvert.isTrue(this.proc.apply1(x));
            }
            
            @Override
            public int match1(final ModuleMethod moduleMethod, final Object o, final CallContext ctx) {
                if (moduleMethod.selector == 4) {
                    ctx.value1 = o;
                    ctx.proc = moduleMethod;
                    ctx.pc = 1;
                    return 0;
                }
                return super.match1(moduleMethod, o, ctx);
            }
            
            @Override
            public void apply(final CallContext callContext) {
                final int pc = callContext.pc;
                ModuleMethod.applyError();
            }
            
            @Override
            public Object apply1(final ModuleMethod method, final Object o) {
                if (method.selector == 4) {
                    return this.lambda6(o) ? Boolean.TRUE : Boolean.FALSE;
                }
                return super.apply1(method, o);
            }
        }
        final lists$frame3 $heapFrame = new lists$frame3();
        $heapFrame.proc = proc;
        return $heapFrame.lambda$Fn4;
    }
    
    public static LList remove(final Object obj, final LList lst) {
        public class lists$frame0 extends ModuleBody
        {
            Object obj;
            final ModuleMethod lambda$Fn1;
            
            public lists$frame0() {
                final ModuleMethod lambda$Fn1 = new ModuleMethod(this, 1, null, 4097);
                lambda$Fn1.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/rnrs/lists.scm:259");
                this.lambda$Fn1 = lambda$Fn1;
            }
            
            boolean lambda3(final Object o) {
                return !KawaConvert.isTrue(Scheme.isEqual.apply2(o, this.obj));
            }
            
            @Override
            public int match1(final ModuleMethod moduleMethod, final Object o, final CallContext ctx) {
                if (moduleMethod.selector == 1) {
                    ctx.value1 = o;
                    ctx.proc = moduleMethod;
                    ctx.pc = 1;
                    return 0;
                }
                return super.match1(moduleMethod, o, ctx);
            }
            
            @Override
            public void apply(final CallContext callContext) {
                final int pc = callContext.pc;
                ModuleMethod.applyError();
            }
            
            @Override
            public Object apply1(final ModuleMethod method, final Object o) {
                if (method.selector == 1) {
                    return this.lambda3(o) ? Boolean.TRUE : Boolean.FALSE;
                }
                return super.apply1(method, o);
            }
        }
        final lists$frame0 $heapFrame = new lists$frame0();
        $heapFrame.obj = obj;
        return (LList)Promise.force(filter($heapFrame.lambda$Fn1, lst), LList.class);
    }
    
    public static LList remv(final Object obj, final LList lst) {
        public class lists$frame1 extends ModuleBody
        {
            Object obj;
            final ModuleMethod lambda$Fn2;
            
            public lists$frame1() {
                final ModuleMethod lambda$Fn2 = new ModuleMethod(this, 2, null, 4097);
                lambda$Fn2.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/rnrs/lists.scm:266");
                this.lambda$Fn2 = lambda$Fn2;
            }
            
            boolean lambda4(final Object o) {
                return !IsEqv.apply(o, this.obj);
            }
            
            @Override
            public int match1(final ModuleMethod moduleMethod, final Object o, final CallContext ctx) {
                if (moduleMethod.selector == 2) {
                    ctx.value1 = o;
                    ctx.proc = moduleMethod;
                    ctx.pc = 1;
                    return 0;
                }
                return super.match1(moduleMethod, o, ctx);
            }
            
            @Override
            public void apply(final CallContext callContext) {
                final int pc = callContext.pc;
                ModuleMethod.applyError();
            }
            
            @Override
            public Object apply1(final ModuleMethod method, final Object o) {
                if (method.selector == 2) {
                    return this.lambda4(o) ? Boolean.TRUE : Boolean.FALSE;
                }
                return super.apply1(method, o);
            }
        }
        final lists$frame1 $heapFrame = new lists$frame1();
        $heapFrame.obj = obj;
        return (LList)Promise.force(filter($heapFrame.lambda$Fn2, lst), LList.class);
    }
    
    public static LList remq(final Object obj, final LList lst) {
        public class lists$frame2 extends ModuleBody
        {
            Object obj;
            final ModuleMethod lambda$Fn3;
            
            public lists$frame2() {
                final ModuleMethod lambda$Fn3 = new ModuleMethod(this, 3, null, 4097);
                lambda$Fn3.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/rnrs/lists.scm:273");
                this.lambda$Fn3 = lambda$Fn3;
            }
            
            boolean lambda5(final Object o) {
                return o != this.obj;
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
            public void apply(final CallContext callContext) {
                final int pc = callContext.pc;
                ModuleMethod.applyError();
            }
            
            @Override
            public Object apply1(final ModuleMethod method, final Object o) {
                if (method.selector == 3) {
                    return this.lambda5(o) ? Boolean.TRUE : Boolean.FALSE;
                }
                return super.apply1(method, o);
            }
        }
        final lists$frame2 $heapFrame = new lists$frame2();
        $heapFrame.obj = obj;
        return (LList)Promise.force(filter($heapFrame.lambda$Fn3, lst), LList.class);
    }
    
    public static Object memp(final Procedure proc, final LList lst) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: astore_2        /* list */
        //     2: aload_2         /* list */
        //     3: invokestatic    kawa/lib/lists.isNull:(Ljava/lang/Object;)Z
        //     6: ifeq            15
        //     9: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //    12: goto            60
        //    15: aload_0         /* proc */
        //    16: aload_2         /* list */
        //    17: ldc             Lgnu/lists/Pair;.class
        //    19: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    22: dup            
        //    23: astore_3       
        //    24: checkcast       Lgnu/lists/Pair;
        //    27: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    30: invokevirtual   gnu/mapping/Procedure.apply1:(Ljava/lang/Object;)Ljava/lang/Object;
        //    33: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //    36: ifeq            43
        //    39: aload_2         /* list */
        //    40: goto            60
        //    43: aload_2         /* list */
        //    44: ldc             Lgnu/lists/Pair;.class
        //    46: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    49: dup            
        //    50: astore_3       
        //    51: checkcast       Lgnu/lists/Pair;
        //    54: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    57: goto            1
        //    60: areturn        
        //    61: new             Lgnu/mapping/WrongType;
        //    64: dup_x1         
        //    65: swap           
        //    66: ldc             "car"
        //    68: iconst_1       
        //    69: aload_3        
        //    70: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //    73: athrow         
        //    74: new             Lgnu/mapping/WrongType;
        //    77: dup_x1         
        //    78: swap           
        //    79: ldc             "cdr"
        //    81: iconst_1       
        //    82: aload_3        
        //    83: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //    86: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  24     27     61     74     Ljava/lang/ClassCastException;
        //  51     54     74     87     Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0060:
        //     at com.strobel.decompiler.ast.Error.expressionLinkedFromMultipleLocations(Error.java:27)
        //     at com.strobel.decompiler.ast.AstOptimizer.mergeDisparateObjectInitializations(AstOptimizer.java:2596)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:235)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:42)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:214)
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
    
    public static Object assp(final Procedure proc, final LList alist) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: astore_2        /* alist */
        //     2: aload_2         /* alist */
        //     3: invokestatic    kawa/lib/lists.isNull:(Ljava/lang/Object;)Z
        //     6: ifeq            15
        //     9: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //    12: goto            63
        //    15: aload_0         /* proc */
        //    16: aload_2         /* alist */
        //    17: invokestatic    kawa/lib/lists.caar:(Ljava/lang/Object;)Ljava/lang/Object;
        //    20: invokevirtual   gnu/mapping/Procedure.apply1:(Ljava/lang/Object;)Ljava/lang/Object;
        //    23: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //    26: ifeq            46
        //    29: aload_2         /* alist */
        //    30: ldc             Lgnu/lists/Pair;.class
        //    32: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    35: dup            
        //    36: astore_3       
        //    37: checkcast       Lgnu/lists/Pair;
        //    40: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    43: goto            63
        //    46: aload_2         /* alist */
        //    47: ldc             Lgnu/lists/Pair;.class
        //    49: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    52: dup            
        //    53: astore_3       
        //    54: checkcast       Lgnu/lists/Pair;
        //    57: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    60: goto            1
        //    63: areturn        
        //    64: new             Lgnu/mapping/WrongType;
        //    67: dup_x1         
        //    68: swap           
        //    69: ldc             "car"
        //    71: iconst_1       
        //    72: aload_3        
        //    73: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //    76: athrow         
        //    77: new             Lgnu/mapping/WrongType;
        //    80: dup_x1         
        //    81: swap           
        //    82: ldc             "cdr"
        //    84: iconst_1       
        //    85: aload_3        
        //    86: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //    89: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  37     40     64     77     Ljava/lang/ClassCastException;
        //  54     57     77     90     Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0063:
        //     at com.strobel.decompiler.ast.Error.expressionLinkedFromMultipleLocations(Error.java:27)
        //     at com.strobel.decompiler.ast.AstOptimizer.mergeDisparateObjectInitializations(AstOptimizer.java:2596)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:235)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:42)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:214)
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
    
    public static Object cons$St(final Object... args) {
        return LList.consX(args);
    }
    
    static Values car$PlCdr(final Pair pair) {
        return Values.values2(kawa.lib.lists.car(pair), kawa.lib.lists.cdr(pair));
    }
    
    static {
        Lit13 = Symbol.valueOf("cons*");
        Lit12 = Symbol.valueOf("assp");
        Lit11 = Symbol.valueOf("memp");
        Lit10 = Symbol.valueOf("remq");
        Lit9 = Symbol.valueOf("remv");
        Lit8 = Symbol.valueOf("remove");
        Lit7 = Symbol.valueOf("remp");
        Lit6 = Symbol.valueOf("fold-right");
        Lit5 = Symbol.valueOf("fold-left");
        Lit4 = Symbol.valueOf("partition");
        Lit3 = Symbol.valueOf("filter");
        Lit2 = Symbol.valueOf("exists");
        Lit1 = Symbol.valueOf("for-all");
        Lit0 = Symbol.valueOf("find");
        lists.$instance = new lists();
        memq = StaticFieldLocation.make("kawa.lib.lists", "memq");
        memv = StaticFieldLocation.make("kawa.lib.lists", "memv");
        member = StaticFieldLocation.make("kawa.lib.lists", "member");
        assq = StaticFieldLocation.make("kawa.lib.lists", "assq");
        assv = StaticFieldLocation.make("kawa.lib.lists", "assv");
        assoc = StaticFieldLocation.make("kawa.lib.lists", "assoc");
        final lists $instance = lists.$instance;
        find = new ModuleMethod($instance, 5, lists.Lit0, 8194);
        for$Mnall = new ModuleMethod($instance, 6, lists.Lit1, -4094);
        exists = new ModuleMethod($instance, 7, lists.Lit2, -4094);
        filter = new ModuleMethod($instance, 8, lists.Lit3, 8194);
        partition = new ModuleMethod($instance, 9, lists.Lit4, 8194);
        fold$Mnleft = new ModuleMethod($instance, 10, lists.Lit5, -4093);
        fold$Mnright = new ModuleMethod($instance, 11, lists.Lit6, -4093);
        remp = new ModuleMethod($instance, 12, lists.Lit7, 8194);
        remove = new ModuleMethod($instance, 13, lists.Lit8, 8194);
        remv = new ModuleMethod($instance, 14, lists.Lit9, 8194);
        remq = new ModuleMethod($instance, 15, lists.Lit10, 8194);
        memp = new ModuleMethod($instance, 16, lists.Lit11, 8194);
        assp = new ModuleMethod($instance, 17, lists.Lit12, 8194);
        cons$St = new ModuleMethod($instance, 18, lists.Lit13, -4096);
        $runBody$();
    }
    
    public lists() {
        ModuleInfo.register(this);
    }
    
    @Override
    public int match2(final ModuleMethod moduleMethod, final Object o, final Object o2, final CallContext ctx) {
        switch (moduleMethod.selector) {
            case 17: {
                final Object force = Promise.force(o, Procedure.class);
                if (LangObjType.coerceToProcedureOrNull(force) == null) {
                    return -786431;
                }
                ctx.value1 = force;
                final Object force2 = Promise.force(o2, LList.class);
                if (force2 instanceof LList) {
                    ctx.value2 = force2;
                    ctx.proc = moduleMethod;
                    ctx.pc = 2;
                    return 0;
                }
                return -786430;
            }
            case 16: {
                final Object force3 = Promise.force(o, Procedure.class);
                if (LangObjType.coerceToProcedureOrNull(force3) == null) {
                    return -786431;
                }
                ctx.value1 = force3;
                final Object force4 = Promise.force(o2, LList.class);
                if (force4 instanceof LList) {
                    ctx.value2 = force4;
                    ctx.proc = moduleMethod;
                    ctx.pc = 2;
                    return 0;
                }
                return -786430;
            }
            case 15: {
                ctx.value1 = o;
                final Object force5 = Promise.force(o2, LList.class);
                if (force5 instanceof LList) {
                    ctx.value2 = force5;
                    ctx.proc = moduleMethod;
                    ctx.pc = 2;
                    return 0;
                }
                return -786430;
            }
            case 14: {
                ctx.value1 = o;
                final Object force6 = Promise.force(o2, LList.class);
                if (force6 instanceof LList) {
                    ctx.value2 = force6;
                    ctx.proc = moduleMethod;
                    ctx.pc = 2;
                    return 0;
                }
                return -786430;
            }
            case 13: {
                ctx.value1 = o;
                final Object force7 = Promise.force(o2, LList.class);
                if (force7 instanceof LList) {
                    ctx.value2 = force7;
                    ctx.proc = moduleMethod;
                    ctx.pc = 2;
                    return 0;
                }
                return -786430;
            }
            case 12: {
                final Object force8 = Promise.force(o, Procedure.class);
                if (LangObjType.coerceToProcedureOrNull(force8) == null) {
                    return -786431;
                }
                ctx.value1 = force8;
                final Object force9 = Promise.force(o2, LList.class);
                if (force9 instanceof LList) {
                    ctx.value2 = force9;
                    ctx.proc = moduleMethod;
                    ctx.pc = 2;
                    return 0;
                }
                return -786430;
            }
            case 9: {
                final Object force10 = Promise.force(o, Procedure.class);
                if (LangObjType.coerceToProcedureOrNull(force10) == null) {
                    return -786431;
                }
                ctx.value1 = force10;
                final Object force11 = Promise.force(o2, LList.class);
                if (force11 instanceof LList) {
                    ctx.value2 = force11;
                    ctx.proc = moduleMethod;
                    ctx.pc = 2;
                    return 0;
                }
                return -786430;
            }
            case 8: {
                final Object force12 = Promise.force(o, Procedure.class);
                if (LangObjType.coerceToProcedureOrNull(force12) == null) {
                    return -786431;
                }
                ctx.value1 = force12;
                final Object force13 = Promise.force(o2, LList.class);
                if (force13 instanceof LList) {
                    ctx.value2 = force13;
                    ctx.proc = moduleMethod;
                    ctx.pc = 2;
                    return 0;
                }
                return -786430;
            }
            case 5: {
                final Object force14 = Promise.force(o, Procedure.class);
                if (LangObjType.coerceToProcedureOrNull(force14) == null) {
                    return -786431;
                }
                ctx.value1 = force14;
                final Object force15 = Promise.force(o2, LList.class);
                if (force15 instanceof LList) {
                    ctx.value2 = force15;
                    ctx.proc = moduleMethod;
                    ctx.pc = 2;
                    return 0;
                }
                return -786430;
            }
            default: {
                return super.match2(moduleMethod, o, o2, ctx);
            }
        }
    }
    
    @Override
    public int matchN(final ModuleMethod moduleMethod, final Object[] array, final CallContext ctx) {
        switch (moduleMethod.selector) {
            case 18: {
                ctx.values = array;
                ctx.proc = moduleMethod;
                ctx.pc = 5;
                return 0;
            }
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
            case 7: {
                ctx.values = array;
                ctx.proc = moduleMethod;
                ctx.pc = 5;
                return 0;
            }
            case 6: {
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
    public Object apply2(final ModuleMethod p0, final Object p1, final Object p2) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        gnu/expr/ModuleMethod.selector:I
        //     4: tableswitch {
        //               10: 72
        //               11: 246
        //               12: 246
        //               13: 94
        //               14: 116
        //               15: 246
        //               16: 246
        //               17: 138
        //               18: 160
        //               19: 174
        //               20: 188
        //               21: 202
        //               22: 224
        //          default: 246
        //        }
        //    72: aload_2        
        //    73: ldc             Lgnu/mapping/Procedure;.class
        //    75: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    78: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceToProcedure:(Ljava/lang/Object;)Lgnu/mapping/Procedure;
        //    81: aload_3        
        //    82: ldc             Lgnu/lists/LList;.class
        //    84: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    87: checkcast       Lgnu/lists/LList;
        //    90: invokestatic    kawa/lib/rnrs/lists.find:(Lgnu/mapping/Procedure;Lgnu/lists/LList;)Ljava/lang/Object;
        //    93: areturn        
        //    94: aload_2        
        //    95: ldc             Lgnu/mapping/Procedure;.class
        //    97: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   100: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceToProcedure:(Ljava/lang/Object;)Lgnu/mapping/Procedure;
        //   103: aload_3        
        //   104: ldc             Lgnu/lists/LList;.class
        //   106: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   109: checkcast       Lgnu/lists/LList;
        //   112: invokestatic    kawa/lib/rnrs/lists.filter:(Lgnu/mapping/Procedure;Lgnu/lists/LList;)Ljava/lang/Object;
        //   115: areturn        
        //   116: aload_2        
        //   117: ldc             Lgnu/mapping/Procedure;.class
        //   119: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   122: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceToProcedure:(Ljava/lang/Object;)Lgnu/mapping/Procedure;
        //   125: aload_3        
        //   126: ldc             Lgnu/lists/LList;.class
        //   128: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   131: checkcast       Lgnu/lists/LList;
        //   134: invokestatic    kawa/lib/rnrs/lists.partition:(Lgnu/mapping/Procedure;Lgnu/lists/LList;)Ljava/lang/Object;
        //   137: areturn        
        //   138: aload_2        
        //   139: ldc             Lgnu/mapping/Procedure;.class
        //   141: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   144: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceToProcedure:(Ljava/lang/Object;)Lgnu/mapping/Procedure;
        //   147: aload_3        
        //   148: ldc             Lgnu/lists/LList;.class
        //   150: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   153: checkcast       Lgnu/lists/LList;
        //   156: invokestatic    kawa/lib/rnrs/lists.remp:(Lgnu/mapping/Procedure;Lgnu/lists/LList;)Lgnu/lists/LList;
        //   159: areturn        
        //   160: aload_2        
        //   161: aload_3        
        //   162: ldc             Lgnu/lists/LList;.class
        //   164: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   167: checkcast       Lgnu/lists/LList;
        //   170: invokestatic    kawa/lib/rnrs/lists.remove:(Ljava/lang/Object;Lgnu/lists/LList;)Lgnu/lists/LList;
        //   173: areturn        
        //   174: aload_2        
        //   175: aload_3        
        //   176: ldc             Lgnu/lists/LList;.class
        //   178: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   181: checkcast       Lgnu/lists/LList;
        //   184: invokestatic    kawa/lib/rnrs/lists.remv:(Ljava/lang/Object;Lgnu/lists/LList;)Lgnu/lists/LList;
        //   187: areturn        
        //   188: aload_2        
        //   189: aload_3        
        //   190: ldc             Lgnu/lists/LList;.class
        //   192: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   195: checkcast       Lgnu/lists/LList;
        //   198: invokestatic    kawa/lib/rnrs/lists.remq:(Ljava/lang/Object;Lgnu/lists/LList;)Lgnu/lists/LList;
        //   201: areturn        
        //   202: aload_2        
        //   203: ldc             Lgnu/mapping/Procedure;.class
        //   205: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   208: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceToProcedure:(Ljava/lang/Object;)Lgnu/mapping/Procedure;
        //   211: aload_3        
        //   212: ldc             Lgnu/lists/LList;.class
        //   214: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   217: checkcast       Lgnu/lists/LList;
        //   220: invokestatic    kawa/lib/rnrs/lists.memp:(Lgnu/mapping/Procedure;Lgnu/lists/LList;)Ljava/lang/Object;
        //   223: areturn        
        //   224: aload_2        
        //   225: ldc             Lgnu/mapping/Procedure;.class
        //   227: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   230: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceToProcedure:(Ljava/lang/Object;)Lgnu/mapping/Procedure;
        //   233: aload_3        
        //   234: ldc             Lgnu/lists/LList;.class
        //   236: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   239: checkcast       Lgnu/lists/LList;
        //   242: invokestatic    kawa/lib/rnrs/lists.assp:(Lgnu/mapping/Procedure;Lgnu/lists/LList;)Ljava/lang/Object;
        //   245: areturn        
        //   246: aload_0        
        //   247: aload_1        
        //   248: aload_2        
        //   249: aload_3        
        //   250: invokespecial   gnu/expr/ModuleBody.apply2:(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   253: areturn        
        //   254: new             Lgnu/mapping/WrongType;
        //   257: dup_x1         
        //   258: swap           
        //   259: ldc_w           "find"
        //   262: iconst_1       
        //   263: aload_2        
        //   264: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   267: athrow         
        //   268: new             Lgnu/mapping/WrongType;
        //   271: dup_x1         
        //   272: swap           
        //   273: ldc_w           "find"
        //   276: iconst_2       
        //   277: aload_3        
        //   278: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   281: athrow         
        //   282: new             Lgnu/mapping/WrongType;
        //   285: dup_x1         
        //   286: swap           
        //   287: ldc_w           "filter"
        //   290: iconst_1       
        //   291: aload_2        
        //   292: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   295: athrow         
        //   296: new             Lgnu/mapping/WrongType;
        //   299: dup_x1         
        //   300: swap           
        //   301: ldc_w           "filter"
        //   304: iconst_2       
        //   305: aload_3        
        //   306: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   309: athrow         
        //   310: new             Lgnu/mapping/WrongType;
        //   313: dup_x1         
        //   314: swap           
        //   315: ldc_w           "partition"
        //   318: iconst_1       
        //   319: aload_2        
        //   320: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   323: athrow         
        //   324: new             Lgnu/mapping/WrongType;
        //   327: dup_x1         
        //   328: swap           
        //   329: ldc_w           "partition"
        //   332: iconst_2       
        //   333: aload_3        
        //   334: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   337: athrow         
        //   338: new             Lgnu/mapping/WrongType;
        //   341: dup_x1         
        //   342: swap           
        //   343: ldc_w           "remp"
        //   346: iconst_1       
        //   347: aload_2        
        //   348: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   351: athrow         
        //   352: new             Lgnu/mapping/WrongType;
        //   355: dup_x1         
        //   356: swap           
        //   357: ldc_w           "remp"
        //   360: iconst_2       
        //   361: aload_3        
        //   362: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   365: athrow         
        //   366: new             Lgnu/mapping/WrongType;
        //   369: dup_x1         
        //   370: swap           
        //   371: ldc_w           "remove"
        //   374: iconst_2       
        //   375: aload_3        
        //   376: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   379: athrow         
        //   380: new             Lgnu/mapping/WrongType;
        //   383: dup_x1         
        //   384: swap           
        //   385: ldc_w           "remv"
        //   388: iconst_2       
        //   389: aload_3        
        //   390: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   393: athrow         
        //   394: new             Lgnu/mapping/WrongType;
        //   397: dup_x1         
        //   398: swap           
        //   399: ldc_w           "remq"
        //   402: iconst_2       
        //   403: aload_3        
        //   404: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   407: athrow         
        //   408: new             Lgnu/mapping/WrongType;
        //   411: dup_x1         
        //   412: swap           
        //   413: ldc_w           "memp"
        //   416: iconst_1       
        //   417: aload_2        
        //   418: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   421: athrow         
        //   422: new             Lgnu/mapping/WrongType;
        //   425: dup_x1         
        //   426: swap           
        //   427: ldc_w           "memp"
        //   430: iconst_2       
        //   431: aload_3        
        //   432: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   435: athrow         
        //   436: new             Lgnu/mapping/WrongType;
        //   439: dup_x1         
        //   440: swap           
        //   441: ldc_w           "assp"
        //   444: iconst_1       
        //   445: aload_2        
        //   446: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   449: athrow         
        //   450: new             Lgnu/mapping/WrongType;
        //   453: dup_x1         
        //   454: swap           
        //   455: ldc_w           "assp"
        //   458: iconst_2       
        //   459: aload_3        
        //   460: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   463: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  78     81     254    268    Ljava/lang/ClassCastException;
        //  87     90     268    282    Ljava/lang/ClassCastException;
        //  100    103    282    296    Ljava/lang/ClassCastException;
        //  109    112    296    310    Ljava/lang/ClassCastException;
        //  122    125    310    324    Ljava/lang/ClassCastException;
        //  131    134    324    338    Ljava/lang/ClassCastException;
        //  144    147    338    352    Ljava/lang/ClassCastException;
        //  153    156    352    366    Ljava/lang/ClassCastException;
        //  167    170    366    380    Ljava/lang/ClassCastException;
        //  181    184    380    394    Ljava/lang/ClassCastException;
        //  195    198    394    408    Ljava/lang/ClassCastException;
        //  208    211    408    422    Ljava/lang/ClassCastException;
        //  217    220    422    436    Ljava/lang/ClassCastException;
        //  230    233    436    450    Ljava/lang/ClassCastException;
        //  239    242    450    464    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 210 out of bounds for length 210
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
        //     4: lookupswitch {
        //                6: 56
        //                7: 113
        //               10: 170
        //               11: 230
        //               18: 290
        //          default: 295
        //        }
        //    56: aload_2        
        //    57: iconst_0       
        //    58: aaload         
        //    59: ldc             Lgnu/mapping/Procedure;.class
        //    61: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    64: dup            
        //    65: astore_3       
        //    66: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceToProcedure:(Ljava/lang/Object;)Lgnu/mapping/Procedure;
        //    69: aload_2        
        //    70: iconst_1       
        //    71: aaload         
        //    72: ldc             Lgnu/lists/LList;.class
        //    74: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    77: dup            
        //    78: astore_3       
        //    79: checkcast       Lgnu/lists/LList;
        //    82: aload_2        
        //    83: arraylength    
        //    84: iconst_2       
        //    85: isub           
        //    86: istore_3       
        //    87: iload_3        
        //    88: anewarray       Ljava/lang/Object;
        //    91: goto            102
        //    94: dup            
        //    95: iload_3        
        //    96: aload_2        
        //    97: iload_3        
        //    98: iconst_2       
        //    99: iadd           
        //   100: aaload         
        //   101: aastore        
        //   102: iinc            3, -1
        //   105: iload_3        
        //   106: ifge            94
        //   109: invokestatic    kawa/lib/rnrs/lists.forAll$V:(Lgnu/mapping/Procedure;Lgnu/lists/LList;[Ljava/lang/Object;)Ljava/lang/Object;
        //   112: areturn        
        //   113: aload_2        
        //   114: iconst_0       
        //   115: aaload         
        //   116: ldc             Lgnu/mapping/Procedure;.class
        //   118: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   121: dup            
        //   122: astore_3       
        //   123: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceToProcedure:(Ljava/lang/Object;)Lgnu/mapping/Procedure;
        //   126: aload_2        
        //   127: iconst_1       
        //   128: aaload         
        //   129: ldc             Lgnu/lists/LList;.class
        //   131: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   134: dup            
        //   135: astore_3       
        //   136: checkcast       Lgnu/lists/LList;
        //   139: aload_2        
        //   140: arraylength    
        //   141: iconst_2       
        //   142: isub           
        //   143: istore_3       
        //   144: iload_3        
        //   145: anewarray       Ljava/lang/Object;
        //   148: goto            159
        //   151: dup            
        //   152: iload_3        
        //   153: aload_2        
        //   154: iload_3        
        //   155: iconst_2       
        //   156: iadd           
        //   157: aaload         
        //   158: aastore        
        //   159: iinc            3, -1
        //   162: iload_3        
        //   163: ifge            151
        //   166: invokestatic    kawa/lib/rnrs/lists.exists$V:(Lgnu/mapping/Procedure;Lgnu/lists/LList;[Ljava/lang/Object;)Ljava/lang/Object;
        //   169: areturn        
        //   170: aload_2        
        //   171: iconst_0       
        //   172: aaload         
        //   173: ldc             Lgnu/mapping/Procedure;.class
        //   175: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   178: dup            
        //   179: astore_3       
        //   180: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceToProcedure:(Ljava/lang/Object;)Lgnu/mapping/Procedure;
        //   183: aload_2        
        //   184: iconst_1       
        //   185: aaload         
        //   186: aload_2        
        //   187: iconst_2       
        //   188: aaload         
        //   189: ldc             Lgnu/lists/LList;.class
        //   191: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   194: dup            
        //   195: astore_3       
        //   196: checkcast       Lgnu/lists/LList;
        //   199: aload_2        
        //   200: arraylength    
        //   201: iconst_3       
        //   202: isub           
        //   203: istore_3       
        //   204: iload_3        
        //   205: anewarray       Ljava/lang/Object;
        //   208: goto            219
        //   211: dup            
        //   212: iload_3        
        //   213: aload_2        
        //   214: iload_3        
        //   215: iconst_3       
        //   216: iadd           
        //   217: aaload         
        //   218: aastore        
        //   219: iinc            3, -1
        //   222: iload_3        
        //   223: ifge            211
        //   226: invokestatic    kawa/lib/rnrs/lists.foldLeft$V:(Lgnu/mapping/Procedure;Ljava/lang/Object;Lgnu/lists/LList;[Ljava/lang/Object;)Ljava/lang/Object;
        //   229: areturn        
        //   230: aload_2        
        //   231: iconst_0       
        //   232: aaload         
        //   233: ldc             Lgnu/mapping/Procedure;.class
        //   235: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   238: dup            
        //   239: astore_3       
        //   240: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceToProcedure:(Ljava/lang/Object;)Lgnu/mapping/Procedure;
        //   243: aload_2        
        //   244: iconst_1       
        //   245: aaload         
        //   246: aload_2        
        //   247: iconst_2       
        //   248: aaload         
        //   249: ldc             Lgnu/lists/LList;.class
        //   251: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   254: dup            
        //   255: astore_3       
        //   256: checkcast       Lgnu/lists/LList;
        //   259: aload_2        
        //   260: arraylength    
        //   261: iconst_3       
        //   262: isub           
        //   263: istore_3       
        //   264: iload_3        
        //   265: anewarray       Ljava/lang/Object;
        //   268: goto            279
        //   271: dup            
        //   272: iload_3        
        //   273: aload_2        
        //   274: iload_3        
        //   275: iconst_3       
        //   276: iadd           
        //   277: aaload         
        //   278: aastore        
        //   279: iinc            3, -1
        //   282: iload_3        
        //   283: ifge            271
        //   286: invokestatic    kawa/lib/rnrs/lists.foldRight$V:(Lgnu/mapping/Procedure;Ljava/lang/Object;Lgnu/lists/LList;[Ljava/lang/Object;)Ljava/lang/Object;
        //   289: areturn        
        //   290: aload_2        
        //   291: invokestatic    kawa/lib/rnrs/lists.cons$St:([Ljava/lang/Object;)Ljava/lang/Object;
        //   294: areturn        
        //   295: aload_0        
        //   296: aload_1        
        //   297: aload_2        
        //   298: invokespecial   gnu/expr/ModuleBody.applyN:(Lgnu/expr/ModuleMethod;[Ljava/lang/Object;)Ljava/lang/Object;
        //   301: areturn        
        //   302: new             Lgnu/mapping/WrongType;
        //   305: dup_x1         
        //   306: swap           
        //   307: ldc_w           "for-all"
        //   310: iconst_1       
        //   311: aload_3        
        //   312: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   315: athrow         
        //   316: new             Lgnu/mapping/WrongType;
        //   319: dup_x1         
        //   320: swap           
        //   321: ldc_w           "for-all"
        //   324: iconst_2       
        //   325: aload_3        
        //   326: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   329: athrow         
        //   330: new             Lgnu/mapping/WrongType;
        //   333: dup_x1         
        //   334: swap           
        //   335: ldc_w           "exists"
        //   338: iconst_1       
        //   339: aload_3        
        //   340: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   343: athrow         
        //   344: new             Lgnu/mapping/WrongType;
        //   347: dup_x1         
        //   348: swap           
        //   349: ldc_w           "exists"
        //   352: iconst_2       
        //   353: aload_3        
        //   354: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   357: athrow         
        //   358: new             Lgnu/mapping/WrongType;
        //   361: dup_x1         
        //   362: swap           
        //   363: ldc_w           "fold-left"
        //   366: iconst_1       
        //   367: aload_3        
        //   368: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   371: athrow         
        //   372: new             Lgnu/mapping/WrongType;
        //   375: dup_x1         
        //   376: swap           
        //   377: ldc_w           "fold-left"
        //   380: iconst_3       
        //   381: aload_3        
        //   382: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   385: athrow         
        //   386: new             Lgnu/mapping/WrongType;
        //   389: dup_x1         
        //   390: swap           
        //   391: ldc_w           "fold-right"
        //   394: iconst_1       
        //   395: aload_3        
        //   396: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   399: athrow         
        //   400: new             Lgnu/mapping/WrongType;
        //   403: dup_x1         
        //   404: swap           
        //   405: ldc_w           "fold-right"
        //   408: iconst_3       
        //   409: aload_3        
        //   410: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   413: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  66     69     302    316    Ljava/lang/ClassCastException;
        //  79     82     316    330    Ljava/lang/ClassCastException;
        //  123    126    330    344    Ljava/lang/ClassCastException;
        //  136    139    344    358    Ljava/lang/ClassCastException;
        //  180    183    358    372    Ljava/lang/ClassCastException;
        //  196    199    372    386    Ljava/lang/ClassCastException;
        //  240    243    386    400    Ljava/lang/ClassCastException;
        //  256    259    400    414    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 229 out of bounds for length 229
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
