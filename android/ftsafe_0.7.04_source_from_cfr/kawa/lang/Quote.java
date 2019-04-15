/*
 * Decompiled with CFR 0.139.
 */
package kawa.lang;

import gnu.bytecode.ClassType;
import gnu.bytecode.Method;
import gnu.expr.ApplyExp;
import gnu.expr.Compilation;
import gnu.expr.ErrorExp;
import gnu.expr.Expression;
import gnu.expr.QuoteExp;
import gnu.kawa.functions.CompileNamedPart;
import gnu.kawa.functions.MakeSplice;
import gnu.kawa.lispexpr.LispLanguage;
import gnu.lists.EmptyList;
import gnu.lists.FVector;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.mapping.Environment;
import gnu.mapping.Namespace;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Symbol;
import java.util.IdentityHashMap;
import java.util.Vector;
import kawa.lang.Syntax;
import kawa.lang.SyntaxForm;
import kawa.lang.SyntaxForms;
import kawa.lang.TemplateScope;
import kawa.lang.Translator;

public class Quote
extends Syntax {
    public static final Quote plainQuote = new Quote("quote", false);
    public static final Quote quasiQuote = new Quote("quasiquote", true);
    protected static final int QUOTE_DEPTH = -1;
    protected boolean isQuasi;
    private static final Object WORKING = new String("(working)");
    private static final Object SHARED = new String("(shared)");
    static final ClassType quoteType = ClassType.make("kawa.lang.Quote");
    static final Method consXMethod = quoteType.getDeclaredMethod("consX$V", 1);
    static final Method appendMethod = quoteType.getDeclaredMethod("append$V", 1);
    static final Method makePairMethod = Compilation.typePair.getDeclaredMethod("make", 2);
    static final Method makeVectorMethod = ClassType.make("gnu.lists.FVector").getDeclaredMethod("makeConstant", 1);

    public Quote(String name, boolean isQuasi) {
        super(name);
        this.isQuasi = isQuasi;
    }

    protected boolean matchesUnquote(Pair pair, SyntaxForm syntax2, Translator tr) {
        return tr.matches(pair.getCar(), syntax2, "unquote");
    }

    protected boolean matchesUnquoteSplicing(Pair pair, SyntaxForm syntax2, Translator tr) {
        return tr.matches(pair.getCar(), syntax2, "unquote-splicing");
    }

    protected boolean matchesQuasiQuote(Object form, SyntaxForm syntax2, Translator tr) {
        return tr.matches(form, syntax2, "quasiquote");
    }

    protected Object expand(Object template, int depth, Translator tr) {
        IdentityHashMap seen = new IdentityHashMap();
        return this.expand(template, depth, null, seen, tr);
    }

    public static Object quote(Object obj, Translator tr) {
        return plainQuote.expand(obj, -1, tr);
    }

    public static Object quote(Object obj) {
        return plainQuote.expand(obj, -1, (Translator)Compilation.getCurrent());
    }

    protected Expression coerceExpression(Object val, Translator tr) {
        return val instanceof Expression ? (Expression)val : this.leaf(val, tr);
    }

    protected Expression leaf(Object val, Translator tr) {
        return new QuoteExp(val);
    }

    protected boolean expandColonForms() {
        return true;
    }

    public static Symbol makeSymbol(Namespace ns, Object local) {
        String name = local instanceof CharSequence ? ((Object)((CharSequence)local)).toString() : (String)local;
        return ns.getSymbol(name.intern());
    }

    Object expand_pair(Pair list, int depth, SyntaxForm syntax2, Object seen, Translator tr) {
        Object result;
        Object cdr;
        Expression[] args;
        Object rest;
        block33 : {
            Object car;
            Pair pair;
            block35 : {
                pair = list;
                do {
                    Pair p1;
                    Pair p2;
                    IdentityHashMap map;
                    Object old;
                    rest = pair;
                    if (this.expandColonForms() && tr != null && pair == list && tr.matches(pair.getCar(), syntax2, LispLanguage.lookup_sym) && pair.getCdr() instanceof Pair && (p1 = (Pair)pair.getCdr()) instanceof Pair && (p2 = (Pair)p1.getCdr()) instanceof Pair && p2.getCdr() == LList.Empty) {
                        Expression part1 = tr.rewrite_car(p1, false);
                        Expression part2 = tr.rewrite_car_for_lookup(p2);
                        Namespace ns = tr.namespaceResolvePrefix(part1);
                        Symbol sym = tr.namespaceResolve(ns, part2);
                        if (sym != null) {
                            cdr = sym;
                        } else if (ns != null && depth == 1) {
                            cdr = new ApplyExp(quoteType.getDeclaredMethod("makeSymbol", 2), QuoteExp.getInstance(ns), part2);
                        } else if (p1.getCar() instanceof SimpleSymbol && part2 instanceof QuoteExp) {
                            String s1 = ((QuoteExp)part2).getValue().toString();
                            String s2 = p1.getCar().toString();
                            cdr = Symbol.makeWithUnknownNamespace(s1, s2);
                        } else {
                            String combinedName = CompileNamedPart.combineName(part1, part2);
                            cdr = combinedName != null ? tr.getGlobalEnvironment().getSymbol(combinedName) : pair;
                        }
                        break block33;
                    }
                    if (depth >= 0) {
                        if (this.matchesQuasiQuote(pair.getCar(), syntax2, tr)) {
                            ++depth;
                        } else {
                            boolean isUnquote = this.matchesUnquote(pair, syntax2, tr);
                            if (isUnquote || this.matchesUnquoteSplicing(pair, syntax2, tr)) {
                                Pair pair_cdr;
                                if (!(pair.getCdr() instanceof Pair) || (pair_cdr = (Pair)pair.getCdr()).getCdr() != LList.Empty || --depth == 0 && !isUnquote) {
                                    return tr.syntaxError("invalid used of " + pair.getCar() + " in quasiquote template");
                                }
                                if (depth == 0) {
                                    cdr = tr.rewrite_car(pair_cdr, syntax2);
                                    break block33;
                                }
                            }
                        }
                    }
                    if (depth == 1 && pair.getCar() instanceof Pair) {
                        Object form = pair.getCar();
                        SyntaxForm subsyntax = syntax2;
                        while (form instanceof SyntaxForm) {
                            subsyntax = (SyntaxForm)form;
                            form = subsyntax.getDatum();
                        }
                        int splicing = -1;
                        if (form instanceof Pair) {
                            Pair pform = (Pair)form;
                            if (this.matchesUnquote(pform, subsyntax, tr)) {
                                splicing = 0;
                            } else if (this.matchesUnquoteSplicing(pform, subsyntax, tr)) {
                                splicing = 1;
                            }
                        }
                        if (splicing >= 0) {
                            Vector<Expression> vec;
                            block34 : {
                                form = ((Pair)form).getCdr();
                                vec = new Vector<Expression>();
                                cdr = null;
                                do {
                                    if (form instanceof SyntaxForm) {
                                        subsyntax = (SyntaxForm)form;
                                        form = subsyntax.getDatum();
                                    }
                                    if (form == LList.Empty) break block34;
                                    if (!(form instanceof Pair)) break;
                                    vec.addElement(tr.rewrite_car((Pair)form, subsyntax));
                                    form = ((Pair)form).getCdr();
                                } while (true);
                                return tr.syntaxError("improper list argument to unquote");
                            }
                            int nargs = vec.size() + 1;
                            cdr = this.expand(pair.getCdr(), 1, syntax2, seen, tr);
                            if (nargs > 1) {
                                Object[] args2 = new Expression[nargs];
                                vec.copyInto(args2);
                                args2[nargs - 1] = this.coerceExpression(cdr, tr);
                                Method method = splicing == 0 ? consXMethod : appendMethod;
                                cdr = new ApplyExp(method, (Expression[])args2);
                            }
                            rest = pair;
                            break block33;
                        }
                    }
                    if ((car = this.expand(pair.getCar(), depth, syntax2, seen, tr)) != pair.getCar()) break block35;
                    rest = pair.getCdr();
                    if (!(rest instanceof Pair) || (old = (map = (IdentityHashMap)seen).get(rest)) != null) break;
                    map.put(rest, WORKING);
                    pair = (Pair)rest;
                } while (true);
                cdr = this.expand(rest, depth, syntax2, seen, tr);
                if (cdr == rest) {
                    return list;
                }
                break block33;
            }
            cdr = this.expand(pair.getCdr(), depth, syntax2, seen, tr);
            if (car instanceof Expression || cdr instanceof Expression) {
                args = new Expression[]{this.coerceExpression(car, tr), this.coerceExpression(cdr, tr)};
                cdr = new ApplyExp(makePairMethod, args);
            } else {
                cdr = Translator.makePair(pair, car, cdr);
            }
        }
        if (list == rest) {
            return cdr;
        }
        Pair p = list;
        Pair[] pairs = new Pair[20];
        int npairs = 0;
        do {
            if (npairs >= pairs.length) {
                Pair[] tmp = new Pair[2 * npairs];
                System.arraycopy(pairs, 0, tmp, 0, npairs);
                pairs = tmp;
            }
            pairs[npairs++] = p;
            if (p.getCdr() == rest) break;
            p = (Pair)p.getCdr();
        } while (true);
        Object object2 = result = cdr instanceof Expression ? LList.Empty : cdr;
        while (--npairs >= 0) {
            p = pairs[npairs];
            result = Translator.makePair(p, p.getCar(), result);
        }
        if (cdr instanceof Expression) {
            args = new Expression[2];
            args[1] = (Expression)cdr;
            if (npairs == 1) {
                args[0] = this.leaf(list.getCar(), tr);
                return new ApplyExp(makePairMethod, args);
            }
            args[0] = this.leaf(result, tr);
            return new ApplyExp(appendMethod, args);
        }
        return result;
    }

    Object expand(Object template, int depth, SyntaxForm syntax2, Object seen, Translator tr) {
        Object result;
        IdentityHashMap map = (IdentityHashMap)seen;
        Object old = map.get(template);
        if (old == WORKING) {
            map.put(template, SHARED);
            return template;
        }
        if (old == SHARED) {
            return template;
        }
        if (old != null) {
            return old;
        }
        map.put(template, WORKING);
        if (template instanceof Pair) {
            result = this.expand_pair((Pair)((Object)template), depth, syntax2, seen, tr);
        } else if (template instanceof SyntaxForm) {
            syntax2 = (SyntaxForm)((Object)template);
            result = this.expand(syntax2.getDatum(), depth, syntax2, seen, tr);
        } else if (template instanceof FVector) {
            FVector vector = template;
            int n = vector.size();
            Object[] buffer = new Object[n];
            byte[] state = new byte[n];
            byte max_state = 0;
            for (int i = 0; i < n; ++i) {
                Pair pair;
                Object element = vector.get(i);
                int element_depth = depth;
                if (element instanceof Pair && depth > -1 && this.matchesUnquoteSplicing(pair = (Pair)element, syntax2, tr) && --element_depth == 0) {
                    Pair pair_cdr;
                    if (!(pair.getCdr() instanceof Pair) || (pair_cdr = (Pair)pair.getCdr()).getCdr() != LList.Empty) {
                        return tr.syntaxError("invalid used of " + pair.getCar() + " in quasiquote template");
                    }
                    buffer[i] = tr.rewrite_car(pair_cdr, syntax2);
                    state[i] = 3;
                } else {
                    buffer[i] = this.expand(element, element_depth, syntax2, seen, tr);
                    state[i] = buffer[i] == element ? 0 : (buffer[i] instanceof Expression ? 2 : 1);
                }
                if (state[i] <= max_state) continue;
                max_state = state[i];
            }
            if (max_state == 0) {
                result = vector;
            } else if (max_state == 1) {
                result = FVector.makeConstant(buffer);
            } else {
                Expression[] args = new Expression[n];
                int firstSpliceArg = -1;
                for (int i = 0; i < n; ++i) {
                    if (state[i] == 3) {
                        args[i] = new ApplyExp(MakeSplice.quoteInstance, (Expression)buffer[i]);
                        continue;
                    }
                    args[i] = this.coerceExpression(buffer[i], tr);
                }
                ApplyExp exp = Quote.makeInvokeMakeVector(args);
                exp.firstSpliceArg = firstSpliceArg;
                result = exp;
            }
        } else {
            result = template;
        }
        if (template != result && map.get(template) == SHARED) {
            tr.error('e', "cycle in non-literal data");
        }
        map.put(template, result);
        return result;
    }

    private static ApplyExp makeInvokeMakeVector(Expression[] args) {
        return new ApplyExp(makeVectorMethod, args);
    }

    @Override
    public Expression rewrite(Object obj, Translator tr) {
        Pair pair;
        if (!(obj instanceof Pair) || (pair = (Pair)obj).getCdr() != LList.Empty) {
            return tr.syntaxError("wrong number of arguments to quote");
        }
        return this.coerceExpression(this.expand(pair.getCar(), this.isQuasi ? 1 : -1, tr), tr);
    }

    public static Object consX$V(Object[] args) {
        return LList.consX(args);
    }

    public static Object append$V(Object[] args) {
        int count = args.length;
        if (count == 0) {
            return LList.Empty;
        }
        Object result = args[count - 1];
        int i = count - 1;
        while (--i >= 0) {
            Object list = args[i];
            Pair copy = null;
            Pair last = null;
            SyntaxForm syntax2 = null;
            do {
                if (list instanceof SyntaxForm) {
                    syntax2 = (SyntaxForm)list;
                    list = syntax2.getDatum();
                    continue;
                }
                if (list == LList.Empty) break;
                if (!(list instanceof Pair)) {
                    if (list instanceof ErrorExp) {
                        return list;
                    }
                    throw new Error("expected list in quasi-quote splicing");
                }
                Pair list_pair = (Pair)list;
                Object car = list_pair.getCar();
                if (syntax2 != null && !(car instanceof SyntaxForm)) {
                    car = SyntaxForms.makeForm(car, syntax2.getScope());
                }
                Pair new_pair = new Pair(car, null);
                if (last == null) {
                    copy = new_pair;
                } else {
                    last.setCdr(new_pair);
                }
                last = new_pair;
                list = list_pair.getCdr();
            } while (true);
            if (last == null) continue;
            last.setCdr(result);
            result = copy;
        }
        return result;
    }
}

