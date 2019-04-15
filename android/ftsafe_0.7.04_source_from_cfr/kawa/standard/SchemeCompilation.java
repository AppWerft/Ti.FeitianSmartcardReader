/*
 * Decompiled with CFR 0.139.
 */
package kawa.standard;

import gnu.expr.ApplyExp;
import gnu.expr.Declaration;
import gnu.expr.Expression;
import gnu.expr.LambdaExp;
import gnu.expr.Language;
import gnu.expr.NameLookup;
import gnu.expr.QuoteExp;
import gnu.expr.ReferenceExp;
import gnu.expr.Special;
import gnu.kawa.functions.Convert;
import gnu.kawa.functions.Curry1;
import gnu.kawa.functions.CurryExp;
import gnu.kawa.reflect.InstanceOf;
import gnu.mapping.Environment;
import gnu.mapping.Namespace;
import gnu.mapping.Procedure;
import gnu.mapping.Symbol;
import gnu.text.SourceMessages;
import kawa.lang.Lambda;
import kawa.lang.Translator;
import kawa.repl;
import kawa.standard.Scheme;

public class SchemeCompilation
extends Translator {
    public static final Declaration applyFieldDecl = Declaration.getDeclarationFromStatic("kawa.standard.Scheme", "applyToArgs");
    public static final repl repl;
    public static final Lambda lambda;
    public static final Lambda mlambda;

    public SchemeCompilation(Language language, SourceMessages messages, NameLookup lexical, Environment env) {
        super(language, messages, lexical, env);
    }

    public SchemeCompilation(Language language, SourceMessages messages, NameLookup lexical) {
        super(language, messages, lexical);
    }

    @Override
    public Expression applyFunction(Expression func) {
        if (func instanceof LambdaExp) {
            return null;
        }
        return new ReferenceExp(applyFieldDecl);
    }

    @Override
    public boolean isApplyFunction(Expression exp) {
        return this.isSimpleApplyFunction(exp);
    }

    @Override
    public boolean isSimpleApplyFunction(Expression exp) {
        return exp instanceof ReferenceExp && ((ReferenceExp)exp).getBinding() == applyFieldDecl;
    }

    @Override
    public boolean appendBodyValues() {
        return ((Scheme)this.getLanguage()).appendBodyValues();
    }

    @Override
    public Expression checkDefaultBinding(Symbol symbol, Translator tr) {
        Expression texp;
        String tlocal;
        Symbol tsymbol;
        Declaration decl;
        Namespace namespace = symbol.getNamespace();
        String local = symbol.getLocalPart();
        String name = symbol.toString();
        int len = name.length();
        if (len == 0) {
            return null;
        }
        int llen = local.length();
        if (len > 1 && llen > 1 && name.charAt(len - 1) == '?') {
            tlocal = local.substring(0, llen - 1).intern();
            tsymbol = namespace.getSymbol(tlocal);
            texp = tr.rewrite((Object)tsymbol, false);
            if (texp instanceof ReferenceExp) {
                decl = ((ReferenceExp)texp).getBinding();
                if (decl == null || decl.getFlag(65536L)) {
                    texp = null;
                }
            } else if (!(texp instanceof QuoteExp)) {
                texp = null;
            }
            if (texp != null) {
                LambdaExp lexp = new LambdaExp(1);
                lexp.setSymbol(symbol);
                Declaration param = lexp.addDeclaration((Object)null);
                param.setFlag(0x80000000000L);
                param.noteValueUnknown();
                lexp.body = new ApplyExp(Scheme.instanceOf, new ReferenceExp(param), texp);
                return lexp;
            }
        }
        if (len > 2 && llen > 2 && name.charAt(0) == '-' && name.charAt(1) == '>') {
            tlocal = local.substring(2).intern();
            tsymbol = namespace.getSymbol(tlocal);
            texp = tr.rewrite((Object)tsymbol, false);
            if (texp instanceof ReferenceExp) {
                decl = ((ReferenceExp)texp).getBinding();
                if (decl == null || decl.getFlag(65536L)) {
                    texp = null;
                }
            } else if (!(texp instanceof QuoteExp)) {
                texp = null;
            }
            if (texp != null) {
                return new CurryExp(Curry1.makeConverter, Convert.cast, texp);
            }
        }
        return super.checkDefaultBinding(symbol, tr);
    }

    static {
        lambda = new Lambda();
        mlambda = new Lambda();
        SchemeCompilation.mlambda.handlePatterns = true;
        mlambda.setKeywords(Special.optional, Special.rest, Special.key);
        repl = new repl(Scheme.instance);
        lambda.setKeywords(Special.optional, Special.rest, Special.key);
    }
}

