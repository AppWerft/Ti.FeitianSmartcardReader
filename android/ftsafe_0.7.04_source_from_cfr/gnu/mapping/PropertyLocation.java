/*
 * Decompiled with CFR 0.139.
 */
package gnu.mapping;

import gnu.lists.EmptyList;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.mapping.Environment;
import gnu.mapping.Location;
import gnu.mapping.NamedLocation;
import gnu.mapping.Namespace;
import gnu.mapping.Symbol;

public class PropertyLocation
extends Location<Object> {
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
    public final void set(Object newValue) {
        this.pair.setCar(newValue);
    }

    public static Object getPropertyList(Object symbol, Environment env) {
        return env.get(Symbol.PLIST, symbol, LList.Empty);
    }

    public static Object getPropertyList(Object symbol) {
        return Environment.getCurrent().get(Symbol.PLIST, symbol, LList.Empty);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void setPropertyList(Object symbol, Object plist, Environment env) {
        Environment environment = env;
        synchronized (environment) {
            Location lloc = env.lookup(Symbol.PLIST, symbol);
            if (symbol instanceof Symbol) {
                Object property;
                Pair pair;
                Symbol sym = (Symbol)symbol;
                EmptyList old = lloc.get(LList.Empty);
                Object p = old;
                while (p instanceof Pair) {
                    pair = (Pair)p;
                    property = pair.getCar();
                    if (PropertyLocation.plistGet(plist, property, null) != null) {
                        env.remove(sym, property);
                    }
                    p = ((Pair)pair.getCdr()).getCdr();
                }
                p = plist;
                while (p instanceof Pair) {
                    Pair valuePair;
                    PropertyLocation ploc;
                    pair = (Pair)p;
                    property = pair.getCar();
                    Location loc = env.lookup(sym, property);
                    if (loc != null && (loc = loc.getBase()) instanceof PropertyLocation) {
                        ploc = (PropertyLocation)loc;
                    } else {
                        ploc = new PropertyLocation();
                        env.addLocation(sym, property, ploc);
                    }
                    ploc.pair = valuePair = (Pair)pair.getCdr();
                    p = valuePair.getCdr();
                }
            }
            lloc.set(plist);
        }
    }

    public static void setPropertyList(Object symbol, Object plist) {
        PropertyLocation.setPropertyList(symbol, plist, Environment.getCurrent());
    }

    public static Object getProperty(Object symbol, Object property, Object defaultValue, Environment env) {
        if (!(symbol instanceof Symbol)) {
            if (symbol instanceof String) {
                symbol = Namespace.getDefaultSymbol((String)symbol);
            } else {
                return PropertyLocation.plistGet(env.get(Symbol.PLIST, symbol, LList.Empty), property, defaultValue);
            }
        }
        return env.get((Symbol)symbol, property, defaultValue);
    }

    public static Object getProperty(Object symbol, Object property, Object defaultValue) {
        return PropertyLocation.getProperty(symbol, property, defaultValue, Environment.getCurrent());
    }

    public static void putProperty(Object symbol, Object property, Object newValue, Environment env) {
        Location loc;
        if (!(symbol instanceof Symbol)) {
            if (symbol instanceof String) {
                symbol = Namespace.getDefaultSymbol((String)symbol);
            } else {
                Location lloc = env.getLocation(Symbol.PLIST, symbol);
                lloc.set(PropertyLocation.plistPut(lloc.get(LList.Empty), property, newValue));
                return;
            }
        }
        if ((loc = env.lookup((Symbol)symbol, property)) != null && (loc = loc.getBase()) instanceof PropertyLocation) {
            ((PropertyLocation)loc).set(newValue);
        } else {
            Location lloc = env.getLocation(Symbol.PLIST, symbol);
            LList plist = lloc.get(LList.Empty);
            Pair pair = null;
            pair = new Pair(newValue, plist);
            plist = new Pair(property, pair);
            lloc.set(plist);
            PropertyLocation ploc = new PropertyLocation();
            ploc.pair = pair;
            env.addLocation((Symbol)symbol, property, ploc);
        }
    }

    public static void putProperty(Object symbol, Object property, Object newValue) {
        PropertyLocation.putProperty(symbol, property, newValue, Environment.getCurrent());
    }

    public static boolean removeProperty(Object symbol, Object property, Environment env) {
        Location ploc = env.lookup(Symbol.PLIST, symbol);
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
            Object next = pair.getCdr();
            if (!(next instanceof Pair)) {
                return false;
            }
            prev = pair;
            pair = (Pair)next;
        }
        Object tail = ((Pair)pair.getCdr()).getCdr();
        if (prev == null) {
            plist = tail;
            ploc.set(plist);
        } else {
            prev.setCdr(tail);
        }
        if (symbol instanceof Symbol) {
            env.remove((Symbol)symbol, property);
        }
        return true;
    }

    public static boolean removeProperty(Object symbol, Object property) {
        return PropertyLocation.removeProperty(symbol, property, Environment.getCurrent());
    }

    public static Object plistGet(Object plist, Object prop, Object dfault) {
        while (plist instanceof Pair) {
            Pair pair = (Pair)plist;
            if (pair.getCar() != prop) continue;
            return ((Pair)pair.getCdr()).getCar();
        }
        return dfault;
    }

    public static Object plistPut(Object plist, Object prop, Object value) {
        Object p = plist;
        while (p instanceof Pair) {
            Pair pair = (Pair)p;
            Pair next = (Pair)pair.getCdr();
            if (pair.getCar() == prop) {
                next.setCar(value);
                return plist;
            }
            p = next.getCdr();
        }
        return new Pair(prop, new Pair(value, plist));
    }

    public static Object plistRemove(Object plist, Object prop) {
        Pair prev = null;
        Object p = plist;
        while (p instanceof Pair) {
            Pair pair = (Pair)p;
            Pair next = (Pair)pair.getCdr();
            p = next.getCdr();
            if (pair.getCar() == prop) {
                if (prev == null) {
                    return p;
                }
                prev.setCdr(p);
                return plist;
            }
            prev = next;
        }
        return plist;
    }
}

