package kawa.lib;

import gnu.lists.Pair;

public class lists extends gnu.expr.ModuleBody { public static final gnu.expr.ModuleMethod pair$Qu;
  public static final gnu.expr.ModuleMethod cons;
  public static final gnu.expr.ModuleMethod null$Qu;
  public static final gnu.expr.ModuleMethod set$Mncar$Ex;
  public static final gnu.expr.ModuleMethod set$Mncdr$Ex;
  public static final gnu.expr.GenericProc car;
  public static final gnu.expr.GenericProc cdr; public static final gnu.expr.GenericProc caar; public static final gnu.expr.GenericProc cadr; public static final gnu.expr.GenericProc cdar; public static final gnu.expr.GenericProc cddr; public static final gnu.expr.GenericProc caaar; public static final gnu.expr.GenericProc caadr; public static final gnu.expr.GenericProc cadar; public static final gnu.expr.GenericProc caddr; public static final gnu.expr.GenericProc cdaar; public static final gnu.expr.GenericProc cdadr; public static final gnu.expr.GenericProc cddar; public static final gnu.expr.GenericProc cdddr; public static final gnu.expr.GenericProc caaaar; public static final gnu.expr.GenericProc caaadr; public static final gnu.expr.GenericProc caadar; public static final gnu.expr.GenericProc caaddr; public static final gnu.expr.GenericProc cadaar; public static final gnu.expr.GenericProc cadadr; public static final gnu.expr.GenericProc caddar; public static final gnu.expr.GenericProc cadddr; public static final gnu.expr.GenericProc cdaaar; public static final gnu.expr.GenericProc cdaadr; public static final gnu.expr.GenericProc cdadar; public static final gnu.expr.GenericProc cdaddr; public static final gnu.expr.GenericProc cddaar; public static final gnu.expr.GenericProc cddadr; public static final gnu.expr.GenericProc cdddar; public static final gnu.expr.GenericProc cddddr; public static final gnu.expr.ModuleMethod length; public static final gnu.expr.ModuleMethod reverse; public static final gnu.expr.ModuleMethod list$Mntail; public static final gnu.expr.GenericProc list$Mnref; public static final gnu.expr.ModuleMethod list$Mnset$Ex; public static final gnu.expr.ModuleMethod list$Qu; public static final gnu.expr.ModuleMethod make$Mnlist; public static final gnu.expr.ModuleMethod reverse$Ex; public static final gnu.expr.ModuleMethod memq; public static final gnu.expr.ModuleMethod memv; public static final gnu.expr.ModuleMethod member; public static final gnu.expr.ModuleMethod assq; public static final gnu.expr.ModuleMethod assv; public static final gnu.expr.ModuleMethod assoc; public static final gnu.expr.ModuleMethod list$Mncopy; public static final gnu.kawa.reflect.StaticFieldLocation $Prvt$define$Mnprocedure; static final gnu.expr.Keyword Lit0; static final gnu.expr.ModuleMethod lambda$Fn1; static final gnu.expr.ModuleMethod lambda$Fn2; static final gnu.expr.ModuleMethod lambda$Fn3; static final gnu.expr.ModuleMethod lambda$Fn4; static final gnu.expr.ModuleMethod lambda$Fn5; static final gnu.expr.ModuleMethod lambda$Fn6; static final gnu.expr.ModuleMethod lambda$Fn7; static final gnu.expr.ModuleMethod lambda$Fn8; static final gnu.expr.ModuleMethod lambda$Fn9; static final gnu.expr.ModuleMethod lambda$Fn10; static final gnu.expr.ModuleMethod lambda$Fn11; static final gnu.expr.ModuleMethod lambda$Fn12; static final gnu.expr.ModuleMethod lambda$Fn13; static final gnu.expr.ModuleMethod lambda$Fn14; static final gnu.expr.ModuleMethod lambda$Fn15; static final gnu.expr.ModuleMethod lambda$Fn16; static final gnu.expr.ModuleMethod lambda$Fn17; static final gnu.expr.ModuleMethod lambda$Fn18; static final gnu.expr.ModuleMethod lambda$Fn19; static final gnu.expr.ModuleMethod lambda$Fn20; static final gnu.expr.ModuleMethod lambda$Fn21; static final gnu.expr.ModuleMethod lambda$Fn22; static final gnu.expr.ModuleMethod lambda$Fn23; static final gnu.expr.ModuleMethod lambda$Fn24; static final gnu.expr.ModuleMethod lambda$Fn25; static final gnu.expr.ModuleMethod lambda$Fn26; static final gnu.expr.ModuleMethod lambda$Fn27; static final gnu.expr.ModuleMethod lambda$Fn28; public static lists $instance; static final gnu.mapping.SimpleSymbol Lit1; static final gnu.mapping.SimpleSymbol Lit2; static final gnu.mapping.SimpleSymbol Lit3; static final gnu.mapping.SimpleSymbol Lit4; static final gnu.mapping.SimpleSymbol Lit5; static final gnu.mapping.SimpleSymbol Lit6; static final gnu.mapping.SimpleSymbol Lit7; static final gnu.mapping.SimpleSymbol Lit8; static final gnu.mapping.SimpleSymbol Lit9; static final gnu.mapping.SimpleSymbol Lit10; static final gnu.mapping.SimpleSymbol Lit11; static final gnu.mapping.SimpleSymbol Lit12; static final gnu.mapping.SimpleSymbol Lit13; static final gnu.mapping.SimpleSymbol Lit14; static final gnu.mapping.SimpleSymbol Lit15; static final gnu.mapping.SimpleSymbol Lit16; static final gnu.mapping.SimpleSymbol Lit17; static final gnu.mapping.SimpleSymbol Lit18; static final gnu.mapping.SimpleSymbol Lit19 = gnu.mapping.Symbol.valueOf("list-copy");
  
  public static boolean isPair(Object x)
  {
    return gnu.mapping.Promise.force(x) instanceof Pair;
  }
  





































































































  public int match2(gnu.expr.ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, gnu.mapping.CallContext paramCallContext)
  {
    switch (selector) {case 68:  value1 = paramObject1;value2 = gnu.mapping.Promise.force(paramObject2);proc = paramModuleMethod;pc = 2;return 0;
    




















































    case 79: 
      value1 = paramObject1;value2 = paramObject2;proc = paramModuleMethod;pc = 2;return 0;
    case 78: 
      value1 = paramObject1;value2 = paramObject2;proc = paramModuleMethod;pc = 2;return 0;
    case 77: 
      value1 = paramObject1;value2 = paramObject2;proc = paramModuleMethod;pc = 2;return 0;
    case 75: 
      value1 = paramObject1;value2 = paramObject2;proc = paramModuleMethod;pc = 2;return 0;
    case 74: 
      value1 = paramObject1;value2 = paramObject2;proc = paramModuleMethod;pc = 2;return 0;
    case 73: 
      value1 = paramObject1;value2 = paramObject2;proc = paramModuleMethod;pc = 2;return 0;
    case 70: 
      value1 = gnu.mapping.Promise.force(paramObject1);value2 = paramObject2;proc = paramModuleMethod;pc = 2;return 0;
    case 66: 
      value1 = paramObject1;value2 = gnu.mapping.Promise.force(paramObject2);proc = paramModuleMethod;pc = 2;return 0; case 63:  value1 = paramObject1;value2 = paramObject2;proc = paramModuleMethod;pc = 2;return 0; case 61:  value1 = paramObject1;value2 = paramObject2;proc = paramModuleMethod;pc = 2;return 0; case 59:  value1 = paramObject1;value2 = paramObject2;proc = paramModuleMethod;pc = 2;return 0; case 57:  value1 = paramObject1;value2 = paramObject2;proc = paramModuleMethod;pc = 2;return 0; case 55:  value1 = paramObject1;value2 = paramObject2;proc = paramModuleMethod;pc = 2;return 0; case 53:  value1 = paramObject1;value2 = paramObject2;proc = paramModuleMethod;pc = 2;return 0; case 51:  value1 = paramObject1;value2 = paramObject2;proc = paramModuleMethod;pc = 2;return 0; case 49:  value1 = paramObject1;value2 = paramObject2;proc = paramModuleMethod;pc = 2;return 0; case 47:  value1 = paramObject1;value2 = paramObject2;proc = paramModuleMethod;pc = 2;return 0; case 45:  value1 = paramObject1;value2 = paramObject2;proc = paramModuleMethod;pc = 2;return 0; case 43:  value1 = paramObject1;value2 = paramObject2;proc = paramModuleMethod;pc = 2;return 0; case 41:  value1 = paramObject1;value2 = paramObject2;proc = paramModuleMethod;pc = 2;return 0; case 39:  value1 = paramObject1;value2 = paramObject2;proc = paramModuleMethod;pc = 2;return 0; case 37:  value1 = paramObject1;value2 = paramObject2;proc = paramModuleMethod;pc = 2;return 0; case 35:  value1 = paramObject1;value2 = paramObject2;proc = paramModuleMethod;pc = 2;return 0; case 33:  value1 = paramObject1;value2 = paramObject2;proc = paramModuleMethod;pc = 2;return 0; case 31:  value1 = paramObject1;value2 = paramObject2;proc = paramModuleMethod;pc = 2;return 0; case 29:  value1 = paramObject1;value2 = paramObject2;proc = paramModuleMethod;pc = 2;return 0; case 27:  value1 = paramObject1;value2 = paramObject2;proc = paramModuleMethod;pc = 2;return 0; case 25:  value1 = paramObject1;value2 = paramObject2;proc = paramModuleMethod;pc = 2;return 0; case 23:  value1 = paramObject1;value2 = paramObject2;proc = paramModuleMethod;pc = 2;return 0; case 21:  value1 = paramObject1;value2 = paramObject2;proc = paramModuleMethod;pc = 2;return 0; case 19:  value1 = paramObject1;value2 = paramObject2;proc = paramModuleMethod;pc = 2;return 0; case 17:  value1 = paramObject1;value2 = paramObject2;proc = paramModuleMethod;pc = 2;return 0; case 15:  value1 = paramObject1;value2 = paramObject2;proc = paramModuleMethod;pc = 2;return 0; case 13:  value1 = paramObject1;value2 = paramObject2;proc = paramModuleMethod;pc = 2;return 0; case 11:  value1 = paramObject1;value2 = paramObject2;proc = paramModuleMethod;pc = 2;return 0; case 9:  value1 = paramObject1;value2 = paramObject2;proc = paramModuleMethod;pc = 2;return 0;
    case 5: 
      Object tmp1311_1308 = gnu.mapping.Promise.force(paramObject1, Pair.class);
      
























      if (!(tmp1311_1308 instanceof Pair)) return -786431; value1 = tmp1311_1308;value2 = paramObject2;proc = paramModuleMethod;pc = 2;return 0;
    case 4: 
      Object tmp1353_1350 = gnu.mapping.Promise.force(paramObject1, Pair.class);
      





















      if (!(tmp1353_1350 instanceof Pair)) return -786431; value1 = tmp1353_1350;value2 = paramObject2;proc = paramModuleMethod;pc = 2;return 0;
    case 2: 
      value1 = paramObject1;value2 = paramObject2;proc = paramModuleMethod;pc = 2;return 0; } return super.match2(paramModuleMethod, paramObject1, paramObject2, paramCallContext); }
  public static Pair cons(Object car, Object cdr) { return new Pair(car, cdr); }
  
  public static boolean isNull(Object x) {
    return gnu.mapping.Promise.force(x) == gnu.lists.LList.Empty;
  }
  
  public static void setCar$Ex(Pair p, Object x) { p.setCar(x); }
  
  public static void setCdr$Ex(Pair p, Object x) {
    p.setCdr(x);
  }
  
  public static Object car(Pair x)
  {
    return x.getCar();
  }
  
  public Object apply1(gnu.expr.ModuleMethod paramModuleMethod, Object paramObject)
  {
    switch (selector) {case 1:  return isPair(paramObject) ? Boolean.TRUE : Boolean.FALSE;
    



    case 3: 
      return isNull(paramObject) ? Boolean.TRUE : Boolean.FALSE;
    }
    
    





































































    try
    {
      return Integer.valueOf(length(gnu.lists.Sequences.coerceToSequence(gnu.mapping.Promise.force(paramObject, java.util.List.class)))); } catch (ClassCastException localClassCastException1) { throw new gnu.mapping.WrongType(localClassCastException1, "length", 1, paramObject);
    }
    try
    {
      return reverse((gnu.lists.LList)gnu.mapping.Promise.force(paramObject, gnu.lists.LList.class)); } catch (ClassCastException localClassCastException2) { throw new gnu.mapping.WrongType(localClassCastException2, "reverse", 1, paramObject);
    }
    






















    return isList(paramObject) ? Boolean.TRUE : Boolean.FALSE;
    try
    {
      return makeList(((Number)gnu.mapping.Promise.force(paramObject)).intValue()); } catch (ClassCastException localClassCastException3) { throw new gnu.mapping.WrongType(localClassCastException3, "make-list", 1, paramObject);
    }
    



    try
    {
      return reverse$Ex((gnu.lists.LList)gnu.mapping.Promise.force(paramObject, gnu.lists.LList.class)); } catch (ClassCastException localClassCastException4) { throw new gnu.mapping.WrongType(localClassCastException4, "reverse!", 1, paramObject);
    }
    














































    return listCopy(paramObject);
    try
    {
      return car((Pair)gnu.mapping.Promise.force(paramObject, Pair.class)); } catch (ClassCastException localClassCastException5) { throw new gnu.mapping.WrongType(
      






































































































        localClassCastException5, "car", 1, paramObject);
    }
    try
    {
      return cdr((Pair)gnu.mapping.Promise.force(paramObject, Pair.class)); } catch (ClassCastException localClassCastException6) { throw new gnu.mapping.WrongType(localClassCastException6, "cdr", 1, paramObject); } return caar(paramObject);return cadr(paramObject);return cdar(paramObject);return cddr(paramObject);return caaar(paramObject);return caadr(paramObject);return cadar(paramObject);return caddr(paramObject);return cdaar(paramObject);return cdadr(paramObject);return cddar(paramObject);return cdddr(paramObject);return caaaar(paramObject);return caaadr(paramObject);return caadar(paramObject);return caaddr(paramObject);return cadaar(paramObject);return cadadr(paramObject);return caddar(paramObject);return cadddr(paramObject);return cdaaar(paramObject);return cdaadr(paramObject);return cdadar(paramObject);return cdaddr(paramObject);return cddaar(paramObject);return cddadr(paramObject);return cdddar(paramObject);return cddddr(paramObject);return super.apply1(paramModuleMethod, paramObject); }
  public static Object cdr(Pair x) { return x.getCdr(); }
  



























  static void lambda1(Object arg, Object value) { ((Pair)gnu.mapping.Promise.force(((Pair)gnu.mapping.Promise.force(arg, Pair.class)).getCar(), Pair.class)).setCar(value); } public static Object caar(Object arg) { return ((Pair)gnu.mapping.Promise.force(((Pair)gnu.mapping.Promise.force(arg, Pair.class)).getCar(), Pair.class)).getCar(); }
  static void lambda2(Object arg, Object value) { ((Pair)gnu.mapping.Promise.force(((Pair)gnu.mapping.Promise.force(arg, Pair.class)).getCdr(), Pair.class)).setCar(value); } public static Object cadr(Object arg) { return ((Pair)gnu.mapping.Promise.force(((Pair)gnu.mapping.Promise.force(arg, Pair.class)).getCdr(), Pair.class)).getCar(); }
  static void lambda3(Object arg, Object value) { ((Pair)gnu.mapping.Promise.force(((Pair)gnu.mapping.Promise.force(arg, Pair.class)).getCar(), Pair.class)).setCdr(value); } public static Object cdar(Object arg) { return ((Pair)gnu.mapping.Promise.force(((Pair)gnu.mapping.Promise.force(arg, Pair.class)).getCar(), Pair.class)).getCdr(); }
  static void lambda4(Object arg, Object value) { ((Pair)gnu.mapping.Promise.force(((Pair)gnu.mapping.Promise.force(arg, Pair.class)).getCdr(), Pair.class)).setCdr(value); } public static Object cddr(Object arg) { return ((Pair)gnu.mapping.Promise.force(((Pair)gnu.mapping.Promise.force(arg, Pair.class)).getCdr(), Pair.class)).getCdr(); }
  static void lambda5(Object arg, Object value) { ((Pair)gnu.mapping.Promise.force(((Pair)gnu.mapping.Promise.force(((Pair)gnu.mapping.Promise.force(arg, Pair.class)).getCar(), Pair.class)).getCar(), Pair.class)).setCar(value); } public static Object caaar(Object arg) { return ((Pair)gnu.mapping.Promise.force(((Pair)gnu.mapping.Promise.force(((Pair)gnu.mapping.Promise.force(arg, Pair.class)).getCar(), Pair.class)).getCar(), Pair.class)).getCar(); }
  static void lambda6(Object arg, Object value) { ((Pair)gnu.mapping.Promise.force(((Pair)gnu.mapping.Promise.force(((Pair)gnu.mapping.Promise.force(arg, Pair.class)).getCdr(), Pair.class)).getCar(), Pair.class)).setCar(value); } public static Object caadr(Object arg) { return ((Pair)gnu.mapping.Promise.force(((Pair)gnu.mapping.Promise.force(((Pair)gnu.mapping.Promise.force(arg, Pair.class)).getCdr(), Pair.class)).getCar(), Pair.class)).getCar(); }
  static void lambda7(Object arg, Object value) { ((Pair)gnu.mapping.Promise.force(((Pair)gnu.mapping.Promise.force(((Pair)gnu.mapping.Promise.force(arg, Pair.class)).getCar(), Pair.class)).getCdr(), Pair.class)).setCar(value); } public static Object cadar(Object arg) { return ((Pair)gnu.mapping.Promise.force(((Pair)gnu.mapping.Promise.force(((Pair)gnu.mapping.Promise.force(arg, Pair.class)).getCar(), Pair.class)).getCdr(), Pair.class)).getCar(); }
  static void lambda8(Object arg, Object value) { ((Pair)gnu.mapping.Promise.force(((Pair)gnu.mapping.Promise.force(((Pair)gnu.mapping.Promise.force(arg, Pair.class)).getCdr(), Pair.class)).getCdr(), Pair.class)).setCar(value); } public static Object caddr(Object arg) { return ((Pair)gnu.mapping.Promise.force(((Pair)gnu.mapping.Promise.force(((Pair)gnu.mapping.Promise.force(arg, Pair.class)).getCdr(), Pair.class)).getCdr(), Pair.class)).getCar(); }
  static void lambda9(Object arg, Object value) { ((Pair)gnu.mapping.Promise.force(((Pair)gnu.mapping.Promise.force(((Pair)gnu.mapping.Promise.force(arg, Pair.class)).getCar(), Pair.class)).getCar(), Pair.class)).setCdr(value); } public static Object cdaar(Object arg) { return ((Pair)gnu.mapping.Promise.force(((Pair)gnu.mapping.Promise.force(((Pair)gnu.mapping.Promise.force(arg, Pair.class)).getCar(), Pair.class)).getCar(), Pair.class)).getCdr(); }
  static void lambda10(Object arg, Object value) { ((Pair)gnu.mapping.Promise.force(((Pair)gnu.mapping.Promise.force(((Pair)gnu.mapping.Promise.force(arg, Pair.class)).getCdr(), Pair.class)).getCar(), Pair.class)).setCdr(value); } public static Object cdadr(Object arg) { return ((Pair)gnu.mapping.Promise.force(((Pair)gnu.mapping.Promise.force(((Pair)gnu.mapping.Promise.force(arg, Pair.class)).getCdr(), Pair.class)).getCar(), Pair.class)).getCdr(); }
  static void lambda11(Object arg, Object value) { ((Pair)gnu.mapping.Promise.force(((Pair)gnu.mapping.Promise.force(((Pair)gnu.mapping.Promise.force(arg, Pair.class)).getCar(), Pair.class)).getCdr(), Pair.class)).setCdr(value); } public static Object cddar(Object arg) { return ((Pair)gnu.mapping.Promise.force(((Pair)gnu.mapping.Promise.force(((Pair)gnu.mapping.Promise.force(arg, Pair.class)).getCar(), Pair.class)).getCdr(), Pair.class)).getCdr(); }
  static void lambda12(Object arg, Object value) { ((Pair)gnu.mapping.Promise.force(((Pair)gnu.mapping.Promise.force(((Pair)gnu.mapping.Promise.force(arg, Pair.class)).getCdr(), Pair.class)).getCdr(), Pair.class)).setCdr(value); } public static Object cdddr(Object arg) { return ((Pair)gnu.mapping.Promise.force(((Pair)gnu.mapping.Promise.force(((Pair)gnu.mapping.Promise.force(arg, Pair.class)).getCdr(), Pair.class)).getCdr(), Pair.class)).getCdr(); }
  static void lambda13(Object arg, Object value) { ((Pair)gnu.mapping.Promise.force(((Pair)gnu.mapping.Promise.force(((Pair)gnu.mapping.Promise.force(((Pair)gnu.mapping.Promise.force(arg, Pair.class)).getCar(), Pair.class)).getCar(), Pair.class)).getCar(), Pair.class)).setCar(value); } public static Object caaaar(Object arg) { return ((Pair)gnu.mapping.Promise.force(((Pair)gnu.mapping.Promise.force(((Pair)gnu.mapping.Promise.force(((Pair)gnu.mapping.Promise.force(arg, Pair.class)).getCar(), Pair.class)).getCar(), Pair.class)).getCar(), Pair.class)).getCar(); }
  static void lambda14(Object arg, Object value) { ((Pair)gnu.mapping.Promise.force(((Pair)gnu.mapping.Promise.force(((Pair)gnu.mapping.Promise.force(((Pair)gnu.mapping.Promise.force(arg, Pair.class)).getCdr(), Pair.class)).getCar(), Pair.class)).getCar(), Pair.class)).setCar(value); } public static Object caaadr(Object arg) { return ((Pair)gnu.mapping.Promise.force(((Pair)gnu.mapping.Promise.force(((Pair)gnu.mapping.Promise.force(((Pair)gnu.mapping.Promise.force(arg, Pair.class)).getCdr(), Pair.class)).getCar(), Pair.class)).getCar(), Pair.class)).getCar(); }
  static void lambda15(Object arg, Object value) { ((Pair)gnu.mapping.Promise.force(((Pair)gnu.mapping.Promise.force(((Pair)gnu.mapping.Promise.force(((Pair)gnu.mapping.Promise.force(arg, Pair.class)).getCar(), Pair.class)).getCdr(), Pair.class)).getCar(), Pair.class)).setCar(value); } public static Object caadar(Object arg) { return ((Pair)gnu.mapping.Promise.force(((Pair)gnu.mapping.Promise.force(((Pair)gnu.mapping.Promise.force(((Pair)gnu.mapping.Promise.force(arg, Pair.class)).getCar(), Pair.class)).getCdr(), Pair.class)).getCar(), Pair.class)).getCar(); }
  static void lambda16(Object arg, Object value) { ((Pair)gnu.mapping.Promise.force(((Pair)gnu.mapping.Promise.force(((Pair)gnu.mapping.Promise.force(((Pair)gnu.mapping.Promise.force(arg, Pair.class)).getCdr(), Pair.class)).getCdr(), Pair.class)).getCar(), Pair.class)).setCar(value); } public static Object caaddr(Object arg) { return ((Pair)gnu.mapping.Promise.force(((Pair)gnu.mapping.Promise.force(((Pair)gnu.mapping.Promise.force(((Pair)gnu.mapping.Promise.force(arg, Pair.class)).getCdr(), Pair.class)).getCdr(), Pair.class)).getCar(), Pair.class)).getCar(); }
  static void lambda17(Object arg, Object value) { ((Pair)gnu.mapping.Promise.force(((Pair)gnu.mapping.Promise.force(((Pair)gnu.mapping.Promise.force(((Pair)gnu.mapping.Promise.force(arg, Pair.class)).getCar(), Pair.class)).getCar(), Pair.class)).getCdr(), Pair.class)).setCar(value); } public static Object cadaar(Object arg) { return ((Pair)gnu.mapping.Promise.force(((Pair)gnu.mapping.Promise.force(((Pair)gnu.mapping.Promise.force(((Pair)gnu.mapping.Promise.force(arg, Pair.class)).getCar(), Pair.class)).getCar(), Pair.class)).getCdr(), Pair.class)).getCar(); }
  static void lambda18(Object arg, Object value) { ((Pair)gnu.mapping.Promise.force(((Pair)gnu.mapping.Promise.force(((Pair)gnu.mapping.Promise.force(((Pair)gnu.mapping.Promise.force(arg, Pair.class)).getCdr(), Pair.class)).getCar(), Pair.class)).getCdr(), Pair.class)).setCar(value); } public static Object cadadr(Object arg) { return ((Pair)gnu.mapping.Promise.force(((Pair)gnu.mapping.Promise.force(((Pair)gnu.mapping.Promise.force(((Pair)gnu.mapping.Promise.force(arg, Pair.class)).getCdr(), Pair.class)).getCar(), Pair.class)).getCdr(), Pair.class)).getCar(); }
  static void lambda19(Object arg, Object value) { ((Pair)gnu.mapping.Promise.force(((Pair)gnu.mapping.Promise.force(((Pair)gnu.mapping.Promise.force(((Pair)gnu.mapping.Promise.force(arg, Pair.class)).getCar(), Pair.class)).getCdr(), Pair.class)).getCdr(), Pair.class)).setCar(value); } public static Object caddar(Object arg) { return ((Pair)gnu.mapping.Promise.force(((Pair)gnu.mapping.Promise.force(((Pair)gnu.mapping.Promise.force(((Pair)gnu.mapping.Promise.force(arg, Pair.class)).getCar(), Pair.class)).getCdr(), Pair.class)).getCdr(), Pair.class)).getCar(); }
  static void lambda20(Object arg, Object value) { ((Pair)gnu.mapping.Promise.force(((Pair)gnu.mapping.Promise.force(((Pair)gnu.mapping.Promise.force(((Pair)gnu.mapping.Promise.force(arg, Pair.class)).getCdr(), Pair.class)).getCdr(), Pair.class)).getCdr(), Pair.class)).setCar(value); } public static Object cadddr(Object arg) { return ((Pair)gnu.mapping.Promise.force(((Pair)gnu.mapping.Promise.force(((Pair)gnu.mapping.Promise.force(((Pair)gnu.mapping.Promise.force(arg, Pair.class)).getCdr(), Pair.class)).getCdr(), Pair.class)).getCdr(), Pair.class)).getCar(); }
  static void lambda21(Object arg, Object value) { ((Pair)gnu.mapping.Promise.force(((Pair)gnu.mapping.Promise.force(((Pair)gnu.mapping.Promise.force(((Pair)gnu.mapping.Promise.force(arg, Pair.class)).getCar(), Pair.class)).getCar(), Pair.class)).getCar(), Pair.class)).setCdr(value); } public static Object cdaaar(Object arg) { return ((Pair)gnu.mapping.Promise.force(((Pair)gnu.mapping.Promise.force(((Pair)gnu.mapping.Promise.force(((Pair)gnu.mapping.Promise.force(arg, Pair.class)).getCar(), Pair.class)).getCar(), Pair.class)).getCar(), Pair.class)).getCdr(); }
  static void lambda22(Object arg, Object value) { ((Pair)gnu.mapping.Promise.force(((Pair)gnu.mapping.Promise.force(((Pair)gnu.mapping.Promise.force(((Pair)gnu.mapping.Promise.force(arg, Pair.class)).getCdr(), Pair.class)).getCar(), Pair.class)).getCar(), Pair.class)).setCdr(value); } public static Object cdaadr(Object arg) { return ((Pair)gnu.mapping.Promise.force(((Pair)gnu.mapping.Promise.force(((Pair)gnu.mapping.Promise.force(((Pair)gnu.mapping.Promise.force(arg, Pair.class)).getCdr(), Pair.class)).getCar(), Pair.class)).getCar(), Pair.class)).getCdr(); }
  static void lambda23(Object arg, Object value) { ((Pair)gnu.mapping.Promise.force(((Pair)gnu.mapping.Promise.force(((Pair)gnu.mapping.Promise.force(((Pair)gnu.mapping.Promise.force(arg, Pair.class)).getCar(), Pair.class)).getCdr(), Pair.class)).getCar(), Pair.class)).setCdr(value); } public static Object cdadar(Object arg) { return ((Pair)gnu.mapping.Promise.force(((Pair)gnu.mapping.Promise.force(((Pair)gnu.mapping.Promise.force(((Pair)gnu.mapping.Promise.force(arg, Pair.class)).getCar(), Pair.class)).getCdr(), Pair.class)).getCar(), Pair.class)).getCdr(); }
  static void lambda24(Object arg, Object value) { ((Pair)gnu.mapping.Promise.force(((Pair)gnu.mapping.Promise.force(((Pair)gnu.mapping.Promise.force(((Pair)gnu.mapping.Promise.force(arg, Pair.class)).getCdr(), Pair.class)).getCdr(), Pair.class)).getCar(), Pair.class)).setCdr(value); } public static Object cdaddr(Object arg) { return ((Pair)gnu.mapping.Promise.force(((Pair)gnu.mapping.Promise.force(((Pair)gnu.mapping.Promise.force(((Pair)gnu.mapping.Promise.force(arg, Pair.class)).getCdr(), Pair.class)).getCdr(), Pair.class)).getCar(), Pair.class)).getCdr(); }
  static void lambda25(Object arg, Object value) { ((Pair)gnu.mapping.Promise.force(((Pair)gnu.mapping.Promise.force(((Pair)gnu.mapping.Promise.force(((Pair)gnu.mapping.Promise.force(arg, Pair.class)).getCar(), Pair.class)).getCar(), Pair.class)).getCdr(), Pair.class)).setCdr(value); } public static Object cddaar(Object arg) { return ((Pair)gnu.mapping.Promise.force(((Pair)gnu.mapping.Promise.force(((Pair)gnu.mapping.Promise.force(((Pair)gnu.mapping.Promise.force(arg, Pair.class)).getCar(), Pair.class)).getCar(), Pair.class)).getCdr(), Pair.class)).getCdr(); }
  static void lambda26(Object arg, Object value) { ((Pair)gnu.mapping.Promise.force(((Pair)gnu.mapping.Promise.force(((Pair)gnu.mapping.Promise.force(((Pair)gnu.mapping.Promise.force(arg, Pair.class)).getCdr(), Pair.class)).getCar(), Pair.class)).getCdr(), Pair.class)).setCdr(value); } public static Object cddadr(Object arg) { return ((Pair)gnu.mapping.Promise.force(((Pair)gnu.mapping.Promise.force(((Pair)gnu.mapping.Promise.force(((Pair)gnu.mapping.Promise.force(arg, Pair.class)).getCdr(), Pair.class)).getCar(), Pair.class)).getCdr(), Pair.class)).getCdr(); }
  static void lambda27(Object arg, Object value) { ((Pair)gnu.mapping.Promise.force(((Pair)gnu.mapping.Promise.force(((Pair)gnu.mapping.Promise.force(((Pair)gnu.mapping.Promise.force(arg, Pair.class)).getCar(), Pair.class)).getCdr(), Pair.class)).getCdr(), Pair.class)).setCdr(value); } public static Object cdddar(Object arg) { return ((Pair)gnu.mapping.Promise.force(((Pair)gnu.mapping.Promise.force(((Pair)gnu.mapping.Promise.force(((Pair)gnu.mapping.Promise.force(arg, Pair.class)).getCar(), Pair.class)).getCdr(), Pair.class)).getCdr(), Pair.class)).getCdr(); }
  static void lambda28(Object arg, Object value) { ((Pair)gnu.mapping.Promise.force(((Pair)gnu.mapping.Promise.force(((Pair)gnu.mapping.Promise.force(((Pair)gnu.mapping.Promise.force(arg, Pair.class)).getCdr(), Pair.class)).getCdr(), Pair.class)).getCdr(), Pair.class)).setCdr(value); } public static Object cddddr(Object arg) { return ((Pair)gnu.mapping.Promise.force(((Pair)gnu.mapping.Promise.force(((Pair)gnu.mapping.Promise.force(((Pair)gnu.mapping.Promise.force(arg, Pair.class)).getCdr(), Pair.class)).getCdr(), Pair.class)).getCdr(), Pair.class)).getCdr(); }
  

  @kawa.SourceMethodType({"", "sequence"})
  public static int length(java.util.List list) { return list.size(); }
  
  public static gnu.lists.LList reverse(gnu.lists.LList list) {
    for (;;) { gnu.lists.EmptyList localEmptyList = gnu.lists.LList.Empty;Object arg = list;
      try { Object result;
        Pair p = (Pair)(localObject1 = gnu.mapping.Promise.force(arg, Pair.class));
        tmpTernaryOp = (isNull(arg) ? (gnu.lists.LList)gnu.mapping.Promise.force(result, gnu.lists.LList.class) : cons(p.getCar(), result);
      }
      catch (ClassCastException localClassCastException)
      {
        Object localObject1;
        throw new gnu.mapping.WrongType(
          localClassCastException, "p", -2, localObject1); } } return p.getCdr();
  }
  







  public static void listSet$Ex(Object list, int index, Object obj)
  {
    try
    {
      setCar$Ex((Pair)(localObject = gnu.mapping.Promise.force(listTail(list, index), Pair.class)), obj);return; } catch (ClassCastException localClassCastException) { Object localObject; throw new gnu.mapping.WrongType(localClassCastException, "set-car!", 0, localObject);
    }
  }
  
  private static void $runBody$()
  {
    ;
    gnu.lists.Consumer $result = getInstanceconsumer;
    


























    car
      .setProperty(Lit0, set$Mncar$Ex);
    


    cdr
      .setProperty(Lit0, set$Mncdr$Ex);
    





























    caar.setProperty(Lit0, lambda$Fn1);
    cadr.setProperty(Lit0, lambda$Fn2);
    cdar.setProperty(Lit0, lambda$Fn3);
    cddr.setProperty(Lit0, lambda$Fn4);
    caaar.setProperty(Lit0, lambda$Fn5);
    caadr.setProperty(Lit0, lambda$Fn6);
    cadar.setProperty(Lit0, lambda$Fn7);
    caddr.setProperty(Lit0, lambda$Fn8);
    cdaar.setProperty(Lit0, lambda$Fn9);
    cdadr.setProperty(Lit0, lambda$Fn10);
    cddar.setProperty(Lit0, lambda$Fn11);
    cdddr.setProperty(Lit0, lambda$Fn12);
    caaaar.setProperty(Lit0, lambda$Fn13);
    caaadr.setProperty(Lit0, lambda$Fn14);
    caadar.setProperty(Lit0, lambda$Fn15);
    caaddr.setProperty(Lit0, lambda$Fn16);
    cadaar.setProperty(Lit0, lambda$Fn17);
    cadadr.setProperty(Lit0, lambda$Fn18);
    caddar.setProperty(Lit0, lambda$Fn19);
    cadddr.setProperty(Lit0, lambda$Fn20);
    cdaaar.setProperty(Lit0, lambda$Fn21);
    cdaadr.setProperty(Lit0, lambda$Fn22);
    cdadar.setProperty(Lit0, lambda$Fn23);
    cdaddr.setProperty(Lit0, lambda$Fn24);
    cddaar.setProperty(Lit0, lambda$Fn25);
    cddadr.setProperty(Lit0, lambda$Fn26);
    cdddar.setProperty(Lit0, lambda$Fn27);
    cddddr.setProperty(Lit0, lambda$Fn28);
    
























    list$Mnref
      .setProperty(Lit0, list$Mnset$Ex);
  }
  
  static
  {
    Lit18 = gnu.mapping.Symbol.valueOf("assoc");Lit17 = gnu.mapping.Symbol.valueOf("assv");Lit16 = gnu.mapping.Symbol.valueOf("assq");Lit15 = gnu.mapping.Symbol.valueOf("member");Lit14 = gnu.mapping.Symbol.valueOf("memv");Lit13 = gnu.mapping.Symbol.valueOf("memq");Lit12 = gnu.mapping.Symbol.valueOf("reverse!");Lit11 = gnu.mapping.Symbol.valueOf("make-list");Lit10 = gnu.mapping.Symbol.valueOf("list?");Lit9 = gnu.mapping.Symbol.valueOf("list-set!");Lit8 = gnu.mapping.Symbol.valueOf("list-tail");Lit7 = gnu.mapping.Symbol.valueOf("reverse");Lit6 = gnu.mapping.Symbol.valueOf("length");Lit5 = gnu.mapping.Symbol.valueOf("set-cdr!");Lit4 = gnu.mapping.Symbol.valueOf("set-car!");Lit3 = gnu.mapping.Symbol.valueOf("null?");Lit2 = gnu.mapping.Symbol.valueOf("cons");Lit1 = gnu.mapping.Symbol.valueOf("pair?");Lit0 = gnu.expr.Keyword.make("setter");$instance = new lists();$Prvt$define$Mnprocedure = gnu.kawa.reflect.StaticFieldLocation.make("kawa.lib.std_syntax", "define$Mnprocedure");lists localLists1 = $instance;pair$Qu = new gnu.expr.ModuleMethod(localLists1, 1, Lit1, 4097);cons = new gnu.expr.ModuleMethod(localLists1, 2, Lit2, 8194);null$Qu = new gnu.expr.ModuleMethod(localLists1, 3, Lit3, 4097);set$Mncar$Ex = new gnu.expr.ModuleMethod(localLists1, 4, Lit4, 8194);set$Mncdr$Ex = new gnu.expr.ModuleMethod(localLists1, 5, Lit5, 8194); void 
    
















      tmp306_303 = new gnu.expr.GenericProc("car");
    
    lists $instance = $instance; void tmp327_324 = new gnu.expr.ModuleMethod($instance, 6, "car", 4097);tmp327_324.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/lists.scm:31");tmp306_303.add(tmp327_324);car = tmp306_303; void 
    

      tmp353_350 = new gnu.expr.GenericProc("cdr");
    
    lists $instance = $instance; void tmp374_371 = new gnu.expr.ModuleMethod($instance, 7, "cdr", 4097);tmp374_371.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/lists.scm:36");tmp353_350.add(tmp374_371);cdr = tmp353_350; void tmp400_397 = new gnu.expr.GenericProc("caar");lists $instance = $instance;tmp400_397.add(new gnu.expr.ModuleMethod($instance, 8, "caar", 4097));caar = tmp400_397;lambda$Fn1 = new gnu.expr.ModuleMethod(localLists1, 9, null, 8194); void tmp454_451 = new gnu.expr.GenericProc("cadr");lists $instance = $instance;tmp454_451.add(new gnu.expr.ModuleMethod($instance, 10, "cadr", 4097));cadr = tmp454_451;lambda$Fn2 = new gnu.expr.ModuleMethod(localLists1, 11, null, 8194); void tmp508_505 = new gnu.expr.GenericProc("cdar");lists $instance = $instance;tmp508_505.add(new gnu.expr.ModuleMethod($instance, 12, "cdar", 4097));cdar = tmp508_505;lambda$Fn3 = new gnu.expr.ModuleMethod(localLists1, 13, null, 8194); void tmp562_559 = new gnu.expr.GenericProc("cddr");lists $instance = $instance;tmp562_559.add(new gnu.expr.ModuleMethod($instance, 14, "cddr", 4097));cddr = tmp562_559;lambda$Fn4 = new gnu.expr.ModuleMethod(localLists1, 15, null, 8194); void tmp616_613 = new gnu.expr.GenericProc("caaar");lists $instance = $instance;tmp616_613.add(new gnu.expr.ModuleMethod($instance, 16, "caaar", 4097));caaar = tmp616_613;lambda$Fn5 = new gnu.expr.ModuleMethod(localLists1, 17, null, 8194); void tmp670_667 = new gnu.expr.GenericProc("caadr");lists $instance = $instance;tmp670_667.add(new gnu.expr.ModuleMethod($instance, 18, "caadr", 4097));caadr = tmp670_667;lambda$Fn6 = new gnu.expr.ModuleMethod(localLists1, 19, null, 8194); void tmp724_721 = new gnu.expr.GenericProc("cadar");lists $instance = $instance;tmp724_721.add(new gnu.expr.ModuleMethod($instance, 20, "cadar", 4097));cadar = tmp724_721;lambda$Fn7 = new gnu.expr.ModuleMethod(localLists1, 21, null, 8194); void tmp778_775 = new gnu.expr.GenericProc("caddr");lists $instance = $instance;tmp778_775.add(new gnu.expr.ModuleMethod($instance, 22, "caddr", 4097));caddr = tmp778_775;lambda$Fn8 = new gnu.expr.ModuleMethod(localLists1, 23, null, 8194); void tmp832_829 = new gnu.expr.GenericProc("cdaar");lists $instance = $instance;tmp832_829.add(new gnu.expr.ModuleMethod($instance, 24, "cdaar", 4097));cdaar = tmp832_829;lambda$Fn9 = new gnu.expr.ModuleMethod(localLists1, 25, null, 8194); void tmp886_883 = new gnu.expr.GenericProc("cdadr");lists $instance = $instance;tmp886_883.add(new gnu.expr.ModuleMethod($instance, 26, "cdadr", 4097));cdadr = tmp886_883;lambda$Fn10 = new gnu.expr.ModuleMethod(localLists1, 27, null, 8194); void tmp940_937 = new gnu.expr.GenericProc("cddar");lists $instance = $instance;tmp940_937.add(new gnu.expr.ModuleMethod($instance, 28, "cddar", 4097));cddar = tmp940_937;lambda$Fn11 = new gnu.expr.ModuleMethod(localLists1, 29, null, 8194); void tmp994_991 = new gnu.expr.GenericProc("cdddr");lists $instance = $instance;tmp994_991.add(new gnu.expr.ModuleMethod($instance, 30, "cdddr", 4097));cdddr = tmp994_991;lambda$Fn12 = new gnu.expr.ModuleMethod(localLists1, 31, null, 8194); void tmp1048_1045 = new gnu.expr.GenericProc("caaaar");lists $instance = $instance;tmp1048_1045.add(new gnu.expr.ModuleMethod($instance, 32, "caaaar", 4097));caaaar = tmp1048_1045;lambda$Fn13 = new gnu.expr.ModuleMethod(localLists1, 33, null, 8194); void tmp1102_1099 = new gnu.expr.GenericProc("caaadr");lists $instance = $instance;tmp1102_1099.add(new gnu.expr.ModuleMethod($instance, 34, "caaadr", 4097));caaadr = tmp1102_1099;lambda$Fn14 = new gnu.expr.ModuleMethod(localLists1, 35, null, 8194); void tmp1156_1153 = new gnu.expr.GenericProc("caadar");lists $instance = $instance;tmp1156_1153.add(new gnu.expr.ModuleMethod($instance, 36, "caadar", 4097));caadar = tmp1156_1153;lambda$Fn15 = new gnu.expr.ModuleMethod(localLists1, 37, null, 8194); void tmp1210_1207 = new gnu.expr.GenericProc("caaddr");lists $instance = $instance;tmp1210_1207.add(new gnu.expr.ModuleMethod($instance, 38, "caaddr", 4097));caaddr = tmp1210_1207;lambda$Fn16 = new gnu.expr.ModuleMethod(localLists1, 39, null, 8194); void tmp1264_1261 = new gnu.expr.GenericProc("cadaar");lists $instance = $instance;tmp1264_1261.add(new gnu.expr.ModuleMethod($instance, 40, "cadaar", 4097));cadaar = tmp1264_1261;lambda$Fn17 = new gnu.expr.ModuleMethod(localLists1, 41, null, 8194); void tmp1318_1315 = new gnu.expr.GenericProc("cadadr");lists $instance = $instance;tmp1318_1315.add(new gnu.expr.ModuleMethod($instance, 42, "cadadr", 4097));cadadr = tmp1318_1315;lambda$Fn18 = new gnu.expr.ModuleMethod(localLists1, 43, null, 8194); void tmp1372_1369 = new gnu.expr.GenericProc("caddar");lists $instance = $instance;tmp1372_1369.add(new gnu.expr.ModuleMethod($instance, 44, "caddar", 4097));caddar = tmp1372_1369;lambda$Fn19 = new gnu.expr.ModuleMethod(localLists1, 45, null, 8194); void tmp1426_1423 = new gnu.expr.GenericProc("cadddr");lists $instance = $instance;tmp1426_1423.add(new gnu.expr.ModuleMethod($instance, 46, "cadddr", 4097));cadddr = tmp1426_1423;lambda$Fn20 = new gnu.expr.ModuleMethod(localLists1, 47, null, 8194); void tmp1480_1477 = new gnu.expr.GenericProc("cdaaar");lists $instance = $instance;tmp1480_1477.add(new gnu.expr.ModuleMethod($instance, 48, "cdaaar", 4097));cdaaar = tmp1480_1477;lambda$Fn21 = new gnu.expr.ModuleMethod(localLists1, 49, null, 8194); void tmp1534_1531 = new gnu.expr.GenericProc("cdaadr");lists $instance = $instance;tmp1534_1531.add(new gnu.expr.ModuleMethod($instance, 50, "cdaadr", 4097));cdaadr = tmp1534_1531;lambda$Fn22 = new gnu.expr.ModuleMethod(localLists1, 51, null, 8194); void tmp1588_1585 = new gnu.expr.GenericProc("cdadar");lists $instance = $instance;tmp1588_1585.add(new gnu.expr.ModuleMethod($instance, 52, "cdadar", 4097));cdadar = tmp1588_1585;lambda$Fn23 = new gnu.expr.ModuleMethod(localLists1, 53, null, 8194); void tmp1642_1639 = new gnu.expr.GenericProc("cdaddr");lists $instance = $instance;tmp1642_1639.add(new gnu.expr.ModuleMethod($instance, 54, "cdaddr", 4097));cdaddr = tmp1642_1639;lambda$Fn24 = new gnu.expr.ModuleMethod(localLists1, 55, null, 8194); void tmp1696_1693 = new gnu.expr.GenericProc("cddaar");lists $instance = $instance;tmp1696_1693.add(new gnu.expr.ModuleMethod($instance, 56, "cddaar", 4097));cddaar = tmp1696_1693;lambda$Fn25 = new gnu.expr.ModuleMethod(localLists1, 57, null, 8194); void tmp1750_1747 = new gnu.expr.GenericProc("cddadr");lists $instance = $instance;tmp1750_1747.add(new gnu.expr.ModuleMethod($instance, 58, "cddadr", 4097));cddadr = tmp1750_1747;lambda$Fn26 = new gnu.expr.ModuleMethod(localLists1, 59, null, 8194); void tmp1804_1801 = new gnu.expr.GenericProc("cdddar");lists $instance = $instance;tmp1804_1801.add(new gnu.expr.ModuleMethod($instance, 60, "cdddar", 4097));cdddar = tmp1804_1801;lambda$Fn27 = new gnu.expr.ModuleMethod(localLists1, 61, null, 8194); void tmp1858_1855 = new gnu.expr.GenericProc("cddddr");lists $instance = $instance;tmp1858_1855.add(new gnu.expr.ModuleMethod($instance, 62, "cddddr", 4097));cddddr = tmp1858_1855;lambda$Fn28 = new gnu.expr.ModuleMethod(localLists1, 63, null, 8194); void tmp1918_1915 = new gnu.expr.ModuleMethod(localLists1, 64, Lit6, 4097);tmp1918_1915.setProperty(gnu.mapping.Procedure.validateApplyKey, "kawa.lib.compile_misc:lengthValidateApply");length = tmp1918_1915;reverse = new gnu.expr.ModuleMethod(localLists1, 65, Lit7, 4097);list$Mntail = new gnu.expr.ModuleMethod(localLists1, 66, Lit8, 8194);list$Mnset$Ex = new gnu.expr.ModuleMethod(localLists1, 67, Lit9, 12291); void 
    

















































































      tmp1998_1995 = new gnu.expr.GenericProc("list-ref");
    
    lists $instance = $instance; void tmp2019_2016 = new gnu.expr.ModuleMethod($instance, 68, "list-ref", 8194);tmp2019_2016.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/lists.scm:121");tmp1998_1995.add(tmp2019_2016);list$Mnref = tmp1998_1995;list$Qu = new gnu.expr.ModuleMethod(localLists1, 69, Lit10, 4097);make$Mnlist = new gnu.expr.ModuleMethod(localLists1, 70, Lit11, 8193);reverse$Ex = new gnu.expr.ModuleMethod(localLists1, 72, Lit12, 4097);memq = new gnu.expr.ModuleMethod(localLists1, 73, Lit13, 8194);memv = new gnu.expr.ModuleMethod(localLists1, 74, Lit14, 8194);member = new gnu.expr.ModuleMethod(localLists1, 75, Lit15, 12290);assq = new gnu.expr.ModuleMethod(localLists1, 77, Lit16, 8194);assv = new gnu.expr.ModuleMethod(localLists1, 78, Lit17, 8194);assoc = new gnu.expr.ModuleMethod(localLists1, 79, Lit18, 12290);list$Mncopy = new gnu.expr.ModuleMethod(localLists1, 81, Lit19, 4097);$runBody$();
  }
  
  public Object apply2(gnu.expr.ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
  {
    switch (selector) {case 2:  return cons(paramObject1, paramObject2);
    }
    
    
    try
    {
      setCar$Ex((Pair)gnu.mapping.Promise.force(paramObject1, Pair.class), paramObject2);return gnu.mapping.Values.empty; } catch (ClassCastException localClassCastException1) { throw new gnu.mapping.WrongType(
      
































































































        localClassCastException1, "set-car!", 1, paramObject1);
    }
    try
    {
      setCdr$Ex((Pair)gnu.mapping.Promise.force(paramObject1, Pair.class), paramObject2);return gnu.mapping.Values.empty; } catch (ClassCastException localClassCastException2) { throw new gnu.mapping.WrongType(localClassCastException2, "set-cdr!", 1, paramObject1); } lambda1(paramObject1, paramObject2);return gnu.mapping.Values.empty;lambda2(paramObject1, paramObject2);return gnu.mapping.Values.empty;lambda3(paramObject1, paramObject2);return gnu.mapping.Values.empty;lambda4(paramObject1, paramObject2);return gnu.mapping.Values.empty;lambda5(paramObject1, paramObject2);return gnu.mapping.Values.empty;lambda6(paramObject1, paramObject2);return gnu.mapping.Values.empty;lambda7(paramObject1, paramObject2);return gnu.mapping.Values.empty;lambda8(paramObject1, paramObject2);return gnu.mapping.Values.empty;lambda9(paramObject1, paramObject2);return gnu.mapping.Values.empty;lambda10(paramObject1, paramObject2);return gnu.mapping.Values.empty;lambda11(paramObject1, paramObject2);return gnu.mapping.Values.empty;lambda12(paramObject1, paramObject2);return gnu.mapping.Values.empty;lambda13(paramObject1, paramObject2);return gnu.mapping.Values.empty;lambda14(paramObject1, paramObject2);return gnu.mapping.Values.empty;lambda15(paramObject1, paramObject2);return gnu.mapping.Values.empty;lambda16(paramObject1, paramObject2);return gnu.mapping.Values.empty;lambda17(paramObject1, paramObject2);return gnu.mapping.Values.empty;lambda18(paramObject1, paramObject2);return gnu.mapping.Values.empty;lambda19(paramObject1, paramObject2);return gnu.mapping.Values.empty;lambda20(paramObject1, paramObject2);return gnu.mapping.Values.empty;lambda21(paramObject1, paramObject2);return gnu.mapping.Values.empty;lambda22(paramObject1, paramObject2);return gnu.mapping.Values.empty;lambda23(paramObject1, paramObject2);return gnu.mapping.Values.empty;lambda24(paramObject1, paramObject2);return gnu.mapping.Values.empty;lambda25(paramObject1, paramObject2);return gnu.mapping.Values.empty;lambda26(paramObject1, paramObject2);return gnu.mapping.Values.empty;lambda27(paramObject1, paramObject2);return gnu.mapping.Values.empty;lambda28(paramObject1, paramObject2);return gnu.mapping.Values.empty;
    











































































    try
    {
      return listTail(paramObject1, ((Number)gnu.mapping.Promise.force(paramObject2)).intValue()); } catch (ClassCastException localClassCastException3) { throw new gnu.mapping.WrongType(localClassCastException3, "list-tail", 2, paramObject2);
    }
    

















    try
    {
      return makeList(((Number)gnu.mapping.Promise.force(paramObject1)).intValue(), paramObject2); } catch (ClassCastException localClassCastException4) { throw new gnu.mapping.WrongType(localClassCastException4, "make-list", 1, paramObject1);
    }
    








    return memq(paramObject1, paramObject2);
    




    return memv(paramObject1, paramObject2);
    





    return member(paramObject1, paramObject2);
    




    return assq(paramObject1, paramObject2);
    







    return assv(paramObject1, paramObject2);
    








    return assoc(paramObject1, paramObject2);
    try
    {
      return listRef(paramObject1, ((Number)gnu.mapping.Promise.force(paramObject2)).intValue()); } catch (ClassCastException localClassCastException5) { throw new gnu.mapping.WrongType(
      




        localClassCastException5, "list-ref", 2, paramObject2);
    }
    return super.apply2(paramModuleMethod, paramObject1, paramObject2); }
  public static Object listRef(Object list, int index) { return car.apply1(listTail(list, index)); }
  

  public static boolean isList(Object obj) { return gnu.lists.LList.listLength(obj, false) >= 0; }
  
  public static gnu.lists.LList makeList(int k, Object fill) {
    int i = k;gnu.lists.LList result = gnu.lists.LList.Empty;
    
    int i;
    result = ???--;return result;
  }
  


  public static gnu.lists.LList reverse$Ex(gnu.lists.LList list) { return gnu.lists.LList.reverseInPlace(list); }
  
  public static Object memq(Object x, Object list) {
    Object lst = list;
    Object localObject1 = lst;Object localObject2 = gnu.mapping.Promise.force(localObject1, Pair.class);Pair localPair = (Pair)localObject2;
    
    return x == localPair.getCar() ? lst : Boolean.FALSE;
  }
  
  public static Object memv(Object x, Object list) { Object lst = list;
    Object localObject1 = lst;Object localObject2 = gnu.mapping.Promise.force(localObject1, Pair.class);Pair localPair = (Pair)localObject2;
    
    return gnu.kawa.functions.IsEqv.apply(x, localPair.getCar()) ? lst : Boolean.FALSE;
  }
  
  public static Object member(Object x, Object list, gnu.mapping.Procedure test) {
    Object lst = list;
    Object localObject1 = lst;Object localObject2 = gnu.mapping.Promise.force(localObject1, Pair.class);Pair localPair = (Pair)localObject2;
    
    return gnu.expr.KawaConvert.isTrue(test.apply2(x, localPair.getCar())) ? lst : Boolean.FALSE;
  }
  
  public Object apply3(gnu.expr.ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    switch (selector) {} try { listSet$Ex(paramObject1, ((Number)gnu.mapping.Promise.force(paramObject2)).intValue(), paramObject3);return gnu.mapping.Values.empty; } catch (ClassCastException localClassCastException1) { throw new gnu.mapping.WrongType(
      


























































        localClassCastException1, "list-set!", 2, paramObject2);
    }
    try
    {
      return member(paramObject1, paramObject2, gnu.kawa.lispexpr.LangObjType.coerceToProcedure(gnu.mapping.Promise.force(paramObject3, gnu.mapping.Procedure.class))); } catch (ClassCastException localClassCastException2) { throw new gnu.mapping.WrongType(localClassCastException2, "member", 3, paramObject3);
    }
    




















    try
    {
      return assoc(paramObject1, paramObject2, gnu.kawa.lispexpr.LangObjType.coerceToProcedure(gnu.mapping.Promise.force(paramObject3, gnu.mapping.Procedure.class))); } catch (ClassCastException localClassCastException3) { throw new gnu.mapping.WrongType(localClassCastException3, "assoc", 3, paramObject3); } return super.apply3(paramModuleMethod, paramObject1, paramObject2, paramObject3);
  }
  




  public static Object listCopy(Object obj)
  {
    Object localObject1 = obj;Pair prev = null;
    for (;;) { Object result;
      Object x = obj;
      if (isPair(x)) {}
      try { Object localObject2; Pair pold = (Pair)(localObject2 = gnu.mapping.Promise.force(x, Pair.class));
        pnew = cons(pold.getCar(), null);
        if (prev == null)
          result = pnew; else
          setCdr$Ex(prev, pnew);
        prev = pnew;
        tmpTernaryOp = pold.getCdr();
      }
      catch (ClassCastException localClassCastException)
      {
        Pair pnew;
        throw new gnu.mapping.WrongType(
        







          localClassCastException, "pold", -2, pnew);
      }
    }
    if (prev != null)
      setCdr$Ex(prev, x);
    return result;
  }
  
  /* Error */
  public static Object listTail(Object list, int count)
  {
    // Byte code:
    //   0: aload_0
    //   1: astore_2
    //   2: iinc 1 -1
    //   5: iload_1
    //   6: ifge +7 -> 13
    //   9: aload_2
    //   10: goto +41 -> 51
    //   13: aload_2
    //   14: invokestatic 16	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   17: astore_3
    //   18: aload_3
    //   19: instanceof 18
    //   22: ifeq +18 -> 40
    //   25: aload_3
    //   26: ldc 18
    //   28: invokestatic 67	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   31: checkcast 18	gnu/lists/Pair
    //   34: invokevirtual 80	gnu/lists/Pair:getCdr	()Ljava/lang/Object;
    //   37: goto -36 -> 1
    //   40: new 264	java/lang/IndexOutOfBoundsException
    //   43: dup
    //   44: ldc_w 266
    //   47: invokespecial 269	java/lang/IndexOutOfBoundsException:<init>	(Ljava/lang/String;)V
    //   50: athrow
    //   51: areturn
    // Line number table:
    //   Java source line #105	-> byte code offset #0
    //   Java source line #106	-> byte code offset #0
    //   Java source line #107	-> byte code offset #2
    //   Java source line #108	-> byte code offset #5
    //   Java source line #109	-> byte code offset #9
    //   Java source line #111	-> byte code offset #13
    //   Java source line #112	-> byte code offset #18
    //   Java source line #113	-> byte code offset #25
    //   Java source line #114	-> byte code offset #40
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	51	0	list	Object
    //   0	51	1	count	int
    //   2	49	2	lst	Object
    //   18	33	3	flst	Object
  }
  
  public static gnu.lists.LList makeList(int paramInt)
  {
    return makeList(paramInt, null);
  }
  
  public static Object member(Object paramObject1, Object paramObject2)
  {
    return member(paramObject1, paramObject2, kawa.standard.Scheme.isEqual);
  }
  
  /* Error */
  public static Object assq(Object x, Object list)
  {
    // Byte code:
    //   0: aload_1
    //   1: astore_2
    //   2: aload_2
    //   3: getstatic 28	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
    //   6: if_acmpne +9 -> 15
    //   9: getstatic 303	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   12: goto +44 -> 56
    //   15: getstatic 41	kawa/lib/lists:car	Lgnu/expr/GenericProc;
    //   18: aload_2
    //   19: invokevirtual 333	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   22: ldc 18
    //   24: invokestatic 67	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   27: dup
    //   28: astore 4
    //   30: checkcast 18	gnu/lists/Pair
    //   33: astore_3
    //   34: aload_3
    //   35: invokevirtual 71	gnu/lists/Pair:getCar	()Ljava/lang/Object;
    //   38: aload_0
    //   39: if_acmpne +7 -> 46
    //   42: aload_3
    //   43: goto +13 -> 56
    //   46: getstatic 58	kawa/lib/lists:cdr	Lgnu/expr/GenericProc;
    //   49: aload_2
    //   50: invokevirtual 333	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   53: goto -52 -> 1
    //   56: areturn
    //   57: new 253	gnu/mapping/WrongType
    //   60: dup_x1
    //   61: swap
    //   62: ldc_w 335
    //   65: bipush -2
    //   67: aload 4
    //   69: invokespecial 258	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   72: athrow
    // Line number table:
    //   Java source line #157	-> byte code offset #0
    //   Java source line #158	-> byte code offset #0
    //   Java source line #159	-> byte code offset #2
    //   Java source line #161	-> byte code offset #15
    //   Java source line #162	-> byte code offset #34
    //   Java source line #164	-> byte code offset #46
    //   Java source line #161	-> byte code offset #57
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	56	0	x	Object
    //   0	56	1	list	Object
    //   2	54	2	list	Object
    //   34	22	3	pair	Pair
    // Exception table:
    //   from	to	target	type
    //   30	33	57	java/lang/ClassCastException
  }
  
  /* Error */
  public static Object assv(Object x, Object list)
  {
    // Byte code:
    //   0: aload_1
    //   1: astore_2
    //   2: aload_2
    //   3: getstatic 28	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
    //   6: if_acmpne +9 -> 15
    //   9: getstatic 303	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   12: goto +47 -> 59
    //   15: getstatic 41	kawa/lib/lists:car	Lgnu/expr/GenericProc;
    //   18: aload_2
    //   19: invokevirtual 333	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   22: ldc 18
    //   24: invokestatic 67	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   27: dup
    //   28: astore 4
    //   30: checkcast 18	gnu/lists/Pair
    //   33: astore_3
    //   34: aload_3
    //   35: invokevirtual 71	gnu/lists/Pair:getCar	()Ljava/lang/Object;
    //   38: aload_0
    //   39: invokestatic 309	gnu/kawa/functions/IsEqv:apply	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   42: ifeq +7 -> 49
    //   45: aload_3
    //   46: goto +13 -> 59
    //   49: getstatic 58	kawa/lib/lists:cdr	Lgnu/expr/GenericProc;
    //   52: aload_2
    //   53: invokevirtual 333	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   56: goto -55 -> 1
    //   59: areturn
    //   60: new 253	gnu/mapping/WrongType
    //   63: dup_x1
    //   64: swap
    //   65: ldc_w 335
    //   68: bipush -2
    //   70: aload 4
    //   72: invokespecial 258	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   75: athrow
    // Line number table:
    //   Java source line #166	-> byte code offset #0
    //   Java source line #167	-> byte code offset #0
    //   Java source line #168	-> byte code offset #2
    //   Java source line #170	-> byte code offset #15
    //   Java source line #171	-> byte code offset #34
    //   Java source line #173	-> byte code offset #49
    //   Java source line #170	-> byte code offset #60
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	59	0	x	Object
    //   0	59	1	list	Object
    //   2	57	2	list	Object
    //   34	25	3	pair	Pair
    // Exception table:
    //   from	to	target	type
    //   30	33	60	java/lang/ClassCastException
  }
  
  public static Object assoc(Object paramObject1, Object paramObject2)
  {
    return assoc(paramObject1, paramObject2, kawa.standard.Scheme.isEqual);
  }
  
  /* Error */
  public static Object assoc(Object key, Object list, gnu.mapping.Procedure test)
  {
    // Byte code:
    //   0: aload_1
    //   1: astore_3
    //   2: aload_3
    //   3: getstatic 28	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
    //   6: if_acmpne +9 -> 15
    //   9: getstatic 303	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   12: goto +54 -> 66
    //   15: getstatic 41	kawa/lib/lists:car	Lgnu/expr/GenericProc;
    //   18: aload_3
    //   19: invokevirtual 333	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   22: ldc 18
    //   24: invokestatic 67	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   27: dup
    //   28: astore 5
    //   30: checkcast 18	gnu/lists/Pair
    //   33: astore 4
    //   35: aload_2
    //   36: aload_0
    //   37: aload 4
    //   39: invokevirtual 71	gnu/lists/Pair:getCar	()Ljava/lang/Object;
    //   42: invokevirtual 325	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   45: invokestatic 330	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   48: ifeq +8 -> 56
    //   51: aload 4
    //   53: goto +13 -> 66
    //   56: getstatic 58	kawa/lib/lists:cdr	Lgnu/expr/GenericProc;
    //   59: aload_3
    //   60: invokevirtual 333	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   63: goto -62 -> 1
    //   66: areturn
    //   67: new 253	gnu/mapping/WrongType
    //   70: dup_x1
    //   71: swap
    //   72: ldc_w 335
    //   75: bipush -2
    //   77: aload 5
    //   79: invokespecial 258	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   82: athrow
    // Line number table:
    //   Java source line #176	-> byte code offset #0
    //   Java source line #177	-> byte code offset #0
    //   Java source line #178	-> byte code offset #2
    //   Java source line #180	-> byte code offset #15
    //   Java source line #181	-> byte code offset #35
    //   Java source line #182	-> byte code offset #56
    //   Java source line #180	-> byte code offset #67
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	66	0	key	Object
    //   0	66	1	list	Object
    //   0	66	2	test	gnu.mapping.Procedure
    //   2	64	3	list	Object
    //   35	31	4	pair	Pair
    // Exception table:
    //   from	to	target	type
    //   30	33	67	java/lang/ClassCastException
  }
  
  public lists()
  {
    gnu.expr.ModuleInfo.register(this);
  }
  
  /* Error */
  public int match1(gnu.expr.ModuleMethod arg1, Object arg2, gnu.mapping.CallContext arg3)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 545	gnu/expr/ModuleMethod:selector	I
    //   4: lookupswitch	default:+1054->1058, 1:+1037->1041, 3:+1020->1024, 6:+825->829, 7:+792->796, 8:+775->779, 10:+758->762, 12:+741->745, 14:+724->728, 16:+707->711, 18:+690->694, 20:+673->677, 22:+656->660, 24:+639->643, 26:+622->626, 28:+605->609, 30:+588->592, 32:+571->575, 34:+554->558, 36:+537->541, 38:+520->524, 40:+503->507, 42:+486->490, 44:+469->473, 46:+452->456, 48:+435->439, 50:+418->422, 52:+401->405, 54:+384->388, 56:+367->371, 58:+350->354, 60:+333->337, 62:+316->320, 64:+984->988, 65:+948->952, 69:+931->935, 70:+911->915, 72:+875->879, 81:+858->862
    //   320: aload_3
    //   321: aload_2
    //   322: putfield 549	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   325: aload_3
    //   326: aload_1
    //   327: putfield 553	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   330: aload_3
    //   331: iconst_1
    //   332: putfield 556	gnu/mapping/CallContext:pc	I
    //   335: iconst_0
    //   336: ireturn
    //   337: aload_3
    //   338: aload_2
    //   339: putfield 549	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   342: aload_3
    //   343: aload_1
    //   344: putfield 553	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   347: aload_3
    //   348: iconst_1
    //   349: putfield 556	gnu/mapping/CallContext:pc	I
    //   352: iconst_0
    //   353: ireturn
    //   354: aload_3
    //   355: aload_2
    //   356: putfield 549	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   359: aload_3
    //   360: aload_1
    //   361: putfield 553	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   364: aload_3
    //   365: iconst_1
    //   366: putfield 556	gnu/mapping/CallContext:pc	I
    //   369: iconst_0
    //   370: ireturn
    //   371: aload_3
    //   372: aload_2
    //   373: putfield 549	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   376: aload_3
    //   377: aload_1
    //   378: putfield 553	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   381: aload_3
    //   382: iconst_1
    //   383: putfield 556	gnu/mapping/CallContext:pc	I
    //   386: iconst_0
    //   387: ireturn
    //   388: aload_3
    //   389: aload_2
    //   390: putfield 549	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   393: aload_3
    //   394: aload_1
    //   395: putfield 553	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   398: aload_3
    //   399: iconst_1
    //   400: putfield 556	gnu/mapping/CallContext:pc	I
    //   403: iconst_0
    //   404: ireturn
    //   405: aload_3
    //   406: aload_2
    //   407: putfield 549	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   410: aload_3
    //   411: aload_1
    //   412: putfield 553	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   415: aload_3
    //   416: iconst_1
    //   417: putfield 556	gnu/mapping/CallContext:pc	I
    //   420: iconst_0
    //   421: ireturn
    //   422: aload_3
    //   423: aload_2
    //   424: putfield 549	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   427: aload_3
    //   428: aload_1
    //   429: putfield 553	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   432: aload_3
    //   433: iconst_1
    //   434: putfield 556	gnu/mapping/CallContext:pc	I
    //   437: iconst_0
    //   438: ireturn
    //   439: aload_3
    //   440: aload_2
    //   441: putfield 549	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   444: aload_3
    //   445: aload_1
    //   446: putfield 553	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   449: aload_3
    //   450: iconst_1
    //   451: putfield 556	gnu/mapping/CallContext:pc	I
    //   454: iconst_0
    //   455: ireturn
    //   456: aload_3
    //   457: aload_2
    //   458: putfield 549	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   461: aload_3
    //   462: aload_1
    //   463: putfield 553	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   466: aload_3
    //   467: iconst_1
    //   468: putfield 556	gnu/mapping/CallContext:pc	I
    //   471: iconst_0
    //   472: ireturn
    //   473: aload_3
    //   474: aload_2
    //   475: putfield 549	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   478: aload_3
    //   479: aload_1
    //   480: putfield 553	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   483: aload_3
    //   484: iconst_1
    //   485: putfield 556	gnu/mapping/CallContext:pc	I
    //   488: iconst_0
    //   489: ireturn
    //   490: aload_3
    //   491: aload_2
    //   492: putfield 549	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   495: aload_3
    //   496: aload_1
    //   497: putfield 553	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   500: aload_3
    //   501: iconst_1
    //   502: putfield 556	gnu/mapping/CallContext:pc	I
    //   505: iconst_0
    //   506: ireturn
    //   507: aload_3
    //   508: aload_2
    //   509: putfield 549	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   512: aload_3
    //   513: aload_1
    //   514: putfield 553	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   517: aload_3
    //   518: iconst_1
    //   519: putfield 556	gnu/mapping/CallContext:pc	I
    //   522: iconst_0
    //   523: ireturn
    //   524: aload_3
    //   525: aload_2
    //   526: putfield 549	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   529: aload_3
    //   530: aload_1
    //   531: putfield 553	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   534: aload_3
    //   535: iconst_1
    //   536: putfield 556	gnu/mapping/CallContext:pc	I
    //   539: iconst_0
    //   540: ireturn
    //   541: aload_3
    //   542: aload_2
    //   543: putfield 549	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   546: aload_3
    //   547: aload_1
    //   548: putfield 553	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   551: aload_3
    //   552: iconst_1
    //   553: putfield 556	gnu/mapping/CallContext:pc	I
    //   556: iconst_0
    //   557: ireturn
    //   558: aload_3
    //   559: aload_2
    //   560: putfield 549	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   563: aload_3
    //   564: aload_1
    //   565: putfield 553	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   568: aload_3
    //   569: iconst_1
    //   570: putfield 556	gnu/mapping/CallContext:pc	I
    //   573: iconst_0
    //   574: ireturn
    //   575: aload_3
    //   576: aload_2
    //   577: putfield 549	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   580: aload_3
    //   581: aload_1
    //   582: putfield 553	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   585: aload_3
    //   586: iconst_1
    //   587: putfield 556	gnu/mapping/CallContext:pc	I
    //   590: iconst_0
    //   591: ireturn
    //   592: aload_3
    //   593: aload_2
    //   594: putfield 549	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   597: aload_3
    //   598: aload_1
    //   599: putfield 553	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   602: aload_3
    //   603: iconst_1
    //   604: putfield 556	gnu/mapping/CallContext:pc	I
    //   607: iconst_0
    //   608: ireturn
    //   609: aload_3
    //   610: aload_2
    //   611: putfield 549	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   614: aload_3
    //   615: aload_1
    //   616: putfield 553	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   619: aload_3
    //   620: iconst_1
    //   621: putfield 556	gnu/mapping/CallContext:pc	I
    //   624: iconst_0
    //   625: ireturn
    //   626: aload_3
    //   627: aload_2
    //   628: putfield 549	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   631: aload_3
    //   632: aload_1
    //   633: putfield 553	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   636: aload_3
    //   637: iconst_1
    //   638: putfield 556	gnu/mapping/CallContext:pc	I
    //   641: iconst_0
    //   642: ireturn
    //   643: aload_3
    //   644: aload_2
    //   645: putfield 549	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   648: aload_3
    //   649: aload_1
    //   650: putfield 553	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   653: aload_3
    //   654: iconst_1
    //   655: putfield 556	gnu/mapping/CallContext:pc	I
    //   658: iconst_0
    //   659: ireturn
    //   660: aload_3
    //   661: aload_2
    //   662: putfield 549	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   665: aload_3
    //   666: aload_1
    //   667: putfield 553	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   670: aload_3
    //   671: iconst_1
    //   672: putfield 556	gnu/mapping/CallContext:pc	I
    //   675: iconst_0
    //   676: ireturn
    //   677: aload_3
    //   678: aload_2
    //   679: putfield 549	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   682: aload_3
    //   683: aload_1
    //   684: putfield 553	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   687: aload_3
    //   688: iconst_1
    //   689: putfield 556	gnu/mapping/CallContext:pc	I
    //   692: iconst_0
    //   693: ireturn
    //   694: aload_3
    //   695: aload_2
    //   696: putfield 549	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   699: aload_3
    //   700: aload_1
    //   701: putfield 553	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   704: aload_3
    //   705: iconst_1
    //   706: putfield 556	gnu/mapping/CallContext:pc	I
    //   709: iconst_0
    //   710: ireturn
    //   711: aload_3
    //   712: aload_2
    //   713: putfield 549	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   716: aload_3
    //   717: aload_1
    //   718: putfield 553	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   721: aload_3
    //   722: iconst_1
    //   723: putfield 556	gnu/mapping/CallContext:pc	I
    //   726: iconst_0
    //   727: ireturn
    //   728: aload_3
    //   729: aload_2
    //   730: putfield 549	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   733: aload_3
    //   734: aload_1
    //   735: putfield 553	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   738: aload_3
    //   739: iconst_1
    //   740: putfield 556	gnu/mapping/CallContext:pc	I
    //   743: iconst_0
    //   744: ireturn
    //   745: aload_3
    //   746: aload_2
    //   747: putfield 549	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   750: aload_3
    //   751: aload_1
    //   752: putfield 553	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   755: aload_3
    //   756: iconst_1
    //   757: putfield 556	gnu/mapping/CallContext:pc	I
    //   760: iconst_0
    //   761: ireturn
    //   762: aload_3
    //   763: aload_2
    //   764: putfield 549	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   767: aload_3
    //   768: aload_1
    //   769: putfield 553	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   772: aload_3
    //   773: iconst_1
    //   774: putfield 556	gnu/mapping/CallContext:pc	I
    //   777: iconst_0
    //   778: ireturn
    //   779: aload_3
    //   780: aload_2
    //   781: putfield 549	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   784: aload_3
    //   785: aload_1
    //   786: putfield 553	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   789: aload_3
    //   790: iconst_1
    //   791: putfield 556	gnu/mapping/CallContext:pc	I
    //   794: iconst_0
    //   795: ireturn
    //   796: aload_3
    //   797: aload_2
    //   798: ldc 18
    //   800: invokestatic 67	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   803: dup
    //   804: instanceof 18
    //   807: ifne +7 -> 814
    //   810: ldc_w 557
    //   813: ireturn
    //   814: putfield 549	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   817: aload_3
    //   818: aload_1
    //   819: putfield 553	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   822: aload_3
    //   823: iconst_1
    //   824: putfield 556	gnu/mapping/CallContext:pc	I
    //   827: iconst_0
    //   828: ireturn
    //   829: aload_3
    //   830: aload_2
    //   831: ldc 18
    //   833: invokestatic 67	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   836: dup
    //   837: instanceof 18
    //   840: ifne +7 -> 847
    //   843: ldc_w 557
    //   846: ireturn
    //   847: putfield 549	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   850: aload_3
    //   851: aload_1
    //   852: putfield 553	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   855: aload_3
    //   856: iconst_1
    //   857: putfield 556	gnu/mapping/CallContext:pc	I
    //   860: iconst_0
    //   861: ireturn
    //   862: aload_3
    //   863: aload_2
    //   864: putfield 549	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   867: aload_3
    //   868: aload_1
    //   869: putfield 553	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   872: aload_3
    //   873: iconst_1
    //   874: putfield 556	gnu/mapping/CallContext:pc	I
    //   877: iconst_0
    //   878: ireturn
    //   879: aload_3
    //   880: aload_2
    //   881: ldc 24
    //   883: invokestatic 67	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   886: dup
    //   887: instanceof 24
    //   890: ifeq +6 -> 896
    //   893: goto +7 -> 900
    //   896: ldc_w 557
    //   899: ireturn
    //   900: putfield 549	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   903: aload_3
    //   904: aload_1
    //   905: putfield 553	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   908: aload_3
    //   909: iconst_1
    //   910: putfield 556	gnu/mapping/CallContext:pc	I
    //   913: iconst_0
    //   914: ireturn
    //   915: aload_3
    //   916: aload_2
    //   917: invokestatic 16	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   920: putfield 549	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   923: aload_3
    //   924: aload_1
    //   925: putfield 553	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   928: aload_3
    //   929: iconst_1
    //   930: putfield 556	gnu/mapping/CallContext:pc	I
    //   933: iconst_0
    //   934: ireturn
    //   935: aload_3
    //   936: aload_2
    //   937: putfield 549	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   940: aload_3
    //   941: aload_1
    //   942: putfield 553	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   945: aload_3
    //   946: iconst_1
    //   947: putfield 556	gnu/mapping/CallContext:pc	I
    //   950: iconst_0
    //   951: ireturn
    //   952: aload_3
    //   953: aload_2
    //   954: ldc 24
    //   956: invokestatic 67	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   959: dup
    //   960: instanceof 24
    //   963: ifeq +6 -> 969
    //   966: goto +7 -> 973
    //   969: ldc_w 557
    //   972: ireturn
    //   973: putfield 549	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   976: aload_3
    //   977: aload_1
    //   978: putfield 553	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   981: aload_3
    //   982: iconst_1
    //   983: putfield 556	gnu/mapping/CallContext:pc	I
    //   986: iconst_0
    //   987: ireturn
    //   988: aload_3
    //   989: aload_2
    //   990: ldc -15
    //   992: invokestatic 67	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   995: dup
    //   996: invokestatic 563	gnu/lists/Sequences:asSequenceOrNull	(Ljava/lang/Object;)Ljava/util/List;
    //   999: ifnull +6 -> 1005
    //   1002: goto +7 -> 1009
    //   1005: ldc_w 557
    //   1008: ireturn
    //   1009: putfield 549	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   1012: aload_3
    //   1013: aload_1
    //   1014: putfield 553	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   1017: aload_3
    //   1018: iconst_1
    //   1019: putfield 556	gnu/mapping/CallContext:pc	I
    //   1022: iconst_0
    //   1023: ireturn
    //   1024: aload_3
    //   1025: aload_2
    //   1026: putfield 549	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   1029: aload_3
    //   1030: aload_1
    //   1031: putfield 553	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   1034: aload_3
    //   1035: iconst_1
    //   1036: putfield 556	gnu/mapping/CallContext:pc	I
    //   1039: iconst_0
    //   1040: ireturn
    //   1041: aload_3
    //   1042: aload_2
    //   1043: putfield 549	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   1046: aload_3
    //   1047: aload_1
    //   1048: putfield 553	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   1051: aload_3
    //   1052: iconst_1
    //   1053: putfield 556	gnu/mapping/CallContext:pc	I
    //   1056: iconst_0
    //   1057: ireturn
    //   1058: aload_0
    //   1059: aload_1
    //   1060: aload_2
    //   1061: aload_3
    //   1062: invokespecial 567	gnu/expr/ModuleBody:match1	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Lgnu/mapping/CallContext;)I
    //   1065: ireturn
    // Line number table:
    //   Java source line #36	-> byte code offset #796
    //   Java source line #31	-> byte code offset #829
    //   Java source line #184	-> byte code offset #862
    //   Java source line #135	-> byte code offset #879
    //   Java source line #127	-> byte code offset #915
    //   Java source line #124	-> byte code offset #935
    //   Java source line #99	-> byte code offset #952
    //   Java source line #95	-> byte code offset #988
    //   Java source line #20	-> byte code offset #1024
    //   Java source line #14	-> byte code offset #1041
  }
  
  /* Error */
  public int match3(gnu.expr.ModuleMethod arg1, Object arg2, Object arg3, Object arg4, gnu.mapping.CallContext arg5)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 545	gnu/expr/ModuleMethod:selector	I
    //   4: lookupswitch	default:+178->182, 67:+142->146, 75:+89->93, 79:+36->40
    //   40: aload 5
    //   42: aload_2
    //   43: putfield 549	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   46: aload 5
    //   48: aload_3
    //   49: putfield 570	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   52: aload 5
    //   54: aload 4
    //   56: ldc_w 321
    //   59: invokestatic 67	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   62: dup
    //   63: invokestatic 580	gnu/kawa/lispexpr/LangObjType:coerceToProcedureOrNull	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   66: ifnull +6 -> 72
    //   69: goto +7 -> 76
    //   72: ldc_w 581
    //   75: ireturn
    //   76: putfield 584	gnu/mapping/CallContext:value3	Ljava/lang/Object;
    //   79: aload 5
    //   81: aload_1
    //   82: putfield 553	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   85: aload 5
    //   87: iconst_3
    //   88: putfield 556	gnu/mapping/CallContext:pc	I
    //   91: iconst_0
    //   92: ireturn
    //   93: aload 5
    //   95: aload_2
    //   96: putfield 549	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   99: aload 5
    //   101: aload_3
    //   102: putfield 570	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   105: aload 5
    //   107: aload 4
    //   109: ldc_w 321
    //   112: invokestatic 67	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   115: dup
    //   116: invokestatic 580	gnu/kawa/lispexpr/LangObjType:coerceToProcedureOrNull	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   119: ifnull +6 -> 125
    //   122: goto +7 -> 129
    //   125: ldc_w 581
    //   128: ireturn
    //   129: putfield 584	gnu/mapping/CallContext:value3	Ljava/lang/Object;
    //   132: aload 5
    //   134: aload_1
    //   135: putfield 553	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   138: aload 5
    //   140: iconst_3
    //   141: putfield 556	gnu/mapping/CallContext:pc	I
    //   144: iconst_0
    //   145: ireturn
    //   146: aload 5
    //   148: aload_2
    //   149: putfield 549	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   152: aload 5
    //   154: aload_3
    //   155: invokestatic 16	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   158: putfield 570	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   161: aload 5
    //   163: aload 4
    //   165: putfield 584	gnu/mapping/CallContext:value3	Ljava/lang/Object;
    //   168: aload 5
    //   170: aload_1
    //   171: putfield 553	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   174: aload 5
    //   176: iconst_3
    //   177: putfield 556	gnu/mapping/CallContext:pc	I
    //   180: iconst_0
    //   181: ireturn
    //   182: aload_0
    //   183: aload_1
    //   184: aload_2
    //   185: aload_3
    //   186: aload 4
    //   188: aload 5
    //   190: invokespecial 588	gnu/expr/ModuleBody:match3	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Lgnu/mapping/CallContext;)I
    //   193: ireturn
    // Line number table:
    //   Java source line #176	-> byte code offset #40
    //   Java source line #151	-> byte code offset #93
    //   Java source line #116	-> byte code offset #146
  }
  
  public void apply(gnu.mapping.CallContext paramCallContext)
  {
    gnu.expr.ModuleMethod.applyError();
  }
}
