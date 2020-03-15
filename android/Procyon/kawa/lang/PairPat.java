// 
// Decompiled by Procyon v0.5.36
// 

package kawa.lang;

import java.io.ObjectInput;
import java.io.IOException;
import java.io.ObjectOutput;
import gnu.lists.Consumer;
import gnu.lists.Pair;
import java.io.Externalizable;
import gnu.kawa.format.Printable;

public class PairPat extends Pattern implements Printable, Externalizable
{
    Pattern car;
    Pattern cdr;
    private int car_count;
    private int cdr_count;
    
    public PairPat() {
    }
    
    public PairPat(final Pattern car, final Pattern cdr) {
        this.car = car;
        this.cdr = cdr;
        this.car_count = car.varCount();
        this.cdr_count = cdr.varCount();
    }
    
    public static PairPat make(final Pattern car, final Pattern cdr) {
        return new PairPat(car, cdr);
    }
    
    @Override
    public boolean match(final Object obj, final Object[] vars, final int start_vars) {
        if (!(obj instanceof Pair)) {
            return false;
        }
        final Pair pair = (Pair)obj;
        return this.car.match(pair.getCar(), vars, start_vars) && this.cdr.match(pair.getCdr(), vars, start_vars + this.car_count);
    }
    
    @Override
    public void print(final Consumer out) {
        out.write("#<pair-pattern car: ");
        this.car.print(out);
        out.write(" cdr: ");
        this.cdr.print(out);
        out.write(62);
    }
    
    @Override
    public int varCount() {
        return this.car_count + this.cdr_count;
    }
    
    @Override
    public void writeExternal(final ObjectOutput out) throws IOException {
        out.writeObject(this.car);
        out.writeObject(this.cdr);
    }
    
    @Override
    public void readExternal(final ObjectInput in) throws IOException, ClassNotFoundException {
        this.car = (Pattern)in.readObject();
        this.cdr = (Pattern)in.readObject();
    }
}
