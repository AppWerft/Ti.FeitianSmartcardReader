/*
 * Decompiled with CFR 0.139.
 */
package gnu.expr;

import gnu.bytecode.ClassType;
import gnu.expr.Compilation;
import gnu.expr.ModuleExp;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleSet;
import gnu.kawa.io.Path;
import gnu.kawa.io.URLPath;
import gnu.mapping.WrappedException;
import java.io.File;
import java.net.URL;

public class ModuleManager {
    private String compilationDirectory = "";
    static ModuleManager instance = new ModuleManager();
    int interactiveCounter;
    int evalCounter;
    public static final String interactiveClassPrefix = "atInteractiveLevel-";
    public String evalClassPrefix = "atEvalLevel-";
    public static final long LAST_MODIFIED_CACHE_TIME = 1000L;
    public long lastModifiedCacheTime = 1000L;
    ModuleInfo[] modules;
    int numModules;
    ModuleSet packageInfoChain;

    public void setCompilationDirectory(String path) {
        int plen;
        if (path == null) {
            path = "";
        }
        if ((plen = path.length()) > 0) {
            char sep = File.separatorChar;
            if (path.charAt(plen - 1) != sep) {
                path = path + sep;
            }
        }
        this.compilationDirectory = path;
    }

    public String getCompilationDirectory() {
        return this.compilationDirectory;
    }

    public static ModuleManager getInstance() {
        return instance;
    }

    public synchronized String getNewInteractiveName() {
        return interactiveClassPrefix + ++this.interactiveCounter;
    }

    public synchronized String getNewEvalName() {
        return this.evalClassPrefix + ++this.evalCounter;
    }

    public synchronized ModuleInfo getModule(int index) {
        return index >= this.numModules ? null : this.modules[index];
    }

    public synchronized ModuleInfo find(Compilation comp) {
        ModuleExp mexp = comp.getModule();
        ClassType ctype = mexp.classFor(comp);
        String fileName = mexp.getFileName();
        Path sourceAbsPath = ModuleInfo.absPath(fileName);
        ModuleInfo info = this.findWithSourcePath(sourceAbsPath, fileName);
        info.setClassName(ctype.getName());
        info.setCompilation(comp);
        return info;
    }

    private synchronized void add(ModuleInfo info) {
        if (this.modules == null) {
            this.modules = new ModuleInfo[10];
        } else if (this.numModules == this.modules.length) {
            ModuleInfo[] tmp = new ModuleInfo[2 * this.numModules];
            System.arraycopy(this.modules, 0, tmp, 0, this.numModules);
            this.modules = tmp;
        }
        this.modules[this.numModules++] = info;
    }

    public ModuleInfo createWithClassName(String className) {
        ModuleInfo info = new ModuleInfo();
        info.setClassName(className);
        this.add(info);
        return info;
    }

    public synchronized ModuleInfo searchWithClassName(String className) {
        int i = this.numModules;
        while (--i >= 0) {
            ModuleInfo info = this.modules[i];
            if (!className.equals(info.getClassName())) continue;
            return info;
        }
        return null;
    }

    public static synchronized ModuleInfo findWithClass(Class clas) {
        ModuleInfo info = (ModuleInfo)ModuleInfo.mapClassToInfo.get(clas);
        if (info == null) {
            info = new ModuleInfo();
            info.setModuleClass(clas);
        }
        return info;
    }

    public ModuleInfo findWithClassName(String className) {
        ModuleInfo info = this.searchWithClassName(className);
        if (info != null) {
            return info;
        }
        try {
            return ModuleManager.findWithClass(ClassType.getContextClass(className));
        }
        catch (Exception ex) {
            throw WrappedException.wrapIfNeeded(ex);
        }
    }

    private synchronized ModuleInfo searchWithAbsSourcePath(String sourcePath) {
        int i = this.numModules;
        while (--i >= 0) {
            ModuleInfo info = this.modules[i];
            if (!sourcePath.equals(info.getSourceAbsPathname())) continue;
            return info;
        }
        return null;
    }

    public synchronized ModuleInfo findWithSourcePath(Path sourceAbsPath, String sourcePath) {
        String sourceAbsPathname = sourceAbsPath.toString();
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

    public synchronized ModuleInfo findWithSourcePath(String sourcePath) {
        return this.findWithSourcePath(ModuleInfo.absPath(sourcePath), sourcePath);
    }

    public synchronized ModuleInfo findWithURL(URL url) {
        URLPath sourceAbsPath = URLPath.valueOf(url);
        String sourcePath = url.toExternalForm();
        return this.findWithSourcePath(sourceAbsPath, sourcePath);
    }

    public synchronized void register(String moduleClass, String moduleSource, String moduleUri) {
        if (this.searchWithClassName(moduleClass) != null) {
            return;
        }
        Path sourcePath = Path.valueOf(moduleSource);
        Path sourceAbsPath = sourcePath.getCanonical();
        String sourceAbsPathname = sourceAbsPath.toString();
        if (this.searchWithAbsSourcePath(sourceAbsPathname) != null) {
            return;
        }
        ModuleInfo info = new ModuleInfo();
        if (sourcePath.isAbsolute()) {
            info.sourceAbsPath = sourcePath;
            info.sourceAbsPathname = sourceAbsPathname;
        } else {
            try {
                Class<?> setClass = this.packageInfoChain.getClass();
                String setClassName = setClass.getName().replace('.', '/') + ".class";
                URL setClassURL = setClass.getClassLoader().getResource(setClassName);
                info.sourceAbsPath = sourceAbsPath = URLPath.valueOf(setClassURL).resolve(moduleSource);
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

    public synchronized void loadPackageInfo(String packageName) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        String moduleSetClassName = packageName + "." + "$ModulesMap$";
        ModuleSet set = this.packageInfoChain;
        while (set != null) {
            String setName = set.getClass().getName();
            if (setName.equals(moduleSetClassName)) {
                // empty if block
            }
            set = set.next;
        }
        Class<?> setClass = Class.forName(moduleSetClassName);
        ModuleSet instance = (ModuleSet)setClass.newInstance();
        instance.next = this.packageInfoChain;
        this.packageInfoChain = instance;
        instance.register(this);
    }

    public synchronized void clear() {
        ModuleSet set = this.packageInfoChain;
        while (set != null) {
            ModuleSet next = set.next;
            set.next = null;
            set = next;
        }
        this.packageInfoChain = null;
        this.modules = null;
        this.numModules = 0;
    }
}

