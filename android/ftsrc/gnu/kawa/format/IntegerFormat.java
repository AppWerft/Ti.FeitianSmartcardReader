package gnu.kawa.format;

import java.io.IOException;
import java.math.BigInteger;
import java.text.FieldPosition;
























public class IntegerFormat
  extends ReportFormat
{
  public int base;
  public int minWidth;
  public int padChar;
  public int commaChar;
  public int commaInterval;
  public int flags;
  public static final int SHOW_GROUPS = 1;
  public static final int SHOW_PLUS = 2;
  public static final int SHOW_SPACE = 4;
  public static final int SHOW_BASE = 8;
  public static final int PAD_RIGHT = 16;
  public static final int UPPERCASE = 32;
  public static final int MIN_DIGITS = 64;
  
  public IntegerFormat()
  {
    base = 10;
    minWidth = 1;
    padChar = 32;
    commaChar = 44;
    commaInterval = 3;
    flags = 0;
  }
  
  public int format(Object[] args, int start, Appendable dst, FieldPosition fpos)
    throws IOException
  {
    return format(args, start, dst, fpos);
  }
  
  public int format(Object arg, int start, Appendable dst, FieldPosition fpos)
    throws IOException
  {
    Object[] args = (arg instanceof Object[]) ? (Object[])arg : null;
    int minWidth = getParam(this.minWidth, 1, args, start);
    if (this.minWidth == -1610612736) start++;
    char padChar = getParam(this.padChar, ' ', args, start);
    if (this.padChar == -1610612736) start++;
    char commaChar = getParam(this.commaChar, ',', args, start);
    if (this.commaChar == -1610612736) start++;
    int commaInterval = getParam(this.commaInterval, 3, args, start);
    if (this.commaInterval == -1610612736) start++;
    boolean printCommas = (flags & 0x1) != 0;
    boolean padRight = (flags & 0x10) != 0;
    boolean padInternal = padChar == '0';
    if (args != null)
    {
      if (start >= args.length)
      {
        dst.append("#<missing format argument>");
        return start;
      }
      arg = args[start];
    }
    String sarg = convertToIntegerString(arg, base);
    if (sarg != null)
    {
      char sarg0 = sarg.charAt(0);
      boolean neg = sarg0 == '-';
      int slen = sarg.length();
      int ndigits = neg ? slen - 1 : slen;
      int numCommas = printCommas ? (ndigits - 1) / commaInterval : 0;
      int unpadded_len = ndigits + numCommas;
      if ((neg) || ((flags & 0x6) != 0)) {
        unpadded_len++;
      }
      if ((flags & 0x8) != 0)
      {
        if (base == 16) {
          unpadded_len += 2;
        } else if ((base == 8) && (sarg0 != '0'))
          unpadded_len++;
      }
      if ((flags & 0x40) != 0)
      {
        unpadded_len = ndigits;
        if ((slen == 1) && (sarg0 == '0') && (minWidth == 0))
          slen = 0;
      }
      if ((!padRight) && (!padInternal))
        for (; minWidth > unpadded_len; minWidth--)
          dst.append(padChar);
      int i = 0;
      if (neg)
      {
        dst.append('-');
        i++;
        slen--;
      }
      else if ((flags & 0x2) != 0) {
        dst.append('+');
      } else if ((flags & 0x4) != 0) {
        dst.append(' '); }
      boolean uppercase = (base > 10) && ((flags & 0x20) != 0);
      if ((flags & 0x8) != 0)
      {
        if (base == 16)
        {
          dst.append('0');
          dst.append(uppercase ? 'X' : 'x');
        }
        else if ((base == 8) && (sarg0 != '0')) {
          dst.append('0');
        } }
      if (padInternal) {
        for (; minWidth > unpadded_len; minWidth--) {
          dst.append(padChar);
        }
      }
      while (slen != 0)
      {
        char ch = sarg.charAt(i++);
        if (uppercase)
          ch = Character.toUpperCase(ch);
        dst.append(ch);
        slen--;
        if ((printCommas) && (slen > 0) && (slen % commaInterval == 0))
          dst.append(commaChar);
      }
      if (padRight) {
        for (; minWidth > unpadded_len; minWidth--)
          dst.append(padChar);
      }
    } else {
      dst.append(arg.toString()); }
    return start + 1;
  }
  
  public String convertToIntegerString(Object x, int radix)
  {
    if (!(x instanceof Number))
      return null;
    if ((x instanceof BigInteger)) {
      return ((BigInteger)x).toString(radix);
    }
    return Long.toString(((Number)x).longValue(), radix);
  }
}
