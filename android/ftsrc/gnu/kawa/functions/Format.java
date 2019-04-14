package gnu.kawa.functions;

import gnu.kawa.format.ReportFormat;
import gnu.kawa.io.CharArrayOutPort;
import gnu.kawa.io.OutPort;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.text.MessageFormat;

public class Format extends gnu.mapping.ProcedureN
{
  public static final Format format = new Format();
  
  static { format.setName("format");
    format.setProperty(gnu.mapping.Procedure.validateApplyKey, "gnu.kawa.functions.CompileMisc:validateApplyFormat");
  }
  

  public static void format(Writer dst, Object[] args, int arg_offset)
  {
    Object format = args[(arg_offset++)];
    Object[] vals = new Object[args.length - arg_offset];
    System.arraycopy(args, arg_offset, vals, 0, vals.length);
    formatToWriter(dst, format, vals);
  }
  
  public static void formatToWriter(Writer dst, Object format, Object... vals)
  {
    if (dst == null) {
      dst = OutPort.outDefault();
    }
    try {
      if ((format instanceof MessageFormat))
      {
        String out = ((MessageFormat)format).format(vals);
        dst.write(out);
      }
      else
      {
        if (!(format instanceof ReportFormat))
          format = ParseFormat.asFormat(format, '~');
        ((ReportFormat)format).format(vals, 0, dst, null);
      }
    }
    catch (IOException ex)
    {
      throw new RuntimeException("Error in format: " + ex);
    }
  }
  
  public static void formatToOutputStream(OutputStream dst, Object format, Object... vals)
  {
    OutPort port = new OutPort(dst);
    format(new Object[] { port, format, vals });
    port.closeThis();
  }
  
  public static String formatToString(int arg_offset, Object... args)
  {
    CharArrayOutPort port = new CharArrayOutPort();
    format(port, args, arg_offset);
    String str = port.toString();
    port.close();
    return str;
  }
  
  public static String sprintfToString(Object fmt, Object... args) {
    ReportFormat rfmt = ParseFormat.asFormat(fmt, '%');
    CharArrayOutPort port = new CharArrayOutPort();
    try {
      rfmt.format(args, 0, port, null);
    } catch (IOException ex) {
      gnu.mapping.WrappedException.rethrow(ex);
    }
    String str = port.toString();
    port.close();
    return str;
  }
  







  public static gnu.lists.FString formatToFString(char style, Object fmt, Object[] args)
  {
    ReportFormat rfmt = ParseFormat.asFormat(fmt, style);
    CharArrayOutPort port = new CharArrayOutPort();
    try
    {
      rfmt.format(args, 0, port, null);
    }
    catch (IOException ex)
    {
      gnu.mapping.WrappedException.rethrow(ex);
    }
    char[] chars = port.toCharArray();
    port.close();
    return new gnu.lists.FString(chars);
  }
  

  public Object applyN(Object[] args)
  {
    return format(args);
  }
  







  public static Object format(Object... args)
  {
    Object port_arg = args[0];
    if (port_arg == Boolean.TRUE)
    {
      format(OutPort.outDefault(), args, 1);
      return gnu.mapping.Values.empty;
    }
    if (port_arg == Boolean.FALSE)
    {
      return formatToString(1, args);
    }
    if (((port_arg instanceof MessageFormat)) || ((port_arg instanceof CharSequence)) || ((port_arg instanceof ReportFormat)))
    {






      return formatToString(0, args);
    }
    if ((port_arg instanceof Writer))
    {
      format((Writer)port_arg, args, 1);
      return gnu.mapping.Values.empty;
    }
    if ((port_arg instanceof OutputStream))
    {
      formatToOutputStream((OutputStream)port_arg, args[1], drop2(args));
      
      return gnu.mapping.Values.empty;
    }
    
    throw new RuntimeException("bad first argument to format");
  }
  
  static Object[] drop2(Object[] vals)
  {
    int xlen = vals.length - 2;
    Object[] xvals = new Object[xlen];
    System.arraycopy(vals, 2, xvals, 0, xlen);
    return xvals;
  }
  
  public Format() {}
}
