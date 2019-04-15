/*
 * Decompiled with CFR 0.139.
 */
package gnu.expr;

import gnu.bytecode.ClassType;
import gnu.bytecode.Type;
import gnu.expr.Compilation;
import gnu.expr.Declaration;
import gnu.expr.Expression;
import gnu.expr.Language;
import gnu.expr.ModuleContext;
import gnu.expr.ModuleExp;
import gnu.expr.ModuleManager;
import gnu.expr.QuoteExp;
import gnu.kawa.io.CharArrayInPort;
import gnu.kawa.io.InPort;
import gnu.kawa.io.Path;
import gnu.kawa.io.TtyInPort;
import gnu.kawa.util.AbstractWeakHashTable;
import gnu.mapping.WrappedException;
import gnu.text.Lexer;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.URL;
import java.net.URLConnection;

public class ModuleInfo {
    protected String className;
    Class moduleClass;
    private Class oldClass;
    static ClassToInfoMap mapClassToInfo = new ClassToInfoMap();
    String uri;
    ModuleExp exp;
    private Compilation comp;
    ModuleInfo[] dependencies;
    int numDependencies;
    public String sourcePath;
    Path sourceAbsPath;
    String sourceAbsPathname;
    public long lastCheckedTime;
    public long lastModifiedTime;

    public String getNamespaceUri() {
        return this.uri;
    }

    public void setNamespaceUri(String uri) {
        this.uri = uri;
    }

    public Compilation getCompilation() {
        return this.comp;
    }

    public void setCompilation(Compilation comp) {
        String fileName;
        this.comp = comp;
        if (comp == null) {
            return;
        }
        ModuleExp mod = comp.mainLambda;
        mod.info = this;
        this.exp = mod;
        if (mod != null && (fileName = mod.getFileName()) != null) {
            InPort port;
            this.sourcePath = fileName;
            InPort inPort = port = comp.lexer == null ? null : comp.lexer.getPort();
            if (!(port instanceof CharArrayInPort) && !(port instanceof TtyInPort)) {
                this.sourceAbsPath = ModuleInfo.absPath(fileName);
            }
        }
    }

    public void cleanupAfterCompilation() {
        if (this.comp != null) {
            this.comp.cleanupAfterCompilation();
        }
    }

    public static Path absPath(String path) {
        return Path.valueOf(path).getCanonical();
    }

    public Path getSourceAbsPath() {
        return this.sourceAbsPath;
    }

    public void setSourceAbsPath(Path path) {
        this.sourceAbsPath = path;
        this.sourceAbsPathname = null;
    }

    public String getSourceAbsPathname() {
        String str = this.sourceAbsPathname;
        if (str == null && this.sourceAbsPath != null) {
            this.sourceAbsPathname = str = this.sourceAbsPath.toString();
        }
        return str;
    }

    public synchronized void addDependency(ModuleInfo dep) {
        if (this.dependencies == null) {
            this.dependencies = new ModuleInfo[8];
        } else if (this.numDependencies == this.dependencies.length) {
            ModuleInfo[] deps = new ModuleInfo[2 * this.numDependencies];
            System.arraycopy(this.dependencies, 0, deps, 0, this.numDependencies);
            this.dependencies = deps;
        }
        this.dependencies[this.numDependencies++] = dep;
    }

    public synchronized ClassType getClassType() {
        if (this.moduleClass != null) {
            return (ClassType)Type.make(this.moduleClass);
        }
        if (this.comp != null && this.comp.mainClass != null) {
            return this.comp.mainClass;
        }
        return ClassType.make(this.className);
    }

    public synchronized String getClassName() {
        if (this.className == null) {
            if (this.moduleClass != null) {
                this.className = this.moduleClass.getName();
            } else if (this.comp != null && this.comp.mainClass != null) {
                this.className = this.comp.mainClass.getName();
            }
        }
        return this.className;
    }

    public void setClassName(String name) {
        this.className = name;
    }

    public ModuleExp getModuleExpRaw() {
        return this.exp;
    }

    public synchronized ModuleExp getModuleExp() {
        ModuleExp m = this.exp;
        if (m == null) {
            ClassType ctype = ClassType.make(this.className);
            m = new ModuleExp();
            m.compiledType = ctype;
            m.setName(ctype.getName());
            m.flags |= 1048576;
            m.info = this;
            this.exp = m;
        }
        return m;
    }

    public synchronized ModuleExp setupModuleExp() {
        ClassType type;
        Class rclass;
        ModuleExp mod = this.getModuleExp();
        if ((mod.flags & 1048576) == 0) {
            if (this.moduleClass != null) {
                for (Declaration decl = mod.firstDecl(); decl != null; decl = decl.nextDecl()) {
                    gnu.bytecode.Field fld = decl.field;
                    if (fld == null || decl.isIndirectBinding() || (fld.getFlags() & 8) == 0 || (fld.getFlags() & 16) == 0 || decl.getValueRaw() instanceof QuoteExp) continue;
                    try {
                        Object fvalue = this.moduleClass.getField(fld.getName()).get(null);
                        decl.setValue(new QuoteExp(fvalue));
                        continue;
                    }
                    catch (Exception ex) {
                        // empty catch block
                    }
                }
            }
            return mod;
        }
        mod.setFlag(false, 1048576);
        if (this.moduleClass != null) {
            rclass = this.moduleClass;
            type = (ClassType)Type.make(rclass);
        } else {
            type = ClassType.make(this.className);
            rclass = type.getReflectClass();
        }
        Object instance = null;
        Language language = Language.getDefaultLanguage();
        for (gnu.bytecode.Field fld = type.getFields(); fld != null; fld = fld.getNext()) {
            int flags = fld.getFlags();
            if ((flags & 1) == 0) continue;
            try {
                Declaration fdecl;
                Object fvalue;
                Type ftype = fld.getType();
                if ((flags & 16) != 0 && (!ftype.isSubtype(Compilation.typeLocation) || ftype.isSubtype(Compilation.typeFieldLocation))) {
                    if ((flags & 8) == 0 && instance == null) {
                        instance = this.getInstance();
                    }
                    fvalue = rclass.getField(fld.getName()).get(instance);
                    fdecl = language.declFromField(mod, fvalue, fld);
                    fdecl.noteValue(new QuoteExp(fvalue));
                    continue;
                }
                fvalue = (flags & 8) == 0 ? null : rclass.getField(fld.getName()).get(null);
                fdecl = language.declFromField(mod, fvalue, fld);
                fdecl.noteValueUnknown();
                continue;
            }
            catch (Exception ex) {
                throw new WrappedException(ex);
            }
        }
        for (Declaration fdecl = mod.firstDecl(); fdecl != null; fdecl = fdecl.nextDecl()) {
            mod.makeDeclInModule2(fdecl);
        }
        return mod;
    }

    public synchronized Class getModuleClass() throws ClassNotFoundException {
        Class mclass = this.moduleClass;
        if (mclass != null) {
            return mclass;
        }
        this.moduleClass = mclass = ClassType.getContextClass(this.className);
        return mclass;
    }

    public Class getModuleClassRaw() {
        return this.moduleClass;
    }

    public Class getOldModuleClass() {
        return this.oldClass;
    }

    public void setModuleClass(Class clas) {
        this.moduleClass = clas;
        this.className = clas.getName();
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
            catch (Exception ex) {
                // empty catch block
            }
        }
        return ModuleInfo.findWithClassName(type.getName());
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
        Object inst = this.getInstance();
        if (inst instanceof Runnable) {
            ((Runnable)inst).run();
        }
        return inst;
    }

    public int getState() {
        return this.comp == null ? 16 : this.comp.getState();
    }

    public void loadByStages(int wantedState) {
        int state = this.getState();
        if (state + 1 >= wantedState) {
            return;
        }
        this.loadByStages(wantedState - 2);
        state = this.getState();
        if (state >= wantedState) {
            return;
        }
        this.comp.setState(state + 1);
        int ndeps = this.numDependencies;
        int depWanted = Compilation.writeImplicitClasses && wantedState >= 16 ? 14 : wantedState;
        for (int idep = 0; idep < ndeps; ++idep) {
            ModuleInfo dep = this.dependencies[idep];
            dep.loadByStages(depWanted);
        }
        state = this.getState();
        if (state >= wantedState) {
            return;
        }
        this.comp.setState(state & -2);
        this.comp.process(wantedState);
    }

    public boolean loadEager(int wantedState) {
        if (this.comp == null && this.className != null) {
            return false;
        }
        int state = this.getState();
        if (state >= wantedState) {
            return true;
        }
        if ((state & 1) != 0) {
            return false;
        }
        this.comp.setState(state + 1);
        int ndeps = this.numDependencies;
        for (int idep = 0; idep < ndeps; ++idep) {
            ModuleInfo dep = this.dependencies[idep];
            if (dep.loadEager(wantedState)) continue;
            if (this.getState() == state + 1) {
                this.comp.setState(state);
            }
            return false;
        }
        if (this.getState() == state + 1) {
            this.comp.setState(state);
        }
        this.comp.process(wantedState);
        return this.getState() == wantedState;
    }

    public void clearClass() {
        this.moduleClass = null;
        this.numDependencies = 0;
        this.dependencies = null;
    }

    public boolean checkCurrent(ModuleManager manager, long now) {
        if (this.sourceAbsPath == null) {
            return true;
        }
        if (this.lastCheckedTime + manager.lastModifiedCacheTime >= now && this.moduleClass != null) {
            return true;
        }
        long lastModifiedTime = this.sourceAbsPath.getLastModified();
        long oldModifiedTime = this.lastModifiedTime;
        this.lastModifiedTime = lastModifiedTime;
        this.lastCheckedTime = now;
        if (this.className == null) {
            return false;
        }
        if (this.moduleClass == null) {
            try {
                this.moduleClass = ClassType.getContextClass(this.className);
            }
            catch (ClassNotFoundException ex) {
                return false;
            }
        }
        if (oldModifiedTime == 0L && this.moduleClass != null) {
            URL resource;
            String classFilename = this.className;
            int dot = classFilename.lastIndexOf(46);
            if (dot >= 0) {
                classFilename = classFilename.substring(dot + 1);
            }
            if ((resource = this.moduleClass.getResource(classFilename = classFilename + ".class")) != null) {
                try {
                    oldModifiedTime = resource.openConnection().getLastModified();
                }
                catch (IOException ex) {
                    resource = null;
                }
            }
            if (resource == null) {
                return true;
            }
        }
        if (lastModifiedTime > oldModifiedTime) {
            this.oldClass = this.moduleClass;
            this.moduleClass = null;
            return false;
        }
        int i = this.numDependencies;
        while (--i >= 0) {
            ModuleInfo dep = this.dependencies[i];
            if (dep.comp != null || dep.checkCurrent(manager, now)) continue;
            this.moduleClass = null;
            return false;
        }
        return true;
    }

    public String toString() {
        StringBuffer sbuf = new StringBuffer();
        sbuf.append("ModuleInfo[");
        if (this.moduleClass != null) {
            sbuf.append("class: ");
            sbuf.append(this.moduleClass);
        } else if (this.className != null) {
            sbuf.append("class-name: ");
            sbuf.append(this.className);
        }
        sbuf.append(']');
        return sbuf.toString();
    }

    static class ClassToInfoMap
    extends AbstractWeakHashTable<Class, ModuleInfo> {
        ClassToInfoMap() {
        }

        @Override
        protected Class getKeyFromValue(ModuleInfo minfo) {
            return minfo.moduleClass;
        }

        protected boolean matches(Class oldValue, Class newValue) {
            return oldValue == newValue;
        }
    }

}

