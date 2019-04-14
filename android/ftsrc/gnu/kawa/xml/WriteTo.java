package gnu.kawa.xml;

import gnu.kawa.io.OutPort;
import gnu.kawa.io.Path;
import gnu.mapping.Procedure2;
import gnu.mapping.Values;
import gnu.xml.XMLPrinter;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class WriteTo extends Procedure2
{
  boolean ifChanged;
  public static final WriteTo writeTo = new WriteTo();
  public static final WriteTo writeToIfChanged = new WriteTo();
  static { writeToIfChangedifChanged = true; }
  
  public static void writeTo(Object value, Path ppath, OutputStream outs)
    throws Throwable
  {
    OutPort out = new OutPort(outs, ppath);
    XMLPrinter consumer = new XMLPrinter(out, false);
    String extension = ppath.getExtension();
    if ("html".equals(extension))
      consumer.setStyle("html");
    Values.writeValues(value, consumer);
    out.close();
  }
  
  public static void writeTo(Object value, Object path) throws Throwable
  {
    Path ppath = Path.valueOf(path);
    OutputStream outs = ppath.openOutputStream();
    writeTo(value, ppath, outs);
  }
  
  public static void writeToIfChanged(Object value, Object path)
    throws Throwable
  {
    Path ppath = Path.valueOf(path);
    ByteArrayOutputStream bout = new ByteArrayOutputStream();
    writeTo(value, ppath, bout);
    byte[] bbuf = bout.toByteArray();
    try
    {
      InputStream ins = new BufferedInputStream(ppath.openInputStream());
      int i = 0;
      for (;;) {
        int b = ins.read();
        boolean atend = i == bbuf.length;
        if (b < 0)
        {
          if (atend)
          {
            ins.close();
          }
        } else
          if ((atend) || (bbuf[(i++)] != b))
            break;
      }
      ins.close();
    }
    catch (Exception ex) {}
    


    OutputStream fout = new BufferedOutputStream(ppath.openOutputStream());
    
    fout.write(bbuf);
    fout.close();
  }
  
  public Object apply2(Object value, Object fileName) throws Throwable
  {
    if (ifChanged) {
      writeToIfChanged(value, fileName.toString());
    } else
      writeTo(value, fileName.toString());
    return Values.empty;
  }
  
  public WriteTo() {}
}
