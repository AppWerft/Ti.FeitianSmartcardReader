/*
 * Decompiled with CFR 0.139.
 */
package gnu.math;

import gnu.math.DQuantity;
import gnu.math.Dimensions;
import gnu.math.Quantity;
import gnu.math.RealNum;
import gnu.math.Unit;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.ObjectStreamException;

public class NamedUnit
extends Unit
implements Externalizable {
    String name;
    double scale;
    Unit base;
    NamedUnit chain;

    public NamedUnit() {
    }

    public NamedUnit(String name, DQuantity value) {
        this.name = name.intern();
        this.scale = value.factor;
        this.base = value.unt;
        this.init();
    }

    public NamedUnit(String name, double factor, Unit base2) {
        this.name = name;
        this.base = base2;
        this.scale = factor;
        this.init();
    }

    protected void init() {
        this.factor = this.scale * this.base.factor;
        this.dims = this.base.dims;
        this.name = this.name.intern();
        int hash = this.name.hashCode();
        int index = (hash & Integer.MAX_VALUE) % table.length;
        this.chain = table[index];
        NamedUnit.table[index] = this;
    }

    @Override
    public String getName() {
        return this.name;
    }

    public static NamedUnit lookup(String name) {
        name = name.intern();
        int hash = name.hashCode();
        int index = (hash & Integer.MAX_VALUE) % table.length;
        NamedUnit unit = table[index];
        while (unit != null) {
            if (unit.name == name) {
                return unit;
            }
            unit = unit.chain;
        }
        return null;
    }

    public static NamedUnit lookup(String name, double scale, Unit base2) {
        name = name.intern();
        int hash = name.hashCode();
        int index = (hash & Integer.MAX_VALUE) % table.length;
        NamedUnit unit = table[index];
        while (unit != null) {
            if (unit.name == name && unit.scale == scale && unit.base == base2) {
                return unit;
            }
            unit = unit.chain;
        }
        return null;
    }

    public static NamedUnit make(String name, double scale, Unit base2) {
        NamedUnit old = NamedUnit.lookup(name, scale, base2);
        return old == null ? new NamedUnit(name, scale, base2) : old;
    }

    public static NamedUnit make(String name, Quantity value) {
        double scale;
        if (value instanceof DQuantity) {
            scale = ((DQuantity)value).factor;
        } else {
            if (value.imValue() != 0.0) {
                throw new ArithmeticException("defining " + name + " using complex value");
            }
            scale = value.re().doubleValue();
        }
        Unit base2 = value.unit();
        NamedUnit old = NamedUnit.lookup(name, scale, base2);
        return old == null ? new NamedUnit(name, scale, base2) : old;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeUTF(this.name);
        out.writeDouble(this.scale);
        out.writeObject(this.base);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        this.name = in.readUTF();
        this.scale = in.readDouble();
        this.base = (Unit)in.readObject();
    }

    public Object readResolve() throws ObjectStreamException {
        NamedUnit unit = NamedUnit.lookup(this.name, this.scale, this.base);
        if (unit != null) {
            return unit;
        }
        this.init();
        return this;
    }
}

