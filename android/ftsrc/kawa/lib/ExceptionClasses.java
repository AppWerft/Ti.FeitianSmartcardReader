package kawa.lib; import gnu.mapping.CallContext;

public class ExceptionClasses extends gnu.expr.ModuleBody { private static void $runBody$() { ; gnu.lists.Consumer $result = getInstanceconsumer;
    

    ThreadLocal localThreadLocal;
    
    current$Mnhandler = localThreadLocal = new ThreadLocal();
  }
  
  public static ThreadLocal<HandlerLink> current$Mnhandler;
  public static final Class HandlerLink;
  public static final Class ExceptionWithValue;
  public static ExceptionClasses $instance = new ExceptionClasses();
  static
  {
    HandlerLink = HandlerLink.class;
    ExceptionWithValue = ExceptionWithValue.class;
    $runBody$();
  }
  
  public ExceptionClasses()
  {
    gnu.expr.ModuleInfo.register(this);
  }
}
