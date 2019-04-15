/*
 * Decompiled with CFR 0.139.
 */
package kawa.lib;

import gnu.expr.GenericProc;
import gnu.expr.KawaConvert;
import gnu.expr.Keyword;
import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.kawa.functions.IsEqual;
import gnu.kawa.functions.IsEqv;
import gnu.kawa.lispexpr.LangObjType;
import gnu.kawa.reflect.StaticFieldLocation;
import gnu.lists.Consumer;
import gnu.lists.EmptyList;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.lists.Sequences;
import gnu.mapping.CallContext;
import gnu.mapping.MethodProc;
import gnu.mapping.Procedure;
import gnu.mapping.Promise;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Symbol;
import gnu.mapping.Values;
import gnu.mapping.WrongType;
import java.util.List;
import kawa.SourceMethodType;
import kawa.standard.Scheme;

public class lists
extends ModuleBody {
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
        CallContext $ctx = CallContext.getInstance();
        Consumer $result = $ctx.consumer;
        car.setProperty(Lit0, set$Mncar$Ex);
        cdr.setProperty(Lit0, set$Mncdr$Ex);
        caar.setProperty(Lit0, lambda$Fn1);
        cadr.setProperty(Lit0, lambda$Fn2);
        cdar.setProperty(Lit0, lambda$Fn3);
        cddr.setProperty(Lit0, lambda$Fn4);
        caaar.setProperty(Lit0, lambda$Fn5);
        caadr.setProperty(Lit0, lambda$Fn6);
        cadar.setProperty(Lit0, lambda$Fn7);
        caddr.setProperty(Lit0, lambda$Fn8);
        cdaar.setProperty(Lit0, lambda$Fn9);
        cdadr.setProperty(Lit0, lambda$Fn10);
        cddar.setProperty(Lit0, lambda$Fn11);
        cdddr.setProperty(Lit0, lambda$Fn12);
        caaaar.setProperty(Lit0, lambda$Fn13);
        caaadr.setProperty(Lit0, lambda$Fn14);
        caadar.setProperty(Lit0, lambda$Fn15);
        caaddr.setProperty(Lit0, lambda$Fn16);
        cadaar.setProperty(Lit0, lambda$Fn17);
        cadadr.setProperty(Lit0, lambda$Fn18);
        caddar.setProperty(Lit0, lambda$Fn19);
        cadddr.setProperty(Lit0, lambda$Fn20);
        cdaaar.setProperty(Lit0, lambda$Fn21);
        cdaadr.setProperty(Lit0, lambda$Fn22);
        cdadar.setProperty(Lit0, lambda$Fn23);
        cdaddr.setProperty(Lit0, lambda$Fn24);
        cddaar.setProperty(Lit0, lambda$Fn25);
        cddadr.setProperty(Lit0, lambda$Fn26);
        cdddar.setProperty(Lit0, lambda$Fn27);
        cddddr.setProperty(Lit0, lambda$Fn28);
        list$Mnref.setProperty(Lit0, list$Mnset$Ex);
    }

    public static boolean isPair(Object x) {
        return Promise.force(x) instanceof Pair;
    }

    public static Pair cons(Object car, Object cdr) {
        return new Pair(car, cdr);
    }

    public static boolean isNull(Object x) {
        return Promise.force(x) == LList.Empty;
    }

    public static void setCar$Ex(Pair p, Object x) {
        p.setCar(x);
    }

    public static void setCdr$Ex(Pair p, Object x) {
        p.setCdr(x);
    }

    static void lambda1(Object arg, Object value) {
        ((Pair)Promise.force(((Pair)Promise.force(arg, Pair.class)).getCar(), Pair.class)).setCar(value);
    }

    static void lambda2(Object arg, Object value) {
        ((Pair)Promise.force(((Pair)Promise.force(arg, Pair.class)).getCdr(), Pair.class)).setCar(value);
    }

    static void lambda3(Object arg, Object value) {
        ((Pair)Promise.force(((Pair)Promise.force(arg, Pair.class)).getCar(), Pair.class)).setCdr(value);
    }

    static void lambda4(Object arg, Object value) {
        ((Pair)Promise.force(((Pair)Promise.force(arg, Pair.class)).getCdr(), Pair.class)).setCdr(value);
    }

    static void lambda5(Object arg, Object value) {
        ((Pair)Promise.force(((Pair)Promise.force(((Pair)Promise.force(arg, Pair.class)).getCar(), Pair.class)).getCar(), Pair.class)).setCar(value);
    }

    static void lambda6(Object arg, Object value) {
        ((Pair)Promise.force(((Pair)Promise.force(((Pair)Promise.force(arg, Pair.class)).getCdr(), Pair.class)).getCar(), Pair.class)).setCar(value);
    }

    static void lambda7(Object arg, Object value) {
        ((Pair)Promise.force(((Pair)Promise.force(((Pair)Promise.force(arg, Pair.class)).getCar(), Pair.class)).getCdr(), Pair.class)).setCar(value);
    }

    static void lambda8(Object arg, Object value) {
        ((Pair)Promise.force(((Pair)Promise.force(((Pair)Promise.force(arg, Pair.class)).getCdr(), Pair.class)).getCdr(), Pair.class)).setCar(value);
    }

    static void lambda9(Object arg, Object value) {
        ((Pair)Promise.force(((Pair)Promise.force(((Pair)Promise.force(arg, Pair.class)).getCar(), Pair.class)).getCar(), Pair.class)).setCdr(value);
    }

    static void lambda10(Object arg, Object value) {
        ((Pair)Promise.force(((Pair)Promise.force(((Pair)Promise.force(arg, Pair.class)).getCdr(), Pair.class)).getCar(), Pair.class)).setCdr(value);
    }

    static void lambda11(Object arg, Object value) {
        ((Pair)Promise.force(((Pair)Promise.force(((Pair)Promise.force(arg, Pair.class)).getCar(), Pair.class)).getCdr(), Pair.class)).setCdr(value);
    }

    static void lambda12(Object arg, Object value) {
        ((Pair)Promise.force(((Pair)Promise.force(((Pair)Promise.force(arg, Pair.class)).getCdr(), Pair.class)).getCdr(), Pair.class)).setCdr(value);
    }

    static void lambda13(Object arg, Object value) {
        ((Pair)Promise.force(((Pair)Promise.force(((Pair)Promise.force(((Pair)Promise.force(arg, Pair.class)).getCar(), Pair.class)).getCar(), Pair.class)).getCar(), Pair.class)).setCar(value);
    }

    static void lambda14(Object arg, Object value) {
        ((Pair)Promise.force(((Pair)Promise.force(((Pair)Promise.force(((Pair)Promise.force(arg, Pair.class)).getCdr(), Pair.class)).getCar(), Pair.class)).getCar(), Pair.class)).setCar(value);
    }

    static void lambda15(Object arg, Object value) {
        ((Pair)Promise.force(((Pair)Promise.force(((Pair)Promise.force(((Pair)Promise.force(arg, Pair.class)).getCar(), Pair.class)).getCdr(), Pair.class)).getCar(), Pair.class)).setCar(value);
    }

    static void lambda16(Object arg, Object value) {
        ((Pair)Promise.force(((Pair)Promise.force(((Pair)Promise.force(((Pair)Promise.force(arg, Pair.class)).getCdr(), Pair.class)).getCdr(), Pair.class)).getCar(), Pair.class)).setCar(value);
    }

    static void lambda17(Object arg, Object value) {
        ((Pair)Promise.force(((Pair)Promise.force(((Pair)Promise.force(((Pair)Promise.force(arg, Pair.class)).getCar(), Pair.class)).getCar(), Pair.class)).getCdr(), Pair.class)).setCar(value);
    }

    static void lambda18(Object arg, Object value) {
        ((Pair)Promise.force(((Pair)Promise.force(((Pair)Promise.force(((Pair)Promise.force(arg, Pair.class)).getCdr(), Pair.class)).getCar(), Pair.class)).getCdr(), Pair.class)).setCar(value);
    }

    static void lambda19(Object arg, Object value) {
        ((Pair)Promise.force(((Pair)Promise.force(((Pair)Promise.force(((Pair)Promise.force(arg, Pair.class)).getCar(), Pair.class)).getCdr(), Pair.class)).getCdr(), Pair.class)).setCar(value);
    }

    static void lambda20(Object arg, Object value) {
        ((Pair)Promise.force(((Pair)Promise.force(((Pair)Promise.force(((Pair)Promise.force(arg, Pair.class)).getCdr(), Pair.class)).getCdr(), Pair.class)).getCdr(), Pair.class)).setCar(value);
    }

    static void lambda21(Object arg, Object value) {
        ((Pair)Promise.force(((Pair)Promise.force(((Pair)Promise.force(((Pair)Promise.force(arg, Pair.class)).getCar(), Pair.class)).getCar(), Pair.class)).getCar(), Pair.class)).setCdr(value);
    }

    static void lambda22(Object arg, Object value) {
        ((Pair)Promise.force(((Pair)Promise.force(((Pair)Promise.force(((Pair)Promise.force(arg, Pair.class)).getCdr(), Pair.class)).getCar(), Pair.class)).getCar(), Pair.class)).setCdr(value);
    }

    static void lambda23(Object arg, Object value) {
        ((Pair)Promise.force(((Pair)Promise.force(((Pair)Promise.force(((Pair)Promise.force(arg, Pair.class)).getCar(), Pair.class)).getCdr(), Pair.class)).getCar(), Pair.class)).setCdr(value);
    }

    static void lambda24(Object arg, Object value) {
        ((Pair)Promise.force(((Pair)Promise.force(((Pair)Promise.force(((Pair)Promise.force(arg, Pair.class)).getCdr(), Pair.class)).getCdr(), Pair.class)).getCar(), Pair.class)).setCdr(value);
    }

    static void lambda25(Object arg, Object value) {
        ((Pair)Promise.force(((Pair)Promise.force(((Pair)Promise.force(((Pair)Promise.force(arg, Pair.class)).getCar(), Pair.class)).getCar(), Pair.class)).getCdr(), Pair.class)).setCdr(value);
    }

    static void lambda26(Object arg, Object value) {
        ((Pair)Promise.force(((Pair)Promise.force(((Pair)Promise.force(((Pair)Promise.force(arg, Pair.class)).getCdr(), Pair.class)).getCar(), Pair.class)).getCdr(), Pair.class)).setCdr(value);
    }

    static void lambda27(Object arg, Object value) {
        ((Pair)Promise.force(((Pair)Promise.force(((Pair)Promise.force(((Pair)Promise.force(arg, Pair.class)).getCar(), Pair.class)).getCdr(), Pair.class)).getCdr(), Pair.class)).setCdr(value);
    }

    static void lambda28(Object arg, Object value) {
        ((Pair)Promise.force(((Pair)Promise.force(((Pair)Promise.force(((Pair)Promise.force(arg, Pair.class)).getCdr(), Pair.class)).getCdr(), Pair.class)).getCdr(), Pair.class)).setCdr(value);
    }

    @SourceMethodType(value={"", "sequence"})
    public static int length(List list) {
        return list.size();
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static LList reverse(LList list) {
        v0 = list;
        v1 /* !! */  = result = LList.Empty;
        do lbl-1000: // 2 sources:
        {
            if (lists.isNull(arg = v0)) {
                return (LList)Promise.force(result, LList.class);
            }
            object2 = Promise.force(arg, Pair.class);
            p = (Pair)object2;
            break;
        } while (true);
        catch (ClassCastException v2) {
            throw new WrongType(v2, "p", -2, object2);
        }
        {
            v0 = p.getCdr();
            v1 /* !! */  = lists.cons(p.getCar(), result);
            ** while (true)
        }
    }

    public static Object listTail(Object list, int count) {
        Object lst;
        Object object2 = lst = list;
        while (--count >= 0) {
            Object flst = Promise.force(lst);
            if (flst instanceof Pair) {
                object2 = ((Pair)Promise.force(flst, Pair.class)).getCdr();
                continue;
            }
            throw new IndexOutOfBoundsException("List is too short.");
        }
        return lst;
    }

    public static void listSet$Ex(Object list, int index, Object obj) {
        Object object2 = Promise.force(lists.listTail(list, index), Pair.class);
        try {
            lists.setCar$Ex((Pair)object2, obj);
            return;
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "set-car!", 0, object2);
        }
    }

    public static boolean isList(Object obj) {
        return LList.listLength(obj, false) >= 0;
    }

    public static LList makeList(int n) {
        return lists.makeList(n, null);
    }

    public static LList makeList(int k, Object fill) {
        LList result = LList.Empty;
        for (int i = k; i > 0; --i) {
            result = lists.cons(fill, result);
        }
        return result;
    }

    public static LList reverse$Ex(LList list) {
        return LList.reverseInPlace(list);
    }

    public static Object memq(Object x, Object list) {
        Object object2;
        block2 : {
            Object lst;
            Object object3;
            Object object4;
            Object object5 = list;
            while ((object4 = Promise.force(object3 = (lst = object5), Pair.class)) instanceof Pair) {
                Pair pair = (Pair)object4;
                if (x == pair.getCar()) {
                    object2 = lst;
                    break block2;
                }
                object5 = pair.getCdr();
            }
            object2 = Boolean.FALSE;
        }
        return object2;
    }

    public static Object memv(Object x, Object list) {
        Object object2;
        block2 : {
            Object lst;
            Object object3;
            Object object4;
            Object object5 = list;
            while ((object4 = Promise.force(object3 = (lst = object5), Pair.class)) instanceof Pair) {
                Pair pair = (Pair)object4;
                if (IsEqv.apply(x, pair.getCar())) {
                    object2 = lst;
                    break block2;
                }
                object5 = pair.getCdr();
            }
            object2 = Boolean.FALSE;
        }
        return object2;
    }

    public static Object member(Object object2, Object object3) {
        return lists.member(object2, object3, Scheme.isEqual);
    }

    public static Object member(Object x, Object list, Procedure test) {
        Object object2;
        block2 : {
            Object object3;
            Object lst;
            Object object4;
            Object object5 = list;
            while ((object4 = Promise.force(object3 = (lst = object5), Pair.class)) instanceof Pair) {
                Pair pair = (Pair)object4;
                if (KawaConvert.isTrue(test.apply2(x, pair.getCar()))) {
                    object2 = lst;
                    break block2;
                }
                object5 = pair.getCdr();
            }
            object2 = Boolean.FALSE;
        }
        return object2;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static Object assq(Object x, Object list) {
        v0 = list;
        do lbl-1000: // 2 sources:
        {
            if ((list2 = v0) == LList.Empty) {
                v1 /* !! */  = Boolean.FALSE;
                return v1 /* !! */ ;
            }
            object2 = Promise.force(lists.car.apply1(list2), Pair.class);
            pair = (Pair)object2;
            break;
        } while (true);
        catch (ClassCastException v2) {
            throw new WrongType(v2, "pair", -2, object2);
        }
        {
            if (pair.getCar() == x) {
                v1 /* !! */  = pair;
                return v1 /* !! */ ;
            }
            v0 = lists.cdr.apply1(list2);
            ** while (true)
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static Object assv(Object x, Object list) {
        v0 = list;
        do lbl-1000: // 2 sources:
        {
            if ((list2 = v0) == LList.Empty) {
                v1 /* !! */  = Boolean.FALSE;
                return v1 /* !! */ ;
            }
            object2 = Promise.force(lists.car.apply1(list2), Pair.class);
            pair = (Pair)object2;
            break;
        } while (true);
        catch (ClassCastException v2) {
            throw new WrongType(v2, "pair", -2, object2);
        }
        {
            if (IsEqv.apply(pair.getCar(), x)) {
                v1 /* !! */  = pair;
                return v1 /* !! */ ;
            }
            v0 = lists.cdr.apply1(list2);
            ** while (true)
        }
    }

    public static Object assoc(Object object2, Object object3) {
        return lists.assoc(object2, object3, Scheme.isEqual);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static Object assoc(Object key, Object list, Procedure test) {
        v0 = list;
        do lbl-1000: // 2 sources:
        {
            if ((list2 = v0) == LList.Empty) {
                v1 /* !! */  = Boolean.FALSE;
                return v1 /* !! */ ;
            }
            object2 = Promise.force(lists.car.apply1(list2), Pair.class);
            pair = (Pair)object2;
            break;
        } while (true);
        catch (ClassCastException v2) {
            throw new WrongType(v2, "pair", -2, object2);
        }
        {
            if (KawaConvert.isTrue(test.apply2(key, pair.getCar()))) {
                v1 /* !! */  = pair;
                return v1 /* !! */ ;
            }
            v0 = lists.cdr.apply1(list2);
            ** while (true)
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static Object listCopy(Object obj) {
        object2 = obj;
        prev = null;
        v0 = obj;
        do lbl-1000: // 2 sources:
        {
            if (!lists.isPair(x = v0)) {
                if (prev == null) return result;
                lists.setCdr$Ex(prev, x);
                return result;
            }
            object4 = Promise.force(x, Pair.class);
            pold = (Pair)object4;
            break;
        } while (true);
        catch (ClassCastException v1) {
            throw new WrongType(v1, "pold", -2, (Object)pnew);
        }
        {
            pnew = lists.cons(pold.getCar(), null);
            if (prev == null) {
                result = pnew;
            } else {
                lists.setCdr$Ex(prev, pnew);
            }
            prev = pnew;
            v0 = pold.getCdr();
            ** while (true)
        }
    }

    public static {
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
        $instance = new lists();
        $Prvt$define$Mnprocedure = StaticFieldLocation.make("kawa.lib.std_syntax", "define$Mnprocedure");
        lists lists2 = $instance;
        pair$Qu = new ModuleMethod(lists2, 1, Lit1, 4097);
        cons = new ModuleMethod(lists2, 2, Lit2, 8194);
        null$Qu = new ModuleMethod(lists2, 3, Lit3, 4097);
        set$Mncar$Ex = new ModuleMethod(lists2, 4, Lit4, 8194);
        set$Mncdr$Ex = new ModuleMethod(lists2, 5, Lit5, 8194);
        GenericProc genericProc = new GenericProc("car");
        lists $instance = lists.$instance;
        ModuleMethod moduleMethod = new ModuleMethod($instance, 6, "car", 4097);
        moduleMethod.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/lists.scm:31");
        genericProc.add(moduleMethod);
        car = genericProc;
        GenericProc genericProc2 = new GenericProc("cdr");
        $instance = lists.$instance;
        ModuleMethod moduleMethod2 = new ModuleMethod($instance, 7, "cdr", 4097);
        moduleMethod2.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/lists.scm:36");
        genericProc2.add(moduleMethod2);
        cdr = genericProc2;
        GenericProc genericProc3 = new GenericProc("caar");
        $instance = lists.$instance;
        genericProc3.add(new ModuleMethod($instance, 8, "caar", 4097));
        caar = genericProc3;
        lambda$Fn1 = new ModuleMethod(lists2, 9, null, 8194);
        GenericProc genericProc4 = new GenericProc("cadr");
        $instance = lists.$instance;
        genericProc4.add(new ModuleMethod($instance, 10, "cadr", 4097));
        cadr = genericProc4;
        lambda$Fn2 = new ModuleMethod(lists2, 11, null, 8194);
        GenericProc genericProc5 = new GenericProc("cdar");
        $instance = lists.$instance;
        genericProc5.add(new ModuleMethod($instance, 12, "cdar", 4097));
        cdar = genericProc5;
        lambda$Fn3 = new ModuleMethod(lists2, 13, null, 8194);
        GenericProc genericProc6 = new GenericProc("cddr");
        $instance = lists.$instance;
        genericProc6.add(new ModuleMethod($instance, 14, "cddr", 4097));
        cddr = genericProc6;
        lambda$Fn4 = new ModuleMethod(lists2, 15, null, 8194);
        GenericProc genericProc7 = new GenericProc("caaar");
        $instance = lists.$instance;
        genericProc7.add(new ModuleMethod($instance, 16, "caaar", 4097));
        caaar = genericProc7;
        lambda$Fn5 = new ModuleMethod(lists2, 17, null, 8194);
        GenericProc genericProc8 = new GenericProc("caadr");
        $instance = lists.$instance;
        genericProc8.add(new ModuleMethod($instance, 18, "caadr", 4097));
        caadr = genericProc8;
        lambda$Fn6 = new ModuleMethod(lists2, 19, null, 8194);
        GenericProc genericProc9 = new GenericProc("cadar");
        $instance = lists.$instance;
        genericProc9.add(new ModuleMethod($instance, 20, "cadar", 4097));
        cadar = genericProc9;
        lambda$Fn7 = new ModuleMethod(lists2, 21, null, 8194);
        GenericProc genericProc10 = new GenericProc("caddr");
        $instance = lists.$instance;
        genericProc10.add(new ModuleMethod($instance, 22, "caddr", 4097));
        caddr = genericProc10;
        lambda$Fn8 = new ModuleMethod(lists2, 23, null, 8194);
        GenericProc genericProc11 = new GenericProc("cdaar");
        $instance = lists.$instance;
        genericProc11.add(new ModuleMethod($instance, 24, "cdaar", 4097));
        cdaar = genericProc11;
        lambda$Fn9 = new ModuleMethod(lists2, 25, null, 8194);
        GenericProc genericProc12 = new GenericProc("cdadr");
        $instance = lists.$instance;
        genericProc12.add(new ModuleMethod($instance, 26, "cdadr", 4097));
        cdadr = genericProc12;
        lambda$Fn10 = new ModuleMethod(lists2, 27, null, 8194);
        GenericProc genericProc13 = new GenericProc("cddar");
        $instance = lists.$instance;
        genericProc13.add(new ModuleMethod($instance, 28, "cddar", 4097));
        cddar = genericProc13;
        lambda$Fn11 = new ModuleMethod(lists2, 29, null, 8194);
        GenericProc genericProc14 = new GenericProc("cdddr");
        $instance = lists.$instance;
        genericProc14.add(new ModuleMethod($instance, 30, "cdddr", 4097));
        cdddr = genericProc14;
        lambda$Fn12 = new ModuleMethod(lists2, 31, null, 8194);
        GenericProc genericProc15 = new GenericProc("caaaar");
        $instance = lists.$instance;
        genericProc15.add(new ModuleMethod($instance, 32, "caaaar", 4097));
        caaaar = genericProc15;
        lambda$Fn13 = new ModuleMethod(lists2, 33, null, 8194);
        GenericProc genericProc16 = new GenericProc("caaadr");
        $instance = lists.$instance;
        genericProc16.add(new ModuleMethod($instance, 34, "caaadr", 4097));
        caaadr = genericProc16;
        lambda$Fn14 = new ModuleMethod(lists2, 35, null, 8194);
        GenericProc genericProc17 = new GenericProc("caadar");
        $instance = lists.$instance;
        genericProc17.add(new ModuleMethod($instance, 36, "caadar", 4097));
        caadar = genericProc17;
        lambda$Fn15 = new ModuleMethod(lists2, 37, null, 8194);
        GenericProc genericProc18 = new GenericProc("caaddr");
        $instance = lists.$instance;
        genericProc18.add(new ModuleMethod($instance, 38, "caaddr", 4097));
        caaddr = genericProc18;
        lambda$Fn16 = new ModuleMethod(lists2, 39, null, 8194);
        GenericProc genericProc19 = new GenericProc("cadaar");
        $instance = lists.$instance;
        genericProc19.add(new ModuleMethod($instance, 40, "cadaar", 4097));
        cadaar = genericProc19;
        lambda$Fn17 = new ModuleMethod(lists2, 41, null, 8194);
        GenericProc genericProc20 = new GenericProc("cadadr");
        $instance = lists.$instance;
        genericProc20.add(new ModuleMethod($instance, 42, "cadadr", 4097));
        cadadr = genericProc20;
        lambda$Fn18 = new ModuleMethod(lists2, 43, null, 8194);
        GenericProc genericProc21 = new GenericProc("caddar");
        $instance = lists.$instance;
        genericProc21.add(new ModuleMethod($instance, 44, "caddar", 4097));
        caddar = genericProc21;
        lambda$Fn19 = new ModuleMethod(lists2, 45, null, 8194);
        GenericProc genericProc22 = new GenericProc("cadddr");
        $instance = lists.$instance;
        genericProc22.add(new ModuleMethod($instance, 46, "cadddr", 4097));
        cadddr = genericProc22;
        lambda$Fn20 = new ModuleMethod(lists2, 47, null, 8194);
        GenericProc genericProc23 = new GenericProc("cdaaar");
        $instance = lists.$instance;
        genericProc23.add(new ModuleMethod($instance, 48, "cdaaar", 4097));
        cdaaar = genericProc23;
        lambda$Fn21 = new ModuleMethod(lists2, 49, null, 8194);
        GenericProc genericProc24 = new GenericProc("cdaadr");
        $instance = lists.$instance;
        genericProc24.add(new ModuleMethod($instance, 50, "cdaadr", 4097));
        cdaadr = genericProc24;
        lambda$Fn22 = new ModuleMethod(lists2, 51, null, 8194);
        GenericProc genericProc25 = new GenericProc("cdadar");
        $instance = lists.$instance;
        genericProc25.add(new ModuleMethod($instance, 52, "cdadar", 4097));
        cdadar = genericProc25;
        lambda$Fn23 = new ModuleMethod(lists2, 53, null, 8194);
        GenericProc genericProc26 = new GenericProc("cdaddr");
        $instance = lists.$instance;
        genericProc26.add(new ModuleMethod($instance, 54, "cdaddr", 4097));
        cdaddr = genericProc26;
        lambda$Fn24 = new ModuleMethod(lists2, 55, null, 8194);
        GenericProc genericProc27 = new GenericProc("cddaar");
        $instance = lists.$instance;
        genericProc27.add(new ModuleMethod($instance, 56, "cddaar", 4097));
        cddaar = genericProc27;
        lambda$Fn25 = new ModuleMethod(lists2, 57, null, 8194);
        GenericProc genericProc28 = new GenericProc("cddadr");
        $instance = lists.$instance;
        genericProc28.add(new ModuleMethod($instance, 58, "cddadr", 4097));
        cddadr = genericProc28;
        lambda$Fn26 = new ModuleMethod(lists2, 59, null, 8194);
        GenericProc genericProc29 = new GenericProc("cdddar");
        $instance = lists.$instance;
        genericProc29.add(new ModuleMethod($instance, 60, "cdddar", 4097));
        cdddar = genericProc29;
        lambda$Fn27 = new ModuleMethod(lists2, 61, null, 8194);
        GenericProc genericProc30 = new GenericProc("cddddr");
        $instance = lists.$instance;
        genericProc30.add(new ModuleMethod($instance, 62, "cddddr", 4097));
        cddddr = genericProc30;
        lambda$Fn28 = new ModuleMethod(lists2, 63, null, 8194);
        ModuleMethod moduleMethod3 = new ModuleMethod(lists2, 64, Lit6, 4097);
        moduleMethod3.setProperty(Procedure.validateApplyKey, "kawa.lib.compile_misc:lengthValidateApply");
        length = moduleMethod3;
        reverse = new ModuleMethod(lists2, 65, Lit7, 4097);
        list$Mntail = new ModuleMethod(lists2, 66, Lit8, 8194);
        list$Mnset$Ex = new ModuleMethod(lists2, 67, Lit9, 12291);
        GenericProc genericProc31 = new GenericProc("list-ref");
        $instance = lists.$instance;
        ModuleMethod moduleMethod4 = new ModuleMethod($instance, 68, "list-ref", 8194);
        moduleMethod4.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/lists.scm:121");
        genericProc31.add(moduleMethod4);
        list$Mnref = genericProc31;
        list$Qu = new ModuleMethod(lists2, 69, Lit10, 4097);
        make$Mnlist = new ModuleMethod(lists2, 70, Lit11, 8193);
        reverse$Ex = new ModuleMethod(lists2, 72, Lit12, 4097);
        memq = new ModuleMethod(lists2, 73, Lit13, 8194);
        memv = new ModuleMethod(lists2, 74, Lit14, 8194);
        member = new ModuleMethod(lists2, 75, Lit15, 12290);
        assq = new ModuleMethod(lists2, 77, Lit16, 8194);
        assv = new ModuleMethod(lists2, 78, Lit17, 8194);
        assoc = new ModuleMethod(lists2, 79, Lit18, 12290);
        list$Mncopy = new ModuleMethod(lists2, 81, Lit19, 4097);
        lists.$runBody$();
    }

    public lists() {
        ModuleInfo.register(this);
    }

    public static Object car(Pair x) {
        return x.getCar();
    }

    public static Object cdr(Pair x) {
        return x.getCdr();
    }

    public static Object caar(Object arg) {
        return ((Pair)Promise.force(((Pair)Promise.force(arg, Pair.class)).getCar(), Pair.class)).getCar();
    }

    public static Object cadr(Object arg) {
        return ((Pair)Promise.force(((Pair)Promise.force(arg, Pair.class)).getCdr(), Pair.class)).getCar();
    }

    public static Object cdar(Object arg) {
        return ((Pair)Promise.force(((Pair)Promise.force(arg, Pair.class)).getCar(), Pair.class)).getCdr();
    }

    public static Object cddr(Object arg) {
        return ((Pair)Promise.force(((Pair)Promise.force(arg, Pair.class)).getCdr(), Pair.class)).getCdr();
    }

    public static Object caaar(Object arg) {
        return ((Pair)Promise.force(((Pair)Promise.force(((Pair)Promise.force(arg, Pair.class)).getCar(), Pair.class)).getCar(), Pair.class)).getCar();
    }

    public static Object caadr(Object arg) {
        return ((Pair)Promise.force(((Pair)Promise.force(((Pair)Promise.force(arg, Pair.class)).getCdr(), Pair.class)).getCar(), Pair.class)).getCar();
    }

    public static Object cadar(Object arg) {
        return ((Pair)Promise.force(((Pair)Promise.force(((Pair)Promise.force(arg, Pair.class)).getCar(), Pair.class)).getCdr(), Pair.class)).getCar();
    }

    public static Object caddr(Object arg) {
        return ((Pair)Promise.force(((Pair)Promise.force(((Pair)Promise.force(arg, Pair.class)).getCdr(), Pair.class)).getCdr(), Pair.class)).getCar();
    }

    public static Object cdaar(Object arg) {
        return ((Pair)Promise.force(((Pair)Promise.force(((Pair)Promise.force(arg, Pair.class)).getCar(), Pair.class)).getCar(), Pair.class)).getCdr();
    }

    public static Object cdadr(Object arg) {
        return ((Pair)Promise.force(((Pair)Promise.force(((Pair)Promise.force(arg, Pair.class)).getCdr(), Pair.class)).getCar(), Pair.class)).getCdr();
    }

    public static Object cddar(Object arg) {
        return ((Pair)Promise.force(((Pair)Promise.force(((Pair)Promise.force(arg, Pair.class)).getCar(), Pair.class)).getCdr(), Pair.class)).getCdr();
    }

    public static Object cdddr(Object arg) {
        return ((Pair)Promise.force(((Pair)Promise.force(((Pair)Promise.force(arg, Pair.class)).getCdr(), Pair.class)).getCdr(), Pair.class)).getCdr();
    }

    public static Object caaaar(Object arg) {
        return ((Pair)Promise.force(((Pair)Promise.force(((Pair)Promise.force(((Pair)Promise.force(arg, Pair.class)).getCar(), Pair.class)).getCar(), Pair.class)).getCar(), Pair.class)).getCar();
    }

    public static Object caaadr(Object arg) {
        return ((Pair)Promise.force(((Pair)Promise.force(((Pair)Promise.force(((Pair)Promise.force(arg, Pair.class)).getCdr(), Pair.class)).getCar(), Pair.class)).getCar(), Pair.class)).getCar();
    }

    public static Object caadar(Object arg) {
        return ((Pair)Promise.force(((Pair)Promise.force(((Pair)Promise.force(((Pair)Promise.force(arg, Pair.class)).getCar(), Pair.class)).getCdr(), Pair.class)).getCar(), Pair.class)).getCar();
    }

    public static Object caaddr(Object arg) {
        return ((Pair)Promise.force(((Pair)Promise.force(((Pair)Promise.force(((Pair)Promise.force(arg, Pair.class)).getCdr(), Pair.class)).getCdr(), Pair.class)).getCar(), Pair.class)).getCar();
    }

    public static Object cadaar(Object arg) {
        return ((Pair)Promise.force(((Pair)Promise.force(((Pair)Promise.force(((Pair)Promise.force(arg, Pair.class)).getCar(), Pair.class)).getCar(), Pair.class)).getCdr(), Pair.class)).getCar();
    }

    public static Object cadadr(Object arg) {
        return ((Pair)Promise.force(((Pair)Promise.force(((Pair)Promise.force(((Pair)Promise.force(arg, Pair.class)).getCdr(), Pair.class)).getCar(), Pair.class)).getCdr(), Pair.class)).getCar();
    }

    public static Object caddar(Object arg) {
        return ((Pair)Promise.force(((Pair)Promise.force(((Pair)Promise.force(((Pair)Promise.force(arg, Pair.class)).getCar(), Pair.class)).getCdr(), Pair.class)).getCdr(), Pair.class)).getCar();
    }

    public static Object cadddr(Object arg) {
        return ((Pair)Promise.force(((Pair)Promise.force(((Pair)Promise.force(((Pair)Promise.force(arg, Pair.class)).getCdr(), Pair.class)).getCdr(), Pair.class)).getCdr(), Pair.class)).getCar();
    }

    public static Object cdaaar(Object arg) {
        return ((Pair)Promise.force(((Pair)Promise.force(((Pair)Promise.force(((Pair)Promise.force(arg, Pair.class)).getCar(), Pair.class)).getCar(), Pair.class)).getCar(), Pair.class)).getCdr();
    }

    public static Object cdaadr(Object arg) {
        return ((Pair)Promise.force(((Pair)Promise.force(((Pair)Promise.force(((Pair)Promise.force(arg, Pair.class)).getCdr(), Pair.class)).getCar(), Pair.class)).getCar(), Pair.class)).getCdr();
    }

    public static Object cdadar(Object arg) {
        return ((Pair)Promise.force(((Pair)Promise.force(((Pair)Promise.force(((Pair)Promise.force(arg, Pair.class)).getCar(), Pair.class)).getCdr(), Pair.class)).getCar(), Pair.class)).getCdr();
    }

    public static Object cdaddr(Object arg) {
        return ((Pair)Promise.force(((Pair)Promise.force(((Pair)Promise.force(((Pair)Promise.force(arg, Pair.class)).getCdr(), Pair.class)).getCdr(), Pair.class)).getCar(), Pair.class)).getCdr();
    }

    public static Object cddaar(Object arg) {
        return ((Pair)Promise.force(((Pair)Promise.force(((Pair)Promise.force(((Pair)Promise.force(arg, Pair.class)).getCar(), Pair.class)).getCar(), Pair.class)).getCdr(), Pair.class)).getCdr();
    }

    public static Object cddadr(Object arg) {
        return ((Pair)Promise.force(((Pair)Promise.force(((Pair)Promise.force(((Pair)Promise.force(arg, Pair.class)).getCdr(), Pair.class)).getCar(), Pair.class)).getCdr(), Pair.class)).getCdr();
    }

    public static Object cdddar(Object arg) {
        return ((Pair)Promise.force(((Pair)Promise.force(((Pair)Promise.force(((Pair)Promise.force(arg, Pair.class)).getCar(), Pair.class)).getCdr(), Pair.class)).getCdr(), Pair.class)).getCdr();
    }

    public static Object cddddr(Object arg) {
        return ((Pair)Promise.force(((Pair)Promise.force(((Pair)Promise.force(((Pair)Promise.force(arg, Pair.class)).getCdr(), Pair.class)).getCdr(), Pair.class)).getCdr(), Pair.class)).getCdr();
    }

    public static Object listRef(Object list, int index) {
        return ((Procedure)car).apply1(lists.listTail(list, index));
    }

    public int match1(ModuleMethod moduleMethod, Object object2, CallContext callContext) {
        switch (moduleMethod.selector) {
            case 62: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 60: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 58: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 56: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 54: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 52: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 50: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 48: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 46: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 44: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 42: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 40: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 38: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 36: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 34: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 32: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 30: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 28: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 26: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 24: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 22: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 20: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 18: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 16: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 14: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 12: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 10: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 8: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 7: {
                Object object3 = Promise.force(object2, Pair.class);
                if (!(object3 instanceof Pair)) {
                    return -786431;
                }
                callContext.value1 = object3;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 6: {
                Object object4 = Promise.force(object2, Pair.class);
                if (!(object4 instanceof Pair)) {
                    return -786431;
                }
                callContext.value1 = object4;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 81: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 72: {
                Object object5 = Promise.force(object2, LList.class);
                if (!(object5 instanceof LList)) {
                    return -786431;
                }
                callContext.value1 = object5;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 70: {
                callContext.value1 = Promise.force(object2);
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 69: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 65: {
                Object object6 = Promise.force(object2, LList.class);
                if (!(object6 instanceof LList)) {
                    return -786431;
                }
                callContext.value1 = object6;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 64: {
                Object object7 = Promise.force(object2, List.class);
                if (Sequences.asSequenceOrNull(object7) == null) {
                    return -786431;
                }
                callContext.value1 = object7;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 3: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 1: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
        }
        return super.match1(moduleMethod, object2, callContext);
    }

    public int match2(ModuleMethod moduleMethod, Object object2, Object object3, CallContext callContext) {
        switch (moduleMethod.selector) {
            case 68: {
                callContext.value1 = object2;
                callContext.value2 = Promise.force(object3);
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 79: {
                callContext.value1 = object2;
                callContext.value2 = object3;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 78: {
                callContext.value1 = object2;
                callContext.value2 = object3;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 77: {
                callContext.value1 = object2;
                callContext.value2 = object3;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 75: {
                callContext.value1 = object2;
                callContext.value2 = object3;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 74: {
                callContext.value1 = object2;
                callContext.value2 = object3;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 73: {
                callContext.value1 = object2;
                callContext.value2 = object3;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 70: {
                callContext.value1 = Promise.force(object2);
                callContext.value2 = object3;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 66: {
                callContext.value1 = object2;
                callContext.value2 = Promise.force(object3);
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 63: {
                callContext.value1 = object2;
                callContext.value2 = object3;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 61: {
                callContext.value1 = object2;
                callContext.value2 = object3;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 59: {
                callContext.value1 = object2;
                callContext.value2 = object3;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 57: {
                callContext.value1 = object2;
                callContext.value2 = object3;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 55: {
                callContext.value1 = object2;
                callContext.value2 = object3;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 53: {
                callContext.value1 = object2;
                callContext.value2 = object3;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 51: {
                callContext.value1 = object2;
                callContext.value2 = object3;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 49: {
                callContext.value1 = object2;
                callContext.value2 = object3;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 47: {
                callContext.value1 = object2;
                callContext.value2 = object3;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 45: {
                callContext.value1 = object2;
                callContext.value2 = object3;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 43: {
                callContext.value1 = object2;
                callContext.value2 = object3;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 41: {
                callContext.value1 = object2;
                callContext.value2 = object3;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 39: {
                callContext.value1 = object2;
                callContext.value2 = object3;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 37: {
                callContext.value1 = object2;
                callContext.value2 = object3;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 35: {
                callContext.value1 = object2;
                callContext.value2 = object3;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 33: {
                callContext.value1 = object2;
                callContext.value2 = object3;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 31: {
                callContext.value1 = object2;
                callContext.value2 = object3;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 29: {
                callContext.value1 = object2;
                callContext.value2 = object3;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 27: {
                callContext.value1 = object2;
                callContext.value2 = object3;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 25: {
                callContext.value1 = object2;
                callContext.value2 = object3;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 23: {
                callContext.value1 = object2;
                callContext.value2 = object3;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 21: {
                callContext.value1 = object2;
                callContext.value2 = object3;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 19: {
                callContext.value1 = object2;
                callContext.value2 = object3;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 17: {
                callContext.value1 = object2;
                callContext.value2 = object3;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 15: {
                callContext.value1 = object2;
                callContext.value2 = object3;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 13: {
                callContext.value1 = object2;
                callContext.value2 = object3;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 11: {
                callContext.value1 = object2;
                callContext.value2 = object3;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 9: {
                callContext.value1 = object2;
                callContext.value2 = object3;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 5: {
                Object object4 = Promise.force(object2, Pair.class);
                if (!(object4 instanceof Pair)) {
                    return -786431;
                }
                callContext.value1 = object4;
                callContext.value2 = object3;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 4: {
                Object object5 = Promise.force(object2, Pair.class);
                if (!(object5 instanceof Pair)) {
                    return -786431;
                }
                callContext.value1 = object5;
                callContext.value2 = object3;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 2: {
                callContext.value1 = object2;
                callContext.value2 = object3;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
        }
        return super.match2(moduleMethod, object2, object3, callContext);
    }

    public int match3(ModuleMethod moduleMethod, Object object2, Object object3, Object object4, CallContext callContext) {
        switch (moduleMethod.selector) {
            case 79: {
                callContext.value1 = object2;
                callContext.value2 = object3;
                Object object5 = Promise.force(object4, Procedure.class);
                if (LangObjType.coerceToProcedureOrNull(object5) == null) {
                    return -786429;
                }
                callContext.value3 = object5;
                callContext.proc = moduleMethod;
                callContext.pc = 3;
                return 0;
            }
            case 75: {
                callContext.value1 = object2;
                callContext.value2 = object3;
                Object object6 = Promise.force(object4, Procedure.class);
                if (LangObjType.coerceToProcedureOrNull(object6) == null) {
                    return -786429;
                }
                callContext.value3 = object6;
                callContext.proc = moduleMethod;
                callContext.pc = 3;
                return 0;
            }
            case 67: {
                callContext.value1 = object2;
                callContext.value2 = Promise.force(object3);
                callContext.value3 = object4;
                callContext.proc = moduleMethod;
                callContext.pc = 3;
                return 0;
            }
        }
        return super.match3(moduleMethod, object2, object3, object4, callContext);
    }

    public void apply(CallContext callContext) {
        ModuleMethod.applyError();
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public Object apply1(ModuleMethod moduleMethod, Object object2) {
        switch (moduleMethod.selector) {
            case 1: {
                Boolean bl;
                if (lists.isPair(object2)) {
                    bl = Boolean.TRUE;
                    return bl;
                }
                bl = Boolean.FALSE;
                return bl;
            }
            case 3: {
                Boolean bl;
                if (lists.isNull(object2)) {
                    bl = Boolean.TRUE;
                    return bl;
                }
                bl = Boolean.FALSE;
                return bl;
            }
            case 64: {
                return lists.length(Sequences.coerceToSequence(Promise.force(object2, List.class)));
            }
            case 65: {
                return lists.reverse((LList)Promise.force(object2, LList.class));
            }
            case 69: {
                Boolean bl;
                if (lists.isList(object2)) {
                    bl = Boolean.TRUE;
                    return bl;
                }
                bl = Boolean.FALSE;
                return bl;
            }
            case 70: {
                return lists.makeList(((Number)Promise.force(object2)).intValue());
            }
            case 72: {
                return lists.reverse$Ex((LList)Promise.force(object2, LList.class));
            }
            case 81: {
                return lists.listCopy(object2);
            }
            case 6: {
                return lists.car((Pair)Promise.force(object2, Pair.class));
            }
            case 7: {
                return lists.cdr((Pair)Promise.force(object2, Pair.class));
            }
            case 8: {
                return lists.caar(object2);
            }
            case 10: {
                return lists.cadr(object2);
            }
            case 12: {
                return lists.cdar(object2);
            }
            case 14: {
                return lists.cddr(object2);
            }
            case 16: {
                return lists.caaar(object2);
            }
            case 18: {
                return lists.caadr(object2);
            }
            case 20: {
                return lists.cadar(object2);
            }
            case 22: {
                return lists.caddr(object2);
            }
            case 24: {
                return lists.cdaar(object2);
            }
            case 26: {
                return lists.cdadr(object2);
            }
            case 28: {
                return lists.cddar(object2);
            }
            case 30: {
                return lists.cdddr(object2);
            }
            case 32: {
                return lists.caaaar(object2);
            }
            case 34: {
                return lists.caaadr(object2);
            }
            case 36: {
                return lists.caadar(object2);
            }
            case 38: {
                return lists.caaddr(object2);
            }
            case 40: {
                return lists.cadaar(object2);
            }
            case 42: {
                return lists.cadadr(object2);
            }
            case 44: {
                return lists.caddar(object2);
            }
            case 46: {
                return lists.cadddr(object2);
            }
            case 48: {
                return lists.cdaaar(object2);
            }
            case 50: {
                return lists.cdaadr(object2);
            }
            case 52: {
                return lists.cdadar(object2);
            }
            case 54: {
                return lists.cdaddr(object2);
            }
            case 56: {
                return lists.cddaar(object2);
            }
            case 58: {
                return lists.cddadr(object2);
            }
            case 60: {
                return lists.cdddar(object2);
            }
            case 62: {
                return lists.cddddr(object2);
            }
        }
        return super.apply1(moduleMethod, object2);
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "length", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "reverse", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "make-list", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "reverse!", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "car", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "cdr", 1, object2);
        }
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public Object apply2(ModuleMethod moduleMethod, Object object2, Object object3) {
        switch (moduleMethod.selector) {
            case 2: {
                return lists.cons(object2, object3);
            }
            case 4: {
                lists.setCar$Ex((Pair)Promise.force(object2, Pair.class), object3);
                return Values.empty;
            }
            case 5: {
                lists.setCdr$Ex((Pair)Promise.force(object2, Pair.class), object3);
                return Values.empty;
            }
            case 9: {
                lists.lambda1(object2, object3);
                return Values.empty;
            }
            case 11: {
                lists.lambda2(object2, object3);
                return Values.empty;
            }
            case 13: {
                lists.lambda3(object2, object3);
                return Values.empty;
            }
            case 15: {
                lists.lambda4(object2, object3);
                return Values.empty;
            }
            case 17: {
                lists.lambda5(object2, object3);
                return Values.empty;
            }
            case 19: {
                lists.lambda6(object2, object3);
                return Values.empty;
            }
            case 21: {
                lists.lambda7(object2, object3);
                return Values.empty;
            }
            case 23: {
                lists.lambda8(object2, object3);
                return Values.empty;
            }
            case 25: {
                lists.lambda9(object2, object3);
                return Values.empty;
            }
            case 27: {
                lists.lambda10(object2, object3);
                return Values.empty;
            }
            case 29: {
                lists.lambda11(object2, object3);
                return Values.empty;
            }
            case 31: {
                lists.lambda12(object2, object3);
                return Values.empty;
            }
            case 33: {
                lists.lambda13(object2, object3);
                return Values.empty;
            }
            case 35: {
                lists.lambda14(object2, object3);
                return Values.empty;
            }
            case 37: {
                lists.lambda15(object2, object3);
                return Values.empty;
            }
            case 39: {
                lists.lambda16(object2, object3);
                return Values.empty;
            }
            case 41: {
                lists.lambda17(object2, object3);
                return Values.empty;
            }
            case 43: {
                lists.lambda18(object2, object3);
                return Values.empty;
            }
            case 45: {
                lists.lambda19(object2, object3);
                return Values.empty;
            }
            case 47: {
                lists.lambda20(object2, object3);
                return Values.empty;
            }
            case 49: {
                lists.lambda21(object2, object3);
                return Values.empty;
            }
            case 51: {
                lists.lambda22(object2, object3);
                return Values.empty;
            }
            case 53: {
                lists.lambda23(object2, object3);
                return Values.empty;
            }
            case 55: {
                lists.lambda24(object2, object3);
                return Values.empty;
            }
            case 57: {
                lists.lambda25(object2, object3);
                return Values.empty;
            }
            case 59: {
                lists.lambda26(object2, object3);
                return Values.empty;
            }
            case 61: {
                lists.lambda27(object2, object3);
                return Values.empty;
            }
            case 63: {
                lists.lambda28(object2, object3);
                return Values.empty;
            }
            case 66: {
                return lists.listTail(object2, ((Number)Promise.force(object3)).intValue());
            }
            case 70: {
                return lists.makeList(((Number)Promise.force(object2)).intValue(), object3);
            }
            case 73: {
                return lists.memq(object2, object3);
            }
            case 74: {
                return lists.memv(object2, object3);
            }
            case 75: {
                return lists.member(object2, object3);
            }
            case 77: {
                return lists.assq(object2, object3);
            }
            case 78: {
                return lists.assv(object2, object3);
            }
            case 79: {
                return lists.assoc(object2, object3);
            }
            case 68: {
                return lists.listRef(object2, ((Number)Promise.force(object3)).intValue());
            }
        }
        return super.apply2(moduleMethod, object2, object3);
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "set-car!", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "set-cdr!", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "list-tail", 2, object3);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "make-list", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "list-ref", 2, object3);
        }
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public Object apply3(ModuleMethod moduleMethod, Object object2, Object object3, Object object4) {
        switch (moduleMethod.selector) {
            case 67: {
                lists.listSet$Ex(object2, ((Number)Promise.force(object3)).intValue(), object4);
                return Values.empty;
            }
            case 75: {
                return lists.member(object2, object3, LangObjType.coerceToProcedure(Promise.force(object4, Procedure.class)));
            }
            case 79: {
                return lists.assoc(object2, object3, LangObjType.coerceToProcedure(Promise.force(object4, Procedure.class)));
            }
        }
        return super.apply3(moduleMethod, object2, object3, object4);
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "list-set!", 2, object3);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "member", 3, object4);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "assoc", 3, object4);
        }
    }
}

