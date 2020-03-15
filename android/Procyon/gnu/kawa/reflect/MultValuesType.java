// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.reflect;

import java.io.ObjectInput;
import java.io.IOException;
import java.io.ObjectOutput;
import gnu.expr.Compilation;
import gnu.bytecode.Type;

public class MultValuesType extends OccurrenceType
{
    Type[] itemTypes;
    
    public MultValuesType(final Type[] itemTypes) {
        super(SingletonType.instance, itemTypes.length, itemTypes.length);
        this.itemTypes = itemTypes;
    }
    
    public int getValueCount() {
        return this.itemTypes.length;
    }
    
    public Type getValueType(final int index) {
        return this.itemTypes[index];
    }
    
    @Override
    public Type getImplementationType() {
        return (this.itemTypes.length == 1) ? Type.objectType : Compilation.typeValues;
    }
    
    public static Type create(final Type[] itemTypes) {
        if (itemTypes.length == 1) {
            final Type t0 = itemTypes[0];
            return (t0 == null) ? SingletonType.getInstance() : t0;
        }
        return new MultValuesType(itemTypes);
    }
    
    @Override
    public String toString() {
        final StringBuilder sbuf = new StringBuilder();
        sbuf.append("mult-values[");
        for (int i = 0; i < this.itemTypes.length; ++i) {
            if (i > 0) {
                sbuf.append(' ');
            }
            sbuf.append(this.itemTypes[i]);
        }
        sbuf.append(']');
        return sbuf.toString();
    }
    
    @Override
    public int isCompatibleWithValue(Type valueType) {
        if (valueType instanceof LazyType) {
            valueType = ((LazyType)valueType).getValueType();
        }
        if (Type.isSame(this, valueType)) {
            return 2;
        }
        if (!(valueType instanceof MultValuesType)) {
            return super.isCompatibleWithValue(valueType);
        }
        final Type[] items = this.itemTypes;
        final MultValuesType mOther = (MultValuesType)valueType;
        final Type[] itemsOther = mOther.itemTypes;
        if (items.length != itemsOther.length) {
            return -3;
        }
        int prev = 2;
        for (int i = 0; i < items.length; ++i) {
            Type item = items[i];
            final Type itemOther = itemsOther[i];
            if (item == null) {
                item = Type.objectType;
            }
            final int cmp = item.isCompatibleWithValue(itemOther);
            if (cmp < 0) {
                return cmp;
            }
            if (cmp < prev) {
                prev = cmp;
            }
        }
        return prev;
    }
    
    @Override
    public int compare(Type other) {
        if (other instanceof LazyType) {
            other = ((LazyType)other).getValueType();
        }
        if (!(other instanceof MultValuesType)) {
            return super.compare(other);
        }
        final MultValuesType mOther = (MultValuesType)other;
        if (this == other) {
            return 0;
        }
        final Type[] items = this.itemTypes;
        final Type[] itemsOther = mOther.itemTypes;
        if (items.length != itemsOther.length) {
            return -3;
        }
        int prev = 0;
        for (int i = 0; i < items.length; ++i) {
            Type item = items[i];
            final Type itemOther = itemsOther[i];
            if (item == null) {
                item = Type.objectType;
            }
            final int cmp = item.compare(itemOther);
            if (cmp == -3) {
                return -3;
            }
            if (cmp != 0) {
                if (cmp != prev) {
                    prev = -2;
                }
            }
        }
        return prev;
    }
    
    @Override
    public void writeExternal(final ObjectOutput out) throws IOException {
        out.writeObject(this.itemTypes);
    }
    
    @Override
    public void readExternal(final ObjectInput in) throws IOException, ClassNotFoundException {
        this.itemTypes = (Type[])in.readObject();
        this.base = SingletonType.instance;
        this.minOccurs = this.itemTypes.length;
        this.maxOccurs = this.itemTypes.length;
    }
}
