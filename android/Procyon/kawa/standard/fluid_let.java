// 
// Decompiled by Procyon v0.5.36
// 

package kawa.standard;

import gnu.mapping.Location;
import gnu.expr.Declaration;
import gnu.expr.ScopeExp;
import gnu.expr.ReferenceExp;
import gnu.expr.Compilation;
import gnu.kawa.reflect.StaticFieldLocation;
import kawa.lang.SyntaxForm;
import gnu.mapping.Symbol;
import gnu.expr.FluidLetExp;
import gnu.lists.LList;
import gnu.lists.Pair;
import kawa.lang.Translator;
import gnu.expr.Expression;
import kawa.lang.Syntax;

public class fluid_let extends Syntax
{
    public static final fluid_let fluid_let;
    boolean star;
    Expression defaultInit;
    boolean warnIfUndefined;
    
    public fluid_let(final boolean star, final boolean warnIfUndefined, final Expression defaultInit) {
        this.star = star;
        this.defaultInit = defaultInit;
        this.warnIfUndefined = warnIfUndefined;
    }
    
    public fluid_let() {
        this.star = false;
    }
    
    @Override
    public Expression rewrite(final Object obj, final Translator tr) {
        if (!(obj instanceof Pair)) {
            return tr.syntaxError("missing let arguments");
        }
        final Pair pair = (Pair)obj;
        return this.rewrite(pair.getCar(), pair.getCdr(), tr);
    }
    
    public Expression rewrite(Object bindings, final Object body, final Translator tr) {
        final int decl_count = this.star ? 1 : LList.length(bindings);
        final FluidLetExp let = new FluidLetExp();
        for (int i = 0; i < decl_count; ++i) {
            final Pair bind_pair = (Pair)bindings;
            final Object savePos = tr.pushPositionOf(bind_pair);
            try {
                Object name = bind_pair.getCar();
                Expression value;
                if (name instanceof String || name instanceof Symbol) {
                    value = this.defaultInit;
                }
                else {
                    Pair binding = null;
                    if (!(name instanceof Pair) || (!((binding = (Pair)name).getCar() instanceof String) && !(binding.getCar() instanceof Symbol) && !(binding.getCar() instanceof SyntaxForm))) {
                        return tr.syntaxError("invalid " + this.getName() + " syntax");
                    }
                    name = binding.getCar();
                    if (name instanceof SyntaxForm) {
                        name = ((SyntaxForm)name).getDatum();
                    }
                    if (binding.getCdr() == LList.Empty) {
                        value = this.defaultInit;
                    }
                    else {
                        if (!(binding.getCdr() instanceof Pair) || (binding = (Pair)binding.getCdr()).getCdr() != LList.Empty) {
                            return tr.syntaxError("bad syntax for value of " + name + " in " + this.getName());
                        }
                        value = tr.rewrite(binding.getCar());
                    }
                }
                final Declaration decl = let.addDeclaration(name);
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
                    (decl.base = found).setFluid(true);
                    found.setCanWrite(true);
                }
                else if (!this.warnIfUndefined) {
                    decl.setFlag(268435456L);
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
            }
            finally {
                tr.popPositionOf(savePos);
            }
        }
        tr.push(let);
        let.setBody((this.star && bindings != LList.Empty) ? this.rewrite(bindings, body, tr) : tr.rewrite_body(body));
        tr.pop(let);
        return let;
    }
    
    static {
        (fluid_let = new fluid_let()).setName("fluid-set");
    }
}
