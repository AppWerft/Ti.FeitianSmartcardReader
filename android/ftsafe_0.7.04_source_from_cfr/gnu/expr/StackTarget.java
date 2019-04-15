/*
 * Decompiled with CFR 0.139.
 */
package gnu.expr;

import gnu.bytecode.ArrayType;
import gnu.bytecode.ClassType;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.Method;
import gnu.bytecode.ObjectType;
import gnu.bytecode.PrimType;
import gnu.bytecode.Type;
import gnu.expr.Compilation;
import gnu.expr.Target;
import gnu.kawa.reflect.LazyType;
import gnu.kawa.reflect.OccurrenceType;
import gnu.mapping.Values;

public class StackTarget
extends Target {
    Type type;
    protected boolean autoTruncates;

    public StackTarget(Type type) {
        this.type = type;
    }

    boolean autoTruncates(Type stackType) {
        char sig1;
        return this.autoTruncates && stackType == Type.intType && ((sig1 = this.type.getSignature().charAt(0)) == 'B' || sig1 == 'S' || sig1 == 'C');
    }

    @Override
    public Type getType() {
        return this.type;
    }

    public static Target getInstance(Type type) {
        return type.isVoid() ? Target.Ignore : (type == Type.pointer_type ? Target.pushObject : new StackTarget(type));
    }

    public static Target getTruncatingInstance(Type type) {
        if (type.isVoid()) {
            return Target.Ignore;
        }
        if (type == Type.pointer_type) {
            return Target.pushObject;
        }
        StackTarget target = new StackTarget(type);
        target.autoTruncates = true;
        return target;
    }

    protected StackTarget getClonedInstance(Type type) {
        return new StackTarget(type);
    }

    public static Type forceLazyIfNeeded(Compilation comp, Type stackType, Type type) {
        if (LazyType.maybeLazy(stackType) && !LazyType.maybeLazy(type)) {
            stackType = StackTarget.forceLazy(comp, stackType, type);
        }
        return stackType;
    }

    public static Type forceLazy(Compilation comp, Type stackType, Type type) {
        Type rawType = type.getRawType();
        if (rawType.compare(stackType.getRawType()) < 0) {
            Method forceMethod;
            if (stackType instanceof LazyType) {
                forceMethod = LazyType.lazyType.getDeclaredMethod("getValue", 0);
            } else {
                int nargsforce;
                if (rawType instanceof ClassType) {
                    nargsforce = 2;
                    comp.loadClassRef((ClassType)rawType);
                } else {
                    nargsforce = 1;
                }
                forceMethod = ClassType.make("gnu.mapping.Promise").getDeclaredStaticMethod("force", nargsforce);
            }
            CodeAttr code = comp.getCode();
            code.emitInvoke(forceMethod);
            if (stackType instanceof LazyType) {
                stackType = ((LazyType)stackType).getValueType();
                if (type.isCompatibleWithValue(Type.objectType) != 2) {
                    code.emitCheckcast(stackType.getRawType());
                }
            } else {
                stackType = Type.objectType;
            }
        }
        return stackType;
    }

    protected boolean compileFromStack0(Compilation comp, Type stackType) {
        return StackTarget.compileFromStack0(comp, stackType, this.type);
    }

    static boolean compileFromStack0(Compilation comp, Type stackType, Type type) {
        CodeAttr code = comp.getCode();
        if (type.isCompatibleWithValue(stackType = StackTarget.forceLazyIfNeeded(comp, stackType, type)) == 2 || !code.reachableHere()) {
            return true;
        }
        if (stackType.isVoid()) {
            comp.compileConstant(Values.empty);
            stackType = Type.pointer_type;
        } else if (stackType instanceof PrimType && type instanceof PrimType) {
            code.emitConvert((PrimType)stackType, (PrimType)type);
            return true;
        }
        if (stackType instanceof ArrayType) {
            if (type == Type.pointer_type || "java.lang.Cloneable".equals(type.getName())) {
                return true;
            }
        } else if (stackType.getImplementationType() instanceof PrimType) {
            type.emitConvertFromPrimitive(stackType, code);
            stackType = code.topType();
        }
        return type.isCompatibleWithValue(stackType) > 1;
    }

    public static void convert(Compilation comp, Type stackType, Type targetType) {
        if (!StackTarget.compileFromStack0(comp, stackType, targetType)) {
            StackTarget.emitCoerceFromObject(targetType, comp);
        }
    }

    protected static void emitCoerceFromObject(Type type, Compilation comp) {
        CodeAttr code = comp.getCode();
        if (type instanceof OccurrenceType) {
            comp.compileConstant(type, Target.pushObject);
            code.emitSwap();
            code.emitInvokeVirtual(ClassType.make("gnu.bytecode.Type").getDeclaredMethod("coerceFromObject", 1));
            Type raw = type.getRawType();
            if (raw != Type.objectType) {
                code.emitCheckcast(raw);
            }
        } else {
            comp.usedClass(type);
            type.emitCoerceFromObject(code);
        }
    }

    @Override
    public void compileFromStack(Compilation comp, Type stackType) {
        if (this.type instanceof LazyType && !(stackType instanceof LazyType)) {
            LazyType ltype = (LazyType)this.type;
            if (!LazyType.maybeLazy(stackType)) {
                this.getClonedInstance(ltype.getValueType()).compileFromStack(comp, stackType);
            }
            Method wrapMethod = ClassType.make("gnu.mapping.Promise").getDeclaredStaticMethod("coerceToLazy", 1);
            comp.getCode().emitInvokeStatic(wrapMethod);
            comp.getCode().emitCheckcast(ltype.getRawType());
        } else if (!this.autoTruncates(stackType) && !this.compileFromStack0(comp, stackType)) {
            this.doCoerce(comp);
        }
    }

    protected void doCoerce(Compilation comp) {
        StackTarget.emitCoerceFromObject(this.type, comp);
    }
}

