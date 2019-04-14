package gnu.lists;

import java.util.Enumeration;
import java.util.ListIterator;
import java.util.NoSuchElementException;


































public class SeqPosition<E, ESEQ extends AbstractSequence<E>>
  implements ListIterator<E>, Enumeration<E>
{
  public ESEQ sequence;
  public int ipos;
  
  public SeqPosition() {}
  
  public SeqPosition(ESEQ seq)
  {
    sequence = seq;
  }
  
  public SeqPosition(ESEQ seq, int offset, boolean isAfter)
  {
    sequence = seq;
    ipos = seq.createPos(offset, isAfter);
  }
  
  public SeqPosition(ESEQ seq, int ipos)
  {
    sequence = seq;
    this.ipos = ipos;
  }
  



  public static <E, ESEQ extends AbstractSequence<E>> SeqPosition<E, ESEQ> make(ESEQ seq, int ipos)
  {
    return new SeqPosition(seq, seq.copyPos(ipos));
  }
  
  public SeqPosition<E, ESEQ> copy()
  {
    return new SeqPosition(sequence, sequence.copyPos(getPos()));
  }
  
  public final void gotoStart(ESEQ seq)
  {
    setPos(seq, seq.startPos());
  }
  
  public final void gotoEnd(ESEQ seq)
  {
    setPos(seq, seq.endPos());
  }
  





  public boolean gotoChildrenStart()
  {
    int child = sequence.firstChildPos(getPos());
    if (child == 0)
      return false;
    ipos = child;
    return true;
  }
  


  public final boolean hasMoreElements()
  {
    return hasNext();
  }
  

  public boolean hasNext()
  {
    return sequence.hasNext(getPos());
  }
  















  public int getNextKind()
  {
    return sequence.getNextKind(getPos());
  }
  

  public String getNextTypeName()
  {
    return sequence.getNextTypeName(getPos());
  }
  

  public E getNextTypeObject()
  {
    return sequence.getNextTypeObject(getPos());
  }
  

  public boolean hasPrevious()
  {
    return sequence.hasPrevious(getPos());
  }
  
  public E next()
  {
    Object result = getNext();
    int next = sequence.nextPos(ipos);
    if (next == 0)
      throw new NoSuchElementException();
    ipos = next;
    return result;
  }
  



  public boolean gotoNext()
  {
    int next = sequence.nextPos(ipos);
    if (next != 0)
    {
      ipos = next;
      return true;
    }
    

    ipos = -1;
    return false;
  }
  




  public boolean gotoPrevious()
  {
    int prev = sequence.previousPos(ipos);
    if (prev != -1)
    {
      ipos = prev;
      return true;
    }
    

    ipos = 0;
    return false;
  }
  



  public E previous()
  {
    Object result = getPrevious();
    if ((result == Sequence.eofValue) || (!gotoPrevious()))
      throw new NoSuchElementException();
    return result;
  }
  

  public final E nextElement()
  {
    return next();
  }
  





  public Object getNext()
  {
    return sequence.getPosNext(getPos());
  }
  





  public Object getPrevious()
  {
    return sequence.getPosPrevious(getPos());
  }
  

  public int nextIndex()
  {
    return sequence.nextIndex(getPos());
  }
  
  public final int fromEndIndex()
  {
    return sequence.fromEndIndex(getPos());
  }
  
  public int getContainingSequenceSize()
  {
    return sequence.getContainingSequenceSize(getPos());
  }
  

  public final int previousIndex()
  {
    return sequence.nextIndex(getPos()) - 1;
  }
  






  public boolean isAfter()
  {
    return sequence.isAfterPos(getPos());
  }
  
  public final void set(E value)
  {
    if (isAfter()) {
      setPrevious(value);
    } else {
      setNext(value);
    }
  }
  
  public void setNext(E value) {
    sequence.setPosNext(getPos(), value);
  }
  
  public void setPrevious(E value)
  {
    sequence.setPosPrevious(getPos(), value);
  }
  
  public void remove()
  {
    sequence.removePos(getPos(), isAfter() ? -1 : 1);
  }
  
  public void add(E o)
  {
    setPos(sequence.addPos(getPos(), o));
  }
  







  public int getPos()
  {
    return ipos;
  }
  
  public void setPos(ESEQ seq, int ipos)
  {
    if (sequence != null)
      sequence.releasePos(getPos());
    this.ipos = ipos;
    sequence = seq;
  }
  
  public void setPos(int ipos)
  {
    if (sequence != null)
      sequence.releasePos(getPos());
    this.ipos = ipos;
  }
  
  public void set(ESEQ seq, int index, boolean isAfter)
  {
    if (sequence != null)
      sequence.releasePos(ipos);
    sequence = seq;
    ipos = seq.createPos(index, isAfter);
  }
  
  public void set(SeqPosition<E, ESEQ> pos)
  {
    if (sequence != null)
      sequence.releasePos(ipos);
    sequence = sequence;
    ipos = sequence.copyPos(ipos);
  }
  
  public void release()
  {
    if (sequence != null)
    {
      sequence.releasePos(getPos());
      sequence = null;
    }
  }
  
  public void finalize()
  {
    release();
  }
  
  public String toString()
  {
    if (sequence == null)
      return toInfo();
    Object item = sequence.getPosNext(ipos);
    return "@" + nextIndex() + ": " + (item == null ? "(null)" : item.toString());
  }
  
  public String toInfo()
  {
    StringBuffer sbuf = new StringBuffer(60);
    sbuf.append('{');
    if (sequence == null) {
      sbuf.append("null sequence");
    }
    else {
      sbuf.append(sequence.getClass().getName());
      sbuf.append('@');
      sbuf.append(System.identityHashCode(sequence));
    }
    sbuf.append(" ipos: ");
    sbuf.append(ipos);
    






    sbuf.append('}');
    return sbuf.toString();
  }
}
