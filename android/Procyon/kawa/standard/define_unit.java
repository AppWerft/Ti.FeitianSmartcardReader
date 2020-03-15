// 
// Decompiled by Procyon v0.5.36
// 

package kawa.standard;

import gnu.expr.SetExp;
import gnu.kawa.reflect.Invoke;
import gnu.bytecode.Type;
import gnu.bytecode.ClassType;
import gnu.expr.Declaration;
import gnu.mapping.Symbol;
import gnu.expr.Expression;
import gnu.expr.QuoteExp;
import gnu.math.Unit;
import gnu.math.Quantity;
import gnu.math.BaseUnit;
import gnu.lists.LList;
import gnu.expr.ModuleExp;
import gnu.expr.Compilation;
import gnu.kawa.lispexpr.LispLanguage;
import gnu.mapping.SimpleSymbol;
import kawa.lang.Translator;
import gnu.expr.ScopeExp;
import gnu.lists.Pair;
import kawa.lang.Syntax;

public class define_unit extends Syntax
{
    public static final define_unit define_unit;
    public static final define_unit define_base_unit;
    boolean base;
    
    public define_unit(final boolean base) {
        this.base = base;
    }
    
    @Override
    public boolean scanForDefinitions(Pair st, final ScopeExp defs, final Translator tr) {
        if (st.getCdr() instanceof Pair) {
            Pair p = (Pair)st.getCdr();
            final Object q = p.getCar();
            if (q instanceof SimpleSymbol) {
                final String name = q.toString();
                final Symbol sym = LispLanguage.unitNamespace.getSymbol(name);
                final Declaration decl = defs.getDefine(sym, tr);
                tr.push(decl);
                Translator.setLine(decl, p);
                decl.setFlag(16384L);
                if (defs instanceof ModuleExp) {
                    decl.setCanRead(true);
                }
                Unit unit = null;
                if (this.base && p.getCdr() == LList.Empty) {
                    unit = BaseUnit.make(name, (String)null);
                }
                else if (p.getCdr() instanceof Pair) {
                    final Object v = ((Pair)p.getCdr()).getCar();
                    if (this.base && v instanceof CharSequence) {
                        unit = BaseUnit.make(name, v.toString());
                    }
                    else if (!this.base && v instanceof Quantity) {
                        unit = Unit.make(name, (Quantity)v);
                    }
                }
                if (unit != null) {
                    decl.noteValue(new QuoteExp(unit));
                }
                p = Translator.makePair(p, decl, p.getCdr());
                st = Translator.makePair(st, this, p);
                tr.pushForm(st);
                return true;
            }
        }
        tr.error('e', "missing name in define-unit");
        return false;
    }
    
    @Override
    public Expression rewriteForm(final Pair form, final Translator tr) {
        final Object obj = form.getCdr();
        Expression value = null;
        final Pair p1;
        if (!(obj instanceof Pair) || !((p1 = (Pair)obj).getCar() instanceof Declaration)) {
            return tr.syntaxError("invalid syntax for " + this.getName());
        }
        final Declaration decl = (Declaration)p1.getCar();
        final Symbol symbol = (Symbol)decl.getSymbol();
        final String unit = symbol.getLocalPart();
        final ClassType unitType = ClassType.make("gnu.math.Unit");
        decl.setType(unitType);
        if (!((value = decl.getValue()) instanceof QuoteExp) || !(((QuoteExp)value).getValue() instanceof Unit)) {
            if (this.base) {
                String dimension = null;
                if (p1.getCdr() != LList.Empty) {
                    dimension = ((Pair)p1.getCdr()).getCar().toString();
                }
                final BaseUnit bunit = BaseUnit.make(unit, dimension);
                value = new QuoteExp(bunit);
            }
            else {
                if (!(p1.getCdr() instanceof Pair)) {
                    return tr.syntaxError("missing value for define-unit");
                }
                final Pair p2 = (Pair)p1.getCdr();
                value = tr.rewrite(p2.getCar());
                final Object quantity;
                if (value instanceof QuoteExp && (quantity = ((QuoteExp)value).getValue()) instanceof Quantity) {
                    value = new QuoteExp(Unit.make(unit, (Quantity)quantity));
                }
                else {
                    final Expression[] args = { new QuoteExp((Object)unit), value };
                    value = Invoke.makeInvokeStatic(unitType, "make", args);
                }
            }
        }
        final SetExp sexp = new SetExp(decl, value);
        sexp.setDefining(true);
        decl.noteValue(value);
        return sexp;
    }
    
    static {
        (define_unit = new define_unit(false)).setName("define-unit");
        (define_base_unit = new define_unit(true)).setName("define-base-unit");
    }
}
