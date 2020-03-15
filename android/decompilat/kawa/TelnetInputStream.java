// 
// Decompiled by Procyon v0.5.36
// 

package kawa;

import java.io.IOException;
import java.io.InputStream;
import java.io.FilterInputStream;

public class TelnetInputStream extends FilterInputStream
{
    Telnet connection;
    protected byte[] buf;
    int pos;
    int count;
    int state;
    int subCommandLength;
    static final int SB_IAC = 400;
    
    public TelnetInputStream(final InputStream in, final Telnet conn) throws IOException {
        super(in);
        this.state = 0;
        this.subCommandLength = 0;
        this.buf = new byte[512];
        this.connection = conn;
    }
    
    @Override
    public int read() throws IOException {
        while (true) {
            if (this.pos >= this.count) {
                int avail = this.in.available();
                if (avail <= 0) {
                    avail = 1;
                }
                else if (avail > this.buf.length - this.subCommandLength) {
                    avail = this.buf.length - this.subCommandLength;
                }
                avail = this.in.read(this.buf, this.subCommandLength, avail);
                this.pos = this.subCommandLength;
                if ((this.count = avail) <= 0) {
                    return -1;
                }
            }
            final int ch = this.buf[this.pos++] & 0xFF;
            if (this.state == 0) {
                if (ch != 255) {
                    return ch;
                }
                this.state = 255;
            }
            else if (this.state == 255) {
                if (ch == 255) {
                    this.state = 0;
                    return 255;
                }
                if (ch == 251 || ch == 252 || ch == 253 || ch == 254 || ch == 250) {
                    this.state = ch;
                }
                else if (ch == 244) {
                    System.err.println("Interrupt Process");
                    this.state = 0;
                }
                else {
                    if (ch == 236) {
                        return -1;
                    }
                    this.state = 0;
                }
            }
            else if (this.state == 251 || this.state == 252 || this.state == 253 || this.state == 254) {
                this.connection.handle(this.state, ch);
                this.state = 0;
            }
            else if (this.state == 250) {
                if (ch == 255) {
                    this.state = 400;
                }
                else {
                    this.buf[this.subCommandLength++] = (byte)ch;
                }
            }
            else if (this.state == 400) {
                if (ch == 255) {
                    this.buf[this.subCommandLength++] = (byte)ch;
                    this.state = 250;
                }
                else if (ch == 240) {
                    this.connection.subCommand(this.buf, 0, this.subCommandLength);
                    this.state = 0;
                    this.subCommandLength = 0;
                }
                else {
                    this.state = 0;
                    this.subCommandLength = 0;
                }
            }
            else {
                System.err.println("Bad state " + this.state);
            }
        }
    }
    
    @Override
    public int read(final byte[] b, int offset, final int length) throws IOException {
        if (length <= 0) {
            return 0;
        }
        int done = 0;
        if (this.state != 0 || this.pos >= this.count) {
            final int ch = this.read();
            if (ch < 0) {
                return ch;
            }
            b[offset++] = (byte)ch;
            ++done;
        }
        if (this.state == 0) {
            while (this.pos < this.count && done < length) {
                final byte ch2 = this.buf[this.pos];
                if (ch2 == -1) {
                    break;
                }
                b[offset++] = ch2;
                ++done;
                ++this.pos;
            }
        }
        return done;
    }
}
