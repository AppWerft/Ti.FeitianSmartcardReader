// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.xml;

import gnu.bytecode.CodeAttr;
import gnu.expr.Expression;
import gnu.bytecode.Variable;
import gnu.bytecode.Type;
import gnu.expr.CheckedTarget;
import gnu.expr.ConsumerTarget;
import gnu.expr.Compilation;
import gnu.expr.ApplyExp;
import gnu.expr.Special;
import gnu.mapping.CallContext;
import gnu.mapping.Symbol;
import gnu.lists.Consumer;
import gnu.bytecode.Method;
import gnu.bytecode.ClassType;
import gnu.expr.QuoteExp;

public class MakeAttribute extends NodeConstructor
{
    public static final MakeAttribute makeAttribute;
    public static final MakeAttribute makeAttributeS;
    public static final QuoteExp makeAttributeExp;
    static final ClassType typeMakeAttribute;
    static final Method startAttributeMethod;
    static final Method endAttributeMethod;
    
    @Override
    public int numArgs() {
        return -4095;
    }
    
    public static void startAttribute(final Consumer out, final Symbol type) {
        out.startAttribute(type);
    }
    
    @Override
    public void apply(final CallContext ctx) {
        final Consumer saved = ctx.consumer;
        final Consumer out = NodeConstructor.pushNodeContext(ctx);
        try {
            final Object type = ctx.getNextArg();
            startAttribute(out, (Symbol)type);
            final Object endMarker = Special.dfault;
            while (true) {
                final Object arg = ctx.getNextArg(endMarker);
                if (arg == endMarker) {
                    break;
                }
                if (this.stringIsText) {
                    NodeConstructor.writeContentS(arg, out);
                }
                else {
                    NodeConstructor.writeContent(arg, out);
                }
            }
            out.endAttribute();
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
        code.emitDup();
        args[0].compile(comp, CheckedTarget.getInstance(Compilation.typeSymbol));
        code.emitInvokeStatic(MakeAttribute.startAttributeMethod);
        for (int i = 1; i < nargs; ++i) {
            NodeConstructor.compileChild(args[i], this.stringIsText, comp, target);
        }
        code.emitInvokeInterface(MakeAttribute.endAttributeMethod);
    }
    
    @Override
    public Type getReturnType(final Expression[] args) {
        return Compilation.typeObject;
    }
    
    static {
        makeAttribute = new MakeAttribute();
        (makeAttributeS = new MakeAttribute()).setStringIsText(true);
        makeAttributeExp = new QuoteExp(MakeAttribute.makeAttribute);
        typeMakeAttribute = ClassType.make("gnu.kawa.xml.MakeAttribute");
        startAttributeMethod = MakeAttribute.typeMakeAttribute.getDeclaredMethod("startAttribute", 2);
        endAttributeMethod = Compilation.typeConsumer.getDeclaredMethod("endAttribute", 0);
    }
}
