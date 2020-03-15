// 
// Decompiled by Procyon v0.5.36
// 

package kawa.lang;

import java.io.ObjectInput;
import java.io.IOException;
import java.io.ObjectOutput;
import gnu.lists.Pair;
import gnu.lists.LList;
import gnu.lists.Consumer;
import java.io.Externalizable;
import gnu.kawa.format.Printable;

public class ListRepeatPat extends Pattern implements Printable, Externalizable
{
    Pattern element_pattern;
    
    public ListRepeatPat() {
    }
    
    public ListRepeatPat(final Pattern element_pattern) {
        this.element_pattern = element_pattern;
    }
    
    public static ListRepeatPat make(final Pattern element_pattern) {
        return new ListRepeatPat(element_pattern);
    }
    
    @Override
    public void print(final Consumer out) {
        out.write("#<list-repeat-pattern ");
        this.element_pattern.print(out);
        out.write(62);
    }
    
    @Override
    public boolean match(Object obj, final Object[] vars, final int start_vars) {
        final int length = LList.listLength(obj, false);
        if (length < 0) {
            return false;
        }
        int i;
        final int var_count = i = this.element_pattern.varCount();
        while (--i >= 0) {
            vars[start_vars + i] = new Object[length];
        }
        final Object[] element_vars = new Object[var_count];
        for (int j = 0; j < length; ++j) {
            final Pair pair = (Pair)obj;
            if (!this.element_pattern.match(pair.getCar(), element_vars, 0)) {
                return false;
            }
            for (int k = 0; k < var_count; ++k) {
                ((Object[])vars[start_vars + k])[j] = element_vars[k];
            }
            obj = pair.getCdr();
        }
        return true;
    }
    
    @Override
    public int varCount() {
        return this.element_pattern.varCount();
    }
    
    @Override
    public void writeExternal(final ObjectOutput out) throws IOException {
        out.writeObject(this.element_pattern);
    }
    
    @Override
    public void readExternal(final ObjectInput in) throws IOException, ClassNotFoundException {
        this.element_pattern = (Pattern)in.readObject();
    }
}
