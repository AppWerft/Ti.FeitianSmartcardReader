package gnu.text;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;
















public class ResourceStreamHandler
  extends URLStreamHandler
{
  public static final String CLASS_RESOURCE_URI_PREFIX = "class-resource:/";
  public static final int CLASS_RESOURCE_URI_PREFIX_LENGTH = 16;
  ClassLoader cloader;
  Class clas;
  
  public ResourceStreamHandler(Class clas)
  {
    this.clas = clas;
    cloader = clas.getClassLoader();
  }
  
  public ResourceStreamHandler(ClassLoader cloader)
  {
    this.cloader = cloader;
  }
  
  public static URL makeURL(Class clas)
    throws MalformedURLException
  {
    String cname = clas.getName();
    int dot = cname.lastIndexOf('.');
    
    StringBuilder sbuf = new StringBuilder();
    


    sbuf.append("class-resource:/");
    if (dot >= 0)
    {
      sbuf.append(cname.substring(0, dot));
      sbuf.append('/');
      cname = cname.substring(dot + 1);
    }
    sbuf.append(cname);
    String str = sbuf.toString();
    return new URL(null, str, new ResourceStreamHandler(clas));
  }
  
  public URLConnection openConnection(URL u) throws IOException
  {
    String ustr = u.toString();
    String rstr = ustr.substring(16);
    int sl = rstr.indexOf('/');
    if (sl > 0)
      rstr = rstr.substring(0, sl).replace('.', '/') + rstr.substring(sl);
    URL url = cloader.getResource(rstr);
    if ((url == null) && (clas != null)) {
      String clasName = clas.getName().replace('.', '/');
      url = cloader.getResource(clasName + ".class");
      StringBuilder adjusted = new StringBuilder();
      int i = clasName.length(); for (;;) { i--; if (i < 0) break;
        if (clasName.charAt(i) == '/')
          adjusted.append("../"); }
      adjusted.append(rstr);
      url = new URL(url, adjusted.toString());
    }
    if (url == null)
      throw new FileNotFoundException(ustr);
    return url.openConnection();
  }
}
