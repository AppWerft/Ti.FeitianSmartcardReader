/*
 * Decompiled with CFR 0.139.
 */
package kawa.standard;

import gnu.expr.Compilation;
import gnu.expr.Declaration;
import gnu.expr.ErrorExp;
import gnu.expr.Expression;
import gnu.expr.Language;
import gnu.expr.QuoteExp;
import gnu.expr.ScopeExp;
import gnu.kawa.io.InPort;
import gnu.kawa.lispexpr.LispReader;
import gnu.lists.EmptyList;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.lists.Sequence;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Symbol;
import gnu.text.Lexer;
import gnu.text.SourceMessages;
import gnu.text.SyntaxException;
import java.io.File;
import java.io.IOException;
import kawa.lang.AutoloadProcedure;
import kawa.lang.Syntax;
import kawa.lang.Translator;

public class define_autoload
extends Syntax {
    public static final define_autoload define_autoload = new define_autoload("define-autoload", false);
    public static final define_autoload define_autoloads_from_file = new define_autoload("define-autoloads-from-file", true);
    boolean fromFile;

    public define_autoload(String name, boolean fromFile) {
        super(name);
        this.fromFile = fromFile;
    }

    @Override
    public boolean scanForDefinitions(Pair st, ScopeExp defs2, Translator tr) {
        if (!(st.getCdr() instanceof Pair)) {
            return super.scanForDefinitions(st, defs2, tr);
        }
        Pair p = (Pair)st.getCdr();
        if (this.fromFile) {
            while (p.getCar() instanceof CharSequence) {
                if (!this.scanFile(p.getCar().toString(), defs2, tr)) {
                    return false;
                }
                Object rest = p.getCdr();
                if (rest == LList.Empty) {
                    return true;
                }
                if (!(rest instanceof Pair)) break;
                p = (Pair)p.getCdr();
            }
            tr.syntaxError("invalid syntax for define-autoloads-from-file");
            return false;
        }
        Object names = p.getCar();
        Object filename = null;
        if (p.getCdr() instanceof Pair) {
            p = (Pair)p.getCdr();
            filename = p.getCar();
            return define_autoload.process(names, filename, defs2, tr);
        }
        tr.syntaxError("invalid syntax for define-autoload");
        return false;
    }

    public boolean scanFile(String filespec, ScopeExp defs2, Translator tr) {
        int dot;
        File file2;
        String filename;
        if (filespec.endsWith(".el")) {
            // empty if block
        }
        if (!(file2 = new File(filespec)).isAbsolute()) {
            file2 = new File(new File(tr.getFileName()).getParent(), filespec);
        }
        if ((dot = (filename = file2.getPath()).lastIndexOf(46)) >= 0) {
            String extension = filename.substring(dot);
            Language language = Language.getInstance(extension);
            if (language == null) {
                tr.syntaxError("unknown extension for " + filename);
                return true;
            }
            String prefix = tr.classPrefix;
            int extlen = extension.length();
            int speclen = filespec.length();
            String cname = filespec.substring(0, speclen - extlen);
            while (cname.startsWith("../")) {
                int i = prefix.lastIndexOf(46, prefix.length() - 2);
                if (i < 0) {
                    tr.syntaxError("cannot use relative filename \"" + filespec + "\" with simple prefix \"" + prefix + "\"");
                    return false;
                }
                prefix = prefix.substring(0, i + 1);
                cname = cname.substring(3);
            }
            String classname = (prefix + cname).replace('/', '.');
            try {
                InPort port = InPort.openFile(filename);
                Lexer lexer = language.getLexer(port, tr.getMessages());
                define_autoload.findAutoloadComments((LispReader)lexer, classname, defs2, tr);
            }
            catch (Exception ex) {
                tr.syntaxError("error reading " + filename + ": " + ex);
                return true;
            }
        }
        return true;
    }

    public static void findAutoloadComments(LispReader in, String filename, ScopeExp defs2, Translator tr) throws IOException, SyntaxException {
        boolean lineStart = true;
        String magic = ";;;###autoload";
        int magicLength = magic.length();
        block0 : do {
            Object skipped;
            int ch;
            if ((ch = in.peek()) < 0) {
                return;
            }
            if (ch == 10 || ch == 13) {
                in.read();
                lineStart = true;
                continue;
            }
            if (lineStart && ch == 59) {
                int i = 0;
                while (i != magicLength) {
                    ch = in.read();
                    if (ch < 0) {
                        return;
                    }
                    if (ch == 10 || ch == 13) {
                        lineStart = true;
                        continue block0;
                    }
                    if (i < 0 || ch == magic.charAt(i++)) continue;
                    i = -1;
                }
                if (i > 0) {
                    Object form = in.readObject();
                    if (form instanceof Pair) {
                        String command;
                        Pair pair = (Pair)form;
                        AutoloadProcedure value = null;
                        String name = null;
                        Object car = pair.getCar();
                        String string = car instanceof String ? car.toString() : (command = car instanceof Symbol ? ((Symbol)car).getName() : null);
                        if (command == "defun") {
                            name = ((Pair)pair.getCdr()).getCar().toString();
                            value = new AutoloadProcedure(name, filename, tr.getLanguage());
                        } else {
                            tr.error('w', "unsupported ;;;###autoload followed by: " + pair.getCar());
                        }
                        if (value != null) {
                            Declaration decl = defs2.getDefine(name, tr);
                            QuoteExp ex = new QuoteExp(value);
                            decl.setFlag(16384L);
                            decl.noteValue(ex);
                        }
                    }
                    lineStart = false;
                    continue;
                }
            }
            lineStart = false;
            in.skip();
            if (ch == 35 && in.peek() == 124) {
                in.skip();
                in.readNestedComment('#', '|', '|', '#');
                continue;
            }
            if (!Character.isWhitespace((char)ch) && (skipped = in.readObject(ch)) == Sequence.eofValue) break;
        } while (true);
    }

    public static boolean process(Object names, Object filename, ScopeExp defs2, Translator tr) {
        if (names instanceof Pair) {
            Pair p = (Pair)names;
            return define_autoload.process(p.getCar(), filename, defs2, tr) && define_autoload.process(p.getCdr(), filename, defs2, tr);
        }
        if (names == LList.Empty) {
            return true;
        }
        if (names instanceof String || names instanceof Symbol) {
            int len;
            String fn;
            String name = names.toString();
            Declaration decl = defs2.getDefine(name, tr);
            if (filename instanceof SimpleSymbol && (len = (fn = filename.toString()).length()) > 2 && fn.charAt(0) == '<' && fn.charAt(len - 1) == '>') {
                filename = fn.substring(1, len - 1);
            }
            AutoloadProcedure value = new AutoloadProcedure(name, filename.toString(), tr.getLanguage());
            QuoteExp ex = new QuoteExp(value);
            decl.setFlag(16384L);
            decl.noteValue(ex);
            return true;
        }
        return false;
    }

    @Override
    public Expression rewriteForm(Pair form, Translator tr) {
        return null;
    }
}

