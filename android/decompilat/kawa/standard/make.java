// 
// Decompiled by Procyon v0.5.36
// 

package kawa.standard;

import kawa.lang.Record;
import gnu.expr.Keyword;
import gnu.mapping.WrappedException;
import gnu.mapping.WrongType;
import gnu.bytecode.ClassType;
import gnu.mapping.Procedure;
import gnu.mapping.WrongArguments;
import gnu.mapping.ProcedureN;

public class make extends ProcedureN
{
    @Override
    public int numArgs() {
        return -4095;
    }
    
    @Override
    public Object applyN(final Object[] args) {
        final int nargs = args.length;
        if (nargs == 0) {
            throw new WrongArguments(this, nargs);
        }
        final Object arg_0 = args[0];
        Class clas;
        if (arg_0 instanceof Class) {
            clas = (Class)arg_0;
        }
        else if (arg_0 instanceof ClassType) {
            clas = ((ClassType)arg_0).getReflectClass();
        }
        else {
            clas = null;
        }
        if (clas == null) {
            throw new WrongType(this, 1, arg_0, "class");
        }
        Object result;
        try {
            result = clas.newInstance();
        }
        catch (Exception ex) {
            throw new WrappedException(ex);
        }
        int i = 1;
        while (i < nargs) {
            final Keyword key = (Keyword)args[i++];
            final Object arg = args[i++];
            Record.set1(arg, key.getName(), result);
        }
        return result;
    }
}
