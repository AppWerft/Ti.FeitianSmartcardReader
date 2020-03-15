// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.functions;

import java.io.ObjectInput;
import java.io.IOException;
import java.io.ObjectOutput;
import gnu.mapping.Values;
import gnu.kawa.reflect.SlotSet;
import gnu.mapping.Procedure;
import java.io.Externalizable;
import gnu.mapping.Procedure2;

class SetNamedInstancePart extends Procedure2 implements Externalizable
{
    String pname;
    
    public SetNamedInstancePart() {
        this.setProperty(Procedure.validateApplyKey, "gnu.kawa.functions.CompileNamedPart:validateSetNamedInstancePart");
    }
    
    public SetNamedInstancePart(final String name) {
        this();
        this.setPartName(name);
    }
    
    public void setPartName(final String name) {
        this.setName("set-instance-part:." + name);
        this.pname = name;
    }
    
    @Override
    public Object apply2(final Object instance, final Object value) throws Throwable {
        SlotSet.setField(instance, this.pname, value);
        return Values.empty;
    }
    
    @Override
    public void writeExternal(final ObjectOutput out) throws IOException {
        out.writeObject(this.pname);
    }
    
    @Override
    public void readExternal(final ObjectInput in) throws IOException, ClassNotFoundException {
        this.setPartName((String)in.readObject());
    }
}
