package gnu.kawa.slib;

import gnu.expr.ModuleMethod;
import gnu.mapping.Symbol;

public class StreamsPrimitive extends gnu.expr.ModuleBody
{
  public static StreamPromise stream$Mnnull;
  public static final kawa.lang.Macro stream$Mncons;
  public static final ModuleMethod stream$Qu;
  public static final ModuleMethod stream$Mnnull$Qu;
  public static final gnu.kawa.reflect.StaticFieldLocation stream$Mntype;
  public static final ModuleMethod stream$Mnpair$Qu;
  public static final ModuleMethod stream$Mncar;
  public static final ModuleMethod stream$Mncdr;
  public static final kawa.lang.Macro stream$Mnlambda;
  public static final gnu.kawa.reflect.StaticFieldLocation $Prvt$StreamPair;
  public static final gnu.kawa.reflect.StaticFieldLocation $Prvt$stream$Mnlazy;
  public static final gnu.kawa.reflect.StaticFieldLocation $Prvt$stream$Mndelay;
  static final ModuleMethod lambda$Fn1;
  static final gnu.mapping.SimpleSymbol Lit0;
  static final gnu.mapping.SimpleSymbol Lit1;
  public static StreamsPrimitive $instance;
  static final gnu.mapping.SimpleSymbol Lit2;
  static final gnu.mapping.SimpleSymbol Lit3;
  static final gnu.mapping.SimpleSymbol Lit4;
  static final gnu.mapping.SimpleSymbol Lit5;
  static final kawa.lang.SyntaxRules Lit6;
  static final gnu.mapping.SimpleSymbol Lit7;
  static final kawa.lang.SyntaxRules Lit8;
  static final Object[] Lit9;
  static final gnu.mapping.SimpleSymbol Lit10 = Symbol.valueOf("stream-lazy"); static { Lit9 = new Object[0]; kawa.lang.SyntaxRule[] tmp27_24 = new kawa.lang.SyntaxRule[1]; Object[] tmp60_57 = new Object[3]; Object[] tmp61_60 = tmp60_57;tmp61_60[0] = Symbol.valueOf("lambda"); Object[] tmp70_61 = tmp61_60;tmp70_61[1] = Lit10;tmp70_61[2] = Symbol.valueOf("let");tmp27_24[0] = new kawa.lang.SyntaxRule(new kawa.lang.SyntaxPattern("\f\030\f\007\f\017\r\027\020\b\b", Lit9, 3, "StreamsPrimitive.scm:70"), "\001\001\003", "\021\030\004\t\003\b\021\030\f\b\021\030\024\t\020\t\013\b\025\023", tmp60_57, 1);Lit8 = new kawa.lang.SyntaxRules(Lit9, tmp27_24, 3, StreamsPrimitive.Lit7 = Symbol.valueOf("stream-lambda")); kawa.lang.SyntaxRule[] tmp117_114 = new kawa.lang.SyntaxRule[1]; Object[] tmp150_147 = new Object[3]; Object[] tmp151_150 = tmp150_147;tmp151_150[0] = Symbol.valueOf("StreamPair"); Object[] tmp159_151 = tmp151_150;tmp159_151[1] = Symbol.valueOf("stream-delay");tmp159_151[2] = Lit10;tmp117_114[0] = new kawa.lang.SyntaxRule(new kawa.lang.SyntaxPattern("\f\030\f\007\f\017\b", Lit9, 2, "StreamsPrimitive.scm:57"), "\001\001", "\021\030\004)\021\030\f\b\003\b\021\030\024\b\013", tmp150_147, 0);Lit6 = new kawa.lang.SyntaxRules(Lit9, tmp117_114, 2, StreamsPrimitive.Lit5 = Symbol.valueOf("stream-cons"));Lit4 = Symbol.valueOf("stream-null?");Lit3 = Symbol.valueOf("stream-pair?");Lit2 = Symbol.valueOf("stream?");Lit1 = Symbol.valueOf("stream-cdr");Lit0 = Symbol.valueOf("stream-car");$instance = new StreamsPrimitive();$Prvt$StreamPair = gnu.kawa.reflect.StaticFieldLocation.make("gnu.kawa.slib.StreamsType", "StreamPair");stream$Mntype = gnu.kawa.reflect.StaticFieldLocation.make("gnu.kawa.slib.StreamsType", "stream$Mntype");$Prvt$stream$Mnlazy = gnu.kawa.reflect.StaticFieldLocation.make("gnu.kawa.slib.StreamsType", "stream$Mnlazy");$Prvt$stream$Mndelay = gnu.kawa.reflect.StaticFieldLocation.make("gnu.kawa.slib.StreamsType", "stream$Mndelay");StreamsPrimitive localStreamsPrimitive = $instance;stream$Qu = new ModuleMethod(localStreamsPrimitive, 1, Lit2, 4097);lambda$Fn1 = new ModuleMethod(localStreamsPrimitive, 2, null, 0);stream$Mnpair$Qu = new ModuleMethod(localStreamsPrimitive, 3, Lit3, 4097);stream$Mnnull$Qu = new ModuleMethod(localStreamsPrimitive, 4, Lit4, 4097);stream$Mncons = kawa.lang.Macro.make(Lit5, Lit6, "gnu.kawa.slib.StreamsPrimitive");stream$Mncar = new ModuleMethod(localStreamsPrimitive, 5, Lit0, 4097);stream$Mncdr = new ModuleMethod(localStreamsPrimitive, 6, Lit1, 4097);
    
    stream$Mnlambda = kawa.lang.Macro.make(Lit7, Lit8, "gnu.kawa.slib.StreamsPrimitive");$runBody$();
  }
  

























  public int match1(ModuleMethod paramModuleMethod, Object paramObject, gnu.mapping.CallContext paramCallContext)
  {
    switch (selector) {case 6:  value1 = paramObject;proc = paramModuleMethod;pc = 1;return 0;
    case 5: 
      value1 = paramObject;proc = paramModuleMethod;pc = 1;return 0;
    case 4: 
      value1 = paramObject;proc = paramModuleMethod;pc = 1;return 0;
    case 3: 
      value1 = paramObject;proc = paramModuleMethod;pc = 1;return 0;
    case 1: 
      value1 = paramObject;proc = paramModuleMethod;pc = 1;return 0; } return super.match1(paramModuleMethod, paramObject, paramCallContext); }
  public static boolean isStream(Object value) { return value instanceof Stream; }
  
  private static void $runBody$()
  {
    ;
    gnu.lists.Consumer $result = getInstanceconsumer;
    










    stream$Mnnull = new StreamPromise(lambda$Fn1, false); }
  static StreamPromise lambda1() { return StreamsType.stream$Mnnull$Mn1; }
  
  public static boolean isStreamPair(Object obj) {
    boolean x = obj instanceof StreamPair;
    
    return (obj instanceof StreamPromise) ? isStreamPair(kawa.lib.misc.force(obj)) : x ? x : false;
  }
  
  public static boolean isStreamNull(Object obj) { boolean x = obj == StreamsType.stream$Mnnull$Mn1;
    
    Object v = ((gnu.mapping.Lazy)obj).getValue();
    return (obj instanceof gnu.mapping.Lazy) ? false : v != obj ? isStreamNull(v) : x ? x : false;
  }
  



  public static Object streamCar(Object strm)
  {
    if (isStreamNull(strm)) throw gnu.expr.Special.reachedUnexpected;
    try { return kawa.lib.misc.force(kawa.lib.lists.car((gnu.lists.Pair)(localObject = gnu.mapping.Promise.force(strm, gnu.lists.Pair.class)))); } catch (ClassCastException localClassCastException) { Object localObject; throw new gnu.mapping.WrongType(localClassCastException, "car", 1, localObject);
    }
  }
  
  public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
  {
    switch (selector) {case 1:  return isStream(paramObject) ? Boolean.TRUE : Boolean.FALSE;
    



    case 3: 
      return isStreamPair(paramObject) ? Boolean.TRUE : Boolean.FALSE;
    


    case 4: 
      return isStreamNull(paramObject) ? Boolean.TRUE : Boolean.FALSE;
    








    case 5: 
      return streamCar(paramObject);
    

    case 6: 
      return streamCdr(paramObject); } return super.apply1(paramModuleMethod, paramObject); }
  public static Object streamCdr(Object strm) { if (isStreamNull(strm)) throw gnu.expr.Special.reachedUnexpected;
    try { return kawa.lib.lists.cdr((gnu.lists.Pair)(localObject = gnu.mapping.Promise.force(strm, gnu.lists.Pair.class))); } catch (ClassCastException localClassCastException) { Object localObject; throw new gnu.mapping.WrongType(localClassCastException, "cdr", 1, localObject);
    }
  }
  
  public StreamsPrimitive()
  {
    gnu.expr.ModuleInfo.register(this);
  }
  
  public int match0(ModuleMethod paramModuleMethod, gnu.mapping.CallContext paramCallContext)
  {
    if (selector == 2)
    {
      proc = paramModuleMethod;
      pc = 0;
      return 0;
    }
    return super.match0(paramModuleMethod, paramCallContext);
  }
  
  public void apply(gnu.mapping.CallContext paramCallContext)
  {
    ModuleMethod.applyError();
  }
  
  public Object apply0(ModuleMethod paramModuleMethod)
  {
    if (selector == 2) {
      return lambda1();
    }
    return super.apply0(paramModuleMethod);
  }
}
