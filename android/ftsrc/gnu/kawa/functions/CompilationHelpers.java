package gnu.kawa.functions;

import gnu.bytecode.ArrayType;
import gnu.bytecode.ClassType;
import gnu.bytecode.Method;
import gnu.bytecode.ParameterizedType;
import gnu.bytecode.Type;
import gnu.expr.ApplyExp;
import gnu.expr.Compilation;
import gnu.expr.Declaration;
import gnu.expr.Expression;
import gnu.expr.InlineCalls;
import gnu.expr.PrimProcedure;
import gnu.expr.QuoteExp;
import gnu.expr.ReferenceExp;
import gnu.kawa.lispexpr.GenArrayType;
import gnu.kawa.lispexpr.LangObjType;
import gnu.mapping.Procedure;

public class CompilationHelpers
{
  public static boolean maybeLazy(Expression exp)
  {
    if ((exp instanceof QuoteExp))
      return false;
    return gnu.kawa.reflect.LazyType.maybeLazy(exp.getType());
  }
  
  private static boolean nonNumeric(Expression exp) {
    if ((exp instanceof QuoteExp)) {
      Object value = ((QuoteExp)exp).getValue();
      return (!(value instanceof Number)) && (!(value instanceof Boolean)) && (!(value instanceof gnu.text.Char)) && (!(value instanceof gnu.mapping.Symbol));
    }
    


    return false;
  }
  

  public static Expression validateApplyToArgs(ApplyExp exp, InlineCalls visitor, Type required, Procedure applyToArgs)
  {
    Expression[] args = exp.getArgs();
    int nargs = args.length - 1;
    if (nargs >= 0) {
      Expression proc = args[0];
      if (!proc.getFlag(1)) {
        Expression pval = proc;
        if ((proc instanceof ReferenceExp)) {
          Declaration decl = ((ReferenceExp)proc).getBinding();
          if (decl != null)
            pval = decl.getValue();
        }
        if ((pval != null) && (pval.getClass() == gnu.expr.LambdaExp.class) && (firstSpliceArg < 0))
        {
          Expression[] rargs = new Expression[nargs];
          System.arraycopy(args, 1, rargs, 0, nargs);
          exp.setFuncArgs(proc, rargs);
          return visitor.visit(exp, required);
        }
        proc = visitor.visit(proc, InlineCalls.typeForCalledFunction(proc));
        args[0] = proc;
      }
      Type ptype0 = proc.getType();
      if (ptype0 == LangObjType.dynamicType)
      {

        exp.visitArgs(visitor);
        exp.setType(LangObjType.dynamicType);
        return exp;
      }
      Type ptype = ptype0.getRealType();
      Compilation comp = visitor.getCompilation();
      gnu.expr.Language language = comp.getLanguage();
      if (ptype.isSubtype(Compilation.typeProcedure)) {
        Expression[] rargs;
        if ((ptype.getRawType() == Compilation.typeLocationProc) && (nargs == 0))
        {
          Expression[] rargs = { proc, new QuoteExp("getValue") };
          proc = new QuoteExp(gnu.kawa.reflect.Invoke.invoke);
        } else {
          rargs = new Expression[nargs];
          System.arraycopy(args, 1, rargs, 0, nargs);
        }
        exp.setFuncArgs(proc, rargs);
        exp.adjustSplice(exp, -1);
        return proc.validateApply(exp, visitor, required, null);
      }
      
      ClassType ctype = (ptype instanceof ParameterizedType) ? ((ParameterizedType)ptype).getRawType() : (ptype instanceof ClassType) ? (ClassType)ptype : Type.objectType;
      


      ApplyExp result = null;
      boolean isString = ctype.isSubclass(Compilation.typeCharSequence);
      boolean isSequence = ctype.isSubclass(Compilation.typeList);
      boolean isArray = ctype.isSubclass(GenArrayType.typeArray);
      if (gnu.kawa.reflect.CompileReflect.checkKnownClass(ptype, comp) >= 0)
      {
        if ((ptype.isSubtype(Compilation.typeType)) || (language.getTypeFor(proc, false) != null))
        {
          result = exp.setFuncArgs(gnu.kawa.reflect.Invoke.make, args);
        } else if ((ptype instanceof ArrayType)) {
          Type elementType = ((ArrayType)ptype).getComponentType();
          exp.setFuncArgs(new gnu.kawa.reflect.ArrayGet(elementType), args);
          result = exp;
        } else if ((exp.isSimple()) && (((!isString) && (!isSequence)) || ((nargs == 1) || (isArray))))
        {

          int rank = (ptype instanceof GenArrayType) ? ((GenArrayType)ptype).rank() : (isString) || (isSequence) ? 1 : -1;
          



          Type elementType = Type.objectType;
          if ((ptype instanceof GenArrayType)) {
            elementType = ((GenArrayType)ptype).getComponentType();
          }
          int resultRank = 0;
          for (int i = 1; i <= nargs; i++) {
            args[i] = visitor.visit(args[i], null);
            Type itype = args[1].getType();
            int listIndexCompat = LangObjType.sequenceType.isCompatibleWithValue(itype);
            

            int intIndexCompat = Type.intType.isCompatibleWithValue(itype);
            
            int arrayIndexCompat = GenArrayType.typeArray.isCompatibleWithValue(itype);
            
            if ((resultRank >= 0) && (intIndexCompat <= 0))
            {
              if (listIndexCompat > 0) {
                resultRank++; } else { int r;
                if (((ptype instanceof GenArrayType)) && ((r = ((GenArrayType)ptype).rank()) >= 0))
                {
                  resultRank += r;
                } else
                  resultRank = -1;
              } }
            if ((listIndexCompat < 0) && (intIndexCompat < 0) && (arrayIndexCompat < 0))
            {
              visitor.getCompilation().error('w', "index is neither integer, sequence, or array");
              
              resultRank = -1;
            } else if (intIndexCompat > 0) {
              if ((isString) && (nargs == 1)) {
                Method method = ClassType.make("gnu.lists.Strings").getDeclaredMethod("characterAt", 2);
                
                PrimProcedure prproc = new PrimProcedure(method, gnu.kawa.lispexpr.LangPrimType.characterType, null);
                

                result = exp.setFuncArgs(prproc, args);
              } else if ((nargs == 1) && (isSequence)) {
                String mname = "get";
                Type retType = null;
                String cname = ctype.getName();
                LangObjType ltype = null;
                if (cname.startsWith("gnu.lists."))
                  ltype = LangObjType.getInstanceFromClass(cname);
                if ((ltype != null) && ((retType = ltype.getElementType()) != null))
                {
                  mname = ltype.elementGetterMethodName();
                } else if ((ltype == LangObjType.vectorType) && ((ptype instanceof ParameterizedType)) && (((ParameterizedType)ptype).getTypeArgumentTypes().length == 1))
                {

                  retType = ((ParameterizedType)ptype).getTypeArgumentType(0);
                }
                

                Method get = ctype.getMethod(mname, new Type[] { Type.intType });
                
                ParameterizedType prtype = (ptype instanceof ParameterizedType) ? (ParameterizedType)ptype : null;
                


                PrimProcedure prproc = new PrimProcedure(get, 'V', language, prtype);
                
                if (retType != null)
                  prproc.setReturnType(retType);
                result = exp.setFuncArgs(prproc, args);
              }
            } else if ((arrayIndexCompat > 0) || 
              (listIndexCompat <= 0)) {}
          }
          

          if ((rank >= 0) && (rank != nargs)) {
            StringBuilder msg = new StringBuilder();
            if ((isSequence) || (isString)) {
              msg.append(isString ? "string" : "sequence").append(" requires 1 index");
            }
            else
              msg.append("array has rank ").append(rank);
            msg.append(" but there are ");
            msg.append(nargs).append(" indexes");
            visitor.getCompilation().error('w', msg.toString());
          }
          else if ((isArray) && (resultRank == 0) && (result == null)) {
            char sig1 = elementType.getSignature().charAt(0);
            String mname;
            String mname; if ((elementType instanceof gnu.bytecode.PrimType)) {
              mname = sig1 == 'I' ? "getInt" : "effectiveIndex";
            } else
              mname = "get";
            Method meth = nargs == 1 ? ctype.getMethod(mname, new Type[] { Type.intType }) : ctype.getDeclaredMethod(mname, nargs > 3 ? 4 : nargs);
            


            PrimProcedure prproc = new PrimProcedure(meth);
            result = exp.setFuncArgs(prproc, args);
            if (mname == "effectiveIndex") {
              switch (sig1) {
              case 'Z':  mname = "getBooleanRaw"; break;
              case 'C':  mname = "getCharRaw"; break;
              case 'B':  mname = "getByteRaw"; break;
              case 'S':  mname = "getShortRaw"; break;
              case 'J':  mname = "getLongRaw"; break;
              case 'F':  mname = "getFloatRaw"; break;
              case 'D':  mname = "getDoubleRaw"; break;
              case 'E': case 'G': case 'H': case 'I': case 'K': case 'L': case 'M': case 'N': case 'O': case 'P': case 'Q': case 'R': case 'T': case 'U': case 'V': case 'W': case 'X': case 'Y': default:  throw new InternalError();
              }
              meth = GenArrayType.typeArray.getDeclaredMethod(mname, 1);
              
              comp.letStart();
              Declaration tdecl = comp.letVariable((String)null, ptype, args[0]);
              
              tdecl.setFlag(549755813888L);
              tdecl.setCanRead(true);
              args[0] = new ReferenceExp(tdecl);
              ReferenceExp aref = new ReferenceExp(tdecl);
              aref.setFlag(32);
              prproc = new PrimProcedure(meth);
              prproc.setReturnType(elementType);
              result = new ApplyExp(prproc, new Expression[] { aref, result });
              Expression let = comp.letDone(result).setLine(exp);
              return visitor.visit(let, required);
            }
            prproc.setReturnType(elementType);
          }
          if ((isArray) && (!isString) && (result == null)) {
            PrimProcedure prproc = new PrimProcedure("gnu.lists.ComposedArray", "generalIndex", 3);
            


            Expression[] xargs = new Expression[nargs + 2];
            xargs[0] = args[0];
            xargs[1] = QuoteExp.falseExp;
            System.arraycopy(args, 1, xargs, 2, nargs);
            result = exp.setFuncArgs(prproc, xargs);
            Type retType = null;
            if (resultRank > 0) {
              retType = new GenArrayType(resultRank, elementType);
            } else if ((resultRank == 0) && (elementType != Type.objectType))
              retType = elementType;
            if (retType != null)
              result = Compilation.makeCoercion(result, retType);
          }
        } }
      if (result != null) {
        result.setLine(exp);
        return visitor.visitApplyOnly(result, required);
      }
    }
    exp.visitArgs(visitor);
    return exp;
  }
  
  static final ClassType setterType = ClassType.make("gnu.kawa.functions.Setter");
  static final gnu.bytecode.Field setterField = setterType.getDeclaredField("setter");
  public static final Declaration setterDecl = new Declaration("setter", setterField);
  static { setterDecl.noteValue(new QuoteExp(Setter.setter)); }
  
  public static Expression validateSetter(ApplyExp exp, InlineCalls visitor, Type required, Procedure proc)
  {
    exp.visitArgs(visitor);
    Expression[] args = exp.getArgs();
    if (args.length == 1) {
      Expression arg = args[0];
      Type argType = arg.getType();
      
      if ((argType instanceof ArrayType))
        return new SetArrayExp(arg, (ArrayType)argType);
      Type implType = argType.getRawType();
      if ((implType instanceof ClassType)) {
        ClassType cimplType = (ClassType)implType;
        if ((cimplType.isSubclass(Compilation.typeList)) || (cimplType.isSubclass(GenArrayType.typeArray)))
        {
          if ((exp instanceof SetListExp)) {
            return exp;
          }
          return new SetListExp(exp.getFunction(), (gnu.bytecode.ObjectType)argType, args);
        }
      }
      
      if ((arg instanceof ReferenceExp)) {
        Declaration decl = ((ReferenceExp)arg).getBinding();
        if (decl != null)
          arg = decl.getValue();
      }
      if ((arg instanceof QuoteExp)) {
        Object value = ((QuoteExp)arg).getValue();
        if ((value instanceof Procedure))
        {
          Procedure pvalue = (Procedure)value;
          Procedure setter;
          try { setter = pvalue.getSetter();
          } catch (RuntimeException ex) {
            setter = null;
            visitor.getCompilation().error('w', "procedure '" + pvalue.getName() + "' has no setter");
          }
          if (setter != null) {
            if ((setter instanceof java.io.Externalizable))
              return new QuoteExp(setter);
            Declaration decl = Declaration.getDeclaration(setter);
            
            if (decl != null)
              return new ReferenceExp(decl);
          }
        }
      }
      if (((argType instanceof ClassType)) && (((ClassType)argType).isSubclass(Compilation.typeProcedure)))
      {
        return new ApplyExp(getSetterProc, args);
      }
    }
    return exp;
  }
  
  public static final PrimProcedure getSetterProc = new PrimProcedure(Compilation.typeProcedure.getDeclaredMethod("getSetter", 0));
  

  public static Expression validateIsEqv(ApplyExp exp, InlineCalls visitor, Type required, Procedure proc)
  {
    exp.visitArgs(visitor);
    Expression[] args = exp.getArgs();
    if (((nonNumeric(args[0])) || (nonNumeric(args[1]))) && (!maybeLazy(args[0])) && (!maybeLazy(args[1])))
    {
      return new ApplyExp(isEq, args); }
    Method meth = ClassType.make("gnu.kawa.functions.IsEqv").getDeclaredMethod("apply", 2);
    

    return new ApplyExp(new PrimProcedure(meth, visitor.getLanguage()), args).setLine(exp);
  }
  
  public CompilationHelpers() {}
}
