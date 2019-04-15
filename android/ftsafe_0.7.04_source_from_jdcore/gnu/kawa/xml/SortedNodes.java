package gnu.kawa.xml;

import gnu.lists.AbstractSequence;
import gnu.lists.SeqPosition;





public class SortedNodes
  extends Nodes
{
  public SortedNodes() {}
  
  private int compareIndex(int index, AbstractSequence seq2, int ipos2)
  {
    AbstractSequence seq1 = vector.getSeq(index);
    int ipos1 = vector.getPos(index);
    return AbstractSequence.compare(seq1, ipos1, seq2, ipos2);
  }
  






  private int find(int start, int count, AbstractSequence seq, int ipos)
  {
    int lo = 0;
    int hi = count;
    



    while (lo < hi) {
      int mid = lo + hi >>> 1;
      int cmp = compareIndex(start + mid, seq, ipos);
      if (cmp == 0)
        return -1;
      if (cmp > 0) {
        hi = mid;
      } else
        lo = mid + 1;
    }
    return start + lo;
  }
  
  int find(AbstractSequence seq, int ipos) {
    int count = size();
    if (count <= 0) {
      return 0;
    }
    
    int lastIndex = vector.getLastIndex();
    int cmp = lastIndex < 0 ? -1 : compareIndex(lastIndex, seq, ipos);
    if (cmp < 0)
    {
      int i = lastIndex + 1;
      


      return find(i, count - i, seq, ipos); }
    if (cmp == 0) {
      return -1;
    }
    return find(0, lastIndex, seq, ipos);
  }
  

  public void writePosition(SeqPosition position)
  {
    AbstractSequence seq = sequence;
    int ipos = ipos;
    int i = find(seq, ipos);
    if (i >= 0) {
      vector.add(i, position);
    }
  }
  
  public void writePosition(AbstractSequence seq, int ipos) {
    int i = find(seq, ipos);
    if (i >= 0) {
      vector.add(i, (SeqPosition)null);
      vector.setBuffer(i, seq, ipos);
    }
  }
}
