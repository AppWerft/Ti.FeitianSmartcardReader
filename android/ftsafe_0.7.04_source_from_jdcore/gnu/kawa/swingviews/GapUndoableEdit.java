package gnu.kawa.swingviews;

import javax.swing.text.BadLocationException;
import javax.swing.undo.AbstractUndoableEdit;
import javax.swing.undo.CannotRedoException;
import javax.swing.undo.CannotUndoException;





















































































































class GapUndoableEdit
  extends AbstractUndoableEdit
{
  boolean isInsertion;
  SwingContent content;
  String data;
  int startOffset;
  int nitems;
  
  GapUndoableEdit(int offset)
  {
    startOffset = offset;
  }
  

  private void doit(boolean isInsertion)
    throws BadLocationException
  {
    if (isInsertion)
    {

      content.insertString(startOffset, data);

    }
    else
    {
      content.remove(startOffset, nitems);
    }
  }
  
  public void undo() throws CannotUndoException
  {
    super.undo();
    try
    {
      doit(!isInsertion);
    }
    catch (BadLocationException ex)
    {
      throw new CannotUndoException();
    }
  }
  
  public void redo() throws CannotUndoException
  {
    super.redo();
    try
    {
      doit(isInsertion);
    }
    catch (BadLocationException ex)
    {
      throw new CannotRedoException();
    }
  }
}
