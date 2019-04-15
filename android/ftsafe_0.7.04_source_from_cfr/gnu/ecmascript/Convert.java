/*
 * Decompiled with CFR 0.139.
 */
package gnu.ecmascript;

public class Convert {
    public static double toNumber(Object x) {
        if (x instanceof Number) {
            return ((Number)x).doubleValue();
        }
        if (x instanceof Boolean) {
            return (Boolean)x != false ? 1.0 : 0.0;
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

    public static double toInteger(double x) {
        if (Double.isNaN(x)) {
            return 0.0;
        }
        return x < 0.0 ? Math.ceil(x) : Math.floor(x);
    }

    public static double toInteger(Object x) {
        return Convert.toInteger(Convert.toNumber(x));
    }

    public int toInt32(double x) {
        if (Double.isNaN(x) || Double.isInfinite(x)) {
            return 0;
        }
        return (int)x;
    }

    public int toInt32(Object x) {
        return this.toInt32(Convert.toNumber(x));
    }
}

