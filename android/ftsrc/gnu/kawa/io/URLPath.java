package gnu.kawa.io;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;

public class URLPath extends URIPath
{
  final URL url;
  
  URLPath(URL url)
  {
    super(toUri(url));
    


    this.url = url;
  }
  
  public static URLPath valueOf(URL url)
  {
    return new URLPath(url);
  }
  
  public boolean isAbsolute()
  {
    return true;
  }
  
  public long getLastModified()
  {
    return getLastModified(url);
  }
  
  public static long getLastModified(URL url)
  {
    try
    {
      return url.openConnection().getLastModified();
    }
    catch (Exception ex) {}
    
    return 0L;
  }
  

  public long getContentLength()
  {
    return getContentLength(url);
  }
  
  public static int getContentLength(URL url)
  {
    try
    {
      return url.openConnection().getContentLength();
    }
    catch (Exception ex) {}
    
    return -1;
  }
  

  public URL toURL()
  {
    return url;
  }
  


  public static URI toUri(URL url)
  {
    try
    {
      return url.toURI();


    }
    catch (Exception ex)
    {

      throw gnu.mapping.WrappedException.wrapIfNeeded(ex);
    }
  }
  
  public URI toUri() { return toUri(url); }
  public String toURIString() { return url.toString(); }
  



  public Path resolve(String relative)
  {
    try
    {
      return valueOf(resolveToUri(relative).toURL());
    } catch (MalformedURLException ex) {
      throw new RuntimeException(ex);
    }
  }
  
  public static java.io.InputStream openInputStream(URL url) throws IOException
  {
    return url.openConnection().getInputStream();
  }
  
  public java.io.InputStream openInputStream() throws IOException
  {
    return openInputStream(url);
  }
  
  public static java.io.OutputStream openOutputStream(URL url) throws IOException
  {
    String str = url.toString();
    


    if (str.startsWith("file:")) {
      try
      {
        return new java.io.FileOutputStream(new java.io.File(new URI(str)));
      }
      catch (Exception ex) {}
    }
    

    URLConnection conn = url.openConnection();
    conn.setDoInput(false);
    conn.setDoOutput(true);
    return conn.getOutputStream();
  }
  
  public java.io.OutputStream openOutputStream() throws IOException
  {
    return openOutputStream(url);
  }
}
