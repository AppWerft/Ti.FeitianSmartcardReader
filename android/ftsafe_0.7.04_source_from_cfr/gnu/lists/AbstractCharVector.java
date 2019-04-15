/*
 * Decompiled with CFR 0.139.
 */
package gnu.lists;

import gnu.kawa.io.CharArrayInPort;
import gnu.lists.SimpleVector;

public abstract class AbstractCharVector<E>
extends SimpleVector<E>
implements Comparable {
    protected char[] data;
    protected static char[] empty = new char[0];

    public int length() {
        return this.size();
    }

    @Override
    public int getBufferLength() {
        return this.data.length;
    }

    @Override
    public void copyBuffer(int length) {
        int oldLength = this.data.length;
        if (length == -1) {
            length = oldLength;
        }
        if (oldLength != length) {
            char[] tmp = new char[length];
            System.arraycopy(this.data, 0, tmp, 0, oldLength < length ? oldLength : length);
            this.data = tmp;
        }
    }

    public void ensureBufferLength(int sz) {
        if (sz > this.data.length) {
            char[] d = new char[sz < 60 ? 120 : 2 * sz];
            System.arraycopy(this.data, 0, d, 0, this.data.length);
            this.data = d;
        }
    }

    public char[] getBuffer() {
        return this.data;
    }

    @Override
    protected void setBuffer(Object buffer) {
        this.data = (char[])buffer;
    }

    public final char charAt(int index) {
        return this.data[this.effectiveIndex(index)];
    }

    @Override
    public final char getCharRaw(int index) {
        return this.data[index];
    }

    public void getChars(int srcBegin, int srcEnd, char[] dst, int dstBegin) {
        if (srcBegin < 0 || srcBegin > srcEnd) {
            throw new StringIndexOutOfBoundsException(srcBegin);
        }
        int size = this.size();
        if (srcEnd > size) {
            throw new StringIndexOutOfBoundsException(srcEnd);
        }
        if (dstBegin + srcEnd - srcBegin > dst.length) {
            throw new StringIndexOutOfBoundsException(dstBegin);
        }
        int len = srcEnd - srcBegin;
        if (len <= 0) {
            return;
        }
        if (this.isVerySimple()) {
            System.arraycopy(this.data, srcBegin, dst, dstBegin, len);
        } else {
            for (int i = 0; i < len; ++i) {
                dst[dstBegin + i] = this.charAt(srcBegin + i);
            }
        }
    }

    @Override
    protected void clearBuffer(int start, int count) {
        char[] d = this.data;
        while (--count >= 0) {
            d[start++] = '\u0000';
        }
    }

    @Override
    public int hashCode() {
        int hash;
        char[] val = this.data;
        int len = this.size();
        hash = 0;
        if (!this.isVerySimple()) {
            for (int i = 0; i < len; ++i) {
                hash = 31 * hash + val[this.effectiveIndex(i)];
            }
        } else {
            for (int i = 0; i < len; ++i) {
                hash = 31 * hash + val[i];
            }
        }
        return hash;
    }

    @Override
    public abstract boolean equals(Object var1);

    public static boolean equals(AbstractCharVector<?> c1, AbstractCharVector<?> c2) {
        int len2;
        int len1 = c1.size();
        return len1 == (len2 = c2.size()) && AbstractCharVector.compareTo(c1.data, c2.data, len1) == 0;
    }

    public int compareTo(Object obj) {
        int n2;
        AbstractCharVector cv1 = this;
        AbstractCharVector cv2 = (AbstractCharVector)obj;
        int n1 = cv1.size();
        int n = n1 > (n2 = cv2.size()) ? n2 : n1;
        int d = AbstractCharVector.compareTo(cv1, cv2, n);
        return d != 0 ? d : n1 - n2;
    }

    public static int compareTo(AbstractCharVector<?> cv1, AbstractCharVector<?> cv2, int length) {
        if (!cv1.isVerySimple() || !cv2.isVerySimple()) {
            for (int i = 0; i < length; ++i) {
                char c2;
                char c1 = cv1.charAt(i);
                int d = c1 - (c2 = cv2.charAt(i));
                if (d == 0) continue;
                return d;
            }
            return 0;
        }
        return AbstractCharVector.compareTo(cv1.data, cv2.data, length);
    }

    public static int compareTo(char[] arr1, char[] arr2, int length) {
        for (int i = 0; i < length; ++i) {
            char c1 = arr1[i];
            char c2 = arr2[i];
            int d = c1 - c2;
            if (d == 0) continue;
            return d;
        }
        return 0;
    }

    public CharArrayInPort openReader() {
        return new CharArrayInPort(this, this.data, 0, this.size());
    }

    public CharArrayInPort openReader(int start, int end) {
        return new CharArrayInPort(this, this.data, start, end);
    }
}

