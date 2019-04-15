/*
 * Decompiled with CFR 0.139.
 */
package kawa.lang;

import gnu.bytecode.ClassType;
import gnu.bytecode.Method;
import gnu.bytecode.PrimType;
import gnu.bytecode.Type;
import gnu.expr.ApplyExp;
import gnu.expr.Declaration;
import gnu.expr.ErrorExp;
import gnu.expr.Expression;
import gnu.expr.LetExp;
import gnu.expr.ModuleExp;
import gnu.expr.NameLookup;
import gnu.expr.QuoteExp;
import gnu.expr.ReferenceExp;
import gnu.expr.ScopeExp;
import gnu.expr.SetExp;
import gnu.kawa.lispexpr.LispLanguage;
import gnu.kawa.lispexpr.SeqSizeType;
import gnu.lists.EmptyList;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Symbol;
import kawa.lang.SyntaxForm;
import kawa.lang.SyntaxPattern;
import kawa.lang.SyntaxRule;
import kawa.lang.Translator;

public class BindDecls {
    public static final BindDecls instance = new BindDecls();
    public boolean allowShadowing = false;
    public boolean makeConstant = true;
    static final Symbol underScoreSymbol = Symbol.valueOf("_");

    public Declaration define(Symbol name, SyntaxForm nameSyntax, ScopeExp scope, Translator comp) {
        Declaration oldDecl = comp.lexical.lookup((Object)name, false);
        Declaration decl = comp.define((Object)name, nameSyntax, scope);
        if (!this.allowShadowing && oldDecl != null && oldDecl.context != scope) {
            comp.error('w', decl, "new declaration '", "' shadows old declaration");
            comp.error('w', oldDecl, "(this is the previous declaration of '", "')");
        }
        return decl;
    }

    public Object[] parsePatternCar(Pair patList, int scanNesting, ScopeExp scope, Translator comp) {
        Pair nextPair;
        Object next = patList.getCdr();
        Type type = null;
        if (next instanceof Pair && comp.matches((nextPair = (Pair)next).getCar(), "::")) {
            Object nextCdr = nextPair.getCdr();
            if (nextCdr instanceof Pair) {
                Pair nextCdrPair = (Pair)nextCdr;
                type = comp.exp2Type(nextCdrPair);
                next = nextCdrPair.getCdr();
            } else {
                Object saveLoc = comp.pushPositionOf(nextPair);
                comp.error('e', "missing type after '::'");
                comp.popPositionOf(saveLoc);
                next = nextCdr;
            }
        }
        Object pattern = patList.getCar();
        Object saveLoc = comp.pushPositionOf(patList);
        Object patval = pattern;
        SyntaxForm nameSyntax = null;
        if (patval instanceof SyntaxForm) {
            nameSyntax = (SyntaxForm)patval;
            patval = nameSyntax.getDatum();
        }
        patval = comp.namespaceResolve(patval);
        Declaration decl = null;
        if (patval instanceof Symbol) {
            if (patval == underScoreSymbol) {
                decl = scope.addDeclaration((Object)null);
            } else {
                decl = this.define((Symbol)patval, nameSyntax, scope, comp);
                Translator.setLine(decl, (Object)patList);
            }
            if (scope instanceof ModuleExp && (patval == underScoreSymbol || !scope.getFlag(4194304))) {
                decl.setPrivate(true);
            }
            if (this.makeConstant) {
                decl.setFlag(16384L);
            }
            decl.setFlag(262144L);
        } else if (pattern instanceof Pair) {
            Pair patpair = (Pair)pattern;
            Object patcar = patpair.getCar();
            if (patcar == LispLanguage.bracket_list_sym) {
                decl = scope.addDeclaration((Object)null);
                if (type != null) {
                    // empty if block
                }
                decl.setPrivate(true);
                decl.setFlag(16384L);
                decl.setFlag(262144L);
                this.parseBracketListPattern(patpair, scanNesting, scope, decl, comp);
            } else {
                comp.syntaxError("unrecognized pattern operator " + patcar);
            }
        } else {
            comp.error('e', "unrecognized pattern " + pattern);
        }
        if (decl != null) {
            decl.setScanNesting(scanNesting);
        }
        if (type != null && decl != null) {
            decl.setType(type);
            decl.setFlag(8192L);
        }
        comp.popPositionOf(saveLoc);
        return new Object[]{next, decl};
    }

    public void parseBracketListPattern(Pair patpair, int scanNesting, ScopeExp scope, Declaration decl, Translator comp) {
        ClassType listType = ClassType.make("java.util.List");
        decl.setFlag(0x20000000000L);
        if (decl.getTypeExpRaw() != null) {
            Declaration d = scope.addDeclaration((Object)null);
            d.setFlag(0x30000000000L);
            d.setScanNesting(scanNesting);
            this.setInitializer(d, new ReferenceExp(decl), scope, comp);
            decl = d;
        }
        int count = 0;
        Object cdr = patpair.getCdr();
        int ellipsisCount = 0;
        while (cdr != LList.Empty && cdr instanceof Pair) {
            ApplyExp init;
            Object nextCar;
            SimpleSymbol ellipsis;
            patpair = (Pair)cdr;
            boolean sawEllipsis = false;
            int curScanNesting = scanNesting;
            if (patpair.getCdr() instanceof Pair && SyntaxPattern.literalIdentifierEq(nextCar = ((Pair)patpair.getCdr()).getCar(), null, ellipsis = SyntaxRule.dots3Symbol, null)) {
                sawEllipsis = true;
                ++curScanNesting;
                if (ellipsisCount > 0) {
                    comp.error('e', "multiple '...' in pattern");
                }
                ++ellipsisCount;
            }
            Object[] r = this.parsePatternCar(patpair, curScanNesting, scope, comp);
            cdr = sawEllipsis ? ((Pair)patpair.getCdr()).getCdr() : r[0];
            Declaration d = (Declaration)r[1];
            d.setScanNesting(curScanNesting);
            d.setFlag(0x30000000000L);
            if (sawEllipsis) {
                int restCount;
                Method dropMethod = ClassType.make("gnu.lists.Sequences").getDeclaredMethod("drop", (restCount = Translator.listLength(cdr)) == 0 ? 2 : 3);
                Expression[] args = new Expression[restCount == 0 ? 2 : 3];
                args[0] = new ReferenceExp(decl);
                args[1] = new QuoteExp(count, Type.intType);
                if (restCount != 0) {
                    args[2] = new QuoteExp(restCount, Type.intType);
                }
                init = new ApplyExp(dropMethod, args);
            } else {
                Method indexMethod = listType.getMethod("get", new Type[]{Type.intType});
                init = new ApplyExp(indexMethod, new ReferenceExp(decl), new QuoteExp(count, Type.intType));
            }
            this.setInitializer(d, init, scope, comp);
            ++count;
        }
        SeqSizeType type = new SeqSizeType(count - ellipsisCount, ellipsisCount == 0, "java.util.List");
        decl.setType(type);
    }

    private void setInitializer(Declaration decl, Expression init, ScopeExp scope, Translator comp) {
        if (scope instanceof ModuleExp || scope instanceof LetExp && scope.getFlag(2)) {
            SetExp sexp = new SetExp(decl, init);
            comp.pushForm(sexp);
            decl.noteValueFromSet(sexp);
        } else {
            decl.setInitValue(init);
            decl.noteValueFromLet(scope);
        }
    }
}

