// 
// Decompiled by Procyon v0.5.36
// 

package gnu.expr;

import gnu.mapping.CallContext;

public class ModuleMethodWithContext extends ModuleMethod
{
    public ModuleMethodWithContext(final ModuleBody module, final int selector, final Object name, final int numArgs) {
        super(module, selector, name, numArgs);
    }
    
    public ModuleMethodWithContext(final ModuleBody module, final int selector, final Object name, final int numArgs, final Object argTypes) {
        super(module, selector, name, numArgs, argTypes);
    }
    
    @Override
    public void apply(final CallContext ctx) throws Throwable {
        ctx.pc = this.selector;
        this.module.apply(ctx);
    }
    
    @Override
    public Object apply0() throws Throwable {
        final CallContext ctx = CallContext.getInstance();
        this.check0(ctx);
        return ctx.runUntilValue();
    }
    
    @Override
    public Object apply1(final Object arg1) throws Throwable {
        final CallContext ctx = CallContext.getInstance();
        this.check1(arg1, ctx);
        return ctx.runUntilValue();
    }
    
    @Override
    public Object apply2(final Object arg1, final Object arg2) throws Throwable {
        final CallContext ctx = CallContext.getInstance();
        this.check2(arg1, arg2, ctx);
        return ctx.runUntilValue();
    }
    
    @Override
    public Object apply3(final Object arg1, final Object arg2, final Object arg3) throws Throwable {
        final CallContext ctx = CallContext.getInstance();
        this.check3(arg1, arg2, arg3, ctx);
        return ctx.runUntilValue();
    }
    
    @Override
    public Object apply4(final Object arg1, final Object arg2, final Object arg3, final Object arg4) throws Throwable {
        final CallContext ctx = CallContext.getInstance();
        this.check4(arg1, arg2, arg3, arg4, ctx);
        return ctx.runUntilValue();
    }
    
    @Override
    public Object applyN(final Object[] args) throws Throwable {
        final CallContext ctx = CallContext.getInstance();
        this.checkN(args, ctx);
        return ctx.runUntilValue();
    }
}
