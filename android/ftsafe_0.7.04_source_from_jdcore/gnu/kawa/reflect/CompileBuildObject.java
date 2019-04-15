package gnu.kawa.reflect;

import gnu.bytecode.ClassType;
import gnu.bytecode.Member;
import gnu.bytecode.Method;
import gnu.bytecode.ObjectType;
import gnu.bytecode.Type;
import gnu.expr.ApplyExp;
import gnu.expr.BeginExp;
import gnu.expr.ClassExp;
import gnu.expr.Compilation;
import gnu.expr.Declaration;
import gnu.expr.Expression;
import gnu.expr.InlineCalls;
import gnu.expr.Keyword;
import gnu.expr.Language;
import gnu.expr.PrimProcedure;
import gnu.expr.QuoteExp;
import gnu.expr.ReferenceExp;
import gnu.kawa.lispexpr.LangObjType;
import gnu.mapping.Namespace;



public class CompileBuildObject
{
  ApplyExp exp;
  InlineCalls visitor;
  Type required;
  ObjectType ctype;
  ClassType caller;
  boolean defaultConstructorSet;
  PrimProcedure defaultConstructor;
  
  public Compilation getCompilation() { return visitor.getCompilation(); }
  public Language getLanguage() { return getCompilation().getLanguage(); }
  
  public ObjectType getResultType() { return ctype; }
  
  public boolean resultTypeExtends(ObjectType other) { return ctype.isSubtype(other); }
  
  public boolean resultTypeExtends(Class other) {
    return ctype.isSubtype(ClassType.make(other));
  }
  

  public CompileBuildObject() {}
  
  public Expression getArg(int i) { return exp.getArg(i); }
  public int getArgCount() { return exp.getArgCount(); }
  public void setArg(int i, Expression arg) { exp.setArg(i, arg); }
  public int numKeywordArgs() { return exp.numKeywordArgs; }
  public int keywordStart() { return exp.numKeywordArgs == 0 ? 1 : exp.firstKeywordArgIndex - 1; }
  

  public void insertArgument(int index, Expression arg)
  {
    Expression[] args = exp.getArgs();
    Expression[] xargs = new Expression[args.length + 1];
    System.arraycopy(args, 0, xargs, 0, index);
    xargs[index] = arg;
    System.arraycopy(args, index, xargs, index + 1, args.length - index);
    exp.setArgs(xargs);
    exp.adjustSplice(exp, 1);
  }
  
  protected void init(ApplyExp exp, InlineCalls visitor, Type required, ObjectType ctype, ClassType caller)
  {
    this.exp = exp;
    this.visitor = visitor;
    this.required = required;
    this.ctype = ctype;
    this.caller = caller;
  }
  

  public static CompileBuildObject make(ApplyExp exp, InlineCalls visitor, Type required, ObjectType ctype, ClassType caller)
  {
    String builderName = null;
    Class builderClass = null;
    Compilation comp = visitor.getCompilation();
    Namespace ns = Namespace.valueOfNoCreate("gnu.kawa.reflect/ObjectBuilder");
    if (ns != null) {
      ObjectType btype = ctype;
      while (builderName == null) {
        gnu.mapping.Symbol sym = ns.lookup(btype.getName());
        if (sym != null) {
          Declaration builderDecl = comp.lookup(sym, 1);
          
          if (builderDecl != null) {
            builderDecl = Declaration.followAliases(builderDecl);
            Object val = builderDecl.getValue().valueIfConstant();
            if ((val instanceof String))
              builderName = (String)val;
            if ((val instanceof Class)) {
              builderClass = (Class)val;
              builderName = builderClass.getName();
            }
          }
        }
        if (!(btype instanceof ClassType))
          break;
        btype = ((ClassType)btype).getSuperclass();
        if ((btype == null) || (btype == Type.objectType)) break;
      }
    }
    CompileBuildObject builder;
    if (builderName != null) {
      ClassLoader loader = ObjectType.getContextClassLoader();
      try {
        if (builderClass == null)
          builderClass = Class.forName(builderName, false, loader);
        builder = (CompileBuildObject)builderClass.newInstance();
      }
      catch (Exception ex) {
        comp.error('w', "while creating " + builderName + " for " + ctype + " - caught " + ex + " loader:" + loader);
        CompileBuildObject builder = new CompileBuildObject();
      } } else { CompileBuildObject builder;
      if ((ctype instanceof LangObjType)) {
        builder = ((LangObjType)ctype).getBuildObject();
      } else
        builder = new CompileBuildObject(); }
    builder.init(exp, visitor, required, ctype, caller);
    return builder;
  }
  


  public void setDefaultConstructor(PrimProcedure proc)
  {
    defaultConstructor = proc;
    defaultConstructorSet = true;
  }
  
  public PrimProcedure getDefaultConstructor() {
    if (!defaultConstructorSet) {
      Type rtype = ctype.getRealType();
      if ((rtype instanceof ClassType)) {
        Method meth = ((ClassType)rtype).getDefaultConstructor();
        if (meth != null)
          defaultConstructor = new PrimProcedure(meth, getLanguage());
      }
      defaultConstructorSet = true;
    }
    return defaultConstructor;
  }
  
  public boolean hasDefaultConstructor() {
    return getDefaultConstructor() != null;
  }
  
  public boolean hasAddChildMethod() {
    return ClassMethods.selectApplicable(ClassMethods.getMethods(ctype, getAddChildMethodName(), 'V', null, getLanguage()), 2, false) > 0;
  }
  
  public Member findNamedMember(String name)
  {
    Member member = SlotSet.lookupMember(ctype, name, caller);
    if (member == null)
    {


      String mname = name.length() == 0 ? getAddChildMethodName() : ClassExp.slotToMethodName("add", name);
      
      member = ctype.getMethod(mname, SlotSet.type1Array);
    }
    return member;
  }
  
  public Expression buildSetter(Declaration target, Member member, Expression value) {
    return CompileReflect.makeSetterCall(new ReferenceExp(target), member, value);
  }
  
  public String getAddChildMethodName() {
    return "add";
  }
  
  public Expression buildAddChild(Declaration target, Expression child) {
    Expression[] iargs = { new ReferenceExp(target), QuoteExp.getInstance(getAddChildMethodName()), child };
    



    return new ApplyExp(Invoke.invoke, iargs);
  }
  



  public boolean useBuilder(int numCode, InlineCalls visitor)
  {
    if ((numKeywordArgs() > 0) && (numCode > 0))
      return true;
    if ((numCode == -917504) && (hasDefaultConstructor()) && (hasAddChildMethod()))
    {

      return true;
    }
    
    return false;
  }
  
  public Expression build() {
    Compilation comp = getCompilation();
    Expression[] args = exp.getArgs();
    StringBuffer errbuf = null;
    Expression e;
    Expression e;
    if (numKeywordArgs() > 0) {
      int keywordStart = keywordStart();
      Expression[] xargs = new Expression[keywordStart];
      System.arraycopy(args, 0, xargs, 0, keywordStart);
      e = visitor.visit(new ApplyExp(exp.getFunction(), xargs), ctype);
    }
    else {
      ApplyExp ae = new ApplyExp(defaultConstructor, new Expression[] { args[0] });
      ae.setType(ctype);
      e = ae;
    }
    
    comp.letStart();
    Declaration adecl = comp.letVariable((String)null, ctype, e);
    adecl.setFlag(549755813888L);
    adecl.setCanRead(true);
    BeginExp begin = new BeginExp();
    int numKeys = numKeywordArgs();
    int keywordStart = keywordStart();
    for (int j = 0; j < numKeys; j++) {
      int i = keywordStart + 2 * j;
      Object value = args[i].valueIfConstant();
      String name = ((Keyword)value).getName();
      Member slot = findNamedMember(name);
      if (slot == null) {
        comp.error('w', "no field or setter '" + name + "' in class " + ctype.getName());
      } else {
        begin.add(visitor.visit(buildSetter(adecl, slot, args[(i + 1)]), Type.voidType));
      }
    }
    for (int i = keywordStart + 2 * numKeys; i < args.length; i++) {
      begin.add(visitor.visit(buildAddChild(adecl, args[i]), null));
    }
    ReferenceExp aref = new ReferenceExp(adecl);
    aref.setFlag(32);
    begin.add(aref);
    
    return visitor.checkType(comp.letDone(begin).setLine(exp), required);
  }
}
