package kawa.lib.scheme; import gnu.mapping.CallContext;

public class eval extends gnu.expr.ModuleBody { private static void $runBody$() { ; gnu.lists.Consumer $result = getInstanceconsumer; }
  
  public static final gnu.expr.ModuleMethod environment;
  public static final gnu.expr.ModuleMethod eval;
  public static eval $instance;
  static final gnu.mapping.SimpleSymbol Lit0;
  static final gnu.mapping.SimpleSymbol Lit1 = gnu.mapping.Symbol.valueOf("environment");
  public int match1(gnu.expr.ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext) { if (selector == 1) { value1 = paramObject;proc = paramModuleMethod;pc = 1;return 0; } return super.match1(paramModuleMethod, paramObject, paramCallContext); } public int match2(gnu.expr.ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext) { if (selector == 1) { value1 = paramObject1; Object tmp25_22 = gnu.mapping.Promise.force(paramObject2, gnu.mapping.Environment.class); if (!(tmp25_22 instanceof gnu.mapping.Environment)) return -786430; value2 = tmp25_22;proc = paramModuleMethod;pc = 2;return 0; } return super.match2(paramModuleMethod, paramObject1, paramObject2, paramCallContext); } public void apply(CallContext paramCallContext) { switch (pc) {case 1:  eval$X(value1, paramCallContext);return; } try { eval$X(value1, (gnu.mapping.Environment)(localObject = gnu.mapping.Promise.force(value2, gnu.mapping.Environment.class)), paramCallContext); return; } catch (ClassCastException localClassCastException) { Object localObject; throw new gnu.mapping.WrongType(localClassCastException, "eval", 2, localObject); } gnu.expr.ModuleMethod.applyError(); } public static void eval$X(Object exp, gnu.mapping.Environment env, CallContext $ctx) { gnu.lists.Consumer $result = consumer;
    kawa.lang.Eval.evalForm$X(exp, env, $ctx); }
  
  public int matchN(gnu.expr.ModuleMethod paramModuleMethod, Object[] paramArrayOfObject, CallContext paramCallContext) { if (selector == 3) { values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0; } return super.matchN(paramModuleMethod, paramArrayOfObject, paramCallContext); } public Object applyN(gnu.expr.ModuleMethod paramModuleMethod, Object[] paramArrayOfObject) { if (selector == 3) return environment$V(paramArrayOfObject); return super.applyN(paramModuleMethod, paramArrayOfObject); } public static gnu.mapping.Environment environment$V(Object[] argsArray) { gnu.lists.LList localLList1; gnu.lists.LList specifiers = localLList1 = gnu.lists.LList.makeList(argsArray, 0);
    kawa.standard.ImportFromLibrary importer = kawa.standard.ImportFromLibrary.instance;
    kawa.standard.Scheme language = kawa.standard.Scheme.getR7rsInstance();
    gnu.text.SourceMessages messages = new gnu.text.SourceMessages();
    gnu.expr.NameLookup lexical = new gnu.expr.NameLookup(language);
    kawa.standard.SchemeCompilation tr = new kawa.standard.SchemeCompilation(language, messages, lexical);immediate = true;
    
    gnu.expr.ModuleExp module = tr.pushNewModule(null);
    gnu.mapping.SimpleEnvironment env = gnu.mapping.Environment.make(gnu.kawa.functions.Format.formatToString(0, new Object[] { "~{~a~^ ~}", specifiers }));
    importer.scanForm(kawa.lib.lists.cons(Boolean.FALSE, specifiers), module, tr);
    if (messages.seenErrors())
      throw new gnu.text.SyntaxException(messages);
    for (;;) { gnu.expr.Declaration decl = module.firstDecl(); gnu.kawa.reflect.StaticFieldLocation loc; if (decl != null)
      {


        loc = gnu.kawa.reflect.StaticFieldLocation.make(gnu.expr.Declaration.followAliases(decl)); }
      try { env.addLocation((gnu.mapping.Symbol)(localObject = gnu.mapping.Promise.force(decl.getSymbol(), gnu.mapping.Symbol.class)), null, loc);tmpTernaryOp = decl.nextDecl(); } catch (ClassCastException localClassCastException) { Object localObject; throw new gnu.mapping.WrongType(
        
          localClassCastException, "gnu.mapping.SimpleEnvironment.addLocation(gnu.mapping.Symbol,java.lang.Object,gnu.mapping.Location)", 2, localObject);
      }
    }
    env.setLocked();
    return env;
  }
  
  public static void eval$X(Object paramObject, CallContext paramCallContext)
  {
    eval$X(paramObject, gnu.mapping.Environment.user(), paramCallContext);
  }
  
  static
  {
    Lit0 = gnu.mapping.Symbol.valueOf("eval");
    $instance = new eval();
    eval localEval = $instance;
    eval = new gnu.expr.ModuleMethodWithContext(localEval, 1, Lit0, 8193);
    environment = new gnu.expr.ModuleMethod(localEval, 3, Lit1, 61440);
    $runBody$();
  }
  
  public eval()
  {
    gnu.expr.ModuleInfo.register(this);
  }
}
