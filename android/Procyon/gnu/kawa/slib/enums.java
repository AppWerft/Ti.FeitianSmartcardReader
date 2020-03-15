// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.slib;

import kawa.standard.syntax_case;
import kawa.lib.prim_syntax;
import kawa.lib.std_syntax;
import kawa.lang.TemplateScope;
import gnu.expr.ModuleInfo;
import gnu.mapping.Procedure;
import gnu.expr.ModuleMethod;
import gnu.lists.Pair;
import kawa.lang.Quote;
import gnu.lists.LList;
import kawa.lib.misc;
import gnu.mapping.Symbol;
import gnu.lists.Consumer;
import gnu.mapping.CallContext;
import gnu.expr.Keyword;
import kawa.lang.SyntaxTemplate;
import kawa.lang.SyntaxPattern;
import gnu.mapping.SimpleSymbol;
import gnu.lists.PairWithPosition;
import kawa.lang.Macro;
import gnu.expr.ModuleBody;

public class enums extends ModuleBody
{
    public static final Macro define$Mnenum;
    public static final Macro $Prvt$$Pcdefine$Mnenum;
    static final PairWithPosition Lit0;
    static final PairWithPosition Lit1;
    static final PairWithPosition Lit2;
    static final PairWithPosition Lit3;
    static final PairWithPosition Lit4;
    public static enums $instance;
    static final SimpleSymbol Lit5;
    static final SyntaxPattern Lit6;
    static final SyntaxTemplate Lit7;
    static final SyntaxTemplate Lit8;
    static final SyntaxPattern Lit9;
    static final SyntaxTemplate Lit10;
    static final SyntaxPattern Lit11;
    static final SyntaxPattern Lit12;
    static final SyntaxPattern Lit13;
    static final SyntaxTemplate Lit14;
    static final SimpleSymbol Lit15;
    static final SyntaxPattern Lit16;
    static final SyntaxTemplate Lit17;
    static final SyntaxTemplate Lit18;
    static final SyntaxTemplate Lit19;
    static final SyntaxTemplate Lit20;
    static final SyntaxTemplate Lit21;
    static final SyntaxTemplate Lit22;
    static final SyntaxTemplate Lit23;
    static final SyntaxTemplate Lit24;
    static final SyntaxTemplate Lit25;
    static final SyntaxTemplate Lit26;
    static final SyntaxTemplate Lit27;
    static final SyntaxTemplate Lit28;
    static final Object[] Lit29;
    static final SimpleSymbol Lit30;
    static final SimpleSymbol Lit31;
    static final SimpleSymbol Lit32;
    static final SimpleSymbol Lit33;
    static final SimpleSymbol Lit34;
    static final Object[] Lit35;
    static final Object[] Lit36;
    static final Keyword Lit37;
    static final PairWithPosition Lit38;
    static final PairWithPosition Lit39;
    static final Keyword Lit40;
    static final SimpleSymbol Lit41;
    static final SimpleSymbol Lit42;
    static final SimpleSymbol Lit43;
    static final PairWithPosition Lit44;
    static final PairWithPosition Lit45;
    
    private static void $runBody$() {
        final CallContext $ctx;
        final Consumer $result = ($ctx = CallContext.getInstance()).consumer;
    }
    
    static Object makeFieldDesc(final Symbol t$Mnname, final Symbol e$Mnname, final int e$Mnval) {
        return Quote.consX$V(new Object[] { e$Mnname, Quote.append$V(new Object[] { enums.Lit0, Quote.consX$V(new Object[] { t$Mnname, Quote.append$V(new Object[] { enums.Lit1, Pair.make(Quote.consX$V(new Object[] { t$Mnname, Quote.consX$V(new Object[] { misc.symbol$To$String(e$Mnname), Quote.consX$V(new Object[] { e$Mnval, LList.Empty }) }) }), LList.Empty) }) }) }) });
    }
    
    static PairWithPosition makeInit() {
        return enums.Lit2;
    }
    
    static Object makeValues(final Symbol t$Mnarr, final LList e$Mnnames) {
        return Quote.append$V(new Object[] { enums.Lit3, Quote.consX$V(new Object[] { t$Mnarr, Quote.append$V(new Object[] { enums.Lit4, Pair.make(Quote.consX$V(new Object[] { t$Mnarr, Quote.append$V(new Object[] { e$Mnnames, LList.Empty }) }), LList.Empty) }) }) });
    }
    
    static LList mapNames(final Symbol t$Mnname, final LList e$Mnnames, final int i) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokestatic    kawa/lib/lists.isNull:(Ljava/lang/Object;)Z
        //     4: ifeq            13
        //     7: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
        //    10: goto            66
        //    13: aload_0         /* t$Mnname */
        //    14: aload_1         /* e$Mnnames */
        //    15: dup            
        //    16: astore_3       
        //    17: checkcast       Lgnu/lists/Pair;
        //    20: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    23: ldc             Lgnu/mapping/Symbol;.class
        //    25: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    28: dup            
        //    29: astore_3       
        //    30: checkcast       Lgnu/mapping/Symbol;
        //    33: iload_2         /* i */
        //    34: invokestatic    gnu/kawa/slib/enums.makeFieldDesc:(Lgnu/mapping/Symbol;Lgnu/mapping/Symbol;I)Ljava/lang/Object;
        //    37: aload_0         /* t$Mnname */
        //    38: aload_1         /* e$Mnnames */
        //    39: dup            
        //    40: astore_3       
        //    41: checkcast       Lgnu/lists/Pair;
        //    44: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    47: ldc             Lgnu/lists/LList;.class
        //    49: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    52: dup            
        //    53: astore_3       
        //    54: checkcast       Lgnu/lists/LList;
        //    57: iload_2         /* i */
        //    58: iconst_1       
        //    59: iadd           
        //    60: invokestatic    gnu/kawa/slib/enums.mapNames:(Lgnu/mapping/Symbol;Lgnu/lists/LList;I)Lgnu/lists/LList;
        //    63: invokestatic    kawa/lib/lists.cons:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //    66: areturn        
        //    67: new             Lgnu/mapping/WrongType;
        //    70: dup_x1         
        //    71: swap           
        //    72: ldc             "car"
        //    74: iconst_1       
        //    75: aload_3        
        //    76: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //    79: athrow         
        //    80: new             Lgnu/mapping/WrongType;
        //    83: dup_x1         
        //    84: swap           
        //    85: ldc             "make-field-desc"
        //    87: iconst_1       
        //    88: aload_3        
        //    89: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //    92: athrow         
        //    93: new             Lgnu/mapping/WrongType;
        //    96: dup_x1         
        //    97: swap           
        //    98: ldc             "cdr"
        //   100: iconst_1       
        //   101: aload_3        
        //   102: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   105: athrow         
        //   106: new             Lgnu/mapping/WrongType;
        //   109: dup_x1         
        //   110: swap           
        //   111: ldc             "map-names"
        //   113: iconst_1       
        //   114: aload_3        
        //   115: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   118: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  17     20     67     80     Ljava/lang/ClassCastException;
        //  30     33     80     93     Ljava/lang/ClassCastException;
        //  41     44     93     106    Ljava/lang/ClassCastException;
        //  54     57     106    119    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 67 out of bounds for length 67
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
        Lit45 = PairWithPosition.make(Lit34 = Symbol.valueOf("quote"), PairWithPosition.make(PairWithPosition.make(Symbol.valueOf("enum"), PairWithPosition.make(Symbol.valueOf("final"), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/enums.scm", 253996), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/enums.scm", 253990), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/enums.scm", 253990), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/enums.scm", 253990);
        Lit44 = PairWithPosition.make(enums.Lit34, PairWithPosition.make(Symbol.valueOf("static"), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/enums.scm", 274451), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/enums.scm", 274451);
        Lit43 = Symbol.valueOf("num");
        Lit42 = Symbol.valueOf("str");
        Lit41 = Symbol.valueOf("*init*");
        Lit40 = Keyword.make("access");
        Lit39 = PairWithPosition.make(Lit32 = Symbol.valueOf("::"), PairWithPosition.make(Symbol.valueOf("String"), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/enums.scm", 270354), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/enums.scm", 270352);
        Lit38 = PairWithPosition.make(enums.Lit44, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/enums.scm", 274450);
        Lit37 = Keyword.make("allocation");
        (Lit36 = new Object[] { null })[0] = "findkeywords";
        final Object[] array = Lit35 = new Object[2];
        array[0] = (Lit5 = Symbol.valueOf("define-enum"));
        array[1] = "findkeywords";
        Lit33 = Symbol.valueOf("java.lang.Enum");
        Lit31 = Symbol.valueOf("s");
        Lit30 = Symbol.valueOf("valueOf");
        Lit29 = new Object[0];
        Lit28 = new SyntaxTemplate("\u0001\u0001\u0003\u0003", "\u0010", enums.Lit29, 0);
        Lit27 = new SyntaxTemplate("\u0001\u0001\u0003\u0003", "\u0010", enums.Lit29, 0);
        Lit26 = new SyntaxTemplate("\u0001\u0001\u0003\u0003", "\u0018\u0004", new Object[] { Pair.make(enums.Lit31, LList.Empty) }, 0);
        Lit25 = new SyntaxTemplate("\u0001\u0001\u0003\u0003", "\u0018\u0004", new Object[] { Pair.make(PairWithPosition.make(Symbol.valueOf("$lookup$"), Pair.make(enums.Lit33, Pair.make(Pair.make(Symbol.valueOf("quasiquote"), Pair.make(enums.Lit30, LList.Empty)), LList.Empty)), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/enums.scm", 278535), LList.Empty) }, 0);
        Lit24 = new SyntaxTemplate("\u0001\u0001\u0003\u0003", "\u0018\u0004", new Object[] { Pair.make(enums.Lit37, enums.Lit38) }, 0);
        Lit23 = new SyntaxTemplate("\u0001\u0001\u0003\u0003", "\u0018\u0004", new Object[] { Pair.make(PairWithPosition.make(enums.Lit30, PairWithPosition.make(enums.Lit31, enums.Lit39, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/enums.scm", 270351), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/enums.scm", 270342), Lit0 = PairWithPosition.make(enums.Lit32, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/enums.scm", 270361)) }, 0);
        Lit22 = new SyntaxTemplate("\u0001\u0001\u0003\u0003", "\u0018\u0004", new Object[] { Pair.make(PairWithPosition.make(enums.Lit33, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/enums.scm", 253964), PairWithPosition.make(enums.Lit40, PairWithPosition.make(enums.Lit45, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/enums.scm", 253989), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/enums.scm", 253981)) }, 0);
        Lit21 = new SyntaxTemplate("\u0001\u0001\u0003\u0003", "\u0018\u0004", new Object[] { Pair.make(Symbol.valueOf("define-simple-class"), LList.Empty) }, 0);
        Lit20 = new SyntaxTemplate("\u0001\u0001\u0003\u0003", "\b\u001d\u001b", enums.Lit29, 1);
        Lit19 = new SyntaxTemplate("\u0001\u0001\u0003\u0003", "\u000b", enums.Lit29, 0);
        Lit18 = new SyntaxTemplate("\u0001\u0001\u0003\u0003", "\b\u0015\u0013", enums.Lit29, 1);
        Lit17 = new SyntaxTemplate("\u0001\u0001\u0003\u0003", "\u0003", enums.Lit29, 0);
        Lit16 = new SyntaxPattern("\f\u0018\f\u0007\f\u000f,\r\u0017\u0010\b\b\r\u001f\u0018\b\b", enums.Lit29, 4, "enums.scm:50");
        Lit15 = Symbol.valueOf("%define-enum");
        Lit14 = new SyntaxTemplate("\u0001\u0003", "\u0011\u0018\u0004\t\f\t\u0003\t\u0010\b\r\u000b", enums.Lit35, 1);
        Lit13 = new SyntaxPattern("\f\u0018\f\u0007\r\u000f\b\b\b", enums.Lit29, 2, "enums.scm:40");
        Lit12 = new SyntaxPattern("\f\u0018\f\u0007\b", enums.Lit29, 1, "enums.scm:39");
        Lit11 = new SyntaxPattern("\f\u0018\b", enums.Lit29, 0, "enums.scm:38");
        Lit10 = new SyntaxTemplate("\u0001\u0003\u0003", "\u0011\u0018\u0004\t\u0003\u0019\b\r\u000b\b\u0015\u0013", new Object[] { enums.Lit15 }, 1);
        Lit9 = new SyntaxPattern("\f\u0018\f\u0002\f\u0007,\r\u000f\b\b\b\r\u0017\u0010\b\b", enums.Lit36, 3, "enums.scm:36");
        Lit8 = new SyntaxTemplate("\u0001\u0003\u0001\u0001\u0003", "\u0011\u0018\u0004\t\f\t\u00039\t\u0013\t\u001b\b\r\u000b\b%#", enums.Lit35, 1);
        Lit7 = new SyntaxTemplate("\u0001\u0003\u0001\u0001\u0003", "\u0013", enums.Lit29, 0);
        Lit6 = new SyntaxPattern("\f\u0018\f\u0002\f\u0007,\r\u000f\b\b\b\f\u0017\f\u001f\r' \b\b", enums.Lit36, 5, "enums.scm:34");
        Lit4 = PairWithPosition.make(enums.Lit37, enums.Lit38, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/enums.scm", 110616);
        Lit3 = PairWithPosition.make(PairWithPosition.make(Symbol.valueOf("values"), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/enums.scm", 110597), enums.Lit0, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/enums.scm", 110596);
        Lit2 = PairWithPosition.make(PairWithPosition.make(enums.Lit41, PairWithPosition.make(PairWithPosition.make(enums.Lit42, enums.Lit39, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/enums.scm", 73741), PairWithPosition.make(PairWithPosition.make(enums.Lit43, PairWithPosition.make(enums.Lit32, PairWithPosition.make(Symbol.valueOf("int"), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/enums.scm", 73765), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/enums.scm", 73762), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/enums.scm", 73757), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/enums.scm", 73757), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/enums.scm", 73741), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/enums.scm", 73733), PairWithPosition.make(enums.Lit40, PairWithPosition.make(PairWithPosition.make(enums.Lit34, PairWithPosition.make(Symbol.valueOf("private"), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/enums.scm", 77838), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/enums.scm", 77838), PairWithPosition.make(PairWithPosition.make(Symbol.valueOf("invoke-special"), PairWithPosition.make(enums.Lit33, PairWithPosition.make(PairWithPosition.make(Symbol.valueOf("this"), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/enums.scm", 81956), PairWithPosition.make(PairWithPosition.make(enums.Lit34, PairWithPosition.make(enums.Lit41, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/enums.scm", 81964), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/enums.scm", 81964), PairWithPosition.make(enums.Lit42, PairWithPosition.make(enums.Lit43, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/enums.scm", 81975), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/enums.scm", 81971), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/enums.scm", 81963), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/enums.scm", 81956), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/enums.scm", 81941), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/enums.scm", 81925), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/enums.scm", 81925), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/enums.scm", 77837), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/enums.scm", 77829), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/enums.scm", 73732);
        Lit1 = PairWithPosition.make(enums.Lit37, PairWithPosition.make(enums.Lit44, PairWithPosition.make(enums.Lit40, PairWithPosition.make(enums.Lit45, PairWithPosition.make(Keyword.make("init"), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/enums.scm", 57357), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/enums.scm", 53289), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/enums.scm", 53281), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/enums.scm", 53273), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/enums.scm", 53261);
        enums.$instance = new enums();
        define$Mnenum = Macro.make(enums.Lit5, new ModuleMethod(enums.$instance, 1, null, 4097), "gnu.kawa.slib.enums");
        $Prvt$$Pcdefine$Mnenum = Macro.make(enums.Lit15, new ModuleMethod(enums.$instance, 2, null, 4097), "gnu.kawa.slib.enums");
        $runBody$();
    }
    
    public enums() {
        ModuleInfo.register(this);
    }
    
    static Object lambda1(final Object form) {
        final Object[] allocVars = SyntaxPattern.allocVars(5, null);
        return (enums.Lit6.match(form, allocVars, 0) && std_syntax.isIdentifier(enums.Lit7.execute(allocVars, TemplateScope.make()))) ? enums.Lit8.execute(allocVars, TemplateScope.make()) : (enums.Lit9.match(form, allocVars, 0) ? enums.Lit10.execute(allocVars, TemplateScope.make()) : (enums.Lit11.match(form, allocVars, 0) ? prim_syntax.reportSyntaxError(form, "no enum type name given") : (enums.Lit12.match(form, allocVars, 0) ? prim_syntax.reportSyntaxError(form, "no enum constants given") : (enums.Lit13.match(form, allocVars, 0) ? enums.Lit14.execute(allocVars, TemplateScope.make()) : syntax_case.error("syntax-case", form)))));
    }
    
    static Object lambda2(final Object form) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: astore_1       
        //     2: iconst_4       
        //     3: aconst_null    
        //     4: invokestatic    kawa/lang/SyntaxPattern.allocVars:(I[Ljava/lang/Object;)[Ljava/lang/Object;
        //     7: astore_2       
        //     8: getstatic       gnu/kawa/slib/enums.Lit16:Lkawa/lang/SyntaxPattern;
        //    11: aload_0         /* form */
        //    12: aload_2        
        //    13: iconst_0       
        //    14: invokevirtual   kawa/lang/Pattern.match:(Ljava/lang/Object;[Ljava/lang/Object;I)Z
        //    17: ifeq            491
        //    20: invokestatic    kawa/lang/TemplateScope.make:()Lkawa/lang/TemplateScope;
        //    23: astore          4
        //    25: getstatic       gnu/kawa/slib/enums.Lit17:Lkawa/lang/SyntaxTemplate;
        //    28: aload_2        
        //    29: aload           4
        //    31: invokevirtual   kawa/lang/SyntaxTemplate.execute:([Ljava/lang/Object;Lkawa/lang/TemplateScope;)Ljava/lang/Object;
        //    34: ldc             Lgnu/mapping/Symbol;.class
        //    36: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    39: dup            
        //    40: astore          5
        //    42: checkcast       Lgnu/mapping/Symbol;
        //    45: astore_3        /* t$Mnname */
        //    46: iconst_2       
        //    47: anewarray       Ljava/lang/Object;
        //    50: dup            
        //    51: iconst_0       
        //    52: aload_3         /* t$Mnname */
        //    53: invokestatic    kawa/lib/misc.symbol$To$String:(Lgnu/mapping/Symbol;)Ljava/lang/String;
        //    56: aastore        
        //    57: dup            
        //    58: iconst_1       
        //    59: ldc             "[]"
        //    61: aastore        
        //    62: invokestatic    kawa/lib/strings.stringAppend:([Ljava/lang/Object;)Lgnu/lists/FString;
        //    65: invokestatic    kawa/lib/misc.string$To$Symbol:(Ljava/lang/CharSequence;)Lgnu/mapping/SimpleSymbol;
        //    68: astore          t$Mnarr
        //    70: invokestatic    kawa/lang/TemplateScope.make:()Lkawa/lang/TemplateScope;
        //    73: astore          6
        //    75: getstatic       gnu/kawa/slib/enums.Lit18:Lkawa/lang/SyntaxTemplate;
        //    78: aload_2        
        //    79: aload           6
        //    81: invokevirtual   kawa/lang/SyntaxTemplate.execute:([Ljava/lang/Object;Lkawa/lang/TemplateScope;)Ljava/lang/Object;
        //    84: ldc             Lgnu/lists/LList;.class
        //    86: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    89: dup            
        //    90: astore          7
        //    92: checkcast       Lgnu/lists/LList;
        //    95: astore          e$Mnnames
        //    97: aload           e$Mnnames
        //    99: invokevirtual   gnu/lists/LList.size:()I
        //   102: pop            
        //   103: aload_3         /* t$Mnname */
        //   104: aload           e$Mnnames
        //   106: iconst_0       
        //   107: invokestatic    gnu/kawa/slib/enums.mapNames:(Lgnu/mapping/Symbol;Lgnu/lists/LList;I)Lgnu/lists/LList;
        //   110: astore          field$Mndescs
        //   112: invokestatic    gnu/kawa/slib/enums.makeInit:()Lgnu/lists/PairWithPosition;
        //   115: astore          init
        //   117: aload           t$Mnarr
        //   119: aload           e$Mnnames
        //   121: invokestatic    gnu/kawa/slib/enums.makeValues:(Lgnu/mapping/Symbol;Lgnu/lists/LList;)Ljava/lang/Object;
        //   124: ldc             Lgnu/lists/LList;.class
        //   126: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   129: dup            
        //   130: astore          9
        //   132: checkcast       Lgnu/lists/LList;
        //   135: astore          values$Mnmethod
        //   137: invokestatic    kawa/lang/TemplateScope.make:()Lkawa/lang/TemplateScope;
        //   140: astore          10
        //   142: getstatic       gnu/kawa/slib/enums.Lit19:Lkawa/lang/SyntaxTemplate;
        //   145: aload_2        
        //   146: aload           10
        //   148: invokevirtual   kawa/lang/SyntaxTemplate.execute:([Ljava/lang/Object;Lkawa/lang/TemplateScope;)Ljava/lang/Object;
        //   151: ldc             Lgnu/lists/LList;.class
        //   153: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   156: dup            
        //   157: astore          11
        //   159: checkcast       Lgnu/lists/LList;
        //   162: astore          opts
        //   164: invokestatic    kawa/lang/TemplateScope.make:()Lkawa/lang/TemplateScope;
        //   167: astore          11
        //   169: getstatic       gnu/kawa/slib/enums.Lit20:Lkawa/lang/SyntaxTemplate;
        //   172: aload_2        
        //   173: aload           11
        //   175: invokevirtual   kawa/lang/SyntaxTemplate.execute:([Ljava/lang/Object;Lkawa/lang/TemplateScope;)Ljava/lang/Object;
        //   178: ldc             Lgnu/lists/LList;.class
        //   180: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   183: dup            
        //   184: astore          12
        //   186: checkcast       Lgnu/lists/LList;
        //   189: astore          other$Mndefs
        //   191: invokestatic    kawa/lang/TemplateScope.make:()Lkawa/lang/TemplateScope;
        //   194: astore          11
        //   196: iconst_2       
        //   197: anewarray       Ljava/lang/Object;
        //   200: dup            
        //   201: iconst_0       
        //   202: getstatic       gnu/kawa/slib/enums.Lit21:Lkawa/lang/SyntaxTemplate;
        //   205: aload_2        
        //   206: aload           11
        //   208: invokevirtual   kawa/lang/SyntaxTemplate.execute:([Ljava/lang/Object;Lkawa/lang/TemplateScope;)Ljava/lang/Object;
        //   211: aastore        
        //   212: dup            
        //   213: iconst_1       
        //   214: iconst_2       
        //   215: anewarray       Ljava/lang/Object;
        //   218: dup            
        //   219: iconst_0       
        //   220: aload_0         /* form */
        //   221: aload_3         /* t$Mnname */
        //   222: invokestatic    kawa/lib/std_syntax.datum$To$SyntaxObject:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   225: aastore        
        //   226: dup            
        //   227: iconst_1       
        //   228: iconst_2       
        //   229: anewarray       Ljava/lang/Object;
        //   232: dup            
        //   233: iconst_0       
        //   234: getstatic       gnu/kawa/slib/enums.Lit22:Lkawa/lang/SyntaxTemplate;
        //   237: aload_2        
        //   238: aload           11
        //   240: invokevirtual   kawa/lang/SyntaxTemplate.execute:([Ljava/lang/Object;Lkawa/lang/TemplateScope;)Ljava/lang/Object;
        //   243: aastore        
        //   244: dup            
        //   245: iconst_1       
        //   246: iconst_2       
        //   247: anewarray       Ljava/lang/Object;
        //   250: dup            
        //   251: iconst_0       
        //   252: aload_0         /* form */
        //   253: aload           opts
        //   255: invokestatic    kawa/lib/std_syntax.datum$To$SyntaxObject:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   258: aastore        
        //   259: dup            
        //   260: iconst_1       
        //   261: iconst_2       
        //   262: anewarray       Ljava/lang/Object;
        //   265: dup            
        //   266: iconst_0       
        //   267: aload_0         /* form */
        //   268: aload           init
        //   270: invokestatic    kawa/lib/std_syntax.datum$To$SyntaxObject:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   273: aastore        
        //   274: dup            
        //   275: iconst_1       
        //   276: iconst_2       
        //   277: anewarray       Ljava/lang/Object;
        //   280: dup            
        //   281: iconst_0       
        //   282: aload_0         /* form */
        //   283: aload           values$Mnmethod
        //   285: invokestatic    kawa/lib/std_syntax.datum$To$SyntaxObject:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   288: aastore        
        //   289: dup            
        //   290: iconst_1       
        //   291: iconst_2       
        //   292: anewarray       Ljava/lang/Object;
        //   295: dup            
        //   296: iconst_0       
        //   297: getstatic       gnu/kawa/slib/enums.Lit23:Lkawa/lang/SyntaxTemplate;
        //   300: aload_2        
        //   301: aload           11
        //   303: invokevirtual   kawa/lang/SyntaxTemplate.execute:([Ljava/lang/Object;Lkawa/lang/TemplateScope;)Ljava/lang/Object;
        //   306: aastore        
        //   307: dup            
        //   308: iconst_1       
        //   309: iconst_2       
        //   310: anewarray       Ljava/lang/Object;
        //   313: dup            
        //   314: iconst_0       
        //   315: aload_0         /* form */
        //   316: aload_3         /* t$Mnname */
        //   317: invokestatic    kawa/lib/std_syntax.datum$To$SyntaxObject:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   320: aastore        
        //   321: dup            
        //   322: iconst_1       
        //   323: iconst_2       
        //   324: anewarray       Ljava/lang/Object;
        //   327: dup            
        //   328: iconst_0       
        //   329: getstatic       gnu/kawa/slib/enums.Lit24:Lkawa/lang/SyntaxTemplate;
        //   332: aload_2        
        //   333: aload           11
        //   335: invokevirtual   kawa/lang/SyntaxTemplate.execute:([Ljava/lang/Object;Lkawa/lang/TemplateScope;)Ljava/lang/Object;
        //   338: aastore        
        //   339: dup            
        //   340: iconst_1       
        //   341: iconst_2       
        //   342: anewarray       Ljava/lang/Object;
        //   345: dup            
        //   346: iconst_0       
        //   347: getstatic       gnu/kawa/slib/enums.Lit25:Lkawa/lang/SyntaxTemplate;
        //   350: aload_2        
        //   351: aload           11
        //   353: invokevirtual   kawa/lang/SyntaxTemplate.execute:([Ljava/lang/Object;Lkawa/lang/TemplateScope;)Ljava/lang/Object;
        //   356: aastore        
        //   357: dup            
        //   358: iconst_1       
        //   359: iconst_2       
        //   360: anewarray       Ljava/lang/Object;
        //   363: dup            
        //   364: iconst_0       
        //   365: aload_0         /* form */
        //   366: aload_3         /* t$Mnname */
        //   367: invokestatic    kawa/lib/std_syntax.datum$To$SyntaxObject:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   370: aastore        
        //   371: dup            
        //   372: iconst_1       
        //   373: getstatic       gnu/kawa/slib/enums.Lit26:Lkawa/lang/SyntaxTemplate;
        //   376: aload_2        
        //   377: aload           11
        //   379: invokevirtual   kawa/lang/SyntaxTemplate.execute:([Ljava/lang/Object;Lkawa/lang/TemplateScope;)Ljava/lang/Object;
        //   382: aastore        
        //   383: invokestatic    kawa/lang/Quote.consX$V:([Ljava/lang/Object;)Ljava/lang/Object;
        //   386: aastore        
        //   387: invokestatic    kawa/lang/Quote.append$V:([Ljava/lang/Object;)Ljava/lang/Object;
        //   390: getstatic       gnu/kawa/slib/enums.Lit27:Lkawa/lang/SyntaxTemplate;
        //   393: aload_2        
        //   394: aload           11
        //   396: invokevirtual   kawa/lang/SyntaxTemplate.execute:([Ljava/lang/Object;Lkawa/lang/TemplateScope;)Ljava/lang/Object;
        //   399: invokestatic    gnu/lists/Pair.make:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //   402: aastore        
        //   403: invokestatic    kawa/lang/Quote.append$V:([Ljava/lang/Object;)Ljava/lang/Object;
        //   406: aastore        
        //   407: invokestatic    kawa/lang/Quote.consX$V:([Ljava/lang/Object;)Ljava/lang/Object;
        //   410: aastore        
        //   411: invokestatic    kawa/lang/Quote.append$V:([Ljava/lang/Object;)Ljava/lang/Object;
        //   414: iconst_2       
        //   415: anewarray       Ljava/lang/Object;
        //   418: dup            
        //   419: iconst_0       
        //   420: aload_0         /* form */
        //   421: aload           field$Mndescs
        //   423: invokestatic    kawa/lib/std_syntax.datum$To$SyntaxObject:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   426: aastore        
        //   427: dup            
        //   428: iconst_1       
        //   429: iconst_2       
        //   430: anewarray       Ljava/lang/Object;
        //   433: dup            
        //   434: iconst_0       
        //   435: aload_0         /* form */
        //   436: aload           other$Mndefs
        //   438: invokestatic    kawa/lib/std_syntax.datum$To$SyntaxObject:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   441: aastore        
        //   442: dup            
        //   443: iconst_1       
        //   444: getstatic       gnu/kawa/slib/enums.Lit28:Lkawa/lang/SyntaxTemplate;
        //   447: aload_2        
        //   448: aload           11
        //   450: invokevirtual   kawa/lang/SyntaxTemplate.execute:([Ljava/lang/Object;Lkawa/lang/TemplateScope;)Ljava/lang/Object;
        //   453: aastore        
        //   454: invokestatic    kawa/lang/Quote.append$V:([Ljava/lang/Object;)Ljava/lang/Object;
        //   457: aastore        
        //   458: invokestatic    kawa/lang/Quote.append$V:([Ljava/lang/Object;)Ljava/lang/Object;
        //   461: invokestatic    gnu/lists/Pair.make:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //   464: aastore        
        //   465: invokestatic    kawa/lang/Quote.consX$V:([Ljava/lang/Object;)Ljava/lang/Object;
        //   468: aastore        
        //   469: invokestatic    kawa/lang/Quote.consX$V:([Ljava/lang/Object;)Ljava/lang/Object;
        //   472: aastore        
        //   473: invokestatic    kawa/lang/Quote.append$V:([Ljava/lang/Object;)Ljava/lang/Object;
        //   476: aastore        
        //   477: invokestatic    kawa/lang/Quote.append$V:([Ljava/lang/Object;)Ljava/lang/Object;
        //   480: aastore        
        //   481: invokestatic    kawa/lang/Quote.consX$V:([Ljava/lang/Object;)Ljava/lang/Object;
        //   484: aastore        
        //   485: invokestatic    kawa/lang/Quote.append$V:([Ljava/lang/Object;)Ljava/lang/Object;
        //   488: goto            497
        //   491: ldc             "syntax-case"
        //   493: aload_0         /* form */
        //   494: invokestatic    kawa/standard/syntax_case.error:(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
        //   497: areturn        
        //   498: new             Lgnu/mapping/WrongType;
        //   501: dup_x1         
        //   502: swap           
        //   503: ldc             "t-name"
        //   505: bipush          -2
        //   507: aload           5
        //   509: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   512: athrow         
        //   513: new             Lgnu/mapping/WrongType;
        //   516: dup_x1         
        //   517: swap           
        //   518: ldc             "e-names"
        //   520: bipush          -2
        //   522: aload           7
        //   524: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   527: athrow         
        //   528: new             Lgnu/mapping/WrongType;
        //   531: dup_x1         
        //   532: swap           
        //   533: ldc_w           "values-method"
        //   536: bipush          -2
        //   538: aload           9
        //   540: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   543: athrow         
        //   544: new             Lgnu/mapping/WrongType;
        //   547: dup_x1         
        //   548: swap           
        //   549: ldc_w           "opts"
        //   552: bipush          -2
        //   554: aload           11
        //   556: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   559: athrow         
        //   560: new             Lgnu/mapping/WrongType;
        //   563: dup_x1         
        //   564: swap           
        //   565: ldc_w           "other-defs"
        //   568: bipush          -2
        //   570: aload           12
        //   572: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   575: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  42     45     498    513    Ljava/lang/ClassCastException;
        //  92     95     513    528    Ljava/lang/ClassCastException;
        //  132    135    528    544    Ljava/lang/ClassCastException;
        //  159    162    544    560    Ljava/lang/ClassCastException;
        //  186    189    560    576    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 315 out of bounds for length 315
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
    public int match1(final ModuleMethod proc, final Object arg1, final CallContext ctx) {
        switch (proc.selector) {
            case 2: {
                ctx.value1 = arg1;
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
    public void apply(final CallContext callContext) {
        final int pc = callContext.pc;
        ModuleMethod.applyError();
    }
    
    @Override
    public Object apply1(final ModuleMethod method, final Object arg1) {
        switch (method.selector) {
            case 1: {
                return lambda1(arg1);
            }
            case 2: {
                return lambda2(arg1);
            }
            default: {
                return super.apply1(method, arg1);
            }
        }
    }
}
