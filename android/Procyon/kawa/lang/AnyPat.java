// 
// Decompiled by Procyon v0.5.36
// 

package kawa.lang;

import java.io.ObjectInput;
import java.io.IOException;
import java.io.ObjectOutput;
import gnu.lists.Consumer;
import java.io.Externalizable;
import gnu.kawa.format.Printable;

public class AnyPat extends Pattern implements Printable, Externalizable
{
    public static AnyPat make() {
        return new AnyPat();
    }
    
    @Override
    public void print(final Consumer out) {
        out.write("#<match any>");
    }
    
    @Override
    public boolean match(final Object obj, final Object[] vars, final int start_vars) {
        vars[start_vars] = obj;
        return true;
    }
    
    @Override
    public int varCount() {
        return 1;
    }
    
    @Override
    public void writeExternal(final ObjectOutput out) throws IOException {
    }
    
    @Override
    public void readExternal(final ObjectInput in) throws IOException, ClassNotFoundException {
    }
}
