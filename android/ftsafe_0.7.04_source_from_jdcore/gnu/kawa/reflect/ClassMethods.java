package gnu.kawa.reflect;

import gnu.bytecode.ClassType;
import gnu.bytecode.Method;
import gnu.bytecode.ObjectType;
import gnu.bytecode.Type;
import gnu.expr.PrimProcedure;
import gnu.mapping.Symbol;

public class ClassMethods extends gnu.mapping.Procedure2
{
  public static final ClassMethods classMethods = new ClassMethods();
  static { classMethods.setName("class-methods"); }
  







  public Object apply2(Object arg0, Object arg1)
  {
    return apply(this, arg0, arg1);
  }
  


  public static gnu.mapping.MethodProc apply(gnu.mapping.Procedure thisProc, Object arg0, Object arg1)
  {
    if ((arg0 instanceof Class))
      arg0 = Type.make((Class)arg0);
    ClassType dtype; if ((arg0 instanceof ClassType)) {
      dtype = (ClassType)arg0; } else { ClassType dtype;
      if (((arg0 instanceof String)) || ((arg0 instanceof gnu.lists.FString)) || ((arg0 instanceof Symbol)))
      {
        dtype = ClassType.make(arg0.toString());
      } else
        throw new gnu.mapping.WrongType(thisProc, 0, null); }
    ClassType dtype; String mname; if (((arg1 instanceof String)) || ((arg1 instanceof gnu.lists.FString)) || ((arg1 instanceof Symbol)))
    {
      mname = arg1.toString();
    } else
      throw new gnu.mapping.WrongType(thisProc, 1, null);
    String mname; if (!"<init>".equals(mname))
      mname = gnu.expr.Mangling.mangleName(mname);
    gnu.mapping.MethodProc result = apply(dtype, mname, '\000', gnu.expr.Language.getDefaultLanguage());
    if (result == null) {
      throw new RuntimeException("no applicable method named `" + mname + "' in " + dtype.getName());
    }
    return result;
  }
  

  private static int removeRedundantMethods(java.util.List<Method> methods)
  {
    int mlength = methods.size();
    
    for (int i = 1; i < mlength;)
    {
      Method method1 = (Method)methods.get(i);
      ClassType class1 = method1.getDeclaringClass();
      Type[] types1 = method1.getParameterTypes();
      int tlen = types1.length;
      for (int j = 0;; j++) { if (j >= i)
          break label220;
        Method method2 = (Method)methods.get(j);
        Type[] types2 = method2.getParameterTypes();
        if (tlen == types2.length)
        {

          int k = tlen; for (;;) { k--; if (k < 0)
              break;
            Type pt1 = types1[k];
            Type pt2 = types2[k];
            if ((pt1 instanceof gnu.bytecode.TypeVariable))
              pt1 = ((gnu.bytecode.TypeVariable)pt1).getRawType();
            if ((pt2 instanceof gnu.bytecode.TypeVariable))
              pt2 = ((gnu.bytecode.TypeVariable)pt2).getRawType();
            if (!Type.isSame(pt1, pt2))
              break;
          }
          if (k < 0)
          {
            if (class1.isSubtype(method2.getDeclaringClass()))
              methods.set(j, method1);
            methods.set(i, methods.get(mlength - 1));
            mlength--;
            
            break;
          } } }
      i++; }
    label220:
    return mlength;
  }
  







  public static PrimProcedure[] getMethods(ObjectType dtype, String mname, char mode, ClassType caller, gnu.expr.Language language)
  {
    if (dtype == Type.tostring_type)
      dtype = Type.string_type;
    MethodFilter filter = new MethodFilter(mname, 0, 0, caller, mode == 'P' ? null : dtype);
    
    boolean named_class_only = (mode == 'P') || ("<init>".equals(mname));
    java.util.ArrayList<Method> methods = new java.util.ArrayList();
    ObjectType rtype;
    gnu.bytecode.ParameterizedType ptype;
    ObjectType rtype; if ((dtype instanceof gnu.bytecode.ParameterizedType)) {
      gnu.bytecode.ParameterizedType ptype = (gnu.bytecode.ParameterizedType)dtype;
      rtype = ptype.getRawType();
    } else {
      ptype = null;
      rtype = dtype;
    }
    rtype.getMethods(filter, named_class_only ? 0 : 2, methods);
    if ((!named_class_only) && ((!(dtype instanceof ClassType)) || (dtype.isInterface())))
    {


      Type.pointer_type.getMethods(filter, 0, methods);
    }
    int mlength = named_class_only ? methods.size() : removeRedundantMethods(methods);
    
    PrimProcedure[] result = new PrimProcedure[mlength];
    int count = 0;
    int i = mlength; for (;;) { i--; if (i < 0) break;
      Method method = (Method)methods.get(i);
      PrimProcedure pproc = new PrimProcedure(method, mode, language, ptype);
      
      if (!named_class_only) {
        ClassType mdclass = method.getDeclaringClass();
        if (mdclass != dtype) {
          Type itype = dtype.getImplementationType();
          if (((itype instanceof ClassType)) && ((!((ClassType)itype).isInterface()) || (mdclass != Type.objectType)))
          {




            pproc.setMethodForInvoke(new Method(method, (ClassType)itype));
          }
        }
      }
      result[(count++)] = pproc;
    }
    return result;
  }
  









  public static long selectApplicable(PrimProcedure[] methods, Type[] atypes, Type restType)
  {
    int limit = methods.length;
    int numDefApplicable = 0;
    int numPosApplicable = 0;
    for (int i = 0; i < limit;)
    {
      int code = methods[i].isApplicable(atypes, restType);
      if (code < 0)
      {

        PrimProcedure tmp = methods[(limit - 1)];
        methods[(limit - 1)] = methods[i];
        methods[i] = tmp;
        limit--;
      }
      else if (code > 0)
      {

        PrimProcedure tmp = methods[numDefApplicable];
        methods[numDefApplicable] = methods[i];
        methods[i] = tmp;
        numDefApplicable++;
        i++;
      }
      else
      {
        numPosApplicable++;
        i++;
      }
    }
    return (numDefApplicable << 32) + numPosApplicable;
  }
  





  public static int selectApplicable(PrimProcedure[] methods, int numArgs, boolean maybeMore)
  {
    int limit = methods.length;
    int numTooManyArgs = 0;
    int numTooFewArgs = 0;
    int numOk = 0;
    for (int i = 0; i < limit;)
    {
      int num = methods[i].numArgs();
      int min = gnu.mapping.Procedure.minArgs(num);
      int max = gnu.mapping.Procedure.maxArgs(num);
      boolean ok = false;
      if ((numArgs < min) && (!maybeMore)) {
        numTooFewArgs++;
      } else if ((numArgs > max) && (max >= 0)) {
        numTooManyArgs++;
      } else
        ok = true;
      if (ok)
      {
        numOk++;
        i++;

      }
      else
      {
        PrimProcedure tmp = methods[(limit - 1)];
        methods[(limit - 1)] = methods[i];
        methods[i] = tmp;
        limit--;
      }
    }
    return numTooManyArgs > 0 ? -917504 : numTooFewArgs > 0 ? -983040 : numOk > 0 ? numOk : 0;
  }
  










  public static gnu.mapping.MethodProc apply(ObjectType dtype, String mname, char mode, gnu.expr.Language language)
  {
    PrimProcedure[] methods = getMethods(dtype, mname, mode, null, language);
    gnu.expr.GenericProc gproc = null;
    PrimProcedure pproc = null;
    for (int i = 0; i < methods.length; i++)
    {
      PrimProcedure cur = methods[i];
      if ((pproc != null) && (gproc == null))
      {
        gproc = new gnu.expr.GenericProc();
        gproc.add(pproc);
      }
      pproc = cur;
      if (gproc != null)
        gproc.add(pproc);
    }
    if (gproc != null)
    {
      gproc.setName(dtype.getName() + "." + mname);
      return gproc;
    }
    return pproc;
  }
  




  static String checkName(gnu.expr.Expression exp, boolean reversible)
  {
    if ((exp instanceof gnu.expr.QuoteExp))
    {
      Object name = ((gnu.expr.QuoteExp)exp).getValue();
      String nam;
      if (((name instanceof gnu.lists.FString)) || ((name instanceof String))) {
        nam = name.toString(); } else { String nam;
        if ((name instanceof Symbol)) {
          nam = ((Symbol)name).getName();
        } else
          return null; }
      String nam; if (gnu.expr.Language.isValidJavaName(nam))
        return nam;
      return gnu.expr.Mangling.mangleName(nam, reversible);
    }
    return null;
  }
  




  static String checkName(gnu.expr.Expression exp)
  {
    if ((exp instanceof gnu.expr.QuoteExp))
    {
      Object name = ((gnu.expr.QuoteExp)exp).getValue();
      if (((name instanceof gnu.lists.FString)) || ((name instanceof String)))
        return name.toString();
      if ((name instanceof Symbol)) {
        return ((Symbol)name).getName();
      }
      return null;
    }
    return null;
  }
  
  public ClassMethods() {}
}
