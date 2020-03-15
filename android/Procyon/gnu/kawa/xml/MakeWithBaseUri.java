// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.xml;

import gnu.bytecode.CodeAttr;
import gnu.expr.Expression;
import gnu.bytecode.Variable;
import gnu.expr.Target;
import gnu.expr.ConsumerTarget;
import gnu.expr.Compilation;
import gnu.expr.ApplyExp;
import gnu.lists.Consumer;
import gnu.mapping.Values;
import gnu.lists.XConsumer;
import gnu.mapping.CallContext;
import gnu.bytecode.Method;
import gnu.bytecode.ClassType;

public class MakeWithBaseUri extends NodeConstructor
{
    public static final MakeWithBaseUri makeWithBaseUri;
    static final ClassType typeXConsumer;
    static final Method beginEntityMethod;
    static final Method endEntityMethod;
    
    @Override
    public int numArgs() {
        return 8194;
    }
    
    @Override
    public void apply(final CallContext ctx) {
        final Consumer saved = ctx.consumer;
        final Consumer out = NodeConstructor.pushNodeContext(ctx);
        final Object baseUri = ctx.getNextArg();
        final Object node = ctx.getNextArg();
        if (out instanceof XConsumer) {
            ((XConsumer)out).beginEntity(baseUri);
        }
        try {
            Values.writeValues(node, out);
        }
        finally {
            if (out instanceof XConsumer) {
                ((XConsumer)out).endEntity();
            }
            NodeConstructor.popNodeContext(saved, ctx);
        }
    }
    
    @Override
    public void compileToNode(final ApplyExp exp, final Compilation comp, final ConsumerTarget target) {
        final Variable consumer = target.getConsumerVariable();
        final Expression[] args = exp.getArgs();
        final int nargs = args.length;
        final CodeAttr code = comp.getCode();
        code.emitLoad(consumer);
        args[0].compile(comp, Target.pushObject);
        code.emitInvokeInterface(MakeWithBaseUri.beginEntityMethod);
        NodeConstructor.compileChild(args[1], this.stringIsText, comp, target);
        code.emitLoad(consumer);
        code.emitInvokeInterface(MakeWithBaseUri.endEntityMethod);
    }
    
    static {
        makeWithBaseUri = new MakeWithBaseUri();
        typeXConsumer = ClassType.make("gnu.lists.XConsumer");
        beginEntityMethod = MakeWithBaseUri.typeXConsumer.getDeclaredMethod("beginEntity", 1);
        endEntityMethod = MakeWithBaseUri.typeXConsumer.getDeclaredMethod("endEntity", 0);
    }
}
