package gnu.kawa.format;

import java.text.FieldPosition;

public class RomanIntegerFormat extends java.text.NumberFormat
{
  private static RomanIntegerFormat newRoman;
  private static RomanIntegerFormat oldRoman;
  public boolean oldStyle;
  static final String codes = "IVXLCDM";
  
  public RomanIntegerFormat(boolean oldStyle) {
    this.oldStyle = oldStyle;
  }
  

  public RomanIntegerFormat() {}
  

  public static RomanIntegerFormat getInstance(boolean oldStyle)
  {
    if (oldStyle)
    {
      if (oldRoman == null)
        oldRoman = new RomanIntegerFormat(true);
      return oldRoman;
    }
    

    if (newRoman == null)
      newRoman = new RomanIntegerFormat(false);
    return newRoman;
  }
  



  public static String format(int num, boolean oldStyle)
  {
    if ((num <= 0) || (num >= 4999))
      return Integer.toString(num);
    StringBuffer sbuf = new StringBuffer(20);
    int power = 3;
    int unit = 1000;
    for (; power >= 0; power--)
    {
      int digit = num / unit;
      num -= digit * unit;
      if (digit != 0)
      {
        if ((!oldStyle) && ((digit == 4) || (digit == 9)))
        {
          sbuf.append("IVXLCDM".charAt(2 * power));
          sbuf.append("IVXLCDM".charAt(2 * power + (digit + 1) / 5));
        }
        else {
          int rest = digit;
          if (rest >= 5)
          {
            sbuf.append("IVXLCDM".charAt(2 * power + 1));
            rest -= 5;
          }
          for (;;) { rest--; if (rest < 0)
              break;
            sbuf.append("IVXLCDM".charAt(2 * power));
          }
        }
      }
      unit /= 10;
    }
    




















    return sbuf.toString();
  }
  
  public static String format(int num)
  {
    return format(num, false);
  }
  

  public StringBuffer format(long num, StringBuffer sbuf, FieldPosition fpos)
  {
    if (num > 0L) if (num < (oldStyle ? 'ᎇ' : 'ྟ')) {
        String str = format((int)num, oldStyle);
        break label48; }
    String str = Long.toString(num);
    label48: if (fpos != null)
    {

      long tval = 1L;
      int len = str.length();
      int i = len; for (;;) { i--; if (i <= 0) break;
        tval = 10L * tval + 9L;
      }
      StringBuffer tbuf = new StringBuffer(len);
      new java.text.DecimalFormat("0").format(tval, tbuf, fpos);
    }
    sbuf.append(str);
    return sbuf;
  }
  
  public StringBuffer format(double num, StringBuffer sbuf, FieldPosition fpos)
  {
    long inum = num;
    if (inum == num)
      return format(inum, sbuf, fpos);
    sbuf.append(Double.toString(num));
    return sbuf;
  }
  
  public Number parse(String text, java.text.ParsePosition status)
  {
    throw new Error("RomanIntegerFormat.parseObject - not implemented");
  }
}
