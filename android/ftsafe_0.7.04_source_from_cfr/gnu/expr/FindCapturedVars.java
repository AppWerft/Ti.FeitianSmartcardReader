/*
 * Decompiled with CFR 0.139.
 */
package gnu.expr;

import gnu.bytecode.ClassType;
import gnu.bytecode.Field;
import gnu.bytecode.Type;
import gnu.expr.ApplyExp;
import gnu.expr.BeginExp;
import gnu.expr.CaseExp;
import gnu.expr.ClassExp;
import gnu.expr.Compilation;
import gnu.expr.Declaration;
import gnu.expr.ExpExpVisitor;
import gnu.expr.ExpVisitor;
import gnu.expr.Expression;
import gnu.expr.FluidLetExp;
import gnu.expr.LambdaExp;
import gnu.expr.Language;
import gnu.expr.LetExp;
import gnu.expr.ModuleExp;
import gnu.expr.PrimProcedure;
import gnu.expr.QuoteExp;
import gnu.expr.ReferenceExp;
import gnu.expr.ScopeExp;
import gnu.expr.SetExp;
import gnu.expr.ThisExp;
import gnu.mapping.EnvironmentKey;
import gnu.mapping.KeyPair;
import gnu.mapping.Symbol;
import gnu.text.SourceLocator;
import java.util.Hashtable;

public class FindCapturedVars
extends ExpExpVisitor<Void> {
    int backJumpPossible = 0;
    Hashtable unknownDecls = null;
    ModuleExp currentModule = null;

    public static void findCapturedVars(Expression exp, Compilation comp) {
        FindCapturedVars visitor = new FindCapturedVars();
        visitor.setContext(comp);
        exp.visit(visitor, null);
    }

    @Override
    protected final void visitDeclarationType(Declaration decl) {
    }

    @Override
    protected Expression visitApplyExp(ApplyExp exp, Void ignored) {
        int oldBackJumpPossible = this.backJumpPossible;
        boolean skipFunc = false;
        boolean skipArgs = false;
        if (exp.func instanceof ReferenceExp && this.getCompilation().currentCallConvention() <= 1) {
            LambdaExp lexp;
            Expression value;
            Declaration decl = Declaration.followAliases(((ReferenceExp)exp.func).binding);
            if (decl != null && decl.context instanceof ModuleExp && !decl.isPublic() && !decl.getFlag(4096L) && (value = decl.getValue()) instanceof LambdaExp && !(lexp = (LambdaExp)value).getNeedsClosureEnv()) {
                skipFunc = true;
            }
        } else if (exp.func instanceof QuoteExp && exp.getArgCount() > 0) {
            Declaration decl;
            Expression value;
            Object val = ((QuoteExp)exp.func).getValue();
            Expression arg0 = exp.getArg(0);
            if (val instanceof PrimProcedure && ((PrimProcedure)val).isConstructor() && arg0 instanceof ReferenceExp && (decl = Declaration.followAliases(((ReferenceExp)arg0).binding)) != null && decl.context == this.comp.getModule() && !decl.getFlag(4096L) && (value = decl.getValue()) instanceof ClassExp) {
                Expression[] args = exp.getArgs();
                LambdaExp lexp = (LambdaExp)value;
                if (!lexp.getNeedsClosureEnv()) {
                    decl.addCaller(exp);
                    for (int i = 1; i < args.length; ++i) {
                        args[i].visit(this, ignored);
                    }
                    skipArgs = true;
                    skipFunc = true;
                }
            }
        }
        if (!skipFunc) {
            exp.func = exp.func.visit(this, ignored);
        }
        if (this.exitValue == null && !skipArgs) {
            int inserted;
            int nargs = exp.args.length;
            for (int i = 0; i < nargs; nargs += inserted, ++i) {
                Expression arg = (Expression)this.visit(exp.args[i], null);
                inserted = exp.args.length - nargs;
                exp.args[i += inserted] = arg;
            }
        }
        if (this.backJumpPossible > oldBackJumpPossible) {
            exp.setFlag(8);
        }
        return exp;
    }

    @Override
    public void visitDefaultArgs(LambdaExp exp, Void ignored) {
        super.visitDefaultArgs(exp, ignored);
        for (Declaration param = exp.firstDecl(); param != null; param = param.nextDecl()) {
            if (param.isSimple()) continue;
            exp.setFlag(true, 512);
            break;
        }
    }

    @Override
    protected Expression visitClassExp(ClassExp exp, Void ignored) {
        Expression ret = (Expression)super.visitClassExp(exp, ignored);
        if (!exp.explicitInit && !exp.instanceType.isInterface()) {
            Compilation.getConstructor(exp.instanceType, exp);
        } else if (exp.getNeedsClosureEnv()) {
            LambdaExp child = exp.firstChild;
            while (child != null) {
                if ("*init*".equals(child.getName())) {
                    child.setNeedsStaticLink(true);
                }
                child = child.nextSibling;
            }
        }
        if (exp.isSimple() && exp.getNeedsClosureEnv() && exp.nameDecl != null && exp.nameDecl.getType() == Compilation.typeClass) {
            exp.nameDecl.setType(Compilation.typeClassType);
        }
        return ret;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    protected Expression visitModuleExp(ModuleExp exp, Void ignored) {
        ModuleExp saveModule = this.currentModule;
        Hashtable saveDecls = this.unknownDecls;
        this.currentModule = exp;
        this.unknownDecls = null;
        try {
            Expression expression = this.visitLambdaExp((LambdaExp)exp, ignored);
            return expression;
        }
        finally {
            this.currentModule = saveModule;
            this.unknownDecls = saveDecls;
        }
    }

    void maybeWarnNoDeclarationSeen(Object name, boolean function2, Compilation comp, SourceLocator location2) {
        if (comp.resolve(name, function2) == null) {
            this.maybeWarnNoDeclarationSeen(name, comp, location2);
        }
    }

    void maybeWarnNoDeclarationSeen(Object name, Compilation comp, SourceLocator location2) {
        if (comp.warnUndefinedVariable()) {
            comp.error('w', "no declaration seen for " + name, location2);
        }
    }

    @Override
    protected Expression visitFluidLetExp(FluidLetExp exp, Void ignored) {
        for (Declaration decl = exp.firstDecl(); decl != null; decl = decl.nextDecl()) {
            if (decl.base != null) continue;
            Object name = decl.getSymbol();
            Declaration bind = this.allocUnboundDecl(name, false);
            if (!decl.getFlag(0x10000000L)) {
                this.maybeWarnNoDeclarationSeen(name, this.comp, exp);
            }
            this.capture(bind, null);
            decl.base = bind;
        }
        return (Expression)super.visitLetExp(exp, ignored);
    }

    @Override
    protected Expression visitLetExp(LetExp exp, Void ignored) {
        if (exp.body instanceof BeginExp) {
            Expression[] exps = ((BeginExp)exp.body).exps;
            int init_index = 0;
            Declaration decl = exp.firstDecl();
            for (int begin_index = 0; begin_index < exps.length && decl != null; ++begin_index) {
                Expression st = exps[begin_index];
                if (!(st instanceof SetExp)) continue;
                SetExp set = (SetExp)st;
                if (set.binding != decl || decl.getInitValue() != QuoteExp.nullExp || !set.isDefining()) continue;
                Expression new_value = set.new_value;
                if ((new_value instanceof QuoteExp || new_value instanceof LambdaExp) && decl.getValue() == new_value) {
                    decl.setInitValue(new_value);
                    exps[begin_index] = QuoteExp.voidExp;
                }
                ++init_index;
                decl = decl.nextDecl();
            }
        }
        return (Expression)super.visitLetExp(exp, ignored);
    }

    @Override
    protected Expression visitLambdaExp(LambdaExp exp, Void ignored) {
        if (exp.getInlineOnly()) {
            ++this.backJumpPossible;
        }
        return (Expression)super.visitLambdaExp(exp, ignored);
    }

    @Override
    protected Expression visitCaseExp(CaseExp exp, Void ignored) {
        exp.key = (Expression)this.visit(exp.key, ignored);
        for (int i = 0; i < exp.clauses.length; ++i) {
            Expression e = exp.clauses[i].exp;
            e = (Expression)this.visit(e, ignored);
        }
        CaseExp.CaseClause ecl = exp.elseClause;
        if (ecl != null) {
            ecl.exp = (Expression)this.visit(ecl.exp, ignored);
        }
        return exp;
    }

    public void capture(Declaration decl, ReferenceExp rexp) {
        LambdaExp declValue;
        LambdaExp curLambda;
        if (!decl.getCanReadOrCall()) {
            return;
        }
        if (decl.field != null && decl.field.getStaticFlag()) {
            return;
        }
        if (this.comp.immediate && decl.hasConstantValue()) {
            return;
        }
        ScopeExp sc = decl.getContext();
        LambdaExp declLambda = sc.currentLambda();
        LambdaExp oldParent = null;
        LambdaExp chain = null;
        for (curLambda = this.getCurrentLambda(); curLambda != declLambda && curLambda.getInlineOnly(); curLambda = curLambda.getCaller()) {
            LambdaExp curParent = curLambda.outerLambda();
            if (curParent != oldParent) {
                chain = curParent.firstChild;
                oldParent = curParent;
            }
            if (chain == null || curLambda.inlineHome == null) {
                return;
            }
            chain = chain.nextSibling;
        }
        if (this.comp.usingCPStyle() ? curLambda instanceof ModuleExp : curLambda == declLambda) {
            return;
        }
        Expression value = decl.getValue();
        if (value == null || !(value instanceof LambdaExp)) {
            declValue = null;
        } else {
            declValue = (LambdaExp)value;
            if (declValue.getInlineOnly()) {
                return;
            }
            if (declValue.isHandlingTailCalls()) {
                declValue = null;
            } else if (declValue == curLambda && !decl.getCanRead()) {
                return;
            }
        }
        if (decl.getFlag(65536L)) {
            for (LambdaExp parent = curLambda; parent != declLambda; parent = parent.outerLambda()) {
                if (parent.nameDecl == null || !parent.nameDecl.getFlag(2048L)) continue;
                decl.setFlag(2048L);
                break;
            }
        }
        if (decl.base != null) {
            decl.base.setCanRead(true);
            this.capture(decl.base, null);
        } else if (decl.getCanReadOrCall() || declValue == null) {
            if (!decl.isStatic()) {
                ScopeExp outer;
                LambdaExp parent;
                LambdaExp heapLambda = curLambda;
                if (!(rexp == null || decl.nvalues != 1 || decl.hasUnknownValue() || decl.getValueRaw() instanceof LambdaExp || decl.getFlag(0x10000000000L) || curLambda.getInlineOnly() || curLambda.getCanRead() || curLambda.nameDecl == null || curLambda.nameDecl.context.isClassGenerated() || curLambda.min_args != curLambda.max_args)) {
                    Declaration ndecl = null;
                    for (ndecl = curLambda.firstDecl(); !(ndecl == null || ndecl.getFlag(131072L) && ndecl.base == decl); ndecl = ndecl.nextDecl()) {
                    }
                    if (ndecl == null) {
                        ndecl = new Declaration(decl.getSymbol());
                        ndecl.base = decl;
                        ndecl.setFlag(131072L);
                        ndecl.setCanRead(true);
                        curLambda.add(null, ndecl);
                        ++curLambda.min_args;
                        ++curLambda.max_args;
                        ApplyExp exp = curLambda.nameDecl.firstCall;
                        while (exp != null) {
                            LambdaExp context = exp.context;
                            Expression[] args = exp.getArgs();
                            Expression[] nargs = new Expression[args.length + 1];
                            boolean recursive = exp.context == curLambda;
                            ReferenceExp ref = new ReferenceExp(recursive ? ndecl : decl);
                            nargs[0] = ref;
                            System.arraycopy(args, 0, nargs, 1, args.length);
                            exp.setArgs(nargs);
                            LambdaExp saveLambda = this.currentLambda;
                            this.currentLambda = context;
                            this.capture(decl, ref);
                            this.currentLambda = saveLambda;
                            exp = exp.nextCall;
                        }
                    }
                    rexp.setBinding(ndecl);
                    return;
                }
                if (decl.context instanceof ClassExp) {
                    if (heapLambda.getOuter() == decl.context) {
                        return;
                    }
                    LambdaExp methodLambda = heapLambda;
                    while (methodLambda != null) {
                        outer = methodLambda.getOuter();
                        if (outer == decl.context) {
                            Declaration thisDecl = methodLambda.firstDecl();
                            if (thisDecl == null || !thisDecl.isThisParameter()) break;
                            this.capture(thisDecl, null);
                            return;
                        }
                        methodLambda = outer;
                    }
                }
                if (!decl.isFluid()) {
                    heapLambda.setImportsLexVars();
                }
                outer = parent = heapLambda.outerLambda();
                while (outer != declLambda && outer != null) {
                    heapLambda = outer;
                    if (!decl.getCanReadOrCall() && declValue == outer) break;
                    Declaration heapDecl = heapLambda.nameDecl;
                    if (heapDecl != null && heapDecl.getFlag(2048L)) {
                        this.comp.error('e', "static " + heapLambda.getName() + " references non-static " + decl.getName());
                    }
                    if (heapLambda instanceof ClassExp && heapLambda.getName() != null && ((ClassExp)heapLambda).isSimple()) {
                        this.comp.error('w', heapLambda.nameDecl, "simple class ", " requiring lexical link (because of reference to " + decl.getName() + ") - use define-class instead");
                    }
                    heapLambda.setNeedsStaticLink();
                    outer = heapLambda.outerLambda();
                }
            }
            declLambda.capture(decl);
        }
    }

    Declaration allocUnboundDecl(Object name, boolean function2) {
        Declaration decl;
        Object key = name;
        if (function2 && name instanceof Symbol) {
            if (!this.getCompilation().getLanguage().hasSeparateFunctionNamespace()) {
                function2 = false;
            } else {
                key = new KeyPair((Symbol)name, EnvironmentKey.FUNCTION);
            }
        }
        if (this.unknownDecls == null) {
            this.unknownDecls = new Hashtable(100);
            decl = null;
        } else {
            decl = (Declaration)this.unknownDecls.get(key);
        }
        if (decl == null) {
            decl = this.currentModule.addDeclaration(name);
            decl.setSimple(false);
            decl.setPrivate(true);
            if (function2) {
                decl.setProcedureDecl(true);
            }
            if (this.currentModule.isStatic()) {
                decl.setFlag(2048L);
            }
            decl.setCanRead(true);
            decl.setCanWrite(true);
            decl.noteValueUnknown();
            decl.setFlag(327680L);
            decl.setIndirectBinding(true);
            this.unknownDecls.put(key, decl);
        }
        return decl;
    }

    @Override
    protected Expression visitReferenceExp(ReferenceExp exp, Void ignored) {
        Declaration decl = exp.getBinding();
        if (decl == null) {
            decl = this.allocUnboundDecl(exp.getSymbol(), exp.isProcedureName());
            exp.setBinding(decl);
        }
        if (decl.getFlag(65536L)) {
            this.maybeWarnNoDeclarationSeen(exp.getSymbol(), exp.isProcedureName(), this.comp, exp);
        }
        this.capture(exp.contextDecl(), decl, exp);
        return exp;
    }

    void capture(Declaration containing, Declaration decl, ReferenceExp exp) {
        Expression dvalue;
        if (decl.isAlias() && (dvalue = decl.getValue()) instanceof ReferenceExp) {
            ReferenceExp rexp = (ReferenceExp)dvalue;
            Declaration orig = rexp.binding;
            if (!(orig == null || containing != null && orig.needsContext())) {
                this.capture(rexp.contextDecl(), orig, null);
                return;
            }
        }
        while (decl.isFluid() && decl.context instanceof FluidLetExp) {
            decl = decl.base;
        }
        if (containing != null && decl.needsContext()) {
            this.capture(containing, null);
        } else {
            this.capture(decl, exp);
        }
    }

    @Override
    protected Expression visitThisExp(ThisExp exp, Void ignored) {
        if (exp.isForContext()) {
            LambdaExp curLambda = this.getCurrentLambda();
            if (!(curLambda instanceof ModuleExp) || !((ModuleExp)curLambda).staticInitRun()) {
                curLambda.setImportsLexVars();
            }
            return exp;
        }
        return this.visitReferenceExp((ReferenceExp)exp, ignored);
    }

    @Override
    protected Expression visitSetExp(SetExp exp, Void ignored) {
        Declaration decl = exp.binding;
        if (decl == null) {
            exp.binding = decl = this.allocUnboundDecl(exp.getSymbol(), exp.isFuncDef());
        }
        if (decl.getFlag(65536L)) {
            this.maybeWarnNoDeclarationSeen(exp.getSymbol(), false, this.comp, exp);
        }
        if (!decl.ignorable()) {
            if (!exp.isDefining()) {
                decl = Declaration.followAliases(decl);
            }
            this.capture(exp.contextDecl(), decl, null);
        }
        return (Expression)super.visitSetExp(exp, ignored);
    }
}

