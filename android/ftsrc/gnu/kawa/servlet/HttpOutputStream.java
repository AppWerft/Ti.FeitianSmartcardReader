package gnu.kawa.servlet;

import java.io.IOException;
import java.io.OutputStream;

































































class HttpOutputStream
  extends OutputStream
{
  HttpRequestContext context;
  byte[] buffer;
  OutputStream out;
  int count;
  
  public HttpOutputStream(HttpRequestContext context, int bufSize)
  {
    this.context = context;
    buffer = new byte[bufSize];
  }
  
  public void write(int b)
    throws IOException
  {
    if (count >= buffer.length)
      flush();
    buffer[(count++)] = ((byte)b);
  }
  
  public void write(byte[] data, int offset, int length)
    throws IOException
  {
    int avail = buffer.length - count;
    while (length > avail)
    {
      System.arraycopy(data, offset, buffer, count, avail);
      count += avail;
      flush();
      offset += avail;
      length -= avail;
      avail = buffer.length;
    }
    if (length > 0)
    {
      System.arraycopy(data, offset, buffer, count, length);
      count += length;
    }
  }
  
  public boolean reset()
  {
    count = 0;
    return out == null;
  }
  
  public void flush()
    throws IOException
  {
    if (out == null)
    {
      maybeSendResponseHeaders(-1);
      out = context.getResponseStream();
    }
    if (count > 0)
    {
      out.write(buffer, 0, count);
      count = 0;
    }
  }
  
  void maybeSendResponseHeaders(int count)
    throws IOException
  {
    int statusCode = context.statusCode;
    if (statusCode != 64537)
    {
      context.sendResponseHeaders(statusCode, context.statusReasonPhrase, count);
      context.statusCode = 64537;
    }
  }
  
  public void close()
    throws IOException
  {
    if (out == null)
    {
      maybeSendResponseHeaders(count);
      out = context.getResponseStream();
    }
    flush();
    out.close();
  }
}
