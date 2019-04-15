package gnu.text;

import java.io.PrintWriter;











public class SyntaxException
  extends RuntimeException
{
  String header;
  SourceMessages messages;
  
  public SyntaxException(SourceMessages messages)
  {
    this.messages = messages;
  }
  
  public SyntaxException(String header, SourceMessages messages)
  {
    this.header = header;
    this.messages = messages;
  }
  
  public final String getHeader()
  {
    return header;
  }
  
  public final void setHeader(String header) { this.header = header; }
  
  public SourceMessages getMessages() { return messages; }
  
  public void printAll(PrintWriter out, int max)
  {
    if (header != null)
      out.println(header);
    messages.printAll(out, max);
  }
  
  public void clear()
  {
    messages.clear();
  }
  
  public int maxToPrint = 10;
  
  public String getMessage() {
    StringBuilder buffer = new StringBuilder();
    if (header != null)
      buffer.append(header);
    messages.printAll(buffer, maxToPrint);
    return buffer.toString().replace("\r\n", "\n");
  }
}
