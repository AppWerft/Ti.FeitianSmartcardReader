// 
// Decompiled by Procyon v0.5.36
// 

package gnu.expr;

import gnu.kawa.reflect.OccurrenceType;
import gnu.bytecode.ArrayType;
import gnu.bytecode.PrimType;
import gnu.mapping.Values;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.Method;
import gnu.bytecode.ObjectType;
import gnu.bytecode.ClassType;
import gnu.kawa.reflect.LazyType;
import gnu.bytecode.Type;

public class StackTarget extends Target
{
    Type type;
    protected boolean autoTruncates;
    
    public StackTarget(final Type type) {
        this.type = type;
    }
    
    boolean autoTruncates(final Type stackType) {
        if (this.autoTruncates && stackType == Type.intType) {
            final char sig1 = this.type.getSignature().charAt(0);
            if (sig1 == 'B' || sig1 == 'S' || sig1 == 'C') {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public Type getType() {
        return this.type;
    }
    
    public static Target getInstance(final Type type) {
        return type.isVoid() ? Target.Ignore : ((type == Type.pointer_type) ? Target.pushObject : new StackTarget(type));
    }
    
    public static Target getTruncatingInstance(final Type type) {
        if (type.isVoid()) {
            return Target.Ignore;
        }
        if (type == Type.pointer_type) {
            return Target.pushObject;
        }
        final StackTarget target = new StackTarget(type);
        target.autoTruncates = true;
        return target;
    }
    
    protected StackTarget getClonedInstance(final Type type) {
        return new StackTarget(type);
    }
    
    public static Type forceLazyIfNeeded(final Compilation comp, Type stackType, final Type type) {
        if (LazyType.maybeLazy(stackType) && !LazyType.maybeLazy(type)) {
            stackType = forceLazy(comp, stackType, type);
        }
        return stackType;
    }
    
    public static Type forceLazy(final Compilation comp, Type stackType, final Type type) {
        final Type rawType = type.getRawType();
        if (rawType.compare(stackType.getRawType()) < 0) {
            Method forceMethod;
            if (stackType instanceof LazyType) {
                forceMethod = LazyType.lazyType.getDeclaredMethod("getValue", 0);
            }
            else {
                int nargsforce;
                if (rawType instanceof ClassType) {
                    nargsforce = 2;
                    comp.loadClassRef((ObjectType)rawType);
                }
                else {
                    nargsforce = 1;
                }
                forceMethod = ClassType.make("gnu.mapping.Promise").getDeclaredStaticMethod("force", nargsforce);
            }
            final CodeAttr code = comp.getCode();
            code.emitInvoke(forceMethod);
            if (stackType instanceof LazyType) {
                stackType = ((LazyType)stackType).getValueType();
                if (type.isCompatibleWithValue(Type.objectType) != 2) {
                    code.emitCheckcast(stackType.getRawType());
                }
            }
            else {
                stackType = Type.objectType;
            }
        }
        return stackType;
    }
    
    protected boolean compileFromStack0(final Compilation comp, final Type stackType) {
        return compileFromStack0(comp, stackType, this.type);
    }
    
    static boolean compileFromStack0(final Compilation comp, Type stackType, final Type type) {
        final CodeAttr code = comp.getCode();
        stackType = forceLazyIfNeeded(comp, stackType, type);
        if (type.isCompatibleWithValue(stackType) == 2 || !code.reachableHere()) {
            return true;
        }
        if (stackType.isVoid()) {
            comp.compileConstant(Values.empty);
            stackType = Type.pointer_type;
        }
        else if (stackType instanceof PrimType && type instanceof PrimType) {
            code.emitConvert((PrimType)stackType, (PrimType)type);
            return true;
        }
        if (stackType instanceof ArrayType) {
            if (type == Type.pointer_type || "java.lang.Cloneable".equals(type.getName())) {
                return true;
            }
        }
        else if (stackType.getImplementationType() instanceof PrimType) {
            type.emitConvertFromPrimitive(stackType, code);
            stackType = code.topType();
        }
        return type.isCompatibleWithValue(stackType) > 1;
    }
    
    public static void convert(final Compilation comp, final Type stackType, final Type targetType) {
        if (!compileFromStack0(comp, stackType, targetType)) {
            emitCoerceFromObject(targetType, comp);
        }
    }
    
    protected static void emitCoerceFromObject(final Type type, final Compilation comp) {
        final CodeAttr code = comp.getCode();
        if (type instanceof OccurrenceType) {
            comp.compileConstant(type, Target.pushObject);
            code.emitSwap();
            code.emitInvokeVirtual(ClassType.make("gnu.bytecode.Type").getDeclaredMethod("coerceFromObject", 1));
            final Type raw = type.getRawType();
            if (raw != Type.objectType) {
                code.emitCheckcast(raw);
            }
        }
        else {
            comp.usedClass(type);
            type.emitCoerceFromObject(code);
        }
    }
    
    @Override
    public void compileFromStack(final Compilation comp, final Type stackType) {
        if (this.type instanceof LazyType && !(stackType instanceof LazyType)) {
            final LazyType ltype = (LazyType)this.type;
            if (!LazyType.maybeLazy(stackType)) {
                this.getClonedInstance(ltype.getValueType()).compileFromStack(comp, stackType);
            }
            final Method wrapMethod = ClassType.make("gnu.mapping.Promise").getDeclaredStaticMethod("coerceToLazy", 1);
            comp.getCode().emitInvokeStatic(wrapMethod);
            comp.getCode().emitCheckcast(ltype.getRawType());
        }
        else if (!this.autoTruncates(stackType) && !this.compileFromStack0(comp, stackType)) {
            this.doCoerce(comp);
        }
    }
    
    protected void doCoerce(final Compilation comp) {
        emitCoerceFromObject(this.type, comp);
    }
}
