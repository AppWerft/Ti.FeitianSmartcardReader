/*
 * Decompiled with CFR 0.139.
 */
package kawa.standard;

import gnu.bytecode.ClassType;
import gnu.expr.Keyword;
import gnu.mapping.Procedure;
import gnu.mapping.ProcedureN;
import gnu.mapping.WrappedException;
import gnu.mapping.WrongArguments;
import gnu.mapping.WrongType;
import kawa.lang.Record;

public class make
extends ProcedureN {
    @Override
    public int numArgs() {
        return -4095;
    }

    @Override
    public Object applyN(Object[] args) {
        Object result;
        int nargs = args.length;
        if (nargs == 0) {
            throw new WrongArguments(this, nargs);
        }
        Object arg_0 = args[0];
        Class clas = arg_0 instanceof Class ? (Class)arg_0 : (arg_0 instanceof ClassType ? ((ClassType)arg_0).getReflectClass() : null);
        if (clas == null) {
            throw new WrongType((Procedure)this, 1, arg_0, "class");
        }
        try {
            result = clas.newInstance();
        }
        catch (Exception ex) {
            throw new WrappedException(ex);
        }
        int i = 1;
        while (i < nargs) {
            Keyword key = (Keyword)args[i++];
            Object arg = args[i++];
            Record.set1(arg, key.getName(), result);
        }
        return result;
    }
}

