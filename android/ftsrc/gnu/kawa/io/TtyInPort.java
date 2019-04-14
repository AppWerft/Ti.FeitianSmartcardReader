package gnu.kawa.io;

import gnu.mapping.Procedure;
import java.io.IOException;

public class TtyInPort extends InPort
{
  protected OutPort tie;
  protected Procedure prompter;
  boolean inDomTerm;
  public Runnable sigIntHandler;
  
  public void setInDomTerm(boolean v)
  {
    inDomTerm = v;
  }
  


  public Procedure getPrompter()
  {
    return prompter;
  }
  




  public void setPrompter(Procedure prompter)
  {
    this.prompter = prompter;
  }
  

  int prompt1Length = 0;
  protected boolean promptEmitted;
  
  public String promptTemplate1() { String str = (String)CheckConsole.prompt1.get("");
    if ((inDomTerm) && (!haveDomTermEscapes(str)))
      str = "%{\033[19u\033[16u%}▼%{\033[17u\033[14u%}" + str + "%{\033[15u%}";
    return str;
  }
  
  public String promptTemplate2() {
    String str = (String)CheckConsole.prompt2.get("");
    if ((inDomTerm) && (!haveDomTermEscapes(str)))
      str = "%{\033[24u%}" + str + "%{\033[18u\033[15u%}";
    return str;
  }
  
  public String defaultPrompt()
  {
    if (readState == '\n')
      return "";
    int line = getLineNumber() + 1;
    if (readState == ' ') {
      String pattern = promptTemplate1();
      int[] width = new int[1];
      String str = expandPrompt(pattern, 0, line, "", width);
      prompt1Length = width[0];
      return str;
    }
    String pattern = promptTemplate2();
    String m = new String(new char[] { readState });
    return expandPrompt(pattern, prompt1Length, line, m, null);
  }
  


  public String expandPrompt(String pattern, int padToWidth, int line, String message, int[] width)
  {
    StringBuilder sb = new StringBuilder();
    int plen = pattern.length();
    int cols = 0;
    int padChar = -1;
    int padPos = -1;
    int escapeStartCol = -1;
    for (int i = 0; i < plen;) {
      char ch = pattern.charAt(i++);
      if ((ch == '%') && (i < plen)) {
        ch = pattern.charAt(i++);
        int count = -1;
        while ((ch >= '0') && (ch <= '9')) {
          count = (count < 0 ? 0 : 10 * count) + (ch - '0');
          
          ch = pattern.charAt(i++);
        }
        switch (ch) {
        case '%': 
          sb.append(ch);
          cols++;
          break;
        case 'N': 
          int oldw = sb.length();
          sb.append(line);
          cols += sb.length() - oldw;
          break;
        case 'M': 
          if (message != null) {
            sb.append(message);
            cols += message.length();
          }
          break;
        case 'P': 
          if (count >= 0)
            padToWidth = count;
          if (i < plen) {
            padChar = pattern.charAt(i++);
          }
          
          padPos = sb.length();
          break;
        case '{': 
          escapeStartCol = cols;
          break;
        case '}': 
          cols = escapeStartCol;
          escapeStartCol = -1;
          break;
        default: 
          i--;
        }
      } else {
        cols++;
        if (Character.isLowSurrogate(ch))
          cols--;
        sb.append(ch);
      }
    }
    String str = sb.toString();
    if (padToWidth > cols) {
      int padCharCols = 1;
      int padCount = (padToWidth - cols) / padCharCols;
      cols += padCount;
      for (;;) { padCount--; if (padCount < 0) break;
        sb.insert(padPos, (char)padChar); }
      str = sb.toString();
    }
    if (width != null)
      width[0] = cols;
    return str;
  }
  
  public TtyInPort(java.io.InputStream in, Path name, OutPort tie)
  {
    super(in, name);
    setConvertCR(true);
    this.tie = tie;
  }
  
  public TtyInPort(java.io.Reader in, Path name, OutPort tie)
  {
    super(in, name);
    setConvertCR(true);
    this.tie = tie;
  }
  


  protected int fill(int len)
    throws IOException
  {
    int count = in.read(buffer, pos, len);
    if ((tie != null) && (count > 0))
      tie.echo(buffer, pos, count);
    return count;
  }
  
  protected void afterFill(int count) throws IOException {
    if ((tie != null) && (count > 0))
      tie.echo(buffer, pos, count);
  }
  
  public void emitPrompt(String prompt) throws IOException {
    tie.print(prompt);
    tie.flush();
    tie.clearBuffer();
  }
  
  public String wrapPromptForAnsi(String prompt) {
    return "\033[38;5;120m" + prompt + "\033[39m";
  }
  
  public static boolean haveDomTermEscapes(String prompt)
  {
    int i = prompt.length(); do { i--; if (i < 4) break;
    } while ((prompt.charAt(i) != 'u') || (prompt.charAt(i - 4) != '\033') || (prompt.charAt(i - 3) != '['));
    
    return true;
    
    return false;
  }
  
  public void lineStart(boolean revisited) throws IOException {
    if (!revisited) {
      promptEmitted = false;
      if (prompter != null) {
        try {
          Object prompt = readState == ' ' ? prompter.apply1(this) : readState == '\n' ? null : defaultPrompt();
          

          if (prompt != null) {
            String string = prompt.toString();
            if ((string != null) && (string.length() > 0)) {
              if (tie != null)
                tie.freshLine();
              emitPrompt(string);
              promptEmitted = true;
            }
          }
        } catch (Throwable ex) {
          throw new IOException("Error when evaluating prompt:" + ex);
        }
      }
      
      if ((tie != null) && (!promptEmitted)) {
        tie.flush();
        tie.clearBuffer();
      }
    }
  }
  
  public int read() throws IOException
  {
    if (tie != null)
      tie.flush();
    int ch = super.read();
    if (ch < 0)
    {
      if ((promptEmitted & tie != null))
        tie.println();
    }
    promptEmitted = false;
    return ch;
  }
  
  public int read(char[] cbuf, int off, int len) throws IOException
  {
    if (tie != null)
      tie.flush();
    int count = super.read(cbuf, off, len);
    if (count < 0) if ((promptEmitted & tie != null))
        tie.println();
    promptEmitted = false;
    return count;
  }
  
  public static TtyInPort make(java.io.InputStream in, Path name, OutPort tie) {
    if (CheckConsole.useJLine() >= 0) {
      try {
        return (TtyInPort)Class.forName("gnu.kawa.io.JLineInPort").getConstructor(new Class[] { java.io.InputStream.class, Path.class, OutPort.class }).newInstance(new Object[] { in, name, tie });
      }
      catch (Throwable ex) {}
    }
    





    return new TtyInPort(in, name, tie);
  }
}
