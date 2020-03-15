// 
// Decompiled by Procyon v0.5.36
// 

package kawa.standard;

import gnu.bytecode.Method;
import gnu.lists.LList;
import gnu.expr.ReferenceExp;
import gnu.expr.Keyword;
import gnu.expr.BeginExp;
import gnu.mapping.Procedure;
import gnu.expr.ApplyExp;
import gnu.kawa.reflect.Invoke;
import gnu.bytecode.ClassType;
import gnu.expr.QuoteExp;
import gnu.expr.Special;
import gnu.expr.Declaration;
import kawa.lang.TemplateScope;
import gnu.expr.LangExp;
import gnu.expr.SetExp;
import gnu.expr.Expression;
import gnu.bytecode.Type;
import gnu.expr.Compilation;
import gnu.expr.LambdaExp;
import gnu.expr.ModuleExp;
import gnu.mapping.Symbol;
import kawa.lang.SyntaxForm;
import kawa.lang.Translator;
import gnu.expr.ScopeExp;
import gnu.lists.Pair;
import kawa.lang.Lambda;
import kawa.lang.Syntax;

public class define extends Syntax
{
    public static final define defineRaw;
    Lambda lambda;
    
    String getName(final int options) {
        if ((options & 0x4) != 0x0) {
            return "define-private";
        }
        if ((options & 0x8) != 0x0) {
            return "define-constant";
        }
        if ((options & 0x20) != 0x0) {
            return "define-variable";
        }
        return "define";
    }
    
    public define(final Lambda lambda) {
        this.lambda = lambda;
    }
    
    @Override
    public void scanForm(Pair st, final ScopeExp defs, final Translator tr) {
        final Pair p1 = (Pair)st.getCdr();
        final Pair p2 = (Pair)p1.getCdr();
        final Pair p3 = (Pair)p2.getCdr();
        TemplateScope templateScope = null;
        Object name;
        SyntaxForm nameSyntax;
        for (name = p1.getCar(); name instanceof SyntaxForm; name = nameSyntax.getDatum()) {
            nameSyntax = (SyntaxForm)name;
            templateScope = nameSyntax.getScope();
        }
        final int options = ((Number)Translator.stripSyntax(p2.getCar())).intValue();
        final boolean makePrivate = (options & 0x4) != 0x0;
        final boolean makeConstant = (options & 0x8) != 0x0;
        final boolean makeFluid = (options & 0x20) != 0x0;
        final boolean makeCompoundProcedure = options == 27;
        name = tr.namespaceResolve(name);
        if (!(name instanceof Symbol)) {
            tr.error('e', "'" + name + "' is not a valid identifier");
            name = null;
        }
        final Object savePos = tr.pushPositionOf(p1);
        final Declaration decl = tr.define(name, templateScope, defs);
        tr.popPositionOf(savePos);
        name = decl.getSymbol();
        if (makePrivate) {
            if (defs instanceof ModuleExp && defs.getFlag(4194304)) {
                tr.error('w', "'define-private' should not be used in interactive mode");
            }
            else {
                decl.setFlag(16777216L);
                decl.setPrivate(true);
            }
        }
        if (makeConstant) {
            decl.setFlag(16384L);
        }
        if ((options & 0x10) != 0x0) {
            decl.setFlag(536870912L);
        }
        decl.setFlag(262144L);
        Expression value;
        if ((options & 0x2) != 0x0 && !makeCompoundProcedure) {
            final LambdaExp lexp = new LambdaExp();
            lexp.setSymbol(name);
            if (Compilation.inlineOk) {
                decl.setProcedureDecl(true);
                decl.setType(Compilation.typeProcedure);
                lexp.nameDecl = decl;
            }
            Translator.setLine(lexp, p1);
            value = lexp;
        }
        else {
            value = null;
        }
        final SetExp sexp = new SetExp(decl, value);
        if (defs instanceof ModuleExp && !makePrivate && !makeConstant && (!Compilation.inlineOk || tr.sharedModuleDefs())) {
            decl.setCanWrite(true);
        }
        if (makeFluid) {
            decl.setSimple(false);
            decl.setPrivate(true);
            decl.setFlag(268435456L);
            decl.setCanRead(true);
            decl.setCanWrite(true);
            decl.setIndirectBinding(true);
            sexp.setSetIfUnbound(true);
        }
        if ((options & 0x1) != 0x0) {
            decl.setTypeExp(new LangExp(p3));
            decl.setFlag(8192L);
        }
        st = Translator.makePair(st, this, Translator.makePair(p1, sexp, p2));
        Translator.setLine(decl, p1);
        tr.pushForm(st);
    }
    
    @Override
    public Expression rewriteForm(final Pair form, final Translator tr) {
        final Pair p1 = (Pair)form.getCdr();
        final Pair p2 = (Pair)p1.getCdr();
        final Pair p3 = (Pair)p2.getCdr();
        Pair p4 = (Pair)p3.getCdr();
        final Object name = p1.getCar();
        final int options = ((Number)Translator.stripSyntax(p2.getCar())).intValue();
        final boolean makePrivate = (options & 0x4) != 0x0;
        final boolean makeFluid = (options & 0x20) != 0x0;
        final boolean makeCompoundProcedure = options == 27;
        if (!(name instanceof SetExp)) {
            return tr.syntaxError(this.getName(options) + " is only allowed in a <body>");
        }
        final SetExp sexp = (SetExp)name;
        final Declaration decl = sexp.getBinding();
        if (decl.getFlag(8192L)) {
            final Expression texp = decl.getTypeExp();
            if (texp instanceof LangExp) {
                final Pair typeSpecPair = (Pair)((LangExp)texp).getLangValue();
                decl.setType(tr.exp2Type(typeSpecPair));
            }
        }
        if (makeFluid && Translator.stripSyntax(p4.getCar()) == Special.undefined) {
            return QuoteExp.voidExp;
        }
        BeginExp bexp2 = null;
        boolean unknownValue;
        if ((options & 0x2) != 0x0 && !makeCompoundProcedure) {
            final LambdaExp lexp = (LambdaExp)sexp.getNewValue();
            final Object formals = p4.getCar();
            final Object body = p4.getCdr();
            this.lambda.rewrite(lexp, formals, body, tr, null);
            unknownValue = !Compilation.inlineOk;
        }
        else {
            unknownValue = (decl.context instanceof ModuleExp && !makePrivate && decl.getCanWrite());
            if (makeCompoundProcedure) {
                tr.letStart();
                final ClassType classGenericProc = ClassType.make("gnu.expr.GenericProc");
                final Declaration gproc = tr.letVariable(null, classGenericProc, new ApplyExp(Invoke.make, new Expression[] { QuoteExp.getInstance(classGenericProc), QuoteExp.getInstance(decl.getName()) }));
                gproc.setFlag(549755813888L);
                tr.letEnter();
                final BeginExp bexp3 = new BeginExp();
                final Method addMethod = classGenericProc.getDeclaredMethod("add", 1);
                final Method setPropMethod = classGenericProc.getDeclaredMethod("setProperty", 2);
                while (true) {
                    Keyword key = null;
                    final Object car = Translator.stripSyntax(p4.getCar());
                    if (car instanceof Keyword) {
                        key = (Keyword)car;
                        final Object cdr = p4.getCdr();
                        if (!(cdr instanceof Pair) || Translator.safeCar(cdr) instanceof Keyword) {
                            tr.error('e', "missing value following keyword");
                            break;
                        }
                        p4 = (Pair)cdr;
                    }
                    final Expression arg = tr.rewrite_car(p4, false);
                    if (key != null) {
                        if (bexp2 == null) {
                            bexp2 = new BeginExp();
                        }
                        bexp2.add(new ApplyExp(setPropMethod, new Expression[] { new ReferenceExp(decl), QuoteExp.getInstance(key), arg }));
                    }
                    else {
                        final Declaration gdecl = (arg instanceof LambdaExp) ? gproc : decl;
                        final Expression addCall = new ApplyExp(addMethod, new Expression[] { new ReferenceExp(gdecl), arg });
                        if (arg instanceof LambdaExp) {
                            final LambdaExp larg = (LambdaExp)arg;
                            final String lname = larg.getName();
                            final String dname = decl.getName();
                            if ((lname == null || lname.equals(dname)) && decl.isPublic()) {
                                larg.setFlag(16384);
                            }
                            bexp3.add(addCall);
                        }
                        else {
                            if (bexp2 == null) {
                                bexp2 = new BeginExp();
                            }
                            bexp2.add(addCall);
                        }
                    }
                    final Object cdr2 = p4.getCdr();
                    if (!(cdr2 instanceof Pair)) {
                        if (cdr2 != LList.Empty) {
                            tr.error('e', "not a proper list");
                            break;
                        }
                        break;
                    }
                    else {
                        p4 = (Pair)cdr2;
                    }
                }
                final ReferenceExp gref = new ReferenceExp(gproc);
                gref.setFlag(32);
                bexp3.add(gref);
                sexp.setNewValue(tr.letDone(BeginExp.canonicalize(bexp3)));
            }
            else {
                sexp.setNewValue(tr.rewrite_car(p4, false));
            }
        }
        if (unknownValue) {
            decl.noteValueUnknown();
        }
        else {
            decl.noteValueFromSet(sexp);
        }
        sexp.setDefining(true);
        if (makePrivate && !(decl.getContext() instanceof ModuleExp)) {
            tr.error('w', "define-private not at top level");
        }
        if (bexp2 != null) {
            return new BeginExp(sexp, bexp2);
        }
        return sexp;
    }
    
    static {
        defineRaw = new define(SchemeCompilation.lambda);
    }
}
