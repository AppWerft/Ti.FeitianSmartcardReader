// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.lispexpr;

import gnu.bytecode.ClassType;
import gnu.bytecode.Type;
import gnu.bytecode.CodeAttr;
import java.util.List;

public class SeqSizeType extends LangObjType
{
    int requiredSize;
    boolean requiredExact;
    
    public SeqSizeType(final String name, final int requiredSize, final boolean requiredExact, final String implClass) {
        super(name, implClass, -1);
        this.requiredSize = requiredSize;
        this.requiredExact = requiredExact;
    }
    
    public SeqSizeType(final int requiredSize, final boolean requiredExact, final String implClass) {
        this((requiredExact ? "list#=" : "list#>=") + requiredSize, requiredSize, requiredExact, implClass);
    }
    
    @Override
    public Object coerceFromObject(final Object obj) {
        final List list = (List)obj;
        final int size = list.size();
        if (this.requiredExact) {
            if (size != this.requiredSize) {
                throw new ClassCastException();
            }
        }
        else if (size < this.requiredSize) {
            throw new ClassCastException();
        }
        return list;
    }
    
    public static void checkSizeEq(final List list, final int requiredSize) {
        final int sz = list.size();
        if (sz != requiredSize) {
            throw new ClassCastException("sequence has size " + sz + " should be " + requiredSize);
        }
    }
    
    public static void checkSizeGe(final List list, final int requiredSize) {
        final int sz = list.size();
        if (sz < requiredSize) {
            throw new ClassCastException("sequence has size " + sz + " should be at least " + requiredSize);
        }
    }
    
    public static List coerceEqOrNull(final Object object, final int requiredSize) {
        if (object instanceof List) {
            final List list = (List)object;
            if (list.size() == requiredSize) {
                return list;
            }
        }
        return null;
    }
    
    public static List coerceGeOrNull(final Object object, final int requiredSize) {
        if (object instanceof List) {
            final List list = (List)object;
            if (list.size() >= requiredSize) {
                return list;
            }
        }
        return null;
    }
    
    @Override
    public void emitCoerceFromObject(final CodeAttr code) {
        code.emitCheckcast(this.implementationType);
        code.emitDup();
        code.emitPushInt(this.requiredSize);
        final ClassType thisCl = ClassType.make("gnu.kawa.lispexpr.SeqSizeType");
        code.emitInvokeStatic(thisCl.getDeclaredMethod(this.requiredExact ? "checkSizeEq" : "checkSizeGe", 2));
    }
    
    @Override
    public boolean emitCoercionOrNull(final CodeAttr code) {
        final ClassType thisCl = ClassType.make("gnu.kawa.lispexpr.SeqSizeType");
        code.emitPushInt(this.requiredSize);
        code.emitInvokeStatic(thisCl.getDeclaredMethod(this.requiredExact ? "coerceEqOrNull" : "coerceGeOrNull", 2));
        return true;
    }
    
    @Override
    public int isCompatibleWithValue(final Type valueType) {
        return Type.isSame(this, valueType) ? 2 : Type.isCompatibleWithValue(this, valueType);
    }
    
    @Override
    public int compare(final Type other) {
        if (other instanceof SeqSizeType) {
            final SeqSizeType sother = (SeqSizeType)other;
            if (this.requiredSize != sother.requiredSize && ((this.requiredExact && sother.requiredExact) || (this.requiredExact && this.requiredSize < sother.requiredSize) || (sother.requiredExact && this.requiredSize > sother.requiredSize))) {
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
        final int r = this.getImplementationType().compare(other);
        return (r == 0 || r == -1) ? -1 : ((r == -3) ? -3 : -2);
    }
}
