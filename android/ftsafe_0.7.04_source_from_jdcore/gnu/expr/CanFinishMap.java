package gnu.expr;

import gnu.math.BitOps;
import gnu.math.IntNum;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;





















class CanFinishMap
{
  int numPaths;
  Map<LambdaExp, IntNum> pathMap;
  IntNum mask;
  
  private CanFinishMap(Map<LambdaExp, IntNum> map, int num, IntNum mask)
  {
    pathMap = map;
    numPaths = num;
    this.mask = mask;
  }
  
  private void setNumPaths(int numPaths)
  {
    this.numPaths = numPaths;
    mask = IntNum.sub(IntNum.shift(IntNum.one(), numPaths), IntNum.one());
  }
  




  public static final CanFinishMap CANNOT_FINISH = new CanFinishMap(new HashMap(), 0, IntNum.zero());
  






  public static final CanFinishMap CAN_FINISH = new CanFinishMap(new HashMap(), 1, IntNum.one());
  
  public CanFinishMap clone()
  {
    return new CanFinishMap(new HashMap(pathMap), numPaths, mask);
  }
  


  public boolean addDependency(LambdaExp callee)
  {
    IntNum old = (IntNum)pathMap.get(callee);
    if ((old != null) && (IntNum.equals(old, mask)))
      return false;
    pathMap.put(callee, mask);
    return true;
  }
  

  public void addPaths(CanFinishMap other)
  {
    for (LambdaExp lexp : pathMap.keySet()) {
      IntNum otherMask = IntNum.shift((IntNum)pathMap.get(lexp), numPaths);
      IntNum old = (IntNum)pathMap.get(lexp);
      pathMap.put(lexp, old == null ? otherMask : BitOps.ior(old, otherMask));
    }
    
    setNumPaths(numPaths + numPaths);
  }
  
  public boolean canFinish()
  {
    if (this == CANNOT_FINISH)
      return false;
    IntNum finishDeps = IntNum.zero();
    Iterator<LambdaExp> it = pathMap.keySet().iterator();
    while (it.hasNext()) {
      LambdaExp lexp = (LambdaExp)it.next();
      if (canFinishCondition == CAN_FINISH) {
        it.remove();
      } else {
        finishDeps = BitOps.ior(finishDeps, (IntNum)pathMap.get(lexp));
      }
    }
    return BitOps.lowestBitSet(BitOps.not(finishDeps)) < numPaths;
  }
}
