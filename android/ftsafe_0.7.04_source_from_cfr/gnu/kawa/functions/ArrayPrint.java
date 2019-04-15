/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.functions;

import gnu.kawa.functions.Format;
import gnu.lists.Array;
import gnu.lists.Arrays;
import gnu.lists.GeneralArray;

public class ArrayPrint {
    private ArrayPrint() {
    }

    public static String print(Object value, String format) {
        if (value instanceof Array) {
            StringBuilder sbuf = new StringBuilder();
            Array arr = (Array)value;
            int rank = arr.rank();
            int size = ArrayPrint.getSize(arr);
            int nfields = rank == 0 ? 1 : arr.getSize(rank - 1);
            int[] fieldw = new int[nfields];
            int[] indexes = new int[rank];
            int[] lows = new int[rank];
            int[] dims = new int[rank];
            String[][] cells = new String[size][];
            boolean[] rightAlign = new boolean[size];
            int icell = 0;
            String vectag = arr instanceof GeneralArray ? ((GeneralArray)arr).getTag() : "a";
            int headStart = sbuf.length();
            sbuf.append("#" + rank + (vectag == null ? "a" : vectag));
            int headEnd = sbuf.length();
            boolean dimsNeeded = false;
            for (int r = 0; r < rank; ++r) {
                int low = arr.getLowBound(r);
                if (low != 0) {
                    sbuf.append('@');
                    sbuf.append(low);
                    dimsNeeded = true;
                }
                sbuf.append(':');
                sbuf.append(arr.getSize(r));
                indexes[r] = low;
                lows[r] = low;
                dims[r] = arr.getSize(r);
            }
            if (rank == 0) {
                String str = ArrayPrint.print(arr.get(indexes), format);
                sbuf.append(' ');
                sbuf.append(str);
                return sbuf.toString();
            }
            if (size == 0) {
                sbuf.append(" ()");
                return sbuf.toString();
            }
            for (int i = 0; i < size; ++i) {
                int col = i % nfields;
                Object element = arr.get(indexes);
                String str = ArrayPrint.print(element, format);
                String[] lines = ArrayPrint.splitLines(str);
                rightAlign[icell] = element instanceof Number;
                cells[icell] = lines;
                ++icell;
                fieldw[col] = ArrayPrint.columnWidth(lines, fieldw[col]);
                Arrays.incrementIndexes(indexes, arr);
            }
            int twidth = nfields + 1;
            for (int i = 0; i < nfields; ++i) {
                twidth += fieldw[i];
            }
            int slen = sbuf.length();
            if (twidth > slen) {
                sbuf.insert(0, '\u2554');
            } else if (twidth < slen && !dimsNeeded) {
                sbuf.setLength(headEnd);
            }
            headEnd = sbuf.length();
            int headSize = headEnd - headStart;
            if (headSize >= twidth) {
                sbuf.append('\n');
            } else {
                ArrayPrint.putLine(0, fieldw, sbuf);
                sbuf.delete(headEnd, headEnd + headSize);
            }
            int groupSize = rank > 2 ? nfields * arr.getSize(rank - 2) : size;
            int rows = ArrayPrint.getSizePrefix(arr);
            int ii = 0;
            while (ii < rows) {
                int i = ii * nfields;
                int nlines = 0;
                for (int k = 0; k < nfields; ++k) {
                    int nl = cells[i + k].length;
                    if (nl <= nlines) continue;
                    nlines = nl;
                }
                for (int j = 0; j < nlines; ++j) {
                    sbuf.append('\u2551');
                    for (int k = 0; k < nfields; ++k) {
                        String[] lines = cells[i + k];
                        String line = j >= lines.length ? "" : lines[j];
                        boolean padLeft = rightAlign[i + k];
                        int linelen = line.length();
                        int width = fieldw[k];
                        if (padLeft) {
                            ArrayPrint.putSpaces(sbuf, width - linelen);
                        }
                        sbuf.append(line);
                        if (!padLeft) {
                            ArrayPrint.putSpaces(sbuf, width - linelen);
                        }
                        sbuf.append(k + 1 < nfields ? (char)'\u2502' : '\u2551');
                    }
                    sbuf.append('\n');
                }
                if (++ii == rows) break;
                int hmode = rank > 2 && arr.getSize(rank - 2) > 0 && ii % arr.getSize(rank - 2) == 0 ? 2 : 1;
                ArrayPrint.putLine(hmode, fieldw, sbuf);
            }
            ArrayPrint.putLine(3, fieldw, sbuf);
            return sbuf.toString();
        }
        if (format == null) {
            format = "~a";
        }
        return Format.formatToString(0, format, value);
    }

    private static void putLine(int hmode, int[] fieldw, StringBuilder sbuf) {
        int nfields = fieldw.length;
        sbuf.append("\u2554\u255f\u2560\u255a".charAt(hmode));
        int k = 0;
        while (k < nfields) {
            ArrayPrint.putChars(sbuf, fieldw[k], "\u2550\u2500\u2550\u2550".charAt(hmode));
            if (++k >= nfields) break;
            sbuf.append("\u2564\u253c\u256a\u2567".charAt(hmode));
        }
        sbuf.append("\u2557\u2562\u2563\u255d".charAt(hmode));
        if (hmode != 3) {
            sbuf.append('\n');
        }
    }

    static void putSpaces(StringBuilder sbuf, int n) {
        ArrayPrint.putChars(sbuf, n, ' ');
    }

    static void putChars(StringBuilder sbuf, int n, char ch) {
        while (--n >= 0) {
            sbuf.append(ch);
        }
    }

    static int columnWidth(CharSequence str) {
        return str.length();
    }

    static int columnWidth(String[] strs, int wmax) {
        int i = strs.length;
        while (--i >= 0) {
            int w = ArrayPrint.columnWidth(strs[i]);
            if (w <= wmax) continue;
            wmax = w;
        }
        return wmax;
    }

    public static int getSize(Array arr) {
        int r = arr.rank();
        int sz = 1;
        while (--r >= 0) {
            sz *= arr.getSize(r);
        }
        return sz;
    }

    public static int getSizePrefix(Array arr) {
        int r = arr.rank() - 1;
        int sz = 1;
        while (--r >= 0) {
            sz *= arr.getSize(r);
        }
        return sz;
    }

    static String[] splitLines(String str) {
        int len = str.length();
        int count = 0;
        int i = len;
        while (--i >= 0) {
            if (str.charAt(i) != '\n') continue;
            ++count;
        }
        if (len == 0 || str.charAt(len - 1) != '\n') {
            ++count;
        }
        String[] lines = new String[count];
        int j = 0;
        int prevStart = 0;
        int i2 = 0;
        do {
            if (i2 == len || str.charAt(i2) == '\n') {
                lines[j++] = str.substring(prevStart, i2);
                prevStart = i2 + 1;
                if (prevStart >= len) break;
            }
            ++i2;
        } while (true);
        return lines;
    }
}

