// 
// Decompiled by Procyon v0.5.36
// 

package kawa.standard;

import gnu.expr.Compilation;
import gnu.lists.LList;
import gnu.lists.Consumer;
import gnu.lists.Pair;
import gnu.kawa.functions.DisplayFormat;
import gnu.kawa.io.CharArrayOutPort;
import gnu.expr.Expression;
import kawa.lang.Translator;
import kawa.lang.Syntax;

public class syntax_error extends Syntax
{
    public static final syntax_error syntax_error;
    
    @Override
    public Expression rewrite(Object obj, final Translator tr) {
        final CharArrayOutPort buf = new CharArrayOutPort();
        int words = 0;
        DisplayFormat format = DisplayFormat.schemeDisplayFormat;
        while (obj instanceof Pair) {
            final Pair pair = (Pair)obj;
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
    
    public static Expression error(final Object form, final Object[] message) {
        final StringBuffer buffer = new StringBuffer();
        final int len = message.length;
        if (message == null || len == 0) {
            buffer.append("invalid syntax");
        }
        else {
            for (int i = 0; i < len; ++i) {
                buffer.append(message[i]);
            }
        }
        final Translator tr = (Translator)Compilation.getCurrent();
        if (tr == null) {
            throw new RuntimeException(buffer.toString());
        }
        final Object savePos = tr.pushPositionOf(form);
        try {
            return tr.syntaxError(buffer.toString());
        }
        finally {
            tr.popPositionOf(savePos);
        }
    }
    
    static {
        (syntax_error = new syntax_error()).setName("syntax-error");
    }
}
