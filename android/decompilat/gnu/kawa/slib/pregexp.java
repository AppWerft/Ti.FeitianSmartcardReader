// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.slib;

import gnu.expr.ModuleInfo;
import gnu.mapping.Symbol;
import gnu.lists.LList;
import kawa.lib.strings;
import gnu.mapping.Procedure;
import gnu.mapping.WrongType;
import kawa.lib.lists;
import gnu.mapping.Promise;
import gnu.lists.Pair;
import gnu.lists.Consumer;
import kawa.lib.exceptions;
import gnu.mapping.CallContext;
import gnu.lists.PairWithPosition;
import gnu.text.Char;
import gnu.mapping.SimpleSymbol;
import gnu.expr.ModuleMethod;
import kawa.SourceType;
import gnu.math.IntNum;
import gnu.expr.ModuleBody;

public class pregexp extends ModuleBody
{
    public static IntNum $Stpregexp$Mnversion$St;
    @SourceType("character")
    public static int $Stpregexp$Mncomment$Mnchar$St;
    public static int $Stpregexp$Mnnul$Mnchar$Mnint$St;
    @SourceType("character")
    public static int $Stpregexp$Mnreturn$Mnchar$St;
    @SourceType("character")
    public static int $Stpregexp$Mntab$Mnchar$St;
    public static Object $Stpregexp$Mnspace$Mnsensitive$Qu$St;
    public static final ModuleMethod pregexp$Mnreverse$Ex;
    public static ModuleMethod pregexp$Mnerror;
    public static final ModuleMethod pregexp$Mnread$Mnpattern;
    public static final ModuleMethod pregexp$Mnread$Mnbranch;
    public static final ModuleMethod pregexp$Mnread$Mnpiece;
    public static final ModuleMethod pregexp$Mnread$Mnescaped$Mnnumber;
    public static final ModuleMethod pregexp$Mnread$Mnescaped$Mnchar;
    public static final ModuleMethod pregexp$Mnread$Mnposix$Mnchar$Mnclass;
    public static final ModuleMethod pregexp$Mnread$Mncluster$Mntype;
    public static final ModuleMethod pregexp$Mnread$Mnsubpattern;
    public static final ModuleMethod pregexp$Mnwrap$Mnquantifier$Mnif$Mnany;
    public static final ModuleMethod pregexp$Mnread$Mnnums;
    public static final ModuleMethod pregexp$Mninvert$Mnchar$Mnlist;
    public static final ModuleMethod pregexp$Mnread$Mnchar$Mnlist;
    public static final ModuleMethod pregexp$Mnstring$Mnmatch;
    public static final ModuleMethod pregexp$Mnchar$Mnword$Qu;
    public static final ModuleMethod pregexp$Mnat$Mnword$Mnboundary$Qu;
    public static final ModuleMethod pregexp$Mncheck$Mnif$Mnin$Mnchar$Mnclass$Qu;
    public static final ModuleMethod pregexp$Mnlist$Mnref;
    public static final ModuleMethod pregexp$Mnmake$Mnbackref$Mnlist;
    public static final ModuleMethod pregexp$Mnmatch$Mnpositions$Mnaux;
    public static final ModuleMethod pregexp$Mnreplace$Mnaux;
    public static final ModuleMethod pregexp;
    public static final ModuleMethod pregexp$Mnmatch$Mnpositions;
    public static final ModuleMethod pregexp$Mnmatch;
    public static final ModuleMethod pregexp$Mnsplit;
    public static final ModuleMethod pregexp$Mnreplace;
    public static final ModuleMethod pregexp$Mnreplace$St;
    public static final ModuleMethod pregexp$Mnquote;
    static final IntNum Lit0;
    static final SimpleSymbol Lit1;
    static final SimpleSymbol Lit2;
    static final IntNum Lit3;
    static final SimpleSymbol Lit4;
    static final SimpleSymbol Lit5;
    static final SimpleSymbol Lit6;
    static final SimpleSymbol Lit7;
    static final SimpleSymbol Lit8;
    static final SimpleSymbol Lit9;
    static final Char Lit10;
    static final IntNum Lit11;
    static final SimpleSymbol Lit12;
    static final SimpleSymbol Lit13;
    static final SimpleSymbol Lit14;
    static final PairWithPosition Lit15;
    static final PairWithPosition Lit16;
    static final SimpleSymbol Lit17;
    static final SimpleSymbol Lit18;
    static final SimpleSymbol Lit19;
    static final PairWithPosition Lit20;
    static final SimpleSymbol Lit21;
    static final Char Lit22;
    static final Char Lit23;
    static final SimpleSymbol Lit24;
    static final PairWithPosition Lit25;
    static final PairWithPosition Lit26;
    static final PairWithPosition Lit27;
    static final PairWithPosition Lit28;
    static final PairWithPosition Lit29;
    static final SimpleSymbol Lit30;
    static final SimpleSymbol Lit31;
    static final SimpleSymbol Lit32;
    static final PairWithPosition Lit33;
    static final SimpleSymbol Lit34;
    static final SimpleSymbol Lit35;
    static final SimpleSymbol Lit36;
    static final SimpleSymbol Lit37;
    static final SimpleSymbol Lit38;
    static final SimpleSymbol Lit39;
    static final IntNum Lit40;
    static final SimpleSymbol Lit41;
    static final SimpleSymbol Lit42;
    static final SimpleSymbol Lit43;
    static final SimpleSymbol Lit44;
    static final SimpleSymbol Lit45;
    static final SimpleSymbol Lit46;
    static final SimpleSymbol Lit47;
    static final SimpleSymbol Lit48;
    static final SimpleSymbol Lit49;
    static final SimpleSymbol Lit50;
    static final SimpleSymbol Lit51;
    static final SimpleSymbol Lit52;
    static final SimpleSymbol Lit53;
    static final SimpleSymbol Lit54;
    static final SimpleSymbol Lit55;
    static final SimpleSymbol Lit56;
    static final SimpleSymbol Lit57;
    static final SimpleSymbol Lit58;
    static final SimpleSymbol Lit59;
    static final SimpleSymbol Lit60;
    static final SimpleSymbol Lit61;
    static final ModuleMethod lambda$Fn1;
    static final SimpleSymbol Lit62;
    static final SimpleSymbol Lit63;
    static final PairWithPosition Lit64;
    static final ModuleMethod lambda$Fn4;
    static final SimpleSymbol Lit65;
    static final ModuleMethod lambda$Fn5;
    static final SimpleSymbol Lit66;
    static final ModuleMethod lambda$Fn9;
    static final SimpleSymbol Lit67;
    static final ModuleMethod lambda$Fn10;
    static final SimpleSymbol Lit68;
    static final ModuleMethod lambda$Fn11;
    static final SimpleSymbol Lit69;
    static final SimpleSymbol Lit70;
    static final SimpleSymbol Lit71;
    static final SimpleSymbol Lit72;
    static final PairWithPosition Lit73;
    static final Char Lit74;
    public static pregexp $instance;
    
    private static void $runBody$() {
        final CallContext $ctx;
        final Consumer $result = ($ctx = CallContext.getInstance()).consumer;
        gnu.kawa.slib.pregexp.$Stpregexp$Mnversion$St = gnu.kawa.slib.pregexp.Lit0;
        gnu.kawa.slib.pregexp.$Stpregexp$Mncomment$Mnchar$St = 59;
        gnu.kawa.slib.pregexp.$Stpregexp$Mnnul$Mnchar$Mnint$St = 97 - 97;
        gnu.kawa.slib.pregexp.$Stpregexp$Mnreturn$Mnchar$St = 13 + gnu.kawa.slib.pregexp.$Stpregexp$Mnnul$Mnchar$Mnint$St;
        gnu.kawa.slib.pregexp.$Stpregexp$Mntab$Mnchar$St = 9 + gnu.kawa.slib.pregexp.$Stpregexp$Mnnul$Mnchar$Mnint$St;
        gnu.kawa.slib.pregexp.$Stpregexp$Mnspace$Mnsensitive$Qu$St = Boolean.TRUE;
        gnu.kawa.slib.pregexp.pregexp$Mnerror = exceptions.error;
    }
    
    public static Object pregexpReverse$Ex(final Object s) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
        //     4: astore_2       
        //     5: astore_1        /* s */
        //     6: aload_1         /* s */
        //     7: invokestatic    kawa/lib/lists.isNull:(Ljava/lang/Object;)Z
        //    10: ifeq            17
        //    13: aload_2         /* r */
        //    14: goto            54
        //    17: aload_1         /* s */
        //    18: ldc             Lgnu/lists/Pair;.class
        //    20: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    23: dup            
        //    24: astore          4
        //    26: checkcast       Lgnu/lists/Pair;
        //    29: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    32: astore_3        /* d */
        //    33: aload_1         /* s */
        //    34: ldc             Lgnu/lists/Pair;.class
        //    36: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    39: dup            
        //    40: astore          4
        //    42: checkcast       Lgnu/lists/Pair;
        //    45: aload_2         /* r */
        //    46: invokestatic    kawa/lib/lists.setCdr$Ex:(Lgnu/lists/Pair;Ljava/lang/Object;)V
        //    49: aload_3         /* d */
        //    50: aload_1         /* s */
        //    51: goto            4
        //    54: areturn        
        //    55: new             Lgnu/mapping/WrongType;
        //    58: dup_x1         
        //    59: swap           
        //    60: ldc             "cdr"
        //    62: iconst_1       
        //    63: aload           4
        //    65: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //    68: athrow         
        //    69: new             Lgnu/mapping/WrongType;
        //    72: dup_x1         
        //    73: swap           
        //    74: ldc             "set-cdr!"
        //    76: iconst_1       
        //    77: aload           4
        //    79: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //    82: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  26     29     55     69     Ljava/lang/ClassCastException;
        //  42     45     69     83     Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public static Object pregexpReadPattern(final Object s, final Object i, final Object n) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: aload_2         /* n */
        //     2: invokestatic    gnu/kawa/functions/NumberCompare.$Gr$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //     5: ifeq            27
        //     8: getstatic       gnu/kawa/slib/pregexp.Lit1:Lgnu/mapping/SimpleSymbol;
        //    11: getstatic       gnu/kawa/slib/pregexp.Lit2:Lgnu/mapping/SimpleSymbol;
        //    14: invokestatic    gnu/lists/LList.list1:(Ljava/lang/Object;)Lgnu/lists/Pair;
        //    17: invokestatic    gnu/lists/LList.list2:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //    20: aload_1         /* i */
        //    21: invokestatic    gnu/lists/LList.list2:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //    24: goto            190
        //    27: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
        //    30: aload_1         /* i */
        //    31: astore          4
        //    33: astore_3        /* branches */
        //    34: aload           i
        //    36: aload_2         /* n */
        //    37: invokestatic    gnu/kawa/functions/NumberCompare.$Gr$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //    40: istore          x
        //    42: iload           x
        //    44: ifeq            55
        //    47: iload           x
        //    49: ifeq            107
        //    52: goto            89
        //    55: aload_0         /* s */
        //    56: ldc             Ljava/lang/CharSequence;.class
        //    58: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    61: dup            
        //    62: astore          6
        //    64: checkcast       Ljava/lang/CharSequence;
        //    67: aload           i
        //    69: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //    72: dup            
        //    73: astore          6
        //    75: checkcast       Ljava/lang/Number;
        //    78: invokevirtual   java/lang/Number.intValue:()I
        //    81: invokestatic    kawa/lib/strings.stringRef:(Ljava/lang/CharSequence;I)I
        //    84: bipush          41
        //    86: if_icmpne       107
        //    89: getstatic       gnu/kawa/slib/pregexp.Lit1:Lgnu/mapping/SimpleSymbol;
        //    92: aload_3         /* branches */
        //    93: invokestatic    gnu/kawa/slib/pregexp.pregexpReverse$Ex:(Ljava/lang/Object;)Ljava/lang/Object;
        //    96: invokestatic    kawa/lib/lists.cons:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //    99: aload           i
        //   101: invokestatic    gnu/lists/LList.list2:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //   104: goto            190
        //   107: aload_0         /* s */
        //   108: aload_0         /* s */
        //   109: ldc             Ljava/lang/CharSequence;.class
        //   111: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   114: dup            
        //   115: astore          7
        //   117: checkcast       Ljava/lang/CharSequence;
        //   120: aload           i
        //   122: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   125: dup            
        //   126: astore          7
        //   128: checkcast       Ljava/lang/Number;
        //   131: invokevirtual   java/lang/Number.intValue:()I
        //   134: invokestatic    kawa/lib/strings.stringRef:(Ljava/lang/CharSequence;I)I
        //   137: bipush          124
        //   139: if_icmpne       154
        //   142: iconst_1       
        //   143: aload           i
        //   145: getstatic       gnu/kawa/slib/pregexp.Lit3:Lgnu/math/IntNum;
        //   148: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   151: goto            156
        //   154: aload           i
        //   156: aload_2         /* n */
        //   157: invokestatic    gnu/kawa/slib/pregexp.pregexpReadBranch:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   160: astore          vv
        //   162: aload           vv
        //   164: ldc             Lgnu/lists/Pair;.class
        //   166: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   169: dup            
        //   170: astore          7
        //   172: checkcast       Lgnu/lists/Pair;
        //   175: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   178: aload_3         /* branches */
        //   179: invokestatic    kawa/lib/lists.cons:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //   182: aload           vv
        //   184: invokestatic    kawa/lib/lists.cadr:(Ljava/lang/Object;)Ljava/lang/Object;
        //   187: goto            31
        //   190: areturn        
        //   191: new             Lgnu/mapping/WrongType;
        //   194: dup_x1         
        //   195: swap           
        //   196: ldc             "string-ref"
        //   198: iconst_1       
        //   199: aload           6
        //   201: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   204: athrow         
        //   205: new             Lgnu/mapping/WrongType;
        //   208: dup_x1         
        //   209: swap           
        //   210: ldc             "string-ref"
        //   212: iconst_2       
        //   213: aload           6
        //   215: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   218: athrow         
        //   219: new             Lgnu/mapping/WrongType;
        //   222: dup_x1         
        //   223: swap           
        //   224: ldc             "string-ref"
        //   226: iconst_1       
        //   227: aload           7
        //   229: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   232: athrow         
        //   233: new             Lgnu/mapping/WrongType;
        //   236: dup_x1         
        //   237: swap           
        //   238: ldc             "string-ref"
        //   240: iconst_2       
        //   241: aload           7
        //   243: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   246: athrow         
        //   247: new             Lgnu/mapping/WrongType;
        //   250: dup_x1         
        //   251: swap           
        //   252: ldc             "car"
        //   254: iconst_1       
        //   255: aload           7
        //   257: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   260: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  64     67     191    205    Ljava/lang/ClassCastException;
        //  75     81     205    219    Ljava/lang/ClassCastException;
        //  117    120    219    233    Ljava/lang/ClassCastException;
        //  128    134    233    247    Ljava/lang/ClassCastException;
        //  172    175    247    261    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public static Object pregexpReadBranch(final Object s, final Object i, final Object n) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: aload_1         /* i */
        //     4: astore          4
        //     6: astore_3        /* pieces */
        //     7: aload           i
        //     9: aload_2         /* n */
        //    10: invokestatic    gnu/kawa/functions/NumberCompare.$Gr$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //    13: ifeq            34
        //    16: getstatic       gnu/kawa/slib/pregexp.Lit2:Lgnu/mapping/SimpleSymbol;
        //    19: aload_3         /* pieces */
        //    20: invokestatic    gnu/kawa/slib/pregexp.pregexpReverse$Ex:(Ljava/lang/Object;)Ljava/lang/Object;
        //    23: invokestatic    kawa/lib/lists.cons:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //    26: aload           i
        //    28: invokestatic    gnu/lists/LList.list2:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //    31: goto            154
        //    34: aload_0         /* s */
        //    35: ldc             Ljava/lang/CharSequence;.class
        //    37: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    40: dup            
        //    41: astore          6
        //    43: checkcast       Ljava/lang/CharSequence;
        //    46: aload           i
        //    48: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //    51: dup            
        //    52: astore          6
        //    54: checkcast       Ljava/lang/Number;
        //    57: invokevirtual   java/lang/Number.intValue:()I
        //    60: invokestatic    kawa/lib/strings.stringRef:(Ljava/lang/CharSequence;I)I
        //    63: istore          c
        //    65: iload           c
        //    67: bipush          124
        //    69: if_icmpne       76
        //    72: iconst_1       
        //    73: goto            77
        //    76: iconst_0       
        //    77: istore          x
        //    79: iload           x
        //    81: ifeq            92
        //    84: iload           x
        //    86: ifeq            117
        //    89: goto            99
        //    92: iload           c
        //    94: bipush          41
        //    96: if_icmpne       117
        //    99: getstatic       gnu/kawa/slib/pregexp.Lit2:Lgnu/mapping/SimpleSymbol;
        //   102: aload_3         /* pieces */
        //   103: invokestatic    gnu/kawa/slib/pregexp.pregexpReverse$Ex:(Ljava/lang/Object;)Ljava/lang/Object;
        //   106: invokestatic    kawa/lib/lists.cons:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //   109: aload           i
        //   111: invokestatic    gnu/lists/LList.list2:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //   114: goto            154
        //   117: aload_0         /* s */
        //   118: aload           i
        //   120: aload_2         /* n */
        //   121: invokestatic    gnu/kawa/slib/pregexp.pregexpReadPiece:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   124: astore          vv
        //   126: aload           vv
        //   128: ldc             Lgnu/lists/Pair;.class
        //   130: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   133: dup            
        //   134: astore          8
        //   136: checkcast       Lgnu/lists/Pair;
        //   139: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   142: aload_3         /* pieces */
        //   143: invokestatic    kawa/lib/lists.cons:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //   146: aload           vv
        //   148: invokestatic    kawa/lib/lists.cadr:(Ljava/lang/Object;)Ljava/lang/Object;
        //   151: goto            4
        //   154: areturn        
        //   155: new             Lgnu/mapping/WrongType;
        //   158: dup_x1         
        //   159: swap           
        //   160: ldc             "string-ref"
        //   162: iconst_1       
        //   163: aload           6
        //   165: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   168: athrow         
        //   169: new             Lgnu/mapping/WrongType;
        //   172: dup_x1         
        //   173: swap           
        //   174: ldc             "string-ref"
        //   176: iconst_2       
        //   177: aload           6
        //   179: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   182: athrow         
        //   183: new             Lgnu/mapping/WrongType;
        //   186: dup_x1         
        //   187: swap           
        //   188: ldc             "car"
        //   190: iconst_1       
        //   191: aload           8
        //   193: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   196: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  43     46     155    169    Ljava/lang/ClassCastException;
        //  54     60     169    183    Ljava/lang/ClassCastException;
        //  136    139    183    197    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public static Object pregexpReadPiece(final Object s, final Object i, final Object n) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             Ljava/lang/CharSequence;.class
        //     3: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //     6: dup            
        //     7: astore          4
        //     9: checkcast       Ljava/lang/CharSequence;
        //    12: aload_1         /* i */
        //    13: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //    16: dup            
        //    17: astore          4
        //    19: checkcast       Ljava/lang/Number;
        //    22: invokevirtual   java/lang/Number.intValue:()I
        //    25: invokestatic    kawa/lib/strings.stringRef:(Ljava/lang/CharSequence;I)I
        //    28: istore_3        /* c */
        //    29: iload_3         /* c */
        //    30: lookupswitch {
        //               36: 88
        //               40: 228
        //               46: 266
        //               91: 288
        //               92: 105
        //               94: 249
        //          default: 437
        //        }
        //    88: getstatic       gnu/kawa/slib/pregexp.Lit4:Lgnu/mapping/SimpleSymbol;
        //    91: iconst_1       
        //    92: aload_1         /* i */
        //    93: getstatic       gnu/kawa/slib/pregexp.Lit3:Lgnu/math/IntNum;
        //    96: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    99: invokestatic    gnu/lists/LList.list2:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //   102: goto            648
        //   105: aload_0         /* s */
        //   106: aload_1         /* i */
        //   107: aload_2         /* n */
        //   108: invokestatic    gnu/kawa/slib/pregexp.pregexpReadEscapedNumber:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   111: astore          temp
        //   113: aload           temp
        //   115: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //   118: ifeq            154
        //   121: getstatic       gnu/kawa/slib/pregexp.Lit5:Lgnu/mapping/SimpleSymbol;
        //   124: aload           temp
        //   126: ldc             Lgnu/lists/Pair;.class
        //   128: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   131: dup            
        //   132: astore          5
        //   134: checkcast       Lgnu/lists/Pair;
        //   137: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   140: invokestatic    gnu/lists/LList.list2:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //   143: aload           temp
        //   145: invokestatic    kawa/lib/lists.cadr:(Ljava/lang/Object;)Ljava/lang/Object;
        //   148: invokestatic    gnu/lists/LList.list2:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //   151: goto            220
        //   154: aload_0         /* s */
        //   155: aload_1         /* i */
        //   156: aload_2         /* n */
        //   157: invokestatic    gnu/kawa/slib/pregexp.pregexpReadEscapedChar:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   160: astore          temp
        //   162: aload           temp
        //   164: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //   167: ifeq            197
        //   170: aload           temp
        //   172: ldc             Lgnu/lists/Pair;.class
        //   174: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   177: dup            
        //   178: astore          6
        //   180: checkcast       Lgnu/lists/Pair;
        //   183: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   186: aload           temp
        //   188: invokestatic    kawa/lib/lists.cadr:(Ljava/lang/Object;)Ljava/lang/Object;
        //   191: invokestatic    gnu/lists/LList.list2:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //   194: goto            220
        //   197: iconst_2       
        //   198: anewarray       Ljava/lang/Object;
        //   201: dup            
        //   202: iconst_0       
        //   203: getstatic       gnu/kawa/slib/pregexp.Lit6:Lgnu/mapping/SimpleSymbol;
        //   206: aastore        
        //   207: dup            
        //   208: iconst_1       
        //   209: getstatic       gnu/kawa/slib/pregexp.Lit7:Lgnu/mapping/SimpleSymbol;
        //   212: aastore        
        //   213: invokestatic    kawa/lib/exceptions.error:([Ljava/lang/Object;)Lgnu/bytecode/Type$NeverReturns;
        //   216: getstatic       gnu/expr/Special.reachedUnexpected:Ljava/lang/RuntimeException;
        //   219: athrow         
        //   220: aload_0         /* s */
        //   221: aload_2         /* n */
        //   222: invokestatic    gnu/kawa/slib/pregexp.pregexpWrapQuantifierIfAny:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   225: goto            648
        //   228: aload_0         /* s */
        //   229: iconst_1       
        //   230: aload_1         /* i */
        //   231: getstatic       gnu/kawa/slib/pregexp.Lit3:Lgnu/math/IntNum;
        //   234: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   237: aload_2         /* n */
        //   238: invokestatic    gnu/kawa/slib/pregexp.pregexpReadSubpattern:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   241: aload_0         /* s */
        //   242: aload_2         /* n */
        //   243: invokestatic    gnu/kawa/slib/pregexp.pregexpWrapQuantifierIfAny:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   246: goto            648
        //   249: getstatic       gnu/kawa/slib/pregexp.Lit8:Lgnu/mapping/SimpleSymbol;
        //   252: iconst_1       
        //   253: aload_1         /* i */
        //   254: getstatic       gnu/kawa/slib/pregexp.Lit3:Lgnu/math/IntNum;
        //   257: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   260: invokestatic    gnu/lists/LList.list2:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //   263: goto            648
        //   266: getstatic       gnu/kawa/slib/pregexp.Lit9:Lgnu/mapping/SimpleSymbol;
        //   269: iconst_1       
        //   270: aload_1         /* i */
        //   271: getstatic       gnu/kawa/slib/pregexp.Lit3:Lgnu/math/IntNum;
        //   274: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   277: invokestatic    gnu/lists/LList.list2:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //   280: aload_0         /* s */
        //   281: aload_2         /* n */
        //   282: invokestatic    gnu/kawa/slib/pregexp.pregexpWrapQuantifierIfAny:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   285: goto            648
        //   288: iconst_1       
        //   289: aload_1         /* i */
        //   290: getstatic       gnu/kawa/slib/pregexp.Lit3:Lgnu/math/IntNum;
        //   293: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   296: astore          i$Pl1
        //   298: aload           i$Pl1
        //   300: aload_2         /* n */
        //   301: invokestatic    gnu/kawa/functions/NumberCompare.$Ls:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   304: ifeq            342
        //   307: aload_0         /* s */
        //   308: ldc             Ljava/lang/CharSequence;.class
        //   310: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   313: dup            
        //   314: astore          6
        //   316: checkcast       Ljava/lang/CharSequence;
        //   319: aload           i$Pl1
        //   321: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   324: dup            
        //   325: astore          6
        //   327: checkcast       Ljava/lang/Number;
        //   330: invokevirtual   java/lang/Number.intValue:()I
        //   333: invokestatic    kawa/lib/strings.stringRef:(Ljava/lang/CharSequence;I)I
        //   336: invokestatic    gnu/text/Char.make:(I)Lgnu/text/Char;
        //   339: goto            345
        //   342: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //   345: astore          tmp
        //   347: aload           tmp
        //   349: invokevirtual   java/lang/Object.hashCode:()I
        //   352: bipush          94
        //   354: if_icmpne       419
        //   357: goto            360
        //   360: aload           tmp
        //   362: getstatic       gnu/kawa/slib/pregexp.Lit10:Lgnu/text/Char;
        //   365: invokestatic    gnu/kawa/functions/IsEqv.apply:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   368: ifeq            419
        //   371: aload_0         /* s */
        //   372: iconst_1       
        //   373: aload_1         /* i */
        //   374: getstatic       gnu/kawa/slib/pregexp.Lit11:Lgnu/math/IntNum;
        //   377: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   380: aload_2         /* n */
        //   381: invokestatic    gnu/kawa/slib/pregexp.pregexpReadCharList:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   384: astore          vv
        //   386: getstatic       gnu/kawa/slib/pregexp.Lit12:Lgnu/mapping/SimpleSymbol;
        //   389: aload           vv
        //   391: ldc             Lgnu/lists/Pair;.class
        //   393: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   396: dup            
        //   397: astore          7
        //   399: checkcast       Lgnu/lists/Pair;
        //   402: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   405: invokestatic    gnu/lists/LList.list2:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //   408: aload           vv
        //   410: invokestatic    kawa/lib/lists.cadr:(Ljava/lang/Object;)Ljava/lang/Object;
        //   413: invokestatic    gnu/lists/LList.list2:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //   416: goto            429
        //   419: aload_0         /* s */
        //   420: aload           i$Pl1
        //   422: aload_2         /* n */
        //   423: invokestatic    gnu/kawa/slib/pregexp.pregexpReadCharList:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   426: goto            429
        //   429: aload_0         /* s */
        //   430: aload_2         /* n */
        //   431: invokestatic    gnu/kawa/slib/pregexp.pregexpWrapQuantifierIfAny:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   434: goto            648
        //   437: getstatic       gnu/kawa/slib/pregexp.$Stpregexp$Mnspace$Mnsensitive$Qu$St:Ljava/lang/Object;
        //   440: astore          x
        //   442: aload           x
        //   444: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //   447: ifeq            461
        //   450: aload           x
        //   452: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //   455: ifeq            497
        //   458: goto            474
        //   461: iload_3         /* c */
        //   462: invokestatic    kawa/lib/rnrs/unicode.isCharWhitespace:(I)Z
        //   465: ifne            497
        //   468: iload_3         /* c */
        //   469: bipush          59
        //   471: if_icmpeq       497
        //   474: iload_3         /* c */
        //   475: invokestatic    gnu/text/Char.make:(I)Lgnu/text/Char;
        //   478: iconst_1       
        //   479: aload_1         /* i */
        //   480: getstatic       gnu/kawa/slib/pregexp.Lit3:Lgnu/math/IntNum;
        //   483: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   486: invokestatic    gnu/lists/LList.list2:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //   489: aload_0         /* s */
        //   490: aload_2         /* n */
        //   491: invokestatic    gnu/kawa/slib/pregexp.pregexpWrapQuantifierIfAny:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   494: goto            648
        //   497: aload_1         /* i */
        //   498: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //   501: astore          6
        //   503: astore          i
        //   505: aload           i
        //   507: aload_2         /* n */
        //   508: invokestatic    gnu/kawa/functions/NumberCompare.$Gr$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   511: ifeq            525
        //   514: getstatic       gnu/kawa/slib/pregexp.Lit13:Lgnu/mapping/SimpleSymbol;
        //   517: aload           i
        //   519: invokestatic    gnu/lists/LList.list2:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //   522: goto            648
        //   525: aload_0         /* s */
        //   526: ldc             Ljava/lang/CharSequence;.class
        //   528: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   531: dup            
        //   532: astore          8
        //   534: checkcast       Ljava/lang/CharSequence;
        //   537: aload           i
        //   539: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   542: dup            
        //   543: astore          8
        //   545: checkcast       Ljava/lang/Number;
        //   548: invokevirtual   java/lang/Number.intValue:()I
        //   551: invokestatic    kawa/lib/strings.stringRef:(Ljava/lang/CharSequence;I)I
        //   554: istore          c
        //   556: aload           in$Mncomment$Qu
        //   558: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //   561: ifeq            592
        //   564: iconst_1       
        //   565: aload           i
        //   567: getstatic       gnu/kawa/slib/pregexp.Lit3:Lgnu/math/IntNum;
        //   570: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   573: iload           c
        //   575: bipush          10
        //   577: if_icmpne       586
        //   580: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //   583: goto            501
        //   586: getstatic       java/lang/Boolean.TRUE:Ljava/lang/Boolean;
        //   589: goto            501
        //   592: iload           c
        //   594: invokestatic    kawa/lib/rnrs/unicode.isCharWhitespace:(I)Z
        //   597: ifeq            615
        //   600: iconst_1       
        //   601: aload           i
        //   603: getstatic       gnu/kawa/slib/pregexp.Lit3:Lgnu/math/IntNum;
        //   606: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   609: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //   612: goto            501
        //   615: iload           c
        //   617: bipush          59
        //   619: if_icmpne       637
        //   622: iconst_1       
        //   623: aload           i
        //   625: getstatic       gnu/kawa/slib/pregexp.Lit3:Lgnu/math/IntNum;
        //   628: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   631: getstatic       java/lang/Boolean.TRUE:Ljava/lang/Boolean;
        //   634: goto            501
        //   637: getstatic       gnu/kawa/slib/pregexp.Lit13:Lgnu/mapping/SimpleSymbol;
        //   640: aload           i
        //   642: invokestatic    gnu/lists/LList.list2:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //   645: goto            648
        //   648: areturn        
        //   649: new             Lgnu/mapping/WrongType;
        //   652: dup_x1         
        //   653: swap           
        //   654: ldc             "string-ref"
        //   656: iconst_1       
        //   657: aload           4
        //   659: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   662: athrow         
        //   663: new             Lgnu/mapping/WrongType;
        //   666: dup_x1         
        //   667: swap           
        //   668: ldc             "string-ref"
        //   670: iconst_2       
        //   671: aload           4
        //   673: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   676: athrow         
        //   677: new             Lgnu/mapping/WrongType;
        //   680: dup_x1         
        //   681: swap           
        //   682: ldc             "car"
        //   684: iconst_1       
        //   685: aload           5
        //   687: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   690: athrow         
        //   691: new             Lgnu/mapping/WrongType;
        //   694: dup_x1         
        //   695: swap           
        //   696: ldc             "car"
        //   698: iconst_1       
        //   699: aload           6
        //   701: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   704: athrow         
        //   705: new             Lgnu/mapping/WrongType;
        //   708: dup_x1         
        //   709: swap           
        //   710: ldc             "string-ref"
        //   712: iconst_1       
        //   713: aload           6
        //   715: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   718: athrow         
        //   719: new             Lgnu/mapping/WrongType;
        //   722: dup_x1         
        //   723: swap           
        //   724: ldc             "string-ref"
        //   726: iconst_2       
        //   727: aload           6
        //   729: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   732: athrow         
        //   733: new             Lgnu/mapping/WrongType;
        //   736: dup_x1         
        //   737: swap           
        //   738: ldc             "car"
        //   740: iconst_1       
        //   741: aload           7
        //   743: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   746: athrow         
        //   747: new             Lgnu/mapping/WrongType;
        //   750: dup_x1         
        //   751: swap           
        //   752: ldc             "string-ref"
        //   754: iconst_1       
        //   755: aload           8
        //   757: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   760: athrow         
        //   761: new             Lgnu/mapping/WrongType;
        //   764: dup_x1         
        //   765: swap           
        //   766: ldc             "string-ref"
        //   768: iconst_2       
        //   769: aload           8
        //   771: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   774: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  9      12     649    663    Ljava/lang/ClassCastException;
        //  19     25     663    677    Ljava/lang/ClassCastException;
        //  134    137    677    691    Ljava/lang/ClassCastException;
        //  180    183    691    705    Ljava/lang/ClassCastException;
        //  316    319    705    719    Ljava/lang/ClassCastException;
        //  327    333    719    733    Ljava/lang/ClassCastException;
        //  399    402    733    747    Ljava/lang/ClassCastException;
        //  534    537    747    761    Ljava/lang/ClassCastException;
        //  545    551    761    775    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public static Object pregexpWrapQuantifierIfAny(final Object vv, final Object s, final Object n) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             Lgnu/lists/Pair;.class
        //     3: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //     6: dup            
        //     7: astore          4
        //     9: checkcast       Lgnu/lists/Pair;
        //    12: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    15: astore_3        /* re */
        //    16: aload_0         /* vv */
        //    17: invokestatic    kawa/lib/lists.cadr:(Ljava/lang/Object;)Ljava/lang/Object;
        //    20: astore          i
        //    22: aload           i
        //    24: aload_2         /* n */
        //    25: invokestatic    gnu/kawa/functions/NumberCompare.$Gr$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //    28: ifeq            35
        //    31: aload_0         /* vv */
        //    32: goto            711
        //    35: aload_1         /* s */
        //    36: ldc             Ljava/lang/CharSequence;.class
        //    38: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    41: dup            
        //    42: astore          6
        //    44: checkcast       Ljava/lang/CharSequence;
        //    47: aload           i
        //    49: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //    52: dup            
        //    53: astore          6
        //    55: checkcast       Ljava/lang/Number;
        //    58: invokevirtual   java/lang/Number.intValue:()I
        //    61: invokestatic    kawa/lib/strings.stringRef:(Ljava/lang/CharSequence;I)I
        //    64: istore          c
        //    66: iload           c
        //    68: invokestatic    kawa/lib/rnrs/unicode.isCharWhitespace:(I)Z
        //    71: ifeq            95
        //    74: getstatic       gnu/kawa/slib/pregexp.$Stpregexp$Mnspace$Mnsensitive$Qu$St:Ljava/lang/Object;
        //    77: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //    80: ifne            95
        //    83: iconst_1       
        //    84: aload           i
        //    86: getstatic       gnu/kawa/slib/pregexp.Lit3:Lgnu/math/IntNum;
        //    89: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    92: goto            20
        //    95: iload           c
        //    97: lookupswitch {
        //               42: 140
        //               43: 140
        //               63: 140
        //              123: 140
        //          default: 707
        //        }
        //   140: getstatic       gnu/kawa/slib/pregexp.Lit35:Lgnu/mapping/SimpleSymbol;
        //   143: invokestatic    gnu/lists/LList.list1:(Ljava/lang/Object;)Lgnu/lists/Pair;
        //   146: dup            
        //   147: getstatic       gnu/kawa/slib/pregexp.Lit36:Lgnu/mapping/SimpleSymbol;
        //   150: getstatic       gnu/kawa/slib/pregexp.Lit37:Lgnu/mapping/SimpleSymbol;
        //   153: getstatic       gnu/kawa/slib/pregexp.Lit38:Lgnu/mapping/SimpleSymbol;
        //   156: aload_3         /* re */
        //   157: invokestatic    gnu/lists/LList.chain4:(Lgnu/lists/Pair;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //   160: pop            
        //   161: astore          new$Mnre
        //   163: aload           new$Mnre
        //   165: getstatic       gnu/kawa/slib/pregexp.Lit39:Lgnu/mapping/SimpleSymbol;
        //   168: invokestatic    gnu/lists/LList.list2:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //   171: astore          new$Mnvv
        //   173: iload           c
        //   175: lookupswitch {
        //               42: 216
        //               43: 263
        //               63: 426
        //              123: 310
        //          default: 473
        //        }
        //   216: aload           new$Mnre
        //   218: invokestatic    kawa/lib/lists.cddr:(Ljava/lang/Object;)Ljava/lang/Object;
        //   221: ldc             Lgnu/lists/Pair;.class
        //   223: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   226: dup            
        //   227: astore          8
        //   229: checkcast       Lgnu/lists/Pair;
        //   232: getstatic       gnu/kawa/slib/pregexp.Lit40:Lgnu/math/IntNum;
        //   235: invokestatic    kawa/lib/lists.setCar$Ex:(Lgnu/lists/Pair;Ljava/lang/Object;)V
        //   238: aload           new$Mnre
        //   240: invokestatic    kawa/lib/lists.cdddr:(Ljava/lang/Object;)Ljava/lang/Object;
        //   243: ldc             Lgnu/lists/Pair;.class
        //   245: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   248: dup            
        //   249: astore          8
        //   251: checkcast       Lgnu/lists/Pair;
        //   254: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //   257: invokestatic    kawa/lib/lists.setCar$Ex:(Lgnu/lists/Pair;Ljava/lang/Object;)V
        //   260: goto            473
        //   263: aload           new$Mnre
        //   265: invokestatic    kawa/lib/lists.cddr:(Ljava/lang/Object;)Ljava/lang/Object;
        //   268: ldc             Lgnu/lists/Pair;.class
        //   270: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   273: dup            
        //   274: astore          8
        //   276: checkcast       Lgnu/lists/Pair;
        //   279: getstatic       gnu/kawa/slib/pregexp.Lit3:Lgnu/math/IntNum;
        //   282: invokestatic    kawa/lib/lists.setCar$Ex:(Lgnu/lists/Pair;Ljava/lang/Object;)V
        //   285: aload           new$Mnre
        //   287: invokestatic    kawa/lib/lists.cdddr:(Ljava/lang/Object;)Ljava/lang/Object;
        //   290: ldc             Lgnu/lists/Pair;.class
        //   292: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   295: dup            
        //   296: astore          8
        //   298: checkcast       Lgnu/lists/Pair;
        //   301: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //   304: invokestatic    kawa/lib/lists.setCar$Ex:(Lgnu/lists/Pair;Ljava/lang/Object;)V
        //   307: goto            473
        //   310: aload_1         /* s */
        //   311: iconst_1       
        //   312: aload           i
        //   314: getstatic       gnu/kawa/slib/pregexp.Lit3:Lgnu/math/IntNum;
        //   317: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   320: aload_2         /* n */
        //   321: invokestatic    gnu/kawa/slib/pregexp.pregexpReadNums:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   324: astore          pq
        //   326: aload           pq
        //   328: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //   331: ifne            357
        //   334: iconst_2       
        //   335: anewarray       Ljava/lang/Object;
        //   338: dup            
        //   339: iconst_0       
        //   340: getstatic       gnu/kawa/slib/pregexp.Lit41:Lgnu/mapping/SimpleSymbol;
        //   343: aastore        
        //   344: dup            
        //   345: iconst_1       
        //   346: getstatic       gnu/kawa/slib/pregexp.Lit42:Lgnu/mapping/SimpleSymbol;
        //   349: aastore        
        //   350: invokestatic    kawa/lib/exceptions.error:([Ljava/lang/Object;)Lgnu/bytecode/Type$NeverReturns;
        //   353: getstatic       gnu/expr/Special.reachedUnexpected:Ljava/lang/RuntimeException;
        //   356: athrow         
        //   357: aload           new$Mnre
        //   359: invokestatic    kawa/lib/lists.cddr:(Ljava/lang/Object;)Ljava/lang/Object;
        //   362: ldc             Lgnu/lists/Pair;.class
        //   364: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   367: dup            
        //   368: astore          9
        //   370: checkcast       Lgnu/lists/Pair;
        //   373: aload           pq
        //   375: ldc             Lgnu/lists/Pair;.class
        //   377: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   380: dup            
        //   381: astore          9
        //   383: checkcast       Lgnu/lists/Pair;
        //   386: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   389: invokestatic    kawa/lib/lists.setCar$Ex:(Lgnu/lists/Pair;Ljava/lang/Object;)V
        //   392: aload           new$Mnre
        //   394: invokestatic    kawa/lib/lists.cdddr:(Ljava/lang/Object;)Ljava/lang/Object;
        //   397: ldc             Lgnu/lists/Pair;.class
        //   399: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   402: dup            
        //   403: astore          9
        //   405: checkcast       Lgnu/lists/Pair;
        //   408: aload           pq
        //   410: invokestatic    kawa/lib/lists.cadr:(Ljava/lang/Object;)Ljava/lang/Object;
        //   413: invokestatic    kawa/lib/lists.setCar$Ex:(Lgnu/lists/Pair;Ljava/lang/Object;)V
        //   416: aload           pq
        //   418: invokestatic    kawa/lib/lists.caddr:(Ljava/lang/Object;)Ljava/lang/Object;
        //   421: astore          i
        //   423: goto            473
        //   426: aload           new$Mnre
        //   428: invokestatic    kawa/lib/lists.cddr:(Ljava/lang/Object;)Ljava/lang/Object;
        //   431: ldc             Lgnu/lists/Pair;.class
        //   433: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   436: dup            
        //   437: astore          8
        //   439: checkcast       Lgnu/lists/Pair;
        //   442: getstatic       gnu/kawa/slib/pregexp.Lit40:Lgnu/math/IntNum;
        //   445: invokestatic    kawa/lib/lists.setCar$Ex:(Lgnu/lists/Pair;Ljava/lang/Object;)V
        //   448: aload           new$Mnre
        //   450: invokestatic    kawa/lib/lists.cdddr:(Ljava/lang/Object;)Ljava/lang/Object;
        //   453: ldc             Lgnu/lists/Pair;.class
        //   455: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   458: dup            
        //   459: astore          8
        //   461: checkcast       Lgnu/lists/Pair;
        //   464: getstatic       gnu/kawa/slib/pregexp.Lit3:Lgnu/math/IntNum;
        //   467: invokestatic    kawa/lib/lists.setCar$Ex:(Lgnu/lists/Pair;Ljava/lang/Object;)V
        //   470: goto            473
        //   473: iconst_1       
        //   474: aload           i
        //   476: getstatic       gnu/kawa/slib/pregexp.Lit3:Lgnu/math/IntNum;
        //   479: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   482: astore          i
        //   484: aload           i
        //   486: aload_2         /* n */
        //   487: invokestatic    gnu/kawa/functions/NumberCompare.$Gr$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   490: ifeq            539
        //   493: aload           new$Mnre
        //   495: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   498: ldc             Lgnu/lists/Pair;.class
        //   500: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   503: dup            
        //   504: astore          9
        //   506: checkcast       Lgnu/lists/Pair;
        //   509: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //   512: invokestatic    kawa/lib/lists.setCar$Ex:(Lgnu/lists/Pair;Ljava/lang/Object;)V
        //   515: aload           new$Mnvv
        //   517: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   520: ldc             Lgnu/lists/Pair;.class
        //   522: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   525: dup            
        //   526: astore          9
        //   528: checkcast       Lgnu/lists/Pair;
        //   531: aload           i
        //   533: invokestatic    kawa/lib/lists.setCar$Ex:(Lgnu/lists/Pair;Ljava/lang/Object;)V
        //   536: goto            702
        //   539: aload_1         /* s */
        //   540: ldc             Ljava/lang/CharSequence;.class
        //   542: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   545: dup            
        //   546: astore          10
        //   548: checkcast       Ljava/lang/CharSequence;
        //   551: aload           i
        //   553: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   556: dup            
        //   557: astore          10
        //   559: checkcast       Ljava/lang/Number;
        //   562: invokevirtual   java/lang/Number.intValue:()I
        //   565: invokestatic    kawa/lib/strings.stringRef:(Ljava/lang/CharSequence;I)I
        //   568: istore          c
        //   570: iload           c
        //   572: invokestatic    kawa/lib/rnrs/unicode.isCharWhitespace:(I)Z
        //   575: ifeq            599
        //   578: getstatic       gnu/kawa/slib/pregexp.$Stpregexp$Mnspace$Mnsensitive$Qu$St:Ljava/lang/Object;
        //   581: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //   584: ifne            599
        //   587: iconst_1       
        //   588: aload           i
        //   590: getstatic       gnu/kawa/slib/pregexp.Lit3:Lgnu/math/IntNum;
        //   593: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   596: goto            482
        //   599: iload           c
        //   601: bipush          63
        //   603: if_icmpne       659
        //   606: aload           new$Mnre
        //   608: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   611: ldc             Lgnu/lists/Pair;.class
        //   613: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   616: dup            
        //   617: astore          10
        //   619: checkcast       Lgnu/lists/Pair;
        //   622: getstatic       java/lang/Boolean.TRUE:Ljava/lang/Boolean;
        //   625: invokestatic    kawa/lib/lists.setCar$Ex:(Lgnu/lists/Pair;Ljava/lang/Object;)V
        //   628: aload           new$Mnvv
        //   630: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   633: ldc             Lgnu/lists/Pair;.class
        //   635: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   638: dup            
        //   639: astore          10
        //   641: checkcast       Lgnu/lists/Pair;
        //   644: iconst_1       
        //   645: aload           i
        //   647: getstatic       gnu/kawa/slib/pregexp.Lit3:Lgnu/math/IntNum;
        //   650: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   653: invokestatic    kawa/lib/lists.setCar$Ex:(Lgnu/lists/Pair;Ljava/lang/Object;)V
        //   656: goto            702
        //   659: aload           new$Mnre
        //   661: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   664: ldc             Lgnu/lists/Pair;.class
        //   666: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   669: dup            
        //   670: astore          10
        //   672: checkcast       Lgnu/lists/Pair;
        //   675: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //   678: invokestatic    kawa/lib/lists.setCar$Ex:(Lgnu/lists/Pair;Ljava/lang/Object;)V
        //   681: aload           new$Mnvv
        //   683: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   686: ldc             Lgnu/lists/Pair;.class
        //   688: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   691: dup            
        //   692: astore          10
        //   694: checkcast       Lgnu/lists/Pair;
        //   697: aload           i
        //   699: invokestatic    kawa/lib/lists.setCar$Ex:(Lgnu/lists/Pair;Ljava/lang/Object;)V
        //   702: aload           new$Mnvv
        //   704: goto            711
        //   707: aload_0         /* vv */
        //   708: goto            711
        //   711: areturn        
        //   712: new             Lgnu/mapping/WrongType;
        //   715: dup_x1         
        //   716: swap           
        //   717: ldc             "car"
        //   719: iconst_1       
        //   720: aload           4
        //   722: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   725: athrow         
        //   726: new             Lgnu/mapping/WrongType;
        //   729: dup_x1         
        //   730: swap           
        //   731: ldc             "string-ref"
        //   733: iconst_1       
        //   734: aload           6
        //   736: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   739: athrow         
        //   740: new             Lgnu/mapping/WrongType;
        //   743: dup_x1         
        //   744: swap           
        //   745: ldc             "string-ref"
        //   747: iconst_2       
        //   748: aload           6
        //   750: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   753: athrow         
        //   754: new             Lgnu/mapping/WrongType;
        //   757: dup_x1         
        //   758: swap           
        //   759: ldc_w           "set-car!"
        //   762: iconst_1       
        //   763: aload           8
        //   765: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   768: athrow         
        //   769: new             Lgnu/mapping/WrongType;
        //   772: dup_x1         
        //   773: swap           
        //   774: ldc_w           "set-car!"
        //   777: iconst_1       
        //   778: aload           8
        //   780: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   783: athrow         
        //   784: new             Lgnu/mapping/WrongType;
        //   787: dup_x1         
        //   788: swap           
        //   789: ldc_w           "set-car!"
        //   792: iconst_1       
        //   793: aload           8
        //   795: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   798: athrow         
        //   799: new             Lgnu/mapping/WrongType;
        //   802: dup_x1         
        //   803: swap           
        //   804: ldc_w           "set-car!"
        //   807: iconst_1       
        //   808: aload           8
        //   810: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   813: athrow         
        //   814: new             Lgnu/mapping/WrongType;
        //   817: dup_x1         
        //   818: swap           
        //   819: ldc_w           "set-car!"
        //   822: iconst_1       
        //   823: aload           9
        //   825: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   828: athrow         
        //   829: new             Lgnu/mapping/WrongType;
        //   832: dup_x1         
        //   833: swap           
        //   834: ldc             "car"
        //   836: iconst_1       
        //   837: aload           9
        //   839: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   842: athrow         
        //   843: new             Lgnu/mapping/WrongType;
        //   846: dup_x1         
        //   847: swap           
        //   848: ldc_w           "set-car!"
        //   851: iconst_1       
        //   852: aload           9
        //   854: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   857: athrow         
        //   858: new             Lgnu/mapping/WrongType;
        //   861: dup_x1         
        //   862: swap           
        //   863: ldc_w           "set-car!"
        //   866: iconst_1       
        //   867: aload           8
        //   869: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   872: athrow         
        //   873: new             Lgnu/mapping/WrongType;
        //   876: dup_x1         
        //   877: swap           
        //   878: ldc_w           "set-car!"
        //   881: iconst_1       
        //   882: aload           8
        //   884: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   887: athrow         
        //   888: new             Lgnu/mapping/WrongType;
        //   891: dup_x1         
        //   892: swap           
        //   893: ldc_w           "set-car!"
        //   896: iconst_1       
        //   897: aload           9
        //   899: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   902: athrow         
        //   903: new             Lgnu/mapping/WrongType;
        //   906: dup_x1         
        //   907: swap           
        //   908: ldc_w           "set-car!"
        //   911: iconst_1       
        //   912: aload           9
        //   914: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   917: athrow         
        //   918: new             Lgnu/mapping/WrongType;
        //   921: dup_x1         
        //   922: swap           
        //   923: ldc             "string-ref"
        //   925: iconst_1       
        //   926: aload           10
        //   928: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   931: athrow         
        //   932: new             Lgnu/mapping/WrongType;
        //   935: dup_x1         
        //   936: swap           
        //   937: ldc             "string-ref"
        //   939: iconst_2       
        //   940: aload           10
        //   942: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   945: athrow         
        //   946: new             Lgnu/mapping/WrongType;
        //   949: dup_x1         
        //   950: swap           
        //   951: ldc_w           "set-car!"
        //   954: iconst_1       
        //   955: aload           10
        //   957: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   960: athrow         
        //   961: new             Lgnu/mapping/WrongType;
        //   964: dup_x1         
        //   965: swap           
        //   966: ldc_w           "set-car!"
        //   969: iconst_1       
        //   970: aload           10
        //   972: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   975: athrow         
        //   976: new             Lgnu/mapping/WrongType;
        //   979: dup_x1         
        //   980: swap           
        //   981: ldc_w           "set-car!"
        //   984: iconst_1       
        //   985: aload           10
        //   987: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   990: athrow         
        //   991: new             Lgnu/mapping/WrongType;
        //   994: dup_x1         
        //   995: swap           
        //   996: ldc_w           "set-car!"
        //   999: iconst_1       
        //  1000: aload           10
        //  1002: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1005: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  9      12     712    726    Ljava/lang/ClassCastException;
        //  44     47     726    740    Ljava/lang/ClassCastException;
        //  55     61     740    754    Ljava/lang/ClassCastException;
        //  229    232    754    769    Ljava/lang/ClassCastException;
        //  251    254    769    784    Ljava/lang/ClassCastException;
        //  276    279    784    799    Ljava/lang/ClassCastException;
        //  298    301    799    814    Ljava/lang/ClassCastException;
        //  370    373    814    829    Ljava/lang/ClassCastException;
        //  383    386    829    843    Ljava/lang/ClassCastException;
        //  405    408    843    858    Ljava/lang/ClassCastException;
        //  439    442    858    873    Ljava/lang/ClassCastException;
        //  461    464    873    888    Ljava/lang/ClassCastException;
        //  506    509    888    903    Ljava/lang/ClassCastException;
        //  528    531    903    918    Ljava/lang/ClassCastException;
        //  548    551    918    932    Ljava/lang/ClassCastException;
        //  559    565    932    946    Ljava/lang/ClassCastException;
        //  619    622    946    961    Ljava/lang/ClassCastException;
        //  641    644    961    976    Ljava/lang/ClassCastException;
        //  672    675    976    991    Ljava/lang/ClassCastException;
        //  694    697    991    1006   Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 431 out of bounds for length 431
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
    
    public static Object pregexpReadEscapedNumber(final Object s, final Object i, final Object n) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: aload_1         /* i */
        //     2: getstatic       gnu/kawa/slib/pregexp.Lit3:Lgnu/math/IntNum;
        //     5: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //     8: aload_2         /* n */
        //     9: invokestatic    gnu/kawa/functions/NumberCompare.$Ls:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //    12: ifeq            213
        //    15: aload_0         /* s */
        //    16: ldc             Ljava/lang/CharSequence;.class
        //    18: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    21: dup            
        //    22: astore          4
        //    24: checkcast       Ljava/lang/CharSequence;
        //    27: iconst_1       
        //    28: aload_1         /* i */
        //    29: getstatic       gnu/kawa/slib/pregexp.Lit3:Lgnu/math/IntNum;
        //    32: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    35: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //    38: dup            
        //    39: astore          4
        //    41: checkcast       Ljava/lang/Number;
        //    44: invokevirtual   java/lang/Number.intValue:()I
        //    47: invokestatic    kawa/lib/strings.stringRef:(Ljava/lang/CharSequence;I)I
        //    50: istore_3        /* c */
        //    51: iload_3         /* c */
        //    52: invokestatic    kawa/lib/rnrs/unicode.isCharNumeric:(I)Z
        //    55: ifeq            207
        //    58: iconst_1       
        //    59: aload_1         /* i */
        //    60: getstatic       gnu/kawa/slib/pregexp.Lit11:Lgnu/math/IntNum;
        //    63: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    66: iload_3         /* c */
        //    67: invokestatic    gnu/text/Char.make:(I)Lgnu/text/Char;
        //    70: invokestatic    gnu/lists/LList.list1:(Ljava/lang/Object;)Lgnu/lists/Pair;
        //    73: astore          5
        //    75: astore          i
        //    77: aload           i
        //    79: aload_2         /* n */
        //    80: invokestatic    gnu/kawa/functions/NumberCompare.$Gr$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //    83: ifeq            116
        //    86: aload           r
        //    88: invokestatic    gnu/kawa/slib/pregexp.pregexpReverse$Ex:(Ljava/lang/Object;)Ljava/lang/Object;
        //    91: ldc             Lgnu/lists/LList;.class
        //    93: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    96: dup            
        //    97: astore          6
        //    99: checkcast       Lgnu/lists/LList;
        //   102: invokestatic    kawa/lib/strings.list$To$String:(Lgnu/lists/LList;)Ljava/lang/CharSequence;
        //   105: invokestatic    kawa/lib/numbers.string$To$Number:(Ljava/lang/CharSequence;)Ljava/lang/Object;
        //   108: aload           i
        //   110: invokestatic    gnu/lists/LList.list2:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //   113: goto            216
        //   116: aload_0         /* s */
        //   117: ldc             Ljava/lang/CharSequence;.class
        //   119: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   122: dup            
        //   123: astore          7
        //   125: checkcast       Ljava/lang/CharSequence;
        //   128: aload           i
        //   130: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   133: dup            
        //   134: astore          7
        //   136: checkcast       Ljava/lang/Number;
        //   139: invokevirtual   java/lang/Number.intValue:()I
        //   142: invokestatic    kawa/lib/strings.stringRef:(Ljava/lang/CharSequence;I)I
        //   145: istore          c
        //   147: iload           c
        //   149: invokestatic    kawa/lib/rnrs/unicode.isCharNumeric:(I)Z
        //   152: ifeq            177
        //   155: iconst_1       
        //   156: aload           i
        //   158: getstatic       gnu/kawa/slib/pregexp.Lit3:Lgnu/math/IntNum;
        //   161: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   164: iload           c
        //   166: invokestatic    gnu/text/Char.make:(I)Lgnu/text/Char;
        //   169: aload           r
        //   171: invokestatic    kawa/lib/lists.cons:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //   174: goto            73
        //   177: aload           r
        //   179: invokestatic    gnu/kawa/slib/pregexp.pregexpReverse$Ex:(Ljava/lang/Object;)Ljava/lang/Object;
        //   182: ldc             Lgnu/lists/LList;.class
        //   184: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   187: dup            
        //   188: astore          7
        //   190: checkcast       Lgnu/lists/LList;
        //   193: invokestatic    kawa/lib/strings.list$To$String:(Lgnu/lists/LList;)Ljava/lang/CharSequence;
        //   196: invokestatic    kawa/lib/numbers.string$To$Number:(Ljava/lang/CharSequence;)Ljava/lang/Object;
        //   199: aload           i
        //   201: invokestatic    gnu/lists/LList.list2:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //   204: goto            216
        //   207: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //   210: goto            216
        //   213: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //   216: areturn        
        //   217: new             Lgnu/mapping/WrongType;
        //   220: dup_x1         
        //   221: swap           
        //   222: ldc             "string-ref"
        //   224: iconst_1       
        //   225: aload           4
        //   227: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   230: athrow         
        //   231: new             Lgnu/mapping/WrongType;
        //   234: dup_x1         
        //   235: swap           
        //   236: ldc             "string-ref"
        //   238: iconst_2       
        //   239: aload           4
        //   241: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   244: athrow         
        //   245: new             Lgnu/mapping/WrongType;
        //   248: dup_x1         
        //   249: swap           
        //   250: ldc             "list->string"
        //   252: iconst_1       
        //   253: aload           6
        //   255: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   258: athrow         
        //   259: new             Lgnu/mapping/WrongType;
        //   262: dup_x1         
        //   263: swap           
        //   264: ldc             "string-ref"
        //   266: iconst_1       
        //   267: aload           7
        //   269: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   272: athrow         
        //   273: new             Lgnu/mapping/WrongType;
        //   276: dup_x1         
        //   277: swap           
        //   278: ldc             "string-ref"
        //   280: iconst_2       
        //   281: aload           7
        //   283: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   286: athrow         
        //   287: new             Lgnu/mapping/WrongType;
        //   290: dup_x1         
        //   291: swap           
        //   292: ldc             "list->string"
        //   294: iconst_1       
        //   295: aload           7
        //   297: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   300: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  24     27     217    231    Ljava/lang/ClassCastException;
        //  41     47     231    245    Ljava/lang/ClassCastException;
        //  99     102    245    259    Ljava/lang/ClassCastException;
        //  125    128    259    273    Ljava/lang/ClassCastException;
        //  136    142    273    287    Ljava/lang/ClassCastException;
        //  190    193    287    301    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public static Object pregexpReadEscapedChar(final Object s, final Object i, final Object n) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: aload_1         /* i */
        //     2: getstatic       gnu/kawa/slib/pregexp.Lit3:Lgnu/math/IntNum;
        //     5: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //     8: aload_2         /* n */
        //     9: invokestatic    gnu/kawa/functions/NumberCompare.$Ls:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //    12: ifeq            363
        //    15: aload_0         /* s */
        //    16: ldc             Ljava/lang/CharSequence;.class
        //    18: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    21: dup            
        //    22: astore          4
        //    24: checkcast       Ljava/lang/CharSequence;
        //    27: iconst_1       
        //    28: aload_1         /* i */
        //    29: getstatic       gnu/kawa/slib/pregexp.Lit3:Lgnu/math/IntNum;
        //    32: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    35: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //    38: dup            
        //    39: astore          4
        //    41: checkcast       Ljava/lang/Number;
        //    44: invokevirtual   java/lang/Number.intValue:()I
        //    47: invokestatic    kawa/lib/strings.stringRef:(Ljava/lang/CharSequence;I)I
        //    50: istore_3        /* c */
        //    51: iload_3         /* c */
        //    52: lookupswitch {
        //               66: 311
        //               68: 169
        //               83: 294
        //               87: 186
        //               98: 257
        //              100: 203
        //              110: 328
        //              114: 274
        //              115: 240
        //              116: 220
        //              119: 152
        //          default: 345
        //        }
        //   152: getstatic       gnu/kawa/slib/pregexp.Lit14:Lgnu/mapping/SimpleSymbol;
        //   155: iconst_1       
        //   156: aload_1         /* i */
        //   157: getstatic       gnu/kawa/slib/pregexp.Lit11:Lgnu/math/IntNum;
        //   160: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   163: invokestatic    gnu/lists/LList.list2:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //   166: goto            366
        //   169: getstatic       gnu/kawa/slib/pregexp.Lit15:Lgnu/lists/PairWithPosition;
        //   172: iconst_1       
        //   173: aload_1         /* i */
        //   174: getstatic       gnu/kawa/slib/pregexp.Lit11:Lgnu/math/IntNum;
        //   177: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   180: invokestatic    gnu/lists/LList.list2:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //   183: goto            366
        //   186: getstatic       gnu/kawa/slib/pregexp.Lit16:Lgnu/lists/PairWithPosition;
        //   189: iconst_1       
        //   190: aload_1         /* i */
        //   191: getstatic       gnu/kawa/slib/pregexp.Lit11:Lgnu/math/IntNum;
        //   194: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   197: invokestatic    gnu/lists/LList.list2:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //   200: goto            366
        //   203: getstatic       gnu/kawa/slib/pregexp.Lit17:Lgnu/mapping/SimpleSymbol;
        //   206: iconst_1       
        //   207: aload_1         /* i */
        //   208: getstatic       gnu/kawa/slib/pregexp.Lit11:Lgnu/math/IntNum;
        //   211: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   214: invokestatic    gnu/lists/LList.list2:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //   217: goto            366
        //   220: getstatic       gnu/kawa/slib/pregexp.$Stpregexp$Mntab$Mnchar$St:I
        //   223: invokestatic    gnu/text/Char.make:(I)Lgnu/text/Char;
        //   226: iconst_1       
        //   227: aload_1         /* i */
        //   228: getstatic       gnu/kawa/slib/pregexp.Lit11:Lgnu/math/IntNum;
        //   231: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   234: invokestatic    gnu/lists/LList.list2:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //   237: goto            366
        //   240: getstatic       gnu/kawa/slib/pregexp.Lit18:Lgnu/mapping/SimpleSymbol;
        //   243: iconst_1       
        //   244: aload_1         /* i */
        //   245: getstatic       gnu/kawa/slib/pregexp.Lit11:Lgnu/math/IntNum;
        //   248: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   251: invokestatic    gnu/lists/LList.list2:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //   254: goto            366
        //   257: getstatic       gnu/kawa/slib/pregexp.Lit19:Lgnu/mapping/SimpleSymbol;
        //   260: iconst_1       
        //   261: aload_1         /* i */
        //   262: getstatic       gnu/kawa/slib/pregexp.Lit11:Lgnu/math/IntNum;
        //   265: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   268: invokestatic    gnu/lists/LList.list2:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //   271: goto            366
        //   274: getstatic       gnu/kawa/slib/pregexp.$Stpregexp$Mnreturn$Mnchar$St:I
        //   277: invokestatic    gnu/text/Char.make:(I)Lgnu/text/Char;
        //   280: iconst_1       
        //   281: aload_1         /* i */
        //   282: getstatic       gnu/kawa/slib/pregexp.Lit11:Lgnu/math/IntNum;
        //   285: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   288: invokestatic    gnu/lists/LList.list2:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //   291: goto            366
        //   294: getstatic       gnu/kawa/slib/pregexp.Lit20:Lgnu/lists/PairWithPosition;
        //   297: iconst_1       
        //   298: aload_1         /* i */
        //   299: getstatic       gnu/kawa/slib/pregexp.Lit11:Lgnu/math/IntNum;
        //   302: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   305: invokestatic    gnu/lists/LList.list2:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //   308: goto            366
        //   311: getstatic       gnu/kawa/slib/pregexp.Lit21:Lgnu/mapping/SimpleSymbol;
        //   314: iconst_1       
        //   315: aload_1         /* i */
        //   316: getstatic       gnu/kawa/slib/pregexp.Lit11:Lgnu/math/IntNum;
        //   319: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   322: invokestatic    gnu/lists/LList.list2:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //   325: goto            366
        //   328: getstatic       gnu/kawa/slib/pregexp.Lit22:Lgnu/text/Char;
        //   331: iconst_1       
        //   332: aload_1         /* i */
        //   333: getstatic       gnu/kawa/slib/pregexp.Lit11:Lgnu/math/IntNum;
        //   336: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   339: invokestatic    gnu/lists/LList.list2:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //   342: goto            366
        //   345: iload_3         /* c */
        //   346: invokestatic    gnu/text/Char.make:(I)Lgnu/text/Char;
        //   349: iconst_1       
        //   350: aload_1         /* i */
        //   351: getstatic       gnu/kawa/slib/pregexp.Lit11:Lgnu/math/IntNum;
        //   354: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   357: invokestatic    gnu/lists/LList.list2:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //   360: goto            366
        //   363: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //   366: areturn        
        //   367: new             Lgnu/mapping/WrongType;
        //   370: dup_x1         
        //   371: swap           
        //   372: ldc             "string-ref"
        //   374: iconst_1       
        //   375: aload           4
        //   377: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   380: athrow         
        //   381: new             Lgnu/mapping/WrongType;
        //   384: dup_x1         
        //   385: swap           
        //   386: ldc             "string-ref"
        //   388: iconst_2       
        //   389: aload           4
        //   391: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   394: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  24     27     367    381    Ljava/lang/ClassCastException;
        //  41     47     381    395    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0152:
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
    
    public static Object pregexpReadSubpattern(final Object s, final Object i, final Object n) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: astore_3        /* remember$Mnspace$Mnsensitive$Qu */
        //     4: aload_0         /* s */
        //     5: aload_1         /* i */
        //     6: aload_2         /* n */
        //     7: invokestatic    gnu/kawa/slib/pregexp.pregexpReadClusterType:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    10: astore          ctyp$Mni
        //    12: aload           ctyp$Mni
        //    14: ldc             Lgnu/lists/Pair;.class
        //    16: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    19: dup            
        //    20: astore          6
        //    22: checkcast       Lgnu/lists/Pair;
        //    25: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    28: astore          ctyp
        //    30: aload           ctyp$Mni
        //    32: invokestatic    kawa/lib/lists.cadr:(Ljava/lang/Object;)Ljava/lang/Object;
        //    35: astore          i
        //    37: aload_0         /* s */
        //    38: aload           i
        //    40: aload_2         /* n */
        //    41: invokestatic    gnu/kawa/slib/pregexp.pregexpReadPattern:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    44: astore          vv
        //    46: aload_3         /* remember$Mnspace$Mnsensitive$Qu */
        //    47: putstatic       gnu/kawa/slib/pregexp.$Stpregexp$Mnspace$Mnsensitive$Qu$St:Ljava/lang/Object;
        //    50: aload           vv
        //    52: ldc             Lgnu/lists/Pair;.class
        //    54: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    57: dup            
        //    58: astore          9
        //    60: checkcast       Lgnu/lists/Pair;
        //    63: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    66: astore          8
        //    68: aload           vv
        //    70: invokestatic    kawa/lib/lists.cadr:(Ljava/lang/Object;)Ljava/lang/Object;
        //    73: astore          vv$Mni
        //    75: aload           vv$Mni
        //    77: aload_2         /* n */
        //    78: invokestatic    gnu/kawa/functions/NumberCompare.$Ls:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //    81: ifeq            194
        //    84: aload_0         /* s */
        //    85: ldc             Ljava/lang/CharSequence;.class
        //    87: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    90: dup            
        //    91: astore          10
        //    93: checkcast       Ljava/lang/CharSequence;
        //    96: aload           vv$Mni
        //    98: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   101: dup            
        //   102: astore          10
        //   104: checkcast       Ljava/lang/Number;
        //   107: invokevirtual   java/lang/Number.intValue:()I
        //   110: invokestatic    kawa/lib/strings.stringRef:(Ljava/lang/CharSequence;I)I
        //   113: bipush          41
        //   115: if_icmpne       194
        //   118: aload           ctyp
        //   120: aload           vv$Mnre
        //   122: astore          11
        //   124: astore          ctyp
        //   126: aload           ctyp
        //   128: invokestatic    kawa/lib/lists.isNull:(Ljava/lang/Object;)Z
        //   131: ifeq            139
        //   134: aload           re
        //   136: goto            179
        //   139: aload           ctyp
        //   141: ldc             Lgnu/lists/Pair;.class
        //   143: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   146: dup            
        //   147: astore          12
        //   149: checkcast       Lgnu/lists/Pair;
        //   152: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   155: aload           ctyp
        //   157: ldc             Lgnu/lists/Pair;.class
        //   159: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   162: dup            
        //   163: astore          12
        //   165: checkcast       Lgnu/lists/Pair;
        //   168: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   171: aload           re
        //   173: invokestatic    gnu/lists/LList.list2:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //   176: goto            122
        //   179: iconst_1       
        //   180: aload           vv$Mni
        //   182: getstatic       gnu/kawa/slib/pregexp.Lit3:Lgnu/math/IntNum;
        //   185: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   188: invokestatic    gnu/lists/LList.list2:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //   191: goto            211
        //   194: iconst_1       
        //   195: anewarray       Ljava/lang/Object;
        //   198: dup            
        //   199: iconst_0       
        //   200: getstatic       gnu/kawa/slib/pregexp.Lit34:Lgnu/mapping/SimpleSymbol;
        //   203: aastore        
        //   204: invokestatic    kawa/lib/exceptions.error:([Ljava/lang/Object;)Lgnu/bytecode/Type$NeverReturns;
        //   207: getstatic       gnu/expr/Special.reachedUnexpected:Ljava/lang/RuntimeException;
        //   210: athrow         
        //   211: areturn        
        //   212: new             Lgnu/mapping/WrongType;
        //   215: dup_x1         
        //   216: swap           
        //   217: ldc             "car"
        //   219: iconst_1       
        //   220: aload           6
        //   222: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   225: athrow         
        //   226: new             Lgnu/mapping/WrongType;
        //   229: dup_x1         
        //   230: swap           
        //   231: ldc             "car"
        //   233: iconst_1       
        //   234: aload           9
        //   236: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   239: athrow         
        //   240: new             Lgnu/mapping/WrongType;
        //   243: dup_x1         
        //   244: swap           
        //   245: ldc             "string-ref"
        //   247: iconst_1       
        //   248: aload           10
        //   250: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   253: athrow         
        //   254: new             Lgnu/mapping/WrongType;
        //   257: dup_x1         
        //   258: swap           
        //   259: ldc             "string-ref"
        //   261: iconst_2       
        //   262: aload           10
        //   264: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   267: athrow         
        //   268: new             Lgnu/mapping/WrongType;
        //   271: dup_x1         
        //   272: swap           
        //   273: ldc             "cdr"
        //   275: iconst_1       
        //   276: aload           12
        //   278: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   281: athrow         
        //   282: new             Lgnu/mapping/WrongType;
        //   285: dup_x1         
        //   286: swap           
        //   287: ldc             "car"
        //   289: iconst_1       
        //   290: aload           12
        //   292: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   295: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  22     25     212    226    Ljava/lang/ClassCastException;
        //  60     63     226    240    Ljava/lang/ClassCastException;
        //  93     96     240    254    Ljava/lang/ClassCastException;
        //  104    110    254    268    Ljava/lang/ClassCastException;
        //  149    152    268    282    Ljava/lang/ClassCastException;
        //  165    168    282    296    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public static Object pregexpReadCharList(final Object s, final Object i, final Object n) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: aload_1         /* i */
        //     4: astore          4
        //     6: astore_3        /* r */
        //     7: aload           i
        //     9: aload_2         /* n */
        //    10: invokestatic    gnu/kawa/functions/NumberCompare.$Gr$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //    13: ifeq            39
        //    16: iconst_2       
        //    17: anewarray       Ljava/lang/Object;
        //    20: dup            
        //    21: iconst_0       
        //    22: getstatic       gnu/kawa/slib/pregexp.Lit45:Lgnu/mapping/SimpleSymbol;
        //    25: aastore        
        //    26: dup            
        //    27: iconst_1       
        //    28: getstatic       gnu/kawa/slib/pregexp.Lit46:Lgnu/mapping/SimpleSymbol;
        //    31: aastore        
        //    32: invokestatic    kawa/lib/exceptions.error:([Ljava/lang/Object;)Lgnu/bytecode/Type$NeverReturns;
        //    35: getstatic       gnu/expr/Special.reachedUnexpected:Ljava/lang/RuntimeException;
        //    38: athrow         
        //    39: aload_0         /* s */
        //    40: ldc             Ljava/lang/CharSequence;.class
        //    42: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    45: dup            
        //    46: astore          6
        //    48: checkcast       Ljava/lang/CharSequence;
        //    51: aload           i
        //    53: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //    56: dup            
        //    57: astore          6
        //    59: checkcast       Ljava/lang/Number;
        //    62: invokevirtual   java/lang/Number.intValue:()I
        //    65: invokestatic    kawa/lib/strings.stringRef:(Ljava/lang/CharSequence;I)I
        //    68: istore          c
        //    70: iload           c
        //    72: lookupswitch {
        //               45: 343
        //               91: 237
        //               92: 169
        //               93: 116
        //          default: 560
        //        }
        //   116: aload_3         /* r */
        //   117: invokestatic    kawa/lib/lists.isNull:(Ljava/lang/Object;)Z
        //   120: ifeq            144
        //   123: iload           c
        //   125: invokestatic    gnu/text/Char.make:(I)Lgnu/text/Char;
        //   128: aload_3         /* r */
        //   129: invokestatic    kawa/lib/lists.cons:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //   132: iconst_1       
        //   133: aload           i
        //   135: getstatic       gnu/kawa/slib/pregexp.Lit3:Lgnu/math/IntNum;
        //   138: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   141: goto            4
        //   144: getstatic       gnu/kawa/slib/pregexp.Lit47:Lgnu/mapping/SimpleSymbol;
        //   147: aload_3         /* r */
        //   148: invokestatic    gnu/kawa/slib/pregexp.pregexpReverse$Ex:(Ljava/lang/Object;)Ljava/lang/Object;
        //   151: invokestatic    kawa/lib/lists.cons:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //   154: iconst_1       
        //   155: aload           i
        //   157: getstatic       gnu/kawa/slib/pregexp.Lit3:Lgnu/math/IntNum;
        //   160: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   163: invokestatic    gnu/lists/LList.list2:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //   166: goto            581
        //   169: aload_0         /* s */
        //   170: aload           i
        //   172: aload_2         /* n */
        //   173: invokestatic    gnu/kawa/slib/pregexp.pregexpReadEscapedChar:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   176: astore          char$Mni
        //   178: aload           char$Mni
        //   180: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //   183: ifeq            214
        //   186: aload           char$Mni
        //   188: ldc             Lgnu/lists/Pair;.class
        //   190: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   193: dup            
        //   194: astore          7
        //   196: checkcast       Lgnu/lists/Pair;
        //   199: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   202: aload_3         /* r */
        //   203: invokestatic    kawa/lib/lists.cons:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //   206: aload           char$Mni
        //   208: invokestatic    kawa/lib/lists.cadr:(Ljava/lang/Object;)Ljava/lang/Object;
        //   211: goto            4
        //   214: iconst_2       
        //   215: anewarray       Ljava/lang/Object;
        //   218: dup            
        //   219: iconst_0       
        //   220: getstatic       gnu/kawa/slib/pregexp.Lit45:Lgnu/mapping/SimpleSymbol;
        //   223: aastore        
        //   224: dup            
        //   225: iconst_1       
        //   226: getstatic       gnu/kawa/slib/pregexp.Lit7:Lgnu/mapping/SimpleSymbol;
        //   229: aastore        
        //   230: invokestatic    kawa/lib/exceptions.error:([Ljava/lang/Object;)Lgnu/bytecode/Type$NeverReturns;
        //   233: getstatic       gnu/expr/Special.reachedUnexpected:Ljava/lang/RuntimeException;
        //   236: athrow         
        //   237: aload_0         /* s */
        //   238: ldc             Ljava/lang/CharSequence;.class
        //   240: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   243: dup            
        //   244: astore          6
        //   246: checkcast       Ljava/lang/CharSequence;
        //   249: iconst_1       
        //   250: aload           i
        //   252: getstatic       gnu/kawa/slib/pregexp.Lit3:Lgnu/math/IntNum;
        //   255: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   258: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   261: dup            
        //   262: astore          6
        //   264: checkcast       Ljava/lang/Number;
        //   267: invokevirtual   java/lang/Number.intValue:()I
        //   270: invokestatic    kawa/lib/strings.stringRef:(Ljava/lang/CharSequence;I)I
        //   273: bipush          58
        //   275: if_icmpne       322
        //   278: aload_0         /* s */
        //   279: iconst_1       
        //   280: aload           i
        //   282: getstatic       gnu/kawa/slib/pregexp.Lit11:Lgnu/math/IntNum;
        //   285: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   288: aload_2         /* n */
        //   289: invokestatic    gnu/kawa/slib/pregexp.pregexpReadPosixCharClass:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   292: astore          posix$Mnchar$Mnclass$Mni
        //   294: aload           posix$Mnchar$Mnclass$Mni
        //   296: ldc             Lgnu/lists/Pair;.class
        //   298: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   301: dup            
        //   302: astore          7
        //   304: checkcast       Lgnu/lists/Pair;
        //   307: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   310: aload_3         /* r */
        //   311: invokestatic    kawa/lib/lists.cons:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //   314: aload           posix$Mnchar$Mnclass$Mni
        //   316: invokestatic    kawa/lib/lists.cadr:(Ljava/lang/Object;)Ljava/lang/Object;
        //   319: goto            4
        //   322: iload           c
        //   324: invokestatic    gnu/text/Char.make:(I)Lgnu/text/Char;
        //   327: aload_3         /* r */
        //   328: invokestatic    kawa/lib/lists.cons:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //   331: iconst_1       
        //   332: aload           i
        //   334: getstatic       gnu/kawa/slib/pregexp.Lit3:Lgnu/math/IntNum;
        //   337: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   340: goto            4
        //   343: aload_3         /* r */
        //   344: invokestatic    kawa/lib/lists.isNull:(Ljava/lang/Object;)Z
        //   347: istore          x
        //   349: iload           x
        //   351: ifeq            362
        //   354: iload           x
        //   356: ifeq            437
        //   359: goto            416
        //   362: iconst_1       
        //   363: aload           i
        //   365: getstatic       gnu/kawa/slib/pregexp.Lit3:Lgnu/math/IntNum;
        //   368: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   371: astore          i$Pl1
        //   373: aload           i$Pl1
        //   375: aload_2         /* n */
        //   376: invokestatic    gnu/kawa/functions/NumberCompare.$Ls:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   379: ifeq            437
        //   382: aload_0         /* s */
        //   383: ldc             Ljava/lang/CharSequence;.class
        //   385: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   388: dup            
        //   389: astore          8
        //   391: checkcast       Ljava/lang/CharSequence;
        //   394: aload           i$Pl1
        //   396: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   399: dup            
        //   400: astore          8
        //   402: checkcast       Ljava/lang/Number;
        //   405: invokevirtual   java/lang/Number.intValue:()I
        //   408: invokestatic    kawa/lib/strings.stringRef:(Ljava/lang/CharSequence;I)I
        //   411: bipush          93
        //   413: if_icmpne       437
        //   416: iload           c
        //   418: invokestatic    gnu/text/Char.make:(I)Lgnu/text/Char;
        //   421: aload_3         /* r */
        //   422: invokestatic    kawa/lib/lists.cons:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //   425: iconst_1       
        //   426: aload           i
        //   428: getstatic       gnu/kawa/slib/pregexp.Lit3:Lgnu/math/IntNum;
        //   431: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   434: goto            4
        //   437: aload_3         /* r */
        //   438: ldc             Lgnu/lists/Pair;.class
        //   440: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   443: dup            
        //   444: astore          8
        //   446: checkcast       Lgnu/lists/Pair;
        //   449: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   452: astore          c$Mnprev
        //   454: aload           c$Mnprev
        //   456: invokestatic    kawa/lib/characters.isChar:(Ljava/lang/Object;)Z
        //   459: ifeq            539
        //   462: getstatic       gnu/kawa/slib/pregexp.Lit48:Lgnu/mapping/SimpleSymbol;
        //   465: aload           c$Mnprev
        //   467: aload_0         /* s */
        //   468: ldc             Ljava/lang/CharSequence;.class
        //   470: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   473: dup            
        //   474: astore          8
        //   476: checkcast       Ljava/lang/CharSequence;
        //   479: iconst_1       
        //   480: aload           i
        //   482: getstatic       gnu/kawa/slib/pregexp.Lit3:Lgnu/math/IntNum;
        //   485: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   488: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   491: dup            
        //   492: astore          8
        //   494: checkcast       Ljava/lang/Number;
        //   497: invokevirtual   java/lang/Number.intValue:()I
        //   500: invokestatic    kawa/lib/strings.stringRef:(Ljava/lang/CharSequence;I)I
        //   503: invokestatic    gnu/text/Char.make:(I)Lgnu/text/Char;
        //   506: invokestatic    gnu/lists/LList.list3:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //   509: aload_3         /* r */
        //   510: ldc             Lgnu/lists/Pair;.class
        //   512: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   515: dup            
        //   516: astore          8
        //   518: checkcast       Lgnu/lists/Pair;
        //   521: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   524: invokestatic    kawa/lib/lists.cons:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //   527: iconst_1       
        //   528: aload           i
        //   530: getstatic       gnu/kawa/slib/pregexp.Lit11:Lgnu/math/IntNum;
        //   533: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   536: goto            4
        //   539: iload           c
        //   541: invokestatic    gnu/text/Char.make:(I)Lgnu/text/Char;
        //   544: aload_3         /* r */
        //   545: invokestatic    kawa/lib/lists.cons:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //   548: iconst_1       
        //   549: aload           i
        //   551: getstatic       gnu/kawa/slib/pregexp.Lit3:Lgnu/math/IntNum;
        //   554: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   557: goto            4
        //   560: iload           c
        //   562: invokestatic    gnu/text/Char.make:(I)Lgnu/text/Char;
        //   565: aload_3         /* r */
        //   566: invokestatic    kawa/lib/lists.cons:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //   569: iconst_1       
        //   570: aload           i
        //   572: getstatic       gnu/kawa/slib/pregexp.Lit3:Lgnu/math/IntNum;
        //   575: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   578: goto            4
        //   581: areturn        
        //   582: new             Lgnu/mapping/WrongType;
        //   585: dup_x1         
        //   586: swap           
        //   587: ldc             "string-ref"
        //   589: iconst_1       
        //   590: aload           6
        //   592: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   595: athrow         
        //   596: new             Lgnu/mapping/WrongType;
        //   599: dup_x1         
        //   600: swap           
        //   601: ldc             "string-ref"
        //   603: iconst_2       
        //   604: aload           6
        //   606: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   609: athrow         
        //   610: new             Lgnu/mapping/WrongType;
        //   613: dup_x1         
        //   614: swap           
        //   615: ldc             "car"
        //   617: iconst_1       
        //   618: aload           7
        //   620: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   623: athrow         
        //   624: new             Lgnu/mapping/WrongType;
        //   627: dup_x1         
        //   628: swap           
        //   629: ldc             "string-ref"
        //   631: iconst_1       
        //   632: aload           6
        //   634: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   637: athrow         
        //   638: new             Lgnu/mapping/WrongType;
        //   641: dup_x1         
        //   642: swap           
        //   643: ldc             "string-ref"
        //   645: iconst_2       
        //   646: aload           6
        //   648: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   651: athrow         
        //   652: new             Lgnu/mapping/WrongType;
        //   655: dup_x1         
        //   656: swap           
        //   657: ldc             "car"
        //   659: iconst_1       
        //   660: aload           7
        //   662: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   665: athrow         
        //   666: new             Lgnu/mapping/WrongType;
        //   669: dup_x1         
        //   670: swap           
        //   671: ldc             "string-ref"
        //   673: iconst_1       
        //   674: aload           8
        //   676: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   679: athrow         
        //   680: new             Lgnu/mapping/WrongType;
        //   683: dup_x1         
        //   684: swap           
        //   685: ldc             "string-ref"
        //   687: iconst_2       
        //   688: aload           8
        //   690: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   693: athrow         
        //   694: new             Lgnu/mapping/WrongType;
        //   697: dup_x1         
        //   698: swap           
        //   699: ldc             "car"
        //   701: iconst_1       
        //   702: aload           8
        //   704: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   707: athrow         
        //   708: new             Lgnu/mapping/WrongType;
        //   711: dup_x1         
        //   712: swap           
        //   713: ldc             "string-ref"
        //   715: iconst_1       
        //   716: aload           8
        //   718: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   721: athrow         
        //   722: new             Lgnu/mapping/WrongType;
        //   725: dup_x1         
        //   726: swap           
        //   727: ldc             "string-ref"
        //   729: iconst_2       
        //   730: aload           8
        //   732: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   735: athrow         
        //   736: new             Lgnu/mapping/WrongType;
        //   739: dup_x1         
        //   740: swap           
        //   741: ldc             "cdr"
        //   743: iconst_1       
        //   744: aload           8
        //   746: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   749: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  48     51     582    596    Ljava/lang/ClassCastException;
        //  59     65     596    610    Ljava/lang/ClassCastException;
        //  196    199    610    624    Ljava/lang/ClassCastException;
        //  246    249    624    638    Ljava/lang/ClassCastException;
        //  264    270    638    652    Ljava/lang/ClassCastException;
        //  304    307    652    666    Ljava/lang/ClassCastException;
        //  391    394    666    680    Ljava/lang/ClassCastException;
        //  402    408    680    694    Ljava/lang/ClassCastException;
        //  446    449    694    708    Ljava/lang/ClassCastException;
        //  476    479    708    722    Ljava/lang/ClassCastException;
        //  494    500    722    736    Ljava/lang/ClassCastException;
        //  518    521    736    750    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public static Object pregexpReadPosixCharClass(final Object s, final Object i, final Object n) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: istore_3        /* neg$Qu */
        //     2: aload_1         /* i */
        //     3: getstatic       gnu/kawa/slib/pregexp.Lit23:Lgnu/text/Char;
        //     6: invokestatic    gnu/lists/LList.list1:(Ljava/lang/Object;)Lgnu/lists/Pair;
        //     9: astore          5
        //    11: astore          i
        //    13: aload           i
        //    15: aload_2         /* n */
        //    16: invokestatic    gnu/kawa/functions/NumberCompare.$Gr$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //    19: ifeq            39
        //    22: iconst_1       
        //    23: anewarray       Ljava/lang/Object;
        //    26: dup            
        //    27: iconst_0       
        //    28: getstatic       gnu/kawa/slib/pregexp.Lit24:Lgnu/mapping/SimpleSymbol;
        //    31: aastore        
        //    32: invokestatic    kawa/lib/exceptions.error:([Ljava/lang/Object;)Lgnu/bytecode/Type$NeverReturns;
        //    35: getstatic       gnu/expr/Special.reachedUnexpected:Ljava/lang/RuntimeException;
        //    38: athrow         
        //    39: aload_0         /* s */
        //    40: ldc             Ljava/lang/CharSequence;.class
        //    42: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    45: dup            
        //    46: astore          7
        //    48: checkcast       Ljava/lang/CharSequence;
        //    51: aload           i
        //    53: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //    56: dup            
        //    57: astore          7
        //    59: checkcast       Ljava/lang/Number;
        //    62: invokevirtual   java/lang/Number.intValue:()I
        //    65: invokestatic    kawa/lib/strings.stringRef:(Ljava/lang/CharSequence;I)I
        //    68: istore          c
        //    70: iload           c
        //    72: bipush          94
        //    74: if_icmpne       93
        //    77: iconst_1       
        //    78: istore_3        /* neg$Qu */
        //    79: iconst_1       
        //    80: aload           i
        //    82: getstatic       gnu/kawa/slib/pregexp.Lit3:Lgnu/math/IntNum;
        //    85: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    88: astore          i
        //    90: goto            13
        //    93: iload           c
        //    95: invokestatic    kawa/lib/rnrs/unicode.isCharAlphabetic:(I)Z
        //    98: ifeq            123
        //   101: iconst_1       
        //   102: aload           i
        //   104: getstatic       gnu/kawa/slib/pregexp.Lit3:Lgnu/math/IntNum;
        //   107: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   110: iload           c
        //   112: invokestatic    gnu/text/Char.make:(I)Lgnu/text/Char;
        //   115: aload           r
        //   117: invokestatic    kawa/lib/lists.cons:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //   120: goto            9
        //   123: iload           c
        //   125: bipush          58
        //   127: if_icmpne       272
        //   130: iconst_1       
        //   131: aload           i
        //   133: getstatic       gnu/kawa/slib/pregexp.Lit3:Lgnu/math/IntNum;
        //   136: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   139: aload_2         /* n */
        //   140: invokestatic    gnu/kawa/functions/NumberCompare.$Gr$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   143: istore          x
        //   145: iload           x
        //   147: ifeq            158
        //   150: iload           x
        //   152: ifeq            216
        //   155: goto            199
        //   158: aload_0         /* s */
        //   159: ldc             Ljava/lang/CharSequence;.class
        //   161: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   164: dup            
        //   165: astore          8
        //   167: checkcast       Ljava/lang/CharSequence;
        //   170: iconst_1       
        //   171: aload           i
        //   173: getstatic       gnu/kawa/slib/pregexp.Lit3:Lgnu/math/IntNum;
        //   176: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   179: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   182: dup            
        //   183: astore          8
        //   185: checkcast       Ljava/lang/Number;
        //   188: invokevirtual   java/lang/Number.intValue:()I
        //   191: invokestatic    kawa/lib/strings.stringRef:(Ljava/lang/CharSequence;I)I
        //   194: bipush          93
        //   196: if_icmpeq       216
        //   199: iconst_1       
        //   200: anewarray       Ljava/lang/Object;
        //   203: dup            
        //   204: iconst_0       
        //   205: getstatic       gnu/kawa/slib/pregexp.Lit24:Lgnu/mapping/SimpleSymbol;
        //   208: aastore        
        //   209: invokestatic    kawa/lib/exceptions.error:([Ljava/lang/Object;)Lgnu/bytecode/Type$NeverReturns;
        //   212: getstatic       gnu/expr/Special.reachedUnexpected:Ljava/lang/RuntimeException;
        //   215: athrow         
        //   216: aload           r
        //   218: invokestatic    gnu/kawa/slib/pregexp.pregexpReverse$Ex:(Ljava/lang/Object;)Ljava/lang/Object;
        //   221: ldc             Lgnu/lists/LList;.class
        //   223: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   226: dup            
        //   227: astore          9
        //   229: checkcast       Lgnu/lists/LList;
        //   232: invokestatic    kawa/lib/strings.list$To$String:(Lgnu/lists/LList;)Ljava/lang/CharSequence;
        //   235: invokestatic    kawa/lib/misc.string$To$Symbol:(Ljava/lang/CharSequence;)Lgnu/mapping/SimpleSymbol;
        //   238: astore          posix$Mnclass
        //   240: iload_3         /* neg$Qu */
        //   241: ifeq            255
        //   244: getstatic       gnu/kawa/slib/pregexp.Lit12:Lgnu/mapping/SimpleSymbol;
        //   247: aload           posix$Mnclass
        //   249: invokestatic    gnu/lists/LList.list2:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //   252: goto            257
        //   255: aload           posix$Mnclass
        //   257: iconst_1       
        //   258: aload           i
        //   260: getstatic       gnu/kawa/slib/pregexp.Lit11:Lgnu/math/IntNum;
        //   263: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   266: invokestatic    gnu/lists/LList.list2:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //   269: goto            289
        //   272: iconst_1       
        //   273: anewarray       Ljava/lang/Object;
        //   276: dup            
        //   277: iconst_0       
        //   278: getstatic       gnu/kawa/slib/pregexp.Lit24:Lgnu/mapping/SimpleSymbol;
        //   281: aastore        
        //   282: invokestatic    kawa/lib/exceptions.error:([Ljava/lang/Object;)Lgnu/bytecode/Type$NeverReturns;
        //   285: getstatic       gnu/expr/Special.reachedUnexpected:Ljava/lang/RuntimeException;
        //   288: athrow         
        //   289: areturn        
        //   290: new             Lgnu/mapping/WrongType;
        //   293: dup_x1         
        //   294: swap           
        //   295: ldc             "string-ref"
        //   297: iconst_1       
        //   298: aload           7
        //   300: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   303: athrow         
        //   304: new             Lgnu/mapping/WrongType;
        //   307: dup_x1         
        //   308: swap           
        //   309: ldc             "string-ref"
        //   311: iconst_2       
        //   312: aload           7
        //   314: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   317: athrow         
        //   318: new             Lgnu/mapping/WrongType;
        //   321: dup_x1         
        //   322: swap           
        //   323: ldc             "string-ref"
        //   325: iconst_1       
        //   326: aload           8
        //   328: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   331: athrow         
        //   332: new             Lgnu/mapping/WrongType;
        //   335: dup_x1         
        //   336: swap           
        //   337: ldc             "string-ref"
        //   339: iconst_2       
        //   340: aload           8
        //   342: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   345: athrow         
        //   346: new             Lgnu/mapping/WrongType;
        //   349: dup_x1         
        //   350: swap           
        //   351: ldc             "list->string"
        //   353: iconst_1       
        //   354: aload           9
        //   356: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   359: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  48     51     290    304    Ljava/lang/ClassCastException;
        //  59     65     304    318    Ljava/lang/ClassCastException;
        //  167    170    318    332    Ljava/lang/ClassCastException;
        //  185    191    332    346    Ljava/lang/ClassCastException;
        //  229    232    346    360    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public static Object pregexpReadClusterType(final Object s, final Object i, final Object n) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             Ljava/lang/CharSequence;.class
        //     3: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //     6: dup            
        //     7: astore          4
        //     9: checkcast       Ljava/lang/CharSequence;
        //    12: aload_1         /* i */
        //    13: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //    16: dup            
        //    17: astore          4
        //    19: checkcast       Ljava/lang/Number;
        //    22: invokevirtual   java/lang/Number.intValue:()I
        //    25: invokestatic    kawa/lib/strings.stringRef:(Ljava/lang/CharSequence;I)I
        //    28: istore_3        /* c */
        //    29: iload_3         /* c */
        //    30: bipush          63
        //    32: if_icmpne       521
        //    35: goto            38
        //    38: iconst_1       
        //    39: aload_1         /* i */
        //    40: getstatic       gnu/kawa/slib/pregexp.Lit3:Lgnu/math/IntNum;
        //    43: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    46: astore          i
        //    48: aload_0         /* s */
        //    49: ldc             Ljava/lang/CharSequence;.class
        //    51: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    54: dup            
        //    55: astore          6
        //    57: checkcast       Ljava/lang/CharSequence;
        //    60: aload           i
        //    62: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //    65: dup            
        //    66: astore          6
        //    68: checkcast       Ljava/lang/Number;
        //    71: invokevirtual   java/lang/Number.intValue:()I
        //    74: invokestatic    kawa/lib/strings.stringRef:(Ljava/lang/CharSequence;I)I
        //    77: istore          tmp
        //    79: iload           tmp
        //    81: lookupswitch {
        //               33: 132
        //               58: 150
        //               60: 204
        //               61: 186
        //               62: 168
        //          default: 316
        //        }
        //   132: getstatic       gnu/kawa/slib/pregexp.Lit25:Lgnu/lists/PairWithPosition;
        //   135: iconst_1       
        //   136: aload           i
        //   138: getstatic       gnu/kawa/slib/pregexp.Lit3:Lgnu/math/IntNum;
        //   141: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   144: invokestatic    gnu/lists/LList.list2:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //   147: goto            531
        //   150: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
        //   153: iconst_1       
        //   154: aload           i
        //   156: getstatic       gnu/kawa/slib/pregexp.Lit3:Lgnu/math/IntNum;
        //   159: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   162: invokestatic    gnu/lists/LList.list2:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //   165: goto            531
        //   168: getstatic       gnu/kawa/slib/pregexp.Lit26:Lgnu/lists/PairWithPosition;
        //   171: iconst_1       
        //   172: aload           i
        //   174: getstatic       gnu/kawa/slib/pregexp.Lit3:Lgnu/math/IntNum;
        //   177: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   180: invokestatic    gnu/lists/LList.list2:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //   183: goto            531
        //   186: getstatic       gnu/kawa/slib/pregexp.Lit27:Lgnu/lists/PairWithPosition;
        //   189: iconst_1       
        //   190: aload           i
        //   192: getstatic       gnu/kawa/slib/pregexp.Lit3:Lgnu/math/IntNum;
        //   195: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   198: invokestatic    gnu/lists/LList.list2:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //   201: goto            531
        //   204: aload_0         /* s */
        //   205: ldc             Ljava/lang/CharSequence;.class
        //   207: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   210: dup            
        //   211: astore          7
        //   213: checkcast       Ljava/lang/CharSequence;
        //   216: iconst_1       
        //   217: aload           i
        //   219: getstatic       gnu/kawa/slib/pregexp.Lit3:Lgnu/math/IntNum;
        //   222: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   225: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   228: dup            
        //   229: astore          7
        //   231: checkcast       Ljava/lang/Number;
        //   234: invokevirtual   java/lang/Number.intValue:()I
        //   237: invokestatic    kawa/lib/strings.stringRef:(Ljava/lang/CharSequence;I)I
        //   240: istore          tmp
        //   242: iload           tmp
        //   244: lookupswitch {
        //               33: 272
        //               61: 278
        //          default: 284
        //        }
        //   272: getstatic       gnu/kawa/slib/pregexp.Lit28:Lgnu/lists/PairWithPosition;
        //   275: goto            301
        //   278: getstatic       gnu/kawa/slib/pregexp.Lit29:Lgnu/lists/PairWithPosition;
        //   281: goto            301
        //   284: iconst_1       
        //   285: anewarray       Ljava/lang/Object;
        //   288: dup            
        //   289: iconst_0       
        //   290: getstatic       gnu/kawa/slib/pregexp.Lit30:Lgnu/mapping/SimpleSymbol;
        //   293: aastore        
        //   294: invokestatic    kawa/lib/exceptions.error:([Ljava/lang/Object;)Lgnu/bytecode/Type$NeverReturns;
        //   297: getstatic       gnu/expr/Special.reachedUnexpected:Ljava/lang/RuntimeException;
        //   300: athrow         
        //   301: iconst_1       
        //   302: aload           i
        //   304: getstatic       gnu/kawa/slib/pregexp.Lit11:Lgnu/math/IntNum;
        //   307: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   310: invokestatic    gnu/lists/LList.list2:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //   313: goto            531
        //   316: aload           i
        //   318: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
        //   321: iconst_0       
        //   322: istore          8
        //   324: astore          7
        //   326: astore          i
        //   328: aload_0         /* s */
        //   329: ldc             Ljava/lang/CharSequence;.class
        //   331: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   334: dup            
        //   335: astore          10
        //   337: checkcast       Ljava/lang/CharSequence;
        //   340: aload           i
        //   342: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   345: dup            
        //   346: astore          10
        //   348: checkcast       Ljava/lang/Number;
        //   351: invokevirtual   java/lang/Number.intValue:()I
        //   354: invokestatic    kawa/lib/strings.stringRef:(Ljava/lang/CharSequence;I)I
        //   357: istore          c
        //   359: iload           c
        //   361: lookupswitch {
        //               45: 487
        //               58: 404
        //              105: 455
        //              120: 421
        //          default: 504
        //        }
        //   404: aload           r
        //   406: iconst_1       
        //   407: aload           i
        //   409: getstatic       gnu/kawa/slib/pregexp.Lit3:Lgnu/math/IntNum;
        //   412: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   415: invokestatic    gnu/lists/LList.list2:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //   418: goto            531
        //   421: iload           inv$Qu
        //   423: ifeq            432
        //   426: getstatic       java/lang/Boolean.TRUE:Ljava/lang/Boolean;
        //   429: goto            435
        //   432: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //   435: putstatic       gnu/kawa/slib/pregexp.$Stpregexp$Mnspace$Mnsensitive$Qu$St:Ljava/lang/Object;
        //   438: iconst_1       
        //   439: aload           i
        //   441: getstatic       gnu/kawa/slib/pregexp.Lit3:Lgnu/math/IntNum;
        //   444: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   447: iconst_0       
        //   448: istore          inv$Qu
        //   450: astore          i
        //   452: goto            328
        //   455: iconst_1       
        //   456: aload           i
        //   458: getstatic       gnu/kawa/slib/pregexp.Lit3:Lgnu/math/IntNum;
        //   461: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   464: iload           inv$Qu
        //   466: ifeq            475
        //   469: getstatic       gnu/kawa/slib/pregexp.Lit31:Lgnu/mapping/SimpleSymbol;
        //   472: goto            478
        //   475: getstatic       gnu/kawa/slib/pregexp.Lit32:Lgnu/mapping/SimpleSymbol;
        //   478: aload           r
        //   480: invokestatic    kawa/lib/lists.cons:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //   483: iconst_0       
        //   484: goto            322
        //   487: iconst_1       
        //   488: aload           i
        //   490: getstatic       gnu/kawa/slib/pregexp.Lit3:Lgnu/math/IntNum;
        //   493: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   496: iconst_1       
        //   497: istore          inv$Qu
        //   499: astore          i
        //   501: goto            328
        //   504: iconst_1       
        //   505: anewarray       Ljava/lang/Object;
        //   508: dup            
        //   509: iconst_0       
        //   510: getstatic       gnu/kawa/slib/pregexp.Lit30:Lgnu/mapping/SimpleSymbol;
        //   513: aastore        
        //   514: invokestatic    kawa/lib/exceptions.error:([Ljava/lang/Object;)Lgnu/bytecode/Type$NeverReturns;
        //   517: getstatic       gnu/expr/Special.reachedUnexpected:Ljava/lang/RuntimeException;
        //   520: athrow         
        //   521: getstatic       gnu/kawa/slib/pregexp.Lit33:Lgnu/lists/PairWithPosition;
        //   524: aload_1         /* i */
        //   525: invokestatic    gnu/lists/LList.list2:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //   528: goto            531
        //   531: areturn        
        //   532: new             Lgnu/mapping/WrongType;
        //   535: dup_x1         
        //   536: swap           
        //   537: ldc             "string-ref"
        //   539: iconst_1       
        //   540: aload           4
        //   542: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   545: athrow         
        //   546: new             Lgnu/mapping/WrongType;
        //   549: dup_x1         
        //   550: swap           
        //   551: ldc             "string-ref"
        //   553: iconst_2       
        //   554: aload           4
        //   556: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   559: athrow         
        //   560: new             Lgnu/mapping/WrongType;
        //   563: dup_x1         
        //   564: swap           
        //   565: ldc             "string-ref"
        //   567: iconst_1       
        //   568: aload           6
        //   570: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   573: athrow         
        //   574: new             Lgnu/mapping/WrongType;
        //   577: dup_x1         
        //   578: swap           
        //   579: ldc             "string-ref"
        //   581: iconst_2       
        //   582: aload           6
        //   584: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   587: athrow         
        //   588: new             Lgnu/mapping/WrongType;
        //   591: dup_x1         
        //   592: swap           
        //   593: ldc             "string-ref"
        //   595: iconst_1       
        //   596: aload           7
        //   598: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   601: athrow         
        //   602: new             Lgnu/mapping/WrongType;
        //   605: dup_x1         
        //   606: swap           
        //   607: ldc             "string-ref"
        //   609: iconst_2       
        //   610: aload           7
        //   612: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   615: athrow         
        //   616: new             Lgnu/mapping/WrongType;
        //   619: dup_x1         
        //   620: swap           
        //   621: ldc             "string-ref"
        //   623: iconst_1       
        //   624: aload           10
        //   626: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   629: athrow         
        //   630: new             Lgnu/mapping/WrongType;
        //   633: dup_x1         
        //   634: swap           
        //   635: ldc             "string-ref"
        //   637: iconst_2       
        //   638: aload           10
        //   640: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   643: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  9      12     532    546    Ljava/lang/ClassCastException;
        //  19     25     546    560    Ljava/lang/ClassCastException;
        //  57     60     560    574    Ljava/lang/ClassCastException;
        //  68     74     574    588    Ljava/lang/ClassCastException;
        //  213    216    588    602    Ljava/lang/ClassCastException;
        //  231    237    602    616    Ljava/lang/ClassCastException;
        //  337    340    616    630    Ljava/lang/ClassCastException;
        //  348    354    630    644    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public static Object pregexpReadNums(final Object s, final Object i, final Object n) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
        //     6: aload_1         /* i */
        //     7: getstatic       gnu/kawa/slib/pregexp.Lit3:Lgnu/math/IntNum;
        //    10: astore          6
        //    12: astore          5
        //    14: astore          4
        //    16: astore_3        /* p */
        //    17: aload           k
        //    19: aload_2         /* n */
        //    20: invokestatic    gnu/kawa/functions/NumberCompare.$Gr$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //    23: ifeq            43
        //    26: iconst_1       
        //    27: anewarray       Ljava/lang/Object;
        //    30: dup            
        //    31: iconst_0       
        //    32: getstatic       gnu/kawa/slib/pregexp.Lit43:Lgnu/mapping/SimpleSymbol;
        //    35: aastore        
        //    36: invokestatic    kawa/lib/exceptions.error:([Ljava/lang/Object;)Lgnu/bytecode/Type$NeverReturns;
        //    39: getstatic       gnu/expr/Special.reachedUnexpected:Ljava/lang/RuntimeException;
        //    42: athrow         
        //    43: aload_0         /* s */
        //    44: ldc             Ljava/lang/CharSequence;.class
        //    46: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    49: dup            
        //    50: astore          8
        //    52: checkcast       Ljava/lang/CharSequence;
        //    55: aload           k
        //    57: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //    60: dup            
        //    61: astore          8
        //    63: checkcast       Ljava/lang/Number;
        //    66: invokevirtual   java/lang/Number.intValue:()I
        //    69: invokestatic    kawa/lib/strings.stringRef:(Ljava/lang/CharSequence;I)I
        //    72: istore          c
        //    74: iload           c
        //    76: invokestatic    kawa/lib/rnrs/unicode.isCharNumeric:(I)Z
        //    79: ifeq            153
        //    82: aload           reading
        //    84: getstatic       gnu/kawa/slib/pregexp.Lit3:Lgnu/math/IntNum;
        //    87: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //    90: ifeq            122
        //    93: iload           c
        //    95: invokestatic    gnu/text/Char.make:(I)Lgnu/text/Char;
        //    98: aload_3         /* p */
        //    99: invokestatic    kawa/lib/lists.cons:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //   102: iconst_1       
        //   103: aload           k
        //   105: getstatic       gnu/kawa/slib/pregexp.Lit3:Lgnu/math/IntNum;
        //   108: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   111: getstatic       gnu/kawa/slib/pregexp.Lit3:Lgnu/math/IntNum;
        //   114: astore          reading
        //   116: astore          k
        //   118: astore_3        /* p */
        //   119: goto            17
        //   122: iload           c
        //   124: invokestatic    gnu/text/Char.make:(I)Lgnu/text/Char;
        //   127: aload           q
        //   129: invokestatic    kawa/lib/lists.cons:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //   132: iconst_1       
        //   133: aload           k
        //   135: getstatic       gnu/kawa/slib/pregexp.Lit3:Lgnu/math/IntNum;
        //   138: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   141: getstatic       gnu/kawa/slib/pregexp.Lit11:Lgnu/math/IntNum;
        //   144: astore          reading
        //   146: astore          k
        //   148: astore          q
        //   150: goto            17
        //   153: iload           c
        //   155: invokestatic    kawa/lib/rnrs/unicode.isCharWhitespace:(I)Z
        //   158: ifeq            184
        //   161: getstatic       gnu/kawa/slib/pregexp.$Stpregexp$Mnspace$Mnsensitive$Qu$St:Ljava/lang/Object;
        //   164: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //   167: ifne            184
        //   170: iconst_1       
        //   171: aload           k
        //   173: getstatic       gnu/kawa/slib/pregexp.Lit3:Lgnu/math/IntNum;
        //   176: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   179: astore          k
        //   181: goto            17
        //   184: iload           c
        //   186: bipush          44
        //   188: if_icmpne       221
        //   191: aload           reading
        //   193: getstatic       gnu/kawa/slib/pregexp.Lit3:Lgnu/math/IntNum;
        //   196: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   199: ifeq            221
        //   202: iconst_1       
        //   203: aload           k
        //   205: getstatic       gnu/kawa/slib/pregexp.Lit3:Lgnu/math/IntNum;
        //   208: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   211: getstatic       gnu/kawa/slib/pregexp.Lit11:Lgnu/math/IntNum;
        //   214: astore          reading
        //   216: astore          k
        //   218: goto            17
        //   221: iload           c
        //   223: bipush          125
        //   225: if_icmpne       343
        //   228: aload_3         /* p */
        //   229: invokestatic    gnu/kawa/slib/pregexp.pregexpReverse$Ex:(Ljava/lang/Object;)Ljava/lang/Object;
        //   232: ldc             Lgnu/lists/LList;.class
        //   234: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   237: dup            
        //   238: astore          9
        //   240: checkcast       Lgnu/lists/LList;
        //   243: invokestatic    kawa/lib/strings.list$To$String:(Lgnu/lists/LList;)Ljava/lang/CharSequence;
        //   246: invokestatic    kawa/lib/numbers.string$To$Number:(Ljava/lang/CharSequence;)Ljava/lang/Object;
        //   249: astore          8
        //   251: aload           q
        //   253: invokestatic    gnu/kawa/slib/pregexp.pregexpReverse$Ex:(Ljava/lang/Object;)Ljava/lang/Object;
        //   256: ldc             Lgnu/lists/LList;.class
        //   258: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   261: dup            
        //   262: astore          10
        //   264: checkcast       Lgnu/lists/LList;
        //   267: invokestatic    kawa/lib/strings.list$To$String:(Lgnu/lists/LList;)Ljava/lang/CharSequence;
        //   270: invokestatic    kawa/lib/numbers.string$To$Number:(Ljava/lang/CharSequence;)Ljava/lang/Object;
        //   273: astore          q
        //   275: aload           p
        //   277: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //   280: ifne            308
        //   283: aload           reading
        //   285: getstatic       gnu/kawa/slib/pregexp.Lit3:Lgnu/math/IntNum;
        //   288: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   291: ifeq            308
        //   294: getstatic       gnu/kawa/slib/pregexp.Lit40:Lgnu/math/IntNum;
        //   297: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //   300: aload           k
        //   302: invokestatic    gnu/lists/LList.list3:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //   305: goto            346
        //   308: aload           reading
        //   310: getstatic       gnu/kawa/slib/pregexp.Lit3:Lgnu/math/IntNum;
        //   313: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   316: ifeq            331
        //   319: aload           p
        //   321: aload           p
        //   323: aload           k
        //   325: invokestatic    gnu/lists/LList.list3:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //   328: goto            346
        //   331: aload           p
        //   333: aload           q
        //   335: aload           k
        //   337: invokestatic    gnu/lists/LList.list3:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //   340: goto            346
        //   343: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //   346: areturn        
        //   347: new             Lgnu/mapping/WrongType;
        //   350: dup_x1         
        //   351: swap           
        //   352: ldc             "string-ref"
        //   354: iconst_1       
        //   355: aload           8
        //   357: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   360: athrow         
        //   361: new             Lgnu/mapping/WrongType;
        //   364: dup_x1         
        //   365: swap           
        //   366: ldc             "string-ref"
        //   368: iconst_2       
        //   369: aload           8
        //   371: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   374: athrow         
        //   375: new             Lgnu/mapping/WrongType;
        //   378: dup_x1         
        //   379: swap           
        //   380: ldc             "list->string"
        //   382: iconst_1       
        //   383: aload           9
        //   385: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   388: athrow         
        //   389: new             Lgnu/mapping/WrongType;
        //   392: dup_x1         
        //   393: swap           
        //   394: ldc             "list->string"
        //   396: iconst_1       
        //   397: aload           10
        //   399: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   402: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  52     55     347    361    Ljava/lang/ClassCastException;
        //  63     69     361    375    Ljava/lang/ClassCastException;
        //  240    243    375    389    Ljava/lang/ClassCastException;
        //  264    267    389    403    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public static Object pregexpInvertCharList(final Object vv) {
        Object o2;
        final Object o = o2 = Promise.force(vv, Pair.class);
        Object o3;
        try {
            o3 = (o2 = Promise.force(lists.car((Pair)o), Pair.class));
            final Pair pair = (Pair)o3;
            final SimpleSymbol simpleSymbol = gnu.kawa.slib.pregexp.Lit44;
            lists.setCar$Ex(pair, simpleSymbol);
            return vv;
        }
        catch (ClassCastException ex) {
            throw new WrongType(ex, "car", 1, o2);
        }
        try {
            final Pair pair = (Pair)o3;
            final SimpleSymbol simpleSymbol = gnu.kawa.slib.pregexp.Lit44;
            lists.setCar$Ex(pair, simpleSymbol);
            return vv;
        }
        catch (ClassCastException ex2) {
            throw new WrongType(ex2, "set-car!", 1, o2);
        }
    }
    
    public static Object pregexpStringMatch(final Object s1, final Object s, final Object i, final Object n, final Object sk, final Object fk) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             Ljava/lang/CharSequence;.class
        //     3: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //     6: dup            
        //     7: astore          7
        //     9: checkcast       Ljava/lang/CharSequence;
        //    12: invokestatic    kawa/lib/strings.stringLength:(Ljava/lang/CharSequence;)I
        //    15: istore          n1
        //    17: iload           n1
        //    19: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //    22: aload_3         /* n */
        //    23: invokestatic    gnu/kawa/functions/NumberCompare.$Gr:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //    26: ifeq            40
        //    29: getstatic       kawa/standard/Scheme.applyToArgs:Lgnu/kawa/functions/ApplyToArgs;
        //    32: aload           fk
        //    34: invokevirtual   gnu/mapping/Procedure.apply1:(Ljava/lang/Object;)Ljava/lang/Object;
        //    37: goto            173
        //    40: getstatic       gnu/kawa/slib/pregexp.Lit40:Lgnu/math/IntNum;
        //    43: aload_2         /* i */
        //    44: astore          8
        //    46: astore          j
        //    48: aload           j
        //    50: iload           n1
        //    52: i2l            
        //    53: invokestatic    gnu/math/IntNum.compare:(Lgnu/math/IntNum;J)I
        //    56: iflt            72
        //    59: getstatic       kawa/standard/Scheme.applyToArgs:Lgnu/kawa/functions/ApplyToArgs;
        //    62: aload           sk
        //    64: aload           k
        //    66: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    69: goto            173
        //    72: aload           k
        //    74: aload_3         /* n */
        //    75: invokestatic    gnu/kawa/functions/NumberCompare.$Gr$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //    78: ifeq            92
        //    81: getstatic       kawa/standard/Scheme.applyToArgs:Lgnu/kawa/functions/ApplyToArgs;
        //    84: aload           fk
        //    86: invokevirtual   gnu/mapping/Procedure.apply1:(Ljava/lang/Object;)Ljava/lang/Object;
        //    89: goto            173
        //    92: aload_0         /* s1 */
        //    93: ldc             Ljava/lang/CharSequence;.class
        //    95: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    98: dup            
        //    99: astore          9
        //   101: checkcast       Ljava/lang/CharSequence;
        //   104: aload           j
        //   106: dup            
        //   107: astore          9
        //   109: invokevirtual   java/lang/Number.intValue:()I
        //   112: invokestatic    kawa/lib/strings.stringRef:(Ljava/lang/CharSequence;I)I
        //   115: aload_1         /* s */
        //   116: ldc             Ljava/lang/CharSequence;.class
        //   118: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   121: dup            
        //   122: astore          9
        //   124: checkcast       Ljava/lang/CharSequence;
        //   127: aload           k
        //   129: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   132: dup            
        //   133: astore          9
        //   135: checkcast       Ljava/lang/Number;
        //   138: invokevirtual   java/lang/Number.intValue:()I
        //   141: invokestatic    kawa/lib/strings.stringRef:(Ljava/lang/CharSequence;I)I
        //   144: if_icmpne       165
        //   147: aload           j
        //   149: iconst_1       
        //   150: invokestatic    gnu/math/IntNum.add:(Lgnu/math/IntNum;I)Lgnu/math/IntNum;
        //   153: iconst_1       
        //   154: aload           k
        //   156: getstatic       gnu/kawa/slib/pregexp.Lit3:Lgnu/math/IntNum;
        //   159: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   162: goto            44
        //   165: getstatic       kawa/standard/Scheme.applyToArgs:Lgnu/kawa/functions/ApplyToArgs;
        //   168: aload           fk
        //   170: invokevirtual   gnu/mapping/Procedure.apply1:(Ljava/lang/Object;)Ljava/lang/Object;
        //   173: areturn        
        //   174: new             Lgnu/mapping/WrongType;
        //   177: dup_x1         
        //   178: swap           
        //   179: ldc_w           "string-length"
        //   182: iconst_1       
        //   183: aload           7
        //   185: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   188: athrow         
        //   189: new             Lgnu/mapping/WrongType;
        //   192: dup_x1         
        //   193: swap           
        //   194: ldc             "string-ref"
        //   196: iconst_1       
        //   197: aload           9
        //   199: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   202: athrow         
        //   203: new             Lgnu/mapping/WrongType;
        //   206: dup_x1         
        //   207: swap           
        //   208: ldc             "string-ref"
        //   210: iconst_2       
        //   211: aload           9
        //   213: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   216: athrow         
        //   217: new             Lgnu/mapping/WrongType;
        //   220: dup_x1         
        //   221: swap           
        //   222: ldc             "string-ref"
        //   224: iconst_1       
        //   225: aload           9
        //   227: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   230: athrow         
        //   231: new             Lgnu/mapping/WrongType;
        //   234: dup_x1         
        //   235: swap           
        //   236: ldc             "string-ref"
        //   238: iconst_2       
        //   239: aload           9
        //   241: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   244: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  9      12     174    189    Ljava/lang/ClassCastException;
        //  101    104    189    203    Ljava/lang/ClassCastException;
        //  109    112    203    217    Ljava/lang/ClassCastException;
        //  124    127    217    231    Ljava/lang/ClassCastException;
        //  135    141    231    245    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public static boolean isPregexpCharWord(final Object c) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //     4: dup            
        //     5: astore_2       
        //     6: invokestatic    gnu/text/Char.castToCharacter:(Ljava/lang/Object;)I
        //     9: invokestatic    kawa/lib/rnrs/unicode.isCharAlphabetic:(I)Z
        //    12: istore_1        /* x */
        //    13: iload_1         /* x */
        //    14: ifeq            21
        //    17: iload_1         /* x */
        //    18: goto            59
        //    21: aload_0         /* c */
        //    22: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //    25: dup            
        //    26: astore_3       
        //    27: invokestatic    gnu/text/Char.castToCharacter:(Ljava/lang/Object;)I
        //    30: invokestatic    kawa/lib/rnrs/unicode.isCharNumeric:(I)Z
        //    33: istore_2        /* x */
        //    34: iload_2         /* x */
        //    35: ifeq            42
        //    38: iload_2         /* x */
        //    39: goto            59
        //    42: aload_0         /* c */
        //    43: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //    46: invokestatic    gnu/text/Char.castToCharacter:(Ljava/lang/Object;)I
        //    49: bipush          95
        //    51: if_icmpne       58
        //    54: iconst_1       
        //    55: goto            59
        //    58: iconst_0       
        //    59: ireturn        
        //    60: new             Lgnu/mapping/WrongType;
        //    63: dup_x1         
        //    64: swap           
        //    65: ldc_w           "char-alphabetic?"
        //    68: iconst_1       
        //    69: aload_2        
        //    70: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //    73: athrow         
        //    74: new             Lgnu/mapping/WrongType;
        //    77: dup_x1         
        //    78: swap           
        //    79: ldc_w           "char-numeric?"
        //    82: iconst_1       
        //    83: aload_3        
        //    84: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //    87: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  6      9      60     74     Ljava/lang/ClassCastException;
        //  27     30     74     88     Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0042:
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
    
    public static boolean isPregexpAtWordBoundary(final Object s, final Object i, final Object n) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getstatic       gnu/kawa/slib/pregexp.Lit40:Lgnu/math/IntNum;
        //     4: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //     7: istore_3        /* x */
        //     8: iload_3         /* x */
        //     9: ifeq            16
        //    12: iload_3         /* x */
        //    13: goto            168
        //    16: aload_1         /* i */
        //    17: aload_2         /* n */
        //    18: invokestatic    gnu/kawa/functions/NumberCompare.$Gr$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //    21: istore          x
        //    23: iload           x
        //    25: ifeq            33
        //    28: iload           x
        //    30: goto            168
        //    33: aload_0         /* s */
        //    34: ldc             Ljava/lang/CharSequence;.class
        //    36: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    39: dup            
        //    40: astore          6
        //    42: checkcast       Ljava/lang/CharSequence;
        //    45: aload_1         /* i */
        //    46: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //    49: dup            
        //    50: astore          6
        //    52: checkcast       Ljava/lang/Number;
        //    55: invokevirtual   java/lang/Number.intValue:()I
        //    58: invokestatic    kawa/lib/strings.stringRef:(Ljava/lang/CharSequence;I)I
        //    61: istore          5
        //    63: aload_0         /* s */
        //    64: ldc             Ljava/lang/CharSequence;.class
        //    66: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    69: dup            
        //    70: astore          7
        //    72: checkcast       Ljava/lang/CharSequence;
        //    75: iconst_m1      
        //    76: aload_1         /* i */
        //    77: getstatic       gnu/kawa/slib/pregexp.Lit3:Lgnu/math/IntNum;
        //    80: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    83: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //    86: dup            
        //    87: astore          7
        //    89: checkcast       Ljava/lang/Number;
        //    92: invokevirtual   java/lang/Number.intValue:()I
        //    95: invokestatic    kawa/lib/strings.stringRef:(Ljava/lang/CharSequence;I)I
        //    98: istore          c$Sli$Mn1
        //   100: iload           c$Sli
        //   102: invokestatic    gnu/text/Char.make:(I)Lgnu/text/Char;
        //   105: getstatic       gnu/kawa/slib/pregexp.Lit14:Lgnu/mapping/SimpleSymbol;
        //   108: invokestatic    gnu/kawa/slib/pregexp.isPregexpCheckIfInCharClass:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   111: istore          7
        //   113: iload           c$Sli$Mn1
        //   115: invokestatic    gnu/text/Char.make:(I)Lgnu/text/Char;
        //   118: getstatic       gnu/kawa/slib/pregexp.Lit14:Lgnu/mapping/SimpleSymbol;
        //   121: invokestatic    gnu/kawa/slib/pregexp.isPregexpCheckIfInCharClass:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   124: istore          c$Sli$Mn1$Slw$Qu
        //   126: iload           c$Sli$Slw$Qu
        //   128: ifeq            144
        //   131: iload           c$Sli$Mn1$Slw$Qu
        //   133: ifeq            140
        //   136: iconst_0       
        //   137: goto            145
        //   140: iconst_1       
        //   141: goto            145
        //   144: iconst_0       
        //   145: istore          x
        //   147: iload           x
        //   149: ifeq            157
        //   152: iload           x
        //   154: goto            168
        //   157: iload           c$Sli$Slw$Qu
        //   159: ifne            167
        //   162: iload           c$Sli$Mn1$Slw$Qu
        //   164: goto            168
        //   167: iconst_0       
        //   168: ireturn        
        //   169: new             Lgnu/mapping/WrongType;
        //   172: dup_x1         
        //   173: swap           
        //   174: ldc             "string-ref"
        //   176: iconst_1       
        //   177: aload           6
        //   179: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   182: athrow         
        //   183: new             Lgnu/mapping/WrongType;
        //   186: dup_x1         
        //   187: swap           
        //   188: ldc             "string-ref"
        //   190: iconst_2       
        //   191: aload           6
        //   193: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   196: athrow         
        //   197: new             Lgnu/mapping/WrongType;
        //   200: dup_x1         
        //   201: swap           
        //   202: ldc             "string-ref"
        //   204: iconst_1       
        //   205: aload           7
        //   207: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   210: athrow         
        //   211: new             Lgnu/mapping/WrongType;
        //   214: dup_x1         
        //   215: swap           
        //   216: ldc             "string-ref"
        //   218: iconst_2       
        //   219: aload           7
        //   221: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   224: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  42     45     169    183    Ljava/lang/ClassCastException;
        //  52     58     183    197    Ljava/lang/ClassCastException;
        //  72     75     197    211    Ljava/lang/ClassCastException;
        //  89     95     211    225    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public static boolean isPregexpCheckIfInCharClass(final Object c, final Object char$Mnclass) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokevirtual   java/lang/Object.hashCode:()I
        //     4: lookupswitch {
        //          -828280721: 473
        //          1824626: 274
        //          57219652: 400
        //          1753399169: 304
        //          1753400676: 224
        //          1753596759: 136
        //          1754309978: 167
        //          1755311465: 727
        //          1756073267: 350
        //          1759106388: 787
        //          1763655431: 375
        //          1767425715: 757
        //          1767519552: 836
        //          1770128652: 702
        //          1771990184: 249
        //          default: 923
        //        }
        //   136: aload_1         /* char$Mnclass */
        //   137: getstatic       gnu/kawa/slib/pregexp.Lit49:Lgnu/mapping/SimpleSymbol;
        //   140: invokestatic    gnu/kawa/functions/IsEqv.apply:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   143: ifeq            923
        //   146: aload_0         /* c */
        //   147: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   150: invokestatic    gnu/text/Char.castToCharacter:(Ljava/lang/Object;)I
        //   153: sipush          128
        //   156: if_icmpge       163
        //   159: iconst_1       
        //   160: goto            940
        //   163: iconst_0       
        //   164: goto            940
        //   167: aload_1         /* char$Mnclass */
        //   168: getstatic       gnu/kawa/slib/pregexp.Lit50:Lgnu/mapping/SimpleSymbol;
        //   171: invokestatic    gnu/kawa/functions/IsEqv.apply:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   174: ifeq            923
        //   177: aload_0         /* c */
        //   178: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   181: invokestatic    gnu/text/Char.castToCharacter:(Ljava/lang/Object;)I
        //   184: bipush          32
        //   186: if_icmpne       193
        //   189: iconst_1       
        //   190: goto            194
        //   193: iconst_0       
        //   194: istore_2        /* x */
        //   195: iload_2         /* x */
        //   196: ifeq            203
        //   199: iload_2         /* x */
        //   200: goto            940
        //   203: aload_0         /* c */
        //   204: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   207: invokestatic    gnu/text/Char.castToCharacter:(Ljava/lang/Object;)I
        //   210: getstatic       gnu/kawa/slib/pregexp.$Stpregexp$Mntab$Mnchar$St:I
        //   213: if_icmpne       220
        //   216: iconst_1       
        //   217: goto            940
        //   220: iconst_0       
        //   221: goto            940
        //   224: aload_1         /* char$Mnclass */
        //   225: getstatic       gnu/kawa/slib/pregexp.Lit51:Lgnu/mapping/SimpleSymbol;
        //   228: invokestatic    gnu/kawa/functions/IsEqv.apply:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   231: ifeq            923
        //   234: aload_0         /* c */
        //   235: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   238: dup            
        //   239: astore_2       
        //   240: invokestatic    gnu/text/Char.castToCharacter:(Ljava/lang/Object;)I
        //   243: invokestatic    kawa/lib/rnrs/unicode.isCharAlphabetic:(I)Z
        //   246: goto            940
        //   249: aload_1         /* char$Mnclass */
        //   250: getstatic       gnu/kawa/slib/pregexp.Lit52:Lgnu/mapping/SimpleSymbol;
        //   253: invokestatic    gnu/kawa/functions/IsEqv.apply:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   256: ifeq            923
        //   259: aload_0         /* c */
        //   260: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   263: dup            
        //   264: astore_2       
        //   265: invokestatic    gnu/text/Char.castToCharacter:(Ljava/lang/Object;)I
        //   268: invokestatic    kawa/lib/rnrs/unicode.isCharUpperCase:(I)Z
        //   271: goto            940
        //   274: aload_1         /* char$Mnclass */
        //   275: getstatic       gnu/kawa/slib/pregexp.Lit9:Lgnu/mapping/SimpleSymbol;
        //   278: invokestatic    gnu/kawa/functions/IsEqv.apply:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   281: ifeq            923
        //   284: aload_0         /* c */
        //   285: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   288: invokestatic    gnu/text/Char.castToCharacter:(Ljava/lang/Object;)I
        //   291: bipush          10
        //   293: if_icmpne       300
        //   296: iconst_0       
        //   297: goto            940
        //   300: iconst_1       
        //   301: goto            940
        //   304: aload_1         /* char$Mnclass */
        //   305: getstatic       gnu/kawa/slib/pregexp.Lit53:Lgnu/mapping/SimpleSymbol;
        //   308: invokestatic    gnu/kawa/functions/IsEqv.apply:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   311: ifeq            923
        //   314: aload_0         /* c */
        //   315: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   318: dup            
        //   319: astore_3       
        //   320: invokestatic    gnu/text/Char.castToCharacter:(Ljava/lang/Object;)I
        //   323: invokestatic    kawa/lib/rnrs/unicode.isCharAlphabetic:(I)Z
        //   326: istore_2        /* x */
        //   327: iload_2         /* x */
        //   328: ifeq            335
        //   331: iload_2         /* x */
        //   332: goto            940
        //   335: aload_0         /* c */
        //   336: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   339: dup            
        //   340: astore_3       
        //   341: invokestatic    gnu/text/Char.castToCharacter:(Ljava/lang/Object;)I
        //   344: invokestatic    kawa/lib/rnrs/unicode.isCharNumeric:(I)Z
        //   347: goto            940
        //   350: aload_1         /* char$Mnclass */
        //   351: getstatic       gnu/kawa/slib/pregexp.Lit17:Lgnu/mapping/SimpleSymbol;
        //   354: invokestatic    gnu/kawa/functions/IsEqv.apply:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   357: ifeq            923
        //   360: aload_0         /* c */
        //   361: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   364: dup            
        //   365: astore_2       
        //   366: invokestatic    gnu/text/Char.castToCharacter:(Ljava/lang/Object;)I
        //   369: invokestatic    kawa/lib/rnrs/unicode.isCharNumeric:(I)Z
        //   372: goto            940
        //   375: aload_1         /* char$Mnclass */
        //   376: getstatic       gnu/kawa/slib/pregexp.Lit54:Lgnu/mapping/SimpleSymbol;
        //   379: invokestatic    gnu/kawa/functions/IsEqv.apply:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   382: ifeq            923
        //   385: aload_0         /* c */
        //   386: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   389: dup            
        //   390: astore_2       
        //   391: invokestatic    gnu/text/Char.castToCharacter:(Ljava/lang/Object;)I
        //   394: invokestatic    kawa/lib/rnrs/unicode.isCharLowerCase:(I)Z
        //   397: goto            940
        //   400: aload_1         /* char$Mnclass */
        //   401: getstatic       gnu/kawa/slib/pregexp.Lit14:Lgnu/mapping/SimpleSymbol;
        //   404: invokestatic    gnu/kawa/functions/IsEqv.apply:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   407: ifeq            923
        //   410: aload_0         /* c */
        //   411: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   414: dup            
        //   415: astore_3       
        //   416: invokestatic    gnu/text/Char.castToCharacter:(Ljava/lang/Object;)I
        //   419: invokestatic    kawa/lib/rnrs/unicode.isCharAlphabetic:(I)Z
        //   422: istore_2        /* x */
        //   423: iload_2         /* x */
        //   424: ifeq            431
        //   427: iload_2         /* x */
        //   428: goto            940
        //   431: aload_0         /* c */
        //   432: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   435: dup            
        //   436: astore          4
        //   438: invokestatic    gnu/text/Char.castToCharacter:(Ljava/lang/Object;)I
        //   441: invokestatic    kawa/lib/rnrs/unicode.isCharNumeric:(I)Z
        //   444: istore_3        /* x */
        //   445: iload_3         /* x */
        //   446: ifeq            453
        //   449: iload_3         /* x */
        //   450: goto            940
        //   453: aload_0         /* c */
        //   454: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   457: invokestatic    gnu/text/Char.castToCharacter:(Ljava/lang/Object;)I
        //   460: bipush          95
        //   462: if_icmpne       469
        //   465: iconst_1       
        //   466: goto            940
        //   469: iconst_0       
        //   470: goto            940
        //   473: aload_1         /* char$Mnclass */
        //   474: getstatic       gnu/kawa/slib/pregexp.Lit55:Lgnu/mapping/SimpleSymbol;
        //   477: invokestatic    gnu/kawa/functions/IsEqv.apply:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   480: ifeq            923
        //   483: aload_0         /* c */
        //   484: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   487: dup            
        //   488: astore_3       
        //   489: invokestatic    gnu/text/Char.castToCharacter:(Ljava/lang/Object;)I
        //   492: invokestatic    kawa/lib/rnrs/unicode.isCharNumeric:(I)Z
        //   495: istore_2        /* x */
        //   496: iload_2         /* x */
        //   497: ifeq            504
        //   500: iload_2         /* x */
        //   501: goto            940
        //   504: aload_0         /* c */
        //   505: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   508: invokestatic    gnu/text/Char.castToCharacter:(Ljava/lang/Object;)I
        //   511: invokestatic    java/lang/Character.toUpperCase:(I)I
        //   514: bipush          97
        //   516: invokestatic    java/lang/Character.toUpperCase:(I)I
        //   519: if_icmpne       526
        //   522: iconst_1       
        //   523: goto            527
        //   526: iconst_0       
        //   527: istore_3        /* x */
        //   528: iload_3         /* x */
        //   529: ifeq            536
        //   532: iload_3         /* x */
        //   533: goto            940
        //   536: aload_0         /* c */
        //   537: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   540: invokestatic    gnu/text/Char.castToCharacter:(Ljava/lang/Object;)I
        //   543: invokestatic    java/lang/Character.toUpperCase:(I)I
        //   546: bipush          98
        //   548: invokestatic    java/lang/Character.toUpperCase:(I)I
        //   551: if_icmpne       558
        //   554: iconst_1       
        //   555: goto            559
        //   558: iconst_0       
        //   559: istore          x
        //   561: iload           x
        //   563: ifeq            571
        //   566: iload           x
        //   568: goto            940
        //   571: aload_0         /* c */
        //   572: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   575: invokestatic    gnu/text/Char.castToCharacter:(Ljava/lang/Object;)I
        //   578: invokestatic    java/lang/Character.toUpperCase:(I)I
        //   581: bipush          99
        //   583: invokestatic    java/lang/Character.toUpperCase:(I)I
        //   586: if_icmpne       593
        //   589: iconst_1       
        //   590: goto            594
        //   593: iconst_0       
        //   594: istore          x
        //   596: iload           x
        //   598: ifeq            606
        //   601: iload           x
        //   603: goto            940
        //   606: aload_0         /* c */
        //   607: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   610: invokestatic    gnu/text/Char.castToCharacter:(Ljava/lang/Object;)I
        //   613: invokestatic    java/lang/Character.toUpperCase:(I)I
        //   616: bipush          100
        //   618: invokestatic    java/lang/Character.toUpperCase:(I)I
        //   621: if_icmpne       628
        //   624: iconst_1       
        //   625: goto            629
        //   628: iconst_0       
        //   629: istore          x
        //   631: iload           x
        //   633: ifeq            641
        //   636: iload           x
        //   638: goto            940
        //   641: aload_0         /* c */
        //   642: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   645: invokestatic    gnu/text/Char.castToCharacter:(Ljava/lang/Object;)I
        //   648: invokestatic    java/lang/Character.toUpperCase:(I)I
        //   651: bipush          101
        //   653: invokestatic    java/lang/Character.toUpperCase:(I)I
        //   656: if_icmpne       663
        //   659: iconst_1       
        //   660: goto            664
        //   663: iconst_0       
        //   664: istore          x
        //   666: iload           x
        //   668: ifeq            676
        //   671: iload           x
        //   673: goto            940
        //   676: aload_0         /* c */
        //   677: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   680: invokestatic    gnu/text/Char.castToCharacter:(Ljava/lang/Object;)I
        //   683: invokestatic    java/lang/Character.toUpperCase:(I)I
        //   686: bipush          102
        //   688: invokestatic    java/lang/Character.toUpperCase:(I)I
        //   691: if_icmpne       698
        //   694: iconst_1       
        //   695: goto            940
        //   698: iconst_0       
        //   699: goto            940
        //   702: aload_1         /* char$Mnclass */
        //   703: getstatic       gnu/kawa/slib/pregexp.Lit18:Lgnu/mapping/SimpleSymbol;
        //   706: invokestatic    gnu/kawa/functions/IsEqv.apply:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   709: ifeq            923
        //   712: aload_0         /* c */
        //   713: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   716: dup            
        //   717: astore_2       
        //   718: invokestatic    gnu/text/Char.castToCharacter:(Ljava/lang/Object;)I
        //   721: invokestatic    kawa/lib/rnrs/unicode.isCharWhitespace:(I)Z
        //   724: goto            940
        //   727: aload_1         /* char$Mnclass */
        //   728: getstatic       gnu/kawa/slib/pregexp.Lit56:Lgnu/mapping/SimpleSymbol;
        //   731: invokestatic    gnu/kawa/functions/IsEqv.apply:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   734: ifeq            923
        //   737: aload_0         /* c */
        //   738: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   741: invokestatic    gnu/text/Char.castToCharacter:(Ljava/lang/Object;)I
        //   744: bipush          32
        //   746: if_icmpge       753
        //   749: iconst_1       
        //   750: goto            940
        //   753: iconst_0       
        //   754: goto            940
        //   757: aload_1         /* char$Mnclass */
        //   758: getstatic       gnu/kawa/slib/pregexp.Lit57:Lgnu/mapping/SimpleSymbol;
        //   761: invokestatic    gnu/kawa/functions/IsEqv.apply:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   764: ifeq            923
        //   767: aload_0         /* c */
        //   768: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   771: invokestatic    gnu/text/Char.castToCharacter:(Ljava/lang/Object;)I
        //   774: bipush          32
        //   776: if_icmplt       783
        //   779: iconst_1       
        //   780: goto            940
        //   783: iconst_0       
        //   784: goto            940
        //   787: aload_1         /* char$Mnclass */
        //   788: getstatic       gnu/kawa/slib/pregexp.Lit58:Lgnu/mapping/SimpleSymbol;
        //   791: invokestatic    gnu/kawa/functions/IsEqv.apply:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   794: ifeq            923
        //   797: aload_0         /* c */
        //   798: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   801: invokestatic    gnu/text/Char.castToCharacter:(Ljava/lang/Object;)I
        //   804: bipush          32
        //   806: if_icmplt       832
        //   809: aload_0         /* c */
        //   810: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   813: dup            
        //   814: astore_2       
        //   815: invokestatic    gnu/text/Char.castToCharacter:(Ljava/lang/Object;)I
        //   818: invokestatic    kawa/lib/rnrs/unicode.isCharWhitespace:(I)Z
        //   821: ifeq            828
        //   824: iconst_0       
        //   825: goto            940
        //   828: iconst_1       
        //   829: goto            940
        //   832: iconst_0       
        //   833: goto            940
        //   836: aload_1         /* char$Mnclass */
        //   837: getstatic       gnu/kawa/slib/pregexp.Lit59:Lgnu/mapping/SimpleSymbol;
        //   840: invokestatic    gnu/kawa/functions/IsEqv.apply:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   843: ifeq            923
        //   846: aload_0         /* c */
        //   847: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   850: invokestatic    gnu/text/Char.castToCharacter:(Ljava/lang/Object;)I
        //   853: bipush          32
        //   855: if_icmplt       919
        //   858: aload_0         /* c */
        //   859: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   862: dup            
        //   863: astore_2       
        //   864: invokestatic    gnu/text/Char.castToCharacter:(Ljava/lang/Object;)I
        //   867: invokestatic    kawa/lib/rnrs/unicode.isCharWhitespace:(I)Z
        //   870: ifne            915
        //   873: aload_0         /* c */
        //   874: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   877: dup            
        //   878: astore_2       
        //   879: invokestatic    gnu/text/Char.castToCharacter:(Ljava/lang/Object;)I
        //   882: invokestatic    kawa/lib/rnrs/unicode.isCharAlphabetic:(I)Z
        //   885: ifne            911
        //   888: aload_0         /* c */
        //   889: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   892: dup            
        //   893: astore_2       
        //   894: invokestatic    gnu/text/Char.castToCharacter:(Ljava/lang/Object;)I
        //   897: invokestatic    kawa/lib/rnrs/unicode.isCharNumeric:(I)Z
        //   900: ifeq            907
        //   903: iconst_0       
        //   904: goto            940
        //   907: iconst_1       
        //   908: goto            940
        //   911: iconst_0       
        //   912: goto            940
        //   915: iconst_0       
        //   916: goto            940
        //   919: iconst_0       
        //   920: goto            940
        //   923: iconst_1       
        //   924: anewarray       Ljava/lang/Object;
        //   927: dup            
        //   928: iconst_0       
        //   929: getstatic       gnu/kawa/slib/pregexp.Lit60:Lgnu/mapping/SimpleSymbol;
        //   932: aastore        
        //   933: invokestatic    kawa/lib/exceptions.error:([Ljava/lang/Object;)Lgnu/bytecode/Type$NeverReturns;
        //   936: getstatic       gnu/expr/Special.reachedUnexpected:Ljava/lang/RuntimeException;
        //   939: athrow         
        //   940: ireturn        
        //   941: new             Lgnu/mapping/WrongType;
        //   944: dup_x1         
        //   945: swap           
        //   946: ldc_w           "char-alphabetic?"
        //   949: iconst_1       
        //   950: aload_2        
        //   951: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   954: athrow         
        //   955: new             Lgnu/mapping/WrongType;
        //   958: dup_x1         
        //   959: swap           
        //   960: ldc_w           "char-upper-case?"
        //   963: iconst_1       
        //   964: aload_2        
        //   965: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   968: athrow         
        //   969: new             Lgnu/mapping/WrongType;
        //   972: dup_x1         
        //   973: swap           
        //   974: ldc_w           "char-alphabetic?"
        //   977: iconst_1       
        //   978: aload_3        
        //   979: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   982: athrow         
        //   983: new             Lgnu/mapping/WrongType;
        //   986: dup_x1         
        //   987: swap           
        //   988: ldc_w           "char-numeric?"
        //   991: iconst_1       
        //   992: aload_3        
        //   993: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   996: athrow         
        //   997: new             Lgnu/mapping/WrongType;
        //  1000: dup_x1         
        //  1001: swap           
        //  1002: ldc_w           "char-numeric?"
        //  1005: iconst_1       
        //  1006: aload_2        
        //  1007: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1010: athrow         
        //  1011: new             Lgnu/mapping/WrongType;
        //  1014: dup_x1         
        //  1015: swap           
        //  1016: ldc_w           "char-lower-case?"
        //  1019: iconst_1       
        //  1020: aload_2        
        //  1021: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1024: athrow         
        //  1025: new             Lgnu/mapping/WrongType;
        //  1028: dup_x1         
        //  1029: swap           
        //  1030: ldc_w           "char-alphabetic?"
        //  1033: iconst_1       
        //  1034: aload_3        
        //  1035: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1038: athrow         
        //  1039: new             Lgnu/mapping/WrongType;
        //  1042: dup_x1         
        //  1043: swap           
        //  1044: ldc_w           "char-numeric?"
        //  1047: iconst_1       
        //  1048: aload           4
        //  1050: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1053: athrow         
        //  1054: new             Lgnu/mapping/WrongType;
        //  1057: dup_x1         
        //  1058: swap           
        //  1059: ldc_w           "char-numeric?"
        //  1062: iconst_1       
        //  1063: aload_3        
        //  1064: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1067: athrow         
        //  1068: new             Lgnu/mapping/WrongType;
        //  1071: dup_x1         
        //  1072: swap           
        //  1073: ldc_w           "char-whitespace?"
        //  1076: iconst_1       
        //  1077: aload_2        
        //  1078: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1081: athrow         
        //  1082: new             Lgnu/mapping/WrongType;
        //  1085: dup_x1         
        //  1086: swap           
        //  1087: ldc_w           "char-whitespace?"
        //  1090: iconst_1       
        //  1091: aload_2        
        //  1092: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1095: athrow         
        //  1096: new             Lgnu/mapping/WrongType;
        //  1099: dup_x1         
        //  1100: swap           
        //  1101: ldc_w           "char-whitespace?"
        //  1104: iconst_1       
        //  1105: aload_2        
        //  1106: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1109: athrow         
        //  1110: new             Lgnu/mapping/WrongType;
        //  1113: dup_x1         
        //  1114: swap           
        //  1115: ldc_w           "char-alphabetic?"
        //  1118: iconst_1       
        //  1119: aload_2        
        //  1120: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1123: athrow         
        //  1124: new             Lgnu/mapping/WrongType;
        //  1127: dup_x1         
        //  1128: swap           
        //  1129: ldc_w           "char-numeric?"
        //  1132: iconst_1       
        //  1133: aload_2        
        //  1134: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1137: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  240    243    941    955    Ljava/lang/ClassCastException;
        //  265    268    955    969    Ljava/lang/ClassCastException;
        //  320    323    969    983    Ljava/lang/ClassCastException;
        //  341    344    983    997    Ljava/lang/ClassCastException;
        //  366    369    997    1011   Ljava/lang/ClassCastException;
        //  391    394    1011   1025   Ljava/lang/ClassCastException;
        //  416    419    1025   1039   Ljava/lang/ClassCastException;
        //  438    441    1039   1054   Ljava/lang/ClassCastException;
        //  489    492    1054   1068   Ljava/lang/ClassCastException;
        //  718    721    1068   1082   Ljava/lang/ClassCastException;
        //  815    818    1082   1096   Ljava/lang/ClassCastException;
        //  864    867    1096   1110   Ljava/lang/ClassCastException;
        //  879    882    1110   1124   Ljava/lang/ClassCastException;
        //  894    897    1124   1138   Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 478 out of bounds for length 478
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
    
    public static Object pregexpListRef(final Object s, final Object i) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getstatic       gnu/kawa/slib/pregexp.Lit40:Lgnu/math/IntNum;
        //     4: astore_3       
        //     5: astore_2        /* s */
        //     6: aload_2         /* s */
        //     7: invokestatic    kawa/lib/lists.isNull:(Ljava/lang/Object;)Z
        //    10: ifeq            19
        //    13: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //    16: goto            68
        //    19: aload_3         /* k */
        //    20: aload_1         /* i */
        //    21: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //    24: ifeq            45
        //    27: aload_2         /* s */
        //    28: ldc             Lgnu/lists/Pair;.class
        //    30: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    33: dup            
        //    34: astore          4
        //    36: checkcast       Lgnu/lists/Pair;
        //    39: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    42: goto            68
        //    45: aload_2         /* s */
        //    46: ldc             Lgnu/lists/Pair;.class
        //    48: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    51: dup            
        //    52: astore          4
        //    54: checkcast       Lgnu/lists/Pair;
        //    57: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    60: aload_3         /* k */
        //    61: iconst_1       
        //    62: invokestatic    gnu/math/IntNum.add:(Lgnu/math/IntNum;I)Lgnu/math/IntNum;
        //    65: goto            4
        //    68: areturn        
        //    69: new             Lgnu/mapping/WrongType;
        //    72: dup_x1         
        //    73: swap           
        //    74: ldc             "car"
        //    76: iconst_1       
        //    77: aload           4
        //    79: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //    82: athrow         
        //    83: new             Lgnu/mapping/WrongType;
        //    86: dup_x1         
        //    87: swap           
        //    88: ldc             "cdr"
        //    90: iconst_1       
        //    91: aload           4
        //    93: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //    96: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  36     39     69     83     Ljava/lang/ClassCastException;
        //  54     57     83     97     Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public static Object pregexpMakeBackrefList(final Object re) {
        return lambda1sub(re);
    }
    
    public static Object lambda1sub(final Object re) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokestatic    kawa/lib/lists.isPair:(Ljava/lang/Object;)Z
        //     4: ifeq            85
        //     7: aload_0         /* re */
        //     8: ldc             Lgnu/lists/Pair;.class
        //    10: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    13: dup            
        //    14: astore_2       
        //    15: checkcast       Lgnu/lists/Pair;
        //    18: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    21: astore_1       
        //    22: aload_0         /* re */
        //    23: ldc             Lgnu/lists/Pair;.class
        //    25: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    28: dup            
        //    29: astore_3       
        //    30: checkcast       Lgnu/lists/Pair;
        //    33: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    36: invokestatic    gnu/kawa/slib/pregexp.lambda1sub:(Ljava/lang/Object;)Ljava/lang/Object;
        //    39: astore_2        /* sub$Mncdr$Mnre */
        //    40: aload_1         /* car$Mnre */
        //    41: getstatic       gnu/kawa/slib/pregexp.Lit61:Lgnu/mapping/SimpleSymbol;
        //    44: invokestatic    gnu/kawa/functions/IsEqv.apply:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //    47: ifeq            64
        //    50: aload_0         /* re */
        //    51: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //    54: invokestatic    kawa/lib/lists.cons:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //    57: aload_2         /* sub$Mncdr$Mnre */
        //    58: invokestatic    kawa/lib/lists.cons:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //    61: goto            88
        //    64: iconst_2       
        //    65: anewarray       Ljava/lang/Object;
        //    68: dup            
        //    69: iconst_0       
        //    70: aload_1         /* car$Mnre */
        //    71: invokestatic    gnu/kawa/slib/pregexp.lambda1sub:(Ljava/lang/Object;)Ljava/lang/Object;
        //    74: aastore        
        //    75: dup            
        //    76: iconst_1       
        //    77: aload_2         /* sub$Mncdr$Mnre */
        //    78: aastore        
        //    79: invokestatic    kawa/standard/append.append$V:([Ljava/lang/Object;)Ljava/lang/Object;
        //    82: goto            88
        //    85: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
        //    88: areturn        
        //    89: new             Lgnu/mapping/WrongType;
        //    92: dup_x1         
        //    93: swap           
        //    94: ldc             "car"
        //    96: iconst_1       
        //    97: aload_2        
        //    98: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   101: athrow         
        //   102: new             Lgnu/mapping/WrongType;
        //   105: dup_x1         
        //   106: swap           
        //   107: ldc             "cdr"
        //   109: iconst_1       
        //   110: aload_3        
        //   111: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   114: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  15     18     89     102    Ljava/lang/ClassCastException;
        //  30     33     102    115    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public static Object pregexpMatchPositionsAux(final Object re, final Object s, final Object sn, final Object start, final Object n, final Object i) {
        public class pregexp$frame extends ModuleBody
        {
            Object sn;
            Procedure identity;
            Object backrefs;
            Object case$Mnsensitive$Qu;
            Object s;
            Object n;
            Object start;
            
            public pregexp$frame() {
                final ModuleMethod identity = new ModuleMethod(this, 15, "identity", 4097);
                identity.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm:465");
                this.identity = identity;
            }
            
            public static Object lambda2identity(final Object x) {
                return x;
            }
            
            public Object lambda3sub(final Object backrefs, final Object re, final Object i, final Object sk, final Object fk) {
                // 
                // This method could not be decompiled.
                // 
                // Original Bytecode:
                // 
                //     3: dup            
                //     4: invokespecial   gnu/kawa/slib/pregexp$frame0.<init>:()V
                //     7: dup            
                //     8: aload_0         /* this */
                //     9: putfield        gnu/kawa/slib/pregexp$frame0.staticLink:Lgnu/kawa/slib/pregexp$frame;
                //    12: astore          $heapFrame
                //    14: aload           $heapFrame
                //    16: aload_2         /* re */
                //    17: putfield        gnu/kawa/slib/pregexp$frame0.re$1:Ljava/lang/Object;
                //    20: aload           $heapFrame
                //    22: aload_3         /* i */
                //    23: putfield        gnu/kawa/slib/pregexp$frame0.i:Ljava/lang/Object;
                //    26: aload           $heapFrame
                //    28: aload           sk
                //    30: putfield        gnu/kawa/slib/pregexp$frame0.sk:Ljava/lang/Object;
                //    33: aload           $heapFrame
                //    35: aload           fk
                //    37: putfield        gnu/kawa/slib/pregexp$frame0.fk:Ljava/lang/Object;
                //    40: aload           $heapFrame
                //    42: getfield        gnu/kawa/slib/pregexp$frame0.re$1:Ljava/lang/Object;
                //    45: getstatic       gnu/kawa/slib/pregexp.Lit8:Lgnu/mapping/SimpleSymbol;
                //    48: invokestatic    gnu/kawa/functions/IsEqv.apply:(Ljava/lang/Object;Ljava/lang/Object;)Z
                //    51: ifeq            102
                //    54: aload           $heapFrame
                //    56: getfield        gnu/kawa/slib/pregexp$frame0.i:Ljava/lang/Object;
                //    59: aload_0         /* this */
                //    60: getfield        gnu/kawa/slib/pregexp$frame.start:Ljava/lang/Object;
                //    63: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
                //    66: ifeq            88
                //    69: getstatic       kawa/standard/Scheme.applyToArgs:Lgnu/kawa/functions/ApplyToArgs;
                //    72: aload           $heapFrame
                //    74: getfield        gnu/kawa/slib/pregexp$frame0.sk:Ljava/lang/Object;
                //    77: aload           $heapFrame
                //    79: getfield        gnu/kawa/slib/pregexp$frame0.i:Ljava/lang/Object;
                //    82: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                //    85: goto            2328
                //    88: getstatic       kawa/standard/Scheme.applyToArgs:Lgnu/kawa/functions/ApplyToArgs;
                //    91: aload           $heapFrame
                //    93: getfield        gnu/kawa/slib/pregexp$frame0.fk:Ljava/lang/Object;
                //    96: invokevirtual   gnu/mapping/Procedure.apply1:(Ljava/lang/Object;)Ljava/lang/Object;
                //    99: goto            2328
                //   102: aload           $heapFrame
                //   104: getfield        gnu/kawa/slib/pregexp$frame0.re$1:Ljava/lang/Object;
                //   107: getstatic       gnu/kawa/slib/pregexp.Lit4:Lgnu/mapping/SimpleSymbol;
                //   110: invokestatic    gnu/kawa/functions/IsEqv.apply:(Ljava/lang/Object;Ljava/lang/Object;)Z
                //   113: ifeq            164
                //   116: aload           $heapFrame
                //   118: getfield        gnu/kawa/slib/pregexp$frame0.i:Ljava/lang/Object;
                //   121: aload_0         /* this */
                //   122: getfield        gnu/kawa/slib/pregexp$frame.n:Ljava/lang/Object;
                //   125: invokestatic    gnu/kawa/functions/NumberCompare.$Gr$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
                //   128: ifeq            150
                //   131: getstatic       kawa/standard/Scheme.applyToArgs:Lgnu/kawa/functions/ApplyToArgs;
                //   134: aload           $heapFrame
                //   136: getfield        gnu/kawa/slib/pregexp$frame0.sk:Ljava/lang/Object;
                //   139: aload           $heapFrame
                //   141: getfield        gnu/kawa/slib/pregexp$frame0.i:Ljava/lang/Object;
                //   144: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                //   147: goto            2328
                //   150: getstatic       kawa/standard/Scheme.applyToArgs:Lgnu/kawa/functions/ApplyToArgs;
                //   153: aload           $heapFrame
                //   155: getfield        gnu/kawa/slib/pregexp$frame0.fk:Ljava/lang/Object;
                //   158: invokevirtual   gnu/mapping/Procedure.apply1:(Ljava/lang/Object;)Ljava/lang/Object;
                //   161: goto            2328
                //   164: aload           $heapFrame
                //   166: getfield        gnu/kawa/slib/pregexp$frame0.re$1:Ljava/lang/Object;
                //   169: getstatic       gnu/kawa/slib/pregexp.Lit13:Lgnu/mapping/SimpleSymbol;
                //   172: invokestatic    gnu/kawa/functions/IsEqv.apply:(Ljava/lang/Object;Ljava/lang/Object;)Z
                //   175: ifeq            197
                //   178: getstatic       kawa/standard/Scheme.applyToArgs:Lgnu/kawa/functions/ApplyToArgs;
                //   181: aload           $heapFrame
                //   183: getfield        gnu/kawa/slib/pregexp$frame0.sk:Ljava/lang/Object;
                //   186: aload           $heapFrame
                //   188: getfield        gnu/kawa/slib/pregexp$frame0.i:Ljava/lang/Object;
                //   191: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                //   194: goto            2328
                //   197: aload           $heapFrame
                //   199: getfield        gnu/kawa/slib/pregexp$frame0.re$1:Ljava/lang/Object;
                //   202: getstatic       gnu/kawa/slib/pregexp.Lit19:Lgnu/mapping/SimpleSymbol;
                //   205: invokestatic    gnu/kawa/functions/IsEqv.apply:(Ljava/lang/Object;Ljava/lang/Object;)Z
                //   208: ifeq            263
                //   211: aload_0         /* this */
                //   212: getfield        gnu/kawa/slib/pregexp$frame.s:Ljava/lang/Object;
                //   215: aload           $heapFrame
                //   217: getfield        gnu/kawa/slib/pregexp$frame0.i:Ljava/lang/Object;
                //   220: aload_0         /* this */
                //   221: getfield        gnu/kawa/slib/pregexp$frame.n:Ljava/lang/Object;
                //   224: invokestatic    gnu/kawa/slib/pregexp.isPregexpAtWordBoundary:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Z
                //   227: ifeq            249
                //   230: getstatic       kawa/standard/Scheme.applyToArgs:Lgnu/kawa/functions/ApplyToArgs;
                //   233: aload           $heapFrame
                //   235: getfield        gnu/kawa/slib/pregexp$frame0.sk:Ljava/lang/Object;
                //   238: aload           $heapFrame
                //   240: getfield        gnu/kawa/slib/pregexp$frame0.i:Ljava/lang/Object;
                //   243: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                //   246: goto            2328
                //   249: getstatic       kawa/standard/Scheme.applyToArgs:Lgnu/kawa/functions/ApplyToArgs;
                //   252: aload           $heapFrame
                //   254: getfield        gnu/kawa/slib/pregexp$frame0.fk:Ljava/lang/Object;
                //   257: invokevirtual   gnu/mapping/Procedure.apply1:(Ljava/lang/Object;)Ljava/lang/Object;
                //   260: goto            2328
                //   263: aload           $heapFrame
                //   265: getfield        gnu/kawa/slib/pregexp$frame0.re$1:Ljava/lang/Object;
                //   268: getstatic       gnu/kawa/slib/pregexp.Lit21:Lgnu/mapping/SimpleSymbol;
                //   271: invokestatic    gnu/kawa/functions/IsEqv.apply:(Ljava/lang/Object;Ljava/lang/Object;)Z
                //   274: ifeq            329
                //   277: aload_0         /* this */
                //   278: getfield        gnu/kawa/slib/pregexp$frame.s:Ljava/lang/Object;
                //   281: aload           $heapFrame
                //   283: getfield        gnu/kawa/slib/pregexp$frame0.i:Ljava/lang/Object;
                //   286: aload_0         /* this */
                //   287: getfield        gnu/kawa/slib/pregexp$frame.n:Ljava/lang/Object;
                //   290: invokestatic    gnu/kawa/slib/pregexp.isPregexpAtWordBoundary:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Z
                //   293: ifeq            310
                //   296: getstatic       kawa/standard/Scheme.applyToArgs:Lgnu/kawa/functions/ApplyToArgs;
                //   299: aload           $heapFrame
                //   301: getfield        gnu/kawa/slib/pregexp$frame0.fk:Ljava/lang/Object;
                //   304: invokevirtual   gnu/mapping/Procedure.apply1:(Ljava/lang/Object;)Ljava/lang/Object;
                //   307: goto            2328
                //   310: getstatic       kawa/standard/Scheme.applyToArgs:Lgnu/kawa/functions/ApplyToArgs;
                //   313: aload           $heapFrame
                //   315: getfield        gnu/kawa/slib/pregexp$frame0.sk:Ljava/lang/Object;
                //   318: aload           $heapFrame
                //   320: getfield        gnu/kawa/slib/pregexp$frame0.i:Ljava/lang/Object;
                //   323: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                //   326: goto            2328
                //   329: aload           $heapFrame
                //   331: getfield        gnu/kawa/slib/pregexp$frame0.re$1:Ljava/lang/Object;
                //   334: invokestatic    kawa/lib/characters.isChar:(Ljava/lang/Object;)Z
                //   337: ifeq            466
                //   340: aload           $heapFrame
                //   342: getfield        gnu/kawa/slib/pregexp$frame0.i:Ljava/lang/Object;
                //   345: aload_0         /* this */
                //   346: getfield        gnu/kawa/slib/pregexp$frame.n:Ljava/lang/Object;
                //   349: invokestatic    gnu/kawa/functions/NumberCompare.$Ls:(Ljava/lang/Object;Ljava/lang/Object;)Z
                //   352: ifeq            466
                //   355: aload_0         /* this */
                //   356: getfield        gnu/kawa/slib/pregexp$frame.case$Mnsensitive$Qu:Ljava/lang/Object;
                //   359: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
                //   362: ifeq            371
                //   365: getstatic       kawa/lib/strings.char$Eq$Qu:Lgnu/expr/ModuleMethod;
                //   368: goto            374
                //   371: getstatic       kawa/lib/strings.char$Mnci$Eq$Qu:Lgnu/expr/ModuleMethod;
                //   374: aload_0         /* this */
                //   375: getfield        gnu/kawa/slib/pregexp$frame.s:Ljava/lang/Object;
                //   378: ldc             Ljava/lang/CharSequence;.class
                //   380: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //   383: dup            
                //   384: astore          7
                //   386: checkcast       Ljava/lang/CharSequence;
                //   389: aload           $heapFrame
                //   391: getfield        gnu/kawa/slib/pregexp$frame0.i:Ljava/lang/Object;
                //   394: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
                //   397: dup            
                //   398: astore          7
                //   400: checkcast       Ljava/lang/Number;
                //   403: invokevirtual   java/lang/Number.intValue:()I
                //   406: invokestatic    kawa/lib/strings.stringRef:(Ljava/lang/CharSequence;I)I
                //   409: invokestatic    gnu/text/Char.make:(I)Lgnu/text/Char;
                //   412: aload           $heapFrame
                //   414: getfield        gnu/kawa/slib/pregexp$frame0.re$1:Ljava/lang/Object;
                //   417: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                //   420: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
                //   423: ifeq            452
                //   426: getstatic       kawa/standard/Scheme.applyToArgs:Lgnu/kawa/functions/ApplyToArgs;
                //   429: aload           $heapFrame
                //   431: getfield        gnu/kawa/slib/pregexp$frame0.sk:Ljava/lang/Object;
                //   434: iconst_1       
                //   435: aload           $heapFrame
                //   437: getfield        gnu/kawa/slib/pregexp$frame0.i:Ljava/lang/Object;
                //   440: getstatic       gnu/kawa/slib/pregexp.Lit3:Lgnu/math/IntNum;
                //   443: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                //   446: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                //   449: goto            2328
                //   452: getstatic       kawa/standard/Scheme.applyToArgs:Lgnu/kawa/functions/ApplyToArgs;
                //   455: aload           $heapFrame
                //   457: getfield        gnu/kawa/slib/pregexp$frame0.fk:Ljava/lang/Object;
                //   460: invokevirtual   gnu/mapping/Procedure.apply1:(Ljava/lang/Object;)Ljava/lang/Object;
                //   463: goto            2328
                //   466: aload           $heapFrame
                //   468: getfield        gnu/kawa/slib/pregexp$frame0.re$1:Ljava/lang/Object;
                //   471: invokestatic    kawa/lib/lists.isPair:(Ljava/lang/Object;)Z
                //   474: ifne            581
                //   477: aload           $heapFrame
                //   479: getfield        gnu/kawa/slib/pregexp$frame0.i:Ljava/lang/Object;
                //   482: aload_0         /* this */
                //   483: getfield        gnu/kawa/slib/pregexp$frame.n:Ljava/lang/Object;
                //   486: invokestatic    gnu/kawa/functions/NumberCompare.$Ls:(Ljava/lang/Object;Ljava/lang/Object;)Z
                //   489: ifeq            581
                //   492: aload_0         /* this */
                //   493: getfield        gnu/kawa/slib/pregexp$frame.s:Ljava/lang/Object;
                //   496: ldc             Ljava/lang/CharSequence;.class
                //   498: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //   501: dup            
                //   502: astore          7
                //   504: checkcast       Ljava/lang/CharSequence;
                //   507: aload           $heapFrame
                //   509: getfield        gnu/kawa/slib/pregexp$frame0.i:Ljava/lang/Object;
                //   512: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
                //   515: dup            
                //   516: astore          7
                //   518: checkcast       Ljava/lang/Number;
                //   521: invokevirtual   java/lang/Number.intValue:()I
                //   524: invokestatic    kawa/lib/strings.stringRef:(Ljava/lang/CharSequence;I)I
                //   527: invokestatic    gnu/text/Char.make:(I)Lgnu/text/Char;
                //   530: aload           $heapFrame
                //   532: getfield        gnu/kawa/slib/pregexp$frame0.re$1:Ljava/lang/Object;
                //   535: invokestatic    gnu/kawa/slib/pregexp.isPregexpCheckIfInCharClass:(Ljava/lang/Object;Ljava/lang/Object;)Z
                //   538: ifeq            567
                //   541: getstatic       kawa/standard/Scheme.applyToArgs:Lgnu/kawa/functions/ApplyToArgs;
                //   544: aload           $heapFrame
                //   546: getfield        gnu/kawa/slib/pregexp$frame0.sk:Ljava/lang/Object;
                //   549: iconst_1       
                //   550: aload           $heapFrame
                //   552: getfield        gnu/kawa/slib/pregexp$frame0.i:Ljava/lang/Object;
                //   555: getstatic       gnu/kawa/slib/pregexp.Lit3:Lgnu/math/IntNum;
                //   558: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                //   561: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                //   564: goto            2328
                //   567: getstatic       kawa/standard/Scheme.applyToArgs:Lgnu/kawa/functions/ApplyToArgs;
                //   570: aload           $heapFrame
                //   572: getfield        gnu/kawa/slib/pregexp$frame0.fk:Ljava/lang/Object;
                //   575: invokevirtual   gnu/mapping/Procedure.apply1:(Ljava/lang/Object;)Ljava/lang/Object;
                //   578: goto            2328
                //   581: aload           $heapFrame
                //   583: getfield        gnu/kawa/slib/pregexp$frame0.re$1:Ljava/lang/Object;
                //   586: invokestatic    kawa/lib/lists.isPair:(Ljava/lang/Object;)Z
                //   589: ifeq            781
                //   592: aload           $heapFrame
                //   594: getfield        gnu/kawa/slib/pregexp$frame0.re$1:Ljava/lang/Object;
                //   597: ldc             Lgnu/lists/Pair;.class
                //   599: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //   602: dup            
                //   603: astore          7
                //   605: checkcast       Lgnu/lists/Pair;
                //   608: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
                //   611: getstatic       gnu/kawa/slib/pregexp.Lit48:Lgnu/mapping/SimpleSymbol;
                //   614: invokestatic    gnu/kawa/functions/IsEqv.apply:(Ljava/lang/Object;Ljava/lang/Object;)Z
                //   617: ifeq            781
                //   620: aload           $heapFrame
                //   622: getfield        gnu/kawa/slib/pregexp$frame0.i:Ljava/lang/Object;
                //   625: aload_0         /* this */
                //   626: getfield        gnu/kawa/slib/pregexp$frame.n:Ljava/lang/Object;
                //   629: invokestatic    gnu/kawa/functions/NumberCompare.$Ls:(Ljava/lang/Object;Ljava/lang/Object;)Z
                //   632: ifeq            781
                //   635: aload_0         /* this */
                //   636: getfield        gnu/kawa/slib/pregexp$frame.s:Ljava/lang/Object;
                //   639: ldc             Ljava/lang/CharSequence;.class
                //   641: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //   644: dup            
                //   645: astore          8
                //   647: checkcast       Ljava/lang/CharSequence;
                //   650: aload           $heapFrame
                //   652: getfield        gnu/kawa/slib/pregexp$frame0.i:Ljava/lang/Object;
                //   655: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
                //   658: dup            
                //   659: astore          8
                //   661: checkcast       Ljava/lang/Number;
                //   664: invokevirtual   java/lang/Number.intValue:()I
                //   667: invokestatic    kawa/lib/strings.stringRef:(Ljava/lang/CharSequence;I)I
                //   670: istore          c
                //   672: aload_0         /* this */
                //   673: getfield        gnu/kawa/slib/pregexp$frame.case$Mnsensitive$Qu:Ljava/lang/Object;
                //   676: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
                //   679: ifeq            688
                //   682: getstatic       kawa/lib/strings.char$Ls$Eq$Qu:Lgnu/expr/ModuleMethod;
                //   685: goto            691
                //   688: getstatic       kawa/lib/strings.char$Mnci$Ls$Eq$Qu:Lgnu/expr/ModuleMethod;
                //   691: astore          c$Ls
                //   693: aload           c$Ls
                //   695: aload           $heapFrame
                //   697: getfield        gnu/kawa/slib/pregexp$frame0.re$1:Ljava/lang/Object;
                //   700: invokestatic    kawa/lib/lists.cadr:(Ljava/lang/Object;)Ljava/lang/Object;
                //   703: iload           c
                //   705: invokestatic    gnu/text/Char.make:(I)Lgnu/text/Char;
                //   708: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                //   711: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
                //   714: ifeq            767
                //   717: aload           c$Ls
                //   719: iload           c
                //   721: invokestatic    gnu/text/Char.make:(I)Lgnu/text/Char;
                //   724: aload           $heapFrame
                //   726: getfield        gnu/kawa/slib/pregexp$frame0.re$1:Ljava/lang/Object;
                //   729: invokestatic    kawa/lib/lists.caddr:(Ljava/lang/Object;)Ljava/lang/Object;
                //   732: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                //   735: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
                //   738: ifeq            767
                //   741: getstatic       kawa/standard/Scheme.applyToArgs:Lgnu/kawa/functions/ApplyToArgs;
                //   744: aload           $heapFrame
                //   746: getfield        gnu/kawa/slib/pregexp$frame0.sk:Ljava/lang/Object;
                //   749: iconst_1       
                //   750: aload           $heapFrame
                //   752: getfield        gnu/kawa/slib/pregexp$frame0.i:Ljava/lang/Object;
                //   755: getstatic       gnu/kawa/slib/pregexp.Lit3:Lgnu/math/IntNum;
                //   758: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                //   761: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                //   764: goto            2328
                //   767: getstatic       kawa/standard/Scheme.applyToArgs:Lgnu/kawa/functions/ApplyToArgs;
                //   770: aload           $heapFrame
                //   772: getfield        gnu/kawa/slib/pregexp$frame0.fk:Ljava/lang/Object;
                //   775: invokevirtual   gnu/mapping/Procedure.apply1:(Ljava/lang/Object;)Ljava/lang/Object;
                //   778: goto            2328
                //   781: aload           $heapFrame
                //   783: getfield        gnu/kawa/slib/pregexp$frame0.re$1:Ljava/lang/Object;
                //   786: invokestatic    kawa/lib/lists.isPair:(Ljava/lang/Object;)Z
                //   789: ifeq            2282
                //   792: aload           $heapFrame
                //   794: getfield        gnu/kawa/slib/pregexp$frame0.re$1:Ljava/lang/Object;
                //   797: ldc             Lgnu/lists/Pair;.class
                //   799: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //   802: dup            
                //   803: astore          8
                //   805: checkcast       Lgnu/lists/Pair;
                //   808: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
                //   811: astore          tmp
                //   813: aload           tmp
                //   815: invokevirtual   java/lang/Object.hashCode:()I
                //   818: lookupswitch {
                //          -1676223608: 1504
                //          -1649488850: 1626
                //          -1373960256: 948
                //          -880563283: 1005
                //          -838680437: 1840
                //          -397368237: 1919
                //          -203333712: 1305
                //            59293: 1091
                //          1841637: 1720
                //          1842118: 1583
                //          684904690: 1764
                //          1002970408: 1436
                //          1406042867: 1077
                //          1951555794: 2050
                //          2082117262: 1130
                //          default: 2265
                //        }
                //   948: aload           tmp
                //   950: getstatic       gnu/kawa/slib/pregexp.Lit48:Lgnu/mapping/SimpleSymbol;
                //   953: invokestatic    gnu/kawa/functions/IsEqv.apply:(Ljava/lang/Object;Ljava/lang/Object;)Z
                //   956: ifeq            2265
                //   959: aload           $heapFrame
                //   961: getfield        gnu/kawa/slib/pregexp$frame0.i:Ljava/lang/Object;
                //   964: aload_0         /* this */
                //   965: getfield        gnu/kawa/slib/pregexp$frame.n:Ljava/lang/Object;
                //   968: invokestatic    gnu/kawa/functions/NumberCompare.$Gr$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
                //   971: ifeq            988
                //   974: getstatic       kawa/standard/Scheme.applyToArgs:Lgnu/kawa/functions/ApplyToArgs;
                //   977: aload           $heapFrame
                //   979: getfield        gnu/kawa/slib/pregexp$frame0.fk:Ljava/lang/Object;
                //   982: invokevirtual   gnu/mapping/Procedure.apply1:(Ljava/lang/Object;)Ljava/lang/Object;
                //   985: goto            2328
                //   988: iconst_1       
                //   989: anewarray       Ljava/lang/Object;
                //   992: dup            
                //   993: iconst_0       
                //   994: getstatic       gnu/kawa/slib/pregexp.Lit62:Lgnu/mapping/SimpleSymbol;
                //   997: aastore        
                //   998: invokestatic    kawa/lib/exceptions.error:([Ljava/lang/Object;)Lgnu/bytecode/Type$NeverReturns;
                //  1001: getstatic       gnu/expr/Special.reachedUnexpected:Ljava/lang/RuntimeException;
                //  1004: athrow         
                //  1005: aload           tmp
                //  1007: getstatic       gnu/kawa/slib/pregexp.Lit12:Lgnu/mapping/SimpleSymbol;
                //  1010: invokestatic    gnu/kawa/functions/IsEqv.apply:(Ljava/lang/Object;Ljava/lang/Object;)Z
                //  1013: ifeq            2265
                //  1016: aload           $heapFrame
                //  1018: getfield        gnu/kawa/slib/pregexp$frame0.i:Ljava/lang/Object;
                //  1021: aload_0         /* this */
                //  1022: getfield        gnu/kawa/slib/pregexp$frame.n:Ljava/lang/Object;
                //  1025: invokestatic    gnu/kawa/functions/NumberCompare.$Gr$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
                //  1028: ifeq            1045
                //  1031: getstatic       kawa/standard/Scheme.applyToArgs:Lgnu/kawa/functions/ApplyToArgs;
                //  1034: aload           $heapFrame
                //  1036: getfield        gnu/kawa/slib/pregexp$frame0.fk:Ljava/lang/Object;
                //  1039: invokevirtual   gnu/mapping/Procedure.apply1:(Ljava/lang/Object;)Ljava/lang/Object;
                //  1042: goto            2328
                //  1045: aload           $heapFrame
                //  1047: getfield        gnu/kawa/slib/pregexp$frame0.re$1:Ljava/lang/Object;
                //  1050: invokestatic    kawa/lib/lists.cadr:(Ljava/lang/Object;)Ljava/lang/Object;
                //  1053: aload           $heapFrame
                //  1055: getfield        gnu/kawa/slib/pregexp$frame0.i:Ljava/lang/Object;
                //  1058: aload           $heapFrame
                //  1060: getfield        gnu/kawa/slib/pregexp$frame0.lambda$Fn2:Lgnu/expr/ModuleMethod;
                //  1063: aload           $heapFrame
                //  1065: getfield        gnu/kawa/slib/pregexp$frame0.lambda$Fn3:Lgnu/expr/ModuleMethod;
                //  1068: astore          fk
                //  1070: astore          sk
                //  1072: astore_3        /* i */
                //  1073: astore_2        /* re */
                //  1074: goto            0
                //  1077: aload           tmp
                //  1079: getstatic       gnu/kawa/slib/pregexp.Lit31:Lgnu/mapping/SimpleSymbol;
                //  1082: invokestatic    gnu/kawa/functions/IsEqv.apply:(Ljava/lang/Object;Ljava/lang/Object;)Z
                //  1085: ifeq            2265
                //  1088: goto            1637
                //  1091: aload           tmp
                //  1093: getstatic       gnu/kawa/slib/pregexp.Lit1:Lgnu/mapping/SimpleSymbol;
                //  1096: invokestatic    gnu/kawa/functions/IsEqv.apply:(Ljava/lang/Object;Ljava/lang/Object;)Z
                //  1099: ifeq            2265
                //  1102: aload           $heapFrame
                //  1104: aload_1         /* backrefs */
                //  1105: aload           $heapFrame
                //  1107: getfield        gnu/kawa/slib/pregexp$frame0.re$1:Ljava/lang/Object;
                //  1110: ldc             Lgnu/lists/Pair;.class
                //  1112: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //  1115: dup            
                //  1116: astore          8
                //  1118: checkcast       Lgnu/lists/Pair;
                //  1121: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
                //  1124: invokevirtual   gnu/kawa/slib/pregexp$frame0.lambda7loupOr:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                //  1127: goto            2328
                //  1130: aload           tmp
                //  1132: getstatic       gnu/kawa/slib/pregexp.Lit35:Lgnu/mapping/SimpleSymbol;
                //  1135: invokestatic    gnu/kawa/functions/IsEqv.apply:(Ljava/lang/Object;Ljava/lang/Object;)Z
                //  1138: ifeq            2265
                //  1141: aload           $heapFrame
                //  1143: getfield        gnu/kawa/slib/pregexp$frame0.re$1:Ljava/lang/Object;
                //  1146: invokestatic    kawa/lib/lists.cadr:(Ljava/lang/Object;)Ljava/lang/Object;
                //  1149: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
                //  1152: ifeq            1159
                //  1155: iconst_0       
                //  1156: goto            1160
                //  1159: iconst_1       
                //  1160: aload           $heapFrame
                //  1162: swap           
                //  1163: putfield        gnu/kawa/slib/pregexp$frame0.maximal$Qu:Z
                //  1166: aload           $heapFrame
                //  1168: getfield        gnu/kawa/slib/pregexp$frame0.re$1:Ljava/lang/Object;
                //  1171: invokestatic    kawa/lib/lists.caddr:(Ljava/lang/Object;)Ljava/lang/Object;
                //  1174: aload           $heapFrame
                //  1176: swap           
                //  1177: putfield        gnu/kawa/slib/pregexp$frame0.p:Ljava/lang/Object;
                //  1180: aload           $heapFrame
                //  1182: getfield        gnu/kawa/slib/pregexp$frame0.re$1:Ljava/lang/Object;
                //  1185: invokestatic    kawa/lib/lists.cadddr:(Ljava/lang/Object;)Ljava/lang/Object;
                //  1188: aload           $heapFrame
                //  1190: swap           
                //  1191: putfield        gnu/kawa/slib/pregexp$frame0.q:Ljava/lang/Object;
                //  1194: aload           $heapFrame
                //  1196: getfield        gnu/kawa/slib/pregexp$frame0.maximal$Qu:Z
                //  1199: ifeq            1221
                //  1202: aload           $heapFrame
                //  1204: getfield        gnu/kawa/slib/pregexp$frame0.q:Ljava/lang/Object;
                //  1207: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
                //  1210: ifeq            1217
                //  1213: iconst_0       
                //  1214: goto            1222
                //  1217: iconst_1       
                //  1218: goto            1222
                //  1221: iconst_0       
                //  1222: aload           $heapFrame
                //  1224: swap           
                //  1225: putfield        gnu/kawa/slib/pregexp$frame0.could$Mnloop$Mninfinitely$Qu:Z
                //  1228: aload           $heapFrame
                //  1230: getfield        gnu/kawa/slib/pregexp$frame0.re$1:Ljava/lang/Object;
                //  1233: invokestatic    kawa/lib/lists.cddddr:(Ljava/lang/Object;)Ljava/lang/Object;
                //  1236: ldc             Lgnu/lists/Pair;.class
                //  1238: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //  1241: dup            
                //  1242: astore          8
                //  1244: checkcast       Lgnu/lists/Pair;
                //  1247: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
                //  1250: aload           $heapFrame
                //  1252: swap           
                //  1253: putfield        gnu/kawa/slib/pregexp$frame0.re:Ljava/lang/Object;
                //  1256: aload           $heapFrame
                //  1258: aload           $heapFrame
                //  1260: getfield        gnu/kawa/slib/pregexp$frame0.maximal$Qu:Z
                //  1263: ifeq            1272
                //  1266: getstatic       java/lang/Boolean.TRUE:Ljava/lang/Boolean;
                //  1269: goto            1275
                //  1272: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
                //  1275: aload           $heapFrame
                //  1277: getfield        gnu/kawa/slib/pregexp$frame0.q:Ljava/lang/Object;
                //  1280: aload           $heapFrame
                //  1282: getfield        gnu/kawa/slib/pregexp$frame0.re:Ljava/lang/Object;
                //  1285: aload           $heapFrame
                //  1287: getfield        gnu/kawa/slib/pregexp$frame0.p:Ljava/lang/Object;
                //  1290: aload_1         /* backrefs */
                //  1291: getstatic       gnu/kawa/slib/pregexp.Lit40:Lgnu/math/IntNum;
                //  1294: aload           $heapFrame
                //  1296: getfield        gnu/kawa/slib/pregexp$frame0.i:Ljava/lang/Object;
                //  1299: invokevirtual   gnu/kawa/slib/pregexp$frame0.lambda8loupP:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Lgnu/math/IntNum;Ljava/lang/Object;)Ljava/lang/Object;
                //  1302: goto            2328
                //  1305: aload           tmp
                //  1307: getstatic       gnu/kawa/slib/pregexp.Lit63:Lgnu/mapping/SimpleSymbol;
                //  1310: invokestatic    gnu/kawa/functions/IsEqv.apply:(Ljava/lang/Object;Ljava/lang/Object;)Z
                //  1313: ifeq            2265
                //  1316: aload_0         /* this */
                //  1317: getfield        gnu/kawa/slib/pregexp$frame.n:Ljava/lang/Object;
                //  1320: astore          8
                //  1322: aload_0         /* this */
                //  1323: getfield        gnu/kawa/slib/pregexp$frame.sn:Ljava/lang/Object;
                //  1326: astore          sn$Mnactual
                //  1328: aload_0         /* this */
                //  1329: aload           $heapFrame
                //  1331: getfield        gnu/kawa/slib/pregexp$frame0.i:Ljava/lang/Object;
                //  1334: putfield        gnu/kawa/slib/pregexp$frame.n:Ljava/lang/Object;
                //  1337: aload_0         /* this */
                //  1338: aload           $heapFrame
                //  1340: getfield        gnu/kawa/slib/pregexp$frame0.i:Ljava/lang/Object;
                //  1343: putfield        gnu/kawa/slib/pregexp$frame.sn:Ljava/lang/Object;
                //  1346: aload_0         /* this */
                //  1347: aload_1         /* backrefs */
                //  1348: getstatic       gnu/kawa/slib/pregexp.Lit2:Lgnu/mapping/SimpleSymbol;
                //  1351: getstatic       gnu/kawa/slib/pregexp.Lit64:Lgnu/lists/PairWithPosition;
                //  1354: aload           $heapFrame
                //  1356: getfield        gnu/kawa/slib/pregexp$frame0.re$1:Ljava/lang/Object;
                //  1359: invokestatic    kawa/lib/lists.cadr:(Ljava/lang/Object;)Ljava/lang/Object;
                //  1362: getstatic       gnu/kawa/slib/pregexp.Lit4:Lgnu/mapping/SimpleSymbol;
                //  1365: invokestatic    gnu/lists/LList.list4:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
                //  1368: getstatic       gnu/kawa/slib/pregexp.Lit40:Lgnu/math/IntNum;
                //  1371: aload_0         /* this */
                //  1372: getfield        gnu/kawa/slib/pregexp$frame.identity:Lgnu/mapping/Procedure;
                //  1375: getstatic       gnu/kawa/slib/pregexp.lambda$Fn4:Lgnu/expr/ModuleMethod;
                //  1378: invokevirtual   gnu/kawa/slib/pregexp$frame.lambda3sub:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                //  1381: astore          found$Mnit$Qu
                //  1383: aload_0         /* this */
                //  1384: aload           n$Mnactual
                //  1386: putfield        gnu/kawa/slib/pregexp$frame.n:Ljava/lang/Object;
                //  1389: aload_0         /* this */
                //  1390: aload           sn$Mnactual
                //  1392: putfield        gnu/kawa/slib/pregexp$frame.sn:Ljava/lang/Object;
                //  1395: aload           found$Mnit$Qu
                //  1397: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
                //  1400: ifeq            1417
                //  1403: getstatic       kawa/standard/Scheme.applyToArgs:Lgnu/kawa/functions/ApplyToArgs;
                //  1406: aload           $heapFrame
                //  1408: getfield        gnu/kawa/slib/pregexp$frame0.fk:Ljava/lang/Object;
                //  1411: invokevirtual   gnu/mapping/Procedure.apply1:(Ljava/lang/Object;)Ljava/lang/Object;
                //  1414: goto            2328
                //  1417: getstatic       kawa/standard/Scheme.applyToArgs:Lgnu/kawa/functions/ApplyToArgs;
                //  1420: aload           $heapFrame
                //  1422: getfield        gnu/kawa/slib/pregexp$frame0.sk:Ljava/lang/Object;
                //  1425: aload           $heapFrame
                //  1427: getfield        gnu/kawa/slib/pregexp$frame0.i:Ljava/lang/Object;
                //  1430: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                //  1433: goto            2328
                //  1436: aload           tmp
                //  1438: getstatic       gnu/kawa/slib/pregexp.Lit47:Lgnu/mapping/SimpleSymbol;
                //  1441: invokestatic    gnu/kawa/functions/IsEqv.apply:(Ljava/lang/Object;Ljava/lang/Object;)Z
                //  1444: ifeq            2265
                //  1447: aload           $heapFrame
                //  1449: getfield        gnu/kawa/slib/pregexp$frame0.i:Ljava/lang/Object;
                //  1452: aload_0         /* this */
                //  1453: getfield        gnu/kawa/slib/pregexp$frame.n:Ljava/lang/Object;
                //  1456: invokestatic    gnu/kawa/functions/NumberCompare.$Gr$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
                //  1459: ifeq            1476
                //  1462: getstatic       kawa/standard/Scheme.applyToArgs:Lgnu/kawa/functions/ApplyToArgs;
                //  1465: aload           $heapFrame
                //  1467: getfield        gnu/kawa/slib/pregexp$frame0.fk:Ljava/lang/Object;
                //  1470: invokevirtual   gnu/mapping/Procedure.apply1:(Ljava/lang/Object;)Ljava/lang/Object;
                //  1473: goto            2328
                //  1476: aload           $heapFrame
                //  1478: aload_1         /* backrefs */
                //  1479: aload           $heapFrame
                //  1481: getfield        gnu/kawa/slib/pregexp$frame0.re$1:Ljava/lang/Object;
                //  1484: ldc             Lgnu/lists/Pair;.class
                //  1486: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //  1489: dup            
                //  1490: astore          8
                //  1492: checkcast       Lgnu/lists/Pair;
                //  1495: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
                //  1498: invokevirtual   gnu/kawa/slib/pregexp$frame0.lambda10loupOneOfChars:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                //  1501: goto            2328
                //  1504: aload           tmp
                //  1506: getstatic       gnu/kawa/slib/pregexp.Lit65:Lgnu/mapping/SimpleSymbol;
                //  1509: invokestatic    gnu/kawa/functions/IsEqv.apply:(Ljava/lang/Object;Ljava/lang/Object;)Z
                //  1512: ifeq            2265
                //  1515: aload_0         /* this */
                //  1516: aload_1         /* backrefs */
                //  1517: aload           $heapFrame
                //  1519: getfield        gnu/kawa/slib/pregexp$frame0.re$1:Ljava/lang/Object;
                //  1522: invokestatic    kawa/lib/lists.cadr:(Ljava/lang/Object;)Ljava/lang/Object;
                //  1525: aload           $heapFrame
                //  1527: getfield        gnu/kawa/slib/pregexp$frame0.i:Ljava/lang/Object;
                //  1530: aload_0         /* this */
                //  1531: getfield        gnu/kawa/slib/pregexp$frame.identity:Lgnu/mapping/Procedure;
                //  1534: getstatic       gnu/kawa/slib/pregexp.lambda$Fn5:Lgnu/expr/ModuleMethod;
                //  1537: invokevirtual   gnu/kawa/slib/pregexp$frame.lambda3sub:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                //  1540: astore          found$Mnit$Qu
                //  1542: aload           found$Mnit$Qu
                //  1544: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
                //  1547: ifeq            1569
                //  1550: getstatic       kawa/standard/Scheme.applyToArgs:Lgnu/kawa/functions/ApplyToArgs;
                //  1553: aload           $heapFrame
                //  1555: getfield        gnu/kawa/slib/pregexp$frame0.sk:Ljava/lang/Object;
                //  1558: aload           $heapFrame
                //  1560: getfield        gnu/kawa/slib/pregexp$frame0.i:Ljava/lang/Object;
                //  1563: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                //  1566: goto            2328
                //  1569: getstatic       kawa/standard/Scheme.applyToArgs:Lgnu/kawa/functions/ApplyToArgs;
                //  1572: aload           $heapFrame
                //  1574: getfield        gnu/kawa/slib/pregexp$frame0.fk:Ljava/lang/Object;
                //  1577: invokevirtual   gnu/mapping/Procedure.apply1:(Ljava/lang/Object;)Ljava/lang/Object;
                //  1580: goto            2328
                //  1583: aload           tmp
                //  1585: getstatic       gnu/kawa/slib/pregexp.Lit61:Lgnu/mapping/SimpleSymbol;
                //  1588: invokestatic    gnu/kawa/functions/IsEqv.apply:(Ljava/lang/Object;Ljava/lang/Object;)Z
                //  1591: ifeq            2265
                //  1594: aload           $heapFrame
                //  1596: getfield        gnu/kawa/slib/pregexp$frame0.re$1:Ljava/lang/Object;
                //  1599: invokestatic    kawa/lib/lists.cadr:(Ljava/lang/Object;)Ljava/lang/Object;
                //  1602: aload           $heapFrame
                //  1604: getfield        gnu/kawa/slib/pregexp$frame0.i:Ljava/lang/Object;
                //  1607: aload           $heapFrame
                //  1609: getfield        gnu/kawa/slib/pregexp$frame0.lambda$Fn6:Lgnu/expr/ModuleMethod;
                //  1612: aload           $heapFrame
                //  1614: getfield        gnu/kawa/slib/pregexp$frame0.fk:Ljava/lang/Object;
                //  1617: astore          fk
                //  1619: astore          sk
                //  1621: astore_3        /* i */
                //  1622: astore_2        /* re */
                //  1623: goto            0
                //  1626: aload           tmp
                //  1628: getstatic       gnu/kawa/slib/pregexp.Lit32:Lgnu/mapping/SimpleSymbol;
                //  1631: invokestatic    gnu/kawa/functions/IsEqv.apply:(Ljava/lang/Object;Ljava/lang/Object;)Z
                //  1634: ifeq            2265
                //  1637: aload_0         /* this */
                //  1638: getfield        gnu/kawa/slib/pregexp$frame.case$Mnsensitive$Qu:Ljava/lang/Object;
                //  1641: aload           $heapFrame
                //  1643: swap           
                //  1644: putfield        gnu/kawa/slib/pregexp$frame0.old:Ljava/lang/Object;
                //  1647: aload_0         /* this */
                //  1648: aload           $heapFrame
                //  1650: getfield        gnu/kawa/slib/pregexp$frame0.re$1:Ljava/lang/Object;
                //  1653: ldc             Lgnu/lists/Pair;.class
                //  1655: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //  1658: dup            
                //  1659: astore          8
                //  1661: checkcast       Lgnu/lists/Pair;
                //  1664: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
                //  1667: getstatic       gnu/kawa/slib/pregexp.Lit31:Lgnu/mapping/SimpleSymbol;
                //  1670: invokestatic    gnu/kawa/functions/IsEqv.apply:(Ljava/lang/Object;Ljava/lang/Object;)Z
                //  1673: ifeq            1682
                //  1676: getstatic       java/lang/Boolean.TRUE:Ljava/lang/Boolean;
                //  1679: goto            1685
                //  1682: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
                //  1685: putfield        gnu/kawa/slib/pregexp$frame.case$Mnsensitive$Qu:Ljava/lang/Object;
                //  1688: aload           $heapFrame
                //  1690: getfield        gnu/kawa/slib/pregexp$frame0.re$1:Ljava/lang/Object;
                //  1693: invokestatic    kawa/lib/lists.cadr:(Ljava/lang/Object;)Ljava/lang/Object;
                //  1696: aload           $heapFrame
                //  1698: getfield        gnu/kawa/slib/pregexp$frame0.i:Ljava/lang/Object;
                //  1701: aload           $heapFrame
                //  1703: getfield        gnu/kawa/slib/pregexp$frame0.lambda$Fn7:Lgnu/expr/ModuleMethod;
                //  1706: aload           $heapFrame
                //  1708: getfield        gnu/kawa/slib/pregexp$frame0.lambda$Fn8:Lgnu/expr/ModuleMethod;
                //  1711: astore          fk
                //  1713: astore          sk
                //  1715: astore_3        /* i */
                //  1716: astore_2        /* re */
                //  1717: goto            0
                //  1720: aload           tmp
                //  1722: getstatic       gnu/kawa/slib/pregexp.Lit2:Lgnu/mapping/SimpleSymbol;
                //  1725: invokestatic    gnu/kawa/functions/IsEqv.apply:(Ljava/lang/Object;Ljava/lang/Object;)Z
                //  1728: ifeq            2265
                //  1731: aload           $heapFrame
                //  1733: aload_1         /* backrefs */
                //  1734: aload           $heapFrame
                //  1736: getfield        gnu/kawa/slib/pregexp$frame0.re$1:Ljava/lang/Object;
                //  1739: ldc             Lgnu/lists/Pair;.class
                //  1741: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //  1744: dup            
                //  1745: astore          8
                //  1747: checkcast       Lgnu/lists/Pair;
                //  1750: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
                //  1753: aload           $heapFrame
                //  1755: getfield        gnu/kawa/slib/pregexp$frame0.i:Ljava/lang/Object;
                //  1758: invokevirtual   gnu/kawa/slib/pregexp$frame0.lambda15loupSeq:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                //  1761: goto            2328
                //  1764: aload           tmp
                //  1766: getstatic       gnu/kawa/slib/pregexp.Lit66:Lgnu/mapping/SimpleSymbol;
                //  1769: invokestatic    gnu/kawa/functions/IsEqv.apply:(Ljava/lang/Object;Ljava/lang/Object;)Z
                //  1772: ifeq            2265
                //  1775: aload_0         /* this */
                //  1776: aload_1         /* backrefs */
                //  1777: aload           $heapFrame
                //  1779: getfield        gnu/kawa/slib/pregexp$frame0.re$1:Ljava/lang/Object;
                //  1782: invokestatic    kawa/lib/lists.cadr:(Ljava/lang/Object;)Ljava/lang/Object;
                //  1785: aload           $heapFrame
                //  1787: getfield        gnu/kawa/slib/pregexp$frame0.i:Ljava/lang/Object;
                //  1790: aload_0         /* this */
                //  1791: getfield        gnu/kawa/slib/pregexp$frame.identity:Lgnu/mapping/Procedure;
                //  1794: getstatic       gnu/kawa/slib/pregexp.lambda$Fn9:Lgnu/expr/ModuleMethod;
                //  1797: invokevirtual   gnu/kawa/slib/pregexp$frame.lambda3sub:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                //  1800: astore          found$Mnit$Qu
                //  1802: aload           found$Mnit$Qu
                //  1804: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
                //  1807: ifeq            1826
                //  1810: getstatic       kawa/standard/Scheme.applyToArgs:Lgnu/kawa/functions/ApplyToArgs;
                //  1813: aload           $heapFrame
                //  1815: getfield        gnu/kawa/slib/pregexp$frame0.sk:Ljava/lang/Object;
                //  1818: aload           found$Mnit$Qu
                //  1820: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                //  1823: goto            2328
                //  1826: getstatic       kawa/standard/Scheme.applyToArgs:Lgnu/kawa/functions/ApplyToArgs;
                //  1829: aload           $heapFrame
                //  1831: getfield        gnu/kawa/slib/pregexp$frame0.fk:Ljava/lang/Object;
                //  1834: invokevirtual   gnu/mapping/Procedure.apply1:(Ljava/lang/Object;)Ljava/lang/Object;
                //  1837: goto            2328
                //  1840: aload           tmp
                //  1842: getstatic       gnu/kawa/slib/pregexp.Lit67:Lgnu/mapping/SimpleSymbol;
                //  1845: invokestatic    gnu/kawa/functions/IsEqv.apply:(Ljava/lang/Object;Ljava/lang/Object;)Z
                //  1848: ifeq            2265
                //  1851: aload_0         /* this */
                //  1852: aload_1         /* backrefs */
                //  1853: aload           $heapFrame
                //  1855: getfield        gnu/kawa/slib/pregexp$frame0.re$1:Ljava/lang/Object;
                //  1858: invokestatic    kawa/lib/lists.cadr:(Ljava/lang/Object;)Ljava/lang/Object;
                //  1861: aload           $heapFrame
                //  1863: getfield        gnu/kawa/slib/pregexp$frame0.i:Ljava/lang/Object;
                //  1866: aload_0         /* this */
                //  1867: getfield        gnu/kawa/slib/pregexp$frame.identity:Lgnu/mapping/Procedure;
                //  1870: getstatic       gnu/kawa/slib/pregexp.lambda$Fn10:Lgnu/expr/ModuleMethod;
                //  1873: invokevirtual   gnu/kawa/slib/pregexp$frame.lambda3sub:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                //  1876: astore          found$Mnit$Qu
                //  1878: aload           found$Mnit$Qu
                //  1880: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
                //  1883: ifeq            1900
                //  1886: getstatic       kawa/standard/Scheme.applyToArgs:Lgnu/kawa/functions/ApplyToArgs;
                //  1889: aload           $heapFrame
                //  1891: getfield        gnu/kawa/slib/pregexp$frame0.fk:Ljava/lang/Object;
                //  1894: invokevirtual   gnu/mapping/Procedure.apply1:(Ljava/lang/Object;)Ljava/lang/Object;
                //  1897: goto            2328
                //  1900: getstatic       kawa/standard/Scheme.applyToArgs:Lgnu/kawa/functions/ApplyToArgs;
                //  1903: aload           $heapFrame
                //  1905: getfield        gnu/kawa/slib/pregexp$frame0.sk:Ljava/lang/Object;
                //  1908: aload           $heapFrame
                //  1910: getfield        gnu/kawa/slib/pregexp$frame0.i:Ljava/lang/Object;
                //  1913: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                //  1916: goto            2328
                //  1919: aload           tmp
                //  1921: getstatic       gnu/kawa/slib/pregexp.Lit68:Lgnu/mapping/SimpleSymbol;
                //  1924: invokestatic    gnu/kawa/functions/IsEqv.apply:(Ljava/lang/Object;Ljava/lang/Object;)Z
                //  1927: ifeq            2265
                //  1930: aload_0         /* this */
                //  1931: getfield        gnu/kawa/slib/pregexp$frame.n:Ljava/lang/Object;
                //  1934: astore          8
                //  1936: aload_0         /* this */
                //  1937: getfield        gnu/kawa/slib/pregexp$frame.sn:Ljava/lang/Object;
                //  1940: astore          sn$Mnactual
                //  1942: aload_0         /* this */
                //  1943: aload           $heapFrame
                //  1945: getfield        gnu/kawa/slib/pregexp$frame0.i:Ljava/lang/Object;
                //  1948: putfield        gnu/kawa/slib/pregexp$frame.n:Ljava/lang/Object;
                //  1951: aload_0         /* this */
                //  1952: aload           $heapFrame
                //  1954: getfield        gnu/kawa/slib/pregexp$frame0.i:Ljava/lang/Object;
                //  1957: putfield        gnu/kawa/slib/pregexp$frame.sn:Ljava/lang/Object;
                //  1960: aload_0         /* this */
                //  1961: aload_1         /* backrefs */
                //  1962: getstatic       gnu/kawa/slib/pregexp.Lit2:Lgnu/mapping/SimpleSymbol;
                //  1965: getstatic       gnu/kawa/slib/pregexp.Lit64:Lgnu/lists/PairWithPosition;
                //  1968: aload           $heapFrame
                //  1970: getfield        gnu/kawa/slib/pregexp$frame0.re$1:Ljava/lang/Object;
                //  1973: invokestatic    kawa/lib/lists.cadr:(Ljava/lang/Object;)Ljava/lang/Object;
                //  1976: getstatic       gnu/kawa/slib/pregexp.Lit4:Lgnu/mapping/SimpleSymbol;
                //  1979: invokestatic    gnu/lists/LList.list4:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
                //  1982: getstatic       gnu/kawa/slib/pregexp.Lit40:Lgnu/math/IntNum;
                //  1985: aload_0         /* this */
                //  1986: getfield        gnu/kawa/slib/pregexp$frame.identity:Lgnu/mapping/Procedure;
                //  1989: getstatic       gnu/kawa/slib/pregexp.lambda$Fn11:Lgnu/expr/ModuleMethod;
                //  1992: invokevirtual   gnu/kawa/slib/pregexp$frame.lambda3sub:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                //  1995: astore          found$Mnit$Qu
                //  1997: aload_0         /* this */
                //  1998: aload           n$Mnactual
                //  2000: putfield        gnu/kawa/slib/pregexp$frame.n:Ljava/lang/Object;
                //  2003: aload_0         /* this */
                //  2004: aload           sn$Mnactual
                //  2006: putfield        gnu/kawa/slib/pregexp$frame.sn:Ljava/lang/Object;
                //  2009: aload           found$Mnit$Qu
                //  2011: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
                //  2014: ifeq            2036
                //  2017: getstatic       kawa/standard/Scheme.applyToArgs:Lgnu/kawa/functions/ApplyToArgs;
                //  2020: aload           $heapFrame
                //  2022: getfield        gnu/kawa/slib/pregexp$frame0.sk:Ljava/lang/Object;
                //  2025: aload           $heapFrame
                //  2027: getfield        gnu/kawa/slib/pregexp$frame0.i:Ljava/lang/Object;
                //  2030: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                //  2033: goto            2328
                //  2036: getstatic       kawa/standard/Scheme.applyToArgs:Lgnu/kawa/functions/ApplyToArgs;
                //  2039: aload           $heapFrame
                //  2041: getfield        gnu/kawa/slib/pregexp$frame0.fk:Ljava/lang/Object;
                //  2044: invokevirtual   gnu/mapping/Procedure.apply1:(Ljava/lang/Object;)Ljava/lang/Object;
                //  2047: goto            2328
                //  2050: aload           tmp
                //  2052: getstatic       gnu/kawa/slib/pregexp.Lit5:Lgnu/mapping/SimpleSymbol;
                //  2055: invokestatic    gnu/kawa/functions/IsEqv.apply:(Ljava/lang/Object;Ljava/lang/Object;)Z
                //  2058: ifeq            2265
                //  2061: aload_1         /* backrefs */
                //  2062: aload           $heapFrame
                //  2064: getfield        gnu/kawa/slib/pregexp$frame0.re$1:Ljava/lang/Object;
                //  2067: invokestatic    kawa/lib/lists.cadr:(Ljava/lang/Object;)Ljava/lang/Object;
                //  2070: invokestatic    gnu/kawa/slib/pregexp.pregexpListRef:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                //  2073: astore          c
                //  2075: aload           c
                //  2077: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
                //  2080: ifeq            2102
                //  2083: aload           c
                //  2085: ldc             Lgnu/lists/Pair;.class
                //  2087: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //  2090: dup            
                //  2091: astore          10
                //  2093: checkcast       Lgnu/lists/Pair;
                //  2096: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
                //  2099: goto            2133
                //  2102: iconst_3       
                //  2103: anewarray       Ljava/lang/Object;
                //  2106: dup            
                //  2107: iconst_0       
                //  2108: getstatic       gnu/kawa/slib/pregexp.Lit62:Lgnu/mapping/SimpleSymbol;
                //  2111: aastore        
                //  2112: dup            
                //  2113: iconst_1       
                //  2114: getstatic       gnu/kawa/slib/pregexp.Lit69:Lgnu/mapping/SimpleSymbol;
                //  2117: aastore        
                //  2118: dup            
                //  2119: iconst_2       
                //  2120: aload           $heapFrame
                //  2122: getfield        gnu/kawa/slib/pregexp$frame0.re$1:Ljava/lang/Object;
                //  2125: aastore        
                //  2126: invokestatic    kawa/lib/exceptions.error:([Ljava/lang/Object;)Lgnu/bytecode/Type$NeverReturns;
                //  2129: getstatic       gnu/expr/Special.reachedUnexpected:Ljava/lang/RuntimeException;
                //  2132: athrow         
                //  2133: astore          backref
                //  2135: aload           backref
                //  2137: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
                //  2140: ifeq            2246
                //  2143: aload_0         /* this */
                //  2144: getfield        gnu/kawa/slib/pregexp$frame.s:Ljava/lang/Object;
                //  2147: ldc             Ljava/lang/CharSequence;.class
                //  2149: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //  2152: dup            
                //  2153: astore          10
                //  2155: checkcast       Ljava/lang/CharSequence;
                //  2158: aload           backref
                //  2160: ldc             Lgnu/lists/Pair;.class
                //  2162: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //  2165: dup            
                //  2166: astore          10
                //  2168: checkcast       Lgnu/lists/Pair;
                //  2171: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
                //  2174: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
                //  2177: dup            
                //  2178: astore          10
                //  2180: checkcast       Ljava/lang/Number;
                //  2183: invokevirtual   java/lang/Number.intValue:()I
                //  2186: aload           backref
                //  2188: ldc             Lgnu/lists/Pair;.class
                //  2190: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //  2193: dup            
                //  2194: astore          10
                //  2196: checkcast       Lgnu/lists/Pair;
                //  2199: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
                //  2202: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
                //  2205: dup            
                //  2206: astore          10
                //  2208: checkcast       Ljava/lang/Number;
                //  2211: invokevirtual   java/lang/Number.intValue:()I
                //  2214: invokestatic    kawa/lib/strings.substring:(Ljava/lang/CharSequence;II)Ljava/lang/CharSequence;
                //  2217: aload_0         /* this */
                //  2218: getfield        gnu/kawa/slib/pregexp$frame.s:Ljava/lang/Object;
                //  2221: aload           $heapFrame
                //  2223: getfield        gnu/kawa/slib/pregexp$frame0.i:Ljava/lang/Object;
                //  2226: aload_0         /* this */
                //  2227: getfield        gnu/kawa/slib/pregexp$frame.n:Ljava/lang/Object;
                //  2230: aload           $heapFrame
                //  2232: getfield        gnu/kawa/slib/pregexp$frame0.lambda$Fn12:Lgnu/expr/ModuleMethod;
                //  2235: aload           $heapFrame
                //  2237: getfield        gnu/kawa/slib/pregexp$frame0.fk:Ljava/lang/Object;
                //  2240: invokestatic    gnu/kawa/slib/pregexp.pregexpStringMatch:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                //  2243: goto            2328
                //  2246: getstatic       kawa/standard/Scheme.applyToArgs:Lgnu/kawa/functions/ApplyToArgs;
                //  2249: aload           $heapFrame
                //  2251: getfield        gnu/kawa/slib/pregexp$frame0.sk:Ljava/lang/Object;
                //  2254: aload           $heapFrame
                //  2256: getfield        gnu/kawa/slib/pregexp$frame0.i:Ljava/lang/Object;
                //  2259: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                //  2262: goto            2328
                //  2265: iconst_1       
                //  2266: anewarray       Ljava/lang/Object;
                //  2269: dup            
                //  2270: iconst_0       
                //  2271: getstatic       gnu/kawa/slib/pregexp.Lit62:Lgnu/mapping/SimpleSymbol;
                //  2274: aastore        
                //  2275: invokestatic    kawa/lib/exceptions.error:([Ljava/lang/Object;)Lgnu/bytecode/Type$NeverReturns;
                //  2278: getstatic       gnu/expr/Special.reachedUnexpected:Ljava/lang/RuntimeException;
                //  2281: athrow         
                //  2282: aload           $heapFrame
                //  2284: getfield        gnu/kawa/slib/pregexp$frame0.i:Ljava/lang/Object;
                //  2287: aload_0         /* this */
                //  2288: getfield        gnu/kawa/slib/pregexp$frame.n:Ljava/lang/Object;
                //  2291: invokestatic    gnu/kawa/functions/NumberCompare.$Gr$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
                //  2294: ifeq            2311
                //  2297: getstatic       kawa/standard/Scheme.applyToArgs:Lgnu/kawa/functions/ApplyToArgs;
                //  2300: aload           $heapFrame
                //  2302: getfield        gnu/kawa/slib/pregexp$frame0.fk:Ljava/lang/Object;
                //  2305: invokevirtual   gnu/mapping/Procedure.apply1:(Ljava/lang/Object;)Ljava/lang/Object;
                //  2308: goto            2328
                //  2311: iconst_1       
                //  2312: anewarray       Ljava/lang/Object;
                //  2315: dup            
                //  2316: iconst_0       
                //  2317: getstatic       gnu/kawa/slib/pregexp.Lit62:Lgnu/mapping/SimpleSymbol;
                //  2320: aastore        
                //  2321: invokestatic    kawa/lib/exceptions.error:([Ljava/lang/Object;)Lgnu/bytecode/Type$NeverReturns;
                //  2324: getstatic       gnu/expr/Special.reachedUnexpected:Ljava/lang/RuntimeException;
                //  2327: athrow         
                //  2328: areturn        
                //  2329: new             Lgnu/mapping/WrongType;
                //  2332: dup_x1         
                //  2333: swap           
                //  2334: ldc             "string-ref"
                //  2336: iconst_1       
                //  2337: aload           7
                //  2339: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //  2342: athrow         
                //  2343: new             Lgnu/mapping/WrongType;
                //  2346: dup_x1         
                //  2347: swap           
                //  2348: ldc             "string-ref"
                //  2350: iconst_2       
                //  2351: aload           7
                //  2353: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //  2356: athrow         
                //  2357: new             Lgnu/mapping/WrongType;
                //  2360: dup_x1         
                //  2361: swap           
                //  2362: ldc             "string-ref"
                //  2364: iconst_1       
                //  2365: aload           7
                //  2367: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //  2370: athrow         
                //  2371: new             Lgnu/mapping/WrongType;
                //  2374: dup_x1         
                //  2375: swap           
                //  2376: ldc             "string-ref"
                //  2378: iconst_2       
                //  2379: aload           7
                //  2381: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //  2384: athrow         
                //  2385: new             Lgnu/mapping/WrongType;
                //  2388: dup_x1         
                //  2389: swap           
                //  2390: ldc             "car"
                //  2392: iconst_1       
                //  2393: aload           7
                //  2395: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //  2398: athrow         
                //  2399: new             Lgnu/mapping/WrongType;
                //  2402: dup_x1         
                //  2403: swap           
                //  2404: ldc             "string-ref"
                //  2406: iconst_1       
                //  2407: aload           8
                //  2409: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //  2412: athrow         
                //  2413: new             Lgnu/mapping/WrongType;
                //  2416: dup_x1         
                //  2417: swap           
                //  2418: ldc             "string-ref"
                //  2420: iconst_2       
                //  2421: aload           8
                //  2423: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //  2426: athrow         
                //  2427: new             Lgnu/mapping/WrongType;
                //  2430: dup_x1         
                //  2431: swap           
                //  2432: ldc             "car"
                //  2434: iconst_1       
                //  2435: aload           8
                //  2437: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //  2440: athrow         
                //  2441: new             Lgnu/mapping/WrongType;
                //  2444: dup_x1         
                //  2445: swap           
                //  2446: ldc             "cdr"
                //  2448: iconst_1       
                //  2449: aload           8
                //  2451: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //  2454: athrow         
                //  2455: new             Lgnu/mapping/WrongType;
                //  2458: dup_x1         
                //  2459: swap           
                //  2460: ldc             "car"
                //  2462: iconst_1       
                //  2463: aload           8
                //  2465: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //  2468: athrow         
                //  2469: new             Lgnu/mapping/WrongType;
                //  2472: dup_x1         
                //  2473: swap           
                //  2474: ldc             "cdr"
                //  2476: iconst_1       
                //  2477: aload           8
                //  2479: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //  2482: athrow         
                //  2483: new             Lgnu/mapping/WrongType;
                //  2486: dup_x1         
                //  2487: swap           
                //  2488: ldc             "car"
                //  2490: iconst_1       
                //  2491: aload           8
                //  2493: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //  2496: athrow         
                //  2497: new             Lgnu/mapping/WrongType;
                //  2500: dup_x1         
                //  2501: swap           
                //  2502: ldc             "cdr"
                //  2504: iconst_1       
                //  2505: aload           8
                //  2507: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //  2510: athrow         
                //  2511: new             Lgnu/mapping/WrongType;
                //  2514: dup_x1         
                //  2515: swap           
                //  2516: ldc             "cdr"
                //  2518: iconst_1       
                //  2519: aload           10
                //  2521: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //  2524: athrow         
                //  2525: new             Lgnu/mapping/WrongType;
                //  2528: dup_x1         
                //  2529: swap           
                //  2530: ldc_w           "substring"
                //  2533: iconst_1       
                //  2534: aload           10
                //  2536: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //  2539: athrow         
                //  2540: new             Lgnu/mapping/WrongType;
                //  2543: dup_x1         
                //  2544: swap           
                //  2545: ldc             "car"
                //  2547: iconst_1       
                //  2548: aload           10
                //  2550: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //  2553: athrow         
                //  2554: new             Lgnu/mapping/WrongType;
                //  2557: dup_x1         
                //  2558: swap           
                //  2559: ldc_w           "substring"
                //  2562: iconst_2       
                //  2563: aload           10
                //  2565: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //  2568: athrow         
                //  2569: new             Lgnu/mapping/WrongType;
                //  2572: dup_x1         
                //  2573: swap           
                //  2574: ldc             "cdr"
                //  2576: iconst_1       
                //  2577: aload           10
                //  2579: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //  2582: athrow         
                //  2583: new             Lgnu/mapping/WrongType;
                //  2586: dup_x1         
                //  2587: swap           
                //  2588: ldc_w           "substring"
                //  2591: iconst_3       
                //  2592: aload           10
                //  2594: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //  2597: athrow         
                //    Exceptions:
                //  Try           Handler
                //  Start  End    Start  End    Type                          
                //  -----  -----  -----  -----  ------------------------------
                //  386    389    2329   2343   Ljava/lang/ClassCastException;
                //  400    406    2343   2357   Ljava/lang/ClassCastException;
                //  504    507    2357   2371   Ljava/lang/ClassCastException;
                //  518    524    2371   2385   Ljava/lang/ClassCastException;
                //  605    608    2385   2399   Ljava/lang/ClassCastException;
                //  647    650    2399   2413   Ljava/lang/ClassCastException;
                //  661    667    2413   2427   Ljava/lang/ClassCastException;
                //  805    808    2427   2441   Ljava/lang/ClassCastException;
                //  1118   1121   2441   2455   Ljava/lang/ClassCastException;
                //  1244   1247   2455   2469   Ljava/lang/ClassCastException;
                //  1492   1495   2469   2483   Ljava/lang/ClassCastException;
                //  1661   1664   2483   2497   Ljava/lang/ClassCastException;
                //  1747   1750   2497   2511   Ljava/lang/ClassCastException;
                //  2093   2096   2511   2525   Ljava/lang/ClassCastException;
                //  2155   2158   2525   2540   Ljava/lang/ClassCastException;
                //  2168   2171   2540   2554   Ljava/lang/ClassCastException;
                //  2180   2186   2554   2569   Ljava/lang/ClassCastException;
                //  2196   2199   2569   2583   Ljava/lang/ClassCastException;
                //  2208   2214   2583   2598   Ljava/lang/ClassCastException;
                // 
                // The error that occurred was:
                // 
                // java.lang.NullPointerException
                // 
                throw new IllegalStateException("An error occurred while decompiling this method.");
            }
            
            static boolean lambda4() {
                return false;
            }
            
            @Override
            public int match1(final ModuleMethod moduleMethod, final Object o, final CallContext ctx) {
                if (moduleMethod.selector == 15) {
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
                if (method.selector == 15) {
                    return lambda2identity(o);
                }
                return super.apply1(method, o);
            }
        }
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: dup            
        //     4: invokespecial   gnu/kawa/slib/pregexp$frame.<init>:()V
        //     7: astore          $heapFrame
        //     9: aload           $heapFrame
        //    11: aload_1         /* s */
        //    12: putfield        gnu/kawa/slib/pregexp$frame.s:Ljava/lang/Object;
        //    15: aload           $heapFrame
        //    17: aload_2         /* sn */
        //    18: putfield        gnu/kawa/slib/pregexp$frame.sn:Ljava/lang/Object;
        //    21: aload           $heapFrame
        //    23: aload_3         /* start */
        //    24: putfield        gnu/kawa/slib/pregexp$frame.start:Ljava/lang/Object;
        //    27: aload           $heapFrame
        //    29: aload           n
        //    31: putfield        gnu/kawa/slib/pregexp$frame.n:Ljava/lang/Object;
        //    34: aload           $heapFrame
        //    36: getfield        gnu/kawa/slib/pregexp$frame.identity:Lgnu/mapping/Procedure;
        //    39: aload           $heapFrame
        //    41: swap           
        //    42: putfield        gnu/kawa/slib/pregexp$frame.identity:Lgnu/mapping/Procedure;
        //    45: aload_0         /* re */
        //    46: invokestatic    gnu/kawa/slib/pregexp.pregexpMakeBackrefList:(Ljava/lang/Object;)Ljava/lang/Object;
        //    49: aload           $heapFrame
        //    51: swap           
        //    52: putfield        gnu/kawa/slib/pregexp$frame.backrefs:Ljava/lang/Object;
        //    55: getstatic       java/lang/Boolean.TRUE:Ljava/lang/Boolean;
        //    58: aload           $heapFrame
        //    60: swap           
        //    61: putfield        gnu/kawa/slib/pregexp$frame.case$Mnsensitive$Qu:Ljava/lang/Object;
        //    64: aload           $heapFrame
        //    66: aload           $heapFrame
        //    68: getfield        gnu/kawa/slib/pregexp$frame.backrefs:Ljava/lang/Object;
        //    71: aload_0         /* re */
        //    72: aload           i
        //    74: aload           $heapFrame
        //    76: getfield        gnu/kawa/slib/pregexp$frame.identity:Lgnu/mapping/Procedure;
        //    79: getstatic       gnu/kawa/slib/pregexp.lambda$Fn1:Lgnu/expr/ModuleMethod;
        //    82: invokevirtual   gnu/kawa/slib/pregexp$frame.lambda3sub:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    85: pop            
        //    86: aload           $heapFrame
        //    88: getfield        gnu/kawa/slib/pregexp$frame.backrefs:Ljava/lang/Object;
        //    91: invokestatic    gnu/lists/Sequences.getIterator:(Ljava/lang/Object;)Ljava/util/Iterator;
        //    94: astore          8
        //    96: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
        //    99: astore          9
        //   101: aconst_null    
        //   102: astore          10
        //   104: aload           8
        //   106: invokeinterface java/util/Iterator.hasNext:()Z
        //   111: ifeq            172
        //   114: aload           8
        //   116: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //   121: astore          11
        //   123: new             Lgnu/lists/Pair;
        //   126: dup            
        //   127: aload           11
        //   129: ldc             Lgnu/lists/Pair;.class
        //   131: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   134: dup            
        //   135: astore          13
        //   137: checkcast       Lgnu/lists/Pair;
        //   140: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   143: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
        //   146: invokespecial   gnu/lists/Pair.<init>:(Ljava/lang/Object;Ljava/lang/Object;)V
        //   149: aload           10
        //   151: ifnonnull       160
        //   154: dup            
        //   155: astore          9
        //   157: goto            167
        //   160: aload           10
        //   162: swap           
        //   163: dup_x1         
        //   164: invokevirtual   gnu/lists/Pair.setCdr:(Ljava/lang/Object;)V
        //   167: astore          10
        //   169: goto            104
        //   172: aload           9
        //   174: astore          backrefs
        //   176: aload           backrefs
        //   178: dup            
        //   179: astore          8
        //   181: checkcast       Lgnu/lists/Pair;
        //   184: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   187: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //   190: ifeq            198
        //   193: aload           backrefs
        //   195: goto            201
        //   198: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //   201: areturn        
        //   202: new             Lgnu/mapping/WrongType;
        //   205: dup_x1         
        //   206: swap           
        //   207: ldc             "cdr"
        //   209: iconst_1       
        //   210: aload           13
        //   212: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   215: athrow         
        //   216: new             Lgnu/mapping/WrongType;
        //   219: dup_x1         
        //   220: swap           
        //   221: ldc             "car"
        //   223: iconst_1       
        //   224: aload           8
        //   226: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   229: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  137    140    202    216    Ljava/lang/ClassCastException;
        //  181    184    216    230    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0198:
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
    
    public static Object pregexpReplaceAux(final Object str, final Object ins, final Object n, final Object backrefs) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: ldc_w           ""
        //     6: astore          5
        //     8: astore          i
        //    10: aload           i
        //    12: aload_2         /* n */
        //    13: invokestatic    gnu/kawa/functions/NumberCompare.$Gr$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //    16: ifeq            24
        //    19: aload           r
        //    21: goto            444
        //    24: aload_1         /* ins */
        //    25: ldc             Ljava/lang/CharSequence;.class
        //    27: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    30: dup            
        //    31: astore          7
        //    33: checkcast       Ljava/lang/CharSequence;
        //    36: aload           i
        //    38: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //    41: dup            
        //    42: astore          7
        //    44: checkcast       Ljava/lang/Number;
        //    47: invokevirtual   java/lang/Number.intValue:()I
        //    50: invokestatic    kawa/lib/strings.stringRef:(Ljava/lang/CharSequence;I)I
        //    53: istore          c
        //    55: iload           c
        //    57: bipush          92
        //    59: if_icmpne       402
        //    62: aload_1         /* ins */
        //    63: aload           i
        //    65: aload_2         /* n */
        //    66: invokestatic    gnu/kawa/slib/pregexp.pregexpReadEscapedNumber:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    69: astore          br$Mni
        //    71: aload           br$Mni
        //    73: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //    76: ifeq            98
        //    79: aload           br$Mni
        //    81: ldc             Lgnu/lists/Pair;.class
        //    83: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    86: dup            
        //    87: astore          9
        //    89: checkcast       Lgnu/lists/Pair;
        //    92: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    95: goto            148
        //    98: aload_1         /* ins */
        //    99: ldc             Ljava/lang/CharSequence;.class
        //   101: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   104: dup            
        //   105: astore          9
        //   107: checkcast       Ljava/lang/CharSequence;
        //   110: iconst_1       
        //   111: aload           i
        //   113: getstatic       gnu/kawa/slib/pregexp.Lit3:Lgnu/math/IntNum;
        //   116: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   119: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   122: dup            
        //   123: astore          9
        //   125: checkcast       Ljava/lang/Number;
        //   128: invokevirtual   java/lang/Number.intValue:()I
        //   131: invokestatic    kawa/lib/strings.stringRef:(Ljava/lang/CharSequence;I)I
        //   134: bipush          38
        //   136: if_icmpne       145
        //   139: getstatic       gnu/kawa/slib/pregexp.Lit40:Lgnu/math/IntNum;
        //   142: goto            148
        //   145: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //   148: astore          br
        //   150: aload           br$Mni
        //   152: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //   155: ifeq            166
        //   158: aload           br$Mni
        //   160: invokestatic    kawa/lib/lists.cadr:(Ljava/lang/Object;)Ljava/lang/Object;
        //   163: goto            195
        //   166: aload           br
        //   168: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //   171: ifeq            186
        //   174: iconst_1       
        //   175: aload           i
        //   177: getstatic       gnu/kawa/slib/pregexp.Lit11:Lgnu/math/IntNum;
        //   180: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   183: goto            195
        //   186: iconst_1       
        //   187: aload           i
        //   189: getstatic       gnu/kawa/slib/pregexp.Lit3:Lgnu/math/IntNum;
        //   192: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   195: astore          i
        //   197: aload           br
        //   199: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //   202: ifne            290
        //   205: aload_1         /* ins */
        //   206: ldc             Ljava/lang/CharSequence;.class
        //   208: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   211: dup            
        //   212: astore          11
        //   214: checkcast       Ljava/lang/CharSequence;
        //   217: aload           i
        //   219: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   222: dup            
        //   223: astore          11
        //   225: checkcast       Ljava/lang/Number;
        //   228: invokevirtual   java/lang/Number.intValue:()I
        //   231: invokestatic    kawa/lib/strings.stringRef:(Ljava/lang/CharSequence;I)I
        //   234: istore          c2
        //   236: iconst_1       
        //   237: aload           i
        //   239: getstatic       gnu/kawa/slib/pregexp.Lit3:Lgnu/math/IntNum;
        //   242: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   245: iload           c2
        //   247: bipush          36
        //   249: if_icmpne       257
        //   252: aload           r
        //   254: goto            6
        //   257: iconst_2       
        //   258: anewarray       Ljava/lang/Object;
        //   261: dup            
        //   262: iconst_0       
        //   263: aload           r
        //   265: aastore        
        //   266: dup            
        //   267: iconst_1       
        //   268: iconst_1       
        //   269: anewarray       Ljava/lang/Object;
        //   272: dup            
        //   273: iconst_0       
        //   274: iload           c2
        //   276: invokestatic    gnu/text/Char.make:(I)Lgnu/text/Char;
        //   279: aastore        
        //   280: invokestatic    kawa/lib/strings.$make$string$:([Ljava/lang/Object;)Ljava/lang/CharSequence;
        //   283: aastore        
        //   284: invokestatic    kawa/lib/strings.stringAppend:([Ljava/lang/Object;)Lgnu/lists/FString;
        //   287: goto            6
        //   290: aload           i
        //   292: aload_3         /* backrefs */
        //   293: aload           br
        //   295: invokestatic    gnu/kawa/slib/pregexp.pregexpListRef:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   298: astore          backref
        //   300: aload           backref
        //   302: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //   305: ifeq            397
        //   308: iconst_2       
        //   309: anewarray       Ljava/lang/Object;
        //   312: dup            
        //   313: iconst_0       
        //   314: aload           r
        //   316: aastore        
        //   317: dup            
        //   318: iconst_1       
        //   319: aload_0         /* str */
        //   320: ldc             Ljava/lang/CharSequence;.class
        //   322: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   325: dup            
        //   326: astore          11
        //   328: checkcast       Ljava/lang/CharSequence;
        //   331: aload           backref
        //   333: ldc             Lgnu/lists/Pair;.class
        //   335: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   338: dup            
        //   339: astore          11
        //   341: checkcast       Lgnu/lists/Pair;
        //   344: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   347: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   350: dup            
        //   351: astore          11
        //   353: checkcast       Ljava/lang/Number;
        //   356: invokevirtual   java/lang/Number.intValue:()I
        //   359: aload           backref
        //   361: ldc             Lgnu/lists/Pair;.class
        //   363: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   366: dup            
        //   367: astore          11
        //   369: checkcast       Lgnu/lists/Pair;
        //   372: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   375: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   378: dup            
        //   379: astore          11
        //   381: checkcast       Ljava/lang/Number;
        //   384: invokevirtual   java/lang/Number.intValue:()I
        //   387: invokestatic    kawa/lib/strings.substring:(Ljava/lang/CharSequence;II)Ljava/lang/CharSequence;
        //   390: aastore        
        //   391: invokestatic    kawa/lib/strings.stringAppend:([Ljava/lang/Object;)Lgnu/lists/FString;
        //   394: goto            6
        //   397: aload           r
        //   399: goto            6
        //   402: iconst_1       
        //   403: aload           i
        //   405: getstatic       gnu/kawa/slib/pregexp.Lit3:Lgnu/math/IntNum;
        //   408: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   411: iconst_2       
        //   412: anewarray       Ljava/lang/Object;
        //   415: dup            
        //   416: iconst_0       
        //   417: aload           r
        //   419: aastore        
        //   420: dup            
        //   421: iconst_1       
        //   422: iconst_1       
        //   423: anewarray       Ljava/lang/Object;
        //   426: dup            
        //   427: iconst_0       
        //   428: iload           c
        //   430: invokestatic    gnu/text/Char.make:(I)Lgnu/text/Char;
        //   433: aastore        
        //   434: invokestatic    kawa/lib/strings.$make$string$:([Ljava/lang/Object;)Ljava/lang/CharSequence;
        //   437: aastore        
        //   438: invokestatic    kawa/lib/strings.stringAppend:([Ljava/lang/Object;)Lgnu/lists/FString;
        //   441: goto            6
        //   444: areturn        
        //   445: new             Lgnu/mapping/WrongType;
        //   448: dup_x1         
        //   449: swap           
        //   450: ldc             "string-ref"
        //   452: iconst_1       
        //   453: aload           7
        //   455: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   458: athrow         
        //   459: new             Lgnu/mapping/WrongType;
        //   462: dup_x1         
        //   463: swap           
        //   464: ldc             "string-ref"
        //   466: iconst_2       
        //   467: aload           7
        //   469: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   472: athrow         
        //   473: new             Lgnu/mapping/WrongType;
        //   476: dup_x1         
        //   477: swap           
        //   478: ldc             "car"
        //   480: iconst_1       
        //   481: aload           9
        //   483: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   486: athrow         
        //   487: new             Lgnu/mapping/WrongType;
        //   490: dup_x1         
        //   491: swap           
        //   492: ldc             "string-ref"
        //   494: iconst_1       
        //   495: aload           9
        //   497: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   500: athrow         
        //   501: new             Lgnu/mapping/WrongType;
        //   504: dup_x1         
        //   505: swap           
        //   506: ldc             "string-ref"
        //   508: iconst_2       
        //   509: aload           9
        //   511: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   514: athrow         
        //   515: new             Lgnu/mapping/WrongType;
        //   518: dup_x1         
        //   519: swap           
        //   520: ldc             "string-ref"
        //   522: iconst_1       
        //   523: aload           11
        //   525: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   528: athrow         
        //   529: new             Lgnu/mapping/WrongType;
        //   532: dup_x1         
        //   533: swap           
        //   534: ldc             "string-ref"
        //   536: iconst_2       
        //   537: aload           11
        //   539: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   542: athrow         
        //   543: new             Lgnu/mapping/WrongType;
        //   546: dup_x1         
        //   547: swap           
        //   548: ldc_w           "substring"
        //   551: iconst_1       
        //   552: aload           11
        //   554: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   557: athrow         
        //   558: new             Lgnu/mapping/WrongType;
        //   561: dup_x1         
        //   562: swap           
        //   563: ldc             "car"
        //   565: iconst_1       
        //   566: aload           11
        //   568: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   571: athrow         
        //   572: new             Lgnu/mapping/WrongType;
        //   575: dup_x1         
        //   576: swap           
        //   577: ldc_w           "substring"
        //   580: iconst_2       
        //   581: aload           11
        //   583: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   586: athrow         
        //   587: new             Lgnu/mapping/WrongType;
        //   590: dup_x1         
        //   591: swap           
        //   592: ldc             "cdr"
        //   594: iconst_1       
        //   595: aload           11
        //   597: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   600: athrow         
        //   601: new             Lgnu/mapping/WrongType;
        //   604: dup_x1         
        //   605: swap           
        //   606: ldc_w           "substring"
        //   609: iconst_3       
        //   610: aload           11
        //   612: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   615: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  33     36     445    459    Ljava/lang/ClassCastException;
        //  44     50     459    473    Ljava/lang/ClassCastException;
        //  89     92     473    487    Ljava/lang/ClassCastException;
        //  107    110    487    501    Ljava/lang/ClassCastException;
        //  125    131    501    515    Ljava/lang/ClassCastException;
        //  214    217    515    529    Ljava/lang/ClassCastException;
        //  225    231    529    543    Ljava/lang/ClassCastException;
        //  328    331    543    558    Ljava/lang/ClassCastException;
        //  341    344    558    572    Ljava/lang/ClassCastException;
        //  353    359    572    587    Ljava/lang/ClassCastException;
        //  369    372    587    601    Ljava/lang/ClassCastException;
        //  381    387    601    616    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public static Pair pregexp(final Object s) {
        gnu.kawa.slib.pregexp.$Stpregexp$Mnspace$Mnsensitive$Qu$St = Boolean.TRUE;
        final SimpleSymbol lit61 = gnu.kawa.slib.pregexp.Lit61;
        final IntNum lit62 = gnu.kawa.slib.pregexp.Lit40;
        Object o2;
        final Object o = o2 = Promise.force(s, CharSequence.class);
        Object o3;
        try {
            o3 = (o2 = Promise.force(pregexpReadPattern(s, lit62, strings.stringLength((CharSequence)o)), Pair.class));
            final Pair pair = (Pair)o3;
            final Object o4 = lists.car(pair);
            return LList.list2(lit61, o4);
        }
        catch (ClassCastException ex) {
            throw new WrongType(ex, "string-length", 1, o2);
        }
        try {
            final Pair pair = (Pair)o3;
            final Object o4 = lists.car(pair);
            return LList.list2(lit61, o4);
        }
        catch (ClassCastException ex2) {
            throw new WrongType(ex2, "car", 1, o2);
        }
    }
    
    public static Object pregexpMatchPositions$V(final Object pat, final Object str, final Object[] argsArray) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: iconst_0       
        //     2: invokestatic    gnu/lists/LList.makeList:([Ljava/lang/Object;I)Lgnu/lists/LList;
        //     5: dup            
        //     6: astore          4
        //     8: astore_3        /* opt$Mnargs */
        //     9: aload_0         /* pat */
        //    10: invokestatic    kawa/lib/strings.isString:(Ljava/lang/Object;)Z
        //    13: ifeq            24
        //    16: aload_0         /* pat */
        //    17: invokestatic    gnu/kawa/slib/pregexp.pregexp:(Ljava/lang/Object;)Lgnu/lists/Pair;
        //    20: astore_0        /* pat */
        //    21: goto            61
        //    24: aload_0         /* pat */
        //    25: invokestatic    kawa/lib/lists.isPair:(Ljava/lang/Object;)Z
        //    28: ifeq            34
        //    31: goto            61
        //    34: iconst_3       
        //    35: anewarray       Ljava/lang/Object;
        //    38: dup            
        //    39: iconst_0       
        //    40: getstatic       gnu/kawa/slib/pregexp.Lit71:Lgnu/mapping/SimpleSymbol;
        //    43: aastore        
        //    44: dup            
        //    45: iconst_1       
        //    46: getstatic       gnu/kawa/slib/pregexp.Lit72:Lgnu/mapping/SimpleSymbol;
        //    49: aastore        
        //    50: dup            
        //    51: iconst_2       
        //    52: aload_0         /* pat */
        //    53: aastore        
        //    54: invokestatic    kawa/lib/exceptions.error:([Ljava/lang/Object;)Lgnu/bytecode/Type$NeverReturns;
        //    57: getstatic       gnu/expr/Special.reachedUnexpected:Ljava/lang/RuntimeException;
        //    60: athrow         
        //    61: aload_1         /* str */
        //    62: ldc             Ljava/lang/CharSequence;.class
        //    64: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    67: dup            
        //    68: astore          5
        //    70: checkcast       Ljava/lang/CharSequence;
        //    73: invokestatic    kawa/lib/strings.stringLength:(Ljava/lang/CharSequence;)I
        //    76: istore          str$Mnlen
        //    78: aload_3         /* opt$Mnargs */
        //    79: invokestatic    kawa/lib/lists.isNull:(Ljava/lang/Object;)Z
        //    82: ifeq            91
        //    85: getstatic       gnu/kawa/slib/pregexp.Lit40:Lgnu/math/IntNum;
        //    88: goto            127
        //    91: aload_3         /* opt$Mnargs */
        //    92: dup            
        //    93: astore          7
        //    95: checkcast       Lgnu/lists/Pair;
        //    98: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   101: astore          start
        //   103: aload_3         /* opt$Mnargs */
        //   104: dup            
        //   105: astore          7
        //   107: checkcast       Lgnu/lists/Pair;
        //   110: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   113: ldc             Lgnu/lists/LList;.class
        //   115: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   118: dup            
        //   119: astore          7
        //   121: checkcast       Lgnu/lists/LList;
        //   124: astore_3        /* opt$Mnargs */
        //   125: aload           start
        //   127: astore          start
        //   129: aload_3         /* opt$Mnargs */
        //   130: invokestatic    kawa/lib/lists.isNull:(Ljava/lang/Object;)Z
        //   133: ifeq            144
        //   136: iload           str$Mnlen
        //   138: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //   141: goto            154
        //   144: aload_3         /* opt$Mnargs */
        //   145: dup            
        //   146: astore          7
        //   148: checkcast       Lgnu/lists/Pair;
        //   151: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   154: astore          end
        //   156: aload           start
        //   158: astore          i
        //   160: aload           i
        //   162: aload           end
        //   164: invokestatic    gnu/kawa/functions/NumberCompare.$Ls$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   167: ifeq            213
        //   170: aload_0         /* pat */
        //   171: aload_1         /* str */
        //   172: iload           str$Mnlen
        //   174: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //   177: aload           start
        //   179: aload           end
        //   181: aload           i
        //   183: invokestatic    gnu/kawa/slib/pregexp.pregexpMatchPositionsAux:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   186: astore          x
        //   188: aload           x
        //   190: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //   193: ifeq            201
        //   196: aload           x
        //   198: goto            216
        //   201: iconst_1       
        //   202: aload           i
        //   204: getstatic       gnu/kawa/slib/pregexp.Lit3:Lgnu/math/IntNum;
        //   207: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   210: goto            158
        //   213: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //   216: areturn        
        //   217: new             Lgnu/mapping/WrongType;
        //   220: dup_x1         
        //   221: swap           
        //   222: ldc_w           "string-length"
        //   225: iconst_1       
        //   226: aload           5
        //   228: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   231: athrow         
        //   232: new             Lgnu/mapping/WrongType;
        //   235: dup_x1         
        //   236: swap           
        //   237: ldc             "car"
        //   239: iconst_1       
        //   240: aload           7
        //   242: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   245: athrow         
        //   246: new             Lgnu/mapping/WrongType;
        //   249: dup_x1         
        //   250: swap           
        //   251: ldc             "cdr"
        //   253: iconst_1       
        //   254: aload           7
        //   256: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   259: athrow         
        //   260: new             Lgnu/mapping/WrongType;
        //   263: dup_x1         
        //   264: swap           
        //   265: ldc_w           "opt-args"
        //   268: bipush          -2
        //   270: aload           7
        //   272: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   275: athrow         
        //   276: new             Lgnu/mapping/WrongType;
        //   279: dup_x1         
        //   280: swap           
        //   281: ldc             "car"
        //   283: iconst_1       
        //   284: aload           7
        //   286: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   289: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  70     73     217    232    Ljava/lang/ClassCastException;
        //  95     98     232    246    Ljava/lang/ClassCastException;
        //  107    110    246    260    Ljava/lang/ClassCastException;
        //  121    124    260    276    Ljava/lang/ClassCastException;
        //  148    151    276    290    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 145 out of bounds for length 145
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
    
    public static Object pregexpMatch$V(final Object pat, final Object str, final Object[] argsArray) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: iconst_0       
        //     2: invokestatic    gnu/lists/LList.makeList:([Ljava/lang/Object;I)Lgnu/lists/LList;
        //     5: dup            
        //     6: astore          4
        //     8: astore_3        /* opt$Mnargs */
        //     9: getstatic       kawa/standard/Scheme.apply:Lgnu/kawa/functions/Apply;
        //    12: getstatic       gnu/kawa/slib/pregexp.pregexp$Mnmatch$Mnpositions:Lgnu/expr/ModuleMethod;
        //    15: aload_0         /* pat */
        //    16: aload_1         /* str */
        //    17: aload_3         /* opt$Mnargs */
        //    18: invokevirtual   gnu/mapping/Procedure.apply4:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    21: astore          ix$Mnprs
        //    23: aload           ix$Mnprs
        //    25: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //    28: ifeq            188
        //    31: aload           ix$Mnprs
        //    33: invokestatic    gnu/lists/Sequences.getIterator:(Ljava/lang/Object;)Ljava/util/Iterator;
        //    36: astore          5
        //    38: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
        //    41: astore          6
        //    43: aconst_null    
        //    44: astore          7
        //    46: aload           5
        //    48: invokeinterface java/util/Iterator.hasNext:()Z
        //    53: ifeq            183
        //    56: aload           5
        //    58: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //    63: astore          8
        //    65: new             Lgnu/lists/Pair;
        //    68: dup            
        //    69: aload           8
        //    71: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //    74: ifeq            151
        //    77: aload_1         /* str */
        //    78: ldc             Ljava/lang/CharSequence;.class
        //    80: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    83: dup            
        //    84: astore          10
        //    86: checkcast       Ljava/lang/CharSequence;
        //    89: aload           8
        //    91: ldc             Lgnu/lists/Pair;.class
        //    93: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    96: dup            
        //    97: astore          10
        //    99: checkcast       Lgnu/lists/Pair;
        //   102: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   105: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   108: dup            
        //   109: astore          10
        //   111: checkcast       Ljava/lang/Number;
        //   114: invokevirtual   java/lang/Number.intValue:()I
        //   117: aload           8
        //   119: ldc             Lgnu/lists/Pair;.class
        //   121: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   124: dup            
        //   125: astore          10
        //   127: checkcast       Lgnu/lists/Pair;
        //   130: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   133: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   136: dup            
        //   137: astore          10
        //   139: checkcast       Ljava/lang/Number;
        //   142: invokevirtual   java/lang/Number.intValue:()I
        //   145: invokestatic    kawa/lib/strings.substring:(Ljava/lang/CharSequence;II)Ljava/lang/CharSequence;
        //   148: goto            154
        //   151: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //   154: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
        //   157: invokespecial   gnu/lists/Pair.<init>:(Ljava/lang/Object;Ljava/lang/Object;)V
        //   160: aload           7
        //   162: ifnonnull       171
        //   165: dup            
        //   166: astore          6
        //   168: goto            178
        //   171: aload           7
        //   173: swap           
        //   174: dup_x1         
        //   175: invokevirtual   gnu/lists/Pair.setCdr:(Ljava/lang/Object;)V
        //   178: astore          7
        //   180: goto            46
        //   183: aload           6
        //   185: goto            191
        //   188: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //   191: areturn        
        //   192: new             Lgnu/mapping/WrongType;
        //   195: dup_x1         
        //   196: swap           
        //   197: ldc_w           "substring"
        //   200: iconst_1       
        //   201: aload           10
        //   203: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   206: athrow         
        //   207: new             Lgnu/mapping/WrongType;
        //   210: dup_x1         
        //   211: swap           
        //   212: ldc             "car"
        //   214: iconst_1       
        //   215: aload           10
        //   217: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   220: athrow         
        //   221: new             Lgnu/mapping/WrongType;
        //   224: dup_x1         
        //   225: swap           
        //   226: ldc_w           "substring"
        //   229: iconst_2       
        //   230: aload           10
        //   232: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   235: athrow         
        //   236: new             Lgnu/mapping/WrongType;
        //   239: dup_x1         
        //   240: swap           
        //   241: ldc             "cdr"
        //   243: iconst_1       
        //   244: aload           10
        //   246: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   249: athrow         
        //   250: new             Lgnu/mapping/WrongType;
        //   253: dup_x1         
        //   254: swap           
        //   255: ldc_w           "substring"
        //   258: iconst_3       
        //   259: aload           10
        //   261: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   264: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  86     89     192    207    Ljava/lang/ClassCastException;
        //  99     102    207    221    Ljava/lang/ClassCastException;
        //  111    117    221    236    Ljava/lang/ClassCastException;
        //  127    130    236    250    Ljava/lang/ClassCastException;
        //  139    145    250    265    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 124 out of bounds for length 124
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
    
    public static Object pregexpSplit(final Object pat, final Object str) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             Ljava/lang/CharSequence;.class
        //     3: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //     6: dup            
        //     7: astore_3       
        //     8: checkcast       Ljava/lang/CharSequence;
        //    11: invokestatic    kawa/lib/strings.stringLength:(Ljava/lang/CharSequence;)I
        //    14: istore_2        /* n */
        //    15: getstatic       gnu/kawa/slib/pregexp.Lit40:Lgnu/math/IntNum;
        //    18: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
        //    21: iconst_0       
        //    22: istore          5
        //    24: astore          4
        //    26: astore_3        /* i */
        //    27: aload_3         /* i */
        //    28: iload_2         /* n */
        //    29: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //    32: invokestatic    gnu/kawa/functions/NumberCompare.$Gr$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //    35: ifeq            46
        //    38: aload           r
        //    40: invokestatic    gnu/kawa/slib/pregexp.pregexpReverse$Ex:(Ljava/lang/Object;)Ljava/lang/Object;
        //    43: goto            325
        //    46: aload_0         /* pat */
        //    47: aload_1         /* str */
        //    48: iconst_2       
        //    49: anewarray       Ljava/lang/Object;
        //    52: dup            
        //    53: iconst_0       
        //    54: aload_3         /* i */
        //    55: aastore        
        //    56: dup            
        //    57: iconst_1       
        //    58: iload_2         /* n */
        //    59: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //    62: aastore        
        //    63: invokestatic    gnu/kawa/slib/pregexp.pregexpMatchPositions$V:(Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
        //    66: astore          temp
        //    68: aload           temp
        //    70: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //    73: ifeq            283
        //    76: aload           temp
        //    78: ldc             Lgnu/lists/Pair;.class
        //    80: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    83: dup            
        //    84: astore          8
        //    86: checkcast       Lgnu/lists/Pair;
        //    89: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    92: astore          jk
        //    94: aload           jk
        //    96: ldc             Lgnu/lists/Pair;.class
        //    98: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   101: dup            
        //   102: astore          9
        //   104: checkcast       Lgnu/lists/Pair;
        //   107: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   110: astore          8
        //   112: aload           jk
        //   114: ldc             Lgnu/lists/Pair;.class
        //   116: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   119: dup            
        //   120: astore          10
        //   122: checkcast       Lgnu/lists/Pair;
        //   125: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   128: astore          k
        //   130: aload           j
        //   132: aload           k
        //   134: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   137: ifeq            207
        //   140: iconst_1       
        //   141: aload           k
        //   143: getstatic       gnu/kawa/slib/pregexp.Lit3:Lgnu/math/IntNum;
        //   146: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   149: aload_1         /* str */
        //   150: ldc             Ljava/lang/CharSequence;.class
        //   152: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   155: dup            
        //   156: astore          10
        //   158: checkcast       Ljava/lang/CharSequence;
        //   161: aload_3         /* i */
        //   162: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   165: dup            
        //   166: astore          10
        //   168: checkcast       Ljava/lang/Number;
        //   171: invokevirtual   java/lang/Number.intValue:()I
        //   174: iconst_1       
        //   175: aload           j
        //   177: getstatic       gnu/kawa/slib/pregexp.Lit3:Lgnu/math/IntNum;
        //   180: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   183: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   186: dup            
        //   187: astore          10
        //   189: checkcast       Ljava/lang/Number;
        //   192: invokevirtual   java/lang/Number.intValue:()I
        //   195: invokestatic    kawa/lib/strings.substring:(Ljava/lang/CharSequence;II)Ljava/lang/CharSequence;
        //   198: aload           r
        //   200: invokestatic    kawa/lib/lists.cons:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //   203: iconst_1       
        //   204: goto            22
        //   207: aload           j
        //   209: aload_3         /* i */
        //   210: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   213: ifeq            230
        //   216: iload           picked$Mnup$Mnone$Mnundelimited$Mnchar$Qu
        //   218: ifeq            230
        //   221: aload           k
        //   223: iconst_0       
        //   224: istore          picked$Mnup$Mnone$Mnundelimited$Mnchar$Qu
        //   226: astore_3        /* i */
        //   227: goto            27
        //   230: aload           k
        //   232: aload_1         /* str */
        //   233: ldc             Ljava/lang/CharSequence;.class
        //   235: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   238: dup            
        //   239: astore          10
        //   241: checkcast       Ljava/lang/CharSequence;
        //   244: aload_3         /* i */
        //   245: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   248: dup            
        //   249: astore          10
        //   251: checkcast       Ljava/lang/Number;
        //   254: invokevirtual   java/lang/Number.intValue:()I
        //   257: aload           j
        //   259: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   262: dup            
        //   263: astore          10
        //   265: checkcast       Ljava/lang/Number;
        //   268: invokevirtual   java/lang/Number.intValue:()I
        //   271: invokestatic    kawa/lib/strings.substring:(Ljava/lang/CharSequence;II)Ljava/lang/CharSequence;
        //   274: aload           r
        //   276: invokestatic    kawa/lib/lists.cons:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //   279: iconst_0       
        //   280: goto            22
        //   283: iload_2         /* n */
        //   284: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //   287: aload_1         /* str */
        //   288: ldc             Ljava/lang/CharSequence;.class
        //   290: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   293: dup            
        //   294: astore          7
        //   296: checkcast       Ljava/lang/CharSequence;
        //   299: aload_3         /* i */
        //   300: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   303: dup            
        //   304: astore          7
        //   306: checkcast       Ljava/lang/Number;
        //   309: invokevirtual   java/lang/Number.intValue:()I
        //   312: iload_2         /* n */
        //   313: invokestatic    kawa/lib/strings.substring:(Ljava/lang/CharSequence;II)Ljava/lang/CharSequence;
        //   316: aload           r
        //   318: invokestatic    kawa/lib/lists.cons:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //   321: iconst_0       
        //   322: goto            22
        //   325: areturn        
        //   326: new             Lgnu/mapping/WrongType;
        //   329: dup_x1         
        //   330: swap           
        //   331: ldc_w           "string-length"
        //   334: iconst_1       
        //   335: aload_3        
        //   336: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   339: athrow         
        //   340: new             Lgnu/mapping/WrongType;
        //   343: dup_x1         
        //   344: swap           
        //   345: ldc             "car"
        //   347: iconst_1       
        //   348: aload           8
        //   350: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   353: athrow         
        //   354: new             Lgnu/mapping/WrongType;
        //   357: dup_x1         
        //   358: swap           
        //   359: ldc             "car"
        //   361: iconst_1       
        //   362: aload           9
        //   364: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   367: athrow         
        //   368: new             Lgnu/mapping/WrongType;
        //   371: dup_x1         
        //   372: swap           
        //   373: ldc             "cdr"
        //   375: iconst_1       
        //   376: aload           10
        //   378: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   381: athrow         
        //   382: new             Lgnu/mapping/WrongType;
        //   385: dup_x1         
        //   386: swap           
        //   387: ldc_w           "substring"
        //   390: iconst_1       
        //   391: aload           10
        //   393: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   396: athrow         
        //   397: new             Lgnu/mapping/WrongType;
        //   400: dup_x1         
        //   401: swap           
        //   402: ldc_w           "substring"
        //   405: iconst_2       
        //   406: aload           10
        //   408: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   411: athrow         
        //   412: new             Lgnu/mapping/WrongType;
        //   415: dup_x1         
        //   416: swap           
        //   417: ldc_w           "substring"
        //   420: iconst_3       
        //   421: aload           10
        //   423: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   426: athrow         
        //   427: new             Lgnu/mapping/WrongType;
        //   430: dup_x1         
        //   431: swap           
        //   432: ldc_w           "substring"
        //   435: iconst_1       
        //   436: aload           10
        //   438: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   441: athrow         
        //   442: new             Lgnu/mapping/WrongType;
        //   445: dup_x1         
        //   446: swap           
        //   447: ldc_w           "substring"
        //   450: iconst_2       
        //   451: aload           10
        //   453: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   456: athrow         
        //   457: new             Lgnu/mapping/WrongType;
        //   460: dup_x1         
        //   461: swap           
        //   462: ldc_w           "substring"
        //   465: iconst_3       
        //   466: aload           10
        //   468: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   471: athrow         
        //   472: new             Lgnu/mapping/WrongType;
        //   475: dup_x1         
        //   476: swap           
        //   477: ldc_w           "substring"
        //   480: iconst_1       
        //   481: aload           7
        //   483: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   486: athrow         
        //   487: new             Lgnu/mapping/WrongType;
        //   490: dup_x1         
        //   491: swap           
        //   492: ldc_w           "substring"
        //   495: iconst_2       
        //   496: aload           7
        //   498: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   501: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  8      11     326    340    Ljava/lang/ClassCastException;
        //  86     89     340    354    Ljava/lang/ClassCastException;
        //  104    107    354    368    Ljava/lang/ClassCastException;
        //  122    125    368    382    Ljava/lang/ClassCastException;
        //  158    161    382    397    Ljava/lang/ClassCastException;
        //  168    174    397    412    Ljava/lang/ClassCastException;
        //  189    195    412    427    Ljava/lang/ClassCastException;
        //  241    244    427    442    Ljava/lang/ClassCastException;
        //  251    257    442    457    Ljava/lang/ClassCastException;
        //  265    271    457    472    Ljava/lang/ClassCastException;
        //  296    299    472    487    Ljava/lang/ClassCastException;
        //  306    312    487    502    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public static Object pregexpReplace(final Object pat, final Object str, final Object ins) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             Ljava/lang/CharSequence;.class
        //     3: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //     6: dup            
        //     7: astore          4
        //     9: checkcast       Ljava/lang/CharSequence;
        //    12: invokestatic    kawa/lib/strings.stringLength:(Ljava/lang/CharSequence;)I
        //    15: istore_3        /* n */
        //    16: aload_0         /* pat */
        //    17: aload_1         /* str */
        //    18: iconst_2       
        //    19: anewarray       Ljava/lang/Object;
        //    22: dup            
        //    23: iconst_0       
        //    24: getstatic       gnu/kawa/slib/pregexp.Lit40:Lgnu/math/IntNum;
        //    27: aastore        
        //    28: dup            
        //    29: iconst_1       
        //    30: iload_3         /* n */
        //    31: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //    34: aastore        
        //    35: invokestatic    gnu/kawa/slib/pregexp.pregexpMatchPositions$V:(Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
        //    38: astore          pp
        //    40: aload           pp
        //    42: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //    45: ifne            52
        //    48: aload_1         /* str */
        //    49: goto            171
        //    52: aload_2         /* ins */
        //    53: ldc             Ljava/lang/CharSequence;.class
        //    55: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    58: dup            
        //    59: astore          6
        //    61: checkcast       Ljava/lang/CharSequence;
        //    64: invokestatic    kawa/lib/strings.stringLength:(Ljava/lang/CharSequence;)I
        //    67: istore          5
        //    69: aload           pp
        //    71: invokestatic    kawa/lib/lists.caar:(Ljava/lang/Object;)Ljava/lang/Object;
        //    74: astore          6
        //    76: aload           pp
        //    78: invokestatic    kawa/lib/lists.cdar:(Ljava/lang/Object;)Ljava/lang/Object;
        //    81: astore          m$Mnn
        //    83: iconst_3       
        //    84: anewarray       Ljava/lang/Object;
        //    87: dup            
        //    88: iconst_0       
        //    89: aload_1         /* str */
        //    90: ldc             Ljava/lang/CharSequence;.class
        //    92: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    95: dup            
        //    96: astore          8
        //    98: checkcast       Ljava/lang/CharSequence;
        //   101: iconst_0       
        //   102: aload           m$Mni
        //   104: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   107: dup            
        //   108: astore          8
        //   110: checkcast       Ljava/lang/Number;
        //   113: invokevirtual   java/lang/Number.intValue:()I
        //   116: invokestatic    kawa/lib/strings.substring:(Ljava/lang/CharSequence;II)Ljava/lang/CharSequence;
        //   119: aastore        
        //   120: dup            
        //   121: iconst_1       
        //   122: aload_1         /* str */
        //   123: aload_2         /* ins */
        //   124: iload           ins$Mnlen
        //   126: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //   129: aload           pp
        //   131: invokestatic    gnu/kawa/slib/pregexp.pregexpReplaceAux:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   134: aastore        
        //   135: dup            
        //   136: iconst_2       
        //   137: aload_1         /* str */
        //   138: ldc             Ljava/lang/CharSequence;.class
        //   140: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   143: dup            
        //   144: astore          8
        //   146: checkcast       Ljava/lang/CharSequence;
        //   149: aload           m$Mnn
        //   151: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   154: dup            
        //   155: astore          8
        //   157: checkcast       Ljava/lang/Number;
        //   160: invokevirtual   java/lang/Number.intValue:()I
        //   163: iload_3         /* n */
        //   164: invokestatic    kawa/lib/strings.substring:(Ljava/lang/CharSequence;II)Ljava/lang/CharSequence;
        //   167: aastore        
        //   168: invokestatic    kawa/lib/strings.stringAppend:([Ljava/lang/Object;)Lgnu/lists/FString;
        //   171: areturn        
        //   172: new             Lgnu/mapping/WrongType;
        //   175: dup_x1         
        //   176: swap           
        //   177: ldc_w           "string-length"
        //   180: iconst_1       
        //   181: aload           4
        //   183: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   186: athrow         
        //   187: new             Lgnu/mapping/WrongType;
        //   190: dup_x1         
        //   191: swap           
        //   192: ldc_w           "string-length"
        //   195: iconst_1       
        //   196: aload           6
        //   198: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   201: athrow         
        //   202: new             Lgnu/mapping/WrongType;
        //   205: dup_x1         
        //   206: swap           
        //   207: ldc_w           "substring"
        //   210: iconst_1       
        //   211: aload           8
        //   213: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   216: athrow         
        //   217: new             Lgnu/mapping/WrongType;
        //   220: dup_x1         
        //   221: swap           
        //   222: ldc_w           "substring"
        //   225: iconst_3       
        //   226: aload           8
        //   228: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   231: athrow         
        //   232: new             Lgnu/mapping/WrongType;
        //   235: dup_x1         
        //   236: swap           
        //   237: ldc_w           "substring"
        //   240: iconst_1       
        //   241: aload           8
        //   243: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   246: athrow         
        //   247: new             Lgnu/mapping/WrongType;
        //   250: dup_x1         
        //   251: swap           
        //   252: ldc_w           "substring"
        //   255: iconst_2       
        //   256: aload           8
        //   258: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   261: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  9      12     172    187    Ljava/lang/ClassCastException;
        //  61     64     187    202    Ljava/lang/ClassCastException;
        //  98     101    202    217    Ljava/lang/ClassCastException;
        //  110    116    217    232    Ljava/lang/ClassCastException;
        //  146    149    232    247    Ljava/lang/ClassCastException;
        //  157    163    247    262    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public static Object pregexpReplace$St(final Object pat, final Object str, final Object ins) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokestatic    kawa/lib/strings.isString:(Ljava/lang/Object;)Z
        //     4: ifeq            14
        //     7: aload_0         /* pat */
        //     8: invokestatic    gnu/kawa/slib/pregexp.pregexp:(Ljava/lang/Object;)Lgnu/lists/Pair;
        //    11: goto            15
        //    14: aload_0         /* pat */
        //    15: astore_3       
        //    16: aload_1         /* str */
        //    17: ldc             Ljava/lang/CharSequence;.class
        //    19: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    22: dup            
        //    23: astore          5
        //    25: checkcast       Ljava/lang/CharSequence;
        //    28: invokestatic    kawa/lib/strings.stringLength:(Ljava/lang/CharSequence;)I
        //    31: istore          4
        //    33: aload_2         /* ins */
        //    34: ldc             Ljava/lang/CharSequence;.class
        //    36: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    39: dup            
        //    40: astore          6
        //    42: checkcast       Ljava/lang/CharSequence;
        //    45: invokestatic    kawa/lib/strings.stringLength:(Ljava/lang/CharSequence;)I
        //    48: istore          ins$Mnlen
        //    50: getstatic       gnu/kawa/slib/pregexp.Lit40:Lgnu/math/IntNum;
        //    53: ldc_w           ""
        //    56: astore          7
        //    58: astore          i
        //    60: aload           i
        //    62: iload           n
        //    64: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //    67: invokestatic    gnu/kawa/functions/NumberCompare.$Gr$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //    70: ifeq            78
        //    73: aload           r
        //    75: goto            258
        //    78: aload_3         /* pat */
        //    79: aload_1         /* str */
        //    80: iconst_2       
        //    81: anewarray       Ljava/lang/Object;
        //    84: dup            
        //    85: iconst_0       
        //    86: aload           i
        //    88: aastore        
        //    89: dup            
        //    90: iconst_1       
        //    91: iload           n
        //    93: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //    96: aastore        
        //    97: invokestatic    gnu/kawa/slib/pregexp.pregexpMatchPositions$V:(Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
        //   100: astore          pp
        //   102: aload           pp
        //   104: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //   107: ifne            174
        //   110: aload           i
        //   112: getstatic       gnu/kawa/slib/pregexp.Lit40:Lgnu/math/IntNum;
        //   115: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   118: ifeq            125
        //   121: aload_1         /* str */
        //   122: goto            258
        //   125: iconst_2       
        //   126: anewarray       Ljava/lang/Object;
        //   129: dup            
        //   130: iconst_0       
        //   131: aload           r
        //   133: aastore        
        //   134: dup            
        //   135: iconst_1       
        //   136: aload_1         /* str */
        //   137: ldc             Ljava/lang/CharSequence;.class
        //   139: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   142: dup            
        //   143: astore          9
        //   145: checkcast       Ljava/lang/CharSequence;
        //   148: aload           i
        //   150: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   153: dup            
        //   154: astore          9
        //   156: checkcast       Ljava/lang/Number;
        //   159: invokevirtual   java/lang/Number.intValue:()I
        //   162: iload           n
        //   164: invokestatic    kawa/lib/strings.substring:(Ljava/lang/CharSequence;II)Ljava/lang/CharSequence;
        //   167: aastore        
        //   168: invokestatic    kawa/lib/strings.stringAppend:([Ljava/lang/Object;)Lgnu/lists/FString;
        //   171: goto            258
        //   174: aload           pp
        //   176: invokestatic    kawa/lib/lists.cdar:(Ljava/lang/Object;)Ljava/lang/Object;
        //   179: iconst_3       
        //   180: anewarray       Ljava/lang/Object;
        //   183: dup            
        //   184: iconst_0       
        //   185: aload           r
        //   187: aastore        
        //   188: dup            
        //   189: iconst_1       
        //   190: aload_1         /* str */
        //   191: ldc             Ljava/lang/CharSequence;.class
        //   193: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   196: dup            
        //   197: astore          9
        //   199: checkcast       Ljava/lang/CharSequence;
        //   202: aload           i
        //   204: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   207: dup            
        //   208: astore          9
        //   210: checkcast       Ljava/lang/Number;
        //   213: invokevirtual   java/lang/Number.intValue:()I
        //   216: aload           pp
        //   218: invokestatic    kawa/lib/lists.caar:(Ljava/lang/Object;)Ljava/lang/Object;
        //   221: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   224: dup            
        //   225: astore          9
        //   227: checkcast       Ljava/lang/Number;
        //   230: invokevirtual   java/lang/Number.intValue:()I
        //   233: invokestatic    kawa/lib/strings.substring:(Ljava/lang/CharSequence;II)Ljava/lang/CharSequence;
        //   236: aastore        
        //   237: dup            
        //   238: iconst_2       
        //   239: aload_1         /* str */
        //   240: aload_2         /* ins */
        //   241: iload           ins$Mnlen
        //   243: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //   246: aload           pp
        //   248: invokestatic    gnu/kawa/slib/pregexp.pregexpReplaceAux:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   251: aastore        
        //   252: invokestatic    kawa/lib/strings.stringAppend:([Ljava/lang/Object;)Lgnu/lists/FString;
        //   255: goto            56
        //   258: areturn        
        //   259: new             Lgnu/mapping/WrongType;
        //   262: dup_x1         
        //   263: swap           
        //   264: ldc_w           "string-length"
        //   267: iconst_1       
        //   268: aload           5
        //   270: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   273: athrow         
        //   274: new             Lgnu/mapping/WrongType;
        //   277: dup_x1         
        //   278: swap           
        //   279: ldc_w           "string-length"
        //   282: iconst_1       
        //   283: aload           6
        //   285: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   288: athrow         
        //   289: new             Lgnu/mapping/WrongType;
        //   292: dup_x1         
        //   293: swap           
        //   294: ldc_w           "substring"
        //   297: iconst_1       
        //   298: aload           9
        //   300: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   303: athrow         
        //   304: new             Lgnu/mapping/WrongType;
        //   307: dup_x1         
        //   308: swap           
        //   309: ldc_w           "substring"
        //   312: iconst_2       
        //   313: aload           9
        //   315: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   318: athrow         
        //   319: new             Lgnu/mapping/WrongType;
        //   322: dup_x1         
        //   323: swap           
        //   324: ldc_w           "substring"
        //   327: iconst_1       
        //   328: aload           9
        //   330: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   333: athrow         
        //   334: new             Lgnu/mapping/WrongType;
        //   337: dup_x1         
        //   338: swap           
        //   339: ldc_w           "substring"
        //   342: iconst_2       
        //   343: aload           9
        //   345: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   348: athrow         
        //   349: new             Lgnu/mapping/WrongType;
        //   352: dup_x1         
        //   353: swap           
        //   354: ldc_w           "substring"
        //   357: iconst_3       
        //   358: aload           9
        //   360: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   363: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  25     28     259    274    Ljava/lang/ClassCastException;
        //  42     45     274    289    Ljava/lang/ClassCastException;
        //  145    148    289    304    Ljava/lang/ClassCastException;
        //  156    162    304    319    Ljava/lang/ClassCastException;
        //  199    202    319    334    Ljava/lang/ClassCastException;
        //  210    216    334    349    Ljava/lang/ClassCastException;
        //  227    233    349    364    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public static Object pregexpQuote(final Object s) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             Ljava/lang/CharSequence;.class
        //     3: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //     6: dup            
        //     7: astore_1       
        //     8: checkcast       Ljava/lang/CharSequence;
        //    11: invokestatic    kawa/lib/strings.stringLength:(Ljava/lang/CharSequence;)I
        //    14: iconst_1       
        //    15: isub           
        //    16: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //    19: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
        //    22: astore_2       
        //    23: astore_1        /* i */
        //    24: aload_1         /* i */
        //    25: getstatic       gnu/kawa/slib/pregexp.Lit40:Lgnu/math/IntNum;
        //    28: invokestatic    gnu/kawa/functions/NumberCompare.$Ls:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //    31: ifeq            51
        //    34: aload_2         /* r */
        //    35: ldc             Lgnu/lists/LList;.class
        //    37: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    40: dup            
        //    41: astore_3       
        //    42: checkcast       Lgnu/lists/LList;
        //    45: invokestatic    kawa/lib/strings.list$To$String:(Lgnu/lists/LList;)Ljava/lang/CharSequence;
        //    48: goto            132
        //    51: iconst_m1      
        //    52: aload_1         /* i */
        //    53: getstatic       gnu/kawa/slib/pregexp.Lit3:Lgnu/math/IntNum;
        //    56: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    59: aload_0         /* s */
        //    60: ldc             Ljava/lang/CharSequence;.class
        //    62: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    65: dup            
        //    66: astore          4
        //    68: checkcast       Ljava/lang/CharSequence;
        //    71: aload_1         /* i */
        //    72: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //    75: dup            
        //    76: astore          4
        //    78: checkcast       Ljava/lang/Number;
        //    81: invokevirtual   java/lang/Number.intValue:()I
        //    84: invokestatic    kawa/lib/strings.stringRef:(Ljava/lang/CharSequence;I)I
        //    87: istore_3        /* c */
        //    88: iload_3         /* c */
        //    89: invokestatic    gnu/text/Char.make:(I)Lgnu/text/Char;
        //    92: getstatic       gnu/kawa/slib/pregexp.Lit73:Lgnu/lists/PairWithPosition;
        //    95: invokestatic    kawa/lib/lists.memv:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    98: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //   101: ifeq            121
        //   104: getstatic       gnu/kawa/slib/pregexp.Lit74:Lgnu/text/Char;
        //   107: iload_3         /* c */
        //   108: invokestatic    gnu/text/Char.make:(I)Lgnu/text/Char;
        //   111: aload_2         /* r */
        //   112: invokestatic    kawa/lib/lists.cons:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //   115: invokestatic    kawa/lib/lists.cons:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //   118: goto            22
        //   121: iload_3         /* c */
        //   122: invokestatic    gnu/text/Char.make:(I)Lgnu/text/Char;
        //   125: aload_2         /* r */
        //   126: invokestatic    kawa/lib/lists.cons:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //   129: goto            22
        //   132: areturn        
        //   133: new             Lgnu/mapping/WrongType;
        //   136: dup_x1         
        //   137: swap           
        //   138: ldc_w           "string-length"
        //   141: iconst_1       
        //   142: aload_1        
        //   143: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   146: athrow         
        //   147: new             Lgnu/mapping/WrongType;
        //   150: dup_x1         
        //   151: swap           
        //   152: ldc             "list->string"
        //   154: iconst_1       
        //   155: aload_3        
        //   156: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   159: athrow         
        //   160: new             Lgnu/mapping/WrongType;
        //   163: dup_x1         
        //   164: swap           
        //   165: ldc             "string-ref"
        //   167: iconst_1       
        //   168: aload           4
        //   170: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   173: athrow         
        //   174: new             Lgnu/mapping/WrongType;
        //   177: dup_x1         
        //   178: swap           
        //   179: ldc             "string-ref"
        //   181: iconst_2       
        //   182: aload           4
        //   184: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   187: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  8      11     133    147    Ljava/lang/ClassCastException;
        //  42     45     147    160    Ljava/lang/ClassCastException;
        //  68     71     160    174    Ljava/lang/ClassCastException;
        //  78     84     174    188    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    static {
        Lit74 = Char.valueOf(92);
        Lit73 = PairWithPosition.make(gnu.kawa.slib.pregexp.Lit74, PairWithPosition.make(Char.valueOf(46), PairWithPosition.make(Char.valueOf(63), PairWithPosition.make(Char.valueOf(42), PairWithPosition.make(Char.valueOf(43), PairWithPosition.make(Char.valueOf(124), PairWithPosition.make(Lit10 = Char.valueOf(94), PairWithPosition.make(Char.valueOf(36), PairWithPosition.make(Char.valueOf(91), PairWithPosition.make(Char.valueOf(93), PairWithPosition.make(Char.valueOf(123), PairWithPosition.make(Char.valueOf(125), PairWithPosition.make(Char.valueOf(40), PairWithPosition.make(Char.valueOf(41), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm", 3170361), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm", 3170357), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm", 3170353), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm", 3170349), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm", 3170345), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm", 3170341), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm", 3166269), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm", 3166265), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm", 3166261), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm", 3166257), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm", 3166253), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm", 3166249), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm", 3166245), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm", 3166240);
        Lit72 = Symbol.valueOf("pattern-must-be-compiled-or-string-regexp");
        Lit71 = Symbol.valueOf("pregexp-match-positions");
        Lit70 = Symbol.valueOf("greedy-quantifier-operand-could-be-empty");
        Lit69 = Symbol.valueOf("non-existent-backref");
        Lit68 = Symbol.valueOf(":lookbehind");
        Lit67 = Symbol.valueOf(":neg-lookahead");
        Lit66 = Symbol.valueOf(":no-backtrack");
        Lit65 = Symbol.valueOf(":lookahead");
        Lit64 = PairWithPosition.make(Lit35 = Symbol.valueOf(":between"), PairWithPosition.make(Boolean.FALSE, PairWithPosition.make(Lit40 = IntNum.valueOf(0), PairWithPosition.make(Boolean.FALSE, PairWithPosition.make(Lit9 = Symbol.valueOf(":any"), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm", 2355265), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm", 2355262), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm", 2355260), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm", 2355257), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm", 2355247);
        Lit63 = Symbol.valueOf(":neg-lookbehind");
        Lit62 = Symbol.valueOf("pregexp-match-positions-aux");
        Lit61 = Symbol.valueOf(":sub");
        Lit60 = Symbol.valueOf("pregexp-check-if-in-char-class?");
        Lit59 = Symbol.valueOf(":punct");
        Lit58 = Symbol.valueOf(":graph");
        Lit57 = Symbol.valueOf(":print");
        Lit56 = Symbol.valueOf(":cntrl");
        Lit55 = Symbol.valueOf(":xdigit");
        Lit54 = Symbol.valueOf(":lower");
        Lit53 = Symbol.valueOf(":alnum");
        Lit52 = Symbol.valueOf(":upper");
        Lit51 = Symbol.valueOf(":alpha");
        Lit50 = Symbol.valueOf(":blank");
        Lit49 = Symbol.valueOf(":ascii");
        Lit48 = Symbol.valueOf(":char-range");
        Lit47 = Symbol.valueOf(":one-of-chars");
        Lit46 = Symbol.valueOf("character-class-ended-too-soon");
        Lit45 = Symbol.valueOf("pregexp-read-char-list");
        Lit44 = Symbol.valueOf(":none-of-chars");
        Lit43 = Symbol.valueOf("pregexp-read-nums");
        Lit42 = Symbol.valueOf("left-brace-must-be-followed-by-number");
        Lit41 = Symbol.valueOf("pregexp-wrap-quantifier-if-any");
        Lit39 = Symbol.valueOf("next-i");
        Lit38 = Symbol.valueOf("at-most");
        Lit37 = Symbol.valueOf("at-least");
        Lit36 = Symbol.valueOf("minimal?");
        Lit34 = Symbol.valueOf("pregexp-read-subpattern");
        Lit33 = PairWithPosition.make(gnu.kawa.slib.pregexp.Lit61, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm", 962582);
        Lit32 = Symbol.valueOf(":case-insensitive");
        Lit31 = Symbol.valueOf(":case-sensitive");
        Lit30 = Symbol.valueOf("pregexp-read-cluster-type");
        Lit29 = PairWithPosition.make(gnu.kawa.slib.pregexp.Lit68, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm", 892959);
        Lit28 = PairWithPosition.make(gnu.kawa.slib.pregexp.Lit63, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm", 897055);
        Lit27 = PairWithPosition.make(gnu.kawa.slib.pregexp.Lit65, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm", 872476);
        Lit26 = PairWithPosition.make(gnu.kawa.slib.pregexp.Lit66, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm", 880668);
        Lit25 = PairWithPosition.make(gnu.kawa.slib.pregexp.Lit67, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm", 876572);
        Lit24 = Symbol.valueOf("pregexp-read-posix-char-class");
        Lit23 = Char.valueOf(58);
        Lit22 = Char.valueOf(10);
        Lit21 = Symbol.valueOf(":not-wbdry");
        Lit20 = PairWithPosition.make(Lit12 = Symbol.valueOf(":neg-char"), PairWithPosition.make(Lit18 = Symbol.valueOf(":space"), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm", 704551), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm", 704540);
        Lit19 = Symbol.valueOf(":wbdry");
        Lit17 = Symbol.valueOf(":digit");
        Lit16 = PairWithPosition.make(gnu.kawa.slib.pregexp.Lit12, PairWithPosition.make(Lit14 = Symbol.valueOf(":word"), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm", 716839), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm", 716828);
        Lit15 = PairWithPosition.make(gnu.kawa.slib.pregexp.Lit12, PairWithPosition.make(gnu.kawa.slib.pregexp.Lit17, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm", 688167), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm", 688156);
        Lit13 = Symbol.valueOf(":empty");
        Lit11 = IntNum.valueOf(2);
        Lit8 = Symbol.valueOf(":bos");
        Lit7 = Symbol.valueOf("backslash");
        Lit6 = Symbol.valueOf("pregexp-read-piece");
        Lit5 = Symbol.valueOf(":backref");
        Lit4 = Symbol.valueOf(":eos");
        Lit3 = IntNum.valueOf(1);
        Lit2 = Symbol.valueOf(":seq");
        Lit1 = Symbol.valueOf(":or");
        Lit0 = IntNum.valueOf(20050502);
        gnu.kawa.slib.pregexp.$instance = new pregexp();
        final pregexp $instance = gnu.kawa.slib.pregexp.$instance;
        final ModuleMethod pregexp$Mnreverse$Ex2 = new ModuleMethod($instance, 16, "pregexp-reverse!", 4097);
        pregexp$Mnreverse$Ex2.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm:47");
        pregexp$Mnreverse$Ex = pregexp$Mnreverse$Ex2;
        final ModuleMethod pregexp$Mnread$Mnpattern2 = new ModuleMethod($instance, 17, "pregexp-read-pattern", 12291);
        pregexp$Mnread$Mnpattern2.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm:70");
        pregexp$Mnread$Mnpattern = pregexp$Mnread$Mnpattern2;
        final ModuleMethod pregexp$Mnread$Mnbranch2 = new ModuleMethod($instance, 18, "pregexp-read-branch", 12291);
        pregexp$Mnread$Mnbranch2.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm:84");
        pregexp$Mnread$Mnbranch = pregexp$Mnread$Mnbranch2;
        final ModuleMethod pregexp$Mnread$Mnpiece2 = new ModuleMethod($instance, 19, "pregexp-read-piece", 12291);
        pregexp$Mnread$Mnpiece2.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm:96");
        pregexp$Mnread$Mnpiece = pregexp$Mnread$Mnpiece2;
        final ModuleMethod pregexp$Mnread$Mnescaped$Mnnumber2 = new ModuleMethod($instance, 20, "pregexp-read-escaped-number", 12291);
        pregexp$Mnread$Mnescaped$Mnnumber2.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm:143");
        pregexp$Mnread$Mnescaped$Mnnumber = pregexp$Mnread$Mnescaped$Mnnumber2;
        final ModuleMethod pregexp$Mnread$Mnescaped$Mnchar2 = new ModuleMethod($instance, 21, "pregexp-read-escaped-char", 12291);
        pregexp$Mnread$Mnescaped$Mnchar2.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm:160");
        pregexp$Mnread$Mnescaped$Mnchar = pregexp$Mnread$Mnescaped$Mnchar2;
        final ModuleMethod pregexp$Mnread$Mnposix$Mnchar$Mnclass2 = new ModuleMethod($instance, 22, "pregexp-read-posix-char-class", 12291);
        pregexp$Mnread$Mnposix$Mnchar$Mnclass2.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm:179");
        pregexp$Mnread$Mnposix$Mnchar$Mnclass = pregexp$Mnread$Mnposix$Mnchar$Mnclass2;
        final ModuleMethod pregexp$Mnread$Mncluster$Mntype2 = new ModuleMethod($instance, 23, "pregexp-read-cluster-type", 12291);
        pregexp$Mnread$Mncluster$Mntype2.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm:205");
        pregexp$Mnread$Mncluster$Mntype = pregexp$Mnread$Mncluster$Mntype2;
        final ModuleMethod pregexp$Mnread$Mnsubpattern2 = new ModuleMethod($instance, 24, "pregexp-read-subpattern", 12291);
        pregexp$Mnread$Mnsubpattern2.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm:238");
        pregexp$Mnread$Mnsubpattern = pregexp$Mnread$Mnsubpattern2;
        final ModuleMethod pregexp$Mnwrap$Mnquantifier$Mnif$Mnany2 = new ModuleMethod($instance, 25, "pregexp-wrap-quantifier-if-any", 12291);
        pregexp$Mnwrap$Mnquantifier$Mnif$Mnany2.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm:259");
        pregexp$Mnwrap$Mnquantifier$Mnif$Mnany = pregexp$Mnwrap$Mnquantifier$Mnif$Mnany2;
        final ModuleMethod pregexp$Mnread$Mnnums2 = new ModuleMethod($instance, 26, "pregexp-read-nums", 12291);
        pregexp$Mnread$Mnnums2.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm:305");
        pregexp$Mnread$Mnnums = pregexp$Mnread$Mnnums2;
        final ModuleMethod pregexp$Mninvert$Mnchar$Mnlist2 = new ModuleMethod($instance, 27, "pregexp-invert-char-list", 4097);
        pregexp$Mninvert$Mnchar$Mnlist2.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm:328");
        pregexp$Mninvert$Mnchar$Mnlist = pregexp$Mninvert$Mnchar$Mnlist2;
        final ModuleMethod pregexp$Mnread$Mnchar$Mnlist2 = new ModuleMethod($instance, 28, "pregexp-read-char-list", 12291);
        pregexp$Mnread$Mnchar$Mnlist2.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm:335");
        pregexp$Mnread$Mnchar$Mnlist = pregexp$Mnread$Mnchar$Mnlist2;
        final ModuleMethod pregexp$Mnstring$Mnmatch2 = new ModuleMethod($instance, 29, "pregexp-string-match", 24582);
        pregexp$Mnstring$Mnmatch2.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm:373");
        pregexp$Mnstring$Mnmatch = pregexp$Mnstring$Mnmatch2;
        final ModuleMethod pregexp$Mnchar$Mnword$Qu2 = new ModuleMethod($instance, 30, "pregexp-char-word?", 4097);
        pregexp$Mnchar$Mnword$Qu2.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm:384");
        pregexp$Mnchar$Mnword$Qu = pregexp$Mnchar$Mnword$Qu2;
        final ModuleMethod pregexp$Mnat$Mnword$Mnboundary$Qu2 = new ModuleMethod($instance, 31, "pregexp-at-word-boundary?", 12291);
        pregexp$Mnat$Mnword$Mnboundary$Qu2.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm:392");
        pregexp$Mnat$Mnword$Mnboundary$Qu = pregexp$Mnat$Mnword$Mnboundary$Qu2;
        final ModuleMethod pregexp$Mncheck$Mnif$Mnin$Mnchar$Mnclass$Qu2 = new ModuleMethod($instance, 32, "pregexp-check-if-in-char-class?", 8194);
        pregexp$Mncheck$Mnif$Mnin$Mnchar$Mnclass$Qu2.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm:404");
        pregexp$Mncheck$Mnif$Mnin$Mnchar$Mnclass$Qu = pregexp$Mncheck$Mnif$Mnin$Mnchar$Mnclass$Qu2;
        final ModuleMethod pregexp$Mnlist$Mnref2 = new ModuleMethod($instance, 33, "pregexp-list-ref", 8194);
        pregexp$Mnlist$Mnref2.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm:434");
        pregexp$Mnlist$Mnref = pregexp$Mnlist$Mnref2;
        final ModuleMethod pregexp$Mnmake$Mnbackref$Mnlist2 = new ModuleMethod($instance, 34, "pregexp-make-backref-list", 4097);
        pregexp$Mnmake$Mnbackref$Mnlist2.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm:453");
        pregexp$Mnmake$Mnbackref$Mnlist = pregexp$Mnmake$Mnbackref$Mnlist2;
        final ModuleMethod lambda$Fn12 = new ModuleMethod($instance, 35, null, 0);
        lambda$Fn12.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm:468");
        lambda$Fn1 = lambda$Fn12;
        final ModuleMethod lambda$Fn13 = new ModuleMethod($instance, 36, null, 0);
        lambda$Fn13.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm:577");
        lambda$Fn4 = lambda$Fn13;
        final ModuleMethod lambda$Fn14 = new ModuleMethod($instance, 37, null, 0);
        lambda$Fn14.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm:555");
        lambda$Fn5 = lambda$Fn14;
        final ModuleMethod lambda$Fn15 = new ModuleMethod($instance, 38, null, 0);
        lambda$Fn15.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm:582");
        lambda$Fn9 = lambda$Fn15;
        final ModuleMethod lambda$Fn16 = new ModuleMethod($instance, 39, null, 0);
        lambda$Fn16.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm:560");
        lambda$Fn10 = lambda$Fn16;
        final ModuleMethod lambda$Fn17 = new ModuleMethod($instance, 40, null, 0);
        lambda$Fn17.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm:568");
        lambda$Fn11 = lambda$Fn17;
        final ModuleMethod pregexp$Mnmatch$Mnpositions$Mnaux2 = new ModuleMethod($instance, 41, "pregexp-match-positions-aux", 24582);
        pregexp$Mnmatch$Mnpositions$Mnaux2.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm:464");
        pregexp$Mnmatch$Mnpositions$Mnaux = pregexp$Mnmatch$Mnpositions$Mnaux2;
        final ModuleMethod pregexp$Mnreplace$Mnaux2 = new ModuleMethod($instance, 42, "pregexp-replace-aux", 16388);
        pregexp$Mnreplace$Mnaux2.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm:643");
        pregexp$Mnreplace$Mnaux = pregexp$Mnreplace$Mnaux2;
        final ModuleMethod pregexp2 = new ModuleMethod($instance, 43, "pregexp", 4097);
        pregexp2.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm:669");
        pregexp = pregexp2;
        final ModuleMethod pregexp$Mnmatch$Mnpositions2 = new ModuleMethod($instance, 44, "pregexp-match-positions", -4094);
        pregexp$Mnmatch$Mnpositions2.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm:674");
        pregexp$Mnmatch$Mnpositions = pregexp$Mnmatch$Mnpositions2;
        final ModuleMethod pregexp$Mnmatch2 = new ModuleMethod($instance, 45, "pregexp-match", -4094);
        pregexp$Mnmatch2.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm:694");
        pregexp$Mnmatch = pregexp$Mnmatch2;
        final ModuleMethod pregexp$Mnsplit2 = new ModuleMethod($instance, 46, "pregexp-split", 8194);
        pregexp$Mnsplit2.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm:704");
        pregexp$Mnsplit = pregexp$Mnsplit2;
        final ModuleMethod pregexp$Mnreplace2 = new ModuleMethod($instance, 47, "pregexp-replace", 12291);
        pregexp$Mnreplace2.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm:727");
        pregexp$Mnreplace = pregexp$Mnreplace2;
        final ModuleMethod pregexp$Mnreplace$St2 = new ModuleMethod($instance, 48, "pregexp-replace*", 12291);
        pregexp$Mnreplace$St2.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm:740");
        pregexp$Mnreplace$St = pregexp$Mnreplace$St2;
        final ModuleMethod pregexp$Mnquote2 = new ModuleMethod($instance, 49, "pregexp-quote", 4097);
        pregexp$Mnquote2.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm:768");
        pregexp$Mnquote = pregexp$Mnquote2;
        $runBody$();
    }
    
    public pregexp() {
        ModuleInfo.register(this);
    }
    
    @Override
    public int match0(final ModuleMethod proc, final CallContext ctx) {
        switch (proc.selector) {
            case 40: {
                ctx.proc = proc;
                return ctx.pc = 0;
            }
            case 39: {
                ctx.proc = proc;
                return ctx.pc = 0;
            }
            case 38: {
                ctx.proc = proc;
                return ctx.pc = 0;
            }
            case 37: {
                ctx.proc = proc;
                return ctx.pc = 0;
            }
            case 36: {
                ctx.proc = proc;
                return ctx.pc = 0;
            }
            case 35: {
                ctx.proc = proc;
                return ctx.pc = 0;
            }
            default: {
                return super.match0(proc, ctx);
            }
        }
    }
    
    @Override
    public int match1(final ModuleMethod proc, final Object arg1, final CallContext ctx) {
        switch (proc.selector) {
            case 49: {
                ctx.value1 = arg1;
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 43: {
                ctx.value1 = arg1;
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 34: {
                ctx.value1 = arg1;
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 30: {
                ctx.value1 = arg1;
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 27: {
                ctx.value1 = arg1;
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 16: {
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
            case 46: {
                ctx.value1 = o;
                ctx.value2 = o2;
                ctx.proc = moduleMethod;
                ctx.pc = 2;
                return 0;
            }
            case 33: {
                ctx.value1 = o;
                ctx.value2 = o2;
                ctx.proc = moduleMethod;
                ctx.pc = 2;
                return 0;
            }
            case 32: {
                ctx.value1 = o;
                ctx.value2 = o2;
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
            case 48: {
                ctx.value1 = arg1;
                ctx.value2 = arg2;
                ctx.value3 = arg3;
                ctx.proc = proc;
                ctx.pc = 3;
                return 0;
            }
            case 47: {
                ctx.value1 = arg1;
                ctx.value2 = arg2;
                ctx.value3 = arg3;
                ctx.proc = proc;
                ctx.pc = 3;
                return 0;
            }
            case 31: {
                ctx.value1 = arg1;
                ctx.value2 = arg2;
                ctx.value3 = arg3;
                ctx.proc = proc;
                ctx.pc = 3;
                return 0;
            }
            case 28: {
                ctx.value1 = arg1;
                ctx.value2 = arg2;
                ctx.value3 = arg3;
                ctx.proc = proc;
                ctx.pc = 3;
                return 0;
            }
            case 26: {
                ctx.value1 = arg1;
                ctx.value2 = arg2;
                ctx.value3 = arg3;
                ctx.proc = proc;
                ctx.pc = 3;
                return 0;
            }
            case 25: {
                ctx.value1 = arg1;
                ctx.value2 = arg2;
                ctx.value3 = arg3;
                ctx.proc = proc;
                ctx.pc = 3;
                return 0;
            }
            case 24: {
                ctx.value1 = arg1;
                ctx.value2 = arg2;
                ctx.value3 = arg3;
                ctx.proc = proc;
                ctx.pc = 3;
                return 0;
            }
            case 23: {
                ctx.value1 = arg1;
                ctx.value2 = arg2;
                ctx.value3 = arg3;
                ctx.proc = proc;
                ctx.pc = 3;
                return 0;
            }
            case 22: {
                ctx.value1 = arg1;
                ctx.value2 = arg2;
                ctx.value3 = arg3;
                ctx.proc = proc;
                ctx.pc = 3;
                return 0;
            }
            case 21: {
                ctx.value1 = arg1;
                ctx.value2 = arg2;
                ctx.value3 = arg3;
                ctx.proc = proc;
                ctx.pc = 3;
                return 0;
            }
            case 20: {
                ctx.value1 = arg1;
                ctx.value2 = arg2;
                ctx.value3 = arg3;
                ctx.proc = proc;
                ctx.pc = 3;
                return 0;
            }
            case 19: {
                ctx.value1 = arg1;
                ctx.value2 = arg2;
                ctx.value3 = arg3;
                ctx.proc = proc;
                ctx.pc = 3;
                return 0;
            }
            case 18: {
                ctx.value1 = arg1;
                ctx.value2 = arg2;
                ctx.value3 = arg3;
                ctx.proc = proc;
                ctx.pc = 3;
                return 0;
            }
            case 17: {
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
    public int match4(final ModuleMethod moduleMethod, final Object o, final Object o2, final Object o3, final Object o4, final CallContext ctx) {
        if (moduleMethod.selector == 42) {
            ctx.value1 = o;
            ctx.value2 = o2;
            ctx.value3 = o3;
            ctx.value4 = o4;
            ctx.proc = moduleMethod;
            ctx.pc = 4;
            return 0;
        }
        return super.match4(moduleMethod, o, o2, o3, o4, ctx);
    }
    
    @Override
    public int matchN(final ModuleMethod proc, final Object[] args, final CallContext ctx) {
        switch (proc.selector) {
            case 45: {
                ctx.values = args;
                ctx.proc = proc;
                ctx.pc = 5;
                return 0;
            }
            case 44: {
                ctx.values = args;
                ctx.proc = proc;
                ctx.pc = 5;
                return 0;
            }
            case 41: {
                ctx.values = args;
                ctx.proc = proc;
                ctx.pc = 5;
                return 0;
            }
            case 29: {
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
    public Object apply0(final ModuleMethod method) {
        switch (method.selector) {
            case 35: {
                return pregexp$frame.lambda4() ? Boolean.TRUE : Boolean.FALSE;
            }
            case 36: {
                return pregexp$frame0.lambda9() ? Boolean.TRUE : Boolean.FALSE;
            }
            case 37: {
                return pregexp$frame0.lambda11() ? Boolean.TRUE : Boolean.FALSE;
            }
            case 38: {
                return pregexp$frame0.lambda16() ? Boolean.TRUE : Boolean.FALSE;
            }
            case 39: {
                return pregexp$frame0.lambda17() ? Boolean.TRUE : Boolean.FALSE;
            }
            case 40: {
                return pregexp$frame0.lambda18() ? Boolean.TRUE : Boolean.FALSE;
            }
            default: {
                return super.apply0(method);
            }
        }
    }
    
    @Override
    public Object apply1(final ModuleMethod method, final Object arg1) {
        switch (method.selector) {
            case 16: {
                return pregexpReverse$Ex(arg1);
            }
            case 27: {
                return pregexpInvertCharList(arg1);
            }
            case 30: {
                return isPregexpCharWord(arg1) ? Boolean.TRUE : Boolean.FALSE;
            }
            case 34: {
                return pregexpMakeBackrefList(arg1);
            }
            case 43: {
                return pregexp(arg1);
            }
            case 49: {
                return pregexpQuote(arg1);
            }
            default: {
                return super.apply1(method, arg1);
            }
        }
    }
    
    @Override
    public Object apply2(final ModuleMethod method, final Object o, final Object o2) {
        switch (method.selector) {
            case 32: {
                return isPregexpCheckIfInCharClass(o, o2) ? Boolean.TRUE : Boolean.FALSE;
            }
            case 33: {
                return pregexpListRef(o, o2);
            }
            case 46: {
                return pregexpSplit(o, o2);
            }
            default: {
                return super.apply2(method, o, o2);
            }
        }
    }
    
    @Override
    public Object apply3(final ModuleMethod method, final Object arg1, final Object arg2, final Object arg3) {
        switch (method.selector) {
            case 17: {
                return pregexpReadPattern(arg1, arg2, arg3);
            }
            case 18: {
                return pregexpReadBranch(arg1, arg2, arg3);
            }
            case 19: {
                return pregexpReadPiece(arg1, arg2, arg3);
            }
            case 20: {
                return pregexpReadEscapedNumber(arg1, arg2, arg3);
            }
            case 21: {
                return pregexpReadEscapedChar(arg1, arg2, arg3);
            }
            case 22: {
                return pregexpReadPosixCharClass(arg1, arg2, arg3);
            }
            case 23: {
                return pregexpReadClusterType(arg1, arg2, arg3);
            }
            case 24: {
                return pregexpReadSubpattern(arg1, arg2, arg3);
            }
            case 25: {
                return pregexpWrapQuantifierIfAny(arg1, arg2, arg3);
            }
            case 26: {
                return pregexpReadNums(arg1, arg2, arg3);
            }
            case 28: {
                return pregexpReadCharList(arg1, arg2, arg3);
            }
            case 31: {
                return isPregexpAtWordBoundary(arg1, arg2, arg3) ? Boolean.TRUE : Boolean.FALSE;
            }
            case 47: {
                return pregexpReplace(arg1, arg2, arg3);
            }
            case 48: {
                return pregexpReplace$St(arg1, arg2, arg3);
            }
            default: {
                return super.apply3(method, arg1, arg2, arg3);
            }
        }
    }
    
    @Override
    public Object apply4(final ModuleMethod method, final Object o, final Object o2, final Object o3, final Object o4) {
        if (method.selector == 42) {
            return pregexpReplaceAux(o, o2, o3, o4);
        }
        return super.apply4(method, o, o2, o3, o4);
    }
    
    @Override
    public Object applyN(final ModuleMethod method, final Object[] args) {
        switch (method.selector) {
            case 29: {
                return pregexpStringMatch(args[0], args[1], args[2], args[3], args[4], args[5]);
            }
            case 41: {
                return pregexpMatchPositionsAux(args[0], args[1], args[2], args[3], args[4], args[5]);
            }
            case 44: {
                final Object pat = args[0];
                final Object str = args[1];
                int n = args.length - 2;
                final Object[] argsArray = new Object[n];
                while (--n >= 0) {
                    argsArray[n] = args[n + 2];
                }
                return pregexpMatchPositions$V(pat, str, argsArray);
            }
            case 45: {
                final Object pat2 = args[0];
                final Object str2 = args[1];
                int n2 = args.length - 2;
                final Object[] argsArray2 = new Object[n2];
                while (--n2 >= 0) {
                    argsArray2[n2] = args[n2 + 2];
                }
                return pregexpMatch$V(pat2, str2, argsArray2);
            }
            default: {
                return super.applyN(method, args);
            }
        }
    }
}
