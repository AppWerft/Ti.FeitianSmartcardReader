// 
// Decompiled by Procyon v0.5.36
// 

package kawa;

import java.io.IOException;
import java.io.OutputStream;
import java.io.FilterOutputStream;

public class TelnetOutputStream extends FilterOutputStream
{
    public TelnetOutputStream(final OutputStream out) {
        super(out);
    }
    
    @Override
    public void write(final int value) throws IOException {
        if (value == 255) {
            this.out.write(value);
        }
        this.out.write(value);
    }
    
    @Override
    public void write(final byte[] b) throws IOException {
        this.write(b, 0, b.length);
    }
    
    @Override
    public void write(final byte[] b, int off, final int len) throws IOException {
        final int limit = off + len;
        for (int i = off; i < limit; ++i) {
            if (b[i] == -1) {
                this.out.write(b, off, i + 1 - off);
                off = i;
            }
        }
        this.out.write(b, off, limit - off);
    }
    
    public void writeCommand(final int code) throws IOException {
        this.out.write(255);
        this.out.write(code);
    }
    
    public final void writeCommand(final int code, final int option) throws IOException {
        this.out.write(255);
        this.out.write(code);
        this.out.write(option);
    }
    
    public final void writeDo(final int option) throws IOException {
        this.writeCommand(253, option);
    }
    
    public final void writeDont(final int option) throws IOException {
        this.writeCommand(254, option);
    }
    
    public final void writeWill(final int option) throws IOException {
        this.writeCommand(251, option);
    }
    
    public final void writeWont(final int option) throws IOException {
        this.writeCommand(252, option);
    }
    
    public final void writeSubCommand(final int option, final byte[] command) throws IOException {
        this.writeCommand(250, option);
        this.write(command);
        this.writeCommand(240);
    }
}
