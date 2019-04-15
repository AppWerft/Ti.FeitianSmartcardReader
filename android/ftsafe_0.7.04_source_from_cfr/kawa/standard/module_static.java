/*
 * Decompiled with CFR 0.139.
 */
package kawa.standard;

import gnu.expr.Declaration;
import gnu.expr.Expression;
import gnu.expr.ModuleExp;
import gnu.expr.ScopeExp;
import gnu.lists.EmptyList;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Symbol;
import kawa.lang.Syntax;
import kawa.lang.Translator;

public class module_static
extends Syntax {
    public static final module_static module_static = new module_static();

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    @Override
    public boolean scanForDefinitions(Pair st, ScopeExp defs, Translator tr) {
        block10 : {
            block9 : {
                list = st.getCdr();
                if (!(defs instanceof ModuleExp)) {
                    tr.error('e', "'" + this.getName() + "' not at module level");
                    return true;
                }
                mexp = (ModuleExp)defs;
                if (!(list instanceof Pair) || (st = (Pair)list).getCdr() != LList.Empty || !(st.getCar() instanceof Boolean)) break block9;
                if (st.getCar() == Boolean.FALSE) {
                    mexp.setFlag(131072);
                } else {
                    mexp.setFlag(65536);
                }
                break block10;
            }
            if (!(list instanceof Pair) || (st = (Pair)list).getCdr() != LList.Empty || !(st.getCar() instanceof Pair) || !tr.matches((st = (Pair)st.getCar()).getCar(), "quote")) ** GOTO lbl23
            cdr = st.getCdr();
            if (cdr != LList.Empty && (st = (Pair)cdr).getCar() instanceof SimpleSymbol && st.getCar().toString() == "init-run") {
                mexp.setFlag(65536);
                mexp.setFlag(524288);
                if (tr.generateMainMethod()) {
                    tr.error('e', "init-run option incompatible with --main");
                }
            } else {
                tr.error('e', "invalid quoted symbol for '" + this.getName() + '\'');
                return false;
lbl23: // 1 sources:
                mexp.setFlag(131072);
                while (list != LList.Empty) {
                    if (!(list instanceof Pair) || !((st = (Pair)list).getCar() instanceof Symbol)) {
                        tr.error('e', "invalid syntax in '" + this.getName() + '\'');
                        return false;
                    }
                    symbol = (Symbol)st.getCar();
                    decl = defs.getNoDefine(symbol);
                    if (decl.getFlag(512L)) {
                        Translator.setLine(decl, (Object)st);
                    }
                    decl.setFlag(2048L);
                    list = st.getCdr();
                }
            }
        }
        if (mexp.getFlag(131072) == false) return true;
        if (mexp.getFlag(65536) == false) return true;
        tr.error('e', "inconsistent module-static specifiers");
        return true;
    }

    @Override
    public Expression rewriteForm(Pair form, Translator tr) {
        return null;
    }

    static {
        module_static.setName("module-static");
    }
}

