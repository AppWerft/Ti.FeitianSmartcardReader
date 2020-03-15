// 
// Decompiled by Procyon v0.5.36
// 

package gnu.mapping;

public class WrongArguments extends IllegalArgumentException
{
    public int number;
    public String usage;
    public String procname;
    Procedure proc;
    
    public static String checkArgCount(final Procedure proc, final int argCount, final boolean hasSplices) {
        final int num = proc.numArgs();
        final int min = num & 0xFFF;
        final int max = num >> 12;
        String pname = proc.getName();
        if (pname == null) {
            pname = proc.getClass().getName();
        }
        return checkArgCount(pname, hasSplices ? 0 : min, max, argCount);
    }
    
    public static String checkArgCount(final String pname, final int min, final int max, final int argCount) {
        boolean tooMany;
        if (argCount < min) {
            tooMany = false;
        }
        else {
            if (max < 0 || argCount <= max) {
                return null;
            }
            tooMany = true;
        }
        final StringBuffer buf = new StringBuffer(100);
        buf.append("call to ");
        if (pname == null) {
            buf.append("unnamed procedure");
        }
        else {
            buf.append('\'');
            buf.append(pname);
            buf.append('\'');
        }
        buf.append(tooMany ? " has too many" : " has too few");
        buf.append(" arguments (");
        buf.append(argCount);
        if (min == max) {
            buf.append("; must be ");
            buf.append(min);
        }
        else {
            buf.append("; min=");
            buf.append(min);
            if (max >= 0) {
                buf.append(", max=");
                buf.append(max);
            }
        }
        buf.append(')');
        return buf.toString();
    }
    
    @Override
    public String getMessage() {
        if (this.proc != null) {
            final String msg = checkArgCount(this.proc, this.number, false);
            if (msg != null) {
                return msg;
            }
        }
        return super.getMessage();
    }
    
    public WrongArguments(final Procedure proc, final int argCount) {
        this.proc = proc;
        this.number = argCount;
    }
    
    public WrongArguments(final String name, final int n, final String u) {
        this.procname = name;
        this.number = n;
        this.usage = u;
    }
}
