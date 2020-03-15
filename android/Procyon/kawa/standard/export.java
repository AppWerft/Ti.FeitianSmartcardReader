// 
// Decompiled by Procyon v0.5.36
// 

package kawa.standard;

import gnu.expr.Declaration;
import gnu.expr.Expression;
import gnu.expr.SetExp;
import gnu.expr.ReferenceExp;
import gnu.mapping.Symbol;
import kawa.lang.SyntaxForm;
import gnu.lists.LList;
import gnu.expr.ModuleExp;
import kawa.lang.Translator;
import gnu.expr.ScopeExp;
import gnu.lists.Pair;
import kawa.lang.Syntax;

public class export extends Syntax
{
    public static final export module_export;
    public static final export export;
    
    @Override
    public boolean scanForDefinitions(Pair st, final ScopeExp defs, final Translator tr) {
        Object list = st.getCdr();
        final Object savePos = tr.pushPositionOf(st);
        try {
            if (!(defs instanceof ModuleExp)) {
                tr.error('e', "'" + this.getName() + "' not at module level");
                return false;
            }
            final ModuleExp mexp = (ModuleExp)defs;
            if (mexp.getFlag(16777216)) {
                tr.error('e', "'export' used follow explicit modules");
                return false;
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
                    st = (Pair)list;
                    Object symbol;
                    for (symbol = st.getCar(); symbol instanceof SyntaxForm; symbol = nameSyntax.getDatum()) {
                        nameSyntax = (SyntaxForm)symbol;
                    }
                    if (symbol instanceof String) {
                        final String str = (String)symbol;
                        if (str.startsWith("namespace:")) {
                            tr.error('w', "'namespace:' prefix ignored");
                            symbol = str.substring(10).intern();
                        }
                    }
                    symbol = tr.namespaceResolve(symbol);
                    if (symbol instanceof Pair) {
                        final Pair psym = (Pair)symbol;
                        final Object symcdr;
                        final Pair psymcdr;
                        final Object symcddr;
                        if (tr.matches(psym.getCar(), "rename") && (symcdr = psym.getCdr()) instanceof Pair && (symcddr = (psymcdr = (Pair)symcdr).getCdr()) instanceof Pair) {
                            final Pair psymcddr = (Pair)symcddr;
                            final Object symcdddr = psymcddr.getCdr();
                            final Object name1 = tr.namespaceResolve(psymcdr.getCar());
                            final Object name2 = tr.namespaceResolve(psymcddr.getCar());
                            if (symcdddr == LList.Empty && name1 instanceof Symbol && name2 instanceof Symbol) {
                                final Declaration decl1 = defs.getNoDefine(name1);
                                if (decl1.getFlag(512L)) {
                                    Translator.setLine(decl1, st);
                                }
                                decl1.setFlag(524288L);
                                final Declaration decl2 = tr.define(null, nameSyntax, defs);
                                decl2.setIndirectBinding(true);
                                decl2.setAlias(true);
                                decl2.setFlag(536871936L);
                                final ReferenceExp ref1 = new ReferenceExp(decl1);
                                ref1.setDontDereference(true);
                                final SetExp sexp = new SetExp(name2, ref1);
                                sexp.setBinding(decl2);
                                tr.setLineOf(sexp);
                                decl2.noteValueFromSet(sexp);
                                sexp.setDefining(true);
                                list = st.getCdr();
                                tr.pushForm(sexp);
                                continue;
                            }
                        }
                    }
                    if (symbol instanceof String || symbol instanceof Symbol) {
                        if (nameSyntax != null) {}
                        final Declaration decl3 = defs.getNoDefine(symbol);
                        if (decl3.getFlag(512L)) {
                            Translator.setLine(decl3, st);
                        }
                        decl3.setFlag(1024L);
                        list = st.getCdr();
                        continue;
                    }
                }
                tr.error('e', "invalid syntax in '" + this.getName() + '\'');
                return false;
            }
            return true;
        }
        finally {
            tr.popPositionOf(savePos);
        }
    }
    
    @Override
    public Expression rewriteForm(final Pair form, final Translator tr) {
        return tr.syntaxError(this.getName() + " is only allowed in a <body>");
    }
    
    static {
        (module_export = new export()).setName("module-export");
        (export = new export()).setName("export");
    }
}
