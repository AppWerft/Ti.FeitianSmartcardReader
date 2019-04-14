package gnu.kawa.io;

import gnu.mapping.WrappedException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;

public class URIPath extends Path implements Comparable<URIPath>
{
  final URI uri;
  
  URIPath(URI uri)
  {
    this.uri = uri;
  }
  
  public static URIPath coerceToURIPathOrNull(Object path) {
    if ((path instanceof URIPath))
      return (URIPath)path;
    if ((path instanceof URL)) {
      return URLPath.valueOf((URL)path);
    }
    if ((path instanceof URI)) {
      return valueOf((URI)path);
    }
    String str;
    if (((path instanceof CharSequence)) || ((path instanceof File)) || ((path instanceof Path)))
    {
      str = path.toString();
    } else
      return null;
    String str; return valueOf(str);
  }
  
  public static URIPath makeURI(Object arg)
  {
    URIPath path = coerceToURIPathOrNull(arg);
    if (path == null)
      throw new gnu.mapping.WrongType((String)null, -4, arg, "URI");
    return path;
  }
  
  public static URIPath valueOf(URI uri)
  {
    return new URIPath(uri);
  }
  

  public static URIPath valueOf(String uri)
  {
    try
    {
      return new URIStringPath(new URI(encodeForUri(uri, 'I')), uri);
    }
    catch (Exception ex)
    {
      throw WrappedException.wrapIfNeeded(ex);
    }
  }
  




  public boolean isAbsolute()
  {
    return uri.isAbsolute();
  }
  



  public boolean exists()
  {
    try
    {
      URLConnection conn = toURL().openConnection();
      if ((conn instanceof HttpURLConnection)) {
        return ((HttpURLConnection)conn).getResponseCode() == 200;
      }
      
      return conn.getLastModified() != 0L;
    }
    catch (Exception ex) {}
    
    return false;
  }
  

  public long getLastModified()
  {
    return URLPath.getLastModified(toURL());
  }
  
  public long getContentLength()
  {
    return URLPath.getContentLength(toURL());
  }
  

  public URI toUri() { return uri; }
  public String toURIString() { return uri.toString(); }
  



  public Path resolve(String rstr)
  {
    char fileSep = File.separatorChar;
    if (fileSep != '/')
    {
      if ((rstr.length() >= 2) && (((rstr.charAt(1) == ':') && (Character.isLetter(rstr.charAt(0)))) || ((rstr.charAt(0) == fileSep) && (rstr.charAt(1) == fileSep))))
      {

        return FilePath.valueOf(new File(rstr));
      }
      rstr = rstr.replace(fileSep, '/');
    }
    return valueOf(resolveToUri(rstr));
  }
  
  public URI resolveToUri(String rstr) {
    try {
      URI r = new URI(rstr);
      if (uri.isOpaque())
        return r;
      String bScheme = getScheme();
      String bAuthority = getAuthority();
      String bPath = getPath();
      String bQuery = getQuery();
      String bFragment = getFragment();
      String rScheme = r.getScheme();
      String rAuthority = r.getAuthority();
      String rPath = r.getPath();
      String rQuery = r.getQuery();
      String rFragment = r.getFragment();
      String tScheme = rScheme != null ? rScheme : bScheme;
      


      boolean removeDotsNeeded = true;
      String tQuery; String tAuthority; String tPath; String tQuery; if ((rScheme != null) || (rAuthority != null)) {
        String tAuthority = rAuthority;
        String tPath = rPath;
        tQuery = rQuery;
      } else {
        tAuthority = bAuthority;
        String tQuery; if ((rPath == null) || (rPath.length() == 0)) {
          String tPath = bPath;
          removeDotsNeeded = false;
          tQuery = rQuery != null ? rQuery : bQuery;
        } else { String tPath;
          if (rPath.charAt(0) == '/') {
            tPath = rPath;
          } else {
            String tPath;
            if ((bAuthority != null) && (bPath.length() == 0)) {
              tPath = "/" + rPath;
            } else {
              int bSlash = bPath.lastIndexOf('/');
              String tPath; if (bSlash >= 0) {
                tPath = bPath.substring(0, bSlash + 1) + rPath;
              } else
                tPath = rPath;
            }
          }
          tQuery = rQuery;
        }
      }
      int len = tPath.length();
      if ((removeDotsNeeded) && (len > 0)) {
        StringBuilder pbuf = new StringBuilder();
        int ch0 = tPath.charAt(0);
        int i = 1;
        while (ch0 >= 0)
        {




          if ((ch0 == 46) && (i + 1 < len) && (tPath.charAt(i) == '.') && (tPath.charAt(i + 1) == '/')) {
            if (tScheme != null)
            {
              ch0 = i + 2 < len ? tPath.charAt(i + 2) : -1;
              i += 3;
            } else {
              pbuf.append("..");
              ch0 = 47;
              i += 2;
            }
            
          }
          else if ((ch0 == 46) && (i < len) && (tPath.charAt(i) == '/')) {
            ch0 = i + 1 < len ? tPath.charAt(i + 1) : -1;
            i += 2;

          }
          else if ((ch0 == 47) && (i < len) && (tPath.charAt(i) == '.') && ((i + 1 == len) || (tPath.charAt(i + 1) == '/')))
          {


            ch0 = 47;
            i = i + 1 == len ? len : i + 2;

          }
          else if ((ch0 == 47) && (i + 1 < len) && (tPath.charAt(i) == '.') && (tPath.charAt(i + 1) == '.') && ((i + 2 == len) || (tPath.charAt(i + 2) == '/')))
          {


            ch0 = 47;
            i = i + 2 == len ? len : i + 3;
            int plen = pbuf.length();
            while ((plen > 0) && (pbuf.charAt(--plen) != '/')) {}
            
            pbuf.setLength(plen);

          }
          else if ((ch0 == 46) && ((i == len) || ((i + 1 == len) && (tPath.charAt(i) == '.'))))
          {
            ch0 = -1;
          } else {
            do {
              pbuf.append((char)ch0);
              if (i == len) {
                ch0 = -1;
                break;
              }
              ch0 = tPath.charAt(i++);
            } while (ch0 != 47);
          }
        }
        


        tPath = pbuf.toString();
      }
      return new URI(tScheme, tAuthority, tPath, tQuery, rFragment);
    } catch (Exception ex) {
      throw WrappedException.wrapIfNeeded(ex);
    }
  }
  
  public int compareTo(URIPath path)
  {
    return uri.compareTo(uri);
  }
  







  public boolean equals(Object obj)
  {
    return ((obj instanceof URIPath)) && (uri.equals(uri));
  }
  
  public int hashCode()
  {
    return uri.hashCode();
  }
  
  public String toString()
  {
    return toURIString();
  }
  
  public URL toURL()
  {
    return Path.toURL(uri.toString());
  }
  
  public File toFile() {
    return FilePath.valueOf(toURIString()).toFile();
  }
  
  public InputStream openInputStream()
    throws IOException
  {
    return URLPath.openInputStream(toURL());
  }
  
  public OutputStream openOutputStream() throws IOException
  {
    return URLPath.openOutputStream(toURL());
  }
  
  public String getScheme()
  {
    return uri.getScheme();
  }
  
  public String getHost()
  {
    return uri.getHost();
  }
  

  public String getAuthority()
  {
    return uri.getAuthority();
  }
  




  public String getUserInfo()
  {
    return uri.getUserInfo();
  }
  




  public int getPort()
  {
    return uri.getPort();
  }
  




  public String getPath()
  {
    return uri.getPath();
  }
  




  public String getQuery()
  {
    return uri.getQuery();
  }
  




  public String getFragment()
  {
    return uri.getFragment();
  }
  




  public Path getCanonical()
  {
    if (isAbsolute())
    {

      URI norm = uri.normalize();
      if (norm == uri)
        return this;
      return valueOf(norm);
    }
    



    return getAbsolute().getCanonical();
  }
  
  public static String encodeForUri(String str, char mode)
  {
    StringBuffer sbuf = new StringBuffer();
    int len = str.length();
    for (int i = 0; i < len;)
    {
      int ch = str.charAt(i++);
      
      if ((ch >= 55296) && (ch < 56320) && (i < len)) {
        ch = (ch - 55296) * 1024 + (str.charAt(i++) - 56320) + 65536;
      }
      if (mode == 'H' ? (ch < 32) && (ch > 126) : ((ch >= 97) && (ch <= 122)) || ((ch >= 65) && (ch <= 90)) || ((ch >= 48) && (ch <= 57)) || (ch == 45) || (ch == 95) || (ch == 46) || (ch == 126) || ((mode == 'I') && ((ch == 59) || (ch == 47) || (ch == 63) || (ch == 58) || (ch == 42) || (ch == 39) || (ch == 40) || (ch == 41) || (ch == 64) || (ch == 38) || (ch == 61) || (ch == 43) || (ch == 36) || (ch == 44) || (ch == 91) || (ch == 93) || (ch == 35) || (ch == 33) || (ch == 37))))
      {








        sbuf.append((char)ch);
      }
      else {
        int pos = sbuf.length();
        int nbytes = 0;
        int needed = ch < 65536 ? 3 : ch < 2048 ? 2 : ch < 128 ? 1 : 4;
        



        do
        {
          int availbits = nbytes == 0 ? 7 : 6 - nbytes;
          int b;
          if (ch < 1 << availbits)
          {

            int b = ch;
            if (nbytes > 0)
              b |= 65408 >> nbytes & 0xFF;
            ch = 0;
          }
          else
          {
            b = 0x80 | ch & 0x3F;
            ch >>= 6;
          }
          nbytes++;
          for (int j = 0; j <= 1; j++)
          {
            int hex = b & 0xF;
            sbuf.insert(pos, (char)(hex <= 9 ? hex + 48 : hex - 10 + 65));
            
            b >>= 4;
          }
          sbuf.insert(pos, '%');
        }
        while (ch != 0);
      }
    }
    return sbuf.toString();
  }
}
