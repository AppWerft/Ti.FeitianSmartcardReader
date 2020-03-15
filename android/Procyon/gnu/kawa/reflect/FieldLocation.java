// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.reflect;

import gnu.mapping.WrappedException;
import gnu.mapping.UnboundLocationException;
import gnu.expr.ModuleExp;
import gnu.expr.ModuleInfo;
import gnu.bytecode.Field;
import kawa.lang.Syntax;
import gnu.mapping.Procedure;
import gnu.mapping.Location;
import gnu.bytecode.ClassType;
import gnu.bytecode.Type;
import gnu.expr.Compilation;
import gnu.expr.Declaration;

public class FieldLocation<T> extends ClassMemberLocation<T>
{
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
        return (this.flags & 0x2) != 0x0;
    }
    
    public void setProcedure() {
        this.flags |= 0x54;
    }
    
    public void setSyntax() {
        this.flags |= 0x64;
    }
    
    void setKindFlags() {
        final String fname = this.getMemberName();
        final Field fld = this.getDeclaringClass().getDeclaredField(fname);
        if (fld == null) {
            throw new RuntimeException("No field found for " + this);
        }
        final int fflags = fld.getModifiers();
        final Type ftype = fld.getType();
        if (ftype.isSubtype(Compilation.typeLocation)) {
            this.flags |= 0x2;
        }
        if ((fflags & 0x10) != 0x0) {
            if ((this.flags & 0x2) == 0x0) {
                this.flags |= 0x4;
                if (ftype.isSubtype(Compilation.typeProcedure)) {
                    this.flags |= 0x10;
                }
                if (ftype instanceof ClassType && ((ClassType)ftype).isSubclass("kawa.lang.Syntax")) {
                    this.flags |= 0x20;
                }
            }
            else {
                final Location loc = this.getFieldValue();
                if (loc instanceof FieldLocation) {
                    final FieldLocation<T> floc = (FieldLocation<T>)loc;
                    if ((floc.flags & 0x40) == 0x0) {
                        floc.setKindFlags();
                    }
                    this.flags |= (floc.flags & 0x34);
                    if ((floc.flags & 0x4) != 0x0) {
                        if ((floc.flags & 0x8) != 0x0) {
                            this.value = floc.value;
                            this.flags |= 0x8;
                        }
                    }
                    else {
                        this.value = floc;
                        this.flags |= 0x8;
                    }
                }
                else if (loc.isConstant()) {
                    final Object val = loc.get(null);
                    if (val instanceof Procedure) {
                        this.flags |= 0x10;
                    }
                    if (val instanceof Syntax) {
                        this.flags |= 0x20;
                    }
                    this.flags |= 0xC;
                    this.value = val;
                }
            }
        }
        this.flags |= 0x40;
    }
    
    public boolean isProcedureOrSyntax() {
        if ((this.flags & 0x40) == 0x0) {
            this.setKindFlags();
        }
        return (this.flags & 0x30) != 0x0;
    }
    
    public FieldLocation(final Object instance, final String cname, final String fname) {
        super(instance, cname, fname);
    }
    
    public FieldLocation(final Object instance, final ClassType type, final String mname) {
        super(instance, type, mname);
    }
    
    public FieldLocation(final Object instance, final java.lang.reflect.Field field) {
        super(instance, field);
    }
    
    public void setDeclaration(final Declaration decl) {
        this.decl = decl;
    }
    
    public Field getField() {
        return this.getDeclaringClass().getDeclaredField(this.mname);
    }
    
    public Type getFType() {
        return this.getField().getType();
    }
    
    public synchronized Declaration getDeclaration() {
        if ((this.flags & 0x40) == 0x0) {
            this.setKindFlags();
        }
        Declaration d = this.decl;
        if (d == null) {
            final String fname = this.getMemberName();
            final ClassType t = this.getDeclaringClass();
            final Field procField = t.getDeclaredField(fname);
            if (procField == null) {
                return null;
            }
            final ModuleInfo info = ModuleInfo.find(t);
            final ModuleExp mexp = info.getModuleExp();
            for (d = mexp.firstDecl(); d != null && (d.field == null || !d.field.getName().equals(fname)); d = d.nextDecl()) {}
            if (d == null) {
                throw new RuntimeException("no field found for " + this);
            }
            this.decl = d;
        }
        return d;
    }
    
    @Override
    void setup() {
        synchronized (this) {
            if ((this.flags & 0x1) != 0x0) {
                return;
            }
            super.setup();
            if ((this.flags & 0x40) == 0x0) {
                this.setKindFlags();
            }
            this.flags |= 0x1;
        }
    }
    
    @Override
    public T get() {
        return this.get(null, true);
    }
    
    @Override
    public T get(final T defaultValue) {
        return this.get(defaultValue, false);
    }
    
    T get(final T defaultValue, final boolean throwIfUnbound) {
        try {
            this.setup();
        }
        catch (Exception ex) {
            if (throwIfUnbound) {
                throw new UnboundLocationException(this);
            }
            return defaultValue;
        }
        Object v;
        if ((this.flags & 0x8) != 0x0) {
            v = this.value;
            if ((this.flags & 0x4) != 0x0) {
                return (T)v;
            }
        }
        else {
            v = this.getFieldValue();
            if ((this.getDeclaringClass().getDeclaredField(this.mname).getModifiers() & 0x10) != 0x0) {
                this.flags |= 0x8;
                if ((this.flags & 0x2) == 0x0) {
                    this.flags |= 0x4;
                }
                this.value = v;
            }
        }
        if ((this.flags & 0x2) != 0x0) {
            final Location loc = (Location)v;
            if (throwIfUnbound) {
                v = loc.get();
            }
            else if (!loc.isBound()) {
                return defaultValue;
            }
            if (loc.isConstant()) {
                this.flags |= 0x4;
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
    public void set(final Object newValue) {
        this.setup();
        if ((this.flags & 0x2) == 0x0) {
            try {
                this.rfield.set(this.instance, newValue);
                return;
            }
            catch (Exception ex) {
                throw WrappedException.wrapIfNeeded(ex);
            }
        }
        Object v;
        if ((this.flags & 0x8) != 0x0) {
            v = this.value;
        }
        else {
            this.flags |= 0x8;
            v = this.getFieldValue();
            this.value = v;
        }
        ((Location)v).set(newValue);
    }
    
    @Override
    public Object setWithSave(final T newValue) {
        if ((this.flags & 0x40) == 0x0) {
            this.setKindFlags();
        }
        if ((this.flags & 0x2) == 0x0) {
            return super.setWithSave(newValue);
        }
        Object v;
        if ((this.flags & 0x8) != 0x0) {
            v = this.value;
        }
        else {
            this.flags |= 0x8;
            v = this.getFieldValue();
            this.value = v;
        }
        return ((Location)v).setWithSave(newValue);
    }
    
    @Override
    public void setRestore(final Object oldValue) {
        if ((this.flags & 0x2) == 0x0) {
            super.setRestore(oldValue);
        }
        else {
            ((Location)this.value).setRestore(oldValue);
        }
    }
    
    @Override
    public boolean isConstant() {
        if ((this.flags & 0x40) == 0x0) {
            this.setKindFlags();
        }
        if ((this.flags & 0x4) != 0x0) {
            return true;
        }
        if (this.isIndirectLocation()) {
            Object v;
            if ((this.flags & 0x8) != 0x0) {
                v = this.value;
            }
            else {
                try {
                    this.setup();
                }
                catch (Exception ex) {
                    return false;
                }
                v = this.getFieldValue();
                this.flags |= 0x8;
                this.value = v;
            }
            return ((Location)v).isConstant();
        }
        return false;
    }
    
    @Override
    public boolean isBound() {
        if ((this.flags & 0x40) == 0x0) {
            this.setKindFlags();
        }
        if ((this.flags & 0x4) != 0x0 || (this.flags & 0x2) == 0x0) {
            return true;
        }
        Object v;
        if ((this.flags & 0x8) != 0x0) {
            v = this.value;
        }
        else {
            try {
                this.setup();
            }
            catch (Exception ex) {
                return false;
            }
            v = this.getFieldValue();
            this.flags |= 0x8;
            this.value = v;
        }
        return ((Location)v).isBound();
    }
    
    public static FieldLocation make(final Object instance, final Declaration decl) {
        final Field fld = decl.field;
        final ClassType ctype = fld.getDeclaringClass();
        final FieldLocation loc = new FieldLocation(instance, ctype, fld.getName());
        loc.setDeclaration(decl);
        return loc;
    }
    
    public static FieldLocation make(final Object instance, final String cname, final String fldName) {
        return new FieldLocation(instance, ClassType.make(cname), fldName);
    }
    
    @Override
    public String toString() {
        final StringBuffer sbuf = new StringBuffer();
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
