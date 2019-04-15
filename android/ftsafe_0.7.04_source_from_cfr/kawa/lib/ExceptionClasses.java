/*
 * Decompiled with CFR 0.139.
 */
package kawa.lib;

import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.lists.Consumer;
import gnu.mapping.CallContext;
import kawa.lib.ExceptionWithValue;
import kawa.lib.HandlerLink;

public class ExceptionClasses
extends ModuleBody {
    public static ThreadLocal<HandlerLink> current$Mnhandler;
    public static final Class HandlerLink;
    public static final Class ExceptionWithValue;
    public static ExceptionClasses $instance;

    private static void $runBody$() {
        CallContext $ctx = CallContext.getInstance();
        Consumer $result = $ctx.consumer;
        ThreadLocal threadLocal = new ThreadLocal();
        current$Mnhandler = threadLocal;
    }

    public static {
        $instance = new ExceptionClasses();
        HandlerLink = HandlerLink.class;
        ExceptionWithValue = ExceptionWithValue.class;
        ExceptionClasses.$runBody$();
    }

    public ExceptionClasses() {
        ModuleInfo.register(this);
    }
}

