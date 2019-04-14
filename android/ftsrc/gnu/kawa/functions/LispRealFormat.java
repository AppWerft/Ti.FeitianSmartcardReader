package gnu.kawa.functions;

import gnu.kawa.format.ReportFormat;
import gnu.math.ExponentialFormat;
import gnu.math.FixedRealFormat;
import java.io.IOException;
import java.text.FieldPosition;
import java.text.Format;


class LispRealFormat
  extends ReportFormat
{
  char op;
  int arg1;
  int arg2;
  int arg3;
  int arg4;
  int arg5;
  int arg6;
  int arg7;
  boolean showPlus;
  boolean internalPad;
  int argsUsed = -1;
  


  public char style = 'L';
  
  LispRealFormat() {}
  
  public Format resolve(Object[] args, int start)
  {
    if (argsUsed < 0) {
      argsUsed = ((arg1 == -1342177280) || (arg2 == -1342177280) || (arg3 == -1342177280) || (arg4 == -1342177280) || (arg5 == -1342177280) || (arg6 == -1342177280) || (arg7 == -1342177280) ? 1 : 0);
      





      if (arg1 == -1610612736) argsUsed += 2;
      if (arg2 == -1610612736) argsUsed += 2;
      if (arg3 == -1610612736) argsUsed += 2;
      if (arg4 == -1610612736) argsUsed += 2;
      if (arg5 == -1610612736) argsUsed += 2;
      if (arg6 == -1610612736) argsUsed += 2;
      if (arg7 == -1610612736) argsUsed += 2;
    }
    if ((argsUsed > 0) && (args == null))
      return this;
    if (op == '$') {
      FixedRealFormat mfmt = new FixedRealFormat();
      int decimals = getParam(arg1, 2, args, start);
      if (arg1 == -1610612736) start++;
      int digits = getParam(arg2, 1, args, start);
      if (arg2 == -1610612736) start++;
      int width = getParam(arg3, 0, args, start);
      if (arg3 == -1610612736) start++;
      char padChar = getParam(arg4, ' ', args, start);
      if (arg4 == -1610612736) { start++;
      }
      mfmt.setMaximumFractionDigits(decimals);
      mfmt.setMinimumIntegerDigits(digits);
      width = width;
      padChar = padChar;
      internalPad = internalPad;
      showPlus = showPlus;
      return mfmt; }
    if ((op == 'F') || (op == 'f')) {
      FixedRealFormat mfmt = new FixedRealFormat();
      int width = getParam(arg1, 0, args, start);
      if (arg1 == -1610612736) start++;
      int decimals = getParam(arg2, -1, args, start);
      if (arg2 == -1610612736) start++;
      int scale = getParam(arg3, 0, args, start);
      if (arg3 == -1610612736) start++;
      overflowChar = getParam(arg4, '\000', args, start);
      if (arg4 == -1610612736) start++;
      char padChar = getParam(arg5, ' ', args, start);
      if (arg5 == -1610612736) start++;
      mfmt.setMaximumFractionDigits(decimals);
      mfmt.setMinimumIntegerDigits(0);
      width = width;
      scale = scale;
      padChar = padChar;
      internalPad = internalPad;
      showPlus = showPlus;
      return mfmt;
    }
    ExponentialFormat efmt = new ExponentialFormat();
    exponentShowSign = true;
    width = getParam(arg1, 0, args, start);
    if (arg1 == -1610612736) start++;
    fracDigits = getParam(arg2, -1, args, start);
    if (arg2 == -1610612736) start++;
    expDigits = getParam(arg3, 0, args, start);
    if (arg3 == -1610612736) start++;
    intDigits = getParam(arg4, 1, args, start);
    if (arg4 == -1610612736) start++;
    overflowChar = getParam(arg5, '\000', args, start);
    if (arg5 == -1610612736) start++;
    padChar = getParam(arg6, ' ', args, start);
    if (arg6 == -1610612736) start++;
    exponentChar = getParam(arg7, 'E', args, start);
    if (arg7 == -1610612736) start++;
    general = ((op == 'G') || (op == 'g'));
    style = style;
    showPlus = showPlus;
    return efmt;
  }
  
  public int format(Object[] args, int start, Appendable dst, FieldPosition fpos)
    throws IOException
  {
    StringBuffer sbuf = new StringBuffer(100);
    Format fmt = resolve(args, start);
    start += (argsUsed >> 1);
    Number value = (Number)args[(start++)];
    fmt.format(value, sbuf, fpos);
    dst.append(sbuf);
    return start;
  }
}
