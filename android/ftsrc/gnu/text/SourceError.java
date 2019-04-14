package gnu.text;

import gnu.kawa.io.InPort;
import java.io.File;
import java.io.IOException;

























public class SourceError
  implements SourceLocator
{
  public SourceError next;
  public char severity;
  public String filename;
  public String code;
  public int line;
  public int column;
  public String message;
  public Throwable fakeException;
  
  public SourceError(char severity, String filename, int line, int column, String message)
  {
    this.severity = severity;
    this.filename = filename;
    this.line = line;
    this.column = column;
    this.message = message;
  }
  
  public SourceError(char severity, SourceLocator location, String message) {
    this(severity, location.getFileName(), location.getLineNumber(), location.getColumnNumber(), message);
  }
  


  public SourceError(InPort port, char severity, String message)
  {
    this(severity, port.getName(), port.getLineNumber() + 1, port.getColumnNumber(), message);
    

    if (column >= 0) {
      column += 1;
    }
  }
  

  public String toString()
  {
    return toString(false);
  }
  


  public String toString(boolean stripDirectories)
  {
    StringBuilder buffer = new StringBuilder();
    appendTo(buffer, stripDirectories, null);
    return buffer.toString();
  }
  
  public void appendTo(Appendable out, boolean stripDirectories, String newLine) {
    try {
      String fname;
      String fname;
      if (filename == null) {
        fname = "<unknown>";
      } else {
        fname = filename;
        if (stripDirectories)
          fname = new File(fname).getName();
      }
      out.append(fname);
      if ((line > 0) || (column > 0)) {
        out.append(':');
        out.append(Integer.toString(line));
        if (column > 0) {
          out.append(':');
          out.append(Integer.toString(column));
        }
      }
      out.append(": ");
      if (severity == 'w') {
        out.append("warning - ");
      } else if (severity == 'i')
        out.append("note - ");
      out.append(message);
      if (code != null) {
        out.append(" [");
        out.append(code);
        out.append("]");
      }
      
      if (fakeException != null) {
        StackTraceElement[] stackTrace = fakeException.getStackTrace();
        for (int i = 0; i < stackTrace.length; i++) {
          out.append(newLine != null ? newLine : "\n");
          out.append("    ");
          out.append(stackTrace[i].toString());
        }
      }
      if (newLine != null)
        out.append(newLine);
    } catch (IOException ex) {
      throw new RuntimeException(ex);
    }
  }
  
  public void print(Appendable out) {
    appendTo(out, false, null);
  }
  
  public void println(Appendable out, boolean stripDirectories) {
    appendTo(out, stripDirectories, System.getProperty("line.separator", "\n"));
  }
  

  public int getLineNumber() { return line == 0 ? -1 : line; }
  public int getColumnNumber() { return column == 0 ? -1 : column; }
  public String getPublicId() { return null; }
  public String getSystemId() { return filename; }
  public String getFileName() { return filename; }
  public boolean isStableSourceLocation() { return true; }
}
