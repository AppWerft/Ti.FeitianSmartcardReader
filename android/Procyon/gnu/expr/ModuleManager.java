// 
// Decompiled by Procyon v0.5.36
// 

package gnu.expr;

import gnu.kawa.util.AbstractHashTable;
import gnu.kawa.io.URLPath;
import java.net.URL;
import gnu.mapping.WrappedException;
import gnu.bytecode.ObjectType;
import gnu.kawa.io.Path;
import gnu.bytecode.ClassType;
import java.io.File;

public class ModuleManager
{
    private String compilationDirectory;
    static ModuleManager instance;
    int interactiveCounter;
    int evalCounter;
    public static final String interactiveClassPrefix = "atInteractiveLevel-";
    public String evalClassPrefix;
    public static final long LAST_MODIFIED_CACHE_TIME = 1000L;
    public long lastModifiedCacheTime;
    ModuleInfo[] modules;
    int numModules;
    ModuleSet packageInfoChain;
    
    public ModuleManager() {
        this.compilationDirectory = "";
        this.evalClassPrefix = "atEvalLevel-";
        this.lastModifiedCacheTime = 1000L;
    }
    
    public void setCompilationDirectory(String path) {
        if (path == null) {
            path = "";
        }
        final int plen = path.length();
        if (plen > 0) {
            final char sep = File.separatorChar;
            if (path.charAt(plen - 1) != sep) {
                path += sep;
            }
        }
        this.compilationDirectory = path;
    }
    
    public String getCompilationDirectory() {
        return this.compilationDirectory;
    }
    
    public static ModuleManager getInstance() {
        return ModuleManager.instance;
    }
    
    public synchronized String getNewInteractiveName() {
        return "atInteractiveLevel-" + ++this.interactiveCounter;
    }
    
    public synchronized String getNewEvalName() {
        return this.evalClassPrefix + ++this.evalCounter;
    }
    
    public synchronized ModuleInfo getModule(final int index) {
        return (index >= this.numModules) ? null : this.modules[index];
    }
    
    public synchronized ModuleInfo find(final Compilation comp) {
        final ModuleExp mexp = comp.getModule();
        final ClassType ctype = mexp.classFor(comp);
        final String fileName = mexp.getFileName();
        final Path sourceAbsPath = ModuleInfo.absPath(fileName);
        final ModuleInfo info = this.findWithSourcePath(sourceAbsPath, fileName);
        info.setClassName(ctype.getName());
        info.setCompilation(comp);
        return info;
    }
    
    private synchronized void add(final ModuleInfo info) {
        if (this.modules == null) {
            this.modules = new ModuleInfo[10];
        }
        else if (this.numModules == this.modules.length) {
            final ModuleInfo[] tmp = new ModuleInfo[2 * this.numModules];
            System.arraycopy(this.modules, 0, tmp, 0, this.numModules);
            this.modules = tmp;
        }
        this.modules[this.numModules++] = info;
    }
    
    public ModuleInfo createWithClassName(final String className) {
        final ModuleInfo info = new ModuleInfo();
        info.setClassName(className);
        this.add(info);
        return info;
    }
    
    public synchronized ModuleInfo searchWithClassName(final String className) {
        int i = this.numModules;
        while (--i >= 0) {
            final ModuleInfo info = this.modules[i];
            if (className.equals(info.getClassName())) {
                return info;
            }
        }
        return null;
    }
    
    public static synchronized ModuleInfo findWithClass(final Class clas) {
        ModuleInfo info = ((AbstractHashTable<Entry, K, ModuleInfo>)ModuleInfo.mapClassToInfo).get(clas);
        if (info == null) {
            info = new ModuleInfo();
            info.setModuleClass(clas);
        }
        return info;
    }
    
    public ModuleInfo findWithClassName(final String className) {
        final ModuleInfo info = this.searchWithClassName(className);
        if (info != null) {
            return info;
        }
        try {
            return findWithClass(ObjectType.getContextClass(className));
        }
        catch (Exception ex) {
            throw WrappedException.wrapIfNeeded(ex);
        }
    }
    
    private synchronized ModuleInfo searchWithAbsSourcePath(final String sourcePath) {
        int i = this.numModules;
        while (--i >= 0) {
            final ModuleInfo info = this.modules[i];
            if (sourcePath.equals(info.getSourceAbsPathname())) {
                return info;
            }
        }
        return null;
    }
    
    public synchronized ModuleInfo findWithSourcePath(final Path sourceAbsPath, final String sourcePath) {
        final String sourceAbsPathname = sourceAbsPath.toString();
        ModuleInfo info = this.searchWithAbsSourcePath(sourceAbsPathname);
        if (info == null) {
            info = new ModuleInfo();
            info.sourcePath = sourcePath;
            info.sourceAbsPath = sourceAbsPath;
            info.sourceAbsPathname = sourceAbsPathname;
            this.add(info);
        }
        return info;
    }
    
    public synchronized ModuleInfo findWithSourcePath(final String sourcePath) {
        return this.findWithSourcePath(ModuleInfo.absPath(sourcePath), sourcePath);
    }
    
    public synchronized ModuleInfo findWithURL(final URL url) {
        final Path sourceAbsPath = URLPath.valueOf(url);
        final String sourcePath = url.toExternalForm();
        return this.findWithSourcePath(sourceAbsPath, sourcePath);
    }
    
    public synchronized void register(final String moduleClass, final String moduleSource, final String moduleUri) {
        if (this.searchWithClassName(moduleClass) != null) {
            return;
        }
        final Path sourcePath = Path.valueOf(moduleSource);
        Path sourceAbsPath = sourcePath.getCanonical();
        final String sourceAbsPathname = sourceAbsPath.toString();
        if (this.searchWithAbsSourcePath(sourceAbsPathname) != null) {
            return;
        }
        final ModuleInfo info = new ModuleInfo();
        if (sourcePath.isAbsolute()) {
            info.sourceAbsPath = sourcePath;
            info.sourceAbsPathname = sourceAbsPathname;
        }
        else {
            try {
                final Class setClass = this.packageInfoChain.getClass();
                final String setClassName = setClass.getName().replace('.', '/') + ".class";
                final URL setClassURL = setClass.getClassLoader().getResource(setClassName);
                sourceAbsPath = URLPath.valueOf(setClassURL).resolve(moduleSource);
                info.sourceAbsPath = sourceAbsPath;
                info.sourceAbsPathname = sourceAbsPath.toString();
            }
            catch (Exception ex) {
                return;
            }
        }
        info.setClassName(moduleClass);
        info.sourcePath = moduleSource;
        info.uri = moduleUri;
        this.add(info);
    }
    
    public synchronized void loadPackageInfo(final String packageName) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        final String moduleSetClassName = packageName + "." + "$ModulesMap$";
        for (ModuleSet set = this.packageInfoChain; set != null; set = set.next) {
            final String setName = set.getClass().getName();
            if (setName.equals(moduleSetClassName)) {}
        }
        final Class setClass = Class.forName(moduleSetClassName);
        final ModuleSet instance = setClass.newInstance();
        instance.next = this.packageInfoChain;
        (this.packageInfoChain = instance).register(this);
    }
    
    public synchronized void clear() {
        ModuleSet next;
        for (ModuleSet set = this.packageInfoChain; set != null; set = next) {
            next = set.next;
            set.next = null;
        }
        this.packageInfoChain = null;
        this.modules = null;
        this.numModules = 0;
    }
    
    static {
        ModuleManager.instance = new ModuleManager();
    }
}
