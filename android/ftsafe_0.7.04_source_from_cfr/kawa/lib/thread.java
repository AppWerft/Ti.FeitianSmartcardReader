/*
 * Decompiled with CFR 0.139.
 */
package kawa.lib;

import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.kawa.lispexpr.LangObjType;
import gnu.kawa.reflect.StaticFieldLocation;
import gnu.lists.Consumer;
import gnu.mapping.CallContext;
import gnu.mapping.Future;
import gnu.mapping.Procedure;
import gnu.mapping.Promise;
import gnu.mapping.RunnableClosure;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Symbol;
import gnu.mapping.Values;
import gnu.mapping.WrongType;
import gnu.math.Quantity;
import kawa.lang.Macro;
import kawa.lang.SyntaxPattern;
import kawa.lang.SyntaxRule;
import kawa.lang.SyntaxRules;
import kawa.standard.sleep;

public class thread
extends ModuleBody {
    public static final StaticFieldLocation $Prvt$lambda;
    public static final Macro future;
    public static final ModuleMethod sleep;
    public static final ModuleMethod runnable;
    public static final ModuleMethod $Prvt$$Pcmake$Mnfuture;
    public static thread $instance;
    static final SimpleSymbol Lit0;
    static final SimpleSymbol Lit1;
    static final SyntaxRules Lit2;
    static final SimpleSymbol Lit3;
    static final SimpleSymbol Lit4;
    static final Object[] Lit5;

    private static void $runBody$() {
        CallContext $ctx = CallContext.getInstance();
        Consumer $result = $ctx.consumer;
    }

    public static void sleep(Quantity time2) {
        sleep.sleep(time2);
    }

    public static Future $PcMakeFuture(Procedure p) {
        Future f = new Future(p);
        f.start();
        return f;
    }

    public static RunnableClosure runnable(Procedure p) {
        return new RunnableClosure(p);
    }

    public static {
        Lit5 = new Object[0];
        Lit4 = Symbol.valueOf("runnable");
        Lit3 = Symbol.valueOf("%make-future");
        Lit1 = Symbol.valueOf("future");
        Lit2 = new SyntaxRules(Lit5, new SyntaxRule[]{new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\b", Lit5, 1, "thread.scm:13"), "\u0001", "\u0011\u0018\u0004\b\u0011\u0018\f\t\u0010\b\u0003", new Object[]{Lit3, Symbol.valueOf("lambda")}, 0)}, 1, Lit1);
        Lit0 = Symbol.valueOf("sleep");
        $instance = new thread();
        $Prvt$lambda = StaticFieldLocation.make("kawa.standard.SchemeCompilation", "lambda");
        thread thread2 = $instance;
        sleep = new ModuleMethod(thread2, 1, Lit0, 4097);
        future = Macro.make(Lit1, Lit2, "kawa.lib.thread");
        $Prvt$$Pcmake$Mnfuture = new ModuleMethod(thread2, 2, Lit3, 4097);
        runnable = new ModuleMethod(thread2, 3, Lit4, 4097);
        thread.$runBody$();
    }

    public thread() {
        ModuleInfo.register(this);
    }

    public int match1(ModuleMethod moduleMethod, Object object2, CallContext callContext) {
        switch (moduleMethod.selector) {
            case 3: {
                Object object3 = Promise.force(object2, Procedure.class);
                if (LangObjType.coerceToProcedureOrNull(object3) == null) {
                    return -786431;
                }
                callContext.value1 = object3;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 2: {
                Object object4 = Promise.force(object2, Procedure.class);
                if (LangObjType.coerceToProcedureOrNull(object4) == null) {
                    return -786431;
                }
                callContext.value1 = object4;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 1: {
                Object object5 = Promise.force(object2, Quantity.class);
                if (!(object5 instanceof Quantity)) {
                    return -786431;
                }
                callContext.value1 = object5;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
        }
        return super.match1(moduleMethod, object2, callContext);
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
                thread.sleep((Quantity)Promise.force(object2, Quantity.class));
                return Values.empty;
            }
            case 2: {
                return thread.$PcMakeFuture(LangObjType.coerceToProcedure(Promise.force(object2, Procedure.class)));
            }
            case 3: {
                return thread.runnable(LangObjType.coerceToProcedure(Promise.force(object2, Procedure.class)));
            }
        }
        return super.apply1(moduleMethod, object2);
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "sleep", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "%make-future", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "runnable", 1, object2);
        }
    }
}

