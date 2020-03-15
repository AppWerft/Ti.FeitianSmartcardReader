// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.reflect;

import gnu.mapping.Symbol;
import gnu.expr.SourceName;
import gnu.expr.Mangling;
import gnu.mapping.Named;
import gnu.mapping.Environment;
import gnu.expr.Language;
import gnu.mapping.WrappedException;
import gnu.mapping.UnboundLocationException;
import gnu.bytecode.Type;
import java.lang.reflect.Field;
import gnu.bytecode.ClassType;
import gnu.mapping.Location;

public abstract class ClassMemberLocation<T> extends Location<T>
{
    Object instance;
    private String cname;
    private ClassType type;
    String mname;
    Field rfield;
    static final ClassType typeProcedure;
    static final ClassType typeLocation;
    
    public final Object getInstance() {
        return this.instance;
    }
    
    public final void setInstance(final Object obj) {
        this.instance = obj;
    }
    
    public ClassMemberLocation(final Object instance, final String cname, final String mname) {
        this.instance = instance;
        this.cname = cname;
        this.mname = mname;
    }
    
    public ClassMemberLocation(final Object instance, final ClassType type, final String mname) {
        this.instance = instance;
        this.type = type;
        this.mname = mname;
    }
    
    public ClassMemberLocation(final Object instance, final Class clas, final String mname) {
        this.instance = instance;
        this.type = (ClassType)Type.make(clas);
        this.mname = mname;
    }
    
    public ClassMemberLocation(final Object instance, final Field field) {
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
        return (this.cname != null) ? this.cname : ((this.type == null) ? "()" : this.type.getName());
    }
    
    void setup() {
        if (this.rfield == null) {
            Class clas;
            try {
                clas = this.getDeclaringClass().getReflectClass();
            }
            catch (RuntimeException ex) {
                final RuntimeException uex = new UnboundLocationException(null, "Unbound location - " + ex.toString());
                uex.initCause(ex);
                throw uex;
            }
            try {
                this.rfield = clas.getField(this.mname);
            }
            catch (NoSuchFieldException ex2) {
                final RuntimeException uex = new UnboundLocationException(null, "Unbound location  - no field " + this.mname + " in " + this.type.getName());
                uex.initCause(ex2);
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
                rfld = clas.getField(this.mname);
                this.rfield = rfld;
            }
            catch (Exception ex) {
                return null;
            }
        }
        return rfld;
    }
    
    public Class getRClass() {
        final Field rfld = this.rfield;
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
    public T get(final T defaultValue) {
        final Field rfld = this.getRField();
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
        final Field rfld = this.getRField();
        return rfld != null && (this.rfield.getModifiers() & 0x10) != 0x0;
    }
    
    @Override
    public boolean isBound() {
        final Field rfld = this.getRField();
        return rfld != null;
    }
    
    @Override
    public void set(final T value) {
        this.setup();
        try {
            this.rfield.set(this.instance, value);
        }
        catch (IllegalAccessException ex) {
            throw WrappedException.wrapIfNeeded(ex);
        }
    }
    
    public static void define(final Object instance, final Field rfield, final String uri, final Language language, final Environment env) throws IllegalAccessException {
        final Object fvalue = rfield.get(instance);
        final Type ftype = Type.make(rfield.getType());
        final boolean isAlias = ftype.isSubtype(ClassMemberLocation.typeLocation);
        final boolean isProcedure = ftype.isSubtype(ClassMemberLocation.typeProcedure);
        final int rModifiers = rfield.getModifiers();
        final boolean isFinal = (rModifiers & 0x10) != 0x0;
        Object fdname = (isFinal && fvalue instanceof Named && !isAlias) ? ((Named)fvalue).getSymbol() : Mangling.demangleName(rfield.getName(), true);
        try {
            final SourceName sourceName = rfield.getAnnotation(SourceName.class);
            if (sourceName != null) {
                fdname = Symbol.valueOf(sourceName.name(), sourceName.uri(), sourceName.prefix());
            }
        }
        catch (Exception ex) {}
        Symbol sym;
        if (fdname instanceof Symbol) {
            sym = (Symbol)fdname;
        }
        else {
            sym = Symbol.make((uri == null) ? "" : uri, fdname.toString().intern());
        }
        Object property = null;
        Location loc;
        if (isAlias && isFinal) {
            loc = (Location)fvalue;
        }
        else {
            if (isFinal) {
                property = language.getEnvPropertyFor(rfield, fvalue);
            }
            final boolean isStatic = (rModifiers & 0x8) != 0x0;
            if (isStatic) {
                loc = new StaticFieldLocation(rfield);
            }
            else {
                loc = new FieldLocation(instance, rfield);
            }
        }
        env.addLocation(sym, property, loc);
    }
    
    public static void defineAll(final Object instance, final Language language, final Environment env) throws IllegalAccessException {
        final Class clas = instance.getClass();
        final Field[] fields = clas.getFields();
        int i = fields.length;
        while (--i >= 0) {
            final Field field = fields[i];
            final String fname = field.getName();
            if (!fname.startsWith("$Prvt$")) {
                if (fname.endsWith("$instance")) {
                    continue;
                }
                define(instance, field, null, language, env);
            }
        }
    }
    
    static {
        typeProcedure = ClassType.make("gnu.mapping.Procedure");
        typeLocation = ClassType.make("gnu.mapping.Location");
    }
}
