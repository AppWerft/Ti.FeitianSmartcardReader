/*
 * Decompiled with CFR 0.139.
 */
package gnu.expr;

import gnu.bytecode.ClassType;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.Method;
import gnu.bytecode.PrimType;
import gnu.bytecode.Scope;
import gnu.bytecode.Type;
import gnu.bytecode.Variable;
import gnu.expr.BindingInitializer;
import gnu.expr.CheckedTarget;
import gnu.expr.Compilation;
import gnu.expr.Declaration;
import gnu.expr.ExpVisitor;
import gnu.expr.Expression;
import gnu.expr.QuoteExp;
import gnu.expr.ScopeExp;
import gnu.expr.Target;
import gnu.kawa.io.OutPort;
import gnu.mapping.CallContext;
import gnu.mapping.Location;

public class LetExp
extends ScopeExp {
    Expression body;
    public static final int IS_BODY_SCOPE = 2;

    public Expression getBody() {
        return this.body;
    }

    public void setBody(Expression body) {
        this.body = body;
    }

    @Override
    protected boolean mustCompile() {
        return false;
    }

    protected Object evalVariable(Declaration decl, CallContext ctx) throws Throwable {
        return decl.getInitValue().eval(ctx);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void apply(CallContext ctx) throws Throwable {
        this.setIndexes();
        int level = ScopeExp.nesting(this);
        int i = this.frameSize;
        Object[] evalFrame = new Object[i];
        Object[][] evalFrames = ctx.evalFrames;
        if (evalFrames == null) {
            ctx.evalFrames = evalFrames = new Object[level + 10][];
        } else if (level >= evalFrames.length) {
            Object[][] newFrames = new Object[level + 10][];
            System.arraycopy(evalFrames, 0, newFrames, 0, evalFrames.length);
            ctx.evalFrames = evalFrames = newFrames;
        }
        Object[] oldFrame = evalFrames[level];
        evalFrames[level] = evalFrame;
        try {
            i = 0;
            Declaration decl = this.firstDecl();
            while (decl != null) {
                if (decl.getInitValue() != QuoteExp.undefined_exp) {
                    Object value = this.evalVariable(decl, ctx);
                    Type type = decl.type;
                    if (type != null && type != Type.pointer_type) {
                        value = type.coerceFromObject(value);
                    }
                    if (decl.isIndirectBinding()) {
                        Location loc = decl.makeIndirectLocationFor();
                        loc.set(value);
                        value = loc;
                    }
                    evalFrame[i] = value;
                }
                decl = decl.nextDecl();
                ++i;
            }
            this.body.apply(ctx);
        }
        finally {
            evalFrames[level] = oldFrame;
        }
    }

    @Override
    public void compile(Compilation comp, Target target) {
        CodeAttr code = comp.getCode();
        for (Declaration decl = this.firstDecl(); decl != null; decl = decl.nextDecl()) {
            boolean needsInit;
            Target varTarget;
            Expression init = decl.getInitValue();
            boolean initialized = init != QuoteExp.undefined_exp;
            boolean bl = needsInit = !decl.ignorable() && (initialized || decl.mayBeAccessedUninitialized());
            if (needsInit && decl.isSimple()) {
                decl.allocateVariable(code);
            }
            if (!needsInit || !initialized && (decl.isIndirectBinding() || !decl.mayBeAccessedUninitialized())) {
                varTarget = Target.Ignore;
            } else {
                Type varType = decl.getType();
                varTarget = CheckedTarget.getInstance(decl);
                if (init == QuoteExp.undefined_exp) {
                    if (varType instanceof PrimType) {
                        init = new QuoteExp(new Byte(0));
                    } else if (varType != null && varType != Type.pointer_type) {
                        init = QuoteExp.nullExp;
                    }
                }
            }
            init.compileWithPosition(comp, varTarget);
            if (!needsInit) continue;
            if (decl.isIndirectBinding()) {
                if (!initialized) {
                    Object name = decl.getSymbol();
                    comp.compileConstant(name, Target.pushObject);
                    code.emitInvokeStatic(BindingInitializer.makeLocationMethod(name));
                } else {
                    decl.pushIndirectBinding(comp);
                }
            }
            if (decl.getFlag(0x8000000000L)) {
                decl.evalIndex = code.getSP();
                continue;
            }
            if (!initialized && !decl.isIndirectBinding() && !decl.mayBeAccessedUninitialized()) continue;
            decl.compileStore(comp);
        }
        code.enterScope(this.getVarScope());
        this.body.compileWithPosition(comp, target);
        this.popScope(code);
    }

    @Override
    protected final Type calculateType() {
        return this.body.getType();
    }

    @Override
    protected <R, D> R visit(ExpVisitor<R, D> visitor, D d) {
        return visitor.visitLetExp(this, d);
    }

    public <R, D> void visitInitializers(ExpVisitor<R, D> visitor, D d) {
        for (Declaration decl = this.firstDecl(); decl != null; decl = decl.nextDecl()) {
            decl.setInitValue(visitor.visitAndUpdate(decl.getInitValue(), d));
        }
    }

    @Override
    protected <R, D> void visitChildren(ExpVisitor<R, D> visitor, D d) {
        this.visitInitializers(visitor, d);
        if (visitor.exitValue == null) {
            this.body = visitor.visitAndUpdate(this.body, d);
        }
    }

    @Override
    public void print(OutPort out) {
        this.print(out, "(Let", ")");
    }

    public void print(OutPort out, String startTag, String endTag) {
        out.startLogicalBlock(startTag + "#" + this.id, endTag, 2);
        out.writeSpaceFill();
        this.printLineColumn(out);
        out.startLogicalBlock("(", false, ")");
        int i = 0;
        for (Declaration decl = this.firstDecl(); decl != null; decl = decl.nextDecl()) {
            if (i > 0) {
                out.writeSpaceFill();
            }
            out.startLogicalBlock("(", false, ")");
            decl.printInfo(out);
            Expression init = decl.getInitValue();
            if (init != null) {
                out.writeSpaceFill();
                out.print('=');
                out.writeSpaceFill();
                if (init == null) {
                    out.print("<null>");
                } else {
                    init.print(out);
                }
                ++i;
            }
            out.endLogicalBlock(")");
        }
        out.endLogicalBlock(")");
        out.writeSpaceLinear();
        if (this.body == null) {
            out.print("<null body>");
        } else {
            this.body.print(out);
        }
        out.endLogicalBlock(endTag);
    }
}

