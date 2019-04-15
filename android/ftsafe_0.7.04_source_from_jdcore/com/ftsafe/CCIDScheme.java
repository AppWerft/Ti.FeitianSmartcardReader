package com.ftsafe;

import gnu.expr.ModuleMethod;

public class CCIDScheme {
  public com.ftsafe.readerScheme.FTReaderInf mFTReaderInf;
  public android.os.Handler mHandler;
  public static final ModuleMethod list$Mn$Gru8vector;
  public static final ModuleMethod u8vector$Mn$Grlist;
  public static final ModuleMethod make$Mnu8vector;
  public static final ModuleMethod object$Mn$Grstring;
  public static final ModuleMethod slice;
  public static final ModuleMethod build$Mndword$Mnfromlst;
  public static final ModuleMethod build$Mndword$Mninlst;
  public static final ModuleMethod build$Mnword$Mnfromlst;
  public static final ModuleMethod build$Mnword$Mninlst;
  public static final ModuleMethod make$Mncounter;
  
  public static gnu.bytecode.Type.NeverReturns GET_DEVICES_INF_default$V(Object[] argsArray) {
    ;
    throw gnu.expr.Special.reachedUnexpected; }
  
  static gnu.bytecode.Type.NeverReturns lambda46$V(Object[] argsArray) { ; throw gnu.expr.Special.reachedUnexpected; }
  static gnu.bytecode.Type.NeverReturns lambda47$V(Object[] argsArray) { ; throw gnu.expr.Special.reachedUnexpected; }
  static gnu.bytecode.Type.NeverReturns lambda48$V(Object[] argsArray) { ; throw gnu.expr.Special.reachedUnexpected; }
  static gnu.bytecode.Type.NeverReturns lambda49$V(Object[] argsArray) { ; throw gnu.expr.Special.reachedUnexpected; }
  static gnu.bytecode.Type.NeverReturns lambda50$V(Object[] argsArray) { ; throw gnu.expr.Special.reachedUnexpected;
  }
  
  private static void $runBody$()
  {
    ;
    gnu.lists.Consumer $result = getInstanceconsumer;
    















































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































    pp = lambda$Fn3;
    


















































































































































    descriptor$Mninfo = gnu.lists.LList.Empty;
    


    _current_interface_ = Lit27;
    current_dev_interface = lambda$Fn5;
    



































































































































































































































    _ccid_bSeq_ = Lit1;
    














































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































    ccid$Mndata$Mnrates$Mnsupported = false;
    USB_TIMEOUT = Lit181;
    





























































































































































































































































    ns = Lit1;
    T1$MnTPDU$MnIblock$MnN_S = lambda$Fn21;
    







    nr = Lit1;
    T1$MnTPDU$MnRblock$MnN_R = lambda$Fn22;
    


































































































    _debug_ = true;
    CCID$MnDEBUG = lambda$Fn23;GET_DEVICES_INF = GET_DEVICES_INF_default;USB_CONTROL_IN = lambda$Fn29;USB_SEND = lambda$Fn30;USB_RECV = lambda$Fn31;USB_SEND_RECV = lambda$Fn32;USB_INTERRUPT_RECV = lambda$Fn33;XfrBlock$Mnhash$Mntable = Boolean.FALSE;
  }
  
  public class frame10
    extends gnu.expr.ModuleBody
  {
    Object atr;
    final ModuleMethod lambda$Fn15;
    
    public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
    {
      if (selector == 6) return lambda25(paramObject); return super.apply1(paramModuleMethod, paramObject); } public void apply(gnu.mapping.CallContext paramCallContext) { ModuleMethod.applyError(); } public int match1(ModuleMethod paramModuleMethod, Object paramObject, gnu.mapping.CallContext paramCallContext) { if (selector == 6) { value1 = paramObject;proc = paramModuleMethod;pc = 1;return 0; } return super.match1(paramModuleMethod, paramObject, paramCallContext); } Object lambda25(Object p) { void tmp7_4 = new CCIDScheme.frame11();74staticLink = this;CCIDScheme.frame11 $heapFrame = tmp7_4;p = p;
      




























      Object TS = $heapFrame.lambda26read$Mn1();
      Object T0 = $heapFrame.lambda26read$Mn1();Object _D = 
      
        T0;Object i = kawa.standard.append.append$V(new Object[] { CCIDScheme.Lit50, $heapFrame.lambda27getAtrInterfaceInside(_D, CCIDScheme.Lit2) });Object localObject1 = 
        p;Object _D = T0;Object K = gnu.kawa.functions.DivideOp.remainder.apply2(_D, CCIDScheme.Lit6);gnu.lists.Pair h = gnu.lists.LList.list2(CCIDScheme.Lit145, CCIDScheme.readU8s(K, port));
      Object TCK = CCIDScheme.readU8s(CCIDScheme.Lit2, p);
      

      if (kawa.lib.lists.isNull(TCK)) {
        CCIDScheme.pp.apply1("no TCK");
      } else if (!gnu.expr.KawaConvert.isTrue(kawa.standard.Scheme.isEqual.apply2(CCIDScheme.listXor(CCIDScheme.subu8list(atr, CCIDScheme.Lit2, Integer.valueOf(gnu.lists.Sequences.getSize(atr)))), CCIDScheme.Lit1))) {
        CCIDScheme.pp.apply1("TCK not equal");
      }
      







      Object tmp232_229 = gnu.mapping.Promise.force(TCK, gnu.lists.Pair.class);Object port = tmp232_229; try { { gnu.lists.LList.list4(gnu.lists.LList.list2(CCIDScheme.Lit146, TS), gnu.lists.LList.list2(CCIDScheme.Lit147, T0), i, h) }[1] = (kawa.lib.lists.isNull(TCK) ? gnu.lists.LList.Empty : gnu.lists.LList.list1(gnu.lists.LList.list2(CCIDScheme.Lit148, kawa.lib.lists.car((gnu.lists.Pair)tmp232_229))));return kawa.standard.append.append$V({ gnu.lists.LList.list4(gnu.lists.LList.list2(CCIDScheme.Lit146, TS), gnu.lists.LList.list2(CCIDScheme.Lit147, T0), i, h) }); } catch (ClassCastException localClassCastException) { throw new gnu.mapping.WrongType(localClassCastException, "car", 1, port);
      }
    }
    

    public frame10()
    {
      void tmp19_16 = new ModuleMethod(this, 6, null, 4097);
      tmp19_16.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm:5");
      lambda$Fn15 = tmp19_16;
    }
  }
  
  static Object lambda54(Object index, Object data)
  {
    USB_SEND.apply2(index, data);
    return USB_RECV.apply1(index);
  }
  
  public class frame17
    extends gnu.expr.ModuleBody
  {
    CCIDScheme $this$;
    final ModuleMethod lambda$Fn34;
    final ModuleMethod lambda$Fn35;
    final ModuleMethod lambda$Fn36;
    final ModuleMethod lambda$Fn38;
    final ModuleMethod lambda$Fn39;
    
    public int matchN(ModuleMethod paramModuleMethod, Object[] paramArrayOfObject, gnu.mapping.CallContext paramCallContext)
    {
      if (selector == 19) { values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0; } return super.matchN(paramModuleMethod, paramArrayOfObject, paramCallContext); } public Object applyN(ModuleMethod paramModuleMethod, Object[] paramArrayOfObject) { if (selector == 19) return CCIDScheme.lambda51(this, paramArrayOfObject[0], paramArrayOfObject[1], paramArrayOfObject[2], paramArrayOfObject[3], paramArrayOfObject[4]); return super.applyN(paramModuleMethod, paramArrayOfObject);
    }
    
    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, gnu.mapping.CallContext paramCallContext) {
      if (selector == 20) { value1 = paramObject1;value2 = paramObject2;proc = paramModuleMethod;pc = 2;return 0; } return super.match2(paramModuleMethod, paramObject1, paramObject2, paramCallContext); } public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2) { if (selector == 20) { CCIDScheme.lambda52(this, paramObject1, paramObject2);return gnu.mapping.Values.empty; } return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    











    public int match1(ModuleMethod paramModuleMethod, Object paramObject, gnu.mapping.CallContext paramCallContext)
    {
      switch (selector) {case 23:  value1 = paramObject;proc = paramModuleMethod;pc = 1;return 0;
      case 22: 
        value1 = paramObject;proc = paramModuleMethod;pc = 1;return 0;
      case 21: 
        value1 = paramObject;proc = paramModuleMethod;pc = 1;return 0; } return super.match1(paramModuleMethod, paramObject, paramCallContext); } public Object apply1(ModuleMethod paramModuleMethod, Object paramObject) { switch (selector) {case 21:  return CCIDScheme.lambda53(this, paramObject);
      






      case 22: 
        return CCIDScheme.lambda55(this, paramObject);
      

      case 23: 
        return CCIDScheme.lambda56(this, paramObject); } return super.apply1(paramModuleMethod, paramObject); }
    public frame17() { void tmp19_16 = new ModuleMethod(this, 19, null, 20485);
      tmp19_16.setProperty("source-location", "ccid_7816/CCIDScheme.scm:57");
      lambda$Fn34 = tmp19_16;
      void tmp45_42 = new ModuleMethod(this, 20, null, 8194);
      tmp45_42.setProperty("source-location", "ccid_7816/CCIDScheme.scm:61");
      lambda$Fn35 = tmp45_42;
      void tmp71_68 = new ModuleMethod(this, 21, null, 4097);
      tmp71_68.setProperty("source-location", "ccid_7816/CCIDScheme.scm:64");
      lambda$Fn36 = tmp71_68;
      void tmp97_94 = new ModuleMethod(this, 22, null, 4097);
      tmp97_94.setProperty("source-location", "ccid_7816/CCIDScheme.scm:73");
      lambda$Fn38 = tmp97_94;
      void tmp123_120 = new ModuleMethod(this, 23, null, 4097);
      tmp123_120.setProperty("source-location", "ccid_7816/CCIDScheme.scm:77");
      lambda$Fn39 = tmp123_120; } public void apply(gnu.mapping.CallContext paramCallContext) { ModuleMethod.applyError(); } } static Object lambda56(frame17 $closureEnv, Object obj) { return $this$.showLog(object$To$String(obj));
  }
  
  public CCIDScheme(com.ftsafe.readerScheme.FTReaderInf arg1, android.os.Handler arg2)
  {
    frame17 $heapFrame = new frame17();$this$ = this;
    $this$.mFTReaderInf = ftReaderInf;
    $this$.mHandler = handler;
    
    USB_CONTROL_IN = lambda$Fn34;
    


    USB_SEND = lambda$Fn35;
    

    USB_RECV = lambda$Fn36;
    


    USB_SEND_RECV = lambda$Fn37;
    



    USB_INTERRUPT_RECV = lambda$Fn38;
    



    pp = lambda$Fn39;
    

    $this$.showLog("(*init* (ftReaderInf ::FTReaderInf) (handler ::Handler)) #!void");
  }
  
  public Object readerFind()
  {
    mFTReaderInf.ft_find();return gnu.mapping.Values.empty;
  }
  
  public class frame0
    extends gnu.expr.ModuleBody
  {
    Object step;
    Object counter;
    final ModuleMethod lambda$Fn1;
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (selector == 1) return lambda1(); return super.apply0(paramModuleMethod); } public void apply(gnu.mapping.CallContext paramCallContext) { ModuleMethod.applyError(); } public int match0(ModuleMethod paramModuleMethod, gnu.mapping.CallContext paramCallContext) { if (selector == 1) { proc = paramModuleMethod;pc = 0;return 0; } return super.match0(paramModuleMethod, paramCallContext); }
    Object lambda1() { counter = gnu.kawa.functions.AddOp.apply2(1, counter, step);
      return counter;
    }
    
    public frame0()
    {
      void tmp16_13 = new ModuleMethod(this, 1, null, 0);
      tmp16_13.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/util.scm:84");
      lambda$Fn1 = tmp16_13;
    }
  }
  
  public class frame13
    extends gnu.expr.ModuleBody
  {
    gnu.lists.LList deviceInf;
    final ModuleMethod lambda$Fn20;
    
    public static Object lambda34loop(Object iads, gnu.math.IntNum i)
    {
      return gnu.kawa.functions.NumberCompare.$Ls(i, kawa.lib.lists.cadr(kawa.lib.lists.assoc(CCIDScheme.Lit92, iads))) ? kawa.standard.append.append$V(new Object[] {gnu.lists.LList.list1(gnu.lists.LList.list3(gnu.kawa.functions.AddOp.apply2(1, i, kawa.lib.lists.cadr(kawa.lib.lists.assoc(CCIDScheme.Lit91, iads))), kawa.lib.lists.assoc(CCIDScheme.Lit96, iads), kawa.lib.lists.assoc(CCIDScheme.Lit92, iads))), lambda34loop(iads, gnu.math.IntNum.add(i, 1)) }) : gnu.lists.LList.Empty;
    }
    


































    public static Object lambda33loop(Object bNumInterfaces, gnu.math.IntNum i) { return gnu.kawa.functions.NumberCompare.$Ls(i, bNumInterfaces) ? kawa.lib.lists.cons(i, lambda33loop(bNumInterfaces, gnu.math.IntNum.add(i, 1))) : gnu.lists.LList.Empty; }
    
    public int match0(ModuleMethod paramModuleMethod, gnu.mapping.CallContext paramCallContext) {
      if (selector == 7) { proc = paramModuleMethod;pc = 0;return 0; } return super.match0(paramModuleMethod, paramCallContext); } public int match1(ModuleMethod paramModuleMethod, Object paramObject, gnu.mapping.CallContext paramCallContext) { if (selector == 7) { value1 = paramObject;proc = paramModuleMethod;pc = 1;return 0; } return super.match1(paramModuleMethod, paramObject, paramCallContext); } public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, gnu.mapping.CallContext paramCallContext) { if (selector == 7) { value1 = paramObject1;value2 = paramObject2;proc = paramModuleMethod;pc = 2;return 0; } return super.match2(paramModuleMethod, paramObject1, paramObject2, paramCallContext); } public Object apply0(ModuleMethod paramModuleMethod) { if (selector == 7) return lambda35(); return super.apply0(paramModuleMethod); } public Object apply1(ModuleMethod paramModuleMethod, Object paramObject) { if (selector == 7) return lambda35(paramObject); return super.apply1(paramModuleMethod, paramObject); } public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2) { if (selector == 7) return lambda35(paramObject1, paramObject2); return super.apply2(paramModuleMethod, paramObject1, paramObject2); }
    
    Object lambda35(Object opt, Object index) { if ((gnu.expr.KawaConvert.isTrue(index)) && (gnu.kawa.functions.NumberCompare.$Gr$Eq(index, Integer.valueOf(deviceInf.size()))))
      {
        localObject = gnu.mapping.Promise.force(index, Number.class); } try { { "Device " }[1] = kawa.lib.numbers.number$To$String((Number)tmp47_44); Object[] tmp56_38 = { "Device " };tmp56_38[2] = " not found : "; Object[] tmp61_56 = tmp56_38;tmp61_56[3] = 
        
          CCIDScheme.object$To$String(deviceInf);tmp28_25[0] = kawa.lib.strings.stringAppend(tmp61_56);throw gnu.expr.Special.reachedUnexpected;
      } catch (ClassCastException localClassCastException2) {
        for (;;) {
          try {
            if (!gnu.expr.KawaConvert.isTrue(kawa.lib.lists.assoc(opt, kawa.lib.lists.cdr((gnu.lists.Pair)(localObject = gnu.mapping.Promise.force(kawa.lib.lists.assoc(index, deviceInf), gnu.lists.Pair.class)))))) {} } catch (ClassCastException localClassCastException2) { throw new gnu.mapping.WrongType(localClassCastException2, "cdr", 1, localObject); }
          try { tmpTernaryOp = kawa.lib.lists.cadr(kawa.lib.lists.assoc(opt, kawa.lib.lists.cdr((gnu.lists.Pair)(localObject = gnu.mapping.Promise.force(kawa.lib.lists.assoc(index, deviceInf), gnu.lists.Pair.class)))));return Boolean.FALSE; } catch (ClassCastException localClassCastException3) { throw new gnu.mapping.WrongType(localClassCastException3, "cdr", 1, localObject);
          }
        }
        throw new gnu.mapping.WrongType(
        





          localClassCastException1, "number->string", 1, localObject);
      }
      if (gnu.expr.KawaConvert.isTrue(kawa.standard.Scheme.isEqual.apply2(opt, CCIDScheme.Lit228))) tmpTernaryOp = Integer.valueOf(deviceInf.size()); }
    public frame13() { void tmp19_16 = new ModuleMethod(this, 7, null, 8192);
      tmp19_16.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid.scm:81");
      lambda$Fn20 = tmp19_16; }
    Object lambda35() { return lambda35(CCIDScheme.Lit227, Boolean.FALSE); }
    Object lambda35(Object paramObject) { return lambda35(paramObject, Boolean.FALSE); } public void apply(gnu.mapping.CallContext paramCallContext) { ModuleMethod.applyError(); } } public class frame1 extends gnu.expr.ModuleBody { public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2) { if (selector == 2) return lambda2(paramObject1, paramObject2); return super.apply2(paramModuleMethod, paramObject1, paramObject2); } Object func; public Object apply1(ModuleMethod paramModuleMethod, Object paramObject) { if (selector == 2) return lambda2(paramObject); return super.apply1(paramModuleMethod, paramObject); } public void apply(gnu.mapping.CallContext paramCallContext) { ModuleMethod.applyError(); } public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, gnu.mapping.CallContext paramCallContext) { if (selector == 2) { value1 = paramObject1;value2 = paramObject2;proc = paramModuleMethod;pc = 2;return 0; } return super.match2(paramModuleMethod, paramObject1, paramObject2, paramCallContext); } Object _container; public int match1(ModuleMethod paramModuleMethod, Object paramObject, gnu.mapping.CallContext paramCallContext) { if (selector == 2) { value1 = paramObject;proc = paramModuleMethod;pc = 1;return 0; } return super.match1(paramModuleMethod, paramObject, paramCallContext); }
    final ModuleMethod lambda$Fn2; Object lambda2(Object op, Object arg) { _container = arg;
      _container = kawa.standard.Scheme.applyToArgs.apply3(func, _container, arg);
      return gnu.expr.KawaConvert.isTrue(kawa.standard.Scheme.isEqual.apply2(op, CCIDScheme.Lit15)) ? _container : gnu.expr.KawaConvert.isTrue(kawa.standard.Scheme.isEqual.apply2(op, CCIDScheme.Lit14)) ? gnu.mapping.Values.empty : gnu.expr.KawaConvert.isTrue(kawa.standard.Scheme.isEqual.apply2(op, CCIDScheme.Lit13)) ? gnu.mapping.Values.empty : gnu.mapping.Values.empty; }
    Object lambda2(Object paramObject) { return lambda2(paramObject, Boolean.FALSE); }
    public frame1() { void tmp18_15 = new ModuleMethod(this, 2, null, 8193);
      tmp18_15.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/util.scm:93");
      lambda$Fn2 = tmp18_15; } }
  public class frame19 extends gnu.expr.ModuleBody { public Object apply0(ModuleMethod paramModuleMethod) { if (selector == 24) return CCIDScheme.lambda57(this); return super.apply0(paramModuleMethod); } public void apply(gnu.mapping.CallContext paramCallContext) { ModuleMethod.applyError(); } public int match0(ModuleMethod paramModuleMethod, gnu.mapping.CallContext paramCallContext) { if (selector == 24) { proc = paramModuleMethod;pc = 0;return 0; } return super.match0(paramModuleMethod, paramCallContext);
    }
    


    Object index;
    

    CCIDScheme.frame18 staticLink;
    

    final ModuleMethod lambda$Fn40;
    

    public frame19()
    {
      void tmp17_14 = new ModuleMethod(this, 24, null, 0);
      tmp17_14.setProperty("source-location", "ccid_7816/CCIDScheme.scm:99");
      lambda$Fn40 = tmp17_14;
    }
  }
  


  public static Object lambda58loop(gnu.math.IntNum i)
  {
    return gnu.kawa.functions.NumberCompare.$Ls(i, kawa.standard.Scheme.applyToArgs.apply2(GET_DEVICES_INF, Lit228)) ? kawa.lib.lists.cons(i, lambda58loop(gnu.math.IntNum.add(i, 1))) : gnu.lists.LList.Empty;
  }
  
  public Object readerClose()
  {
    mFTReaderInf.ft_close();
    GET_DEVICES_INF = GET_DEVICES_INF_default;
    XfrBlock$Mnhash$Mntable = Boolean.FALSE;return gnu.mapping.Values.empty;
  }
  


  static Object lambda59(frame20 $closureEnv, Object data)
  {
    return USB_SEND.apply2(Integer.valueOf(index), data);
  }
  
  public class frame20
    extends gnu.expr.ModuleBody
  {
    int index;
    final ModuleMethod lambda$Fn41;
    final ModuleMethod lambda$Fn42;
    
    public int match1(ModuleMethod paramModuleMethod, Object paramObject, gnu.mapping.CallContext paramCallContext)
    {
      if (selector == 25) { value1 = paramObject;proc = paramModuleMethod;pc = 1;return 0; } return super.match1(paramModuleMethod, paramObject, paramCallContext); } public Object apply1(ModuleMethod paramModuleMethod, Object paramObject) { if (selector == 25) return CCIDScheme.lambda59(this, paramObject); return super.apply1(paramModuleMethod, paramObject); }
    
    public int match0(ModuleMethod paramModuleMethod, gnu.mapping.CallContext paramCallContext) { if (selector == 26) { proc = paramModuleMethod;pc = 0;return 0; } return super.match0(paramModuleMethod, paramCallContext); } public Object apply0(ModuleMethod paramModuleMethod) { if (selector == 26) return CCIDScheme.lambda60(this); return super.apply0(paramModuleMethod); }
    public frame20() { void tmp19_16 = new ModuleMethod(this, 25, null, 4097);
      tmp19_16.setProperty("source-location", "ccid_7816/CCIDScheme.scm:136");
      lambda$Fn41 = tmp19_16;
      void tmp43_40 = new ModuleMethod(this, 26, null, 0);
      tmp43_40.setProperty("source-location", "ccid_7816/CCIDScheme.scm:138");
      lambda$Fn42 = tmp43_40; } public void apply(gnu.mapping.CallContext paramCallContext) { ModuleMethod.applyError(); } } static Object lambda60(frame20 $closureEnv) { return USB_RECV.apply1(Integer.valueOf(index));
  }
  
  public Object readerPowerOn(int index)
  {
    frame20 $heapFrame = new frame20();index = index;
    

    gnu.lists.Pair ret = doPowerOn(lambda$Fn41, lambda$Fn42);
    try {
      kawa.lib.rnrs.hashtables.hashtableSet$Ex((kawa.lib.kawa.hashtable.HashTable)(localObject = gnu.mapping.Promise.force(XfrBlock$Mnhash$Mntable, kawa.lib.kawa.hashtable.HashTable.class)), Integer.valueOf(index), kawa.lib.lists.cadr(kawa.lib.lists.assoc(Lit252, ret)));
      return kawa.standard.Scheme.apply.apply2(Lit0, kawa.lib.lists.cadr(kawa.lib.lists.assoc(Lit251, ret)));
    }
    catch (ClassCastException localClassCastException)
    {
      Object localObject;
      throw new gnu.mapping.WrongType(
        localClassCastException, "hashtable-set!", 1, localObject);
    }
  }
  
  public class frame21 extends gnu.expr.ModuleBody { int index;
    final ModuleMethod lambda$Fn43;
    
    public Object apply1(ModuleMethod paramModuleMethod, Object paramObject) { if (selector == 27) return CCIDScheme.lambda61(this, paramObject); return super.apply1(paramModuleMethod, paramObject); } public void apply(gnu.mapping.CallContext paramCallContext) { ModuleMethod.applyError(); } public int match1(ModuleMethod paramModuleMethod, Object paramObject, gnu.mapping.CallContext paramCallContext) { if (selector == 27) { value1 = paramObject;proc = paramModuleMethod;pc = 1;return 0; } return super.match1(paramModuleMethod, paramObject, paramCallContext); }
    public frame21() { void tmp19_16 = new ModuleMethod(this, 27, null, 4097);
      tmp19_16.setProperty("source-location", "ccid_7816/CCIDScheme.scm:148");
      lambda$Fn43 = tmp19_16; } } static Object lambda61(frame21 $closureEnv, Object data) { return USB_SEND_RECV.apply2(Integer.valueOf(index), data); }
  




  public class frame22
    extends gnu.expr.ModuleBody
  {
    int index;
    


    final ModuleMethod lambda$Fn44;
    



    public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
    {
      if (selector == 28) return CCIDScheme.lambda62(this, paramObject); return super.apply1(paramModuleMethod, paramObject); } public void apply(gnu.mapping.CallContext paramCallContext) { ModuleMethod.applyError(); } public int match1(ModuleMethod paramModuleMethod, Object paramObject, gnu.mapping.CallContext paramCallContext) { if (selector == 28) { value1 = paramObject;proc = paramModuleMethod;pc = 1;return 0; } return super.match1(paramModuleMethod, paramObject, paramCallContext); }
    public frame22() { void tmp19_16 = new ModuleMethod(this, 28, null, 4097);
      tmp19_16.setProperty("source-location", "ccid_7816/CCIDScheme.scm:169");
      lambda$Fn44 = tmp19_16; } } static Object lambda62(frame22 $closureEnv, Object data) { return USB_SEND_RECV.apply2(Integer.valueOf(index), data);
  }
  
  public Object readerEscape(int index, byte[] data)
  {
    frame22 $heapFrame = new frame22();index = index;
    



    return kawa.standard.Scheme.apply.apply2(Lit0, doEscape(lambda$Fn44, kawa.standard.Scheme.apply.apply2(gnu.kawa.lispexpr.LangObjType.listType, data)));
  }
  
  public class frame23 extends gnu.expr.ModuleBody {
    int index;
    final ModuleMethod lambda$Fn45;
    
    public Object apply1(ModuleMethod paramModuleMethod, Object paramObject) { if (selector == 29) return CCIDScheme.lambda63(this, paramObject); return super.apply1(paramModuleMethod, paramObject); } public void apply(gnu.mapping.CallContext paramCallContext) { ModuleMethod.applyError(); } public int match1(ModuleMethod paramModuleMethod, Object paramObject, gnu.mapping.CallContext paramCallContext) { if (selector == 29) { value1 = paramObject;proc = paramModuleMethod;pc = 1;return 0; } return super.match1(paramModuleMethod, paramObject, paramCallContext);
    }
    
    public frame23()
    {
      void tmp19_16 = new ModuleMethod(this, 29, null, 4097);
      tmp19_16.setProperty("source-location", "ccid_7816/CCIDScheme.scm:179");
      lambda$Fn45 = tmp19_16;
    }
  }
  
  public int readerSlotStatus(int index)
  {
    frame23 $heapFrame = new frame23();index = index;
    
    return ((Number)gnu.mapping.Promise.force(doSlotStatus(lambda$Fn45))).intValue(); }
  static Object lambda63(frame23 $closureEnv, Object data) { return USB_SEND_RECV.apply2(Integer.valueOf(index), data);
  }
  
  public class frame3
    extends gnu.expr.ModuleBody
  {
    Object p;
    gnu.mapping.Procedure c;
    final ModuleMethod lambda$Fn8;
    
    static Object lambda19(Object p)
    {
      CCIDScheme.frame8 $heapFrame = new CCIDScheme.frame8();p = p;
      


      return CCIDScheme.toList$V(gnu.lists.LList.list2(CCIDScheme.Lit29, $heapFrame.lambda20read$Mn1()), new Object[] { gnu.lists.LList.list2(CCIDScheme.Lit30, $heapFrame.lambda20read$Mn1()), gnu.lists.LList.list2(CCIDScheme.Lit70, $heapFrame.lambda21read$Mn2()), gnu.lists.LList.list2(CCIDScheme.Lit71, $heapFrame.lambda20read$Mn1()), gnu.lists.LList.list2(CCIDScheme.Lit72, $heapFrame.lambda20read$Mn1()), gnu.lists.LList.list2(CCIDScheme.Lit73, $heapFrame.lambda22read$Mn4()), gnu.lists.LList.list2(CCIDScheme.Lit74, $heapFrame.lambda22read$Mn4()), gnu.lists.LList.list2(CCIDScheme.Lit75, $heapFrame.lambda22read$Mn4()), gnu.lists.LList.list2(CCIDScheme.Lit76, $heapFrame.lambda20read$Mn1()), gnu.lists.LList.list2(CCIDScheme.Lit77, $heapFrame.lambda22read$Mn4()), gnu.lists.LList.list2(CCIDScheme.Lit78, $heapFrame.lambda22read$Mn4()), gnu.lists.LList.list2(CCIDScheme.Lit79, $heapFrame.lambda20read$Mn1()), gnu.lists.LList.list2(CCIDScheme.Lit80, $heapFrame.lambda22read$Mn4()), gnu.lists.LList.list2(CCIDScheme.Lit81, $heapFrame.lambda22read$Mn4()), gnu.lists.LList.list2(CCIDScheme.Lit82, $heapFrame.lambda22read$Mn4()), gnu.lists.LList.list2(CCIDScheme.Lit83, $heapFrame.lambda22read$Mn4()), gnu.lists.LList.list2(CCIDScheme.Lit84, $heapFrame.lambda22read$Mn4()), gnu.lists.LList.list2(CCIDScheme.Lit85, $heapFrame.lambda20read$Mn1()), gnu.lists.LList.list2(CCIDScheme.Lit86, $heapFrame.lambda20read$Mn1()), gnu.lists.LList.list2(CCIDScheme.Lit87, $heapFrame.lambda21read$Mn2()), gnu.lists.LList.list2(CCIDScheme.Lit88, $heapFrame.lambda20read$Mn1()), gnu.lists.LList.list2(CCIDScheme.Lit89, $heapFrame.lambda20read$Mn1()) });
    }
    






















    static Object lambda17(Object p)
    {
      CCIDScheme.frame7 $heapFrame = new CCIDScheme.frame7();p = p;
      
      Object _tmp = CCIDScheme.toList$V(
      
        gnu.lists.LList.list2(CCIDScheme.Lit29, $heapFrame.lambda18read$Mn1()), new Object[] { gnu.lists.LList.list2(CCIDScheme.Lit30, $heapFrame.lambda18read$Mn1()), gnu.lists.LList.list2(CCIDScheme.Lit59, $heapFrame.lambda18read$Mn1()), gnu.lists.LList.list2(CCIDScheme.Lit48, $heapFrame.lambda18read$Mn1()), gnu.lists.LList.list2(CCIDScheme.Lit60, CCIDScheme.buildWordFromlst$V(CCIDScheme.readU8s(CCIDScheme.Lit16, p), new Object[] { CCIDScheme.Lit3, CCIDScheme.Lit4 })), gnu.lists.LList.list2(CCIDScheme.Lit61, $heapFrame.lambda18read$Mn1()) });
      













      return (gnu.expr.KawaConvert.isTrue(kawa.standard.Scheme.isEqual.apply2(kawa.lib.lists.assoc(CCIDScheme.Lit48, _tmp), CCIDScheme.Lit64))) && (gnu.expr.KawaConvert.isTrue(kawa.standard.Scheme.isEqual.apply2(gnu.kawa.functions.BitwiseOp.and.apply2(kawa.lib.lists.cadr(kawa.lib.lists.assoc(CCIDScheme.Lit59, _tmp)), CCIDScheme.Lit20), CCIDScheme.Lit1))) ? kawa.standard.append.append$V(new Object[] { CCIDScheme.Lit66, _tmp }) : (gnu.expr.KawaConvert.isTrue(kawa.standard.Scheme.isEqual.apply2(kawa.lib.lists.assoc(CCIDScheme.Lit48, _tmp), CCIDScheme.Lit64))) && (gnu.expr.KawaConvert.isTrue(kawa.standard.Scheme.isEqual.apply2(gnu.kawa.functions.BitwiseOp.and.apply2(kawa.lib.lists.cadr(kawa.lib.lists.assoc(CCIDScheme.Lit59, _tmp)), CCIDScheme.Lit20), CCIDScheme.Lit20))) ? kawa.standard.append.append$V(new Object[] { CCIDScheme.Lit65, _tmp }) : (gnu.expr.KawaConvert.isTrue(kawa.standard.Scheme.isEqual.apply2(kawa.lib.lists.assoc(CCIDScheme.Lit48, _tmp), CCIDScheme.Lit62))) && (gnu.expr.KawaConvert.isTrue(kawa.standard.Scheme.isEqual.apply2(gnu.kawa.functions.BitwiseOp.and.apply2(kawa.lib.lists.cadr(kawa.lib.lists.assoc(CCIDScheme.Lit59, _tmp)), CCIDScheme.Lit20), CCIDScheme.Lit20))) ? kawa.standard.append.append$V(new Object[] { CCIDScheme.Lit63, _tmp }) : kawa.standard.append.append$V(new Object[] { CCIDScheme.Lit67, _tmp });
    }
    



    static Object lambda15(Object p)
    {
      CCIDScheme.frame6 $heapFrame = new CCIDScheme.frame6();p = p;
      


      return CCIDScheme.toList$V(gnu.lists.LList.list2(CCIDScheme.Lit29, $heapFrame.lambda16read$Mn1()), new Object[] { gnu.lists.LList.list2(CCIDScheme.Lit30, $heapFrame.lambda16read$Mn1()), gnu.lists.LList.list2(CCIDScheme.Lit51, $heapFrame.lambda16read$Mn1()), gnu.lists.LList.list2(CCIDScheme.Lit52, $heapFrame.lambda16read$Mn1()), gnu.lists.LList.list2(CCIDScheme.Lit53, $heapFrame.lambda16read$Mn1()), gnu.lists.LList.list2(CCIDScheme.Lit54, $heapFrame.lambda16read$Mn1()), gnu.lists.LList.list2(CCIDScheme.Lit55, $heapFrame.lambda16read$Mn1()), gnu.lists.LList.list2(CCIDScheme.Lit56, $heapFrame.lambda16read$Mn1()), gnu.lists.LList.list2(CCIDScheme.Lit57, $heapFrame.lambda16read$Mn1()) });
    }
    









    static Object lambda13(Object p)
    {
      CCIDScheme.frame5 $heapFrame = new CCIDScheme.frame5();p = p;
      
      return CCIDScheme.toList$V(
      
        gnu.lists.LList.list2(CCIDScheme.Lit29, $heapFrame.lambda14read$Mn1()), new Object[] { gnu.lists.LList.list2(CCIDScheme.Lit30, $heapFrame.lambda14read$Mn1()), gnu.lists.LList.list2(CCIDScheme.Lit44, CCIDScheme.buildWordFromlst$V(CCIDScheme.readU8s(CCIDScheme.Lit16, p), new Object[] { CCIDScheme.Lit3, CCIDScheme.Lit4 })), gnu.lists.LList.list2(CCIDScheme.Lit45, $heapFrame.lambda14read$Mn1()), gnu.lists.LList.list2(CCIDScheme.Lit46, $heapFrame.lambda14read$Mn1()), gnu.lists.LList.list2(CCIDScheme.Lit47, $heapFrame.lambda14read$Mn1()), gnu.lists.LList.list2(CCIDScheme.Lit48, $heapFrame.lambda14read$Mn1()), gnu.lists.LList.list2(CCIDScheme.Lit49, $heapFrame.lambda14read$Mn1()) });
    }
    








    static Object lambda10(Object p)
    {
      CCIDScheme.frame4 $heapFrame = new CCIDScheme.frame4();p = p;
      


      return CCIDScheme.toList$V(gnu.lists.LList.list2(CCIDScheme.Lit29, $heapFrame.lambda11read$Mn1()), new Object[] { gnu.lists.LList.list2(CCIDScheme.Lit30, $heapFrame.lambda11read$Mn1()), gnu.lists.LList.list2(CCIDScheme.Lit31, $heapFrame.lambda12read$Mn2()), gnu.lists.LList.list2(CCIDScheme.Lit32, $heapFrame.lambda11read$Mn1()), gnu.lists.LList.list2(CCIDScheme.Lit33, $heapFrame.lambda11read$Mn1()), gnu.lists.LList.list2(CCIDScheme.Lit34, $heapFrame.lambda11read$Mn1()), gnu.lists.LList.list2(CCIDScheme.Lit35, $heapFrame.lambda11read$Mn1()), gnu.lists.LList.list2(CCIDScheme.Lit36, $heapFrame.lambda12read$Mn2()), gnu.lists.LList.list2(CCIDScheme.Lit37, $heapFrame.lambda12read$Mn2()), gnu.lists.LList.list2(CCIDScheme.Lit38, $heapFrame.lambda12read$Mn2()), gnu.lists.LList.list2(CCIDScheme.Lit39, $heapFrame.lambda11read$Mn1()), gnu.lists.LList.list2(CCIDScheme.Lit40, $heapFrame.lambda11read$Mn1()), gnu.lists.LList.list2(CCIDScheme.Lit41, $heapFrame.lambda11read$Mn1()), gnu.lists.LList.list2(CCIDScheme.Lit42, $heapFrame.lambda11read$Mn1()) });
    }
    













    static Object lambda23(Object p)
    {
      CCIDScheme.frame9 $heapFrame = new CCIDScheme.frame9();p = p;
      


      return CCIDScheme.toList$V(gnu.lists.LList.list2(CCIDScheme.Lit29, $heapFrame.lambda24read$Mn1()), new Object[] { gnu.lists.LList.list2(CCIDScheme.Lit30, $heapFrame.lambda24read$Mn1()), gnu.lists.LList.list2(CCIDScheme.Lit91, $heapFrame.lambda24read$Mn1()), gnu.lists.LList.list2(CCIDScheme.Lit92, $heapFrame.lambda24read$Mn1()), gnu.lists.LList.list2(CCIDScheme.Lit93, $heapFrame.lambda24read$Mn1()), gnu.lists.LList.list2(CCIDScheme.Lit94, $heapFrame.lambda24read$Mn1()), gnu.lists.LList.list2(CCIDScheme.Lit95, $heapFrame.lambda24read$Mn1()), gnu.lists.LList.list2(CCIDScheme.Lit96, $heapFrame.lambda24read$Mn1()) });
    }
    

















    static Object lambda7(Object A, Object B)
    {
      return kawa.standard.append.append$V(new Object[] { A, gnu.lists.LList.list1(B) });
    }
    

    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, gnu.mapping.CallContext paramCallContext)
    {
      if (selector == 5) { value1 = paramObject1;value2 = paramObject2;proc = paramModuleMethod;pc = 2;return 0; } return super.match2(paramModuleMethod, paramObject1, paramObject2, paramCallContext); } public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2) { if (selector == 5) return lambda8(paramObject1, paramObject2); return super.apply2(paramModuleMethod, paramObject1, paramObject2); }
    Object lambda8(Object A, Object B) { Object[] tmp14_11 = new Object[2]; Object 
      
        tmp39_36 = gnu.mapping.Promise.force(c.apply0(), Number.class);Object localObject = tmp39_36; try { { "IAD" }[1] = kawa.lib.numbers.number$To$String((Number)tmp39_36);tmp14_11[0] = gnu.lists.LList.list1(kawa.lib.misc.string$To$Symbol(kawa.lib.strings.stringAppend({ "IAD" }))); Object[] tmp58_14 = tmp14_11;tmp58_14[1] = B;{ A }[1] = gnu.lists.LList.list1(kawa.standard.append.append$V(tmp58_14));return kawa.standard.append.append$V({ A }); } catch (ClassCastException localClassCastException) { throw new gnu.mapping.WrongType(localClassCastException, "number->string", 1, localObject);
      }
    }
    
    public frame3()
    {
      void tmp18_15 = new ModuleMethod(this, 5, null, 8194);
      tmp18_15.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid_descriptor.scm:178");
      lambda$Fn8 = tmp18_15;
    }
    
    /* Error */
    public Object lambda9loop(Object IAD$Mncontainer, Object counter, Object interface$Mncontainer)
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 68	com/ftsafe/CCIDScheme$frame3:p	Ljava/lang/Object;
      //   4: astore 5
      //   6: getstatic 74	com/ftsafe/CCIDScheme:Lit2	Lgnu/math/IntNum;
      //   9: aload 5
      //   11: invokestatic 78	com/ftsafe/CCIDScheme:readU8s	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   14: astore 6
      //   16: aload 6
      //   18: invokestatic 84	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
      //   21: ifeq +9 -> 30
      //   24: getstatic 88	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
      //   27: goto +50 -> 77
      //   30: aload 6
      //   32: ldc 90
      //   34: invokestatic 36	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   37: dup
      //   38: astore 7
      //   40: checkcast 90	gnu/lists/Pair
      //   43: invokestatic 95	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
      //   46: iconst_m1
      //   47: aload 6
      //   49: ldc 90
      //   51: invokestatic 36	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   54: dup
      //   55: astore 7
      //   57: checkcast 90	gnu/lists/Pair
      //   60: invokestatic 95	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
      //   63: getstatic 74	com/ftsafe/CCIDScheme:Lit2	Lgnu/math/IntNum;
      //   66: invokestatic 101	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   69: aload 5
      //   71: invokestatic 78	com/ftsafe/CCIDScheme:readU8s	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   74: invokestatic 105	kawa/lib/lists:cons	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
      //   77: astore 4
      //   79: aload 4
      //   81: invokestatic 84	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
      //   84: ifne +487 -> 571
      //   87: aload 4
      //   89: iconst_1
      //   90: invokestatic 109	kawa/lib/lists:listRef	(Ljava/lang/Object;I)Ljava/lang/Object;
      //   93: getstatic 74	com/ftsafe/CCIDScheme:Lit2	Lgnu/math/IntNum;
      //   96: invokestatic 115	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
      //   99: ifeq +37 -> 136
      //   102: iconst_2
      //   103: anewarray 2	java/lang/Object
      //   106: dup
      //   107: iconst_0
      //   108: getstatic 119	com/ftsafe/CCIDScheme:Lit28	Lgnu/lists/PairWithPosition;
      //   111: aastore
      //   112: dup
      //   113: iconst_1
      //   114: aload 4
      //   116: astore 6
      //   118: aload 6
      //   120: invokestatic 123	com/ftsafe/CCIDScheme:list$To$U8vector	(Ljava/lang/Object;)Lgnu/lists/U8Vector;
      //   123: getstatic 189	com/ftsafe/CCIDScheme:lambda$Fn9	Lgnu/expr/ModuleMethod;
      //   126: invokestatic 192	com/ftsafe/CCIDScheme:callWithInputU8vector	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   129: aastore
      //   130: invokestatic 14	kawa/standard/append:append$V	([Ljava/lang/Object;)Ljava/lang/Object;
      //   133: goto +362 -> 495
      //   136: aload 4
      //   138: iconst_1
      //   139: invokestatic 109	kawa/lib/lists:listRef	(Ljava/lang/Object;I)Ljava/lang/Object;
      //   142: getstatic 195	com/ftsafe/CCIDScheme:Lit16	Lgnu/math/IntNum;
      //   145: invokestatic 115	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
      //   148: ifeq +37 -> 185
      //   151: iconst_2
      //   152: anewarray 2	java/lang/Object
      //   155: dup
      //   156: iconst_0
      //   157: getstatic 198	com/ftsafe/CCIDScheme:Lit43	Lgnu/lists/PairWithPosition;
      //   160: aastore
      //   161: dup
      //   162: iconst_1
      //   163: aload 4
      //   165: astore 6
      //   167: aload 6
      //   169: invokestatic 123	com/ftsafe/CCIDScheme:list$To$U8vector	(Ljava/lang/Object;)Lgnu/lists/U8Vector;
      //   172: getstatic 236	com/ftsafe/CCIDScheme:lambda$Fn10	Lgnu/expr/ModuleMethod;
      //   175: invokestatic 192	com/ftsafe/CCIDScheme:callWithInputU8vector	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   178: aastore
      //   179: invokestatic 14	kawa/standard/append:append$V	([Ljava/lang/Object;)Ljava/lang/Object;
      //   182: goto +313 -> 495
      //   185: aload 4
      //   187: iconst_1
      //   188: invokestatic 109	kawa/lib/lists:listRef	(Ljava/lang/Object;I)Ljava/lang/Object;
      //   191: getstatic 239	com/ftsafe/CCIDScheme:Lit18	Lgnu/math/IntNum;
      //   194: invokestatic 115	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
      //   197: ifeq +135 -> 332
      //   200: aload_3
      //   201: ldc 24
      //   203: invokestatic 36	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   206: checkcast 24	gnu/mapping/Procedure
      //   209: getstatic 242	com/ftsafe/CCIDScheme:Lit15	Lgnu/mapping/SimpleSymbol;
      //   212: invokevirtual 246	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
      //   215: astore 6
      //   217: aload_3
      //   218: ldc 24
      //   220: invokestatic 36	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   223: checkcast 24	gnu/mapping/Procedure
      //   226: getstatic 249	com/ftsafe/CCIDScheme:Lit13	Lgnu/mapping/SimpleSymbol;
      //   229: iconst_2
      //   230: anewarray 2	java/lang/Object
      //   233: dup
      //   234: iconst_0
      //   235: ldc -5
      //   237: aastore
      //   238: dup
      //   239: iconst_1
      //   240: aload_2
      //   241: ldc 24
      //   243: invokestatic 36	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   246: checkcast 24	gnu/mapping/Procedure
      //   249: invokevirtual 28	gnu/mapping/Procedure:apply0	()Ljava/lang/Object;
      //   252: ldc 30
      //   254: invokestatic 36	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   257: dup
      //   258: astore 7
      //   260: checkcast 30	java/lang/Number
      //   263: invokestatic 52	kawa/lib/numbers:number$To$String	(Ljava/lang/Number;)Ljava/lang/CharSequence;
      //   266: aastore
      //   267: invokestatic 58	kawa/lib/strings:stringAppend	([Ljava/lang/Object;)Lgnu/lists/FString;
      //   270: invokestatic 64	kawa/lib/misc:string$To$Symbol	(Ljava/lang/CharSequence;)Lgnu/mapping/SimpleSymbol;
      //   273: invokestatic 8	gnu/lists/LList:list1	(Ljava/lang/Object;)Lgnu/lists/Pair;
      //   276: invokevirtual 253	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   279: pop
      //   280: aload_3
      //   281: ldc 24
      //   283: invokestatic 36	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   286: checkcast 24	gnu/mapping/Procedure
      //   289: getstatic 256	com/ftsafe/CCIDScheme:Lit14	Lgnu/mapping/SimpleSymbol;
      //   292: iconst_2
      //   293: anewarray 2	java/lang/Object
      //   296: dup
      //   297: iconst_0
      //   298: getstatic 259	com/ftsafe/CCIDScheme:Lit50	Lgnu/lists/PairWithPosition;
      //   301: aastore
      //   302: dup
      //   303: iconst_1
      //   304: aload 4
      //   306: astore 7
      //   308: aload 7
      //   310: invokestatic 123	com/ftsafe/CCIDScheme:list$To$U8vector	(Ljava/lang/Object;)Lgnu/lists/U8Vector;
      //   313: getstatic 290	com/ftsafe/CCIDScheme:lambda$Fn11	Lgnu/expr/ModuleMethod;
      //   316: invokestatic 192	com/ftsafe/CCIDScheme:callWithInputU8vector	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   319: aastore
      //   320: invokestatic 14	kawa/standard/append:append$V	([Ljava/lang/Object;)Ljava/lang/Object;
      //   323: invokevirtual 253	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   326: pop
      //   327: aload 6
      //   329: goto +166 -> 495
      //   332: aload 4
      //   334: iconst_1
      //   335: invokestatic 109	kawa/lib/lists:listRef	(Ljava/lang/Object;I)Ljava/lang/Object;
      //   338: getstatic 293	com/ftsafe/CCIDScheme:Lit58	Lgnu/math/IntNum;
      //   341: invokestatic 115	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
      //   344: ifeq +36 -> 380
      //   347: aload_3
      //   348: ldc 24
      //   350: invokestatic 36	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   353: checkcast 24	gnu/mapping/Procedure
      //   356: getstatic 256	com/ftsafe/CCIDScheme:Lit14	Lgnu/mapping/SimpleSymbol;
      //   359: aload 4
      //   361: astore 6
      //   363: aload 6
      //   365: invokestatic 123	com/ftsafe/CCIDScheme:list$To$U8vector	(Ljava/lang/Object;)Lgnu/lists/U8Vector;
      //   368: getstatic 359	com/ftsafe/CCIDScheme:lambda$Fn12	Lgnu/expr/ModuleMethod;
      //   371: invokestatic 192	com/ftsafe/CCIDScheme:callWithInputU8vector	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   374: invokevirtual 253	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   377: goto +118 -> 495
      //   380: aload 4
      //   382: iconst_1
      //   383: invokestatic 109	kawa/lib/lists:listRef	(Ljava/lang/Object;I)Ljava/lang/Object;
      //   386: getstatic 362	com/ftsafe/CCIDScheme:Lit68	Lgnu/math/IntNum;
      //   389: invokestatic 115	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
      //   392: ifeq +52 -> 444
      //   395: aload_3
      //   396: ldc 24
      //   398: invokestatic 36	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   401: checkcast 24	gnu/mapping/Procedure
      //   404: getstatic 256	com/ftsafe/CCIDScheme:Lit14	Lgnu/mapping/SimpleSymbol;
      //   407: iconst_2
      //   408: anewarray 2	java/lang/Object
      //   411: dup
      //   412: iconst_0
      //   413: getstatic 365	com/ftsafe/CCIDScheme:Lit69	Lgnu/lists/PairWithPosition;
      //   416: aastore
      //   417: dup
      //   418: iconst_1
      //   419: aload 4
      //   421: astore 6
      //   423: aload 6
      //   425: invokestatic 123	com/ftsafe/CCIDScheme:list$To$U8vector	(Ljava/lang/Object;)Lgnu/lists/U8Vector;
      //   428: getstatic 441	com/ftsafe/CCIDScheme:lambda$Fn13	Lgnu/expr/ModuleMethod;
      //   431: invokestatic 192	com/ftsafe/CCIDScheme:callWithInputU8vector	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   434: aastore
      //   435: invokestatic 14	kawa/standard/append:append$V	([Ljava/lang/Object;)Ljava/lang/Object;
      //   438: invokevirtual 253	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   441: goto +54 -> 495
      //   444: aload 4
      //   446: iconst_1
      //   447: invokestatic 109	kawa/lib/lists:listRef	(Ljava/lang/Object;I)Ljava/lang/Object;
      //   450: getstatic 444	com/ftsafe/CCIDScheme:Lit90	Lgnu/math/IntNum;
      //   453: invokestatic 115	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
      //   456: ifeq +36 -> 492
      //   459: aload_1
      //   460: ldc 24
      //   462: invokestatic 36	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   465: checkcast 24	gnu/mapping/Procedure
      //   468: getstatic 256	com/ftsafe/CCIDScheme:Lit14	Lgnu/mapping/SimpleSymbol;
      //   471: aload 4
      //   473: astore 6
      //   475: aload 6
      //   477: invokestatic 123	com/ftsafe/CCIDScheme:list$To$U8vector	(Ljava/lang/Object;)Lgnu/lists/U8Vector;
      //   480: getstatic 472	com/ftsafe/CCIDScheme:lambda$Fn14	Lgnu/expr/ModuleMethod;
      //   483: invokestatic 192	com/ftsafe/CCIDScheme:callWithInputU8vector	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   486: invokevirtual 253	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   489: goto +6 -> 495
      //   492: getstatic 478	gnu/mapping/Values:empty	Lgnu/mapping/Values;
      //   495: astore 5
      //   497: iconst_2
      //   498: anewarray 2	java/lang/Object
      //   501: dup
      //   502: iconst_0
      //   503: getstatic 315	kawa/standard/Scheme:isEqual	Lgnu/kawa/functions/IsEqual;
      //   506: getstatic 478	gnu/mapping/Values:empty	Lgnu/mapping/Values;
      //   509: aload 5
      //   511: invokevirtual 253	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   514: astore 6
      //   516: aload 6
      //   518: invokestatic 326	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
      //   521: ifeq +14 -> 535
      //   524: aload 6
      //   526: invokestatic 326	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
      //   529: ifeq +20 -> 549
      //   532: goto +11 -> 543
      //   535: aload 5
      //   537: invokestatic 84	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
      //   540: ifeq +9 -> 549
      //   543: getstatic 88	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
      //   546: goto +8 -> 554
      //   549: aload 5
      //   551: invokestatic 8	gnu/lists/LList:list1	(Ljava/lang/Object;)Lgnu/lists/Pair;
      //   554: aastore
      //   555: dup
      //   556: iconst_1
      //   557: aload_0
      //   558: aload_1
      //   559: aload_2
      //   560: aload_3
      //   561: invokevirtual 482	com/ftsafe/CCIDScheme$frame3:lambda9loop	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   564: aastore
      //   565: invokestatic 14	kawa/standard/append:append$V	([Ljava/lang/Object;)Ljava/lang/Object;
      //   568: goto +122 -> 690
      //   571: iconst_2
      //   572: anewarray 2	java/lang/Object
      //   575: dup
      //   576: iconst_0
      //   577: aload_3
      //   578: ldc 24
      //   580: invokestatic 36	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   583: checkcast 24	gnu/mapping/Procedure
      //   586: getstatic 242	com/ftsafe/CCIDScheme:Lit15	Lgnu/mapping/SimpleSymbol;
      //   589: invokevirtual 246	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
      //   592: invokestatic 84	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
      //   595: ifeq +9 -> 604
      //   598: getstatic 88	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
      //   601: goto +21 -> 622
      //   604: aload_3
      //   605: ldc 24
      //   607: invokestatic 36	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   610: checkcast 24	gnu/mapping/Procedure
      //   613: getstatic 242	com/ftsafe/CCIDScheme:Lit15	Lgnu/mapping/SimpleSymbol;
      //   616: invokevirtual 246	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
      //   619: invokestatic 8	gnu/lists/LList:list1	(Ljava/lang/Object;)Lgnu/lists/Pair;
      //   622: aastore
      //   623: dup
      //   624: iconst_1
      //   625: aload_1
      //   626: ldc 24
      //   628: invokestatic 36	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   631: checkcast 24	gnu/mapping/Procedure
      //   634: getstatic 242	com/ftsafe/CCIDScheme:Lit15	Lgnu/mapping/SimpleSymbol;
      //   637: invokevirtual 246	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
      //   640: invokestatic 84	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
      //   643: ifeq +9 -> 652
      //   646: getstatic 88	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
      //   649: goto +37 -> 686
      //   652: iconst_2
      //   653: anewarray 2	java/lang/Object
      //   656: dup
      //   657: iconst_0
      //   658: getstatic 485	com/ftsafe/CCIDScheme:Lit97	Lgnu/lists/PairWithPosition;
      //   661: aastore
      //   662: dup
      //   663: iconst_1
      //   664: aload_1
      //   665: ldc 24
      //   667: invokestatic 36	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   670: checkcast 24	gnu/mapping/Procedure
      //   673: getstatic 242	com/ftsafe/CCIDScheme:Lit15	Lgnu/mapping/SimpleSymbol;
      //   676: invokevirtual 246	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
      //   679: aastore
      //   680: invokestatic 14	kawa/standard/append:append$V	([Ljava/lang/Object;)Ljava/lang/Object;
      //   683: invokestatic 8	gnu/lists/LList:list1	(Ljava/lang/Object;)Lgnu/lists/Pair;
      //   686: aastore
      //   687: invokestatic 14	kawa/standard/append:append$V	([Ljava/lang/Object;)Ljava/lang/Object;
      //   690: areturn
      //   691: new 40	gnu/mapping/WrongType
      //   694: dup_x1
      //   695: swap
      //   696: ldc 92
      //   698: iconst_1
      //   699: aload 7
      //   701: invokespecial 46	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   704: athrow
      //   705: new 40	gnu/mapping/WrongType
      //   708: dup_x1
      //   709: swap
      //   710: ldc 92
      //   712: iconst_1
      //   713: aload 7
      //   715: invokespecial 46	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   718: athrow
      //   719: new 40	gnu/mapping/WrongType
      //   722: dup_x1
      //   723: swap
      //   724: ldc 42
      //   726: iconst_1
      //   727: aload 7
      //   729: invokespecial 46	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   732: athrow
      // Line number table:
      //   Java source line #188	-> byte code offset #0
      //   Java source line #20	-> byte code offset #4
      //   Java source line #21	-> byte code offset #6
      //   Java source line #22	-> byte code offset #16
      //   Java source line #24	-> byte code offset #30
      //   Java source line #25	-> byte code offset #46
      //   Java source line #189	-> byte code offset #79
      //   Java source line #190	-> byte code offset #87
      //   Java source line #121	-> byte code offset #116
      //   Java source line #122	-> byte code offset #118
      //   Java source line #123	-> byte code offset #118
      //   Java source line #124	-> byte code offset #123
      //   Java source line #191	-> byte code offset #136
      //   Java source line #104	-> byte code offset #165
      //   Java source line #105	-> byte code offset #167
      //   Java source line #106	-> byte code offset #167
      //   Java source line #107	-> byte code offset #172
      //   Java source line #192	-> byte code offset #185
      //   Java source line #193	-> byte code offset #217
      //   Java source line #194	-> byte code offset #229
      //   Java source line #196	-> byte code offset #240
      //   Java source line #197	-> byte code offset #280
      //   Java source line #198	-> byte code offset #292
      //   Java source line #199	-> byte code offset #304
      //   Java source line #86	-> byte code offset #306
      //   Java source line #87	-> byte code offset #308
      //   Java source line #88	-> byte code offset #308
      //   Java source line #89	-> byte code offset #313
      //   Java source line #200	-> byte code offset #327
      //   Java source line #201	-> byte code offset #332
      //   Java source line #202	-> byte code offset #359
      //   Java source line #59	-> byte code offset #361
      //   Java source line #60	-> byte code offset #363
      //   Java source line #61	-> byte code offset #363
      //   Java source line #62	-> byte code offset #368
      //   Java source line #203	-> byte code offset #380
      //   Java source line #204	-> byte code offset #407
      //   Java source line #205	-> byte code offset #419
      //   Java source line #28	-> byte code offset #421
      //   Java source line #29	-> byte code offset #423
      //   Java source line #30	-> byte code offset #423
      //   Java source line #31	-> byte code offset #428
      //   Java source line #206	-> byte code offset #444
      //   Java source line #207	-> byte code offset #459
      //   Java source line #143	-> byte code offset #473
      //   Java source line #144	-> byte code offset #475
      //   Java source line #145	-> byte code offset #475
      //   Java source line #146	-> byte code offset #480
      //   Java source line #211	-> byte code offset #497
      //   Java source line #212	-> byte code offset #535
      //   Java source line #214	-> byte code offset #549
      //   Java source line #216	-> byte code offset #571
      //   Java source line #218	-> byte code offset #604
      //   Java source line #219	-> byte code offset #625
      //   Java source line #221	-> byte code offset #652
      //   Java source line #24	-> byte code offset #691
      //   Java source line #25	-> byte code offset #705
      //   Java source line #196	-> byte code offset #719
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	691	0	this	frame3
      //   0	690	1	IAD$Mncontainer	Object
      //   0	690	2	counter	Object
      //   0	690	3	interface$Mncontainer	Object
      //   79	611	4	l	Object
      //   6	71	5	p	Object
      //   497	71	5	ret	Object
      //   16	61	6	llen	Object
      //   118	11	6	d	Object
      //   167	11	6	d	Object
      //   217	112	6	old_ret	Object
      //   363	11	6	d	Object
      //   423	11	6	d	Object
      //   475	11	6	d	Object
      //   516	38	6	x	Object
      //   308	11	7	d	Object
      // Exception table:
      //   from	to	target	type
      //   40	43	691	java/lang/ClassCastException
      //   57	60	705	java/lang/ClassCastException
      //   260	263	719	java/lang/ClassCastException
    }
    
    public void apply(gnu.mapping.CallContext paramCallContext)
    {
      ModuleMethod.applyError();
    }
  }
  
  public int readerGetPid()
  {
    if (gnu.expr.KawaConvert.isTrue(mFTReaderInf.isFtExist())) {}
    try { tmpTernaryOp = ((Number)gnu.mapping.Promise.force(kawa.lib.lists.cadr(kawa.lib.lists.assoc(Lit37, kawa.lib.lists.cdr((gnu.lists.Pair)(localObject = gnu.mapping.Promise.force(kawa.lib.lists.assoc(Lit216, descriptor$Mninfo), gnu.lists.Pair.class))))))).intValue();
      break label75; throw gnu.expr.Special.reachedUnexpected; label75: return kawa.lib.exceptions.error(new Object[] { "USB Not Opened" });
    }
    catch (ClassCastException localClassCastException)
    {
      Object localObject;
      throw new gnu.mapping.WrongType(
        localClassCastException, "cdr", 1, localObject);
    }
  }
  
  public int readerGetBcdDevice() { if (gnu.expr.KawaConvert.isTrue(mFTReaderInf.isFtExist())) {}
    try { tmpTernaryOp = ((Number)gnu.mapping.Promise.force(kawa.lib.lists.cadr(kawa.lib.lists.assoc(Lit38, kawa.lib.lists.cdr((gnu.lists.Pair)(localObject = gnu.mapping.Promise.force(kawa.lib.lists.assoc(Lit216, descriptor$Mninfo), gnu.lists.Pair.class))))))).intValue();
      break label75; throw gnu.expr.Special.reachedUnexpected; label75: return kawa.lib.exceptions.error(new Object[] { "USB Not Opened" });
    }
    catch (ClassCastException localClassCastException)
    {
      Object localObject;
      throw new gnu.mapping.WrongType(
        localClassCastException, "cdr", 1, localObject);
    }
  }
  
  public Object showLog(String log) {
    if (!gnu.expr.KawaConvert.isTrue(kawa.standard.Scheme.isEqual.apply2(null, mHandler)))
      mHandler.sendMessage(mHandler.obtainMessage(DK.CCIDSCHEME_LOG, log));
    return Integer.valueOf(android.util.Log.d("CCIDScheme", log));
  }
  






  public class frame2
    extends gnu.expr.ModuleBody
  {
    Object lst;
    




    final ModuleMethod lambda$Fn4;
    





    public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
    {
      if (selector == 4) return lambda4(paramObject) ? Boolean.TRUE : Boolean.FALSE; return super.apply1(paramModuleMethod, paramObject); } public void apply(gnu.mapping.CallContext paramCallContext) { ModuleMethod.applyError(); } public int match1(ModuleMethod paramModuleMethod, Object paramObject, gnu.mapping.CallContext paramCallContext) { if (selector == 4) { value1 = paramObject;proc = paramModuleMethod;pc = 1;return 0; } return super.match1(paramModuleMethod, paramObject, paramCallContext); } boolean lambda4(Object x) { try { return !gnu.expr.KawaConvert.isTrue(kawa.standard.Scheme.isEqual.apply2(x, kawa.lib.lists.car((gnu.lists.Pair)(localObject = gnu.mapping.Promise.force(lst, gnu.lists.Pair.class))))); } catch (ClassCastException localClassCastException) { Object localObject; throw new gnu.mapping.WrongType(localClassCastException, "car", 1, localObject);
      }
    }
    












    public frame2()
    {
      void tmp18_15 = new ModuleMethod(this, 4, null, 4097);
      tmp18_15.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/util.scm:228");
      lambda$Fn4 = tmp18_15;
    }
  }
  












  public class frame14
    extends gnu.expr.ModuleBody
  {
    Object usb_recv;
    











    Object slot;
    











    Object usb_send;
    











    public frame14() {}
    











    public Object lambda38loop2(Object _rB_)
    {
      for (;;)
      {
        try
        {
          if (gnu.expr.KawaConvert.isTrue(kawa.standard.Scheme.isEqual.apply2(CCIDScheme.Lit204, kawa.lib.lists.car((gnu.lists.Pair)(localObject1 = gnu.mapping.Promise.force(_rB_, gnu.lists.Pair.class)))))) {}
        }
        catch (ClassCastException localClassCastException4)
        {
          try
          {
            Object localObject1;
            





            tmp223_220[0] = kawa.lib.lists.cadr(kawa.lib.lists.assoc(CCIDScheme.Lit200, kawa.lib.lists.cdr((gnu.lists.Pair)tmp234_231))); } catch (ClassCastException localClassCastException4) { Object _ret_; Object localObject2; throw new gnu.mapping.WrongType(localClassCastException4, "cdr", 1, _ret_);
          }
          try {
            CCIDScheme.T1$MnTPDU$MnRblock$MnN_R.apply1(CCIDScheme.Lit15);
            
            _ret_ = Boolean.FALSE;
            kawa.standard.Scheme.applyToArgs
            

              .apply2(usb_send, CCIDScheme.PC_to_RDR_XfrBlock(slot, CCIDScheme.Lit1, CCIDScheme.Lit1, CCIDScheme.generateRBlockTPDUT1(CCIDScheme.T1$MnTPDU$MnRblock$MnN_R.apply1(CCIDScheme.Lit15), CCIDScheme.Lit1)));
            _ret_ = CCIDScheme.RDR_to_PC_DataBlock(kawa.standard.Scheme.applyToArgs.apply1(usb_recv));
            if (kawa.lib.lists.isNull(kawa.lib.lists.cadr(kawa.lib.lists.assoc(CCIDScheme.Lit129, _ret_))))
              throw gnu.expr.Special.reachedUnexpected;
            1[kawa.lib.exceptions.error(new Object[] { "this is error:2" })] = (gnu.expr.KawaConvert.isTrue(kawa.standard.Scheme.isEqual.apply2(CCIDScheme.Lit247, kawa.lib.lists.assoc(CCIDScheme.Lit206, kawa.lib.lists.cdr((gnu.lists.Pair)(_ret_ = gnu.mapping.Promise.force(_rB_, gnu.lists.Pair.class)))))) ? gnu.lists.LList.Empty : lambda38loop2(CCIDScheme.parseT1Block(kawa.lib.lists.cadr(kawa.lib.lists.assoc(CCIDScheme.Lit129, _ret_)), CCIDScheme.CCID$MnDEBUG.apply0())));return kawa.standard.append.append$V(tmp249_223);
          }
          catch (ClassCastException localClassCastException5)
          {
            throw new gnu.mapping.WrongType(localClassCastException5, "cdr", 1, _ret_);
          }
          throw new gnu.mapping.WrongType(
          
























            localClassCastException1, "car", 1, _ret_);
        }
        try
        {
          if ((gnu.expr.KawaConvert.isTrue(kawa.standard.Scheme.isEqual.apply2(CCIDScheme.Lit189, kawa.lib.lists.car((gnu.lists.Pair)(localObject1 = gnu.mapping.Promise.force(_rB_, gnu.lists.Pair.class)))))) && 
            (gnu.expr.KawaConvert.isTrue(kawa.standard.Scheme.isEqual.apply2(CCIDScheme.Lit246, kawa.lib.lists.cadr(_rB_))))) {
            _ret_ = Boolean.FALSE;
          }
        }
        catch (ClassCastException localClassCastException2)
        {
          throw new gnu.mapping.WrongType(localClassCastException2, "car", 1, _ret_);
        }
        

        try
        {
          kawa.standard.Scheme.applyToArgs.apply2(usb_send, CCIDScheme.PC_to_RDR_XfrBlock(slot, CCIDScheme.Lit1, CCIDScheme.Lit1, CCIDScheme.generateSBlockTPDUT1(CCIDScheme.Lit198, kawa.lib.lists.cadr(kawa.lib.lists.assoc(CCIDScheme.Lit200, kawa.lib.lists.cdr((gnu.lists.Pair)(localObject2 = gnu.mapping.Promise.force(_rB_, gnu.lists.Pair.class))))))));
          _ret_ = CCIDScheme.RDR_to_PC_DataBlock(kawa.standard.Scheme.applyToArgs.apply1(usb_recv));
          if (kawa.lib.lists.isNull(kawa.lib.lists.cadr(kawa.lib.lists.assoc(CCIDScheme.Lit129, _ret_))))
            throw gnu.expr.Special.reachedUnexpected;
          _rB_ = CCIDScheme.parseT1Block(kawa.lib.lists.cadr(kawa.lib.lists.assoc(;;
        }
        catch (ClassCastException localClassCastException3)
        {
          throw new gnu.mapping.WrongType(localClassCastException3, "cdr", 1, localObject2);
        }
      }
      

      throw gnu.expr.Special.reachedUnexpected;
      _ret_ = gnu.mapping.Promise.force(_rB_, gnu.lists.Pair.class);
    }
  }
  
















  public class frame12
    extends gnu.expr.ModuleBody
  {
    Object info;
    
















    public frame12() {}
    















    public void lambda32setinfo$V(Object arg1, Object[] argsArray)
    {
      gnu.lists.LList localLList1;
      














      gnu.lists.LList arg2s = localLList1 = gnu.lists.LList.makeList(argsArray, 0);
      info = CCIDScheme.stringlst$To$String(kawa.lib.lists.cons(info, kawa.lib.lists.cons(arg1, arg2s)));
    }
  }
  
  public class frame15
    extends gnu.expr.ModuleBody
  {
    Object atr;
    boolean _isFirstTime_;
    Object index;
    Object usb_recv;
    Object usb_send;
    final ModuleMethod usb_send_recv$Fn24;
    final ModuleMethod lambda$Fn25;
    final ModuleMethod lambda$Fn26;
    final ModuleMethod lambda$Fn27;
    final ModuleMethod lambda$Fn28;
    
    public static Object lambda41doPowerOnInside(Object usb_send_recv, Object slot)
    {
      gnu.lists.Pair ret = CCIDScheme.RDR_to_PC_DataBlock(kawa.standard.Scheme.applyToArgs.apply2(usb_send_recv, CCIDScheme.PC_to_RDR_IccPowerOn(slot, CCIDScheme.getVoltageSupportFromDescriptor(CCIDScheme.descriptor$Mninfo))));
      if (!gnu.expr.KawaConvert.isTrue(kawa.standard.Scheme.isEqual.apply2(kawa.lib.lists.assoc(CCIDScheme.Lit126, ret), gnu.lists.LList.list2(CCIDScheme.Lit126, slot))))
        throw gnu.expr.Special.reachedUnexpected;
      return kawa.lib.lists.cadr(kawa.lib.lists.assoc(CCIDScheme.Lit129, ret));
    }
    
    public Object lambda40usb_send_recv(Object data)
    {
      kawa.standard.Scheme.applyToArgs.apply2(usb_send, data);return kawa.standard.Scheme.applyToArgs.apply1(usb_recv);
    }
    






































    public int match1(ModuleMethod paramModuleMethod, Object paramObject, gnu.mapping.CallContext paramCallContext)
    {
      switch (selector) {case 17:  value1 = paramObject;proc = paramModuleMethod;pc = 1;return 0;
      case 15: 
        value1 = paramObject;proc = paramModuleMethod;pc = 1;return 0;
      case 13: 
        value1 = paramObject;proc = paramModuleMethod;pc = 1;return 0;
      case 11: 
        value1 = paramObject;proc = paramModuleMethod;pc = 1;return 0;
      case 10: 
        value1 = paramObject;proc = paramModuleMethod;pc = 1;return 0; } return super.match1(paramModuleMethod, paramObject, paramCallContext);
    }
    






































    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, gnu.mapping.CallContext paramCallContext)
    {
      switch (selector) {case 17:  value1 = paramObject1;value2 = paramObject2;proc = paramModuleMethod;pc = 2;return 0;
      case 15: 
        value1 = paramObject1;value2 = paramObject2;proc = paramModuleMethod;pc = 2;return 0;
      case 13: 
        value1 = paramObject1;value2 = paramObject2;proc = paramModuleMethod;pc = 2;return 0;
      case 11: 
        value1 = paramObject1;value2 = paramObject2;proc = paramModuleMethod;pc = 2;return 0; } return super.match2(paramModuleMethod, paramObject1, paramObject2, paramCallContext); }
    Object lambda42(Object data, Object slot) { CCIDScheme.current_dev_interface.apply2(CCIDScheme.Lit13, index);
      return CCIDScheme.doXfrBlockAPDUExtendedProtocol(usb_send, usb_recv, slot, data); }
    
    Object lambda43(Object data, Object slot) { return CCIDScheme.doXfrBlockTPDUT0Protocol(usb_send, usb_recv, slot, data); }
    
    Object lambda44(Object data, Object slot) {
      return CCIDScheme.doXfrBlockTPDUT0Protocol(usb_send, usb_recv, slot, data);
    }
    
    public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
    {
      switch (selector) {case 10:  return lambda40usb_send_recv(paramObject);
      































      case 11: 
        return lambda42(paramObject);
      
      case 13: 
        return lambda43(paramObject);
      
      case 15: 
        return lambda44(paramObject);
      
      case 17: 
        return lambda45(paramObject); } return super.apply1(paramModuleMethod, paramObject);
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      switch (selector) {case 11:  return lambda42(paramObject1, paramObject2);
      
      case 13: 
        return lambda43(paramObject1, paramObject2);
      
      case 15: 
        return lambda44(paramObject1, paramObject2);
      
      case 17: 
        return lambda45(paramObject1, paramObject2); } return super.apply2(paramModuleMethod, paramObject1, paramObject2); }
    Object lambda45(Object data, Object slot) { if (_isFirstTime_)
      {
        _isFirstTime_ = false;
        CCIDScheme.pp.apply1("is first time");
        CCIDScheme.IFSRequestTPDUT1(usb_send, usb_recv, slot, atr); }
      return CCIDScheme.doXfrBlockTPDUT1Protocol(usb_send, usb_recv, slot, data, atr);
    }
    























    public frame15()
    {
      void tmp20_17 = new ModuleMethod(this, 10, "usb_send_recv", 4097);
      tmp20_17.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid.scm:418");
      usb_send_recv$Fn24 = tmp20_17;
      void tmp46_43 = new ModuleMethod(this, 11, null, 8193);
      tmp46_43.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid.scm:452");
      lambda$Fn25 = tmp46_43;
      void tmp72_69 = new ModuleMethod(this, 13, null, 8193);
      tmp72_69.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid.scm:455");
      lambda$Fn26 = tmp72_69;
      void tmp98_95 = new ModuleMethod(this, 15, null, 8193);
      tmp98_95.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid.scm:458");
      lambda$Fn27 = tmp98_95;
      void tmp124_121 = new ModuleMethod(this, 17, null, 8193);
      tmp124_121.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid.scm:461");
      lambda$Fn28 = tmp124_121;
    }
    























    Object lambda42(Object paramObject)
    {
      return lambda42(paramObject, CCIDScheme.Lit1);
    }
    























    Object lambda43(Object paramObject)
    {
      return lambda43(paramObject, CCIDScheme.Lit1);
    }
    























    Object lambda44(Object paramObject)
    {
      return lambda44(paramObject, CCIDScheme.Lit1);
    }
    























    Object lambda45(Object paramObject)
    {
      return lambda45(paramObject, CCIDScheme.Lit1);
    }
    























    public void apply(gnu.mapping.CallContext paramCallContext)
    {
      ModuleMethod.applyError();
    }
  }
  























  public static final ModuleMethod make$Mncontainer;
  






















  public static final ModuleMethod to$Mnlist;
  






















  public static final ModuleMethod read$Mnu8s;
  






















  public static final ModuleMethod call$Mnwith$Mninput$Mnu8vector;
  






















  public static gnu.mapping.Procedure pp;
  






















  public static final ModuleMethod subu8list;
  






















  public static final ModuleMethod group$Mnlist;
  






















  public static final ModuleMethod filter;
  






















  public static final ModuleMethod assoc$MnEX;
  






















  public static final ModuleMethod list$Mnxor;
  






















  public static final ModuleMethod to$MnhexStr;
  






















  public static final ModuleMethod to$MnoctStr;
  






















  public static final ModuleMethod to$MnbinStr;
  






















  public static final ModuleMethod u8list$Mn$Grstring;
  






















  public static final ModuleMethod in$Mnlist$Qu;
  






















  public static final ModuleMethod byte$Mn$Grbit;
  






















  public static final ModuleMethod list$Mnremove$Mnduplication;
  






















  public static final ModuleMethod float$Mn$Grinteger;
  






















  public static final ModuleMethod stringlst$Mn$Grstring;
  






















  public static final ModuleMethod alist$Mn$Grlist;
  






















  public static final ModuleMethod get$Mnconfiguration$Mndescriptor;
  






















  public static final ModuleMethod get$Mnstring$Mndescriptor;
  






















  public static final ModuleMethod get$Mndevice$Mndescriptor;
  






















  public static Object descriptor$Mninfo;
  






















  public static gnu.mapping.Procedure current_dev_interface;
  






















  public static final ModuleMethod parse$Mndescriptor;
  






















  public static final ModuleMethod get$MnvoltageSupport$Mnfrom$Mndescriptor;
  






















  public static Object _ccid_bSeq_;
  






















  public static final ModuleMethod get$MnbSeq;
  






















  public static final ModuleMethod get$MnbStatus$MnbError$MnerrorName;
  






















  public static final ModuleMethod PC_to_RDR_IccPowerOn;
  






















  public static final ModuleMethod PC_to_RDR_XfrBlock;
  






















  public static final ModuleMethod RDR_to_PC_DataBlock;
  






















  public static final ModuleMethod PC_to_RDR_IccPowerOff;
  






















  public static final ModuleMethod RDR_to_PC_SlotStatus;
  






















  public static final ModuleMethod PC_to_RDR_SetParameters;
  






















  public static final ModuleMethod RDR_to_PC_Parameters;
  






















  public static final ModuleMethod PC_to_RDR_Escape;
  






















  public static final ModuleMethod RDR_to_PC_Escape;
  






















  public static final ModuleMethod PC_to_RDR_GetSlotStatus;
  






















  public static final ModuleMethod parse$MnATR;
  






















  public static final ModuleMethod parse$MnatrTA1;
  






















  public static final ModuleMethod get$MnatrSupportProtocol;
  






















  public static final ModuleMethod get$MnatrTATB$Mnfor$MnT15;
  






















  public static final ModuleMethod get$Mnpps1;
  






















  public static final ModuleMethod generate$MnPPS$Mnexchange;
  






















  public static final ModuleMethod get$MnatrIFSC;
  






















  public static final ModuleMethod get$MnatrTC$Mnfor$MnT1;
  






















  public static final ModuleMethod get$MnatrTB$Mnfor$MnT1;
  






















  public static final ModuleMethod generate$MnPPS$Mnparameters$MnT1;
  






















  public static final ModuleMethod generate$MnPPS$Mnparameters$MnT0;
  






















  public static final ModuleMethod get$MnCard$MnTimeout$MnT1;
  






















  public static final ModuleMethod get$MnCard$MnTimeout$MnT0;
  






















  public static final ModuleMethod get$MnCard$MnTimeout;
  






















  public static final ModuleMethod parse$MnT1Block;
  






















  public static final ModuleMethod generate$MnS$Mnblock$MnTPDU$MnT1;
  






















  public static final ModuleMethod generate$MnI$Mnblock$MnTPDU$MnT1;
  






















  public static final ModuleMethod generate$MnR$Mnblock$MnTPDU$MnT1;
  






















  public static boolean ccid$Mndata$Mnrates$Mnsupported;
  






















  public static Object USB_TIMEOUT;
  






















  public static final ModuleMethod make$MnGET_DEVICE_INF$Mnfunc;
  






















  public static final ModuleMethod do$MnPPS$Mnexchange;
  






















  public static final ModuleMethod do$MnPPS$Mnset$Mnparameters;
  






















  public static final ModuleMethod do$MnPPS;
  






















  public static final ModuleMethod get$Mnccid$Mnexchange$Mnlevel;
  






















  public static final ModuleMethod do$MnXfrBlock$MnTPDU$MnT0$MnProtocol;
  






















  public static final ModuleMethod do$MnXfrBlock$MnAPDU$MnExtended$MnProtocol;
  






















  public static gnu.mapping.Procedure T1$MnTPDU$MnIblock$MnN_S;
  






















  public static gnu.mapping.Procedure T1$MnTPDU$MnRblock$MnN_R;
  






















  public static final ModuleMethod IFS$Mnrequest$MnTPDU$MnT1;
  






















  public static final ModuleMethod do$MnXfrBlock$MnTPDU$MnT1$MnProtocol;
  






















  public static gnu.mapping.Procedure CCID$MnDEBUG;
  






















  public static final ModuleMethod do$MnInitDescriptorInf;
  






















  public static final ModuleMethod do$MnPowerOff;
  






















  public static final ModuleMethod do$MnPowerOn;
  






















  public static final ModuleMethod do$MnEscape;
  






















  public static final ModuleMethod do$MnSlotStatus;
  






















  public static final Class Thread;
  






















  public static final kawa.lang.Macro simple$Mnthread;
  






















  public static final ModuleMethod thread$Mnsleep$Ex;
  






















  public static final ModuleMethod make$Mnthread;
  






















  public static final ModuleMethod thread$Mnstart$Ex;
  






















  public static final gnu.kawa.lispexpr.ClassNamespace Log;
  






















  public static final gnu.kawa.lispexpr.ClassNamespace Object;
  






















  public static final gnu.kawa.lispexpr.ClassNamespace FTReaderInf;
  






















  public static final gnu.kawa.lispexpr.ClassNamespace Context;
  






















  public static final gnu.kawa.lispexpr.ClassNamespace Handler;
  






















  public static final ModuleMethod GET_DEVICES_INF_default;
  






















  public static Object GET_DEVICES_INF;
  






















  public static gnu.mapping.Procedure USB_CONTROL_IN;
  






















  public static gnu.mapping.Procedure USB_SEND;
  






















  public static gnu.mapping.Procedure USB_RECV;
  






















  public static gnu.mapping.Procedure USB_SEND_RECV;
  






















  public static gnu.mapping.Procedure USB_INTERRUPT_RECV;
  






















  public static Object XfrBlock$Mnhash$Mntable;
  






















  public static final Class CCIDScheme;
  






















  static boolean _debug_;
  






















  static Object nr;
  






















  static Object ns;
  






















  static Object _current_interface_;
  






















  static final gnu.bytecode.ArrayType Lit0;
  






















  static final gnu.math.IntNum Lit1;
  






















  static final gnu.math.IntNum Lit2;
  






















  static final gnu.expr.Keyword Lit3;
  






















  static final gnu.mapping.SimpleSymbol Lit4;
  






















  static final gnu.math.IntNum Lit5;
  






















  static final gnu.math.IntNum Lit6;
  






















  static final gnu.math.IntNum Lit7;
  






















  static final gnu.mapping.SimpleSymbol Lit8;
  






















  static final gnu.math.IntNum Lit9;
  






















  static final gnu.math.IntNum Lit10;
  






















  static final gnu.math.IntNum Lit11;
  






















  static final gnu.math.IntNum Lit12;
  






















  static final gnu.mapping.SimpleSymbol Lit13;
  






















  static final gnu.mapping.SimpleSymbol Lit14;
  






















  static final gnu.mapping.SimpleSymbol Lit15;
  






















  static final ModuleMethod lambda$Fn3;
  





















  static final gnu.math.IntNum Lit16;
  





















  static final gnu.math.IntNum Lit17;
  





















  static final gnu.math.IntNum Lit18;
  





















  static final gnu.lists.PairWithPosition Lit19;
  





















  static final gnu.math.IntNum Lit20;
  





















  static final gnu.math.IntNum Lit21;
  





















  static final gnu.math.IntNum Lit22;
  





















  static final gnu.math.IntNum Lit23;
  





















  static final gnu.math.IntNum Lit24;
  





















  static final gnu.math.IntNum Lit25;
  





















  static final gnu.math.IntNum Lit26;
  





















  static final gnu.mapping.SimpleSymbol Lit27;
  





















  static final ModuleMethod lambda$Fn5;
  





















  static final ModuleMethod lambda$Fn6;
  





















  static final ModuleMethod lambda$Fn7;
  





















  static final gnu.lists.PairWithPosition Lit28;
  





















  static final ModuleMethod lambda$Fn9;
  





















  static final gnu.mapping.SimpleSymbol Lit29;
  





















  static final gnu.mapping.SimpleSymbol Lit30;
  





















  static final gnu.mapping.SimpleSymbol Lit31;
  





















  static final gnu.mapping.SimpleSymbol Lit32;
  





















  static final gnu.mapping.SimpleSymbol Lit33;
  





















  static final gnu.mapping.SimpleSymbol Lit34;
  





















  static final gnu.mapping.SimpleSymbol Lit35;
  





















  static final gnu.mapping.SimpleSymbol Lit36;
  





















  static final gnu.mapping.SimpleSymbol Lit37;
  





















  static final gnu.mapping.SimpleSymbol Lit38;
  





















  static final gnu.mapping.SimpleSymbol Lit39;
  





















  static final gnu.mapping.SimpleSymbol Lit40;
  





















  static final gnu.mapping.SimpleSymbol Lit41;
  





















  static final gnu.mapping.SimpleSymbol Lit42;
  





















  static final gnu.lists.PairWithPosition Lit43;
  





















  static final ModuleMethod lambda$Fn10;
  





















  static final gnu.mapping.SimpleSymbol Lit44;
  





















  static final gnu.mapping.SimpleSymbol Lit45;
  





















  static final gnu.mapping.SimpleSymbol Lit46;
  





















  static final gnu.mapping.SimpleSymbol Lit47;
  





















  static final gnu.mapping.SimpleSymbol Lit48;
  





















  static final gnu.mapping.SimpleSymbol Lit49;
  





















  static final gnu.lists.PairWithPosition Lit50;
  





















  static final ModuleMethod lambda$Fn11;
  





















  static final gnu.mapping.SimpleSymbol Lit51;
  





















  static final gnu.mapping.SimpleSymbol Lit52;
  





















  static final gnu.mapping.SimpleSymbol Lit53;
  





















  static final gnu.mapping.SimpleSymbol Lit54;
  





















  static final gnu.mapping.SimpleSymbol Lit55;
  





















  static final gnu.mapping.SimpleSymbol Lit56;
  





















  static final gnu.mapping.SimpleSymbol Lit57;
  





















  static final gnu.math.IntNum Lit58;
  





















  static final ModuleMethod lambda$Fn12;
  





















  static final gnu.mapping.SimpleSymbol Lit59;
  





















  static final gnu.mapping.SimpleSymbol Lit60;
  





















  static final gnu.mapping.SimpleSymbol Lit61;
  





















  static final gnu.lists.PairWithPosition Lit62;
  





















  static final gnu.lists.PairWithPosition Lit63;
  





















  static final gnu.lists.PairWithPosition Lit64;
  





















  static final gnu.lists.PairWithPosition Lit65;
  





















  static final gnu.lists.PairWithPosition Lit66;
  





















  static final gnu.lists.PairWithPosition Lit67;
  





















  static final gnu.math.IntNum Lit68;
  





















  static final gnu.lists.PairWithPosition Lit69;
  





















  static final ModuleMethod lambda$Fn13;
  





















  static final gnu.mapping.SimpleSymbol Lit70;
  





















  static final gnu.mapping.SimpleSymbol Lit71;
  





















  static final gnu.mapping.SimpleSymbol Lit72;
  





















  static final gnu.mapping.SimpleSymbol Lit73;
  





















  static final gnu.mapping.SimpleSymbol Lit74;
  





















  static final gnu.mapping.SimpleSymbol Lit75;
  





















  static final gnu.mapping.SimpleSymbol Lit76;
  





















  static final gnu.mapping.SimpleSymbol Lit77;
  





















  static final gnu.mapping.SimpleSymbol Lit78;
  





















  static final gnu.mapping.SimpleSymbol Lit79;
  





















  static final gnu.mapping.SimpleSymbol Lit80;
  





















  static final gnu.mapping.SimpleSymbol Lit81;
  





















  static final gnu.mapping.SimpleSymbol Lit82;
  





















  static final gnu.mapping.SimpleSymbol Lit83;
  





















  static final gnu.mapping.SimpleSymbol Lit84;
  





















  static final gnu.mapping.SimpleSymbol Lit85;
  





















  static final gnu.mapping.SimpleSymbol Lit86;
  





















  static final gnu.mapping.SimpleSymbol Lit87;
  





















  static final gnu.mapping.SimpleSymbol Lit88;
  





















  static final gnu.mapping.SimpleSymbol Lit89;
  





















  static final gnu.math.IntNum Lit90;
  





















  static final ModuleMethod lambda$Fn14;
  





















  static final gnu.mapping.SimpleSymbol Lit91;
  





















  static final gnu.mapping.SimpleSymbol Lit92;
  





















  static final gnu.mapping.SimpleSymbol Lit93;
  





















  static final gnu.mapping.SimpleSymbol Lit94;
  





















  static final gnu.mapping.SimpleSymbol Lit95;
  





















  static final gnu.mapping.SimpleSymbol Lit96;
  





















  static final gnu.lists.PairWithPosition Lit97;
  





















  static final gnu.mapping.SimpleSymbol Lit98;
  





















  static final gnu.math.IntNum Lit99;
  





















  static final gnu.mapping.SimpleSymbol Lit100;
  





















  static final gnu.math.IntNum Lit101;
  





















  static final gnu.math.IntNum Lit102;
  





















  static final gnu.math.IntNum Lit103;
  





















  static final gnu.math.IntNum Lit104;
  





















  static final gnu.math.IntNum Lit105;
  





















  static final gnu.math.IntNum Lit106;
  





















  static final gnu.math.IntNum Lit107;
  





















  static final gnu.math.IntNum Lit108;
  





















  static final gnu.math.IntNum Lit109;
  





















  static final gnu.math.IntNum Lit110;
  





















  static final gnu.math.IntNum Lit111;
  





















  static final gnu.math.IntNum Lit112;
  





















  static final gnu.math.IntNum Lit113;
  





















  static final gnu.math.IntNum Lit114;
  





















  static final gnu.math.IntNum Lit115;
  





















  static final gnu.math.IntNum Lit116;
  





















  static final gnu.math.IntNum Lit117;
  





















  static final gnu.math.IntNum Lit118;
  





















  static final gnu.math.IntNum Lit119;
  





















  static final gnu.math.IntNum Lit120;
  





















  static final gnu.math.IntNum Lit121;
  





















  static final gnu.math.IntNum Lit122;
  





















  static final gnu.mapping.SimpleSymbol Lit123;
  





















  static final gnu.mapping.SimpleSymbol Lit124;
  





















  static final gnu.mapping.SimpleSymbol Lit125;
  





















  static final gnu.mapping.SimpleSymbol Lit126;
  





















  static final gnu.mapping.SimpleSymbol Lit127;
  





















  static final gnu.mapping.SimpleSymbol Lit128;
  





















  static final gnu.mapping.SimpleSymbol Lit129;
  





















  static final gnu.math.IntNum Lit130;
  





















  static final gnu.lists.PairWithPosition Lit131;
  





















  static final gnu.mapping.SimpleSymbol Lit132;
  





















  static final gnu.math.IntNum Lit133;
  





















  static final gnu.lists.PairWithPosition Lit134;
  





















  static final gnu.math.IntNum Lit135;
  





















  static final gnu.mapping.SimpleSymbol Lit136;
  





















  static final gnu.mapping.SimpleSymbol Lit137;
  





















  static final gnu.math.IntNum Lit138;
  





















  static final gnu.mapping.SimpleSymbol Lit139;
  





















  static final gnu.math.IntNum Lit140;
  





















  static final ModuleMethod lambda$Fn16;
  





















  static final gnu.mapping.SimpleSymbol Lit141;
  





















  static final gnu.mapping.SimpleSymbol Lit142;
  





















  static final gnu.mapping.SimpleSymbol Lit143;
  





















  static final gnu.mapping.SimpleSymbol Lit144;
  





















  static final gnu.mapping.SimpleSymbol Lit145;
  





















  static final gnu.mapping.SimpleSymbol Lit146;
  





















  static final gnu.mapping.SimpleSymbol Lit147;
  





















  static final gnu.mapping.SimpleSymbol Lit148;
  





















  static final gnu.mapping.SimpleSymbol Lit149;
  





















  static final gnu.lists.PairWithPosition Lit150;
  





















  static final gnu.math.IntNum Lit151;
  





















  static final gnu.mapping.SimpleSymbol Lit152;
  





















  static final gnu.lists.PairWithPosition Lit153;
  





















  static final gnu.mapping.SimpleSymbol Lit154;
  





















  static final gnu.lists.PairWithPosition Lit155;
  





















  static final gnu.mapping.SimpleSymbol Lit156;
  





















  static final gnu.lists.PairWithPosition Lit157;
  





















  static final ModuleMethod lambda$Fn17;
  





















  static final gnu.mapping.SimpleSymbol Lit158;
  





















  static final gnu.mapping.SimpleSymbol Lit159;
  





















  static final gnu.mapping.SimpleSymbol Lit160;
  





















  static final ModuleMethod lambda$Fn18;
  





















  static final gnu.lists.PairWithPosition Lit161;
  





















  static final gnu.math.IntNum Lit162;
  





















  static final gnu.mapping.SimpleSymbol Lit163;
  





















  static final gnu.mapping.SimpleSymbol Lit164;
  





















  static final gnu.mapping.SimpleSymbol Lit165;
  





















  static final gnu.math.IntNum Lit166;
  





















  static final gnu.math.IntNum Lit167;
  





















  static final gnu.mapping.SimpleSymbol Lit168;
  





















  static final gnu.math.IntNum Lit169;
  





















  static final gnu.mapping.SimpleSymbol Lit170;
  





















  static final gnu.math.IntNum Lit171;
  





















  static final gnu.math.IntNum Lit172;
  





















  static final ModuleMethod lambda$Fn19;
  





















  static final gnu.math.IntNum Lit173;
  





















  static final gnu.math.IntNum Lit174;
  





















  static final gnu.math.IntNum Lit175;
  





















  static final gnu.math.IntNum Lit176;
  





















  static final gnu.math.IntNum Lit177;
  





















  static final gnu.math.DFloNum Lit178;
  





















  static final gnu.math.IntNum Lit179;
  





















  static final gnu.math.IntNum Lit180;
  





















  static final gnu.math.IntNum Lit181;
  





















  static final gnu.math.IntNum Lit182;
  





















  static final gnu.math.IntNum Lit183;
  





















  static final gnu.math.IntNum Lit184;
  





















  static final gnu.math.IntNum Lit185;
  





















  static final gnu.math.IntNum Lit186;
  





















  static final gnu.math.IntNum Lit187;
  





















  static final gnu.math.IntNum Lit188;
  





















  static final gnu.mapping.SimpleSymbol Lit189;
  





















  static final gnu.mapping.SimpleSymbol Lit190;
  





















  static final gnu.mapping.SimpleSymbol Lit191;
  





















  static final gnu.mapping.SimpleSymbol Lit192;
  





















  static final gnu.mapping.SimpleSymbol Lit193;
  





















  static final gnu.mapping.SimpleSymbol Lit194;
  





















  static final gnu.mapping.SimpleSymbol Lit195;
  





















  static final gnu.mapping.SimpleSymbol Lit196;
  





















  static final gnu.mapping.SimpleSymbol Lit197;
  





















  static final gnu.mapping.SimpleSymbol Lit198;
  





















  static final gnu.mapping.SimpleSymbol Lit199;
  





















  static final gnu.mapping.SimpleSymbol Lit200;
  





















  static final gnu.mapping.SimpleSymbol Lit201;
  





















  static final gnu.mapping.SimpleSymbol Lit202;
  





















  static final gnu.mapping.SimpleSymbol Lit203;
  





















  static final gnu.mapping.SimpleSymbol Lit204;
  





















  static final gnu.mapping.SimpleSymbol Lit205;
  





















  static final gnu.mapping.SimpleSymbol Lit206;
  





















  static final gnu.math.IntNum Lit207;
  





















  static final gnu.math.IntNum Lit208;
  





















  static final gnu.mapping.SimpleSymbol Lit209;
  





















  static final gnu.math.IntNum Lit210;
  





















  static final gnu.math.IntNum Lit211;
  





















  static final gnu.mapping.SimpleSymbol Lit212;
  





















  static final gnu.math.IntNum Lit213;
  





















  static final gnu.math.IntNum Lit214;
  





















  static final gnu.mapping.SimpleSymbol Lit215;
  





















  static final gnu.mapping.SimpleSymbol Lit216;
  





















  static final gnu.mapping.SimpleSymbol Lit217;
  





















  static final gnu.mapping.SimpleSymbol Lit218;
  





















  static final gnu.lists.PairWithPosition Lit219;
  





















  static final gnu.lists.PairWithPosition Lit220;
  





















  static final gnu.mapping.SimpleSymbol Lit221;
  





















  static final gnu.mapping.SimpleSymbol Lit222;
  





















  static final gnu.mapping.SimpleSymbol Lit223;
  





















  static final gnu.mapping.SimpleSymbol Lit224;
  





















  static final gnu.mapping.SimpleSymbol Lit225;
  





















  static final gnu.mapping.SimpleSymbol Lit226;
  





















  static final gnu.mapping.SimpleSymbol Lit227;
  





















  static final gnu.mapping.SimpleSymbol Lit228;
  





















  static final gnu.math.IntNum Lit229;
  





















  static final gnu.math.IntNum Lit230;
  





















  static final gnu.math.IntNum Lit231;
  





















  static final gnu.math.IntNum Lit232;
  





















  static final gnu.mapping.SimpleSymbol Lit233;
  





















  static final gnu.math.IntNum Lit234;
  





















  static final gnu.mapping.SimpleSymbol Lit235;
  





















  static final gnu.math.IntNum Lit236;
  





















  static final gnu.mapping.SimpleSymbol Lit237;
  





















  static final gnu.mapping.SimpleSymbol Lit238;
  





















  static final gnu.lists.PairWithPosition Lit239;
  





















  static final gnu.lists.PairWithPosition Lit240;
  





















  static final gnu.lists.PairWithPosition Lit241;
  





















  static final gnu.lists.PairWithPosition Lit242;
  





















  static final gnu.lists.PairWithPosition Lit243;
  





















  static final ModuleMethod lambda$Fn21;
  





















  static final gnu.mapping.SimpleSymbol Lit244;
  





















  static final ModuleMethod lambda$Fn22;
  





















  static final gnu.lists.PairWithPosition Lit245;
  





















  static final gnu.lists.PairWithPosition Lit246;
  





















  static final gnu.lists.PairWithPosition Lit247;
  





















  static final ModuleMethod lambda$Fn23;
  





















  static final gnu.mapping.SimpleSymbol Lit248;
  





















  static final gnu.mapping.SimpleSymbol Lit249;
  





















  static final gnu.lists.PairWithPosition Lit250;
  





















  static final gnu.mapping.SimpleSymbol Lit251;
  





















  static final gnu.mapping.SimpleSymbol Lit252;
  





















  static final ModuleMethod lambda$Fn29;
  





















  static final ModuleMethod lambda$Fn30;
  





















  static final ModuleMethod lambda$Fn31;
  





















  static final ModuleMethod lambda$Fn32;
  





















  static final ModuleMethod lambda$Fn33;
  





















  static final ModuleMethod lambda$Fn37;
  





















  static final gnu.lists.PairWithPosition Lit253;
  





















  static final gnu.lists.PairWithPosition Lit254;
  





















  static final gnu.bytecode.ArrayType Lit255;
  





















  static final gnu.mapping.SimpleSymbol Lit256;
  





















  static final gnu.mapping.SimpleSymbol Lit257;
  





















  static final kawa.lang.SyntaxPattern Lit258;
  





















  static final kawa.lang.SyntaxTemplate Lit259;
  





















  static final gnu.mapping.SimpleSymbol Lit260;
  





















  static final gnu.math.IntNum Lit261;
  





















  static final gnu.lists.PairWithPosition Lit262;
  





















  static final gnu.lists.PairWithPosition Lit263;
  





















  static final gnu.lists.PairWithPosition Lit264;
  





















  static final gnu.lists.PairWithPosition Lit265;
  





















  static final gnu.lists.PairWithPosition Lit266;
  





















  static final gnu.lists.PairWithPosition Lit267;
  





















  static final gnu.lists.PairWithPosition Lit268;
  





















  static final gnu.lists.PairWithPosition Lit269;
  





















  static final gnu.lists.PairWithPosition Lit270;
  





















  static final gnu.lists.PairWithPosition Lit271;
  





















  static final gnu.lists.PairWithPosition Lit272;
  





















  static final gnu.lists.PairWithPosition Lit273;
  





















  static final gnu.lists.PairWithPosition Lit274;
  





















  static final gnu.lists.PairWithPosition Lit275;
  





















  static final gnu.lists.PairWithPosition Lit276;
  





















  static final gnu.lists.PairWithPosition Lit277;
  





















  public static gnu.lists.U8Vector list$To$U8vector(Object l)
  {
    byte[] b = 
    
      (byte[])gnu.mapping.Promise.force(kawa.standard.Scheme.apply.apply2(Lit0, l));return new gnu.lists.U8Vector(b);
  }
  

  public static Object u8vector$To$List(Object data) { return kawa.standard.Scheme.apply.apply2(gnu.kawa.lispexpr.LangObjType.listType, data); }
  
  public static gnu.lists.U8Vector makeU8vector(Object num, Object fixed) {
    try { return new gnu.lists.U8Vector(((Number)(localObject = gnu.mapping.Promise.force(num))).intValue(), (byte)1); } catch (ClassCastException localClassCastException) { Object localObject; throw new gnu.mapping.WrongType(localClassCastException, "gnu.lists.U8Vector.<init>(int,byte)", 1, localObject);
    } }
  
  public static String object$To$String(Object obj) { return gnu.kawa.functions.Format.formatToString(0, new Object[] { "~A", obj }); }
  








  public static Object buildDwordFromlst$V(Object lst, Object[] argsArray)
  {
    Object endia = gnu.expr.Keyword.searchForKeyword(argsArray, 0, Lit3, Lit4);
    














    throw (endia == Lit8 ? gnu.kawa.functions.BitwiseOp.ior.apply2(gnu.kawa.functions.BitwiseOp.ior.apply2(gnu.kawa.functions.BitwiseOp.ior.apply2(gnu.kawa.functions.BitwiseOp.ashift.apply2(kawa.lib.lists.listRef(lst, 0), Lit5), gnu.kawa.functions.BitwiseOp.ashift.apply2(kawa.lib.lists.listRef(lst, 1), Lit6)), gnu.kawa.functions.BitwiseOp.ashift.apply2(kawa.lib.lists.listRef(lst, 2), Lit7)), kawa.lib.lists.listRef(lst, 3)) : endia == Lit4 ? gnu.kawa.functions.BitwiseOp.ior.apply2(gnu.kawa.functions.BitwiseOp.ior.apply2(gnu.kawa.functions.BitwiseOp.ior.apply2(gnu.kawa.functions.BitwiseOp.ashift.apply2(kawa.lib.lists.listRef(lst, 3), Lit5), gnu.kawa.functions.BitwiseOp.ashift.apply2(kawa.lib.lists.listRef(lst, 2), Lit6)), gnu.kawa.functions.BitwiseOp.ashift.apply2(kawa.lib.lists.listRef(lst, 1), Lit7)), kawa.lib.lists.listRef(lst, 0)) : gnu.expr.Special.reachedUnexpected);return kawa.lib.exceptions.error(new Object[] { "build-dword-fromlst", "parameter error!" });
  }
  
  public static gnu.lists.Pair buildDwordInlst$V(Object dword, Object[] argsArray) { Object endia = gnu.expr.Keyword.searchForKeyword(argsArray, 0, Lit3, Lit4);
    













    throw (endia == Lit8 ? gnu.lists.LList.list4(gnu.kawa.functions.BitwiseOp.and.apply2(gnu.kawa.functions.BitwiseOp.ashift.apply2(dword, Lit12), Lit9), gnu.kawa.functions.BitwiseOp.and.apply2(gnu.kawa.functions.BitwiseOp.ashift.apply2(dword, Lit11), Lit9), gnu.kawa.functions.BitwiseOp.and.apply2(gnu.kawa.functions.BitwiseOp.ashift.apply2(dword, Lit10), Lit9), gnu.kawa.functions.BitwiseOp.and.apply2(dword, Lit9)) : endia == Lit4 ? gnu.lists.LList.list4(gnu.kawa.functions.BitwiseOp.and.apply2(dword, Lit9), gnu.kawa.functions.BitwiseOp.and.apply2(gnu.kawa.functions.BitwiseOp.ashift.apply2(dword, Lit10), Lit9), gnu.kawa.functions.BitwiseOp.and.apply2(gnu.kawa.functions.BitwiseOp.ashift.apply2(dword, Lit11), Lit9), gnu.kawa.functions.BitwiseOp.and.apply2(gnu.kawa.functions.BitwiseOp.ashift.apply2(dword, Lit12), Lit9)) : gnu.expr.Special.reachedUnexpected);return kawa.lib.exceptions.error(new Object[] { "build-dword-inlst", "parameter error!" });
  }
  
  public static Object buildWordFromlst$V(Object lst, Object[] argsArray) { Object endia = gnu.expr.Keyword.searchForKeyword(argsArray, 0, Lit3, Lit4);
    









    throw (endia == Lit8 ? gnu.kawa.functions.BitwiseOp.ior.apply2(gnu.kawa.functions.BitwiseOp.ashift.apply2(kawa.lib.lists.listRef(lst, 0), Lit7), kawa.lib.lists.listRef(lst, 1)) : endia == Lit4 ? gnu.kawa.functions.BitwiseOp.ior.apply2(gnu.kawa.functions.BitwiseOp.ashift.apply2(kawa.lib.lists.listRef(lst, 1), Lit7), kawa.lib.lists.listRef(lst, 0)) : gnu.expr.Special.reachedUnexpected);return kawa.lib.exceptions.error(new Object[] { "build-word-fromlst", "parameter error!" });
  }
  
  public static gnu.lists.Pair buildWordInlst$V(Object word, Object[] argsArray) { Object endia = gnu.expr.Keyword.searchForKeyword(argsArray, 0, Lit3, Lit4);
    









    throw (endia == Lit8 ? gnu.lists.LList.list2(gnu.kawa.functions.BitwiseOp.and.apply2(gnu.kawa.functions.BitwiseOp.ashift.apply2(word, Lit10), Lit9), gnu.kawa.functions.BitwiseOp.and.apply2(word, Lit9)) : endia == Lit4 ? gnu.lists.LList.list2(gnu.kawa.functions.BitwiseOp.and.apply2(word, Lit9), gnu.kawa.functions.BitwiseOp.and.apply2(gnu.kawa.functions.BitwiseOp.ashift.apply2(word, Lit10), Lit9)) : gnu.expr.Special.reachedUnexpected);return kawa.lib.exceptions.error(new Object[] { "build-word-inlst", "parameter error!" });
  }
  
  public static gnu.mapping.Procedure makeCounter(Object start, Object step) { frame0 $heapFrame = new frame0();step = step;
    counter = gnu.kawa.functions.AddOp.apply2(-1, start, step);
    return lambda$Fn1;
  }
  

  public static gnu.mapping.Procedure makeContainer(Object func)
  {
    frame1 $heapFrame = new frame1();func = func;
    
    _container = Boolean.FALSE;
    return lambda$Fn2;
  }
  
  public static Object toList$V(Object A, Object[] argsArray)
  {
    gnu.lists.LList localLList1;
    gnu.lists.LList B = localLList1 = gnu.lists.LList.makeList(argsArray, 0);
    return kawa.standard.append.append$V(new Object[] { gnu.lists.LList.list1(A), B });
  }
  
  public static Object readU8s(Object n, Object port)
  {
    Object b = kawa.lib.ports.readU8(port);
    


    return gnu.kawa.functions.NumberCompare.$Gr(n, Lit1) ? kawa.lib.lists.cons(b, readU8s(gnu.kawa.functions.AddOp.apply2(-1, n, Lit2), port)) : gnu.expr.KawaConvert.isTrue(kawa.standard.Scheme.isEqual.apply2(b, gnu.lists.EofClass.eofValue)) ? gnu.lists.LList.Empty : gnu.lists.LList.Empty;
  }
  









  static void lambda3(Object obj)
  {
    object$To$String(obj);
  }
  



  public static Object subu8list(Object lst, Object start, Object end)
  {
    return slice(lst, start, gnu.kawa.functions.AddOp.apply2(-1, end, start));
  }
  


  public static Object groupList(Object lst, Object gl)
  {
    return gnu.kawa.functions.NumberCompare.$Gr(gl, Lit1) ? kawa.standard.append.append$V(new Object[] { gnu.lists.LList.list1(slice(lst, Lit1, gl)), gnu.kawa.functions.NumberCompare.$Gr(gnu.kawa.functions.AddOp.apply2(-1, Integer.valueOf(gnu.lists.Sequences.getSize(lst)), gl), Lit1) ? groupList(slice(lst, gl, Integer.valueOf(gnu.lists.Sequences.getSize(lst))), gl) : gnu.lists.LList.Empty }) : Boolean.FALSE;
  }
  




  public static Object assocEX(Object n, Object l)
  {
    Object r;
    


    if (kawa.lib.lists.isList(l)) {
      r = kawa.lib.lists.assoc(n, filter(kawa.lib.lists.list$Qu, l));
      if (!gnu.expr.KawaConvert.isTrue(r)) {} }
    try { tmpTernaryOp = kawa.lib.lists.cdr((gnu.lists.Pair)(localObject1 = gnu.mapping.Promise.force(r, gnu.lists.Pair.class))); break label52; tmpTernaryOp = Boolean.FALSE; label52: return Boolean.FALSE; } catch (ClassCastException localClassCastException) { Object localObject1; throw new gnu.mapping.WrongType(localClassCastException, "cdr", 1, localObject1);
    }
  }
  









































































  public static int float$To$Integer(Object f)
  {
    return ((Number)gnu.mapping.Promise.force(f)).intValue();
  }
  
















  public static Object getConfigurationDescriptor(Object usb_control_in)
  {
    Object configdescLen = buildWordFromlst$V(slice(kawa.standard.Scheme.applyToArgs.applyN(new Object[] { usb_control_in, Lit20, Lit21, Lit22, Lit1, Lit7 }), Lit16, Lit16), new Object[] { Lit3, Lit4 });
    return kawa.standard.Scheme.applyToArgs.applyN(new Object[] { usb_control_in, Lit20, Lit21, Lit22, Lit1, configdescLen });
  }
  








  public static Object getDeviceDescriptor(Object usb_control_in)
  {
    return kawa.standard.Scheme.applyToArgs.applyN(new Object[] { usb_control_in, Lit20, Lit21, Lit25, Lit1, Lit26 });
  }
  

  static Object lambda5(Object arg1, Object arg2)
  {
    Object localObject;
    
    if (gnu.expr.KawaConvert.isTrue(kawa.standard.Scheme.isEqual.apply2(arg1, Lit13)))
    {
      localObject = gnu.mapping.Promise.force(arg2, Number.class); } try { { "interface" }[1] = kawa.lib.numbers.number$To$String((Number)tmp56_53);_current_interface_ = kawa.lib.misc.string$To$Symbol(kawa.lib.strings.stringAppend({ "interface" }));
      tmpTernaryOp = _current_interface_;return gnu.expr.KawaConvert.isTrue(kawa.standard.Scheme.isEqual.apply2(arg1, Lit15)) ? _current_interface_ : gnu.mapping.Values.empty;
    }
    catch (ClassCastException localClassCastException)
    {
      throw new gnu.mapping.WrongType(
        localClassCastException, "number->string", 1, localObject);
    }
  }
  


  public static Object parseDescriptor(Object d) { return callWithInputU8vector(list$To$U8vector(d), lambda$Fn6); } static Object lambda6(Object p) { frame3 $heapFrame = new frame3();p = p;
    
























































































































































    gnu.mapping.Procedure counter = makeCounter();
    gnu.mapping.Procedure interface$Mncontainer = makeContainer(lambda$Fn7);
    



    c = makeCounter();
    gnu.mapping.Procedure IAD$Mncontainer = makeContainer(lambda$Fn8);
    




    interface$Mncontainer.apply2(Lit13, gnu.lists.LList.Empty);
    IAD$Mncontainer.apply2(Lit13, gnu.lists.LList.Empty);
    
    return $heapFrame.lambda9loop(IAD$Mncontainer, counter, interface$Mncontainer);
  }
  














































  public static Object getBSeq(Object op)
  {
    Object nextseq = gnu.kawa.functions.AddOp.apply2(1, _ccid_bSeq_, Lit2);
    _ccid_bSeq_ = gnu.kawa.functions.NumberCompare.$Gr$Eq(nextseq, Lit25) ? Lit1 : nextseq;
    


    return gnu.expr.KawaConvert.isTrue(kawa.standard.Scheme.isEqual.apply2(op, Lit100)) ? _ccid_bSeq_ : _ccid_bSeq_;
  }
  







































































































































































































































































































































































  public static Object PC_to_RDR_IccPowerOn(Object _bSlot, Object _bPowerSelect)
  {
    Object bSeq = getBSeq(Lit100);
    

    return kawa.standard.append.append$V(new Object[] { gnu.lists.LList.list1(Lit121), buildDwordInlst$V(Lit1, new Object[] { Lit3, Lit4 }), gnu.lists.LList.list3(_bSlot, bSeq, _bPowerSelect), buildWordInlst$V(Lit1, new Object[] { Lit3, Lit4 }) });
  }
  





  public static Object PC_to_RDR_XfrBlock(Object _bSlot, Object _bBWI, Object _wLevelParameter, Object _abData)
  {
    int i = gnu.lists.Sequences.getSize(_abData);
    
    Object bSeq = getBSeq(Lit100);
    
    int dwLength;
    
    return kawa.standard.append.append$V(new Object[] { gnu.lists.LList.list1(Lit122), buildDwordInlst$V(Integer.valueOf(dwLength), new Object[] { Lit3, Lit4 }), gnu.lists.LList.list3(_bSlot, bSeq, _bBWI), buildWordInlst$V(_wLevelParameter, new Object[] { Lit3, Lit4 }), _abData });
  }
  







  public static gnu.lists.Pair RDR_to_PC_DataBlock(Object data)
  {
    Object localObject1 = kawa.lib.lists.listRef(data, 0);
    Object localObject2 = buildDwordFromlst$V(subu8list(data, Lit2, Lit58), new Object[0]);
    Object localObject3 = kawa.lib.lists.listRef(data, 5);
    Object localObject4 = kawa.lib.lists.listRef(data, 6);
    Object localObject5 = kawa.lib.lists.listRef(data, 7);
    Object localObject6 = kawa.lib.lists.listRef(data, 8);
    Object localObject7 = kawa.lib.lists.listRef(data, 9);
    Object abData = subu8list(data, Lit114, Integer.valueOf(gnu.lists.Sequences.getSize(data)));
    Object bChainParameter; Object bError; Object bStatus; Object bSeq; Object bSlot; Object dwLength; Object bMessageType; if (!gnu.expr.KawaConvert.isTrue(kawa.standard.Scheme.isEqual.apply2(bSeq, getBSeq(Lit123))))
      throw gnu.expr.Special.reachedUnexpected;
    if ((!gnu.kawa.functions.NumberCompare.$Eq(bStatus, Lit1)) || (!gnu.kawa.functions.NumberCompare.$Eq(bError, Lit1)))
      pp.apply1(getBStatusBErrorErrorName(bStatus, bError));
    gnu.lists.Pair tmp161_158 = gnu.lists.LList.list1(gnu.lists.LList.list2(Lit124, bMessageType));gnu.lists.LList.chain1(gnu.lists.LList.chain4(tmp161_158, gnu.lists.LList.list2(Lit125, dwLength), gnu.lists.LList.list2(Lit126, bSlot), gnu.lists.LList.list2(Lit127, bStatus), gnu.lists.LList.list2(Lit128, bChainParameter)), gnu.lists.LList.list2(Lit129, abData));return tmp161_158;
  }
  







  public static Object PC_to_RDR_IccPowerOff(Object _bSlot)
  {
    Object bSeq = getBSeq(Lit100);
    
    return kawa.standard.append.append$V(new Object[] { gnu.lists.LList.list1(Lit130), buildDwordInlst$V(Lit1, new Object[] { Lit3, Lit4 }), gnu.lists.LList.list2(_bSlot, bSeq), Lit131 });
  }
  



  public static gnu.lists.Pair RDR_to_PC_SlotStatus(Object data)
  {
    Object localObject1 = kawa.lib.lists.listRef(data, 0);
    buildDwordFromlst$V(subu8list(data, Lit2, Lit58), new Object[0]);
    Object localObject2 = kawa.lib.lists.listRef(data, 5);
    Object localObject3 = kawa.lib.lists.listRef(data, 6);
    Object localObject4 = kawa.lib.lists.listRef(data, 7);
    Object localObject5 = kawa.lib.lists.listRef(data, 8);
    Object bClockStatus = kawa.lib.lists.listRef(data, 9);
    Object bError; Object bStatus; Object bSeq; Object bSlot; Object bMessageType; if (!gnu.expr.KawaConvert.isTrue(kawa.standard.Scheme.isEqual.apply2(bSeq, getBSeq(Lit123))))
      throw gnu.expr.Special.reachedUnexpected;
    if ((!gnu.kawa.functions.NumberCompare.$Eq(bStatus, Lit1)) || (!gnu.kawa.functions.NumberCompare.$Eq(bError, Lit1)))
      pp.apply1(getBStatusBErrorErrorName(bStatus, bError));
    pp.apply1("bClockStatus: Clock running");
    if (gnu.expr.KawaConvert.isTrue(kawa.standard.Scheme.isEqual.apply2(bClockStatus, Lit2))) { pp.apply1("bClockStatus: Clock stopped in state L");
    } else if (gnu.expr.KawaConvert.isTrue(kawa.standard.Scheme.isEqual.apply2(bClockStatus, Lit16))) { pp.apply1("bClockStatus: Clock stopped in state H");
    } else if (gnu.expr.KawaConvert.isTrue(kawa.standard.Scheme.isEqual.apply2(bClockStatus, Lit99))) pp.apply1("bClockStatus: Clock stopped in an unknown state"); else
      (gnu.expr.KawaConvert.isTrue(kawa.standard.Scheme.isEqual.apply2(bClockStatus, Lit1)) ? kawa.lib.exceptions.error(new Object[] { "bSeq not equal" }) : pp.apply1("bClockStatus: All other values are RFU"));
    return gnu.lists.LList.list4(gnu.lists.LList.list2(Lit124, bMessageType), gnu.lists.LList.list2(Lit126, bSlot), gnu.lists.LList.list2(Lit127, bStatus), gnu.lists.LList.list2(Lit132, bClockStatus));
  }
  



  public static Object PC_to_RDR_SetParameters(Object _bSlot, Object _bProtocolNum, Object _pps)
  {
    int i = gnu.lists.Sequences.getSize(_pps);
    
    Object bSeq = getBSeq(Lit100);
    
    int dwLength;
    
    return kawa.standard.append.append$V(new Object[] { gnu.lists.LList.list1(Lit133), buildDwordInlst$V(Integer.valueOf(dwLength), new Object[] { Lit3, Lit4 }), gnu.lists.LList.list3(_bSlot, bSeq, _bProtocolNum), Lit134, _pps });
  }
  




  public static gnu.lists.Pair RDR_to_PC_Parameters(Object data)
  {
    Object localObject1 = kawa.lib.lists.listRef(data, 0);
    buildDwordFromlst$V(subu8list(data, Lit2, Lit58), new Object[0]);
    Object localObject2 = kawa.lib.lists.listRef(data, 5);
    Object localObject3 = kawa.lib.lists.listRef(data, 6);
    Object localObject4 = kawa.lib.lists.listRef(data, 7);
    Object localObject5 = kawa.lib.lists.listRef(data, 8);
    Object localObject6 = kawa.lib.lists.listRef(data, 9);
    Object abProtocolDataStructure = subu8list(data, Lit114, Integer.valueOf(gnu.lists.Sequences.getSize(data)));
    Object bProtocolNum; Object bError; Object bStatus; Object bSeq; Object bSlot; Object bMessageType; if (!gnu.expr.KawaConvert.isTrue(kawa.standard.Scheme.isEqual.apply2(bSeq, getBSeq(Lit123))))
      throw gnu.expr.Special.reachedUnexpected;
    if ((!gnu.kawa.functions.NumberCompare.$Eq(bStatus, Lit1)) || (!gnu.kawa.functions.NumberCompare.$Eq(bError, Lit1)))
      pp.apply1(getBStatusBErrorErrorName(bStatus, bError));
    pp.apply1("Structure for protocol T=0");
    if (gnu.expr.KawaConvert.isTrue(kawa.standard.Scheme.isEqual.apply2(bProtocolNum, Lit2))) { pp.apply1("Structure for protocol T=1");
    } else if (gnu.expr.KawaConvert.isTrue(kawa.standard.Scheme.isEqual.apply2(bProtocolNum, Lit20))) { pp.apply1("Structure for 2-wire protocol");
    } else if (gnu.expr.KawaConvert.isTrue(kawa.standard.Scheme.isEqual.apply2(bProtocolNum, Lit119))) { pp.apply1("Structure for 3-wire protocol");
    } else if (gnu.expr.KawaConvert.isTrue(kawa.standard.Scheme.isEqual.apply2(bProtocolNum, Lit135))) pp.apply1("Structure for I2C protocol"); else
      (gnu.expr.KawaConvert.isTrue(kawa.standard.Scheme.isEqual.apply2(bProtocolNum, Lit1)) ? kawa.lib.exceptions.error(new Object[] { "bSeq not equal" }) : pp.apply1("bClockStatus: All other values are RFU"));
    return gnu.lists.LList.list4(gnu.lists.LList.list2(Lit124, bMessageType), gnu.lists.LList.list2(Lit126, bSlot), gnu.lists.LList.list2(Lit136, bProtocolNum), gnu.lists.LList.list2(Lit137, abProtocolDataStructure));
  }
  





  public static Object PC_to_RDR_Escape(Object _bSlot, Object _abData)
  {
    int i = gnu.lists.Sequences.getSize(_abData);
    
    Object bSeq = getBSeq(Lit100);
    
    int dwLength;
    return kawa.standard.append.append$V(new Object[] { gnu.lists.LList.list1(Lit138), buildDwordInlst$V(Integer.valueOf(dwLength), new Object[] { Lit3, Lit4 }), gnu.lists.LList.list2(_bSlot, bSeq), Lit131, _abData });
  }
  


  public static gnu.lists.Pair RDR_to_PC_Escape(Object data)
  {
    Object localObject1 = kawa.lib.lists.listRef(data, 0);
    Object localObject2 = buildDwordFromlst$V(subu8list(data, Lit2, Lit58), new Object[0]);
    Object localObject3 = kawa.lib.lists.listRef(data, 5);
    Object localObject4 = kawa.lib.lists.listRef(data, 6);
    Object localObject5 = kawa.lib.lists.listRef(data, 7);
    Object localObject6 = kawa.lib.lists.listRef(data, 8);
    Object localObject7 = kawa.lib.lists.listRef(data, 9);
    Object abData = subu8list(data, Lit114, Integer.valueOf(gnu.lists.Sequences.getSize(data)));
    Object bRFU; Object bError; Object bStatus; Object bSeq; Object bSlot; Object dwLength; Object bMessageType; if (!gnu.expr.KawaConvert.isTrue(kawa.standard.Scheme.isEqual.apply2(bSeq, getBSeq(Lit123))))
      throw gnu.expr.Special.reachedUnexpected;
    if ((!gnu.kawa.functions.NumberCompare.$Eq(bStatus, Lit1)) || (!gnu.kawa.functions.NumberCompare.$Eq(bError, Lit1)))
      pp.apply1(getBStatusBErrorErrorName(bStatus, bError));
    gnu.lists.Pair tmp161_158 = gnu.lists.LList.list1(gnu.lists.LList.list2(Lit124, bMessageType));gnu.lists.LList.chain1(gnu.lists.LList.chain4(tmp161_158, gnu.lists.LList.list2(Lit125, dwLength), gnu.lists.LList.list2(Lit126, bSlot), gnu.lists.LList.list2(Lit127, bStatus), gnu.lists.LList.list2(Lit139, bRFU)), gnu.lists.LList.list2(Lit129, abData));return tmp161_158;
  }
  








  public static Object PC_to_RDR_GetSlotStatus(Object _bSlot)
  {
    Object bSeq = getBSeq(Lit100);
    
    return kawa.standard.append.append$V(new Object[] { gnu.lists.LList.list1(Lit140), buildDwordInlst$V(Lit1, new Object[] { Lit3, Lit4 }), gnu.lists.LList.list2(_bSlot, bSeq), Lit131 }); }
  
  public static Object parseATR(Object atr) { frame10 $heapFrame = new frame10();atr = atr;
    

    return callWithInputU8vector(list$To$U8vector(atr), lambda$Fn15);
  }
  
































































  public static gnu.lists.Pair parseAtrTA1(Object ta1)
  {
    Object x = kawa.standard.Scheme.isEqual.apply2(ta1, Lit149);
    

    Object localObject1 = gnu.kawa.functions.BitwiseOp.and.apply2(gnu.kawa.functions.BitwiseOp.ashift.apply2(ta1, Lit151), Lit118);
    Object b4_1 = gnu.kawa.functions.BitwiseOp.and.apply2(ta1, Lit118);
    
    Object b8_5;
    
    return gnu.expr.KawaConvert.isTrue(x) ? gnu.expr.KawaConvert.isTrue(x) : gnu.expr.KawaConvert.isTrue(kawa.standard.Scheme.isEqual.apply2(ta1, Boolean.FALSE)) ? Lit150 : gnu.lists.LList.list3(gnu.lists.LList.list2(Lit152, kawa.lib.lists.cadr(kawa.lib.lists.assoc(b8_5, Lit153))), gnu.lists.LList.list2(Lit154, kawa.lib.lists.cadr(kawa.lib.lists.assoc(b4_1, Lit155))), gnu.lists.LList.list2(Lit156, kawa.lib.lists.cadr(kawa.lib.lists.assoc(b8_5, Lit157))));
  }
  


  static Object lambda29(Object x)
  {
    return x;
  }
  












  static Object lambda30(Object x)
  {
    return x;
  }
  












































































  static Object lambda31(Object x)
  {
    return x;
  }
  
  public static Object generatePPSExchange(Object atr)
  {
    Object _pps1 = getPps1(atr);
    Object pps1 = gnu.expr.KawaConvert.isTrue(_pps1) ? 
      _pps1 : gnu.expr.KawaConvert.isTrue(assocEX("USE-DEFAULT-PPS-EXCHANGE", assocEX(Lit170, atr))) ? Lit171 : _pps1;
    try
    {
      Object localObject1;
      Object pps2 = kawa.lib.lists.car((gnu.lists.Pair)(localObject1 = gnu.mapping.Promise.force(assocEX(Lit164, getAtrTATBForT15(atr)), gnu.lists.Pair.class)));
      








      pps0 = gnu.kawa.functions.BitwiseOp.ior.apply2(gnu.math.BitOps.ior(gnu.math.BitOps.ior(Lit1, gnu.expr.KawaConvert.isTrue(pps2) ? Lit172 : Lit1), gnu.expr.KawaConvert.isTrue(pps1) ? Lit6 : Lit1), gnu.expr.KawaConvert.isTrue(kawa.standard.Scheme.isEqual.apply2(getAtrSupportProtocol(atr), Lit159)) ? Lit2 : gnu.expr.KawaConvert.isTrue(kawa.standard.Scheme.isEqual.apply2(getAtrSupportProtocol(atr), Lit160)) ? Lit2 : gnu.expr.KawaConvert.isTrue(kawa.standard.Scheme.isEqual.apply2(getAtrSupportProtocol(atr), Lit147)) ? Lit1 : gnu.mapping.Values.empty); gnu.lists.Pair 
      


        tmp202_199 = gnu.lists.LList.list1(Lit9);gnu.lists.LList.chain4(tmp202_199, pps0, pps1, pps2, Boolean.FALSE);Object P = filter(lambda$Fn19, tmp202_199);
      Object pck = listXor(P);
      return kawa.standard.append.append$V(new Object[] { P, gnu.lists.LList.list1(pck) });
    }
    catch (ClassCastException localClassCastException)
    {
      Object pps0;
      throw new gnu.mapping.WrongType(
      














        localClassCastException, "car", 1, pps0);
    }
  }
  




















































































  public static gnu.lists.Pair generatePPSParametersT1(Object atr)
  {
    Object pps = generatePPSExchange(atr);
    Object bmFindexDindex = gnu.expr.KawaConvert.isTrue(kawa.standard.Scheme.isEqual.apply2(gnu.kawa.functions.BitwiseOp.and.apply2(kawa.lib.lists.listRef(pps, 1), Lit6), Lit6)) ? 
      kawa.lib.lists.listRef(pps, 2) : Lit171;
    

    Object Tc = getAtrTCForT1(atr);
    





    gnu.math.IntNum bmTCCKST1 = gnu.math.BitOps.ior(gnu.math.BitOps.ior(Lit6, gnu.expr.KawaConvert.isTrue(Tc) ? Lit1 : gnu.expr.KawaConvert.isTrue(kawa.standard.Scheme.isEqual.apply2(gnu.kawa.functions.BitwiseOp.and.apply2(Tc, Lit2), Lit2)) ? Lit16 : Lit1), gnu.expr.KawaConvert.isTrue(kawa.standard.Scheme.isEqual.apply2(kawa.lib.lists.cadr(kawa.lib.lists.assoc(Lit146, atr)), Lit173)) ? Lit1 : Lit2);
    

    if (gnu.expr.KawaConvert.isTrue(assocEX(Lit143, assocEX(Lit165, assocEX(Lit158, atr))))) {}
    try { Object localObject1; tmpTernaryOp = kawa.lib.lists.car((gnu.lists.Pair)(localObject1 = gnu.mapping.Promise.force(assocEX(Lit143, assocEX(Lit165, assocEX(Lit158, atr))), gnu.lists.Pair.class)));Object bGuardTimeT1 = Lit1;
      
      bmWaitingIntegersT1 = gnu.expr.KawaConvert.isTrue(getAtrTBForT1(atr)) ? 
        getAtrTBForT1(atr) : Lit174;
      

      Object bIFSC = getAtrIFSC(atr); gnu.lists.Pair 
      
        tmp243_240 = gnu.lists.LList.list1(bmFindexDindex);gnu.lists.LList.chain1(gnu.lists.LList.chain1(gnu.lists.LList.chain4(tmp243_240, bmTCCKST1, bGuardTimeT1, bmWaitingIntegersT1, Lit1), bIFSC), Lit1);return tmp243_240;
    }
    catch (ClassCastException localClassCastException)
    {
      Object bmWaitingIntegersT1;
      throw new gnu.mapping.WrongType(
      






        localClassCastException, "car", 1, bmWaitingIntegersT1);
    }
  }
  
































































































  public static gnu.math.IntNum getCardTimeout(Object atr)
  {
    return gnu.expr.KawaConvert.isTrue(kawa.standard.Scheme.isEqual.apply2(gnu.expr.KawaConvert.isTrue(kawa.standard.Scheme.isEqual.apply2(getAtrSupportProtocol(atr), Lit159)) ? Lit2 : gnu.expr.KawaConvert.isTrue(kawa.standard.Scheme.isEqual.apply2(getAtrSupportProtocol(atr), Lit160)) ? Lit2 : gnu.expr.KawaConvert.isTrue(kawa.standard.Scheme.isEqual.apply2(getAtrSupportProtocol(atr), Lit147)) ? Lit1 : gnu.mapping.Values.empty, Lit1)) ? getCardTimeoutT0(atr) : getCardTimeoutT1(atr);
  }
  






























































































  public static Object generateSBlockTPDUT1(Object cmd, Object data)
  {
    throw (gnu.expr.KawaConvert.isTrue(kawa.standard.Scheme.isEqual.apply2(cmd, Lit198)) ? Lit214 : gnu.expr.KawaConvert.isTrue(kawa.standard.Scheme.isEqual.apply2(cmd, Lit212)) ? Lit213 : gnu.expr.KawaConvert.isTrue(kawa.standard.Scheme.isEqual.apply2(cmd, Lit196)) ? Lit211 : gnu.expr.KawaConvert.isTrue(kawa.standard.Scheme.isEqual.apply2(cmd, Lit209)) ? Lit210 : gnu.expr.KawaConvert.isTrue(kawa.standard.Scheme.isEqual.apply2(cmd, Lit194)) ? Lit208 : gnu.expr.KawaConvert.isTrue(kawa.standard.Scheme.isEqual.apply2(cmd, Lit193)) ? Lit207 : gnu.expr.KawaConvert.isTrue(kawa.standard.Scheme.isEqual.apply2(cmd, Lit192)) ? Lit111 : gnu.expr.KawaConvert.isTrue(kawa.standard.Scheme.isEqual.apply2(cmd, Lit191)) ? Lit101 : gnu.expr.Special.reachedUnexpected);gnu.bytecode.Type.NeverReturns localNeverReturns = kawa.lib.exceptions.error(new Object[] { "cmd not right!!!" });
    int LEN = gnu.lists.Sequences.getSize(data);
    gnu.math.IntNum PCB; Object _t = kawa.standard.append.append$V(new Object[] { gnu.lists.LList.list3(Lit1, PCB, Integer.valueOf(LEN)), data });
    return kawa.standard.append.append$V(new Object[] { _t, gnu.lists.LList.list1(listXor(_t)) });
  }
  




  public static Object generateIBlockTPDUT1(Object N_S, Object M$Mnbit, Object data)
  {
    gnu.lists.Pair pf = gnu.lists.LList.list3(Lit1, gnu.kawa.functions.BitwiseOp.xor.apply2(gnu.kawa.functions.BitwiseOp.xor.apply2(Lit1, gnu.kawa.functions.BitwiseOp.ashift.apply2(N_S, Lit21)), gnu.kawa.functions.BitwiseOp.ashift.apply2(M$Mnbit, Lit58)), Integer.valueOf(gnu.lists.Sequences.getSize(data)));
    Object pf_if = kawa.standard.append.append$V(new Object[] { pf, data });
    return kawa.standard.append.append$V(new Object[] { pf_if, gnu.lists.LList.list1(listXor(pf_if)) });
  }
  


  public static Object generateRBlockTPDUT1(Object N_R, Object op)
  {
    gnu.lists.Pair pf = gnu.lists.LList.list3(Lit1, gnu.kawa.functions.BitwiseOp.ior.apply2(gnu.kawa.functions.BitwiseOp.ior.apply2(Lit20, gnu.kawa.functions.BitwiseOp.ashift.apply2(N_R, Lit18)), op), Lit1);
    
    return kawa.standard.append.append$V(new Object[] { pf, gnu.lists.LList.list1(listXor(pf)) });
  }
  






















































































  public static Object doPPSExchange(Object usb_send_recv, Object slot, Object atr)
  {
    Object pps = generatePPSExchange(atr);
    gnu.lists.Pair ret = RDR_to_PC_DataBlock(kawa.standard.Scheme.applyToArgs.apply2(usb_send_recv, PC_to_RDR_XfrBlock(slot, Lit1, Lit1, pps)));
    if (!gnu.expr.KawaConvert.isTrue(kawa.standard.Scheme.isEqual.apply2(kawa.lib.lists.cadr(kawa.lib.lists.assoc(Lit126, ret)), slot)))
      pp.apply1("slot not equal");
    if (!gnu.expr.KawaConvert.isTrue(kawa.standard.Scheme.isEqual.apply2(kawa.lib.lists.cadr(kawa.lib.lists.assoc(Lit129, ret)), pps)))
    {
      pp.apply1("pps not equal should try default");
      throw gnu.expr.Special.reachedUnexpected; }
    return kawa.lib.lists.cadr(kawa.lib.lists.assoc(Lit129, ret));
  }
  


  public static Object doPPSSetParameters(Object usb_send_recv, Object slot, Object atr)
  {
    throw (gnu.expr.KawaConvert.isTrue(kawa.standard.Scheme.isEqual.apply2(getAtrSupportProtocol(atr), Lit159)) ? Lit2 : gnu.expr.KawaConvert.isTrue(kawa.standard.Scheme.isEqual.apply2(getAtrSupportProtocol(atr), Lit160)) ? Lit2 : gnu.expr.KawaConvert.isTrue(kawa.standard.Scheme.isEqual.apply2(getAtrSupportProtocol(atr), Lit147)) ? Lit1 : gnu.expr.Special.reachedUnexpected);gnu.math.IntNum protocol = kawa.lib.exceptions.error(new Object[] { "do-PPS-set-parameters error 1 should not happend" });
    

    throw (gnu.expr.KawaConvert.isTrue(kawa.standard.Scheme.isEqual.apply2(protocol, Lit2)) ? generatePPSParametersT1(atr) : gnu.expr.KawaConvert.isTrue(kawa.standard.Scheme.isEqual.apply2(protocol, Lit1)) ? generatePPSParametersT0(atr) : gnu.expr.Special.reachedUnexpected);gnu.lists.Pair pps$Mnparameters = kawa.lib.exceptions.error(new Object[] { "do-PPS-set-parameters error 2 should not happend" });
    


    gnu.lists.Pair ret = RDR_to_PC_Parameters(kawa.standard.Scheme.applyToArgs.apply2(usb_send_recv, PC_to_RDR_SetParameters(slot, protocol, pps$Mnparameters)));
    if (!gnu.expr.KawaConvert.isTrue(kawa.standard.Scheme.isEqual.apply2(kawa.lib.lists.cadr(kawa.lib.lists.assoc(Lit126, ret)), slot))) {
      pp.apply1("slot not equal");
    }
    
    return !gnu.expr.KawaConvert.isTrue(kawa.standard.Scheme.isEqual.apply2(kawa.lib.lists.cadr(kawa.lib.lists.assoc(Lit137, ret)), pps$Mnparameters)) ? pp.apply1("abProtocolDataStructure not equal") : kawa.lib.lists.cadr(kawa.lib.lists.assoc(Lit137, ret));
  }
  

























































  public static Object doXfrBlockTPDUT0Protocol(Object usb_send, Object usb_recv, Object slot, Object data)
  {
    kawa.standard.Scheme.applyToArgs.apply2(usb_send, PC_to_RDR_XfrBlock(slot, Lit1, Lit1, data));
    
    gnu.lists.Pair ret = RDR_to_PC_DataBlock(kawa.standard.Scheme.applyToArgs.apply1(usb_recv));
    if (!gnu.expr.KawaConvert.isTrue(kawa.standard.Scheme.isEqual.apply2(kawa.lib.lists.assoc(Lit126, ret), gnu.lists.LList.list2(Lit126, slot)))) {
      throw gnu.expr.Special.reachedUnexpected;
    }
    if (!gnu.expr.KawaConvert.isTrue(kawa.standard.Scheme.isEqual.apply2(kawa.lib.lists.assoc(Lit125, ret), gnu.lists.LList.list2(Lit125, Integer.valueOf(gnu.lists.Sequences.getSize(kawa.lib.lists.cadr(kawa.lib.lists.assoc(Lit129, ret)))))))) {
      throw gnu.expr.Special.reachedUnexpected;
    }
    
    return kawa.lib.lists.cadr(kawa.lib.lists.assoc(Lit129, ret));
  }
  
































































  static Object lambda36(Object op, Object arg1)
  {
    ns = Lit1;
    Object ns_tmp = ns;
    ns = gnu.kawa.functions.DivideOp.remainder.apply2(gnu.kawa.functions.AddOp.apply2(1, ns, Lit2), Lit16);
    
    ns = arg1;return gnu.expr.KawaConvert.isTrue(kawa.standard.Scheme.isEqual.apply2(op, Lit13)) ? gnu.mapping.Values.empty : gnu.expr.KawaConvert.isTrue(kawa.standard.Scheme.isEqual.apply2(op, Lit15)) ? ns_tmp : gnu.expr.KawaConvert.isTrue(kawa.standard.Scheme.isEqual.apply2(op, Lit244)) ? gnu.mapping.Values.empty : gnu.mapping.Values.empty;
  }
  

  static Object lambda37(Object op, Object arg1)
  {
    nr = Lit1;
    Object nr_tmp = nr;
    nr = gnu.kawa.functions.DivideOp.remainder.apply2(gnu.kawa.functions.AddOp.apply2(1, nr, Lit2), Lit16);
    
    nr = arg1;return gnu.expr.KawaConvert.isTrue(kawa.standard.Scheme.isEqual.apply2(op, Lit13)) ? gnu.mapping.Values.empty : gnu.expr.KawaConvert.isTrue(kawa.standard.Scheme.isEqual.apply2(op, Lit15)) ? nr_tmp : gnu.expr.KawaConvert.isTrue(kawa.standard.Scheme.isEqual.apply2(op, Lit244)) ? gnu.mapping.Values.empty : gnu.mapping.Values.empty;
  }
  
  public static Object IFSRequestTPDUT1(Object usb_send, Object usb_recv, Object slot, Object atr) {
    T1$MnTPDU$MnIblock$MnN_S.apply1(Lit244);
    T1$MnTPDU$MnRblock$MnN_R.apply1(Lit244);
    kawa.standard.Scheme.applyToArgs
    

      .apply2(usb_send, PC_to_RDR_XfrBlock(slot, Lit1, Lit1, generateSBlockTPDUT1(Lit193, gnu.lists.LList.list1(getAtrIFSC(atr)))));
    gnu.lists.Pair ret = RDR_to_PC_DataBlock(kawa.standard.Scheme.applyToArgs.apply1(usb_recv));
    Object abData = kawa.lib.lists.cadr(kawa.lib.lists.assoc(Lit129, ret));
    

    Object sd_ = generateRBlockTPDUT1(Lit1, Lit16);
    kawa.standard.Scheme.applyToArgs.apply2(usb_send, PC_to_RDR_XfrBlock(slot, Lit1, Lit1, sd_));
    gnu.lists.Pair ret_ = RDR_to_PC_DataBlock(kawa.standard.Scheme.applyToArgs.apply1(usb_recv));
    Object abData_ = kawa.lib.lists.cadr(kawa.lib.lists.assoc(Lit129, ret_));
    

    return kawa.lib.lists.isNull(abData_) ? pp.apply1("error!!!!!! abData null!!!") : !kawa.lib.lists.isNull(abData) ? parseT1Block(abData, CCID$MnDEBUG.apply0()) : parseT1Block(abData_, CCID$MnDEBUG.apply0());
  }
  

  public static Object doXfrBlockTPDUT1Protocol(Object usb_send, Object usb_recv, Object slot, Object data, Object atr)
  {
    frame14 $heapFrame = new frame14();usb_send = usb_send;usb_recv = usb_recv;slot = slot;
    for (;;) { Object sds = groupList(data, getAtrIFSC(atr));
      Object ret; if (!kawa.lib.lists.isNull(sds))
        ret = Boolean.FALSE;
      Object localObject2;
      for (;;) {
        Object retBlock;
        try {
          if (kawa.lib.lists.isNull(kawa.lib.lists.cdr((gnu.lists.Pair)(localObject1 = gnu.mapping.Promise.force(sds, gnu.lists.Pair.class))))) tmpTernaryOp = Lit1; } catch (ClassCastException localClassCastException1) { Object localObject1; throw new gnu.mapping.WrongType(
          





































            localClassCastException1, "cdr", 1, retBlock);
        }
        try
        {
          kawa.standard.Scheme.applyToArgs.apply2(usb_send, PC_to_RDR_XfrBlock(slot, Lit1, Lit1, generateIBlockTPDUT1(T1$MnTPDU$MnIblock$MnN_S.apply1(Lit15), Lit2, kawa.lib.lists.car((gnu.lists.Pair)(localObject1 = gnu.mapping.Promise.force(sds, gnu.lists.Pair.class))))));
          ret = RDR_to_PC_DataBlock(kawa.standard.Scheme.applyToArgs.apply1(usb_recv));
          if (kawa.lib.lists.isNull(kawa.lib.lists.cadr(kawa.lib.lists.assoc(Lit129, ret))))
            throw gnu.expr.Special.reachedUnexpected;
          retBlock = parseT1Block(kawa.lib.lists.cadr(kawa.lib.lists.assoc(Lit129, ret)), CCID$MnDEBUG.apply0());
        }
        catch (ClassCastException localClassCastException2)
        {
          throw new gnu.mapping.WrongType(localClassCastException2, "car", 1, retBlock);
        }
        
        try
        {
          if (kawa.lib.lists.isNull(kawa.lib.lists.cdr((gnu.lists.Pair)(localObject2 = gnu.mapping.Promise.force(sds, gnu.lists.Pair.class))))) {
            tmpTernaryOp = $heapFrame.lambda38loop2(retBlock);
          }
        }
        catch (ClassCastException localClassCastException3)
        {
          throw new gnu.mapping.WrongType(localClassCastException3, "cdr", 1, localObject2);
        }
        
























        try
        {
          if (!gnu.expr.KawaConvert.isTrue(kawa.standard.Scheme.isEqual.apply2(Lit201, kawa.lib.lists.car((gnu.lists.Pair)(localObject2 = gnu.mapping.Promise.force(retBlock, gnu.lists.Pair.class)))))) {
            throw gnu.expr.Special.reachedUnexpected;
          }
        }
        catch (ClassCastException localClassCastException4)
        {
          throw new gnu.mapping.WrongType(localClassCastException4, "car", 1, localObject2);
        }
        try { if (!gnu.expr.KawaConvert.isTrue(kawa.standard.Scheme.isEqual.apply2(Lit245, kawa.lib.lists.assoc(Lit203, kawa.lib.lists.cdr((gnu.lists.Pair)(localObject2 = gnu.mapping.Promise.force(retBlock, gnu.lists.Pair.class))))))) {
            throw gnu.expr.Special.reachedUnexpected;
          }
        }
        catch (ClassCastException localClassCastException5)
        {
          throw new gnu.mapping.WrongType(localClassCastException5, "cdr", 1, localObject2);
        } }
      try { tmpTernaryOp = kawa.lib.lists.cdr((gnu.lists.Pair)(localObject2 = gnu.mapping.Promise.force(sds, gnu.lists.Pair.class))); } catch (ClassCastException localClassCastException6) { throw new gnu.mapping.WrongType(localClassCastException6, "cdr", 1, localObject2); } } return gnu.mapping.Values.empty;
  }
  




















  static Object lambda39(Object arg1)
  {
    _debug_ = true;
    _debug_ = false;return gnu.expr.KawaConvert.isTrue(kawa.standard.Scheme.isEqual.apply2(arg1, Lit249)) ? Boolean.FALSE : _debug_ ? Boolean.TRUE : gnu.expr.KawaConvert.isTrue(kawa.standard.Scheme.isEqual.apply2(arg1, Lit248)) ? Boolean.FALSE : _debug_ ? Boolean.TRUE : gnu.expr.KawaConvert.isTrue(kawa.standard.Scheme.isEqual.apply2(arg1, Lit15)) ? Boolean.FALSE : _debug_ ? Boolean.TRUE : gnu.mapping.Values.empty;
  }
  



  public static gnu.mapping.Procedure doInitDescriptorInf(Object usb_control_in)
  {
    descriptor$Mninfo = kawa.standard.append.append$V(new Object[] { parseDescriptor(getDeviceDescriptor(usb_control_in)), parseDescriptor(getConfigurationDescriptor(usb_control_in)) });
    
    return makeGET_DEVICE_INFFunc(usb_control_in, descriptor$Mninfo);
  }
  
  public static void doPowerOff(Object usb_send_recv, Object slot)
  {
    gnu.lists.Pair ret = RDR_to_PC_SlotStatus(kawa.standard.Scheme.applyToArgs.apply2(usb_send_recv, PC_to_RDR_IccPowerOff(slot)));
    if (!gnu.expr.KawaConvert.isTrue(kawa.standard.Scheme.isEqual.apply2(kawa.lib.lists.assoc(Lit126, ret), gnu.lists.LList.list2(Lit126, slot)))) {
      throw gnu.expr.Special.reachedUnexpected;
    }
  }
  
  public static gnu.lists.Pair doPowerOn(Object usb_send, Object usb_recv, Object index, Object slot)
  {
    frame15 $heapFrame = new frame15();usb_send = usb_send;usb_recv = usb_recv;index = index;
    










    current_dev_interface.apply2(Lit13, index);
    

    gnu.mapping.Procedure usb_send_recv = usb_send_recv$Fn24;
    Object atr_data = frame15.lambda41doPowerOnInside(usb_send_recv$Fn24, Lit1);
    atr = parseATR(atr_data);_isFirstTime_ = true;
    

    pp.apply1(kawa.lib.strings.stringAppend(new Object[] { "ATR: ", u8list$To$String(atr_data, " ") }));
    USB_TIMEOUT = getCardTimeout(atr);
    try
    {
      doPPS(usb_send_recv$Fn24, Lit1, atr);
    } catch (Exception localException1) {
      Exception e;
      pp.apply1("try default pps");
      pp.apply1("power off");
      gnu.lists.Pair ret = RDR_to_PC_SlotStatus($heapFrame.lambda40usb_send_recv(PC_to_RDR_IccPowerOff(Lit1)));
      if (!gnu.expr.KawaConvert.isTrue(kawa.standard.Scheme.isEqual.apply2(kawa.lib.lists.assoc(Lit126, ret), gnu.lists.LList.list2(Lit126, Lit1))))
        throw gnu.expr.Special.reachedUnexpected;
      pp.apply1("power on");
      atr_data = frame15.lambda41doPowerOnInside(usb_send_recv$Fn24, Lit1);
      atr = parseATR(atr_data);
      

      doPPS(usb_send_recv$Fn24, Lit1, kawa.standard.append.append$V(new Object[] { atr, Lit250 }));
    }
    






    throw (gnu.expr.KawaConvert.isTrue(kawa.standard.Scheme.isEqual.apply2(getAtrSupportProtocol(atr), Lit159)) ? Lit2 : gnu.expr.KawaConvert.isTrue(kawa.standard.Scheme.isEqual.apply2(getAtrSupportProtocol(atr), Lit160)) ? Lit2 : gnu.expr.KawaConvert.isTrue(kawa.standard.Scheme.isEqual.apply2(getAtrSupportProtocol(atr), Lit147)) ? Lit1 : gnu.expr.Special.reachedUnexpected);localException1 = kawa.lib.exceptions.error(new Object[] { "do-PowerOn error 1 should not happend" });
    gnu.mapping.SimpleSymbol protocol_r = getCcidExchangeLevel(descriptor$Mninfo);
    








    gnu.math.IntNum protocol_c;
    







    throw ((gnu.expr.KawaConvert.isTrue(kawa.standard.Scheme.isEqual.apply2(protocol_r, Lit233))) && (gnu.expr.KawaConvert.isTrue(kawa.standard.Scheme.isEqual.apply2(protocol_c, Lit2))) ? lambda$Fn28 : (gnu.expr.KawaConvert.isTrue(kawa.standard.Scheme.isEqual.apply2(protocol_r, Lit233))) && (gnu.expr.KawaConvert.isTrue(kawa.standard.Scheme.isEqual.apply2(protocol_c, Lit1))) ? lambda$Fn27 : gnu.expr.KawaConvert.isTrue(kawa.standard.Scheme.isEqual.apply2(protocol_r, Lit235)) ? lambda$Fn26 : gnu.expr.KawaConvert.isTrue(kawa.standard.Scheme.isEqual.apply2(protocol_r, Lit237)) ? lambda$Fn25 : gnu.expr.Special.reachedUnexpected);Object xfrBlock = kawa.lib.exceptions.error(new Object[] { "do-PowerOn error 2 should not happend" });
    
    return gnu.lists.LList.list2(gnu.lists.LList.list2(Lit251, atr_data), gnu.lists.LList.list2(Lit252, xfrBlock));
  }
  










  public static Object doEscape(Object usb_send_recv, Object data, Object slot)
  {
    gnu.lists.Pair ret = RDR_to_PC_Escape(kawa.standard.Scheme.applyToArgs.apply2(usb_send_recv, PC_to_RDR_Escape(slot, data)));
    if (!gnu.expr.KawaConvert.isTrue(kawa.standard.Scheme.isEqual.apply2(kawa.lib.lists.assoc(Lit126, ret), gnu.lists.LList.list2(Lit126, slot))))
      throw gnu.expr.Special.reachedUnexpected;
    return kawa.lib.lists.cadr(kawa.lib.lists.assoc(Lit129, ret));
  }
  
  public static Object doSlotStatus(Object usb_send_recv, Object slot)
  {
    gnu.lists.Pair ret = RDR_to_PC_SlotStatus(kawa.standard.Scheme.applyToArgs.apply2(usb_send_recv, PC_to_RDR_GetSlotStatus(slot)));
    if (!gnu.expr.KawaConvert.isTrue(kawa.standard.Scheme.isEqual.apply2(kawa.lib.lists.assoc(Lit126, ret), gnu.lists.LList.list2(Lit126, slot))))
      throw gnu.expr.Special.reachedUnexpected;
    return gnu.kawa.functions.BitwiseOp.and.apply2(kawa.lib.lists.cadr(kawa.lib.lists.assoc(Lit127, ret)), Lit99);
  }
  


  static
  {
    Lit277 = gnu.lists.PairWithPosition.make(CCIDScheme.Lit105 = gnu.math.IntNum.valueOf(7), Lit268, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 274489);Lit276 = gnu.lists.PairWithPosition.make(CCIDScheme.Lit167 = gnu.math.IntNum.valueOf(372), gnu.lists.LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 253979);Lit275 = gnu.lists.PairWithPosition.make(gnu.lists.PairWithPosition.make(CCIDScheme.Lit117 = gnu.math.IntNum.valueOf(14), Lit268, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 282669), gnu.lists.PairWithPosition.make(gnu.lists.PairWithPosition.make(CCIDScheme.Lit118 = gnu.math.IntNum.valueOf(15), Lit268, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 282683), gnu.lists.LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 282683), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 282669);Lit274 = gnu.lists.PairWithPosition.make(CCIDScheme.Lit115 = gnu.math.IntNum.valueOf(12), gnu.lists.LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 274461);Lit273 = gnu.lists.PairWithPosition.make(CCIDScheme.Lit58 = gnu.math.IntNum.valueOf(5), CCIDScheme.Lit267 = gnu.lists.PairWithPosition.make(CCIDScheme.Lit6 = gnu.math.IntNum.valueOf(16), gnu.lists.LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid.scm", 942140), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 274465);Lit272 = gnu.lists.PairWithPosition.make(Lit7, gnu.lists.LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 270398);Lit271 = gnu.lists.PairWithPosition.make(CCIDScheme.Lit18 = gnu.math.IntNum.valueOf(4), gnu.lists.LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 270365);Lit270 = gnu.lists.PairWithPosition.make(gnu.math.IntNum.valueOf(20), gnu.lists.LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 274485);Lit269 = gnu.lists.PairWithPosition.make(Lit58, gnu.lists.LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 270376);Lit266 = gnu.lists.PairWithPosition.make(Boolean.FALSE, gnu.lists.LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 466963);Lit265 = gnu.lists.PairWithPosition.make(CCIDScheme.Lit2 = gnu.math.IntNum.valueOf(1), gnu.lists.LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid.scm", 999470);Lit264 = gnu.lists.PairWithPosition.make(CCIDScheme.Lit16 = gnu.math.IntNum.valueOf(2), gnu.lists.LList.Empty, "ccid_7816/CCIDScheme.scm", 430130);Lit263 = gnu.lists.PairWithPosition.make(CCIDScheme.Lit99 = gnu.math.IntNum.valueOf(3), gnu.lists.LList.Empty, "ccid_7816/CCIDScheme.scm", 421938);Lit262 = gnu.lists.PairWithPosition.make(CCIDScheme.Lit1 = gnu.math.IntNum.valueOf(0), gnu.lists.LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid.scm", 1380404);Lit261 = gnu.math.IntNum.valueOf(80);Lit260 = gnu.mapping.Symbol.valueOf("Thread"); Object[] tmp475_472 = new Object[7]; Object[] tmp476_475 = tmp475_472;tmp476_475[0] = gnu.mapping.Symbol.valueOf("as"); Object[] tmp485_476 = tmp476_475;tmp485_476[1] = Lit260; Object[] tmp491_485 = tmp485_476;tmp491_485[2] = gnu.mapping.Symbol.valueOf("object"); Object[] tmp500_491 = tmp491_485;tmp500_491[3] = gnu.lists.PairWithPosition.make(Lit260, gnu.lists.LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/Thread.scm", 40986); Object[] tmp518_500 = tmp500_491;tmp518_500[4] = gnu.lists.PairWithPosition.make(gnu.mapping.Symbol.valueOf("run"), gnu.lists.LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/Thread.scm", 40996); Object[] tmp539_518 = tmp518_500;tmp539_518[5] = gnu.mapping.Symbol.valueOf("::");tmp539_518[6] = gnu.mapping.Symbol.valueOf("void");Lit259 = new kawa.lang.SyntaxTemplate("\001\003", "\021\030\004\021\030\f\b\021\030\024\021\030\034\b\021\030$\021\030,\021\0304\b\r\013", tmp475_472, 1);Lit258 = new kawa.lang.SyntaxPattern("\f\007\r\017\b\b\b", new Object[0], 2, "Thread.scm:9");Lit257 = gnu.mapping.Symbol.valueOf("simple-thread");Lit256 = gnu.mapping.Symbol.valueOf("filter");Lit255 = gnu.bytecode.ArrayType.make(gnu.bytecode.Type.tostring_type);Lit254 = gnu.lists.PairWithPosition.make(Lit261, Lit264, "ccid_7816/CCIDScheme.scm", 430124);Lit253 = gnu.lists.PairWithPosition.make(Lit261, Lit263, "ccid_7816/CCIDScheme.scm", 421932);Lit252 = gnu.mapping.Symbol.valueOf("xfrBlock");Lit251 = gnu.mapping.Symbol.valueOf("atr");Lit250 = gnu.lists.PairWithPosition.make(gnu.lists.PairWithPosition.make(CCIDScheme.Lit170 = gnu.mapping.Symbol.valueOf("optionals"), gnu.lists.PairWithPosition.make(gnu.lists.PairWithPosition.make("USE-DEFAULT-PPS-EXCHANGE", gnu.lists.PairWithPosition.make(Boolean.TRUE, gnu.lists.LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid.scm", 1802314), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid.scm", 1802286), gnu.lists.LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid.scm", 1802286), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid.scm", 1802275), gnu.lists.LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid.scm", 1802274);Lit249 = gnu.mapping.Symbol.valueOf("off");Lit248 = gnu.mapping.Symbol.valueOf("on");Lit247 = gnu.lists.PairWithPosition.make(CCIDScheme.Lit206 = gnu.mapping.Symbol.valueOf("M-bit"), Lit262, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid.scm", 1380397);Lit246 = gnu.lists.PairWithPosition.make(CCIDScheme.Lit190 = gnu.mapping.Symbol.valueOf("type"), gnu.lists.PairWithPosition.make(CCIDScheme.Lit197 = gnu.mapping.Symbol.valueOf("WTX_requset"), gnu.lists.LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid.scm", 1331248), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid.scm", 1331242);Lit245 = gnu.lists.PairWithPosition.make(CCIDScheme.Lit203 = gnu.mapping.Symbol.valueOf("ERRCode"), Lit262, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid.scm", 1441831);Lit244 = gnu.mapping.Symbol.valueOf("reset");Lit243 = gnu.lists.PairWithPosition.make(CCIDScheme.Lit128 = gnu.mapping.Symbol.valueOf("bChainParameter"), Lit263, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid.scm", 1048605);Lit242 = gnu.lists.PairWithPosition.make(Lit128, Lit264, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid.scm", 1028125);Lit241 = gnu.lists.PairWithPosition.make(Lit128, Lit265, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid.scm", 999453);Lit240 = gnu.lists.PairWithPosition.make(Lit128, Lit262, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid.scm", 983069);Lit239 = gnu.lists.PairWithPosition.make(Lit128, Lit267, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid.scm", 942123);Lit238 = gnu.mapping.Symbol.valueOf("Character");Lit237 = gnu.mapping.Symbol.valueOf("E-APDU");Lit236 = gnu.math.IntNum.valueOf(262144);Lit235 = gnu.mapping.Symbol.valueOf("S-APDU");Lit234 = gnu.math.IntNum.valueOf(131072);Lit233 = gnu.mapping.Symbol.valueOf("TPDU");Lit232 = gnu.math.IntNum.valueOf(65536);Lit231 = gnu.math.IntNum.valueOf(458752);Lit230 = gnu.math.IntNum.valueOf(186);Lit229 = gnu.math.IntNum.valueOf(56);Lit228 = gnu.mapping.Symbol.valueOf("length");Lit227 = gnu.mapping.Symbol.valueOf("getall");Lit226 = gnu.mapping.Symbol.valueOf("interrupt_in");Lit225 = gnu.mapping.Symbol.valueOf("endpoint-interrupt-in");Lit224 = gnu.mapping.Symbol.valueOf("endpoint-bulk-in");Lit223 = gnu.mapping.Symbol.valueOf("in");Lit222 = gnu.mapping.Symbol.valueOf("endpoint-bulk-out");Lit221 = gnu.mapping.Symbol.valueOf("out");Lit220 = gnu.lists.PairWithPosition.make(CCIDScheme.Lit92 = gnu.mapping.Symbol.valueOf("bInterfaceCount"), Lit265, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid.scm", 266320);Lit219 = gnu.lists.PairWithPosition.make(CCIDScheme.Lit96 = gnu.mapping.Symbol.valueOf("iFunction"), Lit262, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid.scm", 213066);Lit218 = gnu.mapping.Symbol.valueOf("name");Lit217 = gnu.mapping.Symbol.valueOf("IAD");Lit216 = gnu.mapping.Symbol.valueOf("device");Lit215 = gnu.mapping.Symbol.valueOf("configure");Lit214 = gnu.math.IntNum.valueOf(227);Lit213 = gnu.math.IntNum.valueOf(195);Lit212 = gnu.mapping.Symbol.valueOf("WTX_request");Lit211 = gnu.math.IntNum.valueOf(226);Lit210 = gnu.math.IntNum.valueOf(194);Lit209 = gnu.mapping.Symbol.valueOf("ABORT_request");Lit208 = gnu.math.IntNum.valueOf(225);Lit207 = gnu.math.IntNum.valueOf(193);Lit205 = gnu.mapping.Symbol.valueOf("N(S)");Lit204 = gnu.mapping.Symbol.valueOf("I-block");Lit202 = gnu.mapping.Symbol.valueOf("N(R)");Lit201 = gnu.mapping.Symbol.valueOf("R-block");Lit200 = gnu.mapping.Symbol.valueOf("data");Lit199 = gnu.mapping.Symbol.valueOf("reserved_for_future_use");Lit198 = gnu.mapping.Symbol.valueOf("WTX_response");Lit196 = gnu.mapping.Symbol.valueOf("ABORT_response");Lit195 = gnu.mapping.Symbol.valueOf("ABORT_requset");Lit194 = gnu.mapping.Symbol.valueOf("IFS_response");Lit193 = gnu.mapping.Symbol.valueOf("IFS_request");Lit192 = gnu.mapping.Symbol.valueOf("RESYNCH_response");Lit191 = gnu.mapping.Symbol.valueOf("RESYNCH_request");Lit189 = gnu.mapping.Symbol.valueOf("S-block");Lit188 = gnu.math.IntNum.valueOf(64);Lit187 = gnu.math.IntNum.valueOf(35);Lit186 = gnu.math.IntNum.valueOf(34);Lit185 = gnu.math.IntNum.valueOf(63);Lit184 = gnu.math.IntNum.valueOf(-2);Lit183 = gnu.math.IntNum.valueOf(28);Lit182 = gnu.math.IntNum.valueOf(-5);Lit181 = gnu.math.IntNum.valueOf(2000);Lit180 = gnu.math.IntNum.valueOf(261);Lit179 = gnu.math.IntNum.valueOf(960);Lit178 = gnu.math.DFloNum.valueOf(1.0D);Lit177 = gnu.math.IntNum.valueOf(260);Lit176 = gnu.math.IntNum.valueOf(60000);Lit175 = gnu.math.IntNum.valueOf(240);Lit174 = gnu.math.IntNum.valueOf(77);Lit173 = gnu.math.IntNum.valueOf(59);Lit172 = gnu.math.IntNum.valueOf(32);Lit171 = gnu.math.IntNum.valueOf(17);Lit169 = gnu.math.IntNum.valueOf(151);Lit168 = gnu.mapping.Symbol.valueOf("interface2");Lit166 = gnu.math.IntNum.valueOf(1000);Lit165 = gnu.mapping.Symbol.valueOf("interface1");Lit164 = gnu.mapping.Symbol.valueOf("TB15");Lit163 = gnu.mapping.Symbol.valueOf("TA15");Lit162 = gnu.math.IntNum.valueOf(9);Lit161 = gnu.lists.PairWithPosition.make(gnu.lists.PairWithPosition.make(Lit163, Lit266, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 466957), gnu.lists.PairWithPosition.make(gnu.lists.PairWithPosition.make(Lit164, Lit266, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 466966), gnu.lists.LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 466966), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 466956);Lit160 = gnu.mapping.Symbol.valueOf("T1");Lit159 = gnu.mapping.Symbol.valueOf("T0_T1");Lit158 = gnu.mapping.Symbol.valueOf("interface");Lit157 = gnu.lists.PairWithPosition.make(gnu.lists.PairWithPosition.make(Lit1, Lit271, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 270357), gnu.lists.PairWithPosition.make(gnu.lists.PairWithPosition.make(Lit2, Lit269, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 270368), gnu.lists.PairWithPosition.make(gnu.lists.PairWithPosition.make(Lit16, gnu.lists.PairWithPosition.make(CCIDScheme.Lit21 = gnu.math.IntNum.valueOf(6), gnu.lists.LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 270387), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 270379), gnu.lists.PairWithPosition.make(gnu.lists.PairWithPosition.make(Lit99, Lit272, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 270390), gnu.lists.PairWithPosition.make(gnu.lists.PairWithPosition.make(Lit18, Lit274, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 274453), gnu.lists.PairWithPosition.make(Lit273, gnu.lists.PairWithPosition.make(gnu.lists.PairWithPosition.make(Lit21, Lit270, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 274477), gnu.lists.PairWithPosition.make(Lit277, gnu.lists.PairWithPosition.make(Lit278, gnu.lists.PairWithPosition.make(gnu.lists.PairWithPosition.make(Lit162, Lit269, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 278563), gnu.lists.PairWithPosition.make(gnu.lists.PairWithPosition.make(CCIDScheme.Lit114 = gnu.math.IntNum.valueOf(10), gnu.lists.PairWithPosition.make(gnu.math.DFloNum.valueOf(7.5D), gnu.lists.LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 278582), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 278574), gnu.lists.PairWithPosition.make(gnu.lists.PairWithPosition.make(CCIDScheme.Lit90 = gnu.math.IntNum.valueOf(11), gnu.lists.PairWithPosition.make(Lit114, gnu.lists.LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 278595), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 278587), gnu.lists.PairWithPosition.make(gnu.lists.PairWithPosition.make(Lit115, gnu.lists.PairWithPosition.make(Lit118, gnu.lists.LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 282653), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 282645), gnu.lists.PairWithPosition.make(gnu.lists.PairWithPosition.make(CCIDScheme.Lit116 = gnu.math.IntNum.valueOf(13), Lit270, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 282657), Lit275, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 282657), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 282645), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 278587), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 278574), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 278563), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 278549), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 274489), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 274477), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 274465), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 274453), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 270390), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 270379), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 270368), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 270356);Lit156 = gnu.mapping.Symbol.valueOf("fmax");Lit155 = gnu.lists.PairWithPosition.make(gnu.lists.PairWithPosition.make(Lit1, gnu.lists.PairWithPosition.make(gnu.mapping.Symbol.valueOf("‘RFU"), gnu.lists.LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 286747), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 286739), gnu.lists.PairWithPosition.make(gnu.lists.PairWithPosition.make(Lit2, Lit265, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 286753), gnu.lists.PairWithPosition.make(gnu.lists.PairWithPosition.make(Lit16, Lit264, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 286764), gnu.lists.PairWithPosition.make(gnu.lists.PairWithPosition.make(Lit99, Lit271, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 286775), gnu.lists.PairWithPosition.make(gnu.lists.PairWithPosition.make(Lit18, Lit272, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 290835), gnu.lists.PairWithPosition.make(Lit273, gnu.lists.PairWithPosition.make(gnu.lists.PairWithPosition.make(Lit21, gnu.lists.PairWithPosition.make(Lit172, gnu.lists.LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 290866), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 290858), gnu.lists.PairWithPosition.make(gnu.lists.PairWithPosition.make(Lit105, gnu.lists.PairWithPosition.make(Lit188, gnu.lists.LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 290878), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 290870), gnu.lists.PairWithPosition.make(gnu.lists.PairWithPosition.make(Lit7, Lit274, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 294931), gnu.lists.PairWithPosition.make(gnu.lists.PairWithPosition.make(Lit162, Lit270, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 294943), gnu.lists.PairWithPosition.make(gnu.lists.PairWithPosition.make(Lit114, Lit268, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 294955), gnu.lists.PairWithPosition.make(gnu.lists.PairWithPosition.make(Lit90, Lit268, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 294969), gnu.lists.PairWithPosition.make(gnu.lists.PairWithPosition.make(Lit115, Lit268, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 299027), gnu.lists.PairWithPosition.make(gnu.lists.PairWithPosition.make(Lit116, Lit268, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 299041), Lit275, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 299041), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 299027), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 294969), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 294955), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 294943), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 294931), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 290870), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 290858), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 290846), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 290835), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 286775), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 286764), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 286753), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 286738);Lit154 = gnu.mapping.Symbol.valueOf("Di");Lit153 = gnu.lists.PairWithPosition.make(gnu.lists.PairWithPosition.make(Lit1, Lit276, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 253971), gnu.lists.PairWithPosition.make(gnu.lists.PairWithPosition.make(Lit2, Lit276, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 253985), gnu.lists.PairWithPosition.make(gnu.lists.PairWithPosition.make(Lit16, gnu.lists.PairWithPosition.make(gnu.math.IntNum.valueOf(558), gnu.lists.LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 254007), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 253999), gnu.lists.PairWithPosition.make(gnu.lists.PairWithPosition.make(Lit99, gnu.lists.PairWithPosition.make(gnu.math.IntNum.valueOf(774), gnu.lists.LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 254021), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 254013), gnu.lists.PairWithPosition.make(gnu.lists.PairWithPosition.make(Lit18, gnu.lists.PairWithPosition.make(gnu.math.IntNum.valueOf(1116), gnu.lists.LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 258075), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 258067), gnu.lists.PairWithPosition.make(gnu.lists.PairWithPosition.make(Lit58, gnu.lists.PairWithPosition.make(gnu.math.IntNum.valueOf(1488), gnu.lists.LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 258089), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 258081), gnu.lists.PairWithPosition.make(gnu.lists.PairWithPosition.make(Lit21, gnu.lists.PairWithPosition.make(gnu.math.IntNum.valueOf(1860), gnu.lists.LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 258103), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 258095), gnu.lists.PairWithPosition.make(Lit277, gnu.lists.PairWithPosition.make(Lit278, gnu.lists.PairWithPosition.make(gnu.lists.PairWithPosition.make(Lit162, gnu.lists.PairWithPosition.make(CCIDScheme.Lit22 = gnu.math.IntNum.valueOf(512), gnu.lists.LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 262185), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 262177), gnu.lists.PairWithPosition.make(gnu.lists.PairWithPosition.make(Lit114, gnu.lists.PairWithPosition.make(CCIDScheme.Lit23 = gnu.math.IntNum.valueOf(768), gnu.lists.LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 262199), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 262191), gnu.lists.PairWithPosition.make(gnu.lists.PairWithPosition.make(Lit90, gnu.lists.PairWithPosition.make(gnu.math.IntNum.valueOf(1024), gnu.lists.LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 262213), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 262205), gnu.lists.PairWithPosition.make(gnu.lists.PairWithPosition.make(Lit115, gnu.lists.PairWithPosition.make(gnu.math.IntNum.valueOf(1536), gnu.lists.LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 266267), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 266259), gnu.lists.PairWithPosition.make(gnu.lists.PairWithPosition.make(Lit116, gnu.lists.PairWithPosition.make(gnu.math.IntNum.valueOf(2048), gnu.lists.LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 266281), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 266273), Lit275, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 266273), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 266259), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 262205), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 262191), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 262177), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 262163), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 258109), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 258095), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 258081), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 258067), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 254013), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 253999), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 253985), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 253970);Lit152 = gnu.mapping.Symbol.valueOf("Fi");Lit151 = gnu.math.IntNum.valueOf(-4);Lit150 = gnu.lists.PairWithPosition.make(gnu.lists.PairWithPosition.make(Lit152, Lit276, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 311307), gnu.lists.PairWithPosition.make(gnu.lists.PairWithPosition.make(Lit154, Lit265, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 311316), gnu.lists.PairWithPosition.make(gnu.lists.PairWithPosition.make(Lit156, Lit269, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 311323), gnu.lists.LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 311323), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 311316), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 311306);Lit149 = gnu.mapping.Symbol.valueOf("null");Lit148 = gnu.mapping.Symbol.valueOf("TCK");Lit147 = gnu.mapping.Symbol.valueOf("T0");Lit146 = gnu.mapping.Symbol.valueOf("TS");Lit145 = gnu.mapping.Symbol.valueOf("historical");Lit144 = gnu.mapping.Symbol.valueOf("TD");Lit143 = gnu.mapping.Symbol.valueOf("TC");Lit142 = gnu.mapping.Symbol.valueOf("TB");Lit141 = gnu.mapping.Symbol.valueOf("TA");Lit140 = gnu.math.IntNum.valueOf(101);Lit139 = gnu.mapping.Symbol.valueOf("bRFU");Lit138 = gnu.math.IntNum.valueOf(107);Lit137 = gnu.mapping.Symbol.valueOf("abProtocolDataStructure");Lit136 = gnu.mapping.Symbol.valueOf("bProtocolNum");Lit135 = gnu.math.IntNum.valueOf(130);Lit134 = gnu.lists.PairWithPosition.make(Lit1, Lit262, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid_protocol.scm", 1908755);Lit133 = gnu.math.IntNum.valueOf(97);Lit132 = gnu.mapping.Symbol.valueOf("bClockStatus");Lit131 = gnu.lists.PairWithPosition.make(Lit1, Lit134, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid_protocol.scm", 1757203);Lit130 = gnu.math.IntNum.valueOf(99);Lit129 = gnu.mapping.Symbol.valueOf("abData");Lit127 = gnu.mapping.Symbol.valueOf("bStatus");Lit126 = gnu.mapping.Symbol.valueOf("bSlot");Lit125 = gnu.mapping.Symbol.valueOf("dwLength");Lit124 = gnu.mapping.Symbol.valueOf("bMessagetype");Lit123 = gnu.mapping.Symbol.valueOf("last");Lit122 = gnu.math.IntNum.valueOf(111);Lit121 = gnu.math.IntNum.valueOf(98);Lit120 = gnu.math.IntNum.valueOf(127);Lit119 = gnu.math.IntNum.valueOf(129);Lit113 = gnu.math.IntNum.valueOf(252);Lit112 = gnu.math.IntNum.valueOf(242);Lit111 = gnu.math.IntNum.valueOf(224);Lit110 = gnu.math.IntNum.valueOf(245);Lit109 = gnu.math.IntNum.valueOf(246);Lit108 = gnu.math.IntNum.valueOf(247);Lit107 = gnu.math.IntNum.valueOf(248);Lit106 = gnu.math.IntNum.valueOf(253);Lit104 = gnu.math.IntNum.valueOf(251);Lit103 = gnu.math.IntNum.valueOf(254);Lit102 = gnu.math.IntNum.valueOf(-6);Lit101 = gnu.math.IntNum.valueOf(192);Lit100 = gnu.mapping.Symbol.valueOf("next");Lit98 = gnu.mapping.Symbol.valueOf("ccid_class");Lit97 = gnu.lists.PairWithPosition.make(Lit217, gnu.lists.LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid_descriptor.scm", 905257);Lit95 = gnu.mapping.Symbol.valueOf("bFunctionProtocol");Lit94 = gnu.mapping.Symbol.valueOf("bFunctionSubClass");Lit93 = gnu.mapping.Symbol.valueOf("bFunctionClass");Lit91 = gnu.mapping.Symbol.valueOf("bFirstInterface");Lit89 = gnu.mapping.Symbol.valueOf("bMaxCCIDBusySlots");Lit88 = gnu.mapping.Symbol.valueOf("bPINSupport");Lit87 = gnu.mapping.Symbol.valueOf("wLcdLayout");Lit86 = gnu.mapping.Symbol.valueOf("bClassEnvelope");Lit85 = gnu.mapping.Symbol.valueOf("bClassGetResponse");Lit84 = gnu.mapping.Symbol.valueOf("dwMaxCCIDMessageLength");Lit83 = gnu.mapping.Symbol.valueOf("dwFeatures");Lit82 = gnu.mapping.Symbol.valueOf("dwMechanical");Lit81 = gnu.mapping.Symbol.valueOf("dwSynchProtocols");Lit80 = gnu.mapping.Symbol.valueOf("dwMaxIFSD");Lit79 = gnu.mapping.Symbol.valueOf("bNumDataRatesSupported");Lit78 = gnu.mapping.Symbol.valueOf("dwMaxDataRate");Lit77 = gnu.mapping.Symbol.valueOf("dwDataRate");Lit76 = gnu.mapping.Symbol.valueOf("bNumClockSupported");Lit75 = gnu.mapping.Symbol.valueOf("dwMaximumClock");Lit74 = gnu.mapping.Symbol.valueOf("dwDefaultClock");Lit73 = gnu.mapping.Symbol.valueOf("dwProtocols");Lit72 = gnu.mapping.Symbol.valueOf("bVoltageSupport");Lit71 = gnu.mapping.Symbol.valueOf("bMaxSlotIndex");Lit70 = gnu.mapping.Symbol.valueOf("bcdCCID");Lit69 = gnu.lists.PairWithPosition.make(Lit98, gnu.lists.LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid_descriptor.scm", 835672);Lit68 = gnu.math.IntNum.valueOf(33);Lit67 = gnu.lists.PairWithPosition.make(gnu.mapping.Symbol.valueOf("endpoint"), gnu.lists.LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid_descriptor.scm", 331814);Lit66 = gnu.lists.PairWithPosition.make(Lit222, gnu.lists.LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid_descriptor.scm", 327713);Lit65 = gnu.lists.PairWithPosition.make(Lit224, gnu.lists.LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid_descriptor.scm", 315425);Lit64 = gnu.lists.PairWithPosition.make(CCIDScheme.Lit48 = gnu.mapping.Symbol.valueOf("bmAttributes"), Lit264, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid_descriptor.scm", 307265);Lit63 = gnu.lists.PairWithPosition.make(Lit225, gnu.lists.LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid_descriptor.scm", 303137);Lit62 = gnu.lists.PairWithPosition.make(Lit48, Lit263, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid_descriptor.scm", 294977);Lit61 = gnu.mapping.Symbol.valueOf("bInterval");Lit60 = gnu.mapping.Symbol.valueOf("wMaxPacketSize");Lit59 = gnu.mapping.Symbol.valueOf("bEndpointAddress");Lit57 = gnu.mapping.Symbol.valueOf("iInterface");Lit56 = gnu.mapping.Symbol.valueOf("bInterfaceProtocol");Lit55 = gnu.mapping.Symbol.valueOf("bInterfaceSubClass");Lit54 = gnu.mapping.Symbol.valueOf("bInterfaceClass");Lit53 = gnu.mapping.Symbol.valueOf("bNumEndpoints");Lit52 = gnu.mapping.Symbol.valueOf("bAlternateSetting");Lit51 = gnu.mapping.Symbol.valueOf("bInterfaceNumber");Lit50 = gnu.lists.PairWithPosition.make(Lit158, gnu.lists.LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid_descriptor.scm", 811095);Lit49 = gnu.mapping.Symbol.valueOf("bMaxPower");Lit47 = gnu.mapping.Symbol.valueOf("iConfiguration");Lit46 = gnu.mapping.Symbol.valueOf("bConfigurationValue");Lit45 = gnu.mapping.Symbol.valueOf("bNumInterfaces");Lit44 = gnu.mapping.Symbol.valueOf("wTotalLength");Lit43 = gnu.lists.PairWithPosition.make(Lit215, gnu.lists.LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid_descriptor.scm", 782400);Lit42 = gnu.mapping.Symbol.valueOf("bNumConfigurations");Lit41 = gnu.mapping.Symbol.valueOf("iSerialNumber");Lit40 = gnu.mapping.Symbol.valueOf("iProduct");Lit39 = gnu.mapping.Symbol.valueOf("iManufacture");Lit38 = gnu.mapping.Symbol.valueOf("bcdDevice");Lit37 = gnu.mapping.Symbol.valueOf("idProduct");Lit36 = gnu.mapping.Symbol.valueOf("idVendor");Lit35 = gnu.mapping.Symbol.valueOf("bMaxPacketSize0");Lit34 = gnu.mapping.Symbol.valueOf("bDeviceProtocol");Lit33 = gnu.mapping.Symbol.valueOf("bDeviceSubClass");Lit32 = gnu.mapping.Symbol.valueOf("bDeviceCLass");Lit31 = gnu.mapping.Symbol.valueOf("bcdUSB");Lit30 = gnu.mapping.Symbol.valueOf("bDescriptorType");Lit29 = gnu.mapping.Symbol.valueOf("bLength");Lit28 = gnu.lists.PairWithPosition.make(Lit216, gnu.lists.LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid_descriptor.scm", 778304);Lit27 = gnu.mapping.Symbol.valueOf("interface0");Lit26 = gnu.math.IntNum.valueOf(18);Lit25 = gnu.math.IntNum.valueOf(256);Lit24 = gnu.math.IntNum.valueOf(1033);Lit20 = gnu.math.IntNum.valueOf(128);Lit19 = gnu.lists.PairWithPosition.make(Lit105, gnu.lists.PairWithPosition.make(Lit21, gnu.lists.PairWithPosition.make(Lit58, gnu.lists.PairWithPosition.make(Lit18, gnu.lists.PairWithPosition.make(Lit99, gnu.lists.PairWithPosition.make(Lit16, gnu.lists.PairWithPosition.make(Lit2, Lit262, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/util.scm", 905240), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/util.scm", 905238), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/util.scm", 905236), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/util.scm", 905234), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/util.scm", 905232), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/util.scm", 905230), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/util.scm", 905227);Lit17 = gnu.math.IntNum.valueOf(48);Lit15 = gnu.mapping.Symbol.valueOf("get");Lit14 = gnu.mapping.Symbol.valueOf("add");Lit13 = gnu.mapping.Symbol.valueOf("set");Lit12 = gnu.math.IntNum.valueOf(-24);Lit11 = gnu.math.IntNum.valueOf(-16);Lit10 = gnu.math.IntNum.valueOf(-8);Lit9 = gnu.math.IntNum.valueOf(255);Lit8 = gnu.mapping.Symbol.valueOf("big");Lit5 = gnu.math.IntNum.valueOf(24);Lit4 = gnu.mapping.Symbol.valueOf("little");Lit3 = gnu.expr.Keyword.make("endia");Lit0 = gnu.bytecode.ArrayType.make(gnu.bytecode.Type.byte_type);Log = (gnu.kawa.lispexpr.ClassNamespace)new gnu.kawa.lispexpr.ClassNamespace(gnu.bytecode.ClassType.make("android.util.Log")).readResolve();Thread = Thread.class;CCIDScheme.frame.$instance = new CCIDScheme.frame();CCIDScheme.frame localFrame1 = CCIDScheme.frame.$instance; void tmp4436_4433 = new ModuleMethod(localFrame1, 30, "list->u8vector", 4097);tmp4436_4433.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/Type.scm:2");list$Mn$Gru8vector = tmp4436_4433; void tmp4465_4462 = new ModuleMethod(localFrame1, 31, "u8vector->list", 4097);tmp4465_4462.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/Type.scm:9");u8vector$Mn$Grlist = tmp4465_4462; void tmp4494_4491 = new ModuleMethod(localFrame1, 32, "make-u8vector", 8193);tmp4494_4491.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/Type.scm:11");make$Mnu8vector = tmp4494_4491; void tmp4523_4520 = new ModuleMethod(localFrame1, 34, "object->string", 4097);tmp4523_4520.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/util.scm:4");object$Mn$Grstring = tmp4523_4520; void tmp4552_4549 = new ModuleMethod(localFrame1, 35, "slice", 12291);tmp4552_4549.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/util.scm:8");slice = tmp4552_4549; void tmp4580_4577 = new ModuleMethod(localFrame1, 36, "build-dword-fromlst", 61441);tmp4580_4577.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/util.scm:17");build$Mndword$Mnfromlst = tmp4580_4577; void tmp4608_4605 = new ModuleMethod(localFrame1, 37, "build-dword-inlst", 61441);tmp4608_4605.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/util.scm:36");build$Mndword$Mninlst = tmp4608_4605; void tmp4636_4633 = new ModuleMethod(localFrame1, 38, "build-word-fromlst", 61441);tmp4636_4633.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/util.scm:54");build$Mnword$Mnfromlst = tmp4636_4633; void tmp4664_4661 = new ModuleMethod(localFrame1, 39, "build-word-inlst", 61441);tmp4664_4661.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/util.scm:68");build$Mnword$Mninlst = tmp4664_4661; void tmp4693_4690 = new ModuleMethod(localFrame1, 40, "make-counter", 8192);tmp4693_4690.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/util.scm:82");make$Mncounter = tmp4693_4690; void tmp4722_4719 = new ModuleMethod(localFrame1, 43, "make-container", 4097);tmp4722_4719.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/util.scm:90");make$Mncontainer = tmp4722_4719; void tmp4751_4748 = new ModuleMethod(localFrame1, 44, "to-list", 61441);tmp4751_4748.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/util.scm:99");to$Mnlist = tmp4751_4748; void tmp4780_4777 = new ModuleMethod(localFrame1, 45, "read-u8s", 8194);tmp4780_4777.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/util.scm:103");read$Mnu8s = tmp4780_4777; void tmp4809_4806 = new ModuleMethod(localFrame1, 46, "call-with-input-u8vector", 8194);tmp4809_4806.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/util.scm:114");call$Mnwith$Mninput$Mnu8vector = tmp4809_4806; void tmp4836_4833 = new ModuleMethod(localFrame1, 47, null, 4097);tmp4836_4833.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/util.scm:122");lambda$Fn3 = tmp4836_4833; void tmp4865_4862 = new ModuleMethod(localFrame1, 48, "subu8list", 12291);tmp4865_4862.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/util.scm:128");subu8list = tmp4865_4862; void tmp4894_4891 = new ModuleMethod(localFrame1, 49, "group-list", 8194);tmp4894_4891.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/util.scm:134");group$Mnlist = tmp4894_4891;filter = new ModuleMethod(localFrame1, 50, Lit256, 8194); void tmp4942_4939 = new ModuleMethod(localFrame1, 51, "assoc-EX", 8194);tmp4942_4939.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/util.scm:150");assoc$MnEX = tmp4942_4939; void tmp4971_4968 = new ModuleMethod(localFrame1, 52, "list-xor", 4097);tmp4971_4968.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/util.scm:159");list$Mnxor = tmp4971_4968; void tmp5000_4997 = new ModuleMethod(localFrame1, 53, "to-hexStr", 8193);tmp5000_4997.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/util.scm:165");to$MnhexStr = tmp5000_4997; void tmp5029_5026 = new ModuleMethod(localFrame1, 55, "to-octStr", 8193);tmp5029_5026.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/util.scm:177");to$MnoctStr = tmp5029_5026; void tmp5058_5055 = new ModuleMethod(localFrame1, 57, "to-binStr", 8193);tmp5058_5055.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/util.scm:189");to$MnbinStr = tmp5058_5055; void tmp5087_5084 = new ModuleMethod(localFrame1, 59, "u8list->string", 8193);tmp5087_5084.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/util.scm:202");u8list$Mn$Grstring = tmp5087_5084; void tmp5116_5113 = new ModuleMethod(localFrame1, 61, "in-list?", 8194);tmp5116_5113.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/util.scm:210");in$Mnlist$Qu = tmp5116_5113; void tmp5145_5142 = new ModuleMethod(localFrame1, 62, "byte->bit", 4097);tmp5145_5142.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/util.scm:219");byte$Mn$Grbit = tmp5145_5142; void tmp5174_5171 = new ModuleMethod(localFrame1, 63, "list-remove-duplication", 4097);tmp5174_5171.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/util.scm:225");list$Mnremove$Mnduplication = tmp5174_5171; void tmp5203_5200 = new ModuleMethod(localFrame1, 64, "float->integer", 4097);tmp5203_5200.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/util.scm:232");float$Mn$Grinteger = tmp5203_5200; void tmp5232_5229 = new ModuleMethod(localFrame1, 65, "stringlst->string", 8193);tmp5232_5229.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/util.scm:237");stringlst$Mn$Grstring = tmp5232_5229; void tmp5261_5258 = new ModuleMethod(localFrame1, 67, "alist->list", 4097);tmp5261_5258.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/util.scm:244");alist$Mn$Grlist = tmp5261_5258; void tmp5290_5287 = new ModuleMethod(localFrame1, 68, "get-configuration-descriptor", 4097);tmp5290_5287.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/usb.scm:3");get$Mnconfiguration$Mndescriptor = tmp5290_5287; void tmp5319_5316 = new ModuleMethod(localFrame1, 69, "get-string-descriptor", 8194);tmp5319_5316.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/usb.scm:11");get$Mnstring$Mndescriptor = tmp5319_5316; void tmp5348_5345 = new ModuleMethod(localFrame1, 70, "get-device-descriptor", 4097);tmp5348_5345.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/usb.scm:20");get$Mndevice$Mndescriptor = tmp5348_5345; void tmp5375_5372 = new ModuleMethod(localFrame1, 71, null, 8192);tmp5375_5372.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid_descriptor.scm:6");lambda$Fn5 = tmp5375_5372; void tmp5402_5399 = new ModuleMethod(localFrame1, 74, null, 8194);tmp5402_5399.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid_descriptor.scm:172");lambda$Fn7 = tmp5402_5399; void tmp5429_5426 = new ModuleMethod(localFrame1, 75, null, 4097);tmp5429_5426.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid_descriptor.scm:124");lambda$Fn9 = tmp5429_5426; void tmp5456_5453 = new ModuleMethod(localFrame1, 76, null, 4097);tmp5456_5453.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid_descriptor.scm:107");lambda$Fn10 = tmp5456_5453; void tmp5483_5480 = new ModuleMethod(localFrame1, 77, null, 4097);tmp5483_5480.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid_descriptor.scm:89");lambda$Fn11 = tmp5483_5480; void tmp5510_5507 = new ModuleMethod(localFrame1, 78, null, 4097);tmp5510_5507.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid_descriptor.scm:62");lambda$Fn12 = tmp5510_5507; void tmp5537_5534 = new ModuleMethod(localFrame1, 79, null, 4097);tmp5537_5534.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid_descriptor.scm:31");lambda$Fn13 = tmp5537_5534; void tmp5564_5561 = new ModuleMethod(localFrame1, 80, null, 4097);tmp5564_5561.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid_descriptor.scm:146");lambda$Fn14 = tmp5564_5561; void tmp5591_5588 = new ModuleMethod(localFrame1, 81, null, 4097);tmp5591_5588.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid_descriptor.scm:17");lambda$Fn6 = tmp5591_5588; void tmp5620_5617 = new ModuleMethod(localFrame1, 82, "parse-descriptor", 4097);tmp5620_5617.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid_descriptor.scm:14");parse$Mndescriptor = tmp5620_5617; void tmp5649_5646 = new ModuleMethod(localFrame1, 83, "get-voltageSupport-from-descriptor", 4097);tmp5649_5646.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid_descriptor.scm:226");get$MnvoltageSupport$Mnfrom$Mndescriptor = tmp5649_5646; void tmp5678_5675 = new ModuleMethod(localFrame1, 84, "get-bSeq", 4096);tmp5678_5675.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid_protocol.scm:3");get$MnbSeq = tmp5678_5675; void tmp5707_5704 = new ModuleMethod(localFrame1, 86, "get-bStatus-bError-errorName", 8194);tmp5707_5704.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid_protocol.scm:13");get$MnbStatus$MnbError$MnerrorName = tmp5707_5704; void tmp5736_5733 = new ModuleMethod(localFrame1, 87, "PC_to_RDR_IccPowerOn", 8194);tmp5736_5733.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid_protocol.scm:369");PC_to_RDR_IccPowerOn = tmp5736_5733; void tmp5765_5762 = new ModuleMethod(localFrame1, 88, "PC_to_RDR_XfrBlock", 16388);tmp5765_5762.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid_protocol.scm:384");PC_to_RDR_XfrBlock = tmp5765_5762; void tmp5794_5791 = new ModuleMethod(localFrame1, 89, "RDR_to_PC_DataBlock", 4097);tmp5794_5791.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid_protocol.scm:403");RDR_to_PC_DataBlock = tmp5794_5791; void tmp5823_5820 = new ModuleMethod(localFrame1, 90, "PC_to_RDR_IccPowerOff", 4097);tmp5823_5820.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid_protocol.scm:424");PC_to_RDR_IccPowerOff = tmp5823_5820; void tmp5852_5849 = new ModuleMethod(localFrame1, 91, "RDR_to_PC_SlotStatus", 4097);tmp5852_5849.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid_protocol.scm:437");RDR_to_PC_SlotStatus = tmp5852_5849; void tmp5881_5878 = new ModuleMethod(localFrame1, 92, "PC_to_RDR_SetParameters", 12291);tmp5881_5878.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid_protocol.scm:460");PC_to_RDR_SetParameters = tmp5881_5878; void tmp5910_5907 = new ModuleMethod(localFrame1, 93, "RDR_to_PC_Parameters", 4097);tmp5910_5907.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid_protocol.scm:476");RDR_to_PC_Parameters = tmp5910_5907; void tmp5939_5936 = new ModuleMethod(localFrame1, 94, "PC_to_RDR_Escape", 8194);tmp5939_5936.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid_protocol.scm:503");PC_to_RDR_Escape = tmp5939_5936; void tmp5968_5965 = new ModuleMethod(localFrame1, 95, "RDR_to_PC_Escape", 4097);tmp5968_5965.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid_protocol.scm:516");RDR_to_PC_Escape = tmp5968_5965; void tmp5997_5994 = new ModuleMethod(localFrame1, 96, "PC_to_RDR_GetSlotStatus", 4097);tmp5997_5994.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid_protocol.scm:538");PC_to_RDR_GetSlotStatus = tmp5997_5994; void tmp6024_6021 = new ModuleMethod(localFrame1, 97, null, 4097);tmp6024_6021.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm:13");lambda$Fn16 = tmp6024_6021; void tmp6053_6050 = new ModuleMethod(localFrame1, 98, "parse-ATR", 4097);tmp6053_6050.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm:2");parse$MnATR = tmp6053_6050; void tmp6082_6079 = new ModuleMethod(localFrame1, 99, "parse-atrTA1", 4097);tmp6082_6079.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm:61");parse$MnatrTA1 = tmp6082_6079; void tmp6109_6106 = new ModuleMethod(localFrame1, 100, null, 4097);tmp6109_6106.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm:89");lambda$Fn17 = tmp6109_6106; void tmp6138_6135 = new ModuleMethod(localFrame1, 101, "get-atrSupportProtocol", 4097);tmp6138_6135.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm:87");get$MnatrSupportProtocol = tmp6138_6135; void tmp6165_6162 = new ModuleMethod(localFrame1, 102, null, 4097);tmp6165_6162.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm:106");lambda$Fn18 = tmp6165_6162; void tmp6194_6191 = new ModuleMethod(localFrame1, 103, "get-atrTATB-for-T15", 4097);tmp6194_6191.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm:104");get$MnatrTATB$Mnfor$MnT15 = tmp6194_6191; void tmp6223_6220 = new ModuleMethod(localFrame1, 104, "get-pps1", 4097);tmp6223_6220.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm:126");get$Mnpps1 = tmp6223_6220; void tmp6250_6247 = new ModuleMethod(localFrame1, 105, null, 4097);tmp6250_6247.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm:187");lambda$Fn19 = tmp6250_6247; void tmp6279_6276 = new ModuleMethod(localFrame1, 106, "generate-PPS-exchange", 4097);tmp6279_6276.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm:167");generate$MnPPS$Mnexchange = tmp6279_6276; void tmp6308_6305 = new ModuleMethod(localFrame1, 107, "get-atrIFSC", 4097);tmp6308_6305.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm:194");get$MnatrIFSC = tmp6308_6305; void tmp6337_6334 = new ModuleMethod(localFrame1, 108, "get-atrTC-for-T1", 4097);tmp6337_6334.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm:222");get$MnatrTC$Mnfor$MnT1 = tmp6337_6334; void tmp6366_6363 = new ModuleMethod(localFrame1, 109, "get-atrTB-for-T1", 4097);tmp6366_6363.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm:251");get$MnatrTB$Mnfor$MnT1 = tmp6366_6363; void tmp6395_6392 = new ModuleMethod(localFrame1, 110, "generate-PPS-parameters-T1", 4097);tmp6395_6392.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm:279");generate$MnPPS$Mnparameters$MnT1 = tmp6395_6392; void tmp6424_6421 = new ModuleMethod(localFrame1, 111, "generate-PPS-parameters-T0", 4097);tmp6424_6421.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm:316");generate$MnPPS$Mnparameters$MnT0 = tmp6424_6421; void tmp6453_6450 = new ModuleMethod(localFrame1, 112, "get-Card-Timeout-T1", 4097);tmp6453_6450.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm:339");get$MnCard$MnTimeout$MnT1 = tmp6453_6450; void tmp6482_6479 = new ModuleMethod(localFrame1, 113, "get-Card-Timeout-T0", 4097);tmp6482_6479.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm:370");get$MnCard$MnTimeout$MnT0 = tmp6482_6479; void tmp6511_6508 = new ModuleMethod(localFrame1, 114, "get-Card-Timeout", 4097);tmp6511_6508.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm:399");get$MnCard$MnTimeout = tmp6511_6508; void tmp6540_6537 = new ModuleMethod(localFrame1, 115, "parse-T1Block", 8193);tmp6540_6537.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm:410");parse$MnT1Block = tmp6540_6537; void tmp6569_6566 = new ModuleMethod(localFrame1, 117, "generate-S-block-TPDU-T1", 8194);tmp6569_6566.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm:495");generate$MnS$Mnblock$MnTPDU$MnT1 = tmp6569_6566; void tmp6598_6595 = new ModuleMethod(localFrame1, 118, "generate-I-block-TPDU-T1", 12291);tmp6598_6595.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm:512");generate$MnI$Mnblock$MnTPDU$MnT1 = tmp6598_6595; void tmp6627_6624 = new ModuleMethod(localFrame1, 119, "generate-R-block-TPDU-T1", 8194);tmp6627_6624.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm:522");generate$MnR$Mnblock$MnTPDU$MnT1 = tmp6627_6624; void tmp6656_6653 = new ModuleMethod(localFrame1, 120, "make-GET_DEVICE_INF-func", 8194);tmp6656_6653.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid.scm:18");make$MnGET_DEVICE_INF$Mnfunc = tmp6656_6653; void tmp6685_6682 = new ModuleMethod(localFrame1, 121, "do-PPS-exchange", 12291);tmp6685_6682.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid.scm:98");do$MnPPS$Mnexchange = tmp6685_6682; void tmp6714_6711 = new ModuleMethod(localFrame1, 122, "do-PPS-set-parameters", 12291);tmp6714_6711.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid.scm:110");do$MnPPS$Mnset$Mnparameters = tmp6714_6711; void tmp6743_6740 = new ModuleMethod(localFrame1, 123, "do-PPS", 12291);tmp6743_6740.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid.scm:129");do$MnPPS = tmp6743_6740; void tmp6772_6769 = new ModuleMethod(localFrame1, 124, "get-ccid-exchange-level", 4097);tmp6772_6769.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid.scm:169");get$Mnccid$Mnexchange$Mnlevel = tmp6772_6769; void tmp6801_6798 = new ModuleMethod(localFrame1, 125, "do-XfrBlock-TPDU-T0-Protocol", 16388);tmp6801_6798.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid.scm:187");do$MnXfrBlock$MnTPDU$MnT0$MnProtocol = tmp6801_6798; void tmp6830_6827 = new ModuleMethod(localFrame1, 126, "do-XfrBlock-APDU-Extended-Protocol", 16388);tmp6830_6827.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid.scm:204");do$MnXfrBlock$MnAPDU$MnExtended$MnProtocol = tmp6830_6827; void tmp6857_6854 = new ModuleMethod(localFrame1, 127, null, 8193);tmp6857_6854.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid.scm:266");lambda$Fn21 = tmp6857_6854; void tmp6885_6882 = new ModuleMethod(localFrame1, 129, null, 8193);tmp6885_6882.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid.scm:276");lambda$Fn22 = tmp6885_6882; void tmp6915_6912 = new ModuleMethod(localFrame1, 131, "IFS-request-TPDU-T1", 16388);tmp6915_6912.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid.scm:284");IFS$Mnrequest$MnTPDU$MnT1 = tmp6915_6912; void tmp6945_6942 = new ModuleMethod(localFrame1, 132, "do-XfrBlock-TPDU-T1-Protocol", 20485);tmp6945_6942.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid.scm:307");do$MnXfrBlock$MnTPDU$MnT1$MnProtocol = tmp6945_6942; void tmp6973_6970 = new ModuleMethod(localFrame1, 133, null, 4096);tmp6973_6970.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid.scm:377");lambda$Fn23 = tmp6973_6970; void tmp7003_7000 = new ModuleMethod(localFrame1, 135, "do-InitDescriptorInf", 4097);tmp7003_7000.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid.scm:385");do$MnInitDescriptorInf = tmp7003_7000; void tmp7033_7030 = new ModuleMethod(localFrame1, 136, "do-PowerOff", 8193);tmp7033_7030.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid.scm:394");do$MnPowerOff = tmp7033_7030; void tmp7063_7060 = new ModuleMethod(localFrame1, 138, "do-PowerOn", 16386);tmp7063_7060.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid.scm:403");do$MnPowerOn = tmp7063_7060; void tmp7093_7090 = new ModuleMethod(localFrame1, 141, "do-Escape", 12290);tmp7093_7090.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid.scm:485");do$MnEscape = tmp7093_7090; void tmp7123_7120 = new ModuleMethod(localFrame1, 143, "do-SlotStatus", 8193);tmp7123_7120.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid.scm:493");do$MnSlotStatus = tmp7123_7120;CCIDScheme.frame localFrame2 = CCIDScheme.frame.$instance; void tmp7158_7155 = new ModuleMethod(localFrame2, 145, null, 4097);tmp7158_7155.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/Thread.scm:7");simple$Mnthread = kawa.lang.Macro.make(Lit257, tmp7158_7155, "com.ftsafe.CCIDScheme"); void tmp7194_7191 = new ModuleMethod(localFrame1, 146, "thread-sleep!", 4097);tmp7194_7191.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/Thread.scm:16");thread$Mnsleep$Ex = tmp7194_7191; void tmp7224_7221 = new ModuleMethod(localFrame1, 147, "make-thread", 4097);tmp7224_7221.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/Thread.scm:20");make$Mnthread = tmp7224_7221; void tmp7254_7251 = new ModuleMethod(localFrame1, 148, "thread-start!", 4097);tmp7254_7251.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/Thread.scm:25");thread$Mnstart$Ex = tmp7254_7251;Object = Log;FTReaderInf = Log;Context = Log;Handler = Log; void tmp7308_7305 = new ModuleMethod(localFrame1, 149, "GET_DEVICES_INF_default", 61440);tmp7308_7305.setProperty("source-location", "ccid_7816/CCIDScheme.scm:21");GET_DEVICES_INF_default = tmp7308_7305; void tmp7336_7333 = new ModuleMethod(localFrame1, 150, null, 61440);tmp7336_7333.setProperty("source-location", "ccid_7816/CCIDScheme.scm:23");lambda$Fn29 = tmp7336_7333; void tmp7364_7361 = new ModuleMethod(localFrame1, 151, null, 61440);tmp7364_7361.setProperty("source-location", "ccid_7816/CCIDScheme.scm:24");lambda$Fn30 = tmp7364_7361; void tmp7392_7389 = new ModuleMethod(localFrame1, 152, null, 61440);tmp7392_7389.setProperty("source-location", "ccid_7816/CCIDScheme.scm:25");lambda$Fn31 = tmp7392_7389; void tmp7420_7417 = new ModuleMethod(localFrame1, 153, null, 61440);tmp7420_7417.setProperty("source-location", "ccid_7816/CCIDScheme.scm:26");lambda$Fn32 = tmp7420_7417; void tmp7448_7445 = new ModuleMethod(localFrame1, 154, null, 61440);tmp7448_7445.setProperty("source-location", "ccid_7816/CCIDScheme.scm:27");lambda$Fn33 = tmp7448_7445;CCIDScheme = CCIDScheme.class; void tmp7481_7478 = new ModuleMethod(localFrame1, 155, null, 8194);tmp7481_7478.setProperty("source-location", "ccid_7816/CCIDScheme.scm:68");lambda$Fn37 = tmp7481_7478;$runBody$(); } static final gnu.lists.PairWithPosition Lit278 = gnu.lists.PairWithPosition.make(CCIDScheme.Lit7 = gnu.math.IntNum.valueOf(8), CCIDScheme.Lit268 = gnu.lists.PairWithPosition.make(gnu.lists.PairWithPosition.make(gnu.mapping.Symbol.valueOf("quote"), gnu.lists.PairWithPosition.make(gnu.mapping.Symbol.valueOf("RFU"), gnu.lists.LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 274498), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 274498), gnu.lists.LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 274497), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 278549);
  static Object lambda64(Object x) { Object localObject = x;Object[] arrayOfObject = kawa.lang.SyntaxPattern.allocVars(2, null);
    
    kawa.lang.TemplateScope localTemplateScope = kawa.lang.TemplateScope.make();return Lit258.match(x, arrayOfObject, 0) ? Lit259.execute(arrayOfObject, localTemplateScope) : kawa.standard.syntax_case.error("syntax-case", x);
  }
  
  public static void threadSleep$Ex(Object t)
  {
    try
    {
      Thread.sleep(((Number)(localObject = gnu.mapping.Promise.force(gnu.kawa.functions.MultiplyOp.$St.apply2(t, Lit166)))).longValue());return; } catch (ClassCastException localClassCastException) { Object localObject; throw new gnu.mapping.WrongType(localClassCastException, "java.lang.Thread.sleep(long)", 1, localObject);
    } }
  
  public static 0 makeThread(Object func) { frame16 $heapFrame = new frame16();func = func;
    new Thread()
    {
      public void run()
      {
        kawa.standard.Scheme.applyToArgs.apply1(func);
      }
    };
  }
  






































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































  public static void threadStart$Ex(Object thread)
  {
    ((Thread)gnu.mapping.Promise.force(thread, Thread.class)).start();
  }
  
  /* Error */
  public Object readerOpen(Object device)
  {
    // Byte code:
    //   0: new 1845	com/ftsafe/CCIDScheme$frame18
    //   3: dup
    //   4: invokespecial 1846	com/ftsafe/CCIDScheme$frame18:<init>	()V
    //   7: astore_2
    //   8: aload_2
    //   9: aload_0
    //   10: putfield 1847	com/ftsafe/CCIDScheme$frame18:$this$	Lcom/ftsafe/CCIDScheme;
    //   13: aload_2
    //   14: getfield 1847	com/ftsafe/CCIDScheme$frame18:$this$	Lcom/ftsafe/CCIDScheme;
    //   17: getfield 1789	com/ftsafe/CCIDScheme:mFTReaderInf	Lcom/ftsafe/readerScheme/FTReaderInf;
    //   20: aload_1
    //   21: invokeinterface 1850 2 0
    //   26: getstatic 1742	com/ftsafe/CCIDScheme:USB_CONTROL_IN	Lgnu/mapping/Procedure;
    //   29: invokestatic 1853	com/ftsafe/CCIDScheme:doInitDescriptorInf	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   32: putstatic 1734	com/ftsafe/CCIDScheme:GET_DEVICES_INF	Ljava/lang/Object;
    //   35: invokestatic 1859	gnu/kawa/slib/srfi69:makeHashTable	()Lkawa/lib/kawa/hashtable$HashTable;
    //   38: putstatic 1777	com/ftsafe/CCIDScheme:XfrBlock$Mnhash$Mntable	Ljava/lang/Object;
    //   41: getstatic 336	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   44: getstatic 1734	com/ftsafe/CCIDScheme:GET_DEVICES_INF	Ljava/lang/Object;
    //   47: invokevirtual 780	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   50: invokestatic 385	gnu/lists/Sequences:getIterator	(Ljava/lang/Object;)Ljava/util/Iterator;
    //   53: astore_3
    //   54: getstatic 132	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
    //   57: astore 4
    //   59: aconst_null
    //   60: astore 5
    //   62: new 1861	com/ftsafe/CCIDScheme$frame19
    //   65: dup
    //   66: invokespecial 1862	com/ftsafe/CCIDScheme$frame19:<init>	()V
    //   69: dup
    //   70: aload_2
    //   71: putfield 1866	com/ftsafe/CCIDScheme$frame19:staticLink	Lcom/ftsafe/CCIDScheme$frame18;
    //   74: astore 6
    //   76: aload_3
    //   77: invokeinterface 391 1 0
    //   82: ifeq +118 -> 200
    //   85: aload_3
    //   86: invokeinterface 395 1 0
    //   91: astore 7
    //   93: aload 7
    //   95: ldc 98
    //   97: invokestatic 101	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   100: dup
    //   101: astore 10
    //   103: checkcast 98	gnu/lists/Pair
    //   106: invokestatic 118	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   109: aload 6
    //   111: swap
    //   112: putfield 1867	com/ftsafe/CCIDScheme$frame19:index	Ljava/lang/Object;
    //   115: getstatic 1395	com/ftsafe/CCIDScheme:Lit226	Lgnu/mapping/SimpleSymbol;
    //   118: aload 7
    //   120: ldc 98
    //   122: invokestatic 101	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   125: dup
    //   126: astore 10
    //   128: checkcast 98	gnu/lists/Pair
    //   131: invokestatic 106	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   134: invokestatic 348	kawa/lib/lists:assoc	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   137: invokestatic 287	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   140: ifeq +20 -> 160
    //   143: aload 6
    //   145: getfield 1909	com/ftsafe/CCIDScheme$frame19:lambda$Fn40	Lgnu/expr/ModuleMethod;
    //   148: invokestatic 1913	com/ftsafe/CCIDScheme:makeThread	(Ljava/lang/Object;)Lcom/ftsafe/CCIDScheme$0;
    //   151: invokestatic 1916	com/ftsafe/CCIDScheme:threadStart$Ex	(Ljava/lang/Object;)V
    //   154: getstatic 529	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   157: goto +6 -> 163
    //   160: getstatic 529	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   163: astore 9
    //   165: new 98	gnu/lists/Pair
    //   168: dup
    //   169: aload 9
    //   171: getstatic 132	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
    //   174: invokespecial 404	gnu/lists/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   177: aload 5
    //   179: ifnonnull +9 -> 188
    //   182: dup
    //   183: astore 4
    //   185: goto +10 -> 195
    //   188: aload 5
    //   190: swap
    //   191: dup_x1
    //   192: invokevirtual 408	gnu/lists/Pair:setCdr	(Ljava/lang/Object;)V
    //   195: astore 5
    //   197: goto -135 -> 62
    //   200: getstatic 16	kawa/standard/Scheme:apply	Lgnu/kawa/functions/Apply;
    //   203: getstatic 1919	com/ftsafe/CCIDScheme:Lit255	Lgnu/bytecode/ArrayType;
    //   206: getstatic 52	com/ftsafe/CCIDScheme:Lit1	Lgnu/math/IntNum;
    //   209: invokestatic 1923	com/ftsafe/CCIDScheme:lambda58loop	(Lgnu/math/IntNum;)Ljava/lang/Object;
    //   212: invokestatic 385	gnu/lists/Sequences:getIterator	(Ljava/lang/Object;)Ljava/util/Iterator;
    //   215: astore_3
    //   216: getstatic 132	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
    //   219: astore 4
    //   221: aconst_null
    //   222: astore 5
    //   224: aload_3
    //   225: invokeinterface 391 1 0
    //   230: ifeq +58 -> 288
    //   233: aload_3
    //   234: invokeinterface 395 1 0
    //   239: astore 6
    //   241: new 98	gnu/lists/Pair
    //   244: dup
    //   245: getstatic 336	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   248: getstatic 1734	com/ftsafe/CCIDScheme:GET_DEVICES_INF	Ljava/lang/Object;
    //   251: getstatic 1362	com/ftsafe/CCIDScheme:Lit218	Lgnu/mapping/SimpleSymbol;
    //   254: aload 6
    //   256: invokevirtual 1807	gnu/mapping/Procedure:apply3	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   259: getstatic 132	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
    //   262: invokespecial 404	gnu/lists/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   265: aload 5
    //   267: ifnonnull +9 -> 276
    //   270: dup
    //   271: astore 4
    //   273: goto +10 -> 283
    //   276: aload 5
    //   278: swap
    //   279: dup_x1
    //   280: invokevirtual 408	gnu/lists/Pair:setCdr	(Ljava/lang/Object;)V
    //   283: astore 5
    //   285: goto -61 -> 224
    //   288: aload 4
    //   290: invokevirtual 28	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   293: areturn
    //   294: new 66	gnu/mapping/WrongType
    //   297: dup_x1
    //   298: swap
    //   299: ldc 116
    //   301: iconst_1
    //   302: aload 10
    //   304: invokespecial 71	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   307: athrow
    //   308: new 66	gnu/mapping/WrongType
    //   311: dup_x1
    //   312: swap
    //   313: ldc 103
    //   315: iconst_1
    //   316: aload 10
    //   318: invokespecial 71	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   321: athrow
    // Line number table:
    //   Java source line #88	-> byte code offset #0
    //   Java source line #89	-> byte code offset #13
    //   Java source line #90	-> byte code offset #26
    //   Java source line #91	-> byte code offset #35
    //   Java source line #94	-> byte code offset #41
    //   Java source line #113	-> byte code offset #41
    //   Java source line #95	-> byte code offset #93
    //   Java source line #96	-> byte code offset #115
    //   Java source line #97	-> byte code offset #143
    //   Java source line #98	-> byte code offset #143
    //   Java source line #99	-> byte code offset #143
    //   Java source line #118	-> byte code offset #200
    //   Java source line #119	-> byte code offset #206
    //   Java source line #121	-> byte code offset #206
    //   Java source line #120	-> byte code offset #245
    //   Java source line #95	-> byte code offset #294
    //   Java source line #96	-> byte code offset #308
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	294	0	this	CCIDScheme
    //   0	293	1	device	Object
    //   8	285	2	$heapFrame	frame18
    //   76	124	6	$heapFrame	frame19
    // Exception table:
    //   from	to	target	type
    //   103	106	294	java/lang/ClassCastException
    //   128	131	308	java/lang/ClassCastException
  }
  
  /* Error */
  public Object readerPowerOff(int index)
  {
    // Byte code:
    //   0: new 1954	com/ftsafe/CCIDScheme$frame21
    //   3: dup
    //   4: invokespecial 1955	com/ftsafe/CCIDScheme$frame21:<init>	()V
    //   7: astore_2
    //   8: aload_2
    //   9: iload_1
    //   10: putfield 1956	com/ftsafe/CCIDScheme$frame21:index	I
    //   13: aload_2
    //   14: getfield 1959	com/ftsafe/CCIDScheme$frame21:lambda$Fn43	Lgnu/expr/ModuleMethod;
    //   17: invokestatic 1961	com/ftsafe/CCIDScheme:doPowerOff	(Ljava/lang/Object;)V
    //   20: getstatic 1777	com/ftsafe/CCIDScheme:XfrBlock$Mnhash$Mntable	Ljava/lang/Object;
    //   23: ldc_w 1944
    //   26: invokestatic 101	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   29: dup
    //   30: astore_3
    //   31: checkcast 1944	kawa/lib/kawa/hashtable$HashTable
    //   34: aload_2
    //   35: getfield 1956	com/ftsafe/CCIDScheme$frame21:index	I
    //   38: invokestatic 329	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   41: invokestatic 1967	kawa/lib/rnrs/hashtables:isHashtableContains	(Lkawa/lib/kawa/hashtable$HashTable;Ljava/lang/Object;)Z
    //   44: ifeq +33 -> 77
    //   47: getstatic 1777	com/ftsafe/CCIDScheme:XfrBlock$Mnhash$Mntable	Ljava/lang/Object;
    //   50: ldc_w 1944
    //   53: invokestatic 101	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   56: dup
    //   57: astore_3
    //   58: checkcast 1944	kawa/lib/kawa/hashtable$HashTable
    //   61: aload_2
    //   62: getfield 1956	com/ftsafe/CCIDScheme$frame21:index	I
    //   65: invokestatic 329	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   68: invokestatic 1973	kawa/lib/rnrs/hashtables:hashtableDelete$Ex	(Lkawa/lib/kawa/hashtable$HashTable;Ljava/lang/Object;)V
    //   71: getstatic 529	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   74: goto +6 -> 80
    //   77: getstatic 529	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   80: areturn
    //   81: new 66	gnu/mapping/WrongType
    //   84: dup_x1
    //   85: swap
    //   86: ldc_w 1963
    //   89: iconst_1
    //   90: aload_3
    //   91: invokespecial 71	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   94: athrow
    //   95: new 66	gnu/mapping/WrongType
    //   98: dup_x1
    //   99: swap
    //   100: ldc_w 1969
    //   103: iconst_1
    //   104: aload_3
    //   105: invokespecial 71	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   108: athrow
    // Line number table:
    //   Java source line #146	-> byte code offset #0
    //   Java source line #148	-> byte code offset #13
    //   Java source line #151	-> byte code offset #20
    //   Java source line #152	-> byte code offset #47
    //   Java source line #151	-> byte code offset #81
    //   Java source line #152	-> byte code offset #95
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	81	0	this	CCIDScheme
    //   0	80	1	index	int
    //   7	55	2	$heapFrame	frame21
    //   30	75	3	localObject	Object
    //   81	1	4	localClassCastException1	ClassCastException
    //   95	1	5	localClassCastException2	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   31	34	81	java/lang/ClassCastException
    //   58	61	95	java/lang/ClassCastException
  }
  
  /* Error */
  public Object readerXfrBlock(int index, byte[] data)
  {
    // Byte code:
    //   0: getstatic 1777	com/ftsafe/CCIDScheme:XfrBlock$Mnhash$Mntable	Ljava/lang/Object;
    //   3: ldc_w 1944
    //   6: invokestatic 101	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   9: dup
    //   10: astore_3
    //   11: checkcast 1944	kawa/lib/kawa/hashtable$HashTable
    //   14: iload_1
    //   15: invokestatic 329	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   18: invokestatic 1967	kawa/lib/rnrs/hashtables:isHashtableContains	(Lkawa/lib/kawa/hashtable$HashTable;Ljava/lang/Object;)Z
    //   21: ifeq +52 -> 73
    //   24: getstatic 16	kawa/standard/Scheme:apply	Lgnu/kawa/functions/Apply;
    //   27: getstatic 22	com/ftsafe/CCIDScheme:Lit0	Lgnu/bytecode/ArrayType;
    //   30: getstatic 336	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   33: getstatic 1777	com/ftsafe/CCIDScheme:XfrBlock$Mnhash$Mntable	Ljava/lang/Object;
    //   36: ldc_w 1944
    //   39: invokestatic 101	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   42: dup
    //   43: astore_3
    //   44: checkcast 1944	kawa/lib/kawa/hashtable$HashTable
    //   47: iload_1
    //   48: invokestatic 329	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   51: invokestatic 1979	gnu/kawa/slib/srfi69:hashTableRef	(Lkawa/lib/kawa/hashtable$HashTable;Ljava/lang/Object;)Ljava/lang/Object;
    //   54: getstatic 16	kawa/standard/Scheme:apply	Lgnu/kawa/functions/Apply;
    //   57: getstatic 48	gnu/kawa/lispexpr/LangObjType:listType	Lgnu/kawa/lispexpr/LangObjType;
    //   60: aload_2
    //   61: invokevirtual 28	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   64: invokevirtual 28	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   67: invokevirtual 28	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   70: goto +20 -> 90
    //   73: iconst_1
    //   74: anewarray 76	java/lang/Object
    //   77: dup
    //   78: iconst_0
    //   79: ldc_w 1981
    //   82: aastore
    //   83: invokestatic 181	kawa/lib/exceptions:error	([Ljava/lang/Object;)Lgnu/bytecode/Type$NeverReturns;
    //   86: getstatic 187	gnu/expr/Special:reachedUnexpected	Ljava/lang/RuntimeException;
    //   89: athrow
    //   90: areturn
    //   91: new 66	gnu/mapping/WrongType
    //   94: dup_x1
    //   95: swap
    //   96: ldc_w 1963
    //   99: iconst_1
    //   100: aload_3
    //   101: invokespecial 71	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   104: athrow
    //   105: new 66	gnu/mapping/WrongType
    //   108: dup_x1
    //   109: swap
    //   110: ldc_w 1975
    //   113: iconst_1
    //   114: aload_3
    //   115: invokespecial 71	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   118: athrow
    // Line number table:
    //   Java source line #156	-> byte code offset #0
    //   Java source line #158	-> byte code offset #0
    //   Java source line #159	-> byte code offset #24
    //   Java source line #160	-> byte code offset #30
    //   Java source line #161	-> byte code offset #54
    //   Java source line #162	-> byte code offset #73
    //   Java source line #158	-> byte code offset #91
    //   Java source line #160	-> byte code offset #105
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	91	0	this	CCIDScheme
    //   0	90	1	index	int
    //   0	90	2	data	byte[]
    //   10	105	3	localObject	Object
    //   91	1	4	localClassCastException1	ClassCastException
    //   105	1	5	localClassCastException2	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   11	14	91	java/lang/ClassCastException
    //   44	47	105	java/lang/ClassCastException
  }
  
  public static gnu.lists.U8Vector makeU8vector(Object paramObject)
  {
    return makeU8vector(paramObject, Lit1);
  }
  
  /* Error */
  public static Object slice(Object lst, Object offset, Object length)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 90	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
    //   4: ifeq +7 -> 11
    //   7: aload_0
    //   8: goto +101 -> 109
    //   11: aload_1
    //   12: getstatic 52	com/ftsafe/CCIDScheme:Lit1	Lgnu/math/IntNum;
    //   15: invokestatic 96	gnu/kawa/functions/NumberCompare:$Gr	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   18: ifeq +30 -> 48
    //   21: aload_0
    //   22: ldc 98
    //   24: invokestatic 101	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   27: dup
    //   28: astore_3
    //   29: checkcast 98	gnu/lists/Pair
    //   32: invokestatic 106	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   35: iconst_m1
    //   36: aload_1
    //   37: getstatic 109	com/ftsafe/CCIDScheme:Lit2	Lgnu/math/IntNum;
    //   40: invokestatic 114	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   43: astore_1
    //   44: astore_0
    //   45: goto -45 -> 0
    //   48: aload_2
    //   49: getstatic 52	com/ftsafe/CCIDScheme:Lit1	Lgnu/math/IntNum;
    //   52: invokestatic 96	gnu/kawa/functions/NumberCompare:$Gr	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   55: ifeq +51 -> 106
    //   58: aload_0
    //   59: ldc 98
    //   61: invokestatic 101	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   64: dup
    //   65: astore_3
    //   66: checkcast 98	gnu/lists/Pair
    //   69: invokestatic 118	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   72: aload_0
    //   73: ldc 98
    //   75: invokestatic 101	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   78: dup
    //   79: astore_3
    //   80: checkcast 98	gnu/lists/Pair
    //   83: invokestatic 106	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   86: getstatic 52	com/ftsafe/CCIDScheme:Lit1	Lgnu/math/IntNum;
    //   89: iconst_m1
    //   90: aload_2
    //   91: getstatic 109	com/ftsafe/CCIDScheme:Lit2	Lgnu/math/IntNum;
    //   94: invokestatic 114	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   97: invokestatic 122	com/ftsafe/CCIDScheme:slice	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   100: invokestatic 126	kawa/lib/lists:cons	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   103: goto +6 -> 109
    //   106: getstatic 132	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
    //   109: areturn
    //   110: new 66	gnu/mapping/WrongType
    //   113: dup_x1
    //   114: swap
    //   115: ldc 103
    //   117: iconst_1
    //   118: aload_3
    //   119: invokespecial 71	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   122: athrow
    //   123: new 66	gnu/mapping/WrongType
    //   126: dup_x1
    //   127: swap
    //   128: ldc 116
    //   130: iconst_1
    //   131: aload_3
    //   132: invokespecial 71	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   135: athrow
    //   136: new 66	gnu/mapping/WrongType
    //   139: dup_x1
    //   140: swap
    //   141: ldc 103
    //   143: iconst_1
    //   144: aload_3
    //   145: invokespecial 71	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   148: athrow
    // Line number table:
    //   Java source line #10017	-> byte code offset #0
    //   Java source line #10018	-> byte code offset #0
    //   Java source line #10020	-> byte code offset #11
    //   Java source line #10021	-> byte code offset #21
    //   Java source line #10022	-> byte code offset #48
    //   Java source line #10023	-> byte code offset #58
    //   Java source line #10021	-> byte code offset #110
    //   Java source line #10023	-> byte code offset #123
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	109	0	lst	Object
    //   0	109	1	offset	Object
    //   0	109	2	length	Object
    //   28	117	3	localObject	Object
    //   110	1	4	localClassCastException1	ClassCastException
    //   123	1	5	localClassCastException2	ClassCastException
    //   136	1	6	localClassCastException3	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   29	32	110	java/lang/ClassCastException
    //   66	69	123	java/lang/ClassCastException
    //   80	83	136	java/lang/ClassCastException
  }
  
  public static gnu.mapping.Procedure makeCounter()
  {
    return makeCounter(Lit1, Lit2);
  }
  
  public static gnu.mapping.Procedure makeCounter(Object paramObject)
  {
    return makeCounter(paramObject, Lit2);
  }
  
  /* Error */
  public static Object callWithInputU8vector(Object u8, Object proc)
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc 38
    //   3: invokestatic 101	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   6: dup
    //   7: astore_2
    //   8: invokestatic 294	gnu/kawa/lispexpr/LangObjType:coerceToU8Vector	(Ljava/lang/Object;)Lgnu/lists/U8Vector;
    //   11: invokestatic 300	kawa/lib/ports:openInputBytevector	(Lgnu/lists/U8Vector;)Lgnu/kawa/io/BinaryInPort;
    //   14: aload_1
    //   15: ldc 24
    //   17: invokestatic 101	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   20: dup
    //   21: astore_2
    //   22: checkcast 24	gnu/mapping/Procedure
    //   25: invokestatic 306	kawa/lib/ports:callWithPort	(Ljava/io/Closeable;Lgnu/mapping/Procedure;)Ljava/lang/Object;
    //   28: areturn
    //   29: new 66	gnu/mapping/WrongType
    //   32: dup_x1
    //   33: swap
    //   34: ldc_w 296
    //   37: iconst_1
    //   38: aload_2
    //   39: invokespecial 71	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   42: athrow
    //   43: new 66	gnu/mapping/WrongType
    //   46: dup_x1
    //   47: swap
    //   48: ldc_w 302
    //   51: iconst_2
    //   52: aload_2
    //   53: invokespecial 71	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   56: athrow
    // Line number table:
    //   Java source line #10123	-> byte code offset #0
    //   Java source line #10124	-> byte code offset #0
    //   Java source line #10125	-> byte code offset #0
    //   Java source line #10126	-> byte code offset #14
    //   Java source line #10125	-> byte code offset #29
    //   Java source line #10126	-> byte code offset #43
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	28	0	u8	Object
    //   0	28	1	proc	Object
    //   7	46	2	localObject	Object
    //   29	1	3	localClassCastException1	ClassCastException
    //   43	1	4	localClassCastException2	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   8	11	29	java/lang/ClassCastException
    //   22	25	43	java/lang/ClassCastException
  }
  
  /* Error */
  public static Object filter(Object predicate, Object lst)
  {
    // Byte code:
    //   0: getstatic 132	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
    //   3: aload_1
    //   4: if_acmpne +9 -> 13
    //   7: getstatic 132	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
    //   10: goto +86 -> 96
    //   13: getstatic 336	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   16: aload_0
    //   17: aload_1
    //   18: ldc 98
    //   20: invokestatic 101	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   23: dup
    //   24: astore_2
    //   25: checkcast 98	gnu/lists/Pair
    //   28: invokestatic 118	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   31: invokevirtual 28	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   34: invokestatic 287	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   37: ifeq +41 -> 78
    //   40: aload_1
    //   41: ldc 98
    //   43: invokestatic 101	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   46: dup
    //   47: astore_2
    //   48: checkcast 98	gnu/lists/Pair
    //   51: invokestatic 118	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   54: aload_0
    //   55: aload_1
    //   56: ldc 98
    //   58: invokestatic 101	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   61: dup
    //   62: astore_2
    //   63: checkcast 98	gnu/lists/Pair
    //   66: invokestatic 106	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   69: invokestatic 339	com/ftsafe/CCIDScheme:filter	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   72: invokestatic 126	kawa/lib/lists:cons	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   75: goto +21 -> 96
    //   78: aload_1
    //   79: ldc 98
    //   81: invokestatic 101	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   84: dup
    //   85: astore_2
    //   86: checkcast 98	gnu/lists/Pair
    //   89: invokestatic 106	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   92: astore_1
    //   93: goto -93 -> 0
    //   96: areturn
    //   97: new 66	gnu/mapping/WrongType
    //   100: dup_x1
    //   101: swap
    //   102: ldc 116
    //   104: iconst_1
    //   105: aload_2
    //   106: invokespecial 71	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   109: athrow
    //   110: new 66	gnu/mapping/WrongType
    //   113: dup_x1
    //   114: swap
    //   115: ldc 116
    //   117: iconst_1
    //   118: aload_2
    //   119: invokespecial 71	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   122: athrow
    //   123: new 66	gnu/mapping/WrongType
    //   126: dup_x1
    //   127: swap
    //   128: ldc 103
    //   130: iconst_1
    //   131: aload_2
    //   132: invokespecial 71	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   135: athrow
    //   136: new 66	gnu/mapping/WrongType
    //   139: dup_x1
    //   140: swap
    //   141: ldc 103
    //   143: iconst_1
    //   144: aload_2
    //   145: invokespecial 71	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   148: athrow
    // Line number table:
    //   Java source line #10151	-> byte code offset #0
    //   Java source line #10152	-> byte code offset #0
    //   Java source line #10154	-> byte code offset #13
    //   Java source line #10155	-> byte code offset #40
    //   Java source line #10156	-> byte code offset #78
    //   Java source line #10154	-> byte code offset #97
    //   Java source line #10155	-> byte code offset #110
    //   Java source line #10156	-> byte code offset #136
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	96	0	predicate	Object
    //   0	96	1	lst	Object
    // Exception table:
    //   from	to	target	type
    //   25	28	97	java/lang/ClassCastException
    //   48	51	110	java/lang/ClassCastException
    //   63	66	123	java/lang/ClassCastException
    //   86	89	136	java/lang/ClassCastException
  }
  
  /* Error */
  public static Object listXor(Object l)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 90	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
    //   4: ifeq +9 -> 13
    //   7: getstatic 52	com/ftsafe/CCIDScheme:Lit1	Lgnu/math/IntNum;
    //   10: goto +40 -> 50
    //   13: getstatic 351	gnu/kawa/functions/BitwiseOp:xor	Lgnu/kawa/functions/BitwiseOp;
    //   16: aload_0
    //   17: ldc 98
    //   19: invokestatic 101	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   22: dup
    //   23: astore_1
    //   24: checkcast 98	gnu/lists/Pair
    //   27: invokestatic 118	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   30: aload_0
    //   31: ldc 98
    //   33: invokestatic 101	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   36: dup
    //   37: astore_1
    //   38: checkcast 98	gnu/lists/Pair
    //   41: invokestatic 106	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   44: invokestatic 354	com/ftsafe/CCIDScheme:listXor	(Ljava/lang/Object;)Ljava/lang/Object;
    //   47: invokevirtual 28	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   50: areturn
    //   51: new 66	gnu/mapping/WrongType
    //   54: dup_x1
    //   55: swap
    //   56: ldc 116
    //   58: iconst_1
    //   59: aload_1
    //   60: invokespecial 71	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   63: athrow
    //   64: new 66	gnu/mapping/WrongType
    //   67: dup_x1
    //   68: swap
    //   69: ldc 103
    //   71: iconst_1
    //   72: aload_1
    //   73: invokespecial 71	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   76: athrow
    // Line number table:
    //   Java source line #10168	-> byte code offset #0
    //   Java source line #10169	-> byte code offset #0
    //   Java source line #10170	-> byte code offset #13
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	50	0	l	Object
    //   23	50	1	localObject	Object
    //   51	1	2	localClassCastException1	ClassCastException
    //   64	1	3	localClassCastException2	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   24	27	51	java/lang/ClassCastException
    //   38	41	64	java/lang/ClassCastException
  }
  
  public static CharSequence toHexStr(Object paramObject)
  {
    return toHexStr(paramObject, Lit16);
  }
  
  /* Error */
  public static CharSequence toHexStr(Object number, Object len)
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc 58
    //   3: invokestatic 101	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   6: dup
    //   7: astore_3
    //   8: checkcast 58	java/lang/Number
    //   11: bipush 16
    //   13: invokestatic 369	kawa/lib/numbers:number$To$String	(Ljava/lang/Number;I)Ljava/lang/CharSequence;
    //   16: astore_2
    //   17: aload_2
    //   18: invokestatic 375	kawa/lib/strings:stringLength	(Ljava/lang/CharSequence;)I
    //   21: invokestatic 329	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   24: aload_1
    //   25: invokestatic 96	gnu/kawa/functions/NumberCompare:$Gr	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   28: ifeq +7 -> 35
    //   31: aload_2
    //   32: goto +119 -> 151
    //   35: iconst_2
    //   36: anewarray 76	java/lang/Object
    //   39: dup
    //   40: iconst_0
    //   41: iconst_m1
    //   42: aload_1
    //   43: aload_2
    //   44: invokestatic 375	kawa/lib/strings:stringLength	(Ljava/lang/CharSequence;)I
    //   47: invokestatic 329	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   50: invokestatic 114	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   53: getstatic 378	com/ftsafe/CCIDScheme:Lit17	Lgnu/math/IntNum;
    //   56: invokestatic 56	com/ftsafe/CCIDScheme:makeU8vector	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/U8Vector;
    //   59: invokestatic 381	com/ftsafe/CCIDScheme:u8vector$To$List	(Ljava/lang/Object;)Ljava/lang/Object;
    //   62: invokestatic 385	gnu/lists/Sequences:getIterator	(Ljava/lang/Object;)Ljava/util/Iterator;
    //   65: astore_3
    //   66: getstatic 132	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
    //   69: astore 4
    //   71: aconst_null
    //   72: astore 5
    //   74: aload_3
    //   75: invokeinterface 391 1 0
    //   80: ifeq +58 -> 138
    //   83: aload_3
    //   84: invokeinterface 395 1 0
    //   89: astore 6
    //   91: new 98	gnu/lists/Pair
    //   94: dup
    //   95: aload 6
    //   97: invokestatic 34	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   100: checkcast 58	java/lang/Number
    //   103: invokevirtual 62	java/lang/Number:intValue	()I
    //   106: invokestatic 401	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   109: getstatic 132	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
    //   112: invokespecial 404	gnu/lists/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   115: aload 5
    //   117: ifnonnull +9 -> 126
    //   120: dup
    //   121: astore 4
    //   123: goto +10 -> 133
    //   126: aload 5
    //   128: swap
    //   129: dup_x1
    //   130: invokevirtual 408	gnu/lists/Pair:setCdr	(Ljava/lang/Object;)V
    //   133: astore 5
    //   135: goto -61 -> 74
    //   138: aload 4
    //   140: invokestatic 412	kawa/lib/strings:list$To$String	(Lgnu/lists/LList;)Ljava/lang/CharSequence;
    //   143: aastore
    //   144: dup
    //   145: iconst_1
    //   146: aload_2
    //   147: aastore
    //   148: invokestatic 416	kawa/lib/strings:stringAppend	([Ljava/lang/Object;)Lgnu/lists/FString;
    //   151: areturn
    //   152: new 66	gnu/mapping/WrongType
    //   155: dup_x1
    //   156: swap
    //   157: ldc_w 363
    //   160: iconst_1
    //   161: aload_3
    //   162: invokespecial 71	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   165: athrow
    // Line number table:
    //   Java source line #10174	-> byte code offset #0
    //   Java source line #10175	-> byte code offset #0
    //   Java source line #10176	-> byte code offset #17
    //   Java source line #10177	-> byte code offset #35
    //   Java source line #10179	-> byte code offset #41
    //   Java source line #10180	-> byte code offset #41
    //   Java source line #10181	-> byte code offset #41
    //   Java source line #10182	-> byte code offset #41
    //   Java source line #10183	-> byte code offset #53
    //   Java source line #10175	-> byte code offset #152
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	151	0	number	Object
    //   0	151	1	len	Object
    //   17	134	2	s	CharSequence
    // Exception table:
    //   from	to	target	type
    //   8	11	152	java/lang/ClassCastException
  }
  
  public static CharSequence toOctStr(Object paramObject)
  {
    return toOctStr(paramObject, Lit18);
  }
  
  /* Error */
  public static CharSequence toOctStr(Object number, Object len)
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc 58
    //   3: invokestatic 101	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   6: dup
    //   7: astore_3
    //   8: checkcast 58	java/lang/Number
    //   11: bipush 8
    //   13: invokestatic 369	kawa/lib/numbers:number$To$String	(Ljava/lang/Number;I)Ljava/lang/CharSequence;
    //   16: astore_2
    //   17: aload_2
    //   18: invokestatic 375	kawa/lib/strings:stringLength	(Ljava/lang/CharSequence;)I
    //   21: invokestatic 329	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   24: aload_1
    //   25: invokestatic 96	gnu/kawa/functions/NumberCompare:$Gr	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   28: ifeq +7 -> 35
    //   31: aload_2
    //   32: goto +119 -> 151
    //   35: iconst_2
    //   36: anewarray 76	java/lang/Object
    //   39: dup
    //   40: iconst_0
    //   41: iconst_m1
    //   42: aload_1
    //   43: aload_2
    //   44: invokestatic 375	kawa/lib/strings:stringLength	(Ljava/lang/CharSequence;)I
    //   47: invokestatic 329	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   50: invokestatic 114	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   53: getstatic 378	com/ftsafe/CCIDScheme:Lit17	Lgnu/math/IntNum;
    //   56: invokestatic 56	com/ftsafe/CCIDScheme:makeU8vector	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/U8Vector;
    //   59: invokestatic 381	com/ftsafe/CCIDScheme:u8vector$To$List	(Ljava/lang/Object;)Ljava/lang/Object;
    //   62: invokestatic 385	gnu/lists/Sequences:getIterator	(Ljava/lang/Object;)Ljava/util/Iterator;
    //   65: astore_3
    //   66: getstatic 132	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
    //   69: astore 4
    //   71: aconst_null
    //   72: astore 5
    //   74: aload_3
    //   75: invokeinterface 391 1 0
    //   80: ifeq +58 -> 138
    //   83: aload_3
    //   84: invokeinterface 395 1 0
    //   89: astore 6
    //   91: new 98	gnu/lists/Pair
    //   94: dup
    //   95: aload 6
    //   97: invokestatic 34	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   100: checkcast 58	java/lang/Number
    //   103: invokevirtual 62	java/lang/Number:intValue	()I
    //   106: invokestatic 401	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   109: getstatic 132	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
    //   112: invokespecial 404	gnu/lists/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   115: aload 5
    //   117: ifnonnull +9 -> 126
    //   120: dup
    //   121: astore 4
    //   123: goto +10 -> 133
    //   126: aload 5
    //   128: swap
    //   129: dup_x1
    //   130: invokevirtual 408	gnu/lists/Pair:setCdr	(Ljava/lang/Object;)V
    //   133: astore 5
    //   135: goto -61 -> 74
    //   138: aload 4
    //   140: invokestatic 412	kawa/lib/strings:list$To$String	(Lgnu/lists/LList;)Ljava/lang/CharSequence;
    //   143: aastore
    //   144: dup
    //   145: iconst_1
    //   146: aload_2
    //   147: aastore
    //   148: invokestatic 416	kawa/lib/strings:stringAppend	([Ljava/lang/Object;)Lgnu/lists/FString;
    //   151: areturn
    //   152: new 66	gnu/mapping/WrongType
    //   155: dup_x1
    //   156: swap
    //   157: ldc_w 363
    //   160: iconst_1
    //   161: aload_3
    //   162: invokespecial 71	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   165: athrow
    // Line number table:
    //   Java source line #10186	-> byte code offset #0
    //   Java source line #10187	-> byte code offset #0
    //   Java source line #10188	-> byte code offset #17
    //   Java source line #10189	-> byte code offset #35
    //   Java source line #10191	-> byte code offset #41
    //   Java source line #10192	-> byte code offset #41
    //   Java source line #10193	-> byte code offset #41
    //   Java source line #10194	-> byte code offset #41
    //   Java source line #10195	-> byte code offset #53
    //   Java source line #10187	-> byte code offset #152
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	151	0	number	Object
    //   0	151	1	len	Object
    //   17	134	2	s	CharSequence
    // Exception table:
    //   from	to	target	type
    //   8	11	152	java/lang/ClassCastException
  }
  
  public static CharSequence toBinStr(Object paramObject)
  {
    return toBinStr(paramObject, Lit7);
  }
  
  /* Error */
  public static CharSequence toBinStr(Object number, Object len)
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc 58
    //   3: invokestatic 101	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   6: dup
    //   7: astore_3
    //   8: checkcast 58	java/lang/Number
    //   11: iconst_2
    //   12: invokestatic 369	kawa/lib/numbers:number$To$String	(Ljava/lang/Number;I)Ljava/lang/CharSequence;
    //   15: astore_2
    //   16: aload_2
    //   17: invokestatic 375	kawa/lib/strings:stringLength	(Ljava/lang/CharSequence;)I
    //   20: invokestatic 329	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   23: aload_1
    //   24: invokestatic 96	gnu/kawa/functions/NumberCompare:$Gr	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   27: ifeq +7 -> 34
    //   30: aload_2
    //   31: goto +119 -> 150
    //   34: iconst_2
    //   35: anewarray 76	java/lang/Object
    //   38: dup
    //   39: iconst_0
    //   40: iconst_m1
    //   41: aload_1
    //   42: aload_2
    //   43: invokestatic 375	kawa/lib/strings:stringLength	(Ljava/lang/CharSequence;)I
    //   46: invokestatic 329	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   49: invokestatic 114	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   52: getstatic 378	com/ftsafe/CCIDScheme:Lit17	Lgnu/math/IntNum;
    //   55: invokestatic 56	com/ftsafe/CCIDScheme:makeU8vector	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/U8Vector;
    //   58: invokestatic 381	com/ftsafe/CCIDScheme:u8vector$To$List	(Ljava/lang/Object;)Ljava/lang/Object;
    //   61: invokestatic 385	gnu/lists/Sequences:getIterator	(Ljava/lang/Object;)Ljava/util/Iterator;
    //   64: astore_3
    //   65: getstatic 132	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
    //   68: astore 4
    //   70: aconst_null
    //   71: astore 5
    //   73: aload_3
    //   74: invokeinterface 391 1 0
    //   79: ifeq +58 -> 137
    //   82: aload_3
    //   83: invokeinterface 395 1 0
    //   88: astore 6
    //   90: new 98	gnu/lists/Pair
    //   93: dup
    //   94: aload 6
    //   96: invokestatic 34	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   99: checkcast 58	java/lang/Number
    //   102: invokevirtual 62	java/lang/Number:intValue	()I
    //   105: invokestatic 401	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   108: getstatic 132	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
    //   111: invokespecial 404	gnu/lists/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   114: aload 5
    //   116: ifnonnull +9 -> 125
    //   119: dup
    //   120: astore 4
    //   122: goto +10 -> 132
    //   125: aload 5
    //   127: swap
    //   128: dup_x1
    //   129: invokevirtual 408	gnu/lists/Pair:setCdr	(Ljava/lang/Object;)V
    //   132: astore 5
    //   134: goto -61 -> 73
    //   137: aload 4
    //   139: invokestatic 412	kawa/lib/strings:list$To$String	(Lgnu/lists/LList;)Ljava/lang/CharSequence;
    //   142: aastore
    //   143: dup
    //   144: iconst_1
    //   145: aload_2
    //   146: aastore
    //   147: invokestatic 416	kawa/lib/strings:stringAppend	([Ljava/lang/Object;)Lgnu/lists/FString;
    //   150: areturn
    //   151: new 66	gnu/mapping/WrongType
    //   154: dup_x1
    //   155: swap
    //   156: ldc_w 363
    //   159: iconst_1
    //   160: aload_3
    //   161: invokespecial 71	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   164: athrow
    // Line number table:
    //   Java source line #10198	-> byte code offset #0
    //   Java source line #10199	-> byte code offset #0
    //   Java source line #10200	-> byte code offset #16
    //   Java source line #10201	-> byte code offset #34
    //   Java source line #10203	-> byte code offset #40
    //   Java source line #10204	-> byte code offset #40
    //   Java source line #10205	-> byte code offset #40
    //   Java source line #10206	-> byte code offset #40
    //   Java source line #10207	-> byte code offset #52
    //   Java source line #10199	-> byte code offset #151
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	150	0	number	Object
    //   0	150	1	len	Object
    //   16	134	2	s	CharSequence
    // Exception table:
    //   from	to	target	type
    //   8	11	151	java/lang/ClassCastException
  }
  
  public static Object u8list$To$String(Object paramObject)
  {
    return u8list$To$String(paramObject, "");
  }
  
  /* Error */
  public static Object u8list$To$String(Object _l, Object fixed)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 90	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
    //   4: ifeq +9 -> 13
    //   7: ldc_w 427
    //   10: goto +81 -> 91
    //   13: iconst_3
    //   14: anewarray 76	java/lang/Object
    //   17: dup
    //   18: iconst_0
    //   19: aload_0
    //   20: ldc 98
    //   22: invokestatic 101	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   25: dup
    //   26: astore_2
    //   27: checkcast 98	gnu/lists/Pair
    //   30: invokestatic 118	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   33: invokestatic 433	com/ftsafe/CCIDScheme:toHexStr	(Ljava/lang/Object;)Ljava/lang/CharSequence;
    //   36: aastore
    //   37: dup
    //   38: iconst_1
    //   39: aload_0
    //   40: ldc 98
    //   42: invokestatic 101	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   45: dup
    //   46: astore_2
    //   47: checkcast 98	gnu/lists/Pair
    //   50: invokestatic 106	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   53: invokestatic 90	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
    //   56: ifeq +9 -> 65
    //   59: ldc_w 427
    //   62: goto +4 -> 66
    //   65: aload_1
    //   66: aastore
    //   67: dup
    //   68: iconst_2
    //   69: aload_0
    //   70: ldc 98
    //   72: invokestatic 101	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   75: dup
    //   76: astore_2
    //   77: checkcast 98	gnu/lists/Pair
    //   80: invokestatic 106	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   83: aload_1
    //   84: invokestatic 430	com/ftsafe/CCIDScheme:u8list$To$String	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   87: aastore
    //   88: invokestatic 416	kawa/lib/strings:stringAppend	([Ljava/lang/Object;)Lgnu/lists/FString;
    //   91: areturn
    //   92: new 66	gnu/mapping/WrongType
    //   95: dup_x1
    //   96: swap
    //   97: ldc 116
    //   99: iconst_1
    //   100: aload_2
    //   101: invokespecial 71	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   104: athrow
    //   105: new 66	gnu/mapping/WrongType
    //   108: dup_x1
    //   109: swap
    //   110: ldc 103
    //   112: iconst_1
    //   113: aload_2
    //   114: invokespecial 71	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   117: athrow
    //   118: new 66	gnu/mapping/WrongType
    //   121: dup_x1
    //   122: swap
    //   123: ldc 103
    //   125: iconst_1
    //   126: aload_2
    //   127: invokespecial 71	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   130: athrow
    // Line number table:
    //   Java source line #10211	-> byte code offset #0
    //   Java source line #10212	-> byte code offset #0
    //   Java source line #10213	-> byte code offset #13
    //   Java source line #10214	-> byte code offset #19
    //   Java source line #10215	-> byte code offset #39
    //   Java source line #10216	-> byte code offset #69
    //   Java source line #10214	-> byte code offset #92
    //   Java source line #10215	-> byte code offset #105
    //   Java source line #10216	-> byte code offset #118
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	91	0	_l	Object
    //   0	91	1	fixed	Object
    //   26	101	2	localObject	Object
    //   92	1	3	localClassCastException1	ClassCastException
    //   105	1	4	localClassCastException2	ClassCastException
    //   118	1	5	localClassCastException3	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   27	30	92	java/lang/ClassCastException
    //   47	50	105	java/lang/ClassCastException
    //   77	80	118	java/lang/ClassCastException
  }
  
  /* Error */
  public static Object isInList(Object n, Object lst)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 90	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
    //   4: ifeq +9 -> 13
    //   7: getstatic 247	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   10: goto +52 -> 62
    //   13: getstatic 276	kawa/standard/Scheme:isEqual	Lgnu/kawa/functions/IsEqual;
    //   16: aload_0
    //   17: aload_1
    //   18: ldc 98
    //   20: invokestatic 101	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   23: dup
    //   24: astore_2
    //   25: checkcast 98	gnu/lists/Pair
    //   28: invokestatic 118	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   31: invokevirtual 28	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   34: invokestatic 287	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   37: ifeq +7 -> 44
    //   40: aload_0
    //   41: goto +21 -> 62
    //   44: aload_1
    //   45: ldc 98
    //   47: invokestatic 101	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   50: dup
    //   51: astore_2
    //   52: checkcast 98	gnu/lists/Pair
    //   55: invokestatic 106	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   58: astore_1
    //   59: goto -59 -> 0
    //   62: areturn
    //   63: new 66	gnu/mapping/WrongType
    //   66: dup_x1
    //   67: swap
    //   68: ldc 116
    //   70: iconst_1
    //   71: aload_2
    //   72: invokespecial 71	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   75: athrow
    //   76: new 66	gnu/mapping/WrongType
    //   79: dup_x1
    //   80: swap
    //   81: ldc 103
    //   83: iconst_1
    //   84: aload_2
    //   85: invokespecial 71	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   88: athrow
    // Line number table:
    //   Java source line #10219	-> byte code offset #0
    //   Java source line #10220	-> byte code offset #0
    //   Java source line #10222	-> byte code offset #13
    //   Java source line #10224	-> byte code offset #44
    //   Java source line #10222	-> byte code offset #63
    //   Java source line #10224	-> byte code offset #76
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	62	0	n	Object
    //   0	62	1	lst	Object
    // Exception table:
    //   from	to	target	type
    //   25	28	63	java/lang/ClassCastException
    //   52	55	76	java/lang/ClassCastException
  }
  
  /* Error */
  public static gnu.lists.LList byte$To$Bit(Object byte)
  {
    // Byte code:
    //   0: getstatic 437	com/ftsafe/CCIDScheme:Lit19	Lgnu/lists/PairWithPosition;
    //   3: astore_1
    //   4: getstatic 132	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
    //   7: astore_2
    //   8: aconst_null
    //   9: astore_3
    //   10: aload_1
    //   11: getstatic 132	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
    //   14: if_acmpeq +65 -> 79
    //   17: aload_1
    //   18: ldc 98
    //   20: invokestatic 101	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   23: checkcast 98	gnu/lists/Pair
    //   26: astore 4
    //   28: aload 4
    //   30: invokevirtual 440	gnu/lists/Pair:getCar	()Ljava/lang/Object;
    //   33: astore 5
    //   35: new 98	gnu/lists/Pair
    //   38: dup
    //   39: getstatic 445	gnu/kawa/slib/srfi60:bit$Mnset$Qu	Lgnu/mapping/Procedure;
    //   42: aload 5
    //   44: aload_0
    //   45: invokevirtual 28	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   48: getstatic 132	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
    //   51: invokespecial 404	gnu/lists/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   54: aload_3
    //   55: ifnonnull +8 -> 63
    //   58: dup
    //   59: astore_2
    //   60: goto +9 -> 69
    //   63: aload_3
    //   64: swap
    //   65: dup_x1
    //   66: invokevirtual 408	gnu/lists/Pair:setCdr	(Ljava/lang/Object;)V
    //   69: astore_3
    //   70: aload 4
    //   72: invokevirtual 448	gnu/lists/Pair:getCdr	()Ljava/lang/Object;
    //   75: astore_1
    //   76: goto -66 -> 10
    //   79: aload_2
    //   80: areturn
    // Line number table:
    //   Java source line #10228	-> byte code offset #0
    //   Java source line #10229	-> byte code offset #0
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	80	0	byte	Object
  }
  
  /* Error */
  public static Object listRemoveDuplication(Object lst)
  {
    // Byte code:
    //   0: new 450	com/ftsafe/CCIDScheme$frame2
    //   3: dup
    //   4: invokespecial 451	com/ftsafe/CCIDScheme$frame2:<init>	()V
    //   7: astore_1
    //   8: aload_1
    //   9: aload_0
    //   10: putfield 454	com/ftsafe/CCIDScheme$frame2:lst	Ljava/lang/Object;
    //   13: aload_1
    //   14: getfield 454	com/ftsafe/CCIDScheme$frame2:lst	Ljava/lang/Object;
    //   17: invokestatic 90	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
    //   20: ifne +53 -> 73
    //   23: aload_1
    //   24: getfield 454	com/ftsafe/CCIDScheme$frame2:lst	Ljava/lang/Object;
    //   27: ldc 98
    //   29: invokestatic 101	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   32: dup
    //   33: astore_2
    //   34: checkcast 98	gnu/lists/Pair
    //   37: invokestatic 118	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   40: aload_1
    //   41: getfield 457	com/ftsafe/CCIDScheme$frame2:lambda$Fn4	Lgnu/expr/ModuleMethod;
    //   44: aload_1
    //   45: getfield 454	com/ftsafe/CCIDScheme$frame2:lst	Ljava/lang/Object;
    //   48: ldc 98
    //   50: invokestatic 101	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   53: dup
    //   54: astore_2
    //   55: checkcast 98	gnu/lists/Pair
    //   58: invokestatic 106	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   61: invokestatic 339	com/ftsafe/CCIDScheme:filter	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   64: invokestatic 460	com/ftsafe/CCIDScheme:listRemoveDuplication	(Ljava/lang/Object;)Ljava/lang/Object;
    //   67: invokestatic 126	kawa/lib/lists:cons	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   70: goto +6 -> 76
    //   73: getstatic 132	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
    //   76: areturn
    //   77: new 66	gnu/mapping/WrongType
    //   80: dup_x1
    //   81: swap
    //   82: ldc 116
    //   84: iconst_1
    //   85: aload_2
    //   86: invokespecial 71	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   89: athrow
    //   90: new 66	gnu/mapping/WrongType
    //   93: dup_x1
    //   94: swap
    //   95: ldc 103
    //   97: iconst_1
    //   98: aload_2
    //   99: invokespecial 71	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   102: athrow
    // Line number table:
    //   Java source line #10234	-> byte code offset #0
    //   Java source line #10235	-> byte code offset #13
    //   Java source line #10236	-> byte code offset #23
    //   Java source line #10237	-> byte code offset #40
    //   Java source line #10236	-> byte code offset #77
    //   Java source line #10237	-> byte code offset #90
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	76	0	lst	Object
    //   7	38	1	$heapFrame	frame2
    //   33	66	2	localObject	Object
    //   77	1	3	localClassCastException1	ClassCastException
    //   90	1	4	localClassCastException2	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   34	37	77	java/lang/ClassCastException
    //   55	58	90	java/lang/ClassCastException
  }
  
  public static Object stringlst$To$String(Object paramObject)
  {
    return stringlst$To$String(paramObject, "");
  }
  
  /* Error */
  public static Object stringlst$To$String(Object lst, Object fixed)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 90	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
    //   4: ifeq +9 -> 13
    //   7: ldc_w 427
    //   10: goto +78 -> 88
    //   13: iconst_3
    //   14: anewarray 76	java/lang/Object
    //   17: dup
    //   18: iconst_0
    //   19: aload_0
    //   20: ldc 98
    //   22: invokestatic 101	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   25: dup
    //   26: astore_2
    //   27: checkcast 98	gnu/lists/Pair
    //   30: invokestatic 118	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   33: aastore
    //   34: dup
    //   35: iconst_1
    //   36: aload_0
    //   37: ldc 98
    //   39: invokestatic 101	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   42: dup
    //   43: astore_2
    //   44: checkcast 98	gnu/lists/Pair
    //   47: invokestatic 106	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   50: invokestatic 90	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
    //   53: ifeq +9 -> 62
    //   56: ldc_w 427
    //   59: goto +4 -> 63
    //   62: aload_1
    //   63: aastore
    //   64: dup
    //   65: iconst_2
    //   66: aload_0
    //   67: ldc 98
    //   69: invokestatic 101	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   72: dup
    //   73: astore_2
    //   74: checkcast 98	gnu/lists/Pair
    //   77: invokestatic 106	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   80: aload_1
    //   81: invokestatic 463	com/ftsafe/CCIDScheme:stringlst$To$String	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   84: aastore
    //   85: invokestatic 416	kawa/lib/strings:stringAppend	([Ljava/lang/Object;)Lgnu/lists/FString;
    //   88: areturn
    //   89: new 66	gnu/mapping/WrongType
    //   92: dup_x1
    //   93: swap
    //   94: ldc 116
    //   96: iconst_1
    //   97: aload_2
    //   98: invokespecial 71	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   101: athrow
    //   102: new 66	gnu/mapping/WrongType
    //   105: dup_x1
    //   106: swap
    //   107: ldc 103
    //   109: iconst_1
    //   110: aload_2
    //   111: invokespecial 71	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   114: athrow
    //   115: new 66	gnu/mapping/WrongType
    //   118: dup_x1
    //   119: swap
    //   120: ldc 103
    //   122: iconst_1
    //   123: aload_2
    //   124: invokespecial 71	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   127: athrow
    // Line number table:
    //   Java source line #10246	-> byte code offset #0
    //   Java source line #10247	-> byte code offset #0
    //   Java source line #10248	-> byte code offset #13
    //   Java source line #10249	-> byte code offset #19
    //   Java source line #10250	-> byte code offset #36
    //   Java source line #10251	-> byte code offset #66
    //   Java source line #10249	-> byte code offset #89
    //   Java source line #10250	-> byte code offset #102
    //   Java source line #10251	-> byte code offset #115
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	88	0	lst	Object
    //   0	88	1	fixed	Object
    //   26	98	2	localObject	Object
    //   89	1	3	localClassCastException1	ClassCastException
    //   102	1	4	localClassCastException2	ClassCastException
    //   115	1	5	localClassCastException3	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   27	30	89	java/lang/ClassCastException
    //   44	47	102	java/lang/ClassCastException
    //   74	77	115	java/lang/ClassCastException
  }
  
  /* Error */
  public static Object alist$To$List(Object alst)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 90	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
    //   4: ifeq +9 -> 13
    //   7: getstatic 132	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
    //   10: goto +47 -> 57
    //   13: iconst_2
    //   14: anewarray 76	java/lang/Object
    //   17: dup
    //   18: iconst_0
    //   19: aload_0
    //   20: ldc 98
    //   22: invokestatic 101	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   25: dup
    //   26: astore_1
    //   27: checkcast 98	gnu/lists/Pair
    //   30: invokestatic 118	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   33: aastore
    //   34: dup
    //   35: iconst_1
    //   36: aload_0
    //   37: ldc 98
    //   39: invokestatic 101	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   42: dup
    //   43: astore_1
    //   44: checkcast 98	gnu/lists/Pair
    //   47: invokestatic 106	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   50: invokestatic 466	com/ftsafe/CCIDScheme:alist$To$List	(Ljava/lang/Object;)Ljava/lang/Object;
    //   53: aastore
    //   54: invokestatic 267	kawa/standard/append:append$V	([Ljava/lang/Object;)Ljava/lang/Object;
    //   57: areturn
    //   58: new 66	gnu/mapping/WrongType
    //   61: dup_x1
    //   62: swap
    //   63: ldc 116
    //   65: iconst_1
    //   66: aload_1
    //   67: invokespecial 71	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   70: athrow
    //   71: new 66	gnu/mapping/WrongType
    //   74: dup_x1
    //   75: swap
    //   76: ldc 103
    //   78: iconst_1
    //   79: aload_1
    //   80: invokespecial 71	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   83: athrow
    // Line number table:
    //   Java source line #10253	-> byte code offset #0
    //   Java source line #10254	-> byte code offset #0
    //   Java source line #10256	-> byte code offset #13
    //   Java source line #10257	-> byte code offset #36
    //   Java source line #10256	-> byte code offset #58
    //   Java source line #10257	-> byte code offset #71
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	57	0	alst	Object
    //   26	54	1	localObject	Object
    //   58	1	2	localClassCastException1	ClassCastException
    //   71	1	3	localClassCastException2	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   27	30	58	java/lang/ClassCastException
    //   44	47	71	java/lang/ClassCastException
  }
  
  /* Error */
  public static CharSequence getStringDescriptor(Object usb_control_in, Object index)
  {
    // Byte code:
    //   0: getstatic 336	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   3: bipush 6
    //   5: anewarray 76	java/lang/Object
    //   8: dup
    //   9: iconst_0
    //   10: aload_0
    //   11: aastore
    //   12: dup
    //   13: iconst_1
    //   14: getstatic 469	com/ftsafe/CCIDScheme:Lit20	Lgnu/math/IntNum;
    //   17: aastore
    //   18: dup
    //   19: iconst_2
    //   20: getstatic 472	com/ftsafe/CCIDScheme:Lit21	Lgnu/math/IntNum;
    //   23: aastore
    //   24: dup
    //   25: iconst_3
    //   26: getstatic 152	gnu/kawa/functions/BitwiseOp:ior	Lgnu/kawa/functions/BitwiseOp;
    //   29: getstatic 485	com/ftsafe/CCIDScheme:Lit23	Lgnu/math/IntNum;
    //   32: aload_1
    //   33: invokevirtual 28	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   36: aastore
    //   37: dup
    //   38: iconst_4
    //   39: getstatic 488	com/ftsafe/CCIDScheme:Lit24	Lgnu/math/IntNum;
    //   42: aastore
    //   43: dup
    //   44: iconst_5
    //   45: getstatic 419	com/ftsafe/CCIDScheme:Lit18	Lgnu/math/IntNum;
    //   48: aastore
    //   49: invokevirtual 478	gnu/mapping/Procedure:applyN	([Ljava/lang/Object;)Ljava/lang/Object;
    //   52: ldc 98
    //   54: invokestatic 101	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   57: dup
    //   58: astore_3
    //   59: checkcast 98	gnu/lists/Pair
    //   62: invokestatic 118	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   65: astore_2
    //   66: getstatic 336	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   69: bipush 6
    //   71: anewarray 76	java/lang/Object
    //   74: dup
    //   75: iconst_0
    //   76: aload_0
    //   77: aastore
    //   78: dup
    //   79: iconst_1
    //   80: getstatic 469	com/ftsafe/CCIDScheme:Lit20	Lgnu/math/IntNum;
    //   83: aastore
    //   84: dup
    //   85: iconst_2
    //   86: getstatic 472	com/ftsafe/CCIDScheme:Lit21	Lgnu/math/IntNum;
    //   89: aastore
    //   90: dup
    //   91: iconst_3
    //   92: getstatic 152	gnu/kawa/functions/BitwiseOp:ior	Lgnu/kawa/functions/BitwiseOp;
    //   95: getstatic 485	com/ftsafe/CCIDScheme:Lit23	Lgnu/math/IntNum;
    //   98: aload_1
    //   99: invokevirtual 28	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   102: aastore
    //   103: dup
    //   104: iconst_4
    //   105: getstatic 488	com/ftsafe/CCIDScheme:Lit24	Lgnu/math/IntNum;
    //   108: aastore
    //   109: dup
    //   110: iconst_5
    //   111: aload_2
    //   112: aastore
    //   113: invokevirtual 478	gnu/mapping/Procedure:applyN	([Ljava/lang/Object;)Ljava/lang/Object;
    //   116: getstatic 357	com/ftsafe/CCIDScheme:Lit16	Lgnu/math/IntNum;
    //   119: iconst_m1
    //   120: aload_2
    //   121: getstatic 357	com/ftsafe/CCIDScheme:Lit16	Lgnu/math/IntNum;
    //   124: invokestatic 114	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   127: invokestatic 122	com/ftsafe/CCIDScheme:slice	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   130: getstatic 357	com/ftsafe/CCIDScheme:Lit16	Lgnu/math/IntNum;
    //   133: invokestatic 332	com/ftsafe/CCIDScheme:groupList	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   136: invokestatic 385	gnu/lists/Sequences:getIterator	(Ljava/lang/Object;)Ljava/util/Iterator;
    //   139: astore_3
    //   140: getstatic 132	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
    //   143: astore 4
    //   145: aconst_null
    //   146: astore 5
    //   148: aload_3
    //   149: invokeinterface 391 1 0
    //   154: ifeq +72 -> 226
    //   157: aload_3
    //   158: invokeinterface 395 1 0
    //   163: astore 6
    //   165: new 98	gnu/lists/Pair
    //   168: dup
    //   169: aload 6
    //   171: ldc 98
    //   173: invokestatic 101	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   176: dup
    //   177: astore 8
    //   179: checkcast 98	gnu/lists/Pair
    //   182: invokestatic 118	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   185: invokestatic 34	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   188: checkcast 58	java/lang/Number
    //   191: invokevirtual 62	java/lang/Number:intValue	()I
    //   194: invokestatic 401	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   197: getstatic 132	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
    //   200: invokespecial 404	gnu/lists/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   203: aload 5
    //   205: ifnonnull +9 -> 214
    //   208: dup
    //   209: astore 4
    //   211: goto +10 -> 221
    //   214: aload 5
    //   216: swap
    //   217: dup_x1
    //   218: invokevirtual 408	gnu/lists/Pair:setCdr	(Ljava/lang/Object;)V
    //   221: astore 5
    //   223: goto -75 -> 148
    //   226: aload 4
    //   228: invokestatic 412	kawa/lib/strings:list$To$String	(Lgnu/lists/LList;)Ljava/lang/CharSequence;
    //   231: areturn
    //   232: new 66	gnu/mapping/WrongType
    //   235: dup_x1
    //   236: swap
    //   237: ldc 116
    //   239: iconst_1
    //   240: aload_3
    //   241: invokespecial 71	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   244: athrow
    //   245: new 66	gnu/mapping/WrongType
    //   248: dup_x1
    //   249: swap
    //   250: ldc 116
    //   252: iconst_1
    //   253: aload 8
    //   255: invokespecial 71	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   258: athrow
    // Line number table:
    //   Java source line #10267	-> byte code offset #0
    //   Java source line #10268	-> byte code offset #0
    //   Java source line #10269	-> byte code offset #66
    //   Java source line #10271	-> byte code offset #66
    //   Java source line #10272	-> byte code offset #66
    //   Java source line #10273	-> byte code offset #116
    //   Java source line #10270	-> byte code offset #169
    //   Java source line #10268	-> byte code offset #232
    //   Java source line #10270	-> byte code offset #245
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	231	0	usb_control_in	Object
    //   0	231	1	index	Object
    //   66	165	2	stringLen	Object
    // Exception table:
    //   from	to	target	type
    //   59	62	232	java/lang/ClassCastException
    //   179	182	245	java/lang/ClassCastException
  }
  
  static Object lambda5()
  {
    return lambda5(Lit15, Lit1);
  }
  
  static Object lambda5(Object paramObject)
  {
    return lambda5(paramObject, Lit1);
  }
  
  /* Error */
  public static gnu.math.IntNum getVoltageSupportFromDescriptor(Object desc)
  {
    // Byte code:
    //   0: getstatic 572	com/ftsafe/CCIDScheme:Lit98	Lgnu/mapping/SimpleSymbol;
    //   3: getstatic 535	com/ftsafe/CCIDScheme:current_dev_interface	Lgnu/mapping/Procedure;
    //   6: invokevirtual 575	gnu/mapping/Procedure:apply0	()Ljava/lang/Object;
    //   9: aload_0
    //   10: invokestatic 348	kawa/lib/lists:assoc	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   13: ldc 98
    //   15: invokestatic 101	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   18: dup
    //   19: astore_2
    //   20: checkcast 98	gnu/lists/Pair
    //   23: invokestatic 106	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   26: invokestatic 348	kawa/lib/lists:assoc	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   29: ldc 98
    //   31: invokestatic 101	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   34: dup
    //   35: astore_2
    //   36: checkcast 98	gnu/lists/Pair
    //   39: invokestatic 106	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   42: astore_1
    //   43: getstatic 578	com/ftsafe/CCIDScheme:Lit83	Lgnu/mapping/SimpleSymbol;
    //   46: aload_1
    //   47: invokestatic 348	kawa/lib/lists:assoc	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   50: invokestatic 581	kawa/lib/lists:cadr	(Ljava/lang/Object;)Ljava/lang/Object;
    //   53: astore_2
    //   54: getstatic 584	com/ftsafe/CCIDScheme:Lit72	Lgnu/mapping/SimpleSymbol;
    //   57: aload_1
    //   58: invokestatic 348	kawa/lib/lists:assoc	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   61: invokestatic 581	kawa/lib/lists:cadr	(Ljava/lang/Object;)Ljava/lang/Object;
    //   64: astore_3
    //   65: getstatic 276	kawa/standard/Scheme:isEqual	Lgnu/kawa/functions/IsEqual;
    //   68: getstatic 190	gnu/kawa/functions/BitwiseOp:and	Lgnu/kawa/functions/BitwiseOp;
    //   71: aload_2
    //   72: getstatic 168	com/ftsafe/CCIDScheme:Lit7	Lgnu/math/IntNum;
    //   75: invokevirtual 28	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   78: getstatic 168	com/ftsafe/CCIDScheme:Lit7	Lgnu/math/IntNum;
    //   81: invokevirtual 28	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   84: invokestatic 287	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   87: ifeq +9 -> 96
    //   90: getstatic 52	com/ftsafe/CCIDScheme:Lit1	Lgnu/math/IntNum;
    //   93: goto +99 -> 192
    //   96: getstatic 276	kawa/standard/Scheme:isEqual	Lgnu/kawa/functions/IsEqual;
    //   99: getstatic 190	gnu/kawa/functions/BitwiseOp:and	Lgnu/kawa/functions/BitwiseOp;
    //   102: aload_3
    //   103: getstatic 109	com/ftsafe/CCIDScheme:Lit2	Lgnu/math/IntNum;
    //   106: invokevirtual 28	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   109: getstatic 109	com/ftsafe/CCIDScheme:Lit2	Lgnu/math/IntNum;
    //   112: invokevirtual 28	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   115: invokestatic 287	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   118: ifeq +9 -> 127
    //   121: getstatic 109	com/ftsafe/CCIDScheme:Lit2	Lgnu/math/IntNum;
    //   124: goto +68 -> 192
    //   127: getstatic 276	kawa/standard/Scheme:isEqual	Lgnu/kawa/functions/IsEqual;
    //   130: getstatic 190	gnu/kawa/functions/BitwiseOp:and	Lgnu/kawa/functions/BitwiseOp;
    //   133: aload_3
    //   134: getstatic 357	com/ftsafe/CCIDScheme:Lit16	Lgnu/math/IntNum;
    //   137: invokevirtual 28	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   140: getstatic 357	com/ftsafe/CCIDScheme:Lit16	Lgnu/math/IntNum;
    //   143: invokevirtual 28	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   146: invokestatic 287	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   149: ifeq +9 -> 158
    //   152: getstatic 357	com/ftsafe/CCIDScheme:Lit16	Lgnu/math/IntNum;
    //   155: goto +37 -> 192
    //   158: getstatic 276	kawa/standard/Scheme:isEqual	Lgnu/kawa/functions/IsEqual;
    //   161: getstatic 190	gnu/kawa/functions/BitwiseOp:and	Lgnu/kawa/functions/BitwiseOp;
    //   164: aload_3
    //   165: getstatic 419	com/ftsafe/CCIDScheme:Lit18	Lgnu/math/IntNum;
    //   168: invokevirtual 28	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   171: getstatic 419	com/ftsafe/CCIDScheme:Lit18	Lgnu/math/IntNum;
    //   174: invokevirtual 28	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   177: invokestatic 287	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   180: ifeq +9 -> 189
    //   183: getstatic 587	com/ftsafe/CCIDScheme:Lit99	Lgnu/math/IntNum;
    //   186: goto +6 -> 192
    //   189: getstatic 52	com/ftsafe/CCIDScheme:Lit1	Lgnu/math/IntNum;
    //   192: areturn
    //   193: new 66	gnu/mapping/WrongType
    //   196: dup_x1
    //   197: swap
    //   198: ldc 103
    //   200: iconst_1
    //   201: aload_2
    //   202: invokespecial 71	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   205: athrow
    //   206: new 66	gnu/mapping/WrongType
    //   209: dup_x1
    //   210: swap
    //   211: ldc 103
    //   213: iconst_1
    //   214: aload_2
    //   215: invokespecial 71	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   218: athrow
    // Line number table:
    //   Java source line #10503	-> byte code offset #0
    //   Java source line #10504	-> byte code offset #0
    //   Java source line #10505	-> byte code offset #43
    //   Java source line #10504	-> byte code offset #54
    //   Java source line #10506	-> byte code offset #54
    //   Java source line #10507	-> byte code offset #65
    //   Java source line #10508	-> byte code offset #99
    //   Java source line #10509	-> byte code offset #130
    //   Java source line #10510	-> byte code offset #161
    //   Java source line #10511	-> byte code offset #189
    //   Java source line #10504	-> byte code offset #193
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	192	0	desc	Object
    //   42	16	1	ccid_desc	Object
    //   19	17	2	localObject1	Object
    //   53	162	2	dwFeatures	Object
    //   64	101	3	bVoltageSupport	Object
    //   193	1	5	localClassCastException1	ClassCastException
    //   206	1	6	localClassCastException2	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   20	23	193	java/lang/ClassCastException
    //   36	39	206	java/lang/ClassCastException
  }
  
  public static Object getBSeq()
  {
    return getBSeq(Lit100);
  }
  
  /* Error */
  public static gnu.lists.FString getBStatusBErrorErrorName(Object bStatus, Object bError)
  {
    // Byte code:
    //   0: getstatic 190	gnu/kawa/functions/BitwiseOp:and	Lgnu/kawa/functions/BitwiseOp;
    //   3: aload_0
    //   4: getstatic 587	com/ftsafe/CCIDScheme:Lit99	Lgnu/math/IntNum;
    //   7: invokevirtual 28	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   10: astore_2
    //   11: getstatic 155	gnu/kawa/functions/BitwiseOp:ashift	Lgnu/kawa/functions/BitwiseOp;
    //   14: getstatic 190	gnu/kawa/functions/BitwiseOp:and	Lgnu/kawa/functions/BitwiseOp;
    //   17: aload_0
    //   18: getstatic 602	com/ftsafe/CCIDScheme:Lit101	Lgnu/math/IntNum;
    //   21: invokevirtual 28	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   24: getstatic 605	com/ftsafe/CCIDScheme:Lit102	Lgnu/math/IntNum;
    //   27: invokevirtual 28	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   30: astore_3
    //   31: bipush 10
    //   33: anewarray 76	java/lang/Object
    //   36: dup
    //   37: iconst_0
    //   38: ldc_w 607
    //   41: aastore
    //   42: dup
    //   43: iconst_1
    //   44: aload_2
    //   45: ldc 58
    //   47: invokestatic 101	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   50: dup
    //   51: astore 4
    //   53: checkcast 58	java/lang/Number
    //   56: bipush 10
    //   58: invokestatic 369	kawa/lib/numbers:number$To$String	(Ljava/lang/Number;I)Ljava/lang/CharSequence;
    //   61: aastore
    //   62: dup
    //   63: iconst_2
    //   64: ldc_w 609
    //   67: aastore
    //   68: dup
    //   69: iconst_3
    //   70: ldc_w 611
    //   73: aastore
    //   74: dup
    //   75: iconst_4
    //   76: aload_3
    //   77: ldc 58
    //   79: invokestatic 101	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   82: dup
    //   83: astore 4
    //   85: checkcast 58	java/lang/Number
    //   88: bipush 10
    //   90: invokestatic 369	kawa/lib/numbers:number$To$String	(Ljava/lang/Number;I)Ljava/lang/CharSequence;
    //   93: aastore
    //   94: dup
    //   95: iconst_5
    //   96: ldc_w 609
    //   99: aastore
    //   100: dup
    //   101: bipush 6
    //   103: ldc_w 613
    //   106: aastore
    //   107: dup
    //   108: bipush 7
    //   110: aload_1
    //   111: ldc 58
    //   113: invokestatic 101	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   116: dup
    //   117: astore 4
    //   119: checkcast 58	java/lang/Number
    //   122: bipush 16
    //   124: invokestatic 369	kawa/lib/numbers:number$To$String	(Ljava/lang/Number;I)Ljava/lang/CharSequence;
    //   127: aastore
    //   128: dup
    //   129: bipush 8
    //   131: ldc_w 615
    //   134: aastore
    //   135: dup
    //   136: bipush 9
    //   138: aload_2
    //   139: getstatic 357	com/ftsafe/CCIDScheme:Lit16	Lgnu/math/IntNum;
    //   142: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   145: ifeq +29 -> 174
    //   148: aload_3
    //   149: getstatic 109	com/ftsafe/CCIDScheme:Lit2	Lgnu/math/IntNum;
    //   152: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   155: ifeq +19 -> 174
    //   158: aload_1
    //   159: getstatic 621	com/ftsafe/CCIDScheme:Lit58	Lgnu/math/IntNum;
    //   162: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   165: ifeq +9 -> 174
    //   168: ldc_w 623
    //   171: goto +3994 -> 4165
    //   174: aload_2
    //   175: getstatic 357	com/ftsafe/CCIDScheme:Lit16	Lgnu/math/IntNum;
    //   178: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   181: ifeq +29 -> 210
    //   184: aload_3
    //   185: getstatic 109	com/ftsafe/CCIDScheme:Lit2	Lgnu/math/IntNum;
    //   188: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   191: ifeq +19 -> 210
    //   194: aload_1
    //   195: getstatic 626	com/ftsafe/CCIDScheme:Lit103	Lgnu/math/IntNum;
    //   198: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   201: ifeq +9 -> 210
    //   204: ldc_w 628
    //   207: goto +3958 -> 4165
    //   210: aload_2
    //   211: getstatic 109	com/ftsafe/CCIDScheme:Lit2	Lgnu/math/IntNum;
    //   214: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   217: ifeq +29 -> 246
    //   220: aload_3
    //   221: getstatic 109	com/ftsafe/CCIDScheme:Lit2	Lgnu/math/IntNum;
    //   224: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   227: ifeq +19 -> 246
    //   230: aload_1
    //   231: getstatic 631	com/ftsafe/CCIDScheme:Lit104	Lgnu/math/IntNum;
    //   234: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   237: ifeq +9 -> 246
    //   240: ldc_w 633
    //   243: goto +3922 -> 4165
    //   246: aload_2
    //   247: getstatic 109	com/ftsafe/CCIDScheme:Lit2	Lgnu/math/IntNum;
    //   250: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   253: ifeq +29 -> 282
    //   256: aload_3
    //   257: getstatic 109	com/ftsafe/CCIDScheme:Lit2	Lgnu/math/IntNum;
    //   260: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   263: ifeq +19 -> 282
    //   266: aload_1
    //   267: getstatic 636	com/ftsafe/CCIDScheme:Lit105	Lgnu/math/IntNum;
    //   270: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   273: ifeq +9 -> 282
    //   276: ldc_w 638
    //   279: goto +3886 -> 4165
    //   282: aload_2
    //   283: getstatic 109	com/ftsafe/CCIDScheme:Lit2	Lgnu/math/IntNum;
    //   286: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   289: ifeq +29 -> 318
    //   292: aload_3
    //   293: getstatic 109	com/ftsafe/CCIDScheme:Lit2	Lgnu/math/IntNum;
    //   296: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   299: ifeq +19 -> 318
    //   302: aload_1
    //   303: getstatic 641	com/ftsafe/CCIDScheme:Lit106	Lgnu/math/IntNum;
    //   306: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   309: ifeq +9 -> 318
    //   312: ldc_w 643
    //   315: goto +3850 -> 4165
    //   318: aload_2
    //   319: getstatic 109	com/ftsafe/CCIDScheme:Lit2	Lgnu/math/IntNum;
    //   322: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   325: ifeq +29 -> 354
    //   328: aload_3
    //   329: getstatic 109	com/ftsafe/CCIDScheme:Lit2	Lgnu/math/IntNum;
    //   332: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   335: ifeq +19 -> 354
    //   338: aload_1
    //   339: getstatic 626	com/ftsafe/CCIDScheme:Lit103	Lgnu/math/IntNum;
    //   342: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   345: ifeq +9 -> 354
    //   348: ldc_w 645
    //   351: goto +3814 -> 4165
    //   354: aload_2
    //   355: getstatic 109	com/ftsafe/CCIDScheme:Lit2	Lgnu/math/IntNum;
    //   358: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   361: ifeq +29 -> 390
    //   364: aload_3
    //   365: getstatic 109	com/ftsafe/CCIDScheme:Lit2	Lgnu/math/IntNum;
    //   368: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   371: ifeq +19 -> 390
    //   374: aload_1
    //   375: getstatic 648	com/ftsafe/CCIDScheme:Lit107	Lgnu/math/IntNum;
    //   378: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   381: ifeq +9 -> 390
    //   384: ldc_w 650
    //   387: goto +3778 -> 4165
    //   390: aload_2
    //   391: getstatic 109	com/ftsafe/CCIDScheme:Lit2	Lgnu/math/IntNum;
    //   394: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   397: ifeq +29 -> 426
    //   400: aload_3
    //   401: getstatic 109	com/ftsafe/CCIDScheme:Lit2	Lgnu/math/IntNum;
    //   404: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   407: ifeq +19 -> 426
    //   410: aload_1
    //   411: getstatic 653	com/ftsafe/CCIDScheme:Lit108	Lgnu/math/IntNum;
    //   414: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   417: ifeq +9 -> 426
    //   420: ldc_w 655
    //   423: goto +3742 -> 4165
    //   426: aload_2
    //   427: getstatic 109	com/ftsafe/CCIDScheme:Lit2	Lgnu/math/IntNum;
    //   430: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   433: ifeq +29 -> 462
    //   436: aload_3
    //   437: getstatic 109	com/ftsafe/CCIDScheme:Lit2	Lgnu/math/IntNum;
    //   440: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   443: ifeq +19 -> 462
    //   446: aload_1
    //   447: getstatic 658	com/ftsafe/CCIDScheme:Lit109	Lgnu/math/IntNum;
    //   450: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   453: ifeq +9 -> 462
    //   456: ldc_w 660
    //   459: goto +3706 -> 4165
    //   462: aload_2
    //   463: getstatic 109	com/ftsafe/CCIDScheme:Lit2	Lgnu/math/IntNum;
    //   466: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   469: ifeq +29 -> 498
    //   472: aload_3
    //   473: getstatic 109	com/ftsafe/CCIDScheme:Lit2	Lgnu/math/IntNum;
    //   476: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   479: ifeq +19 -> 498
    //   482: aload_1
    //   483: getstatic 663	com/ftsafe/CCIDScheme:Lit110	Lgnu/math/IntNum;
    //   486: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   489: ifeq +9 -> 498
    //   492: ldc_w 665
    //   495: goto +3670 -> 4165
    //   498: aload_2
    //   499: getstatic 109	com/ftsafe/CCIDScheme:Lit2	Lgnu/math/IntNum;
    //   502: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   505: ifeq +29 -> 534
    //   508: aload_3
    //   509: getstatic 109	com/ftsafe/CCIDScheme:Lit2	Lgnu/math/IntNum;
    //   512: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   515: ifeq +19 -> 534
    //   518: aload_1
    //   519: getstatic 193	com/ftsafe/CCIDScheme:Lit9	Lgnu/math/IntNum;
    //   522: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   525: ifeq +9 -> 534
    //   528: ldc_w 667
    //   531: goto +3634 -> 4165
    //   534: aload_2
    //   535: getstatic 52	com/ftsafe/CCIDScheme:Lit1	Lgnu/math/IntNum;
    //   538: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   541: ifeq +29 -> 570
    //   544: aload_3
    //   545: getstatic 109	com/ftsafe/CCIDScheme:Lit2	Lgnu/math/IntNum;
    //   548: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   551: ifeq +19 -> 570
    //   554: aload_1
    //   555: getstatic 52	com/ftsafe/CCIDScheme:Lit1	Lgnu/math/IntNum;
    //   558: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   561: ifeq +9 -> 570
    //   564: ldc_w 669
    //   567: goto +3598 -> 4165
    //   570: aload_2
    //   571: getstatic 52	com/ftsafe/CCIDScheme:Lit1	Lgnu/math/IntNum;
    //   574: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   577: istore 4
    //   579: iload 4
    //   581: ifeq +11 -> 592
    //   584: iload 4
    //   586: ifeq +64 -> 650
    //   589: goto +35 -> 624
    //   592: aload_2
    //   593: getstatic 109	com/ftsafe/CCIDScheme:Lit2	Lgnu/math/IntNum;
    //   596: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   599: istore 5
    //   601: iload 5
    //   603: ifeq +11 -> 614
    //   606: iload 5
    //   608: ifeq +42 -> 650
    //   611: goto +13 -> 624
    //   614: aload_2
    //   615: getstatic 357	com/ftsafe/CCIDScheme:Lit16	Lgnu/math/IntNum;
    //   618: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   621: ifeq +29 -> 650
    //   624: aload_3
    //   625: getstatic 109	com/ftsafe/CCIDScheme:Lit2	Lgnu/math/IntNum;
    //   628: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   631: ifeq +19 -> 650
    //   634: aload_1
    //   635: getstatic 672	com/ftsafe/CCIDScheme:Lit111	Lgnu/math/IntNum;
    //   638: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   641: ifeq +9 -> 650
    //   644: ldc_w 674
    //   647: goto +3518 -> 4165
    //   650: aload_2
    //   651: getstatic 357	com/ftsafe/CCIDScheme:Lit16	Lgnu/math/IntNum;
    //   654: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   657: ifeq +29 -> 686
    //   660: aload_3
    //   661: getstatic 109	com/ftsafe/CCIDScheme:Lit2	Lgnu/math/IntNum;
    //   664: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   667: ifeq +19 -> 686
    //   670: aload_1
    //   671: getstatic 621	com/ftsafe/CCIDScheme:Lit58	Lgnu/math/IntNum;
    //   674: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   677: ifeq +9 -> 686
    //   680: ldc_w 623
    //   683: goto +3482 -> 4165
    //   686: aload_2
    //   687: getstatic 109	com/ftsafe/CCIDScheme:Lit2	Lgnu/math/IntNum;
    //   690: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   693: ifeq +29 -> 722
    //   696: aload_3
    //   697: getstatic 109	com/ftsafe/CCIDScheme:Lit2	Lgnu/math/IntNum;
    //   700: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   703: ifeq +19 -> 722
    //   706: aload_1
    //   707: getstatic 677	com/ftsafe/CCIDScheme:Lit112	Lgnu/math/IntNum;
    //   710: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   713: ifeq +9 -> 722
    //   716: ldc_w 679
    //   719: goto +3446 -> 4165
    //   722: aload_2
    //   723: getstatic 52	com/ftsafe/CCIDScheme:Lit1	Lgnu/math/IntNum;
    //   726: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   729: ifeq +29 -> 758
    //   732: aload_3
    //   733: getstatic 109	com/ftsafe/CCIDScheme:Lit2	Lgnu/math/IntNum;
    //   736: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   739: ifeq +19 -> 758
    //   742: aload_1
    //   743: getstatic 52	com/ftsafe/CCIDScheme:Lit1	Lgnu/math/IntNum;
    //   746: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   749: ifeq +9 -> 758
    //   752: ldc_w 669
    //   755: goto +3410 -> 4165
    //   758: aload_2
    //   759: getstatic 52	com/ftsafe/CCIDScheme:Lit1	Lgnu/math/IntNum;
    //   762: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   765: istore 4
    //   767: iload 4
    //   769: ifeq +11 -> 780
    //   772: iload 4
    //   774: ifeq +64 -> 838
    //   777: goto +35 -> 812
    //   780: aload_2
    //   781: getstatic 109	com/ftsafe/CCIDScheme:Lit2	Lgnu/math/IntNum;
    //   784: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   787: istore 5
    //   789: iload 5
    //   791: ifeq +11 -> 802
    //   794: iload 5
    //   796: ifeq +42 -> 838
    //   799: goto +13 -> 812
    //   802: aload_2
    //   803: getstatic 357	com/ftsafe/CCIDScheme:Lit16	Lgnu/math/IntNum;
    //   806: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   809: ifeq +29 -> 838
    //   812: aload_3
    //   813: getstatic 109	com/ftsafe/CCIDScheme:Lit2	Lgnu/math/IntNum;
    //   816: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   819: ifeq +19 -> 838
    //   822: aload_1
    //   823: getstatic 672	com/ftsafe/CCIDScheme:Lit111	Lgnu/math/IntNum;
    //   826: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   829: ifeq +9 -> 838
    //   832: ldc_w 674
    //   835: goto +3330 -> 4165
    //   838: aload_2
    //   839: getstatic 357	com/ftsafe/CCIDScheme:Lit16	Lgnu/math/IntNum;
    //   842: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   845: ifeq +29 -> 874
    //   848: aload_3
    //   849: getstatic 109	com/ftsafe/CCIDScheme:Lit2	Lgnu/math/IntNum;
    //   852: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   855: ifeq +19 -> 874
    //   858: aload_1
    //   859: getstatic 621	com/ftsafe/CCIDScheme:Lit58	Lgnu/math/IntNum;
    //   862: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   865: ifeq +9 -> 874
    //   868: ldc_w 623
    //   871: goto +3294 -> 4165
    //   874: aload_2
    //   875: getstatic 357	com/ftsafe/CCIDScheme:Lit16	Lgnu/math/IntNum;
    //   878: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   881: ifeq +29 -> 910
    //   884: aload_3
    //   885: getstatic 109	com/ftsafe/CCIDScheme:Lit2	Lgnu/math/IntNum;
    //   888: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   891: ifeq +19 -> 910
    //   894: aload_1
    //   895: getstatic 626	com/ftsafe/CCIDScheme:Lit103	Lgnu/math/IntNum;
    //   898: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   901: ifeq +9 -> 910
    //   904: ldc_w 628
    //   907: goto +3258 -> 4165
    //   910: aload_2
    //   911: getstatic 109	com/ftsafe/CCIDScheme:Lit2	Lgnu/math/IntNum;
    //   914: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   917: ifeq +29 -> 946
    //   920: aload_3
    //   921: getstatic 109	com/ftsafe/CCIDScheme:Lit2	Lgnu/math/IntNum;
    //   924: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   927: ifeq +19 -> 946
    //   930: aload_1
    //   931: getstatic 631	com/ftsafe/CCIDScheme:Lit104	Lgnu/math/IntNum;
    //   934: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   937: ifeq +9 -> 946
    //   940: ldc_w 633
    //   943: goto +3222 -> 4165
    //   946: aload_2
    //   947: getstatic 52	com/ftsafe/CCIDScheme:Lit1	Lgnu/math/IntNum;
    //   950: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   953: ifeq +29 -> 982
    //   956: aload_3
    //   957: getstatic 109	com/ftsafe/CCIDScheme:Lit2	Lgnu/math/IntNum;
    //   960: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   963: ifeq +19 -> 982
    //   966: aload_1
    //   967: getstatic 52	com/ftsafe/CCIDScheme:Lit1	Lgnu/math/IntNum;
    //   970: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   973: ifeq +9 -> 982
    //   976: ldc_w 669
    //   979: goto +3186 -> 4165
    //   982: aload_2
    //   983: getstatic 52	com/ftsafe/CCIDScheme:Lit1	Lgnu/math/IntNum;
    //   986: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   989: istore 4
    //   991: iload 4
    //   993: ifeq +11 -> 1004
    //   996: iload 4
    //   998: ifeq +64 -> 1062
    //   1001: goto +35 -> 1036
    //   1004: aload_2
    //   1005: getstatic 109	com/ftsafe/CCIDScheme:Lit2	Lgnu/math/IntNum;
    //   1008: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   1011: istore 5
    //   1013: iload 5
    //   1015: ifeq +11 -> 1026
    //   1018: iload 5
    //   1020: ifeq +42 -> 1062
    //   1023: goto +13 -> 1036
    //   1026: aload_2
    //   1027: getstatic 357	com/ftsafe/CCIDScheme:Lit16	Lgnu/math/IntNum;
    //   1030: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   1033: ifeq +29 -> 1062
    //   1036: aload_3
    //   1037: getstatic 109	com/ftsafe/CCIDScheme:Lit2	Lgnu/math/IntNum;
    //   1040: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   1043: ifeq +19 -> 1062
    //   1046: aload_1
    //   1047: getstatic 672	com/ftsafe/CCIDScheme:Lit111	Lgnu/math/IntNum;
    //   1050: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   1053: ifeq +9 -> 1062
    //   1056: ldc_w 674
    //   1059: goto +3106 -> 4165
    //   1062: aload_2
    //   1063: getstatic 357	com/ftsafe/CCIDScheme:Lit16	Lgnu/math/IntNum;
    //   1066: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   1069: ifeq +29 -> 1098
    //   1072: aload_3
    //   1073: getstatic 109	com/ftsafe/CCIDScheme:Lit2	Lgnu/math/IntNum;
    //   1076: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   1079: ifeq +19 -> 1098
    //   1082: aload_1
    //   1083: getstatic 621	com/ftsafe/CCIDScheme:Lit58	Lgnu/math/IntNum;
    //   1086: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   1089: ifeq +9 -> 1098
    //   1092: ldc_w 623
    //   1095: goto +3070 -> 4165
    //   1098: aload_2
    //   1099: getstatic 357	com/ftsafe/CCIDScheme:Lit16	Lgnu/math/IntNum;
    //   1102: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   1105: ifeq +29 -> 1134
    //   1108: aload_3
    //   1109: getstatic 109	com/ftsafe/CCIDScheme:Lit2	Lgnu/math/IntNum;
    //   1112: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   1115: ifeq +19 -> 1134
    //   1118: aload_1
    //   1119: getstatic 626	com/ftsafe/CCIDScheme:Lit103	Lgnu/math/IntNum;
    //   1122: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   1125: ifeq +9 -> 1134
    //   1128: ldc_w 628
    //   1131: goto +3034 -> 4165
    //   1134: aload_2
    //   1135: getstatic 109	com/ftsafe/CCIDScheme:Lit2	Lgnu/math/IntNum;
    //   1138: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   1141: ifeq +29 -> 1170
    //   1144: aload_3
    //   1145: getstatic 109	com/ftsafe/CCIDScheme:Lit2	Lgnu/math/IntNum;
    //   1148: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   1151: ifeq +19 -> 1170
    //   1154: aload_1
    //   1155: getstatic 677	com/ftsafe/CCIDScheme:Lit112	Lgnu/math/IntNum;
    //   1158: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   1161: ifeq +9 -> 1170
    //   1164: ldc_w 679
    //   1167: goto +2998 -> 4165
    //   1170: aload_2
    //   1171: getstatic 109	com/ftsafe/CCIDScheme:Lit2	Lgnu/math/IntNum;
    //   1174: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   1177: ifeq +29 -> 1206
    //   1180: aload_3
    //   1181: getstatic 109	com/ftsafe/CCIDScheme:Lit2	Lgnu/math/IntNum;
    //   1184: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   1187: ifeq +19 -> 1206
    //   1190: aload_1
    //   1191: getstatic 631	com/ftsafe/CCIDScheme:Lit104	Lgnu/math/IntNum;
    //   1194: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   1197: ifeq +9 -> 1206
    //   1200: ldc_w 633
    //   1203: goto +2962 -> 4165
    //   1206: aload_2
    //   1207: getstatic 52	com/ftsafe/CCIDScheme:Lit1	Lgnu/math/IntNum;
    //   1210: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   1213: ifeq +29 -> 1242
    //   1216: aload_3
    //   1217: getstatic 109	com/ftsafe/CCIDScheme:Lit2	Lgnu/math/IntNum;
    //   1220: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   1223: ifeq +19 -> 1242
    //   1226: aload_1
    //   1227: getstatic 52	com/ftsafe/CCIDScheme:Lit1	Lgnu/math/IntNum;
    //   1230: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   1233: ifeq +9 -> 1242
    //   1236: ldc_w 669
    //   1239: goto +2926 -> 4165
    //   1242: aload_2
    //   1243: getstatic 52	com/ftsafe/CCIDScheme:Lit1	Lgnu/math/IntNum;
    //   1246: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   1249: istore 4
    //   1251: iload 4
    //   1253: ifeq +11 -> 1264
    //   1256: iload 4
    //   1258: ifeq +64 -> 1322
    //   1261: goto +35 -> 1296
    //   1264: aload_2
    //   1265: getstatic 109	com/ftsafe/CCIDScheme:Lit2	Lgnu/math/IntNum;
    //   1268: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   1271: istore 5
    //   1273: iload 5
    //   1275: ifeq +11 -> 1286
    //   1278: iload 5
    //   1280: ifeq +42 -> 1322
    //   1283: goto +13 -> 1296
    //   1286: aload_2
    //   1287: getstatic 357	com/ftsafe/CCIDScheme:Lit16	Lgnu/math/IntNum;
    //   1290: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   1293: ifeq +29 -> 1322
    //   1296: aload_3
    //   1297: getstatic 109	com/ftsafe/CCIDScheme:Lit2	Lgnu/math/IntNum;
    //   1300: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   1303: ifeq +19 -> 1322
    //   1306: aload_1
    //   1307: getstatic 672	com/ftsafe/CCIDScheme:Lit111	Lgnu/math/IntNum;
    //   1310: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   1313: ifeq +9 -> 1322
    //   1316: ldc_w 674
    //   1319: goto +2846 -> 4165
    //   1322: aload_2
    //   1323: getstatic 52	com/ftsafe/CCIDScheme:Lit1	Lgnu/math/IntNum;
    //   1326: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   1329: ifeq +29 -> 1358
    //   1332: aload_3
    //   1333: getstatic 109	com/ftsafe/CCIDScheme:Lit2	Lgnu/math/IntNum;
    //   1336: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   1339: ifeq +19 -> 1358
    //   1342: aload_1
    //   1343: getstatic 636	com/ftsafe/CCIDScheme:Lit105	Lgnu/math/IntNum;
    //   1346: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   1349: ifeq +9 -> 1358
    //   1352: ldc_w 638
    //   1355: goto +2810 -> 4165
    //   1358: aload_2
    //   1359: getstatic 52	com/ftsafe/CCIDScheme:Lit1	Lgnu/math/IntNum;
    //   1362: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   1365: ifeq +29 -> 1394
    //   1368: aload_3
    //   1369: getstatic 109	com/ftsafe/CCIDScheme:Lit2	Lgnu/math/IntNum;
    //   1372: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   1375: ifeq +19 -> 1394
    //   1378: aload_1
    //   1379: getstatic 641	com/ftsafe/CCIDScheme:Lit106	Lgnu/math/IntNum;
    //   1382: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   1385: ifeq +9 -> 1394
    //   1388: ldc_w 681
    //   1391: goto +2774 -> 4165
    //   1394: aload_2
    //   1395: getstatic 52	com/ftsafe/CCIDScheme:Lit1	Lgnu/math/IntNum;
    //   1398: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   1401: ifeq +29 -> 1430
    //   1404: aload_3
    //   1405: getstatic 109	com/ftsafe/CCIDScheme:Lit2	Lgnu/math/IntNum;
    //   1408: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   1411: ifeq +19 -> 1430
    //   1414: aload_1
    //   1415: getstatic 684	com/ftsafe/CCIDScheme:Lit113	Lgnu/math/IntNum;
    //   1418: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   1421: ifeq +9 -> 1430
    //   1424: ldc_w 686
    //   1427: goto +2738 -> 4165
    //   1430: aload_2
    //   1431: getstatic 52	com/ftsafe/CCIDScheme:Lit1	Lgnu/math/IntNum;
    //   1434: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   1437: ifeq +29 -> 1466
    //   1440: aload_3
    //   1441: getstatic 109	com/ftsafe/CCIDScheme:Lit2	Lgnu/math/IntNum;
    //   1444: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   1447: ifeq +19 -> 1466
    //   1450: aload_1
    //   1451: getstatic 626	com/ftsafe/CCIDScheme:Lit103	Lgnu/math/IntNum;
    //   1454: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   1457: ifeq +9 -> 1466
    //   1460: ldc_w 645
    //   1463: goto +2702 -> 4165
    //   1466: aload_2
    //   1467: getstatic 52	com/ftsafe/CCIDScheme:Lit1	Lgnu/math/IntNum;
    //   1470: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   1473: ifeq +29 -> 1502
    //   1476: aload_3
    //   1477: getstatic 109	com/ftsafe/CCIDScheme:Lit2	Lgnu/math/IntNum;
    //   1480: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   1483: ifeq +19 -> 1502
    //   1486: aload_1
    //   1487: getstatic 168	com/ftsafe/CCIDScheme:Lit7	Lgnu/math/IntNum;
    //   1490: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   1493: ifeq +9 -> 1502
    //   1496: ldc_w 688
    //   1499: goto +2666 -> 4165
    //   1502: aload_2
    //   1503: getstatic 52	com/ftsafe/CCIDScheme:Lit1	Lgnu/math/IntNum;
    //   1506: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   1509: ifeq +29 -> 1538
    //   1512: aload_3
    //   1513: getstatic 109	com/ftsafe/CCIDScheme:Lit2	Lgnu/math/IntNum;
    //   1516: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   1519: ifeq +19 -> 1538
    //   1522: aload_1
    //   1523: getstatic 109	com/ftsafe/CCIDScheme:Lit2	Lgnu/math/IntNum;
    //   1526: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   1529: ifeq +9 -> 1538
    //   1532: ldc_w 690
    //   1535: goto +2630 -> 4165
    //   1538: aload_2
    //   1539: getstatic 52	com/ftsafe/CCIDScheme:Lit1	Lgnu/math/IntNum;
    //   1542: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   1545: ifeq +29 -> 1574
    //   1548: aload_3
    //   1549: getstatic 109	com/ftsafe/CCIDScheme:Lit2	Lgnu/math/IntNum;
    //   1552: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   1555: ifeq +19 -> 1574
    //   1558: aload_1
    //   1559: getstatic 193	com/ftsafe/CCIDScheme:Lit9	Lgnu/math/IntNum;
    //   1562: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   1565: ifeq +9 -> 1574
    //   1568: ldc_w 667
    //   1571: goto +2594 -> 4165
    //   1574: aload_2
    //   1575: getstatic 357	com/ftsafe/CCIDScheme:Lit16	Lgnu/math/IntNum;
    //   1578: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   1581: ifeq +29 -> 1610
    //   1584: aload_3
    //   1585: getstatic 109	com/ftsafe/CCIDScheme:Lit2	Lgnu/math/IntNum;
    //   1588: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   1591: ifeq +19 -> 1610
    //   1594: aload_1
    //   1595: getstatic 621	com/ftsafe/CCIDScheme:Lit58	Lgnu/math/IntNum;
    //   1598: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   1601: ifeq +9 -> 1610
    //   1604: ldc_w 623
    //   1607: goto +2558 -> 4165
    //   1610: aload_2
    //   1611: getstatic 357	com/ftsafe/CCIDScheme:Lit16	Lgnu/math/IntNum;
    //   1614: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   1617: ifeq +29 -> 1646
    //   1620: aload_3
    //   1621: getstatic 109	com/ftsafe/CCIDScheme:Lit2	Lgnu/math/IntNum;
    //   1624: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   1627: ifeq +19 -> 1646
    //   1630: aload_1
    //   1631: getstatic 626	com/ftsafe/CCIDScheme:Lit103	Lgnu/math/IntNum;
    //   1634: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   1637: ifeq +9 -> 1646
    //   1640: ldc_w 628
    //   1643: goto +2522 -> 4165
    //   1646: aload_2
    //   1647: getstatic 109	com/ftsafe/CCIDScheme:Lit2	Lgnu/math/IntNum;
    //   1650: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   1653: ifeq +29 -> 1682
    //   1656: aload_3
    //   1657: getstatic 109	com/ftsafe/CCIDScheme:Lit2	Lgnu/math/IntNum;
    //   1660: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   1663: ifeq +19 -> 1682
    //   1666: aload_1
    //   1667: getstatic 677	com/ftsafe/CCIDScheme:Lit112	Lgnu/math/IntNum;
    //   1670: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   1673: ifeq +9 -> 1682
    //   1676: ldc_w 679
    //   1679: goto +2486 -> 4165
    //   1682: aload_2
    //   1683: getstatic 109	com/ftsafe/CCIDScheme:Lit2	Lgnu/math/IntNum;
    //   1686: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   1689: ifeq +29 -> 1718
    //   1692: aload_3
    //   1693: getstatic 109	com/ftsafe/CCIDScheme:Lit2	Lgnu/math/IntNum;
    //   1696: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   1699: ifeq +19 -> 1718
    //   1702: aload_1
    //   1703: getstatic 631	com/ftsafe/CCIDScheme:Lit104	Lgnu/math/IntNum;
    //   1706: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   1709: ifeq +9 -> 1718
    //   1712: ldc_w 633
    //   1715: goto +2450 -> 4165
    //   1718: aload_2
    //   1719: getstatic 52	com/ftsafe/CCIDScheme:Lit1	Lgnu/math/IntNum;
    //   1722: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   1725: ifeq +29 -> 1754
    //   1728: aload_3
    //   1729: getstatic 109	com/ftsafe/CCIDScheme:Lit2	Lgnu/math/IntNum;
    //   1732: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   1735: ifeq +19 -> 1754
    //   1738: aload_1
    //   1739: getstatic 52	com/ftsafe/CCIDScheme:Lit1	Lgnu/math/IntNum;
    //   1742: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   1745: ifeq +9 -> 1754
    //   1748: ldc_w 669
    //   1751: goto +2414 -> 4165
    //   1754: aload_2
    //   1755: getstatic 52	com/ftsafe/CCIDScheme:Lit1	Lgnu/math/IntNum;
    //   1758: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   1761: istore 4
    //   1763: iload 4
    //   1765: ifeq +11 -> 1776
    //   1768: iload 4
    //   1770: ifeq +64 -> 1834
    //   1773: goto +35 -> 1808
    //   1776: aload_2
    //   1777: getstatic 109	com/ftsafe/CCIDScheme:Lit2	Lgnu/math/IntNum;
    //   1780: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   1783: istore 5
    //   1785: iload 5
    //   1787: ifeq +11 -> 1798
    //   1790: iload 5
    //   1792: ifeq +42 -> 1834
    //   1795: goto +13 -> 1808
    //   1798: aload_2
    //   1799: getstatic 357	com/ftsafe/CCIDScheme:Lit16	Lgnu/math/IntNum;
    //   1802: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   1805: ifeq +29 -> 1834
    //   1808: aload_3
    //   1809: getstatic 109	com/ftsafe/CCIDScheme:Lit2	Lgnu/math/IntNum;
    //   1812: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   1815: ifeq +19 -> 1834
    //   1818: aload_1
    //   1819: getstatic 672	com/ftsafe/CCIDScheme:Lit111	Lgnu/math/IntNum;
    //   1822: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   1825: ifeq +9 -> 1834
    //   1828: ldc_w 674
    //   1831: goto +2334 -> 4165
    //   1834: aload_2
    //   1835: getstatic 357	com/ftsafe/CCIDScheme:Lit16	Lgnu/math/IntNum;
    //   1838: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   1841: ifeq +29 -> 1870
    //   1844: aload_3
    //   1845: getstatic 109	com/ftsafe/CCIDScheme:Lit2	Lgnu/math/IntNum;
    //   1848: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   1851: ifeq +19 -> 1870
    //   1854: aload_1
    //   1855: getstatic 621	com/ftsafe/CCIDScheme:Lit58	Lgnu/math/IntNum;
    //   1858: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   1861: ifeq +9 -> 1870
    //   1864: ldc_w 623
    //   1867: goto +2298 -> 4165
    //   1870: aload_2
    //   1871: getstatic 357	com/ftsafe/CCIDScheme:Lit16	Lgnu/math/IntNum;
    //   1874: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   1877: ifeq +29 -> 1906
    //   1880: aload_3
    //   1881: getstatic 109	com/ftsafe/CCIDScheme:Lit2	Lgnu/math/IntNum;
    //   1884: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   1887: ifeq +19 -> 1906
    //   1890: aload_1
    //   1891: getstatic 626	com/ftsafe/CCIDScheme:Lit103	Lgnu/math/IntNum;
    //   1894: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   1897: ifeq +9 -> 1906
    //   1900: ldc_w 628
    //   1903: goto +2262 -> 4165
    //   1906: aload_2
    //   1907: getstatic 109	com/ftsafe/CCIDScheme:Lit2	Lgnu/math/IntNum;
    //   1910: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   1913: ifeq +29 -> 1942
    //   1916: aload_3
    //   1917: getstatic 109	com/ftsafe/CCIDScheme:Lit2	Lgnu/math/IntNum;
    //   1920: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   1923: ifeq +19 -> 1942
    //   1926: aload_1
    //   1927: getstatic 677	com/ftsafe/CCIDScheme:Lit112	Lgnu/math/IntNum;
    //   1930: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   1933: ifeq +9 -> 1942
    //   1936: ldc_w 679
    //   1939: goto +2226 -> 4165
    //   1942: aload_2
    //   1943: getstatic 109	com/ftsafe/CCIDScheme:Lit2	Lgnu/math/IntNum;
    //   1946: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   1949: ifeq +29 -> 1978
    //   1952: aload_3
    //   1953: getstatic 109	com/ftsafe/CCIDScheme:Lit2	Lgnu/math/IntNum;
    //   1956: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   1959: ifeq +19 -> 1978
    //   1962: aload_1
    //   1963: getstatic 631	com/ftsafe/CCIDScheme:Lit104	Lgnu/math/IntNum;
    //   1966: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   1969: ifeq +9 -> 1978
    //   1972: ldc_w 633
    //   1975: goto +2190 -> 4165
    //   1978: aload_2
    //   1979: getstatic 52	com/ftsafe/CCIDScheme:Lit1	Lgnu/math/IntNum;
    //   1982: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   1985: ifeq +29 -> 2014
    //   1988: aload_3
    //   1989: getstatic 109	com/ftsafe/CCIDScheme:Lit2	Lgnu/math/IntNum;
    //   1992: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   1995: ifeq +19 -> 2014
    //   1998: aload_1
    //   1999: getstatic 52	com/ftsafe/CCIDScheme:Lit1	Lgnu/math/IntNum;
    //   2002: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   2005: ifeq +9 -> 2014
    //   2008: ldc_w 669
    //   2011: goto +2154 -> 4165
    //   2014: aload_2
    //   2015: getstatic 52	com/ftsafe/CCIDScheme:Lit1	Lgnu/math/IntNum;
    //   2018: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   2021: istore 4
    //   2023: iload 4
    //   2025: ifeq +11 -> 2036
    //   2028: iload 4
    //   2030: ifeq +64 -> 2094
    //   2033: goto +35 -> 2068
    //   2036: aload_2
    //   2037: getstatic 109	com/ftsafe/CCIDScheme:Lit2	Lgnu/math/IntNum;
    //   2040: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   2043: istore 5
    //   2045: iload 5
    //   2047: ifeq +11 -> 2058
    //   2050: iload 5
    //   2052: ifeq +42 -> 2094
    //   2055: goto +13 -> 2068
    //   2058: aload_2
    //   2059: getstatic 357	com/ftsafe/CCIDScheme:Lit16	Lgnu/math/IntNum;
    //   2062: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   2065: ifeq +29 -> 2094
    //   2068: aload_3
    //   2069: getstatic 109	com/ftsafe/CCIDScheme:Lit2	Lgnu/math/IntNum;
    //   2072: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   2075: ifeq +19 -> 2094
    //   2078: aload_1
    //   2079: getstatic 672	com/ftsafe/CCIDScheme:Lit111	Lgnu/math/IntNum;
    //   2082: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   2085: ifeq +9 -> 2094
    //   2088: ldc_w 674
    //   2091: goto +2074 -> 4165
    //   2094: aload_2
    //   2095: getstatic 357	com/ftsafe/CCIDScheme:Lit16	Lgnu/math/IntNum;
    //   2098: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   2101: ifeq +29 -> 2130
    //   2104: aload_3
    //   2105: getstatic 109	com/ftsafe/CCIDScheme:Lit2	Lgnu/math/IntNum;
    //   2108: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   2111: ifeq +19 -> 2130
    //   2114: aload_1
    //   2115: getstatic 621	com/ftsafe/CCIDScheme:Lit58	Lgnu/math/IntNum;
    //   2118: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   2121: ifeq +9 -> 2130
    //   2124: ldc_w 623
    //   2127: goto +2038 -> 4165
    //   2130: aload_2
    //   2131: getstatic 357	com/ftsafe/CCIDScheme:Lit16	Lgnu/math/IntNum;
    //   2134: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   2137: ifeq +29 -> 2166
    //   2140: aload_3
    //   2141: getstatic 109	com/ftsafe/CCIDScheme:Lit2	Lgnu/math/IntNum;
    //   2144: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   2147: ifeq +19 -> 2166
    //   2150: aload_1
    //   2151: getstatic 626	com/ftsafe/CCIDScheme:Lit103	Lgnu/math/IntNum;
    //   2154: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   2157: ifeq +9 -> 2166
    //   2160: ldc_w 628
    //   2163: goto +2002 -> 4165
    //   2166: aload_2
    //   2167: getstatic 109	com/ftsafe/CCIDScheme:Lit2	Lgnu/math/IntNum;
    //   2170: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   2173: ifeq +29 -> 2202
    //   2176: aload_3
    //   2177: getstatic 109	com/ftsafe/CCIDScheme:Lit2	Lgnu/math/IntNum;
    //   2180: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   2183: ifeq +19 -> 2202
    //   2186: aload_1
    //   2187: getstatic 677	com/ftsafe/CCIDScheme:Lit112	Lgnu/math/IntNum;
    //   2190: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   2193: ifeq +9 -> 2202
    //   2196: ldc_w 679
    //   2199: goto +1966 -> 4165
    //   2202: aload_2
    //   2203: getstatic 109	com/ftsafe/CCIDScheme:Lit2	Lgnu/math/IntNum;
    //   2206: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   2209: ifeq +29 -> 2238
    //   2212: aload_3
    //   2213: getstatic 109	com/ftsafe/CCIDScheme:Lit2	Lgnu/math/IntNum;
    //   2216: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   2219: ifeq +19 -> 2238
    //   2222: aload_1
    //   2223: getstatic 631	com/ftsafe/CCIDScheme:Lit104	Lgnu/math/IntNum;
    //   2226: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   2229: ifeq +9 -> 2238
    //   2232: ldc_w 633
    //   2235: goto +1930 -> 4165
    //   2238: aload_2
    //   2239: getstatic 52	com/ftsafe/CCIDScheme:Lit1	Lgnu/math/IntNum;
    //   2242: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   2245: ifeq +29 -> 2274
    //   2248: aload_3
    //   2249: getstatic 109	com/ftsafe/CCIDScheme:Lit2	Lgnu/math/IntNum;
    //   2252: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   2255: ifeq +19 -> 2274
    //   2258: aload_1
    //   2259: getstatic 52	com/ftsafe/CCIDScheme:Lit1	Lgnu/math/IntNum;
    //   2262: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   2265: ifeq +9 -> 2274
    //   2268: ldc_w 669
    //   2271: goto +1894 -> 4165
    //   2274: aload_2
    //   2275: getstatic 52	com/ftsafe/CCIDScheme:Lit1	Lgnu/math/IntNum;
    //   2278: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   2281: istore 4
    //   2283: iload 4
    //   2285: ifeq +11 -> 2296
    //   2288: iload 4
    //   2290: ifeq +64 -> 2354
    //   2293: goto +35 -> 2328
    //   2296: aload_2
    //   2297: getstatic 109	com/ftsafe/CCIDScheme:Lit2	Lgnu/math/IntNum;
    //   2300: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   2303: istore 5
    //   2305: iload 5
    //   2307: ifeq +11 -> 2318
    //   2310: iload 5
    //   2312: ifeq +42 -> 2354
    //   2315: goto +13 -> 2328
    //   2318: aload_2
    //   2319: getstatic 357	com/ftsafe/CCIDScheme:Lit16	Lgnu/math/IntNum;
    //   2322: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   2325: ifeq +29 -> 2354
    //   2328: aload_3
    //   2329: getstatic 109	com/ftsafe/CCIDScheme:Lit2	Lgnu/math/IntNum;
    //   2332: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   2335: ifeq +19 -> 2354
    //   2338: aload_1
    //   2339: getstatic 672	com/ftsafe/CCIDScheme:Lit111	Lgnu/math/IntNum;
    //   2342: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   2345: ifeq +9 -> 2354
    //   2348: ldc_w 674
    //   2351: goto +1814 -> 4165
    //   2354: aload_2
    //   2355: getstatic 52	com/ftsafe/CCIDScheme:Lit1	Lgnu/math/IntNum;
    //   2358: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   2361: ifeq +29 -> 2390
    //   2364: aload_3
    //   2365: getstatic 109	com/ftsafe/CCIDScheme:Lit2	Lgnu/math/IntNum;
    //   2368: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   2371: ifeq +19 -> 2390
    //   2374: aload_1
    //   2375: getstatic 636	com/ftsafe/CCIDScheme:Lit105	Lgnu/math/IntNum;
    //   2378: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   2381: ifeq +9 -> 2390
    //   2384: ldc_w 692
    //   2387: goto +1778 -> 4165
    //   2390: aload_2
    //   2391: getstatic 52	com/ftsafe/CCIDScheme:Lit1	Lgnu/math/IntNum;
    //   2394: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   2397: ifeq +29 -> 2426
    //   2400: aload_3
    //   2401: getstatic 109	com/ftsafe/CCIDScheme:Lit2	Lgnu/math/IntNum;
    //   2404: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   2407: ifeq +19 -> 2426
    //   2410: aload_1
    //   2411: getstatic 695	com/ftsafe/CCIDScheme:Lit114	Lgnu/math/IntNum;
    //   2414: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   2417: ifeq +9 -> 2426
    //   2420: ldc_w 697
    //   2423: goto +1742 -> 4165
    //   2426: aload_2
    //   2427: getstatic 52	com/ftsafe/CCIDScheme:Lit1	Lgnu/math/IntNum;
    //   2430: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   2433: ifeq +29 -> 2462
    //   2436: aload_3
    //   2437: getstatic 109	com/ftsafe/CCIDScheme:Lit2	Lgnu/math/IntNum;
    //   2440: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   2443: ifeq +19 -> 2462
    //   2446: aload_1
    //   2447: getstatic 700	com/ftsafe/CCIDScheme:Lit90	Lgnu/math/IntNum;
    //   2450: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   2453: ifeq +9 -> 2462
    //   2456: ldc_w 702
    //   2459: goto +1706 -> 4165
    //   2462: aload_2
    //   2463: getstatic 52	com/ftsafe/CCIDScheme:Lit1	Lgnu/math/IntNum;
    //   2466: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   2469: ifeq +29 -> 2498
    //   2472: aload_3
    //   2473: getstatic 109	com/ftsafe/CCIDScheme:Lit2	Lgnu/math/IntNum;
    //   2476: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   2479: ifeq +19 -> 2498
    //   2482: aload_1
    //   2483: getstatic 705	com/ftsafe/CCIDScheme:Lit115	Lgnu/math/IntNum;
    //   2486: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   2489: ifeq +9 -> 2498
    //   2492: ldc_w 707
    //   2495: goto +1670 -> 4165
    //   2498: aload_2
    //   2499: getstatic 52	com/ftsafe/CCIDScheme:Lit1	Lgnu/math/IntNum;
    //   2502: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   2505: ifeq +29 -> 2534
    //   2508: aload_3
    //   2509: getstatic 109	com/ftsafe/CCIDScheme:Lit2	Lgnu/math/IntNum;
    //   2512: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   2515: ifeq +19 -> 2534
    //   2518: aload_1
    //   2519: getstatic 710	com/ftsafe/CCIDScheme:Lit116	Lgnu/math/IntNum;
    //   2522: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   2525: ifeq +9 -> 2534
    //   2528: ldc_w 712
    //   2531: goto +1634 -> 4165
    //   2534: aload_2
    //   2535: getstatic 52	com/ftsafe/CCIDScheme:Lit1	Lgnu/math/IntNum;
    //   2538: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   2541: ifeq +29 -> 2570
    //   2544: aload_3
    //   2545: getstatic 109	com/ftsafe/CCIDScheme:Lit2	Lgnu/math/IntNum;
    //   2548: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   2551: ifeq +19 -> 2570
    //   2554: aload_1
    //   2555: getstatic 715	com/ftsafe/CCIDScheme:Lit117	Lgnu/math/IntNum;
    //   2558: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   2561: ifeq +9 -> 2570
    //   2564: ldc_w 717
    //   2567: goto +1598 -> 4165
    //   2570: aload_2
    //   2571: getstatic 52	com/ftsafe/CCIDScheme:Lit1	Lgnu/math/IntNum;
    //   2574: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   2577: ifeq +29 -> 2606
    //   2580: aload_3
    //   2581: getstatic 109	com/ftsafe/CCIDScheme:Lit2	Lgnu/math/IntNum;
    //   2584: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   2587: ifeq +19 -> 2606
    //   2590: aload_1
    //   2591: getstatic 720	com/ftsafe/CCIDScheme:Lit118	Lgnu/math/IntNum;
    //   2594: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   2597: ifeq +9 -> 2606
    //   2600: ldc_w 722
    //   2603: goto +1562 -> 4165
    //   2606: aload_2
    //   2607: getstatic 52	com/ftsafe/CCIDScheme:Lit1	Lgnu/math/IntNum;
    //   2610: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   2613: ifeq +29 -> 2642
    //   2616: aload_3
    //   2617: getstatic 109	com/ftsafe/CCIDScheme:Lit2	Lgnu/math/IntNum;
    //   2620: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   2623: ifeq +19 -> 2642
    //   2626: aload_1
    //   2627: getstatic 165	com/ftsafe/CCIDScheme:Lit6	Lgnu/math/IntNum;
    //   2630: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   2633: ifeq +9 -> 2642
    //   2636: ldc_w 724
    //   2639: goto +1526 -> 4165
    //   2642: aload_2
    //   2643: getstatic 357	com/ftsafe/CCIDScheme:Lit16	Lgnu/math/IntNum;
    //   2646: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   2649: ifeq +29 -> 2678
    //   2652: aload_3
    //   2653: getstatic 109	com/ftsafe/CCIDScheme:Lit2	Lgnu/math/IntNum;
    //   2656: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   2659: ifeq +19 -> 2678
    //   2662: aload_1
    //   2663: getstatic 621	com/ftsafe/CCIDScheme:Lit58	Lgnu/math/IntNum;
    //   2666: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   2669: ifeq +9 -> 2678
    //   2672: ldc_w 623
    //   2675: goto +1490 -> 4165
    //   2678: aload_2
    //   2679: getstatic 52	com/ftsafe/CCIDScheme:Lit1	Lgnu/math/IntNum;
    //   2682: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   2685: ifeq +29 -> 2714
    //   2688: aload_3
    //   2689: getstatic 109	com/ftsafe/CCIDScheme:Lit2	Lgnu/math/IntNum;
    //   2692: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   2695: ifeq +19 -> 2714
    //   2698: aload_1
    //   2699: getstatic 52	com/ftsafe/CCIDScheme:Lit1	Lgnu/math/IntNum;
    //   2702: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   2705: ifeq +9 -> 2714
    //   2708: ldc_w 669
    //   2711: goto +1454 -> 4165
    //   2714: aload_2
    //   2715: getstatic 52	com/ftsafe/CCIDScheme:Lit1	Lgnu/math/IntNum;
    //   2718: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   2721: istore 4
    //   2723: iload 4
    //   2725: ifeq +11 -> 2736
    //   2728: iload 4
    //   2730: ifeq +64 -> 2794
    //   2733: goto +35 -> 2768
    //   2736: aload_2
    //   2737: getstatic 109	com/ftsafe/CCIDScheme:Lit2	Lgnu/math/IntNum;
    //   2740: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   2743: istore 5
    //   2745: iload 5
    //   2747: ifeq +11 -> 2758
    //   2750: iload 5
    //   2752: ifeq +42 -> 2794
    //   2755: goto +13 -> 2768
    //   2758: aload_2
    //   2759: getstatic 357	com/ftsafe/CCIDScheme:Lit16	Lgnu/math/IntNum;
    //   2762: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   2765: ifeq +29 -> 2794
    //   2768: aload_3
    //   2769: getstatic 109	com/ftsafe/CCIDScheme:Lit2	Lgnu/math/IntNum;
    //   2772: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   2775: ifeq +19 -> 2794
    //   2778: aload_1
    //   2779: getstatic 672	com/ftsafe/CCIDScheme:Lit111	Lgnu/math/IntNum;
    //   2782: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   2785: ifeq +9 -> 2794
    //   2788: ldc_w 674
    //   2791: goto +1374 -> 4165
    //   2794: aload_2
    //   2795: getstatic 109	com/ftsafe/CCIDScheme:Lit2	Lgnu/math/IntNum;
    //   2798: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   2801: ifeq +29 -> 2830
    //   2804: aload_3
    //   2805: getstatic 109	com/ftsafe/CCIDScheme:Lit2	Lgnu/math/IntNum;
    //   2808: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   2811: ifeq +19 -> 2830
    //   2814: aload_1
    //   2815: getstatic 193	com/ftsafe/CCIDScheme:Lit9	Lgnu/math/IntNum;
    //   2818: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   2821: ifeq +9 -> 2830
    //   2824: ldc_w 667
    //   2827: goto +1338 -> 4165
    //   2830: aload_2
    //   2831: getstatic 357	com/ftsafe/CCIDScheme:Lit16	Lgnu/math/IntNum;
    //   2834: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   2837: ifeq +29 -> 2866
    //   2840: aload_3
    //   2841: getstatic 109	com/ftsafe/CCIDScheme:Lit2	Lgnu/math/IntNum;
    //   2844: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   2847: ifeq +19 -> 2866
    //   2850: aload_1
    //   2851: getstatic 621	com/ftsafe/CCIDScheme:Lit58	Lgnu/math/IntNum;
    //   2854: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   2857: ifeq +9 -> 2866
    //   2860: ldc_w 623
    //   2863: goto +1302 -> 4165
    //   2866: aload_2
    //   2867: getstatic 357	com/ftsafe/CCIDScheme:Lit16	Lgnu/math/IntNum;
    //   2870: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   2873: ifeq +29 -> 2902
    //   2876: aload_3
    //   2877: getstatic 109	com/ftsafe/CCIDScheme:Lit2	Lgnu/math/IntNum;
    //   2880: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   2883: ifeq +19 -> 2902
    //   2886: aload_1
    //   2887: getstatic 626	com/ftsafe/CCIDScheme:Lit103	Lgnu/math/IntNum;
    //   2890: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   2893: ifeq +9 -> 2902
    //   2896: ldc_w 628
    //   2899: goto +1266 -> 4165
    //   2902: aload_2
    //   2903: getstatic 109	com/ftsafe/CCIDScheme:Lit2	Lgnu/math/IntNum;
    //   2906: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   2909: ifeq +29 -> 2938
    //   2912: aload_3
    //   2913: getstatic 109	com/ftsafe/CCIDScheme:Lit2	Lgnu/math/IntNum;
    //   2916: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   2919: ifeq +19 -> 2938
    //   2922: aload_1
    //   2923: getstatic 677	com/ftsafe/CCIDScheme:Lit112	Lgnu/math/IntNum;
    //   2926: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   2929: ifeq +9 -> 2938
    //   2932: ldc_w 679
    //   2935: goto +1230 -> 4165
    //   2938: aload_2
    //   2939: getstatic 109	com/ftsafe/CCIDScheme:Lit2	Lgnu/math/IntNum;
    //   2942: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   2945: ifeq +29 -> 2974
    //   2948: aload_3
    //   2949: getstatic 109	com/ftsafe/CCIDScheme:Lit2	Lgnu/math/IntNum;
    //   2952: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   2955: ifeq +19 -> 2974
    //   2958: aload_1
    //   2959: getstatic 631	com/ftsafe/CCIDScheme:Lit104	Lgnu/math/IntNum;
    //   2962: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   2965: ifeq +9 -> 2974
    //   2968: ldc_w 633
    //   2971: goto +1194 -> 4165
    //   2974: aload_2
    //   2975: getstatic 52	com/ftsafe/CCIDScheme:Lit1	Lgnu/math/IntNum;
    //   2978: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   2981: ifeq +29 -> 3010
    //   2984: aload_3
    //   2985: getstatic 109	com/ftsafe/CCIDScheme:Lit2	Lgnu/math/IntNum;
    //   2988: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   2991: ifeq +19 -> 3010
    //   2994: aload_1
    //   2995: getstatic 52	com/ftsafe/CCIDScheme:Lit1	Lgnu/math/IntNum;
    //   2998: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   3001: ifeq +9 -> 3010
    //   3004: ldc_w 669
    //   3007: goto +1158 -> 4165
    //   3010: aload_2
    //   3011: getstatic 52	com/ftsafe/CCIDScheme:Lit1	Lgnu/math/IntNum;
    //   3014: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   3017: istore 4
    //   3019: iload 4
    //   3021: ifeq +11 -> 3032
    //   3024: iload 4
    //   3026: ifeq +64 -> 3090
    //   3029: goto +35 -> 3064
    //   3032: aload_2
    //   3033: getstatic 109	com/ftsafe/CCIDScheme:Lit2	Lgnu/math/IntNum;
    //   3036: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   3039: istore 5
    //   3041: iload 5
    //   3043: ifeq +11 -> 3054
    //   3046: iload 5
    //   3048: ifeq +42 -> 3090
    //   3051: goto +13 -> 3064
    //   3054: aload_2
    //   3055: getstatic 357	com/ftsafe/CCIDScheme:Lit16	Lgnu/math/IntNum;
    //   3058: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   3061: ifeq +29 -> 3090
    //   3064: aload_3
    //   3065: getstatic 109	com/ftsafe/CCIDScheme:Lit2	Lgnu/math/IntNum;
    //   3068: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   3071: ifeq +19 -> 3090
    //   3074: aload_1
    //   3075: getstatic 672	com/ftsafe/CCIDScheme:Lit111	Lgnu/math/IntNum;
    //   3078: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   3081: ifeq +9 -> 3090
    //   3084: ldc_w 674
    //   3087: goto +1078 -> 4165
    //   3090: aload_2
    //   3091: getstatic 357	com/ftsafe/CCIDScheme:Lit16	Lgnu/math/IntNum;
    //   3094: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   3097: ifeq +29 -> 3126
    //   3100: aload_3
    //   3101: getstatic 109	com/ftsafe/CCIDScheme:Lit2	Lgnu/math/IntNum;
    //   3104: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   3107: ifeq +19 -> 3126
    //   3110: aload_1
    //   3111: getstatic 621	com/ftsafe/CCIDScheme:Lit58	Lgnu/math/IntNum;
    //   3114: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   3117: ifeq +9 -> 3126
    //   3120: ldc_w 623
    //   3123: goto +1042 -> 4165
    //   3126: aload_2
    //   3127: getstatic 357	com/ftsafe/CCIDScheme:Lit16	Lgnu/math/IntNum;
    //   3130: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   3133: ifeq +29 -> 3162
    //   3136: aload_3
    //   3137: getstatic 109	com/ftsafe/CCIDScheme:Lit2	Lgnu/math/IntNum;
    //   3140: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   3143: ifeq +19 -> 3162
    //   3146: aload_1
    //   3147: getstatic 626	com/ftsafe/CCIDScheme:Lit103	Lgnu/math/IntNum;
    //   3150: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   3153: ifeq +9 -> 3162
    //   3156: ldc_w 628
    //   3159: goto +1006 -> 4165
    //   3162: aload_2
    //   3163: getstatic 109	com/ftsafe/CCIDScheme:Lit2	Lgnu/math/IntNum;
    //   3166: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   3169: ifeq +29 -> 3198
    //   3172: aload_3
    //   3173: getstatic 109	com/ftsafe/CCIDScheme:Lit2	Lgnu/math/IntNum;
    //   3176: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   3179: ifeq +19 -> 3198
    //   3182: aload_1
    //   3183: getstatic 684	com/ftsafe/CCIDScheme:Lit113	Lgnu/math/IntNum;
    //   3186: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   3189: ifeq +9 -> 3198
    //   3192: ldc_w 660
    //   3195: goto +970 -> 4165
    //   3198: aload_2
    //   3199: getstatic 109	com/ftsafe/CCIDScheme:Lit2	Lgnu/math/IntNum;
    //   3202: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   3205: ifeq +29 -> 3234
    //   3208: aload_3
    //   3209: getstatic 109	com/ftsafe/CCIDScheme:Lit2	Lgnu/math/IntNum;
    //   3212: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   3215: ifeq +19 -> 3234
    //   3218: aload_1
    //   3219: getstatic 193	com/ftsafe/CCIDScheme:Lit9	Lgnu/math/IntNum;
    //   3222: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   3225: ifeq +9 -> 3234
    //   3228: ldc_w 667
    //   3231: goto +934 -> 4165
    //   3234: aload_2
    //   3235: getstatic 52	com/ftsafe/CCIDScheme:Lit1	Lgnu/math/IntNum;
    //   3238: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   3241: ifeq +29 -> 3270
    //   3244: aload_3
    //   3245: getstatic 109	com/ftsafe/CCIDScheme:Lit2	Lgnu/math/IntNum;
    //   3248: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   3251: ifeq +19 -> 3270
    //   3254: aload_1
    //   3255: getstatic 52	com/ftsafe/CCIDScheme:Lit1	Lgnu/math/IntNum;
    //   3258: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   3261: ifeq +9 -> 3270
    //   3264: ldc_w 669
    //   3267: goto +898 -> 4165
    //   3270: aload_2
    //   3271: getstatic 357	com/ftsafe/CCIDScheme:Lit16	Lgnu/math/IntNum;
    //   3274: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   3277: ifeq +29 -> 3306
    //   3280: aload_3
    //   3281: getstatic 109	com/ftsafe/CCIDScheme:Lit2	Lgnu/math/IntNum;
    //   3284: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   3287: ifeq +19 -> 3306
    //   3290: aload_1
    //   3291: getstatic 621	com/ftsafe/CCIDScheme:Lit58	Lgnu/math/IntNum;
    //   3294: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   3297: ifeq +9 -> 3306
    //   3300: ldc_w 623
    //   3303: goto +862 -> 4165
    //   3306: aload_2
    //   3307: getstatic 357	com/ftsafe/CCIDScheme:Lit16	Lgnu/math/IntNum;
    //   3310: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   3313: ifeq +29 -> 3342
    //   3316: aload_3
    //   3317: getstatic 109	com/ftsafe/CCIDScheme:Lit2	Lgnu/math/IntNum;
    //   3320: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   3323: ifeq +19 -> 3342
    //   3326: aload_1
    //   3327: getstatic 626	com/ftsafe/CCIDScheme:Lit103	Lgnu/math/IntNum;
    //   3330: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   3333: ifeq +9 -> 3342
    //   3336: ldc_w 628
    //   3339: goto +826 -> 4165
    //   3342: aload_2
    //   3343: getstatic 109	com/ftsafe/CCIDScheme:Lit2	Lgnu/math/IntNum;
    //   3346: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   3349: ifeq +29 -> 3378
    //   3352: aload_3
    //   3353: getstatic 109	com/ftsafe/CCIDScheme:Lit2	Lgnu/math/IntNum;
    //   3356: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   3359: ifeq +19 -> 3378
    //   3362: aload_1
    //   3363: getstatic 677	com/ftsafe/CCIDScheme:Lit112	Lgnu/math/IntNum;
    //   3366: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   3369: ifeq +9 -> 3378
    //   3372: ldc_w 679
    //   3375: goto +790 -> 4165
    //   3378: aload_2
    //   3379: getstatic 109	com/ftsafe/CCIDScheme:Lit2	Lgnu/math/IntNum;
    //   3382: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   3385: ifeq +29 -> 3414
    //   3388: aload_3
    //   3389: getstatic 109	com/ftsafe/CCIDScheme:Lit2	Lgnu/math/IntNum;
    //   3392: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   3395: ifeq +19 -> 3414
    //   3398: aload_1
    //   3399: getstatic 631	com/ftsafe/CCIDScheme:Lit104	Lgnu/math/IntNum;
    //   3402: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   3405: ifeq +9 -> 3414
    //   3408: ldc_w 633
    //   3411: goto +754 -> 4165
    //   3414: aload_2
    //   3415: getstatic 52	com/ftsafe/CCIDScheme:Lit1	Lgnu/math/IntNum;
    //   3418: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   3421: ifeq +29 -> 3450
    //   3424: aload_3
    //   3425: getstatic 109	com/ftsafe/CCIDScheme:Lit2	Lgnu/math/IntNum;
    //   3428: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   3431: ifeq +19 -> 3450
    //   3434: aload_1
    //   3435: getstatic 52	com/ftsafe/CCIDScheme:Lit1	Lgnu/math/IntNum;
    //   3438: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   3441: ifeq +9 -> 3450
    //   3444: ldc_w 669
    //   3447: goto +718 -> 4165
    //   3450: aload_2
    //   3451: getstatic 52	com/ftsafe/CCIDScheme:Lit1	Lgnu/math/IntNum;
    //   3454: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   3457: istore 4
    //   3459: iload 4
    //   3461: ifeq +11 -> 3472
    //   3464: iload 4
    //   3466: ifeq +64 -> 3530
    //   3469: goto +35 -> 3504
    //   3472: aload_2
    //   3473: getstatic 109	com/ftsafe/CCIDScheme:Lit2	Lgnu/math/IntNum;
    //   3476: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   3479: istore 5
    //   3481: iload 5
    //   3483: ifeq +11 -> 3494
    //   3486: iload 5
    //   3488: ifeq +42 -> 3530
    //   3491: goto +13 -> 3504
    //   3494: aload_2
    //   3495: getstatic 357	com/ftsafe/CCIDScheme:Lit16	Lgnu/math/IntNum;
    //   3498: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   3501: ifeq +29 -> 3530
    //   3504: aload_3
    //   3505: getstatic 109	com/ftsafe/CCIDScheme:Lit2	Lgnu/math/IntNum;
    //   3508: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   3511: ifeq +19 -> 3530
    //   3514: aload_1
    //   3515: getstatic 672	com/ftsafe/CCIDScheme:Lit111	Lgnu/math/IntNum;
    //   3518: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   3521: ifeq +9 -> 3530
    //   3524: ldc_w 674
    //   3527: goto +638 -> 4165
    //   3530: aload_2
    //   3531: getstatic 109	com/ftsafe/CCIDScheme:Lit2	Lgnu/math/IntNum;
    //   3534: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   3537: ifeq +29 -> 3566
    //   3540: aload_3
    //   3541: getstatic 109	com/ftsafe/CCIDScheme:Lit2	Lgnu/math/IntNum;
    //   3544: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   3547: ifeq +19 -> 3566
    //   3550: aload_1
    //   3551: getstatic 641	com/ftsafe/CCIDScheme:Lit106	Lgnu/math/IntNum;
    //   3554: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   3557: ifeq +9 -> 3566
    //   3560: ldc_w 643
    //   3563: goto +602 -> 4165
    //   3566: aload_2
    //   3567: getstatic 109	com/ftsafe/CCIDScheme:Lit2	Lgnu/math/IntNum;
    //   3570: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   3573: ifeq +29 -> 3602
    //   3576: aload_3
    //   3577: getstatic 109	com/ftsafe/CCIDScheme:Lit2	Lgnu/math/IntNum;
    //   3580: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   3583: ifeq +19 -> 3602
    //   3586: aload_1
    //   3587: getstatic 626	com/ftsafe/CCIDScheme:Lit103	Lgnu/math/IntNum;
    //   3590: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   3593: ifeq +9 -> 3602
    //   3596: ldc_w 645
    //   3599: goto +566 -> 4165
    //   3602: aload_2
    //   3603: getstatic 109	com/ftsafe/CCIDScheme:Lit2	Lgnu/math/IntNum;
    //   3606: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   3609: ifeq +29 -> 3638
    //   3612: aload_3
    //   3613: getstatic 109	com/ftsafe/CCIDScheme:Lit2	Lgnu/math/IntNum;
    //   3616: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   3619: ifeq +19 -> 3638
    //   3622: aload_1
    //   3623: getstatic 193	com/ftsafe/CCIDScheme:Lit9	Lgnu/math/IntNum;
    //   3626: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   3629: ifeq +9 -> 3638
    //   3632: ldc_w 667
    //   3635: goto +530 -> 4165
    //   3638: aload_2
    //   3639: getstatic 357	com/ftsafe/CCIDScheme:Lit16	Lgnu/math/IntNum;
    //   3642: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   3645: ifeq +29 -> 3674
    //   3648: aload_3
    //   3649: getstatic 109	com/ftsafe/CCIDScheme:Lit2	Lgnu/math/IntNum;
    //   3652: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   3655: ifeq +19 -> 3674
    //   3658: aload_1
    //   3659: getstatic 621	com/ftsafe/CCIDScheme:Lit58	Lgnu/math/IntNum;
    //   3662: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   3665: ifeq +9 -> 3674
    //   3668: ldc_w 623
    //   3671: goto +494 -> 4165
    //   3674: aload_2
    //   3675: getstatic 357	com/ftsafe/CCIDScheme:Lit16	Lgnu/math/IntNum;
    //   3678: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   3681: ifeq +29 -> 3710
    //   3684: aload_3
    //   3685: getstatic 109	com/ftsafe/CCIDScheme:Lit2	Lgnu/math/IntNum;
    //   3688: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   3691: ifeq +19 -> 3710
    //   3694: aload_1
    //   3695: getstatic 626	com/ftsafe/CCIDScheme:Lit103	Lgnu/math/IntNum;
    //   3698: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   3701: ifeq +9 -> 3710
    //   3704: ldc_w 628
    //   3707: goto +458 -> 4165
    //   3710: aload_2
    //   3711: getstatic 109	com/ftsafe/CCIDScheme:Lit2	Lgnu/math/IntNum;
    //   3714: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   3717: ifeq +29 -> 3746
    //   3720: aload_3
    //   3721: getstatic 109	com/ftsafe/CCIDScheme:Lit2	Lgnu/math/IntNum;
    //   3724: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   3727: ifeq +19 -> 3746
    //   3730: aload_1
    //   3731: getstatic 677	com/ftsafe/CCIDScheme:Lit112	Lgnu/math/IntNum;
    //   3734: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   3737: ifeq +9 -> 3746
    //   3740: ldc_w 679
    //   3743: goto +422 -> 4165
    //   3746: aload_2
    //   3747: getstatic 109	com/ftsafe/CCIDScheme:Lit2	Lgnu/math/IntNum;
    //   3750: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   3753: ifeq +29 -> 3782
    //   3756: aload_3
    //   3757: getstatic 109	com/ftsafe/CCIDScheme:Lit2	Lgnu/math/IntNum;
    //   3760: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   3763: ifeq +19 -> 3782
    //   3766: aload_1
    //   3767: getstatic 631	com/ftsafe/CCIDScheme:Lit104	Lgnu/math/IntNum;
    //   3770: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   3773: ifeq +9 -> 3782
    //   3776: ldc_w 633
    //   3779: goto +386 -> 4165
    //   3782: aload_2
    //   3783: getstatic 52	com/ftsafe/CCIDScheme:Lit1	Lgnu/math/IntNum;
    //   3786: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   3789: ifeq +29 -> 3818
    //   3792: aload_3
    //   3793: getstatic 109	com/ftsafe/CCIDScheme:Lit2	Lgnu/math/IntNum;
    //   3796: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   3799: ifeq +19 -> 3818
    //   3802: aload_1
    //   3803: getstatic 52	com/ftsafe/CCIDScheme:Lit1	Lgnu/math/IntNum;
    //   3806: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   3809: ifeq +9 -> 3818
    //   3812: ldc_w 669
    //   3815: goto +350 -> 4165
    //   3818: aload_2
    //   3819: getstatic 52	com/ftsafe/CCIDScheme:Lit1	Lgnu/math/IntNum;
    //   3822: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   3825: istore 4
    //   3827: iload 4
    //   3829: ifeq +11 -> 3840
    //   3832: iload 4
    //   3834: ifeq +64 -> 3898
    //   3837: goto +35 -> 3872
    //   3840: aload_2
    //   3841: getstatic 109	com/ftsafe/CCIDScheme:Lit2	Lgnu/math/IntNum;
    //   3844: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   3847: istore 5
    //   3849: iload 5
    //   3851: ifeq +11 -> 3862
    //   3854: iload 5
    //   3856: ifeq +42 -> 3898
    //   3859: goto +13 -> 3872
    //   3862: aload_2
    //   3863: getstatic 357	com/ftsafe/CCIDScheme:Lit16	Lgnu/math/IntNum;
    //   3866: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   3869: ifeq +29 -> 3898
    //   3872: aload_3
    //   3873: getstatic 109	com/ftsafe/CCIDScheme:Lit2	Lgnu/math/IntNum;
    //   3876: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   3879: ifeq +19 -> 3898
    //   3882: aload_1
    //   3883: getstatic 672	com/ftsafe/CCIDScheme:Lit111	Lgnu/math/IntNum;
    //   3886: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   3889: ifeq +9 -> 3898
    //   3892: ldc_w 674
    //   3895: goto +270 -> 4165
    //   3898: aload_2
    //   3899: getstatic 357	com/ftsafe/CCIDScheme:Lit16	Lgnu/math/IntNum;
    //   3902: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   3905: ifeq +29 -> 3934
    //   3908: aload_3
    //   3909: getstatic 109	com/ftsafe/CCIDScheme:Lit2	Lgnu/math/IntNum;
    //   3912: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   3915: ifeq +19 -> 3934
    //   3918: aload_1
    //   3919: getstatic 621	com/ftsafe/CCIDScheme:Lit58	Lgnu/math/IntNum;
    //   3922: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   3925: ifeq +9 -> 3934
    //   3928: ldc_w 623
    //   3931: goto +234 -> 4165
    //   3934: aload_2
    //   3935: getstatic 52	com/ftsafe/CCIDScheme:Lit1	Lgnu/math/IntNum;
    //   3938: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   3941: ifeq +29 -> 3970
    //   3944: aload_3
    //   3945: getstatic 109	com/ftsafe/CCIDScheme:Lit2	Lgnu/math/IntNum;
    //   3948: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   3951: ifeq +19 -> 3970
    //   3954: aload_1
    //   3955: getstatic 52	com/ftsafe/CCIDScheme:Lit1	Lgnu/math/IntNum;
    //   3958: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   3961: ifeq +9 -> 3970
    //   3964: ldc_w 669
    //   3967: goto +198 -> 4165
    //   3970: aload_2
    //   3971: getstatic 357	com/ftsafe/CCIDScheme:Lit16	Lgnu/math/IntNum;
    //   3974: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   3977: ifeq +29 -> 4006
    //   3980: aload_3
    //   3981: getstatic 109	com/ftsafe/CCIDScheme:Lit2	Lgnu/math/IntNum;
    //   3984: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   3987: ifeq +19 -> 4006
    //   3990: aload_1
    //   3991: getstatic 621	com/ftsafe/CCIDScheme:Lit58	Lgnu/math/IntNum;
    //   3994: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   3997: ifeq +9 -> 4006
    //   4000: ldc_w 623
    //   4003: goto +162 -> 4165
    //   4006: aload_2
    //   4007: getstatic 52	com/ftsafe/CCIDScheme:Lit1	Lgnu/math/IntNum;
    //   4010: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   4013: ifeq +29 -> 4042
    //   4016: aload_3
    //   4017: getstatic 109	com/ftsafe/CCIDScheme:Lit2	Lgnu/math/IntNum;
    //   4020: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   4023: ifeq +19 -> 4042
    //   4026: aload_1
    //   4027: getstatic 52	com/ftsafe/CCIDScheme:Lit1	Lgnu/math/IntNum;
    //   4030: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   4033: ifeq +9 -> 4042
    //   4036: ldc_w 669
    //   4039: goto +126 -> 4165
    //   4042: aload_3
    //   4043: getstatic 109	com/ftsafe/CCIDScheme:Lit2	Lgnu/math/IntNum;
    //   4046: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   4049: ifeq +29 -> 4078
    //   4052: aload_1
    //   4053: getstatic 727	com/ftsafe/CCIDScheme:Lit119	Lgnu/math/IntNum;
    //   4056: invokestatic 599	gnu/kawa/functions/NumberCompare:$Gr$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   4059: ifeq +19 -> 4078
    //   4062: aload_1
    //   4063: getstatic 602	com/ftsafe/CCIDScheme:Lit101	Lgnu/math/IntNum;
    //   4066: invokestatic 730	gnu/kawa/functions/NumberCompare:$Ls$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   4069: ifeq +9 -> 4078
    //   4072: ldc_w 732
    //   4075: goto +90 -> 4165
    //   4078: aload_3
    //   4079: getstatic 109	com/ftsafe/CCIDScheme:Lit2	Lgnu/math/IntNum;
    //   4082: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   4085: ifeq +29 -> 4114
    //   4088: aload_1
    //   4089: getstatic 109	com/ftsafe/CCIDScheme:Lit2	Lgnu/math/IntNum;
    //   4092: invokestatic 599	gnu/kawa/functions/NumberCompare:$Gr$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   4095: ifeq +19 -> 4114
    //   4098: aload_1
    //   4099: getstatic 735	com/ftsafe/CCIDScheme:Lit120	Lgnu/math/IntNum;
    //   4102: invokestatic 730	gnu/kawa/functions/NumberCompare:$Ls$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   4105: ifeq +9 -> 4114
    //   4108: ldc_w 737
    //   4111: goto +54 -> 4165
    //   4114: aload_3
    //   4115: getstatic 109	com/ftsafe/CCIDScheme:Lit2	Lgnu/math/IntNum;
    //   4118: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   4121: ifeq +9 -> 4130
    //   4124: ldc_w 739
    //   4127: goto +38 -> 4165
    //   4130: aload_2
    //   4131: getstatic 109	com/ftsafe/CCIDScheme:Lit2	Lgnu/math/IntNum;
    //   4134: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   4137: ifeq +9 -> 4146
    //   4140: ldc_w 741
    //   4143: goto +22 -> 4165
    //   4146: aload_2
    //   4147: getstatic 357	com/ftsafe/CCIDScheme:Lit16	Lgnu/math/IntNum;
    //   4150: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   4153: ifeq +9 -> 4162
    //   4156: ldc_w 743
    //   4159: goto +6 -> 4165
    //   4162: ldc_w 745
    //   4165: aastore
    //   4166: invokestatic 416	kawa/lib/strings:stringAppend	([Ljava/lang/Object;)Lgnu/lists/FString;
    //   4169: areturn
    //   4170: new 66	gnu/mapping/WrongType
    //   4173: dup_x1
    //   4174: swap
    //   4175: ldc_w 363
    //   4178: iconst_1
    //   4179: aload 4
    //   4181: invokespecial 71	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   4184: athrow
    //   4185: new 66	gnu/mapping/WrongType
    //   4188: dup_x1
    //   4189: swap
    //   4190: ldc_w 363
    //   4193: iconst_1
    //   4194: aload 4
    //   4196: invokespecial 71	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   4199: athrow
    //   4200: new 66	gnu/mapping/WrongType
    //   4203: dup_x1
    //   4204: swap
    //   4205: ldc_w 363
    //   4208: iconst_1
    //   4209: aload 4
    //   4211: invokespecial 71	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   4214: athrow
    // Line number table:
    //   Java source line #10524	-> byte code offset #0
    //   Java source line #10525	-> byte code offset #0
    //   Java source line #10526	-> byte code offset #11
    //   Java source line #10527	-> byte code offset #31
    //   Java source line #10528	-> byte code offset #44
    //   Java source line #10530	-> byte code offset #76
    //   Java source line #10532	-> byte code offset #110
    //   Java source line #10536	-> byte code offset #138
    //   Java source line #10537	-> byte code offset #148
    //   Java source line #10538	-> byte code offset #158
    //   Java source line #10539	-> byte code offset #174
    //   Java source line #10540	-> byte code offset #184
    //   Java source line #10541	-> byte code offset #194
    //   Java source line #10542	-> byte code offset #210
    //   Java source line #10543	-> byte code offset #220
    //   Java source line #10544	-> byte code offset #230
    //   Java source line #10545	-> byte code offset #246
    //   Java source line #10546	-> byte code offset #256
    //   Java source line #10547	-> byte code offset #266
    //   Java source line #10548	-> byte code offset #282
    //   Java source line #10549	-> byte code offset #292
    //   Java source line #10550	-> byte code offset #302
    //   Java source line #10551	-> byte code offset #318
    //   Java source line #10552	-> byte code offset #328
    //   Java source line #10553	-> byte code offset #338
    //   Java source line #10554	-> byte code offset #354
    //   Java source line #10555	-> byte code offset #364
    //   Java source line #10556	-> byte code offset #374
    //   Java source line #10557	-> byte code offset #390
    //   Java source line #10558	-> byte code offset #400
    //   Java source line #10559	-> byte code offset #410
    //   Java source line #10560	-> byte code offset #426
    //   Java source line #10561	-> byte code offset #436
    //   Java source line #10562	-> byte code offset #446
    //   Java source line #10563	-> byte code offset #462
    //   Java source line #10564	-> byte code offset #472
    //   Java source line #10565	-> byte code offset #482
    //   Java source line #10566	-> byte code offset #498
    //   Java source line #10567	-> byte code offset #508
    //   Java source line #10568	-> byte code offset #518
    //   Java source line #10569	-> byte code offset #534
    //   Java source line #10570	-> byte code offset #544
    //   Java source line #10571	-> byte code offset #554
    //   Java source line #10572	-> byte code offset #570
    //   Java source line #10573	-> byte code offset #592
    //   Java source line #10572	-> byte code offset #601
    //   Java source line #10574	-> byte code offset #614
    //   Java source line #10575	-> byte code offset #624
    //   Java source line #10576	-> byte code offset #634
    //   Java source line #10578	-> byte code offset #650
    //   Java source line #10579	-> byte code offset #660
    //   Java source line #10580	-> byte code offset #670
    //   Java source line #10581	-> byte code offset #686
    //   Java source line #10582	-> byte code offset #696
    //   Java source line #10583	-> byte code offset #706
    //   Java source line #10584	-> byte code offset #722
    //   Java source line #10585	-> byte code offset #732
    //   Java source line #10586	-> byte code offset #742
    //   Java source line #10587	-> byte code offset #758
    //   Java source line #10588	-> byte code offset #780
    //   Java source line #10587	-> byte code offset #789
    //   Java source line #10589	-> byte code offset #802
    //   Java source line #10590	-> byte code offset #812
    //   Java source line #10591	-> byte code offset #822
    //   Java source line #10593	-> byte code offset #838
    //   Java source line #10594	-> byte code offset #848
    //   Java source line #10595	-> byte code offset #858
    //   Java source line #10596	-> byte code offset #874
    //   Java source line #10597	-> byte code offset #884
    //   Java source line #10598	-> byte code offset #894
    //   Java source line #10599	-> byte code offset #910
    //   Java source line #10600	-> byte code offset #920
    //   Java source line #10601	-> byte code offset #930
    //   Java source line #10602	-> byte code offset #946
    //   Java source line #10603	-> byte code offset #956
    //   Java source line #10604	-> byte code offset #966
    //   Java source line #10605	-> byte code offset #982
    //   Java source line #10606	-> byte code offset #1004
    //   Java source line #10605	-> byte code offset #1013
    //   Java source line #10607	-> byte code offset #1026
    //   Java source line #10608	-> byte code offset #1036
    //   Java source line #10609	-> byte code offset #1046
    //   Java source line #10611	-> byte code offset #1062
    //   Java source line #10612	-> byte code offset #1072
    //   Java source line #10613	-> byte code offset #1082
    //   Java source line #10614	-> byte code offset #1098
    //   Java source line #10615	-> byte code offset #1108
    //   Java source line #10616	-> byte code offset #1118
    //   Java source line #10617	-> byte code offset #1134
    //   Java source line #10618	-> byte code offset #1144
    //   Java source line #10619	-> byte code offset #1154
    //   Java source line #10620	-> byte code offset #1170
    //   Java source line #10621	-> byte code offset #1180
    //   Java source line #10622	-> byte code offset #1190
    //   Java source line #10623	-> byte code offset #1206
    //   Java source line #10624	-> byte code offset #1216
    //   Java source line #10625	-> byte code offset #1226
    //   Java source line #10626	-> byte code offset #1242
    //   Java source line #10627	-> byte code offset #1264
    //   Java source line #10626	-> byte code offset #1273
    //   Java source line #10628	-> byte code offset #1286
    //   Java source line #10629	-> byte code offset #1296
    //   Java source line #10630	-> byte code offset #1306
    //   Java source line #10631	-> byte code offset #1322
    //   Java source line #10632	-> byte code offset #1332
    //   Java source line #10633	-> byte code offset #1342
    //   Java source line #10634	-> byte code offset #1358
    //   Java source line #10635	-> byte code offset #1368
    //   Java source line #10636	-> byte code offset #1378
    //   Java source line #10637	-> byte code offset #1394
    //   Java source line #10638	-> byte code offset #1404
    //   Java source line #10639	-> byte code offset #1414
    //   Java source line #10640	-> byte code offset #1430
    //   Java source line #10641	-> byte code offset #1440
    //   Java source line #10642	-> byte code offset #1450
    //   Java source line #10643	-> byte code offset #1466
    //   Java source line #10644	-> byte code offset #1476
    //   Java source line #10645	-> byte code offset #1486
    //   Java source line #10646	-> byte code offset #1502
    //   Java source line #10647	-> byte code offset #1512
    //   Java source line #10648	-> byte code offset #1522
    //   Java source line #10649	-> byte code offset #1538
    //   Java source line #10650	-> byte code offset #1548
    //   Java source line #10651	-> byte code offset #1558
    //   Java source line #10653	-> byte code offset #1574
    //   Java source line #10654	-> byte code offset #1584
    //   Java source line #10655	-> byte code offset #1594
    //   Java source line #10656	-> byte code offset #1610
    //   Java source line #10657	-> byte code offset #1620
    //   Java source line #10658	-> byte code offset #1630
    //   Java source line #10659	-> byte code offset #1646
    //   Java source line #10660	-> byte code offset #1656
    //   Java source line #10661	-> byte code offset #1666
    //   Java source line #10662	-> byte code offset #1682
    //   Java source line #10663	-> byte code offset #1692
    //   Java source line #10664	-> byte code offset #1702
    //   Java source line #10665	-> byte code offset #1718
    //   Java source line #10666	-> byte code offset #1728
    //   Java source line #10667	-> byte code offset #1738
    //   Java source line #10668	-> byte code offset #1754
    //   Java source line #10669	-> byte code offset #1776
    //   Java source line #10668	-> byte code offset #1785
    //   Java source line #10670	-> byte code offset #1798
    //   Java source line #10671	-> byte code offset #1808
    //   Java source line #10672	-> byte code offset #1818
    //   Java source line #10674	-> byte code offset #1834
    //   Java source line #10675	-> byte code offset #1844
    //   Java source line #10676	-> byte code offset #1854
    //   Java source line #10677	-> byte code offset #1870
    //   Java source line #10678	-> byte code offset #1880
    //   Java source line #10679	-> byte code offset #1890
    //   Java source line #10680	-> byte code offset #1906
    //   Java source line #10681	-> byte code offset #1916
    //   Java source line #10682	-> byte code offset #1926
    //   Java source line #10683	-> byte code offset #1942
    //   Java source line #10684	-> byte code offset #1952
    //   Java source line #10685	-> byte code offset #1962
    //   Java source line #10686	-> byte code offset #1978
    //   Java source line #10687	-> byte code offset #1988
    //   Java source line #10688	-> byte code offset #1998
    //   Java source line #10689	-> byte code offset #2014
    //   Java source line #10690	-> byte code offset #2036
    //   Java source line #10689	-> byte code offset #2045
    //   Java source line #10691	-> byte code offset #2058
    //   Java source line #10692	-> byte code offset #2068
    //   Java source line #10693	-> byte code offset #2078
    //   Java source line #10695	-> byte code offset #2094
    //   Java source line #10696	-> byte code offset #2104
    //   Java source line #10697	-> byte code offset #2114
    //   Java source line #10698	-> byte code offset #2130
    //   Java source line #10699	-> byte code offset #2140
    //   Java source line #10700	-> byte code offset #2150
    //   Java source line #10701	-> byte code offset #2166
    //   Java source line #10702	-> byte code offset #2176
    //   Java source line #10703	-> byte code offset #2186
    //   Java source line #10704	-> byte code offset #2202
    //   Java source line #10705	-> byte code offset #2212
    //   Java source line #10706	-> byte code offset #2222
    //   Java source line #10707	-> byte code offset #2238
    //   Java source line #10708	-> byte code offset #2248
    //   Java source line #10709	-> byte code offset #2258
    //   Java source line #10710	-> byte code offset #2274
    //   Java source line #10711	-> byte code offset #2296
    //   Java source line #10710	-> byte code offset #2305
    //   Java source line #10712	-> byte code offset #2318
    //   Java source line #10713	-> byte code offset #2328
    //   Java source line #10714	-> byte code offset #2338
    //   Java source line #10715	-> byte code offset #2354
    //   Java source line #10716	-> byte code offset #2364
    //   Java source line #10717	-> byte code offset #2374
    //   Java source line #10718	-> byte code offset #2390
    //   Java source line #10719	-> byte code offset #2400
    //   Java source line #10720	-> byte code offset #2410
    //   Java source line #10721	-> byte code offset #2426
    //   Java source line #10722	-> byte code offset #2436
    //   Java source line #10723	-> byte code offset #2446
    //   Java source line #10724	-> byte code offset #2462
    //   Java source line #10725	-> byte code offset #2472
    //   Java source line #10726	-> byte code offset #2482
    //   Java source line #10727	-> byte code offset #2498
    //   Java source line #10728	-> byte code offset #2508
    //   Java source line #10729	-> byte code offset #2518
    //   Java source line #10730	-> byte code offset #2534
    //   Java source line #10731	-> byte code offset #2544
    //   Java source line #10732	-> byte code offset #2554
    //   Java source line #10733	-> byte code offset #2570
    //   Java source line #10734	-> byte code offset #2580
    //   Java source line #10735	-> byte code offset #2590
    //   Java source line #10736	-> byte code offset #2606
    //   Java source line #10737	-> byte code offset #2616
    //   Java source line #10738	-> byte code offset #2626
    //   Java source line #10740	-> byte code offset #2642
    //   Java source line #10741	-> byte code offset #2652
    //   Java source line #10742	-> byte code offset #2662
    //   Java source line #10743	-> byte code offset #2678
    //   Java source line #10744	-> byte code offset #2688
    //   Java source line #10745	-> byte code offset #2698
    //   Java source line #10746	-> byte code offset #2714
    //   Java source line #10747	-> byte code offset #2736
    //   Java source line #10746	-> byte code offset #2745
    //   Java source line #10748	-> byte code offset #2758
    //   Java source line #10749	-> byte code offset #2768
    //   Java source line #10750	-> byte code offset #2778
    //   Java source line #10751	-> byte code offset #2794
    //   Java source line #10752	-> byte code offset #2804
    //   Java source line #10753	-> byte code offset #2814
    //   Java source line #10758	-> byte code offset #2830
    //   Java source line #10759	-> byte code offset #2840
    //   Java source line #10760	-> byte code offset #2850
    //   Java source line #10761	-> byte code offset #2866
    //   Java source line #10762	-> byte code offset #2876
    //   Java source line #10763	-> byte code offset #2886
    //   Java source line #10764	-> byte code offset #2902
    //   Java source line #10765	-> byte code offset #2912
    //   Java source line #10766	-> byte code offset #2922
    //   Java source line #10767	-> byte code offset #2938
    //   Java source line #10768	-> byte code offset #2948
    //   Java source line #10769	-> byte code offset #2958
    //   Java source line #10770	-> byte code offset #2974
    //   Java source line #10771	-> byte code offset #2984
    //   Java source line #10772	-> byte code offset #2994
    //   Java source line #10773	-> byte code offset #3010
    //   Java source line #10774	-> byte code offset #3032
    //   Java source line #10773	-> byte code offset #3041
    //   Java source line #10775	-> byte code offset #3054
    //   Java source line #10776	-> byte code offset #3064
    //   Java source line #10777	-> byte code offset #3074
    //   Java source line #10779	-> byte code offset #3090
    //   Java source line #10780	-> byte code offset #3100
    //   Java source line #10781	-> byte code offset #3110
    //   Java source line #10782	-> byte code offset #3126
    //   Java source line #10783	-> byte code offset #3136
    //   Java source line #10784	-> byte code offset #3146
    //   Java source line #10785	-> byte code offset #3162
    //   Java source line #10786	-> byte code offset #3172
    //   Java source line #10787	-> byte code offset #3182
    //   Java source line #10788	-> byte code offset #3198
    //   Java source line #10789	-> byte code offset #3208
    //   Java source line #10790	-> byte code offset #3218
    //   Java source line #10791	-> byte code offset #3234
    //   Java source line #10792	-> byte code offset #3244
    //   Java source line #10793	-> byte code offset #3254
    //   Java source line #10795	-> byte code offset #3270
    //   Java source line #10796	-> byte code offset #3280
    //   Java source line #10797	-> byte code offset #3290
    //   Java source line #10798	-> byte code offset #3306
    //   Java source line #10799	-> byte code offset #3316
    //   Java source line #10800	-> byte code offset #3326
    //   Java source line #10801	-> byte code offset #3342
    //   Java source line #10802	-> byte code offset #3352
    //   Java source line #10803	-> byte code offset #3362
    //   Java source line #10804	-> byte code offset #3378
    //   Java source line #10805	-> byte code offset #3388
    //   Java source line #10806	-> byte code offset #3398
    //   Java source line #10807	-> byte code offset #3414
    //   Java source line #10808	-> byte code offset #3424
    //   Java source line #10809	-> byte code offset #3434
    //   Java source line #10810	-> byte code offset #3450
    //   Java source line #10811	-> byte code offset #3472
    //   Java source line #10810	-> byte code offset #3481
    //   Java source line #10812	-> byte code offset #3494
    //   Java source line #10813	-> byte code offset #3504
    //   Java source line #10814	-> byte code offset #3514
    //   Java source line #10815	-> byte code offset #3530
    //   Java source line #10816	-> byte code offset #3540
    //   Java source line #10817	-> byte code offset #3550
    //   Java source line #10818	-> byte code offset #3566
    //   Java source line #10819	-> byte code offset #3576
    //   Java source line #10820	-> byte code offset #3586
    //   Java source line #10821	-> byte code offset #3602
    //   Java source line #10822	-> byte code offset #3612
    //   Java source line #10823	-> byte code offset #3622
    //   Java source line #10825	-> byte code offset #3638
    //   Java source line #10826	-> byte code offset #3648
    //   Java source line #10827	-> byte code offset #3658
    //   Java source line #10828	-> byte code offset #3674
    //   Java source line #10829	-> byte code offset #3684
    //   Java source line #10830	-> byte code offset #3694
    //   Java source line #10831	-> byte code offset #3710
    //   Java source line #10832	-> byte code offset #3720
    //   Java source line #10833	-> byte code offset #3730
    //   Java source line #10834	-> byte code offset #3746
    //   Java source line #10835	-> byte code offset #3756
    //   Java source line #10836	-> byte code offset #3766
    //   Java source line #10837	-> byte code offset #3782
    //   Java source line #10838	-> byte code offset #3792
    //   Java source line #10839	-> byte code offset #3802
    //   Java source line #10840	-> byte code offset #3818
    //   Java source line #10841	-> byte code offset #3840
    //   Java source line #10840	-> byte code offset #3849
    //   Java source line #10842	-> byte code offset #3862
    //   Java source line #10843	-> byte code offset #3872
    //   Java source line #10844	-> byte code offset #3882
    //   Java source line #10846	-> byte code offset #3898
    //   Java source line #10847	-> byte code offset #3908
    //   Java source line #10848	-> byte code offset #3918
    //   Java source line #10849	-> byte code offset #3934
    //   Java source line #10850	-> byte code offset #3944
    //   Java source line #10851	-> byte code offset #3954
    //   Java source line #10858	-> byte code offset #3970
    //   Java source line #10859	-> byte code offset #3980
    //   Java source line #10860	-> byte code offset #3990
    //   Java source line #10861	-> byte code offset #4006
    //   Java source line #10862	-> byte code offset #4016
    //   Java source line #10863	-> byte code offset #4026
    //   Java source line #10866	-> byte code offset #4042
    //   Java source line #10867	-> byte code offset #4052
    //   Java source line #10868	-> byte code offset #4062
    //   Java source line #10869	-> byte code offset #4078
    //   Java source line #10870	-> byte code offset #4088
    //   Java source line #10871	-> byte code offset #4098
    //   Java source line #10872	-> byte code offset #4114
    //   Java source line #10873	-> byte code offset #4130
    //   Java source line #10874	-> byte code offset #4146
    //   Java source line #10875	-> byte code offset #4162
    //   Java source line #10528	-> byte code offset #4170
    //   Java source line #10530	-> byte code offset #4185
    //   Java source line #10532	-> byte code offset #4200
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	4169	0	bStatus	Object
    //   0	4169	1	bError	Object
    //   31	4138	2	bmICCStatus	Object
    //   31	4138	3	bmCommandStatus	Object
    //   579	71	4	x	boolean
    //   767	71	4	x	boolean
    //   991	71	4	x	boolean
    //   1251	71	4	x	boolean
    //   1763	71	4	x	boolean
    //   2023	71	4	x	boolean
    //   2283	71	4	x	boolean
    //   2723	71	4	x	boolean
    //   3019	71	4	x	boolean
    //   3459	71	4	x	boolean
    //   3827	71	4	x	boolean
    //   601	23	5	x	boolean
    //   789	23	5	x	boolean
    //   1013	23	5	x	boolean
    //   1273	23	5	x	boolean
    //   1785	23	5	x	boolean
    //   2045	23	5	x	boolean
    //   2305	23	5	x	boolean
    //   2745	23	5	x	boolean
    //   3041	23	5	x	boolean
    //   3481	23	5	x	boolean
    //   3849	23	5	x	boolean
    // Exception table:
    //   from	to	target	type
    //   53	56	4170	java/lang/ClassCastException
    //   85	88	4185	java/lang/ClassCastException
    //   119	122	4200	java/lang/ClassCastException
  }
  
  /* Error */
  public static Object getAtrSupportProtocol(Object atr)
  {
    // Byte code:
    //   0: getstatic 898	com/ftsafe/CCIDScheme:lambda$Fn17	Lgnu/expr/ModuleMethod;
    //   3: getstatic 901	com/ftsafe/CCIDScheme:Lit158	Lgnu/mapping/SimpleSymbol;
    //   6: aload_0
    //   7: invokestatic 348	kawa/lib/lists:assoc	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   10: ldc 98
    //   12: invokestatic 101	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   15: dup
    //   16: astore_3
    //   17: checkcast 98	gnu/lists/Pair
    //   20: invokestatic 106	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   23: invokestatic 385	gnu/lists/Sequences:getIterator	(Ljava/lang/Object;)Ljava/util/Iterator;
    //   26: astore_2
    //   27: getstatic 132	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
    //   30: astore_3
    //   31: aconst_null
    //   32: astore 4
    //   34: aload_2
    //   35: invokeinterface 391 1 0
    //   40: ifeq +95 -> 135
    //   43: aload_2
    //   44: invokeinterface 395 1 0
    //   49: astore 5
    //   51: new 98	gnu/lists/Pair
    //   54: dup
    //   55: getstatic 904	com/ftsafe/CCIDScheme:Lit144	Lgnu/mapping/SimpleSymbol;
    //   58: aload 5
    //   60: ldc 98
    //   62: invokestatic 101	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   65: dup
    //   66: astore 8
    //   68: checkcast 98	gnu/lists/Pair
    //   71: invokestatic 106	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   74: invokestatic 348	kawa/lib/lists:assoc	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   77: astore 7
    //   79: aload 7
    //   81: invokestatic 287	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   84: ifeq +20 -> 104
    //   87: getstatic 190	gnu/kawa/functions/BitwiseOp:and	Lgnu/kawa/functions/BitwiseOp;
    //   90: aload 7
    //   92: invokestatic 581	kawa/lib/lists:cadr	(Ljava/lang/Object;)Ljava/lang/Object;
    //   95: getstatic 720	com/ftsafe/CCIDScheme:Lit118	Lgnu/math/IntNum;
    //   98: invokevirtual 28	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   101: goto +6 -> 107
    //   104: getstatic 247	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   107: getstatic 132	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
    //   110: invokespecial 404	gnu/lists/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   113: aload 4
    //   115: ifnonnull +8 -> 123
    //   118: dup
    //   119: astore_3
    //   120: goto +10 -> 130
    //   123: aload 4
    //   125: swap
    //   126: dup_x1
    //   127: invokevirtual 408	gnu/lists/Pair:setCdr	(Ljava/lang/Object;)V
    //   130: astore 4
    //   132: goto -98 -> 34
    //   135: aload_3
    //   136: invokestatic 339	com/ftsafe/CCIDScheme:filter	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   139: invokestatic 460	com/ftsafe/CCIDScheme:listRemoveDuplication	(Ljava/lang/Object;)Ljava/lang/Object;
    //   142: astore_1
    //   143: getstatic 52	com/ftsafe/CCIDScheme:Lit1	Lgnu/math/IntNum;
    //   146: aload_1
    //   147: invokestatic 907	com/ftsafe/CCIDScheme:isInList	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   150: invokestatic 287	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   153: ifeq +22 -> 175
    //   156: getstatic 109	com/ftsafe/CCIDScheme:Lit2	Lgnu/math/IntNum;
    //   159: aload_1
    //   160: invokestatic 907	com/ftsafe/CCIDScheme:isInList	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   163: invokestatic 287	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   166: ifeq +9 -> 175
    //   169: getstatic 910	com/ftsafe/CCIDScheme:Lit159	Lgnu/mapping/SimpleSymbol;
    //   172: goto +44 -> 216
    //   175: getstatic 52	com/ftsafe/CCIDScheme:Lit1	Lgnu/math/IntNum;
    //   178: aload_1
    //   179: invokestatic 907	com/ftsafe/CCIDScheme:isInList	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   182: invokestatic 287	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   185: ifeq +9 -> 194
    //   188: getstatic 913	com/ftsafe/CCIDScheme:Lit147	Lgnu/mapping/SimpleSymbol;
    //   191: goto +25 -> 216
    //   194: getstatic 109	com/ftsafe/CCIDScheme:Lit2	Lgnu/math/IntNum;
    //   197: aload_1
    //   198: invokestatic 907	com/ftsafe/CCIDScheme:isInList	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   201: invokestatic 287	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   204: ifeq +9 -> 213
    //   207: getstatic 916	com/ftsafe/CCIDScheme:Lit160	Lgnu/mapping/SimpleSymbol;
    //   210: goto +6 -> 216
    //   213: getstatic 913	com/ftsafe/CCIDScheme:Lit147	Lgnu/mapping/SimpleSymbol;
    //   216: areturn
    //   217: new 66	gnu/mapping/WrongType
    //   220: dup_x1
    //   221: swap
    //   222: ldc 103
    //   224: iconst_1
    //   225: aload_3
    //   226: invokespecial 71	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   229: athrow
    //   230: new 66	gnu/mapping/WrongType
    //   233: dup_x1
    //   234: swap
    //   235: ldc 103
    //   237: iconst_1
    //   238: aload 8
    //   240: invokespecial 71	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   243: athrow
    // Line number table:
    //   Java source line #11142	-> byte code offset #0
    //   Java source line #11143	-> byte code offset #0
    //   Java source line #11144	-> byte code offset #0
    //   Java source line #11145	-> byte code offset #3
    //   Java source line #11150	-> byte code offset #3
    //   Java source line #11146	-> byte code offset #55
    //   Java source line #11147	-> byte code offset #79
    //   Java source line #11148	-> byte code offset #87
    //   Java source line #11151	-> byte code offset #143
    //   Java source line #11152	-> byte code offset #156
    //   Java source line #11153	-> byte code offset #175
    //   Java source line #11154	-> byte code offset #194
    //   Java source line #11150	-> byte code offset #217
    //   Java source line #11146	-> byte code offset #230
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	216	0	atr	Object
    //   143	73	1	T	Object
    //   79	28	7	a	Object
    // Exception table:
    //   from	to	target	type
    //   17	20	217	java/lang/ClassCastException
    //   68	71	230	java/lang/ClassCastException
  }
  
  /* Error */
  public static gnu.lists.Pair getAtrTATBForT15(Object atr)
  {
    // Byte code:
    //   0: getstatic 919	com/ftsafe/CCIDScheme:lambda$Fn18	Lgnu/expr/ModuleMethod;
    //   3: getstatic 901	com/ftsafe/CCIDScheme:Lit158	Lgnu/mapping/SimpleSymbol;
    //   6: aload_0
    //   7: invokestatic 922	com/ftsafe/CCIDScheme:assocEX	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   10: invokestatic 385	gnu/lists/Sequences:getIterator	(Ljava/lang/Object;)Ljava/util/Iterator;
    //   13: astore_2
    //   14: getstatic 132	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
    //   17: astore_3
    //   18: aconst_null
    //   19: astore 4
    //   21: aload_2
    //   22: invokeinterface 391 1 0
    //   27: ifeq +123 -> 150
    //   30: aload_2
    //   31: invokeinterface 395 1 0
    //   36: astore 5
    //   38: new 98	gnu/lists/Pair
    //   41: dup
    //   42: getstatic 904	com/ftsafe/CCIDScheme:Lit144	Lgnu/mapping/SimpleSymbol;
    //   45: aload 5
    //   47: invokestatic 922	com/ftsafe/CCIDScheme:assocEX	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   50: astore 7
    //   52: aload 7
    //   54: invokestatic 287	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   57: ifeq +62 -> 119
    //   60: getstatic 190	gnu/kawa/functions/BitwiseOp:and	Lgnu/kawa/functions/BitwiseOp;
    //   63: aload 7
    //   65: ldc 98
    //   67: invokestatic 101	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   70: dup
    //   71: astore 8
    //   73: checkcast 98	gnu/lists/Pair
    //   76: invokestatic 118	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   79: getstatic 720	com/ftsafe/CCIDScheme:Lit118	Lgnu/math/IntNum;
    //   82: invokevirtual 28	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   85: getstatic 720	com/ftsafe/CCIDScheme:Lit118	Lgnu/math/IntNum;
    //   88: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   91: ifeq +22 -> 113
    //   94: aload 5
    //   96: ldc 98
    //   98: invokestatic 101	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   101: dup
    //   102: astore 8
    //   104: checkcast 98	gnu/lists/Pair
    //   107: invokestatic 118	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   110: goto +12 -> 122
    //   113: getstatic 247	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   116: goto +6 -> 122
    //   119: getstatic 247	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   122: getstatic 132	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
    //   125: invokespecial 404	gnu/lists/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   128: aload 4
    //   130: ifnonnull +8 -> 138
    //   133: dup
    //   134: astore_3
    //   135: goto +10 -> 145
    //   138: aload 4
    //   140: swap
    //   141: dup_x1
    //   142: invokevirtual 408	gnu/lists/Pair:setCdr	(Ljava/lang/Object;)V
    //   145: astore 4
    //   147: goto -126 -> 21
    //   150: aload_3
    //   151: invokestatic 339	com/ftsafe/CCIDScheme:filter	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   154: astore_1
    //   155: aload_1
    //   156: invokestatic 90	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
    //   159: ifeq +9 -> 168
    //   162: getstatic 925	com/ftsafe/CCIDScheme:Lit161	Lgnu/lists/PairWithPosition;
    //   165: goto +372 -> 537
    //   168: aload_1
    //   169: ldc 98
    //   171: invokestatic 101	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   174: dup
    //   175: astore 4
    //   177: checkcast 98	gnu/lists/Pair
    //   180: invokestatic 118	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   183: ldc_w 927
    //   186: invokestatic 101	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   189: dup
    //   190: astore 4
    //   192: checkcast 927	gnu/mapping/Symbol
    //   195: invokestatic 933	kawa/lib/misc:symbol$To$String	(Lgnu/mapping/Symbol;)Ljava/lang/String;
    //   198: invokestatic 937	kawa/lib/strings:string$To$List	(Ljava/lang/CharSequence;)Lgnu/lists/LList;
    //   201: invokestatic 385	gnu/lists/Sequences:getIterator	(Ljava/lang/Object;)Ljava/util/Iterator;
    //   204: astore_3
    //   205: getstatic 132	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
    //   208: astore 4
    //   210: aconst_null
    //   211: astore 5
    //   213: aload_3
    //   214: invokeinterface 391 1 0
    //   219: ifeq +55 -> 274
    //   222: aload_3
    //   223: invokeinterface 395 1 0
    //   228: astore 6
    //   230: new 98	gnu/lists/Pair
    //   233: dup
    //   234: aload 6
    //   236: invokestatic 34	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   239: invokestatic 940	gnu/text/Char:castToCharacter	(Ljava/lang/Object;)I
    //   242: invokestatic 329	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   245: getstatic 132	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
    //   248: invokespecial 404	gnu/lists/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   251: aload 5
    //   253: ifnonnull +9 -> 262
    //   256: dup
    //   257: astore 4
    //   259: goto +10 -> 269
    //   262: aload 5
    //   264: swap
    //   265: dup_x1
    //   266: invokevirtual 408	gnu/lists/Pair:setCdr	(Ljava/lang/Object;)V
    //   269: astore 5
    //   271: goto -58 -> 213
    //   274: aload 4
    //   276: astore_2
    //   277: iconst_1
    //   278: aload_2
    //   279: getstatic 943	com/ftsafe/CCIDScheme:Lit162	Lgnu/math/IntNum;
    //   282: aload_2
    //   283: invokevirtual 946	gnu/lists/LList:size	()I
    //   286: invokestatic 329	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   289: invokestatic 765	com/ftsafe/CCIDScheme:subu8list	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   292: invokestatic 385	gnu/lists/Sequences:getIterator	(Ljava/lang/Object;)Ljava/util/Iterator;
    //   295: astore 4
    //   297: getstatic 132	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
    //   300: astore 5
    //   302: aconst_null
    //   303: astore 6
    //   305: aload 4
    //   307: invokeinterface 391 1 0
    //   312: ifeq +59 -> 371
    //   315: aload 4
    //   317: invokeinterface 395 1 0
    //   322: astore 7
    //   324: new 98	gnu/lists/Pair
    //   327: dup
    //   328: aload 7
    //   330: invokestatic 34	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   333: checkcast 58	java/lang/Number
    //   336: invokevirtual 62	java/lang/Number:intValue	()I
    //   339: invokestatic 401	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   342: getstatic 132	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
    //   345: invokespecial 404	gnu/lists/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   348: aload 6
    //   350: ifnonnull +9 -> 359
    //   353: dup
    //   354: astore 5
    //   356: goto +10 -> 366
    //   359: aload 6
    //   361: swap
    //   362: dup_x1
    //   363: invokevirtual 408	gnu/lists/Pair:setCdr	(Ljava/lang/Object;)V
    //   366: astore 6
    //   368: goto -63 -> 305
    //   371: aload 5
    //   373: invokestatic 412	kawa/lib/strings:list$To$String	(Lgnu/lists/LList;)Ljava/lang/CharSequence;
    //   376: invokestatic 950	kawa/lib/numbers:string$To$Number	(Ljava/lang/CharSequence;)Ljava/lang/Object;
    //   379: getstatic 109	com/ftsafe/CCIDScheme:Lit2	Lgnu/math/IntNum;
    //   382: invokestatic 114	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   385: astore_3
    //   386: iconst_2
    //   387: anewarray 76	java/lang/Object
    //   390: dup
    //   391: iconst_0
    //   392: ldc_w 514
    //   395: aastore
    //   396: dup
    //   397: iconst_1
    //   398: aload_3
    //   399: ldc 58
    //   401: invokestatic 101	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   404: dup
    //   405: astore 5
    //   407: checkcast 58	java/lang/Number
    //   410: invokestatic 517	kawa/lib/numbers:number$To$String	(Ljava/lang/Number;)Ljava/lang/CharSequence;
    //   413: aastore
    //   414: invokestatic 416	kawa/lib/strings:stringAppend	([Ljava/lang/Object;)Lgnu/lists/FString;
    //   417: invokestatic 523	kawa/lib/misc:string$To$Symbol	(Ljava/lang/CharSequence;)Lgnu/mapping/SimpleSymbol;
    //   420: astore 4
    //   422: getstatic 953	com/ftsafe/CCIDScheme:Lit141	Lgnu/mapping/SimpleSymbol;
    //   425: aload 4
    //   427: getstatic 901	com/ftsafe/CCIDScheme:Lit158	Lgnu/mapping/SimpleSymbol;
    //   430: aload_0
    //   431: invokestatic 922	com/ftsafe/CCIDScheme:assocEX	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   434: invokestatic 922	com/ftsafe/CCIDScheme:assocEX	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   437: invokestatic 922	com/ftsafe/CCIDScheme:assocEX	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   440: astore 5
    //   442: getstatic 956	com/ftsafe/CCIDScheme:Lit142	Lgnu/mapping/SimpleSymbol;
    //   445: aload 4
    //   447: getstatic 901	com/ftsafe/CCIDScheme:Lit158	Lgnu/mapping/SimpleSymbol;
    //   450: aload_0
    //   451: invokestatic 922	com/ftsafe/CCIDScheme:assocEX	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   454: invokestatic 922	com/ftsafe/CCIDScheme:assocEX	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   457: invokestatic 922	com/ftsafe/CCIDScheme:assocEX	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   460: astore 6
    //   462: getstatic 959	com/ftsafe/CCIDScheme:Lit163	Lgnu/mapping/SimpleSymbol;
    //   465: aload 5
    //   467: invokestatic 287	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   470: ifeq +22 -> 492
    //   473: aload 5
    //   475: ldc 98
    //   477: invokestatic 101	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   480: dup
    //   481: astore 7
    //   483: checkcast 98	gnu/lists/Pair
    //   486: invokestatic 118	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   489: goto +6 -> 495
    //   492: getstatic 247	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   495: invokestatic 213	gnu/lists/LList:list2	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   498: getstatic 962	com/ftsafe/CCIDScheme:Lit164	Lgnu/mapping/SimpleSymbol;
    //   501: aload 6
    //   503: invokestatic 287	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   506: ifeq +22 -> 528
    //   509: aload 6
    //   511: ldc 98
    //   513: invokestatic 101	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   516: dup
    //   517: astore 7
    //   519: checkcast 98	gnu/lists/Pair
    //   522: invokestatic 118	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   525: goto +6 -> 531
    //   528: getstatic 247	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   531: invokestatic 213	gnu/lists/LList:list2	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   534: invokestatic 213	gnu/lists/LList:list2	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   537: areturn
    //   538: new 66	gnu/mapping/WrongType
    //   541: dup_x1
    //   542: swap
    //   543: ldc 116
    //   545: iconst_1
    //   546: aload 8
    //   548: invokespecial 71	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   551: athrow
    //   552: new 66	gnu/mapping/WrongType
    //   555: dup_x1
    //   556: swap
    //   557: ldc 116
    //   559: iconst_1
    //   560: aload 8
    //   562: invokespecial 71	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   565: athrow
    //   566: new 66	gnu/mapping/WrongType
    //   569: dup_x1
    //   570: swap
    //   571: ldc 116
    //   573: iconst_1
    //   574: aload 4
    //   576: invokespecial 71	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   579: athrow
    //   580: new 66	gnu/mapping/WrongType
    //   583: dup_x1
    //   584: swap
    //   585: ldc_w 929
    //   588: iconst_1
    //   589: aload 4
    //   591: invokespecial 71	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   594: athrow
    //   595: new 66	gnu/mapping/WrongType
    //   598: dup_x1
    //   599: swap
    //   600: ldc_w 363
    //   603: iconst_1
    //   604: aload 5
    //   606: invokespecial 71	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   609: athrow
    //   610: new 66	gnu/mapping/WrongType
    //   613: dup_x1
    //   614: swap
    //   615: ldc 116
    //   617: iconst_1
    //   618: aload 7
    //   620: invokespecial 71	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   623: athrow
    //   624: new 66	gnu/mapping/WrongType
    //   627: dup_x1
    //   628: swap
    //   629: ldc 116
    //   631: iconst_1
    //   632: aload 7
    //   634: invokespecial 71	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   637: athrow
    // Line number table:
    //   Java source line #11159	-> byte code offset #0
    //   Java source line #11161	-> byte code offset #0
    //   Java source line #11162	-> byte code offset #3
    //   Java source line #11167	-> byte code offset #3
    //   Java source line #11163	-> byte code offset #42
    //   Java source line #11164	-> byte code offset #52
    //   Java source line #11165	-> byte code offset #60
    //   Java source line #11168	-> byte code offset #155
    //   Java source line #11170	-> byte code offset #168
    //   Java source line #11171	-> byte code offset #168
    //   Java source line #11172	-> byte code offset #277
    //   Java source line #11173	-> byte code offset #386
    //   Java source line #11174	-> byte code offset #422
    //   Java source line #11175	-> byte code offset #442
    //   Java source line #11176	-> byte code offset #462
    //   Java source line #11177	-> byte code offset #509
    //   Java source line #11165	-> byte code offset #538
    //   Java source line #11171	-> byte code offset #566
    //   Java source line #11173	-> byte code offset #595
    //   Java source line #11176	-> byte code offset #610
    //   Java source line #11177	-> byte code offset #624
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	537	0	atr	Object
    //   155	382	1	r	Object
    //   277	260	2	s	gnu.lists.LList
    //   386	151	3	n	Object
    //   422	115	4	i	gnu.mapping.SimpleSymbol
    //   462	75	5	ta15	Object
    //   462	75	6	tb15	Object
    //   52	70	7	a	Object
    // Exception table:
    //   from	to	target	type
    //   73	76	538	java/lang/ClassCastException
    //   104	107	552	java/lang/ClassCastException
    //   177	180	566	java/lang/ClassCastException
    //   192	195	580	java/lang/ClassCastException
    //   407	410	595	java/lang/ClassCastException
    //   483	486	610	java/lang/ClassCastException
    //   519	522	624	java/lang/ClassCastException
  }
  
  /* Error */
  public static Object getPps1(Object atr)
  {
    // Byte code:
    //   0: getstatic 965	com/ftsafe/CCIDScheme:Lit74	Lgnu/mapping/SimpleSymbol;
    //   3: getstatic 572	com/ftsafe/CCIDScheme:Lit98	Lgnu/mapping/SimpleSymbol;
    //   6: getstatic 535	com/ftsafe/CCIDScheme:current_dev_interface	Lgnu/mapping/Procedure;
    //   9: invokevirtual 575	gnu/mapping/Procedure:apply0	()Ljava/lang/Object;
    //   12: getstatic 497	com/ftsafe/CCIDScheme:descriptor$Mninfo	Ljava/lang/Object;
    //   15: invokestatic 348	kawa/lib/lists:assoc	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   18: ldc 98
    //   20: invokestatic 101	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   23: dup
    //   24: astore_2
    //   25: checkcast 98	gnu/lists/Pair
    //   28: invokestatic 106	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   31: invokestatic 348	kawa/lib/lists:assoc	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   34: ldc 98
    //   36: invokestatic 101	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   39: dup
    //   40: astore_2
    //   41: checkcast 98	gnu/lists/Pair
    //   44: invokestatic 106	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   47: invokestatic 348	kawa/lib/lists:assoc	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   50: invokestatic 581	kawa/lib/lists:cadr	(Ljava/lang/Object;)Ljava/lang/Object;
    //   53: astore_1
    //   54: getstatic 968	com/ftsafe/CCIDScheme:Lit78	Lgnu/mapping/SimpleSymbol;
    //   57: getstatic 572	com/ftsafe/CCIDScheme:Lit98	Lgnu/mapping/SimpleSymbol;
    //   60: getstatic 535	com/ftsafe/CCIDScheme:current_dev_interface	Lgnu/mapping/Procedure;
    //   63: invokevirtual 575	gnu/mapping/Procedure:apply0	()Ljava/lang/Object;
    //   66: getstatic 497	com/ftsafe/CCIDScheme:descriptor$Mninfo	Ljava/lang/Object;
    //   69: invokestatic 348	kawa/lib/lists:assoc	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   72: ldc 98
    //   74: invokestatic 101	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   77: dup
    //   78: astore_3
    //   79: checkcast 98	gnu/lists/Pair
    //   82: invokestatic 106	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   85: invokestatic 348	kawa/lib/lists:assoc	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   88: ldc 98
    //   90: invokestatic 101	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   93: dup
    //   94: astore_3
    //   95: checkcast 98	gnu/lists/Pair
    //   98: invokestatic 106	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   101: invokestatic 348	kawa/lib/lists:assoc	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   104: invokestatic 581	kawa/lib/lists:cadr	(Ljava/lang/Object;)Ljava/lang/Object;
    //   107: astore_2
    //   108: getstatic 953	com/ftsafe/CCIDScheme:Lit141	Lgnu/mapping/SimpleSymbol;
    //   111: getstatic 971	com/ftsafe/CCIDScheme:Lit165	Lgnu/mapping/SimpleSymbol;
    //   114: getstatic 901	com/ftsafe/CCIDScheme:Lit158	Lgnu/mapping/SimpleSymbol;
    //   117: aload_0
    //   118: invokestatic 922	com/ftsafe/CCIDScheme:assocEX	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   121: invokestatic 922	com/ftsafe/CCIDScheme:assocEX	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   124: invokestatic 922	com/ftsafe/CCIDScheme:assocEX	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   127: astore 4
    //   129: aload 4
    //   131: invokestatic 287	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   134: ifeq +22 -> 156
    //   137: aload 4
    //   139: ldc 98
    //   141: invokestatic 101	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   144: dup
    //   145: astore 5
    //   147: checkcast 98	gnu/lists/Pair
    //   150: invokestatic 118	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   153: goto +6 -> 159
    //   156: getstatic 871	com/ftsafe/CCIDScheme:Lit149	Lgnu/mapping/SimpleSymbol;
    //   159: invokestatic 974	com/ftsafe/CCIDScheme:parseAtrTA1	(Ljava/lang/Object;)Lgnu/lists/Pair;
    //   162: astore_3
    //   163: getstatic 880	com/ftsafe/CCIDScheme:Lit152	Lgnu/mapping/SimpleSymbol;
    //   166: aload_3
    //   167: invokestatic 348	kawa/lib/lists:assoc	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   170: invokestatic 581	kawa/lib/lists:cadr	(Ljava/lang/Object;)Ljava/lang/Object;
    //   173: astore 4
    //   175: getstatic 886	com/ftsafe/CCIDScheme:Lit154	Lgnu/mapping/SimpleSymbol;
    //   178: aload_3
    //   179: invokestatic 348	kawa/lib/lists:assoc	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   182: invokestatic 581	kawa/lib/lists:cadr	(Ljava/lang/Object;)Ljava/lang/Object;
    //   185: astore 5
    //   187: getstatic 980	gnu/kawa/functions/DivideOp:quotient	Lgnu/kawa/functions/DivideOp;
    //   190: getstatic 986	gnu/kawa/functions/MultiplyOp:$St	Lgnu/kawa/functions/MultiplyOp;
    //   193: getstatic 986	gnu/kawa/functions/MultiplyOp:$St	Lgnu/kawa/functions/MultiplyOp;
    //   196: aload_1
    //   197: getstatic 989	com/ftsafe/CCIDScheme:Lit166	Lgnu/math/IntNum;
    //   200: invokevirtual 28	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   203: getstatic 109	com/ftsafe/CCIDScheme:Lit2	Lgnu/math/IntNum;
    //   206: invokevirtual 28	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   209: getstatic 992	com/ftsafe/CCIDScheme:Lit167	Lgnu/math/IntNum;
    //   212: invokevirtual 28	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   215: astore 6
    //   217: getstatic 980	gnu/kawa/functions/DivideOp:quotient	Lgnu/kawa/functions/DivideOp;
    //   220: getstatic 986	gnu/kawa/functions/MultiplyOp:$St	Lgnu/kawa/functions/MultiplyOp;
    //   223: getstatic 986	gnu/kawa/functions/MultiplyOp:$St	Lgnu/kawa/functions/MultiplyOp;
    //   226: aload_1
    //   227: getstatic 989	com/ftsafe/CCIDScheme:Lit166	Lgnu/math/IntNum;
    //   230: invokevirtual 28	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   233: aload 5
    //   235: invokevirtual 28	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   238: aload 4
    //   240: invokevirtual 28	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   243: astore 7
    //   245: getstatic 953	com/ftsafe/CCIDScheme:Lit141	Lgnu/mapping/SimpleSymbol;
    //   248: getstatic 971	com/ftsafe/CCIDScheme:Lit165	Lgnu/mapping/SimpleSymbol;
    //   251: getstatic 901	com/ftsafe/CCIDScheme:Lit158	Lgnu/mapping/SimpleSymbol;
    //   254: aload_0
    //   255: invokestatic 922	com/ftsafe/CCIDScheme:assocEX	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   258: invokestatic 922	com/ftsafe/CCIDScheme:assocEX	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   261: invokestatic 922	com/ftsafe/CCIDScheme:assocEX	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   264: astore 8
    //   266: aload 8
    //   268: invokestatic 287	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   271: ifeq +22 -> 293
    //   274: aload 8
    //   276: ldc 98
    //   278: invokestatic 101	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   281: dup
    //   282: astore 10
    //   284: checkcast 98	gnu/lists/Pair
    //   287: invokestatic 118	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   290: goto +6 -> 296
    //   293: getstatic 247	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   296: astore 9
    //   298: aload 7
    //   300: aload 6
    //   302: invokestatic 96	gnu/kawa/functions/NumberCompare:$Gr	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   305: ifeq +112 -> 417
    //   308: aload 7
    //   310: aload_2
    //   311: invokestatic 730	gnu/kawa/functions/NumberCompare:$Ls$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   314: ifeq +103 -> 417
    //   317: getstatic 276	kawa/standard/Scheme:isEqual	Lgnu/kawa/functions/IsEqual;
    //   320: getstatic 247	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   323: getstatic 247	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   326: invokevirtual 28	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   329: astore 10
    //   331: aload 10
    //   333: invokestatic 287	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   336: ifeq +14 -> 350
    //   339: aload 10
    //   341: invokestatic 287	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   344: ifeq +25 -> 369
    //   347: goto +17 -> 364
    //   350: aload 7
    //   352: getstatic 247	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   355: invokestatic 907	com/ftsafe/CCIDScheme:isInList	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   358: invokestatic 287	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   361: ifeq +8 -> 369
    //   364: aload 9
    //   366: goto +92 -> 458
    //   369: getstatic 953	com/ftsafe/CCIDScheme:Lit141	Lgnu/mapping/SimpleSymbol;
    //   372: getstatic 995	com/ftsafe/CCIDScheme:Lit168	Lgnu/mapping/SimpleSymbol;
    //   375: getstatic 901	com/ftsafe/CCIDScheme:Lit158	Lgnu/mapping/SimpleSymbol;
    //   378: aload_0
    //   379: invokestatic 922	com/ftsafe/CCIDScheme:assocEX	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   382: invokestatic 922	com/ftsafe/CCIDScheme:assocEX	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   385: invokestatic 922	com/ftsafe/CCIDScheme:assocEX	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   388: invokestatic 287	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   391: ifeq +20 -> 411
    //   394: iconst_1
    //   395: anewarray 76	java/lang/Object
    //   398: dup
    //   399: iconst_0
    //   400: ldc_w 997
    //   403: aastore
    //   404: invokestatic 181	kawa/lib/exceptions:error	([Ljava/lang/Object;)Lgnu/bytecode/Type$NeverReturns;
    //   407: getstatic 187	gnu/expr/Special:reachedUnexpected	Ljava/lang/RuntimeException;
    //   410: athrow
    //   411: getstatic 247	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   414: goto +44 -> 458
    //   417: aload 9
    //   419: invokestatic 287	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   422: ifeq +33 -> 455
    //   425: aload 7
    //   427: iconst_1
    //   428: getstatic 357	com/ftsafe/CCIDScheme:Lit16	Lgnu/math/IntNum;
    //   431: aload_2
    //   432: invokestatic 114	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   435: invokestatic 96	gnu/kawa/functions/NumberCompare:$Gr	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   438: ifeq +17 -> 455
    //   441: aload 9
    //   443: getstatic 1000	com/ftsafe/CCIDScheme:Lit169	Lgnu/math/IntNum;
    //   446: invokestatic 730	gnu/kawa/functions/NumberCompare:$Ls$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   449: ifeq +6 -> 455
    //   452: goto +3 -> 455
    //   455: getstatic 247	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   458: areturn
    //   459: new 66	gnu/mapping/WrongType
    //   462: dup_x1
    //   463: swap
    //   464: ldc 103
    //   466: iconst_1
    //   467: aload_2
    //   468: invokespecial 71	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   471: athrow
    //   472: new 66	gnu/mapping/WrongType
    //   475: dup_x1
    //   476: swap
    //   477: ldc 103
    //   479: iconst_1
    //   480: aload_2
    //   481: invokespecial 71	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   484: athrow
    //   485: new 66	gnu/mapping/WrongType
    //   488: dup_x1
    //   489: swap
    //   490: ldc 103
    //   492: iconst_1
    //   493: aload_3
    //   494: invokespecial 71	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   497: athrow
    //   498: new 66	gnu/mapping/WrongType
    //   501: dup_x1
    //   502: swap
    //   503: ldc 103
    //   505: iconst_1
    //   506: aload_3
    //   507: invokespecial 71	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   510: athrow
    //   511: new 66	gnu/mapping/WrongType
    //   514: dup_x1
    //   515: swap
    //   516: ldc 116
    //   518: iconst_1
    //   519: aload 5
    //   521: invokespecial 71	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   524: athrow
    //   525: new 66	gnu/mapping/WrongType
    //   528: dup_x1
    //   529: swap
    //   530: ldc 116
    //   532: iconst_1
    //   533: aload 10
    //   535: invokespecial 71	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   538: athrow
    // Line number table:
    //   Java source line #11181	-> byte code offset #0
    //   Java source line #11182	-> byte code offset #0
    //   Java source line #11183	-> byte code offset #0
    //   Java source line #11184	-> byte code offset #3
    //   Java source line #11185	-> byte code offset #6
    //   Java source line #11182	-> byte code offset #54
    //   Java source line #11187	-> byte code offset #54
    //   Java source line #11188	-> byte code offset #57
    //   Java source line #11189	-> byte code offset #60
    //   Java source line #11182	-> byte code offset #108
    //   Java source line #11190	-> byte code offset #108
    //   Java source line #11191	-> byte code offset #129
    //   Java source line #11182	-> byte code offset #163
    //   Java source line #11192	-> byte code offset #163
    //   Java source line #11182	-> byte code offset #175
    //   Java source line #11193	-> byte code offset #175
    //   Java source line #11182	-> byte code offset #187
    //   Java source line #11194	-> byte code offset #187
    //   Java source line #11182	-> byte code offset #217
    //   Java source line #11195	-> byte code offset #217
    //   Java source line #11196	-> byte code offset #245
    //   Java source line #11197	-> byte code offset #266
    //   Java source line #11198	-> byte code offset #298
    //   Java source line #11199	-> byte code offset #308
    //   Java source line #11200	-> byte code offset #317
    //   Java source line #11201	-> byte code offset #350
    //   Java source line #11200	-> byte code offset #364
    //   Java source line #11203	-> byte code offset #369
    //   Java source line #11204	-> byte code offset #394
    //   Java source line #11206	-> byte code offset #417
    //   Java source line #11207	-> byte code offset #425
    //   Java source line #11208	-> byte code offset #441
    //   Java source line #11185	-> byte code offset #459
    //   Java source line #11184	-> byte code offset #472
    //   Java source line #11189	-> byte code offset #485
    //   Java source line #11188	-> byte code offset #498
    //   Java source line #11191	-> byte code offset #511
    //   Java source line #11197	-> byte code offset #525
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	458	0	atr	Object
    //   53	174	1	dwDefaultClock	Object
    //   24	17	2	localObject1	Object
    //   107	374	2	dwMaxDataRate	Object
    //   78	17	3	localObject2	Object
    //   162	345	3	Fi_Di_fmax	gnu.lists.Pair
    //   127	11	4	ta1	Object
    //   173	66	4	Fi	Object
    //   145	1	5	localObject3	Object
    //   185	335	5	Di	Object
    //   215	86	6	default_baudrate	Object
    //   243	183	7	card_baudrate	Object
    //   264	11	8	_ta	Object
    //   296	146	9	ta	Object
    //   282	1	10	localObject4	Object
    //   329	205	10	x	Object
    //   459	1	16	localClassCastException1	ClassCastException
    //   472	1	17	localClassCastException2	ClassCastException
    //   485	1	18	localClassCastException3	ClassCastException
    //   498	1	19	localClassCastException4	ClassCastException
    //   511	1	20	localClassCastException5	ClassCastException
    //   525	1	21	localClassCastException6	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   25	28	459	java/lang/ClassCastException
    //   41	44	472	java/lang/ClassCastException
    //   79	82	485	java/lang/ClassCastException
    //   95	98	498	java/lang/ClassCastException
    //   147	150	511	java/lang/ClassCastException
    //   284	287	525	java/lang/ClassCastException
  }
  
  /* Error */
  public static Object getAtrIFSC(Object atr)
  {
    // Byte code:
    //   0: getstatic 1031	kawa/lib/numbers:number$Qu	Lgnu/expr/ModuleMethod;
    //   3: getstatic 1034	kawa/lib/misc:symbol$Qu	Lgnu/expr/ModuleMethod;
    //   6: getstatic 901	com/ftsafe/CCIDScheme:Lit158	Lgnu/mapping/SimpleSymbol;
    //   9: aload_0
    //   10: invokestatic 348	kawa/lib/lists:assoc	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   13: ldc 98
    //   15: invokestatic 101	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   18: dup
    //   19: astore 4
    //   21: checkcast 98	gnu/lists/Pair
    //   24: invokestatic 106	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   27: invokestatic 385	gnu/lists/Sequences:getIterator	(Ljava/lang/Object;)Ljava/util/Iterator;
    //   30: astore_3
    //   31: getstatic 132	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
    //   34: astore 4
    //   36: aconst_null
    //   37: astore 5
    //   39: aload_3
    //   40: invokeinterface 391 1 0
    //   45: ifeq +426 -> 471
    //   48: aload_3
    //   49: invokeinterface 395 1 0
    //   54: astore 6
    //   56: aload 6
    //   58: ldc 98
    //   60: invokestatic 101	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   63: dup
    //   64: astore 9
    //   66: checkcast 98	gnu/lists/Pair
    //   69: invokestatic 118	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   72: pop
    //   73: getstatic 904	com/ftsafe/CCIDScheme:Lit144	Lgnu/mapping/SimpleSymbol;
    //   76: aload 6
    //   78: ldc 98
    //   80: invokestatic 101	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   83: dup
    //   84: astore 9
    //   86: checkcast 98	gnu/lists/Pair
    //   89: invokestatic 106	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   92: invokestatic 348	kawa/lib/lists:assoc	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   95: invokestatic 287	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   98: ifeq +333 -> 431
    //   101: getstatic 276	kawa/standard/Scheme:isEqual	Lgnu/kawa/functions/IsEqual;
    //   104: getstatic 109	com/ftsafe/CCIDScheme:Lit2	Lgnu/math/IntNum;
    //   107: getstatic 190	gnu/kawa/functions/BitwiseOp:and	Lgnu/kawa/functions/BitwiseOp;
    //   110: getstatic 904	com/ftsafe/CCIDScheme:Lit144	Lgnu/mapping/SimpleSymbol;
    //   113: aload 6
    //   115: ldc 98
    //   117: invokestatic 101	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   120: dup
    //   121: astore 9
    //   123: checkcast 98	gnu/lists/Pair
    //   126: invokestatic 106	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   129: invokestatic 348	kawa/lib/lists:assoc	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   132: invokestatic 581	kawa/lib/lists:cadr	(Ljava/lang/Object;)Ljava/lang/Object;
    //   135: getstatic 720	com/ftsafe/CCIDScheme:Lit118	Lgnu/math/IntNum;
    //   138: invokevirtual 28	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   141: invokevirtual 28	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   144: invokestatic 287	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   147: ifeq +284 -> 431
    //   150: aload 6
    //   152: ldc 98
    //   154: invokestatic 101	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   157: dup
    //   158: astore 11
    //   160: checkcast 98	gnu/lists/Pair
    //   163: invokestatic 118	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   166: ldc_w 927
    //   169: invokestatic 101	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   172: dup
    //   173: astore 11
    //   175: checkcast 927	gnu/mapping/Symbol
    //   178: invokestatic 933	kawa/lib/misc:symbol$To$String	(Lgnu/mapping/Symbol;)Ljava/lang/String;
    //   181: invokestatic 937	kawa/lib/strings:string$To$List	(Ljava/lang/CharSequence;)Lgnu/lists/LList;
    //   184: invokestatic 385	gnu/lists/Sequences:getIterator	(Ljava/lang/Object;)Ljava/util/Iterator;
    //   187: astore 10
    //   189: getstatic 132	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
    //   192: astore 11
    //   194: aconst_null
    //   195: astore 12
    //   197: aload 10
    //   199: invokeinterface 391 1 0
    //   204: ifeq +56 -> 260
    //   207: aload 10
    //   209: invokeinterface 395 1 0
    //   214: astore 13
    //   216: new 98	gnu/lists/Pair
    //   219: dup
    //   220: aload 13
    //   222: invokestatic 34	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   225: invokestatic 940	gnu/text/Char:castToCharacter	(Ljava/lang/Object;)I
    //   228: invokestatic 329	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   231: getstatic 132	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
    //   234: invokespecial 404	gnu/lists/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   237: aload 12
    //   239: ifnonnull +9 -> 248
    //   242: dup
    //   243: astore 11
    //   245: goto +10 -> 255
    //   248: aload 12
    //   250: swap
    //   251: dup_x1
    //   252: invokevirtual 408	gnu/lists/Pair:setCdr	(Ljava/lang/Object;)V
    //   255: astore 12
    //   257: goto -60 -> 197
    //   260: aload 11
    //   262: astore 9
    //   264: iconst_1
    //   265: aload 9
    //   267: getstatic 943	com/ftsafe/CCIDScheme:Lit162	Lgnu/math/IntNum;
    //   270: aload 9
    //   272: invokevirtual 946	gnu/lists/LList:size	()I
    //   275: invokestatic 329	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   278: invokestatic 765	com/ftsafe/CCIDScheme:subu8list	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   281: invokestatic 385	gnu/lists/Sequences:getIterator	(Ljava/lang/Object;)Ljava/util/Iterator;
    //   284: astore 11
    //   286: getstatic 132	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
    //   289: astore 12
    //   291: aconst_null
    //   292: astore 13
    //   294: aload 11
    //   296: invokeinterface 391 1 0
    //   301: ifeq +59 -> 360
    //   304: aload 11
    //   306: invokeinterface 395 1 0
    //   311: astore 14
    //   313: new 98	gnu/lists/Pair
    //   316: dup
    //   317: aload 14
    //   319: invokestatic 34	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   322: checkcast 58	java/lang/Number
    //   325: invokevirtual 62	java/lang/Number:intValue	()I
    //   328: invokestatic 401	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   331: getstatic 132	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
    //   334: invokespecial 404	gnu/lists/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   337: aload 13
    //   339: ifnonnull +9 -> 348
    //   342: dup
    //   343: astore 12
    //   345: goto +10 -> 355
    //   348: aload 13
    //   350: swap
    //   351: dup_x1
    //   352: invokevirtual 408	gnu/lists/Pair:setCdr	(Ljava/lang/Object;)V
    //   355: astore 13
    //   357: goto -63 -> 294
    //   360: aload 12
    //   362: invokestatic 412	kawa/lib/strings:list$To$String	(Lgnu/lists/LList;)Ljava/lang/CharSequence;
    //   365: invokestatic 950	kawa/lib/numbers:string$To$Number	(Ljava/lang/CharSequence;)Ljava/lang/Object;
    //   368: getstatic 109	com/ftsafe/CCIDScheme:Lit2	Lgnu/math/IntNum;
    //   371: invokestatic 114	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   374: astore 10
    //   376: aload 10
    //   378: getstatic 587	com/ftsafe/CCIDScheme:Lit99	Lgnu/math/IntNum;
    //   381: invokestatic 599	gnu/kawa/functions/NumberCompare:$Gr$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   384: ifeq +41 -> 425
    //   387: iconst_2
    //   388: anewarray 76	java/lang/Object
    //   391: dup
    //   392: iconst_0
    //   393: ldc_w 514
    //   396: aastore
    //   397: dup
    //   398: iconst_1
    //   399: aload 10
    //   401: ldc 58
    //   403: invokestatic 101	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   406: dup
    //   407: astore 11
    //   409: checkcast 58	java/lang/Number
    //   412: invokestatic 517	kawa/lib/numbers:number$To$String	(Ljava/lang/Number;)Ljava/lang/CharSequence;
    //   415: aastore
    //   416: invokestatic 416	kawa/lib/strings:stringAppend	([Ljava/lang/Object;)Lgnu/lists/FString;
    //   419: invokestatic 523	kawa/lib/misc:string$To$Symbol	(Ljava/lang/CharSequence;)Lgnu/mapping/SimpleSymbol;
    //   422: goto +12 -> 434
    //   425: getstatic 529	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   428: goto +6 -> 434
    //   431: getstatic 529	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   434: astore 8
    //   436: new 98	gnu/lists/Pair
    //   439: dup
    //   440: aload 8
    //   442: getstatic 132	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
    //   445: invokespecial 404	gnu/lists/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   448: aload 5
    //   450: ifnonnull +9 -> 459
    //   453: dup
    //   454: astore 4
    //   456: goto +10 -> 466
    //   459: aload 5
    //   461: swap
    //   462: dup_x1
    //   463: invokevirtual 408	gnu/lists/Pair:setCdr	(Ljava/lang/Object;)V
    //   466: astore 5
    //   468: goto -429 -> 39
    //   471: aload 4
    //   473: invokestatic 339	com/ftsafe/CCIDScheme:filter	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   476: invokestatic 385	gnu/lists/Sequences:getIterator	(Ljava/lang/Object;)Ljava/util/Iterator;
    //   479: astore_2
    //   480: getstatic 132	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
    //   483: astore_3
    //   484: aconst_null
    //   485: astore 4
    //   487: aload_2
    //   488: invokeinterface 391 1 0
    //   493: ifeq +182 -> 675
    //   496: aload_2
    //   497: invokeinterface 395 1 0
    //   502: astore 5
    //   504: new 98	gnu/lists/Pair
    //   507: dup
    //   508: aload 5
    //   510: getstatic 901	com/ftsafe/CCIDScheme:Lit158	Lgnu/mapping/SimpleSymbol;
    //   513: aload_0
    //   514: invokestatic 348	kawa/lib/lists:assoc	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   517: ldc 98
    //   519: invokestatic 101	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   522: dup
    //   523: astore 7
    //   525: checkcast 98	gnu/lists/Pair
    //   528: invokestatic 106	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   531: invokestatic 348	kawa/lib/lists:assoc	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   534: invokestatic 287	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   537: ifeq +107 -> 644
    //   540: getstatic 953	com/ftsafe/CCIDScheme:Lit141	Lgnu/mapping/SimpleSymbol;
    //   543: aload 5
    //   545: getstatic 901	com/ftsafe/CCIDScheme:Lit158	Lgnu/mapping/SimpleSymbol;
    //   548: aload_0
    //   549: invokestatic 348	kawa/lib/lists:assoc	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   552: ldc 98
    //   554: invokestatic 101	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   557: dup
    //   558: astore 7
    //   560: checkcast 98	gnu/lists/Pair
    //   563: invokestatic 106	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   566: invokestatic 348	kawa/lib/lists:assoc	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   569: ldc 98
    //   571: invokestatic 101	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   574: dup
    //   575: astore 7
    //   577: checkcast 98	gnu/lists/Pair
    //   580: invokestatic 106	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   583: invokestatic 348	kawa/lib/lists:assoc	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   586: invokestatic 287	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   589: ifeq +55 -> 644
    //   592: getstatic 953	com/ftsafe/CCIDScheme:Lit141	Lgnu/mapping/SimpleSymbol;
    //   595: aload 5
    //   597: getstatic 901	com/ftsafe/CCIDScheme:Lit158	Lgnu/mapping/SimpleSymbol;
    //   600: aload_0
    //   601: invokestatic 348	kawa/lib/lists:assoc	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   604: ldc 98
    //   606: invokestatic 101	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   609: dup
    //   610: astore 7
    //   612: checkcast 98	gnu/lists/Pair
    //   615: invokestatic 106	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   618: invokestatic 348	kawa/lib/lists:assoc	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   621: ldc 98
    //   623: invokestatic 101	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   626: dup
    //   627: astore 7
    //   629: checkcast 98	gnu/lists/Pair
    //   632: invokestatic 106	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   635: invokestatic 348	kawa/lib/lists:assoc	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   638: invokestatic 581	kawa/lib/lists:cadr	(Ljava/lang/Object;)Ljava/lang/Object;
    //   641: goto +6 -> 647
    //   644: getstatic 529	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   647: getstatic 132	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
    //   650: invokespecial 404	gnu/lists/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   653: aload 4
    //   655: ifnonnull +8 -> 663
    //   658: dup
    //   659: astore_3
    //   660: goto +10 -> 670
    //   663: aload 4
    //   665: swap
    //   666: dup_x1
    //   667: invokevirtual 408	gnu/lists/Pair:setCdr	(Ljava/lang/Object;)V
    //   670: astore 4
    //   672: goto -185 -> 487
    //   675: aload_3
    //   676: invokestatic 339	com/ftsafe/CCIDScheme:filter	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   679: astore_1
    //   680: aload_1
    //   681: invokestatic 90	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
    //   684: ifeq +9 -> 693
    //   687: getstatic 1017	com/ftsafe/CCIDScheme:Lit172	Lgnu/math/IntNum;
    //   690: goto +17 -> 707
    //   693: aload_1
    //   694: ldc 98
    //   696: invokestatic 101	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   699: dup
    //   700: astore_2
    //   701: checkcast 98	gnu/lists/Pair
    //   704: invokestatic 118	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   707: areturn
    //   708: new 66	gnu/mapping/WrongType
    //   711: dup_x1
    //   712: swap
    //   713: ldc 103
    //   715: iconst_1
    //   716: aload 4
    //   718: invokespecial 71	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   721: athrow
    //   722: new 66	gnu/mapping/WrongType
    //   725: dup_x1
    //   726: swap
    //   727: ldc 116
    //   729: iconst_1
    //   730: aload 9
    //   732: invokespecial 71	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   735: athrow
    //   736: new 66	gnu/mapping/WrongType
    //   739: dup_x1
    //   740: swap
    //   741: ldc 103
    //   743: iconst_1
    //   744: aload 9
    //   746: invokespecial 71	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   749: athrow
    //   750: new 66	gnu/mapping/WrongType
    //   753: dup_x1
    //   754: swap
    //   755: ldc 103
    //   757: iconst_1
    //   758: aload 9
    //   760: invokespecial 71	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   763: athrow
    //   764: new 66	gnu/mapping/WrongType
    //   767: dup_x1
    //   768: swap
    //   769: ldc 116
    //   771: iconst_1
    //   772: aload 11
    //   774: invokespecial 71	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   777: athrow
    //   778: new 66	gnu/mapping/WrongType
    //   781: dup_x1
    //   782: swap
    //   783: ldc_w 929
    //   786: iconst_1
    //   787: aload 11
    //   789: invokespecial 71	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   792: athrow
    //   793: new 66	gnu/mapping/WrongType
    //   796: dup_x1
    //   797: swap
    //   798: ldc_w 363
    //   801: iconst_1
    //   802: aload 11
    //   804: invokespecial 71	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   807: athrow
    //   808: new 66	gnu/mapping/WrongType
    //   811: dup_x1
    //   812: swap
    //   813: ldc 103
    //   815: iconst_1
    //   816: aload 7
    //   818: invokespecial 71	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   821: athrow
    //   822: new 66	gnu/mapping/WrongType
    //   825: dup_x1
    //   826: swap
    //   827: ldc 103
    //   829: iconst_1
    //   830: aload 7
    //   832: invokespecial 71	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   835: athrow
    //   836: new 66	gnu/mapping/WrongType
    //   839: dup_x1
    //   840: swap
    //   841: ldc 103
    //   843: iconst_1
    //   844: aload 7
    //   846: invokespecial 71	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   849: athrow
    //   850: new 66	gnu/mapping/WrongType
    //   853: dup_x1
    //   854: swap
    //   855: ldc 103
    //   857: iconst_1
    //   858: aload 7
    //   860: invokespecial 71	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   863: athrow
    //   864: new 66	gnu/mapping/WrongType
    //   867: dup_x1
    //   868: swap
    //   869: ldc 103
    //   871: iconst_1
    //   872: aload 7
    //   874: invokespecial 71	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   877: athrow
    //   878: new 66	gnu/mapping/WrongType
    //   881: dup_x1
    //   882: swap
    //   883: ldc 116
    //   885: iconst_1
    //   886: aload_2
    //   887: invokespecial 71	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   890: athrow
    // Line number table:
    //   Java source line #11249	-> byte code offset #0
    //   Java source line #11250	-> byte code offset #0
    //   Java source line #11251	-> byte code offset #0
    //   Java source line #11252	-> byte code offset #0
    //   Java source line #11253	-> byte code offset #3
    //   Java source line #11258	-> byte code offset #3
    //   Java source line #11259	-> byte code offset #3
    //   Java source line #11260	-> byte code offset #6
    //   Java source line #11271	-> byte code offset #6
    //   Java source line #11261	-> byte code offset #56
    //   Java source line #11262	-> byte code offset #73
    //   Java source line #11263	-> byte code offset #104
    //   Java source line #11264	-> byte code offset #110
    //   Java source line #11265	-> byte code offset #135
    //   Java source line #11266	-> byte code offset #150
    //   Java source line #11267	-> byte code offset #150
    //   Java source line #11268	-> byte code offset #264
    //   Java source line #11269	-> byte code offset #376
    //   Java source line #11270	-> byte code offset #387
    //   Java source line #11255	-> byte code offset #508
    //   Java source line #11256	-> byte code offset #543
    //   Java source line #11257	-> byte code offset #592
    //   Java source line #11272	-> byte code offset #680
    //   Java source line #11274	-> byte code offset #693
    //   Java source line #11271	-> byte code offset #708
    //   Java source line #11261	-> byte code offset #722
    //   Java source line #11262	-> byte code offset #736
    //   Java source line #11264	-> byte code offset #750
    //   Java source line #11267	-> byte code offset #764
    //   Java source line #11270	-> byte code offset #793
    //   Java source line #11255	-> byte code offset #808
    //   Java source line #11256	-> byte code offset #822
    //   Java source line #11257	-> byte code offset #850
    //   Java source line #11274	-> byte code offset #878
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	707	0	atr	Object
    //   680	27	1	ret	Object
    //   264	164	9	s	gnu.lists.LList
    //   376	52	10	n	Object
    // Exception table:
    //   from	to	target	type
    //   21	24	708	java/lang/ClassCastException
    //   66	69	722	java/lang/ClassCastException
    //   86	89	736	java/lang/ClassCastException
    //   123	126	750	java/lang/ClassCastException
    //   160	163	764	java/lang/ClassCastException
    //   175	178	778	java/lang/ClassCastException
    //   409	412	793	java/lang/ClassCastException
    //   525	528	808	java/lang/ClassCastException
    //   560	563	822	java/lang/ClassCastException
    //   577	580	836	java/lang/ClassCastException
    //   612	615	850	java/lang/ClassCastException
    //   629	632	864	java/lang/ClassCastException
    //   701	704	878	java/lang/ClassCastException
  }
  
  /* Error */
  public static Object getAtrTCForT1(Object atr)
  {
    // Byte code:
    //   0: getstatic 1031	kawa/lib/numbers:number$Qu	Lgnu/expr/ModuleMethod;
    //   3: getstatic 1034	kawa/lib/misc:symbol$Qu	Lgnu/expr/ModuleMethod;
    //   6: getstatic 901	com/ftsafe/CCIDScheme:Lit158	Lgnu/mapping/SimpleSymbol;
    //   9: aload_0
    //   10: invokestatic 348	kawa/lib/lists:assoc	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   13: ldc 98
    //   15: invokestatic 101	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   18: dup
    //   19: astore 4
    //   21: checkcast 98	gnu/lists/Pair
    //   24: invokestatic 106	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   27: invokestatic 385	gnu/lists/Sequences:getIterator	(Ljava/lang/Object;)Ljava/util/Iterator;
    //   30: astore_3
    //   31: getstatic 132	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
    //   34: astore 4
    //   36: aconst_null
    //   37: astore 5
    //   39: aload_3
    //   40: invokeinterface 391 1 0
    //   45: ifeq +426 -> 471
    //   48: aload_3
    //   49: invokeinterface 395 1 0
    //   54: astore 6
    //   56: aload 6
    //   58: ldc 98
    //   60: invokestatic 101	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   63: dup
    //   64: astore 9
    //   66: checkcast 98	gnu/lists/Pair
    //   69: invokestatic 118	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   72: pop
    //   73: getstatic 904	com/ftsafe/CCIDScheme:Lit144	Lgnu/mapping/SimpleSymbol;
    //   76: aload 6
    //   78: ldc 98
    //   80: invokestatic 101	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   83: dup
    //   84: astore 9
    //   86: checkcast 98	gnu/lists/Pair
    //   89: invokestatic 106	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   92: invokestatic 348	kawa/lib/lists:assoc	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   95: invokestatic 287	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   98: ifeq +333 -> 431
    //   101: getstatic 276	kawa/standard/Scheme:isEqual	Lgnu/kawa/functions/IsEqual;
    //   104: getstatic 109	com/ftsafe/CCIDScheme:Lit2	Lgnu/math/IntNum;
    //   107: getstatic 190	gnu/kawa/functions/BitwiseOp:and	Lgnu/kawa/functions/BitwiseOp;
    //   110: getstatic 904	com/ftsafe/CCIDScheme:Lit144	Lgnu/mapping/SimpleSymbol;
    //   113: aload 6
    //   115: ldc 98
    //   117: invokestatic 101	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   120: dup
    //   121: astore 9
    //   123: checkcast 98	gnu/lists/Pair
    //   126: invokestatic 106	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   129: invokestatic 348	kawa/lib/lists:assoc	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   132: invokestatic 581	kawa/lib/lists:cadr	(Ljava/lang/Object;)Ljava/lang/Object;
    //   135: getstatic 720	com/ftsafe/CCIDScheme:Lit118	Lgnu/math/IntNum;
    //   138: invokevirtual 28	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   141: invokevirtual 28	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   144: invokestatic 287	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   147: ifeq +284 -> 431
    //   150: aload 6
    //   152: ldc 98
    //   154: invokestatic 101	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   157: dup
    //   158: astore 11
    //   160: checkcast 98	gnu/lists/Pair
    //   163: invokestatic 118	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   166: ldc_w 927
    //   169: invokestatic 101	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   172: dup
    //   173: astore 11
    //   175: checkcast 927	gnu/mapping/Symbol
    //   178: invokestatic 933	kawa/lib/misc:symbol$To$String	(Lgnu/mapping/Symbol;)Ljava/lang/String;
    //   181: invokestatic 937	kawa/lib/strings:string$To$List	(Ljava/lang/CharSequence;)Lgnu/lists/LList;
    //   184: invokestatic 385	gnu/lists/Sequences:getIterator	(Ljava/lang/Object;)Ljava/util/Iterator;
    //   187: astore 10
    //   189: getstatic 132	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
    //   192: astore 11
    //   194: aconst_null
    //   195: astore 12
    //   197: aload 10
    //   199: invokeinterface 391 1 0
    //   204: ifeq +56 -> 260
    //   207: aload 10
    //   209: invokeinterface 395 1 0
    //   214: astore 13
    //   216: new 98	gnu/lists/Pair
    //   219: dup
    //   220: aload 13
    //   222: invokestatic 34	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   225: invokestatic 940	gnu/text/Char:castToCharacter	(Ljava/lang/Object;)I
    //   228: invokestatic 329	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   231: getstatic 132	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
    //   234: invokespecial 404	gnu/lists/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   237: aload 12
    //   239: ifnonnull +9 -> 248
    //   242: dup
    //   243: astore 11
    //   245: goto +10 -> 255
    //   248: aload 12
    //   250: swap
    //   251: dup_x1
    //   252: invokevirtual 408	gnu/lists/Pair:setCdr	(Ljava/lang/Object;)V
    //   255: astore 12
    //   257: goto -60 -> 197
    //   260: aload 11
    //   262: astore 9
    //   264: iconst_1
    //   265: aload 9
    //   267: getstatic 943	com/ftsafe/CCIDScheme:Lit162	Lgnu/math/IntNum;
    //   270: aload 9
    //   272: invokevirtual 946	gnu/lists/LList:size	()I
    //   275: invokestatic 329	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   278: invokestatic 765	com/ftsafe/CCIDScheme:subu8list	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   281: invokestatic 385	gnu/lists/Sequences:getIterator	(Ljava/lang/Object;)Ljava/util/Iterator;
    //   284: astore 11
    //   286: getstatic 132	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
    //   289: astore 12
    //   291: aconst_null
    //   292: astore 13
    //   294: aload 11
    //   296: invokeinterface 391 1 0
    //   301: ifeq +59 -> 360
    //   304: aload 11
    //   306: invokeinterface 395 1 0
    //   311: astore 14
    //   313: new 98	gnu/lists/Pair
    //   316: dup
    //   317: aload 14
    //   319: invokestatic 34	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   322: checkcast 58	java/lang/Number
    //   325: invokevirtual 62	java/lang/Number:intValue	()I
    //   328: invokestatic 401	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   331: getstatic 132	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
    //   334: invokespecial 404	gnu/lists/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   337: aload 13
    //   339: ifnonnull +9 -> 348
    //   342: dup
    //   343: astore 12
    //   345: goto +10 -> 355
    //   348: aload 13
    //   350: swap
    //   351: dup_x1
    //   352: invokevirtual 408	gnu/lists/Pair:setCdr	(Ljava/lang/Object;)V
    //   355: astore 13
    //   357: goto -63 -> 294
    //   360: aload 12
    //   362: invokestatic 412	kawa/lib/strings:list$To$String	(Lgnu/lists/LList;)Ljava/lang/CharSequence;
    //   365: invokestatic 950	kawa/lib/numbers:string$To$Number	(Ljava/lang/CharSequence;)Ljava/lang/Object;
    //   368: getstatic 109	com/ftsafe/CCIDScheme:Lit2	Lgnu/math/IntNum;
    //   371: invokestatic 114	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   374: astore 10
    //   376: aload 10
    //   378: getstatic 587	com/ftsafe/CCIDScheme:Lit99	Lgnu/math/IntNum;
    //   381: invokestatic 599	gnu/kawa/functions/NumberCompare:$Gr$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   384: ifeq +41 -> 425
    //   387: iconst_2
    //   388: anewarray 76	java/lang/Object
    //   391: dup
    //   392: iconst_0
    //   393: ldc_w 514
    //   396: aastore
    //   397: dup
    //   398: iconst_1
    //   399: aload 10
    //   401: ldc 58
    //   403: invokestatic 101	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   406: dup
    //   407: astore 11
    //   409: checkcast 58	java/lang/Number
    //   412: invokestatic 517	kawa/lib/numbers:number$To$String	(Ljava/lang/Number;)Ljava/lang/CharSequence;
    //   415: aastore
    //   416: invokestatic 416	kawa/lib/strings:stringAppend	([Ljava/lang/Object;)Lgnu/lists/FString;
    //   419: invokestatic 523	kawa/lib/misc:string$To$Symbol	(Ljava/lang/CharSequence;)Lgnu/mapping/SimpleSymbol;
    //   422: goto +12 -> 434
    //   425: getstatic 529	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   428: goto +6 -> 434
    //   431: getstatic 529	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   434: astore 8
    //   436: new 98	gnu/lists/Pair
    //   439: dup
    //   440: aload 8
    //   442: getstatic 132	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
    //   445: invokespecial 404	gnu/lists/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   448: aload 5
    //   450: ifnonnull +9 -> 459
    //   453: dup
    //   454: astore 4
    //   456: goto +10 -> 466
    //   459: aload 5
    //   461: swap
    //   462: dup_x1
    //   463: invokevirtual 408	gnu/lists/Pair:setCdr	(Ljava/lang/Object;)V
    //   466: astore 5
    //   468: goto -429 -> 39
    //   471: aload 4
    //   473: invokestatic 339	com/ftsafe/CCIDScheme:filter	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   476: invokestatic 385	gnu/lists/Sequences:getIterator	(Ljava/lang/Object;)Ljava/util/Iterator;
    //   479: astore_2
    //   480: getstatic 132	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
    //   483: astore_3
    //   484: aconst_null
    //   485: astore 4
    //   487: aload_2
    //   488: invokeinterface 391 1 0
    //   493: ifeq +182 -> 675
    //   496: aload_2
    //   497: invokeinterface 395 1 0
    //   502: astore 5
    //   504: new 98	gnu/lists/Pair
    //   507: dup
    //   508: aload 5
    //   510: getstatic 901	com/ftsafe/CCIDScheme:Lit158	Lgnu/mapping/SimpleSymbol;
    //   513: aload_0
    //   514: invokestatic 348	kawa/lib/lists:assoc	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   517: ldc 98
    //   519: invokestatic 101	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   522: dup
    //   523: astore 7
    //   525: checkcast 98	gnu/lists/Pair
    //   528: invokestatic 106	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   531: invokestatic 348	kawa/lib/lists:assoc	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   534: invokestatic 287	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   537: ifeq +107 -> 644
    //   540: getstatic 1037	com/ftsafe/CCIDScheme:Lit143	Lgnu/mapping/SimpleSymbol;
    //   543: aload 5
    //   545: getstatic 901	com/ftsafe/CCIDScheme:Lit158	Lgnu/mapping/SimpleSymbol;
    //   548: aload_0
    //   549: invokestatic 348	kawa/lib/lists:assoc	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   552: ldc 98
    //   554: invokestatic 101	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   557: dup
    //   558: astore 7
    //   560: checkcast 98	gnu/lists/Pair
    //   563: invokestatic 106	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   566: invokestatic 348	kawa/lib/lists:assoc	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   569: ldc 98
    //   571: invokestatic 101	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   574: dup
    //   575: astore 7
    //   577: checkcast 98	gnu/lists/Pair
    //   580: invokestatic 106	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   583: invokestatic 348	kawa/lib/lists:assoc	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   586: invokestatic 287	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   589: ifeq +55 -> 644
    //   592: getstatic 1037	com/ftsafe/CCIDScheme:Lit143	Lgnu/mapping/SimpleSymbol;
    //   595: aload 5
    //   597: getstatic 901	com/ftsafe/CCIDScheme:Lit158	Lgnu/mapping/SimpleSymbol;
    //   600: aload_0
    //   601: invokestatic 348	kawa/lib/lists:assoc	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   604: ldc 98
    //   606: invokestatic 101	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   609: dup
    //   610: astore 7
    //   612: checkcast 98	gnu/lists/Pair
    //   615: invokestatic 106	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   618: invokestatic 348	kawa/lib/lists:assoc	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   621: ldc 98
    //   623: invokestatic 101	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   626: dup
    //   627: astore 7
    //   629: checkcast 98	gnu/lists/Pair
    //   632: invokestatic 106	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   635: invokestatic 348	kawa/lib/lists:assoc	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   638: invokestatic 581	kawa/lib/lists:cadr	(Ljava/lang/Object;)Ljava/lang/Object;
    //   641: goto +6 -> 647
    //   644: getstatic 529	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   647: getstatic 132	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
    //   650: invokespecial 404	gnu/lists/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   653: aload 4
    //   655: ifnonnull +8 -> 663
    //   658: dup
    //   659: astore_3
    //   660: goto +10 -> 670
    //   663: aload 4
    //   665: swap
    //   666: dup_x1
    //   667: invokevirtual 408	gnu/lists/Pair:setCdr	(Ljava/lang/Object;)V
    //   670: astore 4
    //   672: goto -185 -> 487
    //   675: aload_3
    //   676: invokestatic 339	com/ftsafe/CCIDScheme:filter	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   679: astore_1
    //   680: aload_1
    //   681: invokestatic 90	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
    //   684: ifeq +9 -> 693
    //   687: getstatic 247	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   690: goto +17 -> 707
    //   693: aload_1
    //   694: ldc 98
    //   696: invokestatic 101	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   699: dup
    //   700: astore_2
    //   701: checkcast 98	gnu/lists/Pair
    //   704: invokestatic 118	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   707: areturn
    //   708: new 66	gnu/mapping/WrongType
    //   711: dup_x1
    //   712: swap
    //   713: ldc 103
    //   715: iconst_1
    //   716: aload 4
    //   718: invokespecial 71	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   721: athrow
    //   722: new 66	gnu/mapping/WrongType
    //   725: dup_x1
    //   726: swap
    //   727: ldc 116
    //   729: iconst_1
    //   730: aload 9
    //   732: invokespecial 71	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   735: athrow
    //   736: new 66	gnu/mapping/WrongType
    //   739: dup_x1
    //   740: swap
    //   741: ldc 103
    //   743: iconst_1
    //   744: aload 9
    //   746: invokespecial 71	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   749: athrow
    //   750: new 66	gnu/mapping/WrongType
    //   753: dup_x1
    //   754: swap
    //   755: ldc 103
    //   757: iconst_1
    //   758: aload 9
    //   760: invokespecial 71	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   763: athrow
    //   764: new 66	gnu/mapping/WrongType
    //   767: dup_x1
    //   768: swap
    //   769: ldc 116
    //   771: iconst_1
    //   772: aload 11
    //   774: invokespecial 71	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   777: athrow
    //   778: new 66	gnu/mapping/WrongType
    //   781: dup_x1
    //   782: swap
    //   783: ldc_w 929
    //   786: iconst_1
    //   787: aload 11
    //   789: invokespecial 71	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   792: athrow
    //   793: new 66	gnu/mapping/WrongType
    //   796: dup_x1
    //   797: swap
    //   798: ldc_w 363
    //   801: iconst_1
    //   802: aload 11
    //   804: invokespecial 71	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   807: athrow
    //   808: new 66	gnu/mapping/WrongType
    //   811: dup_x1
    //   812: swap
    //   813: ldc 103
    //   815: iconst_1
    //   816: aload 7
    //   818: invokespecial 71	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   821: athrow
    //   822: new 66	gnu/mapping/WrongType
    //   825: dup_x1
    //   826: swap
    //   827: ldc 103
    //   829: iconst_1
    //   830: aload 7
    //   832: invokespecial 71	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   835: athrow
    //   836: new 66	gnu/mapping/WrongType
    //   839: dup_x1
    //   840: swap
    //   841: ldc 103
    //   843: iconst_1
    //   844: aload 7
    //   846: invokespecial 71	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   849: athrow
    //   850: new 66	gnu/mapping/WrongType
    //   853: dup_x1
    //   854: swap
    //   855: ldc 103
    //   857: iconst_1
    //   858: aload 7
    //   860: invokespecial 71	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   863: athrow
    //   864: new 66	gnu/mapping/WrongType
    //   867: dup_x1
    //   868: swap
    //   869: ldc 103
    //   871: iconst_1
    //   872: aload 7
    //   874: invokespecial 71	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   877: athrow
    //   878: new 66	gnu/mapping/WrongType
    //   881: dup_x1
    //   882: swap
    //   883: ldc 116
    //   885: iconst_1
    //   886: aload_2
    //   887: invokespecial 71	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   890: athrow
    // Line number table:
    //   Java source line #11277	-> byte code offset #0
    //   Java source line #11278	-> byte code offset #0
    //   Java source line #11279	-> byte code offset #0
    //   Java source line #11280	-> byte code offset #0
    //   Java source line #11281	-> byte code offset #3
    //   Java source line #11286	-> byte code offset #3
    //   Java source line #11287	-> byte code offset #3
    //   Java source line #11288	-> byte code offset #6
    //   Java source line #11299	-> byte code offset #6
    //   Java source line #11289	-> byte code offset #56
    //   Java source line #11290	-> byte code offset #73
    //   Java source line #11291	-> byte code offset #104
    //   Java source line #11292	-> byte code offset #110
    //   Java source line #11293	-> byte code offset #135
    //   Java source line #11294	-> byte code offset #150
    //   Java source line #11295	-> byte code offset #150
    //   Java source line #11296	-> byte code offset #264
    //   Java source line #11297	-> byte code offset #376
    //   Java source line #11298	-> byte code offset #387
    //   Java source line #11283	-> byte code offset #508
    //   Java source line #11284	-> byte code offset #543
    //   Java source line #11285	-> byte code offset #592
    //   Java source line #11300	-> byte code offset #680
    //   Java source line #11302	-> byte code offset #693
    //   Java source line #11299	-> byte code offset #708
    //   Java source line #11289	-> byte code offset #722
    //   Java source line #11290	-> byte code offset #736
    //   Java source line #11292	-> byte code offset #750
    //   Java source line #11295	-> byte code offset #764
    //   Java source line #11298	-> byte code offset #793
    //   Java source line #11283	-> byte code offset #808
    //   Java source line #11284	-> byte code offset #822
    //   Java source line #11285	-> byte code offset #850
    //   Java source line #11302	-> byte code offset #878
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	707	0	atr	Object
    //   680	27	1	ret	Object
    //   264	164	9	s	gnu.lists.LList
    //   376	52	10	n	Object
    // Exception table:
    //   from	to	target	type
    //   21	24	708	java/lang/ClassCastException
    //   66	69	722	java/lang/ClassCastException
    //   86	89	736	java/lang/ClassCastException
    //   123	126	750	java/lang/ClassCastException
    //   160	163	764	java/lang/ClassCastException
    //   175	178	778	java/lang/ClassCastException
    //   409	412	793	java/lang/ClassCastException
    //   525	528	808	java/lang/ClassCastException
    //   560	563	822	java/lang/ClassCastException
    //   577	580	836	java/lang/ClassCastException
    //   612	615	850	java/lang/ClassCastException
    //   629	632	864	java/lang/ClassCastException
    //   701	704	878	java/lang/ClassCastException
  }
  
  /* Error */
  public static Object getAtrTBForT1(Object atr)
  {
    // Byte code:
    //   0: getstatic 1031	kawa/lib/numbers:number$Qu	Lgnu/expr/ModuleMethod;
    //   3: getstatic 1034	kawa/lib/misc:symbol$Qu	Lgnu/expr/ModuleMethod;
    //   6: getstatic 901	com/ftsafe/CCIDScheme:Lit158	Lgnu/mapping/SimpleSymbol;
    //   9: aload_0
    //   10: invokestatic 348	kawa/lib/lists:assoc	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   13: ldc 98
    //   15: invokestatic 101	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   18: dup
    //   19: astore 4
    //   21: checkcast 98	gnu/lists/Pair
    //   24: invokestatic 106	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   27: invokestatic 385	gnu/lists/Sequences:getIterator	(Ljava/lang/Object;)Ljava/util/Iterator;
    //   30: astore_3
    //   31: getstatic 132	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
    //   34: astore 4
    //   36: aconst_null
    //   37: astore 5
    //   39: aload_3
    //   40: invokeinterface 391 1 0
    //   45: ifeq +426 -> 471
    //   48: aload_3
    //   49: invokeinterface 395 1 0
    //   54: astore 6
    //   56: aload 6
    //   58: ldc 98
    //   60: invokestatic 101	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   63: dup
    //   64: astore 9
    //   66: checkcast 98	gnu/lists/Pair
    //   69: invokestatic 118	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   72: pop
    //   73: getstatic 904	com/ftsafe/CCIDScheme:Lit144	Lgnu/mapping/SimpleSymbol;
    //   76: aload 6
    //   78: ldc 98
    //   80: invokestatic 101	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   83: dup
    //   84: astore 9
    //   86: checkcast 98	gnu/lists/Pair
    //   89: invokestatic 106	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   92: invokestatic 348	kawa/lib/lists:assoc	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   95: invokestatic 287	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   98: ifeq +333 -> 431
    //   101: getstatic 276	kawa/standard/Scheme:isEqual	Lgnu/kawa/functions/IsEqual;
    //   104: getstatic 109	com/ftsafe/CCIDScheme:Lit2	Lgnu/math/IntNum;
    //   107: getstatic 190	gnu/kawa/functions/BitwiseOp:and	Lgnu/kawa/functions/BitwiseOp;
    //   110: getstatic 904	com/ftsafe/CCIDScheme:Lit144	Lgnu/mapping/SimpleSymbol;
    //   113: aload 6
    //   115: ldc 98
    //   117: invokestatic 101	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   120: dup
    //   121: astore 9
    //   123: checkcast 98	gnu/lists/Pair
    //   126: invokestatic 106	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   129: invokestatic 348	kawa/lib/lists:assoc	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   132: invokestatic 581	kawa/lib/lists:cadr	(Ljava/lang/Object;)Ljava/lang/Object;
    //   135: getstatic 720	com/ftsafe/CCIDScheme:Lit118	Lgnu/math/IntNum;
    //   138: invokevirtual 28	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   141: invokevirtual 28	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   144: invokestatic 287	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   147: ifeq +284 -> 431
    //   150: aload 6
    //   152: ldc 98
    //   154: invokestatic 101	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   157: dup
    //   158: astore 11
    //   160: checkcast 98	gnu/lists/Pair
    //   163: invokestatic 118	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   166: ldc_w 927
    //   169: invokestatic 101	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   172: dup
    //   173: astore 11
    //   175: checkcast 927	gnu/mapping/Symbol
    //   178: invokestatic 933	kawa/lib/misc:symbol$To$String	(Lgnu/mapping/Symbol;)Ljava/lang/String;
    //   181: invokestatic 937	kawa/lib/strings:string$To$List	(Ljava/lang/CharSequence;)Lgnu/lists/LList;
    //   184: invokestatic 385	gnu/lists/Sequences:getIterator	(Ljava/lang/Object;)Ljava/util/Iterator;
    //   187: astore 10
    //   189: getstatic 132	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
    //   192: astore 11
    //   194: aconst_null
    //   195: astore 12
    //   197: aload 10
    //   199: invokeinterface 391 1 0
    //   204: ifeq +56 -> 260
    //   207: aload 10
    //   209: invokeinterface 395 1 0
    //   214: astore 13
    //   216: new 98	gnu/lists/Pair
    //   219: dup
    //   220: aload 13
    //   222: invokestatic 34	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   225: invokestatic 940	gnu/text/Char:castToCharacter	(Ljava/lang/Object;)I
    //   228: invokestatic 329	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   231: getstatic 132	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
    //   234: invokespecial 404	gnu/lists/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   237: aload 12
    //   239: ifnonnull +9 -> 248
    //   242: dup
    //   243: astore 11
    //   245: goto +10 -> 255
    //   248: aload 12
    //   250: swap
    //   251: dup_x1
    //   252: invokevirtual 408	gnu/lists/Pair:setCdr	(Ljava/lang/Object;)V
    //   255: astore 12
    //   257: goto -60 -> 197
    //   260: aload 11
    //   262: astore 9
    //   264: iconst_1
    //   265: aload 9
    //   267: getstatic 943	com/ftsafe/CCIDScheme:Lit162	Lgnu/math/IntNum;
    //   270: aload 9
    //   272: invokevirtual 946	gnu/lists/LList:size	()I
    //   275: invokestatic 329	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   278: invokestatic 765	com/ftsafe/CCIDScheme:subu8list	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   281: invokestatic 385	gnu/lists/Sequences:getIterator	(Ljava/lang/Object;)Ljava/util/Iterator;
    //   284: astore 11
    //   286: getstatic 132	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
    //   289: astore 12
    //   291: aconst_null
    //   292: astore 13
    //   294: aload 11
    //   296: invokeinterface 391 1 0
    //   301: ifeq +59 -> 360
    //   304: aload 11
    //   306: invokeinterface 395 1 0
    //   311: astore 14
    //   313: new 98	gnu/lists/Pair
    //   316: dup
    //   317: aload 14
    //   319: invokestatic 34	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   322: checkcast 58	java/lang/Number
    //   325: invokevirtual 62	java/lang/Number:intValue	()I
    //   328: invokestatic 401	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   331: getstatic 132	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
    //   334: invokespecial 404	gnu/lists/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   337: aload 13
    //   339: ifnonnull +9 -> 348
    //   342: dup
    //   343: astore 12
    //   345: goto +10 -> 355
    //   348: aload 13
    //   350: swap
    //   351: dup_x1
    //   352: invokevirtual 408	gnu/lists/Pair:setCdr	(Ljava/lang/Object;)V
    //   355: astore 13
    //   357: goto -63 -> 294
    //   360: aload 12
    //   362: invokestatic 412	kawa/lib/strings:list$To$String	(Lgnu/lists/LList;)Ljava/lang/CharSequence;
    //   365: invokestatic 950	kawa/lib/numbers:string$To$Number	(Ljava/lang/CharSequence;)Ljava/lang/Object;
    //   368: getstatic 109	com/ftsafe/CCIDScheme:Lit2	Lgnu/math/IntNum;
    //   371: invokestatic 114	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   374: astore 10
    //   376: aload 10
    //   378: getstatic 587	com/ftsafe/CCIDScheme:Lit99	Lgnu/math/IntNum;
    //   381: invokestatic 599	gnu/kawa/functions/NumberCompare:$Gr$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   384: ifeq +41 -> 425
    //   387: iconst_2
    //   388: anewarray 76	java/lang/Object
    //   391: dup
    //   392: iconst_0
    //   393: ldc_w 514
    //   396: aastore
    //   397: dup
    //   398: iconst_1
    //   399: aload 10
    //   401: ldc 58
    //   403: invokestatic 101	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   406: dup
    //   407: astore 11
    //   409: checkcast 58	java/lang/Number
    //   412: invokestatic 517	kawa/lib/numbers:number$To$String	(Ljava/lang/Number;)Ljava/lang/CharSequence;
    //   415: aastore
    //   416: invokestatic 416	kawa/lib/strings:stringAppend	([Ljava/lang/Object;)Lgnu/lists/FString;
    //   419: invokestatic 523	kawa/lib/misc:string$To$Symbol	(Ljava/lang/CharSequence;)Lgnu/mapping/SimpleSymbol;
    //   422: goto +12 -> 434
    //   425: getstatic 529	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   428: goto +6 -> 434
    //   431: getstatic 529	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   434: astore 8
    //   436: new 98	gnu/lists/Pair
    //   439: dup
    //   440: aload 8
    //   442: getstatic 132	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
    //   445: invokespecial 404	gnu/lists/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   448: aload 5
    //   450: ifnonnull +9 -> 459
    //   453: dup
    //   454: astore 4
    //   456: goto +10 -> 466
    //   459: aload 5
    //   461: swap
    //   462: dup_x1
    //   463: invokevirtual 408	gnu/lists/Pair:setCdr	(Ljava/lang/Object;)V
    //   466: astore 5
    //   468: goto -429 -> 39
    //   471: aload 4
    //   473: invokestatic 339	com/ftsafe/CCIDScheme:filter	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   476: invokestatic 385	gnu/lists/Sequences:getIterator	(Ljava/lang/Object;)Ljava/util/Iterator;
    //   479: astore_2
    //   480: getstatic 132	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
    //   483: astore_3
    //   484: aconst_null
    //   485: astore 4
    //   487: aload_2
    //   488: invokeinterface 391 1 0
    //   493: ifeq +182 -> 675
    //   496: aload_2
    //   497: invokeinterface 395 1 0
    //   502: astore 5
    //   504: new 98	gnu/lists/Pair
    //   507: dup
    //   508: aload 5
    //   510: getstatic 901	com/ftsafe/CCIDScheme:Lit158	Lgnu/mapping/SimpleSymbol;
    //   513: aload_0
    //   514: invokestatic 348	kawa/lib/lists:assoc	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   517: ldc 98
    //   519: invokestatic 101	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   522: dup
    //   523: astore 7
    //   525: checkcast 98	gnu/lists/Pair
    //   528: invokestatic 106	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   531: invokestatic 348	kawa/lib/lists:assoc	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   534: invokestatic 287	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   537: ifeq +107 -> 644
    //   540: getstatic 956	com/ftsafe/CCIDScheme:Lit142	Lgnu/mapping/SimpleSymbol;
    //   543: aload 5
    //   545: getstatic 901	com/ftsafe/CCIDScheme:Lit158	Lgnu/mapping/SimpleSymbol;
    //   548: aload_0
    //   549: invokestatic 348	kawa/lib/lists:assoc	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   552: ldc 98
    //   554: invokestatic 101	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   557: dup
    //   558: astore 7
    //   560: checkcast 98	gnu/lists/Pair
    //   563: invokestatic 106	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   566: invokestatic 348	kawa/lib/lists:assoc	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   569: ldc 98
    //   571: invokestatic 101	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   574: dup
    //   575: astore 7
    //   577: checkcast 98	gnu/lists/Pair
    //   580: invokestatic 106	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   583: invokestatic 348	kawa/lib/lists:assoc	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   586: invokestatic 287	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   589: ifeq +55 -> 644
    //   592: getstatic 956	com/ftsafe/CCIDScheme:Lit142	Lgnu/mapping/SimpleSymbol;
    //   595: aload 5
    //   597: getstatic 901	com/ftsafe/CCIDScheme:Lit158	Lgnu/mapping/SimpleSymbol;
    //   600: aload_0
    //   601: invokestatic 348	kawa/lib/lists:assoc	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   604: ldc 98
    //   606: invokestatic 101	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   609: dup
    //   610: astore 7
    //   612: checkcast 98	gnu/lists/Pair
    //   615: invokestatic 106	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   618: invokestatic 348	kawa/lib/lists:assoc	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   621: ldc 98
    //   623: invokestatic 101	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   626: dup
    //   627: astore 7
    //   629: checkcast 98	gnu/lists/Pair
    //   632: invokestatic 106	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   635: invokestatic 348	kawa/lib/lists:assoc	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   638: invokestatic 581	kawa/lib/lists:cadr	(Ljava/lang/Object;)Ljava/lang/Object;
    //   641: goto +6 -> 647
    //   644: getstatic 529	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   647: getstatic 132	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
    //   650: invokespecial 404	gnu/lists/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   653: aload 4
    //   655: ifnonnull +8 -> 663
    //   658: dup
    //   659: astore_3
    //   660: goto +10 -> 670
    //   663: aload 4
    //   665: swap
    //   666: dup_x1
    //   667: invokevirtual 408	gnu/lists/Pair:setCdr	(Ljava/lang/Object;)V
    //   670: astore 4
    //   672: goto -185 -> 487
    //   675: aload_3
    //   676: invokestatic 339	com/ftsafe/CCIDScheme:filter	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   679: astore_1
    //   680: aload_1
    //   681: invokestatic 90	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
    //   684: ifeq +9 -> 693
    //   687: getstatic 247	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   690: goto +17 -> 707
    //   693: aload_1
    //   694: ldc 98
    //   696: invokestatic 101	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   699: dup
    //   700: astore_2
    //   701: checkcast 98	gnu/lists/Pair
    //   704: invokestatic 118	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   707: areturn
    //   708: new 66	gnu/mapping/WrongType
    //   711: dup_x1
    //   712: swap
    //   713: ldc 103
    //   715: iconst_1
    //   716: aload 4
    //   718: invokespecial 71	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   721: athrow
    //   722: new 66	gnu/mapping/WrongType
    //   725: dup_x1
    //   726: swap
    //   727: ldc 116
    //   729: iconst_1
    //   730: aload 9
    //   732: invokespecial 71	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   735: athrow
    //   736: new 66	gnu/mapping/WrongType
    //   739: dup_x1
    //   740: swap
    //   741: ldc 103
    //   743: iconst_1
    //   744: aload 9
    //   746: invokespecial 71	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   749: athrow
    //   750: new 66	gnu/mapping/WrongType
    //   753: dup_x1
    //   754: swap
    //   755: ldc 103
    //   757: iconst_1
    //   758: aload 9
    //   760: invokespecial 71	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   763: athrow
    //   764: new 66	gnu/mapping/WrongType
    //   767: dup_x1
    //   768: swap
    //   769: ldc 116
    //   771: iconst_1
    //   772: aload 11
    //   774: invokespecial 71	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   777: athrow
    //   778: new 66	gnu/mapping/WrongType
    //   781: dup_x1
    //   782: swap
    //   783: ldc_w 929
    //   786: iconst_1
    //   787: aload 11
    //   789: invokespecial 71	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   792: athrow
    //   793: new 66	gnu/mapping/WrongType
    //   796: dup_x1
    //   797: swap
    //   798: ldc_w 363
    //   801: iconst_1
    //   802: aload 11
    //   804: invokespecial 71	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   807: athrow
    //   808: new 66	gnu/mapping/WrongType
    //   811: dup_x1
    //   812: swap
    //   813: ldc 103
    //   815: iconst_1
    //   816: aload 7
    //   818: invokespecial 71	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   821: athrow
    //   822: new 66	gnu/mapping/WrongType
    //   825: dup_x1
    //   826: swap
    //   827: ldc 103
    //   829: iconst_1
    //   830: aload 7
    //   832: invokespecial 71	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   835: athrow
    //   836: new 66	gnu/mapping/WrongType
    //   839: dup_x1
    //   840: swap
    //   841: ldc 103
    //   843: iconst_1
    //   844: aload 7
    //   846: invokespecial 71	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   849: athrow
    //   850: new 66	gnu/mapping/WrongType
    //   853: dup_x1
    //   854: swap
    //   855: ldc 103
    //   857: iconst_1
    //   858: aload 7
    //   860: invokespecial 71	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   863: athrow
    //   864: new 66	gnu/mapping/WrongType
    //   867: dup_x1
    //   868: swap
    //   869: ldc 103
    //   871: iconst_1
    //   872: aload 7
    //   874: invokespecial 71	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   877: athrow
    //   878: new 66	gnu/mapping/WrongType
    //   881: dup_x1
    //   882: swap
    //   883: ldc 116
    //   885: iconst_1
    //   886: aload_2
    //   887: invokespecial 71	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   890: athrow
    // Line number table:
    //   Java source line #11306	-> byte code offset #0
    //   Java source line #11307	-> byte code offset #0
    //   Java source line #11308	-> byte code offset #0
    //   Java source line #11309	-> byte code offset #0
    //   Java source line #11310	-> byte code offset #3
    //   Java source line #11315	-> byte code offset #3
    //   Java source line #11316	-> byte code offset #3
    //   Java source line #11317	-> byte code offset #6
    //   Java source line #11328	-> byte code offset #6
    //   Java source line #11318	-> byte code offset #56
    //   Java source line #11319	-> byte code offset #73
    //   Java source line #11320	-> byte code offset #104
    //   Java source line #11321	-> byte code offset #110
    //   Java source line #11322	-> byte code offset #135
    //   Java source line #11323	-> byte code offset #150
    //   Java source line #11324	-> byte code offset #150
    //   Java source line #11325	-> byte code offset #264
    //   Java source line #11326	-> byte code offset #376
    //   Java source line #11327	-> byte code offset #387
    //   Java source line #11312	-> byte code offset #508
    //   Java source line #11313	-> byte code offset #543
    //   Java source line #11314	-> byte code offset #592
    //   Java source line #11329	-> byte code offset #680
    //   Java source line #11331	-> byte code offset #693
    //   Java source line #11328	-> byte code offset #708
    //   Java source line #11318	-> byte code offset #722
    //   Java source line #11319	-> byte code offset #736
    //   Java source line #11321	-> byte code offset #750
    //   Java source line #11324	-> byte code offset #764
    //   Java source line #11327	-> byte code offset #793
    //   Java source line #11312	-> byte code offset #808
    //   Java source line #11313	-> byte code offset #822
    //   Java source line #11314	-> byte code offset #850
    //   Java source line #11331	-> byte code offset #878
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	707	0	atr	Object
    //   680	27	1	ret	Object
    //   264	164	9	s	gnu.lists.LList
    //   376	52	10	n	Object
    // Exception table:
    //   from	to	target	type
    //   21	24	708	java/lang/ClassCastException
    //   66	69	722	java/lang/ClassCastException
    //   86	89	736	java/lang/ClassCastException
    //   123	126	750	java/lang/ClassCastException
    //   160	163	764	java/lang/ClassCastException
    //   175	178	778	java/lang/ClassCastException
    //   409	412	793	java/lang/ClassCastException
    //   525	528	808	java/lang/ClassCastException
    //   560	563	822	java/lang/ClassCastException
    //   577	580	836	java/lang/ClassCastException
    //   612	615	850	java/lang/ClassCastException
    //   629	632	864	java/lang/ClassCastException
    //   701	704	878	java/lang/ClassCastException
  }
  
  /* Error */
  public static gnu.lists.Pair generatePPSParametersT0(Object atr)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 1040	com/ftsafe/CCIDScheme:generatePPSExchange	(Ljava/lang/Object;)Ljava/lang/Object;
    //   4: astore_1
    //   5: getstatic 276	kawa/standard/Scheme:isEqual	Lgnu/kawa/functions/IsEqual;
    //   8: getstatic 190	gnu/kawa/functions/BitwiseOp:and	Lgnu/kawa/functions/BitwiseOp;
    //   11: aload_1
    //   12: iconst_1
    //   13: invokestatic 159	kawa/lib/lists:listRef	(Ljava/lang/Object;I)Ljava/lang/Object;
    //   16: getstatic 165	com/ftsafe/CCIDScheme:Lit6	Lgnu/math/IntNum;
    //   19: invokevirtual 28	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   22: getstatic 165	com/ftsafe/CCIDScheme:Lit6	Lgnu/math/IntNum;
    //   25: invokevirtual 28	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   28: invokestatic 287	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   31: ifeq +11 -> 42
    //   34: aload_1
    //   35: iconst_2
    //   36: invokestatic 159	kawa/lib/lists:listRef	(Ljava/lang/Object;I)Ljava/lang/Object;
    //   39: goto +6 -> 45
    //   42: getstatic 1011	com/ftsafe/CCIDScheme:Lit171	Lgnu/math/IntNum;
    //   45: astore_2
    //   46: getstatic 52	com/ftsafe/CCIDScheme:Lit1	Lgnu/math/IntNum;
    //   49: getstatic 276	kawa/standard/Scheme:isEqual	Lgnu/kawa/functions/IsEqual;
    //   52: getstatic 1046	com/ftsafe/CCIDScheme:Lit146	Lgnu/mapping/SimpleSymbol;
    //   55: aload_0
    //   56: invokestatic 348	kawa/lib/lists:assoc	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   59: invokestatic 581	kawa/lib/lists:cadr	(Ljava/lang/Object;)Ljava/lang/Object;
    //   62: getstatic 1049	com/ftsafe/CCIDScheme:Lit173	Lgnu/math/IntNum;
    //   65: invokevirtual 28	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   68: invokestatic 287	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   71: ifeq +9 -> 80
    //   74: getstatic 52	com/ftsafe/CCIDScheme:Lit1	Lgnu/math/IntNum;
    //   77: goto +6 -> 83
    //   80: getstatic 357	com/ftsafe/CCIDScheme:Lit16	Lgnu/math/IntNum;
    //   83: invokestatic 1022	gnu/math/BitOps:ior	(Lgnu/math/IntNum;Lgnu/math/IntNum;)Lgnu/math/IntNum;
    //   86: astore_3
    //   87: getstatic 1037	com/ftsafe/CCIDScheme:Lit143	Lgnu/mapping/SimpleSymbol;
    //   90: getstatic 971	com/ftsafe/CCIDScheme:Lit165	Lgnu/mapping/SimpleSymbol;
    //   93: getstatic 901	com/ftsafe/CCIDScheme:Lit158	Lgnu/mapping/SimpleSymbol;
    //   96: aload_0
    //   97: invokestatic 922	com/ftsafe/CCIDScheme:assocEX	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   100: invokestatic 922	com/ftsafe/CCIDScheme:assocEX	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   103: invokestatic 922	com/ftsafe/CCIDScheme:assocEX	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   106: invokestatic 287	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   109: ifeq +39 -> 148
    //   112: getstatic 1037	com/ftsafe/CCIDScheme:Lit143	Lgnu/mapping/SimpleSymbol;
    //   115: getstatic 971	com/ftsafe/CCIDScheme:Lit165	Lgnu/mapping/SimpleSymbol;
    //   118: getstatic 901	com/ftsafe/CCIDScheme:Lit158	Lgnu/mapping/SimpleSymbol;
    //   121: aload_0
    //   122: invokestatic 922	com/ftsafe/CCIDScheme:assocEX	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   125: invokestatic 922	com/ftsafe/CCIDScheme:assocEX	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   128: invokestatic 922	com/ftsafe/CCIDScheme:assocEX	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   131: ldc 98
    //   133: invokestatic 101	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   136: dup
    //   137: astore 5
    //   139: checkcast 98	gnu/lists/Pair
    //   142: invokestatic 118	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   145: goto +6 -> 151
    //   148: getstatic 52	com/ftsafe/CCIDScheme:Lit1	Lgnu/math/IntNum;
    //   151: astore 4
    //   153: getstatic 1037	com/ftsafe/CCIDScheme:Lit143	Lgnu/mapping/SimpleSymbol;
    //   156: getstatic 995	com/ftsafe/CCIDScheme:Lit168	Lgnu/mapping/SimpleSymbol;
    //   159: getstatic 901	com/ftsafe/CCIDScheme:Lit158	Lgnu/mapping/SimpleSymbol;
    //   162: aload_0
    //   163: invokestatic 922	com/ftsafe/CCIDScheme:assocEX	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   166: invokestatic 922	com/ftsafe/CCIDScheme:assocEX	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   169: invokestatic 922	com/ftsafe/CCIDScheme:assocEX	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   172: invokestatic 287	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   175: ifeq +39 -> 214
    //   178: getstatic 1037	com/ftsafe/CCIDScheme:Lit143	Lgnu/mapping/SimpleSymbol;
    //   181: getstatic 995	com/ftsafe/CCIDScheme:Lit168	Lgnu/mapping/SimpleSymbol;
    //   184: getstatic 901	com/ftsafe/CCIDScheme:Lit158	Lgnu/mapping/SimpleSymbol;
    //   187: aload_0
    //   188: invokestatic 922	com/ftsafe/CCIDScheme:assocEX	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   191: invokestatic 922	com/ftsafe/CCIDScheme:assocEX	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   194: invokestatic 922	com/ftsafe/CCIDScheme:assocEX	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   197: ldc 98
    //   199: invokestatic 101	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   202: dup
    //   203: astore 6
    //   205: checkcast 98	gnu/lists/Pair
    //   208: invokestatic 118	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   211: goto +6 -> 217
    //   214: getstatic 695	com/ftsafe/CCIDScheme:Lit114	Lgnu/math/IntNum;
    //   217: astore 5
    //   219: aload_2
    //   220: invokestatic 261	gnu/lists/LList:list1	(Ljava/lang/Object;)Lgnu/lists/Pair;
    //   223: dup
    //   224: aload_3
    //   225: aload 4
    //   227: aload 5
    //   229: getstatic 52	com/ftsafe/CCIDScheme:Lit1	Lgnu/math/IntNum;
    //   232: invokestatic 799	gnu/lists/LList:chain4	(Lgnu/lists/Pair;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   235: pop
    //   236: areturn
    //   237: new 66	gnu/mapping/WrongType
    //   240: dup_x1
    //   241: swap
    //   242: ldc 116
    //   244: iconst_1
    //   245: aload 5
    //   247: invokespecial 71	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   250: athrow
    //   251: new 66	gnu/mapping/WrongType
    //   254: dup_x1
    //   255: swap
    //   256: ldc 116
    //   258: iconst_1
    //   259: aload 6
    //   261: invokespecial 71	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   264: athrow
    // Line number table:
    //   Java source line #11371	-> byte code offset #0
    //   Java source line #11372	-> byte code offset #0
    //   Java source line #11373	-> byte code offset #5
    //   Java source line #11374	-> byte code offset #34
    //   Java source line #11373	-> byte code offset #42
    //   Java source line #11376	-> byte code offset #46
    //   Java source line #11377	-> byte code offset #52
    //   Java source line #11373	-> byte code offset #87
    //   Java source line #11380	-> byte code offset #87
    //   Java source line #11381	-> byte code offset #112
    //   Java source line #11380	-> byte code offset #148
    //   Java source line #11373	-> byte code offset #153
    //   Java source line #11383	-> byte code offset #153
    //   Java source line #11384	-> byte code offset #178
    //   Java source line #11383	-> byte code offset #214
    //   Java source line #11373	-> byte code offset #219
    //   Java source line #11386	-> byte code offset #219
    //   Java source line #11387	-> byte code offset #219
    //   Java source line #11381	-> byte code offset #237
    //   Java source line #11384	-> byte code offset #251
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	236	0	atr	Object
    //   4	31	1	pps	Object
    //   45	175	2	bmFindexDindex	Object
    //   86	139	3	bmTCCKST0	gnu.math.IntNum
    //   151	75	4	bGuardTimeT0	Object
    //   137	1	5	localObject1	Object
    //   217	29	5	bmWaitingIntegersT0	Object
    //   203	57	6	localObject2	Object
    //   237	1	8	localClassCastException1	ClassCastException
    //   251	1	9	localClassCastException2	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   139	142	237	java/lang/ClassCastException
    //   205	208	251	java/lang/ClassCastException
  }
  
  /* Error */
  public static gnu.math.IntNum getCardTimeoutT1(Object atr)
  {
    // Byte code:
    //   0: getstatic 953	com/ftsafe/CCIDScheme:Lit141	Lgnu/mapping/SimpleSymbol;
    //   3: getstatic 971	com/ftsafe/CCIDScheme:Lit165	Lgnu/mapping/SimpleSymbol;
    //   6: getstatic 901	com/ftsafe/CCIDScheme:Lit158	Lgnu/mapping/SimpleSymbol;
    //   9: aload_0
    //   10: invokestatic 922	com/ftsafe/CCIDScheme:assocEX	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   13: invokestatic 922	com/ftsafe/CCIDScheme:assocEX	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   16: invokestatic 922	com/ftsafe/CCIDScheme:assocEX	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   19: invokestatic 287	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   22: ifeq +38 -> 60
    //   25: getstatic 953	com/ftsafe/CCIDScheme:Lit141	Lgnu/mapping/SimpleSymbol;
    //   28: getstatic 971	com/ftsafe/CCIDScheme:Lit165	Lgnu/mapping/SimpleSymbol;
    //   31: getstatic 901	com/ftsafe/CCIDScheme:Lit158	Lgnu/mapping/SimpleSymbol;
    //   34: aload_0
    //   35: invokestatic 922	com/ftsafe/CCIDScheme:assocEX	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   38: invokestatic 922	com/ftsafe/CCIDScheme:assocEX	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   41: invokestatic 922	com/ftsafe/CCIDScheme:assocEX	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   44: ldc 98
    //   46: invokestatic 101	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   49: dup
    //   50: astore_2
    //   51: checkcast 98	gnu/lists/Pair
    //   54: invokestatic 118	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   57: goto +6 -> 63
    //   60: getstatic 247	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   63: invokestatic 974	com/ftsafe/CCIDScheme:parseAtrTA1	(Ljava/lang/Object;)Lgnu/lists/Pair;
    //   66: astore_1
    //   67: getstatic 880	com/ftsafe/CCIDScheme:Lit152	Lgnu/mapping/SimpleSymbol;
    //   70: aload_1
    //   71: invokestatic 348	kawa/lib/lists:assoc	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   74: invokestatic 581	kawa/lib/lists:cadr	(Ljava/lang/Object;)Ljava/lang/Object;
    //   77: astore_2
    //   78: getstatic 886	com/ftsafe/CCIDScheme:Lit154	Lgnu/mapping/SimpleSymbol;
    //   81: aload_1
    //   82: invokestatic 348	kawa/lib/lists:assoc	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   85: invokestatic 581	kawa/lib/lists:cadr	(Ljava/lang/Object;)Ljava/lang/Object;
    //   88: astore_3
    //   89: getstatic 1037	com/ftsafe/CCIDScheme:Lit143	Lgnu/mapping/SimpleSymbol;
    //   92: getstatic 971	com/ftsafe/CCIDScheme:Lit165	Lgnu/mapping/SimpleSymbol;
    //   95: getstatic 901	com/ftsafe/CCIDScheme:Lit158	Lgnu/mapping/SimpleSymbol;
    //   98: aload_0
    //   99: invokestatic 922	com/ftsafe/CCIDScheme:assocEX	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   102: invokestatic 922	com/ftsafe/CCIDScheme:assocEX	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   105: invokestatic 922	com/ftsafe/CCIDScheme:assocEX	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   108: invokestatic 287	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   111: ifeq +39 -> 150
    //   114: getstatic 1037	com/ftsafe/CCIDScheme:Lit143	Lgnu/mapping/SimpleSymbol;
    //   117: getstatic 971	com/ftsafe/CCIDScheme:Lit165	Lgnu/mapping/SimpleSymbol;
    //   120: getstatic 901	com/ftsafe/CCIDScheme:Lit158	Lgnu/mapping/SimpleSymbol;
    //   123: aload_0
    //   124: invokestatic 922	com/ftsafe/CCIDScheme:assocEX	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   127: invokestatic 922	com/ftsafe/CCIDScheme:assocEX	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   130: invokestatic 922	com/ftsafe/CCIDScheme:assocEX	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   133: ldc 98
    //   135: invokestatic 101	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   138: dup
    //   139: astore 5
    //   141: checkcast 98	gnu/lists/Pair
    //   144: invokestatic 118	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   147: goto +6 -> 153
    //   150: getstatic 52	com/ftsafe/CCIDScheme:Lit1	Lgnu/math/IntNum;
    //   153: astore 4
    //   155: aload_0
    //   156: invokestatic 1052	com/ftsafe/CCIDScheme:getAtrTBForT1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   159: invokestatic 287	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   162: ifeq +10 -> 172
    //   165: aload_0
    //   166: invokestatic 1052	com/ftsafe/CCIDScheme:getAtrTBForT1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   169: goto +6 -> 175
    //   172: getstatic 1055	com/ftsafe/CCIDScheme:Lit174	Lgnu/math/IntNum;
    //   175: astore 6
    //   177: getstatic 155	gnu/kawa/functions/BitwiseOp:ashift	Lgnu/kawa/functions/BitwiseOp;
    //   180: getstatic 190	gnu/kawa/functions/BitwiseOp:and	Lgnu/kawa/functions/BitwiseOp;
    //   183: aload 6
    //   185: getstatic 1061	com/ftsafe/CCIDScheme:Lit175	Lgnu/math/IntNum;
    //   188: invokevirtual 28	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   191: getstatic 877	com/ftsafe/CCIDScheme:Lit151	Lgnu/math/IntNum;
    //   194: invokevirtual 28	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   197: getstatic 155	gnu/kawa/functions/BitwiseOp:ashift	Lgnu/kawa/functions/BitwiseOp;
    //   200: getstatic 190	gnu/kawa/functions/BitwiseOp:and	Lgnu/kawa/functions/BitwiseOp;
    //   203: aload 6
    //   205: getstatic 720	com/ftsafe/CCIDScheme:Lit118	Lgnu/math/IntNum;
    //   208: invokevirtual 28	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   211: getstatic 52	com/ftsafe/CCIDScheme:Lit1	Lgnu/math/IntNum;
    //   214: invokevirtual 28	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   217: invokestatic 213	gnu/lists/LList:list2	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   220: astore 5
    //   222: aload 5
    //   224: invokestatic 118	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   227: astore 6
    //   229: aload 5
    //   231: invokestatic 581	kawa/lib/lists:cadr	(Ljava/lang/Object;)Ljava/lang/Object;
    //   234: astore 7
    //   236: getstatic 965	com/ftsafe/CCIDScheme:Lit74	Lgnu/mapping/SimpleSymbol;
    //   239: getstatic 572	com/ftsafe/CCIDScheme:Lit98	Lgnu/mapping/SimpleSymbol;
    //   242: getstatic 535	com/ftsafe/CCIDScheme:current_dev_interface	Lgnu/mapping/Procedure;
    //   245: invokevirtual 575	gnu/mapping/Procedure:apply0	()Ljava/lang/Object;
    //   248: getstatic 497	com/ftsafe/CCIDScheme:descriptor$Mninfo	Ljava/lang/Object;
    //   251: invokestatic 348	kawa/lib/lists:assoc	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   254: ldc 98
    //   256: invokestatic 101	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   259: dup
    //   260: astore 9
    //   262: checkcast 98	gnu/lists/Pair
    //   265: invokestatic 106	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   268: invokestatic 348	kawa/lib/lists:assoc	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   271: ldc 98
    //   273: invokestatic 101	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   276: dup
    //   277: astore 9
    //   279: checkcast 98	gnu/lists/Pair
    //   282: invokestatic 106	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   285: invokestatic 348	kawa/lib/lists:assoc	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   288: invokestatic 581	kawa/lib/lists:cadr	(Ljava/lang/Object;)Ljava/lang/Object;
    //   291: astore 8
    //   293: aload_2
    //   294: getstatic 52	com/ftsafe/CCIDScheme:Lit1	Lgnu/math/IntNum;
    //   297: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   300: istore 9
    //   302: iload 9
    //   304: ifeq +11 -> 315
    //   307: iload 9
    //   309: ifeq +45 -> 354
    //   312: goto +36 -> 348
    //   315: aload_3
    //   316: getstatic 52	com/ftsafe/CCIDScheme:Lit1	Lgnu/math/IntNum;
    //   319: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   322: istore 10
    //   324: iload 10
    //   326: ifeq +11 -> 337
    //   329: iload 10
    //   331: ifeq +23 -> 354
    //   334: goto +14 -> 348
    //   337: aload 8
    //   339: getstatic 52	com/ftsafe/CCIDScheme:Lit1	Lgnu/math/IntNum;
    //   342: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   345: ifeq +9 -> 354
    //   348: getstatic 1064	com/ftsafe/CCIDScheme:Lit176	Lgnu/math/IntNum;
    //   351: goto +202 -> 553
    //   354: getstatic 1067	gnu/kawa/functions/DivideOp:$Sl	Lgnu/kawa/functions/DivideOp;
    //   357: getstatic 1067	gnu/kawa/functions/DivideOp:$Sl	Lgnu/kawa/functions/DivideOp;
    //   360: aload_2
    //   361: aload_3
    //   362: invokevirtual 28	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   365: aload 8
    //   367: invokevirtual 28	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   370: astore 10
    //   372: iconst_1
    //   373: getstatic 986	gnu/kawa/functions/MultiplyOp:$St	Lgnu/kawa/functions/MultiplyOp;
    //   376: getstatic 705	com/ftsafe/CCIDScheme:Lit115	Lgnu/math/IntNum;
    //   379: aload 10
    //   381: invokevirtual 28	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   384: getstatic 1067	gnu/kawa/functions/DivideOp:$Sl	Lgnu/kawa/functions/DivideOp;
    //   387: getstatic 986	gnu/kawa/functions/MultiplyOp:$St	Lgnu/kawa/functions/MultiplyOp;
    //   390: getstatic 1067	gnu/kawa/functions/DivideOp:$Sl	Lgnu/kawa/functions/DivideOp;
    //   393: aload_2
    //   394: aload_3
    //   395: invokevirtual 28	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   398: aload 4
    //   400: invokevirtual 28	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   403: aload 8
    //   405: invokevirtual 28	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   408: invokestatic 114	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   411: astore 11
    //   413: iconst_1
    //   414: getstatic 986	gnu/kawa/functions/MultiplyOp:$St	Lgnu/kawa/functions/MultiplyOp;
    //   417: getstatic 700	com/ftsafe/CCIDScheme:Lit90	Lgnu/math/IntNum;
    //   420: aload 10
    //   422: invokevirtual 28	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   425: getstatic 1067	gnu/kawa/functions/DivideOp:$Sl	Lgnu/kawa/functions/DivideOp;
    //   428: getstatic 109	com/ftsafe/CCIDScheme:Lit2	Lgnu/math/IntNum;
    //   431: aload 6
    //   433: invokestatic 34	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   436: checkcast 58	java/lang/Number
    //   439: invokevirtual 62	java/lang/Number:intValue	()I
    //   442: invokestatic 1073	gnu/math/IntNum:shift	(Lgnu/math/IntNum;I)Lgnu/math/IntNum;
    //   445: sipush 960
    //   448: invokestatic 1076	gnu/math/IntNum:times	(Lgnu/math/IntNum;I)Lgnu/math/IntNum;
    //   451: sipush 372
    //   454: invokestatic 1076	gnu/math/IntNum:times	(Lgnu/math/IntNum;I)Lgnu/math/IntNum;
    //   457: aload 8
    //   459: invokevirtual 28	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   462: invokestatic 114	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   465: astore 12
    //   467: getstatic 986	gnu/kawa/functions/MultiplyOp:$St	Lgnu/kawa/functions/MultiplyOp;
    //   470: getstatic 109	com/ftsafe/CCIDScheme:Lit2	Lgnu/math/IntNum;
    //   473: aload 7
    //   475: invokestatic 34	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   478: checkcast 58	java/lang/Number
    //   481: invokevirtual 62	java/lang/Number:intValue	()I
    //   484: invokestatic 1073	gnu/math/IntNum:shift	(Lgnu/math/IntNum;I)Lgnu/math/IntNum;
    //   487: bipush 11
    //   489: invokestatic 1079	gnu/math/IntNum:add	(Lgnu/math/IntNum;I)Lgnu/math/IntNum;
    //   492: aload 10
    //   494: invokevirtual 28	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   497: astore 13
    //   499: getstatic 986	gnu/kawa/functions/MultiplyOp:$St	Lgnu/kawa/functions/MultiplyOp;
    //   502: iconst_1
    //   503: iconst_1
    //   504: iconst_1
    //   505: getstatic 986	gnu/kawa/functions/MultiplyOp:$St	Lgnu/kawa/functions/MultiplyOp;
    //   508: getstatic 1082	com/ftsafe/CCIDScheme:Lit177	Lgnu/math/IntNum;
    //   511: aload 11
    //   513: invokevirtual 28	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   516: aload 12
    //   518: invokestatic 114	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   521: getstatic 986	gnu/kawa/functions/MultiplyOp:$St	Lgnu/kawa/functions/MultiplyOp;
    //   524: getstatic 1082	com/ftsafe/CCIDScheme:Lit177	Lgnu/math/IntNum;
    //   527: aload 13
    //   529: invokevirtual 28	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   532: invokestatic 114	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   535: getstatic 989	com/ftsafe/CCIDScheme:Lit166	Lgnu/math/IntNum;
    //   538: invokestatic 114	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   541: getstatic 1086	com/ftsafe/CCIDScheme:Lit178	Lgnu/math/DFloNum;
    //   544: invokevirtual 28	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   547: invokestatic 1089	com/ftsafe/CCIDScheme:float$To$Integer	(Ljava/lang/Object;)I
    //   550: invokestatic 1092	gnu/math/IntNum:make	(I)Lgnu/math/IntNum;
    //   553: areturn
    //   554: new 66	gnu/mapping/WrongType
    //   557: dup_x1
    //   558: swap
    //   559: ldc 116
    //   561: iconst_1
    //   562: aload_2
    //   563: invokespecial 71	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   566: athrow
    //   567: new 66	gnu/mapping/WrongType
    //   570: dup_x1
    //   571: swap
    //   572: ldc 116
    //   574: iconst_1
    //   575: aload 5
    //   577: invokespecial 71	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   580: athrow
    //   581: new 66	gnu/mapping/WrongType
    //   584: dup_x1
    //   585: swap
    //   586: ldc 103
    //   588: iconst_1
    //   589: aload 9
    //   591: invokespecial 71	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   594: athrow
    //   595: new 66	gnu/mapping/WrongType
    //   598: dup_x1
    //   599: swap
    //   600: ldc 103
    //   602: iconst_1
    //   603: aload 9
    //   605: invokespecial 71	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   608: athrow
    // Line number table:
    //   Java source line #11394	-> byte code offset #0
    //   Java source line #11395	-> byte code offset #0
    //   Java source line #11396	-> byte code offset #25
    //   Java source line #11395	-> byte code offset #67
    //   Java source line #11398	-> byte code offset #67
    //   Java source line #11395	-> byte code offset #78
    //   Java source line #11399	-> byte code offset #78
    //   Java source line #11395	-> byte code offset #89
    //   Java source line #11400	-> byte code offset #89
    //   Java source line #11401	-> byte code offset #114
    //   Java source line #11400	-> byte code offset #150
    //   Java source line #11395	-> byte code offset #155
    //   Java source line #11403	-> byte code offset #155
    //   Java source line #11404	-> byte code offset #165
    //   Java source line #11403	-> byte code offset #172
    //   Java source line #11406	-> byte code offset #177
    //   Java source line #11407	-> byte code offset #200
    //   Java source line #11395	-> byte code offset #222
    //   Java source line #11408	-> byte code offset #222
    //   Java source line #11395	-> byte code offset #229
    //   Java source line #11409	-> byte code offset #229
    //   Java source line #11395	-> byte code offset #236
    //   Java source line #11410	-> byte code offset #236
    //   Java source line #11411	-> byte code offset #248
    //   Java source line #11412	-> byte code offset #293
    //   Java source line #11413	-> byte code offset #315
    //   Java source line #11412	-> byte code offset #324
    //   Java source line #11414	-> byte code offset #337
    //   Java source line #11415	-> byte code offset #348
    //   Java source line #11416	-> byte code offset #354
    //   Java source line #11417	-> byte code offset #372
    //   Java source line #11418	-> byte code offset #387
    //   Java source line #11416	-> byte code offset #413
    //   Java source line #11419	-> byte code offset #413
    //   Java source line #11420	-> byte code offset #457
    //   Java source line #11416	-> byte code offset #467
    //   Java source line #11421	-> byte code offset #467
    //   Java source line #11422	-> byte code offset #499
    //   Java source line #11396	-> byte code offset #554
    //   Java source line #11401	-> byte code offset #567
    //   Java source line #11410	-> byte code offset #581
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	553	0	atr	Object
    //   66	16	1	f_d	gnu.lists.Pair
    //   50	1	2	localObject1	Object
    //   77	486	2	f	Object
    //   88	307	3	d	Object
    //   153	246	4	TC1	Object
    //   139	1	5	localObject2	Object
    //   220	356	5	B_C	gnu.lists.Pair
    //   175	29	6	B_C	Object
    //   227	205	6	BWI	Object
    //   234	240	7	CWI	Object
    //   291	167	8	clock_frequency	Object
    //   260	18	9	localObject3	Object
    //   300	304	9	x	boolean
    //   322	8	10	x	boolean
    //   370	123	10	etu	Object
    //   411	101	11	EGT	Object
    //   465	52	12	BWT	Object
    //   497	31	13	CWT	Object
    //   554	1	19	localClassCastException1	ClassCastException
    //   567	1	20	localClassCastException2	ClassCastException
    //   581	1	21	localClassCastException3	ClassCastException
    //   595	1	22	localClassCastException4	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   51	54	554	java/lang/ClassCastException
    //   141	144	567	java/lang/ClassCastException
    //   262	265	581	java/lang/ClassCastException
    //   279	282	595	java/lang/ClassCastException
  }
  
  /* Error */
  public static gnu.math.IntNum getCardTimeoutT0(Object atr)
  {
    // Byte code:
    //   0: getstatic 953	com/ftsafe/CCIDScheme:Lit141	Lgnu/mapping/SimpleSymbol;
    //   3: getstatic 971	com/ftsafe/CCIDScheme:Lit165	Lgnu/mapping/SimpleSymbol;
    //   6: getstatic 901	com/ftsafe/CCIDScheme:Lit158	Lgnu/mapping/SimpleSymbol;
    //   9: aload_0
    //   10: invokestatic 922	com/ftsafe/CCIDScheme:assocEX	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   13: invokestatic 922	com/ftsafe/CCIDScheme:assocEX	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   16: invokestatic 922	com/ftsafe/CCIDScheme:assocEX	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   19: invokestatic 287	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   22: ifeq +38 -> 60
    //   25: getstatic 953	com/ftsafe/CCIDScheme:Lit141	Lgnu/mapping/SimpleSymbol;
    //   28: getstatic 971	com/ftsafe/CCIDScheme:Lit165	Lgnu/mapping/SimpleSymbol;
    //   31: getstatic 901	com/ftsafe/CCIDScheme:Lit158	Lgnu/mapping/SimpleSymbol;
    //   34: aload_0
    //   35: invokestatic 922	com/ftsafe/CCIDScheme:assocEX	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   38: invokestatic 922	com/ftsafe/CCIDScheme:assocEX	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   41: invokestatic 922	com/ftsafe/CCIDScheme:assocEX	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   44: ldc 98
    //   46: invokestatic 101	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   49: dup
    //   50: astore_2
    //   51: checkcast 98	gnu/lists/Pair
    //   54: invokestatic 118	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   57: goto +6 -> 63
    //   60: getstatic 247	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   63: invokestatic 974	com/ftsafe/CCIDScheme:parseAtrTA1	(Ljava/lang/Object;)Lgnu/lists/Pair;
    //   66: astore_1
    //   67: getstatic 880	com/ftsafe/CCIDScheme:Lit152	Lgnu/mapping/SimpleSymbol;
    //   70: aload_1
    //   71: invokestatic 348	kawa/lib/lists:assoc	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   74: invokestatic 581	kawa/lib/lists:cadr	(Ljava/lang/Object;)Ljava/lang/Object;
    //   77: astore_2
    //   78: getstatic 886	com/ftsafe/CCIDScheme:Lit154	Lgnu/mapping/SimpleSymbol;
    //   81: aload_1
    //   82: invokestatic 348	kawa/lib/lists:assoc	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   85: invokestatic 581	kawa/lib/lists:cadr	(Ljava/lang/Object;)Ljava/lang/Object;
    //   88: astore_3
    //   89: getstatic 1037	com/ftsafe/CCIDScheme:Lit143	Lgnu/mapping/SimpleSymbol;
    //   92: getstatic 971	com/ftsafe/CCIDScheme:Lit165	Lgnu/mapping/SimpleSymbol;
    //   95: getstatic 901	com/ftsafe/CCIDScheme:Lit158	Lgnu/mapping/SimpleSymbol;
    //   98: aload_0
    //   99: invokestatic 922	com/ftsafe/CCIDScheme:assocEX	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   102: invokestatic 922	com/ftsafe/CCIDScheme:assocEX	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   105: invokestatic 922	com/ftsafe/CCIDScheme:assocEX	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   108: invokestatic 287	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   111: ifeq +39 -> 150
    //   114: getstatic 1037	com/ftsafe/CCIDScheme:Lit143	Lgnu/mapping/SimpleSymbol;
    //   117: getstatic 971	com/ftsafe/CCIDScheme:Lit165	Lgnu/mapping/SimpleSymbol;
    //   120: getstatic 901	com/ftsafe/CCIDScheme:Lit158	Lgnu/mapping/SimpleSymbol;
    //   123: aload_0
    //   124: invokestatic 922	com/ftsafe/CCIDScheme:assocEX	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   127: invokestatic 922	com/ftsafe/CCIDScheme:assocEX	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   130: invokestatic 922	com/ftsafe/CCIDScheme:assocEX	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   133: ldc 98
    //   135: invokestatic 101	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   138: dup
    //   139: astore 5
    //   141: checkcast 98	gnu/lists/Pair
    //   144: invokestatic 118	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   147: goto +6 -> 153
    //   150: getstatic 52	com/ftsafe/CCIDScheme:Lit1	Lgnu/math/IntNum;
    //   153: astore 4
    //   155: getstatic 1037	com/ftsafe/CCIDScheme:Lit143	Lgnu/mapping/SimpleSymbol;
    //   158: getstatic 995	com/ftsafe/CCIDScheme:Lit168	Lgnu/mapping/SimpleSymbol;
    //   161: getstatic 901	com/ftsafe/CCIDScheme:Lit158	Lgnu/mapping/SimpleSymbol;
    //   164: aload_0
    //   165: invokestatic 922	com/ftsafe/CCIDScheme:assocEX	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   168: invokestatic 922	com/ftsafe/CCIDScheme:assocEX	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   171: invokestatic 922	com/ftsafe/CCIDScheme:assocEX	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   174: invokestatic 287	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   177: ifeq +39 -> 216
    //   180: getstatic 1037	com/ftsafe/CCIDScheme:Lit143	Lgnu/mapping/SimpleSymbol;
    //   183: getstatic 995	com/ftsafe/CCIDScheme:Lit168	Lgnu/mapping/SimpleSymbol;
    //   186: getstatic 901	com/ftsafe/CCIDScheme:Lit158	Lgnu/mapping/SimpleSymbol;
    //   189: aload_0
    //   190: invokestatic 922	com/ftsafe/CCIDScheme:assocEX	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   193: invokestatic 922	com/ftsafe/CCIDScheme:assocEX	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   196: invokestatic 922	com/ftsafe/CCIDScheme:assocEX	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   199: ldc 98
    //   201: invokestatic 101	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   204: dup
    //   205: astore 6
    //   207: checkcast 98	gnu/lists/Pair
    //   210: invokestatic 118	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   213: goto +6 -> 219
    //   216: getstatic 695	com/ftsafe/CCIDScheme:Lit114	Lgnu/math/IntNum;
    //   219: astore 5
    //   221: getstatic 965	com/ftsafe/CCIDScheme:Lit74	Lgnu/mapping/SimpleSymbol;
    //   224: getstatic 572	com/ftsafe/CCIDScheme:Lit98	Lgnu/mapping/SimpleSymbol;
    //   227: getstatic 535	com/ftsafe/CCIDScheme:current_dev_interface	Lgnu/mapping/Procedure;
    //   230: invokevirtual 575	gnu/mapping/Procedure:apply0	()Ljava/lang/Object;
    //   233: getstatic 497	com/ftsafe/CCIDScheme:descriptor$Mninfo	Ljava/lang/Object;
    //   236: invokestatic 348	kawa/lib/lists:assoc	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   239: ldc 98
    //   241: invokestatic 101	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   244: dup
    //   245: astore 7
    //   247: checkcast 98	gnu/lists/Pair
    //   250: invokestatic 106	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   253: invokestatic 348	kawa/lib/lists:assoc	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   256: ldc 98
    //   258: invokestatic 101	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   261: dup
    //   262: astore 7
    //   264: checkcast 98	gnu/lists/Pair
    //   267: invokestatic 106	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   270: invokestatic 348	kawa/lib/lists:assoc	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   273: invokestatic 581	kawa/lib/lists:cadr	(Ljava/lang/Object;)Ljava/lang/Object;
    //   276: astore 6
    //   278: aload_2
    //   279: getstatic 52	com/ftsafe/CCIDScheme:Lit1	Lgnu/math/IntNum;
    //   282: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   285: istore 7
    //   287: iload 7
    //   289: ifeq +11 -> 300
    //   292: iload 7
    //   294: ifeq +45 -> 339
    //   297: goto +36 -> 333
    //   300: aload_3
    //   301: getstatic 52	com/ftsafe/CCIDScheme:Lit1	Lgnu/math/IntNum;
    //   304: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   307: istore 8
    //   309: iload 8
    //   311: ifeq +11 -> 322
    //   314: iload 8
    //   316: ifeq +23 -> 339
    //   319: goto +14 -> 333
    //   322: aload 6
    //   324: getstatic 52	com/ftsafe/CCIDScheme:Lit1	Lgnu/math/IntNum;
    //   327: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   330: ifeq +9 -> 339
    //   333: getstatic 1064	com/ftsafe/CCIDScheme:Lit176	Lgnu/math/IntNum;
    //   336: goto +202 -> 538
    //   339: iconst_1
    //   340: getstatic 986	gnu/kawa/functions/MultiplyOp:$St	Lgnu/kawa/functions/MultiplyOp;
    //   343: getstatic 705	com/ftsafe/CCIDScheme:Lit115	Lgnu/math/IntNum;
    //   346: getstatic 1067	gnu/kawa/functions/DivideOp:$Sl	Lgnu/kawa/functions/DivideOp;
    //   349: getstatic 1067	gnu/kawa/functions/DivideOp:$Sl	Lgnu/kawa/functions/DivideOp;
    //   352: aload_2
    //   353: aload_3
    //   354: invokevirtual 28	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   357: aload 6
    //   359: invokevirtual 28	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   362: invokevirtual 28	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   365: getstatic 1067	gnu/kawa/functions/DivideOp:$Sl	Lgnu/kawa/functions/DivideOp;
    //   368: getstatic 986	gnu/kawa/functions/MultiplyOp:$St	Lgnu/kawa/functions/MultiplyOp;
    //   371: getstatic 1067	gnu/kawa/functions/DivideOp:$Sl	Lgnu/kawa/functions/DivideOp;
    //   374: aload_2
    //   375: aload_3
    //   376: invokevirtual 28	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   379: aload 4
    //   381: invokevirtual 28	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   384: aload 6
    //   386: invokevirtual 28	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   389: invokestatic 114	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   392: astore 8
    //   394: getstatic 1067	gnu/kawa/functions/DivideOp:$Sl	Lgnu/kawa/functions/DivideOp;
    //   397: getstatic 986	gnu/kawa/functions/MultiplyOp:$St	Lgnu/kawa/functions/MultiplyOp;
    //   400: getstatic 986	gnu/kawa/functions/MultiplyOp:$St	Lgnu/kawa/functions/MultiplyOp;
    //   403: getstatic 1095	com/ftsafe/CCIDScheme:Lit179	Lgnu/math/IntNum;
    //   406: aload 5
    //   408: invokevirtual 28	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   411: aload_2
    //   412: invokevirtual 28	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   415: aload 6
    //   417: invokevirtual 28	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   420: astore 9
    //   422: iconst_1
    //   423: getstatic 986	gnu/kawa/functions/MultiplyOp:$St	Lgnu/kawa/functions/MultiplyOp;
    //   426: getstatic 1098	com/ftsafe/CCIDScheme:Lit180	Lgnu/math/IntNum;
    //   429: aload 8
    //   431: invokevirtual 28	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   434: getstatic 986	gnu/kawa/functions/MultiplyOp:$St	Lgnu/kawa/functions/MultiplyOp;
    //   437: getstatic 472	com/ftsafe/CCIDScheme:Lit21	Lgnu/math/IntNum;
    //   440: aload 9
    //   442: invokevirtual 28	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   445: invokestatic 114	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   448: astore 10
    //   450: iconst_1
    //   451: getstatic 986	gnu/kawa/functions/MultiplyOp:$St	Lgnu/kawa/functions/MultiplyOp;
    //   454: getstatic 621	com/ftsafe/CCIDScheme:Lit58	Lgnu/math/IntNum;
    //   457: aload 8
    //   459: invokevirtual 28	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   462: getstatic 986	gnu/kawa/functions/MultiplyOp:$St	Lgnu/kawa/functions/MultiplyOp;
    //   465: getstatic 1082	com/ftsafe/CCIDScheme:Lit177	Lgnu/math/IntNum;
    //   468: aload 9
    //   470: invokevirtual 28	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   473: invokestatic 114	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   476: astore 11
    //   478: getstatic 986	gnu/kawa/functions/MultiplyOp:$St	Lgnu/kawa/functions/MultiplyOp;
    //   481: aload 10
    //   483: getstatic 1101	com/ftsafe/CCIDScheme:Lit181	Lgnu/math/IntNum;
    //   486: invokestatic 1104	gnu/kawa/functions/NumberCompare:$Ls	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   489: ifeq +20 -> 509
    //   492: aload 11
    //   494: getstatic 1101	com/ftsafe/CCIDScheme:Lit181	Lgnu/math/IntNum;
    //   497: invokestatic 1104	gnu/kawa/functions/NumberCompare:$Ls	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   500: ifeq +9 -> 509
    //   503: getstatic 1101	com/ftsafe/CCIDScheme:Lit181	Lgnu/math/IntNum;
    //   506: goto +20 -> 526
    //   509: aload 10
    //   511: aload 11
    //   513: invokestatic 96	gnu/kawa/functions/NumberCompare:$Gr	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   516: ifeq +8 -> 524
    //   519: aload 10
    //   521: goto +5 -> 526
    //   524: aload 11
    //   526: getstatic 1086	com/ftsafe/CCIDScheme:Lit178	Lgnu/math/DFloNum;
    //   529: invokevirtual 28	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   532: invokestatic 1089	com/ftsafe/CCIDScheme:float$To$Integer	(Ljava/lang/Object;)I
    //   535: invokestatic 1092	gnu/math/IntNum:make	(I)Lgnu/math/IntNum;
    //   538: areturn
    //   539: new 66	gnu/mapping/WrongType
    //   542: dup_x1
    //   543: swap
    //   544: ldc 116
    //   546: iconst_1
    //   547: aload_2
    //   548: invokespecial 71	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   551: athrow
    //   552: new 66	gnu/mapping/WrongType
    //   555: dup_x1
    //   556: swap
    //   557: ldc 116
    //   559: iconst_1
    //   560: aload 5
    //   562: invokespecial 71	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   565: athrow
    //   566: new 66	gnu/mapping/WrongType
    //   569: dup_x1
    //   570: swap
    //   571: ldc 116
    //   573: iconst_1
    //   574: aload 6
    //   576: invokespecial 71	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   579: athrow
    //   580: new 66	gnu/mapping/WrongType
    //   583: dup_x1
    //   584: swap
    //   585: ldc 103
    //   587: iconst_1
    //   588: aload 7
    //   590: invokespecial 71	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   593: athrow
    //   594: new 66	gnu/mapping/WrongType
    //   597: dup_x1
    //   598: swap
    //   599: ldc 103
    //   601: iconst_1
    //   602: aload 7
    //   604: invokespecial 71	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   607: athrow
    // Line number table:
    //   Java source line #11425	-> byte code offset #0
    //   Java source line #11426	-> byte code offset #0
    //   Java source line #11427	-> byte code offset #25
    //   Java source line #11426	-> byte code offset #67
    //   Java source line #11429	-> byte code offset #67
    //   Java source line #11426	-> byte code offset #78
    //   Java source line #11430	-> byte code offset #78
    //   Java source line #11426	-> byte code offset #89
    //   Java source line #11431	-> byte code offset #89
    //   Java source line #11432	-> byte code offset #114
    //   Java source line #11431	-> byte code offset #150
    //   Java source line #11426	-> byte code offset #155
    //   Java source line #11434	-> byte code offset #155
    //   Java source line #11435	-> byte code offset #180
    //   Java source line #11434	-> byte code offset #216
    //   Java source line #11426	-> byte code offset #221
    //   Java source line #11437	-> byte code offset #221
    //   Java source line #11438	-> byte code offset #233
    //   Java source line #11439	-> byte code offset #278
    //   Java source line #11440	-> byte code offset #300
    //   Java source line #11439	-> byte code offset #309
    //   Java source line #11441	-> byte code offset #322
    //   Java source line #11442	-> byte code offset #333
    //   Java source line #11443	-> byte code offset #339
    //   Java source line #11444	-> byte code offset #368
    //   Java source line #11443	-> byte code offset #394
    //   Java source line #11445	-> byte code offset #394
    //   Java source line #11443	-> byte code offset #422
    //   Java source line #11446	-> byte code offset #422
    //   Java source line #11443	-> byte code offset #450
    //   Java source line #11447	-> byte code offset #450
    //   Java source line #11448	-> byte code offset #478
    //   Java source line #11450	-> byte code offset #509
    //   Java source line #11452	-> byte code offset #526
    //   Java source line #11427	-> byte code offset #539
    //   Java source line #11432	-> byte code offset #552
    //   Java source line #11435	-> byte code offset #566
    //   Java source line #11437	-> byte code offset #580
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	538	0	atr	Object
    //   66	16	1	f_d	gnu.lists.Pair
    //   50	1	2	localObject1	Object
    //   77	471	2	f	Object
    //   88	288	3	d	Object
    //   153	227	4	TC1	Object
    //   139	1	5	localObject2	Object
    //   219	342	5	TC2	Object
    //   205	1	6	localObject3	Object
    //   276	299	6	clock_frequency	Object
    //   245	18	7	localObject4	Object
    //   285	318	7	x	boolean
    //   307	8	8	x	boolean
    //   392	66	8	EGT	Object
    //   420	49	9	WWT	Object
    //   448	72	10	t_in	Object
    //   476	49	11	t_out	Object
    //   539	1	17	localClassCastException1	ClassCastException
    //   552	1	18	localClassCastException2	ClassCastException
    //   566	1	19	localClassCastException3	ClassCastException
    //   580	1	20	localClassCastException4	ClassCastException
    //   594	1	21	localClassCastException5	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   51	54	539	java/lang/ClassCastException
    //   141	144	552	java/lang/ClassCastException
    //   207	210	566	java/lang/ClassCastException
    //   247	250	580	java/lang/ClassCastException
    //   264	267	594	java/lang/ClassCastException
  }
  
  public static Object parseT1Block(Object paramObject)
  {
    return parseT1Block(paramObject, Boolean.TRUE);
  }
  
  /* Error */
  public static Object parseT1Block(Object data, Object _debug)
  {
    // Byte code:
    //   0: new 1119	com/ftsafe/CCIDScheme$frame12
    //   3: dup
    //   4: invokespecial 1120	com/ftsafe/CCIDScheme$frame12:<init>	()V
    //   7: astore_2
    //   8: ldc_w 427
    //   11: aload_2
    //   12: swap
    //   13: putfield 1123	com/ftsafe/CCIDScheme$frame12:info	Ljava/lang/Object;
    //   16: aload_2
    //   17: ldc_w 1125
    //   20: iconst_0
    //   21: anewarray 76	java/lang/Object
    //   24: invokevirtual 1129	com/ftsafe/CCIDScheme$frame12:lambda32setinfo$V	(Ljava/lang/Object;[Ljava/lang/Object;)V
    //   27: aload_2
    //   28: ldc_w 1131
    //   31: iconst_2
    //   32: anewarray 76	java/lang/Object
    //   35: dup
    //   36: iconst_0
    //   37: aload_0
    //   38: ldc_w 1133
    //   41: invokestatic 430	com/ftsafe/CCIDScheme:u8list$To$String	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   44: aastore
    //   45: dup
    //   46: iconst_1
    //   47: ldc_w 1135
    //   50: aastore
    //   51: invokevirtual 1129	com/ftsafe/CCIDScheme$frame12:lambda32setinfo$V	(Ljava/lang/Object;[Ljava/lang/Object;)V
    //   54: aload_0
    //   55: getstatic 52	com/ftsafe/CCIDScheme:Lit1	Lgnu/math/IntNum;
    //   58: getstatic 587	com/ftsafe/CCIDScheme:Lit99	Lgnu/math/IntNum;
    //   61: invokestatic 122	com/ftsafe/CCIDScheme:slice	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   64: astore_3
    //   65: aload_2
    //   66: ldc_w 1137
    //   69: iconst_2
    //   70: anewarray 76	java/lang/Object
    //   73: dup
    //   74: iconst_0
    //   75: aload_3
    //   76: invokestatic 1139	com/ftsafe/CCIDScheme:u8list$To$String	(Ljava/lang/Object;)Ljava/lang/Object;
    //   79: aastore
    //   80: dup
    //   81: iconst_1
    //   82: ldc_w 1135
    //   85: aastore
    //   86: invokevirtual 1129	com/ftsafe/CCIDScheme$frame12:lambda32setinfo$V	(Ljava/lang/Object;[Ljava/lang/Object;)V
    //   89: aload_3
    //   90: ldc 98
    //   92: invokestatic 101	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   95: dup
    //   96: astore 5
    //   98: checkcast 98	gnu/lists/Pair
    //   101: invokestatic 118	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   104: astore 4
    //   106: aload_2
    //   107: ldc_w 1141
    //   110: iconst_4
    //   111: anewarray 76	java/lang/Object
    //   114: dup
    //   115: iconst_0
    //   116: ldc_w 1143
    //   119: aastore
    //   120: dup
    //   121: iconst_1
    //   122: aload 4
    //   124: invokestatic 433	com/ftsafe/CCIDScheme:toHexStr	(Ljava/lang/Object;)Ljava/lang/CharSequence;
    //   127: aastore
    //   128: dup
    //   129: iconst_2
    //   130: ldc_w 1145
    //   133: aastore
    //   134: dup
    //   135: iconst_3
    //   136: ldc_w 1135
    //   139: aastore
    //   140: invokevirtual 1129	com/ftsafe/CCIDScheme$frame12:lambda32setinfo$V	(Ljava/lang/Object;[Ljava/lang/Object;)V
    //   143: aload_2
    //   144: ldc_w 1141
    //   147: iconst_5
    //   148: anewarray 76	java/lang/Object
    //   151: dup
    //   152: iconst_0
    //   153: ldc_w 1141
    //   156: aastore
    //   157: dup
    //   158: iconst_1
    //   159: ldc_w 1147
    //   162: aastore
    //   163: dup
    //   164: iconst_2
    //   165: getstatic 155	gnu/kawa/functions/BitwiseOp:ashift	Lgnu/kawa/functions/BitwiseOp;
    //   168: getstatic 190	gnu/kawa/functions/BitwiseOp:and	Lgnu/kawa/functions/BitwiseOp;
    //   171: aload 4
    //   173: getstatic 672	com/ftsafe/CCIDScheme:Lit111	Lgnu/math/IntNum;
    //   176: invokevirtual 28	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   179: getstatic 1150	com/ftsafe/CCIDScheme:Lit182	Lgnu/math/IntNum;
    //   182: invokevirtual 28	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   185: getstatic 587	com/ftsafe/CCIDScheme:Lit99	Lgnu/math/IntNum;
    //   188: invokestatic 425	com/ftsafe/CCIDScheme:toBinStr	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/CharSequence;
    //   191: aastore
    //   192: dup
    //   193: iconst_3
    //   194: ldc_w 1152
    //   197: aastore
    //   198: dup
    //   199: iconst_4
    //   200: ldc_w 1135
    //   203: aastore
    //   204: invokevirtual 1129	com/ftsafe/CCIDScheme$frame12:lambda32setinfo$V	(Ljava/lang/Object;[Ljava/lang/Object;)V
    //   207: aload_2
    //   208: ldc_w 1141
    //   211: iconst_5
    //   212: anewarray 76	java/lang/Object
    //   215: dup
    //   216: iconst_0
    //   217: ldc_w 1141
    //   220: aastore
    //   221: dup
    //   222: iconst_1
    //   223: ldc_w 1154
    //   226: aastore
    //   227: dup
    //   228: iconst_2
    //   229: getstatic 155	gnu/kawa/functions/BitwiseOp:ashift	Lgnu/kawa/functions/BitwiseOp;
    //   232: getstatic 190	gnu/kawa/functions/BitwiseOp:and	Lgnu/kawa/functions/BitwiseOp;
    //   235: aload 4
    //   237: getstatic 1157	com/ftsafe/CCIDScheme:Lit183	Lgnu/math/IntNum;
    //   240: invokevirtual 28	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   243: getstatic 1160	com/ftsafe/CCIDScheme:Lit184	Lgnu/math/IntNum;
    //   246: invokevirtual 28	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   249: getstatic 587	com/ftsafe/CCIDScheme:Lit99	Lgnu/math/IntNum;
    //   252: invokestatic 425	com/ftsafe/CCIDScheme:toBinStr	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/CharSequence;
    //   255: aastore
    //   256: dup
    //   257: iconst_3
    //   258: ldc_w 1152
    //   261: aastore
    //   262: dup
    //   263: iconst_4
    //   264: ldc_w 1135
    //   267: aastore
    //   268: invokevirtual 1129	com/ftsafe/CCIDScheme$frame12:lambda32setinfo$V	(Ljava/lang/Object;[Ljava/lang/Object;)V
    //   271: aload_3
    //   272: invokestatic 581	kawa/lib/lists:cadr	(Ljava/lang/Object;)Ljava/lang/Object;
    //   275: astore 4
    //   277: aload_2
    //   278: ldc_w 1141
    //   281: iconst_4
    //   282: anewarray 76	java/lang/Object
    //   285: dup
    //   286: iconst_0
    //   287: ldc_w 1162
    //   290: aastore
    //   291: dup
    //   292: iconst_1
    //   293: aload 4
    //   295: invokestatic 433	com/ftsafe/CCIDScheme:toHexStr	(Ljava/lang/Object;)Ljava/lang/CharSequence;
    //   298: aastore
    //   299: dup
    //   300: iconst_2
    //   301: ldc_w 1145
    //   304: aastore
    //   305: dup
    //   306: iconst_3
    //   307: ldc_w 1135
    //   310: aastore
    //   311: invokevirtual 1129	com/ftsafe/CCIDScheme$frame12:lambda32setinfo$V	(Ljava/lang/Object;[Ljava/lang/Object;)V
    //   314: getstatic 276	kawa/standard/Scheme:isEqual	Lgnu/kawa/functions/IsEqual;
    //   317: getstatic 190	gnu/kawa/functions/BitwiseOp:and	Lgnu/kawa/functions/BitwiseOp;
    //   320: aload 4
    //   322: getstatic 602	com/ftsafe/CCIDScheme:Lit101	Lgnu/math/IntNum;
    //   325: invokevirtual 28	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   328: getstatic 602	com/ftsafe/CCIDScheme:Lit101	Lgnu/math/IntNum;
    //   331: invokevirtual 28	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   334: invokestatic 287	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   337: ifeq +347 -> 684
    //   340: aload_2
    //   341: ldc_w 1141
    //   344: iconst_2
    //   345: anewarray 76	java/lang/Object
    //   348: dup
    //   349: iconst_0
    //   350: ldc_w 1141
    //   353: aastore
    //   354: dup
    //   355: iconst_1
    //   356: ldc_w 1164
    //   359: aastore
    //   360: invokevirtual 1129	com/ftsafe/CCIDScheme$frame12:lambda32setinfo$V	(Ljava/lang/Object;[Ljava/lang/Object;)V
    //   363: aload_2
    //   364: ldc_w 1141
    //   367: bipush 6
    //   369: anewarray 76	java/lang/Object
    //   372: dup
    //   373: iconst_0
    //   374: ldc_w 1141
    //   377: aastore
    //   378: dup
    //   379: iconst_1
    //   380: ldc_w 1166
    //   383: aastore
    //   384: dup
    //   385: iconst_2
    //   386: getstatic 190	gnu/kawa/functions/BitwiseOp:and	Lgnu/kawa/functions/BitwiseOp;
    //   389: aload 4
    //   391: getstatic 1169	com/ftsafe/CCIDScheme:Lit185	Lgnu/math/IntNum;
    //   394: invokevirtual 28	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   397: getstatic 472	com/ftsafe/CCIDScheme:Lit21	Lgnu/math/IntNum;
    //   400: invokestatic 425	com/ftsafe/CCIDScheme:toBinStr	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/CharSequence;
    //   403: aastore
    //   404: dup
    //   405: iconst_3
    //   406: ldc_w 1171
    //   409: aastore
    //   410: dup
    //   411: iconst_4
    //   412: getstatic 276	kawa/standard/Scheme:isEqual	Lgnu/kawa/functions/IsEqual;
    //   415: getstatic 190	gnu/kawa/functions/BitwiseOp:and	Lgnu/kawa/functions/BitwiseOp;
    //   418: aload 4
    //   420: getstatic 1169	com/ftsafe/CCIDScheme:Lit185	Lgnu/math/IntNum;
    //   423: invokevirtual 28	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   426: getstatic 52	com/ftsafe/CCIDScheme:Lit1	Lgnu/math/IntNum;
    //   429: invokevirtual 28	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   432: invokestatic 287	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   435: ifeq +9 -> 444
    //   438: ldc_w 1173
    //   441: goto +230 -> 671
    //   444: getstatic 276	kawa/standard/Scheme:isEqual	Lgnu/kawa/functions/IsEqual;
    //   447: getstatic 190	gnu/kawa/functions/BitwiseOp:and	Lgnu/kawa/functions/BitwiseOp;
    //   450: aload 4
    //   452: getstatic 1169	com/ftsafe/CCIDScheme:Lit185	Lgnu/math/IntNum;
    //   455: invokevirtual 28	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   458: getstatic 1017	com/ftsafe/CCIDScheme:Lit172	Lgnu/math/IntNum;
    //   461: invokevirtual 28	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   464: invokestatic 287	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   467: ifeq +9 -> 476
    //   470: ldc_w 1175
    //   473: goto +198 -> 671
    //   476: getstatic 276	kawa/standard/Scheme:isEqual	Lgnu/kawa/functions/IsEqual;
    //   479: getstatic 190	gnu/kawa/functions/BitwiseOp:and	Lgnu/kawa/functions/BitwiseOp;
    //   482: aload 4
    //   484: getstatic 1169	com/ftsafe/CCIDScheme:Lit185	Lgnu/math/IntNum;
    //   487: invokevirtual 28	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   490: getstatic 109	com/ftsafe/CCIDScheme:Lit2	Lgnu/math/IntNum;
    //   493: invokevirtual 28	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   496: invokestatic 287	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   499: ifeq +9 -> 508
    //   502: ldc_w 1177
    //   505: goto +166 -> 671
    //   508: getstatic 276	kawa/standard/Scheme:isEqual	Lgnu/kawa/functions/IsEqual;
    //   511: getstatic 190	gnu/kawa/functions/BitwiseOp:and	Lgnu/kawa/functions/BitwiseOp;
    //   514: aload 4
    //   516: getstatic 1169	com/ftsafe/CCIDScheme:Lit185	Lgnu/math/IntNum;
    //   519: invokevirtual 28	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   522: getstatic 1180	com/ftsafe/CCIDScheme:Lit68	Lgnu/math/IntNum;
    //   525: invokevirtual 28	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   528: invokestatic 287	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   531: ifeq +9 -> 540
    //   534: ldc_w 1182
    //   537: goto +134 -> 671
    //   540: getstatic 276	kawa/standard/Scheme:isEqual	Lgnu/kawa/functions/IsEqual;
    //   543: getstatic 190	gnu/kawa/functions/BitwiseOp:and	Lgnu/kawa/functions/BitwiseOp;
    //   546: aload 4
    //   548: getstatic 1169	com/ftsafe/CCIDScheme:Lit185	Lgnu/math/IntNum;
    //   551: invokevirtual 28	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   554: getstatic 357	com/ftsafe/CCIDScheme:Lit16	Lgnu/math/IntNum;
    //   557: invokevirtual 28	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   560: invokestatic 287	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   563: ifeq +9 -> 572
    //   566: ldc_w 1184
    //   569: goto +102 -> 671
    //   572: getstatic 276	kawa/standard/Scheme:isEqual	Lgnu/kawa/functions/IsEqual;
    //   575: getstatic 190	gnu/kawa/functions/BitwiseOp:and	Lgnu/kawa/functions/BitwiseOp;
    //   578: aload 4
    //   580: getstatic 1169	com/ftsafe/CCIDScheme:Lit185	Lgnu/math/IntNum;
    //   583: invokevirtual 28	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   586: getstatic 1187	com/ftsafe/CCIDScheme:Lit186	Lgnu/math/IntNum;
    //   589: invokevirtual 28	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   592: invokestatic 287	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   595: ifeq +9 -> 604
    //   598: ldc_w 1189
    //   601: goto +70 -> 671
    //   604: getstatic 276	kawa/standard/Scheme:isEqual	Lgnu/kawa/functions/IsEqual;
    //   607: getstatic 190	gnu/kawa/functions/BitwiseOp:and	Lgnu/kawa/functions/BitwiseOp;
    //   610: aload 4
    //   612: getstatic 1169	com/ftsafe/CCIDScheme:Lit185	Lgnu/math/IntNum;
    //   615: invokevirtual 28	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   618: getstatic 587	com/ftsafe/CCIDScheme:Lit99	Lgnu/math/IntNum;
    //   621: invokevirtual 28	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   624: invokestatic 287	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   627: ifeq +9 -> 636
    //   630: ldc_w 1191
    //   633: goto +38 -> 671
    //   636: getstatic 276	kawa/standard/Scheme:isEqual	Lgnu/kawa/functions/IsEqual;
    //   639: getstatic 190	gnu/kawa/functions/BitwiseOp:and	Lgnu/kawa/functions/BitwiseOp;
    //   642: aload 4
    //   644: getstatic 1169	com/ftsafe/CCIDScheme:Lit185	Lgnu/math/IntNum;
    //   647: invokevirtual 28	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   650: getstatic 1194	com/ftsafe/CCIDScheme:Lit187	Lgnu/math/IntNum;
    //   653: invokevirtual 28	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   656: invokestatic 287	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   659: ifeq +9 -> 668
    //   662: ldc_w 1196
    //   665: goto +6 -> 671
    //   668: ldc_w 1198
    //   671: aastore
    //   672: dup
    //   673: iconst_5
    //   674: ldc_w 1135
    //   677: aastore
    //   678: invokevirtual 1129	com/ftsafe/CCIDScheme$frame12:lambda32setinfo$V	(Ljava/lang/Object;[Ljava/lang/Object;)V
    //   681: goto +433 -> 1114
    //   684: getstatic 276	kawa/standard/Scheme:isEqual	Lgnu/kawa/functions/IsEqual;
    //   687: getstatic 190	gnu/kawa/functions/BitwiseOp:and	Lgnu/kawa/functions/BitwiseOp;
    //   690: aload 4
    //   692: getstatic 602	com/ftsafe/CCIDScheme:Lit101	Lgnu/math/IntNum;
    //   695: invokevirtual 28	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   698: getstatic 469	com/ftsafe/CCIDScheme:Lit20	Lgnu/math/IntNum;
    //   701: invokevirtual 28	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   704: invokestatic 287	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   707: ifeq +242 -> 949
    //   710: aload_2
    //   711: ldc_w 1141
    //   714: iconst_2
    //   715: anewarray 76	java/lang/Object
    //   718: dup
    //   719: iconst_0
    //   720: ldc_w 1141
    //   723: aastore
    //   724: dup
    //   725: iconst_1
    //   726: ldc_w 1200
    //   729: aastore
    //   730: invokevirtual 1129	com/ftsafe/CCIDScheme$frame12:lambda32setinfo$V	(Ljava/lang/Object;[Ljava/lang/Object;)V
    //   733: aload_2
    //   734: ldc_w 1141
    //   737: iconst_2
    //   738: anewarray 76	java/lang/Object
    //   741: dup
    //   742: iconst_0
    //   743: ldc_w 1141
    //   746: aastore
    //   747: dup
    //   748: iconst_1
    //   749: ldc_w 1202
    //   752: aastore
    //   753: invokevirtual 1129	com/ftsafe/CCIDScheme$frame12:lambda32setinfo$V	(Ljava/lang/Object;[Ljava/lang/Object;)V
    //   756: aload_2
    //   757: ldc_w 1204
    //   760: iconst_2
    //   761: anewarray 76	java/lang/Object
    //   764: dup
    //   765: iconst_0
    //   766: getstatic 155	gnu/kawa/functions/BitwiseOp:ashift	Lgnu/kawa/functions/BitwiseOp;
    //   769: getstatic 190	gnu/kawa/functions/BitwiseOp:and	Lgnu/kawa/functions/BitwiseOp;
    //   772: aload 4
    //   774: getstatic 165	com/ftsafe/CCIDScheme:Lit6	Lgnu/math/IntNum;
    //   777: invokevirtual 28	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   780: getstatic 877	com/ftsafe/CCIDScheme:Lit151	Lgnu/math/IntNum;
    //   783: invokevirtual 28	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   786: getstatic 109	com/ftsafe/CCIDScheme:Lit2	Lgnu/math/IntNum;
    //   789: invokestatic 425	com/ftsafe/CCIDScheme:toBinStr	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/CharSequence;
    //   792: aastore
    //   793: dup
    //   794: iconst_1
    //   795: ldc_w 1206
    //   798: aastore
    //   799: invokevirtual 1129	com/ftsafe/CCIDScheme$frame12:lambda32setinfo$V	(Ljava/lang/Object;[Ljava/lang/Object;)V
    //   802: aload_2
    //   803: getstatic 190	gnu/kawa/functions/BitwiseOp:and	Lgnu/kawa/functions/BitwiseOp;
    //   806: aload 4
    //   808: getstatic 720	com/ftsafe/CCIDScheme:Lit118	Lgnu/math/IntNum;
    //   811: invokevirtual 28	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   814: getstatic 419	com/ftsafe/CCIDScheme:Lit18	Lgnu/math/IntNum;
    //   817: invokestatic 425	com/ftsafe/CCIDScheme:toBinStr	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/CharSequence;
    //   820: iconst_0
    //   821: anewarray 76	java/lang/Object
    //   824: invokevirtual 1129	com/ftsafe/CCIDScheme$frame12:lambda32setinfo$V	(Ljava/lang/Object;[Ljava/lang/Object;)V
    //   827: aload_2
    //   828: ldc_w 1208
    //   831: iconst_2
    //   832: anewarray 76	java/lang/Object
    //   835: dup
    //   836: iconst_0
    //   837: getstatic 276	kawa/standard/Scheme:isEqual	Lgnu/kawa/functions/IsEqual;
    //   840: getstatic 190	gnu/kawa/functions/BitwiseOp:and	Lgnu/kawa/functions/BitwiseOp;
    //   843: aload 4
    //   845: getstatic 720	com/ftsafe/CCIDScheme:Lit118	Lgnu/math/IntNum;
    //   848: invokevirtual 28	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   851: getstatic 52	com/ftsafe/CCIDScheme:Lit1	Lgnu/math/IntNum;
    //   854: invokevirtual 28	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   857: invokestatic 287	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   860: ifeq +9 -> 869
    //   863: ldc_w 1210
    //   866: goto +70 -> 936
    //   869: getstatic 276	kawa/standard/Scheme:isEqual	Lgnu/kawa/functions/IsEqual;
    //   872: getstatic 190	gnu/kawa/functions/BitwiseOp:and	Lgnu/kawa/functions/BitwiseOp;
    //   875: aload 4
    //   877: getstatic 720	com/ftsafe/CCIDScheme:Lit118	Lgnu/math/IntNum;
    //   880: invokevirtual 28	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   883: getstatic 109	com/ftsafe/CCIDScheme:Lit2	Lgnu/math/IntNum;
    //   886: invokevirtual 28	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   889: invokestatic 287	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   892: ifeq +9 -> 901
    //   895: ldc_w 1212
    //   898: goto +38 -> 936
    //   901: getstatic 276	kawa/standard/Scheme:isEqual	Lgnu/kawa/functions/IsEqual;
    //   904: getstatic 190	gnu/kawa/functions/BitwiseOp:and	Lgnu/kawa/functions/BitwiseOp;
    //   907: aload 4
    //   909: getstatic 720	com/ftsafe/CCIDScheme:Lit118	Lgnu/math/IntNum;
    //   912: invokevirtual 28	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   915: getstatic 357	com/ftsafe/CCIDScheme:Lit16	Lgnu/math/IntNum;
    //   918: invokevirtual 28	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   921: invokestatic 287	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   924: ifeq +9 -> 933
    //   927: ldc_w 1214
    //   930: goto +6 -> 936
    //   933: getstatic 529	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   936: aastore
    //   937: dup
    //   938: iconst_1
    //   939: ldc_w 1135
    //   942: aastore
    //   943: invokevirtual 1129	com/ftsafe/CCIDScheme$frame12:lambda32setinfo$V	(Ljava/lang/Object;[Ljava/lang/Object;)V
    //   946: goto +168 -> 1114
    //   949: getstatic 276	kawa/standard/Scheme:isEqual	Lgnu/kawa/functions/IsEqual;
    //   952: getstatic 190	gnu/kawa/functions/BitwiseOp:and	Lgnu/kawa/functions/BitwiseOp;
    //   955: aload 4
    //   957: getstatic 469	com/ftsafe/CCIDScheme:Lit20	Lgnu/math/IntNum;
    //   960: invokevirtual 28	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   963: getstatic 52	com/ftsafe/CCIDScheme:Lit1	Lgnu/math/IntNum;
    //   966: invokevirtual 28	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   969: invokestatic 287	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   972: ifeq +142 -> 1114
    //   975: aload_2
    //   976: ldc_w 1141
    //   979: iconst_2
    //   980: anewarray 76	java/lang/Object
    //   983: dup
    //   984: iconst_0
    //   985: ldc_w 1141
    //   988: aastore
    //   989: dup
    //   990: iconst_1
    //   991: ldc_w 1216
    //   994: aastore
    //   995: invokevirtual 1129	com/ftsafe/CCIDScheme$frame12:lambda32setinfo$V	(Ljava/lang/Object;[Ljava/lang/Object;)V
    //   998: aload_2
    //   999: ldc_w 1141
    //   1002: iconst_4
    //   1003: anewarray 76	java/lang/Object
    //   1006: dup
    //   1007: iconst_0
    //   1008: ldc_w 1141
    //   1011: aastore
    //   1012: dup
    //   1013: iconst_1
    //   1014: ldc_w 1218
    //   1017: aastore
    //   1018: dup
    //   1019: iconst_2
    //   1020: getstatic 155	gnu/kawa/functions/BitwiseOp:ashift	Lgnu/kawa/functions/BitwiseOp;
    //   1023: getstatic 190	gnu/kawa/functions/BitwiseOp:and	Lgnu/kawa/functions/BitwiseOp;
    //   1026: aload 4
    //   1028: getstatic 1221	com/ftsafe/CCIDScheme:Lit188	Lgnu/math/IntNum;
    //   1031: invokevirtual 28	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1034: getstatic 605	com/ftsafe/CCIDScheme:Lit102	Lgnu/math/IntNum;
    //   1037: invokevirtual 28	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1040: getstatic 109	com/ftsafe/CCIDScheme:Lit2	Lgnu/math/IntNum;
    //   1043: invokestatic 425	com/ftsafe/CCIDScheme:toBinStr	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/CharSequence;
    //   1046: aastore
    //   1047: dup
    //   1048: iconst_3
    //   1049: ldc_w 1135
    //   1052: aastore
    //   1053: invokevirtual 1129	com/ftsafe/CCIDScheme$frame12:lambda32setinfo$V	(Ljava/lang/Object;[Ljava/lang/Object;)V
    //   1056: aload_2
    //   1057: ldc_w 1141
    //   1060: iconst_4
    //   1061: anewarray 76	java/lang/Object
    //   1064: dup
    //   1065: iconst_0
    //   1066: ldc_w 1141
    //   1069: aastore
    //   1070: dup
    //   1071: iconst_1
    //   1072: ldc_w 1223
    //   1075: aastore
    //   1076: dup
    //   1077: iconst_2
    //   1078: getstatic 155	gnu/kawa/functions/BitwiseOp:ashift	Lgnu/kawa/functions/BitwiseOp;
    //   1081: getstatic 190	gnu/kawa/functions/BitwiseOp:and	Lgnu/kawa/functions/BitwiseOp;
    //   1084: aload 4
    //   1086: getstatic 1017	com/ftsafe/CCIDScheme:Lit172	Lgnu/math/IntNum;
    //   1089: invokevirtual 28	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1092: getstatic 1150	com/ftsafe/CCIDScheme:Lit182	Lgnu/math/IntNum;
    //   1095: invokevirtual 28	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1098: getstatic 109	com/ftsafe/CCIDScheme:Lit2	Lgnu/math/IntNum;
    //   1101: invokestatic 425	com/ftsafe/CCIDScheme:toBinStr	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/CharSequence;
    //   1104: aastore
    //   1105: dup
    //   1106: iconst_3
    //   1107: ldc_w 1135
    //   1110: aastore
    //   1111: invokevirtual 1129	com/ftsafe/CCIDScheme$frame12:lambda32setinfo$V	(Ljava/lang/Object;[Ljava/lang/Object;)V
    //   1114: aload_3
    //   1115: invokestatic 1226	kawa/lib/lists:caddr	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1118: astore 4
    //   1120: aload_2
    //   1121: ldc_w 1141
    //   1124: iconst_4
    //   1125: anewarray 76	java/lang/Object
    //   1128: dup
    //   1129: iconst_0
    //   1130: ldc_w 1228
    //   1133: aastore
    //   1134: dup
    //   1135: iconst_1
    //   1136: aload 4
    //   1138: invokestatic 433	com/ftsafe/CCIDScheme:toHexStr	(Ljava/lang/Object;)Ljava/lang/CharSequence;
    //   1141: aastore
    //   1142: dup
    //   1143: iconst_2
    //   1144: ldc_w 1145
    //   1147: aastore
    //   1148: dup
    //   1149: iconst_3
    //   1150: ldc_w 1135
    //   1153: aastore
    //   1154: invokevirtual 1129	com/ftsafe/CCIDScheme$frame12:lambda32setinfo$V	(Ljava/lang/Object;[Ljava/lang/Object;)V
    //   1157: aload_0
    //   1158: getstatic 587	com/ftsafe/CCIDScheme:Lit99	Lgnu/math/IntNum;
    //   1161: aload_0
    //   1162: invokestatic 323	gnu/lists/Sequences:getSize	(Ljava/lang/Object;)I
    //   1165: iconst_4
    //   1166: isub
    //   1167: invokestatic 329	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1170: invokestatic 122	com/ftsafe/CCIDScheme:slice	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1173: astore_3
    //   1174: aload_2
    //   1175: ldc_w 1230
    //   1178: iconst_2
    //   1179: anewarray 76	java/lang/Object
    //   1182: dup
    //   1183: iconst_0
    //   1184: aload_3
    //   1185: invokestatic 323	gnu/lists/Sequences:getSize	(Ljava/lang/Object;)I
    //   1188: invokestatic 329	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1191: invokestatic 433	com/ftsafe/CCIDScheme:toHexStr	(Ljava/lang/Object;)Ljava/lang/CharSequence;
    //   1194: aastore
    //   1195: dup
    //   1196: iconst_1
    //   1197: ldc_w 1232
    //   1200: aastore
    //   1201: invokevirtual 1129	com/ftsafe/CCIDScheme$frame12:lambda32setinfo$V	(Ljava/lang/Object;[Ljava/lang/Object;)V
    //   1204: aload_3
    //   1205: getstatic 165	com/ftsafe/CCIDScheme:Lit6	Lgnu/math/IntNum;
    //   1208: invokestatic 332	com/ftsafe/CCIDScheme:groupList	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1211: invokestatic 385	gnu/lists/Sequences:getIterator	(Ljava/lang/Object;)Ljava/util/Iterator;
    //   1214: astore 4
    //   1216: getstatic 132	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
    //   1219: astore 5
    //   1221: aconst_null
    //   1222: astore 6
    //   1224: aload 4
    //   1226: invokeinterface 391 1 0
    //   1231: ifeq +76 -> 1307
    //   1234: aload 4
    //   1236: invokeinterface 395 1 0
    //   1241: astore 7
    //   1243: new 98	gnu/lists/Pair
    //   1246: dup
    //   1247: aload_2
    //   1248: ldc_w 1141
    //   1251: iconst_2
    //   1252: anewarray 76	java/lang/Object
    //   1255: dup
    //   1256: iconst_0
    //   1257: aload 7
    //   1259: ldc_w 609
    //   1262: invokestatic 430	com/ftsafe/CCIDScheme:u8list$To$String	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1265: aastore
    //   1266: dup
    //   1267: iconst_1
    //   1268: ldc_w 1135
    //   1271: aastore
    //   1272: invokevirtual 1129	com/ftsafe/CCIDScheme$frame12:lambda32setinfo$V	(Ljava/lang/Object;[Ljava/lang/Object;)V
    //   1275: getstatic 529	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   1278: getstatic 132	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
    //   1281: invokespecial 404	gnu/lists/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   1284: aload 6
    //   1286: ifnonnull +9 -> 1295
    //   1289: dup
    //   1290: astore 5
    //   1292: goto +10 -> 1302
    //   1295: aload 6
    //   1297: swap
    //   1298: dup_x1
    //   1299: invokevirtual 408	gnu/lists/Pair:setCdr	(Ljava/lang/Object;)V
    //   1302: astore 6
    //   1304: goto -80 -> 1224
    //   1307: aload_0
    //   1308: aload_0
    //   1309: invokestatic 323	gnu/lists/Sequences:getSize	(Ljava/lang/Object;)I
    //   1312: iconst_1
    //   1313: isub
    //   1314: invokestatic 159	kawa/lib/lists:listRef	(Ljava/lang/Object;I)Ljava/lang/Object;
    //   1317: astore_3
    //   1318: aload_2
    //   1319: ldc_w 1234
    //   1322: iconst_2
    //   1323: anewarray 76	java/lang/Object
    //   1326: dup
    //   1327: iconst_0
    //   1328: aload_3
    //   1329: invokestatic 433	com/ftsafe/CCIDScheme:toHexStr	(Ljava/lang/Object;)Ljava/lang/CharSequence;
    //   1332: aastore
    //   1333: dup
    //   1334: iconst_1
    //   1335: ldc_w 1135
    //   1338: aastore
    //   1339: invokevirtual 1129	com/ftsafe/CCIDScheme$frame12:lambda32setinfo$V	(Ljava/lang/Object;[Ljava/lang/Object;)V
    //   1342: aload_2
    //   1343: ldc_w 1141
    //   1346: iconst_3
    //   1347: anewarray 76	java/lang/Object
    //   1350: dup
    //   1351: iconst_0
    //   1352: ldc_w 1236
    //   1355: aastore
    //   1356: dup
    //   1357: iconst_1
    //   1358: aload_0
    //   1359: getstatic 52	com/ftsafe/CCIDScheme:Lit1	Lgnu/math/IntNum;
    //   1362: aload_0
    //   1363: invokestatic 323	gnu/lists/Sequences:getSize	(Ljava/lang/Object;)I
    //   1366: iconst_1
    //   1367: isub
    //   1368: invokestatic 329	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1371: invokestatic 122	com/ftsafe/CCIDScheme:slice	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1374: invokestatic 354	com/ftsafe/CCIDScheme:listXor	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1377: invokestatic 433	com/ftsafe/CCIDScheme:toHexStr	(Ljava/lang/Object;)Ljava/lang/CharSequence;
    //   1380: aastore
    //   1381: dup
    //   1382: iconst_2
    //   1383: ldc_w 1135
    //   1386: aastore
    //   1387: invokevirtual 1129	com/ftsafe/CCIDScheme$frame12:lambda32setinfo$V	(Ljava/lang/Object;[Ljava/lang/Object;)V
    //   1390: aload_2
    //   1391: ldc_w 1125
    //   1394: iconst_0
    //   1395: anewarray 76	java/lang/Object
    //   1398: invokevirtual 1129	com/ftsafe/CCIDScheme$frame12:lambda32setinfo$V	(Ljava/lang/Object;[Ljava/lang/Object;)V
    //   1401: aload_1
    //   1402: invokestatic 287	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   1405: ifeq +14 -> 1419
    //   1408: getstatic 317	com/ftsafe/CCIDScheme:pp	Lgnu/mapping/Procedure;
    //   1411: aload_2
    //   1412: getfield 1123	com/ftsafe/CCIDScheme$frame12:info	Ljava/lang/Object;
    //   1415: invokevirtual 780	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1418: pop
    //   1419: getstatic 52	com/ftsafe/CCIDScheme:Lit1	Lgnu/math/IntNum;
    //   1422: aload_0
    //   1423: invokestatic 354	com/ftsafe/CCIDScheme:listXor	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1426: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   1429: ifeq +550 -> 1979
    //   1432: aload_0
    //   1433: getstatic 52	com/ftsafe/CCIDScheme:Lit1	Lgnu/math/IntNum;
    //   1436: getstatic 587	com/ftsafe/CCIDScheme:Lit99	Lgnu/math/IntNum;
    //   1439: invokestatic 122	com/ftsafe/CCIDScheme:slice	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1442: astore_3
    //   1443: aload_0
    //   1444: getstatic 587	com/ftsafe/CCIDScheme:Lit99	Lgnu/math/IntNum;
    //   1447: aload_0
    //   1448: invokestatic 323	gnu/lists/Sequences:getSize	(Ljava/lang/Object;)I
    //   1451: iconst_4
    //   1452: isub
    //   1453: invokestatic 329	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1456: invokestatic 122	com/ftsafe/CCIDScheme:slice	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1459: astore 4
    //   1461: aload_0
    //   1462: aload_0
    //   1463: invokestatic 323	gnu/lists/Sequences:getSize	(Ljava/lang/Object;)I
    //   1466: iconst_1
    //   1467: isub
    //   1468: invokestatic 159	kawa/lib/lists:listRef	(Ljava/lang/Object;I)Ljava/lang/Object;
    //   1471: pop
    //   1472: getstatic 190	gnu/kawa/functions/BitwiseOp:and	Lgnu/kawa/functions/BitwiseOp;
    //   1475: aload_3
    //   1476: invokestatic 581	kawa/lib/lists:cadr	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1479: getstatic 602	com/ftsafe/CCIDScheme:Lit101	Lgnu/math/IntNum;
    //   1482: invokevirtual 28	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1485: getstatic 602	com/ftsafe/CCIDScheme:Lit101	Lgnu/math/IntNum;
    //   1488: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   1491: ifeq +301 -> 1792
    //   1494: getstatic 1239	com/ftsafe/CCIDScheme:Lit189	Lgnu/mapping/SimpleSymbol;
    //   1497: getstatic 1242	com/ftsafe/CCIDScheme:Lit190	Lgnu/mapping/SimpleSymbol;
    //   1500: getstatic 276	kawa/standard/Scheme:isEqual	Lgnu/kawa/functions/IsEqual;
    //   1503: getstatic 190	gnu/kawa/functions/BitwiseOp:and	Lgnu/kawa/functions/BitwiseOp;
    //   1506: aload_3
    //   1507: invokestatic 581	kawa/lib/lists:cadr	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1510: getstatic 1169	com/ftsafe/CCIDScheme:Lit185	Lgnu/math/IntNum;
    //   1513: invokevirtual 28	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1516: getstatic 52	com/ftsafe/CCIDScheme:Lit1	Lgnu/math/IntNum;
    //   1519: invokevirtual 28	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1522: invokestatic 287	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   1525: ifeq +9 -> 1534
    //   1528: getstatic 1245	com/ftsafe/CCIDScheme:Lit191	Lgnu/mapping/SimpleSymbol;
    //   1531: goto +244 -> 1775
    //   1534: getstatic 276	kawa/standard/Scheme:isEqual	Lgnu/kawa/functions/IsEqual;
    //   1537: getstatic 190	gnu/kawa/functions/BitwiseOp:and	Lgnu/kawa/functions/BitwiseOp;
    //   1540: aload_3
    //   1541: invokestatic 581	kawa/lib/lists:cadr	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1544: getstatic 1169	com/ftsafe/CCIDScheme:Lit185	Lgnu/math/IntNum;
    //   1547: invokevirtual 28	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1550: getstatic 1017	com/ftsafe/CCIDScheme:Lit172	Lgnu/math/IntNum;
    //   1553: invokevirtual 28	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1556: invokestatic 287	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   1559: ifeq +9 -> 1568
    //   1562: getstatic 1248	com/ftsafe/CCIDScheme:Lit192	Lgnu/mapping/SimpleSymbol;
    //   1565: goto +210 -> 1775
    //   1568: getstatic 276	kawa/standard/Scheme:isEqual	Lgnu/kawa/functions/IsEqual;
    //   1571: getstatic 190	gnu/kawa/functions/BitwiseOp:and	Lgnu/kawa/functions/BitwiseOp;
    //   1574: aload_3
    //   1575: invokestatic 581	kawa/lib/lists:cadr	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1578: getstatic 1169	com/ftsafe/CCIDScheme:Lit185	Lgnu/math/IntNum;
    //   1581: invokevirtual 28	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1584: getstatic 109	com/ftsafe/CCIDScheme:Lit2	Lgnu/math/IntNum;
    //   1587: invokevirtual 28	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1590: invokestatic 287	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   1593: ifeq +9 -> 1602
    //   1596: getstatic 1251	com/ftsafe/CCIDScheme:Lit193	Lgnu/mapping/SimpleSymbol;
    //   1599: goto +176 -> 1775
    //   1602: getstatic 276	kawa/standard/Scheme:isEqual	Lgnu/kawa/functions/IsEqual;
    //   1605: getstatic 190	gnu/kawa/functions/BitwiseOp:and	Lgnu/kawa/functions/BitwiseOp;
    //   1608: aload_3
    //   1609: invokestatic 581	kawa/lib/lists:cadr	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1612: getstatic 1169	com/ftsafe/CCIDScheme:Lit185	Lgnu/math/IntNum;
    //   1615: invokevirtual 28	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1618: getstatic 1180	com/ftsafe/CCIDScheme:Lit68	Lgnu/math/IntNum;
    //   1621: invokevirtual 28	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1624: invokestatic 287	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   1627: ifeq +9 -> 1636
    //   1630: getstatic 1254	com/ftsafe/CCIDScheme:Lit194	Lgnu/mapping/SimpleSymbol;
    //   1633: goto +142 -> 1775
    //   1636: getstatic 276	kawa/standard/Scheme:isEqual	Lgnu/kawa/functions/IsEqual;
    //   1639: getstatic 190	gnu/kawa/functions/BitwiseOp:and	Lgnu/kawa/functions/BitwiseOp;
    //   1642: aload_3
    //   1643: invokestatic 581	kawa/lib/lists:cadr	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1646: getstatic 1169	com/ftsafe/CCIDScheme:Lit185	Lgnu/math/IntNum;
    //   1649: invokevirtual 28	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1652: getstatic 357	com/ftsafe/CCIDScheme:Lit16	Lgnu/math/IntNum;
    //   1655: invokevirtual 28	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1658: invokestatic 287	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   1661: ifeq +9 -> 1670
    //   1664: getstatic 1257	com/ftsafe/CCIDScheme:Lit195	Lgnu/mapping/SimpleSymbol;
    //   1667: goto +108 -> 1775
    //   1670: getstatic 276	kawa/standard/Scheme:isEqual	Lgnu/kawa/functions/IsEqual;
    //   1673: getstatic 190	gnu/kawa/functions/BitwiseOp:and	Lgnu/kawa/functions/BitwiseOp;
    //   1676: aload_3
    //   1677: invokestatic 581	kawa/lib/lists:cadr	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1680: getstatic 1169	com/ftsafe/CCIDScheme:Lit185	Lgnu/math/IntNum;
    //   1683: invokevirtual 28	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1686: getstatic 1187	com/ftsafe/CCIDScheme:Lit186	Lgnu/math/IntNum;
    //   1689: invokevirtual 28	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1692: invokestatic 287	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   1695: ifeq +9 -> 1704
    //   1698: getstatic 1260	com/ftsafe/CCIDScheme:Lit196	Lgnu/mapping/SimpleSymbol;
    //   1701: goto +74 -> 1775
    //   1704: getstatic 276	kawa/standard/Scheme:isEqual	Lgnu/kawa/functions/IsEqual;
    //   1707: getstatic 190	gnu/kawa/functions/BitwiseOp:and	Lgnu/kawa/functions/BitwiseOp;
    //   1710: aload_3
    //   1711: invokestatic 581	kawa/lib/lists:cadr	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1714: getstatic 1169	com/ftsafe/CCIDScheme:Lit185	Lgnu/math/IntNum;
    //   1717: invokevirtual 28	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1720: getstatic 587	com/ftsafe/CCIDScheme:Lit99	Lgnu/math/IntNum;
    //   1723: invokevirtual 28	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1726: invokestatic 287	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   1729: ifeq +9 -> 1738
    //   1732: getstatic 1263	com/ftsafe/CCIDScheme:Lit197	Lgnu/mapping/SimpleSymbol;
    //   1735: goto +40 -> 1775
    //   1738: getstatic 276	kawa/standard/Scheme:isEqual	Lgnu/kawa/functions/IsEqual;
    //   1741: getstatic 190	gnu/kawa/functions/BitwiseOp:and	Lgnu/kawa/functions/BitwiseOp;
    //   1744: aload_3
    //   1745: invokestatic 581	kawa/lib/lists:cadr	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1748: getstatic 1169	com/ftsafe/CCIDScheme:Lit185	Lgnu/math/IntNum;
    //   1751: invokevirtual 28	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1754: getstatic 1194	com/ftsafe/CCIDScheme:Lit187	Lgnu/math/IntNum;
    //   1757: invokevirtual 28	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1760: invokestatic 287	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   1763: ifeq +9 -> 1772
    //   1766: getstatic 1266	com/ftsafe/CCIDScheme:Lit198	Lgnu/mapping/SimpleSymbol;
    //   1769: goto +6 -> 1775
    //   1772: getstatic 1269	com/ftsafe/CCIDScheme:Lit199	Lgnu/mapping/SimpleSymbol;
    //   1775: invokestatic 213	gnu/lists/LList:list2	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   1778: getstatic 1272	com/ftsafe/CCIDScheme:Lit200	Lgnu/mapping/SimpleSymbol;
    //   1781: aload 4
    //   1783: invokestatic 213	gnu/lists/LList:list2	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   1786: invokestatic 756	gnu/lists/LList:list3	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   1789: goto +199 -> 1988
    //   1792: getstatic 190	gnu/kawa/functions/BitwiseOp:and	Lgnu/kawa/functions/BitwiseOp;
    //   1795: aload_3
    //   1796: invokestatic 581	kawa/lib/lists:cadr	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1799: getstatic 602	com/ftsafe/CCIDScheme:Lit101	Lgnu/math/IntNum;
    //   1802: invokevirtual 28	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1805: getstatic 469	com/ftsafe/CCIDScheme:Lit20	Lgnu/math/IntNum;
    //   1808: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   1811: ifeq +67 -> 1878
    //   1814: getstatic 1275	com/ftsafe/CCIDScheme:Lit201	Lgnu/mapping/SimpleSymbol;
    //   1817: getstatic 1278	com/ftsafe/CCIDScheme:Lit202	Lgnu/mapping/SimpleSymbol;
    //   1820: getstatic 155	gnu/kawa/functions/BitwiseOp:ashift	Lgnu/kawa/functions/BitwiseOp;
    //   1823: getstatic 190	gnu/kawa/functions/BitwiseOp:and	Lgnu/kawa/functions/BitwiseOp;
    //   1826: aload_3
    //   1827: invokestatic 581	kawa/lib/lists:cadr	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1830: getstatic 165	com/ftsafe/CCIDScheme:Lit6	Lgnu/math/IntNum;
    //   1833: invokevirtual 28	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1836: getstatic 877	com/ftsafe/CCIDScheme:Lit151	Lgnu/math/IntNum;
    //   1839: invokevirtual 28	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1842: invokestatic 213	gnu/lists/LList:list2	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   1845: getstatic 1281	com/ftsafe/CCIDScheme:Lit203	Lgnu/mapping/SimpleSymbol;
    //   1848: getstatic 190	gnu/kawa/functions/BitwiseOp:and	Lgnu/kawa/functions/BitwiseOp;
    //   1851: aload_3
    //   1852: invokestatic 581	kawa/lib/lists:cadr	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1855: getstatic 720	com/ftsafe/CCIDScheme:Lit118	Lgnu/math/IntNum;
    //   1858: invokevirtual 28	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1861: invokestatic 213	gnu/lists/LList:list2	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   1864: getstatic 1272	com/ftsafe/CCIDScheme:Lit200	Lgnu/mapping/SimpleSymbol;
    //   1867: aload 4
    //   1869: invokestatic 213	gnu/lists/LList:list2	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   1872: invokestatic 206	gnu/lists/LList:list4	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   1875: goto +113 -> 1988
    //   1878: getstatic 190	gnu/kawa/functions/BitwiseOp:and	Lgnu/kawa/functions/BitwiseOp;
    //   1881: aload_3
    //   1882: invokestatic 581	kawa/lib/lists:cadr	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1885: getstatic 469	com/ftsafe/CCIDScheme:Lit20	Lgnu/math/IntNum;
    //   1888: invokevirtual 28	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1891: getstatic 52	com/ftsafe/CCIDScheme:Lit1	Lgnu/math/IntNum;
    //   1894: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   1897: ifeq +76 -> 1973
    //   1900: getstatic 1284	com/ftsafe/CCIDScheme:Lit204	Lgnu/mapping/SimpleSymbol;
    //   1903: getstatic 1287	com/ftsafe/CCIDScheme:Lit205	Lgnu/mapping/SimpleSymbol;
    //   1906: getstatic 155	gnu/kawa/functions/BitwiseOp:ashift	Lgnu/kawa/functions/BitwiseOp;
    //   1909: getstatic 190	gnu/kawa/functions/BitwiseOp:and	Lgnu/kawa/functions/BitwiseOp;
    //   1912: aload_3
    //   1913: invokestatic 581	kawa/lib/lists:cadr	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1916: getstatic 1221	com/ftsafe/CCIDScheme:Lit188	Lgnu/math/IntNum;
    //   1919: invokevirtual 28	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1922: getstatic 605	com/ftsafe/CCIDScheme:Lit102	Lgnu/math/IntNum;
    //   1925: invokevirtual 28	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1928: invokestatic 213	gnu/lists/LList:list2	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   1931: getstatic 1290	com/ftsafe/CCIDScheme:Lit206	Lgnu/mapping/SimpleSymbol;
    //   1934: getstatic 155	gnu/kawa/functions/BitwiseOp:ashift	Lgnu/kawa/functions/BitwiseOp;
    //   1937: getstatic 190	gnu/kawa/functions/BitwiseOp:and	Lgnu/kawa/functions/BitwiseOp;
    //   1940: aload_3
    //   1941: invokestatic 581	kawa/lib/lists:cadr	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1944: getstatic 1017	com/ftsafe/CCIDScheme:Lit172	Lgnu/math/IntNum;
    //   1947: invokevirtual 28	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1950: getstatic 1150	com/ftsafe/CCIDScheme:Lit182	Lgnu/math/IntNum;
    //   1953: invokevirtual 28	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1956: invokestatic 213	gnu/lists/LList:list2	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   1959: getstatic 1272	com/ftsafe/CCIDScheme:Lit200	Lgnu/mapping/SimpleSymbol;
    //   1962: aload 4
    //   1964: invokestatic 213	gnu/lists/LList:list2	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   1967: invokestatic 206	gnu/lists/LList:list4	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   1970: goto +18 -> 1988
    //   1973: getstatic 529	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   1976: goto +12 -> 1988
    //   1979: getstatic 317	com/ftsafe/CCIDScheme:pp	Lgnu/mapping/Procedure;
    //   1982: ldc_w 1292
    //   1985: invokevirtual 780	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1988: areturn
    //   1989: new 66	gnu/mapping/WrongType
    //   1992: dup_x1
    //   1993: swap
    //   1994: ldc 116
    //   1996: iconst_1
    //   1997: aload 5
    //   1999: invokespecial 71	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   2002: athrow
    // Line number table:
    //   Java source line #11465	-> byte code offset #0
    //   Java source line #11466	-> byte code offset #8
    //   Java source line #11467	-> byte code offset #16
    //   Java source line #11469	-> byte code offset #16
    //   Java source line #11467	-> byte code offset #16
    //   Java source line #11470	-> byte code offset #16
    //   Java source line #11471	-> byte code offset #27
    //   Java source line #11472	-> byte code offset #54
    //   Java source line #11473	-> byte code offset #65
    //   Java source line #11474	-> byte code offset #89
    //   Java source line #11475	-> byte code offset #106
    //   Java source line #11476	-> byte code offset #143
    //   Java source line #11477	-> byte code offset #207
    //   Java source line #11478	-> byte code offset #271
    //   Java source line #11479	-> byte code offset #277
    //   Java source line #11480	-> byte code offset #314
    //   Java source line #11481	-> byte code offset #340
    //   Java source line #11482	-> byte code offset #340
    //   Java source line #11483	-> byte code offset #363
    //   Java source line #11484	-> byte code offset #415
    //   Java source line #11485	-> byte code offset #447
    //   Java source line #11486	-> byte code offset #479
    //   Java source line #11487	-> byte code offset #511
    //   Java source line #11488	-> byte code offset #543
    //   Java source line #11489	-> byte code offset #575
    //   Java source line #11490	-> byte code offset #607
    //   Java source line #11491	-> byte code offset #639
    //   Java source line #11492	-> byte code offset #668
    //   Java source line #11493	-> byte code offset #687
    //   Java source line #11494	-> byte code offset #710
    //   Java source line #11495	-> byte code offset #710
    //   Java source line #11496	-> byte code offset #733
    //   Java source line #11497	-> byte code offset #756
    //   Java source line #11498	-> byte code offset #802
    //   Java source line #11499	-> byte code offset #827
    //   Java source line #11500	-> byte code offset #872
    //   Java source line #11501	-> byte code offset #904
    //   Java source line #11504	-> byte code offset #952
    //   Java source line #11505	-> byte code offset #975
    //   Java source line #11506	-> byte code offset #975
    //   Java source line #11507	-> byte code offset #998
    //   Java source line #11508	-> byte code offset #1056
    //   Java source line #11509	-> byte code offset #1114
    //   Java source line #11510	-> byte code offset #1120
    //   Java source line #11511	-> byte code offset #1157
    //   Java source line #11512	-> byte code offset #1174
    //   Java source line #11513	-> byte code offset #1204
    //   Java source line #11514	-> byte code offset #1307
    //   Java source line #11515	-> byte code offset #1318
    //   Java source line #11516	-> byte code offset #1342
    //   Java source line #11517	-> byte code offset #1390
    //   Java source line #11518	-> byte code offset #1401
    //   Java source line #11520	-> byte code offset #1419
    //   Java source line #11521	-> byte code offset #1432
    //   Java source line #11522	-> byte code offset #1443
    //   Java source line #11521	-> byte code offset #1461
    //   Java source line #11523	-> byte code offset #1461
    //   Java source line #11524	-> byte code offset #1472
    //   Java source line #11525	-> byte code offset #1494
    //   Java source line #11526	-> byte code offset #1503
    //   Java source line #11527	-> byte code offset #1537
    //   Java source line #11528	-> byte code offset #1571
    //   Java source line #11529	-> byte code offset #1605
    //   Java source line #11530	-> byte code offset #1639
    //   Java source line #11531	-> byte code offset #1673
    //   Java source line #11532	-> byte code offset #1707
    //   Java source line #11533	-> byte code offset #1741
    //   Java source line #11536	-> byte code offset #1792
    //   Java source line #11537	-> byte code offset #1814
    //   Java source line #11538	-> byte code offset #1823
    //   Java source line #11539	-> byte code offset #1851
    //   Java source line #11541	-> byte code offset #1878
    //   Java source line #11542	-> byte code offset #1900
    //   Java source line #11543	-> byte code offset #1909
    //   Java source line #11544	-> byte code offset #1937
    //   Java source line #11546	-> byte code offset #1979
    //   Java source line #11474	-> byte code offset #1989
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1988	0	data	Object
    //   0	1988	1	_debug	Object
    //   8	1980	2	$heapFrame	frame12
    //   65	1092	3	PF	Object
    //   1174	133	3	IF	Object
    //   1318	72	3	EF	Object
    //   1443	533	3	PF	Object
    //   106	165	4	NAD	Object
    //   277	837	4	PCB	Object
    //   1120	37	4	LEN	Object
    //   1461	515	4	IF	Object
    // Exception table:
    //   from	to	target	type
    //   98	101	1989	java/lang/ClassCastException
  }
  
  /* Error */
  public static gnu.mapping.Procedure makeGET_DEVICE_INFFunc(Object usb_control_in, Object descriptor$Mninfo)
  {
    // Byte code:
    //   0: new 1327	com/ftsafe/CCIDScheme$frame13
    //   3: dup
    //   4: invokespecial 1328	com/ftsafe/CCIDScheme$frame13:<init>	()V
    //   7: astore_2
    //   8: getstatic 1331	com/ftsafe/CCIDScheme:Lit45	Lgnu/mapping/SimpleSymbol;
    //   11: getstatic 1334	com/ftsafe/CCIDScheme:Lit215	Lgnu/mapping/SimpleSymbol;
    //   14: aload_1
    //   15: invokestatic 348	kawa/lib/lists:assoc	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   18: ldc 98
    //   20: invokestatic 101	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   23: dup
    //   24: astore 4
    //   26: checkcast 98	gnu/lists/Pair
    //   29: invokestatic 106	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   32: invokestatic 348	kawa/lib/lists:assoc	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   35: invokestatic 581	kawa/lib/lists:cadr	(Ljava/lang/Object;)Ljava/lang/Object;
    //   38: astore_3
    //   39: aload_3
    //   40: getstatic 52	com/ftsafe/CCIDScheme:Lit1	Lgnu/math/IntNum;
    //   43: invokestatic 1338	com/ftsafe/CCIDScheme$frame13:lambda33loop	(Ljava/lang/Object;Lgnu/math/IntNum;)Ljava/lang/Object;
    //   46: invokestatic 385	gnu/lists/Sequences:getIterator	(Ljava/lang/Object;)Ljava/util/Iterator;
    //   49: astore 4
    //   51: getstatic 132	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
    //   54: astore 5
    //   56: aconst_null
    //   57: astore 6
    //   59: aload 4
    //   61: invokeinterface 391 1 0
    //   66: ifeq +858 -> 924
    //   69: aload 4
    //   71: invokeinterface 395 1 0
    //   76: astore 7
    //   78: iconst_2
    //   79: anewarray 76	java/lang/Object
    //   82: dup
    //   83: iconst_0
    //   84: ldc_w 514
    //   87: aastore
    //   88: dup
    //   89: iconst_1
    //   90: aload 7
    //   92: ldc 58
    //   94: invokestatic 101	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   97: dup
    //   98: astore 11
    //   100: checkcast 58	java/lang/Number
    //   103: invokestatic 517	kawa/lib/numbers:number$To$String	(Ljava/lang/Number;)Ljava/lang/CharSequence;
    //   106: aastore
    //   107: invokestatic 416	kawa/lib/strings:stringAppend	([Ljava/lang/Object;)Lgnu/lists/FString;
    //   110: invokestatic 523	kawa/lib/misc:string$To$Symbol	(Ljava/lang/CharSequence;)Lgnu/mapping/SimpleSymbol;
    //   113: astore 10
    //   115: aload 10
    //   117: aload_1
    //   118: invokestatic 348	kawa/lib/lists:assoc	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   121: ldc 98
    //   123: invokestatic 101	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   126: dup
    //   127: astore 12
    //   129: checkcast 98	gnu/lists/Pair
    //   132: invokestatic 106	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   135: astore 11
    //   137: getstatic 1341	com/ftsafe/CCIDScheme:Lit57	Lgnu/mapping/SimpleSymbol;
    //   140: getstatic 901	com/ftsafe/CCIDScheme:Lit158	Lgnu/mapping/SimpleSymbol;
    //   143: aload 11
    //   145: invokestatic 348	kawa/lib/lists:assoc	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   148: ldc 98
    //   150: invokestatic 101	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   153: dup
    //   154: astore 13
    //   156: checkcast 98	gnu/lists/Pair
    //   159: invokestatic 106	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   162: invokestatic 348	kawa/lib/lists:assoc	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   165: invokestatic 581	kawa/lib/lists:cadr	(Ljava/lang/Object;)Ljava/lang/Object;
    //   168: astore 12
    //   170: getstatic 1344	com/ftsafe/CCIDScheme:Lit39	Lgnu/mapping/SimpleSymbol;
    //   173: getstatic 1347	com/ftsafe/CCIDScheme:Lit216	Lgnu/mapping/SimpleSymbol;
    //   176: aload_1
    //   177: invokestatic 348	kawa/lib/lists:assoc	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   180: ldc 98
    //   182: invokestatic 101	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   185: dup
    //   186: astore 14
    //   188: checkcast 98	gnu/lists/Pair
    //   191: invokestatic 106	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   194: invokestatic 348	kawa/lib/lists:assoc	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   197: invokestatic 581	kawa/lib/lists:cadr	(Ljava/lang/Object;)Ljava/lang/Object;
    //   200: astore 13
    //   202: getstatic 1350	com/ftsafe/CCIDScheme:Lit40	Lgnu/mapping/SimpleSymbol;
    //   205: getstatic 1347	com/ftsafe/CCIDScheme:Lit216	Lgnu/mapping/SimpleSymbol;
    //   208: aload_1
    //   209: invokestatic 348	kawa/lib/lists:assoc	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   212: ldc 98
    //   214: invokestatic 101	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   217: dup
    //   218: astore 15
    //   220: checkcast 98	gnu/lists/Pair
    //   223: invokestatic 106	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   226: invokestatic 348	kawa/lib/lists:assoc	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   229: invokestatic 581	kawa/lib/lists:cadr	(Ljava/lang/Object;)Ljava/lang/Object;
    //   232: astore 14
    //   234: aload_0
    //   235: aload 13
    //   237: invokestatic 1353	com/ftsafe/CCIDScheme:getStringDescriptor	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/CharSequence;
    //   240: astore 15
    //   242: aload_0
    //   243: aload 14
    //   245: invokestatic 1353	com/ftsafe/CCIDScheme:getStringDescriptor	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/CharSequence;
    //   248: astore 16
    //   250: getstatic 1356	com/ftsafe/CCIDScheme:Lit217	Lgnu/mapping/SimpleSymbol;
    //   253: aload_1
    //   254: invokestatic 348	kawa/lib/lists:assoc	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   257: invokestatic 287	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   260: ifeq +127 -> 387
    //   263: getstatic 1356	com/ftsafe/CCIDScheme:Lit217	Lgnu/mapping/SimpleSymbol;
    //   266: aload_1
    //   267: invokestatic 348	kawa/lib/lists:assoc	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   270: ldc 98
    //   272: invokestatic 101	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   275: dup
    //   276: astore 19
    //   278: checkcast 98	gnu/lists/Pair
    //   281: invokestatic 106	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   284: astore 18
    //   286: aload 18
    //   288: invokestatic 385	gnu/lists/Sequences:getIterator	(Ljava/lang/Object;)Ljava/util/Iterator;
    //   291: astore 19
    //   293: getstatic 132	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
    //   296: astore 20
    //   298: aconst_null
    //   299: astore 21
    //   301: aload 19
    //   303: invokeinterface 391 1 0
    //   308: ifeq +71 -> 379
    //   311: aload 19
    //   313: invokeinterface 395 1 0
    //   318: astore 22
    //   320: new 98	gnu/lists/Pair
    //   323: dup
    //   324: aload 22
    //   326: ldc 98
    //   328: invokestatic 101	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   331: dup
    //   332: astore 25
    //   334: checkcast 98	gnu/lists/Pair
    //   337: invokestatic 106	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   340: astore 24
    //   342: aload 24
    //   344: getstatic 52	com/ftsafe/CCIDScheme:Lit1	Lgnu/math/IntNum;
    //   347: invokestatic 1359	com/ftsafe/CCIDScheme$frame13:lambda34loop	(Ljava/lang/Object;Lgnu/math/IntNum;)Ljava/lang/Object;
    //   350: getstatic 132	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
    //   353: invokespecial 404	gnu/lists/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   356: aload 21
    //   358: ifnonnull +9 -> 367
    //   361: dup
    //   362: astore 20
    //   364: goto +10 -> 374
    //   367: aload 21
    //   369: swap
    //   370: dup_x1
    //   371: invokevirtual 408	gnu/lists/Pair:setCdr	(Ljava/lang/Object;)V
    //   374: astore 21
    //   376: goto -75 -> 301
    //   379: aload 20
    //   381: invokestatic 466	com/ftsafe/CCIDScheme:alist$To$List	(Ljava/lang/Object;)Ljava/lang/Object;
    //   384: goto +6 -> 390
    //   387: getstatic 247	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   390: astore 17
    //   392: iconst_2
    //   393: anewarray 76	java/lang/Object
    //   396: dup
    //   397: iconst_0
    //   398: aload 7
    //   400: getstatic 1362	com/ftsafe/CCIDScheme:Lit218	Lgnu/mapping/SimpleSymbol;
    //   403: iconst_3
    //   404: anewarray 76	java/lang/Object
    //   407: dup
    //   408: iconst_0
    //   409: aload 15
    //   411: aastore
    //   412: dup
    //   413: iconst_1
    //   414: ldc_w 609
    //   417: aastore
    //   418: dup
    //   419: iconst_2
    //   420: getstatic 52	com/ftsafe/CCIDScheme:Lit1	Lgnu/math/IntNum;
    //   423: aload 12
    //   425: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   428: ifne +12 -> 440
    //   431: aload_0
    //   432: aload 12
    //   434: invokestatic 1353	com/ftsafe/CCIDScheme:getStringDescriptor	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/CharSequence;
    //   437: goto +299 -> 736
    //   440: aload 17
    //   442: invokestatic 287	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   445: ifeq +7 -> 452
    //   448: iconst_0
    //   449: goto +4 -> 453
    //   452: iconst_1
    //   453: istore 18
    //   455: iload 18
    //   457: ifeq +11 -> 468
    //   460: iload 18
    //   462: ifeq +147 -> 609
    //   465: goto +78 -> 543
    //   468: aload 7
    //   470: aload 17
    //   472: invokestatic 348	kawa/lib/lists:assoc	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   475: invokestatic 287	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   478: ifeq +7 -> 485
    //   481: iconst_0
    //   482: goto +4 -> 486
    //   485: iconst_1
    //   486: istore 19
    //   488: iload 19
    //   490: ifeq +11 -> 501
    //   493: iload 19
    //   495: ifeq +114 -> 609
    //   498: goto +45 -> 543
    //   501: getstatic 276	kawa/standard/Scheme:isEqual	Lgnu/kawa/functions/IsEqual;
    //   504: getstatic 1365	com/ftsafe/CCIDScheme:Lit219	Lgnu/lists/PairWithPosition;
    //   507: getstatic 1368	com/ftsafe/CCIDScheme:Lit96	Lgnu/mapping/SimpleSymbol;
    //   510: aload 7
    //   512: aload 17
    //   514: invokestatic 348	kawa/lib/lists:assoc	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   517: ldc 98
    //   519: invokestatic 101	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   522: dup
    //   523: astore 20
    //   525: checkcast 98	gnu/lists/Pair
    //   528: invokestatic 106	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   531: invokestatic 348	kawa/lib/lists:assoc	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   534: invokevirtual 28	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   537: invokestatic 287	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   540: ifeq +69 -> 609
    //   543: iconst_2
    //   544: anewarray 76	java/lang/Object
    //   547: dup
    //   548: iconst_0
    //   549: aload 16
    //   551: aastore
    //   552: dup
    //   553: iconst_1
    //   554: aload_3
    //   555: getstatic 109	com/ftsafe/CCIDScheme:Lit2	Lgnu/math/IntNum;
    //   558: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   561: ifeq +9 -> 570
    //   564: ldc_w 427
    //   567: goto +35 -> 602
    //   570: iconst_2
    //   571: anewarray 76	java/lang/Object
    //   574: dup
    //   575: iconst_0
    //   576: ldc_w 609
    //   579: aastore
    //   580: dup
    //   581: iconst_1
    //   582: aload 7
    //   584: ldc 58
    //   586: invokestatic 101	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   589: dup
    //   590: astore 19
    //   592: checkcast 58	java/lang/Number
    //   595: invokestatic 517	kawa/lib/numbers:number$To$String	(Ljava/lang/Number;)Ljava/lang/CharSequence;
    //   598: aastore
    //   599: invokestatic 416	kawa/lib/strings:stringAppend	([Ljava/lang/Object;)Lgnu/lists/FString;
    //   602: aastore
    //   603: invokestatic 416	kawa/lib/strings:stringAppend	([Ljava/lang/Object;)Lgnu/lists/FString;
    //   606: goto +130 -> 736
    //   609: iconst_2
    //   610: anewarray 76	java/lang/Object
    //   613: dup
    //   614: iconst_0
    //   615: aload_0
    //   616: getstatic 1368	com/ftsafe/CCIDScheme:Lit96	Lgnu/mapping/SimpleSymbol;
    //   619: aload 7
    //   621: aload 17
    //   623: invokestatic 348	kawa/lib/lists:assoc	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   626: ldc 98
    //   628: invokestatic 101	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   631: dup
    //   632: astore 19
    //   634: checkcast 98	gnu/lists/Pair
    //   637: invokestatic 106	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   640: invokestatic 348	kawa/lib/lists:assoc	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   643: invokestatic 581	kawa/lib/lists:cadr	(Ljava/lang/Object;)Ljava/lang/Object;
    //   646: invokestatic 1353	com/ftsafe/CCIDScheme:getStringDescriptor	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/CharSequence;
    //   649: aastore
    //   650: dup
    //   651: iconst_1
    //   652: getstatic 276	kawa/standard/Scheme:isEqual	Lgnu/kawa/functions/IsEqual;
    //   655: getstatic 1371	com/ftsafe/CCIDScheme:Lit220	Lgnu/lists/PairWithPosition;
    //   658: getstatic 1374	com/ftsafe/CCIDScheme:Lit92	Lgnu/mapping/SimpleSymbol;
    //   661: aload 7
    //   663: aload 17
    //   665: invokestatic 348	kawa/lib/lists:assoc	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   668: ldc 98
    //   670: invokestatic 101	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   673: dup
    //   674: astore 19
    //   676: checkcast 98	gnu/lists/Pair
    //   679: invokestatic 106	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   682: invokestatic 348	kawa/lib/lists:assoc	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   685: invokevirtual 28	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   688: invokestatic 287	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   691: ifeq +9 -> 700
    //   694: ldc_w 427
    //   697: goto +35 -> 732
    //   700: iconst_2
    //   701: anewarray 76	java/lang/Object
    //   704: dup
    //   705: iconst_0
    //   706: ldc_w 609
    //   709: aastore
    //   710: dup
    //   711: iconst_1
    //   712: aload 7
    //   714: ldc 58
    //   716: invokestatic 101	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   719: dup
    //   720: astore 19
    //   722: checkcast 58	java/lang/Number
    //   725: invokestatic 517	kawa/lib/numbers:number$To$String	(Ljava/lang/Number;)Ljava/lang/CharSequence;
    //   728: aastore
    //   729: invokestatic 416	kawa/lib/strings:stringAppend	([Ljava/lang/Object;)Lgnu/lists/FString;
    //   732: aastore
    //   733: invokestatic 416	kawa/lib/strings:stringAppend	([Ljava/lang/Object;)Lgnu/lists/FString;
    //   736: aastore
    //   737: invokestatic 416	kawa/lib/strings:stringAppend	([Ljava/lang/Object;)Lgnu/lists/FString;
    //   740: invokestatic 213	gnu/lists/LList:list2	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   743: getstatic 1377	com/ftsafe/CCIDScheme:Lit221	Lgnu/mapping/SimpleSymbol;
    //   746: getstatic 1380	com/ftsafe/CCIDScheme:Lit59	Lgnu/mapping/SimpleSymbol;
    //   749: getstatic 1383	com/ftsafe/CCIDScheme:Lit222	Lgnu/mapping/SimpleSymbol;
    //   752: aload 11
    //   754: invokestatic 348	kawa/lib/lists:assoc	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   757: ldc 98
    //   759: invokestatic 101	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   762: dup
    //   763: astore 18
    //   765: checkcast 98	gnu/lists/Pair
    //   768: invokestatic 106	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   771: invokestatic 348	kawa/lib/lists:assoc	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   774: invokestatic 581	kawa/lib/lists:cadr	(Ljava/lang/Object;)Ljava/lang/Object;
    //   777: invokestatic 213	gnu/lists/LList:list2	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   780: getstatic 1386	com/ftsafe/CCIDScheme:Lit223	Lgnu/mapping/SimpleSymbol;
    //   783: getstatic 1380	com/ftsafe/CCIDScheme:Lit59	Lgnu/mapping/SimpleSymbol;
    //   786: getstatic 1389	com/ftsafe/CCIDScheme:Lit224	Lgnu/mapping/SimpleSymbol;
    //   789: aload 11
    //   791: invokestatic 348	kawa/lib/lists:assoc	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   794: ldc 98
    //   796: invokestatic 101	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   799: dup
    //   800: astore 18
    //   802: checkcast 98	gnu/lists/Pair
    //   805: invokestatic 106	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   808: invokestatic 348	kawa/lib/lists:assoc	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   811: invokestatic 581	kawa/lib/lists:cadr	(Ljava/lang/Object;)Ljava/lang/Object;
    //   814: invokestatic 213	gnu/lists/LList:list2	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   817: invokestatic 206	gnu/lists/LList:list4	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   820: aastore
    //   821: dup
    //   822: iconst_1
    //   823: getstatic 1392	com/ftsafe/CCIDScheme:Lit225	Lgnu/mapping/SimpleSymbol;
    //   826: aload 11
    //   828: invokestatic 348	kawa/lib/lists:assoc	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   831: invokestatic 287	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   834: ifeq +46 -> 880
    //   837: getstatic 1395	com/ftsafe/CCIDScheme:Lit226	Lgnu/mapping/SimpleSymbol;
    //   840: getstatic 1380	com/ftsafe/CCIDScheme:Lit59	Lgnu/mapping/SimpleSymbol;
    //   843: getstatic 1392	com/ftsafe/CCIDScheme:Lit225	Lgnu/mapping/SimpleSymbol;
    //   846: aload 11
    //   848: invokestatic 348	kawa/lib/lists:assoc	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   851: ldc 98
    //   853: invokestatic 101	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   856: dup
    //   857: astore 18
    //   859: checkcast 98	gnu/lists/Pair
    //   862: invokestatic 106	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   865: invokestatic 348	kawa/lib/lists:assoc	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   868: invokestatic 581	kawa/lib/lists:cadr	(Ljava/lang/Object;)Ljava/lang/Object;
    //   871: invokestatic 213	gnu/lists/LList:list2	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   874: invokestatic 261	gnu/lists/LList:list1	(Ljava/lang/Object;)Lgnu/lists/Pair;
    //   877: goto +6 -> 883
    //   880: getstatic 132	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
    //   883: aastore
    //   884: invokestatic 267	kawa/standard/append:append$V	([Ljava/lang/Object;)Ljava/lang/Object;
    //   887: astore 9
    //   889: new 98	gnu/lists/Pair
    //   892: dup
    //   893: aload 9
    //   895: getstatic 132	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
    //   898: invokespecial 404	gnu/lists/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   901: aload 6
    //   903: ifnonnull +9 -> 912
    //   906: dup
    //   907: astore 5
    //   909: goto +10 -> 919
    //   912: aload 6
    //   914: swap
    //   915: dup_x1
    //   916: invokevirtual 408	gnu/lists/Pair:setCdr	(Ljava/lang/Object;)V
    //   919: astore 6
    //   921: goto -862 -> 59
    //   924: aload 5
    //   926: aload_2
    //   927: swap
    //   928: putfield 1399	com/ftsafe/CCIDScheme$frame13:deviceInf	Lgnu/lists/LList;
    //   931: aload_2
    //   932: getfield 1402	com/ftsafe/CCIDScheme$frame13:lambda$Fn20	Lgnu/expr/ModuleMethod;
    //   935: areturn
    //   936: new 66	gnu/mapping/WrongType
    //   939: dup_x1
    //   940: swap
    //   941: ldc 103
    //   943: iconst_1
    //   944: aload 4
    //   946: invokespecial 71	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   949: athrow
    //   950: new 66	gnu/mapping/WrongType
    //   953: dup_x1
    //   954: swap
    //   955: ldc_w 363
    //   958: iconst_1
    //   959: aload 11
    //   961: invokespecial 71	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   964: athrow
    //   965: new 66	gnu/mapping/WrongType
    //   968: dup_x1
    //   969: swap
    //   970: ldc 103
    //   972: iconst_1
    //   973: aload 12
    //   975: invokespecial 71	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   978: athrow
    //   979: new 66	gnu/mapping/WrongType
    //   982: dup_x1
    //   983: swap
    //   984: ldc 103
    //   986: iconst_1
    //   987: aload 13
    //   989: invokespecial 71	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   992: athrow
    //   993: new 66	gnu/mapping/WrongType
    //   996: dup_x1
    //   997: swap
    //   998: ldc 103
    //   1000: iconst_1
    //   1001: aload 14
    //   1003: invokespecial 71	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1006: athrow
    //   1007: new 66	gnu/mapping/WrongType
    //   1010: dup_x1
    //   1011: swap
    //   1012: ldc 103
    //   1014: iconst_1
    //   1015: aload 15
    //   1017: invokespecial 71	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1020: athrow
    //   1021: new 66	gnu/mapping/WrongType
    //   1024: dup_x1
    //   1025: swap
    //   1026: ldc 103
    //   1028: iconst_1
    //   1029: aload 19
    //   1031: invokespecial 71	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1034: athrow
    //   1035: new 66	gnu/mapping/WrongType
    //   1038: dup_x1
    //   1039: swap
    //   1040: ldc 103
    //   1042: iconst_1
    //   1043: aload 25
    //   1045: invokespecial 71	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1048: athrow
    //   1049: new 66	gnu/mapping/WrongType
    //   1052: dup_x1
    //   1053: swap
    //   1054: ldc 103
    //   1056: iconst_1
    //   1057: aload 20
    //   1059: invokespecial 71	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1062: athrow
    //   1063: new 66	gnu/mapping/WrongType
    //   1066: dup_x1
    //   1067: swap
    //   1068: ldc_w 363
    //   1071: iconst_1
    //   1072: aload 19
    //   1074: invokespecial 71	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1077: athrow
    //   1078: new 66	gnu/mapping/WrongType
    //   1081: dup_x1
    //   1082: swap
    //   1083: ldc 103
    //   1085: iconst_1
    //   1086: aload 19
    //   1088: invokespecial 71	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1091: athrow
    //   1092: new 66	gnu/mapping/WrongType
    //   1095: dup_x1
    //   1096: swap
    //   1097: ldc 103
    //   1099: iconst_1
    //   1100: aload 19
    //   1102: invokespecial 71	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1105: athrow
    //   1106: new 66	gnu/mapping/WrongType
    //   1109: dup_x1
    //   1110: swap
    //   1111: ldc_w 363
    //   1114: iconst_1
    //   1115: aload 19
    //   1117: invokespecial 71	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1120: athrow
    //   1121: new 66	gnu/mapping/WrongType
    //   1124: dup_x1
    //   1125: swap
    //   1126: ldc 103
    //   1128: iconst_1
    //   1129: aload 18
    //   1131: invokespecial 71	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1134: athrow
    //   1135: new 66	gnu/mapping/WrongType
    //   1138: dup_x1
    //   1139: swap
    //   1140: ldc 103
    //   1142: iconst_1
    //   1143: aload 18
    //   1145: invokespecial 71	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1148: athrow
    //   1149: new 66	gnu/mapping/WrongType
    //   1152: dup_x1
    //   1153: swap
    //   1154: ldc 103
    //   1156: iconst_1
    //   1157: aload 18
    //   1159: invokespecial 71	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1162: athrow
    // Line number table:
    //   Java source line #11593	-> byte code offset #0
    //   Java source line #11594	-> byte code offset #8
    //   Java source line #11596	-> byte code offset #39
    //   Java source line #11651	-> byte code offset #39
    //   Java source line #11597	-> byte code offset #78
    //   Java source line #11598	-> byte code offset #115
    //   Java source line #11597	-> byte code offset #137
    //   Java source line #11599	-> byte code offset #137
    //   Java source line #11597	-> byte code offset #170
    //   Java source line #11601	-> byte code offset #170
    //   Java source line #11597	-> byte code offset #202
    //   Java source line #11602	-> byte code offset #202
    //   Java source line #11597	-> byte code offset #234
    //   Java source line #11604	-> byte code offset #234
    //   Java source line #11597	-> byte code offset #242
    //   Java source line #11605	-> byte code offset #242
    //   Java source line #11597	-> byte code offset #250
    //   Java source line #11607	-> byte code offset #250
    //   Java source line #11608	-> byte code offset #263
    //   Java source line #11609	-> byte code offset #286
    //   Java source line #11610	-> byte code offset #286
    //   Java source line #11618	-> byte code offset #286
    //   Java source line #11611	-> byte code offset #324
    //   Java source line #11612	-> byte code offset #342
    //   Java source line #11620	-> byte code offset #392
    //   Java source line #11623	-> byte code offset #420
    //   Java source line #11624	-> byte code offset #431
    //   Java source line #11625	-> byte code offset #440
    //   Java source line #11626	-> byte code offset #468
    //   Java source line #11625	-> byte code offset #488
    //   Java source line #11627	-> byte code offset #501
    //   Java source line #11628	-> byte code offset #510
    //   Java source line #11629	-> byte code offset #543
    //   Java source line #11631	-> byte code offset #554
    //   Java source line #11633	-> byte code offset #570
    //   Java source line #11635	-> byte code offset #609
    //   Java source line #11637	-> byte code offset #615
    //   Java source line #11638	-> byte code offset #616
    //   Java source line #11639	-> byte code offset #619
    //   Java source line #11641	-> byte code offset #658
    //   Java source line #11642	-> byte code offset #661
    //   Java source line #11640	-> byte code offset #694
    //   Java source line #11644	-> byte code offset #700
    //   Java source line #11645	-> byte code offset #746
    //   Java source line #11646	-> byte code offset #783
    //   Java source line #11647	-> byte code offset #826
    //   Java source line #11648	-> byte code offset #837
    //   Java source line #11656	-> byte code offset #931
    //   Java source line #11594	-> byte code offset #936
    //   Java source line #11597	-> byte code offset #950
    //   Java source line #11598	-> byte code offset #965
    //   Java source line #11599	-> byte code offset #979
    //   Java source line #11601	-> byte code offset #993
    //   Java source line #11602	-> byte code offset #1007
    //   Java source line #11608	-> byte code offset #1021
    //   Java source line #11611	-> byte code offset #1035
    //   Java source line #11628	-> byte code offset #1049
    //   Java source line #11633	-> byte code offset #1063
    //   Java source line #11639	-> byte code offset #1078
    //   Java source line #11642	-> byte code offset #1092
    //   Java source line #11644	-> byte code offset #1106
    //   Java source line #11645	-> byte code offset #1121
    //   Java source line #11646	-> byte code offset #1135
    //   Java source line #11648	-> byte code offset #1149
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	935	0	usb_control_in	Object
    //   0	935	1	descriptor$Mninfo	Object
    //   8	927	2	$heapFrame	frame13
    //   39	896	3	bNumInterfaces	Object
    //   115	772	10	x	gnu.mapping.SimpleSymbol
    //   137	750	11	interfaceI	Object
    //   170	717	12	iInterface	Object
    //   202	685	13	iManufacture	Object
    //   234	653	14	iProduct	Object
    //   242	645	15	manufactureStr	CharSequence
    //   250	637	16	productStr	CharSequence
    //   392	495	17	iads_iFunction	Object
    //   286	98	18	iads	Object
    //   455	281	18	x	boolean
    //   488	55	19	x	boolean
    //   342	8	24	iads	Object
    // Exception table:
    //   from	to	target	type
    //   26	29	936	java/lang/ClassCastException
    //   100	103	950	java/lang/ClassCastException
    //   129	132	965	java/lang/ClassCastException
    //   156	159	979	java/lang/ClassCastException
    //   188	191	993	java/lang/ClassCastException
    //   220	223	1007	java/lang/ClassCastException
    //   278	281	1021	java/lang/ClassCastException
    //   334	337	1035	java/lang/ClassCastException
    //   525	528	1049	java/lang/ClassCastException
    //   592	595	1063	java/lang/ClassCastException
    //   634	637	1078	java/lang/ClassCastException
    //   676	679	1092	java/lang/ClassCastException
    //   722	725	1106	java/lang/ClassCastException
    //   765	768	1121	java/lang/ClassCastException
    //   802	805	1135	java/lang/ClassCastException
    //   859	862	1149	java/lang/ClassCastException
  }
  
  /* Error */
  public static Object doPPS(Object usb_send_recv, Object slot, Object atr)
  {
    // Byte code:
    //   0: getstatic 572	com/ftsafe/CCIDScheme:Lit98	Lgnu/mapping/SimpleSymbol;
    //   3: getstatic 535	com/ftsafe/CCIDScheme:current_dev_interface	Lgnu/mapping/Procedure;
    //   6: invokevirtual 575	gnu/mapping/Procedure:apply0	()Ljava/lang/Object;
    //   9: getstatic 497	com/ftsafe/CCIDScheme:descriptor$Mninfo	Ljava/lang/Object;
    //   12: invokestatic 348	kawa/lib/lists:assoc	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   15: ldc 98
    //   17: invokestatic 101	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   20: dup
    //   21: astore 4
    //   23: checkcast 98	gnu/lists/Pair
    //   26: invokestatic 106	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   29: invokestatic 348	kawa/lib/lists:assoc	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   32: ldc 98
    //   34: invokestatic 101	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   37: dup
    //   38: astore 4
    //   40: checkcast 98	gnu/lists/Pair
    //   43: invokestatic 106	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   46: astore_3
    //   47: getstatic 578	com/ftsafe/CCIDScheme:Lit83	Lgnu/mapping/SimpleSymbol;
    //   50: aload_3
    //   51: invokestatic 348	kawa/lib/lists:assoc	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   54: invokestatic 581	kawa/lib/lists:cadr	(Ljava/lang/Object;)Ljava/lang/Object;
    //   57: astore 4
    //   59: getstatic 276	kawa/standard/Scheme:isEqual	Lgnu/kawa/functions/IsEqual;
    //   62: getstatic 190	gnu/kawa/functions/BitwiseOp:and	Lgnu/kawa/functions/BitwiseOp;
    //   65: aload 4
    //   67: getstatic 193	com/ftsafe/CCIDScheme:Lit9	Lgnu/math/IntNum;
    //   70: invokevirtual 28	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   73: getstatic 1434	com/ftsafe/CCIDScheme:Lit229	Lgnu/math/IntNum;
    //   76: invokevirtual 28	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   79: invokestatic 287	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   82: ifeq +45 -> 127
    //   85: getstatic 317	com/ftsafe/CCIDScheme:pp	Lgnu/mapping/Procedure;
    //   88: ldc_w 1436
    //   91: invokevirtual 780	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   94: pop
    //   95: getstatic 317	com/ftsafe/CCIDScheme:pp	Lgnu/mapping/Procedure;
    //   98: aload_0
    //   99: aload_1
    //   100: aload_2
    //   101: invokestatic 1439	com/ftsafe/CCIDScheme:doPPSExchange	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   104: invokevirtual 780	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   107: pop
    //   108: getstatic 317	com/ftsafe/CCIDScheme:pp	Lgnu/mapping/Procedure;
    //   111: ldc_w 1441
    //   114: invokevirtual 780	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   117: pop
    //   118: aload_0
    //   119: aload_1
    //   120: aload_2
    //   121: invokestatic 1444	com/ftsafe/CCIDScheme:doPPSSetParameters	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   124: goto +311 -> 435
    //   127: getstatic 276	kawa/standard/Scheme:isEqual	Lgnu/kawa/functions/IsEqual;
    //   130: getstatic 190	gnu/kawa/functions/BitwiseOp:and	Lgnu/kawa/functions/BitwiseOp;
    //   133: aload 4
    //   135: getstatic 193	com/ftsafe/CCIDScheme:Lit9	Lgnu/math/IntNum;
    //   138: invokevirtual 28	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   141: getstatic 1447	com/ftsafe/CCIDScheme:Lit230	Lgnu/math/IntNum;
    //   144: invokevirtual 28	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   147: invokestatic 287	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   150: ifeq +32 -> 182
    //   153: getstatic 317	com/ftsafe/CCIDScheme:pp	Lgnu/mapping/Procedure;
    //   156: ldc_w 1449
    //   159: invokevirtual 780	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   162: pop
    //   163: getstatic 317	com/ftsafe/CCIDScheme:pp	Lgnu/mapping/Procedure;
    //   166: ldc_w 1441
    //   169: invokevirtual 780	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   172: pop
    //   173: aload_0
    //   174: aload_1
    //   175: aload_2
    //   176: invokestatic 1444	com/ftsafe/CCIDScheme:doPPSSetParameters	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   179: goto +256 -> 435
    //   182: getstatic 276	kawa/standard/Scheme:isEqual	Lgnu/kawa/functions/IsEqual;
    //   185: getstatic 190	gnu/kawa/functions/BitwiseOp:and	Lgnu/kawa/functions/BitwiseOp;
    //   188: aload 4
    //   190: getstatic 193	com/ftsafe/CCIDScheme:Lit9	Lgnu/math/IntNum;
    //   193: invokevirtual 28	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   196: getstatic 1447	com/ftsafe/CCIDScheme:Lit230	Lgnu/math/IntNum;
    //   199: invokevirtual 28	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   202: invokestatic 287	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   205: ifeq +25 -> 230
    //   208: getstatic 317	com/ftsafe/CCIDScheme:pp	Lgnu/mapping/Procedure;
    //   211: ldc_w 1449
    //   214: invokevirtual 780	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   217: pop
    //   218: getstatic 317	com/ftsafe/CCIDScheme:pp	Lgnu/mapping/Procedure;
    //   221: ldc_w 1451
    //   224: invokevirtual 780	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   227: goto +208 -> 435
    //   230: getstatic 190	gnu/kawa/functions/BitwiseOp:and	Lgnu/kawa/functions/BitwiseOp;
    //   233: aload 4
    //   235: getstatic 1221	com/ftsafe/CCIDScheme:Lit188	Lgnu/math/IntNum;
    //   238: invokevirtual 28	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   241: getstatic 1221	com/ftsafe/CCIDScheme:Lit188	Lgnu/math/IntNum;
    //   244: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   247: ifeq +15 -> 262
    //   250: getstatic 317	com/ftsafe/CCIDScheme:pp	Lgnu/mapping/Procedure;
    //   253: ldc_w 1453
    //   256: invokevirtual 780	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   259: goto +176 -> 435
    //   262: getstatic 190	gnu/kawa/functions/BitwiseOp:and	Lgnu/kawa/functions/BitwiseOp;
    //   265: aload 4
    //   267: getstatic 469	com/ftsafe/CCIDScheme:Lit20	Lgnu/math/IntNum;
    //   270: invokevirtual 28	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   273: getstatic 469	com/ftsafe/CCIDScheme:Lit20	Lgnu/math/IntNum;
    //   276: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   279: istore 5
    //   281: iload 5
    //   283: ifeq +11 -> 294
    //   286: iload 5
    //   288: ifeq +44 -> 332
    //   291: goto +28 -> 319
    //   294: getstatic 953	com/ftsafe/CCIDScheme:Lit141	Lgnu/mapping/SimpleSymbol;
    //   297: getstatic 995	com/ftsafe/CCIDScheme:Lit168	Lgnu/mapping/SimpleSymbol;
    //   300: getstatic 901	com/ftsafe/CCIDScheme:Lit158	Lgnu/mapping/SimpleSymbol;
    //   303: aload_2
    //   304: invokestatic 922	com/ftsafe/CCIDScheme:assocEX	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   307: invokestatic 922	com/ftsafe/CCIDScheme:assocEX	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   310: invokestatic 922	com/ftsafe/CCIDScheme:assocEX	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   313: invokestatic 287	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   316: ifeq +16 -> 332
    //   319: getstatic 317	com/ftsafe/CCIDScheme:pp	Lgnu/mapping/Procedure;
    //   322: ldc_w 1449
    //   325: invokevirtual 780	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   328: pop
    //   329: goto +58 -> 387
    //   332: getstatic 276	kawa/standard/Scheme:isEqual	Lgnu/kawa/functions/IsEqual;
    //   335: getstatic 916	com/ftsafe/CCIDScheme:Lit160	Lgnu/mapping/SimpleSymbol;
    //   338: aload_2
    //   339: invokestatic 1025	com/ftsafe/CCIDScheme:getAtrSupportProtocol	(Ljava/lang/Object;)Ljava/lang/Object;
    //   342: invokevirtual 28	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   345: invokestatic 287	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   348: ifeq +16 -> 364
    //   351: getstatic 317	com/ftsafe/CCIDScheme:pp	Lgnu/mapping/Procedure;
    //   354: ldc_w 1455
    //   357: invokevirtual 780	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   360: pop
    //   361: goto +26 -> 387
    //   364: getstatic 317	com/ftsafe/CCIDScheme:pp	Lgnu/mapping/Procedure;
    //   367: ldc_w 1436
    //   370: invokevirtual 780	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   373: pop
    //   374: getstatic 317	com/ftsafe/CCIDScheme:pp	Lgnu/mapping/Procedure;
    //   377: aload_0
    //   378: aload_1
    //   379: aload_2
    //   380: invokestatic 1439	com/ftsafe/CCIDScheme:doPPSExchange	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   383: invokevirtual 780	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   386: pop
    //   387: getstatic 190	gnu/kawa/functions/BitwiseOp:and	Lgnu/kawa/functions/BitwiseOp;
    //   390: aload 4
    //   392: getstatic 357	com/ftsafe/CCIDScheme:Lit16	Lgnu/math/IntNum;
    //   395: invokevirtual 28	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   398: getstatic 357	com/ftsafe/CCIDScheme:Lit16	Lgnu/math/IntNum;
    //   401: invokestatic 618	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   404: ifeq +15 -> 419
    //   407: getstatic 317	com/ftsafe/CCIDScheme:pp	Lgnu/mapping/Procedure;
    //   410: ldc_w 1451
    //   413: invokevirtual 780	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   416: goto +19 -> 435
    //   419: getstatic 317	com/ftsafe/CCIDScheme:pp	Lgnu/mapping/Procedure;
    //   422: ldc_w 1441
    //   425: invokevirtual 780	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   428: pop
    //   429: aload_0
    //   430: aload_1
    //   431: aload_2
    //   432: invokestatic 1444	com/ftsafe/CCIDScheme:doPPSSetParameters	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   435: areturn
    //   436: new 66	gnu/mapping/WrongType
    //   439: dup_x1
    //   440: swap
    //   441: ldc 103
    //   443: iconst_1
    //   444: aload 4
    //   446: invokespecial 71	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   449: athrow
    //   450: new 66	gnu/mapping/WrongType
    //   453: dup_x1
    //   454: swap
    //   455: ldc 103
    //   457: iconst_1
    //   458: aload 4
    //   460: invokespecial 71	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   463: athrow
    // Line number table:
    //   Java source line #11704	-> byte code offset #0
    //   Java source line #11705	-> byte code offset #0
    //   Java source line #11706	-> byte code offset #47
    //   Java source line #11707	-> byte code offset #59
    //   Java source line #11708	-> byte code offset #85
    //   Java source line #11709	-> byte code offset #95
    //   Java source line #11710	-> byte code offset #108
    //   Java source line #11711	-> byte code offset #118
    //   Java source line #11713	-> byte code offset #130
    //   Java source line #11714	-> byte code offset #153
    //   Java source line #11715	-> byte code offset #163
    //   Java source line #11716	-> byte code offset #173
    //   Java source line #11718	-> byte code offset #185
    //   Java source line #11719	-> byte code offset #208
    //   Java source line #11720	-> byte code offset #218
    //   Java source line #11723	-> byte code offset #230
    //   Java source line #11724	-> byte code offset #250
    //   Java source line #11726	-> byte code offset #262
    //   Java source line #11727	-> byte code offset #294
    //   Java source line #11728	-> byte code offset #319
    //   Java source line #11730	-> byte code offset #332
    //   Java source line #11732	-> byte code offset #351
    //   Java source line #11734	-> byte code offset #364
    //   Java source line #11735	-> byte code offset #374
    //   Java source line #11736	-> byte code offset #387
    //   Java source line #11737	-> byte code offset #407
    //   Java source line #11739	-> byte code offset #419
    //   Java source line #11740	-> byte code offset #429
    //   Java source line #11705	-> byte code offset #436
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	435	0	usb_send_recv	Object
    //   0	435	1	slot	Object
    //   0	435	2	atr	Object
    //   46	5	3	ccid_desc	Object
    //   21	18	4	localObject1	Object
    //   57	402	4	dwFeatures	Object
    //   279	8	5	x	boolean
    //   436	1	7	localClassCastException1	ClassCastException
    //   450	1	8	localClassCastException2	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   23	26	436	java/lang/ClassCastException
    //   40	43	450	java/lang/ClassCastException
  }
  
  /* Error */
  public static gnu.mapping.SimpleSymbol getCcidExchangeLevel(Object desc)
  {
    // Byte code:
    //   0: getstatic 572	com/ftsafe/CCIDScheme:Lit98	Lgnu/mapping/SimpleSymbol;
    //   3: getstatic 535	com/ftsafe/CCIDScheme:current_dev_interface	Lgnu/mapping/Procedure;
    //   6: invokevirtual 575	gnu/mapping/Procedure:apply0	()Ljava/lang/Object;
    //   9: aload_0
    //   10: invokestatic 348	kawa/lib/lists:assoc	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   13: ldc 98
    //   15: invokestatic 101	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   18: dup
    //   19: astore_2
    //   20: checkcast 98	gnu/lists/Pair
    //   23: invokestatic 106	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   26: invokestatic 348	kawa/lib/lists:assoc	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   29: ldc 98
    //   31: invokestatic 101	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   34: dup
    //   35: astore_2
    //   36: checkcast 98	gnu/lists/Pair
    //   39: invokestatic 106	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   42: astore_1
    //   43: getstatic 578	com/ftsafe/CCIDScheme:Lit83	Lgnu/mapping/SimpleSymbol;
    //   46: aload_1
    //   47: invokestatic 348	kawa/lib/lists:assoc	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   50: invokestatic 581	kawa/lib/lists:cadr	(Ljava/lang/Object;)Ljava/lang/Object;
    //   53: astore_2
    //   54: getstatic 276	kawa/standard/Scheme:isEqual	Lgnu/kawa/functions/IsEqual;
    //   57: getstatic 190	gnu/kawa/functions/BitwiseOp:and	Lgnu/kawa/functions/BitwiseOp;
    //   60: aload_2
    //   61: getstatic 1458	com/ftsafe/CCIDScheme:Lit231	Lgnu/math/IntNum;
    //   64: invokevirtual 28	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   67: getstatic 1461	com/ftsafe/CCIDScheme:Lit232	Lgnu/math/IntNum;
    //   70: invokevirtual 28	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   73: invokestatic 287	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   76: ifeq +19 -> 95
    //   79: getstatic 317	com/ftsafe/CCIDScheme:pp	Lgnu/mapping/Procedure;
    //   82: ldc_w 1463
    //   85: invokevirtual 780	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   88: pop
    //   89: getstatic 1466	com/ftsafe/CCIDScheme:Lit233	Lgnu/mapping/SimpleSymbol;
    //   92: goto +98 -> 190
    //   95: getstatic 276	kawa/standard/Scheme:isEqual	Lgnu/kawa/functions/IsEqual;
    //   98: getstatic 190	gnu/kawa/functions/BitwiseOp:and	Lgnu/kawa/functions/BitwiseOp;
    //   101: aload_2
    //   102: getstatic 1458	com/ftsafe/CCIDScheme:Lit231	Lgnu/math/IntNum;
    //   105: invokevirtual 28	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   108: getstatic 1469	com/ftsafe/CCIDScheme:Lit234	Lgnu/math/IntNum;
    //   111: invokevirtual 28	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   114: invokestatic 287	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   117: ifeq +19 -> 136
    //   120: getstatic 317	com/ftsafe/CCIDScheme:pp	Lgnu/mapping/Procedure;
    //   123: ldc_w 1471
    //   126: invokevirtual 780	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   129: pop
    //   130: getstatic 1474	com/ftsafe/CCIDScheme:Lit235	Lgnu/mapping/SimpleSymbol;
    //   133: goto +57 -> 190
    //   136: getstatic 276	kawa/standard/Scheme:isEqual	Lgnu/kawa/functions/IsEqual;
    //   139: getstatic 190	gnu/kawa/functions/BitwiseOp:and	Lgnu/kawa/functions/BitwiseOp;
    //   142: aload_2
    //   143: getstatic 1458	com/ftsafe/CCIDScheme:Lit231	Lgnu/math/IntNum;
    //   146: invokevirtual 28	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   149: getstatic 1477	com/ftsafe/CCIDScheme:Lit236	Lgnu/math/IntNum;
    //   152: invokevirtual 28	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   155: invokestatic 287	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   158: ifeq +19 -> 177
    //   161: getstatic 317	com/ftsafe/CCIDScheme:pp	Lgnu/mapping/Procedure;
    //   164: ldc_w 1479
    //   167: invokevirtual 780	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   170: pop
    //   171: getstatic 1482	com/ftsafe/CCIDScheme:Lit237	Lgnu/mapping/SimpleSymbol;
    //   174: goto +16 -> 190
    //   177: getstatic 317	com/ftsafe/CCIDScheme:pp	Lgnu/mapping/Procedure;
    //   180: ldc_w 1484
    //   183: invokevirtual 780	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   186: pop
    //   187: getstatic 1487	com/ftsafe/CCIDScheme:Lit238	Lgnu/mapping/SimpleSymbol;
    //   190: areturn
    //   191: new 66	gnu/mapping/WrongType
    //   194: dup_x1
    //   195: swap
    //   196: ldc 103
    //   198: iconst_1
    //   199: aload_2
    //   200: invokespecial 71	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   203: athrow
    //   204: new 66	gnu/mapping/WrongType
    //   207: dup_x1
    //   208: swap
    //   209: ldc 103
    //   211: iconst_1
    //   212: aload_2
    //   213: invokespecial 71	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   216: athrow
    // Line number table:
    //   Java source line #11744	-> byte code offset #0
    //   Java source line #11745	-> byte code offset #0
    //   Java source line #11746	-> byte code offset #43
    //   Java source line #11747	-> byte code offset #54
    //   Java source line #11748	-> byte code offset #79
    //   Java source line #11750	-> byte code offset #98
    //   Java source line #11751	-> byte code offset #120
    //   Java source line #11753	-> byte code offset #139
    //   Java source line #11754	-> byte code offset #161
    //   Java source line #11756	-> byte code offset #177
    //   Java source line #11757	-> byte code offset #177
    //   Java source line #11745	-> byte code offset #191
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	190	0	desc	Object
    //   42	5	1	ccid_desc	Object
    //   19	17	2	localObject1	Object
    //   53	160	2	dwFeatures	Object
    //   191	1	4	localClassCastException1	ClassCastException
    //   204	1	5	localClassCastException2	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   20	23	191	java/lang/ClassCastException
    //   36	39	204	java/lang/ClassCastException
  }
  
  /* Error */
  public static Object doXfrBlockAPDUExtendedProtocol(Object usb_send, Object usb_recv, Object slot, Object data)
  {
    // Byte code:
    //   0: getstatic 1494	com/ftsafe/CCIDScheme:Lit84	Lgnu/mapping/SimpleSymbol;
    //   3: getstatic 572	com/ftsafe/CCIDScheme:Lit98	Lgnu/mapping/SimpleSymbol;
    //   6: getstatic 535	com/ftsafe/CCIDScheme:current_dev_interface	Lgnu/mapping/Procedure;
    //   9: invokevirtual 575	gnu/mapping/Procedure:apply0	()Ljava/lang/Object;
    //   12: getstatic 497	com/ftsafe/CCIDScheme:descriptor$Mninfo	Ljava/lang/Object;
    //   15: invokestatic 348	kawa/lib/lists:assoc	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   18: ldc 98
    //   20: invokestatic 101	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   23: dup
    //   24: astore 5
    //   26: checkcast 98	gnu/lists/Pair
    //   29: invokestatic 106	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   32: invokestatic 348	kawa/lib/lists:assoc	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   35: ldc 98
    //   37: invokestatic 101	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   40: dup
    //   41: astore 5
    //   43: checkcast 98	gnu/lists/Pair
    //   46: invokestatic 106	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   49: invokestatic 348	kawa/lib/lists:assoc	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   52: invokestatic 581	kawa/lib/lists:cadr	(Ljava/lang/Object;)Ljava/lang/Object;
    //   55: astore 4
    //   57: aload_3
    //   58: invokestatic 323	gnu/lists/Sequences:getSize	(Ljava/lang/Object;)I
    //   61: invokestatic 329	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   64: iconst_m1
    //   65: aload 4
    //   67: getstatic 695	com/ftsafe/CCIDScheme:Lit114	Lgnu/math/IntNum;
    //   70: invokestatic 114	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   73: invokestatic 730	gnu/kawa/functions/NumberCompare:$Ls$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   76: ifeq +35 -> 111
    //   79: getstatic 336	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   82: aload_0
    //   83: aload_2
    //   84: getstatic 52	com/ftsafe/CCIDScheme:Lit1	Lgnu/math/IntNum;
    //   87: getstatic 52	com/ftsafe/CCIDScheme:Lit1	Lgnu/math/IntNum;
    //   90: aload_3
    //   91: invokestatic 1406	com/ftsafe/CCIDScheme:PC_to_RDR_XfrBlock	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   94: invokevirtual 28	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   97: pop
    //   98: getstatic 336	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   101: aload_1
    //   102: invokevirtual 780	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   105: invokestatic 1409	com/ftsafe/CCIDScheme:RDR_to_PC_DataBlock	(Ljava/lang/Object;)Lgnu/lists/Pair;
    //   108: goto +363 -> 471
    //   111: aload_3
    //   112: iconst_m1
    //   113: aload 4
    //   115: getstatic 695	com/ftsafe/CCIDScheme:Lit114	Lgnu/math/IntNum;
    //   118: invokestatic 114	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   121: invokestatic 332	com/ftsafe/CCIDScheme:groupList	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   124: astore 6
    //   126: iconst_3
    //   127: anewarray 76	java/lang/Object
    //   130: dup
    //   131: iconst_0
    //   132: getstatic 109	com/ftsafe/CCIDScheme:Lit2	Lgnu/math/IntNum;
    //   135: aload 6
    //   137: ldc 98
    //   139: invokestatic 101	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   142: dup
    //   143: astore 8
    //   145: checkcast 98	gnu/lists/Pair
    //   148: invokestatic 118	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   151: invokestatic 213	gnu/lists/LList:list2	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   154: invokestatic 261	gnu/lists/LList:list1	(Ljava/lang/Object;)Lgnu/lists/Pair;
    //   157: aastore
    //   158: dup
    //   159: iconst_1
    //   160: aload 6
    //   162: astore 9
    //   164: aload 9
    //   166: getstatic 109	com/ftsafe/CCIDScheme:Lit2	Lgnu/math/IntNum;
    //   169: aload 9
    //   171: invokestatic 323	gnu/lists/Sequences:getSize	(Ljava/lang/Object;)I
    //   174: iconst_2
    //   175: isub
    //   176: invokestatic 329	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   179: invokestatic 122	com/ftsafe/CCIDScheme:slice	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   182: invokestatic 385	gnu/lists/Sequences:getIterator	(Ljava/lang/Object;)Ljava/util/Iterator;
    //   185: astore 8
    //   187: getstatic 132	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
    //   190: astore 9
    //   192: aconst_null
    //   193: astore 10
    //   195: aload 8
    //   197: invokeinterface 391 1 0
    //   202: ifeq +53 -> 255
    //   205: aload 8
    //   207: invokeinterface 395 1 0
    //   212: astore 11
    //   214: new 98	gnu/lists/Pair
    //   217: dup
    //   218: getstatic 587	com/ftsafe/CCIDScheme:Lit99	Lgnu/math/IntNum;
    //   221: aload 11
    //   223: invokestatic 213	gnu/lists/LList:list2	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   226: getstatic 132	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
    //   229: invokespecial 404	gnu/lists/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   232: aload 10
    //   234: ifnonnull +9 -> 243
    //   237: dup
    //   238: astore 9
    //   240: goto +10 -> 250
    //   243: aload 10
    //   245: swap
    //   246: dup_x1
    //   247: invokevirtual 408	gnu/lists/Pair:setCdr	(Ljava/lang/Object;)V
    //   250: astore 10
    //   252: goto -57 -> 195
    //   255: aload 9
    //   257: aastore
    //   258: dup
    //   259: iconst_2
    //   260: getstatic 357	com/ftsafe/CCIDScheme:Lit16	Lgnu/math/IntNum;
    //   263: aload 6
    //   265: astore 8
    //   267: aload 8
    //   269: aload 8
    //   271: invokestatic 323	gnu/lists/Sequences:getSize	(Ljava/lang/Object;)I
    //   274: iconst_1
    //   275: isub
    //   276: invokestatic 159	kawa/lib/lists:listRef	(Ljava/lang/Object;I)Ljava/lang/Object;
    //   279: invokestatic 213	gnu/lists/LList:list2	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   282: invokestatic 261	gnu/lists/LList:list1	(Ljava/lang/Object;)Lgnu/lists/Pair;
    //   285: aastore
    //   286: invokestatic 267	kawa/standard/append:append$V	([Ljava/lang/Object;)Ljava/lang/Object;
    //   289: astore 7
    //   291: aload 7
    //   293: astore 8
    //   295: aload 8
    //   297: invokestatic 90	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
    //   300: ifeq +13 -> 313
    //   303: getstatic 317	com/ftsafe/CCIDScheme:pp	Lgnu/mapping/Procedure;
    //   306: ldc_w 1496
    //   309: invokevirtual 780	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   312: pop
    //   313: getstatic 336	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   316: aload_0
    //   317: aload_2
    //   318: getstatic 52	com/ftsafe/CCIDScheme:Lit1	Lgnu/math/IntNum;
    //   321: aload 8
    //   323: ldc 98
    //   325: invokestatic 101	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   328: dup
    //   329: astore 9
    //   331: checkcast 98	gnu/lists/Pair
    //   334: invokestatic 118	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   337: ldc 98
    //   339: invokestatic 101	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   342: dup
    //   343: astore 9
    //   345: checkcast 98	gnu/lists/Pair
    //   348: invokestatic 118	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   351: aload 8
    //   353: ldc 98
    //   355: invokestatic 101	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   358: dup
    //   359: astore 9
    //   361: checkcast 98	gnu/lists/Pair
    //   364: invokestatic 118	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   367: invokestatic 581	kawa/lib/lists:cadr	(Ljava/lang/Object;)Ljava/lang/Object;
    //   370: invokestatic 1406	com/ftsafe/CCIDScheme:PC_to_RDR_XfrBlock	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   373: invokevirtual 28	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   376: pop
    //   377: getstatic 336	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   380: aload_1
    //   381: invokevirtual 780	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   384: invokestatic 1409	com/ftsafe/CCIDScheme:RDR_to_PC_DataBlock	(Ljava/lang/Object;)Lgnu/lists/Pair;
    //   387: astore 9
    //   389: getstatic 276	kawa/standard/Scheme:isEqual	Lgnu/kawa/functions/IsEqual;
    //   392: getstatic 190	gnu/kawa/functions/BitwiseOp:and	Lgnu/kawa/functions/BitwiseOp;
    //   395: getstatic 792	com/ftsafe/CCIDScheme:Lit127	Lgnu/mapping/SimpleSymbol;
    //   398: aload 9
    //   400: invokestatic 348	kawa/lib/lists:assoc	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   403: invokestatic 581	kawa/lib/lists:cadr	(Ljava/lang/Object;)Ljava/lang/Object;
    //   406: getstatic 469	com/ftsafe/CCIDScheme:Lit20	Lgnu/math/IntNum;
    //   409: invokevirtual 28	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   412: getstatic 469	com/ftsafe/CCIDScheme:Lit20	Lgnu/math/IntNum;
    //   415: invokevirtual 28	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   418: invokestatic 287	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   421: ifeq +6 -> 427
    //   424: goto -47 -> 377
    //   427: getstatic 276	kawa/standard/Scheme:isEqual	Lgnu/kawa/functions/IsEqual;
    //   430: getstatic 795	com/ftsafe/CCIDScheme:Lit128	Lgnu/mapping/SimpleSymbol;
    //   433: aload 9
    //   435: invokestatic 348	kawa/lib/lists:assoc	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   438: getstatic 1499	com/ftsafe/CCIDScheme:Lit239	Lgnu/lists/PairWithPosition;
    //   441: invokevirtual 28	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   444: invokestatic 287	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   447: ifeq +22 -> 469
    //   450: aload 8
    //   452: ldc 98
    //   454: invokestatic 101	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   457: dup
    //   458: astore 10
    //   460: checkcast 98	gnu/lists/Pair
    //   463: invokestatic 106	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   466: goto -173 -> 293
    //   469: aload 9
    //   471: astore 5
    //   473: getstatic 132	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
    //   476: astore 6
    //   478: getstatic 276	kawa/standard/Scheme:isEqual	Lgnu/kawa/functions/IsEqual;
    //   481: getstatic 190	gnu/kawa/functions/BitwiseOp:and	Lgnu/kawa/functions/BitwiseOp;
    //   484: getstatic 792	com/ftsafe/CCIDScheme:Lit127	Lgnu/mapping/SimpleSymbol;
    //   487: aload 5
    //   489: invokestatic 348	kawa/lib/lists:assoc	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   492: invokestatic 581	kawa/lib/lists:cadr	(Ljava/lang/Object;)Ljava/lang/Object;
    //   495: getstatic 469	com/ftsafe/CCIDScheme:Lit20	Lgnu/math/IntNum;
    //   498: invokevirtual 28	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   501: getstatic 469	com/ftsafe/CCIDScheme:Lit20	Lgnu/math/IntNum;
    //   504: invokevirtual 28	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   507: invokestatic 287	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   510: ifeq +18 -> 528
    //   513: getstatic 336	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   516: aload_1
    //   517: invokevirtual 780	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   520: invokestatic 1409	com/ftsafe/CCIDScheme:RDR_to_PC_DataBlock	(Ljava/lang/Object;)Lgnu/lists/Pair;
    //   523: astore 5
    //   525: goto -47 -> 478
    //   528: getstatic 276	kawa/standard/Scheme:isEqual	Lgnu/kawa/functions/IsEqual;
    //   531: getstatic 795	com/ftsafe/CCIDScheme:Lit128	Lgnu/mapping/SimpleSymbol;
    //   534: aload 5
    //   536: invokestatic 348	kawa/lib/lists:assoc	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   539: getstatic 1502	com/ftsafe/CCIDScheme:Lit240	Lgnu/lists/PairWithPosition;
    //   542: invokevirtual 28	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   545: invokestatic 287	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   548: ifeq +19 -> 567
    //   551: getstatic 802	com/ftsafe/CCIDScheme:Lit129	Lgnu/mapping/SimpleSymbol;
    //   554: aload 5
    //   556: invokestatic 348	kawa/lib/lists:assoc	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   559: invokestatic 581	kawa/lib/lists:cadr	(Ljava/lang/Object;)Ljava/lang/Object;
    //   562: astore 6
    //   564: goto +216 -> 780
    //   567: getstatic 276	kawa/standard/Scheme:isEqual	Lgnu/kawa/functions/IsEqual;
    //   570: getstatic 795	com/ftsafe/CCIDScheme:Lit128	Lgnu/mapping/SimpleSymbol;
    //   573: aload 5
    //   575: invokestatic 348	kawa/lib/lists:assoc	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   578: getstatic 1505	com/ftsafe/CCIDScheme:Lit241	Lgnu/lists/PairWithPosition;
    //   581: invokevirtual 28	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   584: invokestatic 287	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   587: ifeq +52 -> 639
    //   590: getstatic 802	com/ftsafe/CCIDScheme:Lit129	Lgnu/mapping/SimpleSymbol;
    //   593: aload 5
    //   595: invokestatic 348	kawa/lib/lists:assoc	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   598: invokestatic 581	kawa/lib/lists:cadr	(Ljava/lang/Object;)Ljava/lang/Object;
    //   601: astore 6
    //   603: getstatic 336	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   606: aload_0
    //   607: aload_2
    //   608: getstatic 52	com/ftsafe/CCIDScheme:Lit1	Lgnu/math/IntNum;
    //   611: getstatic 165	com/ftsafe/CCIDScheme:Lit6	Lgnu/math/IntNum;
    //   614: getstatic 132	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
    //   617: invokestatic 1406	com/ftsafe/CCIDScheme:PC_to_RDR_XfrBlock	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   620: invokevirtual 28	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   623: pop
    //   624: getstatic 336	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   627: aload_1
    //   628: invokevirtual 780	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   631: invokestatic 1409	com/ftsafe/CCIDScheme:RDR_to_PC_DataBlock	(Ljava/lang/Object;)Lgnu/lists/Pair;
    //   634: astore 5
    //   636: goto -158 -> 478
    //   639: getstatic 276	kawa/standard/Scheme:isEqual	Lgnu/kawa/functions/IsEqual;
    //   642: getstatic 795	com/ftsafe/CCIDScheme:Lit128	Lgnu/mapping/SimpleSymbol;
    //   645: aload 5
    //   647: invokestatic 348	kawa/lib/lists:assoc	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   650: getstatic 1508	com/ftsafe/CCIDScheme:Lit242	Lgnu/lists/PairWithPosition;
    //   653: invokevirtual 28	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   656: invokestatic 287	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   659: ifeq +34 -> 693
    //   662: iconst_2
    //   663: anewarray 76	java/lang/Object
    //   666: dup
    //   667: iconst_0
    //   668: aload 6
    //   670: aastore
    //   671: dup
    //   672: iconst_1
    //   673: getstatic 802	com/ftsafe/CCIDScheme:Lit129	Lgnu/mapping/SimpleSymbol;
    //   676: aload 5
    //   678: invokestatic 348	kawa/lib/lists:assoc	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   681: invokestatic 581	kawa/lib/lists:cadr	(Ljava/lang/Object;)Ljava/lang/Object;
    //   684: aastore
    //   685: invokestatic 267	kawa/standard/append:append$V	([Ljava/lang/Object;)Ljava/lang/Object;
    //   688: astore 6
    //   690: goto +90 -> 780
    //   693: getstatic 276	kawa/standard/Scheme:isEqual	Lgnu/kawa/functions/IsEqual;
    //   696: getstatic 795	com/ftsafe/CCIDScheme:Lit128	Lgnu/mapping/SimpleSymbol;
    //   699: aload 5
    //   701: invokestatic 348	kawa/lib/lists:assoc	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   704: getstatic 1511	com/ftsafe/CCIDScheme:Lit243	Lgnu/lists/PairWithPosition;
    //   707: invokevirtual 28	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   710: invokestatic 287	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   713: ifeq +67 -> 780
    //   716: iconst_2
    //   717: anewarray 76	java/lang/Object
    //   720: dup
    //   721: iconst_0
    //   722: aload 6
    //   724: aastore
    //   725: dup
    //   726: iconst_1
    //   727: getstatic 802	com/ftsafe/CCIDScheme:Lit129	Lgnu/mapping/SimpleSymbol;
    //   730: aload 5
    //   732: invokestatic 348	kawa/lib/lists:assoc	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   735: invokestatic 581	kawa/lib/lists:cadr	(Ljava/lang/Object;)Ljava/lang/Object;
    //   738: aastore
    //   739: invokestatic 267	kawa/standard/append:append$V	([Ljava/lang/Object;)Ljava/lang/Object;
    //   742: astore 6
    //   744: getstatic 336	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   747: aload_0
    //   748: aload_2
    //   749: getstatic 52	com/ftsafe/CCIDScheme:Lit1	Lgnu/math/IntNum;
    //   752: getstatic 165	com/ftsafe/CCIDScheme:Lit6	Lgnu/math/IntNum;
    //   755: getstatic 132	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
    //   758: invokestatic 1406	com/ftsafe/CCIDScheme:PC_to_RDR_XfrBlock	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   761: invokevirtual 28	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   764: pop
    //   765: getstatic 336	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   768: aload_1
    //   769: invokevirtual 780	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   772: invokestatic 1409	com/ftsafe/CCIDScheme:RDR_to_PC_DataBlock	(Ljava/lang/Object;)Lgnu/lists/Pair;
    //   775: astore 5
    //   777: goto -299 -> 478
    //   780: aload 6
    //   782: areturn
    //   783: new 66	gnu/mapping/WrongType
    //   786: dup_x1
    //   787: swap
    //   788: ldc 103
    //   790: iconst_1
    //   791: aload 5
    //   793: invokespecial 71	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   796: athrow
    //   797: new 66	gnu/mapping/WrongType
    //   800: dup_x1
    //   801: swap
    //   802: ldc 103
    //   804: iconst_1
    //   805: aload 5
    //   807: invokespecial 71	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   810: athrow
    //   811: new 66	gnu/mapping/WrongType
    //   814: dup_x1
    //   815: swap
    //   816: ldc 116
    //   818: iconst_1
    //   819: aload 8
    //   821: invokespecial 71	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   824: athrow
    //   825: new 66	gnu/mapping/WrongType
    //   828: dup_x1
    //   829: swap
    //   830: ldc 116
    //   832: iconst_1
    //   833: aload 9
    //   835: invokespecial 71	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   838: athrow
    //   839: new 66	gnu/mapping/WrongType
    //   842: dup_x1
    //   843: swap
    //   844: ldc 116
    //   846: iconst_1
    //   847: aload 9
    //   849: invokespecial 71	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   852: athrow
    //   853: new 66	gnu/mapping/WrongType
    //   856: dup_x1
    //   857: swap
    //   858: ldc 116
    //   860: iconst_1
    //   861: aload 9
    //   863: invokespecial 71	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   866: athrow
    //   867: new 66	gnu/mapping/WrongType
    //   870: dup_x1
    //   871: swap
    //   872: ldc 103
    //   874: iconst_1
    //   875: aload 10
    //   877: invokespecial 71	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   880: athrow
    // Line number table:
    //   Java source line #11779	-> byte code offset #0
    //   Java source line #11780	-> byte code offset #0
    //   Java source line #11781	-> byte code offset #0
    //   Java source line #11782	-> byte code offset #0
    //   Java source line #11780	-> byte code offset #0
    //   Java source line #11783	-> byte code offset #0
    //   Java source line #11784	-> byte code offset #3
    //   Java source line #11785	-> byte code offset #6
    //   Java source line #11786	-> byte code offset #57
    //   Java source line #11787	-> byte code offset #57
    //   Java source line #11789	-> byte code offset #79
    //   Java source line #11790	-> byte code offset #98
    //   Java source line #11792	-> byte code offset #111
    //   Java source line #11793	-> byte code offset #126
    //   Java source line #11794	-> byte code offset #160
    //   Java source line #11781	-> byte code offset #162
    //   Java source line #11794	-> byte code offset #218
    //   Java source line #11795	-> byte code offset #263
    //   Java source line #11782	-> byte code offset #265
    //   Java source line #11796	-> byte code offset #291
    //   Java source line #11797	-> byte code offset #295
    //   Java source line #11798	-> byte code offset #313
    //   Java source line #11800	-> byte code offset #377
    //   Java source line #11801	-> byte code offset #377
    //   Java source line #11802	-> byte code offset #389
    //   Java source line #11803	-> byte code offset #424
    //   Java source line #11804	-> byte code offset #427
    //   Java source line #11806	-> byte code offset #450
    //   Java source line #11804	-> byte code offset #469
    //   Java source line #11808	-> byte code offset #473
    //   Java source line #11809	-> byte code offset #478
    //   Java source line #11810	-> byte code offset #478
    //   Java source line #11811	-> byte code offset #513
    //   Java source line #11812	-> byte code offset #525
    //   Java source line #11814	-> byte code offset #531
    //   Java source line #11816	-> byte code offset #551
    //   Java source line #11818	-> byte code offset #570
    //   Java source line #11820	-> byte code offset #590
    //   Java source line #11821	-> byte code offset #603
    //   Java source line #11822	-> byte code offset #624
    //   Java source line #11823	-> byte code offset #636
    //   Java source line #11825	-> byte code offset #642
    //   Java source line #11827	-> byte code offset #662
    //   Java source line #11828	-> byte code offset #673
    //   Java source line #11830	-> byte code offset #696
    //   Java source line #11832	-> byte code offset #716
    //   Java source line #11833	-> byte code offset #727
    //   Java source line #11834	-> byte code offset #744
    //   Java source line #11835	-> byte code offset #765
    //   Java source line #11836	-> byte code offset #777
    //   Java source line #11837	-> byte code offset #780
    //   Java source line #11785	-> byte code offset #783
    //   Java source line #11784	-> byte code offset #797
    //   Java source line #11793	-> byte code offset #811
    //   Java source line #11798	-> byte code offset #825
    //   Java source line #11806	-> byte code offset #867
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	782	0	usb_send	Object
    //   0	782	1	usb_recv	Object
    //   0	782	2	slot	Object
    //   0	782	3	data	Object
    //   57	725	4	dwMaxCCIDMessageLength	Object
    //   473	309	5	_rData	Object
    //   126	345	6	abDatas	Object
    //   478	304	6	rData	Object
    //   291	180	7	sData	Object
    //   267	12	8	l	Object
    //   295	176	8	_sDatas	Object
    //   164	18	9	l	Object
    //   389	82	9	ret	gnu.lists.Pair
    // Exception table:
    //   from	to	target	type
    //   26	29	783	java/lang/ClassCastException
    //   43	46	797	java/lang/ClassCastException
    //   145	148	811	java/lang/ClassCastException
    //   331	334	825	java/lang/ClassCastException
    //   345	348	839	java/lang/ClassCastException
    //   361	364	853	java/lang/ClassCastException
    //   460	463	867	java/lang/ClassCastException
  }
  
  static Object lambda36(Object paramObject)
  {
    return lambda36(paramObject, Lit1);
  }
  
  static Object lambda37(Object paramObject)
  {
    return lambda37(paramObject, Lit1);
  }
  
  static Object lambda39()
  {
    return lambda39(Lit15);
  }
  
  public static void doPowerOff(Object paramObject)
  {
    doPowerOff(paramObject, Lit1);
  }
  
  public static gnu.lists.Pair doPowerOn(Object paramObject1, Object paramObject2)
  {
    return doPowerOn(paramObject1, paramObject2, Lit1, Lit1);
  }
  
  public static gnu.lists.Pair doPowerOn(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    return doPowerOn(paramObject1, paramObject2, paramObject3, Lit1);
  }
  
  public static Object doEscape(Object paramObject1, Object paramObject2)
  {
    return doEscape(paramObject1, paramObject2, Lit1);
  }
  
  public static Object doSlotStatus(Object paramObject)
  {
    return doSlotStatus(paramObject, Lit1);
  }
  
  /* Error */
  static gnu.lists.LList lambda51(frame17 $closureEnv, Object requestType, Object request, Object value, Object index, Object length)
  {
    // Byte code:
    //   0: getstatic 16	kawa/standard/Scheme:apply	Lgnu/kawa/functions/Apply;
    //   3: getstatic 48	gnu/kawa/lispexpr/LangObjType:listType	Lgnu/kawa/lispexpr/LangObjType;
    //   6: aload_0
    //   7: getfield 1785	com/ftsafe/CCIDScheme$frame17:$this$	Lcom/ftsafe/CCIDScheme;
    //   10: getfield 1789	com/ftsafe/CCIDScheme:mFTReaderInf	Lcom/ftsafe/readerScheme/FTReaderInf;
    //   13: aload_1
    //   14: invokestatic 34	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   17: dup
    //   18: astore 7
    //   20: checkcast 58	java/lang/Number
    //   23: invokevirtual 62	java/lang/Number:intValue	()I
    //   26: aload_2
    //   27: invokestatic 34	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   30: dup
    //   31: astore 7
    //   33: checkcast 58	java/lang/Number
    //   36: invokevirtual 62	java/lang/Number:intValue	()I
    //   39: aload_3
    //   40: invokestatic 34	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   43: dup
    //   44: astore 7
    //   46: checkcast 58	java/lang/Number
    //   49: invokevirtual 62	java/lang/Number:intValue	()I
    //   52: aload 4
    //   54: invokestatic 34	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   57: dup
    //   58: astore 7
    //   60: checkcast 58	java/lang/Number
    //   63: invokevirtual 62	java/lang/Number:intValue	()I
    //   66: aload 5
    //   68: invokestatic 34	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   71: dup
    //   72: astore 7
    //   74: checkcast 58	java/lang/Number
    //   77: invokevirtual 62	java/lang/Number:intValue	()I
    //   80: sipush 2000
    //   83: invokeinterface 1801 7 0
    //   88: invokevirtual 28	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   91: invokestatic 385	gnu/lists/Sequences:getIterator	(Ljava/lang/Object;)Ljava/util/Iterator;
    //   94: astore 6
    //   96: getstatic 132	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
    //   99: astore 7
    //   101: aconst_null
    //   102: astore 8
    //   104: aload 6
    //   106: invokeinterface 391 1 0
    //   111: ifeq +56 -> 167
    //   114: aload 6
    //   116: invokeinterface 395 1 0
    //   121: astore 9
    //   123: new 98	gnu/lists/Pair
    //   126: dup
    //   127: getstatic 190	gnu/kawa/functions/BitwiseOp:and	Lgnu/kawa/functions/BitwiseOp;
    //   130: aload 9
    //   132: getstatic 193	com/ftsafe/CCIDScheme:Lit9	Lgnu/math/IntNum;
    //   135: invokevirtual 28	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   138: getstatic 132	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
    //   141: invokespecial 404	gnu/lists/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   144: aload 8
    //   146: ifnonnull +9 -> 155
    //   149: dup
    //   150: astore 7
    //   152: goto +10 -> 162
    //   155: aload 8
    //   157: swap
    //   158: dup_x1
    //   159: invokevirtual 408	gnu/lists/Pair:setCdr	(Ljava/lang/Object;)V
    //   162: astore 8
    //   164: goto -60 -> 104
    //   167: aload 7
    //   169: areturn
    //   170: new 66	gnu/mapping/WrongType
    //   173: dup_x1
    //   174: swap
    //   175: ldc_w 1795
    //   178: iconst_2
    //   179: aload 7
    //   181: invokespecial 71	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   184: athrow
    //   185: new 66	gnu/mapping/WrongType
    //   188: dup_x1
    //   189: swap
    //   190: ldc_w 1795
    //   193: iconst_3
    //   194: aload 7
    //   196: invokespecial 71	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   199: athrow
    //   200: new 66	gnu/mapping/WrongType
    //   203: dup_x1
    //   204: swap
    //   205: ldc_w 1795
    //   208: iconst_4
    //   209: aload 7
    //   211: invokespecial 71	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   214: athrow
    //   215: new 66	gnu/mapping/WrongType
    //   218: dup_x1
    //   219: swap
    //   220: ldc_w 1795
    //   223: iconst_5
    //   224: aload 7
    //   226: invokespecial 71	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   229: athrow
    //   230: new 66	gnu/mapping/WrongType
    //   233: dup_x1
    //   234: swap
    //   235: ldc_w 1795
    //   238: bipush 6
    //   240: aload 7
    //   242: invokespecial 71	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   245: athrow
    // Line number table:
    //   Java source line #57	-> byte code offset #0
    //   Java source line #58	-> byte code offset #0
    //   Java source line #59	-> byte code offset #0
    //   Java source line #58	-> byte code offset #127
    //   Java source line #59	-> byte code offset #170
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	169	0	$closureEnv	frame17
    //   0	169	1	requestType	Object
    //   0	169	2	request	Object
    //   0	169	3	value	Object
    //   0	169	4	index	Object
    //   0	169	5	length	Object
    // Exception table:
    //   from	to	target	type
    //   20	26	170	java/lang/ClassCastException
    //   33	39	185	java/lang/ClassCastException
    //   46	52	200	java/lang/ClassCastException
    //   60	66	215	java/lang/ClassCastException
    //   74	80	230	java/lang/ClassCastException
  }
  
  /* Error */
  static void lambda52(frame17 $closureEnv, Object index, Object data)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 1785	com/ftsafe/CCIDScheme$frame17:$this$	Lcom/ftsafe/CCIDScheme;
    //   4: getfield 1789	com/ftsafe/CCIDScheme:mFTReaderInf	Lcom/ftsafe/readerScheme/FTReaderInf;
    //   7: getstatic 336	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   10: getstatic 1734	com/ftsafe/CCIDScheme:GET_DEVICES_INF	Ljava/lang/Object;
    //   13: getstatic 1377	com/ftsafe/CCIDScheme:Lit221	Lgnu/mapping/SimpleSymbol;
    //   16: aload_1
    //   17: invokevirtual 1807	gnu/mapping/Procedure:apply3	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   20: invokestatic 34	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   23: dup
    //   24: astore_3
    //   25: checkcast 58	java/lang/Number
    //   28: invokevirtual 62	java/lang/Number:intValue	()I
    //   31: getstatic 16	kawa/standard/Scheme:apply	Lgnu/kawa/functions/Apply;
    //   34: getstatic 22	com/ftsafe/CCIDScheme:Lit0	Lgnu/bytecode/ArrayType;
    //   37: aload_2
    //   38: invokevirtual 28	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   41: invokestatic 34	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   44: dup
    //   45: astore_3
    //   46: checkcast 36	[B
    //   49: getstatic 1325	com/ftsafe/CCIDScheme:USB_TIMEOUT	Ljava/lang/Object;
    //   52: invokestatic 34	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   55: dup
    //   56: astore_3
    //   57: checkcast 58	java/lang/Number
    //   60: invokevirtual 62	java/lang/Number:intValue	()I
    //   63: invokeinterface 1813 4 0
    //   68: return
    //   69: new 66	gnu/mapping/WrongType
    //   72: dup_x1
    //   73: swap
    //   74: ldc_w 1809
    //   77: iconst_2
    //   78: aload_3
    //   79: invokespecial 71	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   82: athrow
    //   83: new 66	gnu/mapping/WrongType
    //   86: dup_x1
    //   87: swap
    //   88: ldc_w 1809
    //   91: iconst_3
    //   92: aload_3
    //   93: invokespecial 71	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   96: athrow
    //   97: new 66	gnu/mapping/WrongType
    //   100: dup_x1
    //   101: swap
    //   102: ldc_w 1809
    //   105: iconst_4
    //   106: aload_3
    //   107: invokespecial 71	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   110: athrow
    // Line number table:
    //   Java source line #61	-> byte code offset #0
    //   Java source line #62	-> byte code offset #0
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	68	0	$closureEnv	frame17
    //   0	68	1	index	Object
    //   0	68	2	data	Object
    //   24	83	3	localObject	Object
    //   69	1	4	localClassCastException1	ClassCastException
    //   83	1	5	localClassCastException2	ClassCastException
    //   97	1	6	localClassCastException3	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   25	31	69	java/lang/ClassCastException
    //   46	49	83	java/lang/ClassCastException
    //   57	63	97	java/lang/ClassCastException
  }
  
  /* Error */
  static gnu.lists.LList lambda53(frame17 $closureEnv, Object index)
  {
    // Byte code:
    //   0: getstatic 16	kawa/standard/Scheme:apply	Lgnu/kawa/functions/Apply;
    //   3: getstatic 48	gnu/kawa/lispexpr/LangObjType:listType	Lgnu/kawa/lispexpr/LangObjType;
    //   6: aload_0
    //   7: getfield 1785	com/ftsafe/CCIDScheme$frame17:$this$	Lcom/ftsafe/CCIDScheme;
    //   10: getfield 1789	com/ftsafe/CCIDScheme:mFTReaderInf	Lcom/ftsafe/readerScheme/FTReaderInf;
    //   13: getstatic 336	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   16: getstatic 1734	com/ftsafe/CCIDScheme:GET_DEVICES_INF	Ljava/lang/Object;
    //   19: getstatic 1386	com/ftsafe/CCIDScheme:Lit223	Lgnu/mapping/SimpleSymbol;
    //   22: aload_1
    //   23: invokevirtual 1807	gnu/mapping/Procedure:apply3	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   26: invokestatic 34	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   29: dup
    //   30: astore_3
    //   31: checkcast 58	java/lang/Number
    //   34: invokevirtual 62	java/lang/Number:intValue	()I
    //   37: getstatic 1325	com/ftsafe/CCIDScheme:USB_TIMEOUT	Ljava/lang/Object;
    //   40: invokestatic 34	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   43: dup
    //   44: astore_3
    //   45: checkcast 58	java/lang/Number
    //   48: invokevirtual 62	java/lang/Number:intValue	()I
    //   51: invokeinterface 1822 3 0
    //   56: invokevirtual 28	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   59: invokestatic 385	gnu/lists/Sequences:getIterator	(Ljava/lang/Object;)Ljava/util/Iterator;
    //   62: astore_2
    //   63: getstatic 132	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
    //   66: astore_3
    //   67: aconst_null
    //   68: astore 4
    //   70: aload_2
    //   71: invokeinterface 391 1 0
    //   76: ifeq +54 -> 130
    //   79: aload_2
    //   80: invokeinterface 395 1 0
    //   85: astore 5
    //   87: new 98	gnu/lists/Pair
    //   90: dup
    //   91: getstatic 190	gnu/kawa/functions/BitwiseOp:and	Lgnu/kawa/functions/BitwiseOp;
    //   94: aload 5
    //   96: getstatic 193	com/ftsafe/CCIDScheme:Lit9	Lgnu/math/IntNum;
    //   99: invokevirtual 28	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   102: getstatic 132	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
    //   105: invokespecial 404	gnu/lists/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   108: aload 4
    //   110: ifnonnull +8 -> 118
    //   113: dup
    //   114: astore_3
    //   115: goto +10 -> 125
    //   118: aload 4
    //   120: swap
    //   121: dup_x1
    //   122: invokevirtual 408	gnu/lists/Pair:setCdr	(Ljava/lang/Object;)V
    //   125: astore 4
    //   127: goto -57 -> 70
    //   130: aload_3
    //   131: areturn
    //   132: new 66	gnu/mapping/WrongType
    //   135: dup_x1
    //   136: swap
    //   137: ldc_w 1818
    //   140: iconst_2
    //   141: aload_3
    //   142: invokespecial 71	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   145: athrow
    //   146: new 66	gnu/mapping/WrongType
    //   149: dup_x1
    //   150: swap
    //   151: ldc_w 1818
    //   154: iconst_3
    //   155: aload_3
    //   156: invokespecial 71	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   159: athrow
    // Line number table:
    //   Java source line #64	-> byte code offset #0
    //   Java source line #65	-> byte code offset #0
    //   Java source line #66	-> byte code offset #0
    //   Java source line #65	-> byte code offset #91
    //   Java source line #66	-> byte code offset #132
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	131	0	$closureEnv	frame17
    //   0	131	1	index	Object
    // Exception table:
    //   from	to	target	type
    //   31	37	132	java/lang/ClassCastException
    //   45	51	146	java/lang/ClassCastException
  }
  
  /* Error */
  static gnu.lists.LList lambda55(frame17 $closureEnv, Object index)
  {
    // Byte code:
    //   0: getstatic 16	kawa/standard/Scheme:apply	Lgnu/kawa/functions/Apply;
    //   3: getstatic 48	gnu/kawa/lispexpr/LangObjType:listType	Lgnu/kawa/lispexpr/LangObjType;
    //   6: aload_0
    //   7: getfield 1785	com/ftsafe/CCIDScheme$frame17:$this$	Lcom/ftsafe/CCIDScheme;
    //   10: getfield 1789	com/ftsafe/CCIDScheme:mFTReaderInf	Lcom/ftsafe/readerScheme/FTReaderInf;
    //   13: getstatic 336	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   16: getstatic 1734	com/ftsafe/CCIDScheme:GET_DEVICES_INF	Ljava/lang/Object;
    //   19: getstatic 1395	com/ftsafe/CCIDScheme:Lit226	Lgnu/mapping/SimpleSymbol;
    //   22: aload_1
    //   23: invokevirtual 1807	gnu/mapping/Procedure:apply3	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   26: invokestatic 34	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   29: dup
    //   30: astore_3
    //   31: checkcast 58	java/lang/Number
    //   34: invokevirtual 62	java/lang/Number:intValue	()I
    //   37: getstatic 1325	com/ftsafe/CCIDScheme:USB_TIMEOUT	Ljava/lang/Object;
    //   40: invokestatic 34	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   43: dup
    //   44: astore_3
    //   45: checkcast 58	java/lang/Number
    //   48: invokevirtual 62	java/lang/Number:intValue	()I
    //   51: invokeinterface 1822 3 0
    //   56: invokevirtual 28	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   59: invokestatic 385	gnu/lists/Sequences:getIterator	(Ljava/lang/Object;)Ljava/util/Iterator;
    //   62: astore_2
    //   63: getstatic 132	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
    //   66: astore_3
    //   67: aconst_null
    //   68: astore 4
    //   70: aload_2
    //   71: invokeinterface 391 1 0
    //   76: ifeq +54 -> 130
    //   79: aload_2
    //   80: invokeinterface 395 1 0
    //   85: astore 5
    //   87: new 98	gnu/lists/Pair
    //   90: dup
    //   91: getstatic 190	gnu/kawa/functions/BitwiseOp:and	Lgnu/kawa/functions/BitwiseOp;
    //   94: aload 5
    //   96: getstatic 193	com/ftsafe/CCIDScheme:Lit9	Lgnu/math/IntNum;
    //   99: invokevirtual 28	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   102: getstatic 132	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
    //   105: invokespecial 404	gnu/lists/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   108: aload 4
    //   110: ifnonnull +8 -> 118
    //   113: dup
    //   114: astore_3
    //   115: goto +10 -> 125
    //   118: aload 4
    //   120: swap
    //   121: dup_x1
    //   122: invokevirtual 408	gnu/lists/Pair:setCdr	(Ljava/lang/Object;)V
    //   125: astore 4
    //   127: goto -57 -> 70
    //   130: aload_3
    //   131: areturn
    //   132: new 66	gnu/mapping/WrongType
    //   135: dup_x1
    //   136: swap
    //   137: ldc_w 1818
    //   140: iconst_2
    //   141: aload_3
    //   142: invokespecial 71	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   145: athrow
    //   146: new 66	gnu/mapping/WrongType
    //   149: dup_x1
    //   150: swap
    //   151: ldc_w 1818
    //   154: iconst_3
    //   155: aload_3
    //   156: invokespecial 71	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   159: athrow
    // Line number table:
    //   Java source line #73	-> byte code offset #0
    //   Java source line #74	-> byte code offset #0
    //   Java source line #75	-> byte code offset #0
    //   Java source line #74	-> byte code offset #91
    //   Java source line #75	-> byte code offset #132
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	131	0	$closureEnv	frame17
    //   0	131	1	index	Object
    // Exception table:
    //   from	to	target	type
    //   31	37	132	java/lang/ClassCastException
    //   45	51	146	java/lang/ClassCastException
  }
  
  /* Error */
  static Object lambda57(frame19 $closureEnv)
  {
    // Byte code:
    //   0: getstatic 1774	com/ftsafe/CCIDScheme:USB_INTERRUPT_RECV	Lgnu/mapping/Procedure;
    //   3: aload_0
    //   4: getfield 1867	com/ftsafe/CCIDScheme$frame19:index	Ljava/lang/Object;
    //   7: invokevirtual 780	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   10: astore_1
    //   11: getstatic 276	kawa/standard/Scheme:isEqual	Lgnu/kawa/functions/IsEqual;
    //   14: aload_1
    //   15: getstatic 1870	com/ftsafe/CCIDScheme:Lit253	Lgnu/lists/PairWithPosition;
    //   18: invokevirtual 28	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   21: invokestatic 287	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   24: ifeq +78 -> 102
    //   27: aload_0
    //   28: getfield 1866	com/ftsafe/CCIDScheme$frame19:staticLink	Lcom/ftsafe/CCIDScheme$frame18;
    //   31: getfield 1847	com/ftsafe/CCIDScheme$frame18:$this$	Lcom/ftsafe/CCIDScheme;
    //   34: getfield 1793	com/ftsafe/CCIDScheme:mHandler	Landroid/os/Handler;
    //   37: aload_0
    //   38: getfield 1866	com/ftsafe/CCIDScheme$frame19:staticLink	Lcom/ftsafe/CCIDScheme$frame18;
    //   41: getfield 1847	com/ftsafe/CCIDScheme$frame18:$this$	Lcom/ftsafe/CCIDScheme;
    //   44: getfield 1793	com/ftsafe/CCIDScheme:mHandler	Landroid/os/Handler;
    //   47: iconst_1
    //   48: getstatic 1876	com/ftsafe/DK:CARD_IN_MASK	I
    //   51: invokestatic 329	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   54: aload_0
    //   55: getfield 1867	com/ftsafe/CCIDScheme$frame19:index	Ljava/lang/Object;
    //   58: invokestatic 114	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   61: invokestatic 34	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   64: dup
    //   65: astore_2
    //   66: checkcast 58	java/lang/Number
    //   69: invokevirtual 62	java/lang/Number:intValue	()I
    //   72: goto +17 -> 89
    //   75: new 66	gnu/mapping/WrongType
    //   78: dup_x1
    //   79: swap
    //   80: ldc_w 1878
    //   83: iconst_2
    //   84: aload_2
    //   85: invokespecial 71	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   88: athrow
    //   89: ldc_w 427
    //   92: invokevirtual 1884	android/os/Handler:obtainMessage	(ILjava/lang/Object;)Landroid/os/Message;
    //   95: invokevirtual 1888	android/os/Handler:sendMessage	(Landroid/os/Message;)Z
    //   98: pop
    //   99: goto +125 -> 224
    //   102: getstatic 276	kawa/standard/Scheme:isEqual	Lgnu/kawa/functions/IsEqual;
    //   105: aload_1
    //   106: getstatic 1891	com/ftsafe/CCIDScheme:Lit254	Lgnu/lists/PairWithPosition;
    //   109: invokevirtual 28	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   112: invokestatic 287	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   115: ifeq +78 -> 193
    //   118: aload_0
    //   119: getfield 1866	com/ftsafe/CCIDScheme$frame19:staticLink	Lcom/ftsafe/CCIDScheme$frame18;
    //   122: getfield 1847	com/ftsafe/CCIDScheme$frame18:$this$	Lcom/ftsafe/CCIDScheme;
    //   125: getfield 1793	com/ftsafe/CCIDScheme:mHandler	Landroid/os/Handler;
    //   128: aload_0
    //   129: getfield 1866	com/ftsafe/CCIDScheme$frame19:staticLink	Lcom/ftsafe/CCIDScheme$frame18;
    //   132: getfield 1847	com/ftsafe/CCIDScheme$frame18:$this$	Lcom/ftsafe/CCIDScheme;
    //   135: getfield 1793	com/ftsafe/CCIDScheme:mHandler	Landroid/os/Handler;
    //   138: iconst_1
    //   139: getstatic 1894	com/ftsafe/DK:CARD_OUT_MASK	I
    //   142: invokestatic 329	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   145: aload_0
    //   146: getfield 1867	com/ftsafe/CCIDScheme$frame19:index	Ljava/lang/Object;
    //   149: invokestatic 114	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   152: invokestatic 34	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   155: dup
    //   156: astore_2
    //   157: checkcast 58	java/lang/Number
    //   160: invokevirtual 62	java/lang/Number:intValue	()I
    //   163: goto +17 -> 180
    //   166: new 66	gnu/mapping/WrongType
    //   169: dup_x1
    //   170: swap
    //   171: ldc_w 1878
    //   174: iconst_2
    //   175: aload_2
    //   176: invokespecial 71	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   179: athrow
    //   180: ldc_w 427
    //   183: invokevirtual 1884	android/os/Handler:obtainMessage	(ILjava/lang/Object;)Landroid/os/Message;
    //   186: invokevirtual 1888	android/os/Handler:sendMessage	(Landroid/os/Message;)Z
    //   189: pop
    //   190: goto +34 -> 224
    //   193: getstatic 317	com/ftsafe/CCIDScheme:pp	Lgnu/mapping/Procedure;
    //   196: iconst_2
    //   197: anewarray 76	java/lang/Object
    //   200: dup
    //   201: iconst_0
    //   202: ldc_w 1896
    //   205: aastore
    //   206: dup
    //   207: iconst_1
    //   208: aload_1
    //   209: invokestatic 310	com/ftsafe/CCIDScheme:object$To$String	(Ljava/lang/Object;)Ljava/lang/String;
    //   212: aastore
    //   213: invokestatic 416	kawa/lib/strings:stringAppend	([Ljava/lang/Object;)Lgnu/lists/FString;
    //   216: invokevirtual 780	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   219: pop
    //   220: goto +4 -> 224
    //   223: astore_1
    //   224: getstatic 109	com/ftsafe/CCIDScheme:Lit2	Lgnu/math/IntNum;
    //   227: invokestatic 1899	com/ftsafe/CCIDScheme:threadSleep$Ex	(Ljava/lang/Object;)V
    //   230: aload_0
    //   231: getfield 1866	com/ftsafe/CCIDScheme$frame19:staticLink	Lcom/ftsafe/CCIDScheme$frame18;
    //   234: getfield 1847	com/ftsafe/CCIDScheme$frame18:$this$	Lcom/ftsafe/CCIDScheme;
    //   237: getfield 1789	com/ftsafe/CCIDScheme:mFTReaderInf	Lcom/ftsafe/readerScheme/FTReaderInf;
    //   240: invokeinterface 1903 1 0
    //   245: invokestatic 287	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   248: ifeq +6 -> 254
    //   251: goto -251 -> 0
    //   254: getstatic 317	com/ftsafe/CCIDScheme:pp	Lgnu/mapping/Procedure;
    //   257: iconst_3
    //   258: anewarray 76	java/lang/Object
    //   261: dup
    //   262: iconst_0
    //   263: ldc_w 1904
    //   266: aastore
    //   267: dup
    //   268: iconst_1
    //   269: aload_0
    //   270: getfield 1867	com/ftsafe/CCIDScheme$frame19:index	Ljava/lang/Object;
    //   273: ldc 58
    //   275: invokestatic 101	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   278: dup
    //   279: astore_1
    //   280: checkcast 58	java/lang/Number
    //   283: invokestatic 517	kawa/lib/numbers:number$To$String	(Ljava/lang/Number;)Ljava/lang/CharSequence;
    //   286: aastore
    //   287: dup
    //   288: iconst_2
    //   289: ldc_w 1906
    //   292: aastore
    //   293: invokestatic 416	kawa/lib/strings:stringAppend	([Ljava/lang/Object;)Lgnu/lists/FString;
    //   296: invokevirtual 780	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   299: areturn
    //   300: new 66	gnu/mapping/WrongType
    //   303: dup_x1
    //   304: swap
    //   305: ldc_w 363
    //   308: iconst_1
    //   309: aload_1
    //   310: invokespecial 71	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   313: athrow
    // Line number table:
    //   Java source line #99	-> byte code offset #0
    //   Java source line #100	-> byte code offset #0
    //   Java source line #101	-> byte code offset #0
    //   Java source line #102	-> byte code offset #0
    //   Java source line #103	-> byte code offset #11
    //   Java source line #104	-> byte code offset #27
    //   Java source line #105	-> byte code offset #105
    //   Java source line #106	-> byte code offset #118
    //   Java source line #107	-> byte code offset #193
    //   Java source line #109	-> byte code offset #224
    //   Java source line #110	-> byte code offset #230
    //   Java source line #111	-> byte code offset #251
    //   Java source line #112	-> byte code offset #254
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	299	0	$closureEnv	frame19
    //   11	209	1	ret	Object
    //   220	4	1	e	Exception
    // Exception table:
    //   from	to	target	type
    //   66	72	75	java/lang/ClassCastException
    //   157	163	166	java/lang/ClassCastException
    //   0	223	223	java/lang/Exception
    //   280	283	300	java/lang/ClassCastException
  }
  
  public class frame16
    extends gnu.expr.ModuleBody
  {
    Object func;
    
    public frame16() {}
  }
  
  public class frame18
    extends gnu.expr.ModuleBody
  {
    CCIDScheme $this$;
    
    public frame18() {}
  }
}
