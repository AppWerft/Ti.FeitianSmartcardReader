/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.slib;

import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.kawa.reflect.StaticFieldLocation;
import gnu.lists.Consumer;
import gnu.mapping.CallContext;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Symbol;
import kawa.lang.Macro;
import kawa.lang.SyntaxPattern;
import kawa.lang.SyntaxRule;
import kawa.lang.SyntaxRules;

public class receive
extends ModuleBody {
    public static final StaticFieldLocation $Prvt$call$Mnwith$Mnvalues;
    public static final StaticFieldLocation $Prvt$lambda;
    public static final Macro receive;
    public static receive $instance;
    static final SimpleSymbol Lit0;
    static final SyntaxRules Lit1;
    static final Object[] Lit2;

    private static void $runBody$() {
        CallContext $ctx = CallContext.getInstance();
        Consumer $result = $ctx.consumer;
    }

    public static {
        Lit2 = new Object[0];
        Lit0 = Symbol.valueOf("receive");
        Lit1 = new SyntaxRules(Lit2, new SyntaxRule[]{new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\f\u000f\r\u0017\u0010\b\b", Lit2, 3, "receive.scm:22"), "\u0001\u0001\u0003", "\u0011\u0018\u00049\u0011\u0018\f\t\u0010\b\u000b\b\u0011\u0018\f\t\u0003\b\u0015\u0013", new Object[]{Symbol.valueOf("call-with-values"), Symbol.valueOf("lambda")}, 1)}, 3, Lit0);
        $instance = new receive();
        $Prvt$call$Mnwith$Mnvalues = StaticFieldLocation.make("gnu.kawa.functions.CallWithValues", "callWithValues");
        $Prvt$lambda = StaticFieldLocation.make("kawa.standard.SchemeCompilation", "lambda");
        receive = Macro.make(Lit0, Lit1, "gnu.kawa.slib.receive");
        receive.$runBody$();
    }

    public receive() {
        ModuleInfo.register(this);
    }
}

