// 
// Decompiled by Procyon v0.5.36
// 

package kawa.standard;

import gnu.expr.ModuleInfo;
import java.util.ArrayList;
import gnu.kawa.io.Path;
import gnu.expr.ModuleManager;
import gnu.expr.Declaration;
import java.util.Iterator;
import gnu.expr.SetExp;
import java.util.Map;
import gnu.expr.Compilation;
import gnu.bytecode.ObjectType;
import gnu.expr.Expression;
import gnu.mapping.Symbol;
import java.util.LinkedHashMap;
import gnu.expr.Mangling;
import gnu.lists.LList;
import kawa.lang.Translator;
import gnu.expr.ScopeExp;
import gnu.lists.Pair;
import gnu.mapping.SimpleSymbol;
import java.util.List;
import kawa.lang.Syntax;

public class ImportFromLibrary extends Syntax
{
    public static final ImportFromLibrary instance;
    public static String[] classPrefixPath;
    private static final String BUILTIN = "<builtin>";
    private static final String MISSING;
    static final String[][] SRFI97Map;
    public static final ThreadLocal<List<CharSequence>> searchPath;
    public static final SimpleSymbol classSymbol;
    public static final SimpleSymbol exceptSymbol;
    public static final SimpleSymbol librarySymbol;
    public static final SimpleSymbol onlySymbol;
    public static final SimpleSymbol prefixSymbol;
    public static final SimpleSymbol renameSymbol;
    
    @Override
    public void scanForm(final Pair st, final ScopeExp defs, final Translator tr) {
        Object obj;
        Pair pair;
        for (obj = st.getCdr(); obj instanceof Pair; obj = pair.getCdr()) {
            pair = (Pair)obj;
            final Object save1 = tr.pushPositionOf(pair);
            this.scanImportSet(pair.getCar(), defs, tr, null);
            tr.popPositionOf(save1);
        }
        if (obj != LList.Empty) {
            tr.error('e', "improper list");
        }
    }
    
    public static String checkSrfi(final String lname, final Translator tr) {
        if (lname.startsWith("srfi.")) {
            final String demangled = Mangling.demangleSymbolic(lname.substring(5));
            int dot = demangled.indexOf(46);
            StringBuilder badNameBuffer = null;
            String srfiName;
            if (dot < 0) {
                srfiName = null;
                dot = demangled.length();
            }
            else {
                srfiName = demangled.substring(dot + 1);
            }
            String srfiNumber = null;
            Label_0121: {
                if (dot > 0) {
                    int i;
                    int numStart;
                    for (numStart = (i = ((demangled.charAt(0) == ':') ? 1 : 0)); i != dot; ++i) {
                        if (Character.digit(demangled.charAt(i), 10) < 0) {
                            break Label_0121;
                        }
                    }
                    srfiNumber = demangled.substring(numStart, dot);
                }
            }
            if (srfiNumber == null) {
                tr.error('e', "SRFI library reference must have the form: (srfi NNN [name]) or (srfi :NNN [name])");
                return lname;
            }
            int srfiIndex = ImportFromLibrary.SRFI97Map.length;
            while (--srfiIndex >= 0) {
                if (!ImportFromLibrary.SRFI97Map[srfiIndex][0].equals(srfiNumber)) {
                    continue;
                }
                final String srfiNameExpected = ImportFromLibrary.SRFI97Map[srfiIndex][1];
                final String srfiClass = ImportFromLibrary.SRFI97Map[srfiIndex][2];
                if (srfiName == null || srfiName.equals(srfiNameExpected)) {
                    return (srfiClass != ImportFromLibrary.MISSING) ? srfiClass : lname;
                }
                if (badNameBuffer == null) {
                    badNameBuffer = new StringBuilder("the name of SRFI ");
                    badNameBuffer.append(srfiNumber);
                    badNameBuffer.append(" should be '");
                }
                else {
                    badNameBuffer.append(" or '");
                }
                badNameBuffer.append(srfiNameExpected);
                badNameBuffer.append('\'');
            }
            if (badNameBuffer != null) {
                tr.error('e', badNameBuffer.toString());
                return "<builtin>";
            }
        }
        return lname;
    }
    
    void scanImportSet(final Object imports, final ScopeExp defs, final Translator tr, final require.DeclSetMapper mapper) {
        if (imports instanceof SimpleSymbol) {
            final String sname = imports.toString();
            handleImport(sname, null, Mangling.mangleQualifiedName(sname), defs, tr, mapper);
            return;
        }
        final int specLength = Translator.listLength(imports);
        if (specLength <= 0) {
            final Object save1 = tr.pushPositionOf(imports);
            tr.error('e', "import specifier is not a proper list");
            tr.popPositionOf(save1);
            return;
        }
        Pair pimport = (Pair)imports;
        final Object first = pimport.getCar();
        Object rest = pimport.getCdr();
        Pair cdrPair = (specLength >= 2) ? ((Pair)rest) : null;
        char kind = '\0';
        if (first == ImportFromLibrary.onlySymbol) {
            kind = 'O';
        }
        else if (first == ImportFromLibrary.exceptSymbol) {
            kind = 'E';
        }
        else if (first == ImportFromLibrary.renameSymbol) {
            kind = 'R';
        }
        else if (first == ImportFromLibrary.prefixSymbol) {
            kind = 'P';
        }
        else if (first == ImportFromLibrary.librarySymbol && specLength == 2 && cdrPair.getCar() instanceof Pair) {
            pimport = (Pair)cdrPair.getCar();
        }
        else if (first == ImportFromLibrary.classSymbol && specLength >= 2 && cdrPair.getCar() instanceof SimpleSymbol) {
            Map<Symbol, Expression> decls = new LinkedHashMap<Symbol, Expression>();
            final SimpleSymbol name1 = (SimpleSymbol)cdrPair.getCar();
            String prefix = name1.getName();
            if (prefix.length() > 0) {
                prefix += '.';
            }
            rest = cdrPair.getCdr();
            if (rest == LList.Empty) {
                tr.error('e', "class-prefix must be followed by class-names");
            }
            while (rest != LList.Empty) {
                cdrPair = (Pair)rest;
                final Object part2 = cdrPair.getCar();
                String cname = null;
                SimpleSymbol dname = null;
                if (part2 instanceof SimpleSymbol) {
                    dname = (SimpleSymbol)part2;
                    final String str2 = dname.getName();
                    cname = prefix + str2;
                }
                else if (part2 instanceof Pair && Translator.listLength(part2) == 2) {
                    final Pair rpair1 = (Pair)part2;
                    final Pair rpair2 = (Pair)rpair1.getCdr();
                    final Object rname1 = rpair1.getCar();
                    final Object rname2 = rpair2.getCar();
                    if (rname1 instanceof SimpleSymbol && rname2 instanceof SimpleSymbol) {
                        cname = prefix + ((SimpleSymbol)rname1).getName();
                        dname = (SimpleSymbol)rname2;
                    }
                }
                if (dname == null) {
                    tr.error('e', "imported class-name must be NAME or (NAME NEW-NAME)");
                }
                else {
                    try {
                        final Class clas = ObjectType.getContextClass(cname);
                        decls.put(dname, tr.makeQuoteExp(clas));
                    }
                    catch (ClassNotFoundException ex) {
                        final Object savePos = tr.pushPositionOf(cdrPair);
                        tr.error('e', "no class found named " + cname);
                        tr.popPositionOf(savePos);
                    }
                }
                rest = cdrPair.getCdr();
            }
            if (mapper != null) {
                decls = mapper.map(decls, tr);
            }
            for (final Map.Entry<Symbol, Expression> entry : decls.entrySet()) {
                final Symbol aname = entry.getKey();
                final Declaration decl = tr.define(aname, defs);
                decl.setAlias(true);
                decl.setFlag(536887296L);
                final SetExp sexp = new SetExp(decl, entry.getValue());
                tr.setLineOf(sexp);
                decl.noteValueFromSet(sexp);
                sexp.setDefining(true);
                tr.formStack.push(sexp);
            }
            return;
        }
        if (specLength >= 2 && kind != '\0') {
            final ImportSetMapper nmapper = new ImportSetMapper(kind, cdrPair.getCdr(), specLength - 2);
            nmapper.chain = mapper;
            this.scanImportSet(cdrPair.getCar(), defs, tr, nmapper);
            return;
        }
        String explicitSource = null;
        Object versionSpec = null;
        final StringBuilder cbuf = new StringBuilder();
        final StringBuilder sbuf = new StringBuilder();
        Object cdr;
        for (Object libref = pimport; libref instanceof Pair; libref = cdr) {
            final Pair pair = (Pair)libref;
            final Object car = pair.getCar();
            cdr = pair.getCdr();
            if (car instanceof Pair) {
                if (versionSpec != null) {
                    tr.error('e', "duplicate version reference - was " + versionSpec);
                }
                versionSpec = car;
            }
            else if (car instanceof String) {
                if (cdr instanceof Pair) {
                    tr.error('e', "source specifier must be last element in library reference");
                }
                explicitSource = (String)car;
            }
            else {
                if (cbuf.length() > 0) {
                    cbuf.append('.');
                }
                if (sbuf.length() > 0) {
                    sbuf.append('/');
                }
                final String part3 = car.toString();
                cbuf.append(Mangling.mangleClassName(part3));
                sbuf.append(part3);
            }
        }
        handleImport(sbuf.toString(), explicitSource, cbuf.toString(), defs, tr, mapper);
    }
    
    public static void handleImport(final String implicitSource, final String explicitSource, final String requestedClass, final ScopeExp defs, final Translator tr, final require.DeclSetMapper mapper) {
        final ModuleManager mmanager = ModuleManager.getInstance();
        ModuleInfo minfo = null;
        String lname = checkSrfi(requestedClass, tr);
        if (lname == "<builtin>") {
            return;
        }
        final boolean foundSrfi = lname != requestedClass;
        final int classPrefixPathLength = ImportFromLibrary.classPrefixPath.length;
        Class existingClass = null;
        for (int i = 0; i < classPrefixPathLength; ++i) {
            final String tname = ImportFromLibrary.classPrefixPath[i] + lname;
            minfo = mmanager.searchWithClassName(tname);
            if (minfo != null) {
                break;
            }
            try {
                existingClass = ObjectType.getContextClass(tname);
                break;
            }
            catch (Exception ex) {}
            catch (NoClassDefFoundError noClassDefFoundError) {}
        }
        final ModuleInfo curinfo = tr.getMinfo();
        final Path currentSource = curinfo.getSourceAbsPath();
        String currentExtension = (currentSource == null) ? null : currentSource.getExtension();
        if (currentExtension == null) {
            final List<String> langExtensions = tr.getLanguage().getExtensions();
            if (!langExtensions.isEmpty()) {
                currentExtension = langExtensions.get(0);
            }
        }
        boolean hasDot;
        boolean isAbsolute;
        if (explicitSource != null) {
            hasDot = (explicitSource.indexOf("./") >= 0);
            isAbsolute = Path.valueOf(explicitSource).isAbsolute();
        }
        else {
            hasDot = false;
            isAbsolute = false;
        }
        final String currentClassName = curinfo.getClassName();
        final boolean currentIsFile = currentSource != null && currentSource.isPlainFile();
        Path currentRoot = currentIsFile ? currentSource.getDirectory() : Path.currentPath();
        if (currentIsFile && (explicitSource == null || (!hasDot && !isAbsolute))) {
            int currentDots = 0;
            final String prefix = (currentClassName != null) ? currentClassName : ((tr.classPrefix != null) ? tr.classPrefix : "");
            int j = prefix.length();
            while (--j >= 0) {
                if (prefix.charAt(j) == '.') {
                    ++currentDots;
                }
            }
            if (currentDots > 0) {
                final StringBuilder ups = new StringBuilder("..");
                int k = currentDots;
                while (--k > 0) {
                    ups.append("/..");
                }
                currentRoot = currentRoot.resolve(ups.toString());
            }
        }
        final boolean skipSourceSearch = minfo != null && explicitSource == null;
        List<CharSequence> srcSearchPath;
        if (isAbsolute || hasDot || skipSourceSearch) {
            srcSearchPath = new ArrayList<CharSequence>();
            if (!skipSourceSearch) {
                srcSearchPath.add(currentRoot.toString());
            }
        }
        else {
            srcSearchPath = getImportSearchPath();
        }
        String pathStr = null;
        for (final CharSequence searchElement : srcSearchPath) {
            if (isAbsolute) {
                pathStr = explicitSource;
            }
            else {
                String pathElement = searchElement.toString();
                int prefixLength = 0;
                final StringBuilder pbuf = new StringBuilder();
                int selectorEnd;
                int star;
                if (pathElement.length() >= 3 && pathElement.charAt(0) == '<' && (selectorEnd = pathElement.indexOf(62) + 1) > 0) {
                    final StringBuilder prefixBuf = new StringBuilder();
                    boolean slashNeeded = false;
                    for (int l = 1; l < selectorEnd - 1; ++l) {
                        final char ch = pathElement.charAt(l);
                        if (ch == ' ') {
                            if (prefixBuf.length() > 0) {
                                slashNeeded = true;
                            }
                        }
                        else {
                            if (slashNeeded) {
                                prefixBuf.append('/');
                            }
                            prefixBuf.append(ch);
                            prefixLength += (slashNeeded ? 2 : 1);
                            slashNeeded = false;
                        }
                    }
                    if (!implicitSource.startsWith(prefixBuf.toString())) {
                        continue;
                    }
                    if (implicitSource.length() != prefixLength) {
                        if (implicitSource.charAt(prefixLength) != '/') {
                            continue;
                        }
                        ++prefixLength;
                    }
                    star = pathElement.indexOf(42, selectorEnd);
                    if (star < 0) {
                        pathElement = pathElement.substring(selectorEnd);
                    }
                }
                else {
                    star = pathElement.indexOf(42);
                    selectorEnd = 0;
                    if (foundSrfi && explicitSource == null) {
                        continue;
                    }
                }
                if (star >= 0) {
                    pbuf.append(pathElement.substring(selectorEnd, star));
                    pbuf.append(implicitSource.substring(prefixLength));
                    pbuf.append(pathElement.substring(star + 1));
                }
                else {
                    if (!".".equals(pathElement)) {
                        pbuf.append(pathElement);
                        pbuf.append('/');
                    }
                    if (explicitSource != null) {
                        pbuf.append(explicitSource);
                    }
                    else {
                        pbuf.append(implicitSource);
                        if (currentExtension != null) {
                            pbuf.append('.');
                            pbuf.append(currentExtension);
                        }
                    }
                }
                pathStr = pbuf.toString();
            }
            final Path path = currentRoot.resolve(pathStr).getCanonical();
            final long lastModifiedTime = path.getLastModified();
            if (lastModifiedTime != 0L) {
                if (minfo != null) {
                    final String pstring = path.toString();
                    final Path infoPath = minfo.getSourceAbsPath();
                    if (infoPath == null || !pstring.equals(infoPath.toString())) {
                        tr.error('w', "ignoring source file at " + pstring + " - instead using class " + minfo.getClassName() + ((infoPath == null) ? "" : (" from " + infoPath.toString())));
                    }
                }
                else {
                    minfo = mmanager.findWithSourcePath(path, pathStr);
                }
                if (foundSrfi) {
                    lname = requestedClass;
                    break;
                }
                break;
            }
        }
        if (existingClass != null) {
            if (minfo == null) {
                minfo = ModuleManager.findWithClass(existingClass);
            }
            else {
                minfo.setModuleClass(existingClass);
            }
        }
        if (minfo == null) {
            tr.error('e', "unknown library (" + implicitSource.replace('/', ' ') + ")");
        }
        else {
            require.importDefinitions(lname, minfo, mapper, tr.formStack, defs, tr);
        }
    }
    
    @Override
    public Expression rewriteForm(final Pair form, final Translator tr) {
        return tr.syntaxError(this.getName() + " is only allowed in a <body>");
    }
    
    public String libraryExists(final Object list, final Translator tr) {
        String lname = module_name.listToModuleName(list, tr);
        lname = checkSrfi(lname, tr);
        if (lname == "<builtin>") {
            return lname;
        }
        final int classPrefixPathLength = ImportFromLibrary.classPrefixPath.length;
        int i = 0;
        while (i < classPrefixPathLength) {
            final String className = ImportFromLibrary.classPrefixPath[i] + lname;
            try {
                ObjectType.getContextClass(className);
                return className;
            }
            catch (Exception ex) {
                ++i;
                continue;
            }
            break;
        }
        return null;
    }
    
    public static List<CharSequence> getImportSearchPath() {
        return Include.getSearchPath(ImportFromLibrary.searchPath, "kawa.import.path", ".");
    }
    
    static {
        instance = new ImportFromLibrary();
        ImportFromLibrary.classPrefixPath = new String[] { "", "kawa.lib." };
        MISSING = null;
        SRFI97Map = new String[][] { { "1", "lists", "gnu.kawa.slib.srfi1" }, { "2", "and-let*", "gnu.kawa.slib.srfi2" }, { "5", "let", ImportFromLibrary.MISSING }, { "6", "basic-string-ports", "<builtin>" }, { "8", "receive", "gnu.kawa.slib.receive" }, { "9", "records", "<builtin>" }, { "11", "let-values", "<builtin>" }, { "13", "strings", "gnu.kawa.slib.srfi13" }, { "14", "char-sets", "gnu.kawa.slib.srfi14" }, { "16", "case-lambda", "<builtin>" }, { "17", "generalized-set!", "<builtin>" }, { "18", "multithreading", ImportFromLibrary.MISSING }, { "19", "time", ImportFromLibrary.MISSING }, { "21", "real-time-multithreading", ImportFromLibrary.MISSING }, { "23", "error", "<builtin>" }, { "25", "multi-dimensional-arrays", "<builtin>" }, { "26", "cut", "gnu.kawa.slib.cut" }, { "27", "random-bits", ImportFromLibrary.MISSING }, { "28", "basic-format-strings", "<builtin>" }, { "29", "localization", ImportFromLibrary.MISSING }, { "31", "rec", ImportFromLibrary.MISSING }, { "35", "conditions", "gnu.kawa.slib.conditions" }, { "37", "args-fold", "gnu.kawa.slib.srfi37" }, { "38", "with-shared-structure", ImportFromLibrary.MISSING }, { "39", "parameters", "<builtin>" }, { "41", "streams.primitive", "gnu.kawa.slib.StreamsPrimitive" }, { "41", "streams.derived", "gnu.kawa.slib.StreamsDerived" }, { "41", "streams", "gnu.kawa.slib.Streams" }, { "42", "eager-comprehensions", ImportFromLibrary.MISSING }, { "43", "vectors", ImportFromLibrary.MISSING }, { "44", "collections", ImportFromLibrary.MISSING }, { "45", "lazy", ImportFromLibrary.MISSING }, { "46", "syntax-rules", ImportFromLibrary.MISSING }, { "47", "arrays", ImportFromLibrary.MISSING }, { "48", "intermediate-format-strings", ImportFromLibrary.MISSING }, { "51", "rest-values", ImportFromLibrary.MISSING }, { "54", "cat", ImportFromLibrary.MISSING }, { "57", "records", ImportFromLibrary.MISSING }, { "59", "vicinities", ImportFromLibrary.MISSING }, { "60", "integer-bits", "gnu.kawa.slib.srfi60" }, { "61", "cond", ImportFromLibrary.MISSING }, { "63", "arrays", ImportFromLibrary.MISSING }, { "64", "testing", "gnu.kawa.slib.testing" }, { "66", "octet-vectors", ImportFromLibrary.MISSING }, { "67", "compare-procedures", ImportFromLibrary.MISSING }, { "69", "basic-hash-tables", "gnu.kawa.slib.srfi69" }, { "71", "let", ImportFromLibrary.MISSING }, { "74", "blobs", ImportFromLibrary.MISSING }, { "78", "lightweight-testing", ImportFromLibrary.MISSING }, { "86", "mu-and-nu", ImportFromLibrary.MISSING }, { "87", "case", "<builtin>" }, { "95", "sorting-and-merging", "kawa.lib.srfi95" }, { "98", "os-environment-variables", "<builtin>" }, { "101", "random-access-lists", "gnu.kawa.slib.ralists" } };
        searchPath = new InheritableThreadLocal<List<CharSequence>>();
        classSymbol = Symbol.valueOf("class");
        exceptSymbol = Symbol.valueOf("except");
        librarySymbol = Symbol.valueOf("library");
        onlySymbol = Symbol.valueOf("only");
        prefixSymbol = Symbol.valueOf("prefix");
        renameSymbol = Symbol.valueOf("rename");
    }
    
    static class ImportSetMapper implements require.DeclSetMapper
    {
        char kind;
        Object list;
        int listLength;
        require.DeclSetMapper chain;
        
        public ImportSetMapper(final char kind, final Object list, final int listLength) {
            this.kind = kind;
            this.list = list;
            this.listLength = listLength;
        }
        
        @Override
        public Map<Symbol, Expression> map(final Map<Symbol, Expression> decls, final Compilation comp) {
            final Translator tr = (Translator)comp;
            Object lst = this.list;
            Map<Symbol, Expression> nmap = decls;
            switch (this.kind) {
                case 'E':
                case 'O': {
                    if (this.kind == 'O') {
                        nmap = new LinkedHashMap<Symbol, Expression>();
                    }
                    while (lst instanceof Pair) {
                        final Pair pair = (Pair)lst;
                        final Object save1 = tr.pushPositionOf(pair);
                        Object name = Translator.stripSyntax(pair.getCar());
                        name = tr.namespaceResolve(name);
                        Symbol oldsym = null;
                        Symbol newsym = null;
                        if (name instanceof Symbol) {
                            oldsym = (newsym = (Symbol)name);
                        }
                        else if (this.kind == 'O' && name instanceof Pair && Translator.listLength(name) == 2) {
                            final Pair rpair1 = (Pair)name;
                            Object rname1 = rpair1.getCar();
                            Object rname2 = ((Pair)rpair1.getCdr()).getCar();
                            rname1 = tr.namespaceResolve(rname1);
                            rname2 = tr.namespaceResolve(rname2);
                            if (rname1 instanceof Symbol && rname2 instanceof Symbol) {
                                oldsym = (Symbol)rname1;
                                newsym = (Symbol)rname2;
                            }
                        }
                        if (oldsym == null) {
                            tr.error('e', "non-symbol in name list");
                        }
                        else {
                            final Expression old = decls.get(oldsym);
                            if (old == null) {
                                tr.error('e', "unknown symbol in import set: " + oldsym);
                            }
                            else if (this.kind == 'E') {
                                nmap.remove(oldsym);
                            }
                            else {
                                nmap.put(newsym, old);
                            }
                        }
                        tr.popPositionOf(save1);
                        lst = pair.getCdr();
                    }
                    break;
                }
                case 'R': {
                    final Symbol[] pendingSymbols = new Symbol[this.listLength];
                    final Expression[] pendingDecls = new Expression[this.listLength];
                    int npending = 0;
                    while (lst instanceof Pair) {
                        final Pair pair2 = (Pair)lst;
                        final Object save2 = tr.pushPositionOf(pair2);
                        final Object entry = pair2.getCar();
                        int entryLen = Translator.listLength(entry);
                        if (entryLen == 2) {
                            final Pair p1 = (Pair)entry;
                            final Object oldname = p1.getCar();
                            final Object newname = ((Pair)p1.getCdr()).getCar();
                            if (oldname instanceof Symbol && newname instanceof Symbol) {
                                final Symbol oldSymbol = (Symbol)oldname;
                                final Symbol newSymbol = (Symbol)newname;
                                final Expression oldValue = decls.remove(oldSymbol);
                                if (oldValue == null) {
                                    tr.error('e', "missing binding " + oldSymbol);
                                }
                                else {
                                    pendingSymbols[npending] = newSymbol;
                                    pendingDecls[npending] = oldValue;
                                    ++npending;
                                }
                            }
                            else {
                                entryLen = -1;
                            }
                        }
                        if (entryLen != 2) {
                            tr.error('e', "entry is not a pair of names");
                        }
                        tr.popPositionOf(save2);
                        lst = pair2.getCdr();
                    }
                    for (int i = 0; i < npending; ++i) {
                        final Symbol newSymbol2 = pendingSymbols[i];
                        final Expression decl = pendingDecls[i];
                        if (decls.put(newSymbol2, decl) != null) {
                            tr.error('e', "duplicate binding for " + newSymbol2);
                        }
                    }
                    break;
                }
                case 'P': {
                    nmap = new LinkedHashMap<Symbol, Expression>();
                    if (this.listLength != 1 || !(((Pair)this.list).getCar() instanceof SimpleSymbol)) {
                        tr.error('e', "bad syntax for prefix import specifier");
                        break;
                    }
                    final String prefix = ((SimpleSymbol)((Pair)this.list).getCar()).getName();
                    for (final Map.Entry<Symbol, Expression> entry2 : decls.entrySet()) {
                        final Symbol aname = entry2.getKey();
                        final Expression old2 = entry2.getValue();
                        final Symbol nname = Symbol.valueOf(prefix + aname);
                        nmap.put(nname, old2);
                    }
                    break;
                }
            }
            if (this.chain != null) {
                nmap = this.chain.map(nmap, tr);
            }
            return nmap;
        }
    }
}
