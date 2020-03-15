// 
// Decompiled by Procyon v0.5.36
// 

package gnu.expr;

import gnu.lists.Sequence;
import java.io.ObjectStreamException;
import java.io.ObjectInput;
import java.io.IOException;
import java.io.ObjectOutput;
import gnu.lists.Consumer;
import java.io.Externalizable;
import gnu.kawa.format.Printable;

public class Special implements Printable, Externalizable
{
    private String name;
    public static final Special undefined;
    public static final Special optional;
    public static final Special rest;
    public static final Special key;
    public static final Special dfault;
    public static final Special abstractSpecial;
    public static final Special nativeSpecial;
    public static final Object eof;
    public static final RuntimeException reachedUnexpected;
    
    public Special() {
    }
    
    private Special(final String n) {
        this.name = new String(n);
    }
    
    public static Special make(final String name) {
        if (name == "optional") {
            return Special.optional;
        }
        if (name == "rest") {
            return Special.rest;
        }
        if (name == "key") {
            return Special.key;
        }
        if (name == "default") {
            return Special.dfault;
        }
        return new Special(name);
    }
    
    @Override
    public int hashCode() {
        return this.name.hashCode();
    }
    
    @Override
    public final String toString() {
        return "#!" + this.name;
    }
    
    @Override
    public void print(final Consumer out) {
        out.write("#!");
        out.write(this.name);
    }
    
    @Override
    public void writeExternal(final ObjectOutput out) throws IOException {
        out.writeUTF(this.name);
    }
    
    @Override
    public void readExternal(final ObjectInput in) throws IOException, ClassNotFoundException {
        this.name = in.readUTF();
    }
    
    public Object readResolve() throws ObjectStreamException {
        return make(this.name);
    }
    
    static {
        undefined = new Special("undefined");
        optional = new Special("optional");
        rest = new Special("rest");
        key = new Special("key");
        dfault = new Special("default");
        abstractSpecial = new Special("abstract");
        nativeSpecial = new Special("native");
        eof = Sequence.eofValue;
        reachedUnexpected = new RuntimeException("not supposed to reach this point");
    }
}
