/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.xml;

import gnu.expr.ApplyExp;
import gnu.expr.Compilation;
import gnu.expr.ConsumerTarget;
import gnu.expr.Target;
import gnu.kawa.xml.KText;
import gnu.kawa.xml.NodeConstructor;
import gnu.lists.Consumer;
import gnu.mapping.CallContext;
import gnu.mapping.Values;
import gnu.xml.NodeTree;
import gnu.xml.TextUtils;
import gnu.xml.XMLFilter;

public class MakeText
extends NodeConstructor {
    public static final MakeText makeText = new MakeText();

    @Override
    public int numArgs() {
        return 4097;
    }

    @Override
    public Object apply1(Object arg) {
        if (arg == null || arg instanceof Values && ((Values)arg).isEmpty()) {
            return arg;
        }
        NodeTree node = new NodeTree();
        TextUtils.textValue(arg, new XMLFilter(node));
        return KText.make(node);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void text$X(Object arg, CallContext ctx) {
        if (arg == null || arg instanceof Values && ((Values)arg).isEmpty()) {
            return;
        }
        Consumer saved = ctx.consumer;
        XMLFilter out = NodeConstructor.pushNodeContext(ctx);
        try {
            TextUtils.textValue(arg, out);
        }
        finally {
            NodeConstructor.popNodeContext(saved, ctx);
        }
    }

    @Override
    public void apply(CallContext ctx) {
        MakeText.text$X(ctx.getNextArg(null), ctx);
    }

    @Override
    public void compile(ApplyExp exp, Compilation comp, Target target) {
        ApplyExp.compile(exp, comp, target);
    }

    @Override
    public void compileToNode(ApplyExp exp, Compilation comp, ConsumerTarget target) {
        throw new Error("MakeText.compileToNode called!");
    }
}

