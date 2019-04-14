package gnu.kawa.functions;

import gnu.bytecode.CodeAttr;
import gnu.bytecode.Type;
import gnu.expr.ApplyExp;
import gnu.expr.Compilation;
import gnu.expr.Expression;

public class CompileMisc
{
  static gnu.bytecode.ClassType typeType;
  static gnu.bytecode.Method coerceMethod;
  
  public CompileMisc() {}
  
  public static Expression validateApplyConstantFunction0(ApplyExp exp, gnu.expr.InlineCalls visitor, Type required, gnu.mapping.Procedure proc)
  {
    exp.visitArgs(visitor);
    int nargs = exp.getArgCount();
    if ((nargs != 0) && (visitor != null))
    {
      String message = gnu.mapping.WrongArguments.checkArgCount(proc, nargs, false);
      return visitor.noteError(message);
    }
    return constant;
  }
  

  public static Expression validateApplyConvert(ApplyExp exp, gnu.expr.InlineCalls visitor, Type required, gnu.mapping.Procedure proc)
  {
    Compilation comp = visitor.getCompilation();
    gnu.expr.Language language = comp.getLanguage();
    Convert cproc = (Convert)proc;
    Expression[] args = exp.getArgs();
    if (args.length == 2)
    {
      args[0] = visitor.visit(args[0], null);
      Type type = language.getTypeFor(args[0]);
      if ((type instanceof Type))
      {
        args[0] = new gnu.expr.QuoteExp(type);
        Type xtype = lenient ? gnu.expr.InlineCalls.LenientExpectedType.make(type) : type;
        
        if (!args[1].getFlag(1))
          args[1] = ((Expression)gnu.expr.ExpVisitor.visit(visitor, args[1], xtype));
        args[1] = visitor.checkType(args[1], xtype);
        gnu.kawa.reflect.CompileReflect.checkKnownClass(type, comp);
        exp.setType(type);
        Type argType = args[1].getType();
        if ((argType != Type.nullType) && (type.isCompatibleWithValue(argType) == 2))
        {
          return args[1]; }
        return exp;
      }
    }
    exp.visitArgs(visitor);
    return exp;
  }
  

  public static Expression validateApplySimpleBoolean(ApplyExp exp, gnu.expr.InlineCalls visitor, Type required, gnu.mapping.Procedure proc)
  {
    exp.visitArgs(visitor);
    exp.setType(visitor.getCompilation().getLanguage().getTypeFor(Boolean.TYPE));
    return exp.inlineIfConstant(proc, visitor);
  }
  




  public static Expression validateApplyFormat(ApplyExp exp, gnu.expr.InlineCalls visitor, Type required, gnu.mapping.Procedure proc)
  {
    exp.visitArgs(visitor);
    Type retType = Type.objectType;
    Expression[] args = exp.getArgs();
    if (args.length > 0)
    {
      gnu.bytecode.ClassType typeFormat = gnu.bytecode.ClassType.make("gnu.kawa.functions.Format");
      Object f = args[0].valueIfConstant();
      Type ftype = args[0].getType();
      if ((f == Boolean.FALSE) || (ftype.isSubtype(gnu.kawa.lispexpr.LangObjType.stringType)))
      {
        int skip = f == Boolean.FALSE ? 1 : 0;
        if ((skip > 0) && (args.length > 1))
          f = args[1].valueIfConstant();
        if (((f instanceof CharSequence)) && (!(f instanceof String))) {
          f = f.toString();
          args[skip] = gnu.expr.QuoteExp.getInstance(f);
        }
        Expression[] xargs = new Expression[args.length + 1 - skip];
        xargs[0] = new gnu.expr.QuoteExp(Integer.valueOf(0), Type.intType);
        System.arraycopy(args, skip, xargs, 1, xargs.length - 1);
        ApplyExp ae = new ApplyExp(typeFormat.getDeclaredMethod("formatToString", 2), xargs);
        ae.setLine(exp);
        ae.setType(Type.javalangStringType);
        return ae;
      }
      if (((f == Boolean.TRUE) || (ftype.isSubtype(gnu.bytecode.ClassType.make("java.io.Writer")))) && (args.length > 1))
      {

        if (f == Boolean.TRUE)
        {
          Expression[] xargs = new Expression[args.length];
          xargs[0] = gnu.expr.QuoteExp.nullExp;
          System.arraycopy(args, 1, xargs, 1, args.length - 1);
          args = xargs;
        }
        f = args[1].valueIfConstant();
        if (((f instanceof CharSequence)) && (!(f instanceof String))) {
          f = f.toString();
          args[1] = gnu.expr.QuoteExp.getInstance(f);
        }
        ApplyExp ae = new ApplyExp(typeFormat.getDeclaredMethod("formatToWriter", 3), args);
        ae.setLine(exp);
        ae.setType(Type.voidType);
        return ae;
      }
      if (ftype.isSubtype(gnu.bytecode.ClassType.make("java.io.OutputStream")))
        retType = Type.voidType;
    }
    exp.setType(retType);
    return null;
  }
  

  public static Expression validateApplyAppendValues(ApplyExp exp, gnu.expr.InlineCalls visitor, Type required, gnu.mapping.Procedure proc)
  {
    exp.visitArgs(visitor);
    Expression[] args = exp.getArgs();
    int nargs = args.length;
    if (nargs == 1)
      return args[0];
    if (nargs == 0)
      return gnu.expr.QuoteExp.voidExp;
    Expression folded = exp.inlineIfConstant(proc, visitor);
    if (folded.valueIfConstant() == gnu.mapping.Values.empty) {
      folded = gnu.expr.QuoteExp.voidObjectExp;
    } else if (folded == exp) {
      args = exp.getArgs();
      Type typeSoFar = Type.voidType;
      for (int i = 0; i < nargs; i++) {
        Type atype = args[i].getType();
        if (gnu.kawa.reflect.OccurrenceType.itemCountCode(atype) != '0')
        {
          if (typeSoFar == Type.voidType) {
            typeSoFar = atype;
          } else
            typeSoFar = Type.objectType; }
      }
      exp.setType(typeSoFar);
    }
    return folded;
  }
  

  public static Expression validateApplyMakeProcedure(ApplyExp exp, gnu.expr.InlineCalls visitor, Type required, gnu.mapping.Procedure proc)
  {
    exp.visitArgs(visitor);
    Expression[] args = exp.getArgs();
    int alen = args.length;
    Expression method = null;
    int countMethods = 0;
    String name = null;
    for (int i = 0; i < alen; i++)
    {
      Expression arg = args[i];
      gnu.expr.Keyword key = arg.checkLiteralKeyword();
      if (key != null)
      {
        String keyword = key.getName();
        Expression next = args[(++i)];
        if (keyword == "name")
        {
          if ((next instanceof gnu.expr.QuoteExp)) {
            name = ((gnu.expr.QuoteExp)next).getValue().toString();
          }
        } else if (keyword == "method")
        {
          countMethods++;
          method = next;
        }
        

      }
      else
      {
        countMethods++;
        method = arg;
      }
    }
    if ((countMethods == 1) && ((method instanceof gnu.expr.LambdaExp)))
    {
      gnu.expr.LambdaExp lexp = (gnu.expr.LambdaExp)method;
      for (int i = 0; i < alen; i++)
      {
        Expression arg = args[i];
        gnu.expr.Keyword key = arg.checkLiteralKeyword();
        if (key != null)
        {
          String keyword = key.getName();
          Expression next = args[(++i)];
          if (keyword == "name") {
            lexp.setName(name);
          } else if (keyword != "method")
          {

            lexp.setProperty(gnu.mapping.Namespace.EmptyNamespace.getSymbol(keyword), next); }
        }
      }
      return method;
    }
    return exp;
  }
  

  public static Expression validateApplyValuesMap(ApplyExp exp, gnu.expr.InlineCalls visitor, Type required, gnu.mapping.Procedure proc)
  {
    gnu.expr.LambdaExp lexp = ValuesMap.canInline(exp, (ValuesMap)proc);
    


    exp.visitArgs(visitor);
    if (lexp != null)
      lexp.setInlineOnly(exp, visitor.getCurrentLambda());
    return exp;
  }
  



  public static boolean compileConvert(ApplyExp exp, Compilation comp, gnu.expr.Target target, gnu.mapping.Procedure procedure)
  {
    Convert proc = (Convert)procedure;
    Expression[] args = exp.getArgs();
    if ((args.length != 2) || (!exp.isSimple()))
      return false;
    CodeAttr code = comp.getCode();
    Type type = kawa.standard.Scheme.getTypeValue(args[0]);
    if (type == Type.neverReturnsType) {
      args[1].compile(comp, gnu.expr.Target.Ignore);
      gnu.expr.PrimProcedure.compileReachedUnexpected(code);
    } else if (type != null) {
      args[1].compile(comp, gnu.expr.Target.pushValue(type));
      if ((code.reachableHere()) && (!type.isVoid())) {
        target.compileFromStack(comp, type);
      }
    } else {
      if (typeType == null) {
        typeType = gnu.bytecode.ClassType.make("gnu.bytecode.Type");
      }
      if (coerceMethod == null) {
        coerceMethod = typeType.addMethod("coerceFromObject", Compilation.apply1args, Type.pointer_type, 1);
      }
      


      args[0].compile(comp, gnu.kawa.lispexpr.LangObjType.typeClassType);
      args[1].compile(comp, gnu.expr.Target.pushObject);
      code.emitInvokeVirtual(coerceMethod);
      target.compileFromStack(comp, Type.pointer_type);
    }
    return true;
  }
  
  public static boolean compileNot(ApplyExp exp, Compilation comp, gnu.expr.Target target, gnu.mapping.Procedure procedure)
  {
    if (!exp.isSimple())
      return false;
    Not proc = (Not)procedure;
    Expression arg = exp.getArgs()[0];
    gnu.expr.Language language = language;
    if ((target instanceof gnu.expr.ConditionalTarget)) {
      gnu.expr.ConditionalTarget ctarget = (gnu.expr.ConditionalTarget)target;
      gnu.expr.ConditionalTarget sub_target = new gnu.expr.ConditionalTarget(ifFalse, ifTrue, language);
      

      trueBranchComesFirst = (!trueBranchComesFirst);
      arg.compile(comp, sub_target);
      return true;
    }
    CodeAttr code = comp.getCode();
    Type type = target.getType();
    gnu.expr.QuoteExp falseExp;
    gnu.expr.QuoteExp trueExp; gnu.expr.QuoteExp falseExp; if (((target instanceof gnu.expr.StackTarget)) && (type.getSignature().charAt(0) == 'Z'))
    {
      gnu.expr.QuoteExp trueExp = gnu.expr.QuoteExp.trueExp;
      falseExp = gnu.expr.QuoteExp.falseExp;
    } else {
      trueExp = gnu.expr.QuoteExp.getInstance(language.booleanObject(true));
      falseExp = gnu.expr.QuoteExp.getInstance(language.booleanObject(false));
    }
    gnu.expr.IfExp.compile(arg, falseExp, trueExp, comp, target);
    return true;
  }
  
  public static boolean compileEq(ApplyExp exp, Compilation comp, gnu.expr.Target target, gnu.mapping.Procedure proc)
  {
    if (!exp.isSimple())
      return false;
    Expression[] args = exp.getArgs();
    gnu.expr.Language language = language;
    CodeAttr code = comp.getCode();
    Expression arg0 = args[0];
    Expression arg1 = args[1];
    if (arg0 == gnu.expr.QuoteExp.nullExp) {
      Expression tmp = arg1;arg1 = arg0;arg0 = tmp;
    }
    arg0.compile(comp, gnu.expr.Target.pushObject);
    boolean isNull = arg1 == gnu.expr.QuoteExp.nullExp;
    if (!isNull) {
      arg1.compile(comp, gnu.expr.Target.pushObject);
    }
    if ((target instanceof gnu.expr.ConditionalTarget)) {
      gnu.expr.ConditionalTarget ctarget = (gnu.expr.ConditionalTarget)target;
      if (trueBranchComesFirst) {
        if (isNull) {
          code.emitGotoIfNonNull(ifFalse);
        } else {
          code.emitGotoIfNE(ifFalse);
        }
      } else if (isNull) {
        code.emitGotoIfNull(ifTrue);
      } else {
        code.emitGotoIfEq(ifTrue);
      }
      ctarget.emitGotoFirstBranch(code);

    }
    else
    {
      if (isNull) {
        code.emitIfNull();
      } else
        code.emitIfEq();
      Type type;
      Type type; if ((target.getType() instanceof gnu.bytecode.ClassType))
      {
        Object trueValue = language.booleanObject(true);
        Object falseValue = language.booleanObject(false);
        comp.compileConstant(trueValue, gnu.expr.Target.pushObject);
        code.emitElse();
        comp.compileConstant(falseValue, gnu.expr.Target.pushObject);
        Type type; if (((trueValue instanceof Boolean)) && ((falseValue instanceof Boolean))) {
          type = Compilation.scmBooleanType;
        } else {
          type = Type.pointer_type;
        }
      }
      else {
        code.emitPushInt(1);
        code.emitElse();
        code.emitPushInt(0);
        type = language.getTypeFor(Boolean.TYPE);
      }
      code.emitFi();
      target.compileFromStack(comp, type);
    }
    return true;
  }
  
  public static boolean compileNumberCompare(ApplyExp exp, Compilation comp, gnu.expr.Target target, gnu.mapping.Procedure procedure) {
    NumberCompare proc = (NumberCompare)procedure;
    if (!exp.isSimple())
      return false;
    CodeAttr code = comp.getCode();
    Expression[] args = exp.getArgs();
    if (args.length == 2) {
      Expression arg0 = args[0];
      Expression arg1 = args[1];
      int kind0 = classifyForNumCompare(arg0);
      int kind1 = classifyForNumCompare(arg1);
      if ((kind0 > 0) && (kind1 > 0) && (kind0 <= 12) && (kind1 <= 12) && ((kind0 != 8) || (kind1 != 8)))
      {


        if (!(target instanceof gnu.expr.ConditionalTarget)) {
          gnu.expr.IfExp.compile(exp, gnu.expr.QuoteExp.trueExp, gnu.expr.QuoteExp.falseExp, comp, target);
          
          return true;
        }
        int mask = flags;
        if (mask == 1)
          mask = 20;
        if ((kind0 <= 6) && (kind1 <= 6) && ((kind0 > 3) || (kind1 > 3)) && ((kind0 != 4) || (kind1 != 4)))
        {








          Type[] ctypes = new Type[2];
          ctypes[0] = Arithmetic.typeIntNum;
          if (kind1 <= 3) {
            ctypes[1] = Type.longType;
          } else if ((kind0 <= 3) && (((arg0 instanceof gnu.expr.QuoteExp)) || ((arg1 instanceof gnu.expr.QuoteExp)) || ((arg0 instanceof gnu.expr.ReferenceExp)) || ((arg1 instanceof gnu.expr.ReferenceExp))))
          {




            ctypes[1] = Type.longType;
            args = new Expression[2];
            args[0] = arg1;
            args[1] = arg0;
            if ((mask != 8) && (mask != 20))
              mask ^= 0x14;
          } else {
            ctypes[1] = Arithmetic.typeIntNum; }
          gnu.bytecode.Method cmeth = Arithmetic.typeIntNum.getMethod("compare", ctypes);
          
          gnu.expr.PrimProcedure compare = new gnu.expr.PrimProcedure(cmeth, comp.getLanguage());
          
          arg0 = new ApplyExp(compare, args);
          arg1 = new gnu.expr.QuoteExp(gnu.math.IntNum.zero());
          kind0 = kind1 = 1; }
        Type commonType;
        Type commonType;
        if ((kind0 <= 1) && (kind1 <= 1)) {
          commonType = Type.intType; } else { Type commonType;
          if ((kind0 <= 2) && (kind1 <= 2))
          {
            if ((kind0 <= 1) || (kind1 <= 1))
            {

              Type commonType = Type.longType;
              kind0 = kind1 = 3;
            }
            else {
              Expression signBit = gnu.expr.QuoteExp.makeShared(Integer.valueOf(Integer.MIN_VALUE), Type.intType);
              

              arg0 = new ApplyExp(AddOp.$Pl, new Expression[] { arg0, signBit });
              arg1 = new ApplyExp(AddOp.$Pl, new Expression[] { arg1, signBit });
              kind0 = kind1 = 1;
              commonType = Type.intType;
            } } else { Type commonType;
            if ((kind0 <= 3) && (kind1 <= 3))
            {
              commonType = Type.longType; } else { Type commonType;
              if ((kind0 <= 4) && (kind1 <= 4))
              {


                Expression signBit = gnu.expr.QuoteExp.makeShared(Long.valueOf(Long.MIN_VALUE), Type.longType);
                
                arg0 = new ApplyExp(AddOp.$Pl, new Expression[] { arg0, signBit });
                arg1 = new ApplyExp(AddOp.$Pl, new Expression[] { arg1, signBit });
                kind0 = kind1 = 3;
                commonType = Type.longType;
              } else {
                commonType = Type.doubleType; } } } }
        gnu.expr.StackTarget subTarget = new gnu.expr.StackTarget(commonType);
        gnu.expr.ConditionalTarget ctarget = (gnu.expr.ConditionalTarget)target;
        

        if (((arg0 instanceof gnu.expr.QuoteExp)) && (!(arg1 instanceof gnu.expr.QuoteExp))) {
          Expression tmp = arg1;arg1 = arg0;arg0 = tmp;
          if ((mask != 8) && (mask != 20))
            mask ^= 0x14;
        }
        gnu.bytecode.Label label1 = trueBranchComesFirst ? ifFalse : ifTrue;
        if (trueBranchComesFirst)
          mask ^= 0x1C;
        int opcode; switch (mask) {
        case 16: 
          opcode = 157; break;
        case 8: 
          opcode = 153; break;
        case 4: 
          opcode = 155; break;
        case 20: 
          opcode = 154; break;
        case 24: 
          opcode = 156; break;
        case 12: 
          opcode = 158; break;
        default: 
          opcode = 0;
        }
        arg0.compile(comp, subTarget);
        Object value;
        if ((kind0 <= 1) && (kind1 <= 1) && ((arg1 instanceof gnu.expr.QuoteExp)) && (((value = ((gnu.expr.QuoteExp)arg1).getValue()) instanceof gnu.math.IntNum)) && (((gnu.math.IntNum)value).isZero()))
        {


          code.emitGotoIfCompare1(label1, opcode);
        } else {
          arg1.compile(comp, subTarget);
          code.emitGotoIfCompare2(label1, opcode);
        }
        ctarget.emitGotoFirstBranch(code);
        return true;
      }
    }
    
    String mname;
    switch (flags) {
    case 16: 
      mname = "$Gr"; break;
    case 8: 
      mname = "$Eq"; break;
    case 4: 
      mname = "$Ls"; break;
    case 24: 
      mname = "$Gr$Eq"; break;
    case 12: 
      mname = "$Ls$Eq"; break;
    default: 
      mname = null;
    }
    if (mname != null) {
      gnu.bytecode.ClassType compclass = gnu.bytecode.ClassType.make("gnu.kawa.functions.NumberCompare");
      
      gnu.bytecode.Method meth = args.length == 2 ? compclass.getDeclaredMethod(mname, 2) : compclass.getDeclaredMethod(mname + "$V", 4);
      

      new ApplyExp(meth, args).setLine(exp).compile(comp, target);
      
      return true;
    }
    return false;
  }
  
  static int classifyForNumCompare(Expression exp)
  {
    Type type = exp.getType();
    int kind = Arithmetic.classifyType(type);
    Object value;
    if ((kind == 6) && ((exp instanceof gnu.expr.QuoteExp)) && (((value = ((gnu.expr.QuoteExp)exp).getValue()) instanceof gnu.math.IntNum)))
    {

      int ilength = ((gnu.math.IntNum)value).intLength();
      if (ilength < 32)
        return 1;
      if (ilength < 64)
        return 3;
    }
    return kind;
  }
  

  public static boolean compileNumPredicate(ApplyExp exp, Compilation comp, gnu.expr.Target target, gnu.mapping.Procedure procedure)
  {
    NumberPredicate proc = (NumberPredicate)procedure;
    if (!exp.isSimple())
      return false;
    Expression[] args = exp.getArgs();
    int op = op;
    if ((args.length == 1) && ((op == 1) || (op == 2)))
    {
      Expression arg0 = args[0];
      int kind = Arithmetic.classifyType(arg0.getType());
      CodeAttr code = comp.getCode();
      if (kind <= 6) {
        gnu.bytecode.PrimType wtype = Type.intType;
        gnu.expr.Target wtarget = gnu.expr.StackTarget.getInstance(wtype);
        if (op == 2)
          code.emitPushInt(1);
        arg0.compile(comp, wtarget);
        code.emitPushInt(1);
        code.emitAnd();
        if (op == 2)
          code.emitSub(Type.intType);
      } else {
        arg0.compile(comp, gnu.expr.Target.pushObject);
        String mname = op == 2 ? "isEven" : "isOdd";
        gnu.bytecode.Method m = gnu.bytecode.ClassType.make("gnu.kawa.functions.NumberPredicate").getDeclaredMethod(mname, 1);
        

        code.emitInvokeStatic(m);
      }
      target.compileFromStack(comp, Type.booleanType);
      return true;
    }
    return false;
  }
  

  public static Expression validateApplyCallCC(ApplyExp exp, gnu.expr.InlineCalls visitor, Type required, gnu.mapping.Procedure proc)
  {
    gnu.expr.LambdaExp lexp = canInlineCallCC(exp);
    if (lexp != null)
    {
      lexp.setInlineOnly(exp, visitor.getCurrentLambda());
      gnu.expr.Declaration contDecl = lexp.firstDecl();
      if (!contDecl.getFlag(8192L))
        contDecl.setType(typeContinuation);
      contDecl.setFlag(1099511627776L);
      gnu.expr.LambdaExp.maybeSetReturnType(lexp, required);
    }
    

    exp.visitArgs(visitor);
    return exp;
  }
  
  public static final gnu.bytecode.ClassType typeContinuation = gnu.bytecode.ClassType.make("kawa.lang.Continuation");
  

  public static void compileCallCC(ApplyExp exp, Compilation comp, gnu.expr.Target target, gnu.mapping.Procedure proc)
  {
    gnu.expr.LambdaExp lambda = canInlineCallCC(exp);
    if (lambda == null)
    {
      ApplyExp.compile(exp, comp, target);
      return;
    }
    CodeAttr code = comp.getCode();
    gnu.expr.Declaration param = lambda.firstDecl();
    if ((param.isSimple()) && (!param.getCanRead()) && (!param.getCanWrite()))
    {
      param.setCanCall(false);
      CompileTimeContinuation contProxy = new CompileTimeContinuation();
      Type rtype = (target instanceof gnu.expr.StackTarget) ? target.getType() : null;
      boolean runFinallyBlocks = ExitThroughFinallyChecker.check(param, body);
      
      gnu.bytecode.ExitableBlock bl = code.startExitableBlock(rtype, runFinallyBlocks);
      exitableBlock = bl;
      blockTarget = target;
      param.setValue(new gnu.expr.QuoteExp(contProxy));
      new ApplyExp(lambda, new Expression[] { gnu.expr.QuoteExp.nullExp }).compile(comp, target);
      code.endExitableBlock();
      return;
    }
    
    gnu.bytecode.Scope sc = code.pushScope();
    gnu.bytecode.Variable contVar = sc.addVariable(code, typeContinuation, null);
    gnu.expr.Declaration contDecl = new gnu.expr.Declaration(contVar);
    code.emitNew(typeContinuation);
    code.emitDup(typeContinuation);
    comp.loadCallContext();
    code.emitInvokeSpecial(typeContinuation.getDeclaredMethod("<init>", 1));
    code.emitStore(contVar);
    code.emitTryStart(false, ((target instanceof gnu.expr.IgnoreTarget)) || ((target instanceof gnu.expr.ConsumerTarget)) ? null : target.getType().getRawType());
    ApplyExp app = new ApplyExp(lambda, new Expression[] { new gnu.expr.ReferenceExp(contDecl) });
    app.compile(comp, target);
    
    if (code.reachableHere())
    {
      code.emitLoad(contVar);
      code.emitPushInt(1);
      code.emitPutField(typeContinuation.getField("invoked"));
    }
    

    code.emitCatchStart((gnu.bytecode.ClassType)null);
    code.emitLoad(contVar);
    if ((target instanceof gnu.expr.ConsumerTarget))
    {
      comp.loadCallContext();
      gnu.bytecode.Method handleMethod = typeContinuation.getDeclaredMethod("handleException$X", 3);
      code.emitInvokeStatic(handleMethod);
    }
    else
    {
      gnu.bytecode.Method handleMethod = typeContinuation.getDeclaredMethod("handleException", 2);
      code.emitInvokeStatic(handleMethod);
      target.compileFromStack(comp, Type.objectType);
    }
    code.emitCatchEnd();
    
    code.emitTryCatchEnd();
    code.popScope();
  }
  

  private static gnu.expr.LambdaExp canInlineCallCC(ApplyExp exp)
  {
    Expression[] args = exp.getArgs();
    Expression arg0;
    if ((args.length == 1) && (((arg0 = args[0]) instanceof gnu.expr.LambdaExp)) && (!Compilation.enableANF))
    {

      gnu.expr.LambdaExp lexp = (gnu.expr.LambdaExp)arg0;
      if ((min_args == 1) && (max_args == 1) && (!lexp.firstDecl().getCanWrite()))
      {

        return lexp;
      }
    }
    return null;
  }
  
  public static Expression validateApplyWithExceptionHandler(ApplyExp exp, gnu.expr.InlineCalls visitor, Type required, gnu.mapping.Procedure proc)
  {
    Expression[] args = exp.getArgs();
    Expression handler = visitor.visit(args[0], null);
    args[0] = handler;
    Expression thunk = args[1];
    if ((thunk instanceof gnu.expr.LambdaExp)) {
      gnu.expr.LambdaExp lthunk = (gnu.expr.LambdaExp)thunk;
      if ((min_args == 0) && (max_args == 0)) {
        gnu.expr.LambdaExp.maybeSetReturnType(lthunk, required);
        thunk = visitor.visit(lthunk, required);
        args[1] = thunk;
        










        Compilation comp = visitor.getCompilation();
        comp.letStart();
        gnu.bytecode.ClassType handlerLinkType = gnu.bytecode.ClassType.make("kawa.lib.HandlerLink");
        
        gnu.bytecode.Method pushMethod = handlerLinkType.getDeclaredMethod("push", 1);
        
        gnu.bytecode.Method popMethod = handlerLinkType.getDeclaredMethod("pop", 0);
        
        gnu.expr.Declaration linkDecl = comp.letVariable(null, handlerLinkType, new ApplyExp(pushMethod, new Expression[] { handler }));
        

        comp.letEnter();
        
        Type bodyType = lthunk.getReturnType();
        Expression bodyCall = new ApplyExp(thunk, new Expression[0]);
        Expression popHandler = new ApplyExp(popMethod, new Expression[] { new gnu.expr.ReferenceExp(linkDecl) });
        Expression tryClause;
        Expression tryClause; if (bodyType.isVoid()) {
          tryClause = new gnu.expr.BeginExp(bodyCall, popHandler);
        } else {
          comp.letStart();
          gnu.expr.Declaration resultDecl = comp.letVariable(null, bodyType, bodyCall);
          
          comp.letEnter();
          tryClause = comp.letDone(new gnu.expr.BeginExp(popHandler, new gnu.expr.ReferenceExp(resultDecl)));
        }
        


        gnu.expr.TryExp texp = new gnu.expr.TryExp(tryClause, null);
        gnu.expr.Declaration exDecl = new gnu.expr.Declaration(null, Type.javalangThrowableType);
        

        Expression doHandle = new ApplyExp(handlerLinkType.getDeclaredMethod("handle", 1), new Expression[] { new gnu.expr.ReferenceExp(linkDecl), new gnu.expr.ReferenceExp(exDecl) });
        



        texp.addCatchClause(exDecl, new ApplyExp(gnu.kawa.reflect.Throw.primitiveThrow, new Expression[] { doHandle }));
        

        return visitor.visit(comp.letDone(texp), required);
      }
    }
    thunk = visitor.visit(thunk, null);
    args[1] = thunk;
    return exp;
  }
  
  public static Expression validateApplyMakeDynamic(ApplyExp exp, gnu.expr.InlineCalls visitor, Type required, gnu.mapping.Procedure proc)
  {
    if (exp.isSimple(1, 1)) {
      Expression[] args = exp.getArgs();
      args[0] = visitor.visit(args[0], null);
      exp.setType(gnu.kawa.lispexpr.LangObjType.dynamicType);
    } else {
      exp.visitArgs(visitor); }
    return exp;
  }
  

  public static boolean compileMakeDynamic(ApplyExp exp, Compilation comp, gnu.expr.Target target, gnu.mapping.Procedure procedure)
  {
    if (!exp.isSimple())
      return false;
    exp.getArg(0).compile(comp, target);
    return true;
  }
  
  static class ExitThroughFinallyChecker extends gnu.expr.ExpVisitor<Expression, gnu.expr.TryExp>
  {
    gnu.expr.Declaration decl;
    
    ExitThroughFinallyChecker() {}
    
    public static boolean check(gnu.expr.Declaration decl, Expression body)
    {
      ExitThroughFinallyChecker visitor = new ExitThroughFinallyChecker();
      decl = decl;
      visitor.visit(body, null);
      return exitValue != null;
    }
    
    protected Expression defaultValue(Expression r, gnu.expr.TryExp d)
    {
      return r;
    }
    
    protected Expression visitReferenceExp(gnu.expr.ReferenceExp exp, gnu.expr.TryExp currentTry)
    {
      if ((decl == exp.getBinding()) && (currentTry != null))
        exitValue = Boolean.TRUE;
      return exp;
    }
    
    protected Expression visitTryExp(gnu.expr.TryExp exp, gnu.expr.TryExp currentTry)
    {
      visitExpression(exp, exp.getFinallyClause() != null ? exp : currentTry);
      return exp;
    }
  }
  

  public static Expression validateApplyMakePromise(ApplyExp exp, gnu.expr.InlineCalls visitor, Type required, gnu.mapping.Procedure proc)
  {
    Expression[] args = exp.getArgs();
    if ((args.length == 1) && ((args[0] instanceof gnu.expr.LambdaExp)))
    {
      boolean forceValueIfPromise = proc == MakePromise.makeLazy;
      Type bodyRequired;
      Type bodyRequired; if ((required instanceof gnu.kawa.reflect.LazyType))
      {
        Type valueType = ((gnu.kawa.reflect.LazyType)required).getValueType();
        bodyRequired = forceValueIfPromise ? gnu.kawa.reflect.LazyType.getLazyType(valueType) : valueType;
      }
      else
      {
        bodyRequired = null; }
      gnu.expr.LambdaExp lexp = (gnu.expr.LambdaExp)args[0];
      body = visitor.visit(body, bodyRequired);
      args[0] = visitor.visit(lexp, null);
      Type rtype = lexp.getReturnType();
      if (forceValueIfPromise)
      {
        rtype = (rtype instanceof gnu.kawa.reflect.LazyType) ? ((gnu.kawa.reflect.LazyType)rtype).getValueType() : Type.objectType;
      }
      

      Type type = gnu.kawa.reflect.LazyType.getLazyType(rtype);
      String mname = forceValueIfPromise ? "makePromiseLazy" : "makePromise";
      gnu.bytecode.Method meth = gnu.bytecode.ClassType.make("gnu.kawa.functions.MakePromise").getDeclaredMethod(mname, 1);
      
      gnu.expr.PrimProcedure mproc = new gnu.expr.PrimProcedure(meth);
      
      mproc.setReturnType(type);
      exp = new ApplyExp(mproc, args);
      exp.setType(type);
    }
    else
    {
      exp.visitArgs(visitor);
    }
    return exp;
  }
  
  static class CompileTimeContinuation extends gnu.mapping.ProcedureN implements gnu.expr.Inlineable {
    gnu.expr.Target blockTarget;
    gnu.bytecode.ExitableBlock exitableBlock;
    
    CompileTimeContinuation() {}
    
    public Object applyN(Object[] args) throws Throwable {
      throw new Error("internal error");
    }
    
    public void compile(ApplyExp exp, Compilation comp, gnu.expr.Target target) {
      CodeAttr code = comp.getCode();
      Expression[] args = exp.getArgs();
      int nargs = args.length;
      boolean noStack = ((blockTarget instanceof gnu.expr.IgnoreTarget)) || ((blockTarget instanceof gnu.expr.ConsumerTarget));
      
      Type typeNeeded = noStack ? null : target.getType();
      if ((noStack) || (nargs == 1)) {
        for (int i = 0; i < nargs; i++)
          args[i].compileWithPosition(comp, blockTarget);
      } else {
        AppendValues app = AppendValues.appendValues;
        app.compile(new ApplyExp(app, args), comp, blockTarget);
      }
      exitableBlock.exit();
    }
    
    public Type getReturnType(Expression[] args) {
      return Type.neverReturnsType;
    }
  }
}
