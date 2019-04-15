/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.functions;

import gnu.kawa.format.ReportFormat;
import gnu.math.DFloNum;
import gnu.math.IntNum;
import gnu.math.Numeric;
import gnu.text.Char;
import java.io.IOException;
import java.text.FieldPosition;

class LispEscapeFormat
extends ReportFormat {
    int param1;
    int param2;
    int param3;
    boolean escapeAll;
    public static final LispEscapeFormat alwaysTerminate = new LispEscapeFormat(0, -1073741824);
    public static final int ESCAPE_NORMAL = 241;
    public static final int ESCAPE_ALL = 242;

    public LispEscapeFormat(int param1, int param2) {
        this.param1 = param1;
        this.param2 = param2;
        this.param3 = -1073741824;
    }

    public LispEscapeFormat(int param1, int param2, int param3) {
        this.param1 = param1;
        this.param2 = param2;
        this.param3 = param3;
    }

    static Numeric getParam(int param, Object[] args, int start) {
        if (param == -1342177280) {
            return IntNum.make(args.length - start);
        }
        if (param == -1610612736) {
            Object arg = args[start];
            if (arg instanceof Numeric) {
                return (Numeric)arg;
            }
            if (arg instanceof Number) {
                if (arg instanceof Float || arg instanceof Double) {
                    return new DFloNum(((Number)arg).doubleValue());
                }
                return IntNum.make(((Number)arg).longValue());
            }
            if (arg instanceof Char) {
                return new IntNum(((Char)arg).intValue());
            }
            if (arg instanceof Character) {
                return new IntNum(((Character)arg).charValue());
            }
            return new DFloNum(Double.NaN);
        }
        return IntNum.make(param);
    }

    @Override
    public int format(Object[] args, int start, Appendable dst, FieldPosition fpos) throws IOException {
        boolean do_terminate;
        int orig_start = start;
        if (this.param1 == -1073741824) {
            do_terminate = start == args.length;
        } else if (this.param2 == -1073741824 && this.param1 == 0) {
            do_terminate = true;
        } else {
            Numeric arg1 = LispEscapeFormat.getParam(this.param1, args, start);
            if (this.param1 == -1610612736) {
                ++start;
            }
            if (this.param2 == -1073741824) {
                do_terminate = arg1.isZero();
            } else {
                Numeric arg2 = LispEscapeFormat.getParam(this.param2, args, start);
                if (this.param2 == -1610612736) {
                    ++start;
                }
                if (this.param3 == -1073741824) {
                    do_terminate = arg1.equals(arg2);
                } else {
                    Numeric arg3 = LispEscapeFormat.getParam(this.param3, args, start);
                    if (this.param3 == -1610612736) {
                        ++start;
                    }
                    boolean bl = do_terminate = arg2.geq(arg1) && arg3.geq(arg2);
                }
            }
        }
        return LispEscapeFormat.result(!do_terminate ? 0 : (this.escapeAll ? 242 : 241), start);
    }
}

