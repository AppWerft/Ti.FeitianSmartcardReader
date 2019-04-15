/*
 * Decompiled with CFR 0.139.
 */
package gnu.expr;

import gnu.expr.Compilation;
import gnu.expr.Expression;
import gnu.expr.Target;
import gnu.kawa.io.OutPort;
import gnu.text.SourceMessages;

public class ErrorExp
extends Expression {
    String message;

    public ErrorExp(String message) {
        this.message = message;
    }

    public ErrorExp(String message, SourceMessages messages) {
        this(message);
        messages.error('e', message);
    }

    public ErrorExp(String message, Compilation comp) {
        this(message, comp.getMessages());
    }

    @Override
    protected boolean mustCompile() {
        return false;
    }

    @Override
    public String toString() {
        return "ErrorExp[" + this.message + "]";
    }

    @Override
    public void print(OutPort out) {
        out.startLogicalBlock("(Error", false, ")");
        out.writeSpaceLinear();
        out.print(this.message);
        out.endLogicalBlock(")");
    }

    @Override
    public void compile(Compilation comp, Target target) {
        throw new Error(comp.getFileName() + ":" + comp.getLineNumber() + ": internal error: compiling error expression: " + this.message);
    }
}

