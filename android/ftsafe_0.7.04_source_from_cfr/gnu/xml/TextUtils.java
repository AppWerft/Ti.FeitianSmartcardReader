/*
 * Decompiled with CFR 0.139.
 */
package gnu.xml;

import gnu.kawa.xml.KNode;
import gnu.lists.AbstractSequence;
import gnu.lists.Consumer;
import gnu.mapping.Values;
import gnu.math.DFloNum;
import gnu.text.Char;
import gnu.xml.NodeTree;
import gnu.xml.XMLPrinter;
import java.math.BigDecimal;

public class TextUtils {
    public static String asString(Object node) {
        if (node == Values.empty || node == null) {
            return "";
        }
        if (node instanceof Values) {
            throw new ClassCastException();
        }
        StringBuffer sbuf = new StringBuffer(100);
        TextUtils.stringValue(node, sbuf);
        return sbuf.toString();
    }

    public static String stringValue(Object node) {
        StringBuffer sbuf = new StringBuffer(100);
        if (node instanceof Values) {
            Values vals = (Values)node;
            boolean index = false;
            int ipos = 0;
            while ((ipos = vals.nextPos(ipos)) != 0) {
                TextUtils.stringValue(vals.getPosPrevious(ipos), sbuf);
            }
        } else {
            TextUtils.stringValue(node, sbuf);
        }
        return sbuf.toString();
    }

    public static void stringValue(Object node, StringBuffer sbuf) {
        if (node instanceof KNode) {
            KNode pos = (KNode)node;
            NodeTree tlist = (NodeTree)pos.sequence;
            tlist.stringValue(tlist.posToDataIndex(pos.ipos), sbuf);
        } else if (node instanceof Char) {
            Char.print(((Char)node).intValue(), sbuf);
        } else if (node instanceof Character) {
            sbuf.append(((Character)node).charValue());
        } else {
            if (node instanceof BigDecimal) {
                node = XMLPrinter.formatDecimal((BigDecimal)node);
            } else if (node instanceof Double || node instanceof DFloNum) {
                node = XMLPrinter.formatDouble(((Number)node).doubleValue());
            } else if (node instanceof Float) {
                node = XMLPrinter.formatFloat(((Number)node).floatValue());
            }
            if (node != null && node != Values.empty) {
                sbuf.append(node);
            }
        }
    }

    public static void textValue(Object arg, Consumer out) {
        String str;
        if (arg == null || arg instanceof Values && ((Values)arg).isEmpty()) {
            return;
        }
        if (arg instanceof String) {
            str = (String)arg;
        } else {
            StringBuffer sbuf = new StringBuffer();
            if (arg instanceof Values) {
                Values vals = (Values)arg;
                int count = -1;
                int ipos = 0;
                while ((ipos = vals.nextPos(ipos)) != 0) {
                    if (++count > 0) {
                        sbuf.append(' ');
                    }
                    TextUtils.stringValue(vals.getPosPrevious(ipos), sbuf);
                }
            } else {
                TextUtils.stringValue(arg, sbuf);
            }
            str = sbuf.toString();
        }
        out.write(str);
    }

    public static String replaceWhitespace(String str, boolean collapse) {
        StringBuilder sbuf = null;
        int len = str.length();
        int prevSpace = collapse ? 1 : 0;
        int i = 0;
        while (i < len) {
            int isSpace;
            int ch;
            int n = (ch = str.charAt(i++)) == 32 ? 1 : (isSpace = ch == 9 || ch == 13 || ch == 10 ? 2 : 0);
            if (sbuf == null && (isSpace == 2 || isSpace == 1 && prevSpace > 0 && collapse || isSpace == 1 && i == len && collapse)) {
                sbuf = new StringBuilder();
                int k = prevSpace > 0 ? i - 2 : i - 1;
                for (int j = 0; j < k; ++j) {
                    sbuf.append(str.charAt(j));
                }
                ch = 32;
            }
            if (collapse) {
                if (prevSpace > 0 && isSpace == 0) {
                    if (sbuf != null && sbuf.length() > 0) {
                        sbuf.append(' ');
                    }
                    prevSpace = 0;
                } else {
                    prevSpace = isSpace == 2 || isSpace == 1 && prevSpace > 0 ? 2 : (isSpace > 0 ? 1 : 0);
                }
                if (prevSpace > 0) continue;
            }
            if (sbuf == null) continue;
            sbuf.append((char)ch);
        }
        if (sbuf != null) {
            return sbuf.toString();
        }
        return str;
    }
}

