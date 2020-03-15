// 
// Decompiled by Procyon v0.5.36
// 

package kawa;

import java.net.Socket;
import java.io.IOException;
import java.io.OutputStream;
import java.io.InputStream;

public class Telnet implements Runnable
{
    boolean isServer;
    static final int SE = 240;
    static final int NOP = 241;
    static final int IP = 244;
    static final int EOF = 236;
    static final int SB = 250;
    public static final int WILL = 251;
    public static final int WONT = 252;
    public static final int DO = 253;
    public static final int DONT = 254;
    static final int IAC = 255;
    public static final int ECHO = 1;
    public static final int SUPPRESS_GO_AHEAD = 3;
    static final int TM = 6;
    static final int TTYPE = 24;
    static final int NAWS = 31;
    static final int LINEMODE = 34;
    public short windowHeight;
    public short windowWidth;
    public byte[] terminalType;
    final byte preferredLineMode = 3;
    InputStream sin;
    OutputStream sout;
    TelnetInputStream in;
    TelnetOutputStream out;
    final byte[] optionsState;
    static final int OPTION_NO = 0;
    static final int OPTION_WANTNO = 1;
    static final int OPTION_WANTNO_OPPOSITE = 2;
    static final int OPTION_WANTYES = 3;
    static final int OPTION_WANTYES_OPPOSITE = 4;
    static final int OPTION_YES = 5;
    
    public TelnetInputStream getInputStream() {
        return this.in;
    }
    
    public TelnetOutputStream getOutputStream() {
        return this.out;
    }
    
    boolean change(final int command, final int option) {
        if (option == 6) {
            return true;
        }
        if (this.isServer && option == 31) {
            return true;
        }
        if (this.isServer && command == 251 && option == 34) {
            final byte[] buf = { 1, 3 };
            try {
                this.out.writeSubCommand(34, buf);
            }
            catch (IOException ex) {}
            return true;
        }
        if (this.isServer && command == 251 && option == 24) {
            final byte[] buf = { 1 };
            try {
                this.out.writeSubCommand(option, buf);
            }
            catch (IOException ex2) {}
            return true;
        }
        if (!this.isServer && option == 1) {
            if (command == 253) {
                return false;
            }
            if (command == 251) {
                return true;
            }
        }
        return false;
    }
    
    public void subCommand(final byte[] buf, final int off, final int len) {
        final int command = buf[off];
        switch (command) {
            case 31: {
                if (len == 5) {
                    this.windowWidth = (short)((buf[1] << 8) + (buf[2] & 0xFF));
                    this.windowHeight = (short)((buf[3] << 8) + (buf[4] & 0xFF));
                    return;
                }
                break;
            }
            case 24: {
                final byte[] type = new byte[len - 1];
                System.arraycopy(buf, 1, type, 0, len - 1);
                this.terminalType = type;
                System.err.println("terminal type: '" + new String(type) + "'");
            }
            case 34: {
                System.err.println("SBCommand LINEMODE " + buf[1] + " len:" + len);
                if (buf[1] == 3) {
                    for (int i = 2; i + 2 < len; i += 3) {
                        System.err.println("  " + buf[i] + "," + buf[i + 1] + "," + buf[i + 2]);
                    }
                    return;
                }
                break;
            }
        }
    }
    
    void handle(final int command, final int option) throws IOException {
        final boolean otherSide = command < 253;
        final boolean wantOn = (command & 0x1) != 0x0;
        byte state = this.optionsState[option];
        if (otherSide) {
            state >>= 3;
        }
        switch (state >> 3 & 0x7) {
            case 5: {
                if (wantOn) {
                    return;
                }
                state = 0;
                this.change(command, option);
                this.out.writeCommand(otherSide ? 254 : 252, option);
                break;
            }
            case 0: {
                if (!wantOn) {
                    return;
                }
                if (this.change(command, option)) {
                    state = 5;
                    this.out.writeCommand(otherSide ? 253 : 251, option);
                    break;
                }
                this.out.writeCommand(otherSide ? 254 : 252, option);
                break;
            }
            case 1: {
                state = 0;
                break;
            }
            case 2: {
                state = 3;
                this.out.writeCommand(otherSide ? 253 : 251, option);
                break;
            }
            case 3: {
                if (wantOn) {
                    state = 5;
                    this.change(command, option);
                    break;
                }
                state = 0;
                break;
            }
            case 4: {
                if (wantOn) {
                    state = 1;
                    this.out.writeCommand(otherSide ? 254 : 252, option);
                    break;
                }
                state = 0;
                break;
            }
        }
        if (otherSide) {
            state = (byte)((this.optionsState[option] & 0xC7) | state << 3);
        }
        else {
            state |= (byte)(this.optionsState[option] & 0xF8);
        }
        this.optionsState[option] = state;
    }
    
    public void request(final int command, final int option) throws IOException {
        final boolean otherSide = command >= 253;
        final boolean wantOn = (command & 0x1) != 0x0;
        byte state = this.optionsState[option];
        if (otherSide) {
            state >>= 3;
        }
        switch (state & 0x7) {
            case 0: {
                if (wantOn) {
                    state = 3;
                    this.out.writeCommand(command, option);
                    break;
                }
                break;
            }
            case 5: {
                if (!wantOn) {
                    state = 1;
                    this.out.writeCommand(command, option);
                    break;
                }
                break;
            }
            case 1: {
                if (wantOn) {
                    state = 2;
                    break;
                }
                break;
            }
            case 2: {
                if (!wantOn) {
                    state = 1;
                    break;
                }
                break;
            }
            case 3: {
                if (!wantOn) {
                    state = 4;
                }
            }
            case 4: {
                if (wantOn) {
                    state = 3;
                    break;
                }
                break;
            }
        }
        if (otherSide) {
            state = (byte)((this.optionsState[option] & 0xC7) | state << 3);
        }
        else {
            state |= (byte)(this.optionsState[option] & 0xF8);
        }
        this.optionsState[option] = state;
    }
    
    static void usage() {
        System.err.println("Usage:  [java] kawa.Telnet HOST [PORT#]");
        System.exit(-1);
    }
    
    public static void main(final String[] args) {
        if (args.length == 0) {
            usage();
        }
        final String host = args[0];
        int port = 23;
        if (args.length > 1) {
            port = Integer.parseInt(args[1]);
        }
        try {
            final Socket socket = new Socket(host, port);
            final Telnet telnet = new Telnet(socket, false);
            final TelnetOutputStream tout = telnet.getOutputStream();
            final Thread t = new Thread(telnet);
            t.setPriority(Thread.currentThread().getPriority() + 1);
            t.start();
            final byte[] buffer = new byte[1024];
            while (true) {
                final int ch = System.in.read();
                if (ch < 0) {
                    break;
                }
                buffer[0] = (byte)ch;
                int avail = System.in.available();
                if (avail > 0) {
                    if (avail > buffer.length - 1) {
                        avail = buffer.length - 1;
                    }
                    avail = System.in.read(buffer, 1, avail);
                }
                tout.write(buffer, 0, avail + 1);
            }
            t.stop();
        }
        catch (Exception ex) {
            System.err.println(ex);
        }
    }
    
    public Telnet(final Socket socket, final boolean isServer) throws IOException {
        this.optionsState = new byte[256];
        this.sin = socket.getInputStream();
        this.sout = socket.getOutputStream();
        this.out = new TelnetOutputStream(this.sout);
        this.in = new TelnetInputStream(this.sin, this);
        this.isServer = isServer;
    }
    
    @Override
    public void run() {
        try {
            final TelnetInputStream tin = this.getInputStream();
            final byte[] buffer = new byte[1024];
            while (true) {
                final int ch = tin.read();
                if (ch < 0) {
                    break;
                }
                buffer[0] = (byte)ch;
                int avail = tin.available();
                if (avail > 0) {
                    if (avail > buffer.length - 1) {
                        avail = buffer.length - 1;
                    }
                    avail = tin.read(buffer, 1, avail);
                }
                System.out.write(buffer, 0, avail + 1);
            }
        }
        catch (IOException ex) {
            System.err.println(ex);
            System.exit(-1);
        }
    }
}
