package gnu.kawa.lispexpr;

import gnu.bytecode.ClassType;
import gnu.expr.Declaration;
import gnu.lists.Pair;
import gnu.mapping.Namespace;
import gnu.mapping.Symbol;
import kawa.lang.Translator;

public class DefineNamespace extends kawa.lang.Syntax
{
  private boolean makePrivate;
  private boolean makeXML;
  public static final DefineNamespace define_namespace = new DefineNamespace();
  
  public static final DefineNamespace define_private_namespace = new DefineNamespace();
  
  public static final DefineNamespace define_xml_namespace = new DefineNamespace();
  public static final String XML_NAMESPACE_MAGIC = "&xml&";
  
  static { define_namespace.setName("define-namespace");
    define_private_namespace.setName("define-private-namespace");
    define_private_namespacemakePrivate = true;
    define_xml_namespace.setName("define-xml-namespace");
    define_xml_namespacemakeXML = true;
  }
  
  public boolean scanForDefinitions(Pair st, gnu.expr.ScopeExp defs, Translator tr)
  {
    Pair p1;
    Pair p2;
    if ((!(st.getCdr() instanceof Pair)) || (!((p1 = (Pair)st.getCdr()).getCar() instanceof Symbol)) || (!(p1.getCdr() instanceof Pair)) || ((p2 = (Pair)p1.getCdr()).getCdr() != gnu.lists.LList.Empty))
    {



      tr.error('e', "invalid syntax for define-namespace");
      return false; }
    Pair p2;
    Pair p1; Symbol name = (Symbol)p1.getCar();
    Declaration decl = defs.getDefine(name, tr);
    tr.push(decl);
    decl.setFlag(2375680L);
    
    if (makePrivate)
    {
      decl.setFlag(16777216L);
      decl.setPrivate(true);
    }
    else if ((defs instanceof gnu.expr.ModuleExp)) {
      decl.setCanRead(true); }
    Translator.setLine(decl, p1);
    
    String literal = null;
    gnu.expr.Expression value; if ((p2.getCar() instanceof CharSequence))
    {





      literal = p2.getCar().toString();
      
      String prefix = name.getName();
      Namespace namespace; if (literal.startsWith("class:"))
      {
        String cname = literal.substring(6);
        Namespace namespace = ClassNamespace.getInstance(literal, ClassType.make(cname));
        
        decl.setType(ClassType.make("gnu.kawa.lispexpr.ClassNamespace"));
      }
      else if (makeXML)
      {
        Namespace namespace = gnu.kawa.xml.XmlNamespace.getInstance(prefix, literal);
        decl.setType(ClassType.make("gnu.kawa.xml.XmlNamespace"));
      }
      else
      {
        namespace = Namespace.valueOf(literal, prefix);
        decl.setType(ClassType.make("gnu.mapping.Namespace"));
      }
      gnu.expr.Expression value = new gnu.expr.QuoteExp(namespace);
      decl.setFlag(8192L);
    }
    else {
      value = tr.rewrite_car(p2, false); }
    decl.noteValue(value);
    tr.pushForm(gnu.expr.SetExp.makeDefinition(decl, value));
    return true;
  }
  
  public gnu.expr.Expression rewriteForm(Pair form, Translator tr)
  {
    return tr.syntaxError("define-namespace is only allowed in a <body>");
  }
  
  public DefineNamespace() {}
}
