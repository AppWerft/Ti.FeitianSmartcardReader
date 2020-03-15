// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.models;

import gnu.lists.CharBuffer;
import java.io.Serializable;

public class Text extends Model implements Viewable, Serializable
{
    public final CharBuffer buffer;
    
    public Text() {
        this("");
    }
    
    public Text(final String text) {
        (this.buffer = new CharBuffer(100)).append('\n');
        this.setText(text);
    }
    
    @Override
    public void makeView(final Display display, final Object where) {
        display.addText(this, where);
    }
    
    public String getText() {
        final int len = this.buffer.size() - 1;
        final int start = this.buffer.getSegment(0, len);
        return new String(this.buffer.getArray(), start, len);
    }
    
    public void setText(final String text) {
        final int size = this.buffer.size() - 1;
        if (size > 0) {
            this.buffer.delete(0, size);
        }
        this.buffer.insert(0, text, false);
        this.notifyListeners("text");
    }
    
    public CharBuffer getBuffer() {
        return this.buffer;
    }
}
