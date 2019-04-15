/*
 * Decompiled with CFR 0.139.
 */
package gnu.expr;

import gnu.expr.ModuleBody;
import gnu.expr.ModuleMethod;
import gnu.mapping.CallContext;

public class ModuleMethodWithContext
extends ModuleMethod {
    public ModuleMethodWithContext(ModuleBody module, int selector, Object name, int numArgs) {
        super(module, selector, name, numArgs);
    }

    public ModuleMethodWithContext(ModuleBody module, int selector, Object name, int numArgs, Object argTypes) {
        super(module, selector, name, numArgs, argTypes);
    }

    @Override
    public void apply(CallContext ctx) throws Throwable {
        ctx.pc = this.selector;
        this.module.apply(ctx);
    }

    @Override
    public Object apply0() throws Throwable {
        CallContext ctx = CallContext.getInstance();
        this.check0(ctx);
        return ctx.runUntilValue();
    }

    @Override
    public Object apply1(Object arg1) throws Throwable {
        CallContext ctx = CallContext.getInstance();
        this.check1(arg1, ctx);
        return ctx.runUntilValue();
    }

    @Override
    public Object apply2(Object arg1, Object arg2) throws Throwable {
        CallContext ctx = CallContext.getInstance();
        this.check2(arg1, arg2, ctx);
        return ctx.runUntilValue();
    }

    @Override
    public Object apply3(Object arg1, Object arg2, Object arg3) throws Throwable {
        CallContext ctx = CallContext.getInstance();
        this.check3(arg1, arg2, arg3, ctx);
        return ctx.runUntilValue();
    }

    @Override
    public Object apply4(Object arg1, Object arg2, Object arg3, Object arg4) throws Throwable {
        CallContext ctx = CallContext.getInstance();
        this.check4(arg1, arg2, arg3, arg4, ctx);
        return ctx.runUntilValue();
    }

    @Override
    public Object applyN(Object[] args) throws Throwable {
        CallContext ctx = CallContext.getInstance();
        this.checkN(args, ctx);
        return ctx.runUntilValue();
    }
}

