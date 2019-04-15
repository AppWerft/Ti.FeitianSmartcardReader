package gnu.kawa.io;

import java.io.PrintStream;








public class TermErrorStream
  extends PrintStream
{
  public static final byte[] DOMTERM_START_ERR_MARKER = { 27, 91, 49, 50, 117 };
  





  public static final byte[] DOMTERM_END_ERR_MARKER = { 27, 91, 49, 49, 117 };
  





  public static final byte[] ANSI_START_ERR_MARKER = { 27, 91, 51, 49, 109 };
  





  public static final byte[] ANSI_END_ERR_MARKER = { 27, 91, 51, 57, 109 };
  

  byte[] startErrMarker;
  

  byte[] endErrMarker;
  
  private PrintStream out;
  

  public TermErrorStream(PrintStream out, boolean ansi)
  {
    super(out, true);
    this.out = out;
    if (ansi) {
      startErrMarker = ANSI_START_ERR_MARKER;
      endErrMarker = ANSI_END_ERR_MARKER;
    } else {
      startErrMarker = DOMTERM_START_ERR_MARKER;
      endErrMarker = DOMTERM_END_ERR_MARKER;
    }
  }
  


  public static void setSystemErr(boolean ansi)
  {
    if (System.err.getClass().getName().indexOf("DomTermErrorStream") < 0)
    {
      System.setErr(new TermErrorStream(System.out, ansi));
    }
  }
  
  public void write(int b) {
    synchronized (out) {
      out.write(startErrMarker, 0, startErrMarker.length);
      out.write(b);
      out.write(endErrMarker, 0, endErrMarker.length);
      if (b == 10) {
        out.flush();
      }
    }
  }
  
  public void write(byte[] buf, int off, int len) {
    if (len > 0) {
      synchronized (out) {
        out.write(startErrMarker, 0, startErrMarker.length);
        out.write(buf, off, len);
        out.write(endErrMarker, 0, endErrMarker.length);
        out.flush();
      }
    }
  }
}
