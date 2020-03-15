// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.functions;

import java.io.IOException;
import java.text.FieldPosition;
import gnu.text.Char;
import gnu.math.DFloNum;
import gnu.math.IntNum;
import gnu.math.Numeric;
import gnu.kawa.format.ReportFormat;

class LispEscapeFormat extends ReportFormat
{
    int param1;
    int param2;
    int param3;
    boolean escapeAll;
    public static final LispEscapeFormat alwaysTerminate;
    public static final int ESCAPE_NORMAL = 241;
    public static final int ESCAPE_ALL = 242;
    
    public LispEscapeFormat(final int param1, final int param2) {
        this.param1 = param1;
        this.param2 = param2;
        this.param3 = -1073741824;
    }
    
    public LispEscapeFormat(final int param1, final int param2, final int param3) {
        this.param1 = param1;
        this.param2 = param2;
        this.param3 = param3;
    }
    
    static Numeric getParam(final int param, final Object[] args, final int start) {
        if (param == -1342177280) {
            return IntNum.make(args.length - start);
        }
        if (param != -1610612736) {
            return IntNum.make(param);
        }
        final Object arg = args[start];
        if (arg instanceof Numeric) {
            return (Numeric)arg;
        }
        if (arg instanceof Number) {
            if (arg instanceof Float || arg instanceof Double) {
                return new DFloNum(((Number)arg).doubleValue());
            }
            return IntNum.make(((Number)arg).longValue());
        }
        else {
            if (arg instanceof Char) {
                return new IntNum(((Char)arg).intValue());
            }
            if (arg instanceof Character) {
                return new IntNum((char)arg);
            }
            return new DFloNum(Double.NaN);
        }
    }
    
    @Override
    public int format(final Object[] args, int start, final Appendable dst, final FieldPosition fpos) throws IOException {
        final int orig_start = start;
        boolean do_terminate;
        if (this.param1 == -1073741824) {
            do_terminate = (start == args.length);
        }
        else if (this.param2 == -1073741824 && this.param1 == 0) {
            do_terminate = true;
        }
        else {
            final Numeric arg1 = getParam(this.param1, args, start);
            if (this.param1 == -1610612736) {
                ++start;
            }
            if (this.param2 == -1073741824) {
                do_terminate = arg1.isZero();
            }
            else {
                final Numeric arg2 = getParam(this.param2, args, start);
                if (this.param2 == -1610612736) {
                    ++start;
                }
                if (this.param3 == -1073741824) {
                    do_terminate = arg1.equals(arg2);
                }
                else {
                    final Numeric arg3 = getParam(this.param3, args, start);
                    if (this.param3 == -1610612736) {
                        ++start;
                    }
                    do_terminate = (arg2.geq(arg1) && arg3.geq(arg2));
                }
            }
        }
        return ReportFormat.result(do_terminate ? (this.escapeAll ? 242 : 241) : 0, start);
    }
    
    static {
        alwaysTerminate = new LispEscapeFormat(0, -1073741824);
    }
}
