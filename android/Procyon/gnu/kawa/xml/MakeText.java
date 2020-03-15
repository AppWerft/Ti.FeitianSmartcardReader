// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.xml;

import gnu.expr.ConsumerTarget;
import gnu.expr.Target;
import gnu.expr.Compilation;
import gnu.expr.ApplyExp;
import gnu.mapping.CallContext;
import gnu.xml.TextUtils;
import gnu.lists.Consumer;
import gnu.xml.XMLFilter;
import gnu.xml.NodeTree;
import gnu.mapping.Values;

public class MakeText extends NodeConstructor
{
    public static final MakeText makeText;
    
    @Override
    public int numArgs() {
        return 4097;
    }
    
    @Override
    public Object apply1(final Object arg) {
        if (arg == null || (arg instanceof Values && ((Values)arg).isEmpty())) {
            return arg;
        }
        final NodeTree node = new NodeTree();
        TextUtils.textValue(arg, new XMLFilter(node));
        return KNode.make(node);
    }
    
    public static void text$X(final Object arg, final CallContext ctx) {
        if (arg == null || (arg instanceof Values && ((Values)arg).isEmpty())) {
            return;
        }
        final Consumer saved = ctx.consumer;
        final Consumer out = NodeConstructor.pushNodeContext(ctx);
        try {
            TextUtils.textValue(arg, out);
        }
        finally {
            NodeConstructor.popNodeContext(saved, ctx);
        }
    }
    
    @Override
    public void apply(final CallContext ctx) {
        text$X(ctx.getNextArg(null), ctx);
    }
    
    @Override
    public void compile(final ApplyExp exp, final Compilation comp, final Target target) {
        ApplyExp.compile(exp, comp, target);
    }
    
    @Override
    public void compileToNode(final ApplyExp exp, final Compilation comp, final ConsumerTarget target) {
        throw new Error("MakeText.compileToNode called!");
    }
    
    static {
        makeText = new MakeText();
    }
}
