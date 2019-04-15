/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.swingviews;

import gnu.kawa.swingviews.SwingContent;
import javax.swing.text.BadLocationException;
import javax.swing.undo.AbstractUndoableEdit;
import javax.swing.undo.CannotRedoException;
import javax.swing.undo.CannotUndoException;
import javax.swing.undo.UndoableEdit;

class GapUndoableEdit
extends AbstractUndoableEdit {
    boolean isInsertion;
    SwingContent content;
    String data;
    int startOffset;
    int nitems;

    GapUndoableEdit(int offset) {
        this.startOffset = offset;
    }

    private void doit(boolean isInsertion) throws BadLocationException {
        if (isInsertion) {
            this.content.insertString(this.startOffset, this.data);
        } else {
            this.content.remove(this.startOffset, this.nitems);
        }
    }

    @Override
    public void undo() throws CannotUndoException {
        super.undo();
        try {
            this.doit(!this.isInsertion);
        }
        catch (BadLocationException ex) {
            throw new CannotUndoException();
        }
    }

    @Override
    public void redo() throws CannotUndoException {
        super.redo();
        try {
            this.doit(this.isInsertion);
        }
        catch (BadLocationException ex) {
            throw new CannotRedoException();
        }
    }
}

