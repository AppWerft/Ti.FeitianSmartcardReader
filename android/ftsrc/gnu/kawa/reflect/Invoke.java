package gnu.kawa.reflect;

import gnu.bytecode.ArrayType;
import gnu.bytecode.ClassType;
import gnu.bytecode.ObjectType;
import gnu.bytecode.Type;
import gnu.expr.ApplyExp;
import gnu.expr.Expression;
import gnu.expr.Keyword;
import gnu.expr.Language;
import gnu.expr.Mangling;
import gnu.expr.PairClassType;
import gnu.expr.PrimProcedure;
import gnu.expr.TypeValue;
import gnu.kawa.lispexpr.ClassNamespace;
import gnu.kawa.lispexpr.LangObjType;
import gnu.lists.FString;
import gnu.mapping.CallContext;
import gnu.mapping.MethodProc;
import gnu.mapping.Procedure;
import gnu.mapping.ProcedureN;
import gnu.mapping.Symbol;
import gnu.mapping.WrongType;
import java.lang.reflect.Array;

public class Invoke extends ProcedureN
{
  char kind;
  Language language;
  public static final Invoke invoke = new Invoke("invoke", '*');
  public static final Invoke invokeStatic = new Invoke("invoke-static", 'S');
  public static final Invoke invokeSpecial = new Invoke("invoke-special", 'P');
  public static final Invoke make = new Invoke("make", 'N');
  
  public Invoke(String name, char kind)
  {
    this(name, kind, Language.getDefaultLanguage());
  }
  
  public Invoke(String name, char kind, Language language)
  {
    super(name);
    this.kind = kind;
    this.language = language;
    setProperty(Procedure.validateXApplyKey, "gnu.kawa.reflect.CompileInvoke:validateApplyInvoke");
  }
  
  public static Object invoke$V(Object[] args)
    throws Throwable
  {
    return invoke.applyN(args);
  }
  
  public static Object invokeStatic$V(Object[] args) throws Throwable
  {
    return invokeStatic.applyN(args);
  }
  
  public static Object make$V(Object[] args) throws Throwable
  {
    return make.applyN(args);
  }
  
  private static ObjectType typeFrom(Object arg, Invoke thisProc)
  {
    if ((arg instanceof Class))
      arg = Type.make((Class)arg);
    if ((arg instanceof ObjectType))
      return (ObjectType)arg;
    if (((arg instanceof String)) || ((arg instanceof FString)))
      return ClassType.make(arg.toString());
    if ((arg instanceof Symbol))
      return ClassType.make(((Symbol)arg).getName());
    if ((arg instanceof ClassNamespace))
      return ((ClassNamespace)arg).getClassType();
    throw new WrongType(thisProc, 0, arg, "class-specifier");
  }
  
  public void apply(CallContext ctx) throws Throwable
  {
    Object[] args = ctx.getArgs();
    if ((kind == 'S') || (kind == 'V') || (kind == 's') || (kind == '*'))
    {


      int nargs = args.length;
      Procedure.checkArgCount(this, nargs);
      Object arg0 = args[0];
      ObjectType dtype = (ObjectType)((kind == 'S') || (kind == 's') ? typeFrom(arg0, this) : Type.make(arg0.getClass()));
      

      Procedure proc = lookupMethods(dtype, args[1]);
      Object[] margs = new Object[nargs - (kind == 'S' ? 2 : 1)];
      int i = 0;
      if ((kind == 'V') || (kind == '*'))
        margs[(i++)] = args[0];
      System.arraycopy(args, 2, margs, i, nargs - 2);
      proc.checkN(margs, ctx);
    }
    else {
      ctx.writeValue(applyN(args));
    }
  }
  
  public Object applyN(Object[] args) throws Throwable {
    if (kind == 'P') {
      throw new RuntimeException(getName() + ": invoke-special not allowed at run time");
    }
    
    int nargs = args.length;
    Procedure.checkArgCount(this, nargs);
    Object arg0 = args[0];
    ObjectType dtype = (kind != 'V') && (kind != '*') ? typeFrom(arg0, this) : (ObjectType)Type.make(arg0.getClass());
    
    Object mname;
    if (kind == 'N')
    {
      Object mname = null;
      if ((dtype instanceof TypeValue))
      {
        Procedure constructor = ((TypeValue)dtype).getConstructor();
        if (constructor != null)
        {
          nargs--;
          Object[] xargs = new Object[nargs];
          System.arraycopy(args, 1, xargs, 0, nargs);
          return constructor.applyN(xargs);
        }
      }
      if ((dtype instanceof PairClassType))
      {
        PairClassType ptype = (PairClassType)dtype;
        dtype = instanceType;
      }
      if (((dtype instanceof ArrayType)) || (dtype == LangObjType.constVectorType))
      {


        int len = args.length - 1;
        String name;
        boolean lengthSpecified;
        int length;
        int i;
        boolean lengthSpecified; if ((len >= 2) && ((args[1] instanceof Keyword)) && (("length".equals(name = ((Keyword)args[1]).getName())) || ("size".equals(name))))
        {


          int length = ((Number)args[2]).intValue();
          int i = 3;
          lengthSpecified = true;
        }
        else
        {
          length = len;
          i = 1;
          lengthSpecified = false;
        }
        Type elementType = dtype == LangObjType.constVectorType ? Type.objectType : ((ArrayType)dtype).getComponentType();
        

        Object arr = Array.newInstance(elementType.getReflectClass(), length);
        
        int index = 0;
        for (; i <= len; i++)
        {
          Object arg = args[i];
          if ((lengthSpecified) && ((arg instanceof Keyword)) && (i < len))
          {
            String kname = ((Keyword)arg).getName();
            try
            {
              index = Integer.parseInt(kname);
            }
            catch (Exception ex)
            {
              throw new RuntimeException("non-integer keyword '" + kname + "' in array constructor");
            }
            arg = args[(++i)];
          }
          Array.set(arr, index, elementType.coerceFromObject(arg));
          index++;
        }
        if (dtype == LangObjType.constVectorType)
          return gnu.lists.FVector.makeConstant((Object[])arr);
        return arr;
      }
    }
    else
    {
      mname = args[1];
    }
    MethodProc proc = lookupMethods(dtype, mname);
    if (kind != 'N')
    {
      Object[] margs = new Object[nargs - ((kind == 'S') || (kind == 's') ? 2 : 1)];
      int i = 0;
      if ((kind == 'V') || (kind == '*'))
        margs[(i++)] = args[0];
      System.arraycopy(args, 2, margs, i, nargs - 2);
      return proc.applyN(margs);
    }
    

    CallContext vars = CallContext.getInstance();
    int keywordStart = 0;
    
    while ((keywordStart < args.length) && (!(args[keywordStart] instanceof Keyword))) {
      keywordStart++;
    }
    
    int err = -1;
    Object result; Object result; if (keywordStart == args.length)
    {
      err = proc.matchN(args, vars);
      if (err == 0) {
        return vars.runUntilValue();
      }
      MethodProc vproc = ClassMethods.apply(dtype, "valueOf", '\000', language);
      
      if (vproc != null)
      {
        Object[] margs = new Object[nargs - 1];
        System.arraycopy(args, 1, margs, 0, nargs - 1);
        err = vproc.matchN(margs, vars);
        if (err == 0)
          return vars.runUntilValue();
      }
      result = proc.apply1(args[0]);
    }
    else
    {
      Object[] cargs = new Object[keywordStart];
      System.arraycopy(args, 0, cargs, 0, keywordStart);
      result = proc.applyN(cargs);
    }
    
    for (int i = keywordStart; 
        
        i + 1 < args.length; i += 2)
    {
      Object arg = args[i];
      if (!(arg instanceof Keyword))
        break;
      Keyword key = (Keyword)arg;
      arg = args[(i + 1)];
      SlotSet.apply(false, result, key.getName(), arg);
    }
    
    if (keywordStart == args.length)
      i = 1;
    if (i != args.length)
    {
      MethodProc aproc = ClassMethods.apply(dtype, "add", '\000', language);
      
      if (aproc == null)
        throw MethodProc.matchFailAsException(err, proc, args);
      while (i < args.length) {
        aproc.apply2(result, args[(i++)]);
      }
    }
    return result;
  }
  

  public int numArgs()
  {
    return 0xF000 | (kind == 'N' ? 1 : 2);
  }
  
  protected MethodProc lookupMethods(ObjectType dtype, Object name) {
    String mname;
    String mname;
    if (kind == 'N') {
      mname = "<init>";
    } else {
      String mname;
      if ((name instanceof CharSequence)) {
        mname = name.toString(); } else { String mname;
        if ((name instanceof Symbol)) {
          mname = ((Symbol)name).getName();
        } else
          throw new WrongType(this, 1, name, "string-or-symbol"); }
      mname = Mangling.mangleName(mname);
    }
    MethodProc proc = ClassMethods.apply(dtype, mname, (kind == '*') || (kind == 'V') ? 'V' : kind == 'P' ? 'P' : '\000', language);
    



    if (proc == null) {
      throw new RuntimeException(getName() + ": no method named `" + mname + "' in class " + dtype.getName());
    }
    return proc;
  }
  








  public static synchronized ApplyExp makeInvokeStatic(ClassType type, String name, Expression... args)
  {
    PrimProcedure method = getStaticMethod(type, name, args);
    if (method == null) {
      throw new RuntimeException("missing or ambiguous method `" + name + "' in " + type.getName());
    }
    return new ApplyExp(method, args);
  }
  

  @Deprecated
  public static synchronized PrimProcedure getStaticMethod(ClassType type, String name, Expression[] args)
  {
    return CompileInvoke.getStaticMethod(type, name, args);
  }
}
