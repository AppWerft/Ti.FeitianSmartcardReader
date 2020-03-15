// 
// Decompiled by Procyon v0.5.36
// 

package gnu.expr;

import gnu.mapping.KeyPair;
import gnu.mapping.EnvironmentKey;
import gnu.mapping.Symbol;
import gnu.text.SourceLocator;
import gnu.bytecode.Type;
import java.util.Hashtable;

public class FindCapturedVars extends ExpExpVisitor<Void>
{
    int backJumpPossible;
    Hashtable unknownDecls;
    ModuleExp currentModule;
    
    public FindCapturedVars() {
        this.backJumpPossible = 0;
        this.unknownDecls = null;
        this.currentModule = null;
    }
    
    public static void findCapturedVars(final Expression exp, final Compilation comp) {
        final FindCapturedVars visitor = new FindCapturedVars();
        visitor.setContext(comp);
        exp.visit((ExpVisitor<Object, Object>)visitor, null);
    }
    
    @Override
    protected final void visitDeclarationType(final Declaration decl) {
    }
    
    protected Expression visitApplyExp(final ApplyExp exp, final Void ignored) {
        final int oldBackJumpPossible = this.backJumpPossible;
        boolean skipFunc = false;
        boolean skipArgs = false;
        if (exp.func instanceof ReferenceExp && this.getCompilation().currentCallConvention() <= 1) {
            final Declaration decl = Declaration.followAliases(((ReferenceExp)exp.func).binding);
            if (decl != null && decl.context instanceof ModuleExp && !decl.isPublic() && !decl.getFlag(4096L)) {
                final Expression value = decl.getValue();
                if (value instanceof LambdaExp) {
                    final LambdaExp lexp = (LambdaExp)value;
                    if (!lexp.getNeedsClosureEnv()) {
                        skipFunc = true;
                    }
                }
            }
        }
        else if (exp.func instanceof QuoteExp && exp.getArgCount() > 0) {
            final Object val = ((QuoteExp)exp.func).getValue();
            final Expression arg0 = exp.getArg(0);
            if (val instanceof PrimProcedure && ((PrimProcedure)val).isConstructor() && arg0 instanceof ReferenceExp) {
                final Declaration decl2 = Declaration.followAliases(((ReferenceExp)arg0).binding);
                if (decl2 != null && decl2.context == this.comp.getModule() && !decl2.getFlag(4096L)) {
                    final Expression value2 = decl2.getValue();
                    if (value2 instanceof ClassExp) {
                        final Expression[] args = exp.getArgs();
                        final LambdaExp lexp2 = (LambdaExp)value2;
                        if (!lexp2.getNeedsClosureEnv()) {
                            decl2.addCaller(exp);
                            for (int i = 1; i < args.length; ++i) {
                                args[i].visit((ExpVisitor<Object, Void>)this, ignored);
                            }
                            skipArgs = (skipFunc = true);
                        }
                    }
                }
            }
        }
        if (!skipFunc) {
            exp.func = exp.func.visit((ExpVisitor<Expression, Void>)this, ignored);
        }
        if (this.exitValue == null && !skipArgs) {
            Expression arg2;
            int inserted;
            for (int nargs = exp.args.length, j = 0; j < nargs; j += inserted, exp.args[j] = arg2, nargs += inserted, ++j) {
                arg2 = this.visit(exp.args[j], null);
                inserted = exp.args.length - nargs;
            }
        }
        if (this.backJumpPossible > oldBackJumpPossible) {
            exp.setFlag(8);
        }
        return exp;
    }
    
    public void visitDefaultArgs(final LambdaExp exp, final Void ignored) {
        super.visitDefaultArgs(exp, (D)ignored);
        for (Declaration param = exp.firstDecl(); param != null; param = param.nextDecl()) {
            if (!param.isSimple()) {
                exp.setFlag(true, 512);
                break;
            }
        }
    }
    
    protected Expression visitClassExp(final ClassExp exp, final Void ignored) {
        final Expression ret = super.visitClassExp(exp, (D)ignored);
        if (!exp.explicitInit && !exp.instanceType.isInterface()) {
            Compilation.getConstructor(exp.instanceType, exp);
        }
        else if (exp.getNeedsClosureEnv()) {
            for (LambdaExp child = exp.firstChild; child != null; child = child.nextSibling) {
                if ("*init*".equals(child.getName())) {
                    child.setNeedsStaticLink(true);
                }
            }
        }
        if (exp.isSimple() && exp.getNeedsClosureEnv() && exp.nameDecl != null && exp.nameDecl.getType() == Compilation.typeClass) {
            exp.nameDecl.setType(Compilation.typeClassType);
        }
        return ret;
    }
    
    protected Expression visitModuleExp(final ModuleExp exp, final Void ignored) {
        final ModuleExp saveModule = this.currentModule;
        final Hashtable saveDecls = this.unknownDecls;
        this.currentModule = exp;
        this.unknownDecls = null;
        try {
            return this.visitLambdaExp(exp, ignored);
        }
        finally {
            this.currentModule = saveModule;
            this.unknownDecls = saveDecls;
        }
    }
    
    void maybeWarnNoDeclarationSeen(final Object name, final boolean function, final Compilation comp, final SourceLocator location) {
        if (comp.resolve(name, function) == null) {
            this.maybeWarnNoDeclarationSeen(name, comp, location);
        }
    }
    
    void maybeWarnNoDeclarationSeen(final Object name, final Compilation comp, final SourceLocator location) {
        if (comp.warnUndefinedVariable()) {
            comp.error('w', "no declaration seen for " + name, location);
        }
    }
    
    protected Expression visitFluidLetExp(final FluidLetExp exp, final Void ignored) {
        for (Declaration decl = exp.firstDecl(); decl != null; decl = decl.nextDecl()) {
            if (decl.base == null) {
                final Object name = decl.getSymbol();
                final Declaration bind = this.allocUnboundDecl(name, false);
                if (!decl.getFlag(268435456L)) {
                    this.maybeWarnNoDeclarationSeen(name, this.comp, exp);
                }
                this.capture(bind, null);
                decl.base = bind;
            }
        }
        return super.visitLetExp(exp, (D)ignored);
    }
    
    protected Expression visitLetExp(final LetExp exp, final Void ignored) {
        if (exp.body instanceof BeginExp) {
            final Expression[] exps = ((BeginExp)exp.body).exps;
            int init_index = 0;
            Declaration decl = exp.firstDecl();
            for (int begin_index = 0; begin_index < exps.length && decl != null; ++begin_index) {
                final Expression st = exps[begin_index];
                if (st instanceof SetExp) {
                    final SetExp set = (SetExp)st;
                    if (set.binding == decl && decl.getInitValue() == QuoteExp.nullExp && set.isDefining()) {
                        final Expression new_value = set.new_value;
                        if ((new_value instanceof QuoteExp || new_value instanceof LambdaExp) && decl.getValue() == new_value) {
                            decl.setInitValue(new_value);
                            exps[begin_index] = QuoteExp.voidExp;
                        }
                        ++init_index;
                        decl = decl.nextDecl();
                    }
                }
            }
        }
        return super.visitLetExp(exp, (D)ignored);
    }
    
    protected Expression visitLambdaExp(final LambdaExp exp, final Void ignored) {
        if (exp.getInlineOnly()) {
            ++this.backJumpPossible;
        }
        return super.visitLambdaExp(exp, (D)ignored);
    }
    
    protected Expression visitCaseExp(final CaseExp exp, final Void ignored) {
        exp.key = this.visit(exp.key, (D)ignored);
        for (int i = 0; i < exp.clauses.length; ++i) {
            Expression e = exp.clauses[i].exp;
            e = this.visit(e, (D)ignored);
        }
        final CaseExp.CaseClause ecl = exp.elseClause;
        if (ecl != null) {
            ecl.exp = this.visit(ecl.exp, (D)ignored);
        }
        return exp;
    }
    
    public void capture(final Declaration decl, final ReferenceExp rexp) {
        if (!decl.getCanReadOrCall()) {
            return;
        }
        if (decl.field != null && decl.field.getStaticFlag()) {
            return;
        }
        if (this.comp.immediate && decl.hasConstantValue()) {
            return;
        }
        LambdaExp curLambda = this.getCurrentLambda();
        final ScopeExp sc = decl.getContext();
        final LambdaExp declLambda = sc.currentLambda();
        LambdaExp oldParent = null;
        for (LambdaExp chain = null; curLambda != declLambda && curLambda.getInlineOnly(); curLambda = curLambda.getCaller(), chain = chain.nextSibling) {
            final LambdaExp curParent = curLambda.outerLambda();
            if (curParent != oldParent) {
                chain = curParent.firstChild;
                oldParent = curParent;
            }
            if (chain == null || curLambda.inlineHome == null) {
                return;
            }
        }
        if (this.comp.usingCPStyle()) {
            if (curLambda instanceof ModuleExp) {
                return;
            }
        }
        else if (curLambda == declLambda) {
            return;
        }
        final Expression value = decl.getValue();
        LambdaExp declValue;
        if (value == null || !(value instanceof LambdaExp)) {
            declValue = null;
        }
        else {
            declValue = (LambdaExp)value;
            if (declValue.getInlineOnly()) {
                return;
            }
            if (declValue.isHandlingTailCalls()) {
                declValue = null;
            }
            else if (declValue == curLambda && !decl.getCanRead()) {
                return;
            }
        }
        if (decl.getFlag(65536L)) {
            for (LambdaExp parent = curLambda; parent != declLambda; parent = parent.outerLambda()) {
                if (parent.nameDecl != null && parent.nameDecl.getFlag(2048L)) {
                    decl.setFlag(2048L);
                    break;
                }
            }
        }
        if (decl.base != null) {
            decl.base.setCanRead(true);
            this.capture(decl.base, null);
        }
        else if (decl.getCanReadOrCall() || declValue == null) {
            if (!decl.isStatic()) {
                LambdaExp heapLambda = curLambda;
                if (rexp != null && decl.nvalues == 1 && !decl.hasUnknownValue() && !(decl.getValueRaw() instanceof LambdaExp) && !decl.getFlag(1099511627776L) && !curLambda.getInlineOnly() && !curLambda.getCanRead() && curLambda.nameDecl != null && !curLambda.nameDecl.context.isClassGenerated() && curLambda.min_args == curLambda.max_args) {
                    Declaration ndecl;
                    for (ndecl = null, ndecl = curLambda.firstDecl(); ndecl != null && (!ndecl.getFlag(131072L) || ndecl.base != decl); ndecl = ndecl.nextDecl()) {}
                    if (ndecl == null) {
                        ndecl = new Declaration(decl.getSymbol());
                        ndecl.base = decl;
                        ndecl.setFlag(131072L);
                        ndecl.setCanRead(true);
                        curLambda.add(null, ndecl);
                        final LambdaExp lambdaExp = curLambda;
                        ++lambdaExp.min_args;
                        final LambdaExp lambdaExp2 = curLambda;
                        ++lambdaExp2.max_args;
                        for (ApplyExp exp = curLambda.nameDecl.firstCall; exp != null; exp = exp.nextCall) {
                            final LambdaExp context = exp.context;
                            final Expression[] args = exp.getArgs();
                            final Expression[] nargs = new Expression[args.length + 1];
                            final boolean recursive = exp.context == curLambda;
                            final ReferenceExp ref = new ReferenceExp(recursive ? ndecl : decl);
                            nargs[0] = ref;
                            System.arraycopy(args, 0, nargs, 1, args.length);
                            exp.setArgs(nargs);
                            final LambdaExp saveLambda = this.currentLambda;
                            this.currentLambda = context;
                            this.capture(decl, ref);
                            this.currentLambda = saveLambda;
                        }
                    }
                    rexp.setBinding(ndecl);
                    return;
                }
                if (decl.context instanceof ClassExp) {
                    if (heapLambda.getOuter() == decl.context) {
                        return;
                    }
                    ScopeExp methodLambda = heapLambda;
                    while (methodLambda != null) {
                        final ScopeExp outer = methodLambda.getOuter();
                        if (outer == decl.context) {
                            final Declaration thisDecl = methodLambda.firstDecl();
                            if (thisDecl != null && thisDecl.isThisParameter()) {
                                this.capture(thisDecl, null);
                                return;
                            }
                            break;
                        }
                        else {
                            methodLambda = outer;
                        }
                    }
                }
                if (!decl.isFluid()) {
                    heapLambda.setImportsLexVars();
                }
                LambdaExp outer2;
                for (LambdaExp parent2 = outer2 = heapLambda.outerLambda(); outer2 != declLambda && outer2 != null; outer2 = heapLambda.outerLambda()) {
                    heapLambda = outer2;
                    if (!decl.getCanReadOrCall() && declValue == outer2) {
                        break;
                    }
                    final Declaration heapDecl = heapLambda.nameDecl;
                    if (heapDecl != null && heapDecl.getFlag(2048L)) {
                        this.comp.error('e', "static " + heapLambda.getName() + " references non-static " + decl.getName());
                    }
                    if (heapLambda instanceof ClassExp && heapLambda.getName() != null && ((ClassExp)heapLambda).isSimple()) {
                        this.comp.error('w', heapLambda.nameDecl, "simple class ", " requiring lexical link (because of reference to " + decl.getName() + ") - use define-class instead");
                    }
                    heapLambda.setNeedsStaticLink();
                }
            }
            declLambda.capture(decl);
        }
    }
    
    Declaration allocUnboundDecl(final Object name, boolean function) {
        Object key = name;
        if (function && name instanceof Symbol) {
            if (!this.getCompilation().getLanguage().hasSeparateFunctionNamespace()) {
                function = false;
            }
            else {
                key = new KeyPair((Symbol)name, EnvironmentKey.FUNCTION);
            }
        }
        Declaration decl;
        if (this.unknownDecls == null) {
            this.unknownDecls = new Hashtable(100);
            decl = null;
        }
        else {
            decl = this.unknownDecls.get(key);
        }
        if (decl == null) {
            decl = this.currentModule.addDeclaration(name);
            decl.setSimple(false);
            decl.setPrivate(true);
            if (function) {
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
    
    protected Expression visitReferenceExp(final ReferenceExp exp, final Void ignored) {
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
    
    void capture(final Declaration containing, Declaration decl, final ReferenceExp exp) {
        final Expression dvalue;
        if (decl.isAlias() && (dvalue = decl.getValue()) instanceof ReferenceExp) {
            final ReferenceExp rexp = (ReferenceExp)dvalue;
            final Declaration orig = rexp.binding;
            if (orig != null && (containing == null || !orig.needsContext())) {
                this.capture(rexp.contextDecl(), orig, null);
                return;
            }
        }
        while (decl.isFluid() && decl.context instanceof FluidLetExp) {
            decl = decl.base;
        }
        if (containing != null && decl.needsContext()) {
            this.capture(containing, null);
        }
        else {
            this.capture(decl, exp);
        }
    }
    
    protected Expression visitThisExp(final ThisExp exp, final Void ignored) {
        if (exp.isForContext()) {
            final LambdaExp curLambda = this.getCurrentLambda();
            if (!(curLambda instanceof ModuleExp) || !((ModuleExp)curLambda).staticInitRun()) {
                curLambda.setImportsLexVars();
            }
            return exp;
        }
        return this.visitReferenceExp(exp, ignored);
    }
    
    protected Expression visitSetExp(final SetExp exp, final Void ignored) {
        Declaration decl = exp.binding;
        if (decl == null) {
            decl = this.allocUnboundDecl(exp.getSymbol(), exp.isFuncDef());
            exp.binding = decl;
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
        return super.visitSetExp(exp, (D)ignored);
    }
}
