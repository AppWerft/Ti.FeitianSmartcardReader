/*
 * Decompiled with CFR 0.139.
 */
package kawa.lang;

import gnu.bytecode.ClassType;
import gnu.bytecode.Type;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.mapping.Procedure;
import gnu.mapping.ProcedureN;
import gnu.mapping.WrappedException;
import gnu.mapping.WrongArguments;
import java.lang.reflect.Field;
import kawa.lang.GenericError;

public class RecordConstructor
extends ProcedureN {
    ClassType type;
    gnu.bytecode.Field[] fields;

    public RecordConstructor(ClassType type, gnu.bytecode.Field[] fields) {
        this.type = type;
        this.fields = fields;
    }

    public RecordConstructor(Class clas, gnu.bytecode.Field[] fields) {
        this((ClassType)Type.make(clas), fields);
    }

    public RecordConstructor(Class clas) {
        this.init((ClassType)Type.make(clas));
    }

    public RecordConstructor(ClassType type) {
        this.init(type);
    }

    private void init(ClassType type) {
        this.type = type;
        gnu.bytecode.Field list = type.getFields();
        int count = 0;
        for (gnu.bytecode.Field fld = list; fld != null; fld = fld.getNext()) {
            if ((fld.getModifiers() & 9) != 1) continue;
            ++count;
        }
        this.fields = new gnu.bytecode.Field[count];
        int i = 0;
        for (gnu.bytecode.Field fld = list; fld != null; fld = fld.getNext()) {
            if ((fld.getModifiers() & 9) != 1) continue;
            this.fields[i++] = fld;
        }
    }

    public RecordConstructor(Class clas, Object fieldsList) {
        this((ClassType)Type.make(clas), fieldsList);
    }

    public RecordConstructor(ClassType type, Object fieldsList) {
        this.type = type;
        if (fieldsList == null) {
            this.init(type);
        } else {
            int nfields = LList.listLength(fieldsList, false);
            this.fields = new gnu.bytecode.Field[nfields];
            gnu.bytecode.Field list = type.getFields();
            for (int i = 0; i < nfields; ++i) {
                Pair pair = (Pair)fieldsList;
                String fname = pair.getCar().toString();
                gnu.bytecode.Field fld = list;
                do {
                    if (fld == null) {
                        throw new RuntimeException("no such field " + fname + " in " + type.getName());
                    }
                    if (fld.getSourceName() == fname) break;
                    fld = fld.getNext();
                } while (true);
                this.fields[i] = fld;
                fieldsList = pair.getCdr();
            }
        }
    }

    @Override
    public int numArgs() {
        int nargs = this.fields.length;
        return nargs << 12 | nargs;
    }

    @Override
    public String getName() {
        return this.type.getName() + " constructor";
    }

    @Override
    public Object applyN(Object[] args) {
        Object obj;
        try {
            obj = this.type.getReflectClass().newInstance();
        }
        catch (InstantiationException ex) {
            throw new GenericError(ex.toString());
        }
        catch (IllegalAccessException ex) {
            throw new GenericError(ex.toString());
        }
        if (args.length != this.fields.length) {
            throw new WrongArguments(this, args.length);
        }
        for (int i = 0; i < args.length; ++i) {
            gnu.bytecode.Field fld = this.fields[i];
            try {
                fld.getReflectField().set(obj, args[i]);
                continue;
            }
            catch (Exception ex) {
                throw new WrappedException("illegal access for field " + fld.getName(), ex);
            }
        }
        return obj;
    }
}

