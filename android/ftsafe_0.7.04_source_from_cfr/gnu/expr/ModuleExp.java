/*
 * Decompiled with CFR 0.139.
 */
package gnu.expr;

import gnu.bytecode.ArrayClassLoader;
import gnu.bytecode.ClassType;
import gnu.bytecode.Type;
import gnu.bytecode.Variable;
import gnu.expr.ClassExp;
import gnu.expr.Compilation;
import gnu.expr.Declaration;
import gnu.expr.ExpVisitor;
import gnu.expr.Expression;
import gnu.expr.LambdaExp;
import gnu.expr.Language;
import gnu.expr.Mangling;
import gnu.expr.ModuleBody;
import gnu.expr.ModuleContext;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleManager;
import gnu.expr.QuoteExp;
import gnu.expr.ReferenceExp;
import gnu.expr.ScopeExp;
import gnu.kawa.io.OutPort;
import gnu.kawa.io.Path;
import gnu.kawa.reflect.ClassMemberLocation;
import gnu.kawa.reflect.FieldLocation;
import gnu.kawa.reflect.StaticFieldLocation;
import gnu.mapping.CallContext;
import gnu.mapping.Environment;
import gnu.mapping.Location;
import gnu.mapping.NamedLocation;
import gnu.mapping.Symbol;
import gnu.mapping.WrappedException;
import gnu.text.SourceMessages;
import gnu.text.SyntaxException;
import java.io.Externalizable;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.zip.CRC32;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ModuleExp
extends LambdaExp
implements Externalizable {
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

    public static ModuleExp valueOf(ClassType type) {
        return ModuleInfo.find(type).getModuleExp();
    }

    public static Class evalToClass(Compilation comp, URL url) throws SyntaxException {
        ModuleExp mexp = comp.getModule();
        ModuleInfo minfo = mexp.info;
        SourceMessages messages = comp.getMessages();
        try {
            Class clas = null;
            if (mexp.subModulesOnly()) {
                clas = Object.class;
            } else {
                minfo.loadByStages(14);
                if (messages.seenErrors()) {
                    return null;
                }
                ArrayClassLoader loader = comp.loader;
                if (url == null) {
                    url = Path.currentPath().toURL();
                }
                loader.setResourceContext(url);
                ZipOutputStream zout = null;
                if (dumpZipPrefix != null) {
                    StringBuffer zipname = new StringBuffer(dumpZipPrefix);
                    ModuleManager manager = ModuleManager.getInstance();
                    if (manager.interactiveCounter > ++lastZipCounter) {
                        lastZipCounter = manager.interactiveCounter;
                    }
                    zipname.append(lastZipCounter);
                    zipname.append(".zip");
                    FileOutputStream zfout = new FileOutputStream(zipname.toString());
                    zout = new ZipOutputStream(zfout);
                }
                for (int iClass = 0; iClass < comp.numClasses; ++iClass) {
                    ClassType clasi = comp.classes[iClass];
                    String className = clasi.getName();
                    byte[] classBytes = clasi.writeToArray();
                    loader.addClass(className, classBytes);
                    if (zout == null) continue;
                    String clname = className.replace('.', '/') + ".class";
                    ZipEntry zent = new ZipEntry(clname);
                    zent.setSize(classBytes.length);
                    CRC32 crc = new CRC32();
                    crc.update(classBytes);
                    zent.setCrc(crc.getValue());
                    zent.setMethod(0);
                    zout.putNextEntry(zent);
                    zout.write(classBytes);
                }
                if (zout != null) {
                    zout.close();
                }
                ArrayClassLoader context = loader;
                while (context.getParent() instanceof ArrayClassLoader) {
                    context = (ArrayClassLoader)context.getParent();
                }
                for (int iClass = 0; iClass < comp.numClasses; ++iClass) {
                    ClassType ctype = comp.classes[iClass];
                    Class cclass = loader.loadClass(ctype.getName());
                    ctype.setReflectClass(cclass);
                    ctype.setExisting(true);
                    if (iClass == 0) {
                        clas = cclass;
                        continue;
                    }
                    if (context == loader) continue;
                    context.addClass(cclass);
                }
                minfo.setModuleClass(clas);
                comp.cleanupAfterCompilation();
            }
            int ndeps = minfo.numDependencies;
            for (int idep = 0; idep < ndeps; ++idep) {
                ModuleInfo dep = minfo.dependencies[idep];
                Class dclass = dep.getModuleClassRaw();
                if (dclass == null) {
                    dclass = ModuleExp.evalToClass(dep.getCompilation(), null);
                }
                if (comp.loader == null) continue;
                comp.loader.addClass(dclass);
            }
            return clas;
        }
        catch (IOException ex) {
            throw new WrappedException("I/O error in lambda eval", ex);
        }
        catch (ClassNotFoundException ex) {
            throw new WrappedException("class not found in lambda eval", ex);
        }
        catch (Exception ex) {
            messages.error('f', "internal compile error - caught " + ex, ex);
            throw new SyntaxException(messages);
        }
    }

    public static synchronized boolean compilerAvailable() {
        if (haveCompiler == 0) {
            if (!compilerAvailable) {
                haveCompiler = -1;
            } else if ("Dalvik".equals(System.getProperty("java.vm.name"))) {
                haveCompiler = -1;
            } else {
                try {
                    Class.forName("gnu.expr.TryExp");
                    haveCompiler = 1;
                }
                catch (Exception ex) {
                    haveCompiler = -1;
                }
            }
        }
        return haveCompiler >= 0;
    }

    public static final boolean evalModule(Environment env, CallContext ctx, Compilation comp, URL url, OutPort msg) throws Throwable {
        ModuleExp mexp = comp.getModule();
        Language language = comp.getLanguage();
        Object inst = ModuleExp.evalModule1(env, comp, url, msg);
        if (msg != null) {
            msg.flush();
        }
        if (inst == null) {
            comp.pop(comp.mainLambda);
            return false;
        }
        ModuleExp.evalModule2(env, ctx, language, mexp, inst);
        return true;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static final Object evalModule1(Environment env, Compilation comp, URL url, OutPort msg) throws SyntaxException {
        ClassLoader savedLoader;
        Compilation orig_comp;
        Thread thread2;
        Environment orig_env;
        Class clas;
        block18 : {
            SourceMessages messages;
            block17 : {
                block16 : {
                    ModuleExp mexp;
                    block15 : {
                        Object var10_10;
                        mexp = comp.getModule();
                        orig_env = Environment.setSaveCurrent(env);
                        orig_comp = Compilation.setSaveCurrent(comp);
                        messages = comp.getMessages();
                        savedLoader = null;
                        thread2 = null;
                        try {
                            comp.process(6);
                            comp.getMinfo().loadByStages(10);
                            if (!(msg != null ? messages.checkErrors(msg, 20) : messages.seenErrors())) break block15;
                            var10_10 = null;
                        }
                        catch (Throwable throwable) {
                            Environment.restoreCurrent(orig_env);
                            Compilation.restoreCurrent(orig_comp);
                            if (thread2 != null) {
                                thread2.setContextClassLoader(savedLoader);
                            }
                            throw throwable;
                        }
                        Environment.restoreCurrent(orig_env);
                        Compilation.restoreCurrent(orig_comp);
                        if (thread2 != null) {
                            thread2.setContextClassLoader(savedLoader);
                        }
                        return var10_10;
                    }
                    if (comp.mustCompile) break block16;
                    if (Compilation.debugPrintFinalExpr && msg != null) {
                        msg.println("[Evaluating final module \"" + mexp.getName() + "\":");
                        mexp.print(msg);
                        msg.println(']');
                        msg.flush();
                    }
                    Boolean bl = Boolean.TRUE;
                    Environment.restoreCurrent(orig_env);
                    Compilation.restoreCurrent(orig_comp);
                    if (thread2 != null) {
                        thread2.setContextClassLoader(savedLoader);
                    }
                    return bl;
                }
                clas = ModuleExp.evalToClass(comp, url);
                if (clas != null) break block17;
                Object var11_13 = null;
                Environment.restoreCurrent(orig_env);
                Compilation.restoreCurrent(orig_comp);
                if (thread2 != null) {
                    thread2.setContextClassLoader(savedLoader);
                }
                return var11_13;
            }
            try {
                thread2 = Thread.currentThread();
                savedLoader = thread2.getContextClassLoader();
                thread2.setContextClassLoader(clas.getClassLoader());
            }
            catch (Exception ex) {
                thread2 = null;
            }
            mexp.body = null;
            mexp.thisVariable = null;
            if (!(msg != null ? messages.checkErrors(msg, 20) : messages.seenErrors())) break block18;
            Object ex = null;
            Environment.restoreCurrent(orig_env);
            Compilation.restoreCurrent(orig_comp);
            if (thread2 != null) {
                thread2.setContextClassLoader(savedLoader);
            }
            return ex;
        }
        Class ex = clas;
        Environment.restoreCurrent(orig_env);
        Compilation.restoreCurrent(orig_comp);
        if (thread2 != null) {
            thread2.setContextClassLoader(savedLoader);
        }
        return ex;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static final void evalModule2(Environment env, CallContext ctx, Language language, ModuleExp mexp, Object inst) throws Throwable {
        Environment orig_env = Environment.setSaveCurrent(env);
        ClassLoader savedLoader = null;
        Thread thread2 = null;
        try {
            if (inst == Boolean.TRUE) {
                mexp.body.apply(ctx);
            } else {
                if (inst instanceof Class) {
                    inst = ModuleContext.getContext().findInstance((Class)inst);
                }
                if (inst instanceof Runnable) {
                    if (inst instanceof ModuleBody) {
                        ModuleBody mb = (ModuleBody)inst;
                        if (!mb.runDone) {
                            mb.runDone = true;
                            mb.run(ctx);
                        }
                    } else {
                        ((Runnable)inst).run();
                    }
                }
                if (mexp == null) {
                    ClassMemberLocation.defineAll(inst, language, env);
                } else {
                    for (Declaration decl = mexp.firstDecl(); decl != null; decl = decl.nextDecl()) {
                        Object dname = decl.getSymbol();
                        if (decl.isPrivate() || dname == null) continue;
                        gnu.bytecode.Field fld = decl.field;
                        Symbol sym = dname instanceof Symbol ? (Symbol)dname : Symbol.make("", dname.toString().intern());
                        Object property = language.getEnvPropertyFor(decl);
                        Expression dvalue = decl.getValue();
                        if ((decl.field.getModifiers() & 16) != 0) {
                            Object value;
                            if (dvalue instanceof QuoteExp && dvalue != QuoteExp.undefined_exp) {
                                value = ((QuoteExp)dvalue).getValue();
                            } else {
                                value = decl.field.getReflectField().get(null);
                                if (!decl.isIndirectBinding()) {
                                    decl.setValue(QuoteExp.getInstance(value));
                                } else if (!decl.isAlias() || !(dvalue instanceof ReferenceExp)) {
                                    decl.noteValueUnknown();
                                }
                            }
                            if (decl.isIndirectBinding()) {
                                env.addLocation(sym, property, (Location)value);
                                continue;
                            }
                            env.define(sym, property, value);
                            continue;
                        }
                        StaticFieldLocation loc = new StaticFieldLocation(fld.getDeclaringClass(), fld.getName());
                        loc.setDeclaration(decl);
                        env.addLocation(sym, property, loc);
                        decl.noteValueUnknown();
                    }
                }
            }
            ctx.runUntilDone();
        }
        finally {
            Environment.restoreCurrent(orig_env);
            if (thread2 != null) {
                thread2.setContextClassLoader(savedLoader);
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

    public final void setSuperType(ClassType s) {
        this.compiledType.setSuper(s);
    }

    public final ClassType[] getInterfaces() {
        return this.compiledType.getInterfaces();
    }

    public final void setInterfaces(ClassType[] s) {
        this.compiledType.setInterfaces(s);
    }

    public final boolean isStatic() {
        return this.getFlag(65536) || (Compilation.moduleStatic >= 0 || this.getFlag(2097152)) && !this.getFlag(262144) && !this.getFlag(131072);
    }

    public boolean staticInitRun() {
        return this.isStatic() && (this.getFlag(524288) || this.getFlag(8388608) || Compilation.moduleStatic == 2);
    }

    @Override
    public void allocChildClasses(Compilation comp) {
        this.declareClosureEnv();
        if (!comp.usingCPStyle()) {
            return;
        }
        this.allocFrame(comp);
    }

    void allocFields(Compilation comp) {
        Declaration decl;
        for (decl = this.firstDecl(); decl != null; decl = decl.nextDecl()) {
            if (decl.isSimple() && !decl.isPublic() || decl.field != null || !decl.getFlag(65536L) || !decl.getFlag(6L)) continue;
            decl.makeField(comp, null);
        }
        for (decl = this.firstDecl(); decl != null; decl = decl.nextDecl()) {
            if (decl.field != null) continue;
            Expression value = decl.getValue();
            if (decl.isSimple() && decl.isModuleLocal() && !decl.isNamespaceDecl() && (!decl.getFlag(16384L) || !decl.getFlag(6L)) || decl.getFlag(65536L)) continue;
            if (value instanceof LambdaExp && !(value instanceof ModuleExp) && !(value instanceof ClassExp)) {
                ((LambdaExp)value).allocFieldFor(comp);
                continue;
            }
            decl.makeField(comp, decl.shouldEarlyInit() || decl.isAlias() ? value : null);
        }
    }

    @Override
    protected <R, D> R visit(ExpVisitor<R, D> visitor, D d) {
        return visitor.visitModuleExp(this, d);
    }

    @Override
    public void print(OutPort out) {
        Declaration decl;
        out.startLogicalBlock("(Module/", ")", 2);
        Object sym = this.getSymbol();
        if (sym != null) {
            out.print(sym);
            out.print('/');
        }
        out.print(this.id);
        out.print('/');
        out.writeSpaceFill();
        out.startLogicalBlock("(", false, ")");
        if (decl != null) {
            out.print("Declarations:");
            for (decl = this.firstDecl(); decl != null; decl = decl.nextDecl()) {
                out.writeSpaceFill();
                decl.printInfo(out);
            }
        }
        out.endLogicalBlock(")");
        out.writeSpaceLinear();
        if (this.body == null) {
            out.print("<null body>");
        } else {
            this.body.print(out);
        }
        out.endLogicalBlock(")");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public Declaration firstDecl() {
        ModuleExp moduleExp = this;
        synchronized (moduleExp) {
            if (this.getFlag(1048576)) {
                this.info.setupModuleExp();
            }
        }
        return this.decls;
    }

    public ClassType classFor(Compilation comp) {
        String className;
        if (this.compiledType != null && this.compiledType != Compilation.typeProcedure) {
            return this.compiledType;
        }
        String mname = this.getName();
        String fileName = this.getFileName();
        Path path = null;
        if (mname == null) {
            if (fileName == null) {
                mname = "$unnamed_input_file$";
            } else if (fileName.equals("-") || fileName.equals("/dev/stdin")) {
                mname = "$stdin$";
            } else {
                path = Path.valueOf(fileName);
                mname = path.getLast();
                int dotIndex = mname.lastIndexOf(46);
                if (dotIndex > 0) {
                    mname = mname.substring(0, dotIndex);
                }
            }
            this.setName(mname);
        }
        if (comp.getModule() == this && this.info != null && this.info.className != null) {
            className = this.info.className;
        } else {
            Path parentPath;
            String parent;
            className = Mangling.mangleQualifiedName(mname);
            if (comp.classPrefix.length() == 0 && path != null && !path.isAbsolute() && (parentPath = path.getParent()) != null && (parent = parentPath.toString()).length() > 0 && parent.indexOf("..") < 0) {
                if ((parent = parent.replace(System.getProperty("file.separator"), "/")).startsWith("./")) {
                    parent = parent.substring(2);
                }
                className = parent.equals(".") ? className : Compilation.mangleURI(parent) + "." + className;
            } else {
                className = comp.classPrefix + className;
            }
        }
        ClassType clas = new ClassType(className);
        this.setType(clas);
        if (comp.mainLambda == this) {
            if (comp.mainClass == null) {
                comp.mainClass = clas;
            } else if (!className.equals(comp.mainClass.getName())) {
                comp.error('e', "inconsistent main class name: " + className + " - old name: " + comp.mainClass.getName());
            }
        }
        return clas;
    }

    void makeDeclInModule2(Declaration fdecl) {
        Object fvalue = fdecl.getConstantValue();
        if (fvalue instanceof FieldLocation) {
            FieldLocation floc = (FieldLocation)fvalue;
            Declaration vdecl = floc.getDeclaration();
            ReferenceExp fref = new ReferenceExp(vdecl);
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
                ClassType vtype = floc.getDeclaringClass();
                String vname = vtype.getName();
                for (Declaration xdecl = this.firstDecl(); xdecl != null; xdecl = xdecl.nextDecl()) {
                    if (!vname.equals(xdecl.getType().getName()) || !xdecl.getFlag(0x40000000L)) continue;
                    fref.setContextDecl(xdecl);
                    break;
                }
            }
        }
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        String name = null;
        if (this.compiledType != null && this.compiledType != Compilation.typeProcedure && !this.compiledType.isExisting()) {
            out.writeObject(this.compiledType);
        } else {
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
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        Object name = in.readObject();
        if (name instanceof ClassType) {
            this.compiledType = (ClassType)name;
            this.setName(this.compiledType.getName());
        } else {
            this.setName((String)name);
        }
        this.flags |= 1048576;
    }

    static {
        compilerAvailable = true;
        alwaysCompile = ModuleExp.compilerAvailable();
    }
}

