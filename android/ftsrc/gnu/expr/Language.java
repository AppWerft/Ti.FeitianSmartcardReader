package gnu.expr;

import gnu.bytecode.ArrayType;
import gnu.bytecode.ClassType;
import gnu.bytecode.ParameterizedType;
import gnu.bytecode.Type;
import gnu.bytecode.TypeVariable;
import gnu.kawa.io.CharArrayInPort;
import gnu.kawa.io.CheckConsole;
import gnu.kawa.io.InPort;
import gnu.kawa.io.OutPort;
import gnu.kawa.reflect.StaticFieldLocation;
import gnu.lists.Consumer;
import gnu.mapping.CallContext;
import gnu.mapping.Environment;
import gnu.mapping.EnvironmentKey;
import gnu.mapping.Location;
import gnu.mapping.Named;
import gnu.mapping.Namespace;
import gnu.mapping.Symbol;
import gnu.mapping.ThreadLocation;
import gnu.mapping.WrappedException;
import gnu.text.Lexer;
import gnu.text.SourceMessages;
import gnu.text.SyntaxException;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import kawa.SourceType;

public abstract class Language
{
  protected static final InheritableThreadLocal<Language> current = new InheritableThreadLocal();
  
  protected static Language global;
  
  public static Language getDefaultLanguage()
  {
    Language lang = (Language)current.get();
    return lang != null ? lang : global;
  }
  
  static { Environment.setGlobal(BuiltinEnvironment.getInstance()); }
  
  public static void setCurrentLanguage(Language language)
  {
    current.set(language);
    if (CheckConsole.prompt1.get(null) == null)
      CheckConsole.prompt1.set(language.getPrimaryPrompt());
    if (CheckConsole.prompt2.get(null) == null) {
      CheckConsole.prompt2.set(language.getSecondaryPrompt());
    }
  }
  
  public static Language setSaveCurrent(Language language) {
    Language save = (Language)current.get();
    current.set(language);
    return save;
  }
  
  public static void restoreCurrent(Language saved)
  {
    current.set(saved);
  }
  







  static String[][] languages = { { "scheme", ".scm", ".sc", ".sld", "kawa.standard.Scheme" }, { "r5rs", ".scm", "kawa.standard.Scheme" }, { "r6rs", ".scm", "kawa.standard.Scheme" }, { "r7rs", ".scm", "kawa.standard.Scheme" }, { "krl", ".krl", "gnu.kawa.brl.BRL" }, { "brl", ".brl", "gnu.kawa.brl.BRL" }, { "emacs", "elisp", "emacs-lisp", ".el", "gnu.jemacs.lang.ELisp" }, { "xquery", ".xquery", ".xq", ".xql", "gnu.xquery.lang.XQuery" }, { "kashell", ".ksl", "gnu.q2.lang.Q2" }, { "q2", ".q2", "gnu.q2.lang.Q2" }, { "xslt", "xsl", ".xsl", "gnu.kawa.xslt.XSLT" }, { "commonlisp", "common-lisp", "clisp", "lisp", ".lisp", ".lsp", ".cl", "gnu.commonlisp.lang.CommonLisp" } };
  protected Environment environ;
  protected Environment userEnv;
  static int envCounter;
  private java.util.List<String> extensions;
  private java.lang.reflect.Constructor<Compilation> compilationClassConstructor;
  public static final int PARSE_IMMEDIATE = 1;
  public static final int PARSE_CURRENT_NAMES = 2;
  public static final int PARSE_ONE_LINE = 4;
  public static final int PARSE_PROLOG = 8;
  public static final int PARSE_FOR_EVAL = 3;
  public static final int PARSE_FOR_APPLET = 16;
  public static final int PARSE_FOR_SERVLET = 32;
  public static final int PARSE_EXPLICIT = 64;
  public static final int PARSE_INTERACTIVE_MODULE = 128;
  public static final int PARSE_EMIT_MAIN = 256;
  public static boolean requirePedantic;
  public static final int VALUE_NAMESPACE = 1;
  public static final int FUNCTION_NAMESPACE = 2;
  public static final int NAMESPACE_PREFIX_NAMESPACE = 4;
  
  public static String[][] getLanguages() {
    return languages;
  }
  







  public static void registerLanguage(String[] langMapping)
  {
    String[][] newLangs = new String[languages.length + 1][];
    System.arraycopy(languages, 0, newLangs, 0, languages.length);
    newLangs[(newLangs.length - 1)] = langMapping;
    languages = newLangs;
  }
  



  public static Language detect(InputStream in)
    throws IOException
  {
    if (!in.markSupported())
      return null;
    StringBuffer sbuf = new StringBuffer();
    in.mark(200);
    

    while (sbuf.length() < 200)
    {
      int c = in.read();
      if ((c < 0) || (c == 10) || (c == 13))
        break;
      sbuf.append((char)c);
    }
    in.reset();
    return detect(sbuf.toString());
  }
  



  public static Language detect(InPort port)
    throws IOException
  {
    StringBuffer sbuf = new StringBuffer();
    port.mark(300);
    port.readLine(sbuf, 'P');
    port.reset();
    return detect(sbuf.toString());
  }
  




  public static Language detect(String line)
  {
    String str = line.trim();
    
    int k = str.indexOf("kawa:");
    if (k >= 0)
    {
      int i = k + 5;
      int j = i;
      
      while ((j < str.length()) && (Character.isJavaIdentifierPart(str.charAt(j))))
        j++;
      if (j > i)
      {
        String w = str.substring(i, j);
        Language lang = getInstance(w);
        if (lang != null) {
          return lang;
        }
      }
    }
    if (str.indexOf("-*- scheme -*-") >= 0)
      return getInstance("scheme");
    if (str.indexOf("-*- xquery -*-") >= 0)
      return getInstance("xquery");
    if (str.indexOf("-*- emacs-lisp -*-") >= 0)
      return getInstance("elisp");
    if ((str.indexOf("-*- common-lisp -*-") >= 0) || (str.indexOf("-*- lisp -*-") >= 0))
    {
      return getInstance("common-lisp");
    }
    if ((str.startsWith("(:")) || (str.startsWith("xquery")))
      return getInstance("xquery");
    if (str.startsWith(";;"))
      return getInstance("scheme");
    return null;
  }
  
  public static Language getInstanceFromFilenameExtension(String filename)
  {
    int dot = filename.lastIndexOf('.');
    if (dot > 0)
    {
      Language lang = getInstance(filename.substring(dot));
      if (lang != null)
        return lang;
    }
    return null;
  }
  


  public static Language getInstance(String name)
  {
    int langCount = languages.length;
    for (int i = 0; i < langCount; i++)
    {
      String[] names = languages[i];
      int nameCount = names.length - 1;
      int j = nameCount; do { j--; if (j < 0)
          break;
      } while ((name != null) && (!names[j].equalsIgnoreCase(name)));
      
      Class langClass;
      try
      {
        langClass = Class.forName(names[nameCount]);
      }
      catch (ClassNotFoundException ex)
      {
        continue;
      }
      


      return getInstance(names[0], langClass);
    }
    

    return null;
  }
  
  protected Language()
  {
    gnu.lists.Convert.setInstance(KawaConvert.getInstance());
  }
  

  public static Language getInstance(String langName, Class langClass)
  {
    try
    {
      Class[] args = new Class[0];
      java.lang.reflect.Method method;
      try {
        String capitalizedName = Character.toTitleCase(langName.charAt(0)) + langName.substring(1).toLowerCase();
        

        String methodName = "get" + capitalizedName + "Instance";
        method = langClass.getDeclaredMethod(methodName, args);
      }
      catch (Exception ex)
      {
        method = langClass.getDeclaredMethod("getInstance", args);
      }
      
      return (Language)method.invoke(null, gnu.mapping.Values.noArgs);
    }
    catch (Exception ex)
    {
      langName = langClass.getName();
      Throwable th;
      Throwable th; if ((ex instanceof InvocationTargetException)) {
        th = ((InvocationTargetException)ex).getTargetException();
      } else {
        th = ex;
      }
      throw new WrappedException("getInstance for '" + langName + "' failed", th);
    }
  }
  



  public boolean isTrue(Object value)
  {
    return (value != null) && ((!(value instanceof Boolean)) || (((Boolean)value).booleanValue()));
  }
  


  public int booleanValue(Object value)
  {
    try
    {
      return isTrue(value) ? 1 : 0;
    } catch (Exception ex) {}
    return -1;
  }
  

  public Object booleanObject(boolean b)
  {
    return b ? Boolean.TRUE : Boolean.FALSE;
  }
  

  public Object noValue()
  {
    return gnu.mapping.Values.empty;
  }
  


  public boolean hasSeparateFunctionNamespace()
  {
    return false;
  }
  











  public final Environment getEnvironment()
  {
    return userEnv != null ? userEnv : Environment.getCurrent();
  }
  


  public final Environment getNewEnvironment()
  {
    return Environment.make("environment-" + ++envCounter, environ);
  }
  
  public Environment getLangEnvironment() { return environ; }
  
  public gnu.mapping.NamedLocation lookupBuiltin(Symbol name, Object property, int hash)
  {
    return environ == null ? null : environ.lookup(name, property, hash);
  }
  

  public void define(String sym, Object p)
  {
    Symbol s = getSymbol(sym);
    environ.define(s, null, p);
  }
  














  public Type getNamedType(String name)
  {
    return null;
  }
  

  protected void defAliasStFld(String name, String cname, String fname)
  {
    StaticFieldLocation.define(environ, getSymbol(name), null, cname, fname);
  }
  






  protected void defProcStFld(String name, String cname, String fname)
  {
    defProcStFld(getSymbol(name), cname, fname);
  }
  
  protected void defProcStFld(Symbol sym, String cname, String fname)
  {
    Object property = hasSeparateFunctionNamespace() ? EnvironmentKey.FUNCTION : null;
    
    StaticFieldLocation loc = StaticFieldLocation.define(environ, sym, property, cname, fname);
    
    loc.setProcedure();
  }
  





  protected void defProcStFld(String name, String cname)
  {
    defProcStFld(name, cname, mangleNameIfNeeded(name));
  }
  






  protected void defProcStFldAs(String asName, String cname, String mname)
  {
    defProcStFld(asName, cname, mangleNameIfNeeded(mname));
  }
  

  public final void defineFunction(Named proc)
  {
    Object name = proc.getSymbol();
    Symbol sym = (name instanceof Symbol) ? (Symbol)name : getSymbol(name.toString());
    
    Object property = hasSeparateFunctionNamespace() ? EnvironmentKey.FUNCTION : null;
    
    environ.define(sym, property, proc);
  }
  



  public void defineFunction(String name, Object proc)
  {
    Object property = hasSeparateFunctionNamespace() ? EnvironmentKey.FUNCTION : null;
    
    environ.define(getSymbol(name), property, proc);
  }
  
  public Object getEnvPropertyFor(java.lang.reflect.Field fld, Object value)
  {
    if (!hasSeparateFunctionNamespace())
      return null;
    if (Compilation.typeProcedure.getReflectClass().isAssignableFrom(fld.getType()))
    {
      return EnvironmentKey.FUNCTION; }
    return null;
  }
  
  public Object getEnvPropertyFor(Declaration decl)
  {
    if ((hasSeparateFunctionNamespace()) && (decl.isProcedureDecl()))
      return EnvironmentKey.FUNCTION;
    return null;
  }
  
  public void loadClass(String name)
    throws ClassNotFoundException
  {
    Class clas;
    try
    {
      clas = Class.forName(name);
    }
    catch (ClassNotFoundException ex)
    {
      throw ex;
    }
    try
    {
      Object inst = clas.newInstance();
      gnu.kawa.reflect.ClassMemberLocation.defineAll(inst, this, Environment.getCurrent());
      if ((inst instanceof ModuleBody)) {
        ((ModuleBody)inst).run();
      }
    }
    catch (Exception ex) {
      throw new WrappedException("cannot load " + name, ex);
    }
  }
  
  public Symbol getSymbol(String name)
  {
    return environ.getSymbol(name);
  }
  
  public Object lookup(String name)
  {
    return environ.get(name);
  }
  
  public gnu.kawa.format.AbstractFormat getFormat(boolean readable)
  {
    return null;
  }
  
  public Consumer getOutputConsumer(Writer out)
  {
    OutPort oport = (out instanceof OutPort) ? (OutPort)out : new OutPort(out);
    
    return getFormat(false).makeConsumer(oport);
  }
  
  public String getName()
  {
    String name = getClass().getName();
    int dot = name.lastIndexOf('.');
    if (dot >= 0)
      name = name.substring(dot + 1);
    return name;
  }
  

  public java.util.List<String> getExtensions()
  {
    if (extensions == null) {
      ArrayList<String> exts = new ArrayList(1);
      String thisClassName = getClass().getName();
      String[][] langs = getLanguages();
      for (int i = 0; i < langs.length; i++) {
        String[] lang = langs[i];
        if (lang != null)
        {
          int n = lang.length - 1;
          String langClass = lang[n];
          if (thisClassName.equals(langClass))
          {
            for (int j = 1; j < n; j++) {
              String ext = lang[j];
              if ((ext != null) && (ext.charAt(0) == '.')) {
                ext = ext.substring(1);
                if (!exts.contains(ext))
                  exts.add(ext);
              }
            } }
        } }
      extensions = java.util.Collections.unmodifiableList(exts);
    }
    return extensions;
  }
  
  public static String mangleNameIfNeeded(String name)
  {
    if ((name == null) || (isValidJavaName(name))) {
      return name;
    }
    return mangleName(name, 0);
  }
  
  public static boolean isValidJavaName(String name)
  {
    int len = name.length();
    if ((len == 0) || (!Character.isJavaIdentifierStart(name.charAt(0))))
      return false;
    int i = len; do { i--; if (i <= 0) break;
    } while (Character.isJavaIdentifierPart(name.charAt(i)));
    return false;
    return true;
  }
  





  public static String mangleName(String name, int kind)
  {
    boolean reversible = kind >= 0;
    int len = name.length();
    if ((len == 6) && (name.equals("*init*")))
      return "<init>";
    StringBuffer mangled = new StringBuffer(len);
    boolean upcaseNext = false;
    for (int i = 0; i < len; i++)
    {
      char ch = name.charAt(i);
      if (upcaseNext)
      {
        ch = Character.toTitleCase(ch);
        upcaseNext = false;
      }
      if (Character.isDigit(ch))
      {
        if (i == 0)
          mangled.append("$N");
        mangled.append(ch);
      }
      else if ((Character.isLetter(ch)) || (ch == '_')) {
        mangled.append(ch);
      } else if (ch == '$') {
        mangled.append(kind > 1 ? "$$" : "$");
      }
      else {
        switch (ch) {
        case '+': 
          mangled.append("$Pl"); break;
        case '-': 
          if (reversible) {
            mangled.append("$Mn");
          }
          else {
            char next = i + 1 < len ? name.charAt(i + 1) : '\000';
            if (next == '>')
            {
              mangled.append("$To$");
              i++;
            }
            else if (!Character.isLetter(next)) {
              mangled.append("$Mn");
            } }
          break;
        case '*':  mangled.append("$St"); break;
        case '/':  mangled.append("$Sl"); break;
        case '=':  mangled.append("$Eq"); break;
        case '<':  mangled.append("$Ls"); break;
        case '>':  mangled.append("$Gr"); break;
        case '@':  mangled.append("$At"); break;
        case '~':  mangled.append("$Tl"); break;
        case '%':  mangled.append("$Pc"); break;
        case '.':  mangled.append("$Dt"); break;
        case ',':  mangled.append("$Cm"); break;
        case '(':  mangled.append("$LP"); break;
        case ')':  mangled.append("$RP"); break;
        case '[':  mangled.append("$LB"); break;
        case ']':  mangled.append("$RB"); break;
        case '{':  mangled.append("$LC"); break;
        case '}':  mangled.append("$RC"); break;
        case '\'':  mangled.append("$Sq"); break;
        case '"':  mangled.append("$Dq"); break;
        case '&':  mangled.append("$Am"); break;
        case '#':  mangled.append("$Nm"); break;
        case '?': 
          char first = mangled.length() > 0 ? mangled.charAt(0) : '\000';
          if ((!reversible) && (i + 1 == len) && (Character.isLowerCase(first)))
          {

            mangled.setCharAt(0, Character.toTitleCase(first));
            mangled.insert(0, "is");
          }
          else {
            mangled.append("$Qu"); }
          break;
        case '!':  mangled.append("$Ex"); break;
        case ':':  mangled.append("$Cl"); break;
        case ';':  mangled.append("$SC"); break;
        case '^':  mangled.append("$Up"); break;
        case '|':  mangled.append("$VB"); break;
        case '$': case '0': case '1': case '2': case '3': case '4': case '5': case '6': case '7': case '8': case '9': case 'A': case 'B': case 'C': case 'D': case 'E': case 'F': case 'G': case 'H': case 'I': case 'J': case 'K': case 'L': case 'M': case 'N': case 'O': case 'P': case 'Q': case 'R': case 'S': case 'T': case 'U': case 'V': case 'W': case 'X': case 'Y': case 'Z': case '\\': case '_': case '`': case 'a': case 'b': case 'c': case 'd': case 'e': case 'f': case 'g': case 'h': case 'i': case 'j': case 'k': case 'l': case 'm': case 'n': case 'o': case 'p': case 'q': case 'r': case 's': case 't': case 'u': case 'v': case 'w': case 'x': case 'y': case 'z': default: 
          mangled.append('$');
          mangled.append(Character.forDigit(ch >> '\f' & 0xF, 16));
          mangled.append(Character.forDigit(ch >> '\b' & 0xF, 16));
          mangled.append(Character.forDigit(ch >> '\004' & 0xF, 16));
          mangled.append(Character.forDigit(ch & 0xF, 16));
        }
        if (!reversible)
          upcaseNext = true;
      }
    }
    String mname = mangled.toString();
    return mname.equals(name) ? name : mname;
  }
  
  public String getCompilationClass()
  {
    return "gnu.expr.Compilation";
  }
  




  public final Compilation getCompilation(SourceMessages messages, NameLookup lexical)
  {
    try
    {
      if (compilationClassConstructor == null)
      {
        Class<Compilation> compilationClass = Class.forName(getCompilationClass(), true, getClass().getClassLoader());
        

        compilationClassConstructor = compilationClass.getConstructor(new Class[] { Language.class, SourceMessages.class, NameLookup.class });
      }
      
      return (Compilation)compilationClassConstructor.newInstance(new Object[] { this, messages, lexical });
    }
    catch (Exception ex)
    {
      throw WrappedException.wrapIfNeeded(ex);
    }
  }
  
  public final Compilation getCompilation(Lexer lexer, int options, ModuleInfo info) {
    SourceMessages messages = lexer.getMessages();
    NameLookup lexical = (options & 0x2) != 0 ? NameLookup.getInstance(getEnvironment(), this) : new NameLookup(this);
    

    boolean immediate = (options & 0x1) != 0;
    Compilation tr = getCompilation(messages, lexical);
    if (requirePedantic)
      tr.setPedantic(true);
    if (!immediate)
      mustCompile = true;
    immediate = immediate;
    langOptions = options;
    if ((options & 0x100) != 0)
      currentOptions.set("main", null);
    if ((options & 0x40) != 0)
      explicit = true;
    if ((options & 0x8) != 0)
      tr.setState(1);
    ModuleExp module = tr.pushNewModule(lexer);
    if ((options & 0x80) != 0) {
      tr.setInteractiveName();
      module.setFlag(4194304);
    }
    if (info != null)
      info.setCompilation(tr);
    return tr;
  }
  

































  public final Compilation parse(InPort port, SourceMessages messages, int options)
    throws IOException, SyntaxException
  {
    return parse(getLexer(port, messages), options, null);
  }
  


  public final Compilation parse(InPort port, SourceMessages messages, int options, ModuleInfo info)
    throws IOException, SyntaxException
  {
    return parse(getLexer(port, messages), options, info);
  }
  
  public final Compilation parse(Lexer lexer, int options, ModuleInfo info) throws IOException, SyntaxException
  {
    Compilation tr = getCompilation(lexer, options, info);
    return parse(tr) ? tr : null;
  }
  
  public final boolean parse(Compilation tr) throws IOException, SyntaxException
  {
    try {
      if (!parse(tr, langOptions))
        return false;
    } catch (SyntaxException ex) {
      tr.setState(100);
      return true;
    }
    if (tr.getState() == 1) {
      tr.setState(2);
    } else
      mainLambda.classFor(tr);
    return true;
  }
  











  public Type getTypeFor(Class clas)
  {
    return Type.make(clas);
  }
  
  public final Type getLangTypeFor(Type type) {
    if ((type instanceof ParameterizedType)) {
      ParameterizedType ptype = (ParameterizedType)type;
      Type[] pargs = ptype.getTypeArgumentTypes();
      if ((ptype.getRawType() == gnu.kawa.reflect.LazyType.lazyType) && (pargs.length == 1)) {
        return gnu.kawa.reflect.LazyType.getInstance(gnu.kawa.reflect.LazyType.lazyType, getLangTypeFor(pargs[0]));
      }
    }
    if ((type instanceof TypeVariable)) {
      return getLangTypeFor(((TypeVariable)type).getRawType());
    }
    if (type.isExisting()) {
      Class clas = type.getReflectClass();
      if (clas != null)
        return getTypeFor(clas);
    }
    return type;
  }
  
  public String formatType(Type type)
  {
    String s = type.getName();
    if (s == null)
      s = type.toString();
    return s;
  }
  
  public Type getTypeFor(String name) {
    Type t;
    if (name.endsWith("[]")) {
      Type t = getTypeFor(name.substring(0, name.length() - 2));
      if (t != null) {
        t = ArrayType.make(t);
      }
    } else {
      t = getNamedType(name);
    }
    if (t != null)
      return t;
    if (Type.isValidJavaTypeName(name)) {
      t = Type.getType(name);
    }
    return t;
  }
  
  public final Type getTypeFor(Object spec, boolean lenient)
  {
    if ((spec instanceof Type))
      return (Type)spec;
    if ((spec instanceof Class))
      return getTypeFor((Class)spec);
    if ((lenient) && (((spec instanceof gnu.lists.FString)) || ((spec instanceof String)) || (((spec instanceof Symbol)) && (((Symbol)spec).hasEmptyNamespace())) || ((spec instanceof gnu.lists.CharSeq))))
    {



      return getTypeFor(spec.toString()); }
    if ((spec instanceof Namespace))
    {
      String uri = ((Namespace)spec).getName();
      if ((uri != null) && (uri.startsWith("class:")))
        return getLangTypeFor(getTypeFor(uri.substring(6)));
    }
    return null;
  }
  





  public String encodeType(Type type)
  {
    if ((type instanceof TypeValue))
      return ((TypeValue)type).encodeType(this);
    if ((type instanceof ArrayType)) {
      String el = encodeType(((ArrayType)type).getComponentType());
      if (el != null)
        return el + "[]";
    }
    return null;
  }
  
  public Type decodeType(Type javaType, String annotType, ParameterizedType parameterizedType)
  {
    if ((annotType != null) && (annotType.length() > 0))
      return getTypeFor(annotType);
    return getLangTypeFor(resolveTypeVariables(javaType, parameterizedType));
  }
  
  static Type resolveTypeVariables(Type langType, ParameterizedType parameterizedType)
  {
    if ((langType instanceof TypeVariable))
      return resolveTypeVariable((TypeVariable)langType, parameterizedType);
    if ((langType instanceof ParameterizedType)) {
      ParameterizedType ptype = (ParameterizedType)langType;
      Type[] paramTypes = ptype.getTypeArgumentTypes();
      int nparams = paramTypes.length;
      Type[] resolvedTypes = new Type[nparams];
      boolean changed = false;
      for (int i = 0; i < nparams; i++) {
        Type t0 = paramTypes[i];
        char bound = ptype.getTypeArgumentBound(i);
        
        if (bound != 0)
          return langType.getRawType();
        Type t1 = resolveTypeVariables(t0, parameterizedType);
        resolvedTypes[i] = t1;
        if (t0 != t1)
          changed = true;
      }
      if (changed) {
        return new ParameterizedType(ptype.getRawType(), resolvedTypes);
      }
    }
    return langType;
  }
  
  static Type resolveTypeVariable(TypeVariable tvar, ParameterizedType parameterizedType) {
    if (parameterizedType != null) {
      TypeVariable[] tparams = parameterizedType.getRawType().getTypeParameters();
      int nparams = tparams.length;
      for (int i = 0; i < nparams; i++) {
        if (tvar.getName().equals(tparams[i].getName())) {
          return parameterizedType.getTypeArgumentType(i);
        }
      }
    }
    return tvar.getRawType();
  }
  

  public final Type asType(Object spec)
  {
    Type type = getTypeFor(spec, true);
    return type == null ? (Type)spec : type;
  }
  
  public final Type getTypeFor(Expression exp)
  {
    return getTypeFor(exp, true);
  }
  



  public Type getTypeFor(Expression exp, boolean lenient)
  {
    if ((exp instanceof QuoteExp))
    {
      Object value = ((QuoteExp)exp).getValue();
      if ((value instanceof Type))
        return (Type)value;
      if ((value instanceof Class))
        return Type.make((Class)value);
      return getTypeFor(value, lenient);
    }
    if ((exp instanceof ReferenceExp))
    {
      ReferenceExp rexp = (ReferenceExp)exp;
      Declaration decl = Declaration.followAliases(rexp.getBinding());
      String name = rexp.getName();
      if (decl != null)
      {
        exp = decl.getValue();
        if (((exp instanceof QuoteExp)) && (decl.getFlag(16384L)) && (!decl.isIndirectBinding()))
        {


          Object val = ((QuoteExp)exp).getValue();
          return getTypeFor(val, lenient);
        }
        if ((((exp instanceof ClassExp)) && (!(exp instanceof ObjectExp))) || ((exp instanceof ModuleExp)))
        {


          decl.setCanRead(true);
          return ((LambdaExp)exp).getClassType();
        }
        if ((decl.isAlias()) && ((exp instanceof QuoteExp)))
        {

          Object val = ((QuoteExp)exp).getValue();
          if ((val instanceof Location))
          {
            Location loc = (Location)val;
            if (loc.isBound())
              return getTypeFor(loc.get(), lenient);
            if (!(loc instanceof Named))
              return null;
            name = ((Named)loc).getName();
          }
        } else {
          if ((exp instanceof ApplyExp)) {
            ApplyExp aexp = (ApplyExp)exp;
            Expression afunc = aexp.getFunction();
            Object func = afunc.valueIfConstant();
            Expression[] args = aexp.getArgs();
            int start = 0;
            if ((decl.isAlias()) && (func == kawa.standard.location.getMakeProcLocProc()))
            {
              afunc = args[0];
              start = 1;
            }
            return getTypeFor(afunc, args, start);
          }
          if (!decl.getFlag(65536L))
            return getTypeFor(exp, lenient);
        } }
      Object val = getEnvironment().get(name);
      if ((val instanceof Type))
        return (Type)val;
      if ((val instanceof gnu.kawa.lispexpr.ClassNamespace))
        return ((gnu.kawa.lispexpr.ClassNamespace)val).getClassType();
      int len = name.length();
      if ((len > 2) && (name.charAt(0) == '<') && (name.charAt(len - 1) == '>'))
      {
        return getTypeFor(name.substring(1, len - 1)); }
    } else {
      if ((exp instanceof ApplyExp)) {
        ApplyExp aexp = (ApplyExp)exp;
        return getTypeFor(aexp.getFunction(), aexp.getArgs(), 0);
      }
      if ((((exp instanceof ClassExp)) && (!(exp instanceof ObjectExp))) || ((exp instanceof ModuleExp)))
      {

        return ((LambdaExp)exp).getClassType(); }
    }
    return null;
  }
  
  private Type getTypeFor(Expression afunc, Expression[] args, int start) {
    Object func = afunc.valueIfConstant();
    try {
      if ((func == gnu.kawa.reflect.SlotGet.staticField) && (args.length == 2 + start))
      {
        Object arg1 = args[(start + 0)].valueIfConstant();
        Object arg2 = args[(start + 1)].valueIfConstant();
        if ((arg1 != null) && (arg2 != null)) {
          Object fld = gnu.kawa.reflect.SlotGet.staticField.apply2(arg1, arg2);
          if ((fld instanceof Type))
            return (Type)fld;
        }
      }
      if ((func == gnu.kawa.functions.GetNamedPart.getNamedPart) && (args.length == 2 + start))
      {
        Object arg1 = args[(start + 0)].valueIfConstant();
        Object arg2 = args[(start + 1)].valueIfConstant();
        if ((arg2 instanceof Symbol)) {
          Object comb = gnu.kawa.functions.GetNamedPart.getNamedPart(arg1, (Symbol)arg2);
          if ((comb instanceof Class))
            return Type.make((Class)comb);
          if ((comb instanceof Type)) {
            return (Type)comb;
          }
        }
      }
    }
    catch (Exception ex) {}
    return null;
  }
  
  public static Type unionType(Type t1, Type t2)
  {
    if (t1 == Type.neverReturnsType)
      return t2;
    if (t2 == Type.neverReturnsType)
      return t1;
    if (t1 == Type.toStringType)
      t1 = Type.javalangStringType;
    if (t2 == Type.toStringType)
      t2 = Type.javalangStringType;
    if (t1 == t2)
      return t1;
    if ((t1.isVoid()) || (t2.isVoid()))
      return Type.objectType;
    if (t1.isSubtype(t2))
      return t2;
    if (t2.isSubtype(t1))
      return t1;
    return Type.objectType;
  }
  
  public Declaration declFromField(ModuleExp mod, Object fvalue, gnu.bytecode.Field fld) {
    String fname = fld.getName();
    Type ftype = fld.getType();
    boolean isAlias = ftype.isSubtype(Compilation.typeLocation);
    



    boolean externalAccess = fname.startsWith("$Prvt$");
    boolean isFinal = (fld.getModifiers() & 0x10) != 0;
    boolean isImportedInstance; Object fdname; Object fdname; if ((isImportedInstance = fname.endsWith("$instance"))) {
      fdname = fname; } else { Object fdname;
      if ((isFinal) && (ftype == Compilation.typeModuleMethod) && ((fvalue instanceof Named)))
      {
        fdname = ((Named)fvalue).getSymbol();
      }
      else {
        if (externalAccess)
          fname = fname.substring("$Prvt$".length());
        fdname = Mangling.demangleName(fname, true).intern();
      }
    }
    try { SourceName sourceName = (SourceName)fld.getAnnotation(SourceName.class);
      if (sourceName != null) {
        fdname = Symbol.valueOf(sourceName.name(), sourceName.uri(), sourceName.prefix());
      }
    }
    catch (Exception ex) {}
    if ((fdname instanceof String)) {
      String uri = mod.getNamespaceUri();
      String sname = (String)fdname;
      
      if (uri == null) {
        fdname = gnu.mapping.SimpleSymbol.valueOf(sname);
      } else
        fdname = Symbol.make(uri, sname); }
    Type dtype;
    Type dtype;
    if (isAlias) {
      dtype = Type.objectType;
    } else {
      String annotType = null;
      try {
        SourceType sourceType = (SourceType)fld.getAnnotation(SourceType.class);
        if (sourceType != null) {
          annotType = sourceType.value();
        }
      } catch (Throwable ex) {}
      dtype = decodeType(ftype, annotType, null);
    }
    Declaration fdecl = mod.addDeclaration(fdname, dtype);
    boolean isStatic = (fld.getModifiers() & 0x8) != 0;
    if (isAlias) {
      fdecl.setIndirectBinding(true);
      Type frtype = ftype.getRawType();
      if ((frtype instanceof ClassType)) {
        ClassType cftype = (ClassType)frtype;
        if ((cftype.isSubclass("gnu.mapping.DynamicLocation")) || (cftype.isSubclass("gnu.mapping.ThreadLocation")))
        {
          fdecl.setFlag(268435456L);
        }
      }
    } else if ((isFinal) && ((ftype instanceof ClassType))) {
      if (ftype.isSubtype(Compilation.typeProcedure)) {
        fdecl.setProcedureDecl(true);
      } else if (((ClassType)ftype).isSubclass("gnu.mapping.Namespace"))
        fdecl.setFlag(2097152L);
    }
    if (isStatic)
      fdecl.setFlag(2048L);
    field = fld;
    if ((isFinal) && (!isAlias))
      fdecl.setFlag(16384L);
    if (isImportedInstance)
      fdecl.setFlag(1073741824L);
    fdecl.setSimple(false);
    if (externalAccess)
      fdecl.setFlag(524320L);
    return fdecl;
  }
  












  public int getNamespaceOf(Declaration decl)
  {
    return 1;
  }
  


  public boolean hasNamespace(Declaration decl, int namespace)
  {
    return (getNamespaceOf(decl) & namespace) != 0;
  }
  
  public Object coerceFromObject(Class clas, Object obj)
  {
    return getTypeFor(clas).coerceFromObject(obj);
  }
  
  public Object coerceToObject(Class clas, Object obj)
  {
    return getTypeFor(clas).coerceToObject(obj);
  }
  
  public static synchronized void setDefaults(Language lang)
  {
    setCurrentLanguage(lang);
    global = lang;
    


    if (Environment.getGlobal() == BuiltinEnvironment.getInstance())
      Environment.setGlobal(Environment.getCurrent());
  }
  
  public String getPrimaryPrompt() { return "> "; }
  public String getSecondaryPrompt() { return "- "; }
  
  public final Object eval(String string)
    throws Throwable
  {
    return eval(new CharArrayInPort(string));
  }
  


  public final Object eval(Reader in)
    throws Throwable
  {
    return eval((in instanceof InPort) ? (InPort)in : new InPort(in));
  }
  
  public final Object eval(InPort port)
    throws Throwable
  {
    CallContext ctx = CallContext.getInstance();
    int oldIndex = ctx.startFromContext();
    try
    {
      eval(port, ctx);
      return ctx.getFromContext(oldIndex);
    }
    catch (Throwable ex)
    {
      ctx.cleanupFromContext(oldIndex);
      throw ex;
    }
  }
  
  public final void eval(String string, Writer out)
    throws Throwable
  {
    eval(new CharArrayInPort(string), out);
  }
  


  public final void eval(String string, gnu.lists.PrintConsumer out)
    throws Throwable
  {
    eval(string, getOutputConsumer(out));
  }
  
  public final void eval(String string, Consumer out)
    throws Throwable
  {
    eval(new CharArrayInPort(string), out);
  }
  
  public final void eval(Reader in, Writer out)
    throws Throwable
  {
    eval(in, getOutputConsumer(out));
  }
  
  public void eval(Reader in, Consumer out)
    throws Throwable
  {
    InPort port = (in instanceof InPort) ? (InPort)in : new InPort(in);
    CallContext ctx = CallContext.getInstance();
    Consumer save = consumer;
    try
    {
      consumer = out;
      eval(port, ctx);
    }
    finally
    {
      consumer = save;
    }
  }
  
  public void eval(InPort port, CallContext ctx) throws Throwable
  {
    SourceMessages messages = new SourceMessages();
    Language saveLang = setSaveCurrent(this);
    try
    {
      Compilation comp = getCompilation(getLexer(port, messages), 3, null);
      comp.setEvalName();
      parse(comp);
      ModuleExp.evalModule(getEnvironment(), ctx, comp, null, null);
    }
    finally
    {
      restoreCurrent(saveLang);
    }
    if (messages.seenErrors()) {
      throw new RuntimeException("invalid syntax in eval form:\n" + messages.toString(20));
    }
  }
  
  public void runAsApplication(String[] args)
  {
    setDefaults(this);
    kawa.repl.main(args);
  }
  
  public abstract Lexer getLexer(InPort paramInPort, SourceMessages paramSourceMessages);
  
  public abstract boolean parse(Compilation paramCompilation, int paramInt)
    throws IOException, SyntaxException;
  
  public void resolve(Compilation comp) {}
}
