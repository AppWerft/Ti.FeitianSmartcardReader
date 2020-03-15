// 
// Decompiled by Procyon v0.5.36
// 

package gnu.mapping;

import gnu.lists.LList;
import gnu.lists.Pair;

public class PropertyLocation extends Location<Object>
{
    Pair pair;
    
    @Override
    public final Object get() {
        return this.pair.getCar();
    }
    
    @Override
    public boolean isBound() {
        return true;
    }
    
    @Override
    public final void set(final Object newValue) {
        this.pair.setCar(newValue);
    }
    
    public static Object getPropertyList(final Object symbol, final Environment env) {
        return env.get(Symbol.PLIST, symbol, LList.Empty);
    }
    
    public static Object getPropertyList(final Object symbol) {
        return Environment.getCurrent().get(Symbol.PLIST, symbol, LList.Empty);
    }
    
    public static void setPropertyList(final Object symbol, final Object plist, final Environment env) {
        synchronized (env) {
            final Location lloc = env.lookup(Symbol.PLIST, symbol);
            if (symbol instanceof Symbol) {
                final Symbol sym = (Symbol)symbol;
                Object p;
                Pair pair;
                for (Object old = p = lloc.get(LList.Empty); p instanceof Pair; p = ((Pair)pair.getCdr()).getCdr()) {
                    pair = (Pair)p;
                    final Object property = pair.getCar();
                    if (plistGet(plist, property, null) != null) {
                        env.remove(sym, property);
                    }
                }
                Pair valuePair;
                for (p = plist; p instanceof Pair; p = valuePair.getCdr()) {
                    pair = (Pair)p;
                    final Object property = pair.getCar();
                    Location loc = env.lookup(sym, property);
                    PropertyLocation ploc;
                    if (loc != null && (loc = loc.getBase()) instanceof PropertyLocation) {
                        ploc = (PropertyLocation)loc;
                    }
                    else {
                        ploc = new PropertyLocation();
                        env.addLocation(sym, property, ploc);
                    }
                    valuePair = (Pair)pair.getCdr();
                    ploc.pair = valuePair;
                }
            }
            lloc.set(plist);
        }
    }
    
    public static void setPropertyList(final Object symbol, final Object plist) {
        setPropertyList(symbol, plist, Environment.getCurrent());
    }
    
    public static Object getProperty(Object symbol, final Object property, final Object defaultValue, final Environment env) {
        if (!(symbol instanceof Symbol)) {
            if (!(symbol instanceof String)) {
                return plistGet(env.get(Symbol.PLIST, symbol, LList.Empty), property, defaultValue);
            }
            symbol = Namespace.getDefaultSymbol((String)symbol);
        }
        return env.get((Symbol)symbol, property, defaultValue);
    }
    
    public static Object getProperty(final Object symbol, final Object property, final Object defaultValue) {
        return getProperty(symbol, property, defaultValue, Environment.getCurrent());
    }
    
    public static void putProperty(Object symbol, final Object property, final Object newValue, final Environment env) {
        if (!(symbol instanceof Symbol)) {
            if (!(symbol instanceof String)) {
                final Location lloc = env.getLocation(Symbol.PLIST, symbol);
                lloc.set(plistPut(lloc.get(LList.Empty), property, newValue));
                return;
            }
            symbol = Namespace.getDefaultSymbol((String)symbol);
        }
        Location loc = env.lookup((Symbol)symbol, property);
        if (loc != null && (loc = loc.getBase()) instanceof PropertyLocation) {
            ((PropertyLocation)loc).set(newValue);
        }
        else {
            final Location lloc2 = env.getLocation(Symbol.PLIST, symbol);
            Object plist = lloc2.get(LList.Empty);
            Pair pair = null;
            pair = new Pair(newValue, plist);
            plist = new Pair(property, pair);
            lloc2.set(plist);
            final PropertyLocation ploc = new PropertyLocation();
            ploc.pair = pair;
            env.addLocation((Symbol)symbol, property, ploc);
        }
    }
    
    public static void putProperty(final Object symbol, final Object property, final Object newValue) {
        putProperty(symbol, property, newValue, Environment.getCurrent());
    }
    
    public static boolean removeProperty(final Object symbol, final Object property, final Environment env) {
        final Location ploc = env.lookup(Symbol.PLIST, symbol);
        if (ploc == null) {
            return false;
        }
        Object plist = ploc.get(LList.Empty);
        if (!(plist instanceof Pair)) {
            return false;
        }
        Pair pair = (Pair)plist;
        Pair prev = null;
        while (pair.getCar() != property) {
            final Object next = pair.getCdr();
            if (!(next instanceof Pair)) {
                return false;
            }
            prev = pair;
            pair = (Pair)next;
        }
        final Object tail = ((Pair)pair.getCdr()).getCdr();
        if (prev == null) {
            plist = tail;
            ploc.set(plist);
        }
        else {
            prev.setCdr(tail);
        }
        if (symbol instanceof Symbol) {
            env.remove((Symbol)symbol, property);
        }
        return true;
    }
    
    public static boolean removeProperty(final Object symbol, final Object property) {
        return removeProperty(symbol, property, Environment.getCurrent());
    }
    
    public static Object plistGet(final Object plist, final Object prop, final Object dfault) {
        while (plist instanceof Pair) {
            final Pair pair = (Pair)plist;
            if (pair.getCar() == prop) {
                return ((Pair)pair.getCdr()).getCar();
            }
        }
        return dfault;
    }
    
    public static Object plistPut(final Object plist, final Object prop, final Object value) {
        Pair next;
        for (Object p = plist; p instanceof Pair; p = next.getCdr()) {
            final Pair pair = (Pair)p;
            next = (Pair)pair.getCdr();
            if (pair.getCar() == prop) {
                next.setCar(value);
                return plist;
            }
        }
        return new Pair(prop, new Pair(value, plist));
    }
    
    public static Object plistRemove(final Object plist, final Object prop) {
        Pair prev = null;
        Object p = plist;
        while (p instanceof Pair) {
            final Pair pair = (Pair)p;
            final Pair next = (Pair)pair.getCdr();
            p = next.getCdr();
            if (pair.getCar() == prop) {
                if (prev == null) {
                    return p;
                }
                prev.setCdr(p);
                return plist;
            }
            else {
                prev = next;
            }
        }
        return plist;
    }
}
