// 
// Decompiled by Procyon v0.5.36
// 

package kawa.lang;

import gnu.kawa.format.ReportFormat;
import gnu.lists.Consumer;
import gnu.lists.LList;
import gnu.lists.Pair;

public class ListPat extends Pattern
{
    int min_length;
    int max_length;
    Object default_value;
    
    public ListPat(final int len) {
        this.min_length = len;
        this.max_length = len;
    }
    
    public ListPat(final int min, final int max) {
        this.min_length = min;
        this.max_length = max;
    }
    
    public ListPat(final int min, final int max, final Object default_val) {
        this.min_length = min;
        this.max_length = max;
        this.default_value = default_val;
    }
    
    public static boolean match(final int min, final int max, final Object default_val, Object obj, final Object[] vars, final int start_vars) {
        int i = 0;
        while (i < max) {
            if (obj instanceof Pair) {
                final Pair p = (Pair)obj;
                vars[start_vars + i] = p.getCar();
                obj = p.getCdr();
                ++i;
            }
            else {
                if (i < min) {
                    return false;
                }
                break;
            }
        }
        if (i == max && obj != LList.Empty) {
            return false;
        }
        while (i < max) {
            vars[start_vars + i] = default_val;
            ++i;
        }
        return true;
    }
    
    public static Object[] match(final int min, final int max, final Object default_val, final Object obj) {
        final Object[] vars = new Object[max];
        return (Object[])(match(min, max, default_val, obj, vars, 0) ? vars : null);
    }
    
    @Override
    public boolean match(final Object obj, final Object[] vars, final int start_vars) {
        return match(this.min_length, this.max_length, this.default_value, obj, vars, start_vars);
    }
    
    @Override
    public int varCount() {
        return this.max_length;
    }
    
    @Override
    public void print(final Consumer out) {
        out.write("#<list-pattern min:");
        out.write(Integer.toString(this.min_length));
        out.write(" max:");
        out.write(Integer.toString(this.max_length));
        out.write(" default:");
        ReportFormat.print(this.default_value, out);
        out.write(62);
    }
}
