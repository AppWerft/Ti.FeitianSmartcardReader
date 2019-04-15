/*
 * Decompiled with CFR 0.139.
 */
package kawa.lang;

import gnu.bytecode.Type;
import gnu.expr.BeginExp;
import gnu.expr.Compilation;
import gnu.expr.Declaration;
import gnu.expr.ErrorExp;
import gnu.expr.Expression;
import gnu.expr.Keyword;
import gnu.expr.LambdaExp;
import gnu.expr.LangExp;
import gnu.expr.Language;
import gnu.expr.ModuleExp;
import gnu.expr.NameLookup;
import gnu.expr.QuoteExp;
import gnu.expr.ReferenceExp;
import gnu.expr.ScopeExp;
import gnu.expr.ThisExp;
import gnu.kawa.lispexpr.LangObjType;
import gnu.kawa.lispexpr.LispLanguage;
import gnu.lists.Consumer;
import gnu.lists.EmptyList;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.lists.PairWithPosition;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Symbol;
import gnu.text.SourceMessages;
import java.util.ArrayList;
import kawa.lang.BindDecls;
import kawa.lang.Syntax;
import kawa.lang.SyntaxForm;
import kawa.lang.SyntaxForms;
import kawa.lang.TemplateScope;
import kawa.lang.Translator;
import kawa.standard.object;

public class Lambda
extends Syntax {
    public boolean handlePatterns;
    public Object optionalKeyword;
    public Object restKeyword;
    public Object keyKeyword;
    public static final Keyword nameKeyword = Keyword.make("name");
    public Expression defaultDefault = QuoteExp.falseExp;

    public void setKeywords(Object optional, Object rest, Object key) {
        this.optionalKeyword = optional;
        this.restKeyword = rest;
        this.keyKeyword = key;
    }

    @Override
    public Expression rewriteForm(Pair form, Translator tr) {
        Expression exp = this.rewrite(form.getCdr(), tr);
        Translator.setLine(exp, (Object)form);
        return exp;
    }

    @Override
    public Expression rewrite(Object obj, Translator tr) {
        if (!(obj instanceof Pair)) {
            return tr.syntaxError("missing formals in lambda");
        }
        int old_errors = tr.getMessages().getErrorCount();
        LambdaExp lexp = new LambdaExp();
        Pair pair = (Pair)obj;
        Translator.setLine(lexp, (Object)pair);
        this.rewrite(lexp, pair.getCar(), pair.getCdr(), tr, null);
        if (tr.getMessages().getErrorCount() > old_errors) {
            return new ErrorExp("bad lambda expression");
        }
        return lexp;
    }

    public void rewrite(LambdaExp lexp, Object formals, Object body, Translator tr, TemplateScope templateScopeRest) {
        lexp.setCallConvention(tr);
        this.rewriteFormals(lexp, formals, tr, templateScopeRest);
        if (body instanceof PairWithPosition) {
            lexp.setFile(((PairWithPosition)body).getFileName());
        }
        body = this.rewriteAttrs(lexp, body, tr);
        this.rewriteBody(lexp, body, tr);
    }

    public void rewriteFormals(LambdaExp lexp, Object formals, Translator tr, TemplateScope templateScopeRest) {
        SyntaxForm sf;
        if (this.handlePatterns) {
            tr.pushScope(lexp);
        }
        if (lexp.getSymbol() == null) {
            String filename = lexp.getFileName();
            int line = lexp.getLineNumber();
            if (filename != null && line > 0) {
                lexp.setSourceLocation(filename, line);
            }
        }
        Object bindings = formals;
        int opt_args = -1;
        int rest_args = -1;
        int key_args = -1;
        bindings = formals;
        opt_args = -1;
        key_args = -1;
        Object defaultArgs = null;
        ArrayList<Keyword> keywords2 = null;
        Object mode = null;
        Object next = null;
        do {
            if (bindings instanceof SyntaxForm) {
                sf = (SyntaxForm)bindings;
                bindings = sf.getDatum();
                templateScopeRest = sf.getScope();
            }
            if (!(bindings instanceof Pair)) break;
            TemplateScope templateScope = templateScopeRest;
            Pair pair = (Pair)bindings;
            Object pair_car = pair.getCar();
            next = pair.getCdr();
            if (pair_car instanceof SyntaxForm) {
                SyntaxForm sf2 = (SyntaxForm)pair_car;
                pair_car = sf2.getDatum();
                templateScope = sf2.getScope();
            }
            if (pair_car == this.optionalKeyword) {
                if (opt_args >= 0) {
                    tr.syntaxError("multiple " + this.optionalKeyword + " keywords in parameter list");
                } else if (rest_args >= 0 || key_args >= 0) {
                    tr.syntaxError(this.optionalKeyword.toString() + " after " + this.restKeyword + " or " + this.keyKeyword);
                }
                opt_args = 0;
            } else if (pair_car == this.restKeyword) {
                if (rest_args >= 0) {
                    tr.syntaxError("multiple " + this.restKeyword + " keywords in parameter list");
                } else if (key_args >= 0) {
                    tr.syntaxError(this.restKeyword.toString() + " after " + this.keyKeyword);
                }
                rest_args = 0;
            } else if (pair_car == this.keyKeyword) {
                if (key_args >= 0) {
                    tr.syntaxError("multiple " + this.keyKeyword + " keywords in parameter list");
                }
                key_args = 0;
            } else if (key_args >= 0) {
                ++key_args;
            } else if (rest_args >= 0) {
                ++rest_args;
            } else if (opt_args >= 0) {
                ++opt_args;
            } else {
                ++lexp.min_args;
            }
            if (pair_car == this.optionalKeyword || pair_car == this.restKeyword || pair_car == this.keyKeyword) {
                mode = pair_car;
            } else {
                Pair p;
                Declaration decl;
                Object savePos = tr.pushPositionOf(pair);
                Object name = null;
                Object defaultValue = this.defaultDefault;
                Pair typeSpecPair = null;
                if (tr.matches(pair_car, "::")) {
                    tr.syntaxError("'::' must follow parameter name");
                    break;
                }
                if ((pair_car = tr.namespaceResolve(pair_car)) instanceof Symbol && (!this.handlePatterns || mode != null)) {
                    name = pair_car;
                    if (pair.getCdr() instanceof Pair && tr.matches((p = (Pair)pair.getCdr()).getCar(), "::")) {
                        if (!(p.getCdr() instanceof Pair)) {
                            tr.syntaxError("'::' not followed by a type specifier (for parameter '" + name + "')");
                            bindings = LList.Empty;
                            break;
                        }
                        typeSpecPair = p = (Pair)p.getCdr();
                        pair = p;
                        next = pair.getCdr();
                    }
                } else if (pair_car instanceof Pair && (!this.handlePatterns || mode != null)) {
                    p = (Pair)pair_car;
                    pair_car = p.getCar();
                    if (pair_car instanceof SyntaxForm) {
                        SyntaxForm sf3 = (SyntaxForm)pair_car;
                        pair_car = sf3.getDatum();
                        templateScope = sf3.getScope();
                    }
                    if ((pair_car = tr.namespaceResolve(pair_car)) instanceof Symbol && p.getCdr() instanceof Pair) {
                        name = pair_car;
                        if (tr.matches((p = (Pair)p.getCdr()).getCar(), "::")) {
                            if (!(p.getCdr() instanceof Pair)) {
                                tr.syntaxError("'::' not followed by a type specifier (for parameter '" + name + "')");
                                break;
                            }
                            typeSpecPair = p = (Pair)p.getCdr();
                            if (p.getCdr() instanceof Pair) {
                                p = (Pair)p.getCdr();
                            } else if (p.getCdr() == LList.Empty) {
                                p = null;
                            } else {
                                tr.syntaxError("improper list in specifier for parameter '" + name + "')");
                                break;
                            }
                        }
                        if (p != null && mode != null) {
                            defaultValue = p.getCar();
                            if (p.getCdr() instanceof Pair) {
                                p = (Pair)p.getCdr();
                            } else if (p.getCdr() == LList.Empty) {
                                p = null;
                            } else {
                                tr.syntaxError("improper list in specifier for parameter '" + name + "')");
                                break;
                            }
                        }
                        if (p != null) {
                            if (typeSpecPair != null) {
                                tr.syntaxError("duplicate type specifier for parameter '" + name + '\'');
                                break;
                            }
                            typeSpecPair = p;
                            if (p.getCdr() != LList.Empty) {
                                tr.syntaxError("junk at end of specifier for parameter '" + name + '\'' + " after type " + p.getCar());
                                break;
                            }
                            tr.error('w', "deprecated type specifier syntax - use (VAR :: TYPE) rather than (VAR TYPE)");
                        }
                    }
                }
                if (this.handlePatterns && mode == null) {
                    Object pair_car_cdr;
                    p = pair;
                    pair_car = p.getCar();
                    boolean extraParens = false;
                    if (pair_car instanceof Pair && (pair_car_cdr = ((Pair)pair_car).getCdr()) instanceof Pair && tr.matches(((Pair)pair_car_cdr).getCar(), "::")) {
                        extraParens = true;
                    }
                    Object[] r = BindDecls.instance.parsePatternCar(extraParens ? (Pair)pair_car : p, 0, lexp, tr);
                    if (!extraParens) {
                        next = r[0];
                    } else if (r[0] != LList.Empty) {
                        Object savePos1 = tr.pushPositionOf(r[0]);
                        tr.syntaxError("junk at end of specifier for parameter");
                        tr.popPositionOf(savePos1);
                    }
                    decl = (Declaration)r[1];
                    if (decl == null) {
                        decl = new Declaration("<error>");
                    }
                    name = decl == null ? null : decl.getSymbol();
                } else {
                    if (name == null) {
                        tr.syntaxError("parameter is neither name nor (name :: type) nor (name default): " + pair);
                        break;
                    }
                    decl = new Declaration(name);
                }
                decl.setFlag(0x80000000000L);
                if (mode == this.optionalKeyword || mode == this.keyKeyword) {
                    decl.setInitValue(new LangExp(defaultValue));
                    if (mode == this.keyKeyword) {
                        if (keywords2 == null) {
                            keywords2 = new ArrayList<Keyword>();
                        }
                        keywords2.add(Keyword.make(name instanceof Symbol ? ((Symbol)name).getName() : name.toString()));
                    }
                }
                Translator.setLine(decl, bindings);
                if (typeSpecPair != null) {
                    decl.setType(new LangExp(typeSpecPair), null);
                    decl.setFlag(8192L);
                }
                if (mode == this.restKeyword) {
                    decl.setFlag(0x40000000000L);
                    if (!decl.getFlag(8192L)) {
                        decl.setType(LangObjType.listType);
                    }
                }
                decl.setFlag(262144L);
                if (!this.handlePatterns || mode != null) {
                    this.addParam(decl, templateScope, lexp, tr);
                }
                tr.popPositionOf(savePos);
            }
            bindings = next;
        } while (true);
        if (bindings instanceof SyntaxForm) {
            sf = (SyntaxForm)bindings;
            bindings = sf.getDatum();
            templateScopeRest = sf.getScope();
        }
        if (bindings instanceof Symbol) {
            if (opt_args >= 0 || key_args >= 0 || rest_args >= 0) {
                tr.syntaxError("dotted rest-arg after " + this.optionalKeyword + ", " + this.restKeyword + ", or " + this.keyKeyword);
            } else {
                rest_args = 1;
                Declaration decl = new Declaration(bindings);
                decl.setType(LangObjType.listType);
                decl.setFlag(13194139795456L);
                decl.noteValueUnknown();
                this.addParam(decl, templateScopeRest, lexp, tr);
            }
        } else if (bindings != LList.Empty) {
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
        lexp.max_args = rest_args > 0 ? -1 : lexp.min_args + opt_args + 2 * key_args;
        lexp.opt_args = opt_args;
        if (keywords2 != null) {
            lexp.keywords = keywords2.toArray(new Keyword[keywords2.size()]);
        }
    }

    protected void addParam(Declaration decl, ScopeExp templateScope, LambdaExp lexp, Translator tr) {
        if (templateScope != null) {
            decl = tr.makeRenamedAlias(decl, templateScope);
        }
        lexp.addDeclaration(decl);
        if (templateScope != null) {
            decl.context = templateScope;
        }
        if (this.handlePatterns) {
            tr.push(decl);
        }
    }

    public Object rewriteAttrs(LambdaExp lexp, Object body, Translator tr) {
        String allocationFlagName = null;
        long accessFlag = 0L;
        int allocationFlag = 0;
        SyntaxForm syntax0 = null;
        do {
            Object attrValue;
            Expression attrExpr;
            if (body instanceof SyntaxForm) {
                syntax0 = (SyntaxForm)body;
                body = syntax0.getDatum();
                continue;
            }
            if (!(body instanceof Pair)) break;
            Pair pair1 = (Pair)body;
            Object attrName = Translator.stripSyntax(pair1.getCar());
            if (tr.matches(attrName, "::")) {
                attrName = null;
            } else {
                if (attrName instanceof Pair && Lambda.isAnnotationSymbol(((Pair)attrName).getCar())) {
                    if (lexp.nameDecl == null) {
                        tr.error('e', "annotation for anonymous function");
                    } else {
                        lexp.nameDecl.addAnnotation(new LangExp(pair1));
                    }
                    body = pair1.getCdr();
                    continue;
                }
                if (!(attrName instanceof Keyword)) break;
            }
            SyntaxForm syntax1 = syntax0;
            Object pair1_cdr = pair1.getCdr();
            while (pair1_cdr instanceof SyntaxForm) {
                syntax1 = (SyntaxForm)pair1_cdr;
                pair1_cdr = syntax1.getDatum();
            }
            if (!(pair1_cdr instanceof Pair)) break;
            Pair pair2 = (Pair)pair1_cdr;
            if (attrName == null) {
                if (lexp.isClassMethod() && "*init*".equals(lexp.getName())) {
                    tr.error('e', "explicit return type for '*init*' method");
                } else {
                    lexp.body = new LangExp(new Object[]{pair2, syntax1});
                }
            } else if (attrName == object.accessKeyword) {
                accessFlag = object.addAccessFlags(pair2.getCar(), accessFlag, 223589957632L, "method", tr);
            } else if (attrName == object.allocationKeyword) {
                attrExpr = tr.rewrite_car(pair2, syntax1);
                if (!(attrExpr instanceof QuoteExp) || !((attrValue = ((QuoteExp)attrExpr).getValue()) instanceof SimpleSymbol) && !(attrValue instanceof CharSequence)) {
                    tr.error('e', "allocation: value not a constant symbol or string");
                } else if (lexp.nameDecl == null) {
                    tr.error('e', "allocation: not allowed for anonymous function");
                } else {
                    String value = attrValue.toString();
                    if ("class".equals(value) || "static".equals(value)) {
                        allocationFlag = 2048;
                    } else if ("instance".equals(value)) {
                        allocationFlag = 4096;
                    } else {
                        tr.error('e', "unknown allocation specifier");
                    }
                    if (allocationFlagName != null && value != null) {
                        tr.error('e', "duplicate allocation specifiers - " + allocationFlagName + " and " + value);
                    }
                    allocationFlagName = value;
                }
            } else if (attrName == object.throwsKeyword) {
                attrValue = pair2.getCar();
                int count = Translator.listLength(attrValue);
                if (count < 0) {
                    tr.error('e', "throws: not followed by a list");
                } else {
                    Expression[] exps = new Expression[count];
                    SyntaxForm syntax2 = syntax1;
                    for (int i = 0; i < count; ++i) {
                        while (attrValue instanceof SyntaxForm) {
                            syntax2 = (SyntaxForm)attrValue;
                            attrValue = syntax2.getDatum();
                        }
                        Pair pair3 = (Pair)attrValue;
                        exps[i] = tr.rewrite_car(pair3, syntax2);
                        Translator.setLine(exps[i], (Object)pair3);
                        attrValue = pair3.getCdr();
                    }
                    lexp.setExceptions(exps);
                }
            } else if (attrName == nameKeyword) {
                attrExpr = tr.rewrite_car(pair2, syntax1);
                if (attrExpr instanceof QuoteExp) {
                    lexp.setName(((QuoteExp)attrExpr).getValue().toString());
                }
            } else {
                attrExpr = tr.rewrite_car(pair2, syntax1);
                attrName = ((Keyword)attrName).asSymbol();
                lexp.setProperty(attrName, attrExpr);
            }
            body = pair2.getCdr();
        } while (true);
        if ((accessFlag |= (long)allocationFlag) != 0L) {
            lexp.nameDecl.setFlag(accessFlag);
        }
        if (syntax0 != null) {
            body = SyntaxForms.fromDatumIfNeeded(body, syntax0);
        }
        return body;
    }

    public Object skipAttrs(LambdaExp lexp, Object body, Translator tr) {
        Pair pair;
        while (body instanceof Pair && (pair = (Pair)body).getCdr() instanceof Pair) {
            Object attrName = pair.getCar();
            if (tr.matches(attrName, "::")) {
                attrName = null;
            } else if (!(attrName instanceof Keyword)) break;
            body = ((Pair)pair.getCdr()).getCdr();
        }
        return body;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void rewriteBody(LambdaExp lexp, Object body, Translator tr) {
        int numRenamedAlias = 0;
        if (tr.curMethodLambda == null && lexp.nameDecl != null && tr.getModule().getFlag(262144)) {
            tr.curMethodLambda = lexp;
        }
        ScopeExp curs = tr.currentScope();
        if (!this.handlePatterns) {
            tr.pushScope(lexp);
        }
        if (lexp.nameDecl != null) {
            Lambda.rewriteAnnotations(lexp.nameDecl, tr);
        }
        Declaration prev = null;
        int key_args = lexp.keywords == null ? 0 : lexp.keywords.length;
        int opt_args = lexp.opt_args;
        int arg_i = 0;
        for (Declaration cur = lexp.firstDecl(); cur != null; cur = cur.nextDecl()) {
            Expression texp;
            Pair typeSpecPair;
            Type t;
            if (cur.isAlias()) {
                Declaration param = Translator.getOriginalRef(cur).getBinding();
                lexp.replaceFollowing(prev, param);
                param.context = lexp;
                tr.pushRenamedAlias(cur);
                ++numRenamedAlias;
                cur = param;
            }
            if ((texp = cur.getTypeExpRaw()) instanceof LangExp && (t = tr.exp2Type(typeSpecPair = (Pair)((LangExp)texp).getLangValue(), cur, null)) != null) {
                cur.setType(t);
            }
            prev = cur;
            if (cur.getFlag(0x80000000000L)) {
                if (arg_i >= lexp.min_args && (arg_i < lexp.min_args + opt_args || lexp.max_args >= 0 || arg_i != lexp.min_args + opt_args)) {
                    cur.setInitValue(tr.rewrite(cur.getInitValue()));
                }
                ++arg_i;
            }
            if (this.handlePatterns) continue;
            tr.lexical.push(cur);
        }
        if (lexp.isClassMethod() && !lexp.nameDecl.getFlag(2048L)) {
            lexp.add(null, new Declaration(ThisExp.THIS_NAME));
        }
        LambdaExp saveLambda = tr.curLambda;
        tr.curLambda = lexp;
        Type rtype = lexp.returnType;
        Object[] tform = lexp.body instanceof LangExp ? (Object[])((LangExp)lexp.body).getLangValue() : null;
        lexp.body = this.auxillaryRewrite(body, tr);
        tr.curLambda = saveLambda;
        try {
            Expression[] exps;
            int len;
            Object val;
            if (tform != null) {
                Expression texp = tr.rewrite_car((Pair)tform[0], (SyntaxForm)tform[1]);
                lexp.setCoercedReturnValue(texp, tr.getLanguage());
            } else if (lexp.body instanceof BeginExp && body instanceof Pair && ((Pair)body).getCar() instanceof Symbol && (len = (exps = ((BeginExp)lexp.body).getExpressions()).length) > 1 && (exps[0] instanceof ReferenceExp || (val = exps[0].valueIfConstant()) instanceof Type || val instanceof Class)) {
                tr.error('w', "deprecated return-type specifier - use '::TYPE'");
                Expression rexp = exps[0];
                if (--len == 1) {
                    lexp.body = exps[1];
                } else {
                    Expression[] new_body = new Expression[len];
                    System.arraycopy(exps, 1, new_body, 0, len);
                    lexp.body = BeginExp.canonicalize(new_body);
                }
                lexp.setCoercedReturnValue(rexp, tr.getLanguage());
            } else {
                lexp.setCoercedReturnType(rtype);
            }
        }
        finally {
            tr.pop(lexp);
            lexp.countDecls();
            tr.popRenamedAlias(numRenamedAlias);
            lexp.countDecls();
        }
        if (tr.curMethodLambda == lexp) {
            tr.curMethodLambda = null;
        }
    }

    public Expression auxillaryRewrite(Object body, Translator tr) {
        return tr.rewrite_body(body);
    }

    @Override
    public void print(Consumer out) {
        out.write("#<builtin lambda>");
    }

    public static boolean isAnnotationSymbol(Object key) {
        String name;
        Pair keyp;
        if (key instanceof Pair && (keyp = (Pair)key).getCar() == LispLanguage.splice_sym) {
            return true;
        }
        return key instanceof SimpleSymbol && (name = ((SimpleSymbol)key).getName()).length() > 1 && name.charAt(0) == '@';
    }

    public static void rewriteAnnotations(Declaration decl, Translator tr) {
        int n = decl.numAnnotations();
        for (int i = 0; i < n; ++i) {
            Expression ann = decl.getAnnotation(i);
            if (!(ann instanceof LangExp)) continue;
            ann = tr.rewrite_car((Pair)((LangExp)ann).getLangValue(), false);
            decl.setAnnotation(i, ann);
        }
    }
}

