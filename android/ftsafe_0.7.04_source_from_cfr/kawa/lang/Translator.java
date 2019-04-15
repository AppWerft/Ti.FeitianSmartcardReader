/*
 * Decompiled with CFR 0.139.
 */
package kawa.lang;

import gnu.bytecode.ArrayClassLoader;
import gnu.bytecode.ArrayType;
import gnu.bytecode.ClassType;
import gnu.bytecode.Field;
import gnu.bytecode.Member;
import gnu.bytecode.ObjectType;
import gnu.bytecode.PrimType;
import gnu.bytecode.Type;
import gnu.bytecode.ZipLoader;
import gnu.expr.ApplyExp;
import gnu.expr.BeginExp;
import gnu.expr.ClassExp;
import gnu.expr.CommandCompleter;
import gnu.expr.Compilation;
import gnu.expr.Declaration;
import gnu.expr.ErrorExp;
import gnu.expr.Expression;
import gnu.expr.InlineCalls;
import gnu.expr.Keyword;
import gnu.expr.LambdaExp;
import gnu.expr.LangExp;
import gnu.expr.Language;
import gnu.expr.LetExp;
import gnu.expr.Mangling;
import gnu.expr.ModuleExp;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleManager;
import gnu.expr.NameLookup;
import gnu.expr.PrimProcedure;
import gnu.expr.QuoteExp;
import gnu.expr.ReferenceExp;
import gnu.expr.ScopeExp;
import gnu.expr.Special;
import gnu.expr.ThisExp;
import gnu.kawa.functions.AppendValues;
import gnu.kawa.functions.CompileNamedPart;
import gnu.kawa.functions.GetNamedPart;
import gnu.kawa.functions.MakeSplice;
import gnu.kawa.functions.MultiplyOp;
import gnu.kawa.lispexpr.GenArrayType;
import gnu.kawa.lispexpr.LispLanguage;
import gnu.kawa.reflect.ClassMethods;
import gnu.kawa.reflect.FieldLocation;
import gnu.kawa.reflect.MakeAnnotation;
import gnu.kawa.reflect.SlotGet;
import gnu.kawa.reflect.StaticFieldLocation;
import gnu.kawa.xml.XmlNamespace;
import gnu.lists.EmptyList;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.lists.PairWithPosition;
import gnu.mapping.Environment;
import gnu.mapping.EnvironmentKey;
import gnu.mapping.Location;
import gnu.mapping.LocationEnumeration;
import gnu.mapping.Namespace;
import gnu.mapping.Procedure;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Symbol;
import gnu.mapping.Values;
import gnu.math.DFloNum;
import gnu.math.IntNum;
import gnu.math.Unit;
import gnu.text.Char;
import gnu.text.NamedCharTable;
import gnu.text.SourceLocator;
import gnu.text.SourceMessages;
import gnu.text.StandardNamedChars;
import gnu.xml.NamespaceBinding;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import kawa.lang.AutoloadProcedure;
import kawa.lang.Macro;
import kawa.lang.PatternScope;
import kawa.lang.Quote;
import kawa.lang.Syntax;
import kawa.lang.SyntaxForm;
import kawa.lang.SyntaxForms;
import kawa.lang.TemplateScope;
import kawa.standard.IfFeature;
import kawa.standard.Scheme;
import kawa.standard.begin;
import kawa.standard.define_library;
import kawa.standard.expt;
import kawa.standard.require;

public class Translator
extends Compilation {
    private Environment env;
    public Macro currentMacroDefinition;
    public PatternScope patternScope;
    public Declaration templateScopeDecl;
    Object currentMacroMark = null;
    public Declaration matchArray;
    private Stack<Declaration> renamedAliasStack;
    public Object pendingForm;
    public LambdaExp curMethodLambda;
    public NamespaceBinding xmlElementNamespaces = NamespaceBinding.predefinedXML;
    public static final Declaration getNamedPartDecl;
    private static Expression errorExp;
    Syntax currentSyntax;
    Declaration macroContext;
    static Map<String, String> standardEntities;
    PairWithPosition positionPair;
    ArrayList notedAccess;
    public FormStack formStack = new FormStack(this);
    private ScanContext currentScanContext;

    public Translator(Language language, SourceMessages messages, NameLookup lexical, Environment env) {
        super(language, messages, lexical);
        this.env = env;
    }

    public Translator(Language language, SourceMessages messages, NameLookup lexical) {
        super(language, messages, lexical);
        this.env = Environment.getCurrent();
    }

    @Override
    public final Environment getGlobalEnvironment() {
        return this.env;
    }

    @Override
    public Expression parse(Object input) {
        return this.rewrite(input);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final Expression rewrite_car(Pair pair, SyntaxForm syntax2) {
        if (syntax2 == null || syntax2.getScope() == this.current_scope || pair.getCar() instanceof SyntaxForm) {
            return this.rewrite_car(pair, false);
        }
        ScopeExp save_scope = this.setPushCurrentScope(syntax2.getScope());
        try {
            Expression expression = this.rewrite_car(pair, false);
            return expression;
        }
        finally {
            this.setPopCurrentScope(save_scope);
        }
    }

    public final Expression rewrite_car(Pair pair, boolean function2) {
        Object car = pair.getCar();
        if (pair instanceof PairWithPosition) {
            return this.rewrite_with_position(car, function2, (PairWithPosition)pair);
        }
        return this.rewrite(car, function2);
    }

    public final Expression rewrite_car_for_lookup(Pair pair) {
        Pair pcar;
        Object car = pair.getCar();
        if (car instanceof Pair && (pcar = (Pair)car).getCar() == LispLanguage.quasiquote_sym) {
            Object pos = this.pushPositionOf(pair);
            Expression ret = Quote.quasiQuote.rewrite(pcar.getCdr(), this);
            this.popPositionOf(pos);
            return ret;
        }
        return this.rewrite_car(pair, false);
    }

    public Syntax getCurrentSyntax() {
        return this.currentSyntax;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    Expression apply_rewrite(Syntax syntax2, Pair form) {
        Expression exp;
        exp = errorExp;
        Syntax saveSyntax = this.currentSyntax;
        this.currentSyntax = syntax2;
        try {
            exp = syntax2.rewriteForm(form, this);
        }
        finally {
            this.currentSyntax = saveSyntax;
        }
        return exp;
    }

    static ReferenceExp getOriginalRef(Declaration decl) {
        Expression value;
        if (decl != null && decl.isAlias() && !decl.isIndirectBinding() && (value = decl.getValue()) instanceof ReferenceExp) {
            return (ReferenceExp)value;
        }
        return null;
    }

    public final boolean keywordsAreSelfEvaluating() {
        return ((LispLanguage)this.getLanguage()).keywordsAreSelfEvaluating();
    }

    public final boolean selfEvaluatingSymbol(Object obj) {
        return ((LispLanguage)this.getLanguage()).selfEvaluatingSymbol(obj);
    }

    public final boolean matches(Object form, String literal) {
        return this.matches(form, null, literal);
    }

    public boolean matches(Object form, SyntaxForm syntax2, String literal) {
        ReferenceExp rexp;
        if (syntax2 != null) {
            // empty if block
        }
        if (form instanceof SyntaxForm) {
            form = ((SyntaxForm)form).getDatum();
        }
        if (form instanceof SimpleSymbol && !this.selfEvaluatingSymbol(form) && (rexp = Translator.getOriginalRef(this.lexical.lookup(form, -1))) != null) {
            form = rexp.getSymbol();
        }
        return form instanceof SimpleSymbol && ((Symbol)form).getLocalPart() == literal;
    }

    public boolean matches(Object form, SyntaxForm syntax2, Symbol literal) {
        ReferenceExp rexp;
        if (syntax2 != null) {
            // empty if block
        }
        if (form instanceof SyntaxForm) {
            form = ((SyntaxForm)form).getDatum();
        }
        if (form instanceof SimpleSymbol && !this.selfEvaluatingSymbol(form) && (rexp = Translator.getOriginalRef(this.lexical.lookup(form, -1))) != null) {
            form = rexp.getSymbol();
        }
        return form == literal;
    }

    public Object matchQuoted(Pair pair) {
        if (this.matches(pair.getCar(), "quote") && pair.getCdr() instanceof Pair && (pair = (Pair)pair.getCdr()).getCdr() == LList.Empty) {
            return pair.getCar();
        }
        return null;
    }

    @Override
    public Declaration lookup(Object name, int namespace) {
        Declaration decl = this.lexical.lookup(name, namespace);
        if (decl != null && this.getLanguage().hasNamespace(decl, namespace)) {
            return decl;
        }
        return this.currentModule().lookup(name, this.getLanguage(), namespace);
    }

    public Declaration lookupGlobal(Object name) {
        return this.lookupGlobal(name, -1);
    }

    public Declaration lookupGlobal(Object name, int namespace) {
        ModuleExp module = this.currentModule();
        Declaration decl = module.lookup(name, this.getLanguage(), namespace);
        if (decl == null) {
            decl = module.getNoDefine(name);
            decl.setIndirectBinding(true);
        }
        return decl;
    }

    Syntax check_if_Syntax(Declaration decl) {
        Declaration d = Declaration.followAliases(decl);
        Object obj = null;
        Expression dval = d.getValue();
        if (dval != null && d.getFlag(32768L)) {
            try {
                if (decl.getValue() instanceof ReferenceExp) {
                    Declaration context = ((ReferenceExp)decl.getValue()).contextDecl();
                    if (context != null) {
                        this.macroContext = context;
                    } else if (this.current_scope instanceof TemplateScope) {
                        this.macroContext = ((TemplateScope)this.current_scope).macroContext;
                    }
                } else if (this.current_scope instanceof TemplateScope) {
                    this.macroContext = ((TemplateScope)this.current_scope).macroContext;
                }
                obj = dval.eval(this.env);
            }
            catch (Error ex) {
                throw ex;
            }
            catch (Throwable ex) {
                ex.printStackTrace();
                this.error('e', "unable to evaluate macro for " + decl.getSymbol());
            }
        } else if (decl.getFlag(32768L) && !decl.needsContext()) {
            StaticFieldLocation loc = StaticFieldLocation.make(decl);
            obj = loc.get(null);
        }
        return obj instanceof Syntax ? (Syntax)obj : null;
    }

    public Expression rewrite_pair(Pair p, boolean function2) {
        boolean isNamedPartDecl;
        int cdr_length;
        Expression func;
        Object cdr;
        Object p_car = p.getCar();
        boolean useHelper = true;
        if (p_car instanceof Pair && ((Pair)p_car).getCar() == LispLanguage.splice_sym) {
            func = MakeAnnotation.makeAnnotationMaker(this.rewrite_car((Pair)((Pair)p_car).getCdr(), false));
            useHelper = false;
        } else {
            func = this.rewrite_car(p, true);
        }
        Object proc = null;
        if (func instanceof QuoteExp && (proc = func.valueIfConstant()) instanceof Syntax) {
            return this.apply_rewrite((Syntax)proc, p);
        }
        ReferenceExp ref = null;
        if (func instanceof ReferenceExp) {
            ref = (ReferenceExp)func;
            Declaration decl = ref.getBinding();
            if (decl == null) {
                String name;
                Symbol symbol;
                Object sym = ref.getSymbol();
                if (sym instanceof Symbol && !this.selfEvaluatingSymbol(sym)) {
                    symbol = (Symbol)sym;
                    name = symbol.getName();
                } else {
                    name = sym.toString();
                    symbol = this.env.getSymbol(name);
                }
                proc = this.env.get(symbol, this.getLanguage().hasSeparateFunctionNamespace() ? EnvironmentKey.FUNCTION : null, null);
                if (proc instanceof Syntax) {
                    return this.apply_rewrite((Syntax)proc, p);
                }
                if (proc instanceof AutoloadProcedure) {
                    try {
                        proc = ((AutoloadProcedure)proc).getLoaded();
                    }
                    catch (RuntimeException ex) {
                        proc = null;
                    }
                }
            } else {
                Declaration saveContext = this.macroContext;
                Syntax syntax2 = this.check_if_Syntax(decl);
                if (syntax2 != null) {
                    Expression e = this.apply_rewrite(syntax2, p);
                    this.macroContext = saveContext;
                    return e;
                }
            }
            ref.setProcedureName(true);
            if (this.getLanguage().hasSeparateFunctionNamespace()) {
                func.setFlag(2);
            }
        }
        boolean bl = isNamedPartDecl = func instanceof ReferenceExp && ((ReferenceExp)func).getBinding() == getNamedPartDecl;
        if (isNamedPartDecl) {
            useHelper = false;
        }
        if ((cdr_length = Translator.listLength(cdr = p.getCdr())) < 0) {
            return this.syntaxError("improper list (circular or dotted) is not allowed here");
        }
        Expression applyFunction = useHelper ? this.applyFunction(func) : null;
        Stack<Expression> vec = new Stack<Expression>();
        if (applyFunction != null) {
            vec.add(func);
            func = applyFunction;
        }
        ScopeExp save_scope = this.current_scope;
        int first_keyword = -1;
        int last_keyword = -1;
        int firstSpliceArg = -1;
        int i = 0;
        while (cdr != LList.Empty) {
            Expression arg;
            if (cdr instanceof SyntaxForm) {
                SyntaxForm sf = (SyntaxForm)cdr;
                cdr = sf.getDatum();
                if (this.current_scope == save_scope) {
                    this.lexical.pushSaveTopLevelRedefs();
                }
                this.setCurrentScope(sf.getScope());
            }
            Object save_pos = this.pushPositionOf(cdr);
            Pair cdr_pair = (Pair)cdr;
            Object cdr_car = cdr_pair.getCar();
            Object cdr_cdr = cdr_pair.getCdr();
            if (cdr_car instanceof Keyword) {
                if (first_keyword < 0) {
                    first_keyword = i;
                    last_keyword = i - 2;
                }
                if (!this.keywordsAreSelfEvaluating()) {
                    if (i == last_keyword + 1 || i + 1 == cdr_length) {
                        this.error('w', "missing value after unquoted keyword");
                    } else if (i != last_keyword + 2) {
                        this.error('w', "keyword separated from other keyword arguments");
                    }
                }
                last_keyword = i;
                arg = QuoteExp.getInstance(cdr_car, this);
                arg.setFlag(8);
            } else if (cdr_cdr instanceof Pair && ((Pair)cdr_cdr).getCar() == LispLanguage.dots3_sym) {
                LambdaExp dotsLambda = new LambdaExp();
                this.pushScanContext(dotsLambda);
                dotsLambda.body = this.rewrite_car(cdr_pair, false);
                ArrayList<Expression> seqs = this.currentScanContext.sequences;
                int nseqs = seqs.size();
                Expression[] subargs = new Expression[nseqs + 1];
                subargs[0] = dotsLambda;
                for (int j = 0; j < nseqs; ++j) {
                    subargs[j + 1] = (Expression)seqs.get(j);
                }
                arg = new ApplyExp(Scheme.map, subargs);
                arg = new ApplyExp(MakeSplice.quoteInstance, arg);
                this.popScanContext();
                cdr_cdr = ((Pair)cdr_cdr).getCdr();
                if (firstSpliceArg < 0) {
                    firstSpliceArg = i + (applyFunction != null ? 1 : 0);
                }
            } else if (cdr_car instanceof Pair && ((Pair)cdr_car).getCar() == LispLanguage.splice_sym) {
                arg = this.rewrite_car((Pair)((Pair)cdr_car).getCdr(), false);
                arg = new ApplyExp(MakeSplice.quoteInstance, arg);
                if (firstSpliceArg < 0) {
                    firstSpliceArg = i + (applyFunction != null ? 1 : 0);
                }
            } else {
                arg = this.rewrite_car(cdr_pair, false);
            }
            ++i;
            vec.addElement(arg);
            cdr = cdr_cdr;
            this.popPositionOf(save_pos);
        }
        Object[] args = new Expression[vec.size()];
        vec.copyInto(args);
        if (save_scope != this.current_scope) {
            this.setPopCurrentScope(save_scope);
        }
        if (isNamedPartDecl) {
            return this.rewrite_lookup((Expression)args[0], (Expression)args[1], function2);
        }
        ApplyExp app = new ApplyExp(func, (Expression[])args);
        app.firstSpliceArg = firstSpliceArg;
        if (first_keyword >= 0) {
            app.numKeywordArgs = (last_keyword - first_keyword) / 2 + 1;
            app.firstKeywordArgIndex = first_keyword + (applyFunction != null ? 2 : 1);
        }
        return app;
    }

    public Expression rewrite_lookup(Expression part1, Expression part2, boolean function2) {
        Symbol sym = this.namespaceResolve(part1, part2);
        if (sym != null) {
            return this.rewrite((Object)sym, function2);
        }
        return CompileNamedPart.makeExp(part1, part2);
    }

    public Namespace namespaceResolvePrefix(Expression context) {
        if (context instanceof ReferenceExp) {
            Object val;
            ReferenceExp rexp = (ReferenceExp)context;
            Declaration decl = rexp.getBinding();
            if (decl == null || decl.getFlag(65536L)) {
                Object rsym = rexp.getSymbol();
                Symbol sym = rsym instanceof Symbol ? (Symbol)rsym : this.env.getSymbol(rsym.toString());
                val = this.env.get(sym, null);
            } else {
                val = decl.isNamespaceDecl() ? decl.getConstantValue() : null;
            }
            if (val instanceof Namespace) {
                Namespace ns = (Namespace)val;
                String uri = ns.getName();
                if (uri != null && uri.startsWith("class:")) {
                    return null;
                }
                return ns;
            }
        }
        return null;
    }

    public Symbol namespaceResolve(Namespace ns, Expression member) {
        if (ns != null && member instanceof QuoteExp) {
            String mem = ((QuoteExp)member).getValue().toString().intern();
            return ns.getSymbol(mem);
        }
        return null;
    }

    public Symbol namespaceResolve(Expression context, Expression member) {
        return this.namespaceResolve(this.namespaceResolvePrefix(context), member);
    }

    public static Object stripSyntax(Object obj) {
        while (obj instanceof SyntaxForm) {
            obj = ((SyntaxForm)obj).getDatum();
        }
        return obj;
    }

    public static Object safeCar(Object obj) {
        while (obj instanceof SyntaxForm) {
            obj = ((SyntaxForm)obj).getDatum();
        }
        if (!(obj instanceof Pair)) {
            return null;
        }
        return Translator.stripSyntax(((Pair)obj).getCar());
    }

    public static Object safeCdr(Object obj) {
        while (obj instanceof SyntaxForm) {
            obj = ((SyntaxForm)obj).getDatum();
        }
        if (!(obj instanceof Pair)) {
            return null;
        }
        return Translator.stripSyntax(((Pair)obj).getCdr());
    }

    public static int listLength(Object obj) {
        int n = 0;
        Object slow = obj;
        Object fast = obj;
        do {
            if (fast instanceof SyntaxForm) {
                fast = ((SyntaxForm)fast).getDatum();
                continue;
            }
            while (slow instanceof SyntaxForm) {
                slow = ((SyntaxForm)slow).getDatum();
            }
            if (fast == LList.Empty) {
                return n;
            }
            if (!(fast instanceof Pair)) {
                return -1 - n;
            }
            ++n;
            Object next = ((Pair)fast).getCdr();
            while (next instanceof SyntaxForm) {
                next = ((SyntaxForm)next).getDatum();
            }
            if (next == LList.Empty) {
                return n;
            }
            if (!(next instanceof Pair)) {
                return -1 - n;
            }
            slow = ((Pair)slow).getCdr();
            fast = ((Pair)next).getCdr();
            ++n;
            if (fast == slow) break;
        } while (true);
        return Integer.MIN_VALUE;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void rewriteInBody(Object exp) {
        if (exp instanceof SyntaxForm) {
            SyntaxForm sf = (SyntaxForm)exp;
            ScopeExp save_scope = this.setPushCurrentScope(sf.getScope());
            try {
                this.rewriteInBody(sf.getDatum());
            }
            finally {
                this.setPopCurrentScope(save_scope);
            }
        } else if (exp instanceof ValuesFromLList) {
            Object vs = ((ValuesFromLList)exp).values;
            while (vs != LList.Empty) {
                Pair p = (Pair)vs;
                this.pushForm(this.rewrite_car(p, false));
                vs = p.getCdr();
            }
        } else if (exp instanceof Values) {
            Object[] vals = ((Values)exp).getValues();
            for (int i = 0; i < vals.length; ++i) {
                this.rewriteInBody(vals[i]);
            }
        } else {
            this.pushForm(this.rewrite(exp, false));
        }
    }

    public int getCompletions(Environment env, String nameStart, Object property, String namespaceUri, List<? super String> matches) {
        LocationEnumeration e = env.enumerateAllLocations();
        int count = 0;
        while (e.hasMoreElements()) {
            Location loc = e.nextLocation();
            Symbol sym = loc.getKeySymbol();
            String local = sym == null ? null : sym.getLocalPart();
            if (local == null || !local.startsWith(nameStart) || property != loc.getKeyProperty() || namespaceUri != sym.getNamespaceURI()) continue;
            ++count;
            matches.add(local);
        }
        return count;
    }

    public Object namespaceResolve(Object name) {
        Symbol s;
        Pair p;
        Object prefix = null;
        Expression part2 = null;
        if (name instanceof Pair && Translator.safeCar(p = (Pair)name) == LispLanguage.lookup_sym && p.getCdr() instanceof Pair && (p = (Pair)p.getCdr()).getCdr() instanceof Pair) {
            prefix = this.namespaceResolve(p.getCar());
            if (!(Translator.stripSyntax(prefix) instanceof Symbol)) {
                return name;
            }
            part2 = this.rewrite_car_for_lookup((Pair)p.getCdr());
        } else if (name instanceof Symbol && (s = (Symbol)name).hasUnknownNamespace()) {
            String loc = s.getLocalPart();
            prefix = Symbol.valueOf(s.getPrefix());
            part2 = QuoteExp.getInstance(Symbol.valueOf(s.getLocalPart()));
        }
        if (part2 != null) {
            Expression part1 = this.rewrite(prefix);
            Symbol sym = this.namespaceResolve(part1, part2);
            if (sym != null) {
                return sym;
            }
            String combinedName = CompileNamedPart.combineName(part1, part2);
            if (combinedName != null) {
                return Namespace.EmptyNamespace.getSymbol(combinedName);
            }
        }
        return name;
    }

    public Expression rewrite(Object exp) {
        return this.rewrite(exp, 'N');
    }

    public Expression rewrite(Object exp, boolean function2) {
        return this.rewrite(exp, function2 ? (char)'F' : 'N');
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public Expression rewrite(Object exp, char mode) {
        boolean function2;
        if (exp instanceof SyntaxForm) {
            SyntaxForm sf = (SyntaxForm)exp;
            ScopeExp save_scope = this.setPushCurrentScope(sf.getScope());
            try {
                Expression s;
                Expression expression = s = this.rewrite(sf.getDatum(), mode);
                return expression;
            }
            finally {
                this.setPopCurrentScope(save_scope);
            }
        }
        boolean bl = function2 = mode != 'N';
        if (exp instanceof PairWithPosition) {
            return this.rewrite_with_position(exp, function2, (PairWithPosition)exp);
        }
        if (exp instanceof Pair) {
            return this.rewrite_pair((Pair)exp, function2);
        }
        if (exp instanceof Symbol && !this.selfEvaluatingSymbol(exp)) {
            Declaration cdecl;
            boolean separate;
            Object nameToLookup;
            Declaration decl;
            block50 : {
                int decl_nesting;
                String dname;
                Symbol s = (Symbol)exp;
                int complete = s.getLocalName().indexOf(61698);
                separate = this.getLanguage().hasSeparateFunctionNamespace();
                if (complete >= 0) {
                    ArrayList<String> candidates = new ArrayList<String>();
                    String prefix = s.toString().substring(0, complete);
                    Object property = function2 && separate ? EnvironmentKey.FUNCTION : null;
                    int symspace = function2 ? 2 : 1;
                    this.getCompletions(this.env, prefix, property, s.getNamespaceURI(), candidates);
                    this.lexical.getCompletingSymbols(prefix, symspace, candidates);
                    throw new CommandCompleter(complete, candidates, prefix, prefix.length(), this);
                }
                if (s.hasUnknownNamespace()) {
                    String loc = s.getLocalPart();
                    return this.rewrite_lookup(this.rewrite((Object)Symbol.valueOf(s.getPrefix()), false), QuoteExp.getInstance(Symbol.valueOf(s.getLocalPart())), function2);
                }
                decl = this.lexical.lookup(exp, function2);
                cdecl = null;
                ScopeExp scope = this.current_scope;
                int n = decl_nesting = decl == null ? -1 : ScopeExp.nesting(decl.context);
                if (exp instanceof SimpleSymbol) {
                    dname = exp.toString();
                } else {
                    dname = null;
                    scope = null;
                }
                while (scope != null) {
                    if (scope instanceof LambdaExp && scope.getOuter() instanceof ClassExp && ((LambdaExp)scope).isClassMethod() && mode != 'M') {
                        PrimProcedure[] methods;
                        boolean contextStatic;
                        if (decl_nesting >= ScopeExp.nesting(scope.getOuter())) break;
                        LambdaExp caller = (LambdaExp)scope;
                        ClassExp cexp = (ClassExp)scope.getOuter();
                        ClassType ctype = cexp.getClassType();
                        Member part = SlotGet.lookupMember(ctype, dname, ctype);
                        boolean bl2 = contextStatic = caller == cexp.clinitMethod || caller != cexp.initMethod && caller.nameDecl.isStatic();
                        if (!(part != null ? decl != null && !dname.equals(part.getName()) : (methods = ClassMethods.getMethods(ctype, dname, contextStatic ? (char)'S' : 'V', ctype, this.language)).length == 0)) {
                            ReferenceExp part1 = contextStatic ? new ReferenceExp(((ClassExp)caller.getOuter()).nameDecl) : new ThisExp(caller.firstDecl());
                            return CompileNamedPart.makeExp((Expression)part1, QuoteExp.getInstance(dname));
                        }
                    }
                    scope = scope.getOuter();
                }
                if (decl != null) {
                    nameToLookup = decl.getSymbol();
                    exp = null;
                    ReferenceExp rexp = Translator.getOriginalRef(decl);
                    if (rexp != null && (decl = rexp.getBinding()) == null) {
                        nameToLookup = exp = rexp.getSymbol();
                    }
                } else {
                    nameToLookup = exp;
                }
                Symbol symbol = (Symbol)exp;
                if (decl != null) {
                    if (this.current_scope instanceof TemplateScope && decl.needsContext()) {
                        cdecl = ((TemplateScope)this.current_scope).macroContext;
                    } else if (decl.getFlag(0x100000L) && !decl.isStatic()) {
                        scope = this.currentScope();
                        do {
                            if (scope == null) {
                                throw new Error("internal error: missing " + decl);
                            }
                            if (scope.getOuter() == decl.context) break;
                            scope = scope.getOuter();
                        } while (true);
                        cdecl = scope.firstDecl();
                    }
                } else {
                    Expression e;
                    Location loc = this.env.lookup(symbol, function2 && separate ? EnvironmentKey.FUNCTION : null);
                    if (loc != null) {
                        loc = loc.getBase();
                    }
                    if (loc instanceof FieldLocation) {
                        FieldLocation floc = (FieldLocation)loc;
                        try {
                            decl = floc.getDeclaration();
                            if (!this.inlineOk(null) && decl != getNamedPartDecl && !Translator.isObjectSyntax(floc.getDeclaringClass(), floc.getMemberName())) {
                                decl = null;
                                break block50;
                            }
                            if (this.immediate) {
                                if (!decl.isStatic()) {
                                    cdecl = new Declaration("(module-instance)");
                                    cdecl.setValue(new QuoteExp(floc.getInstance()));
                                }
                                break block50;
                            }
                            if (decl.isStatic()) {
                                ClassLoader floader;
                                Class fclass = floc.getRClass();
                                if (fclass == null || (floader = fclass.getClassLoader()) instanceof ZipLoader || floader instanceof ArrayClassLoader) {
                                    decl = null;
                                }
                                break block50;
                            }
                            decl = null;
                        }
                        catch (Exception ex) {
                            this.error('e', "exception loading '" + exp + "' - " + ex.getMessage());
                            decl = null;
                        }
                    } else if (!(mode == 'M' || loc != null && loc.isBound() || (e = this.checkDefaultBinding(symbol, this)) == null)) {
                        return e;
                    }
                }
            }
            if (decl != null) {
                Field dfield = decl.field;
                if (!function2 && dfield != null && Translator.isObjectSyntax(dfield.getDeclaringClass(), dfield.getName())) {
                    return QuoteExp.getInstance(Object.class);
                }
                if (decl.getContext() instanceof PatternScope) {
                    return this.syntaxError("reference to pattern variable " + decl.getName() + " outside syntax template");
                }
            }
            if (decl == null && function2 && nameToLookup == LispLanguage.lookup_sym) {
                decl = getNamedPartDecl;
            }
            int scanNesting = decl == null ? 0 : decl.getScanNesting();
            ReferenceExp rexp = new ReferenceExp(nameToLookup, decl);
            rexp.setContextDecl(cdecl);
            rexp.setLine(this);
            if (scanNesting > 0) {
                if (this.getScanContext() == null) {
                    this.error('e', "using scan variable " + decl.getName() + " while not in scan context");
                } else {
                    Declaration paramDecl = this.currentScanContext.getLambda().addParameter(null);
                    this.currentScanContext.addSeqExpression(rexp);
                    return new ReferenceExp(paramDecl);
                }
            }
            if (function2 && separate) {
                rexp.setFlag(2);
            }
            return rexp;
        }
        if (exp instanceof LangExp) {
            return this.rewrite(((LangExp)exp).getLangValue(), function2);
        }
        if (exp instanceof Expression) {
            return (Expression)exp;
        }
        if (exp == Special.abstractSpecial) {
            return QuoteExp.abstractExp;
        }
        if (exp == Boolean.TRUE) {
            return QuoteExp.trueExp;
        }
        if (exp == Boolean.FALSE) {
            return QuoteExp.falseExp;
        }
        if (exp == Special.nativeSpecial) {
            return QuoteExp.nativeExp;
        }
        if (exp instanceof Keyword && !this.keywordsAreSelfEvaluating()) {
            this.error('w', "keyword should be quoted if not in argument position");
        }
        return QuoteExp.getInstance(Quote.quote(exp, this), this);
    }

    public Expression checkDefaultBinding(Symbol symbol, Translator tr) {
        char ch0;
        Namespace namespace;
        int len;
        boolean sawAngle;
        String name;
        block57 : {
            Object val;
            namespace = symbol.getNamespace();
            String local = symbol.getLocalPart();
            name = symbol.toString();
            len = name.length();
            if (namespace instanceof XmlNamespace) {
                return this.makeQuoteExp(((XmlNamespace)namespace).get(local));
            }
            String namespaceName = namespace.getName();
            if (namespaceName == LispLanguage.unitNamespace.getName() && (val = Unit.lookup(local)) != null) {
                return this.makeQuoteExp(val);
            }
            if (namespaceName == LispLanguage.entityNamespace.getName()) {
                val = Translator.lookupStandardEntity(local);
                if (val != null) {
                    return this.makeQuoteExp(val);
                }
                tr.error('e', "unknown entity name " + local);
            }
            if ((ch0 = name.charAt(0)) == '@') {
                String rest = name.substring(1);
                Expression classRef = tr.rewrite(Symbol.valueOf(rest));
                return MakeAnnotation.makeAnnotationMaker(classRef);
            }
            if (ch0 == '-' || ch0 == '+' || Character.digit(ch0, 10) >= 0) {
                int i;
                int state = 0;
                for (i = 0; i < len; ++i) {
                    char ch = name.charAt(i);
                    if (Character.digit(ch, 10) >= 0) {
                        state = state < 3 ? 2 : (state < 5 ? 4 : 5);
                        continue;
                    }
                    if ((ch == '+' || ch == '-') && state == 0) {
                        state = 1;
                        continue;
                    }
                    if (ch == '.' && state < 3) {
                        state = 3;
                        continue;
                    }
                    if (ch != 'e' && ch != 'E' || state != 2 && state != 4 || i + 1 >= len) break;
                    int j = i + 1;
                    char next = name.charAt(j);
                    if ((next == '-' || next == '+') && ++j < len) {
                        next = name.charAt(j);
                    }
                    if (Character.digit(next, 10) < 0) break;
                    state = 5;
                    i = j + 1;
                }
                if (i < len && state > 1) {
                    DFloNum num = new DFloNum(name.substring(0, i));
                    boolean div = false;
                    ArrayList<Object> vec = new ArrayList<Object>();
                    while (i < len) {
                        char ch;
                        int unitEnd;
                        if ((ch = name.charAt(i++)) == '*') {
                            if (i == len) break block57;
                            ch = name.charAt(i++);
                        } else if (ch == '/') {
                            if (i == len || div) break block57;
                            div = true;
                            ch = name.charAt(i++);
                        }
                        int unitStart = i - 1;
                        do {
                            if (!Character.isLetter(ch)) {
                                unitEnd = i - 1;
                                if (unitEnd != unitStart) break;
                                break block57;
                            }
                            if (i == len) {
                                unitEnd = i;
                                ch = '1';
                                break;
                            }
                            ch = name.charAt(i++);
                        } while (true);
                        vec.add(name.substring(unitStart, unitEnd));
                        boolean expRequired = false;
                        if (ch == '^') {
                            expRequired = true;
                            if (i == len) break block57;
                            ch = name.charAt(i++);
                        }
                        boolean neg = div;
                        if (ch == '+') {
                            expRequired = true;
                            if (i == len) break block57;
                            ch = name.charAt(i++);
                        } else if (ch == '-') {
                            expRequired = true;
                            if (i == len) break block57;
                            ch = name.charAt(i++);
                            neg = !neg;
                        }
                        int nexp = 0;
                        int exp = 0;
                        do {
                            int dig;
                            if ((dig = Character.digit(ch, 10)) <= 0) {
                                --i;
                                break;
                            }
                            exp = 10 * exp + dig;
                            ++nexp;
                            if (i == len) break;
                            ch = name.charAt(i++);
                        } while (true);
                        if (nexp == 0) {
                            exp = 1;
                            if (expRequired) break block57;
                        }
                        if (neg) {
                            exp = -exp;
                        }
                        vec.add(IntNum.make(exp));
                    }
                    if (i == len) {
                        int nunits = vec.size() >> 1;
                        Expression[] units = new Expression[nunits];
                        for (i = 0; i < nunits; ++i) {
                            String uname = (String)vec.get(2 * i);
                            Symbol usym = LispLanguage.unitNamespace.getSymbol(uname.intern());
                            Expression uref = tr.rewrite(usym);
                            IntNum uexp = (IntNum)vec.get(2 * i + 1);
                            if (uexp.longValue() != 1L) {
                                uref = new ApplyExp(expt.expt, uref, this.makeQuoteExp(uexp));
                            }
                            units[i] = uref;
                        }
                        Expression unit = nunits == 1 ? units[0] : new ApplyExp(MultiplyOp.$St, units);
                        return new ApplyExp(MultiplyOp.$St, this.makeQuoteExp(num), unit);
                    }
                }
            }
        }
        if (len > 2 && ch0 == '<' && name.charAt(len - 1) == '>') {
            name = name.substring(1, len - 1);
            len -= 2;
            sawAngle = true;
        } else {
            sawAngle = false;
        }
        int rank = 0;
        while (len > 2 && name.charAt(len - 2) == '[' && name.charAt(len - 1) == ']') {
            len -= 2;
            ++rank;
        }
        String cname = name;
        if (rank != 0) {
            cname = name.substring(0, len);
        }
        try {
            Class clas;
            Type type = this.getLanguage().getNamedType(cname);
            if (!(rank <= 0 || sawAngle && type != null)) {
                Symbol tsymbol = namespace.getSymbol(cname.intern());
                Expression texp = tr.rewrite((Object)tsymbol, false);
                if (!((texp = InlineCalls.inlineCalls(texp, tr)) instanceof ErrorExp)) {
                    type = tr.getLanguage().getTypeFor(texp);
                }
            }
            if (type != null) {
                while (--rank >= 0) {
                    type = ArrayType.make(type);
                }
                return this.makeQuoteExp(type);
            }
            type = Type.lookupType(cname);
            if (type instanceof PrimType) {
                clas = type.getReflectClass();
            } else {
                ModuleInfo typeInfo;
                Compilation tcomp;
                ModuleManager mmanager;
                if (cname.indexOf(46) < 0) {
                    cname = tr.classPrefix + Mangling.mangleNameIfNeeded(cname);
                }
                if (rank == 0 && (typeInfo = (mmanager = ModuleManager.getInstance()).searchWithClassName(cname)) != null && (tcomp = typeInfo.getCompilation()) != null && tcomp.mainClass != null) {
                    QuoteExp qexp = new QuoteExp(tcomp.mainClass, Type.javalangClassType);
                    qexp.setLocation(this);
                    return qexp;
                }
                clas = ClassType.getContextClass(cname);
            }
            if (clas != null) {
                if (rank > 0) {
                    type = Type.make(clas);
                    while (--rank >= 0) {
                        type = ArrayType.make(type);
                    }
                    clas = type.getReflectClass();
                }
                return this.makeQuoteExp(clas);
            }
        }
        catch (ClassNotFoundException ex) {
            Package pack = ArrayClassLoader.getContextPackage(name);
            if (pack != null) {
                return this.makeQuoteExp(pack);
            }
        }
        catch (NoClassDefFoundError ex) {
            tr.error('w', "error loading class " + cname + " - " + ex.getMessage() + " not found");
        }
        catch (Exception ex) {
            // empty catch block
        }
        if (name.startsWith("array")) {
            int nlen = name.length();
            if (nlen == 5) {
                return this.makeQuoteExp(GenArrayType.generalInstance);
            }
            try {
                rank = Integer.parseInt(name.substring(5));
                if (rank >= 0) {
                    return this.makeQuoteExp(new GenArrayType(rank, Type.objectType));
                }
            }
            catch (Throwable ex) {
                // empty catch block
            }
        }
        return null;
    }

    public static synchronized String lookupStandardEntity(String key) {
        String val;
        if (standardEntities == null) {
            standardEntities = new HashMap<String, String>();
            Char.addNamedChars(standardEntities);
        }
        if ((val = standardEntities.get(key)) != null) {
            return val;
        }
        val = (String)StandardNamedChars.instance.get(key);
        return val;
    }

    public static void setLine(Expression exp, Object location2) {
        if (location2 instanceof SourceLocator) {
            exp.setLocation((SourceLocator)location2);
        }
    }

    public static void setLine(Declaration decl, Object location2) {
        if (location2 instanceof SourceLocator) {
            decl.setLocation((SourceLocator)location2);
        }
    }

    public Object pushPositionOf(Object pos) {
        PairWithPosition pair;
        if (pos instanceof SyntaxForm) {
            pos = ((SyntaxForm)pos).getDatum();
        }
        if (pos instanceof PairWithPosition) {
            pair = (PairWithPosition)pos;
        } else if (pos instanceof SourceLocator) {
            pair = new PairWithPosition((SourceLocator)pos, null, null);
        } else {
            return null;
        }
        PairWithPosition saved = this.positionPair == null || this.positionPair.getFileName() != this.getFileName() || this.positionPair.getLineNumber() != this.getLineNumber() || this.positionPair.getColumnNumber() != this.getColumnNumber() ? new PairWithPosition(this, this, this.positionPair) : this.positionPair;
        this.setLine(pos);
        this.positionPair = pair;
        return saved;
    }

    public void popPositionOf(Object saved) {
        if (saved == null) {
            return;
        }
        this.setLine(saved);
        this.positionPair = (PairWithPosition)saved;
        if (this.positionPair.getCar() == this) {
            this.positionPair = (PairWithPosition)this.positionPair.getCdr();
        }
    }

    public void errorWithPosition(String message, Object form) {
        Object save = this.pushPositionOf(form);
        this.error('e', message);
        this.popPositionOf(save);
    }

    public void errorIfNonEmpty(Object form) {
        if (form != LList.Empty) {
            this.error('e', "invalid improper (dotted) list");
        }
    }

    public void setLineOf(Expression exp) {
        if (exp instanceof QuoteExp) {
            return;
        }
        if (exp.getLineNumber() <= 0) {
            exp.setLocation(this);
        }
    }

    public Type exp2Type(Pair typeSpecPair) {
        return this.exp2Type(typeSpecPair, null, null);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public Type exp2Type(Pair typeSpecPair, Declaration decl, SyntaxForm syntax2) {
        Object saved = this.pushPositionOf(typeSpecPair);
        try {
            Expression texp = this.rewrite_car(typeSpecPair, syntax2);
            if (texp instanceof ErrorExp) {
                Type type = null;
                return type;
            }
            Type type = this.getLanguage().getTypeFor(texp);
            if (type == null) {
                try {
                    Object t = texp.eval(this.env);
                    if (t instanceof Class) {
                        type = Type.make((Class)t);
                    } else if (t instanceof Type) {
                        type = (Type)t;
                    }
                }
                catch (Error ex) {
                    throw ex;
                }
                catch (Throwable ex) {
                    // empty catch block
                }
            }
            if (type == null) {
                if (texp instanceof ReferenceExp) {
                    this.error('e', "unknown type name '" + ((ReferenceExp)texp).getName() + '\'');
                } else {
                    this.error('e', "invalid type spec (must be \"type\" or 'type or <type>)");
                }
                type = Type.errorType;
            }
            if (decl != null) {
                decl.setType(texp, type);
            }
            Type ex = type;
            return ex;
        }
        finally {
            this.popPositionOf(saved);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public Expression rewrite_with_position(Object exp, boolean function2, PairWithPosition pair) {
        Expression result;
        Object saved = this.pushPositionOf(pair);
        try {
            result = exp == pair ? this.rewrite_pair(pair, function2) : this.rewrite(exp, function2);
            this.setLineOf(result);
        }
        finally {
            this.popPositionOf(saved);
        }
        return result;
    }

    public static Object wrapSyntax(Object form, SyntaxForm syntax2) {
        if (syntax2 == null || form instanceof Expression) {
            return form;
        }
        return SyntaxForms.fromDatumIfNeeded(form, syntax2);
    }

    public Values popForms(Pair beforeFirst) {
        Object tail = this.formStack.popTail(beforeFirst);
        if (tail == LList.Empty) {
            return Values.empty;
        }
        return new ValuesFromLList((LList)tail);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void scanForm(Object st, ScopeExp defs2) {
        if (st instanceof SyntaxForm) {
            SyntaxForm sf = (SyntaxForm)st;
            ScopeExp save_scope = this.setPushCurrentScope(sf.getScope());
            try {
                Pair beforeFirst = this.formStack.last;
                this.scanForm(sf.getDatum(), defs2);
                this.pushForm(Translator.wrapSyntax(this.popForms(beforeFirst), sf));
                return;
            }
            finally {
                this.setPopCurrentScope(save_scope);
            }
        }
        if (st instanceof Values) {
            if (st == Values.empty) {
                st = QuoteExp.voidExp;
            } else if (st instanceof ValuesFromLList) {
                Object vs = ((ValuesFromLList)st).values;
                while (vs != LList.Empty) {
                    Pair p = (Pair)vs;
                    Object save = this.pushPositionOf(p);
                    this.scanForm(p.getCar(), defs2);
                    this.popPositionOf(save);
                    vs = p.getCdr();
                }
            } else {
                Object[] vals = ((Values)st).getValues();
                for (int i = 0; i < vals.length; ++i) {
                    this.scanForm(vals[i], defs2);
                }
                return;
            }
        }
        if (st instanceof Pair) {
            Syntax syntax2;
            Pair st_pair;
            Declaration saveContext;
            st_pair = (Pair)st;
            saveContext = this.macroContext;
            syntax2 = null;
            ScopeExp savedScope = this.current_scope;
            Object savedPosition = this.pushPositionOf(st);
            if (st instanceof SourceLocator && defs2.getLineNumber() < 0) {
                defs2.setLocation((SourceLocator)st);
            }
            try {
                Object obj;
                Pair p;
                obj = st_pair.getCar();
                if (obj instanceof SyntaxForm) {
                    SyntaxForm sf = (SyntaxForm)st_pair.getCar();
                    savedScope = this.setPushCurrentScope(sf.getScope());
                    obj = sf.getDatum();
                }
                if (obj instanceof Pair && (p = (Pair)obj).getCar() == LispLanguage.lookup_sym && p.getCdr() instanceof Pair && (p = (Pair)p.getCdr()).getCdr() instanceof Pair) {
                    Expression part1 = this.rewrite(p.getCar());
                    Expression part2 = this.rewrite_car_for_lookup((Pair)p.getCdr());
                    Object value1 = part1.valueIfConstant();
                    Object value2 = part2.valueIfConstant();
                    if (value1 instanceof Class && value2 instanceof Symbol) {
                        try {
                            obj = GetNamedPart.getNamedPart(value1, (Symbol)value2);
                            if (obj instanceof Syntax) {
                                syntax2 = (Syntax)obj;
                            }
                        }
                        catch (Exception ex) {
                            obj = null;
                        }
                    } else {
                        obj = this.namespaceResolve(part1, part2);
                    }
                }
                if (obj instanceof Symbol && !this.selfEvaluatingSymbol(obj)) {
                    Expression func = this.rewrite(obj, 'M');
                    if (func instanceof ReferenceExp) {
                        Declaration decl = ((ReferenceExp)func).getBinding();
                        if (decl != null) {
                            syntax2 = this.check_if_Syntax(decl);
                        } else if ((obj = this.resolve(obj, true)) instanceof Syntax) {
                            syntax2 = (Syntax)obj;
                        }
                    }
                } else if (obj == begin.begin || obj == define_library.define_library_scan) {
                    syntax2 = (Syntax)obj;
                }
            }
            finally {
                if (savedScope != this.current_scope) {
                    this.setPopCurrentScope(savedScope);
                }
                this.popPositionOf(savedPosition);
            }
            if (syntax2 != null) {
                String save_filename = this.getFileName();
                int save_line = this.getLineNumber();
                int save_column = this.getColumnNumber();
                try {
                    this.setLine(st_pair);
                    syntax2.scanForm(st_pair, defs2, this);
                    return;
                }
                finally {
                    this.macroContext = saveContext;
                    this.setLine(save_filename, save_line, save_column);
                }
            }
        }
        this.pushForm(st);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public LList scanBody(Object body, ScopeExp defs2, boolean makeList) {
        LList list = makeList ? LList.Empty : null;
        Pair lastPair = null;
        while (body != LList.Empty) {
            if (body instanceof SyntaxForm) {
                SyntaxForm sf = (SyntaxForm)body;
                ScopeExp save_scope = this.setPushCurrentScope(sf.getScope());
                try {
                    LList lList;
                    Pair first = this.formStack.last;
                    LList f = this.scanBody(sf.getDatum(), defs2, makeList);
                    if (makeList) {
                        f = (LList)SyntaxForms.fromDatumIfNeeded(f, sf);
                        if (lastPair == null) {
                            lList = f;
                            return lList;
                        }
                        lastPair.setCdrBackdoor(f);
                        lList = list;
                        return lList;
                    }
                    this.pushForm(Translator.wrapSyntax(this.popForms(first), sf));
                    lList = null;
                    return lList;
                }
                finally {
                    this.setPopCurrentScope(save_scope);
                }
            }
            if (body instanceof Pair) {
                Pair pair = (Pair)body;
                Pair first = this.formStack.last;
                Object savePos = this.pushPositionOf(pair);
                this.scanForm(pair.getCar(), defs2);
                this.popPositionOf(savePos);
                if (this.getState() == 2 && this.pendingForm != null) {
                    if (pair.getCar() != this.pendingForm) {
                        pair = Translator.makePair(pair, this.pendingForm, pair.getCdr());
                    }
                    this.pendingForm = new Pair(begin.begin, pair);
                    if (makeList) {
                        this.formStack.pushAll(list);
                    }
                    return LList.Empty;
                }
                if (makeList) {
                    Pair last = this.formStack.lastPair();
                    LList nlist = (LList)this.formStack.popTail(first);
                    if (lastPair == null) {
                        list = nlist;
                    } else {
                        lastPair.setCdrBackdoor(nlist);
                    }
                    if (last != first) {
                        lastPair = last;
                    }
                }
                body = pair.getCdr();
                continue;
            }
            this.pushForm(this.syntaxError("body is not a proper list"));
            break;
        }
        return list;
    }

    public static Pair makePair(Pair pair, Object car, Object cdr) {
        if (pair instanceof PairWithPosition) {
            return new PairWithPosition((PairWithPosition)pair, car, cdr);
        }
        return new Pair(car, cdr);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public Expression rewrite_body(Object exp) {
        Object saved = this.pushPositionOf(exp);
        LetExp defs2 = new LetExp();
        defs2.setFlag(2);
        int renamedAliasOldSize = this.renamedAliasCount();
        Pair first = this.formStack.last;
        defs2.setOuter(this.current_scope);
        this.current_scope = defs2;
        try {
            LList list = this.scanBody(exp, defs2, true);
            if (list.isEmpty()) {
                this.pushForm(this.syntaxError("body with no expressions"));
            }
            int ndecls = 0;
            for (Declaration decl = defs2.firstDecl(); decl != null; decl = decl.nextDecl()) {
                if (decl.getFlag(0x10000000L)) continue;
                ++ndecls;
                decl.setInitValue(QuoteExp.undefined_exp);
            }
            this.rewriteBody(list);
            int renamedAliasNewSize = this.renamedAliasCount();
            this.popRenamedAlias(renamedAliasNewSize - renamedAliasOldSize);
            Expression body = this.makeBody(first, null);
            this.setLineOf(body);
            if (ndecls == 0) {
                Expression expression = body;
                return expression;
            }
            defs2.setBody(body);
            this.setLineOf(defs2);
            LetExp letExp = defs2;
            return letExp;
        }
        finally {
            this.pop(defs2);
            this.popPositionOf(saved);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void rewriteBody(LList forms) {
        while (forms != LList.Empty) {
            Pair pair;
            pair = (Pair)forms;
            Object saved = this.pushPositionOf(pair);
            try {
                this.rewriteInBody(pair.getCar());
            }
            finally {
                this.popPositionOf(saved);
            }
            forms = (LList)pair.getCdr();
        }
    }

    protected Expression makeBody(Pair head, ScopeExp scope) {
        Object tail = this.formStack.popTail(head);
        int nforms = LList.length(tail);
        if (nforms == 0) {
            return QuoteExp.voidExp;
        }
        Pair first = (Pair)tail;
        if (nforms == 1) {
            return (Expression)first.getCar();
        }
        Object[] exps = new Expression[nforms];
        first.toArray(exps);
        if (scope instanceof ModuleExp) {
            return new ApplyExp(AppendValues.appendValues, (Expression[])exps);
        }
        return this.makeBody((Expression[])exps);
    }

    public boolean appendBodyValues() {
        return false;
    }

    public Expression makeBody(Expression[] exps) {
        if (this.appendBodyValues()) {
            return new ApplyExp(AppendValues.appendValues, exps);
        }
        return new BeginExp(exps);
    }

    public void noteAccess(Object name, ScopeExp scope) {
        if (this.notedAccess == null) {
            this.notedAccess = new ArrayList();
        }
        this.notedAccess.add(name);
        this.notedAccess.add(scope);
    }

    public void processAccesses() {
        if (this.notedAccess == null) {
            return;
        }
        int sz = this.notedAccess.size();
        ScopeExp saveScope = this.current_scope;
        for (int i = 0; i < sz; i += 2) {
            Declaration decl;
            Object name = this.notedAccess.get(i);
            ScopeExp scope = (ScopeExp)this.notedAccess.get(i + 1);
            if (this.current_scope != scope) {
                if (this.current_scope == saveScope) {
                    this.lexical.pushSaveTopLevelRedefs();
                }
                this.setCurrentScope(scope);
            }
            if ((decl = this.lexical.lookup(name, -1)) == null || decl.getFlag(65536L)) continue;
            decl.getContext().currentLambda().capture(decl);
            decl.setCanRead(true);
            decl.setSimple(false);
            decl.setFlag(524288L);
        }
        if (this.current_scope != saveScope) {
            this.setPopCurrentScope(saveScope);
        }
    }

    public void finishModule(ModuleExp mexp) {
        boolean moduleStatic = mexp.isStatic();
        for (Declaration decl = mexp.firstDecl(); decl != null; decl = decl.nextDecl()) {
            if (decl.getFlag(512L)) {
                String msg1 = "'";
                String msg2 = decl.getFlag(1024L) ? "' exported but never defined" : (decl.getFlag(2048L) ? "' declared static but never defined" : "' declared but never defined");
                this.error('e', decl, msg1, msg2);
            }
            if (mexp.getFlag(32768) || this.generateMainMethod() && !this.immediate) {
                if (decl.getFlag(1024L)) {
                    if (decl.isPrivate()) {
                        if (decl.getFlag(0x1000000L)) {
                            this.error('e', decl, "'", "' is declared both private and exported");
                        }
                        decl.setPrivate(false);
                    }
                } else if (!IfFeature.isProvide(decl)) {
                    decl.setPrivate(true);
                }
            }
            if (moduleStatic) {
                decl.setFlag(2048L);
                continue;
            }
            if ((!mexp.getFlag(131072) || decl.getFlag(2048L)) && Compilation.moduleStatic >= 0 && !mexp.getFlag(262144)) continue;
            decl.setFlag(4096L);
        }
        if (mexp.getFlag(262144)) {
            mexp.setFlag(false, 8388608);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void resolveModule(ModuleExp mexp) {
        ReferenceExp savePos = new ReferenceExp((Object)null);
        int numPending = this.pendingImports == null ? 0 : this.pendingImports.size();
        int i = 0;
        while (i < numPending) {
            ModuleInfo info = (ModuleInfo)this.pendingImports.elementAt(i++);
            ScopeExp defs2 = (ScopeExp)this.pendingImports.elementAt(i++);
            Expression posExp = (Expression)this.pendingImports.elementAt(i++);
            Pair beforeGoal = (Pair)this.pendingImports.elementAt(i++);
            require.DeclSetMapper mapper = (require.DeclSetMapper)this.pendingImports.elementAt(i++);
            if (mexp != defs2) continue;
            savePos.setLine(this);
            this.setLine(posExp);
            Pair beforeImports = this.formStack.last;
            require.importDefinitions(null, info, mapper, this.formStack, defs2, this);
            if (beforeGoal != beforeImports && beforeImports != this.formStack.last) {
                Object firstGoal = beforeGoal.getCdr();
                Object firstImports = beforeImports.getCdr();
                beforeGoal.setCdrBackdoor(firstImports);
                this.formStack.last.setCdrBackdoor(firstGoal);
                beforeImports.setCdrBackdoor(LList.Empty);
                this.formStack.last = beforeImports;
            }
            this.setLine(savePos);
        }
        this.pendingImports = null;
        this.setModule(mexp);
        savePos.setLine(this);
        this.setLine(null, -1, -1);
        Compilation save_comp = Compilation.setSaveCurrent(this);
        try {
            Pair firstForm = this.formStack.getHead();
            this.rewriteBody((LList)this.formStack.popTail(firstForm));
            mexp.body = this.makeBody(firstForm, mexp);
            this.processAccesses();
            if (!this.immediate) {
                this.lexical.pop(mexp);
            }
            for (Declaration decl = mexp.firstDecl(); decl != null; decl = decl.nextDecl()) {
                if (decl.getSymbol() != null || !decl.getFlag(1024L)) continue;
                decl.patchSymbolFromSet();
            }
        }
        finally {
            Compilation.restoreCurrent(save_comp);
            this.setLine(savePos);
        }
    }

    public Declaration makeRenamedAlias(Declaration decl, ScopeExp templateScope) {
        if (templateScope == null) {
            return decl;
        }
        return this.makeRenamedAlias(decl.getSymbol(), decl, templateScope);
    }

    public Declaration makeRenamedAlias(Object name, Declaration decl, ScopeExp templateScope) {
        Declaration alias = new Declaration(name);
        alias.setAlias(true);
        alias.setPrivate(true);
        alias.context = templateScope;
        ReferenceExp ref = new ReferenceExp(decl);
        ref.setDontDereference(true);
        alias.noteValue(ref);
        return alias;
    }

    public void pushRenamedAlias(Declaration alias) {
        Declaration decl = Translator.getOriginalRef(alias).getBinding();
        ScopeExp templateScope = alias.context;
        decl.setSymbol(null);
        Declaration old = templateScope.lookup(alias.getSymbol());
        if (old != null) {
            templateScope.remove(old);
        }
        templateScope.addDeclaration(alias);
        if (this.renamedAliasStack == null) {
            this.renamedAliasStack = new Stack();
        }
        this.renamedAliasStack.push(old);
        this.renamedAliasStack.push(alias);
    }

    public int renamedAliasCount() {
        return this.renamedAliasStack == null ? 0 : this.renamedAliasStack.size() >> 1;
    }

    public void popRenamedAlias(int count) {
        while (--count >= 0) {
            Declaration alias = this.renamedAliasStack.pop();
            ScopeExp templateScope = alias.getContext();
            Declaration decl = Translator.getOriginalRef(alias).getBinding();
            decl.setSymbol(alias.getSymbol());
            templateScope.remove(alias);
            Declaration old = this.renamedAliasStack.pop();
            if (old == null) continue;
            templateScope.addDeclaration(old);
        }
    }

    public Declaration define(Object name, ScopeExp defs2) {
        return this.define(name, (TemplateScope)null, defs2);
    }

    public Declaration define(Object name, SyntaxForm nameSyntax, ScopeExp defs2) {
        return this.define(name, nameSyntax == null ? null : nameSyntax.getScope(), defs2);
    }

    public Declaration define(Object name, TemplateScope templateScope, ScopeExp defs2) {
        ScopeExp scope = templateScope != null ? templateScope : this.currentScope();
        boolean aliasNeeded = scope != defs2;
        Object declName = aliasNeeded ? Symbol.makeUninterned(name.toString()) : name;
        Declaration decl = defs2.getDefine(declName, this);
        if (aliasNeeded) {
            Declaration alias = this.makeRenamedAlias(name, decl, scope);
            if (defs2 instanceof LetExp) {
                this.pushRenamedAlias(alias);
            } else {
                scope.addDeclaration(alias);
            }
        }
        this.push(decl);
        return decl;
    }

    static boolean isObjectSyntax(ClassType declaringClass, String fieldName) {
        return "objectSyntax".equals(fieldName) && "kawa.standard.object".equals(declaringClass.getName());
    }

    public void pushForm(Object value) {
        this.formStack.push(value);
    }

    public ScanContext getScanContext() {
        return this.currentScanContext;
    }

    public void setScanContext(ScanContext ctx) {
        this.currentScanContext = ctx;
    }

    public void pushScanContext(LambdaExp lambda) {
        ScanContext newContext = new ScanContext();
        newContext.outer = this.currentScanContext;
        this.currentScanContext = newContext;
        newContext.lambda = lambda;
    }

    public void popScanContext() {
        this.currentScanContext = this.currentScanContext.outer;
    }

    static {
        String cname = "gnu.kawa.functions.GetNamedPart";
        String fname = "getNamedPart";
        getNamedPartDecl = Declaration.getDeclarationFromStatic(cname, fname);
        LispLanguage.getNamedPartLocation.setDeclaration(getNamedPartDecl);
        errorExp = new ErrorExp("unknown syntax error");
    }

    public static class ScanContext {
        ScanContext outer;
        ArrayList<Expression> sequences = new ArrayList();
        LambdaExp lambda;

        public LambdaExp getLambda() {
            return this.lambda;
        }

        public void addSeqExpression(Expression exp) {
            this.sequences.add(exp);
        }
    }

    public static class ValuesFromLList
    extends Values.FromList<Object> {
        public LList values;

        public ValuesFromLList(LList values) {
            super(values);
            this.values = values;
        }
    }

    public static class FormStack
    extends Pair {
        private Pair last = this;
        SourceLocator sloc;

        public FormStack(SourceLocator sloc) {
            this.sloc = sloc;
            this.cdr = LList.Empty;
        }

        public Pair getHead() {
            return this;
        }

        public Object getFirst() {
            return this.cdr;
        }

        @Override
        public Pair lastPair() {
            return this.last;
        }

        public Object popTail(Pair oldTail) {
            Object r = oldTail.getCdr();
            oldTail.setCdrBackdoor(LList.Empty);
            this.last = oldTail;
            return r;
        }

        public void push(Object value) {
            PairWithPosition pair = new PairWithPosition(this.sloc, value, LList.Empty);
            this.last.setCdrBackdoor(pair);
            this.last = pair;
        }

        public void pushAll(LList values) {
            if (values == LList.Empty) {
                return;
            }
            this.last.setCdrBackdoor(values);
            this.last = ((Pair)values).lastPair();
        }

        public void pushAll(LList values, Pair valuesLast) {
            if (values == LList.Empty) {
                return;
            }
            this.last.setCdrBackdoor(values);
            this.last = valuesLast;
        }

        public void pushAfter(Object value, Pair position) {
            PairWithPosition pair = new PairWithPosition(this.sloc, value, position.getCdr());
            position.setCdrBackdoor(pair);
            if (this.last == position) {
                this.last = pair;
            }
        }
    }

}

