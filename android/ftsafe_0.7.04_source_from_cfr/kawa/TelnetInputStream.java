/*
 * Decompiled with CFR 0.139.
 */
package kawa;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import kawa.Telnet;

public class TelnetInputStream
extends FilterInputStream {
    Telnet connection;
    protected byte[] buf = new byte[512];
    int pos;
    int count;
    int state = 0;
    int subCommandLength = 0;
    static final int SB_IAC = 400;

    public TelnetInputStream(InputStream in, Telnet conn) throws IOException {
        super(in);
        this.connection = conn;
    }

    @Override
    public int read() throws IOException {
        do {
            if (this.pos >= this.count) {
                int avail = this.in.available();
                if (avail <= 0) {
                    avail = 1;
                } else if (avail > this.buf.length - this.subCommandLength) {
                    avail = this.buf.length - this.subCommandLength;
                }
                avail = this.in.read(this.buf, this.subCommandLength, avail);
                this.pos = this.subCommandLength;
                this.count = avail;
                if (avail <= 0) {
                    return -1;
                }
            }
            int ch = this.buf[this.pos++] & 255;
            if (this.state == 0) {
                if (ch != 255) {
                    return ch;
                }
                this.state = 255;
                continue;
            }
            if (this.state == 255) {
                if (ch == 255) {
                    this.state = 0;
                    return 255;
                }
                if (ch == 251 || ch == 252 || ch == 253 || ch == 254 || ch == 250) {
                    this.state = ch;
                    continue;
                }
                if (ch == 244) {
                    System.err.println("Interrupt Process");
                    this.state = 0;
                    continue;
                }
                if (ch == 236) {
                    return -1;
                }
                this.state = 0;
                continue;
            }
            if (this.state == 251 || this.state == 252 || this.state == 253 || this.state == 254) {
                this.connection.handle(this.state, ch);
                this.state = 0;
                continue;
            }
            if (this.state == 250) {
                if (ch == 255) {
                    this.state = 400;
                    continue;
                }
                this.buf[this.subCommandLength++] = (byte)ch;
                continue;
            }
            if (this.state == 400) {
                if (ch == 255) {
                    this.buf[this.subCommandLength++] = (byte)ch;
                    this.state = 250;
                    continue;
                }
                if (ch == 240) {
                    this.connection.subCommand(this.buf, 0, this.subCommandLength);
                    this.state = 0;
                    this.subCommandLength = 0;
                    continue;
                }
                this.state = 0;
                this.subCommandLength = 0;
                continue;
            }
            System.err.println("Bad state " + this.state);
        } while (true);
    }

    @Override
    public int read(byte[] b, int offset, int length) throws IOException {
        int ch;
        if (length <= 0) {
            return 0;
        }
        int done = 0;
        if (this.state != 0 || this.pos >= this.count) {
            ch = this.read();
            if (ch < 0) {
                return ch;
            }
            b[offset++] = (byte)ch;
            ++done;
        }
        if (this.state == 0) {
            while (this.pos < this.count && done < length && (ch = this.buf[this.pos]) != -1) {
                b[offset++] = ch;
                ++done;
                ++this.pos;
            }
        }
        return done;
    }
}

