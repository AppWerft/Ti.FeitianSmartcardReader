// 
// Decompiled by Procyon v0.5.36
// 

package gnu.expr;

import gnu.kawa.util.AbstractWeakHashTable;
import java.net.URL;
import java.io.IOException;
import gnu.bytecode.ObjectType;
import gnu.bytecode.Field;
import gnu.mapping.WrappedException;
import gnu.bytecode.Type;
import gnu.bytecode.ClassType;
import gnu.kawa.io.InPort;
import gnu.kawa.io.TtyInPort;
import gnu.kawa.io.CharArrayInPort;
import gnu.kawa.io.Path;

public class ModuleInfo
{
    protected String className;
    Class moduleClass;
    private Class oldClass;
    static ClassToInfoMap mapClassToInfo;
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
    
    public void setNamespaceUri(final String uri) {
        this.uri = uri;
    }
    
    public Compilation getCompilation() {
        return this.comp;
    }
    
    public void setCompilation(final Compilation comp) {
        this.comp = comp;
        if (comp == null) {
            return;
        }
        final ModuleExp mod = comp.mainLambda;
        mod.info = this;
        this.exp = mod;
        final String fileName;
        if (mod != null && (fileName = mod.getFileName()) != null) {
            this.sourcePath = fileName;
            final InPort port = (comp.lexer == null) ? null : comp.lexer.getPort();
            if (!(port instanceof CharArrayInPort) && !(port instanceof TtyInPort)) {
                this.sourceAbsPath = absPath(fileName);
            }
        }
    }
    
    public void cleanupAfterCompilation() {
        if (this.comp != null) {
            this.comp.cleanupAfterCompilation();
        }
    }
    
    public static Path absPath(final String path) {
        return Path.valueOf(path).getCanonical();
    }
    
    public Path getSourceAbsPath() {
        return this.sourceAbsPath;
    }
    
    public void setSourceAbsPath(final Path path) {
        this.sourceAbsPath = path;
        this.sourceAbsPathname = null;
    }
    
    public String getSourceAbsPathname() {
        String str = this.sourceAbsPathname;
        if (str == null && this.sourceAbsPath != null) {
            str = this.sourceAbsPath.toString();
            this.sourceAbsPathname = str;
        }
        return str;
    }
    
    public synchronized void addDependency(final ModuleInfo dep) {
        if (this.dependencies == null) {
            this.dependencies = new ModuleInfo[8];
        }
        else if (this.numDependencies == this.dependencies.length) {
            final ModuleInfo[] deps = new ModuleInfo[2 * this.numDependencies];
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
            }
            else if (this.comp != null && this.comp.mainClass != null) {
                this.className = this.comp.mainClass.getName();
            }
        }
        return this.className;
    }
    
    public void setClassName(final String name) {
        this.className = name;
    }
    
    public ModuleExp getModuleExpRaw() {
        return this.exp;
    }
    
    public synchronized ModuleExp getModuleExp() {
        ModuleExp m = this.exp;
        if (m == null) {
            final ClassType ctype = ClassType.make(this.className);
            m = new ModuleExp();
            m.compiledType = ctype;
            m.setName(ctype.getName());
            final ModuleExp moduleExp = m;
            moduleExp.flags |= 0x100000;
            m.info = this;
            this.exp = m;
        }
        return m;
    }
    
    public synchronized ModuleExp setupModuleExp() {
        final ModuleExp mod = this.getModuleExp();
        if ((mod.flags & 0x100000) == 0x0) {
            if (this.moduleClass != null) {
                for (Declaration decl = mod.firstDecl(); decl != null; decl = decl.nextDecl()) {
                    final Field fld = decl.field;
                    if (fld != null && !decl.isIndirectBinding() && (fld.getFlags() & 0x8) != 0x0 && (fld.getFlags() & 0x10) != 0x0) {
                        if (!(decl.getValueRaw() instanceof QuoteExp)) {
                            try {
                                final Object fvalue = this.moduleClass.getField(fld.getName()).get(null);
                                decl.setValue(new QuoteExp(fvalue));
                            }
                            catch (Exception ex2) {}
                        }
                    }
                }
            }
            return mod;
        }
        mod.setFlag(false, 1048576);
        Class rclass;
        ClassType type;
        if (this.moduleClass != null) {
            rclass = this.moduleClass;
            type = (ClassType)Type.make(rclass);
        }
        else {
            type = ClassType.make(this.className);
            rclass = type.getReflectClass();
        }
        Object instance = null;
        final Language language = Language.getDefaultLanguage();
        for (Field fld2 = type.getFields(); fld2 != null; fld2 = fld2.getNext()) {
            final int flags = fld2.getFlags();
            if ((flags & 0x1) != 0x0) {
                try {
                    final Type ftype = fld2.getType();
                    if ((flags & 0x10) != 0x0 && (!ftype.isSubtype(Compilation.typeLocation) || ftype.isSubtype(Compilation.typeFieldLocation))) {
                        if ((flags & 0x8) == 0x0 && instance == null) {
                            instance = this.getInstance();
                        }
                        final Object fvalue2 = rclass.getField(fld2.getName()).get(instance);
                        final Declaration fdecl = language.declFromField(mod, fvalue2, fld2);
                        fdecl.noteValue(new QuoteExp(fvalue2));
                    }
                    else {
                        final Object fvalue2 = ((flags & 0x8) == 0x0) ? null : rclass.getField(fld2.getName()).get(null);
                        final Declaration fdecl = language.declFromField(mod, fvalue2, fld2);
                        fdecl.noteValueUnknown();
                    }
                }
                catch (Exception ex) {
                    throw new WrappedException(ex);
                }
            }
        }
        for (Declaration fdecl2 = mod.firstDecl(); fdecl2 != null; fdecl2 = fdecl2.nextDecl()) {
            mod.makeDeclInModule2(fdecl2);
        }
        return mod;
    }
    
    public synchronized Class getModuleClass() throws ClassNotFoundException {
        Class mclass = this.moduleClass;
        if (mclass != null) {
            return mclass;
        }
        mclass = ObjectType.getContextClass(this.className);
        return this.moduleClass = mclass;
    }
    
    public Class getModuleClassRaw() {
        return this.moduleClass;
    }
    
    public Class getOldModuleClass() {
        return this.oldClass;
    }
    
    public void setModuleClass(final Class clas) {
        this.moduleClass = clas;
        this.className = clas.getName();
        ModuleInfo.mapClassToInfo.put(clas, this);
    }
    
    public static ModuleInfo findFromInstance(final Object instance) {
        return ModuleContext.getContext().findFromInstance(instance);
    }
    
    public static ModuleInfo find(final ClassType type) {
        if (type.isExisting()) {
            try {
                return ModuleManager.findWithClass(type.getReflectClass());
            }
            catch (Exception ex) {}
        }
        return findWithClassName(type.getName());
    }
    
    public static ModuleInfo findWithClassName(final String className) {
        return ModuleManager.getInstance().findWithClassName(className);
    }
    
    public static void register(final Object instance) {
        ModuleContext.getContext().setInstance(instance);
    }
    
    public Object getInstance() {
        return ModuleContext.getContext().findInstance(this);
    }
    
    public Object getRunInstance() {
        final Object inst = this.getInstance();
        if (inst instanceof Runnable) {
            ((Runnable)inst).run();
        }
        return inst;
    }
    
    public int getState() {
        return (this.comp == null) ? 16 : this.comp.getState();
    }
    
    public void loadByStages(final int wantedState) {
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
        final int ndeps = this.numDependencies;
        final int depWanted = (Compilation.writeImplicitClasses && wantedState >= 16) ? 14 : wantedState;
        for (int idep = 0; idep < ndeps; ++idep) {
            final ModuleInfo dep = this.dependencies[idep];
            dep.loadByStages(depWanted);
        }
        state = this.getState();
        if (state >= wantedState) {
            return;
        }
        this.comp.setState(state & 0xFFFFFFFE);
        this.comp.process(wantedState);
    }
    
    public boolean loadEager(final int wantedState) {
        if (this.comp == null && this.className != null) {
            return false;
        }
        final int state = this.getState();
        if (state >= wantedState) {
            return true;
        }
        if ((state & 0x1) != 0x0) {
            return false;
        }
        this.comp.setState(state + 1);
        for (int ndeps = this.numDependencies, idep = 0; idep < ndeps; ++idep) {
            final ModuleInfo dep = this.dependencies[idep];
            if (!dep.loadEager(wantedState)) {
                if (this.getState() == state + 1) {
                    this.comp.setState(state);
                }
                return false;
            }
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
    
    public boolean checkCurrent(final ModuleManager manager, final long now) {
        if (this.sourceAbsPath == null) {
            return true;
        }
        if (this.lastCheckedTime + manager.lastModifiedCacheTime >= now && this.moduleClass != null) {
            return true;
        }
        final long lastModifiedTime = this.sourceAbsPath.getLastModified();
        long oldModifiedTime = this.lastModifiedTime;
        this.lastModifiedTime = lastModifiedTime;
        this.lastCheckedTime = now;
        if (this.className == null) {
            return false;
        }
        if (this.moduleClass == null) {
            try {
                this.moduleClass = ObjectType.getContextClass(this.className);
            }
            catch (ClassNotFoundException ex) {
                return false;
            }
        }
        if (oldModifiedTime == 0L && this.moduleClass != null) {
            String classFilename = this.className;
            final int dot = classFilename.lastIndexOf(46);
            if (dot >= 0) {
                classFilename = classFilename.substring(dot + 1);
            }
            classFilename += ".class";
            URL resource = this.moduleClass.getResource(classFilename);
            if (resource != null) {
                try {
                    oldModifiedTime = resource.openConnection().getLastModified();
                }
                catch (IOException ex2) {
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
            final ModuleInfo dep = this.dependencies[i];
            if (dep.comp == null && !dep.checkCurrent(manager, now)) {
                this.moduleClass = null;
                return false;
            }
        }
        return true;
    }
    
    @Override
    public String toString() {
        final StringBuffer sbuf = new StringBuffer();
        sbuf.append("ModuleInfo[");
        if (this.moduleClass != null) {
            sbuf.append("class: ");
            sbuf.append(this.moduleClass);
        }
        else if (this.className != null) {
            sbuf.append("class-name: ");
            sbuf.append(this.className);
        }
        sbuf.append(']');
        return sbuf.toString();
    }
    
    static {
        ModuleInfo.mapClassToInfo = new ClassToInfoMap();
    }
    
    static class ClassToInfoMap extends AbstractWeakHashTable<Class, ModuleInfo>
    {
        @Override
        protected Class getKeyFromValue(final ModuleInfo minfo) {
            return minfo.moduleClass;
        }
        
        protected boolean matches(final Class oldValue, final Class newValue) {
            return oldValue == newValue;
        }
    }
}
