/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.io;

import gnu.kawa.io.OutPort;
import java.io.Writer;
import java.lang.ref.WeakReference;

public final class WriterManager
implements Runnable {
    public static final WriterManager instance = new WriterManager();
    WriterRef first;

    private WriterManager() {
    }

    public synchronized WriterRef register(OutPort port) {
        WriterRef ref = new WriterRef(port);
        WriterRef first = this.first;
        if (first != null) {
            ref.next = first;
            first.prev = ref;
        }
        this.first = ref;
        return ref;
    }

    public synchronized void unregister(WriterRef key) {
        if (key == null) {
            return;
        }
        WriterRef ref = key;
        WriterRef next = ref.next;
        WriterRef prev = ref.prev;
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
        WriterRef ref = this.first;
        while (ref != null) {
            WriterRef next = ref.next;
            Object port = ref.get();
            if (port != null) {
                try {
                    ((OutPort)port).close();
                }
                catch (Exception ex) {
                    // empty catch block
                }
            }
            ref = next;
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

    public static class WriterRef
    extends WeakReference {
        WriterRef next;
        WriterRef prev;
        int id = ++counter;
        static int counter;

        public WriterRef(Writer wr) {
            super(wr);
        }

        public String toString() {
            return "WriterRef#" + this.id + ":" + this.get();
        }
    }

}

