// 
// Decompiled by Procyon v0.5.36
// 

package gnu.lists;

public class ExtPosition<E, ESEQ extends AbstractSequence<E>> extends SeqPosition<E, ESEQ>
{
    int position;
    
    public ExtPosition() {
        this.position = -1;
    }
    
    @Override
    public int getPos() {
        if (this.position < 0) {
            this.position = PositionManager.manager.register(this);
        }
        return this.position;
    }
    
    @Override
    public void setPos(final AbstractSequence seq, final int ipos) {
        throw seq.unsupported("setPos");
    }
    
    @Override
    public final boolean isAfter() {
        return (this.ipos & 0x1) != 0x0;
    }
    
    @Override
    public void release() {
        if (this.position >= 0) {
            PositionManager.manager.release(this.position);
        }
        this.sequence = null;
    }
}
