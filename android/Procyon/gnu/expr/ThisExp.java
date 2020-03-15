// 
// Decompiled by Procyon v0.5.36
// 

package gnu.expr;

import gnu.bytecode.CodeAttr;
import gnu.bytecode.Type;
import gnu.bytecode.ClassType;
import gnu.mapping.CallContext;

public class ThisExp extends ReferenceExp
{
    public static final String THIS_NAME;
    static int EVAL_TO_CONTEXT;
    ScopeExp context;
    
    public final boolean isForContext() {
        return (this.flags & ThisExp.EVAL_TO_CONTEXT) != 0x0;
    }
    
    @Override
    public void apply(final CallContext ctx) throws Throwable {
        if (this.isForContext()) {
            ctx.writeValue(this.context);
        }
        else {
            super.apply(ctx);
        }
    }
    
    public ScopeExp getContextScope() {
        return this.context;
    }
    
    public ThisExp() {
        super((Object)ThisExp.THIS_NAME);
    }
    
    public ThisExp(final ScopeExp context) {
        this();
        this.context = context;
    }
    
    public ThisExp(final Declaration binding) {
        super(ThisExp.THIS_NAME, binding);
    }
    
    public ThisExp(final ClassType type) {
        this(new Declaration(ThisExp.THIS_NAME, type));
    }
    
    public static ThisExp makeGivingContext(final ScopeExp context) {
        final ThisExp thisExp;
        final ThisExp exp = thisExp = new ThisExp(context);
        thisExp.flags |= ThisExp.EVAL_TO_CONTEXT;
        return exp;
    }
    
    @Override
    public void compile(final Compilation comp, final Target target) {
        if (target instanceof IgnoreTarget) {
            return;
        }
        if (this.isForContext()) {
            final CodeAttr code = comp.getCode();
            final ModuleExp module;
            if (this.context instanceof ModuleExp && (module = (ModuleExp)this.context).staticInitRun()) {
                code.emitPushString(module.getMinfo().getClassName());
            }
            else if (comp.method.getStaticFlag()) {
                code.emitGetStatic(comp.moduleInstanceMainField);
            }
            else {
                code.emitPushThis();
            }
            target.compileFromStack(comp, this.getType());
        }
        else {
            super.compile(comp, target);
        }
    }
    
    @Override
    protected <R, D> R visit(final ExpVisitor<R, D> visitor, final D d) {
        return visitor.visitThisExp(this, d);
    }
    
    @Override
    protected final Type calculateType() {
        if (this.binding != null) {
            return this.binding.getType();
        }
        if (this.context instanceof ClassExp || this.context instanceof ModuleExp) {
            return this.context.getType();
        }
        return Type.pointer_type;
    }
    
    static {
        THIS_NAME = new String("$this$");
        ThisExp.EVAL_TO_CONTEXT = 4;
    }
}
