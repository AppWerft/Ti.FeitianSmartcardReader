// 
// Decompiled by Procyon v0.5.36
// 

package gnu.lists;

import gnu.kawa.io.CharArrayInPort;

public abstract class AbstractCharVector<E> extends SimpleVector<E> implements Comparable
{
    protected char[] data;
    protected static char[] empty;
    
    public int length() {
        return this.size();
    }
    
    @Override
    public int getBufferLength() {
        return this.data.length;
    }
    
    @Override
    public void copyBuffer(int length) {
        final int oldLength = this.data.length;
        if (length == -1) {
            length = oldLength;
        }
        if (oldLength != length) {
            final char[] tmp = new char[length];
            System.arraycopy(this.data, 0, tmp, 0, (oldLength < length) ? oldLength : length);
            this.data = tmp;
        }
    }
    
    public void ensureBufferLength(final int sz) {
        if (sz > this.data.length) {
            final char[] d = new char[(sz < 60) ? 120 : (2 * sz)];
            System.arraycopy(this.data, 0, d, 0, this.data.length);
            this.data = d;
        }
    }
    
    public char[] getBuffer() {
        return this.data;
    }
    
    @Override
    protected void setBuffer(final Object buffer) {
        this.data = (char[])buffer;
    }
    
    public final char charAt(final int index) {
        return this.data[this.effectiveIndex(index)];
    }
    
    @Override
    public final char getCharRaw(final int index) {
        return this.data[index];
    }
    
    public void getChars(final int srcBegin, final int srcEnd, final char[] dst, final int dstBegin) {
        if (srcBegin < 0 || srcBegin > srcEnd) {
            throw new StringIndexOutOfBoundsException(srcBegin);
        }
        final int size = this.size();
        if (srcEnd > size) {
            throw new StringIndexOutOfBoundsException(srcEnd);
        }
        if (dstBegin + srcEnd - srcBegin > dst.length) {
            throw new StringIndexOutOfBoundsException(dstBegin);
        }
        final int len = srcEnd - srcBegin;
        if (len <= 0) {
            return;
        }
        if (this.isVerySimple()) {
            System.arraycopy(this.data, srcBegin, dst, dstBegin, len);
        }
        else {
            for (int i = 0; i < len; ++i) {
                dst[dstBegin + i] = this.charAt(srcBegin + i);
            }
        }
    }
    
    @Override
    protected void clearBuffer(int start, int count) {
        final char[] d = this.data;
        while (--count >= 0) {
            d[start++] = '\0';
        }
    }
    
    @Override
    public int hashCode() {
        final char[] val = this.data;
        final int len = this.size();
        int hash = 0;
        if (!this.isVerySimple()) {
            for (int i = 0; i < len; ++i) {
                hash = 31 * hash + val[this.effectiveIndex(i)];
            }
        }
        else {
            for (int i = 0; i < len; ++i) {
                hash = 31 * hash + val[i];
            }
        }
        return hash;
    }
    
    @Override
    public abstract boolean equals(final Object p0);
    
    public static boolean equals(final AbstractCharVector<?> c1, final AbstractCharVector<?> c2) {
        final int len1 = c1.size();
        final int len2 = c2.size();
        return len1 == len2 && compareTo(c1.data, c2.data, len1) == 0;
    }
    
    @Override
    public int compareTo(final Object obj) {
        final AbstractCharVector<?> cv1 = this;
        final AbstractCharVector<?> cv2 = (AbstractCharVector<?>)obj;
        final int n1 = cv1.size();
        final int n2 = cv2.size();
        final int n3 = (n1 > n2) ? n2 : n1;
        final int d = compareTo(cv1, cv2, n3);
        return (d != 0) ? d : (n1 - n2);
    }
    
    public static int compareTo(final AbstractCharVector<?> cv1, final AbstractCharVector<?> cv2, final int length) {
        if (!cv1.isVerySimple() || !cv2.isVerySimple()) {
            for (int i = 0; i < length; ++i) {
                final char c1 = cv1.charAt(i);
                final char c2 = cv2.charAt(i);
                final int d = c1 - c2;
                if (d != 0) {
                    return d;
                }
            }
            return 0;
        }
        return compareTo(cv1.data, cv2.data, length);
    }
    
    public static int compareTo(final char[] arr1, final char[] arr2, final int length) {
        for (int i = 0; i < length; ++i) {
            final char c1 = arr1[i];
            final char c2 = arr2[i];
            final int d = c1 - c2;
            if (d != 0) {
                return d;
            }
        }
        return 0;
    }
    
    public CharArrayInPort openReader() {
        return new CharArrayInPort(this, this.data, 0, this.size());
    }
    
    public CharArrayInPort openReader(final int start, final int end) {
        return new CharArrayInPort(this, this.data, start, end);
    }
    
    static {
        AbstractCharVector.empty = new char[0];
    }
}
