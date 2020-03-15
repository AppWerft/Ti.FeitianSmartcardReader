// 
// Decompiled by Procyon v0.5.36
// 

package gnu.expr;

import gnu.mapping.Location;
import gnu.mapping.LocationEnumeration;
import gnu.mapping.NamedLocation;
import gnu.mapping.Symbol;
import gnu.mapping.Environment;

public class BuiltinEnvironment extends Environment
{
    static final BuiltinEnvironment instance;
    
    private BuiltinEnvironment() {
    }
    
    public static BuiltinEnvironment getInstance() {
        return BuiltinEnvironment.instance;
    }
    
    public Environment getLangEnvironment() {
        final Language lang = Language.getDefaultLanguage();
        return (lang == null) ? null : lang.getLangEnvironment();
    }
    
    @Override
    public NamedLocation lookup(final Symbol name, final Object property, final int hash) {
        final Language lang = Language.getDefaultLanguage();
        return (lang == null) ? null : lang.lookupBuiltin(name, property, hash);
    }
    
    @Override
    public NamedLocation getLocation(final Symbol key, final Object property, final int hash, final boolean create) {
        throw new RuntimeException();
    }
    
    @Override
    public void define(final Symbol key, final Object property, final Object newValue) {
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
    protected boolean hasMoreElements(final LocationEnumeration it) {
        throw new RuntimeException();
    }
    
    @Override
    public NamedLocation addLocation(final Symbol name, final Object prop, final Location loc) {
        throw new RuntimeException();
    }
    
    static {
        (instance = new BuiltinEnvironment()).setName("language-builtins");
    }
}
