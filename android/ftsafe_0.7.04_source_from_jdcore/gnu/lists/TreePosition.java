package gnu.lists;

import java.io.PrintStream;
























public class TreePosition
  extends SeqPosition
  implements Cloneable
{
  private Object xpos;
  AbstractSequence[] sstack;
  int[] istack;
  int depth;
  int start;
  
  public TreePosition()
  {
    depth = -1;
  }
  

  public TreePosition(Object root)
  {
    xpos = root;
    depth = -1;
  }
  
  public TreePosition(AbstractSequence seq, int index)
  {
    super(seq, index, false);
  }
  
  public TreePosition(TreePosition pos)
  {
    set(pos);
  }
  
  public Object clone()
  {
    return new TreePosition(this);
  }
  
  public void set(TreePosition position)
  {
    release();
    int d = depth;
    depth = d;
    if (d < 0)
    {
      xpos = xpos;
      return;
    }
    if ((sstack == null) || (sstack.length <= d))
      sstack = new AbstractSequence[d + 10];
    if ((istack == null) || (istack.length <= d)) {
      istack = new int[d + 10];
    }
    
    for (int i = 0; i < depth; i++)
    {
      int j = i + start;
      AbstractSequence seq = sstack[j];
      sstack[(depth - 1)] = seq;
      istack[(depth - i)] = seq.copyPos(istack[j]);
    }
    AbstractSequence seq = sequence;
    sequence = seq;
    ipos = seq.copyPos(ipos);
  }
  

  public int getDepth()
  {
    return depth + 1;
  }
  

  public AbstractSequence getRoot()
  {
    return depth == 0 ? sequence : sstack[start];
  }
  
  public Object getPosNext()
  {
    return sequence == null ? xpos : sequence.getPosNext(ipos);
  }
  
  public void push(AbstractSequence child, int iposChild)
  {
    int d = depth + start;
    if (d >= 0)
    {
      if (d == 0)
      {
        istack = new int[8];
        sstack = new AbstractSequence[8];
      }
      else if (d >= istack.length)
      {
        int ndepth = 2 * d;
        int[] itemp = new int[ndepth];
        Object[] xtemp = new Object[ndepth];
        AbstractSequence[] stemp = new AbstractSequence[ndepth];
        System.arraycopy(istack, 0, itemp, 0, depth);
        System.arraycopy(sstack, 0, stemp, 0, depth);
        istack = itemp;
        sstack = stemp;
      }
      sstack[d] = sequence;
      istack[d] = ipos;
    }
    depth += 1;
    sequence = child;
    ipos = iposChild;
  }
  
  public void pop()
  {
    sequence.releasePos(ipos);
    popNoRelease();
  }
  
  public void popNoRelease()
  {
    if (--depth < 0)
    {
      xpos = sequence;
      sequence = null;
    }
    else
    {
      sequence = sstack[(start + depth)];
      ipos = istack[(start + depth)];
    }
  }
  
  public final boolean gotoParent()
  {
    return sequence == null ? false : sequence.gotoParent(this);
  }
  





  public boolean gotoChildrenStart()
  {
    if (sequence == null)
    {
      if (!(xpos instanceof AbstractSequence))
        return false;
      depth = 0;
      sequence = ((AbstractSequence)xpos);
      setPos(sequence.startPos());


    }
    else if (!sequence.gotoChildrenStart(this)) {
      return false;
    }
    return true;
  }
  



  public boolean gotoAttributesStart()
  {
    if (sequence == null)
    {
      if ((xpos instanceof AbstractSequence)) {}
      


      return false;
    }
    return sequence.gotoAttributesStart(this);
  }
  












  public Object getAncestor(int up)
  {
    if (up == 0)
      return sequence.getPosNext(ipos);
    int i = depth - up;
    if (i <= 0)
      return getRoot();
    i += start;
    return sstack[i].getPosNext(istack[i]);
  }
  
  public void release()
  {
    while (sequence != null)
    {
      sequence.releasePos(ipos);
      pop();
    }
    xpos = null;
  }
  















  public void dump()
  {
    System.err.println("TreePosition dump depth:" + depth + " start:" + start);
    for (int i = 0; i <= depth; i++)
    {
      AbstractSequence seq = i == 0 ? sequence : sstack[(depth - i)];
      System.err.print("#" + i + " seq:" + seq);
      System.err.println(" ipos:" + (i == 0 ? ipos : istack[(depth - i)]));
    }
  }
}
