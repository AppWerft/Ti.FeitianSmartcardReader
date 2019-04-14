package gnu.kawa.functions;

import gnu.bytecode.CodeAttr;
import gnu.bytecode.Type;
import gnu.expr.ApplyExp;
import gnu.expr.Compilation;
import gnu.expr.Expression;
import gnu.expr.InlineCalls;

public class CompileArith implements gnu.expr.Inlineable
{
  int op;
  gnu.mapping.Procedure proc;
  public static CompileArith $Pl = new CompileArith(AddOp.$Pl, 1);
  public static CompileArith $Mn = new CompileArith(AddOp.$Mn, 2);
  
  CompileArith(Object proc, int op)
  {
    this.proc = ((gnu.mapping.Procedure)proc);
    this.op = op;
  }
  
  public static CompileArith forMul(Object proc)
  {
    return new CompileArith(proc, 3);
  }
  
  public static CompileArith forDiv(Object proc)
  {
    return new CompileArith(proc, op);
  }
  
  public static CompileArith forBitwise(Object proc)
  {
    return new CompileArith(proc, op);
  }
  
  public static boolean appropriateIntConstant(Expression[] args, int iarg, InlineCalls visitor)
  {
    Expression exp = visitor.fixIntValue(args[iarg]);
    if (exp != null)
    {
      args[iarg] = exp;
      return true;
    }
    return false;
  }
  
  public static boolean appropriateLongConstant(Expression[] args, int iarg, InlineCalls visitor)
  {
    Expression exp = visitor.fixLongValue(args[iarg]);
    if (exp != null)
    {
      args[iarg] = exp;
      return true;
    }
    return false;
  }
  
  public static Type combineType(Type t1, Type t2)
  {
    int kind1 = Arithmetic.classifyType(t1);
    int kind2 = Arithmetic.classifyType(t2);
    return Arithmetic.kindType(getReturnKind2(kind1, kind2));
  }
  

  public static Expression validateApplyArithOp(ApplyExp exp, InlineCalls visitor, Type required, gnu.mapping.Procedure proc)
  {
    ArithOp aproc = (ArithOp)proc;
    int op = op;
    exp.visitArgs(visitor);
    
    Expression[] args = exp.getArgs();
    if (args.length > 2) {
      return pairwise(proc, exp.getFunction(), args, visitor);
    }
    int rkind = 0;
    if ((args.length == 2) || (args.length == 1))
    {
      int kind1 = Arithmetic.classifyType(args[0].getType());
      if ((args.length == 2) && ((op < 9) || (op > 12)))
      {


        int kind2 = Arithmetic.classifyType(args[1].getType());
        rkind = getReturnKind(kind1, kind2, op);
        if (rkind == 6)
        {
          if ((kind1 == 1) && (appropriateIntConstant(args, 1, visitor))) {
            rkind = 1;
          } else if ((kind2 == 1) && (appropriateIntConstant(args, 0, visitor))) {
            rkind = 1;
          } else if ((kind1 == 3) && (appropriateLongConstant(args, 1, visitor))) {
            rkind = 3;
          } else if ((kind2 == 3) && (appropriateLongConstant(args, 0, visitor))) {
            rkind = 3;
          }
        }
      }
      else {
        rkind = kind1;
      }
      rkind = adjustReturnKind(rkind, op);
      exp.setType(Arithmetic.kindType(rkind));
    }
    
    Expression folded = exp.inlineIfConstant(proc, visitor);
    if (folded != exp) {
      return folded;
    }
    

    if (!getCompilationmustCompile) {
      return exp;
    }
    switch (op)
    {
    case 1: 
    case 2: 
      return validateApplyAdd((AddOp)proc, exp, visitor);
    case 4: 
    case 5: 
    case 6: 
    case 7: 
    case 8: 
      return validateApplyDiv((DivideOp)proc, exp, visitor);
    case 16: 
      if (rkind > 0)
        return validateApplyNot(exp, rkind, visitor);
      break;
    }
    return exp;
  }
  
  public void compileGeneric(ApplyExp exp, Compilation comp, gnu.expr.Target target)
  {
    Expression[] args = exp.getArgs();
    int len = args.length;
    CodeAttr code = comp.getCode();
    if (len == 2) {
      switch (op) {
      case 1: 
      case 2: 
        code.emitPushInt(op == 1 ? 1 : -1);
        args[0].compile(comp, gnu.expr.Target.pushObject);
        args[1].compile(comp, gnu.expr.Target.pushObject);
        code.emitInvoke(gnu.bytecode.ClassType.make("gnu.kawa.functions.AddOp").getDeclaredMethod("apply2", 3));
        
        target.compileFromStack(comp, Type.objectType);
        return;
      }
    }
    ApplyExp.compile(exp, comp, target);
  }
  
  public void compile(ApplyExp exp, Compilation comp, gnu.expr.Target target)
  {
    Expression[] args = exp.getArgs();
    int len = args.length;
    if (len == 0)
    {
      comp.compileConstant(((ArithOp)proc).defaultResult(), target);
      return;
    }
    if ((len == 1) || ((target instanceof gnu.expr.IgnoreTarget)))
    {

      compileGeneric(exp, comp, target);
      return;
    }
    

    int kind1 = Arithmetic.classifyType(args[0].getType());
    int kind2 = Arithmetic.classifyType(args[1].getType());
    int kind = getReturnKind(kind1, kind2, op);
    Type type = Arithmetic.kindType(kind);
    if ((kind == 0) || (len != 2))
    {
      compileGeneric(exp, comp, target);
      return;
    }
    Type targetType = target.getType();
    int tkind = Arithmetic.classifyType(targetType);
    
    Type wtype;
    
    Type wtype;
    
    if ((tkind >= 1) && (tkind <= 4) && (kind >= 1) && (kind <= 6))
    {

      kind = tkind;
      wtype = Arithmetic.kindType(tkind);
    } else { Type wtype;
      if (((tkind == 10) || (tkind == 9)) && (kind > 4) && (kind <= 12))
      {


        kind = tkind;
        wtype = tkind == 9 ? gnu.kawa.lispexpr.LangPrimType.floatType : gnu.kawa.lispexpr.LangPrimType.doubleType;
      }
      else {
        Type wtype;
        if (kind == 9) {
          wtype = gnu.kawa.lispexpr.LangPrimType.floatType; } else { Type wtype;
          if ((kind == 10) || (kind == 11))
          {
            kind = 10;
            wtype = gnu.kawa.lispexpr.LangPrimType.doubleType;
          }
          else {
            wtype = type;
          } } } }
    if ((op >= 4) && (op <= 8))
    {
      DivideOp dproc = (DivideOp)proc;
      if ((op != 4) || ((kind > 6) && (kind < 8) && (kind > 11)))
      {


        if (((op == 5) && (kind <= 12) && (kind != 9)) || ((op == 4) && (kind == 12)))
        {

          kind = 10;
        } else if (((op != 7) && ((op != 6) || (kind > 6))) || ((dproc.getRoundingMode() != 3) && (kind != 6) && (kind != 9) && (kind != 10)))
        {







          if ((op != 8) || ((dproc.getRoundingMode() != 3) && (kind != 6)))
          {





            compileGeneric(exp, comp, target);
            return;
          } } }
    }
    if ((op == 4) && (kind <= 12) && (kind != 10) && (kind != 9))
    {
      gnu.bytecode.Method meth;
      
      gnu.bytecode.Method meth;
      if ((kind == 8) || (kind > 6))
      {


        gnu.kawa.lispexpr.LangObjType ctype = kind == 8 ? Arithmetic.typeRatNum : Arithmetic.typeRealNum;
        

        wtype = ctype;
        meth = ctype.getDeclaredMethod("divide", 2);
      }
      else
      {
        wtype = Arithmetic.typeIntNum;
        meth = Arithmetic.typeRatNum.getDeclaredMethod("make", 2);
      }
      gnu.expr.Target wtarget = gnu.expr.StackTarget.getInstance(wtype);
      args[0].compile(comp, wtarget);
      args[1].compile(comp, wtarget);
      comp.getCode().emitInvokeStatic(meth);
    }
    else if ((kind == 6) && ((op == 1) || (op == 3) || (op == 2) || (op == 13) || (op == 14) || (op == 15) || (op == 7) || (op == 8) || ((op >= 9) && (op <= 11))))
    {




      compileIntNum(args[0], args[1], kind1, kind2, comp);
    }
    else if ((kind == 1) || (kind == 3) || (((kind != 2) && (kind != 4)) || ((op == 1) || (op == 2) || (op == 3) || ((op >= 9) && (op <= 12)) || (op == 13) || (op == 14) || (op == 15) || (((kind == 9) || (kind == 10)) && ((op <= 8) || (op >= 13))))))
    {








      gnu.expr.Target wtarget = gnu.expr.StackTarget.getInstance(wtype);
      
      CodeAttr code = comp.getCode();
      for (int i = 0; i < len; i++)
      {
        if ((i == 1) && (op >= 9) && (op <= 12))
          wtarget = gnu.expr.StackTarget.getInstance(Type.intType);
        args[i].compile(comp, wtarget);
        if (i != 0)
        {
          if (op == 9) {
            String mname;
            switch (kind) {
            case 1: 
            case 3: 
              mname = "shift";
              break;
            case 2: 
            case 4: 
              mname = "shiftUnsigned";
              break;
            default: 
              mname = null;
            }
            Type[] margs = { wtype, Type.intType };
            gnu.bytecode.Method method = gnu.bytecode.ClassType.make("gnu.math.BitOps").getDeclaredMethod(mname, margs);
            
            code.emitInvokeStatic(method);
          } else {
            switch (kind) {
            case 2: 
            case 4: 
              if (op == 11) {
                op = 12;
              }
            case 1: 
            case 3: 
            case 9: 
            case 10: 
              code.emitBinop(primitiveOpcode(), (gnu.bytecode.PrimType)wtype.getImplementationType());
            }
          }
        }
      }
    }
    else
    {
      compileGeneric(exp, comp, target);
      return;
    }
    target.compileFromStack(comp, wtype);
  }
  


  public boolean compileIntNum(Expression arg1, Expression arg2, int kind1, int kind2, Compilation comp)
  {
    if ((op == 2) && ((arg2 instanceof gnu.expr.QuoteExp)))
    {
      Object val = arg2.valueIfConstant();
      boolean negateOk;
      boolean negateOk;
      long lval; if (kind2 <= 4)
      {
        long lval = ((Number)val).longValue();
        negateOk = (kind2 == 4 ? lval >= 0L : lval > -2147483648L) && (lval <= 2147483647L);
      }
      else {
        boolean negateOk;
        if ((val instanceof gnu.math.IntNum))
        {
          gnu.math.IntNum ival = (gnu.math.IntNum)val;
          long lval = ival.longValue();
          negateOk = ival.inRange(-2147483647L, 2147483647L);
        }
        else
        {
          negateOk = false;
          lval = 0L;
        } }
      if (negateOk) {
        return $Pl.compileIntNum(arg1, gnu.expr.QuoteExp.getInstance(Integer.valueOf((int)-lval)), kind1, 1, comp);
      }
    }
    

    boolean addOrMul = (op == 1) || (op == 3);
    Type type2;
    Type type2;
    Type type1; boolean swap; if (addOrMul)
    {
      if (InlineCalls.checkIntValue(arg1) != null)
        kind1 = 1;
      if (InlineCalls.checkIntValue(arg2) != null)
        kind2 = 1;
      boolean swap = (kind1 == 1) && (kind2 != 1);
      if ((swap) && ((!arg1.side_effects()) || (!arg2.side_effects())))
        return compileIntNum(arg2, arg1, kind2, kind1, comp);
      Type type1 = kind1 == 1 ? Type.intType : Arithmetic.typeIntNum;
      type2 = kind2 == 1 ? Type.intType : Arithmetic.typeIntNum;
    } else { boolean swap;
      if ((op >= 9) && (op <= 12))
      {
        Type type1 = Arithmetic.typeIntNum;
        Type type2 = Type.intType;
        swap = false;
      }
      else
      {
        type1 = type2 = Arithmetic.typeIntNum;
        swap = false;
      } }
    arg1.compile(comp, type1);
    arg2.compile(comp, type2);
    CodeAttr code = comp.getCode();
    if (swap)
    {
      code.emitSwap();
      type1 = Arithmetic.typeIntNum;
      type2 = gnu.kawa.lispexpr.LangPrimType.intType;
    }
    String mname = null;
    Type[] argTypes = null;
    gnu.bytecode.ObjectType mclass = Arithmetic.typeIntNum;
    switch (op) {
    case 1: 
      mname = "add"; break;
    case 2:  mname = "sub"; break;
    case 3:  mname = "times"; break;
    case 13: 
      mname = "and";
    
    case 14: 
      if (mname == null) {
        mname = "ior";
      }
    case 15: 
      if (mname == null)
        mname = "xor";
      mclass = gnu.bytecode.ClassType.make("gnu.math.BitOps");
      break;
    case 4: 
    case 5: 
    case 6: 
    case 7: 
    case 8: 
      mname = op == 8 ? "remainder" : "quotient";
      DivideOp dproc = (DivideOp)proc;
      if ((op == 8) && (rounding_mode == 1)) {
        mname = "modulo";
      } else if (rounding_mode != 3)
      {
        code.emitPushInt(rounding_mode);
        argTypes = new Type[] { type1, type2, Type.intType };
      }
      break;
    case 10: 
    case 11: 
      mname = op == 10 ? "shiftLeft" : "shiftRight";
      mclass = gnu.bytecode.ClassType.make("gnu.kawa.functions.BitwiseOp");
      break;
    case 9: 
      mname = "shift";
      break; }
    throw new Error();
    
    if (argTypes == null)
      argTypes = new Type[] { type1, type2 };
    gnu.bytecode.Method meth = mclass.getMethod(mname, argTypes);
    code.emitInvokeStatic(meth);
    return true;
  }
  
  public static int getReturnKind(int kind1, int kind2, int op)
  {
    if ((op >= 9) && (op <= 12))
      return kind1;
    return getReturnKind2(kind1, kind2);
  }
  












  private static int getReturnKind2(int kind1, int kind2)
  {
    return (kind1 <= 0) || ((kind1 > kind2) && (kind2 > 0)) ? kind1 : kind2;
  }
  



  public int getReturnKind(Expression[] args)
  {
    int len = args.length;
    if (len == 0)
      return 6;
    Type type = Type.pointer_type;
    int kindr = 0;
    for (int i = 0; i < len; i++)
    {
      Expression arg = args[i];
      int kind = Arithmetic.classifyType(arg.getType());
      
      if ((i == 0) || (kind == 0) || (kind > kindr))
        kindr = kind;
    }
    return kindr;
  }
  

  public Type getReturnType(Expression[] args)
  {
    return Arithmetic.kindType(adjustReturnKind(getReturnKind(args), op));
  }
  
  static int adjustReturnKind(int rkind, int op)
  {
    if ((op >= 4) && (op <= 7) && (rkind > 0))
    {
      switch (op)
      {
      case 4: 
        if (rkind <= 6)
          rkind = 8;
        break;
      case 5: 
        if ((rkind <= 12) && (rkind != 9))
        {
          rkind = 10; }
        break;
      case 7: 
        if (rkind <= 12)
          rkind = 6;
        break;
      }
    }
    return rkind;
  }
  
  public static Expression validateApplyAdd(AddOp proc, ApplyExp exp, InlineCalls visitor)
  {
    Expression[] args = exp.getArgs();
    if ((args.length == 1) && (plusOrMinus < 0))
    {
      Type type0 = args[0].getType();
      if ((type0 instanceof gnu.bytecode.PrimType))
      {
        char sig0 = type0.getSignature().charAt(0);
        Type type = null;
        int opcode = 0;
        if ((sig0 != 'V') && (sig0 != 'Z') && (sig0 != 'C'))
        {


          if (sig0 == 'D')
          {
            opcode = 119;
            type = gnu.kawa.lispexpr.LangPrimType.doubleType;
          }
          else if (sig0 == 'F')
          {
            opcode = 118;
            type = gnu.kawa.lispexpr.LangPrimType.floatType;
          }
          else if (sig0 == 'J')
          {
            opcode = 117;
            type = gnu.kawa.lispexpr.LangPrimType.longType;
          }
          else
          {
            opcode = 116;
            type = gnu.kawa.lispexpr.LangPrimType.intType;
          } }
        if (type != null)
        {
          gnu.expr.PrimProcedure prim = gnu.expr.PrimProcedure.makeBuiltinUnary(opcode, type);
          
          return new ApplyExp(prim, args);
        }
      }
    }
    return exp;
  }
  

  public static Expression validateApplyDiv(DivideOp proc, ApplyExp exp, InlineCalls visitor)
  {
    Expression[] args = exp.getArgs();
    if (args.length == 1)
    {
      args = new Expression[] { gnu.expr.QuoteExp.getInstance(gnu.math.IntNum.one()), args[0] };
      exp = new ApplyExp(exp.getFunction(), args);
    }
    return exp;
  }
  
  public static Expression validateApplyNot(ApplyExp exp, int kind, InlineCalls visitor)
  {
    if (exp.getArgCount() == 1)
    {
      Expression arg = exp.getArg(0);
      if ((kind == 1) || (kind == 3))
      {
        Expression[] args = { arg, gnu.expr.QuoteExp.getInstance(gnu.math.IntNum.minusOne()) };
        return visitor.visitApplyOnly(new ApplyExp(BitwiseOp.xor, args), null); }
      String cname;
      String cname;
      if (kind == 6) {
        cname = "gnu.math.BitOps"; } else { String cname;
        if (kind == 5) {
          cname = "java.meth.BigInteger";
        } else
          cname = null; }
      if (cname != null) {
        return new ApplyExp(gnu.bytecode.ClassType.make(cname).getDeclaredMethod("not", 1), exp.getArgs());
      }
    }
    return exp;
  }
  
  public int primitiveOpcode()
  {
    switch (op) {
    case 1: 
      return 96;
    case 2:  return 100;
    case 3:  return 104;
    case 4: 
    case 5: 
    case 6: 
    case 7: 
      return 108;
    case 8:  return 112;
    case 10:  return 120;
    case 11:  return 122;
    case 12:  return 124;
    case 13:  return 126;
    case 14:  return 128;
    case 15:  return 130; }
    return -1;
  }
  





  public static Expression pairwise(gnu.mapping.Procedure proc, Expression rproc, Expression[] args, InlineCalls visitor)
  {
    int len = args.length;
    Expression prev = args[0];
    for (int i = 1; i < len; i++)
    {
      Expression[] args2 = new Expression[2];
      args2[0] = prev;
      args2[1] = args[i];
      ApplyExp next = new ApplyExp(rproc, args2);
      Expression inlined = visitor.maybeInline(next, null, proc);
      prev = inlined != null ? inlined : next;
    }
    return prev;
  }
}
