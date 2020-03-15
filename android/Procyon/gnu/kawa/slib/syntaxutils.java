// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.slib;

import gnu.expr.ModuleInfo;
import gnu.mapping.Procedure;
import kawa.lang.SyntaxPattern;
import kawa.lang.SyntaxRule;
import gnu.mapping.Symbol;
import gnu.lists.Pair;
import java.io.Externalizable;
import gnu.expr.Compilation;
import kawa.lib.lists;
import gnu.kawa.functions.NumberCompare;
import gnu.mapping.WrongType;
import gnu.expr.KawaConvert;
import gnu.kawa.functions.GetNamedPart;
import gnu.kawa.functions.Convert;
import gnu.expr.Declaration;
import gnu.expr.ReferenceExp;
import gnu.expr.ApplyExp;
import gnu.expr.LambdaExp;
import gnu.expr.ClassExp;
import gnu.expr.QuoteExp;
import gnu.expr.LetExp;
import gnu.expr.Expression;
import kawa.lang.Quote;
import gnu.lists.LList;
import kawa.lib.misc;
import gnu.expr.Special;
import gnu.lists.Consumer;
import gnu.mapping.CallContext;
import kawa.lang.SyntaxRules;
import gnu.mapping.SimpleSymbol;
import gnu.math.IntNum;
import gnu.lists.PairWithPosition;
import gnu.expr.Keyword;
import kawa.lang.Macro;
import gnu.expr.ModuleMethod;
import gnu.expr.ModuleBody;

public class syntaxutils extends ModuleBody
{
    public static final ModuleMethod expand;
    public static final Macro $Prvt$typecase$Pc;
    public static final Macro $Prvt$$Ex;
    static final Keyword Lit0;
    static final PairWithPosition Lit1;
    static final Keyword Lit2;
    static final PairWithPosition Lit3;
    static final PairWithPosition Lit4;
    static final PairWithPosition Lit5;
    static final IntNum Lit6;
    static final IntNum Lit7;
    static final PairWithPosition Lit8;
    static final PairWithPosition Lit9;
    static final PairWithPosition Lit10;
    static final PairWithPosition Lit11;
    static final PairWithPosition Lit12;
    static final PairWithPosition Lit13;
    static final SimpleSymbol Lit14;
    static final PairWithPosition Lit15;
    static final PairWithPosition Lit16;
    static final PairWithPosition Lit17;
    static final PairWithPosition Lit18;
    static final PairWithPosition Lit19;
    static final PairWithPosition Lit20;
    public static syntaxutils $instance;
    static final SimpleSymbol Lit21;
    static final SyntaxRules Lit22;
    static final SimpleSymbol Lit23;
    static final SyntaxRules Lit24;
    static final SimpleSymbol Lit25;
    static final Object[] Lit26;
    static final SimpleSymbol Lit27;
    static final SimpleSymbol Lit28;
    static final SimpleSymbol Lit29;
    static final Object[] Lit30;
    static final SimpleSymbol Lit31;
    static final SimpleSymbol Lit32;
    static final SimpleSymbol Lit33;
    static final SimpleSymbol Lit34;
    static final SimpleSymbol Lit35;
    static final SimpleSymbol Lit36;
    
    private static void $runBody$() {
        final CallContext $ctx;
        final Consumer $result = ($ctx = CallContext.getInstance()).consumer;
    }
    
    public static Object expand$V(final Object sexp, final Object[] argsArray) {
        Object o;
        if ((o = Keyword.searchForKeyword(argsArray, 0, syntaxutils.Lit0)) == Special.dfault) {
            o = misc.interactionEnvironment();
        }
        final Object env = o;
        return unrewrite(rewriteForm$V(Quote.append$V(new Object[] { syntaxutils.Lit1, Quote.consX$V(new Object[] { sexp, LList.Empty }) }), new Object[] { syntaxutils.Lit0, env }));
    }
    
    static Object unrewrite(final Expression exp) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: instanceof      Lgnu/expr/LetExp;
        //     4: ifeq            21
        //     7: aload_0         /* exp */
        //     8: dup            
        //     9: astore_2       
        //    10: checkcast       Lgnu/expr/LetExp;
        //    13: astore_1        /* exp */
        //    14: aload_1         /* exp */
        //    15: invokestatic    gnu/kawa/slib/syntaxutils.unrewriteLet:(Lgnu/expr/LetExp;)Ljava/lang/Object;
        //    18: goto            403
        //    21: aload_0         /* exp */
        //    22: instanceof      Lgnu/expr/QuoteExp;
        //    25: ifeq            42
        //    28: aload_0         /* exp */
        //    29: dup            
        //    30: astore_2       
        //    31: checkcast       Lgnu/expr/QuoteExp;
        //    34: astore_1        /* exp */
        //    35: aload_1         /* exp */
        //    36: invokestatic    gnu/kawa/slib/syntaxutils.unrewriteQuote:(Lgnu/expr/QuoteExp;)Ljava/lang/Object;
        //    39: goto            403
        //    42: aload_0         /* exp */
        //    43: instanceof      Lgnu/expr/SetExp;
        //    46: ifeq            115
        //    49: aload_0         /* exp */
        //    50: dup            
        //    51: astore_2       
        //    52: checkcast       Lgnu/expr/SetExp;
        //    55: astore_1        /* exp */
        //    56: iconst_2       
        //    57: anewarray       Ljava/lang/Object;
        //    60: dup            
        //    61: iconst_0       
        //    62: getstatic       gnu/kawa/slib/syntaxutils.Lit3:Lgnu/lists/PairWithPosition;
        //    65: aastore        
        //    66: dup            
        //    67: iconst_1       
        //    68: iconst_2       
        //    69: anewarray       Ljava/lang/Object;
        //    72: dup            
        //    73: iconst_0       
        //    74: aload_1         /* exp */
        //    75: invokevirtual   gnu/expr/SetExp.getSymbol:()Ljava/lang/Object;
        //    78: aastore        
        //    79: dup            
        //    80: iconst_1       
        //    81: iconst_2       
        //    82: anewarray       Ljava/lang/Object;
        //    85: dup            
        //    86: iconst_0       
        //    87: aload_1         /* exp */
        //    88: invokevirtual   gnu/expr/SetExp.getNewValue:()Lgnu/expr/Expression;
        //    91: invokestatic    gnu/kawa/slib/syntaxutils.unrewrite:(Lgnu/expr/Expression;)Ljava/lang/Object;
        //    94: aastore        
        //    95: dup            
        //    96: iconst_1       
        //    97: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
        //   100: aastore        
        //   101: invokestatic    kawa/lang/Quote.consX$V:([Ljava/lang/Object;)Ljava/lang/Object;
        //   104: aastore        
        //   105: invokestatic    kawa/lang/Quote.consX$V:([Ljava/lang/Object;)Ljava/lang/Object;
        //   108: aastore        
        //   109: invokestatic    kawa/lang/Quote.append$V:([Ljava/lang/Object;)Ljava/lang/Object;
        //   112: goto            403
        //   115: aload_0         /* exp */
        //   116: instanceof      Lgnu/expr/ClassExp;
        //   119: ifeq            136
        //   122: aload_0         /* exp */
        //   123: dup            
        //   124: astore_2       
        //   125: checkcast       Lgnu/expr/ClassExp;
        //   128: astore_1        /* exp */
        //   129: aload_1         /* exp */
        //   130: invokestatic    gnu/kawa/slib/syntaxutils.unrewriteClass:(Lgnu/expr/ClassExp;)Ljava/lang/Object;
        //   133: goto            403
        //   136: aload_0         /* exp */
        //   137: instanceof      Lgnu/expr/LambdaExp;
        //   140: ifeq            209
        //   143: aload_0         /* exp */
        //   144: dup            
        //   145: astore_2       
        //   146: checkcast       Lgnu/expr/LambdaExp;
        //   149: astore_1        /* exp */
        //   150: iconst_2       
        //   151: anewarray       Ljava/lang/Object;
        //   154: dup            
        //   155: iconst_0       
        //   156: getstatic       gnu/kawa/slib/syntaxutils.Lit4:Lgnu/lists/PairWithPosition;
        //   159: aastore        
        //   160: dup            
        //   161: iconst_1       
        //   162: iconst_2       
        //   163: anewarray       Ljava/lang/Object;
        //   166: dup            
        //   167: iconst_0       
        //   168: aload_1         /* exp */
        //   169: invokestatic    gnu/kawa/slib/syntaxutils.unrewriteArglist:(Lgnu/expr/LambdaExp;)Ljava/lang/Object;
        //   172: aastore        
        //   173: dup            
        //   174: iconst_1       
        //   175: iconst_2       
        //   176: anewarray       Ljava/lang/Object;
        //   179: dup            
        //   180: iconst_0       
        //   181: aload_1         /* exp */
        //   182: getfield        gnu/expr/LambdaExp.body:Lgnu/expr/Expression;
        //   185: invokestatic    gnu/kawa/slib/syntaxutils.unrewrite:(Lgnu/expr/Expression;)Ljava/lang/Object;
        //   188: aastore        
        //   189: dup            
        //   190: iconst_1       
        //   191: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
        //   194: aastore        
        //   195: invokestatic    kawa/lang/Quote.consX$V:([Ljava/lang/Object;)Ljava/lang/Object;
        //   198: aastore        
        //   199: invokestatic    kawa/lang/Quote.consX$V:([Ljava/lang/Object;)Ljava/lang/Object;
        //   202: aastore        
        //   203: invokestatic    kawa/lang/Quote.append$V:([Ljava/lang/Object;)Ljava/lang/Object;
        //   206: goto            403
        //   209: aload_0         /* exp */
        //   210: instanceof      Lgnu/expr/ReferenceExp;
        //   213: ifeq            230
        //   216: aload_0         /* exp */
        //   217: dup            
        //   218: astore_2       
        //   219: checkcast       Lgnu/expr/ReferenceExp;
        //   222: astore_1        /* exp */
        //   223: aload_1         /* exp */
        //   224: invokevirtual   gnu/expr/ReferenceExp.getSymbol:()Ljava/lang/Object;
        //   227: goto            403
        //   230: aload_0         /* exp */
        //   231: instanceof      Lgnu/expr/ApplyExp;
        //   234: ifeq            251
        //   237: aload_0         /* exp */
        //   238: dup            
        //   239: astore_2       
        //   240: checkcast       Lgnu/expr/ApplyExp;
        //   243: astore_1        /* exp */
        //   244: aload_1         /* exp */
        //   245: invokestatic    gnu/kawa/slib/syntaxutils.unrewriteApply:(Lgnu/expr/ApplyExp;)Ljava/lang/Object;
        //   248: goto            403
        //   251: aload_0         /* exp */
        //   252: instanceof      Lgnu/expr/BeginExp;
        //   255: ifeq            291
        //   258: aload_0         /* exp */
        //   259: dup            
        //   260: astore_2       
        //   261: checkcast       Lgnu/expr/BeginExp;
        //   264: astore_1        /* exp */
        //   265: iconst_2       
        //   266: anewarray       Ljava/lang/Object;
        //   269: dup            
        //   270: iconst_0       
        //   271: getstatic       gnu/kawa/slib/syntaxutils.Lit1:Lgnu/lists/PairWithPosition;
        //   274: aastore        
        //   275: dup            
        //   276: iconst_1       
        //   277: aload_1         /* exp */
        //   278: invokevirtual   gnu/expr/BeginExp.getExpressions:()[Lgnu/expr/Expression;
        //   281: invokestatic    gnu/kawa/slib/syntaxutils.unrewrite$St:([Lgnu/expr/Expression;)Lgnu/lists/LList;
        //   284: aastore        
        //   285: invokestatic    kawa/lang/Quote.append$V:([Ljava/lang/Object;)Ljava/lang/Object;
        //   288: goto            403
        //   291: aload_0         /* exp */
        //   292: instanceof      Lgnu/expr/IfExp;
        //   295: ifeq            402
        //   298: aload_0         /* exp */
        //   299: dup            
        //   300: astore_2       
        //   301: checkcast       Lgnu/expr/IfExp;
        //   304: astore_1        /* exp */
        //   305: iconst_2       
        //   306: anewarray       Ljava/lang/Object;
        //   309: dup            
        //   310: iconst_0       
        //   311: getstatic       gnu/kawa/slib/syntaxutils.Lit5:Lgnu/lists/PairWithPosition;
        //   314: aastore        
        //   315: dup            
        //   316: iconst_1       
        //   317: iconst_2       
        //   318: anewarray       Ljava/lang/Object;
        //   321: dup            
        //   322: iconst_0       
        //   323: aload_1         /* exp */
        //   324: invokevirtual   gnu/expr/IfExp.getTest:()Lgnu/expr/Expression;
        //   327: invokestatic    gnu/kawa/slib/syntaxutils.unrewrite:(Lgnu/expr/Expression;)Ljava/lang/Object;
        //   330: aastore        
        //   331: dup            
        //   332: iconst_1       
        //   333: iconst_2       
        //   334: anewarray       Ljava/lang/Object;
        //   337: dup            
        //   338: iconst_0       
        //   339: aload_1         /* exp */
        //   340: invokevirtual   gnu/expr/IfExp.getThenClause:()Lgnu/expr/Expression;
        //   343: invokestatic    gnu/kawa/slib/syntaxutils.unrewrite:(Lgnu/expr/Expression;)Ljava/lang/Object;
        //   346: aastore        
        //   347: dup            
        //   348: iconst_1       
        //   349: iconst_2       
        //   350: anewarray       Ljava/lang/Object;
        //   353: dup            
        //   354: iconst_0       
        //   355: aload_1         /* exp */
        //   356: invokevirtual   gnu/expr/IfExp.getElseClause:()Lgnu/expr/Expression;
        //   359: astore_2        /* eclause */
        //   360: aload_2         /* eclause */
        //   361: ifnonnull       370
        //   364: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
        //   367: goto            377
        //   370: aload_2         /* eclause */
        //   371: invokestatic    gnu/kawa/slib/syntaxutils.unrewrite:(Lgnu/expr/Expression;)Ljava/lang/Object;
        //   374: invokestatic    gnu/lists/LList.list1:(Ljava/lang/Object;)Lgnu/lists/Pair;
        //   377: aastore        
        //   378: dup            
        //   379: iconst_1       
        //   380: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
        //   383: aastore        
        //   384: invokestatic    kawa/lang/Quote.append$V:([Ljava/lang/Object;)Ljava/lang/Object;
        //   387: aastore        
        //   388: invokestatic    kawa/lang/Quote.consX$V:([Ljava/lang/Object;)Ljava/lang/Object;
        //   391: aastore        
        //   392: invokestatic    kawa/lang/Quote.consX$V:([Ljava/lang/Object;)Ljava/lang/Object;
        //   395: aastore        
        //   396: invokestatic    kawa/lang/Quote.append$V:([Ljava/lang/Object;)Ljava/lang/Object;
        //   399: goto            403
        //   402: aload_0         /* exp */
        //   403: areturn        
        //   404: new             Lgnu/mapping/WrongType;
        //   407: dup_x1         
        //   408: swap           
        //   409: ldc             "exp"
        //   411: bipush          -2
        //   413: aload_2        
        //   414: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   417: athrow         
        //   418: new             Lgnu/mapping/WrongType;
        //   421: dup_x1         
        //   422: swap           
        //   423: ldc             "exp"
        //   425: bipush          -2
        //   427: aload_2        
        //   428: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   431: athrow         
        //   432: new             Lgnu/mapping/WrongType;
        //   435: dup_x1         
        //   436: swap           
        //   437: ldc             "exp"
        //   439: bipush          -2
        //   441: aload_2        
        //   442: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   445: athrow         
        //   446: new             Lgnu/mapping/WrongType;
        //   449: dup_x1         
        //   450: swap           
        //   451: ldc             "exp"
        //   453: bipush          -2
        //   455: aload_2        
        //   456: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   459: athrow         
        //   460: new             Lgnu/mapping/WrongType;
        //   463: dup_x1         
        //   464: swap           
        //   465: ldc             "exp"
        //   467: bipush          -2
        //   469: aload_2        
        //   470: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   473: athrow         
        //   474: new             Lgnu/mapping/WrongType;
        //   477: dup_x1         
        //   478: swap           
        //   479: ldc             "exp"
        //   481: bipush          -2
        //   483: aload_2        
        //   484: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   487: athrow         
        //   488: new             Lgnu/mapping/WrongType;
        //   491: dup_x1         
        //   492: swap           
        //   493: ldc             "exp"
        //   495: bipush          -2
        //   497: aload_2        
        //   498: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   501: athrow         
        //   502: new             Lgnu/mapping/WrongType;
        //   505: dup_x1         
        //   506: swap           
        //   507: ldc             "exp"
        //   509: bipush          -2
        //   511: aload_2        
        //   512: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   515: athrow         
        //   516: new             Lgnu/mapping/WrongType;
        //   519: dup_x1         
        //   520: swap           
        //   521: ldc             "exp"
        //   523: bipush          -2
        //   525: aload_2        
        //   526: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   529: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  10     13     404    418    Ljava/lang/ClassCastException;
        //  31     34     418    432    Ljava/lang/ClassCastException;
        //  52     55     432    446    Ljava/lang/ClassCastException;
        //  125    128    446    460    Ljava/lang/ClassCastException;
        //  146    149    460    474    Ljava/lang/ClassCastException;
        //  219    222    474    488    Ljava/lang/ClassCastException;
        //  240    243    488    502    Ljava/lang/ClassCastException;
        //  261    264    502    516    Ljava/lang/ClassCastException;
        //  301    304    516    530    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 300 out of bounds for length 300
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
    
    static Expression rewriteForm$V(final Object exp, final Object[] argsArray) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: iconst_0       
        //     2: getstatic       gnu/kawa/slib/syntaxutils.Lit2:Lgnu/expr/Keyword;
        //     5: invokestatic    gnu/expr/Keyword.searchForKeyword:([Ljava/lang/Object;ILjava/lang/Object;)Ljava/lang/Object;
        //     8: dup            
        //     9: getstatic       gnu/expr/Special.dfault:Lgnu/expr/Special;
        //    12: if_acmpne       19
        //    15: pop            
        //    16: invokestatic    gnu/expr/Language.getDefaultLanguage:()Lgnu/expr/Language;
        //    19: ldc             Lgnu/expr/Language;.class
        //    21: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    24: dup            
        //    25: astore          4
        //    27: checkcast       Lgnu/expr/Language;
        //    30: astore_2        /* lang */
        //    31: aload_1         /* argsArray */
        //    32: iconst_0       
        //    33: getstatic       gnu/kawa/slib/syntaxutils.Lit0:Lgnu/expr/Keyword;
        //    36: invokestatic    gnu/expr/Keyword.searchForKeyword:([Ljava/lang/Object;ILjava/lang/Object;)Ljava/lang/Object;
        //    39: dup            
        //    40: getstatic       gnu/expr/Special.dfault:Lgnu/expr/Special;
        //    43: if_acmpne       50
        //    46: pop            
        //    47: invokestatic    kawa/lib/misc.interactionEnvironment:()Lgnu/mapping/Environment;
        //    50: astore_3        /* env */
        //    51: aload_3         /* env */
        //    52: ldc             Lgnu/mapping/Environment;.class
        //    54: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    57: dup            
        //    58: astore          5
        //    60: checkcast       Lgnu/mapping/Environment;
        //    63: aload_2         /* lang */
        //    64: invokestatic    gnu/expr/NameLookup.getInstance:(Lgnu/mapping/Environment;Lgnu/expr/Language;)Lgnu/expr/NameLookup;
        //    67: astore          namelookup
        //    69: new             Lgnu/text/SourceMessages;
        //    72: dup            
        //    73: invokespecial   gnu/text/SourceMessages.<init>:()V
        //    76: astore          messages
        //    78: aload_2         /* lang */
        //    79: aload           messages
        //    81: aload           namelookup
        //    83: invokevirtual   gnu/expr/Language.getCompilation:(Lgnu/text/SourceMessages;Lgnu/expr/NameLookup;)Lgnu/expr/Compilation;
        //    86: dup            
        //    87: astore          7
        //    89: checkcast       Lkawa/lang/Translator;
        //    92: astore          translator
        //    94: aload           translator
        //    96: aconst_null    
        //    97: invokevirtual   kawa/lang/Translator.pushNewModule:(Lgnu/text/Lexer;)Lgnu/expr/ModuleExp;
        //   100: pop            
        //   101: aload           translator
        //   103: invokestatic    gnu/expr/Compilation.setSaveCurrent:(Lgnu/expr/Compilation;)Lgnu/expr/Compilation;
        //   106: astore          saved$Mncomp
        //   108: aload           translator
        //   110: aload_0         /* exp */
        //   111: invokevirtual   kawa/lang/Translator.rewrite:(Ljava/lang/Object;)Lgnu/expr/Expression;
        //   114: astore          8
        //   116: jsr             130
        //   119: goto            139
        //   122: astore          9
        //   124: jsr             130
        //   127: aload           9
        //   129: athrow         
        //   130: astore          10
        //   132: aload           saved$Mncomp
        //   134: invokestatic    gnu/expr/Compilation.restoreCurrent:(Lgnu/expr/Compilation;)V
        //   137: ret             10
        //   139: aload           8
        //   141: areturn        
        //   142: new             Lgnu/mapping/WrongType;
        //   145: dup_x1         
        //   146: swap           
        //   147: ldc             "rewrite-form"
        //   149: iconst_2       
        //   150: aload           4
        //   152: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   155: athrow         
        //   156: new             Lgnu/mapping/WrongType;
        //   159: dup_x1         
        //   160: swap           
        //   161: ldc             "gnu.expr.NameLookup.getInstance(gnu.mapping.Environment,gnu.expr.Language)"
        //   163: iconst_1       
        //   164: aload           5
        //   166: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   169: athrow         
        //   170: new             Lgnu/mapping/WrongType;
        //   173: dup_x1         
        //   174: swap           
        //   175: ldc             "translator"
        //   177: bipush          -2
        //   179: aload           7
        //   181: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   184: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  108    122    122    130    Any
        //  27     30     142    156    Ljava/lang/ClassCastException;
        //  60     63     156    170    Ljava/lang/ClassCastException;
        //  89     92     170    185    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 95 out of bounds for length 95
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
    
    static Object unrewriteLet(final LetExp exp) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: anewarray       Ljava/lang/Object;
        //     4: dup            
        //     5: iconst_0       
        //     6: getstatic       gnu/kawa/slib/syntaxutils.Lit11:Lgnu/lists/PairWithPosition;
        //     9: aastore        
        //    10: dup            
        //    11: iconst_1       
        //    12: iconst_2       
        //    13: anewarray       Ljava/lang/Object;
        //    16: dup            
        //    17: iconst_0       
        //    18: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
        //    21: astore_1        /* pack */
        //    22: aload_0         /* exp */
        //    23: invokevirtual   gnu/expr/LetExp.firstDecl:()Lgnu/expr/Declaration;
        //    26: getstatic       gnu/kawa/slib/syntaxutils.Lit6:Lgnu/math/IntNum;
        //    29: astore_3       
        //    30: astore_2        /* decl */
        //    31: aload_2         /* decl */
        //    32: ifnull          70
        //    35: aload_2         /* decl */
        //    36: invokevirtual   gnu/expr/Declaration.getSymbol:()Ljava/lang/Object;
        //    39: aload_2         /* decl */
        //    40: invokevirtual   gnu/expr/Declaration.getInitValue:()Lgnu/expr/Expression;
        //    43: invokestatic    gnu/kawa/slib/syntaxutils.unrewrite:(Lgnu/expr/Expression;)Ljava/lang/Object;
        //    46: invokestatic    gnu/lists/LList.list2:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //    49: astore          v
        //    51: aload           v
        //    53: aload_1         /* pack */
        //    54: invokestatic    kawa/lib/lists.cons:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //    57: astore_1        /* pack */
        //    58: aload_2         /* decl */
        //    59: invokevirtual   gnu/expr/Declaration.nextDecl:()Lgnu/expr/Declaration;
        //    62: aload_3         /* i */
        //    63: iconst_1       
        //    64: invokestatic    gnu/math/IntNum.add:(Lgnu/math/IntNum;I)Lgnu/math/IntNum;
        //    67: goto            29
        //    70: aload_1         /* pack */
        //    71: invokestatic    kawa/lib/lists.reverse$Ex:(Lgnu/lists/LList;)Lgnu/lists/LList;
        //    74: aastore        
        //    75: dup            
        //    76: iconst_1       
        //    77: iconst_2       
        //    78: anewarray       Ljava/lang/Object;
        //    81: dup            
        //    82: iconst_0       
        //    83: aload_0         /* exp */
        //    84: invokevirtual   gnu/expr/LetExp.getBody:()Lgnu/expr/Expression;
        //    87: invokestatic    gnu/kawa/slib/syntaxutils.unrewrite:(Lgnu/expr/Expression;)Ljava/lang/Object;
        //    90: aastore        
        //    91: dup            
        //    92: iconst_1       
        //    93: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
        //    96: aastore        
        //    97: invokestatic    kawa/lang/Quote.consX$V:([Ljava/lang/Object;)Ljava/lang/Object;
        //   100: aastore        
        //   101: invokestatic    kawa/lang/Quote.consX$V:([Ljava/lang/Object;)Ljava/lang/Object;
        //   104: aastore        
        //   105: invokestatic    kawa/lang/Quote.append$V:([Ljava/lang/Object;)Ljava/lang/Object;
        //   108: areturn        
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    static Object unrewriteQuote(final QuoteExp exp) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokevirtual   gnu/expr/QuoteExp.getValue:()Ljava/lang/Object;
        //     4: astore_1        /* val */
        //     5: aload_1         /* val */
        //     6: invokestatic    gnu/math/Numeric.asNumericOrNull:(Ljava/lang/Object;)Lgnu/math/Numeric;
        //     9: ifnull          34
        //    12: goto            15
        //    15: aload_1         /* val */
        //    16: ldc_w           Lgnu/math/Numeric;.class
        //    19: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    22: dup            
        //    23: astore_3       
        //    24: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceNumeric:(Ljava/lang/Object;)Lgnu/math/Numeric;
        //    27: astore_2        /* val */
        //    28: aload_2         /* val */
        //    29: astore_3        /* val */
        //    30: aload_3         /* val */
        //    31: goto            325
        //    34: aload_1         /* val */
        //    35: instanceof      Ljava/lang/Boolean;
        //    38: ifeq            75
        //    41: aload_1         /* val */
        //    42: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //    45: dup            
        //    46: astore_3       
        //    47: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //    50: ifeq            57
        //    53: iconst_1       
        //    54: goto            58
        //    57: iconst_0       
        //    58: istore_2        /* val */
        //    59: iload_2         /* val */
        //    60: ifeq            69
        //    63: getstatic       java/lang/Boolean.TRUE:Ljava/lang/Boolean;
        //    66: goto            29
        //    69: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //    72: goto            29
        //    75: aload_1         /* val */
        //    76: instanceof      Lgnu/text/Char;
        //    79: ifeq            99
        //    82: aload_1         /* val */
        //    83: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //    86: dup            
        //    87: astore_3       
        //    88: invokestatic    gnu/text/Char.castToCharacter:(Ljava/lang/Object;)I
        //    91: istore_2        /* val */
        //    92: iload_2         /* val */
        //    93: invokestatic    gnu/text/Char.make:(I)Lgnu/text/Char;
        //    96: goto            29
        //    99: aload_1         /* val */
        //   100: instanceof      Lgnu/expr/Keyword;
        //   103: ifeq            122
        //   106: aload_1         /* val */
        //   107: ldc             Lgnu/expr/Keyword;.class
        //   109: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   112: dup            
        //   113: astore_3       
        //   114: checkcast       Lgnu/expr/Keyword;
        //   117: astore_2        /* val */
        //   118: aload_2         /* val */
        //   119: goto            29
        //   122: aload_1         /* val */
        //   123: instanceof      Ljava/lang/CharSequence;
        //   126: ifeq            146
        //   129: aload_1         /* val */
        //   130: ldc_w           Ljava/lang/CharSequence;.class
        //   133: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   136: dup            
        //   137: astore_3       
        //   138: checkcast       Ljava/lang/CharSequence;
        //   141: astore_2        /* val */
        //   142: aload_2         /* val */
        //   143: goto            29
        //   146: aload_1         /* val */
        //   147: getstatic       gnu/expr/Special.undefined:Lgnu/expr/Special;
        //   150: invokestatic    gnu/kawa/functions/IsEqv.apply:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   153: ifeq            160
        //   156: aload_1         /* val */
        //   157: goto            29
        //   160: aload_1         /* val */
        //   161: getstatic       gnu/lists/EofClass.eofValue:Lgnu/lists/EofClass;
        //   164: invokestatic    gnu/kawa/functions/IsEqv.apply:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   167: ifeq            174
        //   170: aload_1         /* val */
        //   171: goto            29
        //   174: aload_1         /* val */
        //   175: getstatic       gnu/expr/Special.abstractSpecial:Lgnu/expr/Special;
        //   178: invokestatic    gnu/kawa/functions/IsEqv.apply:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   181: ifeq            188
        //   184: aload_1         /* val */
        //   185: goto            29
        //   188: aload_1         /* val */
        //   189: getstatic       gnu/expr/Special.nativeSpecial:Lgnu/expr/Special;
        //   192: invokestatic    gnu/kawa/functions/IsEqv.apply:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   195: ifeq            202
        //   198: aload_1         /* val */
        //   199: goto            29
        //   202: aload_1         /* val */
        //   203: instanceof      Lgnu/bytecode/Type;
        //   206: ifeq            251
        //   209: aload_1         /* val */
        //   210: ldc_w           Lgnu/bytecode/Type;.class
        //   213: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   216: dup            
        //   217: astore_3       
        //   218: checkcast       Lgnu/bytecode/Type;
        //   221: astore_2        /* val */
        //   222: aload_2         /* val */
        //   223: invokevirtual   gnu/bytecode/Type.getName:()Ljava/lang/String;
        //   226: astore_3        /* name */
        //   227: iconst_0       
        //   228: iconst_2       
        //   229: anewarray       Ljava/lang/Object;
        //   232: dup            
        //   233: iconst_0       
        //   234: ldc_w           "<~a>"
        //   237: aastore        
        //   238: dup            
        //   239: iconst_1       
        //   240: aload_3         /* name */
        //   241: aastore        
        //   242: invokestatic    gnu/kawa/functions/Format.formatToString:(I[Ljava/lang/Object;)Ljava/lang/String;
        //   245: invokestatic    kawa/lib/misc.string$To$Symbol:(Ljava/lang/CharSequence;)Lgnu/mapping/SimpleSymbol;
        //   248: goto            325
        //   251: aload_1         /* val */
        //   252: instanceof      Ljava/lang/Class;
        //   255: ifeq            278
        //   258: aload_1         /* val */
        //   259: ldc_w           Ljava/lang/Class;.class
        //   262: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   265: dup            
        //   266: astore_3       
        //   267: checkcast       Ljava/lang/Class;
        //   270: astore_2        /* val */
        //   271: aload_2         /* val */
        //   272: invokevirtual   java/lang/Class.getName:()Ljava/lang/String;
        //   275: goto            226
        //   278: aload_1         /* val */
        //   279: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //   282: invokestatic    gnu/kawa/functions/IsEqv.apply:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   285: ifeq            292
        //   288: aload_0         /* exp */
        //   289: goto            325
        //   292: iconst_2       
        //   293: anewarray       Ljava/lang/Object;
        //   296: dup            
        //   297: iconst_0       
        //   298: getstatic       gnu/kawa/slib/syntaxutils.Lit12:Lgnu/lists/PairWithPosition;
        //   301: aastore        
        //   302: dup            
        //   303: iconst_1       
        //   304: iconst_2       
        //   305: anewarray       Ljava/lang/Object;
        //   308: dup            
        //   309: iconst_0       
        //   310: aload_1         /* val */
        //   311: aastore        
        //   312: dup            
        //   313: iconst_1       
        //   314: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
        //   317: aastore        
        //   318: invokestatic    kawa/lang/Quote.consX$V:([Ljava/lang/Object;)Ljava/lang/Object;
        //   321: aastore        
        //   322: invokestatic    kawa/lang/Quote.append$V:([Ljava/lang/Object;)Ljava/lang/Object;
        //   325: areturn        
        //   326: new             Lgnu/mapping/WrongType;
        //   329: dup_x1         
        //   330: swap           
        //   331: ldc_w           "val"
        //   334: bipush          -2
        //   336: aload_3        
        //   337: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   340: athrow         
        //   341: new             Lgnu/mapping/WrongType;
        //   344: dup_x1         
        //   345: swap           
        //   346: ldc_w           "val"
        //   349: bipush          -2
        //   351: aload_3        
        //   352: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   355: athrow         
        //   356: new             Lgnu/mapping/WrongType;
        //   359: dup_x1         
        //   360: swap           
        //   361: ldc_w           "val"
        //   364: bipush          -2
        //   366: aload_3        
        //   367: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   370: athrow         
        //   371: new             Lgnu/mapping/WrongType;
        //   374: dup_x1         
        //   375: swap           
        //   376: ldc_w           "val"
        //   379: bipush          -2
        //   381: aload_3        
        //   382: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   385: athrow         
        //   386: new             Lgnu/mapping/WrongType;
        //   389: dup_x1         
        //   390: swap           
        //   391: ldc_w           "val"
        //   394: bipush          -2
        //   396: aload_3        
        //   397: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   400: athrow         
        //   401: new             Lgnu/mapping/WrongType;
        //   404: dup_x1         
        //   405: swap           
        //   406: ldc_w           "val"
        //   409: bipush          -2
        //   411: aload_3        
        //   412: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   415: athrow         
        //   416: new             Lgnu/mapping/WrongType;
        //   419: dup_x1         
        //   420: swap           
        //   421: ldc_w           "val"
        //   424: bipush          -2
        //   426: aload_3        
        //   427: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   430: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  24     27     326    341    Ljava/lang/ClassCastException;
        //  47     58     341    356    Ljava/lang/ClassCastException;
        //  88     91     356    371    Ljava/lang/ClassCastException;
        //  114    117    371    386    Ljava/lang/ClassCastException;
        //  138    141    386    401    Ljava/lang/ClassCastException;
        //  218    221    401    416    Ljava/lang/ClassCastException;
        //  267    270    416    431    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 221 out of bounds for length 221
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
    
    static Object unrewriteClass(final ClassExp exp) {
        return Quote.append$V(new Object[] { syntaxutils.Lit13, Quote.consX$V(new Object[] { unrewrite$St(exp.supers), Quote.append$V(new Object[] { lambda1loop(exp.firstDecl()), Quote.append$V(new Object[] { lambda2loop(exp.firstChild), LList.Empty }) }) }) });
    }
    
    static Object unrewriteArglist(final LambdaExp exp) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        gnu/expr/LambdaExp.min_args:I
        //     4: istore_1        /* min */
        //     5: aload_0         /* exp */
        //     6: getfield        gnu/expr/LambdaExp.max_args:I
        //     9: invokestatic    gnu/math/IntNum.make:(I)Lgnu/math/IntNum;
        //    12: invokestatic    kawa/lib/numbers.isNegative:(Lgnu/math/RealNum;)Z
        //    15: istore_2        /* rest$Qu */
        //    16: aload_0         /* exp */
        //    17: getfield        gnu/expr/LambdaExp.keywords:[Lgnu/expr/Keyword;
        //    20: ifnonnull       27
        //    23: iconst_0       
        //    24: goto            28
        //    27: iconst_1       
        //    28: istore_3        /* key$Qu */
        //    29: aload_0         /* exp */
        //    30: getfield        gnu/expr/LambdaExp.opt_args:I
        //    33: istore          opt
        //    35: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
        //    38: astore          required
        //    40: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
        //    43: astore          optional
        //    45: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
        //    48: astore          key
        //    50: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //    53: astore          rest
        //    55: aload_0         /* exp */
        //    56: invokevirtual   gnu/expr/LambdaExp.firstDecl:()Lgnu/expr/Declaration;
        //    59: getstatic       gnu/kawa/slib/syntaxutils.Lit6:Lgnu/math/IntNum;
        //    62: astore          10
        //    64: astore          decl
        //    66: aload           decl
        //    68: ifnull          249
        //    71: aload           decl
        //    73: invokevirtual   gnu/expr/Declaration.getSymbol:()Ljava/lang/Object;
        //    76: astore          var
        //    78: aload           i
        //    80: iload_1         /* min */
        //    81: i2l            
        //    82: invokestatic    gnu/math/IntNum.compare:(Lgnu/math/IntNum;J)I
        //    85: ifge            100
        //    88: aload           var
        //    90: aload           required
        //    92: invokestatic    kawa/lib/lists.cons:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //    95: astore          required
        //    97: goto            235
        //   100: aload           i
        //   102: iload_1         /* min */
        //   103: i2l            
        //   104: iload           opt
        //   106: i2l            
        //   107: ladd           
        //   108: invokestatic    gnu/math/IntNum.compare:(Lgnu/math/IntNum;J)I
        //   111: ifge            126
        //   114: aload           var
        //   116: aload           optional
        //   118: invokestatic    kawa/lib/lists.cons:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //   121: astore          optional
        //   123: goto            235
        //   126: iload_2         /* rest$Qu */
        //   127: ifeq            151
        //   130: aload           i
        //   132: iload_1         /* min */
        //   133: i2l            
        //   134: iload           opt
        //   136: i2l            
        //   137: ladd           
        //   138: invokestatic    gnu/math/IntNum.compare:(Lgnu/math/IntNum;J)I
        //   141: ifne            151
        //   144: aload           var
        //   146: astore          rest
        //   148: goto            235
        //   151: iload_3         /* key$Qu */
        //   152: ifeq            203
        //   155: aload           i
        //   157: iload_2         /* rest$Qu */
        //   158: ifeq            167
        //   161: getstatic       gnu/kawa/slib/syntaxutils.Lit7:Lgnu/math/IntNum;
        //   164: goto            170
        //   167: getstatic       gnu/kawa/slib/syntaxutils.Lit6:Lgnu/math/IntNum;
        //   170: iload_1         /* min */
        //   171: iload           opt
        //   173: iadd           
        //   174: invokestatic    gnu/math/IntNum.add:(Lgnu/math/IntNum;I)Lgnu/math/IntNum;
        //   177: aload_0         /* exp */
        //   178: getfield        gnu/expr/LambdaExp.keywords:[Lgnu/expr/Keyword;
        //   181: arraylength    
        //   182: invokestatic    gnu/math/IntNum.add:(Lgnu/math/IntNum;I)Lgnu/math/IntNum;
        //   185: invokestatic    gnu/math/IntNum.compare:(Lgnu/math/IntNum;Lgnu/math/IntNum;)I
        //   188: ifge            203
        //   191: aload           var
        //   193: aload           key
        //   195: invokestatic    kawa/lib/lists.cons:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //   198: astore          key
        //   200: goto            235
        //   203: aload           decl
        //   205: invokevirtual   gnu/expr/Declaration.isThisParameter:()Z
        //   208: istore          x
        //   210: iload           x
        //   212: ifeq            218
        //   215: goto            235
        //   218: iconst_1       
        //   219: anewarray       Ljava/lang/Object;
        //   222: dup            
        //   223: iconst_0       
        //   224: ldc_w           "nyi"
        //   227: aastore        
        //   228: invokestatic    kawa/lib/exceptions.error:([Ljava/lang/Object;)Lgnu/bytecode/Type$NeverReturns;
        //   231: getstatic       gnu/expr/Special.reachedUnexpected:Ljava/lang/RuntimeException;
        //   234: athrow         
        //   235: aload           decl
        //   237: invokevirtual   gnu/expr/Declaration.nextDecl:()Lgnu/expr/Declaration;
        //   240: aload           i
        //   242: iconst_1       
        //   243: invokestatic    gnu/math/IntNum.add:(Lgnu/math/IntNum;I)Lgnu/math/IntNum;
        //   246: goto            62
        //   249: iconst_2       
        //   250: anewarray       Ljava/lang/Object;
        //   253: dup            
        //   254: iconst_0       
        //   255: aload           required
        //   257: ldc             Lgnu/lists/LList;.class
        //   259: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   262: dup            
        //   263: astore          9
        //   265: checkcast       Lgnu/lists/LList;
        //   268: invokestatic    kawa/lib/lists.reverse:(Lgnu/lists/LList;)Lgnu/lists/LList;
        //   271: aastore        
        //   272: dup            
        //   273: iconst_1       
        //   274: iconst_2       
        //   275: anewarray       Ljava/lang/Object;
        //   278: dup            
        //   279: iconst_0       
        //   280: iload           opt
        //   282: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //   285: invokestatic    kawa/lib/numbers.isZero:(Ljava/lang/Number;)Z
        //   288: ifeq            297
        //   291: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
        //   294: goto            329
        //   297: iconst_2       
        //   298: anewarray       Ljava/lang/Object;
        //   301: dup            
        //   302: iconst_0       
        //   303: getstatic       gnu/kawa/slib/syntaxutils.Lit8:Lgnu/lists/PairWithPosition;
        //   306: aastore        
        //   307: dup            
        //   308: iconst_1       
        //   309: aload           optional
        //   311: ldc             Lgnu/lists/LList;.class
        //   313: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   316: dup            
        //   317: astore          9
        //   319: checkcast       Lgnu/lists/LList;
        //   322: invokestatic    kawa/lib/lists.reverse:(Lgnu/lists/LList;)Lgnu/lists/LList;
        //   325: aastore        
        //   326: invokestatic    kawa/lang/Quote.append$V:([Ljava/lang/Object;)Ljava/lang/Object;
        //   329: aastore        
        //   330: dup            
        //   331: iconst_1       
        //   332: iconst_2       
        //   333: anewarray       Ljava/lang/Object;
        //   336: dup            
        //   337: iconst_0       
        //   338: iload_2         /* rest$Qu */
        //   339: ifeq            379
        //   342: iconst_2       
        //   343: anewarray       Ljava/lang/Object;
        //   346: dup            
        //   347: iconst_0       
        //   348: getstatic       gnu/kawa/slib/syntaxutils.Lit9:Lgnu/lists/PairWithPosition;
        //   351: aastore        
        //   352: dup            
        //   353: iconst_1       
        //   354: iconst_2       
        //   355: anewarray       Ljava/lang/Object;
        //   358: dup            
        //   359: iconst_0       
        //   360: aload           rest
        //   362: aastore        
        //   363: dup            
        //   364: iconst_1       
        //   365: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
        //   368: aastore        
        //   369: invokestatic    kawa/lang/Quote.consX$V:([Ljava/lang/Object;)Ljava/lang/Object;
        //   372: aastore        
        //   373: invokestatic    kawa/lang/Quote.append$V:([Ljava/lang/Object;)Ljava/lang/Object;
        //   376: goto            382
        //   379: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
        //   382: aastore        
        //   383: dup            
        //   384: iconst_1       
        //   385: iconst_2       
        //   386: anewarray       Ljava/lang/Object;
        //   389: dup            
        //   390: iconst_0       
        //   391: iload_3         /* key$Qu */
        //   392: ifeq            430
        //   395: iconst_2       
        //   396: anewarray       Ljava/lang/Object;
        //   399: dup            
        //   400: iconst_0       
        //   401: getstatic       gnu/kawa/slib/syntaxutils.Lit10:Lgnu/lists/PairWithPosition;
        //   404: aastore        
        //   405: dup            
        //   406: iconst_1       
        //   407: aload           key
        //   409: ldc             Lgnu/lists/LList;.class
        //   411: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   414: dup            
        //   415: astore          9
        //   417: checkcast       Lgnu/lists/LList;
        //   420: invokestatic    kawa/lib/lists.reverse:(Lgnu/lists/LList;)Lgnu/lists/LList;
        //   423: aastore        
        //   424: invokestatic    kawa/lang/Quote.append$V:([Ljava/lang/Object;)Ljava/lang/Object;
        //   427: goto            433
        //   430: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
        //   433: aastore        
        //   434: dup            
        //   435: iconst_1       
        //   436: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
        //   439: aastore        
        //   440: invokestatic    kawa/lang/Quote.append$V:([Ljava/lang/Object;)Ljava/lang/Object;
        //   443: aastore        
        //   444: invokestatic    kawa/lang/Quote.append$V:([Ljava/lang/Object;)Ljava/lang/Object;
        //   447: aastore        
        //   448: invokestatic    kawa/lang/Quote.append$V:([Ljava/lang/Object;)Ljava/lang/Object;
        //   451: aastore        
        //   452: invokestatic    kawa/lang/Quote.append$V:([Ljava/lang/Object;)Ljava/lang/Object;
        //   455: areturn        
        //   456: new             Lgnu/mapping/WrongType;
        //   459: dup_x1         
        //   460: swap           
        //   461: ldc_w           "reverse"
        //   464: iconst_1       
        //   465: aload           9
        //   467: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   470: athrow         
        //   471: new             Lgnu/mapping/WrongType;
        //   474: dup_x1         
        //   475: swap           
        //   476: ldc_w           "reverse"
        //   479: iconst_1       
        //   480: aload           9
        //   482: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   485: athrow         
        //   486: new             Lgnu/mapping/WrongType;
        //   489: dup_x1         
        //   490: swap           
        //   491: ldc_w           "reverse"
        //   494: iconst_1       
        //   495: aload           9
        //   497: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   500: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  265    268    456    471    Ljava/lang/ClassCastException;
        //  319    322    471    486    Ljava/lang/ClassCastException;
        //  417    420    486    501    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    static Object unrewriteApply(final ApplyExp exp) {
        final Expression fun = exp.getFunction();
        final LList args = unrewrite$St(exp.getArgs());
        Label_0037: {
            if (!(fun instanceof ReferenceExp)) {
                break Label_0037;
            }
            final Expression argValue = fun;
            try {
                final ReferenceExp fun2 = (ReferenceExp)argValue;
                Declaration binding = fun2.getBinding();
                while (true) {
                    final Declaration fbinding = binding;
                    final Declaration apply$Mnto$Mnargs = Declaration.getDeclarationFromStatic("kawa.standard.Scheme", "applyToArgs");
                    final Object fval = exp.getFunctionValue();
                    Object o;
                    if (fbinding != null && apply$Mnto$Mnargs != null && fbinding.field == apply$Mnto$Mnargs.field) {
                        o = args;
                    }
                    else {
                        final Object x = (fval instanceof Convert) ? Quote.append$V(new Object[] { syntaxutils.Lit19, args }) : ((fval instanceof GetNamedPart) ? Quote.append$V(new Object[] { syntaxutils.Lit20, args }) : Boolean.FALSE);
                        o = (KawaConvert.isTrue(x) ? x : Quote.consX$V(new Object[] { unrewrite(fun), args }));
                    }
                    return o;
                    binding = null;
                    continue;
                }
            }
            catch (ClassCastException ex) {
                throw new WrongType(ex, "fun", -2, argValue);
            }
        }
    }
    
    static LList unrewrite$St(final Expression[] exps) {
        LList pack = LList.Empty;
        final Object value = exps.length;
        final IntNum lit6 = syntaxutils.Lit6;
        IntNum i = null;
        for (Object len = value; !NumberCompare.$Eq(i, len); i = IntNum.add(i, 1)) {
            final Object v = unrewrite(exps[i.intValue()]);
            pack = lists.cons(v, pack);
        }
        return lists.reverse$Ex(pack);
    }
    
    public static Object lambda1loop(Declaration decl) {
        while (decl != null) {
            if (decl.getType() != Compilation.typeProcedure) {
                return lists.cons(LList.list3(decl.getSymbol(), syntaxutils.Lit14, decl.getType()), lambda1loop(decl.nextDecl()));
            }
            decl = decl.nextDecl();
        }
        return LList.Empty;
    }
    
    public static Object lambda2loop(final LambdaExp child) {
        return (child == null) ? LList.Empty : lists.cons(unrewriteMethod(child), lambda2loop(child.nextSibling));
    }
    
    static Pair unrewriteMethod(final LambdaExp exp) {
        final Declaration decl = exp.nameDecl;
        final String name = exp.getName();
        final boolean x = decl != null && decl.getFlag(Declaration.STATIC_SPECIFIED);
        final boolean static$Qu = x ? x : (name == "$clinit$");
        final boolean private$Qu = decl != null && decl.getFlag(Declaration.PRIVATE_ACCESS);
        final boolean protected$Qu = decl != null && decl.getFlag(Declaration.PROTECTED_ACCESS);
        return Pair.make(Quote.consX$V(new Object[] { name, Quote.append$V(new Object[] { unrewriteArglist(exp), LList.Empty }) }), Quote.append$V(new Object[] { static$Qu ? syntaxutils.Lit15 : LList.Empty, Quote.append$V(new Object[] { (private$Qu ? private$Qu : protected$Qu) ? Quote.append$V(new Object[] { syntaxutils.Lit16, Quote.consX$V(new Object[] { private$Qu ? syntaxutils.Lit17 : syntaxutils.Lit18, LList.Empty }) }) : LList.Empty, Quote.consX$V(new Object[] { unrewrite(exp.body), LList.Empty }) }) }));
    }
    
    static {
        Lit36 = Symbol.valueOf("lambda");
        Lit35 = Symbol.valueOf("as");
        Lit34 = Symbol.valueOf("else");
        Lit33 = Symbol.valueOf("let");
        Lit32 = Symbol.valueOf("cond");
        Lit31 = Symbol.valueOf("begin");
        (Lit30 = new Object[] { null })[0] = (Lit29 = Symbol.valueOf("or"));
        Lit28 = Symbol.valueOf("quote");
        Lit27 = Symbol.valueOf("eql");
        Lit26 = new Object[0];
        Lit25 = Symbol.valueOf("expand");
        Lit24 = new SyntaxRules(syntaxutils.Lit26, new SyntaxRule[] { new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\f\u000f\r\u0017\u0010\b\b", syntaxutils.Lit26, 3, "syntaxutils.scm:49"), "\u0001\u0001\u0003", "\u0011\u0018\u0004\t\u000b)\u0011\u0018\f\b\u0003\b\u0015\u0013", new Object[] { Symbol.valueOf("invoke"), syntaxutils.Lit28 }, 1) }, 3, Lit23 = Symbol.valueOf("!"));
        Lit22 = new SyntaxRules(new Object[] { syntaxutils.Lit27, syntaxutils.Lit29 }, new SyntaxRule[] { new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007<\f\u0002\r\u000f\b\b\b\r\u0017\u0010\b\b", new Object[] { Boolean.TRUE }, 3, "syntaxutils.scm:17"), "\u0001\u0003\u0003", "\u0011\u0018\u0004\b\r\u000b", new Object[] { syntaxutils.Lit31 }, 1), new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\\,\f\u0002\f\u000f\b\r\u0017\u0010\b\b\r\u001f\u0018\b\b", new Object[] { syntaxutils.Lit27 }, 4, "syntaxutils.scm:19"), "\u0001\u0001\u0003\u0003", "\u0011\u0018\u0004yY\u0011\u0018\f\t\u0003\b\u0011\u0018\u0014\b\u000b\b\u0015\u0013\b\u0011\u0018\u001c\b\u0011\u0018$\t\u0003\b\u001d\u001b", new Object[] { syntaxutils.Lit32, Symbol.valueOf("eqv?"), syntaxutils.Lit28, syntaxutils.Lit34, Lit21 = Symbol.valueOf("typecase%") }, 1), new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\\,\f\u0002\f\u000f\b\r\u0017\u0010\b\b\r\u001f\u0018\b\b", syntaxutils.Lit30, 4, "syntaxutils.scm:22"), "\u0001\u0001\u0003\u0003", "\u0011\u0018\u0004\t\u0003)\t\u000b\b\u0015\u0013\b\u001d\u001b", new Object[] { syntaxutils.Lit21 }, 1), new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007l<\f\u0002\r\u000f\b\b\b\r\u0017\u0010\b\b\r\u001f\u0018\b\b", syntaxutils.Lit30, 4, "syntaxutils.scm:24"), "\u0001\u0003\u0003\u0003", "\u0011\u0018\u0004\u0091\b\u0011\u0018\f\b\u0011\u0018\u0014\u0011\b\u0003\b\u0011\u0018\u001c\b\u0015\u0013\b\u0011\u0018$\t\u0003I\r\t\u000b\b\u0011\u0018\f\b\u0003\b\t,\b\u0011\u0018$\t\u0003\b\u001d\u001b", new Object[] { syntaxutils.Lit33, Symbol.valueOf("f"), syntaxutils.Lit36, syntaxutils.Lit31, syntaxutils.Lit21, Boolean.TRUE }, 1), new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007<\f\u000f\r\u0017\u0010\b\b\r\u001f\u0018\b\b", syntaxutils.Lit26, 4, "syntaxutils.scm:29"), "\u0001\u0001\u0003\u0003", "\u0011\u0018\u0004\u00f19\u0011\u0018\f\t\u0003\b\u000b\b\u0011\u0018\u0014Q\b\t\u0003\u0011\u0018\u001c\t\u000b\b\u0003\b\u0011\u0018$\b\u0015\u0013\b\u0011\u0018,\b\u0011\u00184\t\u0003\b\u001d\u001b", new Object[] { syntaxutils.Lit32, Symbol.valueOf("instance?"), syntaxutils.Lit33, Lit14 = Symbol.valueOf("::"), syntaxutils.Lit31, syntaxutils.Lit34, syntaxutils.Lit21 }, 1), new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\b", syntaxutils.Lit26, 1, "syntaxutils.scm:34"), "\u0001", "\u0011\u0018\u0004\t\f\t\u0003\b\u0011\u0018\u0014\u0011\u0018\u001c\b\u0011\u0018$\u0011\u0018,\b\u0003", new Object[] { Symbol.valueOf("error"), "typecase% failed", syntaxutils.Lit23, Symbol.valueOf("getClass"), syntaxutils.Lit35, Symbol.valueOf("<object>") }, 0) }, 4, syntaxutils.Lit21);
        Lit20 = PairWithPosition.make(Symbol.valueOf(":"), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/syntaxutils.scm", 913424);
        Lit19 = PairWithPosition.make(syntaxutils.Lit35, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/syntaxutils.scm", 905232);
        Lit18 = PairWithPosition.make(syntaxutils.Lit28, PairWithPosition.make(Symbol.valueOf("protected"), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/syntaxutils.scm", 827441), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/syntaxutils.scm", 827441);
        Lit17 = PairWithPosition.make(syntaxutils.Lit28, PairWithPosition.make(Symbol.valueOf("private"), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/syntaxutils.scm", 827431), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/syntaxutils.scm", 827431);
        Lit16 = PairWithPosition.make(Keyword.make("access"), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/syntaxutils.scm", 827406);
        Lit15 = PairWithPosition.make(Keyword.make("allocation"), PairWithPosition.make(PairWithPosition.make(syntaxutils.Lit28, PairWithPosition.make(Symbol.valueOf("static"), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/syntaxutils.scm", 819236), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/syntaxutils.scm", 819236), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/syntaxutils.scm", 819235), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/syntaxutils.scm", 819222);
        Lit13 = PairWithPosition.make(Symbol.valueOf("class"), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/syntaxutils.scm", 708612);
        Lit12 = PairWithPosition.make(syntaxutils.Lit28, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/syntaxutils.scm", 696332);
        Lit11 = PairWithPosition.make(syntaxutils.Lit33, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/syntaxutils.scm", 618500);
        Lit10 = PairWithPosition.make(Special.key, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/syntaxutils.scm", 573462);
        Lit9 = PairWithPosition.make(Special.rest, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/syntaxutils.scm", 565271);
        Lit8 = PairWithPosition.make(Special.optional, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/syntaxutils.scm", 561165);
        Lit7 = IntNum.valueOf(1);
        Lit6 = IntNum.valueOf(0);
        Lit5 = PairWithPosition.make(Symbol.valueOf("if"), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/syntaxutils.scm", 409607);
        Lit4 = PairWithPosition.make(syntaxutils.Lit36, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/syntaxutils.scm", 385031);
        Lit3 = PairWithPosition.make(Symbol.valueOf("set"), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/syntaxutils.scm", 372743);
        Lit2 = Keyword.make("lang");
        Lit1 = PairWithPosition.make(syntaxutils.Lit31, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/syntaxutils.scm", 278557);
        Lit0 = Keyword.make("env");
        syntaxutils.$instance = new syntaxutils();
        $Prvt$typecase$Pc = Macro.make(syntaxutils.Lit21, syntaxutils.Lit22, "gnu.kawa.slib.syntaxutils");
        $Prvt$$Ex = Macro.make(syntaxutils.Lit23, syntaxutils.Lit24, "gnu.kawa.slib.syntaxutils");
        expand = new ModuleMethod(syntaxutils.$instance, 1, syntaxutils.Lit25, -4095);
        $runBody$();
    }
    
    public syntaxutils() {
        ModuleInfo.register(this);
    }
    
    @Override
    public int matchN(final ModuleMethod moduleMethod, final Object[] array, final CallContext ctx) {
        if (moduleMethod.selector == 1) {
            ctx.values = array;
            ctx.proc = moduleMethod;
            ctx.pc = 5;
            return 0;
        }
        return super.matchN(moduleMethod, array, ctx);
    }
    
    @Override
    public void apply(final CallContext callContext) {
        final int pc = callContext.pc;
        ModuleMethod.applyError();
    }
    
    @Override
    public Object applyN(final ModuleMethod method, final Object[] args) {
        if (method.selector == 1) {
            final Object sexp = args[0];
            int n = args.length - 1;
            final Object[] argsArray = new Object[n];
            while (--n >= 0) {
                argsArray[n] = args[n + 1];
            }
            return expand$V(sexp, argsArray);
        }
        return super.applyN(method, args);
    }
}
