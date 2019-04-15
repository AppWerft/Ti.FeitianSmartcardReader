/*
 * Decompiled with CFR 0.139.
 */
package kawa.standard;

import gnu.expr.Declaration;
import gnu.expr.ErrorExp;
import gnu.expr.Expression;
import gnu.expr.ModuleExp;
import gnu.expr.ReferenceExp;
import gnu.expr.ScopeExp;
import gnu.expr.SetExp;
import gnu.lists.EmptyList;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.mapping.Symbol;
import kawa.lang.Syntax;
import kawa.lang.SyntaxForm;
import kawa.lang.Translator;

public class export
extends Syntax {
    public static final export module_export = new export();
    public static final export export;

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean scanForDefinitions(Pair st, ScopeExp defs2, Translator tr) {
        Object list = st.getCdr();
        Object savePos = tr.pushPositionOf(st);
        try {
            if (!(defs2 instanceof ModuleExp)) {
                tr.error('e', "'" + this.getName() + "' not at module level");
                boolean bl = false;
                return bl;
            }
            ModuleExp mexp = (ModuleExp)defs2;
            if (mexp.getFlag(16777216)) {
                tr.error('e', "'export' used follow explicit modules");
                boolean bl = false;
                return bl;
            }
            mexp.setFlag(32768);
            SyntaxForm restSyntax = null;
            while (list != LList.Empty) {
                tr.pushPositionOf(list);
                while (list instanceof SyntaxForm) {
                    restSyntax = (SyntaxForm)list;
                    list = restSyntax.getDatum();
                }
                SyntaxForm nameSyntax = restSyntax;
                if (list instanceof Pair) {
                    Object symcdr;
                    Pair psymcdr;
                    Object symcddr;
                    Pair psym;
                    String str;
                    st = (Pair)list;
                    Object symbol = st.getCar();
                    while (symbol instanceof SyntaxForm) {
                        nameSyntax = (SyntaxForm)symbol;
                        symbol = nameSyntax.getDatum();
                    }
                    if (symbol instanceof String && (str = (String)symbol).startsWith("namespace:")) {
                        tr.error('w', "'namespace:' prefix ignored");
                        symbol = str.substring(10).intern();
                    }
                    if ((symbol = tr.namespaceResolve(symbol)) instanceof Pair && tr.matches((psym = (Pair)symbol).getCar(), "rename") && (symcdr = psym.getCdr()) instanceof Pair && (symcddr = (psymcdr = (Pair)symcdr).getCdr()) instanceof Pair) {
                        Pair psymcddr = (Pair)symcddr;
                        Object symcdddr = psymcddr.getCdr();
                        Object name1 = tr.namespaceResolve(psymcdr.getCar());
                        Object name2 = tr.namespaceResolve(psymcddr.getCar());
                        if (symcdddr == LList.Empty && name1 instanceof Symbol && name2 instanceof Symbol) {
                            Declaration decl1 = defs2.getNoDefine(name1);
                            if (decl1.getFlag(512L)) {
                                Translator.setLine(decl1, (Object)st);
                            }
                            decl1.setFlag(524288L);
                            Declaration decl2 = tr.define(null, nameSyntax, defs2);
                            decl2.setIndirectBinding(true);
                            decl2.setAlias(true);
                            decl2.setFlag(536871936L);
                            ReferenceExp ref1 = new ReferenceExp(decl1);
                            ref1.setDontDereference(true);
                            SetExp sexp = new SetExp(name2, (Expression)ref1);
                            sexp.setBinding(decl2);
                            tr.setLineOf(sexp);
                            decl2.noteValueFromSet(sexp);
                            sexp.setDefining(true);
                            list = st.getCdr();
                            tr.pushForm(sexp);
                            continue;
                        }
                    }
                    if (symbol instanceof String || symbol instanceof Symbol) {
                        Declaration decl;
                        if (nameSyntax != null) {
                            // empty if block
                        }
                        if ((decl = defs2.getNoDefine(symbol)).getFlag(512L)) {
                            Translator.setLine(decl, (Object)st);
                        }
                        decl.setFlag(1024L);
                        list = st.getCdr();
                        continue;
                    }
                }
                tr.error('e', "invalid syntax in '" + this.getName() + '\'');
                boolean symbol = false;
                return symbol;
            }
            boolean nameSyntax = true;
            return nameSyntax;
        }
        finally {
            tr.popPositionOf(savePos);
        }
    }

    @Override
    public Expression rewriteForm(Pair form, Translator tr) {
        return tr.syntaxError(this.getName() + " is only allowed in a <body>");
    }

    static {
        module_export.setName("module-export");
        export = new export();
        export.setName("export");
    }
}

