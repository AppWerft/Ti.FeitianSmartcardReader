package gnu.bytecode;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Hashtable;


public class ArrayClassLoader
  extends ClassLoader
{
  Hashtable map = new Hashtable(100);
  
  Hashtable cmap = new Hashtable(100);
  

  URL context;
  

  public ArrayClassLoader() {}
  

  public ArrayClassLoader(ClassLoader parent)
  {
    super(parent);
  }
  
  public URL getResourceContext() {
    return context;
  }
  
  public void setResourceContext(URL context) { this.context = context; }
  




  public ArrayClassLoader(byte[][] classBytes)
  {
    int i = classBytes.length; for (;;) { i--; if (i < 0) break;
      addClass("lambda" + i, classBytes[i]);
    }
  }
  
  public ArrayClassLoader(String[] classNames, byte[][] classBytes) {
    int i = classBytes.length; for (;;) { i--; if (i < 0) break;
      addClass(classNames[i], classBytes[i]);
    }
  }
  
  public void addClass(Class clas) {
    cmap.put(clas.getName(), clas);
  }
  
  public void addClass(String name, byte[] bytes)
  {
    map.put(name, bytes);
  }
  
  public void addClass(ClassType ctype)
  {
    map.put(ctype.getName(), ctype);
  }
  
  public InputStream getResourceAsStream(String name)
  {
    InputStream in = super.getResourceAsStream(name);
    if ((in == null) && (name.endsWith(".class")))
    {
      String cname = name.substring(0, name.length() - 6).replace('/', '.');
      Object r = map.get(cname);
      if ((r instanceof byte[]))
        return new ByteArrayInputStream((byte[])r);
    }
    return in;
  }
  
  protected URL findResource(String name)
  {
    if (context != null)
    {
      try
      {
        URL url = new URL(context, name);
        url.openConnection().connect();
        return url;
      }
      catch (Exception ex) {}
    }
    


    return super.findResource(name);
  }
  
  public Class loadClass(String name, boolean resolve)
    throws ClassNotFoundException
  {
    Class clas = loadClass(name);
    if (resolve)
      resolveClass(clas);
    return clas;
  }
  




  public Class loadClass(String name)
    throws ClassNotFoundException
  {
    Object r = cmap.get(name);
    if (r != null)
      return (Class)r;
    synchronized (this) {
      r = map.get(name);
      if ((r instanceof ClassType)) {
        ClassType ctype = (ClassType)r;
        if (ctype.isExisting()) {
          r = reflectClass;
        } else
          r = ctype.writeToArray();
      }
      if ((r instanceof byte[])) {
        byte[] bytes = (byte[])r;
        Class clas = defineClass(name, bytes, 0, bytes.length);
        cmap.put(name, clas);
        return clas;
      }
      if (r == null) {
        return getParent().loadClass(name);
      }
      return (Class)r;
    }
  }
  


  public static Package getContextPackage(String cname)
  {
    try
    {
      ClassLoader loader = Thread.currentThread().getContextClassLoader();
      if ((loader instanceof ArrayClassLoader)) {
        return ((ArrayClassLoader)loader).getPackage(cname);
      }
    }
    catch (SecurityException ex) {}
    
    return Package.getPackage(cname);
  }
}
