// 
// Decompiled by Procyon v0.5.36
// 

package gnu.ecmascript;

public class Convert
{
    public static double toNumber(final Object x) {
        if (x instanceof Number) {
            return ((Number)x).doubleValue();
        }
        if (x instanceof Boolean) {
            return x ? 1.0 : 0.0;
        }
        if (x instanceof String) {
            try {
                return Double.valueOf((String)x);
            }
            catch (NumberFormatException ex) {
                return Double.NaN;
            }
        }
        return Double.NaN;
    }
    
    public static double toInteger(final double x) {
        if (Double.isNaN(x)) {
            return 0.0;
        }
        return (x < 0.0) ? Math.ceil(x) : Math.floor(x);
    }
    
    public static double toInteger(final Object x) {
        return toInteger(toNumber(x));
    }
    
    public int toInt32(final double x) {
        if (Double.isNaN(x) || Double.isInfinite(x)) {
            return 0;
        }
        return (int)x;
    }
    
    public int toInt32(final Object x) {
        return this.toInt32(toNumber(x));
    }
}
