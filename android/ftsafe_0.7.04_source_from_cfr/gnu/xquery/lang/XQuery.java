/*
 * Decompiled with CFR 0.139.
 */
package gnu.xquery.lang;

import gnu.bytecode.ClassType;
import gnu.bytecode.PrimType;
import gnu.bytecode.Type;
import gnu.expr.ApplicationMainSupport;
import gnu.expr.BeginExp;
import gnu.expr.Compilation;
import gnu.expr.Declaration;
import gnu.expr.Expression;
import gnu.expr.LambdaExp;
import gnu.expr.Language;
import gnu.expr.Mangling;
import gnu.expr.ModuleBody;
import gnu.expr.ModuleExp;
import gnu.expr.NameLookup;
import gnu.expr.QuoteExp;
import gnu.expr.ReferenceExp;
import gnu.expr.ScopeExp;
import gnu.kawa.functions.ConstantFunction0;
import gnu.kawa.io.CharArrayInPort;
import gnu.kawa.io.InPort;
import gnu.kawa.reflect.ClassMethods;
import gnu.kawa.xml.XDataType;
import gnu.kawa.xml.XIntegerType;
import gnu.kawa.xml.XStringType;
import gnu.kawa.xml.XTimeType;
import gnu.lists.Consumer;
import gnu.mapping.CallContext;
import gnu.mapping.Environment;
import gnu.mapping.EnvironmentKey;
import gnu.mapping.MethodProc;
import gnu.mapping.Namespace;
import gnu.mapping.Procedure;
import gnu.mapping.Symbol;
import gnu.mapping.Values;
import gnu.mapping.WrongType;
import gnu.math.DFloNum;
import gnu.math.IntNum;
import gnu.math.Numeric;
import gnu.text.Char;
import gnu.text.Lexer;
import gnu.text.SourceMessages;
import gnu.text.SyntaxException;
import gnu.xml.XMLPrinter;
import gnu.xquery.lang.XQParser;
import gnu.xquery.lang.XQResolveNames;
import gnu.xquery.util.BooleanValue;
import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.Vector;

public class XQuery
extends Language {
    public static final String XQUERY_FUNCTION_NAMESPACE = "http://www.w3.org/2005/xpath-functions";
    public static final String KAWA_FUNCTION_NAMESPACE = "http://kawa.gnu.org/";
    public static final String QEXO_FUNCTION_NAMESPACE = "http://qexo.gnu.org/";
    public static final String LOCAL_NAMESPACE = "http://www.w3.org/2005/xquery-local-functions";
    public static final String SCHEMA_NAMESPACE = "http://www.w3.org/2001/XMLSchema";
    public static final String SCHEMA_INSTANCE_NAMESPACE = "http://www.w3.org/2001/XMLSchema-instance";
    public static final String XHTML_NAMESPACE = "http://www.w3.org/1999/xhtml";
    public static final Namespace xqueryFunctionNamespace = Namespace.valueOf("http://www.w3.org/2005/xpath-functions");
    public static final Namespace kawaFunctionNamespace = Namespace.valueOf("http://kawa.gnu.org/");
    public static final Namespace qexoFunctionNamespace = Namespace.valueOf("http://qexo.gnu.org/");
    public static final Namespace[] defaultFunctionNamespacePath = new Namespace[]{qexoFunctionNamespace, xqueryFunctionNamespace, Namespace.EmptyNamespace, kawaFunctionNamespace};
    static boolean charIsInt = false;
    public static final String DEFAULT_ELEMENT_PREFIX = null;
    public static final String DEFAULT_FUNCTION_PREFIX = "(functions)";
    Namespace defaultNamespace;
    public static final int PARSE_WITH_FOCUS = 65536;
    public static final int VARIADIC_FUNCTION_NAMESPACE = -2;
    static int envCounter = 0;
    public static Environment extensionsEnvEnv = Environment.getInstance("http://kawa.gnu.org/");
    public static final Environment xqEnvironment = Environment.make("http://www.w3.org/2005/xpath-functions");
    public static final XQuery instance = new XQuery();
    public static QuoteExp falseExp;
    public static QuoteExp trueExp;
    public static final ConstantFunction0 falseFunction;
    public static final ConstantFunction0 trueFunction;
    static Object[] typeMap;

    @Override
    public boolean hasSeparateFunctionNamespace() {
        return true;
    }

    public static Numeric asNumber(Object arg) {
        if (arg instanceof Char) {
            return IntNum.valueOf(((Char)arg).intValue());
        }
        return (Numeric)arg;
    }

    public static char asChar(Object x) {
        if (x instanceof Char) {
            return ((Char)x).charValue();
        }
        int i = x instanceof Numeric ? ((Numeric)x).intValue() : -1;
        if (i < 0 || i > 65535) {
            throw new ClassCastException("not a character value");
        }
        return (char)i;
    }

    @Override
    public boolean isTrue(Object value) {
        return BooleanValue.booleanValue(value);
    }

    @Override
    public Lexer getLexer(InPort inp, SourceMessages messages) {
        return new XQParser(inp, messages, this);
    }

    public Compilation getCompilation(Lexer lexer, SourceMessages messages, NameLookup lexical) {
        return new Compilation(this, messages, lexical);
    }

    @Override
    public boolean parse(Compilation tr, int options) throws IOException, SyntaxException {
        ModuleExp mexp = tr.mainLambda;
        Compilation.defaultCallConvention = 2;
        tr.mustCompileHere();
        XQParser parser = (XQParser)tr.lexer;
        if (parser.isInteractive()) {
            Expression sexp = parser.parse(tr);
            if (sexp == null) {
                return false;
            }
            mexp.body = sexp;
        } else if ((options & 65536) != 0) {
            LambdaExp lexp = new LambdaExp(3);
            Declaration dotDecl = lexp.addDeclaration(XQParser.DOT_VARNAME);
            dotDecl.setFlag(262144L);
            dotDecl.noteValueUnknown();
            lexp.addDeclaration(XQParser.POSITION_VARNAME, Type.intType);
            lexp.addDeclaration(XQParser.LAST_VARNAME, Type.intType);
            tr.push(lexp);
            lexp.body = parser.parse(tr);
            tr.pop(lexp);
            mexp.body = lexp;
        } else {
            Vector<Expression> exps = new Vector<Expression>(10);
            Expression sexp = mexp.body;
            if (sexp instanceof BeginExp) {
                BeginExp bexp = (BeginExp)sexp;
                int blen = bexp.getExpressionCount();
                Expression[] bexps = bexp.getExpressions();
                for (int i = 0; i < blen; ++i) {
                    exps.addElement(bexps[i]);
                }
            } else if (sexp != null && sexp != QuoteExp.voidExp) {
                exps.addElement(sexp);
            }
            do {
                if ((sexp = parser.parse(tr)) == null) {
                    if (parser.parseCount != 0 || parser.isInteractive()) break;
                    parser.error('e', "empty module", "XPST0003");
                    return false;
                }
                exps.addElement(sexp);
            } while (true);
            int nexps = exps.size();
            if (nexps == 0) {
                mexp.body = QuoteExp.voidExp;
            } else if (nexps == 1) {
                mexp.body = (Expression)exps.elementAt(0);
            } else {
                Object[] arr = new Expression[nexps];
                exps.copyInto(arr);
                mexp.body = new BeginExp((Expression[])arr);
            }
        }
        tr.pop(mexp);
        XQResolveNames resolver = new XQResolveNames(tr);
        resolver.functionNamespacePath = parser.functionNamespacePath;
        resolver.parser = parser;
        resolver.resolveModule(mexp);
        tr.setState(4);
        return true;
    }

    @Override
    public void resolve(Compilation comp) {
    }

    public static int namespaceForFunctions(int argCount) {
        return argCount << 2 | 2;
    }

    @Override
    public int getNamespaceOf(Declaration decl) {
        if (decl.isProcedureDecl()) {
            if (decl.getCode() < 0) {
                return -2;
            }
            Expression value = decl.getValue();
            if (value instanceof LambdaExp) {
                LambdaExp lexp = (LambdaExp)value;
                if (lexp.min_args == lexp.max_args) {
                    return XQuery.namespaceForFunctions(lexp.min_args);
                }
            } else if (value instanceof QuoteExp) {
                Procedure proc;
                int max;
                int min;
                Object val = ((QuoteExp)value).getValue();
                if (val instanceof Procedure && (min = (proc = (Procedure)val).minArgs()) == (max = proc.maxArgs())) {
                    return XQuery.namespaceForFunctions(min);
                }
            } else if (value instanceof ReferenceExp) {
                return this.getNamespaceOf(((ReferenceExp)value).getBinding());
            }
            return -2;
        }
        return 1;
    }

    @Override
    public boolean hasNamespace(Declaration decl, int namespace) {
        int dnspace = this.getNamespaceOf(decl);
        return dnspace == namespace || dnspace == -2 && (namespace & 2) != 0 || namespace == -2 && (dnspace & 2) != 0;
    }

    @Override
    public Symbol getSymbol(String name) {
        return Symbol.make(this.defaultNamespace, name);
    }

    @Override
    public void define(String name, Object value) {
        Symbol sym = Symbol.make(this.defaultNamespace, name);
        Object prop = value instanceof Procedure ? EnvironmentKey.FUNCTION : null;
        this.environ.define(sym, prop, value);
    }

    protected void define_method(String name, String cname, String mname) {
        Symbol sym = Symbol.make(this.defaultNamespace, name);
        ClassType ctype = ClassType.make(cname);
        MethodProc proc = ClassMethods.apply(ctype, mname, '\u0000', this);
        proc.setSymbol(sym);
        this.environ.define(sym, EnvironmentKey.FUNCTION, proc);
    }

    @Override
    public String getName() {
        return "XQuery";
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void applyWithFocus(Procedure proc, Object item, int position, int size, Consumer out) throws Throwable {
        CallContext ctx = CallContext.getInstance();
        proc.check3(item, IntNum.valueOf(position), IntNum.valueOf(size), ctx);
        Consumer save = ctx.consumer;
        try {
            ctx.consumer = out;
            ctx.runUntilDone();
        }
        finally {
            ctx.consumer = save;
        }
    }

    public Object applyWithFocus(Procedure proc, Object item, int position, int size) throws Throwable {
        CallContext ctx = CallContext.getInstance();
        int oldIndex = ctx.startFromContext();
        try {
            proc.check3(item, IntNum.valueOf(position), IntNum.valueOf(size), ctx);
            return ctx.getFromContext(oldIndex);
        }
        catch (Throwable ex) {
            ctx.cleanupFromContext(oldIndex);
            throw ex;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void applyWithFocus(Procedure proc, Object values, Consumer out) throws Throwable {
        CallContext ctx = CallContext.getInstance();
        Consumer save = ctx.consumer;
        try {
            ctx.consumer = out;
            this.applyWithFocus$X(proc, values, ctx);
        }
        finally {
            ctx.consumer = save;
        }
    }

    public Object applyWithFocus(Procedure proc, Object values) throws Throwable {
        CallContext ctx = CallContext.getInstance();
        int oldIndex = ctx.startFromContext();
        try {
            this.applyWithFocus$X(proc, values, ctx);
            return ctx.getFromContext(oldIndex);
        }
        catch (Throwable ex) {
            ctx.cleanupFromContext(oldIndex);
            throw ex;
        }
    }

    public void applyWithFocus$X(Procedure proc, Object values, CallContext ctx) throws Throwable {
        if (values instanceof Values) {
            Values v = (Values)values;
            int count = v.size();
            if (count == 0) {
                return;
            }
            int ipos = 0;
            IntNum size = IntNum.valueOf(count);
            int i = 1;
            do {
                proc.check3(v.getPosNext(ipos), IntNum.valueOf(i), size, ctx);
                ctx.runUntilDone();
                if (i != count) {
                    ipos = v.nextPos(ipos);
                    ++i;
                    continue;
                }
                break;
            } while (true);
        } else {
            IntNum one = IntNum.one();
            proc.check3(values, one, one, ctx);
            ctx.runUntilDone();
        }
    }

    public Procedure evalToFocusProc(String expr) throws Throwable {
        SourceMessages messages = new SourceMessages();
        Procedure proc = this.evalToFocusProc(new CharArrayInPort(expr), messages);
        if (messages.seenErrors()) {
            throw new RuntimeException("invalid syntax in eval form:\n" + messages.toString(20));
        }
        return proc;
    }

    public Procedure evalToFocusProc(Reader in, SourceMessages messages) throws Throwable {
        InPort port = in instanceof InPort ? (InPort)in : new InPort(in);
        Compilation comp = this.parse(port, messages, 65537);
        CallContext ctx = CallContext.getInstance();
        int oldIndex = ctx.startFromContext();
        try {
            ModuleExp.evalModule(Environment.getCurrent(), ctx, comp, null, null);
            return (Procedure)ctx.getFromContext(oldIndex);
        }
        catch (Throwable ex) {
            ctx.cleanupFromContext(oldIndex);
            throw ex;
        }
    }

    public void evalWithFocus(Reader in, SourceMessages messages, Object values, Consumer out) throws Throwable {
        this.applyWithFocus(this.evalToFocusProc(in, messages), values, out);
    }

    public Object evalWithFocus(String expr, Object values) throws Throwable {
        return this.applyWithFocus(this.evalToFocusProc(expr), values);
    }

    public Object evalWithFocus(String expr, Object item, int position, int size) throws Throwable {
        return this.applyWithFocus(this.evalToFocusProc(expr), item, position, size);
    }

    public void evalWithFocus(Reader in, SourceMessages messages, Object item, int position, int size, Consumer out) throws Throwable {
        this.applyWithFocus(this.evalToFocusProc(in, messages), item, position, size, out);
    }

    public void eval_with_focus$X(String expr, Object values, CallContext ctx) throws Throwable {
        this.applyWithFocus$X(this.evalToFocusProc(expr), values, ctx);
    }

    public void eval_with_focus$X(String expr, Object item, int position, int size, CallContext ctx) throws Throwable {
        Procedure proc = this.evalToFocusProc(expr);
        proc.check3(item, IntNum.valueOf(position), IntNum.valueOf(size), ctx);
    }

    public XQuery() {
        this.environ = xqEnvironment;
        this.defaultNamespace = xqueryFunctionNamespace;
    }

    private void initXQuery() {
        ModuleBody.setMainPrintValues(true);
        this.defProcStFld("unescaped-data", "gnu.kawa.xml.MakeUnescapedData", "unescapedData");
        this.defProcStFld("item-at", "gnu.xquery.util.ItemAt", "itemAt");
        this.defProcStFld("count", "kawa.lib.xquery.Xutils", "count$Mnvalues");
        this.define_method("sum", "gnu.xquery.util.Reduce", "sum");
        this.defProcStFld("avg", "gnu.xquery.util.Average", "avg");
        this.defProcStFld("sublist", "kawa.lib.xquery.Xutils", "sublist");
        this.defProcStFld("subsequence", "kawa.lib.xquery.Xutils", "sublist");
        this.define_method("empty", "gnu.xquery.util.SequenceUtils", "isEmptySequence");
        this.define_method("exists", "gnu.xquery.util.SequenceUtils", "exists");
        this.define_method("insert-before", "gnu.xquery.util.SequenceUtils", "insertBefore$X");
        this.define_method("remove", "gnu.xquery.util.SequenceUtils", "remove$X");
        this.define_method("reverse", "gnu.xquery.util.SequenceUtils", "reverse$X");
        this.defProcStFld("false", "gnu.xquery.lang.XQuery", "falseFunction");
        this.defProcStFld("true", "gnu.xquery.lang.XQuery", "trueFunction");
        this.defProcStFld("boolean", "gnu.xquery.util.BooleanValue", "booleanValue");
        this.define_method("trace", "gnu.xquery.util.Debug", "trace");
        this.define_method("error", "gnu.xquery.util.XQException", "error");
        this.defProcStFld("write-to", "gnu.kawa.xml.WriteTo", "writeTo");
        this.defProcStFld("write-to-if-changed", "gnu.kawa.xml.WriteTo", "writeToIfChanged");
        this.defProcStFld("iterator-items", "gnu.kawa.xml.IteratorItems", "iteratorItems");
        this.defProcStFld("list-items", "gnu.kawa.xml.ListItems", "listItems");
        this.define_method("node-name", "gnu.xquery.util.NodeUtils", "nodeName");
        this.define_method("nilled", "gnu.xquery.util.NodeUtils", "nilled");
        this.define_method("data", "gnu.xquery.util.NodeUtils", "data$X");
        this.define_method("lower-case", "gnu.xquery.util.StringUtils", "lowerCase");
        this.define_method("upper-case", "gnu.xquery.util.StringUtils", "upperCase");
        this.define_method("substring", "gnu.xquery.util.StringUtils", "substring");
        this.define_method("string-length", "gnu.xquery.util.StringUtils", "stringLength");
        this.define_method("substring-before", "gnu.xquery.util.StringUtils", "substringBefore");
        this.define_method("substring-after", "gnu.xquery.util.StringUtils", "substringAfter");
        this.define_method("translate", "gnu.xquery.util.StringUtils", "translate");
        this.define_method("encode-for-uri", "gnu.xquery.util.StringUtils", "encodeForUri");
        this.define_method("iri-to-uri", "gnu.xquery.util.StringUtils", "iriToUri");
        this.define_method("escape-html-uri", "gnu.xquery.util.StringUtils", "escapeHtmlUri");
        this.define_method("contains", "gnu.xquery.util.StringUtils", "contains");
        this.define_method("starts-with", "gnu.xquery.util.StringUtils", "startsWith");
        this.define_method("ends-with", "gnu.xquery.util.StringUtils", "endsWith");
        this.define_method("codepoint-equal", "gnu.xquery.util.StringUtils", "codepointEqual");
        this.define_method("normalize-unicode", "gnu.xquery.util.StringUtils", "normalizeUnicode");
        this.define_method("string-join", "gnu.xquery.util.StringUtils", "stringJoin");
        this.define_method("concat", "gnu.xquery.util.StringUtils", "concat$V");
        this.define_method("matches", "gnu.xquery.util.StringUtils", "matches");
        this.define_method("replace", "gnu.xquery.util.StringUtils", "replace");
        this.define_method("tokenize", "gnu.xquery.util.StringUtils", "tokenize$X");
        this.define_method("string-to-codepoints", "gnu.xquery.util.StringUtils", "stringToCodepoints$X");
        this.define_method("codepoints-to-string", "gnu.xquery.util.StringUtils", "codepointsToString");
        this.define_method("abs", "gnu.xquery.util.NumberValue", "abs");
        this.define_method("floor", "gnu.xquery.util.NumberValue", "floor");
        this.define_method("ceiling", "gnu.xquery.util.NumberValue", "ceiling");
        this.define_method("round", "gnu.xquery.util.NumberValue", "round");
        this.define_method("round-half-to-even", "gnu.xquery.util.NumberValue", "roundHalfToEven");
        this.define_method("QName", "gnu.xquery.util.QNameUtils", "makeQName");
        this.define_method("resolve-QName", "gnu.xquery.util.QNameUtils", "resolveQNameUsingElement");
        this.define_method("prefix-from-QName", "gnu.xquery.util.QNameUtils", "prefixFromQName");
        this.define_method("local-name-from-QName", "gnu.xquery.util.QNameUtils", "localNameFromQName");
        this.define_method("namespace-uri-from-QName", "gnu.xquery.util.QNameUtils", "namespaceURIFromQName");
        this.define_method("namespace-uri-for-prefix", "gnu.xquery.util.QNameUtils", "namespaceURIForPrefix");
        this.define_method("in-scope-prefixes", "gnu.xquery.util.NodeUtils", "inScopePrefixes$X");
        this.define_method("document-uri", "gnu.xquery.util.NodeUtils", "documentUri");
        this.define_method("years-from-duration", "gnu.xquery.util.TimeUtils", "yearsFromDuration");
        this.define_method("months-from-duration", "gnu.xquery.util.TimeUtils", "monthsFromDuration");
        this.define_method("days-from-duration", "gnu.xquery.util.TimeUtils", "daysFromDuration");
        this.define_method("hours-from-duration", "gnu.xquery.util.TimeUtils", "hoursFromDuration");
        this.define_method("minutes-from-duration", "gnu.xquery.util.TimeUtils", "minutesFromDuration");
        this.define_method("seconds-from-duration", "gnu.xquery.util.TimeUtils", "secondsFromDuration");
        this.define_method("year-from-dateTime", "gnu.xquery.util.TimeUtils", "yearFromDateTime");
        this.define_method("month-from-dateTime", "gnu.xquery.util.TimeUtils", "monthFromDateTime");
        this.define_method("day-from-dateTime", "gnu.xquery.util.TimeUtils", "dayFromDateTime");
        this.define_method("hours-from-dateTime", "gnu.xquery.util.TimeUtils", "hoursFromDateTime");
        this.define_method("minutes-from-dateTime", "gnu.xquery.util.TimeUtils", "minutesFromDateTime");
        this.define_method("seconds-from-dateTime", "gnu.xquery.util.TimeUtils", "secondsFromDateTime");
        this.define_method("timezone-from-dateTime", "gnu.xquery.util.TimeUtils", "timezoneFromDateTime");
        this.define_method("year-from-date", "gnu.xquery.util.TimeUtils", "yearFromDate");
        this.define_method("month-from-date", "gnu.xquery.util.TimeUtils", "monthFromDate");
        this.define_method("day-from-date", "gnu.xquery.util.TimeUtils", "dayFromDate");
        this.define_method("timezone-from-date", "gnu.xquery.util.TimeUtils", "timezoneFromDate");
        this.define_method("hours-from-time", "gnu.xquery.util.TimeUtils", "hoursFromTime");
        this.define_method("minutes-from-time", "gnu.xquery.util.TimeUtils", "minutesFromTime");
        this.define_method("seconds-from-time", "gnu.xquery.util.TimeUtils", "secondsFromTime");
        this.define_method("timezone-from-time", "gnu.xquery.util.TimeUtils", "timezoneFromTime");
        this.define_method("adjust-dateTime-to-timezone", "gnu.xquery.util.TimeUtils", "adjustDateTimeToTimezone");
        this.define_method("adjust-date-to-timezone", "gnu.xquery.util.TimeUtils", "adjustDateToTimezone");
        this.define_method("adjust-time-to-timezone", "gnu.xquery.util.TimeUtils", "adjustTimeToTimezone");
        this.define_method("dateTime", "gnu.xquery.util.TimeUtils", "dateTime");
        this.define_method("current-dateTime", "gnu.xquery.util.TimeUtils", "currentDateTime");
        this.define_method("current-date", "gnu.xquery.util.TimeUtils", "currentDate");
        this.define_method("current-time", "gnu.xquery.util.TimeUtils", "currentTime");
        this.define_method("implicit-timezone", "gnu.xquery.util.TimeUtils", "implicitTimezone");
        this.define_method("zero-or-one", "gnu.xquery.util.SequenceUtils", "zeroOrOne");
        this.define_method("one-or-more", "gnu.xquery.util.SequenceUtils", "oneOrMore");
        this.define_method("exactly-one", "gnu.xquery.util.SequenceUtils", "exactlyOne");
        this.defProcStFld("distinct-nodes", "gnu.kawa.xml.SortNodes", "sortNodes");
        this.defProcStFld("children", "gnu.kawa.xml.Children", "children");
        this.define_method("not", "gnu.xquery.util.BooleanValue", "not");
        this.defaultNamespace = qexoFunctionNamespace;
        this.defProcStFld("response-header", "gnu.kawa.servlet.HTTP");
        this.defProcStFld("response-content-type", "gnu.kawa.servlet.HTTP");
        this.defProcStFld("response-status", "gnu.kawa.servlet.HTTP");
        this.defProcStFld("error-response", "gnu.kawa.servlet.HTTP");
        this.defProcStFld("current-servlet", "gnu.kawa.servlet.HTTP");
        this.defProcStFld("current-servlet-context", "gnu.kawa.servlet.HTTP");
        this.defProcStFld("current-servlet-config", "gnu.kawa.servlet.HTTP");
        this.defProcStFld("servlet-context-realpath", "gnu.kawa.servlet.HTTP");
        this.defProcStFld("get-response", "gnu.kawa.servlet.HTTP");
        this.defProcStFld("get-request", "gnu.kawa.servlet.HTTP");
        this.defProcStFld("request-method", "gnu.kawa.servlet.HTTP");
        this.defProcStFld("request-uri", "gnu.kawa.servlet.HTTP");
        this.defProcStFld("request-url", "gnu.kawa.servlet.HTTP");
        this.defProcStFld("request-path-info", "gnu.kawa.servlet.HTTP");
        this.defProcStFld("request-path-translated", "gnu.kawa.servlet.HTTP");
        this.defProcStFld("request-servlet-path", "gnu.kawa.servlet.HTTP");
        this.defProcStFld("request-query-string", "gnu.kawa.servlet.HTTP");
        this.defProcStFld("request-parameter", "gnu.kawa.servlet.HTTP");
        this.defProcStFld("request-parameters", "gnu.kawa.servlet.HTTP");
        this.defaultNamespace = xqueryFunctionNamespace;
    }

    public static XQuery getInstance() {
        return instance;
    }

    public static void registerEnvironment() {
        ApplicationMainSupport.processCommandLinePropertyAssignments = true;
        Language.setDefaults(instance);
    }

    @Override
    public Consumer getOutputConsumer(Writer out) {
        return new XMLPrinter(out);
    }

    public Type getStandardType(String name) {
        int i = typeMap.length;
        while ((i -= 2) >= 0) {
            if (!typeMap[i].equals(name)) continue;
            Object t = typeMap[i + 1];
            if (t instanceof String) {
                return super.getTypeFor((String)t);
            }
            return (Type)t;
        }
        return null;
    }

    @Override
    public Type getTypeFor(String name) {
        String core = name.startsWith("xs:") ? name.substring(3) : (name.startsWith("xdt:") ? name.substring(4) : name);
        Type t = this.getStandardType(core);
        return t != null ? t : super.getTypeFor(name);
    }

    @Override
    public String formatType(Type type) {
        String tname = type.getName();
        if ("gnu.math.IntNum".equals(tname)) {
            return "xs:integer";
        }
        if ("java.lang.String".equals(tname) || "java.lang.CharSequence".equals(tname)) {
            return "xs:string";
        }
        return type.toString();
    }

    @Override
    public Type getTypeFor(Class clas) {
        if (clas.isPrimitive()) {
            String name = clas.getName();
            if (name.equals("boolean")) {
                return XDataType.booleanType;
            }
            return super.getTypeFor(name);
        }
        if (!clas.isArray()) {
            String name = clas.getName();
            if (name.equals("java.lang.String")) {
                return XDataType.stringStringType;
            }
            if (name.equals("gnu.kawa.xml.UntypedAtomic")) {
                return XDataType.untypedAtomicType;
            }
            if (name.equals("java.lang.Boolean")) {
                return XDataType.booleanType;
            }
            if (name.equals("java.lang.Float")) {
                return XDataType.floatType;
            }
            if (name.equals("java.lang.Double")) {
                return XDataType.doubleType;
            }
            if (name.equals("java.math.BigDecimal")) {
                return XDataType.decimalType;
            }
            if (name.equals("gnu.math.Duration")) {
                return XDataType.durationType;
            }
            if (name.equals("gnu.kawa.io.Path")) {
                return XDataType.anyURIType;
            }
        }
        return Type.make(clas);
    }

    @Override
    public String getPrimaryPrompt() {
        return "<!--%N-->";
    }

    @Override
    public String getSecondaryPrompt() {
        return "{%P.%N} ";
    }

    static void mangle(String name, int start, int length, StringBuffer sbuf, char mode) {
        int prev = 80;
        int outStart = sbuf.length();
        int i = 0;
        while (i < length) {
            boolean wordStart;
            char ch = name.charAt(start + i);
            ++i;
            if (Character.isUpperCase(ch)) {
                wordStart = prev != 85 || i < length && Character.isLowerCase(name.charAt(start + i));
                prev = 85;
            } else if (Character.isLowerCase(ch)) {
                wordStart = prev != 76 || prev != 85;
                prev = 76;
            } else if (Character.isLetter(ch)) {
                wordStart = prev != 79;
                prev = 79;
            } else if (Character.isDigit(ch)) {
                wordStart = prev != 68;
                prev = 68;
            } else if (Character.isJavaIdentifierPart(ch)) {
                wordStart = prev != 68 && prev != 77;
                prev = 77;
            } else {
                prev = 80;
                continue;
            }
            if (wordStart || mode == '_') {
                if (wordStart && mode == '_' && sbuf.length() > outStart) {
                    sbuf.append('_');
                }
                ch = Character.toUpperCase(ch);
            }
            sbuf.append(ch);
        }
    }

    public static String mangle(String name) {
        StringBuffer sbuf = new StringBuffer();
        XQuery.mangle(name, 0, name.length(), sbuf, 'U');
        return sbuf.toString();
    }

    public static String makeClassName(String source) {
        int dot;
        int sl = (source = source.replace(File.separatorChar, '/')).lastIndexOf(47);
        if (sl >= 0) {
            source = source.substring(sl + 1);
        }
        if ((dot = source.lastIndexOf(46)) >= 0) {
            source = source.substring(0, dot);
        }
        return Mangling.mangleNameIfNeeded(source);
    }

    public static Object getExternal(Symbol name, Object type) {
        Environment env = Environment.getCurrent();
        Object value = env.get(name, null, null);
        if (value == null) {
            value = env.get(Symbol.makeWithUnknownNamespace(name.getLocalName(), name.getPrefix()), null, null);
        }
        if (value == null) {
            throw new RuntimeException("unbound external " + name);
        }
        if (type == null) {
            return value;
        }
        if (type instanceof XDataType) {
            return ((XDataType)type).cast(value);
        }
        if (type instanceof ClassType) {
            String cname = ((ClassType)type).getName();
            if ("gnu.math.IntNum".equals(cname)) {
                return IntNum.valueOf(value.toString());
            }
            if ("gnu.math.RealNum".equals(cname)) {
                return DFloNum.valueOf(Double.parseDouble(value.toString()));
            }
        }
        try {
            value = ((Type)type).coerceFromObject(value);
        }
        catch (ClassCastException ex) {
            throw new WrongType(name.toString(), -2, value, type.toString());
        }
        return value;
    }

    static {
        instance.initXQuery();
        falseExp = new QuoteExp(Boolean.FALSE, XDataType.booleanType);
        trueExp = new QuoteExp(Boolean.TRUE, XDataType.booleanType);
        falseFunction = new ConstantFunction0("false", falseExp);
        trueFunction = new ConstantFunction0("true", trueExp);
        typeMap = new Object[]{"string", XDataType.stringType, "untypedAtomic", XDataType.untypedAtomicType, "boolean", XDataType.booleanType, "integer", XIntegerType.integerType, "long", XIntegerType.longType, "int", XIntegerType.intType, "short", XIntegerType.shortType, "byte", XIntegerType.byteType, "unsignedLong", XIntegerType.unsignedLongType, "unsignedInt", XIntegerType.unsignedIntType, "unsignedShort", XIntegerType.unsignedShortType, "unsignedByte", XIntegerType.unsignedByteType, "positiveInteger", XIntegerType.positiveIntegerType, "nonPositiveInteger", XIntegerType.nonPositiveIntegerType, "negativeInteger", XIntegerType.negativeIntegerType, "nonNegativeInteger", XIntegerType.nonNegativeIntegerType, "date", XTimeType.dateType, "dateTime", XTimeType.dateTimeType, "time", XTimeType.timeType, "duration", XTimeType.durationType, "yearMonthDuration", XTimeType.yearMonthDurationType, "dayTimeDuration", XTimeType.dayTimeDurationType, "gYearMonth", XTimeType.gYearMonthType, "gYear", XTimeType.gYearType, "gMonthDay", XTimeType.gMonthDayType, "gDay", XTimeType.gDayType, "gMonth", XTimeType.gMonthType, "decimal", XDataType.decimalType, "float", XDataType.floatType, "double", XDataType.doubleType, "anyURI", XDataType.anyURIType, "hexBinary", XDataType.hexBinaryType, "base64Binary", XDataType.base64BinaryType, "NOTATION", XDataType.NotationType, "QName", "gnu.mapping.Symbol", "normalizedString", XStringType.normalizedStringType, "token", XStringType.tokenType, "language", XStringType.languageType, "NMTOKEN", XStringType.NMTOKENType, "Name", XStringType.NameType, "NCName", XStringType.NCNameType, "ID", XStringType.IDType, "IDREF", XStringType.IDREFType, "ENTITY", XStringType.ENTITYType, "anyAtomicType", XDataType.anyAtomicType, "anySimpleType", XDataType.anySimpleType, "untyped", XDataType.untypedType, "anyType", Type.objectType};
    }
}

