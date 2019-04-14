package gnu.kawa.format;

import gnu.lists.Consumer;
import java.text.FieldPosition;
import java.text.ParsePosition;

public class EnglishIntegerFormat extends java.text.NumberFormat
{
  private static EnglishIntegerFormat cardinalEnglish;
  private static EnglishIntegerFormat ordinalEnglish;
  public boolean ordinal;
  
  public EnglishIntegerFormat(boolean ordinal)
  {
    this.ordinal = ordinal;
  }
  
  public static EnglishIntegerFormat getInstance(boolean ordinal)
  {
    if (ordinal)
    {
      if (ordinalEnglish == null)
        ordinalEnglish = new EnglishIntegerFormat(true);
      return ordinalEnglish;
    }
    

    if (cardinalEnglish == null)
      cardinalEnglish = new EnglishIntegerFormat(false);
    return cardinalEnglish;
  }
  

  public static final String[] ones = { null, "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen" };
  






  public static final String[] onesth = { null, "first", "second", "third", "fourth", "fifth", "sixth", "seventh", "eighth", "ninth", "tenth", "eleventh", "twelveth", "thirteenth", "fourteenth", "fifteenth", "sixteenth", "seventeenth", "eighteenth", "nineteenth" };
  






  public static final String[] tens = { null, null, "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety" };
  




  public static final String[] tensth = { null, null, "twentieth", "thirtieth", "fortieth", "fiftieth", "sixtieth", "seventieth", "eightieth", "ninetieth" };
  




  public static final String[] power1000s = { null, " thousand", " million", " billion", " trillion", " quadrillion", " quintillion", " sextillion", " septillion", " octillion", " nonillion", " decillion", " undecillion", " duodecillion", " tredecillion", " quattuordecillion", " quindecillion", " sexdecillion", " septendecillion", " octodecillion", " novemdecillion", " vigintillion" };
  











  void format999(StringBuffer sbuf, int num, boolean ordinal)
  {
    if (num >= 100)
    {
      int num100s = num / 100;
      num %= 100;
      if (num100s > 1)
      {
        sbuf.append(ones[num100s]);
        sbuf.append(' ');
      }
      sbuf.append("hundred");
      if (num > 0) {
        sbuf.append(' ');
      } else if (ordinal)
        sbuf.append("th");
    }
    if (num >= 20)
    {
      int num10s = num / 10;
      num %= 10;
      sbuf.append(tens[num10s]);
      if (num > 0)
        sbuf.append('-');
    }
    if (num > 0)
    {
      sbuf.append(ones[num]);
    }
  }
  
  void format(StringBuffer sbuf, long num, int exp1000, boolean ordinal)
  {
    if (num >= 1000L)
    {
      format(sbuf, num / 1000L, exp1000 + 1, false);
      num %= 1000L;
      if (num > 0L) {
        sbuf.append(", ");
      } else if (ordinal)
        sbuf.append("th");
    }
    if (num > 0L)
    {
      format999(sbuf, (int)num, (ordinal) && (exp1000 == 0));
      if (exp1000 >= power1000s.length)
      {
        sbuf.append(" times ten to the ");
        format(sbuf, exp1000 * 3, 0, true);
        sbuf.append(" power");
      }
      else if (exp1000 > 0) {
        sbuf.append(power1000s[exp1000]);
      }
    }
  }
  
  public void writeInt(int value, Consumer out) {
    writeLong(value, out);
  }
  
  public void writeLong(long value, Consumer out)
  {
    StringBuffer sbuf = new StringBuffer();
    format(value, sbuf, null);
    
    out.write(sbuf, 0, sbuf.length());
  }
  



  public void writeObject(Object value, Consumer out)
  {
    writeLong(((Number)value).longValue(), out);
  }
  
  public void writeBoolean(boolean value, Consumer out)
  {
    writeLong(value ? 1L : 0L, out);
  }
  
  public StringBuffer format(long num, StringBuffer sbuf, FieldPosition fpos)
  {
    if (num == 0L) {
      sbuf.append(ordinal ? "zeroth" : "zero");
    }
    else {
      if (num < 0L)
      {
        sbuf.append("minus ");
        num = -num;
      }
      format(sbuf, num, 0, ordinal);
    }
    if (fpos != null) {}
    


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
  
  public Number parse(String text, ParsePosition status)
  {
    throw new Error("EnglishIntegerFormat.parseObject - not implemented");
  }
}
