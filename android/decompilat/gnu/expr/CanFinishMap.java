// 
// Decompiled by Procyon v0.5.36
// 

package gnu.expr;

import java.util.Iterator;
import gnu.math.BitOps;
import java.util.HashMap;
import gnu.math.IntNum;
import java.util.Map;

class CanFinishMap
{
    int numPaths;
    Map<LambdaExp, IntNum> pathMap;
    IntNum mask;
    public static final CanFinishMap CANNOT_FINISH;
    public static final CanFinishMap CAN_FINISH;
    
    private CanFinishMap(final Map<LambdaExp, IntNum> map, final int num, final IntNum mask) {
        this.pathMap = map;
        this.numPaths = num;
        this.mask = mask;
    }
    
    private void setNumPaths(final int numPaths) {
        this.numPaths = numPaths;
        this.mask = IntNum.sub(IntNum.shift(IntNum.one(), numPaths), IntNum.one());
    }
    
    public CanFinishMap clone() {
        return new CanFinishMap(new HashMap<LambdaExp, IntNum>(this.pathMap), this.numPaths, this.mask);
    }
    
    public boolean addDependency(final LambdaExp callee) {
        final IntNum old = this.pathMap.get(callee);
        if (old != null && IntNum.equals(old, this.mask)) {
            return false;
        }
        this.pathMap.put(callee, this.mask);
        return true;
    }
    
    public void addPaths(final CanFinishMap other) {
        for (final LambdaExp lexp : other.pathMap.keySet()) {
            final IntNum otherMask = IntNum.shift(other.pathMap.get(lexp), this.numPaths);
            final IntNum old = this.pathMap.get(lexp);
            this.pathMap.put(lexp, (old == null) ? otherMask : BitOps.ior(old, otherMask));
        }
        this.setNumPaths(this.numPaths + other.numPaths);
    }
    
    public boolean canFinish() {
        if (this == CanFinishMap.CANNOT_FINISH) {
            return false;
        }
        IntNum finishDeps = IntNum.zero();
        final Iterator<LambdaExp> it = this.pathMap.keySet().iterator();
        while (it.hasNext()) {
            final LambdaExp lexp = it.next();
            if (lexp.canFinishCondition == CanFinishMap.CAN_FINISH) {
                it.remove();
            }
            else {
                finishDeps = BitOps.ior(finishDeps, this.pathMap.get(lexp));
            }
        }
        return BitOps.lowestBitSet(BitOps.not(finishDeps)) < this.numPaths;
    }
    
    static {
        CANNOT_FINISH = new CanFinishMap(new HashMap<LambdaExp, IntNum>(), 0, IntNum.zero());
        CAN_FINISH = new CanFinishMap(new HashMap<LambdaExp, IntNum>(), 1, IntNum.one());
    }
}
