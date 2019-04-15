/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.xml;

import gnu.bytecode.ClassType;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.Method;
import gnu.bytecode.Type;
import gnu.bytecode.Variable;
import gnu.expr.ApplyExp;
import gnu.expr.CheckedTarget;
import gnu.expr.Compilation;
import gnu.expr.ConsumerTarget;
import gnu.expr.Expression;
import gnu.expr.QuoteExp;
import gnu.expr.Special;
import gnu.expr.Target;
import gnu.kawa.xml.NodeConstructor;
import gnu.lists.Consumer;
import gnu.mapping.CallContext;
import gnu.mapping.Symbol;
import gnu.xml.XMLFilter;

public class MakeAttribute
extends NodeConstructor {
    public static final MakeAttribute makeAttribute = new MakeAttribute();
    public static final MakeAttribute makeAttributeS = new MakeAttribute();
    public static final QuoteExp makeAttributeExp;
    static final ClassType typeMakeAttribute;
    static final Method startAttributeMethod;
    static final Method endAttributeMethod;

    @Override
    public int numArgs() {
        return -4095;
    }

    public static void startAttribute(Consumer out, Symbol type) {
        out.startAttribute(type);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void apply(CallContext ctx) {
        Consumer saved = ctx.consumer;
        XMLFilter out = MakeAttribute.pushNodeContext(ctx);
        try {
            Object arg;
            Object type = ctx.getNextArg();
            MakeAttribute.startAttribute(out, (Symbol)type);
            Special endMarker = Special.dfault;
            while ((arg = ctx.getNextArg(endMarker)) != endMarker) {
                if (this.stringIsText) {
                    MakeAttribute.writeContentS(arg, out);
                    continue;
                }
                MakeAttribute.writeContent(arg, out);
            }
            out.endAttribute();
        }
        finally {
            MakeAttribute.popNodeContext(saved, ctx);
        }
    }

    @Override
    public void compileToNode(ApplyExp exp, Compilation comp, ConsumerTarget target) {
        Variable consumer = target.getConsumerVariable();
        Expression[] args = exp.getArgs();
        int nargs = args.length;
        CodeAttr code = comp.getCode();
        code.emitLoad(consumer);
        code.emitDup();
        args[0].compile(comp, CheckedTarget.getInstance(Compilation.typeSymbol));
        code.emitInvokeStatic(startAttributeMethod);
        for (int i = 1; i < nargs; ++i) {
            MakeAttribute.compileChild(args[i], this.stringIsText, comp, target);
        }
        code.emitInvokeInterface(endAttributeMethod);
    }

    @Override
    public Type getReturnType(Expression[] args) {
        return Compilation.typeObject;
    }

    static {
        makeAttributeS.setStringIsText(true);
        makeAttributeExp = new QuoteExp(makeAttribute);
        typeMakeAttribute = ClassType.make("gnu.kawa.xml.MakeAttribute");
        startAttributeMethod = typeMakeAttribute.getDeclaredMethod("startAttribute", 2);
        endAttributeMethod = Compilation.typeConsumer.getDeclaredMethod("endAttribute", 0);
    }
}

