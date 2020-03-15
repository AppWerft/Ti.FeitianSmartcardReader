// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.slib;

import gnu.expr.ModuleInfo;
import kawa.lang.SyntaxPattern;
import kawa.lang.SyntaxRule;
import gnu.kawa.functions.Apply;
import java.util.Iterator;
import gnu.kawa.functions.IsEq;
import gnu.mapping.WrongType;
import gnu.lists.Pair;
import gnu.lists.Sequences;
import gnu.mapping.Promise;
import gnu.expr.KawaConvert;
import kawa.standard.append;
import gnu.expr.Special;
import kawa.lib.exceptions;
import kawa.lib.lists;
import gnu.mapping.Procedure;
import kawa.standard.Scheme;
import gnu.lists.Consumer;
import gnu.mapping.Symbol;
import gnu.lists.LList;
import gnu.mapping.CallContext;
import kawa.lang.SyntaxRules;
import gnu.lists.PairWithPosition;
import gnu.mapping.SimpleSymbol;
import kawa.lang.Macro;
import gnu.expr.ModuleMethod;
import gnu.expr.ModuleBody;

public class conditions extends ModuleBody
{
    public static final ModuleMethod make$Mncondition$Mntype;
    public static final ModuleMethod condition$Mntype$Qu;
    public static final ModuleMethod make$Mncondition;
    public static final ModuleMethod condition$Qu;
    public static final ModuleMethod condition$Mnhas$Mntype$Qu;
    public static final ModuleMethod condition$Mnref;
    public static final ModuleMethod message$Mncondition$Qu;
    public static final ModuleMethod serious$Mncondition$Qu;
    public static final ModuleMethod error$Qu;
    public static final ModuleMethod condition$Mnmessage;
    public static final ModuleMethod condition$Mntype$Mnfield$Mnsupertype;
    public static final ModuleMethod check$Mncondition$Mntype$Mnfield$Mnalist;
    public static final ModuleMethod make$Mncompound$Mncondition;
    public static final ModuleMethod extract$Mncondition;
    public static final Macro define$Mncondition$Mntype;
    public static final Macro condition;
    public static condition-type $Amcondition;
    public static condition-type $Ammessage;
    public static condition-type $Amserious;
    public static condition-type $Amerror;
    public static final int $Pcprovide$Pcsrfi$Mn35 = 123;
    public static final int $Pcprovide$Pccondition = 123;
    public static final int $Pcprovide$Pcconditions = 123;
    static final Class $Lscondition$Mntype$Gr;
    public static final Class $Prvt$$Lscondition$Gr;
    static final Macro condition$Mntype$Mnfield$Mnalist;
    public static final ModuleMethod $Prvt$type$Mnfield$Mnalist$Mn$Grcondition;
    static final SimpleSymbol Lit0;
    static final SimpleSymbol Lit1;
    static final PairWithPosition Lit2;
    static final SimpleSymbol Lit3;
    static final SimpleSymbol Lit4;
    static final SimpleSymbol Lit5;
    public static conditions $instance;
    static final SimpleSymbol Lit6;
    static final SimpleSymbol Lit7;
    static final SimpleSymbol Lit8;
    static final SyntaxRules Lit9;
    static final SimpleSymbol Lit10;
    static final SimpleSymbol Lit11;
    static final SimpleSymbol Lit12;
    static final SimpleSymbol Lit13;
    static final SimpleSymbol Lit14;
    static final SyntaxRules Lit15;
    static final SimpleSymbol Lit16;
    static final SimpleSymbol Lit17;
    static final SimpleSymbol Lit18;
    static final SimpleSymbol Lit19;
    static final SyntaxRules Lit20;
    static final SimpleSymbol Lit21;
    static final SimpleSymbol Lit22;
    static final SimpleSymbol Lit23;
    static final SimpleSymbol Lit24;
    static final SimpleSymbol Lit25;
    static final SimpleSymbol Lit26;
    static final Object[] Lit27;
    static final SimpleSymbol Lit28;
    static final PairWithPosition Lit29;
    static final SimpleSymbol Lit30;
    
    private static void $runBody$() {
        final CallContext $ctx;
        final Consumer $result = ($ctx = CallContext.getInstance()).consumer;
        conditions.$Amcondition = new condition-type(conditions.Lit0, Boolean.FALSE, LList.Empty, LList.Empty);
        conditions.$Ammessage = makeConditionType(conditions.Lit1, conditions.$Amcondition, conditions.Lit2);
        conditions.$Amserious = makeConditionType(conditions.Lit4, conditions.$Amcondition, LList.Empty);
        conditions.$Amerror = makeConditionType(conditions.Lit5, conditions.$Amserious, LList.Empty);
    }
    
    public static boolean isConditionType(final Object obj) {
        return obj instanceof condition-type;
    }
    
    public static condition-type makeConditionType(final Symbol name, final condition-type supertype, final Object fields) {
        if (!lists.isNull(srfi1.lsetIntersection$V(Scheme.isEq, supertype.all$Mnfields, new Object[] { fields }))) {
            exceptions.error("duplicate field name");
            throw Special.reachedUnexpected;
        }
        return new condition-type(name, supertype, fields, append.append$V(new Object[] { supertype.all$Mnfields, fields }));
    }
    
    public static Object conditionTypeFieldSupertype(final condition-type condition$Mntype, final Object field) {
        condition-type condition-type = condition$Mntype;
        Object false;
        while (true) {
            final condition-type condition$Mntype2 = condition-type;
            if (condition$Mntype2 == null) {
                false = Boolean.FALSE;
                break;
            }
            if (KawaConvert.isTrue(lists.memq(field, condition$Mntype2.fields))) {
                false = condition$Mntype2;
                break;
            }
            condition-type = (condition-type)Promise.force(condition$Mntype2.supertype, condition-type.class);
        }
        return false;
    }
    
    public static boolean isCondition(final Object obj) {
        return obj instanceof condition;
    }
    
    public static condition makeCondition$V(final condition-type type, final Object[] argsArray) {
        final LList field$Mnplist = LList.makeList(argsArray, 0);
        final Object alist = lambda1label(field$Mnplist);
        final IsEq isEq = Scheme.isEq;
        final Object[] argsArray2 = { type.all$Mnfields, null };
        final int n = 1;
        final Iterator iterator = Sequences.getIterator(alist);
        LList empty = LList.Empty;
        Pair pair = null;
    Block_5_Outer:
        while (true) {
            Label_0111: {
                if (!iterator.hasNext()) {
                    break Label_0111;
                }
                final Object force = Promise.force(iterator.next(), Pair.class);
                try {
                    final Pair cdr = new Pair(lists.car((Pair)force), LList.Empty);
                    if (pair == null) {
                        empty = cdr;
                    }
                    else {
                        pair.setCdr(cdr);
                    }
                    pair = cdr;
                    continue Block_5_Outer;
                    Label_0139: {
                        return new condition(LList.list1(lists.cons(type, alist)));
                    }
                    while (true) {
                        exceptions.error("condition fields don't match condition type");
                        throw Special.reachedUnexpected;
                        argsArray2[n] = empty;
                        continue;
                    }
                }
                // iftrue(Label_0139:, KawaConvert.isTrue(srfi1.lset$Eq$V((Procedure)isEq, argsArray2)))
                catch (ClassCastException ex) {
                    throw new WrongType(ex, "car", 1, force);
                }
            }
        }
    }
    
    public static Object lambda1label(final Object plist) {
        if (lists.isNull(plist)) {
            return LList.Empty;
        }
        final Object force = Promise.force(plist, Pair.class);
        try {
            return lists.cons(lists.cons(lists.car((Pair)force), lists.cadr(plist)), lambda1label(lists.cddr(plist)));
        }
        catch (ClassCastException ex) {
            throw new WrongType(ex, "car", 1, force);
        }
    }
    
    public static boolean isConditionHasType(final Object condition, final condition-type type) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokestatic    gnu/kawa/slib/conditions.conditionTypes:(Ljava/lang/Object;)Lgnu/lists/LList;
        //     4: astore_2        /* types */
        //     5: aload_2         /* types */
        //     6: ldc             Lgnu/lists/Pair;.class
        //     8: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    11: dup            
        //    12: astore          4
        //    14: checkcast       Lgnu/lists/Pair;
        //    17: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    20: ldc             Lgnu/kawa/slib/condition-type;.class
        //    22: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    25: dup            
        //    26: astore          4
        //    28: checkcast       Lgnu/kawa/slib/condition-type;
        //    31: aload_1         /* type */
        //    32: invokestatic    gnu/kawa/slib/conditions.isConditionSubtype:(Lgnu/kawa/slib/condition-type;Lgnu/kawa/slib/condition-type;)Z
        //    35: istore_3        /* x */
        //    36: iload_3         /* x */
        //    37: ifeq            44
        //    40: iload_3         /* x */
        //    41: goto            62
        //    44: aload_2         /* types */
        //    45: ldc             Lgnu/lists/Pair;.class
        //    47: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    50: dup            
        //    51: astore          4
        //    53: checkcast       Lgnu/lists/Pair;
        //    56: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    59: goto            4
        //    62: ireturn        
        //    63: new             Lgnu/mapping/WrongType;
        //    66: dup_x1         
        //    67: swap           
        //    68: ldc             "car"
        //    70: iconst_1       
        //    71: aload           4
        //    73: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //    76: athrow         
        //    77: new             Lgnu/mapping/WrongType;
        //    80: dup_x1         
        //    81: swap           
        //    82: ldc             "condition-subtype?"
        //    84: iconst_0       
        //    85: aload           4
        //    87: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //    90: athrow         
        //    91: new             Lgnu/mapping/WrongType;
        //    94: dup_x1         
        //    95: swap           
        //    96: ldc             "cdr"
        //    98: iconst_1       
        //    99: aload           4
        //   101: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   104: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  14     17     63     77     Ljava/lang/ClassCastException;
        //  28     31     77     91     Ljava/lang/ClassCastException;
        //  53     56     91     105    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 55 out of bounds for length 55
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
    
    static LList conditionTypes(final Object condition) {
        final Iterator iterator = Sequences.getIterator(((condition)Promise.force(condition, condition.class)).type$Mnfield$Mnalist);
        LList empty = LList.Empty;
        Pair pair = null;
        while (true) {
            if (!iterator.hasNext()) {
                return empty;
            }
            final Object force = Promise.force(iterator.next(), Pair.class);
            try {
                final Pair cdr = new Pair(lists.car((Pair)force), LList.Empty);
                if (pair == null) {
                    empty = cdr;
                }
                else {
                    pair.setCdr(cdr);
                }
                pair = cdr;
                continue;
            }
            catch (ClassCastException ex) {
                throw new WrongType(ex, "car", 1, force);
            }
        }
    }
    
    static boolean isConditionSubtype(final condition-type subtype, final condition-type supertype) {
        condition-type condition-type = subtype;
        boolean b;
        while (true) {
            final condition-type subtype2 = condition-type;
            if (subtype2 == null) {
                b = false;
                break;
            }
            if (subtype2 == supertype) {
                b = true;
                break;
            }
            condition-type = (condition-type)Promise.force(subtype2.supertype, condition-type.class);
        }
        return b;
    }
    
    public static Object conditionRef(final condition condition, final Object field) {
        return typeFieldAlistRef(condition.type$Mnfield$Mnalist, field);
    }
    
    static Object typeFieldAlistRef(final Object type$Mnfield$Mnalist, final Object field) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: astore_2        /* type$Mnfield$Mnalist */
        //     2: aload_2         /* type$Mnfield$Mnalist */
        //     3: invokestatic    kawa/lib/lists.isNull:(Ljava/lang/Object;)Z
        //     6: ifeq            34
        //     9: iconst_3       
        //    10: anewarray       Ljava/lang/Object;
        //    13: dup            
        //    14: iconst_0       
        //    15: ldc_w           "type-field-alist-ref: field not found"
        //    18: aastore        
        //    19: dup            
        //    20: iconst_1       
        //    21: aload_2         /* type$Mnfield$Mnalist */
        //    22: aastore        
        //    23: dup            
        //    24: iconst_2       
        //    25: aload_1         /* field */
        //    26: aastore        
        //    27: invokestatic    kawa/lib/exceptions.error:([Ljava/lang/Object;)Lgnu/bytecode/Type$NeverReturns;
        //    30: getstatic       gnu/expr/Special.reachedUnexpected:Ljava/lang/RuntimeException;
        //    33: athrow         
        //    34: aload_1         /* field */
        //    35: aload_2         /* type$Mnfield$Mnalist */
        //    36: ldc             Lgnu/lists/Pair;.class
        //    38: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    41: dup            
        //    42: astore          4
        //    44: checkcast       Lgnu/lists/Pair;
        //    47: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    50: ldc             Lgnu/lists/Pair;.class
        //    52: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    55: dup            
        //    56: astore          4
        //    58: checkcast       Lgnu/lists/Pair;
        //    61: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    64: invokestatic    kawa/lib/lists.assq:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    67: astore_3        /* temp */
        //    68: aload_3         /* temp */
        //    69: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //    72: ifeq            93
        //    75: aload_3         /* temp */
        //    76: ldc             Lgnu/lists/Pair;.class
        //    78: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    81: dup            
        //    82: astore          4
        //    84: checkcast       Lgnu/lists/Pair;
        //    87: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    90: goto            111
        //    93: aload_2         /* type$Mnfield$Mnalist */
        //    94: ldc             Lgnu/lists/Pair;.class
        //    96: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    99: dup            
        //   100: astore          4
        //   102: checkcast       Lgnu/lists/Pair;
        //   105: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   108: goto            1
        //   111: areturn        
        //   112: new             Lgnu/mapping/WrongType;
        //   115: dup_x1         
        //   116: swap           
        //   117: ldc             "car"
        //   119: iconst_1       
        //   120: aload           4
        //   122: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   125: athrow         
        //   126: new             Lgnu/mapping/WrongType;
        //   129: dup_x1         
        //   130: swap           
        //   131: ldc             "cdr"
        //   133: iconst_1       
        //   134: aload           4
        //   136: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   139: athrow         
        //   140: new             Lgnu/mapping/WrongType;
        //   143: dup_x1         
        //   144: swap           
        //   145: ldc             "cdr"
        //   147: iconst_1       
        //   148: aload           4
        //   150: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   153: athrow         
        //   154: new             Lgnu/mapping/WrongType;
        //   157: dup_x1         
        //   158: swap           
        //   159: ldc             "cdr"
        //   161: iconst_1       
        //   162: aload           4
        //   164: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   167: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  44     47     112    126    Ljava/lang/ClassCastException;
        //  58     61     126    140    Ljava/lang/ClassCastException;
        //  84     87     140    154    Ljava/lang/ClassCastException;
        //  102    105    154    168    Ljava/lang/ClassCastException;
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
    
    public static condition makeCompoundCondition$V(final Object condition$Mn1, final Object[] argsArray) {
        final LList conditions = LList.makeList(argsArray, 0);
        final Apply apply = Scheme.apply;
        final append append = kawa.standard.append.append;
        final Iterator iterator = Sequences.getIterator(lists.cons(condition$Mn1, conditions));
        LList empty = LList.Empty;
        Pair pair = null;
        while (iterator.hasNext()) {
            final Pair cdr = new Pair(Scheme.applyToArgs.apply2(gnu.kawa.slib.conditions.condition$Mntype$Mnfield$Mnalist, iterator.next()), LList.Empty);
            if (pair == null) {
                empty = cdr;
            }
            else {
                pair.setCdr(cdr);
            }
            pair = cdr;
        }
        return new condition(apply.apply2(append, empty));
    }
    
    public static condition extractCondition(final condition condition, final condition-type type) {
        public class conditions$frame extends ModuleBody
        {
            condition-type type;
            final ModuleMethod lambda$Fn1;
            
            public conditions$frame() {
                final ModuleMethod lambda$Fn1 = new ModuleMethod(this, 1, null, 4097);
                lambda$Fn1.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/conditions.scm:169");
                this.lambda$Fn1 = lambda$Fn1;
            }
            
            boolean lambda2(final Object entry) {
                Object o2;
                final Object o = o2 = Promise.force(entry, Pair.class);
                Object o3;
                try {
                    o3 = (o2 = Promise.force(lists.car((Pair)o), condition-type.class));
                    final condition-type condition-type = (condition-type)o3;
                    final conditions$frame conditions$frame = this;
                    final condition-type condition-type2 = conditions$frame.type;
                    return conditions.isConditionSubtype(condition-type, condition-type2);
                }
                catch (ClassCastException ex) {
                    throw new WrongType(ex, "car", 1, o2);
                }
                try {
                    final condition-type condition-type = (condition-type)o3;
                    final conditions$frame conditions$frame = this;
                    final condition-type condition-type2 = conditions$frame.type;
                    return conditions.isConditionSubtype(condition-type, condition-type2);
                }
                catch (ClassCastException ex2) {
                    throw new WrongType(ex2, "condition-subtype?", 0, o2);
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
                    return this.lambda2(o) ? Boolean.TRUE : Boolean.FALSE;
                }
                return super.apply1(method, o);
            }
        }
        final conditions$frame $heapFrame = new conditions$frame();
        $heapFrame.type = type;
        final Object entry = srfi1.find($heapFrame.lambda$Fn1, condition.type$Mnfield$Mnalist);
        if (!KawaConvert.isTrue(entry)) {
            exceptions.error("extract-condition: invalid condition type", condition, $heapFrame.type);
            throw Special.reachedUnexpected;
        }
        final condition-type type2 = $heapFrame.type;
        final Iterator iterator = Sequences.getIterator($heapFrame.type.all$Mnfields);
        LList empty = LList.Empty;
        Pair pair = null;
        while (true) {
            Label_0155: {
                if (!iterator.hasNext()) {
                    break Label_0155;
                }
                final Object next = iterator.next();
                final Object force = Promise.force(entry, Pair.class);
                try {
                    final Pair cdr = new Pair(lists.assq(next, lists.cdr((Pair)force)), LList.Empty);
                    if (pair == null) {
                        empty = cdr;
                    }
                    else {
                        pair.setCdr(cdr);
                    }
                    pair = cdr;
                    continue;
                    return new condition(LList.list1(lists.cons(type2, empty)));
                }
                catch (ClassCastException ex) {
                    throw new WrongType(ex, "cdr", 1, force);
                }
            }
        }
    }
    
    public static condition typeFieldAlist$To$Condition(final Object type$Mnfield$Mnalist) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokestatic    gnu/lists/Sequences.getIterator:(Ljava/lang/Object;)Ljava/util/Iterator;
        //     4: astore_2       
        //     5: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
        //     8: astore_3       
        //     9: aconst_null    
        //    10: astore          4
        //    12: aload_2        
        //    13: invokeinterface java/util/Iterator.hasNext:()Z
        //    18: ifeq            225
        //    21: aload_2        
        //    22: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //    27: astore          5
        //    29: aload           5
        //    31: ldc             Lgnu/lists/Pair;.class
        //    33: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    36: dup            
        //    37: astore          8
        //    39: checkcast       Lgnu/lists/Pair;
        //    42: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    45: aload           5
        //    47: ldc             Lgnu/lists/Pair;.class
        //    49: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    52: dup            
        //    53: astore          9
        //    55: checkcast       Lgnu/lists/Pair;
        //    58: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    61: ldc             Lgnu/kawa/slib/condition-type;.class
        //    63: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    66: checkcast       Lgnu/kawa/slib/condition-type;
        //    69: getfield        gnu/kawa/slib/condition-type.all$Mnfields:Ljava/lang/Object;
        //    72: invokestatic    gnu/lists/Sequences.getIterator:(Ljava/lang/Object;)Ljava/util/Iterator;
        //    75: astore          8
        //    77: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
        //    80: astore          9
        //    82: aconst_null    
        //    83: astore          10
        //    85: aload           8
        //    87: invokeinterface java/util/Iterator.hasNext:()Z
        //    92: ifeq            184
        //    95: aload           8
        //    97: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //   102: astore          11
        //   104: new             Lgnu/lists/Pair;
        //   107: dup            
        //   108: aload           11
        //   110: aload           5
        //   112: ldc             Lgnu/lists/Pair;.class
        //   114: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   117: dup            
        //   118: astore          14
        //   120: checkcast       Lgnu/lists/Pair;
        //   123: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   126: invokestatic    kawa/lib/lists.assq:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   129: astore          x
        //   131: aload           x
        //   133: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //   136: ifeq            144
        //   139: aload           x
        //   141: goto            155
        //   144: aload           11
        //   146: aload_0         /* type$Mnfield$Mnalist */
        //   147: aload           11
        //   149: invokestatic    gnu/kawa/slib/conditions.typeFieldAlistRef:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   152: invokestatic    kawa/lib/lists.cons:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //   155: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
        //   158: invokespecial   gnu/lists/Pair.<init>:(Ljava/lang/Object;Ljava/lang/Object;)V
        //   161: aload           10
        //   163: ifnonnull       172
        //   166: dup            
        //   167: astore          9
        //   169: goto            179
        //   172: aload           10
        //   174: swap           
        //   175: dup_x1         
        //   176: invokevirtual   gnu/lists/Pair.setCdr:(Ljava/lang/Object;)V
        //   179: astore          10
        //   181: goto            85
        //   184: aload           9
        //   186: invokestatic    kawa/lib/lists.cons:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //   189: astore          7
        //   191: new             Lgnu/lists/Pair;
        //   194: dup            
        //   195: aload           7
        //   197: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
        //   200: invokespecial   gnu/lists/Pair.<init>:(Ljava/lang/Object;Ljava/lang/Object;)V
        //   203: aload           4
        //   205: ifnonnull       213
        //   208: dup            
        //   209: astore_3       
        //   210: goto            220
        //   213: aload           4
        //   215: swap           
        //   216: dup_x1         
        //   217: invokevirtual   gnu/lists/Pair.setCdr:(Ljava/lang/Object;)V
        //   220: astore          4
        //   222: goto            12
        //   225: aload_3        
        //   226: astore_1       
        //   227: new             Lgnu/kawa/slib/condition;
        //   230: dup            
        //   231: aload_1        
        //   232: invokespecial   gnu/kawa/slib/condition.<init>:(Ljava/lang/Object;)V
        //   235: areturn        
        //   236: new             Lgnu/mapping/WrongType;
        //   239: dup_x1         
        //   240: swap           
        //   241: ldc             "car"
        //   243: iconst_1       
        //   244: aload           8
        //   246: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   249: athrow         
        //   250: new             Lgnu/mapping/WrongType;
        //   253: dup_x1         
        //   254: swap           
        //   255: ldc             "car"
        //   257: iconst_1       
        //   258: aload           9
        //   260: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   263: athrow         
        //   264: new             Lgnu/mapping/WrongType;
        //   267: dup_x1         
        //   268: swap           
        //   269: ldc             "cdr"
        //   271: iconst_1       
        //   272: aload           14
        //   274: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   277: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  39     42     236    250    Ljava/lang/ClassCastException;
        //  55     58     250    264    Ljava/lang/ClassCastException;
        //  120    123    264    278    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 128 out of bounds for length 128
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
    
    public static Object checkConditionTypeFieldAlist(final Object the$Mntype$Mnfield$Mnalist) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: astore_1        /* type$Mnfield$Mnalist */
        //     2: aload_1         /* type$Mnfield$Mnalist */
        //     3: invokestatic    kawa/lib/lists.isNull:(Ljava/lang/Object;)Z
        //     6: ifne            347
        //     9: aload_1         /* type$Mnfield$Mnalist */
        //    10: ldc             Lgnu/lists/Pair;.class
        //    12: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    15: dup            
        //    16: astore_3       
        //    17: checkcast       Lgnu/lists/Pair;
        //    20: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    23: astore_2        /* entry */
        //    24: aload_2         /* entry */
        //    25: ldc             Lgnu/lists/Pair;.class
        //    27: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    30: dup            
        //    31: astore          4
        //    33: checkcast       Lgnu/lists/Pair;
        //    36: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    39: ldc             Lgnu/kawa/slib/condition-type;.class
        //    41: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    44: dup            
        //    45: astore          4
        //    47: checkcast       Lgnu/kawa/slib/condition-type;
        //    50: astore_3        /* type */
        //    51: aload_2         /* entry */
        //    52: ldc             Lgnu/lists/Pair;.class
        //    54: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    57: dup            
        //    58: astore          5
        //    60: checkcast       Lgnu/lists/Pair;
        //    63: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    66: astore          field$Mnalist
        //    68: aload           field$Mnalist
        //    70: invokestatic    gnu/lists/Sequences.getIterator:(Ljava/lang/Object;)Ljava/util/Iterator;
        //    73: astore          6
        //    75: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
        //    78: astore          7
        //    80: aconst_null    
        //    81: astore          8
        //    83: aload           6
        //    85: invokeinterface java/util/Iterator.hasNext:()Z
        //    90: ifeq            151
        //    93: aload           6
        //    95: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //   100: astore          9
        //   102: new             Lgnu/lists/Pair;
        //   105: dup            
        //   106: aload           9
        //   108: ldc             Lgnu/lists/Pair;.class
        //   110: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   113: dup            
        //   114: astore          11
        //   116: checkcast       Lgnu/lists/Pair;
        //   119: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   122: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
        //   125: invokespecial   gnu/lists/Pair.<init>:(Ljava/lang/Object;Ljava/lang/Object;)V
        //   128: aload           8
        //   130: ifnonnull       139
        //   133: dup            
        //   134: astore          7
        //   136: goto            146
        //   139: aload           8
        //   141: swap           
        //   142: dup_x1         
        //   143: invokevirtual   gnu/lists/Pair.setCdr:(Ljava/lang/Object;)V
        //   146: astore          8
        //   148: goto            83
        //   151: aload           7
        //   153: astore          fields
        //   155: aload_3         /* type */
        //   156: getfield        gnu/kawa/slib/condition-type.all$Mnfields:Ljava/lang/Object;
        //   159: astore          all$Mnfields
        //   161: getstatic       kawa/standard/Scheme.isEq:Lgnu/kawa/functions/IsEq;
        //   164: aload           all$Mnfields
        //   166: iconst_1       
        //   167: anewarray       Ljava/lang/Object;
        //   170: dup            
        //   171: iconst_0       
        //   172: aload           fields
        //   174: aastore        
        //   175: invokestatic    gnu/kawa/slib/srfi1.lsetDifference$V:(Lgnu/mapping/Procedure;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
        //   178: invokestatic    gnu/lists/Sequences.getIterator:(Ljava/lang/Object;)Ljava/util/Iterator;
        //   181: astore          7
        //   183: aload           7
        //   185: invokeinterface java/util/Iterator.hasNext:()Z
        //   190: ifeq            329
        //   193: aload           7
        //   195: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //   200: astore          8
        //   202: aload_3         /* type */
        //   203: aload           8
        //   205: invokestatic    gnu/kawa/slib/conditions.conditionTypeFieldSupertype:(Lgnu/kawa/slib/condition-type;Ljava/lang/Object;)Ljava/lang/Object;
        //   208: astore          supertype
        //   210: aload_0         /* the$Mntype$Mnfield$Mnalist */
        //   211: astore          alist
        //   213: aload           alist
        //   215: ldc             Lgnu/lists/Pair;.class
        //   217: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   220: dup            
        //   221: astore          12
        //   223: checkcast       Lgnu/lists/Pair;
        //   226: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   229: ldc             Lgnu/lists/Pair;.class
        //   231: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   234: dup            
        //   235: astore          12
        //   237: checkcast       Lgnu/lists/Pair;
        //   240: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   243: ldc             Lgnu/kawa/slib/condition-type;.class
        //   245: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   248: dup            
        //   249: astore          12
        //   251: checkcast       Lgnu/kawa/slib/condition-type;
        //   254: aload           supertype
        //   256: ldc             Lgnu/kawa/slib/condition-type;.class
        //   258: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   261: dup            
        //   262: astore          12
        //   264: checkcast       Lgnu/kawa/slib/condition-type;
        //   267: invokestatic    gnu/kawa/slib/conditions.isConditionSubtype:(Lgnu/kawa/slib/condition-type;Lgnu/kawa/slib/condition-type;)Z
        //   270: istore          x
        //   272: iload           x
        //   274: ifeq            285
        //   277: iload           x
        //   279: ifne            183
        //   282: goto            304
        //   285: aload           alist
        //   287: ldc             Lgnu/lists/Pair;.class
        //   289: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   292: dup            
        //   293: astore          12
        //   295: checkcast       Lgnu/lists/Pair;
        //   298: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   301: goto            211
        //   304: iconst_3       
        //   305: anewarray       Ljava/lang/Object;
        //   308: dup            
        //   309: iconst_0       
        //   310: ldc             "missing field in condition construction"
        //   312: aastore        
        //   313: dup            
        //   314: iconst_1       
        //   315: aload_3         /* type */
        //   316: aastore        
        //   317: dup            
        //   318: iconst_2       
        //   319: aload           8
        //   321: aastore        
        //   322: invokestatic    kawa/lib/exceptions.error:([Ljava/lang/Object;)Lgnu/bytecode/Type$NeverReturns;
        //   325: getstatic       gnu/expr/Special.reachedUnexpected:Ljava/lang/RuntimeException;
        //   328: athrow         
        //   329: aload_1         /* type$Mnfield$Mnalist */
        //   330: ldc             Lgnu/lists/Pair;.class
        //   332: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   335: dup            
        //   336: astore          7
        //   338: checkcast       Lgnu/lists/Pair;
        //   341: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   344: goto            1
        //   347: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //   350: areturn        
        //   351: new             Lgnu/mapping/WrongType;
        //   354: dup_x1         
        //   355: swap           
        //   356: ldc             "car"
        //   358: iconst_1       
        //   359: aload_3        
        //   360: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   363: athrow         
        //   364: new             Lgnu/mapping/WrongType;
        //   367: dup_x1         
        //   368: swap           
        //   369: ldc             "car"
        //   371: iconst_1       
        //   372: aload           4
        //   374: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   377: athrow         
        //   378: new             Lgnu/mapping/WrongType;
        //   381: dup_x1         
        //   382: swap           
        //   383: ldc             "type"
        //   385: bipush          -2
        //   387: aload           4
        //   389: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   392: athrow         
        //   393: new             Lgnu/mapping/WrongType;
        //   396: dup_x1         
        //   397: swap           
        //   398: ldc             "cdr"
        //   400: iconst_1       
        //   401: aload           5
        //   403: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   406: athrow         
        //   407: new             Lgnu/mapping/WrongType;
        //   410: dup_x1         
        //   411: swap           
        //   412: ldc             "car"
        //   414: iconst_1       
        //   415: aload           11
        //   417: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   420: athrow         
        //   421: new             Lgnu/mapping/WrongType;
        //   424: dup_x1         
        //   425: swap           
        //   426: ldc             "car"
        //   428: iconst_1       
        //   429: aload           12
        //   431: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   434: athrow         
        //   435: new             Lgnu/mapping/WrongType;
        //   438: dup_x1         
        //   439: swap           
        //   440: ldc             "car"
        //   442: iconst_1       
        //   443: aload           12
        //   445: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   448: athrow         
        //   449: new             Lgnu/mapping/WrongType;
        //   452: dup_x1         
        //   453: swap           
        //   454: ldc             "condition-subtype?"
        //   456: iconst_0       
        //   457: aload           12
        //   459: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   462: athrow         
        //   463: new             Lgnu/mapping/WrongType;
        //   466: dup_x1         
        //   467: swap           
        //   468: ldc             "condition-subtype?"
        //   470: iconst_1       
        //   471: aload           12
        //   473: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   476: athrow         
        //   477: new             Lgnu/mapping/WrongType;
        //   480: dup_x1         
        //   481: swap           
        //   482: ldc             "cdr"
        //   484: iconst_1       
        //   485: aload           12
        //   487: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   490: athrow         
        //   491: new             Lgnu/mapping/WrongType;
        //   494: dup_x1         
        //   495: swap           
        //   496: ldc             "cdr"
        //   498: iconst_1       
        //   499: aload           7
        //   501: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   504: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  17     20     351    364    Ljava/lang/ClassCastException;
        //  33     36     364    378    Ljava/lang/ClassCastException;
        //  47     50     378    393    Ljava/lang/ClassCastException;
        //  60     63     393    407    Ljava/lang/ClassCastException;
        //  116    119    407    421    Ljava/lang/ClassCastException;
        //  223    226    421    435    Ljava/lang/ClassCastException;
        //  237    240    435    449    Ljava/lang/ClassCastException;
        //  251    254    449    463    Ljava/lang/ClassCastException;
        //  264    267    463    477    Ljava/lang/ClassCastException;
        //  295    298    477    491    Ljava/lang/ClassCastException;
        //  338    341    491    505    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 251 out of bounds for length 251
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
    
    public static boolean isMessageCondition(final Object thing) {
        return isCondition(thing) && isConditionHasType(thing, conditions.$Ammessage);
    }
    
    public static Object conditionMessage(final Object condition) {
        final Object force = Promise.force(condition, condition.class);
        try {
            return conditionRef(extractCondition((condition)force, conditions.$Ammessage), conditions.Lit3);
        }
        catch (ClassCastException ex) {
            throw new WrongType(ex, "extract-condition", 0, force);
        }
    }
    
    public static boolean isSeriousCondition(final Object thing) {
        return isCondition(thing) && isConditionHasType(thing, conditions.$Amserious);
    }
    
    public static boolean isError(final Object thing) {
        return isCondition(thing) && isConditionHasType(thing, conditions.$Amerror);
    }
    
    static {
        Lit30 = Symbol.valueOf("thing");
        Lit29 = PairWithPosition.make(conditions.Lit30, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/conditions.scm", 339996);
        Lit28 = Symbol.valueOf("quote");
        Lit27 = new Object[0];
        Lit26 = Symbol.valueOf("error?");
        Lit25 = Symbol.valueOf("serious-condition?");
        Lit24 = Symbol.valueOf("condition-message");
        Lit23 = Symbol.valueOf("message-condition?");
        Lit22 = Symbol.valueOf("check-condition-type-field-alist");
        Lit21 = Symbol.valueOf("type-field-alist->condition");
        Lit20 = new SyntaxRules(conditions.Lit27, new SyntaxRule[] { new SyntaxRule(new SyntaxPattern("\f\u0018]\f\u0007-\f\u000f\f\u0017\b\b\u0010\b\u0000\u0018\b", conditions.Lit27, 3, "conditions.scm:183"), "\u0003\u0005\u0005", "\u0011\u0018\u0004\b\u0011\u0018\f\b\u0005\u0011\u0018\u0014\t\u0003\b\u0011\u0018\f\b\r\u0011\u0018\u0014)\u0011\u0018\u001c\b\u000b\b\u0013", new Object[] { conditions.Lit21, Symbol.valueOf("list"), Symbol.valueOf("cons"), conditions.Lit28 }, 2) }, 3, Lit19 = Symbol.valueOf("condition"));
        Lit18 = Symbol.valueOf("extract-condition");
        Lit17 = Symbol.valueOf("make-compound-condition");
        Lit16 = Symbol.valueOf("condition-ref");
        Lit15 = new SyntaxRules(conditions.Lit27, new SyntaxRule[] { new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\b", conditions.Lit27, 1, "conditions.scm:144"), "\u0001", "\u0011\u0018\u0004\b\u0011\u0018\f\u0011\u0018\u0014\b\u0003", new Object[] { PairWithPosition.make(Symbol.valueOf("$lookup$"), Pair.make(Symbol.valueOf("*"), Pair.make(Pair.make(Symbol.valueOf("quasiquote"), Pair.make(Symbol.valueOf(".type-field-alist"), LList.Empty)), LList.Empty)), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/conditions.scm", 593927), Symbol.valueOf("as"), Symbol.valueOf("<condition>") }, 0) }, 1, Lit14 = Symbol.valueOf("condition-type-field-alist"));
        Lit13 = Symbol.valueOf("condition-has-type?");
        Lit12 = Symbol.valueOf("make-condition");
        Lit11 = Symbol.valueOf("condition?");
        Lit10 = Symbol.valueOf("condition-type-field-supertype");
        Lit9 = new SyntaxRules(conditions.Lit27, new SyntaxRule[] { new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\f\u000f\f\u0017-\f\u001f\f'\b\u0018\u0010\b", conditions.Lit27, 5, "conditions.scm:76"), "\u0001\u0001\u0001\u0003\u0003", "\u0011\u0018\u0004\u00c9\u0011\u0018\f\t\u0003\b\u0011\u0018\u0014)\u0011\u0018\u001c\b\u0003\t\u000b\b\u0011\u0018\u001c\b\b\u001d\u001b\u00c1\u0011\u0018\f!\t\u0013\u0018$\b\u0011\u0018,\u0011\u00184\b\u0011\u0018<\u0011\u0018D\b\u0003\b%\u0011\u0018\f!\t#\u0018L\b\u0011\u0018TA\u0011\u0018\\\u0011\u0018d\b\u0003\b\u0011\u0018\u001c\b\u001b", new Object[] { Symbol.valueOf("begin"), Symbol.valueOf("define"), Lit7 = Symbol.valueOf("make-condition-type"), conditions.Lit28, conditions.Lit29, Symbol.valueOf("and"), PairWithPosition.make(conditions.Lit11, conditions.Lit29, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/conditions.scm", 344079), conditions.Lit13, conditions.Lit30, PairWithPosition.make(conditions.Lit19, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/conditions.scm", 352284), conditions.Lit16, conditions.Lit18, conditions.Lit19 }, 1) }, 5, Lit8 = Symbol.valueOf("define-condition-type"));
        Lit6 = Symbol.valueOf("condition-type?");
        Lit5 = Symbol.valueOf("&error");
        Lit4 = Symbol.valueOf("&serious");
        Lit3 = Symbol.valueOf("message");
        Lit2 = PairWithPosition.make(conditions.Lit3, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/conditions.scm", 937987);
        Lit1 = Symbol.valueOf("&message");
        Lit0 = Symbol.valueOf("&condition");
        conditions.$instance = new conditions();
        $Lscondition$Mntype$Gr = condition-type.class;
        final conditions $instance = conditions.$instance;
        condition$Mntype$Qu = new ModuleMethod($instance, 2, conditions.Lit6, 4097);
        make$Mncondition$Mntype = new ModuleMethod($instance, 3, conditions.Lit7, 12291);
        define$Mncondition$Mntype = Macro.make(conditions.Lit8, conditions.Lit9, "gnu.kawa.slib.conditions");
        condition$Mntype$Mnfield$Mnsupertype = new ModuleMethod($instance, 4, conditions.Lit10, 8194);
        $Prvt$$Lscondition$Gr = condition.class;
        condition$Qu = new ModuleMethod($instance, 5, conditions.Lit11, 4097);
        make$Mncondition = new ModuleMethod($instance, 6, conditions.Lit12, -4095);
        condition$Mnhas$Mntype$Qu = new ModuleMethod($instance, 7, conditions.Lit13, 8194);
        condition$Mntype$Mnfield$Mnalist = Macro.make(conditions.Lit14, conditions.Lit15, "gnu.kawa.slib.conditions");
        condition$Mnref = new ModuleMethod($instance, 8, conditions.Lit16, 8194);
        make$Mncompound$Mncondition = new ModuleMethod($instance, 9, conditions.Lit17, -4095);
        extract$Mncondition = new ModuleMethod($instance, 10, conditions.Lit18, 8194);
        condition = Macro.make(conditions.Lit19, conditions.Lit20, "gnu.kawa.slib.conditions");
        $Prvt$type$Mnfield$Mnalist$Mn$Grcondition = new ModuleMethod($instance, 11, conditions.Lit21, 4097);
        check$Mncondition$Mntype$Mnfield$Mnalist = new ModuleMethod($instance, 12, conditions.Lit22, 4097);
        message$Mncondition$Qu = new ModuleMethod($instance, 13, conditions.Lit23, 4097);
        condition$Mnmessage = new ModuleMethod($instance, 14, conditions.Lit24, 4097);
        serious$Mncondition$Qu = new ModuleMethod($instance, 15, conditions.Lit25, 4097);
        error$Qu = new ModuleMethod($instance, 16, conditions.Lit26, 4097);
        $runBody$();
    }
    
    public conditions() {
        ModuleInfo.register(this);
    }
    
    @Override
    public int match1(final ModuleMethod proc, final Object arg1, final CallContext ctx) {
        switch (proc.selector) {
            case 16: {
                ctx.value1 = arg1;
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 15: {
                ctx.value1 = arg1;
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 14: {
                ctx.value1 = arg1;
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 13: {
                ctx.value1 = arg1;
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 12: {
                ctx.value1 = arg1;
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 11: {
                ctx.value1 = arg1;
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 5: {
                ctx.value1 = arg1;
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 2: {
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
    public int match2(final ModuleMethod proc, final Object arg1, final Object arg2, final CallContext ctx) {
        switch (proc.selector) {
            case 10: {
                final Object force = Promise.force(arg1, condition.class);
                if (!(force instanceof condition)) {
                    return -786431;
                }
                ctx.value1 = force;
                final Object force2 = Promise.force(arg2, condition-type.class);
                if (!(force2 instanceof condition-type)) {
                    return -786430;
                }
                ctx.value2 = force2;
                ctx.proc = proc;
                ctx.pc = 2;
                return 0;
            }
            case 8: {
                final Object force3 = Promise.force(arg1, condition.class);
                if (!(force3 instanceof condition)) {
                    return -786431;
                }
                ctx.value1 = force3;
                ctx.value2 = arg2;
                ctx.proc = proc;
                ctx.pc = 2;
                return 0;
            }
            case 7: {
                ctx.value1 = arg1;
                final Object force4 = Promise.force(arg2, condition-type.class);
                if (!(force4 instanceof condition-type)) {
                    return -786430;
                }
                ctx.value2 = force4;
                ctx.proc = proc;
                ctx.pc = 2;
                return 0;
            }
            case 4: {
                final Object force5 = Promise.force(arg1, condition-type.class);
                if (!(force5 instanceof condition-type)) {
                    return -786431;
                }
                ctx.value1 = force5;
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
    public int match3(final ModuleMethod moduleMethod, final Object o, final Object o2, final Object o3, final CallContext ctx) {
        if (moduleMethod.selector != 3) {
            return super.match3(moduleMethod, o, o2, o3, ctx);
        }
        final Object force = Promise.force(o, Symbol.class);
        if (!(force instanceof Symbol)) {
            return -786431;
        }
        ctx.value1 = force;
        final Object force2 = Promise.force(o2, condition-type.class);
        if (!(force2 instanceof condition-type)) {
            return -786430;
        }
        ctx.value2 = force2;
        ctx.value3 = o3;
        ctx.proc = moduleMethod;
        ctx.pc = 3;
        return 0;
    }
    
    @Override
    public int matchN(final ModuleMethod proc, final Object[] args, final CallContext ctx) {
        switch (proc.selector) {
            case 9: {
                ctx.values = args;
                ctx.proc = proc;
                ctx.pc = 5;
                return 0;
            }
            case 6: {
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
    public Object apply1(final ModuleMethod method, final Object arg1) {
        switch (method.selector) {
            case 2: {
                return isConditionType(arg1) ? Boolean.TRUE : Boolean.FALSE;
            }
            case 5: {
                return isCondition(arg1) ? Boolean.TRUE : Boolean.FALSE;
            }
            case 11: {
                return typeFieldAlist$To$Condition(arg1);
            }
            case 12: {
                return checkConditionTypeFieldAlist(arg1);
            }
            case 13: {
                return isMessageCondition(arg1) ? Boolean.TRUE : Boolean.FALSE;
            }
            case 14: {
                return conditionMessage(arg1);
            }
            case 15: {
                return isSeriousCondition(arg1) ? Boolean.TRUE : Boolean.FALSE;
            }
            case 16: {
                return isError(arg1) ? Boolean.TRUE : Boolean.FALSE;
            }
            default: {
                return super.apply1(method, arg1);
            }
        }
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
        //                8: 48
        //                9: 124
        //               10: 124
        //               11: 62
        //               12: 88
        //               13: 124
        //               14: 102
        //          default: 124
        //        }
        //    48: aload_2        
        //    49: ldc             Lgnu/kawa/slib/condition-type;.class
        //    51: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    54: checkcast       Lgnu/kawa/slib/condition-type;
        //    57: aload_3        
        //    58: invokestatic    gnu/kawa/slib/conditions.conditionTypeFieldSupertype:(Lgnu/kawa/slib/condition-type;Ljava/lang/Object;)Ljava/lang/Object;
        //    61: areturn        
        //    62: aload_2        
        //    63: aload_3        
        //    64: ldc             Lgnu/kawa/slib/condition-type;.class
        //    66: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    69: checkcast       Lgnu/kawa/slib/condition-type;
        //    72: invokestatic    gnu/kawa/slib/conditions.isConditionHasType:(Ljava/lang/Object;Lgnu/kawa/slib/condition-type;)Z
        //    75: ifeq            84
        //    78: getstatic       java/lang/Boolean.TRUE:Ljava/lang/Boolean;
        //    81: goto            87
        //    84: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //    87: areturn        
        //    88: aload_2        
        //    89: ldc             Lgnu/kawa/slib/condition;.class
        //    91: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    94: checkcast       Lgnu/kawa/slib/condition;
        //    97: aload_3        
        //    98: invokestatic    gnu/kawa/slib/conditions.conditionRef:(Lgnu/kawa/slib/condition;Ljava/lang/Object;)Ljava/lang/Object;
        //   101: areturn        
        //   102: aload_2        
        //   103: ldc             Lgnu/kawa/slib/condition;.class
        //   105: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   108: checkcast       Lgnu/kawa/slib/condition;
        //   111: aload_3        
        //   112: ldc             Lgnu/kawa/slib/condition-type;.class
        //   114: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   117: checkcast       Lgnu/kawa/slib/condition-type;
        //   120: invokestatic    gnu/kawa/slib/conditions.extractCondition:(Lgnu/kawa/slib/condition;Lgnu/kawa/slib/condition-type;)Lgnu/kawa/slib/condition;
        //   123: areturn        
        //   124: aload_0        
        //   125: aload_1        
        //   126: aload_2        
        //   127: aload_3        
        //   128: invokespecial   gnu/expr/ModuleBody.apply2:(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   131: areturn        
        //   132: new             Lgnu/mapping/WrongType;
        //   135: dup_x1         
        //   136: swap           
        //   137: ldc_w           "condition-type-field-supertype"
        //   140: iconst_1       
        //   141: aload_2        
        //   142: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   145: athrow         
        //   146: new             Lgnu/mapping/WrongType;
        //   149: dup_x1         
        //   150: swap           
        //   151: ldc_w           "condition-has-type?"
        //   154: iconst_2       
        //   155: aload_3        
        //   156: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   159: athrow         
        //   160: new             Lgnu/mapping/WrongType;
        //   163: dup_x1         
        //   164: swap           
        //   165: ldc_w           "condition-ref"
        //   168: iconst_1       
        //   169: aload_2        
        //   170: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   173: athrow         
        //   174: new             Lgnu/mapping/WrongType;
        //   177: dup_x1         
        //   178: swap           
        //   179: ldc_w           "extract-condition"
        //   182: iconst_1       
        //   183: aload_2        
        //   184: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   187: athrow         
        //   188: new             Lgnu/mapping/WrongType;
        //   191: dup_x1         
        //   192: swap           
        //   193: ldc_w           "extract-condition"
        //   196: iconst_2       
        //   197: aload_3        
        //   198: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   201: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  54     57     132    146    Ljava/lang/ClassCastException;
        //  69     72     146    160    Ljava/lang/ClassCastException;
        //  94     97     160    174    Ljava/lang/ClassCastException;
        //  108    111    174    188    Ljava/lang/ClassCastException;
        //  117    120    188    202    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 84 out of bounds for length 84
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
        //     4: iconst_3       
        //     5: if_icmpne       36
        //     8: goto            11
        //    11: aload_2        
        //    12: ldc_w           Lgnu/mapping/Symbol;.class
        //    15: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    18: checkcast       Lgnu/mapping/Symbol;
        //    21: aload_3        
        //    22: ldc             Lgnu/kawa/slib/condition-type;.class
        //    24: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    27: checkcast       Lgnu/kawa/slib/condition-type;
        //    30: aload           4
        //    32: invokestatic    gnu/kawa/slib/conditions.makeConditionType:(Lgnu/mapping/Symbol;Lgnu/kawa/slib/condition-type;Ljava/lang/Object;)Lgnu/kawa/slib/condition-type;
        //    35: areturn        
        //    36: aload_0        
        //    37: aload_1        
        //    38: aload_2        
        //    39: aload_3        
        //    40: aload           4
        //    42: invokespecial   gnu/expr/ModuleBody.apply3:(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    45: areturn        
        //    46: new             Lgnu/mapping/WrongType;
        //    49: dup_x1         
        //    50: swap           
        //    51: ldc_w           "make-condition-type"
        //    54: iconst_1       
        //    55: aload_2        
        //    56: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //    59: athrow         
        //    60: new             Lgnu/mapping/WrongType;
        //    63: dup_x1         
        //    64: swap           
        //    65: ldc_w           "make-condition-type"
        //    68: iconst_2       
        //    69: aload_3        
        //    70: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //    73: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  18     21     46     60     Ljava/lang/ClassCastException;
        //  27     30     60     74     Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0036:
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
    
    @Override
    public Object applyN(final ModuleMethod method, final Object[] args) {
    Label_0080_Outer:
        while (true) {
            while (true) {
                switch (method.selector) {
                    case 6: {
                        final Object force = Promise.force(args[0], condition-type.class);
                        try {
                            final condition-type type = (condition-type)force;
                            int n = args.length - 1;
                            final Object[] argsArray = new Object[n];
                            while (--n >= 0) {
                                argsArray[n] = args[n + 1];
                            }
                            return makeCondition$V(type, argsArray);
                            while (true) {
                                final Object condition$Mn1;
                                final Object[] argsArray2;
                                return makeCompoundCondition$V(condition$Mn1, argsArray2);
                                return super.applyN(method, args);
                                condition$Mn1 = args[0];
                                final int n2 = args.length - 1;
                                argsArray2 = new Object[n2];
                                continue Label_0080_Outer;
                                Label_0095: {
                                    argsArray2[n2] = args[n2 + 1];
                                }
                                continue Label_0080_Outer;
                            }
                        }
                        // iftrue(Label_0095:, --n2 >= 0)
                        catch (ClassCastException ex) {
                            throw new WrongType(ex, "make-condition", 1, force);
                        }
                        break;
                    }
                    case 9: {
                        continue;
                    }
                    default: {
                        continue Label_0080_Outer;
                    }
                }
                break;
            }
            break;
        }
    }
}
