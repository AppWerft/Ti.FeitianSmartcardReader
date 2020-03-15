// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.functions;

import gnu.mapping.Procedure;
import gnu.bytecode.Type;
import gnu.mapping.WrongType;
import gnu.kawa.lispexpr.LangObjType;
import gnu.math.Numeric;
import gnu.math.RealNum;
import gnu.math.IntNum;
import gnu.mapping.Promise;
import gnu.expr.Language;
import gnu.mapping.Procedure1;

public class NumberPredicate extends Procedure1
{
    public static final int ODD = 1;
    public static final int EVEN = 2;
    final int op;
    Language language;
    
    protected final Language getLanguage() {
        return this.language;
    }
    
    public static boolean isOdd(final Object obj) {
        return isOddEven(true, obj);
    }
    
    public static boolean isEven(final Object obj) {
        return isOddEven(false, obj);
    }
    
    public static boolean isOddEven(final boolean isOdd, Object obj) {
        obj = Promise.force(obj);
        final IntNum iarg = IntNum.asIntNumOrNull(obj);
        if (iarg == null && obj instanceof Number && (obj instanceof RealNum || !(obj instanceof Numeric))) {
            final double r = Math.IEEEremainder(((Number)obj).doubleValue(), 2.0);
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
    public Object apply1(final Object arg1) {
        boolean result = false;
        switch (this.op) {
            case 1: {
                result = isOddEven(true, arg1);
                break;
            }
            case 2: {
                result = isOddEven(false, arg1);
                break;
            }
            default: {
                throw new Error();
            }
        }
        return this.getLanguage().booleanObject(result);
    }
    
    public NumberPredicate(final Language language, final String name, final int op) {
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
