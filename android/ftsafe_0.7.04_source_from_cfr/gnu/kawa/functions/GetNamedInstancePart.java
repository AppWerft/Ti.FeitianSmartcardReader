/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.functions;

import gnu.kawa.functions.SetNamedInstancePart;
import gnu.kawa.reflect.Invoke;
import gnu.kawa.reflect.SlotGet;
import gnu.mapping.HasSetter;
import gnu.mapping.Procedure;
import gnu.mapping.ProcedureN;
import gnu.mapping.Symbol;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class GetNamedInstancePart
extends ProcedureN
implements Externalizable,
HasSetter {
    String pname;
    boolean isField;

    public GetNamedInstancePart() {
        this.setProperty(Procedure.validateApplyKey, "gnu.kawa.functions.CompileNamedPart:validateGetNamedInstancePart");
    }

    public GetNamedInstancePart(String name) {
        this();
        this.setPartName(name);
    }

    public void setPartName(String name) {
        this.setName("get-instance-part:" + name);
        if (name.length() > 1 && name.charAt(0) == '.') {
            this.isField = true;
            this.pname = name.substring(1);
        } else {
            this.isField = false;
            this.pname = name;
        }
    }

    @Override
    public int numArgs() {
        return this.isField ? 4097 : -4095;
    }

    @Override
    public Object applyN(Object[] args) throws Throwable {
        GetNamedInstancePart.checkArgCount(this, args.length);
        if (this.isField) {
            return SlotGet.field(args[0], this.pname);
        }
        Object[] xargs = new Object[args.length + 1];
        xargs[0] = args[0];
        xargs[1] = this.pname;
        System.arraycopy(args, 1, xargs, 2, args.length - 1);
        return Invoke.invoke.applyN(xargs);
    }

    @Override
    public Procedure getSetter() {
        if (!this.isField) {
            throw new RuntimeException("no setter for instance method call");
        }
        return new SetNamedInstancePart(this.pname);
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(this.isField ? "." + this.pname : this.pname);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        this.setPartName((String)in.readObject());
    }
}

