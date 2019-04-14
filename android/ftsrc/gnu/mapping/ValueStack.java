package gnu.mapping;

import gnu.lists.Consumer;
import gnu.lists.TreeList;

class ValueStack extends TreeList
{
  int gapStartOnPush;
  Consumer consumerOnPush = this;
  int oindexOnPush;
  
  ValueStack() {}
  
  Object lastObject = this;
  
  public void clear() {
    super.clear();
    lastObject = this;
  }
  
  void push() {
    if (lastObject != this) {
      super.writeObject(lastObject);
      lastObject = this;
    }
    int oindex = find(consumerOnPush);
    ensureSpace(6);
    int start = gapStart;
    data[(start++)] = 61698;
    setIntN(start, oindex);
    start += 2;
    gapStart = start;
    data[(start++)] = 61698;
    setIntN(start, gapStartOnPush);
    gapStart = (start + 2);
  }
  
  void pop(int saved) {
    gapStartOnPush = getIntN(saved - 2);
    int oindex = getIntN(saved - 5);
    consumerOnPush = ((Consumer)objects[oindex]);
    objects[oindex] = null;
    oindexOnPush = oindex;
    gapStart = (saved - 6);
  }
  
  Object getValue() {
    Object last = lastObject;
    if (gapStart == gapStartOnPush) {
      return last == this ? Values.empty : last;
    }
    int next = nextDataIndex(gapStartOnPush);
    if ((next == gapStart) && (last == this))
      return getPosNext(gapStartOnPush << 1);
    Values.FromTreeList vals = new Values.FromTreeList();
    super.consumeIRange(gapStartOnPush, gapStart, vals);
    if (lastObject != this)
      vals.writeObject(lastObject);
    return vals;
  }
  
  public void ensureSpace(int needed)
  {
    super.ensureSpace(needed + 3);
    if (lastObject != this) {
      super.writeObject(lastObject);
      lastObject = this;
    }
  }
  
  public void writeObject(Object v)
  {
    if (lastObject != this)
      super.writeObject(lastObject);
    lastObject = v;
  }
}
