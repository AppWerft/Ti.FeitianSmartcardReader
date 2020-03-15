// 
// Decompiled by Procyon v0.5.36
// 

package gnu.xml;

import gnu.lists.Consumer;
import gnu.math.DFloNum;
import java.math.BigDecimal;
import gnu.text.Char;
import gnu.kawa.xml.KNode;
import gnu.mapping.Values;

public class TextUtils
{
    public static String asString(final Object node) {
        if (node == Values.empty || node == null) {
            return "";
        }
        if (node instanceof Values) {
            throw new ClassCastException();
        }
        final StringBuffer sbuf = new StringBuffer(100);
        stringValue(node, sbuf);
        return sbuf.toString();
    }
    
    public static String stringValue(final Object node) {
        final StringBuffer sbuf = new StringBuffer(100);
        if (node instanceof Values) {
            final Values vals = (Values)node;
            final int index = 0;
            int ipos = 0;
            while ((ipos = vals.nextPos(ipos)) != 0) {
                stringValue(vals.getPosPrevious(ipos), sbuf);
            }
        }
        else {
            stringValue(node, sbuf);
        }
        return sbuf.toString();
    }
    
    public static void stringValue(Object node, final StringBuffer sbuf) {
        if (node instanceof KNode) {
            final KNode pos = (KNode)node;
            final NodeTree tlist = (NodeTree)pos.sequence;
            tlist.stringValue(tlist.posToDataIndex(pos.ipos), sbuf);
        }
        else if (node instanceof Char) {
            Char.print(((Char)node).intValue(), sbuf);
        }
        else if (node instanceof Character) {
            sbuf.append((char)node);
        }
        else {
            if (node instanceof BigDecimal) {
                node = XMLPrinter.formatDecimal((BigDecimal)node);
            }
            else if (node instanceof Double || node instanceof DFloNum) {
                node = XMLPrinter.formatDouble(((Number)node).doubleValue());
            }
            else if (node instanceof Float) {
                node = XMLPrinter.formatFloat(((Number)node).floatValue());
            }
            if (node != null && node != Values.empty) {
                sbuf.append(node);
            }
        }
    }
    
    public static void textValue(final Object arg, final Consumer out) {
        if (arg == null || (arg instanceof Values && ((Values)arg).isEmpty())) {
            return;
        }
        String str;
        if (arg instanceof String) {
            str = (String)arg;
        }
        else {
            final StringBuffer sbuf = new StringBuffer();
            if (arg instanceof Values) {
                final Values vals = (Values)arg;
                int count = -1;
                int ipos = 0;
                while ((ipos = vals.nextPos(ipos)) != 0) {
                    if (++count > 0) {
                        sbuf.append(' ');
                    }
                    stringValue(vals.getPosPrevious(ipos), sbuf);
                }
            }
            else {
                stringValue(arg, sbuf);
            }
            str = sbuf.toString();
        }
        out.write(str);
    }
    
    public static String replaceWhitespace(final String str, final boolean collapse) {
        StringBuilder sbuf = null;
        final int len = str.length();
        int prevSpace = collapse ? 1 : 0;
        int i = 0;
        while (i < len) {
            char ch = str.charAt(i++);
            final int isSpace = (ch == ' ') ? 1 : ((ch == '\t' || ch == '\r' || ch == '\n') ? 2 : 0);
            if (sbuf == null && (isSpace == 2 || (isSpace == 1 && prevSpace > 0 && collapse) || (isSpace == 1 && i == len && collapse))) {
                sbuf = new StringBuilder();
                for (int k = (prevSpace > 0) ? (i - 2) : (i - 1), j = 0; j < k; ++j) {
                    sbuf.append(str.charAt(j));
                }
                ch = ' ';
            }
            if (collapse) {
                if (prevSpace > 0 && isSpace == 0) {
                    if (sbuf != null && sbuf.length() > 0) {
                        sbuf.append(' ');
                    }
                    prevSpace = 0;
                }
                else if (isSpace == 2 || (isSpace == 1 && prevSpace > 0)) {
                    prevSpace = 2;
                }
                else if (isSpace > 0) {
                    prevSpace = 1;
                }
                else {
                    prevSpace = 0;
                }
                if (prevSpace > 0) {
                    continue;
                }
            }
            if (sbuf != null) {
                sbuf.append(ch);
            }
        }
        if (sbuf != null) {
            return sbuf.toString();
        }
        return str;
    }
}
