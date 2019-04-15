/*
 * Decompiled with CFR 0.139.
 */
package kawa;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class TelnetOutputStream
extends FilterOutputStream {
    public TelnetOutputStream(OutputStream out) {
        super(out);
    }

    @Override
    public void write(int value) throws IOException {
        if (value == 255) {
            this.out.write(value);
        }
        this.out.write(value);
    }

    @Override
    public void write(byte[] b) throws IOException {
        this.write(b, 0, b.length);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        int limit = off + len;
        for (int i = off; i < limit; ++i) {
            if (b[i] != -1) continue;
            this.out.write(b, off, i + 1 - off);
            off = i;
        }
        this.out.write(b, off, limit - off);
    }

    public void writeCommand(int code) throws IOException {
        this.out.write(255);
        this.out.write(code);
    }

    public final void writeCommand(int code, int option) throws IOException {
        this.out.write(255);
        this.out.write(code);
        this.out.write(option);
    }

    public final void writeDo(int option) throws IOException {
        this.writeCommand(253, option);
    }

    public final void writeDont(int option) throws IOException {
        this.writeCommand(254, option);
    }

    public final void writeWill(int option) throws IOException {
        this.writeCommand(251, option);
    }

    public final void writeWont(int option) throws IOException {
        this.writeCommand(252, option);
    }

    public final void writeSubCommand(int option, byte[] command) throws IOException {
        this.writeCommand(250, option);
        this.write(command);
        this.writeCommand(240);
    }
}

