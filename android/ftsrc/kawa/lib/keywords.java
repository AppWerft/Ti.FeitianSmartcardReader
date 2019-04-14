package kawa.lib; import gnu.expr.ModuleMethod;

public class keywords extends gnu.expr.ModuleBody { private static void $runBody$() { ; gnu.lists.Consumer $result = getInstanceconsumer;
  }
  
  public static final ModuleMethod keyword$Qu;
  public static final ModuleMethod keyword$Mn$Grstring;
  public static final ModuleMethod string$Mn$Grkeyword;
  
  public int match1(ModuleMethod paramModuleMethod, Object paramObject, gnu.mapping.CallContext paramCallContext) {
    switch (selector) {case 3:  value1 = gnu.mapping.Promise.force(paramObject, String.class);proc = paramModuleMethod;pc = 1;return 0;
    case 2: 
      Object tmp61_58 = gnu.mapping.Promise.force(paramObject, gnu.expr.Keyword.class);
      




      if (!(tmp61_58 instanceof gnu.expr.Keyword)) return -786431; value1 = tmp61_58;proc = paramModuleMethod;pc = 1;return 0;
    case 1: 
      value1 = paramObject;proc = paramModuleMethod;pc = 1;return 0; } return super.match1(paramModuleMethod, paramObject, paramCallContext); }
  public static boolean isKeyword(Object object) { return gnu.expr.Keyword.isKeyword(object); }
  
  public static CharSequence keyword$To$String(gnu.expr.Keyword keyword) {
    return keyword.getName();
  }
  
  public static keywords $instance;
  static final gnu.mapping.SimpleSymbol Lit0;
  static final gnu.mapping.SimpleSymbol Lit1;
  static final gnu.mapping.SimpleSymbol Lit2 = gnu.mapping.Symbol.valueOf("string->keyword");
  public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
  {
    switch (selector) {case 1:  return isKeyword(paramObject) ? Boolean.TRUE : Boolean.FALSE;
    }
    try {
      return keyword$To$String((gnu.expr.Keyword)gnu.mapping.Promise.force(paramObject, gnu.expr.Keyword.class)); } catch (ClassCastException localClassCastException) { throw new gnu.mapping.WrongType(
      

        localClassCastException, "keyword->string", 1, paramObject); } Object tmp68_65 = gnu.mapping.Promise.force(paramObject, String.class);tmp68_65;return string$To$Keyword(tmp68_65 == null ? null : tmp68_65.toString());return super.apply1(paramModuleMethod, paramObject); }
  public static gnu.expr.Keyword string$To$Keyword(String string) { return gnu.expr.Keyword.make(string); }
  
  static
  {
    Lit1 = gnu.mapping.Symbol.valueOf("keyword->string");
    Lit0 = gnu.mapping.Symbol.valueOf("keyword?");
    $instance = new keywords();
    keywords localKeywords = $instance;
    keyword$Qu = new ModuleMethod(localKeywords, 1, Lit0, 4097);
    keyword$Mn$Grstring = new ModuleMethod(localKeywords, 2, Lit1, 4097);
    string$Mn$Grkeyword = new ModuleMethod(localKeywords, 3, Lit2, 4097);
    $runBody$();
  }
  
  public keywords()
  {
    gnu.expr.ModuleInfo.register(this);
  }
  
  public void apply(gnu.mapping.CallContext paramCallContext)
  {
    ModuleMethod.applyError();
  }
}
