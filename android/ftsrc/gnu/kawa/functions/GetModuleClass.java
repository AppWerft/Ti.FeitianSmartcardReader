package gnu.kawa.functions;

import gnu.bytecode.ClassType;
import gnu.bytecode.Method;
import gnu.bytecode.Type;
import gnu.expr.ApplyExp;
import gnu.expr.Compilation;
import gnu.expr.Declaration;
import gnu.expr.Expression;
import gnu.expr.ModuleExp;
import gnu.expr.ReferenceExp;
import gnu.expr.Target;
import gnu.kawa.io.Path;
import gnu.kawa.io.URLPath;
import gnu.text.ResourceStreamHandler;

public class GetModuleClass extends gnu.mapping.ProcedureN implements gnu.expr.Inlineable
{
  public static final GetModuleClass getModuleClass = new GetModuleClass();
  




  public static final GetModuleClass getModuleUri = new GetModuleClass();
  





  public static final GetModuleClass getModuleUriDummy = new GetModuleClass();
  

  static final ClassType typeURLPath = ClassType.make("gnu.kawa.io.URLPath");
  static final Method maker = ClassType.make("gnu.kawa.functions.GetModuleClass").getDeclaredMethod("classResourcePath", 1);
  
  public GetModuleClass() {}
  
  public Object applyN(Object[] args)
  {
    throw new Error("get-module-class must be inlined");
  }
  
  public int numArgs()
  {
    return this == getModuleUriDummy ? 4097 : 0;
  }
  
  public void compile(ApplyExp exp, Compilation comp, Target target)
  {
    if (this == getModuleUriDummy)
    {
      ReferenceExp ref = (ReferenceExp)exp.getArgs()[0];
      ref.compile(comp, target);
      Declaration decl = ref.getBinding();
      Expression init = decl.getValue();
      if (init != null)
      {
        gnu.expr.BindingInitializer.create(decl, init, comp);
        decl.noteValueUnknown();
      }
    }
    else
    {
      comp.loadClassRef(mainClass);
      if (this == getModuleUri)
        comp.getCode().emitInvoke(maker);
      target.compileFromStack(comp, exp.getType());
    }
  }
  
  public Type getReturnType(Expression[] args)
  {
    return this == getModuleClass ? Type.javalangClassType : typeURLPath;
  }
  
  private static gnu.mapping.Symbol CLASS_RESOURCE_NAME = gnu.mapping.Namespace.getDefaultSymbol("$class_resource_URL$");
  





  public static Expression getModuleClassURI(Compilation comp)
  {
    Declaration decl = mainLambda.lookup(CLASS_RESOURCE_NAME);
    if (decl == null)
    {
      decl = new Declaration(CLASS_RESOURCE_NAME, typeURLPath);
      decl.setFlag(536889344L);
      Expression value;
      Expression value; if (immediate)
      {
        Path path = comp.getMinfo().getSourceAbsPath();
        if (path == null)
          path = Path.currentPath();
        if (!(path instanceof URLPath))
          path = URLPath.valueOf(path.toURL());
        value = gnu.expr.QuoteExp.getInstance(path);
      }
      else
      {
        Expression clas = new ApplyExp(getModuleClass, Expression.noExpressions);
        

        value = new ApplyExp(maker, new Expression[] { clas });
      }
      decl.setValue(value);
      mainLambda.add(null, decl);
    }
    ReferenceExp ref = new ReferenceExp(decl);
    if (immediate) {
      return ref;
    }
    return new ApplyExp(getModuleUriDummy, new Expression[] { ref });
  }
  
  public static URLPath classResourcePath(Class clas)
  {
    java.net.URL url;
    try {
      try {
        url = ResourceStreamHandler.makeURL(clas);

      }
      catch (SecurityException ex)
      {

        String classFileName = clas.getName().replace('.', '/') + ".class";
        url = clas.getClassLoader().getResource(classFileName);
      }
    } catch (Exception ex) {
      throw gnu.mapping.WrappedException.wrapIfNeeded(ex);
    }
    return URLPath.valueOf(url);
  }
}
