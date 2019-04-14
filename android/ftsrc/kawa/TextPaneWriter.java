package kawa;

import java.io.Writer;
import javax.swing.text.AttributeSet;





































































































class TextPaneWriter
  extends Writer
{
  ReplDocument document;
  AttributeSet style;
  String str = "";
  
  public TextPaneWriter(ReplDocument document, AttributeSet style)
  {
    this.document = document;
    this.style = style;
  }
  
  public synchronized void write(int x)
  {
    str += (char)x;
    if (x == 10) {
      flush();
    }
  }
  
  public void write(String str) {
    document.write(str, style);
  }
  
  public synchronized void write(char[] data, int off, int len)
  {
    flush();
    if (len != 0) {
      write(new String(data, off, len));
    }
  }
  
  public synchronized void flush() {
    String s = str;
    if (!s.equals(""))
    {
      str = "";
      write(s);
    }
  }
  
  public void close()
  {
    flush();
  }
}
