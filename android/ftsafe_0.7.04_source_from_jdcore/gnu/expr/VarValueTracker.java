package gnu.expr;

import gnu.math.IntNum;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Stack;

public class VarValueTracker
{
  InlineCalls visitor;
  HashMap<Declaration, IntNum> declValueUsage;
  HashMap<Declaration, IntNum[]> forkValues;
  int forkBranchNumber;
  VarValueTracker outer;
  java.util.Set<LambdaExp> lambdasCheckedForUninitializedVariables;
  
  public VarValueTracker(InlineCalls visitor)
  {
    this.visitor = visitor;
    declValueUsage = new HashMap();
  }
  
  public VarValueTracker(VarValueTracker outer)
  {
    this.outer = outer;
    declValueUsage = declValueUsage;
  }
  


























  public static void forkPush(InlineCalls visitor)
  {
    VarValueTracker oldTracker = valueTracker;
    VarValueTracker newTracker = new VarValueTracker(oldTracker);
    valueTracker = newTracker;
    forkValues = new HashMap();
  }
  

  public void forkNext()
  {
    forkBranchNumber += 1;
    for (Map.Entry<Declaration, IntNum[]> entry : forkValues.entrySet())
    {
      Declaration decl = (Declaration)entry.getKey();
      IntNum[] vals = (IntNum[])entry.getValue();
      IntNum cur = (IntNum)declValueUsage.get(decl);
      vals[1] = sourceUnion(vals[1], cur);
      declValueUsage.put(decl, vals[0]);
    }
    
    lambdasCheckedForUninitializedVariables = null;
  }
  
  public static void forkPop(InlineCalls visitor)
  {
    VarValueTracker innerTracker = valueTracker;
    VarValueTracker outerTracker = outer;
    HashMap<Declaration, IntNum> declValueUsage = declValueUsage;
    valueTracker = outerTracker;
    for (Map.Entry<Declaration, IntNum[]> entry : forkValues.entrySet())
    {
      Declaration decl = (Declaration)entry.getKey();
      IntNum[] vals = (IntNum[])entry.getValue();
      IntNum newSource = sourceUnion(vals[1], (IntNum)declValueUsage.get(decl));
      outerTracker.noteSet(decl, newSource);
    }
  }
  
  static IntNum sourceAsMask(IntNum val)
  {
    if (val.isNegative())
    {
      int index = val.intValue() ^ 0xFFFFFFFF;
      val = IntNum.shift(IntNum.one(), index + 1);
    }
    return val;
  }
  
  static IntNum sourceUnion(IntNum set1, IntNum set2)
  {
    if (set1 == set2)
      return set1;
    if (set2.isZero())
      return set1;
    if (set1.isZero())
      return set2;
    return gnu.math.BitOps.ior(sourceAsMask(set1), sourceAsMask(set2));
  }
  
  static boolean maybeUninitialized(IntNum set)
  {
    return (!set.isNegative()) && (set.isOdd());
  }
  

  public void noteUnitialized(Declaration decl)
  {
    if (values != Declaration.unknownValueValues) {
      declValueUsage.put(decl, IntNum.one());
    }
  }
  
  public void noteUnitialized(ScopeExp scope)
  {
    for (Declaration decl = scope.firstDecl(); decl != null; 
        decl = decl.nextDecl()) {
      noteUnitialized(decl);
    }
  }
  
  public void noteSet(Declaration decl, IntNum source) {
    IntNum curSource = (IntNum)declValueUsage.get(decl);
    if ((forkValues != null) && (curSource != null))
    {
      IntNum[] vals = (IntNum[])forkValues.get(decl);
      if (vals == null)
      {
        vals = new IntNum[2];
        vals[0] = curSource;
        vals[1] = (forkBranchNumber == 0 ? IntNum.zero() : curSource);
        forkValues.put(decl, vals);
      }
    }
    declValueUsage.put(decl, source);
  }
  







  void checkUninitializedVariables(LambdaExp lexp, ReferenceExp referrer, Stack<ReferenceExp> callers)
  {
    if (lambdasCheckedForUninitializedVariables == null) {
      lambdasCheckedForUninitializedVariables = new java.util.HashSet();
    } else if (lambdasCheckedForUninitializedVariables.contains(lexp))
      return;
    lambdasCheckedForUninitializedVariables.add(lexp);
    if (callers == null)
      callers = new Stack();
    callers.push(referrer);
    for (ReferenceExp rexp = siblingReferences; rexp != null; 
        rexp = siblingReferencesNext)
    {
      Declaration decl = rexp.getBinding();
      LambdaExp lvalue = decl.getLambdaValue();
      if (lvalue != null)
      {
        checkUninitializedVariables(lvalue, rexp, callers);
      }
      else
      {
        IntNum vals = (IntNum)declValueUsage.get(decl);
        if ((vals != null) && (maybeUninitialized(vals)) && (!decl.getFlag(274877906944L)))
        {

          Compilation comp = visitor.getCompilation();
          comp.error('w', "variable '" + rexp.getName() + "' may be uninitialized here", rexp);
          if (callers != null)
          {
            int i = callers.size();
            for (;;) { i--; if (i < 0) break;
              comp.error('w', "- because of possible call here of function " + ((ReferenceExp)callers.get(i)).getName(), (gnu.text.SourceLocator)callers.get(i));
            } }
          decl.setFlag(274877906944L);
        }
      }
    }
    callers.pop();
  }
}
