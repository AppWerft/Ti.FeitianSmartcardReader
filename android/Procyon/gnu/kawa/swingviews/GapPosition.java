// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.swingviews;

import gnu.lists.CharBuffer;
import javax.swing.text.Position;
import gnu.lists.SeqPosition;

class GapPosition extends SeqPosition implements Position
{
    public GapPosition(final CharBuffer content, final int offset) {
        super(content, offset, offset != 0);
    }
    
    @Override
    public int getOffset() {
        return this.nextIndex();
    }
}
