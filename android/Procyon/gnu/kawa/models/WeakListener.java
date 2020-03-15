// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.models;

import java.lang.ref.WeakReference;

public class WeakListener extends WeakReference
{
    WeakListener next;
    
    public WeakListener(final Object referent) {
        super(referent);
    }
    
    public WeakListener(final Object referent, final WeakListener next) {
        super(referent);
        this.next = next;
    }
    
    public void update(final Object view, final Model model, final Object key) {
        ((ModelListener)view).modelUpdated(model, key);
    }
}
