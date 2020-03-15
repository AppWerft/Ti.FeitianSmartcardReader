// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.xml;

import gnu.bytecode.CodeAttr;
import gnu.bytecode.Variable;
import gnu.expr.Target;
import gnu.bytecode.Type;
import gnu.expr.CheckedTarget;
import gnu.expr.ConsumerTarget;
import gnu.expr.Compilation;
import gnu.expr.Special;
import gnu.mapping.CallContext;
import gnu.xml.XMLFilter;
import gnu.xml.XName;
import gnu.lists.Consumer;
import gnu.expr.Expression;
import gnu.expr.QuoteExp;
import gnu.expr.ApplyExp;
import gnu.bytecode.Method;
import gnu.bytecode.ClassType;
import gnu.xml.NamespaceBinding;
import gnu.mapping.Symbol;

public class MakeElement extends NodeConstructor
{
    public static final MakeElement makeElementS;
    public Symbol tag;
    public int copyNamespacesMode;
    private boolean handlingKeywordParameters;
    NamespaceBinding namespaceNodes;
    static final ClassType typeMakeElement;
    static final Method startElementMethod3;
    static final Method startElementMethod4;
    static final Method endElementMethod;
    
    public MakeElement() {
        this.copyNamespacesMode = 1;
    }
    
    @Override
    public int numArgs() {
        return (this.tag == null) ? -4095 : -4096;
    }
    
    @Override
    public String toString() {
        return "makeElement[" + this.tag + "]";
    }
    
    public boolean isHandlingKeywordParameters() {
        return this.handlingKeywordParameters;
    }
    
    public void setHandlingKeywordParameters(final boolean value) {
        this.handlingKeywordParameters = value;
    }
    
    public NamespaceBinding getNamespaceNodes() {
        return this.namespaceNodes;
    }
    
    public void setNamespaceNodes(final NamespaceBinding bindings) {
        this.namespaceNodes = bindings;
    }
    
    public static Symbol getTagName(final ApplyExp exp) {
        final Expression[] args = exp.getArgs();
        if (args.length > 0) {
            final Expression arg0 = args[0];
            if (arg0 instanceof QuoteExp) {
                final Object val = ((QuoteExp)arg0).getValue();
                if (val instanceof Symbol) {
                    return (Symbol)val;
                }
            }
        }
        return null;
    }
    
    public static void startElement(final Consumer out, final Symbol qname, final int copyNamespacesMode, final NamespaceBinding namespaceNodes) {
        final XName type = new XName(qname, namespaceNodes);
        if (out instanceof XMLFilter) {
            ((XMLFilter)out).copyNamespacesMode = copyNamespacesMode;
        }
        out.startElement(type);
    }
    
    public static void startElement(final Consumer out, final Symbol qname, final int copyNamespacesMode) {
        if (out instanceof XMLFilter) {
            ((XMLFilter)out).copyNamespacesMode = copyNamespacesMode;
        }
        out.startElement(qname);
    }
    
    public static void endElement(final Consumer out, final Object type) {
        out.endElement();
    }
    
    @Override
    public void apply(final CallContext ctx) {
        final Consumer saved = ctx.consumer;
        final Consumer out = NodeConstructor.pushNodeContext(ctx);
        try {
            final Symbol type = (Symbol)((this.tag != null) ? this.tag : ctx.getNextArg());
            if (this.namespaceNodes != null) {
                startElement(out, type, this.copyNamespacesMode, this.namespaceNodes);
            }
            else {
                startElement(out, type, this.copyNamespacesMode);
            }
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
                if (!this.isHandlingKeywordParameters()) {
                    continue;
                }
                out.endAttribute();
            }
            endElement(out, type);
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
        final Target tagTarget = CheckedTarget.getInstance(Compilation.typeSymbol);
        int i;
        if (this.tag == null) {
            args[0].compile(comp, tagTarget);
            i = 1;
        }
        else {
            comp.compileConstant(this.tag, tagTarget);
            i = 0;
        }
        code.emitDup(1, 1);
        code.emitPushInt(this.copyNamespacesMode);
        if (this.namespaceNodes != null) {
            comp.compileConstant(this.namespaceNodes, Target.pushObject);
            code.emitInvokeStatic(MakeElement.startElementMethod4);
        }
        else {
            code.emitInvokeStatic(MakeElement.startElementMethod3);
        }
        while (i < nargs) {
            NodeConstructor.compileChild(args[i], this.stringIsText, comp, target);
            if (this.isHandlingKeywordParameters()) {
                code.emitLoad(consumer);
                code.emitInvokeInterface(MakeAttribute.endAttributeMethod);
            }
            ++i;
        }
        code.emitInvokeStatic(MakeElement.endElementMethod);
    }
    
    @Override
    public Type getReturnType(final Expression[] args) {
        return Compilation.typeObject;
    }
    
    static {
        (makeElementS = new MakeElement()).setStringIsText(true);
        typeMakeElement = ClassType.make("gnu.kawa.xml.MakeElement");
        startElementMethod3 = MakeElement.typeMakeElement.getDeclaredMethod("startElement", 3);
        startElementMethod4 = MakeElement.typeMakeElement.getDeclaredMethod("startElement", 4);
        endElementMethod = MakeElement.typeMakeElement.getDeclaredMethod("endElement", 2);
    }
}
