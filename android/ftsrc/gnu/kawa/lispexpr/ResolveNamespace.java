package gnu.kawa.lispexpr;

import gnu.expr.Expression;
import gnu.expr.QuoteExp;
import gnu.lists.Pair;
import gnu.mapping.Namespace;
import kawa.lang.Syntax;
import kawa.lang.Translator;

public class ResolveNamespace extends Syntax
{
  public static final ResolveNamespace resolveNamespace = new ResolveNamespace("$resolve-namespace$", false);
  
  public static final ResolveNamespace resolveQName = new ResolveNamespace("$resolve-qname$", true);
  
  boolean resolvingQName;
  

  public ResolveNamespace(String name, boolean resolvingQName)
  {
    super(name);
    this.resolvingQName = resolvingQName;
  }
  
  public Expression rewriteForm(Pair form, Translator tr) {
    Object cdr = form.getCdr();
    String local;
    if (resolvingQName)
    {
      Pair pair = (Pair)cdr;
      String local = pair.getCar().toString();
      cdr = pair.getCdr();
    }
    else {
      local = null; }
    if (!(cdr instanceof Pair))
      cdr = gnu.lists.LList.list1(ReaderXmlElement.defaultElementNamespaceSymbol);
    Pair pair = (Pair)cdr;
    Expression prefix = tr.rewrite_car(pair, false);
    Namespace namespace = tr.namespaceResolvePrefix(prefix);
    if (namespace == null) {
      String pstr = pair.getCar().toString();
      if (pstr == "$default-element-namespace$") {
        namespace = Namespace.EmptyNamespace;
      } else {
        Object savePos = tr.pushPositionOf(pair);
        tr.error('e', "unknown namespace prefix " + pstr);
        tr.popPositionOf(savePos);
        namespace = Namespace.valueOf(pstr, pstr);
      }
    }
    if (resolvingQName) {
      return new QuoteExp(namespace.getSymbol(local));
    }
    return new QuoteExp(namespace);
  }
}
