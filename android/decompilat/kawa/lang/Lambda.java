// 
// Decompiled by Procyon v0.5.36
// 

package kawa.lang;

import gnu.kawa.lispexpr.LispLanguage;
import gnu.lists.Consumer;
import gnu.expr.ReferenceExp;
import gnu.expr.BeginExp;
import gnu.expr.ThisExp;
import gnu.mapping.SimpleSymbol;
import kawa.standard.object;
import gnu.kawa.lispexpr.LangObjType;
import gnu.bytecode.Type;
import java.util.ArrayList;
import gnu.expr.LangExp;
import gnu.expr.Declaration;
import gnu.lists.LList;
import gnu.mapping.Symbol;
import gnu.expr.ScopeExp;
import gnu.lists.PairWithPosition;
import gnu.expr.Compilation;
import gnu.expr.ErrorExp;
import gnu.expr.LambdaExp;
import gnu.lists.Pair;
import gnu.expr.QuoteExp;
import gnu.expr.Expression;
import gnu.expr.Keyword;

public class Lambda extends Syntax
{
    public boolean handlePatterns;
    public Object optionalKeyword;
    public Object restKeyword;
    public Object keyKeyword;
    public static final Keyword nameKeyword;
    public Expression defaultDefault;
    
    public Lambda() {
        this.defaultDefault = QuoteExp.falseExp;
    }
    
    public void setKeywords(final Object optional, final Object rest, final Object key) {
        this.optionalKeyword = optional;
        this.restKeyword = rest;
        this.keyKeyword = key;
    }
    
    @Override
    public Expression rewriteForm(final Pair form, final Translator tr) {
        final Expression exp = this.rewrite(form.getCdr(), tr);
        Translator.setLine(exp, form);
        return exp;
    }
    
    @Override
    public Expression rewrite(final Object obj, final Translator tr) {
        if (!(obj instanceof Pair)) {
            return tr.syntaxError("missing formals in lambda");
        }
        final int old_errors = tr.getMessages().getErrorCount();
        final LambdaExp lexp = new LambdaExp();
        final Pair pair = (Pair)obj;
        Translator.setLine(lexp, pair);
        this.rewrite(lexp, pair.getCar(), pair.getCdr(), tr, null);
        if (tr.getMessages().getErrorCount() > old_errors) {
            return new ErrorExp("bad lambda expression");
        }
        return lexp;
    }
    
    public void rewrite(final LambdaExp lexp, final Object formals, Object body, final Translator tr, final TemplateScope templateScopeRest) {
        lexp.setCallConvention(tr);
        this.rewriteFormals(lexp, formals, tr, templateScopeRest);
        if (body instanceof PairWithPosition) {
            lexp.setFile(((PairWithPosition)body).getFileName());
        }
        body = this.rewriteAttrs(lexp, body, tr);
        this.rewriteBody(lexp, body, tr);
    }
    
    public void rewriteFormals(final LambdaExp lexp, final Object formals, final Translator tr, TemplateScope templateScopeRest) {
        if (this.handlePatterns) {
            tr.pushScope(lexp);
        }
        if (lexp.getSymbol() == null) {
            final String filename = lexp.getFileName();
            final int line = lexp.getLineNumber();
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
        final ArrayList<Expression> defaultArgs = null;
        ArrayList<Keyword> keywords = null;
        Object mode = null;
        Object next = null;
        while (true) {
            if (bindings instanceof SyntaxForm) {
                final SyntaxForm sf = (SyntaxForm)bindings;
                bindings = sf.getDatum();
                templateScopeRest = sf.getScope();
            }
            if (!(bindings instanceof Pair)) {
                break;
            }
            TemplateScope templateScope = templateScopeRest;
            Pair pair = (Pair)bindings;
            Object pair_car = pair.getCar();
            next = pair.getCdr();
            if (pair_car instanceof SyntaxForm) {
                final SyntaxForm sf2 = (SyntaxForm)pair_car;
                pair_car = sf2.getDatum();
                templateScope = sf2.getScope();
            }
            if (pair_car == this.optionalKeyword) {
                if (opt_args >= 0) {
                    tr.syntaxError("multiple " + this.optionalKeyword + " keywords in parameter list");
                }
                else if (rest_args >= 0 || key_args >= 0) {
                    tr.syntaxError(this.optionalKeyword.toString() + " after " + this.restKeyword + " or " + this.keyKeyword);
                }
                opt_args = 0;
            }
            else if (pair_car == this.restKeyword) {
                if (rest_args >= 0) {
                    tr.syntaxError("multiple " + this.restKeyword + " keywords in parameter list");
                }
                else if (key_args >= 0) {
                    tr.syntaxError(this.restKeyword.toString() + " after " + this.keyKeyword);
                }
                rest_args = 0;
            }
            else if (pair_car == this.keyKeyword) {
                if (key_args >= 0) {
                    tr.syntaxError("multiple " + this.keyKeyword + " keywords in parameter list");
                }
                key_args = 0;
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
            else {
                ++lexp.min_args;
            }
            if (pair_car == this.optionalKeyword || pair_car == this.restKeyword || pair_car == this.keyKeyword) {
                mode = pair_car;
            }
            else {
                final Object savePos = tr.pushPositionOf(pair);
                Object name = null;
                Object defaultValue = this.defaultDefault;
                Pair typeSpecPair = null;
                if (tr.matches(pair_car, "::")) {
                    tr.syntaxError("'::' must follow parameter name");
                    break;
                }
                pair_car = tr.namespaceResolve(pair_car);
                if (pair_car instanceof Symbol && (!this.handlePatterns || mode != null)) {
                    name = pair_car;
                    final Pair p;
                    if (pair.getCdr() instanceof Pair && tr.matches((p = (Pair)pair.getCdr()).getCar(), "::")) {
                        if (!(p.getCdr() instanceof Pair)) {
                            tr.syntaxError("'::' not followed by a type specifier (for parameter '" + name + "')");
                            bindings = LList.Empty;
                            break;
                        }
                        typeSpecPair = (pair = (Pair)p.getCdr());
                        next = pair.getCdr();
                    }
                }
                else if (pair_car instanceof Pair && (!this.handlePatterns || mode != null)) {
                    Pair p = (Pair)pair_car;
                    pair_car = p.getCar();
                    if (pair_car instanceof SyntaxForm) {
                        final SyntaxForm sf3 = (SyntaxForm)pair_car;
                        pair_car = sf3.getDatum();
                        templateScope = sf3.getScope();
                    }
                    pair_car = tr.namespaceResolve(pair_car);
                    if (pair_car instanceof Symbol && p.getCdr() instanceof Pair) {
                        name = pair_car;
                        p = (Pair)p.getCdr();
                        if (tr.matches(p.getCar(), "::")) {
                            if (!(p.getCdr() instanceof Pair)) {
                                tr.syntaxError("'::' not followed by a type specifier (for parameter '" + name + "')");
                                break;
                            }
                            p = (typeSpecPair = (Pair)p.getCdr());
                            if (p.getCdr() instanceof Pair) {
                                p = (Pair)p.getCdr();
                            }
                            else {
                                if (p.getCdr() != LList.Empty) {
                                    tr.syntaxError("improper list in specifier for parameter '" + name + "')");
                                    break;
                                }
                                p = null;
                            }
                        }
                        if (p != null && mode != null) {
                            defaultValue = p.getCar();
                            if (p.getCdr() instanceof Pair) {
                                p = (Pair)p.getCdr();
                            }
                            else {
                                if (p.getCdr() != LList.Empty) {
                                    tr.syntaxError("improper list in specifier for parameter '" + name + "')");
                                    break;
                                }
                                p = null;
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
                Declaration decl;
                if (this.handlePatterns && mode == null) {
                    final Pair p = pair;
                    pair_car = p.getCar();
                    boolean extraParens = false;
                    if (pair_car instanceof Pair) {
                        final Object pair_car_cdr = ((Pair)pair_car).getCdr();
                        if (pair_car_cdr instanceof Pair && tr.matches(((Pair)pair_car_cdr).getCar(), "::")) {
                            extraParens = true;
                        }
                    }
                    final Object[] r = BindDecls.instance.parsePatternCar(extraParens ? ((Pair)pair_car) : p, 0, lexp, tr);
                    if (!extraParens) {
                        next = r[0];
                    }
                    else if (r[0] != LList.Empty) {
                        final Object savePos2 = tr.pushPositionOf(r[0]);
                        tr.syntaxError("junk at end of specifier for parameter");
                        tr.popPositionOf(savePos2);
                    }
                    decl = (Declaration)r[1];
                    if (decl == null) {
                        decl = new Declaration("<error>");
                    }
                    name = ((decl == null) ? null : decl.getSymbol());
                }
                else {
                    if (name == null) {
                        tr.syntaxError("parameter is neither name nor (name :: type) nor (name default): " + pair);
                        break;
                    }
                    decl = new Declaration(name);
                }
                decl.setFlag(8796093022208L);
                if (mode == this.optionalKeyword || mode == this.keyKeyword) {
                    decl.setInitValue(new LangExp(defaultValue));
                    if (mode == this.keyKeyword) {
                        if (keywords == null) {
                            keywords = new ArrayList<Keyword>();
                        }
                        keywords.add(Keyword.make((name instanceof Symbol) ? ((Symbol)name).getName() : name.toString()));
                    }
                }
                Translator.setLine(decl, bindings);
                if (typeSpecPair != null) {
                    decl.setType(new LangExp(typeSpecPair), null);
                    decl.setFlag(8192L);
                }
                if (mode == this.restKeyword) {
                    decl.setFlag(4398046511104L);
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
        }
        if (bindings instanceof SyntaxForm) {
            final SyntaxForm sf = (SyntaxForm)bindings;
            bindings = sf.getDatum();
            templateScopeRest = sf.getScope();
        }
        if (bindings instanceof Symbol) {
            if (opt_args >= 0 || key_args >= 0 || rest_args >= 0) {
                tr.syntaxError("dotted rest-arg after " + this.optionalKeyword + ", " + this.restKeyword + ", or " + this.keyKeyword);
            }
            else {
                rest_args = 1;
                final Declaration decl2 = new Declaration(bindings);
                decl2.setType(LangObjType.listType);
                decl2.setFlag(13194139795456L);
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
    
    protected void addParam(Declaration decl, final ScopeExp templateScope, final LambdaExp lexp, final Translator tr) {
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
    
    public Object rewriteAttrs(final LambdaExp lexp, Object body, final Translator tr) {
        String allocationFlagName = null;
        long accessFlag = 0L;
        int allocationFlag = 0;
        SyntaxForm syntax0 = null;
        while (true) {
            if (body instanceof SyntaxForm) {
                syntax0 = (SyntaxForm)body;
                body = syntax0.getDatum();
            }
            else {
                if (!(body instanceof Pair)) {
                    break;
                }
                final Pair pair1 = (Pair)body;
                Object attrName = Translator.stripSyntax(pair1.getCar());
                if (tr.matches(attrName, "::")) {
                    attrName = null;
                }
                else {
                    if (attrName instanceof Pair && isAnnotationSymbol(((Pair)attrName).getCar())) {
                        if (lexp.nameDecl == null) {
                            tr.error('e', "annotation for anonymous function");
                        }
                        else {
                            lexp.nameDecl.addAnnotation(new LangExp(pair1));
                        }
                        body = pair1.getCdr();
                        continue;
                    }
                    if (!(attrName instanceof Keyword)) {
                        break;
                    }
                }
                SyntaxForm syntax2;
                Object pair1_cdr;
                for (syntax2 = syntax0, pair1_cdr = pair1.getCdr(); pair1_cdr instanceof SyntaxForm; pair1_cdr = syntax2.getDatum()) {
                    syntax2 = (SyntaxForm)pair1_cdr;
                }
                if (!(pair1_cdr instanceof Pair)) {
                    break;
                }
                final Pair pair2 = (Pair)pair1_cdr;
                if (attrName == null) {
                    if (lexp.isClassMethod() && "*init*".equals(lexp.getName())) {
                        tr.error('e', "explicit return type for '*init*' method");
                    }
                    else {
                        lexp.body = new LangExp(new Object[] { pair2, syntax2 });
                    }
                }
                else if (attrName == object.accessKeyword) {
                    accessFlag = object.addAccessFlags(pair2.getCar(), accessFlag, 223589957632L, "method", tr);
                }
                else if (attrName == object.allocationKeyword) {
                    final Expression attrExpr = tr.rewrite_car(pair2, syntax2);
                    final Object attrValue;
                    if (!(attrExpr instanceof QuoteExp) || (!((attrValue = ((QuoteExp)attrExpr).getValue()) instanceof SimpleSymbol) && !(attrValue instanceof CharSequence))) {
                        tr.error('e', "allocation: value not a constant symbol or string");
                    }
                    else if (lexp.nameDecl == null) {
                        tr.error('e', "allocation: not allowed for anonymous function");
                    }
                    else {
                        final String value = attrValue.toString();
                        if ("class".equals(value) || "static".equals(value)) {
                            allocationFlag = 2048;
                        }
                        else if ("instance".equals(value)) {
                            allocationFlag = 4096;
                        }
                        else {
                            tr.error('e', "unknown allocation specifier");
                        }
                        if (allocationFlagName != null && value != null) {
                            tr.error('e', "duplicate allocation specifiers - " + allocationFlagName + " and " + value);
                        }
                        allocationFlagName = value;
                    }
                }
                else if (attrName == object.throwsKeyword) {
                    Object attrValue = pair2.getCar();
                    final int count = Translator.listLength(attrValue);
                    if (count < 0) {
                        tr.error('e', "throws: not followed by a list");
                    }
                    else {
                        final Expression[] exps = new Expression[count];
                        SyntaxForm syntax3 = syntax2;
                        for (int i = 0; i < count; ++i) {
                            while (attrValue instanceof SyntaxForm) {
                                syntax3 = (SyntaxForm)attrValue;
                                attrValue = syntax3.getDatum();
                            }
                            final Pair pair3 = (Pair)attrValue;
                            Translator.setLine(exps[i] = tr.rewrite_car(pair3, syntax3), pair3);
                            attrValue = pair3.getCdr();
                        }
                        lexp.setExceptions(exps);
                    }
                }
                else if (attrName == Lambda.nameKeyword) {
                    final Expression attrExpr = tr.rewrite_car(pair2, syntax2);
                    if (attrExpr instanceof QuoteExp) {
                        lexp.setName(((QuoteExp)attrExpr).getValue().toString());
                    }
                }
                else {
                    final Expression attrExpr = tr.rewrite_car(pair2, syntax2);
                    attrName = ((Keyword)attrName).asSymbol();
                    lexp.setProperty(attrName, attrExpr);
                }
                body = pair2.getCdr();
            }
        }
        accessFlag |= allocationFlag;
        if (accessFlag != 0L) {
            lexp.nameDecl.setFlag(accessFlag);
        }
        if (syntax0 != null) {
            body = SyntaxForms.fromDatumIfNeeded(body, syntax0);
        }
        return body;
    }
    
    public Object skipAttrs(final LambdaExp lexp, Object body, final Translator tr) {
        while (body instanceof Pair) {
            final Pair pair = (Pair)body;
            if (!(pair.getCdr() instanceof Pair)) {
                break;
            }
            Object attrName = pair.getCar();
            if (tr.matches(attrName, "::")) {
                attrName = null;
            }
            else if (!(attrName instanceof Keyword)) {
                break;
            }
            body = ((Pair)pair.getCdr()).getCdr();
        }
        return body;
    }
    
    public void rewriteBody(final LambdaExp lexp, final Object body, final Translator tr) {
        int numRenamedAlias = 0;
        if (tr.curMethodLambda == null && lexp.nameDecl != null && tr.getModule().getFlag(262144)) {
            tr.curMethodLambda = lexp;
        }
        final ScopeExp curs = tr.currentScope();
        if (!this.handlePatterns) {
            tr.pushScope(lexp);
        }
        if (lexp.nameDecl != null) {
            rewriteAnnotations(lexp.nameDecl, tr);
        }
        Declaration prev = null;
        final int key_args = (lexp.keywords == null) ? 0 : lexp.keywords.length;
        final int opt_args = lexp.opt_args;
        int arg_i = 0;
        for (Declaration cur = lexp.firstDecl(); cur != null; cur = cur.nextDecl()) {
            if (cur.isAlias()) {
                final Declaration param = Translator.getOriginalRef(cur).getBinding();
                lexp.replaceFollowing(prev, param);
                param.context = lexp;
                tr.pushRenamedAlias(cur);
                ++numRenamedAlias;
                cur = param;
            }
            final Expression texp = cur.getTypeExpRaw();
            if (texp instanceof LangExp) {
                final Pair typeSpecPair = (Pair)((LangExp)texp).getLangValue();
                final Type t = tr.exp2Type(typeSpecPair, cur, null);
                if (t != null) {
                    cur.setType(t);
                }
            }
            prev = cur;
            if (cur.getFlag(8796093022208L)) {
                if (arg_i >= lexp.min_args && (arg_i < lexp.min_args + opt_args || lexp.max_args >= 0 || arg_i != lexp.min_args + opt_args)) {
                    cur.setInitValue(tr.rewrite(cur.getInitValue()));
                }
                ++arg_i;
            }
            if (!this.handlePatterns) {
                tr.lexical.push(cur);
            }
        }
        if (lexp.isClassMethod() && !lexp.nameDecl.getFlag(2048L)) {
            lexp.add(null, new Declaration(ThisExp.THIS_NAME));
        }
        final LambdaExp saveLambda = tr.curLambda;
        tr.curLambda = lexp;
        final Type rtype = lexp.returnType;
        final Object[] tform = (lexp.body instanceof LangExp) ? ((Object[])((LangExp)lexp.body).getLangValue()) : null;
        lexp.body = this.auxillaryRewrite(body, tr);
        tr.curLambda = saveLambda;
        try {
            if (tform != null) {
                final Expression texp2 = tr.rewrite_car((Pair)tform[0], (SyntaxForm)tform[1]);
                lexp.setCoercedReturnValue(texp2, tr.getLanguage());
            }
            else {
                final Expression[] exps;
                int len;
                final Object val;
                if (lexp.body instanceof BeginExp && body instanceof Pair && ((Pair)body).getCar() instanceof Symbol && (len = (exps = ((BeginExp)lexp.body).getExpressions()).length) > 1 && (exps[0] instanceof ReferenceExp || (val = exps[0].valueIfConstant()) instanceof Type || val instanceof Class)) {
                    tr.error('w', "deprecated return-type specifier - use '::TYPE'");
                    final Expression rexp = exps[0];
                    if (--len == 1) {
                        lexp.body = exps[1];
                    }
                    else {
                        final Expression[] new_body = new Expression[len];
                        System.arraycopy(exps, 1, new_body, 0, len);
                        lexp.body = BeginExp.canonicalize(new_body);
                    }
                    lexp.setCoercedReturnValue(rexp, tr.getLanguage());
                }
                else {
                    lexp.setCoercedReturnType(rtype);
                }
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
    
    public Expression auxillaryRewrite(final Object body, final Translator tr) {
        return tr.rewrite_body(body);
    }
    
    @Override
    public void print(final Consumer out) {
        out.write("#<builtin lambda>");
    }
    
    public static boolean isAnnotationSymbol(final Object key) {
        if (key instanceof Pair) {
            final Pair keyp = (Pair)key;
            if (keyp.getCar() == LispLanguage.splice_sym) {
                return true;
            }
        }
        if (key instanceof SimpleSymbol) {
            final String name = ((SimpleSymbol)key).getName();
            if (name.length() > 1 && name.charAt(0) == '@') {
                return true;
            }
        }
        return false;
    }
    
    public static void rewriteAnnotations(final Declaration decl, final Translator tr) {
        for (int n = decl.numAnnotations(), i = 0; i < n; ++i) {
            Expression ann = decl.getAnnotation(i);
            if (ann instanceof LangExp) {
                ann = tr.rewrite_car((Pair)((LangExp)ann).getLangValue(), false);
                decl.setAnnotation(i, ann);
            }
        }
    }
    
    static {
        nameKeyword = Keyword.make("name");
    }
}
