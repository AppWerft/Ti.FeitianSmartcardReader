// 
// Decompiled by Procyon v0.5.36
// 

package kawa.lang;

import gnu.kawa.util.AbstractHashTable;
import kawa.standard.require;
import kawa.standard.IfFeature;
import gnu.expr.BeginExp;
import gnu.kawa.functions.AppendValues;
import gnu.expr.LetExp;
import kawa.standard.define_library;
import kawa.standard.begin;
import gnu.kawa.functions.GetNamedPart;
import gnu.text.StandardNamedChars;
import gnu.text.Char;
import java.util.HashMap;
import gnu.expr.ModuleInfo;
import gnu.kawa.lispexpr.GenArrayType;
import gnu.expr.ModuleManager;
import gnu.expr.Mangling;
import gnu.bytecode.PrimType;
import gnu.bytecode.Type;
import gnu.bytecode.ArrayType;
import gnu.expr.ErrorExp;
import gnu.expr.InlineCalls;
import gnu.kawa.functions.MultiplyOp;
import kawa.standard.expt;
import gnu.math.IntNum;
import gnu.math.DFloNum;
import gnu.math.Unit;
import gnu.kawa.xml.XmlNamespace;
import gnu.bytecode.Field;
import gnu.expr.PrimProcedure;
import gnu.bytecode.Member;
import gnu.bytecode.ClassType;
import gnu.expr.Special;
import gnu.expr.LangExp;
import gnu.bytecode.ArrayClassLoader;
import gnu.bytecode.ZipLoader;
import gnu.kawa.reflect.FieldLocation;
import gnu.expr.ThisExp;
import gnu.kawa.reflect.ClassMethods;
import gnu.bytecode.ObjectType;
import gnu.kawa.reflect.SlotGet;
import gnu.expr.ClassExp;
import gnu.expr.CommandCompleter;
import gnu.mapping.Location;
import gnu.mapping.LocationEnumeration;
import gnu.mapping.Values;
import gnu.mapping.Namespace;
import gnu.kawa.functions.CompileNamedPart;
import java.util.List;
import gnu.kawa.functions.MakeSplice;
import gnu.mapping.Procedure;
import gnu.expr.ApplyExp;
import kawa.standard.Scheme;
import gnu.expr.Keyword;
import gnu.mapping.EnvironmentKey;
import gnu.expr.QuoteExp;
import gnu.kawa.reflect.MakeAnnotation;
import gnu.kawa.reflect.StaticFieldLocation;
import gnu.expr.ModuleExp;
import gnu.lists.LList;
import gnu.mapping.Symbol;
import gnu.mapping.SimpleSymbol;
import gnu.expr.ReferenceExp;
import gnu.kawa.lispexpr.LispLanguage;
import gnu.expr.ScopeExp;
import gnu.lists.Pair;
import gnu.text.SourceLocator;
import gnu.expr.NameLookup;
import gnu.text.SourceMessages;
import gnu.expr.Language;
import java.util.ArrayList;
import gnu.lists.PairWithPosition;
import java.util.Map;
import gnu.expr.Expression;
import gnu.xml.NamespaceBinding;
import gnu.expr.LambdaExp;
import java.util.Stack;
import gnu.expr.Declaration;
import gnu.mapping.Environment;
import gnu.expr.Compilation;

public class Translator extends Compilation
{
    private Environment env;
    public Macro currentMacroDefinition;
    public PatternScope patternScope;
    public Declaration templateScopeDecl;
    Object currentMacroMark;
    public Declaration matchArray;
    private Stack<Declaration> renamedAliasStack;
    public Object pendingForm;
    public LambdaExp curMethodLambda;
    public NamespaceBinding xmlElementNamespaces;
    public static final Declaration getNamedPartDecl;
    private static Expression errorExp;
    Syntax currentSyntax;
    Declaration macroContext;
    static Map<String, String> standardEntities;
    PairWithPosition positionPair;
    ArrayList notedAccess;
    public FormStack formStack;
    private ScanContext currentScanContext;
    
    public Translator(final Language language, final SourceMessages messages, final NameLookup lexical, final Environment env) {
        super(language, messages, lexical);
        this.currentMacroMark = null;
        this.xmlElementNamespaces = NamespaceBinding.predefinedXML;
        this.formStack = new FormStack(this);
        this.env = env;
    }
    
    public Translator(final Language language, final SourceMessages messages, final NameLookup lexical) {
        super(language, messages, lexical);
        this.currentMacroMark = null;
        this.xmlElementNamespaces = NamespaceBinding.predefinedXML;
        this.formStack = new FormStack(this);
        this.env = Environment.getCurrent();
    }
    
    @Override
    public final Environment getGlobalEnvironment() {
        return this.env;
    }
    
    @Override
    public Expression parse(final Object input) {
        return this.rewrite(input);
    }
    
    public final Expression rewrite_car(final Pair pair, final SyntaxForm syntax) {
        if (syntax == null || syntax.getScope() == this.current_scope || pair.getCar() instanceof SyntaxForm) {
            return this.rewrite_car(pair, false);
        }
        final ScopeExp save_scope = this.setPushCurrentScope(syntax.getScope());
        try {
            return this.rewrite_car(pair, false);
        }
        finally {
            this.setPopCurrentScope(save_scope);
        }
    }
    
    public final Expression rewrite_car(final Pair pair, final boolean function) {
        final Object car = pair.getCar();
        if (pair instanceof PairWithPosition) {
            return this.rewrite_with_position(car, function, (PairWithPosition)pair);
        }
        return this.rewrite(car, function);
    }
    
    public final Expression rewrite_car_for_lookup(final Pair pair) {
        final Object car = pair.getCar();
        if (car instanceof Pair) {
            final Pair pcar = (Pair)car;
            if (pcar.getCar() == LispLanguage.quasiquote_sym) {
                final Object pos = this.pushPositionOf(pair);
                final Expression ret = Quote.quasiQuote.rewrite(pcar.getCdr(), this);
                this.popPositionOf(pos);
                return ret;
            }
        }
        return this.rewrite_car(pair, false);
    }
    
    public Syntax getCurrentSyntax() {
        return this.currentSyntax;
    }
    
    Expression apply_rewrite(final Syntax syntax, final Pair form) {
        Expression exp = Translator.errorExp;
        final Syntax saveSyntax = this.currentSyntax;
        this.currentSyntax = syntax;
        try {
            exp = syntax.rewriteForm(form, this);
        }
        finally {
            this.currentSyntax = saveSyntax;
        }
        return exp;
    }
    
    static ReferenceExp getOriginalRef(final Declaration decl) {
        if (decl != null && decl.isAlias() && !decl.isIndirectBinding()) {
            final Expression value = decl.getValue();
            if (value instanceof ReferenceExp) {
                return (ReferenceExp)value;
            }
        }
        return null;
    }
    
    public final boolean keywordsAreSelfEvaluating() {
        return ((LispLanguage)this.getLanguage()).keywordsAreSelfEvaluating();
    }
    
    public final boolean selfEvaluatingSymbol(final Object obj) {
        return ((LispLanguage)this.getLanguage()).selfEvaluatingSymbol(obj);
    }
    
    public final boolean matches(final Object form, final String literal) {
        return this.matches(form, null, literal);
    }
    
    public boolean matches(Object form, final SyntaxForm syntax, final String literal) {
        if (syntax != null) {}
        if (form instanceof SyntaxForm) {
            form = ((SyntaxForm)form).getDatum();
        }
        if (form instanceof SimpleSymbol && !this.selfEvaluatingSymbol(form)) {
            final ReferenceExp rexp = getOriginalRef(this.lexical.lookup(form, -1));
            if (rexp != null) {
                form = rexp.getSymbol();
            }
        }
        return form instanceof SimpleSymbol && ((Symbol)form).getLocalPart() == literal;
    }
    
    public boolean matches(Object form, final SyntaxForm syntax, final Symbol literal) {
        if (syntax != null) {}
        if (form instanceof SyntaxForm) {
            form = ((SyntaxForm)form).getDatum();
        }
        if (form instanceof SimpleSymbol && !this.selfEvaluatingSymbol(form)) {
            final ReferenceExp rexp = getOriginalRef(this.lexical.lookup(form, -1));
            if (rexp != null) {
                form = rexp.getSymbol();
            }
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
    public Declaration lookup(final Object name, final int namespace) {
        final Declaration decl = this.lexical.lookup(name, namespace);
        if (decl != null && this.getLanguage().hasNamespace(decl, namespace)) {
            return decl;
        }
        return this.currentModule().lookup(name, this.getLanguage(), namespace);
    }
    
    public Declaration lookupGlobal(final Object name) {
        return this.lookupGlobal(name, -1);
    }
    
    public Declaration lookupGlobal(final Object name, final int namespace) {
        final ModuleExp module = this.currentModule();
        Declaration decl = module.lookup(name, this.getLanguage(), namespace);
        if (decl == null) {
            decl = module.getNoDefine(name);
            decl.setIndirectBinding(true);
        }
        return decl;
    }
    
    Syntax check_if_Syntax(final Declaration decl) {
        final Declaration d = Declaration.followAliases(decl);
        Object obj = null;
        final Expression dval = d.getValue();
        if (dval != null && d.getFlag(32768L)) {
            try {
                if (decl.getValue() instanceof ReferenceExp) {
                    final Declaration context = ((ReferenceExp)decl.getValue()).contextDecl();
                    if (context != null) {
                        this.macroContext = context;
                    }
                    else if (this.current_scope instanceof TemplateScope) {
                        this.macroContext = ((TemplateScope)this.current_scope).macroContext;
                    }
                }
                else if (this.current_scope instanceof TemplateScope) {
                    this.macroContext = ((TemplateScope)this.current_scope).macroContext;
                }
                obj = dval.eval(this.env);
                return (obj instanceof Syntax) ? ((Syntax)obj) : null;
            }
            catch (Error ex) {
                throw ex;
            }
            catch (Throwable ex2) {
                ex2.printStackTrace();
                this.error('e', "unable to evaluate macro for " + decl.getSymbol());
                return (obj instanceof Syntax) ? ((Syntax)obj) : null;
            }
        }
        if (decl.getFlag(32768L) && !decl.needsContext()) {
            final StaticFieldLocation loc = StaticFieldLocation.make(decl);
            obj = loc.get(null);
        }
        return (obj instanceof Syntax) ? ((Syntax)obj) : null;
    }
    
    public Expression rewrite_pair(final Pair p, final boolean function) {
        final Object p_car = p.getCar();
        boolean useHelper = true;
        Expression func;
        if (p_car instanceof Pair && ((Pair)p_car).getCar() == LispLanguage.splice_sym) {
            func = MakeAnnotation.makeAnnotationMaker(this.rewrite_car((Pair)((Pair)p_car).getCdr(), false));
            useHelper = false;
        }
        else {
            func = this.rewrite_car(p, true);
        }
        Object proc = null;
        if (func instanceof QuoteExp) {
            proc = func.valueIfConstant();
            if (proc instanceof Syntax) {
                return this.apply_rewrite((Syntax)proc, p);
            }
        }
        ReferenceExp ref = null;
        if (func instanceof ReferenceExp) {
            ref = (ReferenceExp)func;
            final Declaration decl = ref.getBinding();
            if (decl == null) {
                final Object sym = ref.getSymbol();
                Symbol symbol;
                if (sym instanceof Symbol && !this.selfEvaluatingSymbol(sym)) {
                    symbol = (Symbol)sym;
                    final String name = symbol.getName();
                }
                else {
                    final String name = sym.toString();
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
            }
            else {
                final Declaration saveContext = this.macroContext;
                final Syntax syntax = this.check_if_Syntax(decl);
                if (syntax != null) {
                    final Expression e = this.apply_rewrite(syntax, p);
                    this.macroContext = saveContext;
                    return e;
                }
            }
            ref.setProcedureName(true);
            if (this.getLanguage().hasSeparateFunctionNamespace()) {
                func.setFlag(2);
            }
        }
        final boolean isNamedPartDecl = func instanceof ReferenceExp && ((ReferenceExp)func).getBinding() == Translator.getNamedPartDecl;
        if (isNamedPartDecl) {
            useHelper = false;
        }
        Object cdr = p.getCdr();
        final int cdr_length = listLength(cdr);
        if (cdr_length < 0) {
            return this.syntaxError("improper list (circular or dotted) is not allowed here");
        }
        final Expression applyFunction = useHelper ? this.applyFunction(func) : null;
        final Stack vec = new Stack();
        if (applyFunction != null) {
            vec.add(func);
            func = applyFunction;
        }
        final ScopeExp save_scope = this.current_scope;
        int first_keyword = -1;
        int last_keyword = -1;
        int firstSpliceArg = -1;
        int i = 0;
        while (cdr != LList.Empty) {
            if (cdr instanceof SyntaxForm) {
                final SyntaxForm sf = (SyntaxForm)cdr;
                cdr = sf.getDatum();
                if (this.current_scope == save_scope) {
                    this.lexical.pushSaveTopLevelRedefs();
                }
                this.setCurrentScope(sf.getScope());
            }
            final Object save_pos = this.pushPositionOf(cdr);
            final Pair cdr_pair = (Pair)cdr;
            final Object cdr_car = cdr_pair.getCar();
            Object cdr_cdr = cdr_pair.getCdr();
            Expression arg;
            if (cdr_car instanceof Keyword) {
                if (first_keyword < 0) {
                    first_keyword = i;
                    last_keyword = i - 2;
                }
                if (!this.keywordsAreSelfEvaluating()) {
                    if (i == last_keyword + 1 || i + 1 == cdr_length) {
                        this.error('w', "missing value after unquoted keyword");
                    }
                    else if (i != last_keyword + 2) {
                        this.error('w', "keyword separated from other keyword arguments");
                    }
                }
                last_keyword = i;
                arg = QuoteExp.getInstance(cdr_car, this);
                arg.setFlag(8);
            }
            else if (cdr_cdr instanceof Pair && ((Pair)cdr_cdr).getCar() == LispLanguage.dots3_sym) {
                final LambdaExp dotsLambda = new LambdaExp();
                this.pushScanContext(dotsLambda);
                dotsLambda.body = this.rewrite_car(cdr_pair, false);
                final List<Expression> seqs = this.currentScanContext.sequences;
                final int nseqs = seqs.size();
                final Expression[] subargs = new Expression[nseqs + 1];
                subargs[0] = dotsLambda;
                for (int j = 0; j < nseqs; ++j) {
                    subargs[j + 1] = seqs.get(j);
                }
                arg = new ApplyExp(Scheme.map, subargs);
                arg = new ApplyExp(MakeSplice.quoteInstance, new Expression[] { arg });
                this.popScanContext();
                cdr_cdr = ((Pair)cdr_cdr).getCdr();
                if (firstSpliceArg < 0) {
                    firstSpliceArg = i + ((applyFunction != null) ? 1 : 0);
                }
            }
            else if (cdr_car instanceof Pair && ((Pair)cdr_car).getCar() == LispLanguage.splice_sym) {
                arg = this.rewrite_car((Pair)((Pair)cdr_car).getCdr(), false);
                arg = new ApplyExp(MakeSplice.quoteInstance, new Expression[] { arg });
                if (firstSpliceArg < 0) {
                    firstSpliceArg = i + ((applyFunction != null) ? 1 : 0);
                }
            }
            else {
                arg = this.rewrite_car(cdr_pair, false);
            }
            ++i;
            vec.addElement(arg);
            cdr = cdr_cdr;
            this.popPositionOf(save_pos);
        }
        final Expression[] args = new Expression[vec.size()];
        vec.copyInto(args);
        if (save_scope != this.current_scope) {
            this.setPopCurrentScope(save_scope);
        }
        if (isNamedPartDecl) {
            return this.rewrite_lookup(args[0], args[1], function);
        }
        final ApplyExp app = new ApplyExp(func, args);
        app.firstSpliceArg = firstSpliceArg;
        if (first_keyword >= 0) {
            app.numKeywordArgs = (last_keyword - first_keyword) / 2 + 1;
            app.firstKeywordArgIndex = first_keyword + ((applyFunction != null) ? 2 : 1);
        }
        return app;
    }
    
    public Expression rewrite_lookup(final Expression part1, final Expression part2, final boolean function) {
        final Symbol sym = this.namespaceResolve(part1, part2);
        if (sym != null) {
            return this.rewrite(sym, function);
        }
        return CompileNamedPart.makeExp(part1, part2);
    }
    
    public Namespace namespaceResolvePrefix(final Expression context) {
        if (context instanceof ReferenceExp) {
            final ReferenceExp rexp = (ReferenceExp)context;
            final Declaration decl = rexp.getBinding();
            Object val;
            if (decl == null || decl.getFlag(65536L)) {
                final Object rsym = rexp.getSymbol();
                final Symbol sym = (Symbol)((rsym instanceof Symbol) ? rsym : this.env.getSymbol(rsym.toString()));
                val = this.env.get(sym, null);
            }
            else if (decl.isNamespaceDecl()) {
                val = decl.getConstantValue();
            }
            else {
                val = null;
            }
            if (val instanceof Namespace) {
                final Namespace ns = (Namespace)val;
                final String uri = ns.getName();
                if (uri != null && uri.startsWith("class:")) {
                    return null;
                }
                return ns;
            }
        }
        return null;
    }
    
    public Symbol namespaceResolve(final Namespace ns, final Expression member) {
        if (ns != null && member instanceof QuoteExp) {
            final String mem = ((QuoteExp)member).getValue().toString().intern();
            return ns.getSymbol(mem);
        }
        return null;
    }
    
    public Symbol namespaceResolve(final Expression context, final Expression member) {
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
        return stripSyntax(((Pair)obj).getCar());
    }
    
    public static Object safeCdr(Object obj) {
        while (obj instanceof SyntaxForm) {
            obj = ((SyntaxForm)obj).getDatum();
        }
        if (!(obj instanceof Pair)) {
            return null;
        }
        return stripSyntax(((Pair)obj).getCdr());
    }
    
    public static int listLength(final Object obj) {
        int n = 0;
        Object slow = obj;
        Object fast = obj;
        while (true) {
            if (fast instanceof SyntaxForm) {
                fast = ((SyntaxForm)fast).getDatum();
            }
            else {
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
                Object next;
                for (next = ((Pair)fast).getCdr(); next instanceof SyntaxForm; next = ((SyntaxForm)next).getDatum()) {}
                if (next == LList.Empty) {
                    return n;
                }
                if (!(next instanceof Pair)) {
                    return -1 - n;
                }
                slow = ((Pair)slow).getCdr();
                fast = ((Pair)next).getCdr();
                ++n;
                if (fast == slow) {
                    return Integer.MIN_VALUE;
                }
                continue;
            }
        }
    }
    
    public void rewriteInBody(final Object exp) {
        if (exp instanceof SyntaxForm) {
            final SyntaxForm sf = (SyntaxForm)exp;
            final ScopeExp save_scope = this.setPushCurrentScope(sf.getScope());
            try {
                this.rewriteInBody(sf.getDatum());
            }
            finally {
                this.setPopCurrentScope(save_scope);
            }
        }
        else if (exp instanceof ValuesFromLList) {
            Pair p;
            for (Object vs = ((ValuesFromLList)exp).values; vs != LList.Empty; vs = p.getCdr()) {
                p = (Pair)vs;
                this.pushForm(this.rewrite_car(p, false));
            }
        }
        else if (exp instanceof Values) {
            final Object[] vals = ((Values)exp).getValues();
            for (int i = 0; i < vals.length; ++i) {
                this.rewriteInBody(vals[i]);
            }
        }
        else {
            this.pushForm(this.rewrite(exp, false));
        }
    }
    
    public int getCompletions(final Environment env, final String nameStart, final Object property, final String namespaceUri, final List<? super String> matches) {
        final LocationEnumeration e = env.enumerateAllLocations();
        int count = 0;
        while (e.hasMoreElements()) {
            final Location loc = e.nextLocation();
            final Symbol sym = loc.getKeySymbol();
            final String local = (sym == null) ? null : sym.getLocalPart();
            if (local != null && local.startsWith(nameStart) && property == loc.getKeyProperty() && namespaceUri == sym.getNamespaceURI()) {
                ++count;
                matches.add(local);
            }
        }
        return count;
    }
    
    public Object namespaceResolve(final Object name) {
        Object prefix = null;
        Expression part2 = null;
        Pair p;
        if (name instanceof Pair && safeCar(p = (Pair)name) == LispLanguage.lookup_sym && p.getCdr() instanceof Pair && (p = (Pair)p.getCdr()).getCdr() instanceof Pair) {
            prefix = this.namespaceResolve(p.getCar());
            if (!(stripSyntax(prefix) instanceof Symbol)) {
                return name;
            }
            part2 = this.rewrite_car_for_lookup((Pair)p.getCdr());
        }
        else if (name instanceof Symbol) {
            final Symbol s = (Symbol)name;
            if (s.hasUnknownNamespace()) {
                final String loc = s.getLocalPart();
                prefix = Symbol.valueOf(s.getPrefix());
                part2 = QuoteExp.getInstance(Symbol.valueOf(s.getLocalPart()));
            }
        }
        if (part2 != null) {
            final Expression part3 = this.rewrite(prefix);
            final Symbol sym = this.namespaceResolve(part3, part2);
            if (sym != null) {
                return sym;
            }
            final String combinedName = CompileNamedPart.combineName(part3, part2);
            if (combinedName != null) {
                return Namespace.EmptyNamespace.getSymbol(combinedName);
            }
        }
        return name;
    }
    
    public Expression rewrite(final Object exp) {
        return this.rewrite(exp, 'N');
    }
    
    public Expression rewrite(final Object exp, final boolean function) {
        return this.rewrite(exp, function ? 'F' : 'N');
    }
    
    public Expression rewrite(Object exp, final char mode) {
        if (exp instanceof SyntaxForm) {
            final SyntaxForm sf = (SyntaxForm)exp;
            final ScopeExp save_scope = this.setPushCurrentScope(sf.getScope());
            try {
                final Expression s = this.rewrite(sf.getDatum(), mode);
                return s;
            }
            finally {
                this.setPopCurrentScope(save_scope);
            }
        }
        final boolean function = mode != 'N';
        if (exp instanceof PairWithPosition) {
            return this.rewrite_with_position(exp, function, (PairWithPosition)exp);
        }
        if (exp instanceof Pair) {
            return this.rewrite_pair((Pair)exp, function);
        }
        if (exp instanceof Symbol && !this.selfEvaluatingSymbol(exp)) {
            final Symbol s2 = (Symbol)exp;
            final int complete = s2.getLocalName().indexOf(61698);
            final boolean separate = this.getLanguage().hasSeparateFunctionNamespace();
            if (complete >= 0) {
                final List<String> candidates = new ArrayList<String>();
                final String prefix = s2.toString().substring(0, complete);
                final Object property = (function && separate) ? EnvironmentKey.FUNCTION : null;
                final int symspace = function ? 2 : 1;
                this.getCompletions(this.env, prefix, property, s2.getNamespaceURI(), candidates);
                this.lexical.getCompletingSymbols(prefix, symspace, candidates);
                throw new CommandCompleter(complete, candidates, prefix, prefix.length(), this);
            }
            if (s2.hasUnknownNamespace()) {
                final String loc = s2.getLocalPart();
                return this.rewrite_lookup(this.rewrite(Symbol.valueOf(s2.getPrefix()), false), QuoteExp.getInstance(Symbol.valueOf(s2.getLocalPart())), function);
            }
            Declaration decl = this.lexical.lookup(exp, function);
            Declaration cdecl = null;
            ScopeExp scope = this.current_scope;
            final int decl_nesting = (decl == null) ? -1 : ScopeExp.nesting(decl.context);
            String dname;
            if (exp instanceof SimpleSymbol) {
                dname = exp.toString();
            }
            else {
                dname = null;
                scope = null;
            }
            while (scope != null) {
                Label_0615: {
                    if (scope instanceof LambdaExp && scope.getOuter() instanceof ClassExp && ((LambdaExp)scope).isClassMethod() && mode != 'M') {
                        if (decl_nesting >= ScopeExp.nesting(scope.getOuter())) {
                            break;
                        }
                        final LambdaExp caller = (LambdaExp)scope;
                        final ClassExp cexp = (ClassExp)scope.getOuter();
                        final ClassType ctype = cexp.getClassType();
                        final Member part = SlotGet.lookupMember(ctype, dname, ctype);
                        final boolean contextStatic = caller == cexp.clinitMethod || (caller != cexp.initMethod && caller.nameDecl.isStatic());
                        if (part == null) {
                            final PrimProcedure[] methods = ClassMethods.getMethods(ctype, dname, contextStatic ? 'S' : 'V', ctype, this.language);
                            if (methods.length == 0) {
                                break Label_0615;
                            }
                        }
                        else if (decl != null && !dname.equals(part.getName())) {
                            break Label_0615;
                        }
                        Expression part2;
                        if (contextStatic) {
                            part2 = new ReferenceExp(((ClassExp)caller.getOuter()).nameDecl);
                        }
                        else {
                            part2 = new ThisExp(caller.firstDecl());
                        }
                        return CompileNamedPart.makeExp(part2, QuoteExp.getInstance(dname));
                    }
                }
                scope = scope.getOuter();
            }
            Object nameToLookup;
            if (decl != null) {
                nameToLookup = decl.getSymbol();
                exp = null;
                final ReferenceExp rexp = getOriginalRef(decl);
                if (rexp != null) {
                    decl = rexp.getBinding();
                    if (decl == null) {
                        exp = (nameToLookup = rexp.getSymbol());
                    }
                }
            }
            else {
                nameToLookup = exp;
            }
            final Symbol symbol = (Symbol)exp;
            Label_1097: {
                if (decl != null) {
                    if (this.current_scope instanceof TemplateScope && decl.needsContext()) {
                        cdecl = ((TemplateScope)this.current_scope).macroContext;
                    }
                    else if (decl.getFlag(1048576L) && !decl.isStatic()) {
                        for (scope = this.currentScope(); scope != null; scope = scope.getOuter()) {
                            if (scope.getOuter() == decl.context) {
                                cdecl = scope.firstDecl();
                                break Label_1097;
                            }
                        }
                        throw new Error("internal error: missing " + decl);
                    }
                }
                else {
                    Location loc2 = this.env.lookup(symbol, (function && separate) ? EnvironmentKey.FUNCTION : null);
                    if (loc2 != null) {
                        loc2 = loc2.getBase();
                    }
                    if (loc2 instanceof FieldLocation) {
                        final FieldLocation floc = (FieldLocation)loc2;
                        try {
                            decl = floc.getDeclaration();
                            if (!this.inlineOk(null) && decl != Translator.getNamedPartDecl && !isObjectSyntax(floc.getDeclaringClass(), floc.getMemberName())) {
                                decl = null;
                            }
                            else if (this.immediate) {
                                if (!decl.isStatic()) {
                                    cdecl = new Declaration("(module-instance)");
                                    cdecl.setValue(new QuoteExp(floc.getInstance()));
                                }
                            }
                            else if (decl.isStatic()) {
                                final Class fclass = floc.getRClass();
                                final ClassLoader floader;
                                if (fclass == null || (floader = fclass.getClassLoader()) instanceof ZipLoader || floader instanceof ArrayClassLoader) {
                                    decl = null;
                                }
                            }
                            else {
                                decl = null;
                            }
                        }
                        catch (Exception ex) {
                            this.error('e', "exception loading '" + exp + "' - " + ex.getMessage());
                            decl = null;
                        }
                    }
                    else if (mode != 'M' && (loc2 == null || !loc2.isBound())) {
                        final Expression e = this.checkDefaultBinding(symbol, this);
                        if (e != null) {
                            return e;
                        }
                    }
                }
            }
            if (decl != null) {
                final Field dfield = decl.field;
                if (!function && dfield != null && isObjectSyntax(dfield.getDeclaringClass(), dfield.getName())) {
                    return QuoteExp.getInstance(Object.class);
                }
                if (decl.getContext() instanceof PatternScope) {
                    return this.syntaxError("reference to pattern variable " + decl.getName() + " outside syntax template");
                }
            }
            if (decl == null && function && nameToLookup == LispLanguage.lookup_sym) {
                decl = Translator.getNamedPartDecl;
            }
            final int scanNesting = (decl == null) ? 0 : decl.getScanNesting();
            final ReferenceExp rexp2 = new ReferenceExp(nameToLookup, decl);
            rexp2.setContextDecl(cdecl);
            rexp2.setLine(this);
            if (scanNesting > 0) {
                if (this.getScanContext() != null) {
                    final Declaration paramDecl = this.currentScanContext.getLambda().addParameter(null);
                    this.currentScanContext.addSeqExpression(rexp2);
                    return new ReferenceExp(paramDecl);
                }
                this.error('e', "using scan variable " + decl.getName() + " while not in scan context");
            }
            if (function && separate) {
                rexp2.setFlag(2);
            }
            return rexp2;
        }
        else {
            if (exp instanceof LangExp) {
                return this.rewrite(((LangExp)exp).getLangValue(), function);
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
    }
    
    public Expression checkDefaultBinding(final Symbol symbol, final Translator tr) {
        final Namespace namespace = symbol.getNamespace();
        final String local = symbol.getLocalPart();
        String name = symbol.toString();
        int len = name.length();
        if (namespace instanceof XmlNamespace) {
            return this.makeQuoteExp(((XmlNamespace)namespace).get(local));
        }
        final String namespaceName = namespace.getName();
        if (namespaceName == LispLanguage.unitNamespace.getName()) {
            final Object val = Unit.lookup(local);
            if (val != null) {
                return this.makeQuoteExp(val);
            }
        }
        if (namespaceName == LispLanguage.entityNamespace.getName()) {
            final Object val = lookupStandardEntity(local);
            if (val != null) {
                return this.makeQuoteExp(val);
            }
            tr.error('e', "unknown entity name " + local);
        }
        final char ch0 = name.charAt(0);
        if (ch0 == '@') {
            final String rest = name.substring(1);
            final Expression classRef = tr.rewrite(Symbol.valueOf(rest));
            return MakeAnnotation.makeAnnotationMaker(classRef);
        }
        Label_1040: {
            if (ch0 == '-' || ch0 == '+' || Character.digit(ch0, 10) >= 0) {
                int state = 0;
                int i;
                for (i = 0; i < len; ++i) {
                    final char ch2 = name.charAt(i);
                    if (Character.digit(ch2, 10) >= 0) {
                        state = ((state < 3) ? 2 : ((state < 5) ? 4 : 5));
                    }
                    else if ((ch2 == '+' || ch2 == '-') && state == 0) {
                        state = 1;
                    }
                    else if (ch2 == '.' && state < 3) {
                        state = 3;
                    }
                    else {
                        if ((ch2 != 'e' && ch2 != 'E') || (state != 2 && state != 4) || i + 1 >= len) {
                            break;
                        }
                        int j = i + 1;
                        char next = name.charAt(j);
                        if ((next == '-' || next == '+') && ++j < len) {
                            next = name.charAt(j);
                        }
                        if (Character.digit(next, 10) < 0) {
                            break;
                        }
                        state = 5;
                        i = j + 1;
                    }
                }
                if (i < len && state > 1) {
                    final DFloNum num = new DFloNum(name.substring(0, i));
                    boolean div = false;
                    final ArrayList vec = new ArrayList();
                Label_0457:
                    while (i < len) {
                        char ch3 = name.charAt(i++);
                        if (ch3 == '*') {
                            if (i == len) {
                                break Label_1040;
                            }
                            ch3 = name.charAt(i++);
                        }
                        else if (ch3 == '/') {
                            if (i == len) {
                                break Label_1040;
                            }
                            if (div) {
                                break Label_1040;
                            }
                            div = true;
                            ch3 = name.charAt(i++);
                        }
                        final int unitStart = i - 1;
                        while (true) {
                            while (Character.isLetter(ch3)) {
                                if (i == len) {
                                    final int unitEnd = i;
                                    ch3 = '1';
                                    vec.add(name.substring(unitStart, unitEnd));
                                    boolean expRequired = false;
                                    if (ch3 == '^') {
                                        expRequired = true;
                                        if (i == len) {
                                            break Label_1040;
                                        }
                                        ch3 = name.charAt(i++);
                                    }
                                    boolean neg = div;
                                    if (ch3 == '+') {
                                        expRequired = true;
                                        if (i == len) {
                                            break Label_1040;
                                        }
                                        ch3 = name.charAt(i++);
                                    }
                                    else if (ch3 == '-') {
                                        expRequired = true;
                                        if (i == len) {
                                            break Label_1040;
                                        }
                                        ch3 = name.charAt(i++);
                                        neg = !neg;
                                    }
                                    int nexp = 0;
                                    int exp = 0;
                                    while (true) {
                                        final int dig = Character.digit(ch3, 10);
                                        if (dig <= 0) {
                                            --i;
                                            break;
                                        }
                                        exp = 10 * exp + dig;
                                        ++nexp;
                                        if (i == len) {
                                            break;
                                        }
                                        ch3 = name.charAt(i++);
                                    }
                                    if (nexp == 0) {
                                        exp = 1;
                                        if (expRequired) {
                                            break Label_1040;
                                        }
                                    }
                                    if (neg) {
                                        exp = -exp;
                                    }
                                    vec.add(IntNum.make(exp));
                                    continue Label_0457;
                                }
                                ch3 = name.charAt(i++);
                            }
                            final int unitEnd = i - 1;
                            if (unitEnd == unitStart) {
                                break Label_1040;
                            }
                            continue;
                        }
                    }
                    if (i == len) {
                        final int nunits = vec.size() >> 1;
                        final Expression[] units = new Expression[nunits];
                        for (i = 0; i < nunits; ++i) {
                            final String uname = vec.get(2 * i);
                            final Symbol usym = LispLanguage.unitNamespace.getSymbol(uname.intern());
                            Expression uref = tr.rewrite(usym);
                            final IntNum uexp = vec.get(2 * i + 1);
                            if (uexp.longValue() != 1L) {
                                uref = new ApplyExp(expt.expt, new Expression[] { uref, this.makeQuoteExp(uexp) });
                            }
                            units[i] = uref;
                        }
                        Expression unit;
                        if (nunits == 1) {
                            unit = units[0];
                        }
                        else {
                            unit = new ApplyExp(MultiplyOp.$St, units);
                        }
                        return new ApplyExp(MultiplyOp.$St, new Expression[] { this.makeQuoteExp(num), unit });
                    }
                }
            }
        }
        boolean sawAngle;
        if (len > 2 && ch0 == '<' && name.charAt(len - 1) == '>') {
            name = name.substring(1, len - 1);
            len -= 2;
            sawAngle = true;
        }
        else {
            sawAngle = false;
        }
        int rank;
        for (rank = 0; len > 2 && name.charAt(len - 2) == '[' && name.charAt(len - 1) == ']'; len -= 2, ++rank) {}
        String cname = name;
        if (rank != 0) {
            cname = name.substring(0, len);
        }
        try {
            Type type = this.getLanguage().getNamedType(cname);
            if (rank > 0 && (!sawAngle || type == null)) {
                final Symbol tsymbol = namespace.getSymbol(cname.intern());
                Expression texp = tr.rewrite(tsymbol, false);
                texp = InlineCalls.inlineCalls(texp, tr);
                if (!(texp instanceof ErrorExp)) {
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
            Class clas;
            if (type instanceof PrimType) {
                clas = type.getReflectClass();
            }
            else {
                if (cname.indexOf(46) < 0) {
                    cname = tr.classPrefix + Mangling.mangleNameIfNeeded(cname);
                }
                if (rank == 0) {
                    final ModuleManager mmanager = ModuleManager.getInstance();
                    final ModuleInfo typeInfo = mmanager.searchWithClassName(cname);
                    if (typeInfo != null) {
                        final Compilation tcomp = typeInfo.getCompilation();
                        if (tcomp != null && tcomp.mainClass != null) {
                            final QuoteExp qexp = new QuoteExp(tcomp.mainClass, Type.javalangClassType);
                            qexp.setLocation(this);
                            return qexp;
                        }
                    }
                }
                clas = ObjectType.getContextClass(cname);
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
        catch (ClassNotFoundException ex2) {
            final Package pack = ArrayClassLoader.getContextPackage(name);
            if (pack != null) {
                return this.makeQuoteExp(pack);
            }
        }
        catch (NoClassDefFoundError ex) {
            tr.error('w', "error loading class " + cname + " - " + ex.getMessage() + " not found");
        }
        catch (Exception ex3) {}
        if (name.startsWith("array")) {
            final int nlen = name.length();
            if (nlen == 5) {
                return this.makeQuoteExp(GenArrayType.generalInstance);
            }
            try {
                rank = Integer.parseInt(name.substring(5));
                if (rank >= 0) {
                    return this.makeQuoteExp(new GenArrayType(rank, Type.objectType));
                }
            }
            catch (Throwable t) {}
        }
        return null;
    }
    
    public static synchronized String lookupStandardEntity(final String key) {
        if (Translator.standardEntities == null) {
            Char.addNamedChars(Translator.standardEntities = new HashMap<String, String>());
        }
        String val = Translator.standardEntities.get(key);
        if (val != null) {
            return val;
        }
        return val = ((AbstractHashTable<Entry, K, String>)StandardNamedChars.instance).get(key);
    }
    
    public static void setLine(final Expression exp, final Object location) {
        if (location instanceof SourceLocator) {
            exp.setLocation((SourceLocator)location);
        }
    }
    
    public static void setLine(final Declaration decl, final Object location) {
        if (location instanceof SourceLocator) {
            decl.setLocation((SourceLocator)location);
        }
    }
    
    public Object pushPositionOf(Object pos) {
        if (pos instanceof SyntaxForm) {
            pos = ((SyntaxForm)pos).getDatum();
        }
        PairWithPosition pair;
        if (pos instanceof PairWithPosition) {
            pair = (PairWithPosition)pos;
        }
        else {
            if (!(pos instanceof SourceLocator)) {
                return null;
            }
            pair = new PairWithPosition((SourceLocator)pos, null, null);
        }
        Object saved;
        if (this.positionPair == null || this.positionPair.getFileName() != this.getFileName() || this.positionPair.getLineNumber() != this.getLineNumber() || this.positionPair.getColumnNumber() != this.getColumnNumber()) {
            saved = new PairWithPosition(this, this, this.positionPair);
        }
        else {
            saved = this.positionPair;
        }
        this.setLine(pos);
        this.positionPair = pair;
        return saved;
    }
    
    public void popPositionOf(final Object saved) {
        if (saved == null) {
            return;
        }
        this.setLine(saved);
        this.positionPair = (PairWithPosition)saved;
        if (this.positionPair.getCar() == this) {
            this.positionPair = (PairWithPosition)this.positionPair.getCdr();
        }
    }
    
    public void errorWithPosition(final String message, final Object form) {
        final Object save = this.pushPositionOf(form);
        this.error('e', message);
        this.popPositionOf(save);
    }
    
    public void errorIfNonEmpty(final Object form) {
        if (form != LList.Empty) {
            this.error('e', "invalid improper (dotted) list");
        }
    }
    
    public void setLineOf(final Expression exp) {
        if (exp instanceof QuoteExp) {
            return;
        }
        if (exp.getLineNumber() <= 0) {
            exp.setLocation(this);
        }
    }
    
    public Type exp2Type(final Pair typeSpecPair) {
        return this.exp2Type(typeSpecPair, null, null);
    }
    
    public Type exp2Type(final Pair typeSpecPair, final Declaration decl, final SyntaxForm syntax) {
        final Object saved = this.pushPositionOf(typeSpecPair);
        try {
            final Expression texp = this.rewrite_car(typeSpecPair, syntax);
            if (texp instanceof ErrorExp) {
                return null;
            }
            Type type = this.getLanguage().getTypeFor(texp);
            if (type == null) {
                try {
                    final Object t = texp.eval(this.env);
                    if (t instanceof Class) {
                        type = Type.make((Class)t);
                    }
                    else if (t instanceof Type) {
                        type = (Type)t;
                    }
                }
                catch (Error ex) {
                    throw ex;
                }
                catch (Throwable t2) {}
            }
            if (type == null) {
                if (texp instanceof ReferenceExp) {
                    this.error('e', "unknown type name '" + ((ReferenceExp)texp).getName() + '\'');
                }
                else {
                    this.error('e', "invalid type spec (must be \"type\" or 'type or <type>)");
                }
                type = Type.errorType;
            }
            if (decl != null) {
                decl.setType(texp, type);
            }
            return type;
        }
        finally {
            this.popPositionOf(saved);
        }
    }
    
    public Expression rewrite_with_position(final Object exp, final boolean function, final PairWithPosition pair) {
        final Object saved = this.pushPositionOf(pair);
        Expression result;
        try {
            if (exp == pair) {
                result = this.rewrite_pair(pair, function);
            }
            else {
                result = this.rewrite(exp, function);
            }
            this.setLineOf(result);
        }
        finally {
            this.popPositionOf(saved);
        }
        return result;
    }
    
    public static Object wrapSyntax(final Object form, final SyntaxForm syntax) {
        if (syntax == null || form instanceof Expression) {
            return form;
        }
        return SyntaxForms.fromDatumIfNeeded(form, syntax);
    }
    
    public Values popForms(final Pair beforeFirst) {
        final Object tail = this.formStack.popTail(beforeFirst);
        if (tail == LList.Empty) {
            return Values.empty;
        }
        return new ValuesFromLList((LList)tail);
    }
    
    public void scanForm(Object st, final ScopeExp defs) {
        if (st instanceof SyntaxForm) {
            final SyntaxForm sf = (SyntaxForm)st;
            final ScopeExp save_scope = this.setPushCurrentScope(sf.getScope());
            try {
                final Pair beforeFirst = this.formStack.last;
                this.scanForm(sf.getDatum(), defs);
                this.pushForm(wrapSyntax(this.popForms(beforeFirst), sf));
                return;
            }
            finally {
                this.setPopCurrentScope(save_scope);
            }
        }
        if (st instanceof Values) {
            if (st == Values.empty) {
                st = QuoteExp.voidExp;
            }
            else {
                if (!(st instanceof ValuesFromLList)) {
                    final Object[] vals = ((Values)st).getValues();
                    for (int i = 0; i < vals.length; ++i) {
                        this.scanForm(vals[i], defs);
                    }
                    return;
                }
                Pair p;
                for (Object vs = ((ValuesFromLList)st).values; vs != LList.Empty; vs = p.getCdr()) {
                    p = (Pair)vs;
                    final Object save = this.pushPositionOf(p);
                    this.scanForm(p.getCar(), defs);
                    this.popPositionOf(save);
                }
            }
        }
        if (st instanceof Pair) {
            final Pair st_pair = (Pair)st;
            final Declaration saveContext = this.macroContext;
            Syntax syntax = null;
            ScopeExp savedScope = this.current_scope;
            final Object savedPosition = this.pushPositionOf(st);
            if (st instanceof SourceLocator && defs.getLineNumber() < 0) {
                defs.setLocation((SourceLocator)st);
            }
            try {
                Object obj = st_pair.getCar();
                if (obj instanceof SyntaxForm) {
                    final SyntaxForm sf2 = (SyntaxForm)st_pair.getCar();
                    savedScope = this.setPushCurrentScope(sf2.getScope());
                    obj = sf2.getDatum();
                }
                Pair p2;
                if (obj instanceof Pair && (p2 = (Pair)obj).getCar() == LispLanguage.lookup_sym && p2.getCdr() instanceof Pair && (p2 = (Pair)p2.getCdr()).getCdr() instanceof Pair) {
                    final Expression part1 = this.rewrite(p2.getCar());
                    final Expression part2 = this.rewrite_car_for_lookup((Pair)p2.getCdr());
                    final Object value1 = part1.valueIfConstant();
                    final Object value2 = part2.valueIfConstant();
                    if (value1 instanceof Class && value2 instanceof Symbol) {
                        try {
                            obj = GetNamedPart.getNamedPart(value1, (Symbol)value2);
                            if (obj instanceof Syntax) {
                                syntax = (Syntax)obj;
                            }
                        }
                        catch (Exception ex) {
                            obj = null;
                        }
                    }
                    else {
                        obj = this.namespaceResolve(part1, part2);
                    }
                }
                if (obj instanceof Symbol && !this.selfEvaluatingSymbol(obj)) {
                    final Expression func = this.rewrite(obj, 'M');
                    if (func instanceof ReferenceExp) {
                        final Declaration decl = ((ReferenceExp)func).getBinding();
                        if (decl != null) {
                            syntax = this.check_if_Syntax(decl);
                        }
                        else {
                            obj = this.resolve(obj, true);
                            if (obj instanceof Syntax) {
                                syntax = (Syntax)obj;
                            }
                        }
                    }
                }
                else if (obj == begin.begin || obj == define_library.define_library_scan) {
                    syntax = (Syntax)obj;
                }
            }
            finally {
                if (savedScope != this.current_scope) {
                    this.setPopCurrentScope(savedScope);
                }
                this.popPositionOf(savedPosition);
            }
            if (syntax != null) {
                final String save_filename = this.getFileName();
                final int save_line = this.getLineNumber();
                final int save_column = this.getColumnNumber();
                try {
                    this.setLine(st_pair);
                    syntax.scanForm(st_pair, defs, this);
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
    
    public LList scanBody(Object body, final ScopeExp defs, final boolean makeList) {
        LList list = makeList ? LList.Empty : null;
        Pair lastPair = null;
        while (body != LList.Empty) {
            if (body instanceof SyntaxForm) {
                final SyntaxForm sf = (SyntaxForm)body;
                final ScopeExp save_scope = this.setPushCurrentScope(sf.getScope());
                try {
                    final Pair first = this.formStack.last;
                    LList f = this.scanBody(sf.getDatum(), defs, makeList);
                    if (!makeList) {
                        this.pushForm(wrapSyntax(this.popForms(first), sf));
                        return null;
                    }
                    f = (LList)SyntaxForms.fromDatumIfNeeded(f, sf);
                    if (lastPair == null) {
                        return f;
                    }
                    lastPair.setCdrBackdoor(f);
                    return list;
                }
                finally {
                    this.setPopCurrentScope(save_scope);
                }
            }
            if (!(body instanceof Pair)) {
                this.pushForm(this.syntaxError("body is not a proper list"));
                break;
            }
            Pair pair = (Pair)body;
            final Pair first2 = this.formStack.last;
            final Object savePos = this.pushPositionOf(pair);
            this.scanForm(pair.getCar(), defs);
            this.popPositionOf(savePos);
            if (this.getState() == 2 && this.pendingForm != null) {
                if (pair.getCar() != this.pendingForm) {
                    pair = makePair(pair, this.pendingForm, pair.getCdr());
                }
                this.pendingForm = new Pair(begin.begin, pair);
                if (makeList) {
                    this.formStack.pushAll(list);
                }
                return LList.Empty;
            }
            if (makeList) {
                final Pair last = this.formStack.lastPair();
                final LList nlist = (LList)this.formStack.popTail(first2);
                if (lastPair == null) {
                    list = nlist;
                }
                else {
                    lastPair.setCdrBackdoor(nlist);
                }
                if (last != first2) {
                    lastPair = last;
                }
            }
            body = pair.getCdr();
        }
        return list;
    }
    
    public static Pair makePair(final Pair pair, final Object car, final Object cdr) {
        if (pair instanceof PairWithPosition) {
            return new PairWithPosition((SourceLocator)pair, car, cdr);
        }
        return new Pair(car, cdr);
    }
    
    public Expression rewrite_body(final Object exp) {
        final Object saved = this.pushPositionOf(exp);
        final LetExp defs = new LetExp();
        defs.setFlag(2);
        final int renamedAliasOldSize = this.renamedAliasCount();
        final Pair first = this.formStack.last;
        defs.setOuter(this.current_scope);
        this.current_scope = defs;
        try {
            final LList list = this.scanBody(exp, defs, true);
            if (list.isEmpty()) {
                this.pushForm(this.syntaxError("body with no expressions"));
            }
            int ndecls = 0;
            for (Declaration decl = defs.firstDecl(); decl != null; decl = decl.nextDecl()) {
                if (!decl.getFlag(268435456L)) {
                    ++ndecls;
                    decl.setInitValue(QuoteExp.undefined_exp);
                }
            }
            this.rewriteBody(list);
            final int renamedAliasNewSize = this.renamedAliasCount();
            this.popRenamedAlias(renamedAliasNewSize - renamedAliasOldSize);
            final Expression body = this.makeBody(first, null);
            this.setLineOf(body);
            if (ndecls == 0) {
                return body;
            }
            defs.setBody(body);
            this.setLineOf(defs);
            return defs;
        }
        finally {
            this.pop(defs);
            this.popPositionOf(saved);
        }
    }
    
    protected void rewriteBody(LList forms) {
        while (forms != LList.Empty) {
            final Pair pair = (Pair)forms;
            final Object saved = this.pushPositionOf(pair);
            try {
                this.rewriteInBody(pair.getCar());
            }
            finally {
                this.popPositionOf(saved);
            }
            forms = (LList)pair.getCdr();
        }
    }
    
    protected Expression makeBody(final Pair head, final ScopeExp scope) {
        final Object tail = this.formStack.popTail(head);
        final int nforms = LList.length(tail);
        if (nforms == 0) {
            return QuoteExp.voidExp;
        }
        final Pair first = (Pair)tail;
        if (nforms == 1) {
            return (Expression)first.getCar();
        }
        final Expression[] exps = new Expression[nforms];
        first.toArray(exps);
        if (scope instanceof ModuleExp) {
            return new ApplyExp(AppendValues.appendValues, exps);
        }
        return this.makeBody(exps);
    }
    
    public boolean appendBodyValues() {
        return false;
    }
    
    public Expression makeBody(final Expression[] exps) {
        if (this.appendBodyValues()) {
            return new ApplyExp(AppendValues.appendValues, exps);
        }
        return new BeginExp(exps);
    }
    
    public void noteAccess(final Object name, final ScopeExp scope) {
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
        final int sz = this.notedAccess.size();
        final ScopeExp saveScope = this.current_scope;
        for (int i = 0; i < sz; i += 2) {
            final Object name = this.notedAccess.get(i);
            final ScopeExp scope = this.notedAccess.get(i + 1);
            if (this.current_scope != scope) {
                if (this.current_scope == saveScope) {
                    this.lexical.pushSaveTopLevelRedefs();
                }
                this.setCurrentScope(scope);
            }
            final Declaration decl = this.lexical.lookup(name, -1);
            if (decl != null && !decl.getFlag(65536L)) {
                decl.getContext().currentLambda().capture(decl);
                decl.setCanRead(true);
                decl.setSimple(false);
                decl.setFlag(524288L);
            }
        }
        if (this.current_scope != saveScope) {
            this.setPopCurrentScope(saveScope);
        }
    }
    
    public void finishModule(final ModuleExp mexp) {
        final boolean moduleStatic = mexp.isStatic();
        for (Declaration decl = mexp.firstDecl(); decl != null; decl = decl.nextDecl()) {
            if (decl.getFlag(512L)) {
                final String msg1 = "'";
                final String msg2 = decl.getFlag(1024L) ? "' exported but never defined" : (decl.getFlag(2048L) ? "' declared static but never defined" : "' declared but never defined");
                this.error('e', decl, msg1, msg2);
            }
            if (mexp.getFlag(32768) || (this.generateMainMethod() && !this.immediate)) {
                if (decl.getFlag(1024L)) {
                    if (decl.isPrivate()) {
                        if (decl.getFlag(16777216L)) {
                            this.error('e', decl, "'", "' is declared both private and exported");
                        }
                        decl.setPrivate(false);
                    }
                }
                else if (!IfFeature.isProvide(decl)) {
                    decl.setPrivate(true);
                }
            }
            if (moduleStatic) {
                decl.setFlag(2048L);
            }
            else if ((mexp.getFlag(131072) && !decl.getFlag(2048L)) || Compilation.moduleStatic < 0 || mexp.getFlag(262144)) {
                decl.setFlag(4096L);
            }
        }
        if (mexp.getFlag(262144)) {
            mexp.setFlag(false, 8388608);
        }
    }
    
    public void resolveModule(final ModuleExp mexp) {
        final Expression savePos = new ReferenceExp((Object)null);
        final int numPending = (this.pendingImports == null) ? 0 : this.pendingImports.size();
        int i = 0;
        while (i < numPending) {
            final ModuleInfo info = this.pendingImports.elementAt(i++);
            final ScopeExp defs = this.pendingImports.elementAt(i++);
            final Expression posExp = this.pendingImports.elementAt(i++);
            final Pair beforeGoal = this.pendingImports.elementAt(i++);
            final require.DeclSetMapper mapper = this.pendingImports.elementAt(i++);
            if (mexp == defs) {
                savePos.setLine(this);
                this.setLine(posExp);
                final Pair beforeImports = this.formStack.last;
                require.importDefinitions(null, info, mapper, this.formStack, defs, this);
                if (beforeGoal != beforeImports && beforeImports != this.formStack.last) {
                    final Object firstGoal = beforeGoal.getCdr();
                    final Object firstImports = beforeImports.getCdr();
                    beforeGoal.setCdrBackdoor(firstImports);
                    this.formStack.last.setCdrBackdoor(firstGoal);
                    beforeImports.setCdrBackdoor(LList.Empty);
                    this.formStack.last = beforeImports;
                }
                this.setLine(savePos);
            }
        }
        this.pendingImports = null;
        this.setModule(mexp);
        savePos.setLine(this);
        this.setLine(null, -1, -1);
        final Compilation save_comp = Compilation.setSaveCurrent(this);
        try {
            final Pair firstForm = this.formStack.getHead();
            this.rewriteBody((LList)this.formStack.popTail(firstForm));
            mexp.body = this.makeBody(firstForm, mexp);
            this.processAccesses();
            if (!this.immediate) {
                this.lexical.pop(mexp);
            }
            for (Declaration decl = mexp.firstDecl(); decl != null; decl = decl.nextDecl()) {
                if (decl.getSymbol() == null && decl.getFlag(1024L)) {
                    decl.patchSymbolFromSet();
                }
            }
        }
        finally {
            Compilation.restoreCurrent(save_comp);
            this.setLine(savePos);
        }
    }
    
    public Declaration makeRenamedAlias(final Declaration decl, final ScopeExp templateScope) {
        if (templateScope == null) {
            return decl;
        }
        return this.makeRenamedAlias(decl.getSymbol(), decl, templateScope);
    }
    
    public Declaration makeRenamedAlias(final Object name, final Declaration decl, final ScopeExp templateScope) {
        final Declaration alias = new Declaration(name);
        alias.setAlias(true);
        alias.setPrivate(true);
        alias.context = templateScope;
        final ReferenceExp ref = new ReferenceExp(decl);
        ref.setDontDereference(true);
        alias.noteValue(ref);
        return alias;
    }
    
    public void pushRenamedAlias(final Declaration alias) {
        final Declaration decl = getOriginalRef(alias).getBinding();
        final ScopeExp templateScope = alias.context;
        decl.setSymbol(null);
        final Declaration old = templateScope.lookup(alias.getSymbol());
        if (old != null) {
            templateScope.remove(old);
        }
        templateScope.addDeclaration(alias);
        if (this.renamedAliasStack == null) {
            this.renamedAliasStack = new Stack<Declaration>();
        }
        this.renamedAliasStack.push(old);
        this.renamedAliasStack.push(alias);
    }
    
    public int renamedAliasCount() {
        return (this.renamedAliasStack == null) ? 0 : (this.renamedAliasStack.size() >> 1);
    }
    
    public void popRenamedAlias(int count) {
        while (--count >= 0) {
            final Declaration alias = this.renamedAliasStack.pop();
            final ScopeExp templateScope = alias.getContext();
            final Declaration decl = getOriginalRef(alias).getBinding();
            decl.setSymbol(alias.getSymbol());
            templateScope.remove(alias);
            final Declaration old = this.renamedAliasStack.pop();
            if (old != null) {
                templateScope.addDeclaration(old);
            }
        }
    }
    
    public Declaration define(final Object name, final ScopeExp defs) {
        return this.define(name, (TemplateScope)null, defs);
    }
    
    public Declaration define(final Object name, final SyntaxForm nameSyntax, final ScopeExp defs) {
        return this.define(name, (nameSyntax == null) ? null : nameSyntax.getScope(), defs);
    }
    
    public Declaration define(final Object name, final TemplateScope templateScope, final ScopeExp defs) {
        final ScopeExp scope = (templateScope != null) ? templateScope : this.currentScope();
        final boolean aliasNeeded = scope != defs;
        final Object declName = aliasNeeded ? Symbol.makeUninterned(name.toString()) : name;
        final Declaration decl = defs.getDefine(declName, this);
        if (aliasNeeded) {
            final Declaration alias = this.makeRenamedAlias(name, decl, scope);
            if (defs instanceof LetExp) {
                this.pushRenamedAlias(alias);
            }
            else {
                scope.addDeclaration(alias);
            }
        }
        this.push(decl);
        return decl;
    }
    
    static boolean isObjectSyntax(final ClassType declaringClass, final String fieldName) {
        return "objectSyntax".equals(fieldName) && "kawa.standard.object".equals(declaringClass.getName());
    }
    
    public void pushForm(final Object value) {
        this.formStack.push(value);
    }
    
    public ScanContext getScanContext() {
        return this.currentScanContext;
    }
    
    public void setScanContext(final ScanContext ctx) {
        this.currentScanContext = ctx;
    }
    
    public void pushScanContext(final LambdaExp lambda) {
        final ScanContext newContext = new ScanContext();
        newContext.outer = this.currentScanContext;
        this.currentScanContext = newContext;
        newContext.lambda = lambda;
    }
    
    public void popScanContext() {
        this.currentScanContext = this.currentScanContext.outer;
    }
    
    static {
        final String cname = "gnu.kawa.functions.GetNamedPart";
        final String fname = "getNamedPart";
        getNamedPartDecl = Declaration.getDeclarationFromStatic(cname, fname);
        LispLanguage.getNamedPartLocation.setDeclaration(Translator.getNamedPartDecl);
        Translator.errorExp = new ErrorExp("unknown syntax error");
    }
    
    public static class FormStack extends Pair
    {
        private Pair last;
        SourceLocator sloc;
        
        public FormStack(final SourceLocator sloc) {
            this.last = this;
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
        
        public Object popTail(final Pair oldTail) {
            final Object r = oldTail.getCdr();
            oldTail.setCdrBackdoor(LList.Empty);
            this.last = oldTail;
            return r;
        }
        
        public void push(final Object value) {
            final Pair pair = new PairWithPosition(this.sloc, value, LList.Empty);
            this.last.setCdrBackdoor(pair);
            this.last = pair;
        }
        
        public void pushAll(final LList values) {
            if (values == LList.Empty) {
                return;
            }
            this.last.setCdrBackdoor(values);
            this.last = ((Pair)values).lastPair();
        }
        
        public void pushAll(final LList values, final Pair valuesLast) {
            if (values == LList.Empty) {
                return;
            }
            this.last.setCdrBackdoor(values);
            this.last = valuesLast;
        }
        
        public void pushAfter(final Object value, final Pair position) {
            final Pair pair = new PairWithPosition(this.sloc, value, position.getCdr());
            position.setCdrBackdoor(pair);
            if (this.last == position) {
                this.last = pair;
            }
        }
    }
    
    public static class ValuesFromLList extends FromList<Object>
    {
        public LList values;
        
        public ValuesFromLList(final LList values) {
            super(values);
            this.values = values;
        }
    }
    
    public static class ScanContext
    {
        ScanContext outer;
        ArrayList<Expression> sequences;
        LambdaExp lambda;
        
        public ScanContext() {
            this.sequences = new ArrayList<Expression>();
        }
        
        public LambdaExp getLambda() {
            return this.lambda;
        }
        
        public void addSeqExpression(final Expression exp) {
            this.sequences.add(exp);
        }
    }
}
