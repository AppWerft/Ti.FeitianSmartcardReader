package gnu.expr;

import gnu.bytecode.ClassType;
import gnu.bytecode.Type;
import gnu.kawa.io.CharArrayInPort;
import gnu.kawa.io.InPort;
import gnu.kawa.io.Path;
import gnu.kawa.io.TtyInPort;
import gnu.kawa.util.AbstractWeakHashTable;
import gnu.mapping.WrappedException;
import gnu.text.Lexer;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

public class ModuleInfo
{
  protected String className;
  Class moduleClass;
  private Class oldClass;
  static ClassToInfoMap mapClassToInfo = new ClassToInfoMap();
  String uri;
  
  public ModuleInfo() {}
  
  public String getNamespaceUri() { return uri; }
  public void setNamespaceUri(String uri) { this.uri = uri; }
  




  public Compilation getCompilation() { return comp; }
  
  public void setCompilation(Compilation comp) {
    this.comp = comp;
    if (comp == null)
      return;
    ModuleExp mod = mainLambda;
    info = this;
    exp = mod;
    String fileName;
    if ((mod != null) && ((fileName = mod.getFileName()) != null)) {
      sourcePath = fileName;
      InPort port = lexer == null ? null : lexer.getPort();
      if ((!(port instanceof CharArrayInPort)) && (!(port instanceof TtyInPort)))
      {
        sourceAbsPath = absPath(fileName); }
    }
  }
  
  public void cleanupAfterCompilation() {
    if (comp != null)
      comp.cleanupAfterCompilation();
  }
  
  public static Path absPath(String path) {
    return Path.valueOf(path).getCanonical();
  }
  


  ModuleExp exp;
  

  private Compilation comp;
  

  ModuleInfo[] dependencies;
  

  int numDependencies;
  

  public String sourcePath;
  
  Path sourceAbsPath;
  
  String sourceAbsPathname;
  
  public long lastCheckedTime;
  
  public long lastModifiedTime;
  
  public Path getSourceAbsPath()
  {
    return sourceAbsPath;
  }
  
  public void setSourceAbsPath(Path path) {
    sourceAbsPath = path;
    sourceAbsPathname = null;
  }
  
  public String getSourceAbsPathname() {
    String str = sourceAbsPathname;
    if ((str == null) && (sourceAbsPath != null)) {
      str = sourceAbsPath.toString();
      sourceAbsPathname = str;
    }
    return str;
  }
  
  public synchronized void addDependency(ModuleInfo dep) {
    if (dependencies == null) {
      dependencies = new ModuleInfo[8];
    } else if (numDependencies == dependencies.length) {
      ModuleInfo[] deps = new ModuleInfo[2 * numDependencies];
      System.arraycopy(dependencies, 0, deps, 0, numDependencies);
      dependencies = deps;
    }
    dependencies[(numDependencies++)] = dep;
  }
  
  public synchronized ClassType getClassType() {
    if (moduleClass != null)
      return (ClassType)Type.make(moduleClass);
    if ((comp != null) && (comp.mainClass != null))
      return comp.mainClass;
    return ClassType.make(className);
  }
  
  public synchronized String getClassName() {
    if (className == null) {
      if (moduleClass != null) {
        className = moduleClass.getName();
      } else if ((comp != null) && (comp.mainClass != null))
        className = comp.mainClass.getName();
    }
    return className;
  }
  
  public void setClassName(String name) {
    className = name;
  }
  
  public ModuleExp getModuleExpRaw() { return exp; }
  
  public synchronized ModuleExp getModuleExp() {
    ModuleExp m = exp;
    if (m == null) {
      ClassType ctype = ClassType.make(className);
      m = new ModuleExp();
      compiledType = ctype;
      m.setName(ctype.getName());
      flags |= 0x100000;
      info = this;
      exp = m;
    }
    return m;
  }
  
  public synchronized ModuleExp setupModuleExp()
  {
    ModuleExp mod = getModuleExp();
    if ((flags & 0x100000) == 0) {
      if (moduleClass != null) {
        for (Declaration decl = mod.firstDecl(); 
            decl != null; decl = decl.nextDecl()) {
          gnu.bytecode.Field fld = field;
          if ((fld != null) && (!decl.isIndirectBinding()) && ((fld.getFlags() & 0x8) != 0) && ((fld.getFlags() & 0x10) != 0) && (!(decl.getValueRaw() instanceof QuoteExp)))
          {

            try
            {


              Object fvalue = moduleClass.getField(fld.getName()).get(null);
              
              decl.setValue(new QuoteExp(fvalue));
            }
            catch (Exception ex) {}
          }
        }
      }
      return mod;
    }
    mod.setFlag(false, 1048576);
    ClassType type;
    ClassType type;
    Class rclass; if (moduleClass != null) {
      Class rclass = moduleClass;
      type = (ClassType)Type.make(rclass);
    } else {
      type = ClassType.make(className);
      rclass = type.getReflectClass();
    }
    Object instance = null;
    
    Language language = Language.getDefaultLanguage();
    for (gnu.bytecode.Field fld = type.getFields(); 
        fld != null; fld = fld.getNext()) {
      int flags = fld.getFlags();
      if ((flags & 0x1) != 0) {
        try
        {
          Type ftype = fld.getType();
          
          if (((flags & 0x10) != 0) && ((!ftype.isSubtype(Compilation.typeLocation)) || (ftype.isSubtype(Compilation.typeFieldLocation))))
          {

            if (((flags & 0x8) == 0) && (instance == null))
              instance = getInstance();
            Object fvalue = rclass.getField(fld.getName()).get(instance);
            Declaration fdecl = language.declFromField(mod, fvalue, fld);
            fdecl.noteValue(new QuoteExp(fvalue));
          }
          else {
            Object fvalue = (flags & 0x8) == 0 ? null : rclass.getField(fld.getName()).get(null);
            
            Declaration fdecl = language.declFromField(mod, fvalue, fld);
            fdecl.noteValueUnknown();
          }
        } catch (Exception ex) {
          throw new WrappedException(ex);
        }
      }
    }
    for (Declaration fdecl = mod.firstDecl(); 
        fdecl != null; fdecl = fdecl.nextDecl()) {
      mod.makeDeclInModule2(fdecl);
    }
    return mod;
  }
  
  public synchronized Class getModuleClass() throws ClassNotFoundException {
    Class mclass = moduleClass;
    if (mclass != null)
      return mclass;
    mclass = ClassType.getContextClass(className);
    moduleClass = mclass;
    return mclass;
  }
  
  public Class getModuleClassRaw() {
    return moduleClass;
  }
  
  public Class getOldModuleClass() {
    return oldClass;
  }
  
  public void setModuleClass(Class clas) {
    moduleClass = clas;
    className = clas.getName();
    mapClassToInfo.put(clas, this);
  }
  
  public static ModuleInfo findFromInstance(Object instance) {
    return ModuleContext.getContext().findFromInstance(instance);
  }
  
  public static ModuleInfo find(ClassType type) {
    if (type.isExisting()) {
      try {
        return ModuleManager.findWithClass(type.getReflectClass());
      }
      catch (Exception ex) {}
    }
    return findWithClassName(type.getName());
  }
  
  public static ModuleInfo findWithClassName(String className) {
    return ModuleManager.getInstance().findWithClassName(className);
  }
  
  public static void register(Object instance) {
    ModuleContext.getContext().setInstance(instance);
  }
  
  public Object getInstance() {
    return ModuleContext.getContext().findInstance(this);
  }
  
  public Object getRunInstance() {
    Object inst = getInstance();
    if ((inst instanceof Runnable))
      ((Runnable)inst).run();
    return inst;
  }
  
  public int getState() { return comp == null ? 16 : comp.getState(); }
  
  public void loadByStages(int wantedState) {
    int state = getState();
    if (state + 1 >= wantedState)
      return;
    loadByStages(wantedState - 2);
    state = getState();
    if (state >= wantedState)
      return;
    comp.setState(state + 1);
    int ndeps = numDependencies;
    int depWanted = (Compilation.writeImplicitClasses) && (wantedState >= 16) ? 14 : wantedState;
    


    for (int idep = 0; idep < ndeps; idep++) {
      ModuleInfo dep = dependencies[idep];
      dep.loadByStages(depWanted);
    }
    state = getState();
    if (state >= wantedState)
      return;
    comp.setState(state & 0xFFFFFFFE);
    comp.process(wantedState);
  }
  



  public boolean loadEager(int wantedState)
  {
    if ((comp == null) && (className != null))
      return false;
    int state = getState();
    if (state >= wantedState)
      return true;
    if ((state & 0x1) != 0)
      return false;
    comp.setState(state + 1);
    int ndeps = numDependencies;
    for (int idep = 0; idep < ndeps; idep++) {
      ModuleInfo dep = dependencies[idep];
      if (!dep.loadEager(wantedState)) {
        if (getState() == state + 1)
          comp.setState(state);
        return false;
      }
    }
    if (getState() == state + 1)
      comp.setState(state);
    comp.process(wantedState);
    return getState() == wantedState;
  }
  
  public void clearClass() {
    moduleClass = null;
    numDependencies = 0;
    dependencies = null;
  }
  




  public boolean checkCurrent(ModuleManager manager, long now)
  {
    if (sourceAbsPath == null)
      return true;
    if ((lastCheckedTime + lastModifiedCacheTime >= now) && (moduleClass != null))
    {
      return true; }
    long lastModifiedTime = sourceAbsPath.getLastModified();
    long oldModifiedTime = this.lastModifiedTime;
    this.lastModifiedTime = lastModifiedTime;
    lastCheckedTime = now;
    if (className == null)
      return false;
    if (moduleClass == null) {
      try {
        moduleClass = ClassType.getContextClass(className);
      } catch (ClassNotFoundException ex) {
        return false;
      }
    }
    if ((oldModifiedTime == 0L) && (moduleClass != null)) {
      String classFilename = className;
      int dot = classFilename.lastIndexOf('.');
      if (dot >= 0)
        classFilename = classFilename.substring(dot + 1);
      classFilename = classFilename + ".class";
      URL resource = moduleClass.getResource(classFilename);
      if (resource != null) {
        try {
          oldModifiedTime = resource.openConnection().getLastModified();
        } catch (IOException ex) {
          resource = null;
        }
      }
      if (resource == null)
      {

        return true;
      }
    }
    if (lastModifiedTime > oldModifiedTime) {
      oldClass = moduleClass;
      moduleClass = null;
      return false;
    }
    int i = numDependencies; for (;;) { i--; if (i < 0) break;
      ModuleInfo dep = dependencies[i];
      if ((comp == null) && (!dep.checkCurrent(manager, now))) {
        moduleClass = null;
        return false;
      }
    }
    return true;
  }
  
  public String toString()
  {
    StringBuffer sbuf = new StringBuffer();
    sbuf.append("ModuleInfo[");
    if (moduleClass != null) {
      sbuf.append("class: ");
      sbuf.append(moduleClass);
    } else if (className != null) {
      sbuf.append("class-name: ");
      sbuf.append(className);
    }
    sbuf.append(']');
    return sbuf.toString();
  }
  
  static class ClassToInfoMap extends AbstractWeakHashTable<Class, ModuleInfo> {
    ClassToInfoMap() {}
    
    protected Class getKeyFromValue(ModuleInfo minfo) {
      return moduleClass;
    }
    
    protected boolean matches(Class oldValue, Class newValue) {
      return oldValue == newValue;
    }
  }
}
