package gnu.kawa.functions;

import gnu.lists.Array;
import gnu.lists.Arrays;
import gnu.lists.GeneralArray;


public class ArrayPrint
{
  private ArrayPrint() {}
  
  public static String print(Object value, String format)
  {
    if ((value instanceof Array)) {
      StringBuilder sbuf = new StringBuilder();
      Array arr = (Array)value;
      int rank = arr.rank();
      int size = getSize(arr);
      int nfields = rank == 0 ? 1 : arr.getSize(rank - 1);
      int[] fieldw = new int[nfields];
      int[] indexes = new int[rank];
      int[] lows = new int[rank];
      int[] dims = new int[rank];
      String[][] cells = new String[size][];
      boolean[] rightAlign = new boolean[size];
      int icell = 0;
      String vectag = (arr instanceof GeneralArray) ? ((GeneralArray)arr).getTag() : "a";
      

      int headStart = sbuf.length();
      sbuf.append("#" + rank + (vectag == null ? "a" : vectag));
      int headEnd = sbuf.length();
      boolean dimsNeeded = false;
      for (int r = 0; r < rank; r++) {
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
        String str = print(arr.get(indexes), format);
        sbuf.append(' ');
        sbuf.append(str);
        return sbuf.toString();
      }
      if (size == 0) {
        sbuf.append(" ()");
        return sbuf.toString();
      }
      
      for (int i = 0; i < size; i++) {
        int col = i % nfields;
        Object element = arr.get(indexes);
        String str = print(element, format);
        String[] lines = splitLines(str);
        rightAlign[icell] = (element instanceof Number);
        cells[icell] = lines;
        icell++;
        fieldw[col] = columnWidth(lines, fieldw[col]);
        Arrays.incrementIndexes(indexes, arr);
      }
      int twidth = nfields + 1;
      for (int i = 0; i < nfields; i++)
        twidth += fieldw[i];
      int slen = sbuf.length();
      if (twidth > slen) {
        sbuf.insert(0, '╔');
      } else if ((twidth < slen) && (!dimsNeeded)) {
        sbuf.setLength(headEnd);
      }
      headEnd = sbuf.length();
      int headSize = headEnd - headStart;
      if (headSize >= twidth) {
        sbuf.append('\n');
      } else {
        putLine(0, fieldw, sbuf);
        sbuf.delete(headEnd, headEnd + headSize);
      }
      int groupSize = rank > 2 ? nfields * arr.getSize(rank - 2) : size;
      int rows = getSizePrefix(arr);
      for (int ii = 0; ii < rows;) {
        int i = ii * nfields;
        int nlines = 0;
        for (int k = 0; k < nfields; k++)
        {
          int nl = cells[(i + k)].length;
          if (nl > nlines) {
            nlines = nl;
          }
        }
        for (int j = 0; j < nlines; j++) {
          sbuf.append('║');
          for (int k = 0; k < nfields; k++) {
            String[] lines = cells[(i + k)];
            String line = j >= lines.length ? "" : lines[j];
            boolean padLeft = rightAlign[(i + k)];
            int linelen = line.length();
            int width = fieldw[k];
            if (padLeft)
              putSpaces(sbuf, width - linelen);
            sbuf.append(line);
            if (!padLeft)
              putSpaces(sbuf, width - linelen);
            sbuf.append(k + 1 < nfields ? '│' : '║');
          }
          sbuf.append('\n');
        }
        ii++; if (ii == rows)
          break;
        int hmode = (rank > 2) && (arr.getSize(rank - 2) > 0) && (ii % arr.getSize(rank - 2) == 0) ? 2 : 1;
        



        putLine(hmode, fieldw, sbuf);
      }
      putLine(3, fieldw, sbuf);
      return sbuf.toString();
    }
    if (format == null)
      format = "~a";
    return Format.formatToString(0, new Object[] { format, value });
  }
  

  private static void putLine(int hmode, int[] fieldw, StringBuilder sbuf)
  {
    int nfields = fieldw.length;
    sbuf.append("╔╟╠╚".charAt(hmode));
    for (int k = 0; k < nfields;) {
      putChars(sbuf, fieldw[k], "═─══".charAt(hmode));
      
      k++; if (k >= nfields)
        break;
      sbuf.append("╤┼╪╧".charAt(hmode));
    }
    sbuf.append("╗╢╣╝".charAt(hmode));
    if (hmode != 3) {
      sbuf.append('\n');
    }
  }
  
  static void putSpaces(StringBuilder sbuf, int n) { putChars(sbuf, n, ' '); }
  
  static void putChars(StringBuilder sbuf, int n, char ch) { for (;;) { 
      if (n < 0) break;
      sbuf.append(ch);
    }
  }
  
  static int columnWidth(CharSequence str) { return str.length(); }
  
  static int columnWidth(String[] strs, int wmax)
  {
    int i = strs.length; for (;;) { i--; if (i < 0) break;
      int w = columnWidth(strs[i]);
      if (w > wmax)
        wmax = w;
    }
    return wmax;
  }
  
  public static int getSize(Array arr)
  {
    int r = arr.rank();
    int sz = 1;
    for (;;) { r--; if (r < 0) break;
      sz *= arr.getSize(r); }
    return sz;
  }
  
  public static int getSizePrefix(Array arr)
  {
    int r = arr.rank() - 1;
    int sz = 1;
    for (;;) { r--; if (r < 0) break;
      sz *= arr.getSize(r); }
    return sz;
  }
  
  static String[] splitLines(String str) {
    int len = str.length();
    int count = 0;
    int i = len; for (;;) { i--; if (i < 0) break;
      if (str.charAt(i) == '\n')
        count++;
    }
    if ((len == 0) || (str.charAt(len - 1) != '\n'))
      count++;
    String[] lines = new String[count];
    int j = 0;
    int prevStart = 0;
    for (int i = 0;; i++) {
      if ((i == len) || (str.charAt(i) == '\n')) {
        lines[(j++)] = str.substring(prevStart, i);
        prevStart = i + 1;
        if (prevStart >= len)
          break;
      }
    }
    return lines;
  }
}
