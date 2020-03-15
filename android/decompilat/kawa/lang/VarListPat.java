// 
// Decompiled by Procyon v0.5.36
// 

package kawa.lang;

import gnu.lists.Consumer;
import gnu.lists.Pair;

public class VarListPat extends Pattern
{
    int min_length;
    
    public VarListPat(final int min) {
        this.min_length = min;
    }
    
    @Override
    public boolean match(Object obj, final Object[] vars, final int start_vars) {
        int i;
        for (i = 0; i < this.min_length; ++i) {
            if (!(obj instanceof Pair)) {
                return false;
            }
            final Pair p = (Pair)obj;
            vars[start_vars + i] = p.getCar();
            obj = p.getCdr();
        }
        vars[start_vars + i] = obj;
        return true;
    }
    
    @Override
    public int varCount() {
        return this.min_length + 1;
    }
    
    @Override
    public void print(final Consumer out) {
        out.write("#<varlist-pattern min:");
        out.writeInt(this.min_length);
        out.write(62);
    }
}
