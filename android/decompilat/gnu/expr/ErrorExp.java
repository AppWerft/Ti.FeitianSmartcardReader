// 
// Decompiled by Procyon v0.5.36
// 

package gnu.expr;

import gnu.kawa.io.OutPort;
import gnu.text.SourceMessages;

public class ErrorExp extends Expression
{
    String message;
    
    public ErrorExp(final String message) {
        this.message = message;
    }
    
    public ErrorExp(final String message, final SourceMessages messages) {
        this(message);
        messages.error('e', message);
    }
    
    public ErrorExp(final String message, final Compilation comp) {
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
    public void print(final OutPort out) {
        out.startLogicalBlock("(Error", false, ")");
        out.writeSpaceLinear();
        out.print(this.message);
        out.endLogicalBlock(")");
    }
    
    @Override
    public void compile(final Compilation comp, final Target target) {
        throw new Error(comp.getFileName() + ":" + comp.getLineNumber() + ": internal error: compiling error expression: " + this.message);
    }
}
