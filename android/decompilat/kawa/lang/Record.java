// 
// Decompiled by Procyon v0.5.36
// 

package kawa.lang;

import gnu.mapping.Symbol;
import java.util.Vector;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.Method;
import gnu.bytecode.ArrayClassLoader;
import gnu.lists.Pair;
import gnu.expr.Compilation;
import gnu.expr.Mangling;
import gnu.lists.LList;
import java.io.PrintWriter;
import gnu.mapping.WrappedException;
import gnu.bytecode.Type;
import gnu.bytecode.ClassType;
import java.lang.reflect.Field;

public class Record
{
    public String getTypeName() {
        return this.getClass().getName();
    }
    
    public static boolean isRecord(final Object obj) {
        return obj instanceof Record;
    }
    
    @Override
    public int hashCode() {
        final Field[] fields = this.getClass().getFields();
        int hash = 12345;
        for (int i = 0; i < fields.length; ++i) {
            final Field field = fields[i];
            Object value;
            try {
                value = field.get(this);
            }
            catch (IllegalAccessException ex) {
                continue;
            }
            if (value != null) {
                hash ^= value.hashCode();
            }
        }
        return hash;
    }
    
    static Field getField(final Class clas, final String fname) throws NoSuchFieldException {
        final ClassType ctype = (ClassType)Type.make(clas);
        for (gnu.bytecode.Field fld = ctype.getFields(); fld != null; fld = fld.getNext()) {
            if ((fld.getModifiers() & 0x9) == 0x1) {
                if (fld.getSourceName().equals(fname)) {
                    return fld.getReflectField();
                }
            }
        }
        throw new NoSuchFieldException();
    }
    
    public Object get(final String fname, final Object defaultValue) {
        final Class clas = this.getClass();
        try {
            return getField(clas, fname).get(this);
        }
        catch (NoSuchFieldException ex) {
            throw new GenericError("no such field " + fname + " in " + clas.getName());
        }
        catch (IllegalAccessException ex2) {
            throw new GenericError("illegal access for field " + fname);
        }
    }
    
    public Object put(final String fname, final Object value) {
        return set1(this, fname, value);
    }
    
    public static Object set1(final Object record, final String fname, final Object value) {
        final Class clas = record.getClass();
        try {
            final Field fld = getField(clas, fname);
            final Object old = fld.get(record);
            fld.set(record, value);
            return old;
        }
        catch (NoSuchFieldException ex) {
            throw new GenericError("no such field " + fname + " in " + clas.getName());
        }
        catch (IllegalAccessException ex2) {
            throw new GenericError("illegal access for field " + fname);
        }
    }
    
    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        final Class thisClass = this.getClass();
        if (obj == null || obj.getClass() != thisClass) {
            return false;
        }
        final ClassType ctype = (ClassType)Type.make(thisClass);
        for (gnu.bytecode.Field fld = ctype.getFields(); fld != null; fld = fld.getNext()) {
            if ((fld.getModifiers() & 0x9) == 0x1) {
                Object value1;
                Object value2;
                try {
                    final Field field = fld.getReflectField();
                    value1 = field.get(this);
                    value2 = field.get(obj);
                }
                catch (Exception ex) {
                    throw new WrappedException(ex);
                }
                if (!value1.equals(value2)) {
                    return false;
                }
            }
        }
        return true;
    }
    
    @Override
    public String toString() {
        final StringBuffer buf = new StringBuffer(200);
        buf.append("#<");
        buf.append(this.getTypeName());
        final ClassType ctype = (ClassType)Type.make(this.getClass());
        for (gnu.bytecode.Field fld = ctype.getFields(); fld != null; fld = fld.getNext()) {
            if ((fld.getModifiers() & 0x9) == 0x1) {
                Object value;
                try {
                    final Field field = fld.getReflectField();
                    value = field.get(this);
                }
                catch (Exception ex) {
                    value = "#<illegal-access>";
                }
                buf.append(' ');
                buf.append(fld.getSourceName());
                buf.append(": ");
                buf.append(value);
            }
        }
        buf.append(">");
        return buf.toString();
    }
    
    public void print(final PrintWriter ps) {
        ps.print(this.toString());
    }
    
    public static ClassType makeRecordType(final String name, LList fnames) {
        final ClassType superClass = ClassType.make("kawa.lang.Record");
        final String mangledName = Mangling.mangleClassName(name);
        final ClassType clas = new ClassType(mangledName);
        clas.setClassfileVersion(Compilation.defaultClassFileVersion);
        clas.setSuper(superClass);
        clas.setModifiers(33);
        final Method constructor = clas.addMethod("<init>", Type.typeArray0, Type.voidType, 1);
        final Method superConstructor = superClass.addMethod("<init>", Type.typeArray0, Type.voidType, 1);
        CodeAttr code = constructor.startCode();
        code.emitPushThis();
        code.emitInvokeSpecial(superConstructor);
        code.emitReturn();
        if (!name.equals(mangledName)) {
            final Method meth = clas.addMethod("getTypeName", Type.typeArray0, Compilation.typeString, 1);
            code = meth.startCode();
            code.emitPushString(name);
            code.emitReturn();
        }
        while (fnames != LList.Empty) {
            final Pair pair = (Pair)fnames;
            final String fname = pair.getCar().toString();
            final gnu.bytecode.Field fld = clas.addField(Mangling.mangleNameIfNeeded(fname), Type.pointer_type, 1);
            fld.setSourceName(fname.intern());
            fnames = (LList)pair.getCdr();
        }
        final byte[][] arrays = { null };
        final String[] names = { mangledName };
        arrays[0] = clas.writeToArray();
        final ArrayClassLoader loader = new ArrayClassLoader(names, arrays);
        try {
            final Class reflectClass = loader.loadClass(mangledName);
            Type.registerTypeForClass(reflectClass, clas);
            return clas;
        }
        catch (ClassNotFoundException ex) {
            throw new InternalError(ex.toString());
        }
    }
    
    public static LList typeFieldNames(final Class clas) {
        LList list = LList.Empty;
        final ClassType ctype = (ClassType)Type.make(clas);
        gnu.bytecode.Field field = ctype.getFields();
        final Vector vec = new Vector(100);
        while (field != null) {
            if ((field.getModifiers() & 0x9) == 0x1) {
                vec.addElement(Symbol.valueOf(field.getSourceName()));
            }
            field = field.getNext();
        }
        int i = vec.size();
        while (--i >= 0) {
            list = new Pair(vec.elementAt(i), list);
        }
        return list;
    }
    
    public static LList typeFieldNames(final ClassType ctype) {
        return typeFieldNames(ctype.getReflectClass());
    }
}
