/*
 * Decompiled with CFR 0.139.
 */
package gnu.mapping;

import gnu.bytecode.ArrayType;
import gnu.bytecode.ClassType;
import gnu.bytecode.ObjectType;
import gnu.bytecode.Type;
import gnu.mapping.CallContext;
import gnu.mapping.Procedure;
import gnu.mapping.ProcedureN;
import gnu.mapping.WrongArguments;
import gnu.mapping.WrongType;

public abstract class MethodProc
extends ProcedureN {
    protected Object argTypes;
    static final Type[] unknownArgTypes = new Type[]{Type.pointer_type};
    public static final int NO_MATCH = -1;
    public static final int NO_MATCH_TOO_FEW_ARGS = -983040;
    public static final int NO_MATCH_TOO_MANY_ARGS = -917504;
    public static final int NO_MATCH_AMBIGUOUS = -851968;
    public static final int NO_MATCH_BAD_TYPE = -786432;

    public int isApplicable(Type[] argTypes, Type restType) {
        int argCount = argTypes.length;
        int num = this.numArgs();
        int min = Procedure.minArgs(num);
        int max = Procedure.maxArgs(num);
        if (argCount < min && restType == null || num >= 0 && argCount > max) {
            return -1;
        }
        int result = 1;
        for (int i = 0; i < argCount || restType != null && i < min; ++i) {
            int code;
            boolean toStringTypeHack;
            Type ptype = this.getParameterType(i);
            boolean bl = toStringTypeHack = ptype == Type.toStringType;
            if (toStringTypeHack) {
                ptype = Type.javalangStringType;
            }
            if ((code = ptype.compare(i < argCount ? argTypes[i] : restType)) == -3) {
                if (toStringTypeHack) {
                    result = 0;
                    continue;
                }
                return -1;
            }
            if (code >= 0) continue;
            result = 0;
        }
        return result;
    }

    public int numParameters() {
        int num = this.numArgs();
        int max = num >> 12;
        if (max >= 0) {
            return max;
        }
        int min = num & 4095;
        return min + 1;
    }

    protected void resolveParameterTypes() {
        this.argTypes = unknownArgTypes;
    }

    public Type getParameterType(int index) {
        Type rtype;
        Type[] atypes;
        if (!(this.argTypes instanceof Type[])) {
            this.resolveParameterTypes();
        }
        if (index < (atypes = (Type[])this.argTypes).length && (index < atypes.length - 1 || this.maxArgs() >= 0)) {
            return atypes[index];
        }
        if (this.maxArgs() < 0 && (rtype = atypes[atypes.length - 1]) instanceof ArrayType) {
            return ((ArrayType)rtype).getComponentType();
        }
        return Type.objectType;
    }

    public static RuntimeException matchFailAsException(int code, Procedure proc, Object[] args) {
        short arg = (short)code;
        if ((code &= -65536) != -786432) {
            return new WrongArguments(proc, args.length);
        }
        return new WrongType(proc, (int)arg, arg > 0 ? args[arg - 1] : null);
    }

    @Override
    public Object applyN(Object[] args) throws Throwable {
        MethodProc.checkArgCount(this, args.length);
        CallContext ctx = CallContext.getInstance();
        this.checkN(args, ctx);
        return ctx.runUntilValue();
    }

    public static MethodProc mostSpecific(MethodProc proc1, MethodProc proc2) {
        int limit;
        int num2;
        boolean not1 = false;
        boolean not2 = false;
        int min1 = proc1.minArgs();
        int min2 = proc2.minArgs();
        int max1 = proc1.maxArgs();
        int max2 = proc2.maxArgs();
        if (max1 >= 0 && max1 < min2 || max2 >= 0 && max2 < min1) {
            return null;
        }
        int num1 = proc1.numParameters();
        int n = limit = num1 < (num2 = proc2.numParameters()) ? num1 : num2;
        if (max1 != max2) {
            if (max1 < 0) {
                not1 = true;
            }
            if (max2 < 0) {
                not2 = true;
            }
        }
        if (min1 < min2) {
            not1 = true;
        } else if (min1 > min2) {
            not2 = true;
        }
        for (int i = 0; i < limit; ++i) {
            Type t2;
            Type t1 = proc1.getParameterType(i);
            int comp = t1.compare(t2 = proc2.getParameterType(i));
            if (comp == -1) {
                not2 = true;
                if (not1) {
                    return null;
                }
            }
            if (comp != 1) continue;
            not1 = true;
            if (!not2) continue;
            return null;
        }
        return not2 ? proc1 : (not1 ? proc2 : null);
    }

    public static boolean overrideEquivalent(MethodProc proc1, MethodProc proc2) {
        int num2;
        int num1 = proc1.numParameters();
        if (num1 != (num2 = proc2.numParameters())) {
            return false;
        }
        for (int i = 1; i < num1; ++i) {
            Type t2;
            Type t1 = proc1.getParameterType(i);
            if (t1.compare(t2 = proc2.getParameterType(i)) == 0) continue;
            return false;
        }
        return true;
    }
}

