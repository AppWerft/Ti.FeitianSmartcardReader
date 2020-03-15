// 
// Decompiled by Procyon v0.5.36
// 

package gnu.xquery.util;

import gnu.mapping.WrongType;
import gnu.mapping.Values;
import gnu.kawa.xml.UntypedAtomic;
import gnu.kawa.io.Path;
import gnu.lists.SeqPosition;
import gnu.math.Numeric;
import gnu.math.RealNum;
import gnu.mapping.Procedure;
import gnu.mapping.Procedure1;

public class BooleanValue extends Procedure1
{
    public static final BooleanValue booleanValue;
    
    public BooleanValue(final String name) {
        super(name);
        this.setProperty(Procedure.validateApplyKey, "gnu.xquery.util.CompileMisc:validateBooleanValue");
    }
    
    public static boolean booleanValue(final Object value) {
        if (value instanceof Boolean) {
            return (boolean)value;
        }
        if (value instanceof Number && (value instanceof RealNum || !(value instanceof Numeric))) {
            final double d = ((Number)value).doubleValue();
            return d != 0.0 && !Double.isNaN(d);
        }
        if (value instanceof SeqPosition) {
            return true;
        }
        if (value instanceof String || value instanceof Path || value instanceof UntypedAtomic) {
            return value.toString().length() > 0;
        }
        if (value instanceof Values) {
            final Values values = (Values)value;
            final int sz = values.size();
            if (sz == 0) {
                return false;
            }
            final Object value2 = values.get(0);
            if (sz == 1) {
                return booleanValue(value2);
            }
            if (value2 instanceof SeqPosition) {
                return true;
            }
        }
        throw new WrongType("fn:boolean", 1, value, "boolean-convertible-value");
    }
    
    public static boolean not(final Object value) {
        return !booleanValue(value);
    }
    
    @Override
    public Object apply1(final Object arg) {
        return booleanValue(arg) ? Boolean.TRUE : Boolean.FALSE;
    }
    
    static {
        booleanValue = new BooleanValue("boolean-value");
    }
}
