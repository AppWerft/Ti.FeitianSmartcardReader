package kawa;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

public class TelnetInputStream extends FilterInputStream
{
  Telnet connection;
  protected byte[] buf;
  int pos;
  int count;
  
  public TelnetInputStream(InputStream in, Telnet conn) throws IOException
  {
    super(in);
    buf = new byte['Ȁ'];
    connection = conn;
  }
  






  int state = 0;
  
  int subCommandLength = 0;
  static final int SB_IAC = 400;
  
  public int read()
    throws IOException
  {
    for (;;)
    {
      if (pos >= count)
      {
        int avail = in.available();
        if (avail <= 0) {
          avail = 1;
        } else if (avail > buf.length - subCommandLength)
        {
          avail = buf.length - subCommandLength;
        }
        avail = in.read(buf, subCommandLength, avail);
        pos = subCommandLength;
        count = avail;
        if (avail <= 0)
          return -1;
      }
      int ch = buf[(pos++)] & 0xFF;
      if (state == 0)
      {
        if (ch != 255)
          return ch;
        state = 255;

      }
      else if (state == 255)
      {
        if (ch == 255)
        {
          state = 0;
          return 255;
        }
        if ((ch == 251) || (ch == 252) || (ch == 253) || (ch == 254) || (ch == 250))
        {




          state = ch;
        }
        else if (ch == 244)
        {
          System.err.println("Interrupt Process");
          state = 0;
        } else {
          if (ch == 236)
          {
            return -1;
          }
          

          state = 0;
        }
      }
      else if ((state == 251) || (state == 252) || (state == 253) || (state == 254))
      {

        connection.handle(state, ch);
        state = 0;
      }
      else if (state == 250)
      {
        if (ch == 255) {
          state = 400;
        } else {
          buf[(subCommandLength++)] = ((byte)ch);
        }
      } else if (state == 400)
      {
        if (ch == 255)
        {
          buf[(subCommandLength++)] = ((byte)ch);
          state = 250;
        }
        else if (ch == 240)
        {
          connection.subCommand(buf, 0, subCommandLength);
          state = 0;
          subCommandLength = 0;
        }
        else
        {
          state = 0;
          subCommandLength = 0;
        }
      }
      else {
        System.err.println("Bad state " + state);
      }
    }
  }
  
  public int read(byte[] b, int offset, int length) throws IOException {
    if (length <= 0)
      return 0;
    int done = 0;
    if ((state != 0) || (pos >= count))
    {
      int ch = read();
      if (ch < 0)
        return ch;
      b[(offset++)] = ((byte)ch);
      done++;
    }
    if (state == 0)
    {
      while ((pos < count) && (done < length))
      {
        byte ch = buf[pos];
        if (ch == -1)
          break;
        b[(offset++)] = ch;
        done++;
        pos += 1;
      }
    }
    return done;
  }
}
