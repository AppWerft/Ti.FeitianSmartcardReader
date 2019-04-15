package gnu.expr;

import gnu.bytecode.ClassType;
import gnu.kawa.io.Path;
import gnu.kawa.io.URLPath;
import gnu.mapping.WrappedException;
import java.io.File;
import java.net.URL;


public class ModuleManager
{
  public ModuleManager() {}
  
  private String compilationDirectory = "";
  
  public void setCompilationDirectory(String path) {
    if (path == null)
      path = "";
    int plen = path.length();
    if (plen > 0)
    {
      char sep = File.separatorChar;
      if (path.charAt(plen - 1) != sep)
        path = path + sep;
    }
    compilationDirectory = path; }
  
  public String getCompilationDirectory() { return compilationDirectory; }
  
  static ModuleManager instance = new ModuleManager();
  int interactiveCounter;
  
  public static ModuleManager getInstance() {
    return instance;
  }
  

  int evalCounter;
  
  public static final String interactiveClassPrefix = "atInteractiveLevel-";
  public String evalClassPrefix = "atEvalLevel-";
  

  public static final long LAST_MODIFIED_CACHE_TIME = 1000L;
  

  public synchronized String getNewInteractiveName()
  {
    return "atInteractiveLevel-" + ++interactiveCounter;
  }
  



  public synchronized String getNewEvalName()
  {
    return evalClassPrefix + ++evalCounter;
  }
  


  public long lastModifiedCacheTime = 1000L;
  
  ModuleInfo[] modules;
  int numModules;
  ModuleSet packageInfoChain;
  
  public synchronized ModuleInfo getModule(int index)
  {
    return index >= numModules ? null : modules[index];
  }
  
  public synchronized ModuleInfo find(Compilation comp)
  {
    ModuleExp mexp = comp.getModule();
    ClassType ctype = mexp.classFor(comp);
    String fileName = mexp.getFileName();
    Path sourceAbsPath = ModuleInfo.absPath(fileName);
    ModuleInfo info = findWithSourcePath(sourceAbsPath, fileName);
    info.setClassName(ctype.getName());
    info.setCompilation(comp);
    return info;
  }
  
  private synchronized void add(ModuleInfo info)
  {
    if (modules == null) {
      modules = new ModuleInfo[10];
    } else if (numModules == modules.length)
    {
      ModuleInfo[] tmp = new ModuleInfo[2 * numModules];
      System.arraycopy(modules, 0, tmp, 0, numModules);
      modules = tmp;
    }
    modules[(numModules++)] = info;
  }
  
  public ModuleInfo createWithClassName(String className) {
    ModuleInfo info = new ModuleInfo();
    info.setClassName(className);
    add(info);
    return info;
  }
  
  public synchronized ModuleInfo searchWithClassName(String className)
  {
    int i = numModules; for (;;) { i--; if (i < 0)
        break;
      ModuleInfo info = modules[i];
      if (className.equals(info.getClassName()))
        return info;
    }
    return null;
  }
  
  public static synchronized ModuleInfo findWithClass(Class clas)
  {
    ModuleInfo info = (ModuleInfo)ModuleInfo.mapClassToInfo.get(clas);
    if (info == null)
    {
      info = new ModuleInfo();
      info.setModuleClass(clas);
    }
    return info;
  }
  
  public ModuleInfo findWithClassName(String className)
  {
    ModuleInfo info = searchWithClassName(className);
    if (info != null) {
      return info;
    }
    try {
      return findWithClass(ClassType.getContextClass(className));
    }
    catch (Exception ex)
    {
      throw WrappedException.wrapIfNeeded(ex);
    }
  }
  
  private synchronized ModuleInfo searchWithAbsSourcePath(String sourcePath)
  {
    int i = numModules; for (;;) { i--; if (i < 0)
        break;
      ModuleInfo info = modules[i];
      if (sourcePath.equals(info.getSourceAbsPathname()))
        return info;
    }
    return null;
  }
  

  public synchronized ModuleInfo findWithSourcePath(Path sourceAbsPath, String sourcePath)
  {
    String sourceAbsPathname = sourceAbsPath.toString();
    ModuleInfo info = searchWithAbsSourcePath(sourceAbsPathname);
    if (info == null)
    {
      info = new ModuleInfo();
      sourcePath = sourcePath;
      sourceAbsPath = sourceAbsPath;
      sourceAbsPathname = sourceAbsPathname;
      add(info);
    }
    return info;
  }
  
  public synchronized ModuleInfo findWithSourcePath(String sourcePath)
  {
    return findWithSourcePath(ModuleInfo.absPath(sourcePath), sourcePath);
  }
  
  public synchronized ModuleInfo findWithURL(URL url)
  {
    Path sourceAbsPath = URLPath.valueOf(url);
    String sourcePath = url.toExternalForm();
    return findWithSourcePath(sourceAbsPath, sourcePath);
  }
  











  public synchronized void register(String moduleClass, String moduleSource, String moduleUri)
  {
    if (searchWithClassName(moduleClass) != null)
      return;
    Path sourcePath = Path.valueOf(moduleSource);
    Path sourceAbsPath = sourcePath.getCanonical();
    String sourceAbsPathname = sourceAbsPath.toString();
    if (searchWithAbsSourcePath(sourceAbsPathname) != null)
      return;
    ModuleInfo info = new ModuleInfo();
    if (sourcePath.isAbsolute())
    {
      sourceAbsPath = sourcePath;
      sourceAbsPathname = sourceAbsPathname;

    }
    else
    {

      try
      {
        Class setClass = packageInfoChain.getClass();
        String setClassName = setClass.getName().replace('.', '/') + ".class";
        URL setClassURL = setClass.getClassLoader().getResource(setClassName);
        
        sourceAbsPath = URLPath.valueOf(setClassURL).resolve(moduleSource);
        sourceAbsPath = sourceAbsPath;
        sourceAbsPathname = sourceAbsPath.toString();
      }
      catch (Exception ex)
      {
        return;
      }
    }
    info.setClassName(moduleClass);
    sourcePath = moduleSource;
    uri = moduleUri;
    add(info);
  }
  





  public synchronized void loadPackageInfo(String packageName)
    throws ClassNotFoundException, InstantiationException, IllegalAccessException
  {
    String moduleSetClassName = packageName + "." + "$ModulesMap$";
    
    for (ModuleSet set = packageInfoChain; set != null; set = next)
    {
      String setName = set.getClass().getName();
      if (setName.equals(moduleSetClassName)) {}
    }
    
    Class setClass = Class.forName(moduleSetClassName);
    ModuleSet instance = (ModuleSet)setClass.newInstance();
    
    next = packageInfoChain;
    

    packageInfoChain = instance;
    instance.register(this);
  }
  





  public synchronized void clear()
  {
    ModuleSet set = packageInfoChain;
    while (set != null)
    {
      ModuleSet next = next;
      next = null;
      set = next;
    }
    packageInfoChain = null;
    
    modules = null;
    numModules = 0;
  }
}
