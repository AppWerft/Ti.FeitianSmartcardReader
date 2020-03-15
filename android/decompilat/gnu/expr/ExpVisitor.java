// 
// Decompiled by Procyon v0.5.36
// 

package gnu.expr;

import gnu.text.SourceMessages;
import gnu.text.SourceLocator;

public class ExpVisitor<R, D> implements SourceLocator
{
    protected SourceMessages messages;
    Compilation comp;
    protected LambdaExp currentLambda;
    protected Object exitValue;
    
    public ExpVisitor() {
        this.currentLambda = null;
        this.exitValue = null;
    }
    
    public Compilation getCompilation() {
        return this.comp;
    }
    
    public Language getLanguage() {
        return this.comp.getLanguage();
    }
    
    public SourceMessages getMessages() {
        return this.messages;
    }
    
    protected R defaultValue(final Expression r, final D d) {
        return null;
    }
    
    protected R visitExpression(final Expression exp, final D d) {
        exp.visitChildren((ExpVisitor<Object, D>)this, d);
        return this.defaultValue(exp, d);
    }
    
    public void setContext(final Compilation comp) {
        this.comp = comp;
        this.messages = comp.getMessages();
    }
    
    public R visit(final Expression exp, final D d) {
        return visit(this, exp, d);
    }
    
    public static <R, D> R visit(final ExpVisitor<R, D> visitor, final Expression exp, final D d) {
        final int line = exp.getLineNumber();
        final SourceMessages messages = visitor.messages;
        if (messages != null && line > 0) {
            final String saveFile = messages.getFileName();
            final int saveLine = messages.getLineNumber();
            final int saveColumn = messages.getColumnNumber();
            messages.setLine(exp.getFileName(), line, exp.getColumnNumber());
            final R ret = exp.visit(visitor, d);
            messages.setLine(saveFile, saveLine, saveColumn);
            return ret;
        }
        return exp.visit(visitor, d);
    }
    
    protected Expression update(final Expression exp, final R r) {
        return exp;
    }
    
    protected R visitApplyExp(final ApplyExp exp, final D d) {
        return this.visitExpression(exp, d);
    }
    
    protected R visitIfExp(final IfExp exp, final D d) {
        return this.visitExpression(exp, d);
    }
    
    protected R visitCaseExp(final CaseExp exp, final D d) {
        return this.visitExpression(exp, d);
    }
    
    protected void visitDeclarationType(final Declaration decl) {
        final Expression texp1 = decl.typeExp;
        if (texp1 != null) {
            final Expression texp2 = this.visitAndUpdate(texp1, null);
            if (texp2 != texp1) {
                decl.setTypeExp(texp2);
            }
        }
    }
    
    protected final void visitDeclarationTypes(final ScopeExp exp) {
        for (Declaration decl = exp.firstDecl(); decl != null; decl = decl.nextDecl()) {
            this.visitDeclarationType(decl);
        }
    }
    
    protected R visitScopeExp(final ScopeExp exp, final D d) {
        this.visitDeclarationTypes(exp);
        return this.visitExpression(exp, d);
    }
    
    protected R visitLetExp(final LetExp exp, final D d) {
        return this.visitScopeExp(exp, d);
    }
    
    protected R visitLambdaExp(final LambdaExp exp, final D d) {
        return this.visitScopeExp(exp, d);
    }
    
    protected R visitClassExp(final ClassExp exp, final D d) {
        return this.visitLambdaExp(exp, d);
    }
    
    protected R visitObjectExp(final ObjectExp exp, final D d) {
        return this.visitClassExp(exp, d);
    }
    
    protected R visitModuleExp(final ModuleExp exp, final D d) {
        return this.visitLambdaExp(exp, d);
    }
    
    protected R visitSetExp(final SetExp exp, final D d) {
        exp.new_value = this.visitAndUpdate(exp.new_value, d);
        return this.defaultValue(exp, d);
    }
    
    protected R visitTryExp(final TryExp exp, final D d) {
        return this.visitExpression(exp, d);
    }
    
    protected R visitBeginExp(final BeginExp exp, final D d) {
        return this.visitExpression(exp, d);
    }
    
    protected R visitQuoteExp(final QuoteExp exp, final D d) {
        return this.visitExpression(exp, d);
    }
    
    protected R visitReferenceExp(final ReferenceExp exp, final D d) {
        return this.visitExpression(exp, d);
    }
    
    protected R visitThisExp(final ThisExp exp, final D d) {
        return this.visitReferenceExp(exp, d);
    }
    
    protected R visitSynchronizedExp(final SynchronizedExp exp, final D d) {
        return this.visitExpression(exp, d);
    }
    
    protected R visitBlockExp(final BlockExp exp, final D d) {
        return this.visitExpression(exp, d);
    }
    
    protected R visitExitExp(final ExitExp exp, final D d) {
        return this.visitExpression(exp, d);
    }
    
    protected R visitFluidLetExp(final FluidLetExp exp, final D d) {
        return this.visitLetExp(exp, d);
    }
    
    protected R visitLangExp(final LangExp exp, final D d) {
        return this.visitExpression(exp, d);
    }
    
    public Object getExitValue() {
        return this.exitValue;
    }
    
    public final LambdaExp getCurrentLambda() {
        return this.currentLambda;
    }
    
    public Expression visitAndUpdate(final Expression exp, final D d) {
        return this.update(exp, this.visit(exp, d));
    }
    
    public Expression[] visitExps(final Expression[] exps, final D d) {
        return (Expression[])((exps == null) ? null : this.visitExps(exps, exps.length, d));
    }
    
    public Expression[] visitExps(final Expression[] exps, final int n, final D d) {
        for (int i = 0; i < n && this.exitValue == null; ++i) {
            exps[i] = this.visitAndUpdate(exps[i], d);
        }
        return exps;
    }
    
    public void visitDefaultArgs(final LambdaExp exp, final D d) {
        for (Declaration p = exp.firstDecl(); p != null; p = p.nextDecl()) {
            final Expression init = p.getInitValue();
            if (init != null) {
                p.setInitValue(this.visitAndUpdate(init, d));
            }
        }
    }
    
    public void error(char kind, final String message) {
        if (kind == 'w' && this.comp.warnAsError()) {
            kind = 'e';
        }
        if (this.messages != null) {
            this.messages.error(kind, message);
        }
        else {
            new Error("internal error: " + message);
        }
    }
    
    public Expression noteError(final String message) {
        if (this.messages != null) {
            this.messages.error('e', message);
        }
        return new ErrorExp(message);
    }
    
    @Override
    public final String getFileName() {
        return this.messages.getFileName();
    }
    
    @Override
    public final int getLineNumber() {
        return this.messages.getLineNumber();
    }
    
    @Override
    public final int getColumnNumber() {
        return this.messages.getColumnNumber();
    }
    
    @Override
    public String getPublicId() {
        return this.messages.getPublicId();
    }
    
    @Override
    public String getSystemId() {
        return this.messages.getSystemId();
    }
    
    @Override
    public boolean isStableSourceLocation() {
        return false;
    }
    
    public void setFile(final String filename) {
        this.messages.setFile(filename);
    }
    
    public void setLine(final int line) {
        this.messages.setLine(line);
    }
    
    public void setColumn(final int column) {
        this.messages.setColumn(column);
    }
    
    public void setLine(final String filename, final int line, final int column) {
        this.messages.setLine(filename, line, column);
    }
}
