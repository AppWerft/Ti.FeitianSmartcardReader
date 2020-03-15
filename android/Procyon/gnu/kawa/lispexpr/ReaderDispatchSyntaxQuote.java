// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.lispexpr;

import gnu.kawa.io.InPort;
import gnu.kawa.reflect.Invoke;
import gnu.bytecode.Type;
import gnu.mapping.Procedure;
import gnu.lists.Pair;
import gnu.lists.LList;
import gnu.text.SyntaxException;
import java.io.IOException;
import gnu.text.Lexer;
import gnu.mapping.Namespace;
import gnu.mapping.Symbol;

public class ReaderDispatchSyntaxQuote extends ReadTableEntry
{
    static Symbol syntaxSymbol;
    static Symbol quasisyntaxSymbol;
    static Symbol unsyntaxSymbol;
    static Symbol unsyntaxSplicingSymbol;
    
    static Symbol makeSymbol(final String name) {
        return Namespace.EmptyNamespace.getSymbol(name);
    }
    
    public Object read(final Lexer in, final int ch, final int count) throws IOException, SyntaxException {
        final LispReader reader = (LispReader)in;
        switch (ch) {
            case 44: {
                if (reader.inQuasiSyntax) {
                    return ReaderQuote.read(reader, ReaderDispatchSyntaxQuote.unsyntaxSymbol, '@', ReaderDispatchSyntaxQuote.unsyntaxSplicingSymbol);
                }
                return readNamedConstructor(reader);
            }
            case 39: {
                return ReaderQuote.read(reader, ReaderDispatchSyntaxQuote.syntaxSymbol, '\0', null);
            }
            case 96: {
                final boolean save = reader.inQuasiSyntax;
                reader.inQuasiSyntax = true;
                try {
                    return ReaderQuote.read(reader, ReaderDispatchSyntaxQuote.quasisyntaxSymbol, '\0', null);
                }
                finally {
                    reader.inQuasiSyntax = save;
                }
                break;
            }
        }
        return null;
    }
    
    public static Object readNamedConstructor(final LispReader reader) throws IOException, SyntaxException {
        final InPort port = reader.getPort();
        final Object list;
        int length;
        if (port.peek() == 40 && (length = LList.listLength(list = reader.readObject(), false)) > 0 && ((Pair)list).getCar() instanceof Symbol) {
            final String name = ((Pair)list).getCar().toString();
            final Object proc = ReadTable.getCurrent().getReaderCtor(name);
            if (proc == null) {
                reader.error("unknown reader constructor " + name);
            }
            else if (!(proc instanceof Procedure) && !(proc instanceof Type)) {
                reader.error("reader constructor must be procedure or type name");
            }
            else {
                --length;
                final int parg = (proc instanceof Type) ? 1 : 0;
                final Object[] args = new Object[parg + length];
                Object argList = ((Pair)list).getCdr();
                for (int i = 0; i < length; ++i) {
                    final Pair pair = (Pair)argList;
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
                catch (Throwable ex2) {
                    reader.error("caught " + ex2 + " applying reader constructor " + name);
                }
            }
        }
        else {
            reader.error("a non-empty list starting with a symbol must follow #,");
        }
        return Boolean.FALSE;
    }
    
    static {
        ReaderDispatchSyntaxQuote.syntaxSymbol = makeSymbol("syntax");
        ReaderDispatchSyntaxQuote.quasisyntaxSymbol = makeSymbol("quasisyntax");
        ReaderDispatchSyntaxQuote.unsyntaxSymbol = makeSymbol("unsyntax");
        ReaderDispatchSyntaxQuote.unsyntaxSplicingSymbol = makeSymbol("unsyntax-splicing");
    }
}
