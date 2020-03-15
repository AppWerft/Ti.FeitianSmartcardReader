// 
// Decompiled by Procyon v0.5.36
// 

package kawa.standard;

import gnu.mapping.SimpleSymbol;
import gnu.text.SyntaxException;
import java.io.IOException;
import gnu.expr.Expression;
import gnu.expr.Declaration;
import gnu.lists.Sequence;
import gnu.expr.QuoteExp;
import gnu.expr.Compilation;
import kawa.lang.AutoloadProcedure;
import gnu.mapping.Symbol;
import gnu.text.Lexer;
import gnu.kawa.lispexpr.LispReader;
import gnu.kawa.io.InPort;
import gnu.expr.Language;
import java.io.File;
import gnu.lists.LList;
import kawa.lang.Translator;
import gnu.expr.ScopeExp;
import gnu.lists.Pair;
import kawa.lang.Syntax;

public class define_autoload extends Syntax
{
    public static final define_autoload define_autoload;
    public static final define_autoload define_autoloads_from_file;
    boolean fromFile;
    
    public define_autoload(final String name, final boolean fromFile) {
        super(name);
        this.fromFile = fromFile;
    }
    
    @Override
    public boolean scanForDefinitions(final Pair st, final ScopeExp defs, final Translator tr) {
        if (!(st.getCdr() instanceof Pair)) {
            return super.scanForDefinitions(st, defs, tr);
        }
        Pair p = (Pair)st.getCdr();
        if (this.fromFile) {
            while (true) {
                while (p.getCar() instanceof CharSequence) {
                    if (!this.scanFile(p.getCar().toString(), defs, tr)) {
                        return false;
                    }
                    final Object rest = p.getCdr();
                    if (rest == LList.Empty) {
                        return true;
                    }
                    if (!(rest instanceof Pair)) {
                        tr.syntaxError("invalid syntax for define-autoloads-from-file");
                        return false;
                    }
                    p = (Pair)p.getCdr();
                }
                continue;
            }
        }
        final Object names = p.getCar();
        Object filename = null;
        if (p.getCdr() instanceof Pair) {
            p = (Pair)p.getCdr();
            filename = p.getCar();
            return process(names, filename, defs, tr);
        }
        tr.syntaxError("invalid syntax for define-autoload");
        return false;
    }
    
    public boolean scanFile(final String filespec, final ScopeExp defs, final Translator tr) {
        if (filespec.endsWith(".el")) {}
        File file = new File(filespec);
        if (!file.isAbsolute()) {
            file = new File(new File(tr.getFileName()).getParent(), filespec);
        }
        final String filename = file.getPath();
        final int dot = filename.lastIndexOf(46);
        if (dot >= 0) {
            final String extension = filename.substring(dot);
            final Language language = Language.getInstance(extension);
            if (language == null) {
                tr.syntaxError("unknown extension for " + filename);
                return true;
            }
            String prefix = tr.classPrefix;
            final int extlen = extension.length();
            final int speclen = filespec.length();
            String cname;
            for (cname = filespec.substring(0, speclen - extlen); cname.startsWith("../"); cname = cname.substring(3)) {
                final int i = prefix.lastIndexOf(46, prefix.length() - 2);
                if (i < 0) {
                    tr.syntaxError("cannot use relative filename \"" + filespec + "\" with simple prefix \"" + prefix + "\"");
                    return false;
                }
                prefix = prefix.substring(0, i + 1);
            }
            final String classname = (prefix + cname).replace('/', '.');
            try {
                final InPort port = InPort.openFile(filename);
                final Lexer lexer = language.getLexer(port, tr.getMessages());
                findAutoloadComments((LispReader)lexer, classname, defs, tr);
            }
            catch (Exception ex) {
                tr.syntaxError("error reading " + filename + ": " + ex);
                return true;
            }
        }
        return true;
    }
    
    public static void findAutoloadComments(final LispReader in, final String filename, final ScopeExp defs, final Translator tr) throws IOException, SyntaxException {
        boolean lineStart = true;
        final String magic = ";;;###autoload";
        final int magicLength = magic.length();
    Label_0014:
        while (true) {
            int ch = in.peek();
            if (ch < 0) {
                return;
            }
            if (ch == 10 || ch == 13) {
                in.read();
                lineStart = true;
            }
            else {
                if (lineStart && ch == 59) {
                    int i = 0;
                    while (i != magicLength) {
                        ch = in.read();
                        if (ch < 0) {
                            return;
                        }
                        if (ch == 10 || ch == 13) {
                            lineStart = true;
                            continue Label_0014;
                        }
                        if (i < 0) {
                            continue;
                        }
                        if (ch == magic.charAt(i++)) {
                            continue;
                        }
                        i = -1;
                    }
                    if (i > 0) {
                        final Object form = in.readObject();
                        if (form instanceof Pair) {
                            final Pair pair = (Pair)form;
                            Object value = null;
                            String name = null;
                            final Object car = pair.getCar();
                            final String command = (car instanceof String) ? car.toString() : ((car instanceof Symbol) ? ((Symbol)car).getName() : null);
                            if (command == "defun") {
                                name = ((Pair)pair.getCdr()).getCar().toString();
                                value = new AutoloadProcedure(name, filename, tr.getLanguage());
                            }
                            else {
                                tr.error('w', "unsupported ;;;###autoload followed by: " + pair.getCar());
                            }
                            if (value != null) {
                                final Declaration decl = defs.getDefine(name, tr);
                                final Expression ex = new QuoteExp(value);
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
                }
                else {
                    if (Character.isWhitespace((char)ch)) {
                        continue;
                    }
                    final Object skipped = in.readObject(ch);
                    if (skipped == Sequence.eofValue) {
                        return;
                    }
                    continue;
                }
            }
        }
    }
    
    public static boolean process(final Object names, Object filename, final ScopeExp defs, final Translator tr) {
        if (names instanceof Pair) {
            final Pair p = (Pair)names;
            return process(p.getCar(), filename, defs, tr) && process(p.getCdr(), filename, defs, tr);
        }
        if (names == LList.Empty) {
            return true;
        }
        if (names instanceof String || names instanceof Symbol) {
            final String name = names.toString();
            final Declaration decl = defs.getDefine(name, tr);
            final String fn;
            final int len;
            if (filename instanceof SimpleSymbol && (len = (fn = filename.toString()).length()) > 2 && fn.charAt(0) == '<' && fn.charAt(len - 1) == '>') {
                filename = fn.substring(1, len - 1);
            }
            final Object value = new AutoloadProcedure(name, filename.toString(), tr.getLanguage());
            final Expression ex = new QuoteExp(value);
            decl.setFlag(16384L);
            decl.noteValue(ex);
            return true;
        }
        return false;
    }
    
    @Override
    public Expression rewriteForm(final Pair form, final Translator tr) {
        return null;
    }
    
    static {
        define_autoload = new define_autoload("define-autoload", false);
        define_autoloads_from_file = new define_autoload("define-autoloads-from-file", true);
    }
}
