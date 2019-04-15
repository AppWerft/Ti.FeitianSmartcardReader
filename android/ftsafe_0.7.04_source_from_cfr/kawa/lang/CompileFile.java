/*
 * Decompiled with CFR 0.139.
 */
package kawa.lang;

import gnu.expr.Compilation;
import gnu.expr.Language;
import gnu.kawa.io.InPort;
import gnu.mapping.WrappedException;
import gnu.text.SourceMessages;
import gnu.text.SyntaxException;
import java.io.FileNotFoundException;
import java.io.IOException;

public class CompileFile {
    public static final Compilation read(String name, SourceMessages messages) throws IOException, SyntaxException {
        try {
            InPort fstream = InPort.openFile(name);
            Compilation result = CompileFile.read(fstream, messages);
            fstream.close();
            return result;
        }
        catch (FileNotFoundException e) {
            throw new WrappedException("compile-file: file not found: " + name, e);
        }
        catch (IOException e) {
            throw new WrappedException("compile-file: read-error: " + name, e);
        }
    }

    public static final Compilation read(InPort port, SourceMessages messages) throws IOException, SyntaxException {
        return Language.getDefaultLanguage().parse(port, messages, 0);
    }
}

