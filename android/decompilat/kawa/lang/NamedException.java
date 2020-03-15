// 
// Decompiled by Procyon v0.5.36
// 

package kawa.lang;

import gnu.lists.Consumer;
import gnu.kawa.functions.DisplayFormat;
import gnu.kawa.io.CharArrayOutPort;
import gnu.lists.LList;
import gnu.mapping.Procedure;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Symbol;

public class NamedException extends RuntimeException
{
    Symbol name;
    Object[] args;
    static SimpleSymbol miscErrorSymbol;
    
    public NamedException(final Symbol name, final Object[] args) {
        this.name = name;
        this.args = args;
    }
    
    public static NamedException makeError(final Object... args) {
        final Object[] xargs = new Object[args.length + 1];
        xargs[0] = NamedException.miscErrorSymbol;
        System.arraycopy(args, 0, xargs, 1, args.length);
        return new NamedException(null, xargs);
    }
    
    public Object applyHandler(final Object key, final Procedure handler) throws Throwable {
        if (key != this.name && key != Boolean.TRUE) {
            throw this;
        }
        return handler.applyN(this.args);
    }
    
    public Object getObjectMessage() {
        return (this.name == null) ? this.args[1] : this.name;
    }
    
    public LList getObjectIrritants() {
        return LList.makeList(this.args, (this.name == null) ? 2 : 1);
    }
    
    @Override
    public String toString() {
        final CharArrayOutPort buf = new CharArrayOutPort();
        buf.append("#<ERROR");
        final int len = this.args.length;
        int i = (this.name == null) ? 1 : 0;
        DisplayFormat format = DisplayFormat.schemeDisplayFormat;
        while (i < len) {
            buf.append(' ');
            format.format(this.args[i], buf);
            format = DisplayFormat.schemeWriteFormat;
            ++i;
        }
        buf.append(">");
        return buf.toString();
    }
    
    static {
        NamedException.miscErrorSymbol = Symbol.valueOf("misc-error");
    }
}
