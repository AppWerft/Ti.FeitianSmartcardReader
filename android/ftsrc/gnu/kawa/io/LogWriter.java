package gnu.kawa.io;

import java.io.FilterWriter;
import java.io.IOException;
import java.io.Writer;

public class LogWriter extends FilterWriter
{
  private Writer log;
  
  public LogWriter(Writer out)
  {
    super(out);
  }
  
  public final Writer getLogFile() { return log; }
  
  public void setLogFile(Writer log)
  {
    this.log = log;
  }
  

  public void setLogFile(String name)
    throws IOException
  {
    log = new java.io.PrintWriter(new java.io.BufferedWriter(new java.io.FileWriter(name)));
  }
  



  public void closeLogFile()
    throws IOException
  {
    if (log != null)
      log.close();
    log = null;
  }
  
  public void write(int c) throws IOException
  {
    if (log != null)
      log.write(c);
    super.write(c);
  }
  
  public void echo(char[] buf, int off, int len) throws IOException
  {
    if (log != null) {
      log.write(buf, off, len);
    }
  }
  
  public void write(char[] buf, int off, int len) throws IOException {
    if (log != null)
      log.write(buf, off, len);
    super.write(buf, off, len);
  }
  
  public void write(String str, int off, int len) throws IOException
  {
    if (log != null)
      log.write(str, off, len);
    super.write(str, off, len);
  }
  
  public void flush() throws IOException
  {
    if (log != null)
      log.flush();
    super.flush();
  }
  
  public void close() throws IOException
  {
    if (log != null)
      log.close();
    super.close();
  }
}
