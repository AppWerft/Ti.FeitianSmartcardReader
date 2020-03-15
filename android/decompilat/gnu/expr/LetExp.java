// 
// Decompiled by Procyon v0.5.36
// 

package gnu.expr;

import gnu.kawa.io.OutPort;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.PrimType;
import gnu.mapping.Location;
import gnu.bytecode.Type;
import gnu.mapping.CallContext;

public class LetExp extends ScopeExp
{
    Expression body;
    public static final int IS_BODY_SCOPE = 2;
    
    public Expression getBody() {
        return this.body;
    }
    
    public void setBody(final Expression body) {
        this.body = body;
    }
    
    @Override
    protected boolean mustCompile() {
        return false;
    }
    
    protected Object evalVariable(final Declaration decl, final CallContext ctx) throws Throwable {
        return decl.getInitValue().eval(ctx);
    }
    
    @Override
    public void apply(final CallContext ctx) throws Throwable {
        this.setIndexes();
        final int level = ScopeExp.nesting(this);
        int i = this.frameSize;
        final Object[] evalFrame = new Object[i];
        Object[][] evalFrames = ctx.evalFrames;
        if (evalFrames == null) {
            evalFrames = new Object[level + 10][];
            ctx.evalFrames = evalFrames;
        }
        else if (level >= evalFrames.length) {
            final Object[][] newFrames = new Object[level + 10][];
            System.arraycopy(evalFrames, 0, newFrames, 0, evalFrames.length);
            evalFrames = (ctx.evalFrames = newFrames);
        }
        final Object[] oldFrame = evalFrames[level];
        evalFrames[level] = evalFrame;
        try {
            i = 0;
            for (Declaration decl = this.firstDecl(); decl != null; decl = decl.nextDecl(), ++i) {
                if (decl.getInitValue() != QuoteExp.undefined_exp) {
                    Object value = this.evalVariable(decl, ctx);
                    final Type type = decl.type;
                    if (type != null && type != Type.pointer_type) {
                        value = type.coerceFromObject(value);
                    }
                    if (decl.isIndirectBinding()) {
                        final Location loc = decl.makeIndirectLocationFor();
                        loc.set(value);
                        value = loc;
                    }
                    evalFrame[i] = value;
                }
            }
            this.body.apply(ctx);
        }
        finally {
            evalFrames[level] = oldFrame;
        }
    }
    
    @Override
    public void compile(final Compilation comp, final Target target) {
        final CodeAttr code = comp.getCode();
        for (Declaration decl = this.firstDecl(); decl != null; decl = decl.nextDecl()) {
            Expression init = decl.getInitValue();
            final boolean initialized = init != QuoteExp.undefined_exp;
            final boolean needsInit = !decl.ignorable() && (initialized || decl.mayBeAccessedUninitialized());
            if (needsInit && decl.isSimple()) {
                decl.allocateVariable(code);
            }
            Target varTarget;
            if (!needsInit || (!initialized && (decl.isIndirectBinding() || !decl.mayBeAccessedUninitialized()))) {
                varTarget = Target.Ignore;
            }
            else {
                final Type varType = decl.getType();
                varTarget = CheckedTarget.getInstance(decl);
                if (init == QuoteExp.undefined_exp) {
                    if (varType instanceof PrimType) {
                        init = new QuoteExp(new Byte((byte)0));
                    }
                    else if (varType != null && varType != Type.pointer_type) {
                        init = QuoteExp.nullExp;
                    }
                }
            }
            init.compileWithPosition(comp, varTarget);
            if (needsInit) {
                if (decl.isIndirectBinding()) {
                    if (!initialized) {
                        final Object name = decl.getSymbol();
                        comp.compileConstant(name, Target.pushObject);
                        code.emitInvokeStatic(BindingInitializer.makeLocationMethod(name));
                    }
                    else {
                        decl.pushIndirectBinding(comp);
                    }
                }
                if (decl.getFlag(549755813888L)) {
                    decl.evalIndex = code.getSP();
                }
                else if (initialized || decl.isIndirectBinding() || decl.mayBeAccessedUninitialized()) {
                    decl.compileStore(comp);
                }
            }
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
    protected <R, D> R visit(final ExpVisitor<R, D> visitor, final D d) {
        return visitor.visitLetExp(this, d);
    }
    
    public <R, D> void visitInitializers(final ExpVisitor<R, D> visitor, final D d) {
        for (Declaration decl = this.firstDecl(); decl != null; decl = decl.nextDecl()) {
            decl.setInitValue(visitor.visitAndUpdate(decl.getInitValue(), d));
        }
    }
    
    @Override
    protected <R, D> void visitChildren(final ExpVisitor<R, D> visitor, final D d) {
        this.visitInitializers((ExpVisitor<Object, Object>)visitor, d);
        if (visitor.exitValue == null) {
            this.body = visitor.visitAndUpdate(this.body, d);
        }
    }
    
    @Override
    public void print(final OutPort out) {
        this.print(out, "(Let", ")");
    }
    
    public void print(final OutPort out, final String startTag, final String endTag) {
        out.startLogicalBlock(startTag + "#" + this.id, endTag, 2);
        out.writeSpaceFill();
        this.printLineColumn(out);
        out.startLogicalBlock("(", false, ")");
        Declaration decl = this.firstDecl();
        int i = 0;
        while (decl != null) {
            if (i > 0) {
                out.writeSpaceFill();
            }
            out.startLogicalBlock("(", false, ")");
            decl.printInfo(out);
            final Expression init = decl.getInitValue();
            if (init != null) {
                out.writeSpaceFill();
                out.print('=');
                out.writeSpaceFill();
                if (init == null) {
                    out.print("<null>");
                }
                else {
                    init.print(out);
                }
                ++i;
            }
            out.endLogicalBlock(")");
            decl = decl.nextDecl();
        }
        out.endLogicalBlock(")");
        out.writeSpaceLinear();
        if (this.body == null) {
            out.print("<null body>");
        }
        else {
            this.body.print(out);
        }
        out.endLogicalBlock(endTag);
    }
}
