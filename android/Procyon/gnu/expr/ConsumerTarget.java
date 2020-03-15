// 
// Decompiled by Procyon v0.5.36
// 

package gnu.expr;

import gnu.bytecode.PrimType;
import gnu.kawa.lispexpr.LangPrimType;
import gnu.bytecode.Method;
import gnu.bytecode.Scope;
import gnu.bytecode.CodeAttr;
import gnu.kawa.reflect.SingletonType;
import gnu.kawa.reflect.OccurrenceType;
import gnu.bytecode.ClassType;
import gnu.bytecode.Type;
import gnu.bytecode.Variable;

public class ConsumerTarget extends Target
{
    Variable consumer;
    boolean isContextTarget;
    Type type;
    private ConsumerTarget singleTarget;
    public static final ClassType typeSequences;
    
    public ConsumerTarget(final Variable consumer) {
        this.consumer = consumer;
        this.type = Type.objectType;
    }
    
    public ConsumerTarget(final Variable consumer, final Type type) {
        this.consumer = consumer;
        this.type = type;
    }
    
    public ConsumerTarget getSingleTarget() {
        if (this.singleTarget == null) {
            Type base;
            if (!(this.type instanceof OccurrenceType) || !OccurrenceType.itemCountIsOne(base = ((OccurrenceType)this.type).getBase())) {
                base = SingletonType.getInstance();
            }
            this.singleTarget = new ConsumerTarget(this.consumer, base);
            this.singleTarget.isContextTarget = this.isContextTarget;
        }
        return this.singleTarget;
    }
    
    public Variable getConsumerVariable() {
        return this.consumer;
    }
    
    public final boolean isContextTarget() {
        return this.isContextTarget;
    }
    
    public static Target makeContextTarget(final Compilation comp, final Type type) {
        final CodeAttr code = comp.getCode();
        comp.loadCallContext();
        code.emitGetField(Compilation.typeCallContext.getDeclaredField("consumer"));
        final Scope scope = code.getCurrentScope();
        final Variable result = scope.addVariable(code, Compilation.typeConsumer, "$result");
        code.emitStore(result);
        final ConsumerTarget target = new ConsumerTarget(result, type);
        target.isContextTarget = true;
        return target;
    }
    
    public static void compileUsingValues(final Expression exp, final Compilation comp, final Target target) {
        final ClassType typeValues = Compilation.typeValues;
        compileUsingConsumer(exp, comp, target, typeValues.getDeclaredMethod("make", 0), typeValues.getDeclaredMethod("canonicalize", 0));
    }
    
    public static void compileUsingConsumer(final Expression exp, final Compilation comp, final Target target) {
        if (target instanceof IgnoreTarget || target instanceof ConsumerTarget) {
            exp.compile(comp, target);
        }
        else {
            compileUsingValues(exp, comp, target);
        }
    }
    
    public static void compileUsingConsumer(final Expression exp, final Compilation comp, final Target target, final Method makeMethod, final Method resultMethod) {
        final CodeAttr code = comp.getCode();
        final Scope scope = code.pushScope();
        Type ctype;
        if (makeMethod.getName() == "<init>") {
            final ClassType cltype = (ClassType)(ctype = makeMethod.getDeclaringClass());
            code.emitNew(cltype);
            code.emitDup(ctype);
            code.emitInvoke(makeMethod);
        }
        else {
            ctype = makeMethod.getReturnType();
            code.emitInvokeStatic(makeMethod);
        }
        final Variable consumer = scope.addVariable(code, ctype, null);
        final ConsumerTarget ctarget = new ConsumerTarget(consumer, exp.getType());
        code.emitStore(consumer);
        exp.compile(comp, ctarget);
        code.emitLoad(consumer);
        if (resultMethod != null) {
            code.emitInvoke(resultMethod);
        }
        code.popScope();
        target.compileFromStack(comp, exp.getType());
    }
    
    @Override
    public void compileFromStack(final Compilation comp, final Type stackType) {
        this.compileFromStack(comp, stackType, -1);
    }
    
    void compileFromStack(final Compilation comp, Type stackType, final int consumerPushed) {
        final CodeAttr code = comp.getCode();
        String methodName = null;
        Method method = null;
        ClassType methodClass = Compilation.typeConsumer;
        Type methodArg = null;
        boolean islong = false;
        final Type ttype = this.getType();
        if (!stackType.isVoid()) {
            StackTarget.convert(comp, stackType, ttype);
            stackType = ttype;
        }
        if (stackType instanceof LangPrimType && (stackType == LangPrimType.characterType || stackType == LangPrimType.characterOrEofType)) {
            stackType.emitCoerceToObject(code);
            stackType = Type.objectType;
        }
        final Type implType = stackType.getImplementationType();
        char sig;
        if (implType instanceof PrimType) {
            sig = implType.getSignature().charAt(0);
            switch (sig) {
                case 'I': {
                    if (stackType == LangPrimType.unsignedIntType) {
                        methodName = "writeUInt";
                        methodClass = ConsumerTarget.typeSequences;
                        break;
                    }
                }
                case 'B':
                case 'S': {
                    methodName = "writeInt";
                    methodArg = Type.intType;
                    break;
                }
                case 'J': {
                    if (stackType == LangPrimType.unsignedLongType) {
                        methodName = "writeULong";
                        methodClass = ConsumerTarget.typeSequences;
                    }
                    else {
                        methodName = "writeLong";
                        methodArg = Type.longType;
                    }
                    islong = true;
                    break;
                }
                case 'F': {
                    methodName = "writeFloat";
                    methodArg = Type.floatType;
                    break;
                }
                case 'D': {
                    methodName = "writeDouble";
                    methodArg = Type.doubleType;
                    islong = true;
                    break;
                }
                case 'C': {
                    methodName = "append";
                    methodArg = Type.charType;
                    break;
                }
                case 'Z': {
                    methodName = "writeBoolean";
                    methodArg = Type.booleanType;
                    break;
                }
                case 'V': {
                    return;
                }
            }
        }
        else {
            sig = '\0';
            if (consumerPushed != 1 && !OccurrenceType.itemCountIsOne(implType)) {
                method = Compilation.typeValues.getDeclaredMethod("writeValues", 2);
                code.emitLoad(this.consumer);
                if (consumerPushed == 0) {
                    code.emitSwap();
                }
                code.emitInvokeStatic(method);
                return;
            }
            methodName = "writeObject";
            methodArg = Type.pointer_type;
        }
        if (consumerPushed >= 0) {
            if (methodClass == ConsumerTarget.typeSequences) {
                throw new InternalError();
            }
        }
        else if (methodClass == ConsumerTarget.typeSequences) {
            code.emitLoad(this.consumer);
        }
        else if (islong) {
            code.pushScope();
            final Variable temp = code.addLocal(implType);
            code.emitStore(temp);
            code.emitLoad(this.consumer);
            code.emitLoad(temp);
            code.popScope();
        }
        else {
            code.emitLoad(this.consumer);
            code.emitSwap();
        }
        if (methodClass == ConsumerTarget.typeSequences) {
            method = methodClass.getDeclaredMethod(methodName, 2);
        }
        else if (method == null && methodName != null) {
            final Type[] methodArgs = { methodArg };
            method = methodClass.getDeclaredMethod(methodName, methodArgs);
        }
        if (method != null) {
            code.emitInvoke(method);
        }
        if (sig == 'C') {
            code.emitPop(1);
        }
    }
    
    public boolean compileWrite(final Expression exp, final Compilation comp) {
        final Type stackType = exp.getType();
        final Type implType = stackType.getImplementationType();
        if (implType instanceof PrimType) {
            if (implType.isVoid() || stackType == LangPrimType.characterType || stackType == LangPrimType.characterOrEofType || stackType == LangPrimType.unsignedLongType || stackType == LangPrimType.unsignedIntType) {
                return false;
            }
        }
        else if (!OccurrenceType.itemCountIsOne(implType)) {
            return false;
        }
        comp.getCode().emitLoad(this.consumer);
        final Type ttype = this.type;
        exp.compile(comp, StackTarget.getInstance(ttype));
        this.compileFromStack(comp, ttype, 1);
        return true;
    }
    
    @Override
    public Type getType() {
        return this.type;
    }
    
    static {
        typeSequences = ClassType.make("gnu.lists.Sequences");
    }
}
