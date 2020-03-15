// 
// Decompiled by Procyon v0.5.36
// 

package kawa.lib;

import gnu.kawa.lispexpr.LangObjType;
import gnu.lists.Sequences;
import gnu.expr.ModuleInfo;
import gnu.mapping.MethodProc;
import gnu.mapping.Symbol;
import java.io.Serializable;
import gnu.expr.KawaConvert;
import gnu.mapping.Procedure;
import kawa.standard.Scheme;
import gnu.kawa.functions.IsEqv;
import gnu.mapping.WrongType;
import kawa.SourceMethodType;
import java.util.List;
import gnu.lists.LList;
import gnu.mapping.Promise;
import gnu.lists.Pair;
import gnu.lists.Consumer;
import gnu.mapping.CallContext;
import gnu.mapping.SimpleSymbol;
import gnu.expr.Keyword;
import gnu.kawa.reflect.StaticFieldLocation;
import gnu.expr.GenericProc;
import gnu.expr.ModuleMethod;
import gnu.expr.ModuleBody;

public class lists extends ModuleBody
{
    public static final ModuleMethod pair$Qu;
    public static final ModuleMethod cons;
    public static final ModuleMethod null$Qu;
    public static final ModuleMethod set$Mncar$Ex;
    public static final ModuleMethod set$Mncdr$Ex;
    public static final GenericProc car;
    public static final GenericProc cdr;
    public static final GenericProc caar;
    public static final GenericProc cadr;
    public static final GenericProc cdar;
    public static final GenericProc cddr;
    public static final GenericProc caaar;
    public static final GenericProc caadr;
    public static final GenericProc cadar;
    public static final GenericProc caddr;
    public static final GenericProc cdaar;
    public static final GenericProc cdadr;
    public static final GenericProc cddar;
    public static final GenericProc cdddr;
    public static final GenericProc caaaar;
    public static final GenericProc caaadr;
    public static final GenericProc caadar;
    public static final GenericProc caaddr;
    public static final GenericProc cadaar;
    public static final GenericProc cadadr;
    public static final GenericProc caddar;
    public static final GenericProc cadddr;
    public static final GenericProc cdaaar;
    public static final GenericProc cdaadr;
    public static final GenericProc cdadar;
    public static final GenericProc cdaddr;
    public static final GenericProc cddaar;
    public static final GenericProc cddadr;
    public static final GenericProc cdddar;
    public static final GenericProc cddddr;
    public static final ModuleMethod length;
    public static final ModuleMethod reverse;
    public static final ModuleMethod list$Mntail;
    public static final GenericProc list$Mnref;
    public static final ModuleMethod list$Mnset$Ex;
    public static final ModuleMethod list$Qu;
    public static final ModuleMethod make$Mnlist;
    public static final ModuleMethod reverse$Ex;
    public static final ModuleMethod memq;
    public static final ModuleMethod memv;
    public static final ModuleMethod member;
    public static final ModuleMethod assq;
    public static final ModuleMethod assv;
    public static final ModuleMethod assoc;
    public static final ModuleMethod list$Mncopy;
    public static final StaticFieldLocation $Prvt$define$Mnprocedure;
    static final Keyword Lit0;
    static final ModuleMethod lambda$Fn1;
    static final ModuleMethod lambda$Fn2;
    static final ModuleMethod lambda$Fn3;
    static final ModuleMethod lambda$Fn4;
    static final ModuleMethod lambda$Fn5;
    static final ModuleMethod lambda$Fn6;
    static final ModuleMethod lambda$Fn7;
    static final ModuleMethod lambda$Fn8;
    static final ModuleMethod lambda$Fn9;
    static final ModuleMethod lambda$Fn10;
    static final ModuleMethod lambda$Fn11;
    static final ModuleMethod lambda$Fn12;
    static final ModuleMethod lambda$Fn13;
    static final ModuleMethod lambda$Fn14;
    static final ModuleMethod lambda$Fn15;
    static final ModuleMethod lambda$Fn16;
    static final ModuleMethod lambda$Fn17;
    static final ModuleMethod lambda$Fn18;
    static final ModuleMethod lambda$Fn19;
    static final ModuleMethod lambda$Fn20;
    static final ModuleMethod lambda$Fn21;
    static final ModuleMethod lambda$Fn22;
    static final ModuleMethod lambda$Fn23;
    static final ModuleMethod lambda$Fn24;
    static final ModuleMethod lambda$Fn25;
    static final ModuleMethod lambda$Fn26;
    static final ModuleMethod lambda$Fn27;
    static final ModuleMethod lambda$Fn28;
    public static lists $instance;
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
        lists.car.setProperty(lists.Lit0, lists.set$Mncar$Ex);
        lists.cdr.setProperty(lists.Lit0, lists.set$Mncdr$Ex);
        lists.caar.setProperty(lists.Lit0, lists.lambda$Fn1);
        lists.cadr.setProperty(lists.Lit0, lists.lambda$Fn2);
        lists.cdar.setProperty(lists.Lit0, lists.lambda$Fn3);
        lists.cddr.setProperty(lists.Lit0, lists.lambda$Fn4);
        lists.caaar.setProperty(lists.Lit0, lists.lambda$Fn5);
        lists.caadr.setProperty(lists.Lit0, lists.lambda$Fn6);
        lists.cadar.setProperty(lists.Lit0, lists.lambda$Fn7);
        lists.caddr.setProperty(lists.Lit0, lists.lambda$Fn8);
        lists.cdaar.setProperty(lists.Lit0, lists.lambda$Fn9);
        lists.cdadr.setProperty(lists.Lit0, lists.lambda$Fn10);
        lists.cddar.setProperty(lists.Lit0, lists.lambda$Fn11);
        lists.cdddr.setProperty(lists.Lit0, lists.lambda$Fn12);
        lists.caaaar.setProperty(lists.Lit0, lists.lambda$Fn13);
        lists.caaadr.setProperty(lists.Lit0, lists.lambda$Fn14);
        lists.caadar.setProperty(lists.Lit0, lists.lambda$Fn15);
        lists.caaddr.setProperty(lists.Lit0, lists.lambda$Fn16);
        lists.cadaar.setProperty(lists.Lit0, lists.lambda$Fn17);
        lists.cadadr.setProperty(lists.Lit0, lists.lambda$Fn18);
        lists.caddar.setProperty(lists.Lit0, lists.lambda$Fn19);
        lists.cadddr.setProperty(lists.Lit0, lists.lambda$Fn20);
        lists.cdaaar.setProperty(lists.Lit0, lists.lambda$Fn21);
        lists.cdaadr.setProperty(lists.Lit0, lists.lambda$Fn22);
        lists.cdadar.setProperty(lists.Lit0, lists.lambda$Fn23);
        lists.cdaddr.setProperty(lists.Lit0, lists.lambda$Fn24);
        lists.cddaar.setProperty(lists.Lit0, lists.lambda$Fn25);
        lists.cddadr.setProperty(lists.Lit0, lists.lambda$Fn26);
        lists.cdddar.setProperty(lists.Lit0, lists.lambda$Fn27);
        lists.cddddr.setProperty(lists.Lit0, lists.lambda$Fn28);
        lists.list$Mnref.setProperty(lists.Lit0, lists.list$Mnset$Ex);
    }
    
    public static boolean isPair(final Object x) {
        return Promise.force(x) instanceof Pair;
    }
    
    public static Pair cons(final Object car, final Object cdr) {
        return new Pair(car, cdr);
    }
    
    public static boolean isNull(final Object x) {
        return Promise.force(x) == LList.Empty;
    }
    
    public static void setCar$Ex(final Pair p, final Object x) {
        p.setCar(x);
    }
    
    public static void setCdr$Ex(final Pair p, final Object x) {
        p.setCdr(x);
    }
    
    static void lambda1(final Object arg, final Object value) {
        ((Pair)Promise.force(((Pair)Promise.force(arg, Pair.class)).getCar(), Pair.class)).setCar(value);
    }
    
    static void lambda2(final Object arg, final Object value) {
        ((Pair)Promise.force(((Pair)Promise.force(arg, Pair.class)).getCdr(), Pair.class)).setCar(value);
    }
    
    static void lambda3(final Object arg, final Object value) {
        ((Pair)Promise.force(((Pair)Promise.force(arg, Pair.class)).getCar(), Pair.class)).setCdr(value);
    }
    
    static void lambda4(final Object arg, final Object value) {
        ((Pair)Promise.force(((Pair)Promise.force(arg, Pair.class)).getCdr(), Pair.class)).setCdr(value);
    }
    
    static void lambda5(final Object arg, final Object value) {
        ((Pair)Promise.force(((Pair)Promise.force(((Pair)Promise.force(arg, Pair.class)).getCar(), Pair.class)).getCar(), Pair.class)).setCar(value);
    }
    
    static void lambda6(final Object arg, final Object value) {
        ((Pair)Promise.force(((Pair)Promise.force(((Pair)Promise.force(arg, Pair.class)).getCdr(), Pair.class)).getCar(), Pair.class)).setCar(value);
    }
    
    static void lambda7(final Object arg, final Object value) {
        ((Pair)Promise.force(((Pair)Promise.force(((Pair)Promise.force(arg, Pair.class)).getCar(), Pair.class)).getCdr(), Pair.class)).setCar(value);
    }
    
    static void lambda8(final Object arg, final Object value) {
        ((Pair)Promise.force(((Pair)Promise.force(((Pair)Promise.force(arg, Pair.class)).getCdr(), Pair.class)).getCdr(), Pair.class)).setCar(value);
    }
    
    static void lambda9(final Object arg, final Object value) {
        ((Pair)Promise.force(((Pair)Promise.force(((Pair)Promise.force(arg, Pair.class)).getCar(), Pair.class)).getCar(), Pair.class)).setCdr(value);
    }
    
    static void lambda10(final Object arg, final Object value) {
        ((Pair)Promise.force(((Pair)Promise.force(((Pair)Promise.force(arg, Pair.class)).getCdr(), Pair.class)).getCar(), Pair.class)).setCdr(value);
    }
    
    static void lambda11(final Object arg, final Object value) {
        ((Pair)Promise.force(((Pair)Promise.force(((Pair)Promise.force(arg, Pair.class)).getCar(), Pair.class)).getCdr(), Pair.class)).setCdr(value);
    }
    
    static void lambda12(final Object arg, final Object value) {
        ((Pair)Promise.force(((Pair)Promise.force(((Pair)Promise.force(arg, Pair.class)).getCdr(), Pair.class)).getCdr(), Pair.class)).setCdr(value);
    }
    
    static void lambda13(final Object arg, final Object value) {
        ((Pair)Promise.force(((Pair)Promise.force(((Pair)Promise.force(((Pair)Promise.force(arg, Pair.class)).getCar(), Pair.class)).getCar(), Pair.class)).getCar(), Pair.class)).setCar(value);
    }
    
    static void lambda14(final Object arg, final Object value) {
        ((Pair)Promise.force(((Pair)Promise.force(((Pair)Promise.force(((Pair)Promise.force(arg, Pair.class)).getCdr(), Pair.class)).getCar(), Pair.class)).getCar(), Pair.class)).setCar(value);
    }
    
    static void lambda15(final Object arg, final Object value) {
        ((Pair)Promise.force(((Pair)Promise.force(((Pair)Promise.force(((Pair)Promise.force(arg, Pair.class)).getCar(), Pair.class)).getCdr(), Pair.class)).getCar(), Pair.class)).setCar(value);
    }
    
    static void lambda16(final Object arg, final Object value) {
        ((Pair)Promise.force(((Pair)Promise.force(((Pair)Promise.force(((Pair)Promise.force(arg, Pair.class)).getCdr(), Pair.class)).getCdr(), Pair.class)).getCar(), Pair.class)).setCar(value);
    }
    
    static void lambda17(final Object arg, final Object value) {
        ((Pair)Promise.force(((Pair)Promise.force(((Pair)Promise.force(((Pair)Promise.force(arg, Pair.class)).getCar(), Pair.class)).getCar(), Pair.class)).getCdr(), Pair.class)).setCar(value);
    }
    
    static void lambda18(final Object arg, final Object value) {
        ((Pair)Promise.force(((Pair)Promise.force(((Pair)Promise.force(((Pair)Promise.force(arg, Pair.class)).getCdr(), Pair.class)).getCar(), Pair.class)).getCdr(), Pair.class)).setCar(value);
    }
    
    static void lambda19(final Object arg, final Object value) {
        ((Pair)Promise.force(((Pair)Promise.force(((Pair)Promise.force(((Pair)Promise.force(arg, Pair.class)).getCar(), Pair.class)).getCdr(), Pair.class)).getCdr(), Pair.class)).setCar(value);
    }
    
    static void lambda20(final Object arg, final Object value) {
        ((Pair)Promise.force(((Pair)Promise.force(((Pair)Promise.force(((Pair)Promise.force(arg, Pair.class)).getCdr(), Pair.class)).getCdr(), Pair.class)).getCdr(), Pair.class)).setCar(value);
    }
    
    static void lambda21(final Object arg, final Object value) {
        ((Pair)Promise.force(((Pair)Promise.force(((Pair)Promise.force(((Pair)Promise.force(arg, Pair.class)).getCar(), Pair.class)).getCar(), Pair.class)).getCar(), Pair.class)).setCdr(value);
    }
    
    static void lambda22(final Object arg, final Object value) {
        ((Pair)Promise.force(((Pair)Promise.force(((Pair)Promise.force(((Pair)Promise.force(arg, Pair.class)).getCdr(), Pair.class)).getCar(), Pair.class)).getCar(), Pair.class)).setCdr(value);
    }
    
    static void lambda23(final Object arg, final Object value) {
        ((Pair)Promise.force(((Pair)Promise.force(((Pair)Promise.force(((Pair)Promise.force(arg, Pair.class)).getCar(), Pair.class)).getCdr(), Pair.class)).getCar(), Pair.class)).setCdr(value);
    }
    
    static void lambda24(final Object arg, final Object value) {
        ((Pair)Promise.force(((Pair)Promise.force(((Pair)Promise.force(((Pair)Promise.force(arg, Pair.class)).getCdr(), Pair.class)).getCdr(), Pair.class)).getCar(), Pair.class)).setCdr(value);
    }
    
    static void lambda25(final Object arg, final Object value) {
        ((Pair)Promise.force(((Pair)Promise.force(((Pair)Promise.force(((Pair)Promise.force(arg, Pair.class)).getCar(), Pair.class)).getCar(), Pair.class)).getCdr(), Pair.class)).setCdr(value);
    }
    
    static void lambda26(final Object arg, final Object value) {
        ((Pair)Promise.force(((Pair)Promise.force(((Pair)Promise.force(((Pair)Promise.force(arg, Pair.class)).getCdr(), Pair.class)).getCar(), Pair.class)).getCdr(), Pair.class)).setCdr(value);
    }
    
    static void lambda27(final Object arg, final Object value) {
        ((Pair)Promise.force(((Pair)Promise.force(((Pair)Promise.force(((Pair)Promise.force(arg, Pair.class)).getCar(), Pair.class)).getCdr(), Pair.class)).getCdr(), Pair.class)).setCdr(value);
    }
    
    static void lambda28(final Object arg, final Object value) {
        ((Pair)Promise.force(((Pair)Promise.force(((Pair)Promise.force(((Pair)Promise.force(arg, Pair.class)).getCdr(), Pair.class)).getCdr(), Pair.class)).getCdr(), Pair.class)).setCdr(value);
    }
    
    @SourceMethodType({ "", "sequence" })
    public static int length(final List list) {
        return list.size();
    }
    
    public static LList reverse(final LList list) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
        //     4: astore_2       
        //     5: astore_1        /* arg */
        //     6: aload_1         /* arg */
        //     7: invokestatic    kawa/lib/lists.isNull:(Ljava/lang/Object;)Z
        //    10: ifeq            25
        //    13: aload_2         /* result */
        //    14: ldc             Lgnu/lists/LList;.class
        //    16: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    19: checkcast       Lgnu/lists/LList;
        //    22: goto            53
        //    25: aload_1         /* arg */
        //    26: ldc             Lgnu/lists/Pair;.class
        //    28: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    31: dup            
        //    32: astore          4
        //    34: checkcast       Lgnu/lists/Pair;
        //    37: astore_3        /* p */
        //    38: aload_3         /* p */
        //    39: invokevirtual   gnu/lists/Pair.getCdr:()Ljava/lang/Object;
        //    42: aload_3         /* p */
        //    43: invokevirtual   gnu/lists/Pair.getCar:()Ljava/lang/Object;
        //    46: aload_2         /* result */
        //    47: invokestatic    kawa/lib/lists.cons:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //    50: goto            4
        //    53: areturn        
        //    54: new             Lgnu/mapping/WrongType;
        //    57: dup_x1         
        //    58: swap           
        //    59: ldc             "p"
        //    61: bipush          -2
        //    63: aload           4
        //    65: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //    68: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  34     37     54     69     Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public static Object listTail(final Object list, int count) {
        Object cdr = list;
        while (true) {
            final Object lst = cdr;
            if (--count < 0) {
                return lst;
            }
            final Object flst = Promise.force(lst);
            if (!(flst instanceof Pair)) {
                throw new IndexOutOfBoundsException("List is too short.");
            }
            cdr = ((Pair)Promise.force(flst, Pair.class)).getCdr();
        }
    }
    
    public static void listSet$Ex(final Object list, final int index, final Object obj) {
        final Object force = Promise.force(listTail(list, index), Pair.class);
        try {
            setCar$Ex((Pair)force, obj);
        }
        catch (ClassCastException ex) {
            throw new WrongType(ex, "set-car!", 0, force);
        }
    }
    
    public static boolean isList(final Object obj) {
        return LList.listLength(obj, false) >= 0;
    }
    
    public static LList makeList(final int k) {
        return makeList(k, null);
    }
    
    public static LList makeList(final int k, final Object fill) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: iload_0         /* k */
        //     4: istore_3       
        //     5: astore_2        /* result */
        //     6: iload_3         /* i */
        //     7: ifle            22
        //    10: aload_1         /* fill */
        //    11: aload_2         /* result */
        //    12: invokestatic    kawa/lib/lists.cons:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //    15: iinc            i, -1
        //    18: astore_2        /* result */
        //    19: goto            6
        //    22: aload_2         /* result */
        //    23: areturn        
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public static LList reverse$Ex(final LList list) {
        return LList.reverseInPlace(list);
    }
    
    public static Object memq(final Object x, final Object list) {
        Object cdr = list;
        Object false;
        while (true) {
            final Object lst = cdr;
            final Object force = Promise.force(lst, Pair.class);
            if (!(force instanceof Pair)) {
                false = Boolean.FALSE;
                break;
            }
            final Pair pair = (Pair)force;
            if (x == pair.getCar()) {
                false = lst;
                break;
            }
            cdr = pair.getCdr();
        }
        return false;
    }
    
    public static Object memv(final Object x, final Object list) {
        Object cdr = list;
        Object false;
        while (true) {
            final Object lst = cdr;
            final Object force = Promise.force(lst, Pair.class);
            if (!(force instanceof Pair)) {
                false = Boolean.FALSE;
                break;
            }
            final Pair pair = (Pair)force;
            if (IsEqv.apply(x, pair.getCar())) {
                false = lst;
                break;
            }
            cdr = pair.getCdr();
        }
        return false;
    }
    
    public static Object member(final Object x, final Object list) {
        return member(x, list, Scheme.isEqual);
    }
    
    public static Object member(final Object x, final Object list, final Procedure test) {
        Object cdr = list;
        Object false;
        while (true) {
            final Object lst = cdr;
            final Object force = Promise.force(lst, Pair.class);
            if (!(force instanceof Pair)) {
                false = Boolean.FALSE;
                break;
            }
            final Pair pair = (Pair)force;
            if (KawaConvert.isTrue(test.apply2(x, pair.getCar()))) {
                false = lst;
                break;
            }
            cdr = pair.getCdr();
        }
        return false;
    }
    
    public static Object assq(final Object x, final Object list) {
        Object apply1 = list;
        while (true) {
            final Object list2 = apply1;
            if (list2 == LList.Empty) {
                return Boolean.FALSE;
            }
            final Object force = Promise.force(lists.car.apply1(list2), Pair.class);
            try {
                final Pair pair = (Pair)force;
                if (pair.getCar() == x) {
                    return pair;
                }
                apply1 = lists.cdr.apply1(list2);
            }
            catch (ClassCastException ex) {
                throw new WrongType(ex, "pair", -2, force);
            }
        }
    }
    
    public static Object assv(final Object x, final Object list) {
        Object apply1 = list;
        while (true) {
            final Object list2 = apply1;
            if (list2 == LList.Empty) {
                return Boolean.FALSE;
            }
            final Object force = Promise.force(lists.car.apply1(list2), Pair.class);
            try {
                final Pair pair = (Pair)force;
                if (IsEqv.apply(pair.getCar(), x)) {
                    return pair;
                }
                apply1 = lists.cdr.apply1(list2);
            }
            catch (ClassCastException ex) {
                throw new WrongType(ex, "pair", -2, force);
            }
        }
    }
    
    public static Object assoc(final Object key, final Object list) {
        return assoc(key, list, Scheme.isEqual);
    }
    
    public static Object assoc(final Object key, final Object list, final Procedure test) {
        Object apply1 = list;
        while (true) {
            final Object list2 = apply1;
            if (list2 == LList.Empty) {
                return Boolean.FALSE;
            }
            final Object force = Promise.force(lists.car.apply1(list2), Pair.class);
            try {
                final Pair pair = (Pair)force;
                if (KawaConvert.isTrue(test.apply2(key, pair.getCar()))) {
                    return pair;
                }
                apply1 = lists.cdr.apply1(list2);
            }
            catch (ClassCastException ex) {
                throw new WrongType(ex, "pair", -2, force);
            }
        }
    }
    
    public static Object listCopy(final Object obj) {
        Pair prev = null;
        Object cdr = obj;
        while (true) {
            final Object x = cdr;
            Label_0065: {
                if (!isPair(x)) {
                    break Label_0065;
                }
                final Object force = Promise.force(x, Pair.class);
                try {
                    final Pair pold = (Pair)force;
                    final Pair pnew = cons(pold.getCar(), null);
                    if (prev == null) {
                        final Object result = pnew;
                    }
                    else {
                        setCdr$Ex(prev, pnew);
                    }
                    prev = pnew;
                    cdr = pold.getCdr();
                    continue;
                    // iftrue(Label_0074:, prev == null)
                    Object result = null;
                    Block_5: {
                        break Block_5;
                        Label_0074: {
                            return result;
                        }
                    }
                    setCdr$Ex(prev, x);
                    return result;
                }
                catch (ClassCastException ex) {
                    throw new WrongType(ex, "pold", -2, force);
                }
            }
        }
    }
    
    static {
        Lit19 = Symbol.valueOf("list-copy");
        Lit18 = Symbol.valueOf("assoc");
        Lit17 = Symbol.valueOf("assv");
        Lit16 = Symbol.valueOf("assq");
        Lit15 = Symbol.valueOf("member");
        Lit14 = Symbol.valueOf("memv");
        Lit13 = Symbol.valueOf("memq");
        Lit12 = Symbol.valueOf("reverse!");
        Lit11 = Symbol.valueOf("make-list");
        Lit10 = Symbol.valueOf("list?");
        Lit9 = Symbol.valueOf("list-set!");
        Lit8 = Symbol.valueOf("list-tail");
        Lit7 = Symbol.valueOf("reverse");
        Lit6 = Symbol.valueOf("length");
        Lit5 = Symbol.valueOf("set-cdr!");
        Lit4 = Symbol.valueOf("set-car!");
        Lit3 = Symbol.valueOf("null?");
        Lit2 = Symbol.valueOf("cons");
        Lit1 = Symbol.valueOf("pair?");
        Lit0 = Keyword.make("setter");
        lists.$instance = new lists();
        $Prvt$define$Mnprocedure = StaticFieldLocation.make("kawa.lib.std_syntax", "define$Mnprocedure");
        final lists $instance2 = lists.$instance;
        pair$Qu = new ModuleMethod($instance2, 1, lists.Lit1, 4097);
        cons = new ModuleMethod($instance2, 2, lists.Lit2, 8194);
        null$Qu = new ModuleMethod($instance2, 3, lists.Lit3, 4097);
        set$Mncar$Ex = new ModuleMethod($instance2, 4, lists.Lit4, 8194);
        set$Mncdr$Ex = new ModuleMethod($instance2, 5, lists.Lit5, 8194);
        final GenericProc car2 = new GenericProc("car");
        lists $instance = lists.$instance;
        final ModuleMethod method = new ModuleMethod($instance, 6, "car", 4097);
        method.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/lists.scm:31");
        car2.add(method);
        car = car2;
        final GenericProc cdr2 = new GenericProc("cdr");
        $instance = lists.$instance;
        final ModuleMethod method2 = new ModuleMethod($instance, 7, "cdr", 4097);
        method2.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/lists.scm:36");
        cdr2.add(method2);
        cdr = cdr2;
        final GenericProc caar2 = new GenericProc("caar");
        $instance = lists.$instance;
        caar2.add(new ModuleMethod($instance, 8, "caar", 4097));
        caar = caar2;
        lambda$Fn1 = new ModuleMethod($instance2, 9, null, 8194);
        final GenericProc cadr2 = new GenericProc("cadr");
        $instance = lists.$instance;
        cadr2.add(new ModuleMethod($instance, 10, "cadr", 4097));
        cadr = cadr2;
        lambda$Fn2 = new ModuleMethod($instance2, 11, null, 8194);
        final GenericProc cdar2 = new GenericProc("cdar");
        $instance = lists.$instance;
        cdar2.add(new ModuleMethod($instance, 12, "cdar", 4097));
        cdar = cdar2;
        lambda$Fn3 = new ModuleMethod($instance2, 13, null, 8194);
        final GenericProc cddr2 = new GenericProc("cddr");
        $instance = lists.$instance;
        cddr2.add(new ModuleMethod($instance, 14, "cddr", 4097));
        cddr = cddr2;
        lambda$Fn4 = new ModuleMethod($instance2, 15, null, 8194);
        final GenericProc caaar2 = new GenericProc("caaar");
        $instance = lists.$instance;
        caaar2.add(new ModuleMethod($instance, 16, "caaar", 4097));
        caaar = caaar2;
        lambda$Fn5 = new ModuleMethod($instance2, 17, null, 8194);
        final GenericProc caadr2 = new GenericProc("caadr");
        $instance = lists.$instance;
        caadr2.add(new ModuleMethod($instance, 18, "caadr", 4097));
        caadr = caadr2;
        lambda$Fn6 = new ModuleMethod($instance2, 19, null, 8194);
        final GenericProc cadar2 = new GenericProc("cadar");
        $instance = lists.$instance;
        cadar2.add(new ModuleMethod($instance, 20, "cadar", 4097));
        cadar = cadar2;
        lambda$Fn7 = new ModuleMethod($instance2, 21, null, 8194);
        final GenericProc caddr2 = new GenericProc("caddr");
        $instance = lists.$instance;
        caddr2.add(new ModuleMethod($instance, 22, "caddr", 4097));
        caddr = caddr2;
        lambda$Fn8 = new ModuleMethod($instance2, 23, null, 8194);
        final GenericProc cdaar2 = new GenericProc("cdaar");
        $instance = lists.$instance;
        cdaar2.add(new ModuleMethod($instance, 24, "cdaar", 4097));
        cdaar = cdaar2;
        lambda$Fn9 = new ModuleMethod($instance2, 25, null, 8194);
        final GenericProc cdadr2 = new GenericProc("cdadr");
        $instance = lists.$instance;
        cdadr2.add(new ModuleMethod($instance, 26, "cdadr", 4097));
        cdadr = cdadr2;
        lambda$Fn10 = new ModuleMethod($instance2, 27, null, 8194);
        final GenericProc cddar2 = new GenericProc("cddar");
        $instance = lists.$instance;
        cddar2.add(new ModuleMethod($instance, 28, "cddar", 4097));
        cddar = cddar2;
        lambda$Fn11 = new ModuleMethod($instance2, 29, null, 8194);
        final GenericProc cdddr2 = new GenericProc("cdddr");
        $instance = lists.$instance;
        cdddr2.add(new ModuleMethod($instance, 30, "cdddr", 4097));
        cdddr = cdddr2;
        lambda$Fn12 = new ModuleMethod($instance2, 31, null, 8194);
        final GenericProc caaaar2 = new GenericProc("caaaar");
        $instance = lists.$instance;
        caaaar2.add(new ModuleMethod($instance, 32, "caaaar", 4097));
        caaaar = caaaar2;
        lambda$Fn13 = new ModuleMethod($instance2, 33, null, 8194);
        final GenericProc caaadr2 = new GenericProc("caaadr");
        $instance = lists.$instance;
        caaadr2.add(new ModuleMethod($instance, 34, "caaadr", 4097));
        caaadr = caaadr2;
        lambda$Fn14 = new ModuleMethod($instance2, 35, null, 8194);
        final GenericProc caadar2 = new GenericProc("caadar");
        $instance = lists.$instance;
        caadar2.add(new ModuleMethod($instance, 36, "caadar", 4097));
        caadar = caadar2;
        lambda$Fn15 = new ModuleMethod($instance2, 37, null, 8194);
        final GenericProc caaddr2 = new GenericProc("caaddr");
        $instance = lists.$instance;
        caaddr2.add(new ModuleMethod($instance, 38, "caaddr", 4097));
        caaddr = caaddr2;
        lambda$Fn16 = new ModuleMethod($instance2, 39, null, 8194);
        final GenericProc cadaar2 = new GenericProc("cadaar");
        $instance = lists.$instance;
        cadaar2.add(new ModuleMethod($instance, 40, "cadaar", 4097));
        cadaar = cadaar2;
        lambda$Fn17 = new ModuleMethod($instance2, 41, null, 8194);
        final GenericProc cadadr2 = new GenericProc("cadadr");
        $instance = lists.$instance;
        cadadr2.add(new ModuleMethod($instance, 42, "cadadr", 4097));
        cadadr = cadadr2;
        lambda$Fn18 = new ModuleMethod($instance2, 43, null, 8194);
        final GenericProc caddar2 = new GenericProc("caddar");
        $instance = lists.$instance;
        caddar2.add(new ModuleMethod($instance, 44, "caddar", 4097));
        caddar = caddar2;
        lambda$Fn19 = new ModuleMethod($instance2, 45, null, 8194);
        final GenericProc cadddr2 = new GenericProc("cadddr");
        $instance = lists.$instance;
        cadddr2.add(new ModuleMethod($instance, 46, "cadddr", 4097));
        cadddr = cadddr2;
        lambda$Fn20 = new ModuleMethod($instance2, 47, null, 8194);
        final GenericProc cdaaar2 = new GenericProc("cdaaar");
        $instance = lists.$instance;
        cdaaar2.add(new ModuleMethod($instance, 48, "cdaaar", 4097));
        cdaaar = cdaaar2;
        lambda$Fn21 = new ModuleMethod($instance2, 49, null, 8194);
        final GenericProc cdaadr2 = new GenericProc("cdaadr");
        $instance = lists.$instance;
        cdaadr2.add(new ModuleMethod($instance, 50, "cdaadr", 4097));
        cdaadr = cdaadr2;
        lambda$Fn22 = new ModuleMethod($instance2, 51, null, 8194);
        final GenericProc cdadar2 = new GenericProc("cdadar");
        $instance = lists.$instance;
        cdadar2.add(new ModuleMethod($instance, 52, "cdadar", 4097));
        cdadar = cdadar2;
        lambda$Fn23 = new ModuleMethod($instance2, 53, null, 8194);
        final GenericProc cdaddr2 = new GenericProc("cdaddr");
        $instance = lists.$instance;
        cdaddr2.add(new ModuleMethod($instance, 54, "cdaddr", 4097));
        cdaddr = cdaddr2;
        lambda$Fn24 = new ModuleMethod($instance2, 55, null, 8194);
        final GenericProc cddaar2 = new GenericProc("cddaar");
        $instance = lists.$instance;
        cddaar2.add(new ModuleMethod($instance, 56, "cddaar", 4097));
        cddaar = cddaar2;
        lambda$Fn25 = new ModuleMethod($instance2, 57, null, 8194);
        final GenericProc cddadr2 = new GenericProc("cddadr");
        $instance = lists.$instance;
        cddadr2.add(new ModuleMethod($instance, 58, "cddadr", 4097));
        cddadr = cddadr2;
        lambda$Fn26 = new ModuleMethod($instance2, 59, null, 8194);
        final GenericProc cdddar2 = new GenericProc("cdddar");
        $instance = lists.$instance;
        cdddar2.add(new ModuleMethod($instance, 60, "cdddar", 4097));
        cdddar = cdddar2;
        lambda$Fn27 = new ModuleMethod($instance2, 61, null, 8194);
        final GenericProc cddddr2 = new GenericProc("cddddr");
        $instance = lists.$instance;
        cddddr2.add(new ModuleMethod($instance, 62, "cddddr", 4097));
        cddddr = cddddr2;
        lambda$Fn28 = new ModuleMethod($instance2, 63, null, 8194);
        final ModuleMethod length2 = new ModuleMethod($instance2, 64, lists.Lit6, 4097);
        length2.setProperty(Procedure.validateApplyKey, "kawa.lib.compile_misc:lengthValidateApply");
        length = length2;
        reverse = new ModuleMethod($instance2, 65, lists.Lit7, 4097);
        list$Mntail = new ModuleMethod($instance2, 66, lists.Lit8, 8194);
        list$Mnset$Ex = new ModuleMethod($instance2, 67, lists.Lit9, 12291);
        final GenericProc list$Mnref2 = new GenericProc("list-ref");
        $instance = lists.$instance;
        final ModuleMethod method3 = new ModuleMethod($instance, 68, "list-ref", 8194);
        method3.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/lists.scm:121");
        list$Mnref2.add(method3);
        list$Mnref = list$Mnref2;
        list$Qu = new ModuleMethod($instance2, 69, lists.Lit10, 4097);
        make$Mnlist = new ModuleMethod($instance2, 70, lists.Lit11, 8193);
        reverse$Ex = new ModuleMethod($instance2, 72, lists.Lit12, 4097);
        memq = new ModuleMethod($instance2, 73, lists.Lit13, 8194);
        memv = new ModuleMethod($instance2, 74, lists.Lit14, 8194);
        member = new ModuleMethod($instance2, 75, lists.Lit15, 12290);
        assq = new ModuleMethod($instance2, 77, lists.Lit16, 8194);
        assv = new ModuleMethod($instance2, 78, lists.Lit17, 8194);
        assoc = new ModuleMethod($instance2, 79, lists.Lit18, 12290);
        list$Mncopy = new ModuleMethod($instance2, 81, lists.Lit19, 4097);
        $runBody$();
    }
    
    public lists() {
        ModuleInfo.register(this);
    }
    
    public static Object car(final Pair x) {
        return x.getCar();
    }
    
    public static Object cdr(final Pair x) {
        return x.getCdr();
    }
    
    public static Object caar(final Object arg) {
        return ((Pair)Promise.force(((Pair)Promise.force(arg, Pair.class)).getCar(), Pair.class)).getCar();
    }
    
    public static Object cadr(final Object arg) {
        return ((Pair)Promise.force(((Pair)Promise.force(arg, Pair.class)).getCdr(), Pair.class)).getCar();
    }
    
    public static Object cdar(final Object arg) {
        return ((Pair)Promise.force(((Pair)Promise.force(arg, Pair.class)).getCar(), Pair.class)).getCdr();
    }
    
    public static Object cddr(final Object arg) {
        return ((Pair)Promise.force(((Pair)Promise.force(arg, Pair.class)).getCdr(), Pair.class)).getCdr();
    }
    
    public static Object caaar(final Object arg) {
        return ((Pair)Promise.force(((Pair)Promise.force(((Pair)Promise.force(arg, Pair.class)).getCar(), Pair.class)).getCar(), Pair.class)).getCar();
    }
    
    public static Object caadr(final Object arg) {
        return ((Pair)Promise.force(((Pair)Promise.force(((Pair)Promise.force(arg, Pair.class)).getCdr(), Pair.class)).getCar(), Pair.class)).getCar();
    }
    
    public static Object cadar(final Object arg) {
        return ((Pair)Promise.force(((Pair)Promise.force(((Pair)Promise.force(arg, Pair.class)).getCar(), Pair.class)).getCdr(), Pair.class)).getCar();
    }
    
    public static Object caddr(final Object arg) {
        return ((Pair)Promise.force(((Pair)Promise.force(((Pair)Promise.force(arg, Pair.class)).getCdr(), Pair.class)).getCdr(), Pair.class)).getCar();
    }
    
    public static Object cdaar(final Object arg) {
        return ((Pair)Promise.force(((Pair)Promise.force(((Pair)Promise.force(arg, Pair.class)).getCar(), Pair.class)).getCar(), Pair.class)).getCdr();
    }
    
    public static Object cdadr(final Object arg) {
        return ((Pair)Promise.force(((Pair)Promise.force(((Pair)Promise.force(arg, Pair.class)).getCdr(), Pair.class)).getCar(), Pair.class)).getCdr();
    }
    
    public static Object cddar(final Object arg) {
        return ((Pair)Promise.force(((Pair)Promise.force(((Pair)Promise.force(arg, Pair.class)).getCar(), Pair.class)).getCdr(), Pair.class)).getCdr();
    }
    
    public static Object cdddr(final Object arg) {
        return ((Pair)Promise.force(((Pair)Promise.force(((Pair)Promise.force(arg, Pair.class)).getCdr(), Pair.class)).getCdr(), Pair.class)).getCdr();
    }
    
    public static Object caaaar(final Object arg) {
        return ((Pair)Promise.force(((Pair)Promise.force(((Pair)Promise.force(((Pair)Promise.force(arg, Pair.class)).getCar(), Pair.class)).getCar(), Pair.class)).getCar(), Pair.class)).getCar();
    }
    
    public static Object caaadr(final Object arg) {
        return ((Pair)Promise.force(((Pair)Promise.force(((Pair)Promise.force(((Pair)Promise.force(arg, Pair.class)).getCdr(), Pair.class)).getCar(), Pair.class)).getCar(), Pair.class)).getCar();
    }
    
    public static Object caadar(final Object arg) {
        return ((Pair)Promise.force(((Pair)Promise.force(((Pair)Promise.force(((Pair)Promise.force(arg, Pair.class)).getCar(), Pair.class)).getCdr(), Pair.class)).getCar(), Pair.class)).getCar();
    }
    
    public static Object caaddr(final Object arg) {
        return ((Pair)Promise.force(((Pair)Promise.force(((Pair)Promise.force(((Pair)Promise.force(arg, Pair.class)).getCdr(), Pair.class)).getCdr(), Pair.class)).getCar(), Pair.class)).getCar();
    }
    
    public static Object cadaar(final Object arg) {
        return ((Pair)Promise.force(((Pair)Promise.force(((Pair)Promise.force(((Pair)Promise.force(arg, Pair.class)).getCar(), Pair.class)).getCar(), Pair.class)).getCdr(), Pair.class)).getCar();
    }
    
    public static Object cadadr(final Object arg) {
        return ((Pair)Promise.force(((Pair)Promise.force(((Pair)Promise.force(((Pair)Promise.force(arg, Pair.class)).getCdr(), Pair.class)).getCar(), Pair.class)).getCdr(), Pair.class)).getCar();
    }
    
    public static Object caddar(final Object arg) {
        return ((Pair)Promise.force(((Pair)Promise.force(((Pair)Promise.force(((Pair)Promise.force(arg, Pair.class)).getCar(), Pair.class)).getCdr(), Pair.class)).getCdr(), Pair.class)).getCar();
    }
    
    public static Object cadddr(final Object arg) {
        return ((Pair)Promise.force(((Pair)Promise.force(((Pair)Promise.force(((Pair)Promise.force(arg, Pair.class)).getCdr(), Pair.class)).getCdr(), Pair.class)).getCdr(), Pair.class)).getCar();
    }
    
    public static Object cdaaar(final Object arg) {
        return ((Pair)Promise.force(((Pair)Promise.force(((Pair)Promise.force(((Pair)Promise.force(arg, Pair.class)).getCar(), Pair.class)).getCar(), Pair.class)).getCar(), Pair.class)).getCdr();
    }
    
    public static Object cdaadr(final Object arg) {
        return ((Pair)Promise.force(((Pair)Promise.force(((Pair)Promise.force(((Pair)Promise.force(arg, Pair.class)).getCdr(), Pair.class)).getCar(), Pair.class)).getCar(), Pair.class)).getCdr();
    }
    
    public static Object cdadar(final Object arg) {
        return ((Pair)Promise.force(((Pair)Promise.force(((Pair)Promise.force(((Pair)Promise.force(arg, Pair.class)).getCar(), Pair.class)).getCdr(), Pair.class)).getCar(), Pair.class)).getCdr();
    }
    
    public static Object cdaddr(final Object arg) {
        return ((Pair)Promise.force(((Pair)Promise.force(((Pair)Promise.force(((Pair)Promise.force(arg, Pair.class)).getCdr(), Pair.class)).getCdr(), Pair.class)).getCar(), Pair.class)).getCdr();
    }
    
    public static Object cddaar(final Object arg) {
        return ((Pair)Promise.force(((Pair)Promise.force(((Pair)Promise.force(((Pair)Promise.force(arg, Pair.class)).getCar(), Pair.class)).getCar(), Pair.class)).getCdr(), Pair.class)).getCdr();
    }
    
    public static Object cddadr(final Object arg) {
        return ((Pair)Promise.force(((Pair)Promise.force(((Pair)Promise.force(((Pair)Promise.force(arg, Pair.class)).getCdr(), Pair.class)).getCar(), Pair.class)).getCdr(), Pair.class)).getCdr();
    }
    
    public static Object cdddar(final Object arg) {
        return ((Pair)Promise.force(((Pair)Promise.force(((Pair)Promise.force(((Pair)Promise.force(arg, Pair.class)).getCar(), Pair.class)).getCdr(), Pair.class)).getCdr(), Pair.class)).getCdr();
    }
    
    public static Object cddddr(final Object arg) {
        return ((Pair)Promise.force(((Pair)Promise.force(((Pair)Promise.force(((Pair)Promise.force(arg, Pair.class)).getCdr(), Pair.class)).getCdr(), Pair.class)).getCdr(), Pair.class)).getCdr();
    }
    
    public static Object listRef(final Object list, final int index) {
        return lists.car.apply1(listTail(list, index));
    }
    
    @Override
    public int match1(final ModuleMethod proc, final Object arg1, final CallContext ctx) {
        switch (proc.selector) {
            case 62: {
                ctx.value1 = arg1;
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 60: {
                ctx.value1 = arg1;
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 58: {
                ctx.value1 = arg1;
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 56: {
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
            case 52: {
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
            case 48: {
                ctx.value1 = arg1;
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 46: {
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
            case 42: {
                ctx.value1 = arg1;
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 40: {
                ctx.value1 = arg1;
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 38: {
                ctx.value1 = arg1;
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 36: {
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
            case 32: {
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
            case 28: {
                ctx.value1 = arg1;
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 26: {
                ctx.value1 = arg1;
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 24: {
                ctx.value1 = arg1;
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 22: {
                ctx.value1 = arg1;
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 20: {
                ctx.value1 = arg1;
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 18: {
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
            case 14: {
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
            case 10: {
                ctx.value1 = arg1;
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 8: {
                ctx.value1 = arg1;
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 7: {
                final Object force = Promise.force(arg1, Pair.class);
                if (!(force instanceof Pair)) {
                    return -786431;
                }
                ctx.value1 = force;
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 6: {
                final Object force2 = Promise.force(arg1, Pair.class);
                if (!(force2 instanceof Pair)) {
                    return -786431;
                }
                ctx.value1 = force2;
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 81: {
                ctx.value1 = arg1;
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 72: {
                final Object force3 = Promise.force(arg1, LList.class);
                if (force3 instanceof LList) {
                    ctx.value1 = force3;
                    ctx.proc = proc;
                    ctx.pc = 1;
                    return 0;
                }
                return -786431;
            }
            case 70: {
                ctx.value1 = Promise.force(arg1);
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
            case 65: {
                final Object force4 = Promise.force(arg1, LList.class);
                if (force4 instanceof LList) {
                    ctx.value1 = force4;
                    ctx.proc = proc;
                    ctx.pc = 1;
                    return 0;
                }
                return -786431;
            }
            case 64: {
                final Object force5 = Promise.force(arg1, List.class);
                if (Sequences.asSequenceOrNull(force5) != null) {
                    ctx.value1 = force5;
                    ctx.proc = proc;
                    ctx.pc = 1;
                    return 0;
                }
                return -786431;
            }
            case 3: {
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
    public int match2(final ModuleMethod proc, final Object arg1, final Object arg2, final CallContext ctx) {
        switch (proc.selector) {
            case 68: {
                ctx.value1 = arg1;
                ctx.value2 = Promise.force(arg2);
                ctx.proc = proc;
                ctx.pc = 2;
                return 0;
            }
            case 79: {
                ctx.value1 = arg1;
                ctx.value2 = arg2;
                ctx.proc = proc;
                ctx.pc = 2;
                return 0;
            }
            case 78: {
                ctx.value1 = arg1;
                ctx.value2 = arg2;
                ctx.proc = proc;
                ctx.pc = 2;
                return 0;
            }
            case 77: {
                ctx.value1 = arg1;
                ctx.value2 = arg2;
                ctx.proc = proc;
                ctx.pc = 2;
                return 0;
            }
            case 75: {
                ctx.value1 = arg1;
                ctx.value2 = arg2;
                ctx.proc = proc;
                ctx.pc = 2;
                return 0;
            }
            case 74: {
                ctx.value1 = arg1;
                ctx.value2 = arg2;
                ctx.proc = proc;
                ctx.pc = 2;
                return 0;
            }
            case 73: {
                ctx.value1 = arg1;
                ctx.value2 = arg2;
                ctx.proc = proc;
                ctx.pc = 2;
                return 0;
            }
            case 70: {
                ctx.value1 = Promise.force(arg1);
                ctx.value2 = arg2;
                ctx.proc = proc;
                ctx.pc = 2;
                return 0;
            }
            case 66: {
                ctx.value1 = arg1;
                ctx.value2 = Promise.force(arg2);
                ctx.proc = proc;
                ctx.pc = 2;
                return 0;
            }
            case 63: {
                ctx.value1 = arg1;
                ctx.value2 = arg2;
                ctx.proc = proc;
                ctx.pc = 2;
                return 0;
            }
            case 61: {
                ctx.value1 = arg1;
                ctx.value2 = arg2;
                ctx.proc = proc;
                ctx.pc = 2;
                return 0;
            }
            case 59: {
                ctx.value1 = arg1;
                ctx.value2 = arg2;
                ctx.proc = proc;
                ctx.pc = 2;
                return 0;
            }
            case 57: {
                ctx.value1 = arg1;
                ctx.value2 = arg2;
                ctx.proc = proc;
                ctx.pc = 2;
                return 0;
            }
            case 55: {
                ctx.value1 = arg1;
                ctx.value2 = arg2;
                ctx.proc = proc;
                ctx.pc = 2;
                return 0;
            }
            case 53: {
                ctx.value1 = arg1;
                ctx.value2 = arg2;
                ctx.proc = proc;
                ctx.pc = 2;
                return 0;
            }
            case 51: {
                ctx.value1 = arg1;
                ctx.value2 = arg2;
                ctx.proc = proc;
                ctx.pc = 2;
                return 0;
            }
            case 49: {
                ctx.value1 = arg1;
                ctx.value2 = arg2;
                ctx.proc = proc;
                ctx.pc = 2;
                return 0;
            }
            case 47: {
                ctx.value1 = arg1;
                ctx.value2 = arg2;
                ctx.proc = proc;
                ctx.pc = 2;
                return 0;
            }
            case 45: {
                ctx.value1 = arg1;
                ctx.value2 = arg2;
                ctx.proc = proc;
                ctx.pc = 2;
                return 0;
            }
            case 43: {
                ctx.value1 = arg1;
                ctx.value2 = arg2;
                ctx.proc = proc;
                ctx.pc = 2;
                return 0;
            }
            case 41: {
                ctx.value1 = arg1;
                ctx.value2 = arg2;
                ctx.proc = proc;
                ctx.pc = 2;
                return 0;
            }
            case 39: {
                ctx.value1 = arg1;
                ctx.value2 = arg2;
                ctx.proc = proc;
                ctx.pc = 2;
                return 0;
            }
            case 37: {
                ctx.value1 = arg1;
                ctx.value2 = arg2;
                ctx.proc = proc;
                ctx.pc = 2;
                return 0;
            }
            case 35: {
                ctx.value1 = arg1;
                ctx.value2 = arg2;
                ctx.proc = proc;
                ctx.pc = 2;
                return 0;
            }
            case 33: {
                ctx.value1 = arg1;
                ctx.value2 = arg2;
                ctx.proc = proc;
                ctx.pc = 2;
                return 0;
            }
            case 31: {
                ctx.value1 = arg1;
                ctx.value2 = arg2;
                ctx.proc = proc;
                ctx.pc = 2;
                return 0;
            }
            case 29: {
                ctx.value1 = arg1;
                ctx.value2 = arg2;
                ctx.proc = proc;
                ctx.pc = 2;
                return 0;
            }
            case 27: {
                ctx.value1 = arg1;
                ctx.value2 = arg2;
                ctx.proc = proc;
                ctx.pc = 2;
                return 0;
            }
            case 25: {
                ctx.value1 = arg1;
                ctx.value2 = arg2;
                ctx.proc = proc;
                ctx.pc = 2;
                return 0;
            }
            case 23: {
                ctx.value1 = arg1;
                ctx.value2 = arg2;
                ctx.proc = proc;
                ctx.pc = 2;
                return 0;
            }
            case 21: {
                ctx.value1 = arg1;
                ctx.value2 = arg2;
                ctx.proc = proc;
                ctx.pc = 2;
                return 0;
            }
            case 19: {
                ctx.value1 = arg1;
                ctx.value2 = arg2;
                ctx.proc = proc;
                ctx.pc = 2;
                return 0;
            }
            case 17: {
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
            case 13: {
                ctx.value1 = arg1;
                ctx.value2 = arg2;
                ctx.proc = proc;
                ctx.pc = 2;
                return 0;
            }
            case 11: {
                ctx.value1 = arg1;
                ctx.value2 = arg2;
                ctx.proc = proc;
                ctx.pc = 2;
                return 0;
            }
            case 9: {
                ctx.value1 = arg1;
                ctx.value2 = arg2;
                ctx.proc = proc;
                ctx.pc = 2;
                return 0;
            }
            case 5: {
                final Object force = Promise.force(arg1, Pair.class);
                if (!(force instanceof Pair)) {
                    return -786431;
                }
                ctx.value1 = force;
                ctx.value2 = arg2;
                ctx.proc = proc;
                ctx.pc = 2;
                return 0;
            }
            case 4: {
                final Object force2 = Promise.force(arg1, Pair.class);
                if (!(force2 instanceof Pair)) {
                    return -786431;
                }
                ctx.value1 = force2;
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
    public int match3(final ModuleMethod moduleMethod, final Object o, final Object o2, final Object o3, final CallContext ctx) {
        switch (moduleMethod.selector) {
            case 79: {
                ctx.value1 = o;
                ctx.value2 = o2;
                final Object force = Promise.force(o3, Procedure.class);
                if (LangObjType.coerceToProcedureOrNull(force) != null) {
                    ctx.value3 = force;
                    ctx.proc = moduleMethod;
                    ctx.pc = 3;
                    return 0;
                }
                return -786429;
            }
            case 75: {
                ctx.value1 = o;
                ctx.value2 = o2;
                final Object force2 = Promise.force(o3, Procedure.class);
                if (LangObjType.coerceToProcedureOrNull(force2) != null) {
                    ctx.value3 = force2;
                    ctx.proc = moduleMethod;
                    ctx.pc = 3;
                    return 0;
                }
                return -786429;
            }
            case 67: {
                ctx.value1 = o;
                ctx.value2 = Promise.force(o2);
                ctx.value3 = o3;
                ctx.proc = moduleMethod;
                ctx.pc = 3;
                return 0;
            }
            default: {
                return super.match3(moduleMethod, o, o2, o3, ctx);
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
        //                1: 320
        //                3: 337
        //                6: 432
        //                7: 445
        //                8: 458
        //               10: 463
        //               12: 468
        //               14: 473
        //               16: 478
        //               18: 483
        //               20: 488
        //               22: 493
        //               24: 498
        //               26: 503
        //               28: 508
        //               30: 513
        //               32: 518
        //               34: 523
        //               36: 528
        //               38: 533
        //               40: 538
        //               42: 543
        //               44: 548
        //               46: 553
        //               48: 558
        //               50: 563
        //               52: 568
        //               54: 573
        //               56: 578
        //               58: 583
        //               60: 588
        //               62: 593
        //               64: 354
        //               65: 370
        //               69: 383
        //               70: 400
        //               72: 414
        //               81: 427
        //          default: 598
        //        }
        //   320: aload_2        
        //   321: invokestatic    kawa/lib/lists.isPair:(Ljava/lang/Object;)Z
        //   324: ifeq            333
        //   327: getstatic       java/lang/Boolean.TRUE:Ljava/lang/Boolean;
        //   330: goto            336
        //   333: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //   336: areturn        
        //   337: aload_2        
        //   338: invokestatic    kawa/lib/lists.isNull:(Ljava/lang/Object;)Z
        //   341: ifeq            350
        //   344: getstatic       java/lang/Boolean.TRUE:Ljava/lang/Boolean;
        //   347: goto            353
        //   350: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //   353: areturn        
        //   354: aload_2        
        //   355: ldc             Ljava/util/List;.class
        //   357: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   360: invokestatic    gnu/lists/Sequences.coerceToSequence:(Ljava/lang/Object;)Ljava/util/List;
        //   363: invokestatic    kawa/lib/lists.length:(Ljava/util/List;)I
        //   366: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //   369: areturn        
        //   370: aload_2        
        //   371: ldc             Lgnu/lists/LList;.class
        //   373: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   376: checkcast       Lgnu/lists/LList;
        //   379: invokestatic    kawa/lib/lists.reverse:(Lgnu/lists/LList;)Lgnu/lists/LList;
        //   382: areturn        
        //   383: aload_2        
        //   384: invokestatic    kawa/lib/lists.isList:(Ljava/lang/Object;)Z
        //   387: ifeq            396
        //   390: getstatic       java/lang/Boolean.TRUE:Ljava/lang/Boolean;
        //   393: goto            399
        //   396: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //   399: areturn        
        //   400: aload_2        
        //   401: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   404: checkcast       Ljava/lang/Number;
        //   407: invokevirtual   java/lang/Number.intValue:()I
        //   410: invokestatic    kawa/lib/lists.makeList:(I)Lgnu/lists/LList;
        //   413: areturn        
        //   414: aload_2        
        //   415: ldc             Lgnu/lists/LList;.class
        //   417: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   420: checkcast       Lgnu/lists/LList;
        //   423: invokestatic    kawa/lib/lists.reverse$Ex:(Lgnu/lists/LList;)Lgnu/lists/LList;
        //   426: areturn        
        //   427: aload_2        
        //   428: invokestatic    kawa/lib/lists.listCopy:(Ljava/lang/Object;)Ljava/lang/Object;
        //   431: areturn        
        //   432: aload_2        
        //   433: ldc             Lgnu/lists/Pair;.class
        //   435: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   438: checkcast       Lgnu/lists/Pair;
        //   441: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   444: areturn        
        //   445: aload_2        
        //   446: ldc             Lgnu/lists/Pair;.class
        //   448: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   451: checkcast       Lgnu/lists/Pair;
        //   454: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   457: areturn        
        //   458: aload_2        
        //   459: invokestatic    kawa/lib/lists.caar:(Ljava/lang/Object;)Ljava/lang/Object;
        //   462: areturn        
        //   463: aload_2        
        //   464: invokestatic    kawa/lib/lists.cadr:(Ljava/lang/Object;)Ljava/lang/Object;
        //   467: areturn        
        //   468: aload_2        
        //   469: invokestatic    kawa/lib/lists.cdar:(Ljava/lang/Object;)Ljava/lang/Object;
        //   472: areturn        
        //   473: aload_2        
        //   474: invokestatic    kawa/lib/lists.cddr:(Ljava/lang/Object;)Ljava/lang/Object;
        //   477: areturn        
        //   478: aload_2        
        //   479: invokestatic    kawa/lib/lists.caaar:(Ljava/lang/Object;)Ljava/lang/Object;
        //   482: areturn        
        //   483: aload_2        
        //   484: invokestatic    kawa/lib/lists.caadr:(Ljava/lang/Object;)Ljava/lang/Object;
        //   487: areturn        
        //   488: aload_2        
        //   489: invokestatic    kawa/lib/lists.cadar:(Ljava/lang/Object;)Ljava/lang/Object;
        //   492: areturn        
        //   493: aload_2        
        //   494: invokestatic    kawa/lib/lists.caddr:(Ljava/lang/Object;)Ljava/lang/Object;
        //   497: areturn        
        //   498: aload_2        
        //   499: invokestatic    kawa/lib/lists.cdaar:(Ljava/lang/Object;)Ljava/lang/Object;
        //   502: areturn        
        //   503: aload_2        
        //   504: invokestatic    kawa/lib/lists.cdadr:(Ljava/lang/Object;)Ljava/lang/Object;
        //   507: areturn        
        //   508: aload_2        
        //   509: invokestatic    kawa/lib/lists.cddar:(Ljava/lang/Object;)Ljava/lang/Object;
        //   512: areturn        
        //   513: aload_2        
        //   514: invokestatic    kawa/lib/lists.cdddr:(Ljava/lang/Object;)Ljava/lang/Object;
        //   517: areturn        
        //   518: aload_2        
        //   519: invokestatic    kawa/lib/lists.caaaar:(Ljava/lang/Object;)Ljava/lang/Object;
        //   522: areturn        
        //   523: aload_2        
        //   524: invokestatic    kawa/lib/lists.caaadr:(Ljava/lang/Object;)Ljava/lang/Object;
        //   527: areturn        
        //   528: aload_2        
        //   529: invokestatic    kawa/lib/lists.caadar:(Ljava/lang/Object;)Ljava/lang/Object;
        //   532: areturn        
        //   533: aload_2        
        //   534: invokestatic    kawa/lib/lists.caaddr:(Ljava/lang/Object;)Ljava/lang/Object;
        //   537: areturn        
        //   538: aload_2        
        //   539: invokestatic    kawa/lib/lists.cadaar:(Ljava/lang/Object;)Ljava/lang/Object;
        //   542: areturn        
        //   543: aload_2        
        //   544: invokestatic    kawa/lib/lists.cadadr:(Ljava/lang/Object;)Ljava/lang/Object;
        //   547: areturn        
        //   548: aload_2        
        //   549: invokestatic    kawa/lib/lists.caddar:(Ljava/lang/Object;)Ljava/lang/Object;
        //   552: areturn        
        //   553: aload_2        
        //   554: invokestatic    kawa/lib/lists.cadddr:(Ljava/lang/Object;)Ljava/lang/Object;
        //   557: areturn        
        //   558: aload_2        
        //   559: invokestatic    kawa/lib/lists.cdaaar:(Ljava/lang/Object;)Ljava/lang/Object;
        //   562: areturn        
        //   563: aload_2        
        //   564: invokestatic    kawa/lib/lists.cdaadr:(Ljava/lang/Object;)Ljava/lang/Object;
        //   567: areturn        
        //   568: aload_2        
        //   569: invokestatic    kawa/lib/lists.cdadar:(Ljava/lang/Object;)Ljava/lang/Object;
        //   572: areturn        
        //   573: aload_2        
        //   574: invokestatic    kawa/lib/lists.cdaddr:(Ljava/lang/Object;)Ljava/lang/Object;
        //   577: areturn        
        //   578: aload_2        
        //   579: invokestatic    kawa/lib/lists.cddaar:(Ljava/lang/Object;)Ljava/lang/Object;
        //   582: areturn        
        //   583: aload_2        
        //   584: invokestatic    kawa/lib/lists.cddadr:(Ljava/lang/Object;)Ljava/lang/Object;
        //   587: areturn        
        //   588: aload_2        
        //   589: invokestatic    kawa/lib/lists.cdddar:(Ljava/lang/Object;)Ljava/lang/Object;
        //   592: areturn        
        //   593: aload_2        
        //   594: invokestatic    kawa/lib/lists.cddddr:(Ljava/lang/Object;)Ljava/lang/Object;
        //   597: areturn        
        //   598: aload_0        
        //   599: aload_1        
        //   600: aload_2        
        //   601: invokespecial   gnu/expr/ModuleBody.apply1:(Lgnu/expr/ModuleMethod;Ljava/lang/Object;)Ljava/lang/Object;
        //   604: areturn        
        //   605: new             Lgnu/mapping/WrongType;
        //   608: dup_x1         
        //   609: swap           
        //   610: ldc_w           "length"
        //   613: iconst_1       
        //   614: aload_2        
        //   615: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   618: athrow         
        //   619: new             Lgnu/mapping/WrongType;
        //   622: dup_x1         
        //   623: swap           
        //   624: ldc_w           "reverse"
        //   627: iconst_1       
        //   628: aload_2        
        //   629: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   632: athrow         
        //   633: new             Lgnu/mapping/WrongType;
        //   636: dup_x1         
        //   637: swap           
        //   638: ldc_w           "make-list"
        //   641: iconst_1       
        //   642: aload_2        
        //   643: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   646: athrow         
        //   647: new             Lgnu/mapping/WrongType;
        //   650: dup_x1         
        //   651: swap           
        //   652: ldc_w           "reverse!"
        //   655: iconst_1       
        //   656: aload_2        
        //   657: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   660: athrow         
        //   661: new             Lgnu/mapping/WrongType;
        //   664: dup_x1         
        //   665: swap           
        //   666: ldc_w           "car"
        //   669: iconst_1       
        //   670: aload_2        
        //   671: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   674: athrow         
        //   675: new             Lgnu/mapping/WrongType;
        //   678: dup_x1         
        //   679: swap           
        //   680: ldc_w           "cdr"
        //   683: iconst_1       
        //   684: aload_2        
        //   685: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   688: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  360    363    605    619    Ljava/lang/ClassCastException;
        //  376    379    619    633    Ljava/lang/ClassCastException;
        //  404    410    633    647    Ljava/lang/ClassCastException;
        //  420    423    647    661    Ljava/lang/ClassCastException;
        //  438    441    661    675    Ljava/lang/ClassCastException;
        //  451    454    675    689    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 201 out of bounds for length 201
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
        //                4: 332
        //                5: 705
        //                6: 338
        //                7: 355
        //                8: 705
        //                9: 705
        //               10: 705
        //               11: 372
        //               12: 705
        //               13: 381
        //               14: 705
        //               15: 390
        //               16: 705
        //               17: 399
        //               18: 705
        //               19: 408
        //               20: 705
        //               21: 417
        //               22: 705
        //               23: 426
        //               24: 705
        //               25: 435
        //               26: 705
        //               27: 444
        //               28: 705
        //               29: 453
        //               30: 705
        //               31: 462
        //               32: 705
        //               33: 471
        //               34: 705
        //               35: 480
        //               36: 705
        //               37: 489
        //               38: 705
        //               39: 498
        //               40: 705
        //               41: 507
        //               42: 705
        //               43: 516
        //               44: 705
        //               45: 525
        //               46: 705
        //               47: 534
        //               48: 705
        //               49: 543
        //               50: 705
        //               51: 552
        //               52: 705
        //               53: 561
        //               54: 705
        //               55: 570
        //               56: 705
        //               57: 579
        //               58: 705
        //               59: 588
        //               60: 705
        //               61: 597
        //               62: 705
        //               63: 606
        //               64: 705
        //               65: 615
        //               66: 705
        //               67: 705
        //               68: 624
        //               69: 705
        //               70: 690
        //               71: 705
        //               72: 639
        //               73: 705
        //               74: 705
        //               75: 654
        //               76: 660
        //               77: 666
        //               78: 705
        //               79: 672
        //               80: 678
        //               81: 684
        //          default: 705
        //        }
        //   332: aload_2        
        //   333: aload_3        
        //   334: invokestatic    kawa/lib/lists.cons:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //   337: areturn        
        //   338: aload_2        
        //   339: ldc             Lgnu/lists/Pair;.class
        //   341: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   344: checkcast       Lgnu/lists/Pair;
        //   347: aload_3        
        //   348: invokestatic    kawa/lib/lists.setCar$Ex:(Lgnu/lists/Pair;Ljava/lang/Object;)V
        //   351: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //   354: areturn        
        //   355: aload_2        
        //   356: ldc             Lgnu/lists/Pair;.class
        //   358: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   361: checkcast       Lgnu/lists/Pair;
        //   364: aload_3        
        //   365: invokestatic    kawa/lib/lists.setCdr$Ex:(Lgnu/lists/Pair;Ljava/lang/Object;)V
        //   368: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //   371: areturn        
        //   372: aload_2        
        //   373: aload_3        
        //   374: invokestatic    kawa/lib/lists.lambda1:(Ljava/lang/Object;Ljava/lang/Object;)V
        //   377: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //   380: areturn        
        //   381: aload_2        
        //   382: aload_3        
        //   383: invokestatic    kawa/lib/lists.lambda2:(Ljava/lang/Object;Ljava/lang/Object;)V
        //   386: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //   389: areturn        
        //   390: aload_2        
        //   391: aload_3        
        //   392: invokestatic    kawa/lib/lists.lambda3:(Ljava/lang/Object;Ljava/lang/Object;)V
        //   395: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //   398: areturn        
        //   399: aload_2        
        //   400: aload_3        
        //   401: invokestatic    kawa/lib/lists.lambda4:(Ljava/lang/Object;Ljava/lang/Object;)V
        //   404: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //   407: areturn        
        //   408: aload_2        
        //   409: aload_3        
        //   410: invokestatic    kawa/lib/lists.lambda5:(Ljava/lang/Object;Ljava/lang/Object;)V
        //   413: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //   416: areturn        
        //   417: aload_2        
        //   418: aload_3        
        //   419: invokestatic    kawa/lib/lists.lambda6:(Ljava/lang/Object;Ljava/lang/Object;)V
        //   422: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //   425: areturn        
        //   426: aload_2        
        //   427: aload_3        
        //   428: invokestatic    kawa/lib/lists.lambda7:(Ljava/lang/Object;Ljava/lang/Object;)V
        //   431: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //   434: areturn        
        //   435: aload_2        
        //   436: aload_3        
        //   437: invokestatic    kawa/lib/lists.lambda8:(Ljava/lang/Object;Ljava/lang/Object;)V
        //   440: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //   443: areturn        
        //   444: aload_2        
        //   445: aload_3        
        //   446: invokestatic    kawa/lib/lists.lambda9:(Ljava/lang/Object;Ljava/lang/Object;)V
        //   449: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //   452: areturn        
        //   453: aload_2        
        //   454: aload_3        
        //   455: invokestatic    kawa/lib/lists.lambda10:(Ljava/lang/Object;Ljava/lang/Object;)V
        //   458: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //   461: areturn        
        //   462: aload_2        
        //   463: aload_3        
        //   464: invokestatic    kawa/lib/lists.lambda11:(Ljava/lang/Object;Ljava/lang/Object;)V
        //   467: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //   470: areturn        
        //   471: aload_2        
        //   472: aload_3        
        //   473: invokestatic    kawa/lib/lists.lambda12:(Ljava/lang/Object;Ljava/lang/Object;)V
        //   476: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //   479: areturn        
        //   480: aload_2        
        //   481: aload_3        
        //   482: invokestatic    kawa/lib/lists.lambda13:(Ljava/lang/Object;Ljava/lang/Object;)V
        //   485: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //   488: areturn        
        //   489: aload_2        
        //   490: aload_3        
        //   491: invokestatic    kawa/lib/lists.lambda14:(Ljava/lang/Object;Ljava/lang/Object;)V
        //   494: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //   497: areturn        
        //   498: aload_2        
        //   499: aload_3        
        //   500: invokestatic    kawa/lib/lists.lambda15:(Ljava/lang/Object;Ljava/lang/Object;)V
        //   503: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //   506: areturn        
        //   507: aload_2        
        //   508: aload_3        
        //   509: invokestatic    kawa/lib/lists.lambda16:(Ljava/lang/Object;Ljava/lang/Object;)V
        //   512: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //   515: areturn        
        //   516: aload_2        
        //   517: aload_3        
        //   518: invokestatic    kawa/lib/lists.lambda17:(Ljava/lang/Object;Ljava/lang/Object;)V
        //   521: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //   524: areturn        
        //   525: aload_2        
        //   526: aload_3        
        //   527: invokestatic    kawa/lib/lists.lambda18:(Ljava/lang/Object;Ljava/lang/Object;)V
        //   530: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //   533: areturn        
        //   534: aload_2        
        //   535: aload_3        
        //   536: invokestatic    kawa/lib/lists.lambda19:(Ljava/lang/Object;Ljava/lang/Object;)V
        //   539: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //   542: areturn        
        //   543: aload_2        
        //   544: aload_3        
        //   545: invokestatic    kawa/lib/lists.lambda20:(Ljava/lang/Object;Ljava/lang/Object;)V
        //   548: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //   551: areturn        
        //   552: aload_2        
        //   553: aload_3        
        //   554: invokestatic    kawa/lib/lists.lambda21:(Ljava/lang/Object;Ljava/lang/Object;)V
        //   557: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //   560: areturn        
        //   561: aload_2        
        //   562: aload_3        
        //   563: invokestatic    kawa/lib/lists.lambda22:(Ljava/lang/Object;Ljava/lang/Object;)V
        //   566: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //   569: areturn        
        //   570: aload_2        
        //   571: aload_3        
        //   572: invokestatic    kawa/lib/lists.lambda23:(Ljava/lang/Object;Ljava/lang/Object;)V
        //   575: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //   578: areturn        
        //   579: aload_2        
        //   580: aload_3        
        //   581: invokestatic    kawa/lib/lists.lambda24:(Ljava/lang/Object;Ljava/lang/Object;)V
        //   584: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //   587: areturn        
        //   588: aload_2        
        //   589: aload_3        
        //   590: invokestatic    kawa/lib/lists.lambda25:(Ljava/lang/Object;Ljava/lang/Object;)V
        //   593: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //   596: areturn        
        //   597: aload_2        
        //   598: aload_3        
        //   599: invokestatic    kawa/lib/lists.lambda26:(Ljava/lang/Object;Ljava/lang/Object;)V
        //   602: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //   605: areturn        
        //   606: aload_2        
        //   607: aload_3        
        //   608: invokestatic    kawa/lib/lists.lambda27:(Ljava/lang/Object;Ljava/lang/Object;)V
        //   611: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //   614: areturn        
        //   615: aload_2        
        //   616: aload_3        
        //   617: invokestatic    kawa/lib/lists.lambda28:(Ljava/lang/Object;Ljava/lang/Object;)V
        //   620: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //   623: areturn        
        //   624: aload_2        
        //   625: aload_3        
        //   626: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   629: checkcast       Ljava/lang/Number;
        //   632: invokevirtual   java/lang/Number.intValue:()I
        //   635: invokestatic    kawa/lib/lists.listTail:(Ljava/lang/Object;I)Ljava/lang/Object;
        //   638: areturn        
        //   639: aload_2        
        //   640: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   643: checkcast       Ljava/lang/Number;
        //   646: invokevirtual   java/lang/Number.intValue:()I
        //   649: aload_3        
        //   650: invokestatic    kawa/lib/lists.makeList:(ILjava/lang/Object;)Lgnu/lists/LList;
        //   653: areturn        
        //   654: aload_2        
        //   655: aload_3        
        //   656: invokestatic    kawa/lib/lists.memq:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   659: areturn        
        //   660: aload_2        
        //   661: aload_3        
        //   662: invokestatic    kawa/lib/lists.memv:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   665: areturn        
        //   666: aload_2        
        //   667: aload_3        
        //   668: invokestatic    kawa/lib/lists.member:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   671: areturn        
        //   672: aload_2        
        //   673: aload_3        
        //   674: invokestatic    kawa/lib/lists.assq:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   677: areturn        
        //   678: aload_2        
        //   679: aload_3        
        //   680: invokestatic    kawa/lib/lists.assv:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   683: areturn        
        //   684: aload_2        
        //   685: aload_3        
        //   686: invokestatic    kawa/lib/lists.assoc:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   689: areturn        
        //   690: aload_2        
        //   691: aload_3        
        //   692: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   695: checkcast       Ljava/lang/Number;
        //   698: invokevirtual   java/lang/Number.intValue:()I
        //   701: invokestatic    kawa/lib/lists.listRef:(Ljava/lang/Object;I)Ljava/lang/Object;
        //   704: areturn        
        //   705: aload_0        
        //   706: aload_1        
        //   707: aload_2        
        //   708: aload_3        
        //   709: invokespecial   gnu/expr/ModuleBody.apply2:(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   712: areturn        
        //   713: new             Lgnu/mapping/WrongType;
        //   716: dup_x1         
        //   717: swap           
        //   718: ldc_w           "set-car!"
        //   721: iconst_1       
        //   722: aload_2        
        //   723: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   726: athrow         
        //   727: new             Lgnu/mapping/WrongType;
        //   730: dup_x1         
        //   731: swap           
        //   732: ldc_w           "set-cdr!"
        //   735: iconst_1       
        //   736: aload_2        
        //   737: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   740: athrow         
        //   741: new             Lgnu/mapping/WrongType;
        //   744: dup_x1         
        //   745: swap           
        //   746: ldc_w           "list-tail"
        //   749: iconst_2       
        //   750: aload_3        
        //   751: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   754: athrow         
        //   755: new             Lgnu/mapping/WrongType;
        //   758: dup_x1         
        //   759: swap           
        //   760: ldc_w           "make-list"
        //   763: iconst_1       
        //   764: aload_2        
        //   765: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   768: athrow         
        //   769: new             Lgnu/mapping/WrongType;
        //   772: dup_x1         
        //   773: swap           
        //   774: ldc_w           "list-ref"
        //   777: iconst_2       
        //   778: aload_3        
        //   779: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   782: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  344    347    713    727    Ljava/lang/ClassCastException;
        //  361    364    727    741    Ljava/lang/ClassCastException;
        //  629    635    741    755    Ljava/lang/ClassCastException;
        //  643    649    755    769    Ljava/lang/ClassCastException;
        //  695    701    769    783    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 254 out of bounds for length 254
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
        //               67: 40
        //               75: 60
        //               79: 77
        //          default: 94
        //        }
        //    40: aload_2        
        //    41: aload_3        
        //    42: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //    45: checkcast       Ljava/lang/Number;
        //    48: invokevirtual   java/lang/Number.intValue:()I
        //    51: aload           4
        //    53: invokestatic    kawa/lib/lists.listSet$Ex:(Ljava/lang/Object;ILjava/lang/Object;)V
        //    56: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //    59: areturn        
        //    60: aload_2        
        //    61: aload_3        
        //    62: aload           4
        //    64: ldc_w           Lgnu/mapping/Procedure;.class
        //    67: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    70: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceToProcedure:(Ljava/lang/Object;)Lgnu/mapping/Procedure;
        //    73: invokestatic    kawa/lib/lists.member:(Ljava/lang/Object;Ljava/lang/Object;Lgnu/mapping/Procedure;)Ljava/lang/Object;
        //    76: areturn        
        //    77: aload_2        
        //    78: aload_3        
        //    79: aload           4
        //    81: ldc_w           Lgnu/mapping/Procedure;.class
        //    84: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    87: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceToProcedure:(Ljava/lang/Object;)Lgnu/mapping/Procedure;
        //    90: invokestatic    kawa/lib/lists.assoc:(Ljava/lang/Object;Ljava/lang/Object;Lgnu/mapping/Procedure;)Ljava/lang/Object;
        //    93: areturn        
        //    94: aload_0        
        //    95: aload_1        
        //    96: aload_2        
        //    97: aload_3        
        //    98: aload           4
        //   100: invokespecial   gnu/expr/ModuleBody.apply3:(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   103: areturn        
        //   104: new             Lgnu/mapping/WrongType;
        //   107: dup_x1         
        //   108: swap           
        //   109: ldc_w           "list-set!"
        //   112: iconst_2       
        //   113: aload_3        
        //   114: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   117: athrow         
        //   118: new             Lgnu/mapping/WrongType;
        //   121: dup_x1         
        //   122: swap           
        //   123: ldc_w           "member"
        //   126: iconst_3       
        //   127: aload           4
        //   129: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   132: athrow         
        //   133: new             Lgnu/mapping/WrongType;
        //   136: dup_x1         
        //   137: swap           
        //   138: ldc_w           "assoc"
        //   141: iconst_3       
        //   142: aload           4
        //   144: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   147: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  45     51     104    118    Ljava/lang/ClassCastException;
        //  70     73     118    133    Ljava/lang/ClassCastException;
        //  87     90     133    148    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 59 out of bounds for length 59
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
