package gnu.kawa.functions;

import gnu.kawa.format.LiteralFormat;
import gnu.kawa.format.PadFormat;
import gnu.kawa.format.ReportFormat;
import gnu.kawa.io.InPort;
import java.io.IOException;
import java.text.Format;
import java.text.ParseException;
import java.util.ArrayList;

public class ParseFormat extends gnu.mapping.Procedure1
{
  public static final ParseFormat parseFormat = new ParseFormat(false);
  
  boolean emacsStyle = true;
  public static final int PARAM_UNSPECIFIED = -1073741824;
  public static final int PARAM_FROM_LIST = -1610612736;
  public static final int SEEN_MINUS = 1;
  
  public ParseFormat(boolean emacsStyle) {
    this.emacsStyle = emacsStyle;
  }
  

  public static final int SEEN_PLUS = 2;
  
  public static final int SEEN_SPACE = 4;
  public static final int SEEN_ZERO = 8;
  public static final int SEEN_HASH = 16;
  public ReportFormat parseFormat(InPort fmt)
    throws ParseException, IOException
  {
    return parseFormat(fmt, emacsStyle ? '?' : '~');
  }
  
  public static ReportFormat parseFormat(InPort fmt, char magic)
    throws ParseException, IOException
  {
    StringBuffer fbuf = new StringBuffer(100);
    int position = 0;
    ArrayList<Format> formats = new ArrayList();
    
    for (;;)
    {
      int ch = fmt.read();
      if (ch >= 0)
      {
        if (ch != magic)
        {

          fbuf.append((char)ch);
          continue;
        }
        ch = fmt.read();
        if (ch == magic)
        {
          fbuf.append((char)ch);
          continue;
        }
      }
      int len = fbuf.length();
      
      Format format;
      
      Format format;
      
      if (len == 0) {
        format = LiteralFormat.separator;
      }
      else {
        char[] text = new char[len];
        fbuf.getChars(0, len, text, 0);
        fbuf.setLength(0);
        format = new LiteralFormat(text);
      }
      formats.add(format);
      
      if (ch < 0) {
        break;
      }
      if (ch == 36)
      {
        ch = fmt.read();
        position = Character.digit((char)ch, 10);
        if (position < 0) {
          throw new ParseException("missing number (position) after '%$'", -1);
        }
        for (;;)
        {
          ch = fmt.read();
          int digit = Character.digit((char)ch, 10);
          if (digit < 0)
            break;
          position = 10 * position + digit;
        }
        position--;
      }
      
      int flags = 0;
      for (;; ch = fmt.read())
      {
        switch ((char)ch) {
        case '-': 
          flags |= 0x1; break;
        case '+':  flags |= 0x2; break;
        case ' ':  flags |= 0x4; break;
        case '0':  flags |= 0x8; break;
        case '#':  flags |= 0x10; break;
        default: 
          break label331;
        } }
      label331:
      int width;
      if (ch == 42)
      {
        int width = -1610612736;
        ch = fmt.read();
      } else { int digit;
        if ((digit = Character.digit((char)ch, 10)) >= 0)
        {
          int width = digit;
          for (;;)
          {
            ch = fmt.read();
            digit = Character.digit((char)ch, 10);
            if (digit < 0)
              break;
            width = 10 * width + digit;
          }
        }
        
        width = -1073741824;
      }
      int precision = -1073741824;
      if (ch == 46)
      {
        ch = fmt.read();
        if (ch == 42)
        {
          precision = -1610612736;
          ch = fmt.read();
        } else { int digit;
          if ((digit = Character.digit((char)ch, 10)) >= 0)
          {
            precision = digit;
            for (;;)
            {
              ch = fmt.read();
              digit = Character.digit((char)ch, 10);
              if (digit < 0)
                break;
              precision = 10 * precision + digit;
            }
          }
        }
      }
      char padChar = (flags & 0x9) == 8 ? '0' : ' ';
      
      switch (ch)
      {
      case 83: 
      case 115: 
        format = new ObjectFormat(ch == 83, precision);
        break;
      

      case 88: 
      case 100: 
      case 105: 
      case 111: 
      case 120: 
        int fflags = 0;
        int base; int base; if ((ch == 100) || (ch == 105)) {
          base = 10; } else { int base;
          if (ch == 111) {
            base = 8;
          }
          else {
            base = 16;
            if (ch == 88) fflags = 32;
          } }
        boolean seenColon = false;
        boolean seenAt = false;
        if ((flags & 0x10) != 0)
          fflags |= 0x8;
        if ((flags & 0x2) != 0)
          fflags |= 0x2;
        if ((flags & 0x1) != 0)
          fflags |= 0x10;
        if ((flags & 0x4) != 0)
          fflags |= 0x4;
        if (precision != -1073741824)
        {
          flags &= 0xFFFFFFF7;
          fflags |= 0x40;
          format = IntegerFormat.getInstance(base, precision, 48, -1073741824, -1073741824, fflags);

        }
        else
        {
          format = IntegerFormat.getInstance(base, width, padChar, -1073741824, -1073741824, fflags);
        }
        
        break;
      case 69: 
      case 71: 
      case 101: 
      case 102: 
      case 103: 
        LispRealFormat dfmt = new LispRealFormat();
        op = ((char)ch);
        style = 'P';
        arg1 = width;
        if (precision == -1073741824)
          precision = 6;
        arg2 = precision;
        showPlus = ((flags & 0x2) != 0);
        if ((ch == 101) || (ch == 69) || (ch == 103) || (ch == 71)) {
          arg3 = 2;
          arg4 = 1;
          arg5 = 0;
          arg6 = padChar;
          
          arg7 = ((ch == 69) || (ch == 71) ? 69 : 101);
        }
        else {
          arg3 = 0;
          arg5 = padChar;
        }
        internalPad = true;
        format = dfmt.resolve(null, 0);
        break;
      default: 
        throw new ParseException("unknown format character '" + ch + "'", -1);
      }
      if (width > 0)
      {
        padChar = (flags & 0x8) != 0 ? '0' : ' ';
        int where;
        int where; if ((flags & 0x1) != 0) {
          where = 100; } else { int where;
          if (padChar == '0') {
            where = -1;
          } else
            where = 0; }
        format = new PadFormat(format, width, padChar, where);
      }
      



      formats.add(format);
      position++;
    }
    int fcount = formats.size();
    if (fcount == 1)
    {
      Object f = formats.get(0);
      if ((f instanceof ReportFormat))
        return (ReportFormat)f;
    }
    return new gnu.kawa.format.CompoundFormat((Format[])formats.toArray(new Format[fcount]));
  }
  
  public Object apply1(Object arg)
  {
    return asFormat(arg, emacsStyle ? '?' : '~');
  }
  
  /* Error */
  public static ReportFormat asFormat(Object arg, char style)
  {
    // Byte code:
    //   0: aload_0
    //   1: instanceof 51
    //   4: ifeq +8 -> 12
    //   7: aload_0
    //   8: checkcast 51	gnu/kawa/format/ReportFormat
    //   11: areturn
    //   12: iload_1
    //   13: bipush 126
    //   15: if_icmpne +15 -> 30
    //   18: new 58	gnu/kawa/functions/LispFormat
    //   21: dup
    //   22: aload_0
    //   23: invokevirtual 59	java/lang/Object:toString	()Ljava/lang/String;
    //   26: invokespecial 60	gnu/kawa/functions/LispFormat:<init>	(Ljava/lang/String;)V
    //   29: areturn
    //   30: aload_0
    //   31: instanceof 61
    //   34: ifeq +14 -> 48
    //   37: aload_0
    //   38: checkcast 61	gnu/lists/FString
    //   41: invokevirtual 62	gnu/lists/FString:openReader	()Lgnu/kawa/io/CharArrayInPort;
    //   44: astore_2
    //   45: goto +15 -> 60
    //   48: new 63	gnu/kawa/io/CharArrayInPort
    //   51: dup
    //   52: aload_0
    //   53: invokevirtual 59	java/lang/Object:toString	()Ljava/lang/String;
    //   56: invokespecial 64	gnu/kawa/io/CharArrayInPort:<init>	(Ljava/lang/String;)V
    //   59: astore_2
    //   60: aload_2
    //   61: iload_1
    //   62: invokestatic 3	gnu/kawa/functions/ParseFormat:parseFormat	(Lgnu/kawa/io/InPort;C)Lgnu/kawa/format/ReportFormat;
    //   65: astore_3
    //   66: aload_2
    //   67: invokevirtual 65	gnu/kawa/io/InPort:close	()V
    //   70: aload_3
    //   71: areturn
    //   72: astore 4
    //   74: aload_2
    //   75: invokevirtual 65	gnu/kawa/io/InPort:close	()V
    //   78: aload 4
    //   80: athrow
    //   81: astore_2
    //   82: new 67	java/lang/RuntimeException
    //   85: dup
    //   86: new 40	java/lang/StringBuilder
    //   89: dup
    //   90: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   93: ldc 68
    //   95: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: aload_2
    //   99: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   102: ldc 70
    //   104: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: invokevirtual 46	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   110: invokespecial 71	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   113: athrow
    //   114: astore_2
    //   115: new 67	java/lang/RuntimeException
    //   118: dup
    //   119: new 40	java/lang/StringBuilder
    //   122: dup
    //   123: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   126: ldc 72
    //   128: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: aload_2
    //   132: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   135: ldc 70
    //   137: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: invokevirtual 46	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   143: invokespecial 71	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   146: athrow
    //   147: astore_2
    //   148: new 67	java/lang/RuntimeException
    //   151: dup
    //   152: ldc 74
    //   154: invokespecial 71	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   157: athrow
    // Line number table:
    //   Java source line #275	-> byte code offset #0
    //   Java source line #276	-> byte code offset #7
    //   Java source line #277	-> byte code offset #12
    //   Java source line #278	-> byte code offset #18
    //   Java source line #282	-> byte code offset #30
    //   Java source line #283	-> byte code offset #37
    //   Java source line #285	-> byte code offset #48
    //   Java source line #288	-> byte code offset #60
    //   Java source line #292	-> byte code offset #66
    //   Java source line #296	-> byte code offset #81
    //   Java source line #298	-> byte code offset #82
    //   Java source line #300	-> byte code offset #114
    //   Java source line #302	-> byte code offset #115
    //   Java source line #304	-> byte code offset #147
    //   Java source line #306	-> byte code offset #148
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	158	0	arg	Object
    //   0	158	1	style	char
    //   44	2	2	iport	InPort
    //   59	16	2	iport	InPort
    //   81	18	2	ex	IOException
    //   114	18	2	ex	ParseException
    //   147	2	2	ex	IndexOutOfBoundsException
    //   72	7	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   60	66	72	finally
    //   72	74	72	finally
    //   0	11	81	java/io/IOException
    //   12	29	81	java/io/IOException
    //   30	70	81	java/io/IOException
    //   72	81	81	java/io/IOException
    //   0	11	114	java/text/ParseException
    //   12	29	114	java/text/ParseException
    //   30	70	114	java/text/ParseException
    //   72	81	114	java/text/ParseException
    //   0	11	147	java/lang/IndexOutOfBoundsException
    //   12	29	147	java/lang/IndexOutOfBoundsException
    //   30	70	147	java/lang/IndexOutOfBoundsException
    //   72	81	147	java/lang/IndexOutOfBoundsException
  }
}
