/*
 * Decompiled with CFR 0.139.
 */
package gnu.expr;

import gnu.expr.ApplyExp;
import gnu.expr.BeginExp;
import gnu.expr.BlockExp;
import gnu.expr.CaseExp;
import gnu.expr.ClassExp;
import gnu.expr.Compilation;
import gnu.expr.Declaration;
import gnu.expr.ErrorExp;
import gnu.expr.ExitExp;
import gnu.expr.Expression;
import gnu.expr.FluidLetExp;
import gnu.expr.IfExp;
import gnu.expr.LambdaExp;
import gnu.expr.LangExp;
import gnu.expr.Language;
import gnu.expr.LetExp;
import gnu.expr.ModuleExp;
import gnu.expr.ObjectExp;
import gnu.expr.QuoteExp;
import gnu.expr.ReferenceExp;
import gnu.expr.ScopeExp;
import gnu.expr.SetExp;
import gnu.expr.SynchronizedExp;
import gnu.expr.ThisExp;
import gnu.expr.TryExp;
import gnu.text.SourceLocator;
import gnu.text.SourceMessages;

public class ExpVisitor<R, D>
implements SourceLocator {
    protected SourceMessages messages;
    Compilation comp;
    protected LambdaExp currentLambda = null;
    protected Object exitValue = null;

    public Compilation getCompilation() {
        return this.comp;
    }

    public Language getLanguage() {
        return this.comp.getLanguage();
    }

    public SourceMessages getMessages() {
        return this.messages;
    }

    protected R defaultValue(Expression r, D d) {
        return null;
    }

    protected R visitExpression(Expression exp, D d) {
        exp.visitChildren(this, d);
        return this.defaultValue(exp, d);
    }

    public void setContext(Compilation comp) {
        this.comp = comp;
        this.messages = comp.getMessages();
    }

    public R visit(Expression exp, D d) {
        return ExpVisitor.visit(this, exp, d);
    }

    public static <R, D> R visit(ExpVisitor<R, D> visitor, Expression exp, D d) {
        int line = exp.getLineNumber();
        SourceMessages messages = visitor.messages;
        if (messages != null && line > 0) {
            String saveFile = messages.getFileName();
            int saveLine = messages.getLineNumber();
            int saveColumn = messages.getColumnNumber();
            messages.setLine(exp.getFileName(), line, exp.getColumnNumber());
            R ret = exp.visit(visitor, d);
            messages.setLine(saveFile, saveLine, saveColumn);
            return ret;
        }
        return exp.visit(visitor, d);
    }

    protected Expression update(Expression exp, R r) {
        return exp;
    }

    protected R visitApplyExp(ApplyExp exp, D d) {
        return this.visitExpression(exp, d);
    }

    protected R visitIfExp(IfExp exp, D d) {
        return this.visitExpression(exp, d);
    }

    protected R visitCaseExp(CaseExp exp, D d) {
        return this.visitExpression(exp, d);
    }

    protected void visitDeclarationType(Declaration decl) {
        Expression texp2;
        Expression texp1 = decl.typeExp;
        if (texp1 != null && (texp2 = this.visitAndUpdate(texp1, null)) != texp1) {
            decl.setTypeExp(texp2);
        }
    }

    protected final void visitDeclarationTypes(ScopeExp exp) {
        for (Declaration decl = exp.firstDecl(); decl != null; decl = decl.nextDecl()) {
            this.visitDeclarationType(decl);
        }
    }

    protected R visitScopeExp(ScopeExp exp, D d) {
        this.visitDeclarationTypes(exp);
        return this.visitExpression(exp, d);
    }

    protected R visitLetExp(LetExp exp, D d) {
        return this.visitScopeExp(exp, d);
    }

    protected R visitLambdaExp(LambdaExp exp, D d) {
        return this.visitScopeExp(exp, d);
    }

    protected R visitClassExp(ClassExp exp, D d) {
        return this.visitLambdaExp(exp, d);
    }

    protected R visitObjectExp(ObjectExp exp, D d) {
        return this.visitClassExp(exp, d);
    }

    protected R visitModuleExp(ModuleExp exp, D d) {
        return this.visitLambdaExp(exp, d);
    }

    protected R visitSetExp(SetExp exp, D d) {
        exp.new_value = this.visitAndUpdate(exp.new_value, d);
        return this.defaultValue(exp, d);
    }

    protected R visitTryExp(TryExp exp, D d) {
        return this.visitExpression(exp, d);
    }

    protected R visitBeginExp(BeginExp exp, D d) {
        return this.visitExpression(exp, d);
    }

    protected R visitQuoteExp(QuoteExp exp, D d) {
        return this.visitExpression(exp, d);
    }

    protected R visitReferenceExp(ReferenceExp exp, D d) {
        return this.visitExpression(exp, d);
    }

    protected R visitThisExp(ThisExp exp, D d) {
        return this.visitReferenceExp(exp, d);
    }

    protected R visitSynchronizedExp(SynchronizedExp exp, D d) {
        return this.visitExpression(exp, d);
    }

    protected R visitBlockExp(BlockExp exp, D d) {
        return this.visitExpression(exp, d);
    }

    protected R visitExitExp(ExitExp exp, D d) {
        return this.visitExpression(exp, d);
    }

    protected R visitFluidLetExp(FluidLetExp exp, D d) {
        return this.visitLetExp(exp, d);
    }

    protected R visitLangExp(LangExp exp, D d) {
        return this.visitExpression(exp, d);
    }

    public Object getExitValue() {
        return this.exitValue;
    }

    public final LambdaExp getCurrentLambda() {
        return this.currentLambda;
    }

    public Expression visitAndUpdate(Expression exp, D d) {
        return this.update(exp, this.visit(exp, d));
    }

    public Expression[] visitExps(Expression[] exps, D d) {
        return exps == null ? null : this.visitExps(exps, exps.length, d);
    }

    public Expression[] visitExps(Expression[] exps, int n, D d) {
        for (int i = 0; i < n && this.exitValue == null; ++i) {
            exps[i] = this.visitAndUpdate(exps[i], d);
        }
        return exps;
    }

    public void visitDefaultArgs(LambdaExp exp, D d) {
        for (Declaration p = exp.firstDecl(); p != null; p = p.nextDecl()) {
            Expression init = p.getInitValue();
            if (init == null) continue;
            p.setInitValue(this.visitAndUpdate(init, d));
        }
    }

    public void error(char kind, String message) {
        if (kind == 'w' && this.comp.warnAsError()) {
            kind = (char)101;
        }
        if (this.messages != null) {
            this.messages.error(kind, message);
        } else {
            new Error("internal error: " + message);
        }
    }

    public Expression noteError(String message) {
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

    public void setFile(String filename) {
        this.messages.setFile(filename);
    }

    public void setLine(int line) {
        this.messages.setLine(line);
    }

    public void setColumn(int column) {
        this.messages.setColumn(column);
    }

    public void setLine(String filename, int line, int column) {
        this.messages.setLine(filename, line, column);
    }
}

