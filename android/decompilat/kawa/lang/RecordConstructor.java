// 
// Decompiled by Procyon v0.5.36
// 

package kawa.lang;

import gnu.mapping.WrappedException;
import gnu.mapping.Procedure;
import gnu.mapping.WrongArguments;
import gnu.lists.Pair;
import gnu.lists.LList;
import gnu.bytecode.Type;
import gnu.bytecode.Field;
import gnu.bytecode.ClassType;
import gnu.mapping.ProcedureN;

public class RecordConstructor extends ProcedureN
{
    ClassType type;
    Field[] fields;
    
    public RecordConstructor(final ClassType type, final Field[] fields) {
        this.type = type;
        this.fields = fields;
    }
    
    public RecordConstructor(final Class clas, final Field[] fields) {
        this((ClassType)Type.make(clas), fields);
    }
    
    public RecordConstructor(final Class clas) {
        this.init((ClassType)Type.make(clas));
    }
    
    public RecordConstructor(final ClassType type) {
        this.init(type);
    }
    
    private void init(final ClassType type) {
        this.type = type;
        final Field list = type.getFields();
        int count = 0;
        for (Field fld = list; fld != null; fld = fld.getNext()) {
            if ((fld.getModifiers() & 0x9) == 0x1) {
                ++count;
            }
        }
        this.fields = new Field[count];
        int i = 0;
        for (Field fld2 = list; fld2 != null; fld2 = fld2.getNext()) {
            if ((fld2.getModifiers() & 0x9) == 0x1) {
                this.fields[i++] = fld2;
            }
        }
    }
    
    public RecordConstructor(final Class clas, final Object fieldsList) {
        this((ClassType)Type.make(clas), fieldsList);
    }
    
    public RecordConstructor(final ClassType type, Object fieldsList) {
        this.type = type;
        if (fieldsList == null) {
            this.init(type);
        }
        else {
            final int nfields = LList.listLength(fieldsList, false);
            this.fields = new Field[nfields];
            final Field list = type.getFields();
            int i = 0;
        Label_0044:
            while (i < nfields) {
                final Pair pair = (Pair)fieldsList;
                final String fname = pair.getCar().toString();
                for (Field fld = list; fld != null; fld = fld.getNext()) {
                    if (fld.getSourceName() == fname) {
                        this.fields[i] = fld;
                        fieldsList = pair.getCdr();
                        ++i;
                        continue Label_0044;
                    }
                }
                throw new RuntimeException("no such field " + fname + " in " + type.getName());
            }
        }
    }
    
    @Override
    public int numArgs() {
        final int nargs = this.fields.length;
        return nargs << 12 | nargs;
    }
    
    @Override
    public String getName() {
        return this.type.getName() + " constructor";
    }
    
    @Override
    public Object applyN(final Object[] args) {
        Object obj;
        try {
            obj = this.type.getReflectClass().newInstance();
        }
        catch (InstantiationException ex) {
            throw new GenericError(ex.toString());
        }
        catch (IllegalAccessException ex2) {
            throw new GenericError(ex2.toString());
        }
        if (args.length != this.fields.length) {
            throw new WrongArguments(this, args.length);
        }
        for (int i = 0; i < args.length; ++i) {
            final Field fld = this.fields[i];
            try {
                fld.getReflectField().set(obj, args[i]);
            }
            catch (Exception ex3) {
                throw new WrappedException("illegal access for field " + fld.getName(), ex3);
            }
        }
        return obj;
    }
}
