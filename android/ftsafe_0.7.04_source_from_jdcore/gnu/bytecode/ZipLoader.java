package gnu.bytecode;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Vector;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;










public class ZipLoader
  extends ClassLoader
{
  ZipFile zar;
  int size;
  private String zipname;
  private Vector<Object> loadedClasses;
  
  public ZipLoader(String name)
    throws IOException
  {
    zipname = name;
    zar = new ZipFile(name);
    size = 0;
    Enumeration e = zar.entries();
    while (e.hasMoreElements())
    {
      ZipEntry ent = (ZipEntry)e.nextElement();
      if (!ent.isDirectory()) {
        size += 1;
      }
    }
    loadedClasses = new Vector(size);
  }
  




  public Class loadClass(String name, boolean resolve)
    throws ClassNotFoundException
  {
    int index = loadedClasses.indexOf(name);
    Class clas; Class clas; if (index >= 0) {
      clas = (Class)loadedClasses.elementAt(index + 1); } else { Class clas;
      if ((zar == null) && (loadedClasses.size() == 2 * size)) {
        clas = Class.forName(name);
      }
      else {
        boolean reopened = false;
        String member_name = name.replace('.', '/') + ".class";
        if (zar == null) {
          try
          {
            zar = new ZipFile(zipname);
            reopened = true;
          }
          catch (IOException ex)
          {
            throw new ClassNotFoundException("IOException while loading " + member_name + " from ziparchive \"" + name + "\": " + ex.toString());
          }
        }
        


        ZipEntry member = zar.getEntry(member_name);
        Class clas; if (member == null) {
          if (reopened) {
            try {
              close();
            } catch (IOException e) {
              throw new RuntimeException("failed to close \"" + zipname + "\"");
            }
          }
          clas = Class.forName(name);
        }
        else
        {
          try
          {
            int member_size = (int)member.getSize();
            InputStream strm = zar.getInputStream(member);
            byte[] bytes = new byte[member_size];
            new DataInputStream(strm).readFully(bytes);
            clas = defineClass(name, bytes, 0, member_size);
            loadedClasses.addElement(name);
            loadedClasses.addElement(clas);
            if (2 * size == loadedClasses.size()) {
              close();
            }
          }
          catch (IOException ex) {
            throw new ClassNotFoundException("IOException while loading " + member_name + " from ziparchive \"" + name + "\": " + ex.toString());
          }
        }
      }
    }
    


    if (resolve)
      resolveClass(clas);
    return clas;
  }
  



  public Class loadAllClasses()
    throws IOException
  {
    Enumeration e = zar.entries();
    Class mainClass = null;
    while (e.hasMoreElements())
    {
      ZipEntry member = (ZipEntry)e.nextElement();
      
      String name = member.getName().replace('/', '.');
      name = name.substring(0, name.length() - "/class".length());
      int member_size = (int)member.getSize();
      InputStream strm = zar.getInputStream(member);
      byte[] bytes = new byte[member_size];
      new DataInputStream(strm).readFully(bytes);
      if (!loadedClasses.contains(name)) {
        Class clas = defineClass(name, bytes, 0, member_size);
        if (mainClass == null)
          mainClass = clas;
        loadedClasses.addElement(name);
        loadedClasses.addElement(clas);
      }
    }
    close();
    return mainClass;
  }
  

  public void close()
    throws IOException
  {
    if (zar != null)
      zar.close();
    zar = null;
  }
}
