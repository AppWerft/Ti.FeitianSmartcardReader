// 
// Decompiled by Procyon v0.5.36
// 

package kawa.lang;

import java.io.ObjectInput;
import java.io.IOException;
import java.io.ObjectOutput;
import gnu.kawa.format.ReportFormat;
import gnu.lists.Consumer;
import gnu.mapping.Symbol;
import java.io.Externalizable;
import gnu.kawa.format.Printable;

public class EqualPat extends Pattern implements Printable, Externalizable
{
    Object value;
    
    public EqualPat() {
    }
    
    public EqualPat(final Object obj) {
        this.value = obj;
    }
    
    public static EqualPat make(final Object obj) {
        return new EqualPat(obj);
    }
    
    @Override
    public boolean match(Object obj, final Object[] vars, final int start_vars) {
        if (this.value instanceof String && obj instanceof Symbol) {
            obj = ((Symbol)obj).getName();
        }
        return this.value.equals(obj);
    }
    
    @Override
    public int varCount() {
        return 0;
    }
    
    @Override
    public void print(final Consumer out) {
        out.write("#<equals: ");
        ReportFormat.print(this.value, out);
        out.write(62);
    }
    
    @Override
    public void writeExternal(final ObjectOutput out) throws IOException {
        out.writeObject(this.value);
    }
    
    @Override
    public void readExternal(final ObjectInput in) throws IOException, ClassNotFoundException {
        this.value = in.readObject();
    }
}
