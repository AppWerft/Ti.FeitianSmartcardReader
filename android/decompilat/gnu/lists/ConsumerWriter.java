// 
// Decompiled by Procyon v0.5.36
// 

package gnu.lists;

import java.io.Writer;

public class ConsumerWriter extends Writer
{
    protected Consumer out;
    
    public ConsumerWriter(final Consumer out) {
        this.out = out;
    }
    
    @Override
    public void write(final char[] buffer, final int offset, final int length) {
        this.out.write(buffer, offset, length);
    }
    
    @Override
    public void flush() {
    }
    
    @Override
    public void close() {
        this.flush();
    }
    
    public void finalize() {
        this.close();
    }
}
