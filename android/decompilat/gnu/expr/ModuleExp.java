// 
// Decompiled by Procyon v0.5.36
// 

package gnu.expr;

import java.io.ObjectInput;
import java.io.ObjectOutput;
import gnu.kawa.reflect.FieldLocation;
import gnu.bytecode.Field;
import gnu.kawa.reflect.StaticFieldLocation;
import gnu.mapping.Location;
import gnu.mapping.Symbol;
import gnu.kawa.reflect.ClassMemberLocation;
import gnu.kawa.io.OutPort;
import gnu.mapping.CallContext;
import gnu.mapping.Environment;
import gnu.text.SourceMessages;
import gnu.text.SyntaxException;
import java.io.IOException;
import gnu.mapping.WrappedException;
import gnu.bytecode.ArrayClassLoader;
import java.util.zip.CRC32;
import java.util.zip.ZipEntry;
import java.io.OutputStream;
import java.util.zip.ZipOutputStream;
import java.io.FileOutputStream;
import gnu.kawa.io.Path;
import java.net.URL;
import gnu.bytecode.ClassType;
import java.io.Externalizable;

public class ModuleExp extends LambdaExp implements Externalizable
{
    public static final int EXPORT_SPECIFIED = 32768;
    public static final int STATIC_SPECIFIED = 65536;
    public static final int NONSTATIC_SPECIFIED = 131072;
    public static final int SUPERTYPE_SPECIFIED = 262144;
    public static final int STATIC_RUN_SPECIFIED = 524288;
    public static final int LAZY_DECLARATIONS = 1048576;
    public static final int IMMEDIATE = 2097152;
    public static final int INTERACTIVE = 4194304;
    public static final int USE_DEFINED_CLASS = 8388608;
    public static final int HAS_SUB_MODULE = 16777216;
    public static String dumpZipPrefix;
    static int lastZipCounter;
    @Deprecated
    public static boolean compilerAvailable;
    private static int haveCompiler;
    public static boolean alwaysCompile;
    ModuleInfo info;
    
    public boolean subModulesOnly() {
        return this.getFlag(16777216) && this.body == QuoteExp.voidExp && this.firstDecl() == null;
    }
    
    public static ModuleExp valueOf(final ClassType type) {
        return ModuleInfo.find(type).getModuleExp();
    }
    
    public static Class evalToClass(final Compilation comp, URL url) throws SyntaxException {
        final ModuleExp mexp = comp.getModule();
        final ModuleInfo minfo = mexp.info;
        final SourceMessages messages = comp.getMessages();
        try {
            Class clas = null;
            if (mexp.subModulesOnly()) {
                clas = Object.class;
            }
            else {
                minfo.loadByStages(14);
                if (messages.seenErrors()) {
                    return null;
                }
                final ArrayClassLoader loader = comp.loader;
                if (url == null) {
                    url = Path.currentPath().toURL();
                }
                loader.setResourceContext(url);
                ZipOutputStream zout = null;
                if (ModuleExp.dumpZipPrefix != null) {
                    final StringBuffer zipname = new StringBuffer(ModuleExp.dumpZipPrefix);
                    final ModuleManager manager = ModuleManager.getInstance();
                    ++ModuleExp.lastZipCounter;
                    if (manager.interactiveCounter > ModuleExp.lastZipCounter) {
                        ModuleExp.lastZipCounter = manager.interactiveCounter;
                    }
                    zipname.append(ModuleExp.lastZipCounter);
                    zipname.append(".zip");
                    final FileOutputStream zfout = new FileOutputStream(zipname.toString());
                    zout = new ZipOutputStream(zfout);
                }
                for (int iClass = 0; iClass < comp.numClasses; ++iClass) {
                    final ClassType clasi = comp.classes[iClass];
                    final String className = clasi.getName();
                    final byte[] classBytes = clasi.writeToArray();
                    loader.addClass(className, classBytes);
                    if (zout != null) {
                        final String clname = className.replace('.', '/') + ".class";
                        final ZipEntry zent = new ZipEntry(clname);
                        zent.setSize(classBytes.length);
                        final CRC32 crc = new CRC32();
                        crc.update(classBytes);
                        zent.setCrc(crc.getValue());
                        zent.setMethod(0);
                        zout.putNextEntry(zent);
                        zout.write(classBytes);
                    }
                }
                if (zout != null) {
                    zout.close();
                }
                ArrayClassLoader context;
                for (context = loader; context.getParent() instanceof ArrayClassLoader; context = (ArrayClassLoader)context.getParent()) {}
                for (int iClass2 = 0; iClass2 < comp.numClasses; ++iClass2) {
                    final ClassType ctype = comp.classes[iClass2];
                    final Class cclass = loader.loadClass(ctype.getName());
                    ctype.setReflectClass(cclass);
                    ctype.setExisting(true);
                    if (iClass2 == 0) {
                        clas = cclass;
                    }
                    else if (context != loader) {
                        context.addClass(cclass);
                    }
                }
                minfo.setModuleClass(clas);
                comp.cleanupAfterCompilation();
            }
            for (int ndeps = minfo.numDependencies, idep = 0; idep < ndeps; ++idep) {
                final ModuleInfo dep = minfo.dependencies[idep];
                Class dclass = dep.getModuleClassRaw();
                if (dclass == null) {
                    dclass = evalToClass(dep.getCompilation(), null);
                }
                if (comp.loader != null) {
                    comp.loader.addClass(dclass);
                }
            }
            return clas;
        }
        catch (IOException ex) {
            throw new WrappedException("I/O error in lambda eval", ex);
        }
        catch (ClassNotFoundException ex2) {
            throw new WrappedException("class not found in lambda eval", ex2);
        }
        catch (Exception ex3) {
            messages.error('f', "internal compile error - caught " + ex3, ex3);
            throw new SyntaxException(messages);
        }
    }
    
    public static synchronized boolean compilerAvailable() {
        if (ModuleExp.haveCompiler == 0) {
            if (!ModuleExp.compilerAvailable) {
                ModuleExp.haveCompiler = -1;
            }
            else if ("Dalvik".equals(System.getProperty("java.vm.name"))) {
                ModuleExp.haveCompiler = -1;
            }
            else {
                try {
                    Class.forName("gnu.expr.TryExp");
                    ModuleExp.haveCompiler = 1;
                }
                catch (Exception ex) {
                    ModuleExp.haveCompiler = -1;
                }
            }
        }
        return ModuleExp.haveCompiler >= 0;
    }
    
    public static final boolean evalModule(final Environment env, final CallContext ctx, final Compilation comp, final URL url, final OutPort msg) throws Throwable {
        final ModuleExp mexp = comp.getModule();
        final Language language = comp.getLanguage();
        final Object inst = evalModule1(env, comp, url, msg);
        if (msg != null) {
            msg.flush();
        }
        if (inst == null) {
            comp.pop(comp.mainLambda);
            return false;
        }
        evalModule2(env, ctx, language, mexp, inst);
        return true;
    }
    
    public static final Object evalModule1(final Environment env, final Compilation comp, final URL url, final OutPort msg) throws SyntaxException {
        final ModuleExp mexp = comp.getModule();
        final Environment orig_env = Environment.setSaveCurrent(env);
        final Compilation orig_comp = Compilation.setSaveCurrent(comp);
        final SourceMessages messages = comp.getMessages();
        ClassLoader savedLoader = null;
        Thread thread = null;
        try {
            comp.process(6);
            comp.getMinfo().loadByStages(10);
            Label_0099: {
                if (msg != null) {
                    if (!messages.checkErrors(msg, 20)) {
                        break Label_0099;
                    }
                }
                else if (!messages.seenErrors()) {
                    break Label_0099;
                }
                return null;
            }
            if (!comp.mustCompile) {
                if (Compilation.debugPrintFinalExpr && msg != null) {
                    msg.println("[Evaluating final module \"" + mexp.getName() + "\":");
                    mexp.print(msg);
                    msg.println(']');
                    msg.flush();
                }
                return Boolean.TRUE;
            }
            final Class clas = evalToClass(comp, url);
            if (clas == null) {
                return null;
            }
            try {
                thread = Thread.currentThread();
                savedLoader = thread.getContextClassLoader();
                thread.setContextClassLoader(clas.getClassLoader());
            }
            catch (Exception ex) {
                thread = null;
            }
            mexp.body = null;
            mexp.thisVariable = null;
            if (msg != null) {
                if (!messages.checkErrors(msg, 20)) {
                    return clas;
                }
            }
            else if (!messages.seenErrors()) {
                return clas;
            }
            return null;
        }
        finally {
            Environment.restoreCurrent(orig_env);
            Compilation.restoreCurrent(orig_comp);
            if (thread != null) {
                thread.setContextClassLoader(savedLoader);
            }
        }
    }
    
    public static final void evalModule2(final Environment env, final CallContext ctx, final Language language, final ModuleExp mexp, Object inst) throws Throwable {
        final Environment orig_env = Environment.setSaveCurrent(env);
        final ClassLoader savedLoader = null;
        final Thread thread = null;
        try {
            if (inst == Boolean.TRUE) {
                mexp.body.apply(ctx);
            }
            else {
                if (inst instanceof Class) {
                    inst = ModuleContext.getContext().findInstance((Class)inst);
                }
                if (inst instanceof Runnable) {
                    if (inst instanceof ModuleBody) {
                        final ModuleBody mb = (ModuleBody)inst;
                        if (!mb.runDone) {
                            mb.runDone = true;
                            mb.run(ctx);
                        }
                    }
                    else {
                        ((Runnable)inst).run();
                    }
                }
                if (mexp == null) {
                    ClassMemberLocation.defineAll(inst, language, env);
                }
                else {
                    for (Declaration decl = mexp.firstDecl(); decl != null; decl = decl.nextDecl()) {
                        final Object dname = decl.getSymbol();
                        if (!decl.isPrivate()) {
                            if (dname != null) {
                                final Field fld = decl.field;
                                final Symbol sym = (Symbol)((dname instanceof Symbol) ? dname : Symbol.make("", dname.toString().intern()));
                                final Object property = language.getEnvPropertyFor(decl);
                                final Expression dvalue = decl.getValue();
                                if ((decl.field.getModifiers() & 0x10) != 0x0) {
                                    Object value;
                                    if (dvalue instanceof QuoteExp && dvalue != QuoteExp.undefined_exp) {
                                        value = ((QuoteExp)dvalue).getValue();
                                    }
                                    else {
                                        value = decl.field.getReflectField().get(null);
                                        if (!decl.isIndirectBinding()) {
                                            decl.setValue(QuoteExp.getInstance(value));
                                        }
                                        else if (!decl.isAlias() || !(dvalue instanceof ReferenceExp)) {
                                            decl.noteValueUnknown();
                                        }
                                    }
                                    if (decl.isIndirectBinding()) {
                                        env.addLocation(sym, property, (Location)value);
                                    }
                                    else {
                                        env.define(sym, property, value);
                                    }
                                }
                                else {
                                    final StaticFieldLocation loc = new StaticFieldLocation(fld.getDeclaringClass(), fld.getName());
                                    loc.setDeclaration(decl);
                                    env.addLocation(sym, property, loc);
                                    decl.noteValueUnknown();
                                }
                            }
                        }
                    }
                }
            }
            ctx.runUntilDone();
        }
        finally {
            Environment.restoreCurrent(orig_env);
            if (thread != null) {
                thread.setContextClassLoader(savedLoader);
            }
        }
    }
    
    public ModuleInfo getMinfo() {
        return this.info;
    }
    
    public String getNamespaceUri() {
        return this.info.uri;
    }
    
    public final ClassType getSuperType() {
        return this.compiledType.getSuperclass();
    }
    
    public final void setSuperType(final ClassType s) {
        this.compiledType.setSuper(s);
    }
    
    public final ClassType[] getInterfaces() {
        return this.compiledType.getInterfaces();
    }
    
    public final void setInterfaces(final ClassType[] s) {
        this.compiledType.setInterfaces(s);
    }
    
    public final boolean isStatic() {
        return this.getFlag(65536) || ((Compilation.moduleStatic >= 0 || this.getFlag(2097152)) && !this.getFlag(262144) && !this.getFlag(131072));
    }
    
    public boolean staticInitRun() {
        return this.isStatic() && (this.getFlag(524288) || this.getFlag(8388608) || Compilation.moduleStatic == 2);
    }
    
    @Override
    public void allocChildClasses(final Compilation comp) {
        this.declareClosureEnv();
        if (!comp.usingCPStyle()) {
            return;
        }
        this.allocFrame(comp);
    }
    
    void allocFields(final Compilation comp) {
        for (Declaration decl = this.firstDecl(); decl != null; decl = decl.nextDecl()) {
            if (!decl.isSimple() || decl.isPublic()) {
                if (decl.field == null) {
                    if (decl.getFlag(65536L) && decl.getFlag(6L)) {
                        decl.makeField(comp, null);
                    }
                }
            }
        }
        for (Declaration decl = this.firstDecl(); decl != null; decl = decl.nextDecl()) {
            if (decl.field == null) {
                final Expression value = decl.getValue();
                if (decl.isSimple() && decl.isModuleLocal() && !decl.isNamespaceDecl()) {
                    if (!decl.getFlag(16384L)) {
                        continue;
                    }
                    if (!decl.getFlag(6L)) {
                        continue;
                    }
                }
                if (!decl.getFlag(65536L)) {
                    if (value instanceof LambdaExp && !(value instanceof ModuleExp) && !(value instanceof ClassExp)) {
                        ((LambdaExp)value).allocFieldFor(comp);
                    }
                    else {
                        decl.makeField(comp, (decl.shouldEarlyInit() || decl.isAlias()) ? value : null);
                    }
                }
            }
        }
    }
    
    @Override
    protected <R, D> R visit(final ExpVisitor<R, D> visitor, final D d) {
        return visitor.visitModuleExp(this, d);
    }
    
    @Override
    public void print(final OutPort out) {
        out.startLogicalBlock("(Module/", ")", 2);
        final Object sym = this.getSymbol();
        if (sym != null) {
            out.print(sym);
            out.print('/');
        }
        out.print(this.id);
        out.print('/');
        out.writeSpaceFill();
        out.startLogicalBlock("(", false, ")");
        Declaration decl = this.firstDecl();
        if (decl != null) {
            out.print("Declarations:");
            while (decl != null) {
                out.writeSpaceFill();
                decl.printInfo(out);
                decl = decl.nextDecl();
            }
        }
        out.endLogicalBlock(")");
        out.writeSpaceLinear();
        if (this.body == null) {
            out.print("<null body>");
        }
        else {
            this.body.print(out);
        }
        out.endLogicalBlock(")");
    }
    
    @Override
    public Declaration firstDecl() {
        synchronized (this) {
            if (this.getFlag(1048576)) {
                this.info.setupModuleExp();
            }
        }
        return this.decls;
    }
    
    public ClassType classFor(final Compilation comp) {
        if (this.compiledType != null && this.compiledType != Compilation.typeProcedure) {
            return this.compiledType;
        }
        String mname = this.getName();
        final String fileName = this.getFileName();
        Path path = null;
        if (mname == null) {
            if (fileName == null) {
                mname = "$unnamed_input_file$";
            }
            else if (fileName.equals("-") || fileName.equals("/dev/stdin")) {
                mname = "$stdin$";
            }
            else {
                path = Path.valueOf(fileName);
                mname = path.getLast();
                final int dotIndex = mname.lastIndexOf(46);
                if (dotIndex > 0) {
                    mname = mname.substring(0, dotIndex);
                }
            }
            this.setName(mname);
        }
        String className;
        if (comp.getModule() == this && this.info != null && this.info.className != null) {
            className = this.info.className;
        }
        else {
            className = Mangling.mangleQualifiedName(mname);
            final Path parentPath;
            String parent;
            if (comp.classPrefix.length() == 0 && path != null && !path.isAbsolute() && (parentPath = path.getParent()) != null && (parent = parentPath.toString()).length() > 0 && parent.indexOf("..") < 0) {
                parent = parent.replace(System.getProperty("file.separator"), "/");
                if (parent.startsWith("./")) {
                    parent = parent.substring(2);
                }
                className = (parent.equals(".") ? className : (Compilation.mangleURI(parent) + "." + className));
            }
            else {
                className = comp.classPrefix + className;
            }
        }
        final ClassType clas = new ClassType(className);
        this.setType(clas);
        if (comp.mainLambda == this) {
            if (comp.mainClass == null) {
                comp.mainClass = clas;
            }
            else if (!className.equals(comp.mainClass.getName())) {
                comp.error('e', "inconsistent main class name: " + className + " - old name: " + comp.mainClass.getName());
            }
        }
        return clas;
    }
    
    void makeDeclInModule2(final Declaration fdecl) {
        final Object fvalue = fdecl.getConstantValue();
        if (fvalue instanceof FieldLocation) {
            final FieldLocation floc = (FieldLocation)fvalue;
            final Declaration vdecl = floc.getDeclaration();
            final ReferenceExp fref = new ReferenceExp(vdecl);
            fdecl.setAlias(true);
            fref.setDontDereference(true);
            fdecl.setValue(fref);
            if (vdecl.isProcedureDecl()) {
                fdecl.setProcedureDecl(true);
            }
            if (vdecl.getFlag(32768L)) {
                fdecl.setSyntax();
            }
            if (!fdecl.getFlag(2048L)) {
                final ClassType vtype = floc.getDeclaringClass();
                final String vname = vtype.getName();
                for (Declaration xdecl = this.firstDecl(); xdecl != null; xdecl = xdecl.nextDecl()) {
                    if (vname.equals(xdecl.getType().getName()) && xdecl.getFlag(1073741824L)) {
                        fref.setContextDecl(xdecl);
                        break;
                    }
                }
            }
        }
    }
    
    @Override
    public void writeExternal(final ObjectOutput out) throws IOException {
        String name = null;
        if (this.compiledType != null && this.compiledType != Compilation.typeProcedure && !this.compiledType.isExisting()) {
            out.writeObject(this.compiledType);
        }
        else {
            if (name == null) {
                name = this.getName();
            }
            if (name == null) {
                name = this.getFileName();
            }
            out.writeObject(name);
        }
    }
    
    @Override
    public void readExternal(final ObjectInput in) throws IOException, ClassNotFoundException {
        final Object name = in.readObject();
        if (name instanceof ClassType) {
            this.compiledType = (ClassType)name;
            this.setName(this.compiledType.getName());
        }
        else {
            this.setName((String)name);
        }
        this.flags |= 0x100000;
    }
    
    static {
        ModuleExp.compilerAvailable = true;
        ModuleExp.alwaysCompile = compilerAvailable();
    }
}
