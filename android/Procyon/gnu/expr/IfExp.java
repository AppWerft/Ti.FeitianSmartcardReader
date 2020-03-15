// 
// Decompiled by Procyon v0.5.36
// 

package gnu.expr;

import gnu.kawa.io.OutPort;
import gnu.bytecode.Type;
import gnu.bytecode.Variable;
import gnu.bytecode.CodeAttr;
import gnu.mapping.Values;
import gnu.bytecode.Label;
import gnu.mapping.CallContext;

public class IfExp extends Expression
{
    Expression test;
    Expression then_clause;
    Expression else_clause;
    
    public IfExp(final Expression i, final Expression t, final Expression e) {
        this.test = i;
        this.then_clause = t;
        this.else_clause = e;
    }
    
    public Expression getTest() {
        return this.test;
    }
    
    public Expression getThenClause() {
        return this.then_clause;
    }
    
    public Expression getElseClause() {
        return this.else_clause;
    }
    
    protected final Language getLanguage() {
        return Language.getDefaultLanguage();
    }
    
    @Override
    protected boolean mustCompile() {
        return false;
    }
    
    @Override
    public void apply(final CallContext ctx) throws Throwable {
        if (this.getLanguage().isTrue(this.test.eval(ctx))) {
            this.then_clause.apply(ctx);
        }
        else if (this.else_clause != null) {
            this.else_clause.apply(ctx);
        }
    }
    
    Expression select(final boolean truth) {
        return truth ? this.then_clause : ((this.else_clause == null) ? QuoteExp.voidExp : this.else_clause);
    }
    
    @Override
    public void compile(final Compilation comp, final Target target) {
        compile(this.test, this.then_clause, (this.else_clause == null) ? QuoteExp.voidExp : this.else_clause, comp, target);
    }
    
    public static void compile(final Expression test, final Expression then_clause, final Expression else_clause, final Compilation comp, final Target target) {
        final Language language = comp.getLanguage();
        final CodeAttr code = comp.getCode();
        Label falseLabel = null;
        boolean falseInherited;
        if (target instanceof ConditionalTarget && else_clause instanceof QuoteExp) {
            falseInherited = true;
            final Object value = ((QuoteExp)else_clause).getValue();
            if (language.isTrue(value)) {
                falseLabel = ((ConditionalTarget)target).ifTrue;
            }
            else {
                falseLabel = ((ConditionalTarget)target).ifFalse;
            }
        }
        else {
            falseInherited = false;
        }
        if (falseLabel == null) {
            falseLabel = new Label(code);
        }
        boolean trueInherited;
        Label trueLabel;
        if (test == then_clause && target instanceof ConditionalTarget && then_clause instanceof ReferenceExp) {
            trueInherited = true;
            trueLabel = ((ConditionalTarget)target).ifTrue;
        }
        else {
            trueInherited = false;
            trueLabel = new Label(code);
        }
        final ConditionalTarget ctarget = new ConditionalTarget(trueLabel, falseLabel, language);
        if (trueInherited) {
            ctarget.trueBranchComesFirst = false;
        }
        test.compile(comp, ctarget);
        code.emitIfThen();
        if (!trueInherited && trueLabel.isUsed()) {
            trueLabel.define(code);
            final Variable callContextSave = comp.callContextVar;
            then_clause.compileWithPosition(comp, target);
            comp.callContextVar = callContextSave;
        }
        if (!falseInherited) {
            code.emitElse();
            if (falseLabel.isUsed()) {
                falseLabel.define(code);
                final Variable callContextSave = comp.callContextVar;
                if (else_clause == null) {
                    comp.compileConstant(Values.empty, target);
                }
                else {
                    else_clause.compileWithPosition(comp, target);
                }
                comp.callContextVar = callContextSave;
            }
            else {
                code.setUnreachable();
            }
        }
        code.emitFi();
    }
    
    @Override
    protected <R, D> R visit(final ExpVisitor<R, D> visitor, final D d) {
        return visitor.visitIfExp(this, d);
    }
    
    @Override
    protected <R, D> void visitChildren(final ExpVisitor<R, D> visitor, final D d) {
        this.test = visitor.visitAndUpdate(this.test, d);
        if (visitor.exitValue == null) {
            this.then_clause = visitor.visitAndUpdate(this.then_clause, d);
        }
        if (visitor.exitValue == null && this.else_clause != null) {
            this.else_clause = visitor.visitAndUpdate(this.else_clause, d);
        }
    }
    
    @Override
    protected Type calculateType() {
        final Type t1 = this.then_clause.getType();
        final Type t2 = (this.else_clause == null) ? Type.voidType : this.else_clause.getType();
        return Language.unionType(t1, t2);
    }
    
    @Override
    public void print(final OutPort out) {
        out.startLogicalBlock("(If ", false, ")");
        out.setIndentation(-2, false);
        this.test.print(out);
        out.writeSpaceLinear();
        this.then_clause.print(out);
        if (this.else_clause != null) {
            out.writeSpaceLinear();
            this.else_clause.print(out);
        }
        out.endLogicalBlock(")");
    }
}
