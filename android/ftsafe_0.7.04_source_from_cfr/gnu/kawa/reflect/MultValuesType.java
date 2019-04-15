/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.reflect;

import gnu.bytecode.ClassType;
import gnu.bytecode.Type;
import gnu.expr.Compilation;
import gnu.kawa.reflect.LazyType;
import gnu.kawa.reflect.OccurrenceType;
import gnu.kawa.reflect.SingletonType;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class MultValuesType
extends OccurrenceType {
    Type[] itemTypes;

    public MultValuesType(Type[] itemTypes) {
        super(SingletonType.instance, itemTypes.length, itemTypes.length);
        this.itemTypes = itemTypes;
    }

    public int getValueCount() {
        return this.itemTypes.length;
    }

    public Type getValueType(int index) {
        return this.itemTypes[index];
    }

    @Override
    public Type getImplementationType() {
        return this.itemTypes.length == 1 ? Type.objectType : Compilation.typeValues;
    }

    public static Type create(Type[] itemTypes) {
        if (itemTypes.length == 1) {
            Type t0 = itemTypes[0];
            return t0 == null ? SingletonType.getInstance() : t0;
        }
        return new MultValuesType(itemTypes);
    }

    @Override
    public String toString() {
        StringBuilder sbuf = new StringBuilder();
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
        if (valueType instanceof MultValuesType) {
            Type[] items = this.itemTypes;
            MultValuesType mOther = (MultValuesType)valueType;
            Type[] itemsOther = mOther.itemTypes;
            if (items.length != itemsOther.length) {
                return -3;
            }
            int prev = 2;
            for (int i = 0; i < items.length; ++i) {
                int cmp;
                Type item = items[i];
                Type itemOther = itemsOther[i];
                if (item == null) {
                    item = Type.objectType;
                }
                if ((cmp = item.isCompatibleWithValue(itemOther)) < 0) {
                    return cmp;
                }
                if (cmp >= prev) continue;
                prev = cmp;
            }
            return prev;
        }
        return super.isCompatibleWithValue(valueType);
    }

    @Override
    public int compare(Type other) {
        if (other instanceof LazyType) {
            other = ((LazyType)other).getValueType();
        }
        if (other instanceof MultValuesType) {
            MultValuesType mOther = (MultValuesType)other;
            if (this == other) {
                return 0;
            }
            Type[] items = this.itemTypes;
            Type[] itemsOther = mOther.itemTypes;
            if (items.length != itemsOther.length) {
                return -3;
            }
            int prev = 0;
            for (int i = 0; i < items.length; ++i) {
                int cmp;
                Type item = items[i];
                Type itemOther = itemsOther[i];
                if (item == null) {
                    item = Type.objectType;
                }
                if ((cmp = item.compare(itemOther)) == -3) {
                    return -3;
                }
                if (cmp == 0 || cmp == prev) continue;
                prev = -2;
            }
            return prev;
        }
        return super.compare(other);
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(this.itemTypes);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        this.itemTypes = (Type[])in.readObject();
        this.base = SingletonType.instance;
        this.minOccurs = this.itemTypes.length;
        this.maxOccurs = this.itemTypes.length;
    }
}

