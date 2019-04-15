/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.models;

import gnu.kawa.models.Display;
import gnu.kawa.models.Model;
import gnu.kawa.models.Viewable;
import gnu.lists.CharBuffer;
import gnu.lists.FString;
import java.io.Serializable;

public class Text
extends Model
implements Viewable,
Serializable {
    public final CharBuffer buffer = new CharBuffer(100);

    public Text() {
        this("");
    }

    public Text(String text) {
        this.buffer.append('\n');
        this.setText(text);
    }

    @Override
    public void makeView(Display display, Object where) {
        display.addText(this, where);
    }

    public String getText() {
        int len = this.buffer.size() - 1;
        int start = this.buffer.getSegment(0, len);
        return new String(this.buffer.getArray(), start, len);
    }

    public void setText(String text) {
        int size = this.buffer.size() - 1;
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

