/*
 * Decompiled with CFR 0.139.
 */
package gnu.expr;

import gnu.expr.LambdaExp;
import gnu.math.BitOps;
import gnu.math.IntNum;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class CanFinishMap {
    int numPaths;
    Map<LambdaExp, IntNum> pathMap;
    IntNum mask;
    public static final CanFinishMap CANNOT_FINISH = new CanFinishMap(new HashMap<LambdaExp, IntNum>(), 0, IntNum.zero());
    public static final CanFinishMap CAN_FINISH = new CanFinishMap(new HashMap<LambdaExp, IntNum>(), 1, IntNum.one());

    private CanFinishMap(Map<LambdaExp, IntNum> map, int num, IntNum mask) {
        this.pathMap = map;
        this.numPaths = num;
        this.mask = mask;
    }

    private void setNumPaths(int numPaths) {
        this.numPaths = numPaths;
        this.mask = IntNum.sub(IntNum.shift(IntNum.one(), numPaths), IntNum.one());
    }

    public CanFinishMap clone() {
        return new CanFinishMap(new HashMap<LambdaExp, IntNum>(this.pathMap), this.numPaths, this.mask);
    }

    public boolean addDependency(LambdaExp callee) {
        IntNum old = this.pathMap.get(callee);
        if (old != null && IntNum.equals(old, this.mask)) {
            return false;
        }
        this.pathMap.put(callee, this.mask);
        return true;
    }

    public void addPaths(CanFinishMap other) {
        for (LambdaExp lexp : other.pathMap.keySet()) {
            IntNum otherMask = IntNum.shift(other.pathMap.get(lexp), this.numPaths);
            IntNum old = this.pathMap.get(lexp);
            this.pathMap.put(lexp, old == null ? otherMask : BitOps.ior(old, otherMask));
        }
        this.setNumPaths(this.numPaths + other.numPaths);
    }

    public boolean canFinish() {
        if (this == CANNOT_FINISH) {
            return false;
        }
        IntNum finishDeps = IntNum.zero();
        Iterator<LambdaExp> it = this.pathMap.keySet().iterator();
        while (it.hasNext()) {
            LambdaExp lexp = it.next();
            if (lexp.canFinishCondition == CAN_FINISH) {
                it.remove();
                continue;
            }
            finishDeps = BitOps.ior(finishDeps, this.pathMap.get(lexp));
        }
        return BitOps.lowestBitSet(BitOps.not(finishDeps)) < this.numPaths;
    }
}

