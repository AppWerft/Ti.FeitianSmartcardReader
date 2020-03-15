// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.slib;

import gnu.expr.ModuleInfo;
import gnu.mapping.Symbol;
import gnu.lists.FString;
import gnu.expr.KawaConvert;
import gnu.lists.FVector;
import kawa.standard.Scheme;
import kawa.lib.numbers;
import gnu.lists.LList;
import kawa.lib.vectors;
import gnu.mapping.WrongType;
import gnu.kawa.functions.NumberCompare;
import gnu.kawa.functions.AddOp;
import kawa.lib.strings;
import gnu.mapping.Promise;
import kawa.lib.lists;
import gnu.mapping.Procedure;
import gnu.lists.Consumer;
import gnu.mapping.CallContext;
import gnu.math.IntNum;
import gnu.mapping.SimpleSymbol;
import gnu.expr.ModuleMethod;
import gnu.expr.ModuleBody;

public class genwrite extends ModuleBody
{
    public static final ModuleMethod generic$Mnwrite;
    public static final ModuleMethod reverse$Mnstring$Mnappend;
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
    static final IntNum Lit13;
    static final IntNum Lit14;
    static final IntNum Lit15;
    static final IntNum Lit16;
    static final IntNum Lit17;
    static final IntNum Lit18;
    static final SimpleSymbol Lit19;
    static final SimpleSymbol Lit20;
    static final SimpleSymbol Lit21;
    static final SimpleSymbol Lit22;
    static final SimpleSymbol Lit23;
    static final SimpleSymbol Lit24;
    static final SimpleSymbol Lit25;
    static final SimpleSymbol Lit26;
    static final SimpleSymbol Lit27;
    static final SimpleSymbol Lit28;
    static final SimpleSymbol Lit29;
    static final SimpleSymbol Lit30;
    static final SimpleSymbol Lit31;
    static final SimpleSymbol Lit32;
    public static genwrite $instance;
    static final SimpleSymbol Lit33;
    static final SimpleSymbol Lit34;
    
    private static void $runBody$() {
        final CallContext $ctx;
        final Consumer $result = ($ctx = CallContext.getInstance()).consumer;
    }
    
    public static Object genericWrite(final Object obj, final Object isDisplay, final Object width, final Object output) {
        public class genwrite$frame extends ModuleBody
        {
            Object width;
            Object display$Qu;
            Object output;
            
            public Object lambda1out(final Object str, final Object col) {
                Label_0055: {
                    if (!KawaConvert.isTrue(col)) {
                        break Label_0055;
                    }
                    Label_0049: {
                        if (!KawaConvert.isTrue(Scheme.applyToArgs.apply2(this.output, str))) {
                            break Label_0049;
                        }
                        final int plusOrMinus = 1;
                        final Object force = Promise.force(str, CharSequence.class);
                        try {
                            return AddOp.apply2(plusOrMinus, col, strings.stringLength((CharSequence)force));
                            o = Boolean.FALSE;
                            return o;
                            o = Boolean.FALSE;
                            return o;
                        }
                        catch (ClassCastException ex) {
                            throw new WrongType(ex, "string-length", 1, force);
                        }
                    }
                }
            }
            
            public static boolean lambda3isReadMacro(final Object l) {
                // 
                // This method could not be decompiled.
                // 
                // Original Bytecode:
                // 
                //     1: ldc             Lgnu/lists/Pair;.class
                //     3: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //     6: dup            
                //     7: astore_2       
                //     8: checkcast       Lgnu/lists/Pair;
                //    11: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
                //    14: astore_1       
                //    15: aload_0         /* l */
                //    16: ldc             Lgnu/lists/Pair;.class
                //    18: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //    21: dup            
                //    22: astore_3       
                //    23: checkcast       Lgnu/lists/Pair;
                //    26: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
                //    29: astore_2        /* tail */
                //    30: aload_1         /* head */
                //    31: invokevirtual   java/lang/Object.hashCode:()I
                //    34: lookupswitch {
                //          -279091325: 76
                //          107953788: 102
                //          881169219: 115
                //          1896636553: 89
                //          default: 159
                //        }
                //    76: aload_1         /* head */
                //    77: getstatic       gnu/kawa/slib/genwrite.Lit29:Lgnu/mapping/SimpleSymbol;
                //    80: invokestatic    gnu/kawa/functions/IsEqv.apply:(Ljava/lang/Object;Ljava/lang/Object;)Z
                //    83: ifeq            159
                //    86: goto            125
                //    89: aload_1         /* head */
                //    90: getstatic       gnu/kawa/slib/genwrite.Lit30:Lgnu/mapping/SimpleSymbol;
                //    93: invokestatic    gnu/kawa/functions/IsEqv.apply:(Ljava/lang/Object;Ljava/lang/Object;)Z
                //    96: ifeq            159
                //    99: goto            125
                //   102: aload_1         /* head */
                //   103: getstatic       gnu/kawa/slib/genwrite.Lit31:Lgnu/mapping/SimpleSymbol;
                //   106: invokestatic    gnu/kawa/functions/IsEqv.apply:(Ljava/lang/Object;Ljava/lang/Object;)Z
                //   109: ifeq            159
                //   112: goto            125
                //   115: aload_1         /* head */
                //   116: getstatic       gnu/kawa/slib/genwrite.Lit32:Lgnu/mapping/SimpleSymbol;
                //   119: invokestatic    gnu/kawa/functions/IsEqv.apply:(Ljava/lang/Object;Ljava/lang/Object;)Z
                //   122: ifeq            159
                //   125: aload_2         /* tail */
                //   126: astore_3        /* l */
                //   127: aload_3         /* l */
                //   128: invokestatic    kawa/lib/lists.isPair:(Ljava/lang/Object;)Z
                //   131: ifeq            155
                //   134: aload_3         /* l */
                //   135: ldc             Lgnu/lists/Pair;.class
                //   137: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //   140: dup            
                //   141: astore          4
                //   143: checkcast       Lgnu/lists/Pair;
                //   146: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
                //   149: invokestatic    kawa/lib/lists.isNull:(Ljava/lang/Object;)Z
                //   152: goto            163
                //   155: iconst_0       
                //   156: goto            163
                //   159: iconst_0       
                //   160: goto            163
                //   163: ireturn        
                //   164: new             Lgnu/mapping/WrongType;
                //   167: dup_x1         
                //   168: swap           
                //   169: ldc             "car"
                //   171: iconst_1       
                //   172: aload_2        
                //   173: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //   176: athrow         
                //   177: new             Lgnu/mapping/WrongType;
                //   180: dup_x1         
                //   181: swap           
                //   182: ldc             "cdr"
                //   184: iconst_1       
                //   185: aload_3        
                //   186: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //   189: athrow         
                //   190: new             Lgnu/mapping/WrongType;
                //   193: dup_x1         
                //   194: swap           
                //   195: ldc             "cdr"
                //   197: iconst_1       
                //   198: aload           4
                //   200: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //   203: athrow         
                //    Exceptions:
                //  Try           Handler
                //  Start  End    Start  End    Type                          
                //  -----  -----  -----  -----  ------------------------------
                //  8      11     164    177    Ljava/lang/ClassCastException;
                //  23     26     177    190    Ljava/lang/ClassCastException;
                //  143    146    190    204    Ljava/lang/ClassCastException;
                // 
                // The error that occurred was:
                // 
                // java.lang.NullPointerException
                //     at com.strobel.decompiler.ast.AstBuilder.convertLocalVariables(AstBuilder.java:2895)
                //     at com.strobel.decompiler.ast.AstBuilder.performStackAnalysis(AstBuilder.java:2445)
                //     at com.strobel.decompiler.ast.AstBuilder.build(AstBuilder.java:108)
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
            
            public static Object lambda5readMacroBody(final Object l) {
                return lists.cadr(l);
            }
            
            public static Object lambda6readMacroPrefix(final Object l) {
                // 
                // This method could not be decompiled.
                // 
                // Original Bytecode:
                // 
                //     1: ldc             Lgnu/lists/Pair;.class
                //     3: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //     6: dup            
                //     7: astore_2       
                //     8: checkcast       Lgnu/lists/Pair;
                //    11: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
                //    14: astore_1       
                //    15: aload_0         /* l */
                //    16: ldc             Lgnu/lists/Pair;.class
                //    18: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //    21: dup            
                //    22: astore_2       
                //    23: checkcast       Lgnu/lists/Pair;
                //    26: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
                //    29: pop            
                //    30: aload_1         /* head */
                //    31: invokevirtual   java/lang/Object.hashCode:()I
                //    34: lookupswitch {
                //          -279091325: 76
                //          107953788: 106
                //          881169219: 121
                //          1896636553: 91
                //          default: 136
                //        }
                //    76: aload_1         /* head */
                //    77: getstatic       gnu/kawa/slib/genwrite.Lit29:Lgnu/mapping/SimpleSymbol;
                //    80: invokestatic    gnu/kawa/functions/IsEqv.apply:(Ljava/lang/Object;Ljava/lang/Object;)Z
                //    83: ifeq            136
                //    86: ldc             ","
                //    88: goto            142
                //    91: aload_1         /* head */
                //    92: getstatic       gnu/kawa/slib/genwrite.Lit30:Lgnu/mapping/SimpleSymbol;
                //    95: invokestatic    gnu/kawa/functions/IsEqv.apply:(Ljava/lang/Object;Ljava/lang/Object;)Z
                //    98: ifeq            136
                //   101: ldc             "`"
                //   103: goto            142
                //   106: aload_1         /* head */
                //   107: getstatic       gnu/kawa/slib/genwrite.Lit31:Lgnu/mapping/SimpleSymbol;
                //   110: invokestatic    gnu/kawa/functions/IsEqv.apply:(Ljava/lang/Object;Ljava/lang/Object;)Z
                //   113: ifeq            136
                //   116: ldc             "'"
                //   118: goto            142
                //   121: aload_1         /* head */
                //   122: getstatic       gnu/kawa/slib/genwrite.Lit32:Lgnu/mapping/SimpleSymbol;
                //   125: invokestatic    gnu/kawa/functions/IsEqv.apply:(Ljava/lang/Object;Ljava/lang/Object;)Z
                //   128: ifeq            136
                //   131: ldc             ",@"
                //   133: goto            142
                //   136: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
                //   139: goto            142
                //   142: areturn        
                //   143: new             Lgnu/mapping/WrongType;
                //   146: dup_x1         
                //   147: swap           
                //   148: ldc             "car"
                //   150: iconst_1       
                //   151: aload_2        
                //   152: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //   155: athrow         
                //   156: new             Lgnu/mapping/WrongType;
                //   159: dup_x1         
                //   160: swap           
                //   161: ldc             "cdr"
                //   163: iconst_1       
                //   164: aload_2        
                //   165: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //   168: athrow         
                //    Exceptions:
                //  Try           Handler
                //  Start  End    Start  End    Type                          
                //  -----  -----  -----  -----  ------------------------------
                //  8      11     143    156    Ljava/lang/ClassCastException;
                //  23     26     156    169    Ljava/lang/ClassCastException;
                // 
                // The error that occurred was:
                // 
                // java.lang.NullPointerException
                //     at com.strobel.decompiler.ast.AstBuilder.convertLocalVariables(AstBuilder.java:2895)
                //     at com.strobel.decompiler.ast.AstBuilder.performStackAnalysis(AstBuilder.java:2445)
                //     at com.strobel.decompiler.ast.AstBuilder.build(AstBuilder.java:108)
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
            
            public Object lambda21wr(final Object obj, final Object col) {
                // 
                // This method could not be decompiled.
                // 
                // Original Bytecode:
                // 
                //     1: invokestatic    kawa/lib/lists.isPair:(Ljava/lang/Object;)Z
                //     4: ifeq            241
                //     7: aload_1         /* obj */
                //     8: aload_2         /* col */
                //     9: astore          4
                //    11: astore_3        /* expr */
                //    12: aload_3         /* expr */
                //    13: invokestatic    gnu/kawa/slib/genwrite$frame.lambda3isReadMacro:(Ljava/lang/Object;)Z
                //    16: ifeq            40
                //    19: aload_0         /* this */
                //    20: aload_3         /* expr */
                //    21: invokestatic    gnu/kawa/slib/genwrite$frame.lambda5readMacroBody:(Ljava/lang/Object;)Ljava/lang/Object;
                //    24: aload_0         /* this */
                //    25: aload_3         /* expr */
                //    26: invokestatic    gnu/kawa/slib/genwrite$frame.lambda6readMacroPrefix:(Ljava/lang/Object;)Ljava/lang/Object;
                //    29: aload           col
                //    31: invokevirtual   gnu/kawa/slib/genwrite$frame.lambda1out:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                //    34: invokevirtual   gnu/kawa/slib/genwrite$frame.lambda21wr:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                //    37: goto            321
                //    40: aload_3         /* expr */
                //    41: aload           col
                //    43: goto            46
                //    46: astore          6
                //    48: astore          l
                //    50: aload           l
                //    52: invokestatic    kawa/lib/lists.isPair:(Ljava/lang/Object;)Z
                //    55: ifeq            230
                //    58: aload           l
                //    60: ldc             Lgnu/lists/Pair;.class
                //    62: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //    65: dup            
                //    66: astore          7
                //    68: checkcast       Lgnu/lists/Pair;
                //    71: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
                //    74: aload           col
                //    76: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
                //    79: ifeq            113
                //    82: aload_0         /* this */
                //    83: aload           l
                //    85: ldc             Lgnu/lists/Pair;.class
                //    87: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //    90: dup            
                //    91: astore          7
                //    93: checkcast       Lgnu/lists/Pair;
                //    96: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
                //    99: aload_0         /* this */
                //   100: ldc             "("
                //   102: aload           col
                //   104: invokevirtual   gnu/kawa/slib/genwrite$frame.lambda1out:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                //   107: invokevirtual   gnu/kawa/slib/genwrite$frame.lambda21wr:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                //   110: goto            116
                //   113: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
                //   116: astore          8
                //   118: astore          l
                //   120: aload           col
                //   122: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
                //   125: ifne            133
                //   128: aload           col
                //   130: goto            321
                //   133: aload           l
                //   135: invokestatic    kawa/lib/lists.isPair:(Ljava/lang/Object;)Z
                //   138: ifeq            188
                //   141: aload           l
                //   143: ldc             Lgnu/lists/Pair;.class
                //   145: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //   148: dup            
                //   149: astore          9
                //   151: checkcast       Lgnu/lists/Pair;
                //   154: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
                //   157: aload_0         /* this */
                //   158: aload           l
                //   160: ldc             Lgnu/lists/Pair;.class
                //   162: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //   165: dup            
                //   166: astore          9
                //   168: checkcast       Lgnu/lists/Pair;
                //   171: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
                //   174: aload_0         /* this */
                //   175: ldc             " "
                //   177: aload           col
                //   179: invokevirtual   gnu/kawa/slib/genwrite$frame.lambda1out:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                //   182: invokevirtual   gnu/kawa/slib/genwrite$frame.lambda21wr:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                //   185: goto            116
                //   188: aload           l
                //   190: invokestatic    kawa/lib/lists.isNull:(Ljava/lang/Object;)Z
                //   193: ifeq            207
                //   196: aload_0         /* this */
                //   197: ldc             ")"
                //   199: aload           col
                //   201: invokevirtual   gnu/kawa/slib/genwrite$frame.lambda1out:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                //   204: goto            321
                //   207: aload_0         /* this */
                //   208: ldc             ")"
                //   210: aload_0         /* this */
                //   211: aload           l
                //   213: aload_0         /* this */
                //   214: ldc             " . "
                //   216: aload           col
                //   218: invokevirtual   gnu/kawa/slib/genwrite$frame.lambda1out:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                //   221: invokevirtual   gnu/kawa/slib/genwrite$frame.lambda21wr:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                //   224: invokevirtual   gnu/kawa/slib/genwrite$frame.lambda1out:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                //   227: goto            321
                //   230: aload_0         /* this */
                //   231: ldc             "()"
                //   233: aload           col
                //   235: invokevirtual   gnu/kawa/slib/genwrite$frame.lambda1out:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                //   238: goto            321
                //   241: aload_1         /* obj */
                //   242: invokestatic    kawa/lib/lists.isNull:(Ljava/lang/Object;)Z
                //   245: ifeq            253
                //   248: aload_1         /* obj */
                //   249: aload_2         /* col */
                //   250: goto            46
                //   253: aload_1         /* obj */
                //   254: invokestatic    kawa/lib/vectors.isVector:(Ljava/lang/Object;)Z
                //   257: ifeq            284
                //   260: aload_1         /* obj */
                //   261: ldc             Lgnu/lists/FVector;.class
                //   263: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //   266: dup            
                //   267: astore_3       
                //   268: checkcast       Lgnu/lists/FVector;
                //   271: invokestatic    kawa/lib/vectors.vector$To$List:(Lgnu/lists/FVector;)Lgnu/lists/LList;
                //   274: aload_0         /* this */
                //   275: ldc             "#"
                //   277: aload_2         /* col */
                //   278: invokevirtual   gnu/kawa/slib/genwrite$frame.lambda1out:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                //   281: goto            46
                //   284: aload_0         /* this */
                //   285: iconst_0       
                //   286: iconst_2       
                //   287: anewarray       Ljava/lang/Object;
                //   290: dup            
                //   291: iconst_0       
                //   292: aload_0         /* this */
                //   293: getfield        gnu/kawa/slib/genwrite$frame.display$Qu:Ljava/lang/Object;
                //   296: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
                //   299: ifeq            307
                //   302: ldc             "~a"
                //   304: goto            309
                //   307: ldc             "~s"
                //   309: aastore        
                //   310: dup            
                //   311: iconst_1       
                //   312: aload_1         /* obj */
                //   313: aastore        
                //   314: invokestatic    gnu/kawa/functions/Format.formatToString:(I[Ljava/lang/Object;)Ljava/lang/String;
                //   317: aload_2         /* col */
                //   318: invokevirtual   gnu/kawa/slib/genwrite$frame.lambda1out:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                //   321: areturn        
                //   322: new             Lgnu/mapping/WrongType;
                //   325: dup_x1         
                //   326: swap           
                //   327: ldc             "cdr"
                //   329: iconst_1       
                //   330: aload           7
                //   332: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //   335: athrow         
                //   336: new             Lgnu/mapping/WrongType;
                //   339: dup_x1         
                //   340: swap           
                //   341: ldc             "car"
                //   343: iconst_1       
                //   344: aload           7
                //   346: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //   349: athrow         
                //   350: new             Lgnu/mapping/WrongType;
                //   353: dup_x1         
                //   354: swap           
                //   355: ldc             "cdr"
                //   357: iconst_1       
                //   358: aload           9
                //   360: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //   363: athrow         
                //   364: new             Lgnu/mapping/WrongType;
                //   367: dup_x1         
                //   368: swap           
                //   369: ldc             "car"
                //   371: iconst_1       
                //   372: aload           9
                //   374: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //   377: athrow         
                //   378: new             Lgnu/mapping/WrongType;
                //   381: dup_x1         
                //   382: swap           
                //   383: ldc             "vector->list"
                //   385: iconst_1       
                //   386: aload_3        
                //   387: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //   390: athrow         
                //    Exceptions:
                //  Try           Handler
                //  Start  End    Start  End    Type                          
                //  -----  -----  -----  -----  ------------------------------
                //  68     71     322    336    Ljava/lang/ClassCastException;
                //  93     96     336    350    Ljava/lang/ClassCastException;
                //  151    154    350    364    Ljava/lang/ClassCastException;
                //  168    171    364    378    Ljava/lang/ClassCastException;
                //  268    271    378    391    Ljava/lang/ClassCastException;
                // 
                // The error that occurred was:
                // 
                // java.lang.NullPointerException
                //     at com.strobel.decompiler.ast.AstBuilder.convertLocalVariables(AstBuilder.java:2895)
                //     at com.strobel.decompiler.ast.AstBuilder.performStackAnalysis(AstBuilder.java:2445)
                //     at com.strobel.decompiler.ast.AstBuilder.build(AstBuilder.java:108)
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
        final genwrite$frame $heapFrame = new genwrite$frame();
        $heapFrame.display$Qu = isDisplay;
        $heapFrame.width = width;
        $heapFrame.output = output;
        Object o;
        if (KawaConvert.isTrue($heapFrame.width)) {
            final genwrite$frame genwrite$frame = $heapFrame;
            final FString string = strings.makeString(1, 10);
            final Object obj2 = obj;
            public class genwrite$frame0 extends ModuleBody
            {
                Procedure pp$MnDO;
                Procedure pp$MnBEGIN;
                Procedure pp$MnLET;
                Procedure pp$MnAND;
                Procedure pp$MnCASE;
                Procedure pp$MnCOND;
                Procedure pp$MnIF;
                Procedure pp$MnLAMBDA;
                Procedure pp$Mnexpr$Mnlist;
                Procedure pp$Mnexpr;
                genwrite$frame staticLink;
                
                public genwrite$frame0() {
                    this.pp$Mnexpr = new ModuleMethod(this, 2, genwrite.Lit19, 12291);
                    this.pp$Mnexpr$Mnlist = new ModuleMethod(this, 3, genwrite.Lit20, 12291);
                    this.pp$MnLAMBDA = new ModuleMethod(this, 4, genwrite.Lit21, 12291);
                    this.pp$MnIF = new ModuleMethod(this, 5, genwrite.Lit22, 12291);
                    this.pp$MnCOND = new ModuleMethod(this, 6, genwrite.Lit23, 12291);
                    this.pp$MnCASE = new ModuleMethod(this, 7, genwrite.Lit24, 12291);
                    this.pp$MnAND = new ModuleMethod(this, 8, genwrite.Lit25, 12291);
                    this.pp$MnLET = new ModuleMethod(this, 9, genwrite.Lit26, 12291);
                    this.pp$MnBEGIN = new ModuleMethod(this, 10, genwrite.Lit27, 12291);
                    this.pp$MnDO = new ModuleMethod(this, 11, genwrite.Lit28, 12291);
                }
                
                public Object lambda2ppExpr(final Object expr, final Object col, final Object extra) {
                    // 
                    // This method could not be decompiled.
                    // 
                    // Original Bytecode:
                    // 
                    //     1: invokestatic    gnu/kawa/slib/genwrite$frame.lambda3isReadMacro:(Ljava/lang/Object;)Z
                    //     4: ifeq            35
                    //     7: aload_0         /* this */
                    //     8: aload_1         /* expr */
                    //     9: invokestatic    gnu/kawa/slib/genwrite$frame.lambda5readMacroBody:(Ljava/lang/Object;)Ljava/lang/Object;
                    //    12: aload_0         /* this */
                    //    13: getfield        gnu/kawa/slib/genwrite$frame0.staticLink:Lgnu/kawa/slib/genwrite$frame;
                    //    16: aload_1         /* expr */
                    //    17: invokestatic    gnu/kawa/slib/genwrite$frame.lambda6readMacroPrefix:(Ljava/lang/Object;)Ljava/lang/Object;
                    //    20: aload_2         /* col */
                    //    21: invokevirtual   gnu/kawa/slib/genwrite$frame.lambda1out:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                    //    24: aload_3         /* extra */
                    //    25: aload_0         /* this */
                    //    26: getfield        gnu/kawa/slib/genwrite$frame0.pp$Mnexpr:Lgnu/mapping/Procedure;
                    //    29: invokevirtual   gnu/kawa/slib/genwrite$frame0.lambda4pr:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                    //    32: goto            499
                    //    35: aload_1         /* expr */
                    //    36: ldc             Lgnu/lists/Pair;.class
                    //    38: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                    //    41: dup            
                    //    42: astore          5
                    //    44: checkcast       Lgnu/lists/Pair;
                    //    47: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
                    //    50: astore          head
                    //    52: aload           head
                    //    54: invokestatic    kawa/lib/misc.isSymbol:(Ljava/lang/Object;)Z
                    //    57: ifeq            488
                    //    60: aload           head
                    //    62: astore          head
                    //    64: aload           head
                    //    66: invokevirtual   java/lang/Object.hashCode:()I
                    //    69: lookupswitch {
                    //          -1335633477: 184
                    //          -1110092857: 312
                    //          -1106174827: 262
                    //             3211: 362
                    //             3357: 344
                    //             3555: 230
                    //            96727: 276
                    //           107035: 198
                    //          3046192: 380
                    //          3059490: 244
                    //          3318127: 216
                    //          3526655: 330
                    //          93616297: 294
                    //          default: 398
                    //        }
                    //   184: aload           head
                    //   186: getstatic       gnu/kawa/slib/genwrite.Lit0:Lgnu/mapping/SimpleSymbol;
                    //   189: invokestatic    gnu/kawa/functions/IsEqv.apply:(Ljava/lang/Object;Ljava/lang/Object;)Z
                    //   192: ifeq            398
                    //   195: goto            323
                    //   198: aload           head
                    //   200: getstatic       gnu/kawa/slib/genwrite.Lit1:Lgnu/mapping/SimpleSymbol;
                    //   203: invokestatic    gnu/kawa/functions/IsEqv.apply:(Ljava/lang/Object;Ljava/lang/Object;)Z
                    //   206: ifeq            398
                    //   209: aload_0         /* this */
                    //   210: getfield        gnu/kawa/slib/genwrite$frame0.pp$MnLET:Lgnu/mapping/Procedure;
                    //   213: goto            404
                    //   216: aload           head
                    //   218: getstatic       gnu/kawa/slib/genwrite.Lit2:Lgnu/mapping/SimpleSymbol;
                    //   221: invokestatic    gnu/kawa/functions/IsEqv.apply:(Ljava/lang/Object;Ljava/lang/Object;)Z
                    //   224: ifeq            398
                    //   227: goto            323
                    //   230: aload           head
                    //   232: getstatic       gnu/kawa/slib/genwrite.Lit3:Lgnu/mapping/SimpleSymbol;
                    //   235: invokestatic    gnu/kawa/functions/IsEqv.apply:(Ljava/lang/Object;Ljava/lang/Object;)Z
                    //   238: ifeq            398
                    //   241: goto            287
                    //   244: aload           head
                    //   246: getstatic       gnu/kawa/slib/genwrite.Lit4:Lgnu/mapping/SimpleSymbol;
                    //   249: invokestatic    gnu/kawa/functions/IsEqv.apply:(Ljava/lang/Object;Ljava/lang/Object;)Z
                    //   252: ifeq            398
                    //   255: aload_0         /* this */
                    //   256: getfield        gnu/kawa/slib/genwrite$frame0.pp$MnCOND:Lgnu/mapping/Procedure;
                    //   259: goto            404
                    //   262: aload           head
                    //   264: getstatic       gnu/kawa/slib/genwrite.Lit5:Lgnu/mapping/SimpleSymbol;
                    //   267: invokestatic    gnu/kawa/functions/IsEqv.apply:(Ljava/lang/Object;Ljava/lang/Object;)Z
                    //   270: ifeq            398
                    //   273: goto            323
                    //   276: aload           head
                    //   278: getstatic       gnu/kawa/slib/genwrite.Lit6:Lgnu/mapping/SimpleSymbol;
                    //   281: invokestatic    gnu/kawa/functions/IsEqv.apply:(Ljava/lang/Object;Ljava/lang/Object;)Z
                    //   284: ifeq            398
                    //   287: aload_0         /* this */
                    //   288: getfield        gnu/kawa/slib/genwrite$frame0.pp$MnAND:Lgnu/mapping/Procedure;
                    //   291: goto            404
                    //   294: aload           head
                    //   296: getstatic       gnu/kawa/slib/genwrite.Lit7:Lgnu/mapping/SimpleSymbol;
                    //   299: invokestatic    gnu/kawa/functions/IsEqv.apply:(Ljava/lang/Object;Ljava/lang/Object;)Z
                    //   302: ifeq            398
                    //   305: aload_0         /* this */
                    //   306: getfield        gnu/kawa/slib/genwrite$frame0.pp$MnBEGIN:Lgnu/mapping/Procedure;
                    //   309: goto            404
                    //   312: aload           head
                    //   314: getstatic       gnu/kawa/slib/genwrite.Lit8:Lgnu/mapping/SimpleSymbol;
                    //   317: invokestatic    gnu/kawa/functions/IsEqv.apply:(Ljava/lang/Object;Ljava/lang/Object;)Z
                    //   320: ifeq            398
                    //   323: aload_0         /* this */
                    //   324: getfield        gnu/kawa/slib/genwrite$frame0.pp$MnLAMBDA:Lgnu/mapping/Procedure;
                    //   327: goto            404
                    //   330: aload           head
                    //   332: getstatic       gnu/kawa/slib/genwrite.Lit9:Lgnu/mapping/SimpleSymbol;
                    //   335: invokestatic    gnu/kawa/functions/IsEqv.apply:(Ljava/lang/Object;Ljava/lang/Object;)Z
                    //   338: ifeq            398
                    //   341: goto            355
                    //   344: aload           head
                    //   346: getstatic       gnu/kawa/slib/genwrite.Lit10:Lgnu/mapping/SimpleSymbol;
                    //   349: invokestatic    gnu/kawa/functions/IsEqv.apply:(Ljava/lang/Object;Ljava/lang/Object;)Z
                    //   352: ifeq            398
                    //   355: aload_0         /* this */
                    //   356: getfield        gnu/kawa/slib/genwrite$frame0.pp$MnIF:Lgnu/mapping/Procedure;
                    //   359: goto            404
                    //   362: aload           head
                    //   364: getstatic       gnu/kawa/slib/genwrite.Lit11:Lgnu/mapping/SimpleSymbol;
                    //   367: invokestatic    gnu/kawa/functions/IsEqv.apply:(Ljava/lang/Object;Ljava/lang/Object;)Z
                    //   370: ifeq            398
                    //   373: aload_0         /* this */
                    //   374: getfield        gnu/kawa/slib/genwrite$frame0.pp$MnDO:Lgnu/mapping/Procedure;
                    //   377: goto            404
                    //   380: aload           head
                    //   382: getstatic       gnu/kawa/slib/genwrite.Lit12:Lgnu/mapping/SimpleSymbol;
                    //   385: invokestatic    gnu/kawa/functions/IsEqv.apply:(Ljava/lang/Object;Ljava/lang/Object;)Z
                    //   388: ifeq            398
                    //   391: aload_0         /* this */
                    //   392: getfield        gnu/kawa/slib/genwrite$frame0.pp$MnCASE:Lgnu/mapping/Procedure;
                    //   395: goto            404
                    //   398: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
                    //   401: goto            404
                    //   404: astore          proc
                    //   406: aload           proc
                    //   408: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
                    //   411: ifeq            428
                    //   414: getstatic       kawa/standard/Scheme.applyToArgs:Lgnu/kawa/functions/ApplyToArgs;
                    //   417: aload           proc
                    //   419: aload_1         /* expr */
                    //   420: aload_2         /* col */
                    //   421: aload_3         /* extra */
                    //   422: invokevirtual   gnu/mapping/Procedure.apply4:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                    //   425: goto            499
                    //   428: aload           head
                    //   430: ldc             Lgnu/mapping/Symbol;.class
                    //   432: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                    //   435: dup            
                    //   436: astore          6
                    //   438: checkcast       Lgnu/mapping/Symbol;
                    //   441: invokestatic    kawa/lib/misc.symbol$To$String:(Lgnu/mapping/Symbol;)Ljava/lang/String;
                    //   444: invokestatic    kawa/lib/strings.stringLength:(Ljava/lang/CharSequence;)I
                    //   447: iconst_5       
                    //   448: if_icmple       474
                    //   451: aload_0         /* this */
                    //   452: aload_1         /* expr */
                    //   453: aload_2         /* col */
                    //   454: aload_3         /* extra */
                    //   455: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
                    //   458: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
                    //   461: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
                    //   464: aload_0         /* this */
                    //   465: getfield        gnu/kawa/slib/genwrite$frame0.pp$Mnexpr:Lgnu/mapping/Procedure;
                    //   468: invokevirtual   gnu/kawa/slib/genwrite$frame0.lambda7ppGeneral:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Lgnu/mapping/Procedure;)Ljava/lang/Object;
                    //   471: goto            499
                    //   474: aload_0         /* this */
                    //   475: aload_1         /* expr */
                    //   476: aload_2         /* col */
                    //   477: aload_3         /* extra */
                    //   478: aload_0         /* this */
                    //   479: getfield        gnu/kawa/slib/genwrite$frame0.pp$Mnexpr:Lgnu/mapping/Procedure;
                    //   482: invokevirtual   gnu/kawa/slib/genwrite$frame0.lambda8ppCall:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Lgnu/mapping/Procedure;)Ljava/lang/Object;
                    //   485: goto            499
                    //   488: aload_0         /* this */
                    //   489: aload_1         /* expr */
                    //   490: aload_2         /* col */
                    //   491: aload_3         /* extra */
                    //   492: aload_0         /* this */
                    //   493: getfield        gnu/kawa/slib/genwrite$frame0.pp$Mnexpr:Lgnu/mapping/Procedure;
                    //   496: invokevirtual   gnu/kawa/slib/genwrite$frame0.lambda9ppList:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Lgnu/mapping/Procedure;)Ljava/lang/Object;
                    //   499: areturn        
                    //   500: new             Lgnu/mapping/WrongType;
                    //   503: dup_x1         
                    //   504: swap           
                    //   505: ldc             "car"
                    //   507: iconst_1       
                    //   508: aload           5
                    //   510: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                    //   513: athrow         
                    //   514: new             Lgnu/mapping/WrongType;
                    //   517: dup_x1         
                    //   518: swap           
                    //   519: ldc             "symbol->string"
                    //   521: iconst_1       
                    //   522: aload           6
                    //   524: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                    //   527: athrow         
                    //    Exceptions:
                    //  Try           Handler
                    //  Start  End    Start  End    Type                          
                    //  -----  -----  -----  -----  ------------------------------
                    //  44     47     500    514    Ljava/lang/ClassCastException;
                    //  438    441    514    528    Ljava/lang/ClassCastException;
                    // 
                    // The error that occurred was:
                    // 
                    // java.lang.IllegalStateException: Expression is linked from several locations: Label_0474:
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
                
                public Object lambda4pr(final Object obj, final Object col, final Object extra, final Object pp$Mnpair) {
                    public class genwrite$frame1 extends ModuleBody
                    {
                        Object left;
                        Object result;
                        genwrite$frame0 staticLink;
                        final ModuleMethod lambda$Fn1;
                        
                        public genwrite$frame1() {
                            final ModuleMethod lambda$Fn1 = new ModuleMethod(this, 1, null, 4097);
                            lambda$Fn1.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/genwrite.scm:72");
                            this.lambda$Fn1 = lambda$Fn1;
                        }
                        
                        boolean lambda20(final Object str) {
                            this.result = lists.cons(str, this.result);
                            final int plusOrMinus = -1;
                            final Object left = this.left;
                            final Object force = Promise.force(str, CharSequence.class);
                            try {
                                this.left = AddOp.apply2(plusOrMinus, left, strings.stringLength((CharSequence)force));
                                return NumberCompare.$Gr(this.left, genwrite.Lit13);
                            }
                            catch (ClassCastException ex) {
                                throw new WrongType(ex, "string-length", 1, force);
                            }
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
                                return this.lambda20(o) ? Boolean.TRUE : Boolean.FALSE;
                            }
                            return super.apply1(method, o);
                        }
                    }
                    final genwrite$frame1 genwrite$frame1 = new genwrite$frame1();
                    genwrite$frame1.staticLink = this;
                    final genwrite$frame1 $heapFrame = genwrite$frame1;
                    final boolean x = lists.isPair(obj);
                    Label_0208: {
                        if (x) {
                            if (!x) {
                                break Label_0208;
                            }
                        }
                        else if (!vectors.isVector(obj)) {
                            break Label_0208;
                        }
                        $heapFrame.result = LList.Empty;
                        $heapFrame.left = numbers.min(AddOp.apply2(1, AddOp.apply2(-1, AddOp.apply2(-1, this.staticLink.width, col), extra), genwrite.Lit16), genwrite.Lit17);
                        genwrite.genericWrite(obj, this.staticLink.display$Qu, Boolean.FALSE, $heapFrame.lambda$Fn1);
                        if (NumberCompare.$Gr($heapFrame.left, genwrite.Lit13)) {
                            return this.staticLink.lambda1out(genwrite.reverseStringAppend($heapFrame.result), col);
                        }
                        if (lists.isPair(obj)) {
                            return Scheme.applyToArgs.apply4(pp$Mnpair, obj, col, extra);
                        }
                        final Object force = Promise.force(obj, FVector.class);
                        try {
                            return this.lambda9ppList(vectors.vector$To$List((FVector)force), this.staticLink.lambda1out("#", col), extra, this.pp$Mnexpr);
                            o = this.staticLink.lambda21wr(obj, col);
                            return o;
                        }
                        catch (ClassCastException ex) {
                            throw new WrongType(ex, "vector->list", 1, force);
                        }
                    }
                }
                
                public Object lambda7ppGeneral(final Object expr, final Object col, final Object extra, final Object named$Qu, final Object pp$Mn1, final Object pp$Mn2, final Procedure pp$Mn3) {
                    // 
                    // This method could not be decompiled.
                    // 
                    // Original Bytecode:
                    // 
                    //     1: ldc             Lgnu/lists/Pair;.class
                    //     3: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                    //     6: dup            
                    //     7: astore          9
                    //     9: checkcast       Lgnu/lists/Pair;
                    //    12: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
                    //    15: astore          head
                    //    17: aload_1         /* expr */
                    //    18: ldc             Lgnu/lists/Pair;.class
                    //    20: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                    //    23: dup            
                    //    24: astore          10
                    //    26: checkcast       Lgnu/lists/Pair;
                    //    29: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
                    //    32: astore          rest
                    //    34: aload_0         /* this */
                    //    35: getfield        gnu/kawa/slib/genwrite$frame0.staticLink:Lgnu/kawa/slib/genwrite$frame;
                    //    38: aload           head
                    //    40: aload_0         /* this */
                    //    41: getfield        gnu/kawa/slib/genwrite$frame0.staticLink:Lgnu/kawa/slib/genwrite$frame;
                    //    44: ldc_w           "("
                    //    47: aload_2         /* col */
                    //    48: invokevirtual   gnu/kawa/slib/genwrite$frame.lambda1out:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                    //    51: invokevirtual   gnu/kawa/slib/genwrite$frame.lambda21wr:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                    //    54: astore          col$St
                    //    56: aload           named$Qu
                    //    58: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
                    //    61: ifeq            408
                    //    64: aload           rest
                    //    66: invokestatic    kawa/lib/lists.isPair:(Ljava/lang/Object;)Z
                    //    69: ifeq            408
                    //    72: aload           rest
                    //    74: ldc             Lgnu/lists/Pair;.class
                    //    76: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                    //    79: dup            
                    //    80: astore          12
                    //    82: checkcast       Lgnu/lists/Pair;
                    //    85: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
                    //    88: astore          name
                    //    90: aload           rest
                    //    92: ldc             Lgnu/lists/Pair;.class
                    //    94: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                    //    97: dup            
                    //    98: astore          13
                    //   100: checkcast       Lgnu/lists/Pair;
                    //   103: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
                    //   106: astore          rest
                    //   108: aload_0         /* this */
                    //   109: getfield        gnu/kawa/slib/genwrite$frame0.staticLink:Lgnu/kawa/slib/genwrite$frame;
                    //   112: aload           name
                    //   114: aload_0         /* this */
                    //   115: getfield        gnu/kawa/slib/genwrite$frame0.staticLink:Lgnu/kawa/slib/genwrite$frame;
                    //   118: ldc_w           " "
                    //   121: aload           col$St
                    //   123: invokevirtual   gnu/kawa/slib/genwrite$frame.lambda1out:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                    //   126: invokevirtual   gnu/kawa/slib/genwrite$frame.lambda21wr:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                    //   129: astore          col$St$St
                    //   131: aload           rest
                    //   133: iconst_1       
                    //   134: aload_2         /* col */
                    //   135: getstatic       gnu/kawa/slib/genwrite.Lit18:Lgnu/math/IntNum;
                    //   138: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                    //   141: aload           col$St$St
                    //   143: iconst_1       
                    //   144: aload           col$St$St
                    //   146: getstatic       gnu/kawa/slib/genwrite.Lit16:Lgnu/math/IntNum;
                    //   149: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                    //   152: astore          17
                    //   154: astore          16
                    //   156: astore          15
                    //   158: astore          rest
                    //   160: aload           pp$Mn1
                    //   162: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
                    //   165: ifeq            263
                    //   168: aload           rest
                    //   170: invokestatic    kawa/lib/lists.isPair:(Ljava/lang/Object;)Z
                    //   173: ifeq            263
                    //   176: aload           rest
                    //   178: ldc             Lgnu/lists/Pair;.class
                    //   180: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                    //   183: dup            
                    //   184: astore          19
                    //   186: checkcast       Lgnu/lists/Pair;
                    //   189: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
                    //   192: astore          val1
                    //   194: aload           rest
                    //   196: ldc             Lgnu/lists/Pair;.class
                    //   198: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                    //   201: dup            
                    //   202: astore          20
                    //   204: checkcast       Lgnu/lists/Pair;
                    //   207: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
                    //   210: astore          rest
                    //   212: aload           rest
                    //   214: invokestatic    kawa/lib/lists.isNull:(Ljava/lang/Object;)Z
                    //   217: ifeq            231
                    //   220: iconst_1       
                    //   221: aload_3         /* extra */
                    //   222: getstatic       gnu/kawa/slib/genwrite.Lit16:Lgnu/math/IntNum;
                    //   225: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                    //   228: goto            234
                    //   231: getstatic       gnu/kawa/slib/genwrite.Lit13:Lgnu/math/IntNum;
                    //   234: astore          extra
                    //   236: aload           rest
                    //   238: aload           col1
                    //   240: aload_0         /* this */
                    //   241: aload           val1
                    //   243: aload_0         /* this */
                    //   244: aload           col3
                    //   246: aload           col2
                    //   248: invokevirtual   gnu/kawa/slib/genwrite$frame0.lambda19indent:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                    //   251: aload           extra
                    //   253: aload           pp$Mn1
                    //   255: invokevirtual   gnu/kawa/slib/genwrite$frame0.lambda4pr:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                    //   258: aload           col3
                    //   260: goto            271
                    //   263: aload           rest
                    //   265: aload           col1
                    //   267: aload           col2
                    //   269: aload           col3
                    //   271: astore          21
                    //   273: astore          20
                    //   275: astore          19
                    //   277: astore          rest
                    //   279: aload           pp$Mn2
                    //   281: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
                    //   284: ifeq            380
                    //   287: aload           rest
                    //   289: invokestatic    kawa/lib/lists.isPair:(Ljava/lang/Object;)Z
                    //   292: ifeq            380
                    //   295: aload           rest
                    //   297: ldc             Lgnu/lists/Pair;.class
                    //   299: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                    //   302: dup            
                    //   303: astore          23
                    //   305: checkcast       Lgnu/lists/Pair;
                    //   308: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
                    //   311: astore          val1
                    //   313: aload           rest
                    //   315: ldc             Lgnu/lists/Pair;.class
                    //   317: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                    //   320: dup            
                    //   321: astore          24
                    //   323: checkcast       Lgnu/lists/Pair;
                    //   326: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
                    //   329: astore          rest
                    //   331: aload           rest
                    //   333: invokestatic    kawa/lib/lists.isNull:(Ljava/lang/Object;)Z
                    //   336: ifeq            350
                    //   339: iconst_1       
                    //   340: aload_3         /* extra */
                    //   341: getstatic       gnu/kawa/slib/genwrite.Lit16:Lgnu/math/IntNum;
                    //   344: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                    //   347: goto            353
                    //   350: getstatic       gnu/kawa/slib/genwrite.Lit13:Lgnu/math/IntNum;
                    //   353: astore          extra
                    //   355: aload           rest
                    //   357: aload           col1
                    //   359: aload_0         /* this */
                    //   360: aload           val1
                    //   362: aload_0         /* this */
                    //   363: aload           col3
                    //   365: aload           col2
                    //   367: invokevirtual   gnu/kawa/slib/genwrite$frame0.lambda19indent:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                    //   370: aload           extra
                    //   372: aload           pp$Mn2
                    //   374: invokevirtual   gnu/kawa/slib/genwrite$frame0.lambda4pr:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                    //   377: goto            386
                    //   380: aload           rest
                    //   382: aload           col1
                    //   384: aload           col2
                    //   386: astore          24
                    //   388: astore          23
                    //   390: astore          rest
                    //   392: aload_0         /* this */
                    //   393: aload           rest
                    //   395: aload           col2
                    //   397: aload           col1
                    //   399: aload_3         /* extra */
                    //   400: aload           pp$Mn3
                    //   402: invokevirtual   gnu/kawa/slib/genwrite$frame0.lambda22ppDown:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                    //   405: goto            432
                    //   408: aload           rest
                    //   410: iconst_1       
                    //   411: aload_2         /* col */
                    //   412: getstatic       gnu/kawa/slib/genwrite.Lit18:Lgnu/math/IntNum;
                    //   415: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                    //   418: aload           col$St
                    //   420: iconst_1       
                    //   421: aload           col$St
                    //   423: getstatic       gnu/kawa/slib/genwrite.Lit16:Lgnu/math/IntNum;
                    //   426: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                    //   429: goto            152
                    //   432: areturn        
                    //   433: new             Lgnu/mapping/WrongType;
                    //   436: dup_x1         
                    //   437: swap           
                    //   438: ldc             "car"
                    //   440: iconst_1       
                    //   441: aload           9
                    //   443: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                    //   446: athrow         
                    //   447: new             Lgnu/mapping/WrongType;
                    //   450: dup_x1         
                    //   451: swap           
                    //   452: ldc             "cdr"
                    //   454: iconst_1       
                    //   455: aload           10
                    //   457: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                    //   460: athrow         
                    //   461: new             Lgnu/mapping/WrongType;
                    //   464: dup_x1         
                    //   465: swap           
                    //   466: ldc             "car"
                    //   468: iconst_1       
                    //   469: aload           12
                    //   471: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                    //   474: athrow         
                    //   475: new             Lgnu/mapping/WrongType;
                    //   478: dup_x1         
                    //   479: swap           
                    //   480: ldc             "cdr"
                    //   482: iconst_1       
                    //   483: aload           13
                    //   485: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                    //   488: athrow         
                    //   489: new             Lgnu/mapping/WrongType;
                    //   492: dup_x1         
                    //   493: swap           
                    //   494: ldc             "car"
                    //   496: iconst_1       
                    //   497: aload           19
                    //   499: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                    //   502: athrow         
                    //   503: new             Lgnu/mapping/WrongType;
                    //   506: dup_x1         
                    //   507: swap           
                    //   508: ldc             "cdr"
                    //   510: iconst_1       
                    //   511: aload           20
                    //   513: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                    //   516: athrow         
                    //   517: new             Lgnu/mapping/WrongType;
                    //   520: dup_x1         
                    //   521: swap           
                    //   522: ldc             "car"
                    //   524: iconst_1       
                    //   525: aload           23
                    //   527: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                    //   530: athrow         
                    //   531: new             Lgnu/mapping/WrongType;
                    //   534: dup_x1         
                    //   535: swap           
                    //   536: ldc             "cdr"
                    //   538: iconst_1       
                    //   539: aload           24
                    //   541: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                    //   544: athrow         
                    //    Exceptions:
                    //  Try           Handler
                    //  Start  End    Start  End    Type                          
                    //  -----  -----  -----  -----  ------------------------------
                    //  9      12     433    447    Ljava/lang/ClassCastException;
                    //  26     29     447    461    Ljava/lang/ClassCastException;
                    //  82     85     461    475    Ljava/lang/ClassCastException;
                    //  100    103    475    489    Ljava/lang/ClassCastException;
                    //  186    189    489    503    Ljava/lang/ClassCastException;
                    //  204    207    503    517    Ljava/lang/ClassCastException;
                    //  305    308    517    531    Ljava/lang/ClassCastException;
                    //  323    326    531    545    Ljava/lang/ClassCastException;
                    // 
                    // The error that occurred was:
                    // 
                    // java.lang.NullPointerException
                    //     at com.strobel.decompiler.ast.AstBuilder.convertLocalVariables(AstBuilder.java:2895)
                    //     at com.strobel.decompiler.ast.AstBuilder.performStackAnalysis(AstBuilder.java:2445)
                    //     at com.strobel.decompiler.ast.AstBuilder.build(AstBuilder.java:108)
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
                
                public Object lambda8ppCall(final Object expr, final Object col, final Object extra, final Procedure pp$Mnitem) {
                    // 
                    // This method could not be decompiled.
                    // 
                    // Original Bytecode:
                    // 
                    //     1: getfield        gnu/kawa/slib/genwrite$frame0.staticLink:Lgnu/kawa/slib/genwrite$frame;
                    //     4: aload_1         /* expr */
                    //     5: ldc             Lgnu/lists/Pair;.class
                    //     7: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                    //    10: dup            
                    //    11: astore          6
                    //    13: checkcast       Lgnu/lists/Pair;
                    //    16: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
                    //    19: aload_0         /* this */
                    //    20: getfield        gnu/kawa/slib/genwrite$frame0.staticLink:Lgnu/kawa/slib/genwrite$frame;
                    //    23: ldc_w           "("
                    //    26: aload_2         /* col */
                    //    27: invokevirtual   gnu/kawa/slib/genwrite$frame.lambda1out:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                    //    30: invokevirtual   gnu/kawa/slib/genwrite$frame.lambda21wr:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                    //    33: astore          col$St
                    //    35: aload_2         /* col */
                    //    36: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
                    //    39: ifeq            78
                    //    42: aload_0         /* this */
                    //    43: aload_1         /* expr */
                    //    44: ldc             Lgnu/lists/Pair;.class
                    //    46: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                    //    49: dup            
                    //    50: astore          6
                    //    52: checkcast       Lgnu/lists/Pair;
                    //    55: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
                    //    58: aload           col$St
                    //    60: iconst_1       
                    //    61: aload           col$St
                    //    63: getstatic       gnu/kawa/slib/genwrite.Lit16:Lgnu/math/IntNum;
                    //    66: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                    //    69: aload_3         /* extra */
                    //    70: aload           pp$Mnitem
                    //    72: invokevirtual   gnu/kawa/slib/genwrite$frame0.lambda22ppDown:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                    //    75: goto            81
                    //    78: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
                    //    81: areturn        
                    //    82: new             Lgnu/mapping/WrongType;
                    //    85: dup_x1         
                    //    86: swap           
                    //    87: ldc             "car"
                    //    89: iconst_1       
                    //    90: aload           6
                    //    92: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                    //    95: athrow         
                    //    96: new             Lgnu/mapping/WrongType;
                    //    99: dup_x1         
                    //   100: swap           
                    //   101: ldc             "cdr"
                    //   103: iconst_1       
                    //   104: aload           6
                    //   106: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                    //   109: athrow         
                    //    Exceptions:
                    //  Try           Handler
                    //  Start  End    Start  End    Type                          
                    //  -----  -----  -----  -----  ------------------------------
                    //  13     16     82     96     Ljava/lang/ClassCastException;
                    //  52     55     96     110    Ljava/lang/ClassCastException;
                    // 
                    // The error that occurred was:
                    // 
                    // java.lang.IllegalStateException: Expression is linked from several locations: Label_0078:
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
                
                public Object lambda9ppList(final Object l, final Object col, final Object extra, final Procedure pp$Mnitem) {
                    final Object col2 = this.staticLink.lambda1out("(", col);
                    return this.lambda22ppDown(l, col2, col2, extra, pp$Mnitem);
                }
                
                public Object lambda10ppExprList(final Object l, final Object col, final Object extra) {
                    return this.lambda9ppList(l, col, extra, this.pp$Mnexpr);
                }
                
                public Object lambda11ppLAMBDA(final Object expr, final Object col, final Object extra) {
                    return this.lambda7ppGeneral(expr, col, extra, Boolean.FALSE, this.pp$Mnexpr$Mnlist, Boolean.FALSE, this.pp$Mnexpr);
                }
                
                public Object lambda12ppIF(final Object expr, final Object col, final Object extra) {
                    return this.lambda7ppGeneral(expr, col, extra, Boolean.FALSE, this.pp$Mnexpr, Boolean.FALSE, this.pp$Mnexpr);
                }
                
                public Object lambda13ppCOND(final Object expr, final Object col, final Object extra) {
                    return this.lambda8ppCall(expr, col, extra, this.pp$Mnexpr$Mnlist);
                }
                
                public Object lambda14ppCASE(final Object expr, final Object col, final Object extra) {
                    return this.lambda7ppGeneral(expr, col, extra, Boolean.FALSE, this.pp$Mnexpr, Boolean.FALSE, this.pp$Mnexpr$Mnlist);
                }
                
                public Object lambda15ppAND(final Object expr, final Object col, final Object extra) {
                    return this.lambda8ppCall(expr, col, extra, this.pp$Mnexpr);
                }
                
                public Object lambda16ppLET(final Object expr, final Object col, final Object extra) {
                    // 
                    // This method could not be decompiled.
                    // 
                    // Original Bytecode:
                    // 
                    //     1: ldc             Lgnu/lists/Pair;.class
                    //     3: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                    //     6: dup            
                    //     7: astore          5
                    //     9: checkcast       Lgnu/lists/Pair;
                    //    12: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
                    //    15: astore          rest
                    //    17: aload           rest
                    //    19: invokestatic    kawa/lib/lists.isPair:(Ljava/lang/Object;)Z
                    //    22: ifeq            47
                    //    25: aload           rest
                    //    27: ldc             Lgnu/lists/Pair;.class
                    //    29: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                    //    32: dup            
                    //    33: astore          6
                    //    35: checkcast       Lgnu/lists/Pair;
                    //    38: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
                    //    41: invokestatic    kawa/lib/misc.isSymbol:(Ljava/lang/Object;)Z
                    //    44: goto            48
                    //    47: iconst_0       
                    //    48: istore          named$Qu
                    //    50: aload_0         /* this */
                    //    51: aload_1         /* expr */
                    //    52: aload_2         /* col */
                    //    53: aload_3         /* extra */
                    //    54: iload           named$Qu
                    //    56: ifeq            65
                    //    59: getstatic       java/lang/Boolean.TRUE:Ljava/lang/Boolean;
                    //    62: goto            68
                    //    65: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
                    //    68: aload_0         /* this */
                    //    69: getfield        gnu/kawa/slib/genwrite$frame0.pp$Mnexpr$Mnlist:Lgnu/mapping/Procedure;
                    //    72: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
                    //    75: aload_0         /* this */
                    //    76: getfield        gnu/kawa/slib/genwrite$frame0.pp$Mnexpr:Lgnu/mapping/Procedure;
                    //    79: invokevirtual   gnu/kawa/slib/genwrite$frame0.lambda7ppGeneral:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Lgnu/mapping/Procedure;)Ljava/lang/Object;
                    //    82: areturn        
                    //    83: new             Lgnu/mapping/WrongType;
                    //    86: dup_x1         
                    //    87: swap           
                    //    88: ldc             "cdr"
                    //    90: iconst_1       
                    //    91: aload           5
                    //    93: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                    //    96: athrow         
                    //    97: new             Lgnu/mapping/WrongType;
                    //   100: dup_x1         
                    //   101: swap           
                    //   102: ldc             "car"
                    //   104: iconst_1       
                    //   105: aload           6
                    //   107: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                    //   110: athrow         
                    //    Exceptions:
                    //  Try           Handler
                    //  Start  End    Start  End    Type                          
                    //  -----  -----  -----  -----  ------------------------------
                    //  9      12     83     97     Ljava/lang/ClassCastException;
                    //  35     38     97     111    Ljava/lang/ClassCastException;
                    // 
                    // The error that occurred was:
                    // 
                    // java.lang.IllegalStateException: Expression is linked from several locations: Label_0047:
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
                
                public Object lambda17ppBEGIN(final Object expr, final Object col, final Object extra) {
                    return this.lambda7ppGeneral(expr, col, extra, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE, this.pp$Mnexpr);
                }
                
                public Object lambda18ppDO(final Object expr, final Object col, final Object extra) {
                    return this.lambda7ppGeneral(expr, col, extra, Boolean.FALSE, this.pp$Mnexpr$Mnlist, this.pp$Mnexpr$Mnlist, this.pp$Mnexpr);
                }
                
                public Object lambda19indent(final Object to, final Object col) {
                    // 
                    // This method could not be decompiled.
                    // 
                    // Original Bytecode:
                    // 
                    //     1: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
                    //     4: ifeq            58
                    //     7: aload_1         /* to */
                    //     8: aload_2         /* col */
                    //     9: invokestatic    gnu/kawa/functions/NumberCompare.$Ls:(Ljava/lang/Object;Ljava/lang/Object;)Z
                    //    12: ifeq            48
                    //    15: aload_0         /* this */
                    //    16: getfield        gnu/kawa/slib/genwrite$frame0.staticLink:Lgnu/kawa/slib/genwrite$frame;
                    //    19: iconst_1       
                    //    20: bipush          10
                    //    22: invokestatic    kawa/lib/strings.makeString:(II)Lgnu/lists/FString;
                    //    25: aload_2         /* col */
                    //    26: invokevirtual   gnu/kawa/slib/genwrite$frame.lambda1out:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                    //    29: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
                    //    32: ifeq            42
                    //    35: aload_1         /* to */
                    //    36: getstatic       gnu/kawa/slib/genwrite.Lit13:Lgnu/math/IntNum;
                    //    39: goto            64
                    //    42: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
                    //    45: goto            142
                    //    48: iconst_m1      
                    //    49: aload_1         /* to */
                    //    50: aload_2         /* col */
                    //    51: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                    //    54: aload_2         /* col */
                    //    55: goto            64
                    //    58: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
                    //    61: goto            142
                    //    64: astore          4
                    //    66: astore_3        /* n */
                    //    67: aload_3         /* n */
                    //    68: getstatic       gnu/kawa/slib/genwrite.Lit13:Lgnu/math/IntNum;
                    //    71: invokestatic    gnu/kawa/functions/NumberCompare.$Gr:(Ljava/lang/Object;Ljava/lang/Object;)Z
                    //    74: ifeq            140
                    //    77: aload_3         /* n */
                    //    78: getstatic       gnu/kawa/slib/genwrite.Lit14:Lgnu/math/IntNum;
                    //    81: invokestatic    gnu/kawa/functions/NumberCompare.$Gr:(Ljava/lang/Object;Ljava/lang/Object;)Z
                    //    84: ifeq            109
                    //    87: iconst_m1      
                    //    88: aload_3         /* n */
                    //    89: getstatic       gnu/kawa/slib/genwrite.Lit15:Lgnu/math/IntNum;
                    //    92: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                    //    95: aload_0         /* this */
                    //    96: getfield        gnu/kawa/slib/genwrite$frame0.staticLink:Lgnu/kawa/slib/genwrite$frame;
                    //    99: ldc             "        "
                    //   101: aload           col
                    //   103: invokevirtual   gnu/kawa/slib/genwrite$frame.lambda1out:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                    //   106: goto            64
                    //   109: aload_0         /* this */
                    //   110: getfield        gnu/kawa/slib/genwrite$frame0.staticLink:Lgnu/kawa/slib/genwrite$frame;
                    //   113: ldc             "        "
                    //   115: iconst_0       
                    //   116: aload_3         /* n */
                    //   117: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
                    //   120: dup            
                    //   121: astore          5
                    //   123: checkcast       Ljava/lang/Number;
                    //   126: invokevirtual   java/lang/Number.intValue:()I
                    //   129: invokestatic    kawa/lib/strings.substring:(Ljava/lang/CharSequence;II)Ljava/lang/CharSequence;
                    //   132: aload           col
                    //   134: invokevirtual   gnu/kawa/slib/genwrite$frame.lambda1out:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                    //   137: goto            142
                    //   140: aload           col
                    //   142: areturn        
                    //   143: new             Lgnu/mapping/WrongType;
                    //   146: dup_x1         
                    //   147: swap           
                    //   148: ldc             "substring"
                    //   150: iconst_3       
                    //   151: aload           5
                    //   153: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                    //   156: athrow         
                    //    Exceptions:
                    //  Try           Handler
                    //  Start  End    Start  End    Type                          
                    //  -----  -----  -----  -----  ------------------------------
                    //  123    129    143    157    Ljava/lang/ClassCastException;
                    // 
                    // The error that occurred was:
                    // 
                    // java.lang.NullPointerException
                    //     at com.strobel.decompiler.ast.AstBuilder.convertLocalVariables(AstBuilder.java:2895)
                    //     at com.strobel.decompiler.ast.AstBuilder.performStackAnalysis(AstBuilder.java:2445)
                    //     at com.strobel.decompiler.ast.AstBuilder.build(AstBuilder.java:108)
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
                
                public Object lambda22ppDown(final Object l, final Object col1, final Object col2, final Object extra, final Object pp$Mnitem) {
                    // 
                    // This method could not be decompiled.
                    // 
                    // Original Bytecode:
                    // 
                    //     1: aload_2         /* col1 */
                    //     2: astore          7
                    //     4: astore          l
                    //     6: aload           col
                    //     8: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
                    //    11: ifeq            176
                    //    14: aload           l
                    //    16: invokestatic    kawa/lib/lists.isPair:(Ljava/lang/Object;)Z
                    //    19: ifeq            101
                    //    22: aload           l
                    //    24: ldc             Lgnu/lists/Pair;.class
                    //    26: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                    //    29: dup            
                    //    30: astore          9
                    //    32: checkcast       Lgnu/lists/Pair;
                    //    35: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
                    //    38: astore          rest
                    //    40: aload           rest
                    //    42: invokestatic    kawa/lib/lists.isNull:(Ljava/lang/Object;)Z
                    //    45: ifeq            60
                    //    48: iconst_1       
                    //    49: aload           extra
                    //    51: getstatic       gnu/kawa/slib/genwrite.Lit16:Lgnu/math/IntNum;
                    //    54: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                    //    57: goto            63
                    //    60: getstatic       gnu/kawa/slib/genwrite.Lit13:Lgnu/math/IntNum;
                    //    63: astore          extra
                    //    65: aload           rest
                    //    67: aload_0         /* this */
                    //    68: aload           l
                    //    70: ldc             Lgnu/lists/Pair;.class
                    //    72: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                    //    75: dup            
                    //    76: astore          10
                    //    78: checkcast       Lgnu/lists/Pair;
                    //    81: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
                    //    84: aload_0         /* this */
                    //    85: aload_3         /* col2 */
                    //    86: aload           col
                    //    88: invokevirtual   gnu/kawa/slib/genwrite$frame0.lambda19indent:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                    //    91: aload           extra
                    //    93: aload           pp$Mnitem
                    //    95: invokevirtual   gnu/kawa/slib/genwrite$frame0.lambda4pr:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                    //    98: goto            2
                    //   101: aload           l
                    //   103: invokestatic    kawa/lib/lists.isNull:(Ljava/lang/Object;)Z
                    //   106: ifeq            124
                    //   109: aload_0         /* this */
                    //   110: getfield        gnu/kawa/slib/genwrite$frame0.staticLink:Lgnu/kawa/slib/genwrite$frame;
                    //   113: ldc_w           ")"
                    //   116: aload           col
                    //   118: invokevirtual   gnu/kawa/slib/genwrite$frame.lambda1out:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                    //   121: goto            179
                    //   124: aload_0         /* this */
                    //   125: getfield        gnu/kawa/slib/genwrite$frame0.staticLink:Lgnu/kawa/slib/genwrite$frame;
                    //   128: ldc_w           ")"
                    //   131: aload_0         /* this */
                    //   132: aload           l
                    //   134: aload_0         /* this */
                    //   135: aload_3         /* col2 */
                    //   136: aload_0         /* this */
                    //   137: getfield        gnu/kawa/slib/genwrite$frame0.staticLink:Lgnu/kawa/slib/genwrite$frame;
                    //   140: ldc_w           "."
                    //   143: aload_0         /* this */
                    //   144: aload_3         /* col2 */
                    //   145: aload           col
                    //   147: invokevirtual   gnu/kawa/slib/genwrite$frame0.lambda19indent:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                    //   150: invokevirtual   gnu/kawa/slib/genwrite$frame.lambda1out:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                    //   153: invokevirtual   gnu/kawa/slib/genwrite$frame0.lambda19indent:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                    //   156: iconst_1       
                    //   157: aload           extra
                    //   159: getstatic       gnu/kawa/slib/genwrite.Lit16:Lgnu/math/IntNum;
                    //   162: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                    //   165: aload           pp$Mnitem
                    //   167: invokevirtual   gnu/kawa/slib/genwrite$frame0.lambda4pr:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                    //   170: invokevirtual   gnu/kawa/slib/genwrite$frame.lambda1out:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                    //   173: goto            179
                    //   176: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
                    //   179: areturn        
                    //   180: new             Lgnu/mapping/WrongType;
                    //   183: dup_x1         
                    //   184: swap           
                    //   185: ldc             "cdr"
                    //   187: iconst_1       
                    //   188: aload           9
                    //   190: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                    //   193: athrow         
                    //   194: new             Lgnu/mapping/WrongType;
                    //   197: dup_x1         
                    //   198: swap           
                    //   199: ldc             "car"
                    //   201: iconst_1       
                    //   202: aload           10
                    //   204: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                    //   207: athrow         
                    //    Exceptions:
                    //  Try           Handler
                    //  Start  End    Start  End    Type                          
                    //  -----  -----  -----  -----  ------------------------------
                    //  32     35     180    194    Ljava/lang/ClassCastException;
                    //  78     81     194    208    Ljava/lang/ClassCastException;
                    // 
                    // The error that occurred was:
                    // 
                    // java.lang.NullPointerException
                    //     at com.strobel.decompiler.ast.AstBuilder.convertLocalVariables(AstBuilder.java:2895)
                    //     at com.strobel.decompiler.ast.AstBuilder.performStackAnalysis(AstBuilder.java:2445)
                    //     at com.strobel.decompiler.ast.AstBuilder.build(AstBuilder.java:108)
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
                
                @Override
                public int match3(final ModuleMethod proc, final Object arg1, final Object arg2, final Object arg3, final CallContext ctx) {
                    switch (proc.selector) {
                        case 11: {
                            ctx.value1 = arg1;
                            ctx.value2 = arg2;
                            ctx.value3 = arg3;
                            ctx.proc = proc;
                            ctx.pc = 3;
                            return 0;
                        }
                        case 10: {
                            ctx.value1 = arg1;
                            ctx.value2 = arg2;
                            ctx.value3 = arg3;
                            ctx.proc = proc;
                            ctx.pc = 3;
                            return 0;
                        }
                        case 9: {
                            ctx.value1 = arg1;
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
                        case 7: {
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
                        case 5: {
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
                        case 3: {
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
                public void apply(final CallContext callContext) {
                    final int pc = callContext.pc;
                    ModuleMethod.applyError();
                }
                
                @Override
                public Object apply3(final ModuleMethod method, final Object arg1, final Object arg2, final Object arg3) {
                    switch (method.selector) {
                        case 2: {
                            return this.lambda2ppExpr(arg1, arg2, arg3);
                        }
                        case 3: {
                            return this.lambda10ppExprList(arg1, arg2, arg3);
                        }
                        case 4: {
                            return this.lambda11ppLAMBDA(arg1, arg2, arg3);
                        }
                        case 5: {
                            return this.lambda12ppIF(arg1, arg2, arg3);
                        }
                        case 6: {
                            return this.lambda13ppCOND(arg1, arg2, arg3);
                        }
                        case 7: {
                            return this.lambda14ppCASE(arg1, arg2, arg3);
                        }
                        case 8: {
                            return this.lambda15ppAND(arg1, arg2, arg3);
                        }
                        case 9: {
                            return this.lambda16ppLET(arg1, arg2, arg3);
                        }
                        case 10: {
                            return this.lambda17ppBEGIN(arg1, arg2, arg3);
                        }
                        case 11: {
                            return this.lambda18ppDO(arg1, arg2, arg3);
                        }
                        default: {
                            return super.apply3(method, arg1, arg2, arg3);
                        }
                    }
                }
            }
            final genwrite$frame0 genwrite$frame2 = new genwrite$frame0();
            genwrite$frame2.staticLink = $heapFrame;
            final genwrite$frame0 $heapFrame2 = genwrite$frame2;
            $heapFrame2.pp$Mnexpr = $heapFrame2.pp$Mnexpr;
            $heapFrame2.pp$Mnexpr$Mnlist = $heapFrame2.pp$Mnexpr$Mnlist;
            $heapFrame2.pp$MnLAMBDA = $heapFrame2.pp$MnLAMBDA;
            $heapFrame2.pp$MnIF = $heapFrame2.pp$MnIF;
            $heapFrame2.pp$MnCOND = $heapFrame2.pp$MnCOND;
            $heapFrame2.pp$MnCASE = $heapFrame2.pp$MnCASE;
            $heapFrame2.pp$MnAND = $heapFrame2.pp$MnAND;
            $heapFrame2.pp$MnLET = $heapFrame2.pp$MnLET;
            $heapFrame2.pp$MnBEGIN = $heapFrame2.pp$MnBEGIN;
            $heapFrame2.pp$MnDO = $heapFrame2.pp$MnDO;
            o = genwrite$frame.lambda1out(string, $heapFrame2.lambda4pr(obj2, genwrite.Lit13, genwrite.Lit13, $heapFrame2.pp$Mnexpr));
        }
        else {
            o = $heapFrame.lambda21wr(obj, genwrite.Lit13);
        }
        return o;
    }
    
    public static Object reverseStringAppend(final Object l) {
        return lambda23revStringAppend(l, genwrite.Lit13);
    }
    
    public static Object lambda23revStringAppend(final Object l, final Object i) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokestatic    kawa/lib/lists.isPair:(Ljava/lang/Object;)Z
        //     4: ifeq            192
        //     7: aload_0         /* l */
        //     8: ldc             Lgnu/lists/Pair;.class
        //    10: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    13: dup            
        //    14: astore_3       
        //    15: checkcast       Lgnu/lists/Pair;
        //    18: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    21: astore_2        /* str */
        //    22: aload_2         /* str */
        //    23: ldc             Ljava/lang/CharSequence;.class
        //    25: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    28: dup            
        //    29: astore          4
        //    31: checkcast       Ljava/lang/CharSequence;
        //    34: invokestatic    kawa/lib/strings.stringLength:(Ljava/lang/CharSequence;)I
        //    37: istore_3        /* len */
        //    38: aload_0         /* l */
        //    39: ldc             Lgnu/lists/Pair;.class
        //    41: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    44: dup            
        //    45: astore          5
        //    47: checkcast       Lgnu/lists/Pair;
        //    50: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    53: iconst_1       
        //    54: aload_1         /* i */
        //    55: iload_3         /* len */
        //    56: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //    59: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    62: invokestatic    gnu/kawa/slib/genwrite.lambda23revStringAppend:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    65: astore          result
        //    67: getstatic       gnu/kawa/slib/genwrite.Lit13:Lgnu/math/IntNum;
        //    70: iconst_m1      
        //    71: iconst_m1      
        //    72: aload           result
        //    74: ldc             Ljava/lang/CharSequence;.class
        //    76: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    79: dup            
        //    80: astore          5
        //    82: checkcast       Ljava/lang/CharSequence;
        //    85: invokestatic    kawa/lib/strings.stringLength:(Ljava/lang/CharSequence;)I
        //    88: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //    91: aload_1         /* i */
        //    92: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    95: iload_3         /* len */
        //    96: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //    99: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   102: astore          6
        //   104: astore          j
        //   106: aload           j
        //   108: iload_3         /* len */
        //   109: i2l            
        //   110: invokestatic    gnu/math/IntNum.compare:(Lgnu/math/IntNum;J)I
        //   113: ifge            187
        //   116: aload           result
        //   118: ldc             Lgnu/lists/CharSeq;.class
        //   120: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   123: dup            
        //   124: astore          7
        //   126: checkcast       Lgnu/lists/CharSeq;
        //   129: aload           k
        //   131: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   134: dup            
        //   135: astore          7
        //   137: checkcast       Ljava/lang/Number;
        //   140: invokevirtual   java/lang/Number.intValue:()I
        //   143: aload_2         /* str */
        //   144: ldc             Ljava/lang/CharSequence;.class
        //   146: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   149: dup            
        //   150: astore          7
        //   152: checkcast       Ljava/lang/CharSequence;
        //   155: aload           j
        //   157: dup            
        //   158: astore          7
        //   160: invokevirtual   java/lang/Number.intValue:()I
        //   163: invokestatic    kawa/lib/strings.stringRef:(Ljava/lang/CharSequence;I)I
        //   166: invokestatic    kawa/lib/strings.stringSet$Ex:(Lgnu/lists/CharSeq;II)V
        //   169: aload           j
        //   171: iconst_1       
        //   172: invokestatic    gnu/math/IntNum.add:(Lgnu/math/IntNum;I)Lgnu/math/IntNum;
        //   175: iconst_1       
        //   176: aload           k
        //   178: getstatic       gnu/kawa/slib/genwrite.Lit16:Lgnu/math/IntNum;
        //   181: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   184: goto            102
        //   187: aload           result
        //   189: goto            207
        //   192: aload_1         /* i */
        //   193: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   196: dup            
        //   197: astore_2       
        //   198: checkcast       Ljava/lang/Number;
        //   201: invokevirtual   java/lang/Number.intValue:()I
        //   204: invokestatic    kawa/lib/strings.makeString:(I)Lgnu/lists/FString;
        //   207: areturn        
        //   208: new             Lgnu/mapping/WrongType;
        //   211: dup_x1         
        //   212: swap           
        //   213: ldc             "car"
        //   215: iconst_1       
        //   216: aload_3        
        //   217: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   220: athrow         
        //   221: new             Lgnu/mapping/WrongType;
        //   224: dup_x1         
        //   225: swap           
        //   226: ldc             "string-length"
        //   228: iconst_1       
        //   229: aload           4
        //   231: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   234: athrow         
        //   235: new             Lgnu/mapping/WrongType;
        //   238: dup_x1         
        //   239: swap           
        //   240: ldc             "cdr"
        //   242: iconst_1       
        //   243: aload           5
        //   245: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   248: athrow         
        //   249: new             Lgnu/mapping/WrongType;
        //   252: dup_x1         
        //   253: swap           
        //   254: ldc             "string-length"
        //   256: iconst_1       
        //   257: aload           5
        //   259: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   262: athrow         
        //   263: new             Lgnu/mapping/WrongType;
        //   266: dup_x1         
        //   267: swap           
        //   268: ldc             "string-set!"
        //   270: iconst_1       
        //   271: aload           7
        //   273: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   276: athrow         
        //   277: new             Lgnu/mapping/WrongType;
        //   280: dup_x1         
        //   281: swap           
        //   282: ldc             "string-set!"
        //   284: iconst_2       
        //   285: aload           7
        //   287: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   290: athrow         
        //   291: new             Lgnu/mapping/WrongType;
        //   294: dup_x1         
        //   295: swap           
        //   296: ldc             "string-ref"
        //   298: iconst_1       
        //   299: aload           7
        //   301: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   304: athrow         
        //   305: new             Lgnu/mapping/WrongType;
        //   308: dup_x1         
        //   309: swap           
        //   310: ldc             "string-ref"
        //   312: iconst_2       
        //   313: aload           7
        //   315: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   318: athrow         
        //   319: new             Lgnu/mapping/WrongType;
        //   322: dup_x1         
        //   323: swap           
        //   324: ldc             "make-string"
        //   326: iconst_1       
        //   327: aload_2        
        //   328: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   331: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  15     18     208    221    Ljava/lang/ClassCastException;
        //  31     34     221    235    Ljava/lang/ClassCastException;
        //  47     50     235    249    Ljava/lang/ClassCastException;
        //  82     85     249    263    Ljava/lang/ClassCastException;
        //  126    129    263    277    Ljava/lang/ClassCastException;
        //  137    143    277    291    Ljava/lang/ClassCastException;
        //  152    155    291    305    Ljava/lang/ClassCastException;
        //  160    163    305    319    Ljava/lang/ClassCastException;
        //  198    204    319    332    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        //     at com.strobel.decompiler.ast.AstBuilder.convertLocalVariables(AstBuilder.java:2895)
        //     at com.strobel.decompiler.ast.AstBuilder.performStackAnalysis(AstBuilder.java:2445)
        //     at com.strobel.decompiler.ast.AstBuilder.build(AstBuilder.java:108)
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
    
    static {
        Lit34 = Symbol.valueOf("reverse-string-append");
        Lit33 = Symbol.valueOf("generic-write");
        Lit32 = Symbol.valueOf("unquote-splicing");
        Lit31 = Symbol.valueOf("quote");
        Lit30 = Symbol.valueOf("quasiquote");
        Lit29 = Symbol.valueOf("unquote");
        Lit28 = Symbol.valueOf("pp-DO");
        Lit27 = Symbol.valueOf("pp-BEGIN");
        Lit26 = Symbol.valueOf("pp-LET");
        Lit25 = Symbol.valueOf("pp-AND");
        Lit24 = Symbol.valueOf("pp-CASE");
        Lit23 = Symbol.valueOf("pp-COND");
        Lit22 = Symbol.valueOf("pp-IF");
        Lit21 = Symbol.valueOf("pp-LAMBDA");
        Lit20 = Symbol.valueOf("pp-expr-list");
        Lit19 = Symbol.valueOf("pp-expr");
        Lit18 = IntNum.valueOf(2);
        Lit17 = IntNum.valueOf(50);
        Lit16 = IntNum.valueOf(1);
        Lit15 = IntNum.valueOf(8);
        Lit14 = IntNum.valueOf(7);
        Lit13 = IntNum.valueOf(0);
        Lit12 = Symbol.valueOf("case");
        Lit11 = Symbol.valueOf("do");
        Lit10 = Symbol.valueOf("if");
        Lit9 = Symbol.valueOf("set!");
        Lit8 = Symbol.valueOf("lambda");
        Lit7 = Symbol.valueOf("begin");
        Lit6 = Symbol.valueOf("and");
        Lit5 = Symbol.valueOf("letrec");
        Lit4 = Symbol.valueOf("cond");
        Lit3 = Symbol.valueOf("or");
        Lit2 = Symbol.valueOf("let*");
        Lit1 = Symbol.valueOf("let");
        Lit0 = Symbol.valueOf("define");
        genwrite.$instance = new genwrite();
        final genwrite $instance = genwrite.$instance;
        generic$Mnwrite = new ModuleMethod($instance, 12, genwrite.Lit33, 16388);
        reverse$Mnstring$Mnappend = new ModuleMethod($instance, 13, genwrite.Lit34, 4097);
        $runBody$();
    }
    
    public genwrite() {
        ModuleInfo.register(this);
    }
    
    @Override
    public int match1(final ModuleMethod moduleMethod, final Object o, final CallContext ctx) {
        if (moduleMethod.selector == 13) {
            ctx.value1 = o;
            ctx.proc = moduleMethod;
            ctx.pc = 1;
            return 0;
        }
        return super.match1(moduleMethod, o, ctx);
    }
    
    @Override
    public int match4(final ModuleMethod moduleMethod, final Object o, final Object o2, final Object o3, final Object o4, final CallContext ctx) {
        if (moduleMethod.selector == 12) {
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
    public void apply(final CallContext callContext) {
        final int pc = callContext.pc;
        ModuleMethod.applyError();
    }
    
    @Override
    public Object apply1(final ModuleMethod method, final Object o) {
        if (method.selector == 13) {
            return reverseStringAppend(o);
        }
        return super.apply1(method, o);
    }
    
    @Override
    public Object apply4(final ModuleMethod method, final Object o, final Object o2, final Object o3, final Object o4) {
        if (method.selector == 12) {
            return genericWrite(o, o2, o3, o4);
        }
        return super.apply4(method, o, o2, o3, o4);
    }
}
