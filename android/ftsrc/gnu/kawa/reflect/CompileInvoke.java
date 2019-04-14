package gnu.kawa.reflect;

import gnu.bytecode.Type;
import gnu.expr.ApplyExp;
import gnu.expr.Compilation;
import gnu.expr.Expression;
import gnu.expr.PrimProcedure;

public class CompileInvoke
{
  public CompileInvoke() {}
  
  public static Expression validateApplyInvoke(ApplyExp exp, gnu.expr.InlineCalls visitor, Type required, gnu.mapping.Procedure proc)
  {
    Invoke iproc = (Invoke)proc;
    char kind = kind;
    Compilation comp = visitor.getCompilation();
    Expression[] args = exp.getArgs();
    int nargs = args.length;
    if ((nargs == 0) || (((kind == 'V') || (kind == '*')) && (nargs == 1)))
    {

      exp.visitArgs(visitor);
      return exp;
    }
    
    Expression arg0 = visitor.visit(args[0], null);
    args[0] = arg0;
    Type type0 = (kind == 'V') || (kind == '*') ? arg0.getType() : language.getTypeFor(arg0);
    gnu.bytecode.ObjectType type; gnu.bytecode.ObjectType type; if (((type0 instanceof gnu.expr.PairClassType)) && (kind == 'N')) {
      type = instanceType; } else { gnu.bytecode.ObjectType type;
      if (((type0 instanceof gnu.kawa.lispexpr.LangObjType)) && (kind == 'N')) {
        type = ((gnu.kawa.lispexpr.LangObjType)type0).getConstructorType(); } else { gnu.bytecode.ObjectType type;
        if ((type0 instanceof gnu.bytecode.ObjectType)) {
          type = (gnu.bytecode.ObjectType)type0;
        } else
          type = null; } }
    if (kind == 'P') {
      if (type0 == null) {
        comp.error('e', "unknown class for invoke-special", arg0);
      } else if ((!(type instanceof gnu.bytecode.ClassType)) || (type.isInterface()))
        comp.error('e', "invalid class for invoke-special", arg0);
    }
    String name = getMethodName(args, kind);
    
    if ((kind == 'N') && (type == gnu.kawa.lispexpr.LangObjType.constVectorType) && ((required instanceof gnu.bytecode.ArrayType)))
    {
      type = (gnu.bytecode.ObjectType)required; }
    if ((kind == 'N') && ((type instanceof gnu.bytecode.ArrayType))) {
      gnu.bytecode.ArrayType atype = (gnu.bytecode.ArrayType)type;
      Type elementType = atype.getComponentType();
      Expression sizeArg = null;
      boolean lengthSpecified = false;
      if ((args.length >= 3) && ((args[1] instanceof gnu.expr.QuoteExp))) {
        Object arg1 = ((gnu.expr.QuoteExp)args[1]).getValue();
        if (((arg1 instanceof gnu.expr.Keyword)) && (("length".equals(name = ((gnu.expr.Keyword)arg1).getName())) || ("size".equals(name))))
        {

          sizeArg = args[2];
          lengthSpecified = true;
        }
      }
      if (sizeArg == null)
        sizeArg = gnu.expr.QuoteExp.getInstance(new Integer(args.length - 1));
      sizeArg = visitor.visit(sizeArg, Type.intType);
      Object constantValue = null;
      if ((visitor.processingAnnotations()) && ((sizeArg instanceof gnu.expr.QuoteExp))) {
        try
        {
          int sz = ((Number)sizeArg.valueIfConstant()).intValue();
          constantValue = java.lang.reflect.Array.newInstance(elementType.getReflectClass(), sz);
        } catch (Exception ex) {
          comp.error('e', "bad array size: " + ex.getMessage());
        }
      }
      boolean useArrayMake = (numKeywordArgs == 0) && (constantValue == null);
      ApplyExp alloc = new ApplyExp(new ArrayNew(elementType), new Expression[] { sizeArg });
      
      alloc.setType(type);
      if ((lengthSpecified) && (args.length == 3))
        return alloc;
      gnu.expr.Declaration adecl;
      gnu.expr.Declaration adecl; if (useArrayMake) {
        adecl = null;
      } else {
        comp.letStart();
        adecl = comp.letVariable((String)null, type, alloc);
        adecl.setCanRead(true);
      }
      gnu.expr.BeginExp begin = new gnu.expr.BeginExp();
      int index = 0;
      for (int i = lengthSpecified ? 3 : 1; i < args.length; i++) {
        Expression arg = args[i];
        if ((lengthSpecified) && (i + 1 < args.length) && ((arg instanceof gnu.expr.QuoteExp)))
        {
          Object key = ((gnu.expr.QuoteExp)arg).getValue();
          if ((key instanceof gnu.expr.Keyword)) {
            String kname = ((gnu.expr.Keyword)key).getName();
            try {
              index = Integer.parseInt(kname);
              arg = args[(++i)];
            } catch (Exception ex) {
              comp.error('e', "non-integer keyword '" + kname + "' in array constructor");
              return exp;
            }
          }
        }
        boolean isSplice = gnu.kawa.functions.MakeSplice.argIfSplice(arg) != null;
        arg = visitor.visit(arg, isSplice ? null : elementType);
        args[i] = arg;
        if (!(arg instanceof gnu.expr.QuoteExp)) {
          constantValue = null;
        } else if ((constantValue != null) && (!useArrayMake)) {
          try {
            java.lang.reflect.Array.set(constantValue, index, arg.valueIfConstant());
          } catch (Exception ex) {
            constantValue = null;
          }
        }
        if (!useArrayMake) {
          begin.add(new ApplyExp(new ArraySet(elementType), new Expression[] { new gnu.expr.ReferenceExp(adecl), gnu.expr.QuoteExp.getInstance(new Integer(index)), arg }));
        }
        


        index++;
      }
      
      if (constantValue != null) {
        return new gnu.expr.QuoteExp(constantValue, type);
      }
      if (useArrayMake) {
        Expression[] xargs = new Expression[args.length - 1];
        System.arraycopy(args, 1, xargs, 0, xargs.length);
        ApplyExp xexp = new ApplyExp(ArrayMake.getInstance(elementType), xargs);
        
        xexp.adjustSplice(exp, -1);
        xexp.setType(atype);
        return xexp;
      }
      
      begin.add(new gnu.expr.ReferenceExp(adecl));
      gnu.expr.LetExp let = comp.letDone(begin);
      return let;
    }
    if ((type != null) && (name != null))
      return validateNamedInvoke(exp, visitor, type, name, null, iproc, required);
    exp.visitArgs(visitor);
    return exp;
  }
  
  public static Expression validateNamedInvoke(ApplyExp exp, gnu.expr.InlineCalls visitor, gnu.bytecode.ObjectType type, String name, PrimProcedure[] methods, Invoke iproc, Type required) {
    Expression[] args = exp.getArgs();
    int nargs = args.length;
    Compilation comp = visitor.getCompilation();
    char kind = kind;
    int objIndex;
    if ((kind == 'V') || (kind == '*')) {
      int margsLength = nargs - 1;
      int argsStartIndex = 2;
      objIndex = 0; } else { int objIndex;
      if (kind == 'N') {
        int margsLength = nargs;
        int argsStartIndex = 0;
        objIndex = -1; } else { int objIndex;
        if ((kind == 'S') || (kind == 's')) {
          int margsLength = nargs - 2;
          int argsStartIndex = 2;
          objIndex = -1; } else { int objIndex;
          if (kind == 'P') {
            int margsLength = nargs - 2;
            int argsStartIndex = 3;
            objIndex = 1;
          } else {
            exp.visitArgs(visitor);
            return exp; } } } }
    int objIndex;
    int argsStartIndex; int margsLength; gnu.bytecode.ClassType caller = curClass != null ? curClass : comp == null ? null : mainClass;
    

    gnu.bytecode.ObjectType ctype = type;
    
    int keywordStart = (kind == 'N') && (numKeywordArgs > 0) ? firstKeywordArgIndex - 1 : nargs;
    int tailArgs = nargs - keywordStart;
    int spliceCount = exp.spliceCount();
    int numCode;
    try { if (methods == null)
        methods = getMethods(ctype, name, caller, iproc);
      numCode = ClassMethods.selectApplicable(methods, margsLength - tailArgs - spliceCount, spliceCount > 0);
    }
    catch (Exception ex)
    {
      comp.error('w', "unknown class: " + type.getName());
      return exp;
    }
    
    if (kind == 'N') {
      boolean usingConstVector = false;
      if (type == gnu.kawa.lispexpr.LangObjType.constVectorType) {
        gnu.bytecode.ClassType creq;
        gnu.bytecode.Method defcons;
        if ((tailArgs == 0) && (((required instanceof gnu.bytecode.ClassType)) || ((required instanceof gnu.bytecode.ParameterizedType))) && ((creq = (gnu.bytecode.ClassType)required.getRawType()).isSubclass(Compilation.typeList)) && ((defcons = creq.getDefaultConstructor()) != null) && (exp.isSimple()))
        {



          ctype = creq;
          type = ctype;
          usingConstVector = true;
          keywordStart = 1;
          numCode = -917504;
          tailArgs = nargs - 1;
          methods[0] = new PrimProcedure(defcons, language);
          args[0] = new gnu.expr.QuoteExp(ctype.getReflectClass());
          if ((required instanceof gnu.bytecode.ParameterizedType)) {
            Type[] paramTypes = ((gnu.bytecode.ParameterizedType)required).getTypeArgumentTypes();
            if (paramTypes.length == 1) {
              int i = args.length; for (;;) { i--; if (i <= 0) break;
                args[i] = Compilation.makeCoercion(args[i], paramTypes[0]);
              }
            }
          }
        }
      }
      if ((type instanceof gnu.expr.TypeValue)) {
        gnu.mapping.Procedure constructor = ((gnu.expr.TypeValue)type).getConstructor();
        if (constructor != null) {
          Expression[] xargs = new Expression[nargs - 1];
          System.arraycopy(args, 1, xargs, 0, nargs - 1);
          ApplyExp xapp = new ApplyExp(constructor, xargs);
          xapp.adjustSplice(exp, -1);
          return visitor.visit(xapp.setLine(exp), required);
        }
      }
      if (firstSpliceArg >= 0) {
        exp.visitArgs(visitor);
        return exp;
      }
      CompileBuildObject builder = CompileBuildObject.make(exp, visitor, required, ctype, caller);
      if (usingConstVector) {
        builder.setDefaultConstructor(methods[0]);
        return builder.build();
      }
      if (builder.useBuilder(numCode, visitor)) {
        return builder.build();
      }
    }
    int okCount = 0;int maybeCount = 0;
    if ((kind == 'N') && (tailArgs > 0)) {
      comp.error('w', "args following keyword args but no 'add' method");
    } else if (numCode >= 0) {
      for (int i = 1; i < nargs; i++) {
        Type atype = null;
        boolean last = i == nargs - 1;
        if (((kind == 'P') && (i == 2)) || ((kind != 'N') && (i == 1))) {
          atype = null;
        } else if ((kind == 'P') && (i == 1)) {
          atype = ctype;
        } else if (numCode > 0) {
          int pi = i - (kind == 'N' ? 1 : argsStartIndex);
          for (int j = 0; j < numCode; j++) {
            PrimProcedure pproc = methods[j];
            int pii = pi + ((kind != 'S') && (pproc.takesTarget()) ? 1 : 0);
            
            if ((PrimProcedure.explicitArrayAsVarArgsAllowed) && (last) && (pproc.takesVarArgs()) && (pii == pproc.minArgs()))
            {

              atype = null;
            } else {
              Type ptype = pproc.getParameterType(pii);
              if (j == 0) {
                atype = ptype;
              } else if (ptype instanceof gnu.bytecode.PrimType != atype instanceof gnu.bytecode.PrimType) {
                atype = null;
              } else {
                atype = gnu.expr.Language.unionType(atype, ptype);
              }
            }
            if (atype == null)
              break;
          }
        }
        args[i] = visitor.visit(args[i], atype);
      }
      long num = selectApplicable(methods, ctype, args, margsLength, argsStartIndex, objIndex);
      
      okCount = (int)(num >> 32);
      maybeCount = (int)num;
    }
    int nmethods = methods.length;
    if ((okCount + maybeCount == 0) && (kind == 'N')) {
      methods = getMethods(ctype, "valueOf", caller, Invoke.invokeStatic);
      argsStartIndex = 1;
      margsLength = nargs - 1;
      long num = selectApplicable(methods, ctype, args, margsLength, argsStartIndex, -1);
      
      okCount = (int)(num >> 32);
      maybeCount = (int)num;
    }
    int index = -1;
    if (okCount + maybeCount == 0) {
      if ((kind == 'P') || (comp.warnInvokeUnknownMethod())) {
        if (kind == 'N')
          name = name + "/valueOf";
        StringBuilder sbuf = new StringBuilder();
        if (nmethods + methods.length == 0) {
          sbuf.append("no accessible method '");
        } else if (numCode == -983040) {
          sbuf.append("too few arguments for method '");
        } else if (numCode == -917504) {
          sbuf.append("too many arguments for method '");
        } else
          sbuf.append("no possibly applicable method '");
        sbuf.append(name);
        sbuf.append("' in ");
        sbuf.append(type.getName());
        comp.error(kind == 'P' ? 'e' : 'w', sbuf.toString());
      }
    }
    else if ((okCount == 1) || ((okCount == 0) && (maybeCount == 1))) {
      index = 0;
    } else if (okCount > 0) {
      index = PrimProcedure.mostSpecific(methods, okCount);
      if ((index < 0) && 
        (kind == 'S'))
      {


        for (int i = 0; i < okCount; i++) {
          if (methods[i].getStaticFlag()) {
            if (index >= 0) {
              index = -1;
              break;
            }
            index = i;
          }
        }
      }
      
      if ((index < 0) && ((kind == 'P') || (comp.warnInvokeUnknownMethod())))
      {
        StringBuffer sbuf = new StringBuffer();
        sbuf.append("more than one definitely applicable method `");
        sbuf.append(name);
        sbuf.append("' in ");
        sbuf.append(type.getName());
        append(methods, okCount, sbuf);
        comp.error(kind == 'P' ? 'e' : 'w', sbuf.toString());
      }
    } else if ((kind == 'P') || (comp.warnInvokeUnknownMethod())) {
      StringBuffer sbuf = new StringBuffer();
      sbuf.append("more than one possibly applicable method '");
      sbuf.append(name);
      sbuf.append("' in ");
      sbuf.append(type.getName());
      append(methods, maybeCount, sbuf);
      comp.error(kind == 'P' ? 'e' : 'w', sbuf.toString());
    }
    if (index >= 0) {
      Expression[] margs = new Expression[margsLength];
      PrimProcedure method = methods[index];
      boolean variable = method.takesVarArgs();
      int dst = 0;
      int spdelta = -argsStartIndex;
      if (objIndex >= 0) {
        if (firstSpliceArg == objIndex) {
          spdelta = -objIndex;
        } else
          spdelta++;
        margs[(dst++)] = args[objIndex];
      }
      int src = argsStartIndex;
      for (; (src < args.length) && (dst < margs.length); 
          dst++) {
        margs[dst] = args[src];src++;
      }
      ApplyExp e = new ApplyExp(method, margs);
      e.adjustSplice(exp, spdelta);
      e.setLine(exp);
      if (method.canCompile(e))
        return visitor.visitApplyOnly(e, required);
    }
    exp.visitArgs(visitor);
    return exp;
  }
  
  private static String getMethodName(Expression[] args, char kind)
  {
    if (kind == 'N')
      return "<init>";
    int nameIndex = kind == 'P' ? 2 : 1;
    if (args.length >= nameIndex + 1)
      return ClassMethods.checkName(args[nameIndex], false);
    return null;
  }
  
  private static void append(PrimProcedure[] methods, int mcount, StringBuffer sbuf) {
    for (int i = 0; i < mcount; i++) {
      sbuf.append("\n  candidate: ");
      sbuf.append(methods[i]);
    }
  }
  

  protected static PrimProcedure[] getMethods(gnu.bytecode.ObjectType ctype, String mname, gnu.bytecode.ClassType caller, Invoke iproc)
  {
    int kind = kind;
    return ClassMethods.getMethods(ctype, mname, (kind == 42) || (kind == 86) ? 'V' : kind == 80 ? 'P' : '\000', caller, language);
  }
  






  private static long selectApplicable(PrimProcedure[] methods, gnu.bytecode.ObjectType ctype, Expression[] args, int margsLength, int argsStartIndex, int objIndex)
  {
    Type[] atypes = new Type[margsLength];
    
    int dst = 0;
    if (objIndex >= 0)
      atypes[(dst++)] = ctype;
    Type restType = null;
    int src = argsStartIndex;
    for (; (src < args.length) && (dst < atypes.length); 
        dst++) {
      Expression arg = args[src];
      Expression spliceArg = gnu.kawa.functions.MakeSplice.argIfSplice(arg);
      if (spliceArg != null) {
        restType = Type.objectType;
        Type[] xtypes = new Type[dst];
        System.arraycopy(atypes, 0, xtypes, 0, dst);
        atypes = xtypes;
        break;
      }
      Type atype = null;
      
      if (gnu.expr.InlineCalls.checkIntValue(arg) != null) {
        atype = Type.intType;
      } else if (gnu.expr.InlineCalls.checkLongValue(arg) != null) {
        atype = Type.longType;
      } else if (atype == null)
        atype = arg.getType();
      atypes[dst] = atype;src++;
    }
    return ClassMethods.selectApplicable(methods, atypes, restType);
  }
  
  public static synchronized PrimProcedure getStaticMethod(gnu.bytecode.ClassType type, String name, Expression[] args)
  {
    PrimProcedure[] methods = getMethods(type, name, null, Invoke.invokeStatic);
    
    long num = selectApplicable(methods, type, args, args.length, 0, -1);
    int okCount = (int)(num >> 32);
    int maybeCount = (int)num;
    int index;
    int index; if (methods == null) {
      index = -1; } else { int index;
      if (okCount > 0) {
        index = PrimProcedure.mostSpecific(methods, okCount); } else { int index;
        if (maybeCount == 1) {
          index = 0;
        } else
          index = -1; } }
    return index < 0 ? null : methods[index];
  }
}
