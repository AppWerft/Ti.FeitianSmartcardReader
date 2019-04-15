/*
 * Decompiled with CFR 0.139.
 */
package gnu.q2.lang;

import gnu.bytecode.Type;
import gnu.expr.ApplyExp;
import gnu.expr.BeginExp;
import gnu.expr.Declaration;
import gnu.expr.Expression;
import gnu.expr.IfExp;
import gnu.expr.Language;
import gnu.expr.LetExp;
import gnu.expr.NameLookup;
import gnu.expr.QuoteExp;
import gnu.expr.ReferenceExp;
import gnu.expr.ScopeExp;
import gnu.expr.SetExp;
import gnu.kawa.functions.ApplyToArgs;
import gnu.kawa.functions.MakeSplice;
import gnu.kawa.lispexpr.LispLanguage;
import gnu.lists.EmptyList;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.lists.PairWithPosition;
import gnu.mapping.Symbol;
import gnu.q2.lang.Operator;
import gnu.q2.lang.Q2;
import gnu.text.SourceLocator;
import gnu.text.SourceMessages;
import java.util.ArrayList;
import java.util.Stack;
import kawa.lang.SyntaxForm;
import kawa.lang.Translator;
import kawa.standard.Scheme;
import kawa.standard.SchemeCompilation;

public class Q2Translator
extends SchemeCompilation {
    public Q2Translator(Language language, SourceMessages messages, NameLookup lexical) {
        super(language, messages, lexical);
    }

    public static Object partition(Object p, Translator tr) {
        Stack<Object> st = new Stack<Object>();
        st.add(Operator.FENCE);
        Object larg = p;
        Pair prev = null;
        do {
            Pair pp2;
            if (p instanceof SyntaxForm) {
                // empty if block
            }
            Operator op = null;
            if (!(p instanceof Pair)) {
                op = Operator.FENCE;
                pp2 = null;
            } else {
                Declaration decl;
                Expression func;
                Object value;
                pp2 = (Pair)p;
                Object obj = pp2.getCar();
                if (obj instanceof Symbol && !Q2.instance.selfEvaluatingSymbol(obj) && (func = tr.rewrite(obj, true)) instanceof ReferenceExp && (decl = ((ReferenceExp)func).getBinding()) != null && (value = decl.getConstantValue()) instanceof Operator) {
                    op = (Operator)value;
                }
            }
            if (op != null) {
                if (prev == null) {
                    larg = LList.Empty;
                } else if (p instanceof Pair) {
                    prev.setCdrBackdoor(LList.Empty);
                }
                int stsz = st.size();
                Operator topop = (Operator)st.get(stsz - 1);
                while (op.lprio <= topop.rprio) {
                    PairWithPosition oppair = (PairWithPosition)st.get(stsz - 2);
                    if ((topop.flags & 2) != 0 && larg == LList.Empty) {
                        tr.error('e', "missing right operand after " + topop.getName(), oppair);
                    }
                    larg = topop.combine((LList)st.get(stsz - 3), larg, oppair);
                    st.setSize(stsz -= 3);
                    topop = (Operator)st.get(stsz - 1);
                }
                if (pp2 == null) break;
                st.add(larg);
                st.add(pp2);
                st.add(op);
                larg = pp2.getCdr();
                prev = null;
            } else {
                prev = pp2;
            }
            p = pp2.getCdr();
        } while (true);
        return larg;
    }

    @Override
    public Expression makeBody(Expression[] exps) {
        int nlen = exps.length;
        for (int i = 0; i < nlen - 1; ++i) {
            IfExp iexp;
            Expression exp = exps[i];
            if (!(exp instanceof IfExp) || (iexp = (IfExp)exp).getElseClause() != null) continue;
            Expression[] rest = new Expression[nlen - i - 1];
            System.arraycopy(exps, i + 1, rest, 0, rest.length);
            iexp = new IfExp(iexp.getTest(), iexp.getThenClause(), this.makeBody(rest));
            iexp.setLine(exp);
            if (i == 0) {
                return iexp;
            }
            Expression[] init = new Expression[i + 1];
            System.arraycopy(exps, 0, init, 0, i);
            init[i] = iexp;
            return super.makeBody(init);
        }
        return super.makeBody(exps);
    }

    @Override
    public void scanForm(Object st, ScopeExp defs2) {
        if (st instanceof LList) {
            st = Q2Translator.partition(st, this);
        }
        if (st != LList.Empty) {
            super.scanForm(st, defs2);
        }
    }

    @Override
    public Expression rewrite(Object exp, boolean function2) {
        if (exp == LList.Empty) {
            return QuoteExp.voidExp;
        }
        return super.rewrite(exp, function2);
    }

    @Override
    public Expression rewrite_pair(Pair p, boolean function2) {
        Object partitioned = Q2Translator.partition(p, this);
        if (partitioned instanceof Pair) {
            ApplyExp app;
            Pair pair = (Pair)partitioned;
            Object p_car = pair.getCar();
            if (p_car instanceof Pair && ((Pair)p_car).getCar() == LispLanguage.splice_sym) {
                return new ApplyExp(MakeSplice.quoteInstance, this.rewrite_car((Pair)((Pair)p_car).getCdr(), function2));
            }
            Expression exp = super.rewrite_pair(pair, function2);
            if (exp instanceof ApplyExp && this.isApplyFunction((app = (ApplyExp)exp).getFunction())) {
                exp = Q2Translator.convertApply(app);
            }
            return exp;
        }
        return this.rewrite(partitioned, function2);
    }

    public static boolean applyNullary(Expression exp) {
        Declaration decl;
        if (exp instanceof ReferenceExp && (decl = Declaration.followAliases(((ReferenceExp)exp).getBinding())) != null) {
            Type type;
            if (decl.isProcedureDecl()) {
                return true;
            }
            if (decl.getFlag(2048L) && decl.getFlag(16384L) && "gnu.kawa.lispexpr.LangObjType" == (type = decl.getType()).getName()) {
                return true;
            }
        }
        if (exp instanceof QuoteExp) {
            Object val = exp.valueIfConstant();
            return val instanceof Type || val instanceof Class;
        }
        return false;
    }

    public static Expression convertApply(ApplyExp exp) {
        Expression[] args = exp.getArgs();
        int nargs = args.length;
        Expression arg0 = args[0];
        if (nargs == 1 && !Q2Translator.applyNullary(arg0)) {
            if (arg0 instanceof IfExp && ((IfExp)arg0).getElseClause() == null) {
                arg0 = new BeginExp(args);
            }
            return arg0;
        }
        ArrayList<Expression> rargs = new ArrayList<Expression>();
        LetExp let2 = null;
        for (int i = 0; i < nargs; ++i) {
            ApplyExp aarg;
            Expression arg = exp.getArg(i);
            Expression barg = arg instanceof LetExp && arg.getFlag(2) && let2 == null ? ((LetExp)arg).getBody() : arg;
            if (barg instanceof ApplyExp && (aarg = (ApplyExp)barg).isAppendValues()) {
                if (arg != barg) {
                    let2 = (LetExp)arg;
                }
                int naarg = aarg.getArgCount();
                for (int j = 0; j < naarg; ++j) {
                    Expression xaarg = aarg.getArg(j);
                    if (xaarg instanceof SetExp) {
                        xaarg = new ApplyExp(MakeSplice.quoteInstance, new BeginExp(xaarg, QuoteExp.emptyExp));
                        if (exp.firstSpliceArg == -1 || exp.firstSpliceArg > j) {
                            exp.firstSpliceArg = j;
                        }
                    }
                    rargs.add(xaarg);
                }
                continue;
            }
            rargs.add(arg);
        }
        args = rargs.toArray(new Expression[rargs.size()]);
        ApplyToArgs proc = Scheme.applyToArgs;
        exp.setFuncArgs(new QuoteExp(proc), args);
        if (let2 != null) {
            let2.setBody(exp);
            return let2;
        }
        return exp;
    }
}

