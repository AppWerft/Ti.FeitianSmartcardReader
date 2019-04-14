package gnu.expr;

import gnu.bytecode.ArrayClassLoader;
import gnu.bytecode.ClassType;
import gnu.bytecode.Type;
import gnu.kawa.io.OutPort;
import gnu.kawa.io.Path;
import gnu.kawa.reflect.ClassMemberLocation;
import gnu.kawa.reflect.FieldLocation;
import gnu.kawa.reflect.StaticFieldLocation;
import gnu.mapping.CallContext;
import gnu.mapping.Environment;
import gnu.mapping.Location;
import gnu.mapping.Symbol;
import gnu.mapping.WrappedException;
import gnu.text.SourceMessages;
import gnu.text.SyntaxException;
import java.io.Externalizable;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.net.URL;
import java.util.zip.CRC32;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

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
  
  public ModuleExp() {}
  
  public boolean subModulesOnly()
  {
    return (getFlag(16777216)) && (body == QuoteExp.voidExp) && (firstDecl() == null);
  }
  
  public static ModuleExp valueOf(ClassType type)
  {
    return ModuleInfo.find(type).getModuleExp();
  }
  







  public static Class evalToClass(Compilation comp, URL url)
    throws SyntaxException
  {
    ModuleExp mexp = comp.getModule();
    ModuleInfo minfo = info;
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
        if (url == null)
          url = Path.currentPath().toURL();
        loader.setResourceContext(url);
        
        ZipOutputStream zout = null;
        if (dumpZipPrefix != null) {
          StringBuffer zipname = new StringBuffer(dumpZipPrefix);
          ModuleManager manager = ModuleManager.getInstance();
          lastZipCounter += 1;
          if (interactiveCounter > lastZipCounter)
            lastZipCounter = interactiveCounter;
          zipname.append(lastZipCounter);
          zipname.append(".zip");
          FileOutputStream zfout = new FileOutputStream(zipname.toString());
          
          zout = new ZipOutputStream(zfout);
        }
        
        for (int iClass = 0; iClass < numClasses; iClass++) {
          ClassType clasi = classes[iClass];
          String className = clasi.getName();
          byte[] classBytes = clasi.writeToArray();
          loader.addClass(className, classBytes);
          
          if (zout != null) {
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
        }
        if (zout != null) {
          zout.close();
        }
        









        ArrayClassLoader context = loader;
        while ((context.getParent() instanceof ArrayClassLoader))
          context = (ArrayClassLoader)context.getParent();
        for (int iClass = 0; iClass < numClasses; iClass++) {
          ClassType ctype = classes[iClass];
          Class cclass = loader.loadClass(ctype.getName());
          ctype.setReflectClass(cclass);
          ctype.setExisting(true);
          if (iClass == 0) {
            clas = cclass;



          }
          else if (context != loader) {
            context.addClass(cclass);
          }
        }
        minfo.setModuleClass(clas);
        comp.cleanupAfterCompilation();
      }
      int ndeps = numDependencies;
      
      for (int idep = 0; idep < ndeps; idep++) {
        ModuleInfo dep = dependencies[idep];
        Class dclass = dep.getModuleClassRaw();
        if (dclass == null)
          dclass = evalToClass(dep.getCompilation(), null);
        if (comp.loader != null) {
          comp.loader.addClass(dclass);
        }
      }
      return clas;
    } catch (IOException ex) {
      throw new WrappedException("I/O error in lambda eval", ex);
    } catch (ClassNotFoundException ex) {
      throw new WrappedException("class not found in lambda eval", ex);
    } catch (Exception ex) {
      messages.error('f', "internal compile error - caught " + ex, ex);
      throw new SyntaxException(messages);
    } }
  
  @Deprecated
  public static boolean compilerAvailable = true;
  
  private static int haveCompiler;
  
  public static synchronized boolean compilerAvailable()
  {
    if (haveCompiler == 0) {
      if (!compilerAvailable) {
        haveCompiler = -1;
      } else if ("Dalvik".equals(System.getProperty("java.vm.name"))) {
        haveCompiler = -1;
      }
      else {
        try
        {
          Class.forName("gnu.expr.TryExp");
          haveCompiler = 1;
        } catch (Exception ex) {
          haveCompiler = -1;
        }
      }
    }
    return haveCompiler >= 0;
  }
  

  public static boolean alwaysCompile = compilerAvailable();
  ModuleInfo info;
  
  public static final boolean evalModule(Environment env, CallContext ctx, Compilation comp, URL url, OutPort msg) throws Throwable
  {
    ModuleExp mexp = comp.getModule();
    Language language = comp.getLanguage();
    Object inst = evalModule1(env, comp, url, msg);
    if (msg != null)
      msg.flush();
    if (inst == null) {
      comp.pop(mainLambda);
      return false;
    }
    evalModule2(env, ctx, language, mexp, inst);
    return true;
  }
  





  public static final Object evalModule1(Environment env, Compilation comp, URL url, OutPort msg)
    throws SyntaxException
  {
    ModuleExp mexp = comp.getModule();
    Environment orig_env = Environment.setSaveCurrent(env);
    Compilation orig_comp = Compilation.setSaveCurrent(comp);
    SourceMessages messages = comp.getMessages();
    ClassLoader savedLoader = null;
    Thread thread = null;
    try {
      comp.process(6);
      comp.getMinfo().loadByStages(10);
      Object localObject1;
      if (msg != null ? messages.checkErrors(msg, 20) : messages.seenErrors()) {
        return null;
      }
      if (!mustCompile) {
        if ((Compilation.debugPrintFinalExpr) && (msg != null)) {
          msg.println("[Evaluating final module \"" + mexp.getName() + "\":");
          mexp.print(msg);
          msg.println(']');
          msg.flush();
        }
        return Boolean.TRUE;
      }
      Class clas = evalToClass(comp, url);
      if (clas == null)
        return null;
      try {
        thread = Thread.currentThread();
        savedLoader = thread.getContextClassLoader();
        thread.setContextClassLoader(clas.getClassLoader());
      } catch (Exception ex) {
        thread = null;
      }
      
      body = null;
      thisVariable = null;
      if (msg != null ? messages.checkErrors(msg, 20) : messages.seenErrors())
      {
        return null; }
      return clas;
    }
    finally {
      Environment.restoreCurrent(orig_env);
      Compilation.restoreCurrent(orig_comp);
      if (thread != null) {
        thread.setContextClassLoader(savedLoader);
      }
    }
  }
  
  public static final void evalModule2(Environment env, CallContext ctx, Language language, ModuleExp mexp, Object inst)
    throws Throwable
  {
    Environment orig_env = Environment.setSaveCurrent(env);
    ClassLoader savedLoader = null;
    Thread thread = null;
    try {
      if (inst == Boolean.TRUE)
      {
        body.apply(ctx);
      } else {
        if ((inst instanceof Class)) {
          inst = ModuleContext.getContext().findInstance((Class)inst);
        }
        
        if ((inst instanceof Runnable)) {
          if ((inst instanceof ModuleBody)) {
            ModuleBody mb = (ModuleBody)inst;
            if (!runDone) {
              runDone = true;
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
          for (Declaration decl = mexp.firstDecl(); 
              decl != null; decl = decl.nextDecl()) {
            Object dname = decl.getSymbol();
            if ((!decl.isPrivate()) && (dname != null))
            {
              gnu.bytecode.Field fld = field;
              Symbol sym = (dname instanceof Symbol) ? (Symbol)dname : Symbol.make("", dname.toString().intern());
              
              Object property = language.getEnvPropertyFor(decl);
              Expression dvalue = decl.getValue();
              



              if ((field.getModifiers() & 0x10) != 0) { Object value;
                Object value;
                if (((dvalue instanceof QuoteExp)) && (dvalue != QuoteExp.undefined_exp))
                {
                  value = ((QuoteExp)dvalue).getValue();
                } else {
                  value = field.getReflectField().get(null);
                  if (!decl.isIndirectBinding()) {
                    decl.setValue(QuoteExp.getInstance(value));
                  } else if ((!decl.isAlias()) || (!(dvalue instanceof ReferenceExp)))
                    decl.noteValueUnknown();
                }
                if (decl.isIndirectBinding()) {
                  env.addLocation(sym, property, (Location)value);
                } else
                  env.define(sym, property, value);
              } else {
                StaticFieldLocation loc = new StaticFieldLocation(fld.getDeclaringClass(), fld.getName());
                

                loc.setDeclaration(decl);
                env.addLocation(sym, property, loc);
                decl.noteValueUnknown();
              }
            }
          }
        }
      }
      



      ctx.runUntilDone();
    } finally {
      Environment.restoreCurrent(orig_env);
      if (thread != null) {
        thread.setContextClassLoader(savedLoader);
      }
    }
  }
  
  public ModuleInfo getMinfo()
  {
    return info;
  }
  
  public String getNamespaceUri() { return info.uri; }
  
  public final ClassType getSuperType() {
    return compiledType.getSuperclass();
  }
  
  public final void setSuperType(ClassType s) { compiledType.setSuper(s); }
  
  public final ClassType[] getInterfaces() {
    return compiledType.getInterfaces();
  }
  
  public final void setInterfaces(ClassType[] s) { compiledType.setInterfaces(s); }
  


  public final boolean isStatic()
  {
    return (getFlag(65536)) || (((Compilation.moduleStatic >= 0) || (getFlag(2097152))) && (!getFlag(262144)) && (!getFlag(131072)));
  }
  




  public boolean staticInitRun()
  {
    return (isStatic()) && ((getFlag(524288)) || (getFlag(8388608)) || (Compilation.moduleStatic == 2));
  }
  


  public void allocChildClasses(Compilation comp)
  {
    declareClosureEnv();
    if (!comp.usingCPStyle())
      return;
    allocFrame(comp);
  }
  





  void allocFields(Compilation comp)
  {
    for (Declaration decl = firstDecl(); 
        decl != null; decl = decl.nextDecl()) {
      if (((!decl.isSimple()) || (decl.isPublic())) && (field == null))
      {
        if ((decl.getFlag(65536L)) && (decl.getFlag(6L)))
        {


          decl.makeField(comp, null); } }
    }
    for (Declaration decl = firstDecl(); 
        decl != null; decl = decl.nextDecl()) {
      if (field == null)
      {
        Expression value = decl.getValue();
        if ((!decl.isSimple()) || (!decl.isModuleLocal()) || (decl.isNamespaceDecl()) || ((decl.getFlag(16384L)) && (decl.getFlag(6L))))
        {




          if (!decl.getFlag(65536L))
          {
            if (((value instanceof LambdaExp)) && (!(value instanceof ModuleExp)) && (!(value instanceof ClassExp)))
            {

              ((LambdaExp)value).allocFieldFor(comp);
            } else
              decl.makeField(comp, (decl.shouldEarlyInit()) || (decl.isAlias()) ? value : null);
          }
        }
      }
    }
  }
  
  protected <R, D> R visit(ExpVisitor<R, D> visitor, D d) {
    return visitor.visitModuleExp(this, d);
  }
  
  public void print(OutPort out) {
    out.startLogicalBlock("(Module/", ")", 2);
    Object sym = getSymbol();
    if (sym != null) {
      out.print(sym);
      out.print('/');
    }
    out.print(id);
    out.print('/');
    out.writeSpaceFill();
    out.startLogicalBlock("(", false, ")");
    Declaration decl = firstDecl();
    if (decl != null) {
      out.print("Declarations:");
      for (; decl != null; decl = decl.nextDecl()) {
        out.writeSpaceFill();
        decl.printInfo(out);
      }
    }
    out.endLogicalBlock(")");
    out.writeSpaceLinear();
    if (body == null) {
      out.print("<null body>");
    } else
      body.print(out);
    out.endLogicalBlock(")");
  }
  
  public Declaration firstDecl() {
    synchronized (this) {
      if (getFlag(1048576))
        info.setupModuleExp();
    }
    return decls;
  }
  


  public ClassType classFor(Compilation comp)
  {
    if ((compiledType != null) && (compiledType != Compilation.typeProcedure))
      return compiledType;
    String mname = getName();
    String fileName = getFileName();
    Path path = null;
    if (mname == null) {
      if (fileName == null) {
        mname = "$unnamed_input_file$";
      } else if ((fileName.equals("-")) || (fileName.equals("/dev/stdin"))) {
        mname = "$stdin$";
      } else {
        path = Path.valueOf(fileName);
        mname = path.getLast();
        int dotIndex = mname.lastIndexOf('.');
        if (dotIndex > 0)
          mname = mname.substring(0, dotIndex);
      }
      setName(mname); }
    String className;
    String className;
    if ((comp.getModule() == this) && (info != null) && (info.className != null))
    {

      className = info.className;
    } else {
      className = Mangling.mangleQualifiedName(mname);
      
      Path parentPath;
      String parent;
      if ((classPrefix.length() == 0) && (path != null) && (!path.isAbsolute()) && ((parentPath = path.getParent()) != null) && ((parent = parentPath.toString()).length() > 0) && (parent.indexOf("..") < 0))
      {




        parent = parent.replace(System.getProperty("file.separator"), "/");
        if (parent.startsWith("./"))
          parent = parent.substring(2);
        className = Compilation.mangleURI(parent) + "." + className;
      }
      else
      {
        className = classPrefix + className;
      } }
    ClassType clas = new ClassType(className);
    setType(clas);
    if (mainLambda == this) {
      if (mainClass == null) {
        mainClass = clas;
      } else if (!className.equals(mainClass.getName())) {
        comp.error('e', "inconsistent main class name: " + className + " - old name: " + mainClass.getName());
      }
    }
    return clas;
  }
  
  void makeDeclInModule2(Declaration fdecl) {
    Object fvalue = fdecl.getConstantValue();
    if ((fvalue instanceof FieldLocation)) {
      FieldLocation floc = (FieldLocation)fvalue;
      Declaration vdecl = floc.getDeclaration();
      ReferenceExp fref = new ReferenceExp(vdecl);
      fdecl.setAlias(true);
      fref.setDontDereference(true);
      fdecl.setValue(fref);
      if (vdecl.isProcedureDecl())
        fdecl.setProcedureDecl(true);
      if (vdecl.getFlag(32768L))
        fdecl.setSyntax();
      if (!fdecl.getFlag(2048L)) {
        ClassType vtype = floc.getDeclaringClass();
        String vname = vtype.getName();
        for (Declaration xdecl = firstDecl(); 
            xdecl != null; xdecl = xdecl.nextDecl()) {
          if ((vname.equals(xdecl.getType().getName())) && (xdecl.getFlag(1073741824L)))
          {
            fref.setContextDecl(xdecl);
            break;
          }
        }
      }
    }
  }
  
  public void writeExternal(ObjectOutput out) throws IOException {
    String name = null;
    if ((compiledType != null) && (compiledType != Compilation.typeProcedure) && (!compiledType.isExisting()))
    {



      out.writeObject(compiledType);
    } else {
      if (name == null)
        name = getName();
      if (name == null)
        name = getFileName();
      out.writeObject(name);
    }
  }
  
  public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException
  {
    Object name = in.readObject();
    if ((name instanceof ClassType)) {
      compiledType = ((ClassType)name);
      setName(compiledType.getName());
    } else {
      setName((String)name); }
    flags |= 0x100000;
  }
}
