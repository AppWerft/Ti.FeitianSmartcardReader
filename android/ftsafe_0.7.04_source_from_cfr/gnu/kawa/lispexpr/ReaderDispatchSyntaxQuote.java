/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.lispexpr;

import gnu.bytecode.Type;
import gnu.kawa.io.InPort;
import gnu.kawa.lispexpr.LispReader;
import gnu.kawa.lispexpr.ReadTable;
import gnu.kawa.lispexpr.ReadTableEntry;
import gnu.kawa.lispexpr.ReaderQuote;
import gnu.kawa.reflect.Invoke;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.mapping.Namespace;
import gnu.mapping.Procedure;
import gnu.mapping.Symbol;
import gnu.text.Lexer;
import gnu.text.SyntaxException;
import java.io.IOException;

public class ReaderDispatchSyntaxQuote
extends ReadTableEntry {
    static Symbol syntaxSymbol = ReaderDispatchSyntaxQuote.makeSymbol("syntax");
    static Symbol quasisyntaxSymbol = ReaderDispatchSyntaxQuote.makeSymbol("quasisyntax");
    static Symbol unsyntaxSymbol = ReaderDispatchSyntaxQuote.makeSymbol("unsyntax");
    static Symbol unsyntaxSplicingSymbol = ReaderDispatchSyntaxQuote.makeSymbol("unsyntax-splicing");

    static Symbol makeSymbol(String name) {
        return Namespace.EmptyNamespace.getSymbol(name);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public Object read(Lexer in, int ch, int count) throws IOException, SyntaxException {
        LispReader reader = (LispReader)in;
        switch (ch) {
            case 44: {
                if (reader.inQuasiSyntax) {
                    return ReaderQuote.read(reader, unsyntaxSymbol, '@', unsyntaxSplicingSymbol);
                }
                return ReaderDispatchSyntaxQuote.readNamedConstructor(reader);
            }
            case 39: {
                return ReaderQuote.read(reader, syntaxSymbol, '\u0000', null);
            }
            case 96: {
                boolean save = reader.inQuasiSyntax;
                reader.inQuasiSyntax = true;
                try {
                    Object object2 = ReaderQuote.read(reader, quasisyntaxSymbol, '\u0000', null);
                    return object2;
                }
                finally {
                    reader.inQuasiSyntax = save;
                }
            }
        }
        return null;
    }

    public static Object readNamedConstructor(LispReader reader) throws IOException, SyntaxException {
        int length;
        Object list;
        InPort port = reader.getPort();
        if (port.peek() == 40 && (length = LList.listLength(list = reader.readObject(), false)) > 0 && ((Pair)list).getCar() instanceof Symbol) {
            String name = ((Pair)list).getCar().toString();
            Object proc = ReadTable.getCurrent().getReaderCtor(name);
            if (proc == null) {
                reader.error("unknown reader constructor " + name);
            } else if (!(proc instanceof Procedure) && !(proc instanceof Type)) {
                reader.error("reader constructor must be procedure or type name");
            } else {
                int parg = proc instanceof Type ? 1 : 0;
                Object[] args = new Object[parg + --length];
                Object argList = ((Pair)list).getCdr();
                for (int i = 0; i < length; ++i) {
                    Pair pair = (Pair)argList;
                    args[parg + i] = pair.getCar();
                    argList = pair.getCdr();
                }
                try {
                    if (parg > 0) {
                        args[0] = proc;
                        return Invoke.make.applyN(args);
                    }
                    return ((Procedure)proc).applyN(args);
                }
                catch (Error ex) {
                    throw ex;
                }
                catch (Throwable ex) {
                    reader.error("caught " + ex + " applying reader constructor " + name);
                }
            }
        } else {
            reader.error("a non-empty list starting with a symbol must follow #,");
        }
        return Boolean.FALSE;
    }
}

