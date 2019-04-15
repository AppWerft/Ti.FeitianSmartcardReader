/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.io;

import java.io.OutputStream;
import java.io.PrintStream;

public class TermErrorStream
extends PrintStream {
    public static final byte[] DOMTERM_START_ERR_MARKER = new byte[]{27, 91, 49, 50, 117};
    public static final byte[] DOMTERM_END_ERR_MARKER = new byte[]{27, 91, 49, 49, 117};
    public static final byte[] ANSI_START_ERR_MARKER = new byte[]{27, 91, 51, 49, 109};
    public static final byte[] ANSI_END_ERR_MARKER = new byte[]{27, 91, 51, 57, 109};
    byte[] startErrMarker;
    byte[] endErrMarker;
    private PrintStream out;

    public TermErrorStream(PrintStream out, boolean ansi) {
        super(out, true);
        this.out = out;
        if (ansi) {
            this.startErrMarker = ANSI_START_ERR_MARKER;
            this.endErrMarker = ANSI_END_ERR_MARKER;
        } else {
            this.startErrMarker = DOMTERM_START_ERR_MARKER;
            this.endErrMarker = DOMTERM_END_ERR_MARKER;
        }
    }

    public static void setSystemErr(boolean ansi) {
        if (System.err.getClass().getName().indexOf("DomTermErrorStream") < 0) {
            System.setErr(new TermErrorStream(System.out, ansi));
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void write(int b) {
        PrintStream printStream = this.out;
        synchronized (printStream) {
            this.out.write(this.startErrMarker, 0, this.startErrMarker.length);
            this.out.write(b);
            this.out.write(this.endErrMarker, 0, this.endErrMarker.length);
            if (b == 10) {
                this.out.flush();
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void write(byte[] buf, int off, int len) {
        if (len > 0) {
            PrintStream printStream = this.out;
            synchronized (printStream) {
                this.out.write(this.startErrMarker, 0, this.startErrMarker.length);
                this.out.write(buf, off, len);
                this.out.write(this.endErrMarker, 0, this.endErrMarker.length);
                this.out.flush();
            }
        }
    }
}

