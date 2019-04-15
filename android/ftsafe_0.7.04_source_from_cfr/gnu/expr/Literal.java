/*
 * Decompiled with CFR 0.139.
 */
package gnu.expr;

import gnu.bytecode.ClassType;
import gnu.bytecode.Field;
import gnu.bytecode.ObjectType;
import gnu.bytecode.Type;
import gnu.expr.Compilation;
import gnu.expr.LitTable;

public class Literal {
    Literal next;
    public Field field;
    Object value;
    int index;
    public Type type;
    public int flags;
    static final int WRITING = 1;
    static final int WRITTEN = 2;
    static final int CYCLIC = 4;
    static final int EMITTED = 8;
    Object[] argValues;
    Type[] argTypes;
    public static final Literal nullLiteral = new Literal(null, Type.nullType);

    public final Object getValue() {
        return this.value;
    }

    void assign(LitTable litTable) {
        this.assign((String)null, litTable);
    }

    void assign(String name, LitTable litTable) {
        int flags;
        int n = flags = litTable.comp.immediate ? 9 : 24;
        if (name == null) {
            this.index = litTable.literalsCount++;
            name = "Lit" + this.index;
        } else {
            flags |= 1;
        }
        this.assign(litTable.mainClass.addField(name, this.type, flags), litTable);
    }

    void assign(Field field, LitTable litTable) {
        this.next = litTable.literalsChain;
        litTable.literalsChain = this;
        this.field = field;
    }

    public Literal(Object value, LitTable litTable) {
        this(value, (String)null, litTable);
    }

    public Literal(Object value, String name, LitTable litTable) {
        this(value, Type.make(value.getClass()));
        litTable.put(value, this);
        this.assign(name, litTable);
    }

    public Literal(Object value, Field field, LitTable litTable) {
        this(value, field.getType());
        litTable.put(value, this);
        this.field = field;
        this.flags = 10;
    }

    public Literal(Object value, Type type, LitTable litTable) {
        this(value, type);
        litTable.put(value, this);
    }

    Literal(Object value, Type type) {
        this.value = value;
        this.type = type;
    }
}

