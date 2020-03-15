// 
// Decompiled by Procyon v0.5.36
// 

package gnu.mapping;

import gnu.expr.Language;
import gnu.bytecode.Type;

public class WrongType extends WrappedException
{
    public int number;
    public static final int ARG_UNKNOWN = -1;
    public static final int ARG_VARNAME = -2;
    public static final int ARG_DESCRIPTION = -3;
    public static final int ARG_CAST = -4;
    public String procname;
    public Procedure proc;
    public Object argValue;
    public Object expectedType;
    
    public WrongType(final String name, final int n, final String u) {
        super(null, null);
        this.procname = name;
        this.number = n;
        this.expectedType = u;
    }
    
    public WrongType(final Procedure proc, final int n, final ClassCastException ex) {
        super(ex);
        this.proc = proc;
        this.procname = proc.getName();
        this.number = n;
    }
    
    public WrongType(final ClassCastException ex, final Procedure proc, final int n, final Object argValue) {
        this(proc, n, ex);
        this.argValue = argValue;
    }
    
    public WrongType(final Procedure proc, final int n, final Object argValue) {
        this.proc = proc;
        this.procname = proc.getName();
        this.number = n;
        this.argValue = argValue;
    }
    
    public WrongType(final Procedure proc, final int n, final Object argValue, final Type expectedType) {
        this.proc = proc;
        this.procname = proc.getName();
        this.number = n;
        this.argValue = argValue;
        this.expectedType = expectedType;
    }
    
    public WrongType(final int n, final Object argValue, final Type expectedType) {
        this.number = n;
        this.argValue = argValue;
        this.expectedType = expectedType;
    }
    
    public WrongType(final Procedure proc, final int n, final Object argValue, final String expectedType) {
        this(proc.getName(), n, argValue, expectedType);
        this.proc = proc;
    }
    
    public WrongType(final String procName, final int n, final Object argValue, final String expectedType) {
        this.procname = procName;
        this.number = n;
        this.argValue = argValue;
        this.expectedType = expectedType;
    }
    
    public WrongType(final String procname, final int n, final ClassCastException ex) {
        super(ex);
        this.procname = procname;
        this.number = n;
    }
    
    public WrongType(final ClassCastException ex, final String procname, final int n, final Object argValue) {
        this(procname, n, ex);
        this.argValue = argValue;
    }
    
    @Deprecated
    public static WrongType make(final ClassCastException ex, final Procedure proc, final int n) {
        return new WrongType(proc, n, ex);
    }
    
    @Deprecated
    public static WrongType make(final ClassCastException ex, final String procname, final int n) {
        return new WrongType(procname, n, ex);
    }
    
    public static WrongType make(final ClassCastException ex, final Procedure proc, final int n, final Object argValue) {
        final WrongType wex = new WrongType(proc, n, ex);
        wex.argValue = argValue;
        return wex;
    }
    
    public static WrongType make(final ClassCastException ex, final String procname, final int n, final Object argValue) {
        final WrongType wex = new WrongType(procname, n, ex);
        wex.argValue = argValue;
        return wex;
    }
    
    @Override
    public String getMessage() {
        final StringBuffer sbuf = new StringBuffer(100);
        if (this.number == -3) {
            sbuf.append(this.procname);
        }
        else if (this.number == -4 || this.number == -2) {
            sbuf.append("Value");
        }
        else {
            sbuf.append("Argument ");
            if (this.number > 0) {
                sbuf.append('#');
                sbuf.append(this.number);
            }
        }
        if (this.argValue != null) {
            sbuf.append(" '");
            final String argString = this.argValue.toString();
            if (argString.length() > 50) {
                sbuf.append(argString.substring(0, 47));
                sbuf.append("...");
            }
            else {
                sbuf.append(argString);
            }
            sbuf.append("'");
        }
        if (this.procname != null && this.number != -3) {
            sbuf.append((this.number == -2) ? " for variable '" : " to '");
            sbuf.append(this.procname);
            sbuf.append("'");
        }
        sbuf.append(" has wrong type");
        if (this.argValue != null) {
            sbuf.append(" (");
            final Class wrongClass = this.argValue.getClass();
            final Language currentLang = Language.getDefaultLanguage();
            final String wrongClassname = (currentLang == null) ? wrongClass.getName() : currentLang.formatType(currentLang.getTypeFor(wrongClass));
            sbuf.append(wrongClassname);
            sbuf.append(")");
        }
        Object expectType = this.expectedType;
        if (expectType == null && this.number > 0 && this.proc instanceof MethodProc) {
            expectType = ((MethodProc)this.proc).getParameterType(this.number - 1);
        }
        if (expectType != null && expectType != Type.pointer_type) {
            sbuf.append(" (expected: ");
            if (expectType instanceof Type) {
                expectType = ((Type)expectType).getName();
            }
            else if (expectType instanceof Class) {
                expectType = ((Class)expectType).getName();
            }
            sbuf.append(expectType);
            sbuf.append(")");
        }
        final Throwable ex = this.getCause();
        if (ex != null) {
            final String msg = ex.getMessage();
            if (msg != null) {
                sbuf.append(" (");
                sbuf.append(msg);
                sbuf.append(')');
            }
        }
        return sbuf.toString();
    }
}
