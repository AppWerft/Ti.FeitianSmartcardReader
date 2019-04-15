package gnu.bytecode;

import java.util.ArrayList;















public class Label
{
  int first_fixup;
  int position;
  boolean needsStackMapEntry;
  Type[] stackTypes;
  Type[] localTypes;
  private Object[] typeChangeListeners;
  
  public final boolean defined()
  {
    return position >= 0;
  }
  
  public Label() {
    this(-1);
  }
  
  public Label(CodeAttr code)
  {
    this(-1);
  }
  
  public Label(int position)
  {
    this.position = position;
  }
  
  public boolean isUsed() { return stackTypes != null; }
  
  Type mergeTypes(Type t1, Type t2)
  {
    if (t1 instanceof PrimType != t2 instanceof PrimType)
      return null;
    return Type.lowestCommonSuperType(t1, t2);
  }
  
  void setTypes(Type[] locals, int usedLocals, Type[] stack, int usedStack)
  {
    for (; 
        usedLocals > 0; usedLocals--)
    {
      Type last = locals[(usedLocals - 1)];
      if (last != null)
        break;
    }
    if (stackTypes == null)
    {
      if (usedStack == 0) {
        stackTypes = Type.typeArray0;
      }
      else {
        stackTypes = new Type[usedStack];
        System.arraycopy(stack, 0, stackTypes, 0, usedStack);
      }
      if (usedLocals == 0) {
        localTypes = Type.typeArray0;
      }
      else {
        localTypes = new Type[usedLocals];
        System.arraycopy(locals, 0, localTypes, 0, usedLocals);
      }
    }
    else
    {
      int SP = usedStack;
      int slen = stackTypes.length;
      if (SP != slen)
        throw new InternalError("inconsistent stack length");
      for (int i = 0; i < SP; i++)
      {
        Type t = mergeTypes(stackTypes[i], stack[i]);
        if (t == null)
          throw new InternalError("inconsistent stackType");
        stackTypes[i] = t;
      }
      for (int i = 0; i < localTypes.length; i++)
      {
        mergeLocalType(i, i < usedLocals ? locals[i] : null);
      }
    }
  }
  
  public void setTypes(CodeAttr code)
  {
    addTypeChangeListeners(code);
    if ((stackTypes != null) && (SP != stackTypes.length))
      throw new InternalError();
    setTypes(local_types, local_types == null ? 0 : local_types.length, stack_types, SP);
  }
  



  public void setTypes(Label other)
  {
    setTypes(localTypes, localTypes.length, stackTypes, stackTypes.length);
  }
  

  private void mergeLocalType(int varnum, Type newType)
  {
    if (varnum < localTypes.length)
    {
      Type oldLocal = localTypes[varnum];
      Type newLocal = mergeTypes(oldLocal, newType);
      if (newLocal != oldLocal)
      {
        localTypes[varnum] = newLocal;
        notifyTypeChangeListeners(varnum, newLocal);
      }
    }
  }
  
  private void notifyTypeChangeListeners(int varnum, Type newType)
  {
    Object[] arr = typeChangeListeners;
    if ((arr == null) || (arr.length <= varnum))
      return;
    Object listeners = arr[varnum];
    if (listeners == null)
      return;
    if ((listeners instanceof Label)) {
      ((Label)listeners).mergeLocalType(varnum, newType);
    }
    else {
      for (Label listener : (ArrayList)listeners)
        listener.mergeLocalType(varnum, newType);
    }
    if (newType == null) {
      arr[varnum] = null;
    }
  }
  






  void addTypeChangeListener(int varnum, Label listener)
  {
    Object[] arr = typeChangeListeners;
    if (arr == null) {
      typeChangeListeners = (arr = new Object[varnum + 10]);
    } else if (arr.length <= varnum)
    {
      arr = new Object[varnum + 10];
      System.arraycopy(typeChangeListeners, 0, arr, 0, typeChangeListeners.length);
      typeChangeListeners = arr;
    }
    Object set = arr[varnum];
    if (set == null) {
      arr[varnum] = listener;
    }
    else {
      ArrayList<Label> list;
      if ((set instanceof Label))
      {
        ArrayList<Label> list = new ArrayList();
        list.add((Label)set);
        arr[varnum] = list;
      }
      else {
        list = (ArrayList)set; }
      list.add(listener);
    }
  }
  
  void addTypeChangeListeners(CodeAttr code)
  {
    if ((local_types != null) && (previousLabel != null))
    {
      int len = local_types.length;
      for (int varnum = 0; varnum < len; varnum++)
      {
        if ((local_types[varnum] != null) && ((varsSetInCurrentBlock == null) || (varsSetInCurrentBlock.length <= varnum) || (varsSetInCurrentBlock[varnum] == 0)))
        {


          previousLabel.addTypeChangeListener(varnum, this);
        }
      }
    }
  }
  


  public void defineRaw(CodeAttr code)
  {
    defineRaw(code, 0);
  }
  
  void defineRaw(CodeAttr code, int fixupKind)
  {
    if (position >= 0)
      throw new Error("label definition more than once");
    position = PC;
    first_fixup = fixup_count;
    if (first_fixup >= 0) {
      code.fixupAdd(fixupKind, this);
    }
  }
  



  public void define(CodeAttr code)
  {
    boolean wasReachable = code.reachableHere();
    if (wasReachable)
    {
      setTypes(code);
    }
    else if (localTypes != null)
    {
      int i = localTypes.length; for (;;) { i--; if (i < 0)
          break;
        if ((localTypes[i] != null) && ((locals.used == null) || (locals.used[i] == null)))
        {

          localTypes[i] = null;
        }
      }
    }
    code.setPreviousLabelHere(this);
    defineRaw(code, wasReachable ? 0 : 1);
    
    if (localTypes != null)
    {
      code.setTypes(this);
    }
    code.setReachable(true);
  }
}
