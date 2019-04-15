/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.swingviews;

import gnu.kawa.swingviews.GapPosition;
import gnu.kawa.swingviews.GapUndoableEdit;
import gnu.lists.CharBuffer;
import gnu.lists.FString;
import javax.swing.text.AbstractDocument;
import javax.swing.text.BadLocationException;
import javax.swing.text.Position;
import javax.swing.text.Segment;
import javax.swing.undo.UndoableEdit;

public class SwingContent
implements AbstractDocument.Content {
    public final CharBuffer buffer;

    public SwingContent(CharBuffer buffer) {
        this.buffer = buffer;
    }

    public SwingContent(int initialSize) {
        CharBuffer b = new CharBuffer(initialSize);
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
    public void getChars(int where, int len, Segment txt) throws BadLocationException {
        CharBuffer b = this.buffer;
        int start = b.getSegment(where, len);
        if (start < 0) {
            throw new BadLocationException("invalid offset", where);
        }
        txt.offset = start;
        txt.array = b.getArray();
        txt.count = len;
    }

    @Override
    public String getString(int where, int len) throws BadLocationException {
        CharBuffer b = this.buffer;
        int start = b.getSegment(where, len);
        if (start < 0) {
            throw new BadLocationException("invalid offset", where);
        }
        return new String(b.getArray(), start, len);
    }

    @Override
    public UndoableEdit remove(int where, int nitems) throws BadLocationException {
        CharBuffer b = this.buffer;
        int end = where + nitems;
        if (nitems < 0 || where < 0 || end > b.length()) {
            throw new BadLocationException("invalid remove", where);
        }
        GapUndoableEdit undo = new GapUndoableEdit(where);
        undo.content = this;
        undo.data = b.substring(where, end);
        undo.nitems = nitems;
        undo.isInsertion = false;
        b.delete(where, end);
        return undo;
    }

    public UndoableEdit insertString(int where, String str, boolean beforeMarkers) throws BadLocationException {
        CharBuffer b = this.buffer;
        if (where < 0 || where > b.length()) {
            throw new BadLocationException("bad insert", where);
        }
        b.insert(where, str, beforeMarkers);
        GapUndoableEdit undo = new GapUndoableEdit(where);
        undo.content = this;
        undo.data = str;
        undo.nitems = str.length();
        undo.isInsertion = true;
        return undo;
    }

    @Override
    public UndoableEdit insertString(int where, String str) throws BadLocationException {
        return this.insertString(where, str, false);
    }

    @Override
    public Position createPosition(int offset) throws BadLocationException {
        CharBuffer b = this.buffer;
        if (offset < 0 || offset > b.length()) {
            throw new BadLocationException("bad offset to createPosition", offset);
        }
        return new GapPosition(b, offset);
    }
}

