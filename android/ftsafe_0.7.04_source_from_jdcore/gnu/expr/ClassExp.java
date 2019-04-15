package gnu.expr;

import gnu.bytecode.ClassType;
import gnu.bytecode.Method;
import gnu.bytecode.Type;


public class ClassExp
  extends LambdaExp
{
  int state;
  static final int PARTS_PREDECLARED = 1;
  static final int TYPES_SET = 2;
  static final int PARTS_DECLARED = 3;
  private boolean simple;
  public static final int IS_ABSTRACT = 32768;
  public static final int INTERFACE_SPECIFIED = 65536;
  
  public boolean isSimple() { return simple; }
  
  public final boolean isAbstract() { return getFlag(32768); }
  


  public static final int CLASS_SPECIFIED = 131072;
  

  public static final int HAS_SUBCLASS = 262144;
  
  public static final int IS_PACKAGE_MEMBER = 524288;
  
  boolean explicitInit;
  
  ClassType instanceType;
  
  public String classNameSpecifier;
  
  public Expression[] supers;
  
  public boolean isMakingClassPair()
  {
    return compiledType != instanceType;
  }
  




  protected Type calculateType()
  {
    return simple ? Compilation.typeClass : Compilation.typeClassType;
  }
  


  public ClassType getClassType() { return compiledType; }
  
  public void setClassType(ClassType type) {
    compiledType = type;
    instanceType = type;
  }
  




  public int superClassIndex = -1;
  

  public LambdaExp initMethod;
  

  public LambdaExp clinitMethod;
  


  public ClassExp(boolean simple, ClassType type)
  {
    this.simple = simple;
    setClassType(type);
  }
  
  protected boolean mustCompile() { return true; }
  
  public void compile(Compilation comp, Target target) {
    if ((target instanceof IgnoreTarget))
      return;
    compilePushClass(comp, target);
  }
  
  public void compilePushClass(Compilation comp, Target target) {
    ClassType new_class = compiledType;
    
    gnu.bytecode.CodeAttr code = comp.getCode();
    ClassType typeClass = Type.javalangClassType;
    

    boolean needsLink = getNeedsClosureEnv();
    comp.loadClassRef(new_class);
    ClassType typeType; ClassType typeType; if ((isSimple()) && (!needsLink)) {
      typeType = typeClass; } else { int nargs;
      int nargs;
      if ((isMakingClassPair()) || (needsLink)) {
        if (new_class == instanceType) {
          code.emitDup(instanceType);
        } else
          comp.loadClassRef(instanceType);
        ClassType typeType = ClassType.make("gnu.expr.PairClassType");
        nargs = needsLink ? 3 : 2;
      } else {
        typeType = Compilation.typeType;
        nargs = 1;
      }
      Type[] argsClass = new Type[nargs];
      if (needsLink) {
        getOwningLambda().loadHeapFrame(comp);
        argsClass[(--nargs)] = Type.objectType;
      }
      for (;;) { nargs--; if (nargs < 0) break; argsClass[nargs] = typeClass; }
      Method makeMethod = typeType.addMethod("make", argsClass, typeType, 9);
      

      code.emitInvokeStatic(makeMethod);
    }
    target.compileFromStack(comp, typeType);
  }
  
  protected ClassType getCompiledClassType(Compilation comp) {
    return compiledType;
  }
  








  public void createFields(Compilation comp)
  {
    if (state >= 1)
      return;
    state = 1;
    java.util.Hashtable<String, Declaration> seenFields = new java.util.Hashtable();
    
    for (Declaration decl = firstDecl(); 
        decl != null; decl = decl.nextDecl())
    {
      if (decl.getCanRead()) {
        int flags = decl.getAccessFlags((short)1);
        if (decl.getFlag(2048L))
          flags |= 0x8;
        String fname = Mangling.mangleNameIfNeeded(decl.getName());
        field = instanceType.addField(fname, null, flags);
        
        Declaration old = (Declaration)seenFields.get(fname);
        if (old != null)
          duplicateDeclarationError(old, decl, comp);
        seenFields.put(fname, decl);
      }
    }
  }
  
  public void setTypes(Compilation comp) {
    if (state >= 2)
      return;
    createFields(comp);
    state = 2;
    int nsupers = supers == null ? 0 : supers.length;
    ClassType[] superTypes = new ClassType[nsupers];
    ClassType superType = null;
    int j = 0;
    for (int i = 0; i < nsupers; i++) {
      Type st = Language.getDefaultLanguage().getTypeFor(supers[i]);
      ClassType t;
      if ((st instanceof ClassType)) {
        t = (ClassType)st; } else { ClassType t;
        if ((st instanceof gnu.bytecode.ParameterizedType)) {
          t = ((gnu.bytecode.ParameterizedType)st).getRawType();
        } else {
          comp.setLine(supers[i]);
          comp.error('e', "invalid super type");
          continue;
        } }
      ClassType t;
      int modifiers;
      try { modifiers = t.getModifiers();
      } catch (RuntimeException ex) {
        modifiers = 0;
        if (comp != null)
          comp.error('e', "unknown super-type " + t.getName());
      }
      if ((modifiers & 0x200) == 0) {
        if (j < i)
          comp.error('e', "duplicate superclass for " + this);
        superType = t;
        superClassIndex = i;
      } else {
        superTypes[(j++)] = t;
      } }
    if ((superType != null) && ((flags & 0x10000) != 0))
      comp.error('e', "cannot be interface since has superclass");
    if ((!simple) && (superType == null) && ((flags & 0x20000) == 0) && ((getFlag(262144)) || ((nameDecl != null) && (nameDecl.isPublic()))))
    {



      PairClassType ptype = new PairClassType();
      compiledType = ptype;
      ptype.setInterface(true);
      instanceType = instanceType;
      ClassType[] interfaces = { compiledType };
      
      instanceType.setSuper(Type.pointer_type);
      instanceType.setInterfaces(interfaces);
    }
    else if (getFlag(65536)) {
      instanceType.setInterface(true); }
    compiledType.setSuper(superType == null ? Type.pointer_type : superType);
    ClassType[] interfaces;
    ClassType[] interfaces;
    if (j == nsupers) {
      interfaces = superTypes;
    } else {
      interfaces = new ClassType[j];
      System.arraycopy(superTypes, 0, interfaces, 0, j);
    }
    compiledType.setInterfaces(interfaces);
    
    if (compiledType.getName() == null) {
      compiledType.setName(getClassName(comp));
    }
    
    if (compiledType != mainClass)
      comp.addClass(compiledType);
    if (isMakingClassPair()) {
      instanceType.setName(compiledType.getName() + "$class");
      comp.addClass(instanceType);
      


      gnu.bytecode.Field prev = null;
      for (Declaration decl = firstDecl(); 
          decl != null; decl = decl.nextDecl()) {
        gnu.bytecode.Field fld = field;
        if (decl.getCanRead()) {
          int fflags = field.getFlags() | 0x400;
          String gname = slotToMethodName("get", decl.getName());
          getterMethod = compiledType.addMethod(gname, fflags, Type.typeArray0, null);
          

          String sname = slotToMethodName("set", decl.getName());
          Type[] stypes = { null };
          setterMethod = compiledType.addMethod(sname, fflags, stypes, Type.voidType);
          

          instanceType.removeField(fld, prev);
          field = null;
        }
        prev = fld;
      }
    }
  }
  
  public String getClassName(Compilation comp) { String name;
    String name;
    if (classNameSpecifier != null) {
      name = classNameSpecifier;
    } else {
      name = getName();
      if (name != null) {
        int nlen = name.length();
        if ((nlen > 2) && (name.charAt(0) == '<') && (name.charAt(nlen - 1) == '>'))
        {
          name = name.substring(1, nlen - 1); }
      }
    }
    if (name == null) {
      StringBuffer nbuf = new StringBuffer(100);
      comp.getModule().classFor(comp);
      nbuf.append(mainClass.getName());
      nbuf.append('$');
      int len = nbuf.length();
      for (int i = 0;; i++) {
        nbuf.append(i);
        name = nbuf.toString();
        if (comp.findNamedClass(name) == null)
          break;
        nbuf.setLength(len);
      }
    }
    else if ((!isSimple()) || ((this instanceof ObjectExp))) {
      name = comp.generateClassName(name);
    } else {
      int start = 0;
      StringBuilder nbuf = new StringBuilder(100);
      for (;;)
      {
        int dot = name.indexOf('.', start);
        if (dot < 0)
          break;
        nbuf.append(Mangling.mangleClassName(name.substring(start, dot)));
        
        start = dot + 1;
        if (start < name.length()) {
          nbuf.append('.');
        }
      }
      
      if (start == 0) {
        setFlag(524288);
        String mainName = mainClass == null ? null : mainClass.getName();
        
        int dot = mainName == null ? -1 : mainName.lastIndexOf('.');
        if (dot > 0) {
          nbuf.append(mainName.substring(0, dot + 1));
        } else if (classPrefix != null) {
          nbuf.append(classPrefix);
        }
      } else if ((start == 1) && (start < name.length()))
      {
        nbuf.setLength(0);
        nbuf.append(mainClass.getName());
        nbuf.append('$');
      }
      else {
        setFlag(524288); }
      if (start < name.length()) {
        nbuf.append(Mangling.mangleClassName(name.substring(start)));
      }
      name = nbuf.toString();
    }
    return name;
  }
  
  public void declareParts(Compilation comp) {
    if (state >= 3)
      return;
    setTypes(comp);
    state = 3;
    for (Declaration decl = firstDecl(); 
        decl != null; decl = decl.nextDecl()) {
      if (decl.getCanRead()) {
        if (isMakingClassPair()) {
          Type ftype = decl.getType().getImplementationType();
          getterMethod.setReturnType(ftype);
          setterMethod.getParameterTypes()[0] = ftype;
        } else {
          decl.setSimple(false);
          field.setType(decl.getType());
        }
      }
    }
    
    for (LambdaExp child = firstChild; child != null; 
        child = nextSibling) {
      if (child.isAbstract())
        setFlag(32768);
      if ("*init*".equals(child.getName())) {
        explicitInit = true;
        if (child.isAbstract())
          comp.error('e', "*init* method cannot be abstract", child);
        if ((compiledType instanceof PairClassType)) {
          comp.error('e', "'*init*' methods only supported for simple classes");
        }
      }
      



      child.setOuter(this);
      if (((child != initMethod) && (child != clinitMethod) && (nameDecl != null) && (!nameDecl.getFlag(2048L))) || (!isMakingClassPair()))
      {


        child.addMethodFor(compiledType, comp, null); }
      if (isMakingClassPair())
        child.addMethodFor(instanceType, comp, compiledType);
    }
    if ((!explicitInit) && (!instanceType.isInterface()))
      Compilation.getConstructor(instanceType, this);
    int instanceModifiers = instanceType.getModifiers();
    if (isAbstract()) {
      instanceModifiers |= 0x400;
      instanceType.setModifiers(instanceModifiers);
    }
    if (nameDecl != null) {
      instanceType.setModifiers(instanceModifiers & 0xFFFFFFFE | nameDecl.getAccessFlags((short)1));
    }
  }
  













  static void getImplMethods(ClassType interfaceType, String mname, Type[] paramTypes, java.util.ArrayList<Method> vec)
  {
    getImplMethods(interfaceType, mname, paramTypes, vec, null);
  }
  
  private static void getImplMethods(ClassType interfaceType, String mname, Type[] paramTypes, java.util.ArrayList<Method> vec, Type[] itypes)
  {
    ClassType implType;
    ClassType implType;
    if ((interfaceType instanceof PairClassType)) {
      implType = instanceType;
    } else { if (!interfaceType.isInterface()) {
        return;
      }
      try {
        Class reflectClass = interfaceType.getReflectClass();
        if (reflectClass == null)
          return;
        String implTypeName = interfaceType.getName() + "$class";
        ClassLoader loader = reflectClass.getClassLoader();
        
        Class implClass = Class.forName(implTypeName, false, loader);
        


        implType = (ClassType)Type.make(implClass);
      } catch (Exception ex) {
        return;
      }
    }
    if (itypes == null) {
      itypes = new Type[paramTypes.length + 1];
      System.arraycopy(paramTypes, 0, itypes, 1, paramTypes.length);
    }
    itypes[0] = interfaceType;
    Method implMethod = implType.getDeclaredMethod(mname, itypes);
    if (implMethod != null) {
      int count = vec.size();
      if ((count == 0) || (!((Method)vec.get(count - 1)).equals(implMethod)))
        vec.add(implMethod);
    } else {
      ClassType[] superInterfaces = interfaceType.getInterfaces();
      for (int i = 0; i < superInterfaces.length; i++) {
        getImplMethods(superInterfaces[i], mname, paramTypes, vec, itypes);
      }
    }
  }
  
  private static void usedSuperClasses(ClassType clas, Compilation comp)
  {
    comp.usedClass(clas.getSuperclass());
    ClassType[] interfaces = clas.getInterfaces();
    if (interfaces != null) {
      int i = interfaces.length; for (;;) { i--; if (i < 0) break;
        comp.usedClass(interfaces[i]);
      }
    }
  }
  
  public ClassType compileMembers(Compilation comp) { ClassType saveClass = curClass;
    Method saveMethod = method;
    try {
      ClassType new_class = getCompiledClassType(comp);
      curClass = new_class;
      
      LambdaExp outer = outerLambda();
      gnu.bytecode.Member enclosing = null;
      if ((outer instanceof ClassExp)) {
        enclosing = compiledType;
      } else if ((outer != null) && (!(outer instanceof ModuleExp))) {
        enclosing = saveMethod;
      } else if (((outer instanceof ModuleExp)) && (!getFlag(524288)))
        enclosing = compiledType;
      if (enclosing != null) {
        new_class.setEnclosingMember(enclosing);
        if ((enclosing instanceof ClassType))
          ((ClassType)enclosing).addMemberClass(new_class);
      }
      if (instanceType != new_class) {
        instanceType.setEnclosingMember(compiledType);
        compiledType.addMemberClass(instanceType);
      }
      
      usedSuperClasses(compiledType, comp);
      if (compiledType != instanceType) {
        usedSuperClasses(instanceType, comp);
      }
      String filename = getFileName();
      if (filename != null) {
        new_class.setSourceFile(filename);
      }
      LambdaExp saveLambda = curLambda;
      curLambda = this;
      
      allocFrame(comp);
      

      if (nameDecl != null)
        nameDecl.compileAnnotations(compiledType, java.lang.annotation.ElementType.TYPE);
      for (Declaration decl = firstDecl(); decl != null; 
          decl = decl.nextDecl()) {
        decl.compileAnnotations(field, java.lang.annotation.ElementType.FIELD);
      }
      
      for (LambdaExp child = firstChild; child != null; 
          child = nextSibling)
        if ((!child.isAbstract()) && (!child.isNative()))
        {
          if ((child != clinitMethod) || (compiledType != mainClass))
          {
            Method save_method = method;
            LambdaExp save_lambda = curLambda;
            String saveFilename = comp.getFileName();
            int saveLine = comp.getLineNumber();
            int saveColumn = comp.getColumnNumber();
            comp.setLine(child);
            method = child.getMainMethod();
            
            Declaration childDecl = nameDecl;
            if (childDecl != null)
              childDecl.compileAnnotations(method, java.lang.annotation.ElementType.METHOD);
            curClass = instanceType;
            curLambda = child;
            method.initCode();
            child.allocChildClasses(comp);
            child.allocParameters(comp);
            if ("*init*".equals(child.getName())) {
              gnu.bytecode.CodeAttr code = comp.getCode();
              
              if (staticLinkField != null) {
                code.emitPushThis();
                code.emitLoad(code.getCurrentScope().getVariable(1));
                code.emitPutField(staticLinkField);
              }
              

              Expression bodyFirst = child.getBodyFirstExpression();
              
              ClassType calledInit = checkForInitCall(bodyFirst);
              ClassType superClass = instanceType.getSuperclass();
              if ((calledInit == null) && (superClass != null))
              {

                invokeDefaultSuperConstructor(superClass, comp, this);
                compileCallInitMethods(comp);
              }
              else if (calledInit != instanceType) {
                ((ApplyExp)bodyFirst).setFlag(16); }
              child.enterFunction(comp);
              child.compileBody(comp);
            } else {
              child.enterFunction(comp);
              child.compileBody(comp);
            }
            child.compileEnd(comp);
            child.generateApplyMethods(comp);
            




            Method thisMethod = method;
            Type[] ptypes = thisMethod.getParameterTypes();
            Type rtype = thisMethod.getReturnType();
            ClassType superClass = instanceType.getSuperclass();
            Method superMethod = superClass.getMethod(child.getName(), ptypes);
            
            if ((superMethod != null) && (superMethod.getReturnType().compare(rtype) == 1))
            {
              generateBridgeMethod(comp, thisMethod, ptypes, superMethod.getReturnType());
            }
            

            method = save_method;
            curClass = new_class;
            curLambda = save_lambda;
            comp.setLine(saveFilename, saveLine, saveColumn);
          } }
      if ((!explicitInit) && (!instanceType.isInterface())) {
        comp.generateConstructor(instanceType, this);
      } else if (initChain != null)
        initChain.reportError("unimplemented: explicit constructor cannot initialize ", comp);
      int nmethods;
      Method[] methods;
      int nmethods;
      if (isAbstract()) {
        Method[] methods = null;
        nmethods = 0;
      } else {
        methods = compiledType.getAbstractMethods();
        nmethods = methods.length;
      }
      for (int i = 0; i < nmethods; i++) {
        Method meth = methods[i];
        String mname = meth.getName();
        Type[] ptypes = meth.getParameterTypes();
        Type rtype = meth.getReturnType();
        
        Method mimpl = instanceType.getMethod(mname, ptypes);
        if ((mimpl == null) || (mimpl.isAbstract()))
        {


          java.util.ArrayList<Method> vec = new java.util.ArrayList();
          getImplMethods(compiledType, mname, ptypes, vec);
          char ch; if ((vec.size() == 0) && (mname.length() > 3) && (mname.charAt(2) == 't') && (mname.charAt(1) == 'e') && (((ch = mname.charAt(0)) == 'g') || (ch == 's')))
          {
            Type ftype;
            

            Type ftype;
            
            if ((ch == 's') && (rtype.isVoid()) && (ptypes.length == 1)) {
              ftype = ptypes[0];
            } else { if ((ch != 'g') || (ptypes.length != 0)) continue;
              ftype = rtype;
            }
            
            String fname = Character.toLowerCase(mname.charAt(3)) + mname.substring(4);
            
            gnu.bytecode.Field fld = instanceType.getField(fname);
            if (fld == null) {
              fld = instanceType.addField(fname, ftype, 1);
            }
            Method impl = instanceType.addMethod(mname, 1, ptypes, rtype);
            
            gnu.bytecode.CodeAttr code = impl.startCode();
            code.emitPushThis();
            if (ch == 'g') {
              code.emitGetField(fld);
            } else {
              code.emitLoad(code.getArg(1));
              code.emitPutField(fld);
            }
            code.emitReturn();
          }
          else if (vec.size() != 1) {
            Method impl = vec.size() != 0 ? null : findMethodForBridge(mname, ptypes, rtype);
            

            if (impl != null) {
              generateBridgeMethod(comp, impl, ptypes, rtype);
            }
            else {
              String msg = vec.size() == 0 ? "missing implementation for " : "ambiguous implementation for ";
              

              comp.error('e', msg + meth);
            }
          } else {
            Method impl = instanceType.addMethod(mname, 1, ptypes, rtype);
            

            gnu.bytecode.CodeAttr code = impl.startCode();
            for (gnu.bytecode.Variable var = code.getCurrentScope().firstVar(); 
                var != null; var = var.nextVar())
              code.emitLoad(var);
            code.emitInvokeStatic((Method)vec.get(0));
            code.emitReturn();
          }
        }
      }
      
      generateApplyMethods(comp);
      curLambda = saveLambda;
      
      return new_class;
    } finally {
      curClass = saveClass;
      method = saveMethod;
    }
  }
  
  void compileCallInitMethods(Compilation comp) { comp.callInitMethods(getCompiledClassType(comp), new java.util.ArrayList(10)); }
  







  protected Method findMethodForBridge(String mname, Type[] ptypes, Type rtype)
  {
    Method result = null;
    for (Method method = compiledType.getDeclaredMethods(); 
        method != null; method = method.getNext()) {
      if ((mname.equals(method.getName())) && (method.getReturnType().isSubtype(rtype)) && (Type.isMoreSpecific(method.getParameterTypes(), ptypes)))
      {

        result = method; }
    }
    return result;
  }
  






  public final void generateBridgeMethod(Compilation comp, Method src_method, Type[] bridge_arg_types, Type bridge_return_type)
  {
    ClassType save_class = curClass;
    Method save_method = method;
    try {
      curClass = getCompiledClassType(comp);
      method = curClass.addMethod(src_method.getName(), 4161, bridge_arg_types, bridge_return_type);
      


      Type[] src_arg_types = src_method.getParameterTypes();
      
      gnu.bytecode.CodeAttr code = method.startCode();
      code.emitLoad(code.getArg(0));
      for (int i = 0; i < src_arg_types.length; i++) {
        code.emitLoad(code.getArg(i + 1));
        code.emitCheckcast(src_arg_types[i]);
      }
      code.emitInvokeVirtual(src_method);
      code.emitReturn();
    } finally {
      method = save_method;
      curClass = save_class;
    }
  }
  
  protected <R, D> R visit(ExpVisitor<R, D> visitor, D d) {
    Compilation comp = visitor.getCompilation();
    if (comp == null)
      return visitor.visitClassExp(this, d);
    ClassType saveClass = curClass;
    try {
      curClass = compiledType;
      return visitor.visitClassExp(this, d);
    } finally {
      curClass = saveClass;
    }
  }
  
  protected <R, D> void visitChildren(ExpVisitor<R, D> visitor, D d) {
    LambdaExp save = currentLambda;
    currentLambda = this;
    if (supers != null)
      supers = visitor.visitExps(supers, supers.length, d);
    try {
      for (LambdaExp child = firstChild; 
          (child != null) && (exitValue == null); 
          child = nextSibling) {
        if (instanceType != null) {
          Declaration firstParam = child.firstDecl();
          if ((firstParam != null) && (firstParam.isThisParameter()))
            firstParam.setType(compiledType);
        }
        visitor.visitLambdaExp(child, d);
      }
    } finally {
      currentLambda = save;
    }
  }
  
  static void loadSuperStaticLink(Expression superExp, ClassType superClass, Compilation comp)
  {
    gnu.bytecode.CodeAttr code = comp.getCode();
    
    superExp.compile(comp, Target.pushValue(Compilation.typeClassType));
    code.emitInvokeStatic(ClassType.make("gnu.expr.PairClassType").getDeclaredMethod("extractStaticLink", 1));
    code.emitCheckcast(superClass.getOuterLinkType());
  }
  
  void checkDefaultSuperConstructor(ClassType superClass, Compilation comp) {
    if (superClass.getDeclaredMethod("<init>", 0) == null) {
      comp.error('e', "super class " + superClass.getName() + " does not have a default constructor");
    }
  }
  

  static void invokeDefaultSuperConstructor(ClassType superClass, Compilation comp, LambdaExp lexp)
  {
    gnu.bytecode.CodeAttr code = comp.getCode();
    Method superConstructor = superClass.getDeclaredMethod("<init>", 0);
    


    assert (superConstructor != null);
    code.emitPushThis();
    if ((superClass.hasOuterLink()) && ((lexp instanceof ClassExp))) {
      ClassExp clExp = (ClassExp)lexp;
      Expression superExp = supers[superClassIndex];
      loadSuperStaticLink(superExp, superClass, comp);
    }
    code.emitInvokeSpecial(superConstructor);
  }
  
  public void print(gnu.kawa.io.OutPort out) {
    out.startLogicalBlock("(" + getExpClassName() + "/", ")", 2);
    Object name = getSymbol();
    if (name != null) {
      out.print(name);
      out.print('/');
    }
    out.print(id);
    out.print("/fl:");out.print(Integer.toHexString(flags));
    if (supers.length > 0) {
      out.writeSpaceFill();
      out.startLogicalBlock("supers:", "", 2);
      for (int i = 0; i < supers.length; i++) {
        supers[i].print(out);
        out.writeSpaceFill();
      }
      out.endLogicalBlock("");
    }
    Special prevMode = null;
    int key_args = keywords == null ? 0 : keywords.length;
    
    for (Declaration decl = firstDecl(); decl != null; 
        decl = decl.nextDecl()) {
      out.writeSpaceFill();
      decl.printInfo(out);
    }
    for (LambdaExp child = firstChild; child != null; 
        child = nextSibling) {
      out.writeBreakLinear();
      child.print(out);
    }
    if (body != null) {
      out.writeBreakLinear();
      body.print(out);
    }
    out.endLogicalBlock(")");
  }
  
  public gnu.bytecode.Field compileSetField(Compilation comp) {
    gnu.bytecode.Field field = allocFieldFor(comp);
    if ((!getNeedsClosureEnv()) && (field.getStaticFlag()) && (!immediate) && (type != Type.javalangClassType))
    {
      new Literal(compiledType, type, litTable).assign(field, litTable);
    }
    else
      new ClassInitializer(this, field, comp);
    return field;
  }
  



  public static String slotToMethodName(String prefix, String sname)
  {
    if (!Language.isValidJavaName(sname))
      sname = Mangling.mangleName(sname, false);
    int slen = sname.length();
    StringBuffer sbuf = new StringBuffer(slen + 3);
    sbuf.append(prefix);
    if (slen > 0) {
      sbuf.append(Character.toTitleCase(sname.charAt(0)));
      sbuf.append(sname.substring(1));
    }
    return sbuf.toString();
  }
  
  public Declaration addMethod(LambdaExp lexp, Object mname) {
    Declaration mdecl = addDeclaration(mname, Compilation.typeProcedure);
    lexp.setOuter(this);
    lexp.setClassMethod(true);
    mdecl.noteValue(lexp);
    mdecl.setFlag(1048576L);
    mdecl.setProcedureDecl(true);
    lexp.setSymbol(mname);
    return mdecl;
  }
}
