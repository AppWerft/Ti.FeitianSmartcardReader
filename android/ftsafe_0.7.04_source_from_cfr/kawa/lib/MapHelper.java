/*
 * Decompiled with CFR 0.139.
 */
package kawa.lib;

import gnu.bytecode.Type;
import gnu.expr.ApplyExp;
import gnu.expr.Compilation;
import gnu.expr.Expression;
import gnu.expr.ModuleMethod;
import gnu.kawa.functions.MakeSplice;
import gnu.mapping.Procedure;
import gnu.mapping.Promise;
import kawa.lib.ScanHelper;
import kawa.lib.kawa.expressions;

public abstract class MapHelper {
    public Compilation comp;
    public ScanHelper[] scanners;

    public abstract ScanHelper makeScanner(Expression var1, Type var2);

    public void initialize(ApplyExp applyExp, Compilation compilation) {
    }

    public Expression applyFunction(Object func, Object args) {
        int n = 1;
        Object object2 = args;
        int n2 = MakeSplice.count(object2);
        n = n2 + n;
        Object[] arrobject = new Object[n];
        arrobject[0] = func;
        int n3 = 1;
        MakeSplice.copyTo(arrobject, n3, n2, object2);
        n3 += n2;
        return (Expression)Promise.force(((Procedure)expressions.apply$Mnto$Mnargs$Mnexp).applyN(arrobject), Expression.class);
    }

    public Expression doCollect(Expression result) {
        return result;
    }

    public Expression collectResult(Expression result) {
        return result;
    }
}

