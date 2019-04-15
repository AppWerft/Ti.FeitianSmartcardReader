/*
 * Decompiled with CFR 0.139.
 */
package gnu.expr;

import gnu.expr.Language;
import gnu.mapping.Environment;
import gnu.mapping.Location;
import gnu.mapping.LocationEnumeration;
import gnu.mapping.NamedLocation;
import gnu.mapping.Symbol;

public class BuiltinEnvironment
extends Environment {
    static final BuiltinEnvironment instance = new BuiltinEnvironment();

    private BuiltinEnvironment() {
    }

    public static BuiltinEnvironment getInstance() {
        return instance;
    }

    public Environment getLangEnvironment() {
        Language lang = Language.getDefaultLanguage();
        return lang == null ? null : lang.getLangEnvironment();
    }

    @Override
    public NamedLocation lookup(Symbol name, Object property, int hash) {
        Language lang = Language.getDefaultLanguage();
        return lang == null ? null : lang.lookupBuiltin(name, property, hash);
    }

    @Override
    public NamedLocation getLocation(Symbol key, Object property, int hash, boolean create) {
        throw new RuntimeException();
    }

    @Override
    public void define(Symbol key, Object property, Object newValue) {
        throw new RuntimeException();
    }

    @Override
    public LocationEnumeration enumerateLocations() {
        return this.getLangEnvironment().enumerateLocations();
    }

    @Override
    public LocationEnumeration enumerateAllLocations() {
        return this.getLangEnvironment().enumerateAllLocations();
    }

    @Override
    protected boolean hasMoreElements(LocationEnumeration it) {
        throw new RuntimeException();
    }

    @Override
    public NamedLocation addLocation(Symbol name, Object prop, Location loc) {
        throw new RuntimeException();
    }

    static {
        instance.setName("language-builtins");
    }
}

