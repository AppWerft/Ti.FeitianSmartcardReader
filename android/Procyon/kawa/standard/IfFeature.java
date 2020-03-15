// 
// Decompiled by Procyon v0.5.36
// 

package kawa.standard;

import java.util.Locale;
import java.nio.ByteOrder;
import kawa.Version;
import java.util.ArrayList;
import gnu.lists.ImmutablePair;
import gnu.expr.Declaration;
import gnu.mapping.Symbol;
import gnu.expr.Compilation;
import gnu.expr.ModuleContext;
import gnu.lists.LList;
import gnu.expr.Expression;
import kawa.lang.Translator;
import gnu.expr.ScopeExp;
import gnu.lists.Pair;
import gnu.mapping.SimpleSymbol;
import java.util.List;
import kawa.lang.Syntax;

public class IfFeature extends Syntax
{
    public static final IfFeature condExpand;
    private static List<String> coreFeatures;
    public static final String PROVIDE_PREFIX = "%provide%";
    public static final SimpleSymbol andSymbol;
    public static final SimpleSymbol elseSymbol;
    public static final SimpleSymbol librarySymbol;
    public static final SimpleSymbol notSymbol;
    public static final SimpleSymbol orSymbol;
    
    @Override
    public void scanForm(final Pair st, final ScopeExp defs, final Translator tr) {
        final Object forms = this.evaluate(st.getCdr(), tr);
        tr.scanBody(forms, defs, false);
    }
    
    @Override
    public Expression rewriteForm(final Pair form, final Translator tr) {
        final Object forms = this.evaluate(form.getCdr(), tr);
        return tr.rewrite_body(forms);
    }
    
    public boolean evaluateConditionCar(final Pair pair, final Translator tr) {
        final Object save = tr.pushPositionOf(pair);
        final boolean r = this.evaluateCondition(pair.getCar(), tr);
        tr.popPositionOf(save);
        return r;
    }
    
    public boolean evaluateCondition(Object form, final Translator tr) {
        form = tr.namespaceResolve(Translator.stripSyntax(form));
        if (form instanceof String || form instanceof SimpleSymbol) {
            return hasFeature(form.toString());
        }
        if (form instanceof Pair) {
            Pair pair = (Pair)form;
            final Object keyword = Translator.stripSyntax(pair.getCar());
            if (keyword == IfFeature.orSymbol || keyword == IfFeature.andSymbol) {
                Object rest;
                for (rest = pair.getCdr(); rest instanceof Pair; rest = pair.getCdr()) {
                    pair = (Pair)rest;
                    final boolean val = this.evaluateConditionCar(pair, tr);
                    if (val == (keyword == IfFeature.orSymbol)) {
                        return val;
                    }
                }
                tr.errorIfNonEmpty(rest);
                return keyword == IfFeature.andSymbol;
            }
            if (keyword == IfFeature.notSymbol) {
                final Object rest = pair.getCdr();
                if (rest instanceof Pair) {
                    final Pair pair2 = (Pair)rest;
                    if (pair2.getCdr() == LList.Empty) {
                        return !this.evaluateConditionCar(pair2, tr);
                    }
                }
                tr.errorWithPosition("'not' must be followed by a single condition", pair);
                return false;
            }
            if (keyword == IfFeature.librarySymbol) {
                final Object rest = pair.getCdr();
                if (rest instanceof Pair) {
                    final Pair pair2 = (Pair)rest;
                    if (pair2.getCdr() == LList.Empty) {
                        return ImportFromLibrary.instance.libraryExists(pair2.getCar(), tr) != null;
                    }
                }
                tr.errorWithPosition("'library' must be followed by <library name>", pair);
                return false;
            }
        }
        tr.error('e', "unrecognized cond-expand expression");
        return false;
    }
    
    public Object evaluate(Object clauses, final Translator tr) {
        while (clauses instanceof Pair) {
            final Pair pclauses = (Pair)clauses;
            final Object clause = pclauses.getCar();
            clauses = pclauses.getCdr();
            if (!(clause instanceof Pair)) {
                tr.errorWithPosition("cond-expand clauses is not a list", pclauses);
            }
            final Pair pclause = (Pair)clause;
            final Object test = Translator.stripSyntax(pclause.getCar());
            if ((test == IfFeature.elseSymbol && clauses == LList.Empty) || this.evaluateConditionCar(pclause, tr)) {
                return pclause.getCdr();
            }
        }
        tr.errorIfNonEmpty(clauses);
        return LList.Empty;
    }
    
    public static boolean hasFeature(String name) {
        int i = IfFeature.coreFeatures.size();
        while (--i >= 0) {
            if (name == IfFeature.coreFeatures.get(i)) {
                return true;
            }
        }
        if (name == "in-http-server" || name == "in-servlet") {
            final int mflags = ModuleContext.getContext().getFlags();
            if (name == "in-http-server") {
                return (mflags & ModuleContext.IN_HTTP_SERVER) != 0x0;
            }
            if (name == "in-servlet") {
                return (mflags & ModuleContext.IN_SERVLET) != 0x0 || Compilation.getCurrent().generatingServlet();
            }
        }
        final String classExistsPrefix = "class-exists:";
        if (name.startsWith(classExistsPrefix)) {
            name = name.substring(classExistsPrefix.length());
            try {
                Class.forName(name, false, IfFeature.class.getClassLoader());
                return true;
            }
            catch (ClassNotFoundException ex) {
                return false;
            }
        }
        final Symbol provide_symbol = Symbol.valueOf("%provide%" + name);
        final Declaration decl = Compilation.getCurrent().lookup(provide_symbol, -1);
        return decl != null && !decl.getFlag(65536L);
    }
    
    public static LList featureList() {
        LList result = LList.Empty;
        int i = IfFeature.coreFeatures.size();
        while (--i >= 0) {
            final String item = IfFeature.coreFeatures.get(i);
            result = new ImmutablePair(Symbol.valueOf(item), result);
        }
        return result;
    }
    
    public static boolean isProvide(final Declaration decl) {
        return decl.getName().startsWith("%provide%");
    }
    
    static {
        (condExpand = new IfFeature()).setName("cond-expand");
        (IfFeature.coreFeatures = new ArrayList<String>()).add("kawa");
        IfFeature.coreFeatures.add("kawa-" + Version.getVersion());
        IfFeature.coreFeatures.add("complex");
        IfFeature.coreFeatures.add("exact-complex");
        IfFeature.coreFeatures.add("exact-closed");
        IfFeature.coreFeatures.add("ieee-float");
        IfFeature.coreFeatures.add("ratios");
        IfFeature.coreFeatures.add("full-unicode");
        String javaVersion = System.getProperty("java.version");
        if (javaVersion != null && javaVersion.length() >= 1) {
            if (javaVersion.length() >= 3 && javaVersion.charAt(0) == '1' && javaVersion.charAt(1) == '.') {
                javaVersion = javaVersion.substring(2);
            }
            switch (javaVersion.charAt(0)) {
                case '9': {
                    IfFeature.coreFeatures.add("java-9");
                }
                case '8': {
                    IfFeature.coreFeatures.add("java-8");
                }
                case '7': {
                    IfFeature.coreFeatures.add("java-7");
                }
                case '6': {
                    IfFeature.coreFeatures.add("java-6");
                    break;
                }
            }
        }
        if (ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN) {
            IfFeature.coreFeatures.add("big-endian");
        }
        else {
            IfFeature.coreFeatures.add("little-endian");
        }
        final String osName = System.getProperty("os.name").toLowerCase(Locale.ENGLISH);
        if (osName.indexOf("linux") >= 0) {
            IfFeature.coreFeatures.add("posix");
            IfFeature.coreFeatures.add("unix");
            IfFeature.coreFeatures.add("linux");
            IfFeature.coreFeatures.add("gnu-linux");
        }
        else if (osName.indexOf("win") >= 0) {
            IfFeature.coreFeatures.add("windows");
        }
        else if (osName.indexOf("sunos") >= 0 || osName.indexOf("solaris") >= 0) {
            IfFeature.coreFeatures.add("posix");
            IfFeature.coreFeatures.add("unix");
            IfFeature.coreFeatures.add("solaris");
        }
        else if (osName.indexOf("mac") >= 0 || osName.indexOf("darwin") >= 0) {
            IfFeature.coreFeatures.add("posix");
            IfFeature.coreFeatures.add("unix");
            IfFeature.coreFeatures.add("darwin");
            IfFeature.coreFeatures.add("macosx");
        }
        else if (osName.indexOf("bsd") >= 0) {
            IfFeature.coreFeatures.add("bsd");
            IfFeature.coreFeatures.add("posix");
            IfFeature.coreFeatures.add("unix");
        }
        else if (osName.indexOf("nix") >= 0 || osName.indexOf("nux") >= 0 || osName.indexOf("aix") > 0) {
            IfFeature.coreFeatures.add("posix");
            IfFeature.coreFeatures.add("unix");
        }
        final String archName = System.getProperty("os.arch").toLowerCase(Locale.ENGLISH);
        if (archName.indexOf("amd64") >= 0 || archName.indexOf("x86_64") >= 0) {
            IfFeature.coreFeatures.add("x86-64");
        }
        else if (archName.indexOf("x86") >= 0 || archName.indexOf("i386") >= 0) {
            IfFeature.coreFeatures.add("i386");
        }
        else if (archName.indexOf("ppc") >= 0 || archName.indexOf("powerpc") >= 0) {
            IfFeature.coreFeatures.add("ppc");
        }
        else if (archName.indexOf("sparc") >= 0) {
            IfFeature.coreFeatures.add("sparc");
        }
        IfFeature.coreFeatures.add("jvm");
        IfFeature.coreFeatures.add("r7rs");
        IfFeature.coreFeatures.add("srfi-0");
        IfFeature.coreFeatures.add("srfi-4");
        IfFeature.coreFeatures.add("srfi-6");
        IfFeature.coreFeatures.add("srfi-8");
        IfFeature.coreFeatures.add("srfi-9");
        IfFeature.coreFeatures.add("srfi-11");
        IfFeature.coreFeatures.add("srfi-16");
        IfFeature.coreFeatures.add("srfi-17");
        IfFeature.coreFeatures.add("srfi-23");
        IfFeature.coreFeatures.add("srfi-25");
        IfFeature.coreFeatures.add("srfi-26");
        IfFeature.coreFeatures.add("srfi-28");
        IfFeature.coreFeatures.add("srfi-30");
        IfFeature.coreFeatures.add("srfi-39");
        IfFeature.coreFeatures.add("threads");
        andSymbol = Symbol.valueOf("and");
        elseSymbol = Symbol.valueOf("else");
        librarySymbol = Symbol.valueOf("library");
        notSymbol = Symbol.valueOf("not");
        orSymbol = Symbol.valueOf("or");
    }
}
