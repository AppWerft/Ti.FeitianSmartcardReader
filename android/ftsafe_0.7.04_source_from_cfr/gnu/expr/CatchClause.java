/*
 * Decompiled with CFR 0.139.
 */
package gnu.expr;

import gnu.bytecode.ClassType;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.Scope;
import gnu.bytecode.Type;
import gnu.bytecode.Variable;
import gnu.expr.Compilation;
import gnu.expr.Declaration;
import gnu.expr.ExpVisitor;
import gnu.expr.Expression;
import gnu.expr.LambdaExp;
import gnu.expr.LetExp;
import gnu.expr.QuoteExp;
import gnu.expr.Target;
import gnu.kawa.io.OutPort;
import gnu.mapping.CallContext;

public class CatchClause
extends LetExp {
    CatchClause next;

    public CatchClause() {
    }

    public CatchClause(Declaration decl, Expression body) {
        decl.setInitValue(QuoteExp.undefined_exp);
        this.add(decl);
        this.body = body;
    }

    public CatchClause(Object name, Type type, Expression body) {
        this(new Declaration(name, type), body);
    }

    public CatchClause(LambdaExp lexp) {
        this();
        Declaration decl = lexp.firstDecl();
        decl.setInitValue(QuoteExp.undefined_exp);
        lexp.remove(null, decl);
        this.add(decl);
        this.body = lexp.body;
    }

    public final CatchClause getNext() {
        return this.next;
    }

    public final void setNext(CatchClause next) {
        this.next = next;
    }

    @Override
    public final Expression getBody() {
        return this.body;
    }

    @Override
    public final void setBody(Expression body) {
        this.body = body;
    }

    @Override
    protected boolean mustCompile() {
        return false;
    }

    @Override
    protected Object evalVariable(Declaration decl, CallContext ctx) throws Throwable {
        return ctx.value1;
    }

    @Override
    public void compile(Compilation comp, Target target) {
        CodeAttr code = comp.getCode();
        Declaration catchDecl = this.firstDecl();
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
    protected <R, D> void visitChildren(ExpVisitor<R, D> visitor, D d) {
        this.body = visitor.visitAndUpdate(this.body, d);
    }

    @Override
    public void print(OutPort out) {
        out.writeSpaceLinear();
        out.startLogicalBlock("(Catch", ")", 2);
        out.writeSpaceFill();
        this.decls.printInfo(out);
        out.writeSpaceLinear();
        this.body.print(out);
        out.endLogicalBlock(")");
    }
}

