// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.xml;

import gnu.expr.Expression;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.ClassType;
import gnu.expr.Target;
import gnu.expr.ConsumerTarget;
import gnu.expr.Compilation;
import gnu.expr.ApplyExp;
import gnu.mapping.CallContext;
import gnu.xml.TextUtils;
import gnu.mapping.Values;
import gnu.lists.XConsumer;
import gnu.lists.Consumer;

public class MakeProcInst extends NodeConstructor
{
    public static final MakeProcInst makeProcInst;
    
    @Override
    public int numArgs() {
        return 8194;
    }
    
    public static void procInst$C(Object target, final Object content, final Consumer out) {
        target = KNode.atomicValue(target);
        if (!(target instanceof String) && !(target instanceof UntypedAtomic)) {
            throw new ClassCastException("invalid type of processing-instruction target [XPTY0004]");
        }
        if (!(out instanceof XConsumer)) {
            return;
        }
        final StringBuffer sbuf = new StringBuffer();
        if (content instanceof Values) {
            final Object[] vals = ((Values)content).getValues();
            for (int i = 0; i < vals.length; ++i) {
                if (i > 0) {
                    sbuf.append(' ');
                }
                TextUtils.stringValue(vals[i], sbuf);
            }
        }
        else {
            TextUtils.stringValue(content, sbuf);
        }
        int length;
        int start;
        for (length = sbuf.length(), start = 0; start < length && Character.isWhitespace(sbuf.charAt(start)); ++start) {}
        final char[] chars = new char[length - start];
        sbuf.getChars(start, length, chars, 0);
        ((XConsumer)out).writeProcessingInstruction(target.toString(), chars, 0, chars.length);
    }
    
    public static void procInst$X(final Object target, final Object content, final CallContext ctx) {
        final Consumer saved = ctx.consumer;
        final Consumer out = NodeConstructor.pushNodeContext(ctx);
        try {
            procInst$C(target, content, out);
        }
        finally {
            NodeConstructor.popNodeContext(saved, ctx);
        }
    }
    
    @Override
    public void apply(final CallContext ctx) {
        procInst$X(ctx.getNextArg(null), ctx.getNextArg(null), ctx);
    }
    
    @Override
    public void compileToNode(final ApplyExp exp, final Compilation comp, final ConsumerTarget target) {
        final CodeAttr code = comp.getCode();
        final Expression[] args = exp.getArgs();
        args[0].compile(comp, Target.pushObject);
        args[1].compile(comp, Target.pushObject);
        code.emitLoad(target.getConsumerVariable());
        code.emitInvokeStatic(ClassType.make("gnu.kawa.xml.MakeProcInst").getDeclaredMethod("procInst$C", 3));
    }
    
    static {
        makeProcInst = new MakeProcInst();
    }
}
