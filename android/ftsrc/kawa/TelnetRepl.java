package kawa;

import gnu.expr.Language;
import gnu.kawa.io.FilePath;
import gnu.kawa.io.OutPort;
import gnu.kawa.io.TtyInPort;
import java.io.IOException;
import java.net.Socket;

public class TelnetRepl extends gnu.mapping.Procedure0
{
  Socket socket;
  Language language;
  
  public TelnetRepl(Language language, Socket socket)
  {
    this.language = language;
    this.socket = socket;
  }
  
  public Object apply0()
  {
    try
    {
      Shell.run(language, gnu.mapping.Environment.getCurrent());
      return gnu.mapping.Values.empty;
    }
    finally
    {
      try
      {
        socket.close();
      }
      catch (IOException ex) {}
    }
  }
  







  public static Thread serve(Language language, Socket client)
    throws IOException
  {
    Telnet conn = new Telnet(client, true);
    java.io.OutputStream sout = conn.getOutputStream();
    java.io.InputStream sin = conn.getInputStream();
    OutPort out = new OutPort(sout, FilePath.valueOf("/dev/stdout"));
    TtyInPort in = new TtyInPort(sin, FilePath.valueOf("/dev/stdin"), out);
    






    Runnable r = new gnu.mapping.RunnableClosure(new TelnetRepl(language, client), in, out, out);
    
    Thread thread = new Thread(r);
    thread.start();
    return thread;
  }
}
