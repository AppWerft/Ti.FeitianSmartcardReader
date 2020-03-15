// 
// Decompiled by Procyon v0.5.36
// 

package gnu.xquery.util;

import gnu.expr.QuoteExp;
import gnu.bytecode.Variable;
import gnu.bytecode.Scope;
import gnu.bytecode.CodeAttr;
import gnu.kawa.xml.TreeScanner;
import gnu.bytecode.Method;
import gnu.kawa.functions.ValuesMap;
import gnu.expr.LambdaExp;
import gnu.bytecode.ClassType;
import gnu.expr.Expression;
import gnu.expr.ConsumerTarget;
import gnu.kawa.xml.NodeSetType;
import gnu.kawa.xml.SelfAxis;
import gnu.kawa.xml.AttributeAxis;
import gnu.kawa.xml.ChildAxis;
import gnu.kawa.xml.NodeType;
import gnu.kawa.reflect.OccurrenceType;
import gnu.bytecode.Type;
import gnu.expr.IgnoreTarget;
import gnu.expr.Target;
import gnu.expr.Compilation;
import gnu.expr.ApplyExp;
import gnu.math.IntNum;
import gnu.lists.Consumer;
import gnu.mapping.Values;
import gnu.kawa.xml.Nodes;
import gnu.mapping.CallContext;
import gnu.mapping.Procedure;
import gnu.expr.Inlineable;
import gnu.mapping.MethodProc;

public class RelativeStep extends MethodProc implements Inlineable
{
    public static final RelativeStep relativeStep;
    
    RelativeStep() {
        this.setProperty(Procedure.validateApplyKey, "gnu.xquery.util.CompileMisc:validateApplyRelativeStep");
    }
    
    @Override
    public int numArgs() {
        return 8194;
    }
    
    @Override
    public void apply(final CallContext ctx) throws Throwable {
        final Object arg = ctx.getNextArg();
        final Object next = ctx.getNextArg();
        final Procedure proc = (Procedure)next;
        final Consumer out = ctx.consumer;
        Nodes values;
        if (arg instanceof Nodes) {
            values = (Nodes)arg;
        }
        else {
            values = new Nodes();
            Values.writeValues(arg, values);
        }
        final int count = values.size();
        int it = 0;
        final IntNum countObj = IntNum.make(count);
        final RelativeStepFilter filter = new RelativeStepFilter(out);
        for (int pos = 1; pos <= count; ++pos) {
            it = values.nextPos(it);
            final Object dot = values.getPosPrevious(it);
            proc.check3(dot, IntNum.make(pos), countObj, ctx);
            Values.writeValues(ctx.runUntilValue(), filter);
        }
        filter.finish();
    }
    
    @Override
    public void compile(final ApplyExp exp, final Compilation comp, final Target target) {
        final Expression[] args = exp.getArgs();
        final Expression exp2 = args[0];
        final Expression exp3 = args[1];
        if (target instanceof IgnoreTarget) {
            exp2.compile(comp, target);
            exp3.compile(comp, target);
            return;
        }
        Type rtype = exp.getTypeRaw();
        if (rtype == null) {
            rtype = Type.pointer_type;
        }
        final Type rtypePrime = OccurrenceType.itemPrimeType(rtype);
        final int nodeCompare = NodeType.anyNodeTest.compare(rtypePrime);
        char expectedKind;
        if (nodeCompare >= 0) {
            expectedKind = 'N';
        }
        else if (nodeCompare == -3) {
            expectedKind = 'A';
        }
        else {
            expectedKind = ' ';
        }
        final TreeScanner step = extractStep(exp3);
        if (step != null) {
            final Type type1 = exp2.getType();
            if ((step instanceof ChildAxis || step instanceof AttributeAxis || step instanceof SelfAxis) && (type1 instanceof NodeSetType || (expectedKind == 'N' && OccurrenceType.itemCountIsZeroOrOne(exp2.getType())))) {
                expectedKind = 'S';
            }
        }
        if (!(target instanceof ConsumerTarget)) {
            ConsumerTarget.compileUsingConsumer(exp, comp, target);
            return;
        }
        final CodeAttr code = comp.getCode();
        final Scope scope = code.pushScope();
        Target mtarget;
        ClassType mclass;
        Variable mconsumer;
        Variable tconsumer;
        if (expectedKind == 'A' || expectedKind == 'S') {
            mtarget = target;
            mclass = null;
            mconsumer = null;
            tconsumer = null;
        }
        else {
            Method initMethod;
            if (expectedKind == 'N') {
                mclass = ClassType.make("gnu.kawa.xml.SortedNodes");
                initMethod = mclass.getDeclaredMethod("<init>", 0);
            }
            else {
                mclass = ClassType.make("gnu.xquery.util.RelativeStepFilter");
                initMethod = mclass.getDeclaredMethod("<init>", 1);
            }
            mconsumer = scope.addVariable(code, mclass, null);
            mtarget = new ConsumerTarget(mconsumer);
            code.emitNew(mclass);
            code.emitDup(mclass);
            tconsumer = ((ConsumerTarget)target).getConsumerVariable();
            if (expectedKind != 'N') {
                code.emitLoad(tconsumer);
            }
            code.emitInvoke(initMethod);
            code.emitStore(mconsumer);
        }
        ValuesMap.compileInlined((LambdaExp)exp3, exp2, 1, null, comp, mtarget);
        if (expectedKind == 'N') {
            code.emitLoad(mconsumer);
            code.emitLoad(tconsumer);
            code.emitInvokeStatic(Compilation.typeValues.getDeclaredMethod("writeValues", 2));
        }
        else if (expectedKind == ' ') {
            code.emitLoad(mconsumer);
            code.emitInvoke(mclass.getDeclaredMethod("finish", 0));
        }
        code.popScope();
    }
    
    @Override
    public Type getReturnType(final Expression[] args) {
        return Type.pointer_type;
    }
    
    public static TreeScanner extractStep(Expression exp) {
        while (exp instanceof ApplyExp) {
            final ApplyExp aexp = (ApplyExp)exp;
            final Expression func = aexp.getFunction();
            if (func instanceof QuoteExp) {
                final Object value = ((QuoteExp)func).getValue();
                if (value instanceof TreeScanner) {
                    return (TreeScanner)value;
                }
                if (value instanceof ValuesFilter) {
                    exp = aexp.getArgs()[0];
                    continue;
                }
            }
            return null;
        }
        return null;
    }
    
    static {
        relativeStep = new RelativeStep();
    }
}
