/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.reflect;

import gnu.bytecode.ClassType;
import gnu.bytecode.Type;
import gnu.expr.Language;
import gnu.expr.Mangling;
import gnu.expr.SourceName;
import gnu.kawa.reflect.FieldLocation;
import gnu.kawa.reflect.StaticFieldLocation;
import gnu.mapping.Environment;
import gnu.mapping.Location;
import gnu.mapping.Named;
import gnu.mapping.NamedLocation;
import gnu.mapping.Symbol;
import gnu.mapping.UnboundLocationException;
import gnu.mapping.WrappedException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public abstract class ClassMemberLocation<T>
extends Location<T> {
    Object instance;
    private String cname;
    private ClassType type;
    String mname;
    Field rfield;
    static final ClassType typeProcedure = ClassType.make("gnu.mapping.Procedure");
    static final ClassType typeLocation = ClassType.make("gnu.mapping.Location");

    public final Object getInstance() {
        return this.instance;
    }

    public final void setInstance(Object obj) {
        this.instance = obj;
    }

    public ClassMemberLocation(Object instance, String cname, String mname) {
        this.instance = instance;
        this.cname = cname;
        this.mname = mname;
    }

    public ClassMemberLocation(Object instance, ClassType type, String mname) {
        this.instance = instance;
        this.type = type;
        this.mname = mname;
    }

    public ClassMemberLocation(Object instance, Class clas, String mname) {
        this.instance = instance;
        this.type = (ClassType)Type.make(clas);
        this.mname = mname;
    }

    public ClassMemberLocation(Object instance, Field field) {
        this.instance = instance;
        this.rfield = field;
        this.type = (ClassType)Type.make(field.getDeclaringClass());
        this.mname = field.getName();
    }

    public String getMemberName() {
        return this.mname;
    }

    public ClassType getDeclaringClass() {
        if (this.type == null) {
            this.type = ClassType.make(this.cname);
        }
        return this.type;
    }

    public String getDeclaringClassname() {
        return this.cname != null ? this.cname : (this.type == null ? "()" : this.type.getName());
    }

    void setup() {
        if (this.rfield == null) {
            Class clas;
            try {
                clas = this.getDeclaringClass().getReflectClass();
            }
            catch (RuntimeException ex) {
                UnboundLocationException uex = new UnboundLocationException(null, "Unbound location - " + ex.toString());
                uex.initCause(ex);
                throw uex;
            }
            try {
                this.rfield = clas.getField(this.mname);
            }
            catch (NoSuchFieldException ex) {
                UnboundLocationException uex = new UnboundLocationException(null, "Unbound location  - no field " + this.mname + " in " + this.type.getName());
                uex.initCause(ex);
                throw uex;
            }
        }
    }

    public Field getRField() {
        Field rfld = this.rfield;
        if (rfld == null) {
            Class clas = null;
            try {
                clas = this.getDeclaringClass().getReflectClass();
                this.rfield = rfld = clas.getField(this.mname);
            }
            catch (Exception ex) {
                return null;
            }
        }
        return rfld;
    }

    public Class getRClass() {
        Field rfld = this.rfield;
        if (rfld != null) {
            return rfld.getDeclaringClass();
        }
        try {
            return this.getDeclaringClass().getReflectClass();
        }
        catch (Exception ex) {
            return null;
        }
    }

    @Override
    public T get(T defaultValue) {
        Field rfld = this.getRField();
        if (rfld == null) {
            return defaultValue;
        }
        try {
            return (T)rfld.get(this.instance);
        }
        catch (IllegalAccessException ex) {
            throw WrappedException.wrapIfNeeded(ex);
        }
    }

    @Override
    public boolean isConstant() {
        Field rfld = this.getRField();
        return rfld != null && (this.rfield.getModifiers() & 16) != 0;
    }

    @Override
    public boolean isBound() {
        Field rfld = this.getRField();
        return rfld != null;
    }

    @Override
    public void set(T value) {
        this.setup();
        try {
            this.rfield.set(this.instance, value);
            return;
        }
        catch (IllegalAccessException ex) {
            throw WrappedException.wrapIfNeeded(ex);
        }
    }

    public static void define(Object instance, Field rfield, String uri, Language language, Environment env) throws IllegalAccessException {
        FieldLocation loc;
        Object fvalue = rfield.get(instance);
        Type ftype = Type.make(rfield.getType());
        boolean isAlias = ftype.isSubtype(typeLocation);
        boolean isProcedure = ftype.isSubtype(typeProcedure);
        int rModifiers = rfield.getModifiers();
        boolean isFinal = (rModifiers & 16) != 0;
        Object fdname = isFinal && fvalue instanceof Named && !isAlias ? ((Named)fvalue).getSymbol() : Mangling.demangleName(rfield.getName(), true);
        try {
            SourceName sourceName = rfield.getAnnotation(SourceName.class);
            if (sourceName != null) {
                fdname = Symbol.valueOf(sourceName.name(), sourceName.uri(), sourceName.prefix());
            }
        }
        catch (Exception ex) {
            // empty catch block
        }
        Symbol sym = fdname instanceof Symbol ? (Symbol)fdname : Symbol.make(uri == null ? "" : uri, fdname.toString().intern());
        Object property = null;
        if (isAlias && isFinal) {
            loc = (FieldLocation)fvalue;
        } else {
            if (isFinal) {
                property = language.getEnvPropertyFor(rfield, fvalue);
            }
            boolean isStatic = (rModifiers & 8) != 0;
            loc = isStatic ? new StaticFieldLocation(rfield) : new FieldLocation(instance, rfield);
        }
        env.addLocation(sym, property, loc);
    }

    public static void defineAll(Object instance, Language language, Environment env) throws IllegalAccessException {
        Class<?> clas = instance.getClass();
        Field[] fields = clas.getFields();
        int i = fields.length;
        while (--i >= 0) {
            Field field = fields[i];
            String fname = field.getName();
            if (fname.startsWith("$Prvt$") || fname.endsWith("$instance")) continue;
            ClassMemberLocation.define(instance, field, null, language, env);
        }
    }
}

