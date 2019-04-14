package kawa.lib; import gnu.kawa.io.Path;

public class files extends gnu.expr.ModuleBody { public static final gnu.kawa.reflect.StaticFieldLocation $Prvt$$string$; public static final gnu.expr.ModuleMethod path$Qu; public static final gnu.expr.ModuleMethod filepath$Qu; public static final gnu.expr.ModuleMethod URI$Qu; public static final gnu.expr.ModuleMethod absolute$Mnpath$Qu; public static final gnu.expr.ModuleMethod path$Mnscheme; public static final gnu.expr.ModuleMethod path$Mnauthority; public static final gnu.expr.ModuleMethod path$Mnuser$Mninfo; public static final gnu.expr.ModuleMethod path$Mnhost; public static final gnu.expr.ModuleMethod path$Mnfile; public static final gnu.expr.ModuleMethod path$Mndirectory; public static final gnu.expr.ModuleMethod path$Mnparent; public static final gnu.expr.ModuleMethod path$Mnlast; public static final gnu.expr.ModuleMethod path$Mnextension; public static final gnu.expr.ModuleMethod path$Mnport; public static final gnu.expr.ModuleMethod path$Mnquery; public static final gnu.expr.ModuleMethod path$Mnfragment; public static final gnu.expr.GenericProc path$Mnbytes; public static final gnu.expr.ModuleMethod path$Mndata$Mnsetter; public static final gnu.expr.ModuleMethod path$Mndata$Mnappender; public static final gnu.expr.GenericProc path$Mndata; public static final kawa.lang.Macro path$Mndata$Mnsetter$Mncurried; public static final kawa.lang.Macro path$Mndata$Mnappender$Mncurried; @gnu.expr.SourceName(name="PD", uri="http://kawa.gnu.org/construct", prefix="$construct$")
  public static final kawa.lang.Macro PD; @gnu.expr.SourceName(name="set_PD", uri="http://kawa.gnu.org/construct", prefix="$construct$")
  public static final kawa.lang.Macro set_PD; @gnu.expr.SourceName(name="append_PD", uri="http://kawa.gnu.org/construct", prefix="$construct$")
  public static final kawa.lang.Macro append_PD; public static final gnu.expr.ModuleMethod file$Mnexists$Qu; public static final gnu.expr.ModuleMethod file$Mndirectory$Qu; public static final gnu.expr.ModuleMethod file$Mnreadable$Qu; public static final gnu.expr.ModuleMethod file$Mnwritable$Qu; public static final gnu.expr.ModuleMethod delete$Mnfile; public static final gnu.expr.ModuleMethod rename$Mnfile; public static final gnu.expr.ModuleMethod copy$Mnfile; public static final gnu.expr.ModuleMethod create$Mndirectory; public static final gnu.expr.ModuleMethod directory$Mnfiles; public static final gnu.expr.ModuleMethod $Mn$Grpathname; public static final gnu.expr.ModuleMethod $Pcfile$Mnseparator; public static final gnu.expr.ModuleMethod system$Mntmpdir; public static final gnu.expr.ModuleMethod resolve$Mnuri; public static final gnu.expr.ModuleMethod make$Mntemporary$Mnfile; static final gnu.expr.Keyword Lit0; static final gnu.expr.ModuleMethod lambda$Fn1; public static files $instance; static final gnu.mapping.SimpleSymbol Lit1; static final gnu.mapping.SimpleSymbol Lit2; static final gnu.mapping.SimpleSymbol Lit3; static final gnu.mapping.SimpleSymbol Lit4; static final gnu.mapping.SimpleSymbol Lit5; static final gnu.mapping.SimpleSymbol Lit6; static final gnu.mapping.SimpleSymbol Lit7; static final gnu.mapping.SimpleSymbol Lit8; static final gnu.mapping.SimpleSymbol Lit9; static final gnu.mapping.SimpleSymbol Lit10; static final gnu.mapping.SimpleSymbol Lit11; static final gnu.mapping.SimpleSymbol Lit12; static final gnu.mapping.SimpleSymbol Lit13; static final gnu.mapping.SimpleSymbol Lit14; static final gnu.mapping.SimpleSymbol Lit15; static final gnu.mapping.SimpleSymbol Lit16; static final gnu.mapping.SimpleSymbol Lit17; static final gnu.mapping.SimpleSymbol Lit18; static final gnu.mapping.SimpleSymbol Lit19; static final kawa.lang.SyntaxRules Lit20; static final gnu.mapping.SimpleSymbol Lit21; static final kawa.lang.SyntaxRules Lit22; static final gnu.mapping.Symbol Lit23; static final kawa.lang.SyntaxRules Lit24; static final gnu.mapping.Symbol Lit25; static final kawa.lang.SyntaxRules Lit26; static final gnu.mapping.Symbol Lit27; static final kawa.lang.SyntaxRules Lit28; static final gnu.mapping.SimpleSymbol Lit29; static final gnu.mapping.SimpleSymbol Lit30; static final gnu.mapping.SimpleSymbol Lit31; static final gnu.mapping.SimpleSymbol Lit32; static final gnu.mapping.SimpleSymbol Lit33; static final gnu.mapping.SimpleSymbol Lit34; static final gnu.mapping.SimpleSymbol Lit35; static final gnu.mapping.SimpleSymbol Lit36; static final gnu.mapping.SimpleSymbol Lit37; static final gnu.mapping.SimpleSymbol Lit38; static final gnu.mapping.SimpleSymbol Lit39; static final gnu.mapping.SimpleSymbol Lit40; static final gnu.mapping.SimpleSymbol Lit41; static final gnu.mapping.SimpleSymbol Lit42; static final Object[] Lit43; static final gnu.mapping.SimpleSymbol Lit44; static final gnu.mapping.SimpleSymbol Lit45; static final gnu.mapping.Namespace Lit46; static final gnu.lists.PairWithPosition Lit47; static final gnu.mapping.SimpleSymbol Lit48; static final gnu.mapping.SimpleSymbol Lit49; static final gnu.mapping.SimpleSymbol Lit50 = gnu.mapping.Symbol.valueOf("void");
  


  public static boolean isPath(Object path) { return path instanceof Path; }
  
  public static boolean isFilepath(Object path) { return path instanceof gnu.kawa.io.FilePath; }
  
  public static boolean URI$Qu(Object path) { return path instanceof gnu.kawa.io.URIPath; }
  
  public static boolean isAbsolutePath(Path path) { return path.isAbsolute(); }
  
  public static Object pathScheme(Path p) { String s = p.getScheme();
    return s == null ? Boolean.FALSE : s; }
  
  public static Object pathAuthority(Path p) { String s = p.getAuthority();
    return s == null ? Boolean.FALSE : s; }
  
  public static Object pathUserInfo(Path p) { String s = p.getUserInfo();
    return s == null ? Boolean.FALSE : s; }
  
  public static String pathHost(Path p) { return p.getHost(); }
  
  public static Object pathFile(Path p) { String s = p.getPath();
    return s == null ? Boolean.FALSE : s; }
  
  public static Object pathDirectory(Path p) { Path s = p.getDirectory();
    return s == null ? Boolean.FALSE : s.toString(); }
  
  public static Object pathParent(Path p) { Path s = p.getParent();
    return s == null ? Boolean.FALSE : s.toString(); }
  
  public static Object pathLast(Path p) { String s = p.getLast();
    return s == null ? Boolean.FALSE : s; }
  
  public static Object pathExtension(Path p) { String s = p.getExtension();
    return s == null ? Boolean.FALSE : s; }
  
  public static int pathPort(Path p) { return p.getPort(); }
  
  public static Object pathQuery(Path p) { String s = p.getQuery();
    return s == null ? Boolean.FALSE : s; }
  
  public static Object pathFragment(Path p) { String s = p.getFragment();
    return s == null ? Boolean.FALSE : s;
  }
  










  static void lambda1(Path p, gnu.lists.U8Vector b)
  {
    java.io.OutputStream out = p.openOutputStream();
    try {
      b.writeTo(0, b.size(), out);
    } finally { out.close(); } }
  
  public static gnu.lists.U8Vector pathBytes(Path p) { return new gnu.lists.U8Vector(p.readAllBytes()); }
  
  public static void pathDataSetter(Path p, Object newvalue) {
    java.io.OutputStream localOutputStream1 = p.openOutputStream();
    java.io.InputStream in = gnu.kawa.functions.RunProcess.getInputStreamFrom(newvalue);
    java.io.OutputStream out; gnu.kawa.functions.RunProcess.copyStream(in, out, true);
  }
  
  public static void pathDataAppender(gnu.kawa.io.FilePath p, Object newvalue) { java.io.OutputStream localOutputStream1 = p.openAppendStream();
    java.io.InputStream in = gnu.kawa.functions.RunProcess.getInputStreamFrom(newvalue);
    java.io.OutputStream out; gnu.kawa.functions.RunProcess.copyStream(in, out, true);
  }
  
  private static void $runBody$()
  {
    ;
    gnu.lists.Consumer $result = getInstanceconsumer;
    


























































    path$Mnbytes
      .setProperty(Lit0, lambda$Fn1);
    
















    path$Mndata
      .setProperty(Lit0, path$Mndata$Mnsetter);
  }
  
  static
  {
    Lit49 = gnu.mapping.Symbol.valueOf("::");Lit48 = gnu.mapping.Symbol.valueOf("lambda");Lit47 = gnu.lists.PairWithPosition.make(gnu.mapping.Symbol.valueOf("newvalue"), gnu.lists.LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/files.scm", 372756);Lit46 = gnu.mapping.Namespace.valueOf("http://kawa.gnu.org/construct", "$construct$");Lit45 = gnu.mapping.Symbol.valueOf("$string$");Lit44 = gnu.mapping.Symbol.valueOf("%simple-construct-builder");Lit43 = new Object[0];Lit42 = gnu.mapping.Symbol.valueOf("make-temporary-file");Lit41 = gnu.mapping.Symbol.valueOf("resolve-uri");Lit40 = gnu.mapping.Symbol.valueOf("system-tmpdir");Lit39 = gnu.mapping.Symbol.valueOf("%file-separator");Lit38 = gnu.mapping.Symbol.valueOf("->pathname");Lit37 = gnu.mapping.Symbol.valueOf("directory-files");Lit36 = gnu.mapping.Symbol.valueOf("create-directory");Lit35 = gnu.mapping.Symbol.valueOf("copy-file");Lit34 = gnu.mapping.Symbol.valueOf("rename-file");Lit33 = gnu.mapping.Symbol.valueOf("delete-file");Lit32 = gnu.mapping.Symbol.valueOf("file-writable?");Lit31 = gnu.mapping.Symbol.valueOf("file-readable?");Lit30 = gnu.mapping.Symbol.valueOf("file-directory?");Lit29 = gnu.mapping.Symbol.valueOf("file-exists?"); kawa.lang.SyntaxRule[] tmp222_219 = new kawa.lang.SyntaxRule[1]; Object[] tmp255_252 = new Object[3]; Object[] tmp256_255 = tmp255_252;tmp256_255[0] = new kawa.lang.SyntaxForms.SimpleSyntaxForm(Lit44, kawa.lang.TemplateScope.make("kawa.lib.syntax")); Object[] tmp275_256 = tmp256_255; gnu.mapping.SimpleSymbol tmp283_280 = gnu.mapping.Symbol.valueOf("path-data-appender-curried");Lit21 = tmp283_280;tmp275_256[1] = tmp283_280;tmp275_256[2] = Lit45;tmp222_219[0] = new kawa.lang.SyntaxRule(new kawa.lang.SyntaxPattern("\f\030\003", Lit43, 1, "files.scm:95"), "\000", "\t\004\021\030\f\021\030\024\t\020\002", tmp255_252, 0);Lit28 = new kawa.lang.SyntaxRules(Lit43, tmp222_219, 1, files.Lit27 = gnu.mapping.Symbol.make(Lit46, "append_PD")); kawa.lang.SyntaxRule[] tmp329_326 = new kawa.lang.SyntaxRule[1]; Object[] tmp362_359 = new Object[3]; Object[] tmp363_362 = tmp362_359;tmp363_362[0] = new kawa.lang.SyntaxForms.SimpleSyntaxForm(Lit44, kawa.lang.TemplateScope.make("kawa.lib.syntax")); Object[] tmp382_363 = tmp363_362; gnu.mapping.SimpleSymbol tmp390_387 = gnu.mapping.Symbol.valueOf("path-data-setter-curried");Lit19 = tmp390_387;tmp382_363[1] = tmp390_387;tmp382_363[2] = Lit45;tmp329_326[0] = new kawa.lang.SyntaxRule(new kawa.lang.SyntaxPattern("\f\030\003", Lit43, 1, "files.scm:94"), "\000", "\t\004\021\030\f\021\030\024\t\020\002", tmp362_359, 0);Lit26 = new kawa.lang.SyntaxRules(Lit43, tmp329_326, 1, files.Lit25 = gnu.mapping.Symbol.make(Lit46, "set_PD")); kawa.lang.SyntaxRule[] tmp436_433 = new kawa.lang.SyntaxRule[1]; Object[] tmp469_466 = new Object[3]; Object[] tmp470_469 = tmp469_466;tmp470_469[0] = new kawa.lang.SyntaxForms.SimpleSyntaxForm(Lit44, kawa.lang.TemplateScope.make("kawa.lib.syntax")); Object[] tmp489_470 = tmp470_469;tmp489_470[1] = gnu.mapping.Symbol.valueOf("path-data");tmp489_470[2] = Lit45;tmp436_433[0] = new kawa.lang.SyntaxRule(new kawa.lang.SyntaxPattern("\f\030\003", Lit43, 1, "files.scm:93"), "\000", "\t\004\021\030\f\021\030\024\t\020\002", tmp469_466, 0);Lit24 = new kawa.lang.SyntaxRules(Lit43, tmp436_433, 1, files.Lit23 = gnu.mapping.Symbol.make(Lit46, "PD")); kawa.lang.SyntaxRule[] tmp539_536 = new kawa.lang.SyntaxRule[1]; Object[] tmp573_570 = new Object[6]; Object[] tmp574_573 = tmp573_570;tmp574_573[0] = Lit48; Object[] tmp580_574 = tmp574_573;tmp580_574[1] = Lit47; Object[] tmp586_580 = tmp580_574;tmp586_580[2] = Lit49; Object[] tmp592_586 = tmp586_580;tmp592_586[3] = Lit50; Object[] tmp598_592 = tmp592_586; gnu.mapping.SimpleSymbol tmp606_603 = gnu.mapping.Symbol.valueOf("path-data-appender");Lit18 = tmp606_603;tmp598_592[4] = tmp606_603;tmp598_592[5] = Lit47;tmp539_536[0] = new kawa.lang.SyntaxRule(new kawa.lang.SyntaxPattern("\f\030\f\007\b", Lit43, 1, "files.scm:91"), "\001", "\021\030\004\021\030\f\021\030\024\021\030\034\b\021\030$\t\003\030,", tmp573_570, 0);Lit22 = new kawa.lang.SyntaxRules(Lit43, tmp539_536, 1, Lit21); kawa.lang.SyntaxRule[] tmp642_639 = new kawa.lang.SyntaxRule[1]; Object[] tmp676_673 = new Object[6]; Object[] tmp677_676 = tmp676_673;tmp677_676[0] = Lit48; Object[] tmp683_677 = tmp677_676;tmp683_677[1] = Lit47; Object[] tmp689_683 = tmp683_677;tmp689_683[2] = Lit49; Object[] tmp695_689 = tmp689_683;tmp695_689[3] = Lit50; Object[] tmp701_695 = tmp695_689; gnu.mapping.SimpleSymbol tmp709_706 = gnu.mapping.Symbol.valueOf("path-data-setter");Lit17 = tmp709_706;tmp701_695[4] = tmp709_706;tmp701_695[5] = Lit47;tmp642_639[0] = new kawa.lang.SyntaxRule(new kawa.lang.SyntaxPattern("\f\030\f\007\b", Lit43, 1, "files.scm:87"), "\001", "\021\030\004\021\030\f\021\030\024\021\030\034\b\021\030$\t\003\030,", tmp676_673, 0);Lit20 = new kawa.lang.SyntaxRules(Lit43, tmp642_639, 1, Lit19);Lit16 = gnu.mapping.Symbol.valueOf("path-fragment");Lit15 = gnu.mapping.Symbol.valueOf("path-query");Lit14 = gnu.mapping.Symbol.valueOf("path-port");Lit13 = gnu.mapping.Symbol.valueOf("path-extension");Lit12 = gnu.mapping.Symbol.valueOf("path-last");Lit11 = gnu.mapping.Symbol.valueOf("path-parent");Lit10 = gnu.mapping.Symbol.valueOf("path-directory");Lit9 = gnu.mapping.Symbol.valueOf("path-file");Lit8 = gnu.mapping.Symbol.valueOf("path-host");Lit7 = gnu.mapping.Symbol.valueOf("path-user-info");Lit6 = gnu.mapping.Symbol.valueOf("path-authority");Lit5 = gnu.mapping.Symbol.valueOf("path-scheme");Lit4 = gnu.mapping.Symbol.valueOf("absolute-path?");Lit3 = gnu.mapping.Symbol.valueOf("URI?");Lit2 = gnu.mapping.Symbol.valueOf("filepath?");Lit1 = gnu.mapping.Symbol.valueOf("path?");Lit0 = gnu.expr.Keyword.make("setter");$instance = new files();$Prvt$$string$ = gnu.kawa.reflect.StaticFieldLocation.make("kawa.lib.syntax", "$string$");files localFiles1 = $instance;path$Qu = new gnu.expr.ModuleMethod(localFiles1, 1, Lit1, 4097);filepath$Qu = new gnu.expr.ModuleMethod(localFiles1, 2, Lit2, 4097);URI$Qu = new gnu.expr.ModuleMethod(localFiles1, 3, Lit3, 4097);absolute$Mnpath$Qu = new gnu.expr.ModuleMethod(localFiles1, 4, Lit4, 4097);path$Mnscheme = new gnu.expr.ModuleMethod(localFiles1, 5, Lit5, 4097);path$Mnauthority = new gnu.expr.ModuleMethod(localFiles1, 6, Lit6, 4097);path$Mnuser$Mninfo = new gnu.expr.ModuleMethod(localFiles1, 7, Lit7, 4097);path$Mnhost = new gnu.expr.ModuleMethod(localFiles1, 8, Lit8, 4097);path$Mnfile = new gnu.expr.ModuleMethod(localFiles1, 9, Lit9, 4097);path$Mndirectory = new gnu.expr.ModuleMethod(localFiles1, 10, Lit10, 4097);path$Mnparent = new gnu.expr.ModuleMethod(localFiles1, 11, Lit11, 4097);path$Mnlast = new gnu.expr.ModuleMethod(localFiles1, 12, Lit12, 4097);path$Mnextension = new gnu.expr.ModuleMethod(localFiles1, 13, Lit13, 4097);path$Mnport = new gnu.expr.ModuleMethod(localFiles1, 14, Lit14, 4097);path$Mnquery = new gnu.expr.ModuleMethod(localFiles1, 15, Lit15, 4097);path$Mnfragment = new gnu.expr.ModuleMethod(localFiles1, 16, Lit16, 4097); void 
    























































      tmp1222_1219 = new gnu.expr.GenericProc("path-bytes");
    




    files $instance = $instance; void tmp1243_1240 = new gnu.expr.ModuleMethod($instance, 17, "path-bytes", 4097);tmp1243_1240.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/files.scm:67");tmp1222_1219.add(tmp1243_1240);path$Mnbytes = tmp1222_1219; void tmp1273_1270 = new gnu.expr.ModuleMethod(localFiles1, 18, null, 8194);tmp1273_1270.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/files.scm:62");lambda$Fn1 = tmp1273_1270;path$Mndata$Mnsetter = new gnu.expr.ModuleMethod(localFiles1, 19, Lit17, 8194);path$Mndata$Mnappender = new gnu.expr.ModuleMethod(localFiles1, 20, Lit18, 8194); void 
    











      tmp1334_1331 = new gnu.expr.GenericProc("path-data");
    
    files $instance = $instance; void tmp1355_1352 = new gnu.expr.ModuleMethod($instance, 21, "path-data", 4097);tmp1355_1352.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/files.scm:82");tmp1334_1331.add(tmp1355_1352);path$Mndata = tmp1334_1331;path$Mndata$Mnsetter$Mncurried = kawa.lang.Macro.make(Lit19, Lit20, "kawa.lib.files");path$Mndata$Mnappender$Mncurried = kawa.lang.Macro.make(Lit21, Lit22, "kawa.lib.files");PD = kawa.lang.Macro.make(Lit23, Lit24, "kawa.lib.files");set_PD = kawa.lang.Macro.make(Lit25, Lit26, "kawa.lib.files");append_PD = kawa.lang.Macro.make(Lit27, Lit28, "kawa.lib.files");file$Mnexists$Qu = new gnu.expr.ModuleMethod(localFiles1, 22, Lit29, 4097);file$Mndirectory$Qu = new gnu.expr.ModuleMethod(localFiles1, 23, Lit30, 4097);file$Mnreadable$Qu = new gnu.expr.ModuleMethod(localFiles1, 24, Lit31, 4097);file$Mnwritable$Qu = new gnu.expr.ModuleMethod(localFiles1, 25, Lit32, 4097);delete$Mnfile = new gnu.expr.ModuleMethod(localFiles1, 26, Lit33, 4097);rename$Mnfile = new gnu.expr.ModuleMethod(localFiles1, 27, Lit34, 8194);copy$Mnfile = new gnu.expr.ModuleMethod(localFiles1, 28, Lit35, 8194);create$Mndirectory = new gnu.expr.ModuleMethod(localFiles1, 29, Lit36, 4097);directory$Mnfiles = new gnu.expr.ModuleMethod(localFiles1, 30, Lit37, 4097);$Mn$Grpathname = new gnu.expr.ModuleMethod(localFiles1, 31, Lit38, 4097);$Pcfile$Mnseparator = new gnu.expr.ModuleMethod(localFiles1, 32, Lit39, 0);system$Mntmpdir = new gnu.expr.ModuleMethod(localFiles1, 33, Lit40, 0);resolve$Mnuri = new gnu.expr.ModuleMethod(localFiles1, 34, Lit41, 8194);make$Mntemporary$Mnfile = new gnu.expr.ModuleMethod(localFiles1, 35, Lit42, 4096);$runBody$();
  }
  
  public Object apply1(gnu.expr.ModuleMethod paramModuleMethod, Object paramObject)
  {
    switch (selector) {case 1:  return isPath(paramObject) ? Boolean.TRUE : Boolean.FALSE;
    case 2: 
      return isFilepath(paramObject) ? Boolean.TRUE : Boolean.FALSE;
    case 3: 
      return URI$Qu(paramObject) ? Boolean.TRUE : Boolean.FALSE; }
    for (;;) {
      try { return isAbsolutePath(Path.valueOf(gnu.mapping.Promise.force(paramObject, Path.class))) ? Boolean.TRUE : Boolean.FALSE; } catch (ClassCastException localClassCastException1) { throw new gnu.mapping.WrongType(
        



































































          localClassCastException1, "absolute-path?", 1, paramObject);
      }
      try
      {
        return pathScheme(Path.valueOf(gnu.mapping.Promise.force(paramObject, Path.class))); } catch (ClassCastException localClassCastException2) { throw new gnu.mapping.WrongType(localClassCastException2, "path-scheme", 1, paramObject);
      }
      try {
        return pathAuthority(Path.valueOf(gnu.mapping.Promise.force(paramObject, Path.class))); } catch (ClassCastException localClassCastException3) { throw new gnu.mapping.WrongType(localClassCastException3, "path-authority", 1, paramObject);
      }
      try {
        return pathUserInfo(Path.valueOf(gnu.mapping.Promise.force(paramObject, Path.class))); } catch (ClassCastException localClassCastException4) { throw new gnu.mapping.WrongType(localClassCastException4, "path-user-info", 1, paramObject);
      }
      try {
        return pathHost(Path.valueOf(gnu.mapping.Promise.force(paramObject, Path.class))); } catch (ClassCastException localClassCastException5) { throw new gnu.mapping.WrongType(localClassCastException5, "path-host", 1, paramObject);
      }
      try { return pathFile(Path.valueOf(gnu.mapping.Promise.force(paramObject, Path.class))); } catch (ClassCastException localClassCastException6) { throw new gnu.mapping.WrongType(localClassCastException6, "path-file", 1, paramObject);
      }
      try {
        return pathDirectory(Path.valueOf(gnu.mapping.Promise.force(paramObject, Path.class))); } catch (ClassCastException localClassCastException7) { throw new gnu.mapping.WrongType(localClassCastException7, "path-directory", 1, paramObject);
      }
      try {
        return pathParent(Path.valueOf(gnu.mapping.Promise.force(paramObject, Path.class))); } catch (ClassCastException localClassCastException8) { throw new gnu.mapping.WrongType(localClassCastException8, "path-parent", 1, paramObject);
      }
      try {
        return pathLast(Path.valueOf(gnu.mapping.Promise.force(paramObject, Path.class))); } catch (ClassCastException localClassCastException9) { throw new gnu.mapping.WrongType(localClassCastException9, "path-last", 1, paramObject);
      }
      try {
        return pathExtension(Path.valueOf(gnu.mapping.Promise.force(paramObject, Path.class))); } catch (ClassCastException localClassCastException10) { throw new gnu.mapping.WrongType(localClassCastException10, "path-extension", 1, paramObject);
      }
      try {
        return Integer.valueOf(pathPort(Path.valueOf(gnu.mapping.Promise.force(paramObject, Path.class)))); } catch (ClassCastException localClassCastException11) { throw new gnu.mapping.WrongType(localClassCastException11, "path-port", 1, paramObject);
      }
      try { return pathQuery(Path.valueOf(gnu.mapping.Promise.force(paramObject, Path.class))); } catch (ClassCastException localClassCastException12) { throw new gnu.mapping.WrongType(localClassCastException12, "path-query", 1, paramObject);
      }
      try {
        return pathFragment(Path.valueOf(gnu.mapping.Promise.force(paramObject, Path.class))); } catch (ClassCastException localClassCastException13) { throw new gnu.mapping.WrongType(localClassCastException13, "path-fragment", 1, paramObject);
      }
      














































      try
      {
        return isFileExists(Path.valueOf(gnu.mapping.Promise.force(paramObject, Path.class))) ? Boolean.TRUE : Boolean.FALSE; } catch (ClassCastException localClassCastException14) { throw new gnu.mapping.WrongType(localClassCastException14, "file-exists?", 1, paramObject);
      }
      try {
        return isFileDirectory(Path.valueOf(gnu.mapping.Promise.force(paramObject, Path.class))) ? Boolean.TRUE : Boolean.FALSE; } catch (ClassCastException localClassCastException15) { throw new gnu.mapping.WrongType(localClassCastException15, "file-directory?", 1, paramObject);
      }
      try {
        return isFileReadable(gnu.kawa.io.FilePath.makeFilePath(gnu.mapping.Promise.force(paramObject, gnu.kawa.io.FilePath.class))) ? Boolean.TRUE : Boolean.FALSE; } catch (ClassCastException localClassCastException16) { throw new gnu.mapping.WrongType(localClassCastException16, "file-readable?", 1, paramObject);
      }
      try {
        return isFileWritable(gnu.kawa.io.FilePath.makeFilePath(gnu.mapping.Promise.force(paramObject, gnu.kawa.io.FilePath.class))) ? Boolean.TRUE : Boolean.FALSE; } catch (ClassCastException localClassCastException17) { throw new gnu.mapping.WrongType(localClassCastException17, "file-writable?", 1, paramObject);
      }
      

      try
      {
        deleteFile(gnu.kawa.io.FilePath.makeFilePath(gnu.mapping.Promise.force(paramObject, gnu.kawa.io.FilePath.class)));return gnu.mapping.Values.empty; } catch (ClassCastException localClassCastException18) { throw new gnu.mapping.WrongType(localClassCastException18, "delete-file", 1, paramObject);
      }
      











      try
      {
        return createDirectory(gnu.kawa.io.FilePath.makeFilePath(gnu.mapping.Promise.force(paramObject, gnu.kawa.io.FilePath.class))) ? Boolean.TRUE : Boolean.FALSE; } catch (ClassCastException localClassCastException19) { throw new gnu.mapping.WrongType(localClassCastException19, "create-directory", 1, paramObject);
      }
    }
    try {
      return directoryFiles(gnu.kawa.io.FilePath.makeFilePath(gnu.mapping.Promise.force(paramObject, gnu.kawa.io.FilePath.class))); } catch (ClassCastException localClassCastException20) { throw new gnu.mapping.WrongType(localClassCastException20, "directory-files", 1, paramObject);
    }
    





    return $To$Pathname(paramObject);
    

















    try
    {
      return makeTemporaryFile((CharSequence)gnu.mapping.Promise.force(paramObject, CharSequence.class)); } catch (ClassCastException localClassCastException21) { throw new gnu.mapping.WrongType(localClassCastException21, "make-temporary-file", 1, paramObject);
    }
    try
    {
      return pathBytes(Path.valueOf(gnu.mapping.Promise.force(paramObject, Path.class))); } catch (ClassCastException localClassCastException22) { throw new gnu.mapping.WrongType(
      




























































































        localClassCastException22, "path-bytes", 1, paramObject);
    }
    try
    {
      return pathData(Path.valueOf(gnu.mapping.Promise.force(paramObject, Path.class))); } catch (ClassCastException localClassCastException23) { throw new gnu.mapping.WrongType(localClassCastException23, "path-data", 1, paramObject); } return super.apply1(paramModuleMethod, paramObject); }
  public static gnu.lists.Blob pathData(Path p) { return new gnu.lists.Blob(p.readAllBytes()); }
  











  public static boolean isFileExists(Path file)
  {
    return file.exists();
  }
  
  public static boolean isFileDirectory(Path file) { return file.isDirectory(); }
  
  public static boolean isFileReadable(gnu.kawa.io.FilePath file) {
    return file.toFile().canRead();
  }
  
  public static boolean isFileWritable(gnu.kawa.io.FilePath file) { return file.toFile().canWrite(); }
  


  public static void deleteFile(gnu.kawa.io.FilePath file)
  {
    file.deleteFile();
  }
  
  public static boolean renameFile(gnu.kawa.io.FilePath oldname, gnu.kawa.io.FilePath newname) { return oldname.toFile().renameTo(newname.toFile()); }
  
  public static void copyFile(Path from, Path to) {
    java.io.InputStream localInputStream1 = from.openInputStream();
    java.io.OutputStream localOutputStream1 = to.openOutputStream();byte[] buf = new byte[' '];
    for (;;) { java.io.OutputStream out;
      java.io.InputStream in;
      int n = in.read(buf);
      if (n < 0) break;
      out.write(buf, 0, n);
    }
  }
  
  public static boolean createDirectory(gnu.kawa.io.FilePath dirname) { return dirname.toFile().mkdir(); }
  
  public static Object directoryFiles(gnu.kawa.io.FilePath dir)
  {
    String[] files = dir.toFile().list();
    
    return files == null ? Boolean.FALSE : gnu.lists.LList.makeList(files, 0);
  }
  

  public static Path $To$Pathname(Object filename)
  {
    return Path.valueOf(filename);
  }
  















  public int match0(gnu.expr.ModuleMethod paramModuleMethod, gnu.mapping.CallContext paramCallContext)
  {
    switch (selector) {case 35:  proc = paramModuleMethod;pc = 0;return 0;
    case 33: 
      proc = paramModuleMethod;pc = 0;return 0;
    case 32: 
      proc = paramModuleMethod;pc = 0;return 0; } return super.match0(paramModuleMethod, paramCallContext); }
  public static String $PcFileSeparator() { return System.getProperty("file.separator"); }
  
  public static String systemTmpdir()
  {
    String name = System.getProperty("java.io.tmpdir");
    

    String sep = $PcFileSeparator();
    return gnu.expr.KawaConvert.isTrue(kawa.standard.Scheme.isEqual.apply2(sep, "\\")) ? "C:\\temp" : name != null ? name : "/tmp";
  }
  

  public static Path resolveUri(Path uri, Path base)
  {
    return base.resolve(uri);
  }
  
  public Object apply0(gnu.expr.ModuleMethod paramModuleMethod)
  {
    switch (selector) {case 32:  return $PcFileSeparator();
    
    case 33: 
      return systemTmpdir();
    












    case 35: 
      return makeTemporaryFile(); } return super.apply0(paramModuleMethod); }
  
  public static gnu.kawa.io.FilePath makeTemporaryFile(CharSequence format) { String fmt = format.toString();
    int tilde = fmt.indexOf('~');
    String prefix = tilde < 0 ? fmt : fmt.substring(0, tilde);
    String suffix = tilde < 0 ? ".tmp" : fmt.substring(2 + tilde);
    int sep = prefix.indexOf(java.io.File.separatorChar);java.io.File directory = null;
    




    if (sep >= 0) {
      directory = new java.io.File(prefix.substring(0, sep));
      prefix = prefix.substring(sep + 1); }
    return gnu.kawa.io.FilePath.makeFilePath(java.io.File.createTempFile(prefix, suffix, directory));
  }
  
  public static gnu.kawa.io.FilePath makeTemporaryFile()
  {
    return makeTemporaryFile("kawa~d.tmp");
  }
  
  public files()
  {
    gnu.expr.ModuleInfo.register(this);
  }
  
  /* Error */
  public int match1(gnu.expr.ModuleMethod arg1, Object arg2, gnu.mapping.CallContext arg3)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 581	gnu/expr/ModuleMethod:selector	I
    //   4: tableswitch	default:+1052->1056, 1:+1035->1039, 2:+1018->1022, 3:+1001->1005, 4:+965->969, 5:+929->933, 6:+893->897, 7:+857->861, 8:+821->825, 9:+785->789, 10:+749->753, 11:+713->717, 12:+677->681, 13:+641->645, 14:+605->609, 15:+569->573, 16:+533->537, 17:+192->196, 18:+1052->1056, 19:+1052->1056, 20:+1052->1056, 21:+156->160, 22:+497->501, 23:+461->465, 24:+425->429, 25:+389->393, 26:+353->357, 27:+1052->1056, 28:+1052->1056, 29:+317->321, 30:+281->285, 31:+264->268, 32:+1052->1056, 33:+1052->1056, 34:+1052->1056, 35:+228->232
    //   160: aload_3
    //   161: aload_2
    //   162: ldc 12
    //   164: invokestatic 598	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   167: dup
    //   168: invokestatic 601	gnu/kawa/io/Path:coerceToPathOrNull	(Ljava/lang/Object;)Lgnu/kawa/io/Path;
    //   171: ifnull +6 -> 177
    //   174: goto +7 -> 181
    //   177: ldc_w 602
    //   180: ireturn
    //   181: putfield 606	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   184: aload_3
    //   185: aload_1
    //   186: putfield 585	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   189: aload_3
    //   190: iconst_1
    //   191: putfield 588	gnu/mapping/CallContext:pc	I
    //   194: iconst_0
    //   195: ireturn
    //   196: aload_3
    //   197: aload_2
    //   198: ldc 12
    //   200: invokestatic 598	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   203: dup
    //   204: invokestatic 601	gnu/kawa/io/Path:coerceToPathOrNull	(Ljava/lang/Object;)Lgnu/kawa/io/Path;
    //   207: ifnull +6 -> 213
    //   210: goto +7 -> 217
    //   213: ldc_w 602
    //   216: ireturn
    //   217: putfield 606	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   220: aload_3
    //   221: aload_1
    //   222: putfield 585	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   225: aload_3
    //   226: iconst_1
    //   227: putfield 588	gnu/mapping/CallContext:pc	I
    //   230: iconst_0
    //   231: ireturn
    //   232: aload_3
    //   233: aload_2
    //   234: ldc -25
    //   236: invokestatic 598	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   239: dup
    //   240: instanceof 231
    //   243: ifeq +6 -> 249
    //   246: goto +7 -> 253
    //   249: ldc_w 602
    //   252: ireturn
    //   253: putfield 606	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   256: aload_3
    //   257: aload_1
    //   258: putfield 585	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   261: aload_3
    //   262: iconst_1
    //   263: putfield 588	gnu/mapping/CallContext:pc	I
    //   266: iconst_0
    //   267: ireturn
    //   268: aload_3
    //   269: aload_2
    //   270: putfield 606	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   273: aload_3
    //   274: aload_1
    //   275: putfield 585	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   278: aload_3
    //   279: iconst_1
    //   280: putfield 588	gnu/mapping/CallContext:pc	I
    //   283: iconst_0
    //   284: ireturn
    //   285: aload_3
    //   286: aload_2
    //   287: ldc 14
    //   289: invokestatic 598	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   292: dup
    //   293: invokestatic 609	gnu/kawa/io/FilePath:coerceToFilePathOrNull	(Ljava/lang/Object;)Lgnu/kawa/io/FilePath;
    //   296: ifnull +6 -> 302
    //   299: goto +7 -> 306
    //   302: ldc_w 602
    //   305: ireturn
    //   306: putfield 606	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   309: aload_3
    //   310: aload_1
    //   311: putfield 585	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   314: aload_3
    //   315: iconst_1
    //   316: putfield 588	gnu/mapping/CallContext:pc	I
    //   319: iconst_0
    //   320: ireturn
    //   321: aload_3
    //   322: aload_2
    //   323: ldc 14
    //   325: invokestatic 598	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   328: dup
    //   329: invokestatic 609	gnu/kawa/io/FilePath:coerceToFilePathOrNull	(Ljava/lang/Object;)Lgnu/kawa/io/FilePath;
    //   332: ifnull +6 -> 338
    //   335: goto +7 -> 342
    //   338: ldc_w 602
    //   341: ireturn
    //   342: putfield 606	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   345: aload_3
    //   346: aload_1
    //   347: putfield 585	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   350: aload_3
    //   351: iconst_1
    //   352: putfield 588	gnu/mapping/CallContext:pc	I
    //   355: iconst_0
    //   356: ireturn
    //   357: aload_3
    //   358: aload_2
    //   359: ldc 14
    //   361: invokestatic 598	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   364: dup
    //   365: invokestatic 609	gnu/kawa/io/FilePath:coerceToFilePathOrNull	(Ljava/lang/Object;)Lgnu/kawa/io/FilePath;
    //   368: ifnull +6 -> 374
    //   371: goto +7 -> 378
    //   374: ldc_w 602
    //   377: ireturn
    //   378: putfield 606	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   381: aload_3
    //   382: aload_1
    //   383: putfield 585	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   386: aload_3
    //   387: iconst_1
    //   388: putfield 588	gnu/mapping/CallContext:pc	I
    //   391: iconst_0
    //   392: ireturn
    //   393: aload_3
    //   394: aload_2
    //   395: ldc 14
    //   397: invokestatic 598	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   400: dup
    //   401: invokestatic 609	gnu/kawa/io/FilePath:coerceToFilePathOrNull	(Ljava/lang/Object;)Lgnu/kawa/io/FilePath;
    //   404: ifnull +6 -> 410
    //   407: goto +7 -> 414
    //   410: ldc_w 602
    //   413: ireturn
    //   414: putfield 606	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   417: aload_3
    //   418: aload_1
    //   419: putfield 585	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   422: aload_3
    //   423: iconst_1
    //   424: putfield 588	gnu/mapping/CallContext:pc	I
    //   427: iconst_0
    //   428: ireturn
    //   429: aload_3
    //   430: aload_2
    //   431: ldc 14
    //   433: invokestatic 598	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   436: dup
    //   437: invokestatic 609	gnu/kawa/io/FilePath:coerceToFilePathOrNull	(Ljava/lang/Object;)Lgnu/kawa/io/FilePath;
    //   440: ifnull +6 -> 446
    //   443: goto +7 -> 450
    //   446: ldc_w 602
    //   449: ireturn
    //   450: putfield 606	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   453: aload_3
    //   454: aload_1
    //   455: putfield 585	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   458: aload_3
    //   459: iconst_1
    //   460: putfield 588	gnu/mapping/CallContext:pc	I
    //   463: iconst_0
    //   464: ireturn
    //   465: aload_3
    //   466: aload_2
    //   467: ldc 12
    //   469: invokestatic 598	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   472: dup
    //   473: invokestatic 601	gnu/kawa/io/Path:coerceToPathOrNull	(Ljava/lang/Object;)Lgnu/kawa/io/Path;
    //   476: ifnull +6 -> 482
    //   479: goto +7 -> 486
    //   482: ldc_w 602
    //   485: ireturn
    //   486: putfield 606	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   489: aload_3
    //   490: aload_1
    //   491: putfield 585	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   494: aload_3
    //   495: iconst_1
    //   496: putfield 588	gnu/mapping/CallContext:pc	I
    //   499: iconst_0
    //   500: ireturn
    //   501: aload_3
    //   502: aload_2
    //   503: ldc 12
    //   505: invokestatic 598	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   508: dup
    //   509: invokestatic 601	gnu/kawa/io/Path:coerceToPathOrNull	(Ljava/lang/Object;)Lgnu/kawa/io/Path;
    //   512: ifnull +6 -> 518
    //   515: goto +7 -> 522
    //   518: ldc_w 602
    //   521: ireturn
    //   522: putfield 606	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   525: aload_3
    //   526: aload_1
    //   527: putfield 585	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   530: aload_3
    //   531: iconst_1
    //   532: putfield 588	gnu/mapping/CallContext:pc	I
    //   535: iconst_0
    //   536: ireturn
    //   537: aload_3
    //   538: aload_2
    //   539: ldc 12
    //   541: invokestatic 598	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   544: dup
    //   545: invokestatic 601	gnu/kawa/io/Path:coerceToPathOrNull	(Ljava/lang/Object;)Lgnu/kawa/io/Path;
    //   548: ifnull +6 -> 554
    //   551: goto +7 -> 558
    //   554: ldc_w 602
    //   557: ireturn
    //   558: putfield 606	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   561: aload_3
    //   562: aload_1
    //   563: putfield 585	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   566: aload_3
    //   567: iconst_1
    //   568: putfield 588	gnu/mapping/CallContext:pc	I
    //   571: iconst_0
    //   572: ireturn
    //   573: aload_3
    //   574: aload_2
    //   575: ldc 12
    //   577: invokestatic 598	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   580: dup
    //   581: invokestatic 601	gnu/kawa/io/Path:coerceToPathOrNull	(Ljava/lang/Object;)Lgnu/kawa/io/Path;
    //   584: ifnull +6 -> 590
    //   587: goto +7 -> 594
    //   590: ldc_w 602
    //   593: ireturn
    //   594: putfield 606	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   597: aload_3
    //   598: aload_1
    //   599: putfield 585	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   602: aload_3
    //   603: iconst_1
    //   604: putfield 588	gnu/mapping/CallContext:pc	I
    //   607: iconst_0
    //   608: ireturn
    //   609: aload_3
    //   610: aload_2
    //   611: ldc 12
    //   613: invokestatic 598	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   616: dup
    //   617: invokestatic 601	gnu/kawa/io/Path:coerceToPathOrNull	(Ljava/lang/Object;)Lgnu/kawa/io/Path;
    //   620: ifnull +6 -> 626
    //   623: goto +7 -> 630
    //   626: ldc_w 602
    //   629: ireturn
    //   630: putfield 606	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   633: aload_3
    //   634: aload_1
    //   635: putfield 585	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   638: aload_3
    //   639: iconst_1
    //   640: putfield 588	gnu/mapping/CallContext:pc	I
    //   643: iconst_0
    //   644: ireturn
    //   645: aload_3
    //   646: aload_2
    //   647: ldc 12
    //   649: invokestatic 598	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   652: dup
    //   653: invokestatic 601	gnu/kawa/io/Path:coerceToPathOrNull	(Ljava/lang/Object;)Lgnu/kawa/io/Path;
    //   656: ifnull +6 -> 662
    //   659: goto +7 -> 666
    //   662: ldc_w 602
    //   665: ireturn
    //   666: putfield 606	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   669: aload_3
    //   670: aload_1
    //   671: putfield 585	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   674: aload_3
    //   675: iconst_1
    //   676: putfield 588	gnu/mapping/CallContext:pc	I
    //   679: iconst_0
    //   680: ireturn
    //   681: aload_3
    //   682: aload_2
    //   683: ldc 12
    //   685: invokestatic 598	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   688: dup
    //   689: invokestatic 601	gnu/kawa/io/Path:coerceToPathOrNull	(Ljava/lang/Object;)Lgnu/kawa/io/Path;
    //   692: ifnull +6 -> 698
    //   695: goto +7 -> 702
    //   698: ldc_w 602
    //   701: ireturn
    //   702: putfield 606	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   705: aload_3
    //   706: aload_1
    //   707: putfield 585	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   710: aload_3
    //   711: iconst_1
    //   712: putfield 588	gnu/mapping/CallContext:pc	I
    //   715: iconst_0
    //   716: ireturn
    //   717: aload_3
    //   718: aload_2
    //   719: ldc 12
    //   721: invokestatic 598	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   724: dup
    //   725: invokestatic 601	gnu/kawa/io/Path:coerceToPathOrNull	(Ljava/lang/Object;)Lgnu/kawa/io/Path;
    //   728: ifnull +6 -> 734
    //   731: goto +7 -> 738
    //   734: ldc_w 602
    //   737: ireturn
    //   738: putfield 606	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   741: aload_3
    //   742: aload_1
    //   743: putfield 585	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   746: aload_3
    //   747: iconst_1
    //   748: putfield 588	gnu/mapping/CallContext:pc	I
    //   751: iconst_0
    //   752: ireturn
    //   753: aload_3
    //   754: aload_2
    //   755: ldc 12
    //   757: invokestatic 598	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   760: dup
    //   761: invokestatic 601	gnu/kawa/io/Path:coerceToPathOrNull	(Ljava/lang/Object;)Lgnu/kawa/io/Path;
    //   764: ifnull +6 -> 770
    //   767: goto +7 -> 774
    //   770: ldc_w 602
    //   773: ireturn
    //   774: putfield 606	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   777: aload_3
    //   778: aload_1
    //   779: putfield 585	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   782: aload_3
    //   783: iconst_1
    //   784: putfield 588	gnu/mapping/CallContext:pc	I
    //   787: iconst_0
    //   788: ireturn
    //   789: aload_3
    //   790: aload_2
    //   791: ldc 12
    //   793: invokestatic 598	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   796: dup
    //   797: invokestatic 601	gnu/kawa/io/Path:coerceToPathOrNull	(Ljava/lang/Object;)Lgnu/kawa/io/Path;
    //   800: ifnull +6 -> 806
    //   803: goto +7 -> 810
    //   806: ldc_w 602
    //   809: ireturn
    //   810: putfield 606	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   813: aload_3
    //   814: aload_1
    //   815: putfield 585	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   818: aload_3
    //   819: iconst_1
    //   820: putfield 588	gnu/mapping/CallContext:pc	I
    //   823: iconst_0
    //   824: ireturn
    //   825: aload_3
    //   826: aload_2
    //   827: ldc 12
    //   829: invokestatic 598	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   832: dup
    //   833: invokestatic 601	gnu/kawa/io/Path:coerceToPathOrNull	(Ljava/lang/Object;)Lgnu/kawa/io/Path;
    //   836: ifnull +6 -> 842
    //   839: goto +7 -> 846
    //   842: ldc_w 602
    //   845: ireturn
    //   846: putfield 606	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   849: aload_3
    //   850: aload_1
    //   851: putfield 585	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   854: aload_3
    //   855: iconst_1
    //   856: putfield 588	gnu/mapping/CallContext:pc	I
    //   859: iconst_0
    //   860: ireturn
    //   861: aload_3
    //   862: aload_2
    //   863: ldc 12
    //   865: invokestatic 598	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   868: dup
    //   869: invokestatic 601	gnu/kawa/io/Path:coerceToPathOrNull	(Ljava/lang/Object;)Lgnu/kawa/io/Path;
    //   872: ifnull +6 -> 878
    //   875: goto +7 -> 882
    //   878: ldc_w 602
    //   881: ireturn
    //   882: putfield 606	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   885: aload_3
    //   886: aload_1
    //   887: putfield 585	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   890: aload_3
    //   891: iconst_1
    //   892: putfield 588	gnu/mapping/CallContext:pc	I
    //   895: iconst_0
    //   896: ireturn
    //   897: aload_3
    //   898: aload_2
    //   899: ldc 12
    //   901: invokestatic 598	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   904: dup
    //   905: invokestatic 601	gnu/kawa/io/Path:coerceToPathOrNull	(Ljava/lang/Object;)Lgnu/kawa/io/Path;
    //   908: ifnull +6 -> 914
    //   911: goto +7 -> 918
    //   914: ldc_w 602
    //   917: ireturn
    //   918: putfield 606	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   921: aload_3
    //   922: aload_1
    //   923: putfield 585	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   926: aload_3
    //   927: iconst_1
    //   928: putfield 588	gnu/mapping/CallContext:pc	I
    //   931: iconst_0
    //   932: ireturn
    //   933: aload_3
    //   934: aload_2
    //   935: ldc 12
    //   937: invokestatic 598	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   940: dup
    //   941: invokestatic 601	gnu/kawa/io/Path:coerceToPathOrNull	(Ljava/lang/Object;)Lgnu/kawa/io/Path;
    //   944: ifnull +6 -> 950
    //   947: goto +7 -> 954
    //   950: ldc_w 602
    //   953: ireturn
    //   954: putfield 606	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   957: aload_3
    //   958: aload_1
    //   959: putfield 585	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   962: aload_3
    //   963: iconst_1
    //   964: putfield 588	gnu/mapping/CallContext:pc	I
    //   967: iconst_0
    //   968: ireturn
    //   969: aload_3
    //   970: aload_2
    //   971: ldc 12
    //   973: invokestatic 598	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   976: dup
    //   977: invokestatic 601	gnu/kawa/io/Path:coerceToPathOrNull	(Ljava/lang/Object;)Lgnu/kawa/io/Path;
    //   980: ifnull +6 -> 986
    //   983: goto +7 -> 990
    //   986: ldc_w 602
    //   989: ireturn
    //   990: putfield 606	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   993: aload_3
    //   994: aload_1
    //   995: putfield 585	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   998: aload_3
    //   999: iconst_1
    //   1000: putfield 588	gnu/mapping/CallContext:pc	I
    //   1003: iconst_0
    //   1004: ireturn
    //   1005: aload_3
    //   1006: aload_2
    //   1007: putfield 606	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   1010: aload_3
    //   1011: aload_1
    //   1012: putfield 585	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   1015: aload_3
    //   1016: iconst_1
    //   1017: putfield 588	gnu/mapping/CallContext:pc	I
    //   1020: iconst_0
    //   1021: ireturn
    //   1022: aload_3
    //   1023: aload_2
    //   1024: putfield 606	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   1027: aload_3
    //   1028: aload_1
    //   1029: putfield 585	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   1032: aload_3
    //   1033: iconst_1
    //   1034: putfield 588	gnu/mapping/CallContext:pc	I
    //   1037: iconst_0
    //   1038: ireturn
    //   1039: aload_3
    //   1040: aload_2
    //   1041: putfield 606	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   1044: aload_3
    //   1045: aload_1
    //   1046: putfield 585	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   1049: aload_3
    //   1050: iconst_1
    //   1051: putfield 588	gnu/mapping/CallContext:pc	I
    //   1054: iconst_0
    //   1055: ireturn
    //   1056: aload_0
    //   1057: aload_1
    //   1058: aload_2
    //   1059: aload_3
    //   1060: invokespecial 613	gnu/expr/ModuleBody:match1	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Lgnu/mapping/CallContext;)I
    //   1063: ireturn
    // Line number table:
    //   Java source line #82	-> byte code offset #160
    //   Java source line #67	-> byte code offset #196
    //   Java source line #161	-> byte code offset #232
    //   Java source line #140	-> byte code offset #268
    //   Java source line #132	-> byte code offset #285
    //   Java source line #128	-> byte code offset #321
    //   Java source line #112	-> byte code offset #357
    //   Java source line #106	-> byte code offset #393
    //   Java source line #103	-> byte code offset #429
    //   Java source line #100	-> byte code offset #465
    //   Java source line #97	-> byte code offset #501
    //   Java source line #46	-> byte code offset #537
    //   Java source line #43	-> byte code offset #573
    //   Java source line #41	-> byte code offset #609
    //   Java source line #38	-> byte code offset #645
    //   Java source line #35	-> byte code offset #681
    //   Java source line #32	-> byte code offset #717
    //   Java source line #29	-> byte code offset #753
    //   Java source line #26	-> byte code offset #789
    //   Java source line #24	-> byte code offset #825
    //   Java source line #21	-> byte code offset #861
    //   Java source line #18	-> byte code offset #897
    //   Java source line #15	-> byte code offset #933
    //   Java source line #13	-> byte code offset #969
    //   Java source line #11	-> byte code offset #1005
    //   Java source line #9	-> byte code offset #1022
    //   Java source line #7	-> byte code offset #1039
  }
  
  /* Error */
  public int match2(gnu.expr.ModuleMethod arg1, Object arg2, Object arg3, gnu.mapping.CallContext arg4)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 581	gnu/expr/ModuleMethod:selector	I
    //   4: lookupswitch	default:+406->410, 18:+342->346, 19:+297->301, 20:+252->256, 27:+188->192, 28:+124->128, 34:+60->64
    //   64: aload 4
    //   66: aload_2
    //   67: ldc 12
    //   69: invokestatic 598	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   72: dup
    //   73: invokestatic 601	gnu/kawa/io/Path:coerceToPathOrNull	(Ljava/lang/Object;)Lgnu/kawa/io/Path;
    //   76: ifnull +6 -> 82
    //   79: goto +7 -> 86
    //   82: ldc_w 602
    //   85: ireturn
    //   86: putfield 606	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   89: aload 4
    //   91: aload_3
    //   92: ldc 12
    //   94: invokestatic 598	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   97: dup
    //   98: invokestatic 601	gnu/kawa/io/Path:coerceToPathOrNull	(Ljava/lang/Object;)Lgnu/kawa/io/Path;
    //   101: ifnull +6 -> 107
    //   104: goto +7 -> 111
    //   107: ldc_w 614
    //   110: ireturn
    //   111: putfield 617	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   114: aload 4
    //   116: aload_1
    //   117: putfield 585	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   120: aload 4
    //   122: iconst_2
    //   123: putfield 588	gnu/mapping/CallContext:pc	I
    //   126: iconst_0
    //   127: ireturn
    //   128: aload 4
    //   130: aload_2
    //   131: ldc 12
    //   133: invokestatic 598	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   136: dup
    //   137: invokestatic 601	gnu/kawa/io/Path:coerceToPathOrNull	(Ljava/lang/Object;)Lgnu/kawa/io/Path;
    //   140: ifnull +6 -> 146
    //   143: goto +7 -> 150
    //   146: ldc_w 602
    //   149: ireturn
    //   150: putfield 606	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   153: aload 4
    //   155: aload_3
    //   156: ldc 12
    //   158: invokestatic 598	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   161: dup
    //   162: invokestatic 601	gnu/kawa/io/Path:coerceToPathOrNull	(Ljava/lang/Object;)Lgnu/kawa/io/Path;
    //   165: ifnull +6 -> 171
    //   168: goto +7 -> 175
    //   171: ldc_w 614
    //   174: ireturn
    //   175: putfield 617	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   178: aload 4
    //   180: aload_1
    //   181: putfield 585	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   184: aload 4
    //   186: iconst_2
    //   187: putfield 588	gnu/mapping/CallContext:pc	I
    //   190: iconst_0
    //   191: ireturn
    //   192: aload 4
    //   194: aload_2
    //   195: ldc 14
    //   197: invokestatic 598	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   200: dup
    //   201: invokestatic 609	gnu/kawa/io/FilePath:coerceToFilePathOrNull	(Ljava/lang/Object;)Lgnu/kawa/io/FilePath;
    //   204: ifnull +6 -> 210
    //   207: goto +7 -> 214
    //   210: ldc_w 602
    //   213: ireturn
    //   214: putfield 606	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   217: aload 4
    //   219: aload_3
    //   220: ldc 14
    //   222: invokestatic 598	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   225: dup
    //   226: invokestatic 609	gnu/kawa/io/FilePath:coerceToFilePathOrNull	(Ljava/lang/Object;)Lgnu/kawa/io/FilePath;
    //   229: ifnull +6 -> 235
    //   232: goto +7 -> 239
    //   235: ldc_w 614
    //   238: ireturn
    //   239: putfield 617	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   242: aload 4
    //   244: aload_1
    //   245: putfield 585	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   248: aload 4
    //   250: iconst_2
    //   251: putfield 588	gnu/mapping/CallContext:pc	I
    //   254: iconst_0
    //   255: ireturn
    //   256: aload 4
    //   258: aload_2
    //   259: ldc 14
    //   261: invokestatic 598	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   264: dup
    //   265: invokestatic 609	gnu/kawa/io/FilePath:coerceToFilePathOrNull	(Ljava/lang/Object;)Lgnu/kawa/io/FilePath;
    //   268: ifnull +6 -> 274
    //   271: goto +7 -> 278
    //   274: ldc_w 602
    //   277: ireturn
    //   278: putfield 606	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   281: aload 4
    //   283: aload_3
    //   284: putfield 617	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   287: aload 4
    //   289: aload_1
    //   290: putfield 585	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   293: aload 4
    //   295: iconst_2
    //   296: putfield 588	gnu/mapping/CallContext:pc	I
    //   299: iconst_0
    //   300: ireturn
    //   301: aload 4
    //   303: aload_2
    //   304: ldc 12
    //   306: invokestatic 598	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   309: dup
    //   310: invokestatic 601	gnu/kawa/io/Path:coerceToPathOrNull	(Ljava/lang/Object;)Lgnu/kawa/io/Path;
    //   313: ifnull +6 -> 319
    //   316: goto +7 -> 323
    //   319: ldc_w 602
    //   322: ireturn
    //   323: putfield 606	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   326: aload 4
    //   328: aload_3
    //   329: putfield 617	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   332: aload 4
    //   334: aload_1
    //   335: putfield 585	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   338: aload 4
    //   340: iconst_2
    //   341: putfield 588	gnu/mapping/CallContext:pc	I
    //   344: iconst_0
    //   345: ireturn
    //   346: aload 4
    //   348: aload_2
    //   349: ldc 12
    //   351: invokestatic 598	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   354: dup
    //   355: invokestatic 601	gnu/kawa/io/Path:coerceToPathOrNull	(Ljava/lang/Object;)Lgnu/kawa/io/Path;
    //   358: ifnull +6 -> 364
    //   361: goto +7 -> 368
    //   364: ldc_w 602
    //   367: ireturn
    //   368: putfield 606	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   371: aload 4
    //   373: aload_3
    //   374: ldc 84
    //   376: invokestatic 598	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   379: dup
    //   380: instanceof 84
    //   383: ifeq +6 -> 389
    //   386: goto +7 -> 393
    //   389: ldc_w 614
    //   392: ireturn
    //   393: putfield 617	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   396: aload 4
    //   398: aload_1
    //   399: putfield 585	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   402: aload 4
    //   404: iconst_2
    //   405: putfield 588	gnu/mapping/CallContext:pc	I
    //   408: iconst_0
    //   409: ireturn
    //   410: aload_0
    //   411: aload_1
    //   412: aload_2
    //   413: aload_3
    //   414: aload 4
    //   416: invokespecial 621	gnu/expr/ModuleBody:match2	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;Lgnu/mapping/CallContext;)I
    //   419: ireturn
    // Line number table:
    //   Java source line #157	-> byte code offset #64
    //   Java source line #118	-> byte code offset #128
    //   Java source line #115	-> byte code offset #192
    //   Java source line #75	-> byte code offset #256
    //   Java source line #70	-> byte code offset #301
    //   Java source line #62	-> byte code offset #346
  }
  
  public void apply(gnu.mapping.CallContext paramCallContext)
  {
    gnu.expr.ModuleMethod.applyError();
  }
  
  /* Error */
  public Object apply2(gnu.expr.ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 581	gnu/expr/ModuleMethod:selector	I
    //   4: lookupswitch	default:+200->204, 18:+60->64, 19:+85->89, 20:+102->106, 27:+119->123, 28:+153->157, 34:+178->182
    //   64: aload_2
    //   65: ldc 12
    //   67: invokestatic 598	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   70: invokestatic 182	gnu/kawa/io/Path:valueOf	(Ljava/lang/Object;)Lgnu/kawa/io/Path;
    //   73: aload_3
    //   74: ldc 84
    //   76: invokestatic 598	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   79: invokestatic 794	gnu/kawa/lispexpr/LangObjType:coerceToU8Vector	(Ljava/lang/Object;)Lgnu/lists/U8Vector;
    //   82: invokestatic 798	kawa/lib/files:lambda1	(Lgnu/kawa/io/Path;Lgnu/lists/U8Vector;)V
    //   85: getstatic 758	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   88: areturn
    //   89: aload_2
    //   90: ldc 12
    //   92: invokestatic 598	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   95: invokestatic 182	gnu/kawa/io/Path:valueOf	(Ljava/lang/Object;)Lgnu/kawa/io/Path;
    //   98: aload_3
    //   99: invokestatic 804	kawa/lib/files:pathDataSetter	(Lgnu/kawa/io/Path;Ljava/lang/Object;)V
    //   102: getstatic 758	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   105: areturn
    //   106: aload_2
    //   107: ldc 14
    //   109: invokestatic 598	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   112: invokestatic 263	gnu/kawa/io/FilePath:makeFilePath	(Ljava/lang/Object;)Lgnu/kawa/io/FilePath;
    //   115: aload_3
    //   116: invokestatic 810	kawa/lib/files:pathDataAppender	(Lgnu/kawa/io/FilePath;Ljava/lang/Object;)V
    //   119: getstatic 758	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   122: areturn
    //   123: aload_2
    //   124: ldc 14
    //   126: invokestatic 598	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   129: invokestatic 263	gnu/kawa/io/FilePath:makeFilePath	(Ljava/lang/Object;)Lgnu/kawa/io/FilePath;
    //   132: aload_3
    //   133: ldc 14
    //   135: invokestatic 598	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   138: invokestatic 263	gnu/kawa/io/FilePath:makeFilePath	(Ljava/lang/Object;)Lgnu/kawa/io/FilePath;
    //   141: invokestatic 816	kawa/lib/files:renameFile	(Lgnu/kawa/io/FilePath;Lgnu/kawa/io/FilePath;)Z
    //   144: ifeq +9 -> 153
    //   147: getstatic 640	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   150: goto +6 -> 156
    //   153: getstatic 30	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   156: areturn
    //   157: aload_2
    //   158: ldc 12
    //   160: invokestatic 598	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   163: invokestatic 182	gnu/kawa/io/Path:valueOf	(Ljava/lang/Object;)Lgnu/kawa/io/Path;
    //   166: aload_3
    //   167: ldc 12
    //   169: invokestatic 598	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   172: invokestatic 182	gnu/kawa/io/Path:valueOf	(Ljava/lang/Object;)Lgnu/kawa/io/Path;
    //   175: invokestatic 822	kawa/lib/files:copyFile	(Lgnu/kawa/io/Path;Lgnu/kawa/io/Path;)V
    //   178: getstatic 758	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   181: areturn
    //   182: aload_2
    //   183: ldc 12
    //   185: invokestatic 598	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   188: invokestatic 182	gnu/kawa/io/Path:valueOf	(Ljava/lang/Object;)Lgnu/kawa/io/Path;
    //   191: aload_3
    //   192: ldc 12
    //   194: invokestatic 598	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   197: invokestatic 182	gnu/kawa/io/Path:valueOf	(Ljava/lang/Object;)Lgnu/kawa/io/Path;
    //   200: invokestatic 828	kawa/lib/files:resolveUri	(Lgnu/kawa/io/Path;Lgnu/kawa/io/Path;)Lgnu/kawa/io/Path;
    //   203: areturn
    //   204: aload_0
    //   205: aload_1
    //   206: aload_2
    //   207: aload_3
    //   208: invokespecial 831	gnu/expr/ModuleBody:apply2	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   211: areturn
    //   212: new 649	gnu/mapping/WrongType
    //   215: dup_x1
    //   216: swap
    //   217: ldc_w 788
    //   220: iconst_1
    //   221: aload_2
    //   222: invokespecial 654	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   225: athrow
    //   226: new 649	gnu/mapping/WrongType
    //   229: dup_x1
    //   230: swap
    //   231: ldc_w 788
    //   234: iconst_2
    //   235: aload_3
    //   236: invokespecial 654	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   239: athrow
    //   240: new 649	gnu/mapping/WrongType
    //   243: dup_x1
    //   244: swap
    //   245: ldc_w 800
    //   248: iconst_1
    //   249: aload_2
    //   250: invokespecial 654	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   253: athrow
    //   254: new 649	gnu/mapping/WrongType
    //   257: dup_x1
    //   258: swap
    //   259: ldc_w 806
    //   262: iconst_1
    //   263: aload_2
    //   264: invokespecial 654	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   267: athrow
    //   268: new 649	gnu/mapping/WrongType
    //   271: dup_x1
    //   272: swap
    //   273: ldc_w 812
    //   276: iconst_1
    //   277: aload_2
    //   278: invokespecial 654	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   281: athrow
    //   282: new 649	gnu/mapping/WrongType
    //   285: dup_x1
    //   286: swap
    //   287: ldc_w 812
    //   290: iconst_2
    //   291: aload_3
    //   292: invokespecial 654	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   295: athrow
    //   296: new 649	gnu/mapping/WrongType
    //   299: dup_x1
    //   300: swap
    //   301: ldc_w 818
    //   304: iconst_1
    //   305: aload_2
    //   306: invokespecial 654	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   309: athrow
    //   310: new 649	gnu/mapping/WrongType
    //   313: dup_x1
    //   314: swap
    //   315: ldc_w 818
    //   318: iconst_2
    //   319: aload_3
    //   320: invokespecial 654	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   323: athrow
    //   324: new 649	gnu/mapping/WrongType
    //   327: dup_x1
    //   328: swap
    //   329: ldc_w 824
    //   332: iconst_1
    //   333: aload_2
    //   334: invokespecial 654	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   337: athrow
    //   338: new 649	gnu/mapping/WrongType
    //   341: dup_x1
    //   342: swap
    //   343: ldc_w 824
    //   346: iconst_2
    //   347: aload_3
    //   348: invokespecial 654	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   351: athrow
    // Line number table:
    //   Java source line #62	-> byte code offset #64
    //   Java source line #70	-> byte code offset #89
    //   Java source line #75	-> byte code offset #106
    //   Java source line #115	-> byte code offset #123
    //   Java source line #118	-> byte code offset #157
    //   Java source line #157	-> byte code offset #182
    //   Java source line #62	-> byte code offset #212
    //   Java source line #70	-> byte code offset #240
    //   Java source line #75	-> byte code offset #254
    //   Java source line #115	-> byte code offset #268
    //   Java source line #118	-> byte code offset #296
    //   Java source line #157	-> byte code offset #324
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	352	0	this	files
    //   0	352	1	paramModuleMethod	gnu.expr.ModuleMethod
    //   0	352	2	paramObject1	Object
    //   0	352	3	paramObject2	Object
    //   212	1	4	localClassCastException1	ClassCastException
    //   226	1	5	localClassCastException2	ClassCastException
    //   240	1	6	localClassCastException3	ClassCastException
    //   254	1	7	localClassCastException4	ClassCastException
    //   268	1	8	localClassCastException5	ClassCastException
    //   282	1	9	localClassCastException6	ClassCastException
    //   296	1	10	localClassCastException7	ClassCastException
    //   310	1	11	localClassCastException8	ClassCastException
    //   324	1	12	localClassCastException9	ClassCastException
    //   338	1	13	localClassCastException10	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   70	73	212	java/lang/ClassCastException
    //   79	82	226	java/lang/ClassCastException
    //   95	98	240	java/lang/ClassCastException
    //   112	115	254	java/lang/ClassCastException
    //   129	132	268	java/lang/ClassCastException
    //   138	141	282	java/lang/ClassCastException
    //   163	166	296	java/lang/ClassCastException
    //   172	175	310	java/lang/ClassCastException
    //   188	191	324	java/lang/ClassCastException
    //   197	200	338	java/lang/ClassCastException
  }
}
