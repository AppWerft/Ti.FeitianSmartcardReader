// 
// Decompiled by Procyon v0.5.36
// 

package kawa.lib;

import gnu.mapping.Promise;
import gnu.lists.Blob;
import gnu.expr.ModuleInfo;
import gnu.mapping.Procedure;
import gnu.mapping.MethodProc;
import kawa.lang.SyntaxForms;
import kawa.lang.TemplateScope;
import kawa.lang.SyntaxPattern;
import kawa.lang.SyntaxRule;
import java.io.File;
import gnu.expr.KawaConvert;
import kawa.standard.Scheme;
import gnu.lists.LList;
import java.io.OutputStream;
import gnu.lists.U8Vector;
import gnu.kawa.io.URIPath;
import gnu.kawa.io.FilePath;
import gnu.kawa.io.Path;
import gnu.lists.Consumer;
import gnu.mapping.CallContext;
import gnu.lists.PairWithPosition;
import gnu.mapping.Namespace;
import gnu.mapping.Symbol;
import kawa.lang.SyntaxRules;
import gnu.mapping.SimpleSymbol;
import gnu.expr.Keyword;
import gnu.expr.SourceName;
import kawa.lang.Macro;
import gnu.expr.GenericProc;
import gnu.expr.ModuleMethod;
import gnu.kawa.reflect.StaticFieldLocation;
import gnu.expr.ModuleBody;

public class files extends ModuleBody
{
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
    @SourceName(name = "PD", uri = "http://kawa.gnu.org/construct", prefix = "$construct$")
    public static final Macro PD;
    @SourceName(name = "set_PD", uri = "http://kawa.gnu.org/construct", prefix = "$construct$")
    public static final Macro set_PD;
    @SourceName(name = "append_PD", uri = "http://kawa.gnu.org/construct", prefix = "$construct$")
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
        final CallContext $ctx;
        final Consumer $result = ($ctx = CallContext.getInstance()).consumer;
        files.path$Mnbytes.setProperty(files.Lit0, files.lambda$Fn1);
        files.path$Mndata.setProperty(files.Lit0, files.path$Mndata$Mnsetter);
    }
    
    public static boolean isPath(final Object path) {
        return path instanceof Path;
    }
    
    public static boolean isFilepath(final Object path) {
        return path instanceof FilePath;
    }
    
    public static boolean URI$Qu(final Object path) {
        return path instanceof URIPath;
    }
    
    public static boolean isAbsolutePath(final Path path) {
        return path.isAbsolute();
    }
    
    public static Object pathScheme(final Path p) {
        final String s = p.getScheme();
        return (s == null) ? Boolean.FALSE : s;
    }
    
    public static Object pathAuthority(final Path p) {
        final String s = p.getAuthority();
        return (s == null) ? Boolean.FALSE : s;
    }
    
    public static Object pathUserInfo(final Path p) {
        final String s = p.getUserInfo();
        return (s == null) ? Boolean.FALSE : s;
    }
    
    public static String pathHost(final Path p) {
        return p.getHost();
    }
    
    public static Object pathFile(final Path p) {
        final String s = p.getPath();
        return (s == null) ? Boolean.FALSE : s;
    }
    
    public static Object pathDirectory(final Path p) {
        final Path s = p.getDirectory();
        return (s == null) ? Boolean.FALSE : s.toString();
    }
    
    public static Object pathParent(final Path p) {
        final Path s = p.getParent();
        return (s == null) ? Boolean.FALSE : s.toString();
    }
    
    public static Object pathLast(final Path p) {
        final String s = p.getLast();
        return (s == null) ? Boolean.FALSE : s;
    }
    
    public static Object pathExtension(final Path p) {
        final String s = p.getExtension();
        return (s == null) ? Boolean.FALSE : s;
    }
    
    public static int pathPort(final Path p) {
        return p.getPort();
    }
    
    public static Object pathQuery(final Path p) {
        final String s = p.getQuery();
        return (s == null) ? Boolean.FALSE : s;
    }
    
    public static Object pathFragment(final Path p) {
        final String s = p.getFragment();
        return (s == null) ? Boolean.FALSE : s;
    }
    
    static void lambda1(final Path p, final U8Vector b) {
        final OutputStream out = p.openOutputStream();
        try {
            b.writeTo(0, b.size(), out);
        }
        finally {
            out.close();
        }
    }
    
    public static void pathDataSetter(final Path p, final Object newvalue) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokevirtual   gnu/kawa/io/Path.openOutputStream:()Ljava/io/OutputStream;
        //     4: astore_2       
        //     5: aload_1         /* newvalue */
        //     6: invokestatic    gnu/kawa/functions/RunProcess.getInputStreamFrom:(Ljava/lang/Object;)Ljava/io/InputStream;
        //     9: astore_3        /* in */
        //    10: aload_3         /* in */
        //    11: aload_2         /* out */
        //    12: iconst_1       
        //    13: invokestatic    gnu/kawa/functions/RunProcess.copyStream:(Ljava/io/InputStream;Ljava/io/OutputStream;Z)V
        //    16: return         
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public static void pathDataAppender(final FilePath p, final Object newvalue) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokevirtual   gnu/kawa/io/FilePath.openAppendStream:()Ljava/io/OutputStream;
        //     4: astore_2       
        //     5: aload_1         /* newvalue */
        //     6: invokestatic    gnu/kawa/functions/RunProcess.getInputStreamFrom:(Ljava/lang/Object;)Ljava/io/InputStream;
        //     9: astore_3        /* in */
        //    10: aload_3         /* in */
        //    11: aload_2         /* out */
        //    12: iconst_1       
        //    13: invokestatic    gnu/kawa/functions/RunProcess.copyStream:(Ljava/io/InputStream;Ljava/io/OutputStream;Z)V
        //    16: return         
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public static boolean isFileExists(final Path file) {
        return file.exists();
    }
    
    public static boolean isFileDirectory(final Path file) {
        return file.isDirectory();
    }
    
    public static boolean isFileReadable(final FilePath file) {
        return file.toFile().canRead();
    }
    
    public static boolean isFileWritable(final FilePath file) {
        return file.toFile().canWrite();
    }
    
    public static void deleteFile(final FilePath file) {
        file.deleteFile();
    }
    
    public static boolean renameFile(final FilePath oldname, final FilePath newname) {
        return oldname.toFile().renameTo(newname.toFile());
    }
    
    public static void copyFile(final Path from, final Path to) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokevirtual   gnu/kawa/io/Path.openInputStream:()Ljava/io/InputStream;
        //     4: astore_2       
        //     5: aload_1         /* to */
        //     6: invokevirtual   gnu/kawa/io/Path.openOutputStream:()Ljava/io/OutputStream;
        //     9: astore_3       
        //    10: sipush          8192
        //    13: newarray        B
        //    15: astore          buf
        //    17: aload_2         /* in */
        //    18: aload           buf
        //    20: invokevirtual   java/io/InputStream.read:([B)I
        //    23: istore          n
        //    25: iload           n
        //    27: iflt            42
        //    30: aload_3         /* out */
        //    31: aload           buf
        //    33: iconst_0       
        //    34: iload           n
        //    36: invokevirtual   java/io/OutputStream.write:([BII)V
        //    39: goto            17
        //    42: return         
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public static boolean createDirectory(final FilePath dirname) {
        return dirname.toFile().mkdir();
    }
    
    public static Object directoryFiles(final FilePath dir) {
        final String[] files = dir.toFile().list();
        return (files == null) ? Boolean.FALSE : LList.makeList(files, 0);
    }
    
    public static Path $To$Pathname(final Object filename) {
        return Path.valueOf(filename);
    }
    
    public static String $PcFileSeparator() {
        return System.getProperty("file.separator");
    }
    
    public static String systemTmpdir() {
        final String name = System.getProperty("java.io.tmpdir");
        String s;
        if (name != null) {
            s = name;
        }
        else {
            final String sep = $PcFileSeparator();
            s = (KawaConvert.isTrue(Scheme.isEqual.apply2(sep, "\\")) ? "C:\\temp" : "/tmp");
        }
        return s;
    }
    
    public static Path resolveUri(final Path uri, final Path base) {
        return base.resolve(uri);
    }
    
    public static FilePath makeTemporaryFile() {
        return makeTemporaryFile("kawa~d.tmp");
    }
    
    public static FilePath makeTemporaryFile(final CharSequence format) {
        final String fmt = format.toString();
        final int tilde = fmt.indexOf(126);
        String prefix = (tilde < 0) ? fmt : fmt.substring(0, tilde);
        final String suffix = (tilde < 0) ? ".tmp" : fmt.substring(2 + tilde);
        final int sep = prefix.indexOf(File.separatorChar);
        File directory = null;
        if (sep >= 0) {
            directory = new File(prefix.substring(0, sep));
            prefix = prefix.substring(sep + 1);
        }
        return FilePath.makeFilePath(File.createTempFile(prefix, suffix, directory));
    }
    
    static {
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
        Lit28 = new SyntaxRules(files.Lit43, new SyntaxRule[] { new SyntaxRule(new SyntaxPattern("\f\u0018\u0003", files.Lit43, 1, "files.scm:95"), "\u0000", "\t\u0004\u0011\u0018\f\u0011\u0018\u0014\t\u0010\u0002", new Object[] { new SyntaxForms.SimpleSyntaxForm(files.Lit44, TemplateScope.make("kawa.lib.syntax")), Lit21 = Symbol.valueOf("path-data-appender-curried"), files.Lit45 }, 0) }, 1, Lit27 = Symbol.make(files.Lit46, "append_PD"));
        Lit26 = new SyntaxRules(files.Lit43, new SyntaxRule[] { new SyntaxRule(new SyntaxPattern("\f\u0018\u0003", files.Lit43, 1, "files.scm:94"), "\u0000", "\t\u0004\u0011\u0018\f\u0011\u0018\u0014\t\u0010\u0002", new Object[] { new SyntaxForms.SimpleSyntaxForm(files.Lit44, TemplateScope.make("kawa.lib.syntax")), Lit19 = Symbol.valueOf("path-data-setter-curried"), files.Lit45 }, 0) }, 1, Lit25 = Symbol.make(files.Lit46, "set_PD"));
        Lit24 = new SyntaxRules(files.Lit43, new SyntaxRule[] { new SyntaxRule(new SyntaxPattern("\f\u0018\u0003", files.Lit43, 1, "files.scm:93"), "\u0000", "\t\u0004\u0011\u0018\f\u0011\u0018\u0014\t\u0010\u0002", new Object[] { new SyntaxForms.SimpleSyntaxForm(files.Lit44, TemplateScope.make("kawa.lib.syntax")), Symbol.valueOf("path-data"), files.Lit45 }, 0) }, 1, Lit23 = Symbol.make(files.Lit46, "PD"));
        Lit22 = new SyntaxRules(files.Lit43, new SyntaxRule[] { new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\b", files.Lit43, 1, "files.scm:91"), "\u0001", "\u0011\u0018\u0004\u0011\u0018\f\u0011\u0018\u0014\u0011\u0018\u001c\b\u0011\u0018$\t\u0003\u0018,", new Object[] { files.Lit48, files.Lit47, files.Lit49, files.Lit50, Lit18 = Symbol.valueOf("path-data-appender"), files.Lit47 }, 0) }, 1, files.Lit21);
        Lit20 = new SyntaxRules(files.Lit43, new SyntaxRule[] { new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\b", files.Lit43, 1, "files.scm:87"), "\u0001", "\u0011\u0018\u0004\u0011\u0018\f\u0011\u0018\u0014\u0011\u0018\u001c\b\u0011\u0018$\t\u0003\u0018,", new Object[] { files.Lit48, files.Lit47, files.Lit49, files.Lit50, Lit17 = Symbol.valueOf("path-data-setter"), files.Lit47 }, 0) }, 1, files.Lit19);
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
        files.$instance = new files();
        $Prvt$$string$ = StaticFieldLocation.make("kawa.lib.syntax", "$string$");
        final files $instance2 = files.$instance;
        path$Qu = new ModuleMethod($instance2, 1, files.Lit1, 4097);
        filepath$Qu = new ModuleMethod($instance2, 2, files.Lit2, 4097);
        URI$Qu = new ModuleMethod($instance2, 3, files.Lit3, 4097);
        absolute$Mnpath$Qu = new ModuleMethod($instance2, 4, files.Lit4, 4097);
        path$Mnscheme = new ModuleMethod($instance2, 5, files.Lit5, 4097);
        path$Mnauthority = new ModuleMethod($instance2, 6, files.Lit6, 4097);
        path$Mnuser$Mninfo = new ModuleMethod($instance2, 7, files.Lit7, 4097);
        path$Mnhost = new ModuleMethod($instance2, 8, files.Lit8, 4097);
        path$Mnfile = new ModuleMethod($instance2, 9, files.Lit9, 4097);
        path$Mndirectory = new ModuleMethod($instance2, 10, files.Lit10, 4097);
        path$Mnparent = new ModuleMethod($instance2, 11, files.Lit11, 4097);
        path$Mnlast = new ModuleMethod($instance2, 12, files.Lit12, 4097);
        path$Mnextension = new ModuleMethod($instance2, 13, files.Lit13, 4097);
        path$Mnport = new ModuleMethod($instance2, 14, files.Lit14, 4097);
        path$Mnquery = new ModuleMethod($instance2, 15, files.Lit15, 4097);
        path$Mnfragment = new ModuleMethod($instance2, 16, files.Lit16, 4097);
        final GenericProc path$Mnbytes2 = new GenericProc("path-bytes");
        files $instance = files.$instance;
        final ModuleMethod method = new ModuleMethod($instance, 17, "path-bytes", 4097);
        method.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/files.scm:67");
        path$Mnbytes2.add(method);
        path$Mnbytes = path$Mnbytes2;
        final ModuleMethod lambda$Fn2 = new ModuleMethod($instance2, 18, null, 8194);
        lambda$Fn2.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/files.scm:62");
        lambda$Fn1 = lambda$Fn2;
        path$Mndata$Mnsetter = new ModuleMethod($instance2, 19, files.Lit17, 8194);
        path$Mndata$Mnappender = new ModuleMethod($instance2, 20, files.Lit18, 8194);
        final GenericProc path$Mndata2 = new GenericProc("path-data");
        $instance = files.$instance;
        final ModuleMethod method2 = new ModuleMethod($instance, 21, "path-data", 4097);
        method2.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/files.scm:82");
        path$Mndata2.add(method2);
        path$Mndata = path$Mndata2;
        path$Mndata$Mnsetter$Mncurried = Macro.make(files.Lit19, files.Lit20, "kawa.lib.files");
        path$Mndata$Mnappender$Mncurried = Macro.make(files.Lit21, files.Lit22, "kawa.lib.files");
        PD = Macro.make(files.Lit23, files.Lit24, "kawa.lib.files");
        set_PD = Macro.make(files.Lit25, files.Lit26, "kawa.lib.files");
        append_PD = Macro.make(files.Lit27, files.Lit28, "kawa.lib.files");
        file$Mnexists$Qu = new ModuleMethod($instance2, 22, files.Lit29, 4097);
        file$Mndirectory$Qu = new ModuleMethod($instance2, 23, files.Lit30, 4097);
        file$Mnreadable$Qu = new ModuleMethod($instance2, 24, files.Lit31, 4097);
        file$Mnwritable$Qu = new ModuleMethod($instance2, 25, files.Lit32, 4097);
        delete$Mnfile = new ModuleMethod($instance2, 26, files.Lit33, 4097);
        rename$Mnfile = new ModuleMethod($instance2, 27, files.Lit34, 8194);
        copy$Mnfile = new ModuleMethod($instance2, 28, files.Lit35, 8194);
        create$Mndirectory = new ModuleMethod($instance2, 29, files.Lit36, 4097);
        directory$Mnfiles = new ModuleMethod($instance2, 30, files.Lit37, 4097);
        $Mn$Grpathname = new ModuleMethod($instance2, 31, files.Lit38, 4097);
        $Pcfile$Mnseparator = new ModuleMethod($instance2, 32, files.Lit39, 0);
        system$Mntmpdir = new ModuleMethod($instance2, 33, files.Lit40, 0);
        resolve$Mnuri = new ModuleMethod($instance2, 34, files.Lit41, 8194);
        make$Mntemporary$Mnfile = new ModuleMethod($instance2, 35, files.Lit42, 4096);
        $runBody$();
    }
    
    public files() {
        ModuleInfo.register(this);
    }
    
    public static U8Vector pathBytes(final Path p) {
        return new U8Vector(p.readAllBytes());
    }
    
    public static Blob pathData(final Path p) {
        return new Blob(p.readAllBytes());
    }
    
    @Override
    public int match0(final ModuleMethod moduleMethod, final CallContext ctx) {
        switch (moduleMethod.selector) {
            case 35: {
                ctx.proc = moduleMethod;
                return ctx.pc = 0;
            }
            case 33: {
                ctx.proc = moduleMethod;
                return ctx.pc = 0;
            }
            case 32: {
                ctx.proc = moduleMethod;
                return ctx.pc = 0;
            }
            default: {
                return super.match0(moduleMethod, ctx);
            }
        }
    }
    
    @Override
    public int match1(final ModuleMethod moduleMethod, final Object o, final CallContext ctx) {
        switch (moduleMethod.selector) {
            case 21: {
                final Object force = Promise.force(o, Path.class);
                if (Path.coerceToPathOrNull(force) != null) {
                    ctx.value1 = force;
                    ctx.proc = moduleMethod;
                    ctx.pc = 1;
                    return 0;
                }
                return -786431;
            }
            case 17: {
                final Object force2 = Promise.force(o, Path.class);
                if (Path.coerceToPathOrNull(force2) != null) {
                    ctx.value1 = force2;
                    ctx.proc = moduleMethod;
                    ctx.pc = 1;
                    return 0;
                }
                return -786431;
            }
            case 35: {
                final Object force3 = Promise.force(o, CharSequence.class);
                if (force3 instanceof CharSequence) {
                    ctx.value1 = force3;
                    ctx.proc = moduleMethod;
                    ctx.pc = 1;
                    return 0;
                }
                return -786431;
            }
            case 31: {
                ctx.value1 = o;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 30: {
                final Object force4 = Promise.force(o, FilePath.class);
                if (FilePath.coerceToFilePathOrNull(force4) != null) {
                    ctx.value1 = force4;
                    ctx.proc = moduleMethod;
                    ctx.pc = 1;
                    return 0;
                }
                return -786431;
            }
            case 29: {
                final Object force5 = Promise.force(o, FilePath.class);
                if (FilePath.coerceToFilePathOrNull(force5) != null) {
                    ctx.value1 = force5;
                    ctx.proc = moduleMethod;
                    ctx.pc = 1;
                    return 0;
                }
                return -786431;
            }
            case 26: {
                final Object force6 = Promise.force(o, FilePath.class);
                if (FilePath.coerceToFilePathOrNull(force6) != null) {
                    ctx.value1 = force6;
                    ctx.proc = moduleMethod;
                    ctx.pc = 1;
                    return 0;
                }
                return -786431;
            }
            case 25: {
                final Object force7 = Promise.force(o, FilePath.class);
                if (FilePath.coerceToFilePathOrNull(force7) != null) {
                    ctx.value1 = force7;
                    ctx.proc = moduleMethod;
                    ctx.pc = 1;
                    return 0;
                }
                return -786431;
            }
            case 24: {
                final Object force8 = Promise.force(o, FilePath.class);
                if (FilePath.coerceToFilePathOrNull(force8) != null) {
                    ctx.value1 = force8;
                    ctx.proc = moduleMethod;
                    ctx.pc = 1;
                    return 0;
                }
                return -786431;
            }
            case 23: {
                final Object force9 = Promise.force(o, Path.class);
                if (Path.coerceToPathOrNull(force9) != null) {
                    ctx.value1 = force9;
                    ctx.proc = moduleMethod;
                    ctx.pc = 1;
                    return 0;
                }
                return -786431;
            }
            case 22: {
                final Object force10 = Promise.force(o, Path.class);
                if (Path.coerceToPathOrNull(force10) != null) {
                    ctx.value1 = force10;
                    ctx.proc = moduleMethod;
                    ctx.pc = 1;
                    return 0;
                }
                return -786431;
            }
            case 16: {
                final Object force11 = Promise.force(o, Path.class);
                if (Path.coerceToPathOrNull(force11) != null) {
                    ctx.value1 = force11;
                    ctx.proc = moduleMethod;
                    ctx.pc = 1;
                    return 0;
                }
                return -786431;
            }
            case 15: {
                final Object force12 = Promise.force(o, Path.class);
                if (Path.coerceToPathOrNull(force12) != null) {
                    ctx.value1 = force12;
                    ctx.proc = moduleMethod;
                    ctx.pc = 1;
                    return 0;
                }
                return -786431;
            }
            case 14: {
                final Object force13 = Promise.force(o, Path.class);
                if (Path.coerceToPathOrNull(force13) != null) {
                    ctx.value1 = force13;
                    ctx.proc = moduleMethod;
                    ctx.pc = 1;
                    return 0;
                }
                return -786431;
            }
            case 13: {
                final Object force14 = Promise.force(o, Path.class);
                if (Path.coerceToPathOrNull(force14) != null) {
                    ctx.value1 = force14;
                    ctx.proc = moduleMethod;
                    ctx.pc = 1;
                    return 0;
                }
                return -786431;
            }
            case 12: {
                final Object force15 = Promise.force(o, Path.class);
                if (Path.coerceToPathOrNull(force15) != null) {
                    ctx.value1 = force15;
                    ctx.proc = moduleMethod;
                    ctx.pc = 1;
                    return 0;
                }
                return -786431;
            }
            case 11: {
                final Object force16 = Promise.force(o, Path.class);
                if (Path.coerceToPathOrNull(force16) != null) {
                    ctx.value1 = force16;
                    ctx.proc = moduleMethod;
                    ctx.pc = 1;
                    return 0;
                }
                return -786431;
            }
            case 10: {
                final Object force17 = Promise.force(o, Path.class);
                if (Path.coerceToPathOrNull(force17) != null) {
                    ctx.value1 = force17;
                    ctx.proc = moduleMethod;
                    ctx.pc = 1;
                    return 0;
                }
                return -786431;
            }
            case 9: {
                final Object force18 = Promise.force(o, Path.class);
                if (Path.coerceToPathOrNull(force18) != null) {
                    ctx.value1 = force18;
                    ctx.proc = moduleMethod;
                    ctx.pc = 1;
                    return 0;
                }
                return -786431;
            }
            case 8: {
                final Object force19 = Promise.force(o, Path.class);
                if (Path.coerceToPathOrNull(force19) != null) {
                    ctx.value1 = force19;
                    ctx.proc = moduleMethod;
                    ctx.pc = 1;
                    return 0;
                }
                return -786431;
            }
            case 7: {
                final Object force20 = Promise.force(o, Path.class);
                if (Path.coerceToPathOrNull(force20) != null) {
                    ctx.value1 = force20;
                    ctx.proc = moduleMethod;
                    ctx.pc = 1;
                    return 0;
                }
                return -786431;
            }
            case 6: {
                final Object force21 = Promise.force(o, Path.class);
                if (Path.coerceToPathOrNull(force21) != null) {
                    ctx.value1 = force21;
                    ctx.proc = moduleMethod;
                    ctx.pc = 1;
                    return 0;
                }
                return -786431;
            }
            case 5: {
                final Object force22 = Promise.force(o, Path.class);
                if (Path.coerceToPathOrNull(force22) != null) {
                    ctx.value1 = force22;
                    ctx.proc = moduleMethod;
                    ctx.pc = 1;
                    return 0;
                }
                return -786431;
            }
            case 4: {
                final Object force23 = Promise.force(o, Path.class);
                if (Path.coerceToPathOrNull(force23) != null) {
                    ctx.value1 = force23;
                    ctx.proc = moduleMethod;
                    ctx.pc = 1;
                    return 0;
                }
                return -786431;
            }
            case 3: {
                ctx.value1 = o;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 2: {
                ctx.value1 = o;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 1: {
                ctx.value1 = o;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            default: {
                return super.match1(moduleMethod, o, ctx);
            }
        }
    }
    
    @Override
    public int match2(final ModuleMethod proc, final Object arg1, final Object arg2, final CallContext ctx) {
        switch (proc.selector) {
            case 34: {
                final Object force = Promise.force(arg1, Path.class);
                if (Path.coerceToPathOrNull(force) == null) {
                    return -786431;
                }
                ctx.value1 = force;
                final Object force2 = Promise.force(arg2, Path.class);
                if (Path.coerceToPathOrNull(force2) != null) {
                    ctx.value2 = force2;
                    ctx.proc = proc;
                    ctx.pc = 2;
                    return 0;
                }
                return -786430;
            }
            case 28: {
                final Object force3 = Promise.force(arg1, Path.class);
                if (Path.coerceToPathOrNull(force3) == null) {
                    return -786431;
                }
                ctx.value1 = force3;
                final Object force4 = Promise.force(arg2, Path.class);
                if (Path.coerceToPathOrNull(force4) != null) {
                    ctx.value2 = force4;
                    ctx.proc = proc;
                    ctx.pc = 2;
                    return 0;
                }
                return -786430;
            }
            case 27: {
                final Object force5 = Promise.force(arg1, FilePath.class);
                if (FilePath.coerceToFilePathOrNull(force5) == null) {
                    return -786431;
                }
                ctx.value1 = force5;
                final Object force6 = Promise.force(arg2, FilePath.class);
                if (FilePath.coerceToFilePathOrNull(force6) != null) {
                    ctx.value2 = force6;
                    ctx.proc = proc;
                    ctx.pc = 2;
                    return 0;
                }
                return -786430;
            }
            case 20: {
                final Object force7 = Promise.force(arg1, FilePath.class);
                if (FilePath.coerceToFilePathOrNull(force7) != null) {
                    ctx.value1 = force7;
                    ctx.value2 = arg2;
                    ctx.proc = proc;
                    ctx.pc = 2;
                    return 0;
                }
                return -786431;
            }
            case 19: {
                final Object force8 = Promise.force(arg1, Path.class);
                if (Path.coerceToPathOrNull(force8) != null) {
                    ctx.value1 = force8;
                    ctx.value2 = arg2;
                    ctx.proc = proc;
                    ctx.pc = 2;
                    return 0;
                }
                return -786431;
            }
            case 18: {
                final Object force9 = Promise.force(arg1, Path.class);
                if (Path.coerceToPathOrNull(force9) == null) {
                    return -786431;
                }
                ctx.value1 = force9;
                final Object force10 = Promise.force(arg2, U8Vector.class);
                if (force10 instanceof U8Vector) {
                    ctx.value2 = force10;
                    ctx.proc = proc;
                    ctx.pc = 2;
                    return 0;
                }
                return -786430;
            }
            default: {
                return super.match2(proc, arg1, arg2, ctx);
            }
        }
    }
    
    @Override
    public void apply(final CallContext callContext) {
        final int pc = callContext.pc;
        ModuleMethod.applyError();
    }
    
    @Override
    public Object apply0(final ModuleMethod method) {
        switch (method.selector) {
            case 32: {
                return $PcFileSeparator();
            }
            case 33: {
                return systemTmpdir();
            }
            case 35: {
                return makeTemporaryFile();
            }
            default: {
                return super.apply0(method);
            }
        }
    }
    
    @Override
    public Object apply1(final ModuleMethod p0, final Object p1) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        gnu/expr/ModuleMethod.selector:I
        //     4: tableswitch {
        //                2: 160
        //                3: 177
        //                4: 194
        //                5: 211
        //                6: 236
        //                7: 249
        //                8: 262
        //                9: 275
        //               10: 288
        //               11: 301
        //               12: 314
        //               13: 327
        //               14: 340
        //               15: 353
        //               16: 369
        //               17: 382
        //               18: 567
        //               19: 593
        //               20: 593
        //               21: 593
        //               22: 580
        //               23: 395
        //               24: 420
        //               25: 445
        //               26: 470
        //               27: 495
        //               28: 593
        //               29: 593
        //               30: 511
        //               31: 536
        //               32: 549
        //               33: 593
        //               34: 593
        //               35: 593
        //               36: 554
        //          default: 593
        //        }
        //   160: aload_2        
        //   161: invokestatic    kawa/lib/files.isPath:(Ljava/lang/Object;)Z
        //   164: ifeq            173
        //   167: getstatic       java/lang/Boolean.TRUE:Ljava/lang/Boolean;
        //   170: goto            176
        //   173: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //   176: areturn        
        //   177: aload_2        
        //   178: invokestatic    kawa/lib/files.isFilepath:(Ljava/lang/Object;)Z
        //   181: ifeq            190
        //   184: getstatic       java/lang/Boolean.TRUE:Ljava/lang/Boolean;
        //   187: goto            193
        //   190: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //   193: areturn        
        //   194: aload_2        
        //   195: invokestatic    kawa/lib/files.URI$Qu:(Ljava/lang/Object;)Z
        //   198: ifeq            207
        //   201: getstatic       java/lang/Boolean.TRUE:Ljava/lang/Boolean;
        //   204: goto            210
        //   207: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //   210: areturn        
        //   211: aload_2        
        //   212: ldc             Lgnu/kawa/io/Path;.class
        //   214: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   217: invokestatic    gnu/kawa/io/Path.valueOf:(Ljava/lang/Object;)Lgnu/kawa/io/Path;
        //   220: invokestatic    kawa/lib/files.isAbsolutePath:(Lgnu/kawa/io/Path;)Z
        //   223: ifeq            232
        //   226: getstatic       java/lang/Boolean.TRUE:Ljava/lang/Boolean;
        //   229: goto            235
        //   232: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //   235: areturn        
        //   236: aload_2        
        //   237: ldc             Lgnu/kawa/io/Path;.class
        //   239: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   242: invokestatic    gnu/kawa/io/Path.valueOf:(Ljava/lang/Object;)Lgnu/kawa/io/Path;
        //   245: invokestatic    kawa/lib/files.pathScheme:(Lgnu/kawa/io/Path;)Ljava/lang/Object;
        //   248: areturn        
        //   249: aload_2        
        //   250: ldc             Lgnu/kawa/io/Path;.class
        //   252: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   255: invokestatic    gnu/kawa/io/Path.valueOf:(Ljava/lang/Object;)Lgnu/kawa/io/Path;
        //   258: invokestatic    kawa/lib/files.pathAuthority:(Lgnu/kawa/io/Path;)Ljava/lang/Object;
        //   261: areturn        
        //   262: aload_2        
        //   263: ldc             Lgnu/kawa/io/Path;.class
        //   265: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   268: invokestatic    gnu/kawa/io/Path.valueOf:(Ljava/lang/Object;)Lgnu/kawa/io/Path;
        //   271: invokestatic    kawa/lib/files.pathUserInfo:(Lgnu/kawa/io/Path;)Ljava/lang/Object;
        //   274: areturn        
        //   275: aload_2        
        //   276: ldc             Lgnu/kawa/io/Path;.class
        //   278: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   281: invokestatic    gnu/kawa/io/Path.valueOf:(Ljava/lang/Object;)Lgnu/kawa/io/Path;
        //   284: invokestatic    kawa/lib/files.pathHost:(Lgnu/kawa/io/Path;)Ljava/lang/String;
        //   287: areturn        
        //   288: aload_2        
        //   289: ldc             Lgnu/kawa/io/Path;.class
        //   291: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   294: invokestatic    gnu/kawa/io/Path.valueOf:(Ljava/lang/Object;)Lgnu/kawa/io/Path;
        //   297: invokestatic    kawa/lib/files.pathFile:(Lgnu/kawa/io/Path;)Ljava/lang/Object;
        //   300: areturn        
        //   301: aload_2        
        //   302: ldc             Lgnu/kawa/io/Path;.class
        //   304: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   307: invokestatic    gnu/kawa/io/Path.valueOf:(Ljava/lang/Object;)Lgnu/kawa/io/Path;
        //   310: invokestatic    kawa/lib/files.pathDirectory:(Lgnu/kawa/io/Path;)Ljava/lang/Object;
        //   313: areturn        
        //   314: aload_2        
        //   315: ldc             Lgnu/kawa/io/Path;.class
        //   317: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   320: invokestatic    gnu/kawa/io/Path.valueOf:(Ljava/lang/Object;)Lgnu/kawa/io/Path;
        //   323: invokestatic    kawa/lib/files.pathParent:(Lgnu/kawa/io/Path;)Ljava/lang/Object;
        //   326: areturn        
        //   327: aload_2        
        //   328: ldc             Lgnu/kawa/io/Path;.class
        //   330: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   333: invokestatic    gnu/kawa/io/Path.valueOf:(Ljava/lang/Object;)Lgnu/kawa/io/Path;
        //   336: invokestatic    kawa/lib/files.pathLast:(Lgnu/kawa/io/Path;)Ljava/lang/Object;
        //   339: areturn        
        //   340: aload_2        
        //   341: ldc             Lgnu/kawa/io/Path;.class
        //   343: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   346: invokestatic    gnu/kawa/io/Path.valueOf:(Ljava/lang/Object;)Lgnu/kawa/io/Path;
        //   349: invokestatic    kawa/lib/files.pathExtension:(Lgnu/kawa/io/Path;)Ljava/lang/Object;
        //   352: areturn        
        //   353: aload_2        
        //   354: ldc             Lgnu/kawa/io/Path;.class
        //   356: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   359: invokestatic    gnu/kawa/io/Path.valueOf:(Ljava/lang/Object;)Lgnu/kawa/io/Path;
        //   362: invokestatic    kawa/lib/files.pathPort:(Lgnu/kawa/io/Path;)I
        //   365: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //   368: areturn        
        //   369: aload_2        
        //   370: ldc             Lgnu/kawa/io/Path;.class
        //   372: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   375: invokestatic    gnu/kawa/io/Path.valueOf:(Ljava/lang/Object;)Lgnu/kawa/io/Path;
        //   378: invokestatic    kawa/lib/files.pathQuery:(Lgnu/kawa/io/Path;)Ljava/lang/Object;
        //   381: areturn        
        //   382: aload_2        
        //   383: ldc             Lgnu/kawa/io/Path;.class
        //   385: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   388: invokestatic    gnu/kawa/io/Path.valueOf:(Ljava/lang/Object;)Lgnu/kawa/io/Path;
        //   391: invokestatic    kawa/lib/files.pathFragment:(Lgnu/kawa/io/Path;)Ljava/lang/Object;
        //   394: areturn        
        //   395: aload_2        
        //   396: ldc             Lgnu/kawa/io/Path;.class
        //   398: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   401: invokestatic    gnu/kawa/io/Path.valueOf:(Ljava/lang/Object;)Lgnu/kawa/io/Path;
        //   404: invokestatic    kawa/lib/files.isFileExists:(Lgnu/kawa/io/Path;)Z
        //   407: ifeq            416
        //   410: getstatic       java/lang/Boolean.TRUE:Ljava/lang/Boolean;
        //   413: goto            419
        //   416: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //   419: areturn        
        //   420: aload_2        
        //   421: ldc             Lgnu/kawa/io/Path;.class
        //   423: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   426: invokestatic    gnu/kawa/io/Path.valueOf:(Ljava/lang/Object;)Lgnu/kawa/io/Path;
        //   429: invokestatic    kawa/lib/files.isFileDirectory:(Lgnu/kawa/io/Path;)Z
        //   432: ifeq            441
        //   435: getstatic       java/lang/Boolean.TRUE:Ljava/lang/Boolean;
        //   438: goto            444
        //   441: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //   444: areturn        
        //   445: aload_2        
        //   446: ldc             Lgnu/kawa/io/FilePath;.class
        //   448: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   451: invokestatic    gnu/kawa/io/FilePath.makeFilePath:(Ljava/lang/Object;)Lgnu/kawa/io/FilePath;
        //   454: invokestatic    kawa/lib/files.isFileReadable:(Lgnu/kawa/io/FilePath;)Z
        //   457: ifeq            466
        //   460: getstatic       java/lang/Boolean.TRUE:Ljava/lang/Boolean;
        //   463: goto            469
        //   466: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //   469: areturn        
        //   470: aload_2        
        //   471: ldc             Lgnu/kawa/io/FilePath;.class
        //   473: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   476: invokestatic    gnu/kawa/io/FilePath.makeFilePath:(Ljava/lang/Object;)Lgnu/kawa/io/FilePath;
        //   479: invokestatic    kawa/lib/files.isFileWritable:(Lgnu/kawa/io/FilePath;)Z
        //   482: ifeq            491
        //   485: getstatic       java/lang/Boolean.TRUE:Ljava/lang/Boolean;
        //   488: goto            494
        //   491: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //   494: areturn        
        //   495: aload_2        
        //   496: ldc             Lgnu/kawa/io/FilePath;.class
        //   498: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   501: invokestatic    gnu/kawa/io/FilePath.makeFilePath:(Ljava/lang/Object;)Lgnu/kawa/io/FilePath;
        //   504: invokestatic    kawa/lib/files.deleteFile:(Lgnu/kawa/io/FilePath;)V
        //   507: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //   510: areturn        
        //   511: aload_2        
        //   512: ldc             Lgnu/kawa/io/FilePath;.class
        //   514: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   517: invokestatic    gnu/kawa/io/FilePath.makeFilePath:(Ljava/lang/Object;)Lgnu/kawa/io/FilePath;
        //   520: invokestatic    kawa/lib/files.createDirectory:(Lgnu/kawa/io/FilePath;)Z
        //   523: ifeq            532
        //   526: getstatic       java/lang/Boolean.TRUE:Ljava/lang/Boolean;
        //   529: goto            535
        //   532: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //   535: areturn        
        //   536: aload_2        
        //   537: ldc             Lgnu/kawa/io/FilePath;.class
        //   539: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   542: invokestatic    gnu/kawa/io/FilePath.makeFilePath:(Ljava/lang/Object;)Lgnu/kawa/io/FilePath;
        //   545: invokestatic    kawa/lib/files.directoryFiles:(Lgnu/kawa/io/FilePath;)Ljava/lang/Object;
        //   548: areturn        
        //   549: aload_2        
        //   550: invokestatic    kawa/lib/files.$To$Pathname:(Ljava/lang/Object;)Lgnu/kawa/io/Path;
        //   553: areturn        
        //   554: aload_2        
        //   555: ldc             Ljava/lang/CharSequence;.class
        //   557: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   560: checkcast       Ljava/lang/CharSequence;
        //   563: invokestatic    kawa/lib/files.makeTemporaryFile:(Ljava/lang/CharSequence;)Lgnu/kawa/io/FilePath;
        //   566: areturn        
        //   567: aload_2        
        //   568: ldc             Lgnu/kawa/io/Path;.class
        //   570: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   573: invokestatic    gnu/kawa/io/Path.valueOf:(Ljava/lang/Object;)Lgnu/kawa/io/Path;
        //   576: invokestatic    kawa/lib/files.pathBytes:(Lgnu/kawa/io/Path;)Lgnu/lists/U8Vector;
        //   579: areturn        
        //   580: aload_2        
        //   581: ldc             Lgnu/kawa/io/Path;.class
        //   583: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   586: invokestatic    gnu/kawa/io/Path.valueOf:(Ljava/lang/Object;)Lgnu/kawa/io/Path;
        //   589: invokestatic    kawa/lib/files.pathData:(Lgnu/kawa/io/Path;)Lgnu/lists/Blob;
        //   592: areturn        
        //   593: aload_0        
        //   594: aload_1        
        //   595: aload_2        
        //   596: invokespecial   gnu/expr/ModuleBody.apply1:(Lgnu/expr/ModuleMethod;Ljava/lang/Object;)Ljava/lang/Object;
        //   599: areturn        
        //   600: new             Lgnu/mapping/WrongType;
        //   603: dup_x1         
        //   604: swap           
        //   605: ldc_w           "absolute-path?"
        //   608: iconst_1       
        //   609: aload_2        
        //   610: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   613: athrow         
        //   614: new             Lgnu/mapping/WrongType;
        //   617: dup_x1         
        //   618: swap           
        //   619: ldc_w           "path-scheme"
        //   622: iconst_1       
        //   623: aload_2        
        //   624: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   627: athrow         
        //   628: new             Lgnu/mapping/WrongType;
        //   631: dup_x1         
        //   632: swap           
        //   633: ldc_w           "path-authority"
        //   636: iconst_1       
        //   637: aload_2        
        //   638: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   641: athrow         
        //   642: new             Lgnu/mapping/WrongType;
        //   645: dup_x1         
        //   646: swap           
        //   647: ldc_w           "path-user-info"
        //   650: iconst_1       
        //   651: aload_2        
        //   652: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   655: athrow         
        //   656: new             Lgnu/mapping/WrongType;
        //   659: dup_x1         
        //   660: swap           
        //   661: ldc_w           "path-host"
        //   664: iconst_1       
        //   665: aload_2        
        //   666: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   669: athrow         
        //   670: new             Lgnu/mapping/WrongType;
        //   673: dup_x1         
        //   674: swap           
        //   675: ldc_w           "path-file"
        //   678: iconst_1       
        //   679: aload_2        
        //   680: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   683: athrow         
        //   684: new             Lgnu/mapping/WrongType;
        //   687: dup_x1         
        //   688: swap           
        //   689: ldc_w           "path-directory"
        //   692: iconst_1       
        //   693: aload_2        
        //   694: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   697: athrow         
        //   698: new             Lgnu/mapping/WrongType;
        //   701: dup_x1         
        //   702: swap           
        //   703: ldc_w           "path-parent"
        //   706: iconst_1       
        //   707: aload_2        
        //   708: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   711: athrow         
        //   712: new             Lgnu/mapping/WrongType;
        //   715: dup_x1         
        //   716: swap           
        //   717: ldc_w           "path-last"
        //   720: iconst_1       
        //   721: aload_2        
        //   722: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   725: athrow         
        //   726: new             Lgnu/mapping/WrongType;
        //   729: dup_x1         
        //   730: swap           
        //   731: ldc_w           "path-extension"
        //   734: iconst_1       
        //   735: aload_2        
        //   736: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   739: athrow         
        //   740: new             Lgnu/mapping/WrongType;
        //   743: dup_x1         
        //   744: swap           
        //   745: ldc_w           "path-port"
        //   748: iconst_1       
        //   749: aload_2        
        //   750: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   753: athrow         
        //   754: new             Lgnu/mapping/WrongType;
        //   757: dup_x1         
        //   758: swap           
        //   759: ldc_w           "path-query"
        //   762: iconst_1       
        //   763: aload_2        
        //   764: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   767: athrow         
        //   768: new             Lgnu/mapping/WrongType;
        //   771: dup_x1         
        //   772: swap           
        //   773: ldc_w           "path-fragment"
        //   776: iconst_1       
        //   777: aload_2        
        //   778: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   781: athrow         
        //   782: new             Lgnu/mapping/WrongType;
        //   785: dup_x1         
        //   786: swap           
        //   787: ldc_w           "file-exists?"
        //   790: iconst_1       
        //   791: aload_2        
        //   792: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   795: athrow         
        //   796: new             Lgnu/mapping/WrongType;
        //   799: dup_x1         
        //   800: swap           
        //   801: ldc_w           "file-directory?"
        //   804: iconst_1       
        //   805: aload_2        
        //   806: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   809: athrow         
        //   810: new             Lgnu/mapping/WrongType;
        //   813: dup_x1         
        //   814: swap           
        //   815: ldc_w           "file-readable?"
        //   818: iconst_1       
        //   819: aload_2        
        //   820: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   823: athrow         
        //   824: new             Lgnu/mapping/WrongType;
        //   827: dup_x1         
        //   828: swap           
        //   829: ldc_w           "file-writable?"
        //   832: iconst_1       
        //   833: aload_2        
        //   834: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   837: athrow         
        //   838: new             Lgnu/mapping/WrongType;
        //   841: dup_x1         
        //   842: swap           
        //   843: ldc_w           "delete-file"
        //   846: iconst_1       
        //   847: aload_2        
        //   848: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   851: athrow         
        //   852: new             Lgnu/mapping/WrongType;
        //   855: dup_x1         
        //   856: swap           
        //   857: ldc_w           "create-directory"
        //   860: iconst_1       
        //   861: aload_2        
        //   862: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   865: athrow         
        //   866: new             Lgnu/mapping/WrongType;
        //   869: dup_x1         
        //   870: swap           
        //   871: ldc_w           "directory-files"
        //   874: iconst_1       
        //   875: aload_2        
        //   876: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   879: athrow         
        //   880: new             Lgnu/mapping/WrongType;
        //   883: dup_x1         
        //   884: swap           
        //   885: ldc_w           "make-temporary-file"
        //   888: iconst_1       
        //   889: aload_2        
        //   890: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   893: athrow         
        //   894: new             Lgnu/mapping/WrongType;
        //   897: dup_x1         
        //   898: swap           
        //   899: ldc_w           "path-bytes"
        //   902: iconst_1       
        //   903: aload_2        
        //   904: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   907: athrow         
        //   908: new             Lgnu/mapping/WrongType;
        //   911: dup_x1         
        //   912: swap           
        //   913: ldc_w           "path-data"
        //   916: iconst_1       
        //   917: aload_2        
        //   918: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   921: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  217    220    600    614    Ljava/lang/ClassCastException;
        //  242    245    614    628    Ljava/lang/ClassCastException;
        //  255    258    628    642    Ljava/lang/ClassCastException;
        //  268    271    642    656    Ljava/lang/ClassCastException;
        //  281    284    656    670    Ljava/lang/ClassCastException;
        //  294    297    670    684    Ljava/lang/ClassCastException;
        //  307    310    684    698    Ljava/lang/ClassCastException;
        //  320    323    698    712    Ljava/lang/ClassCastException;
        //  333    336    712    726    Ljava/lang/ClassCastException;
        //  346    349    726    740    Ljava/lang/ClassCastException;
        //  359    362    740    754    Ljava/lang/ClassCastException;
        //  375    378    754    768    Ljava/lang/ClassCastException;
        //  388    391    768    782    Ljava/lang/ClassCastException;
        //  401    404    782    796    Ljava/lang/ClassCastException;
        //  426    429    796    810    Ljava/lang/ClassCastException;
        //  451    454    810    824    Ljava/lang/ClassCastException;
        //  476    479    824    838    Ljava/lang/ClassCastException;
        //  501    504    838    852    Ljava/lang/ClassCastException;
        //  517    520    852    866    Ljava/lang/ClassCastException;
        //  542    545    866    880    Ljava/lang/ClassCastException;
        //  560    563    880    894    Ljava/lang/ClassCastException;
        //  573    576    894    908    Ljava/lang/ClassCastException;
        //  586    589    908    922    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 380 out of bounds for length 380
        //     at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
        //     at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
        //     at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:248)
        //     at java.base/java.util.Objects.checkIndex(Objects.java:372)
        //     at java.base/java.util.ArrayList.get(ArrayList.java:458)
        //     at com.strobel.decompiler.ast.AstBuilder.convertToAst(AstBuilder.java:3321)
        //     at com.strobel.decompiler.ast.AstBuilder.build(AstBuilder.java:113)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:211)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:675)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:552)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:150)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:125)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:330)
        //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:251)
        //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:126)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    @Override
    public Object apply2(final ModuleMethod p0, final Object p1, final Object p2) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        gnu/expr/ModuleMethod.selector:I
        //     4: lookupswitch {
        //               18: 64
        //               19: 89
        //               20: 106
        //               27: 123
        //               28: 157
        //               34: 182
        //          default: 204
        //        }
        //    64: aload_2        
        //    65: ldc             Lgnu/kawa/io/Path;.class
        //    67: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    70: invokestatic    gnu/kawa/io/Path.valueOf:(Ljava/lang/Object;)Lgnu/kawa/io/Path;
        //    73: aload_3        
        //    74: ldc             Lgnu/lists/U8Vector;.class
        //    76: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    79: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceToU8Vector:(Ljava/lang/Object;)Lgnu/lists/U8Vector;
        //    82: invokestatic    kawa/lib/files.lambda1:(Lgnu/kawa/io/Path;Lgnu/lists/U8Vector;)V
        //    85: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //    88: areturn        
        //    89: aload_2        
        //    90: ldc             Lgnu/kawa/io/Path;.class
        //    92: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    95: invokestatic    gnu/kawa/io/Path.valueOf:(Ljava/lang/Object;)Lgnu/kawa/io/Path;
        //    98: aload_3        
        //    99: invokestatic    kawa/lib/files.pathDataSetter:(Lgnu/kawa/io/Path;Ljava/lang/Object;)V
        //   102: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //   105: areturn        
        //   106: aload_2        
        //   107: ldc             Lgnu/kawa/io/FilePath;.class
        //   109: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   112: invokestatic    gnu/kawa/io/FilePath.makeFilePath:(Ljava/lang/Object;)Lgnu/kawa/io/FilePath;
        //   115: aload_3        
        //   116: invokestatic    kawa/lib/files.pathDataAppender:(Lgnu/kawa/io/FilePath;Ljava/lang/Object;)V
        //   119: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //   122: areturn        
        //   123: aload_2        
        //   124: ldc             Lgnu/kawa/io/FilePath;.class
        //   126: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   129: invokestatic    gnu/kawa/io/FilePath.makeFilePath:(Ljava/lang/Object;)Lgnu/kawa/io/FilePath;
        //   132: aload_3        
        //   133: ldc             Lgnu/kawa/io/FilePath;.class
        //   135: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   138: invokestatic    gnu/kawa/io/FilePath.makeFilePath:(Ljava/lang/Object;)Lgnu/kawa/io/FilePath;
        //   141: invokestatic    kawa/lib/files.renameFile:(Lgnu/kawa/io/FilePath;Lgnu/kawa/io/FilePath;)Z
        //   144: ifeq            153
        //   147: getstatic       java/lang/Boolean.TRUE:Ljava/lang/Boolean;
        //   150: goto            156
        //   153: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //   156: areturn        
        //   157: aload_2        
        //   158: ldc             Lgnu/kawa/io/Path;.class
        //   160: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   163: invokestatic    gnu/kawa/io/Path.valueOf:(Ljava/lang/Object;)Lgnu/kawa/io/Path;
        //   166: aload_3        
        //   167: ldc             Lgnu/kawa/io/Path;.class
        //   169: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   172: invokestatic    gnu/kawa/io/Path.valueOf:(Ljava/lang/Object;)Lgnu/kawa/io/Path;
        //   175: invokestatic    kawa/lib/files.copyFile:(Lgnu/kawa/io/Path;Lgnu/kawa/io/Path;)V
        //   178: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //   181: areturn        
        //   182: aload_2        
        //   183: ldc             Lgnu/kawa/io/Path;.class
        //   185: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   188: invokestatic    gnu/kawa/io/Path.valueOf:(Ljava/lang/Object;)Lgnu/kawa/io/Path;
        //   191: aload_3        
        //   192: ldc             Lgnu/kawa/io/Path;.class
        //   194: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   197: invokestatic    gnu/kawa/io/Path.valueOf:(Ljava/lang/Object;)Lgnu/kawa/io/Path;
        //   200: invokestatic    kawa/lib/files.resolveUri:(Lgnu/kawa/io/Path;Lgnu/kawa/io/Path;)Lgnu/kawa/io/Path;
        //   203: areturn        
        //   204: aload_0        
        //   205: aload_1        
        //   206: aload_2        
        //   207: aload_3        
        //   208: invokespecial   gnu/expr/ModuleBody.apply2:(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   211: areturn        
        //   212: new             Lgnu/mapping/WrongType;
        //   215: dup_x1         
        //   216: swap           
        //   217: ldc_w           "lambda"
        //   220: iconst_1       
        //   221: aload_2        
        //   222: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   225: athrow         
        //   226: new             Lgnu/mapping/WrongType;
        //   229: dup_x1         
        //   230: swap           
        //   231: ldc_w           "lambda"
        //   234: iconst_2       
        //   235: aload_3        
        //   236: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   239: athrow         
        //   240: new             Lgnu/mapping/WrongType;
        //   243: dup_x1         
        //   244: swap           
        //   245: ldc_w           "path-data-setter"
        //   248: iconst_1       
        //   249: aload_2        
        //   250: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   253: athrow         
        //   254: new             Lgnu/mapping/WrongType;
        //   257: dup_x1         
        //   258: swap           
        //   259: ldc_w           "path-data-appender"
        //   262: iconst_1       
        //   263: aload_2        
        //   264: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   267: athrow         
        //   268: new             Lgnu/mapping/WrongType;
        //   271: dup_x1         
        //   272: swap           
        //   273: ldc_w           "rename-file"
        //   276: iconst_1       
        //   277: aload_2        
        //   278: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   281: athrow         
        //   282: new             Lgnu/mapping/WrongType;
        //   285: dup_x1         
        //   286: swap           
        //   287: ldc_w           "rename-file"
        //   290: iconst_2       
        //   291: aload_3        
        //   292: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   295: athrow         
        //   296: new             Lgnu/mapping/WrongType;
        //   299: dup_x1         
        //   300: swap           
        //   301: ldc_w           "copy-file"
        //   304: iconst_1       
        //   305: aload_2        
        //   306: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   309: athrow         
        //   310: new             Lgnu/mapping/WrongType;
        //   313: dup_x1         
        //   314: swap           
        //   315: ldc_w           "copy-file"
        //   318: iconst_2       
        //   319: aload_3        
        //   320: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   323: athrow         
        //   324: new             Lgnu/mapping/WrongType;
        //   327: dup_x1         
        //   328: swap           
        //   329: ldc_w           "resolve-uri"
        //   332: iconst_1       
        //   333: aload_2        
        //   334: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   337: athrow         
        //   338: new             Lgnu/mapping/WrongType;
        //   341: dup_x1         
        //   342: swap           
        //   343: ldc_w           "resolve-uri"
        //   346: iconst_2       
        //   347: aload_3        
        //   348: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   351: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  70     73     212    226    Ljava/lang/ClassCastException;
        //  79     82     226    240    Ljava/lang/ClassCastException;
        //  95     98     240    254    Ljava/lang/ClassCastException;
        //  112    115    254    268    Ljava/lang/ClassCastException;
        //  129    132    268    282    Ljava/lang/ClassCastException;
        //  138    141    282    296    Ljava/lang/ClassCastException;
        //  163    166    296    310    Ljava/lang/ClassCastException;
        //  172    175    310    324    Ljava/lang/ClassCastException;
        //  188    191    324    338    Ljava/lang/ClassCastException;
        //  197    200    338    352    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 151 out of bounds for length 151
        //     at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
        //     at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
        //     at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:248)
        //     at java.base/java.util.Objects.checkIndex(Objects.java:372)
        //     at java.base/java.util.ArrayList.get(ArrayList.java:458)
        //     at com.strobel.decompiler.ast.AstBuilder.convertToAst(AstBuilder.java:3321)
        //     at com.strobel.decompiler.ast.AstBuilder.build(AstBuilder.java:113)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:211)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:675)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:552)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:150)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:125)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:330)
        //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:251)
        //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:126)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
}
