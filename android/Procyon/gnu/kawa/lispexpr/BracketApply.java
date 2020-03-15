// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.lispexpr;

import gnu.expr.Language;
import gnu.bytecode.ArrayType;
import gnu.bytecode.ParameterizedType;
import gnu.bytecode.ClassType;
import gnu.bytecode.TypeVariable;
import gnu.bytecode.ObjectType;
import gnu.expr.QuoteExp;
import gnu.kawa.reflect.LazyType;
import gnu.bytecode.Type;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.expr.Expression;
import kawa.lang.Translator;
import kawa.lang.Syntax;

public class BracketApply extends Syntax
{
    public static final BracketApply instance;
    
    @Override
    public Expression rewrite(final Object obj, final Translator tr) {
        if (!(obj instanceof Pair)) {
            return tr.syntaxError("internal error - $bracket-apply$ missing functor");
        }
        final Pair pair = (Pair)obj;
        final int length = LList.listLength(pair, false) - 1;
        final Expression arg0 = tr.rewrite_car(pair, false);
        final Object val = arg0.valueIfConstant();
        Object pairCdr = pair.getCdr();
        if (length == 1 && val == LangObjType.promiseType && pairCdr instanceof Pair) {
            final Expression arg2 = tr.rewrite_car((Pair)pairCdr, false);
            final Object val2 = arg2.valueIfConstant();
            if (val2 instanceof Type) {
                return new QuoteExp(LazyType.getInstance(LazyType.lazyType, (Type)val2));
            }
        }
        Class clas;
        if (val instanceof Class) {
            clas = (Class)val;
        }
        else if (val instanceof ObjectType) {
            final Type rtype = ((ObjectType)val).getRawType();
            clas = rtype.getReflectClass();
        }
        else {
            clas = null;
        }
        if (length > 0 && clas != null) {
            final java.lang.reflect.TypeVariable[] vars = clas.getTypeParameters();
            if (vars.length != length) {
                return tr.syntaxError("expected " + vars.length + " parameters for type " + val);
            }
            final Type[] params = new Type[length];
            for (int i = 0; i < length; ++i) {
                final Pair pp = (Pair)pairCdr;
                final Expression arg3 = tr.rewrite_car(pp, false);
                Type type1 = tr.getLanguage().getTypeFor(arg3, false);
                final TypeVariable tvar = TypeVariable.make(vars[i]);
                if (type1 == null) {
                    tr.errorWithPosition("unrecognized parameter type " + pp.getCar(), pp);
                    type1 = Type.objectType;
                }
                else {
                    final int comp = tvar.compare(type1);
                    final Language language = tr.getLanguage();
                    if (comp < 0) {
                        tr.error('e', "type parameter " + tvar.getName() + " must extend " + language.formatType(tvar.getRawType()) + " which is incompatible with " + language.formatType(type1));
                    }
                }
                params[i] = type1;
                pairCdr = pp.getCdr();
            }
            if (val instanceof GenArrayType && length == 1) {
                final int rank = ((GenArrayType)val).rank();
                return new QuoteExp(new GenArrayType(rank, params[0]));
            }
            return new QuoteExp(new ParameterizedType((ClassType)Type.make(clas), params));
        }
        else {
            if (pair.getCdr() != LList.Empty) {
                return tr.syntaxError("unrecognized syntax: type[args]");
            }
            if (val instanceof Type) {
                return new QuoteExp(ArrayType.make((Type)val));
            }
            if (val instanceof Class) {
                final Class cls = (Class)val;
                return new QuoteExp(new ArrayType(Type.make(cls)).getReflectClass());
            }
            final Type typ = tr.getLanguage().getTypeFor(arg0, false);
            if (typ != null) {
                return new QuoteExp(ArrayType.make(typ));
            }
            return tr.syntaxError("[] syntax not implemented for non-constant: " + arg0 + "::" + arg0.getClass().getName());
        }
    }
    
    static {
        instance = new BracketApply();
    }
}
