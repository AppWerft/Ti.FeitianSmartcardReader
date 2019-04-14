package gnu.kawa.reflect;

import gnu.bytecode.AnnotationEntry;
import gnu.bytecode.ClassType;
import gnu.bytecode.Method;
import gnu.bytecode.Type;
import gnu.expr.ApplyExp;
import gnu.expr.Compilation;
import gnu.expr.Expression;
import gnu.expr.InlineCalls;
import gnu.expr.Keyword;
import gnu.expr.Language;
import gnu.expr.QuoteExp;
import gnu.mapping.Procedure;
import gnu.text.SourceMessages;
import java.lang.reflect.Proxy;

public class MakeAnnotation extends gnu.mapping.ProcedureN
{
  public static final MakeAnnotation instance = new MakeAnnotation(null);
  
  ClassType annotationType;
  

  public MakeAnnotation(ClassType annotationType)
  {
    this.annotationType = annotationType;
    setProperty(Procedure.validateApplyKey, "gnu.kawa.reflect.MakeAnnotation:validate");
  }
  
  public static MakeAnnotation make(Object annotationType)
  {
    ClassType annotationCType;
    ClassType annotationCType;
    if ((annotationType instanceof ClassType)) {
      annotationCType = (ClassType)annotationType; } else { ClassType annotationCType;
      if ((annotationType instanceof Class)) {
        annotationCType = (ClassType)Type.make((Class)annotationType);
      } else
        annotationCType = ClassType.make(annotationType.toString()); }
    return new MakeAnnotation(annotationCType);
  }
  
  static final Method makeMethod = ClassType.make("gnu.kawa.reflect.MakeAnnotation").getDeclaredMethod("make", 1);
  

  public static final Procedure makeMethodProc = new gnu.expr.PrimProcedure(makeMethod);
  public static final QuoteExp makeMethodExp = QuoteExp.getInstance(makeMethodProc);
  

  public static ApplyExp makeAnnotationMaker(Expression classRef)
  {
    ApplyExp aexp = new ApplyExp(makeMethodExp, new Expression[] { classRef });
    aexp.setFlag(4);
    return aexp;
  }
  
  public String getName()
  {
    return "@" + annotationType.getName();
  }
  



  public static Expression validate(ApplyExp exp, InlineCalls visitor, Type required, Procedure proc)
  {
    Compilation comp = visitor.getCompilation();
    Language language = visitor.getLanguage();
    SourceMessages messages = visitor.getMessages();
    boolean mustBeConstant = visitor.processingAnnotations();
    MakeAnnotation aproc = (MakeAnnotation)proc;
    Expression[] args = exp.getArgs();
    int nargs = args.length;
    int i = 0;
    
    ClassType annotationType = annotationType;
    
    if (annotationType == null)
    {
      args[0] = visitor.visit(args[0], null);
      i++;
      Type t = visitor.getLanguage().getTypeFor(args[0], true);
      if ((t instanceof ClassType))
        annotationType = (ClassType)t;
    }
    int istart = i;
    
    AnnotationEntry aentry = null;
    if (annotationType != null)
    {
      if (annotationType.implementsInterface(Type.javalangannotationAnnotationType)) {
        aentry = new AnnotationEntry(annotationType);
      } else {
        messages.error('e', annotationType.getName() + " is not an annotation type");
      }
    } else if (mustBeConstant)
      messages.error('e', "annotation type is not a known class");
    boolean warnedMissingName = false;
    for (; i < nargs; i++)
    {

      int ikey = i;
      String name; String name; if ((i == istart) && (nargs == istart + 1)) {
        name = "value";
      }
      else {
        args[i] = visitor.visit(args[i], null);
        Object keyword = args[i].valueIfConstant();
        String name; if ((i == nargs) || (!(keyword instanceof Keyword)))
        {
          if (!warnedMissingName) {
            messages.error(mustBeConstant ? 'e' : 'w', "missing keyword in annotation arguments");
          }
          warnedMissingName = false;
          aentry = null;
          name = null;
        }
        else
        {
          i++;
          name = ((Keyword)keyword).getName();
        }
      }
      Type eltype = null;
      if ((annotationType != null) && (name != null))
      {
        Method method = annotationType.getDeclaredMethod(name, Type.typeArray0);
        if (method == null)
        {
          comp.error('e', "no annotation element named '" + name + '\'', args[ikey]);
          aentry = null;
        }
        else {
          eltype = comp.getLanguage().getLangTypeFor(method.getReturnType());
        }
      }
      int ecount = messages.getErrorCount();
      args[i] = visitor.visit(args[i], eltype);
      Object arg = args[i].valueIfConstant();
      if (messages.getErrorCount() > ecount)
      {
        eltype = null;
        aentry = null;
      }
      else if ((arg == null) && (mustBeConstant))
      {
        comp.error('e', "annotation value must be constant", args[i]);
        eltype = null;
        aentry = null;
      }
      if (aentry != null)
      {
        try
        {
          aentry.addMember(name, arg, eltype);
        }
        catch (Exception ex)
        {
          aentry = null;
          comp.error(mustBeConstant ? 'e' : 'w', "bad annotation value", args[i]);
        }
      }
    }
    

    if (aentry != null)
    {
      Class aclass = annotationType.getReflectClass();
      return new QuoteExp(Proxy.newProxyInstance(aclass.getClassLoader(), new Class[] { aclass }, aentry), annotationType);
    }
    


    return exp;
  }
  
  public Object applyN(Object[] args)
  {
    return applyN(args, null);
  }
  
  public Object applyN(Object[] args, SourceMessages messages)
  {
    int nargs = args.length;
    int i = 0;
    
    ClassType annotationType = this.annotationType;
    
    Class aclass;
    if (annotationType == null)
    {
      Class aclass = (Class)args[(i++)];
      annotationType = (ClassType)Type.make(aclass);
    }
    else {
      aclass = annotationType.getReflectClass(); }
    int istart = i;
    
    AnnotationEntry aentry = new AnnotationEntry(annotationType);
    for (; i < nargs; i++) {
      String name;
      String name;
      if ((i == istart) && (nargs == istart + 1)) {
        name = "value";
      }
      else {
        Object keyword = args[i];
        i++;
        if ((i == nargs) || (!(keyword instanceof Keyword)))
          throw new IllegalArgumentException("missing keyword in annotation arguments");
        name = ((Keyword)keyword).getName();
      }
      Object arg = args[i];
      Method method = annotationType.getDeclaredMethod(name, Type.typeArray0);
      if (method == null)
        throw new IllegalArgumentException("no annotation element named '" + name + '\'');
      Type eltype = method.getReturnType();
      aentry.addMember(name, AnnotationEntry.asAnnotationValue(arg, eltype));
    }
    return Proxy.newProxyInstance(aclass.getClassLoader(), new Class[] { aclass }, aentry);
  }
}
