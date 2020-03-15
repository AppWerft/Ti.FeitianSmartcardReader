// 
// Decompiled by Procyon v0.5.36
// 

package kawa.lang;

import gnu.expr.SetExp;
import gnu.expr.LetExp;
import gnu.bytecode.Method;
import gnu.expr.ApplyExp;
import gnu.expr.QuoteExp;
import gnu.kawa.lispexpr.SeqSizeType;
import gnu.lists.LList;
import gnu.expr.Expression;
import gnu.expr.ReferenceExp;
import gnu.bytecode.ClassType;
import gnu.bytecode.Type;
import gnu.kawa.lispexpr.LispLanguage;
import gnu.expr.ModuleExp;
import gnu.lists.Pair;
import gnu.expr.Declaration;
import gnu.expr.ScopeExp;
import gnu.mapping.Symbol;

public class BindDecls
{
    public static final BindDecls instance;
    public boolean allowShadowing;
    public boolean makeConstant;
    static final Symbol underScoreSymbol;
    
    public BindDecls() {
        this.allowShadowing = false;
        this.makeConstant = true;
    }
    
    public Declaration define(final Symbol name, final SyntaxForm nameSyntax, final ScopeExp scope, final Translator comp) {
        final Declaration oldDecl = comp.lexical.lookup(name, false);
        final Declaration decl = comp.define(name, nameSyntax, scope);
        if (!this.allowShadowing && oldDecl != null && oldDecl.context != scope) {
            comp.error('w', decl, "new declaration '", "' shadows old declaration");
            comp.error('w', oldDecl, "(this is the previous declaration of '", "')");
        }
        return decl;
    }
    
    public Object[] parsePatternCar(final Pair patList, final int scanNesting, final ScopeExp scope, final Translator comp) {
        Object next = patList.getCdr();
        Type type = null;
        if (next instanceof Pair) {
            final Pair nextPair = (Pair)next;
            if (comp.matches(nextPair.getCar(), "::")) {
                final Object nextCdr = nextPair.getCdr();
                if (nextCdr instanceof Pair) {
                    final Pair nextCdrPair = (Pair)nextCdr;
                    type = comp.exp2Type(nextCdrPair);
                    next = nextCdrPair.getCdr();
                }
                else {
                    final Object saveLoc = comp.pushPositionOf(nextPair);
                    comp.error('e', "missing type after '::'");
                    comp.popPositionOf(saveLoc);
                    next = nextCdr;
                }
            }
        }
        final Object pattern = patList.getCar();
        final Object saveLoc2 = comp.pushPositionOf(patList);
        Object patval = pattern;
        SyntaxForm nameSyntax = null;
        if (patval instanceof SyntaxForm) {
            nameSyntax = (SyntaxForm)patval;
            patval = nameSyntax.getDatum();
        }
        patval = comp.namespaceResolve(patval);
        Declaration decl = null;
        if (patval instanceof Symbol) {
            if (patval == BindDecls.underScoreSymbol) {
                decl = scope.addDeclaration((Object)null);
            }
            else {
                decl = this.define((Symbol)patval, nameSyntax, scope, comp);
                Translator.setLine(decl, patList);
            }
            if (scope instanceof ModuleExp && (patval == BindDecls.underScoreSymbol || !scope.getFlag(4194304))) {
                decl.setPrivate(true);
            }
            if (this.makeConstant) {
                decl.setFlag(16384L);
            }
            decl.setFlag(262144L);
        }
        else if (pattern instanceof Pair) {
            final Pair patpair = (Pair)pattern;
            final Object patcar = patpair.getCar();
            if (patcar == LispLanguage.bracket_list_sym) {
                decl = scope.addDeclaration((Object)null);
                if (type != null) {}
                decl.setPrivate(true);
                decl.setFlag(16384L);
                decl.setFlag(262144L);
                this.parseBracketListPattern(patpair, scanNesting, scope, decl, comp);
            }
            else {
                comp.syntaxError("unrecognized pattern operator " + patcar);
            }
        }
        else {
            comp.error('e', "unrecognized pattern " + pattern);
        }
        if (decl != null) {
            decl.setScanNesting(scanNesting);
        }
        if (type != null && decl != null) {
            decl.setType(type);
            decl.setFlag(8192L);
        }
        comp.popPositionOf(saveLoc2);
        return new Object[] { next, decl };
    }
    
    public void parseBracketListPattern(Pair patpair, final int scanNesting, final ScopeExp scope, Declaration decl, final Translator comp) {
        final ClassType listType = ClassType.make("java.util.List");
        decl.setFlag(2199023255552L);
        if (decl.getTypeExpRaw() != null) {
            final Declaration d = scope.addDeclaration((Object)null);
            d.setFlag(3298534883328L);
            d.setScanNesting(scanNesting);
            this.setInitializer(d, new ReferenceExp(decl), scope, comp);
            decl = d;
        }
        int count = 0;
        Object cdr = patpair.getCdr();
        int ellipsisCount = 0;
        while (true) {
            while (cdr != LList.Empty) {
                if (!(cdr instanceof Pair)) {
                    final Type type = new SeqSizeType(count - ellipsisCount, ellipsisCount == 0, "java.util.List");
                    decl.setType(type);
                    return;
                }
                patpair = (Pair)cdr;
                boolean sawEllipsis = false;
                int curScanNesting = scanNesting;
                if (patpair.getCdr() instanceof Pair) {
                    final Object nextCar = ((Pair)patpair.getCdr()).getCar();
                    final Object ellipsis = SyntaxRule.dots3Symbol;
                    if (SyntaxPattern.literalIdentifierEq(nextCar, null, ellipsis, null)) {
                        sawEllipsis = true;
                        ++curScanNesting;
                        if (ellipsisCount > 0) {
                            comp.error('e', "multiple '...' in pattern");
                        }
                        ++ellipsisCount;
                    }
                }
                final Object[] r = this.parsePatternCar(patpair, curScanNesting, scope, comp);
                cdr = (sawEllipsis ? ((Pair)patpair.getCdr()).getCdr() : r[0]);
                final Declaration d2 = (Declaration)r[1];
                d2.setScanNesting(curScanNesting);
                d2.setFlag(3298534883328L);
                Expression init;
                if (sawEllipsis) {
                    final int restCount = Translator.listLength(cdr);
                    final Method dropMethod = ClassType.make("gnu.lists.Sequences").getDeclaredMethod("drop", (restCount == 0) ? 2 : 3);
                    final Expression[] args = new Expression[(restCount == 0) ? 2 : 3];
                    args[0] = new ReferenceExp(decl);
                    args[1] = new QuoteExp(count, Type.intType);
                    if (restCount != 0) {
                        args[2] = new QuoteExp(restCount, Type.intType);
                    }
                    init = new ApplyExp(dropMethod, args);
                }
                else {
                    final Method indexMethod = listType.getMethod("get", new Type[] { Type.intType });
                    init = new ApplyExp(indexMethod, new Expression[] { new ReferenceExp(decl), new QuoteExp(count, Type.intType) });
                }
                this.setInitializer(d2, init, scope, comp);
                ++count;
            }
            continue;
        }
    }
    
    private void setInitializer(final Declaration decl, final Expression init, final ScopeExp scope, final Translator comp) {
        if (scope instanceof ModuleExp || (scope instanceof LetExp && scope.getFlag(2))) {
            final SetExp sexp = new SetExp(decl, init);
            comp.pushForm(sexp);
            decl.noteValueFromSet(sexp);
        }
        else {
            decl.setInitValue(init);
            decl.noteValueFromLet(scope);
        }
    }
    
    static {
        instance = new BindDecls();
        underScoreSymbol = Symbol.valueOf("_");
    }
}
