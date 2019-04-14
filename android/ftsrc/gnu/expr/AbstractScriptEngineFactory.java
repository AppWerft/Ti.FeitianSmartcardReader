package gnu.expr;

import gnu.mapping.InheritingEnvironment;
import gnu.mapping.NamedLocation;
import gnu.mapping.Symbol;
import java.util.List;
import javax.script.Bindings;

public abstract class AbstractScriptEngineFactory implements javax.script.ScriptEngineFactory
{
  Language language;
  protected List<String> names;
  private static List<String> noMimeTypes;
  InheritingEnvironment savedEnvironment;
  Bindings saveEngineBindings;
  Bindings saveGlobalBindings;
  
  gnu.mapping.Environment getEnvironment(javax.script.ScriptContext ctx)
  {
    Bindings ebindings = ctx.getBindings(100);
    Bindings gbindings = ctx.getBindings(200);
    if ((ebindings == saveEngineBindings) && (gbindings == saveGlobalBindings))
      return savedEnvironment;
    InheritingEnvironment env = new BindingsEnvironment("environment-" + ++Language.envCounter, ebindings, gbindings, language.getLangEnvironment());
    


    savedEnvironment = env;
    saveEngineBindings = ebindings;
    saveGlobalBindings = gbindings;
    return env;
  }
  
  protected AbstractScriptEngineFactory(Language language)
  {
    this.language = language;
  }
  
  public String getEngineName()
  {
    return "Kawa-" + language.getName();
  }
  
  public String getEngineVersion()
  {
    return kawa.Version.getVersion();
  }
  
  public String getLanguageVersion()
  {
    return kawa.Version.getVersion();
  }
  
  public String getLanguageName()
  {
    return language.getName();
  }
  
  public List<String> getExtensions() {
    return language.getExtensions();
  }
  
  public List<String> getMimeTypes()
  {
    if (noMimeTypes == null)
      noMimeTypes = java.util.Collections.unmodifiableList(new java.util.ArrayList(0));
    return noMimeTypes;
  }
  
  public List<String> getNames()
  {
    if (names == null)
    {
      java.util.ArrayList<String> n = new java.util.ArrayList(3);
      getNames(n);
      names = java.util.Collections.unmodifiableList(n);
    }
    return names;
  }
  
  protected void getNames(List<String> names)
  {
    names.add(language.getName());
  }
  
  public String getMethodCallSyntax(String obj, String m, String... args)
  {
    throw new UnsupportedOperationException(getClass().getName() + ".getMethodCalSyntax not supported");
  }
  
  public String getOutputStatement(String toDisplay)
  {
    throw new UnsupportedOperationException(getClass().getName() + ".getOutputStatement not supported");
  }
  
  public String getProgram(String... statements)
  {
    throw new UnsupportedOperationException(getClass().getName() + ".getProgram not supported");
  }
  
  public javax.script.ScriptEngine getScriptEngine()
  {
    return new KawaScriptEngine(this);
  }
  
  public String getParameter(String key)
  {
    if (key.equals("javax.script.engine"))
      return getEngineName();
    if (key.equals("javax.script.engine_version"))
      return getEngineVersion();
    if (key.equals("javax.script.name"))
      return getEngineName();
    if (key.equals("javax.script.language"))
      return getLanguageName();
    if (key.equals("javax.script.language_version"))
      return getLanguageVersion();
    if (key.equals("THREADING"))
      return "MULTITHREADED";
    return null;
  }
  
  public static class BindingsLocation extends NamedLocation<Object>
  {
    final AbstractScriptEngineFactory.BindingsEnvironment env;
    final String sname;
    
    public BindingsLocation(gnu.mapping.SimpleSymbol name, AbstractScriptEngineFactory.BindingsEnvironment env) {
      super(null);
      this.env = env;
      sname = name.getName();
      setAlias(null);
    }
    
    public Object get(Object defaultValue) { Object r = env.ebindings.get(sname);
      if ((r != null) || (env.ebindings.containsKey(sname)))
        return r;
      r = env.gbindings.get(sname);
      if ((r != null) || (env.gbindings.containsKey(sname)))
        return r;
      return defaultValue;
    }
    
    public Object get() { Object unbound = gnu.mapping.Location.UNBOUND;
      Object v = get(unbound);
      if (v == unbound)
        throw new gnu.mapping.UnboundLocationException(sname);
      return v;
    }
    
    public boolean isBound() {
      Object unbound = get(gnu.mapping.Location.UNBOUND);
      return get(unbound) == unbound;
    }
    
    public void set(Object newValue) {
      env.ebindings.put(sname, newValue);
    }
    
    public gnu.mapping.Environment getEnvironment() {
      return env;
    }
  }
  
  public static class BindingsEnvironment extends InheritingEnvironment
  {
    Bindings ebindings;
    Bindings gbindings;
    
    public BindingsEnvironment(String name, Bindings ebindings, Bindings gbindings, gnu.mapping.Environment builtin) {
      super(builtin);
      this.ebindings = ebindings;
      this.gbindings = gbindings;
    }
    
    protected NamedLocation newLocation(Symbol name, Object property) {
      if ((property == null) && ((name instanceof gnu.mapping.SimpleSymbol))) {
        return new AbstractScriptEngineFactory.BindingsLocation((gnu.mapping.SimpleSymbol)name, this);
      }
      return super.newLocation(name, property);
    }
    
    public NamedLocation lookupDirect(Symbol name, Object property, int hash) {
      NamedLocation loc = super.lookupDirect(name, property, hash);
      if ((loc != null) && (loc.isBound()))
        return loc;
      if ((ebindings instanceof KawaScriptBindings)) {
        loc = ebindings).environment.lookup(name, property, hash);
        if ((loc != null) && (loc.isBound()))
          return loc;
      } else if ((property == null) && ((name instanceof gnu.mapping.SimpleSymbol))) {
        String sname = name.getName();
        if (ebindings.containsKey(sname))
          return addUnboundLocation(name, property, hash);
      }
      if ((gbindings instanceof KawaScriptBindings)) {
        loc = gbindings).environment.lookup(name, property, hash);
        if ((loc != null) && (loc.isBound()))
          return loc;
      } else if ((property == null) && ((name instanceof gnu.mapping.SimpleSymbol))) {
        String sname = name.getName();
        if (gbindings.containsKey(sname))
          return addUnboundLocation(name, property, hash);
      }
      return loc;
    }
    

    public void define(Symbol key, Object property, Object newValue) { put(key, property, newValue); }
    
    public void fixEntries() {
      for (String key : ebindings.keySet()) {
        lookup(Symbol.valueOf(key));
      }
      for (String key : gbindings.keySet())
        lookup(Symbol.valueOf(key));
    }
    
    public gnu.mapping.LocationEnumeration enumerateLocations() {
      fixEntries();
      return super.enumerateLocations();
    }
    
    public gnu.mapping.LocationEnumeration enumerateAllLocations() { fixEntries();
      return super.enumerateAllLocations();
    }
  }
}
