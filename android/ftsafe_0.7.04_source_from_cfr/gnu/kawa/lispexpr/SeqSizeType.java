/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.lispexpr;

import gnu.bytecode.ClassType;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.Method;
import gnu.bytecode.Type;
import gnu.kawa.lispexpr.LangObjType;
import java.util.List;

public class SeqSizeType
extends LangObjType {
    int requiredSize;
    boolean requiredExact;

    public SeqSizeType(String name, int requiredSize, boolean requiredExact, String implClass) {
        super(name, implClass, -1);
        this.requiredSize = requiredSize;
        this.requiredExact = requiredExact;
    }

    public SeqSizeType(int requiredSize, boolean requiredExact, String implClass) {
        this((requiredExact ? "list#=" : "list#>=") + requiredSize, requiredSize, requiredExact, implClass);
    }

    @Override
    public Object coerceFromObject(Object obj) {
        List list = (List)obj;
        int size = list.size();
        if (this.requiredExact ? size == this.requiredSize : size >= this.requiredSize) {
            return list;
        }
        throw new ClassCastException();
    }

    public static void checkSizeEq(List list, int requiredSize) {
        int sz = list.size();
        if (sz != requiredSize) {
            throw new ClassCastException("sequence has size " + sz + " should be " + requiredSize);
        }
    }

    public static void checkSizeGe(List list, int requiredSize) {
        int sz = list.size();
        if (sz < requiredSize) {
            throw new ClassCastException("sequence has size " + sz + " should be at least " + requiredSize);
        }
    }

    public static List coerceEqOrNull(Object object2, int requiredSize) {
        List list;
        if (object2 instanceof List && (list = (List)object2).size() == requiredSize) {
            return list;
        }
        return null;
    }

    public static List coerceGeOrNull(Object object2, int requiredSize) {
        List list;
        if (object2 instanceof List && (list = (List)object2).size() >= requiredSize) {
            return list;
        }
        return null;
    }

    @Override
    public void emitCoerceFromObject(CodeAttr code) {
        code.emitCheckcast(this.implementationType);
        code.emitDup();
        code.emitPushInt(this.requiredSize);
        ClassType thisCl = ClassType.make("gnu.kawa.lispexpr.SeqSizeType");
        code.emitInvokeStatic(thisCl.getDeclaredMethod(this.requiredExact ? "checkSizeEq" : "checkSizeGe", 2));
    }

    @Override
    public boolean emitCoercionOrNull(CodeAttr code) {
        ClassType thisCl = ClassType.make("gnu.kawa.lispexpr.SeqSizeType");
        code.emitPushInt(this.requiredSize);
        code.emitInvokeStatic(thisCl.getDeclaredMethod(this.requiredExact ? "coerceEqOrNull" : "coerceGeOrNull", 2));
        return true;
    }

    @Override
    public int isCompatibleWithValue(Type valueType) {
        return Type.isSame(this, valueType) ? 2 : Type.isCompatibleWithValue(this, valueType);
    }

    @Override
    public int compare(Type other) {
        int r;
        if (other instanceof SeqSizeType) {
            SeqSizeType sother = (SeqSizeType)other;
            if (this.requiredSize != sother.requiredSize && (this.requiredExact && sother.requiredExact || this.requiredExact && this.requiredSize < sother.requiredSize || sother.requiredExact && this.requiredSize > sother.requiredSize)) {
                return -3;
            }
            if (this.getImplementationType() == sother.getImplementationType()) {
                if (this.requiredSize == sother.requiredSize && this.requiredExact && sother.requiredExact) {
                    return 0;
                }
                if (this.requiredSize < sother.requiredSize && !this.requiredExact) {
                    return 1;
                }
                if (this.requiredSize > sother.requiredSize && !sother.requiredExact) {
                    return -1;
                }
            }
        }
        return (r = this.getImplementationType().compare(other)) == 0 || r == -1 ? -1 : (r == -3 ? -3 : -2);
    }
}

