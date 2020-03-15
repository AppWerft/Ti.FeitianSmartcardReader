// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.xml;

import gnu.mapping.Values;
import gnu.lists.Consumable;
import java.util.Iterator;
import java.util.List;
import gnu.lists.UnescapedData;
import gnu.bytecode.Scope;
import gnu.bytecode.Variable;
import gnu.expr.IgnoreTarget;
import gnu.bytecode.CodeAttr;
import gnu.expr.Target;
import gnu.bytecode.Type;
import gnu.lists.FString;
import gnu.expr.QuoteExp;
import gnu.expr.Expression;
import gnu.mapping.CallContext;
import gnu.xml.NodeTree;
import gnu.xml.XMLFilter;
import gnu.lists.Consumer;
import gnu.expr.ConsumerTarget;
import gnu.expr.Compilation;
import gnu.expr.ApplyExp;
import gnu.bytecode.Method;
import gnu.bytecode.ClassType;
import gnu.expr.Inlineable;
import gnu.mapping.MethodProc;

public abstract class NodeConstructor extends MethodProc implements Inlineable
{
    protected boolean stringIsText;
    static final ClassType typeXMLFilter;
    static final ClassType typeKNode;
    static final ClassType typeNodeConstructor;
    static final Method pushNodeContextMethod;
    static final Method popNodeContextMethod;
    static final Method pushNodeConsumerMethod;
    static final Method popNodeConsumerMethod;
    
    public abstract void compileToNode(final ApplyExp p0, final Compilation p1, final ConsumerTarget p2);
    
    public void setStringIsText(final boolean stringIsText) {
        this.stringIsText = stringIsText;
    }
    
    public static XMLFilter pushNodeConsumer(final Consumer out) {
        if (out instanceof XMLFilter) {
            return (XMLFilter)out;
        }
        return new XMLFilter(new NodeTree());
    }
    
    public static void popNodeConsumer(final Consumer saved, final Consumer current) {
        if (saved != current) {
            saved.writeObject((current instanceof XMLFilter) ? KNode.make((NodeTree)((XMLFilter)current).out) : current);
        }
    }
    
    public static XMLFilter pushNodeContext(final CallContext ctx) {
        final Consumer out = ctx.consumer;
        if (out instanceof XMLFilter) {
            return (XMLFilter)out;
        }
        final XMLFilter filter = new XMLFilter(new NodeTree());
        return (XMLFilter)(ctx.consumer = filter);
    }
    
    public static void popNodeContext(final Consumer saved, final CallContext ctx) {
        Object current = ctx.consumer;
        if (saved != current) {
            if (current instanceof XMLFilter) {
                current = KNode.make((NodeTree)((XMLFilter)current).out);
            }
            saved.writeObject(current);
            ctx.consumer = saved;
        }
    }
    
    public static void compileChild(final Expression arg, final boolean stringIsText, final Compilation comp, final ConsumerTarget target) {
        if (arg instanceof ApplyExp) {
            final ApplyExp app = (ApplyExp)arg;
            final Expression func = app.getFunction();
            final Object proc = func.valueIfConstant();
            if (proc instanceof NodeConstructor && !(proc instanceof MakeText)) {
                ((NodeConstructor)proc).compileToNode(app, comp, target);
                return;
            }
        }
        final CodeAttr code = comp.getCode();
        if (arg instanceof QuoteExp) {
            final Object value = ((QuoteExp)arg).getValue();
            if (value instanceof FString) {
                code.emitLoad(target.getConsumerVariable());
                code.emitPushString(value.toString());
                code.emitInvoke(Compilation.typeConsumer.getDeclaredMethod("write", new Type[] { Type.javalangStringType }));
                return;
            }
        }
        arg.compileWithPosition(comp, Target.pushObject);
        code.emitLoad(target.getConsumerVariable());
        code.emitInvokeStatic(ClassType.make("gnu.kawa.xml.NodeConstructor").getDeclaredMethod(stringIsText ? "writeContentS" : "writeContent", 2));
    }
    
    public static void compileUsingNodeTree(final Expression exp, final Compilation comp, final Target target) {
        final Method makeMethod = NodeConstructor.typeNodeConstructor.getDeclaredMethod("makeNode", 0);
        final Method makeKNodeMethod = NodeConstructor.typeNodeConstructor.getDeclaredMethod("finishNode", 1);
        ConsumerTarget.compileUsingConsumer(exp, comp, target, makeMethod, makeKNodeMethod);
    }
    
    public static XMLFilter makeNode() {
        return new XMLFilter(new NodeTree());
    }
    
    public static KNode finishNode(final XMLFilter filter) {
        return KNode.make((NodeTree)filter.out);
    }
    
    @Override
    public void compile(final ApplyExp exp, final Compilation comp, final Target target) {
        if (target instanceof IgnoreTarget) {
            ApplyExp.compile(exp, comp, target);
        }
        else if (!(target instanceof ConsumerTarget)) {
            compileUsingNodeTree(exp, comp, target);
        }
        else {
            final ConsumerTarget ctarget = (ConsumerTarget)target;
            final Variable cvar = ctarget.getConsumerVariable();
            final Type ctype = cvar.getType();
            if (ctype.isSubtype(NodeConstructor.typeXMLFilter)) {
                this.compileToNode(exp, comp, ctarget);
            }
            else {
                final Expression[] args = exp.getArgs();
                final int nargs = args.length;
                final CodeAttr code = comp.getCode();
                final Scope scope = code.pushScope();
                final Variable xvar = scope.addVariable(code, NodeConstructor.typeXMLFilter, null);
                if (ctarget.isContextTarget()) {
                    comp.loadCallContext();
                    code.emitInvokeStatic(NodeConstructor.pushNodeContextMethod);
                }
                else {
                    code.emitLoad(cvar);
                    code.emitInvokeStatic(NodeConstructor.pushNodeConsumerMethod);
                }
                code.emitStore(xvar);
                code.emitTryStart(true, Type.void_type);
                final ConsumerTarget xtarget = new ConsumerTarget(xvar);
                this.compileToNode(exp, comp, xtarget);
                code.emitFinallyStart();
                code.emitLoad(cvar);
                if (ctarget.isContextTarget()) {
                    comp.loadCallContext();
                    code.emitInvokeStatic(NodeConstructor.popNodeContextMethod);
                }
                else {
                    code.emitLoad(xvar);
                    code.emitInvokeStatic(NodeConstructor.popNodeConsumerMethod);
                }
                code.emitFinallyEnd();
                code.emitTryCatchEnd();
                code.popScope();
            }
        }
    }
    
    @Override
    public Type getReturnType(final Expression[] args) {
        return Compilation.typeObject;
    }
    
    public static void writeContentS(final Object arg, final Consumer out) {
        if (arg instanceof CharSequence && !(arg instanceof UnescapedData)) {
            final CharSequence carg = (CharSequence)arg;
            out.write(carg, 0, carg.length());
        }
        else {
            writeContent(arg, out);
        }
    }
    
    public static void writeContent(final Object arg, final Consumer out) {
        if (arg instanceof List && !(arg instanceof CharSequence)) {
            for (final Object e : (List)arg) {
                writeContent1(e, out);
            }
        }
        else {
            writeContent1(arg, out);
        }
    }
    
    protected static void writeContent1(final Object arg, final Consumer out) {
        if (arg instanceof Consumable) {
            ((Consumable)arg).consume(out);
        }
        else {
            Values.writeValues(arg, out);
        }
    }
    
    static {
        typeXMLFilter = ClassType.make("gnu.xml.XMLFilter");
        typeKNode = ClassType.make("gnu.kawa.xml.KNode");
        typeNodeConstructor = ClassType.make("gnu.kawa.xml.NodeConstructor");
        pushNodeContextMethod = NodeConstructor.typeNodeConstructor.getDeclaredMethod("pushNodeContext", 1);
        popNodeContextMethod = NodeConstructor.typeNodeConstructor.getDeclaredMethod("popNodeContext", 2);
        pushNodeConsumerMethod = NodeConstructor.typeNodeConstructor.getDeclaredMethod("pushNodeConsumer", 1);
        popNodeConsumerMethod = NodeConstructor.typeNodeConstructor.getDeclaredMethod("popNodeConsumer", 2);
    }
}
