/*
 * Decompiled with CFR 0.139.
 */
package kawa.standard;

import gnu.expr.Expression;
import gnu.expr.ModuleInfo;
import gnu.expr.ScopeExp;
import gnu.kawa.io.BinaryInPort;
import gnu.kawa.io.InPort;
import gnu.kawa.io.Path;
import gnu.kawa.lispexpr.LispReader;
import gnu.lists.EmptyList;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.lists.Sequence;
import gnu.text.Lexer;
import gnu.text.SourceMessages;
import java.io.File;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;
import kawa.lang.Syntax;
import kawa.lang.Translator;

public class Include
extends Syntax {
    boolean ignoreCase;
    boolean relative;
    public static final Include include = new Include("include", false, false);
    public static final Include includeRelative = new Include("include-relative", true, false);
    public static final Include includeCi = new Include("include-ci", true, true);
    public static final ThreadLocal<List<CharSequence>> searchPath = new InheritableThreadLocal<List<CharSequence>>();

    public Include(String name, boolean relative, boolean ignoreCase) {
        super(name);
        this.relative = relative;
        this.ignoreCase = ignoreCase;
    }

    @Override
    public void scanForm(Pair st, ScopeExp defs2, Translator tr) {
        this.process(st.getCdr(), tr, defs2, this.ignoreCase);
    }

    @Override
    public Expression rewrite(Object obj, Translator tr) {
        return tr.rewrite_body(this.process(obj, tr, null, this.ignoreCase));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public LList process(Object rest, Translator tr, ScopeExp defs2, boolean ignoreCase) {
        LList result = LList.Empty;
        Pair lastPair = null;
        if (tr.getState() == 1) {
            tr.setState(2);
        }
        while (rest instanceof Pair) {
            Pair pair;
            CharSequence searchElement;
            BinaryInPort inp;
            Path path;
            pair = (Pair)rest;
            Object paircar = pair.getCar();
            Object savePos1 = tr.pushPositionOf(pair);
            if (!(paircar instanceof CharSequence)) {
                tr.error('e', "include parameters must be strings");
            }
            String fname = paircar.toString();
            Iterator<CharSequence> searchIterator = Include.getIncludeSearchPath().iterator();
            CharSequence charSequence = searchElement = this.relative ? "|" : null;
            do {
                Path pathElement;
                if (searchElement == null) {
                    if (!searchIterator.hasNext()) {
                        tr.error('e', "cannot open file \"" + fname + "\"");
                        return result;
                    }
                    searchElement = searchIterator.next();
                }
                if (searchElement.length() > 0 && searchElement.charAt(0) == '|') {
                    pathElement = tr.getMinfo().getSourceAbsPath();
                    if (pathElement == null || !pathElement.isPlainFile()) {
                        pathElement = Path.currentPath();
                    }
                    if (searchElement.length() > 1) {
                        pathElement = pathElement.resolve(searchElement.toString().substring(1));
                    }
                } else {
                    pathElement = Path.valueOf(searchElement);
                }
                try {
                    path = pathElement.resolve(fname);
                    InputStream istrm = path.openInputStream();
                    try {
                        inp = BinaryInPort.openHeuristicFile(istrm, path);
                    }
                    catch (Exception ex) {
                        tr.error('e', "error reading file \"" + path + "\": " + ex.getMessage());
                        return result;
                    }
                }
                catch (Exception ex) {
                    searchElement = null;
                    continue;
                }
                break;
            } while (true);
            tr.popPositionOf(savePos1);
            LispReader reader = new LispReader(inp, tr.getMessages());
            if (ignoreCase) {
                reader.setReadCase('D');
            }
            Lexer saveLexer = tr.lexer;
            tr.lexer = reader;
            try {
                Charset saveCset;
                InPort savePort;
                if (inp.getCharset() == null && saveLexer != null && (savePort = saveLexer.getPort()) instanceof BinaryInPort && (saveCset = ((BinaryInPort)savePort).getCharset()) != null) {
                    inp.setDefaultCharset(saveCset);
                }
                do {
                    Object sexp;
                    block27 : {
                        try {
                            sexp = reader.readCommand();
                            if (sexp != Sequence.eofValue) break block27;
                            break;
                        }
                        catch (Exception ex) {
                            tr.error('e', "error reading file \"" + path + "\": " + ex.getMessage());
                            EmptyList emptyList = result;
                            tr.lexer = saveLexer;
                            return emptyList;
                        }
                    }
                    if (defs2 != null) {
                        tr.scanForm(sexp, defs2);
                        continue;
                    }
                    Pair npair = new Pair(sexp, LList.Empty);
                    if (lastPair == null) {
                        result = npair;
                    } else {
                        lastPair.setCdrBackdoor(npair);
                    }
                    lastPair = npair;
                } while (true);
            }
            finally {
                tr.lexer = saveLexer;
            }
            rest = pair.getCdr();
        }
        if (rest != LList.Empty) {
            tr.error('e', "improper list");
        }
        return result;
    }

    public static List<CharSequence> getIncludeSearchPath() {
        return Include.getSearchPath(searchPath, "kawa.include.path", "|:.");
    }

    public static List<CharSequence> getSearchPath(ThreadLocal<List<CharSequence>> var, String propertyName, String defaultPath) {
        List<CharSequence> path = var.get();
        if (path != null) {
            return path;
        }
        String pstr = System.getProperty(propertyName);
        if (pstr == null) {
            if (defaultPath == null) {
                return null;
            }
            pstr = defaultPath;
        }
        StringTokenizer tokenizer = new StringTokenizer(pstr, File.pathSeparator);
        path = new ArrayList<CharSequence>();
        while (tokenizer.hasMoreTokens()) {
            String str = tokenizer.nextToken().trim();
            if (str.length() <= 0) continue;
            path.add(str);
        }
        var.set(path);
        return path;
    }
}

