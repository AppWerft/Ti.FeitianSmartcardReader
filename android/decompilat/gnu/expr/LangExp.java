// 
// Decompiled by Procyon v0.5.36
// 

package gnu.expr;

import gnu.kawa.io.OutPort;

public class LangExp extends Expression
{
    Object hook;
    
    public Object getLangValue() {
        return this.hook;
    }
    
    public void setLangValue(final Object value) {
        this.hook = value;
    }
    
    public LangExp() {
    }
    
    public LangExp(final Object value) {
        this.hook = value;
    }
    
    @Override
    protected boolean mustCompile() {
        return false;
    }
    
    @Override
    public void print(final OutPort out) {
        out.print("(LangExp ???)");
    }
    
    @Override
    protected <R, D> R visit(final ExpVisitor<R, D> visitor, final D d) {
        return visitor.visitLangExp(this, d);
    }
    
    @Override
    public void compile(final Compilation comp, final Target target) {
        throw new RuntimeException("compile called on LangExp");
    }
}
