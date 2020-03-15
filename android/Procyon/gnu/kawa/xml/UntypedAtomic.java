// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.xml;

public class UntypedAtomic
{
    String text;
    
    @Override
    public String toString() {
        return this.text;
    }
    
    public UntypedAtomic(final String text) {
        this.text = text;
    }
    
    @Override
    public int hashCode() {
        return this.text.hashCode();
    }
    
    @Override
    public boolean equals(final Object arg) {
        return arg instanceof UntypedAtomic && this.text.equals(((UntypedAtomic)arg).text);
    }
}
