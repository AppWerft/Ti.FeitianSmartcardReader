// 
// Decompiled by Procyon v0.5.36
// 

package gnu.expr;

import java.util.Map;
import gnu.mapping.LocationEnumeration;
import java.util.Iterator;
import gnu.mapping.UnboundLocationException;
import gnu.mapping.Location;
import gnu.mapping.Symbol;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.NamedLocation;
import javax.script.ScriptEngine;
import java.util.Collections;
import java.util.ArrayList;
import kawa.Version;
import gnu.mapping.Environment;
import javax.script.ScriptContext;
import javax.script.Bindings;
import gnu.mapping.InheritingEnvironment;
import java.util.List;
import javax.script.ScriptEngineFactory;

public abstract class AbstractScriptEngineFactory implements ScriptEngineFactory
{
    Language language;
    protected List<String> names;
    private static List<String> noMimeTypes;
    InheritingEnvironment savedEnvironment;
    Bindings saveEngineBindings;
    Bindings saveGlobalBindings;
    
    Environment getEnvironment(final ScriptContext ctx) {
        final Bindings ebindings = ctx.getBindings(100);
        final Bindings gbindings = ctx.getBindings(200);
        if (ebindings == this.saveEngineBindings && gbindings == this.saveGlobalBindings) {
            return this.savedEnvironment;
        }
        final InheritingEnvironment env = new BindingsEnvironment("environment-" + ++Language.envCounter, ebindings, gbindings, this.language.getLangEnvironment());
        this.savedEnvironment = env;
        this.saveEngineBindings = ebindings;
        this.saveGlobalBindings = gbindings;
        return env;
    }
    
    protected AbstractScriptEngineFactory(final Language language) {
        this.language = language;
    }
    
    @Override
    public String getEngineName() {
        return "Kawa-" + this.language.getName();
    }
    
    @Override
    public String getEngineVersion() {
        return Version.getVersion();
    }
    
    @Override
    public String getLanguageVersion() {
        return Version.getVersion();
    }
    
    @Override
    public String getLanguageName() {
        return this.language.getName();
    }
    
    @Override
    public List<String> getExtensions() {
        return this.language.getExtensions();
    }
    
    @Override
    public List<String> getMimeTypes() {
        if (AbstractScriptEngineFactory.noMimeTypes == null) {
            AbstractScriptEngineFactory.noMimeTypes = Collections.unmodifiableList((List<? extends String>)new ArrayList<String>(0));
        }
        return AbstractScriptEngineFactory.noMimeTypes;
    }
    
    @Override
    public List<String> getNames() {
        if (this.names == null) {
            final ArrayList<String> n = new ArrayList<String>(3);
            this.getNames(n);
            this.names = Collections.unmodifiableList((List<? extends String>)n);
        }
        return this.names;
    }
    
    protected void getNames(final List<String> names) {
        names.add(this.language.getName());
    }
    
    @Override
    public String getMethodCallSyntax(final String obj, final String m, final String... args) {
        throw new UnsupportedOperationException(this.getClass().getName() + ".getMethodCalSyntax not supported");
    }
    
    @Override
    public String getOutputStatement(final String toDisplay) {
        throw new UnsupportedOperationException(this.getClass().getName() + ".getOutputStatement not supported");
    }
    
    @Override
    public String getProgram(final String... statements) {
        throw new UnsupportedOperationException(this.getClass().getName() + ".getProgram not supported");
    }
    
    @Override
    public ScriptEngine getScriptEngine() {
        return new KawaScriptEngine(this);
    }
    
    @Override
    public String getParameter(final String key) {
        if (key.equals("javax.script.engine")) {
            return this.getEngineName();
        }
        if (key.equals("javax.script.engine_version")) {
            return this.getEngineVersion();
        }
        if (key.equals("javax.script.name")) {
            return this.getEngineName();
        }
        if (key.equals("javax.script.language")) {
            return this.getLanguageName();
        }
        if (key.equals("javax.script.language_version")) {
            return this.getLanguageVersion();
        }
        if (key.equals("THREADING")) {
            return "MULTITHREADED";
        }
        return null;
    }
    
    public static class BindingsLocation extends NamedLocation<Object>
    {
        final BindingsEnvironment env;
        final String sname;
        
        public BindingsLocation(final SimpleSymbol name, final BindingsEnvironment env) {
            super(name, null);
            this.env = env;
            this.sname = name.getName();
            this.setAlias(null);
        }
        
        @Override
        public Object get(final Object defaultValue) {
            Object r = this.env.ebindings.get(this.sname);
            if (r != null || this.env.ebindings.containsKey(this.sname)) {
                return r;
            }
            r = this.env.gbindings.get(this.sname);
            if (r != null || this.env.gbindings.containsKey(this.sname)) {
                return r;
            }
            return defaultValue;
        }
        
        @Override
        public Object get() {
            final Object unbound = Location.UNBOUND;
            final Object v = this.get(unbound);
            if (v == unbound) {
                throw new UnboundLocationException((Object)this.sname);
            }
            return v;
        }
        
        @Override
        public boolean isBound() {
            final Object unbound = this.get(Location.UNBOUND);
            return this.get(unbound) == unbound;
        }
        
        @Override
        public void set(final Object newValue) {
            this.env.ebindings.put(this.sname, newValue);
        }
        
        @Override
        public Environment getEnvironment() {
            return this.env;
        }
    }
    
    public static class BindingsEnvironment extends InheritingEnvironment
    {
        Bindings ebindings;
        Bindings gbindings;
        
        public BindingsEnvironment(final String name, final Bindings ebindings, final Bindings gbindings, final Environment builtin) {
            super(name, builtin);
            this.ebindings = ebindings;
            this.gbindings = gbindings;
        }
        
        @Override
        protected NamedLocation newLocation(final Symbol name, final Object property) {
            if (property == null && name instanceof SimpleSymbol) {
                return new BindingsLocation((SimpleSymbol)name, this);
            }
            return super.newLocation(name, property);
        }
        
        @Override
        public NamedLocation lookupDirect(final Symbol name, final Object property, final int hash) {
            NamedLocation loc = super.lookupDirect(name, property, hash);
            if (loc != null && loc.isBound()) {
                return loc;
            }
            if (this.ebindings instanceof KawaScriptBindings) {
                loc = ((KawaScriptBindings)this.ebindings).environment.lookup(name, property, hash);
                if (loc != null && loc.isBound()) {
                    return loc;
                }
            }
            else if (property == null && name instanceof SimpleSymbol) {
                final String sname = name.getName();
                if (this.ebindings.containsKey(sname)) {
                    return this.addUnboundLocation(name, property, hash);
                }
            }
            if (this.gbindings instanceof KawaScriptBindings) {
                loc = ((KawaScriptBindings)this.gbindings).environment.lookup(name, property, hash);
                if (loc != null && loc.isBound()) {
                    return loc;
                }
            }
            else if (property == null && name instanceof SimpleSymbol) {
                final String sname = name.getName();
                if (this.gbindings.containsKey(sname)) {
                    return this.addUnboundLocation(name, property, hash);
                }
            }
            return loc;
        }
        
        @Override
        public void define(final Symbol key, final Object property, final Object newValue) {
            this.put(key, property, newValue);
        }
        
        public void fixEntries() {
            for (final String key : ((Map<String, V>)this.ebindings).keySet()) {
                this.lookup(Symbol.valueOf(key));
            }
            for (final String key : ((Map<String, V>)this.gbindings).keySet()) {
                this.lookup(Symbol.valueOf(key));
            }
        }
        
        @Override
        public LocationEnumeration enumerateLocations() {
            this.fixEntries();
            return super.enumerateLocations();
        }
        
        @Override
        public LocationEnumeration enumerateAllLocations() {
            this.fixEntries();
            return super.enumerateAllLocations();
        }
    }
}
