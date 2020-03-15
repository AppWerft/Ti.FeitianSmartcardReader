// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.models;

public abstract class Model implements Viewable
{
    transient WeakListener listeners;
    
    public void addListener(final ModelListener listener) {
        this.listeners = new WeakListener(listener, this.listeners);
    }
    
    public void addListener(final WeakListener listener) {
        listener.next = this.listeners;
        this.listeners = listener;
    }
    
    public void notifyListeners(final String key) {
        WeakListener prev = null;
        WeakListener next;
        for (WeakListener wlistener = this.listeners; wlistener != null; wlistener = next) {
            final Object listener = wlistener.get();
            next = wlistener.next;
            if (listener == null) {
                if (prev != null) {
                    prev.next = next;
                }
            }
            else {
                prev = wlistener;
                wlistener.update(listener, this, key);
            }
        }
    }
}
