/*
 * Decompiled with CFR 0.139.
 */
package gnu.lists;

import gnu.kawa.io.BinaryInPort;
import gnu.kawa.io.Path;
import gnu.lists.ByteVector;
import gnu.lists.U8Vector;
import java.nio.charset.Charset;

public class Blob
extends U8Vector
implements CharSequence {
    private String stringValue;
    Charset charset;

    public Blob(byte[] data) {
        super(data);
    }

    public Blob(byte[] data, Charset charset) {
        super(data);
        this.charset = charset;
    }

    public static Blob wrap(byte[] data, int size) {
        Blob blob = new Blob(data);
        blob.setInfoField(size, 0, 0x1100000000L);
        return blob;
    }

    public U8Vector asPlainBytevector() {
        if (this.isVerySimple()) {
            return new U8Vector(this.data);
        }
        int sz = this.size();
        byte[] b = new byte[sz];
        U8Vector vec = new U8Vector(b);
        vec.copyFrom(0, this, 0, sz);
        return vec;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public String toString() {
        Blob blob = this;
        synchronized (blob) {
            if (this.stringValue == null) {
                BinaryInPort in = new BinaryInPort(this.data, this.size(), null);
                StringBuilder buf = new StringBuilder();
                try {
                    int ch;
                    boolean bomSeen = false;
                    if (this.charset != null) {
                        bomSeen = in.setFromByteOrderMark();
                    }
                    if (!bomSeen) {
                        in.setCharset(this.charset != null ? this.charset : Charset.defaultCharset());
                    }
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
    public char charAt(int index) {
        return this.toString().charAt(index);
    }

    @Override
    public int length() {
        return this.toString().length();
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return this.toString().subSequence(start, end);
    }
}

