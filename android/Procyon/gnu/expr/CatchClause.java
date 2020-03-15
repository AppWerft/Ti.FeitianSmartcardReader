// 
// Decompiled by Procyon v0.5.36
// 

package gnu.expr;

import gnu.kawa.io.OutPort;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.ClassType;
import gnu.mapping.CallContext;
import gnu.bytecode.Type;

public class CatchClause extends LetExp
{
    CatchClause next;
    
    public CatchClause() {
    }
    
    public CatchClause(final Declaration decl, final Expression body) {
        decl.setInitValue(QuoteExp.undefined_exp);
        this.add(decl);
        this.body = body;
    }
    
    public CatchClause(final Object name, final Type type, final Expression body) {
        this(new Declaration(name, type), body);
    }
    
    public CatchClause(final LambdaExp lexp) {
        this();
        final Declaration decl = lexp.firstDecl();
        decl.setInitValue(QuoteExp.undefined_exp);
        lexp.remove(null, decl);
        this.add(decl);
        this.body = lexp.body;
    }
    
    public final CatchClause getNext() {
        return this.next;
    }
    
    public final void setNext(final CatchClause next) {
        this.next = next;
    }
    
    @Override
    public final Expression getBody() {
        return this.body;
    }
    
    @Override
    public final void setBody(final Expression body) {
        this.body = body;
    }
    
    @Override
    protected boolean mustCompile() {
        return false;
    }
    
    @Override
    protected Object evalVariable(final Declaration decl, final CallContext ctx) throws Throwable {
        return ctx.value1;
    }
    
    @Override
    public void compile(final Compilation comp, final Target target) {
        final CodeAttr code = comp.getCode();
        final Declaration catchDecl = this.firstDecl();
        if (catchDecl.isSimple()) {
            catchDecl.allocateVariable(code);
        }
        code.enterScope(this.getVarScope());
        code.emitCatchStart((ClassType)catchDecl.getType());
        catchDecl.compileStore(comp);
        this.body.compileWithPosition(comp, target);
        code.emitCatchEnd();
        code.popScope();
    }
    
    @Override
    protected <R, D> void visitChildren(final ExpVisitor<R, D> visitor, final D d) {
        this.body = visitor.visitAndUpdate(this.body, d);
    }
    
    @Override
    public void print(final OutPort out) {
        out.writeSpaceLinear();
        out.startLogicalBlock("(Catch", ")", 2);
        out.writeSpaceFill();
        this.decls.printInfo(out);
        out.writeSpaceLinear();
        this.body.print(out);
        out.endLogicalBlock(")");
    }
}
