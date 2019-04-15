/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.functions;

import gnu.lists.Blob;
import gnu.mapping.Lazy;
import gnu.mapping.WrappedException;
import java.io.InputStream;
import java.io.OutputStream;

public class LProcess
extends Process
implements Lazy<Blob> {
    private Process base;
    private Blob value;
    private Throwable exception;

    public LProcess(Process process) {
        this.base = process;
    }

    @Override
    public InputStream getInputStream() {
        return this.getValue().getInputStream();
    }

    @Override
    public OutputStream getOutputStream() {
        return this.base.getOutputStream();
    }

    @Override
    public InputStream getErrorStream() {
        return this.base.getErrorStream();
    }

    @Override
    public int waitFor() throws InterruptedException {
        return this.base.waitFor();
    }

    @Override
    public int exitValue() {
        return this.base.exitValue();
    }

    @Override
    public void destroy() {
        this.base.destroy();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public Blob getValue() {
        LProcess lProcess = this;
        synchronized (lProcess) {
            if (this.value == null) {
                try {
                    byte[] bytes = new byte[1024];
                    int len = 0;
                    InputStream in = this.base.getInputStream();
                    do {
                        int avail;
                        int cnt;
                        if ((avail = bytes.length - len) < 512) {
                            byte[] tmp = new byte[2 * bytes.length];
                            System.arraycopy(bytes, 0, tmp, 0, len);
                            bytes = tmp;
                            avail = bytes.length - len;
                        }
                        if ((cnt = in.read(bytes, len, avail)) < 0) break;
                        len += cnt;
                    } while (true);
                    if (4 * len < 3 * bytes.length) {
                        byte[] tmp = new byte[len];
                        System.arraycopy(bytes, 0, tmp, 0, len);
                        bytes = tmp;
                    }
                    this.value = Blob.wrap(bytes, len);
                }
                catch (Throwable ex) {
                    this.exception = ex;
                }
            }
            if (this.exception != null) {
                WrappedException.rethrow(this.exception);
            }
        }
        return this.value;
    }
}

