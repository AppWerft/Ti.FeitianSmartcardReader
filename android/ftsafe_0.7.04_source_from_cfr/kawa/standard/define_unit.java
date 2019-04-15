/*
 * Decompiled with CFR 0.139.
 */
package kawa.standard;

import gnu.bytecode.ClassType;
import gnu.bytecode.Type;
import gnu.expr.Compilation;
import gnu.expr.Declaration;
import gnu.expr.ErrorExp;
import gnu.expr.Expression;
import gnu.expr.ModuleExp;
import gnu.expr.QuoteExp;
import gnu.expr.ScopeExp;
import gnu.expr.SetExp;
import gnu.kawa.lispexpr.LispLanguage;
import gnu.kawa.reflect.Invoke;
import gnu.lists.EmptyList;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.mapping.Namespace;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Symbol;
import gnu.math.BaseUnit;
import gnu.math.NamedUnit;
import gnu.math.Quantity;
import gnu.math.Unit;
import kawa.lang.Syntax;
import kawa.lang.Translator;

public class define_unit
extends Syntax {
    public static final define_unit define_unit = new define_unit(false);
    public static final define_unit define_base_unit;
    boolean base;

    public define_unit(boolean base2) {
        this.base = base2;
    }

    @Override
    public boolean scanForDefinitions(Pair st, ScopeExp defs2, Translator tr) {
        Object q;
        Pair p;
        if (st.getCdr() instanceof Pair && (q = (p = (Pair)st.getCdr()).getCar()) instanceof SimpleSymbol) {
            String name = q.toString();
            Symbol sym = LispLanguage.unitNamespace.getSymbol(name);
            Declaration decl = defs2.getDefine(sym, tr);
            tr.push(decl);
            Translator.setLine(decl, (Object)p);
            decl.setFlag(16384L);
            if (defs2 instanceof ModuleExp) {
                decl.setCanRead(true);
            }
            NamedUnit unit = null;
            if (this.base && p.getCdr() == LList.Empty) {
                unit = BaseUnit.make(name, null);
            } else if (p.getCdr() instanceof Pair) {
                Object v = ((Pair)p.getCdr()).getCar();
                if (this.base && v instanceof CharSequence) {
                    unit = BaseUnit.make(name, v.toString());
                } else if (!this.base && v instanceof Quantity) {
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
        tr.error('e', "missing name in define-unit");
        return false;
    }

    @Override
    public Expression rewriteForm(Pair form, Translator tr) {
        Pair p1;
        Object obj = form.getCdr();
        Expression value = null;
        if (!(obj instanceof Pair) || !((p1 = (Pair)obj).getCar() instanceof Declaration)) {
            return tr.syntaxError("invalid syntax for " + this.getName());
        }
        Declaration decl = (Declaration)p1.getCar();
        Symbol symbol = (Symbol)decl.getSymbol();
        String unit = symbol.getLocalPart();
        ClassType unitType = ClassType.make("gnu.math.Unit");
        decl.setType(unitType);
        value = decl.getValue();
        if (!(value instanceof QuoteExp) || !(((QuoteExp)value).getValue() instanceof Unit)) {
            if (this.base) {
                String dimension = null;
                if (p1.getCdr() != LList.Empty) {
                    dimension = ((Pair)p1.getCdr()).getCar().toString();
                }
                BaseUnit bunit = BaseUnit.make(unit, dimension);
                value = new QuoteExp(bunit);
            } else {
                Object quantity;
                if (!(p1.getCdr() instanceof Pair)) {
                    return tr.syntaxError("missing value for define-unit");
                }
                Pair p2 = (Pair)p1.getCdr();
                value = tr.rewrite(p2.getCar());
                if (value instanceof QuoteExp && (quantity = ((QuoteExp)value).getValue()) instanceof Quantity) {
                    value = new QuoteExp(Unit.make(unit, (Quantity)quantity));
                } else {
                    Expression[] args = new Expression[]{new QuoteExp(unit), value};
                    value = Invoke.makeInvokeStatic(unitType, "make", args);
                }
            }
        }
        SetExp sexp = new SetExp(decl, value);
        sexp.setDefining(true);
        decl.noteValue(value);
        return sexp;
    }

    static {
        define_unit.setName("define-unit");
        define_base_unit = new define_unit(true);
        define_base_unit.setName("define-base-unit");
    }
}

