// 
// Decompiled by Procyon v0.5.36
// 

package kawa.lib;

import gnu.expr.ModuleMethod;
import gnu.mapping.Promise;
import gnu.kawa.functions.MakeSplice;
import kawa.lib.kawa.expressions;
import gnu.expr.ApplyExp;
import gnu.bytecode.Type;
import gnu.expr.Expression;
import gnu.expr.Compilation;

public abstract class MapHelper
{
    public Compilation comp;
    public ScanHelper[] scanners;
    
    public abstract ScanHelper makeScanner(final Expression p0, final Type p1);
    
    public void initialize(final ApplyExp applyExp, final Compilation compilation) {
    }
    
    public Expression applyFunction(final Object func, final Object args) {
        final ModuleMethod apply$Mnto$Mnargs$Mnexp = expressions.apply$Mnto$Mnargs$Mnexp;
        final int count;
        final Object[] target = new Object[(count = MakeSplice.count(args)) + 1];
        target[0] = func;
        MakeSplice.copyTo(target, 1, count, args);
        return (Expression)Promise.force(apply$Mnto$Mnargs$Mnexp.applyN(target), Expression.class);
    }
    
    public Expression doCollect(final Expression result) {
        return result;
    }
    
    public Expression collectResult(final Expression result) {
        return result;
    }
}
