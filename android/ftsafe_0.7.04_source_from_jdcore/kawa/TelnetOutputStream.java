package kawa;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;



public class TelnetOutputStream
  extends FilterOutputStream
{
  public TelnetOutputStream(OutputStream out)
  {
    super(out);
  }
  
  public void write(int value) throws IOException
  {
    if (value == 255)
      out.write(value);
    out.write(value);
  }
  
  public void write(byte[] b) throws IOException
  {
    write(b, 0, b.length);
  }
  
  public void write(byte[] b, int off, int len)
    throws IOException
  {
    int limit = off + len;
    for (int i = off; i < limit; i++)
    {
      if (b[i] == -1)
      {

        out.write(b, off, i + 1 - off);
        

        off = i;
      }
    }
    
    out.write(b, off, limit - off);
  }
  
  public void writeCommand(int code) throws IOException
  {
    out.write(255);
    out.write(code);
  }
  
  public final void writeCommand(int code, int option) throws IOException
  {
    out.write(255);
    out.write(code);
    out.write(option);
  }
  
  public final void writeDo(int option) throws IOException
  {
    writeCommand(253, option);
  }
  
  public final void writeDont(int option) throws IOException
  {
    writeCommand(254, option);
  }
  
  public final void writeWill(int option) throws IOException
  {
    writeCommand(251, option);
  }
  
  public final void writeWont(int option) throws IOException
  {
    writeCommand(252, option);
  }
  
  public final void writeSubCommand(int option, byte[] command)
    throws IOException
  {
    writeCommand(250, option);
    write(command);
    writeCommand(240);
  }
}
