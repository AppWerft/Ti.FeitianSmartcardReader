// 
// Decompiled by Procyon v0.5.36
// 

package kawa.standard;

import gnu.expr.Expression;
import gnu.expr.Declaration;
import gnu.mapping.Symbol;
import gnu.mapping.SimpleSymbol;
import gnu.lists.LList;
import gnu.expr.ModuleExp;
import kawa.lang.Translator;
import gnu.expr.ScopeExp;
import gnu.lists.Pair;
import kawa.lang.Syntax;

public class module_static extends Syntax
{
    public static final module_static module_static;
    
    @Override
    public boolean scanForDefinitions(Pair st, final ScopeExp defs, final Translator tr) {
        Object list = st.getCdr();
        if (!(defs instanceof ModuleExp)) {
            tr.error('e', "'" + this.getName() + "' not at module level");
            return true;
        }
        final ModuleExp mexp = (ModuleExp)defs;
        if (list instanceof Pair && (st = (Pair)list).getCdr() == LList.Empty && st.getCar() instanceof Boolean) {
            if (st.getCar() == Boolean.FALSE) {
                mexp.setFlag(131072);
            }
            else {
                mexp.setFlag(65536);
            }
        }
        else if (list instanceof Pair && (st = (Pair)list).getCdr() == LList.Empty && st.getCar() instanceof Pair && tr.matches((st = (Pair)st.getCar()).getCar(), "quote")) {
            final Object cdr = st.getCdr();
            if (cdr == LList.Empty || !((st = (Pair)cdr).getCar() instanceof SimpleSymbol) || st.getCar().toString() != "init-run") {
                tr.error('e', "invalid quoted symbol for '" + this.getName() + '\'');
                return false;
            }
            mexp.setFlag(65536);
            mexp.setFlag(524288);
            if (tr.generateMainMethod()) {
                tr.error('e', "init-run option incompatible with --main");
            }
        }
        else {
            mexp.setFlag(131072);
            while (list != LList.Empty) {
                if (!(list instanceof Pair) || !((st = (Pair)list).getCar() instanceof Symbol)) {
                    tr.error('e', "invalid syntax in '" + this.getName() + '\'');
                    return false;
                }
                final Symbol symbol = (Symbol)st.getCar();
                final Declaration decl = defs.getNoDefine(symbol);
                if (decl.getFlag(512L)) {
                    Translator.setLine(decl, st);
                }
                decl.setFlag(2048L);
                list = st.getCdr();
            }
        }
        if (mexp.getFlag(131072) && mexp.getFlag(65536)) {
            tr.error('e', "inconsistent module-static specifiers");
        }
        return true;
    }
    
    @Override
    public Expression rewriteForm(final Pair form, final Translator tr) {
        return null;
    }
    
    static {
        (module_static = new module_static()).setName("module-static");
    }
}
