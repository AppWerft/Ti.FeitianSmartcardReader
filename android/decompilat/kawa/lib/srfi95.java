// 
// Decompiled by Procyon v0.5.36
// 

package kawa.lib;

import gnu.mapping.Promise;
import gnu.expr.ModuleInfo;
import gnu.mapping.Symbol;
import kawa.standard.append;
import gnu.lists.FVector;
import gnu.lists.EmptyList;
import gnu.lists.LList;
import gnu.lists.Sequence;
import gnu.lists.Consumer;
import gnu.mapping.CallContext;
import gnu.mapping.SimpleSymbol;
import gnu.math.IntNum;
import gnu.expr.ModuleMethod;
import gnu.expr.ModuleBody;

public class srfi95 extends ModuleBody
{
    public static final ModuleMethod sorted$Qu;
    public static final ModuleMethod merge;
    public static final ModuleMethod merge$Ex;
    public static final ModuleMethod sort;
    public static final ModuleMethod sort$Ex;
    public static final ModuleMethod $Pcsort$Mnlist;
    public static final ModuleMethod $Pcsort$Mnvector;
    public static final ModuleMethod $Pcvector$Mnsort$Ex;
    static final ModuleMethod identity;
    static final IntNum Lit0;
    static final IntNum Lit1;
    static final IntNum Lit2;
    static final IntNum Lit3;
    public static srfi95 $instance;
    static final SimpleSymbol Lit4;
    static final SimpleSymbol Lit5;
    static final SimpleSymbol Lit6;
    static final SimpleSymbol Lit7;
    static final SimpleSymbol Lit8;
    static final SimpleSymbol Lit9;
    static final SimpleSymbol Lit10;
    static final SimpleSymbol Lit11;
    static final SimpleSymbol Lit12;
    
    private static void $runBody$() {
        final CallContext $ctx;
        final Consumer $result = ($ctx = CallContext.getInstance()).consumer;
    }
    
    static Object identity(final Object x) {
        return x;
    }
    
    public static Object isSorted(final Object seq, final Object less$Qu) {
        return isSorted(seq, less$Qu, srfi95.identity);
    }
    
    public static Object isSorted(final Object seq, final Object less$Qu, final Object key) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokestatic    kawa/lib/lists.isNull:(Ljava/lang/Object;)Z
        //     4: ifeq            13
        //     7: getstatic       java/lang/Boolean.TRUE:Ljava/lang/Boolean;
        //    10: goto            357
        //    13: aload_0         /* seq */
        //    14: instanceof      Lgnu/lists/Sequence;
        //    17: ifeq            199
        //    20: aload_0         /* seq */
        //    21: ldc             Lgnu/lists/Sequence;.class
        //    23: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    26: dup            
        //    27: astore          4
        //    29: checkcast       Lgnu/lists/Sequence;
        //    32: astore_3        /* arr */
        //    33: iconst_m1      
        //    34: aload_3         /* arr */
        //    35: invokeinterface gnu/lists/Sequence.size:()I
        //    40: iadd           
        //    41: istore          dimax
        //    43: iload           dimax
        //    45: iconst_1       
        //    46: if_icmpgt       53
        //    49: iconst_1       
        //    50: goto            54
        //    53: iconst_0       
        //    54: istore          x
        //    56: iload           x
        //    58: ifeq            78
        //    61: iload           x
        //    63: ifeq            72
        //    66: getstatic       java/lang/Boolean.TRUE:Ljava/lang/Boolean;
        //    69: goto            357
        //    72: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //    75: goto            357
        //    78: iconst_m1      
        //    79: iload           dimax
        //    81: iadd           
        //    82: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //    85: getstatic       kawa/standard/Scheme.applyToArgs:Lgnu/kawa/functions/ApplyToArgs;
        //    88: aload_2         /* key */
        //    89: aload_3         /* arr */
        //    90: iload           dimax
        //    92: invokeinterface gnu/lists/Sequence.get:(I)Ljava/lang/Object;
        //    97: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   100: astore          7
        //   102: astore          idx
        //   104: aload           idx
        //   106: ldc             Lgnu/math/RealNum;.class
        //   108: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   111: dup            
        //   112: astore          9
        //   114: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceRealNum:(Ljava/lang/Object;)Lgnu/math/RealNum;
        //   117: invokestatic    kawa/lib/numbers.isNegative:(Lgnu/math/RealNum;)Z
        //   120: istore          x
        //   122: iload           x
        //   124: ifeq            144
        //   127: iload           x
        //   129: ifeq            138
        //   132: getstatic       java/lang/Boolean.TRUE:Ljava/lang/Boolean;
        //   135: goto            357
        //   138: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //   141: goto            357
        //   144: getstatic       kawa/standard/Scheme.applyToArgs:Lgnu/kawa/functions/ApplyToArgs;
        //   147: aload_2         /* key */
        //   148: getstatic       kawa/standard/Scheme.applyToArgs:Lgnu/kawa/functions/ApplyToArgs;
        //   151: aload_3         /* arr */
        //   152: aload           idx
        //   154: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   157: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   160: astore          nxt
        //   162: getstatic       kawa/standard/Scheme.applyToArgs:Lgnu/kawa/functions/ApplyToArgs;
        //   165: aload_1         /* less$Qu */
        //   166: aload           nxt
        //   168: aload           last
        //   170: invokevirtual   gnu/mapping/Procedure.apply3:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   173: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //   176: ifeq            193
        //   179: iconst_1       
        //   180: getstatic       kawa/lib/srfi95.Lit0:Lgnu/math/IntNum;
        //   183: aload           idx
        //   185: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   188: aload           nxt
        //   190: goto            100
        //   193: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //   196: goto            357
        //   199: aload_0         /* seq */
        //   200: ldc             Lgnu/lists/Pair;.class
        //   202: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   205: dup            
        //   206: astore_3       
        //   207: checkcast       Lgnu/lists/Pair;
        //   210: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   213: invokestatic    kawa/lib/lists.isNull:(Ljava/lang/Object;)Z
        //   216: ifeq            225
        //   219: getstatic       java/lang/Boolean.TRUE:Ljava/lang/Boolean;
        //   222: goto            357
        //   225: getstatic       kawa/standard/Scheme.applyToArgs:Lgnu/kawa/functions/ApplyToArgs;
        //   228: aload_2         /* key */
        //   229: aload_0         /* seq */
        //   230: ldc             Lgnu/lists/Pair;.class
        //   232: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   235: dup            
        //   236: astore_3       
        //   237: checkcast       Lgnu/lists/Pair;
        //   240: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   243: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   246: aload_0         /* seq */
        //   247: ldc             Lgnu/lists/Pair;.class
        //   249: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   252: dup            
        //   253: astore_3       
        //   254: checkcast       Lgnu/lists/Pair;
        //   257: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   260: astore          4
        //   262: astore_3        /* last */
        //   263: aload           next
        //   265: invokestatic    kawa/lib/lists.isNull:(Ljava/lang/Object;)Z
        //   268: istore          x
        //   270: iload           x
        //   272: ifeq            292
        //   275: iload           x
        //   277: ifeq            286
        //   280: getstatic       java/lang/Boolean.TRUE:Ljava/lang/Boolean;
        //   283: goto            357
        //   286: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //   289: goto            357
        //   292: getstatic       kawa/standard/Scheme.applyToArgs:Lgnu/kawa/functions/ApplyToArgs;
        //   295: aload_2         /* key */
        //   296: aload           next
        //   298: ldc             Lgnu/lists/Pair;.class
        //   300: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   303: dup            
        //   304: astore          7
        //   306: checkcast       Lgnu/lists/Pair;
        //   309: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   312: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   315: astore          nxt
        //   317: getstatic       kawa/standard/Scheme.applyToArgs:Lgnu/kawa/functions/ApplyToArgs;
        //   320: aload_1         /* less$Qu */
        //   321: aload           nxt
        //   323: aload_3         /* last */
        //   324: invokevirtual   gnu/mapping/Procedure.apply3:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   327: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //   330: ifne            354
        //   333: aload           nxt
        //   335: aload           next
        //   337: ldc             Lgnu/lists/Pair;.class
        //   339: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   342: dup            
        //   343: astore          7
        //   345: checkcast       Lgnu/lists/Pair;
        //   348: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   351: goto            260
        //   354: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //   357: areturn        
        //   358: new             Lgnu/mapping/WrongType;
        //   361: dup_x1         
        //   362: swap           
        //   363: ldc             "arr"
        //   365: bipush          -2
        //   367: aload           4
        //   369: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   372: athrow         
        //   373: new             Lgnu/mapping/WrongType;
        //   376: dup_x1         
        //   377: swap           
        //   378: ldc             "negative?"
        //   380: iconst_1       
        //   381: aload           9
        //   383: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   386: athrow         
        //   387: new             Lgnu/mapping/WrongType;
        //   390: dup_x1         
        //   391: swap           
        //   392: ldc             "cdr"
        //   394: iconst_1       
        //   395: aload_3        
        //   396: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   399: athrow         
        //   400: new             Lgnu/mapping/WrongType;
        //   403: dup_x1         
        //   404: swap           
        //   405: ldc             "car"
        //   407: iconst_1       
        //   408: aload_3        
        //   409: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   412: athrow         
        //   413: new             Lgnu/mapping/WrongType;
        //   416: dup_x1         
        //   417: swap           
        //   418: ldc             "cdr"
        //   420: iconst_1       
        //   421: aload_3        
        //   422: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   425: athrow         
        //   426: new             Lgnu/mapping/WrongType;
        //   429: dup_x1         
        //   430: swap           
        //   431: ldc             "car"
        //   433: iconst_1       
        //   434: aload           7
        //   436: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   439: athrow         
        //   440: new             Lgnu/mapping/WrongType;
        //   443: dup_x1         
        //   444: swap           
        //   445: ldc             "cdr"
        //   447: iconst_1       
        //   448: aload           7
        //   450: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   453: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  29     32     358    373    Ljava/lang/ClassCastException;
        //  114    117    373    387    Ljava/lang/ClassCastException;
        //  207    210    387    400    Ljava/lang/ClassCastException;
        //  237    240    400    413    Ljava/lang/ClassCastException;
        //  254    257    413    426    Ljava/lang/ClassCastException;
        //  306    309    426    440    Ljava/lang/ClassCastException;
        //  345    348    440    454    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public static Object merge(final Object a, final Object b, final Object isLess) {
        return merge(a, b, isLess, srfi95.identity);
    }
    
    public static Object merge(final Object a, final Object b, final Object isLess, final Object key) {
        public class srfi95$frame extends ModuleBody
        {
            Object key;
            Object less$Qu;
            
            public Object lambda1loop(final Object x, final Object kx, final Object a, final Object y, final Object ky, final Object b) {
                // 
                // This method could not be decompiled.
                // 
                // Original Bytecode:
                // 
                //     3: aload_0         /* this */
                //     4: getfield        kawa/lib/srfi95$frame.less$Qu:Ljava/lang/Object;
                //     7: aload           ky
                //     9: aload_2         /* kx */
                //    10: invokevirtual   gnu/mapping/Procedure.apply3:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                //    13: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
                //    16: ifeq            113
                //    19: aload           b
                //    21: invokestatic    kawa/lib/lists.isNull:(Ljava/lang/Object;)Z
                //    24: ifeq            40
                //    27: aload           y
                //    29: aload_1         /* x */
                //    30: aload_3         /* a */
                //    31: invokestatic    kawa/lib/lists.cons:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
                //    34: invokestatic    kawa/lib/lists.cons:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
                //    37: goto            203
                //    40: aload           y
                //    42: aload_0         /* this */
                //    43: aload_1         /* x */
                //    44: aload_2         /* kx */
                //    45: aload_3         /* a */
                //    46: aload           b
                //    48: ldc             Lgnu/lists/Pair;.class
                //    50: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //    53: dup            
                //    54: astore          7
                //    56: checkcast       Lgnu/lists/Pair;
                //    59: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
                //    62: getstatic       kawa/standard/Scheme.applyToArgs:Lgnu/kawa/functions/ApplyToArgs;
                //    65: aload_0         /* this */
                //    66: getfield        kawa/lib/srfi95$frame.key:Ljava/lang/Object;
                //    69: aload           b
                //    71: ldc             Lgnu/lists/Pair;.class
                //    73: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //    76: dup            
                //    77: astore          7
                //    79: checkcast       Lgnu/lists/Pair;
                //    82: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
                //    85: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                //    88: aload           b
                //    90: ldc             Lgnu/lists/Pair;.class
                //    92: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //    95: dup            
                //    96: astore          7
                //    98: checkcast       Lgnu/lists/Pair;
                //   101: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
                //   104: invokevirtual   kawa/lib/srfi95$frame.lambda1loop:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                //   107: invokestatic    kawa/lib/lists.cons:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
                //   110: goto            203
                //   113: aload_3         /* a */
                //   114: invokestatic    kawa/lib/lists.isNull:(Ljava/lang/Object;)Z
                //   117: ifeq            134
                //   120: aload_1         /* x */
                //   121: aload           y
                //   123: aload           b
                //   125: invokestatic    kawa/lib/lists.cons:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
                //   128: invokestatic    kawa/lib/lists.cons:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
                //   131: goto            203
                //   134: aload_1         /* x */
                //   135: aload_0         /* this */
                //   136: aload_3         /* a */
                //   137: ldc             Lgnu/lists/Pair;.class
                //   139: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //   142: dup            
                //   143: astore          7
                //   145: checkcast       Lgnu/lists/Pair;
                //   148: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
                //   151: getstatic       kawa/standard/Scheme.applyToArgs:Lgnu/kawa/functions/ApplyToArgs;
                //   154: aload_0         /* this */
                //   155: getfield        kawa/lib/srfi95$frame.key:Ljava/lang/Object;
                //   158: aload_3         /* a */
                //   159: ldc             Lgnu/lists/Pair;.class
                //   161: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //   164: dup            
                //   165: astore          7
                //   167: checkcast       Lgnu/lists/Pair;
                //   170: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
                //   173: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                //   176: aload_3         /* a */
                //   177: ldc             Lgnu/lists/Pair;.class
                //   179: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //   182: dup            
                //   183: astore          7
                //   185: checkcast       Lgnu/lists/Pair;
                //   188: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
                //   191: aload           y
                //   193: aload           ky
                //   195: aload           b
                //   197: invokevirtual   kawa/lib/srfi95$frame.lambda1loop:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                //   200: invokestatic    kawa/lib/lists.cons:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
                //   203: areturn        
                //   204: new             Lgnu/mapping/WrongType;
                //   207: dup_x1         
                //   208: swap           
                //   209: ldc             "car"
                //   211: iconst_1       
                //   212: aload           7
                //   214: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //   217: athrow         
                //   218: new             Lgnu/mapping/WrongType;
                //   221: dup_x1         
                //   222: swap           
                //   223: ldc             "car"
                //   225: iconst_1       
                //   226: aload           7
                //   228: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //   231: athrow         
                //   232: new             Lgnu/mapping/WrongType;
                //   235: dup_x1         
                //   236: swap           
                //   237: ldc             "cdr"
                //   239: iconst_1       
                //   240: aload           7
                //   242: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //   245: athrow         
                //   246: new             Lgnu/mapping/WrongType;
                //   249: dup_x1         
                //   250: swap           
                //   251: ldc             "car"
                //   253: iconst_1       
                //   254: aload           7
                //   256: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //   259: athrow         
                //   260: new             Lgnu/mapping/WrongType;
                //   263: dup_x1         
                //   264: swap           
                //   265: ldc             "car"
                //   267: iconst_1       
                //   268: aload           7
                //   270: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //   273: athrow         
                //   274: new             Lgnu/mapping/WrongType;
                //   277: dup_x1         
                //   278: swap           
                //   279: ldc             "cdr"
                //   281: iconst_1       
                //   282: aload           7
                //   284: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //   287: athrow         
                //    Exceptions:
                //  Try           Handler
                //  Start  End    Start  End    Type                          
                //  -----  -----  -----  -----  ------------------------------
                //  56     59     204    218    Ljava/lang/ClassCastException;
                //  79     82     218    232    Ljava/lang/ClassCastException;
                //  98     101    232    246    Ljava/lang/ClassCastException;
                //  145    148    246    260    Ljava/lang/ClassCastException;
                //  167    170    260    274    Ljava/lang/ClassCastException;
                //  185    188    274    288    Ljava/lang/ClassCastException;
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
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: dup            
        //     4: invokespecial   kawa/lib/srfi95$frame.<init>:()V
        //     7: astore          $heapFrame
        //     9: aload           $heapFrame
        //    11: aload_2         /* isLess */
        //    12: putfield        kawa/lib/srfi95$frame.less$Qu:Ljava/lang/Object;
        //    15: aload           $heapFrame
        //    17: aload_3         /* key */
        //    18: putfield        kawa/lib/srfi95$frame.key:Ljava/lang/Object;
        //    21: aload_0         /* a */
        //    22: invokestatic    kawa/lib/lists.isNull:(Ljava/lang/Object;)Z
        //    25: ifeq            32
        //    28: aload_1         /* b */
        //    29: goto            160
        //    32: aload_1         /* b */
        //    33: invokestatic    kawa/lib/lists.isNull:(Ljava/lang/Object;)Z
        //    36: ifeq            43
        //    39: aload_0         /* a */
        //    40: goto            160
        //    43: aload           $heapFrame
        //    45: aload_0         /* a */
        //    46: ldc             Lgnu/lists/Pair;.class
        //    48: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    51: dup            
        //    52: astore          5
        //    54: checkcast       Lgnu/lists/Pair;
        //    57: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    60: getstatic       kawa/standard/Scheme.applyToArgs:Lgnu/kawa/functions/ApplyToArgs;
        //    63: aload           $heapFrame
        //    65: getfield        kawa/lib/srfi95$frame.key:Ljava/lang/Object;
        //    68: aload_0         /* a */
        //    69: ldc             Lgnu/lists/Pair;.class
        //    71: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    74: dup            
        //    75: astore          5
        //    77: checkcast       Lgnu/lists/Pair;
        //    80: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    83: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    86: aload_0         /* a */
        //    87: ldc             Lgnu/lists/Pair;.class
        //    89: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    92: dup            
        //    93: astore          5
        //    95: checkcast       Lgnu/lists/Pair;
        //    98: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   101: aload_1         /* b */
        //   102: ldc             Lgnu/lists/Pair;.class
        //   104: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   107: dup            
        //   108: astore          5
        //   110: checkcast       Lgnu/lists/Pair;
        //   113: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   116: getstatic       kawa/standard/Scheme.applyToArgs:Lgnu/kawa/functions/ApplyToArgs;
        //   119: aload           $heapFrame
        //   121: getfield        kawa/lib/srfi95$frame.key:Ljava/lang/Object;
        //   124: aload_1         /* b */
        //   125: ldc             Lgnu/lists/Pair;.class
        //   127: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   130: dup            
        //   131: astore          5
        //   133: checkcast       Lgnu/lists/Pair;
        //   136: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   139: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   142: aload_1         /* b */
        //   143: ldc             Lgnu/lists/Pair;.class
        //   145: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   148: dup            
        //   149: astore          5
        //   151: checkcast       Lgnu/lists/Pair;
        //   154: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   157: invokevirtual   kawa/lib/srfi95$frame.lambda1loop:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   160: areturn        
        //   161: new             Lgnu/mapping/WrongType;
        //   164: dup_x1         
        //   165: swap           
        //   166: ldc             "car"
        //   168: iconst_1       
        //   169: aload           5
        //   171: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   174: athrow         
        //   175: new             Lgnu/mapping/WrongType;
        //   178: dup_x1         
        //   179: swap           
        //   180: ldc             "car"
        //   182: iconst_1       
        //   183: aload           5
        //   185: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   188: athrow         
        //   189: new             Lgnu/mapping/WrongType;
        //   192: dup_x1         
        //   193: swap           
        //   194: ldc             "cdr"
        //   196: iconst_1       
        //   197: aload           5
        //   199: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   202: athrow         
        //   203: new             Lgnu/mapping/WrongType;
        //   206: dup_x1         
        //   207: swap           
        //   208: ldc             "car"
        //   210: iconst_1       
        //   211: aload           5
        //   213: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   216: athrow         
        //   217: new             Lgnu/mapping/WrongType;
        //   220: dup_x1         
        //   221: swap           
        //   222: ldc             "car"
        //   224: iconst_1       
        //   225: aload           5
        //   227: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   230: athrow         
        //   231: new             Lgnu/mapping/WrongType;
        //   234: dup_x1         
        //   235: swap           
        //   236: ldc             "cdr"
        //   238: iconst_1       
        //   239: aload           5
        //   241: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   244: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  54     57     161    175    Ljava/lang/ClassCastException;
        //  77     80     175    189    Ljava/lang/ClassCastException;
        //  95     98     189    203    Ljava/lang/ClassCastException;
        //  110    113    203    217    Ljava/lang/ClassCastException;
        //  133    136    217    231    Ljava/lang/ClassCastException;
        //  151    154    231    245    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 121 out of bounds for length 121
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
    
    public static Object merge$Ex(final Object a, final Object b, final Object less$Qu) {
        return merge$Ex(a, b, less$Qu, srfi95.identity);
    }
    
    public static Object merge$Ex(final Object a, final Object b, final Object less$Qu, final Object key) {
        return sort$ClMerge$Ex(a, b, less$Qu, key);
    }
    
    static Object sort$ClMerge$Ex(final Object a, final Object b, final Object isLess, final Object key) {
        public class srfi95$frame1 extends ModuleBody
        {
            Object key;
            Object less$Qu;
            
            public Object lambda3loop(final Object r, final Object a, final Object kcara, final Object b, final Object kcarb) {
                // 
                // This method could not be decompiled.
                // 
                // Original Bytecode:
                // 
                //     3: aload_0         /* this */
                //     4: getfield        kawa/lib/srfi95$frame1.less$Qu:Ljava/lang/Object;
                //     7: aload           kcarb
                //     9: aload_3         /* kcara */
                //    10: invokevirtual   gnu/mapping/Procedure.apply3:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                //    13: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
                //    16: ifeq            122
                //    19: aload_1         /* r */
                //    20: ldc             Lgnu/lists/Pair;.class
                //    22: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //    25: dup            
                //    26: astore          6
                //    28: checkcast       Lgnu/lists/Pair;
                //    31: aload           b
                //    33: invokestatic    kawa/lib/lists.setCdr$Ex:(Lgnu/lists/Pair;Ljava/lang/Object;)V
                //    36: aload           b
                //    38: ldc             Lgnu/lists/Pair;.class
                //    40: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //    43: dup            
                //    44: astore          6
                //    46: checkcast       Lgnu/lists/Pair;
                //    49: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
                //    52: invokestatic    kawa/lib/lists.isNull:(Ljava/lang/Object;)Z
                //    55: ifeq            81
                //    58: aload           b
                //    60: ldc             Lgnu/lists/Pair;.class
                //    62: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //    65: dup            
                //    66: astore          6
                //    68: checkcast       Lgnu/lists/Pair;
                //    71: aload_2         /* a */
                //    72: invokestatic    kawa/lib/lists.setCdr$Ex:(Lgnu/lists/Pair;Ljava/lang/Object;)V
                //    75: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
                //    78: goto            218
                //    81: aload           b
                //    83: aload           b
                //    85: ldc             Lgnu/lists/Pair;.class
                //    87: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //    90: dup            
                //    91: astore          6
                //    93: checkcast       Lgnu/lists/Pair;
                //    96: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
                //    99: getstatic       kawa/standard/Scheme.applyToArgs:Lgnu/kawa/functions/ApplyToArgs;
                //   102: aload_0         /* this */
                //   103: getfield        kawa/lib/srfi95$frame1.key:Ljava/lang/Object;
                //   106: aload           b
                //   108: invokestatic    kawa/lib/lists.cadr:(Ljava/lang/Object;)Ljava/lang/Object;
                //   111: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                //   114: astore          kcarb
                //   116: astore          b
                //   118: astore_1        /* r */
                //   119: goto            0
                //   122: aload_1         /* r */
                //   123: ldc             Lgnu/lists/Pair;.class
                //   125: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //   128: dup            
                //   129: astore          6
                //   131: checkcast       Lgnu/lists/Pair;
                //   134: aload_2         /* a */
                //   135: invokestatic    kawa/lib/lists.setCdr$Ex:(Lgnu/lists/Pair;Ljava/lang/Object;)V
                //   138: aload_2         /* a */
                //   139: ldc             Lgnu/lists/Pair;.class
                //   141: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //   144: dup            
                //   145: astore          6
                //   147: checkcast       Lgnu/lists/Pair;
                //   150: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
                //   153: invokestatic    kawa/lib/lists.isNull:(Ljava/lang/Object;)Z
                //   156: ifeq            182
                //   159: aload_2         /* a */
                //   160: ldc             Lgnu/lists/Pair;.class
                //   162: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //   165: dup            
                //   166: astore          6
                //   168: checkcast       Lgnu/lists/Pair;
                //   171: aload           b
                //   173: invokestatic    kawa/lib/lists.setCdr$Ex:(Lgnu/lists/Pair;Ljava/lang/Object;)V
                //   176: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
                //   179: goto            218
                //   182: aload_2         /* a */
                //   183: aload_2         /* a */
                //   184: ldc             Lgnu/lists/Pair;.class
                //   186: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //   189: dup            
                //   190: astore          6
                //   192: checkcast       Lgnu/lists/Pair;
                //   195: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
                //   198: getstatic       kawa/standard/Scheme.applyToArgs:Lgnu/kawa/functions/ApplyToArgs;
                //   201: aload_0         /* this */
                //   202: getfield        kawa/lib/srfi95$frame1.key:Ljava/lang/Object;
                //   205: aload_2         /* a */
                //   206: invokestatic    kawa/lib/lists.cadr:(Ljava/lang/Object;)Ljava/lang/Object;
                //   209: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                //   212: astore_3        /* kcara */
                //   213: astore_2        /* a */
                //   214: astore_1        /* r */
                //   215: goto            0
                //   218: areturn        
                //   219: new             Lgnu/mapping/WrongType;
                //   222: dup_x1         
                //   223: swap           
                //   224: ldc             "set-cdr!"
                //   226: iconst_1       
                //   227: aload           6
                //   229: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //   232: athrow         
                //   233: new             Lgnu/mapping/WrongType;
                //   236: dup_x1         
                //   237: swap           
                //   238: ldc             "cdr"
                //   240: iconst_1       
                //   241: aload           6
                //   243: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //   246: athrow         
                //   247: new             Lgnu/mapping/WrongType;
                //   250: dup_x1         
                //   251: swap           
                //   252: ldc             "set-cdr!"
                //   254: iconst_1       
                //   255: aload           6
                //   257: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //   260: athrow         
                //   261: new             Lgnu/mapping/WrongType;
                //   264: dup_x1         
                //   265: swap           
                //   266: ldc             "cdr"
                //   268: iconst_1       
                //   269: aload           6
                //   271: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //   274: athrow         
                //   275: new             Lgnu/mapping/WrongType;
                //   278: dup_x1         
                //   279: swap           
                //   280: ldc             "set-cdr!"
                //   282: iconst_1       
                //   283: aload           6
                //   285: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //   288: athrow         
                //   289: new             Lgnu/mapping/WrongType;
                //   292: dup_x1         
                //   293: swap           
                //   294: ldc             "cdr"
                //   296: iconst_1       
                //   297: aload           6
                //   299: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //   302: athrow         
                //   303: new             Lgnu/mapping/WrongType;
                //   306: dup_x1         
                //   307: swap           
                //   308: ldc             "set-cdr!"
                //   310: iconst_1       
                //   311: aload           6
                //   313: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //   316: athrow         
                //   317: new             Lgnu/mapping/WrongType;
                //   320: dup_x1         
                //   321: swap           
                //   322: ldc             "cdr"
                //   324: iconst_1       
                //   325: aload           6
                //   327: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //   330: athrow         
                //    Exceptions:
                //  Try           Handler
                //  Start  End    Start  End    Type                          
                //  -----  -----  -----  -----  ------------------------------
                //  28     31     219    233    Ljava/lang/ClassCastException;
                //  46     49     233    247    Ljava/lang/ClassCastException;
                //  68     71     247    261    Ljava/lang/ClassCastException;
                //  93     96     261    275    Ljava/lang/ClassCastException;
                //  131    134    275    289    Ljava/lang/ClassCastException;
                //  147    150    289    303    Ljava/lang/ClassCastException;
                //  168    171    303    317    Ljava/lang/ClassCastException;
                //  192    195    317    331    Ljava/lang/ClassCastException;
                // 
                // The error that occurred was:
                // 
                // java.lang.IndexOutOfBoundsException: Index 163 out of bounds for length 163
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
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: dup            
        //     4: invokespecial   kawa/lib/srfi95$frame1.<init>:()V
        //     7: astore          $heapFrame
        //     9: aload           $heapFrame
        //    11: aload_2         /* isLess */
        //    12: putfield        kawa/lib/srfi95$frame1.less$Qu:Ljava/lang/Object;
        //    15: aload           $heapFrame
        //    17: aload_3         /* key */
        //    18: putfield        kawa/lib/srfi95$frame1.key:Ljava/lang/Object;
        //    21: aload_0         /* a */
        //    22: invokestatic    kawa/lib/lists.isNull:(Ljava/lang/Object;)Z
        //    25: ifeq            32
        //    28: aload_1         /* b */
        //    29: goto            285
        //    32: aload_1         /* b */
        //    33: invokestatic    kawa/lib/lists.isNull:(Ljava/lang/Object;)Z
        //    36: ifeq            43
        //    39: aload_0         /* a */
        //    40: goto            285
        //    43: getstatic       kawa/standard/Scheme.applyToArgs:Lgnu/kawa/functions/ApplyToArgs;
        //    46: aload           $heapFrame
        //    48: getfield        kawa/lib/srfi95$frame1.key:Ljava/lang/Object;
        //    51: aload_0         /* a */
        //    52: ldc             Lgnu/lists/Pair;.class
        //    54: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    57: dup            
        //    58: astore          6
        //    60: checkcast       Lgnu/lists/Pair;
        //    63: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    66: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    69: astore          5
        //    71: getstatic       kawa/standard/Scheme.applyToArgs:Lgnu/kawa/functions/ApplyToArgs;
        //    74: aload           $heapFrame
        //    76: getfield        kawa/lib/srfi95$frame1.key:Ljava/lang/Object;
        //    79: aload_1         /* b */
        //    80: ldc             Lgnu/lists/Pair;.class
        //    82: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    85: dup            
        //    86: astore          7
        //    88: checkcast       Lgnu/lists/Pair;
        //    91: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    94: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    97: astore          kcarb
        //    99: getstatic       kawa/standard/Scheme.applyToArgs:Lgnu/kawa/functions/ApplyToArgs;
        //   102: aload           $heapFrame
        //   104: getfield        kawa/lib/srfi95$frame1.less$Qu:Ljava/lang/Object;
        //   107: aload           kcarb
        //   109: aload           kcara
        //   111: invokevirtual   gnu/mapping/Procedure.apply3:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   114: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //   117: ifeq            204
        //   120: aload_1         /* b */
        //   121: ldc             Lgnu/lists/Pair;.class
        //   123: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   126: dup            
        //   127: astore          7
        //   129: checkcast       Lgnu/lists/Pair;
        //   132: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   135: invokestatic    kawa/lib/lists.isNull:(Ljava/lang/Object;)Z
        //   138: ifeq            160
        //   141: aload_1         /* b */
        //   142: ldc             Lgnu/lists/Pair;.class
        //   144: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   147: dup            
        //   148: astore          7
        //   150: checkcast       Lgnu/lists/Pair;
        //   153: aload_0         /* a */
        //   154: invokestatic    kawa/lib/lists.setCdr$Ex:(Lgnu/lists/Pair;Ljava/lang/Object;)V
        //   157: goto            200
        //   160: aload           $heapFrame
        //   162: aload_1         /* b */
        //   163: aload_0         /* a */
        //   164: aload           kcara
        //   166: aload_1         /* b */
        //   167: ldc             Lgnu/lists/Pair;.class
        //   169: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   172: dup            
        //   173: astore          7
        //   175: checkcast       Lgnu/lists/Pair;
        //   178: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   181: getstatic       kawa/standard/Scheme.applyToArgs:Lgnu/kawa/functions/ApplyToArgs;
        //   184: aload           $heapFrame
        //   186: getfield        kawa/lib/srfi95$frame1.key:Ljava/lang/Object;
        //   189: aload_1         /* b */
        //   190: invokestatic    kawa/lib/lists.cadr:(Ljava/lang/Object;)Ljava/lang/Object;
        //   193: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   196: invokevirtual   kawa/lib/srfi95$frame1.lambda3loop:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   199: pop            
        //   200: aload_1         /* b */
        //   201: goto            285
        //   204: aload_0         /* a */
        //   205: ldc             Lgnu/lists/Pair;.class
        //   207: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   210: dup            
        //   211: astore          7
        //   213: checkcast       Lgnu/lists/Pair;
        //   216: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   219: invokestatic    kawa/lib/lists.isNull:(Ljava/lang/Object;)Z
        //   222: ifeq            244
        //   225: aload_0         /* a */
        //   226: ldc             Lgnu/lists/Pair;.class
        //   228: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   231: dup            
        //   232: astore          7
        //   234: checkcast       Lgnu/lists/Pair;
        //   237: aload_1         /* b */
        //   238: invokestatic    kawa/lib/lists.setCdr$Ex:(Lgnu/lists/Pair;Ljava/lang/Object;)V
        //   241: goto            284
        //   244: aload           $heapFrame
        //   246: aload_0         /* a */
        //   247: aload_0         /* a */
        //   248: ldc             Lgnu/lists/Pair;.class
        //   250: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   253: dup            
        //   254: astore          7
        //   256: checkcast       Lgnu/lists/Pair;
        //   259: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   262: getstatic       kawa/standard/Scheme.applyToArgs:Lgnu/kawa/functions/ApplyToArgs;
        //   265: aload           $heapFrame
        //   267: getfield        kawa/lib/srfi95$frame1.key:Ljava/lang/Object;
        //   270: aload_0         /* a */
        //   271: invokestatic    kawa/lib/lists.cadr:(Ljava/lang/Object;)Ljava/lang/Object;
        //   274: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   277: aload_1         /* b */
        //   278: aload           kcarb
        //   280: invokevirtual   kawa/lib/srfi95$frame1.lambda3loop:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   283: pop            
        //   284: aload_0         /* a */
        //   285: areturn        
        //   286: new             Lgnu/mapping/WrongType;
        //   289: dup_x1         
        //   290: swap           
        //   291: ldc             "car"
        //   293: iconst_1       
        //   294: aload           6
        //   296: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   299: athrow         
        //   300: new             Lgnu/mapping/WrongType;
        //   303: dup_x1         
        //   304: swap           
        //   305: ldc             "car"
        //   307: iconst_1       
        //   308: aload           7
        //   310: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   313: athrow         
        //   314: new             Lgnu/mapping/WrongType;
        //   317: dup_x1         
        //   318: swap           
        //   319: ldc             "cdr"
        //   321: iconst_1       
        //   322: aload           7
        //   324: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   327: athrow         
        //   328: new             Lgnu/mapping/WrongType;
        //   331: dup_x1         
        //   332: swap           
        //   333: ldc             "set-cdr!"
        //   335: iconst_1       
        //   336: aload           7
        //   338: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   341: athrow         
        //   342: new             Lgnu/mapping/WrongType;
        //   345: dup_x1         
        //   346: swap           
        //   347: ldc             "cdr"
        //   349: iconst_1       
        //   350: aload           7
        //   352: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   355: athrow         
        //   356: new             Lgnu/mapping/WrongType;
        //   359: dup_x1         
        //   360: swap           
        //   361: ldc             "cdr"
        //   363: iconst_1       
        //   364: aload           7
        //   366: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   369: athrow         
        //   370: new             Lgnu/mapping/WrongType;
        //   373: dup_x1         
        //   374: swap           
        //   375: ldc             "set-cdr!"
        //   377: iconst_1       
        //   378: aload           7
        //   380: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   383: athrow         
        //   384: new             Lgnu/mapping/WrongType;
        //   387: dup_x1         
        //   388: swap           
        //   389: ldc             "cdr"
        //   391: iconst_1       
        //   392: aload           7
        //   394: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   397: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  60     63     286    300    Ljava/lang/ClassCastException;
        //  88     91     300    314    Ljava/lang/ClassCastException;
        //  129    132    314    328    Ljava/lang/ClassCastException;
        //  150    153    328    342    Ljava/lang/ClassCastException;
        //  175    178    342    356    Ljava/lang/ClassCastException;
        //  213    216    356    370    Ljava/lang/ClassCastException;
        //  234    237    370    384    Ljava/lang/ClassCastException;
        //  256    259    384    398    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public static Object $PcSortList(final Object seq, final Object isLess, final Object key) {
        public class srfi95$frame0 extends ModuleBody
        {
            Object seq;
            Object less$Qu;
            
            public Object lambda2step(final Object keyer, final Object n) {
                // 
                // This method could not be decompiled.
                // 
                // Original Bytecode:
                // 
                //     1: getstatic       kawa/lib/srfi95.Lit1:Lgnu/math/IntNum;
                //     4: invokestatic    gnu/kawa/functions/NumberCompare.$Gr:(Ljava/lang/Object;Ljava/lang/Object;)Z
                //     7: ifeq            61
                //    10: getstatic       gnu/kawa/functions/DivideOp.quotient:Lgnu/kawa/functions/DivideOp;
                //    13: aload_2         /* n */
                //    14: getstatic       kawa/lib/srfi95.Lit1:Lgnu/math/IntNum;
                //    17: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                //    20: astore_3        /* j */
                //    21: aload_0         /* this */
                //    22: aload_1         /* keyer */
                //    23: aload_3         /* j */
                //    24: invokevirtual   kawa/lib/srfi95$frame0.lambda2step:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                //    27: astore          a
                //    29: iconst_m1      
                //    30: aload_2         /* n */
                //    31: aload_3         /* j */
                //    32: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                //    35: astore          k
                //    37: aload_0         /* this */
                //    38: aload_1         /* keyer */
                //    39: aload           k
                //    41: invokevirtual   kawa/lib/srfi95$frame0.lambda2step:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                //    44: astore          b
                //    46: aload           a
                //    48: aload           b
                //    50: aload_0         /* this */
                //    51: getfield        kawa/lib/srfi95$frame0.less$Qu:Ljava/lang/Object;
                //    54: aload_1         /* keyer */
                //    55: invokestatic    kawa/lib/srfi95.sort$ClMerge$Ex:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                //    58: goto            308
                //    61: aload_2         /* n */
                //    62: getstatic       kawa/lib/srfi95.Lit1:Lgnu/math/IntNum;
                //    65: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
                //    68: ifeq            246
                //    71: aload_0         /* this */
                //    72: getfield        kawa/lib/srfi95$frame0.seq:Ljava/lang/Object;
                //    75: ldc             Lgnu/lists/Pair;.class
                //    77: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //    80: dup            
                //    81: astore          4
                //    83: checkcast       Lgnu/lists/Pair;
                //    86: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
                //    89: astore_3       
                //    90: aload_0         /* this */
                //    91: getfield        kawa/lib/srfi95$frame0.seq:Ljava/lang/Object;
                //    94: invokestatic    kawa/lib/lists.cadr:(Ljava/lang/Object;)Ljava/lang/Object;
                //    97: astore          4
                //    99: aload_0         /* this */
                //   100: getfield        kawa/lib/srfi95$frame0.seq:Ljava/lang/Object;
                //   103: astore          p
                //   105: aload_0         /* this */
                //   106: aload_0         /* this */
                //   107: getfield        kawa/lib/srfi95$frame0.seq:Ljava/lang/Object;
                //   110: invokestatic    kawa/lib/lists.cddr:(Ljava/lang/Object;)Ljava/lang/Object;
                //   113: putfield        kawa/lib/srfi95$frame0.seq:Ljava/lang/Object;
                //   116: getstatic       kawa/standard/Scheme.applyToArgs:Lgnu/kawa/functions/ApplyToArgs;
                //   119: aload_0         /* this */
                //   120: getfield        kawa/lib/srfi95$frame0.less$Qu:Ljava/lang/Object;
                //   123: aload_1         /* keyer */
                //   124: ldc             Lgnu/mapping/Procedure;.class
                //   126: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //   129: checkcast       Lgnu/mapping/Procedure;
                //   132: aload           y
                //   134: invokevirtual   gnu/mapping/Procedure.apply1:(Ljava/lang/Object;)Ljava/lang/Object;
                //   137: aload_1         /* keyer */
                //   138: ldc             Lgnu/mapping/Procedure;.class
                //   140: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //   143: checkcast       Lgnu/mapping/Procedure;
                //   146: aload_3         /* x */
                //   147: invokevirtual   gnu/mapping/Procedure.apply1:(Ljava/lang/Object;)Ljava/lang/Object;
                //   150: invokevirtual   gnu/mapping/Procedure.apply3:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                //   153: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
                //   156: ifeq            208
                //   159: aload           p
                //   161: ldc             Lgnu/lists/Pair;.class
                //   163: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //   166: dup            
                //   167: astore          6
                //   169: checkcast       Lgnu/lists/Pair;
                //   172: aload           y
                //   174: invokestatic    kawa/lib/lists.setCar$Ex:(Lgnu/lists/Pair;Ljava/lang/Object;)V
                //   177: aload           p
                //   179: ldc             Lgnu/lists/Pair;.class
                //   181: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //   184: dup            
                //   185: astore          6
                //   187: checkcast       Lgnu/lists/Pair;
                //   190: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
                //   193: ldc             Lgnu/lists/Pair;.class
                //   195: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //   198: dup            
                //   199: astore          6
                //   201: checkcast       Lgnu/lists/Pair;
                //   204: aload_3         /* x */
                //   205: invokestatic    kawa/lib/lists.setCar$Ex:(Lgnu/lists/Pair;Ljava/lang/Object;)V
                //   208: aload           p
                //   210: ldc             Lgnu/lists/Pair;.class
                //   212: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //   215: dup            
                //   216: astore          6
                //   218: checkcast       Lgnu/lists/Pair;
                //   221: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
                //   224: ldc             Lgnu/lists/Pair;.class
                //   226: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //   229: dup            
                //   230: astore          6
                //   232: checkcast       Lgnu/lists/Pair;
                //   235: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
                //   238: invokestatic    kawa/lib/lists.setCdr$Ex:(Lgnu/lists/Pair;Ljava/lang/Object;)V
                //   241: aload           p
                //   243: goto            308
                //   246: aload_2         /* n */
                //   247: getstatic       kawa/lib/srfi95.Lit2:Lgnu/math/IntNum;
                //   250: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
                //   253: ifeq            305
                //   256: aload_0         /* this */
                //   257: getfield        kawa/lib/srfi95$frame0.seq:Ljava/lang/Object;
                //   260: astore_3        /* p */
                //   261: aload_0         /* this */
                //   262: aload_0         /* this */
                //   263: getfield        kawa/lib/srfi95$frame0.seq:Ljava/lang/Object;
                //   266: ldc             Lgnu/lists/Pair;.class
                //   268: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //   271: dup            
                //   272: astore          4
                //   274: checkcast       Lgnu/lists/Pair;
                //   277: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
                //   280: putfield        kawa/lib/srfi95$frame0.seq:Ljava/lang/Object;
                //   283: aload_3         /* p */
                //   284: ldc             Lgnu/lists/Pair;.class
                //   286: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //   289: dup            
                //   290: astore          4
                //   292: checkcast       Lgnu/lists/Pair;
                //   295: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
                //   298: invokestatic    kawa/lib/lists.setCdr$Ex:(Lgnu/lists/Pair;Ljava/lang/Object;)V
                //   301: aload_3         /* p */
                //   302: goto            308
                //   305: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
                //   308: areturn        
                //   309: new             Lgnu/mapping/WrongType;
                //   312: dup_x1         
                //   313: swap           
                //   314: ldc             "car"
                //   316: iconst_1       
                //   317: aload           4
                //   319: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //   322: athrow         
                //   323: new             Lgnu/mapping/WrongType;
                //   326: dup_x1         
                //   327: swap           
                //   328: ldc             "set-car!"
                //   330: iconst_1       
                //   331: aload           6
                //   333: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //   336: athrow         
                //   337: new             Lgnu/mapping/WrongType;
                //   340: dup_x1         
                //   341: swap           
                //   342: ldc             "cdr"
                //   344: iconst_1       
                //   345: aload           6
                //   347: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //   350: athrow         
                //   351: new             Lgnu/mapping/WrongType;
                //   354: dup_x1         
                //   355: swap           
                //   356: ldc             "set-car!"
                //   358: iconst_1       
                //   359: aload           6
                //   361: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //   364: athrow         
                //   365: new             Lgnu/mapping/WrongType;
                //   368: dup_x1         
                //   369: swap           
                //   370: ldc             "cdr"
                //   372: iconst_1       
                //   373: aload           6
                //   375: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //   378: athrow         
                //   379: new             Lgnu/mapping/WrongType;
                //   382: dup_x1         
                //   383: swap           
                //   384: ldc             "set-cdr!"
                //   386: iconst_1       
                //   387: aload           6
                //   389: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //   392: athrow         
                //   393: new             Lgnu/mapping/WrongType;
                //   396: dup_x1         
                //   397: swap           
                //   398: ldc             "cdr"
                //   400: iconst_1       
                //   401: aload           4
                //   403: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //   406: athrow         
                //   407: new             Lgnu/mapping/WrongType;
                //   410: dup_x1         
                //   411: swap           
                //   412: ldc             "set-cdr!"
                //   414: iconst_1       
                //   415: aload           4
                //   417: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //   420: athrow         
                //    Exceptions:
                //  Try           Handler
                //  Start  End    Start  End    Type                          
                //  -----  -----  -----  -----  ------------------------------
                //  83     86     309    323    Ljava/lang/ClassCastException;
                //  169    172    323    337    Ljava/lang/ClassCastException;
                //  187    190    337    351    Ljava/lang/ClassCastException;
                //  201    204    351    365    Ljava/lang/ClassCastException;
                //  218    221    365    379    Ljava/lang/ClassCastException;
                //  232    235    379    393    Ljava/lang/ClassCastException;
                //  274    277    393    407    Ljava/lang/ClassCastException;
                //  292    295    407    421    Ljava/lang/ClassCastException;
                // 
                // The error that occurred was:
                // 
                // java.lang.NullPointerException
                // 
                throw new IllegalStateException("An error occurred while decompiling this method.");
            }
        }
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: dup            
        //     4: invokespecial   kawa/lib/srfi95$frame0.<init>:()V
        //     7: astore_3        /* $heapFrame */
        //     8: aload_3         /* $heapFrame */
        //     9: aload_0         /* seq */
        //    10: putfield        kawa/lib/srfi95$frame0.seq:Ljava/lang/Object;
        //    13: aload_3         /* $heapFrame */
        //    14: aload_1         /* isLess */
        //    15: putfield        kawa/lib/srfi95$frame0.less$Qu:Ljava/lang/Object;
        //    18: aload_2         /* key */
        //    19: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //    22: ifeq            31
        //    25: getstatic       kawa/lib/lists.car:Lgnu/expr/GenericProc;
        //    28: goto            34
        //    31: getstatic       kawa/lib/srfi95.identity:Lgnu/expr/ModuleMethod;
        //    34: astore          keyer
        //    36: aload_2         /* key */
        //    37: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //    40: ifeq            229
        //    43: aload_3         /* $heapFrame */
        //    44: getfield        kawa/lib/srfi95$frame0.seq:Ljava/lang/Object;
        //    47: astore          lst
        //    49: aload           lst
        //    51: invokestatic    kawa/lib/lists.isNull:(Ljava/lang/Object;)Z
        //    54: istore          x
        //    56: iload           x
        //    58: ifeq            64
        //    61: goto            141
        //    64: aload           lst
        //    66: ldc             Lgnu/lists/Pair;.class
        //    68: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    71: dup            
        //    72: astore          7
        //    74: checkcast       Lgnu/lists/Pair;
        //    77: getstatic       kawa/standard/Scheme.applyToArgs:Lgnu/kawa/functions/ApplyToArgs;
        //    80: aload_2         /* key */
        //    81: aload           lst
        //    83: ldc             Lgnu/lists/Pair;.class
        //    85: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    88: dup            
        //    89: astore          7
        //    91: checkcast       Lgnu/lists/Pair;
        //    94: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    97: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   100: aload           lst
        //   102: ldc             Lgnu/lists/Pair;.class
        //   104: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   107: dup            
        //   108: astore          7
        //   110: checkcast       Lgnu/lists/Pair;
        //   113: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   116: invokestatic    kawa/lib/lists.cons:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //   119: invokestatic    kawa/lib/lists.setCar$Ex:(Lgnu/lists/Pair;Ljava/lang/Object;)V
        //   122: aload           lst
        //   124: ldc             Lgnu/lists/Pair;.class
        //   126: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   129: dup            
        //   130: astore          7
        //   132: checkcast       Lgnu/lists/Pair;
        //   135: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   138: goto            47
        //   141: aload_3         /* $heapFrame */
        //   142: aload_3         /* $heapFrame */
        //   143: aload           keyer
        //   145: aload_3         /* $heapFrame */
        //   146: getfield        kawa/lib/srfi95$frame0.seq:Ljava/lang/Object;
        //   149: invokestatic    gnu/lists/Sequences.getSize:(Ljava/lang/Object;)I
        //   152: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //   155: invokevirtual   kawa/lib/srfi95$frame0.lambda2step:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   158: putfield        kawa/lib/srfi95$frame0.seq:Ljava/lang/Object;
        //   161: aload_3         /* $heapFrame */
        //   162: getfield        kawa/lib/srfi95$frame0.seq:Ljava/lang/Object;
        //   165: astore          lst
        //   167: aload           lst
        //   169: invokestatic    kawa/lib/lists.isNull:(Ljava/lang/Object;)Z
        //   172: istore          x
        //   174: iload           x
        //   176: ifeq            182
        //   179: goto            222
        //   182: aload           lst
        //   184: ldc             Lgnu/lists/Pair;.class
        //   186: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   189: dup            
        //   190: astore          7
        //   192: checkcast       Lgnu/lists/Pair;
        //   195: aload           lst
        //   197: invokestatic    kawa/lib/lists.cdar:(Ljava/lang/Object;)Ljava/lang/Object;
        //   200: invokestatic    kawa/lib/lists.setCar$Ex:(Lgnu/lists/Pair;Ljava/lang/Object;)V
        //   203: aload           lst
        //   205: ldc             Lgnu/lists/Pair;.class
        //   207: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   210: dup            
        //   211: astore          7
        //   213: checkcast       Lgnu/lists/Pair;
        //   216: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   219: goto            165
        //   222: aload_3         /* $heapFrame */
        //   223: getfield        kawa/lib/srfi95$frame0.seq:Ljava/lang/Object;
        //   226: goto            245
        //   229: aload_3         /* $heapFrame */
        //   230: aload           keyer
        //   232: aload_3         /* $heapFrame */
        //   233: getfield        kawa/lib/srfi95$frame0.seq:Ljava/lang/Object;
        //   236: invokestatic    gnu/lists/Sequences.getSize:(Ljava/lang/Object;)I
        //   239: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //   242: invokevirtual   kawa/lib/srfi95$frame0.lambda2step:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   245: areturn        
        //   246: new             Lgnu/mapping/WrongType;
        //   249: dup_x1         
        //   250: swap           
        //   251: ldc             "set-car!"
        //   253: iconst_1       
        //   254: aload           7
        //   256: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   259: athrow         
        //   260: new             Lgnu/mapping/WrongType;
        //   263: dup_x1         
        //   264: swap           
        //   265: ldc             "car"
        //   267: iconst_1       
        //   268: aload           7
        //   270: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   273: athrow         
        //   274: new             Lgnu/mapping/WrongType;
        //   277: dup_x1         
        //   278: swap           
        //   279: ldc             "car"
        //   281: iconst_1       
        //   282: aload           7
        //   284: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   287: athrow         
        //   288: new             Lgnu/mapping/WrongType;
        //   291: dup_x1         
        //   292: swap           
        //   293: ldc             "cdr"
        //   295: iconst_1       
        //   296: aload           7
        //   298: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   301: athrow         
        //   302: new             Lgnu/mapping/WrongType;
        //   305: dup_x1         
        //   306: swap           
        //   307: ldc             "set-car!"
        //   309: iconst_1       
        //   310: aload           7
        //   312: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   315: athrow         
        //   316: new             Lgnu/mapping/WrongType;
        //   319: dup_x1         
        //   320: swap           
        //   321: ldc             "cdr"
        //   323: iconst_1       
        //   324: aload           7
        //   326: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   329: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  74     77     246    260    Ljava/lang/ClassCastException;
        //  91     94     260    274    Ljava/lang/ClassCastException;
        //  110    113    274    288    Ljava/lang/ClassCastException;
        //  132    135    288    302    Ljava/lang/ClassCastException;
        //  192    195    302    316    Ljava/lang/ClassCastException;
        //  213    216    316    330    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 156 out of bounds for length 156
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
    
    public static Object sort$Ex(final Sequence seq, final Object less$Qu) {
        return sort$Ex(seq, less$Qu, Boolean.FALSE);
    }
    
    public static Object sort$Ex(final Sequence seq, final Object less$Qu, final Object key) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokestatic    kawa/lib/lists.isList:(Ljava/lang/Object;)Z
        //     4: ifeq            190
        //     7: aload_0         /* seq */
        //     8: aload_1         /* less$Qu */
        //     9: aload_2         /* key */
        //    10: invokestatic    kawa/lib/srfi95.$PcSortList:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    13: astore_3        /* ret */
        //    14: aload_3         /* ret */
        //    15: aload_0         /* seq */
        //    16: if_acmpeq       186
        //    19: aload_3         /* ret */
        //    20: astore          crt
        //    22: aload           crt
        //    24: ldc             Lgnu/lists/Pair;.class
        //    26: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    29: dup            
        //    30: astore          5
        //    32: checkcast       Lgnu/lists/Pair;
        //    35: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    38: aload_0         /* seq */
        //    39: if_acmpeq       61
        //    42: aload           crt
        //    44: ldc             Lgnu/lists/Pair;.class
        //    46: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    49: dup            
        //    50: astore          5
        //    52: checkcast       Lgnu/lists/Pair;
        //    55: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    58: goto            20
        //    61: aload           crt
        //    63: ldc             Lgnu/lists/Pair;.class
        //    65: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    68: dup            
        //    69: astore          5
        //    71: checkcast       Lgnu/lists/Pair;
        //    74: aload_3         /* ret */
        //    75: invokestatic    kawa/lib/lists.setCdr$Ex:(Lgnu/lists/Pair;Ljava/lang/Object;)V
        //    78: aload_0         /* seq */
        //    79: dup            
        //    80: astore          6
        //    82: checkcast       Lgnu/lists/Pair;
        //    85: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    88: astore          5
        //    90: aload_0         /* seq */
        //    91: dup            
        //    92: astore          7
        //    94: checkcast       Lgnu/lists/Pair;
        //    97: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   100: astore          scdr
        //   102: aload_0         /* seq */
        //   103: dup            
        //   104: astore          7
        //   106: checkcast       Lgnu/lists/Pair;
        //   109: aload_3         /* ret */
        //   110: ldc             Lgnu/lists/Pair;.class
        //   112: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   115: dup            
        //   116: astore          7
        //   118: checkcast       Lgnu/lists/Pair;
        //   121: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   124: invokestatic    kawa/lib/lists.setCar$Ex:(Lgnu/lists/Pair;Ljava/lang/Object;)V
        //   127: aload_0         /* seq */
        //   128: dup            
        //   129: astore          7
        //   131: checkcast       Lgnu/lists/Pair;
        //   134: aload_3         /* ret */
        //   135: ldc             Lgnu/lists/Pair;.class
        //   137: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   140: dup            
        //   141: astore          7
        //   143: checkcast       Lgnu/lists/Pair;
        //   146: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   149: invokestatic    kawa/lib/lists.setCdr$Ex:(Lgnu/lists/Pair;Ljava/lang/Object;)V
        //   152: aload_3         /* ret */
        //   153: ldc             Lgnu/lists/Pair;.class
        //   155: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   158: dup            
        //   159: astore          7
        //   161: checkcast       Lgnu/lists/Pair;
        //   164: aload           scar
        //   166: invokestatic    kawa/lib/lists.setCar$Ex:(Lgnu/lists/Pair;Ljava/lang/Object;)V
        //   169: aload_3         /* ret */
        //   170: ldc             Lgnu/lists/Pair;.class
        //   172: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   175: dup            
        //   176: astore          7
        //   178: checkcast       Lgnu/lists/Pair;
        //   181: aload           scdr
        //   183: invokestatic    kawa/lib/lists.setCdr$Ex:(Lgnu/lists/Pair;Ljava/lang/Object;)V
        //   186: aload_0         /* seq */
        //   187: goto            196
        //   190: aload_0         /* seq */
        //   191: aload_1         /* less$Qu */
        //   192: aload_2         /* key */
        //   193: invokestatic    kawa/lib/srfi95.$PcVectorSort$Ex:(Lgnu/lists/Sequence;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   196: areturn        
        //   197: new             Lgnu/mapping/WrongType;
        //   200: dup_x1         
        //   201: swap           
        //   202: ldc             "cdr"
        //   204: iconst_1       
        //   205: aload           5
        //   207: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   210: athrow         
        //   211: new             Lgnu/mapping/WrongType;
        //   214: dup_x1         
        //   215: swap           
        //   216: ldc             "cdr"
        //   218: iconst_1       
        //   219: aload           5
        //   221: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   224: athrow         
        //   225: new             Lgnu/mapping/WrongType;
        //   228: dup_x1         
        //   229: swap           
        //   230: ldc             "set-cdr!"
        //   232: iconst_1       
        //   233: aload           5
        //   235: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   238: athrow         
        //   239: new             Lgnu/mapping/WrongType;
        //   242: dup_x1         
        //   243: swap           
        //   244: ldc             "car"
        //   246: iconst_1       
        //   247: aload           6
        //   249: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   252: athrow         
        //   253: new             Lgnu/mapping/WrongType;
        //   256: dup_x1         
        //   257: swap           
        //   258: ldc             "cdr"
        //   260: iconst_1       
        //   261: aload           7
        //   263: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   266: athrow         
        //   267: new             Lgnu/mapping/WrongType;
        //   270: dup_x1         
        //   271: swap           
        //   272: ldc             "set-car!"
        //   274: iconst_1       
        //   275: aload           7
        //   277: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   280: athrow         
        //   281: new             Lgnu/mapping/WrongType;
        //   284: dup_x1         
        //   285: swap           
        //   286: ldc             "car"
        //   288: iconst_1       
        //   289: aload           7
        //   291: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   294: athrow         
        //   295: new             Lgnu/mapping/WrongType;
        //   298: dup_x1         
        //   299: swap           
        //   300: ldc             "set-cdr!"
        //   302: iconst_1       
        //   303: aload           7
        //   305: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   308: athrow         
        //   309: new             Lgnu/mapping/WrongType;
        //   312: dup_x1         
        //   313: swap           
        //   314: ldc             "cdr"
        //   316: iconst_1       
        //   317: aload           7
        //   319: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   322: athrow         
        //   323: new             Lgnu/mapping/WrongType;
        //   326: dup_x1         
        //   327: swap           
        //   328: ldc             "set-car!"
        //   330: iconst_1       
        //   331: aload           7
        //   333: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   336: athrow         
        //   337: new             Lgnu/mapping/WrongType;
        //   340: dup_x1         
        //   341: swap           
        //   342: ldc             "set-cdr!"
        //   344: iconst_1       
        //   345: aload           7
        //   347: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   350: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  32     35     197    211    Ljava/lang/ClassCastException;
        //  52     55     211    225    Ljava/lang/ClassCastException;
        //  71     74     225    239    Ljava/lang/ClassCastException;
        //  82     85     239    253    Ljava/lang/ClassCastException;
        //  94     97     253    267    Ljava/lang/ClassCastException;
        //  106    109    267    281    Ljava/lang/ClassCastException;
        //  118    121    281    295    Ljava/lang/ClassCastException;
        //  131    134    295    309    Ljava/lang/ClassCastException;
        //  143    146    309    323    Ljava/lang/ClassCastException;
        //  161    164    323    337    Ljava/lang/ClassCastException;
        //  178    181    337    351    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public static Object $PcVectorSort$Ex(final Sequence seq, final Object less$Qu, final Object key) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokestatic    kawa/lib/srfi95.rank$Mn1Array$To$List:(Lgnu/lists/Sequence;)Ljava/lang/Object;
        //     4: aload_1         /* less$Qu */
        //     5: aload_2         /* key */
        //     6: invokestatic    kawa/lib/srfi95.$PcSortList:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //     9: getstatic       kawa/lib/srfi95.Lit3:Lgnu/math/IntNum;
        //    12: astore          4
        //    14: astore_3        /* sorted */
        //    15: aload_3         /* sorted */
        //    16: invokestatic    kawa/lib/lists.isNull:(Ljava/lang/Object;)Z
        //    19: ifne            82
        //    22: getstatic       gnu/kawa/functions/Setter.setter:Lgnu/kawa/functions/Setter;
        //    25: aload_0         /* seq */
        //    26: invokevirtual   gnu/mapping/Procedure.apply1:(Ljava/lang/Object;)Ljava/lang/Object;
        //    29: ldc             Lgnu/mapping/Procedure;.class
        //    31: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    34: checkcast       Lgnu/mapping/Procedure;
        //    37: aload           i
        //    39: aload_3         /* sorted */
        //    40: ldc             Lgnu/lists/Pair;.class
        //    42: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    45: dup            
        //    46: astore          5
        //    48: checkcast       Lgnu/lists/Pair;
        //    51: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    54: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    57: pop            
        //    58: aload_3         /* sorted */
        //    59: ldc             Lgnu/lists/Pair;.class
        //    61: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    64: dup            
        //    65: astore          5
        //    67: checkcast       Lgnu/lists/Pair;
        //    70: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    73: aload           i
        //    75: iconst_1       
        //    76: invokestatic    gnu/math/IntNum.add:(Lgnu/math/IntNum;I)Lgnu/math/IntNum;
        //    79: goto            12
        //    82: aload_0         /* seq */
        //    83: areturn        
        //    84: new             Lgnu/mapping/WrongType;
        //    87: dup_x1         
        //    88: swap           
        //    89: ldc             "car"
        //    91: iconst_1       
        //    92: aload           5
        //    94: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //    97: athrow         
        //    98: new             Lgnu/mapping/WrongType;
        //   101: dup_x1         
        //   102: swap           
        //   103: ldc             "cdr"
        //   105: iconst_1       
        //   106: aload           5
        //   108: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   111: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  48     51     84     98     Ljava/lang/ClassCastException;
        //  67     70     98     112    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    static Object rank$Mn1Array$To$List(final Sequence seq) {
        final int n = seq.size() - 1;
        final EmptyList empty = LList.Empty;
        Object lst = null;
        for (int idx = n; idx >= 0; --idx) {
            lst = lists.cons(seq.get(idx), lst);
        }
        return lst;
    }
    
    public static FVector $PcSortVector(final Sequence seq, final Object less$Qu) {
        return $PcSortVector(seq, less$Qu, Boolean.FALSE);
    }
    
    public static FVector $PcSortVector(final Sequence seq, final Object less$Qu, final Object key) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokeinterface gnu/lists/Sequence.size:()I
        //     6: istore_3        /* dim */
        //     7: iload_3         /* dim */
        //     8: invokestatic    kawa/lib/vectors.makeVector:(I)Lgnu/lists/FVector;
        //    11: astore          newra
        //    13: aload_0         /* seq */
        //    14: invokestatic    kawa/lib/srfi95.rank$Mn1Array$To$List:(Lgnu/lists/Sequence;)Ljava/lang/Object;
        //    17: aload_1         /* less$Qu */
        //    18: aload_2         /* key */
        //    19: invokestatic    kawa/lib/srfi95.$PcSortList:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    22: getstatic       kawa/lib/srfi95.Lit3:Lgnu/math/IntNum;
        //    25: astore          6
        //    27: astore          sorted
        //    29: aload           sorted
        //    31: invokestatic    kawa/lib/lists.isNull:(Ljava/lang/Object;)Z
        //    34: ifne            91
        //    37: aload           newra
        //    39: aload           i
        //    41: dup            
        //    42: astore          7
        //    44: invokevirtual   java/lang/Number.intValue:()I
        //    47: aload           sorted
        //    49: ldc             Lgnu/lists/Pair;.class
        //    51: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    54: dup            
        //    55: astore          7
        //    57: checkcast       Lgnu/lists/Pair;
        //    60: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    63: invokestatic    kawa/lib/vectors.vectorSet$Ex:(Lgnu/lists/FVector;ILjava/lang/Object;)V
        //    66: aload           sorted
        //    68: ldc             Lgnu/lists/Pair;.class
        //    70: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    73: dup            
        //    74: astore          7
        //    76: checkcast       Lgnu/lists/Pair;
        //    79: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    82: aload           i
        //    84: iconst_1       
        //    85: invokestatic    gnu/math/IntNum.add:(Lgnu/math/IntNum;I)Lgnu/math/IntNum;
        //    88: goto            25
        //    91: aload           newra
        //    93: areturn        
        //    94: new             Lgnu/mapping/WrongType;
        //    97: dup_x1         
        //    98: swap           
        //    99: ldc             "vector-set!"
        //   101: iconst_2       
        //   102: aload           7
        //   104: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   107: athrow         
        //   108: new             Lgnu/mapping/WrongType;
        //   111: dup_x1         
        //   112: swap           
        //   113: ldc             "car"
        //   115: iconst_1       
        //   116: aload           7
        //   118: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   121: athrow         
        //   122: new             Lgnu/mapping/WrongType;
        //   125: dup_x1         
        //   126: swap           
        //   127: ldc             "cdr"
        //   129: iconst_1       
        //   130: aload           7
        //   132: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   135: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  44     47     94     108    Ljava/lang/ClassCastException;
        //  57     60     108    122    Ljava/lang/ClassCastException;
        //  76     79     122    136    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public static Object sort(final Sequence seq, final Object less$Qu) {
        return sort(seq, less$Qu, Boolean.FALSE);
    }
    
    public static Object sort(final Sequence seq, final Object less$Qu, final Object key) {
        return lists.isList(seq) ? $PcSortList(append.append$V(new Object[] { seq, LList.Empty }), less$Qu, key) : $PcSortVector(seq, less$Qu, key);
    }
    
    static {
        Lit12 = Symbol.valueOf("sort");
        Lit11 = Symbol.valueOf("%sort-vector");
        Lit10 = Symbol.valueOf("%vector-sort!");
        Lit9 = Symbol.valueOf("sort!");
        Lit8 = Symbol.valueOf("%sort-list");
        Lit7 = Symbol.valueOf("merge!");
        Lit6 = Symbol.valueOf("merge");
        Lit5 = Symbol.valueOf("sorted?");
        Lit4 = Symbol.valueOf("identity");
        Lit3 = IntNum.valueOf(0);
        Lit2 = IntNum.valueOf(1);
        Lit1 = IntNum.valueOf(2);
        Lit0 = IntNum.valueOf(-1);
        srfi95.$instance = new srfi95();
        final srfi95 $instance = srfi95.$instance;
        identity = new ModuleMethod($instance, 1, srfi95.Lit4, 4097);
        sorted$Qu = new ModuleMethod($instance, 2, srfi95.Lit5, 12290);
        merge = new ModuleMethod($instance, 4, srfi95.Lit6, 16387);
        merge$Ex = new ModuleMethod($instance, 6, srfi95.Lit7, 16387);
        $Pcsort$Mnlist = new ModuleMethod($instance, 8, srfi95.Lit8, 12291);
        sort$Ex = new ModuleMethod($instance, 9, srfi95.Lit9, 12290);
        $Pcvector$Mnsort$Ex = new ModuleMethod($instance, 11, srfi95.Lit10, 12291);
        $Pcsort$Mnvector = new ModuleMethod($instance, 12, srfi95.Lit11, 12290);
        sort = new ModuleMethod($instance, 14, srfi95.Lit12, 12290);
        $runBody$();
    }
    
    public srfi95() {
        ModuleInfo.register(this);
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
    public int match2(final ModuleMethod proc, final Object arg1, final Object arg2, final CallContext ctx) {
        switch (proc.selector) {
            case 14: {
                final Object force = Promise.force(arg1, Sequence.class);
                if (!(force instanceof Sequence)) {
                    return -786431;
                }
                ctx.value1 = force;
                ctx.value2 = arg2;
                ctx.proc = proc;
                ctx.pc = 2;
                return 0;
            }
            case 12: {
                final Object force2 = Promise.force(arg1, Sequence.class);
                if (!(force2 instanceof Sequence)) {
                    return -786431;
                }
                ctx.value1 = force2;
                ctx.value2 = arg2;
                ctx.proc = proc;
                ctx.pc = 2;
                return 0;
            }
            case 9: {
                final Object force3 = Promise.force(arg1, Sequence.class);
                if (!(force3 instanceof Sequence)) {
                    return -786431;
                }
                ctx.value1 = force3;
                ctx.value2 = arg2;
                ctx.proc = proc;
                ctx.pc = 2;
                return 0;
            }
            case 2: {
                ctx.value1 = arg1;
                ctx.value2 = arg2;
                ctx.proc = proc;
                ctx.pc = 2;
                return 0;
            }
            default: {
                return super.match2(proc, arg1, arg2, ctx);
            }
        }
    }
    
    @Override
    public int match3(final ModuleMethod proc, final Object arg1, final Object arg2, final Object arg3, final CallContext ctx) {
        switch (proc.selector) {
            case 14: {
                final Object force = Promise.force(arg1, Sequence.class);
                if (!(force instanceof Sequence)) {
                    return -786431;
                }
                ctx.value1 = force;
                ctx.value2 = arg2;
                ctx.value3 = arg3;
                ctx.proc = proc;
                ctx.pc = 3;
                return 0;
            }
            case 12: {
                final Object force2 = Promise.force(arg1, Sequence.class);
                if (!(force2 instanceof Sequence)) {
                    return -786431;
                }
                ctx.value1 = force2;
                ctx.value2 = arg2;
                ctx.value3 = arg3;
                ctx.proc = proc;
                ctx.pc = 3;
                return 0;
            }
            case 11: {
                final Object force3 = Promise.force(arg1, Sequence.class);
                if (!(force3 instanceof Sequence)) {
                    return -786431;
                }
                ctx.value1 = force3;
                ctx.value2 = arg2;
                ctx.value3 = arg3;
                ctx.proc = proc;
                ctx.pc = 3;
                return 0;
            }
            case 9: {
                final Object force4 = Promise.force(arg1, Sequence.class);
                if (!(force4 instanceof Sequence)) {
                    return -786431;
                }
                ctx.value1 = force4;
                ctx.value2 = arg2;
                ctx.value3 = arg3;
                ctx.proc = proc;
                ctx.pc = 3;
                return 0;
            }
            case 8: {
                ctx.value1 = arg1;
                ctx.value2 = arg2;
                ctx.value3 = arg3;
                ctx.proc = proc;
                ctx.pc = 3;
                return 0;
            }
            case 6: {
                ctx.value1 = arg1;
                ctx.value2 = arg2;
                ctx.value3 = arg3;
                ctx.proc = proc;
                ctx.pc = 3;
                return 0;
            }
            case 4: {
                ctx.value1 = arg1;
                ctx.value2 = arg2;
                ctx.value3 = arg3;
                ctx.proc = proc;
                ctx.pc = 3;
                return 0;
            }
            case 2: {
                ctx.value1 = arg1;
                ctx.value2 = arg2;
                ctx.value3 = arg3;
                ctx.proc = proc;
                ctx.pc = 3;
                return 0;
            }
            default: {
                return super.match3(proc, arg1, arg2, arg3, ctx);
            }
        }
    }
    
    @Override
    public int match4(final ModuleMethod proc, final Object arg1, final Object arg2, final Object arg3, final Object arg4, final CallContext ctx) {
        switch (proc.selector) {
            case 6: {
                ctx.value1 = arg1;
                ctx.value2 = arg2;
                ctx.value3 = arg3;
                ctx.value4 = arg4;
                ctx.proc = proc;
                ctx.pc = 4;
                return 0;
            }
            case 4: {
                ctx.value1 = arg1;
                ctx.value2 = arg2;
                ctx.value3 = arg3;
                ctx.value4 = arg4;
                ctx.proc = proc;
                ctx.pc = 4;
                return 0;
            }
            default: {
                return super.match4(proc, arg1, arg2, arg3, arg4, ctx);
            }
        }
    }
    
    @Override
    public void apply(final CallContext callContext) {
        final int pc = callContext.pc;
        ModuleMethod.applyError();
    }
    
    @Override
    public Object apply1(final ModuleMethod method, final Object o) {
        if (method.selector == 1) {
            return identity(o);
        }
        return super.apply1(method, o);
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
        //                2: 48
        //                9: 54
        //               12: 68
        //               14: 82
        //          default: 96
        //        }
        //    48: aload_2        
        //    49: aload_3        
        //    50: invokestatic    kawa/lib/srfi95.isSorted:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    53: areturn        
        //    54: aload_2        
        //    55: ldc             Lgnu/lists/Sequence;.class
        //    57: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    60: checkcast       Lgnu/lists/Sequence;
        //    63: aload_3        
        //    64: invokestatic    kawa/lib/srfi95.sort$Ex:(Lgnu/lists/Sequence;Ljava/lang/Object;)Ljava/lang/Object;
        //    67: areturn        
        //    68: aload_2        
        //    69: ldc             Lgnu/lists/Sequence;.class
        //    71: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    74: checkcast       Lgnu/lists/Sequence;
        //    77: aload_3        
        //    78: invokestatic    kawa/lib/srfi95.$PcSortVector:(Lgnu/lists/Sequence;Ljava/lang/Object;)Lgnu/lists/FVector;
        //    81: areturn        
        //    82: aload_2        
        //    83: ldc             Lgnu/lists/Sequence;.class
        //    85: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    88: checkcast       Lgnu/lists/Sequence;
        //    91: aload_3        
        //    92: invokestatic    kawa/lib/srfi95.sort:(Lgnu/lists/Sequence;Ljava/lang/Object;)Ljava/lang/Object;
        //    95: areturn        
        //    96: aload_0        
        //    97: aload_1        
        //    98: aload_2        
        //    99: aload_3        
        //   100: invokespecial   gnu/expr/ModuleBody.apply2:(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   103: areturn        
        //   104: new             Lgnu/mapping/WrongType;
        //   107: dup_x1         
        //   108: swap           
        //   109: ldc_w           "sort!"
        //   112: iconst_1       
        //   113: aload_2        
        //   114: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   117: athrow         
        //   118: new             Lgnu/mapping/WrongType;
        //   121: dup_x1         
        //   122: swap           
        //   123: ldc_w           "%sort-vector"
        //   126: iconst_1       
        //   127: aload_2        
        //   128: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   131: athrow         
        //   132: new             Lgnu/mapping/WrongType;
        //   135: dup_x1         
        //   136: swap           
        //   137: ldc_w           "sort"
        //   140: iconst_1       
        //   141: aload_2        
        //   142: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   145: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  60     63     104    118    Ljava/lang/ClassCastException;
        //  74     77     118    132    Ljava/lang/ClassCastException;
        //  88     91     132    146    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 58 out of bounds for length 58
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
        //     4: tableswitch {
        //                4: 72
        //                5: 168
        //                6: 80
        //                7: 168
        //                8: 88
        //                9: 168
        //               10: 96
        //               11: 104
        //               12: 168
        //               13: 120
        //               14: 136
        //               15: 168
        //               16: 152
        //          default: 168
        //        }
        //    72: aload_2        
        //    73: aload_3        
        //    74: aload           4
        //    76: invokestatic    kawa/lib/srfi95.isSorted:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    79: areturn        
        //    80: aload_2        
        //    81: aload_3        
        //    82: aload           4
        //    84: invokestatic    kawa/lib/srfi95.merge:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    87: areturn        
        //    88: aload_2        
        //    89: aload_3        
        //    90: aload           4
        //    92: invokestatic    kawa/lib/srfi95.merge$Ex:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    95: areturn        
        //    96: aload_2        
        //    97: aload_3        
        //    98: aload           4
        //   100: invokestatic    kawa/lib/srfi95.$PcSortList:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   103: areturn        
        //   104: aload_2        
        //   105: ldc             Lgnu/lists/Sequence;.class
        //   107: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   110: checkcast       Lgnu/lists/Sequence;
        //   113: aload_3        
        //   114: aload           4
        //   116: invokestatic    kawa/lib/srfi95.sort$Ex:(Lgnu/lists/Sequence;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   119: areturn        
        //   120: aload_2        
        //   121: ldc             Lgnu/lists/Sequence;.class
        //   123: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   126: checkcast       Lgnu/lists/Sequence;
        //   129: aload_3        
        //   130: aload           4
        //   132: invokestatic    kawa/lib/srfi95.$PcVectorSort$Ex:(Lgnu/lists/Sequence;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   135: areturn        
        //   136: aload_2        
        //   137: ldc             Lgnu/lists/Sequence;.class
        //   139: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   142: checkcast       Lgnu/lists/Sequence;
        //   145: aload_3        
        //   146: aload           4
        //   148: invokestatic    kawa/lib/srfi95.$PcSortVector:(Lgnu/lists/Sequence;Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/FVector;
        //   151: areturn        
        //   152: aload_2        
        //   153: ldc             Lgnu/lists/Sequence;.class
        //   155: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   158: checkcast       Lgnu/lists/Sequence;
        //   161: aload_3        
        //   162: aload           4
        //   164: invokestatic    kawa/lib/srfi95.sort:(Lgnu/lists/Sequence;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   167: areturn        
        //   168: aload_0        
        //   169: aload_1        
        //   170: aload_2        
        //   171: aload_3        
        //   172: aload           4
        //   174: invokespecial   gnu/expr/ModuleBody.apply3:(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   177: areturn        
        //   178: new             Lgnu/mapping/WrongType;
        //   181: dup_x1         
        //   182: swap           
        //   183: ldc_w           "sort!"
        //   186: iconst_1       
        //   187: aload_2        
        //   188: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   191: athrow         
        //   192: new             Lgnu/mapping/WrongType;
        //   195: dup_x1         
        //   196: swap           
        //   197: ldc_w           "%vector-sort!"
        //   200: iconst_1       
        //   201: aload_2        
        //   202: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   205: athrow         
        //   206: new             Lgnu/mapping/WrongType;
        //   209: dup_x1         
        //   210: swap           
        //   211: ldc_w           "%sort-vector"
        //   214: iconst_1       
        //   215: aload_2        
        //   216: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   219: athrow         
        //   220: new             Lgnu/mapping/WrongType;
        //   223: dup_x1         
        //   224: swap           
        //   225: ldc_w           "sort"
        //   228: iconst_1       
        //   229: aload_2        
        //   230: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   233: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  110    113    178    192    Ljava/lang/ClassCastException;
        //  126    129    192    206    Ljava/lang/ClassCastException;
        //  142    145    206    220    Ljava/lang/ClassCastException;
        //  158    161    220    234    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 94 out of bounds for length 94
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
    public Object apply4(final ModuleMethod method, final Object arg1, final Object arg2, final Object arg3, final Object arg4) {
        switch (method.selector) {
            case 4: {
                return merge(arg1, arg2, arg3, arg4);
            }
            case 6: {
                return merge$Ex(arg1, arg2, arg3, arg4);
            }
            default: {
                return super.apply4(method, arg1, arg2, arg3, arg4);
            }
        }
    }
}
