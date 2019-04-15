package gnu.kawa.servlet;

import gnu.kawa.io.InPort;
import gnu.kawa.io.Path;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.URL;
import java.util.List;
import java.util.Map;




public abstract class HttpRequestContext
{
  public static final int HTTP_OK = 200;
  public static final int HTTP_NOT_FOUND = 404;
  static final int STATUS_SENT = -999;
  public int statusCode = 200;
  public String statusReasonPhrase = null;
  



  public static int importServletDefinitions;
  


  protected static final ThreadLocal<HttpRequestContext> instance = new ThreadLocal();
  ServletPrinter consumer;
  
  public HttpRequestContext() {}
  
  public static HttpRequestContext getInstance() { HttpRequestContext hctx = (HttpRequestContext)instance.get();
    if (hctx == null)
      throw new UnsupportedOperationException("can only be called by http-server");
    return hctx;
  }
  
  public static HttpRequestContext getInstance(String command)
  {
    HttpRequestContext hctx = (HttpRequestContext)instance.get();
    if (hctx == null)
      throw new UnsupportedOperationException(command + " can only be called within http-server");
    return hctx;
  }
  
  public static void setInstance(HttpRequestContext ctx)
  {
    instance.set(ctx);
  }
  
  public abstract InputStream getRequestStream();
  
  public InPort getRequestPort()
  {
    return new InPort(getRequestStream());
  }
  
  public String getRequestBodyChars()
    throws IOException
  {
    InputStream is = getRequestStream();
    Reader reader = new InputStreamReader(is);
    int buflen = 1024;
    char[] buf = new char[buflen];
    int pos = 0;
    for (;;)
    {
      int avail = buflen - pos;
      if (avail <= 0)
      {
        char[] tmp = new char[2 * buflen];
        System.arraycopy(buf, 0, tmp, 0, buflen);
        buf = tmp;
        buflen += buflen;
      }
      int count = reader.read(buf, pos, avail);
      if (count < 0)
        break;
      pos += count;
    }
    reader.close();
    String str = new String(buf, 0, pos);
    return str;
  }
  



  public abstract OutputStream getResponseStream();
  


  public ServletPrinter getConsumer()
    throws IOException
  {
    if (consumer == null)
      consumer = new ServletPrinter(this, 8192);
    return consumer;
  }
  


  public abstract boolean reset(boolean paramBoolean);
  


  public String getRequestParameter(String name)
  {
    List<String> p = (List)getRequestParameters().get(name);
    return (p == null) || (p.isEmpty()) ? null : (String)p.get(0);
  }
  



  public abstract Map<String, List<String>> getRequestParameters();
  


  public abstract URI getRequestURI();
  


  public abstract String getContextPath();
  


  public String getScriptPath()
  {
    return scriptPath;
  }
  
  public String getLocalPath() { return localPath; }
  
  String scriptPath = ""; String localPath = "";
  
  public void setScriptAndLocalPath(String scriptPath, String localPath) {
    this.scriptPath = scriptPath;
    this.localPath = localPath;
  }
  
  public abstract String getPathTranslated();
  
  public String getRequestPath()
  {
    return getRequestURI().getPath();
  }
  
  public String getRequestScheme()
  {
    return "http";
  }
  
  public InetSocketAddress getLocalSocketAddress()
  {
    return new InetSocketAddress(getLocalHost(), getLocalPort());
  }
  
  public String getLocalIPAddress()
  {
    return getLocalHost().getHostAddress();
  }
  
  public InetAddress getLocalHost()
  {
    try
    {
      return InetAddress.getLocalHost();
    }
    catch (Exception ex)
    {
      throw new RuntimeException(ex);
    }
  }
  

  public abstract int getLocalPort();
  

  public InetSocketAddress getRemoteSocketAddress() { return new InetSocketAddress(getRemoteHost(), getRemotePort()); }
  
  public abstract InetAddress getRemoteHost();
  
  public abstract String getRemoteIPAddress();
  
  public abstract int getRemotePort();
  
  public StringBuffer getRequestURLBuffer() {
    StringBuffer sbuf = new StringBuffer();
    sbuf.append(getRequestScheme());
    sbuf.append("://");
    String host = getRequestHeader("Host");
    if (host != null) {
      sbuf.append(host);
    }
    else {
      sbuf.append(getLocalIPAddress());
      sbuf.append(':');
      sbuf.append(getLocalPort());
    }
    sbuf.append(getRequestPath());
    return sbuf; }
  
  public abstract String getQueryString();
  
  public abstract String getRequestMethod();
  
  public abstract String getRequestHeader(String paramString);
  
  public abstract List<String> getRequestHeaders(String paramString);
  
  public abstract Map<String, List<String>> getRequestHeaders();
  
  public abstract void setResponseHeader(String paramString1, String paramString2);
  
  public void setContentType(String type) { setResponseHeader("Content-Type", type); }
  

  protected String normalizeToContext(String path)
  {
    if ((path.length() > 0) && (path.charAt(0) == '/')) {
      path = path.substring(1);
    } else
      path = getScriptPath() + path;
    if (path.indexOf("..") >= 0)
    {
      path = URI.create(path).normalize().toString();
      if (path.startsWith("../"))
        return null;
    }
    return path;
  }
  



  public abstract URL getResourceURL(String paramString);
  



  public abstract Object getAttribute(String paramString);
  



  public abstract void setAttribute(String paramString, Object paramObject);
  


  public abstract void sendResponseHeaders(int paramInt, String paramString, long paramLong)
    throws IOException;
  


  public void sendNotFound(String path)
    throws IOException
  {
    String msg = "The requested URL " + path + " was not found on this server.\r\n";
    byte[] bmsg = msg.getBytes();
    sendResponseHeaders(404, null, bmsg.length);
    OutputStream out = getResponseStream();
    try
    {
      out.write(bmsg);
    }
    catch (IOException ex)
    {
      throw new RuntimeException(ex);
    }
  }
  
  public abstract void log(String paramString);
  
  public abstract void log(String paramString, Throwable paramThrowable);
  
  public static void handleStaticFile(HttpRequestContext hctx, Path absPath) throws IOException { String contentType = absPath.probeContentType();
    if (contentType != null)
      hctx.setContentType(contentType);
    OutputStream out = hctx.getResponseStream();
    try {
      long len = absPath.getContentLength();
      InputStream in = absPath.openInputStream();
      hctx.sendResponseHeaders(200, null, len);
      byte[] buffer = new byte['က'];
      for (;;) {
        int n = in.read(buffer);
        if (n < 0)
          break;
        out.write(buffer, 0, n);
      }
      out.close();
    } catch (Throwable ex) {
      String msg = "The requested URL " + hctx.getRequestPath() + " was not found on this server.\r\n - " + ex + "\r\n";
      byte[] bmsg = msg.getBytes();
      hctx.sendResponseHeaders(404, null, bmsg.length);
      try {
        out.write(bmsg);
      }
      catch (IOException ex2) {}
    }
  }
}
