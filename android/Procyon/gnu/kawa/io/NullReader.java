// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.io;

import java.io.Reader;

public class NullReader extends Reader
{
    public static final NullReader nullReader;
    
    @Override
    public int read(final char[] buffer, final int offset, final int length) {
        return -1;
    }
    
    @Override
    public boolean ready() {
        return true;
    }
    
    @Override
    public void close() {
    }
    
    static {
        nullReader = new NullReader();
    }
}
