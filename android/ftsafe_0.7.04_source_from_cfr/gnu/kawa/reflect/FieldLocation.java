/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.reflect;

import gnu.bytecode.ClassType;
import gnu.bytecode.Type;
import gnu.expr.Compilation;
import gnu.expr.Declaration;
import gnu.expr.ModuleExp;
import gnu.expr.ModuleInfo;
import gnu.kawa.reflect.ClassMemberLocation;
import gnu.mapping.Location;
import gnu.mapping.Procedure;
import gnu.mapping.UnboundLocationException;
import gnu.mapping.WrappedException;
import java.lang.reflect.Field;
import kawa.lang.Syntax;

public class FieldLocation<T>
extends ClassMemberLocation<T> {
    Declaration decl;
    Object value;
    static final int SETUP_DONE = 1;
    static final int INDIRECT_LOCATION = 2;
    static final int CONSTANT = 4;
    static final int VALUE_SET = 8;
    public static final int PROCEDURE = 16;
    public static final int SYNTAX = 32;
    public static final int KIND_FLAGS_SET = 64;
    private int flags;

    public boolean isIndirectLocation() {
        return (this.flags & 2) != 0;
    }

    public void setProcedure() {
        this.flags |= 84;
    }

    public void setSyntax() {
        this.flags |= 100;
    }

    void setKindFlags() {
        String fname = this.getMemberName();
        gnu.bytecode.Field fld = this.getDeclaringClass().getDeclaredField(fname);
        if (fld == null) {
            throw new RuntimeException("No field found for " + this);
        }
        int fflags = fld.getModifiers();
        Type ftype = fld.getType();
        if (ftype.isSubtype(Compilation.typeLocation)) {
            this.flags |= 2;
        }
        if ((fflags & 16) != 0) {
            if ((this.flags & 2) == 0) {
                this.flags |= 4;
                if (ftype.isSubtype(Compilation.typeProcedure)) {
                    this.flags |= 16;
                }
                if (ftype instanceof ClassType && ((ClassType)ftype).isSubclass("kawa.lang.Syntax")) {
                    this.flags |= 32;
                }
            } else {
                Location loc = (Location)this.getFieldValue();
                if (loc instanceof FieldLocation) {
                    FieldLocation floc = (FieldLocation)loc;
                    if ((floc.flags & 64) == 0) {
                        floc.setKindFlags();
                    }
                    this.flags |= floc.flags & 52;
                    if ((floc.flags & 4) != 0) {
                        if ((floc.flags & 8) != 0) {
                            this.value = floc.value;
                            this.flags |= 8;
                        }
                    } else {
                        this.value = floc;
                        this.flags |= 8;
                    }
                } else if (loc.isConstant()) {
                    Object val = loc.get(null);
                    if (val instanceof Procedure) {
                        this.flags |= 16;
                    }
                    if (val instanceof Syntax) {
                        this.flags |= 32;
                    }
                    this.flags |= 12;
                    this.value = val;
                }
            }
        }
        this.flags |= 64;
    }

    public boolean isProcedureOrSyntax() {
        if ((this.flags & 64) == 0) {
            this.setKindFlags();
        }
        return (this.flags & 48) != 0;
    }

    public FieldLocation(Object instance, String cname, String fname) {
        super(instance, cname, fname);
    }

    public FieldLocation(Object instance, ClassType type, String mname) {
        super(instance, type, mname);
    }

    public FieldLocation(Object instance, Field field) {
        super(instance, field);
    }

    public void setDeclaration(Declaration decl) {
        this.decl = decl;
    }

    public gnu.bytecode.Field getField() {
        return this.getDeclaringClass().getDeclaredField(this.mname);
    }

    public Type getFType() {
        return this.getField().getType();
    }

    public synchronized Declaration getDeclaration() {
        Declaration d;
        if ((this.flags & 64) == 0) {
            this.setKindFlags();
        }
        if ((d = this.decl) == null) {
            String fname = this.getMemberName();
            ClassType t = this.getDeclaringClass();
            gnu.bytecode.Field procField = t.getDeclaredField(fname);
            if (procField == null) {
                return null;
            }
            ModuleInfo info = ModuleInfo.find(t);
            ModuleExp mexp = info.getModuleExp();
            for (d = mexp.firstDecl(); !(d == null || d.field != null && d.field.getName().equals(fname)); d = d.nextDecl()) {
            }
            if (d == null) {
                throw new RuntimeException("no field found for " + this);
            }
            this.decl = d;
        }
        return d;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    void setup() {
        FieldLocation fieldLocation = this;
        synchronized (fieldLocation) {
            if ((this.flags & 1) != 0) {
                return;
            }
            super.setup();
            if ((this.flags & 64) == 0) {
                this.setKindFlags();
            }
            this.flags |= 1;
        }
    }

    @Override
    public T get() {
        return this.get(null, true);
    }

    @Override
    public T get(T defaultValue) {
        return this.get(defaultValue, false);
    }

    T get(T defaultValue, boolean throwIfUnbound) {
        Object v;
        try {
            this.setup();
        }
        catch (Exception ex) {
            if (throwIfUnbound) {
                throw new UnboundLocationException(this);
            }
            return defaultValue;
        }
        if ((this.flags & 8) != 0) {
            v = this.value;
            if ((this.flags & 4) != 0) {
                return (T)v;
            }
        } else {
            v = this.getFieldValue();
            if ((this.getDeclaringClass().getDeclaredField(this.mname).getModifiers() & 16) != 0) {
                this.flags |= 8;
                if ((this.flags & 2) == 0) {
                    this.flags |= 4;
                }
                this.value = v;
            }
        }
        if ((this.flags & 2) != 0) {
            Location loc = (Location)v;
            if (throwIfUnbound) {
                v = loc.get();
            } else if (!loc.isBound()) {
                return defaultValue;
            }
            if (loc.isConstant()) {
                this.flags |= 4;
                this.value = v;
            }
        }
        return (T)v;
    }

    private T getFieldValue() {
        super.setup();
        try {
            return (T)this.rfield.get(this.instance);
        }
        catch (Exception ex) {
            throw WrappedException.rethrow(ex);
        }
    }

    @Override
    public void set(Object newValue) {
        this.setup();
        if ((this.flags & 2) == 0) {
            try {
                this.rfield.set(this.instance, newValue);
            }
            catch (Exception ex) {
                throw WrappedException.wrapIfNeeded(ex);
            }
        } else {
            Object v;
            if ((this.flags & 8) != 0) {
                v = this.value;
            } else {
                this.flags |= 8;
                this.value = v = this.getFieldValue();
            }
            ((Location)v).set(newValue);
        }
    }

    @Override
    public Object setWithSave(T newValue) {
        Object v;
        if ((this.flags & 64) == 0) {
            this.setKindFlags();
        }
        if ((this.flags & 2) == 0) {
            return super.setWithSave(newValue);
        }
        if ((this.flags & 8) != 0) {
            v = this.value;
        } else {
            this.flags |= 8;
            this.value = v = this.getFieldValue();
        }
        return ((Location)v).setWithSave(newValue);
    }

    @Override
    public void setRestore(Object oldValue) {
        if ((this.flags & 2) == 0) {
            super.setRestore(oldValue);
        } else {
            ((Location)this.value).setRestore(oldValue);
        }
    }

    @Override
    public boolean isConstant() {
        if ((this.flags & 64) == 0) {
            this.setKindFlags();
        }
        if ((this.flags & 4) != 0) {
            return true;
        }
        if (this.isIndirectLocation()) {
            Object v;
            if ((this.flags & 8) != 0) {
                v = this.value;
            } else {
                try {
                    this.setup();
                }
                catch (Exception ex) {
                    return false;
                }
                v = this.getFieldValue();
                this.flags |= 8;
                this.value = v;
            }
            return ((Location)v).isConstant();
        }
        return false;
    }

    @Override
    public boolean isBound() {
        Object v;
        if ((this.flags & 64) == 0) {
            this.setKindFlags();
        }
        if ((this.flags & 4) != 0 || (this.flags & 2) == 0) {
            return true;
        }
        if ((this.flags & 8) != 0) {
            v = this.value;
        } else {
            try {
                this.setup();
            }
            catch (Exception ex) {
                return false;
            }
            v = this.getFieldValue();
            this.flags |= 8;
            this.value = v;
        }
        return ((Location)v).isBound();
    }

    public static FieldLocation make(Object instance, Declaration decl) {
        gnu.bytecode.Field fld = decl.field;
        ClassType ctype = fld.getDeclaringClass();
        FieldLocation<T> loc = new FieldLocation<T>(instance, ctype, fld.getName());
        loc.setDeclaration(decl);
        return loc;
    }

    public static FieldLocation make(Object instance, String cname, String fldName) {
        return new FieldLocation<T>(instance, ClassType.make(cname), fldName);
    }

    @Override
    public String toString() {
        StringBuffer sbuf = new StringBuffer();
        sbuf.append("FieldLocation[");
        if (this.instance != null) {
            sbuf.append(this.instance);
            sbuf.append(' ');
        }
        sbuf.append(this.getDeclaringClassname());
        sbuf.append('.');
        sbuf.append(this.mname);
        sbuf.append(']');
        return sbuf.toString();
    }
}

