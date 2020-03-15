// 
// Decompiled by Procyon v0.5.36
// 

package kawa.standard;

import gnu.math.Quaternion;
import gnu.math.Complex;
import gnu.kawa.functions.Arithmetic;
import gnu.math.Numeric;
import gnu.math.IntNum;
import gnu.mapping.Procedure2;

public class expt extends Procedure2
{
    public static final expt expt;
    
    public expt(final String name) {
        super(name);
    }
    
    public static IntNum expt(final IntNum x, final int y) {
        return IntNum.power(x, y);
    }
    
    public static Numeric expt(final Object arg1, final Object arg2) {
        final Numeric narg1 = Arithmetic.asNumeric(arg1);
        final Numeric narg2 = Arithmetic.asNumeric(arg2);
        if (narg2 instanceof IntNum) {
            return narg1.power((IntNum)narg2);
        }
        if (narg1 instanceof Complex && narg2 instanceof Complex) {
            return Complex.power((Complex)narg1, (Complex)narg2);
        }
        return Quaternion.power((Quaternion)narg1, (Quaternion)narg2);
    }
    
    @Override
    public Object apply2(final Object arg1, final Object arg2) {
        return expt(arg1, arg2);
    }
    
    static {
        expt = new expt("expt");
    }
}
