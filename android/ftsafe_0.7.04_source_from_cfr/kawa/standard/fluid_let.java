/*
 * Decompiled with CFR 0.139.
 */
package kawa.standard;

import gnu.expr.Compilation;
import gnu.expr.Declaration;
import gnu.expr.ErrorExp;
import gnu.expr.Expression;
import gnu.expr.FluidLetExp;
import gnu.expr.Language;
import gnu.expr.ReferenceExp;
import gnu.expr.ScopeExp;
import gnu.kawa.reflect.StaticFieldLocation;
import gnu.lists.EmptyList;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.mapping.Environment;
import gnu.mapping.Location;
import gnu.mapping.Symbol;
import kawa.lang.Syntax;
import kawa.lang.SyntaxForm;
import kawa.lang.Translator;

public class fluid_let
extends Syntax {
    public static final fluid_let fluid_let = new fluid_let();
    boolean star;
    Expression defaultInit;
    boolean warnIfUndefined;

    public fluid_let(boolean star, boolean warnIfUndefined, Expression defaultInit) {
        this.star = star;
        this.defaultInit = defaultInit;
        this.warnIfUndefined = warnIfUndefined;
    }

    public fluid_let() {
        this.star = false;
    }

    @Override
    public Expression rewrite(Object obj, Translator tr) {
        if (!(obj instanceof Pair)) {
            return tr.syntaxError("missing let arguments");
        }
        Pair pair = (Pair)obj;
        return this.rewrite(pair.getCar(), pair.getCdr(), tr);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public Expression rewrite(Object bindings, Object body, Translator tr) {
        int decl_count = this.star ? 1 : LList.length(bindings);
        FluidLetExp let2 = new FluidLetExp();
        for (int i = 0; i < decl_count; ++i) {
            Pair bind_pair = (Pair)bindings;
            Object savePos = tr.pushPositionOf(bind_pair);
            try {
                ErrorExp errorExp;
                Expression value;
                Pair binding;
                Object name = bind_pair.getCar();
                if (name instanceof String || name instanceof Symbol) {
                    value = this.defaultInit;
                } else if (name instanceof Pair && ((binding = (Pair)name).getCar() instanceof String || binding.getCar() instanceof Symbol || binding.getCar() instanceof SyntaxForm)) {
                    name = binding.getCar();
                    if (name instanceof SyntaxForm) {
                        name = ((SyntaxForm)name).getDatum();
                    }
                    if (binding.getCdr() == LList.Empty) {
                        value = this.defaultInit;
                    } else {
                        if (!(binding.getCdr() instanceof Pair) || (binding = (Pair)binding.getCdr()).getCdr() != LList.Empty) {
                            errorExp = tr.syntaxError("bad syntax for value of " + name + " in " + this.getName());
                            return errorExp;
                        }
                        value = tr.rewrite(binding.getCar());
                    }
                } else {
                    errorExp = tr.syntaxError("invalid " + this.getName() + " syntax");
                    return errorExp;
                }
                Declaration decl = let2.addDeclaration(name);
                Declaration found = tr.lookup(name, -1);
                if (found == null && name instanceof Symbol) {
                    Location loc = tr.getLanguage().getLangEnvironment().lookup((Symbol)name, null);
                    if (loc != null) {
                        loc = loc.getBase();
                    }
                    if (loc instanceof StaticFieldLocation) {
                        found = ((StaticFieldLocation)loc).getDeclaration();
                    }
                }
                if (found != null) {
                    found.maybeIndirectBinding(tr);
                    decl.base = found;
                    found.setFluid(true);
                    found.setCanWrite(true);
                } else if (!this.warnIfUndefined) {
                    decl.setFlag(0x10000000L);
                }
                decl.setCanWrite(true);
                decl.setFluid(true);
                decl.setIndirectBinding(true);
                if (value == null) {
                    value = new ReferenceExp(name);
                }
                decl.setInitValue(value);
                decl.noteValueUnknown();
                bindings = bind_pair.getCdr();
                continue;
            }
            finally {
                tr.popPositionOf(savePos);
            }
        }
        tr.push(let2);
        let2.setBody(this.star && bindings != LList.Empty ? this.rewrite(bindings, body, tr) : tr.rewrite_body(body));
        tr.pop(let2);
        return let2;
    }

    static {
        fluid_let.setName("fluid-set");
    }
}

