/*
 * Decompiled with CFR 0.139.
 */
package kawa.standard;

import gnu.bytecode.ClassType;
import gnu.bytecode.Method;
import gnu.bytecode.Type;
import gnu.expr.ApplyExp;
import gnu.expr.BeginExp;
import gnu.expr.Compilation;
import gnu.expr.Declaration;
import gnu.expr.ErrorExp;
import gnu.expr.Expression;
import gnu.expr.Keyword;
import gnu.expr.LambdaExp;
import gnu.expr.LangExp;
import gnu.expr.LetExp;
import gnu.expr.ModuleExp;
import gnu.expr.QuoteExp;
import gnu.expr.ReferenceExp;
import gnu.expr.ScopeExp;
import gnu.expr.SetExp;
import gnu.expr.Special;
import gnu.kawa.reflect.Invoke;
import gnu.lists.EmptyList;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.mapping.Procedure;
import gnu.mapping.Symbol;
import kawa.lang.Lambda;
import kawa.lang.Syntax;
import kawa.lang.SyntaxForm;
import kawa.lang.TemplateScope;
import kawa.lang.Translator;
import kawa.standard.SchemeCompilation;

public class define
extends Syntax {
    public static final define defineRaw = new define(SchemeCompilation.lambda);
    Lambda lambda;

    String getName(int options) {
        if ((options & 4) != 0) {
            return "define-private";
        }
        if ((options & 8) != 0) {
            return "define-constant";
        }
        if ((options & 32) != 0) {
            return "define-variable";
        }
        return "define";
    }

    public define(Lambda lambda) {
        this.lambda = lambda;
    }

    @Override
    public void scanForm(Pair st, ScopeExp defs2, Translator tr) {
        LambdaExp value;
        Pair p1 = (Pair)st.getCdr();
        Pair p2 = (Pair)p1.getCdr();
        Pair p3 = (Pair)p2.getCdr();
        TemplateScope templateScope = null;
        Object name = p1.getCar();
        while (name instanceof SyntaxForm) {
            SyntaxForm nameSyntax = (SyntaxForm)name;
            templateScope = nameSyntax.getScope();
            name = nameSyntax.getDatum();
        }
        int options = ((Number)Translator.stripSyntax(p2.getCar())).intValue();
        boolean makePrivate = (options & 4) != 0;
        boolean makeConstant = (options & 8) != 0;
        boolean makeFluid = (options & 32) != 0;
        boolean makeCompoundProcedure = options == 27;
        if (!((name = tr.namespaceResolve(name)) instanceof Symbol)) {
            tr.error('e', "'" + name + "' is not a valid identifier");
            name = null;
        }
        Object savePos = tr.pushPositionOf(p1);
        Declaration decl = tr.define(name, templateScope, defs2);
        tr.popPositionOf(savePos);
        name = decl.getSymbol();
        if (makePrivate) {
            if (defs2 instanceof ModuleExp && defs2.getFlag(4194304)) {
                tr.error('w', "'define-private' should not be used in interactive mode");
            } else {
                decl.setFlag(0x1000000L);
                decl.setPrivate(true);
            }
        }
        if (makeConstant) {
            decl.setFlag(16384L);
        }
        if ((options & 16) != 0) {
            decl.setFlag(0x20000000L);
        }
        decl.setFlag(262144L);
        if ((options & 2) != 0 && !makeCompoundProcedure) {
            LambdaExp lexp = new LambdaExp();
            lexp.setSymbol(name);
            if (Compilation.inlineOk) {
                decl.setProcedureDecl(true);
                decl.setType(Compilation.typeProcedure);
                lexp.nameDecl = decl;
            }
            Translator.setLine(lexp, (Object)p1);
            value = lexp;
        } else {
            value = null;
        }
        SetExp sexp = new SetExp(decl, value);
        if (!(!(defs2 instanceof ModuleExp) || makePrivate || makeConstant || Compilation.inlineOk && !tr.sharedModuleDefs())) {
            decl.setCanWrite(true);
        }
        if (makeFluid) {
            decl.setSimple(false);
            decl.setPrivate(true);
            decl.setFlag(0x10000000L);
            decl.setCanRead(true);
            decl.setCanWrite(true);
            decl.setIndirectBinding(true);
            sexp.setSetIfUnbound(true);
        }
        if ((options & 1) != 0) {
            decl.setTypeExp(new LangExp(p3));
            decl.setFlag(8192L);
        }
        st = Translator.makePair(st, this, Translator.makePair(p1, sexp, p2));
        Translator.setLine(decl, (Object)p1);
        tr.pushForm(st);
    }

    @Override
    public Expression rewriteForm(Pair form, Translator tr) {
        Expression texp;
        boolean unknownValue;
        boolean makeCompoundProcedure;
        Pair p1 = (Pair)form.getCdr();
        Pair p2 = (Pair)p1.getCdr();
        Pair p3 = (Pair)p2.getCdr();
        Pair p4 = (Pair)p3.getCdr();
        Object name = p1.getCar();
        int options = ((Number)Translator.stripSyntax(p2.getCar())).intValue();
        boolean makePrivate = (options & 4) != 0;
        boolean makeFluid = (options & 32) != 0;
        boolean bl = makeCompoundProcedure = options == 27;
        if (!(name instanceof SetExp)) {
            return tr.syntaxError(this.getName(options) + " is only allowed in a <body>");
        }
        SetExp sexp = (SetExp)name;
        Declaration decl = sexp.getBinding();
        if (decl.getFlag(8192L) && (texp = decl.getTypeExp()) instanceof LangExp) {
            Pair typeSpecPair = (Pair)((LangExp)texp).getLangValue();
            decl.setType(tr.exp2Type(typeSpecPair));
        }
        if (makeFluid && Translator.stripSyntax(p4.getCar()) == Special.undefined) {
            return QuoteExp.voidExp;
        }
        BeginExp bexp2 = null;
        if ((options & 2) != 0 && !makeCompoundProcedure) {
            LambdaExp lexp = (LambdaExp)sexp.getNewValue();
            Object formals = p4.getCar();
            Object body = p4.getCdr();
            this.lambda.rewrite(lexp, formals, body, tr, null);
            unknownValue = !Compilation.inlineOk;
        } else {
            boolean bl2 = unknownValue = decl.context instanceof ModuleExp && !makePrivate && decl.getCanWrite();
            if (makeCompoundProcedure) {
                tr.letStart();
                ClassType classGenericProc = ClassType.make("gnu.expr.GenericProc");
                Declaration gproc = tr.letVariable(null, classGenericProc, new ApplyExp(Invoke.make, QuoteExp.getInstance(classGenericProc), QuoteExp.getInstance(decl.getName())));
                gproc.setFlag(0x8000000000L);
                tr.letEnter();
                BeginExp bexp1 = new BeginExp();
                Method addMethod = classGenericProc.getDeclaredMethod("add", 1);
                Method setPropMethod = classGenericProc.getDeclaredMethod("setProperty", 2);
                do {
                    Keyword key = null;
                    Object car = Translator.stripSyntax(p4.getCar());
                    if (car instanceof Keyword) {
                        key = (Keyword)car;
                        Object cdr = p4.getCdr();
                        if (!(cdr instanceof Pair) || Translator.safeCar(cdr) instanceof Keyword) {
                            tr.error('e', "missing value following keyword");
                            break;
                        }
                        p4 = (Pair)cdr;
                    }
                    Expression arg = tr.rewrite_car(p4, false);
                    if (key != null) {
                        if (bexp2 == null) {
                            bexp2 = new BeginExp();
                        }
                        bexp2.add(new ApplyExp(setPropMethod, new ReferenceExp(decl), QuoteExp.getInstance(key), arg));
                    } else {
                        Declaration gdecl = arg instanceof LambdaExp ? gproc : decl;
                        ApplyExp addCall = new ApplyExp(addMethod, new ReferenceExp(gdecl), arg);
                        if (arg instanceof LambdaExp) {
                            LambdaExp larg = (LambdaExp)arg;
                            String lname = larg.getName();
                            String dname = decl.getName();
                            if ((lname == null || lname.equals(dname)) && decl.isPublic()) {
                                larg.setFlag(16384);
                            }
                            bexp1.add(addCall);
                        } else {
                            if (bexp2 == null) {
                                bexp2 = new BeginExp();
                            }
                            bexp2.add(addCall);
                        }
                    }
                    Object cdr = p4.getCdr();
                    if (!(cdr instanceof Pair)) {
                        if (cdr == LList.Empty) break;
                        tr.error('e', "not a proper list");
                        break;
                    }
                    p4 = (Pair)cdr;
                } while (true);
                ReferenceExp gref = new ReferenceExp(gproc);
                gref.setFlag(32);
                bexp1.add(gref);
                sexp.setNewValue(tr.letDone(BeginExp.canonicalize(bexp1)));
            } else {
                sexp.setNewValue(tr.rewrite_car(p4, false));
            }
        }
        if (unknownValue) {
            decl.noteValueUnknown();
        } else {
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
}

