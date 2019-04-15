/*
 * Decompiled with CFR 0.139.
 */
package kawa.lib;

import gnu.expr.GenericProc;
import gnu.expr.KawaConvert;
import gnu.expr.Keyword;
import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.expr.SourceName;
import gnu.kawa.functions.IsEqual;
import gnu.kawa.functions.RunProcess;
import gnu.kawa.io.FilePath;
import gnu.kawa.io.Path;
import gnu.kawa.io.URIPath;
import gnu.kawa.reflect.StaticFieldLocation;
import gnu.lists.Blob;
import gnu.lists.Consumer;
import gnu.lists.EmptyList;
import gnu.lists.LList;
import gnu.lists.PairWithPosition;
import gnu.lists.U8Vector;
import gnu.mapping.CallContext;
import gnu.mapping.MethodProc;
import gnu.mapping.Namespace;
import gnu.mapping.Procedure;
import gnu.mapping.Promise;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Symbol;
import gnu.mapping.Values;
import gnu.mapping.WrongType;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import kawa.lang.Macro;
import kawa.lang.SyntaxForms;
import kawa.lang.SyntaxPattern;
import kawa.lang.SyntaxRule;
import kawa.lang.SyntaxRules;
import kawa.lang.TemplateScope;
import kawa.standard.Scheme;

public class files
extends ModuleBody {
    public static final StaticFieldLocation $Prvt$$string$;
    public static final ModuleMethod path$Qu;
    public static final ModuleMethod filepath$Qu;
    public static final ModuleMethod URI$Qu;
    public static final ModuleMethod absolute$Mnpath$Qu;
    public static final ModuleMethod path$Mnscheme;
    public static final ModuleMethod path$Mnauthority;
    public static final ModuleMethod path$Mnuser$Mninfo;
    public static final ModuleMethod path$Mnhost;
    public static final ModuleMethod path$Mnfile;
    public static final ModuleMethod path$Mndirectory;
    public static final ModuleMethod path$Mnparent;
    public static final ModuleMethod path$Mnlast;
    public static final ModuleMethod path$Mnextension;
    public static final ModuleMethod path$Mnport;
    public static final ModuleMethod path$Mnquery;
    public static final ModuleMethod path$Mnfragment;
    public static final GenericProc path$Mnbytes;
    public static final ModuleMethod path$Mndata$Mnsetter;
    public static final ModuleMethod path$Mndata$Mnappender;
    public static final GenericProc path$Mndata;
    public static final Macro path$Mndata$Mnsetter$Mncurried;
    public static final Macro path$Mndata$Mnappender$Mncurried;
    @SourceName(name="PD", uri="http://kawa.gnu.org/construct", prefix="$construct$")
    public static final Macro PD;
    @SourceName(name="set_PD", uri="http://kawa.gnu.org/construct", prefix="$construct$")
    public static final Macro set_PD;
    @SourceName(name="append_PD", uri="http://kawa.gnu.org/construct", prefix="$construct$")
    public static final Macro append_PD;
    public static final ModuleMethod file$Mnexists$Qu;
    public static final ModuleMethod file$Mndirectory$Qu;
    public static final ModuleMethod file$Mnreadable$Qu;
    public static final ModuleMethod file$Mnwritable$Qu;
    public static final ModuleMethod delete$Mnfile;
    public static final ModuleMethod rename$Mnfile;
    public static final ModuleMethod copy$Mnfile;
    public static final ModuleMethod create$Mndirectory;
    public static final ModuleMethod directory$Mnfiles;
    public static final ModuleMethod $Mn$Grpathname;
    public static final ModuleMethod $Pcfile$Mnseparator;
    public static final ModuleMethod system$Mntmpdir;
    public static final ModuleMethod resolve$Mnuri;
    public static final ModuleMethod make$Mntemporary$Mnfile;
    static final Keyword Lit0;
    static final ModuleMethod lambda$Fn1;
    public static files $instance;
    static final SimpleSymbol Lit1;
    static final SimpleSymbol Lit2;
    static final SimpleSymbol Lit3;
    static final SimpleSymbol Lit4;
    static final SimpleSymbol Lit5;
    static final SimpleSymbol Lit6;
    static final SimpleSymbol Lit7;
    static final SimpleSymbol Lit8;
    static final SimpleSymbol Lit9;
    static final SimpleSymbol Lit10;
    static final SimpleSymbol Lit11;
    static final SimpleSymbol Lit12;
    static final SimpleSymbol Lit13;
    static final SimpleSymbol Lit14;
    static final SimpleSymbol Lit15;
    static final SimpleSymbol Lit16;
    static final SimpleSymbol Lit17;
    static final SimpleSymbol Lit18;
    static final SimpleSymbol Lit19;
    static final SyntaxRules Lit20;
    static final SimpleSymbol Lit21;
    static final SyntaxRules Lit22;
    static final Symbol Lit23;
    static final SyntaxRules Lit24;
    static final Symbol Lit25;
    static final SyntaxRules Lit26;
    static final Symbol Lit27;
    static final SyntaxRules Lit28;
    static final SimpleSymbol Lit29;
    static final SimpleSymbol Lit30;
    static final SimpleSymbol Lit31;
    static final SimpleSymbol Lit32;
    static final SimpleSymbol Lit33;
    static final SimpleSymbol Lit34;
    static final SimpleSymbol Lit35;
    static final SimpleSymbol Lit36;
    static final SimpleSymbol Lit37;
    static final SimpleSymbol Lit38;
    static final SimpleSymbol Lit39;
    static final SimpleSymbol Lit40;
    static final SimpleSymbol Lit41;
    static final SimpleSymbol Lit42;
    static final Object[] Lit43;
    static final SimpleSymbol Lit44;
    static final SimpleSymbol Lit45;
    static final Namespace Lit46;
    static final PairWithPosition Lit47;
    static final SimpleSymbol Lit48;
    static final SimpleSymbol Lit49;
    static final SimpleSymbol Lit50;

    private static void $runBody$() {
        CallContext $ctx = CallContext.getInstance();
        Consumer $result = $ctx.consumer;
        path$Mnbytes.setProperty(Lit0, lambda$Fn1);
        path$Mndata.setProperty(Lit0, path$Mndata$Mnsetter);
    }

    public static boolean isPath(Object path) {
        return path instanceof Path;
    }

    public static boolean isFilepath(Object path) {
        return path instanceof FilePath;
    }

    public static boolean URI$Qu(Object path) {
        return path instanceof URIPath;
    }

    public static boolean isAbsolutePath(Path path) {
        return path.isAbsolute();
    }

    public static Object pathScheme(Path p) {
        String s = p.getScheme();
        return s == null ? Boolean.FALSE : s;
    }

    public static Object pathAuthority(Path p) {
        String s = p.getAuthority();
        return s == null ? Boolean.FALSE : s;
    }

    public static Object pathUserInfo(Path p) {
        String s = p.getUserInfo();
        return s == null ? Boolean.FALSE : s;
    }

    public static String pathHost(Path p) {
        return p.getHost();
    }

    public static Object pathFile(Path p) {
        String s = p.getPath();
        return s == null ? Boolean.FALSE : s;
    }

    public static Object pathDirectory(Path p) {
        Path s = p.getDirectory();
        return s == null ? Boolean.FALSE : s.toString();
    }

    public static Object pathParent(Path p) {
        Path s = p.getParent();
        return s == null ? Boolean.FALSE : s.toString();
    }

    public static Object pathLast(Path p) {
        String s = p.getLast();
        return s == null ? Boolean.FALSE : s;
    }

    public static Object pathExtension(Path p) {
        String s = p.getExtension();
        return s == null ? Boolean.FALSE : s;
    }

    public static int pathPort(Path p) {
        return p.getPort();
    }

    public static Object pathQuery(Path p) {
        String s = p.getQuery();
        return s == null ? Boolean.FALSE : s;
    }

    public static Object pathFragment(Path p) {
        String s = p.getFragment();
        return s == null ? Boolean.FALSE : s;
    }

    static void lambda1(Path p, U8Vector b) {
        OutputStream out = p.openOutputStream();
        try {
            b.writeTo(0, b.size(), out);
            Object var4_3 = null;
        }
        catch (Throwable throwable) {
            Object var4_4 = null;
            out.close();
            throw throwable;
        }
        out.close();
        {
        }
    }

    public static void pathDataSetter(Path p, Object newvalue) {
        void out;
        OutputStream outputStream = p.openOutputStream();
        InputStream in = RunProcess.getInputStreamFrom(newvalue);
        RunProcess.copyStream(in, (OutputStream)out, true);
    }

    public static void pathDataAppender(FilePath p, Object newvalue) {
        void out;
        OutputStream outputStream = p.openAppendStream();
        InputStream in = RunProcess.getInputStreamFrom(newvalue);
        RunProcess.copyStream(in, (OutputStream)out, true);
    }

    public static boolean isFileExists(Path file2) {
        return file2.exists();
    }

    public static boolean isFileDirectory(Path file2) {
        return file2.isDirectory();
    }

    public static boolean isFileReadable(FilePath file2) {
        return file2.toFile().canRead();
    }

    public static boolean isFileWritable(FilePath file2) {
        return file2.toFile().canWrite();
    }

    public static void deleteFile(FilePath file2) {
        file2.deleteFile();
    }

    public static boolean renameFile(FilePath oldname, FilePath newname) {
        return oldname.toFile().renameTo(newname.toFile());
    }

    public static void copyFile(Path from, Path to) {
        int n;
        void in;
        InputStream inputStream = from.openInputStream();
        OutputStream outputStream = to.openOutputStream();
        byte[] buf = new byte[8192];
        while ((n = in.read(buf)) >= 0) {
            void out;
            out.write(buf, 0, n);
        }
    }

    public static boolean createDirectory(FilePath dirname) {
        return dirname.toFile().mkdir();
    }

    public static Object directoryFiles(FilePath dir) {
        Object[] files2 = dir.toFile().list();
        return files2 == null ? Boolean.FALSE : LList.makeList(files2, 0);
    }

    public static Path $To$Pathname(Object filename) {
        return Path.valueOf(filename);
    }

    public static String $PcFileSeparator() {
        return System.getProperty("file.separator");
    }

    public static String systemTmpdir() {
        String sep;
        String name = System.getProperty("java.io.tmpdir");
        return name != null ? name : (KawaConvert.isTrue(((Procedure)Scheme.isEqual).apply2(sep = files.$PcFileSeparator(), "\\")) ? "C:\\temp" : "/tmp");
    }

    public static Path resolveUri(Path uri, Path base2) {
        return base2.resolve(uri);
    }

    public static FilePath makeTemporaryFile() {
        return files.makeTemporaryFile("kawa~d.tmp");
    }

    public static FilePath makeTemporaryFile(CharSequence format) {
        String fmt = format.toString();
        int tilde = fmt.indexOf(126);
        String prefix = tilde < 0 ? fmt : fmt.substring(0, tilde);
        String suffix = tilde < 0 ? ".tmp" : fmt.substring(2 + tilde);
        int sep = prefix.indexOf(File.separatorChar);
        File directory = null;
        if (sep >= 0) {
            directory = new File(prefix.substring(0, sep));
            prefix = prefix.substring(sep + 1);
        }
        return FilePath.makeFilePath(File.createTempFile(prefix, suffix, directory));
    }

    public static {
        Lit50 = Symbol.valueOf("void");
        Lit49 = Symbol.valueOf("::");
        Lit48 = Symbol.valueOf("lambda");
        Lit47 = PairWithPosition.make(Symbol.valueOf("newvalue"), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/files.scm", 372756);
        Lit46 = Namespace.valueOf("http://kawa.gnu.org/construct", "$construct$");
        Lit45 = Symbol.valueOf("$string$");
        Lit44 = Symbol.valueOf("%simple-construct-builder");
        Lit43 = new Object[0];
        Lit42 = Symbol.valueOf("make-temporary-file");
        Lit41 = Symbol.valueOf("resolve-uri");
        Lit40 = Symbol.valueOf("system-tmpdir");
        Lit39 = Symbol.valueOf("%file-separator");
        Lit38 = Symbol.valueOf("->pathname");
        Lit37 = Symbol.valueOf("directory-files");
        Lit36 = Symbol.valueOf("create-directory");
        Lit35 = Symbol.valueOf("copy-file");
        Lit34 = Symbol.valueOf("rename-file");
        Lit33 = Symbol.valueOf("delete-file");
        Lit32 = Symbol.valueOf("file-writable?");
        Lit31 = Symbol.valueOf("file-readable?");
        Lit30 = Symbol.valueOf("file-directory?");
        Lit29 = Symbol.valueOf("file-exists?");
        SyntaxRule[] arrsyntaxRule = new SyntaxRule[1];
        Object[] arrobject = new Object[3];
        arrobject[0] = new SyntaxForms.SimpleSyntaxForm(Lit44, TemplateScope.make("kawa.lib.syntax"));
        Lit21 = Symbol.valueOf("path-data-appender-curried");
        arrobject[1] = Lit21;
        arrobject[2] = Lit45;
        arrsyntaxRule[0] = new SyntaxRule(new SyntaxPattern("\f\u0018\u0003", Lit43, 1, "files.scm:95"), "\u0000", "\t\u0004\u0011\u0018\f\u0011\u0018\u0014\t\u0010\u0002", arrobject, 0);
        Lit27 = Symbol.make(Lit46, "append_PD");
        Lit28 = new SyntaxRules(Lit43, arrsyntaxRule, 1, Lit27);
        SyntaxRule[] arrsyntaxRule2 = new SyntaxRule[1];
        Object[] arrobject2 = new Object[3];
        arrobject2[0] = new SyntaxForms.SimpleSyntaxForm(Lit44, TemplateScope.make("kawa.lib.syntax"));
        Lit19 = Symbol.valueOf("path-data-setter-curried");
        arrobject2[1] = Lit19;
        arrobject2[2] = Lit45;
        arrsyntaxRule2[0] = new SyntaxRule(new SyntaxPattern("\f\u0018\u0003", Lit43, 1, "files.scm:94"), "\u0000", "\t\u0004\u0011\u0018\f\u0011\u0018\u0014\t\u0010\u0002", arrobject2, 0);
        Lit25 = Symbol.make(Lit46, "set_PD");
        Lit26 = new SyntaxRules(Lit43, arrsyntaxRule2, 1, Lit25);
        Lit23 = Symbol.make(Lit46, "PD");
        Lit24 = new SyntaxRules(Lit43, new SyntaxRule[]{new SyntaxRule(new SyntaxPattern("\f\u0018\u0003", Lit43, 1, "files.scm:93"), "\u0000", "\t\u0004\u0011\u0018\f\u0011\u0018\u0014\t\u0010\u0002", new Object[]{new SyntaxForms.SimpleSyntaxForm(Lit44, TemplateScope.make("kawa.lib.syntax")), Symbol.valueOf("path-data"), Lit45}, 0)}, 1, Lit23);
        SyntaxRule[] arrsyntaxRule3 = new SyntaxRule[1];
        Object[] arrobject3 = new Object[6];
        arrobject3[0] = Lit48;
        arrobject3[1] = Lit47;
        arrobject3[2] = Lit49;
        arrobject3[3] = Lit50;
        Lit18 = Symbol.valueOf("path-data-appender");
        arrobject3[4] = Lit18;
        arrobject3[5] = Lit47;
        arrsyntaxRule3[0] = new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\b", Lit43, 1, "files.scm:91"), "\u0001", "\u0011\u0018\u0004\u0011\u0018\f\u0011\u0018\u0014\u0011\u0018\u001c\b\u0011\u0018$\t\u0003\u0018,", arrobject3, 0);
        Lit22 = new SyntaxRules(Lit43, arrsyntaxRule3, 1, Lit21);
        SyntaxRule[] arrsyntaxRule4 = new SyntaxRule[1];
        Object[] arrobject4 = new Object[6];
        arrobject4[0] = Lit48;
        arrobject4[1] = Lit47;
        arrobject4[2] = Lit49;
        arrobject4[3] = Lit50;
        Lit17 = Symbol.valueOf("path-data-setter");
        arrobject4[4] = Lit17;
        arrobject4[5] = Lit47;
        arrsyntaxRule4[0] = new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\b", Lit43, 1, "files.scm:87"), "\u0001", "\u0011\u0018\u0004\u0011\u0018\f\u0011\u0018\u0014\u0011\u0018\u001c\b\u0011\u0018$\t\u0003\u0018,", arrobject4, 0);
        Lit20 = new SyntaxRules(Lit43, arrsyntaxRule4, 1, Lit19);
        Lit16 = Symbol.valueOf("path-fragment");
        Lit15 = Symbol.valueOf("path-query");
        Lit14 = Symbol.valueOf("path-port");
        Lit13 = Symbol.valueOf("path-extension");
        Lit12 = Symbol.valueOf("path-last");
        Lit11 = Symbol.valueOf("path-parent");
        Lit10 = Symbol.valueOf("path-directory");
        Lit9 = Symbol.valueOf("path-file");
        Lit8 = Symbol.valueOf("path-host");
        Lit7 = Symbol.valueOf("path-user-info");
        Lit6 = Symbol.valueOf("path-authority");
        Lit5 = Symbol.valueOf("path-scheme");
        Lit4 = Symbol.valueOf("absolute-path?");
        Lit3 = Symbol.valueOf("URI?");
        Lit2 = Symbol.valueOf("filepath?");
        Lit1 = Symbol.valueOf("path?");
        Lit0 = Keyword.make("setter");
        $instance = new files();
        $Prvt$$string$ = StaticFieldLocation.make("kawa.lib.syntax", "$string$");
        files files2 = $instance;
        path$Qu = new ModuleMethod(files2, 1, Lit1, 4097);
        filepath$Qu = new ModuleMethod(files2, 2, Lit2, 4097);
        URI$Qu = new ModuleMethod(files2, 3, Lit3, 4097);
        absolute$Mnpath$Qu = new ModuleMethod(files2, 4, Lit4, 4097);
        path$Mnscheme = new ModuleMethod(files2, 5, Lit5, 4097);
        path$Mnauthority = new ModuleMethod(files2, 6, Lit6, 4097);
        path$Mnuser$Mninfo = new ModuleMethod(files2, 7, Lit7, 4097);
        path$Mnhost = new ModuleMethod(files2, 8, Lit8, 4097);
        path$Mnfile = new ModuleMethod(files2, 9, Lit9, 4097);
        path$Mndirectory = new ModuleMethod(files2, 10, Lit10, 4097);
        path$Mnparent = new ModuleMethod(files2, 11, Lit11, 4097);
        path$Mnlast = new ModuleMethod(files2, 12, Lit12, 4097);
        path$Mnextension = new ModuleMethod(files2, 13, Lit13, 4097);
        path$Mnport = new ModuleMethod(files2, 14, Lit14, 4097);
        path$Mnquery = new ModuleMethod(files2, 15, Lit15, 4097);
        path$Mnfragment = new ModuleMethod(files2, 16, Lit16, 4097);
        GenericProc genericProc = new GenericProc("path-bytes");
        files $instance = files.$instance;
        ModuleMethod moduleMethod = new ModuleMethod($instance, 17, "path-bytes", 4097);
        moduleMethod.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/files.scm:67");
        genericProc.add(moduleMethod);
        path$Mnbytes = genericProc;
        ModuleMethod moduleMethod2 = new ModuleMethod(files2, 18, null, 8194);
        moduleMethod2.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/files.scm:62");
        lambda$Fn1 = moduleMethod2;
        path$Mndata$Mnsetter = new ModuleMethod(files2, 19, Lit17, 8194);
        path$Mndata$Mnappender = new ModuleMethod(files2, 20, Lit18, 8194);
        GenericProc genericProc2 = new GenericProc("path-data");
        $instance = files.$instance;
        ModuleMethod moduleMethod3 = new ModuleMethod($instance, 21, "path-data", 4097);
        moduleMethod3.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/files.scm:82");
        genericProc2.add(moduleMethod3);
        path$Mndata = genericProc2;
        path$Mndata$Mnsetter$Mncurried = Macro.make(Lit19, Lit20, "kawa.lib.files");
        path$Mndata$Mnappender$Mncurried = Macro.make(Lit21, Lit22, "kawa.lib.files");
        PD = Macro.make(Lit23, Lit24, "kawa.lib.files");
        set_PD = Macro.make(Lit25, Lit26, "kawa.lib.files");
        append_PD = Macro.make(Lit27, Lit28, "kawa.lib.files");
        file$Mnexists$Qu = new ModuleMethod(files2, 22, Lit29, 4097);
        file$Mndirectory$Qu = new ModuleMethod(files2, 23, Lit30, 4097);
        file$Mnreadable$Qu = new ModuleMethod(files2, 24, Lit31, 4097);
        file$Mnwritable$Qu = new ModuleMethod(files2, 25, Lit32, 4097);
        delete$Mnfile = new ModuleMethod(files2, 26, Lit33, 4097);
        rename$Mnfile = new ModuleMethod(files2, 27, Lit34, 8194);
        copy$Mnfile = new ModuleMethod(files2, 28, Lit35, 8194);
        create$Mndirectory = new ModuleMethod(files2, 29, Lit36, 4097);
        directory$Mnfiles = new ModuleMethod(files2, 30, Lit37, 4097);
        $Mn$Grpathname = new ModuleMethod(files2, 31, Lit38, 4097);
        $Pcfile$Mnseparator = new ModuleMethod(files2, 32, Lit39, 0);
        system$Mntmpdir = new ModuleMethod(files2, 33, Lit40, 0);
        resolve$Mnuri = new ModuleMethod(files2, 34, Lit41, 8194);
        make$Mntemporary$Mnfile = new ModuleMethod(files2, 35, Lit42, 4096);
        files.$runBody$();
    }

    public files() {
        ModuleInfo.register(this);
    }

    public static U8Vector pathBytes(Path p) {
        return new U8Vector(p.readAllBytes());
    }

    public static Blob pathData(Path p) {
        return new Blob(p.readAllBytes());
    }

    public int match0(ModuleMethod moduleMethod, CallContext callContext) {
        switch (moduleMethod.selector) {
            case 35: {
                callContext.proc = moduleMethod;
                callContext.pc = 0;
                return 0;
            }
            case 33: {
                callContext.proc = moduleMethod;
                callContext.pc = 0;
                return 0;
            }
            case 32: {
                callContext.proc = moduleMethod;
                callContext.pc = 0;
                return 0;
            }
        }
        return super.match0(moduleMethod, callContext);
    }

    public int match1(ModuleMethod moduleMethod, Object object2, CallContext callContext) {
        switch (moduleMethod.selector) {
            case 21: {
                Object object3 = Promise.force(object2, Path.class);
                if (Path.coerceToPathOrNull(object3) == null) {
                    return -786431;
                }
                callContext.value1 = object3;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 17: {
                Object object4 = Promise.force(object2, Path.class);
                if (Path.coerceToPathOrNull(object4) == null) {
                    return -786431;
                }
                callContext.value1 = object4;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 35: {
                Object object5 = Promise.force(object2, CharSequence.class);
                if (!(object5 instanceof CharSequence)) {
                    return -786431;
                }
                callContext.value1 = object5;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 31: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 30: {
                Object object6 = Promise.force(object2, FilePath.class);
                if (FilePath.coerceToFilePathOrNull(object6) == null) {
                    return -786431;
                }
                callContext.value1 = object6;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 29: {
                Object object7 = Promise.force(object2, FilePath.class);
                if (FilePath.coerceToFilePathOrNull(object7) == null) {
                    return -786431;
                }
                callContext.value1 = object7;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 26: {
                Object object8 = Promise.force(object2, FilePath.class);
                if (FilePath.coerceToFilePathOrNull(object8) == null) {
                    return -786431;
                }
                callContext.value1 = object8;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 25: {
                Object object9 = Promise.force(object2, FilePath.class);
                if (FilePath.coerceToFilePathOrNull(object9) == null) {
                    return -786431;
                }
                callContext.value1 = object9;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 24: {
                Object object10 = Promise.force(object2, FilePath.class);
                if (FilePath.coerceToFilePathOrNull(object10) == null) {
                    return -786431;
                }
                callContext.value1 = object10;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 23: {
                Object object11 = Promise.force(object2, Path.class);
                if (Path.coerceToPathOrNull(object11) == null) {
                    return -786431;
                }
                callContext.value1 = object11;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 22: {
                Object object12 = Promise.force(object2, Path.class);
                if (Path.coerceToPathOrNull(object12) == null) {
                    return -786431;
                }
                callContext.value1 = object12;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 16: {
                Object object13 = Promise.force(object2, Path.class);
                if (Path.coerceToPathOrNull(object13) == null) {
                    return -786431;
                }
                callContext.value1 = object13;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 15: {
                Object object14 = Promise.force(object2, Path.class);
                if (Path.coerceToPathOrNull(object14) == null) {
                    return -786431;
                }
                callContext.value1 = object14;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 14: {
                Object object15 = Promise.force(object2, Path.class);
                if (Path.coerceToPathOrNull(object15) == null) {
                    return -786431;
                }
                callContext.value1 = object15;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 13: {
                Object object16 = Promise.force(object2, Path.class);
                if (Path.coerceToPathOrNull(object16) == null) {
                    return -786431;
                }
                callContext.value1 = object16;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 12: {
                Object object17 = Promise.force(object2, Path.class);
                if (Path.coerceToPathOrNull(object17) == null) {
                    return -786431;
                }
                callContext.value1 = object17;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 11: {
                Object object18 = Promise.force(object2, Path.class);
                if (Path.coerceToPathOrNull(object18) == null) {
                    return -786431;
                }
                callContext.value1 = object18;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 10: {
                Object object19 = Promise.force(object2, Path.class);
                if (Path.coerceToPathOrNull(object19) == null) {
                    return -786431;
                }
                callContext.value1 = object19;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 9: {
                Object object20 = Promise.force(object2, Path.class);
                if (Path.coerceToPathOrNull(object20) == null) {
                    return -786431;
                }
                callContext.value1 = object20;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 8: {
                Object object21 = Promise.force(object2, Path.class);
                if (Path.coerceToPathOrNull(object21) == null) {
                    return -786431;
                }
                callContext.value1 = object21;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 7: {
                Object object22 = Promise.force(object2, Path.class);
                if (Path.coerceToPathOrNull(object22) == null) {
                    return -786431;
                }
                callContext.value1 = object22;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 6: {
                Object object23 = Promise.force(object2, Path.class);
                if (Path.coerceToPathOrNull(object23) == null) {
                    return -786431;
                }
                callContext.value1 = object23;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 5: {
                Object object24 = Promise.force(object2, Path.class);
                if (Path.coerceToPathOrNull(object24) == null) {
                    return -786431;
                }
                callContext.value1 = object24;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 4: {
                Object object25 = Promise.force(object2, Path.class);
                if (Path.coerceToPathOrNull(object25) == null) {
                    return -786431;
                }
                callContext.value1 = object25;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 3: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 2: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 1: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
        }
        return super.match1(moduleMethod, object2, callContext);
    }

    public int match2(ModuleMethod moduleMethod, Object object2, Object object3, CallContext callContext) {
        switch (moduleMethod.selector) {
            case 34: {
                Object object4 = Promise.force(object2, Path.class);
                if (Path.coerceToPathOrNull(object4) == null) {
                    return -786431;
                }
                callContext.value1 = object4;
                Object object5 = Promise.force(object3, Path.class);
                if (Path.coerceToPathOrNull(object5) == null) {
                    return -786430;
                }
                callContext.value2 = object5;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 28: {
                Object object6 = Promise.force(object2, Path.class);
                if (Path.coerceToPathOrNull(object6) == null) {
                    return -786431;
                }
                callContext.value1 = object6;
                Object object7 = Promise.force(object3, Path.class);
                if (Path.coerceToPathOrNull(object7) == null) {
                    return -786430;
                }
                callContext.value2 = object7;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 27: {
                Object object8 = Promise.force(object2, FilePath.class);
                if (FilePath.coerceToFilePathOrNull(object8) == null) {
                    return -786431;
                }
                callContext.value1 = object8;
                Object object9 = Promise.force(object3, FilePath.class);
                if (FilePath.coerceToFilePathOrNull(object9) == null) {
                    return -786430;
                }
                callContext.value2 = object9;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 20: {
                Object object10 = Promise.force(object2, FilePath.class);
                if (FilePath.coerceToFilePathOrNull(object10) == null) {
                    return -786431;
                }
                callContext.value1 = object10;
                callContext.value2 = object3;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 19: {
                Object object11 = Promise.force(object2, Path.class);
                if (Path.coerceToPathOrNull(object11) == null) {
                    return -786431;
                }
                callContext.value1 = object11;
                callContext.value2 = object3;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 18: {
                Object object12 = Promise.force(object2, Path.class);
                if (Path.coerceToPathOrNull(object12) == null) {
                    return -786431;
                }
                callContext.value1 = object12;
                Object object13 = Promise.force(object3, U8Vector.class);
                if (!(object13 instanceof U8Vector)) {
                    return -786430;
                }
                callContext.value2 = object13;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
        }
        return super.match2(moduleMethod, object2, object3, callContext);
    }

    public void apply(CallContext callContext) {
        ModuleMethod.applyError();
    }

    public Object apply0(ModuleMethod moduleMethod) {
        switch (moduleMethod.selector) {
            case 32: {
                return files.$PcFileSeparator();
            }
            case 33: {
                return files.systemTmpdir();
            }
            case 35: {
                return files.makeTemporaryFile();
            }
        }
        return super.apply0(moduleMethod);
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public Object apply1(ModuleMethod moduleMethod, Object object2) {
        switch (moduleMethod.selector) {
            case 1: {
                Boolean bl;
                if (files.isPath(object2)) {
                    bl = Boolean.TRUE;
                    return bl;
                }
                bl = Boolean.FALSE;
                return bl;
            }
            case 2: {
                Boolean bl;
                if (files.isFilepath(object2)) {
                    bl = Boolean.TRUE;
                    return bl;
                }
                bl = Boolean.FALSE;
                return bl;
            }
            case 3: {
                Boolean bl;
                if (files.URI$Qu(object2)) {
                    bl = Boolean.TRUE;
                    return bl;
                }
                bl = Boolean.FALSE;
                return bl;
            }
            case 4: {
                Boolean bl;
                if (files.isAbsolutePath(Path.valueOf(Promise.force(object2, Path.class)))) {
                    bl = Boolean.TRUE;
                    return bl;
                }
                bl = Boolean.FALSE;
                return bl;
            }
            case 5: {
                return files.pathScheme(Path.valueOf(Promise.force(object2, Path.class)));
            }
            case 6: {
                return files.pathAuthority(Path.valueOf(Promise.force(object2, Path.class)));
            }
            case 7: {
                return files.pathUserInfo(Path.valueOf(Promise.force(object2, Path.class)));
            }
            case 8: {
                return files.pathHost(Path.valueOf(Promise.force(object2, Path.class)));
            }
            case 9: {
                return files.pathFile(Path.valueOf(Promise.force(object2, Path.class)));
            }
            case 10: {
                return files.pathDirectory(Path.valueOf(Promise.force(object2, Path.class)));
            }
            case 11: {
                return files.pathParent(Path.valueOf(Promise.force(object2, Path.class)));
            }
            case 12: {
                return files.pathLast(Path.valueOf(Promise.force(object2, Path.class)));
            }
            case 13: {
                return files.pathExtension(Path.valueOf(Promise.force(object2, Path.class)));
            }
            case 14: {
                return files.pathPort(Path.valueOf(Promise.force(object2, Path.class)));
            }
            case 15: {
                return files.pathQuery(Path.valueOf(Promise.force(object2, Path.class)));
            }
            case 16: {
                return files.pathFragment(Path.valueOf(Promise.force(object2, Path.class)));
            }
            case 22: {
                Boolean bl;
                if (files.isFileExists(Path.valueOf(Promise.force(object2, Path.class)))) {
                    bl = Boolean.TRUE;
                    return bl;
                }
                bl = Boolean.FALSE;
                return bl;
            }
            case 23: {
                Boolean bl;
                if (files.isFileDirectory(Path.valueOf(Promise.force(object2, Path.class)))) {
                    bl = Boolean.TRUE;
                    return bl;
                }
                bl = Boolean.FALSE;
                return bl;
            }
            case 24: {
                Boolean bl;
                if (files.isFileReadable(FilePath.makeFilePath(Promise.force(object2, FilePath.class)))) {
                    bl = Boolean.TRUE;
                    return bl;
                }
                bl = Boolean.FALSE;
                return bl;
            }
            case 25: {
                Boolean bl;
                if (files.isFileWritable(FilePath.makeFilePath(Promise.force(object2, FilePath.class)))) {
                    bl = Boolean.TRUE;
                    return bl;
                }
                bl = Boolean.FALSE;
                return bl;
            }
            case 26: {
                files.deleteFile(FilePath.makeFilePath(Promise.force(object2, FilePath.class)));
                return Values.empty;
            }
            case 29: {
                Boolean bl;
                if (files.createDirectory(FilePath.makeFilePath(Promise.force(object2, FilePath.class)))) {
                    bl = Boolean.TRUE;
                    return bl;
                }
                bl = Boolean.FALSE;
                return bl;
            }
            case 30: {
                return files.directoryFiles(FilePath.makeFilePath(Promise.force(object2, FilePath.class)));
            }
            case 31: {
                return files.$To$Pathname(object2);
            }
            case 35: {
                return files.makeTemporaryFile((CharSequence)Promise.force(object2, CharSequence.class));
            }
            case 17: {
                return files.pathBytes(Path.valueOf(Promise.force(object2, Path.class)));
            }
            case 21: {
                return files.pathData(Path.valueOf(Promise.force(object2, Path.class)));
            }
        }
        return super.apply1(moduleMethod, object2);
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "absolute-path?", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "path-scheme", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "path-authority", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "path-user-info", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "path-host", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "path-file", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "path-directory", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "path-parent", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "path-last", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "path-extension", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "path-port", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "path-query", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "path-fragment", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "file-exists?", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "file-directory?", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "file-readable?", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "file-writable?", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "delete-file", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "create-directory", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "directory-files", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "make-temporary-file", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "path-bytes", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "path-data", 1, object2);
        }
    }

    /*
     * Exception decompiling
     */
    public Object apply2(ModuleMethod var1_1, Object var2_2, Object var3_3) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Started 2 blocks at once
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.getStartingBlocks(Op04StructuredStatement.java:409)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:487)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:607)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:692)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:182)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:127)
        // org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.Method.analyse(Method.java:396)
        // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:890)
        // org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:792)
        // org.benf.cfr.reader.Driver.doJar(Driver.java:128)
        // org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:63)
        // org.benf.cfr.reader.Main.main(Main.java:48)
        throw new IllegalStateException("Decompilation failed");
    }
}

