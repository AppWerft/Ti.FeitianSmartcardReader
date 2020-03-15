// 
// Decompiled by Procyon v0.5.36
// 

package gnu.math;

import java.io.ObjectStreamException;
import java.io.ObjectInput;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.Externalizable;

public class NamedUnit extends Unit implements Externalizable
{
    String name;
    double scale;
    Unit base;
    NamedUnit chain;
    
    public NamedUnit() {
    }
    
    public NamedUnit(final String name, final DQuantity value) {
        this.name = name.intern();
        this.scale = value.factor;
        this.base = value.unt;
        this.init();
    }
    
    public NamedUnit(final String name, final double factor, final Unit base) {
        this.name = name;
        this.base = base;
        this.scale = factor;
        this.init();
    }
    
    protected void init() {
        this.factor = this.scale * this.base.factor;
        this.dims = this.base.dims;
        this.name = this.name.intern();
        final int hash = this.name.hashCode();
        final int index = (hash & Integer.MAX_VALUE) % NamedUnit.table.length;
        this.chain = NamedUnit.table[index];
        NamedUnit.table[index] = this;
    }
    
    @Override
    public String getName() {
        return this.name;
    }
    
    public static NamedUnit lookup(String name) {
        name = name.intern();
        final int hash = name.hashCode();
        final int index = (hash & Integer.MAX_VALUE) % NamedUnit.table.length;
        for (NamedUnit unit = NamedUnit.table[index]; unit != null; unit = unit.chain) {
            if (unit.name == name) {
                return unit;
            }
        }
        return null;
    }
    
    public static NamedUnit lookup(String name, final double scale, final Unit base) {
        name = name.intern();
        final int hash = name.hashCode();
        final int index = (hash & Integer.MAX_VALUE) % NamedUnit.table.length;
        for (NamedUnit unit = NamedUnit.table[index]; unit != null; unit = unit.chain) {
            if (unit.name == name && unit.scale == scale && unit.base == base) {
                return unit;
            }
        }
        return null;
    }
    
    public static NamedUnit make(final String name, final double scale, final Unit base) {
        final NamedUnit old = lookup(name, scale, base);
        return (old == null) ? new NamedUnit(name, scale, base) : old;
    }
    
    public static NamedUnit make(final String name, final Quantity value) {
        double scale;
        if (value instanceof DQuantity) {
            scale = ((DQuantity)value).factor;
        }
        else {
            if (value.imValue() != 0.0) {
                throw new ArithmeticException("defining " + name + " using complex value");
            }
            scale = value.re().doubleValue();
        }
        final Unit base = value.unit();
        final NamedUnit old = lookup(name, scale, base);
        return (old == null) ? new NamedUnit(name, scale, base) : old;
    }
    
    @Override
    public void writeExternal(final ObjectOutput out) throws IOException {
        out.writeUTF(this.name);
        out.writeDouble(this.scale);
        out.writeObject(this.base);
    }
    
    @Override
    public void readExternal(final ObjectInput in) throws IOException, ClassNotFoundException {
        this.name = in.readUTF();
        this.scale = in.readDouble();
        this.base = (Unit)in.readObject();
    }
    
    public Object readResolve() throws ObjectStreamException {
        final NamedUnit unit = lookup(this.name, this.scale, this.base);
        if (unit != null) {
            return unit;
        }
        this.init();
        return this;
    }
}
