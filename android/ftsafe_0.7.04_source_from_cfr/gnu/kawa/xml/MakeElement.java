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
import gnu.kawa.xml.MakeAttribute;
import gnu.kawa.xml.NodeConstructor;
import gnu.lists.Consumer;
import gnu.mapping.CallContext;
import gnu.mapping.Symbol;
import gnu.xml.NamespaceBinding;
import gnu.xml.XMLFilter;
import gnu.xml.XName;

public class MakeElement
extends NodeConstructor {
    public static final MakeElement makeElementS = new MakeElement();
    public Symbol tag;
    public int copyNamespacesMode = 1;
    private boolean handlingKeywordParameters;
    NamespaceBinding namespaceNodes;
    static final ClassType typeMakeElement;
    static final Method startElementMethod3;
    static final Method startElementMethod4;
    static final Method endElementMethod;

    @Override
    public int numArgs() {
        return this.tag == null ? -4095 : -4096;
    }

    @Override
    public String toString() {
        return "makeElement[" + this.tag + "]";
    }

    public boolean isHandlingKeywordParameters() {
        return this.handlingKeywordParameters;
    }

    public void setHandlingKeywordParameters(boolean value) {
        this.handlingKeywordParameters = value;
    }

    public NamespaceBinding getNamespaceNodes() {
        return this.namespaceNodes;
    }

    public void setNamespaceNodes(NamespaceBinding bindings) {
        this.namespaceNodes = bindings;
    }

    public static Symbol getTagName(ApplyExp exp) {
        Object val;
        Expression arg0;
        Expression[] args = exp.getArgs();
        if (args.length > 0 && (arg0 = args[0]) instanceof QuoteExp && (val = ((QuoteExp)arg0).getValue()) instanceof Symbol) {
            return (Symbol)val;
        }
        return null;
    }

    public static void startElement(Consumer out, Symbol qname, int copyNamespacesMode, NamespaceBinding namespaceNodes) {
        XName type = new XName(qname, namespaceNodes);
        if (out instanceof XMLFilter) {
            ((XMLFilter)out).copyNamespacesMode = copyNamespacesMode;
        }
        out.startElement(type);
    }

    public static void startElement(Consumer out, Symbol qname, int copyNamespacesMode) {
        if (out instanceof XMLFilter) {
            ((XMLFilter)out).copyNamespacesMode = copyNamespacesMode;
        }
        out.startElement(qname);
    }

    public static void endElement(Consumer out, Object type) {
        out.endElement();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void apply(CallContext ctx) {
        Consumer saved = ctx.consumer;
        XMLFilter out = MakeElement.pushNodeContext(ctx);
        try {
            Symbol type;
            Object arg;
            Symbol symbol = type = this.tag != null ? this.tag : (Symbol)ctx.getNextArg();
            if (this.namespaceNodes != null) {
                MakeElement.startElement(out, type, this.copyNamespacesMode, this.namespaceNodes);
            } else {
                MakeElement.startElement(out, type, this.copyNamespacesMode);
            }
            Special endMarker = Special.dfault;
            while ((arg = ctx.getNextArg(endMarker)) != endMarker) {
                if (this.stringIsText) {
                    MakeElement.writeContentS(arg, out);
                } else {
                    MakeElement.writeContent(arg, out);
                }
                if (!this.isHandlingKeywordParameters()) continue;
                out.endAttribute();
            }
            MakeElement.endElement(out, type);
        }
        finally {
            MakeElement.popNodeContext(saved, ctx);
        }
    }

    @Override
    public void compileToNode(ApplyExp exp, Compilation comp, ConsumerTarget target) {
        int i;
        Variable consumer = target.getConsumerVariable();
        Expression[] args = exp.getArgs();
        int nargs = args.length;
        CodeAttr code = comp.getCode();
        code.emitLoad(consumer);
        code.emitDup();
        Target tagTarget = CheckedTarget.getInstance(Compilation.typeSymbol);
        if (this.tag == null) {
            args[0].compile(comp, tagTarget);
            i = 1;
        } else {
            comp.compileConstant(this.tag, tagTarget);
            i = 0;
        }
        code.emitDup(1, 1);
        code.emitPushInt(this.copyNamespacesMode);
        if (this.namespaceNodes != null) {
            comp.compileConstant(this.namespaceNodes, Target.pushObject);
            code.emitInvokeStatic(startElementMethod4);
        } else {
            code.emitInvokeStatic(startElementMethod3);
        }
        while (i < nargs) {
            MakeElement.compileChild(args[i], this.stringIsText, comp, target);
            if (this.isHandlingKeywordParameters()) {
                code.emitLoad(consumer);
                code.emitInvokeInterface(MakeAttribute.endAttributeMethod);
            }
            ++i;
        }
        code.emitInvokeStatic(endElementMethod);
    }

    @Override
    public Type getReturnType(Expression[] args) {
        return Compilation.typeObject;
    }

    static {
        makeElementS.setStringIsText(true);
        typeMakeElement = ClassType.make("gnu.kawa.xml.MakeElement");
        startElementMethod3 = typeMakeElement.getDeclaredMethod("startElement", 3);
        startElementMethod4 = typeMakeElement.getDeclaredMethod("startElement", 4);
        endElementMethod = typeMakeElement.getDeclaredMethod("endElement", 2);
    }
}

