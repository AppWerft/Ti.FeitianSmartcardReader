// 
// Decompiled by Procyon v0.5.36
// 

package kawa.standard;

import gnu.expr.Special;
import gnu.mapping.Namespace;
import gnu.kawa.functions.CurryExp;
import gnu.kawa.functions.Convert;
import gnu.kawa.functions.Curry1;
import gnu.mapping.Procedure;
import gnu.expr.ApplyExp;
import gnu.expr.QuoteExp;
import gnu.mapping.Symbol;
import gnu.expr.ReferenceExp;
import gnu.expr.LambdaExp;
import gnu.expr.Expression;
import gnu.mapping.Environment;
import gnu.expr.NameLookup;
import gnu.text.SourceMessages;
import gnu.expr.Language;
import kawa.lang.Lambda;
import kawa.repl;
import gnu.expr.Declaration;
import kawa.lang.Translator;

public class SchemeCompilation extends Translator
{
    public static final Declaration applyFieldDecl;
    public static final repl repl;
    public static final Lambda lambda;
    public static final Lambda mlambda;
    
    public SchemeCompilation(final Language language, final SourceMessages messages, final NameLookup lexical, final Environment env) {
        super(language, messages, lexical, env);
    }
    
    public SchemeCompilation(final Language language, final SourceMessages messages, final NameLookup lexical) {
        super(language, messages, lexical);
    }
    
    @Override
    public Expression applyFunction(final Expression func) {
        if (func instanceof LambdaExp) {
            return null;
        }
        return new ReferenceExp(SchemeCompilation.applyFieldDecl);
    }
    
    @Override
    public boolean isApplyFunction(final Expression exp) {
        return this.isSimpleApplyFunction(exp);
    }
    
    @Override
    public boolean isSimpleApplyFunction(final Expression exp) {
        return exp instanceof ReferenceExp && ((ReferenceExp)exp).getBinding() == SchemeCompilation.applyFieldDecl;
    }
    
    @Override
    public boolean appendBodyValues() {
        return ((Scheme)this.getLanguage()).appendBodyValues();
    }
    
    @Override
    public Expression checkDefaultBinding(final Symbol symbol, final Translator tr) {
        final Namespace namespace = symbol.getNamespace();
        final String local = symbol.getLocalPart();
        final String name = symbol.toString();
        final int len = name.length();
        if (len == 0) {
            return null;
        }
        final int llen = local.length();
        if (len > 1 && llen > 1 && name.charAt(len - 1) == '?') {
            final String tlocal = local.substring(0, llen - 1).intern();
            final Symbol tsymbol = namespace.getSymbol(tlocal);
            Expression texp = tr.rewrite(tsymbol, false);
            if (texp instanceof ReferenceExp) {
                final Declaration decl = ((ReferenceExp)texp).getBinding();
                if (decl == null || decl.getFlag(65536L)) {
                    texp = null;
                }
            }
            else if (!(texp instanceof QuoteExp)) {
                texp = null;
            }
            if (texp != null) {
                final LambdaExp lexp = new LambdaExp(1);
                lexp.setSymbol(symbol);
                final Declaration param = lexp.addDeclaration((Object)null);
                param.setFlag(8796093022208L);
                param.noteValueUnknown();
                lexp.body = new ApplyExp(Scheme.instanceOf, new Expression[] { new ReferenceExp(param), texp });
                return lexp;
            }
        }
        if (len > 2 && llen > 2 && name.charAt(0) == '-' && name.charAt(1) == '>') {
            final String tlocal = local.substring(2).intern();
            final Symbol tsymbol = namespace.getSymbol(tlocal);
            Expression texp = tr.rewrite(tsymbol, false);
            if (texp instanceof ReferenceExp) {
                final Declaration decl = ((ReferenceExp)texp).getBinding();
                if (decl == null || decl.getFlag(65536L)) {
                    texp = null;
                }
            }
            else if (!(texp instanceof QuoteExp)) {
                texp = null;
            }
            if (texp != null) {
                return new CurryExp(Curry1.makeConverter, Convert.cast, new Expression[] { texp });
            }
        }
        return super.checkDefaultBinding(symbol, tr);
    }
    
    static {
        applyFieldDecl = Declaration.getDeclarationFromStatic("kawa.standard.Scheme", "applyToArgs");
        lambda = new Lambda();
        mlambda = new Lambda();
        SchemeCompilation.mlambda.handlePatterns = true;
        SchemeCompilation.mlambda.setKeywords(Special.optional, Special.rest, Special.key);
        repl = new repl(Scheme.instance);
        SchemeCompilation.lambda.setKeywords(Special.optional, Special.rest, Special.key);
    }
}
