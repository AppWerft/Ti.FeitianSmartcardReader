package kawa.standard;

import gnu.expr.Expression;
import gnu.expr.LambdaExp;
import kawa.lang.Translator;
import kawa.lang.Translator.ScanContext;

public class Scan extends kawa.lang.Syntax
{
  public static final Scan scan = new Scan();
  static { scan.setName("scan"); }
  
  public Expression rewrite(Object obj, Translator tr)
  {
    if (Translator.listLength(obj) != 1)
      return tr.syntaxError("'scan' requires a single argument");
    Translator.ScanContext savedScanContext = tr.getScanContext();
    if (savedScanContext == null)
      tr.error('e', "'scan' not in a '...'- context");
    try {
      tr.setScanContext(null);
      Expression scanExp = tr.rewrite_car((gnu.lists.Pair)obj, false);
      gnu.expr.Declaration paramDecl = savedScanContext.getLambda().addParameter(null);
      
      savedScanContext.addSeqExpression(scanExp);
      return new gnu.expr.ReferenceExp(paramDecl);
    } finally {
      tr.setScanContext(savedScanContext);
    }
  }
  
  public Scan() {}
}
