/*
 * Decompiled with CFR 0.139.
 */
package kawa.lang;

import gnu.kawa.format.ReportFormat;
import gnu.lists.Consumer;
import gnu.lists.EmptyList;
import gnu.lists.LList;
import gnu.lists.Pair;
import kawa.lang.Pattern;

public class ListPat
extends Pattern {
    int min_length;
    int max_length;
    Object default_value;

    public ListPat(int len) {
        this.min_length = len;
        this.max_length = len;
    }

    public ListPat(int min, int max) {
        this.min_length = min;
        this.max_length = max;
    }

    public ListPat(int min, int max, Object default_val) {
        this.min_length = min;
        this.max_length = max;
        this.default_value = default_val;
    }

    public static boolean match(int min, int max, Object default_val, Object obj, Object[] vars, int start_vars) {
        int i;
        for (i = 0; i < max; ++i) {
            if (!(obj instanceof Pair)) {
                if (i >= min) break;
                return false;
            }
            Pair p = (Pair)obj;
            vars[start_vars + i] = p.getCar();
            obj = p.getCdr();
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

    public static Object[] match(int min, int max, Object default_val, Object obj) {
        Object[] vars = new Object[max];
        return ListPat.match(min, max, default_val, obj, vars, 0) ? vars : null;
    }

    @Override
    public boolean match(Object obj, Object[] vars, int start_vars) {
        return ListPat.match(this.min_length, this.max_length, this.default_value, obj, vars, start_vars);
    }

    @Override
    public int varCount() {
        return this.max_length;
    }

    @Override
    public void print(Consumer out) {
        out.write("#<list-pattern min:");
        out.write(Integer.toString(this.min_length));
        out.write(" max:");
        out.write(Integer.toString(this.max_length));
        out.write(" default:");
        ReportFormat.print(this.default_value, out);
        out.write(62);
    }
}

