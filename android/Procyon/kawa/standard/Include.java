// 
// Decompiled by Procyon v0.5.36
// 

package kawa.standard;

import java.util.ArrayList;
import java.util.StringTokenizer;
import java.io.File;
import java.nio.charset.Charset;
import gnu.text.Lexer;
import java.io.InputStream;
import java.util.Iterator;
import gnu.lists.Sequence;
import gnu.kawa.io.InPort;
import gnu.kawa.lispexpr.LispReader;
import gnu.kawa.io.BinaryInPort;
import gnu.kawa.io.Path;
import gnu.lists.LList;
import gnu.expr.Expression;
import kawa.lang.Translator;
import gnu.expr.ScopeExp;
import gnu.lists.Pair;
import java.util.List;
import kawa.lang.Syntax;

public class Include extends Syntax
{
    boolean ignoreCase;
    boolean relative;
    public static final Include include;
    public static final Include includeRelative;
    public static final Include includeCi;
    public static final ThreadLocal<List<CharSequence>> searchPath;
    
    public Include(final String name, final boolean relative, final boolean ignoreCase) {
        super(name);
        this.relative = relative;
        this.ignoreCase = ignoreCase;
    }
    
    @Override
    public void scanForm(final Pair st, final ScopeExp defs, final Translator tr) {
        this.process(st.getCdr(), tr, defs, this.ignoreCase);
    }
    
    @Override
    public Expression rewrite(final Object obj, final Translator tr) {
        return tr.rewrite_body(this.process(obj, tr, null, this.ignoreCase));
    }
    
    public LList process(Object rest, final Translator tr, final ScopeExp defs, final boolean ignoreCase) {
        LList result = LList.Empty;
        Pair lastPair = null;
        if (tr.getState() == 1) {
            tr.setState(2);
        }
        while (rest instanceof Pair) {
            final Pair pair = (Pair)rest;
            final Object paircar = pair.getCar();
            final Object savePos1 = tr.pushPositionOf(pair);
            if (!(paircar instanceof CharSequence)) {
                tr.error('e', "include parameters must be strings");
            }
            final String fname = paircar.toString();
            final Iterator<CharSequence> searchIterator = getIncludeSearchPath().iterator();
            CharSequence searchElement = this.relative ? "|" : null;
            while (true) {
                if (searchElement == null) {
                    if (!searchIterator.hasNext()) {
                        tr.error('e', "cannot open file \"" + fname + "\"");
                        return result;
                    }
                    searchElement = searchIterator.next();
                }
                Path pathElement;
                if (searchElement.length() > 0 && searchElement.charAt(0) == '|') {
                    pathElement = tr.getMinfo().getSourceAbsPath();
                    if (pathElement == null || !pathElement.isPlainFile()) {
                        pathElement = Path.currentPath();
                    }
                    if (searchElement.length() > 1) {
                        pathElement = pathElement.resolve(searchElement.toString().substring(1));
                    }
                }
                else {
                    pathElement = Path.valueOf(searchElement);
                }
                Path path;
                BinaryInPort inp;
                try {
                    path = pathElement.resolve(fname);
                    final InputStream istrm = path.openInputStream();
                    try {
                        inp = BinaryInPort.openHeuristicFile(istrm, path);
                    }
                    catch (Exception ex) {
                        tr.error('e', "error reading file \"" + path + "\": " + ex.getMessage());
                        return result;
                    }
                }
                catch (Exception ex3) {
                    searchElement = null;
                    continue;
                }
                tr.popPositionOf(savePos1);
                final LispReader reader = new LispReader(inp, tr.getMessages());
                if (ignoreCase) {
                    reader.setReadCase('D');
                }
                final Lexer saveLexer = tr.lexer;
                tr.lexer = reader;
                try {
                    if (inp.getCharset() == null && saveLexer != null) {
                        final InPort savePort = saveLexer.getPort();
                        if (savePort instanceof BinaryInPort) {
                            final Charset saveCset = ((BinaryInPort)savePort).getCharset();
                            if (saveCset != null) {
                                inp.setDefaultCharset(saveCset);
                            }
                        }
                    }
                    while (true) {
                        Object sexp;
                        try {
                            sexp = reader.readCommand();
                            if (sexp == Sequence.eofValue) {
                                break;
                            }
                        }
                        catch (Exception ex2) {
                            tr.error('e', "error reading file \"" + path + "\": " + ex2.getMessage());
                            return result;
                        }
                        if (defs != null) {
                            tr.scanForm(sexp, defs);
                        }
                        else {
                            final Pair npair = new Pair(sexp, LList.Empty);
                            if (lastPair == null) {
                                result = npair;
                            }
                            else {
                                lastPair.setCdrBackdoor(npair);
                            }
                            lastPair = npair;
                        }
                    }
                }
                finally {
                    tr.lexer = saveLexer;
                }
                rest = pair.getCdr();
                break;
            }
        }
        if (rest != LList.Empty) {
            tr.error('e', "improper list");
        }
        return result;
    }
    
    public static List<CharSequence> getIncludeSearchPath() {
        return getSearchPath(Include.searchPath, "kawa.include.path", "|:.");
    }
    
    public static List<CharSequence> getSearchPath(final ThreadLocal<List<CharSequence>> var, final String propertyName, final String defaultPath) {
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
        final StringTokenizer tokenizer = new StringTokenizer(pstr, File.pathSeparator);
        path = new ArrayList<CharSequence>();
        while (tokenizer.hasMoreTokens()) {
            final String str = tokenizer.nextToken().trim();
            if (str.length() > 0) {
                path.add(str);
            }
        }
        var.set(path);
        return path;
    }
    
    static {
        include = new Include("include", false, false);
        includeRelative = new Include("include-relative", true, false);
        includeCi = new Include("include-ci", true, true);
        searchPath = new InheritableThreadLocal<List<CharSequence>>();
    }
}
