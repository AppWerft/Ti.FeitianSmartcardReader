package kawa.lib; import gnu.expr.ModuleMethod;

public class windows extends gnu.expr.ModuleBody { private static void $runBody$() { ; gnu.lists.Consumer $result = getInstanceconsumer; }
  
  public int match0(ModuleMethod paramModuleMethod, gnu.mapping.CallContext paramCallContext) { if (selector == 1) { proc = paramModuleMethod;pc = 0;return 0; } return super.match0(paramModuleMethod, paramCallContext); } public int match1(ModuleMethod paramModuleMethod, Object paramObject, gnu.mapping.CallContext paramCallContext) { if (selector == 1) { value1 = paramObject;proc = paramModuleMethod;pc = 1;return 0; } return super.match1(paramModuleMethod, paramObject, paramCallContext); } public Object apply0(ModuleMethod paramModuleMethod) { if (selector == 1) { schemeWindow();return gnu.mapping.Values.empty; } return super.apply0(paramModuleMethod); } public Object apply1(ModuleMethod paramModuleMethod, Object paramObject) { if (selector == 1) { schemeWindow(paramObject);return gnu.mapping.Values.empty; } return super.apply1(paramModuleMethod, paramObject); }
  
  public static void schemeWindow(Object share) { gnu.expr.Language language = kawa.standard.Scheme.getInstance();
    

    gnu.mapping.Environment env = gnu.expr.KawaConvert.isTrue(share) ? misc.interactionEnvironment() : language.getNewEnvironment();
    try { new kawa.GuiConsole(language, env, gnu.expr.KawaConvert.isTrue(localObject = gnu.mapping.Promise.force(share))); return; } catch (ClassCastException localClassCastException) { Object localObject; throw new gnu.mapping.WrongType(localClassCastException, "kawa.GuiConsole.<init>(gnu.expr.Language,gnu.mapping.Environment,boolean)", 3, localObject);
    }
  }
  
  public static final ModuleMethod scheme$Mnwindow;
  public static windows $instance;
  static final gnu.mapping.SimpleSymbol Lit0 = gnu.mapping.Symbol.valueOf("scheme-window");
  public static void schemeWindow()
  {
    schemeWindow(Boolean.FALSE);
  }
  
  static
  {
    $instance = new windows();
    windows localWindows = $instance;
    scheme$Mnwindow = new ModuleMethod(localWindows, 1, Lit0, 4096);
    $runBody$();
  }
  
  public windows()
  {
    gnu.expr.ModuleInfo.register(this);
  }
  
  public void apply(gnu.mapping.CallContext paramCallContext)
  {
    ModuleMethod.applyError();
  }
}
