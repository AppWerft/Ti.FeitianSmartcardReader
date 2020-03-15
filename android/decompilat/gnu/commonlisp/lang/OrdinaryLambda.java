// 
// Decompiled by Procyon v0.5.36
// 

package gnu.commonlisp.lang;

import gnu.lists.Consumer;
import gnu.expr.LetExp;
import gnu.expr.IfExp;
import gnu.mapping.Procedure;
import gnu.expr.ApplyExp;
import gnu.expr.QuoteExp;
import gnu.expr.ReferenceExp;
import gnu.expr.ScopeExp;
import gnu.bytecode.Type;
import gnu.kawa.lispexpr.LangObjType;
import gnu.expr.Keyword;
import java.util.ArrayList;
import gnu.expr.Expression;
import gnu.expr.LangExp;
import gnu.expr.Special;
import gnu.expr.Symbols;
import gnu.expr.Declaration;
import gnu.lists.LList;
import gnu.mapping.Symbol;
import gnu.lists.Pair;
import kawa.lang.SyntaxForm;
import gnu.lists.PairWithPosition;
import kawa.lang.TemplateScope;
import kawa.lang.Translator;
import gnu.expr.LambdaExp;
import kawa.lang.Lambda;

public class OrdinaryLambda extends Lambda
{
    protected Object allowOtherKeysKeyword;
    protected Object auxKeyword;
    protected Object bodyKeyword;
    Object[] rewriteHelper;
    int rwIdx;
    
    public OrdinaryLambda() {
        this.rewriteHelper = new Object[16];
        this.rwIdx = 0;
    }
    
    public void setKeywords(final Object optional, final Object rest, final Object key, final Object allowOthers, final Object aux, final Object body) {
        this.optionalKeyword = optional;
        this.restKeyword = rest;
        this.keyKeyword = key;
        this.allowOtherKeysKeyword = allowOthers;
        this.auxKeyword = aux;
        this.bodyKeyword = body;
    }
    
    @Override
    public void rewrite(final LambdaExp lexp, final Object formals, final Object body, final Translator tr, final TemplateScope templateScopeRest) {
        this.rewriteFormals(lexp, formals, tr, templateScopeRest);
        if (body instanceof PairWithPosition) {
            lexp.setFile(((PairWithPosition)body).getFileName());
        }
        this.rewriteBody(lexp, body, tr);
    }
    
    @Override
    public void rewriteFormals(final LambdaExp lexp, final Object formals, final Translator tr, TemplateScope templateScopeRest) {
        if (lexp.getSymbol() == null) {
            final String filename = lexp.getFileName();
            final int line = lexp.getLineNumber();
            if (filename != null && line > 0) {
                lexp.setSourceLocation(filename, line);
            }
        }
        Object bindings = formals;
        Object mode = null;
        TemplateScope templateScope = templateScopeRest;
        final int allow_other_keys;
        int aux_args;
        int key_args;
        int opt_args;
        int rest_args = opt_args = (aux_args = (key_args = (aux_args = (allow_other_keys = -1))));
        ArrayList<Keyword> keywords = null;
        while (true) {
            if (bindings instanceof SyntaxForm) {
                final SyntaxForm sf = (SyntaxForm)bindings;
                bindings = sf.getDatum();
                templateScopeRest = sf.getScope();
            }
            if (!(bindings instanceof Pair)) {
                break;
            }
            final Pair pair = (Pair)bindings;
            Object pair_car = pair.getCar();
            if (pair_car instanceof SyntaxForm) {
                final SyntaxForm sf = (SyntaxForm)pair_car;
                pair_car = sf.getDatum();
                templateScope = sf.getScope();
            }
            if (pair_car == this.optionalKeyword) {
                if (opt_args >= 0) {
                    tr.syntaxError("multiple " + this.optionalKeyword + " keywords in parameter list");
                }
                else if (rest_args >= 0 || key_args >= 0 || aux_args >= 0) {
                    tr.syntaxError(this.optionalKeyword + " after " + this.restKeyword + " or " + this.keyKeyword + " or " + this.auxKeyword);
                }
                opt_args = 0;
            }
            else if (pair_car == this.restKeyword || pair_car == this.bodyKeyword) {
                if (rest_args >= 0) {
                    tr.syntaxError("multiple " + pair_car + " keywords in parameter list");
                }
                else if (key_args >= 0 || aux_args >= 0) {
                    tr.syntaxError(pair_car + " after " + this.keyKeyword + " or " + this.auxKeyword);
                }
                rest_args = 0;
            }
            else if (pair_car == this.keyKeyword) {
                if (key_args >= 0) {
                    tr.syntaxError("multiple " + this.keyKeyword + " keywords in parameter list");
                }
                key_args = 0;
            }
            else if (pair_car == this.auxKeyword) {
                if (aux_args >= 0) {
                    tr.syntaxError("multiple " + this.auxKeyword + " keywords in parameter list");
                }
                aux_args = 0;
            }
            else if (key_args >= 0) {
                ++key_args;
            }
            else if (rest_args >= 0) {
                ++rest_args;
            }
            else if (opt_args >= 0) {
                ++opt_args;
            }
            else if (aux_args >= 0) {
                ++aux_args;
            }
            else {
                ++lexp.min_args;
            }
            if (pair_car == this.optionalKeyword || pair_car == this.restKeyword || pair_car == this.bodyKeyword || pair_car == this.keyKeyword || pair_car == this.auxKeyword) {
                mode = pair_car;
            }
            else {
                final Object savePos = tr.pushPositionOf(pair);
                Object name = null;
                Object defaultValue = this.defaultDefault;
                Object suppliedp = null;
                Pair p = null;
                pair_car = tr.namespaceResolve(pair_car);
                if (pair_car instanceof Symbol) {
                    name = pair_car;
                }
                else if (pair_car instanceof Pair) {
                    p = (Pair)pair_car;
                    pair_car = p.getCar();
                    if (pair_car instanceof SyntaxForm) {
                        final SyntaxForm sf2 = (SyntaxForm)pair_car;
                        pair_car = sf2.getDatum();
                        templateScope = sf2.getScope();
                    }
                    pair_car = tr.namespaceResolve(pair_car);
                    if (pair_car instanceof Symbol && p.getCdr() instanceof Pair) {
                        name = pair_car;
                        p = (Pair)p.getCdr();
                        if (p != null && mode != null) {
                            defaultValue = p.getCar();
                            if (p.getCdr() instanceof Pair) {
                                p = (Pair)p.getCdr();
                                suppliedp = p.getCar();
                            }
                            if (p.getCdr() != LList.Empty) {
                                tr.syntaxError("improper list in specifier for parameter '" + name + "')");
                                break;
                            }
                            p = null;
                        }
                        if (p != null && p.getCdr() != LList.Empty) {
                            tr.syntaxError("junk at end of specifier for parameter `" + name + "`" + ": " + p.getCdr());
                            break;
                        }
                    }
                }
                if (name == null && p != null) {
                    tr.syntaxError("general symbols in keyword parameter not implemented");
                }
                final Declaration decl = new Declaration(name);
                decl.setFlag(8796093022208L);
                final Declaration tmpVar = new Declaration(Symbols.gentemp());
                if (suppliedp != null) {
                    if (this.rwIdx >= this.rewriteHelper.length - 4) {
                        final Object[] newHelper = new Object[2 * this.rewriteHelper.length];
                        System.arraycopy(this.rewriteHelper, 0, newHelper, 0, this.rewriteHelper.length);
                        this.rewriteHelper = newHelper;
                    }
                    this.rewriteHelper[this.rwIdx++] = decl;
                    this.rewriteHelper[this.rwIdx++] = defaultValue;
                    this.rewriteHelper[this.rwIdx++] = new Declaration(suppliedp);
                    ((Declaration)(this.rewriteHelper[this.rwIdx++] = tmpVar)).setFlag(8796093022208L);
                }
                if (mode == this.optionalKeyword || mode == this.keyKeyword || mode == this.auxKeyword) {
                    if (suppliedp != null) {
                        tmpVar.setInitValue(new LangExp(Special.undefined));
                    }
                    else {
                        decl.setInitValue(new LangExp(defaultValue));
                    }
                    if (mode == this.keyKeyword) {
                        if (keywords == null) {
                            keywords = new ArrayList<Keyword>();
                        }
                        keywords.add(Keyword.make((name instanceof Symbol) ? ((Symbol)name).getName() : name.toString()));
                    }
                }
                Translator.setLine(decl, bindings);
                if (mode == this.restKeyword || mode == this.bodyKeyword) {
                    decl.setType(LangObjType.listType);
                }
                tmpVar.setFlag(262144L);
                decl.setFlag(262144L);
                this.addParam((suppliedp != null) ? tmpVar : decl, templateScope, lexp, tr);
                tr.popPositionOf(savePos);
            }
            bindings = pair.getCdr();
        }
        if (bindings instanceof SyntaxForm) {
            final SyntaxForm sf = (SyntaxForm)bindings;
            bindings = sf.getDatum();
            templateScopeRest = sf.getScope();
        }
        if (bindings instanceof Symbol) {
            if (opt_args >= 0 || key_args >= 0 || aux_args >= 0) {
                tr.syntaxError("dotted rest-arg after " + this.optionalKeyword + ", " + this.restKeyword + ", or " + this.keyKeyword + ", or " + this.auxKeyword);
            }
            else {
                rest_args = 1;
                final Declaration decl2 = new Declaration(bindings);
                decl2.setType(LangObjType.listType);
                decl2.setFlag(262144L);
                decl2.noteValueUnknown();
                this.addParam(decl2, templateScopeRest, lexp, tr);
            }
        }
        else if (bindings != LList.Empty) {
            tr.syntaxError("misformed formals in lambda");
        }
        if (rest_args > 1) {
            tr.syntaxError("multiple " + this.restKeyword + " parameters");
            rest_args = 1;
        }
        if (opt_args < 0) {
            opt_args = 0;
        }
        if (rest_args < 0) {
            rest_args = 0;
        }
        if (key_args < 0) {
            key_args = 0;
        }
        if (aux_args < 0) {
            aux_args = 0;
        }
        if (rest_args > 0) {
            lexp.max_args = -1;
        }
        else {
            lexp.max_args = lexp.min_args + opt_args + 2 * key_args;
        }
        lexp.opt_args = opt_args;
        if (keywords != null) {
            lexp.keywords = keywords.toArray(new Keyword[keywords.size()]);
        }
    }
    
    @Override
    public Expression auxillaryRewrite(final Object body, final Translator tr) {
        boolean outerLet = false;
        if (this.rwIdx == 0) {
            return super.auxillaryRewrite(body, tr);
        }
        int i = 2;
        if (this.rewriteHelper[i] != null) {
            outerLet = true;
            tr.letStart();
            while (this.rewriteHelper[i] != null) {
                tr.letVariable((Declaration)this.rewriteHelper[i], new IfExp(new ApplyExp(CommonLisp.isEq, new Expression[] { new ReferenceExp((Declaration)this.rewriteHelper[i + 1]), new QuoteExp(Special.undefined) }), new QuoteExp(CommonLisp.FALSE), new QuoteExp(CommonLisp.TRUE)));
                i += 4;
            }
            tr.letEnter();
        }
        i = 0;
        tr.letStart();
        while (this.rewriteHelper[i] != null) {
            if (this.rewriteHelper[i + 2] != null) {
                tr.letVariable((Declaration)this.rewriteHelper[i], new IfExp(new ReferenceExp((Declaration)this.rewriteHelper[i + 2]), new ReferenceExp((Declaration)this.rewriteHelper[i + 3]), tr.rewrite(this.rewriteHelper[i + 1])));
            }
            else {
                tr.letVariable((Declaration)this.rewriteHelper[i], new IfExp(new ApplyExp(CommonLisp.isEq, new Expression[] { new ReferenceExp((Declaration)this.rewriteHelper[i + 3]), new QuoteExp(Special.undefined) }), tr.rewrite(this.rewriteHelper[i + 1]), new ReferenceExp((Declaration)this.rewriteHelper[i + 3])));
            }
            i += 4;
        }
        tr.letEnter();
        LetExp suppLet = tr.letDone(tr.rewrite_body(body));
        if (outerLet) {
            suppLet = tr.letDone(suppLet);
        }
        for (i = 0; i < this.rewriteHelper.length; i += 4) {
            this.rewriteHelper[i] = (this.rewriteHelper[i + 2] = null);
        }
        this.rwIdx = 0;
        return suppLet;
    }
    
    @Override
    public void print(final Consumer out) {
        out.write("#<BUILTIN LAMBDA>");
    }
}
