// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.slib;

public class raise-object-exception extends Throwable
{
    public Object value;
    
    public raise-object-exception(final Object value) {
        this.value = value;
    }
}
