package gnu.expr;

import gnu.bytecode.ClassType;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.Label;
import gnu.bytecode.Method;
import gnu.bytecode.SwitchState;
import gnu.bytecode.Type;
import gnu.kawa.functions.IsEqv;
import gnu.kawa.io.OutPort;
import gnu.kawa.lispexpr.LangObjType;
import gnu.kawa.lispexpr.LangPrimType;
import gnu.lists.EmptyList;
import gnu.lists.PairWithPosition;
import gnu.lists.SimpleVector;
import gnu.mapping.CallContext;
import gnu.math.IntNum;
import gnu.text.Char;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;




















public class CaseExp
  extends Expression
{
  Expression key;
  CaseClause[] clauses;
  CaseClause elseClause;
  
  public static class CaseClause
  {
    Expression[] datums;
    Expression exp;
    
    public CaseClause(Expression exp)
    {
      datums = null;
      this.exp = exp;
    }
    
    public CaseClause(Expression[] datums, Expression exp)
    {
      this.datums = datums;
      this.exp = exp;
    }
  }
  














  public CaseExp(Expression key, CaseClause[] clauses)
  {
    this.key = key;
    this.clauses = clauses;
    elseClause = null;
    if ((key == null) || (clauses == null) || (clauses.length == 0)) {
      throw new IllegalArgumentException("CaseExp constructor called with null arguments");
    }
  }
  



  public CaseExp(Expression key, CaseClause[] clauses, CaseClause elseClause)
  {
    this.key = key;
    this.clauses = clauses;
    this.elseClause = elseClause;
    if ((key == null) || (clauses == null) || (elseClause == null)) {
      throw new IllegalArgumentException("CaseExp constructor called with null arguments");
    }
  }
  
  protected boolean mustCompile()
  {
    return false;
  }
  
  public void apply(CallContext ctx) throws Throwable
  {
    Expression e = selectCase(key.eval(ctx));
    if (e != null) {
      e.apply(ctx);
    } else {
      QuoteExp.voidExp.apply(ctx);
    }
  }
  
  public void print(OutPort out) {
    out.startLogicalBlock("(Case ", false, ")");
    out.setIndentation(-2, false);
    key.print(out);
    for (int i = 0; i < clauses.length; i++) {
      out.writeSpaceLinear();
      Expression[] datums = clauses[i].datums;
      Expression exp = clauses[i].exp;
      out.startLogicalBlock("(", false, ")");
      out.startLogicalBlock("(", false, ")");
      for (int j = 0; j < datums.length; j++) {
        if (j > 0)
          out.print(' ');
        out.print(((QuoteExp)datums[j]).getValue());
      }
      out.endLogicalBlock(")");
      out.writeSpaceLinear();
      exp.print(out);
      out.endLogicalBlock(")");
    }
    if (elseClause != null) {
      out.writeSpaceLinear();
      out.startLogicalBlock("(else ", false, ")");
      elseClause.exp.print(out);
      out.endLogicalBlock(")");
    }
    out.endLogicalBlock(")");
  }
  
  static Method isEqvMethod = ClassType.make("gnu.kawa.functions.IsEqv").getDeclaredStaticMethod("apply", 2);
  
  static Method hashCodeMethod = Type.objectType.getDeclaredMethod("hashCode", 0);
  

  public void compile(Compilation comp, Target target)
  {
    CodeAttr code = comp.getCode();
    
    compileKey(comp);
    
    if (!code.reachableHere()) {
      return;
    }
    

    boolean integer = ((key.getType() == Type.intType) && (calculateDatumsType() == Type.intType)) || (((key.getType() == LangPrimType.characterType) || (key.getType() == LangPrimType.charType)) && (calculateDatumsType() == LangPrimType.characterType));
    









    HashMap<Integer, ArrayList<Object>> hashToClauseMap = new HashMap();
    




    HashMap<Expression, Label> expToLabelMap = new HashMap();
    
    HashMap<Expression, Integer> expToPendingDatumCounts = new HashMap();
    

    for (CaseClause clause : clauses) {
      Expression e = exp;
      int saneDatums = 0;
      for (int j = 0; j < datums.length; j++) {
        Expression dexp = datums[j];
        Object d = calculateDatumValue(dexp);
        
        if (((integer) || (!(d instanceof SimpleVector))) && (((d instanceof EmptyList)) || (!(d instanceof PairWithPosition))))
        {


          saneDatums++;
          int hash = d.hashCode();
          ArrayList<Object> a = (ArrayList)hashToClauseMap.get(Integer.valueOf(hash));
          if (a == null) {
            a = new ArrayList();
            hashToClauseMap.put(Integer.valueOf(hash), a);
          }
          a.add(d);
          a.add(e);
        } }
      expToPendingDatumCounts.put(e, Integer.valueOf(saneDatums));
    }
    

    SwitchState sw = code.startSwitch();
    Label before_label = new Label();
    before_label.setTypes(code);
    Label defaultl = new Label();
    
    for (Iterator i$ = hashToClauseMap.keySet().iterator(); i$.hasNext();) { int h = ((Integer)i$.next()).intValue();
      if (!integer)
        sw.addCase(h, code);
      ArrayList<Object> dwes = (ArrayList)hashToClauseMap.get(Integer.valueOf(h));
      
      for (int i = 0; i < dwes.size(); i += 2)
      {
        Object datum = dwes.get(i);
        Expression exp = (Expression)dwes.get(i + 1);
        



        if (!integer)
        {



          if (((key.getType() == Type.intType) || (key.getType() == Type.longType)) && ((datum instanceof IntNum)))
          {
            IntNum idatum = (IntNum)datum;
            key.compile(comp, key.getType());
            
            if ((idatum.inIntRange()) && (key.getType() == Type.intType)) {
              int val = idatum.intValue();
              code.emitPushInt(val);
            } else {
              StackTarget st = new StackTarget(Type.longType);
              st.compileFromStack(comp, key.getType());
              long val = idatum.longValue();
              code.emitPushLong(val);
            }
            code.emitIfEq();
          } else if (((key.getType() == LangPrimType.charType) || (key.getType() == LangPrimType.characterType)) && ((datum instanceof Char)))
          {


            key.compile(comp, Type.intType);
            int val = ((Char)datum).intValue();
            code.emitPushInt(val);
            code.emitIfEq();
          }
          else {
            key.compile(comp, Type.objectType);
            comp.compileConstant(datum, Target.pushObject);
            code.emitInvokeStatic(isEqvMethod);
            code.emitIfIntNotZero();
          }
        }
        








        int pendingDatumCount = ((Integer)expToPendingDatumCounts.get(exp)).intValue() - 1;
        Label expLabel = (Label)expToLabelMap.get(exp);
        if (pendingDatumCount == 0)
        {
          if (integer) {
            sw.addCase(h, code);
          }
          if (expLabel != null)
            expLabel.define(code);
          exp.compile(comp, target);
          sw.exitSwitch(code);
        }
        else
        {
          expToPendingDatumCounts.put(exp, Integer.valueOf(pendingDatumCount));
          if (expLabel == null) {
            expLabel = new Label(code);
            expToLabelMap.put(exp, expLabel);
          }
          if (integer) {
            sw.addCaseGoto(h, code, expLabel);
          } else
            code.emitGoto(expLabel);
        }
        if (!integer) { code.emitFi();
        }
      }
      

      if (!integer) {
        code.emitGoto(defaultl);
      }
    }
    sw.addDefault(code);
    defaultl.define(code);
    if (elseClause != null) {
      elseClause.exp.compile(comp, target);
    } else
      QuoteExp.voidExp.compile(comp, target);
    sw.finish(code);
  }
  





  private void compileKey(Compilation comp)
  {
    CodeAttr code = comp.getCode();
    
    if ((key.getType() == Type.intType) || (key.getType() == Type.shortType) || (key.getType() == Type.byteType) || (key.getType() == LangPrimType.charType) || (key.getType() == LangPrimType.characterType))
    {




      key.compile(comp, Type.intType);
    } else if (key.getType() == Type.longType)
    {
      key.compile(comp, Type.longType);
      key.compile(comp, Type.longType);
      code.emitPushInt(32);
      code.emitShr();
      code.emitXOr();
      StackTarget st = new StackTarget(Type.intType);
      st.compileFromStack(comp, Type.longType);
    }
    else
    {
      key.compile(comp, Type.objectType);
      code.emitInvokeVirtual(hashCodeMethod);
    }
  }
  
  protected <R, D> R visit(ExpVisitor<R, D> visitor, D d)
  {
    return visitor.visitCaseExp(this, d);
  }
  
  protected <R, D> void visitChildren(ExpVisitor<R, D> visitor, D d)
  {
    key = visitor.visitAndUpdate(key, d);
    for (int i = 0; (exitValue == null) && (i < clauses.length); i++) {
      CaseClause clause = clauses[i];
      exp = visitor.visitAndUpdate(exp, d);
    }
    
    if ((exitValue == null) && (elseClause != null)) {
      elseClause.exp = visitor.visitAndUpdate(elseClause.exp, d);
    }
  }
  


  protected Object calculateDatumValue(Expression datum)
  {
    if ((datum instanceof QuoteExp))
      return value;
    if ((datum instanceof ReferenceExp))
      return ((ReferenceExp)datum).getSymbol();
    throw new Error("Invalid Datum");
  }
  


  protected Type calculateType()
  {
    CaseClause clause = clauses.length > 0 ? clauses[0] : null;
    if (clause != null) {
      Type t = exp.getType();
      
      for (int i = 1; i < clauses.length; i++) {
        clause = clauses[i];
        t = Language.unionType(t, exp.getType());
      }
      
      t = elseClause != null ? Language.unionType(t, elseClause.exp.getType()) : Language.unionType(t, Type.voidType);
    }
    else {
      Type t;
      if (elseClause != null) {
        t = elseClause.exp.getType();
      } else
        throw new Error("Syntax Error: Case without any clause, at least a default clause is required");
    }
    Type t;
    return t;
  }
  





  protected Type calculateDatumsType()
  {
    boolean atLeastOne = clauses.length > 0;
    if (atLeastOne) {
      Type t = calculateDatumType(clauses[0].datums);
      
      for (int i = 1; i < clauses.length; i++) {
        t = Language.unionType(t, calculateDatumType(clauses[i].datums));
      }
    }
    else {
      if (elseClause != null) {
        return Type.voidType;
      }
      throw new Error(); }
    Type t; return t;
  }
  




  private Type calculateDatumType(Expression[] datum)
  {
    Type t = resolveType(calculateDatumValue(datum[0]));
    for (int i = 1; i < datum.length; i++) {
      t = Language.unionType(t, resolveType(calculateDatumValue(datum[i])));
    }
    
    return t;
  }
  





  private Type resolveType(Object o)
  {
    if ((o instanceof IntNum)) {
      IntNum ii = (IntNum)o;
      if (ii.inIntRange())
        return Type.intType;
      if (ii.inLongRange()) {
        return Type.longType;
      }
      return LangObjType.integerType; }
    if ((o instanceof Char))
      return LangPrimType.characterType;
    if ((o instanceof Character)) {
      return LangPrimType.charType;
    }
    return Type.make(o.getClass());
  }
  




  public boolean searchValue(Object keyValue)
  {
    Expression exp = selectCase(keyValue);
    Expression elseExp = elseClause != null ? elseClause.exp : null;
    return (exp != null) && (exp != elseExp);
  }
  




  public Expression selectCase(Object keyValue)
  {
    for (int i = 0; i < clauses.length; i++) {
      Expression[] datums = clauses[i].datums;
      int pos = -1;
      for (int j = 0; j < datums.length; j++) {
        if (IsEqv.apply(keyValue, calculateDatumValue(datums[j])))
          pos = j;
      }
      if (pos >= 0) {
        return clauses[i].exp;
      }
    }
    
    return elseClause != null ? elseClause.exp : null;
  }
}
