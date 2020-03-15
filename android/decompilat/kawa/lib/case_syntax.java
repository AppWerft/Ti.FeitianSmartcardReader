// 
// Decompiled by Procyon v0.5.36
// 

package kawa.lib;

import kawa.standard.syntax_case;
import gnu.bytecode.Type;
import gnu.kawa.functions.MakeSplice;
import kawa.lang.SyntaxForms;
import kawa.lang.TemplateScope;
import gnu.expr.ModuleInfo;
import gnu.mapping.Procedure;
import gnu.expr.QuoteExp;
import gnu.expr.CaseExp;
import kawa.lang.SyntaxRule;
import gnu.mapping.Symbol;
import gnu.expr.Expression;
import gnu.mapping.Promise;
import kawa.lang.SyntaxForm;
import gnu.lists.Consumer;
import gnu.mapping.CallContext;
import kawa.lang.SyntaxTemplate;
import kawa.lang.SyntaxPattern;
import kawa.lang.SyntaxRules;
import gnu.mapping.SimpleSymbol;
import gnu.bytecode.ClassType;
import kawa.lang.Macro;
import gnu.expr.ModuleMethod;
import gnu.kawa.reflect.StaticFieldLocation;
import gnu.expr.ModuleBody;

public class case_syntax extends ModuleBody
{
    public static final StaticFieldLocation $Prvt$let;
    public static final StaticFieldLocation $Prvt$else;
    public static final Object $LsCaseClause$Gr;
    public static final Class $LsCaseExp$Gr;
    public static final Class $LsExpression$Gr;
    public static final Class $LsQuoteExp$Gr;
    public static final ModuleMethod syntax$Mnform$Mn$Grdatum;
    public static final ModuleMethod clause$Mndatums$Mn$Grexps;
    public static final ModuleMethod syntax$Mn$Grcase$Mnclauses;
    public static final ModuleMethod case$Mnclause$Mn$Grexpression;
    public static final Macro case;
    public static final Macro $Pccase;
    static final Class Lit0;
    static final ClassType Lit1;
    static final SimpleSymbol Lit2;
    static final SimpleSymbol Lit3;
    public static case_syntax $instance;
    static final SimpleSymbol Lit4;
    static final SimpleSymbol Lit5;
    static final SimpleSymbol Lit6;
    static final SimpleSymbol Lit7;
    static final SimpleSymbol Lit8;
    static final SyntaxRules Lit9;
    static final SimpleSymbol Lit10;
    static final SyntaxPattern Lit11;
    static final SyntaxTemplate Lit12;
    static final SyntaxTemplate Lit13;
    static final SyntaxTemplate Lit14;
    static final ClassType Lit15;
    static final SyntaxTemplate Lit16;
    static final SyntaxTemplate Lit17;
    static final SyntaxPattern Lit18;
    static final SyntaxTemplate Lit19;
    static final SyntaxTemplate Lit20;
    static final SyntaxTemplate Lit21;
    static final Object[] Lit22;
    static final Object[] Lit23;
    
    private static void $runBody$() {
        final CallContext $ctx;
        final Consumer $result = ($ctx = CallContext.getInstance()).consumer;
        $LsCaseClause$Gr = case_syntax.Lit0;
    }
    
    public static Object syntaxForm$To$Datum(final Object obj) {
        return (obj instanceof SyntaxForm) ? ((SyntaxForm)Promise.force(obj, SyntaxForm.class)).getDatum() : obj;
    }
    
    public static Object clauseDatums$To$Exps(final Object datums) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokestatic    kawa/lib/lists.isNull:(Ljava/lang/Object;)Z
        //     4: ifeq            13
        //     7: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
        //    10: goto            80
        //    13: invokestatic    gnu/expr/Compilation.getCurrent:()Lgnu/expr/Compilation;
        //    16: dup            
        //    17: astore_2       
        //    18: checkcast       Lkawa/lang/Translator;
        //    21: astore_1        /* tr */
        //    22: aload_1         /* tr */
        //    23: aload_0         /* datums */
        //    24: ldc             Lgnu/lists/Pair;.class
        //    26: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    29: dup            
        //    30: astore_3       
        //    31: checkcast       Lgnu/lists/Pair;
        //    34: iconst_0       
        //    35: invokevirtual   kawa/lang/Translator.rewrite_car:(Lgnu/lists/Pair;Z)Lgnu/expr/Expression;
        //    38: astore_2        /* datum */
        //    39: aload_0         /* datums */
        //    40: ldc             Lgnu/lists/Pair;.class
        //    42: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    45: dup            
        //    46: astore_3       
        //    47: checkcast       Lgnu/lists/Pair;
        //    50: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    53: invokestatic    kawa/lib/case_syntax.syntaxForm$To$Datum:(Ljava/lang/Object;)Ljava/lang/Object;
        //    56: aload_2         /* datum */
        //    57: invokestatic    gnu/expr/QuoteExp.getInstance:(Ljava/lang/Object;Lgnu/text/SourceLocator;)Lgnu/expr/QuoteExp;
        //    60: aload_0         /* datums */
        //    61: ldc             Lgnu/lists/Pair;.class
        //    63: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    66: dup            
        //    67: astore_3       
        //    68: checkcast       Lgnu/lists/Pair;
        //    71: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    74: invokestatic    kawa/lib/case_syntax.clauseDatums$To$Exps:(Ljava/lang/Object;)Ljava/lang/Object;
        //    77: invokestatic    kawa/lib/lists.cons:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //    80: areturn        
        //    81: new             Lgnu/mapping/WrongType;
        //    84: dup_x1         
        //    85: swap           
        //    86: ldc             "tr"
        //    88: bipush          -2
        //    90: aload_2        
        //    91: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //    94: athrow         
        //    95: new             Lgnu/mapping/WrongType;
        //    98: dup_x1         
        //    99: swap           
        //   100: ldc             "kawa.lang.Translator.rewrite_car(gnu.lists.Pair,boolean)"
        //   102: iconst_2       
        //   103: aload_3        
        //   104: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   107: athrow         
        //   108: new             Lgnu/mapping/WrongType;
        //   111: dup_x1         
        //   112: swap           
        //   113: ldc             "car"
        //   115: iconst_1       
        //   116: aload_3        
        //   117: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   120: athrow         
        //   121: new             Lgnu/mapping/WrongType;
        //   124: dup_x1         
        //   125: swap           
        //   126: ldc             "cdr"
        //   128: iconst_1       
        //   129: aload_3        
        //   130: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   133: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  18     21     81     95     Ljava/lang/ClassCastException;
        //  31     34     95     108    Ljava/lang/ClassCastException;
        //  47     50     108    121    Ljava/lang/ClassCastException;
        //  68     71     121    134    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 72 out of bounds for length 72
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
    
    public static Object syntax$To$CaseClauses(final Object s$Mnclauses, final Object key) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokestatic    kawa/lib/lists.isNull:(Ljava/lang/Object;)Z
        //     4: ifne            129
        //     7: aload_0         /* s$Mnclauses */
        //     8: ldc             Lgnu/lists/Pair;.class
        //    10: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    13: dup            
        //    14: astore_3       
        //    15: checkcast       Lgnu/lists/Pair;
        //    18: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    21: astore_2        /* clause */
        //    22: aload_2         /* clause */
        //    23: ldc             Lgnu/lists/Pair;.class
        //    25: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    28: dup            
        //    29: astore          4
        //    31: checkcast       Lgnu/lists/Pair;
        //    34: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    37: astore_3        /* datums */
        //    38: aload_0         /* s$Mnclauses */
        //    39: ldc             Lgnu/lists/Pair;.class
        //    41: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    44: dup            
        //    45: astore          5
        //    47: checkcast       Lgnu/lists/Pair;
        //    50: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    53: astore          rest
        //    55: new             Lgnu/expr/CaseExp$CaseClause;
        //    58: dup            
        //    59: iconst_0       
        //    60: istore          5
        //    62: aload_3         /* datums */
        //    63: invokestatic    kawa/lib/case_syntax.clauseDatums$To$Exps:(Ljava/lang/Object;)Ljava/lang/Object;
        //    66: astore          6
        //    68: aload           6
        //    70: invokestatic    gnu/kawa/functions/MakeSplice.count:(Ljava/lang/Object;)I
        //    73: dup            
        //    74: istore          7
        //    76: iload           5
        //    78: iadd           
        //    79: istore          5
        //    81: iload           5
        //    83: anewarray       Lgnu/expr/Expression;
        //    86: dup            
        //    87: iconst_0       
        //    88: istore          8
        //    90: iload           8
        //    92: iload           7
        //    94: aload           6
        //    96: getstatic       kawa/lib/case_syntax.Lit1:Lgnu/bytecode/ClassType;
        //    99: invokestatic    gnu/kawa/functions/MakeSplice.copyTo:(Ljava/lang/Object;IILjava/lang/Object;Lgnu/bytecode/Type;)V
        //   102: iload           8
        //   104: iload           7
        //   106: iadd           
        //   107: istore          8
        //   109: aload_2         /* clause */
        //   110: aload_1         /* key */
        //   111: invokestatic    kawa/lib/case_syntax.caseClause$To$Expression:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/expr/Expression;
        //   114: invokespecial   gnu/expr/CaseExp$CaseClause.<init>:([Lgnu/expr/Expression;Lgnu/expr/Expression;)V
        //   117: aload           rest
        //   119: aload_1         /* key */
        //   120: invokestatic    kawa/lib/case_syntax.syntax$To$CaseClauses:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   123: invokestatic    kawa/lib/lists.cons:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //   126: goto            132
        //   129: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
        //   132: areturn        
        //   133: new             Lgnu/mapping/WrongType;
        //   136: dup_x1         
        //   137: swap           
        //   138: ldc             "car"
        //   140: iconst_1       
        //   141: aload_3        
        //   142: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   145: athrow         
        //   146: new             Lgnu/mapping/WrongType;
        //   149: dup_x1         
        //   150: swap           
        //   151: ldc             "car"
        //   153: iconst_1       
        //   154: aload           4
        //   156: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   159: athrow         
        //   160: new             Lgnu/mapping/WrongType;
        //   163: dup_x1         
        //   164: swap           
        //   165: ldc             "cdr"
        //   167: iconst_1       
        //   168: aload           5
        //   170: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   173: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  15     18     133    146    Ljava/lang/ClassCastException;
        //  31     34     146    160    Ljava/lang/ClassCastException;
        //  47     50     160    174    Ljava/lang/ClassCastException;
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
    
    public static Expression caseClause$To$Expression(final Object s$Mnclause, final Object key) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokestatic    kawa/lib/lists.isNull:(Ljava/lang/Object;)Z
        //     4: istore_2        /* x */
        //     5: iload_2         /* x */
        //     6: ifeq            16
        //     9: iload_2         /* x */
        //    10: ifeq            52
        //    13: goto            36
        //    16: aload_0         /* s$Mnclause */
        //    17: ldc             Lgnu/lists/Pair;.class
        //    19: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    22: dup            
        //    23: astore_3       
        //    24: checkcast       Lgnu/lists/Pair;
        //    27: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    30: invokestatic    kawa/lib/lists.isNull:(Ljava/lang/Object;)Z
        //    33: ifeq            52
        //    36: aload_0         /* s$Mnclause */
        //    37: iconst_1       
        //    38: anewarray       Ljava/lang/Object;
        //    41: dup            
        //    42: iconst_0       
        //    43: ldc             "too few expressions for a 'case' clause"
        //    45: aastore        
        //    46: invokestatic    kawa/lib/prim_syntax.reportSyntaxError:(Ljava/lang/Object;[Ljava/lang/Object;)Lgnu/expr/Expression;
        //    49: goto            141
        //    52: aload_0         /* s$Mnclause */
        //    53: ldc             Lgnu/lists/Pair;.class
        //    55: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    58: dup            
        //    59: astore          4
        //    61: checkcast       Lgnu/lists/Pair;
        //    64: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    67: astore_3        /* exp */
        //    68: aload_3         /* exp */
        //    69: ldc             Lgnu/lists/Pair;.class
        //    71: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    74: dup            
        //    75: astore          5
        //    77: checkcast       Lgnu/lists/Pair;
        //    80: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    83: getstatic       kawa/lib/case_syntax.Lit2:Lgnu/mapping/SimpleSymbol;
        //    86: if_acmpne       127
        //    89: iconst_2       
        //    90: anewarray       Ljava/lang/Object;
        //    93: dup            
        //    94: iconst_0       
        //    95: aload_3         /* exp */
        //    96: ldc             Lgnu/lists/Pair;.class
        //    98: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   101: dup            
        //   102: astore          5
        //   104: checkcast       Lgnu/lists/Pair;
        //   107: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   110: aastore        
        //   111: dup            
        //   112: iconst_1       
        //   113: aload_1         /* key */
        //   114: invokestatic    gnu/lists/LList.list1:(Ljava/lang/Object;)Lgnu/lists/Pair;
        //   117: aastore        
        //   118: invokestatic    kawa/standard/append.append$V:([Ljava/lang/Object;)Ljava/lang/Object;
        //   121: invokestatic    gnu/lists/LList.list1:(Ljava/lang/Object;)Lgnu/lists/Pair;
        //   124: goto            128
        //   127: aload_3         /* exp */
        //   128: astore          exp
        //   130: getstatic       kawa/lib/case_syntax.Lit3:Lgnu/mapping/SimpleSymbol;
        //   133: aload           exp
        //   135: invokestatic    kawa/lib/lists.cons:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //   138: invokestatic    kawa/lang/SyntaxForms.rewrite:(Ljava/lang/Object;)Lgnu/expr/Expression;
        //   141: areturn        
        //   142: new             Lgnu/mapping/WrongType;
        //   145: dup_x1         
        //   146: swap           
        //   147: ldc             "cdr"
        //   149: iconst_1       
        //   150: aload_3        
        //   151: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   154: athrow         
        //   155: new             Lgnu/mapping/WrongType;
        //   158: dup_x1         
        //   159: swap           
        //   160: ldc             "cdr"
        //   162: iconst_1       
        //   163: aload           4
        //   165: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   168: athrow         
        //   169: new             Lgnu/mapping/WrongType;
        //   172: dup_x1         
        //   173: swap           
        //   174: ldc             "car"
        //   176: iconst_1       
        //   177: aload           5
        //   179: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   182: athrow         
        //   183: new             Lgnu/mapping/WrongType;
        //   186: dup_x1         
        //   187: swap           
        //   188: ldc             "cdr"
        //   190: iconst_1       
        //   191: aload           5
        //   193: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   196: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  24     27     142    155    Ljava/lang/ClassCastException;
        //  61     64     155    169    Ljava/lang/ClassCastException;
        //  77     80     169    183    Ljava/lang/ClassCastException;
        //  104    107    183    197    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 102 out of bounds for length 102
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
    
    static {
        (Lit23 = new Object[] { null })[0] = Symbol.valueOf("else");
        Lit22 = new Object[0];
        Lit21 = new SyntaxTemplate("\u0001\u0003", "\u0003", case_syntax.Lit22, 0);
        Lit20 = new SyntaxTemplate("\u0001\u0003", "\b\r\u000b", case_syntax.Lit22, 1);
        Lit19 = new SyntaxTemplate("\u0001\u0003", "\u0003", case_syntax.Lit22, 0);
        Lit18 = new SyntaxPattern("\f\u0018\f\u0007\r\u000f\b\b\b", case_syntax.Lit22, 2, "case_syntax.scm:67");
        Lit17 = new SyntaxTemplate("\u0001\u0003\u0003", "\u0003", case_syntax.Lit22, 0);
        Lit16 = new SyntaxTemplate("\u0001\u0003\u0003", "\u0011\u0018\u0004\b\u0015\u0013", case_syntax.Lit23, 1);
        Lit15 = ClassType.make("gnu.expr.CaseExp$CaseClause");
        Lit14 = new SyntaxTemplate("\u0001\u0003\u0003", "\u0003", case_syntax.Lit22, 0);
        Lit13 = new SyntaxTemplate("\u0001\u0003\u0003", "\b\r\u000b", case_syntax.Lit22, 1);
        Lit12 = new SyntaxTemplate("\u0001\u0003\u0003", "\u0003", case_syntax.Lit22, 0);
        Lit11 = new SyntaxPattern("\f\u0018\f\u0007\r\u000f\b\b\u0016<\f\u0002\r\u0017\u0010\b\b\b", case_syntax.Lit23, 3, "case_syntax.scm:58");
        Lit10 = Symbol.valueOf("%case");
        Lit9 = new SyntaxRules(case_syntax.Lit22, new SyntaxRule[] { new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\r\u000f\b\b\b", case_syntax.Lit22, 2, "case_syntax.scm:51"), "\u0001\u0003", "\u0011\u0018\u00041\b\u0011\u0018\f\b\u0003\b\u0011\u0018\u0014\u0011\u0018\f\b\r\u000b", new Object[] { Symbol.valueOf("let"), Symbol.valueOf("tmp"), case_syntax.Lit10 }, 1) }, 2, Lit8 = Symbol.valueOf("case"));
        Lit7 = Symbol.valueOf("case-clause->expression");
        Lit6 = Symbol.valueOf("syntax->case-clauses");
        Lit5 = Symbol.valueOf("clause-datums->exps");
        Lit4 = Symbol.valueOf("syntax-form->datum");
        Lit3 = Symbol.valueOf("begin");
        Lit2 = Symbol.valueOf("=>");
        Lit1 = ClassType.make("gnu.expr.Expression");
        Lit0 = CaseExp.CaseClause.class;
        $LsQuoteExp$Gr = QuoteExp.class;
        $LsExpression$Gr = Expression.class;
        $LsCaseExp$Gr = CaseExp.class;
        case_syntax.$instance = new case_syntax();
        $Prvt$let = StaticFieldLocation.make("kawa.lib.std_syntax", "let");
        $Prvt$else = StaticFieldLocation.make("kawa.lib.std_syntax", "else");
        final case_syntax $instance = case_syntax.$instance;
        syntax$Mnform$Mn$Grdatum = new ModuleMethod($instance, 1, case_syntax.Lit4, 4097);
        clause$Mndatums$Mn$Grexps = new ModuleMethod($instance, 2, case_syntax.Lit5, 4097);
        syntax$Mn$Grcase$Mnclauses = new ModuleMethod($instance, 3, case_syntax.Lit6, 8194);
        case$Mnclause$Mn$Grexpression = new ModuleMethod($instance, 4, case_syntax.Lit7, 8194);
        case = Macro.make(case_syntax.Lit8, case_syntax.Lit9, "kawa.lib.case_syntax");
        final SimpleSymbol lit10 = case_syntax.Lit10;
        final ModuleMethod expander = new ModuleMethod(case_syntax.$instance, 5, null, 4097);
        expander.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/case_syntax.scm:56");
        $Pccase = Macro.makeSkipScanForm(lit10, expander, "kawa.lib.case_syntax");
        $runBody$();
    }
    
    public case_syntax() {
        ModuleInfo.register(this);
    }
    
    static Object lambda1(final Object x) {
        final Object[] allocVars = SyntaxPattern.allocVars(3, null);
        Object error;
        if (case_syntax.Lit11.match(x, allocVars, 0)) {
            final Expression rewrite;
            final CaseExp.CaseClause[] array;
            final CaseExp.CaseClause elseClause;
            error = new CaseExp(rewrite, array, elseClause);
            rewrite = SyntaxForms.rewrite(case_syntax.Lit12.execute(allocVars, TemplateScope.make()));
            final int n = 0;
            final Object syntax$To$CaseClauses = syntax$To$CaseClauses(case_syntax.Lit13.execute(allocVars, TemplateScope.make()), case_syntax.Lit14.execute(allocVars, TemplateScope.make()));
            final int count;
            array = new CaseExp.CaseClause[(count = MakeSplice.count(syntax$To$CaseClauses)) + n];
            MakeSplice.copyTo(array, 0, count, syntax$To$CaseClauses, case_syntax.Lit15);
            elseClause = new CaseExp.CaseClause(caseClause$To$Expression(case_syntax.Lit16.execute(allocVars, TemplateScope.make()), case_syntax.Lit17.execute(allocVars, TemplateScope.make())));
        }
        else if (case_syntax.Lit18.match(x, allocVars, 0)) {
            final Expression rewrite2;
            final CaseExp.CaseClause[] array2;
            error = new CaseExp(rewrite2, array2);
            rewrite2 = SyntaxForms.rewrite(case_syntax.Lit19.execute(allocVars, TemplateScope.make()));
            final int n2 = 0;
            final Object syntax$To$CaseClauses2 = syntax$To$CaseClauses(case_syntax.Lit20.execute(allocVars, TemplateScope.make()), case_syntax.Lit21.execute(allocVars, TemplateScope.make()));
            final int count2;
            array2 = new CaseExp.CaseClause[(count2 = MakeSplice.count(syntax$To$CaseClauses2)) + n2];
            MakeSplice.copyTo(array2, 0, count2, syntax$To$CaseClauses2, case_syntax.Lit15);
        }
        else {
            error = syntax_case.error("syntax-case", x);
        }
        return error;
    }
    
    @Override
    public int match1(final ModuleMethod moduleMethod, final Object o, final CallContext ctx) {
        switch (moduleMethod.selector) {
            case 5: {
                ctx.value1 = o;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 2: {
                ctx.value1 = o;
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
    public int match2(final ModuleMethod proc, final Object arg1, final Object arg2, final CallContext ctx) {
        switch (proc.selector) {
            case 4: {
                ctx.value1 = arg1;
                ctx.value2 = arg2;
                ctx.proc = proc;
                ctx.pc = 2;
                return 0;
            }
            case 3: {
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
    public void apply(final CallContext callContext) {
        final int pc = callContext.pc;
        ModuleMethod.applyError();
    }
    
    @Override
    public Object apply1(final ModuleMethod method, final Object o) {
        switch (method.selector) {
            case 1: {
                return syntaxForm$To$Datum(o);
            }
            case 2: {
                return clauseDatums$To$Exps(o);
            }
            case 5: {
                return lambda1(o);
            }
            default: {
                return super.apply1(method, o);
            }
        }
    }
    
    @Override
    public Object apply2(final ModuleMethod method, final Object arg1, final Object arg2) {
        switch (method.selector) {
            case 3: {
                return syntax$To$CaseClauses(arg1, arg2);
            }
            case 4: {
                return caseClause$To$Expression(arg1, arg2);
            }
            default: {
                return super.apply2(method, arg1, arg2);
            }
        }
    }
}
