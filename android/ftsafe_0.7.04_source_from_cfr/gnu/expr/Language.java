/*
 * Decompiled with CFR 0.139.
 */
package gnu.expr;

import gnu.bytecode.ArrayType;
import gnu.bytecode.ClassType;
import gnu.bytecode.ObjectType;
import gnu.bytecode.ParameterizedType;
import gnu.bytecode.Type;
import gnu.bytecode.TypeVariable;
import gnu.expr.ApplyExp;
import gnu.expr.BuiltinEnvironment;
import gnu.expr.ClassExp;
import gnu.expr.Compilation;
import gnu.expr.Declaration;
import gnu.expr.Expression;
import gnu.expr.KawaConvert;
import gnu.expr.LambdaExp;
import gnu.expr.Mangling;
import gnu.expr.ModuleBody;
import gnu.expr.ModuleExp;
import gnu.expr.ModuleInfo;
import gnu.expr.NameLookup;
import gnu.expr.ObjectExp;
import gnu.expr.QuoteExp;
import gnu.expr.ReferenceExp;
import gnu.expr.SourceName;
import gnu.expr.TypeValue;
import gnu.kawa.format.AbstractFormat;
import gnu.kawa.functions.GetNamedPart;
import gnu.kawa.io.CharArrayInPort;
import gnu.kawa.io.CheckConsole;
import gnu.kawa.io.InPort;
import gnu.kawa.io.OutPort;
import gnu.kawa.lispexpr.ClassNamespace;
import gnu.kawa.reflect.ClassMemberLocation;
import gnu.kawa.reflect.LazyType;
import gnu.kawa.reflect.SlotGet;
import gnu.kawa.reflect.StaticFieldLocation;
import gnu.lists.CharSeq;
import gnu.lists.Consumer;
import gnu.lists.Convert;
import gnu.lists.FString;
import gnu.lists.PrintConsumer;
import gnu.mapping.CallContext;
import gnu.mapping.Environment;
import gnu.mapping.EnvironmentKey;
import gnu.mapping.Location;
import gnu.mapping.Named;
import gnu.mapping.NamedLocation;
import gnu.mapping.Namespace;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Symbol;
import gnu.mapping.ThreadLocation;
import gnu.mapping.Values;
import gnu.mapping.WrappedException;
import gnu.text.Lexer;
import gnu.text.Options;
import gnu.text.SourceMessages;
import gnu.text.SyntaxException;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.Writer;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kawa.SourceType;
import kawa.repl;
import kawa.standard.location;

public abstract class Language {
    protected static final InheritableThreadLocal<Language> current = new InheritableThreadLocal<T>();
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
        Language lang = (Language)current.get();
        return lang != null ? lang : global;
    }

    public static void setCurrentLanguage(Language language) {
        current.set(language);
        if (CheckConsole.prompt1.get(null) == null) {
            CheckConsole.prompt1.set(language.getPrimaryPrompt());
        }
        if (CheckConsole.prompt2.get(null) == null) {
            CheckConsole.prompt2.set(language.getSecondaryPrompt());
        }
    }

    public static Language setSaveCurrent(Language language) {
        Language save = (Language)current.get();
        current.set(language);
        return save;
    }

    public static void restoreCurrent(Language saved) {
        current.set(saved);
    }

    public static String[][] getLanguages() {
        return languages;
    }

    public static void registerLanguage(String[] langMapping) {
        String[][] newLangs = new String[languages.length + 1][];
        System.arraycopy(languages, 0, newLangs, 0, languages.length);
        newLangs[newLangs.length - 1] = langMapping;
        languages = newLangs;
    }

    public static Language detect(InputStream in) throws IOException {
        int c;
        if (!in.markSupported()) {
            return null;
        }
        StringBuffer sbuf = new StringBuffer();
        in.mark(200);
        while (sbuf.length() < 200 && (c = in.read()) >= 0 && c != 10 && c != 13) {
            sbuf.append((char)c);
        }
        in.reset();
        return Language.detect(sbuf.toString());
    }

    public static Language detect(InPort port) throws IOException {
        StringBuffer sbuf = new StringBuffer();
        port.mark(300);
        port.readLine(sbuf, 'P');
        port.reset();
        return Language.detect(sbuf.toString());
    }

    public static Language detect(String line) {
        String str = line.trim();
        int k = str.indexOf("kawa:");
        if (k >= 0) {
            Language lang;
            int j;
            String w;
            int i;
            for (j = i = k + 5; j < str.length() && Character.isJavaIdentifierPart(str.charAt(j)); ++j) {
            }
            if (j > i && (lang = Language.getInstance(w = str.substring(i, j))) != null) {
                return lang;
            }
        }
        if (str.indexOf("-*- scheme -*-") >= 0) {
            return Language.getInstance("scheme");
        }
        if (str.indexOf("-*- xquery -*-") >= 0) {
            return Language.getInstance("xquery");
        }
        if (str.indexOf("-*- emacs-lisp -*-") >= 0) {
            return Language.getInstance("elisp");
        }
        if (str.indexOf("-*- common-lisp -*-") >= 0 || str.indexOf("-*- lisp -*-") >= 0) {
            return Language.getInstance("common-lisp");
        }
        if (str.startsWith("(:") || str.startsWith("xquery")) {
            return Language.getInstance("xquery");
        }
        if (str.startsWith(";;")) {
            return Language.getInstance("scheme");
        }
        return null;
    }

    public static Language getInstanceFromFilenameExtension(String filename) {
        Language lang;
        int dot = filename.lastIndexOf(46);
        if (dot > 0 && (lang = Language.getInstance(filename.substring(dot))) != null) {
            return lang;
        }
        return null;
    }

    public static Language getInstance(String name) {
        block2 : for (String[] names : languages) {
            int nameCount;
            int j = nameCount = names.length - 1;
            while (--j >= 0) {
                Class<?> langClass;
                if (name != null && !names[j].equalsIgnoreCase(name)) continue;
                try {
                    langClass = Class.forName(names[nameCount]);
                }
                catch (ClassNotFoundException ex) {
                    continue block2;
                }
                return Language.getInstance(names[0], langClass);
            }
        }
        return null;
    }

    protected Language() {
        Convert.setInstance(KawaConvert.getInstance());
    }

    public static Language getInstance(String langName, Class langClass) {
        try {
            Method method;
            Class[] args = new Class[]{};
            try {
                String capitalizedName = Character.toTitleCase(langName.charAt(0)) + langName.substring(1).toLowerCase();
                String methodName = "get" + capitalizedName + "Instance";
                method = langClass.getDeclaredMethod(methodName, args);
            }
            catch (Exception ex) {
                method = langClass.getDeclaredMethod("getInstance", args);
            }
            return (Language)method.invoke(null, Values.noArgs);
        }
        catch (Exception ex) {
            langName = langClass.getName();
            Throwable th = ex instanceof InvocationTargetException ? ((InvocationTargetException)ex).getTargetException() : ex;
            throw new WrappedException("getInstance for '" + langName + "' failed", th);
        }
    }

    public boolean isTrue(Object value) {
        return value != null && (!(value instanceof Boolean) || (Boolean)value != false);
    }

    public int booleanValue(Object value) {
        try {
            return this.isTrue(value) ? 1 : 0;
        }
        catch (Exception ex) {
            return -1;
        }
    }

    public Object booleanObject(boolean b) {
        return b ? Boolean.TRUE : Boolean.FALSE;
    }

    public Object noValue() {
        return Values.empty;
    }

    public boolean hasSeparateFunctionNamespace() {
        return false;
    }

    public final Environment getEnvironment() {
        return this.userEnv != null ? this.userEnv : Environment.getCurrent();
    }

    public final Environment getNewEnvironment() {
        return Environment.make("environment-" + ++envCounter, this.environ);
    }

    public Environment getLangEnvironment() {
        return this.environ;
    }

    public NamedLocation lookupBuiltin(Symbol name, Object property, int hash) {
        return this.environ == null ? null : this.environ.lookup(name, property, hash);
    }

    public void define(String sym, Object p) {
        Symbol s = this.getSymbol(sym);
        this.environ.define(s, null, p);
    }

    public Type getNamedType(String name) {
        return null;
    }

    protected void defAliasStFld(String name, String cname, String fname) {
        StaticFieldLocation.define(this.environ, this.getSymbol(name), null, cname, fname);
    }

    protected void defProcStFld(String name, String cname, String fname) {
        this.defProcStFld(this.getSymbol(name), cname, fname);
    }

    protected void defProcStFld(Symbol sym, String cname, String fname) {
        Object property = this.hasSeparateFunctionNamespace() ? EnvironmentKey.FUNCTION : null;
        StaticFieldLocation loc = StaticFieldLocation.define(this.environ, sym, property, cname, fname);
        loc.setProcedure();
    }

    protected void defProcStFld(String name, String cname) {
        this.defProcStFld(name, cname, Language.mangleNameIfNeeded(name));
    }

    protected void defProcStFldAs(String asName, String cname, String mname) {
        this.defProcStFld(asName, cname, Language.mangleNameIfNeeded(mname));
    }

    public final void defineFunction(Named proc) {
        Object name = proc.getSymbol();
        Symbol sym = name instanceof Symbol ? (Symbol)name : this.getSymbol(name.toString());
        Object property = this.hasSeparateFunctionNamespace() ? EnvironmentKey.FUNCTION : null;
        this.environ.define(sym, property, proc);
    }

    public void defineFunction(String name, Object proc) {
        Object property = this.hasSeparateFunctionNamespace() ? EnvironmentKey.FUNCTION : null;
        this.environ.define(this.getSymbol(name), property, proc);
    }

    public Object getEnvPropertyFor(Field fld, Object value) {
        if (!this.hasSeparateFunctionNamespace()) {
            return null;
        }
        if (Compilation.typeProcedure.getReflectClass().isAssignableFrom(fld.getType())) {
            return EnvironmentKey.FUNCTION;
        }
        return null;
    }

    public Object getEnvPropertyFor(Declaration decl) {
        if (this.hasSeparateFunctionNamespace() && decl.isProcedureDecl()) {
            return EnvironmentKey.FUNCTION;
        }
        return null;
    }

    public void loadClass(String name) throws ClassNotFoundException {
        Class<?> clas = Class.forName(name);
        try {
            Object inst = clas.newInstance();
            ClassMemberLocation.defineAll(inst, this, Environment.getCurrent());
            if (inst instanceof ModuleBody) {
                ((ModuleBody)inst).run();
            }
        }
        catch (Exception ex) {
            throw new WrappedException("cannot load " + name, ex);
        }
    }

    public Symbol getSymbol(String name) {
        return this.environ.getSymbol(name);
    }

    public Object lookup(String name) {
        return this.environ.get(name);
    }

    public AbstractFormat getFormat(boolean readable) {
        return null;
    }

    public Consumer getOutputConsumer(Writer out) {
        OutPort oport = out instanceof OutPort ? (OutPort)out : new OutPort(out);
        return this.getFormat(false).makeConsumer(oport);
    }

    public String getName() {
        String name = this.getClass().getName();
        int dot = name.lastIndexOf(46);
        if (dot >= 0) {
            name = name.substring(dot + 1);
        }
        return name;
    }

    public List<String> getExtensions() {
        if (this.extensions == null) {
            ArrayList<String> exts = new ArrayList<String>(1);
            String thisClassName = this.getClass().getName();
            String[][] langs = Language.getLanguages();
            for (int i = 0; i < langs.length; ++i) {
                int n;
                String langClass;
                String[] lang = langs[i];
                if (lang == null || !thisClassName.equals(langClass = lang[n = lang.length - 1])) continue;
                for (int j = 1; j < n; ++j) {
                    String ext = lang[j];
                    if (ext == null || ext.charAt(0) != '.' || exts.contains(ext = ext.substring(1))) continue;
                    exts.add(ext);
                }
            }
            this.extensions = Collections.unmodifiableList(exts);
        }
        return this.extensions;
    }

    public static String mangleNameIfNeeded(String name) {
        if (name == null || Language.isValidJavaName(name)) {
            return name;
        }
        return Language.mangleName(name, 0);
    }

    public static boolean isValidJavaName(String name) {
        int len = name.length();
        if (len == 0 || !Character.isJavaIdentifierStart(name.charAt(0))) {
            return false;
        }
        int i = len;
        while (--i > 0) {
            if (Character.isJavaIdentifierPart(name.charAt(i))) continue;
            return false;
        }
        return true;
    }

    public static String mangleName(String name, int kind) {
        boolean reversible = kind >= 0;
        int len = name.length();
        if (len == 6 && name.equals("*init*")) {
            return "<init>";
        }
        StringBuffer mangled = new StringBuffer(len);
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
                continue;
            }
            if (Character.isLetter(ch) || ch == '_') {
                mangled.append(ch);
                continue;
            }
            if (ch == '$') {
                mangled.append(kind > 1 ? "$$" : "$");
                continue;
            }
            switch (ch) {
                case '+': {
                    mangled.append("$Pl");
                    break;
                }
                case '-': {
                    char next;
                    if (reversible) {
                        mangled.append("$Mn");
                        break;
                    }
                    char c = next = i + 1 < len ? name.charAt(i + 1) : (char)'\u0000';
                    if (next == '>') {
                        mangled.append("$To$");
                        ++i;
                        break;
                    }
                    if (Character.isLetter(next)) break;
                    mangled.append("$Mn");
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
                    char first;
                    char c = first = mangled.length() > 0 ? mangled.charAt(0) : (char)'\u0000';
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
                    mangled.append(Character.forDigit(ch >> 12 & 15, 16));
                    mangled.append(Character.forDigit(ch >> 8 & 15, 16));
                    mangled.append(Character.forDigit(ch >> 4 & 15, 16));
                    mangled.append(Character.forDigit(ch & 15, 16));
                }
            }
            if (reversible) continue;
            upcaseNext = true;
        }
        String mname = mangled.toString();
        return mname.equals(name) ? name : mname;
    }

    public abstract Lexer getLexer(InPort var1, SourceMessages var2);

    public String getCompilationClass() {
        return "gnu.expr.Compilation";
    }

    public final Compilation getCompilation(SourceMessages messages, NameLookup lexical) {
        try {
            if (this.compilationClassConstructor == null) {
                Class<?> compilationClass = Class.forName(this.getCompilationClass(), true, this.getClass().getClassLoader());
                this.compilationClassConstructor = compilationClass.getConstructor(Language.class, SourceMessages.class, NameLookup.class);
            }
            return this.compilationClassConstructor.newInstance(this, messages, lexical);
        }
        catch (Exception ex) {
            throw WrappedException.wrapIfNeeded(ex);
        }
    }

    public final Compilation getCompilation(Lexer lexer, int options, ModuleInfo info) {
        SourceMessages messages = lexer.getMessages();
        NameLookup lexical = (options & 2) != 0 ? NameLookup.getInstance(this.getEnvironment(), this) : new NameLookup(this);
        boolean immediate = (options & 1) != 0;
        Compilation tr = this.getCompilation(messages, lexical);
        if (requirePedantic) {
            tr.setPedantic(true);
        }
        if (!immediate) {
            tr.mustCompile = true;
        }
        tr.immediate = immediate;
        tr.langOptions = options;
        if ((options & 256) != 0) {
            tr.currentOptions.set("main", null);
        }
        if ((options & 64) != 0) {
            tr.explicit = true;
        }
        if ((options & 8) != 0) {
            tr.setState(1);
        }
        ModuleExp module = tr.pushNewModule(lexer);
        if ((options & 128) != 0) {
            tr.setInteractiveName();
            module.setFlag(4194304);
        }
        if (info != null) {
            info.setCompilation(tr);
        }
        return tr;
    }

    public final Compilation parse(InPort port, SourceMessages messages, int options) throws IOException, SyntaxException {
        return this.parse(this.getLexer(port, messages), options, null);
    }

    public final Compilation parse(InPort port, SourceMessages messages, int options, ModuleInfo info) throws IOException, SyntaxException {
        return this.parse(this.getLexer(port, messages), options, info);
    }

    public final Compilation parse(Lexer lexer, int options, ModuleInfo info) throws IOException, SyntaxException {
        Compilation tr = this.getCompilation(lexer, options, info);
        return this.parse(tr) ? tr : null;
    }

    public final boolean parse(Compilation tr) throws IOException, SyntaxException {
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
        } else {
            tr.mainLambda.classFor(tr);
        }
        return true;
    }

    public abstract boolean parse(Compilation var1, int var2) throws IOException, SyntaxException;

    public void resolve(Compilation comp) {
    }

    public Type getTypeFor(Class clas) {
        return Type.make(clas);
    }

    public final Type getLangTypeFor(Type type) {
        Class clas;
        if (type instanceof ParameterizedType) {
            ParameterizedType ptype = (ParameterizedType)type;
            Type[] pargs = ptype.getTypeArgumentTypes();
            if (ptype.getRawType() == LazyType.lazyType && pargs.length == 1) {
                return LazyType.getInstance(LazyType.lazyType, this.getLangTypeFor(pargs[0]));
            }
        }
        if (type instanceof TypeVariable) {
            return this.getLangTypeFor(((TypeVariable)type).getRawType());
        }
        if (type.isExisting() && (clas = type.getReflectClass()) != null) {
            return this.getTypeFor(clas);
        }
        return type;
    }

    public String formatType(Type type) {
        String s = type.getName();
        if (s == null) {
            s = type.toString();
        }
        return s;
    }

    public Type getTypeFor(String name) {
        Type t;
        if (name.endsWith("[]")) {
            t = this.getTypeFor(name.substring(0, name.length() - 2));
            if (t != null) {
                t = ArrayType.make(t);
            }
        } else {
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

    public final Type getTypeFor(Object spec, boolean lenient) {
        String uri;
        if (spec instanceof Type) {
            return (Type)spec;
        }
        if (spec instanceof Class) {
            return this.getTypeFor((Class)spec);
        }
        if (lenient && (spec instanceof FString || spec instanceof String || spec instanceof Symbol && ((Symbol)spec).hasEmptyNamespace() || spec instanceof CharSeq)) {
            return this.getTypeFor(spec.toString());
        }
        if (spec instanceof Namespace && (uri = ((Namespace)spec).getName()) != null && uri.startsWith("class:")) {
            return this.getLangTypeFor(this.getTypeFor(uri.substring(6)));
        }
        return null;
    }

    public String encodeType(Type type) {
        String el;
        if (type instanceof TypeValue) {
            return ((TypeValue)((Object)type)).encodeType(this);
        }
        if (type instanceof ArrayType && (el = this.encodeType(((ArrayType)type).getComponentType())) != null) {
            return el + "[]";
        }
        return null;
    }

    public Type decodeType(Type javaType, String annotType, ParameterizedType parameterizedType) {
        if (annotType != null && annotType.length() > 0) {
            return this.getTypeFor(annotType);
        }
        return this.getLangTypeFor(Language.resolveTypeVariables(javaType, parameterizedType));
    }

    static Type resolveTypeVariables(Type langType, ParameterizedType parameterizedType) {
        if (langType instanceof TypeVariable) {
            return Language.resolveTypeVariable((TypeVariable)langType, parameterizedType);
        }
        if (langType instanceof ParameterizedType) {
            ParameterizedType ptype = (ParameterizedType)langType;
            Type[] paramTypes = ptype.getTypeArgumentTypes();
            int nparams = paramTypes.length;
            Type[] resolvedTypes = new Type[nparams];
            boolean changed = false;
            for (int i = 0; i < nparams; ++i) {
                Type t1;
                Type t0 = paramTypes[i];
                char bound = ptype.getTypeArgumentBound(i);
                if (bound != '\u0000') {
                    return langType.getRawType();
                }
                resolvedTypes[i] = t1 = Language.resolveTypeVariables(t0, parameterizedType);
                if (t0 == t1) continue;
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
            for (int i = 0; i < nparams; ++i) {
                if (!tvar.getName().equals(tparams[i].getName())) continue;
                return parameterizedType.getTypeArgumentType(i);
            }
        }
        return tvar.getRawType();
    }

    public final Type asType(Object spec) {
        Type type = this.getTypeFor(spec, true);
        return type == null ? (Type)spec : type;
    }

    public final Type getTypeFor(Expression exp) {
        return this.getTypeFor(exp, true);
    }

    public Type getTypeFor(Expression exp, boolean lenient) {
        if (exp instanceof QuoteExp) {
            Object value = ((QuoteExp)exp).getValue();
            if (value instanceof Type) {
                return (Type)value;
            }
            if (value instanceof Class) {
                return Type.make((Class)value);
            }
            return this.getTypeFor(value, lenient);
        }
        if (exp instanceof ReferenceExp) {
            Object val;
            ReferenceExp rexp = (ReferenceExp)exp;
            Declaration decl = Declaration.followAliases(rexp.getBinding());
            String name = rexp.getName();
            if (decl != null) {
                exp = decl.getValue();
                if (exp instanceof QuoteExp && decl.getFlag(16384L) && !decl.isIndirectBinding()) {
                    Object val2 = ((QuoteExp)exp).getValue();
                    return this.getTypeFor(val2, lenient);
                }
                if (exp instanceof ClassExp && !(exp instanceof ObjectExp) || exp instanceof ModuleExp) {
                    decl.setCanRead(true);
                    return ((LambdaExp)exp).getClassType();
                }
                if (decl.isAlias() && exp instanceof QuoteExp) {
                    val = ((QuoteExp)exp).getValue();
                    if (val instanceof Location) {
                        Location loc = (Location)val;
                        if (loc.isBound()) {
                            return this.getTypeFor(loc.get(), lenient);
                        }
                        if (!(loc instanceof Named)) {
                            return null;
                        }
                        name = ((Named)((Object)loc)).getName();
                    }
                } else {
                    if (exp instanceof ApplyExp) {
                        ApplyExp aexp = (ApplyExp)exp;
                        Expression afunc = aexp.getFunction();
                        Object func = afunc.valueIfConstant();
                        Expression[] args = aexp.getArgs();
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
            if ((val = this.getEnvironment().get(name)) instanceof Type) {
                return (Type)val;
            }
            if (val instanceof ClassNamespace) {
                return ((ClassNamespace)val).getClassType();
            }
            int len = name.length();
            if (len > 2 && name.charAt(0) == '<' && name.charAt(len - 1) == '>') {
                return this.getTypeFor(name.substring(1, len - 1));
            }
        } else {
            if (exp instanceof ApplyExp) {
                ApplyExp aexp = (ApplyExp)exp;
                return this.getTypeFor(aexp.getFunction(), aexp.getArgs(), 0);
            }
            if (exp instanceof ClassExp && !(exp instanceof ObjectExp) || exp instanceof ModuleExp) {
                return ((LambdaExp)exp).getClassType();
            }
        }
        return null;
    }

    private Type getTypeFor(Expression afunc, Expression[] args, int start) {
        Object func = afunc.valueIfConstant();
        try {
            Object arg2;
            Object arg1;
            if (func == SlotGet.staticField && args.length == 2 + start) {
                Object fld;
                arg1 = args[start + 0].valueIfConstant();
                arg2 = args[start + 1].valueIfConstant();
                if (arg1 != null && arg2 != null && (fld = SlotGet.staticField.apply2(arg1, arg2)) instanceof Type) {
                    return (Type)fld;
                }
            }
            if (func == GetNamedPart.getNamedPart && args.length == 2 + start) {
                arg1 = args[start + 0].valueIfConstant();
                arg2 = args[start + 1].valueIfConstant();
                if (arg2 instanceof Symbol) {
                    Object comb = GetNamedPart.getNamedPart(arg1, (Symbol)arg2);
                    if (comb instanceof Class) {
                        return Type.make((Class)comb);
                    }
                    if (comb instanceof Type) {
                        return (Type)comb;
                    }
                }
            }
        }
        catch (Exception ex) {
            // empty catch block
        }
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

    public Declaration declFromField(ModuleExp mod, Object fvalue, gnu.bytecode.Field fld) {
        boolean isStatic;
        Type dtype;
        Object fdname;
        String fname = fld.getName();
        Type ftype = fld.getType();
        boolean isAlias = ftype.isSubtype(Compilation.typeLocation);
        boolean externalAccess = fname.startsWith("$Prvt$");
        boolean isFinal = (fld.getModifiers() & 16) != 0;
        boolean isImportedInstance = fname.endsWith("$instance");
        if (isImportedInstance) {
            fdname = fname;
        } else if (isFinal && ftype == Compilation.typeModuleMethod && fvalue instanceof Named) {
            fdname = ((Named)fvalue).getSymbol();
        } else {
            if (externalAccess) {
                fname = fname.substring("$Prvt$".length());
            }
            fdname = Mangling.demangleName(fname, true).intern();
        }
        try {
            SourceName sourceName = fld.getAnnotation(SourceName.class);
            if (sourceName != null) {
                fdname = Symbol.valueOf(sourceName.name(), sourceName.uri(), sourceName.prefix());
            }
        }
        catch (Exception ex) {
            // empty catch block
        }
        if (fdname instanceof String) {
            String uri = mod.getNamespaceUri();
            String sname = (String)fdname;
            fdname = uri == null ? SimpleSymbol.valueOf(sname) : Symbol.make(uri, sname);
        }
        if (isAlias) {
            dtype = Type.objectType;
        } else {
            String annotType = null;
            try {
                SourceType sourceType = fld.getAnnotation(SourceType.class);
                if (sourceType != null) {
                    annotType = sourceType.value();
                }
            }
            catch (Throwable ex) {
                // empty catch block
            }
            dtype = this.decodeType(ftype, annotType, null);
        }
        Declaration fdecl = mod.addDeclaration(fdname, dtype);
        boolean bl = isStatic = (fld.getModifiers() & 8) != 0;
        if (isAlias) {
            ClassType cftype;
            fdecl.setIndirectBinding(true);
            Type frtype = ftype.getRawType();
            if (frtype instanceof ClassType && ((cftype = (ClassType)frtype).isSubclass("gnu.mapping.DynamicLocation") || cftype.isSubclass("gnu.mapping.ThreadLocation"))) {
                fdecl.setFlag(0x10000000L);
            }
        } else if (isFinal && ftype instanceof ClassType) {
            if (ftype.isSubtype(Compilation.typeProcedure)) {
                fdecl.setProcedureDecl(true);
            } else if (((ClassType)ftype).isSubclass("gnu.mapping.Namespace")) {
                fdecl.setFlag(0x200000L);
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
            fdecl.setFlag(0x40000000L);
        }
        fdecl.setSimple(false);
        if (externalAccess) {
            fdecl.setFlag(524320L);
        }
        return fdecl;
    }

    public int getNamespaceOf(Declaration decl) {
        return 1;
    }

    public boolean hasNamespace(Declaration decl, int namespace) {
        return (this.getNamespaceOf(decl) & namespace) != 0;
    }

    public Object coerceFromObject(Class clas, Object obj) {
        return this.getTypeFor(clas).coerceFromObject(obj);
    }

    public Object coerceToObject(Class clas, Object obj) {
        return this.getTypeFor(clas).coerceToObject(obj);
    }

    public static synchronized void setDefaults(Language lang) {
        Language.setCurrentLanguage(lang);
        global = lang;
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

    public final Object eval(String string) throws Throwable {
        return this.eval(new CharArrayInPort(string));
    }

    public final Object eval(Reader in) throws Throwable {
        return this.eval(in instanceof InPort ? (InPort)in : new InPort(in));
    }

    public final Object eval(InPort port) throws Throwable {
        CallContext ctx = CallContext.getInstance();
        int oldIndex = ctx.startFromContext();
        try {
            this.eval(port, ctx);
            return ctx.getFromContext(oldIndex);
        }
        catch (Throwable ex) {
            ctx.cleanupFromContext(oldIndex);
            throw ex;
        }
    }

    public final void eval(String string, Writer out) throws Throwable {
        this.eval((Reader)new CharArrayInPort(string), out);
    }

    public final void eval(String string, PrintConsumer out) throws Throwable {
        this.eval(string, this.getOutputConsumer(out));
    }

    public final void eval(String string, Consumer out) throws Throwable {
        this.eval((Reader)new CharArrayInPort(string), out);
    }

    public final void eval(Reader in, Writer out) throws Throwable {
        this.eval(in, this.getOutputConsumer(out));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void eval(Reader in, Consumer out) throws Throwable {
        InPort port = in instanceof InPort ? (InPort)in : new InPort(in);
        CallContext ctx = CallContext.getInstance();
        Consumer save = ctx.consumer;
        try {
            ctx.consumer = out;
            this.eval(port, ctx);
        }
        finally {
            ctx.consumer = save;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void eval(InPort port, CallContext ctx) throws Throwable {
        SourceMessages messages;
        messages = new SourceMessages();
        Language saveLang = Language.setSaveCurrent(this);
        try {
            Compilation comp = this.getCompilation(this.getLexer(port, messages), 3, null);
            comp.setEvalName();
            this.parse(comp);
            ModuleExp.evalModule(this.getEnvironment(), ctx, comp, null, null);
        }
        finally {
            Language.restoreCurrent(saveLang);
        }
        if (messages.seenErrors()) {
            throw new RuntimeException("invalid syntax in eval form:\n" + messages.toString(20));
        }
    }

    public void runAsApplication(String[] args) {
        Language.setDefaults(this);
        repl.main(args);
    }

    static {
        Environment.setGlobal(BuiltinEnvironment.getInstance());
        languages = new String[][]{{"scheme", ".scm", ".sc", ".sld", "kawa.standard.Scheme"}, {"r5rs", ".scm", "kawa.standard.Scheme"}, {"r6rs", ".scm", "kawa.standard.Scheme"}, {"r7rs", ".scm", "kawa.standard.Scheme"}, {"krl", ".krl", "gnu.kawa.brl.BRL"}, {"brl", ".brl", "gnu.kawa.brl.BRL"}, {"emacs", "elisp", "emacs-lisp", ".el", "gnu.jemacs.lang.ELisp"}, {"xquery", ".xquery", ".xq", ".xql", "gnu.xquery.lang.XQuery"}, {"kashell", ".ksl", "gnu.q2.lang.Q2"}, {"q2", ".q2", "gnu.q2.lang.Q2"}, {"xslt", "xsl", ".xsl", "gnu.kawa.xslt.XSLT"}, {"commonlisp", "common-lisp", "clisp", "lisp", ".lisp", ".lsp", ".cl", "gnu.commonlisp.lang.CommonLisp"}};
    }
}

