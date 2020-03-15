// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.functions;

import gnu.mapping.Procedure;
import gnu.mapping.Symbol;
import gnu.kawa.reflect.SlotSet;
import gnu.bytecode.Type;
import gnu.bytecode.ClassType;
import gnu.mapping.Values;
import gnu.mapping.Environment;
import gnu.mapping.Namespace;
import gnu.mapping.HasSetter;
import gnu.mapping.Procedure3;

public class SetNamedPart extends Procedure3 implements HasSetter
{
    public static final SetNamedPart setNamedPart;
    
    @Override
    public Object apply3(Object container, final Object part, final Object value) {
        if (container instanceof Namespace) {
            final Namespace ns = (Namespace)container;
            final String uri = ns.getName();
            if (!uri.startsWith("class:")) {
                final Symbol sym = ns.getSymbol(part.toString());
                final Environment env = Environment.getCurrent();
                Environment.getCurrent().put(sym, value);
                return Values.empty;
            }
            container = ClassType.make(uri.substring(6));
        }
        if (container instanceof Class) {
            container = Type.make((Class)container);
        }
        if (container instanceof ClassType) {
            try {
                SlotSet.setStaticField(container, part.toString(), value);
                return Values.empty;
            }
            catch (Exception ex) {}
        }
        SlotSet.setField(container, part.toString(), value);
        return Values.empty;
    }
    
    static {
        (setNamedPart = new SetNamedPart()).setName("setNamedPart");
        SetNamedPart.setNamedPart.setProperty(Procedure.validateApplyKey, "gnu.kawa.functions.CompileNamedPart:validateSetNamedPart");
    }
}
