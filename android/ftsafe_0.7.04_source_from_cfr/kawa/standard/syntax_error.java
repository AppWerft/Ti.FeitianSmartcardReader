/*
 * Decompiled with CFR 0.139.
 */
package kawa.standard;

import gnu.expr.Compilation;
import gnu.expr.ErrorExp;
import gnu.expr.Expression;
import gnu.kawa.functions.DisplayFormat;
import gnu.kawa.io.CharArrayOutPort;
import gnu.lists.Consumer;
import gnu.lists.EmptyList;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.lists.PrintConsumer;
import kawa.lang.Syntax;
import kawa.lang.Translator;

public class syntax_error
extends Syntax {
    public static final syntax_error syntax_error = new syntax_error();

    @Override
    public Expression rewrite(Object obj, Translator tr) {
        CharArrayOutPort buf = new CharArrayOutPort();
        int words = 0;
        DisplayFormat format = DisplayFormat.schemeDisplayFormat;
        while (obj instanceof Pair) {
            Pair pair = (Pair)obj;
            if (words > 0) {
                buf.append(' ');
            }
            format.format(Translator.stripSyntax(pair.getCar()), buf);
            format = DisplayFormat.schemeWriteFormat;
            obj = pair.getCdr();
            ++words;
        }
        if (obj != LList.Empty) {
            if (words > 0) {
                buf.append(' ');
            }
            format.format(obj, buf);
        }
        return tr.syntaxError(buf.toString());
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static Expression error(Object form, Object[] message) {
        StringBuffer buffer = new StringBuffer();
        int len = message.length;
        if (message == null || len == 0) {
            buffer.append("invalid syntax");
        } else {
            for (int i = 0; i < len; ++i) {
                buffer.append(message[i]);
            }
        }
        Translator tr = (Translator)Compilation.getCurrent();
        if (tr == null) {
            throw new RuntimeException(buffer.toString());
        }
        Object savePos = tr.pushPositionOf(form);
        try {
            ErrorExp errorExp = tr.syntaxError(buffer.toString());
            return errorExp;
        }
        finally {
            tr.popPositionOf(savePos);
        }
    }

    static {
        syntax_error.setName("syntax-error");
    }
}

