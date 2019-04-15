/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.functions;

import gnu.kawa.reflect.SlotSet;
import gnu.mapping.Procedure;
import gnu.mapping.Procedure2;
import gnu.mapping.Symbol;
import gnu.mapping.Values;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

class SetNamedInstancePart
extends Procedure2
implements Externalizable {
    String pname;

    public SetNamedInstancePart() {
        this.setProperty(Procedure.validateApplyKey, "gnu.kawa.functions.CompileNamedPart:validateSetNamedInstancePart");
    }

    public SetNamedInstancePart(String name) {
        this();
        this.setPartName(name);
    }

    public void setPartName(String name) {
        this.setName("set-instance-part:." + name);
        this.pname = name;
    }

    @Override
    public Object apply2(Object instance, Object value) throws Throwable {
        SlotSet.setField(instance, this.pname, value);
        return Values.empty;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(this.pname);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        this.setPartName((String)in.readObject());
    }
}

