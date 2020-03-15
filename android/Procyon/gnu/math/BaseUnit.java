// 
// Decompiled by Procyon v0.5.36
// 

package gnu.math;

import java.io.ObjectStreamException;
import java.io.ObjectInput;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.Externalizable;

public class BaseUnit extends NamedUnit implements Externalizable
{
    String dimension;
    static int base_count;
    int index;
    private static final String unitName = "(name)";
    
    public String getDimension() {
        return this.dimension;
    }
    
    public BaseUnit() {
        this.name = "(name)";
        this.index = Integer.MAX_VALUE;
        this.dims = Dimensions.Empty;
    }
    
    @Override
    protected void init() {
        this.base = this;
        this.scale = 1.0;
        this.dims = new Dimensions(this);
        super.init();
        this.index = BaseUnit.base_count++;
    }
    
    public BaseUnit(final String name) {
        this.name = name;
        this.init();
    }
    
    public BaseUnit(final String name, final String dimension) {
        this.name = name;
        this.dimension = dimension;
        this.init();
    }
    
    @Override
    public int hashCode() {
        return this.name.hashCode();
    }
    
    @Override
    public Unit unit() {
        return this;
    }
    
    public static BaseUnit lookup(String name, final String dimension) {
        name = name.intern();
        if (name == "(name)" && dimension == null) {
            return Unit.Empty;
        }
        final int hash = name.hashCode();
        final int index = (hash & Integer.MAX_VALUE) % BaseUnit.table.length;
        for (NamedUnit unit = BaseUnit.table[index]; unit != null; unit = unit.chain) {
            if (unit.name == name && unit instanceof BaseUnit) {
                final BaseUnit bunit = (BaseUnit)unit;
                if (bunit.dimension == dimension) {
                    return bunit;
                }
            }
        }
        return null;
    }
    
    public static BaseUnit make(final String name, final String dimension) {
        final BaseUnit old = lookup(name, dimension);
        return (old == null) ? new BaseUnit(name, dimension) : old;
    }
    
    public static int compare(final BaseUnit unit1, final BaseUnit unit2) {
        final int code = unit1.name.compareTo(unit2.name);
        if (code != 0) {
            return code;
        }
        final String dim1 = unit1.dimension;
        final String dim2 = unit2.dimension;
        if (dim1 == dim2) {
            return 0;
        }
        if (dim1 == null) {
            return -1;
        }
        if (dim2 == null) {
            return 1;
        }
        return dim1.compareTo(dim2);
    }
    
    @Override
    public void writeExternal(final ObjectOutput out) throws IOException {
        out.writeUTF(this.name);
        out.writeObject(this.dimension);
    }
    
    @Override
    public void readExternal(final ObjectInput in) throws IOException, ClassNotFoundException {
        this.name = in.readUTF();
        this.dimension = (String)in.readObject();
    }
    
    @Override
    public Object readResolve() throws ObjectStreamException {
        final BaseUnit unit = lookup(this.name, this.dimension);
        if (unit != null) {
            return unit;
        }
        this.init();
        return this;
    }
    
    static {
        BaseUnit.base_count = 0;
    }
}
