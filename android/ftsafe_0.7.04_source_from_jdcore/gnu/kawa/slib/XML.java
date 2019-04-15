package gnu.kawa.slib; import gnu.expr.ModuleMethod;

public class XML extends gnu.expr.ModuleBody { private static void $runBody$() { ; gnu.lists.Consumer $result = getInstanceconsumer;as$Mnxml = new gnu.kawa.xml.OutputAsXML();
  }
  

  public static gnu.kawa.xml.OutputAsXML as$Mnxml;
  
  public static final Class comment;
  
  public static final Class processing$Mninstruction;
  
  public static final ModuleMethod parse$Mnxml$Mnfrom$Mnurl;
  
  public static final ModuleMethod element$Mnname;
  
  public static final ModuleMethod attribute$Mnname;
  
  public static XML $instance;
  static final gnu.mapping.SimpleSymbol Lit0;
  static final gnu.mapping.SimpleSymbol Lit1;
  static final gnu.mapping.SimpleSymbol Lit2 = gnu.mapping.Symbol.valueOf("attribute-name");
  public int match1(ModuleMethod paramModuleMethod, Object paramObject, gnu.mapping.CallContext paramCallContext)
  {
    switch (selector) {case 3:  Object tmp39_36 = gnu.mapping.Promise.force(paramObject, gnu.kawa.xml.KAttr.class);
      





















      if (!(tmp39_36 instanceof gnu.kawa.xml.KAttr)) return -786431; value1 = tmp39_36;proc = paramModuleMethod;pc = 1;return 0;
    case 2: 
      Object tmp71_68 = gnu.mapping.Promise.force(paramObject, gnu.kawa.xml.KElement.class);
      


















      if (!(tmp71_68 instanceof gnu.kawa.xml.KElement)) return -786431; value1 = tmp71_68;proc = paramModuleMethod;pc = 1;return 0;
    case 1: 
      value1 = paramObject;proc = paramModuleMethod;pc = 1;return 0; } return super.match1(paramModuleMethod, paramObject, paramCallContext); }
  public static gnu.kawa.xml.KDocument parseXmlFromUrl(Object url) { return gnu.kawa.xml.Document.parse(url); }
  
  public static gnu.mapping.Symbol elementName(gnu.kawa.xml.KElement element) {
    return element.getNodeSymbol();
  }
  
  public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
  {
    switch (selector) {case 1:  return parseXmlFromUrl(paramObject);
    }
    try {
      return elementName((gnu.kawa.xml.KElement)gnu.mapping.Promise.force(paramObject, gnu.kawa.xml.KElement.class)); } catch (ClassCastException localClassCastException1) { throw new gnu.mapping.WrongType(
      

        localClassCastException1, "element-name", 1, paramObject); } try { return attributeName((gnu.kawa.xml.KAttr)gnu.mapping.Promise.force(paramObject, gnu.kawa.xml.KAttr.class)); } catch (ClassCastException localClassCastException2) { throw new gnu.mapping.WrongType(localClassCastException2, "attribute-name", 1, paramObject); } return super.apply1(paramModuleMethod, paramObject); }
  public static gnu.mapping.Symbol attributeName(gnu.kawa.xml.KAttr attr) { return attr.getNodeSymbol(); }
  
  static
  {
    Lit1 = gnu.mapping.Symbol.valueOf("element-name");
    Lit0 = gnu.mapping.Symbol.valueOf("parse-xml-from-url");
    processing$Mninstruction = gnu.kawa.xml.KProcessingInstruction.class;
    comment = gnu.kawa.xml.KComment.class;
    $instance = new XML();
    XML localXML = $instance;
    parse$Mnxml$Mnfrom$Mnurl = new ModuleMethod(localXML, 1, Lit0, 4097);
    element$Mnname = new ModuleMethod(localXML, 2, Lit1, 4097);
    attribute$Mnname = new ModuleMethod(localXML, 3, Lit2, 4097);
    $runBody$();
  }
  
  public XML()
  {
    gnu.expr.ModuleInfo.register(this);
  }
  
  public void apply(gnu.mapping.CallContext paramCallContext)
  {
    ModuleMethod.applyError();
  }
}
