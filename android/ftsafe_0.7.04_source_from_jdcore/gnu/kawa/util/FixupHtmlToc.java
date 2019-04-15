package gnu.kawa.util;

import java.io.File;
import java.io.PrintStream;






















public class FixupHtmlToc
{
  static FileInfo[] argFiles;
  
  public FixupHtmlToc() {}
  
  public static void main(String[] args)
  {
    try
    {
      argFiles = new FileInfo[args.length];
      for (int i = 0; i < args.length; i++)
      {
        FileInfo info = FileInfo.find(new File(args[i]));
        writeNeeded = true;
        argFiles[i] = info;
      }
      
      for (int i = 0; i < args.length; i++)
      {
        argFiles[i].scan();
        argFiles[i].write();
      }
    }
    catch (Throwable ex)
    {
      System.err.println("caught " + ex);
      ex.printStackTrace();
    }
  }
}
