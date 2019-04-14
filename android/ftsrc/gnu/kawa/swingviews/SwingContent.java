package gnu.kawa.swingviews;

import gnu.lists.CharBuffer;
import javax.swing.text.AbstractDocument.Content;
import javax.swing.text.BadLocationException;
import javax.swing.text.Position;
import javax.swing.text.Segment;
import javax.swing.undo.UndoableEdit;

public class SwingContent implements AbstractDocument.Content
{
  public final CharBuffer buffer;
  
  public SwingContent(CharBuffer buffer)
  {
    this.buffer = buffer;
  }
  
  public SwingContent(int initialSize)
  {
    CharBuffer b = new CharBuffer(initialSize);
    

    b.append('\n');
    buffer = b;
  }
  
  public SwingContent()
  {
    this(100);
  }
  
  public int length() { return buffer.length(); }
  
  public void getChars(int where, int len, Segment txt)
    throws BadLocationException
  {
    CharBuffer b = buffer;
    int start = b.getSegment(where, len);
    if (start < 0)
      throw new BadLocationException("invalid offset", where);
    offset = start;
    array = b.getArray();
    count = len;
  }
  
  public String getString(int where, int len)
    throws BadLocationException
  {
    CharBuffer b = buffer;
    int start = b.getSegment(where, len);
    if (start < 0)
      throw new BadLocationException("invalid offset", where);
    return new String(b.getArray(), start, len);
  }
  
  public UndoableEdit remove(int where, int nitems)
    throws BadLocationException
  {
    CharBuffer b = buffer;
    int end = where + nitems;
    if ((nitems < 0) || (where < 0) || (end > b.length())) {
      throw new BadLocationException("invalid remove", where);
    }
    GapUndoableEdit undo = new GapUndoableEdit(where);
    content = this;
    data = b.substring(where, end);
    nitems = nitems;
    isInsertion = false;
    b.delete(where, end);
    return undo;
  }
  

  public UndoableEdit insertString(int where, String str, boolean beforeMarkers)
    throws BadLocationException
  {
    CharBuffer b = buffer;
    if ((where < 0) || (where > b.length()))
      throw new BadLocationException("bad insert", where);
    b.insert(where, str, beforeMarkers);
    
    GapUndoableEdit undo = new GapUndoableEdit(where);
    content = this;
    data = str;
    nitems = str.length();
    isInsertion = true;
    return undo;
  }
  
  public UndoableEdit insertString(int where, String str)
    throws BadLocationException
  {
    return insertString(where, str, false);
  }
  
  public Position createPosition(int offset)
    throws BadLocationException
  {
    CharBuffer b = buffer;
    if ((offset < 0) || (offset > b.length()))
      throw new BadLocationException("bad offset to createPosition", offset);
    return new GapPosition(b, offset);
  }
}
