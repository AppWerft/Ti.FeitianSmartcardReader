// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.slib;

import gnu.expr.ModuleInfo;
import kawa.lang.SyntaxPattern;
import kawa.lang.SyntaxRule;
import gnu.mapping.Symbol;
import gnu.lists.EmptyList;
import gnu.kawa.functions.ApplyToArgs;
import gnu.expr.KawaConvert;
import gnu.kawa.functions.Apply;
import kawa.lang.Continuation;
import kawa.standard.append;
import java.util.Iterator;
import gnu.lists.Sequences;
import kawa.lib.numbers;
import gnu.mapping.Values;
import gnu.kawa.lispexpr.LangObjType;
import gnu.expr.Special;
import kawa.lib.exceptions;
import gnu.mapping.WrongType;
import gnu.mapping.Promise;
import gnu.math.Numeric;
import gnu.lists.LList;
import gnu.mapping.Procedure;
import gnu.lists.Pair;
import gnu.lists.Consumer;
import kawa.standard.Scheme;
import kawa.lib.lists;
import gnu.mapping.CallContext;
import gnu.lists.PairWithPosition;
import kawa.lang.SyntaxRules;
import gnu.mapping.SimpleSymbol;
import gnu.math.IntNum;
import kawa.lang.Macro;
import gnu.kawa.functions.Map;
import gnu.expr.GenericProc;
import gnu.expr.ModuleMethod;
import gnu.expr.ModuleBody;

public class srfi1 extends ModuleBody
{
    public static final int $Pcprovide$Pcsrfi$Mn1 = 123;
    public static final int $Pcprovide$Pclist$Mnlib = 123;
    public static final ModuleMethod xcons;
    public static final ModuleMethod list$Mntabulate;
    public static final ModuleMethod cons$St;
    public static final ModuleMethod iota;
    public static final ModuleMethod circular$Mnlist;
    public static final ModuleMethod proper$Mnlist$Qu;
    public static final ModuleMethod dotted$Mnlist$Qu;
    public static final ModuleMethod circular$Mnlist$Qu;
    public static final ModuleMethod not$Mnpair$Qu;
    public static final ModuleMethod null$Mnlist$Qu;
    public static final ModuleMethod list$Eq;
    public static final ModuleMethod length$Pl;
    public static final ModuleMethod zip;
    public static GenericProc first;
    public static GenericProc second;
    public static GenericProc third;
    public static GenericProc fourth;
    public static final ModuleMethod fifth;
    public static final ModuleMethod sixth;
    public static final ModuleMethod seventh;
    public static final ModuleMethod eighth;
    public static final ModuleMethod ninth;
    public static final ModuleMethod tenth;
    public static final ModuleMethod car$Plcdr;
    public static final ModuleMethod take;
    public static final ModuleMethod drop;
    public static final ModuleMethod take$Ex;
    public static final ModuleMethod take$Mnright;
    public static final ModuleMethod drop$Mnright;
    public static final ModuleMethod drop$Mnright$Ex;
    public static final ModuleMethod split$Mnat;
    public static final ModuleMethod split$Mnat$Ex;
    public static final ModuleMethod last;
    public static final ModuleMethod last$Mnpair;
    public static final ModuleMethod unzip1;
    public static final ModuleMethod unzip2;
    public static final ModuleMethod unzip3;
    public static final ModuleMethod unzip4;
    public static final ModuleMethod unzip5;
    public static final ModuleMethod append$Ex;
    public static final ModuleMethod append$Mnreverse;
    public static final ModuleMethod append$Mnreverse$Ex;
    public static final ModuleMethod concatenate;
    public static final ModuleMethod concatenate$Ex;
    public static final ModuleMethod count;
    public static final ModuleMethod unfold$Mnright;
    public static final ModuleMethod unfold;
    public static final ModuleMethod fold;
    public static final ModuleMethod fold$Mnright;
    public static final ModuleMethod pair$Mnfold$Mnright;
    public static final ModuleMethod pair$Mnfold;
    public static final ModuleMethod reduce;
    public static final ModuleMethod reduce$Mnright;
    public static final ModuleMethod append$Mnmap;
    public static final ModuleMethod append$Mnmap$Ex;
    public static final ModuleMethod pair$Mnfor$Mneach;
    public static final ModuleMethod map$Ex;
    public static final ModuleMethod filter$Mnmap;
    public static Map map$Mnin$Mnorder;
    public static final ModuleMethod filter;
    public static final ModuleMethod filter$Ex;
    public static final ModuleMethod partition;
    public static final ModuleMethod partition$Ex;
    public static final ModuleMethod remove;
    public static final ModuleMethod remove$Ex;
    public static final ModuleMethod delete;
    public static final ModuleMethod delete$Ex;
    public static final ModuleMethod delete$Mnduplicates;
    public static final ModuleMethod delete$Mnduplicates$Ex;
    public static final ModuleMethod alist$Mncons;
    public static final ModuleMethod alist$Mncopy;
    public static final ModuleMethod alist$Mndelete;
    public static final ModuleMethod alist$Mndelete$Ex;
    public static final ModuleMethod find;
    public static final ModuleMethod find$Mntail;
    public static final ModuleMethod take$Mnwhile;
    public static final ModuleMethod drop$Mnwhile;
    public static final ModuleMethod take$Mnwhile$Ex;
    public static final ModuleMethod span;
    public static final ModuleMethod span$Ex;
    public static final ModuleMethod break;
    public static final ModuleMethod break$Ex;
    public static final ModuleMethod any;
    public static final ModuleMethod every;
    public static final Macro $Pcevery;
    public static final ModuleMethod list$Mnindex;
    public static final ModuleMethod lset$Ls$Eq;
    public static final ModuleMethod lset$Eq;
    public static final ModuleMethod lset$Mnadjoin;
    public static final ModuleMethod lset$Mnunion;
    public static final ModuleMethod lset$Mnunion$Ex;
    public static final ModuleMethod lset$Mnintersection;
    public static final ModuleMethod lset$Mnintersection$Ex;
    public static final ModuleMethod lset$Mndifference;
    public static final ModuleMethod lset$Mndifference$Ex;
    public static final ModuleMethod lset$Mnxor;
    public static final ModuleMethod lset$Mnxor$Ex;
    public static final ModuleMethod lset$Mndiff$Plintersection;
    public static final ModuleMethod lset$Mndiff$Plintersection$Ex;
    static final IntNum Lit0;
    static final IntNum Lit1;
    static final SimpleSymbol Lit2;
    public static srfi1 $instance;
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
    static final SimpleSymbol Lit33;
    static final SimpleSymbol Lit34;
    static final SimpleSymbol Lit35;
    static final SimpleSymbol Lit36;
    static final SimpleSymbol Lit37;
    static final SimpleSymbol Lit38;
    static final SimpleSymbol Lit39;
    static final SimpleSymbol Lit40;
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
    static final SimpleSymbol Lit62;
    static final SimpleSymbol Lit63;
    static final SimpleSymbol Lit64;
    static final SimpleSymbol Lit65;
    static final SimpleSymbol Lit66;
    static final SimpleSymbol Lit67;
    static final SimpleSymbol Lit68;
    static final SimpleSymbol Lit69;
    static final SimpleSymbol Lit70;
    static final SimpleSymbol Lit71;
    static final SimpleSymbol Lit72;
    static final SimpleSymbol Lit73;
    static final SimpleSymbol Lit74;
    static final SimpleSymbol Lit75;
    static final SimpleSymbol Lit76;
    static final SimpleSymbol Lit77;
    static final SimpleSymbol Lit78;
    static final SimpleSymbol Lit79;
    static final SimpleSymbol Lit80;
    static final SimpleSymbol Lit81;
    static final SimpleSymbol Lit82;
    static final SyntaxRules Lit83;
    static final SimpleSymbol Lit84;
    static final SimpleSymbol Lit85;
    static final SimpleSymbol Lit86;
    static final SimpleSymbol Lit87;
    static final SimpleSymbol Lit88;
    static final SimpleSymbol Lit89;
    static final SimpleSymbol Lit90;
    static final SimpleSymbol Lit91;
    static final SimpleSymbol Lit92;
    static final SimpleSymbol Lit93;
    static final SimpleSymbol Lit94;
    static final SimpleSymbol Lit95;
    static final SimpleSymbol Lit96;
    static final SimpleSymbol Lit97;
    static final Object[] Lit98;
    static final SimpleSymbol Lit99;
    static final SimpleSymbol Lit100;
    static final SimpleSymbol Lit101;
    static final SimpleSymbol Lit102;
    static final PairWithPosition Lit103;
    static final SimpleSymbol Lit104;
    
    private static void $runBody$() {
        final CallContext $ctx;
        final Consumer $result = ($ctx = CallContext.getInstance()).consumer;
        srfi1.first = lists.car;
        srfi1.second = lists.cadr;
        srfi1.third = lists.caddr;
        srfi1.fourth = lists.cadddr;
        srfi1.map$Mnin$Mnorder = Scheme.map;
    }
    
    public static Pair xcons(final Object d, final Object a) {
        return lists.cons(a, d);
    }
    
    public static Object listTabulate(final Object len, final Procedure proc) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokestatic    kawa/lib/numbers.isInteger:(Ljava/lang/Object;)Z
        //     4: ifeq            11
        //     7: iconst_0       
        //     8: goto            12
        //    11: iconst_1       
        //    12: istore_2        /* x */
        //    13: iload_2         /* x */
        //    14: ifeq            24
        //    17: iload_2         /* x */
        //    18: ifeq            50
        //    21: goto            34
        //    24: aload_0         /* len */
        //    25: getstatic       gnu/kawa/slib/srfi1.Lit0:Lgnu/math/IntNum;
        //    28: invokestatic    gnu/kawa/functions/NumberCompare.$Ls:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //    31: ifeq            50
        //    34: iconst_1       
        //    35: anewarray       Ljava/lang/Object;
        //    38: dup            
        //    39: iconst_0       
        //    40: ldc             "list-tabulate arg#1 must be a non-negative integer"
        //    42: aastore        
        //    43: invokestatic    kawa/lib/exceptions.error:([Ljava/lang/Object;)Lgnu/bytecode/Type$NeverReturns;
        //    46: getstatic       gnu/expr/Special.reachedUnexpected:Ljava/lang/RuntimeException;
        //    49: athrow         
        //    50: iconst_m1      
        //    51: aload_0         /* len */
        //    52: getstatic       gnu/kawa/slib/srfi1.Lit1:Lgnu/math/IntNum;
        //    55: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    58: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
        //    61: astore_3       
        //    62: astore_2        /* i */
        //    63: aload_2         /* i */
        //    64: getstatic       gnu/kawa/slib/srfi1.Lit0:Lgnu/math/IntNum;
        //    67: invokestatic    gnu/kawa/functions/NumberCompare.$Ls:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //    70: ifne            93
        //    73: iconst_m1      
        //    74: aload_2         /* i */
        //    75: getstatic       gnu/kawa/slib/srfi1.Lit1:Lgnu/math/IntNum;
        //    78: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    81: aload_1         /* proc */
        //    82: aload_2         /* i */
        //    83: invokevirtual   gnu/mapping/Procedure.apply1:(Ljava/lang/Object;)Ljava/lang/Object;
        //    86: aload_3         /* ans */
        //    87: invokestatic    kawa/lib/lists.cons:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //    90: goto            61
        //    93: aload_3         /* ans */
        //    94: areturn        
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public static Object cons$St(final Object... args) {
        return LList.consX(args);
    }
    
    public static Object iota(final IntNum count) {
        return iota(count, srfi1.Lit0, srfi1.Lit1);
    }
    
    public static Object iota(final IntNum count, final Numeric start) {
        return iota(count, start, srfi1.Lit1);
    }
    
    public static Object iota(final IntNum count, final Numeric start, final Numeric step) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: lconst_0       
        //     2: invokestatic    gnu/math/IntNum.compare:(Lgnu/math/IntNum;J)I
        //     5: ifge            34
        //     8: iconst_3       
        //     9: anewarray       Ljava/lang/Object;
        //    12: dup            
        //    13: iconst_0       
        //    14: ldc             "Negative step count"
        //    16: aastore        
        //    17: dup            
        //    18: iconst_1       
        //    19: getstatic       gnu/kawa/slib/srfi1.iota:Lgnu/expr/ModuleMethod;
        //    22: aastore        
        //    23: dup            
        //    24: iconst_2       
        //    25: aload_0         /* count */
        //    26: aastore        
        //    27: invokestatic    kawa/lib/exceptions.error:([Ljava/lang/Object;)Lgnu/bytecode/Type$NeverReturns;
        //    30: getstatic       gnu/expr/Special.reachedUnexpected:Ljava/lang/RuntimeException;
        //    33: athrow         
        //    34: iconst_1       
        //    35: aload_1         /* start */
        //    36: getstatic       gnu/kawa/functions/MultiplyOp.$St:Lgnu/kawa/functions/MultiplyOp;
        //    39: aload_0         /* count */
        //    40: iconst_m1      
        //    41: invokestatic    gnu/math/IntNum.add:(Lgnu/math/IntNum;I)Lgnu/math/IntNum;
        //    44: aload_2         /* step */
        //    45: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    48: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    51: ldc             Lgnu/math/Numeric;.class
        //    53: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    56: dup            
        //    57: astore          4
        //    59: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceNumeric:(Ljava/lang/Object;)Lgnu/math/Numeric;
        //    62: astore_3        /* last$Mnval */
        //    63: aload_0         /* count */
        //    64: aload_3         /* last$Mnval */
        //    65: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
        //    68: astore          6
        //    70: astore          5
        //    72: astore          count
        //    74: aload           count
        //    76: lconst_0       
        //    77: invokestatic    gnu/math/IntNum.compare:(Lgnu/math/IntNum;J)I
        //    80: ifle            106
        //    83: aload           count
        //    85: iconst_m1      
        //    86: invokestatic    gnu/math/IntNum.add:(Lgnu/math/IntNum;I)Lgnu/math/IntNum;
        //    89: iconst_m1      
        //    90: aload           val
        //    92: aload_2         /* step */
        //    93: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    96: aload           val
        //    98: aload           ans
        //   100: invokestatic    kawa/lib/lists.cons:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //   103: goto            68
        //   106: aload           ans
        //   108: areturn        
        //   109: new             Lgnu/mapping/WrongType;
        //   112: dup_x1         
        //   113: swap           
        //   114: ldc             "last-val"
        //   116: bipush          -2
        //   118: aload           4
        //   120: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   123: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  59     62     109    124    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public static Pair circularList$V(final Object val1, final Object[] argsArray) {
        final LList vals = LList.makeList(argsArray, 0);
        final Pair ans = lists.cons(val1, vals);
        final Object force = Promise.force(lastPair(ans), Pair.class);
        try {
            lists.setCdr$Ex((Pair)force, ans);
            return ans;
        }
        catch (ClassCastException ex) {
            throw new WrongType(ex, "set-cdr!", 1, force);
        }
    }
    
    public static Object lastPair(final Pair lis) {
        Object o = lis;
        while (true) {
            final Object lis2 = o;
            final Object force = Promise.force(lis2, Pair.class);
            try {
                final Object tail = lists.cdr((Pair)force);
                if (!lists.isPair(tail)) {
                    return lis2;
                }
                o = tail;
            }
            catch (ClassCastException ex) {
                throw new WrongType(ex, "cdr", 1, force);
            }
        }
    }
    
    public static Object isProperList(final Object x) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: aload_0         /* x */
        //     2: astore_2       
        //     3: astore_1        /* x */
        //     4: aload_1         /* x */
        //     5: invokestatic    kawa/lib/lists.isPair:(Ljava/lang/Object;)Z
        //     8: ifeq            107
        //    11: aload_1         /* x */
        //    12: ldc             Lgnu/lists/Pair;.class
        //    14: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    17: dup            
        //    18: astore          4
        //    20: checkcast       Lgnu/lists/Pair;
        //    23: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    26: astore_3        /* x */
        //    27: aload_3         /* x */
        //    28: invokestatic    kawa/lib/lists.isPair:(Ljava/lang/Object;)Z
        //    31: ifeq            88
        //    34: aload_3         /* x */
        //    35: ldc             Lgnu/lists/Pair;.class
        //    37: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    40: dup            
        //    41: astore          5
        //    43: checkcast       Lgnu/lists/Pair;
        //    46: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    49: astore          4
        //    51: aload_2         /* lag */
        //    52: ldc             Lgnu/lists/Pair;.class
        //    54: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    57: dup            
        //    58: astore          6
        //    60: checkcast       Lgnu/lists/Pair;
        //    63: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    66: astore          lag
        //    68: aload           x
        //    70: aload           lag
        //    72: if_acmpeq       82
        //    75: aload           x
        //    77: aload           lag
        //    79: goto            2
        //    82: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //    85: goto            123
        //    88: aload_3         /* x */
        //    89: invokestatic    kawa/lib/lists.isNull:(Ljava/lang/Object;)Z
        //    92: ifeq            101
        //    95: getstatic       java/lang/Boolean.TRUE:Ljava/lang/Boolean;
        //    98: goto            123
        //   101: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //   104: goto            123
        //   107: aload_1         /* x */
        //   108: invokestatic    kawa/lib/lists.isNull:(Ljava/lang/Object;)Z
        //   111: ifeq            120
        //   114: getstatic       java/lang/Boolean.TRUE:Ljava/lang/Boolean;
        //   117: goto            123
        //   120: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //   123: areturn        
        //   124: new             Lgnu/mapping/WrongType;
        //   127: dup_x1         
        //   128: swap           
        //   129: ldc             "cdr"
        //   131: iconst_1       
        //   132: aload           4
        //   134: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   137: athrow         
        //   138: new             Lgnu/mapping/WrongType;
        //   141: dup_x1         
        //   142: swap           
        //   143: ldc             "cdr"
        //   145: iconst_1       
        //   146: aload           5
        //   148: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   151: athrow         
        //   152: new             Lgnu/mapping/WrongType;
        //   155: dup_x1         
        //   156: swap           
        //   157: ldc             "cdr"
        //   159: iconst_1       
        //   160: aload           6
        //   162: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   165: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  20     23     124    138    Ljava/lang/ClassCastException;
        //  43     46     138    152    Ljava/lang/ClassCastException;
        //  60     63     152    166    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public static Object isDottedList(final Object x) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: aload_0         /* x */
        //     2: astore_2       
        //     3: astore_1        /* x */
        //     4: aload_1         /* x */
        //     5: invokestatic    kawa/lib/lists.isPair:(Ljava/lang/Object;)Z
        //     8: ifeq            107
        //    11: aload_1         /* x */
        //    12: ldc             Lgnu/lists/Pair;.class
        //    14: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    17: dup            
        //    18: astore          4
        //    20: checkcast       Lgnu/lists/Pair;
        //    23: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    26: astore_3        /* x */
        //    27: aload_3         /* x */
        //    28: invokestatic    kawa/lib/lists.isPair:(Ljava/lang/Object;)Z
        //    31: ifeq            88
        //    34: aload_3         /* x */
        //    35: ldc             Lgnu/lists/Pair;.class
        //    37: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    40: dup            
        //    41: astore          5
        //    43: checkcast       Lgnu/lists/Pair;
        //    46: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    49: astore          4
        //    51: aload_2         /* lag */
        //    52: ldc             Lgnu/lists/Pair;.class
        //    54: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    57: dup            
        //    58: astore          6
        //    60: checkcast       Lgnu/lists/Pair;
        //    63: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    66: astore          lag
        //    68: aload           x
        //    70: aload           lag
        //    72: if_acmpeq       82
        //    75: aload           x
        //    77: aload           lag
        //    79: goto            2
        //    82: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //    85: goto            123
        //    88: aload_3         /* x */
        //    89: invokestatic    kawa/lib/lists.isNull:(Ljava/lang/Object;)Z
        //    92: ifeq            101
        //    95: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //    98: goto            123
        //   101: getstatic       java/lang/Boolean.TRUE:Ljava/lang/Boolean;
        //   104: goto            123
        //   107: aload_1         /* x */
        //   108: invokestatic    kawa/lib/lists.isNull:(Ljava/lang/Object;)Z
        //   111: ifeq            120
        //   114: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //   117: goto            123
        //   120: getstatic       java/lang/Boolean.TRUE:Ljava/lang/Boolean;
        //   123: areturn        
        //   124: new             Lgnu/mapping/WrongType;
        //   127: dup_x1         
        //   128: swap           
        //   129: ldc             "cdr"
        //   131: iconst_1       
        //   132: aload           4
        //   134: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   137: athrow         
        //   138: new             Lgnu/mapping/WrongType;
        //   141: dup_x1         
        //   142: swap           
        //   143: ldc             "cdr"
        //   145: iconst_1       
        //   146: aload           5
        //   148: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   151: athrow         
        //   152: new             Lgnu/mapping/WrongType;
        //   155: dup_x1         
        //   156: swap           
        //   157: ldc             "cdr"
        //   159: iconst_1       
        //   160: aload           6
        //   162: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   165: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  20     23     124    138    Ljava/lang/ClassCastException;
        //  43     46     138    152    Ljava/lang/ClassCastException;
        //  60     63     152    166    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public static Object isCircularList(final Object x) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: aload_0         /* x */
        //     2: astore_2       
        //     3: astore_1        /* x */
        //     4: aload_1         /* x */
        //     5: invokestatic    kawa/lib/lists.isPair:(Ljava/lang/Object;)Z
        //     8: ifeq            117
        //    11: aload_1         /* x */
        //    12: ldc             Lgnu/lists/Pair;.class
        //    14: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    17: dup            
        //    18: astore          4
        //    20: checkcast       Lgnu/lists/Pair;
        //    23: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    26: astore_3        /* x */
        //    27: aload_3         /* x */
        //    28: invokestatic    kawa/lib/lists.isPair:(Ljava/lang/Object;)Z
        //    31: ifeq            111
        //    34: aload_3         /* x */
        //    35: ldc             Lgnu/lists/Pair;.class
        //    37: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    40: dup            
        //    41: astore          5
        //    43: checkcast       Lgnu/lists/Pair;
        //    46: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    49: astore          4
        //    51: aload_2         /* lag */
        //    52: ldc             Lgnu/lists/Pair;.class
        //    54: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    57: dup            
        //    58: astore          6
        //    60: checkcast       Lgnu/lists/Pair;
        //    63: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    66: astore          lag
        //    68: aload           x
        //    70: aload           lag
        //    72: if_acmpne       79
        //    75: iconst_1       
        //    76: goto            80
        //    79: iconst_0       
        //    80: istore          x
        //    82: iload           x
        //    84: ifeq            104
        //    87: iload           x
        //    89: ifeq            98
        //    92: getstatic       java/lang/Boolean.TRUE:Ljava/lang/Boolean;
        //    95: goto            120
        //    98: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //   101: goto            120
        //   104: aload           x
        //   106: aload           lag
        //   108: goto            2
        //   111: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //   114: goto            120
        //   117: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //   120: areturn        
        //   121: new             Lgnu/mapping/WrongType;
        //   124: dup_x1         
        //   125: swap           
        //   126: ldc             "cdr"
        //   128: iconst_1       
        //   129: aload           4
        //   131: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   134: athrow         
        //   135: new             Lgnu/mapping/WrongType;
        //   138: dup_x1         
        //   139: swap           
        //   140: ldc             "cdr"
        //   142: iconst_1       
        //   143: aload           5
        //   145: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   148: athrow         
        //   149: new             Lgnu/mapping/WrongType;
        //   152: dup_x1         
        //   153: swap           
        //   154: ldc             "cdr"
        //   156: iconst_1       
        //   157: aload           6
        //   159: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   162: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  20     23     121    135    Ljava/lang/ClassCastException;
        //  43     46     135    149    Ljava/lang/ClassCastException;
        //  60     63     149    163    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public static boolean isNotPair(final Object x) {
        return !lists.isPair(x);
    }
    
    public static boolean isNullList(final Object l) {
        boolean b;
        if (l instanceof Pair) {
            b = false;
        }
        else {
            if (l != LList.Empty) {
                exceptions.error("null-list?: argument out of domain", l);
                throw Special.reachedUnexpected;
            }
            b = true;
        }
        return b;
    }
    
    public static Object list$Eq$V(final Object $Eq, final Object[] argsArray) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: iconst_0       
        //     2: invokestatic    gnu/lists/LList.makeList:([Ljava/lang/Object;I)Lgnu/lists/LList;
        //     5: dup            
        //     6: astore_3       
        //     7: astore_2        /* lists */
        //     8: aload_2         /* lists */
        //     9: invokestatic    kawa/lib/lists.isNull:(Ljava/lang/Object;)Z
        //    12: istore_3        /* x */
        //    13: iload_3         /* x */
        //    14: ifeq            33
        //    17: iload_3         /* x */
        //    18: ifeq            27
        //    21: getstatic       java/lang/Boolean.TRUE:Ljava/lang/Boolean;
        //    24: goto            270
        //    27: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //    30: goto            270
        //    33: aload_2         /* lists */
        //    34: dup            
        //    35: astore          4
        //    37: checkcast       Lgnu/lists/Pair;
        //    40: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    43: aload_2         /* lists */
        //    44: dup            
        //    45: astore          4
        //    47: checkcast       Lgnu/lists/Pair;
        //    50: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    53: astore          5
        //    55: astore          list$Mna
        //    57: aload           others
        //    59: invokestatic    kawa/lib/lists.isNull:(Ljava/lang/Object;)Z
        //    62: istore          x
        //    64: iload           x
        //    66: ifeq            86
        //    69: iload           x
        //    71: ifeq            80
        //    74: getstatic       java/lang/Boolean.TRUE:Ljava/lang/Boolean;
        //    77: goto            270
        //    80: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //    83: goto            270
        //    86: aload           others
        //    88: ldc             Lgnu/lists/Pair;.class
        //    90: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    93: dup            
        //    94: astore          8
        //    96: checkcast       Lgnu/lists/Pair;
        //    99: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   102: astore          7
        //   104: aload           others
        //   106: ldc             Lgnu/lists/Pair;.class
        //   108: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   111: dup            
        //   112: astore          9
        //   114: checkcast       Lgnu/lists/Pair;
        //   117: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   120: astore          others
        //   122: aload           list$Mna
        //   124: aload           list$Mnb
        //   126: if_acmpne       136
        //   129: aload           list$Mnb
        //   131: aload           others
        //   133: goto            53
        //   136: aload           list$Mna
        //   138: aload           list$Mnb
        //   140: astore          10
        //   142: astore          list$Mna
        //   144: aload           list$Mna
        //   146: invokestatic    gnu/kawa/slib/srfi1.isNullList:(Ljava/lang/Object;)Z
        //   149: ifeq            173
        //   152: aload           list$Mnb
        //   154: invokestatic    gnu/kawa/slib/srfi1.isNullList:(Ljava/lang/Object;)Z
        //   157: ifeq            167
        //   160: aload           list$Mnb
        //   162: aload           others
        //   164: goto            53
        //   167: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //   170: goto            270
        //   173: aload           list$Mnb
        //   175: invokestatic    gnu/kawa/slib/srfi1.isNullList:(Ljava/lang/Object;)Z
        //   178: ifne            267
        //   181: getstatic       kawa/standard/Scheme.applyToArgs:Lgnu/kawa/functions/ApplyToArgs;
        //   184: aload_0         /* $Eq */
        //   185: aload           list$Mna
        //   187: ldc             Lgnu/lists/Pair;.class
        //   189: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   192: dup            
        //   193: astore          11
        //   195: checkcast       Lgnu/lists/Pair;
        //   198: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   201: aload           list$Mnb
        //   203: ldc             Lgnu/lists/Pair;.class
        //   205: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   208: dup            
        //   209: astore          11
        //   211: checkcast       Lgnu/lists/Pair;
        //   214: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   217: invokevirtual   gnu/mapping/Procedure.apply3:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   220: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //   223: ifeq            261
        //   226: aload           list$Mna
        //   228: ldc             Lgnu/lists/Pair;.class
        //   230: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   233: dup            
        //   234: astore          11
        //   236: checkcast       Lgnu/lists/Pair;
        //   239: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   242: aload           list$Mnb
        //   244: ldc             Lgnu/lists/Pair;.class
        //   246: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   249: dup            
        //   250: astore          11
        //   252: checkcast       Lgnu/lists/Pair;
        //   255: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   258: goto            140
        //   261: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //   264: goto            270
        //   267: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //   270: areturn        
        //   271: new             Lgnu/mapping/WrongType;
        //   274: dup_x1         
        //   275: swap           
        //   276: ldc             "car"
        //   278: iconst_1       
        //   279: aload           4
        //   281: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   284: athrow         
        //   285: new             Lgnu/mapping/WrongType;
        //   288: dup_x1         
        //   289: swap           
        //   290: ldc             "cdr"
        //   292: iconst_1       
        //   293: aload           4
        //   295: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   298: athrow         
        //   299: new             Lgnu/mapping/WrongType;
        //   302: dup_x1         
        //   303: swap           
        //   304: ldc             "car"
        //   306: iconst_1       
        //   307: aload           8
        //   309: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   312: athrow         
        //   313: new             Lgnu/mapping/WrongType;
        //   316: dup_x1         
        //   317: swap           
        //   318: ldc             "cdr"
        //   320: iconst_1       
        //   321: aload           9
        //   323: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   326: athrow         
        //   327: new             Lgnu/mapping/WrongType;
        //   330: dup_x1         
        //   331: swap           
        //   332: ldc             "car"
        //   334: iconst_1       
        //   335: aload           11
        //   337: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   340: athrow         
        //   341: new             Lgnu/mapping/WrongType;
        //   344: dup_x1         
        //   345: swap           
        //   346: ldc             "car"
        //   348: iconst_1       
        //   349: aload           11
        //   351: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   354: athrow         
        //   355: new             Lgnu/mapping/WrongType;
        //   358: dup_x1         
        //   359: swap           
        //   360: ldc             "cdr"
        //   362: iconst_1       
        //   363: aload           11
        //   365: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   368: athrow         
        //   369: new             Lgnu/mapping/WrongType;
        //   372: dup_x1         
        //   373: swap           
        //   374: ldc             "cdr"
        //   376: iconst_1       
        //   377: aload           11
        //   379: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   382: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  37     40     271    285    Ljava/lang/ClassCastException;
        //  47     50     285    299    Ljava/lang/ClassCastException;
        //  96     99     299    313    Ljava/lang/ClassCastException;
        //  114    117    313    327    Ljava/lang/ClassCastException;
        //  195    198    327    341    Ljava/lang/ClassCastException;
        //  211    214    341    355    Ljava/lang/ClassCastException;
        //  236    239    355    369    Ljava/lang/ClassCastException;
        //  252    255    369    383    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public static Object length$Pl(final Object x) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: aload_0         /* x */
        //     2: getstatic       gnu/kawa/slib/srfi1.Lit0:Lgnu/math/IntNum;
        //     5: astore_3       
        //     6: astore_2       
        //     7: astore_1        /* x */
        //     8: aload_1         /* x */
        //     9: invokestatic    kawa/lib/lists.isPair:(Ljava/lang/Object;)Z
        //    12: ifeq            123
        //    15: aload_1         /* x */
        //    16: ldc             Lgnu/lists/Pair;.class
        //    18: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    21: dup            
        //    22: astore          5
        //    24: checkcast       Lgnu/lists/Pair;
        //    27: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    30: astore          4
        //    32: iconst_1       
        //    33: aload_3         /* len */
        //    34: getstatic       gnu/kawa/slib/srfi1.Lit1:Lgnu/math/IntNum;
        //    37: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    40: astore          len
        //    42: aload           x
        //    44: invokestatic    kawa/lib/lists.isPair:(Ljava/lang/Object;)Z
        //    47: ifeq            118
        //    50: aload           x
        //    52: ldc             Lgnu/lists/Pair;.class
        //    54: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    57: dup            
        //    58: astore          7
        //    60: checkcast       Lgnu/lists/Pair;
        //    63: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    66: astore          6
        //    68: aload_2         /* lag */
        //    69: ldc             Lgnu/lists/Pair;.class
        //    71: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    74: dup            
        //    75: astore          8
        //    77: checkcast       Lgnu/lists/Pair;
        //    80: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    83: astore          7
        //    85: iconst_1       
        //    86: aload           len
        //    88: getstatic       gnu/kawa/slib/srfi1.Lit1:Lgnu/math/IntNum;
        //    91: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    94: astore          len
        //    96: aload           x
        //    98: aload           lag
        //   100: if_acmpeq       112
        //   103: aload           x
        //   105: aload           lag
        //   107: aload           len
        //   109: goto            5
        //   112: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //   115: goto            124
        //   118: aload           len
        //   120: goto            124
        //   123: aload_3         /* len */
        //   124: areturn        
        //   125: new             Lgnu/mapping/WrongType;
        //   128: dup_x1         
        //   129: swap           
        //   130: ldc             "cdr"
        //   132: iconst_1       
        //   133: aload           5
        //   135: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   138: athrow         
        //   139: new             Lgnu/mapping/WrongType;
        //   142: dup_x1         
        //   143: swap           
        //   144: ldc             "cdr"
        //   146: iconst_1       
        //   147: aload           7
        //   149: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   152: athrow         
        //   153: new             Lgnu/mapping/WrongType;
        //   156: dup_x1         
        //   157: swap           
        //   158: ldc             "cdr"
        //   160: iconst_1       
        //   161: aload           8
        //   163: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   166: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  24     27     125    139    Ljava/lang/ClassCastException;
        //  60     63     139    153    Ljava/lang/ClassCastException;
        //  77     80     153    167    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public static Object zip$V(final Object list1, final Object[] argsArray) {
        final LList more$Mnlists = LList.makeList(argsArray, 0);
        return Scheme.apply.apply4(Scheme.map, LangObjType.listType, list1, more$Mnlists);
    }
    
    public static Object fifth(final Object x) {
        final Object force = Promise.force(lists.cddddr(x), Pair.class);
        try {
            return lists.car((Pair)force);
        }
        catch (ClassCastException ex) {
            throw new WrongType(ex, "car", 1, force);
        }
    }
    
    public static Object sixth(final Object x) {
        return lists.cadr(lists.cddddr(x));
    }
    
    public static Object seventh(final Object x) {
        return lists.caddr(lists.cddddr(x));
    }
    
    public static Object eighth(final Object x) {
        return lists.cadddr(lists.cddddr(x));
    }
    
    public static Object ninth(final Object x) {
        final Object force = Promise.force(lists.cddddr(lists.cddddr(x)), Pair.class);
        try {
            return lists.car((Pair)force);
        }
        catch (ClassCastException ex) {
            throw new WrongType(ex, "car", 1, force);
        }
    }
    
    public static Object tenth(final Object x) {
        return lists.cadr(lists.cddddr(lists.cddddr(x)));
    }
    
    public static Values car$PlCdr(final Object pair) {
        Object o2;
        final Object o = o2 = Promise.force(pair, Pair.class);
        Object car;
        Object o3;
        try {
            car = lists.car((Pair)o);
            o3 = (o2 = Promise.force(pair, Pair.class));
            final Pair pair2 = (Pair)o3;
            final Object o4 = lists.cdr(pair2);
            return Values.values2(car, o4);
        }
        catch (ClassCastException ex) {
            throw new WrongType(ex, "car", 1, o2);
        }
        try {
            final Pair pair2 = (Pair)o3;
            final Object o4 = lists.cdr(pair2);
            return Values.values2(car, o4);
        }
        catch (ClassCastException ex2) {
            throw new WrongType(ex2, "cdr", 1, o2);
        }
    }
    
    public static Object take(final Object lis, final IntNum k) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: aload_1         /* k */
        //     2: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
        //     5: astore          4
        //     7: astore_3       
        //     8: astore_2        /* lis */
        //     9: aload_3         /* k */
        //    10: invokestatic    kawa/lib/numbers.isZero:(Ljava/lang/Number;)Z
        //    13: ifeq            35
        //    16: aload           res
        //    18: ldc             Lgnu/lists/LList;.class
        //    20: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    23: dup            
        //    24: astore          5
        //    26: checkcast       Lgnu/lists/LList;
        //    29: invokestatic    kawa/lib/lists.reverse$Ex:(Lgnu/lists/LList;)Lgnu/lists/LList;
        //    32: goto            78
        //    35: aload_2         /* lis */
        //    36: ldc             Lgnu/lists/Pair;.class
        //    38: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    41: dup            
        //    42: astore          5
        //    44: checkcast       Lgnu/lists/Pair;
        //    47: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    50: aload_3         /* k */
        //    51: iconst_m1      
        //    52: invokestatic    gnu/math/IntNum.add:(Lgnu/math/IntNum;I)Lgnu/math/IntNum;
        //    55: aload_2         /* lis */
        //    56: ldc             Lgnu/lists/Pair;.class
        //    58: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    61: dup            
        //    62: astore          5
        //    64: checkcast       Lgnu/lists/Pair;
        //    67: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    70: aload           res
        //    72: invokestatic    kawa/lib/lists.cons:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //    75: goto            5
        //    78: areturn        
        //    79: new             Lgnu/mapping/WrongType;
        //    82: dup_x1         
        //    83: swap           
        //    84: ldc             "reverse!"
        //    86: iconst_1       
        //    87: aload           5
        //    89: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //    92: athrow         
        //    93: new             Lgnu/mapping/WrongType;
        //    96: dup_x1         
        //    97: swap           
        //    98: ldc             "cdr"
        //   100: iconst_1       
        //   101: aload           5
        //   103: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   106: athrow         
        //   107: new             Lgnu/mapping/WrongType;
        //   110: dup_x1         
        //   111: swap           
        //   112: ldc             "car"
        //   114: iconst_1       
        //   115: aload           5
        //   117: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   120: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  26     29     79     93     Ljava/lang/ClassCastException;
        //  44     47     93     107    Ljava/lang/ClassCastException;
        //  64     67     107    121    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public static Object drop(final Object lis, final IntNum k) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: aload_1         /* k */
        //     2: astore_3       
        //     3: astore_2        /* lis */
        //     4: aload_3         /* k */
        //     5: invokestatic    kawa/lib/numbers.isZero:(Ljava/lang/Number;)Z
        //     8: ifeq            15
        //    11: aload_2         /* lis */
        //    12: goto            38
        //    15: aload_2         /* lis */
        //    16: ldc             Lgnu/lists/Pair;.class
        //    18: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    21: dup            
        //    22: astore          4
        //    24: checkcast       Lgnu/lists/Pair;
        //    27: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    30: aload_3         /* k */
        //    31: iconst_m1      
        //    32: invokestatic    gnu/math/IntNum.add:(Lgnu/math/IntNum;I)Lgnu/math/IntNum;
        //    35: goto            2
        //    38: areturn        
        //    39: new             Lgnu/mapping/WrongType;
        //    42: dup_x1         
        //    43: swap           
        //    44: ldc             "cdr"
        //    46: iconst_1       
        //    47: aload           4
        //    49: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //    52: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  24     27     39     53     Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public static Object take$Ex(final Object lis, final IntNum k) {
        if (numbers.isZero(k)) {
            return LList.Empty;
        }
        final Object force = Promise.force(drop(lis, IntNum.add(k, -1)), Pair.class);
        try {
            lists.setCdr$Ex((Pair)force, LList.Empty);
            return lis;
        }
        catch (ClassCastException ex) {
            throw new WrongType(ex, "set-cdr!", 1, force);
        }
    }
    
    public static Object takeRight(final Object lis, final IntNum k) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: aload_0         /* lis */
        //     2: aload_1         /* k */
        //     3: invokestatic    gnu/kawa/slib/srfi1.drop:(Ljava/lang/Object;Lgnu/math/IntNum;)Ljava/lang/Object;
        //     6: astore_3       
        //     7: astore_2        /* lag */
        //     8: aload_3         /* lead */
        //     9: invokestatic    kawa/lib/lists.isPair:(Ljava/lang/Object;)Z
        //    12: ifeq            48
        //    15: aload_2         /* lag */
        //    16: ldc             Lgnu/lists/Pair;.class
        //    18: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    21: dup            
        //    22: astore          4
        //    24: checkcast       Lgnu/lists/Pair;
        //    27: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    30: aload_3         /* lead */
        //    31: ldc             Lgnu/lists/Pair;.class
        //    33: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    36: dup            
        //    37: astore          4
        //    39: checkcast       Lgnu/lists/Pair;
        //    42: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    45: goto            6
        //    48: aload_2         /* lag */
        //    49: areturn        
        //    50: new             Lgnu/mapping/WrongType;
        //    53: dup_x1         
        //    54: swap           
        //    55: ldc             "cdr"
        //    57: iconst_1       
        //    58: aload           4
        //    60: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //    63: athrow         
        //    64: new             Lgnu/mapping/WrongType;
        //    67: dup_x1         
        //    68: swap           
        //    69: ldc             "cdr"
        //    71: iconst_1       
        //    72: aload           4
        //    74: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //    77: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  24     27     50     64     Ljava/lang/ClassCastException;
        //  39     42     64     78     Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public static Object dropRight(final Object lis, final IntNum k) {
        return lambda1recur(lis, drop(lis, k));
    }
    
    public static Object lambda1recur(final Object lag, final Object lead) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokestatic    kawa/lib/lists.isPair:(Ljava/lang/Object;)Z
        //     4: ifeq            58
        //     7: aload_0         /* lag */
        //     8: ldc             Lgnu/lists/Pair;.class
        //    10: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    13: dup            
        //    14: astore_2       
        //    15: checkcast       Lgnu/lists/Pair;
        //    18: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    21: aload_0         /* lag */
        //    22: ldc             Lgnu/lists/Pair;.class
        //    24: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    27: dup            
        //    28: astore_2       
        //    29: checkcast       Lgnu/lists/Pair;
        //    32: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    35: aload_1         /* lead */
        //    36: ldc             Lgnu/lists/Pair;.class
        //    38: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    41: dup            
        //    42: astore_2       
        //    43: checkcast       Lgnu/lists/Pair;
        //    46: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    49: invokestatic    gnu/kawa/slib/srfi1.lambda1recur:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    52: invokestatic    kawa/lib/lists.cons:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //    55: goto            61
        //    58: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
        //    61: areturn        
        //    62: new             Lgnu/mapping/WrongType;
        //    65: dup_x1         
        //    66: swap           
        //    67: ldc             "car"
        //    69: iconst_1       
        //    70: aload_2        
        //    71: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //    74: athrow         
        //    75: new             Lgnu/mapping/WrongType;
        //    78: dup_x1         
        //    79: swap           
        //    80: ldc             "cdr"
        //    82: iconst_1       
        //    83: aload_2        
        //    84: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //    87: athrow         
        //    88: new             Lgnu/mapping/WrongType;
        //    91: dup_x1         
        //    92: swap           
        //    93: ldc             "cdr"
        //    95: iconst_1       
        //    96: aload_2        
        //    97: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   100: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  15     18     62     75     Ljava/lang/ClassCastException;
        //  29     32     75     88     Ljava/lang/ClassCastException;
        //  43     46     88     101    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 53 out of bounds for length 53
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
    
    public static Object dropRight$Ex(final Object lis, final IntNum k) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: aload_1         /* k */
        //     2: invokestatic    gnu/kawa/slib/srfi1.drop:(Ljava/lang/Object;Lgnu/math/IntNum;)Ljava/lang/Object;
        //     5: astore_2        /* lead */
        //     6: aload_2         /* lead */
        //     7: invokestatic    kawa/lib/lists.isPair:(Ljava/lang/Object;)Z
        //    10: ifeq            95
        //    13: aload_0         /* lis */
        //    14: aload_2         /* lead */
        //    15: ldc             Lgnu/lists/Pair;.class
        //    17: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    20: dup            
        //    21: astore_3       
        //    22: checkcast       Lgnu/lists/Pair;
        //    25: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    28: astore          4
        //    30: astore_3        /* lag */
        //    31: aload           lead
        //    33: invokestatic    kawa/lib/lists.isPair:(Ljava/lang/Object;)Z
        //    36: ifeq            73
        //    39: aload_3         /* lag */
        //    40: ldc             Lgnu/lists/Pair;.class
        //    42: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    45: dup            
        //    46: astore          5
        //    48: checkcast       Lgnu/lists/Pair;
        //    51: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    54: aload           lead
        //    56: ldc             Lgnu/lists/Pair;.class
        //    58: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    61: dup            
        //    62: astore          5
        //    64: checkcast       Lgnu/lists/Pair;
        //    67: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    70: goto            28
        //    73: aload_3         /* lag */
        //    74: ldc             Lgnu/lists/Pair;.class
        //    76: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    79: dup            
        //    80: astore          5
        //    82: checkcast       Lgnu/lists/Pair;
        //    85: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
        //    88: invokestatic    kawa/lib/lists.setCdr$Ex:(Lgnu/lists/Pair;Ljava/lang/Object;)V
        //    91: aload_0         /* lis */
        //    92: goto            98
        //    95: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
        //    98: areturn        
        //    99: new             Lgnu/mapping/WrongType;
        //   102: dup_x1         
        //   103: swap           
        //   104: ldc             "cdr"
        //   106: iconst_1       
        //   107: aload_3        
        //   108: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   111: athrow         
        //   112: new             Lgnu/mapping/WrongType;
        //   115: dup_x1         
        //   116: swap           
        //   117: ldc             "cdr"
        //   119: iconst_1       
        //   120: aload           5
        //   122: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   125: athrow         
        //   126: new             Lgnu/mapping/WrongType;
        //   129: dup_x1         
        //   130: swap           
        //   131: ldc             "cdr"
        //   133: iconst_1       
        //   134: aload           5
        //   136: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   139: athrow         
        //   140: new             Lgnu/mapping/WrongType;
        //   143: dup_x1         
        //   144: swap           
        //   145: ldc             "set-cdr!"
        //   147: iconst_1       
        //   148: aload           5
        //   150: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   153: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  22     25     99     112    Ljava/lang/ClassCastException;
        //  48     51     112    126    Ljava/lang/ClassCastException;
        //  64     67     126    140    Ljava/lang/ClassCastException;
        //  82     85     140    154    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public static Object splitAt(final Object x, final IntNum k) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: aload_0         /* x */
        //     4: aload_1         /* k */
        //     5: astore          4
        //     7: astore_3       
        //     8: astore_2        /* prefix */
        //     9: aload           k
        //    11: invokestatic    kawa/lib/numbers.isZero:(Ljava/lang/Number;)Z
        //    14: ifeq            39
        //    17: aload_2         /* prefix */
        //    18: ldc             Lgnu/lists/LList;.class
        //    20: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    23: dup            
        //    24: astore          5
        //    26: checkcast       Lgnu/lists/LList;
        //    29: invokestatic    kawa/lib/lists.reverse$Ex:(Lgnu/lists/LList;)Lgnu/lists/LList;
        //    32: aload_3         /* suffix */
        //    33: invokestatic    gnu/mapping/Values.values2:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/mapping/Values$Values2;
        //    36: goto            82
        //    39: aload_3         /* suffix */
        //    40: ldc             Lgnu/lists/Pair;.class
        //    42: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    45: dup            
        //    46: astore          5
        //    48: checkcast       Lgnu/lists/Pair;
        //    51: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    54: aload_2         /* prefix */
        //    55: invokestatic    kawa/lib/lists.cons:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //    58: aload_3         /* suffix */
        //    59: ldc             Lgnu/lists/Pair;.class
        //    61: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    64: dup            
        //    65: astore          5
        //    67: checkcast       Lgnu/lists/Pair;
        //    70: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    73: aload           k
        //    75: iconst_m1      
        //    76: invokestatic    gnu/math/IntNum.add:(Lgnu/math/IntNum;I)Lgnu/math/IntNum;
        //    79: goto            5
        //    82: areturn        
        //    83: new             Lgnu/mapping/WrongType;
        //    86: dup_x1         
        //    87: swap           
        //    88: ldc             "reverse!"
        //    90: iconst_1       
        //    91: aload           5
        //    93: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //    96: athrow         
        //    97: new             Lgnu/mapping/WrongType;
        //   100: dup_x1         
        //   101: swap           
        //   102: ldc             "car"
        //   104: iconst_1       
        //   105: aload           5
        //   107: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   110: athrow         
        //   111: new             Lgnu/mapping/WrongType;
        //   114: dup_x1         
        //   115: swap           
        //   116: ldc             "cdr"
        //   118: iconst_1       
        //   119: aload           5
        //   121: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   124: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  26     29     83     97     Ljava/lang/ClassCastException;
        //  48     51     97     111    Ljava/lang/ClassCastException;
        //  67     70     111    125    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public static Object splitAt$Ex(final Object x, final IntNum k) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokestatic    kawa/lib/numbers.isZero:(Ljava/lang/Number;)Z
        //     4: ifeq            17
        //     7: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
        //    10: aload_0         /* x */
        //    11: invokestatic    gnu/mapping/Values.values2:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/mapping/Values$Values2;
        //    14: goto            66
        //    17: aload_0         /* x */
        //    18: aload_1         /* k */
        //    19: iconst_m1      
        //    20: invokestatic    gnu/math/IntNum.add:(Lgnu/math/IntNum;I)Lgnu/math/IntNum;
        //    23: invokestatic    gnu/kawa/slib/srfi1.drop:(Ljava/lang/Object;Lgnu/math/IntNum;)Ljava/lang/Object;
        //    26: astore_2        /* prev */
        //    27: aload_2         /* prev */
        //    28: ldc             Lgnu/lists/Pair;.class
        //    30: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    33: dup            
        //    34: astore          4
        //    36: checkcast       Lgnu/lists/Pair;
        //    39: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    42: astore_3        /* suffix */
        //    43: aload_2         /* prev */
        //    44: ldc             Lgnu/lists/Pair;.class
        //    46: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    49: dup            
        //    50: astore          4
        //    52: checkcast       Lgnu/lists/Pair;
        //    55: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
        //    58: invokestatic    kawa/lib/lists.setCdr$Ex:(Lgnu/lists/Pair;Ljava/lang/Object;)V
        //    61: aload_0         /* x */
        //    62: aload_3         /* suffix */
        //    63: invokestatic    gnu/mapping/Values.values2:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/mapping/Values$Values2;
        //    66: areturn        
        //    67: new             Lgnu/mapping/WrongType;
        //    70: dup_x1         
        //    71: swap           
        //    72: ldc             "cdr"
        //    74: iconst_1       
        //    75: aload           4
        //    77: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //    80: athrow         
        //    81: new             Lgnu/mapping/WrongType;
        //    84: dup_x1         
        //    85: swap           
        //    86: ldc             "set-cdr!"
        //    88: iconst_1       
        //    89: aload           4
        //    91: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //    94: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  36     39     67     81     Ljava/lang/ClassCastException;
        //  52     55     81     95     Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0066:
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
    
    public static Object last(final Object lis) {
        Object o2;
        final Object o = o2 = Promise.force(lis, Pair.class);
        Object o3;
        try {
            o3 = (o2 = Promise.force(lastPair((Pair)o), Pair.class));
            final Pair pair = (Pair)o3;
            return lists.car(pair);
        }
        catch (ClassCastException ex) {
            throw new WrongType(ex, "last-pair", 0, o2);
        }
        try {
            final Pair pair = (Pair)o3;
            return lists.car(pair);
        }
        catch (ClassCastException ex2) {
            throw new WrongType(ex2, "car", 1, o2);
        }
    }
    
    public static LList unzip1(final Object lis) {
        final Iterator iterator = Sequences.getIterator(lis);
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
    
    public static Object unzip2(final Object lis) {
        return lambda2recur(lis);
    }
    
    public static Object lambda2recur(final Object lis) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokestatic    gnu/kawa/slib/srfi1.isNullList:(Ljava/lang/Object;)Z
        //     4: ifeq            15
        //     7: aload_0         /* lis */
        //     8: aload_0         /* lis */
        //     9: invokestatic    gnu/mapping/Values.values2:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/mapping/Values$Values2;
        //    12: goto            108
        //    15: aload_0         /* lis */
        //    16: ldc             Lgnu/lists/Pair;.class
        //    18: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    21: dup            
        //    22: astore_2       
        //    23: checkcast       Lgnu/lists/Pair;
        //    26: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    29: astore_1        /* elt */
        //    30: aload_0         /* lis */
        //    31: ldc             Lgnu/lists/Pair;.class
        //    33: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    36: dup            
        //    37: astore_3       
        //    38: checkcast       Lgnu/lists/Pair;
        //    41: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    44: invokestatic    gnu/kawa/slib/srfi1.lambda2recur:(Ljava/lang/Object;)Ljava/lang/Object;
        //    47: astore_2       
        //    48: iconst_0       
        //    49: istore_3       
        //    50: aload_2        
        //    51: iload_3        
        //    52: invokestatic    gnu/mapping/Values.incrPos:(Ljava/lang/Object;I)I
        //    55: istore_3       
        //    56: aload_2        
        //    57: iload_3        
        //    58: invokestatic    gnu/mapping/Values.getFromPos:(Ljava/lang/Object;I)Ljava/lang/Object;
        //    61: astore          4
        //    63: aload_2        
        //    64: iload_3        
        //    65: invokestatic    gnu/mapping/Values.incrPos:(Ljava/lang/Object;I)I
        //    68: istore_3       
        //    69: aload_2        
        //    70: iload_3        
        //    71: invokestatic    gnu/mapping/Values.getFromPosFinal:(Ljava/lang/Object;I)Ljava/lang/Object;
        //    74: astore          b
        //    76: aload_1         /* elt */
        //    77: ldc             Lgnu/lists/Pair;.class
        //    79: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    82: dup            
        //    83: astore          6
        //    85: checkcast       Lgnu/lists/Pair;
        //    88: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    91: aload           a
        //    93: invokestatic    kawa/lib/lists.cons:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //    96: aload_1         /* elt */
        //    97: invokestatic    kawa/lib/lists.cadr:(Ljava/lang/Object;)Ljava/lang/Object;
        //   100: aload           b
        //   102: invokestatic    kawa/lib/lists.cons:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //   105: invokestatic    gnu/mapping/Values.values2:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/mapping/Values$Values2;
        //   108: areturn        
        //   109: new             Lgnu/mapping/WrongType;
        //   112: dup_x1         
        //   113: swap           
        //   114: ldc             "car"
        //   116: iconst_1       
        //   117: aload_2        
        //   118: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   121: athrow         
        //   122: new             Lgnu/mapping/WrongType;
        //   125: dup_x1         
        //   126: swap           
        //   127: ldc             "cdr"
        //   129: iconst_1       
        //   130: aload_3        
        //   131: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   134: athrow         
        //   135: new             Lgnu/mapping/WrongType;
        //   138: dup_x1         
        //   139: swap           
        //   140: ldc             "car"
        //   142: iconst_1       
        //   143: aload           6
        //   145: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   148: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  23     26     109    122    Ljava/lang/ClassCastException;
        //  38     41     122    135    Ljava/lang/ClassCastException;
        //  85     88     135    149    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public static Object unzip3(final Object lis) {
        return lambda3recur(lis);
    }
    
    public static Object lambda3recur(final Object lis) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokestatic    gnu/kawa/slib/srfi1.isNullList:(Ljava/lang/Object;)Z
        //     4: ifeq            29
        //     7: iconst_3       
        //     8: anewarray       Ljava/lang/Object;
        //    11: dup            
        //    12: iconst_0       
        //    13: aload_0         /* lis */
        //    14: aastore        
        //    15: dup            
        //    16: iconst_1       
        //    17: aload_0         /* lis */
        //    18: aastore        
        //    19: dup            
        //    20: iconst_2       
        //    21: aload_0         /* lis */
        //    22: aastore        
        //    23: invokestatic    gnu/mapping/Values.makeFromArray:([Ljava/lang/Object;)Lgnu/mapping/Values;
        //    26: goto            157
        //    29: aload_0         /* lis */
        //    30: ldc             Lgnu/lists/Pair;.class
        //    32: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    35: dup            
        //    36: astore_2       
        //    37: checkcast       Lgnu/lists/Pair;
        //    40: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    43: astore_1        /* elt */
        //    44: aload_0         /* lis */
        //    45: ldc             Lgnu/lists/Pair;.class
        //    47: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    50: dup            
        //    51: astore_3       
        //    52: checkcast       Lgnu/lists/Pair;
        //    55: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    58: invokestatic    gnu/kawa/slib/srfi1.lambda3recur:(Ljava/lang/Object;)Ljava/lang/Object;
        //    61: astore_2       
        //    62: iconst_0       
        //    63: istore_3       
        //    64: aload_2        
        //    65: iload_3        
        //    66: invokestatic    gnu/mapping/Values.incrPos:(Ljava/lang/Object;I)I
        //    69: istore_3       
        //    70: aload_2        
        //    71: iload_3        
        //    72: invokestatic    gnu/mapping/Values.getFromPos:(Ljava/lang/Object;I)Ljava/lang/Object;
        //    75: astore          4
        //    77: aload_2        
        //    78: iload_3        
        //    79: invokestatic    gnu/mapping/Values.incrPos:(Ljava/lang/Object;I)I
        //    82: istore_3       
        //    83: aload_2        
        //    84: iload_3        
        //    85: invokestatic    gnu/mapping/Values.getFromPos:(Ljava/lang/Object;I)Ljava/lang/Object;
        //    88: astore          5
        //    90: aload_2        
        //    91: iload_3        
        //    92: invokestatic    gnu/mapping/Values.incrPos:(Ljava/lang/Object;I)I
        //    95: istore_3       
        //    96: aload_2        
        //    97: iload_3        
        //    98: invokestatic    gnu/mapping/Values.getFromPosFinal:(Ljava/lang/Object;I)Ljava/lang/Object;
        //   101: astore          c
        //   103: iconst_3       
        //   104: anewarray       Ljava/lang/Object;
        //   107: dup            
        //   108: iconst_0       
        //   109: aload_1         /* elt */
        //   110: ldc             Lgnu/lists/Pair;.class
        //   112: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   115: dup            
        //   116: astore          7
        //   118: checkcast       Lgnu/lists/Pair;
        //   121: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   124: aload           a
        //   126: invokestatic    kawa/lib/lists.cons:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //   129: aastore        
        //   130: dup            
        //   131: iconst_1       
        //   132: aload_1         /* elt */
        //   133: invokestatic    kawa/lib/lists.cadr:(Ljava/lang/Object;)Ljava/lang/Object;
        //   136: aload           b
        //   138: invokestatic    kawa/lib/lists.cons:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //   141: aastore        
        //   142: dup            
        //   143: iconst_2       
        //   144: aload_1         /* elt */
        //   145: invokestatic    kawa/lib/lists.caddr:(Ljava/lang/Object;)Ljava/lang/Object;
        //   148: aload           c
        //   150: invokestatic    kawa/lib/lists.cons:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //   153: aastore        
        //   154: invokestatic    gnu/mapping/Values.makeFromArray:([Ljava/lang/Object;)Lgnu/mapping/Values;
        //   157: areturn        
        //   158: new             Lgnu/mapping/WrongType;
        //   161: dup_x1         
        //   162: swap           
        //   163: ldc             "car"
        //   165: iconst_1       
        //   166: aload_2        
        //   167: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   170: athrow         
        //   171: new             Lgnu/mapping/WrongType;
        //   174: dup_x1         
        //   175: swap           
        //   176: ldc             "cdr"
        //   178: iconst_1       
        //   179: aload_3        
        //   180: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   183: athrow         
        //   184: new             Lgnu/mapping/WrongType;
        //   187: dup_x1         
        //   188: swap           
        //   189: ldc             "car"
        //   191: iconst_1       
        //   192: aload           7
        //   194: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   197: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  37     40     158    171    Ljava/lang/ClassCastException;
        //  52     55     171    184    Ljava/lang/ClassCastException;
        //  118    121    184    198    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public static Object unzip4(final Object lis) {
        return lambda4recur(lis);
    }
    
    public static Object lambda4recur(final Object lis) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokestatic    gnu/kawa/slib/srfi1.isNullList:(Ljava/lang/Object;)Z
        //     4: ifeq            33
        //     7: iconst_4       
        //     8: anewarray       Ljava/lang/Object;
        //    11: dup            
        //    12: iconst_0       
        //    13: aload_0         /* lis */
        //    14: aastore        
        //    15: dup            
        //    16: iconst_1       
        //    17: aload_0         /* lis */
        //    18: aastore        
        //    19: dup            
        //    20: iconst_2       
        //    21: aload_0         /* lis */
        //    22: aastore        
        //    23: dup            
        //    24: iconst_3       
        //    25: aload_0         /* lis */
        //    26: aastore        
        //    27: invokestatic    gnu/mapping/Values.makeFromArray:([Ljava/lang/Object;)Lgnu/mapping/Values;
        //    30: goto            186
        //    33: aload_0         /* lis */
        //    34: ldc             Lgnu/lists/Pair;.class
        //    36: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    39: dup            
        //    40: astore_2       
        //    41: checkcast       Lgnu/lists/Pair;
        //    44: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    47: astore_1        /* elt */
        //    48: aload_0         /* lis */
        //    49: ldc             Lgnu/lists/Pair;.class
        //    51: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    54: dup            
        //    55: astore_3       
        //    56: checkcast       Lgnu/lists/Pair;
        //    59: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    62: invokestatic    gnu/kawa/slib/srfi1.lambda4recur:(Ljava/lang/Object;)Ljava/lang/Object;
        //    65: astore_2       
        //    66: iconst_0       
        //    67: istore_3       
        //    68: aload_2        
        //    69: iload_3        
        //    70: invokestatic    gnu/mapping/Values.incrPos:(Ljava/lang/Object;I)I
        //    73: istore_3       
        //    74: aload_2        
        //    75: iload_3        
        //    76: invokestatic    gnu/mapping/Values.getFromPos:(Ljava/lang/Object;I)Ljava/lang/Object;
        //    79: astore          4
        //    81: aload_2        
        //    82: iload_3        
        //    83: invokestatic    gnu/mapping/Values.incrPos:(Ljava/lang/Object;I)I
        //    86: istore_3       
        //    87: aload_2        
        //    88: iload_3        
        //    89: invokestatic    gnu/mapping/Values.getFromPos:(Ljava/lang/Object;I)Ljava/lang/Object;
        //    92: astore          5
        //    94: aload_2        
        //    95: iload_3        
        //    96: invokestatic    gnu/mapping/Values.incrPos:(Ljava/lang/Object;I)I
        //    99: istore_3       
        //   100: aload_2        
        //   101: iload_3        
        //   102: invokestatic    gnu/mapping/Values.getFromPos:(Ljava/lang/Object;I)Ljava/lang/Object;
        //   105: astore          6
        //   107: aload_2        
        //   108: iload_3        
        //   109: invokestatic    gnu/mapping/Values.incrPos:(Ljava/lang/Object;I)I
        //   112: istore_3       
        //   113: aload_2        
        //   114: iload_3        
        //   115: invokestatic    gnu/mapping/Values.getFromPosFinal:(Ljava/lang/Object;I)Ljava/lang/Object;
        //   118: astore          d
        //   120: iconst_4       
        //   121: anewarray       Ljava/lang/Object;
        //   124: dup            
        //   125: iconst_0       
        //   126: aload_1         /* elt */
        //   127: ldc             Lgnu/lists/Pair;.class
        //   129: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   132: dup            
        //   133: astore          8
        //   135: checkcast       Lgnu/lists/Pair;
        //   138: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   141: aload           a
        //   143: invokestatic    kawa/lib/lists.cons:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //   146: aastore        
        //   147: dup            
        //   148: iconst_1       
        //   149: aload_1         /* elt */
        //   150: invokestatic    kawa/lib/lists.cadr:(Ljava/lang/Object;)Ljava/lang/Object;
        //   153: aload           b
        //   155: invokestatic    kawa/lib/lists.cons:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //   158: aastore        
        //   159: dup            
        //   160: iconst_2       
        //   161: aload_1         /* elt */
        //   162: invokestatic    kawa/lib/lists.caddr:(Ljava/lang/Object;)Ljava/lang/Object;
        //   165: aload           c
        //   167: invokestatic    kawa/lib/lists.cons:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //   170: aastore        
        //   171: dup            
        //   172: iconst_3       
        //   173: aload_1         /* elt */
        //   174: invokestatic    kawa/lib/lists.cadddr:(Ljava/lang/Object;)Ljava/lang/Object;
        //   177: aload           d
        //   179: invokestatic    kawa/lib/lists.cons:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //   182: aastore        
        //   183: invokestatic    gnu/mapping/Values.makeFromArray:([Ljava/lang/Object;)Lgnu/mapping/Values;
        //   186: areturn        
        //   187: new             Lgnu/mapping/WrongType;
        //   190: dup_x1         
        //   191: swap           
        //   192: ldc             "car"
        //   194: iconst_1       
        //   195: aload_2        
        //   196: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   199: athrow         
        //   200: new             Lgnu/mapping/WrongType;
        //   203: dup_x1         
        //   204: swap           
        //   205: ldc             "cdr"
        //   207: iconst_1       
        //   208: aload_3        
        //   209: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   212: athrow         
        //   213: new             Lgnu/mapping/WrongType;
        //   216: dup_x1         
        //   217: swap           
        //   218: ldc             "car"
        //   220: iconst_1       
        //   221: aload           8
        //   223: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   226: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  41     44     187    200    Ljava/lang/ClassCastException;
        //  56     59     200    213    Ljava/lang/ClassCastException;
        //  135    138    213    227    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public static Object unzip5(final Object lis) {
        return lambda5recur(lis);
    }
    
    public static Object lambda5recur(final Object lis) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokestatic    gnu/kawa/slib/srfi1.isNullList:(Ljava/lang/Object;)Z
        //     4: ifeq            37
        //     7: iconst_5       
        //     8: anewarray       Ljava/lang/Object;
        //    11: dup            
        //    12: iconst_0       
        //    13: aload_0         /* lis */
        //    14: aastore        
        //    15: dup            
        //    16: iconst_1       
        //    17: aload_0         /* lis */
        //    18: aastore        
        //    19: dup            
        //    20: iconst_2       
        //    21: aload_0         /* lis */
        //    22: aastore        
        //    23: dup            
        //    24: iconst_3       
        //    25: aload_0         /* lis */
        //    26: aastore        
        //    27: dup            
        //    28: iconst_4       
        //    29: aload_0         /* lis */
        //    30: aastore        
        //    31: invokestatic    gnu/mapping/Values.makeFromArray:([Ljava/lang/Object;)Lgnu/mapping/Values;
        //    34: goto            229
        //    37: aload_0         /* lis */
        //    38: ldc             Lgnu/lists/Pair;.class
        //    40: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    43: dup            
        //    44: astore_2       
        //    45: checkcast       Lgnu/lists/Pair;
        //    48: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    51: astore_1        /* elt */
        //    52: aload_0         /* lis */
        //    53: ldc             Lgnu/lists/Pair;.class
        //    55: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    58: dup            
        //    59: astore_3       
        //    60: checkcast       Lgnu/lists/Pair;
        //    63: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    66: invokestatic    gnu/kawa/slib/srfi1.lambda5recur:(Ljava/lang/Object;)Ljava/lang/Object;
        //    69: astore_2       
        //    70: iconst_0       
        //    71: istore_3       
        //    72: aload_2        
        //    73: iload_3        
        //    74: invokestatic    gnu/mapping/Values.incrPos:(Ljava/lang/Object;I)I
        //    77: istore_3       
        //    78: aload_2        
        //    79: iload_3        
        //    80: invokestatic    gnu/mapping/Values.getFromPos:(Ljava/lang/Object;I)Ljava/lang/Object;
        //    83: astore          4
        //    85: aload_2        
        //    86: iload_3        
        //    87: invokestatic    gnu/mapping/Values.incrPos:(Ljava/lang/Object;I)I
        //    90: istore_3       
        //    91: aload_2        
        //    92: iload_3        
        //    93: invokestatic    gnu/mapping/Values.getFromPos:(Ljava/lang/Object;I)Ljava/lang/Object;
        //    96: astore          5
        //    98: aload_2        
        //    99: iload_3        
        //   100: invokestatic    gnu/mapping/Values.incrPos:(Ljava/lang/Object;I)I
        //   103: istore_3       
        //   104: aload_2        
        //   105: iload_3        
        //   106: invokestatic    gnu/mapping/Values.getFromPos:(Ljava/lang/Object;I)Ljava/lang/Object;
        //   109: astore          6
        //   111: aload_2        
        //   112: iload_3        
        //   113: invokestatic    gnu/mapping/Values.incrPos:(Ljava/lang/Object;I)I
        //   116: istore_3       
        //   117: aload_2        
        //   118: iload_3        
        //   119: invokestatic    gnu/mapping/Values.getFromPos:(Ljava/lang/Object;I)Ljava/lang/Object;
        //   122: astore          7
        //   124: aload_2        
        //   125: iload_3        
        //   126: invokestatic    gnu/mapping/Values.incrPos:(Ljava/lang/Object;I)I
        //   129: istore_3       
        //   130: aload_2        
        //   131: iload_3        
        //   132: invokestatic    gnu/mapping/Values.getFromPosFinal:(Ljava/lang/Object;I)Ljava/lang/Object;
        //   135: astore          e
        //   137: iconst_5       
        //   138: anewarray       Ljava/lang/Object;
        //   141: dup            
        //   142: iconst_0       
        //   143: aload_1         /* elt */
        //   144: ldc             Lgnu/lists/Pair;.class
        //   146: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   149: dup            
        //   150: astore          9
        //   152: checkcast       Lgnu/lists/Pair;
        //   155: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   158: aload           a
        //   160: invokestatic    kawa/lib/lists.cons:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //   163: aastore        
        //   164: dup            
        //   165: iconst_1       
        //   166: aload_1         /* elt */
        //   167: invokestatic    kawa/lib/lists.cadr:(Ljava/lang/Object;)Ljava/lang/Object;
        //   170: aload           b
        //   172: invokestatic    kawa/lib/lists.cons:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //   175: aastore        
        //   176: dup            
        //   177: iconst_2       
        //   178: aload_1         /* elt */
        //   179: invokestatic    kawa/lib/lists.caddr:(Ljava/lang/Object;)Ljava/lang/Object;
        //   182: aload           c
        //   184: invokestatic    kawa/lib/lists.cons:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //   187: aastore        
        //   188: dup            
        //   189: iconst_3       
        //   190: aload_1         /* elt */
        //   191: invokestatic    kawa/lib/lists.cadddr:(Ljava/lang/Object;)Ljava/lang/Object;
        //   194: aload           d
        //   196: invokestatic    kawa/lib/lists.cons:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //   199: aastore        
        //   200: dup            
        //   201: iconst_4       
        //   202: aload_1         /* elt */
        //   203: invokestatic    kawa/lib/lists.cddddr:(Ljava/lang/Object;)Ljava/lang/Object;
        //   206: ldc             Lgnu/lists/Pair;.class
        //   208: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   211: dup            
        //   212: astore          9
        //   214: checkcast       Lgnu/lists/Pair;
        //   217: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   220: aload           e
        //   222: invokestatic    kawa/lib/lists.cons:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //   225: aastore        
        //   226: invokestatic    gnu/mapping/Values.makeFromArray:([Ljava/lang/Object;)Lgnu/mapping/Values;
        //   229: areturn        
        //   230: new             Lgnu/mapping/WrongType;
        //   233: dup_x1         
        //   234: swap           
        //   235: ldc             "car"
        //   237: iconst_1       
        //   238: aload_2        
        //   239: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   242: athrow         
        //   243: new             Lgnu/mapping/WrongType;
        //   246: dup_x1         
        //   247: swap           
        //   248: ldc             "cdr"
        //   250: iconst_1       
        //   251: aload_3        
        //   252: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   255: athrow         
        //   256: new             Lgnu/mapping/WrongType;
        //   259: dup_x1         
        //   260: swap           
        //   261: ldc             "car"
        //   263: iconst_1       
        //   264: aload           9
        //   266: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   269: athrow         
        //   270: new             Lgnu/mapping/WrongType;
        //   273: dup_x1         
        //   274: swap           
        //   275: ldc             "car"
        //   277: iconst_1       
        //   278: aload           9
        //   280: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   283: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  45     48     230    243    Ljava/lang/ClassCastException;
        //  60     63     243    256    Ljava/lang/ClassCastException;
        //  152    155    256    270    Ljava/lang/ClassCastException;
        //  214    217    270    284    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public static Object append$Ex$V(final Object[] argsArray) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: iconst_0       
        //     2: invokestatic    gnu/lists/LList.makeList:([Ljava/lang/Object;I)Lgnu/lists/LList;
        //     5: dup            
        //     6: astore_2       
        //     7: astore_1        /* lists */
        //     8: aload_1         /* lists */
        //     9: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
        //    12: astore_3       
        //    13: astore_2        /* lists */
        //    14: aload_2         /* lists */
        //    15: invokestatic    kawa/lib/lists.isPair:(Ljava/lang/Object;)Z
        //    18: ifne            25
        //    21: aload_3         /* prev */
        //    22: goto            194
        //    25: aload_2         /* lists */
        //    26: ldc             Lgnu/lists/Pair;.class
        //    28: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    31: dup            
        //    32: astore          5
        //    34: checkcast       Lgnu/lists/Pair;
        //    37: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    40: astore          4
        //    42: aload_2         /* lists */
        //    43: ldc             Lgnu/lists/Pair;.class
        //    45: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    48: dup            
        //    49: astore          6
        //    51: checkcast       Lgnu/lists/Pair;
        //    54: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    57: astore          rest
        //    59: aload           first
        //    61: invokestatic    kawa/lib/lists.isPair:(Ljava/lang/Object;)Z
        //    64: ifne            74
        //    67: aload           rest
        //    69: aload           first
        //    71: goto            12
        //    74: aload           first
        //    76: ldc             Lgnu/lists/Pair;.class
        //    78: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    81: dup            
        //    82: astore          6
        //    84: checkcast       Lgnu/lists/Pair;
        //    87: invokestatic    gnu/kawa/slib/srfi1.lastPair:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    90: aload           rest
        //    92: astore          7
        //    94: astore          tail$Mncons
        //    96: aload           rest
        //    98: invokestatic    kawa/lib/lists.isPair:(Ljava/lang/Object;)Z
        //   101: ifeq            192
        //   104: aload           rest
        //   106: ldc             Lgnu/lists/Pair;.class
        //   108: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   111: dup            
        //   112: astore          9
        //   114: checkcast       Lgnu/lists/Pair;
        //   117: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   120: astore          8
        //   122: aload           rest
        //   124: ldc             Lgnu/lists/Pair;.class
        //   126: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   129: dup            
        //   130: astore          10
        //   132: checkcast       Lgnu/lists/Pair;
        //   135: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   138: astore          rest
        //   140: aload           tail$Mncons
        //   142: ldc             Lgnu/lists/Pair;.class
        //   144: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   147: dup            
        //   148: astore          10
        //   150: checkcast       Lgnu/lists/Pair;
        //   153: aload           next
        //   155: invokestatic    kawa/lib/lists.setCdr$Ex:(Lgnu/lists/Pair;Ljava/lang/Object;)V
        //   158: aload           next
        //   160: invokestatic    kawa/lib/lists.isPair:(Ljava/lang/Object;)Z
        //   163: ifeq            185
        //   166: aload           next
        //   168: ldc             Lgnu/lists/Pair;.class
        //   170: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   173: dup            
        //   174: astore          10
        //   176: checkcast       Lgnu/lists/Pair;
        //   179: invokestatic    gnu/kawa/slib/srfi1.lastPair:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   182: goto            187
        //   185: aload           tail$Mncons
        //   187: aload           rest
        //   189: goto            92
        //   192: aload           first
        //   194: areturn        
        //   195: new             Lgnu/mapping/WrongType;
        //   198: dup_x1         
        //   199: swap           
        //   200: ldc             "car"
        //   202: iconst_1       
        //   203: aload           5
        //   205: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   208: athrow         
        //   209: new             Lgnu/mapping/WrongType;
        //   212: dup_x1         
        //   213: swap           
        //   214: ldc             "cdr"
        //   216: iconst_1       
        //   217: aload           6
        //   219: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   222: athrow         
        //   223: new             Lgnu/mapping/WrongType;
        //   226: dup_x1         
        //   227: swap           
        //   228: ldc_w           "last-pair"
        //   231: iconst_0       
        //   232: aload           6
        //   234: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   237: athrow         
        //   238: new             Lgnu/mapping/WrongType;
        //   241: dup_x1         
        //   242: swap           
        //   243: ldc             "car"
        //   245: iconst_1       
        //   246: aload           9
        //   248: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   251: athrow         
        //   252: new             Lgnu/mapping/WrongType;
        //   255: dup_x1         
        //   256: swap           
        //   257: ldc             "cdr"
        //   259: iconst_1       
        //   260: aload           10
        //   262: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   265: athrow         
        //   266: new             Lgnu/mapping/WrongType;
        //   269: dup_x1         
        //   270: swap           
        //   271: ldc             "set-cdr!"
        //   273: iconst_1       
        //   274: aload           10
        //   276: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   279: athrow         
        //   280: new             Lgnu/mapping/WrongType;
        //   283: dup_x1         
        //   284: swap           
        //   285: ldc_w           "last-pair"
        //   288: iconst_0       
        //   289: aload           10
        //   291: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   294: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  34     37     195    209    Ljava/lang/ClassCastException;
        //  51     54     209    223    Ljava/lang/ClassCastException;
        //  84     87     223    238    Ljava/lang/ClassCastException;
        //  114    117    238    252    Ljava/lang/ClassCastException;
        //  132    135    252    266    Ljava/lang/ClassCastException;
        //  150    153    266    280    Ljava/lang/ClassCastException;
        //  176    179    280    295    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public static Object appendReverse(final Object rev$Mnhead, final Object tail) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: aload_1         /* tail */
        //     2: astore_3       
        //     3: astore_2        /* rev$Mnhead */
        //     4: aload_2         /* rev$Mnhead */
        //     5: invokestatic    gnu/kawa/slib/srfi1.isNullList:(Ljava/lang/Object;)Z
        //     8: ifeq            15
        //    11: aload_3         /* tail */
        //    12: goto            52
        //    15: aload_2         /* rev$Mnhead */
        //    16: ldc             Lgnu/lists/Pair;.class
        //    18: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    21: dup            
        //    22: astore          4
        //    24: checkcast       Lgnu/lists/Pair;
        //    27: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    30: aload_2         /* rev$Mnhead */
        //    31: ldc             Lgnu/lists/Pair;.class
        //    33: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    36: dup            
        //    37: astore          4
        //    39: checkcast       Lgnu/lists/Pair;
        //    42: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    45: aload_3         /* tail */
        //    46: invokestatic    kawa/lib/lists.cons:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //    49: goto            2
        //    52: areturn        
        //    53: new             Lgnu/mapping/WrongType;
        //    56: dup_x1         
        //    57: swap           
        //    58: ldc             "cdr"
        //    60: iconst_1       
        //    61: aload           4
        //    63: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //    66: athrow         
        //    67: new             Lgnu/mapping/WrongType;
        //    70: dup_x1         
        //    71: swap           
        //    72: ldc             "car"
        //    74: iconst_1       
        //    75: aload           4
        //    77: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //    80: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  24     27     53     67     Ljava/lang/ClassCastException;
        //  39     42     67     81     Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public static Object appendReverse$Ex(final Object rev$Mnhead, final Object tail) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: aload_1         /* tail */
        //     2: astore_3       
        //     3: astore_2        /* rev$Mnhead */
        //     4: aload_2         /* rev$Mnhead */
        //     5: invokestatic    gnu/kawa/slib/srfi1.isNullList:(Ljava/lang/Object;)Z
        //     8: ifeq            15
        //    11: aload_3         /* tail */
        //    12: goto            54
        //    15: aload_2         /* rev$Mnhead */
        //    16: ldc             Lgnu/lists/Pair;.class
        //    18: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    21: dup            
        //    22: astore          5
        //    24: checkcast       Lgnu/lists/Pair;
        //    27: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    30: astore          next$Mnrev
        //    32: aload_2         /* rev$Mnhead */
        //    33: ldc             Lgnu/lists/Pair;.class
        //    35: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    38: dup            
        //    39: astore          5
        //    41: checkcast       Lgnu/lists/Pair;
        //    44: aload_3         /* tail */
        //    45: invokestatic    kawa/lib/lists.setCdr$Ex:(Lgnu/lists/Pair;Ljava/lang/Object;)V
        //    48: aload           next$Mnrev
        //    50: aload_2         /* rev$Mnhead */
        //    51: goto            2
        //    54: areturn        
        //    55: new             Lgnu/mapping/WrongType;
        //    58: dup_x1         
        //    59: swap           
        //    60: ldc             "cdr"
        //    62: iconst_1       
        //    63: aload           5
        //    65: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //    68: athrow         
        //    69: new             Lgnu/mapping/WrongType;
        //    72: dup_x1         
        //    73: swap           
        //    74: ldc             "set-cdr!"
        //    76: iconst_1       
        //    77: aload           5
        //    79: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //    82: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  24     27     55     69     Ljava/lang/ClassCastException;
        //  41     44     69     83     Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public static Object concatenate(final Object lists) {
        return reduceRight(append.append, LList.Empty, lists);
    }
    
    public static Object reduceRight(final Procedure f, final Object ridentity, final Object lis) {
        public class srfi1$frame1 extends ModuleBody
        {
            Procedure f;
            
            public Object lambda10recur(final Object head, final Object lis) {
                // 
                // This method could not be decompiled.
                // 
                // Original Bytecode:
                // 
                //     1: invokestatic    kawa/lib/lists.isPair:(Ljava/lang/Object;)Z
                //     4: ifeq            50
                //     7: aload_0         /* this */
                //     8: getfield        gnu/kawa/slib/srfi1$frame1.f:Lgnu/mapping/Procedure;
                //    11: aload_1         /* head */
                //    12: aload_0         /* this */
                //    13: aload_2         /* lis */
                //    14: ldc             Lgnu/lists/Pair;.class
                //    16: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //    19: dup            
                //    20: astore_3       
                //    21: checkcast       Lgnu/lists/Pair;
                //    24: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
                //    27: aload_2         /* lis */
                //    28: ldc             Lgnu/lists/Pair;.class
                //    30: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //    33: dup            
                //    34: astore_3       
                //    35: checkcast       Lgnu/lists/Pair;
                //    38: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
                //    41: invokevirtual   gnu/kawa/slib/srfi1$frame1.lambda10recur:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                //    44: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                //    47: goto            51
                //    50: aload_1         /* head */
                //    51: areturn        
                //    52: new             Lgnu/mapping/WrongType;
                //    55: dup_x1         
                //    56: swap           
                //    57: ldc             "car"
                //    59: iconst_1       
                //    60: aload_3        
                //    61: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //    64: athrow         
                //    65: new             Lgnu/mapping/WrongType;
                //    68: dup_x1         
                //    69: swap           
                //    70: ldc             "cdr"
                //    72: iconst_1       
                //    73: aload_3        
                //    74: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //    77: athrow         
                //    Exceptions:
                //  Try           Handler
                //  Start  End    Start  End    Type                          
                //  -----  -----  -----  -----  ------------------------------
                //  21     24     52     65     Ljava/lang/ClassCastException;
                //  35     38     65     78     Ljava/lang/ClassCastException;
                // 
                // The error that occurred was:
                // 
                // java.lang.IllegalStateException: Expression is linked from several locations: Label_0050:
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
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: dup            
        //     4: invokespecial   gnu/kawa/slib/srfi1$frame1.<init>:()V
        //     7: astore_3        /* $heapFrame */
        //     8: aload_3         /* $heapFrame */
        //     9: aload_0         /* f */
        //    10: putfield        gnu/kawa/slib/srfi1$frame1.f:Lgnu/mapping/Procedure;
        //    13: aload_2         /* lis */
        //    14: invokestatic    gnu/kawa/slib/srfi1.isNullList:(Ljava/lang/Object;)Z
        //    17: ifeq            24
        //    20: aload_1         /* ridentity */
        //    21: goto            58
        //    24: aload_3         /* $heapFrame */
        //    25: aload_2         /* lis */
        //    26: ldc             Lgnu/lists/Pair;.class
        //    28: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    31: dup            
        //    32: astore          4
        //    34: checkcast       Lgnu/lists/Pair;
        //    37: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    40: aload_2         /* lis */
        //    41: ldc             Lgnu/lists/Pair;.class
        //    43: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    46: dup            
        //    47: astore          4
        //    49: checkcast       Lgnu/lists/Pair;
        //    52: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    55: invokevirtual   gnu/kawa/slib/srfi1$frame1.lambda10recur:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    58: areturn        
        //    59: new             Lgnu/mapping/WrongType;
        //    62: dup_x1         
        //    63: swap           
        //    64: ldc             "car"
        //    66: iconst_1       
        //    67: aload           4
        //    69: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //    72: athrow         
        //    73: new             Lgnu/mapping/WrongType;
        //    76: dup_x1         
        //    77: swap           
        //    78: ldc             "cdr"
        //    80: iconst_1       
        //    81: aload           4
        //    83: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //    86: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  34     37     59     73     Ljava/lang/ClassCastException;
        //  49     52     73     87     Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0058:
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
    
    public static Object concatenate$Ex(final Object lists) {
        return reduceRight(srfi1.append$Ex, LList.Empty, lists);
    }
    
    public static Object count$V(final Procedure pred, final Object list1, final Object[] argsArray) {
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
        //    13: ifeq            140
        //    16: aload_1         /* list1 */
        //    17: aload_3         /* lists */
        //    18: getstatic       gnu/kawa/slib/srfi1.Lit0:Lgnu/math/IntNum;
        //    21: astore          6
        //    23: astore          5
        //    25: astore          list1
        //    27: aload           list1
        //    29: invokestatic    gnu/kawa/slib/srfi1.isNullList:(Ljava/lang/Object;)Z
        //    32: ifeq            40
        //    35: aload           i
        //    37: goto            220
        //    40: aload           lists
        //    42: invokestatic    gnu/kawa/slib/srfi1.$PcCars$PlCdrs$SlPair:(Ljava/lang/Object;)Lgnu/lists/Pair;
        //    45: astore          split
        //    47: aload           split
        //    49: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    52: astore          a$Mns
        //    54: aload           split
        //    56: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    59: astore          d$Mns
        //    61: aload           a$Mns
        //    63: invokestatic    kawa/lib/lists.isNull:(Ljava/lang/Object;)Z
        //    66: ifeq            74
        //    69: aload           i
        //    71: goto            220
        //    74: aload           list1
        //    76: ldc             Lgnu/lists/Pair;.class
        //    78: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    81: dup            
        //    82: astore          10
        //    84: checkcast       Lgnu/lists/Pair;
        //    87: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    90: aload           d$Mns
        //    92: getstatic       kawa/standard/Scheme.apply:Lgnu/kawa/functions/Apply;
        //    95: aload_0         /* pred */
        //    96: aload           list1
        //    98: ldc             Lgnu/lists/Pair;.class
        //   100: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   103: dup            
        //   104: astore          10
        //   106: checkcast       Lgnu/lists/Pair;
        //   109: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   112: aload           a$Mns
        //   114: invokevirtual   gnu/mapping/Procedure.apply3:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   117: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //   120: ifeq            135
        //   123: iconst_1       
        //   124: aload           i
        //   126: getstatic       gnu/kawa/slib/srfi1.Lit1:Lgnu/math/IntNum;
        //   129: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   132: goto            21
        //   135: aload           i
        //   137: goto            21
        //   140: aload_1         /* list1 */
        //   141: getstatic       gnu/kawa/slib/srfi1.Lit0:Lgnu/math/IntNum;
        //   144: astore          5
        //   146: astore          lis
        //   148: aload           lis
        //   150: invokestatic    gnu/kawa/slib/srfi1.isNullList:(Ljava/lang/Object;)Z
        //   153: ifeq            161
        //   156: aload           i
        //   158: goto            220
        //   161: aload           lis
        //   163: ldc             Lgnu/lists/Pair;.class
        //   165: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   168: dup            
        //   169: astore          6
        //   171: checkcast       Lgnu/lists/Pair;
        //   174: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   177: aload_0         /* pred */
        //   178: aload           lis
        //   180: ldc             Lgnu/lists/Pair;.class
        //   182: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   185: dup            
        //   186: astore          6
        //   188: checkcast       Lgnu/lists/Pair;
        //   191: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   194: invokevirtual   gnu/mapping/Procedure.apply1:(Ljava/lang/Object;)Ljava/lang/Object;
        //   197: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //   200: ifeq            215
        //   203: iconst_1       
        //   204: aload           i
        //   206: getstatic       gnu/kawa/slib/srfi1.Lit1:Lgnu/math/IntNum;
        //   209: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   212: goto            144
        //   215: aload           i
        //   217: goto            144
        //   220: areturn        
        //   221: new             Lgnu/mapping/WrongType;
        //   224: dup_x1         
        //   225: swap           
        //   226: ldc             "cdr"
        //   228: iconst_1       
        //   229: aload           10
        //   231: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   234: athrow         
        //   235: new             Lgnu/mapping/WrongType;
        //   238: dup_x1         
        //   239: swap           
        //   240: ldc             "car"
        //   242: iconst_1       
        //   243: aload           10
        //   245: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   248: athrow         
        //   249: new             Lgnu/mapping/WrongType;
        //   252: dup_x1         
        //   253: swap           
        //   254: ldc             "cdr"
        //   256: iconst_1       
        //   257: aload           6
        //   259: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   262: athrow         
        //   263: new             Lgnu/mapping/WrongType;
        //   266: dup_x1         
        //   267: swap           
        //   268: ldc             "car"
        //   270: iconst_1       
        //   271: aload           6
        //   273: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   276: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  84     87     221    235    Ljava/lang/ClassCastException;
        //  106    109    235    249    Ljava/lang/ClassCastException;
        //  171    174    249    263    Ljava/lang/ClassCastException;
        //  188    191    263    277    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    static Pair $PcCars$PlCdrs$SlPair(final Object lists) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokestatic    gnu/kawa/slib/srfi1.$PcCars$PlCdrs:(Ljava/lang/Object;)Ljava/lang/Object;
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
    
    public static Object unfoldRight(final Procedure p4, final Procedure f, final Procedure g, final Object seed) {
        return unfoldRight(p4, f, g, seed, LList.Empty);
    }
    
    public static Object unfoldRight(final Procedure p, final Procedure f, final Procedure g, final Object seed, final Object maybe$Mntail) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: aload           maybe$Mntail
        //     3: astore          6
        //     5: astore          seed
        //     7: aload_0         /* p */
        //     8: aload           seed
        //    10: invokevirtual   gnu/mapping/Procedure.apply1:(Ljava/lang/Object;)Ljava/lang/Object;
        //    13: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //    16: ifeq            24
        //    19: aload           ans
        //    21: goto            44
        //    24: aload_2         /* g */
        //    25: aload           seed
        //    27: invokevirtual   gnu/mapping/Procedure.apply1:(Ljava/lang/Object;)Ljava/lang/Object;
        //    30: aload_1         /* f */
        //    31: aload           seed
        //    33: invokevirtual   gnu/mapping/Procedure.apply1:(Ljava/lang/Object;)Ljava/lang/Object;
        //    36: aload           ans
        //    38: invokestatic    kawa/lib/lists.cons:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //    41: goto            3
        //    44: areturn        
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public static Object unfold$V(final Procedure p, final Procedure f, final Procedure g, final Object seed, final Object[] argsArray) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     2: iconst_0       
        //     3: invokestatic    gnu/lists/LList.makeList:([Ljava/lang/Object;I)Lgnu/lists/LList;
        //     6: dup            
        //     7: astore          6
        //     9: astore          maybe$Mntail$Mngen
        //    11: aload           maybe$Mntail$Mngen
        //    13: invokestatic    kawa/lib/lists.isPair:(Ljava/lang/Object;)Z
        //    16: ifeq            162
        //    19: aload           maybe$Mntail$Mngen
        //    21: dup            
        //    22: astore          7
        //    24: checkcast       Lgnu/lists/Pair;
        //    27: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    30: astore          tail$Mngen
        //    32: aload           maybe$Mntail$Mngen
        //    34: dup            
        //    35: astore          7
        //    37: checkcast       Lgnu/lists/Pair;
        //    40: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    43: invokestatic    kawa/lib/lists.isPair:(Ljava/lang/Object;)Z
        //    46: ifeq            104
        //    49: getstatic       kawa/standard/Scheme.apply:Lgnu/kawa/functions/Apply;
        //    52: bipush          8
        //    54: anewarray       Ljava/lang/Object;
        //    57: dup            
        //    58: iconst_0       
        //    59: getstatic       kawa/lib/exceptions.error:Lgnu/expr/ModuleMethod;
        //    62: aastore        
        //    63: dup            
        //    64: iconst_1       
        //    65: ldc_w           "Too many arguments"
        //    68: aastore        
        //    69: dup            
        //    70: iconst_2       
        //    71: getstatic       gnu/kawa/slib/srfi1.unfold:Lgnu/expr/ModuleMethod;
        //    74: aastore        
        //    75: dup            
        //    76: iconst_3       
        //    77: aload_0         /* p */
        //    78: aastore        
        //    79: dup            
        //    80: iconst_4       
        //    81: aload_1         /* f */
        //    82: aastore        
        //    83: dup            
        //    84: iconst_5       
        //    85: aload_2         /* g */
        //    86: aastore        
        //    87: dup            
        //    88: bipush          6
        //    90: aload_3         /* seed */
        //    91: aastore        
        //    92: dup            
        //    93: bipush          7
        //    95: aload           maybe$Mntail$Mngen
        //    97: aastore        
        //    98: invokevirtual   gnu/mapping/Procedure.applyN:([Ljava/lang/Object;)Ljava/lang/Object;
        //   101: goto            221
        //   104: aload_3         /* seed */
        //   105: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
        //   108: astore          8
        //   110: astore          seed
        //   112: aload_0         /* p */
        //   113: aload           seed
        //   115: invokevirtual   gnu/mapping/Procedure.apply1:(Ljava/lang/Object;)Ljava/lang/Object;
        //   118: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //   121: ifeq            142
        //   124: aload           res
        //   126: getstatic       kawa/standard/Scheme.applyToArgs:Lgnu/kawa/functions/ApplyToArgs;
        //   129: aload           tail$Mngen
        //   131: aload           seed
        //   133: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   136: invokestatic    gnu/kawa/slib/srfi1.appendReverse$Ex:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   139: goto            221
        //   142: aload_2         /* g */
        //   143: aload           seed
        //   145: invokevirtual   gnu/mapping/Procedure.apply1:(Ljava/lang/Object;)Ljava/lang/Object;
        //   148: aload_1         /* f */
        //   149: aload           seed
        //   151: invokevirtual   gnu/mapping/Procedure.apply1:(Ljava/lang/Object;)Ljava/lang/Object;
        //   154: aload           res
        //   156: invokestatic    kawa/lib/lists.cons:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //   159: goto            108
        //   162: aload_3         /* seed */
        //   163: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
        //   166: astore          7
        //   168: astore          seed
        //   170: aload_0         /* p */
        //   171: aload           seed
        //   173: invokevirtual   gnu/mapping/Procedure.apply1:(Ljava/lang/Object;)Ljava/lang/Object;
        //   176: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //   179: ifeq            201
        //   182: aload           res
        //   184: ldc             Lgnu/lists/LList;.class
        //   186: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   189: dup            
        //   190: astore          8
        //   192: checkcast       Lgnu/lists/LList;
        //   195: invokestatic    kawa/lib/lists.reverse$Ex:(Lgnu/lists/LList;)Lgnu/lists/LList;
        //   198: goto            221
        //   201: aload_2         /* g */
        //   202: aload           seed
        //   204: invokevirtual   gnu/mapping/Procedure.apply1:(Ljava/lang/Object;)Ljava/lang/Object;
        //   207: aload_1         /* f */
        //   208: aload           seed
        //   210: invokevirtual   gnu/mapping/Procedure.apply1:(Ljava/lang/Object;)Ljava/lang/Object;
        //   213: aload           res
        //   215: invokestatic    kawa/lib/lists.cons:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //   218: goto            166
        //   221: areturn        
        //   222: new             Lgnu/mapping/WrongType;
        //   225: dup_x1         
        //   226: swap           
        //   227: ldc             "car"
        //   229: iconst_1       
        //   230: aload           7
        //   232: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   235: athrow         
        //   236: new             Lgnu/mapping/WrongType;
        //   239: dup_x1         
        //   240: swap           
        //   241: ldc             "cdr"
        //   243: iconst_1       
        //   244: aload           7
        //   246: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   249: athrow         
        //   250: new             Lgnu/mapping/WrongType;
        //   253: dup_x1         
        //   254: swap           
        //   255: ldc             "reverse!"
        //   257: iconst_1       
        //   258: aload           8
        //   260: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   263: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  24     27     222    236    Ljava/lang/ClassCastException;
        //  37     40     236    250    Ljava/lang/ClassCastException;
        //  192    195    250    264    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public static Object fold$V(final Procedure kons, final Object knil, final Object lis1, final Object[] argsArray) {
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
        //    15: ifeq            104
        //    18: aload_2         /* lis1 */
        //    19: aload           lists
        //    21: invokestatic    kawa/lib/lists.cons:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //    24: aload_1         /* knil */
        //    25: astore          6
        //    27: astore          lists
        //    29: aload           lists
        //    31: aload           ans
        //    33: invokestatic    gnu/kawa/slib/srfi1.$PcCars$PlCdrs$Pl:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    36: astore          7
        //    38: iconst_0       
        //    39: istore          8
        //    41: aload           7
        //    43: iload           8
        //    45: invokestatic    gnu/mapping/Values.incrPos:(Ljava/lang/Object;I)I
        //    48: istore          8
        //    50: aload           7
        //    52: iload           8
        //    54: invokestatic    gnu/mapping/Values.getFromPos:(Ljava/lang/Object;I)Ljava/lang/Object;
        //    57: astore          9
        //    59: aload           7
        //    61: iload           8
        //    63: invokestatic    gnu/mapping/Values.incrPos:(Ljava/lang/Object;I)I
        //    66: istore          8
        //    68: aload           7
        //    70: iload           8
        //    72: invokestatic    gnu/mapping/Values.getFromPosFinal:(Ljava/lang/Object;I)Ljava/lang/Object;
        //    75: astore          cdrs
        //    77: aload           cars$Plans
        //    79: invokestatic    kawa/lib/lists.isNull:(Ljava/lang/Object;)Z
        //    82: ifeq            90
        //    85: aload           ans
        //    87: goto            164
        //    90: aload           cdrs
        //    92: getstatic       kawa/standard/Scheme.apply:Lgnu/kawa/functions/Apply;
        //    95: aload_0         /* kons */
        //    96: aload           cars$Plans
        //    98: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   101: goto            25
        //   104: aload_2         /* lis1 */
        //   105: aload_1         /* knil */
        //   106: astore          6
        //   108: astore          lis
        //   110: aload           lis
        //   112: invokestatic    gnu/kawa/slib/srfi1.isNullList:(Ljava/lang/Object;)Z
        //   115: ifeq            123
        //   118: aload           ans
        //   120: goto            164
        //   123: aload           lis
        //   125: ldc             Lgnu/lists/Pair;.class
        //   127: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   130: dup            
        //   131: astore          7
        //   133: checkcast       Lgnu/lists/Pair;
        //   136: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   139: aload_0         /* kons */
        //   140: aload           lis
        //   142: ldc             Lgnu/lists/Pair;.class
        //   144: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   147: dup            
        //   148: astore          7
        //   150: checkcast       Lgnu/lists/Pair;
        //   153: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   156: aload           ans
        //   158: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   161: goto            106
        //   164: areturn        
        //   165: new             Lgnu/mapping/WrongType;
        //   168: dup_x1         
        //   169: swap           
        //   170: ldc             "cdr"
        //   172: iconst_1       
        //   173: aload           7
        //   175: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   178: athrow         
        //   179: new             Lgnu/mapping/WrongType;
        //   182: dup_x1         
        //   183: swap           
        //   184: ldc             "car"
        //   186: iconst_1       
        //   187: aload           7
        //   189: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   192: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  133    136    165    179    Ljava/lang/ClassCastException;
        //  150    153    179    193    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    static Object $PcCars$PlCdrs$Pl(final Object lists, final Object carsFinal) {
        public class srfi1$frame38 extends ModuleBody
        {
            Object cars$Mnfinal;
        }
        final srfi1$frame38 $heapFrame = new srfi1$frame38();
        $heapFrame.cars$Mnfinal = carsFinal;
        final CallContext $ctx;
        final Continuation cont = new Continuation($ctx = CallContext.getInstance());
        Object handleException = null;
        try {
            final Continuation abort = cont;
            public class srfi1$frame39 extends ModuleBody
            {
                Continuation abort;
                srfi1$frame38 staticLink;
                
                public Object lambda49recur(final Object lists) {
                    // 
                    // This method could not be decompiled.
                    // 
                    // Original Bytecode:
                    // 
                    //     1: invokestatic    kawa/lib/lists.isPair:(Ljava/lang/Object;)Z
                    //     4: ifeq            177
                    //     7: aload_1         /* lists */
                    //     8: invokestatic    gnu/kawa/slib/srfi1.car$PlCdr:(Ljava/lang/Object;)Lgnu/mapping/Values;
                    //    11: astore_2       
                    //    12: iconst_0       
                    //    13: istore_3       
                    //    14: aload_2        
                    //    15: iload_3        
                    //    16: invokestatic    gnu/mapping/Values.incrPos:(Ljava/lang/Object;I)I
                    //    19: istore_3       
                    //    20: aload_2        
                    //    21: iload_3        
                    //    22: invokestatic    gnu/mapping/Values.getFromPos:(Ljava/lang/Object;I)Ljava/lang/Object;
                    //    25: astore          4
                    //    27: aload_2        
                    //    28: iload_3        
                    //    29: invokestatic    gnu/mapping/Values.incrPos:(Ljava/lang/Object;I)I
                    //    32: istore_3       
                    //    33: aload_2        
                    //    34: iload_3        
                    //    35: invokestatic    gnu/mapping/Values.getFromPosFinal:(Ljava/lang/Object;I)Ljava/lang/Object;
                    //    38: astore          other$Mnlists
                    //    40: aload           list
                    //    42: invokestatic    gnu/kawa/slib/srfi1.isNullList:(Ljava/lang/Object;)Z
                    //    45: ifeq            64
                    //    48: aload_0         /* this */
                    //    49: getfield        gnu/kawa/slib/srfi1$frame39.abort:Lkawa/lang/Continuation;
                    //    52: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
                    //    55: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
                    //    58: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                    //    61: goto            193
                    //    64: aload           list
                    //    66: invokestatic    gnu/kawa/slib/srfi1.car$PlCdr:(Ljava/lang/Object;)Lgnu/mapping/Values;
                    //    69: astore          6
                    //    71: iconst_0       
                    //    72: istore          7
                    //    74: aload           6
                    //    76: iload           7
                    //    78: invokestatic    gnu/mapping/Values.incrPos:(Ljava/lang/Object;I)I
                    //    81: istore          7
                    //    83: aload           6
                    //    85: iload           7
                    //    87: invokestatic    gnu/mapping/Values.getFromPos:(Ljava/lang/Object;I)Ljava/lang/Object;
                    //    90: astore          8
                    //    92: aload           6
                    //    94: iload           7
                    //    96: invokestatic    gnu/mapping/Values.incrPos:(Ljava/lang/Object;I)I
                    //    99: istore          7
                    //   101: aload           6
                    //   103: iload           7
                    //   105: invokestatic    gnu/mapping/Values.getFromPosFinal:(Ljava/lang/Object;I)Ljava/lang/Object;
                    //   108: astore          d
                    //   110: aload_0         /* this */
                    //   111: aload           other$Mnlists
                    //   113: invokevirtual   gnu/kawa/slib/srfi1$frame39.lambda49recur:(Ljava/lang/Object;)Ljava/lang/Object;
                    //   116: astore          10
                    //   118: iconst_0       
                    //   119: istore          11
                    //   121: aload           10
                    //   123: iload           11
                    //   125: invokestatic    gnu/mapping/Values.incrPos:(Ljava/lang/Object;I)I
                    //   128: istore          11
                    //   130: aload           10
                    //   132: iload           11
                    //   134: invokestatic    gnu/mapping/Values.getFromPos:(Ljava/lang/Object;I)Ljava/lang/Object;
                    //   137: astore          12
                    //   139: aload           10
                    //   141: iload           11
                    //   143: invokestatic    gnu/mapping/Values.incrPos:(Ljava/lang/Object;I)I
                    //   146: istore          11
                    //   148: aload           10
                    //   150: iload           11
                    //   152: invokestatic    gnu/mapping/Values.getFromPosFinal:(Ljava/lang/Object;I)Ljava/lang/Object;
                    //   155: astore          cdrs
                    //   157: aload           a
                    //   159: aload           cars
                    //   161: invokestatic    kawa/lib/lists.cons:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
                    //   164: aload           d
                    //   166: aload           cdrs
                    //   168: invokestatic    kawa/lib/lists.cons:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
                    //   171: invokestatic    gnu/mapping/Values.values2:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/mapping/Values$Values2;
                    //   174: goto            193
                    //   177: aload_0         /* this */
                    //   178: getfield        gnu/kawa/slib/srfi1$frame39.staticLink:Lgnu/kawa/slib/srfi1$frame38;
                    //   181: getfield        gnu/kawa/slib/srfi1$frame38.cars$Mnfinal:Ljava/lang/Object;
                    //   184: invokestatic    gnu/lists/LList.list1:(Ljava/lang/Object;)Lgnu/lists/Pair;
                    //   187: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
                    //   190: invokestatic    gnu/mapping/Values.values2:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/mapping/Values$Values2;
                    //   193: areturn        
                    // 
                    // The error that occurred was:
                    // 
                    // java.lang.NullPointerException
                    // 
                    throw new IllegalStateException("An error occurred while decompiling this method.");
                }
            }
            final srfi1$frame39 srfi1$frame39 = new srfi1$frame39();
            srfi1$frame39.staticLink = $heapFrame;
            final srfi1$frame39 $heapFrame2 = srfi1$frame39;
            $heapFrame2.abort = abort;
            $heapFrame2.lambda49recur(lists);
            cont.invoked = true;
        }
        finally {
            handleException = Continuation.handleException(loadexception(java.lang.Throwable.class), cont);
        }
        return handleException;
    }
    
    public static Object foldRight$V(final Procedure kons, final Object knil, final Object lis1, final Object[] argsArray) {
        public class srfi1$frame extends ModuleBody
        {
            Procedure kons;
            Object knil;
            
            public Object lambda6recur(final Object lists) {
                final Object cdrs = srfi1.$PcCdrs(lists);
                return lists.isNull(cdrs) ? this.knil : Scheme.apply.apply2(this.kons, srfi1.$PcCars$Pl(lists, this.lambda6recur(cdrs)));
            }
            
            public Object lambda7recur(final Object lis) {
                // 
                // This method could not be decompiled.
                // 
                // Original Bytecode:
                // 
                //     1: invokestatic    gnu/kawa/slib/srfi1.isNullList:(Ljava/lang/Object;)Z
                //     4: ifeq            14
                //     7: aload_0         /* this */
                //     8: getfield        gnu/kawa/slib/srfi1$frame.knil:Ljava/lang/Object;
                //    11: goto            55
                //    14: aload_1         /* lis */
                //    15: ldc             Lgnu/lists/Pair;.class
                //    17: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //    20: dup            
                //    21: astore_3       
                //    22: checkcast       Lgnu/lists/Pair;
                //    25: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
                //    28: astore_2        /* head */
                //    29: aload_0         /* this */
                //    30: getfield        gnu/kawa/slib/srfi1$frame.kons:Lgnu/mapping/Procedure;
                //    33: aload_2         /* head */
                //    34: aload_0         /* this */
                //    35: aload_1         /* lis */
                //    36: ldc             Lgnu/lists/Pair;.class
                //    38: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //    41: dup            
                //    42: astore_3       
                //    43: checkcast       Lgnu/lists/Pair;
                //    46: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
                //    49: invokevirtual   gnu/kawa/slib/srfi1$frame.lambda7recur:(Ljava/lang/Object;)Ljava/lang/Object;
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
        final srfi1$frame $heapFrame = new srfi1$frame();
        $heapFrame.kons = kons;
        $heapFrame.knil = knil;
        final LList lists = LList.makeList(argsArray, 0);
        return kawa.lib.lists.isPair(lists) ? $heapFrame.lambda6recur(kawa.lib.lists.cons(lis1, lists)) : $heapFrame.lambda7recur(lis1);
    }
    
    static Object $PcCdrs(final Object lists) {
        final CallContext $ctx;
        final Continuation cont = new Continuation($ctx = CallContext.getInstance());
        Object handleException = null;
        try {
            final Continuation abort = cont;
            public class srfi1$frame35 extends ModuleBody
            {
                Continuation abort;
                
                public Object lambda46recur(final Object lists) {
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
                    //    23: invokestatic    gnu/kawa/slib/srfi1.isNullList:(Ljava/lang/Object;)Z
                    //    26: ifeq            42
                    //    29: aload_0         /* this */
                    //    30: getfield        gnu/kawa/slib/srfi1$frame35.abort:Lkawa/lang/Continuation;
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
                    //    71: invokevirtual   gnu/kawa/slib/srfi1$frame35.lambda46recur:(Ljava/lang/Object;)Ljava/lang/Object;
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
            final srfi1$frame35 $heapFrame = new srfi1$frame35();
            $heapFrame.abort = abort;
            $heapFrame.lambda46recur(lists);
            cont.invoked = true;
        }
        finally {
            handleException = Continuation.handleException(loadexception(java.lang.Throwable.class), cont);
        }
        return handleException;
    }
    
    static Object $PcCars$Pl(final Object lists, final Object lastElt) {
        public class srfi1$frame36 extends ModuleBody
        {
            Object last$Mnelt;
            
            public Object lambda47recur(final Object lists) {
                Label_0035: {
                    if (!lists.isPair(lists)) {
                        break Label_0035;
                    }
                    final Object caar = lists.caar(lists);
                    final Object force = Promise.force(lists, Pair.class);
                    try {
                        return lists.cons(caar, this.lambda47recur(lists.cdr((Pair)force)));
                        pair = LList.list1(this.last$Mnelt);
                        return pair;
                    }
                    catch (ClassCastException ex) {
                        throw new WrongType(ex, "cdr", 1, force);
                    }
                }
            }
        }
        final srfi1$frame36 $heapFrame = new srfi1$frame36();
        $heapFrame.last$Mnelt = lastElt;
        return $heapFrame.lambda47recur(lists);
    }
    
    public static Object pairFoldRight$V(final Procedure f, final Object zero, final Object lis1, final Object[] argsArray) {
        public class srfi1$frame0 extends ModuleBody
        {
            Procedure f;
            Object zero;
            
            public Object lambda8recur(final Object lists) {
                final Object cdrs = srfi1.$PcCdrs(lists);
                return lists.isNull(cdrs) ? this.zero : Scheme.apply.apply2(this.f, srfi1.append$Ex$V(new Object[] { lists, LList.list1(this.lambda8recur(cdrs)) }));
            }
            
            public Object lambda9recur(final Object lis) {
                if (srfi1.isNullList(lis)) {
                    return this.zero;
                }
                final Procedure f = this.f;
                final Object force = Promise.force(lis, Pair.class);
                try {
                    return f.apply2(lis, this.lambda9recur(lists.cdr((Pair)force)));
                }
                catch (ClassCastException ex) {
                    throw new WrongType(ex, "cdr", 1, force);
                }
            }
        }
        final srfi1$frame0 $heapFrame = new srfi1$frame0();
        $heapFrame.f = f;
        $heapFrame.zero = zero;
        final LList lists = LList.makeList(argsArray, 0);
        return kawa.lib.lists.isPair(lists) ? $heapFrame.lambda8recur(kawa.lib.lists.cons(lis1, lists)) : $heapFrame.lambda9recur(lis1);
    }
    
    public static Object pairFold$V(final Procedure f, final Object zero, final Object lis1, final Object[] argsArray) {
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
        //    15: ifeq            81
        //    18: aload_2         /* lis1 */
        //    19: aload           lists
        //    21: invokestatic    kawa/lib/lists.cons:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //    24: aload_1         /* zero */
        //    25: astore          6
        //    27: astore          lists
        //    29: aload           lists
        //    31: invokestatic    gnu/kawa/slib/srfi1.$PcCdrs:(Ljava/lang/Object;)Ljava/lang/Object;
        //    34: astore          tails
        //    36: aload           tails
        //    38: invokestatic    kawa/lib/lists.isNull:(Ljava/lang/Object;)Z
        //    41: ifeq            49
        //    44: aload           ans
        //    46: goto            131
        //    49: aload           tails
        //    51: getstatic       kawa/standard/Scheme.apply:Lgnu/kawa/functions/Apply;
        //    54: aload_0         /* f */
        //    55: iconst_2       
        //    56: anewarray       Ljava/lang/Object;
        //    59: dup            
        //    60: iconst_0       
        //    61: aload           lists
        //    63: aastore        
        //    64: dup            
        //    65: iconst_1       
        //    66: aload           ans
        //    68: invokestatic    gnu/lists/LList.list1:(Ljava/lang/Object;)Lgnu/lists/Pair;
        //    71: aastore        
        //    72: invokestatic    gnu/kawa/slib/srfi1.append$Ex$V:([Ljava/lang/Object;)Ljava/lang/Object;
        //    75: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    78: goto            25
        //    81: aload_2         /* lis1 */
        //    82: aload_1         /* zero */
        //    83: astore          6
        //    85: astore          lis
        //    87: aload           lis
        //    89: invokestatic    gnu/kawa/slib/srfi1.isNullList:(Ljava/lang/Object;)Z
        //    92: ifeq            100
        //    95: aload           ans
        //    97: goto            131
        //   100: aload           lis
        //   102: ldc             Lgnu/lists/Pair;.class
        //   104: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   107: dup            
        //   108: astore          8
        //   110: checkcast       Lgnu/lists/Pair;
        //   113: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   116: astore          tail
        //   118: aload           tail
        //   120: aload_0         /* f */
        //   121: aload           lis
        //   123: aload           ans
        //   125: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   128: goto            83
        //   131: areturn        
        //   132: new             Lgnu/mapping/WrongType;
        //   135: dup_x1         
        //   136: swap           
        //   137: ldc             "cdr"
        //   139: iconst_1       
        //   140: aload           8
        //   142: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   145: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  110    113    132    146    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public static Object reduce(final Procedure f, final Object ridentity, final Object lis) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokestatic    gnu/kawa/slib/srfi1.isNullList:(Ljava/lang/Object;)Z
        //     4: ifeq            11
        //     7: aload_1         /* ridentity */
        //     8: goto            47
        //    11: aload_0         /* f */
        //    12: aload_2         /* lis */
        //    13: ldc             Lgnu/lists/Pair;.class
        //    15: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    18: dup            
        //    19: astore_3       
        //    20: checkcast       Lgnu/lists/Pair;
        //    23: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    26: aload_2         /* lis */
        //    27: ldc             Lgnu/lists/Pair;.class
        //    29: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    32: dup            
        //    33: astore_3       
        //    34: checkcast       Lgnu/lists/Pair;
        //    37: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    40: iconst_0       
        //    41: anewarray       Ljava/lang/Object;
        //    44: invokestatic    gnu/kawa/slib/srfi1.fold$V:(Lgnu/mapping/Procedure;Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
        //    47: areturn        
        //    48: new             Lgnu/mapping/WrongType;
        //    51: dup_x1         
        //    52: swap           
        //    53: ldc             "car"
        //    55: iconst_1       
        //    56: aload_3        
        //    57: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //    60: athrow         
        //    61: new             Lgnu/mapping/WrongType;
        //    64: dup_x1         
        //    65: swap           
        //    66: ldc             "cdr"
        //    68: iconst_1       
        //    69: aload_3        
        //    70: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //    73: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  20     23     48     61     Ljava/lang/ClassCastException;
        //  34     37     61     74     Ljava/lang/ClassCastException;
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
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:125)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:330)
        //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:251)
        //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:126)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public static Object appendMap$V(final Object f, final Object lis1, final Object[] argsArray) {
        final LList lists = LList.makeList(argsArray, 0);
        Object o;
        if (kawa.lib.lists.isPair(lists)) {
            o = Scheme.apply.apply2(append.append, Scheme.apply.apply4(Scheme.map, f, lis1, lists));
        }
        else {
            final Apply apply = Scheme.apply;
            final append append = kawa.standard.append.append;
            final Iterator iterator = Sequences.getIterator(lis1);
            LList empty = LList.Empty;
            Pair pair = null;
            while (iterator.hasNext()) {
                final Pair cdr = new Pair(Scheme.applyToArgs.apply2(f, iterator.next()), LList.Empty);
                if (pair == null) {
                    empty = cdr;
                }
                else {
                    pair.setCdr(cdr);
                }
                pair = cdr;
            }
            o = apply.apply2(append, empty);
        }
        return o;
    }
    
    public static Object appendMap$Ex$V(final Object f, final Object lis1, final Object[] argsArray) {
        final LList lists = LList.makeList(argsArray, 0);
        Object o;
        if (kawa.lib.lists.isPair(lists)) {
            o = Scheme.apply.apply2(srfi1.append$Ex, Scheme.apply.apply4(Scheme.map, f, lis1, lists));
        }
        else {
            final Apply apply = Scheme.apply;
            final ModuleMethod append$Ex = srfi1.append$Ex;
            final Iterator iterator = Sequences.getIterator(lis1);
            LList empty = LList.Empty;
            Pair pair = null;
            while (iterator.hasNext()) {
                final Pair cdr = new Pair(Scheme.applyToArgs.apply2(f, iterator.next()), LList.Empty);
                if (pair == null) {
                    empty = cdr;
                }
                else {
                    pair.setCdr(cdr);
                }
                pair = cdr;
            }
            o = apply.apply2(append$Ex, empty);
        }
        return o;
    }
    
    public static Object pairForEach$V(final Procedure proc, final Object lis1, final Object[] argsArray) {
        final LList lists = LList.makeList(argsArray, 0);
        if (kawa.lib.lists.isPair(lists)) {
            Object cons = kawa.lib.lists.cons(lis1, lists);
            while (true) {
                final Object lists2 = cons;
                final Object tails = $PcCdrs(lists2);
                if (!kawa.lib.lists.isPair(tails)) {
                    break;
                }
                Scheme.apply.apply2(proc, lists2);
                cons = tails;
            }
            return Values.empty;
        }
        Object o = lis1;
        while (true) {
            final Object lis2 = o;
            Label_0100: {
                if (isNullList(lis2)) {
                    break Label_0100;
                }
                final Object force = Promise.force(lis2, Pair.class);
                try {
                    final Object tail = kawa.lib.lists.cdr((Pair)force);
                    proc.apply1(lis2);
                    o = tail;
                    continue;
                    return Values.empty;
                }
                catch (ClassCastException ex) {
                    throw new WrongType(ex, "cdr", 1, force);
                }
            }
            break;
        }
    }
    
    public static Object map$Ex$V(final Procedure f, final Object lis1, final Object[] argsArray) {
        public class srfi1$frame2 extends ModuleBody
        {
            Procedure f;
            final ModuleMethod lambda$Fn1;
            
            public srfi1$frame2() {
                final ModuleMethod lambda$Fn1 = new ModuleMethod(this, 1, null, 4097);
                lambda$Fn1.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi1.scm:948");
                this.lambda$Fn1 = lambda$Fn1;
            }
            
            void lambda11(final Object pair) {
                Object o2;
                final Object o = o2 = Promise.force(pair, Pair.class);
                Pair pair2;
                Procedure f;
                Object o3;
                try {
                    pair2 = (Pair)o;
                    f = this.f;
                    o3 = (o2 = Promise.force(pair, Pair.class));
                    final Pair pair3 = (Pair)o3;
                    final Object o4 = lists.car(pair3);
                    final Object o5 = f.apply1(o4);
                    lists.setCar$Ex(pair2, o5);
                    return;
                }
                catch (ClassCastException ex) {
                    throw new WrongType(ex, "set-car!", 1, o2);
                }
                try {
                    final Pair pair3 = (Pair)o3;
                    final Object o4 = lists.car(pair3);
                    final Object o5 = f.apply1(o4);
                    lists.setCar$Ex(pair2, o5);
                }
                catch (ClassCastException ex2) {
                    throw new WrongType(ex2, "car", 1, o2);
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
                    this.lambda11(o);
                    return Values.empty;
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
        //     4: invokespecial   gnu/kawa/slib/srfi1$frame2.<init>:()V
        //     7: astore          $heapFrame
        //     9: aload           $heapFrame
        //    11: aload_0         /* f */
        //    12: putfield        gnu/kawa/slib/srfi1$frame2.f:Lgnu/mapping/Procedure;
        //    15: aload_2         /* argsArray */
        //    16: iconst_0       
        //    17: invokestatic    gnu/lists/LList.makeList:([Ljava/lang/Object;I)Lgnu/lists/LList;
        //    20: dup            
        //    21: astore          5
        //    23: astore_3        /* lists */
        //    24: aload_3         /* lists */
        //    25: invokestatic    kawa/lib/lists.isPair:(Ljava/lang/Object;)Z
        //    28: ifeq            132
        //    31: aload_1         /* lis1 */
        //    32: aload_3         /* lists */
        //    33: astore          6
        //    35: astore          lis1
        //    37: aload           lis1
        //    39: invokestatic    gnu/kawa/slib/srfi1.isNullList:(Ljava/lang/Object;)Z
        //    42: ifne            146
        //    45: aload           lists
        //    47: invokestatic    gnu/kawa/slib/srfi1.$PcCars$PlCdrs$SlNoTest$SlPair:(Ljava/lang/Object;)Lgnu/lists/Pair;
        //    50: astore          split
        //    52: aload           split
        //    54: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    57: astore          heads
        //    59: aload           split
        //    61: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    64: astore          tails
        //    66: aload           lis1
        //    68: ldc             Lgnu/lists/Pair;.class
        //    70: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    73: dup            
        //    74: astore          10
        //    76: checkcast       Lgnu/lists/Pair;
        //    79: getstatic       kawa/standard/Scheme.apply:Lgnu/kawa/functions/Apply;
        //    82: aload           $heapFrame
        //    84: getfield        gnu/kawa/slib/srfi1$frame2.f:Lgnu/mapping/Procedure;
        //    87: aload           lis1
        //    89: ldc             Lgnu/lists/Pair;.class
        //    91: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    94: dup            
        //    95: astore          10
        //    97: checkcast       Lgnu/lists/Pair;
        //   100: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   103: aload           heads
        //   105: invokevirtual   gnu/mapping/Procedure.apply3:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   108: invokestatic    kawa/lib/lists.setCar$Ex:(Lgnu/lists/Pair;Ljava/lang/Object;)V
        //   111: aload           lis1
        //   113: ldc             Lgnu/lists/Pair;.class
        //   115: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   118: dup            
        //   119: astore          10
        //   121: checkcast       Lgnu/lists/Pair;
        //   124: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   127: aload           tails
        //   129: goto            33
        //   132: aload           $heapFrame
        //   134: getfield        gnu/kawa/slib/srfi1$frame2.lambda$Fn1:Lgnu/expr/ModuleMethod;
        //   137: aload_1         /* lis1 */
        //   138: iconst_0       
        //   139: anewarray       Ljava/lang/Object;
        //   142: invokestatic    gnu/kawa/slib/srfi1.pairForEach$V:(Lgnu/mapping/Procedure;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
        //   145: pop            
        //   146: aload_1         /* lis1 */
        //   147: areturn        
        //   148: new             Lgnu/mapping/WrongType;
        //   151: dup_x1         
        //   152: swap           
        //   153: ldc_w           "set-car!"
        //   156: iconst_1       
        //   157: aload           10
        //   159: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   162: athrow         
        //   163: new             Lgnu/mapping/WrongType;
        //   166: dup_x1         
        //   167: swap           
        //   168: ldc             "car"
        //   170: iconst_1       
        //   171: aload           10
        //   173: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   176: athrow         
        //   177: new             Lgnu/mapping/WrongType;
        //   180: dup_x1         
        //   181: swap           
        //   182: ldc             "cdr"
        //   184: iconst_1       
        //   185: aload           10
        //   187: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   190: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  76     79     148    163    Ljava/lang/ClassCastException;
        //  97     100    163    177    Ljava/lang/ClassCastException;
        //  121    124    177    191    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    static Pair $PcCars$PlCdrs$SlNoTest$SlPair(final Object lists) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokestatic    gnu/kawa/slib/srfi1.$PcCars$PlCdrs$SlNoTest:(Ljava/lang/Object;)Ljava/lang/Object;
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
    
    public static Object filterMap$V(final Procedure f, final Object lis1, final Object[] argsArray) {
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
        //    13: ifeq            139
        //    16: aload_1         /* lis1 */
        //    17: aload_3         /* lists */
        //    18: invokestatic    kawa/lib/lists.cons:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //    21: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
        //    24: astore          5
        //    26: astore          lists
        //    28: aload           lists
        //    30: invokestatic    gnu/kawa/slib/srfi1.$PcCars$PlCdrs:(Ljava/lang/Object;)Ljava/lang/Object;
        //    33: astore          6
        //    35: iconst_0       
        //    36: istore          7
        //    38: aload           6
        //    40: iload           7
        //    42: invokestatic    gnu/mapping/Values.incrPos:(Ljava/lang/Object;I)I
        //    45: istore          7
        //    47: aload           6
        //    49: iload           7
        //    51: invokestatic    gnu/mapping/Values.getFromPos:(Ljava/lang/Object;I)Ljava/lang/Object;
        //    54: astore          8
        //    56: aload           6
        //    58: iload           7
        //    60: invokestatic    gnu/mapping/Values.incrPos:(Ljava/lang/Object;I)I
        //    63: istore          7
        //    65: aload           6
        //    67: iload           7
        //    69: invokestatic    gnu/mapping/Values.getFromPosFinal:(Ljava/lang/Object;I)Ljava/lang/Object;
        //    72: astore          cdrs
        //    74: aload           cars
        //    76: invokestatic    gnu/kawa/slib/srfi1.isNotPair:(Ljava/lang/Object;)Z
        //    79: ifeq            101
        //    82: aload           res
        //    84: ldc             Lgnu/lists/LList;.class
        //    86: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    89: dup            
        //    90: astore          10
        //    92: checkcast       Lgnu/lists/LList;
        //    95: invokestatic    kawa/lib/lists.reverse$Ex:(Lgnu/lists/LList;)Lgnu/lists/LList;
        //    98: goto            241
        //   101: getstatic       kawa/standard/Scheme.apply:Lgnu/kawa/functions/Apply;
        //   104: aload_0         /* f */
        //   105: aload           cars
        //   107: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   110: astore          head
        //   112: aload           head
        //   114: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //   117: ifeq            132
        //   120: aload           cdrs
        //   122: aload           head
        //   124: aload           res
        //   126: invokestatic    kawa/lib/lists.cons:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //   129: goto            24
        //   132: aload           cdrs
        //   134: astore          lists
        //   136: goto            28
        //   139: aload_1         /* lis1 */
        //   140: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
        //   143: astore          5
        //   145: astore          lis
        //   147: aload           lis
        //   149: invokestatic    gnu/kawa/slib/srfi1.isNullList:(Ljava/lang/Object;)Z
        //   152: ifeq            174
        //   155: aload           res
        //   157: ldc             Lgnu/lists/LList;.class
        //   159: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   162: dup            
        //   163: astore          6
        //   165: checkcast       Lgnu/lists/LList;
        //   168: invokestatic    kawa/lib/lists.reverse$Ex:(Lgnu/lists/LList;)Lgnu/lists/LList;
        //   171: goto            241
        //   174: aload_0         /* f */
        //   175: aload           lis
        //   177: ldc             Lgnu/lists/Pair;.class
        //   179: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   182: dup            
        //   183: astore          7
        //   185: checkcast       Lgnu/lists/Pair;
        //   188: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   191: invokevirtual   gnu/mapping/Procedure.apply1:(Ljava/lang/Object;)Ljava/lang/Object;
        //   194: astore          6
        //   196: aload           lis
        //   198: ldc             Lgnu/lists/Pair;.class
        //   200: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   203: dup            
        //   204: astore          8
        //   206: checkcast       Lgnu/lists/Pair;
        //   209: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   212: astore          tail
        //   214: aload           head
        //   216: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //   219: ifeq            234
        //   222: aload           tail
        //   224: aload           head
        //   226: aload           res
        //   228: invokestatic    kawa/lib/lists.cons:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //   231: goto            143
        //   234: aload           tail
        //   236: astore          lis
        //   238: goto            147
        //   241: areturn        
        //   242: new             Lgnu/mapping/WrongType;
        //   245: dup_x1         
        //   246: swap           
        //   247: ldc             "reverse!"
        //   249: iconst_1       
        //   250: aload           10
        //   252: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   255: athrow         
        //   256: new             Lgnu/mapping/WrongType;
        //   259: dup_x1         
        //   260: swap           
        //   261: ldc             "reverse!"
        //   263: iconst_1       
        //   264: aload           6
        //   266: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   269: athrow         
        //   270: new             Lgnu/mapping/WrongType;
        //   273: dup_x1         
        //   274: swap           
        //   275: ldc             "car"
        //   277: iconst_1       
        //   278: aload           7
        //   280: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   283: athrow         
        //   284: new             Lgnu/mapping/WrongType;
        //   287: dup_x1         
        //   288: swap           
        //   289: ldc             "cdr"
        //   291: iconst_1       
        //   292: aload           8
        //   294: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   297: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  92     95     242    256    Ljava/lang/ClassCastException;
        //  165    168    256    270    Ljava/lang/ClassCastException;
        //  185    188    270    284    Ljava/lang/ClassCastException;
        //  206    209    284    298    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    static Object $PcCars$PlCdrs(final Object lists) {
        final CallContext $ctx;
        final Continuation cont = new Continuation($ctx = CallContext.getInstance());
        Object handleException = null;
        try {
            final Continuation abort = cont;
            public class srfi1$frame37 extends ModuleBody
            {
                Continuation abort;
                
                public Object lambda48recur(final Object lists) {
                    // 
                    // This method could not be decompiled.
                    // 
                    // Original Bytecode:
                    // 
                    //     1: invokestatic    kawa/lib/lists.isPair:(Ljava/lang/Object;)Z
                    //     4: ifeq            177
                    //     7: aload_1         /* lists */
                    //     8: invokestatic    gnu/kawa/slib/srfi1.car$PlCdr:(Ljava/lang/Object;)Lgnu/mapping/Values;
                    //    11: astore_2       
                    //    12: iconst_0       
                    //    13: istore_3       
                    //    14: aload_2        
                    //    15: iload_3        
                    //    16: invokestatic    gnu/mapping/Values.incrPos:(Ljava/lang/Object;I)I
                    //    19: istore_3       
                    //    20: aload_2        
                    //    21: iload_3        
                    //    22: invokestatic    gnu/mapping/Values.getFromPos:(Ljava/lang/Object;I)Ljava/lang/Object;
                    //    25: astore          4
                    //    27: aload_2        
                    //    28: iload_3        
                    //    29: invokestatic    gnu/mapping/Values.incrPos:(Ljava/lang/Object;I)I
                    //    32: istore_3       
                    //    33: aload_2        
                    //    34: iload_3        
                    //    35: invokestatic    gnu/mapping/Values.getFromPosFinal:(Ljava/lang/Object;I)Ljava/lang/Object;
                    //    38: astore          other$Mnlists
                    //    40: aload           list
                    //    42: invokestatic    gnu/kawa/slib/srfi1.isNullList:(Ljava/lang/Object;)Z
                    //    45: ifeq            64
                    //    48: aload_0         /* this */
                    //    49: getfield        gnu/kawa/slib/srfi1$frame37.abort:Lkawa/lang/Continuation;
                    //    52: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
                    //    55: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
                    //    58: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                    //    61: goto            186
                    //    64: aload           list
                    //    66: invokestatic    gnu/kawa/slib/srfi1.car$PlCdr:(Ljava/lang/Object;)Lgnu/mapping/Values;
                    //    69: astore          6
                    //    71: iconst_0       
                    //    72: istore          7
                    //    74: aload           6
                    //    76: iload           7
                    //    78: invokestatic    gnu/mapping/Values.incrPos:(Ljava/lang/Object;I)I
                    //    81: istore          7
                    //    83: aload           6
                    //    85: iload           7
                    //    87: invokestatic    gnu/mapping/Values.getFromPos:(Ljava/lang/Object;I)Ljava/lang/Object;
                    //    90: astore          8
                    //    92: aload           6
                    //    94: iload           7
                    //    96: invokestatic    gnu/mapping/Values.incrPos:(Ljava/lang/Object;I)I
                    //    99: istore          7
                    //   101: aload           6
                    //   103: iload           7
                    //   105: invokestatic    gnu/mapping/Values.getFromPosFinal:(Ljava/lang/Object;I)Ljava/lang/Object;
                    //   108: astore          d
                    //   110: aload_0         /* this */
                    //   111: aload           other$Mnlists
                    //   113: invokevirtual   gnu/kawa/slib/srfi1$frame37.lambda48recur:(Ljava/lang/Object;)Ljava/lang/Object;
                    //   116: astore          10
                    //   118: iconst_0       
                    //   119: istore          11
                    //   121: aload           10
                    //   123: iload           11
                    //   125: invokestatic    gnu/mapping/Values.incrPos:(Ljava/lang/Object;I)I
                    //   128: istore          11
                    //   130: aload           10
                    //   132: iload           11
                    //   134: invokestatic    gnu/mapping/Values.getFromPos:(Ljava/lang/Object;I)Ljava/lang/Object;
                    //   137: astore          12
                    //   139: aload           10
                    //   141: iload           11
                    //   143: invokestatic    gnu/mapping/Values.incrPos:(Ljava/lang/Object;I)I
                    //   146: istore          11
                    //   148: aload           10
                    //   150: iload           11
                    //   152: invokestatic    gnu/mapping/Values.getFromPosFinal:(Ljava/lang/Object;I)Ljava/lang/Object;
                    //   155: astore          cdrs
                    //   157: aload           a
                    //   159: aload           cars
                    //   161: invokestatic    kawa/lib/lists.cons:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
                    //   164: aload           d
                    //   166: aload           cdrs
                    //   168: invokestatic    kawa/lib/lists.cons:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
                    //   171: invokestatic    gnu/mapping/Values.values2:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/mapping/Values$Values2;
                    //   174: goto            186
                    //   177: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
                    //   180: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
                    //   183: invokestatic    gnu/mapping/Values.values2:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/mapping/Values$Values2;
                    //   186: areturn        
                    // 
                    // The error that occurred was:
                    // 
                    // java.lang.NullPointerException
                    // 
                    throw new IllegalStateException("An error occurred while decompiling this method.");
                }
            }
            final srfi1$frame37 $heapFrame = new srfi1$frame37();
            $heapFrame.abort = abort;
            $heapFrame.lambda48recur(lists);
            cont.invoked = true;
        }
        finally {
            handleException = Continuation.handleException(loadexception(java.lang.Throwable.class), cont);
        }
        return handleException;
    }
    
    public static Object filter(final Procedure pred, final Object lis) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
        //     4: astore_3       
        //     5: astore_2        /* lis */
        //     6: aload_2         /* lis */
        //     7: invokestatic    gnu/kawa/slib/srfi1.isNullList:(Ljava/lang/Object;)Z
        //    10: ifeq            31
        //    13: aload_3         /* res */
        //    14: ldc             Lgnu/lists/LList;.class
        //    16: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    19: dup            
        //    20: astore          4
        //    22: checkcast       Lgnu/lists/LList;
        //    25: invokestatic    kawa/lib/lists.reverse$Ex:(Lgnu/lists/LList;)Lgnu/lists/LList;
        //    28: goto            94
        //    31: aload_2         /* lis */
        //    32: ldc             Lgnu/lists/Pair;.class
        //    34: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    37: dup            
        //    38: astore          5
        //    40: checkcast       Lgnu/lists/Pair;
        //    43: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    46: astore          4
        //    48: aload_2         /* lis */
        //    49: ldc             Lgnu/lists/Pair;.class
        //    51: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    54: dup            
        //    55: astore          6
        //    57: checkcast       Lgnu/lists/Pair;
        //    60: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    63: astore          tail
        //    65: aload_0         /* pred */
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
        //    90: astore_2        /* lis */
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
    
    public static Object filter$Ex(final Procedure pred, final Object lis) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: astore_2        /* ans */
        //     2: aload_2         /* ans */
        //     3: invokestatic    gnu/kawa/slib/srfi1.isNullList:(Ljava/lang/Object;)Z
        //     6: ifeq            13
        //     9: aload_2         /* ans */
        //    10: goto            266
        //    13: aload_0         /* pred */
        //    14: aload_2         /* ans */
        //    15: ldc             Lgnu/lists/Pair;.class
        //    17: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    20: dup            
        //    21: astore_3       
        //    22: checkcast       Lgnu/lists/Pair;
        //    25: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    28: invokevirtual   gnu/mapping/Procedure.apply1:(Ljava/lang/Object;)Ljava/lang/Object;
        //    31: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //    34: ifne            54
        //    37: aload_2         /* ans */
        //    38: ldc             Lgnu/lists/Pair;.class
        //    40: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    43: dup            
        //    44: astore_3       
        //    45: checkcast       Lgnu/lists/Pair;
        //    48: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    51: goto            1
        //    54: aload_2         /* ans */
        //    55: aload_2         /* ans */
        //    56: ldc             Lgnu/lists/Pair;.class
        //    58: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    61: dup            
        //    62: astore_3       
        //    63: checkcast       Lgnu/lists/Pair;
        //    66: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    69: astore          4
        //    71: astore_3        /* prev */
        //    72: aload           lis
        //    74: invokestatic    kawa/lib/lists.isPair:(Ljava/lang/Object;)Z
        //    77: ifeq            265
        //    80: aload_0         /* pred */
        //    81: aload           lis
        //    83: ldc             Lgnu/lists/Pair;.class
        //    85: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    88: dup            
        //    89: astore          5
        //    91: checkcast       Lgnu/lists/Pair;
        //    94: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    97: invokevirtual   gnu/mapping/Procedure.apply1:(Ljava/lang/Object;)Ljava/lang/Object;
        //   100: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //   103: ifeq            127
        //   106: aload           lis
        //   108: aload           lis
        //   110: ldc             Lgnu/lists/Pair;.class
        //   112: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   115: dup            
        //   116: astore          5
        //   118: checkcast       Lgnu/lists/Pair;
        //   121: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   124: goto            69
        //   127: aload_3         /* prev */
        //   128: aload           lis
        //   130: ldc             Lgnu/lists/Pair;.class
        //   132: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   135: dup            
        //   136: astore          5
        //   138: checkcast       Lgnu/lists/Pair;
        //   141: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   144: goto            147
        //   147: astore          6
        //   149: astore          prev
        //   151: aload           lis
        //   153: astore          lis
        //   155: aload           lis
        //   157: invokestatic    kawa/lib/lists.isPair:(Ljava/lang/Object;)Z
        //   160: ifeq            247
        //   163: aload_0         /* pred */
        //   164: aload           lis
        //   166: ldc             Lgnu/lists/Pair;.class
        //   168: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   171: dup            
        //   172: astore          8
        //   174: checkcast       Lgnu/lists/Pair;
        //   177: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   180: invokevirtual   gnu/mapping/Procedure.apply1:(Ljava/lang/Object;)Ljava/lang/Object;
        //   183: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //   186: ifeq            228
        //   189: aload           prev
        //   191: ldc             Lgnu/lists/Pair;.class
        //   193: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   196: dup            
        //   197: astore          8
        //   199: checkcast       Lgnu/lists/Pair;
        //   202: aload           lis
        //   204: invokestatic    kawa/lib/lists.setCdr$Ex:(Lgnu/lists/Pair;Ljava/lang/Object;)V
        //   207: aload           lis
        //   209: aload           lis
        //   211: ldc             Lgnu/lists/Pair;.class
        //   213: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   216: dup            
        //   217: astore          8
        //   219: checkcast       Lgnu/lists/Pair;
        //   222: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   225: goto            69
        //   228: aload           lis
        //   230: ldc             Lgnu/lists/Pair;.class
        //   232: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   235: dup            
        //   236: astore          8
        //   238: checkcast       Lgnu/lists/Pair;
        //   241: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   244: goto            153
        //   247: aload           prev
        //   249: ldc             Lgnu/lists/Pair;.class
        //   251: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   254: dup            
        //   255: astore          8
        //   257: checkcast       Lgnu/lists/Pair;
        //   260: aload           lis
        //   262: invokestatic    kawa/lib/lists.setCdr$Ex:(Lgnu/lists/Pair;Ljava/lang/Object;)V
        //   265: aload_2         /* ans */
        //   266: areturn        
        //   267: new             Lgnu/mapping/WrongType;
        //   270: dup_x1         
        //   271: swap           
        //   272: ldc             "car"
        //   274: iconst_1       
        //   275: aload_3        
        //   276: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   279: athrow         
        //   280: new             Lgnu/mapping/WrongType;
        //   283: dup_x1         
        //   284: swap           
        //   285: ldc             "cdr"
        //   287: iconst_1       
        //   288: aload_3        
        //   289: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   292: athrow         
        //   293: new             Lgnu/mapping/WrongType;
        //   296: dup_x1         
        //   297: swap           
        //   298: ldc             "cdr"
        //   300: iconst_1       
        //   301: aload_3        
        //   302: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   305: athrow         
        //   306: new             Lgnu/mapping/WrongType;
        //   309: dup_x1         
        //   310: swap           
        //   311: ldc             "car"
        //   313: iconst_1       
        //   314: aload           5
        //   316: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   319: athrow         
        //   320: new             Lgnu/mapping/WrongType;
        //   323: dup_x1         
        //   324: swap           
        //   325: ldc             "cdr"
        //   327: iconst_1       
        //   328: aload           5
        //   330: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   333: athrow         
        //   334: new             Lgnu/mapping/WrongType;
        //   337: dup_x1         
        //   338: swap           
        //   339: ldc             "cdr"
        //   341: iconst_1       
        //   342: aload           5
        //   344: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   347: athrow         
        //   348: new             Lgnu/mapping/WrongType;
        //   351: dup_x1         
        //   352: swap           
        //   353: ldc             "car"
        //   355: iconst_1       
        //   356: aload           8
        //   358: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   361: athrow         
        //   362: new             Lgnu/mapping/WrongType;
        //   365: dup_x1         
        //   366: swap           
        //   367: ldc             "set-cdr!"
        //   369: iconst_1       
        //   370: aload           8
        //   372: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   375: athrow         
        //   376: new             Lgnu/mapping/WrongType;
        //   379: dup_x1         
        //   380: swap           
        //   381: ldc             "cdr"
        //   383: iconst_1       
        //   384: aload           8
        //   386: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   389: athrow         
        //   390: new             Lgnu/mapping/WrongType;
        //   393: dup_x1         
        //   394: swap           
        //   395: ldc             "cdr"
        //   397: iconst_1       
        //   398: aload           8
        //   400: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   403: athrow         
        //   404: new             Lgnu/mapping/WrongType;
        //   407: dup_x1         
        //   408: swap           
        //   409: ldc             "set-cdr!"
        //   411: iconst_1       
        //   412: aload           8
        //   414: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   417: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  22     25     267    280    Ljava/lang/ClassCastException;
        //  45     48     280    293    Ljava/lang/ClassCastException;
        //  63     66     293    306    Ljava/lang/ClassCastException;
        //  91     94     306    320    Ljava/lang/ClassCastException;
        //  118    121    320    334    Ljava/lang/ClassCastException;
        //  138    141    334    348    Ljava/lang/ClassCastException;
        //  174    177    348    362    Ljava/lang/ClassCastException;
        //  199    202    362    376    Ljava/lang/ClassCastException;
        //  219    222    376    390    Ljava/lang/ClassCastException;
        //  238    241    390    404    Ljava/lang/ClassCastException;
        //  257    260    404    418    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public static Object partition(final Procedure pred, final Object lis) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
        //     4: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
        //     7: astore          4
        //     9: astore_3       
        //    10: astore_2        /* lis */
        //    11: aload_2         /* lis */
        //    12: invokestatic    gnu/kawa/slib/srfi1.isNullList:(Ljava/lang/Object;)Z
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
        //    55: aload_2         /* lis */
        //    56: ldc             Lgnu/lists/Pair;.class
        //    58: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    61: dup            
        //    62: astore          6
        //    64: checkcast       Lgnu/lists/Pair;
        //    67: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    70: astore          5
        //    72: aload_2         /* lis */
        //    73: ldc             Lgnu/lists/Pair;.class
        //    75: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    78: dup            
        //    79: astore          7
        //    81: checkcast       Lgnu/lists/Pair;
        //    84: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    87: astore          tail
        //    89: aload_0         /* pred */
        //    90: aload           head
        //    92: invokevirtual   gnu/mapping/Procedure.apply1:(Ljava/lang/Object;)Ljava/lang/Object;
        //    95: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //    98: ifeq            114
        //   101: aload           tail
        //   103: aload           head
        //   105: aload_3         /* in */
        //   106: invokestatic    kawa/lib/lists.cons:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //   109: astore_3        /* in */
        //   110: astore_2        /* lis */
        //   111: goto            11
        //   114: aload           tail
        //   116: aload           head
        //   118: aload           out
        //   120: invokestatic    kawa/lib/lists.cons:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //   123: astore          out
        //   125: astore_2        /* lis */
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
    
    public static Object partition$Ex(final Procedure pred, final Object lis) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
        //     6: invokestatic    kawa/lib/lists.cons:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //     9: astore_2       
        //    10: getstatic       gnu/kawa/slib/srfi1.Lit2:Lgnu/mapping/SimpleSymbol;
        //    13: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
        //    16: invokestatic    kawa/lib/lists.cons:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //    19: astore_3        /* out$Mnhead */
        //    20: aload_2         /* in$Mnhead */
        //    21: aload_3         /* out$Mnhead */
        //    22: aload_1         /* lis */
        //    23: astore          6
        //    25: astore          5
        //    27: astore          in
        //    29: aload           lis
        //    31: invokestatic    gnu/kawa/slib/srfi1.isNotPair:(Ljava/lang/Object;)Z
        //    34: ifeq            89
        //    37: aload           in
        //    39: ldc             Lgnu/lists/Pair;.class
        //    41: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    44: dup            
        //    45: astore          7
        //    47: checkcast       Lgnu/lists/Pair;
        //    50: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
        //    53: invokestatic    kawa/lib/lists.setCdr$Ex:(Lgnu/lists/Pair;Ljava/lang/Object;)V
        //    56: aload           out
        //    58: ldc             Lgnu/lists/Pair;.class
        //    60: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    63: dup            
        //    64: astore          7
        //    66: checkcast       Lgnu/lists/Pair;
        //    69: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
        //    72: invokestatic    kawa/lib/lists.setCdr$Ex:(Lgnu/lists/Pair;Ljava/lang/Object;)V
        //    75: aload_2         /* in$Mnhead */
        //    76: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    79: aload_3         /* out$Mnhead */
        //    80: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    83: invokestatic    gnu/mapping/Values.values2:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/mapping/Values$Values2;
        //    86: goto            201
        //    89: aload_0         /* pred */
        //    90: aload           lis
        //    92: ldc             Lgnu/lists/Pair;.class
        //    94: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    97: dup            
        //    98: astore          7
        //   100: checkcast       Lgnu/lists/Pair;
        //   103: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   106: invokevirtual   gnu/mapping/Procedure.apply1:(Ljava/lang/Object;)Ljava/lang/Object;
        //   109: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //   112: ifeq            158
        //   115: aload           in
        //   117: ldc             Lgnu/lists/Pair;.class
        //   119: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   122: dup            
        //   123: astore          7
        //   125: checkcast       Lgnu/lists/Pair;
        //   128: aload           lis
        //   130: invokestatic    kawa/lib/lists.setCdr$Ex:(Lgnu/lists/Pair;Ljava/lang/Object;)V
        //   133: aload           lis
        //   135: aload           lis
        //   137: ldc             Lgnu/lists/Pair;.class
        //   139: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   142: dup            
        //   143: astore          7
        //   145: checkcast       Lgnu/lists/Pair;
        //   148: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   151: astore          lis
        //   153: astore          in
        //   155: goto            29
        //   158: aload           out
        //   160: ldc             Lgnu/lists/Pair;.class
        //   162: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   165: dup            
        //   166: astore          7
        //   168: checkcast       Lgnu/lists/Pair;
        //   171: aload           lis
        //   173: invokestatic    kawa/lib/lists.setCdr$Ex:(Lgnu/lists/Pair;Ljava/lang/Object;)V
        //   176: aload           lis
        //   178: aload           lis
        //   180: ldc             Lgnu/lists/Pair;.class
        //   182: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   185: dup            
        //   186: astore          7
        //   188: checkcast       Lgnu/lists/Pair;
        //   191: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   194: astore          lis
        //   196: astore          out
        //   198: goto            29
        //   201: areturn        
        //   202: new             Lgnu/mapping/WrongType;
        //   205: dup_x1         
        //   206: swap           
        //   207: ldc             "set-cdr!"
        //   209: iconst_1       
        //   210: aload           7
        //   212: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   215: athrow         
        //   216: new             Lgnu/mapping/WrongType;
        //   219: dup_x1         
        //   220: swap           
        //   221: ldc             "set-cdr!"
        //   223: iconst_1       
        //   224: aload           7
        //   226: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   229: athrow         
        //   230: new             Lgnu/mapping/WrongType;
        //   233: dup_x1         
        //   234: swap           
        //   235: ldc             "car"
        //   237: iconst_1       
        //   238: aload           7
        //   240: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   243: athrow         
        //   244: new             Lgnu/mapping/WrongType;
        //   247: dup_x1         
        //   248: swap           
        //   249: ldc             "set-cdr!"
        //   251: iconst_1       
        //   252: aload           7
        //   254: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   257: athrow         
        //   258: new             Lgnu/mapping/WrongType;
        //   261: dup_x1         
        //   262: swap           
        //   263: ldc             "cdr"
        //   265: iconst_1       
        //   266: aload           7
        //   268: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   271: athrow         
        //   272: new             Lgnu/mapping/WrongType;
        //   275: dup_x1         
        //   276: swap           
        //   277: ldc             "set-cdr!"
        //   279: iconst_1       
        //   280: aload           7
        //   282: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   285: athrow         
        //   286: new             Lgnu/mapping/WrongType;
        //   289: dup_x1         
        //   290: swap           
        //   291: ldc             "cdr"
        //   293: iconst_1       
        //   294: aload           7
        //   296: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   299: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  47     50     202    216    Ljava/lang/ClassCastException;
        //  66     69     216    230    Ljava/lang/ClassCastException;
        //  100    103    230    244    Ljava/lang/ClassCastException;
        //  125    128    244    258    Ljava/lang/ClassCastException;
        //  145    148    258    272    Ljava/lang/ClassCastException;
        //  168    171    272    286    Ljava/lang/ClassCastException;
        //  188    191    286    300    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public static Object remove(final Object pred, final Object l) {
        public class srfi1$frame3 extends ModuleBody
        {
            Object pred;
            final ModuleMethod lambda$Fn2;
            
            public srfi1$frame3() {
                final ModuleMethod lambda$Fn2 = new ModuleMethod(this, 2, null, 4097);
                lambda$Fn2.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi1.scm:1186");
                this.lambda$Fn2 = lambda$Fn2;
            }
            
            boolean lambda12(final Object x) {
                return !KawaConvert.isTrue(Scheme.applyToArgs.apply2(this.pred, x));
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
                    return this.lambda12(o) ? Boolean.TRUE : Boolean.FALSE;
                }
                return super.apply1(method, o);
            }
        }
        final srfi1$frame3 $heapFrame = new srfi1$frame3();
        $heapFrame.pred = pred;
        return filter($heapFrame.lambda$Fn2, l);
    }
    
    public static Object remove$Ex(final Object pred, final Object l) {
        public class srfi1$frame4 extends ModuleBody
        {
            Object pred;
            final ModuleMethod lambda$Fn3;
            
            public srfi1$frame4() {
                final ModuleMethod lambda$Fn3 = new ModuleMethod(this, 3, null, 4097);
                lambda$Fn3.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi1.scm:1187");
                this.lambda$Fn3 = lambda$Fn3;
            }
            
            boolean lambda13(final Object x) {
                return !KawaConvert.isTrue(Scheme.applyToArgs.apply2(this.pred, x));
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
                    return this.lambda13(o) ? Boolean.TRUE : Boolean.FALSE;
                }
                return super.apply1(method, o);
            }
        }
        final srfi1$frame4 $heapFrame = new srfi1$frame4();
        $heapFrame.pred = pred;
        return filter$Ex($heapFrame.lambda$Fn3, l);
    }
    
    public static Object delete(final Object x, final Object lis) {
        return delete(x, lis, Scheme.isEqual);
    }
    
    public static Object delete(final Object x, final Object lis, final Object maybe$Mn$Eq) {
        public class srfi1$frame5 extends ModuleBody
        {
            Object x;
            Object maybe$Mn$Eq;
            final ModuleMethod lambda$Fn4;
            
            public srfi1$frame5() {
                final ModuleMethod lambda$Fn4 = new ModuleMethod(this, 4, null, 4097);
                lambda$Fn4.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi1.scm:1209");
                this.lambda$Fn4 = lambda$Fn4;
            }
            
            boolean lambda14(final Object y) {
                return !KawaConvert.isTrue(Scheme.applyToArgs.apply3(this.maybe$Mn$Eq, this.x, y));
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
                    return this.lambda14(o) ? Boolean.TRUE : Boolean.FALSE;
                }
                return super.apply1(method, o);
            }
        }
        final srfi1$frame5 $heapFrame = new srfi1$frame5();
        $heapFrame.x = x;
        $heapFrame.maybe$Mn$Eq = maybe$Mn$Eq;
        return filter($heapFrame.lambda$Fn4, lis);
    }
    
    public static Object delete$Ex(final Object x, final Object lis) {
        return delete$Ex(x, lis, Scheme.isEqual);
    }
    
    public static Object delete$Ex(final Object x, final Object lis, final Object maybe$Mn$Eq) {
        public class srfi1$frame6 extends ModuleBody
        {
            Object x;
            Object maybe$Mn$Eq;
            final ModuleMethod lambda$Fn5;
            
            public srfi1$frame6() {
                final ModuleMethod lambda$Fn5 = new ModuleMethod(this, 5, null, 4097);
                lambda$Fn5.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi1.scm:1212");
                this.lambda$Fn5 = lambda$Fn5;
            }
            
            boolean lambda15(final Object y) {
                return !KawaConvert.isTrue(Scheme.applyToArgs.apply3(this.maybe$Mn$Eq, this.x, y));
            }
            
            @Override
            public int match1(final ModuleMethod moduleMethod, final Object o, final CallContext ctx) {
                if (moduleMethod.selector == 5) {
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
                if (method.selector == 5) {
                    return this.lambda15(o) ? Boolean.TRUE : Boolean.FALSE;
                }
                return super.apply1(method, o);
            }
        }
        final srfi1$frame6 $heapFrame = new srfi1$frame6();
        $heapFrame.x = x;
        $heapFrame.maybe$Mn$Eq = maybe$Mn$Eq;
        return filter$Ex($heapFrame.lambda$Fn5, lis);
    }
    
    public static Object deleteDuplicates(final Object lis) {
        return deleteDuplicates(lis, Scheme.isEqual);
    }
    
    public static Object deleteDuplicates(final Object lis, final Procedure maybe$Mn$Eq) {
        public class srfi1$frame7 extends ModuleBody
        {
            Procedure maybe$Mn$Eq;
            
            public Object lambda16recur(final Object lis) {
                // 
                // This method could not be decompiled.
                // 
                // Original Bytecode:
                // 
                //     1: invokestatic    gnu/kawa/slib/srfi1.isNullList:(Ljava/lang/Object;)Z
                //     4: ifeq            11
                //     7: aload_1         /* lis */
                //     8: goto            73
                //    11: aload_1         /* lis */
                //    12: ldc             Lgnu/lists/Pair;.class
                //    14: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //    17: dup            
                //    18: astore_3       
                //    19: checkcast       Lgnu/lists/Pair;
                //    22: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
                //    25: astore_2        /* x */
                //    26: aload_1         /* lis */
                //    27: ldc             Lgnu/lists/Pair;.class
                //    29: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //    32: dup            
                //    33: astore          4
                //    35: checkcast       Lgnu/lists/Pair;
                //    38: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
                //    41: astore_3        /* tail */
                //    42: aload_0         /* this */
                //    43: aload_2         /* x */
                //    44: aload_3         /* tail */
                //    45: aload_0         /* this */
                //    46: getfield        gnu/kawa/slib/srfi1$frame7.maybe$Mn$Eq:Lgnu/mapping/Procedure;
                //    49: invokestatic    gnu/kawa/slib/srfi1.delete:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                //    52: invokevirtual   gnu/kawa/slib/srfi1$frame7.lambda16recur:(Ljava/lang/Object;)Ljava/lang/Object;
                //    55: astore          new$Mntail
                //    57: aload_3         /* tail */
                //    58: aload           new$Mntail
                //    60: if_acmpne       67
                //    63: aload_1         /* lis */
                //    64: goto            73
                //    67: aload_2         /* x */
                //    68: aload           new$Mntail
                //    70: invokestatic    kawa/lib/lists.cons:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
                //    73: areturn        
                //    74: new             Lgnu/mapping/WrongType;
                //    77: dup_x1         
                //    78: swap           
                //    79: ldc             "car"
                //    81: iconst_1       
                //    82: aload_3        
                //    83: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //    86: athrow         
                //    87: new             Lgnu/mapping/WrongType;
                //    90: dup_x1         
                //    91: swap           
                //    92: ldc             "cdr"
                //    94: iconst_1       
                //    95: aload           4
                //    97: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //   100: athrow         
                //    Exceptions:
                //  Try           Handler
                //  Start  End    Start  End    Type                          
                //  -----  -----  -----  -----  ------------------------------
                //  19     22     74     87     Ljava/lang/ClassCastException;
                //  35     38     87     101    Ljava/lang/ClassCastException;
                // 
                // The error that occurred was:
                // 
                // java.lang.IllegalStateException: Expression is linked from several locations: Label_0067:
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
        final srfi1$frame7 $heapFrame = new srfi1$frame7();
        $heapFrame.maybe$Mn$Eq = maybe$Mn$Eq;
        return $heapFrame.lambda16recur(lis);
    }
    
    public static Object deleteDuplicates$Ex(final Object lis) {
        return deleteDuplicates$Ex(lis, Scheme.isEqual);
    }
    
    public static Object deleteDuplicates$Ex(final Object lis, final Procedure maybe$Mn$Eq) {
        public class srfi1$frame8 extends ModuleBody
        {
            Procedure maybe$Mn$Eq;
            
            public Object lambda17recur(final Object lis) {
                // 
                // This method could not be decompiled.
                // 
                // Original Bytecode:
                // 
                //     1: invokestatic    gnu/kawa/slib/srfi1.isNullList:(Ljava/lang/Object;)Z
                //     4: ifeq            11
                //     7: aload_1         /* lis */
                //     8: goto            73
                //    11: aload_1         /* lis */
                //    12: ldc             Lgnu/lists/Pair;.class
                //    14: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //    17: dup            
                //    18: astore_3       
                //    19: checkcast       Lgnu/lists/Pair;
                //    22: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
                //    25: astore_2        /* x */
                //    26: aload_1         /* lis */
                //    27: ldc             Lgnu/lists/Pair;.class
                //    29: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //    32: dup            
                //    33: astore          4
                //    35: checkcast       Lgnu/lists/Pair;
                //    38: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
                //    41: astore_3        /* tail */
                //    42: aload_0         /* this */
                //    43: aload_2         /* x */
                //    44: aload_3         /* tail */
                //    45: aload_0         /* this */
                //    46: getfield        gnu/kawa/slib/srfi1$frame8.maybe$Mn$Eq:Lgnu/mapping/Procedure;
                //    49: invokestatic    gnu/kawa/slib/srfi1.delete$Ex:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                //    52: invokevirtual   gnu/kawa/slib/srfi1$frame8.lambda17recur:(Ljava/lang/Object;)Ljava/lang/Object;
                //    55: astore          new$Mntail
                //    57: aload_3         /* tail */
                //    58: aload           new$Mntail
                //    60: if_acmpne       67
                //    63: aload_1         /* lis */
                //    64: goto            73
                //    67: aload_2         /* x */
                //    68: aload           new$Mntail
                //    70: invokestatic    kawa/lib/lists.cons:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
                //    73: areturn        
                //    74: new             Lgnu/mapping/WrongType;
                //    77: dup_x1         
                //    78: swap           
                //    79: ldc             "car"
                //    81: iconst_1       
                //    82: aload_3        
                //    83: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //    86: athrow         
                //    87: new             Lgnu/mapping/WrongType;
                //    90: dup_x1         
                //    91: swap           
                //    92: ldc             "cdr"
                //    94: iconst_1       
                //    95: aload           4
                //    97: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //   100: athrow         
                //    Exceptions:
                //  Try           Handler
                //  Start  End    Start  End    Type                          
                //  -----  -----  -----  -----  ------------------------------
                //  19     22     74     87     Ljava/lang/ClassCastException;
                //  35     38     87     101    Ljava/lang/ClassCastException;
                // 
                // The error that occurred was:
                // 
                // java.lang.IllegalStateException: Expression is linked from several locations: Label_0067:
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
        final srfi1$frame8 $heapFrame = new srfi1$frame8();
        $heapFrame.maybe$Mn$Eq = maybe$Mn$Eq;
        return $heapFrame.lambda17recur(lis);
    }
    
    public static Pair alistCons(final Object key, final Object datum, final Object alist) {
        return lists.cons(lists.cons(key, datum), alist);
    }
    
    public static LList alistCopy(final Object alist) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokestatic    gnu/lists/Sequences.getIterator:(Ljava/lang/Object;)Ljava/util/Iterator;
        //     4: astore_1       
        //     5: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
        //     8: astore_2       
        //     9: aconst_null    
        //    10: astore_3       
        //    11: aload_1        
        //    12: invokeinterface java/util/Iterator.hasNext:()Z
        //    17: ifeq            92
        //    20: aload_1        
        //    21: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //    26: astore          4
        //    28: new             Lgnu/lists/Pair;
        //    31: dup            
        //    32: aload           4
        //    34: ldc             Lgnu/lists/Pair;.class
        //    36: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    39: dup            
        //    40: astore          6
        //    42: checkcast       Lgnu/lists/Pair;
        //    45: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    48: aload           4
        //    50: ldc             Lgnu/lists/Pair;.class
        //    52: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    55: dup            
        //    56: astore          6
        //    58: checkcast       Lgnu/lists/Pair;
        //    61: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    64: invokestatic    kawa/lib/lists.cons:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //    67: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
        //    70: invokespecial   gnu/lists/Pair.<init>:(Ljava/lang/Object;Ljava/lang/Object;)V
        //    73: aload_3        
        //    74: ifnonnull       82
        //    77: dup            
        //    78: astore_2       
        //    79: goto            88
        //    82: aload_3        
        //    83: swap           
        //    84: dup_x1         
        //    85: invokevirtual   gnu/lists/Pair.setCdr:(Ljava/lang/Object;)V
        //    88: astore_3       
        //    89: goto            11
        //    92: aload_2        
        //    93: areturn        
        //    94: new             Lgnu/mapping/WrongType;
        //    97: dup_x1         
        //    98: swap           
        //    99: ldc             "car"
        //   101: iconst_1       
        //   102: aload           6
        //   104: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   107: athrow         
        //   108: new             Lgnu/mapping/WrongType;
        //   111: dup_x1         
        //   112: swap           
        //   113: ldc             "cdr"
        //   115: iconst_1       
        //   116: aload           6
        //   118: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   121: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  42     45     94     108    Ljava/lang/ClassCastException;
        //  58     61     108    122    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0082:
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
    
    public static Object alistDelete(final Object key, final Object alist) {
        return alistDelete(key, alist, Scheme.isEqual);
    }
    
    public static Object alistDelete(final Object key, final Object alist, final Object maybe$Mn$Eq) {
        public class srfi1$frame9 extends ModuleBody
        {
            Object key;
            Object maybe$Mn$Eq;
            final ModuleMethod lambda$Fn6;
            
            public srfi1$frame9() {
                final ModuleMethod lambda$Fn6 = new ModuleMethod(this, 6, null, 4097);
                lambda$Fn6.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi1.scm:1267");
                this.lambda$Fn6 = lambda$Fn6;
            }
            
            boolean lambda18(final Object elt) {
                final ApplyToArgs applyToArgs = Scheme.applyToArgs;
                final Object maybe$Mn$Eq = this.maybe$Mn$Eq;
                final Object key = this.key;
                final Object force = Promise.force(elt, Pair.class);
                try {
                    return !KawaConvert.isTrue(applyToArgs.apply3(maybe$Mn$Eq, key, lists.car((Pair)force)));
                }
                catch (ClassCastException ex) {
                    throw new WrongType(ex, "car", 1, force);
                }
            }
            
            @Override
            public int match1(final ModuleMethod moduleMethod, final Object o, final CallContext ctx) {
                if (moduleMethod.selector == 6) {
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
                if (method.selector == 6) {
                    return this.lambda18(o) ? Boolean.TRUE : Boolean.FALSE;
                }
                return super.apply1(method, o);
            }
        }
        final srfi1$frame9 $heapFrame = new srfi1$frame9();
        $heapFrame.key = key;
        $heapFrame.maybe$Mn$Eq = maybe$Mn$Eq;
        return filter($heapFrame.lambda$Fn6, alist);
    }
    
    public static Object alistDelete$Ex(final Object key, final Object alist) {
        return alistDelete$Ex(key, alist, Scheme.isEqual);
    }
    
    public static Object alistDelete$Ex(final Object key, final Object alist, final Object maybe$Mn$Eq) {
        public class srfi1$frame10 extends ModuleBody
        {
            Object key;
            Object maybe$Mn$Eq;
            final ModuleMethod lambda$Fn7;
            
            public srfi1$frame10() {
                final ModuleMethod lambda$Fn7 = new ModuleMethod(this, 7, null, 4097);
                lambda$Fn7.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi1.scm:1270");
                this.lambda$Fn7 = lambda$Fn7;
            }
            
            boolean lambda19(final Object elt) {
                final ApplyToArgs applyToArgs = Scheme.applyToArgs;
                final Object maybe$Mn$Eq = this.maybe$Mn$Eq;
                final Object key = this.key;
                final Object force = Promise.force(elt, Pair.class);
                try {
                    return !KawaConvert.isTrue(applyToArgs.apply3(maybe$Mn$Eq, key, lists.car((Pair)force)));
                }
                catch (ClassCastException ex) {
                    throw new WrongType(ex, "car", 1, force);
                }
            }
            
            @Override
            public int match1(final ModuleMethod moduleMethod, final Object o, final CallContext ctx) {
                if (moduleMethod.selector == 7) {
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
                if (method.selector == 7) {
                    return this.lambda19(o) ? Boolean.TRUE : Boolean.FALSE;
                }
                return super.apply1(method, o);
            }
        }
        final srfi1$frame10 $heapFrame = new srfi1$frame10();
        $heapFrame.key = key;
        $heapFrame.maybe$Mn$Eq = maybe$Mn$Eq;
        return filter$Ex($heapFrame.lambda$Fn7, alist);
    }
    
    public static Object find(final Object pred, final Object list) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             Lgnu/mapping/Procedure;.class
        //     3: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //     6: dup            
        //     7: astore_3       
        //     8: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceToProcedure:(Ljava/lang/Object;)Lgnu/mapping/Procedure;
        //    11: aload_1         /* list */
        //    12: invokestatic    gnu/kawa/slib/srfi1.findTail:(Lgnu/mapping/Procedure;Ljava/lang/Object;)Ljava/lang/Object;
        //    15: astore_2        /* temp */
        //    16: aload_2         /* temp */
        //    17: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //    20: ifeq            40
        //    23: aload_2         /* temp */
        //    24: ldc             Lgnu/lists/Pair;.class
        //    26: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    29: dup            
        //    30: astore_3       
        //    31: checkcast       Lgnu/lists/Pair;
        //    34: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    37: goto            43
        //    40: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //    43: areturn        
        //    44: new             Lgnu/mapping/WrongType;
        //    47: dup_x1         
        //    48: swap           
        //    49: ldc_w           "find-tail"
        //    52: iconst_0       
        //    53: aload_3        
        //    54: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //    57: athrow         
        //    58: new             Lgnu/mapping/WrongType;
        //    61: dup_x1         
        //    62: swap           
        //    63: ldc             "car"
        //    65: iconst_1       
        //    66: aload_3        
        //    67: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //    70: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  8      11     44     58     Ljava/lang/ClassCastException;
        //  31     34     58     71     Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0040:
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
    
    public static Object findTail(final Procedure pred, final Object list) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: astore_2        /* list */
        //     2: aload_2         /* list */
        //     3: invokestatic    gnu/kawa/slib/srfi1.isNullList:(Ljava/lang/Object;)Z
        //     6: ifne            54
        //     9: aload_0         /* pred */
        //    10: aload_2         /* list */
        //    11: ldc             Lgnu/lists/Pair;.class
        //    13: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    16: dup            
        //    17: astore_3       
        //    18: checkcast       Lgnu/lists/Pair;
        //    21: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    24: invokevirtual   gnu/mapping/Procedure.apply1:(Ljava/lang/Object;)Ljava/lang/Object;
        //    27: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //    30: ifeq            37
        //    33: aload_2         /* list */
        //    34: goto            57
        //    37: aload_2         /* list */
        //    38: ldc             Lgnu/lists/Pair;.class
        //    40: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    43: dup            
        //    44: astore_3       
        //    45: checkcast       Lgnu/lists/Pair;
        //    48: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    51: goto            1
        //    54: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //    57: areturn        
        //    58: new             Lgnu/mapping/WrongType;
        //    61: dup_x1         
        //    62: swap           
        //    63: ldc             "car"
        //    65: iconst_1       
        //    66: aload_3        
        //    67: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //    70: athrow         
        //    71: new             Lgnu/mapping/WrongType;
        //    74: dup_x1         
        //    75: swap           
        //    76: ldc             "cdr"
        //    78: iconst_1       
        //    79: aload_3        
        //    80: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //    83: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  18     21     58     71     Ljava/lang/ClassCastException;
        //  45     48     71     84     Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0054:
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
    
    public static Object takeWhile(final Procedure pred, final Object lis) {
        public class srfi1$frame11 extends ModuleBody
        {
            Procedure pred;
            
            public Object lambda20recur(final Object lis) {
                // 
                // This method could not be decompiled.
                // 
                // Original Bytecode:
                // 
                //     1: invokestatic    gnu/kawa/slib/srfi1.isNullList:(Ljava/lang/Object;)Z
                //     4: ifeq            13
                //     7: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
                //    10: goto            70
                //    13: aload_1         /* lis */
                //    14: ldc             Lgnu/lists/Pair;.class
                //    16: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //    19: dup            
                //    20: astore_3       
                //    21: checkcast       Lgnu/lists/Pair;
                //    24: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
                //    27: astore_2        /* x */
                //    28: aload_0         /* this */
                //    29: getfield        gnu/kawa/slib/srfi1$frame11.pred:Lgnu/mapping/Procedure;
                //    32: aload_2         /* x */
                //    33: invokevirtual   gnu/mapping/Procedure.apply1:(Ljava/lang/Object;)Ljava/lang/Object;
                //    36: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
                //    39: ifeq            67
                //    42: aload_2         /* x */
                //    43: aload_0         /* this */
                //    44: aload_1         /* lis */
                //    45: ldc             Lgnu/lists/Pair;.class
                //    47: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //    50: dup            
                //    51: astore_3       
                //    52: checkcast       Lgnu/lists/Pair;
                //    55: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
                //    58: invokevirtual   gnu/kawa/slib/srfi1$frame11.lambda20recur:(Ljava/lang/Object;)Ljava/lang/Object;
                //    61: invokestatic    kawa/lib/lists.cons:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
                //    64: goto            70
                //    67: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
                //    70: areturn        
                //    71: new             Lgnu/mapping/WrongType;
                //    74: dup_x1         
                //    75: swap           
                //    76: ldc             "car"
                //    78: iconst_1       
                //    79: aload_3        
                //    80: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //    83: athrow         
                //    84: new             Lgnu/mapping/WrongType;
                //    87: dup_x1         
                //    88: swap           
                //    89: ldc             "cdr"
                //    91: iconst_1       
                //    92: aload_3        
                //    93: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //    96: athrow         
                //    Exceptions:
                //  Try           Handler
                //  Start  End    Start  End    Type                          
                //  -----  -----  -----  -----  ------------------------------
                //  21     24     71     84     Ljava/lang/ClassCastException;
                //  52     55     84     97     Ljava/lang/ClassCastException;
                // 
                // The error that occurred was:
                // 
                // java.lang.IllegalStateException: Expression is linked from several locations: Label_0067:
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
        final srfi1$frame11 $heapFrame = new srfi1$frame11();
        $heapFrame.pred = pred;
        return $heapFrame.lambda20recur(lis);
    }
    
    public static Object dropWhile(final Procedure pred, final Object lis) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: astore_2        /* lis */
        //     2: aload_2         /* lis */
        //     3: invokestatic    gnu/kawa/slib/srfi1.isNullList:(Ljava/lang/Object;)Z
        //     6: ifeq            15
        //     9: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
        //    12: goto            57
        //    15: aload_0         /* pred */
        //    16: aload_2         /* lis */
        //    17: ldc             Lgnu/lists/Pair;.class
        //    19: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    22: dup            
        //    23: astore_3       
        //    24: checkcast       Lgnu/lists/Pair;
        //    27: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    30: invokevirtual   gnu/mapping/Procedure.apply1:(Ljava/lang/Object;)Ljava/lang/Object;
        //    33: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //    36: ifeq            56
        //    39: aload_2         /* lis */
        //    40: ldc             Lgnu/lists/Pair;.class
        //    42: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    45: dup            
        //    46: astore_3       
        //    47: checkcast       Lgnu/lists/Pair;
        //    50: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    53: goto            1
        //    56: aload_2         /* lis */
        //    57: areturn        
        //    58: new             Lgnu/mapping/WrongType;
        //    61: dup_x1         
        //    62: swap           
        //    63: ldc             "car"
        //    65: iconst_1       
        //    66: aload_3        
        //    67: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //    70: athrow         
        //    71: new             Lgnu/mapping/WrongType;
        //    74: dup_x1         
        //    75: swap           
        //    76: ldc             "cdr"
        //    78: iconst_1       
        //    79: aload_3        
        //    80: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //    83: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  24     27     58     71     Ljava/lang/ClassCastException;
        //  47     50     71     84     Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0056:
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
    
    public static Object takeWhile$Ex(final Procedure pred, final Object lis) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokestatic    gnu/kawa/slib/srfi1.isNullList:(Ljava/lang/Object;)Z
        //     4: istore_2        /* x */
        //     5: iload_2         /* x */
        //     6: ifeq            16
        //     9: iload_2         /* x */
        //    10: ifeq            46
        //    13: goto            40
        //    16: aload_0         /* pred */
        //    17: aload_1         /* lis */
        //    18: ldc             Lgnu/lists/Pair;.class
        //    20: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    23: dup            
        //    24: astore_3       
        //    25: checkcast       Lgnu/lists/Pair;
        //    28: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    31: invokevirtual   gnu/mapping/Procedure.apply1:(Ljava/lang/Object;)Ljava/lang/Object;
        //    34: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //    37: ifne            46
        //    40: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
        //    43: goto            142
        //    46: aload_1         /* lis */
        //    47: aload_1         /* lis */
        //    48: ldc             Lgnu/lists/Pair;.class
        //    50: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    53: dup            
        //    54: astore_3       
        //    55: checkcast       Lgnu/lists/Pair;
        //    58: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    61: astore          4
        //    63: astore_3        /* prev */
        //    64: aload           rest
        //    66: invokestatic    kawa/lib/lists.isPair:(Ljava/lang/Object;)Z
        //    69: ifeq            141
        //    72: aload           rest
        //    74: ldc             Lgnu/lists/Pair;.class
        //    76: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    79: dup            
        //    80: astore          6
        //    82: checkcast       Lgnu/lists/Pair;
        //    85: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    88: astore          x
        //    90: aload_0         /* pred */
        //    91: aload           x
        //    93: invokevirtual   gnu/mapping/Procedure.apply1:(Ljava/lang/Object;)Ljava/lang/Object;
        //    96: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //    99: ifeq            123
        //   102: aload           rest
        //   104: aload           rest
        //   106: ldc             Lgnu/lists/Pair;.class
        //   108: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   111: dup            
        //   112: astore          6
        //   114: checkcast       Lgnu/lists/Pair;
        //   117: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   120: goto            61
        //   123: aload_3         /* prev */
        //   124: ldc             Lgnu/lists/Pair;.class
        //   126: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   129: dup            
        //   130: astore          6
        //   132: checkcast       Lgnu/lists/Pair;
        //   135: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
        //   138: invokestatic    kawa/lib/lists.setCdr$Ex:(Lgnu/lists/Pair;Ljava/lang/Object;)V
        //   141: aload_1         /* lis */
        //   142: areturn        
        //   143: new             Lgnu/mapping/WrongType;
        //   146: dup_x1         
        //   147: swap           
        //   148: ldc             "car"
        //   150: iconst_1       
        //   151: aload_3        
        //   152: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   155: athrow         
        //   156: new             Lgnu/mapping/WrongType;
        //   159: dup_x1         
        //   160: swap           
        //   161: ldc             "cdr"
        //   163: iconst_1       
        //   164: aload_3        
        //   165: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   168: athrow         
        //   169: new             Lgnu/mapping/WrongType;
        //   172: dup_x1         
        //   173: swap           
        //   174: ldc             "car"
        //   176: iconst_1       
        //   177: aload           6
        //   179: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   182: athrow         
        //   183: new             Lgnu/mapping/WrongType;
        //   186: dup_x1         
        //   187: swap           
        //   188: ldc             "cdr"
        //   190: iconst_1       
        //   191: aload           6
        //   193: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   196: athrow         
        //   197: new             Lgnu/mapping/WrongType;
        //   200: dup_x1         
        //   201: swap           
        //   202: ldc             "set-cdr!"
        //   204: iconst_1       
        //   205: aload           6
        //   207: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   210: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  25     28     143    156    Ljava/lang/ClassCastException;
        //  55     58     156    169    Ljava/lang/ClassCastException;
        //  82     85     169    183    Ljava/lang/ClassCastException;
        //  114    117    183    197    Ljava/lang/ClassCastException;
        //  132    135    197    211    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public static Object span(final Procedure pred, final Object lis) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
        //     4: astore_3       
        //     5: astore_2        /* lis */
        //     6: aload_2         /* lis */
        //     7: invokestatic    gnu/kawa/slib/srfi1.isNullList:(Ljava/lang/Object;)Z
        //    10: ifeq            35
        //    13: aload_3         /* res */
        //    14: ldc             Lgnu/lists/LList;.class
        //    16: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    19: dup            
        //    20: astore          4
        //    22: checkcast       Lgnu/lists/LList;
        //    25: invokestatic    kawa/lib/lists.reverse$Ex:(Lgnu/lists/LList;)Lgnu/lists/LList;
        //    28: aload_2         /* lis */
        //    29: invokestatic    gnu/mapping/Values.values2:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/mapping/Values$Values2;
        //    32: goto            107
        //    35: aload_2         /* lis */
        //    36: ldc             Lgnu/lists/Pair;.class
        //    38: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    41: dup            
        //    42: astore          5
        //    44: checkcast       Lgnu/lists/Pair;
        //    47: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    50: astore          head
        //    52: aload_0         /* pred */
        //    53: aload           head
        //    55: invokevirtual   gnu/mapping/Procedure.apply1:(Ljava/lang/Object;)Ljava/lang/Object;
        //    58: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //    61: ifeq            88
        //    64: aload_2         /* lis */
        //    65: ldc             Lgnu/lists/Pair;.class
        //    67: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    70: dup            
        //    71: astore          5
        //    73: checkcast       Lgnu/lists/Pair;
        //    76: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    79: aload           head
        //    81: aload_3         /* res */
        //    82: invokestatic    kawa/lib/lists.cons:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //    85: goto            4
        //    88: aload_3         /* res */
        //    89: ldc             Lgnu/lists/LList;.class
        //    91: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    94: dup            
        //    95: astore          5
        //    97: checkcast       Lgnu/lists/LList;
        //   100: invokestatic    kawa/lib/lists.reverse$Ex:(Lgnu/lists/LList;)Lgnu/lists/LList;
        //   103: aload_2         /* lis */
        //   104: invokestatic    gnu/mapping/Values.values2:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/mapping/Values$Values2;
        //   107: areturn        
        //   108: new             Lgnu/mapping/WrongType;
        //   111: dup_x1         
        //   112: swap           
        //   113: ldc             "reverse!"
        //   115: iconst_1       
        //   116: aload           4
        //   118: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   121: athrow         
        //   122: new             Lgnu/mapping/WrongType;
        //   125: dup_x1         
        //   126: swap           
        //   127: ldc             "car"
        //   129: iconst_1       
        //   130: aload           5
        //   132: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   135: athrow         
        //   136: new             Lgnu/mapping/WrongType;
        //   139: dup_x1         
        //   140: swap           
        //   141: ldc             "cdr"
        //   143: iconst_1       
        //   144: aload           5
        //   146: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   149: athrow         
        //   150: new             Lgnu/mapping/WrongType;
        //   153: dup_x1         
        //   154: swap           
        //   155: ldc             "reverse!"
        //   157: iconst_1       
        //   158: aload           5
        //   160: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   163: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  22     25     108    122    Ljava/lang/ClassCastException;
        //  44     47     122    136    Ljava/lang/ClassCastException;
        //  73     76     136    150    Ljava/lang/ClassCastException;
        //  97     100    150    164    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public static Object span$Ex(final Procedure pred, final Object lis) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokestatic    gnu/kawa/slib/srfi1.isNullList:(Ljava/lang/Object;)Z
        //     4: istore_2        /* x */
        //     5: iload_2         /* x */
        //     6: ifeq            16
        //     9: iload_2         /* x */
        //    10: ifeq            50
        //    13: goto            40
        //    16: aload_0         /* pred */
        //    17: aload_1         /* lis */
        //    18: ldc             Lgnu/lists/Pair;.class
        //    20: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    23: dup            
        //    24: astore_3       
        //    25: checkcast       Lgnu/lists/Pair;
        //    28: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    31: invokevirtual   gnu/mapping/Procedure.apply1:(Ljava/lang/Object;)Ljava/lang/Object;
        //    34: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //    37: ifne            50
        //    40: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
        //    43: aload_1         /* lis */
        //    44: invokestatic    gnu/mapping/Values.values2:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/mapping/Values$Values2;
        //    47: goto            161
        //    50: aload_1         /* lis */
        //    51: aload_1         /* lis */
        //    52: ldc             Lgnu/lists/Pair;.class
        //    54: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    57: dup            
        //    58: astore          4
        //    60: checkcast       Lgnu/lists/Pair;
        //    63: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    66: astore          5
        //    68: astore          prev
        //    70: aload           rest
        //    72: invokestatic    gnu/kawa/slib/srfi1.isNullList:(Ljava/lang/Object;)Z
        //    75: ifeq            83
        //    78: aload           rest
        //    80: goto            155
        //    83: aload           rest
        //    85: ldc             Lgnu/lists/Pair;.class
        //    87: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    90: dup            
        //    91: astore          7
        //    93: checkcast       Lgnu/lists/Pair;
        //    96: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    99: astore          x
        //   101: aload_0         /* pred */
        //   102: aload           x
        //   104: invokevirtual   gnu/mapping/Procedure.apply1:(Ljava/lang/Object;)Ljava/lang/Object;
        //   107: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //   110: ifeq            134
        //   113: aload           rest
        //   115: aload           rest
        //   117: ldc             Lgnu/lists/Pair;.class
        //   119: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   122: dup            
        //   123: astore          7
        //   125: checkcast       Lgnu/lists/Pair;
        //   128: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   131: goto            66
        //   134: aload           prev
        //   136: ldc             Lgnu/lists/Pair;.class
        //   138: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   141: dup            
        //   142: astore          7
        //   144: checkcast       Lgnu/lists/Pair;
        //   147: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
        //   150: invokestatic    kawa/lib/lists.setCdr$Ex:(Lgnu/lists/Pair;Ljava/lang/Object;)V
        //   153: aload           rest
        //   155: astore_3        /* suffix */
        //   156: aload_1         /* lis */
        //   157: aload_3         /* suffix */
        //   158: invokestatic    gnu/mapping/Values.values2:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/mapping/Values$Values2;
        //   161: areturn        
        //   162: new             Lgnu/mapping/WrongType;
        //   165: dup_x1         
        //   166: swap           
        //   167: ldc             "car"
        //   169: iconst_1       
        //   170: aload_3        
        //   171: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   174: athrow         
        //   175: new             Lgnu/mapping/WrongType;
        //   178: dup_x1         
        //   179: swap           
        //   180: ldc             "cdr"
        //   182: iconst_1       
        //   183: aload           4
        //   185: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   188: athrow         
        //   189: new             Lgnu/mapping/WrongType;
        //   192: dup_x1         
        //   193: swap           
        //   194: ldc             "car"
        //   196: iconst_1       
        //   197: aload           7
        //   199: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   202: athrow         
        //   203: new             Lgnu/mapping/WrongType;
        //   206: dup_x1         
        //   207: swap           
        //   208: ldc             "cdr"
        //   210: iconst_1       
        //   211: aload           7
        //   213: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   216: athrow         
        //   217: new             Lgnu/mapping/WrongType;
        //   220: dup_x1         
        //   221: swap           
        //   222: ldc             "set-cdr!"
        //   224: iconst_1       
        //   225: aload           7
        //   227: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   230: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  25     28     162    175    Ljava/lang/ClassCastException;
        //  60     63     175    189    Ljava/lang/ClassCastException;
        //  93     96     189    203    Ljava/lang/ClassCastException;
        //  125    128    203    217    Ljava/lang/ClassCastException;
        //  144    147    217    231    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public static Object break(final Object pred, final Object lis) {
        public class srfi1$frame12 extends ModuleBody
        {
            Object pred;
            final ModuleMethod lambda$Fn8;
            
            public srfi1$frame12() {
                final ModuleMethod lambda$Fn8 = new ModuleMethod(this, 8, null, 4097);
                lambda$Fn8.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi1.scm:1330");
                this.lambda$Fn8 = lambda$Fn8;
            }
            
            boolean lambda21(final Object x) {
                return !KawaConvert.isTrue(Scheme.applyToArgs.apply2(this.pred, x));
            }
            
            @Override
            public int match1(final ModuleMethod moduleMethod, final Object o, final CallContext ctx) {
                if (moduleMethod.selector == 8) {
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
                if (method.selector == 8) {
                    return this.lambda21(o) ? Boolean.TRUE : Boolean.FALSE;
                }
                return super.apply1(method, o);
            }
        }
        final srfi1$frame12 $heapFrame = new srfi1$frame12();
        $heapFrame.pred = pred;
        return span($heapFrame.lambda$Fn8, lis);
    }
    
    public static Object break$Ex(final Object pred, final Object lis) {
        public class srfi1$frame13 extends ModuleBody
        {
            Object pred;
            final ModuleMethod lambda$Fn9;
            
            public srfi1$frame13() {
                final ModuleMethod lambda$Fn9 = new ModuleMethod(this, 9, null, 4097);
                lambda$Fn9.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi1.scm:1331");
                this.lambda$Fn9 = lambda$Fn9;
            }
            
            boolean lambda22(final Object x) {
                return !KawaConvert.isTrue(Scheme.applyToArgs.apply2(this.pred, x));
            }
            
            @Override
            public int match1(final ModuleMethod moduleMethod, final Object o, final CallContext ctx) {
                if (moduleMethod.selector == 9) {
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
                if (method.selector == 9) {
                    return this.lambda22(o) ? Boolean.TRUE : Boolean.FALSE;
                }
                return super.apply1(method, o);
            }
        }
        final srfi1$frame13 $heapFrame = new srfi1$frame13();
        $heapFrame.pred = pred;
        return span$Ex($heapFrame.lambda$Fn9, lis);
    }
    
    public static Object any$V(final Procedure pred, final Object lis1, final Object[] argsArray) {
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
        //    13: ifeq            159
        //    16: aload_1         /* lis1 */
        //    17: aload_3         /* lists */
        //    18: invokestatic    kawa/lib/lists.cons:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //    21: invokestatic    gnu/kawa/slib/srfi1.$PcCars$PlCdrs:(Ljava/lang/Object;)Ljava/lang/Object;
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
        //    70: ifeq            153
        //    73: aload           heads
        //    75: aload           tails
        //    77: astore          9
        //    79: astore          heads
        //    81: aload           tails
        //    83: invokestatic    gnu/kawa/slib/srfi1.$PcCars$PlCdrs$SlPair:(Ljava/lang/Object;)Lgnu/lists/Pair;
        //    86: astore          split
        //    88: aload           split
        //    90: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    93: astore          next$Mnheads
        //    95: aload           split
        //    97: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   100: astore          next$Mntails
        //   102: aload           next$Mnheads
        //   104: invokestatic    kawa/lib/lists.isPair:(Ljava/lang/Object;)Z
        //   107: ifeq            141
        //   110: getstatic       kawa/standard/Scheme.apply:Lgnu/kawa/functions/Apply;
        //   113: aload_0         /* pred */
        //   114: aload           heads
        //   116: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   119: astore          x
        //   121: aload           x
        //   123: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //   126: ifeq            134
        //   129: aload           x
        //   131: goto            276
        //   134: aload           next$Mnheads
        //   136: aload           next$Mntails
        //   138: goto            77
        //   141: getstatic       kawa/standard/Scheme.apply:Lgnu/kawa/functions/Apply;
        //   144: aload_0         /* pred */
        //   145: aload           heads
        //   147: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   150: goto            276
        //   153: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //   156: goto            276
        //   159: aload_1         /* lis1 */
        //   160: invokestatic    gnu/kawa/slib/srfi1.isNullList:(Ljava/lang/Object;)Z
        //   163: ifne            273
        //   166: aload_1         /* lis1 */
        //   167: ldc             Lgnu/lists/Pair;.class
        //   169: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   172: dup            
        //   173: astore          4
        //   175: checkcast       Lgnu/lists/Pair;
        //   178: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   181: aload_1         /* lis1 */
        //   182: ldc             Lgnu/lists/Pair;.class
        //   184: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   187: dup            
        //   188: astore          4
        //   190: checkcast       Lgnu/lists/Pair;
        //   193: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   196: astore          5
        //   198: astore          head
        //   200: aload           tail
        //   202: invokestatic    gnu/kawa/slib/srfi1.isNullList:(Ljava/lang/Object;)Z
        //   205: ifeq            217
        //   208: aload_0         /* pred */
        //   209: aload           head
        //   211: invokevirtual   gnu/mapping/Procedure.apply1:(Ljava/lang/Object;)Ljava/lang/Object;
        //   214: goto            276
        //   217: aload_0         /* pred */
        //   218: aload           head
        //   220: invokevirtual   gnu/mapping/Procedure.apply1:(Ljava/lang/Object;)Ljava/lang/Object;
        //   223: astore          x
        //   225: aload           x
        //   227: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //   230: ifeq            238
        //   233: aload           x
        //   235: goto            276
        //   238: aload           tail
        //   240: ldc             Lgnu/lists/Pair;.class
        //   242: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   245: dup            
        //   246: astore          7
        //   248: checkcast       Lgnu/lists/Pair;
        //   251: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   254: aload           tail
        //   256: ldc             Lgnu/lists/Pair;.class
        //   258: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   261: dup            
        //   262: astore          7
        //   264: checkcast       Lgnu/lists/Pair;
        //   267: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   270: goto            196
        //   273: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //   276: areturn        
        //   277: new             Lgnu/mapping/WrongType;
        //   280: dup_x1         
        //   281: swap           
        //   282: ldc             "car"
        //   284: iconst_1       
        //   285: aload           4
        //   287: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   290: athrow         
        //   291: new             Lgnu/mapping/WrongType;
        //   294: dup_x1         
        //   295: swap           
        //   296: ldc             "cdr"
        //   298: iconst_1       
        //   299: aload           4
        //   301: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   304: athrow         
        //   305: new             Lgnu/mapping/WrongType;
        //   308: dup_x1         
        //   309: swap           
        //   310: ldc             "car"
        //   312: iconst_1       
        //   313: aload           7
        //   315: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   318: athrow         
        //   319: new             Lgnu/mapping/WrongType;
        //   322: dup_x1         
        //   323: swap           
        //   324: ldc             "cdr"
        //   326: iconst_1       
        //   327: aload           7
        //   329: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   332: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  175    178    277    291    Ljava/lang/ClassCastException;
        //  190    193    291    305    Ljava/lang/ClassCastException;
        //  248    251    305    319    Ljava/lang/ClassCastException;
        //  264    267    319    333    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public static Object every$V(final Procedure pred, final Object lis1, final Object[] argsArray) {
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
        //    13: ifeq            204
        //    16: aload_1         /* lis1 */
        //    17: aload_3         /* lists */
        //    18: invokestatic    kawa/lib/lists.cons:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //    21: invokestatic    gnu/kawa/slib/srfi1.$PcCars$PlCdrs:(Ljava/lang/Object;)Ljava/lang/Object;
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
        //    93: goto            333
        //    96: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //    99: goto            333
        //   102: aload           heads
        //   104: aload           tails
        //   106: astore          10
        //   108: astore          heads
        //   110: aload           tails
        //   112: invokestatic    gnu/kawa/slib/srfi1.$PcCars$PlCdrs:(Ljava/lang/Object;)Ljava/lang/Object;
        //   115: astore          11
        //   117: iconst_0       
        //   118: istore          12
        //   120: aload           11
        //   122: iload           12
        //   124: invokestatic    gnu/mapping/Values.incrPos:(Ljava/lang/Object;I)I
        //   127: istore          12
        //   129: aload           11
        //   131: iload           12
        //   133: invokestatic    gnu/mapping/Values.getFromPos:(Ljava/lang/Object;I)Ljava/lang/Object;
        //   136: astore          13
        //   138: aload           11
        //   140: iload           12
        //   142: invokestatic    gnu/mapping/Values.incrPos:(Ljava/lang/Object;I)I
        //   145: istore          12
        //   147: aload           11
        //   149: iload           12
        //   151: invokestatic    gnu/mapping/Values.getFromPosFinal:(Ljava/lang/Object;I)Ljava/lang/Object;
        //   154: astore          next$Mntails
        //   156: aload           next$Mnheads
        //   158: invokestatic    kawa/lib/lists.isPair:(Ljava/lang/Object;)Z
        //   161: ifeq            192
        //   164: getstatic       kawa/standard/Scheme.apply:Lgnu/kawa/functions/Apply;
        //   167: aload_0         /* pred */
        //   168: aload           heads
        //   170: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   173: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //   176: ifeq            186
        //   179: aload           next$Mnheads
        //   181: aload           next$Mntails
        //   183: goto            106
        //   186: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //   189: goto            333
        //   192: getstatic       kawa/standard/Scheme.apply:Lgnu/kawa/functions/Apply;
        //   195: aload_0         /* pred */
        //   196: aload           heads
        //   198: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   201: goto            333
        //   204: aload_1         /* lis1 */
        //   205: invokestatic    gnu/kawa/slib/srfi1.isNullList:(Ljava/lang/Object;)Z
        //   208: istore          x
        //   210: iload           x
        //   212: ifeq            232
        //   215: iload           x
        //   217: ifeq            226
        //   220: getstatic       java/lang/Boolean.TRUE:Ljava/lang/Boolean;
        //   223: goto            333
        //   226: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //   229: goto            333
        //   232: aload_1         /* lis1 */
        //   233: ldc             Lgnu/lists/Pair;.class
        //   235: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   238: dup            
        //   239: astore          5
        //   241: checkcast       Lgnu/lists/Pair;
        //   244: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   247: aload_1         /* lis1 */
        //   248: ldc             Lgnu/lists/Pair;.class
        //   250: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   253: dup            
        //   254: astore          5
        //   256: checkcast       Lgnu/lists/Pair;
        //   259: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   262: astore          6
        //   264: astore          head
        //   266: aload           tail
        //   268: invokestatic    gnu/kawa/slib/srfi1.isNullList:(Ljava/lang/Object;)Z
        //   271: ifeq            283
        //   274: aload_0         /* pred */
        //   275: aload           head
        //   277: invokevirtual   gnu/mapping/Procedure.apply1:(Ljava/lang/Object;)Ljava/lang/Object;
        //   280: goto            333
        //   283: aload_0         /* pred */
        //   284: aload           head
        //   286: invokevirtual   gnu/mapping/Procedure.apply1:(Ljava/lang/Object;)Ljava/lang/Object;
        //   289: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //   292: ifeq            330
        //   295: aload           tail
        //   297: ldc             Lgnu/lists/Pair;.class
        //   299: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   302: dup            
        //   303: astore          7
        //   305: checkcast       Lgnu/lists/Pair;
        //   308: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   311: aload           tail
        //   313: ldc             Lgnu/lists/Pair;.class
        //   315: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   318: dup            
        //   319: astore          7
        //   321: checkcast       Lgnu/lists/Pair;
        //   324: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   327: goto            262
        //   330: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //   333: areturn        
        //   334: new             Lgnu/mapping/WrongType;
        //   337: dup_x1         
        //   338: swap           
        //   339: ldc             "car"
        //   341: iconst_1       
        //   342: aload           5
        //   344: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   347: athrow         
        //   348: new             Lgnu/mapping/WrongType;
        //   351: dup_x1         
        //   352: swap           
        //   353: ldc             "cdr"
        //   355: iconst_1       
        //   356: aload           5
        //   358: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   361: athrow         
        //   362: new             Lgnu/mapping/WrongType;
        //   365: dup_x1         
        //   366: swap           
        //   367: ldc             "car"
        //   369: iconst_1       
        //   370: aload           7
        //   372: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   375: athrow         
        //   376: new             Lgnu/mapping/WrongType;
        //   379: dup_x1         
        //   380: swap           
        //   381: ldc             "cdr"
        //   383: iconst_1       
        //   384: aload           7
        //   386: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   389: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  241    244    334    348    Ljava/lang/ClassCastException;
        //  256    259    348    362    Ljava/lang/ClassCastException;
        //  305    308    362    376    Ljava/lang/ClassCastException;
        //  321    324    376    390    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public static Object listIndex$V(final Procedure pred, final Object lis1, final Object[] argsArray) {
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
        //    13: ifeq            119
        //    16: aload_1         /* lis1 */
        //    17: aload_3         /* lists */
        //    18: invokestatic    kawa/lib/lists.cons:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //    21: getstatic       gnu/kawa/slib/srfi1.Lit0:Lgnu/math/IntNum;
        //    24: astore          5
        //    26: astore          lists
        //    28: aload           lists
        //    30: invokestatic    gnu/kawa/slib/srfi1.$PcCars$PlCdrs:(Ljava/lang/Object;)Ljava/lang/Object;
        //    33: astore          6
        //    35: iconst_0       
        //    36: istore          7
        //    38: aload           6
        //    40: iload           7
        //    42: invokestatic    gnu/mapping/Values.incrPos:(Ljava/lang/Object;I)I
        //    45: istore          7
        //    47: aload           6
        //    49: iload           7
        //    51: invokestatic    gnu/mapping/Values.getFromPos:(Ljava/lang/Object;I)Ljava/lang/Object;
        //    54: astore          8
        //    56: aload           6
        //    58: iload           7
        //    60: invokestatic    gnu/mapping/Values.incrPos:(Ljava/lang/Object;I)I
        //    63: istore          7
        //    65: aload           6
        //    67: iload           7
        //    69: invokestatic    gnu/mapping/Values.getFromPosFinal:(Ljava/lang/Object;I)Ljava/lang/Object;
        //    72: astore          tails
        //    74: aload           heads
        //    76: invokestatic    kawa/lib/lists.isPair:(Ljava/lang/Object;)Z
        //    79: ifeq            113
        //    82: getstatic       kawa/standard/Scheme.apply:Lgnu/kawa/functions/Apply;
        //    85: aload_0         /* pred */
        //    86: aload           heads
        //    88: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    91: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //    94: ifeq            102
        //    97: aload           n
        //    99: goto            194
        //   102: aload           tails
        //   104: aload           n
        //   106: iconst_1       
        //   107: invokestatic    gnu/math/IntNum.add:(Lgnu/math/IntNum;I)Lgnu/math/IntNum;
        //   110: goto            24
        //   113: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //   116: goto            194
        //   119: aload_1         /* lis1 */
        //   120: getstatic       gnu/kawa/slib/srfi1.Lit0:Lgnu/math/IntNum;
        //   123: astore          5
        //   125: astore          lis
        //   127: aload           lis
        //   129: invokestatic    gnu/kawa/slib/srfi1.isNullList:(Ljava/lang/Object;)Z
        //   132: ifne            191
        //   135: aload_0         /* pred */
        //   136: aload           lis
        //   138: ldc             Lgnu/lists/Pair;.class
        //   140: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   143: dup            
        //   144: astore          6
        //   146: checkcast       Lgnu/lists/Pair;
        //   149: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   152: invokevirtual   gnu/mapping/Procedure.apply1:(Ljava/lang/Object;)Ljava/lang/Object;
        //   155: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //   158: ifeq            166
        //   161: aload           n
        //   163: goto            194
        //   166: aload           lis
        //   168: ldc             Lgnu/lists/Pair;.class
        //   170: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   173: dup            
        //   174: astore          6
        //   176: checkcast       Lgnu/lists/Pair;
        //   179: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   182: aload           n
        //   184: iconst_1       
        //   185: invokestatic    gnu/math/IntNum.add:(Lgnu/math/IntNum;I)Lgnu/math/IntNum;
        //   188: goto            123
        //   191: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //   194: areturn        
        //   195: new             Lgnu/mapping/WrongType;
        //   198: dup_x1         
        //   199: swap           
        //   200: ldc             "car"
        //   202: iconst_1       
        //   203: aload           6
        //   205: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   208: athrow         
        //   209: new             Lgnu/mapping/WrongType;
        //   212: dup_x1         
        //   213: swap           
        //   214: ldc             "cdr"
        //   216: iconst_1       
        //   217: aload           6
        //   219: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   222: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  146    149    195    209    Ljava/lang/ClassCastException;
        //  176    179    209    223    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public static Object lset$Ls$Eq$V(final Procedure $Eq, final Object[] argsArray) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: iconst_0       
        //     2: invokestatic    gnu/lists/LList.makeList:([Ljava/lang/Object;I)Lgnu/lists/LList;
        //     5: dup            
        //     6: astore_3       
        //     7: astore_2        /* lists */
        //     8: aload_2         /* lists */
        //     9: invokestatic    kawa/lib/lists.isPair:(Ljava/lang/Object;)Z
        //    12: ifeq            19
        //    15: iconst_0       
        //    16: goto            20
        //    19: iconst_1       
        //    20: istore_3        /* x */
        //    21: iload_3         /* x */
        //    22: ifeq            41
        //    25: iload_3         /* x */
        //    26: ifeq            35
        //    29: getstatic       java/lang/Boolean.TRUE:Ljava/lang/Boolean;
        //    32: goto            189
        //    35: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //    38: goto            189
        //    41: aload_2         /* lists */
        //    42: dup            
        //    43: astore          4
        //    45: checkcast       Lgnu/lists/Pair;
        //    48: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    51: aload_2         /* lists */
        //    52: dup            
        //    53: astore          4
        //    55: checkcast       Lgnu/lists/Pair;
        //    58: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    61: astore          5
        //    63: astore          s1
        //    65: aload           rest
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
        //    93: goto            189
        //    96: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //    99: goto            189
        //   102: aload           rest
        //   104: ldc             Lgnu/lists/Pair;.class
        //   106: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   109: dup            
        //   110: astore          8
        //   112: checkcast       Lgnu/lists/Pair;
        //   115: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   118: astore          7
        //   120: aload           rest
        //   122: ldc             Lgnu/lists/Pair;.class
        //   124: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   127: dup            
        //   128: astore          9
        //   130: checkcast       Lgnu/lists/Pair;
        //   133: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   136: astore          rest
        //   138: aload           s2
        //   140: aload           s1
        //   142: if_acmpne       149
        //   145: iconst_1       
        //   146: goto            150
        //   149: iconst_0       
        //   150: istore          x
        //   152: iload           x
        //   154: ifeq            165
        //   157: iload           x
        //   159: ifeq            186
        //   162: goto            179
        //   165: aload_0         /* $Eq */
        //   166: aload           s1
        //   168: aload           s2
        //   170: invokestatic    gnu/kawa/slib/srfi1.$PcLset2$Ls$Eq:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   173: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //   176: ifeq            186
        //   179: aload           s2
        //   181: aload           rest
        //   183: goto            61
        //   186: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //   189: areturn        
        //   190: new             Lgnu/mapping/WrongType;
        //   193: dup_x1         
        //   194: swap           
        //   195: ldc             "car"
        //   197: iconst_1       
        //   198: aload           4
        //   200: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   203: athrow         
        //   204: new             Lgnu/mapping/WrongType;
        //   207: dup_x1         
        //   208: swap           
        //   209: ldc             "cdr"
        //   211: iconst_1       
        //   212: aload           4
        //   214: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   217: athrow         
        //   218: new             Lgnu/mapping/WrongType;
        //   221: dup_x1         
        //   222: swap           
        //   223: ldc             "car"
        //   225: iconst_1       
        //   226: aload           8
        //   228: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   231: athrow         
        //   232: new             Lgnu/mapping/WrongType;
        //   235: dup_x1         
        //   236: swap           
        //   237: ldc             "cdr"
        //   239: iconst_1       
        //   240: aload           9
        //   242: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   245: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  45     48     190    204    Ljava/lang/ClassCastException;
        //  55     58     204    218    Ljava/lang/ClassCastException;
        //  112    115    218    232    Ljava/lang/ClassCastException;
        //  130    133    232    246    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    static Object $PcLset2$Ls$Eq(final Object $Eq, final Object lis1, final Object lis2) {
        public class srfi1$frame40 extends ModuleBody
        {
            Object $Eq;
            Object lis2;
            final ModuleMethod lambda$Fn33;
            
            public srfi1$frame40() {
                final ModuleMethod lambda$Fn33 = new ModuleMethod(this, 33, null, 4097);
                lambda$Fn33.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi1.scm:1430");
                this.lambda$Fn33 = lambda$Fn33;
            }
            
            Object lambda51(final Object x) {
                final Object lis2 = this.lis2;
                final Object force = Promise.force(this.$Eq, Procedure.class);
                try {
                    return lists.member(x, lis2, (Procedure)force);
                }
                catch (ClassCastException ex) {
                    throw new WrongType(ex, "member", 3, force);
                }
            }
            
            @Override
            public int match1(final ModuleMethod moduleMethod, final Object o, final CallContext ctx) {
                if (moduleMethod.selector == 33) {
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
                if (method.selector == 33) {
                    return this.lambda51(o);
                }
                return super.apply1(method, o);
            }
        }
        final srfi1$frame40 $heapFrame = new srfi1$frame40();
        $heapFrame.$Eq = $Eq;
        $heapFrame.lis2 = lis2;
        return every$V($heapFrame.lambda$Fn33, lis1, new Object[0]);
    }
    
    public static Object lset$Eq$V(final Procedure $Eq, final Object[] argsArray) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: iconst_0       
        //     2: invokestatic    gnu/lists/LList.makeList:([Ljava/lang/Object;I)Lgnu/lists/LList;
        //     5: dup            
        //     6: astore_3       
        //     7: astore_2        /* lists */
        //     8: aload_2         /* lists */
        //     9: invokestatic    kawa/lib/lists.isPair:(Ljava/lang/Object;)Z
        //    12: ifeq            19
        //    15: iconst_0       
        //    16: goto            20
        //    19: iconst_1       
        //    20: istore_3        /* x */
        //    21: iload_3         /* x */
        //    22: ifeq            41
        //    25: iload_3         /* x */
        //    26: ifeq            35
        //    29: getstatic       java/lang/Boolean.TRUE:Ljava/lang/Boolean;
        //    32: goto            203
        //    35: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //    38: goto            203
        //    41: aload_2         /* lists */
        //    42: dup            
        //    43: astore          4
        //    45: checkcast       Lgnu/lists/Pair;
        //    48: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    51: aload_2         /* lists */
        //    52: dup            
        //    53: astore          4
        //    55: checkcast       Lgnu/lists/Pair;
        //    58: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    61: astore          5
        //    63: astore          s1
        //    65: aload           rest
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
        //    93: goto            203
        //    96: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //    99: goto            203
        //   102: aload           rest
        //   104: ldc             Lgnu/lists/Pair;.class
        //   106: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   109: dup            
        //   110: astore          8
        //   112: checkcast       Lgnu/lists/Pair;
        //   115: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   118: astore          7
        //   120: aload           rest
        //   122: ldc             Lgnu/lists/Pair;.class
        //   124: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   127: dup            
        //   128: astore          9
        //   130: checkcast       Lgnu/lists/Pair;
        //   133: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   136: astore          rest
        //   138: aload           s1
        //   140: aload           s2
        //   142: if_acmpne       149
        //   145: iconst_1       
        //   146: goto            150
        //   149: iconst_0       
        //   150: istore          x
        //   152: iload           x
        //   154: ifeq            165
        //   157: iload           x
        //   159: ifeq            200
        //   162: goto            193
        //   165: aload_0         /* $Eq */
        //   166: aload           s1
        //   168: aload           s2
        //   170: invokestatic    gnu/kawa/slib/srfi1.$PcLset2$Ls$Eq:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   173: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //   176: ifeq            200
        //   179: aload_0         /* $Eq */
        //   180: aload           s2
        //   182: aload           s1
        //   184: invokestatic    gnu/kawa/slib/srfi1.$PcLset2$Ls$Eq:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   187: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //   190: ifeq            200
        //   193: aload           s2
        //   195: aload           rest
        //   197: goto            61
        //   200: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //   203: areturn        
        //   204: new             Lgnu/mapping/WrongType;
        //   207: dup_x1         
        //   208: swap           
        //   209: ldc             "car"
        //   211: iconst_1       
        //   212: aload           4
        //   214: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   217: athrow         
        //   218: new             Lgnu/mapping/WrongType;
        //   221: dup_x1         
        //   222: swap           
        //   223: ldc             "cdr"
        //   225: iconst_1       
        //   226: aload           4
        //   228: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   231: athrow         
        //   232: new             Lgnu/mapping/WrongType;
        //   235: dup_x1         
        //   236: swap           
        //   237: ldc             "car"
        //   239: iconst_1       
        //   240: aload           8
        //   242: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   245: athrow         
        //   246: new             Lgnu/mapping/WrongType;
        //   249: dup_x1         
        //   250: swap           
        //   251: ldc             "cdr"
        //   253: iconst_1       
        //   254: aload           9
        //   256: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   259: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  45     48     204    218    Ljava/lang/ClassCastException;
        //  55     58     218    232    Ljava/lang/ClassCastException;
        //  112    115    232    246    Ljava/lang/ClassCastException;
        //  130    133    246    260    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public static Object lsetAdjoin$V(final Procedure $Eq, final Object lis, final Object[] argsArray) {
        public class srfi1$frame14 extends ModuleBody
        {
            Procedure $Eq;
            final ModuleMethod lambda$Fn10;
            
            public srfi1$frame14() {
                final ModuleMethod lambda$Fn10 = new ModuleMethod(this, 10, null, 8194);
                lambda$Fn10.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi1.scm:1453");
                this.lambda$Fn10 = lambda$Fn10;
            }
            
            Object lambda23(final Object elt, final Object ans) {
                return KawaConvert.isTrue(lists.member(elt, ans, this.$Eq)) ? ans : lists.cons(elt, ans);
            }
            
            @Override
            public int match2(final ModuleMethod moduleMethod, final Object o, final Object o2, final CallContext ctx) {
                if (moduleMethod.selector == 10) {
                    ctx.value1 = o;
                    ctx.value2 = o2;
                    ctx.proc = moduleMethod;
                    ctx.pc = 2;
                    return 0;
                }
                return super.match2(moduleMethod, o, o2, ctx);
            }
            
            @Override
            public void apply(final CallContext callContext) {
                final int pc = callContext.pc;
                ModuleMethod.applyError();
            }
            
            @Override
            public Object apply2(final ModuleMethod method, final Object o, final Object o2) {
                if (method.selector == 10) {
                    return this.lambda23(o, o2);
                }
                return super.apply2(method, o, o2);
            }
        }
        final srfi1$frame14 $heapFrame = new srfi1$frame14();
        $heapFrame.$Eq = $Eq;
        final LList elts = LList.makeList(argsArray, 0);
        return fold$V($heapFrame.lambda$Fn10, lis, elts, new Object[0]);
    }
    
    public static Object lsetUnion$V(final Procedure $Eq, final Object[] argsArray) {
        public class srfi1$frame15 extends ModuleBody
        {
            Procedure $Eq;
            final ModuleMethod lambda$Fn11;
            final ModuleMethod lambda$Fn12;
            
            public srfi1$frame15() {
                final ModuleMethod lambda$Fn12 = new ModuleMethod(this, 12, null, 8194);
                lambda$Fn12.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi1.scm:1463");
                this.lambda$Fn12 = lambda$Fn12;
                final ModuleMethod lambda$Fn13 = new ModuleMethod(this, 13, null, 8194);
                lambda$Fn13.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi1.scm:1458");
                this.lambda$Fn11 = lambda$Fn13;
            }
            
            Object lambda24(final Object lis, final Object ans) {
                return lists.isNull(lis) ? ans : (lists.isNull(ans) ? lis : ((lis == ans) ? ans : srfi1.fold$V(this.lambda$Fn12, ans, lis, new Object[0])));
            }
            
            Object lambda25(final Object elt, final Object ans) {
                public class srfi1$frame16 extends ModuleBody
                {
                    Object elt;
                    srfi1$frame15 staticLink;
                    final ModuleMethod lambda$Fn13;
                    
                    public srfi1$frame16() {
                        final ModuleMethod lambda$Fn13 = new ModuleMethod(this, 11, null, 4097);
                        lambda$Fn13.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi1.scm:1463");
                        this.lambda$Fn13 = lambda$Fn13;
                    }
                    
                    Object lambda26(final Object x) {
                        return this.staticLink.$Eq.apply2(x, this.elt);
                    }
                    
                    @Override
                    public int match1(final ModuleMethod moduleMethod, final Object o, final CallContext ctx) {
                        if (moduleMethod.selector == 11) {
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
                        if (method.selector == 11) {
                            return this.lambda26(o);
                        }
                        return super.apply1(method, o);
                    }
                }
                final srfi1$frame16 srfi1$frame16 = new srfi1$frame16();
                srfi1$frame16.staticLink = this;
                final srfi1$frame16 $heapFrame = srfi1$frame16;
                $heapFrame.elt = elt;
                return KawaConvert.isTrue(srfi1.any$V($heapFrame.lambda$Fn13, ans, new Object[0])) ? ans : lists.cons($heapFrame.elt, ans);
            }
            
            @Override
            public int match2(final ModuleMethod proc, final Object arg1, final Object arg2, final CallContext ctx) {
                switch (proc.selector) {
                    case 13: {
                        ctx.value1 = arg1;
                        ctx.value2 = arg2;
                        ctx.proc = proc;
                        ctx.pc = 2;
                        return 0;
                    }
                    case 12: {
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
            public Object apply2(final ModuleMethod method, final Object arg1, final Object arg2) {
                switch (method.selector) {
                    case 12: {
                        return this.lambda25(arg1, arg2);
                    }
                    case 13: {
                        return this.lambda24(arg1, arg2);
                    }
                    default: {
                        return super.apply2(method, arg1, arg2);
                    }
                }
            }
        }
        final srfi1$frame15 $heapFrame = new srfi1$frame15();
        $heapFrame.$Eq = $Eq;
        final LList lists = LList.makeList(argsArray, 0);
        return reduce($heapFrame.lambda$Fn11, LList.Empty, lists);
    }
    
    public static Object lsetUnion$Ex$V(final Procedure $Eq, final Object[] argsArray) {
        public class srfi1$frame17 extends ModuleBody
        {
            Procedure $Eq;
            final ModuleMethod lambda$Fn14;
            final ModuleMethod lambda$Fn15;
            
            public srfi1$frame17() {
                final ModuleMethod lambda$Fn15 = new ModuleMethod(this, 15, null, 8194);
                lambda$Fn15.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi1.scm:1475");
                this.lambda$Fn15 = lambda$Fn15;
                final ModuleMethod lambda$Fn16 = new ModuleMethod(this, 16, null, 8194);
                lambda$Fn16.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi1.scm:1470");
                this.lambda$Fn14 = lambda$Fn16;
            }
            
            Object lambda27(final Object lis, final Object ans) {
                return lists.isNull(lis) ? ans : (lists.isNull(ans) ? lis : ((lis == ans) ? ans : srfi1.pairFold$V(this.lambda$Fn15, ans, lis, new Object[0])));
            }
            
            Object lambda28(final Object pair, final Object ans) {
                public class srfi1$frame18 extends ModuleBody
                {
                    Object elt;
                    srfi1$frame17 staticLink;
                    final ModuleMethod lambda$Fn16;
                    
                    public srfi1$frame18() {
                        final ModuleMethod lambda$Fn16 = new ModuleMethod(this, 14, null, 4097);
                        lambda$Fn16.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi1.scm:1477");
                        this.lambda$Fn16 = lambda$Fn16;
                    }
                    
                    Object lambda29(final Object x) {
                        return this.staticLink.$Eq.apply2(x, this.elt);
                    }
                    
                    @Override
                    public int match1(final ModuleMethod moduleMethod, final Object o, final CallContext ctx) {
                        if (moduleMethod.selector == 14) {
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
                        if (method.selector == 14) {
                            return this.lambda29(o);
                        }
                        return super.apply1(method, o);
                    }
                }
                // 
                // This method could not be decompiled.
                // 
                // Original Bytecode:
                // 
                //     4: invokespecial   gnu/kawa/slib/srfi1$frame18.<init>:()V
                //     7: dup            
                //     8: aload_0         /* this */
                //     9: putfield        gnu/kawa/slib/srfi1$frame18.staticLink:Lgnu/kawa/slib/srfi1$frame17;
                //    12: astore_3        /* $heapFrame */
                //    13: aload_1         /* pair */
                //    14: ldc             Lgnu/lists/Pair;.class
                //    16: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //    19: dup            
                //    20: astore          4
                //    22: checkcast       Lgnu/lists/Pair;
                //    25: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
                //    28: aload_3         /* $heapFrame */
                //    29: swap           
                //    30: putfield        gnu/kawa/slib/srfi1$frame18.elt:Ljava/lang/Object;
                //    33: aload_3         /* $heapFrame */
                //    34: getfield        gnu/kawa/slib/srfi1$frame18.lambda$Fn16:Lgnu/expr/ModuleMethod;
                //    37: aload_2         /* ans */
                //    38: iconst_0       
                //    39: anewarray       Ljava/lang/Object;
                //    42: invokestatic    gnu/kawa/slib/srfi1.any$V:(Lgnu/mapping/Procedure;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
                //    45: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
                //    48: ifeq            55
                //    51: aload_2         /* ans */
                //    52: goto            72
                //    55: aload_1         /* pair */
                //    56: ldc             Lgnu/lists/Pair;.class
                //    58: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //    61: dup            
                //    62: astore          4
                //    64: checkcast       Lgnu/lists/Pair;
                //    67: aload_2         /* ans */
                //    68: invokestatic    kawa/lib/lists.setCdr$Ex:(Lgnu/lists/Pair;Ljava/lang/Object;)V
                //    71: aload_1         /* pair */
                //    72: areturn        
                //    73: new             Lgnu/mapping/WrongType;
                //    76: dup_x1         
                //    77: swap           
                //    78: ldc             "car"
                //    80: iconst_1       
                //    81: aload           4
                //    83: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //    86: athrow         
                //    87: new             Lgnu/mapping/WrongType;
                //    90: dup_x1         
                //    91: swap           
                //    92: ldc             "set-cdr!"
                //    94: iconst_1       
                //    95: aload           4
                //    97: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //   100: athrow         
                //    Exceptions:
                //  Try           Handler
                //  Start  End    Start  End    Type                          
                //  -----  -----  -----  -----  ------------------------------
                //  22     25     73     87     Ljava/lang/ClassCastException;
                //  64     67     87     101    Ljava/lang/ClassCastException;
                // 
                // The error that occurred was:
                // 
                // java.lang.IllegalStateException: Expression is linked from several locations: Label_0072:
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
            
            @Override
            public int match2(final ModuleMethod proc, final Object arg1, final Object arg2, final CallContext ctx) {
                switch (proc.selector) {
                    case 16: {
                        ctx.value1 = arg1;
                        ctx.value2 = arg2;
                        ctx.proc = proc;
                        ctx.pc = 2;
                        return 0;
                    }
                    case 15: {
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
            public Object apply2(final ModuleMethod method, final Object arg1, final Object arg2) {
                switch (method.selector) {
                    case 15: {
                        return this.lambda28(arg1, arg2);
                    }
                    case 16: {
                        return this.lambda27(arg1, arg2);
                    }
                    default: {
                        return super.apply2(method, arg1, arg2);
                    }
                }
            }
        }
        final srfi1$frame17 $heapFrame = new srfi1$frame17();
        $heapFrame.$Eq = $Eq;
        final LList lists = LList.makeList(argsArray, 0);
        return reduce($heapFrame.lambda$Fn14, LList.Empty, lists);
    }
    
    public static Object lsetIntersection$V(final Procedure $Eq, final Object lis1, final Object[] argsArray) {
        public class srfi1$frame19 extends ModuleBody
        {
            Object lists;
            Procedure $Eq;
            final ModuleMethod lambda$Fn17;
            
            public srfi1$frame19() {
                final ModuleMethod lambda$Fn17 = new ModuleMethod(this, 18, null, 4097);
                lambda$Fn17.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi1.scm:1488");
                this.lambda$Fn17 = lambda$Fn17;
            }
            
            Object lambda30(final Object x) {
                public class srfi1$frame20 extends ModuleBody
                {
                    Object x;
                    srfi1$frame19 staticLink;
                    final ModuleMethod lambda$Fn18;
                    
                    public srfi1$frame20() {
                        final ModuleMethod lambda$Fn18 = new ModuleMethod(this, 17, null, 4097);
                        lambda$Fn18.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi1.scm:1489");
                        this.lambda$Fn18 = lambda$Fn18;
                    }
                    
                    Object lambda31(final Object lis) {
                        return kawa.lib.lists.member(this.x, lis, this.staticLink.$Eq);
                    }
                    
                    @Override
                    public int match1(final ModuleMethod moduleMethod, final Object o, final CallContext ctx) {
                        if (moduleMethod.selector == 17) {
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
                        if (method.selector == 17) {
                            return this.lambda31(o);
                        }
                        return super.apply1(method, o);
                    }
                }
                final srfi1$frame20 srfi1$frame20 = new srfi1$frame20();
                srfi1$frame20.staticLink = this;
                final srfi1$frame20 $heapFrame = srfi1$frame20;
                $heapFrame.x = x;
                return srfi1.every$V($heapFrame.lambda$Fn18, this.lists, new Object[0]);
            }
            
            @Override
            public int match1(final ModuleMethod moduleMethod, final Object o, final CallContext ctx) {
                if (moduleMethod.selector == 18) {
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
                if (method.selector == 18) {
                    return this.lambda30(o);
                }
                return super.apply1(method, o);
            }
        }
        final srfi1$frame19 $heapFrame = new srfi1$frame19();
        $heapFrame.$Eq = $Eq;
        final LList lists = LList.makeList(argsArray, 0);
        $heapFrame.lists = delete(lis1, lists, Scheme.isEq);
        return KawaConvert.isTrue(any$V(srfi1.null$Mnlist$Qu, $heapFrame.lists, new Object[0])) ? LList.Empty : (kawa.lib.lists.isNull($heapFrame.lists) ? lis1 : filter($heapFrame.lambda$Fn17, lis1));
    }
    
    public static Object lsetIntersection$Ex$V(final Procedure $Eq, final Object lis1, final Object[] argsArray) {
        public class srfi1$frame21 extends ModuleBody
        {
            Object lists;
            Procedure $Eq;
            final ModuleMethod lambda$Fn19;
            
            public srfi1$frame21() {
                final ModuleMethod lambda$Fn19 = new ModuleMethod(this, 20, null, 4097);
                lambda$Fn19.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi1.scm:1496");
                this.lambda$Fn19 = lambda$Fn19;
            }
            
            Object lambda32(final Object x) {
                public class srfi1$frame22 extends ModuleBody
                {
                    Object x;
                    srfi1$frame21 staticLink;
                    final ModuleMethod lambda$Fn20;
                    
                    public srfi1$frame22() {
                        final ModuleMethod lambda$Fn20 = new ModuleMethod(this, 19, null, 4097);
                        lambda$Fn20.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi1.scm:1497");
                        this.lambda$Fn20 = lambda$Fn20;
                    }
                    
                    Object lambda33(final Object lis) {
                        return kawa.lib.lists.member(this.x, lis, this.staticLink.$Eq);
                    }
                    
                    @Override
                    public int match1(final ModuleMethod moduleMethod, final Object o, final CallContext ctx) {
                        if (moduleMethod.selector == 19) {
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
                        if (method.selector == 19) {
                            return this.lambda33(o);
                        }
                        return super.apply1(method, o);
                    }
                }
                final srfi1$frame22 srfi1$frame22 = new srfi1$frame22();
                srfi1$frame22.staticLink = this;
                final srfi1$frame22 $heapFrame = srfi1$frame22;
                $heapFrame.x = x;
                return srfi1.every$V($heapFrame.lambda$Fn20, this.lists, new Object[0]);
            }
            
            @Override
            public int match1(final ModuleMethod moduleMethod, final Object o, final CallContext ctx) {
                if (moduleMethod.selector == 20) {
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
                if (method.selector == 20) {
                    return this.lambda32(o);
                }
                return super.apply1(method, o);
            }
        }
        final srfi1$frame21 $heapFrame = new srfi1$frame21();
        $heapFrame.$Eq = $Eq;
        final LList lists = LList.makeList(argsArray, 0);
        $heapFrame.lists = delete(lis1, lists, Scheme.isEq);
        return KawaConvert.isTrue(any$V(srfi1.null$Mnlist$Qu, $heapFrame.lists, new Object[0])) ? LList.Empty : (kawa.lib.lists.isNull($heapFrame.lists) ? lis1 : filter$Ex($heapFrame.lambda$Fn19, lis1));
    }
    
    public static Object lsetDifference$V(final Procedure $Eq, final Object lis1, final Object[] argsArray) {
        public class srfi1$frame23 extends ModuleBody
        {
            Object lists;
            Procedure $Eq;
            final ModuleMethod lambda$Fn21;
            
            public srfi1$frame23() {
                final ModuleMethod lambda$Fn21 = new ModuleMethod(this, 22, null, 4097);
                lambda$Fn21.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi1.scm:1505");
                this.lambda$Fn21 = lambda$Fn21;
            }
            
            Object lambda34(final Object x) {
                public class srfi1$frame24 extends ModuleBody
                {
                    Object x;
                    srfi1$frame23 staticLink;
                    final ModuleMethod lambda$Fn22;
                    
                    public srfi1$frame24() {
                        final ModuleMethod lambda$Fn22 = new ModuleMethod(this, 21, null, 4097);
                        lambda$Fn22.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi1.scm:1506");
                        this.lambda$Fn22 = lambda$Fn22;
                    }
                    
                    boolean lambda35(final Object lis) {
                        return !KawaConvert.isTrue(kawa.lib.lists.member(this.x, lis, this.staticLink.$Eq));
                    }
                    
                    @Override
                    public int match1(final ModuleMethod moduleMethod, final Object o, final CallContext ctx) {
                        if (moduleMethod.selector == 21) {
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
                        if (method.selector == 21) {
                            return this.lambda35(o) ? Boolean.TRUE : Boolean.FALSE;
                        }
                        return super.apply1(method, o);
                    }
                }
                final srfi1$frame24 srfi1$frame24 = new srfi1$frame24();
                srfi1$frame24.staticLink = this;
                final srfi1$frame24 $heapFrame = srfi1$frame24;
                $heapFrame.x = x;
                return srfi1.every$V($heapFrame.lambda$Fn22, this.lists, new Object[0]);
            }
            
            @Override
            public int match1(final ModuleMethod moduleMethod, final Object o, final CallContext ctx) {
                if (moduleMethod.selector == 22) {
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
                if (method.selector == 22) {
                    return this.lambda34(o);
                }
                return super.apply1(method, o);
            }
        }
        final srfi1$frame23 $heapFrame = new srfi1$frame23();
        $heapFrame.$Eq = $Eq;
        final LList lists = LList.makeList(argsArray, 0);
        $heapFrame.lists = filter(kawa.lib.lists.pair$Qu, lists);
        return kawa.lib.lists.isNull($heapFrame.lists) ? lis1 : (KawaConvert.isTrue(kawa.lib.lists.memq(lis1, $heapFrame.lists)) ? LList.Empty : filter($heapFrame.lambda$Fn21, lis1));
    }
    
    public static Object lsetDifference$Ex$V(final Procedure $Eq, final Object lis1, final Object[] argsArray) {
        public class srfi1$frame25 extends ModuleBody
        {
            Object lists;
            Procedure $Eq;
            final ModuleMethod lambda$Fn23;
            
            public srfi1$frame25() {
                final ModuleMethod lambda$Fn23 = new ModuleMethod(this, 24, null, 4097);
                lambda$Fn23.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi1.scm:1514");
                this.lambda$Fn23 = lambda$Fn23;
            }
            
            Object lambda36(final Object x) {
                public class srfi1$frame26 extends ModuleBody
                {
                    Object x;
                    srfi1$frame25 staticLink;
                    final ModuleMethod lambda$Fn24;
                    
                    public srfi1$frame26() {
                        final ModuleMethod lambda$Fn24 = new ModuleMethod(this, 23, null, 4097);
                        lambda$Fn24.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi1.scm:1515");
                        this.lambda$Fn24 = lambda$Fn24;
                    }
                    
                    boolean lambda37(final Object lis) {
                        return !KawaConvert.isTrue(kawa.lib.lists.member(this.x, lis, this.staticLink.$Eq));
                    }
                    
                    @Override
                    public int match1(final ModuleMethod moduleMethod, final Object o, final CallContext ctx) {
                        if (moduleMethod.selector == 23) {
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
                        if (method.selector == 23) {
                            return this.lambda37(o) ? Boolean.TRUE : Boolean.FALSE;
                        }
                        return super.apply1(method, o);
                    }
                }
                final srfi1$frame26 srfi1$frame26 = new srfi1$frame26();
                srfi1$frame26.staticLink = this;
                final srfi1$frame26 $heapFrame = srfi1$frame26;
                $heapFrame.x = x;
                return srfi1.every$V($heapFrame.lambda$Fn24, this.lists, new Object[0]);
            }
            
            @Override
            public int match1(final ModuleMethod moduleMethod, final Object o, final CallContext ctx) {
                if (moduleMethod.selector == 24) {
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
                if (method.selector == 24) {
                    return this.lambda36(o);
                }
                return super.apply1(method, o);
            }
        }
        final srfi1$frame25 $heapFrame = new srfi1$frame25();
        $heapFrame.$Eq = $Eq;
        final LList lists = LList.makeList(argsArray, 0);
        $heapFrame.lists = filter(kawa.lib.lists.pair$Qu, lists);
        return kawa.lib.lists.isNull($heapFrame.lists) ? lis1 : (KawaConvert.isTrue(kawa.lib.lists.memq(lis1, $heapFrame.lists)) ? LList.Empty : filter$Ex($heapFrame.lambda$Fn23, lis1));
    }
    
    public static Object lsetXor$V(final Procedure $Eq, final Object[] argsArray) {
        public class srfi1$frame27 extends ModuleBody
        {
            Procedure $Eq;
            final ModuleMethod lambda$Fn25;
            
            public srfi1$frame27() {
                final ModuleMethod lambda$Fn25 = new ModuleMethod(this, 26, null, 8194);
                lambda$Fn25.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi1.scm:1521");
                this.lambda$Fn25 = lambda$Fn25;
            }
            
            Object lambda38(final Object b, final Object a) {
                public class srfi1$frame28 extends ModuleBody
                {
                    Object a$Mnint$Mnb;
                    srfi1$frame27 staticLink;
                    final ModuleMethod lambda$Fn26;
                    
                    public srfi1$frame28() {
                        final ModuleMethod lambda$Fn26 = new ModuleMethod(this, 25, null, 8194);
                        lambda$Fn26.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi1.scm:1534");
                        this.lambda$Fn26 = lambda$Fn26;
                    }
                    
                    Object lambda39(final Object xb, final Object ans) {
                        return KawaConvert.isTrue(lists.member(xb, this.a$Mnint$Mnb, this.staticLink.$Eq)) ? ans : lists.cons(xb, ans);
                    }
                    
                    @Override
                    public int match2(final ModuleMethod moduleMethod, final Object o, final Object o2, final CallContext ctx) {
                        if (moduleMethod.selector == 25) {
                            ctx.value1 = o;
                            ctx.value2 = o2;
                            ctx.proc = moduleMethod;
                            ctx.pc = 2;
                            return 0;
                        }
                        return super.match2(moduleMethod, o, o2, ctx);
                    }
                    
                    @Override
                    public void apply(final CallContext callContext) {
                        final int pc = callContext.pc;
                        ModuleMethod.applyError();
                    }
                    
                    @Override
                    public Object apply2(final ModuleMethod method, final Object o, final Object o2) {
                        if (method.selector == 25) {
                            return this.lambda39(o, o2);
                        }
                        return super.apply2(method, o, o2);
                    }
                }
                // 
                // This method could not be decompiled.
                // 
                // Original Bytecode:
                // 
                //     4: invokespecial   gnu/kawa/slib/srfi1$frame28.<init>:()V
                //     7: dup            
                //     8: aload_0         /* this */
                //     9: putfield        gnu/kawa/slib/srfi1$frame28.staticLink:Lgnu/kawa/slib/srfi1$frame27;
                //    12: astore_3        /* $heapFrame */
                //    13: aload_0         /* this */
                //    14: getfield        gnu/kawa/slib/srfi1$frame27.$Eq:Lgnu/mapping/Procedure;
                //    17: aload_2         /* a */
                //    18: iconst_1       
                //    19: anewarray       Ljava/lang/Object;
                //    22: dup            
                //    23: iconst_0       
                //    24: aload_1         /* b */
                //    25: aastore        
                //    26: invokestatic    gnu/kawa/slib/srfi1.lsetDiff$PlIntersection$V:(Lgnu/mapping/Procedure;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
                //    29: astore          4
                //    31: iconst_0       
                //    32: istore          5
                //    34: aload           4
                //    36: iload           5
                //    38: invokestatic    gnu/mapping/Values.incrPos:(Ljava/lang/Object;I)I
                //    41: istore          5
                //    43: aload           4
                //    45: iload           5
                //    47: invokestatic    gnu/mapping/Values.getFromPos:(Ljava/lang/Object;I)Ljava/lang/Object;
                //    50: astore          6
                //    52: aload           4
                //    54: iload           5
                //    56: invokestatic    gnu/mapping/Values.incrPos:(Ljava/lang/Object;I)I
                //    59: istore          5
                //    61: aload           4
                //    63: iload           5
                //    65: invokestatic    gnu/mapping/Values.getFromPosFinal:(Ljava/lang/Object;I)Ljava/lang/Object;
                //    68: aload_3         /* $heapFrame */
                //    69: swap           
                //    70: putfield        gnu/kawa/slib/srfi1$frame28.a$Mnint$Mnb:Ljava/lang/Object;
                //    73: aload           a$Mnb
                //    75: invokestatic    kawa/lib/lists.isNull:(Ljava/lang/Object;)Z
                //    78: ifeq            100
                //    81: aload_0         /* this */
                //    82: getfield        gnu/kawa/slib/srfi1$frame27.$Eq:Lgnu/mapping/Procedure;
                //    85: aload_1         /* b */
                //    86: iconst_1       
                //    87: anewarray       Ljava/lang/Object;
                //    90: dup            
                //    91: iconst_0       
                //    92: aload_2         /* a */
                //    93: aastore        
                //    94: invokestatic    gnu/kawa/slib/srfi1.lsetDifference$V:(Lgnu/mapping/Procedure;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
                //    97: goto            142
                //   100: aload_3         /* $heapFrame */
                //   101: getfield        gnu/kawa/slib/srfi1$frame28.a$Mnint$Mnb:Ljava/lang/Object;
                //   104: invokestatic    kawa/lib/lists.isNull:(Ljava/lang/Object;)Z
                //   107: ifeq            128
                //   110: iconst_2       
                //   111: anewarray       Ljava/lang/Object;
                //   114: dup            
                //   115: iconst_0       
                //   116: aload_1         /* b */
                //   117: aastore        
                //   118: dup            
                //   119: iconst_1       
                //   120: aload_2         /* a */
                //   121: aastore        
                //   122: invokestatic    kawa/standard/append.append$V:([Ljava/lang/Object;)Ljava/lang/Object;
                //   125: goto            142
                //   128: aload_3         /* $heapFrame */
                //   129: getfield        gnu/kawa/slib/srfi1$frame28.lambda$Fn26:Lgnu/expr/ModuleMethod;
                //   132: aload           a$Mnb
                //   134: aload_1         /* b */
                //   135: iconst_0       
                //   136: anewarray       Ljava/lang/Object;
                //   139: invokestatic    gnu/kawa/slib/srfi1.fold$V:(Lgnu/mapping/Procedure;Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
                //   142: areturn        
                // 
                // The error that occurred was:
                // 
                // java.lang.NullPointerException
                // 
                throw new IllegalStateException("An error occurred while decompiling this method.");
            }
            
            @Override
            public int match2(final ModuleMethod moduleMethod, final Object o, final Object o2, final CallContext ctx) {
                if (moduleMethod.selector == 26) {
                    ctx.value1 = o;
                    ctx.value2 = o2;
                    ctx.proc = moduleMethod;
                    ctx.pc = 2;
                    return 0;
                }
                return super.match2(moduleMethod, o, o2, ctx);
            }
            
            @Override
            public void apply(final CallContext callContext) {
                final int pc = callContext.pc;
                ModuleMethod.applyError();
            }
            
            @Override
            public Object apply2(final ModuleMethod method, final Object o, final Object o2) {
                if (method.selector == 26) {
                    return this.lambda38(o, o2);
                }
                return super.apply2(method, o, o2);
            }
        }
        final srfi1$frame27 $heapFrame = new srfi1$frame27();
        $heapFrame.$Eq = $Eq;
        final LList lists = LList.makeList(argsArray, 0);
        return reduce($heapFrame.lambda$Fn25, LList.Empty, lists);
    }
    
    public static Object lsetDiff$PlIntersection$V(final Procedure $Eq, final Object lis1, final Object[] argsArray) {
        public class srfi1$frame31 extends ModuleBody
        {
            LList lists;
            Procedure $Eq;
            final ModuleMethod lambda$Fn29;
            
            public srfi1$frame31() {
                final ModuleMethod lambda$Fn29 = new ModuleMethod(this, 30, null, 4097);
                lambda$Fn29.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi1.scm:1566");
                this.lambda$Fn29 = lambda$Fn29;
            }
            
            boolean lambda42(final Object elt) {
                public class srfi1$frame32 extends ModuleBody
                {
                    Object elt;
                    srfi1$frame31 staticLink;
                    final ModuleMethod lambda$Fn30;
                    
                    public srfi1$frame32() {
                        final ModuleMethod lambda$Fn30 = new ModuleMethod(this, 29, null, 4097);
                        lambda$Fn30.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi1.scm:1567");
                        this.lambda$Fn30 = lambda$Fn30;
                    }
                    
                    Object lambda43(final Object lis) {
                        return kawa.lib.lists.member(this.elt, lis, this.staticLink.$Eq);
                    }
                    
                    @Override
                    public int match1(final ModuleMethod moduleMethod, final Object o, final CallContext ctx) {
                        if (moduleMethod.selector == 29) {
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
                        if (method.selector == 29) {
                            return this.lambda43(o);
                        }
                        return super.apply1(method, o);
                    }
                }
                final srfi1$frame32 srfi1$frame32 = new srfi1$frame32();
                srfi1$frame32.staticLink = this;
                final srfi1$frame32 $heapFrame = srfi1$frame32;
                $heapFrame.elt = elt;
                return !KawaConvert.isTrue(srfi1.any$V($heapFrame.lambda$Fn30, this.lists, new Object[0]));
            }
            
            @Override
            public int match1(final ModuleMethod moduleMethod, final Object o, final CallContext ctx) {
                if (moduleMethod.selector == 30) {
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
                if (method.selector == 30) {
                    return this.lambda42(o) ? Boolean.TRUE : Boolean.FALSE;
                }
                return super.apply1(method, o);
            }
        }
        final srfi1$frame31 $heapFrame = new srfi1$frame31();
        $heapFrame.$Eq = $Eq;
        $heapFrame.lists = LList.makeList(argsArray, 0);
        return KawaConvert.isTrue(every$V(srfi1.null$Mnlist$Qu, $heapFrame.lists, new Object[0])) ? Values.values2(lis1, LList.Empty) : (KawaConvert.isTrue(lists.memq(lis1, $heapFrame.lists)) ? Values.values2(LList.Empty, lis1) : partition($heapFrame.lambda$Fn29, lis1));
    }
    
    public static Object lsetXor$Ex$V(final Procedure $Eq, final Object[] argsArray) {
        public class srfi1$frame29 extends ModuleBody
        {
            Procedure $Eq;
            final ModuleMethod lambda$Fn27;
            
            public srfi1$frame29() {
                final ModuleMethod lambda$Fn27 = new ModuleMethod(this, 28, null, 8194);
                lambda$Fn27.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi1.scm:1542");
                this.lambda$Fn27 = lambda$Fn27;
            }
            
            Object lambda40(final Object b, final Object a) {
                public class srfi1$frame30 extends ModuleBody
                {
                    Object a$Mnint$Mnb;
                    srfi1$frame29 staticLink;
                    final ModuleMethod lambda$Fn28;
                    
                    public srfi1$frame30() {
                        final ModuleMethod lambda$Fn28 = new ModuleMethod(this, 27, null, 8194);
                        lambda$Fn28.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi1.scm:1555");
                        this.lambda$Fn28 = lambda$Fn28;
                    }
                    
                    Object lambda41(final Object b$Mnpair, final Object ans) {
                        // 
                        // This method could not be decompiled.
                        // 
                        // Original Bytecode:
                        // 
                        //     3: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                        //     6: dup            
                        //     7: astore_3       
                        //     8: checkcast       Lgnu/lists/Pair;
                        //    11: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
                        //    14: aload_0         /* this */
                        //    15: getfield        gnu/kawa/slib/srfi1$frame30.a$Mnint$Mnb:Ljava/lang/Object;
                        //    18: aload_0         /* this */
                        //    19: getfield        gnu/kawa/slib/srfi1$frame30.staticLink:Lgnu/kawa/slib/srfi1$frame29;
                        //    22: getfield        gnu/kawa/slib/srfi1$frame29.$Eq:Lgnu/mapping/Procedure;
                        //    25: invokestatic    kawa/lib/lists.member:(Ljava/lang/Object;Ljava/lang/Object;Lgnu/mapping/Procedure;)Ljava/lang/Object;
                        //    28: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
                        //    31: ifeq            38
                        //    34: aload_2         /* ans */
                        //    35: goto            54
                        //    38: aload_1         /* b$Mnpair */
                        //    39: ldc             Lgnu/lists/Pair;.class
                        //    41: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                        //    44: dup            
                        //    45: astore_3       
                        //    46: checkcast       Lgnu/lists/Pair;
                        //    49: aload_2         /* ans */
                        //    50: invokestatic    kawa/lib/lists.setCdr$Ex:(Lgnu/lists/Pair;Ljava/lang/Object;)V
                        //    53: aload_1         /* b$Mnpair */
                        //    54: areturn        
                        //    55: new             Lgnu/mapping/WrongType;
                        //    58: dup_x1         
                        //    59: swap           
                        //    60: ldc             "car"
                        //    62: iconst_1       
                        //    63: aload_3        
                        //    64: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                        //    67: athrow         
                        //    68: new             Lgnu/mapping/WrongType;
                        //    71: dup_x1         
                        //    72: swap           
                        //    73: ldc             "set-cdr!"
                        //    75: iconst_1       
                        //    76: aload_3        
                        //    77: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                        //    80: athrow         
                        //    Exceptions:
                        //  Try           Handler
                        //  Start  End    Start  End    Type                          
                        //  -----  -----  -----  -----  ------------------------------
                        //  8      11     55     68     Ljava/lang/ClassCastException;
                        //  46     49     68     81     Ljava/lang/ClassCastException;
                        // 
                        // The error that occurred was:
                        // 
                        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0054:
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
                    public int match2(final ModuleMethod moduleMethod, final Object o, final Object o2, final CallContext ctx) {
                        if (moduleMethod.selector == 27) {
                            ctx.value1 = o;
                            ctx.value2 = o2;
                            ctx.proc = moduleMethod;
                            ctx.pc = 2;
                            return 0;
                        }
                        return super.match2(moduleMethod, o, o2, ctx);
                    }
                    
                    @Override
                    public void apply(final CallContext callContext) {
                        final int pc = callContext.pc;
                        ModuleMethod.applyError();
                    }
                    
                    @Override
                    public Object apply2(final ModuleMethod method, final Object o, final Object o2) {
                        if (method.selector == 27) {
                            return this.lambda41(o, o2);
                        }
                        return super.apply2(method, o, o2);
                    }
                }
                // 
                // This method could not be decompiled.
                // 
                // Original Bytecode:
                // 
                //     4: invokespecial   gnu/kawa/slib/srfi1$frame30.<init>:()V
                //     7: dup            
                //     8: aload_0         /* this */
                //     9: putfield        gnu/kawa/slib/srfi1$frame30.staticLink:Lgnu/kawa/slib/srfi1$frame29;
                //    12: astore_3        /* $heapFrame */
                //    13: aload_0         /* this */
                //    14: getfield        gnu/kawa/slib/srfi1$frame29.$Eq:Lgnu/mapping/Procedure;
                //    17: aload_2         /* a */
                //    18: iconst_1       
                //    19: anewarray       Ljava/lang/Object;
                //    22: dup            
                //    23: iconst_0       
                //    24: aload_1         /* b */
                //    25: aastore        
                //    26: invokestatic    gnu/kawa/slib/srfi1.lsetDiff$PlIntersection$Ex$V:(Lgnu/mapping/Procedure;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
                //    29: astore          4
                //    31: iconst_0       
                //    32: istore          5
                //    34: aload           4
                //    36: iload           5
                //    38: invokestatic    gnu/mapping/Values.incrPos:(Ljava/lang/Object;I)I
                //    41: istore          5
                //    43: aload           4
                //    45: iload           5
                //    47: invokestatic    gnu/mapping/Values.getFromPos:(Ljava/lang/Object;I)Ljava/lang/Object;
                //    50: astore          6
                //    52: aload           4
                //    54: iload           5
                //    56: invokestatic    gnu/mapping/Values.incrPos:(Ljava/lang/Object;I)I
                //    59: istore          5
                //    61: aload           4
                //    63: iload           5
                //    65: invokestatic    gnu/mapping/Values.getFromPosFinal:(Ljava/lang/Object;I)Ljava/lang/Object;
                //    68: aload_3         /* $heapFrame */
                //    69: swap           
                //    70: putfield        gnu/kawa/slib/srfi1$frame30.a$Mnint$Mnb:Ljava/lang/Object;
                //    73: aload           a$Mnb
                //    75: invokestatic    kawa/lib/lists.isNull:(Ljava/lang/Object;)Z
                //    78: ifeq            100
                //    81: aload_0         /* this */
                //    82: getfield        gnu/kawa/slib/srfi1$frame29.$Eq:Lgnu/mapping/Procedure;
                //    85: aload_1         /* b */
                //    86: iconst_1       
                //    87: anewarray       Ljava/lang/Object;
                //    90: dup            
                //    91: iconst_0       
                //    92: aload_2         /* a */
                //    93: aastore        
                //    94: invokestatic    gnu/kawa/slib/srfi1.lsetDifference$Ex$V:(Lgnu/mapping/Procedure;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
                //    97: goto            142
                //   100: aload_3         /* $heapFrame */
                //   101: getfield        gnu/kawa/slib/srfi1$frame30.a$Mnint$Mnb:Ljava/lang/Object;
                //   104: invokestatic    kawa/lib/lists.isNull:(Ljava/lang/Object;)Z
                //   107: ifeq            128
                //   110: iconst_2       
                //   111: anewarray       Ljava/lang/Object;
                //   114: dup            
                //   115: iconst_0       
                //   116: aload_1         /* b */
                //   117: aastore        
                //   118: dup            
                //   119: iconst_1       
                //   120: aload_2         /* a */
                //   121: aastore        
                //   122: invokestatic    gnu/kawa/slib/srfi1.append$Ex$V:([Ljava/lang/Object;)Ljava/lang/Object;
                //   125: goto            142
                //   128: aload_3         /* $heapFrame */
                //   129: getfield        gnu/kawa/slib/srfi1$frame30.lambda$Fn28:Lgnu/expr/ModuleMethod;
                //   132: aload           a$Mnb
                //   134: aload_1         /* b */
                //   135: iconst_0       
                //   136: anewarray       Ljava/lang/Object;
                //   139: invokestatic    gnu/kawa/slib/srfi1.pairFold$V:(Lgnu/mapping/Procedure;Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
                //   142: areturn        
                // 
                // The error that occurred was:
                // 
                // java.lang.NullPointerException
                // 
                throw new IllegalStateException("An error occurred while decompiling this method.");
            }
            
            @Override
            public int match2(final ModuleMethod moduleMethod, final Object o, final Object o2, final CallContext ctx) {
                if (moduleMethod.selector == 28) {
                    ctx.value1 = o;
                    ctx.value2 = o2;
                    ctx.proc = moduleMethod;
                    ctx.pc = 2;
                    return 0;
                }
                return super.match2(moduleMethod, o, o2, ctx);
            }
            
            @Override
            public void apply(final CallContext callContext) {
                final int pc = callContext.pc;
                ModuleMethod.applyError();
            }
            
            @Override
            public Object apply2(final ModuleMethod method, final Object o, final Object o2) {
                if (method.selector == 28) {
                    return this.lambda40(o, o2);
                }
                return super.apply2(method, o, o2);
            }
        }
        final srfi1$frame29 $heapFrame = new srfi1$frame29();
        $heapFrame.$Eq = $Eq;
        final LList lists = LList.makeList(argsArray, 0);
        return reduce($heapFrame.lambda$Fn27, LList.Empty, lists);
    }
    
    public static Object lsetDiff$PlIntersection$Ex$V(final Procedure $Eq, final Object lis1, final Object[] argsArray) {
        public class srfi1$frame33 extends ModuleBody
        {
            LList lists;
            Procedure $Eq;
            final ModuleMethod lambda$Fn31;
            
            public srfi1$frame33() {
                final ModuleMethod lambda$Fn31 = new ModuleMethod(this, 32, null, 4097);
                lambda$Fn31.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi1.scm:1574");
                this.lambda$Fn31 = lambda$Fn31;
            }
            
            boolean lambda44(final Object elt) {
                public class srfi1$frame34 extends ModuleBody
                {
                    Object elt;
                    srfi1$frame33 staticLink;
                    final ModuleMethod lambda$Fn32;
                    
                    public srfi1$frame34() {
                        final ModuleMethod lambda$Fn32 = new ModuleMethod(this, 31, null, 4097);
                        lambda$Fn32.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi1.scm:1575");
                        this.lambda$Fn32 = lambda$Fn32;
                    }
                    
                    Object lambda45(final Object lis) {
                        return kawa.lib.lists.member(this.elt, lis, this.staticLink.$Eq);
                    }
                    
                    @Override
                    public int match1(final ModuleMethod moduleMethod, final Object o, final CallContext ctx) {
                        if (moduleMethod.selector == 31) {
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
                        if (method.selector == 31) {
                            return this.lambda45(o);
                        }
                        return super.apply1(method, o);
                    }
                }
                final srfi1$frame34 srfi1$frame34 = new srfi1$frame34();
                srfi1$frame34.staticLink = this;
                final srfi1$frame34 $heapFrame = srfi1$frame34;
                $heapFrame.elt = elt;
                return !KawaConvert.isTrue(srfi1.any$V($heapFrame.lambda$Fn32, this.lists, new Object[0]));
            }
            
            @Override
            public int match1(final ModuleMethod moduleMethod, final Object o, final CallContext ctx) {
                if (moduleMethod.selector == 32) {
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
                if (method.selector == 32) {
                    return this.lambda44(o) ? Boolean.TRUE : Boolean.FALSE;
                }
                return super.apply1(method, o);
            }
        }
        final srfi1$frame33 $heapFrame = new srfi1$frame33();
        $heapFrame.$Eq = $Eq;
        $heapFrame.lists = LList.makeList(argsArray, 0);
        return KawaConvert.isTrue(every$V(srfi1.null$Mnlist$Qu, $heapFrame.lists, new Object[0])) ? Values.values2(lis1, LList.Empty) : (KawaConvert.isTrue(lists.memq(lis1, $heapFrame.lists)) ? Values.values2(LList.Empty, lis1) : partition$Ex($heapFrame.lambda$Fn31, lis1));
    }
    
    static Object $PcCars$PlCdrs$SlNoTest(final Object lists) {
        return lambda50recur(lists);
    }
    
    public static Object lambda50recur(final Object lists) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokestatic    kawa/lib/lists.isPair:(Ljava/lang/Object;)Z
        //     4: ifeq            150
        //     7: aload_0         /* lists */
        //     8: invokestatic    gnu/kawa/slib/srfi1.car$PlCdr:(Ljava/lang/Object;)Lgnu/mapping/Values;
        //    11: astore_1       
        //    12: iconst_0       
        //    13: istore_2       
        //    14: aload_1        
        //    15: iload_2        
        //    16: invokestatic    gnu/mapping/Values.incrPos:(Ljava/lang/Object;I)I
        //    19: istore_2       
        //    20: aload_1        
        //    21: iload_2        
        //    22: invokestatic    gnu/mapping/Values.getFromPos:(Ljava/lang/Object;I)Ljava/lang/Object;
        //    25: astore_3       
        //    26: aload_1        
        //    27: iload_2        
        //    28: invokestatic    gnu/mapping/Values.incrPos:(Ljava/lang/Object;I)I
        //    31: istore_2       
        //    32: aload_1        
        //    33: iload_2        
        //    34: invokestatic    gnu/mapping/Values.getFromPosFinal:(Ljava/lang/Object;I)Ljava/lang/Object;
        //    37: astore          other$Mnlists
        //    39: aload_3         /* list */
        //    40: invokestatic    gnu/kawa/slib/srfi1.car$PlCdr:(Ljava/lang/Object;)Lgnu/mapping/Values;
        //    43: astore          5
        //    45: iconst_0       
        //    46: istore          6
        //    48: aload           5
        //    50: iload           6
        //    52: invokestatic    gnu/mapping/Values.incrPos:(Ljava/lang/Object;I)I
        //    55: istore          6
        //    57: aload           5
        //    59: iload           6
        //    61: invokestatic    gnu/mapping/Values.getFromPos:(Ljava/lang/Object;I)Ljava/lang/Object;
        //    64: astore          7
        //    66: aload           5
        //    68: iload           6
        //    70: invokestatic    gnu/mapping/Values.incrPos:(Ljava/lang/Object;I)I
        //    73: istore          6
        //    75: aload           5
        //    77: iload           6
        //    79: invokestatic    gnu/mapping/Values.getFromPosFinal:(Ljava/lang/Object;I)Ljava/lang/Object;
        //    82: astore          d
        //    84: aload           other$Mnlists
        //    86: invokestatic    gnu/kawa/slib/srfi1.lambda50recur:(Ljava/lang/Object;)Ljava/lang/Object;
        //    89: astore          9
        //    91: iconst_0       
        //    92: istore          10
        //    94: aload           9
        //    96: iload           10
        //    98: invokestatic    gnu/mapping/Values.incrPos:(Ljava/lang/Object;I)I
        //   101: istore          10
        //   103: aload           9
        //   105: iload           10
        //   107: invokestatic    gnu/mapping/Values.getFromPos:(Ljava/lang/Object;I)Ljava/lang/Object;
        //   110: astore          11
        //   112: aload           9
        //   114: iload           10
        //   116: invokestatic    gnu/mapping/Values.incrPos:(Ljava/lang/Object;I)I
        //   119: istore          10
        //   121: aload           9
        //   123: iload           10
        //   125: invokestatic    gnu/mapping/Values.getFromPosFinal:(Ljava/lang/Object;I)Ljava/lang/Object;
        //   128: astore          cdrs
        //   130: aload           a
        //   132: aload           cars
        //   134: invokestatic    kawa/lib/lists.cons:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //   137: aload           d
        //   139: aload           cdrs
        //   141: invokestatic    kawa/lib/lists.cons:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //   144: invokestatic    gnu/mapping/Values.values2:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/mapping/Values$Values2;
        //   147: goto            159
        //   150: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
        //   153: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
        //   156: invokestatic    gnu/mapping/Values.values2:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/mapping/Values$Values2;
        //   159: areturn        
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    static {
        Lit104 = Symbol.valueOf("cdr");
        Lit103 = PairWithPosition.make(Lit99 = Symbol.valueOf("tail"), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi1.scm", 5668888);
        Lit102 = Symbol.valueOf("car");
        Lit101 = Symbol.valueOf("lp");
        Lit100 = Symbol.valueOf("head");
        Lit98 = new Object[0];
        Lit97 = Symbol.valueOf("lset-diff+intersection!");
        Lit96 = Symbol.valueOf("lset-diff+intersection");
        Lit95 = Symbol.valueOf("lset-xor!");
        Lit94 = Symbol.valueOf("lset-xor");
        Lit93 = Symbol.valueOf("lset-difference!");
        Lit92 = Symbol.valueOf("lset-difference");
        Lit91 = Symbol.valueOf("lset-intersection!");
        Lit90 = Symbol.valueOf("lset-intersection");
        Lit89 = Symbol.valueOf("lset-union!");
        Lit88 = Symbol.valueOf("lset-union");
        Lit87 = Symbol.valueOf("lset-adjoin");
        Lit86 = Symbol.valueOf("lset=");
        Lit85 = Symbol.valueOf("lset<=");
        Lit84 = Symbol.valueOf("list-index");
        Lit83 = new SyntaxRules(srfi1.Lit98, new SyntaxRule[] { new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\f\u000f\b", srfi1.Lit98, 2, "srfi1.scm:1382"), "\u0001\u0001", "\u0011\u0018\u0004\u0011\u0018\f¡I\u0011\u0018\u0014\b\u0011\u0018\u001c\b\u000b\b\u0011\u0018$\b\u0011\u0018,\b\u000b\b\u0011\u00184\u0011\u0018<!\t\u0003\u0018D\u0018L", new Object[] { Symbol.valueOf("let"), srfi1.Lit101, srfi1.Lit100, srfi1.Lit102, srfi1.Lit99, srfi1.Lit104, Symbol.valueOf("and"), PairWithPosition.make(Lit12 = Symbol.valueOf("null-list?"), srfi1.Lit103, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi1.scm", 5668876), PairWithPosition.make(srfi1.Lit100, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi1.scm", 5668900), PairWithPosition.make(PairWithPosition.make(srfi1.Lit101, PairWithPosition.make(PairWithPosition.make(srfi1.Lit102, srfi1.Lit103, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi1.scm", 5668910), PairWithPosition.make(PairWithPosition.make(srfi1.Lit104, srfi1.Lit103, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi1.scm", 5668921), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi1.scm", 5668921), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi1.scm", 5668910), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi1.scm", 5668906), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi1.scm", 5668906) }, 0) }, 2, Lit82 = Symbol.valueOf("%every"));
        Lit81 = Symbol.valueOf("every");
        Lit80 = Symbol.valueOf("any");
        Lit79 = Symbol.valueOf("break!");
        Lit78 = Symbol.valueOf("break");
        Lit77 = Symbol.valueOf("span!");
        Lit76 = Symbol.valueOf("span");
        Lit75 = Symbol.valueOf("take-while!");
        Lit74 = Symbol.valueOf("drop-while");
        Lit73 = Symbol.valueOf("take-while");
        Lit72 = Symbol.valueOf("find-tail");
        Lit71 = Symbol.valueOf("find");
        Lit70 = Symbol.valueOf("alist-delete!");
        Lit69 = Symbol.valueOf("alist-delete");
        Lit68 = Symbol.valueOf("alist-copy");
        Lit67 = Symbol.valueOf("alist-cons");
        Lit66 = Symbol.valueOf("delete-duplicates!");
        Lit65 = Symbol.valueOf("delete-duplicates");
        Lit64 = Symbol.valueOf("delete!");
        Lit63 = Symbol.valueOf("delete");
        Lit62 = Symbol.valueOf("remove!");
        Lit61 = Symbol.valueOf("remove");
        Lit60 = Symbol.valueOf("partition!");
        Lit59 = Symbol.valueOf("partition");
        Lit58 = Symbol.valueOf("filter!");
        Lit57 = Symbol.valueOf("filter");
        Lit56 = Symbol.valueOf("filter-map");
        Lit55 = Symbol.valueOf("map!");
        Lit54 = Symbol.valueOf("pair-for-each");
        Lit53 = Symbol.valueOf("append-map!");
        Lit52 = Symbol.valueOf("append-map");
        Lit51 = Symbol.valueOf("reduce-right");
        Lit50 = Symbol.valueOf("reduce");
        Lit49 = Symbol.valueOf("pair-fold");
        Lit48 = Symbol.valueOf("pair-fold-right");
        Lit47 = Symbol.valueOf("fold-right");
        Lit46 = Symbol.valueOf("fold");
        Lit45 = Symbol.valueOf("unfold");
        Lit44 = Symbol.valueOf("unfold-right");
        Lit43 = Symbol.valueOf("count");
        Lit42 = Symbol.valueOf("concatenate!");
        Lit41 = Symbol.valueOf("concatenate");
        Lit40 = Symbol.valueOf("append-reverse!");
        Lit39 = Symbol.valueOf("append-reverse");
        Lit38 = Symbol.valueOf("append!");
        Lit37 = Symbol.valueOf("unzip5");
        Lit36 = Symbol.valueOf("unzip4");
        Lit35 = Symbol.valueOf("unzip3");
        Lit34 = Symbol.valueOf("unzip2");
        Lit33 = Symbol.valueOf("unzip1");
        Lit32 = Symbol.valueOf("last-pair");
        Lit31 = Symbol.valueOf("last");
        Lit30 = Symbol.valueOf("split-at!");
        Lit29 = Symbol.valueOf("split-at");
        Lit28 = Symbol.valueOf("drop-right!");
        Lit27 = Symbol.valueOf("drop-right");
        Lit26 = Symbol.valueOf("take-right");
        Lit25 = Symbol.valueOf("take!");
        Lit24 = Symbol.valueOf("drop");
        Lit23 = Symbol.valueOf("take");
        Lit22 = Symbol.valueOf("car+cdr");
        Lit21 = Symbol.valueOf("tenth");
        Lit20 = Symbol.valueOf("ninth");
        Lit19 = Symbol.valueOf("eighth");
        Lit18 = Symbol.valueOf("seventh");
        Lit17 = Symbol.valueOf("sixth");
        Lit16 = Symbol.valueOf("fifth");
        Lit15 = Symbol.valueOf("zip");
        Lit14 = Symbol.valueOf("length+");
        Lit13 = Symbol.valueOf("list=");
        Lit11 = Symbol.valueOf("not-pair?");
        Lit10 = Symbol.valueOf("circular-list?");
        Lit9 = Symbol.valueOf("dotted-list?");
        Lit8 = Symbol.valueOf("proper-list?");
        Lit7 = Symbol.valueOf("circular-list");
        Lit6 = Symbol.valueOf("iota");
        Lit5 = Symbol.valueOf("cons*");
        Lit4 = Symbol.valueOf("list-tabulate");
        Lit3 = Symbol.valueOf("xcons");
        Lit2 = Symbol.valueOf("tmp");
        Lit1 = IntNum.valueOf(1);
        Lit0 = IntNum.valueOf(0);
        srfi1.$instance = new srfi1();
        final srfi1 $instance = srfi1.$instance;
        xcons = new ModuleMethod($instance, 34, srfi1.Lit3, 8194);
        list$Mntabulate = new ModuleMethod($instance, 35, srfi1.Lit4, 8194);
        cons$St = new ModuleMethod($instance, 36, srfi1.Lit5, -4096);
        iota = new ModuleMethod($instance, 37, srfi1.Lit6, 12289);
        circular$Mnlist = new ModuleMethod($instance, 40, srfi1.Lit7, -4095);
        proper$Mnlist$Qu = new ModuleMethod($instance, 41, srfi1.Lit8, 4097);
        dotted$Mnlist$Qu = new ModuleMethod($instance, 42, srfi1.Lit9, 4097);
        circular$Mnlist$Qu = new ModuleMethod($instance, 43, srfi1.Lit10, 4097);
        not$Mnpair$Qu = new ModuleMethod($instance, 44, srfi1.Lit11, 4097);
        null$Mnlist$Qu = new ModuleMethod($instance, 45, srfi1.Lit12, 4097);
        list$Eq = new ModuleMethod($instance, 46, srfi1.Lit13, -4095);
        length$Pl = new ModuleMethod($instance, 47, srfi1.Lit14, 4097);
        zip = new ModuleMethod($instance, 48, srfi1.Lit15, -4095);
        fifth = new ModuleMethod($instance, 49, srfi1.Lit16, 4097);
        sixth = new ModuleMethod($instance, 50, srfi1.Lit17, 4097);
        seventh = new ModuleMethod($instance, 51, srfi1.Lit18, 4097);
        eighth = new ModuleMethod($instance, 52, srfi1.Lit19, 4097);
        ninth = new ModuleMethod($instance, 53, srfi1.Lit20, 4097);
        tenth = new ModuleMethod($instance, 54, srfi1.Lit21, 4097);
        car$Plcdr = new ModuleMethod($instance, 55, srfi1.Lit22, 4097);
        take = new ModuleMethod($instance, 56, srfi1.Lit23, 8194);
        drop = new ModuleMethod($instance, 57, srfi1.Lit24, 8194);
        take$Ex = new ModuleMethod($instance, 58, srfi1.Lit25, 8194);
        take$Mnright = new ModuleMethod($instance, 59, srfi1.Lit26, 8194);
        drop$Mnright = new ModuleMethod($instance, 60, srfi1.Lit27, 8194);
        drop$Mnright$Ex = new ModuleMethod($instance, 61, srfi1.Lit28, 8194);
        split$Mnat = new ModuleMethod($instance, 62, srfi1.Lit29, 8194);
        split$Mnat$Ex = new ModuleMethod($instance, 63, srfi1.Lit30, 8194);
        last = new ModuleMethod($instance, 64, srfi1.Lit31, 4097);
        last$Mnpair = new ModuleMethod($instance, 65, srfi1.Lit32, 4097);
        unzip1 = new ModuleMethod($instance, 66, srfi1.Lit33, 4097);
        unzip2 = new ModuleMethod($instance, 67, srfi1.Lit34, 4097);
        unzip3 = new ModuleMethod($instance, 68, srfi1.Lit35, 4097);
        unzip4 = new ModuleMethod($instance, 69, srfi1.Lit36, 4097);
        unzip5 = new ModuleMethod($instance, 70, srfi1.Lit37, 4097);
        append$Ex = new ModuleMethod($instance, 71, srfi1.Lit38, -4096);
        append$Mnreverse = new ModuleMethod($instance, 72, srfi1.Lit39, 8194);
        append$Mnreverse$Ex = new ModuleMethod($instance, 73, srfi1.Lit40, 8194);
        concatenate = new ModuleMethod($instance, 74, srfi1.Lit41, 4097);
        concatenate$Ex = new ModuleMethod($instance, 75, srfi1.Lit42, 4097);
        count = new ModuleMethod($instance, 76, srfi1.Lit43, -4094);
        unfold$Mnright = new ModuleMethod($instance, 77, srfi1.Lit44, 20484);
        unfold = new ModuleMethod($instance, 79, srfi1.Lit45, -4092);
        fold = new ModuleMethod($instance, 80, srfi1.Lit46, -4093);
        fold$Mnright = new ModuleMethod($instance, 81, srfi1.Lit47, -4093);
        pair$Mnfold$Mnright = new ModuleMethod($instance, 82, srfi1.Lit48, -4093);
        pair$Mnfold = new ModuleMethod($instance, 83, srfi1.Lit49, -4093);
        reduce = new ModuleMethod($instance, 84, srfi1.Lit50, 12291);
        reduce$Mnright = new ModuleMethod($instance, 85, srfi1.Lit51, 12291);
        append$Mnmap = new ModuleMethod($instance, 86, srfi1.Lit52, -4094);
        append$Mnmap$Ex = new ModuleMethod($instance, 87, srfi1.Lit53, -4094);
        pair$Mnfor$Mneach = new ModuleMethod($instance, 88, srfi1.Lit54, -4094);
        map$Ex = new ModuleMethod($instance, 89, srfi1.Lit55, -4094);
        filter$Mnmap = new ModuleMethod($instance, 90, srfi1.Lit56, -4094);
        filter = new ModuleMethod($instance, 91, srfi1.Lit57, 8194);
        filter$Ex = new ModuleMethod($instance, 92, srfi1.Lit58, 8194);
        partition = new ModuleMethod($instance, 93, srfi1.Lit59, 8194);
        partition$Ex = new ModuleMethod($instance, 94, srfi1.Lit60, 8194);
        remove = new ModuleMethod($instance, 95, srfi1.Lit61, 8194);
        remove$Ex = new ModuleMethod($instance, 96, srfi1.Lit62, 8194);
        delete = new ModuleMethod($instance, 97, srfi1.Lit63, 12290);
        delete$Ex = new ModuleMethod($instance, 99, srfi1.Lit64, 12290);
        delete$Mnduplicates = new ModuleMethod($instance, 101, srfi1.Lit65, 8193);
        delete$Mnduplicates$Ex = new ModuleMethod($instance, 103, srfi1.Lit66, 8193);
        alist$Mncons = new ModuleMethod($instance, 105, srfi1.Lit67, 12291);
        alist$Mncopy = new ModuleMethod($instance, 106, srfi1.Lit68, 4097);
        alist$Mndelete = new ModuleMethod($instance, 107, srfi1.Lit69, 12290);
        alist$Mndelete$Ex = new ModuleMethod($instance, 109, srfi1.Lit70, 12290);
        find = new ModuleMethod($instance, 111, srfi1.Lit71, 8194);
        find$Mntail = new ModuleMethod($instance, 112, srfi1.Lit72, 8194);
        take$Mnwhile = new ModuleMethod($instance, 113, srfi1.Lit73, 8194);
        drop$Mnwhile = new ModuleMethod($instance, 114, srfi1.Lit74, 8194);
        take$Mnwhile$Ex = new ModuleMethod($instance, 115, srfi1.Lit75, 8194);
        span = new ModuleMethod($instance, 116, srfi1.Lit76, 8194);
        span$Ex = new ModuleMethod($instance, 117, srfi1.Lit77, 8194);
        break = new ModuleMethod($instance, 118, srfi1.Lit78, 8194);
        break$Ex = new ModuleMethod($instance, 119, srfi1.Lit79, 8194);
        any = new ModuleMethod($instance, 120, srfi1.Lit80, -4094);
        every = new ModuleMethod($instance, 121, srfi1.Lit81, -4094);
        $Pcevery = Macro.make(srfi1.Lit82, srfi1.Lit83, "gnu.kawa.slib.srfi1");
        list$Mnindex = new ModuleMethod($instance, 122, srfi1.Lit84, -4094);
        lset$Ls$Eq = new ModuleMethod($instance, 123, srfi1.Lit85, -4095);
        lset$Eq = new ModuleMethod($instance, 124, srfi1.Lit86, -4095);
        lset$Mnadjoin = new ModuleMethod($instance, 125, srfi1.Lit87, -4094);
        lset$Mnunion = new ModuleMethod($instance, 126, srfi1.Lit88, -4095);
        lset$Mnunion$Ex = new ModuleMethod($instance, 127, srfi1.Lit89, -4095);
        lset$Mnintersection = new ModuleMethod($instance, 128, srfi1.Lit90, -4094);
        lset$Mnintersection$Ex = new ModuleMethod($instance, 129, srfi1.Lit91, -4094);
        lset$Mndifference = new ModuleMethod($instance, 130, srfi1.Lit92, -4094);
        lset$Mndifference$Ex = new ModuleMethod($instance, 131, srfi1.Lit93, -4094);
        lset$Mnxor = new ModuleMethod($instance, 132, srfi1.Lit94, -4095);
        lset$Mnxor$Ex = new ModuleMethod($instance, 133, srfi1.Lit95, -4095);
        lset$Mndiff$Plintersection = new ModuleMethod($instance, 134, srfi1.Lit96, -4094);
        lset$Mndiff$Plintersection$Ex = new ModuleMethod($instance, 135, srfi1.Lit97, -4094);
        $runBody$();
    }
    
    public srfi1() {
        ModuleInfo.register(this);
    }
    
    @Override
    public int match1(final ModuleMethod proc, final Object arg1, final CallContext ctx) {
        switch (proc.selector) {
            case 106: {
                ctx.value1 = arg1;
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 103: {
                ctx.value1 = arg1;
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 101: {
                ctx.value1 = arg1;
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 75: {
                ctx.value1 = arg1;
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 74: {
                ctx.value1 = arg1;
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 70: {
                ctx.value1 = arg1;
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 69: {
                ctx.value1 = arg1;
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 68: {
                ctx.value1 = arg1;
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 67: {
                ctx.value1 = arg1;
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 66: {
                ctx.value1 = arg1;
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 65: {
                final Object force = Promise.force(arg1, Pair.class);
                if (!(force instanceof Pair)) {
                    return -786431;
                }
                ctx.value1 = force;
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 64: {
                ctx.value1 = arg1;
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 55: {
                ctx.value1 = arg1;
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 54: {
                ctx.value1 = arg1;
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 53: {
                ctx.value1 = arg1;
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 52: {
                ctx.value1 = arg1;
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 51: {
                ctx.value1 = arg1;
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 50: {
                ctx.value1 = arg1;
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 49: {
                ctx.value1 = arg1;
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 47: {
                ctx.value1 = arg1;
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 45: {
                ctx.value1 = arg1;
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 44: {
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
            case 42: {
                ctx.value1 = arg1;
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 41: {
                ctx.value1 = arg1;
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 37: {
                final Object force2 = Promise.force(arg1, IntNum.class);
                if (IntNum.asIntNumOrNull(force2) != null) {
                    ctx.value1 = force2;
                    ctx.proc = proc;
                    ctx.pc = 1;
                    return 0;
                }
                return -786431;
            }
            default: {
                return super.match1(proc, arg1, ctx);
            }
        }
    }
    
    @Override
    public int match2(final ModuleMethod proc, final Object arg1, final Object arg2, final CallContext ctx) {
        switch (proc.selector) {
            case 119: {
                ctx.value1 = arg1;
                ctx.value2 = arg2;
                ctx.proc = proc;
                ctx.pc = 2;
                return 0;
            }
            case 118: {
                ctx.value1 = arg1;
                ctx.value2 = arg2;
                ctx.proc = proc;
                ctx.pc = 2;
                return 0;
            }
            case 117: {
                final Object force = Promise.force(arg1, Procedure.class);
                if (LangObjType.coerceToProcedureOrNull(force) != null) {
                    ctx.value1 = force;
                    ctx.value2 = arg2;
                    ctx.proc = proc;
                    ctx.pc = 2;
                    return 0;
                }
                return -786431;
            }
            case 116: {
                final Object force2 = Promise.force(arg1, Procedure.class);
                if (LangObjType.coerceToProcedureOrNull(force2) != null) {
                    ctx.value1 = force2;
                    ctx.value2 = arg2;
                    ctx.proc = proc;
                    ctx.pc = 2;
                    return 0;
                }
                return -786431;
            }
            case 115: {
                final Object force3 = Promise.force(arg1, Procedure.class);
                if (LangObjType.coerceToProcedureOrNull(force3) != null) {
                    ctx.value1 = force3;
                    ctx.value2 = arg2;
                    ctx.proc = proc;
                    ctx.pc = 2;
                    return 0;
                }
                return -786431;
            }
            case 114: {
                final Object force4 = Promise.force(arg1, Procedure.class);
                if (LangObjType.coerceToProcedureOrNull(force4) != null) {
                    ctx.value1 = force4;
                    ctx.value2 = arg2;
                    ctx.proc = proc;
                    ctx.pc = 2;
                    return 0;
                }
                return -786431;
            }
            case 113: {
                final Object force5 = Promise.force(arg1, Procedure.class);
                if (LangObjType.coerceToProcedureOrNull(force5) != null) {
                    ctx.value1 = force5;
                    ctx.value2 = arg2;
                    ctx.proc = proc;
                    ctx.pc = 2;
                    return 0;
                }
                return -786431;
            }
            case 112: {
                final Object force6 = Promise.force(arg1, Procedure.class);
                if (LangObjType.coerceToProcedureOrNull(force6) != null) {
                    ctx.value1 = force6;
                    ctx.value2 = arg2;
                    ctx.proc = proc;
                    ctx.pc = 2;
                    return 0;
                }
                return -786431;
            }
            case 111: {
                ctx.value1 = arg1;
                ctx.value2 = arg2;
                ctx.proc = proc;
                ctx.pc = 2;
                return 0;
            }
            case 109: {
                ctx.value1 = arg1;
                ctx.value2 = arg2;
                ctx.proc = proc;
                ctx.pc = 2;
                return 0;
            }
            case 107: {
                ctx.value1 = arg1;
                ctx.value2 = arg2;
                ctx.proc = proc;
                ctx.pc = 2;
                return 0;
            }
            case 103: {
                ctx.value1 = arg1;
                final Object force7 = Promise.force(arg2, Procedure.class);
                if (LangObjType.coerceToProcedureOrNull(force7) != null) {
                    ctx.value2 = force7;
                    ctx.proc = proc;
                    ctx.pc = 2;
                    return 0;
                }
                return -786430;
            }
            case 101: {
                ctx.value1 = arg1;
                final Object force8 = Promise.force(arg2, Procedure.class);
                if (LangObjType.coerceToProcedureOrNull(force8) != null) {
                    ctx.value2 = force8;
                    ctx.proc = proc;
                    ctx.pc = 2;
                    return 0;
                }
                return -786430;
            }
            case 99: {
                ctx.value1 = arg1;
                ctx.value2 = arg2;
                ctx.proc = proc;
                ctx.pc = 2;
                return 0;
            }
            case 97: {
                ctx.value1 = arg1;
                ctx.value2 = arg2;
                ctx.proc = proc;
                ctx.pc = 2;
                return 0;
            }
            case 96: {
                ctx.value1 = arg1;
                ctx.value2 = arg2;
                ctx.proc = proc;
                ctx.pc = 2;
                return 0;
            }
            case 95: {
                ctx.value1 = arg1;
                ctx.value2 = arg2;
                ctx.proc = proc;
                ctx.pc = 2;
                return 0;
            }
            case 94: {
                final Object force9 = Promise.force(arg1, Procedure.class);
                if (LangObjType.coerceToProcedureOrNull(force9) != null) {
                    ctx.value1 = force9;
                    ctx.value2 = arg2;
                    ctx.proc = proc;
                    ctx.pc = 2;
                    return 0;
                }
                return -786431;
            }
            case 93: {
                final Object force10 = Promise.force(arg1, Procedure.class);
                if (LangObjType.coerceToProcedureOrNull(force10) != null) {
                    ctx.value1 = force10;
                    ctx.value2 = arg2;
                    ctx.proc = proc;
                    ctx.pc = 2;
                    return 0;
                }
                return -786431;
            }
            case 92: {
                final Object force11 = Promise.force(arg1, Procedure.class);
                if (LangObjType.coerceToProcedureOrNull(force11) != null) {
                    ctx.value1 = force11;
                    ctx.value2 = arg2;
                    ctx.proc = proc;
                    ctx.pc = 2;
                    return 0;
                }
                return -786431;
            }
            case 91: {
                final Object force12 = Promise.force(arg1, Procedure.class);
                if (LangObjType.coerceToProcedureOrNull(force12) != null) {
                    ctx.value1 = force12;
                    ctx.value2 = arg2;
                    ctx.proc = proc;
                    ctx.pc = 2;
                    return 0;
                }
                return -786431;
            }
            case 73: {
                ctx.value1 = arg1;
                ctx.value2 = arg2;
                ctx.proc = proc;
                ctx.pc = 2;
                return 0;
            }
            case 72: {
                ctx.value1 = arg1;
                ctx.value2 = arg2;
                ctx.proc = proc;
                ctx.pc = 2;
                return 0;
            }
            case 63: {
                ctx.value1 = arg1;
                final Object force13 = Promise.force(arg2, IntNum.class);
                if (IntNum.asIntNumOrNull(force13) != null) {
                    ctx.value2 = force13;
                    ctx.proc = proc;
                    ctx.pc = 2;
                    return 0;
                }
                return -786430;
            }
            case 62: {
                ctx.value1 = arg1;
                final Object force14 = Promise.force(arg2, IntNum.class);
                if (IntNum.asIntNumOrNull(force14) != null) {
                    ctx.value2 = force14;
                    ctx.proc = proc;
                    ctx.pc = 2;
                    return 0;
                }
                return -786430;
            }
            case 61: {
                ctx.value1 = arg1;
                final Object force15 = Promise.force(arg2, IntNum.class);
                if (IntNum.asIntNumOrNull(force15) != null) {
                    ctx.value2 = force15;
                    ctx.proc = proc;
                    ctx.pc = 2;
                    return 0;
                }
                return -786430;
            }
            case 60: {
                ctx.value1 = arg1;
                final Object force16 = Promise.force(arg2, IntNum.class);
                if (IntNum.asIntNumOrNull(force16) != null) {
                    ctx.value2 = force16;
                    ctx.proc = proc;
                    ctx.pc = 2;
                    return 0;
                }
                return -786430;
            }
            case 59: {
                ctx.value1 = arg1;
                final Object force17 = Promise.force(arg2, IntNum.class);
                if (IntNum.asIntNumOrNull(force17) != null) {
                    ctx.value2 = force17;
                    ctx.proc = proc;
                    ctx.pc = 2;
                    return 0;
                }
                return -786430;
            }
            case 58: {
                ctx.value1 = arg1;
                final Object force18 = Promise.force(arg2, IntNum.class);
                if (IntNum.asIntNumOrNull(force18) != null) {
                    ctx.value2 = force18;
                    ctx.proc = proc;
                    ctx.pc = 2;
                    return 0;
                }
                return -786430;
            }
            case 57: {
                ctx.value1 = arg1;
                final Object force19 = Promise.force(arg2, IntNum.class);
                if (IntNum.asIntNumOrNull(force19) != null) {
                    ctx.value2 = force19;
                    ctx.proc = proc;
                    ctx.pc = 2;
                    return 0;
                }
                return -786430;
            }
            case 56: {
                ctx.value1 = arg1;
                final Object force20 = Promise.force(arg2, IntNum.class);
                if (IntNum.asIntNumOrNull(force20) != null) {
                    ctx.value2 = force20;
                    ctx.proc = proc;
                    ctx.pc = 2;
                    return 0;
                }
                return -786430;
            }
            case 37: {
                final Object force21 = Promise.force(arg1, IntNum.class);
                if (IntNum.asIntNumOrNull(force21) == null) {
                    return -786431;
                }
                ctx.value1 = force21;
                final Object force22 = Promise.force(arg2, Numeric.class);
                if (Numeric.asNumericOrNull(force22) != null) {
                    ctx.value2 = force22;
                    ctx.proc = proc;
                    ctx.pc = 2;
                    return 0;
                }
                return -786430;
            }
            case 35: {
                ctx.value1 = arg1;
                final Object force23 = Promise.force(arg2, Procedure.class);
                if (LangObjType.coerceToProcedureOrNull(force23) != null) {
                    ctx.value2 = force23;
                    ctx.proc = proc;
                    ctx.pc = 2;
                    return 0;
                }
                return -786430;
            }
            case 34: {
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
            case 109: {
                ctx.value1 = arg1;
                ctx.value2 = arg2;
                ctx.value3 = arg3;
                ctx.proc = proc;
                ctx.pc = 3;
                return 0;
            }
            case 107: {
                ctx.value1 = arg1;
                ctx.value2 = arg2;
                ctx.value3 = arg3;
                ctx.proc = proc;
                ctx.pc = 3;
                return 0;
            }
            case 105: {
                ctx.value1 = arg1;
                ctx.value2 = arg2;
                ctx.value3 = arg3;
                ctx.proc = proc;
                ctx.pc = 3;
                return 0;
            }
            case 99: {
                ctx.value1 = arg1;
                ctx.value2 = arg2;
                ctx.value3 = arg3;
                ctx.proc = proc;
                ctx.pc = 3;
                return 0;
            }
            case 97: {
                ctx.value1 = arg1;
                ctx.value2 = arg2;
                ctx.value3 = arg3;
                ctx.proc = proc;
                ctx.pc = 3;
                return 0;
            }
            case 85: {
                final Object force = Promise.force(arg1, Procedure.class);
                if (LangObjType.coerceToProcedureOrNull(force) != null) {
                    ctx.value1 = force;
                    ctx.value2 = arg2;
                    ctx.value3 = arg3;
                    ctx.proc = proc;
                    ctx.pc = 3;
                    return 0;
                }
                return -786431;
            }
            case 84: {
                final Object force2 = Promise.force(arg1, Procedure.class);
                if (LangObjType.coerceToProcedureOrNull(force2) != null) {
                    ctx.value1 = force2;
                    ctx.value2 = arg2;
                    ctx.value3 = arg3;
                    ctx.proc = proc;
                    ctx.pc = 3;
                    return 0;
                }
                return -786431;
            }
            case 37: {
                final Object force3 = Promise.force(arg1, IntNum.class);
                if (IntNum.asIntNumOrNull(force3) == null) {
                    return -786431;
                }
                ctx.value1 = force3;
                final Object force4 = Promise.force(arg2, Numeric.class);
                if (Numeric.asNumericOrNull(force4) == null) {
                    return -786430;
                }
                ctx.value2 = force4;
                final Object force5 = Promise.force(arg3, Numeric.class);
                if (Numeric.asNumericOrNull(force5) != null) {
                    ctx.value3 = force5;
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
    public int match4(final ModuleMethod moduleMethod, final Object o, final Object o2, final Object o3, final Object o4, final CallContext ctx) {
        if (moduleMethod.selector != 77) {
            return super.match4(moduleMethod, o, o2, o3, o4, ctx);
        }
        final Object force = Promise.force(o, Procedure.class);
        if (LangObjType.coerceToProcedureOrNull(force) == null) {
            return -786431;
        }
        ctx.value1 = force;
        final Object force2 = Promise.force(o2, Procedure.class);
        if (LangObjType.coerceToProcedureOrNull(force2) == null) {
            return -786430;
        }
        ctx.value2 = force2;
        final Object force3 = Promise.force(o3, Procedure.class);
        if (LangObjType.coerceToProcedureOrNull(force3) != null) {
            ctx.value3 = force3;
            ctx.value4 = o4;
            ctx.proc = moduleMethod;
            ctx.pc = 4;
            return 0;
        }
        return -786429;
    }
    
    @Override
    public int matchN(final ModuleMethod moduleMethod, final Object[] array, final CallContext ctx) {
        switch (moduleMethod.selector) {
            case 135: {
                ctx.values = array;
                ctx.proc = moduleMethod;
                ctx.pc = 5;
                return 0;
            }
            case 134: {
                ctx.values = array;
                ctx.proc = moduleMethod;
                ctx.pc = 5;
                return 0;
            }
            case 133: {
                ctx.values = array;
                ctx.proc = moduleMethod;
                ctx.pc = 5;
                return 0;
            }
            case 132: {
                ctx.values = array;
                ctx.proc = moduleMethod;
                ctx.pc = 5;
                return 0;
            }
            case 131: {
                ctx.values = array;
                ctx.proc = moduleMethod;
                ctx.pc = 5;
                return 0;
            }
            case 130: {
                ctx.values = array;
                ctx.proc = moduleMethod;
                ctx.pc = 5;
                return 0;
            }
            case 129: {
                ctx.values = array;
                ctx.proc = moduleMethod;
                ctx.pc = 5;
                return 0;
            }
            case 128: {
                ctx.values = array;
                ctx.proc = moduleMethod;
                ctx.pc = 5;
                return 0;
            }
            case 127: {
                ctx.values = array;
                ctx.proc = moduleMethod;
                ctx.pc = 5;
                return 0;
            }
            case 126: {
                ctx.values = array;
                ctx.proc = moduleMethod;
                ctx.pc = 5;
                return 0;
            }
            case 125: {
                ctx.values = array;
                ctx.proc = moduleMethod;
                ctx.pc = 5;
                return 0;
            }
            case 124: {
                ctx.values = array;
                ctx.proc = moduleMethod;
                ctx.pc = 5;
                return 0;
            }
            case 123: {
                ctx.values = array;
                ctx.proc = moduleMethod;
                ctx.pc = 5;
                return 0;
            }
            case 122: {
                ctx.values = array;
                ctx.proc = moduleMethod;
                ctx.pc = 5;
                return 0;
            }
            case 121: {
                ctx.values = array;
                ctx.proc = moduleMethod;
                ctx.pc = 5;
                return 0;
            }
            case 120: {
                ctx.values = array;
                ctx.proc = moduleMethod;
                ctx.pc = 5;
                return 0;
            }
            case 90: {
                ctx.values = array;
                ctx.proc = moduleMethod;
                ctx.pc = 5;
                return 0;
            }
            case 89: {
                ctx.values = array;
                ctx.proc = moduleMethod;
                ctx.pc = 5;
                return 0;
            }
            case 88: {
                ctx.values = array;
                ctx.proc = moduleMethod;
                ctx.pc = 5;
                return 0;
            }
            case 87: {
                ctx.values = array;
                ctx.proc = moduleMethod;
                ctx.pc = 5;
                return 0;
            }
            case 86: {
                ctx.values = array;
                ctx.proc = moduleMethod;
                ctx.pc = 5;
                return 0;
            }
            case 83: {
                ctx.values = array;
                ctx.proc = moduleMethod;
                ctx.pc = 5;
                return 0;
            }
            case 82: {
                ctx.values = array;
                ctx.proc = moduleMethod;
                ctx.pc = 5;
                return 0;
            }
            case 81: {
                ctx.values = array;
                ctx.proc = moduleMethod;
                ctx.pc = 5;
                return 0;
            }
            case 80: {
                ctx.values = array;
                ctx.proc = moduleMethod;
                ctx.pc = 5;
                return 0;
            }
            case 79: {
                ctx.values = array;
                ctx.proc = moduleMethod;
                ctx.pc = 5;
                return 0;
            }
            case 77: {
                ctx.values = array;
                ctx.proc = moduleMethod;
                ctx.pc = 5;
                return 0;
            }
            case 76: {
                ctx.values = array;
                ctx.proc = moduleMethod;
                ctx.pc = 5;
                return 0;
            }
            case 71: {
                ctx.values = array;
                ctx.proc = moduleMethod;
                ctx.pc = 5;
                return 0;
            }
            case 48: {
                ctx.values = array;
                ctx.proc = moduleMethod;
                ctx.pc = 5;
                return 0;
            }
            case 46: {
                ctx.values = array;
                ctx.proc = moduleMethod;
                ctx.pc = 5;
                return 0;
            }
            case 40: {
                ctx.values = array;
                ctx.proc = moduleMethod;
                ctx.pc = 5;
                return 0;
            }
            case 36: {
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
        //               37: 224
        //               41: 237
        //               42: 242
        //               43: 247
        //               44: 252
        //               45: 269
        //               47: 286
        //               49: 291
        //               50: 296
        //               51: 301
        //               52: 306
        //               53: 311
        //               54: 316
        //               55: 321
        //               64: 326
        //               65: 331
        //               66: 344
        //               67: 349
        //               68: 354
        //               69: 359
        //               70: 364
        //               74: 369
        //               75: 374
        //              101: 379
        //              103: 384
        //              106: 389
        //          default: 394
        //        }
        //   224: aload_2        
        //   225: ldc             Lgnu/math/IntNum;.class
        //   227: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   230: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceIntNum:(Ljava/lang/Object;)Lgnu/math/IntNum;
        //   233: invokestatic    gnu/kawa/slib/srfi1.iota:(Lgnu/math/IntNum;)Ljava/lang/Object;
        //   236: areturn        
        //   237: aload_2        
        //   238: invokestatic    gnu/kawa/slib/srfi1.isProperList:(Ljava/lang/Object;)Ljava/lang/Object;
        //   241: areturn        
        //   242: aload_2        
        //   243: invokestatic    gnu/kawa/slib/srfi1.isDottedList:(Ljava/lang/Object;)Ljava/lang/Object;
        //   246: areturn        
        //   247: aload_2        
        //   248: invokestatic    gnu/kawa/slib/srfi1.isCircularList:(Ljava/lang/Object;)Ljava/lang/Object;
        //   251: areturn        
        //   252: aload_2        
        //   253: invokestatic    gnu/kawa/slib/srfi1.isNotPair:(Ljava/lang/Object;)Z
        //   256: ifeq            265
        //   259: getstatic       java/lang/Boolean.TRUE:Ljava/lang/Boolean;
        //   262: goto            268
        //   265: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //   268: areturn        
        //   269: aload_2        
        //   270: invokestatic    gnu/kawa/slib/srfi1.isNullList:(Ljava/lang/Object;)Z
        //   273: ifeq            282
        //   276: getstatic       java/lang/Boolean.TRUE:Ljava/lang/Boolean;
        //   279: goto            285
        //   282: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //   285: areturn        
        //   286: aload_2        
        //   287: invokestatic    gnu/kawa/slib/srfi1.length$Pl:(Ljava/lang/Object;)Ljava/lang/Object;
        //   290: areturn        
        //   291: aload_2        
        //   292: invokestatic    gnu/kawa/slib/srfi1.fifth:(Ljava/lang/Object;)Ljava/lang/Object;
        //   295: areturn        
        //   296: aload_2        
        //   297: invokestatic    gnu/kawa/slib/srfi1.sixth:(Ljava/lang/Object;)Ljava/lang/Object;
        //   300: areturn        
        //   301: aload_2        
        //   302: invokestatic    gnu/kawa/slib/srfi1.seventh:(Ljava/lang/Object;)Ljava/lang/Object;
        //   305: areturn        
        //   306: aload_2        
        //   307: invokestatic    gnu/kawa/slib/srfi1.eighth:(Ljava/lang/Object;)Ljava/lang/Object;
        //   310: areturn        
        //   311: aload_2        
        //   312: invokestatic    gnu/kawa/slib/srfi1.ninth:(Ljava/lang/Object;)Ljava/lang/Object;
        //   315: areturn        
        //   316: aload_2        
        //   317: invokestatic    gnu/kawa/slib/srfi1.tenth:(Ljava/lang/Object;)Ljava/lang/Object;
        //   320: areturn        
        //   321: aload_2        
        //   322: invokestatic    gnu/kawa/slib/srfi1.car$PlCdr:(Ljava/lang/Object;)Lgnu/mapping/Values;
        //   325: areturn        
        //   326: aload_2        
        //   327: invokestatic    gnu/kawa/slib/srfi1.last:(Ljava/lang/Object;)Ljava/lang/Object;
        //   330: areturn        
        //   331: aload_2        
        //   332: ldc             Lgnu/lists/Pair;.class
        //   334: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   337: checkcast       Lgnu/lists/Pair;
        //   340: invokestatic    gnu/kawa/slib/srfi1.lastPair:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   343: areturn        
        //   344: aload_2        
        //   345: invokestatic    gnu/kawa/slib/srfi1.unzip1:(Ljava/lang/Object;)Lgnu/lists/LList;
        //   348: areturn        
        //   349: aload_2        
        //   350: invokestatic    gnu/kawa/slib/srfi1.unzip2:(Ljava/lang/Object;)Ljava/lang/Object;
        //   353: areturn        
        //   354: aload_2        
        //   355: invokestatic    gnu/kawa/slib/srfi1.unzip3:(Ljava/lang/Object;)Ljava/lang/Object;
        //   358: areturn        
        //   359: aload_2        
        //   360: invokestatic    gnu/kawa/slib/srfi1.unzip4:(Ljava/lang/Object;)Ljava/lang/Object;
        //   363: areturn        
        //   364: aload_2        
        //   365: invokestatic    gnu/kawa/slib/srfi1.unzip5:(Ljava/lang/Object;)Ljava/lang/Object;
        //   368: areturn        
        //   369: aload_2        
        //   370: invokestatic    gnu/kawa/slib/srfi1.concatenate:(Ljava/lang/Object;)Ljava/lang/Object;
        //   373: areturn        
        //   374: aload_2        
        //   375: invokestatic    gnu/kawa/slib/srfi1.concatenate$Ex:(Ljava/lang/Object;)Ljava/lang/Object;
        //   378: areturn        
        //   379: aload_2        
        //   380: invokestatic    gnu/kawa/slib/srfi1.deleteDuplicates:(Ljava/lang/Object;)Ljava/lang/Object;
        //   383: areturn        
        //   384: aload_2        
        //   385: invokestatic    gnu/kawa/slib/srfi1.deleteDuplicates$Ex:(Ljava/lang/Object;)Ljava/lang/Object;
        //   388: areturn        
        //   389: aload_2        
        //   390: invokestatic    gnu/kawa/slib/srfi1.alistCopy:(Ljava/lang/Object;)Lgnu/lists/LList;
        //   393: areturn        
        //   394: aload_0        
        //   395: aload_1        
        //   396: aload_2        
        //   397: invokespecial   gnu/expr/ModuleBody.apply1:(Lgnu/expr/ModuleMethod;Ljava/lang/Object;)Ljava/lang/Object;
        //   400: areturn        
        //   401: new             Lgnu/mapping/WrongType;
        //   404: dup_x1         
        //   405: swap           
        //   406: ldc_w           "iota"
        //   409: iconst_1       
        //   410: aload_2        
        //   411: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   414: athrow         
        //   415: new             Lgnu/mapping/WrongType;
        //   418: dup_x1         
        //   419: swap           
        //   420: ldc_w           "last-pair"
        //   423: iconst_1       
        //   424: aload_2        
        //   425: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   428: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  230    233    401    415    Ljava/lang/ClassCastException;
        //  337    340    415    429    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0344:
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
    public Object apply2(final ModuleMethod p0, final Object p1, final Object p2) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        gnu/expr/ModuleMethod.selector:I
        //     4: lookupswitch {
        //               34: 288
        //               35: 294
        //               37: 308
        //               56: 330
        //               57: 344
        //               58: 358
        //               59: 372
        //               60: 386
        //               61: 400
        //               62: 414
        //               63: 428
        //               72: 442
        //               73: 448
        //               91: 454
        //               92: 468
        //               93: 482
        //               94: 496
        //               95: 510
        //               96: 516
        //               97: 522
        //               99: 528
        //              101: 534
        //              103: 548
        //              107: 562
        //              109: 568
        //              111: 574
        //              112: 580
        //              113: 594
        //              114: 608
        //              115: 622
        //              116: 636
        //              117: 650
        //              118: 664
        //              119: 670
        //          default: 676
        //        }
        //   288: aload_2        
        //   289: aload_3        
        //   290: invokestatic    gnu/kawa/slib/srfi1.xcons:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //   293: areturn        
        //   294: aload_2        
        //   295: aload_3        
        //   296: ldc             Lgnu/mapping/Procedure;.class
        //   298: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   301: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceToProcedure:(Ljava/lang/Object;)Lgnu/mapping/Procedure;
        //   304: invokestatic    gnu/kawa/slib/srfi1.listTabulate:(Ljava/lang/Object;Lgnu/mapping/Procedure;)Ljava/lang/Object;
        //   307: areturn        
        //   308: aload_2        
        //   309: ldc             Lgnu/math/IntNum;.class
        //   311: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   314: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceIntNum:(Ljava/lang/Object;)Lgnu/math/IntNum;
        //   317: aload_3        
        //   318: ldc             Lgnu/math/Numeric;.class
        //   320: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   323: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceNumeric:(Ljava/lang/Object;)Lgnu/math/Numeric;
        //   326: invokestatic    gnu/kawa/slib/srfi1.iota:(Lgnu/math/IntNum;Lgnu/math/Numeric;)Ljava/lang/Object;
        //   329: areturn        
        //   330: aload_2        
        //   331: aload_3        
        //   332: ldc             Lgnu/math/IntNum;.class
        //   334: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   337: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceIntNum:(Ljava/lang/Object;)Lgnu/math/IntNum;
        //   340: invokestatic    gnu/kawa/slib/srfi1.take:(Ljava/lang/Object;Lgnu/math/IntNum;)Ljava/lang/Object;
        //   343: areturn        
        //   344: aload_2        
        //   345: aload_3        
        //   346: ldc             Lgnu/math/IntNum;.class
        //   348: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   351: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceIntNum:(Ljava/lang/Object;)Lgnu/math/IntNum;
        //   354: invokestatic    gnu/kawa/slib/srfi1.drop:(Ljava/lang/Object;Lgnu/math/IntNum;)Ljava/lang/Object;
        //   357: areturn        
        //   358: aload_2        
        //   359: aload_3        
        //   360: ldc             Lgnu/math/IntNum;.class
        //   362: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   365: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceIntNum:(Ljava/lang/Object;)Lgnu/math/IntNum;
        //   368: invokestatic    gnu/kawa/slib/srfi1.take$Ex:(Ljava/lang/Object;Lgnu/math/IntNum;)Ljava/lang/Object;
        //   371: areturn        
        //   372: aload_2        
        //   373: aload_3        
        //   374: ldc             Lgnu/math/IntNum;.class
        //   376: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   379: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceIntNum:(Ljava/lang/Object;)Lgnu/math/IntNum;
        //   382: invokestatic    gnu/kawa/slib/srfi1.takeRight:(Ljava/lang/Object;Lgnu/math/IntNum;)Ljava/lang/Object;
        //   385: areturn        
        //   386: aload_2        
        //   387: aload_3        
        //   388: ldc             Lgnu/math/IntNum;.class
        //   390: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   393: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceIntNum:(Ljava/lang/Object;)Lgnu/math/IntNum;
        //   396: invokestatic    gnu/kawa/slib/srfi1.dropRight:(Ljava/lang/Object;Lgnu/math/IntNum;)Ljava/lang/Object;
        //   399: areturn        
        //   400: aload_2        
        //   401: aload_3        
        //   402: ldc             Lgnu/math/IntNum;.class
        //   404: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   407: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceIntNum:(Ljava/lang/Object;)Lgnu/math/IntNum;
        //   410: invokestatic    gnu/kawa/slib/srfi1.dropRight$Ex:(Ljava/lang/Object;Lgnu/math/IntNum;)Ljava/lang/Object;
        //   413: areturn        
        //   414: aload_2        
        //   415: aload_3        
        //   416: ldc             Lgnu/math/IntNum;.class
        //   418: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   421: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceIntNum:(Ljava/lang/Object;)Lgnu/math/IntNum;
        //   424: invokestatic    gnu/kawa/slib/srfi1.splitAt:(Ljava/lang/Object;Lgnu/math/IntNum;)Ljava/lang/Object;
        //   427: areturn        
        //   428: aload_2        
        //   429: aload_3        
        //   430: ldc             Lgnu/math/IntNum;.class
        //   432: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   435: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceIntNum:(Ljava/lang/Object;)Lgnu/math/IntNum;
        //   438: invokestatic    gnu/kawa/slib/srfi1.splitAt$Ex:(Ljava/lang/Object;Lgnu/math/IntNum;)Ljava/lang/Object;
        //   441: areturn        
        //   442: aload_2        
        //   443: aload_3        
        //   444: invokestatic    gnu/kawa/slib/srfi1.appendReverse:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   447: areturn        
        //   448: aload_2        
        //   449: aload_3        
        //   450: invokestatic    gnu/kawa/slib/srfi1.appendReverse$Ex:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   453: areturn        
        //   454: aload_2        
        //   455: ldc             Lgnu/mapping/Procedure;.class
        //   457: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   460: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceToProcedure:(Ljava/lang/Object;)Lgnu/mapping/Procedure;
        //   463: aload_3        
        //   464: invokestatic    gnu/kawa/slib/srfi1.filter:(Lgnu/mapping/Procedure;Ljava/lang/Object;)Ljava/lang/Object;
        //   467: areturn        
        //   468: aload_2        
        //   469: ldc             Lgnu/mapping/Procedure;.class
        //   471: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   474: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceToProcedure:(Ljava/lang/Object;)Lgnu/mapping/Procedure;
        //   477: aload_3        
        //   478: invokestatic    gnu/kawa/slib/srfi1.filter$Ex:(Lgnu/mapping/Procedure;Ljava/lang/Object;)Ljava/lang/Object;
        //   481: areturn        
        //   482: aload_2        
        //   483: ldc             Lgnu/mapping/Procedure;.class
        //   485: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   488: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceToProcedure:(Ljava/lang/Object;)Lgnu/mapping/Procedure;
        //   491: aload_3        
        //   492: invokestatic    gnu/kawa/slib/srfi1.partition:(Lgnu/mapping/Procedure;Ljava/lang/Object;)Ljava/lang/Object;
        //   495: areturn        
        //   496: aload_2        
        //   497: ldc             Lgnu/mapping/Procedure;.class
        //   499: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   502: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceToProcedure:(Ljava/lang/Object;)Lgnu/mapping/Procedure;
        //   505: aload_3        
        //   506: invokestatic    gnu/kawa/slib/srfi1.partition$Ex:(Lgnu/mapping/Procedure;Ljava/lang/Object;)Ljava/lang/Object;
        //   509: areturn        
        //   510: aload_2        
        //   511: aload_3        
        //   512: invokestatic    gnu/kawa/slib/srfi1.remove:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   515: areturn        
        //   516: aload_2        
        //   517: aload_3        
        //   518: invokestatic    gnu/kawa/slib/srfi1.remove$Ex:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   521: areturn        
        //   522: aload_2        
        //   523: aload_3        
        //   524: invokestatic    gnu/kawa/slib/srfi1.delete:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   527: areturn        
        //   528: aload_2        
        //   529: aload_3        
        //   530: invokestatic    gnu/kawa/slib/srfi1.delete$Ex:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   533: areturn        
        //   534: aload_2        
        //   535: aload_3        
        //   536: ldc             Lgnu/mapping/Procedure;.class
        //   538: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   541: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceToProcedure:(Ljava/lang/Object;)Lgnu/mapping/Procedure;
        //   544: invokestatic    gnu/kawa/slib/srfi1.deleteDuplicates:(Ljava/lang/Object;Lgnu/mapping/Procedure;)Ljava/lang/Object;
        //   547: areturn        
        //   548: aload_2        
        //   549: aload_3        
        //   550: ldc             Lgnu/mapping/Procedure;.class
        //   552: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   555: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceToProcedure:(Ljava/lang/Object;)Lgnu/mapping/Procedure;
        //   558: invokestatic    gnu/kawa/slib/srfi1.deleteDuplicates$Ex:(Ljava/lang/Object;Lgnu/mapping/Procedure;)Ljava/lang/Object;
        //   561: areturn        
        //   562: aload_2        
        //   563: aload_3        
        //   564: invokestatic    gnu/kawa/slib/srfi1.alistDelete:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   567: areturn        
        //   568: aload_2        
        //   569: aload_3        
        //   570: invokestatic    gnu/kawa/slib/srfi1.alistDelete$Ex:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   573: areturn        
        //   574: aload_2        
        //   575: aload_3        
        //   576: invokestatic    gnu/kawa/slib/srfi1.find:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   579: areturn        
        //   580: aload_2        
        //   581: ldc             Lgnu/mapping/Procedure;.class
        //   583: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   586: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceToProcedure:(Ljava/lang/Object;)Lgnu/mapping/Procedure;
        //   589: aload_3        
        //   590: invokestatic    gnu/kawa/slib/srfi1.findTail:(Lgnu/mapping/Procedure;Ljava/lang/Object;)Ljava/lang/Object;
        //   593: areturn        
        //   594: aload_2        
        //   595: ldc             Lgnu/mapping/Procedure;.class
        //   597: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   600: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceToProcedure:(Ljava/lang/Object;)Lgnu/mapping/Procedure;
        //   603: aload_3        
        //   604: invokestatic    gnu/kawa/slib/srfi1.takeWhile:(Lgnu/mapping/Procedure;Ljava/lang/Object;)Ljava/lang/Object;
        //   607: areturn        
        //   608: aload_2        
        //   609: ldc             Lgnu/mapping/Procedure;.class
        //   611: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   614: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceToProcedure:(Ljava/lang/Object;)Lgnu/mapping/Procedure;
        //   617: aload_3        
        //   618: invokestatic    gnu/kawa/slib/srfi1.dropWhile:(Lgnu/mapping/Procedure;Ljava/lang/Object;)Ljava/lang/Object;
        //   621: areturn        
        //   622: aload_2        
        //   623: ldc             Lgnu/mapping/Procedure;.class
        //   625: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   628: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceToProcedure:(Ljava/lang/Object;)Lgnu/mapping/Procedure;
        //   631: aload_3        
        //   632: invokestatic    gnu/kawa/slib/srfi1.takeWhile$Ex:(Lgnu/mapping/Procedure;Ljava/lang/Object;)Ljava/lang/Object;
        //   635: areturn        
        //   636: aload_2        
        //   637: ldc             Lgnu/mapping/Procedure;.class
        //   639: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   642: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceToProcedure:(Ljava/lang/Object;)Lgnu/mapping/Procedure;
        //   645: aload_3        
        //   646: invokestatic    gnu/kawa/slib/srfi1.span:(Lgnu/mapping/Procedure;Ljava/lang/Object;)Ljava/lang/Object;
        //   649: areturn        
        //   650: aload_2        
        //   651: ldc             Lgnu/mapping/Procedure;.class
        //   653: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   656: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceToProcedure:(Ljava/lang/Object;)Lgnu/mapping/Procedure;
        //   659: aload_3        
        //   660: invokestatic    gnu/kawa/slib/srfi1.span$Ex:(Lgnu/mapping/Procedure;Ljava/lang/Object;)Ljava/lang/Object;
        //   663: areturn        
        //   664: aload_2        
        //   665: aload_3        
        //   666: invokestatic    gnu/kawa/slib/srfi1.break:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   669: areturn        
        //   670: aload_2        
        //   671: aload_3        
        //   672: invokestatic    gnu/kawa/slib/srfi1.break$Ex:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   675: areturn        
        //   676: aload_0        
        //   677: aload_1        
        //   678: aload_2        
        //   679: aload_3        
        //   680: invokespecial   gnu/expr/ModuleBody.apply2:(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   683: areturn        
        //   684: new             Lgnu/mapping/WrongType;
        //   687: dup_x1         
        //   688: swap           
        //   689: ldc_w           "list-tabulate"
        //   692: iconst_2       
        //   693: aload_3        
        //   694: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   697: athrow         
        //   698: new             Lgnu/mapping/WrongType;
        //   701: dup_x1         
        //   702: swap           
        //   703: ldc_w           "iota"
        //   706: iconst_1       
        //   707: aload_2        
        //   708: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   711: athrow         
        //   712: new             Lgnu/mapping/WrongType;
        //   715: dup_x1         
        //   716: swap           
        //   717: ldc_w           "iota"
        //   720: iconst_2       
        //   721: aload_3        
        //   722: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   725: athrow         
        //   726: new             Lgnu/mapping/WrongType;
        //   729: dup_x1         
        //   730: swap           
        //   731: ldc_w           "take"
        //   734: iconst_2       
        //   735: aload_3        
        //   736: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   739: athrow         
        //   740: new             Lgnu/mapping/WrongType;
        //   743: dup_x1         
        //   744: swap           
        //   745: ldc_w           "drop"
        //   748: iconst_2       
        //   749: aload_3        
        //   750: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   753: athrow         
        //   754: new             Lgnu/mapping/WrongType;
        //   757: dup_x1         
        //   758: swap           
        //   759: ldc_w           "take!"
        //   762: iconst_2       
        //   763: aload_3        
        //   764: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   767: athrow         
        //   768: new             Lgnu/mapping/WrongType;
        //   771: dup_x1         
        //   772: swap           
        //   773: ldc_w           "take-right"
        //   776: iconst_2       
        //   777: aload_3        
        //   778: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   781: athrow         
        //   782: new             Lgnu/mapping/WrongType;
        //   785: dup_x1         
        //   786: swap           
        //   787: ldc_w           "drop-right"
        //   790: iconst_2       
        //   791: aload_3        
        //   792: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   795: athrow         
        //   796: new             Lgnu/mapping/WrongType;
        //   799: dup_x1         
        //   800: swap           
        //   801: ldc_w           "drop-right!"
        //   804: iconst_2       
        //   805: aload_3        
        //   806: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   809: athrow         
        //   810: new             Lgnu/mapping/WrongType;
        //   813: dup_x1         
        //   814: swap           
        //   815: ldc_w           "split-at"
        //   818: iconst_2       
        //   819: aload_3        
        //   820: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   823: athrow         
        //   824: new             Lgnu/mapping/WrongType;
        //   827: dup_x1         
        //   828: swap           
        //   829: ldc_w           "split-at!"
        //   832: iconst_2       
        //   833: aload_3        
        //   834: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   837: athrow         
        //   838: new             Lgnu/mapping/WrongType;
        //   841: dup_x1         
        //   842: swap           
        //   843: ldc_w           "filter"
        //   846: iconst_1       
        //   847: aload_2        
        //   848: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   851: athrow         
        //   852: new             Lgnu/mapping/WrongType;
        //   855: dup_x1         
        //   856: swap           
        //   857: ldc_w           "filter!"
        //   860: iconst_1       
        //   861: aload_2        
        //   862: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   865: athrow         
        //   866: new             Lgnu/mapping/WrongType;
        //   869: dup_x1         
        //   870: swap           
        //   871: ldc_w           "partition"
        //   874: iconst_1       
        //   875: aload_2        
        //   876: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   879: athrow         
        //   880: new             Lgnu/mapping/WrongType;
        //   883: dup_x1         
        //   884: swap           
        //   885: ldc_w           "partition!"
        //   888: iconst_1       
        //   889: aload_2        
        //   890: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   893: athrow         
        //   894: new             Lgnu/mapping/WrongType;
        //   897: dup_x1         
        //   898: swap           
        //   899: ldc_w           "delete-duplicates"
        //   902: iconst_2       
        //   903: aload_3        
        //   904: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   907: athrow         
        //   908: new             Lgnu/mapping/WrongType;
        //   911: dup_x1         
        //   912: swap           
        //   913: ldc_w           "delete-duplicates!"
        //   916: iconst_2       
        //   917: aload_3        
        //   918: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   921: athrow         
        //   922: new             Lgnu/mapping/WrongType;
        //   925: dup_x1         
        //   926: swap           
        //   927: ldc_w           "find-tail"
        //   930: iconst_1       
        //   931: aload_2        
        //   932: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   935: athrow         
        //   936: new             Lgnu/mapping/WrongType;
        //   939: dup_x1         
        //   940: swap           
        //   941: ldc_w           "take-while"
        //   944: iconst_1       
        //   945: aload_2        
        //   946: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   949: athrow         
        //   950: new             Lgnu/mapping/WrongType;
        //   953: dup_x1         
        //   954: swap           
        //   955: ldc_w           "drop-while"
        //   958: iconst_1       
        //   959: aload_2        
        //   960: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   963: athrow         
        //   964: new             Lgnu/mapping/WrongType;
        //   967: dup_x1         
        //   968: swap           
        //   969: ldc_w           "take-while!"
        //   972: iconst_1       
        //   973: aload_2        
        //   974: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   977: athrow         
        //   978: new             Lgnu/mapping/WrongType;
        //   981: dup_x1         
        //   982: swap           
        //   983: ldc_w           "span"
        //   986: iconst_1       
        //   987: aload_2        
        //   988: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   991: athrow         
        //   992: new             Lgnu/mapping/WrongType;
        //   995: dup_x1         
        //   996: swap           
        //   997: ldc_w           "span!"
        //  1000: iconst_1       
        //  1001: aload_2        
        //  1002: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1005: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  301    304    684    698    Ljava/lang/ClassCastException;
        //  314    317    698    712    Ljava/lang/ClassCastException;
        //  323    326    712    726    Ljava/lang/ClassCastException;
        //  337    340    726    740    Ljava/lang/ClassCastException;
        //  351    354    740    754    Ljava/lang/ClassCastException;
        //  365    368    754    768    Ljava/lang/ClassCastException;
        //  379    382    768    782    Ljava/lang/ClassCastException;
        //  393    396    782    796    Ljava/lang/ClassCastException;
        //  407    410    796    810    Ljava/lang/ClassCastException;
        //  421    424    810    824    Ljava/lang/ClassCastException;
        //  435    438    824    838    Ljava/lang/ClassCastException;
        //  460    463    838    852    Ljava/lang/ClassCastException;
        //  474    477    852    866    Ljava/lang/ClassCastException;
        //  488    491    866    880    Ljava/lang/ClassCastException;
        //  502    505    880    894    Ljava/lang/ClassCastException;
        //  541    544    894    908    Ljava/lang/ClassCastException;
        //  555    558    908    922    Ljava/lang/ClassCastException;
        //  586    589    922    936    Ljava/lang/ClassCastException;
        //  600    603    936    950    Ljava/lang/ClassCastException;
        //  614    617    950    964    Ljava/lang/ClassCastException;
        //  628    631    964    978    Ljava/lang/ClassCastException;
        //  642    645    978    992    Ljava/lang/ClassCastException;
        //  656    659    992    1006   Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 398 out of bounds for length 398
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
        //               37: 80
        //               84: 112
        //               85: 128
        //               97: 144
        //               99: 152
        //              105: 160
        //              107: 168
        //              109: 176
        //          default: 184
        //        }
        //    80: aload_2        
        //    81: ldc             Lgnu/math/IntNum;.class
        //    83: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    86: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceIntNum:(Ljava/lang/Object;)Lgnu/math/IntNum;
        //    89: aload_3        
        //    90: ldc             Lgnu/math/Numeric;.class
        //    92: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    95: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceNumeric:(Ljava/lang/Object;)Lgnu/math/Numeric;
        //    98: aload           4
        //   100: ldc             Lgnu/math/Numeric;.class
        //   102: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   105: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceNumeric:(Ljava/lang/Object;)Lgnu/math/Numeric;
        //   108: invokestatic    gnu/kawa/slib/srfi1.iota:(Lgnu/math/IntNum;Lgnu/math/Numeric;Lgnu/math/Numeric;)Ljava/lang/Object;
        //   111: areturn        
        //   112: aload_2        
        //   113: ldc             Lgnu/mapping/Procedure;.class
        //   115: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   118: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceToProcedure:(Ljava/lang/Object;)Lgnu/mapping/Procedure;
        //   121: aload_3        
        //   122: aload           4
        //   124: invokestatic    gnu/kawa/slib/srfi1.reduce:(Lgnu/mapping/Procedure;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   127: areturn        
        //   128: aload_2        
        //   129: ldc             Lgnu/mapping/Procedure;.class
        //   131: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   134: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceToProcedure:(Ljava/lang/Object;)Lgnu/mapping/Procedure;
        //   137: aload_3        
        //   138: aload           4
        //   140: invokestatic    gnu/kawa/slib/srfi1.reduceRight:(Lgnu/mapping/Procedure;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   143: areturn        
        //   144: aload_2        
        //   145: aload_3        
        //   146: aload           4
        //   148: invokestatic    gnu/kawa/slib/srfi1.delete:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   151: areturn        
        //   152: aload_2        
        //   153: aload_3        
        //   154: aload           4
        //   156: invokestatic    gnu/kawa/slib/srfi1.delete$Ex:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   159: areturn        
        //   160: aload_2        
        //   161: aload_3        
        //   162: aload           4
        //   164: invokestatic    gnu/kawa/slib/srfi1.alistCons:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //   167: areturn        
        //   168: aload_2        
        //   169: aload_3        
        //   170: aload           4
        //   172: invokestatic    gnu/kawa/slib/srfi1.alistDelete:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   175: areturn        
        //   176: aload_2        
        //   177: aload_3        
        //   178: aload           4
        //   180: invokestatic    gnu/kawa/slib/srfi1.alistDelete$Ex:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   183: areturn        
        //   184: aload_0        
        //   185: aload_1        
        //   186: aload_2        
        //   187: aload_3        
        //   188: aload           4
        //   190: invokespecial   gnu/expr/ModuleBody.apply3:(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   193: areturn        
        //   194: new             Lgnu/mapping/WrongType;
        //   197: dup_x1         
        //   198: swap           
        //   199: ldc_w           "iota"
        //   202: iconst_1       
        //   203: aload_2        
        //   204: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   207: athrow         
        //   208: new             Lgnu/mapping/WrongType;
        //   211: dup_x1         
        //   212: swap           
        //   213: ldc_w           "iota"
        //   216: iconst_2       
        //   217: aload_3        
        //   218: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   221: athrow         
        //   222: new             Lgnu/mapping/WrongType;
        //   225: dup_x1         
        //   226: swap           
        //   227: ldc_w           "iota"
        //   230: iconst_3       
        //   231: aload           4
        //   233: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   236: athrow         
        //   237: new             Lgnu/mapping/WrongType;
        //   240: dup_x1         
        //   241: swap           
        //   242: ldc_w           "reduce"
        //   245: iconst_1       
        //   246: aload_2        
        //   247: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   250: athrow         
        //   251: new             Lgnu/mapping/WrongType;
        //   254: dup_x1         
        //   255: swap           
        //   256: ldc_w           "reduce-right"
        //   259: iconst_1       
        //   260: aload_2        
        //   261: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   264: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  86     89     194    208    Ljava/lang/ClassCastException;
        //  95     98     208    222    Ljava/lang/ClassCastException;
        //  105    108    222    237    Ljava/lang/ClassCastException;
        //  118    121    237    251    Ljava/lang/ClassCastException;
        //  134    137    251    265    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 105 out of bounds for length 105
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
        //     4: bipush          77
        //     6: if_icmpne       46
        //     9: goto            12
        //    12: aload_2        
        //    13: ldc             Lgnu/mapping/Procedure;.class
        //    15: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    18: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceToProcedure:(Ljava/lang/Object;)Lgnu/mapping/Procedure;
        //    21: aload_3        
        //    22: ldc             Lgnu/mapping/Procedure;.class
        //    24: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    27: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceToProcedure:(Ljava/lang/Object;)Lgnu/mapping/Procedure;
        //    30: aload           4
        //    32: ldc             Lgnu/mapping/Procedure;.class
        //    34: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    37: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceToProcedure:(Ljava/lang/Object;)Lgnu/mapping/Procedure;
        //    40: aload           5
        //    42: invokestatic    gnu/kawa/slib/srfi1.unfoldRight:(Lgnu/mapping/Procedure;Lgnu/mapping/Procedure;Lgnu/mapping/Procedure;Ljava/lang/Object;)Ljava/lang/Object;
        //    45: areturn        
        //    46: aload_0        
        //    47: aload_1        
        //    48: aload_2        
        //    49: aload_3        
        //    50: aload           4
        //    52: aload           5
        //    54: invokespecial   gnu/expr/ModuleBody.apply4:(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    57: areturn        
        //    58: new             Lgnu/mapping/WrongType;
        //    61: dup_x1         
        //    62: swap           
        //    63: ldc_w           "unfold-right"
        //    66: iconst_1       
        //    67: aload_2        
        //    68: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //    71: athrow         
        //    72: new             Lgnu/mapping/WrongType;
        //    75: dup_x1         
        //    76: swap           
        //    77: ldc_w           "unfold-right"
        //    80: iconst_2       
        //    81: aload_3        
        //    82: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //    85: athrow         
        //    86: new             Lgnu/mapping/WrongType;
        //    89: dup_x1         
        //    90: swap           
        //    91: ldc_w           "unfold-right"
        //    94: iconst_3       
        //    95: aload           4
        //    97: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   100: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  18     21     58     72     Ljava/lang/ClassCastException;
        //  27     30     72     86     Ljava/lang/ClassCastException;
        //  37     40     86     101    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 52 out of bounds for length 52
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
        //               36: 280
        //               40: 285
        //               46: 319
        //               48: 353
        //               71: 387
        //               76: 392
        //               77: 439
        //               79: 509
        //               80: 590
        //               81: 646
        //               82: 702
        //               83: 758
        //               86: 814
        //               87: 856
        //               88: 898
        //               89: 951
        //               90: 1004
        //              120: 1057
        //              121: 1110
        //              122: 1163
        //              123: 1216
        //              124: 1266
        //              125: 1316
        //              126: 1369
        //              127: 1419
        //              128: 1469
        //              129: 1522
        //              130: 1575
        //              131: 1628
        //              132: 1681
        //              133: 1731
        //              134: 1781
        //              135: 1834
        //          default: 1887
        //        }
        //   280: aload_2        
        //   281: invokestatic    gnu/kawa/slib/srfi1.cons$St:([Ljava/lang/Object;)Ljava/lang/Object;
        //   284: areturn        
        //   285: aload_2        
        //   286: iconst_0       
        //   287: aaload         
        //   288: aload_2        
        //   289: arraylength    
        //   290: iconst_1       
        //   291: isub           
        //   292: istore_3       
        //   293: iload_3        
        //   294: anewarray       Ljava/lang/Object;
        //   297: goto            308
        //   300: dup            
        //   301: iload_3        
        //   302: aload_2        
        //   303: iload_3        
        //   304: iconst_1       
        //   305: iadd           
        //   306: aaload         
        //   307: aastore        
        //   308: iinc            3, -1
        //   311: iload_3        
        //   312: ifge            300
        //   315: invokestatic    gnu/kawa/slib/srfi1.circularList$V:(Ljava/lang/Object;[Ljava/lang/Object;)Lgnu/lists/Pair;
        //   318: areturn        
        //   319: aload_2        
        //   320: iconst_0       
        //   321: aaload         
        //   322: aload_2        
        //   323: arraylength    
        //   324: iconst_1       
        //   325: isub           
        //   326: istore_3       
        //   327: iload_3        
        //   328: anewarray       Ljava/lang/Object;
        //   331: goto            342
        //   334: dup            
        //   335: iload_3        
        //   336: aload_2        
        //   337: iload_3        
        //   338: iconst_1       
        //   339: iadd           
        //   340: aaload         
        //   341: aastore        
        //   342: iinc            3, -1
        //   345: iload_3        
        //   346: ifge            334
        //   349: invokestatic    gnu/kawa/slib/srfi1.list$Eq$V:(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
        //   352: areturn        
        //   353: aload_2        
        //   354: iconst_0       
        //   355: aaload         
        //   356: aload_2        
        //   357: arraylength    
        //   358: iconst_1       
        //   359: isub           
        //   360: istore_3       
        //   361: iload_3        
        //   362: anewarray       Ljava/lang/Object;
        //   365: goto            376
        //   368: dup            
        //   369: iload_3        
        //   370: aload_2        
        //   371: iload_3        
        //   372: iconst_1       
        //   373: iadd           
        //   374: aaload         
        //   375: aastore        
        //   376: iinc            3, -1
        //   379: iload_3        
        //   380: ifge            368
        //   383: invokestatic    gnu/kawa/slib/srfi1.zip$V:(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
        //   386: areturn        
        //   387: aload_2        
        //   388: invokestatic    gnu/kawa/slib/srfi1.append$Ex$V:([Ljava/lang/Object;)Ljava/lang/Object;
        //   391: areturn        
        //   392: aload_2        
        //   393: iconst_0       
        //   394: aaload         
        //   395: ldc             Lgnu/mapping/Procedure;.class
        //   397: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   400: dup            
        //   401: astore_3       
        //   402: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceToProcedure:(Ljava/lang/Object;)Lgnu/mapping/Procedure;
        //   405: aload_2        
        //   406: iconst_1       
        //   407: aaload         
        //   408: aload_2        
        //   409: arraylength    
        //   410: iconst_2       
        //   411: isub           
        //   412: istore_3       
        //   413: iload_3        
        //   414: anewarray       Ljava/lang/Object;
        //   417: goto            428
        //   420: dup            
        //   421: iload_3        
        //   422: aload_2        
        //   423: iload_3        
        //   424: iconst_2       
        //   425: iadd           
        //   426: aaload         
        //   427: aastore        
        //   428: iinc            3, -1
        //   431: iload_3        
        //   432: ifge            420
        //   435: invokestatic    gnu/kawa/slib/srfi1.count$V:(Lgnu/mapping/Procedure;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
        //   438: areturn        
        //   439: aload_2        
        //   440: arraylength    
        //   441: iconst_4       
        //   442: isub           
        //   443: istore_3       
        //   444: aload_2        
        //   445: iconst_0       
        //   446: aaload         
        //   447: ldc             Lgnu/mapping/Procedure;.class
        //   449: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   452: dup            
        //   453: astore          4
        //   455: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceToProcedure:(Ljava/lang/Object;)Lgnu/mapping/Procedure;
        //   458: aload_2        
        //   459: iconst_1       
        //   460: aaload         
        //   461: ldc             Lgnu/mapping/Procedure;.class
        //   463: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   466: dup            
        //   467: astore          4
        //   469: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceToProcedure:(Ljava/lang/Object;)Lgnu/mapping/Procedure;
        //   472: aload_2        
        //   473: iconst_2       
        //   474: aaload         
        //   475: ldc             Lgnu/mapping/Procedure;.class
        //   477: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   480: dup            
        //   481: astore          4
        //   483: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceToProcedure:(Ljava/lang/Object;)Lgnu/mapping/Procedure;
        //   486: aload_2        
        //   487: iconst_3       
        //   488: aaload         
        //   489: iload_3        
        //   490: ifgt            499
        //   493: invokestatic    gnu/kawa/slib/srfi1.unfoldRight:(Lgnu/mapping/Procedure;Lgnu/mapping/Procedure;Lgnu/mapping/Procedure;Ljava/lang/Object;)Ljava/lang/Object;
        //   496: goto            508
        //   499: iinc            3, -1
        //   502: aload_2        
        //   503: iconst_4       
        //   504: aaload         
        //   505: invokestatic    gnu/kawa/slib/srfi1.unfoldRight:(Lgnu/mapping/Procedure;Lgnu/mapping/Procedure;Lgnu/mapping/Procedure;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   508: areturn        
        //   509: aload_2        
        //   510: iconst_0       
        //   511: aaload         
        //   512: ldc             Lgnu/mapping/Procedure;.class
        //   514: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   517: dup            
        //   518: astore          4
        //   520: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceToProcedure:(Ljava/lang/Object;)Lgnu/mapping/Procedure;
        //   523: aload_2        
        //   524: iconst_1       
        //   525: aaload         
        //   526: ldc             Lgnu/mapping/Procedure;.class
        //   528: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   531: dup            
        //   532: astore          4
        //   534: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceToProcedure:(Ljava/lang/Object;)Lgnu/mapping/Procedure;
        //   537: aload_2        
        //   538: iconst_2       
        //   539: aaload         
        //   540: ldc             Lgnu/mapping/Procedure;.class
        //   542: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   545: dup            
        //   546: astore          4
        //   548: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceToProcedure:(Ljava/lang/Object;)Lgnu/mapping/Procedure;
        //   551: aload_2        
        //   552: iconst_3       
        //   553: aaload         
        //   554: aload_2        
        //   555: arraylength    
        //   556: iconst_4       
        //   557: isub           
        //   558: istore          4
        //   560: iload           4
        //   562: anewarray       Ljava/lang/Object;
        //   565: goto            578
        //   568: dup            
        //   569: iload           4
        //   571: aload_2        
        //   572: iload           4
        //   574: iconst_4       
        //   575: iadd           
        //   576: aaload         
        //   577: aastore        
        //   578: iinc            4, -1
        //   581: iload           4
        //   583: ifge            568
        //   586: invokestatic    gnu/kawa/slib/srfi1.unfold$V:(Lgnu/mapping/Procedure;Lgnu/mapping/Procedure;Lgnu/mapping/Procedure;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
        //   589: areturn        
        //   590: aload_2        
        //   591: iconst_0       
        //   592: aaload         
        //   593: ldc             Lgnu/mapping/Procedure;.class
        //   595: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   598: dup            
        //   599: astore          4
        //   601: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceToProcedure:(Ljava/lang/Object;)Lgnu/mapping/Procedure;
        //   604: aload_2        
        //   605: iconst_1       
        //   606: aaload         
        //   607: aload_2        
        //   608: iconst_2       
        //   609: aaload         
        //   610: aload_2        
        //   611: arraylength    
        //   612: iconst_3       
        //   613: isub           
        //   614: istore          4
        //   616: iload           4
        //   618: anewarray       Ljava/lang/Object;
        //   621: goto            634
        //   624: dup            
        //   625: iload           4
        //   627: aload_2        
        //   628: iload           4
        //   630: iconst_3       
        //   631: iadd           
        //   632: aaload         
        //   633: aastore        
        //   634: iinc            4, -1
        //   637: iload           4
        //   639: ifge            624
        //   642: invokestatic    gnu/kawa/slib/srfi1.fold$V:(Lgnu/mapping/Procedure;Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
        //   645: areturn        
        //   646: aload_2        
        //   647: iconst_0       
        //   648: aaload         
        //   649: ldc             Lgnu/mapping/Procedure;.class
        //   651: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   654: dup            
        //   655: astore          4
        //   657: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceToProcedure:(Ljava/lang/Object;)Lgnu/mapping/Procedure;
        //   660: aload_2        
        //   661: iconst_1       
        //   662: aaload         
        //   663: aload_2        
        //   664: iconst_2       
        //   665: aaload         
        //   666: aload_2        
        //   667: arraylength    
        //   668: iconst_3       
        //   669: isub           
        //   670: istore          4
        //   672: iload           4
        //   674: anewarray       Ljava/lang/Object;
        //   677: goto            690
        //   680: dup            
        //   681: iload           4
        //   683: aload_2        
        //   684: iload           4
        //   686: iconst_3       
        //   687: iadd           
        //   688: aaload         
        //   689: aastore        
        //   690: iinc            4, -1
        //   693: iload           4
        //   695: ifge            680
        //   698: invokestatic    gnu/kawa/slib/srfi1.foldRight$V:(Lgnu/mapping/Procedure;Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
        //   701: areturn        
        //   702: aload_2        
        //   703: iconst_0       
        //   704: aaload         
        //   705: ldc             Lgnu/mapping/Procedure;.class
        //   707: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   710: dup            
        //   711: astore          4
        //   713: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceToProcedure:(Ljava/lang/Object;)Lgnu/mapping/Procedure;
        //   716: aload_2        
        //   717: iconst_1       
        //   718: aaload         
        //   719: aload_2        
        //   720: iconst_2       
        //   721: aaload         
        //   722: aload_2        
        //   723: arraylength    
        //   724: iconst_3       
        //   725: isub           
        //   726: istore          4
        //   728: iload           4
        //   730: anewarray       Ljava/lang/Object;
        //   733: goto            746
        //   736: dup            
        //   737: iload           4
        //   739: aload_2        
        //   740: iload           4
        //   742: iconst_3       
        //   743: iadd           
        //   744: aaload         
        //   745: aastore        
        //   746: iinc            4, -1
        //   749: iload           4
        //   751: ifge            736
        //   754: invokestatic    gnu/kawa/slib/srfi1.pairFoldRight$V:(Lgnu/mapping/Procedure;Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
        //   757: areturn        
        //   758: aload_2        
        //   759: iconst_0       
        //   760: aaload         
        //   761: ldc             Lgnu/mapping/Procedure;.class
        //   763: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   766: dup            
        //   767: astore          4
        //   769: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceToProcedure:(Ljava/lang/Object;)Lgnu/mapping/Procedure;
        //   772: aload_2        
        //   773: iconst_1       
        //   774: aaload         
        //   775: aload_2        
        //   776: iconst_2       
        //   777: aaload         
        //   778: aload_2        
        //   779: arraylength    
        //   780: iconst_3       
        //   781: isub           
        //   782: istore          4
        //   784: iload           4
        //   786: anewarray       Ljava/lang/Object;
        //   789: goto            802
        //   792: dup            
        //   793: iload           4
        //   795: aload_2        
        //   796: iload           4
        //   798: iconst_3       
        //   799: iadd           
        //   800: aaload         
        //   801: aastore        
        //   802: iinc            4, -1
        //   805: iload           4
        //   807: ifge            792
        //   810: invokestatic    gnu/kawa/slib/srfi1.pairFold$V:(Lgnu/mapping/Procedure;Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
        //   813: areturn        
        //   814: aload_2        
        //   815: iconst_0       
        //   816: aaload         
        //   817: aload_2        
        //   818: iconst_1       
        //   819: aaload         
        //   820: aload_2        
        //   821: arraylength    
        //   822: iconst_2       
        //   823: isub           
        //   824: istore          4
        //   826: iload           4
        //   828: anewarray       Ljava/lang/Object;
        //   831: goto            844
        //   834: dup            
        //   835: iload           4
        //   837: aload_2        
        //   838: iload           4
        //   840: iconst_2       
        //   841: iadd           
        //   842: aaload         
        //   843: aastore        
        //   844: iinc            4, -1
        //   847: iload           4
        //   849: ifge            834
        //   852: invokestatic    gnu/kawa/slib/srfi1.appendMap$V:(Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
        //   855: areturn        
        //   856: aload_2        
        //   857: iconst_0       
        //   858: aaload         
        //   859: aload_2        
        //   860: iconst_1       
        //   861: aaload         
        //   862: aload_2        
        //   863: arraylength    
        //   864: iconst_2       
        //   865: isub           
        //   866: istore          4
        //   868: iload           4
        //   870: anewarray       Ljava/lang/Object;
        //   873: goto            886
        //   876: dup            
        //   877: iload           4
        //   879: aload_2        
        //   880: iload           4
        //   882: iconst_2       
        //   883: iadd           
        //   884: aaload         
        //   885: aastore        
        //   886: iinc            4, -1
        //   889: iload           4
        //   891: ifge            876
        //   894: invokestatic    gnu/kawa/slib/srfi1.appendMap$Ex$V:(Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
        //   897: areturn        
        //   898: aload_2        
        //   899: iconst_0       
        //   900: aaload         
        //   901: ldc             Lgnu/mapping/Procedure;.class
        //   903: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   906: dup            
        //   907: astore          4
        //   909: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceToProcedure:(Ljava/lang/Object;)Lgnu/mapping/Procedure;
        //   912: aload_2        
        //   913: iconst_1       
        //   914: aaload         
        //   915: aload_2        
        //   916: arraylength    
        //   917: iconst_2       
        //   918: isub           
        //   919: istore          4
        //   921: iload           4
        //   923: anewarray       Ljava/lang/Object;
        //   926: goto            939
        //   929: dup            
        //   930: iload           4
        //   932: aload_2        
        //   933: iload           4
        //   935: iconst_2       
        //   936: iadd           
        //   937: aaload         
        //   938: aastore        
        //   939: iinc            4, -1
        //   942: iload           4
        //   944: ifge            929
        //   947: invokestatic    gnu/kawa/slib/srfi1.pairForEach$V:(Lgnu/mapping/Procedure;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
        //   950: areturn        
        //   951: aload_2        
        //   952: iconst_0       
        //   953: aaload         
        //   954: ldc             Lgnu/mapping/Procedure;.class
        //   956: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   959: dup            
        //   960: astore          4
        //   962: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceToProcedure:(Ljava/lang/Object;)Lgnu/mapping/Procedure;
        //   965: aload_2        
        //   966: iconst_1       
        //   967: aaload         
        //   968: aload_2        
        //   969: arraylength    
        //   970: iconst_2       
        //   971: isub           
        //   972: istore          4
        //   974: iload           4
        //   976: anewarray       Ljava/lang/Object;
        //   979: goto            992
        //   982: dup            
        //   983: iload           4
        //   985: aload_2        
        //   986: iload           4
        //   988: iconst_2       
        //   989: iadd           
        //   990: aaload         
        //   991: aastore        
        //   992: iinc            4, -1
        //   995: iload           4
        //   997: ifge            982
        //  1000: invokestatic    gnu/kawa/slib/srfi1.map$Ex$V:(Lgnu/mapping/Procedure;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
        //  1003: areturn        
        //  1004: aload_2        
        //  1005: iconst_0       
        //  1006: aaload         
        //  1007: ldc             Lgnu/mapping/Procedure;.class
        //  1009: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //  1012: dup            
        //  1013: astore          4
        //  1015: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceToProcedure:(Ljava/lang/Object;)Lgnu/mapping/Procedure;
        //  1018: aload_2        
        //  1019: iconst_1       
        //  1020: aaload         
        //  1021: aload_2        
        //  1022: arraylength    
        //  1023: iconst_2       
        //  1024: isub           
        //  1025: istore          4
        //  1027: iload           4
        //  1029: anewarray       Ljava/lang/Object;
        //  1032: goto            1045
        //  1035: dup            
        //  1036: iload           4
        //  1038: aload_2        
        //  1039: iload           4
        //  1041: iconst_2       
        //  1042: iadd           
        //  1043: aaload         
        //  1044: aastore        
        //  1045: iinc            4, -1
        //  1048: iload           4
        //  1050: ifge            1035
        //  1053: invokestatic    gnu/kawa/slib/srfi1.filterMap$V:(Lgnu/mapping/Procedure;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
        //  1056: areturn        
        //  1057: aload_2        
        //  1058: iconst_0       
        //  1059: aaload         
        //  1060: ldc             Lgnu/mapping/Procedure;.class
        //  1062: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //  1065: dup            
        //  1066: astore          4
        //  1068: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceToProcedure:(Ljava/lang/Object;)Lgnu/mapping/Procedure;
        //  1071: aload_2        
        //  1072: iconst_1       
        //  1073: aaload         
        //  1074: aload_2        
        //  1075: arraylength    
        //  1076: iconst_2       
        //  1077: isub           
        //  1078: istore          4
        //  1080: iload           4
        //  1082: anewarray       Ljava/lang/Object;
        //  1085: goto            1098
        //  1088: dup            
        //  1089: iload           4
        //  1091: aload_2        
        //  1092: iload           4
        //  1094: iconst_2       
        //  1095: iadd           
        //  1096: aaload         
        //  1097: aastore        
        //  1098: iinc            4, -1
        //  1101: iload           4
        //  1103: ifge            1088
        //  1106: invokestatic    gnu/kawa/slib/srfi1.any$V:(Lgnu/mapping/Procedure;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
        //  1109: areturn        
        //  1110: aload_2        
        //  1111: iconst_0       
        //  1112: aaload         
        //  1113: ldc             Lgnu/mapping/Procedure;.class
        //  1115: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //  1118: dup            
        //  1119: astore          4
        //  1121: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceToProcedure:(Ljava/lang/Object;)Lgnu/mapping/Procedure;
        //  1124: aload_2        
        //  1125: iconst_1       
        //  1126: aaload         
        //  1127: aload_2        
        //  1128: arraylength    
        //  1129: iconst_2       
        //  1130: isub           
        //  1131: istore          4
        //  1133: iload           4
        //  1135: anewarray       Ljava/lang/Object;
        //  1138: goto            1151
        //  1141: dup            
        //  1142: iload           4
        //  1144: aload_2        
        //  1145: iload           4
        //  1147: iconst_2       
        //  1148: iadd           
        //  1149: aaload         
        //  1150: aastore        
        //  1151: iinc            4, -1
        //  1154: iload           4
        //  1156: ifge            1141
        //  1159: invokestatic    gnu/kawa/slib/srfi1.every$V:(Lgnu/mapping/Procedure;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
        //  1162: areturn        
        //  1163: aload_2        
        //  1164: iconst_0       
        //  1165: aaload         
        //  1166: ldc             Lgnu/mapping/Procedure;.class
        //  1168: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //  1171: dup            
        //  1172: astore          4
        //  1174: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceToProcedure:(Ljava/lang/Object;)Lgnu/mapping/Procedure;
        //  1177: aload_2        
        //  1178: iconst_1       
        //  1179: aaload         
        //  1180: aload_2        
        //  1181: arraylength    
        //  1182: iconst_2       
        //  1183: isub           
        //  1184: istore          4
        //  1186: iload           4
        //  1188: anewarray       Ljava/lang/Object;
        //  1191: goto            1204
        //  1194: dup            
        //  1195: iload           4
        //  1197: aload_2        
        //  1198: iload           4
        //  1200: iconst_2       
        //  1201: iadd           
        //  1202: aaload         
        //  1203: aastore        
        //  1204: iinc            4, -1
        //  1207: iload           4
        //  1209: ifge            1194
        //  1212: invokestatic    gnu/kawa/slib/srfi1.listIndex$V:(Lgnu/mapping/Procedure;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
        //  1215: areturn        
        //  1216: aload_2        
        //  1217: iconst_0       
        //  1218: aaload         
        //  1219: ldc             Lgnu/mapping/Procedure;.class
        //  1221: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //  1224: dup            
        //  1225: astore          4
        //  1227: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceToProcedure:(Ljava/lang/Object;)Lgnu/mapping/Procedure;
        //  1230: aload_2        
        //  1231: arraylength    
        //  1232: iconst_1       
        //  1233: isub           
        //  1234: istore          4
        //  1236: iload           4
        //  1238: anewarray       Ljava/lang/Object;
        //  1241: goto            1254
        //  1244: dup            
        //  1245: iload           4
        //  1247: aload_2        
        //  1248: iload           4
        //  1250: iconst_1       
        //  1251: iadd           
        //  1252: aaload         
        //  1253: aastore        
        //  1254: iinc            4, -1
        //  1257: iload           4
        //  1259: ifge            1244
        //  1262: invokestatic    gnu/kawa/slib/srfi1.lset$Ls$Eq$V:(Lgnu/mapping/Procedure;[Ljava/lang/Object;)Ljava/lang/Object;
        //  1265: areturn        
        //  1266: aload_2        
        //  1267: iconst_0       
        //  1268: aaload         
        //  1269: ldc             Lgnu/mapping/Procedure;.class
        //  1271: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //  1274: dup            
        //  1275: astore          4
        //  1277: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceToProcedure:(Ljava/lang/Object;)Lgnu/mapping/Procedure;
        //  1280: aload_2        
        //  1281: arraylength    
        //  1282: iconst_1       
        //  1283: isub           
        //  1284: istore          4
        //  1286: iload           4
        //  1288: anewarray       Ljava/lang/Object;
        //  1291: goto            1304
        //  1294: dup            
        //  1295: iload           4
        //  1297: aload_2        
        //  1298: iload           4
        //  1300: iconst_1       
        //  1301: iadd           
        //  1302: aaload         
        //  1303: aastore        
        //  1304: iinc            4, -1
        //  1307: iload           4
        //  1309: ifge            1294
        //  1312: invokestatic    gnu/kawa/slib/srfi1.lset$Eq$V:(Lgnu/mapping/Procedure;[Ljava/lang/Object;)Ljava/lang/Object;
        //  1315: areturn        
        //  1316: aload_2        
        //  1317: iconst_0       
        //  1318: aaload         
        //  1319: ldc             Lgnu/mapping/Procedure;.class
        //  1321: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //  1324: dup            
        //  1325: astore          4
        //  1327: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceToProcedure:(Ljava/lang/Object;)Lgnu/mapping/Procedure;
        //  1330: aload_2        
        //  1331: iconst_1       
        //  1332: aaload         
        //  1333: aload_2        
        //  1334: arraylength    
        //  1335: iconst_2       
        //  1336: isub           
        //  1337: istore          4
        //  1339: iload           4
        //  1341: anewarray       Ljava/lang/Object;
        //  1344: goto            1357
        //  1347: dup            
        //  1348: iload           4
        //  1350: aload_2        
        //  1351: iload           4
        //  1353: iconst_2       
        //  1354: iadd           
        //  1355: aaload         
        //  1356: aastore        
        //  1357: iinc            4, -1
        //  1360: iload           4
        //  1362: ifge            1347
        //  1365: invokestatic    gnu/kawa/slib/srfi1.lsetAdjoin$V:(Lgnu/mapping/Procedure;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
        //  1368: areturn        
        //  1369: aload_2        
        //  1370: iconst_0       
        //  1371: aaload         
        //  1372: ldc             Lgnu/mapping/Procedure;.class
        //  1374: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //  1377: dup            
        //  1378: astore          4
        //  1380: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceToProcedure:(Ljava/lang/Object;)Lgnu/mapping/Procedure;
        //  1383: aload_2        
        //  1384: arraylength    
        //  1385: iconst_1       
        //  1386: isub           
        //  1387: istore          4
        //  1389: iload           4
        //  1391: anewarray       Ljava/lang/Object;
        //  1394: goto            1407
        //  1397: dup            
        //  1398: iload           4
        //  1400: aload_2        
        //  1401: iload           4
        //  1403: iconst_1       
        //  1404: iadd           
        //  1405: aaload         
        //  1406: aastore        
        //  1407: iinc            4, -1
        //  1410: iload           4
        //  1412: ifge            1397
        //  1415: invokestatic    gnu/kawa/slib/srfi1.lsetUnion$V:(Lgnu/mapping/Procedure;[Ljava/lang/Object;)Ljava/lang/Object;
        //  1418: areturn        
        //  1419: aload_2        
        //  1420: iconst_0       
        //  1421: aaload         
        //  1422: ldc             Lgnu/mapping/Procedure;.class
        //  1424: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //  1427: dup            
        //  1428: astore          4
        //  1430: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceToProcedure:(Ljava/lang/Object;)Lgnu/mapping/Procedure;
        //  1433: aload_2        
        //  1434: arraylength    
        //  1435: iconst_1       
        //  1436: isub           
        //  1437: istore          4
        //  1439: iload           4
        //  1441: anewarray       Ljava/lang/Object;
        //  1444: goto            1457
        //  1447: dup            
        //  1448: iload           4
        //  1450: aload_2        
        //  1451: iload           4
        //  1453: iconst_1       
        //  1454: iadd           
        //  1455: aaload         
        //  1456: aastore        
        //  1457: iinc            4, -1
        //  1460: iload           4
        //  1462: ifge            1447
        //  1465: invokestatic    gnu/kawa/slib/srfi1.lsetUnion$Ex$V:(Lgnu/mapping/Procedure;[Ljava/lang/Object;)Ljava/lang/Object;
        //  1468: areturn        
        //  1469: aload_2        
        //  1470: iconst_0       
        //  1471: aaload         
        //  1472: ldc             Lgnu/mapping/Procedure;.class
        //  1474: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //  1477: dup            
        //  1478: astore          4
        //  1480: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceToProcedure:(Ljava/lang/Object;)Lgnu/mapping/Procedure;
        //  1483: aload_2        
        //  1484: iconst_1       
        //  1485: aaload         
        //  1486: aload_2        
        //  1487: arraylength    
        //  1488: iconst_2       
        //  1489: isub           
        //  1490: istore          4
        //  1492: iload           4
        //  1494: anewarray       Ljava/lang/Object;
        //  1497: goto            1510
        //  1500: dup            
        //  1501: iload           4
        //  1503: aload_2        
        //  1504: iload           4
        //  1506: iconst_2       
        //  1507: iadd           
        //  1508: aaload         
        //  1509: aastore        
        //  1510: iinc            4, -1
        //  1513: iload           4
        //  1515: ifge            1500
        //  1518: invokestatic    gnu/kawa/slib/srfi1.lsetIntersection$V:(Lgnu/mapping/Procedure;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
        //  1521: areturn        
        //  1522: aload_2        
        //  1523: iconst_0       
        //  1524: aaload         
        //  1525: ldc             Lgnu/mapping/Procedure;.class
        //  1527: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //  1530: dup            
        //  1531: astore          4
        //  1533: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceToProcedure:(Ljava/lang/Object;)Lgnu/mapping/Procedure;
        //  1536: aload_2        
        //  1537: iconst_1       
        //  1538: aaload         
        //  1539: aload_2        
        //  1540: arraylength    
        //  1541: iconst_2       
        //  1542: isub           
        //  1543: istore          4
        //  1545: iload           4
        //  1547: anewarray       Ljava/lang/Object;
        //  1550: goto            1563
        //  1553: dup            
        //  1554: iload           4
        //  1556: aload_2        
        //  1557: iload           4
        //  1559: iconst_2       
        //  1560: iadd           
        //  1561: aaload         
        //  1562: aastore        
        //  1563: iinc            4, -1
        //  1566: iload           4
        //  1568: ifge            1553
        //  1571: invokestatic    gnu/kawa/slib/srfi1.lsetIntersection$Ex$V:(Lgnu/mapping/Procedure;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
        //  1574: areturn        
        //  1575: aload_2        
        //  1576: iconst_0       
        //  1577: aaload         
        //  1578: ldc             Lgnu/mapping/Procedure;.class
        //  1580: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //  1583: dup            
        //  1584: astore          4
        //  1586: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceToProcedure:(Ljava/lang/Object;)Lgnu/mapping/Procedure;
        //  1589: aload_2        
        //  1590: iconst_1       
        //  1591: aaload         
        //  1592: aload_2        
        //  1593: arraylength    
        //  1594: iconst_2       
        //  1595: isub           
        //  1596: istore          4
        //  1598: iload           4
        //  1600: anewarray       Ljava/lang/Object;
        //  1603: goto            1616
        //  1606: dup            
        //  1607: iload           4
        //  1609: aload_2        
        //  1610: iload           4
        //  1612: iconst_2       
        //  1613: iadd           
        //  1614: aaload         
        //  1615: aastore        
        //  1616: iinc            4, -1
        //  1619: iload           4
        //  1621: ifge            1606
        //  1624: invokestatic    gnu/kawa/slib/srfi1.lsetDifference$V:(Lgnu/mapping/Procedure;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
        //  1627: areturn        
        //  1628: aload_2        
        //  1629: iconst_0       
        //  1630: aaload         
        //  1631: ldc             Lgnu/mapping/Procedure;.class
        //  1633: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //  1636: dup            
        //  1637: astore          4
        //  1639: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceToProcedure:(Ljava/lang/Object;)Lgnu/mapping/Procedure;
        //  1642: aload_2        
        //  1643: iconst_1       
        //  1644: aaload         
        //  1645: aload_2        
        //  1646: arraylength    
        //  1647: iconst_2       
        //  1648: isub           
        //  1649: istore          4
        //  1651: iload           4
        //  1653: anewarray       Ljava/lang/Object;
        //  1656: goto            1669
        //  1659: dup            
        //  1660: iload           4
        //  1662: aload_2        
        //  1663: iload           4
        //  1665: iconst_2       
        //  1666: iadd           
        //  1667: aaload         
        //  1668: aastore        
        //  1669: iinc            4, -1
        //  1672: iload           4
        //  1674: ifge            1659
        //  1677: invokestatic    gnu/kawa/slib/srfi1.lsetDifference$Ex$V:(Lgnu/mapping/Procedure;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
        //  1680: areturn        
        //  1681: aload_2        
        //  1682: iconst_0       
        //  1683: aaload         
        //  1684: ldc             Lgnu/mapping/Procedure;.class
        //  1686: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //  1689: dup            
        //  1690: astore          4
        //  1692: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceToProcedure:(Ljava/lang/Object;)Lgnu/mapping/Procedure;
        //  1695: aload_2        
        //  1696: arraylength    
        //  1697: iconst_1       
        //  1698: isub           
        //  1699: istore          4
        //  1701: iload           4
        //  1703: anewarray       Ljava/lang/Object;
        //  1706: goto            1719
        //  1709: dup            
        //  1710: iload           4
        //  1712: aload_2        
        //  1713: iload           4
        //  1715: iconst_1       
        //  1716: iadd           
        //  1717: aaload         
        //  1718: aastore        
        //  1719: iinc            4, -1
        //  1722: iload           4
        //  1724: ifge            1709
        //  1727: invokestatic    gnu/kawa/slib/srfi1.lsetXor$V:(Lgnu/mapping/Procedure;[Ljava/lang/Object;)Ljava/lang/Object;
        //  1730: areturn        
        //  1731: aload_2        
        //  1732: iconst_0       
        //  1733: aaload         
        //  1734: ldc             Lgnu/mapping/Procedure;.class
        //  1736: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //  1739: dup            
        //  1740: astore          4
        //  1742: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceToProcedure:(Ljava/lang/Object;)Lgnu/mapping/Procedure;
        //  1745: aload_2        
        //  1746: arraylength    
        //  1747: iconst_1       
        //  1748: isub           
        //  1749: istore          4
        //  1751: iload           4
        //  1753: anewarray       Ljava/lang/Object;
        //  1756: goto            1769
        //  1759: dup            
        //  1760: iload           4
        //  1762: aload_2        
        //  1763: iload           4
        //  1765: iconst_1       
        //  1766: iadd           
        //  1767: aaload         
        //  1768: aastore        
        //  1769: iinc            4, -1
        //  1772: iload           4
        //  1774: ifge            1759
        //  1777: invokestatic    gnu/kawa/slib/srfi1.lsetXor$Ex$V:(Lgnu/mapping/Procedure;[Ljava/lang/Object;)Ljava/lang/Object;
        //  1780: areturn        
        //  1781: aload_2        
        //  1782: iconst_0       
        //  1783: aaload         
        //  1784: ldc             Lgnu/mapping/Procedure;.class
        //  1786: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //  1789: dup            
        //  1790: astore          4
        //  1792: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceToProcedure:(Ljava/lang/Object;)Lgnu/mapping/Procedure;
        //  1795: aload_2        
        //  1796: iconst_1       
        //  1797: aaload         
        //  1798: aload_2        
        //  1799: arraylength    
        //  1800: iconst_2       
        //  1801: isub           
        //  1802: istore          4
        //  1804: iload           4
        //  1806: anewarray       Ljava/lang/Object;
        //  1809: goto            1822
        //  1812: dup            
        //  1813: iload           4
        //  1815: aload_2        
        //  1816: iload           4
        //  1818: iconst_2       
        //  1819: iadd           
        //  1820: aaload         
        //  1821: aastore        
        //  1822: iinc            4, -1
        //  1825: iload           4
        //  1827: ifge            1812
        //  1830: invokestatic    gnu/kawa/slib/srfi1.lsetDiff$PlIntersection$V:(Lgnu/mapping/Procedure;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
        //  1833: areturn        
        //  1834: aload_2        
        //  1835: iconst_0       
        //  1836: aaload         
        //  1837: ldc             Lgnu/mapping/Procedure;.class
        //  1839: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //  1842: dup            
        //  1843: astore          4
        //  1845: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceToProcedure:(Ljava/lang/Object;)Lgnu/mapping/Procedure;
        //  1848: aload_2        
        //  1849: iconst_1       
        //  1850: aaload         
        //  1851: aload_2        
        //  1852: arraylength    
        //  1853: iconst_2       
        //  1854: isub           
        //  1855: istore          4
        //  1857: iload           4
        //  1859: anewarray       Ljava/lang/Object;
        //  1862: goto            1875
        //  1865: dup            
        //  1866: iload           4
        //  1868: aload_2        
        //  1869: iload           4
        //  1871: iconst_2       
        //  1872: iadd           
        //  1873: aaload         
        //  1874: aastore        
        //  1875: iinc            4, -1
        //  1878: iload           4
        //  1880: ifge            1865
        //  1883: invokestatic    gnu/kawa/slib/srfi1.lsetDiff$PlIntersection$Ex$V:(Lgnu/mapping/Procedure;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
        //  1886: areturn        
        //  1887: aload_0        
        //  1888: aload_1        
        //  1889: aload_2        
        //  1890: invokespecial   gnu/expr/ModuleBody.applyN:(Lgnu/expr/ModuleMethod;[Ljava/lang/Object;)Ljava/lang/Object;
        //  1893: areturn        
        //  1894: new             Lgnu/mapping/WrongType;
        //  1897: dup_x1         
        //  1898: swap           
        //  1899: ldc_w           "count"
        //  1902: iconst_1       
        //  1903: aload_3        
        //  1904: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1907: athrow         
        //  1908: new             Lgnu/mapping/WrongType;
        //  1911: dup_x1         
        //  1912: swap           
        //  1913: ldc_w           "unfold-right"
        //  1916: iconst_1       
        //  1917: aload           4
        //  1919: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1922: athrow         
        //  1923: new             Lgnu/mapping/WrongType;
        //  1926: dup_x1         
        //  1927: swap           
        //  1928: ldc_w           "unfold-right"
        //  1931: iconst_2       
        //  1932: aload           4
        //  1934: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1937: athrow         
        //  1938: new             Lgnu/mapping/WrongType;
        //  1941: dup_x1         
        //  1942: swap           
        //  1943: ldc_w           "unfold-right"
        //  1946: iconst_3       
        //  1947: aload           4
        //  1949: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1952: athrow         
        //  1953: new             Lgnu/mapping/WrongType;
        //  1956: dup_x1         
        //  1957: swap           
        //  1958: ldc_w           "unfold"
        //  1961: iconst_1       
        //  1962: aload           4
        //  1964: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1967: athrow         
        //  1968: new             Lgnu/mapping/WrongType;
        //  1971: dup_x1         
        //  1972: swap           
        //  1973: ldc_w           "unfold"
        //  1976: iconst_2       
        //  1977: aload           4
        //  1979: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1982: athrow         
        //  1983: new             Lgnu/mapping/WrongType;
        //  1986: dup_x1         
        //  1987: swap           
        //  1988: ldc_w           "unfold"
        //  1991: iconst_3       
        //  1992: aload           4
        //  1994: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1997: athrow         
        //  1998: new             Lgnu/mapping/WrongType;
        //  2001: dup_x1         
        //  2002: swap           
        //  2003: ldc_w           "fold"
        //  2006: iconst_1       
        //  2007: aload           4
        //  2009: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  2012: athrow         
        //  2013: new             Lgnu/mapping/WrongType;
        //  2016: dup_x1         
        //  2017: swap           
        //  2018: ldc_w           "fold-right"
        //  2021: iconst_1       
        //  2022: aload           4
        //  2024: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  2027: athrow         
        //  2028: new             Lgnu/mapping/WrongType;
        //  2031: dup_x1         
        //  2032: swap           
        //  2033: ldc_w           "pair-fold-right"
        //  2036: iconst_1       
        //  2037: aload           4
        //  2039: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  2042: athrow         
        //  2043: new             Lgnu/mapping/WrongType;
        //  2046: dup_x1         
        //  2047: swap           
        //  2048: ldc_w           "pair-fold"
        //  2051: iconst_1       
        //  2052: aload           4
        //  2054: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  2057: athrow         
        //  2058: new             Lgnu/mapping/WrongType;
        //  2061: dup_x1         
        //  2062: swap           
        //  2063: ldc_w           "pair-for-each"
        //  2066: iconst_1       
        //  2067: aload           4
        //  2069: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  2072: athrow         
        //  2073: new             Lgnu/mapping/WrongType;
        //  2076: dup_x1         
        //  2077: swap           
        //  2078: ldc_w           "map!"
        //  2081: iconst_1       
        //  2082: aload           4
        //  2084: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  2087: athrow         
        //  2088: new             Lgnu/mapping/WrongType;
        //  2091: dup_x1         
        //  2092: swap           
        //  2093: ldc_w           "filter-map"
        //  2096: iconst_1       
        //  2097: aload           4
        //  2099: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  2102: athrow         
        //  2103: new             Lgnu/mapping/WrongType;
        //  2106: dup_x1         
        //  2107: swap           
        //  2108: ldc_w           "any"
        //  2111: iconst_1       
        //  2112: aload           4
        //  2114: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  2117: athrow         
        //  2118: new             Lgnu/mapping/WrongType;
        //  2121: dup_x1         
        //  2122: swap           
        //  2123: ldc_w           "every"
        //  2126: iconst_1       
        //  2127: aload           4
        //  2129: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  2132: athrow         
        //  2133: new             Lgnu/mapping/WrongType;
        //  2136: dup_x1         
        //  2137: swap           
        //  2138: ldc_w           "list-index"
        //  2141: iconst_1       
        //  2142: aload           4
        //  2144: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  2147: athrow         
        //  2148: new             Lgnu/mapping/WrongType;
        //  2151: dup_x1         
        //  2152: swap           
        //  2153: ldc_w           "lset<="
        //  2156: iconst_1       
        //  2157: aload           4
        //  2159: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  2162: athrow         
        //  2163: new             Lgnu/mapping/WrongType;
        //  2166: dup_x1         
        //  2167: swap           
        //  2168: ldc_w           "lset="
        //  2171: iconst_1       
        //  2172: aload           4
        //  2174: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  2177: athrow         
        //  2178: new             Lgnu/mapping/WrongType;
        //  2181: dup_x1         
        //  2182: swap           
        //  2183: ldc_w           "lset-adjoin"
        //  2186: iconst_1       
        //  2187: aload           4
        //  2189: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  2192: athrow         
        //  2193: new             Lgnu/mapping/WrongType;
        //  2196: dup_x1         
        //  2197: swap           
        //  2198: ldc_w           "lset-union"
        //  2201: iconst_1       
        //  2202: aload           4
        //  2204: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  2207: athrow         
        //  2208: new             Lgnu/mapping/WrongType;
        //  2211: dup_x1         
        //  2212: swap           
        //  2213: ldc_w           "lset-union!"
        //  2216: iconst_1       
        //  2217: aload           4
        //  2219: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  2222: athrow         
        //  2223: new             Lgnu/mapping/WrongType;
        //  2226: dup_x1         
        //  2227: swap           
        //  2228: ldc_w           "lset-intersection"
        //  2231: iconst_1       
        //  2232: aload           4
        //  2234: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  2237: athrow         
        //  2238: new             Lgnu/mapping/WrongType;
        //  2241: dup_x1         
        //  2242: swap           
        //  2243: ldc_w           "lset-intersection!"
        //  2246: iconst_1       
        //  2247: aload           4
        //  2249: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  2252: athrow         
        //  2253: new             Lgnu/mapping/WrongType;
        //  2256: dup_x1         
        //  2257: swap           
        //  2258: ldc_w           "lset-difference"
        //  2261: iconst_1       
        //  2262: aload           4
        //  2264: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  2267: athrow         
        //  2268: new             Lgnu/mapping/WrongType;
        //  2271: dup_x1         
        //  2272: swap           
        //  2273: ldc_w           "lset-difference!"
        //  2276: iconst_1       
        //  2277: aload           4
        //  2279: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  2282: athrow         
        //  2283: new             Lgnu/mapping/WrongType;
        //  2286: dup_x1         
        //  2287: swap           
        //  2288: ldc_w           "lset-xor"
        //  2291: iconst_1       
        //  2292: aload           4
        //  2294: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  2297: athrow         
        //  2298: new             Lgnu/mapping/WrongType;
        //  2301: dup_x1         
        //  2302: swap           
        //  2303: ldc_w           "lset-xor!"
        //  2306: iconst_1       
        //  2307: aload           4
        //  2309: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  2312: athrow         
        //  2313: new             Lgnu/mapping/WrongType;
        //  2316: dup_x1         
        //  2317: swap           
        //  2318: ldc_w           "lset-diff+intersection"
        //  2321: iconst_1       
        //  2322: aload           4
        //  2324: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  2327: athrow         
        //  2328: new             Lgnu/mapping/WrongType;
        //  2331: dup_x1         
        //  2332: swap           
        //  2333: ldc_w           "lset-diff+intersection!"
        //  2336: iconst_1       
        //  2337: aload           4
        //  2339: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  2342: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  402    405    1894   1908   Ljava/lang/ClassCastException;
        //  455    458    1908   1923   Ljava/lang/ClassCastException;
        //  469    472    1923   1938   Ljava/lang/ClassCastException;
        //  483    486    1938   1953   Ljava/lang/ClassCastException;
        //  520    523    1953   1968   Ljava/lang/ClassCastException;
        //  534    537    1968   1983   Ljava/lang/ClassCastException;
        //  548    551    1983   1998   Ljava/lang/ClassCastException;
        //  601    604    1998   2013   Ljava/lang/ClassCastException;
        //  657    660    2013   2028   Ljava/lang/ClassCastException;
        //  713    716    2028   2043   Ljava/lang/ClassCastException;
        //  769    772    2043   2058   Ljava/lang/ClassCastException;
        //  909    912    2058   2073   Ljava/lang/ClassCastException;
        //  962    965    2073   2088   Ljava/lang/ClassCastException;
        //  1015   1018   2088   2103   Ljava/lang/ClassCastException;
        //  1068   1071   2103   2118   Ljava/lang/ClassCastException;
        //  1121   1124   2118   2133   Ljava/lang/ClassCastException;
        //  1174   1177   2133   2148   Ljava/lang/ClassCastException;
        //  1227   1230   2148   2163   Ljava/lang/ClassCastException;
        //  1277   1280   2163   2178   Ljava/lang/ClassCastException;
        //  1327   1330   2178   2193   Ljava/lang/ClassCastException;
        //  1380   1383   2193   2208   Ljava/lang/ClassCastException;
        //  1430   1433   2208   2223   Ljava/lang/ClassCastException;
        //  1480   1483   2223   2238   Ljava/lang/ClassCastException;
        //  1533   1536   2238   2253   Ljava/lang/ClassCastException;
        //  1586   1589   2253   2268   Ljava/lang/ClassCastException;
        //  1639   1642   2268   2283   Ljava/lang/ClassCastException;
        //  1692   1695   2283   2298   Ljava/lang/ClassCastException;
        //  1742   1745   2298   2313   Ljava/lang/ClassCastException;
        //  1792   1795   2313   2328   Ljava/lang/ClassCastException;
        //  1845   1848   2328   2343   Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 1232 out of bounds for length 1232
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
