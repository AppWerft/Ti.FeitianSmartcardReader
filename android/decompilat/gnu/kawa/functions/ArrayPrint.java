// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.functions;

import gnu.lists.Arrays;
import gnu.lists.GeneralArray;
import gnu.lists.Array;

public class ArrayPrint
{
    private ArrayPrint() {
    }
    
    public static String print(final Object value, String format) {
        if (!(value instanceof Array)) {
            if (format == null) {
                format = "~a";
            }
            return Format.formatToString(0, format, value);
        }
        final StringBuilder sbuf = new StringBuilder();
        final Array arr = (Array)value;
        final int rank = arr.rank();
        final int size = getSize(arr);
        final int nfields = (rank == 0) ? 1 : arr.getSize(rank - 1);
        final int[] fieldw = new int[nfields];
        final int[] indexes = new int[rank];
        final int[] lows = new int[rank];
        final int[] dims = new int[rank];
        final String[][] cells = new String[size][];
        final boolean[] rightAlign = new boolean[size];
        int icell = 0;
        final String vectag = (arr instanceof GeneralArray) ? ((GeneralArray)arr).getTag() : "a";
        final int headStart = sbuf.length();
        sbuf.append("#" + rank + ((vectag == null) ? "a" : vectag));
        int headEnd = sbuf.length();
        boolean dimsNeeded = false;
        for (int r = 0; r < rank; ++r) {
            final int low = arr.getLowBound(r);
            if (low != 0) {
                sbuf.append('@');
                sbuf.append(low);
                dimsNeeded = true;
            }
            sbuf.append(':');
            sbuf.append(arr.getSize(r));
            lows[r] = (indexes[r] = low);
            dims[r] = arr.getSize(r);
        }
        if (rank == 0) {
            final String str = print(arr.get(indexes), format);
            sbuf.append(' ');
            sbuf.append(str);
            return sbuf.toString();
        }
        if (size == 0) {
            sbuf.append(" ()");
            return sbuf.toString();
        }
        for (int i = 0; i < size; ++i) {
            final int col = i % nfields;
            final Object element = arr.get(indexes);
            final String str2 = print(element, format);
            final String[] lines = splitLines(str2);
            rightAlign[icell] = (element instanceof Number);
            cells[icell] = lines;
            ++icell;
            fieldw[col] = columnWidth(lines, fieldw[col]);
            Arrays.incrementIndexes(indexes, arr);
        }
        int twidth = nfields + 1;
        for (int j = 0; j < nfields; ++j) {
            twidth += fieldw[j];
        }
        final int slen = sbuf.length();
        if (twidth > slen) {
            sbuf.insert(0, '\u2554');
        }
        else if (twidth < slen && !dimsNeeded) {
            sbuf.setLength(headEnd);
        }
        headEnd = sbuf.length();
        final int headSize = headEnd - headStart;
        if (headSize >= twidth) {
            sbuf.append('\n');
        }
        else {
            putLine(0, fieldw, sbuf);
            sbuf.delete(headEnd, headEnd + headSize);
        }
        final int groupSize = (rank > 2) ? (nfields * arr.getSize(rank - 2)) : size;
        final int rows = getSizePrefix(arr);
        int ii = 0;
        while (ii < rows) {
            final int k = ii * nfields;
            int nlines = 0;
            for (int l = 0; l < nfields; ++l) {
                final int nl = cells[k + l].length;
                if (nl > nlines) {
                    nlines = nl;
                }
            }
            for (int m = 0; m < nlines; ++m) {
                sbuf.append('\u2551');
                for (int k2 = 0; k2 < nfields; ++k2) {
                    final String[] lines2 = cells[k + k2];
                    final String line = (m >= lines2.length) ? "" : lines2[m];
                    final boolean padLeft = rightAlign[k + k2];
                    final int linelen = line.length();
                    final int width = fieldw[k2];
                    if (padLeft) {
                        putSpaces(sbuf, width - linelen);
                    }
                    sbuf.append(line);
                    if (!padLeft) {
                        putSpaces(sbuf, width - linelen);
                    }
                    sbuf.append((k2 + 1 < nfields) ? '\u2502' : '\u2551');
                }
                sbuf.append('\n');
            }
            if (++ii == rows) {
                break;
            }
            final int hmode = (rank > 2 && arr.getSize(rank - 2) > 0 && ii % arr.getSize(rank - 2) == 0) ? 2 : 1;
            putLine(hmode, fieldw, sbuf);
        }
        putLine(3, fieldw, sbuf);
        return sbuf.toString();
    }
    
    private static void putLine(final int hmode, final int[] fieldw, final StringBuilder sbuf) {
        final int nfields = fieldw.length;
        sbuf.append("\u2554\u255f\u2560\u255a".charAt(hmode));
        int k = 0;
        while (k < nfields) {
            putChars(sbuf, fieldw[k], "\u2550\u2500\u2550\u2550".charAt(hmode));
            if (++k >= nfields) {
                break;
            }
            sbuf.append("\u2564\u253c\u256a\u2567".charAt(hmode));
        }
        sbuf.append("\u2557\u2562\u2563\u255d".charAt(hmode));
        if (hmode != 3) {
            sbuf.append('\n');
        }
    }
    
    static void putSpaces(final StringBuilder sbuf, final int n) {
        putChars(sbuf, n, ' ');
    }
    
    static void putChars(final StringBuilder sbuf, int n, final char ch) {
        while (--n >= 0) {
            sbuf.append(ch);
        }
    }
    
    static int columnWidth(final CharSequence str) {
        return str.length();
    }
    
    static int columnWidth(final String[] strs, int wmax) {
        int i = strs.length;
        while (--i >= 0) {
            final int w = columnWidth(strs[i]);
            if (w > wmax) {
                wmax = w;
            }
        }
        return wmax;
    }
    
    public static int getSize(final Array arr) {
        int r = arr.rank();
        int sz = 1;
        while (--r >= 0) {
            sz *= arr.getSize(r);
        }
        return sz;
    }
    
    public static int getSizePrefix(final Array arr) {
        int r = arr.rank() - 1;
        int sz = 1;
        while (--r >= 0) {
            sz *= arr.getSize(r);
        }
        return sz;
    }
    
    static String[] splitLines(final String str) {
        final int len = str.length();
        int count = 0;
        int i = len;
        while (--i >= 0) {
            if (str.charAt(i) == '\n') {
                ++count;
            }
        }
        if (len == 0 || str.charAt(len - 1) != '\n') {
            ++count;
        }
        final String[] lines = new String[count];
        int j = 0;
        int prevStart = 0;
        int k = 0;
        while (true) {
            if (k == len || str.charAt(k) == '\n') {
                lines[j++] = str.substring(prevStart, k);
                prevStart = k + 1;
                if (prevStart >= len) {
                    break;
                }
            }
            ++k;
        }
        return lines;
    }
}
