// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.xml;

import gnu.bytecode.CodeAttr;
import gnu.expr.Expression;
import gnu.bytecode.Variable;
import gnu.expr.ConsumerTarget;
import gnu.expr.Compilation;
import gnu.expr.ApplyExp;
import gnu.lists.Consumer;
import gnu.lists.Consumable;
import gnu.mapping.Location;
import gnu.mapping.CallContext;
import gnu.bytecode.Method;

public class DocumentConstructor extends NodeConstructor
{
    public static final DocumentConstructor documentConstructor;
    static final Method startDocumentMethod;
    static final Method endDocumentMethod;
    
    @Override
    public void apply(final CallContext ctx) {
        final Consumer saved = ctx.consumer;
        final Consumer out = NodeConstructor.pushNodeContext(ctx);
        try {
            final Object endMarker = Location.UNBOUND;
            out.startDocument();
            while (true) {
                final Object arg = ctx.getNextArg(endMarker);
                if (arg == endMarker) {
                    break;
                }
                if (arg instanceof Consumable) {
                    ((Consumable)arg).consume(out);
                }
                else {
                    out.writeObject(arg);
                }
            }
            out.endDocument();
        }
        finally {
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
        code.emitInvokeInterface(DocumentConstructor.startDocumentMethod);
        for (int i = 0; i < nargs; ++i) {
            NodeConstructor.compileChild(args[i], this.stringIsText, comp, target);
        }
        code.emitLoad(consumer);
        code.emitInvokeInterface(DocumentConstructor.endDocumentMethod);
    }
    
    static {
        documentConstructor = new DocumentConstructor();
        startDocumentMethod = Compilation.typeConsumer.getDeclaredMethod("startDocument", 0);
        endDocumentMethod = Compilation.typeConsumer.getDeclaredMethod("endDocument", 0);
    }
}
