package gnu.xml;

import gnu.kawa.io.BinaryInPort;
import gnu.kawa.io.InPort;
import gnu.kawa.io.Path;
import gnu.lists.Consumer;
import gnu.text.SourceMessages;
import java.io.IOException;
import java.io.InputStream;










public class XMLParser
{
  private static final int EXPECT_NAME_MODIFIER = 1;
  private static final int SKIP_SPACES_MODIFIER = 2;
  private static final int INIT_STATE = 0;
  private static final int TEXT_STATE = 1;
  private static final int BEGIN_ELEMENT_STATE = 2;
  private static final int END_ELEMENT_STATE = 4;
  private static final int SAW_ENTITY_REF = 6;
  private static final int ATTRIBUTE_SEEN_NAME_STATE = 8;
  private static final int MAYBE_ATTRIBUTE_STATE = 10;
  private static final int ATTRIBUTE_SEEN_EQ_STATE = 11;
  private static final int DOCTYPE_SEEN_STATE = 13;
  private static final int DOCTYPE_NAME_SEEN_STATE = 16;
  private static final int SAW_LEFT_STATE = 14;
  private static final int SAW_LEFT_SLASH_STATE = 19;
  private static final int SAW_LEFT_EXCL_STATE = 20;
  private static final int SAW_LEFT_QUEST_STATE = 21;
  private static final int SAW_LEFT_EXCL_MINUS_STATE = 22;
  private static final int SAW_AMP_STATE = 25;
  private static final int SAW_AMP_SHARP_STATE = 26;
  private static final int EXPECT_RIGHT_STATE = 27;
  private static final int PREV_WAS_CR_STATE = 28;
  private static final int INIT_LEFT_QUEST_STATE = 30;
  private static final int INIT_TEXT_STATE = 31;
  private static final int INIT_LEFT_STATE = 34;
  private static final int INVALID_VERSION_DECL = 35;
  private static final int SAW_ERROR = 36;
  private static final int SAW_EOF_ERROR = 37;
  private static final int MISSING_XML_DECL = 38;
  static final String BAD_ENCODING_SYNTAX = "bad 'encoding' declaration";
  static final String BAD_STANDALONE_SYNTAX = "bad 'standalone' declaration";
  
  public XMLParser() {}
  
  public static void parse(Object uri, SourceMessages messages, Consumer out)
    throws IOException
  {
    parse(Path.openInputStream(uri), uri, messages, out);
  }
  
  public static BinaryInPort XMLStreamReader(InputStream strm) throws IOException
  {
    BinaryInPort in = new BinaryInPort(strm);
    in.setFromByteOrderMark();
    in.setKeepFullLines(false);
    return in;
  }
  

  public static void parse(InputStream strm, Object uri, SourceMessages messages, Consumer out)
    throws IOException
  {
    BinaryInPort in = XMLStreamReader(strm);
    if (uri != null)
      in.setName(uri);
    parse(in, messages, out);
    in.close();
  }
  
  public static void parse(InPort in, SourceMessages messages, Consumer out)
    throws IOException
  {
    XMLFilter filter = new XMLFilter(out);
    filter.setMessages(messages);
    filter.setSourceLocator(in);
    filter.startDocument();
    Object uri = in.getPath();
    if (uri != null)
      filter.writeDocumentUri(uri);
    parse(in, filter);
    filter.endDocument();
  }
  
  public static void parse(InPort in, SourceMessages messages, XMLFilter filter)
    throws IOException
  {
    filter.setMessages(messages);
    filter.setSourceLocator(in);
    filter.startDocument();
    Object uri = in.getPath();
    if (uri != null)
      filter.writeDocumentUri(uri);
    parse(in, filter);
    filter.endDocument();
    in.close();
  }
  

  public static void parse(InPort in, XMLFilter out)
  {
    char[] buffer = in.buffer;
    int pos = in.pos;
    int limit = in.limit;
    boolean strict = false;
    














    int state = 0;
    



    char terminator = '<';
    int continue_state = 14;
    char ch = ' ';
    int length = 0;
    int dstart = -1;
    String message = null;
    
    int start = -1;
    

    for (;;)
    {
      switch (state)
      {
      case 0: 
        state = 31;
        break;
      
      case 31: 
        if (ch == '<')
        {
          state = 34;
        }
        else
          state = strict ? 38 : 1;
        break;
      
      case 34: 
        if (ch == '?')
        {
          start = pos;
          state = 33;
        }
        else {
          state = strict ? 38 : 14; }
        break;
      
      case 38: 
        message = "missing XML declaration";
        state = 36;
        break;
      
      case 35: 
        pos = dstart;
        message = "invalid xml version specifier";
        state = 36;
        break;
      
      case 36: 
        in.pos = pos;
        start = -1;
        out.error('e', message);
        do
        {
          if (pos >= limit)
            break;
          ch = buffer[(pos++)];
        } while (ch != '>');
        
        state = 1;
        break;
      


      case 37: 
        in.pos = pos;
        out.error('f', "unexpected end-of-file");
        return;
      



      case 1: 
        start = pos - 1;
        
        length = pos;
        for (;;)
        {
          if (ch == terminator)
          {
            state = continue_state;
            break;
          }
          if (ch == '&')
          {
            state = 25;
            break;
          }
          if (ch == '\r')
          {
            length = pos - length;
            in.pos = pos;
            if (length > 0)
              out.textFromParser(buffer, start, length);
            if (pos < limit)
            {
              ch = buffer[pos];
              if (ch == '\n')
              {
                start = pos;
                pos++;length = pos;
              }
              else
              {
                out.linefeedFromParser();
                if (ch == '')
                {
                  start = pos++;
                  length = pos + 1;
                }
                else
                {
                  in.incrLineNumber(1, pos);
                  start = pos;
                  pos++;length = pos;
                  continue;
                }
              }
              in.incrLineNumber(1, pos);
            }
            else
            {
              out.linefeedFromParser();
              state = 28;
              break label3487;
            }
          }
          else if ((ch == '') || (ch == ' '))
          {
            length = pos - length;
            in.pos = (pos - 1);
            if (length > 0)
              out.textFromParser(buffer, start, length);
            out.linefeedFromParser();
            in.incrLineNumber(1, pos);
            length = pos + 1;
            start = pos;
          }
          else if (ch == '\n')
          {
            in.incrLineNumber(1, pos);
          }
          if (pos == limit)
          {
            length--;
            break;
          }
          ch = buffer[(pos++)];
        }
        length = pos - length;
        if (length > 0)
        {
          in.pos = pos;
          out.textFromParser(buffer, start, length);
        }
        start = -1;
        break;
      


      case 28: 
        state = 1;
        if ((ch == '\n') || (ch == ''))
        {
          in.incrLineNumber(1, pos);

        }
        else
        {
          in.incrLineNumber(1, pos - 1); }
        break;
      


      case 12: 
      case 15: 
      case 23: 
      case 29: 
      case 32: 
        if ((ch != ' ') && (ch != '\t'))
        {
          if ((ch == '\n') || (ch == '\r') || (ch == '') || (ch == ' '))
          {

            in.incrLineNumber(1, pos);
          }
          else
          {
            state -= 2; } }
        break;
      
      case 3: 
      case 5: 
      case 7: 
      case 9: 
      case 17: 
      case 24: 
      case 33: 
        length = start + 1;
        









        for (;;)
        {
          if (((ch < 'a') || (ch > 'z')) && ((ch < 'A') || (ch > 'Z')) && (ch != '_') && (ch != ':') && ((ch < 'À') || ((ch > '˿') && ((ch < 'Ͱ') || (((ch > '῿') || (ch == ';')) && ((ch < '‌') || ((ch > '‍') && ((ch < '⁰') || (ch > '↏')) && ((ch < 'Ⰰ') || (ch > '⿯')) && ((ch < '、') || (ch > 55295)) && ((ch < 63744) || (ch > 65533)))))))) && ((pos <= length) || (ch < '0') || (ch > '9')) && (ch != '.') && (ch != '-') && (ch != '·') && ((ch <= '̀') || ((ch > 'ͯ') && ((ch < '‿') || (ch > '⁀')))))
          {




















            state--;
            length = pos - length;
            if (length != 0)
              break;
            if (state == 8) {
              message = "missing or invalid attribute name";
            } else if ((state == 2) || (state == 4))
            {
              message = "missing or invalid element name";
            } else
              message = "missing or invalid name";
            state = 36; break;
          }
          

          if (pos >= limit) break label3487;
          ch = buffer[(pos++)];
        }
      

      case 26: 
        for (;;)
        {
          if (ch == ';')
          {
            in.pos = pos;
            out.emitCharacterReference(length, buffer, start, pos - 1 - start);
            
            state = 1;
            break label3487;
          }
          if ((ch == 'x') && (dstart == 0)) {
            dstart = 16;
          } else { if (length >= 134217728) {
              break;
            }
            
            int base = dstart == 0 ? 10 : dstart;
            int digit = Character.digit(ch, base);
            if (digit < 0)
              break;
            length = length * base + digit;
          }
          if (pos >= limit) break label3487;
          ch = buffer[(pos++)];
        }
        

        in.pos = pos;
        out.error('e', "invalid character reference");
        state = 1;
        break;
      
      case 25: 
        if (ch == '#')
        {
          state = 26;
          start = pos;
          length = 0;
          dstart = 0;
        }
        else {
          start = pos - 1;
          state = 7; }
        break;
      
      case 6: 
        in.pos = pos;
        if (ch != ';')
          out.error('w', "missing ';'");
        out.emitEntityReference(buffer, start, length);
        start = -1;
        state = 1;
        break;
      
      case 14: 
        if (ch == '/')
        {
          state = 19;

        }
        else if (ch == '?')
        {
          start = pos;
          state = 24;

        }
        else if (ch == '!')
        {
          state = 20;
          start = pos;
        }
        else
        {
          start = pos - 1;
          state = 3; }
        break;
      case 2: 
        in.pos = (pos - length);
        out.emitStartElement(buffer, start, length);
        state = 12;
        start = -1;
        break;
      
      case 21: 
      case 30: 
        if (dstart < 0) {
          dstart = pos - 1;
        }
        for (;;) {
          int end;
          if ((ch == '>') && (buffer[(end = pos - 2)] == '?') && (end >= dstart))
          {


            in.pos = pos;
            if ((length == 3) && (buffer[start] == 'x') && (buffer[(start + 1)] == 'm') && (buffer[(start + 2)] == 'l'))
            {



              if (state == 30)
              {
                if ((end <= dstart + 7) || (buffer[dstart] != 'v') || (buffer[(dstart + 1)] != 'e') || (buffer[(dstart + 2)] != 'r') || (buffer[(dstart + 3)] != 's') || (buffer[(dstart + 4)] != 'i') || (buffer[(dstart + 5)] != 'o') || (buffer[(dstart + 6)] != 'n'))
                {








                  pos = dstart;
                  message = "xml declaration without version";
                  state = 36;
                  break;
                }
                dstart += 7;
                ch = buffer[dstart];
                
                while (Character.isWhitespace(ch)) { dstart++; if (dstart >= end) break;
                  ch = buffer[dstart]; }
                if (ch != '=')
                {
                  state = 35;
                  break;
                }
                ch = buffer[(++dstart)];
                
                while (Character.isWhitespace(ch)) { dstart++; if (dstart >= end) break;
                  ch = buffer[dstart]; }
                if ((ch != '\'') && (ch != '"'))
                {
                  state = 35;
                  break;
                }
                char quote = ch;
                dstart++;int i = dstart;
                for (;; i++)
                {
                  if (i == end)
                  {
                    state = 35;
                    break;
                  }
                  ch = buffer[i];
                  if (ch == quote)
                    break label1724;
                }
                if (((i != dstart + 3) || (buffer[dstart] != '1') || (buffer[(dstart + 1)] != '.') || ((ch = buffer[(dstart + 2)]) != '0')) && (ch != '1'))
                {






                  state = 35;
                  break;
                }
                dstart = i + 1;
                
                while ((dstart < end) && (Character.isWhitespace(buffer[dstart])))
                  dstart++;
                if ((end > dstart + 7) && (buffer[dstart] == 'e') && (buffer[(dstart + 1)] == 'n') && (buffer[(dstart + 2)] == 'c') && (buffer[(dstart + 3)] == 'o') && (buffer[(dstart + 4)] == 'd') && (buffer[(dstart + 5)] == 'i') && (buffer[(dstart + 6)] == 'n') && (buffer[(dstart + 7)] == 'g'))
                {








                  dstart += 8;
                  ch = buffer[dstart];
                  
                  while (Character.isWhitespace(ch)) { dstart++; if (dstart >= end) break;
                    ch = buffer[dstart]; }
                  if (ch != '=')
                  {
                    message = "bad 'encoding' declaration";
                    state = 36;
                    break;
                  }
                  ch = buffer[(++dstart)];
                  
                  while (Character.isWhitespace(ch)) { dstart++; if (dstart >= end) break;
                    ch = buffer[dstart]; }
                  if ((ch != '\'') && (ch != '"'))
                  {
                    message = "bad 'encoding' declaration";
                    state = 36;
                    break;
                  }
                  quote = ch;
                  dstart++;i = dstart;
                  for (;; i++)
                  {
                    if (i == end)
                    {
                      message = "bad 'encoding' declaration";
                      state = 36;
                      break;
                    }
                    ch = buffer[i];
                    if (ch == quote)
                      break label2077;
                  }
                  String encoding = new String(buffer, dstart, i - dstart);
                  if ((in instanceof BinaryInPort))
                    ((BinaryInPort)in).setCharset(encoding);
                  dstart = i + 1;
                  
                  while ((dstart < end) && (Character.isWhitespace(buffer[dstart])))
                    dstart++;
                }
                if ((end > dstart + 9) && (buffer[dstart] == 's') && (buffer[(dstart + 1)] == 't') && (buffer[(dstart + 2)] == 'a') && (buffer[(dstart + 3)] == 'n') && (buffer[(dstart + 4)] == 'd') && (buffer[(dstart + 5)] == 'a') && (buffer[(dstart + 6)] == 'l') && (buffer[(dstart + 7)] == 'o') && (buffer[(dstart + 8)] == 'n') && (buffer[(dstart + 9)] == 'e'))
                {










                  dstart += 10;
                  ch = buffer[dstart];
                  
                  while (Character.isWhitespace(ch)) { dstart++; if (dstart >= end) break;
                    ch = buffer[dstart]; }
                  if (ch != '=')
                  {
                    message = "bad 'standalone' declaration";
                    state = 36;
                    break;
                  }
                  ch = buffer[(++dstart)];
                  
                  while (Character.isWhitespace(ch)) { dstart++; if (dstart >= end) break;
                    ch = buffer[dstart]; }
                  if ((ch != '\'') && (ch != '"'))
                  {
                    message = "bad 'standalone' declaration";
                    state = 36;
                    break;
                  }
                  quote = ch;
                  dstart++;i = dstart;
                  for (;; i++)
                  {
                    if (i == end)
                    {
                      message = "bad 'standalone' declaration";
                      state = 36;
                      break;
                    }
                    ch = buffer[i];
                    if (ch == quote)
                      break label2427;
                  }
                  if ((i != dstart + 3) || (buffer[dstart] != 'y') || (buffer[(dstart + 1)] != 'e') || (buffer[(dstart + 2)] != 's'))
                  {




                    if ((i != dstart + 2) || (buffer[dstart] != 'n') || (buffer[(dstart + 1)] != 'o'))
                    {





                      message = "bad 'standalone' declaration";
                      state = 36;
                      break;
                    } }
                  dstart = i + 1;
                  
                  while ((dstart < end) && (Character.isWhitespace(buffer[dstart])))
                    dstart++;
                }
                if (end != dstart)
                {
                  message = "junk at end of xml declaration";
                  pos = dstart;
                  state = 36;
                  break;
                }
                
                break label2612;
              }
              message = "<?xml must be at start of file";
              state = 36;
              break;
            }
            
            if ((strict) && (state == 30))
            {
              state = 38;
              break;
            }
            
            out.processingInstructionFromParser(buffer, start, length, dstart, end - dstart);
            
            start = -1;
            dstart = -1;
            state = 1;
            break label3487;
          }
          if (pos >= limit) break label3487;
          ch = buffer[(pos++)];
        }
      



      case 20: 
        for (;;)
        {
          if (ch == '>')
          {
            length = pos - 1 - start;
            if ((length >= 4) && (buffer[start] == '-') && (buffer[(start + 1)] == '-'))
            {


              if ((buffer[(pos - 2)] == '-') && (buffer[(pos - 3)] == '-'))
              {

                in.pos = pos;
                out.commentFromParser(buffer, start + 2, length - 4);
                start = -1;
                break;
              }
            } else {
              if ((length < 6) || (buffer[start] != '[') || (buffer[(start + 1)] != 'C') || (buffer[(start + 2)] != 'D') || (buffer[(start + 3)] != 'A') || (buffer[(start + 4)] != 'T') || (buffer[(start + 5)] != 'A') || (buffer[(start + 6)] != '[')) {
                break;
              }
              





              if ((buffer[(pos - 2)] == ']') && (buffer[(pos - 3)] == ']'))
              {

                in.pos = pos;
                out.writeCDATA(buffer, start + 7, pos - 10 - start);
                start = -1;
                break;

              }
              

            }
            

          }
          else if ((pos == start + 7) && (buffer[start] == 'D') && (buffer[(start + 1)] == 'O') && (buffer[(start + 2)] == 'C') && (buffer[(start + 3)] == 'T') && (buffer[(start + 4)] == 'Y') && (buffer[(start + 5)] == 'P') && (ch == 'E'))
          {







            start = -1;
            state = 15;
            break label3487;
          }
          if (pos >= limit) break label3487;
          ch = buffer[(pos++)];
        }
        

        start = -1;
        state = 1;
        break;
      
      case 13: 
        state = 17;
        start = pos - 1;
        break;
      
      case 16: 
        if (dstart < 0)
        {

          dstart = pos - 1;
          dstart -= start;
          dstart <<= 1;
          terminator = '\000';
        }
        for (;;)
        {
          if ((ch == '\'') || (ch == '"'))
          {
            if (terminator == 0) {
              terminator = ch;
            } else if (terminator == ch) {
              terminator = '\000';
            }
          } else if (terminator == 0)
          {

            if (ch == '[') {
              dstart |= 0x1;
            } else if (ch == ']') {
              dstart &= 0xFFFFFFFE;
            } else if ((ch == '>') && ((dstart & 0x1) == 0))
            {
              in.pos = pos;
              dstart >>= 1;
              dstart += start;
              out.emitDoctypeDecl(buffer, start, length, dstart, pos - 1 - dstart);
              
              terminator = '<';
              start = -1;
              dstart = -1;
              state = 1;
              break;
            }
          }
          if (pos >= limit) break;
          ch = buffer[(pos++)];
        }
      


      case 10: 
        terminator = '<';
        continue_state = 14;
        if (ch == '/')
        {
          in.pos = pos;
          out.emitEndAttributes();
          out.emitEndElement(null, 0, 0);
          state = 27;

        }
        else if (ch == '>')
        {
          in.pos = pos;
          out.emitEndAttributes();
          state = 1;
        }
        else {
          start = pos - 1;
          state = 9; }
        break;
      case 8: 
        if ((ch != ' ') && (ch != '\t') && (ch != '\r') && (ch != '\n') && (ch != '') && (ch != ' '))
        {

          in.pos = (pos - length);
          out.emitStartAttribute(buffer, start, length);
          start = -1;
          if (ch == '=')
          {
            state = 11;
          }
          else {
            out.emitEndAttributes();
            message = "missing or misplaced '=' after attribute name";
            state = 36; } }
        break;
      case 11: 
        if ((ch == '\'') || (ch == '"'))
        {
          terminator = ch;
          continue_state = 12;
          state = 1;

        }
        else if ((ch != ' ') && (ch != '\t') && (ch != '\r') && (ch != '\n') && (ch != '') && (ch != ' '))
        {

          out.emitEndAttributes();
          message = "missing or unquoted attribute value";
          state = 36; }
        break;
      

      case 19: 
        start = pos - 1;
        state = 5;
        break;
      
      case 4: 
        in.pos = pos;
        out.emitEndElement(buffer, start, length);
        start = -1;
        
        state = 29;
        break;
      
      case 27: 
        if (ch != '>')
        {
          message = "missing '>'";
          state = 36;
        }
        else {
          state = 1; }
        break; case 18: case 22: default:  label1724:
        label2077:
        label2427:
        label2612:
        label3487: if (pos >= limit)
        {
          int saved = pos - start;
          try
          {
            if (start >= 0)
            {
              in.setSaveStart(start);
            }
            in.pos = pos;
            int x = in.peek();
            if (x < 0)
            {
              if ((state == 1) || (state == 28))
                return;
              state = 37;
              continue;
            }
            if (start >= 0)
            {
              in.setSaveStart(-1);
            }
          }
          catch (IOException ex)
          {
            throw new RuntimeException(ex.getMessage());
          }
          pos = in.pos;
          buffer = in.buffer;
          
          limit = in.limit;
          start = start >= 0 ? pos - saved : limit;
        } else {
          ch = buffer[(pos++)];
        }
        break;
      }
    }
  }
}
