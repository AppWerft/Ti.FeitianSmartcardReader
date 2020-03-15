// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.io;

import java.io.OutputStream;
import java.io.PrintStream;

public class TermErrorStream extends PrintStream
{
    public static final byte[] DOMTERM_START_ERR_MARKER;
    public static final byte[] DOMTERM_END_ERR_MARKER;
    public static final byte[] ANSI_START_ERR_MARKER;
    public static final byte[] ANSI_END_ERR_MARKER;
    byte[] startErrMarker;
    byte[] endErrMarker;
    private PrintStream out;
    
    public TermErrorStream(final PrintStream out, final boolean ansi) {
        super(out, true);
        this.out = out;
        if (ansi) {
            this.startErrMarker = TermErrorStream.ANSI_START_ERR_MARKER;
            this.endErrMarker = TermErrorStream.ANSI_END_ERR_MARKER;
        }
        else {
            this.startErrMarker = TermErrorStream.DOMTERM_START_ERR_MARKER;
            this.endErrMarker = TermErrorStream.DOMTERM_END_ERR_MARKER;
        }
    }
    
    public static void setSystemErr(final boolean ansi) {
        if (System.err.getClass().getName().indexOf("DomTermErrorStream") < 0) {
            System.setErr(new TermErrorStream(System.out, ansi));
        }
    }
    
    @Override
    public void write(final int b) {
        synchronized (this.out) {
            this.out.write(this.startErrMarker, 0, this.startErrMarker.length);
            this.out.write(b);
            this.out.write(this.endErrMarker, 0, this.endErrMarker.length);
            if (b == 10) {
                this.out.flush();
            }
        }
    }
    
    @Override
    public void write(final byte[] buf, final int off, final int len) {
        if (len > 0) {
            synchronized (this.out) {
                this.out.write(this.startErrMarker, 0, this.startErrMarker.length);
                this.out.write(buf, off, len);
                this.out.write(this.endErrMarker, 0, this.endErrMarker.length);
                this.out.flush();
            }
        }
    }
    
    static {
        DOMTERM_START_ERR_MARKER = new byte[] { 27, 91, 49, 50, 117 };
        DOMTERM_END_ERR_MARKER = new byte[] { 27, 91, 49, 49, 117 };
        ANSI_START_ERR_MARKER = new byte[] { 27, 91, 51, 49, 109 };
        ANSI_END_ERR_MARKER = new byte[] { 27, 91, 51, 57, 109 };
    }
}
