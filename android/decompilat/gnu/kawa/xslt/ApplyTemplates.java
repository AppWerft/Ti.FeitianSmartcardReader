// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.xslt;

import gnu.expr.Expression;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.ClassType;
import gnu.expr.Target;
import gnu.expr.ConsumerTarget;
import gnu.expr.Compilation;
import gnu.expr.ApplyExp;
import gnu.lists.AbstractSequence;
import gnu.lists.TreeList;
import gnu.kawa.xml.Focus;
import gnu.mapping.CallContext;
import gnu.lists.Consumer;
import gnu.mapping.Symbol;
import gnu.kawa.xml.NodeConstructor;

public class ApplyTemplates extends NodeConstructor
{
    public static final ApplyTemplates applyTemplatesProc;
    
    @Override
    public int numArgs() {
        return 8194;
    }
    
    public static void applyTemplates$C(final String select, final Symbol mode, final Consumer out) throws Throwable {
        final CallContext ctx = CallContext.getInstance();
        final Consumer save = ctx.consumer;
        ctx.consumer = out;
        try {
            applyTemplates$X(select, mode, ctx);
        }
        finally {
            ctx.consumer = save;
        }
    }
    
    public static void applyTemplates$X(final String select, Symbol mode, final CallContext ctx) throws Throwable {
        if (mode == null) {
            mode = XSLT.nullMode;
        }
        final TemplateTable table = TemplateTable.getTemplateTable(mode);
        final Focus pos = Focus.getCurrent();
        final TreeList doc = (TreeList)pos.sequence;
        final Object cur = doc.getPosNext(pos.ipos);
        pos.push(doc, doc.firstChildPos(pos.ipos));
        XSLT.process(doc, pos, ctx);
        pos.pop();
    }
    
    @Override
    public void apply(final CallContext ctx) throws Throwable {
        applyTemplates$X((String)ctx.getNextArg(null), (Symbol)ctx.getNextArg(null), ctx);
    }
    
    @Override
    public void compileToNode(final ApplyExp exp, final Compilation comp, final ConsumerTarget target) {
        final CodeAttr code = comp.getCode();
        final Expression[] args = exp.getArgs();
        args[0].compile(comp, Target.pushObject);
        args[1].compile(comp, Target.pushObject);
        String mname;
        if (target.isContextTarget()) {
            comp.loadCallContext();
            mname = "applyTemplates$X";
        }
        else {
            code.emitLoad(target.getConsumerVariable());
            mname = "applyTemplates$C";
        }
        code.emitInvokeStatic(ClassType.make("gnu.kawa.xslt.ApplyTemplates").getDeclaredMethod(mname, 3));
    }
    
    static {
        applyTemplatesProc = new ApplyTemplates();
    }
}
