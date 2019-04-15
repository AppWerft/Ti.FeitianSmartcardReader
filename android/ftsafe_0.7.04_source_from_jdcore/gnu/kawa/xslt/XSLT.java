package gnu.kawa.xslt;

import gnu.expr.ApplicationMainSupport;
import gnu.expr.Compilation;
import gnu.kawa.io.InPort;
import gnu.kawa.xml.Focus;
import gnu.kawa.xml.KDocument;
import gnu.lists.Consumer;
import gnu.lists.TreeList;
import gnu.mapping.CallContext;
import gnu.mapping.Procedure;
import gnu.mapping.Symbol;
import gnu.text.SourceMessages;
import gnu.xquery.lang.XQParser;
import gnu.xquery.lang.XQResolveNames;

public class XSLT extends gnu.xquery.lang.XQuery
{
  public static XSLT instance;
  
  public String getName()
  {
    return "XSLT";
  }
  
  public XSLT()
  {
    instance = this;
    gnu.expr.ModuleBody.setMainPrintValues(true);
  }
  
  public static XSLT getXsltInstance()
  {
    if (instance == null)
      new XSLT();
    return instance;
  }
  
  public gnu.text.Lexer getLexer(InPort inp, SourceMessages messages)
  {
    return new XslTranslator(inp, messages, this);
  }
  
  public boolean parse(Compilation comp, int options)
    throws java.io.IOException, gnu.text.SyntaxException
  {
    Compilation.defaultCallConvention = 2;
    ((XslTranslator)lexer).parse(comp);
    comp.setState(4);
    
    XQParser xqparser = new XQParser(null, comp.getMessages(), this);
    if (mainLambda.body == null)
      return false;
    XQResolveNames resolver = new XQResolveNames(comp);
    functionNamespacePath = functionNamespacePath;
    parser = xqparser;
    resolver.resolveModule(mainLambda);
    
    return true;
  }
  

  public static void registerEnvironment()
  {
    gnu.expr.Language.setDefaults(new XSLT());
  }
  






  public static Symbol nullMode = Symbol.make(null, "");
  

  public static void defineCallTemplate(Symbol name, double priority, Procedure template) {}
  
  public static void defineApplyTemplate(String pattern, double priority, Symbol mode, Procedure template)
  {
    if (mode == null)
      mode = nullMode;
    TemplateTable table = TemplateTable.getTemplateTable(mode);
    table.enter(pattern, priority, template);
  }
  


  public static void defineTemplate(Symbol name, String pattern, double priority, Symbol mode, Procedure template)
  {
    if (name != null)
      defineCallTemplate(name, priority, template);
    if (pattern != null) {
      defineApplyTemplate(pattern, priority, mode, template);
    }
  }
  
  public static void process(TreeList doc, Focus pos, CallContext ctx) throws Throwable
  {
    Consumer out = consumer;
    for (;;)
    {
      int ipos = ipos;
      int kind = doc.getNextKind(ipos);
      Object type;
      String name;
      Procedure proc;
      switch (kind)
      {
      case 34: 
        ipos = doc.firstChildPos(ipos);
        break;
      case 33: 
        type = pos.getNextTypeObject();
        name = pos.getNextTypeName();
        proc = TemplateTable.nullModeTable.find(name);
        if (proc != null)
        {
          proc.check0(ctx);
          ctx.runUntilDone();
        }
        else
        {
          out.startElement(type);
          int child = doc.firstAttributePos(ipos);
          if (child == 0)
            child = doc.firstChildPos(ipos);
          pos.push(doc, child);
          process(doc, pos, ctx);
          pos.pop();
          out.endElement();
        }
        ipos = doc.nextDataIndex(ipos >>> 1) << 1;
        pos.gotoNext();
        break;
      case 35: 
        type = pos.getNextTypeObject();
        name = pos.getNextTypeName();
        proc = TemplateTable.nullModeTable.find("@" + name);
        if (proc != null)
        {
          proc.check0(ctx);
          ctx.runUntilDone(); }
        break;
      

      case 29: 
        int ichild = ipos >>> 1;
        int next = doc.nextNodeIndex(ichild, Integer.MAX_VALUE);
        if (ichild == next)
          next = doc.nextDataIndex(ichild);
        doc.consumeIRange(ichild, next, out);
        ipos = next << 1;
        break;
      case 36: 
      case 37: 
        ipos = doc.nextDataIndex(ipos >>> 1) << 1;
        break;
      }
      
      
      return;
      
      ipos = ipos;
    }
  }
  
  public static void runStylesheet()
    throws Throwable
  {
    CallContext ctx = CallContext.getInstance();
    ApplicationMainSupport.processSetProperties();
    String[] args = ApplicationMainSupport.commandLineArgArray;
    for (int i = 0; i < args.length; i++)
    {
      String arg = args[i];
      KDocument doc = gnu.kawa.xml.Document.parse(arg);
      Focus pos = Focus.getCurrent();
      pos.push(sequence, ipos);
      process((TreeList)sequence, pos, ctx);
    }
  }
}
