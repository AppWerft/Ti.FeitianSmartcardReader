package gnu.kawa.xslt;

import gnu.bytecode.ClassType;
import gnu.bytecode.Method;
import gnu.expr.ApplyExp;
import gnu.expr.Compilation;
import gnu.expr.Expression;
import gnu.expr.ModuleExp;
import gnu.expr.PrimProcedure;
import gnu.expr.QuoteExp;
import gnu.kawa.io.InPort;
import gnu.lists.Consumer;
import gnu.mapping.Symbol;
import gnu.math.DFloNum;
import gnu.text.SourceMessages;
import gnu.xml.XName;
import gnu.xquery.lang.XQParser;
import java.util.Stack;
import java.util.Vector;

public class XslTranslator extends gnu.text.Lexer implements Consumer
{
  boolean inTemplate;
  gnu.expr.Declaration consumerDecl;
  StringBuffer nesting = new StringBuffer(100);
  
  ModuleExp mexp;
  
  Compilation comp;
  
  boolean inAttribute;
  
  Object attributeType;
  StringBuffer attributeValue = new StringBuffer(100);
  
  boolean preserveSpace;
  
  XSLT interpreter;
  
  InPort in;
  
  gnu.expr.LambdaExp templateLambda;
  static final String XSL_TRANSFORM_URI = "http://www.w3.org/1999/XSL/Transform";
  
  XslTranslator(InPort inp, SourceMessages messages, XSLT interpreter)
  {
    super(inp, messages);
    this.interpreter = interpreter;
    in = inp;
  }
  



  void maybeSkipWhitespace()
  {
    if (preserveSpace)
      return;
    int size = comp.exprStack.size();
    for (;;) { size--; if (size < 0)
        break;
      Object expr = (Expression)comp.exprStack.elementAt(size);
      if (!(expr instanceof QuoteExp))
        break;
      Object value = ((QuoteExp)expr).getValue();
      String str = value == null ? "" : value.toString();
      int j = str.length(); for (;;) { j--; if (j < 0)
          break;
        char ch = str.charAt(j);
        if ((ch != ' ') && (ch != '\t') && (ch != '\r') && (ch != '\n')) {
          return;
        }
      }
    }
    

    comp.exprStack.setSize(size + 1);
  }
  
  public String popMatchingAttribute(String ns, String name, int start)
  {
    int size = comp.exprStack.size();
    for (int i = start; i < size; i++)
    {
      Object el = comp.exprStack.elementAt(start);
      if (!(el instanceof ApplyExp))
        return null;
      ApplyExp aexp = (ApplyExp)el;
      Expression function = aexp.getFunction();
      if (aexp.getFunction() != gnu.kawa.xml.MakeAttribute.makeAttributeExp)
        return null;
      Expression[] args = aexp.getArgs();
      if (args.length != 2)
        return null;
      Expression arg0 = args[0];
      if (!(arg0 instanceof QuoteExp))
        return null;
      Object tag = ((QuoteExp)arg0).getValue();
      if (!(tag instanceof Symbol))
        return null;
      Symbol stag = (Symbol)tag;
      if ((stag.getLocalPart() == name) && (stag.getNamespaceURI() == ns))
      {
        comp.exprStack.removeElementAt(i);
        return (String)((QuoteExp)args[1]).getValue();
      }
    }
    return null;
  }
  

  Expression popTemplateBody(int start)
  {
    int i = comp.exprStack.size() - start;
    
    Expression[] args = new Expression[i];
    for (;;) { i--; if (i < 0) break;
      args[i] = ((Expression)comp.exprStack.pop()); }
    return new ApplyExp(gnu.kawa.functions.AppendValues.appendValues, args);
  }
  
  public static String isXslTag(Object type)
  {
    if ((type instanceof QuoteExp))
      type = ((QuoteExp)type).getValue();
    if (!(type instanceof Symbol))
      return null;
    Symbol qname = (Symbol)type;
    if (qname.getNamespaceURI() != "http://www.w3.org/1999/XSL/Transform")
      return null;
    return qname.getLocalName();
  }
  


  void append(Expression expr) {}
  

  public void startElement(Object type)
  {
    maybeSkipWhitespace();
    String xslTag = isXslTag(type);
    if (xslTag == "template")
    {
      if (templateLambda != null)
        error("nested xsl:template");
      templateLambda = new gnu.expr.LambdaExp();


    }
    else if (xslTag == "text") {
      preserveSpace = false; }
    if ((type instanceof XName))
    {


      XName xn = (XName)type;
      type = Symbol.make(xn.getNamespaceURI(), xn.getLocalPart(), xn.getPrefix());
    }
    
    nesting.append((char)comp.exprStack.size());
    push(type);
  }
  
  public void startAttribute(Object attrType)
  {
    if (inAttribute)
      error('f', "internal error - attribute inside attribute");
    attributeType = attrType;
    attributeValue.setLength(0);
    nesting.append((char)comp.exprStack.size());
    inAttribute = true;
  }
  
  public void endAttribute()
  {
    Expression[] args = new Expression[2];
    args[0] = new QuoteExp(attributeType);
    args[1] = new QuoteExp(attributeValue.toString());
    push(new ApplyExp(gnu.kawa.xml.MakeAttribute.makeAttributeExp, args));
    nesting.setLength(nesting.length() - 1);
    inAttribute = false;
  }
  
  public void endElement()
  {
    maybeSkipWhitespace();
    int nlen = nesting.length() - 1;
    int start = nesting.charAt(nlen);
    nesting.setLength(nlen);
    Expression startTag = (Expression)comp.exprStack.elementAt(start);
    String xslTag = isXslTag(startTag);
    if (xslTag == "value-of")
    {
      String select = popMatchingAttribute("", "select", start + 1);
      if (select != null)
      {
        Expression exp = parseXPath(select);
        exp = new ApplyExp(XQParser.makeText, new Expression[] { exp });
        comp.exprStack.pop();
        push(exp);
        return;
      }
    }
    else if (xslTag == "copy-of")
    {
      String select = popMatchingAttribute("", "select", start + 1);
      if (select != null)
      {
        Expression exp = parseXPath(select);
        comp.exprStack.pop();
        push(exp);
        return;
      }
    }
    else if (xslTag == "apply-templates")
    {
      String select = popMatchingAttribute("", "select", start + 1);
      String mode = popMatchingAttribute("", "mode", start + 1);
      Expression[] args = { new QuoteExp(select), resolveQNameExpression(mode) };
      
      comp.exprStack.pop();
      push(new ApplyExp(ApplyTemplates.applyTemplatesProc, args));
    }
    else if (xslTag == "if")
    {
      String select = popMatchingAttribute("", "test", start + 1);
      Expression test = parseXPath(select);
      test = XQParser.booleanValue(test);
      Expression clause = popTemplateBody(start + 1);
      comp.exprStack.pop();
      push(new gnu.expr.IfExp(test, clause, QuoteExp.voidExp));
    }
    else if ((xslTag == "stylesheet") || (xslTag == "transform"))
    {
      String version = popMatchingAttribute("", "version", start + 1);
      push(new ApplyExp(new QuoteExp(runStylesheetProc), Expression.noExpressions));
      
      Expression body = popTemplateBody(start + 1);
      push(body);
      mexp.body = body;
    }
    else if (xslTag == "template")
    {
      String match = popMatchingAttribute("", "match", start + 1);
      String name = popMatchingAttribute("", "name", start + 1);
      String priority = popMatchingAttribute("", "priority", start + 1);
      String mode = popMatchingAttribute("", "mode", start + 1);
      templateLambda.body = popTemplateBody(start + 1);
      comp.exprStack.pop();
      Expression[] args = new Expression[5];
      double prio = 0.0D;
      args[0] = resolveQNameExpression(name);
      args[1] = new QuoteExp(match);
      args[2] = new QuoteExp(DFloNum.valueOf(prio));
      args[3] = resolveQNameExpression(mode);
      args[4] = templateLambda;
      push(new ApplyExp(new QuoteExp(defineTemplateProc), args));
      templateLambda = null;
    }
    else if (xslTag == "text")
    {
      preserveSpace = false;
      Expression[] args = new Expression[comp.exprStack.size() - start - 1];
      int i = args.length; for (;;) { i--; if (i < 0) break;
        args[i] = ((Expression)comp.exprStack.pop()); }
      comp.exprStack.pop();
      Expression exp = new ApplyExp(XQParser.makeText, args);
      push(exp);
      mexp.body = exp;
    }
    else
    {
      Expression[] args = new Expression[comp.exprStack.size() - start];
      int i = args.length; for (;;) { i--; if (i < 0) break;
        args[i] = ((Expression)comp.exprStack.pop()); }
      gnu.kawa.xml.MakeElement mkElement = new gnu.kawa.xml.MakeElement();
      
      Expression exp = new ApplyExp(new QuoteExp(mkElement), args);
      push(exp);
      mexp.body = exp;
    }
  }
  
  Expression parseXPath(String string)
  {
    SourceMessages messages = comp.getMessages();
    try
    {
      XQParser parser = new XQParser(new gnu.kawa.io.CharArrayInPort(string), messages, interpreter);
      
      Vector exps = new Vector(20);
      
      for (;;)
      {
        Expression sexp = parser.parse(comp);
        if (sexp == null)
          break;
        exps.addElement(sexp);
      }
      int nexps = exps.size();
      if (nexps == 0)
        return QuoteExp.voidExp;
      if (nexps == 1) {
        return (Expression)exps.elementAt(0);
      }
      throw new InternalError("too many xpath expressions");
    }
    catch (Exception ex)
    {
      ex.printStackTrace();
      throw new InternalError("caught " + ex);
    }
  }
  
  public void write(int v)
  {
    if (inAttribute)
    {

      attributeValue.appendCodePoint(v);
    }
    else
    {
      String str;
      
      String str;
      
      if (v < 65536) {
        str = String.valueOf(v);
      }
      else {
        char[] c2 = { (char)((v - 65536 >> 10) + 55296), (char)((v & 0x3FF) + 56320) };
        
        str = new String(c2);
      }
      push(str);
    }
  }
  

  public Consumer append(char v)
  {
    if (inAttribute) {
      attributeValue.append(v);
    } else
      push(String.valueOf(v));
    return this;
  }
  
  public Consumer append(CharSequence csq)
  {
    if (inAttribute) {
      attributeValue.append(csq);
    } else
      push(csq.toString());
    return this;
  }
  
  public Consumer append(CharSequence csq, int start, int end)
  {
    return append(csq.subSequence(start, end));
  }
  










  void push(Expression exp)
  {
    comp.exprStack.push(exp);
  }
  
  void push(Object value)
  {
    push(new QuoteExp(value));
  }
  
  public void writeBoolean(boolean v)
  {
    if (inAttribute) {
      attributeValue.append(v);
    } else {
      push(v ? QuoteExp.trueExp : QuoteExp.falseExp);
    }
  }
  
  public void writeFloat(float v) {
    if (inAttribute) {
      attributeValue.append(v);
    } else {
      push(DFloNum.valueOf(v));
    }
  }
  
  public void writeDouble(double v) {
    if (inAttribute) {
      attributeValue.append(v);
    } else {
      push(DFloNum.valueOf(v));
    }
  }
  
  public void writeInt(int v) {
    if (inAttribute) {
      attributeValue.append(v);
    } else {
      push(gnu.math.IntNum.valueOf(v));
    }
  }
  
  public void writeLong(long v) {
    if (inAttribute) {
      attributeValue.append(v);
    } else {
      push(gnu.math.IntNum.valueOf(v));
    }
  }
  

  public void startDocument() {}
  

  public void startDocument(ModuleExp mexp)
  {
    this.mexp = mexp;
    startDocument();
  }
  

  public void endDocument() {}
  

  public void writeObject(Object v)
  {
    if (inAttribute) {
      attributeValue.append(v);
    } else {
      push(v);
    }
  }
  
  public void write(char[] buf, int off, int len) {
    if (inAttribute) {
      attributeValue.append(buf, off, len);
    } else {
      push(new String(buf, off, len));
    }
  }
  
  public void write(String str) {
    if (inAttribute) {
      attributeValue.append(str);
    } else {
      push(str);
    }
  }
  
  public void write(CharSequence str, int start, int length)
  {
    write(str.subSequence(start, length).toString());
  }
  






  public boolean ignoring()
  {
    return false;
  }
  
  public Expression getExpression()
  {
    return (Expression)comp.exprStack.pop();
  }
  
  public void error(char kind, String message)
  {
    getMessages().error(kind, message);
  }
  








  Expression resolveQNameExpression(String name)
  {
    if (name == null) {
      return QuoteExp.nullExp;
    }
    return new QuoteExp(Symbol.make(null, name));
  }
  
  public void parse(Compilation comp)
    throws java.io.IOException
  {
    this.comp = comp;
    if (exprStack == null)
      exprStack = new Stack();
    ModuleExp mexp = comp.getModule();
    comp.mustCompileHere();
    startDocument(mexp);
    gnu.xml.XMLParser.parse(in, getMessages(), this);
    endDocument();
    comp.pop(mexp);
  }
  
  static final ClassType typeXSLT = ClassType.make("gnu.kawa.xslt.XSLT");
  
  static final ClassType typeTemplateTable = ClassType.make("gnu.kawa.xslt.TemplateTable");
  
  static final Method defineTemplateMethod = typeXSLT.getDeclaredMethod("defineTemplate", 5);
  
  static final Method runStylesheetMethod = typeXSLT.getDeclaredMethod("runStylesheet", 0);
  
  static final PrimProcedure defineTemplateProc = new PrimProcedure(defineTemplateMethod);
  
  static final PrimProcedure runStylesheetProc = new PrimProcedure(runStylesheetMethod);
}
