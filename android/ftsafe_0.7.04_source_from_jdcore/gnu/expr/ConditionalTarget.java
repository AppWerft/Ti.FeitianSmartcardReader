package gnu.expr;

import gnu.bytecode.ClassType;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.Label;
import gnu.bytecode.Method;
import gnu.bytecode.Type;
import gnu.kawa.reflect.LazyType;
import gnu.mapping.Values;

public class ConditionalTarget extends Target
{
  public Label ifTrue;
  public Label ifFalse;
  Language language;
  public static final Method isTrueMethod = ClassType.make("gnu.expr.KawaConvert").getDeclaredMethod("isTrue", 1);
  








  public ConditionalTarget(Label ifTrue, Label ifFalse, Language language)
  {
    this.ifTrue = ifTrue;
    this.ifFalse = ifFalse;
    this.language = language;
  }
  



  public boolean trueBranchComesFirst = true;
  
  public Type getType() { return Type.booleanType; }
  
  public void compileFromStack(Compilation comp, Type stackType) {
    CodeAttr code = comp.getCode();
    
    stackType = comp.asBooleanValue(this, stackType);
    if (stackType == null)
      return;
    char sig = stackType.getSignature().charAt(0);
    if (language != null)
    {
      Object zero;
      

      switch (sig) {
      case 'B': case 'D': case 'F': case 'I': case 'J': case 'S': 
        zero = Integer.valueOf(0);
        break;
      case 'C': 
        zero = Character.valueOf('\000');
        break;
      case 'E': case 'G': case 'H': case 'K': case 'L': case 'M': case 'N': case 'O': case 'P': case 'Q': case 'R': default: 
        zero = null;
      }
      if ((zero != null) && (language.booleanValue(zero) > 0)) {
        code.emitPop(1);
        code.emitGoto(ifTrue);
        return;
      }
    }
    
    switch (sig)
    {

    case 'V': 
      int voidValue = language.booleanValue(Values.empty);
      Label lab; Label lab; if (voidValue > 0) {
        lab = ifTrue;
      } else {
        if (voidValue < 0)
          comp.error('e', "invalid void value in condition");
        lab = ifFalse;
      }
      code.emitGoto(lab);
      return;
    case 'J': 
      code.emitPushLong(0L);
      break;
    case 'D': 
      code.emitPushDouble(0.0D);
      break;
    case 'F': 
      code.emitPushFloat(0.0F);
      break;
    default: 
      if (trueBranchComesFirst) {
        code.emitGotoIfIntEqZero(ifFalse);
      } else
        code.emitGotoIfIntNeZero(ifTrue);
      emitGotoFirstBranch(code);
      return;
    case 'L': case '[': 
      if (language.booleanValue(null) == 0) {
        if ((Type.javalangBooleanType.compare(stackType) == -3) && (!LazyType.maybeLazy(stackType)))
        {
          comp.compileConstant(null);
        } else {
          code.emitInvokeStatic(isTrueMethod);
          if (trueBranchComesFirst) {
            code.emitGotoIfIntEqZero(ifFalse);
          } else
            code.emitGotoIfIntNeZero(ifTrue);
          emitGotoFirstBranch(code);
        }
        
      }
      else
        comp.compileConstant(language.booleanObject(false));
      break; }
    
    if (trueBranchComesFirst) {
      code.emitGotoIfEq(ifFalse);
    } else
      code.emitGotoIfNE(ifTrue);
    emitGotoFirstBranch(code);
  }
  


  public final void emitGotoFirstBranch(CodeAttr code)
  {
    code.emitGoto(trueBranchComesFirst ? ifTrue : ifFalse);
  }
}
