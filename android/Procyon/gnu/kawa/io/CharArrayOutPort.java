// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.io;

import java.io.IOException;
import gnu.lists.FString;
import gnu.lists.Consumer;
import java.io.Writer;

public class CharArrayOutPort extends OutPort
{
    public CharArrayOutPort() {
        super(null, false, CharArrayInPort.stringPath);
    }
    
    public CharArrayOutPort(final boolean printPretty, final Path path) {
        super(null, printPretty, false, path);
    }
    
    public int length() {
        return this.bout.bufferFillPointer;
    }
    
    public int size() {
        return this.bout.bufferFillPointer;
    }
    
    public void setLength(final int length) {
        this.bout.bufferFillPointer = length;
    }
    
    public void reset() {
        this.bout.bufferFillPointer = 0;
    }
    
    public char[] toCharArray() {
        final int length = this.bout.bufferFillPointer;
        final char[] result = new char[length];
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
    
    @Override
    public String toString() {
        return this.toSubString(0);
    }
    
    public String toSubString(final int beginIndex, final int endIndex) {
        if (endIndex > this.bout.bufferFillPointer) {
            throw new IndexOutOfBoundsException();
        }
        return new String(this.bout.buffer, beginIndex, endIndex - beginIndex);
    }
    
    public String toSubString(final int beginIndex) {
        return new String(this.bout.buffer, beginIndex, this.bout.bufferFillPointer - beginIndex);
    }
    
    public void writeTo(final Appendable out) {
        this.writeTo(0, this.bout.bufferFillPointer, out);
    }
    
    public void writeTo(final int start, final int count, final Appendable out) {
        if (out instanceof Consumer) {
            ((Consumer)out).write(this.bout.buffer, start, count);
        }
        else {
            try {
                out.append(new FString(this.bout.buffer), start, start + count);
            }
            catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
