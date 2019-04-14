package kawa.lib.kawa; import gnu.kawa.reflect.StaticFieldLocation;

public class reflect extends gnu.expr.ModuleBody { private static void $runBody$() { ; gnu.lists.Consumer $result = getInstanceconsumer;
  }
  
  public static final StaticFieldLocation invoke;
  public static final StaticFieldLocation invoke$Mnstatic;
  public static final StaticFieldLocation invoke$Mnspecial;
  public static final StaticFieldLocation field;
  public static final StaticFieldLocation static$Mnfield;
  public static final StaticFieldLocation set$Mnfield$Ex;
  public static final StaticFieldLocation set$Mnstatic$Mnfield$Ex;
  public static final StaticFieldLocation make;
  public static final StaticFieldLocation instance$Qu;
  public static final StaticFieldLocation as;
  public static final StaticFieldLocation primitive$Mnthrow;
  public static reflect $instance = new reflect(); static { invoke = StaticFieldLocation.make("gnu.kawa.reflect.Invoke", "invoke");invoke$Mnstatic = StaticFieldLocation.make("gnu.kawa.reflect.Invoke", "invokeStatic");invoke$Mnspecial = StaticFieldLocation.make("gnu.kawa.reflect.Invoke", "invokeSpecial");make = StaticFieldLocation.make("gnu.kawa.reflect.Invoke", "make");
    






    field = StaticFieldLocation.make("gnu.kawa.reflect.SlotGet", "field");static$Mnfield = StaticFieldLocation.make("gnu.kawa.reflect.SlotGet", "staticField");
    



    set$Mnfield$Ex = StaticFieldLocation.make("gnu.kawa.reflect.SlotSet", "set$Mnfield$Ex");set$Mnstatic$Mnfield$Ex = StaticFieldLocation.make("gnu.kawa.reflect.SlotSet", "set$Mnstatic$Mnfield$Ex");
    


    primitive$Mnthrow = StaticFieldLocation.make("gnu.kawa.reflect.Throw", "primitiveThrow");
    


    instance$Qu = StaticFieldLocation.make("kawa.standard.Scheme", "instanceOf");
    


    as = StaticFieldLocation.make("gnu.kawa.functions.Convert", "as");$runBody$();
  }
  
  public reflect()
  {
    gnu.expr.ModuleInfo.register(this);
  }
}
