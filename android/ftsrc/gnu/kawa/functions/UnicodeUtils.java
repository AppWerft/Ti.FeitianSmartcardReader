package gnu.kawa.functions;

import gnu.mapping.Namespace;

public class UnicodeUtils { static final gnu.mapping.Symbol Mc;
  static final gnu.mapping.Symbol Pc;
  static final gnu.mapping.Symbol Cc;
  
  public UnicodeUtils() {}
  
  public static boolean isWhitespace(int ch) { if ((ch == 32) || ((ch >= 9) && (ch <= 13)))
      return true;
    if (ch < 133)
      return false;
    if ((ch == 133) || (ch == 160) || (ch == 5760) || (ch == 6158))
      return true;
    if ((ch < 8192) || (ch > 12288))
      return false;
    return (ch <= 8202) || (ch == 8232) || (ch == 8233) || (ch == 8239) || (ch == 8287) || (ch == 12288);
  }
  


  public static String capitalize(String str)
  {
    StringBuilder sbuf = new StringBuilder();
    


    java.text.BreakIterator wb = java.text.BreakIterator.getWordInstance();
    wb.setText(str);
    int start = wb.first();
    for (int end = wb.next(); 
        end != -1; 
        end = wb.next())
    {
      boolean isWord = false;
      for (int p = start; p < end; p++)
      {
        if (Character.isLetter(str.codePointAt(p)))
        {
          isWord = true;
          break;
        }
      }
      if (!isWord) {
        sbuf.append(str, start, end);
      }
      else {
        char first = str.charAt(start);
        


        char title = Character.toTitleCase(first);
        sbuf.append(title);
        sbuf.append(str.substring(start + 1, end).toLowerCase());
      }
      start = end;
    }
    





















    return sbuf.toString();
  }
  
  public static CharSequence foldCase(CharSequence str) {
    int len = str.length();
    if (len == 0)
      return "";
    StringBuilder sbuf = null;
    int start = 0;
    int i = 0;
    for (;;) { int ch = i == len ? '￿' : str.charAt(i);
      int w = 1;
      if ((ch >= 55296) && (ch <= 56319) && (i + 1 < len)) {
        char next = str.charAt(i + 1);
        w++;
        if ((next >= 56320) && (next <= 57343))
          ch = (ch - 55296 << 10) + (ch - 56320) + 65536; }
      int chl;
      int chl;
      if (ch == -1) {
        chl = ch; } else { int chl;
        if ((ch == 223) || (ch == 304)) {
          chl = -2; } else { int chl;
          if (ch == 962) {
            chl = 963;
          } else
            chl = Character.toLowerCase(Character.toUpperCase(ch)); } }
      if ((ch != chl) || (sbuf != null)) {
        if (sbuf == null) {
          sbuf = new StringBuilder();
          sbuf.append(str, 0, i);
        }
        if (chl == -1)
          return sbuf;
        if (chl == -2) {
          if (ch == 223) {
            sbuf.append('s');
            sbuf.append('s');
          } else {
            sbuf.append('i');
            sbuf.append('̇');
          }
        } else if (chl >= 65536) {
          sbuf.append((char)((i - 65536 >> 10) + 55296));
          sbuf.append((char)((i & 0x3FF) + 56320));
        } else {
          sbuf.append((char)chl);
        }
      }
      else if (ch < 0) {
        return str; }
      i += w;
    }
  }
  
  public static gnu.mapping.Symbol generalCategory(int ch)
  {
    switch (Character.getType(ch))
    {
    case 8: 
      return Mc;
    case 23: 
      return Pc;
    case 15: 
      return Cc;
    case 26: 
      return Sc;
    case 20: 
      return Pd;
    case 9: 
      return Nd;
    case 7: 
      return Me;
    case 22: 
      return Pe;
    case 30: 
      return Pf;
    case 16: 
      return Cf;
    case 29: 
      return Pi;
    case 10: 
      return Nl;
    case 13: 
      return Zl;
    case 2: 
      return Ll;
    case 25: 
      return Sm;
    case 4: 
      return Lm;
    case 27: 
      return Sk;
    case 6: 
      return Mn;
    case 5: 
      return Lo;
    case 11: 
      return No;
    case 24: 
      return Po;
    case 28: 
      return So;
    case 14: 
      return Zp;
    case 18: 
      return Co;
    case 12: 
      return Zs;
    case 21: 
      return Ps;
    case 19: 
      return Cs;
    case 3: 
      return Lt;
    case 1: 
      return Lu;
    }
    
    return Cn;
  }
  

  static final gnu.mapping.Symbol Sc;
  
  static final gnu.mapping.Symbol Pd;
  
  static final gnu.mapping.Symbol Nd;
  
  static final gnu.mapping.Symbol Me;
  
  static final gnu.mapping.Symbol Pe;
  static final gnu.mapping.Symbol Pf;
  static final gnu.mapping.Symbol Cf;
  static final gnu.mapping.Symbol Pi;
  static final gnu.mapping.Symbol Nl;
  static final gnu.mapping.Symbol Zl;
  static final gnu.mapping.Symbol Ll;
  static final gnu.mapping.Symbol Sm;
  static final gnu.mapping.Symbol Lm;
  static final gnu.mapping.Symbol Sk;
  static final gnu.mapping.Symbol Mn;
  static final gnu.mapping.Symbol Lo;
  static final gnu.mapping.Symbol No;
  static final gnu.mapping.Symbol Po;
  static final gnu.mapping.Symbol So;
  static final gnu.mapping.Symbol Zp;
  static final gnu.mapping.Symbol Co;
  static final gnu.mapping.Symbol Zs;
  static final gnu.mapping.Symbol Ps;
  static final gnu.mapping.Symbol Cs;
  static final gnu.mapping.Symbol Lt;
  static final gnu.mapping.Symbol Cn;
  static final gnu.mapping.Symbol Lu;
  static
  {
    Namespace empty = Namespace.EmptyNamespace;
    Mc = empty.getSymbol("Mc");
    Pc = empty.getSymbol("Pc");
    Cc = empty.getSymbol("Cc");
    Sc = empty.getSymbol("Sc");
    Pd = empty.getSymbol("Pd");
    Nd = empty.getSymbol("Nd");
    Me = empty.getSymbol("Me");
    Pe = empty.getSymbol("Pe");
    Pf = empty.getSymbol("Pf");
    Cf = empty.getSymbol("Cf");
    Pi = empty.getSymbol("Pi");
    Nl = empty.getSymbol("Nl");
    Zl = empty.getSymbol("Zl");
    Ll = empty.getSymbol("Ll");
    Sm = empty.getSymbol("Sm");
    Lm = empty.getSymbol("Lm");
    Sk = empty.getSymbol("Sk");
    Mn = empty.getSymbol("Mn");
    Lo = empty.getSymbol("Lo");
    No = empty.getSymbol("No");
    Po = empty.getSymbol("Po");
    So = empty.getSymbol("So");
    Zp = empty.getSymbol("Zp");
    Co = empty.getSymbol("Co");
    Zs = empty.getSymbol("Zs");
    Ps = empty.getSymbol("Ps");
    Cs = empty.getSymbol("Cs");
    Lt = empty.getSymbol("Lt");
    Cn = empty.getSymbol("Cn");
    Lu = empty.getSymbol("Lu");
  }
}
