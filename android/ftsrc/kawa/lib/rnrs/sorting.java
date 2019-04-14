package kawa.lib.rnrs; import gnu.expr.ModuleMethod;

public class sorting extends gnu.expr.ModuleBody { private static void $runBody$() { ; gnu.lists.Consumer $result = getInstanceconsumer;
  }
  
  public static final ModuleMethod list$Mnsort;
  public static final ModuleMethod vector$Mnsort;
  public static final ModuleMethod vector$Mnsort$Ex;
  public static sorting $instance;
  static final gnu.mapping.SimpleSymbol Lit0;
  static final gnu.mapping.SimpleSymbol Lit1;
  static final gnu.mapping.SimpleSymbol Lit2 = gnu.mapping.Symbol.valueOf("vector-sort!");
  public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, gnu.mapping.CallContext paramCallContext)
  {
    switch (selector) {case 3:  value1 = paramObject1;value2 = paramObject2;proc = paramModuleMethod;pc = 2;return 0;
    case 2: 
      value1 = paramObject1;value2 = paramObject2;proc = paramModuleMethod;pc = 2;return 0;
    case 1: 
      value1 = paramObject1;value2 = paramObject2;proc = paramModuleMethod;pc = 2;return 0; } return super.match2(paramModuleMethod, paramObject1, paramObject2, paramCallContext); }
  public static Object listSort(Object less$Qu, Object list) { return kawa.lib.srfi95.$PcSortList(kawa.standard.append.append$V(new Object[] { list, gnu.lists.LList.Empty }), less$Qu, Boolean.FALSE); }
  
  public static gnu.lists.FVector vectorSort(Object less$Qu, Object seq) {
    try { return kawa.lib.srfi95.$PcSortVector((gnu.lists.Sequence)(localObject = gnu.mapping.Promise.force(seq, gnu.lists.Sequence.class)), less$Qu, Boolean.FALSE); } catch (ClassCastException localClassCastException) { Object localObject; throw new gnu.mapping.WrongType(localClassCastException, "%sort-vector", 1, localObject);
    }
  }
  
  public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
  {
    switch (selector) {case 1:  return listSort(paramObject1, paramObject2);
    
    case 2: 
      return vectorSort(paramObject1, paramObject2);
    
    case 3: 
      vectorSort$Ex(paramObject1, paramObject2);return gnu.mapping.Values.empty; } return super.apply2(paramModuleMethod, paramObject1, paramObject2); }
  public static void vectorSort$Ex(Object proc, Object vector) { try { kawa.lib.srfi95.$PcVectorSort$Ex((gnu.lists.Sequence)(localObject = gnu.mapping.Promise.force(vector, gnu.lists.Sequence.class)), proc, Boolean.FALSE);return; } catch (ClassCastException localClassCastException) { Object localObject; throw new gnu.mapping.WrongType(localClassCastException, "%vector-sort!", 1, localObject);
    }
  }
  
  static
  {
    Lit1 = gnu.mapping.Symbol.valueOf("vector-sort");
    Lit0 = gnu.mapping.Symbol.valueOf("list-sort");
    $instance = new sorting();
    sorting localSorting = $instance;
    list$Mnsort = new ModuleMethod(localSorting, 1, Lit0, 8194);
    vector$Mnsort = new ModuleMethod(localSorting, 2, Lit1, 8194);
    vector$Mnsort$Ex = new ModuleMethod(localSorting, 3, Lit2, 8194);
    $runBody$();
  }
  
  public sorting()
  {
    gnu.expr.ModuleInfo.register(this);
  }
  
  public void apply(gnu.mapping.CallContext paramCallContext)
  {
    ModuleMethod.applyError();
  }
}
