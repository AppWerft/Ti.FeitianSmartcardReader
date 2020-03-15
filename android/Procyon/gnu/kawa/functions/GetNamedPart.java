// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.functions;

import gnu.mapping.MethodProc;
import gnu.expr.Language;
import gnu.expr.Mangling;
import gnu.mapping.HasNamedParts;
import gnu.mapping.Promise;
import gnu.mapping.Procedure;
import gnu.kawa.reflect.ClassMethods;
import gnu.kawa.reflect.SlotGet;
import gnu.bytecode.ClassType;
import gnu.bytecode.ObjectType;
import gnu.bytecode.Type;
import gnu.mapping.Namespace;
import gnu.mapping.Symbol;
import gnu.mapping.Values;
import gnu.mapping.HasSetter;
import gnu.mapping.Procedure2;

public class GetNamedPart extends Procedure2 implements HasSetter
{
    public static final GetNamedPart getNamedPart;
    public static final String CLASSTYPE_FOR = "<>";
    public static final String CAST_METHOD_NAME = "@";
    public static final String INSTANCEOF_METHOD_NAME = "instance?";
    
    @Override
    public Object apply2(final Object container, final Object part) throws Throwable {
        if (container instanceof Values) {
            final Object[] values = ((Values)container).getValues();
            final Values.FromTreeList result = new Values.FromTreeList();
            for (int i = 0; i < values.length; ++i) {
                result.writeObject(this.apply2(values[i], part));
            }
            return result.canonicalize();
        }
        Symbol sym;
        if (part instanceof Symbol) {
            sym = (Symbol)part;
        }
        else {
            sym = Namespace.EmptyNamespace.getSymbol(part.toString().intern());
        }
        return getNamedPart(container, sym);
    }
    
    public static Object getTypePart(final Type type, final String name) throws Exception {
        if (name.equals("<>")) {
            return type;
        }
        if (type instanceof ObjectType) {
            if (name.equals("instance?")) {
                return new NamedPart(type, name, 'I');
            }
            if (name.equals("@")) {
                return new NamedPart(type, name, 'C');
            }
            if (name.equals("new")) {
                return new NamedPart(type, name, 'N');
            }
            if (name.equals(".length") || (name.length() > 1 && name.charAt(0) == '.' && type instanceof ClassType)) {
                return new NamedPart(type, name, 'D');
            }
        }
        if (type instanceof ClassType) {
            try {
                return SlotGet.staticField(type, name);
            }
            catch (Exception ex) {
                return ClassMethods.apply(ClassMethods.classMethods, type, name);
            }
        }
        return getMemberPart(type, name);
    }
    
    public static Object getNamedPart(Object container, final Symbol part) throws Exception {
        final String name = part.getName();
        container = Promise.force(container);
        if (container instanceof HasNamedParts) {
            return ((HasNamedParts)container).get(name);
        }
        if (container instanceof Class) {
            container = Type.make((Class)container);
        }
        if (container instanceof Package) {
            try {
                final String pname = ((Package)container).getName();
                return ObjectType.getContextClass(pname + '.' + name);
            }
            catch (Exception ex) {}
        }
        if (container instanceof Type) {
            return getTypePart((Type)container, name);
        }
        return getMemberPart(container, part.toString());
    }
    
    public static Object getMemberPart(final Object container, final String name) throws Exception {
        try {
            return SlotGet.field(container, name);
        }
        catch (Exception ex) {
            final MethodProc methods = ClassMethods.apply((ObjectType)Type.make(container.getClass()), Mangling.mangleName(name), '\0', Language.getDefaultLanguage());
            if (methods != null) {
                return new NamedPart(container, name, 'M', methods);
            }
            throw new RuntimeException("no part '" + name + "' in " + container);
        }
    }
    
    @Override
    public Procedure getSetter() {
        return SetNamedPart.setNamedPart;
    }
    
    static {
        (getNamedPart = new GetNamedPart()).setProperty(Procedure.validateApplyKey, "gnu.kawa.functions.CompileNamedPart:validateGetNamedPart");
    }
}
