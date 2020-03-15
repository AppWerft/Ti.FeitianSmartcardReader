// 
// Decompiled by Procyon v0.5.36
// 

package gnu.ecmascript;

import gnu.mapping.Procedure2;

public class BinaryOp extends Procedure2
{
    int op;
    
    public BinaryOp(final String name, final int op) {
        this.setName(name);
        this.op = op;
    }
    
    @Override
    public Object apply2(final Object arg1, final Object arg2) {
        if (this.op == 5) {
            return (Convert.toNumber(arg1) < Convert.toNumber(arg2)) ? Boolean.TRUE : Boolean.FALSE;
        }
        return new Double(this.apply(Convert.toNumber(arg1), Convert.toNumber(arg2)));
    }
    
    public double apply(final double arg1, final double arg2) {
        switch (this.op) {
            case 1: {
                return arg1 + arg2;
            }
            case 2: {
                return arg1 - arg2;
            }
            case 3: {
                return arg1 * arg2;
            }
            case 4: {
                return (int)arg1 << ((int)arg2 & 0x1F);
            }
            default: {
                return Double.NaN;
            }
        }
    }
}
