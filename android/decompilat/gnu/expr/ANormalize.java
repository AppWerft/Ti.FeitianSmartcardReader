// 
// Decompiled by Procyon v0.5.36
// 

package gnu.expr;

import java.util.Vector;
import gnu.kawa.reflect.TypeSwitch;
import gnu.kawa.lispexpr.LispLanguage;
import gnu.kawa.functions.GetNamedPart;
import gnu.bytecode.ClassType;
import gnu.bytecode.Type;
import gnu.kawa.functions.MakeSplice;

public class ANormalize extends ExpExpVisitor<Context>
{
    static final Context identity;
    int varCount;
    
    public static void aNormalize(final Expression exp, final Compilation comp) {
        final ANormalize visitor = new ANormalize();
        visitor.setContext(comp);
        ((ExpVisitor<Object, D>)visitor).visit(exp, (D)ANormalize.identity);
    }
    
    Declaration genLetDeclaration(final Expression val, final LetExp let, final Declaration providedDecl) {
        final boolean isProvided = providedDecl != null;
        final Declaration decl = isProvided ? providedDecl : new Declaration((Object)null);
        let.add(decl);
        decl.setInitValue(val);
        decl.setFlag(262144L);
        decl.setNext(null);
        if (!isProvided) {
            decl.setCanRead();
            decl.setType(val.getType());
            if (val.getClass() == LambdaExp.class) {
                decl.setCanCall();
            }
            decl.noteValueFromLet(let);
            final Declaration declaration = decl;
            ++declaration.numReferences;
        }
        else {
            for (int i = 0; i < decl.nvalues; ++i) {
                if (decl.values[i].kind == 3) {
                    decl.values[i].base = let;
                }
            }
        }
        if (val.getClass() == LambdaExp.class) {
            final LambdaExp lexp = (LambdaExp)val;
            decl.setCanRead(lexp.getCanRead());
        }
        return decl;
    }
    
    Declaration genLetDeclaration(final Expression val, final LetExp let) {
        return this.genLetDeclaration(val, let, null);
    }
    
    protected Expression normalizeTerm(final Expression exp) {
        return this.visit(exp, (D)ANormalize.identity);
    }
    
    protected static boolean isAtomic(final Expression exp) {
        return exp instanceof QuoteExp || exp instanceof ReferenceExp || MakeSplice.argIfSplice(exp) != null || isGetNamedPart(exp) || isBracketList(exp) || isTypeSwitch(exp);
    }
    
    protected Expression normalizeName(final Expression exp, final Context context) {
        final Context newContext = new Context() {
            @Override
            Expression invoke(final Expression expr) {
                if (ANormalize.isAtomic(expr)) {
                    return context.invoke(expr);
                }
                final LetExp newlet = new LetExp();
                final Declaration decl = ANormalize.this.genLetDeclaration(expr, newlet);
                newlet.body = context.invoke(new ReferenceExp(decl));
                return newlet;
            }
        };
        return this.visit(exp, (D)newContext);
    }
    
    protected Expression normalizeNames(final Expression[] exps, final int index, final MultiContext context) {
        if (exps.length == 0 || index == exps.length) {
            return context.invoke(exps, exps.length - 1);
        }
        final Context newContext = new Context() {
            @Override
            Expression invoke(final Expression expr) {
                final MultiContext newNewContext = new MultiContext() {
                    @Override
                    Expression invoke(final Expression[] exprs, final int ind) {
                        exprs[ind] = expr;
                        return context.invoke(exprs, ind - 1);
                    }
                };
                return ANormalize.this.normalizeNames(exps, index + 1, newNewContext);
            }
        };
        return this.normalizeName(exps[index], newContext);
    }
    
    protected Expression visitQuoteExp(final QuoteExp exp, final Context context) {
        return context.invoke(exp);
    }
    
    protected Expression visitReferenceExp(final ReferenceExp exp, final Context context) {
        return context.invoke(exp);
    }
    
    protected Expression visitApplyExp(final ApplyExp exp, final Context context) {
        Expression func = exp.getFunction();
        if ((isApplyToArgs(func) && exp.args[0] instanceof QuoteExp && ((QuoteExp)exp.args[0]).getValue() instanceof Type) || isGetNamedPart(exp) || isBracketList(exp)) {
            for (int i = 0; i < exp.args.length; ++i) {
                exp.args[i] = this.normalizeTerm(exp.args[i]);
            }
            return context.invoke(exp);
        }
        if (MakeSplice.argIfSplice(exp) != null || isTypeSwitch(exp)) {
            exp.args[0] = this.normalizeTerm(exp.args[0]);
            return context.invoke(exp);
        }
        if (isSetter(func)) {
            return context.invoke(exp);
        }
        int startIndex;
        if (isApplyToArgs(func)) {
            func = exp.args[0];
            startIndex = 1;
        }
        else {
            startIndex = 0;
        }
        final Context newContext = new Context() {
            @Override
            Expression invoke(final Expression expr) {
                final MultiContext newNewContext = new MultiContext() {
                    @Override
                    Expression invoke(final Expression[] exprs, final int ind) {
                        if (ind > -1) {
                            exprs[ind] = expr;
                        }
                        else {
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
    
    private static boolean isApplyToArgs(final Expression func) {
        return func instanceof ReferenceExp && func.getName() != null && func.getName().equals("applyToArgs");
    }
    
    private static Expression getApplyFunc(final ApplyExp aexp) {
        return isApplyToArgs(aexp.getFunction()) ? aexp.args[0] : aexp.getFunction();
    }
    
    private static boolean isSetter(final Expression aexp) {
        return aexp instanceof ApplyExp && ((ApplyExp)aexp).getFunction().getType() == ClassType.make("gnu.kawa.functions.Setter");
    }
    
    private static boolean isGetNamedPart(final Expression exp) {
        if (exp instanceof ApplyExp) {
            final ApplyExp aexp = (ApplyExp)exp;
            final Expression func = aexp.getFunction();
            return func instanceof QuoteExp && ((QuoteExp)func).getValue() == GetNamedPart.getNamedPart;
        }
        return false;
    }
    
    private static boolean isBracketList(final Expression exp) {
        if (exp instanceof ApplyExp) {
            final ApplyExp aexp = (ApplyExp)exp;
            final Expression func = getApplyFunc(aexp);
            return func instanceof ReferenceExp && ((ReferenceExp)func).getSymbol() == LispLanguage.bracket_list_sym;
        }
        return false;
    }
    
    private static boolean isTypeSwitch(final Expression exp) {
        if (exp instanceof ApplyExp) {
            final ApplyExp aexp = (ApplyExp)exp;
            final Expression func = getApplyFunc(aexp);
            return func instanceof QuoteExp && ((QuoteExp)func).getValue() == TypeSwitch.typeSwitch;
        }
        return false;
    }
    
    protected Expression visitBeginExp(final BeginExp exp, final Context context) {
        final Vector co = exp.compileOptions;
        LetExp previous;
        final LetExp firstLet = previous = new LetExp();
        int i;
        for (i = 0; i < exp.exps.length - 1 && exp.exps[i + 1] != null; ++i) {
            if (exp.exps[i] != QuoteExp.voidExp) {
                this.genLetDeclaration(exp.exps[i], previous);
                previous.body = new LetExp();
                previous = (LetExp)previous.body;
            }
        }
        previous.body = exp.exps[i];
        Expression result = this.visitLetExp(firstLet, context);
        if (co != null) {
            result = new BeginExp(new Expression[] { result });
            ((BeginExp)result).compileOptions = co;
        }
        return result;
    }
    
    protected Expression visitLetExp(final LetExp exp, final Context context) {
        final Declaration first = exp.firstDecl();
        if (exp instanceof FluidLetExp && context != ANormalize.identity) {
            return context.invoke(this.normalizeTerm(exp));
        }
        if (first == null) {
            return this.visit(exp.body, (D)context);
        }
        exp.decls = exp.decls.nextDecl();
        final Expression innerLet = this.visitLetExp(exp, context);
        final Expression firstLetVal = first.getInitValue();
        final Context newContext = new Context() {
            @Override
            Expression invoke(final Expression expr) {
                if (expr != QuoteExp.voidExp) {
                    final LetExp newlet = (exp instanceof FluidLetExp) ? new FluidLetExp() : new LetExp();
                    ANormalize.this.genLetDeclaration(expr, newlet, first);
                    newlet.body = innerLet;
                    return newlet;
                }
                return innerLet;
            }
        };
        return this.visit(firstLetVal, (D)newContext);
    }
    
    protected Expression visitIfExp(final IfExp exp, final Context context) {
        final Context newContext = new Context() {
            @Override
            Expression invoke(final Expression expr) {
                exp.then_clause = ANormalize.this.normalizeTerm(exp.then_clause);
                exp.else_clause = ((exp.else_clause != null) ? ANormalize.this.normalizeTerm(exp.else_clause) : null);
                exp.test = expr;
                return context.invoke(exp);
            }
        };
        return this.normalizeName(exp.test, newContext);
    }
    
    protected Expression visitCaseExp(final CaseExp exp, final Context context) {
        final Context newContext = new Context() {
            @Override
            Expression invoke(final Expression expr) {
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
    
    protected Expression visitLambdaExp(final LambdaExp exp, final Context context) {
        exp.body = this.normalizeTerm(exp.body);
        return context.invoke(exp);
    }
    
    protected Expression visitSetExp(final SetExp exp, final Context context) {
        final Declaration bin = exp.getBinding();
        if (bin != null) {
            bin.setCanWrite();
            if (bin.getInitValue() == QuoteExp.undefined_exp) {
                final Expression value = bin.getValue();
                if (value instanceof LambdaExp || (value != bin.getInitValue() && value instanceof QuoteExp)) {
                    bin.setInitValue(this.normalizeTerm(value));
                    return context.invoke(QuoteExp.voidExp);
                }
            }
        }
        if (exp.isDefining()) {
            if (!(exp.new_value instanceof ReferenceExp) && !(exp.new_value instanceof QuoteExp)) {
                exp.new_value = this.normalizeTerm(exp.new_value);
            }
            return context.invoke(exp);
        }
        final Context newContext = new Context() {
            @Override
            Expression invoke(final Expression expr) {
                final LetExp newlet = new LetExp();
                exp.new_value = expr;
                ANormalize.this.genLetDeclaration(exp, newlet);
                newlet.body = context.invoke(QuoteExp.voidExp);
                return newlet;
            }
        };
        return this.normalizeName(exp.new_value, newContext);
    }
    
    protected Expression visitModuleExp(final ModuleExp exp, final Context context) {
        if (exp.body instanceof ApplyExp) {
            final ApplyExp body = (ApplyExp)exp.body;
            for (int i = 0; i < body.args.length; ++i) {
                body.args[i] = this.visit(body.args[i], (D)context);
            }
            return exp;
        }
        return this.visitExpression(exp, (D)context);
    }
    
    protected Expression visitTryExp(final TryExp exp, final Context context) {
        exp.try_clause = this.normalizeTerm(exp.try_clause);
        if (exp.catch_clauses != null) {
            exp.catch_clauses = this.toCatchClause((LetExp)this.normalizeTerm(exp.catch_clauses), exp.catch_clauses.next);
            for (CatchClause c = exp.catch_clauses; c.next != null; c = c.next) {
                c.next = this.toCatchClause((LetExp)this.normalizeTerm(c.next), c.next.next);
            }
        }
        if (exp.finally_clause != null) {
            exp.finally_clause = this.normalizeTerm(exp.finally_clause);
        }
        return context.invoke(exp);
    }
    
    protected CatchClause toCatchClause(final LetExp exp, final CatchClause next) {
        final CatchClause clause = new CatchClause(exp.decls, exp.body);
        clause.next = next;
        return clause;
    }
    
    protected Expression visitSynchronizedExp(final SynchronizedExp exp, final Context context) {
        final Context newContext = new Context() {
            @Override
            Expression invoke(final Expression expr) {
                exp.body = ANormalize.this.normalizeTerm(exp.body);
                exp.object = expr;
                return context.invoke(exp);
            }
        };
        return this.normalizeName(exp.object, newContext);
    }
    
    protected Expression visitBlockExp(final BlockExp exp, final Context context) {
        exp.body = this.normalizeTerm(exp.body);
        if (exp.exitBody != null) {
            exp.exitBody = this.normalizeTerm(exp.exitBody);
        }
        return context.invoke(exp);
    }
    
    protected Expression visitExitExp(final ExitExp exp, final Context context) {
        exp.result = this.normalizeTerm(exp.result);
        return context.invoke(exp);
    }
    
    protected Expression visitClassExp(final ClassExp exp, final Context context) {
        for (Declaration decl = exp.firstDecl(); decl != null; decl = decl.nextDecl()) {
            final Expression e = decl.getValue();
            if (e != null) {
                if (e instanceof LambdaExp) {
                    decl.setValue(this.normalizeClassMethod((LambdaExp)e));
                }
                else {
                    decl.setValue(this.normalizeTerm(e));
                }
            }
        }
        if (exp.firstChild != null) {
            LambdaExp next = exp.firstChild.nextSibling;
            exp.firstChild = (LambdaExp)this.normalizeClassMethod(exp.firstChild);
            exp.firstChild.nextSibling = next;
            for (LambdaExp child = exp.firstChild; child.nextSibling != null; child = child.nextSibling) {
                next = child.nextSibling.nextSibling;
                child.nextSibling = (LambdaExp)this.normalizeClassMethod(child.nextSibling);
                child.nextSibling.nextSibling = next;
            }
        }
        return context.invoke(exp);
    }
    
    private Expression normalizeClassMethod(final LambdaExp exp) {
        if (!exp.isClassMethod()) {
            throw new Error();
        }
        if ("*init*".equals(exp.getName())) {
            if (exp.body instanceof BeginExp) {
                final Expression bodyFirst = exp.getBodyFirstExpression();
                ((BeginExp)exp.body).exps[0] = QuoteExp.voidExp;
                exp.body = new BeginExp(bodyFirst, this.normalizeTerm(exp.body));
            }
            return exp;
        }
        return this.normalizeTerm(exp);
    }
    
    static {
        identity = new Context();
    }
    
    static class Context
    {
        Expression invoke(final Expression expr) {
            return expr;
        }
    }
    
    abstract static class MultiContext
    {
        abstract Expression invoke(final Expression[] p0, final int p1);
    }
}
