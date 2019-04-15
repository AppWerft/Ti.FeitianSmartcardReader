/*
 * Decompiled with CFR 0.139.
 */
package kawa.lang;

import gnu.bytecode.ArrayClassLoader;
import gnu.bytecode.ClassType;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.Method;
import gnu.bytecode.PrimType;
import gnu.bytecode.Type;
import gnu.expr.Compilation;
import gnu.expr.Mangling;
import gnu.lists.EmptyList;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.WrappedException;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.util.Vector;
import kawa.lang.GenericError;

public class Record {
    public String getTypeName() {
        return this.getClass().getName();
    }

    public static boolean isRecord(Object obj) {
        return obj instanceof Record;
    }

    public int hashCode() {
        Field[] fields = this.getClass().getFields();
        int hash = 12345;
        for (int i = 0; i < fields.length; ++i) {
            Object value;
            Field field = fields[i];
            try {
                value = field.get(this);
            }
            catch (IllegalAccessException ex) {
                continue;
            }
            if (value == null) continue;
            hash ^= value.hashCode();
        }
        return hash;
    }

    static Field getField(Class clas, String fname) throws NoSuchFieldException {
        ClassType ctype = (ClassType)Type.make(clas);
        for (gnu.bytecode.Field fld = ctype.getFields(); fld != null; fld = fld.getNext()) {
            if ((fld.getModifiers() & 9) != 1 || !fld.getSourceName().equals(fname)) continue;
            return fld.getReflectField();
        }
        throw new NoSuchFieldException();
    }

    public Object get(String fname, Object defaultValue) {
        Class<?> clas = this.getClass();
        try {
            return Record.getField(clas, fname).get(this);
        }
        catch (NoSuchFieldException ex) {
            throw new GenericError("no such field " + fname + " in " + clas.getName());
        }
        catch (IllegalAccessException ex) {
            throw new GenericError("illegal access for field " + fname);
        }
    }

    public Object put(String fname, Object value) {
        return Record.set1(this, fname, value);
    }

    public static Object set1(Object record, String fname, Object value) {
        Class<?> clas = record.getClass();
        try {
            Field fld = Record.getField(clas, fname);
            Object old = fld.get(record);
            fld.set(record, value);
            return old;
        }
        catch (NoSuchFieldException ex) {
            throw new GenericError("no such field " + fname + " in " + clas.getName());
        }
        catch (IllegalAccessException ex) {
            throw new GenericError("illegal access for field " + fname);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        Class<?> thisClass = this.getClass();
        if (obj == null || obj.getClass() != thisClass) {
            return false;
        }
        ClassType ctype = (ClassType)Type.make(thisClass);
        for (gnu.bytecode.Field fld = ctype.getFields(); fld != null; fld = fld.getNext()) {
            Object value1;
            Object value2;
            if ((fld.getModifiers() & 9) != 1) continue;
            try {
                Field field = fld.getReflectField();
                value1 = field.get(this);
                value2 = field.get(obj);
            }
            catch (Exception ex) {
                throw new WrappedException(ex);
            }
            if (value1.equals(value2)) continue;
            return false;
        }
        return true;
    }

    public String toString() {
        StringBuffer buf = new StringBuffer(200);
        buf.append("#<");
        buf.append(this.getTypeName());
        ClassType ctype = (ClassType)Type.make(this.getClass());
        for (gnu.bytecode.Field fld = ctype.getFields(); fld != null; fld = fld.getNext()) {
            Object value;
            if ((fld.getModifiers() & 9) != 1) continue;
            try {
                Field field = fld.getReflectField();
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
        buf.append(">");
        return buf.toString();
    }

    public void print(PrintWriter ps) {
        ps.print(this.toString());
    }

    public static ClassType makeRecordType(String name, LList fnames) {
        ClassType superClass = ClassType.make("kawa.lang.Record");
        String mangledName = Mangling.mangleClassName(name);
        ClassType clas = new ClassType(mangledName);
        clas.setClassfileVersion(Compilation.defaultClassFileVersion);
        clas.setSuper(superClass);
        clas.setModifiers(33);
        Method constructor = clas.addMethod("<init>", Type.typeArray0, Type.voidType, 1);
        Method superConstructor = superClass.addMethod("<init>", Type.typeArray0, Type.voidType, 1);
        CodeAttr code = constructor.startCode();
        code.emitPushThis();
        code.emitInvokeSpecial(superConstructor);
        code.emitReturn();
        if (!name.equals(mangledName)) {
            Method meth = clas.addMethod("getTypeName", Type.typeArray0, Compilation.typeString, 1);
            code = meth.startCode();
            code.emitPushString(name);
            code.emitReturn();
        }
        while (fnames != LList.Empty) {
            Pair pair = (Pair)fnames;
            String fname = pair.getCar().toString();
            gnu.bytecode.Field fld = clas.addField(Mangling.mangleNameIfNeeded(fname), Type.pointer_type, 1);
            fld.setSourceName(fname.intern());
            fnames = (LList)pair.getCdr();
        }
        byte[][] arrays2 = new byte[1][];
        String[] names = new String[]{mangledName};
        arrays2[0] = clas.writeToArray();
        ArrayClassLoader loader = new ArrayClassLoader(names, arrays2);
        try {
            Class reflectClass = loader.loadClass(mangledName);
            Type.registerTypeForClass(reflectClass, clas);
            return clas;
        }
        catch (ClassNotFoundException ex) {
            throw new InternalError(ex.toString());
        }
    }

    public static LList typeFieldNames(Class clas) {
        LList list = LList.Empty;
        ClassType ctype = (ClassType)Type.make(clas);
        Vector<SimpleSymbol> vec = new Vector<SimpleSymbol>(100);
        for (gnu.bytecode.Field field = ctype.getFields(); field != null; field = field.getNext()) {
            if ((field.getModifiers() & 9) != 1) continue;
            vec.addElement(SimpleSymbol.valueOf(field.getSourceName()));
        }
        int i = vec.size();
        while (--i >= 0) {
            list = new Pair(vec.elementAt(i), list);
        }
        return list;
    }

    public static LList typeFieldNames(ClassType ctype) {
        return Record.typeFieldNames(ctype.getReflectClass());
    }
}

