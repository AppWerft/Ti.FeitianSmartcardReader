package gnu.expr;

import gnu.bytecode.AnnotationEntry;
import gnu.bytecode.ClassType;
import gnu.bytecode.ObjectType;
import gnu.bytecode.ParameterizedType;
import gnu.bytecode.PrimType;
import gnu.bytecode.Type;
import gnu.kawa.functions.MakePromise;
import gnu.kawa.lispexpr.LangPrimType;
import gnu.kawa.reflect.CompileReflect;
import gnu.kawa.reflect.Invoke;
import gnu.kawa.util.IdentityHashTable;
import gnu.lists.EmptyList;
import gnu.lists.PairWithPosition;
import gnu.lists.SimpleVector;
import gnu.mapping.Procedure;
import gnu.mapping.Values;
import gnu.math.DFloNum;
import gnu.math.IntNum;
import gnu.text.Char;
import gnu.text.SourceMessages;
import java.lang.annotation.ElementType;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.List;














public class InlineCalls
  extends ExpExpVisitor<Type>
{
  public static ThreadLocal<InlineCalls> currentVisitor = new ThreadLocal();
  
  public static Expression inlineCalls(Expression exp, Compilation comp)
  {
    InlineCalls visitor = new InlineCalls(comp);
    InlineCalls saved = (InlineCalls)currentVisitor.get();
    try {
      currentVisitor.set(visitor);
      return visitor.visit(exp, null);
    } finally {
      currentVisitor.set(saved);
    }
  }
  
  public InlineCalls(Compilation comp) {
    setContext(comp);
  }
  
  VarValueTracker valueTracker = new VarValueTracker(this);
  boolean processingAnnotations;
  
  public Expression visit(Expression exp, Type required) { Expression exp0 = exp;
    if (!exp.getFlag(1)) {
      exp.setFlag(1);
      exp = (Expression)ExpVisitor.visit(this, exp, required);
      exp.setFlag(1);
    }
    if (required == ProcedureInCallContext.INSTANCE)
      required = null;
    if (((required instanceof ValueNeededType)) && (exp.getType().isVoid())) {
      if (exp == QuoteExp.voidExp)
        return QuoteExp.voidObjectExp;
      if (comp.warnVoidUsed()) {
        comp.error('w', "void-valued expression where value is needed", exp0);
      }
      
      return new BeginExp(exp, QuoteExp.nullExp);
    }
    return checkType(exp, required);
  }
  
  public Expression checkType(Expression exp, Type required) {
    Type expType = exp.getType();
    if (expType == Type.toStringType)
      expType = Type.javalangStringType;
    int cmp = (required == null) || (expType == Type.neverReturnsType) || (required == Type.neverReturnsType) ? 1 : required.isCompatibleWithValue(expType);
    


    if ((cmp < 0) || ((cmp == 0) && (required.isInterface()) && (((exp instanceof QuoteExp)) || ((exp instanceof LambdaExp)))))
    {

      if (((exp instanceof LambdaExp)) && (((required instanceof ClassType)) || ((required instanceof ParameterizedType))))
      {

        ClassType reqraw = (required instanceof ParameterizedType) ? ((ParameterizedType)required).getRawType() : (ClassType)required;
        gnu.bytecode.Method amethod = reqraw.checkSingleAbstractMethod();
        if (amethod != null) {
          if (!ModuleExp.compilerAvailable()) {
            if (!reqraw.isInterface())
              comp.error('e', "cannot convert procedure to abstract class " + reqraw.getClass().getName() + " without bytecode compiler");
            Class iface;
            try {
              iface = reqraw.getReflectClass();
            }
            catch (Exception ex) {
              iface = null;
            }
            if (iface == null)
              comp.error('e', "cannot find interface " + reqraw.getClass().getName());
            gnu.bytecode.Method makeProxy = ClassType.make("gnu.kawa.reflect.ProceduralProxy").getDeclaredMethod("makeProxy", 2);
            

            Expression[] args = { QuoteExp.getInstance(iface), exp };
            return visit(new ApplyExp(makeProxy, args), required);
          }
          LambdaExp lexp = (LambdaExp)exp;
          ObjectExp oexp = new ObjectExp();
          oexp.setLocation(exp);
          supers = new Expression[] { new QuoteExp(required) };
          oexp.setTypes(getCompilation());
          Object mname = amethod.getName();
          oexp.addMethod(lexp, mname);
          Declaration mdecl = oexp.addDeclaration(mname, Compilation.typeProcedure);
          firstChild = lexp;
          oexp.declareParts(comp);
          return visit(oexp, required);
        }
      }
      if ((required instanceof TypeValue)) {
        Expression converted = ((TypeValue)required).convertValue(exp);
        if (converted != null) {
          return converted;
        }
      }
      Language language = comp.getLanguage();
      comp.error(processingAnnotations() ? 'e' : 'w', "type " + language.formatType(expType) + " is incompatible with required type " + language.formatType(required), exp);
      





      if ((required instanceof PrimType)) {
        required = ((PrimType)required).boxedType();
      }
      ApplyExp expb = Compilation.makeCoercion(exp, required);
      
      expb.setType(required);
      expb.setFlag(1);
      return expb;
    }
    return exp;
  }
  
  private void setCanAccess(LambdaExp exp, Type required) {
    if (required != ProcedureInCallContext.INSTANCE)
      exp.setCanRead(true);
  }
  
  protected Expression visitApplyExp(ApplyExp exp, Type required) {
    Expression func = func;
    



    if ((func instanceof LambdaExp))
    {

      Expression inlined = inlineCall((LambdaExp)func, args, false);
      if (inlined != null)
        return visit(inlined, required);
    }
    func = visit(func, typeForCalledFunction(func));
    func = func;
    return func.validateApply(exp, this, required, null);
  }
  









  public static Type typeForCalledFunction(Expression exp)
  {
    return (((exp instanceof LambdaExp)) && (!(exp instanceof ClassExp))) || ((exp instanceof ReferenceExp)) ? ProcedureInCallContext.INSTANCE : null;
  }
  



  public final Expression visitApplyOnly(ApplyExp exp, Type required)
  {
    return func.validateApply(exp, this, required, null);
  }
  
  public static Integer checkIntValue(Expression exp) {
    if ((exp instanceof QuoteExp)) {
      QuoteExp qarg = (QuoteExp)exp;
      Object value = qarg.getValue();
      if ((!qarg.isExplicitlyTyped()) && ((value instanceof IntNum))) {
        IntNum ivalue = (IntNum)value;
        if (ivalue.inIntRange())
          return Integer.valueOf(ivalue.intValue());
      }
    }
    return null;
  }
  
  public static Long checkLongValue(Expression exp) {
    if ((exp instanceof QuoteExp)) {
      QuoteExp qarg = (QuoteExp)exp;
      Object value = qarg.getValue();
      if ((!qarg.isExplicitlyTyped()) && ((value instanceof IntNum))) {
        IntNum ivalue = (IntNum)value;
        if (ivalue.inLongRange())
          return Long.valueOf(ivalue.longValue());
      }
    }
    return null;
  }
  
  public QuoteExp fixIntValue(Expression exp) {
    Integer ival = checkIntValue(exp);
    if (ival != null)
      return new QuoteExp(ival, comp.getLanguage().getTypeFor(Integer.TYPE));
    return null;
  }
  
  public QuoteExp fixLongValue(Expression exp) {
    Long ival = checkLongValue(exp);
    if (ival != null)
      return new QuoteExp(ival, comp.getLanguage().getTypeFor(Long.TYPE));
    return null;
  }
  
  protected Expression visitQuoteExp(QuoteExp exp, Type required) {
    Object value = exp.getValue();
    if ((exp.getRawType() == null) && (!exp.isSharedConstant()) && (value != null))
    {
      Language language = comp.getLanguage();
      Type vtype = language.getTypeFor(value.getClass());
      if (vtype == Type.toStringType)
        vtype = Type.javalangStringType;
      type = vtype;
      
      if (!exp.isExplicitlyTyped()) { Type primRequired;
        if ((primRequired = PrimType.unboxedType(required)) != null) {
          char sig1 = primRequired.getSignature().charAt(0);
          if (((value instanceof IntNum)) && (primRequired != LangPrimType.characterType) && (primRequired != LangPrimType.characterOrEofType))
          {

            IntNum ivalue = (IntNum)value;
            Object ival = null;
            switch (sig1) {
            case 'B': 
            case 'I': 
            case 'J': 
            case 'S': 
              ival = LangPrimType.convertIntegerLiteral(ivalue, (PrimType)primRequired, false);
              
              break;
            case 'F': 
              ival = Float.valueOf(ivalue.floatValue());
              break;
            case 'D': 
              ival = Double.valueOf(ivalue.doubleValue());
              break;
            case 'C': case 'E': case 'G': case 'H': case 'K': case 'L': case 'M': case 'N': case 'O': case 'P': case 'Q': case 'R': default: 
              ivalue = null;
            }
            if (ival != null) {
              exp = new QuoteExp(ival, required);
            } else if (ivalue != null)
              error('w', "integer " + ivalue + " not in range of " + required.getName());
          }
          if ((value instanceof DFloNum)) {
            DFloNum dvalue = (DFloNum)value;
            Object dval;
            switch (sig1) {
            case 'F': 
              dval = Float.valueOf(dvalue.floatValue());
              break;
            case 'D': 
              dval = Double.valueOf(dvalue.doubleValue());
              break;
            default: 
              dval = null;
            }
            if (dval != null) {
              exp = new QuoteExp(dval, required);
            } else
              error('w', "saw float where " + required.getName() + " expected");
          }
          if ((value instanceof Char)) {
            if (sig1 == 'C') {
              int ival = ((Char)value).intValue();
              if ((ival >= 0) && (ival <= 65535)) {
                exp = new QuoteExp(Character.valueOf((char)ival), required);
              } else
                error('w', "character scalar value " + ival + " not in range of " + required.getName());
            } else {
              exp.setType(LangPrimType.characterType);
            }
          }
        } else if (((value instanceof IntNum)) && (required != null) && ("java.math.BigInteger".equals(required.getName())))
        {
          exp = new QuoteExp(((IntNum)value).asBigInteger(), required);
        } else if ((value instanceof Char)) {
          exp.setType(LangPrimType.characterType);
        }
      }
    }
    return exp;
  }
  
  protected Expression visitReferenceExp(ReferenceExp exp, Type required) {
    Declaration decl = exp.getBinding();
    if ((decl != null) && (!exp.getDontDereference())) {
      IntNum vals = (IntNum)valueTracker.declValueUsage.get(decl);
      if ((vals != null) && 
        (VarValueTracker.maybeUninitialized(vals)) && (!decl.getFlag(274877906944L)))
      {
        comp.error('w', "variable '" + exp.getName() + "' may be uninitialized here", exp);
        decl.setFlag(274877906944L);
      }
      

      LambdaExp lval = decl.getLambdaValue();
      if (lval != null) {
        setCanAccess(lval, required);
        valueTracker.checkUninitializedVariables(lval, exp, null);
      }
      Expression dval = decl.getValue();
      if ((deferableInit(dval)) && (!dval.getFlag(1))) {
        visit(dval, required);
      }
      




      Type type = decl.getType();
      if ((type != null) && (type.isVoid()))
        return QuoteExp.voidExp;
    }
    if ((decl != null) && (field == null) && (!decl.getCanWrite()) && (!exp.getDontDereference()))
    {
      Expression dval = decl.getValue();
      if (((dval instanceof QuoteExp)) && (dval != QuoteExp.undefined_exp)) {
        return visitQuoteExp(new QuoteExp(((QuoteExp)dval).getValue(), decl.getType()), required);
      }
      

      if ((dval != null) && (nvalues == 1) && (values[0].kind == 4)) {
        dval = null;
      }
      if (((dval instanceof ReferenceExp)) && (!decl.isAlias())) {
        ReferenceExp rval = (ReferenceExp)dval;
        Declaration rdecl = rval.getBinding();
        Type dtype = decl.getType();
        if ((rdecl != null) && (!rdecl.getCanWrite()) && ((dtype == null) || (dtype == Type.objectType) || (dtype == rdecl.getType())))
        {


          return visitReferenceExp(new ReferenceExp(rval), required); }
      }
      if (((dval instanceof ClassExp)) && (processingAnnotations())) {
        ClassExp cval = (ClassExp)dval;
        if (compiledType != null)
          return new QuoteExp(compiledType, required);
      }
      if ((!exp.isProcedureName()) && (decl.isClassMethod()))
      {




        comp.error('e', "unimplemented: reference to method " + decl.getName() + " as variable");
        comp.error('e', decl, "here is the definition of ", "");
      }
    }
    decl = Declaration.followAliases(decl);
    if (decl != null) {
      if (required != ProcedureInCallContext.INSTANCE) {
        decl.setCanRead(true);
      } else {
        decl.setCanCall(true);
        
        if (!comp.mustCompile)
          decl.setCanRead();
      }
      Declaration ctx = exp.contextDecl();
      if (ctx != null)
        ctx.setCanRead(true);
    }
    return (Expression)super.visitReferenceExp(exp, required);
  }
  
  protected Expression visitIfExp(IfExp exp, Type required) {
    Expression test = (Expression)test.visit(this, ValueNeededType.instance);
    if ((test instanceof ReferenceExp)) {
      Declaration decl = ((ReferenceExp)test).getBinding();
      if (decl != null)
      {
        Expression value = decl.getValue();
        if (((value instanceof QuoteExp)) && (value != QuoteExp.undefined_exp))
          test = value;
      }
    }
    test = test;
    VarValueTracker.forkPush(this);
    if (exitValue == null)
      then_clause = visit(then_clause, required);
    valueTracker.forkNext();
    if ((exitValue == null) && (else_clause != null))
      else_clause = visit(else_clause, required);
    VarValueTracker.forkPop(this);
    
    int truth = comp.getLanguage().isTrue(((QuoteExp)test).getValue()) ? 1 : !(test instanceof QuoteExp) ? -1 : 0;
    
    if ((else_clause == null) && (truth <= 0) && ((required instanceof ValueNeededType)))
    {
      if (comp.warnVoidUsed())
        comp.error('w', "missing else where value is required", exp);
      if (truth == 0)
        return QuoteExp.voidObjectExp;
    }
    if (truth >= 0)
      return exp.select(truth != 0);
    if (test.getType().isVoid()) {
      boolean voidTrue = comp.getLanguage().isTrue(Values.empty);
      
      if (comp.warnVoidUsed())
        comp.error('w', "void-valued condition is always " + (truth != 0));
      return new BeginExp(test, exp.select(voidTrue));
    }
    return exp;
  }
  
  protected Expression visitBeginExp(BeginExp exp, Type required) {
    int last = length - 1;
    for (int i = 0; i <= last; i++) {
      exps[i] = visit(exps[i], i < last ? null : required);
    }
    return exp;
  }
  
  protected Expression visitCaseExp(CaseExp exp, Type required) {
    Expression key = (Expression)key.visit(this, ValueNeededType.instance);
    


    if ((key instanceof ReferenceExp)) {
      Declaration decl = ((ReferenceExp)key).getBinding();
      if (decl != null) {
        Expression value = decl.getValue();
        if (((value instanceof QuoteExp)) && (value != QuoteExp.undefined_exp))
        {
          key = value; }
      }
    }
    key = key;
    

    if (clauses.length == 0) {
      return new BeginExp(key, visit(elseClause.exp, required));
    }
    

    Expression lastIncomp = null;
    int incomps = 0;
    for (int i = 0; i < clauses.length; i++) {
      for (int j = 0; j < clauses[i].datums.length; j++) {
        Expression dexp = clauses[i].datums[j];
        Object d = ((QuoteExp)dexp).getValue();
        if (((d instanceof SimpleVector)) || ((!(d instanceof EmptyList)) && ((d instanceof PairWithPosition))))
        {
          comp.error('w', "List and vectors will never be matched in a case clause", dexp);
        } else if ((d instanceof CharSequence)) {
          comp.error('w', "a string in a case clause will never match (except another literal)", dexp);
        }
        if (key.getType().isCompatibleWithValue(dexp.getType()) == -1) {
          if (incomps < 2) {
            comp.error('w', "datum type incompatible with the key", dexp);
          } else if (incomps == 2)
            lastIncomp = dexp;
          incomps++;
        }
      }
    }
    
    if (incomps > 2) {
      comp.error('w', "there are " + (incomps - 2) + " more datums that are incompatible with the key", lastIncomp);
    }
    
    VarValueTracker.forkPush(this);
    if (exitValue == null) {
      clauses[0].exp = visit(clauses[0].exp, required);
      for (int i = 1; i < clauses.length; i++) {
        if (exitValue == null) {
          valueTracker.forkNext();
          clauses[i].exp = visit(clauses[i].exp, required);
        }
      }
    }
    if ((exitValue == null) && (elseClause != null)) {
      valueTracker.forkNext();
      elseClause.exp = visit(elseClause.exp, required);
    }
    VarValueTracker.forkPop(this);
    
    boolean isKeyKnown = key instanceof QuoteExp;
    
    Object keyValue = isKeyKnown ? ((QuoteExp)key).getValue() : null;
    
    if ((elseClause == null) && ((required instanceof ValueNeededType))) {
      boolean missing = (!isKeyKnown) || (!exp.searchValue(keyValue));
      if ((missing) && 
        (comp.warnVoidUsed())) {
        comp.error('w', "missing else where value is required", exp);
      }
      
      if ((isKeyKnown) && (missing)) {
        return QuoteExp.voidObjectExp;
      }
    }
    


    if (isKeyKnown) {
      Expression e = exp.selectCase(keyValue);
      return e != null ? e : QuoteExp.voidObjectExp;
    }
    
    if (key.getType().isVoid()) {
      return new BeginExp(key, exp.selectCase(QuoteExp.voidExp.getValue()));
    }
    
    return exp;
  }
  
  protected Expression visitScopeExp(ScopeExp exp, Type required) {
    exp.visitChildren(this, null);
    visitDeclarationTypes(exp);
    for (Declaration decl = exp.firstDecl(); decl != null; 
        decl = decl.nextDecl()) {
      if (type == null) {
        Expression val = decl.getValue();
        type = Type.objectType;
        decl.setType((val != null) && (val != QuoteExp.undefined_exp) ? val.getType() : Type.objectType);
      }
      

      visitAnnotations(decl);
    }
    return exp;
  }
  


  protected void visitRemainingDeclaredLambdas(ScopeExp exp)
  {
    for (Declaration decl = exp.firstDecl(); decl != null; 
        decl = decl.nextDecl()) {
      Expression value = decl.getValueRaw();
      if (((value instanceof LambdaExp)) && (!decl.isModuleLocal()))
        visit(value, null);
    }
    for (Declaration decl = exp.firstDecl(); decl != null; 
        decl = decl.nextDecl()) {
      Expression value = decl.getValueRaw();
      if (((value instanceof LambdaExp)) && (!value.getFlag(1)) && (decl.isModuleLocal()) && (comp.warnUnused()))
      {


        comp.error('w', decl, "no use of ", ""); }
    }
  }
  
  protected Expression visitModuleExp(ModuleExp exp, Type required) {
    LambdaExp saveLambda = currentLambda;
    currentLambda = exp;
    try {
      super.visitModuleExp(exp, required);
    } finally {
      currentLambda = saveLambda;
    }
    visitRemainingDeclaredLambdas(exp);
    return exp;
  }
  
  protected Expression visitLetExp(LetExp exp, Type required) {
    if ((!(exp instanceof CatchClause)) && (!(exp instanceof FluidLetExp))) {
      for (Declaration decl = exp.firstDecl(); decl != null; 
          decl = decl.nextDecl())
      {







        if ((body instanceof ReferenceExp)) {
          ReferenceExp ref = (ReferenceExp)body;
          if ((ref.getBinding() == decl) && (!ref.getDontDereference()))
          {
            decl.setFlag(549755813888L);
            ref.setFlag(32);
          }
        }
        Expression init = decl.getInitValue();
        if ((init == QuoteExp.undefined_exp) && ((decl.getValueRaw() instanceof LambdaExp)))
        {
          valueTracker.noteSet(decl, IntNum.make(-1));
        } else {
          valueTracker.noteUnitialized(decl);
        }
      }
    }
    for (Declaration decl = exp.firstDecl(); decl != null; 
        decl = decl.nextDecl()) {
      Expression init = decl.getInitValue();
      if ((nvalues > 0) && (values[0].kind == 3) && (values[0].base == exp))
      {

        valueTracker.noteSet(decl, IntNum.make(-1));
      }
      boolean typeSpecified = decl.getFlag(8192L);
      Type dtype = (typeSpecified) && (init != QuoteExp.undefined_exp) ? decl.getType() : null;
      if ((!deferableInit(init)) || (decl.getValueRaw() != init))
      {

        init = visit(init, ValueNeededType.make(dtype)); }
      decl.setInitValue(init);
    }
    
    if (exitValue == null)
      body = visit(body, required);
    visitRemainingDeclaredLambdas(exp);
    return exp;
  }
  
  protected boolean deferableInit(Expression init) {
    if ((init instanceof LambdaExp))
      return !(init instanceof ClassExp);
    if ((init instanceof ApplyExp)) {
      Object fun = ((ApplyExp)init).getFunctionValue();
      if ((fun == MakePromise.makeDelay) || (fun == MakePromise.makeLazy))
        return true;
    }
    return false;
  }
  
  protected Expression visitFluidLetExp(FluidLetExp exp, Type required) {
    for (Declaration decl = exp.firstDecl(); 
        decl != null; decl = decl.nextDecl()) {
      decl.setCanRead(true);
      if (base != null)
        base.setCanRead(true);
    }
    return (Expression)super.visitFluidLetExp(exp, required);
  }
  
  protected Expression visitLambdaExp(LambdaExp exp, Type required) {
    setCanAccess(exp, required);
    if (exp.getCallConvention() == 0)
      exp.setCallConvention(getCompilation());
    Declaration firstDecl = exp.firstDecl();
    if ((firstDecl != null) && (firstDecl.isThisParameter()) && (!exp.isClassMethod()) && (type == null))
    {
      firstDecl.setType(comp.mainClass);
    }
    if (exp.getClass() == LambdaExp.class) {
      if ((canFinishCondition != CanFinishMap.CAN_FINISH) && (canFinishCondition != null))
      {
        exp.setReturnType(Type.neverReturnsType);
      }
      Declaration ldecl = nameDecl;
      boolean unknownCalls = true;
      if ((ldecl != null) && (!exp.isClassMethod()) && (ldecl.isModuleLocal())) {
        int countApply = 0;
        for (ApplyExp app = firstCall; app != null; 
            app = nextCall)
          countApply++;
        if ((countApply == numReferences) && (!Compilation.avoidInline(exp)))
        {






          unknownCalls = false;
          for (ApplyExp app = firstCall; app != null; 
              app = nextCall) {
            Expression func = app.getFunction();
            int nargs = app.getArgCount();
            Declaration p = firstDecl;
            if ((p != null) && (p.isThisParameter()))
              p = p.nextDecl();
            for (int i = 0; (p != null) && (i < min_args); 
                i++) {
              if (!p.hasUnknownValue()) {
                p.noteValueFromApply(app, i);
              }
              p = p.nextDecl();
            }
          }
        }
      }
      

      if (unknownCalls) {
        for (Declaration p = firstDecl; p != null; p = p.nextDecl()) {
          if (!p.isThisParameter())
            p.noteValueUnknown();
        }
      }
    }
    LambdaExp saveLambda = currentLambda;
    currentLambda = exp;
    try {
      visitScopeExp(exp, required);
    } finally {
      currentLambda = saveLambda;
    }
    if ((exp.isClassMethod()) && ("*init*".equals(exp.getName()))) {
      Expression bodyFirst = exp.getBodyFirstExpression();
      ClassType calledInit = exp.checkForInitCall(bodyFirst);
      ClassExp cexp = (ClassExp)exp.getOuter();
      ClassType superClass = instanceType.getSuperclass();
      if (calledInit != null) {
        if ((calledInit != instanceType) && (calledInit != superClass))
          comp.error('e', "call to <init> for not this or super class");
      } else if (superClass != null) {
        cexp.checkDefaultSuperConstructor(superClass, comp);
      }
    }
    return exp;
  }
  
  public void visitDefaultArgs(LambdaExp exp, Type required) {
    for (Declaration p = exp.firstDecl(); p != null; p = p.nextDecl()) {
      Expression init = p.getInitValue();
      if (init != null)
        p.setInitValue(visitAndUpdate(init, p.getType()));
    }
  }
  
  protected Expression visitClassExp(ClassExp exp, Type required) {
    Expression result = (Expression)super.visitClassExp(exp, required);
    if ((!explicitInit) && (instanceType != null) && (!instanceType.isInterface()))
    {
      exp.checkDefaultSuperConstructor(instanceType.getSuperclass(), comp); }
    return result;
  }
  
  protected Expression visitTryExp(TryExp exp, Type required) {
    if ((exp.getCatchClauses() == null) && (exp.getFinallyClause() == null)) {
      return visit(try_clause, required);
    }
    VarValueTracker.forkPush(this);
    try_clause = ((Expression)try_clause.visit(this, required));
    for (CatchClause clause = catch_clauses; 
        clause != null; clause = clause.getNext()) {
      valueTracker.forkNext();
      clause.visit(this, required);
    }
    

    if (finally_clause != null)
      valueTracker.forkNext();
    VarValueTracker.forkPop(this);
    if (finally_clause != null)
      finally_clause = ((Expression)finally_clause.visit(this, null));
    return exp;
  }
  





  public boolean processingAnnotations() { return processingAnnotations; }
  
  protected void visitAnnotations(Declaration decl) {
    List<Expression> annotations = annotations;
    if (annotations != null) {
      boolean saveProcessingAnnotations = processingAnnotations;
      processingAnnotations = true;
      try {
        int num = annotations.size();
        for (int i = 0; i < num; i++) {
          Expression before = (Expression)annotations.get(i);
          Expression ann = visit(before, null);
          Object aval = ann.valueIfConstant();
          if (((aval instanceof Proxy)) && (((aval = Proxy.getInvocationHandler(aval)) instanceof AnnotationEntry)))
          {

            AnnotationEntry ae = (AnnotationEntry)aval;
            if ((decl.isClassMethod()) && (!ae.hasTarget(ElementType.METHOD)))
              comp.error('e', "annotation " + ae.getAnnotationType().getName() + " allowed on methods", before);
            if ((decl.isClassField()) && (!ae.hasTarget(ElementType.FIELD)))
              comp.error('e', "annotation " + ae.getAnnotationType().getName() + " not allowed on fields", before);
            if (((decl.getValue() instanceof ClassExp)) && (!ae.hasTarget(ElementType.TYPE)) && (!ae.hasTarget(ElementType.FIELD)))
            {

              comp.error('e', "annotation " + ae.getAnnotationType().getName() + " not allowed on classes", before); }
          }
          annotations.set(i, ann);
        }
      } finally {
        processingAnnotations = saveProcessingAnnotations;
      }
    }
  }
  
  protected Expression visitSetExp(SetExp exp, Type required) {
    Declaration decl = exp.getBinding();
    if ((decl != null) && (values != Declaration.unknownValueValues) && (valueIndex >= 0))
    {
      IntNum setterMask = IntNum.make(valueIndex ^ 0xFFFFFFFF);
      valueTracker.noteSet(decl, setterMask);
    }
    if ((decl == null) || (decl.getValueRaw() != new_value) || (!deferableInit(new_value)))
    {


      Type dtype = (decl == null) || (decl.isAlias()) ? null : type;
      new_value = visit(new_value, ValueNeededType.make(dtype));
    }
    if ((!exp.isDefining()) && (decl != null) && (decl.isClassMethod()))
      comp.error('e', "can't assign to method " + decl.getName(), exp);
    if ((decl != null) && (decl.getFlag(8192L)) && 
      (CompileReflect.checkKnownClass(decl.getType(), comp) < 0)) {
      decl.setType(Type.errorType);
    }
    











    Declaration ctx = exp.contextDecl();
    if (ctx != null)
      ctx.setCanRead(true);
    return exp;
  }
  








  private static final Class[] inlinerMethodType = { ApplyExp.class, InlineCalls.class, Type.class, Procedure.class };
  












  static java.lang.reflect.Method resolveInliner(Procedure proc, String inliner, Class[] mtype)
    throws Throwable
  {
    int colon = inliner.indexOf(':');
    if (colon > 0) {
      String cname = inliner.substring(0, colon);
      String mname = inliner.substring(colon + 1);
      Class clas = Class.forName(cname, true, proc.getClass().getClassLoader());
      


      return clas.getDeclaredMethod(mname, mtype);
    }
    
    return null;
  }
  
  public Expression maybeInline(ApplyExp exp, Type required, Procedure proc) {
    try {
      Object inliner;
      synchronized (proc) {
        inliner = proc.getProperty(Procedure.validateXApplyKey, null);
        if ((inliner == null) && (firstSpliceArg < 0))
          inliner = proc.getProperty(Procedure.validateApplyKey, null);
        if ((inliner instanceof CharSequence)) {
          inliner = resolveInliner(proc, inliner.toString(), inlinerMethodType);
          
          if (inliner == null) {
            error('e', "inliner property string for " + proc + " is not of the form CLASS:METHOD");
            return null;
          }
        }
      }
      if (inliner != null)
      {



        Object[] vargs = { exp, this, required, proc };
        if ((inliner instanceof Procedure)) {
          return (Expression)((Procedure)inliner).applyN(vargs);
        }
        if ((inliner instanceof java.lang.reflect.Method)) {
          return (Expression)((java.lang.reflect.Method)inliner).invoke(null, vargs);
        }
      }
    }
    catch (Error ex) {
      throw ex;
    } catch (Throwable ex) {
      if ((ex instanceof InvocationTargetException))
        ex = ((InvocationTargetException)ex).getTargetException();
      messages.error('e', "caught exception in inliner for " + proc + " - " + ex, ex);
    }
    
    return null;
  }
  








  public static Expression inlineCall(LambdaExp lexp, Expression[] args, boolean makeCopy)
  {
    if (keywords != null)
      return null;
    boolean varArgs = max_args < 0;
    int fixed = min_args;
    if (((fixed == max_args) && (fixed == args.length)) || ((varArgs) && (args.length >= fixed)))
    {

      Declaration prev = null;
      IdentityHashTable mapper;
      Expression[] cargs;
      if (makeCopy) {
        IdentityHashTable mapper = new IdentityHashTable();
        Expression[] cargs = Expression.deepCopy(args, mapper);
        if ((cargs == null) && (args != null))
          return null;
      } else {
        mapper = null;
        cargs = args;
      }
      if (varArgs) {
        cargs = new Expression[fixed + 1];
        
        System.arraycopy(args, 0, cargs, 0, fixed);
        
        Expression[] xargs = new Expression[args.length - fixed + 1];
        Declaration restArg = lexp.firstDecl();
        int i = fixed; for (;;) { i--; if (i < 0) break;
          restArg = restArg.nextDecl(); }
        xargs[0] = QuoteExp.getInstance(type);
        
        System.arraycopy(args, fixed, xargs, 1, args.length - fixed);
        cargs[fixed] = new ApplyExp(Invoke.make, xargs);
      }
      int i = 0;
      LetExp let = new LetExp();
      for (Declaration param = lexp.firstDecl(); param != null; i++) {
        Declaration next = param.nextDecl();
        param.setInitValue(cargs[i]);
        if (makeCopy) {
          Declaration ldecl = let.addDeclaration(symbol, type);
          
          if (typeExp != null) {
            typeExp = Expression.deepCopy(typeExp);
            if (typeExp == null) {
              return null;
            }
          }
          mapper.put(param, ldecl);
        } else {
          lexp.remove(prev, param);
          let.add(prev, param);
        }
        if (!param.getCanWrite()) {
          nvalues = 0;
          values = null;
        }
        param.noteValueFromLet(let);
        prev = param;
        param = next;
      }
      Expression body = lexp.body;
      if (makeCopy) {
        body = Expression.deepCopy(body, mapper);
        if ((body == null) && (lexp.body != null))
          return null;
      }
      body = body;
      lexp.body = null;
      lexp.setFlag(1);
      lexp.setInlineOnly(true);
      return let;
    }
    














    return null;
  }
  
  public static class LenientExpectedType extends Type
  {
    Type base;
    
    public static LenientExpectedType make(Type type) {
      return new LenientExpectedType(type);
    }
    
    LenientExpectedType(Type type) {
      super();
      base = type;
    }
    
    public int compare(Type other)
    {
      return this == other ? 0 : -3;
    }
    
    public Object coerceFromObject(Object obj)
    {
      return obj;
    }
    
    public int isCompatibleWithValue(Type valueType)
    {
      if (base.getRawType().equals(base.getRawType()))
        return 1;
      return base.isCompatibleWithValue(valueType);
    }
    
    public String toString()
    {
      return "LenientExpectedType[" + base + ']';
    }
  }
  
  public static class ProcedureInCallContext extends ObjectType {
    public static final ProcedureInCallContext INSTANCE = new ProcedureInCallContext();
    
    ProcedureInCallContext() {
      super();
    }
    
    public Type getImplementationType() {
      return Compilation.typeProcedure;
    }
    
    public int compare(Type other) {
      return getImplementationType().compare(other.getImplementationType());
    }
  }
  

  public static class ValueNeededType
    extends ObjectType
  {
    static final ValueNeededType instance = new ValueNeededType(null);
    
    Type actualType;
    
    ValueNeededType(Type actualType)
    {
      super();
      this.actualType = actualType;
    }
    
    public static Type make(Type type) {
      if (type == null)
        return instance;
      if (((type instanceof ValueNeededType)) || (type == Type.objectType)) {
        return type;
      }
      

      return type;
    }
    
    public Type getImplementationType() {
      return actualType;
    }
    
    public int compare(Type other) {
      return other.isVoid() ? -1 : 1;
    }
  }
}
