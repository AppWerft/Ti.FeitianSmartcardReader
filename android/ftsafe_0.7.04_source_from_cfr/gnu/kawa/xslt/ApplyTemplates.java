/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.xslt;

import gnu.bytecode.ClassType;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.Method;
import gnu.bytecode.Variable;
import gnu.expr.ApplyExp;
import gnu.expr.Compilation;
import gnu.expr.ConsumerTarget;
import gnu.expr.Expression;
import gnu.expr.Target;
import gnu.kawa.xml.Focus;
import gnu.kawa.xml.NodeConstructor;
import gnu.kawa.xslt.TemplateTable;
import gnu.kawa.xslt.XSLT;
import gnu.lists.AbstractSequence;
import gnu.lists.Consumer;
import gnu.lists.TreeList;
import gnu.mapping.CallContext;
import gnu.mapping.Symbol;

public class ApplyTemplates
extends NodeConstructor {
    public static final ApplyTemplates applyTemplatesProc = new ApplyTemplates();

    @Override
    public int numArgs() {
        return 8194;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void applyTemplates$C(String select, Symbol mode, Consumer out) throws Throwable {
        CallContext ctx = CallContext.getInstance();
        Consumer save = ctx.consumer;
        ctx.consumer = out;
        try {
            ApplyTemplates.applyTemplates$X(select, mode, ctx);
        }
        finally {
            ctx.consumer = save;
        }
    }

    public static void applyTemplates$X(String select, Symbol mode, CallContext ctx) throws Throwable {
        if (mode == null) {
            mode = XSLT.nullMode;
        }
        TemplateTable table = TemplateTable.getTemplateTable(mode);
        Focus pos = Focus.getCurrent();
        TreeList doc = (TreeList)pos.sequence;
        Object cur = doc.getPosNext(pos.ipos);
        pos.push(doc, doc.firstChildPos(pos.ipos));
        XSLT.process(doc, pos, ctx);
        pos.pop();
    }

    @Override
    public void apply(CallContext ctx) throws Throwable {
        ApplyTemplates.applyTemplates$X((String)ctx.getNextArg(null), (Symbol)ctx.getNextArg(null), ctx);
    }

    @Override
    public void compileToNode(ApplyExp exp, Compilation comp, ConsumerTarget target) {
        String mname;
        CodeAttr code = comp.getCode();
        Expression[] args = exp.getArgs();
        args[0].compile(comp, Target.pushObject);
        args[1].compile(comp, Target.pushObject);
        if (target.isContextTarget()) {
            comp.loadCallContext();
            mname = "applyTemplates$X";
        } else {
            code.emitLoad(target.getConsumerVariable());
            mname = "applyTemplates$C";
        }
        code.emitInvokeStatic(ClassType.make("gnu.kawa.xslt.ApplyTemplates").getDeclaredMethod(mname, 3));
    }
}

