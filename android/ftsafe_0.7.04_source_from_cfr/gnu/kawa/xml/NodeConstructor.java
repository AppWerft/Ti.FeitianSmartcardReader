/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.xml;

import gnu.bytecode.ClassType;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.Method;
import gnu.bytecode.PrimType;
import gnu.bytecode.Scope;
import gnu.bytecode.Type;
import gnu.bytecode.Variable;
import gnu.expr.ApplyExp;
import gnu.expr.Compilation;
import gnu.expr.ConsumerTarget;
import gnu.expr.Expression;
import gnu.expr.IgnoreTarget;
import gnu.expr.Inlineable;
import gnu.expr.QuoteExp;
import gnu.expr.Target;
import gnu.kawa.xml.KNode;
import gnu.kawa.xml.MakeText;
import gnu.lists.Consumable;
import gnu.lists.Consumer;
import gnu.lists.FString;
import gnu.lists.UnescapedData;
import gnu.mapping.CallContext;
import gnu.mapping.MethodProc;
import gnu.mapping.Values;
import gnu.xml.NodeTree;
import gnu.xml.XMLFilter;
import java.util.List;

public abstract class NodeConstructor
extends MethodProc
implements Inlineable {
    protected boolean stringIsText;
    static final ClassType typeXMLFilter = ClassType.make("gnu.xml.XMLFilter");
    static final ClassType typeKNode = ClassType.make("gnu.kawa.xml.KNode");
    static final ClassType typeNodeConstructor = ClassType.make("gnu.kawa.xml.NodeConstructor");
    static final Method pushNodeContextMethod = typeNodeConstructor.getDeclaredMethod("pushNodeContext", 1);
    static final Method popNodeContextMethod = typeNodeConstructor.getDeclaredMethod("popNodeContext", 2);
    static final Method pushNodeConsumerMethod = typeNodeConstructor.getDeclaredMethod("pushNodeConsumer", 1);
    static final Method popNodeConsumerMethod = typeNodeConstructor.getDeclaredMethod("popNodeConsumer", 2);

    public abstract void compileToNode(ApplyExp var1, Compilation var2, ConsumerTarget var3);

    public void setStringIsText(boolean stringIsText) {
        this.stringIsText = stringIsText;
    }

    public static XMLFilter pushNodeConsumer(Consumer out) {
        if (out instanceof XMLFilter) {
            return (XMLFilter)out;
        }
        return new XMLFilter(new NodeTree());
    }

    public static void popNodeConsumer(Consumer saved, Consumer current) {
        if (saved != current) {
            saved.writeObject(current instanceof XMLFilter ? KNode.make((NodeTree)((XMLFilter)current).out) : current);
        }
    }

    public static XMLFilter pushNodeContext(CallContext ctx) {
        Consumer out = ctx.consumer;
        if (out instanceof XMLFilter) {
            return (XMLFilter)out;
        }
        XMLFilter filter = new XMLFilter(new NodeTree());
        ctx.consumer = filter;
        return filter;
    }

    public static void popNodeContext(Consumer saved, CallContext ctx) {
        Object current = ctx.consumer;
        if (saved != current) {
            if (current instanceof XMLFilter) {
                current = KNode.make((NodeTree)((XMLFilter)current).out);
            }
            saved.writeObject(current);
            ctx.consumer = saved;
        }
    }

    public static void compileChild(Expression arg, boolean stringIsText, Compilation comp, ConsumerTarget target) {
        Expression func;
        Object value;
        ApplyExp app;
        Object proc;
        if (arg instanceof ApplyExp && (proc = (func = (app = (ApplyExp)arg).getFunction()).valueIfConstant()) instanceof NodeConstructor && !(proc instanceof MakeText)) {
            ((NodeConstructor)proc).compileToNode(app, comp, target);
            return;
        }
        CodeAttr code = comp.getCode();
        if (arg instanceof QuoteExp && (value = ((QuoteExp)arg).getValue()) instanceof FString) {
            code.emitLoad(target.getConsumerVariable());
            code.emitPushString(value.toString());
            code.emitInvoke(Compilation.typeConsumer.getDeclaredMethod("write", new Type[]{Type.javalangStringType}));
            return;
        }
        arg.compileWithPosition(comp, Target.pushObject);
        code.emitLoad(target.getConsumerVariable());
        code.emitInvokeStatic(ClassType.make("gnu.kawa.xml.NodeConstructor").getDeclaredMethod(stringIsText ? "writeContentS" : "writeContent", 2));
    }

    public static void compileUsingNodeTree(Expression exp, Compilation comp, Target target) {
        Method makeMethod = typeNodeConstructor.getDeclaredMethod("makeNode", 0);
        Method makeKNodeMethod = typeNodeConstructor.getDeclaredMethod("finishNode", 1);
        ConsumerTarget.compileUsingConsumer(exp, comp, target, makeMethod, makeKNodeMethod);
    }

    public static XMLFilter makeNode() {
        return new XMLFilter(new NodeTree());
    }

    public static KNode finishNode(XMLFilter filter) {
        return KNode.make((NodeTree)filter.out);
    }

    @Override
    public void compile(ApplyExp exp, Compilation comp, Target target) {
        if (target instanceof IgnoreTarget) {
            ApplyExp.compile(exp, comp, target);
        } else if (!(target instanceof ConsumerTarget)) {
            NodeConstructor.compileUsingNodeTree(exp, comp, target);
        } else {
            ConsumerTarget ctarget = (ConsumerTarget)target;
            Variable cvar = ctarget.getConsumerVariable();
            Type ctype = cvar.getType();
            if (ctype.isSubtype(typeXMLFilter)) {
                this.compileToNode(exp, comp, ctarget);
            } else {
                Expression[] args = exp.getArgs();
                int nargs = args.length;
                CodeAttr code = comp.getCode();
                Scope scope = code.pushScope();
                Variable xvar = scope.addVariable(code, typeXMLFilter, null);
                if (ctarget.isContextTarget()) {
                    comp.loadCallContext();
                    code.emitInvokeStatic(pushNodeContextMethod);
                } else {
                    code.emitLoad(cvar);
                    code.emitInvokeStatic(pushNodeConsumerMethod);
                }
                code.emitStore(xvar);
                code.emitTryStart(true, Type.void_type);
                ConsumerTarget xtarget = new ConsumerTarget(xvar);
                this.compileToNode(exp, comp, xtarget);
                code.emitFinallyStart();
                code.emitLoad(cvar);
                if (ctarget.isContextTarget()) {
                    comp.loadCallContext();
                    code.emitInvokeStatic(popNodeContextMethod);
                } else {
                    code.emitLoad(xvar);
                    code.emitInvokeStatic(popNodeConsumerMethod);
                }
                code.emitFinallyEnd();
                code.emitTryCatchEnd();
                code.popScope();
            }
        }
    }

    @Override
    public Type getReturnType(Expression[] args) {
        return Compilation.typeObject;
    }

    public static void writeContentS(Object arg, Consumer out) {
        if (arg instanceof CharSequence && !(arg instanceof UnescapedData)) {
            CharSequence carg = (CharSequence)arg;
            out.write(carg, 0, carg.length());
        } else {
            NodeConstructor.writeContent(arg, out);
        }
    }

    public static void writeContent(Object arg, Consumer out) {
        if (arg instanceof List && !(arg instanceof CharSequence)) {
            for (E e : (List)arg) {
                NodeConstructor.writeContent1(e, out);
            }
        } else {
            NodeConstructor.writeContent1(arg, out);
        }
    }

    protected static void writeContent1(Object arg, Consumer out) {
        if (arg instanceof Consumable) {
            ((Consumable)arg).consume(out);
        } else {
            Values.writeValues(arg, out);
        }
    }
}

