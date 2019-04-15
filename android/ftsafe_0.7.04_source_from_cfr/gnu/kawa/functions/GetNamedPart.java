/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.functions;

import gnu.bytecode.ClassType;
import gnu.bytecode.ObjectType;
import gnu.bytecode.Type;
import gnu.expr.Language;
import gnu.expr.Mangling;
import gnu.kawa.functions.NamedPart;
import gnu.kawa.functions.SetNamedPart;
import gnu.kawa.reflect.ClassMethods;
import gnu.kawa.reflect.SlotGet;
import gnu.mapping.HasNamedParts;
import gnu.mapping.HasSetter;
import gnu.mapping.MethodProc;
import gnu.mapping.Namespace;
import gnu.mapping.Procedure;
import gnu.mapping.Procedure2;
import gnu.mapping.Promise;
import gnu.mapping.Symbol;
import gnu.mapping.Values;

public class GetNamedPart
extends Procedure2
implements HasSetter {
    public static final GetNamedPart getNamedPart = new GetNamedPart();
    public static final String CLASSTYPE_FOR = "<>";
    public static final String CAST_METHOD_NAME = "@";
    public static final String INSTANCEOF_METHOD_NAME = "instance?";

    @Override
    public Object apply2(Object container, Object part) throws Throwable {
        if (container instanceof Values) {
            Object[] values = ((Values)container).getValues();
            Values.FromTreeList result = new Values.FromTreeList();
            for (int i = 0; i < values.length; ++i) {
                result.writeObject(this.apply2(values[i], part));
            }
            return result.canonicalize();
        }
        Symbol sym = part instanceof Symbol ? (Symbol)part : Namespace.EmptyNamespace.getSymbol(part.toString().intern());
        return GetNamedPart.getNamedPart(container, sym);
    }

    public static Object getTypePart(Type type, String name) throws Exception {
        if (name.equals(CLASSTYPE_FOR)) {
            return type;
        }
        if (type instanceof ObjectType) {
            if (name.equals(INSTANCEOF_METHOD_NAME)) {
                return new NamedPart(type, name, 'I');
            }
            if (name.equals(CAST_METHOD_NAME)) {
                return new NamedPart(type, name, 'C');
            }
            if (name.equals("new")) {
                return new NamedPart(type, name, 'N');
            }
            if (name.equals(".length") || name.length() > 1 && name.charAt(0) == '.' && type instanceof ClassType) {
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
        return GetNamedPart.getMemberPart(type, name);
    }

    public static Object getNamedPart(Object container, Symbol part) throws Exception {
        String name = part.getName();
        if ((container = Promise.force(container)) instanceof HasNamedParts) {
            return ((HasNamedParts)container).get(name);
        }
        if (container instanceof Class) {
            container = Type.make((Class)container);
        }
        if (container instanceof Package) {
            try {
                String pname = ((Package)container).getName();
                return ClassType.getContextClass(pname + '.' + name);
            }
            catch (Exception ex) {
                // empty catch block
            }
        }
        if (container instanceof Type) {
            return GetNamedPart.getTypePart((Type)container, name);
        }
        return GetNamedPart.getMemberPart(container, part.toString());
    }

    public static Object getMemberPart(Object container, String name) throws Exception {
        try {
            return SlotGet.field(container, name);
        }
        catch (Exception ex) {
            MethodProc methods = ClassMethods.apply((ObjectType)ClassType.make(container.getClass()), Mangling.mangleName(name), '\u0000', Language.getDefaultLanguage());
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
        getNamedPart.setProperty(Procedure.validateApplyKey, "gnu.kawa.functions.CompileNamedPart:validateGetNamedPart");
    }
}

