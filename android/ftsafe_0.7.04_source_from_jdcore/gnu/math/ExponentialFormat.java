package gnu.math;

import java.text.FieldPosition;
import java.text.Format;
import java.text.ParsePosition;








public class ExponentialFormat
  extends Format
{
  public int fracDigits = -1;
  

  public int intDigits;
  

  public int expDigits;
  

  public char overflowChar;
  

  public char padChar;
  
  public char exponentChar = 'E';
  

  public boolean exponentShowSign;
  

  public boolean showPlus;
  

  public boolean general;
  
  public char style;
  
  public int width;
  
  static final double LOG10 = Math.log(10.0D);
  
  public ExponentialFormat() {}
  
  static boolean addOne(StringBuffer sbuf, int digStart, int digEnd)
  {
    int j = digEnd;
    for (;;) {
      if (j == digStart)
      {
        sbuf.insert(j, '1');
        return true;
      }
      char ch = sbuf.charAt(--j);
      if (ch != '9')
      {
        sbuf.setCharAt(j, (char)(ch + '\001'));
        return false;
      }
      sbuf.setCharAt(j, '0');
    }
  }
  

  public StringBuffer format(float value, StringBuffer sbuf, FieldPosition fpos)
  {
    return format(value, fracDigits < 0 ? Float.toString(value) : null, sbuf, fpos);
  }
  


  public StringBuffer format(double value, StringBuffer sbuf, FieldPosition fpos)
  {
    return format(value, fracDigits < 0 ? Double.toString(value) : null, sbuf, fpos);
  }
  


  StringBuffer format(double value, String dstr, StringBuffer sbuf, FieldPosition fpos)
  {
    int k = intDigits;
    int d = fracDigits;
    boolean negative = value < 0.0D;
    if (negative)
      value = -value;
    int oldLen = sbuf.length();
    int signLen = 1;
    if (negative)
    {
      if (d >= 0) {
        sbuf.append('-');
      }
    }
    else if (showPlus) {
      sbuf.append('+');
    } else {
      signLen = 0;
    }
    
    int digStart = sbuf.length();
    
    boolean nonFinite = (Double.isNaN(value)) || (Double.isInfinite(value));
    int scale; int digits; int scale; int exponent; if ((d < 0) || (nonFinite))
    {
      if (dstr == null)
        dstr = Double.toString(value);
      int indexE = dstr.indexOf('E');
      int exponent; if (indexE >= 0)
      {
        sbuf.append(dstr);
        indexE += digStart;
        boolean negexp = dstr.charAt(indexE + 1) == '-';
        int exponent = 0;
        for (int i = indexE + (negexp ? 2 : 1); i < sbuf.length(); i++)
          exponent = 10 * exponent + (sbuf.charAt(i) - '0');
        if (negexp)
          exponent = -exponent;
        sbuf.setLength(indexE);
      }
      else {
        exponent = RealNum.toStringScientific(dstr, sbuf); }
      if (negative)
        digStart++;
      int dot = digStart + 1;
      
      sbuf.deleteCharAt(dot);
      




      int digits = sbuf.length() - digStart;
      
      if ((digits > 1) && (sbuf.charAt(digStart + digits - 1) == '0'))
        sbuf.setLength(digStart + --digits);
      scale = digits - exponent - 1;
    }
    else
    {
      digits = d + (k > 0 ? 1 : k);
      int log = (int)(Math.log(value) / LOG10 + 1000.0D);
      if (log == Integer.MIN_VALUE) {
        log = 0;
      } else
        log -= 1000;
      scale = digits - log - 1;
      RealNum.toScaledInt(value, scale).format(10, sbuf);
      exponent = digits - 1 - scale;
    }
    
    exponent -= k - 1;
    int exponentAbs = exponent < 0 ? -exponent : exponent;
    int exponentLen = exponentAbs >= 10 ? 2 : exponentAbs >= 100 ? 3 : exponentAbs >= 1000 ? 4 : 1;
    
    if (expDigits > exponentLen)
      exponentLen = expDigits;
    boolean showExponent = true;
    int ee = expDigits > 0 ? expDigits + 2 : !general ? 0 : 4;
    boolean fracUnspecified = d < 0;
    if ((general) || (fracUnspecified))
    {
      int n = digits - scale;
      if (fracUnspecified)
      {
        d = n < 7 ? n : 7;
        if (digits > d)
          d = digits;
      }
      int dd = d - n;
      if ((general) && (n >= 0) && (dd >= 0))
      {


        digits = d;
        k = n;
        showExponent = false;
      }
      else if (fracUnspecified)
      {
        if (width <= 0) {
          digits = d;
        }
        else {
          int avail = width - signLen - exponentLen - 3;
          digits = avail;
          if (k < 0)
            digits -= k;
          if (digits > d)
            digits = d;
        }
        if (digits <= 0) {
          digits = 1;
        }
      }
    }
    int digEnd = digStart + digits;
    while (sbuf.length() < digEnd) {
      sbuf.append('0');
    }
    
    char nextDigit = digEnd == sbuf.length() ? '0' : sbuf.charAt(digEnd);
    boolean addOne = nextDigit >= '5';
    

    if ((addOne) && (addOne(sbuf, digStart, digEnd))) {
      scale++;
    }
    scale -= sbuf.length() - digEnd;
    sbuf.setLength(digEnd);
    
    int dot = digStart;
    if (k < 0)
    {

      int j = k; for (;;) { j++; if (j > 0) break;
        sbuf.insert(digStart, '0');
      }
    }
    else
    {
      for (; digStart + k > digEnd; digEnd++)
        sbuf.append('0');
      dot += k;
    }
    if (nonFinite) {
      showExponent = false;
    } else {
      sbuf.insert(dot, '.');
    }
    
    if (showExponent)
    {

      sbuf.append(exponentChar);
      if ((exponentShowSign) || (exponent < 0))
        sbuf.append(exponent >= 0 ? '+' : '-');
      int i = sbuf.length();
      sbuf.append(exponentAbs);
      int newLen = sbuf.length();
      int j = expDigits - (newLen - i);
      if (j > 0)
      {
        newLen += j;
        for (;;) { j--; if (j < 0) break;
          sbuf.insert(i, '0');
        }
      }
    }
    else {
      exponentLen = 0;
    }
    int newLen = sbuf.length();
    int used = newLen - oldLen;
    int i = width - used;
    

    if ((fracUnspecified) && ((dot + 1 == sbuf.length()) || (sbuf.charAt(dot + 1) == exponentChar)) && ((width <= 0) || (i > 0)))
    {


      i--;
      sbuf.insert(dot + 1, '0');
    }
    
    if (((i >= 0) || (width <= 0)) && ((!showExponent) || (exponentLen <= expDigits) || (expDigits <= 0) || (overflowChar == 0)))
    {



      if ((k <= 0) && ((i > 0) || (width <= 0)))
      {
        sbuf.insert(digStart, '0');
        i--;
      }
      if ((!showExponent) && (style == 'L'))
        for (;; 
            i--) { ee--; if (ee < 0) break;
          sbuf.append(' ');
        }
      for (;;) {
        i--; if (i < 0) break;
        sbuf.insert(oldLen, padChar);
      } }
    if (overflowChar != 0)
    {
      sbuf.setLength(oldLen);
      i = width; for (;;) { i--; if (i < 0) break;
        sbuf.append(overflowChar);
      } }
    return sbuf;
  }
  
  public StringBuffer format(long num, StringBuffer sbuf, FieldPosition fpos)
  {
    return format(num, sbuf, fpos);
  }
  


  public StringBuffer format(Object num, StringBuffer sbuf, FieldPosition fpos)
  {
    return format(((Number)num).doubleValue(), sbuf, fpos);
  }
  
  public Number parse(String text, ParsePosition status) {
    throw new UnsupportedOperationException("ExponentialFormat.parse - not implemented");
  }
  
  public Object parseObject(String text, ParsePosition status) {
    throw new UnsupportedOperationException("ExponentialFormat.parseObject - not implemented");
  }
}
