package gnu.kawa.models;

import gnu.lists.CharBuffer;
import java.io.Serializable;





public class Text
  extends Model
  implements Viewable, Serializable
{
  public final CharBuffer buffer = new CharBuffer(100);
  
  public Text()
  {
    this("");
  }
  
  public Text(String text)
  {
    buffer.append('\n');
    setText(text);
  }
  
  public void makeView(Display display, Object where)
  {
    display.addText(this, where);
  }
  
  public String getText()
  {
    int len = buffer.size() - 1;
    int start = buffer.getSegment(0, len);
    return new String(buffer.getArray(), start, len);
  }
  
  public void setText(String text)
  {
    int size = buffer.size() - 1;
    if (size > 0)
      buffer.delete(0, size);
    buffer.insert(0, text, false);
    notifyListeners("text");
  }
  
  public CharBuffer getBuffer()
  {
    return buffer;
  }
}
