/*
 * Decompiled with CFR 0.139.
 */
package kawa.lang;

import gnu.kawa.functions.DisplayFormat;
import gnu.kawa.io.CharArrayOutPort;
import gnu.lists.Consumer;
import gnu.lists.LList;
import gnu.lists.PrintConsumer;
import gnu.mapping.Procedure;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Symbol;

public class NamedException
extends RuntimeException {
    Symbol name;
    Object[] args;
    static SimpleSymbol miscErrorSymbol = Symbol.valueOf("misc-error");

    public NamedException(Symbol name, Object[] args) {
        this.name = name;
        this.args = args;
    }

    public static /* varargs */ NamedException makeError(Object ... args) {
        Object[] xargs = new Object[args.length + 1];
        xargs[0] = miscErrorSymbol;
        System.arraycopy(args, 0, xargs, 1, args.length);
        return new NamedException(null, xargs);
    }

    public Object applyHandler(Object key, Procedure handler) throws Throwable {
        if (key != this.name && key != Boolean.TRUE) {
            throw this;
        }
        return handler.applyN(this.args);
    }

    public Object getObjectMessage() {
        return this.name == null ? this.args[1] : this.name;
    }

    public LList getObjectIrritants() {
        return LList.makeList(this.args, this.name == null ? 2 : 1);
    }

    @Override
    public String toString() {
        CharArrayOutPort buf = new CharArrayOutPort();
        buf.append("#<ERROR");
        int len = this.args.length;
        DisplayFormat format = DisplayFormat.schemeDisplayFormat;
        for (int i = this.name == null ? 1 : 0; i < len; ++i) {
            buf.append(' ');
            format.format(this.args[i], buf);
            format = DisplayFormat.schemeWriteFormat;
        }
        buf.append(">");
        return buf.toString();
    }
}

