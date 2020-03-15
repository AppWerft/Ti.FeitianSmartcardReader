// 
// Decompiled by Procyon v0.5.36
// 

package gnu.expr;

import gnu.text.SourceLocator;

public abstract class ExpExpVisitor<D> extends ExpVisitor<Expression, D>
{
    @Override
    protected Expression update(final Expression exp, final Expression r) {
        return r;
    }
    
    @Override
    protected Expression defaultValue(final Expression r, final D d) {
        return r;
    }
    
    public ErrorExp error(final String msg) {
        return this.comp.syntaxError(msg);
    }
    
    public ErrorExp error(final char severity, final String message, final SourceLocator location) {
        this.comp.error(severity, message, location);
        return new ErrorExp(message);
    }
}
