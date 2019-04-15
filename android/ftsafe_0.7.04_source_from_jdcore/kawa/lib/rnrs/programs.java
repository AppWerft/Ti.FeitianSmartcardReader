package kawa.lib.rnrs; import gnu.expr.ModuleMethod;

public class programs extends gnu.expr.ModuleBody { private static void $runBody$() { ; gnu.lists.Consumer $result = getInstanceconsumer;
  }
  





  public static final ModuleMethod command$Mnline;
  




  public static final ModuleMethod exit;
  




  public static final ModuleMethod emergency$Mnexit;
  




  static final gnu.math.IntNum Lit0;
  



  public static programs $instance;
  



  static final gnu.mapping.SimpleSymbol Lit1;
  



  static final gnu.mapping.SimpleSymbol Lit2;
  



  static final gnu.mapping.SimpleSymbol Lit3 = gnu.mapping.Symbol.valueOf("emergency-exit");
  



  public int match0(ModuleMethod paramModuleMethod, gnu.mapping.CallContext paramCallContext)
  {
    switch (selector) {case 4:  proc = paramModuleMethod;pc = 0;return 0;
    case 2: 
      proc = paramModuleMethod;pc = 0;return 0;
    case 1: 
      proc = paramModuleMethod;pc = 0;return 0; } return super.match0(paramModuleMethod, paramCallContext);
  }
  
  public static gnu.lists.LList commandLine() { gnu.lists.LList rest = gnu.lists.LList.makeList(gnu.expr.ApplicationMainSupport.commandLineArgArray, 0);
    

    String command$Mnname = (String)gnu.expr.ApplicationMainSupport.commandName.get(null);
    


    Object localObject;
    

    try
    {
      String raw1 = System.getProperty("kawa.command.line");
      


      String raw2 = System.getProperty("sun.java.command");String raw = raw1 == null ? 
      
        "java ".concat(raw2) : raw2 == null ? null : raw1;
      



      String frest = gnu.kawa.functions.Format.formatToString(0, new Object[] { "~{ ~a~}", rest });
      int rlen = raw.length();
      int flen = frest.length();
      int alen = rlen - flen;
      if (alen >= 0) {}
      
      Throwable exp;
      
      localObject = raw.substring(alen).equals(frest) ? raw.substring(0, alen) : flen == 0 ? raw : raw == null ? null : null; } catch (Throwable localThrowable1) { localObject = null; } String command = localObject;String arg0 = command$Mnname == null ? 
    


      command : command == null ? "kawa" : command$Mnname;
    
    return kawa.lib.lists.cons(arg0, rest);
  }
  




  public int match1(ModuleMethod paramModuleMethod, Object paramObject, gnu.mapping.CallContext paramCallContext)
  {
    switch (selector) {case 4:  value1 = paramObject;proc = paramModuleMethod;pc = 1;return 0;
    case 2: 
      value1 = paramObject;proc = paramModuleMethod;pc = 1;return 0; } return super.match1(paramModuleMethod, paramObject, paramCallContext); }
  
  public static void exit(Object code) { if (kawa.lib.numbers.isInteger(code)) {} try { tmpTernaryOp = ((Number)(localObject = gnu.mapping.Promise.force(code))).intValue();int status = gnu.expr.KawaConvert.isTrue(code) ? 0 : -1;
      

      gnu.kawa.util.ExitCalled.doExit(status); return;
    }
    catch (ClassCastException localClassCastException)
    {
      Object localObject;
      throw new gnu.mapping.WrongType(
      

        localClassCastException, "status", -2, localObject);
    }
  }
  
  public Object apply0(ModuleMethod paramModuleMethod)
  {
    switch (selector) {case 1:  return commandLine();
    







































    case 2: 
      exit();return gnu.mapping.Values.empty;
    




    case 4: 
      emergencyExit();return gnu.mapping.Values.empty; } return super.apply0(paramModuleMethod);
  }
  
  public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
  {
    switch (selector) {case 2:  exit(paramObject);return gnu.mapping.Values.empty;
    




    case 4: 
      emergencyExit(paramObject);return gnu.mapping.Values.empty; } return super.apply1(paramModuleMethod, paramObject); }
  
  public static void emergencyExit(Object code) { if (kawa.lib.numbers.isInteger(code)) {} try { tmpTernaryOp = ((Number)(localObject = gnu.mapping.Promise.force(code))).intValue();int status = gnu.expr.KawaConvert.isTrue(code) ? 0 : -1;
      

      Runtime.getRuntime().halt(status); return;
    }
    catch (ClassCastException localClassCastException)
    {
      Object localObject;
      throw new gnu.mapping.WrongType(
      

        localClassCastException, "status", -2, localObject);
    }
  }
  
  public static void exit()
  {
    exit(Lit0);
  }
  
  public static void emergencyExit()
  {
    emergencyExit(Lit0);
  }
  
  static
  {
    Lit2 = gnu.mapping.Symbol.valueOf("exit");
    Lit1 = gnu.mapping.Symbol.valueOf("command-line");
    Lit0 = gnu.math.IntNum.valueOf(0);
    $instance = new programs();
    programs localPrograms = $instance;
    command$Mnline = new ModuleMethod(localPrograms, 1, Lit1, 0);
    exit = new ModuleMethod(localPrograms, 2, Lit2, 4096);
    emergency$Mnexit = new ModuleMethod(localPrograms, 4, Lit3, 4096);
    $runBody$();
  }
  
  public programs()
  {
    gnu.expr.ModuleInfo.register(this);
  }
  
  public void apply(gnu.mapping.CallContext paramCallContext)
  {
    ModuleMethod.applyError();
  }
}
