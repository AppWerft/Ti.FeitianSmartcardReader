/*
 * Decompiled with CFR 0.139.
 */
package gnu.expr;

import gnu.bytecode.ClassType;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.Field;
import gnu.bytecode.Method;
import gnu.bytecode.Type;
import gnu.expr.ClassExp;
import gnu.expr.Compilation;
import gnu.expr.Declaration;
import gnu.expr.ExpVisitor;
import gnu.expr.IgnoreTarget;
import gnu.expr.ModuleExp;
import gnu.expr.ModuleInfo;
import gnu.expr.ReferenceExp;
import gnu.expr.ScopeExp;
import gnu.expr.Target;
import gnu.mapping.CallContext;

public class ThisExp
extends ReferenceExp {
    public static final String THIS_NAME = new String("$this$");
    static int EVAL_TO_CONTEXT = 4;
    ScopeExp context;

    public final boolean isForContext() {
        return (this.flags & EVAL_TO_CONTEXT) != 0;
    }

    @Override
    public void apply(CallContext ctx) throws Throwable {
        if (this.isForContext()) {
            ctx.writeValue(this.context);
        } else {
            super.apply(ctx);
        }
    }

    public ScopeExp getContextScope() {
        return this.context;
    }

    public ThisExp() {
        super(THIS_NAME);
    }

    public ThisExp(ScopeExp context) {
        this();
        this.context = context;
    }

    public ThisExp(Declaration binding) {
        super(THIS_NAME, binding);
    }

    public ThisExp(ClassType type) {
        this(new Declaration((Object)THIS_NAME, type));
    }

    public static ThisExp makeGivingContext(ScopeExp context) {
        ThisExp exp = new ThisExp(context);
        exp.flags |= EVAL_TO_CONTEXT;
        return exp;
    }

    @Override
    public void compile(Compilation comp, Target target) {
        if (target instanceof IgnoreTarget) {
            return;
        }
        if (this.isForContext()) {
            ModuleExp module;
            CodeAttr code = comp.getCode();
            if (this.context instanceof ModuleExp && (module = (ModuleExp)this.context).staticInitRun()) {
                code.emitPushString(module.getMinfo().getClassName());
            } else if (comp.method.getStaticFlag()) {
                code.emitGetStatic(comp.moduleInstanceMainField);
            } else {
                code.emitPushThis();
            }
            target.compileFromStack(comp, this.getType());
        } else {
            super.compile(comp, target);
        }
    }

    @Override
    protected <R, D> R visit(ExpVisitor<R, D> visitor, D d) {
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
}

