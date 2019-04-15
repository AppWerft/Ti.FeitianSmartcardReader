/*
 * Decompiled with CFR 0.139.
 */
package gnu.expr;

import gnu.expr.KawaScriptBindings;
import gnu.expr.KawaScriptEngine;
import gnu.expr.Language;
import gnu.mapping.Environment;
import gnu.mapping.InheritingEnvironment;
import gnu.mapping.Location;
import gnu.mapping.LocationEnumeration;
import gnu.mapping.NamedLocation;
import gnu.mapping.SimpleEnvironment;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Symbol;
import gnu.mapping.UnboundLocationException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import javax.script.Bindings;
import javax.script.ScriptContext;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineFactory;
import kawa.Version;

public abstract class AbstractScriptEngineFactory
implements ScriptEngineFactory {
    Language language;
    protected List<String> names;
    private static List<String> noMimeTypes;
    InheritingEnvironment savedEnvironment;
    Bindings saveEngineBindings;
    Bindings saveGlobalBindings;

    Environment getEnvironment(ScriptContext ctx) {
        Bindings ebindings = ctx.getBindings(100);
        Bindings gbindings = ctx.getBindings(200);
        if (ebindings == this.saveEngineBindings && gbindings == this.saveGlobalBindings) {
            return this.savedEnvironment;
        }
        BindingsEnvironment env = new BindingsEnvironment("environment-" + ++Language.envCounter, ebindings, gbindings, this.language.getLangEnvironment());
        this.savedEnvironment = env;
        this.saveEngineBindings = ebindings;
        this.saveGlobalBindings = gbindings;
        return env;
    }

    protected AbstractScriptEngineFactory(Language language) {
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
        if (noMimeTypes == null) {
            noMimeTypes = Collections.unmodifiableList(new ArrayList(0));
        }
        return noMimeTypes;
    }

    @Override
    public List<String> getNames() {
        if (this.names == null) {
            ArrayList<String> n = new ArrayList<String>(3);
            this.getNames(n);
            this.names = Collections.unmodifiableList(n);
        }
        return this.names;
    }

    protected void getNames(List<String> names) {
        names.add(this.language.getName());
    }

    @Override
    public /* varargs */ String getMethodCallSyntax(String obj, String m, String ... args) {
        throw new UnsupportedOperationException(this.getClass().getName() + ".getMethodCalSyntax not supported");
    }

    @Override
    public String getOutputStatement(String toDisplay) {
        throw new UnsupportedOperationException(this.getClass().getName() + ".getOutputStatement not supported");
    }

    @Override
    public /* varargs */ String getProgram(String ... statements) {
        throw new UnsupportedOperationException(this.getClass().getName() + ".getProgram not supported");
    }

    @Override
    public ScriptEngine getScriptEngine() {
        return new KawaScriptEngine(this);
    }

    @Override
    public String getParameter(String key) {
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

    public static class BindingsEnvironment
    extends InheritingEnvironment {
        Bindings ebindings;
        Bindings gbindings;

        public BindingsEnvironment(String name, Bindings ebindings, Bindings gbindings, Environment builtin) {
            super(name, builtin);
            this.ebindings = ebindings;
            this.gbindings = gbindings;
        }

        @Override
        protected NamedLocation newLocation(Symbol name, Object property) {
            if (property == null && name instanceof SimpleSymbol) {
                return new BindingsLocation((SimpleSymbol)name, this);
            }
            return super.newLocation(name, property);
        }

        @Override
        public NamedLocation lookupDirect(Symbol name, Object property, int hash) {
            String sname;
            NamedLocation loc = super.lookupDirect(name, property, hash);
            if (loc != null && loc.isBound()) {
                return loc;
            }
            if (this.ebindings instanceof KawaScriptBindings) {
                loc = ((KawaScriptBindings)this.ebindings).environment.lookup(name, property, hash);
                if (loc != null && loc.isBound()) {
                    return loc;
                }
            } else if (property == null && name instanceof SimpleSymbol && this.ebindings.containsKey(sname = name.getName())) {
                return this.addUnboundLocation(name, property, hash);
            }
            if (this.gbindings instanceof KawaScriptBindings) {
                loc = ((KawaScriptBindings)this.gbindings).environment.lookup(name, property, hash);
                if (loc != null && loc.isBound()) {
                    return loc;
                }
            } else if (property == null && name instanceof SimpleSymbol && this.gbindings.containsKey(sname = name.getName())) {
                return this.addUnboundLocation(name, property, hash);
            }
            return loc;
        }

        @Override
        public void define(Symbol key, Object property, Object newValue) {
            this.put(key, property, newValue);
        }

        public void fixEntries() {
            for (String key : this.ebindings.keySet()) {
                this.lookup(Symbol.valueOf(key));
            }
            for (String key : this.gbindings.keySet()) {
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

    public static class BindingsLocation
    extends NamedLocation<Object> {
        final BindingsEnvironment env;
        final String sname;

        public BindingsLocation(SimpleSymbol name, BindingsEnvironment env) {
            super(name, null);
            this.env = env;
            this.sname = name.getName();
            this.setAlias(null);
        }

        @Override
        public Object get(Object defaultValue) {
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
            String unbound = Location.UNBOUND;
            Object v = this.get(unbound);
            if (v == unbound) {
                throw new UnboundLocationException(this.sname);
            }
            return v;
        }

        @Override
        public boolean isBound() {
            Object unbound = this.get(Location.UNBOUND);
            return this.get(unbound) == unbound;
        }

        @Override
        public void set(Object newValue) {
            this.env.ebindings.put(this.sname, newValue);
        }

        @Override
        public Environment getEnvironment() {
            return this.env;
        }
    }

}

