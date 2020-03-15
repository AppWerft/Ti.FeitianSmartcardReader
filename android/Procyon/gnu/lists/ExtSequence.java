// 
// Decompiled by Procyon v0.5.36
// 

package gnu.lists;

public abstract class ExtSequence<E> extends AbstractSequence<E>
{
    @Override
    public int copyPos(final int ipos) {
        if (ipos <= 0) {
            return ipos;
        }
        return PositionManager.manager.register(PositionManager.getPositionObject(ipos).copy());
    }
    
    @Override
    protected void releasePos(final int ipos) {
        if (ipos > 0) {
            PositionManager.manager.release(ipos);
        }
    }
    
    @Override
    protected boolean isAfterPos(final int ipos) {
        if (ipos <= 0) {
            return ipos < 0;
        }
        return (PositionManager.getPositionObject(ipos).ipos & 0x1) != 0x0;
    }
    
    @Override
    protected int nextIndex(final int ipos) {
        return (ipos == -1) ? this.size() : ((ipos == 0) ? 0 : PositionManager.getPositionObject(ipos).nextIndex());
    }
}
