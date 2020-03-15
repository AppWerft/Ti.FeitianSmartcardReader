// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.functions;

import java.util.Collection;
import java.util.ArrayList;
import gnu.bytecode.Type;
import java.util.Iterator;
import java.lang.reflect.Array;
import java.util.List;
import gnu.text.Char;
import gnu.lists.Sequences;
import gnu.lists.Strings;
import gnu.expr.ApplyExp;
import gnu.expr.Expression;
import gnu.expr.QuoteExp;
import gnu.mapping.Procedure1;

public class MakeSplice extends Procedure1
{
    public static final MakeSplice instance;
    public static final QuoteExp quoteInstance;
    
    public static Expression argIfSplice(final Expression exp) {
        if (exp instanceof ApplyExp) {
            final ApplyExp aexp = (ApplyExp)exp;
            if (aexp.getFunction() == MakeSplice.quoteInstance) {
                return aexp.getArg(0);
            }
        }
        return null;
    }
    
    @Override
    public Object apply1(final Object arg1) throws Throwable {
        throw new UnsupportedOperationException("$splice$ function should not be called");
    }
    
    public static int count(final Object values) {
        if (values instanceof CharSequence) {
            return Strings.sizeInCodePoints((CharSequence)values);
        }
        return Sequences.getSize(values);
    }
    
    public static void copyTo(final Object[] target, int start, final int size, final Object values) {
        if (values instanceof Object[]) {
            final Object[] arr = (Object[])values;
            final int nlen = arr.length;
            System.arraycopy(arr, 0, target, start, size);
        }
        else if (values instanceof CharSequence) {
            final CharSequence cseq = (CharSequence)values;
            for (int len = cseq.length(), i = 0; i < len; ++i) {
                final int ch = Character.codePointAt(cseq, i);
                target[start++] = Char.make(ch);
                if (ch > 65535) {
                    ++i;
                }
            }
        }
        else if (values instanceof List) {
            for (final Object val : (List)values) {
                target[start++] = val;
            }
        }
        else {
            if (!values.getClass().isArray()) {
                throw new ClassCastException("value is neither List or array");
            }
            for (int j = 0; j < size; ++j) {
                target[start++] = Array.get(values, j);
            }
        }
    }
    
    public static void copyTo(final Object target, int start, final int size, final Object values, final Type elementType) {
        if (elementType == Type.objectType) {
            copyTo((Object[])target, start, size, values);
        }
        else if (values instanceof CharSequence) {
            final CharSequence cseq = (CharSequence)values;
            for (int len = cseq.length(), i = 0; i < len; ++i) {
                final int ch = Character.codePointAt(cseq, i);
                final Object value = elementType.coerceFromObject(Char.make(ch));
                Array.set(target, start++, value);
                if (ch > 65535) {
                    ++i;
                }
            }
        }
        else if (values instanceof List) {
            for (final Object val : (List)values) {
                final Object value2 = elementType.coerceFromObject(val);
                Array.set(target, start++, value2);
            }
        }
        else {
            if (!values.getClass().isArray()) {
                throw new ClassCastException("value is neither List or array");
            }
            for (int j = 0; j < size; ++j) {
                final Object value3 = elementType.coerceFromObject(Array.get(values, j));
                Array.set(target, start++, value3);
            }
        }
    }
    
    public static void addAll(final ArrayList<Object> list, final Object values) {
        if (values instanceof Object[]) {
            final Object[] arr = (Object[])values;
            for (int nlen = arr.length, i = 0; i < nlen; ++i) {
                list.add(arr[i]);
            }
        }
        else if (values instanceof CharSequence) {
            final CharSequence cseq = (CharSequence)values;
            for (int len = cseq.length(), i = 0; i < len; ++i) {
                final int ch = Character.codePointAt(cseq, i);
                list.add(Char.make(ch));
                if (ch > 65535) {
                    ++i;
                }
            }
        }
        else if (values instanceof List) {
            list.addAll((Collection<?>)values);
        }
        else {
            if (!values.getClass().isArray()) {
                throw new ClassCastException("value is neither List or array");
            }
            for (int nlen2 = Array.getLength(values), j = 0; j < nlen2; ++j) {
                list.add(Array.get(values, j));
            }
        }
    }
    
    static {
        instance = new MakeSplice();
        quoteInstance = new QuoteExp(MakeSplice.instance);
    }
}
