// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.functions;

import gnu.mapping.WrappedException;
import java.io.OutputStream;
import java.io.InputStream;
import gnu.lists.Blob;
import gnu.mapping.Lazy;

public class LProcess extends Process implements Lazy<Blob>
{
    private Process base;
    private Blob value;
    private Throwable exception;
    
    public LProcess(final Process process) {
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
    
    @Override
    public Blob getValue() {
        synchronized (this) {
            if (this.value == null) {
                try {
                    byte[] bytes = new byte[1024];
                    int len = 0;
                    final InputStream in = this.base.getInputStream();
                    while (true) {
                        int avail = bytes.length - len;
                        if (avail < 512) {
                            final byte[] tmp = new byte[2 * bytes.length];
                            System.arraycopy(bytes, 0, tmp, 0, len);
                            bytes = tmp;
                            avail = bytes.length - len;
                        }
                        final int cnt = in.read(bytes, len, avail);
                        if (cnt < 0) {
                            break;
                        }
                        len += cnt;
                    }
                    if (4 * len < 3 * bytes.length) {
                        final byte[] tmp2 = new byte[len];
                        System.arraycopy(bytes, 0, tmp2, 0, len);
                        bytes = tmp2;
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
