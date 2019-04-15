package gnu.kawa.xslt;

import gnu.bytecode.CodeAttr;
import gnu.expr.ApplyExp;
import gnu.expr.Compilation;
import gnu.expr.ConsumerTarget;
import gnu.expr.Expression;
import gnu.kawa.xml.Focus;
import gnu.lists.Consumer;
import gnu.lists.TreeList;
import gnu.mapping.CallContext;
import gnu.mapping.Symbol;

public class ApplyTemplates extends gnu.kawa.xml.NodeConstructor
{
  public ApplyTemplates() {}
  
  public static final ApplyTemplates applyTemplatesProc = new ApplyTemplates();
  
  public int numArgs() {
    return 8194;
  }
  
  public static void applyTemplates$C(String select, Symbol mode, Consumer out) throws Throwable {
    CallContext ctx = CallContext.getInstance();
    Consumer save = consumer;
    consumer = out;
    try {
      applyTemplates$X(select, mode, ctx);
    } finally {
      consumer = save;
    }
  }
  
  public static void applyTemplates$X(String select, Symbol mode, CallContext ctx) throws Throwable
  {
    if (mode == null)
      mode = XSLT.nullMode;
    TemplateTable table = TemplateTable.getTemplateTable(mode);
    Focus pos = Focus.getCurrent();
    TreeList doc = (TreeList)sequence;
    Object cur = doc.getPosNext(ipos);
    pos.push(doc, doc.firstChildPos(ipos));
    XSLT.process(doc, pos, ctx);
    pos.pop();
  }
  
  public void apply(CallContext ctx) throws Throwable {
    applyTemplates$X((String)ctx.getNextArg(null), (Symbol)ctx.getNextArg(null), ctx);
  }
  


  public void compileToNode(ApplyExp exp, Compilation comp, ConsumerTarget target)
  {
    CodeAttr code = comp.getCode();
    Expression[] args = exp.getArgs();
    args[0].compile(comp, gnu.expr.Target.pushObject);
    args[1].compile(comp, gnu.expr.Target.pushObject);
    String mname;
    String mname; if (target.isContextTarget()) {
      comp.loadCallContext();
      mname = "applyTemplates$X";
    } else {
      code.emitLoad(target.getConsumerVariable());
      mname = "applyTemplates$C";
    }
    code.emitInvokeStatic(gnu.bytecode.ClassType.make("gnu.kawa.xslt.ApplyTemplates").getDeclaredMethod(mname, 3));
  }
}
