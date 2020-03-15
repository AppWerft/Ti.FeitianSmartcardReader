// 
// Decompiled by Procyon v0.5.36
// 

package gnu.expr;

import gnu.kawa.io.OutPort;
import gnu.bytecode.Type;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.ClassType;
import gnu.mapping.CallContext;

public class TryExp extends Expression
{
    Expression try_clause;
    CatchClause catch_clauses;
    Expression finally_clause;
    
    public final CatchClause getCatchClauses() {
        return this.catch_clauses;
    }
    
    public final Expression getFinallyClause() {
        return this.finally_clause;
    }
    
    public final void setCatchClauses(final CatchClause catch_clauses) {
        this.catch_clauses = catch_clauses;
    }
    
    public void addCatchClause(final Declaration decl, final Expression body) {
        final CatchClause clause = new CatchClause(decl, body);
        CatchClause last = this.catch_clauses;
        if (last == null) {
            this.catch_clauses = clause;
        }
        else {
            while (last.next != null) {
                last = last.next;
            }
            last.next = clause;
        }
    }
    
    public TryExp(final Expression try_clause, final Expression finally_clause) {
        this.try_clause = try_clause;
        this.finally_clause = finally_clause;
    }
    
    @Override
    protected boolean mustCompile() {
        return false;
    }
    
    @Override
    public void apply(final CallContext ctx) throws Throwable {
        try {
            this.try_clause.apply(ctx);
            ctx.runUntilDone();
        }
        catch (Throwable ex) {
            for (CatchClause clause = this.catch_clauses; clause != null; clause = clause.next) {
                final Declaration decl = clause.firstDecl();
                final ClassType typeVal = (ClassType)decl.getTypeExp().eval(ctx);
                if (typeVal.isInstance(ex)) {
                    ctx.value1 = ex;
                    clause.apply(ctx);
                    return;
                }
            }
            throw ex;
        }
        finally {
            if (this.finally_clause != null) {
                this.finally_clause.eval(ctx);
            }
        }
    }
    
    @Override
    public void compile(final Compilation comp, final Target target) {
        final CodeAttr code = comp.getCode();
        final boolean has_finally = this.finally_clause != null;
        Target ttarg;
        if (target instanceof StackTarget || target instanceof ConsumerTarget || target instanceof IgnoreTarget || (target instanceof ConditionalTarget && this.finally_clause == null)) {
            ttarg = target;
        }
        else {
            ttarg = Target.pushValue(target.getType());
        }
        code.emitTryStart(has_finally, (ttarg instanceof StackTarget) ? ttarg.getType() : null);
        this.try_clause.compileWithPosition(comp, ttarg);
        for (CatchClause catch_clause = this.catch_clauses; catch_clause != null; catch_clause = catch_clause.getNext()) {
            catch_clause.compile(comp, ttarg);
        }
        if (this.finally_clause != null) {
            code.emitFinallyStart();
            this.finally_clause.compileWithPosition(comp, Target.Ignore);
            code.emitFinallyEnd();
        }
        code.emitTryCatchEnd();
        if (ttarg != target) {
            target.compileFromStack(comp, target.getType());
        }
    }
    
    @Override
    protected <R, D> R visit(final ExpVisitor<R, D> visitor, final D d) {
        return visitor.visitTryExp(this, d);
    }
    
    @Override
    protected <R, D> void visitChildren(final ExpVisitor<R, D> visitor, final D d) {
        this.try_clause = visitor.visitAndUpdate(this.try_clause, d);
        for (CatchClause catch_clause = this.catch_clauses; visitor.exitValue == null && catch_clause != null; catch_clause = catch_clause.getNext()) {
            visitor.visit(catch_clause, d);
        }
        if (visitor.exitValue == null && this.finally_clause != null) {
            this.finally_clause = visitor.visitAndUpdate(this.finally_clause, d);
        }
    }
    
    @Override
    protected Type calculateType() {
        Type t = this.try_clause.getType();
        for (CatchClause clause = this.catch_clauses; clause != null; clause = clause.getNext()) {
            t = Language.unionType(t, clause.getType());
        }
        return t;
    }
    
    @Override
    public void print(final OutPort ps) {
        ps.startLogicalBlock("(Try", ")", 2);
        ps.writeSpaceFill();
        this.try_clause.print(ps);
        for (CatchClause catch_clause = this.catch_clauses; catch_clause != null; catch_clause = catch_clause.getNext()) {
            catch_clause.print(ps);
        }
        if (this.finally_clause != null) {
            ps.writeSpaceLinear();
            ps.print(" finally: ");
            this.finally_clause.print(ps);
        }
        ps.endLogicalBlock(")");
    }
}
