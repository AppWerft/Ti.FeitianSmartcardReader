/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.functions;

import gnu.bytecode.Type;
import gnu.expr.Language;
import gnu.kawa.lispexpr.LangObjType;
import gnu.mapping.Procedure;
import gnu.mapping.Procedure1;
import gnu.mapping.Promise;
import gnu.mapping.Symbol;
import gnu.mapping.WrongType;
import gnu.math.IntNum;
import gnu.math.Numeric;
import gnu.math.RealNum;

public class NumberPredicate
extends Procedure1 {
    public static final int ODD = 1;
    public static final int EVEN = 2;
    final int op;
    Language language;

    protected final Language getLanguage() {
        return this.language;
    }

    public static boolean isOdd(Object obj) {
        return NumberPredicate.isOddEven(true, obj);
    }

    public static boolean isEven(Object obj) {
        return NumberPredicate.isOddEven(false, obj);
    }

    public static boolean isOddEven(boolean isOdd, Object obj) {
        IntNum iarg = IntNum.asIntNumOrNull(obj = Promise.force(obj));
        if (iarg == null && obj instanceof Number && (obj instanceof RealNum || !(obj instanceof Numeric))) {
            double r = Math.IEEEremainder(((Number)obj).doubleValue(), 2.0);
            if (r == 0.0) {
                return !isOdd;
            }
            if (r == -1.0 || r == 1.0) {
                return isOdd;
            }
        }
        if (iarg == null) {
            throw new WrongType(-4, obj, LangObjType.integerType);
        }
        return iarg.isOdd() == isOdd;
    }

    @Override
    public Object apply1(Object arg1) {
        boolean result;
        switch (this.op) {
            case 1: {
                result = NumberPredicate.isOddEven(true, arg1);
                break;
            }
            case 2: {
                result = NumberPredicate.isOddEven(false, arg1);
                break;
            }
            default: {
                throw new Error();
            }
        }
        return this.getLanguage().booleanObject(result);
    }

    public NumberPredicate(Language language, String name, int op) {
        super(name);
        this.language = language;
        this.op = op;
        this.setProperty(Procedure.validateApplyKey, "gnu.kawa.functions.CompileMisc:validateApplySimpleBoolean");
        this.setProperty(Procedure.compilerXKey, "gnu.kawa.functions.CompileMisc:compileNumPredicate");
    }

    @Override
    public int numArgs() {
        return 4097;
    }
}

