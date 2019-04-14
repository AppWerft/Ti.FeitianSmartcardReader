package gnu.lists;

import java.io.IOException;
import java.io.UnsupportedEncodingException;



public class Strings
{
  public Strings() {}
  
  public static int characterAt(CharSequence cseq, int index)
  {
    return characterAt(cseq, 0, cseq.length(), index);
  }
  
  public static int characterAt(CharSequence cseq, int start, int end, int index) {
    if ((index < start) || (index >= end))
      throw new IndexOutOfBoundsException();
    char ch1 = cseq.charAt(index);
    if ((ch1 >= 55296) && (ch1 <= 56319)) {
      if (index + 1 < end) {
        char ch2 = cseq.charAt(index + 1);
        if ((ch2 >= 56320) && (ch2 <= 57343))
          return (ch1 - 55296 << 10) + (ch2 - 56320) + 65536;
      }
    } else if ((ch1 >= 56320) && (ch1 <= 57343) && 
      (index > start)) {
      char ch0 = cseq.charAt(index - 1);
      if ((ch0 >= 55296) && (ch0 <= 56319)) {
        return 2097151;
      }
    }
    return ch1;
  }
  
  public static int sizeInCodePoints(CharSequence str) {
    int len = str.length();
    int nsurr = 0;
    for (int i = 0; i < len;) {
      char ch = str.charAt(i++);
      if ((ch >= 55296) && (ch <= 56319) && (i < len)) {
        int next = str.charAt(i);
        if ((next >= 56320) && (next <= 57343)) {
          i++;
          nsurr++;
        }
      }
    }
    return len - nsurr;
  }
  

  public static void makeUpperCase(CharSeq str)
  {
    int i = str.length(); for (;;) { i--; if (i < 0) break;
      str.setCharAt(i, Character.toUpperCase(str.charAt(i)));
    }
  }
  
  public static void makeLowerCase(CharSeq str)
  {
    int i = str.length(); for (;;) { i--; if (i < 0) break;
      str.setCharAt(i, Character.toLowerCase(str.charAt(i)));
    }
  }
  


  public static void makeCapitalize(CharSeq str)
  {
    char prev = ' ';
    int len = str.length();
    for (int i = 0; i < len; i++)
    {
      char ch = str.charAt(i);
      if (!Character.isLetterOrDigit(prev)) {
        ch = Character.toTitleCase(ch);
      } else
        ch = Character.toLowerCase(ch);
      str.setCharAt(i, ch);
      prev = ch;
    }
  }
  
  public static String toJson(CharSequence str) {
    StringBuilder sbuf = new StringBuilder();
    printQuoted(str, sbuf, 3);
    return sbuf.toString();
  }
  
  public static void printJson(CharSequence str, Appendable ps) {
    printQuoted(str, ps, 3);
  }
  






  public static void printQuoted(CharSequence str, Appendable ps, int escapes)
  {
    int len = str.length();
    try {
      ps.append('"');
      for (int i = 0; i < len; i++) {
        char ch = str.charAt(i);
        if ((ch == '\\') || (ch == '"')) {
          ps.append('\\');
        } else if (escapes > 0)
        {
          if (ch == '\n') {
            ps.append("\\n"); continue; }
          if (ch == '\r') {
            ps.append("\\r"); continue; }
          if (ch == '\t') {
            ps.append("\\t"); continue; }
          if ((ch == '\007') && (escapes < 3)) {
            ps.append("\\a"); continue; }
          if (ch == '\b') {
            ps.append("\\b"); continue; }
          if ((ch == '\013') && (escapes < 3)) {
            ps.append("\\v"); continue; }
          if (ch == '\f') {
            ps.append("\\f"); continue; }
          if ((escapes >= 3) && ((ch < ' ') || (ch >= '')))
          {
            ps.append("\\u");
            int d = ch;
            for (int k = 12; k >= 0; k -= 4) {
              ps.append(Character.forDigit(d >> k & 0xF, 16));
            }
            continue;
          }
          if ((ch < ' ') || ((escapes > 1) && (ch >= '')))
          {
            ps.append("\\x");
            ps.append(Integer.toHexString(ch));
            ps.append(';');
            continue;
          }
        }
        ps.append(ch);
      }
      ps.append('"');
    } catch (IOException ex) {
      throw new RuntimeException(ex);
    }
  }
  
  public static void copyInto(CharSequence src, int start, int end, CharSeq dst, int at)
  {
    int dstLen = dst.length();
    int srcLen = src.length();
    if ((at < 0) || (at > dstLen) || (start < 0) || (end > srcLen) || (end < start) || (dstLen - at < end - start))
    {
      throw new StringIndexOutOfBoundsException(); }
    if (at < start) {
      int i = at;
      for (int j = start; 
          j < end; j++) {
        dst.setCharAt(i, src.charAt(j));i++;
      }
    }
    else {
      int i = at + end - start;
      int j = end;
      for (;;) { j--; if (j < start) break;
        dst.setCharAt(--i, src.charAt(j));
      }
    }
  }
  

  public static CharSequence indirectIndexed(CharSequence base, IntSequence indexes)
  {
    if ((indexes instanceof Range.IntRange)) {
      Range.IntRange range = (Range.IntRange)indexes;
      if (range.getStepInt() == 1) {
        int start = range.getStartInt();
        int end = base.length();
        if ((start < 0) || (start > end))
          throw new IndexOutOfBoundsException();
        if (!range.isUnbounded()) {
          int size = range.size();
          if ((start + size < 0) || (start + size > end))
            throw new IndexOutOfBoundsException();
          end = start + size;
        }
        return substring(base, start, end);
      }
    }
    int len = indexes.size();
    StringBuilder sbuf = new StringBuilder(len);
    for (int i = 0; i < len; i++)
      sbuf.append(base.charAt(indexes.getInt(i)));
    return sbuf.toString();
  }
  
  public static CharSequence substring(CharSequence base, int start, int end)
  {
    if ((base instanceof FString)) {
      FString fstr = (FString)base;
      if ((fstr.isVerySimple()) || (fstr.isSubRange()))
        return (CharSequence)Sequences.copy(fstr, start, end, false);
    }
    if ((base instanceof String)) {
      return ((String)base).substring(start, end);
    }
    int len = end - start;
    StringBuilder sbuf = new StringBuilder(len);
    if ((base instanceof CharSeq)) {
      try {
        ((CharSeq)base).writeTo(start, len, sbuf);
      } catch (Throwable ex) {
        throw new RuntimeException(ex);
      }
    } else {
      for (int i = start; i < end; i++)
        sbuf.append(base.charAt(i));
    }
    return sbuf.toString();
  }
  


  public static String toUtf8(byte[] bytes, int start, int length)
  {
    try
    {
      return new String(bytes, start, length, "UTF-8");
    } catch (UnsupportedEncodingException ex) {
      throw new RuntimeException(ex);
    }
  }
}
