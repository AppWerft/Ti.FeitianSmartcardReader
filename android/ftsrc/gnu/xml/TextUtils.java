package gnu.xml;

import gnu.kawa.xml.KNode;
import gnu.mapping.Values;
import gnu.text.Char;

public class TextUtils
{
  public TextUtils() {}
  
  public static String asString(Object node)
  {
    if ((node == Values.empty) || (node == null))
      return "";
    if ((node instanceof Values))
      throw new ClassCastException();
    StringBuffer sbuf = new StringBuffer(100);
    stringValue(node, sbuf);
    return sbuf.toString();
  }
  
  public static String stringValue(Object node)
  {
    StringBuffer sbuf = new StringBuffer(100);
    Values vals; int ipos; if ((node instanceof Values))
    {
      vals = (Values)node;
      int index = 0;
      for (ipos = 0; (ipos = vals.nextPos(ipos)) != 0;)
      {
        stringValue(vals.getPosPrevious(ipos), sbuf);
      }
    }
    else {
      stringValue(node, sbuf); }
    return sbuf.toString();
  }
  
  public static void stringValue(Object node, StringBuffer sbuf) {
    if ((node instanceof KNode)) {
      KNode pos = (KNode)node;
      NodeTree tlist = (NodeTree)sequence;
      tlist.stringValue(tlist.posToDataIndex(ipos), sbuf);
    } else if ((node instanceof Char)) {
      Char.print(((Char)node).intValue(), sbuf);
    } else if ((node instanceof Character)) {
      sbuf.append(((Character)node).charValue());
    } else {
      if ((node instanceof java.math.BigDecimal)) {
        node = XMLPrinter.formatDecimal((java.math.BigDecimal)node);
      } else if (((node instanceof Double)) || ((node instanceof gnu.math.DFloNum))) {
        node = XMLPrinter.formatDouble(((Number)node).doubleValue());
      } else if ((node instanceof Float))
        node = XMLPrinter.formatFloat(((Number)node).floatValue());
      if ((node != null) && (node != Values.empty)) {
        sbuf.append(node);
      }
    }
  }
  
  public static void textValue(Object arg, gnu.lists.Consumer out) {
    if ((arg == null) || (((arg instanceof Values)) && (((Values)arg).isEmpty()))) return;
    String str;
    String str;
    if ((arg instanceof String)) {
      str = (String)arg;
    }
    else {
      StringBuffer sbuf = new StringBuffer();
      Values vals; int count; int ipos; if ((arg instanceof Values))
      {
        vals = (Values)arg;
        count = -1;
        for (ipos = 0; (ipos = vals.nextPos(ipos)) != 0;)
        {
          count++; if (count > 0)
            sbuf.append(' ');
          stringValue(vals.getPosPrevious(ipos), sbuf);
        }
      }
      else {
        stringValue(arg, sbuf); }
      str = sbuf.toString();
    }
    out.write(str);
  }
  





  public static String replaceWhitespace(String str, boolean collapse)
  {
    StringBuilder sbuf = null;
    


    int len = str.length();
    

    int prevSpace = collapse ? 1 : 0;
    for (int i = 0; i < len;)
    {
      char ch = str.charAt(i++);
      int isSpace = (ch == '\t') || (ch == '\r') || (ch == '\n') ? 2 : ch == ' ' ? 1 : 0;
      
      if ((sbuf == null) && ((isSpace == 2) || ((isSpace == 1) && (prevSpace > 0) && (collapse)) || ((isSpace == 1) && (i == len) && (collapse))))
      {




        sbuf = new StringBuilder();
        


        int k = prevSpace > 0 ? i - 2 : i - 1;
        for (int j = 0; j < k; j++)
          sbuf.append(str.charAt(j));
        ch = ' ';
      }
      if (collapse)
      {
        if ((prevSpace > 0) && (isSpace == 0))
        {
          if ((sbuf != null) && (sbuf.length() > 0))
            sbuf.append(' ');
          prevSpace = 0;
        }
        else if ((isSpace == 2) || ((isSpace == 1) && (prevSpace > 0))) {
          prevSpace = 2;
        } else if (isSpace > 0) {
          prevSpace = 1;
        } else {
          prevSpace = 0; }
        if (prevSpace > 0) {}

      }
      else if (sbuf != null) {
        sbuf.append(ch);
      } }
    if (sbuf != null) {
      return sbuf.toString();
    }
    return str;
  }
}
