/*
 * Decompiled with CFR 0.139.
 */
package kawa.standard;

import gnu.expr.Compilation;
import gnu.expr.Declaration;
import gnu.expr.Expression;
import gnu.expr.ModuleContext;
import gnu.expr.ScopeExp;
import gnu.lists.EmptyList;
import gnu.lists.ImmutablePair;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Symbol;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import kawa.Version;
import kawa.lang.Syntax;
import kawa.lang.Translator;
import kawa.standard.ImportFromLibrary;

public class IfFeature
extends Syntax {
    public static final IfFeature condExpand = new IfFeature();
    private static List<String> coreFeatures;
    public static final String PROVIDE_PREFIX = "%provide%";
    public static final SimpleSymbol andSymbol;
    public static final SimpleSymbol elseSymbol;
    public static final SimpleSymbol librarySymbol;
    public static final SimpleSymbol notSymbol;
    public static final SimpleSymbol orSymbol;

    @Override
    public void scanForm(Pair st, ScopeExp defs2, Translator tr) {
        Object forms = this.evaluate(st.getCdr(), tr);
        tr.scanBody(forms, defs2, false);
    }

    @Override
    public Expression rewriteForm(Pair form, Translator tr) {
        Object forms = this.evaluate(form.getCdr(), tr);
        return tr.rewrite_body(forms);
    }

    public boolean evaluateConditionCar(Pair pair, Translator tr) {
        Object save = tr.pushPositionOf(pair);
        boolean r = this.evaluateCondition(pair.getCar(), tr);
        tr.popPositionOf(save);
        return r;
    }

    public boolean evaluateCondition(Object form, Translator tr) {
        if ((form = tr.namespaceResolve(Translator.stripSyntax(form))) instanceof String || form instanceof SimpleSymbol) {
            return IfFeature.hasFeature(form.toString());
        }
        if (form instanceof Pair) {
            Pair pair = (Pair)form;
            Object keyword = Translator.stripSyntax(pair.getCar());
            if (keyword == orSymbol || keyword == andSymbol) {
                Object rest = pair.getCdr();
                while (rest instanceof Pair) {
                    pair = (Pair)rest;
                    boolean val = this.evaluateConditionCar(pair, tr);
                    if (val == (keyword == orSymbol)) {
                        return val;
                    }
                    rest = pair.getCdr();
                }
                tr.errorIfNonEmpty(rest);
                return keyword == andSymbol;
            }
            if (keyword == notSymbol) {
                Pair pair2;
                Object rest = pair.getCdr();
                if (rest instanceof Pair && (pair2 = (Pair)rest).getCdr() == LList.Empty) {
                    return !this.evaluateConditionCar(pair2, tr);
                }
                tr.errorWithPosition("'not' must be followed by a single condition", pair);
                return false;
            }
            if (keyword == librarySymbol) {
                Pair pair2;
                Object rest = pair.getCdr();
                if (rest instanceof Pair && (pair2 = (Pair)rest).getCdr() == LList.Empty) {
                    return ImportFromLibrary.instance.libraryExists(pair2.getCar(), tr) != null;
                }
                tr.errorWithPosition("'library' must be followed by <library name>", pair);
                return false;
            }
        }
        tr.error('e', "unrecognized cond-expand expression");
        return false;
    }

    public Object evaluate(Object clauses, Translator tr) {
        while (clauses instanceof Pair) {
            Object test;
            Pair pclause;
            Pair pclauses = (Pair)clauses;
            Object clause = pclauses.getCar();
            clauses = pclauses.getCdr();
            if (!(clause instanceof Pair)) {
                tr.errorWithPosition("cond-expand clauses is not a list", pclauses);
            }
            if (((test = Translator.stripSyntax((pclause = (Pair)clause).getCar())) != elseSymbol || clauses != LList.Empty) && !this.evaluateConditionCar(pclause, tr)) continue;
            return pclause.getCdr();
        }
        tr.errorIfNonEmpty(clauses);
        return LList.Empty;
    }

    public static boolean hasFeature(String name) {
        String classExistsPrefix;
        int i = coreFeatures.size();
        while (--i >= 0) {
            if (name != coreFeatures.get(i)) continue;
            return true;
        }
        if (name == "in-http-server" || name == "in-servlet") {
            int mflags = ModuleContext.getContext().getFlags();
            if (name == "in-http-server") {
                return (mflags & ModuleContext.IN_HTTP_SERVER) != 0;
            }
            if (name == "in-servlet") {
                return (mflags & ModuleContext.IN_SERVLET) != 0 || Compilation.getCurrent().generatingServlet();
            }
        }
        if (name.startsWith(classExistsPrefix = "class-exists:")) {
            name = name.substring(classExistsPrefix.length());
            try {
                Class.forName(name, false, IfFeature.class.getClassLoader());
                return true;
            }
            catch (ClassNotFoundException ex) {
                return false;
            }
        }
        SimpleSymbol provide_symbol = Symbol.valueOf(PROVIDE_PREFIX + name);
        Declaration decl = Compilation.getCurrent().lookup(provide_symbol, -1);
        return decl != null && !decl.getFlag(65536L);
    }

    public static LList featureList() {
        LList result = LList.Empty;
        int i = coreFeatures.size();
        while (--i >= 0) {
            String item = coreFeatures.get(i);
            result = new ImmutablePair(Symbol.valueOf(item), result);
        }
        return result;
    }

    public static boolean isProvide(Declaration decl) {
        return decl.getName().startsWith(PROVIDE_PREFIX);
    }

    static {
        condExpand.setName("cond-expand");
        coreFeatures = new ArrayList<String>();
        coreFeatures.add("kawa");
        coreFeatures.add("kawa-" + Version.getVersion());
        coreFeatures.add("complex");
        coreFeatures.add("exact-complex");
        coreFeatures.add("exact-closed");
        coreFeatures.add("ieee-float");
        coreFeatures.add("ratios");
        coreFeatures.add("full-unicode");
        String javaVersion = System.getProperty("java.version");
        if (javaVersion != null && javaVersion.length() >= 1) {
            if (javaVersion.length() >= 3 && javaVersion.charAt(0) == '1' && javaVersion.charAt(1) == '.') {
                javaVersion = javaVersion.substring(2);
            }
            switch (javaVersion.charAt(0)) {
                case '9': {
                    coreFeatures.add("java-9");
                }
                case '8': {
                    coreFeatures.add("java-8");
                }
                case '7': {
                    coreFeatures.add("java-7");
                }
                case '6': {
                    coreFeatures.add("java-6");
                }
            }
        }
        if (ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN) {
            coreFeatures.add("big-endian");
        } else {
            coreFeatures.add("little-endian");
        }
        String osName = System.getProperty("os.name").toLowerCase(Locale.ENGLISH);
        if (osName.indexOf("linux") >= 0) {
            coreFeatures.add("posix");
            coreFeatures.add("unix");
            coreFeatures.add("linux");
            coreFeatures.add("gnu-linux");
        } else if (osName.indexOf("win") >= 0) {
            coreFeatures.add("windows");
        } else if (osName.indexOf("sunos") >= 0 || osName.indexOf("solaris") >= 0) {
            coreFeatures.add("posix");
            coreFeatures.add("unix");
            coreFeatures.add("solaris");
        } else if (osName.indexOf("mac") >= 0 || osName.indexOf("darwin") >= 0) {
            coreFeatures.add("posix");
            coreFeatures.add("unix");
            coreFeatures.add("darwin");
            coreFeatures.add("macosx");
        } else if (osName.indexOf("bsd") >= 0) {
            coreFeatures.add("bsd");
            coreFeatures.add("posix");
            coreFeatures.add("unix");
        } else if (osName.indexOf("nix") >= 0 || osName.indexOf("nux") >= 0 || osName.indexOf("aix") > 0) {
            coreFeatures.add("posix");
            coreFeatures.add("unix");
        }
        String archName = System.getProperty("os.arch").toLowerCase(Locale.ENGLISH);
        if (archName.indexOf("amd64") >= 0 || archName.indexOf("x86_64") >= 0) {
            coreFeatures.add("x86-64");
        } else if (archName.indexOf("x86") >= 0 || archName.indexOf("i386") >= 0) {
            coreFeatures.add("i386");
        } else if (archName.indexOf("ppc") >= 0 || archName.indexOf("powerpc") >= 0) {
            coreFeatures.add("ppc");
        } else if (archName.indexOf("sparc") >= 0) {
            coreFeatures.add("sparc");
        }
        coreFeatures.add("jvm");
        coreFeatures.add("r7rs");
        coreFeatures.add("srfi-0");
        coreFeatures.add("srfi-4");
        coreFeatures.add("srfi-6");
        coreFeatures.add("srfi-8");
        coreFeatures.add("srfi-9");
        coreFeatures.add("srfi-11");
        coreFeatures.add("srfi-16");
        coreFeatures.add("srfi-17");
        coreFeatures.add("srfi-23");
        coreFeatures.add("srfi-25");
        coreFeatures.add("srfi-26");
        coreFeatures.add("srfi-28");
        coreFeatures.add("srfi-30");
        coreFeatures.add("srfi-39");
        coreFeatures.add("threads");
        andSymbol = Symbol.valueOf("and");
        elseSymbol = Symbol.valueOf("else");
        librarySymbol = Symbol.valueOf("library");
        notSymbol = Symbol.valueOf("not");
        orSymbol = Symbol.valueOf("or");
    }
}

