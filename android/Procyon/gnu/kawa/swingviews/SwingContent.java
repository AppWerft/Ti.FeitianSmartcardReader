// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.swingviews;

import javax.swing.text.Position;
import javax.swing.undo.UndoableEdit;
import javax.swing.text.BadLocationException;
import javax.swing.text.Segment;
import gnu.lists.CharBuffer;
import javax.swing.text.AbstractDocument;

public class SwingContent implements AbstractDocument.Content
{
    public final CharBuffer buffer;
    
    public SwingContent(final CharBuffer buffer) {
        this.buffer = buffer;
    }
    
    public SwingContent(final int initialSize) {
        final CharBuffer b = new CharBuffer(initialSize);
        b.append('\n');
        this.buffer = b;
    }
    
    public SwingContent() {
        this(100);
    }
    
    @Override
    public int length() {
        return this.buffer.length();
    }
    
    @Override
    public void getChars(final int where, final int len, final Segment txt) throws BadLocationException {
        final CharBuffer b = this.buffer;
        final int start = b.getSegment(where, len);
        if (start < 0) {
            throw new BadLocationException("invalid offset", where);
        }
        txt.offset = start;
        txt.array = b.getArray();
        txt.count = len;
    }
    
    @Override
    public String getString(final int where, final int len) throws BadLocationException {
        final CharBuffer b = this.buffer;
        final int start = b.getSegment(where, len);
        if (start < 0) {
            throw new BadLocationException("invalid offset", where);
        }
        return new String(b.getArray(), start, len);
    }
    
    @Override
    public UndoableEdit remove(final int where, final int nitems) throws BadLocationException {
        final CharBuffer b = this.buffer;
        final int end = where + nitems;
        if (nitems < 0 || where < 0 || end > b.length()) {
            throw new BadLocationException("invalid remove", where);
        }
        final GapUndoableEdit undo = new GapUndoableEdit(where);
        undo.content = this;
        undo.data = b.substring(where, end);
        undo.nitems = nitems;
        undo.isInsertion = false;
        b.delete(where, end);
        return undo;
    }
    
    public UndoableEdit insertString(final int where, final String str, final boolean beforeMarkers) throws BadLocationException {
        final CharBuffer b = this.buffer;
        if (where < 0 || where > b.length()) {
            throw new BadLocationException("bad insert", where);
        }
        b.insert(where, str, beforeMarkers);
        final GapUndoableEdit undo = new GapUndoableEdit(where);
        undo.content = this;
        undo.data = str;
        undo.nitems = str.length();
        undo.isInsertion = true;
        return undo;
    }
    
    @Override
    public UndoableEdit insertString(final int where, final String str) throws BadLocationException {
        return this.insertString(where, str, false);
    }
    
    @Override
    public Position createPosition(final int offset) throws BadLocationException {
        final CharBuffer b = this.buffer;
        if (offset < 0 || offset > b.length()) {
            throw new BadLocationException("bad offset to createPosition", offset);
        }
        return new GapPosition(b, offset);
    }
}
