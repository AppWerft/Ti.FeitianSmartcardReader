// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.io;

import java.lang.ref.WeakReference;
import java.io.Writer;

public final class WriterManager implements Runnable
{
    public static final WriterManager instance;
    WriterRef first;
    
    private WriterManager() {
    }
    
    public synchronized WriterRef register(final OutPort port) {
        final WriterRef ref = new WriterRef(port);
        final WriterRef first = this.first;
        if (first != null) {
            ref.next = first;
            first.prev = ref;
        }
        return this.first = ref;
    }
    
    public synchronized void unregister(final WriterRef key) {
        if (key == null) {
            return;
        }
        final WriterRef ref = key;
        final WriterRef next = ref.next;
        final WriterRef prev = ref.prev;
        if (next != null) {
            next.prev = prev;
        }
        if (prev != null) {
            prev.next = next;
        }
        ref.next = null;
        ref.prev = null;
        if (ref == this.first) {
            this.first = next;
        }
    }
    
    @Override
    public synchronized void run() {
        WriterRef next;
        for (WriterRef ref = this.first; ref != null; ref = next) {
            next = ref.next;
            final Object port = ref.get();
            if (port != null) {
                try {
                    ((OutPort)port).close();
                }
                catch (Exception ex) {}
            }
        }
        this.first = null;
    }
    
    public boolean registerShutdownHook() {
        try {
            Runtime.getRuntime().addShutdownHook(new Thread(this));
            return true;
        }
        catch (Exception ex) {
            return false;
        }
    }
    
    static {
        instance = new WriterManager();
    }
    
    public static class WriterRef extends WeakReference
    {
        WriterRef next;
        WriterRef prev;
        int id;
        static int counter;
        
        public WriterRef(final Writer wr) {
            super(wr);
            this.id = ++WriterRef.counter;
        }
        
        @Override
        public String toString() {
            return "WriterRef#" + this.id + ":" + this.get();
        }
    }
}
