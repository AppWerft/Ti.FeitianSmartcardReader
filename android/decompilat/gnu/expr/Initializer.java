// 
// Decompiled by Procyon v0.5.36
// 

package gnu.expr;

import gnu.bytecode.Field;

public abstract class Initializer
{
    Initializer next;
    public Field field;
    
    public abstract void emit(final Compilation p0);
    
    public static Initializer reverse(Initializer list) {
        Initializer prev = null;
        while (list != null) {
            final Initializer next = list.next;
            list.next = prev;
            prev = list;
            list = next;
        }
        return prev;
    }
    
    public void reportError(final String message, final Compilation comp) {
        comp.error('e', message + "field " + this.field);
    }
}
