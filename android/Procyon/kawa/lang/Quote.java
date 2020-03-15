// 
// Decompiled by Procyon v0.5.36
// 

package kawa.lang;

import gnu.expr.ErrorExp;
import gnu.kawa.functions.MakeSplice;
import gnu.lists.FVector;
import java.util.Vector;
import gnu.kawa.functions.CompileNamedPart;
import gnu.mapping.SimpleSymbol;
import gnu.expr.ApplyExp;
import gnu.lists.LList;
import gnu.kawa.lispexpr.LispLanguage;
import gnu.mapping.Symbol;
import gnu.mapping.Namespace;
import gnu.expr.QuoteExp;
import gnu.expr.Expression;
import gnu.expr.Compilation;
import java.util.IdentityHashMap;
import gnu.lists.Pair;
import gnu.bytecode.Method;
import gnu.bytecode.ClassType;

public class Quote extends Syntax
{
    public static final Quote plainQuote;
    public static final Quote quasiQuote;
    protected static final int QUOTE_DEPTH = -1;
    protected boolean isQuasi;
    private static final Object WORKING;
    private static final Object SHARED;
    static final ClassType quoteType;
    static final Method consXMethod;
    static final Method appendMethod;
    static final Method makePairMethod;
    static final Method makeVectorMethod;
    
    public Quote(final String name, final boolean isQuasi) {
        super(name);
        this.isQuasi = isQuasi;
    }
    
    protected boolean matchesUnquote(final Pair pair, final SyntaxForm syntax, final Translator tr) {
        return tr.matches(pair.getCar(), syntax, "unquote");
    }
    
    protected boolean matchesUnquoteSplicing(final Pair pair, final SyntaxForm syntax, final Translator tr) {
        return tr.matches(pair.getCar(), syntax, "unquote-splicing");
    }
    
    protected boolean matchesQuasiQuote(final Object form, final SyntaxForm syntax, final Translator tr) {
        return tr.matches(form, syntax, "quasiquote");
    }
    
    protected Object expand(final Object template, final int depth, final Translator tr) {
        final IdentityHashMap seen = new IdentityHashMap();
        return this.expand(template, depth, null, seen, tr);
    }
    
    public static Object quote(final Object obj, final Translator tr) {
        return Quote.plainQuote.expand(obj, -1, tr);
    }
    
    public static Object quote(final Object obj) {
        return Quote.plainQuote.expand(obj, -1, (Translator)Compilation.getCurrent());
    }
    
    protected Expression coerceExpression(final Object val, final Translator tr) {
        return (Expression)((val instanceof Expression) ? val : this.leaf(val, tr));
    }
    
    protected Expression leaf(final Object val, final Translator tr) {
        return new QuoteExp(val);
    }
    
    protected boolean expandColonForms() {
        return true;
    }
    
    public static Symbol makeSymbol(final Namespace ns, final Object local) {
        String name;
        if (local instanceof CharSequence) {
            name = ((CharSequence)local).toString();
        }
        else {
            name = (String)local;
        }
        return ns.getSymbol(name.intern());
    }
    
    Object expand_pair(final Pair list, int depth, final SyntaxForm syntax, final Object seen, final Translator tr) {
        Pair pair = list;
        Object rest = null;
        Object cdr = null;
        Label_0948: {
            Object car = null;
            Label_0854: {
                while (true) {
                    rest = pair;
                    final Pair p1;
                    final Pair p2;
                    if (this.expandColonForms() && tr != null && pair == list && tr.matches(pair.getCar(), syntax, LispLanguage.lookup_sym) && pair.getCdr() instanceof Pair && (p1 = (Pair)pair.getCdr()) instanceof Pair && (p2 = (Pair)p1.getCdr()) instanceof Pair && p2.getCdr() == LList.Empty) {
                        final Expression part1 = tr.rewrite_car(p1, false);
                        final Expression part2 = tr.rewrite_car_for_lookup(p2);
                        final Namespace ns = tr.namespaceResolvePrefix(part1);
                        final Symbol sym = tr.namespaceResolve(ns, part2);
                        if (sym != null) {
                            cdr = sym;
                            break Label_0948;
                        }
                        if (ns != null && depth == 1) {
                            cdr = new ApplyExp(Quote.quoteType.getDeclaredMethod("makeSymbol", 2), new Expression[] { QuoteExp.getInstance(ns), part2 });
                            break Label_0948;
                        }
                        if (p1.getCar() instanceof SimpleSymbol && part2 instanceof QuoteExp) {
                            final String s1 = ((QuoteExp)part2).getValue().toString();
                            final String s2 = p1.getCar().toString();
                            cdr = Symbol.makeWithUnknownNamespace(s1, s2);
                            break Label_0948;
                        }
                        final String combinedName = CompileNamedPart.combineName(part1, part2);
                        if (combinedName != null) {
                            cdr = tr.getGlobalEnvironment().getSymbol(combinedName);
                        }
                        else {
                            cdr = pair;
                        }
                        break Label_0948;
                    }
                    else {
                        if (depth >= 0) {
                            if (this.matchesQuasiQuote(pair.getCar(), syntax, tr)) {
                                ++depth;
                            }
                            else {
                                final boolean isUnquote;
                                if ((isUnquote = this.matchesUnquote(pair, syntax, tr)) || this.matchesUnquoteSplicing(pair, syntax, tr)) {
                                    --depth;
                                    final Pair pair_cdr;
                                    if (!(pair.getCdr() instanceof Pair) || (pair_cdr = (Pair)pair.getCdr()).getCdr() != LList.Empty || (depth == 0 && !isUnquote)) {
                                        return tr.syntaxError("invalid used of " + pair.getCar() + " in quasiquote template");
                                    }
                                    if (depth == 0) {
                                        cdr = tr.rewrite_car(pair_cdr, syntax);
                                        break Label_0948;
                                    }
                                }
                            }
                        }
                        if (depth == 1 && pair.getCar() instanceof Pair) {
                            Object form;
                            SyntaxForm subsyntax;
                            for (form = pair.getCar(), subsyntax = syntax; form instanceof SyntaxForm; form = subsyntax.getDatum()) {
                                subsyntax = (SyntaxForm)form;
                            }
                            int splicing = -1;
                            if (form instanceof Pair) {
                                final Pair pform = (Pair)form;
                                if (this.matchesUnquote(pform, subsyntax, tr)) {
                                    splicing = 0;
                                }
                                else if (this.matchesUnquoteSplicing(pform, subsyntax, tr)) {
                                    splicing = 1;
                                }
                            }
                            if (splicing >= 0) {
                                form = ((Pair)form).getCdr();
                                final Vector vec = new Vector();
                                cdr = null;
                                while (true) {
                                    if (form instanceof SyntaxForm) {
                                        subsyntax = (SyntaxForm)form;
                                        form = subsyntax.getDatum();
                                    }
                                    if (form == LList.Empty) {
                                        final int nargs = vec.size() + 1;
                                        cdr = this.expand(pair.getCdr(), 1, syntax, seen, tr);
                                        if (nargs > 1) {
                                            final Expression[] args = new Expression[nargs];
                                            vec.copyInto(args);
                                            args[nargs - 1] = this.coerceExpression(cdr, tr);
                                            final Method method = (splicing == 0) ? Quote.consXMethod : Quote.appendMethod;
                                            cdr = new ApplyExp(method, args);
                                        }
                                        rest = pair;
                                        break Label_0948;
                                    }
                                    if (!(form instanceof Pair)) {
                                        return tr.syntaxError("improper list argument to unquote");
                                    }
                                    vec.addElement(tr.rewrite_car((Pair)form, subsyntax));
                                    form = ((Pair)form).getCdr();
                                }
                            }
                        }
                        car = this.expand(pair.getCar(), depth, syntax, seen, tr);
                        if (car != pair.getCar()) {
                            break Label_0854;
                        }
                        rest = pair.getCdr();
                        if (!(rest instanceof Pair)) {
                            break;
                        }
                        final IdentityHashMap map = (IdentityHashMap)seen;
                        final Object old = map.get(rest);
                        if (old != null) {
                            break;
                        }
                        map.put(rest, Quote.WORKING);
                        pair = (Pair)rest;
                    }
                }
                cdr = this.expand(rest, depth, syntax, seen, tr);
                if (cdr == rest) {
                    return list;
                }
                break Label_0948;
            }
            cdr = this.expand(pair.getCdr(), depth, syntax, seen, tr);
            if (car instanceof Expression || cdr instanceof Expression) {
                final Expression[] args2 = { this.coerceExpression(car, tr), this.coerceExpression(cdr, tr) };
                cdr = new ApplyExp(Quote.makePairMethod, args2);
            }
            else {
                cdr = Translator.makePair(pair, car, cdr);
            }
        }
        if (list == rest) {
            return cdr;
        }
        Pair p3 = list;
        Pair[] pairs = new Pair[20];
        int npairs = 0;
        while (true) {
            if (npairs >= pairs.length) {
                final Pair[] tmp = new Pair[2 * npairs];
                System.arraycopy(pairs, 0, tmp, 0, npairs);
                pairs = tmp;
            }
            pairs[npairs++] = p3;
            if (p3.getCdr() == rest) {
                break;
            }
            p3 = (Pair)p3.getCdr();
        }
        Object result = (cdr instanceof Expression) ? LList.Empty : cdr;
        while (--npairs >= 0) {
            p3 = pairs[npairs];
            result = Translator.makePair(p3, p3.getCar(), result);
        }
        if (!(cdr instanceof Expression)) {
            return result;
        }
        final Expression[] args2 = { null, (Expression)cdr };
        if (npairs == 1) {
            args2[0] = this.leaf(list.getCar(), tr);
            return new ApplyExp(Quote.makePairMethod, args2);
        }
        args2[0] = this.leaf(result, tr);
        return new ApplyExp(Quote.appendMethod, args2);
    }
    
    Object expand(final Object template, final int depth, SyntaxForm syntax, final Object seen, final Translator tr) {
        final IdentityHashMap map = (IdentityHashMap)seen;
        final Object old = map.get(template);
        if (old == Quote.WORKING) {
            map.put(template, Quote.SHARED);
            return template;
        }
        if (old == Quote.SHARED) {
            return template;
        }
        if (old != null) {
            return old;
        }
        map.put(template, Quote.WORKING);
        Object result;
        if (template instanceof Pair) {
            result = this.expand_pair((Pair)template, depth, syntax, seen, tr);
        }
        else if (template instanceof SyntaxForm) {
            syntax = (SyntaxForm)template;
            result = this.expand(syntax.getDatum(), depth, syntax, seen, tr);
        }
        else if (template instanceof FVector) {
            final FVector vector = (FVector)template;
            final int n = vector.size();
            final Object[] buffer = new Object[n];
            final byte[] state = new byte[n];
            byte max_state = 0;
            for (int i = 0; i < n; ++i) {
                final Object element = vector.get(i);
                int element_depth = depth;
                final Pair pair;
                if (element instanceof Pair && depth > -1 && this.matchesUnquoteSplicing(pair = (Pair)element, syntax, tr) && --element_depth == 0) {
                    final Pair pair_cdr;
                    if (!(pair.getCdr() instanceof Pair) || (pair_cdr = (Pair)pair.getCdr()).getCdr() != LList.Empty) {
                        return tr.syntaxError("invalid used of " + pair.getCar() + " in quasiquote template");
                    }
                    buffer[i] = tr.rewrite_car(pair_cdr, syntax);
                    state[i] = 3;
                }
                else {
                    buffer[i] = this.expand(element, element_depth, syntax, seen, tr);
                    if (buffer[i] == element) {
                        state[i] = 0;
                    }
                    else if (buffer[i] instanceof Expression) {
                        state[i] = 2;
                    }
                    else {
                        state[i] = 1;
                    }
                }
                if (state[i] > max_state) {
                    max_state = state[i];
                }
            }
            if (max_state == 0) {
                result = vector;
            }
            else if (max_state == 1) {
                result = FVector.makeConstant(buffer);
            }
            else {
                final Expression[] args = new Expression[n];
                final int firstSpliceArg = -1;
                for (int j = 0; j < n; ++j) {
                    if (state[j] == 3) {
                        args[j] = new ApplyExp(MakeSplice.quoteInstance, new Expression[] { (Expression)buffer[j] });
                    }
                    else {
                        args[j] = this.coerceExpression(buffer[j], tr);
                    }
                }
                final ApplyExp exp = makeInvokeMakeVector(args);
                exp.firstSpliceArg = firstSpliceArg;
                result = exp;
            }
        }
        else {
            result = template;
        }
        if (template != result && map.get(template) == Quote.SHARED) {
            tr.error('e', "cycle in non-literal data");
        }
        map.put(template, result);
        return result;
    }
    
    private static ApplyExp makeInvokeMakeVector(final Expression[] args) {
        return new ApplyExp(Quote.makeVectorMethod, args);
    }
    
    @Override
    public Expression rewrite(final Object obj, final Translator tr) {
        final Pair pair;
        if (!(obj instanceof Pair) || (pair = (Pair)obj).getCdr() != LList.Empty) {
            return tr.syntaxError("wrong number of arguments to quote");
        }
        return this.coerceExpression(this.expand(pair.getCar(), this.isQuasi ? 1 : -1, tr), tr);
    }
    
    public static Object consX$V(final Object[] args) {
        return LList.consX(args);
    }
    
    public static Object append$V(final Object[] args) {
        final int count = args.length;
        if (count == 0) {
            return LList.Empty;
        }
        Object result = args[count - 1];
        int i = count - 1;
        while (--i >= 0) {
            Object list = args[i];
            Object copy = null;
            Pair last = null;
            SyntaxForm syntax = null;
            while (true) {
                if (list instanceof SyntaxForm) {
                    syntax = (SyntaxForm)list;
                    list = syntax.getDatum();
                }
                else {
                    if (list == LList.Empty) {
                        if (last != null) {
                            last.setCdr(result);
                            result = copy;
                        }
                        break;
                    }
                    if (!(list instanceof Pair)) {
                        if (list instanceof ErrorExp) {
                            return list;
                        }
                        throw new Error("expected list in quasi-quote splicing");
                    }
                    else {
                        final Pair list_pair = (Pair)list;
                        Object car = list_pair.getCar();
                        if (syntax != null && !(car instanceof SyntaxForm)) {
                            car = SyntaxForms.makeForm(car, syntax.getScope());
                        }
                        final Pair new_pair = new Pair(car, null);
                        if (last == null) {
                            copy = new_pair;
                        }
                        else {
                            last.setCdr(new_pair);
                        }
                        last = new_pair;
                        list = list_pair.getCdr();
                    }
                }
            }
        }
        return result;
    }
    
    static {
        plainQuote = new Quote("quote", false);
        quasiQuote = new Quote("quasiquote", true);
        WORKING = new String("(working)");
        SHARED = new String("(shared)");
        quoteType = ClassType.make("kawa.lang.Quote");
        consXMethod = Quote.quoteType.getDeclaredMethod("consX$V", 1);
        appendMethod = Quote.quoteType.getDeclaredMethod("append$V", 1);
        makePairMethod = Compilation.typePair.getDeclaredMethod("make", 2);
        makeVectorMethod = ClassType.make("gnu.lists.FVector").getDeclaredMethod("makeConstant", 1);
    }
}
