// 
// Decompiled by Procyon v0.5.36
// 

package gnu.expr;

import gnu.kawa.util.AbstractHashTable;
import gnu.bytecode.Type;
import gnu.bytecode.Field;

public class Literal
{
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
    public static final Literal nullLiteral;
    
    public final Object getValue() {
        return this.value;
    }
    
    void assign(final LitTable litTable) {
        this.assign((String)null, litTable);
    }
    
    void assign(String name, final LitTable litTable) {
        int flags = litTable.comp.immediate ? 9 : 24;
        if (name == null) {
            this.index = litTable.literalsCount++;
            name = "Lit" + this.index;
        }
        else {
            flags |= 0x1;
        }
        this.assign(litTable.mainClass.addField(name, this.type, flags), litTable);
    }
    
    void assign(final Field field, final LitTable litTable) {
        this.next = litTable.literalsChain;
        litTable.literalsChain = this;
        this.field = field;
    }
    
    public Literal(final Object value, final LitTable litTable) {
        this(value, (String)null, litTable);
    }
    
    public Literal(final Object value, final String name, final LitTable litTable) {
        this(value, Type.make(value.getClass()));
        ((AbstractHashTable<Entry, K, V>)litTable).put((K)value, (V)this);
        this.assign(name, litTable);
    }
    
    public Literal(final Object value, final Field field, final LitTable litTable) {
        this(value, field.getType());
        ((AbstractHashTable<Entry, K, V>)litTable).put((K)value, (V)this);
        this.field = field;
        this.flags = 10;
    }
    
    public Literal(final Object value, final Type type, final LitTable litTable) {
        this(value, type);
        ((AbstractHashTable<Entry, K, V>)litTable).put((K)value, (V)this);
    }
    
    Literal(final Object value, final Type type) {
        this.value = value;
        this.type = type;
    }
    
    static {
        nullLiteral = new Literal(null, Type.nullType);
    }
}
