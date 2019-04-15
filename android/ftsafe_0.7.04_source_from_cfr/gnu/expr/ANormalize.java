/*
 * Decompiled with CFR 0.139.
 */
package gnu.expr;

import gnu.bytecode.ClassType;
import gnu.bytecode.Type;
import gnu.expr.ApplyExp;
import gnu.expr.BeginExp;
import gnu.expr.BlockExp;
import gnu.expr.CaseExp;
import gnu.expr.CatchClause;
import gnu.expr.ClassExp;
import gnu.expr.Compilation;
import gnu.expr.Declaration;
import gnu.expr.ExitExp;
import gnu.expr.ExpExpVisitor;
import gnu.expr.Expression;
import gnu.expr.FluidLetExp;
import gnu.expr.IfExp;
import gnu.expr.LambdaExp;
import gnu.expr.LetExp;
import gnu.expr.ModuleExp;
import gnu.expr.QuoteExp;
import gnu.expr.ReferenceExp;
import gnu.expr.ScopeExp;
import gnu.expr.SetExp;
import gnu.expr.SynchronizedExp;
import gnu.expr.TryExp;
import gnu.kawa.functions.GetNamedPart;
import gnu.kawa.functions.MakeSplice;
import gnu.kawa.lispexpr.LispLanguage;
import gnu.kawa.reflect.TypeSwitch;
import gnu.mapping.Symbol;
import java.util.Vector;

public class ANormalize
extends ExpExpVisitor<Context> {
    static final Context identity = new Context();
    int varCount;

    public static void aNormalize(Expression exp, Compilation comp) {
        ANormalize visitor = new ANormalize();
        visitor.setContext(comp);
        visitor.visit(exp, identity);
    }

    Declaration genLetDeclaration(Expression val, LetExp let2, Declaration providedDecl) {
        boolean isProvided = providedDecl != null;
        Declaration decl = isProvided ? providedDecl : new Declaration((Object)null);
        let2.add(decl);
        decl.setInitValue(val);
        decl.setFlag(262144L);
        decl.setNext(null);
        if (!isProvided) {
            decl.setCanRead();
            decl.setType(val.getType());
            if (val.getClass() == LambdaExp.class) {
                decl.setCanCall();
            }
            decl.noteValueFromLet(let2);
            ++decl.numReferences;
        } else {
            for (int i = 0; i < decl.nvalues; ++i) {
                if (decl.values[i].kind != 3) continue;
                decl.values[i].base = let2;
            }
        }
        if (val.getClass() == LambdaExp.class) {
            LambdaExp lexp = (LambdaExp)val;
            decl.setCanRead(lexp.getCanRead());
        }
        return decl;
    }

    Declaration genLetDeclaration(Expression val, LetExp let2) {
        return this.genLetDeclaration(val, let2, null);
    }

    protected Expression normalizeTerm(Expression exp) {
        return (Expression)this.visit(exp, identity);
    }

    protected static boolean isAtomic(Expression exp) {
        return exp instanceof QuoteExp || exp instanceof ReferenceExp || MakeSplice.argIfSplice(exp) != null || ANormalize.isGetNamedPart(exp) || ANormalize.isBracketList(exp) || ANormalize.isTypeSwitch(exp);
    }

    protected Expression normalizeName(Expression exp, final Context context) {
        Context newContext = new Context(){

            @Override
            Expression invoke(Expression expr) {
                if (ANormalize.isAtomic(expr)) {
                    return context.invoke(expr);
                }
                LetExp newlet = new LetExp();
                Declaration decl = ANormalize.this.genLetDeclaration(expr, newlet);
                newlet.body = context.invoke(new ReferenceExp(decl));
                return newlet;
            }
        };
        return (Expression)this.visit(exp, newContext);
    }

    protected Expression normalizeNames(final Expression[] exps, final int index, final MultiContext context) {
        if (exps.length == 0 || index == exps.length) {
            return context.invoke(exps, exps.length - 1);
        }
        Context newContext = new Context(){

            @Override
            Expression invoke(final Expression expr) {
                MultiContext newNewContext = new MultiContext(){

                    @Override
                    Expression invoke(Expression[] exprs, int ind) {
                        exprs[ind] = expr;
                        return context.invoke(exprs, ind - 1);
                    }
                };
                return ANormalize.this.normalizeNames(exps, index + 1, newNewContext);
            }

        };
        return this.normalizeName(exps[index], newContext);
    }

    @Override
    protected Expression visitQuoteExp(QuoteExp exp, Context context) {
        return context.invoke(exp);
    }

    @Override
    protected Expression visitReferenceExp(ReferenceExp exp, Context context) {
        return context.invoke(exp);
    }

    @Override
    protected Expression visitApplyExp(final ApplyExp exp, final Context context) {
        int startIndex;
        Expression func = exp.getFunction();
        if (ANormalize.isApplyToArgs(func) && exp.args[0] instanceof QuoteExp && ((QuoteExp)exp.args[0]).getValue() instanceof Type || ANormalize.isGetNamedPart(exp) || ANormalize.isBracketList(exp)) {
            for (int i = 0; i < exp.args.length; ++i) {
                exp.args[i] = this.normalizeTerm(exp.args[i]);
            }
            return context.invoke(exp);
        }
        if (MakeSplice.argIfSplice(exp) != null || ANormalize.isTypeSwitch(exp)) {
            exp.args[0] = this.normalizeTerm(exp.args[0]);
            return context.invoke(exp);
        }
        if (ANormalize.isSetter(func)) {
            return context.invoke(exp);
        }
        if (ANormalize.isApplyToArgs(func)) {
            func = exp.args[0];
            startIndex = 1;
        } else {
            startIndex = 0;
        }
        Context newContext = new Context(){

            @Override
            Expression invoke(final Expression expr) {
                MultiContext newNewContext = new MultiContext(){

                    @Override
                    Expression invoke(Expression[] exprs, int ind) {
                        if (ind > -1) {
                            exprs[ind] = expr;
                        } else {
                            exp.func = expr;
                        }
                        exp.args = exprs;
                        return context.invoke(exp);
                    }
                };
                return ANormalize.this.normalizeNames(exp.args, startIndex, newNewContext);
            }

        };
        return this.normalizeName(func, newContext);
    }

    private static boolean isApplyToArgs(Expression func) {
        return func instanceof ReferenceExp && func.getName() != null && func.getName().equals("applyToArgs");
    }

    private static Expression getApplyFunc(ApplyExp aexp) {
        return ANormalize.isApplyToArgs(aexp.getFunction()) ? aexp.args[0] : aexp.getFunction();
    }

    private static boolean isSetter(Expression aexp) {
        return aexp instanceof ApplyExp && ((ApplyExp)aexp).getFunction().getType() == ClassType.make("gnu.kawa.functions.Setter");
    }

    private static boolean isGetNamedPart(Expression exp) {
        if (exp instanceof ApplyExp) {
            ApplyExp aexp = (ApplyExp)exp;
            Expression func = aexp.getFunction();
            return func instanceof QuoteExp && ((QuoteExp)func).getValue() == GetNamedPart.getNamedPart;
        }
        return false;
    }

    private static boolean isBracketList(Expression exp) {
        if (exp instanceof ApplyExp) {
            ApplyExp aexp = (ApplyExp)exp;
            Expression func = ANormalize.getApplyFunc(aexp);
            return func instanceof ReferenceExp && ((ReferenceExp)func).getSymbol() == LispLanguage.bracket_list_sym;
        }
        return false;
    }

    private static boolean isTypeSwitch(Expression exp) {
        if (exp instanceof ApplyExp) {
            ApplyExp aexp = (ApplyExp)exp;
            Expression func = ANormalize.getApplyFunc(aexp);
            return func instanceof QuoteExp && ((QuoteExp)func).getValue() == TypeSwitch.typeSwitch;
        }
        return false;
    }

    @Override
    protected Expression visitBeginExp(BeginExp exp, Context context) {
        int i;
        LetExp firstLet;
        Vector co = exp.compileOptions;
        LetExp previous = firstLet = new LetExp();
        for (i = 0; i < exp.exps.length - 1 && exp.exps[i + 1] != null; ++i) {
            if (exp.exps[i] == QuoteExp.voidExp) continue;
            this.genLetDeclaration(exp.exps[i], previous);
            previous.body = new LetExp();
            previous = (LetExp)previous.body;
        }
        previous.body = exp.exps[i];
        Expression result = this.visitLetExp(firstLet, context);
        if (co != null) {
            result = new BeginExp(new Expression[]{result});
            ((BeginExp)result).compileOptions = co;
        }
        return result;
    }

    @Override
    protected Expression visitLetExp(final LetExp exp, Context context) {
        final Declaration first = exp.firstDecl();
        if (exp instanceof FluidLetExp && context != identity) {
            return context.invoke(this.normalizeTerm(exp));
        }
        if (first == null) {
            return (Expression)this.visit(exp.body, context);
        }
        exp.decls = exp.decls.nextDecl();
        final Expression innerLet = this.visitLetExp(exp, context);
        Expression firstLetVal = first.getInitValue();
        Context newContext = new Context(){

            @Override
            Expression invoke(Expression expr) {
                if (expr != QuoteExp.voidExp) {
                    LetExp newlet = exp instanceof FluidLetExp ? new FluidLetExp() : new LetExp();
                    ANormalize.this.genLetDeclaration(expr, newlet, first);
                    newlet.body = innerLet;
                    return newlet;
                }
                return innerLet;
            }
        };
        return (Expression)this.visit(firstLetVal, newContext);
    }

    @Override
    protected Expression visitIfExp(final IfExp exp, final Context context) {
        Context newContext = new Context(){

            @Override
            Expression invoke(Expression expr) {
                exp.then_clause = ANormalize.this.normalizeTerm(exp.then_clause);
                exp.else_clause = exp.else_clause != null ? ANormalize.this.normalizeTerm(exp.else_clause) : null;
                exp.test = expr;
                return context.invoke(exp);
            }
        };
        return this.normalizeName(exp.test, newContext);
    }

    @Override
    protected Expression visitCaseExp(final CaseExp exp, final Context context) {
        Context newContext = new Context(){

            @Override
            Expression invoke(Expression expr) {
                for (int i = 0; i < exp.clauses.length; ++i) {
                    exp.clauses[i].exp = ANormalize.this.normalizeTerm(exp.clauses[i].exp);
                }
                if (exp.elseClause != null) {
                    exp.elseClause.exp = ANormalize.this.normalizeTerm(exp.elseClause.exp);
                }
                exp.key = expr;
                return context.invoke(exp);
            }
        };
        return this.normalizeName(exp.key, newContext);
    }

    @Override
    protected Expression visitLambdaExp(LambdaExp exp, Context context) {
        exp.body = this.normalizeTerm(exp.body);
        return context.invoke(exp);
    }

    @Override
    protected Expression visitSetExp(final SetExp exp, final Context context) {
        Declaration bin = exp.getBinding();
        if (bin != null) {
            Expression value;
            bin.setCanWrite();
            if (bin.getInitValue() == QuoteExp.undefined_exp && ((value = bin.getValue()) instanceof LambdaExp || value != bin.getInitValue() && value instanceof QuoteExp)) {
                bin.setInitValue(this.normalizeTerm(value));
                return context.invoke(QuoteExp.voidExp);
            }
        }
        if (exp.isDefining()) {
            if (!(exp.new_value instanceof ReferenceExp) && !(exp.new_value instanceof QuoteExp)) {
                exp.new_value = this.normalizeTerm(exp.new_value);
            }
            return context.invoke(exp);
        }
        Context newContext = new Context(){

            @Override
            Expression invoke(Expression expr) {
                LetExp newlet = new LetExp();
                exp.new_value = expr;
                ANormalize.this.genLetDeclaration(exp, newlet);
                newlet.body = context.invoke(QuoteExp.voidExp);
                return newlet;
            }
        };
        return this.normalizeName(exp.new_value, newContext);
    }

    @Override
    protected Expression visitModuleExp(ModuleExp exp, Context context) {
        if (exp.body instanceof ApplyExp) {
            ApplyExp body = (ApplyExp)exp.body;
            for (int i = 0; i < body.args.length; ++i) {
                body.args[i] = (Expression)this.visit(body.args[i], context);
            }
            return exp;
        }
        return (Expression)this.visitExpression(exp, context);
    }

    @Override
    protected Expression visitTryExp(TryExp exp, Context context) {
        exp.try_clause = this.normalizeTerm(exp.try_clause);
        if (exp.catch_clauses != null) {
            CatchClause c = exp.catch_clauses = this.toCatchClause((LetExp)this.normalizeTerm(exp.catch_clauses), exp.catch_clauses.next);
            while (c.next != null) {
                c = c.next = this.toCatchClause((LetExp)this.normalizeTerm(c.next), c.next.next);
            }
        }
        if (exp.finally_clause != null) {
            exp.finally_clause = this.normalizeTerm(exp.finally_clause);
        }
        return context.invoke(exp);
    }

    protected CatchClause toCatchClause(LetExp exp, CatchClause next) {
        CatchClause clause = new CatchClause(exp.decls, exp.body);
        clause.next = next;
        return clause;
    }

    @Override
    protected Expression visitSynchronizedExp(final SynchronizedExp exp, final Context context) {
        Context newContext = new Context(){

            @Override
            Expression invoke(Expression expr) {
                exp.body = ANormalize.this.normalizeTerm(exp.body);
                exp.object = expr;
                return context.invoke(exp);
            }
        };
        return this.normalizeName(exp.object, newContext);
    }

    @Override
    protected Expression visitBlockExp(BlockExp exp, Context context) {
        exp.body = this.normalizeTerm(exp.body);
        if (exp.exitBody != null) {
            exp.exitBody = this.normalizeTerm(exp.exitBody);
        }
        return context.invoke(exp);
    }

    @Override
    protected Expression visitExitExp(ExitExp exp, Context context) {
        exp.result = this.normalizeTerm(exp.result);
        return context.invoke(exp);
    }

    @Override
    protected Expression visitClassExp(ClassExp exp, Context context) {
        for (Declaration decl = exp.firstDecl(); decl != null; decl = decl.nextDecl()) {
            Expression e = decl.getValue();
            if (e == null) continue;
            if (e instanceof LambdaExp) {
                decl.setValue(this.normalizeClassMethod((LambdaExp)e));
                continue;
            }
            decl.setValue(this.normalizeTerm(e));
        }
        if (exp.firstChild != null) {
            LambdaExp next = exp.firstChild.nextSibling;
            exp.firstChild = (LambdaExp)this.normalizeClassMethod(exp.firstChild);
            exp.firstChild.nextSibling = next;
            LambdaExp child = exp.firstChild;
            while (child.nextSibling != null) {
                next = child.nextSibling.nextSibling;
                child.nextSibling = (LambdaExp)this.normalizeClassMethod(child.nextSibling);
                child.nextSibling.nextSibling = next;
                child = child.nextSibling;
            }
        }
        return context.invoke(exp);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private Expression normalizeClassMethod(LambdaExp exp) {
        if (!exp.isClassMethod()) throw new Error();
        if (!"*init*".equals(exp.getName())) return this.normalizeTerm(exp);
        if (!(exp.body instanceof BeginExp)) return exp;
        Expression bodyFirst = exp.getBodyFirstExpression();
        ((BeginExp)exp.body).exps[0] = QuoteExp.voidExp;
        exp.body = new BeginExp(bodyFirst, this.normalizeTerm(exp.body));
        return exp;
    }

    static abstract class MultiContext {
        MultiContext() {
        }

        abstract Expression invoke(Expression[] var1, int var2);
    }

    static class Context {
        Context() {
        }

        Expression invoke(Expression expr) {
            return expr;
        }
    }

}

