// 
// Decompiled by Procyon v0.5.36
// 

package gnu.q2.lang;

import gnu.mapping.Procedure;
import kawa.standard.Scheme;
import gnu.expr.SetExp;
import gnu.expr.LetExp;
import java.util.ArrayList;
import gnu.expr.BeginExp;
import gnu.bytecode.Type;
import gnu.expr.ApplyExp;
import gnu.kawa.functions.MakeSplice;
import gnu.kawa.lispexpr.LispLanguage;
import gnu.expr.QuoteExp;
import gnu.expr.ScopeExp;
import gnu.expr.IfExp;
import gnu.expr.Declaration;
import gnu.expr.Expression;
import gnu.text.SourceLocator;
import gnu.lists.PairWithPosition;
import gnu.lists.LList;
import gnu.expr.ReferenceExp;
import gnu.mapping.Symbol;
import gnu.lists.Pair;
import kawa.lang.SyntaxForm;
import java.util.Stack;
import kawa.lang.Translator;
import gnu.expr.NameLookup;
import gnu.text.SourceMessages;
import gnu.expr.Language;
import kawa.standard.SchemeCompilation;

public class Q2Translator extends SchemeCompilation
{
    public Q2Translator(final Language language, final SourceMessages messages, final NameLookup lexical) {
        super(language, messages, lexical);
    }
    
    public static Object partition(Object p, final Translator tr) {
        final Stack st = new Stack();
        st.add(Operator.FENCE);
        Object larg = p;
        Pair prev = null;
        while (true) {
            if (p instanceof SyntaxForm) {}
            Operator op = null;
            Pair pp;
            if (!(p instanceof Pair)) {
                op = Operator.FENCE;
                pp = null;
            }
            else {
                pp = (Pair)p;
                final Object obj = pp.getCar();
                if (obj instanceof Symbol && !Q2.instance.selfEvaluatingSymbol(obj)) {
                    final Expression func = tr.rewrite(obj, true);
                    final Declaration decl;
                    final Object value;
                    if (func instanceof ReferenceExp && (decl = ((ReferenceExp)func).getBinding()) != null && (value = decl.getConstantValue()) instanceof Operator) {
                        op = (Operator)value;
                    }
                }
            }
            if (op != null) {
                if (prev == null) {
                    larg = LList.Empty;
                }
                else if (p instanceof Pair) {
                    prev.setCdrBackdoor(LList.Empty);
                }
                int stsz = st.size();
                for (Operator topop = (Operator)st.get(stsz - 1); op.lprio <= topop.rprio; topop = (Operator)st.get(stsz - 1)) {
                    final PairWithPosition oppair = (PairWithPosition)st.get(stsz - 2);
                    if ((topop.flags & 0x2) != 0x0 && larg == LList.Empty) {
                        tr.error('e', "missing right operand after " + topop.getName(), oppair);
                    }
                    larg = topop.combine(st.get(stsz - 3), larg, oppair);
                    stsz -= 3;
                    st.setSize(stsz);
                }
                if (pp == null) {
                    break;
                }
                st.add(larg);
                st.add(pp);
                st.add(op);
                larg = pp.getCdr();
                prev = null;
            }
            else {
                prev = pp;
            }
            p = pp.getCdr();
        }
        return larg;
    }
    
    @Override
    public Expression makeBody(final Expression[] exps) {
        for (int nlen = exps.length, i = 0; i < nlen - 1; ++i) {
            final Expression exp = exps[i];
            if (exp instanceof IfExp) {
                IfExp iexp = (IfExp)exp;
                if (iexp.getElseClause() == null) {
                    final Expression[] rest = new Expression[nlen - i - 1];
                    System.arraycopy(exps, i + 1, rest, 0, rest.length);
                    iexp = new IfExp(iexp.getTest(), iexp.getThenClause(), this.makeBody(rest));
                    iexp.setLine(exp);
                    if (i == 0) {
                        return iexp;
                    }
                    final Expression[] init = new Expression[i + 1];
                    System.arraycopy(exps, 0, init, 0, i);
                    init[i] = iexp;
                    return super.makeBody(init);
                }
            }
        }
        return super.makeBody(exps);
    }
    
    @Override
    public void scanForm(Object st, final ScopeExp defs) {
        if (st instanceof LList) {
            st = partition(st, this);
        }
        if (st != LList.Empty) {
            super.scanForm(st, defs);
        }
    }
    
    @Override
    public Expression rewrite(final Object exp, final boolean function) {
        if (exp == LList.Empty) {
            return QuoteExp.voidExp;
        }
        return super.rewrite(exp, function);
    }
    
    @Override
    public Expression rewrite_pair(final Pair p, final boolean function) {
        final Object partitioned = partition(p, this);
        if (!(partitioned instanceof Pair)) {
            return this.rewrite(partitioned, function);
        }
        final Pair pair = (Pair)partitioned;
        final Object p_car = pair.getCar();
        if (p_car instanceof Pair && ((Pair)p_car).getCar() == LispLanguage.splice_sym) {
            return new ApplyExp(MakeSplice.quoteInstance, new Expression[] { this.rewrite_car((Pair)((Pair)p_car).getCdr(), function) });
        }
        Expression exp = super.rewrite_pair(pair, function);
        final ApplyExp app;
        if (exp instanceof ApplyExp && this.isApplyFunction((app = (ApplyExp)exp).getFunction())) {
            exp = convertApply(app);
        }
        return exp;
    }
    
    public static boolean applyNullary(final Expression exp) {
        if (exp instanceof ReferenceExp) {
            final Declaration decl = Declaration.followAliases(((ReferenceExp)exp).getBinding());
            if (decl != null) {
                if (decl.isProcedureDecl()) {
                    return true;
                }
                if (decl.getFlag(2048L) && decl.getFlag(16384L)) {
                    final Type type = decl.getType();
                    if ("gnu.kawa.lispexpr.LangObjType" == type.getName()) {
                        return true;
                    }
                }
            }
        }
        if (exp instanceof QuoteExp) {
            final Object val = exp.valueIfConstant();
            return val instanceof Type || val instanceof Class;
        }
        return false;
    }
    
    public static Expression convertApply(final ApplyExp exp) {
        Expression[] args = exp.getArgs();
        final int nargs = args.length;
        Expression arg0 = args[0];
        if (nargs == 1 && !applyNullary(arg0)) {
            if (arg0 instanceof IfExp && ((IfExp)arg0).getElseClause() == null) {
                arg0 = new BeginExp(args);
            }
            return arg0;
        }
        final ArrayList<Expression> rargs = new ArrayList<Expression>();
        LetExp let = null;
        for (int i = 0; i < nargs; ++i) {
            final Expression arg2 = exp.getArg(i);
            Expression barg;
            if (arg2 instanceof LetExp && arg2.getFlag(2) && let == null) {
                barg = ((LetExp)arg2).getBody();
            }
            else {
                barg = arg2;
            }
            if (barg instanceof ApplyExp) {
                final ApplyExp aarg = (ApplyExp)barg;
                if (aarg.isAppendValues()) {
                    if (arg2 != barg) {
                        let = (LetExp)arg2;
                    }
                    for (int naarg = aarg.getArgCount(), j = 0; j < naarg; ++j) {
                        Expression xaarg = aarg.getArg(j);
                        if (xaarg instanceof SetExp) {
                            xaarg = new ApplyExp(MakeSplice.quoteInstance, new Expression[] { new BeginExp(xaarg, QuoteExp.emptyExp) });
                            if (exp.firstSpliceArg == -1 || exp.firstSpliceArg > j) {
                                exp.firstSpliceArg = j;
                            }
                        }
                        rargs.add(xaarg);
                    }
                    continue;
                }
            }
            rargs.add(arg2);
        }
        args = rargs.toArray(new Expression[rargs.size()]);
        final Procedure proc = Scheme.applyToArgs;
        exp.setFuncArgs(new QuoteExp(proc), args);
        if (let != null) {
            let.setBody(exp);
            return let;
        }
        return exp;
    }
}
