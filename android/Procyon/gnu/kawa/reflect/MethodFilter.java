// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.reflect;

import gnu.bytecode.Method;
import gnu.bytecode.ObjectType;
import gnu.bytecode.ClassType;
import gnu.bytecode.Filter;

class MethodFilter implements Filter
{
    String name;
    int nlen;
    int modifiers;
    int modmask;
    ClassType caller;
    ObjectType receiver;
    
    public MethodFilter(final String name, final int modifiers, final int modmask, final ClassType caller, final ObjectType receiver) {
        this.name = name;
        this.nlen = name.length();
        this.modifiers = modifiers;
        this.modmask = modmask;
        this.caller = caller;
        this.receiver = receiver;
    }
    
    @Override
    public boolean select(final Object value) {
        final Method method = (Method)value;
        final String mname = method.getName();
        final int mmods = method.getModifiers();
        if ((mmods & this.modmask) != this.modifiers || (mmods & 0x1000) != 0x0 || !mname.startsWith(this.name)) {
            return false;
        }
        final int mlen = mname.length();
        final char c;
        if (mlen != this.nlen && (mlen != this.nlen + 2 || mname.charAt(this.nlen) != '$' || ((c = mname.charAt(this.nlen + 1)) != 'V' && c != 'X')) && (mlen != this.nlen + 4 || !mname.endsWith("$V$X"))) {
            return false;
        }
        final ClassType declaring = (ClassType)((this.receiver instanceof ClassType) ? this.receiver : method.getDeclaringClass());
        return this.caller == null || this.caller.isAccessible(declaring, this.receiver, method.getModifiers());
    }
}
