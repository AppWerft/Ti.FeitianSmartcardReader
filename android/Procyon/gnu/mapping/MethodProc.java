// 
// Decompiled by Procyon v0.5.36
// 

package gnu.mapping;

import gnu.bytecode.ArrayType;
import gnu.bytecode.Type;

public abstract class MethodProc extends ProcedureN
{
    protected Object argTypes;
    static final Type[] unknownArgTypes;
    public static final int NO_MATCH = -1;
    public static final int NO_MATCH_TOO_FEW_ARGS = -983040;
    public static final int NO_MATCH_TOO_MANY_ARGS = -917504;
    public static final int NO_MATCH_AMBIGUOUS = -851968;
    public static final int NO_MATCH_BAD_TYPE = -786432;
    
    public int isApplicable(final Type[] argTypes, final Type restType) {
        final int argCount = argTypes.length;
        final int num = this.numArgs();
        final int min = Procedure.minArgs(num);
        final int max = Procedure.maxArgs(num);
        if ((argCount < min && restType == null) || (num >= 0 && argCount > max)) {
            return -1;
        }
        int result = 1;
        for (int i = 0; i < argCount || (restType != null && i < min); ++i) {
            Type ptype = this.getParameterType(i);
            final boolean toStringTypeHack = ptype == Type.toStringType;
            if (toStringTypeHack) {
                ptype = Type.javalangStringType;
            }
            final int code = ptype.compare((i < argCount) ? argTypes[i] : restType);
            if (code == -3) {
                if (!toStringTypeHack) {
                    return -1;
                }
                result = 0;
            }
            else if (code < 0) {
                result = 0;
            }
        }
        return result;
    }
    
    public int numParameters() {
        final int num = this.numArgs();
        final int max = num >> 12;
        if (max >= 0) {
            return max;
        }
        final int min = num & 0xFFF;
        return min + 1;
    }
    
    protected void resolveParameterTypes() {
        this.argTypes = MethodProc.unknownArgTypes;
    }
    
    public Type getParameterType(final int index) {
        if (!(this.argTypes instanceof Type[])) {
            this.resolveParameterTypes();
        }
        final Type[] atypes = (Type[])this.argTypes;
        if (index < atypes.length && (index < atypes.length - 1 || this.maxArgs() >= 0)) {
            return atypes[index];
        }
        if (this.maxArgs() < 0) {
            final Type rtype = atypes[atypes.length - 1];
            if (rtype instanceof ArrayType) {
                return ((ArrayType)rtype).getComponentType();
            }
        }
        return Type.objectType;
    }
    
    public static RuntimeException matchFailAsException(int code, final Procedure proc, final Object[] args) {
        final int arg = (short)code;
        code &= 0xFFFF0000;
        if (code != -786432) {
            return new WrongArguments(proc, args.length);
        }
        return new WrongType(proc, arg, (arg > 0) ? args[arg - 1] : null);
    }
    
    @Override
    public Object applyN(final Object[] args) throws Throwable {
        Procedure.checkArgCount(this, args.length);
        final CallContext ctx = CallContext.getInstance();
        this.checkN(args, ctx);
        return ctx.runUntilValue();
    }
    
    public static MethodProc mostSpecific(final MethodProc proc1, final MethodProc proc2) {
        boolean not1 = false;
        boolean not2 = false;
        final int min1 = proc1.minArgs();
        final int min2 = proc2.minArgs();
        final int max1 = proc1.maxArgs();
        final int max2 = proc2.maxArgs();
        if ((max1 >= 0 && max1 < min2) || (max2 >= 0 && max2 < min1)) {
            return null;
        }
        final int num1 = proc1.numParameters();
        final int num2 = proc2.numParameters();
        final int limit = (num1 < num2) ? num1 : num2;
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
        }
        else if (min1 > min2) {
            not2 = true;
        }
        for (int i = 0; i < limit; ++i) {
            final Type t1 = proc1.getParameterType(i);
            final Type t2 = proc2.getParameterType(i);
            final int comp = t1.compare(t2);
            if (comp == -1) {
                not2 = true;
                if (not1) {
                    return null;
                }
            }
            if (comp == 1) {
                not1 = true;
                if (not2) {
                    return null;
                }
            }
        }
        return not2 ? proc1 : (not1 ? proc2 : null);
    }
    
    public static boolean overrideEquivalent(final MethodProc proc1, final MethodProc proc2) {
        final int num1 = proc1.numParameters();
        final int num2 = proc2.numParameters();
        if (num1 != num2) {
            return false;
        }
        for (int i = 1; i < num1; ++i) {
            final Type t1 = proc1.getParameterType(i);
            final Type t2 = proc2.getParameterType(i);
            if (t1.compare(t2) != 0) {
                return false;
            }
        }
        return true;
    }
    
    static {
        unknownArgTypes = new Type[] { Type.pointer_type };
    }
}
