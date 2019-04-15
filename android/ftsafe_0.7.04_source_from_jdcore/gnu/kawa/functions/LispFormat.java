package gnu.kawa.functions;

import gnu.kawa.format.CaseConvertFormat;
import gnu.kawa.format.CompoundFormat;
import gnu.kawa.format.DelimitSubstitutionFormat;
import gnu.kawa.format.LiteralFormat;
import gnu.lists.Pair;
import gnu.lists.Sequence;
import gnu.math.IntNum;
import gnu.text.Char;
import java.text.Format;
import java.text.ParseException;
import java.util.Stack;
import java.util.Vector;

public class LispFormat extends CompoundFormat
{
  public static final String paramFromList = "<from list>";
  public static final String paramFromCount = "<from count>";
  public static final String paramUnspecified = "<unspecified>";
  static final DelimitSubstitutionFormat delimitSubstitutionInstance = DelimitSubstitutionFormat.getInstance(ObjectFormat.getInstance(false));
  


  public LispFormat(char[] format, int offset, int length)
    throws ParseException
  {
    super(null, 0);
    
    int start_nesting = -1;
    int choices_seen = 0;
    
    StringBuffer litbuf = new StringBuffer(100);
    Stack stack = new Stack();
    
    int limit = offset + length;
    int i = offset;
    



    for (;;)
    {
      if ((i >= limit) || (format[i] == '~'))
      {
        LiteralFormat fmt = litbuf.length() > 0 ? new LiteralFormat(litbuf) : LiteralFormat.separator;
        
        stack.push(fmt);
        litbuf.setLength(0);
      }
      if (i >= limit)
        break;
      char ch = format[(i++)];
      if (ch != '~')
      {
        litbuf.append(ch);
      }
      else {
        int speci = stack.size();
        ch = format[(i++)];
        for (;;)
        {
          if (ch == '#')
          {
            stack.push("<from count>");
            ch = format[(i++)];
          }
          else if ((ch == 'v') || (ch == 'V'))
          {
            stack.push("<from list>");
            ch = format[(i++)];
          }
          else if ((ch == '-') || (ch == '+') || (Character.digit(ch, 10) >= 0))
          {
            boolean neg = ch == '-';
            if ((neg) || (ch == '+'))
              ch = format[(i++)];
            int val = 0;
            int start = i;
            for (;;)
            {
              int dig = Character.digit(ch, 10);
              if (dig < 0)
                break;
              val = 10 * val + dig;
              ch = format[(i++)];
            }
            stack.push(i - start < 8 ? IntNum.make(neg ? -val : val) : IntNum.valueOf(format, start, i - start, 10, neg));

          }
          else if (ch == '\'')
          {
            stack.push(Char.make(format[(i++)]));
            ch = format[(i++)];
          } else {
            if (ch != ',')
              break;
            stack.push("<unspecified>");
          }
          

          if (ch != ',')
            break;
          ch = format[(i++)];
        }
        boolean seenColon = false;
        boolean seenAt = false;
        for (;;)
        {
          if (ch == ':') {
            seenColon = true;
          } else { if (ch != '@') break;
            seenAt = true;
          }
          
          ch = format[(i++)];
        }
        ch = Character.toUpperCase(ch);
        int numParams = stack.size() - speci;
        int minWidth;
        int padChar;
        Format fmt; int charVal; CaseConvertFormat cfmt; LispIterationFormat lfmt; LispPrettyFormat pfmt; LispChoiceFormat afmt; Format fmt; int param1; int param2; int param3; int count; switch (ch) {
        case 'B': case 'D': case 'O': 
        case 'R': case 'X': 
          int argstart = speci;
          int base;
          int base; if (ch == 'R') { base = getParam(stack, argstart++); } else { int base;
            if (ch == 'D') { base = 10; } else { int base;
              if (ch == 'O') { base = 8; } else { int base;
                if (ch == 'X') base = 16; else
                  base = 2; } } }
          minWidth = getParam(stack, argstart);
          padChar = getParam(stack, argstart + 1);
          int commaChar = getParam(stack, argstart + 2);
          int commaInterval = getParam(stack, argstart + 3);
          int flags = 0;
          if (seenColon)
            flags |= 0x1;
          if (seenAt)
            flags |= 0x2;
          fmt = IntegerFormat.getInstance(base, minWidth, padChar, commaChar, commaInterval, flags);
          
          break;
        case 'P': 
          fmt = LispPluralFormat.getInstance(seenColon, seenAt);
          break;
        case '$': 
        case 'E': 
        case 'F': 
        case 'G': 
          LispRealFormat dfmt = new LispRealFormat();
          op = ch;
          style = 'L';
          arg1 = getParam(stack, speci);
          arg2 = getParam(stack, speci + 1);
          arg3 = getParam(stack, speci + 2);
          arg4 = getParam(stack, speci + 3);
          if (ch != '$')
          {
            arg5 = getParam(stack, speci + 4);
            if ((ch == 'E') || (ch == 'G'))
            {
              arg6 = getParam(stack, speci + 5);
              arg7 = getParam(stack, speci + 6);
            }
          }
          showPlus = seenAt;
          internalPad = seenColon;
          fmt = dfmt.resolve(null, 0);
          break;
        case 'A': case 'S': 
        case 'W': 
        case 'Y': 
          minWidth = getParam(stack, speci);
          int colInc = getParam(stack, speci + 1);
          int minPad = getParam(stack, speci + 2);
          padChar = getParam(stack, speci + 3);
          fmt = new LispObjectFormat(ObjectFormat.getInstance(ch != 'A'), minWidth, colInc, minPad, padChar, seenAt ? 0 : 100);
          


          break;
        case 'C': 
          charVal = numParams > 0 ? getParam(stack, speci) : -1610612736;
          
          fmt = LispCharacterFormat.getInstance(charVal, 1, seenAt, seenColon);
          
          break;
        case '*': 
          fmt = new LispRepositionFormat(getParam(stack, speci), seenColon, seenAt);
          
          break;
        case '(': 
          ch = seenAt ? 'T' : seenColon ? 'C' : seenAt ? 'U' : 'L';
          cfmt = new CaseConvertFormat(null, ch);
          stack.setSize(speci);
          stack.push(cfmt);
          stack.push(IntNum.make(start_nesting));
          start_nesting = speci;
          break;
        case ')': 
          if ((start_nesting < 0) || (!(stack.elementAt(start_nesting) instanceof CaseConvertFormat)))
          {

            throw new ParseException("saw ~) without matching ~(", i); }
          cfmt = (CaseConvertFormat)stack.elementAt(start_nesting);
          cfmt.setBaseFormat(popFormats(stack, start_nesting + 2, speci));
          start_nesting = ((IntNum)stack.pop()).intValue();
          break;
        case '?': 
          lfmt = new LispIterationFormat();
          seenAt = seenAt;
          maxIterations = 1;
          atLeastOnce = true;
          fmt = lfmt;
          break;
        case '{': 
          lfmt = new LispIterationFormat();
          seenAt = seenAt;
          seenColon = seenColon;
          maxIterations = getParam(stack, speci);
          stack.setSize(speci);
          stack.push(lfmt);
          stack.push(IntNum.make(start_nesting));
          start_nesting = speci;
          break;
        case '}': 
          if ((start_nesting < 0) || (!(stack.elementAt(start_nesting) instanceof LispIterationFormat)))
          {

            throw new ParseException("saw ~} without matching ~{", i); }
          lfmt = (LispIterationFormat)stack.elementAt(start_nesting);
          atLeastOnce = seenColon;
          if (speci > start_nesting + 2)
          {
            Format body = popFormats(stack, start_nesting + 2, speci);
            if (body != LiteralFormat.separator)
              body = body;
          }
          start_nesting = ((IntNum)stack.pop()).intValue();
          break;
        case '<': 
          pfmt = new LispPrettyFormat();
          seenAt = seenAt;
          if (seenColon)
          {
            prefix = "(";
            suffix = ")";
          }
          else
          {
            prefix = "";
            suffix = "";
          }
          stack.setSize(speci);
          stack.push(pfmt);
          stack.push(IntNum.make(start_nesting));
          stack.push(IntNum.make(choices_seen));
          start_nesting = speci;
          choices_seen = 0;
          break;
        case '>': 
          if ((start_nesting < 0) || (!(stack.elementAt(start_nesting) instanceof LispPrettyFormat)))
          {

            throw new ParseException("saw ~> without matching ~<", i); }
          fmt = popFormats(stack, start_nesting + 3 + choices_seen, speci);
          stack.push(fmt);
          pfmt = (LispPrettyFormat)stack.elementAt(start_nesting);
          segments = getFormats(stack, start_nesting + 3, stack.size());
          stack.setSize(start_nesting + 3);
          start_nesting = ((IntNum)stack.pop()).intValue();
          start_nesting = ((IntNum)stack.pop()).intValue();
          if (seenColon)
          {
            int nsegments = segments.length;
            if (nsegments > 3)
              throw new ParseException("too many segments in Logical Block format", i);
            if (nsegments >= 2)
            {
              if (!(segments[0] instanceof LiteralFormat))
                throw new ParseException("prefix segment is not literal", i);
              prefix = ((LiteralFormat)segments[0]).content();
              body = segments[1];
            }
            else {
              body = segments[0]; }
            if (nsegments >= 3)
            {
              if (!(segments[2] instanceof LiteralFormat))
                throw new ParseException("suffix segment is not literal", i);
              suffix = ((LiteralFormat)segments[2]).content();
            }
          }
          else {
            throw new ParseException("not implemented: justfication i.e. ~<...~>", i);
          }
          break;
        case '[':  afmt = new LispChoiceFormat();
          param = getParam(stack, speci);
          if (param == -1073741824)
            param = -1610612736;
          if (seenColon)
            testBoolean = true;
          if (seenAt)
            skipIfFalse = true;
          stack.setSize(speci);
          stack.push(afmt);
          stack.push(IntNum.make(start_nesting));
          stack.push(IntNum.make(choices_seen));
          start_nesting = speci;
          choices_seen = 0;
          break;
        case ';': 
          if (start_nesting >= 0)
          {
            if ((stack.elementAt(start_nesting) instanceof LispChoiceFormat))
            {

              afmt = (LispChoiceFormat)stack.elementAt(start_nesting);
              if (seenColon)
                lastIsDefault = true;
              fmt = popFormats(stack, start_nesting + 3 + choices_seen, speci);
              
              stack.push(fmt);
              choices_seen++;
              continue;
            }
            if ((stack.elementAt(start_nesting) instanceof LispPrettyFormat))
            {

              pfmt = (LispPrettyFormat)stack.elementAt(start_nesting);
              if (seenAt)
                perLine = true;
              Format fmt = popFormats(stack, start_nesting + 3 + choices_seen, speci);
              
              stack.push(fmt);
              choices_seen++;
              continue;
            }
          }
          
          throw new ParseException("saw ~; without matching ~[ or ~<", i);
        case ']': 
          if ((start_nesting < 0) || (!(stack.elementAt(start_nesting) instanceof LispChoiceFormat)))
          {

            throw new ParseException("saw ~] without matching ~[", i); }
          fmt = popFormats(stack, start_nesting + 3 + choices_seen, speci);
          stack.push(fmt);
          LispChoiceFormat afmt = (LispChoiceFormat)stack.elementAt(start_nesting);
          choices = getFormats(stack, start_nesting + 3, stack.size());
          stack.setSize(start_nesting + 3);
          choices_seen = ((IntNum)stack.pop()).intValue();
          start_nesting = ((IntNum)stack.pop()).intValue();
          break;
        case '^': 
          param1 = getParam(stack, speci);
          param2 = getParam(stack, speci + 1);
          param3 = getParam(stack, speci + 2);
          fmt = new LispEscapeFormat(param1, param2, param3);
          break;
        case '\n': 
          if (seenAt)
            litbuf.append(ch);
          if (!seenColon) {
            do {
              if (i >= limit)
                break;
              ch = format[(i++)];
            } while (Character.isWhitespace(ch));
            
            i--; }
          break;
        



        case '!': 
          fmt = gnu.kawa.format.FlushFormat.getInstance();
          break;
        case 'T': 
          param1 = getParam(stack, speci);
          param2 = getParam(stack, speci + 1);
          param3 = getParam(stack, speci + 2);
          fmt = new LispTabulateFormat(param1, param2, param3, seenAt);
          break;
        case '&': 
          param1 = getParam(stack, speci);
          fmt = new LispFreshlineFormat(param1);
          break;
        case 'I': 
          param1 = getParam(stack, speci);
          if (param1 == -1073741824)
            param1 = 0;
          fmt = LispIndentFormat.getInstance(param1, seenColon);
          break;
        case '_': 
          param1 = getParam(stack, speci);
          if (param1 == -1073741824)
            param1 = 1;
          charVal = (seenColon) && (seenAt) ? 10 : 32;
          int kind;
          int kind; if ((seenAt) && (seenColon)) { kind = 82; } else { int kind;
            if (seenAt) { kind = 77; } else { int kind;
              if (seenColon) kind = 70; else
                kind = 78; } }
          fmt = LispNewlineFormat.getInstance(param1, kind);
          break;
        case '~': 
          if (numParams == 0)
          {
            litbuf.append(ch); }
          break;
        

        case '|': 
          count = getParam(stack, speci);
          if (count == -1073741824) {
            count = 1;
          }
          charVal = getParam(stack, speci + 1);
          if (charVal == -1073741824)
            charVal = ch == '|' ? 12 : 126;
          fmt = LispCharacterFormat.getInstance(charVal, count, false, false);
          
          break;
        case '%': 
          count = getParam(stack, speci);
          if (count == -1073741824)
            count = 1;
          fmt = LispNewlineFormat.getInstance(count, 76);
          
          break;
        case 'Q': 
          fmt = delimitSubstitutionInstance;
          break;
        case '\013': case '\f': case '\r': case '\016': case '\017': case '\020': case '\021': case '\022': case '\023': case '\024': case '\025': case '\026': case '\027': case '\030': case '\031': case '\032': case '\033': case '\034': case '\035': case '\036': case '\037': case ' ': case '"': case '#': case '\'': case '+': case ',': case '-': case '.': case '/': case '0': case '1': case '2': case '3': case '4': case '5': case '6': case '7': case '8': case '9': case ':': case '=': case '@': case 'H': case 'J': case 'K': case 'L': case 'M': case 'N': case 'U': case 'V': case 'Z': case '\\': case '`': case 'a': case 'b': case 'c': case 'd': case 'e': case 'f': case 'g': case 'h': case 'i': case 'j': case 'k': case 'l': case 'm': case 'n': case 'o': case 'p': case 'q': case 'r': case 's': case 't': case 'u': case 'v': case 'w': case 'x': case 'y': case 'z': default: 
          throw new ParseException("unrecognized format specifier ~" + ch, i);
          
          stack.setSize(speci);
          stack.push(fmt); }
      } }
    if (i > limit)
      throw new IndexOutOfBoundsException();
    if (start_nesting >= 0)
    {
      throw new ParseException("missing ~] or ~}", i);
    }
    this.length = stack.size();
    formats = new Format[this.length];
    stack.copyInto(formats);
  }
  
  static Format[] getFormats(Vector vector, int start, int end)
  {
    Format[] f = new Format[end - start];
    for (int i = start; i < end; i++)
      f[(i - start)] = ((Format)vector.elementAt(i));
    return f;
  }
  
  static Format popFormats(Vector vector, int start, int end) {
    Format f;
    Format f;
    if (end == start + 1) {
      f = (Format)vector.elementAt(start);
    } else
      f = new CompoundFormat(getFormats(vector, start, end));
    vector.setSize(start);
    return f;
  }
  
  public LispFormat(String str)
    throws ParseException
  {
    this(str.toCharArray());
  }
  













































  public LispFormat(char[] format)
    throws ParseException
  {
    this(format, 0, format.length);
  }
  
  public static int getParam(Vector vec, int index)
  {
    if (index >= vec.size())
      return -1073741824;
    Object arg = vec.elementAt(index);
    if (arg == "<from list>")
      return -1610612736;
    if (arg == "<from count>")
      return -1342177280;
    if (arg == "<unspecified>")
      return -1073741824;
    return getParam(arg, -1073741824);
  }
  


  public static Object[] asArray(Object arg)
  {
    if ((arg instanceof Object[]))
      return (Object[])arg;
    if (!(arg instanceof Sequence))
      return null;
    int count = ((Sequence)arg).size();
    Object[] arr = new Object[count];
    int i = 0;
    while ((arg instanceof Pair))
    {
      Pair pair = (Pair)arg;
      arr[(i++)] = pair.getCar();
      arg = pair.getCdr();
    }
    if (i < count)
    {
      if (!(arg instanceof Sequence))
        return null;
      int npairs = i;
      Sequence seq = (Sequence)arg;
      for (; i < count; i++)
        arr[i] = seq.get(npairs + i);
    }
    return arr;
  }
}
