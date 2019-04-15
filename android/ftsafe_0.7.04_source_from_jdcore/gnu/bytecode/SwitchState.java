package gnu.bytecode;







public class SwitchState
{
  int minValue;
  




  int maxValue;
  



  int numCases;
  



  int[] values;
  



  Label[] labels;
  



  Label defaultLabel;
  



  Label switch_label;
  



  Label cases_label;
  



  Label after_label;
  



  TryState outerTry;
  




  public int getMaxValue() { return maxValue; }
  
  public int getNumCases() { return numCases; }
  
  public SwitchState(CodeAttr code) {
    switch_label = new Label(code);
    cases_label = new Label(code);
    after_label = new Label(code);
    defaultLabel = new Label(code);
    outerTry = try_stack;
    
    numCases = 0;
  }
  



  public void switchValuePushed(CodeAttr code)
  {
    Type top = code.popType();
    cases_label.setTypes(code);
    code.pushType(top);
    switch_label.setTypes(code);
    code.fixupAdd(9, -1, switch_label);
    code.setUnreachable();
    cases_label.define(code);
  }
  





  public boolean addCase(int value, CodeAttr code)
  {
    Label label = new Label(code);
    label.setTypes(cases_label);
    label.define(code);
    return insertCase(value, label, code);
  }
  
  public boolean addCaseGoto(int value, CodeAttr code, Label label)
  {
    boolean ok = insertCase(value, label, code);
    label.setTypes(cases_label);
    code.setUnreachable();
    return ok;
  }
  
  public void addDefault(CodeAttr code) {
    if (defaultLabel.defined()) throw new Error();
    if (outerTry != try_stack)
      defaultLabel.setTypes(code);
    defaultLabel.setTypes(cases_label);
    defaultLabel.define(code);
  }
  





  public boolean insertCase(int value, Label label, CodeAttr code)
  {
    if (values == null) {
      values = new int[10];
      labels = new Label[10];
      numCases = 1;
      minValue = (this.maxValue = value);
      values[0] = value;
      labels[0] = label;
      return true;
    }
    
    int[] old_values = values;
    Label[] old_labels = labels;
    int copyBefore;
    if (value < minValue) {
      int copyBefore = 0;
      minValue = value;
    } else if (value > maxValue) {
      int copyBefore = numCases;
      maxValue = value;
    }
    else {
      int low = 0;
      int hi = numCases - 1;
      copyBefore = 0;
      while (low <= hi) {
        copyBefore = low + hi >>> 1;
        if (old_values[copyBefore] >= value) {
          hi = copyBefore - 1;
        } else {
          copyBefore++;low = copyBefore;
        }
      }
      if (value == old_values[copyBefore])
        return false;
    }
    if (numCases >= values.length) {
      values = new int[2 * numCases];
      labels = new Label[2 * numCases];
    }
    int copyAfter = numCases - copyBefore;
    System.arraycopy(old_values, copyBefore, values, copyBefore + 1, copyAfter);
    System.arraycopy(old_values, 0, values, 0, copyBefore);
    values[copyBefore] = value;
    System.arraycopy(old_labels, copyBefore, labels, copyBefore + 1, copyAfter);
    System.arraycopy(old_labels, 0, labels, 0, copyBefore);
    labels[copyBefore] = label;
    numCases += 1;
    return true;
  }
  



  public void exitSwitch(CodeAttr code)
  {
    if (code.reachableHere()) {
      if (outerTry != try_stack)
        throw new Error("exitSwitch cannot exit through a try");
      code.emitGoto(after_label);
    }
  }
  

  public void finish(CodeAttr code)
  {
    if (code.reachableHere())
      exitSwitch(code);
    if (!defaultLabel.defined()) {
      defaultLabel.define(code);
      ClassType ex = ClassType.make("java.lang.RuntimeException");
      code.emitNew(ex);
      code.emitDup(ex);
      code.emitPushString("bad case value!");
      Type[] args = { Type.string_type };
      Method con = ex.addMethod("<init>", 1, args, Type.voidType);
      
      code.emitInvokeSpecial(con);
      code.emitThrow();
    }
    code.fixupAdd(9, -1, after_label);
    switch_label.define(code);
    
    if (numCases <= 1) {
      if (numCases == 1) {
        if (minValue == 0) {
          code.emitIfIntEqZero();
        } else {
          code.emitPushInt(minValue);
          code.emitIfEq();
        }
        code.emitGoto(labels[0]);
        code.emitElse();
        code.emitGoto(defaultLabel);
        code.emitFi();
      } else {
        code.emitPop(1);
        code.emitGoto(defaultLabel);
      }
    } else {
      long rangeDim = maxValue - minValue;
      if (2 * numCases >= rangeDim) {
        int size = (int)(13L + 4L * (rangeDim + 1L));
        code.reserve(size);
        code.fixupAdd(2, null);
        code.put1(170);
        code.fixupAdd(3, defaultLabel);
        PC += 4;
        code.put4(minValue);
        code.put4(maxValue);
        int index = 0;
        
        for (int i = minValue;; i++) {
          Label lab = values[index] == i ? labels[(index++)] : defaultLabel;
          code.fixupAdd(3, lab);
          PC += 4;
          if (i == maxValue)
            break;
        }
      } else { code.reserve(9 + 8 * numCases);
        code.fixupAdd(2, null);
        code.put1(171);
        code.fixupAdd(3, defaultLabel);
        PC += 4;
        code.put4(numCases);
        for (int index = 0; index < numCases; index++) {
          code.put4(values[index]);
          code.fixupAdd(3, labels[index]);
          PC += 4;
        }
      }
    }
    code.fixupAdd(9, cases_label);
    code.setUnreachable();
    if (after_label.isUsed()) {
      after_label.define(code);
    } else {
      after_label.defineRaw(code);
    }
  }
}
