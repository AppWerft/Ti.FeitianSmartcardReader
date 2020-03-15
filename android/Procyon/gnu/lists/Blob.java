// 
// Decompiled by Procyon v0.5.36
// 

package gnu.lists;

import gnu.kawa.io.Path;
import gnu.kawa.io.BinaryInPort;
import gnu.math.UByte;
import java.nio.charset.Charset;

public class Blob extends U8Vector implements CharSequence
{
    private String stringValue;
    Charset charset;
    
    public Blob(final byte[] data) {
        super(data);
    }
    
    public Blob(final byte[] data, final Charset charset) {
        super(data);
        this.charset = charset;
    }
    
    public static Blob wrap(final byte[] data, final int size) {
        final Blob blob = new Blob(data);
        blob.setInfoField(size, 0, 73014444032L);
        return blob;
    }
    
    public U8Vector asPlainBytevector() {
        if (this.isVerySimple()) {
            return new U8Vector(this.data);
        }
        final int sz = this.size();
        final byte[] b = new byte[sz];
        final U8Vector vec = new U8Vector(b);
        vec.copyFrom(0, this, 0, sz);
        return vec;
    }
    
    @Override
    public String toString() {
        synchronized (this) {
            if (this.stringValue == null) {
                final BinaryInPort in = new BinaryInPort(this.data, this.size(), null);
                final StringBuilder buf = new StringBuilder();
                try {
                    boolean bomSeen = false;
                    if (this.charset != null) {
                        bomSeen = in.setFromByteOrderMark();
                    }
                    if (!bomSeen) {
                        in.setCharset((this.charset != null) ? this.charset : Charset.defaultCharset());
                    }
                    int ch;
                    while ((ch = in.read()) >= 0) {
                        buf.append((char)ch);
                    }
                }
                catch (Exception ex) {
                    buf.append("[unexpected exception: ");
                    buf.append(ex);
                    buf.append(']');
                }
                this.stringValue = buf.toString();
            }
            return this.stringValue;
        }
    }
    
    @Override
    public char charAt(final int index) {
        return this.toString().charAt(index);
    }
    
    @Override
    public int length() {
        return this.toString().length();
    }
    
    @Override
    public CharSequence subSequence(final int start, final int end) {
        return this.toString().subSequence(start, end);
    }
}
