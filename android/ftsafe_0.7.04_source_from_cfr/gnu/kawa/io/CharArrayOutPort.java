/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.io;

import gnu.kawa.io.CharArrayInPort;
import gnu.kawa.io.OutPort;
import gnu.kawa.io.Path;
import gnu.kawa.io.PrettyWriter;
import gnu.lists.Consumer;
import gnu.lists.FString;
import java.io.IOException;
import java.io.Writer;

public class CharArrayOutPort
extends OutPort {
    public CharArrayOutPort() {
        super(null, false, CharArrayInPort.stringPath);
    }

    public CharArrayOutPort(boolean printPretty, Path path) {
        super(null, printPretty, false, path);
    }

    public int length() {
        return this.bout.bufferFillPointer;
    }

    public int size() {
        return this.bout.bufferFillPointer;
    }

    public void setLength(int length) {
        this.bout.bufferFillPointer = length;
    }

    public void reset() {
        this.bout.bufferFillPointer = 0;
    }

    public char[] toCharArray() {
        int length = this.bout.bufferFillPointer;
        char[] result = new char[length];
        System.arraycopy(this.bout.buffer, 0, result, 0, length);
        return result;
    }

    @Override
    public void close() {
        this.flags = 4;
    }

    @Override
    protected boolean closeOnExit() {
        return false;
    }

    @Override
    public void finalize() {
    }

    public String toString() {
        return this.toSubString(0);
    }

    public String toSubString(int beginIndex, int endIndex) {
        if (endIndex > this.bout.bufferFillPointer) {
            throw new IndexOutOfBoundsException();
        }
        return new String(this.bout.buffer, beginIndex, endIndex - beginIndex);
    }

    public String toSubString(int beginIndex) {
        return new String(this.bout.buffer, beginIndex, this.bout.bufferFillPointer - beginIndex);
    }

    public void writeTo(Appendable out) {
        this.writeTo(0, this.bout.bufferFillPointer, out);
    }

    public void writeTo(int start, int count, Appendable out) {
        if (out instanceof Consumer) {
            ((Consumer)out).write(this.bout.buffer, start, count);
        } else {
            try {
                out.append(new FString(this.bout.buffer), start, start + count);
            }
            catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}

