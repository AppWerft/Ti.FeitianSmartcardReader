package gnu.bytecode;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

public class ZipArchive
{
  public ZipArchive() {}
  
  private static void usage()
  {
    System.err.println("zipfile [ptxq] archive [file ...]");
    System.exit(-1);
  }
  
  public static long copy(java.io.InputStream in, OutputStream out, byte[] buffer)
    throws IOException
  {
    long total = 0L;
    for (;;)
    {
      int count = in.read(buffer);
      if (count <= 0)
        return total;
      out.write(buffer, 0, count);
      total += count;
    }
  }
  
  public static void copy(java.io.InputStream in, String name, byte[] buffer)
    throws IOException
  {
    File f = new File(name);
    String dir_name = f.getParent();
    if (dir_name != null)
    {
      File dir = new File(dir_name);
      if (!dir.exists())
        System.err.println("mkdirs:" + dir.mkdirs());
    }
    if (name.charAt(name.length() - 1) != '/')
    {
      OutputStream out = new java.io.BufferedOutputStream(new java.io.FileOutputStream(f));
      copy(in, out, buffer);
      out.close();
    }
  }
  



















  public static void main(String[] args)
    throws IOException
  {
    if (args.length < 2)
      usage();
    String command = args[0];
    String archive_name = args[1];
    
    try
    {
      if ((command.equals("t")) || (command.equals("p")) || (command.equals("x")))
      {


        PrintStream out = System.out;
        byte[] buf = new byte['Ѐ'];
        if (args.length == 2)
        {
          java.io.BufferedInputStream in = new java.io.BufferedInputStream(new FileInputStream(archive_name));
          
          java.util.zip.ZipInputStream zin = new java.util.zip.ZipInputStream(in);
          ZipEntry zent;
          while ((zent = zin.getNextEntry()) != null)
          {
            String name = zent.getName();
            if (command.equals("t"))
            {
              out.print(name);
              out.print(" size: ");
              out.println(zent.getSize());
            }
            else if (command.equals("p"))
            {
              copy(zin, out, buf);
            }
            else
            {
              copy(zin, name, buf);
            }
          }
        }
        else
        {
          ZipFile zar = new ZipFile(archive_name);
          for (int i = 2; i < args.length; i++)
          {
            String name = args[i];
            ZipEntry zent = zar.getEntry(name);
            if (zent == null)
            {
              System.err.println("zipfile " + archive_name + ":" + args[i] + " - not found");
              
              System.exit(-1);
            }
            else if (command.equals("t"))
            {
              out.print(name);
              out.print(" size: ");
              out.println(zent.getSize());
            }
            else if (command.equals("p"))
            {
              copy(zar.getInputStream(zent), out, buf);
            }
            else
            {
              copy(zar.getInputStream(zent), name, buf);
            }
          }
        }
      }
      else if (command.equals("q"))
      {
        ZipOutputStream zar = new ZipOutputStream(new java.io.FileOutputStream(archive_name));
        
        for (int i = 2; i < args.length; i++)
        {
          File in = new File(args[i]);
          if (!in.exists())
            throw new IOException(args[i] + " - not found");
          if (!in.canRead())
            throw new IOException(args[i] + " - not readable");
          int size = (int)in.length();
          FileInputStream fin = new FileInputStream(in);
          byte[] contents = new byte[size];
          if (fin.read(contents) != size)
            throw new IOException(args[i] + " - read error");
          fin.close();
          
          ZipEntry ze = new ZipEntry(args[i]);
          ze.setSize(size);
          ze.setTime(in.lastModified());
          zar.putNextEntry(ze);
          zar.write(contents, 0, size);
        }
        zar.close();
      }
      else {
        usage();
      }
    }
    catch (IOException ex) {
      System.err.println("I/O Exception:  " + ex);
    }
  }
}
