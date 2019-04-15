/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.lispexpr;

import gnu.bytecode.ArrayType;
import gnu.bytecode.ClassType;
import gnu.bytecode.ObjectType;
import gnu.bytecode.ParameterizedType;
import gnu.bytecode.Type;
import gnu.expr.ErrorExp;
import gnu.expr.Expression;
import gnu.expr.Language;
import gnu.expr.QuoteExp;
import gnu.kawa.lispexpr.GenArrayType;
import gnu.kawa.lispexpr.LangObjType;
import gnu.kawa.reflect.LazyType;
import gnu.lists.EmptyList;
import gnu.lists.LList;
import gnu.lists.Pair;
import java.lang.reflect.TypeVariable;
import kawa.lang.Syntax;
import kawa.lang.Translator;

public class BracketApply
extends Syntax {
    public static final BracketApply instance = new BracketApply();

    @Override
    public Expression rewrite(Object obj, Translator tr) {
        Expression arg1;
        Object val1;
        Class clas;
        if (!(obj instanceof Pair)) {
            return tr.syntaxError("internal error - $bracket-apply$ missing functor");
        }
        Pair pair = (Pair)obj;
        int length = LList.listLength(pair, false) - 1;
        Expression arg0 = tr.rewrite_car(pair, false);
        Object val = arg0.valueIfConstant();
        Object pairCdr = pair.getCdr();
        if (length == 1 && val == LangObjType.promiseType && pairCdr instanceof Pair && (val1 = (arg1 = tr.rewrite_car((Pair)pairCdr, false)).valueIfConstant()) instanceof Type) {
            return new QuoteExp(LazyType.getInstance(LazyType.lazyType, (Type)val1));
        }
        if (val instanceof Class) {
            clas = (Class)val;
        } else if (val instanceof ObjectType) {
            Type rtype = ((ObjectType)val).getRawType();
            clas = rtype.getReflectClass();
        } else {
            clas = null;
        }
        if (length > 0 && clas != null) {
            TypeVariable<Class<T>>[] vars = clas.getTypeParameters();
            if (vars.length != length) {
                return tr.syntaxError("expected " + vars.length + " parameters for type " + val);
            }
            Type[] params = new Type[length];
            for (int i = 0; i < length; ++i) {
                Pair pp2 = (Pair)pairCdr;
                Expression arg12 = tr.rewrite_car(pp2, false);
                Type type1 = tr.getLanguage().getTypeFor(arg12, false);
                gnu.bytecode.TypeVariable tvar = gnu.bytecode.TypeVariable.make(vars[i]);
                if (type1 == null) {
                    tr.errorWithPosition("unrecognized parameter type " + pp2.getCar(), pp2);
                    type1 = Type.objectType;
                } else {
                    int comp = tvar.compare(type1);
                    Language language = tr.getLanguage();
                    if (comp < 0) {
                        tr.error('e', "type parameter " + tvar.getName() + " must extend " + language.formatType(tvar.getRawType()) + " which is incompatible with " + language.formatType(type1));
                    }
                }
                params[i] = type1;
                pairCdr = pp2.getCdr();
            }
            if (val instanceof GenArrayType && length == 1) {
                int rank = ((GenArrayType)val).rank();
                return new QuoteExp(new GenArrayType(rank, params[0]));
            }
            return new QuoteExp(new ParameterizedType((ClassType)ClassType.make(clas), params));
        }
        if (pair.getCdr() != LList.Empty) {
            return tr.syntaxError("unrecognized syntax: type[args]");
        }
        if (val instanceof Type) {
            return new QuoteExp(ArrayType.make((Type)val));
        }
        if (val instanceof Class) {
            Class cls = (Class)val;
            return new QuoteExp(new ArrayType(ClassType.make(cls)).getReflectClass());
        }
        Type typ = tr.getLanguage().getTypeFor(arg0, false);
        if (typ != null) {
            return new QuoteExp(ArrayType.make(typ));
        }
        return tr.syntaxError("[] syntax not implemented for non-constant: " + arg0 + "::" + arg0.getClass().getName());
    }
}

