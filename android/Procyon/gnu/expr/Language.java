// 
// Decompiled by Procyon v0.5.36
// 

package gnu.expr;

import kawa.repl;
import java.net.URL;
import gnu.lists.PrintConsumer;
import gnu.mapping.CallContext;
import java.io.Reader;
import gnu.kawa.io.CharArrayInPort;
import gnu.bytecode.ClassType;
import kawa.SourceType;
import gnu.kawa.functions.GetNamedPart;
import gnu.kawa.reflect.SlotGet;
import gnu.kawa.lispexpr.ClassNamespace;
import kawa.standard.location;
import gnu.mapping.Location;
import gnu.mapping.Namespace;
import gnu.lists.CharSeq;
import gnu.lists.FString;
import gnu.bytecode.ArrayType;
import gnu.bytecode.TypeVariable;
import gnu.kawa.reflect.LazyType;
import gnu.bytecode.ParameterizedType;
import gnu.text.SyntaxException;
import gnu.text.Lexer;
import gnu.text.SourceMessages;
import java.util.Collections;
import java.util.ArrayList;
import gnu.kawa.io.OutPort;
import gnu.lists.Consumer;
import java.io.Writer;
import gnu.kawa.format.AbstractFormat;
import gnu.kawa.reflect.ClassMemberLocation;
import java.lang.reflect.Field;
import gnu.mapping.Named;
import gnu.mapping.EnvironmentKey;
import gnu.kawa.reflect.StaticFieldLocation;
import gnu.bytecode.Type;
import gnu.mapping.NamedLocation;
import gnu.mapping.Symbol;
import java.lang.reflect.Method;
import gnu.mapping.WrappedException;
import java.lang.reflect.InvocationTargetException;
import gnu.mapping.Values;
import gnu.lists.Convert;
import gnu.kawa.io.InPort;
import java.io.IOException;
import java.io.InputStream;
import gnu.kawa.io.CheckConsole;
import java.lang.reflect.Constructor;
import java.util.List;
import gnu.mapping.Environment;

public abstract class Language
{
    protected static final InheritableThreadLocal<Language> current;
    protected static Language global;
    static String[][] languages;
    protected Environment environ;
    protected Environment userEnv;
    static int envCounter;
    private List<String> extensions;
    private Constructor<Compilation> compilationClassConstructor;
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
    
    public static Language getDefaultLanguage() {
        final Language lang = Language.current.get();
        return (lang != null) ? lang : Language.global;
    }
    
    public static void setCurrentLanguage(final Language language) {
        Language.current.set(language);
        if (CheckConsole.prompt1.get(null) == null) {
            CheckConsole.prompt1.set(language.getPrimaryPrompt());
        }
        if (CheckConsole.prompt2.get(null) == null) {
            CheckConsole.prompt2.set(language.getSecondaryPrompt());
        }
    }
    
    public static Language setSaveCurrent(final Language language) {
        final Language save = Language.current.get();
        Language.current.set(language);
        return save;
    }
    
    public static void restoreCurrent(final Language saved) {
        Language.current.set(saved);
    }
    
    public static String[][] getLanguages() {
        return Language.languages;
    }
    
    public static void registerLanguage(final String[] langMapping) {
        final String[][] newLangs = new String[Language.languages.length + 1][];
        System.arraycopy(Language.languages, 0, newLangs, 0, Language.languages.length);
        newLangs[newLangs.length - 1] = langMapping;
        Language.languages = newLangs;
    }
    
    public static Language detect(final InputStream in) throws IOException {
        if (!in.markSupported()) {
            return null;
        }
        final StringBuffer sbuf = new StringBuffer();
        in.mark(200);
        while (true) {
            while (sbuf.length() < 200) {
                final int c = in.read();
                if (c >= 0 && c != 10) {
                    if (c != 13) {
                        sbuf.append((char)c);
                        continue;
                    }
                }
                in.reset();
                return detect(sbuf.toString());
            }
            continue;
        }
    }
    
    public static Language detect(final InPort port) throws IOException {
        final StringBuffer sbuf = new StringBuffer();
        port.mark(300);
        port.readLine(sbuf, 'P');
        port.reset();
        return detect(sbuf.toString());
    }
    
    public static Language detect(final String line) {
        final String str = line.trim();
        final int k = str.indexOf("kawa:");
        if (k >= 0) {
            int j;
            int i;
            for (i = (j = k + 5); j < str.length() && Character.isJavaIdentifierPart(str.charAt(j)); ++j) {}
            if (j > i) {
                final String w = str.substring(i, j);
                final Language lang = getInstance(w);
                if (lang != null) {
                    return lang;
                }
            }
        }
        if (str.indexOf("-*- scheme -*-") >= 0) {
            return getInstance("scheme");
        }
        if (str.indexOf("-*- xquery -*-") >= 0) {
            return getInstance("xquery");
        }
        if (str.indexOf("-*- emacs-lisp -*-") >= 0) {
            return getInstance("elisp");
        }
        if (str.indexOf("-*- common-lisp -*-") >= 0 || str.indexOf("-*- lisp -*-") >= 0) {
            return getInstance("common-lisp");
        }
        if (str.startsWith("(:") || str.startsWith("xquery")) {
            return getInstance("xquery");
        }
        if (str.startsWith(";;")) {
            return getInstance("scheme");
        }
        return null;
    }
    
    public static Language getInstanceFromFilenameExtension(final String filename) {
        final int dot = filename.lastIndexOf(46);
        if (dot > 0) {
            final Language lang = getInstance(filename.substring(dot));
            if (lang != null) {
                return lang;
            }
        }
        return null;
    }
    
    public static Language getInstance(final String name) {
        for (int langCount = Language.languages.length, i = 0; i < langCount; ++i) {
            final String[] names = Language.languages[i];
            int j;
            final int nameCount = j = names.length - 1;
            while (--j >= 0) {
                if (name != null) {
                    if (!names[j].equalsIgnoreCase(name)) {
                        continue;
                    }
                }
                Class langClass;
                try {
                    langClass = Class.forName(names[nameCount]);
                }
                catch (ClassNotFoundException ex) {
                    break;
                }
                return getInstance(names[0], langClass);
            }
        }
        return null;
    }
    
    protected Language() {
        Convert.setInstance(KawaConvert.getInstance());
    }
    
    public static Language getInstance(String langName, final Class langClass) {
        try {
            final Class[] args = new Class[0];
            Method method;
            try {
                final String capitalizedName = Character.toTitleCase(langName.charAt(0)) + langName.substring(1).toLowerCase();
                final String methodName = "get" + capitalizedName + "Instance";
                method = langClass.getDeclaredMethod(methodName, (Class[])args);
            }
            catch (Exception ex2) {
                method = langClass.getDeclaredMethod("getInstance", (Class[])args);
            }
            return (Language)method.invoke(null, Values.noArgs);
        }
        catch (Exception ex) {
            langName = langClass.getName();
            Throwable th;
            if (ex instanceof InvocationTargetException) {
                th = ((InvocationTargetException)ex).getTargetException();
            }
            else {
                th = ex;
            }
            throw new WrappedException("getInstance for '" + langName + "' failed", th);
        }
    }
    
    public boolean isTrue(final Object value) {
        return value != null && (!(value instanceof Boolean) || (boolean)value);
    }
    
    public int booleanValue(final Object value) {
        try {
            return this.isTrue(value) ? 1 : 0;
        }
        catch (Exception ex) {
            return -1;
        }
    }
    
    public Object booleanObject(final boolean b) {
        return b ? Boolean.TRUE : Boolean.FALSE;
    }
    
    public Object noValue() {
        return Values.empty;
    }
    
    public boolean hasSeparateFunctionNamespace() {
        return false;
    }
    
    public final Environment getEnvironment() {
        return (this.userEnv != null) ? this.userEnv : Environment.getCurrent();
    }
    
    public final Environment getNewEnvironment() {
        return Environment.make("environment-" + ++Language.envCounter, this.environ);
    }
    
    public Environment getLangEnvironment() {
        return this.environ;
    }
    
    public NamedLocation lookupBuiltin(final Symbol name, final Object property, final int hash) {
        return (this.environ == null) ? null : this.environ.lookup(name, property, hash);
    }
    
    public void define(final String sym, final Object p) {
        final Symbol s = this.getSymbol(sym);
        this.environ.define(s, null, p);
    }
    
    public Type getNamedType(final String name) {
        return null;
    }
    
    protected void defAliasStFld(final String name, final String cname, final String fname) {
        StaticFieldLocation.define(this.environ, this.getSymbol(name), null, cname, fname);
    }
    
    protected void defProcStFld(final String name, final String cname, final String fname) {
        this.defProcStFld(this.getSymbol(name), cname, fname);
    }
    
    protected void defProcStFld(final Symbol sym, final String cname, final String fname) {
        final Object property = this.hasSeparateFunctionNamespace() ? EnvironmentKey.FUNCTION : null;
        final StaticFieldLocation loc = StaticFieldLocation.define(this.environ, sym, property, cname, fname);
        loc.setProcedure();
    }
    
    protected void defProcStFld(final String name, final String cname) {
        this.defProcStFld(name, cname, mangleNameIfNeeded(name));
    }
    
    protected void defProcStFldAs(final String asName, final String cname, final String mname) {
        this.defProcStFld(asName, cname, mangleNameIfNeeded(mname));
    }
    
    public final void defineFunction(final Named proc) {
        final Object name = proc.getSymbol();
        final Symbol sym = (Symbol)((name instanceof Symbol) ? name : this.getSymbol(name.toString()));
        final Object property = this.hasSeparateFunctionNamespace() ? EnvironmentKey.FUNCTION : null;
        this.environ.define(sym, property, proc);
    }
    
    public void defineFunction(final String name, final Object proc) {
        final Object property = this.hasSeparateFunctionNamespace() ? EnvironmentKey.FUNCTION : null;
        this.environ.define(this.getSymbol(name), property, proc);
    }
    
    public Object getEnvPropertyFor(final Field fld, final Object value) {
        if (!this.hasSeparateFunctionNamespace()) {
            return null;
        }
        if (Compilation.typeProcedure.getReflectClass().isAssignableFrom(fld.getType())) {
            return EnvironmentKey.FUNCTION;
        }
        return null;
    }
    
    public Object getEnvPropertyFor(final Declaration decl) {
        if (this.hasSeparateFunctionNamespace() && decl.isProcedureDecl()) {
            return EnvironmentKey.FUNCTION;
        }
        return null;
    }
    
    public void loadClass(final String name) throws ClassNotFoundException {
        Class clas;
        try {
            clas = Class.forName(name);
        }
        catch (ClassNotFoundException ex) {
            throw ex;
        }
        try {
            final Object inst = clas.newInstance();
            ClassMemberLocation.defineAll(inst, this, Environment.getCurrent());
            if (inst instanceof ModuleBody) {
                ((ModuleBody)inst).run();
            }
        }
        catch (Exception ex2) {
            throw new WrappedException("cannot load " + name, ex2);
        }
    }
    
    public Symbol getSymbol(final String name) {
        return this.environ.getSymbol(name);
    }
    
    public Object lookup(final String name) {
        return this.environ.get(name);
    }
    
    public AbstractFormat getFormat(final boolean readable) {
        return null;
    }
    
    public Consumer getOutputConsumer(final Writer out) {
        final OutPort oport = (OutPort)((out instanceof OutPort) ? out : new OutPort(out));
        return this.getFormat(false).makeConsumer(oport);
    }
    
    public String getName() {
        String name = this.getClass().getName();
        final int dot = name.lastIndexOf(46);
        if (dot >= 0) {
            name = name.substring(dot + 1);
        }
        return name;
    }
    
    public List<String> getExtensions() {
        if (this.extensions == null) {
            final ArrayList<String> exts = new ArrayList<String>(1);
            final String thisClassName = this.getClass().getName();
            final String[][] langs = getLanguages();
            for (int i = 0; i < langs.length; ++i) {
                final String[] lang = langs[i];
                if (lang != null) {
                    final int n = lang.length - 1;
                    final String langClass = lang[n];
                    if (thisClassName.equals(langClass)) {
                        for (int j = 1; j < n; ++j) {
                            String ext = lang[j];
                            if (ext != null && ext.charAt(0) == '.') {
                                ext = ext.substring(1);
                                if (!exts.contains(ext)) {
                                    exts.add(ext);
                                }
                            }
                        }
                    }
                }
            }
            this.extensions = Collections.unmodifiableList((List<? extends String>)exts);
        }
        return this.extensions;
    }
    
    public static String mangleNameIfNeeded(final String name) {
        if (name == null || isValidJavaName(name)) {
            return name;
        }
        return mangleName(name, 0);
    }
    
    public static boolean isValidJavaName(final String name) {
        final int len = name.length();
        if (len == 0 || !Character.isJavaIdentifierStart(name.charAt(0))) {
            return false;
        }
        int i = len;
        while (--i > 0) {
            if (!Character.isJavaIdentifierPart(name.charAt(i))) {
                return false;
            }
        }
        return true;
    }
    
    public static String mangleName(final String name, final int kind) {
        final boolean reversible = kind >= 0;
        final int len = name.length();
        if (len == 6 && name.equals("*init*")) {
            return "<init>";
        }
        final StringBuffer mangled = new StringBuffer(len);
        boolean upcaseNext = false;
        for (int i = 0; i < len; ++i) {
            char ch = name.charAt(i);
            if (upcaseNext) {
                ch = Character.toTitleCase(ch);
                upcaseNext = false;
            }
            if (Character.isDigit(ch)) {
                if (i == 0) {
                    mangled.append("$N");
                }
                mangled.append(ch);
            }
            else if (Character.isLetter(ch) || ch == '_') {
                mangled.append(ch);
            }
            else if (ch == '$') {
                mangled.append((kind > 1) ? "$$" : "$");
            }
            else {
                switch (ch) {
                    case '+': {
                        mangled.append("$Pl");
                        break;
                    }
                    case '-': {
                        if (reversible) {
                            mangled.append("$Mn");
                            break;
                        }
                        final char next = (i + 1 < len) ? name.charAt(i + 1) : '\0';
                        if (next == '>') {
                            mangled.append("$To$");
                            ++i;
                        }
                        else if (!Character.isLetter(next)) {
                            mangled.append("$Mn");
                        }
                        break;
                    }
                    case '*': {
                        mangled.append("$St");
                        break;
                    }
                    case '/': {
                        mangled.append("$Sl");
                        break;
                    }
                    case '=': {
                        mangled.append("$Eq");
                        break;
                    }
                    case '<': {
                        mangled.append("$Ls");
                        break;
                    }
                    case '>': {
                        mangled.append("$Gr");
                        break;
                    }
                    case '@': {
                        mangled.append("$At");
                        break;
                    }
                    case '~': {
                        mangled.append("$Tl");
                        break;
                    }
                    case '%': {
                        mangled.append("$Pc");
                        break;
                    }
                    case '.': {
                        mangled.append("$Dt");
                        break;
                    }
                    case ',': {
                        mangled.append("$Cm");
                        break;
                    }
                    case '(': {
                        mangled.append("$LP");
                        break;
                    }
                    case ')': {
                        mangled.append("$RP");
                        break;
                    }
                    case '[': {
                        mangled.append("$LB");
                        break;
                    }
                    case ']': {
                        mangled.append("$RB");
                        break;
                    }
                    case '{': {
                        mangled.append("$LC");
                        break;
                    }
                    case '}': {
                        mangled.append("$RC");
                        break;
                    }
                    case '\'': {
                        mangled.append("$Sq");
                        break;
                    }
                    case '\"': {
                        mangled.append("$Dq");
                        break;
                    }
                    case '&': {
                        mangled.append("$Am");
                        break;
                    }
                    case '#': {
                        mangled.append("$Nm");
                        break;
                    }
                    case '?': {
                        final char first = (mangled.length() > 0) ? mangled.charAt(0) : '\0';
                        if (!reversible && i + 1 == len && Character.isLowerCase(first)) {
                            mangled.setCharAt(0, Character.toTitleCase(first));
                            mangled.insert(0, "is");
                            break;
                        }
                        mangled.append("$Qu");
                        break;
                    }
                    case '!': {
                        mangled.append("$Ex");
                        break;
                    }
                    case ':': {
                        mangled.append("$Cl");
                        break;
                    }
                    case ';': {
                        mangled.append("$SC");
                        break;
                    }
                    case '^': {
                        mangled.append("$Up");
                        break;
                    }
                    case '|': {
                        mangled.append("$VB");
                        break;
                    }
                    default: {
                        mangled.append('$');
                        mangled.append(Character.forDigit(ch >> 12 & 0xF, 16));
                        mangled.append(Character.forDigit(ch >> 8 & 0xF, 16));
                        mangled.append(Character.forDigit(ch >> 4 & 0xF, 16));
                        mangled.append(Character.forDigit(ch & '\u000f', 16));
                        break;
                    }
                }
                if (!reversible) {
                    upcaseNext = true;
                }
            }
        }
        final String mname = mangled.toString();
        return mname.equals(name) ? name : mname;
    }
    
    public abstract Lexer getLexer(final InPort p0, final SourceMessages p1);
    
    public String getCompilationClass() {
        return "gnu.expr.Compilation";
    }
    
    public final Compilation getCompilation(final SourceMessages messages, final NameLookup lexical) {
        try {
            if (this.compilationClassConstructor == null) {
                final Class<Compilation> compilationClass = (Class<Compilation>)Class.forName(this.getCompilationClass(), true, this.getClass().getClassLoader());
                this.compilationClassConstructor = compilationClass.getConstructor(Language.class, SourceMessages.class, NameLookup.class);
            }
            return this.compilationClassConstructor.newInstance(this, messages, lexical);
        }
        catch (Exception ex) {
            throw WrappedException.wrapIfNeeded(ex);
        }
    }
    
    public final Compilation getCompilation(final Lexer lexer, final int options, final ModuleInfo info) {
        final SourceMessages messages = lexer.getMessages();
        final NameLookup lexical = ((options & 0x2) != 0x0) ? NameLookup.getInstance(this.getEnvironment(), this) : new NameLookup(this);
        final boolean immediate = (options & 0x1) != 0x0;
        final Compilation tr = this.getCompilation(messages, lexical);
        if (Language.requirePedantic) {
            tr.setPedantic(true);
        }
        if (!immediate) {
            tr.mustCompile = true;
        }
        tr.immediate = immediate;
        tr.langOptions = options;
        if ((options & 0x100) != 0x0) {
            tr.currentOptions.set("main", null);
        }
        if ((options & 0x40) != 0x0) {
            tr.explicit = true;
        }
        if ((options & 0x8) != 0x0) {
            tr.setState(1);
        }
        final ModuleExp module = tr.pushNewModule(lexer);
        if ((options & 0x80) != 0x0) {
            tr.setInteractiveName();
            module.setFlag(4194304);
        }
        if (info != null) {
            info.setCompilation(tr);
        }
        return tr;
    }
    
    public final Compilation parse(final InPort port, final SourceMessages messages, final int options) throws IOException, SyntaxException {
        return this.parse(this.getLexer(port, messages), options, null);
    }
    
    public final Compilation parse(final InPort port, final SourceMessages messages, final int options, final ModuleInfo info) throws IOException, SyntaxException {
        return this.parse(this.getLexer(port, messages), options, info);
    }
    
    public final Compilation parse(final Lexer lexer, final int options, final ModuleInfo info) throws IOException, SyntaxException {
        final Compilation tr = this.getCompilation(lexer, options, info);
        return this.parse(tr) ? tr : null;
    }
    
    public final boolean parse(final Compilation tr) throws IOException, SyntaxException {
        try {
            if (!this.parse(tr, tr.langOptions)) {
                return false;
            }
        }
        catch (SyntaxException ex) {
            tr.setState(100);
            return true;
        }
        if (tr.getState() == 1) {
            tr.setState(2);
        }
        else {
            tr.mainLambda.classFor(tr);
        }
        return true;
    }
    
    public abstract boolean parse(final Compilation p0, final int p1) throws IOException, SyntaxException;
    
    public void resolve(final Compilation comp) {
    }
    
    public Type getTypeFor(final Class clas) {
        return Type.make(clas);
    }
    
    public final Type getLangTypeFor(final Type type) {
        if (type instanceof ParameterizedType) {
            final ParameterizedType ptype = (ParameterizedType)type;
            final Type[] pargs = ptype.getTypeArgumentTypes();
            if (ptype.getRawType() == LazyType.lazyType && pargs.length == 1) {
                return LazyType.getInstance(LazyType.lazyType, this.getLangTypeFor(pargs[0]));
            }
        }
        if (type instanceof TypeVariable) {
            return this.getLangTypeFor(((TypeVariable)type).getRawType());
        }
        if (type.isExisting()) {
            final Class clas = type.getReflectClass();
            if (clas != null) {
                return this.getTypeFor(clas);
            }
        }
        return type;
    }
    
    public String formatType(final Type type) {
        String s = type.getName();
        if (s == null) {
            s = type.toString();
        }
        return s;
    }
    
    public Type getTypeFor(final String name) {
        Type t;
        if (name.endsWith("[]")) {
            t = this.getTypeFor(name.substring(0, name.length() - 2));
            if (t != null) {
                t = ArrayType.make(t);
            }
        }
        else {
            t = this.getNamedType(name);
        }
        if (t != null) {
            return t;
        }
        if (Type.isValidJavaTypeName(name)) {
            t = Type.getType(name);
        }
        return t;
    }
    
    public final Type getTypeFor(final Object spec, final boolean lenient) {
        if (spec instanceof Type) {
            return (Type)spec;
        }
        if (spec instanceof Class) {
            return this.getTypeFor((Class)spec);
        }
        if (lenient && (spec instanceof FString || spec instanceof String || (spec instanceof Symbol && ((Symbol)spec).hasEmptyNamespace()) || spec instanceof CharSeq)) {
            return this.getTypeFor(spec.toString());
        }
        if (spec instanceof Namespace) {
            final String uri = ((Namespace)spec).getName();
            if (uri != null && uri.startsWith("class:")) {
                return this.getLangTypeFor(this.getTypeFor(uri.substring(6)));
            }
        }
        return null;
    }
    
    public String encodeType(final Type type) {
        if (type instanceof TypeValue) {
            return ((TypeValue)type).encodeType(this);
        }
        if (type instanceof ArrayType) {
            final String el = this.encodeType(((ArrayType)type).getComponentType());
            if (el != null) {
                return el + "[]";
            }
        }
        return null;
    }
    
    public Type decodeType(final Type javaType, final String annotType, final ParameterizedType parameterizedType) {
        if (annotType != null && annotType.length() > 0) {
            return this.getTypeFor(annotType);
        }
        return this.getLangTypeFor(resolveTypeVariables(javaType, parameterizedType));
    }
    
    static Type resolveTypeVariables(final Type langType, final ParameterizedType parameterizedType) {
        if (langType instanceof TypeVariable) {
            return resolveTypeVariable((TypeVariable)langType, parameterizedType);
        }
        if (langType instanceof ParameterizedType) {
            final ParameterizedType ptype = (ParameterizedType)langType;
            final Type[] paramTypes = ptype.getTypeArgumentTypes();
            final int nparams = paramTypes.length;
            final Type[] resolvedTypes = new Type[nparams];
            boolean changed = false;
            for (int i = 0; i < nparams; ++i) {
                final Type t0 = paramTypes[i];
                final char bound = ptype.getTypeArgumentBound(i);
                if (bound != '\0') {
                    return langType.getRawType();
                }
                final Type t2 = resolveTypeVariables(t0, parameterizedType);
                if (t0 != (resolvedTypes[i] = t2)) {
                    changed = true;
                }
            }
            if (changed) {
                return new ParameterizedType(ptype.getRawType(), resolvedTypes);
            }
        }
        return langType;
    }
    
    static Type resolveTypeVariable(final TypeVariable tvar, final ParameterizedType parameterizedType) {
        if (parameterizedType != null) {
            final TypeVariable[] tparams = parameterizedType.getRawType().getTypeParameters();
            for (int nparams = tparams.length, i = 0; i < nparams; ++i) {
                if (tvar.getName().equals(tparams[i].getName())) {
                    return parameterizedType.getTypeArgumentType(i);
                }
            }
        }
        return tvar.getRawType();
    }
    
    public final Type asType(final Object spec) {
        final Type type = this.getTypeFor(spec, true);
        return (Type)((type == null) ? spec : type);
    }
    
    public final Type getTypeFor(final Expression exp) {
        return this.getTypeFor(exp, true);
    }
    
    public Type getTypeFor(Expression exp, final boolean lenient) {
        if (!(exp instanceof QuoteExp)) {
            if (exp instanceof ReferenceExp) {
                final ReferenceExp rexp = (ReferenceExp)exp;
                final Declaration decl = Declaration.followAliases(rexp.getBinding());
                String name = rexp.getName();
                if (decl != null) {
                    exp = decl.getValue();
                    if (exp instanceof QuoteExp && decl.getFlag(16384L) && !decl.isIndirectBinding()) {
                        final Object val = ((QuoteExp)exp).getValue();
                        return this.getTypeFor(val, lenient);
                    }
                    if ((exp instanceof ClassExp && !(exp instanceof ObjectExp)) || exp instanceof ModuleExp) {
                        decl.setCanRead(true);
                        return ((LambdaExp)exp).getClassType();
                    }
                    if (decl.isAlias() && exp instanceof QuoteExp) {
                        final Object val = ((QuoteExp)exp).getValue();
                        if (val instanceof Location) {
                            final Location loc = (Location)val;
                            if (loc.isBound()) {
                                return this.getTypeFor(loc.get(), lenient);
                            }
                            if (!(loc instanceof Named)) {
                                return null;
                            }
                            name = ((Named)loc).getName();
                        }
                    }
                    else {
                        if (exp instanceof ApplyExp) {
                            final ApplyExp aexp = (ApplyExp)exp;
                            Expression afunc = aexp.getFunction();
                            final Object func = afunc.valueIfConstant();
                            final Expression[] args = aexp.getArgs();
                            int start = 0;
                            if (decl.isAlias() && func == location.getMakeProcLocProc()) {
                                afunc = args[0];
                                start = 1;
                            }
                            return this.getTypeFor(afunc, args, start);
                        }
                        if (!decl.getFlag(65536L)) {
                            return this.getTypeFor(exp, lenient);
                        }
                    }
                }
                final Object val = this.getEnvironment().get(name);
                if (val instanceof Type) {
                    return (Type)val;
                }
                if (val instanceof ClassNamespace) {
                    return ((ClassNamespace)val).getClassType();
                }
                final int len = name.length();
                if (len > 2 && name.charAt(0) == '<' && name.charAt(len - 1) == '>') {
                    return this.getTypeFor(name.substring(1, len - 1));
                }
            }
            else {
                if (exp instanceof ApplyExp) {
                    final ApplyExp aexp2 = (ApplyExp)exp;
                    return this.getTypeFor(aexp2.getFunction(), aexp2.getArgs(), 0);
                }
                if ((exp instanceof ClassExp && !(exp instanceof ObjectExp)) || exp instanceof ModuleExp) {
                    return ((LambdaExp)exp).getClassType();
                }
            }
            return null;
        }
        final Object value = ((QuoteExp)exp).getValue();
        if (value instanceof Type) {
            return (Type)value;
        }
        if (value instanceof Class) {
            return Type.make((Class)value);
        }
        return this.getTypeFor(value, lenient);
    }
    
    private Type getTypeFor(final Expression afunc, final Expression[] args, final int start) {
        final Object func = afunc.valueIfConstant();
        try {
            if (func == SlotGet.staticField && args.length == 2 + start) {
                final Object arg1 = args[start + 0].valueIfConstant();
                final Object arg2 = args[start + 1].valueIfConstant();
                if (arg1 != null && arg2 != null) {
                    final Object fld = SlotGet.staticField.apply2(arg1, arg2);
                    if (fld instanceof Type) {
                        return (Type)fld;
                    }
                }
            }
            if (func == GetNamedPart.getNamedPart && args.length == 2 + start) {
                final Object arg1 = args[start + 0].valueIfConstant();
                final Object arg2 = args[start + 1].valueIfConstant();
                if (arg2 instanceof Symbol) {
                    final Object comb = GetNamedPart.getNamedPart(arg1, (Symbol)arg2);
                    if (comb instanceof Class) {
                        return Type.make((Class)comb);
                    }
                    if (comb instanceof Type) {
                        return (Type)comb;
                    }
                }
            }
        }
        catch (Exception ex) {}
        return null;
    }
    
    public static Type unionType(Type t1, Type t2) {
        if (t1 == Type.neverReturnsType) {
            return t2;
        }
        if (t2 == Type.neverReturnsType) {
            return t1;
        }
        if (t1 == Type.toStringType) {
            t1 = Type.javalangStringType;
        }
        if (t2 == Type.toStringType) {
            t2 = Type.javalangStringType;
        }
        if (t1 == t2) {
            return t1;
        }
        if (t1.isVoid() || t2.isVoid()) {
            return Type.objectType;
        }
        if (t1.isSubtype(t2)) {
            return t2;
        }
        if (t2.isSubtype(t1)) {
            return t1;
        }
        return Type.objectType;
    }
    
    public Declaration declFromField(final ModuleExp mod, final Object fvalue, final gnu.bytecode.Field fld) {
        String fname = fld.getName();
        final Type ftype = fld.getType();
        final boolean isAlias = ftype.isSubtype(Compilation.typeLocation);
        final boolean externalAccess = fname.startsWith("$Prvt$");
        final boolean isFinal = (fld.getModifiers() & 0x10) != 0x0;
        final boolean isImportedInstance;
        Object fdname;
        if (isImportedInstance = fname.endsWith("$instance")) {
            fdname = fname;
        }
        else if (isFinal && ftype == Compilation.typeModuleMethod && fvalue instanceof Named) {
            fdname = ((Named)fvalue).getSymbol();
        }
        else {
            if (externalAccess) {
                fname = fname.substring("$Prvt$".length());
            }
            fdname = Mangling.demangleName(fname, true).intern();
        }
        try {
            final SourceName sourceName = fld.getAnnotation(SourceName.class);
            if (sourceName != null) {
                fdname = Symbol.valueOf(sourceName.name(), sourceName.uri(), sourceName.prefix());
            }
        }
        catch (Exception ex) {}
        if (fdname instanceof String) {
            final String uri = mod.getNamespaceUri();
            final String sname = (String)fdname;
            if (uri == null) {
                fdname = Symbol.valueOf(sname);
            }
            else {
                fdname = Symbol.make(uri, sname);
            }
        }
        Type dtype;
        if (isAlias) {
            dtype = Type.objectType;
        }
        else {
            String annotType = null;
            try {
                final SourceType sourceType = fld.getAnnotation(SourceType.class);
                if (sourceType != null) {
                    annotType = sourceType.value();
                }
            }
            catch (Throwable t) {}
            dtype = this.decodeType(ftype, annotType, null);
        }
        final Declaration fdecl = mod.addDeclaration(fdname, dtype);
        final boolean isStatic = (fld.getModifiers() & 0x8) != 0x0;
        if (isAlias) {
            fdecl.setIndirectBinding(true);
            final Type frtype = ftype.getRawType();
            if (frtype instanceof ClassType) {
                final ClassType cftype = (ClassType)frtype;
                if (cftype.isSubclass("gnu.mapping.DynamicLocation") || cftype.isSubclass("gnu.mapping.ThreadLocation")) {
                    fdecl.setFlag(268435456L);
                }
            }
        }
        else if (isFinal && ftype instanceof ClassType) {
            if (ftype.isSubtype(Compilation.typeProcedure)) {
                fdecl.setProcedureDecl(true);
            }
            else if (((ClassType)ftype).isSubclass("gnu.mapping.Namespace")) {
                fdecl.setFlag(2097152L);
            }
        }
        if (isStatic) {
            fdecl.setFlag(2048L);
        }
        fdecl.field = fld;
        if (isFinal && !isAlias) {
            fdecl.setFlag(16384L);
        }
        if (isImportedInstance) {
            fdecl.setFlag(1073741824L);
        }
        fdecl.setSimple(false);
        if (externalAccess) {
            fdecl.setFlag(524320L);
        }
        return fdecl;
    }
    
    public int getNamespaceOf(final Declaration decl) {
        return 1;
    }
    
    public boolean hasNamespace(final Declaration decl, final int namespace) {
        return (this.getNamespaceOf(decl) & namespace) != 0x0;
    }
    
    public Object coerceFromObject(final Class clas, final Object obj) {
        return this.getTypeFor(clas).coerceFromObject(obj);
    }
    
    public Object coerceToObject(final Class clas, final Object obj) {
        return this.getTypeFor(clas).coerceToObject(obj);
    }
    
    public static synchronized void setDefaults(final Language lang) {
        setCurrentLanguage(lang);
        Language.global = lang;
        if (Environment.getGlobal() == BuiltinEnvironment.getInstance()) {
            Environment.setGlobal(Environment.getCurrent());
        }
    }
    
    public String getPrimaryPrompt() {
        return "> ";
    }
    
    public String getSecondaryPrompt() {
        return "- ";
    }
    
    public final Object eval(final String string) throws Throwable {
        return this.eval(new CharArrayInPort(string));
    }
    
    public final Object eval(final Reader in) throws Throwable {
        return this.eval((in instanceof InPort) ? ((InPort)in) : new InPort(in));
    }
    
    public final Object eval(final InPort port) throws Throwable {
        final CallContext ctx = CallContext.getInstance();
        final int oldIndex = ctx.startFromContext();
        try {
            this.eval(port, ctx);
            return ctx.getFromContext(oldIndex);
        }
        catch (Throwable ex) {
            ctx.cleanupFromContext(oldIndex);
            throw ex;
        }
    }
    
    public final void eval(final String string, final Writer out) throws Throwable {
        this.eval(new CharArrayInPort(string), out);
    }
    
    public final void eval(final String string, final PrintConsumer out) throws Throwable {
        this.eval(string, this.getOutputConsumer(out));
    }
    
    public final void eval(final String string, final Consumer out) throws Throwable {
        this.eval(new CharArrayInPort(string), out);
    }
    
    public final void eval(final Reader in, final Writer out) throws Throwable {
        this.eval(in, this.getOutputConsumer(out));
    }
    
    public void eval(final Reader in, final Consumer out) throws Throwable {
        final InPort port = (InPort)((in instanceof InPort) ? in : new InPort(in));
        final CallContext ctx = CallContext.getInstance();
        final Consumer save = ctx.consumer;
        try {
            ctx.consumer = out;
            this.eval(port, ctx);
        }
        finally {
            ctx.consumer = save;
        }
    }
    
    public void eval(final InPort port, final CallContext ctx) throws Throwable {
        final SourceMessages messages = new SourceMessages();
        final Language saveLang = setSaveCurrent(this);
        try {
            final Compilation comp = this.getCompilation(this.getLexer(port, messages), 3, null);
            comp.setEvalName();
            this.parse(comp);
            ModuleExp.evalModule(this.getEnvironment(), ctx, comp, null, null);
        }
        finally {
            restoreCurrent(saveLang);
        }
        if (messages.seenErrors()) {
            throw new RuntimeException("invalid syntax in eval form:\n" + messages.toString(20));
        }
    }
    
    public void runAsApplication(final String[] args) {
        setDefaults(this);
        repl.main(args);
    }
    
    static {
        current = new InheritableThreadLocal<Language>();
        Environment.setGlobal(BuiltinEnvironment.getInstance());
        Language.languages = new String[][] { { "scheme", ".scm", ".sc", ".sld", "kawa.standard.Scheme" }, { "r5rs", ".scm", "kawa.standard.Scheme" }, { "r6rs", ".scm", "kawa.standard.Scheme" }, { "r7rs", ".scm", "kawa.standard.Scheme" }, { "krl", ".krl", "gnu.kawa.brl.BRL" }, { "brl", ".brl", "gnu.kawa.brl.BRL" }, { "emacs", "elisp", "emacs-lisp", ".el", "gnu.jemacs.lang.ELisp" }, { "xquery", ".xquery", ".xq", ".xql", "gnu.xquery.lang.XQuery" }, { "kashell", ".ksl", "gnu.q2.lang.Q2" }, { "q2", ".q2", "gnu.q2.lang.Q2" }, { "xslt", "xsl", ".xsl", "gnu.kawa.xslt.XSLT" }, { "commonlisp", "common-lisp", "clisp", "lisp", ".lisp", ".lsp", ".cl", "gnu.commonlisp.lang.CommonLisp" } };
    }
}
