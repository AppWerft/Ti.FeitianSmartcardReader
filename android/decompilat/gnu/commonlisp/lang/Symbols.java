// 
// Decompiled by Procyon v0.5.36
// 

package gnu.commonlisp.lang;

import gnu.mapping.EnvironmentKey;
import gnu.mapping.Namespace;
import gnu.mapping.Environment;
import gnu.mapping.Symbol;

public class Symbols
{
    private Symbols() {
    }
    
    public static boolean isSymbol(final Object val) {
        return val == Lisp2.FALSE || val instanceof Symbol;
    }
    
    public static boolean isBound(final Object sym) {
        if (sym == Lisp2.FALSE) {
            return true;
        }
        final Environment env = Environment.getCurrent();
        Symbol symbol;
        if (sym instanceof Symbol) {
            symbol = (Symbol)sym;
        }
        else {
            symbol = env.defaultNamespace().lookup((String)sym);
        }
        return symbol != null && env.isBound(symbol);
    }
    
    public static Symbol getSymbol(final Environment env, Object sym) {
        if (sym == Lisp2.FALSE) {
            sym = "nil";
        }
        return (Symbol)((sym instanceof Symbol) ? sym : env.defaultNamespace().getSymbol((String)sym));
    }
    
    public static Symbol getSymbol(Object sym) {
        if (sym == Lisp2.FALSE) {
            sym = "nil";
        }
        return (Symbol)((sym instanceof Symbol) ? sym : Namespace.getDefaultSymbol((String)sym));
    }
    
    public static Object getPrintName(final Object sym) {
        return (sym == Lisp2.FALSE) ? "nil" : Lisp2.getString(((Symbol)sym).getName());
    }
    
    public static Object getFunctionBinding(final Object symbol) {
        return Environment.getCurrent().getFunction(getSymbol(symbol));
    }
    
    public static Object getFunctionBinding(final Environment environ, final Object symbol) {
        return environ.getFunction(getSymbol(symbol));
    }
    
    public static void setFunctionBinding(final Environment environ, final Object symbol, final Object newValue) {
        environ.put(getSymbol(symbol), EnvironmentKey.FUNCTION, newValue);
    }
}
