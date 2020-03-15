// 
// Decompiled by Procyon v0.5.36
// 

package gnu.xquery.lang;

import gnu.expr.ExpVisitor;
import java.util.HashMap;
import java.util.Map;
import gnu.expr.ExpExpVisitor;
import gnu.kawa.functions.GetModuleClass;
import gnu.xml.XMLFilter;
import gnu.kawa.xml.MakeAttribute;
import gnu.kawa.xml.NodeType;
import gnu.mapping.Procedure;
import gnu.xquery.util.QNameUtils;
import gnu.kawa.xml.XDataType;
import gnu.kawa.reflect.SingletonType;
import gnu.xml.NamespaceBinding;
import gnu.kawa.xml.MakeElement;
import gnu.expr.ErrorExp;
import gnu.mapping.WrongArguments;
import gnu.expr.PrimProcedure;
import gnu.xquery.util.NamedCollator;
import gnu.expr.ModuleExp;
import gnu.expr.BeginExp;
import gnu.expr.SetExp;
import gnu.bytecode.Method;
import gnu.bytecode.Type;
import gnu.kawa.functions.CompileNamedPart;
import gnu.expr.QuoteExp;
import gnu.bytecode.ClassType;
import gnu.expr.ApplyExp;
import gnu.expr.Expression;
import gnu.expr.ReferenceExp;
import gnu.mapping.Location;
import gnu.mapping.Environment;
import gnu.kawa.reflect.StaticFieldLocation;
import gnu.mapping.EnvironmentKey;
import gnu.text.SourceLocator;
import gnu.expr.ScopeExp;
import gnu.expr.Compilation;
import gnu.mapping.Symbol;
import gnu.mapping.Namespace;
import gnu.expr.Declaration;
import gnu.expr.ResolveNames;

public class XQResolveNames extends ResolveNames
{
    public XQParser parser;
    public static final int LAST_BUILTIN = -1;
    public static final int POSITION_BUILTIN = -2;
    public static final int HANDLE_EXTENSION_BUILTIN = -3;
    public static final int COMPARE_BUILTIN = -4;
    public static final int DISTINCT_VALUES_BUILTIN = -5;
    public static final int LOCAL_NAME_BUILTIN = -6;
    public static final int NAMESPACE_URI_BUILTIN = -7;
    public static final int COLLECTION_BUILTIN = -8;
    public static final int DOC_BUILTIN = -9;
    public static final int DOC_AVAILABLE_BUILTIN = -10;
    public static final int BASE_URI_BUILTIN = -11;
    public static final int RESOLVE_URI_BUILTIN = -12;
    public static final int RESOLVE_PREFIX_BUILTIN = -13;
    public static final int STATIC_BASE_URI_BUILTIN = -14;
    public static final int INDEX_OF_BUILTIN = -15;
    public static final int STRING_BUILTIN = -16;
    public static final int NORMALIZE_SPACE_BUILTIN = -17;
    public static final int UNORDERED_BUILTIN = -18;
    public static final int LANG_BUILTIN = -23;
    public static final int NAME_BUILTIN = -24;
    public static final int DEEP_EQUAL_BUILTIN = -25;
    public static final int MIN_BUILTIN = -26;
    public static final int MAX_BUILTIN = -27;
    public static final int NUMBER_BUILTIN = -28;
    public static final int DEFAULT_COLLATION_BUILTIN = -29;
    public static final int ID_BUILTIN = -30;
    public static final int IDREF_BUILTIN = -31;
    public static final int ROOT_BUILTIN = -32;
    public static final int CAST_AS_BUILTIN = -33;
    public static final int CASTABLE_AS_BUILTIN = -34;
    public static final int XS_QNAME_BUILTIN = -35;
    public static final int XS_QNAME_IGNORE_DEFAULT_BUILTIN = -36;
    public static final Declaration handleExtensionDecl;
    public static final Declaration castAsDecl;
    public static final Declaration castableAsDecl;
    public static final Declaration lastDecl;
    public static final Declaration xsQNameDecl;
    public static final Declaration xsQNameIgnoreDefaultDecl;
    public static final Declaration staticBaseUriDecl;
    public static final Declaration resolvePrefixDecl;
    public Namespace[] functionNamespacePath;
    private Declaration moduleDecl;
    
    public static Declaration makeBuiltin(final String name, final int code) {
        return makeBuiltin(Symbol.make("http://www.w3.org/2005/xpath-functions", name, "fn"), code);
    }
    
    public static Declaration makeBuiltin(final Symbol name, final int code) {
        final Declaration decl = new Declaration(name);
        decl.setProcedureDecl(true);
        decl.setCode(code);
        return decl;
    }
    
    public XQResolveNames() {
        this(null);
    }
    
    void pushBuiltin(final String name, final int code) {
        this.lookup.push(makeBuiltin(name, code));
    }
    
    public XQResolveNames(final Compilation comp) {
        super(comp);
        this.functionNamespacePath = XQuery.defaultFunctionNamespacePath;
        this.lookup.push(XQResolveNames.lastDecl);
        this.lookup.push(XQResolveNames.xsQNameDecl);
        this.lookup.push(XQResolveNames.staticBaseUriDecl);
        this.pushBuiltin("position", -2);
        this.pushBuiltin("compare", -4);
        this.pushBuiltin("distinct-values", -5);
        this.pushBuiltin("local-name", -6);
        this.pushBuiltin("name", -24);
        this.pushBuiltin("namespace-uri", -7);
        this.pushBuiltin("root", -32);
        this.pushBuiltin("base-uri", -11);
        this.pushBuiltin("lang", -23);
        this.pushBuiltin("resolve-uri", -12);
        this.pushBuiltin("collection", -8);
        this.pushBuiltin("doc", -9);
        this.pushBuiltin("document", -9);
        this.pushBuiltin("doc-available", -10);
        this.pushBuiltin("index-of", -15);
        this.pushBuiltin("string", -16);
        this.pushBuiltin("normalize-space", -17);
        this.pushBuiltin("unordered", -18);
        this.pushBuiltin("deep-equal", -25);
        this.pushBuiltin("min", -26);
        this.pushBuiltin("max", -27);
        this.pushBuiltin("number", -28);
        this.pushBuiltin("default-collation", -29);
        this.pushBuiltin("id", -30);
        this.pushBuiltin("idref", -31);
    }
    
    @Override
    protected void push(final ScopeExp exp) {
        for (Declaration decl = exp.firstDecl(); decl != null; decl = decl.nextDecl()) {
            this.push(decl);
        }
    }
    
    void push(final Declaration decl) {
        final Compilation comp = this.getCompilation();
        Object name = decl.getSymbol();
        final boolean function = decl.isProcedureDecl();
        if (name instanceof String) {
            final int line = decl.getLineNumber();
            if (line > 0 && comp != null) {
                final String saveFilename = comp.getFileName();
                final int saveLine = comp.getLineNumber();
                final int saveColumn = comp.getColumnNumber();
                comp.setLocation(decl);
                name = this.parser.namespaceResolve((String)name, function);
                comp.setLine(saveFilename, saveLine, saveColumn);
            }
            else {
                name = this.parser.namespaceResolve((String)name, function);
            }
            if (name == null) {
                return;
            }
            decl.setName(name);
        }
        final Declaration old = this.lookup.lookup(name, XQuery.instance.getNamespaceOf(decl));
        if (old != null) {
            if (decl.context == old.context) {
                ScopeExp.duplicateDeclarationError(old, decl, comp);
            }
            else if (XQParser.warnHidePreviousDeclaration && (!(name instanceof Symbol) || ((Symbol)name).getNamespace() != null)) {
                comp.error('w', decl, "declaration ", " hides previous declaration");
            }
        }
        this.lookup.push(decl);
    }
    
    Declaration flookup(final Symbol sym) {
        final Environment env = XQuery.xqEnvironment;
        Location loc = env.lookup(sym, EnvironmentKey.FUNCTION);
        if (loc == null) {
            return null;
        }
        loc = loc.getBase();
        if (loc instanceof StaticFieldLocation) {
            final Declaration decl = ((StaticFieldLocation)loc).getDeclaration();
            if (decl != null) {
                return decl;
            }
        }
        final Object val = loc.get(null);
        if (val != null) {
            return procToDecl(sym, val);
        }
        return null;
    }
    
    @Override
    protected Expression visitReferenceExp(final ReferenceExp exp, final Void ignored) {
        return this.visitReferenceExp(exp, (ApplyExp)null);
    }
    
    protected Expression visitReferenceExp(final ReferenceExp exp, final ApplyExp call) {
        if (exp.getBinding() == null) {
            final Object symbol = exp.getSymbol();
            final boolean needFunction = exp.isProcedureName();
            final boolean needType = exp.getFlag(16);
            final int namespace = (call == null) ? 1 : XQuery.namespaceForFunctions(call.getArgCount());
            Declaration decl = this.lookup.lookup(symbol, namespace);
            if (decl == null) {
                Symbol sym;
                if (symbol instanceof Symbol && "".equals((sym = (Symbol)symbol).getNamespaceURI())) {
                    final String name = sym.getLocalName();
                    String mname;
                    if ("request".equals(name)) {
                        mname = "getCurrentRequest";
                    }
                    else if ("response".equals(name)) {
                        mname = "getCurrentResponse";
                    }
                    else {
                        mname = null;
                    }
                    if (mname != null) {
                        final Method meth = ClassType.make("gnu.kawa.servlet.KawaServlet").getDeclaredMethod(mname, 0);
                        return new ApplyExp(meth, Expression.noExpressions);
                    }
                }
                else if (symbol instanceof Symbol) {
                    decl = this.flookup((Symbol)symbol);
                }
                else {
                    String name = (String)symbol;
                    if (name.indexOf(58) < 0) {
                        name = name.intern();
                        if (needFunction) {
                            for (int i = 0; i < this.functionNamespacePath.length; ++i) {
                                sym = this.functionNamespacePath[i].getSymbol(name);
                                decl = this.lookup.lookup(sym, namespace);
                                if (decl != null) {
                                    break;
                                }
                                decl = this.flookup(sym);
                                if (decl != null) {
                                    break;
                                }
                            }
                        }
                    }
                    if (decl == null) {
                        sym = this.parser.namespaceResolve(name, needFunction);
                        if (sym != null) {
                            decl = this.lookup.lookup(sym, namespace);
                            if (decl == null && (needFunction || needType)) {
                                final String uri = sym.getNamespaceURI();
                                Type type = null;
                                if ("http://www.w3.org/2001/XMLSchema".equals(uri)) {
                                    type = this.parser.interpreter.getStandardType(sym.getName());
                                }
                                else if (needType && uri == "" && !this.getCompilation().isPedantic()) {
                                    type = this.parser.interpreter.getTypeFor(name);
                                }
                                if (type != null) {
                                    return new QuoteExp(type).setLine(exp);
                                }
                                if (uri != null && uri.length() > 6 && uri.startsWith("class:")) {
                                    final ClassType ctype = ClassType.make(uri.substring(6));
                                    return CompileNamedPart.makeExp(ctype, sym.getName());
                                }
                                decl = this.flookup(sym);
                            }
                        }
                    }
                }
            }
            if (decl != null) {
                exp.setBinding(decl);
            }
            else if (needFunction) {
                this.error('e', "unknown function " + symbol);
            }
            else if (needType) {
                this.messages.error('e', exp, "unknown type " + symbol, "XPST0051");
            }
            else {
                this.messages.error('e', exp, "unknown variable $" + symbol, "XPST0008");
            }
        }
        return exp;
    }
    
    @Override
    protected Expression visitSetExp(final SetExp exp, final Void ignored) {
        final Expression result = super.visitSetExp(exp, ignored);
        final Declaration decl = exp.getBinding();
        final Object name;
        final Expression new_value;
        if (decl != null && !this.getCompilation().immediate && (name = decl.getSymbol()) instanceof Symbol && "http://www.w3.org/2005/xquery-local-functions".equals(((Symbol)name).getNamespaceURI()) && (!((new_value = exp.getNewValue()) instanceof ApplyExp) || ((ApplyExp)new_value).getFunction() != XQParser.getExternalFunction)) {
            decl.setFlag(16777216L);
            decl.setPrivate(true);
        }
        return result;
    }
    
    private Expression visitStatements(Expression exp) {
        if (exp instanceof BeginExp) {
            final BeginExp bbody = (BeginExp)exp;
            final Expression[] exps = bbody.getExpressions();
            for (int nexps = bbody.getExpressionCount(), i = 0; i < nexps; ++i) {
                exps[i] = this.visitStatements(exps[i]);
            }
        }
        else if (exp instanceof SetExp) {
            Declaration decl = this.moduleDecl;
            final SetExp sexp = (SetExp)exp;
            exp = this.visitSetExp(sexp, (Void)null);
            if (sexp.isDefining() && sexp.getBinding() == decl) {
                if (!decl.isProcedureDecl()) {
                    this.push(decl);
                }
                decl = decl.nextDecl();
            }
            this.moduleDecl = decl;
        }
        else {
            exp = this.visit(exp, null);
        }
        return exp;
    }
    
    @Override
    public void resolveModule(final ModuleExp exp) {
        this.currentLambda = exp;
        for (Declaration decl = exp.firstDecl(); decl != null; decl = decl.nextDecl()) {
            if (decl.isProcedureDecl()) {
                this.push(decl);
            }
        }
        this.moduleDecl = exp.firstDecl();
        exp.body = this.visitStatements(exp.body);
        for (Declaration decl = exp.firstDecl(); decl != null; decl = decl.nextDecl()) {
            if (!decl.isProcedureDecl() && CycleDetector.scanVariable(decl)) {
                this.getCompilation().error('e', "cycle detected initializing $" + decl.getName(), "XQST0054", decl);
            }
            if (decl.getSymbol() != null) {
                this.lookup.removeSubsumed(decl);
            }
        }
    }
    
    Expression getCollator(final Expression[] args, final int argno) {
        if (args != null && args.length > argno) {
            return new ApplyExp(ClassType.make("gnu.xquery.util.NamedCollator").getDeclaredMethod("find", 1), new Expression[] { args[argno] });
        }
        final NamedCollator coll = this.parser.defaultCollator;
        return (coll == null) ? QuoteExp.nullExp : new QuoteExp(coll);
    }
    
    Expression withCollator(final Method method, final Expression[] args, final String name, final int minArgs) {
        return this.withCollator(new QuoteExp(new PrimProcedure(method)), args, name, minArgs);
    }
    
    Expression withCollator(final Expression function, final Expression[] args, final String name, final int minArgs) {
        final String err = WrongArguments.checkArgCount(name, minArgs, minArgs + 1, args.length);
        if (err != null) {
            return this.getCompilation().syntaxError(err);
        }
        final Expression[] xargs = new Expression[minArgs + 1];
        System.arraycopy(args, 0, xargs, 0, minArgs);
        xargs[minArgs] = this.getCollator(args, minArgs);
        return new ApplyExp(function, xargs);
    }
    
    Expression withContext(final Method method, Expression[] args, final String name, final int minArgs) {
        final String err = WrongArguments.checkArgCount(name, minArgs, minArgs + 1, args.length);
        if (err != null) {
            return this.getCompilation().syntaxError(err);
        }
        if (args.length == minArgs) {
            final Expression[] xargs = new Expression[minArgs + 1];
            System.arraycopy(args, 0, xargs, 0, minArgs);
            final Declaration dot = this.lookup.lookup(XQParser.DOT_VARNAME, false);
            if (dot == null) {
                final String message = "undefined context for " + name;
                this.messages.error('e', message, "XPDY0002");
                return new ErrorExp(message);
            }
            xargs[minArgs] = new ReferenceExp(dot);
            args = xargs;
        }
        return new ApplyExp(method, args);
    }
    
    private Expression checkArgCount(final Expression[] args, final Declaration decl, final int min, final int max) {
        final String err = WrongArguments.checkArgCount("fn:" + decl.getName(), min, max, args.length);
        if (err == null) {
            return null;
        }
        return this.getCompilation().syntaxError(err);
    }
    
    protected Expression visitApplyExp(final ApplyExp exp, final Void ignored) {
        Expression func = exp.getFunction();
        final NamespaceBinding namespaceSave = this.parser.constructorNamespaces;
        Object proc = exp.getFunctionValue();
        if (proc instanceof MakeElement) {
            final MakeElement mk = (MakeElement)proc;
            final NamespaceBinding nschain = NamespaceBinding.nconc(mk.getNamespaceNodes(), namespaceSave);
            mk.setNamespaceNodes(nschain);
            this.parser.constructorNamespaces = nschain;
        }
        if (func instanceof ReferenceExp) {
            func = this.visitReferenceExp((ReferenceExp)func, exp);
        }
        else {
            func = this.visit(func, (D)ignored);
        }
        exp.setFunction(func);
        ((ExpVisitor<R, D>)this).visitExps(exp.getArgs(), (D)ignored);
        this.parser.constructorNamespaces = namespaceSave;
        func = exp.getFunction();
        if (func instanceof ReferenceExp) {
            Declaration decl = ((ReferenceExp)func).getBinding();
            final int code;
            if (decl != null && (code = decl.getCode()) < 0) {
                switch (code) {
                    case -2:
                    case -1: {
                        final Symbol sym = (code == -1) ? XQParser.LAST_VARNAME : XQParser.POSITION_VARNAME;
                        decl = this.lookup.lookup(sym, false);
                        if (decl == null) {
                            this.error('e', "undefined context for " + sym.getName());
                        }
                        else {
                            decl.setCanRead(true);
                        }
                        return new ReferenceExp(sym, decl);
                    }
                    case -34:
                    case -33: {
                        final Expression[] args = exp.getArgs();
                        Expression qexp;
                        final Expression texp = qexp = args[code != -33];
                        if (texp instanceof ApplyExp) {
                            final ApplyExp taexp = (ApplyExp)texp;
                            if (taexp.getFunction().valueIfConstant() == XQParser.proc_OccurrenceType_getInstance) {
                                qexp = taexp.getArg(0);
                            }
                        }
                        Object value = qexp.valueIfConstant();
                        String msg = null;
                        if (value == SingletonType.getInstance()) {
                            msg = "type to 'cast as' or 'castable as' must be atomic";
                        }
                        else if (value == XDataType.anyAtomicType) {
                            msg = "type to 'cast as' or 'castable as' cannot be anyAtomicType";
                        }
                        else if (value == XDataType.anySimpleType) {
                            msg = "type to 'cast as' or 'castable as' cannot be anySimpleType";
                        }
                        else if (value == XDataType.untypedType) {
                            msg = "type to 'cast as' or 'castable as' cannot be untyped";
                        }
                        else if (value == XDataType.NotationType) {
                            msg = "type to 'cast as' or 'castable as' cannot be NOTATION";
                        }
                        if (msg != null) {
                            this.messages.error('e', texp, msg, "XPST0080");
                        }
                        final boolean toQName = value == Compilation.typeSymbol && !(texp instanceof ApplyExp);
                        if (code == -33) {
                            if (toQName) {
                                return this.visitApplyExp(XQParser.castQName(args[1], true), ignored);
                            }
                            func = XQParser.makeFunctionExp("gnu.xquery.util.CastAs", "castAs");
                        }
                        else {
                            if (toQName && args[0] instanceof QuoteExp) {
                                value = ((QuoteExp)args[0]).getValue();
                                try {
                                    QNameUtils.resolveQName(value, this.parser.constructorNamespaces, this.parser.prologNamespaces);
                                    return XQuery.trueExp;
                                }
                                catch (RuntimeException ex2) {
                                    return XQuery.falseExp;
                                }
                            }
                            func = XQParser.makeFunctionExp("gnu.xquery.lang.XQParser", "castableAs");
                        }
                        return new ApplyExp(func, args).setLine(exp);
                    }
                    case -36:
                    case -35: {
                        final Expression[] args = exp.getArgs();
                        final Expression err;
                        if ((err = this.checkArgCount(args, decl, 1, 1)) != null) {
                            return err;
                        }
                        NamespaceBinding constructorNamespaces = this.parser.constructorNamespaces;
                        if (code == -36) {
                            constructorNamespaces = new NamespaceBinding(null, "", constructorNamespaces);
                        }
                        if (args[0] instanceof QuoteExp) {
                            try {
                                Object val = ((QuoteExp)args[0]).getValue();
                                val = QNameUtils.resolveQName(val, constructorNamespaces, this.parser.prologNamespaces);
                                return new QuoteExp(val);
                            }
                            catch (RuntimeException ex) {
                                return this.getCompilation().syntaxError(ex.getMessage());
                            }
                        }
                        final Expression[] xargs = { args[0], new QuoteExp(constructorNamespaces), new QuoteExp(this.parser.prologNamespaces) };
                        final Method meth = ClassType.make("gnu.xquery.util.QNameUtils").getDeclaredMethod("resolveQName", 3);
                        final ApplyExp app = new ApplyExp(meth, xargs);
                        app.setFlag(4);
                        return app;
                    }
                    case -13: {
                        final Expression[] args = exp.getArgs();
                        final Expression err;
                        if ((err = this.checkArgCount(args, decl, 1, 1)) != null) {
                            return err;
                        }
                        if (!(args[0] instanceof QuoteExp)) {
                            final Expression[] xargs2 = { args[0], new QuoteExp(this.parser.constructorNamespaces), new QuoteExp(this.parser.prologNamespaces) };
                            final PrimProcedure pproc = new PrimProcedure(ClassType.make("gnu.xquery.util.QNameUtils").getDeclaredMethod("resolvePrefix", 3));
                            final ApplyExp app2 = new ApplyExp(pproc, xargs2);
                            app2.setFlag(4);
                            return app2;
                        }
                        Object val2 = ((QuoteExp)args[0]).getValue();
                        final String prefix = (val2 == null) ? null : val2.toString();
                        val2 = QNameUtils.lookupPrefix(prefix, this.parser.constructorNamespaces, this.parser.prologNamespaces);
                        if (val2 == null) {
                            return this.getCompilation().syntaxError("unknown namespace prefix '" + prefix + "'");
                        }
                        return new QuoteExp(val2);
                    }
                    case -6: {
                        final Method meth2 = ClassType.make("gnu.xquery.util.NodeUtils").getDeclaredMethod("localName", 1);
                        return this.withContext(meth2, exp.getArgs(), "fn:local-name", 0);
                    }
                    case -24: {
                        final Method meth2 = ClassType.make("gnu.xquery.util.NodeUtils").getDeclaredMethod("name", 1);
                        return this.withContext(meth2, exp.getArgs(), "fn:name", 0);
                    }
                    case -28: {
                        final Method meth2 = ClassType.make("gnu.xquery.util.NumberValue").getDeclaredMethod("numberValue", 1);
                        return this.withContext(meth2, exp.getArgs(), "fn:number", 0);
                    }
                    case -32: {
                        final Method meth2 = ClassType.make("gnu.xquery.util.NodeUtils").getDeclaredMethod("root", 1);
                        return this.withContext(meth2, exp.getArgs(), "fn:root", 0);
                    }
                    case -11: {
                        final Method meth2 = ClassType.make("gnu.xquery.util.NodeUtils").getDeclaredMethod("baseUri", 1);
                        return this.withContext(meth2, exp.getArgs(), "fn:base-uri", 0);
                    }
                    case -23: {
                        final Method meth2 = ClassType.make("gnu.xquery.util.NodeUtils").getDeclaredMethod("lang", 2);
                        return this.withContext(meth2, exp.getArgs(), "fn:lang", 1);
                    }
                    case -30: {
                        final Method meth2 = ClassType.make("gnu.xquery.util.NodeUtils").getDeclaredMethod("id$X", 3);
                        return this.withContext(meth2, exp.getArgs(), "fn:id", 1);
                    }
                    case -31: {
                        final Method meth2 = ClassType.make("gnu.xquery.util.NodeUtils").getDeclaredMethod("idref", 2);
                        return this.withContext(meth2, exp.getArgs(), "fn:idref", 1);
                    }
                    case -14: {
                        final Expression[] args = exp.getArgs();
                        final Expression err;
                        if ((err = this.checkArgCount(args, decl, 0, 0)) != null) {
                            return err;
                        }
                        return this.getBaseUriExpr();
                    }
                    case -7: {
                        final Method meth2 = ClassType.make("gnu.xquery.util.NodeUtils").getDeclaredMethod("namespaceURI", 1);
                        return this.withContext(meth2, exp.getArgs(), "fn:namespace-uri", 0);
                    }
                    case -17: {
                        final Method meth2 = ClassType.make("gnu.xquery.util.StringUtils").getDeclaredMethod("normalizeSpace", 1);
                        return this.withContext(meth2, exp.getArgs(), "fn:normalize-space", 0);
                    }
                    case -18: {
                        final Expression[] args = exp.getArgs();
                        final Expression err;
                        if ((err = this.checkArgCount(args, decl, 1, 1)) != null) {
                            return err;
                        }
                        return args[0];
                    }
                    case -4: {
                        final Method meth2 = ClassType.make("gnu.xquery.util.StringUtils").getDeclaredMethod("compare", 3);
                        return this.withCollator(meth2, exp.getArgs(), "fn:compare", 2);
                    }
                    case -16: {
                        return this.withContext(ClassType.make("gnu.xml.TextUtils").getDeclaredMethod("asString", 1), exp.getArgs(), "fn:string", 0);
                    }
                    case -15: {
                        final Method meth2 = ClassType.make("gnu.xquery.util.SequenceUtils").getDeclaredMethod("indexOf$X", 4);
                        return this.withCollator(meth2, exp.getArgs(), "fn:index-of", 2);
                    }
                    case -8: {
                        final Expression[] args = exp.getArgs();
                        final ClassType cl = ClassType.make("gnu.xquery.util.NodeUtils");
                        final Method meth3 = cl.getDeclaredMethod("collection", 2);
                        final Expression err;
                        if ((err = this.checkArgCount(args, decl, 0, 1)) != null) {
                            return err;
                        }
                        final Expression base = this.getBaseUriExpr();
                        final Expression uri = (args.length > 0) ? args[0] : QuoteExp.voidExp;
                        return new ApplyExp(meth3, new Expression[] { uri, base });
                    }
                    case -10:
                    case -9: {
                        final Expression[] args = exp.getArgs();
                        final ClassType cl = ClassType.make("gnu.xquery.util.NodeUtils");
                        String mname;
                        if (code == -9) {
                            mname = "docCached";
                            if (XQParser.warnOldVersion && "document".equals(decl.getName())) {
                                this.getCompilation().error('w', "replace 'document' by 'doc'");
                            }
                        }
                        else {
                            mname = "availableCached";
                        }
                        final Method meth = cl.getDeclaredMethod(mname, 2);
                        final Expression err;
                        if ((err = this.checkArgCount(args, decl, 1, 1)) != null) {
                            return err;
                        }
                        final PrimProcedure pproc2 = new PrimProcedure(meth);
                        if (code == -9) {
                            pproc2.setSideEffectFree();
                        }
                        final Expression base2 = this.getBaseUriExpr();
                        final ApplyExp aexp = new ApplyExp(pproc2, new Expression[] { args[0], base2 });
                        if (code == -9) {
                            aexp.setType(NodeType.documentNodeTest);
                        }
                        else {
                            aexp.setType(XDataType.booleanType);
                        }
                        return aexp;
                    }
                    case -12: {
                        final Expression[] args = exp.getArgs();
                        final Expression err;
                        if ((err = this.checkArgCount(args, decl, 1, 2)) != null) {
                            return err;
                        }
                        final Expression[] margs = { args[0], null };
                        if (args.length == 1) {
                            margs[1] = this.getBaseUriExpr();
                        }
                        else {
                            margs[1] = args[1];
                        }
                        final Method meth3 = ClassType.make("gnu.xquery.util.QNameUtils").getDeclaredMethod("resolveURI", 2);
                        return new ApplyExp(meth3, margs);
                    }
                    case -5: {
                        final Method meth2 = ClassType.make("gnu.xquery.util.DistinctValues").getDeclaredMethod("distinctValues$X", 3);
                        return this.withCollator(meth2, exp.getArgs(), "fn:distinct-values", 1);
                    }
                    case -25: {
                        final Method meth2 = ClassType.make("gnu.xquery.util.SequenceUtils").getDeclaredMethod("deepEqual", 3);
                        return this.withCollator(meth2, exp.getArgs(), "fn:deep-equal", 2);
                    }
                    case -26: {
                        final Method meth2 = ClassType.make("gnu.xquery.util.MinMax").getDeclaredMethod("min", 2);
                        return this.withCollator(meth2, exp.getArgs(), "fn:min", 1);
                    }
                    case -27: {
                        final Method meth2 = ClassType.make("gnu.xquery.util.MinMax").getDeclaredMethod("max", 2);
                        return this.withCollator(meth2, exp.getArgs(), "fn:max", 1);
                    }
                    case -29: {
                        final Expression err;
                        if ((err = this.checkArgCount(exp.getArgs(), decl, 0, 0)) != null) {
                            return err;
                        }
                        final NamedCollator coll = this.parser.defaultCollator;
                        return QuoteExp.getInstance((coll != null) ? coll.getName() : "http://www.w3.org/2005/xpath-functions/collation/codepoint");
                    }
                    case -3: {
                        final Compilation comp = this.getCompilation();
                        Expression[] args2;
                        int i;
                        Expression pname;
                        String qname;
                        Symbol psymbol;
                        Expression replacement;
                        for (args2 = exp.getArgs(), i = 0; i < args2.length - 1; i += 2) {
                            pname = args2[i];
                            qname = (String)((QuoteExp)pname).getValue();
                            psymbol = this.parser.namespaceResolve(qname, false);
                            if (psymbol != null) {
                                if (psymbol.getNamespaceURI().length() == 0) {
                                    comp.error('e', "pragma name cannot be in the empty namespace");
                                }
                                else {
                                    replacement = this.checkPragma(psymbol, args2[i + 1]);
                                    if (replacement != null) {
                                        return replacement;
                                    }
                                }
                            }
                        }
                        if (i < args2.length) {
                            return args2[args2.length - 1];
                        }
                        final String msg = "no recognized pragma or default in extension expression";
                        this.getMessages().error('e', msg, "XQST0079");
                        return new ErrorExp(msg);
                    }
                }
            }
        }
        proc = exp.getFunctionValue();
        if (!(proc instanceof Type)) {
            if (proc instanceof MakeElement) {
                final MakeElement make = (MakeElement)proc;
                NamespaceBinding nsBindings = make.getNamespaceNodes();
                Symbol tag = make.tag;
                if (tag == null) {
                    tag = MakeElement.getTagName(exp);
                }
                nsBindings = maybeAddNamespace(tag, false, nsBindings);
                final Expression[] args3 = exp.getArgs();
                final Symbol[] attrSyms = new Symbol[args3.length];
                int nattrSyms = 0;
                for (int j = 0; j < args3.length; ++j) {
                    final Expression arg = args3[j];
                    if (arg instanceof ApplyExp) {
                        final ApplyExp app = (ApplyExp)arg;
                        if (app.getFunction() == MakeAttribute.makeAttributeExp) {
                            final Symbol sym2 = MakeElement.getTagName(app);
                            if (sym2 != null) {
                                for (int k = 0; k != nattrSyms; ++k) {
                                    if (sym2.equals(attrSyms[k])) {
                                        this.getCompilation().setLine(app);
                                        final Symbol elementSym = MakeElement.getTagName(exp);
                                        final String elementName = (elementSym == null) ? null : elementSym.toString();
                                        this.messages.error('e', XMLFilter.duplicateAttributeMessage(sym2, elementName), "XQST0040");
                                    }
                                }
                                attrSyms[nattrSyms++] = sym2;
                                nsBindings = maybeAddNamespace(sym2, true, nsBindings);
                            }
                        }
                    }
                }
                if (nsBindings != null) {
                    make.setNamespaceNodes(nsBindings);
                }
            }
            return exp;
        }
        final Expression[] args4 = exp.getArgs();
        if (args4.length != 1) {
            this.messages.error('e', "type constructor requires a single argument");
            return exp;
        }
        return new ApplyExp(XQParser.makeFunctionExp("gnu.xquery.util.CastAs", "castAs"), new Expression[] { exp.getFunction(), args4[0] });
    }
    
    public Expression checkPragma(final Symbol name, final Expression contents) {
        return null;
    }
    
    Expression getBaseUriExpr() {
        final Compilation comp = this.getCompilation();
        final String staticBaseUri = this.parser.getStaticBaseUri();
        if (staticBaseUri != null) {
            return QuoteExp.getInstance(staticBaseUri);
        }
        return GetModuleClass.getModuleClassURI(comp);
    }
    
    static NamespaceBinding maybeAddNamespace(final Symbol qname, final boolean isAttribute, final NamespaceBinding bindings) {
        if (qname == null) {
            return bindings;
        }
        String prefix = qname.getPrefix();
        String uri = qname.getNamespaceURI();
        if (prefix == "") {
            prefix = null;
        }
        if (uri == "") {
            uri = null;
        }
        if (isAttribute && prefix == null && uri == null) {
            return bindings;
        }
        return NamespaceBinding.maybeAdd(prefix, uri, bindings);
    }
    
    static Declaration procToDecl(final Object symbol, final Object val) {
        final Declaration decl = new Declaration(symbol);
        decl.setProcedureDecl(true);
        decl.noteValue(new QuoteExp(val));
        decl.setFlag(16384L);
        return decl;
    }
    
    static {
        handleExtensionDecl = makeBuiltin("(extension)", -3);
        castAsDecl = makeBuiltin("(cast as)", -33);
        castableAsDecl = makeBuiltin("(castable as)", -34);
        lastDecl = makeBuiltin("last", -1);
        xsQNameDecl = makeBuiltin(Symbol.make("http://www.w3.org/2001/XMLSchema", "QName"), -35);
        xsQNameIgnoreDefaultDecl = makeBuiltin(Symbol.make("http://www.w3.org/2001/XMLSchema", "(QName-ignore-default)"), -36);
        staticBaseUriDecl = makeBuiltin("static-base-uri", -14);
        resolvePrefixDecl = makeBuiltin(Symbol.make("http://www.w3.org/2001/XMLSchema", "(resolve-prefix)"), -13);
    }
    
    static class CycleDetector extends ExpExpVisitor<Void>
    {
        Map<Declaration, Integer> depsScanState;
        static final Integer SCANNING;
        static final Integer SCANNED_CYCLE;
        static final Integer SCANNED_NO_CYCLE;
        Declaration target;
        boolean cycleSeen;
        
        CycleDetector() {
            this.depsScanState = new HashMap<Declaration, Integer>();
        }
        
        protected Expression visitReferenceExp(final ReferenceExp exp, final Void ignored) {
            final Declaration decl = exp.getBinding();
            if (decl != null && decl.context instanceof ModuleExp) {
                this.scanDependencies(decl);
            }
            return exp;
        }
        
        public void scanDependencies(final Declaration decl) {
            if (this.target == null) {
                this.target = decl;
            }
            else if (this.target == decl) {
                this.cycleSeen = true;
                return;
            }
            Integer state = this.depsScanState.get(decl);
            if (state != null) {
                if (state == CycleDetector.SCANNING) {
                    this.depsScanState.put(decl, CycleDetector.SCANNED_CYCLE);
                }
                return;
            }
            this.depsScanState.put(decl, CycleDetector.SCANNING);
            final Expression dval = decl.getValue();
            if (dval != null) {
                ((ExpVisitor<Object, D>)this).visit(dval, null);
            }
            state = this.depsScanState.get(decl);
            if (state == CycleDetector.SCANNING) {
                this.depsScanState.put(decl, CycleDetector.SCANNED_NO_CYCLE);
            }
        }
        
        public static boolean scanVariable(final Declaration decl) {
            final CycleDetector cycleDetector = new CycleDetector();
            cycleDetector.scanDependencies(decl);
            return cycleDetector.cycleSeen;
        }
        
        static {
            SCANNING = 0;
            SCANNED_CYCLE = 1;
            SCANNED_NO_CYCLE = -1;
        }
    }
}
