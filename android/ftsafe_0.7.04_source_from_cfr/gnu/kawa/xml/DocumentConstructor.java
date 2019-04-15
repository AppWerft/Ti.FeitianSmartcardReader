/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.xml;

import gnu.bytecode.ClassType;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.Method;
import gnu.bytecode.Variable;
import gnu.expr.ApplyExp;
import gnu.expr.Compilation;
import gnu.expr.ConsumerTarget;
import gnu.expr.Expression;
import gnu.kawa.xml.NodeConstructor;
import gnu.lists.Consumable;
import gnu.lists.Consumer;
import gnu.mapping.CallContext;
import gnu.mapping.Location;
import gnu.xml.XMLFilter;

public class DocumentConstructor
extends NodeConstructor {
    public static final DocumentConstructor documentConstructor = new DocumentConstructor();
    static final Method startDocumentMethod = Compilation.typeConsumer.getDeclaredMethod("startDocument", 0);
    static final Method endDocumentMethod = Compilation.typeConsumer.getDeclaredMethod("endDocument", 0);

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void apply(CallContext ctx) {
        Consumer saved = ctx.consumer;
        XMLFilter out = DocumentConstructor.pushNodeContext(ctx);
        try {
            Object arg;
            String endMarker = Location.UNBOUND;
            out.startDocument();
            while ((arg = ctx.getNextArg(endMarker)) != endMarker) {
                if (arg instanceof Consumable) {
                    ((Consumable)arg).consume(out);
                    continue;
                }
                out.writeObject(arg);
            }
            out.endDocument();
        }
        finally {
            DocumentConstructor.popNodeContext(saved, ctx);
        }
    }

    @Override
    public void compileToNode(ApplyExp exp, Compilation comp, ConsumerTarget target) {
        Variable consumer = target.getConsumerVariable();
        Expression[] args = exp.getArgs();
        int nargs = args.length;
        CodeAttr code = comp.getCode();
        code.emitLoad(consumer);
        code.emitInvokeInterface(startDocumentMethod);
        for (int i = 0; i < nargs; ++i) {
            DocumentConstructor.compileChild(args[i], this.stringIsText, comp, target);
        }
        code.emitLoad(consumer);
        code.emitInvokeInterface(endDocumentMethod);
    }
}

