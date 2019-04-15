package gnu.expr;

import gnu.bytecode.CodeAttr;

public class ProcInitializer extends Initializer
{
  LambdaExp proc;
  
  public ProcInitializer(LambdaExp lexp, Compilation comp, gnu.bytecode.Field field) {
    this.field = field;
    proc = lexp;
    LambdaExp heapLambda = field.getStaticFlag() ? comp.getModule() : lexp.getOwningLambda();
    
    if (((heapLambda instanceof ModuleExp)) && (comp.isStatic())) {
      next = clinitChain;
      clinitChain = this;
    } else {
      next = initChain;
      initChain = this;
    }
  }
  
  public static void emitLoadModuleMethod(LambdaExp proc, Compilation comp)
  {
    Declaration pdecl = nameDecl;
    Object pname = pdecl == null ? proc.getName() : pdecl.getSymbol();
    ModuleMethod oldproc = null;
    if ((comp.isInteractive()) && (pname != null) && (pdecl != null) && ((context instanceof ModuleExp)))
    {


      ModuleInfo minfo = comp.getMinfo();
      Class oldClass = minfo.getOldModuleClass();
      if ((oldClass != null) && (field != null)) {
        try {
          Object oldpval = oldClass.getField(field.getName()).get(null);
          
          if ((oldpval instanceof ModuleMethod)) {
            oldproc = (ModuleMethod)oldpval;
          }
        } catch (Throwable ex) {}
      }
      if (oldproc == null) {
        gnu.mapping.Environment env = gnu.mapping.Environment.getCurrent();
        gnu.mapping.Symbol sym = (pname instanceof gnu.mapping.Symbol) ? (gnu.mapping.Symbol)pname : gnu.mapping.Symbol.make("", pname.toString().intern());
        
        Object property = comp.getLanguage().getEnvPropertyFor(nameDecl);
        Object old = env.get(sym, property, null);
        if ((old instanceof ModuleMethod)) {
          String moduleName = module.getClass().getName();
          
          if ((moduleName.startsWith("atInteractiveLevel-")) || (moduleName.equals(moduleClass.getName())))
          {
            oldproc = (ModuleMethod)old; }
        }
      }
    }
    CodeAttr code = comp.getCode();
    gnu.bytecode.ClassType procClass = proc.usingCallContext() ? Compilation.typeModuleMethodWithContext : Compilation.typeModuleMethod;
    
    gnu.bytecode.Method initModuleMethod;
    gnu.bytecode.Method initModuleMethod;
    if (oldproc == null) {
      code.emitNew(procClass);
      code.emitDup(1);
      initModuleMethod = procClass.getDeclaredMethod("<init>", 4);
    } else {
      comp.compileConstant(oldproc, Target.pushValue(procClass));
      initModuleMethod = Compilation.typeModuleMethod.getDeclaredMethod("init", 4);
    }
    LambdaExp owning = proc.getNeedsClosureEnv() ? proc.getOwningLambda() : comp.getModule();
    
    if (((owning instanceof ClassExp)) && (staticLinkField != null)) {
      code.emitLoad(code.getCurrentScope().getVariable(1));
    } else if (!(owning instanceof ModuleExp)) {
      owning.loadHeapFrame(comp);
    } else if ((moduleClass == mainClass) && (!method.getStaticFlag()))
    {
      code.emitPushThis();
    } else {
      if ((moduleInstanceVar == null) || (moduleInstanceVar.dead()))
      {
        moduleInstanceVar = locals.current_scope.addVariable(code, moduleClass, "$instance");
        


        if ((moduleClass != mainClass) && (!comp.isStatic())) {
          code.emitNew(moduleClass);
          code.emitDup(moduleClass);
          code.emitInvokeSpecial(moduleClass.constructor);
          if (moduleInstanceMainField == null) {
            moduleInstanceMainField = moduleClass.addField("$main", mainClass, 0);
          }
          code.emitDup(moduleClass);
          code.emitPushThis();
          code.emitPutField(moduleInstanceMainField);
        } else {
          code.emitGetStatic(moduleInstanceMainField); }
        code.emitStore(moduleInstanceVar);
      }
      code.emitLoad(moduleInstanceVar);
    }
    code.emitPushInt(proc.getSelectorValue(comp));
    comp.compileConstant(proc.getProperty(gnu.mapping.PropertySet.nameKey, pname), Target.pushObject);
    


    code.emitPushInt(min_args | (keywords == null ? max_args : -1) << 12);
    
    code.emitInvoke(initModuleMethod);
    
    if (properties != null) {
      int len = properties.length;
      for (int i = 0; i < len; i += 2) {
        Object key = properties[i];
        
        if ((key != null) && (key != gnu.mapping.PropertySet.nameKey)) {
          Object val = properties[(i + 1)];
          code.emitDup(1);
          gnu.bytecode.Field pfld = null;
          if (key == gnu.mapping.Procedure.validateApplyKey) {
            pfld = Compilation.typeProcedure.getDeclaredField("validateApplyKey");
          }
          else if (key == gnu.mapping.Procedure.validateXApplyKey) {
            pfld = Compilation.typeProcedure.getDeclaredField("validateXApplyKey");
          }
          else if (key == gnu.mapping.Procedure.compilerXKey) {
            pfld = Compilation.typeProcedure.getDeclaredField("compilerXKey");
          }
          if (pfld != null) {
            code.emitGetStatic(pfld);
          } else
            comp.compileConstant(key);
          Target target = Target.pushObject;
          if ((val instanceof Expression)) {
            ((Expression)val).compile(comp, target);
          } else
            comp.compileConstant(val, target);
          gnu.bytecode.Method m = gnu.bytecode.ClassType.make("gnu.mapping.PropertySet").getDeclaredMethod("setProperty", 2);
          
          code.emitInvokeVirtual(m);
        }
      }
    }
  }
  
  public void emit(Compilation comp) {
    CodeAttr code = comp.getCode();
    if (!field.getStaticFlag()) {
      code.emitPushThis();
    }
    emitLoadModuleMethod(proc, comp);
    
    if (field.getStaticFlag()) {
      code.emitPutStatic(field);
    } else
      code.emitPutField(field);
  }
  
  public void reportError(String message, Compilation comp) {
    String saveFile = comp.getFileName();
    int saveLine = comp.getLineNumber();
    int saveColumn = comp.getColumnNumber();
    comp.setLocation(proc);
    String name = proc.getName();
    StringBuffer sbuf = new StringBuffer(message);
    if (name == null) {
      sbuf.append("unnamed procedure");
    } else {
      sbuf.append("procedure ");
      sbuf.append(name);
    }
    comp.error('e', sbuf.toString());
    comp.setLine(saveFile, saveLine, saveColumn);
  }
}
