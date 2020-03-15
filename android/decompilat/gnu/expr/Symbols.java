// 
// Decompiled by Procyon v0.5.36
// 

package gnu.expr;

import gnu.mapping.Symbol;
import gnu.mapping.SimpleSymbol;

public class Symbols
{
    private static int gensym_counter;
    
    private Symbols() {
    }
    
    static synchronized int generateInt() {
        return ++Symbols.gensym_counter;
    }
    
    public static final SimpleSymbol gentemp() {
        return Symbol.valueOf("GS." + Integer.toString(generateInt()));
    }
    
    public static String make(final String name) {
        return name.intern();
    }
    
    public static final String intern(final String name) {
        return make(name);
    }
}
