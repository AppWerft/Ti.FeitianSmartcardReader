/*
 * Decompiled with CFR 0.139.
 */
package kawa;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import kawa.TelnetInputStream;
import kawa.TelnetOutputStream;

public class Telnet
implements Runnable {
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
    final byte preferredLineMode = (byte)3;
    InputStream sin;
    OutputStream sout;
    TelnetInputStream in;
    TelnetOutputStream out;
    final byte[] optionsState = new byte[256];
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

    boolean change(int command, int option) {
        if (option == 6) {
            return true;
        }
        if (this.isServer && option == 31) {
            return true;
        }
        if (this.isServer && command == 251 && option == 34) {
            byte[] buf = new byte[]{1, 3};
            try {
                this.out.writeSubCommand(34, buf);
            }
            catch (IOException ex) {
                // empty catch block
            }
            return true;
        }
        if (this.isServer && command == 251 && option == 24) {
            byte[] buf = new byte[]{1};
            try {
                this.out.writeSubCommand(option, buf);
            }
            catch (IOException ex) {
                // empty catch block
            }
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

    public void subCommand(byte[] buf, int off, int len) {
        byte command = buf[off];
        switch (command) {
            case 31: {
                if (len != 5) break;
                this.windowWidth = (short)((buf[1] << 8) + (buf[2] & 255));
                this.windowHeight = (short)((buf[3] << 8) + (buf[4] & 255));
                return;
            }
            case 24: {
                byte[] type = new byte[len - 1];
                System.arraycopy(buf, 1, type, 0, len - 1);
                this.terminalType = type;
                System.err.println("terminal type: '" + new String(type) + "'");
                return;
            }
            case 34: {
                System.err.println("SBCommand LINEMODE " + buf[1] + " len:" + len);
                if (buf[1] != 3) break;
                int i = 2;
                while (i + 2 < len) {
                    System.err.println("  " + buf[i] + "," + buf[i + 1] + "," + buf[i + 2]);
                    i += 3;
                }
                return;
            }
        }
    }

    void handle(int command, int option) throws IOException {
        boolean otherSide = command < 253;
        boolean wantOn = (command & 1) != 0;
        int state = this.optionsState[option];
        if (otherSide) {
            state = (byte)(state >> 3);
        }
        switch (state >> 3 & 7) {
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
            }
        }
        state = otherSide ? (int)((byte)(this.optionsState[option] & 199 | state << 3)) : (int)((byte)(this.optionsState[option] & 248 | state));
        this.optionsState[option] = state;
    }

    public void request(int command, int option) throws IOException {
        boolean otherSide = command >= 253;
        boolean wantOn = (command & 1) != 0;
        int state = this.optionsState[option];
        if (otherSide) {
            state = (byte)(state >> 3);
        }
        switch (state & 7) {
            case 0: {
                if (!wantOn) break;
                state = 3;
                this.out.writeCommand(command, option);
                break;
            }
            case 5: {
                if (wantOn) break;
                state = 1;
                this.out.writeCommand(command, option);
                break;
            }
            case 1: {
                if (!wantOn) break;
                state = 2;
                break;
            }
            case 2: {
                if (wantOn) break;
                state = 1;
                break;
            }
            case 3: {
                if (!wantOn) {
                    state = 4;
                }
            }
            case 4: {
                if (!wantOn) break;
                state = 3;
            }
        }
        state = otherSide ? (int)((byte)(this.optionsState[option] & 199 | state << 3)) : (int)((byte)(this.optionsState[option] & 248 | state));
        this.optionsState[option] = state;
    }

    static void usage() {
        System.err.println("Usage:  [java] kawa.Telnet HOST [PORT#]");
        System.exit(-1);
    }

    public static void main(String[] args) {
        if (args.length == 0) {
            Telnet.usage();
        }
        String host = args[0];
        int port = 23;
        if (args.length > 1) {
            port = Integer.parseInt(args[1]);
        }
        try {
            int ch;
            Socket socket = new Socket(host, port);
            Telnet telnet = new Telnet(socket, false);
            TelnetOutputStream tout = telnet.getOutputStream();
            Thread t = new Thread(telnet);
            t.setPriority(Thread.currentThread().getPriority() + 1);
            t.start();
            byte[] buffer = new byte[1024];
            while ((ch = System.in.read()) >= 0) {
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

    public Telnet(Socket socket, boolean isServer) throws IOException {
        this.sin = socket.getInputStream();
        this.sout = socket.getOutputStream();
        this.out = new TelnetOutputStream(this.sout);
        this.in = new TelnetInputStream(this.sin, this);
        this.isServer = isServer;
    }

    @Override
    public void run() {
        try {
            int ch;
            TelnetInputStream tin = this.getInputStream();
            byte[] buffer = new byte[1024];
            while ((ch = tin.read()) >= 0) {
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

