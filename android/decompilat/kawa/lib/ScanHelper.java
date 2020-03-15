// 
// Decompiled by Procyon v0.5.36
// 

package kawa.lib;

import gnu.expr.QuoteExp;
import gnu.expr.Declaration;
import gnu.expr.Expression;
import gnu.expr.Compilation;

public abstract class ScanHelper
{
    public Compilation comp;
    
    public abstract void init(final Expression p0);
    
    public abstract Expression test();
    
    public abstract Declaration eval();
    
    public Expression incr(final Declaration value) {
        return QuoteExp.voidExp;
    }
}
