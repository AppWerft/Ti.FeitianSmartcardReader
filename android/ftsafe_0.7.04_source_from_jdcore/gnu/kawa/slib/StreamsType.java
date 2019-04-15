package gnu.kawa.slib;

import gnu.expr.ModuleMethod;

public class StreamsType extends gnu.expr.ModuleBody { public static final Class Stream;
  public static final Class StreamPromise;
  public static final Class StreamPair;
  public static final Class stream$Mntype;
  public static StreamPromise stream$Mnnull$Mn1;
  public static final kawa.lang.Macro stream$Mnlazy;
  public static final kawa.lang.Macro stream$Mndelay;
  public static final ModuleMethod stream$Mnforce;
  public static final ModuleMethod stream$Mneager;
  public static StreamsType $instance;
  static final gnu.mapping.SimpleSymbol Lit0; static final kawa.lang.SyntaxRules Lit1; static final gnu.mapping.SimpleSymbol Lit2; static final kawa.lang.SyntaxRules Lit3; static final gnu.mapping.SimpleSymbol Lit4; static final gnu.mapping.SimpleSymbol Lit5;
  static { Lit7 = gnu.mapping.Symbol.valueOf("StreamPromise");Lit6 = new Object[0];Lit5 = gnu.mapping.Symbol.valueOf("stream-eager");Lit4 = gnu.mapping.Symbol.valueOf("stream-force"); kawa.lang.SyntaxRule[] tmp50_47 = new kawa.lang.SyntaxRule[1]; Object[] tmp79_76 = new Object[3]; Object[] tmp80_79 = tmp79_76;tmp80_79[0] = Lit7; Object[] tmp86_80 = tmp80_79;tmp86_80[1] = Lit8;tmp86_80[2] = gnu.lists.PairWithPosition.make(Boolean.FALSE, gnu.lists.LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/StreamsType.scm", 127015);tmp50_47[0] = new kawa.lang.SyntaxRule(new kawa.lang.SyntaxPattern("\f\030\f\007\b", Lit6, 1, "StreamsType.scm:30"), "\001", "\021\030\0049\021\030\f\t\020\b\003\030\024", tmp79_76, 0);Lit3 = new kawa.lang.SyntaxRules(Lit6, tmp50_47, 1, StreamsType.Lit2 = gnu.mapping.Symbol.valueOf("stream-delay")); kawa.lang.SyntaxRule[] tmp139_136 = new kawa.lang.SyntaxRule[1]; Object[] tmp168_165 = new Object[3]; Object[] tmp169_168 = tmp168_165;tmp169_168[0] = Lit7; Object[] tmp175_169 = tmp169_168;tmp175_169[1] = Lit8;tmp175_169[2] = gnu.lists.PairWithPosition.make(Boolean.TRUE, gnu.lists.LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/StreamsType.scm", 106534);tmp139_136[0] = new kawa.lang.SyntaxRule(new kawa.lang.SyntaxPattern("\f\030\f\007\b", Lit6, 1, "StreamsType.scm:25"), "\001", "\021\030\0049\021\030\f\t\020\b\003\030\024", tmp168_165, 0);Lit1 = new kawa.lang.SyntaxRules(Lit6, tmp139_136, 1, StreamsType.Lit0 = gnu.mapping.Symbol.valueOf("stream-lazy"));$instance = new StreamsType();Stream = Stream.class;StreamPromise = StreamPromise.class;StreamPair = StreamPair.class;stream$Mntype = Stream.class;stream$Mnlazy = kawa.lang.Macro.make(Lit0, Lit1, "gnu.kawa.slib.StreamsType");stream$Mndelay = kawa.lang.Macro.make(Lit2, Lit3, "gnu.kawa.slib.StreamsType");StreamsType localStreamsType = $instance;stream$Mnforce = new ModuleMethod(localStreamsType, 1, Lit4, 4097);stream$Mneager = new ModuleMethod(localStreamsType, 2, Lit5, 4097);$runBody$(); } static final Object[] Lit6; static final gnu.mapping.SimpleSymbol Lit7; static final gnu.mapping.SimpleSymbol Lit8 = gnu.mapping.Symbol.valueOf("lambda");
  
  private static void $runBody$()
  {
    ;
    gnu.lists.Consumer $result = getInstanceconsumer;
    














    StreamPromise p = new StreamPromise();
    p.setValue(gnu.lists.LList.Empty);
    stream$Mnnull$Mn1 = p;
  }
  










  public int match1(ModuleMethod paramModuleMethod, Object paramObject, gnu.mapping.CallContext paramCallContext)
  {
    switch (selector) {case 2:  value1 = paramObject;proc = paramModuleMethod;pc = 1;return 0;
    case 1: 
      value1 = paramObject;proc = paramModuleMethod;pc = 1;return 0; } return super.match1(paramModuleMethod, paramObject, paramCallContext); }
  public static Object streamForce(Object promise) { return kawa.lib.misc.force(promise);
  }
  
  public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
  {
    switch (selector) {case 1:  return streamForce(paramObject);
    
    case 2: 
      return streamEager(paramObject); } return super.apply1(paramModuleMethod, paramObject); }
  public static Object streamEager(Object expr) { return expr; }
  
  public StreamsType()
  {
    gnu.expr.ModuleInfo.register(this);
  }
  
  public void apply(gnu.mapping.CallContext paramCallContext)
  {
    ModuleMethod.applyError();
  }
}
