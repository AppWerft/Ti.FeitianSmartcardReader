/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.swingviews;

import gnu.lists.CharBuffer;
import gnu.lists.SeqPosition;
import javax.swing.text.Position;

class GapPosition
extends SeqPosition
implements Position {
    public GapPosition(CharBuffer content, int offset) {
        super(content, offset, offset != 0);
    }

    @Override
    public int getOffset() {
        return this.nextIndex();
    }
}

