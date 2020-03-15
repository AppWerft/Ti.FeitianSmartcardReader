// 
// Decompiled by Procyon v0.5.36
// 

package kawa.lang;

import gnu.expr.Language;
import gnu.text.SyntaxException;
import java.io.IOException;
import java.io.FileNotFoundException;
import gnu.mapping.WrappedException;
import gnu.kawa.io.InPort;
import gnu.expr.Compilation;
import gnu.text.SourceMessages;

public class CompileFile
{
    public static final Compilation read(final String name, final SourceMessages messages) throws IOException, SyntaxException {
        try {
            final InPort fstream = InPort.openFile(name);
            final Compilation result = read(fstream, messages);
            fstream.close();
            return result;
        }
        catch (FileNotFoundException e) {
            throw new WrappedException("compile-file: file not found: " + name, e);
        }
        catch (IOException e2) {
            throw new WrappedException("compile-file: read-error: " + name, e2);
        }
    }
    
    public static final Compilation read(final InPort port, final SourceMessages messages) throws IOException, SyntaxException {
        return Language.getDefaultLanguage().parse(port, messages, 0);
    }
}
