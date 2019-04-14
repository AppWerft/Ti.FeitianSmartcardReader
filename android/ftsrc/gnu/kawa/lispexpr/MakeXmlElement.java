package gnu.kawa.lispexpr;

import gnu.bytecode.ClassType;
import gnu.expr.Declaration;
import gnu.expr.Expression;
import gnu.expr.QuoteExp;
import gnu.kawa.xml.MakeElement;
import gnu.kawa.xml.XmlNamespace;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.mapping.Namespace;
import gnu.mapping.Symbol;
import gnu.xml.NamespaceBinding;
import kawa.lang.Syntax;
import kawa.lang.Translator;

public class MakeXmlElement extends Syntax
{
  public static final MakeXmlElement makeXml = new MakeXmlElement();
  static { makeXml.setName("$make-xml$"); }
  
  static final ClassType typeNamespace = ClassType.make("gnu.mapping.Namespace");
  

  public Expression rewriteForm(Pair form, Translator tr)
  {
    Pair pair1 = (Pair)form.getCdr();
    Object namespaceList = pair1.getCar();
    Object obj = pair1.getCdr();
    boolean nsSeen = false;
    NamespaceBinding saveBindings = xmlElementNamespaces;
    NamespaceBinding nsBindings = saveBindings;
    String nsPrefix; while ((namespaceList instanceof Pair))
    {
      if (!nsSeen)
      {
        tr.letStart();
        nsSeen = true;
      }
      Pair namespacePair = (Pair)namespaceList;
      Pair namespaceNode = (Pair)namespacePair.getCar();
      nsPrefix = namespaceNode.getCar().toString();
      nsPrefix = nsPrefix.length() == 0 ? null : nsPrefix.intern();
      Object valueList = namespaceNode.getCdr();
      StringBuilder sbuf = new StringBuilder();
      while ((valueList instanceof Pair))
      {
        Pair valuePair = (Pair)valueList;
        Object valueForm = valuePair.getCar();
        Object value;
        Object value; if ((LList.listLength(valueForm, false) == 2) && ((valueForm instanceof Pair)) && (((Pair)valueForm).getCar() == ReaderXmlElement.xmlTextSymbol))
        {


          value = ((Pair)((Pair)valueForm).getCdr()).getCar();
        }
        else
        {
          Expression valueExp = tr.rewrite_car(valuePair, false);
          value = valueExp.valueIfConstant();
        }
        if (value == null)
        {
          Object savePos = tr.pushPositionOf(valuePair);
          tr.error('e', "namespace URI must be literal");
          tr.popPositionOf(savePos);
        }
        else {
          sbuf.append(value); }
        valueList = valuePair.getCdr();
      }
      String nsUri = sbuf.toString().intern();
      


      nsBindings = new NamespaceBinding(nsPrefix, nsUri == "" ? null : nsUri, nsBindings);
      

      Namespace namespace;
      
      if (nsPrefix == null)
      {
        Namespace namespace = Namespace.valueOf(nsUri);
        nsPrefix = "$default-element-namespace$";
      }
      else
      {
        namespace = XmlNamespace.getInstance(nsPrefix, nsUri);
      }
      Symbol nsSymbol = Namespace.EmptyNamespace.getSymbol(nsPrefix);
      Declaration decl = tr.letVariable(nsSymbol, typeNamespace, new QuoteExp(namespace));
      
      decl.setFlag(2121728L);
      
      namespaceList = namespacePair.getCdr();
    }
    
    MakeElement mkElement = new MakeElement();
    mkElement.setNamespaceNodes(nsBindings);
    mkElement.setStringIsText(true);
    xmlElementNamespaces = nsBindings;
    try
    {
      if (nsSeen)
        tr.letEnter();
      Expression result = tr.rewrite(Translator.makePair(form, mkElement, obj));
      return nsSeen ? tr.letDone(result) : result;
    }
    finally
    {
      xmlElementNamespaces = saveBindings;
    }
  }
  
  public MakeXmlElement() {}
}
