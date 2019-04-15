package gnu.kawa.slib;

import gnu.expr.KawaConvert;
import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.expr.SourceName;
import gnu.expr.Special;
import gnu.kawa.functions.AddOp;
import gnu.kawa.functions.IsEqv;
import gnu.kawa.functions.NumberCompare;
import gnu.lists.Consumer;
import gnu.lists.EmptyList;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.lists.PairWithPosition;
import gnu.mapping.CallContext;
import gnu.mapping.Procedure;
import gnu.mapping.Promise;
import gnu.mapping.PropertySet;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Symbol;
import gnu.mapping.WrongType;
import gnu.math.IntNum;
import gnu.text.Char;
import kawa.SourceType;
import kawa.lib.exceptions;
import kawa.lib.lists;
import kawa.lib.rnrs.unicode;
import kawa.lib.strings;
import kawa.standard.Scheme;


































































































































































































































































































































































































































































































































































































































public class pregexp
  extends ModuleBody
{
  public static IntNum $Stpregexp$Mnversion$St;
  @SourceType("character")
  public static int $Stpregexp$Mncomment$Mnchar$St;
  public static int $Stpregexp$Mnnul$Mnchar$Mnint$St;
  @SourceType("character")
  public static int $Stpregexp$Mnreturn$Mnchar$St;
  @SourceType("character")
  public static int $Stpregexp$Mntab$Mnchar$St;
  public static Object $Stpregexp$Mnspace$Mnsensitive$Qu$St;
  public static final ModuleMethod pregexp$Mnreverse$Ex;
  public static ModuleMethod pregexp$Mnerror;
  public static final ModuleMethod pregexp$Mnread$Mnpattern;
  public static final ModuleMethod pregexp$Mnread$Mnbranch;
  public static final ModuleMethod pregexp$Mnread$Mnpiece;
  public static final ModuleMethod pregexp$Mnread$Mnescaped$Mnnumber;
  public static final ModuleMethod pregexp$Mnread$Mnescaped$Mnchar;
  public static final ModuleMethod pregexp$Mnread$Mnposix$Mnchar$Mnclass;
  public static final ModuleMethod pregexp$Mnread$Mncluster$Mntype;
  public static final ModuleMethod pregexp$Mnread$Mnsubpattern;
  public static final ModuleMethod pregexp$Mnwrap$Mnquantifier$Mnif$Mnany;
  public static final ModuleMethod pregexp$Mnread$Mnnums;
  public static final ModuleMethod pregexp$Mninvert$Mnchar$Mnlist;
  public static final ModuleMethod pregexp$Mnread$Mnchar$Mnlist;
  public static final ModuleMethod pregexp$Mnstring$Mnmatch;
  public static final ModuleMethod pregexp$Mnchar$Mnword$Qu;
  public static final ModuleMethod pregexp$Mnat$Mnword$Mnboundary$Qu;
  public static final ModuleMethod pregexp$Mncheck$Mnif$Mnin$Mnchar$Mnclass$Qu;
  public static final ModuleMethod pregexp$Mnlist$Mnref;
  public static final ModuleMethod pregexp$Mnmake$Mnbackref$Mnlist;
  public static final ModuleMethod pregexp$Mnmatch$Mnpositions$Mnaux;
  public static final ModuleMethod pregexp$Mnreplace$Mnaux;
  public static final ModuleMethod pregexp;
  public static final ModuleMethod pregexp$Mnmatch$Mnpositions;
  public static final ModuleMethod pregexp$Mnmatch;
  public static final ModuleMethod pregexp$Mnsplit;
  public static final ModuleMethod pregexp$Mnreplace;
  public static final ModuleMethod pregexp$Mnreplace$St;
  public static final ModuleMethod pregexp$Mnquote;
  static final IntNum Lit0;
  static final SimpleSymbol Lit1;
  static final SimpleSymbol Lit2;
  static final IntNum Lit3;
  static final SimpleSymbol Lit4;
  static final SimpleSymbol Lit5;
  static final SimpleSymbol Lit6;
  static final SimpleSymbol Lit7;
  static final SimpleSymbol Lit8;
  static final SimpleSymbol Lit9;
  static final Char Lit10;
  static final IntNum Lit11;
  static final SimpleSymbol Lit12;
  static final SimpleSymbol Lit13;
  static final SimpleSymbol Lit14;
  static final PairWithPosition Lit15;
  static final PairWithPosition Lit16;
  static final SimpleSymbol Lit17;
  static final SimpleSymbol Lit18;
  static final SimpleSymbol Lit19;
  static final PairWithPosition Lit20;
  static final SimpleSymbol Lit21;
  static final Char Lit22;
  static final Char Lit23;
  static final SimpleSymbol Lit24;
  static final PairWithPosition Lit25;
  static final PairWithPosition Lit26;
  static final PairWithPosition Lit27;
  static final PairWithPosition Lit28;
  static final PairWithPosition Lit29;
  static final SimpleSymbol Lit30;
  static final SimpleSymbol Lit31;
  static final SimpleSymbol Lit32;
  static final PairWithPosition Lit33;
  static final SimpleSymbol Lit34;
  static final SimpleSymbol Lit35;
  static final SimpleSymbol Lit36;
  static final SimpleSymbol Lit37;
  static final SimpleSymbol Lit38;
  static final SimpleSymbol Lit39;
  static final IntNum Lit40;
  static final SimpleSymbol Lit41;
  static final SimpleSymbol Lit42;
  static final SimpleSymbol Lit43;
  static final SimpleSymbol Lit44;
  static final SimpleSymbol Lit45;
  static final SimpleSymbol Lit46;
  static final SimpleSymbol Lit47;
  static final SimpleSymbol Lit48;
  static final SimpleSymbol Lit49;
  static final SimpleSymbol Lit50;
  static final SimpleSymbol Lit51;
  static final SimpleSymbol Lit52;
  static final SimpleSymbol Lit53;
  static final SimpleSymbol Lit54;
  static final SimpleSymbol Lit55;
  static final SimpleSymbol Lit56;
  static final SimpleSymbol Lit57;
  static final SimpleSymbol Lit58;
  static final SimpleSymbol Lit59;
  static final SimpleSymbol Lit60;
  static final SimpleSymbol Lit61;
  static final ModuleMethod lambda$Fn1;
  static final SimpleSymbol Lit62;
  static final SimpleSymbol Lit63;
  static final PairWithPosition Lit64;
  static final ModuleMethod lambda$Fn4;
  static final SimpleSymbol Lit65;
  static final ModuleMethod lambda$Fn5;
  static final SimpleSymbol Lit66;
  static final ModuleMethod lambda$Fn9;
  static final SimpleSymbol Lit67;
  static final ModuleMethod lambda$Fn10;
  static final SimpleSymbol Lit68;
  static final ModuleMethod lambda$Fn11;
  static final SimpleSymbol Lit69;
  static final SimpleSymbol Lit70;
  static final SimpleSymbol Lit71;
  static final SimpleSymbol Lit72;
  static final PairWithPosition Lit73;
  static final Char Lit74 = Char.valueOf(92);
  public static pregexp $instance;
  
  public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
  {
    switch (selector) {case 49:  value1 = paramObject;proc = paramModuleMethod;pc = 1;return 0;
    case 43: 
      value1 = paramObject;proc = paramModuleMethod;pc = 1;return 0;
    case 34: 
      value1 = paramObject;proc = paramModuleMethod;pc = 1;return 0;
    case 30: 
      value1 = paramObject;proc = paramModuleMethod;pc = 1;return 0;
    case 27: 
      value1 = paramObject;proc = paramModuleMethod;pc = 1;return 0;
    case 16: 
      value1 = paramObject;proc = paramModuleMethod;pc = 1;return 0; } return super.match1(paramModuleMethod, paramObject, paramCallContext); }
  public static Object pregexpReverse$Ex(Object s) { for (;;) { EmptyList localEmptyList = LList.Empty;Object s = s;
      Object localObject1;
      try { d = lists.cdr((Pair)(localObject1 = Promise.force(s, Pair.class))); } catch (ClassCastException localClassCastException1) { Object r; Object d; throw new WrongType(
        
          localClassCastException1, "cdr", 1, localObject1);
      }
      try
      {
        lists.setCdr$Ex((Pair)(localObject1 = Promise.force(s, Pair.class)), r);
        tmpTernaryOp = (lists.isNull(s) ? r : s;
      }
      catch (ClassCastException localClassCastException2)
      {
        throw new WrongType(localClassCastException2, "set-cdr!", 1, localObject1); } }
    return d;
  }
  
  private static void $runBody$()
  {
    ;
    Consumer $result = getInstanceconsumer;$Stpregexp$Mnversion$St = Lit0;
    
    $Stpregexp$Mncomment$Mnchar$St = 59;
    
    $Stpregexp$Mnnul$Mnchar$Mnint$St = 97 - 97;
    


    $Stpregexp$Mnreturn$Mnchar$St = 13 + $Stpregexp$Mnnul$Mnchar$Mnint$St;
    



    $Stpregexp$Mntab$Mnchar$St = 9 + $Stpregexp$Mnnul$Mnchar$Mnint$St;
    



    $Stpregexp$Mnspace$Mnsensitive$Qu$St = Boolean.TRUE;
    









    pregexp$Mnerror = exceptions.error;
  }
  









































































































































































































































































































































































































































































































































































































































































































  public int match3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3, CallContext paramCallContext)
  {
    switch (selector) {case 48:  value1 = paramObject1;value2 = paramObject2;value3 = paramObject3;proc = paramModuleMethod;pc = 3;return 0;
    case 47: 
      value1 = paramObject1;value2 = paramObject2;value3 = paramObject3;proc = paramModuleMethod;pc = 3;return 0;
    case 31: 
      value1 = paramObject1;value2 = paramObject2;value3 = paramObject3;proc = paramModuleMethod;pc = 3;return 0;
    case 28: 
      value1 = paramObject1;value2 = paramObject2;value3 = paramObject3;proc = paramModuleMethod;pc = 3;return 0;
    case 26: 
      value1 = paramObject1;value2 = paramObject2;value3 = paramObject3;proc = paramModuleMethod;pc = 3;return 0;
    case 25: 
      value1 = paramObject1;value2 = paramObject2;value3 = paramObject3;proc = paramModuleMethod;pc = 3;return 0;
    case 24: 
      value1 = paramObject1;value2 = paramObject2;value3 = paramObject3;proc = paramModuleMethod;pc = 3;return 0;
    case 23: 
      value1 = paramObject1;value2 = paramObject2;value3 = paramObject3;proc = paramModuleMethod;pc = 3;return 0;
    case 22: 
      value1 = paramObject1;value2 = paramObject2;value3 = paramObject3;proc = paramModuleMethod;pc = 3;return 0;
    case 21: 
      value1 = paramObject1;value2 = paramObject2;value3 = paramObject3;proc = paramModuleMethod;pc = 3;return 0;
    case 20: 
      value1 = paramObject1;value2 = paramObject2;value3 = paramObject3;proc = paramModuleMethod;pc = 3;return 0;
    case 19: 
      value1 = paramObject1;value2 = paramObject2;value3 = paramObject3;proc = paramModuleMethod;pc = 3;return 0;
    case 18: 
      value1 = paramObject1;value2 = paramObject2;value3 = paramObject3;proc = paramModuleMethod;pc = 3;return 0;
    case 17: 
      value1 = paramObject1;value2 = paramObject2;value3 = paramObject3;proc = paramModuleMethod;pc = 3;return 0; } return super.match3(paramModuleMethod, paramObject1, paramObject2, paramObject3, paramCallContext);
  }
  











































































































































































































































































































































































































































































































































































































































  public int matchN(ModuleMethod paramModuleMethod, Object[] paramArrayOfObject, CallContext paramCallContext)
  {
    switch (selector) {case 45:  values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0;
    case 44: 
      values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0;
    case 41: 
      values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0;
    case 29: 
      values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0; } return super.matchN(paramModuleMethod, paramArrayOfObject, paramCallContext);
  }
  






































































































































































































































































































































  public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
  {
    switch (selector) {case 46:  value1 = paramObject1;value2 = paramObject2;proc = paramModuleMethod;pc = 2;return 0;
    case 33: 
      value1 = paramObject1;value2 = paramObject2;proc = paramModuleMethod;pc = 2;return 0;
    case 32: 
      value1 = paramObject1;value2 = paramObject2;proc = paramModuleMethod;pc = 2;return 0; } return super.match2(paramModuleMethod, paramObject1, paramObject2, paramCallContext); }
  public static boolean isPregexpCheckIfInCharClass(Object c, Object char$Mnclass) { switch (char$Mnclass.hashCode()) {case 1753596759:  if (IsEqv.apply(char$Mnclass, Lit49)) tmpTernaryOp = 0; break; case 1754309978:  if (IsEqv.apply(char$Mnclass, Lit50))
      {




        x = Char.castToCharacter(Promise.force(c)) == 32;tmpTernaryOp = 0; } break; case 1753400676:  if (!IsEqv.apply(char$Mnclass, Lit51)) {
        break;
      }
    }
    try
    {
      tmpTernaryOp = unicode.isCharAlphabetic(Char.castToCharacter(x = Promise.force(c)));
    }
    catch (ClassCastException localClassCastException2)
    {
      for (;;)
      {
        boolean x;
        
        boolean x;
        
        boolean x;
        
        try
        {
          tmpTernaryOp = unicode.isCharUpperCase(Char.castToCharacter(x = Promise.force(c))); continue; if (IsEqv.apply(char$Mnclass, Lit9)) { tmpTernaryOp = 1; continue; if (!IsEqv.apply(char$Mnclass, Lit53)) {} } } catch (ClassCastException localClassCastException2) { Object localObject1; boolean x; boolean x; Object localObject3; boolean x; Object localObject2; boolean x; boolean x; boolean x; throw new WrongType(localClassCastException2, "char-upper-case?", 1, x);
        }
        try
        {
          x = unicode.isCharAlphabetic(Char.castToCharacter(localObject1 = Promise.force(c))); if (x) tmpTernaryOp = x; } catch (ClassCastException localClassCastException3) { throw new WrongType(
          













            localClassCastException3, "char-alphabetic?", 1, x);
        }
        try
        {
          tmpTernaryOp = unicode.isCharNumeric(Char.castToCharacter(localObject1 = Promise.force(c))); continue; if (!IsEqv.apply(char$Mnclass, Lit17)) {} } catch (ClassCastException localClassCastException4) { throw new WrongType(localClassCastException4, "char-numeric?", 1, x);
        }
        
        try
        {
          tmpTernaryOp = unicode.isCharNumeric(Char.castToCharacter(x = Promise.force(c))); continue; if (!IsEqv.apply(char$Mnclass, Lit54)) {} } catch (ClassCastException localClassCastException5) { throw new WrongType(localClassCastException5, "char-numeric?", 1, x);
        }
        try {
          tmpTernaryOp = unicode.isCharLowerCase(Char.castToCharacter(x = Promise.force(c))); continue; if (!IsEqv.apply(char$Mnclass, Lit14)) {} } catch (ClassCastException localClassCastException6) { throw new WrongType(localClassCastException6, "char-lower-case?", 1, x);
        }
        



        try
        {
          x = unicode.isCharAlphabetic(Char.castToCharacter(localObject1 = Promise.force(c))); if (x) tmpTernaryOp = x; } catch (ClassCastException localClassCastException7) { throw new WrongType(localClassCastException7, "char-alphabetic?", 1, x); }
        try { x = unicode.isCharNumeric(Char.castToCharacter(localObject3 = Promise.force(c)));
          tmpTernaryOp = 0; continue; if (!IsEqv.apply(char$Mnclass, Lit55)) {}
        }
        catch (ClassCastException localClassCastException8)
        {
          throw new WrongType(localClassCastException8, "char-numeric?", 1, x);
        }
        try { x = unicode.isCharNumeric(Char.castToCharacter(localObject2 = Promise.force(c)));
          x = Character.toUpperCase(Char.castToCharacter(Promise.force(c))) == Character.toUpperCase(97);x = Character.toUpperCase(Char.castToCharacter(Promise.force(c))) == Character.toUpperCase(98);
          x = Character.toUpperCase(Char.castToCharacter(Promise.force(c))) == Character.toUpperCase(99);x = Character.toUpperCase(Char.castToCharacter(Promise.force(c))) == Character.toUpperCase(100);
          x = Character.toUpperCase(Char.castToCharacter(Promise.force(c))) == Character.toUpperCase(101);tmpTernaryOp = 0; continue; if (!IsEqv.apply(char$Mnclass, Lit18)) {}
        }
        catch (ClassCastException localClassCastException9)
        {
          throw new WrongType(localClassCastException9, "char-numeric?", 1, x);
        }
        try
        {
          tmpTernaryOp = unicode.isCharWhitespace(Char.castToCharacter(x = Promise.force(c))); continue; if (IsEqv.apply(char$Mnclass, Lit56)) { tmpTernaryOp = 0; continue; if (IsEqv.apply(char$Mnclass, Lit57)) { tmpTernaryOp = 0; continue; if (IsEqv.apply(char$Mnclass, Lit58)) if (Char.castToCharacter(Promise.force(c)) < 32) {} } } } catch (ClassCastException localClassCastException10) { throw new WrongType(
          



            localClassCastException10, "char-whitespace?", 1, x);
        }
        try
        {
          tmpTernaryOp = 1; continue;tmpTernaryOp = 0; continue; if (IsEqv.apply(char$Mnclass, Lit59)) if (Char.castToCharacter(Promise.force(c)) < 32) {} } catch (ClassCastException localClassCastException11) { throw new WrongType(
          





            localClassCastException11, "char-whitespace?", 1, x);
        }
        try
        {
          if (unicode.isCharWhitespace(Char.castToCharacter(x = Promise.force(c)))) {} } catch (ClassCastException localClassCastException12) { throw new WrongType(localClassCastException12, "char-whitespace?", 1, x); }
        try { if (unicode.isCharAlphabetic(Char.castToCharacter(x = Promise.force(c)))) {} } catch (ClassCastException localClassCastException13) { throw new WrongType(localClassCastException13, "char-alphabetic?", 1, x); }
        try { tmpTernaryOp = 1; continue;tmpTernaryOp = 0; continue;tmpTernaryOp = 0; continue;tmpTernaryOp = 0; continue;throw (Char.castToCharacter(Promise.force(c)) == $Stpregexp$Mntab$Mnchar$St ? 1 : x ? x : Char.castToCharacter(Promise.force(c)) < 128 ? 1 : unicode.isCharNumeric(Char.castToCharacter(x = Promise.force(c))) ? 0 : Special.reachedUnexpected);return exceptions.error(new Object[] { Lit60 }); } catch (ClassCastException localClassCastException14) { throw new WrongType(localClassCastException14, "char-numeric?", 1, x);
        }
      }
      throw new WrongType(
      










        localClassCastException1, "char-alphabetic?", 1, x);
    }
    if (!IsEqv.apply(char$Mnclass, Lit52)) {}
  }
  





















  public static Object pregexpListRef(Object s, Object i)
  {
    for (;;)
    {
      IntNum localIntNum1 = Lit40;Object s = s;
      IntNum k;
      if (NumberCompare.$Eq(k, i)) {} Object localObject1; try { tmpTernaryOp = lists.car((Pair)(localObject1 = Promise.force(s, Pair.class))); } catch (ClassCastException localClassCastException1) { throw new WrongType(
          localClassCastException1, "car", 1, localObject1); } try { tmpTernaryOp = (lists.isNull(s) ? Boolean.FALSE : IntNum.add(k, 1); } catch (ClassCastException localClassCastException2) { throw new WrongType(localClassCastException2, "cdr", 1, localObject1); } } return lists.cdr((Pair)(localObject1 = Promise.force(s, Pair.class)));
  }
  











  public static Object pregexpMakeBackrefList(Object re) { return lambda1sub(re); }
  
  public class frame extends ModuleBody {
    Object sn;
    Procedure identity;
    Object backrefs;
    Object case$Mnsensitive$Qu;
    Object s;
    Object n;
    Object start;
    
    public static Object lambda2identity(Object x) { return x; } public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext) { if (selector == 15) { value1 = paramObject;proc = paramModuleMethod;pc = 1;return 0; } return super.match1(paramModuleMethod, paramObject, paramCallContext); } public Object apply1(ModuleMethod paramModuleMethod, Object paramObject) { if (selector == 15) return lambda2identity(paramObject); return super.apply1(paramModuleMethod, paramObject);
    }
    
    static boolean lambda4() { return false; }
    
    public frame()
    {
      void tmp21_18 = new ModuleMethod(this, 15, "identity", 4097);
      tmp21_18.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm:465");
      identity = tmp21_18;
    }
    
    /* Error */
    public Object lambda3sub(Object backrefs, Object re, Object i, Object sk, Object fk)
    {
      // Byte code:
      //   0: new 2	gnu/kawa/slib/pregexp$frame0
      //   3: dup
      //   4: invokespecial 6	gnu/kawa/slib/pregexp$frame0:<init>	()V
      //   7: dup
      //   8: aload_0
      //   9: putfield 10	gnu/kawa/slib/pregexp$frame0:staticLink	Lgnu/kawa/slib/pregexp$frame;
      //   12: astore 6
      //   14: aload 6
      //   16: aload_2
      //   17: putfield 14	gnu/kawa/slib/pregexp$frame0:re$1	Ljava/lang/Object;
      //   20: aload 6
      //   22: aload_3
      //   23: putfield 17	gnu/kawa/slib/pregexp$frame0:i	Ljava/lang/Object;
      //   26: aload 6
      //   28: aload 4
      //   30: putfield 20	gnu/kawa/slib/pregexp$frame0:sk	Ljava/lang/Object;
      //   33: aload 6
      //   35: aload 5
      //   37: putfield 23	gnu/kawa/slib/pregexp$frame0:fk	Ljava/lang/Object;
      //   40: aload 6
      //   42: getfield 14	gnu/kawa/slib/pregexp$frame0:re$1	Ljava/lang/Object;
      //   45: getstatic 29	gnu/kawa/slib/pregexp:Lit8	Lgnu/mapping/SimpleSymbol;
      //   48: invokestatic 35	gnu/kawa/functions/IsEqv:apply	(Ljava/lang/Object;Ljava/lang/Object;)Z
      //   51: ifeq +51 -> 102
      //   54: aload 6
      //   56: getfield 17	gnu/kawa/slib/pregexp$frame0:i	Ljava/lang/Object;
      //   59: aload_0
      //   60: getfield 40	gnu/kawa/slib/pregexp$frame:start	Ljava/lang/Object;
      //   63: invokestatic 45	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
      //   66: ifeq +22 -> 88
      //   69: getstatic 51	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
      //   72: aload 6
      //   74: getfield 20	gnu/kawa/slib/pregexp$frame0:sk	Ljava/lang/Object;
      //   77: aload 6
      //   79: getfield 17	gnu/kawa/slib/pregexp$frame0:i	Ljava/lang/Object;
      //   82: invokevirtual 57	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   85: goto +2243 -> 2328
      //   88: getstatic 51	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
      //   91: aload 6
      //   93: getfield 23	gnu/kawa/slib/pregexp$frame0:fk	Ljava/lang/Object;
      //   96: invokevirtual 61	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
      //   99: goto +2229 -> 2328
      //   102: aload 6
      //   104: getfield 14	gnu/kawa/slib/pregexp$frame0:re$1	Ljava/lang/Object;
      //   107: getstatic 64	gnu/kawa/slib/pregexp:Lit4	Lgnu/mapping/SimpleSymbol;
      //   110: invokestatic 35	gnu/kawa/functions/IsEqv:apply	(Ljava/lang/Object;Ljava/lang/Object;)Z
      //   113: ifeq +51 -> 164
      //   116: aload 6
      //   118: getfield 17	gnu/kawa/slib/pregexp$frame0:i	Ljava/lang/Object;
      //   121: aload_0
      //   122: getfield 67	gnu/kawa/slib/pregexp$frame:n	Ljava/lang/Object;
      //   125: invokestatic 70	gnu/kawa/functions/NumberCompare:$Gr$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
      //   128: ifeq +22 -> 150
      //   131: getstatic 51	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
      //   134: aload 6
      //   136: getfield 20	gnu/kawa/slib/pregexp$frame0:sk	Ljava/lang/Object;
      //   139: aload 6
      //   141: getfield 17	gnu/kawa/slib/pregexp$frame0:i	Ljava/lang/Object;
      //   144: invokevirtual 57	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   147: goto +2181 -> 2328
      //   150: getstatic 51	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
      //   153: aload 6
      //   155: getfield 23	gnu/kawa/slib/pregexp$frame0:fk	Ljava/lang/Object;
      //   158: invokevirtual 61	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
      //   161: goto +2167 -> 2328
      //   164: aload 6
      //   166: getfield 14	gnu/kawa/slib/pregexp$frame0:re$1	Ljava/lang/Object;
      //   169: getstatic 73	gnu/kawa/slib/pregexp:Lit13	Lgnu/mapping/SimpleSymbol;
      //   172: invokestatic 35	gnu/kawa/functions/IsEqv:apply	(Ljava/lang/Object;Ljava/lang/Object;)Z
      //   175: ifeq +22 -> 197
      //   178: getstatic 51	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
      //   181: aload 6
      //   183: getfield 20	gnu/kawa/slib/pregexp$frame0:sk	Ljava/lang/Object;
      //   186: aload 6
      //   188: getfield 17	gnu/kawa/slib/pregexp$frame0:i	Ljava/lang/Object;
      //   191: invokevirtual 57	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   194: goto +2134 -> 2328
      //   197: aload 6
      //   199: getfield 14	gnu/kawa/slib/pregexp$frame0:re$1	Ljava/lang/Object;
      //   202: getstatic 76	gnu/kawa/slib/pregexp:Lit19	Lgnu/mapping/SimpleSymbol;
      //   205: invokestatic 35	gnu/kawa/functions/IsEqv:apply	(Ljava/lang/Object;Ljava/lang/Object;)Z
      //   208: ifeq +55 -> 263
      //   211: aload_0
      //   212: getfield 79	gnu/kawa/slib/pregexp$frame:s	Ljava/lang/Object;
      //   215: aload 6
      //   217: getfield 17	gnu/kawa/slib/pregexp$frame0:i	Ljava/lang/Object;
      //   220: aload_0
      //   221: getfield 67	gnu/kawa/slib/pregexp$frame:n	Ljava/lang/Object;
      //   224: invokestatic 83	gnu/kawa/slib/pregexp:isPregexpAtWordBoundary	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Z
      //   227: ifeq +22 -> 249
      //   230: getstatic 51	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
      //   233: aload 6
      //   235: getfield 20	gnu/kawa/slib/pregexp$frame0:sk	Ljava/lang/Object;
      //   238: aload 6
      //   240: getfield 17	gnu/kawa/slib/pregexp$frame0:i	Ljava/lang/Object;
      //   243: invokevirtual 57	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   246: goto +2082 -> 2328
      //   249: getstatic 51	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
      //   252: aload 6
      //   254: getfield 23	gnu/kawa/slib/pregexp$frame0:fk	Ljava/lang/Object;
      //   257: invokevirtual 61	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
      //   260: goto +2068 -> 2328
      //   263: aload 6
      //   265: getfield 14	gnu/kawa/slib/pregexp$frame0:re$1	Ljava/lang/Object;
      //   268: getstatic 86	gnu/kawa/slib/pregexp:Lit21	Lgnu/mapping/SimpleSymbol;
      //   271: invokestatic 35	gnu/kawa/functions/IsEqv:apply	(Ljava/lang/Object;Ljava/lang/Object;)Z
      //   274: ifeq +55 -> 329
      //   277: aload_0
      //   278: getfield 79	gnu/kawa/slib/pregexp$frame:s	Ljava/lang/Object;
      //   281: aload 6
      //   283: getfield 17	gnu/kawa/slib/pregexp$frame0:i	Ljava/lang/Object;
      //   286: aload_0
      //   287: getfield 67	gnu/kawa/slib/pregexp$frame:n	Ljava/lang/Object;
      //   290: invokestatic 83	gnu/kawa/slib/pregexp:isPregexpAtWordBoundary	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Z
      //   293: ifeq +17 -> 310
      //   296: getstatic 51	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
      //   299: aload 6
      //   301: getfield 23	gnu/kawa/slib/pregexp$frame0:fk	Ljava/lang/Object;
      //   304: invokevirtual 61	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
      //   307: goto +2021 -> 2328
      //   310: getstatic 51	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
      //   313: aload 6
      //   315: getfield 20	gnu/kawa/slib/pregexp$frame0:sk	Ljava/lang/Object;
      //   318: aload 6
      //   320: getfield 17	gnu/kawa/slib/pregexp$frame0:i	Ljava/lang/Object;
      //   323: invokevirtual 57	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   326: goto +2002 -> 2328
      //   329: aload 6
      //   331: getfield 14	gnu/kawa/slib/pregexp$frame0:re$1	Ljava/lang/Object;
      //   334: invokestatic 92	kawa/lib/characters:isChar	(Ljava/lang/Object;)Z
      //   337: ifeq +129 -> 466
      //   340: aload 6
      //   342: getfield 17	gnu/kawa/slib/pregexp$frame0:i	Ljava/lang/Object;
      //   345: aload_0
      //   346: getfield 67	gnu/kawa/slib/pregexp$frame:n	Ljava/lang/Object;
      //   349: invokestatic 95	gnu/kawa/functions/NumberCompare:$Ls	(Ljava/lang/Object;Ljava/lang/Object;)Z
      //   352: ifeq +114 -> 466
      //   355: aload_0
      //   356: getfield 98	gnu/kawa/slib/pregexp$frame:case$Mnsensitive$Qu	Ljava/lang/Object;
      //   359: invokestatic 103	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
      //   362: ifeq +9 -> 371
      //   365: getstatic 109	kawa/lib/strings:char$Eq$Qu	Lgnu/expr/ModuleMethod;
      //   368: goto +6 -> 374
      //   371: getstatic 112	kawa/lib/strings:char$Mnci$Eq$Qu	Lgnu/expr/ModuleMethod;
      //   374: aload_0
      //   375: getfield 79	gnu/kawa/slib/pregexp$frame:s	Ljava/lang/Object;
      //   378: ldc 114
      //   380: invokestatic 120	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   383: dup
      //   384: astore 7
      //   386: checkcast 114	java/lang/CharSequence
      //   389: aload 6
      //   391: getfield 17	gnu/kawa/slib/pregexp$frame0:i	Ljava/lang/Object;
      //   394: invokestatic 131	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
      //   397: dup
      //   398: astore 7
      //   400: checkcast 133	java/lang/Number
      //   403: invokevirtual 137	java/lang/Number:intValue	()I
      //   406: invokestatic 141	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)I
      //   409: invokestatic 147	gnu/text/Char:make	(I)Lgnu/text/Char;
      //   412: aload 6
      //   414: getfield 14	gnu/kawa/slib/pregexp$frame0:re$1	Ljava/lang/Object;
      //   417: invokevirtual 57	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   420: invokestatic 103	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
      //   423: ifeq +29 -> 452
      //   426: getstatic 51	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
      //   429: aload 6
      //   431: getfield 20	gnu/kawa/slib/pregexp$frame0:sk	Ljava/lang/Object;
      //   434: iconst_1
      //   435: aload 6
      //   437: getfield 17	gnu/kawa/slib/pregexp$frame0:i	Ljava/lang/Object;
      //   440: getstatic 151	gnu/kawa/slib/pregexp:Lit3	Lgnu/math/IntNum;
      //   443: invokestatic 156	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   446: invokevirtual 57	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   449: goto +1879 -> 2328
      //   452: getstatic 51	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
      //   455: aload 6
      //   457: getfield 23	gnu/kawa/slib/pregexp$frame0:fk	Ljava/lang/Object;
      //   460: invokevirtual 61	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
      //   463: goto +1865 -> 2328
      //   466: aload 6
      //   468: getfield 14	gnu/kawa/slib/pregexp$frame0:re$1	Ljava/lang/Object;
      //   471: invokestatic 161	kawa/lib/lists:isPair	(Ljava/lang/Object;)Z
      //   474: ifne +107 -> 581
      //   477: aload 6
      //   479: getfield 17	gnu/kawa/slib/pregexp$frame0:i	Ljava/lang/Object;
      //   482: aload_0
      //   483: getfield 67	gnu/kawa/slib/pregexp$frame:n	Ljava/lang/Object;
      //   486: invokestatic 95	gnu/kawa/functions/NumberCompare:$Ls	(Ljava/lang/Object;Ljava/lang/Object;)Z
      //   489: ifeq +92 -> 581
      //   492: aload_0
      //   493: getfield 79	gnu/kawa/slib/pregexp$frame:s	Ljava/lang/Object;
      //   496: ldc 114
      //   498: invokestatic 120	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   501: dup
      //   502: astore 7
      //   504: checkcast 114	java/lang/CharSequence
      //   507: aload 6
      //   509: getfield 17	gnu/kawa/slib/pregexp$frame0:i	Ljava/lang/Object;
      //   512: invokestatic 131	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
      //   515: dup
      //   516: astore 7
      //   518: checkcast 133	java/lang/Number
      //   521: invokevirtual 137	java/lang/Number:intValue	()I
      //   524: invokestatic 141	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)I
      //   527: invokestatic 147	gnu/text/Char:make	(I)Lgnu/text/Char;
      //   530: aload 6
      //   532: getfield 14	gnu/kawa/slib/pregexp$frame0:re$1	Ljava/lang/Object;
      //   535: invokestatic 164	gnu/kawa/slib/pregexp:isPregexpCheckIfInCharClass	(Ljava/lang/Object;Ljava/lang/Object;)Z
      //   538: ifeq +29 -> 567
      //   541: getstatic 51	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
      //   544: aload 6
      //   546: getfield 20	gnu/kawa/slib/pregexp$frame0:sk	Ljava/lang/Object;
      //   549: iconst_1
      //   550: aload 6
      //   552: getfield 17	gnu/kawa/slib/pregexp$frame0:i	Ljava/lang/Object;
      //   555: getstatic 151	gnu/kawa/slib/pregexp:Lit3	Lgnu/math/IntNum;
      //   558: invokestatic 156	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   561: invokevirtual 57	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   564: goto +1764 -> 2328
      //   567: getstatic 51	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
      //   570: aload 6
      //   572: getfield 23	gnu/kawa/slib/pregexp$frame0:fk	Ljava/lang/Object;
      //   575: invokevirtual 61	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
      //   578: goto +1750 -> 2328
      //   581: aload 6
      //   583: getfield 14	gnu/kawa/slib/pregexp$frame0:re$1	Ljava/lang/Object;
      //   586: invokestatic 161	kawa/lib/lists:isPair	(Ljava/lang/Object;)Z
      //   589: ifeq +192 -> 781
      //   592: aload 6
      //   594: getfield 14	gnu/kawa/slib/pregexp$frame0:re$1	Ljava/lang/Object;
      //   597: ldc -90
      //   599: invokestatic 120	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   602: dup
      //   603: astore 7
      //   605: checkcast 166	gnu/lists/Pair
      //   608: invokestatic 171	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
      //   611: getstatic 174	gnu/kawa/slib/pregexp:Lit48	Lgnu/mapping/SimpleSymbol;
      //   614: invokestatic 35	gnu/kawa/functions/IsEqv:apply	(Ljava/lang/Object;Ljava/lang/Object;)Z
      //   617: ifeq +164 -> 781
      //   620: aload 6
      //   622: getfield 17	gnu/kawa/slib/pregexp$frame0:i	Ljava/lang/Object;
      //   625: aload_0
      //   626: getfield 67	gnu/kawa/slib/pregexp$frame:n	Ljava/lang/Object;
      //   629: invokestatic 95	gnu/kawa/functions/NumberCompare:$Ls	(Ljava/lang/Object;Ljava/lang/Object;)Z
      //   632: ifeq +149 -> 781
      //   635: aload_0
      //   636: getfield 79	gnu/kawa/slib/pregexp$frame:s	Ljava/lang/Object;
      //   639: ldc 114
      //   641: invokestatic 120	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   644: dup
      //   645: astore 8
      //   647: checkcast 114	java/lang/CharSequence
      //   650: aload 6
      //   652: getfield 17	gnu/kawa/slib/pregexp$frame0:i	Ljava/lang/Object;
      //   655: invokestatic 131	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
      //   658: dup
      //   659: astore 8
      //   661: checkcast 133	java/lang/Number
      //   664: invokevirtual 137	java/lang/Number:intValue	()I
      //   667: invokestatic 141	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)I
      //   670: istore 7
      //   672: aload_0
      //   673: getfield 98	gnu/kawa/slib/pregexp$frame:case$Mnsensitive$Qu	Ljava/lang/Object;
      //   676: invokestatic 103	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
      //   679: ifeq +9 -> 688
      //   682: getstatic 177	kawa/lib/strings:char$Ls$Eq$Qu	Lgnu/expr/ModuleMethod;
      //   685: goto +6 -> 691
      //   688: getstatic 180	kawa/lib/strings:char$Mnci$Ls$Eq$Qu	Lgnu/expr/ModuleMethod;
      //   691: astore 8
      //   693: aload 8
      //   695: aload 6
      //   697: getfield 14	gnu/kawa/slib/pregexp$frame0:re$1	Ljava/lang/Object;
      //   700: invokestatic 183	kawa/lib/lists:cadr	(Ljava/lang/Object;)Ljava/lang/Object;
      //   703: iload 7
      //   705: invokestatic 147	gnu/text/Char:make	(I)Lgnu/text/Char;
      //   708: invokevirtual 57	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   711: invokestatic 103	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
      //   714: ifeq +53 -> 767
      //   717: aload 8
      //   719: iload 7
      //   721: invokestatic 147	gnu/text/Char:make	(I)Lgnu/text/Char;
      //   724: aload 6
      //   726: getfield 14	gnu/kawa/slib/pregexp$frame0:re$1	Ljava/lang/Object;
      //   729: invokestatic 186	kawa/lib/lists:caddr	(Ljava/lang/Object;)Ljava/lang/Object;
      //   732: invokevirtual 57	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   735: invokestatic 103	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
      //   738: ifeq +29 -> 767
      //   741: getstatic 51	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
      //   744: aload 6
      //   746: getfield 20	gnu/kawa/slib/pregexp$frame0:sk	Ljava/lang/Object;
      //   749: iconst_1
      //   750: aload 6
      //   752: getfield 17	gnu/kawa/slib/pregexp$frame0:i	Ljava/lang/Object;
      //   755: getstatic 151	gnu/kawa/slib/pregexp:Lit3	Lgnu/math/IntNum;
      //   758: invokestatic 156	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   761: invokevirtual 57	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   764: goto +1564 -> 2328
      //   767: getstatic 51	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
      //   770: aload 6
      //   772: getfield 23	gnu/kawa/slib/pregexp$frame0:fk	Ljava/lang/Object;
      //   775: invokevirtual 61	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
      //   778: goto +1550 -> 2328
      //   781: aload 6
      //   783: getfield 14	gnu/kawa/slib/pregexp$frame0:re$1	Ljava/lang/Object;
      //   786: invokestatic 161	kawa/lib/lists:isPair	(Ljava/lang/Object;)Z
      //   789: ifeq +1493 -> 2282
      //   792: aload 6
      //   794: getfield 14	gnu/kawa/slib/pregexp$frame0:re$1	Ljava/lang/Object;
      //   797: ldc -90
      //   799: invokestatic 120	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   802: dup
      //   803: astore 8
      //   805: checkcast 166	gnu/lists/Pair
      //   808: invokestatic 171	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
      //   811: astore 7
      //   813: aload 7
      //   815: invokevirtual 191	java/lang/Object:hashCode	()I
      //   818: lookupswitch	default:+1447->2265, -1676223608:+686->1504, -1649488850:+808->1626, -1373960256:+130->948, -880563283:+187->1005, -838680437:+1022->1840, -397368237:+1101->1919, -203333712:+487->1305, 59293:+273->1091, 1841637:+902->1720, 1842118:+765->1583, 684904690:+946->1764, 1002970408:+618->1436, 1406042867:+259->1077, 1951555794:+1232->2050, 2082117262:+312->1130
      //   948: aload 7
      //   950: getstatic 174	gnu/kawa/slib/pregexp:Lit48	Lgnu/mapping/SimpleSymbol;
      //   953: invokestatic 35	gnu/kawa/functions/IsEqv:apply	(Ljava/lang/Object;Ljava/lang/Object;)Z
      //   956: ifeq +1309 -> 2265
      //   959: aload 6
      //   961: getfield 17	gnu/kawa/slib/pregexp$frame0:i	Ljava/lang/Object;
      //   964: aload_0
      //   965: getfield 67	gnu/kawa/slib/pregexp$frame:n	Ljava/lang/Object;
      //   968: invokestatic 70	gnu/kawa/functions/NumberCompare:$Gr$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
      //   971: ifeq +17 -> 988
      //   974: getstatic 51	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
      //   977: aload 6
      //   979: getfield 23	gnu/kawa/slib/pregexp$frame0:fk	Ljava/lang/Object;
      //   982: invokevirtual 61	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
      //   985: goto +1343 -> 2328
      //   988: iconst_1
      //   989: anewarray 188	java/lang/Object
      //   992: dup
      //   993: iconst_0
      //   994: getstatic 194	gnu/kawa/slib/pregexp:Lit62	Lgnu/mapping/SimpleSymbol;
      //   997: aastore
      //   998: invokestatic 200	kawa/lib/exceptions:error	([Ljava/lang/Object;)Lgnu/bytecode/Type$NeverReturns;
      //   1001: getstatic 206	gnu/expr/Special:reachedUnexpected	Ljava/lang/RuntimeException;
      //   1004: athrow
      //   1005: aload 7
      //   1007: getstatic 209	gnu/kawa/slib/pregexp:Lit12	Lgnu/mapping/SimpleSymbol;
      //   1010: invokestatic 35	gnu/kawa/functions/IsEqv:apply	(Ljava/lang/Object;Ljava/lang/Object;)Z
      //   1013: ifeq +1252 -> 2265
      //   1016: aload 6
      //   1018: getfield 17	gnu/kawa/slib/pregexp$frame0:i	Ljava/lang/Object;
      //   1021: aload_0
      //   1022: getfield 67	gnu/kawa/slib/pregexp$frame:n	Ljava/lang/Object;
      //   1025: invokestatic 70	gnu/kawa/functions/NumberCompare:$Gr$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
      //   1028: ifeq +17 -> 1045
      //   1031: getstatic 51	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
      //   1034: aload 6
      //   1036: getfield 23	gnu/kawa/slib/pregexp$frame0:fk	Ljava/lang/Object;
      //   1039: invokevirtual 61	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
      //   1042: goto +1286 -> 2328
      //   1045: aload 6
      //   1047: getfield 14	gnu/kawa/slib/pregexp$frame0:re$1	Ljava/lang/Object;
      //   1050: invokestatic 183	kawa/lib/lists:cadr	(Ljava/lang/Object;)Ljava/lang/Object;
      //   1053: aload 6
      //   1055: getfield 17	gnu/kawa/slib/pregexp$frame0:i	Ljava/lang/Object;
      //   1058: aload 6
      //   1060: getfield 212	gnu/kawa/slib/pregexp$frame0:lambda$Fn2	Lgnu/expr/ModuleMethod;
      //   1063: aload 6
      //   1065: getfield 215	gnu/kawa/slib/pregexp$frame0:lambda$Fn3	Lgnu/expr/ModuleMethod;
      //   1068: astore 5
      //   1070: astore 4
      //   1072: astore_3
      //   1073: astore_2
      //   1074: goto -1074 -> 0
      //   1077: aload 7
      //   1079: getstatic 218	gnu/kawa/slib/pregexp:Lit31	Lgnu/mapping/SimpleSymbol;
      //   1082: invokestatic 35	gnu/kawa/functions/IsEqv:apply	(Ljava/lang/Object;Ljava/lang/Object;)Z
      //   1085: ifeq +1180 -> 2265
      //   1088: goto +549 -> 1637
      //   1091: aload 7
      //   1093: getstatic 221	gnu/kawa/slib/pregexp:Lit1	Lgnu/mapping/SimpleSymbol;
      //   1096: invokestatic 35	gnu/kawa/functions/IsEqv:apply	(Ljava/lang/Object;Ljava/lang/Object;)Z
      //   1099: ifeq +1166 -> 2265
      //   1102: aload 6
      //   1104: aload_1
      //   1105: aload 6
      //   1107: getfield 14	gnu/kawa/slib/pregexp$frame0:re$1	Ljava/lang/Object;
      //   1110: ldc -90
      //   1112: invokestatic 120	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   1115: dup
      //   1116: astore 8
      //   1118: checkcast 166	gnu/lists/Pair
      //   1121: invokestatic 225	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
      //   1124: invokevirtual 228	gnu/kawa/slib/pregexp$frame0:lambda7loupOr	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   1127: goto +1201 -> 2328
      //   1130: aload 7
      //   1132: getstatic 231	gnu/kawa/slib/pregexp:Lit35	Lgnu/mapping/SimpleSymbol;
      //   1135: invokestatic 35	gnu/kawa/functions/IsEqv:apply	(Ljava/lang/Object;Ljava/lang/Object;)Z
      //   1138: ifeq +1127 -> 2265
      //   1141: aload 6
      //   1143: getfield 14	gnu/kawa/slib/pregexp$frame0:re$1	Ljava/lang/Object;
      //   1146: invokestatic 183	kawa/lib/lists:cadr	(Ljava/lang/Object;)Ljava/lang/Object;
      //   1149: invokestatic 103	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
      //   1152: ifeq +7 -> 1159
      //   1155: iconst_0
      //   1156: goto +4 -> 1160
      //   1159: iconst_1
      //   1160: aload 6
      //   1162: swap
      //   1163: putfield 235	gnu/kawa/slib/pregexp$frame0:maximal$Qu	Z
      //   1166: aload 6
      //   1168: getfield 14	gnu/kawa/slib/pregexp$frame0:re$1	Ljava/lang/Object;
      //   1171: invokestatic 186	kawa/lib/lists:caddr	(Ljava/lang/Object;)Ljava/lang/Object;
      //   1174: aload 6
      //   1176: swap
      //   1177: putfield 238	gnu/kawa/slib/pregexp$frame0:p	Ljava/lang/Object;
      //   1180: aload 6
      //   1182: getfield 14	gnu/kawa/slib/pregexp$frame0:re$1	Ljava/lang/Object;
      //   1185: invokestatic 241	kawa/lib/lists:cadddr	(Ljava/lang/Object;)Ljava/lang/Object;
      //   1188: aload 6
      //   1190: swap
      //   1191: putfield 244	gnu/kawa/slib/pregexp$frame0:q	Ljava/lang/Object;
      //   1194: aload 6
      //   1196: getfield 235	gnu/kawa/slib/pregexp$frame0:maximal$Qu	Z
      //   1199: ifeq +22 -> 1221
      //   1202: aload 6
      //   1204: getfield 244	gnu/kawa/slib/pregexp$frame0:q	Ljava/lang/Object;
      //   1207: invokestatic 103	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
      //   1210: ifeq +7 -> 1217
      //   1213: iconst_0
      //   1214: goto +8 -> 1222
      //   1217: iconst_1
      //   1218: goto +4 -> 1222
      //   1221: iconst_0
      //   1222: aload 6
      //   1224: swap
      //   1225: putfield 247	gnu/kawa/slib/pregexp$frame0:could$Mnloop$Mninfinitely$Qu	Z
      //   1228: aload 6
      //   1230: getfield 14	gnu/kawa/slib/pregexp$frame0:re$1	Ljava/lang/Object;
      //   1233: invokestatic 250	kawa/lib/lists:cddddr	(Ljava/lang/Object;)Ljava/lang/Object;
      //   1236: ldc -90
      //   1238: invokestatic 120	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   1241: dup
      //   1242: astore 8
      //   1244: checkcast 166	gnu/lists/Pair
      //   1247: invokestatic 171	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
      //   1250: aload 6
      //   1252: swap
      //   1253: putfield 253	gnu/kawa/slib/pregexp$frame0:re	Ljava/lang/Object;
      //   1256: aload 6
      //   1258: aload 6
      //   1260: getfield 235	gnu/kawa/slib/pregexp$frame0:maximal$Qu	Z
      //   1263: ifeq +9 -> 1272
      //   1266: getstatic 259	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
      //   1269: goto +6 -> 1275
      //   1272: getstatic 262	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   1275: aload 6
      //   1277: getfield 244	gnu/kawa/slib/pregexp$frame0:q	Ljava/lang/Object;
      //   1280: aload 6
      //   1282: getfield 253	gnu/kawa/slib/pregexp$frame0:re	Ljava/lang/Object;
      //   1285: aload 6
      //   1287: getfield 238	gnu/kawa/slib/pregexp$frame0:p	Ljava/lang/Object;
      //   1290: aload_1
      //   1291: getstatic 265	gnu/kawa/slib/pregexp:Lit40	Lgnu/math/IntNum;
      //   1294: aload 6
      //   1296: getfield 17	gnu/kawa/slib/pregexp$frame0:i	Ljava/lang/Object;
      //   1299: invokevirtual 269	gnu/kawa/slib/pregexp$frame0:lambda8loupP	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Lgnu/math/IntNum;Ljava/lang/Object;)Ljava/lang/Object;
      //   1302: goto +1026 -> 2328
      //   1305: aload 7
      //   1307: getstatic 272	gnu/kawa/slib/pregexp:Lit63	Lgnu/mapping/SimpleSymbol;
      //   1310: invokestatic 35	gnu/kawa/functions/IsEqv:apply	(Ljava/lang/Object;Ljava/lang/Object;)Z
      //   1313: ifeq +952 -> 2265
      //   1316: aload_0
      //   1317: getfield 67	gnu/kawa/slib/pregexp$frame:n	Ljava/lang/Object;
      //   1320: astore 8
      //   1322: aload_0
      //   1323: getfield 275	gnu/kawa/slib/pregexp$frame:sn	Ljava/lang/Object;
      //   1326: astore 9
      //   1328: aload_0
      //   1329: aload 6
      //   1331: getfield 17	gnu/kawa/slib/pregexp$frame0:i	Ljava/lang/Object;
      //   1334: putfield 67	gnu/kawa/slib/pregexp$frame:n	Ljava/lang/Object;
      //   1337: aload_0
      //   1338: aload 6
      //   1340: getfield 17	gnu/kawa/slib/pregexp$frame0:i	Ljava/lang/Object;
      //   1343: putfield 275	gnu/kawa/slib/pregexp$frame:sn	Ljava/lang/Object;
      //   1346: aload_0
      //   1347: aload_1
      //   1348: getstatic 278	gnu/kawa/slib/pregexp:Lit2	Lgnu/mapping/SimpleSymbol;
      //   1351: getstatic 282	gnu/kawa/slib/pregexp:Lit64	Lgnu/lists/PairWithPosition;
      //   1354: aload 6
      //   1356: getfield 14	gnu/kawa/slib/pregexp$frame0:re$1	Ljava/lang/Object;
      //   1359: invokestatic 183	kawa/lib/lists:cadr	(Ljava/lang/Object;)Ljava/lang/Object;
      //   1362: getstatic 64	gnu/kawa/slib/pregexp:Lit4	Lgnu/mapping/SimpleSymbol;
      //   1365: invokestatic 288	gnu/lists/LList:list4	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
      //   1368: getstatic 265	gnu/kawa/slib/pregexp:Lit40	Lgnu/math/IntNum;
      //   1371: aload_0
      //   1372: getfield 292	gnu/kawa/slib/pregexp$frame:identity	Lgnu/mapping/Procedure;
      //   1375: getstatic 295	gnu/kawa/slib/pregexp:lambda$Fn4	Lgnu/expr/ModuleMethod;
      //   1378: invokevirtual 299	gnu/kawa/slib/pregexp$frame:lambda3sub	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   1381: astore 10
      //   1383: aload_0
      //   1384: aload 8
      //   1386: putfield 67	gnu/kawa/slib/pregexp$frame:n	Ljava/lang/Object;
      //   1389: aload_0
      //   1390: aload 9
      //   1392: putfield 275	gnu/kawa/slib/pregexp$frame:sn	Ljava/lang/Object;
      //   1395: aload 10
      //   1397: invokestatic 103	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
      //   1400: ifeq +17 -> 1417
      //   1403: getstatic 51	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
      //   1406: aload 6
      //   1408: getfield 23	gnu/kawa/slib/pregexp$frame0:fk	Ljava/lang/Object;
      //   1411: invokevirtual 61	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
      //   1414: goto +914 -> 2328
      //   1417: getstatic 51	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
      //   1420: aload 6
      //   1422: getfield 20	gnu/kawa/slib/pregexp$frame0:sk	Ljava/lang/Object;
      //   1425: aload 6
      //   1427: getfield 17	gnu/kawa/slib/pregexp$frame0:i	Ljava/lang/Object;
      //   1430: invokevirtual 57	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   1433: goto +895 -> 2328
      //   1436: aload 7
      //   1438: getstatic 302	gnu/kawa/slib/pregexp:Lit47	Lgnu/mapping/SimpleSymbol;
      //   1441: invokestatic 35	gnu/kawa/functions/IsEqv:apply	(Ljava/lang/Object;Ljava/lang/Object;)Z
      //   1444: ifeq +821 -> 2265
      //   1447: aload 6
      //   1449: getfield 17	gnu/kawa/slib/pregexp$frame0:i	Ljava/lang/Object;
      //   1452: aload_0
      //   1453: getfield 67	gnu/kawa/slib/pregexp$frame:n	Ljava/lang/Object;
      //   1456: invokestatic 70	gnu/kawa/functions/NumberCompare:$Gr$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
      //   1459: ifeq +17 -> 1476
      //   1462: getstatic 51	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
      //   1465: aload 6
      //   1467: getfield 23	gnu/kawa/slib/pregexp$frame0:fk	Ljava/lang/Object;
      //   1470: invokevirtual 61	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
      //   1473: goto +855 -> 2328
      //   1476: aload 6
      //   1478: aload_1
      //   1479: aload 6
      //   1481: getfield 14	gnu/kawa/slib/pregexp$frame0:re$1	Ljava/lang/Object;
      //   1484: ldc -90
      //   1486: invokestatic 120	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   1489: dup
      //   1490: astore 8
      //   1492: checkcast 166	gnu/lists/Pair
      //   1495: invokestatic 225	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
      //   1498: invokevirtual 305	gnu/kawa/slib/pregexp$frame0:lambda10loupOneOfChars	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   1501: goto +827 -> 2328
      //   1504: aload 7
      //   1506: getstatic 308	gnu/kawa/slib/pregexp:Lit65	Lgnu/mapping/SimpleSymbol;
      //   1509: invokestatic 35	gnu/kawa/functions/IsEqv:apply	(Ljava/lang/Object;Ljava/lang/Object;)Z
      //   1512: ifeq +753 -> 2265
      //   1515: aload_0
      //   1516: aload_1
      //   1517: aload 6
      //   1519: getfield 14	gnu/kawa/slib/pregexp$frame0:re$1	Ljava/lang/Object;
      //   1522: invokestatic 183	kawa/lib/lists:cadr	(Ljava/lang/Object;)Ljava/lang/Object;
      //   1525: aload 6
      //   1527: getfield 17	gnu/kawa/slib/pregexp$frame0:i	Ljava/lang/Object;
      //   1530: aload_0
      //   1531: getfield 292	gnu/kawa/slib/pregexp$frame:identity	Lgnu/mapping/Procedure;
      //   1534: getstatic 311	gnu/kawa/slib/pregexp:lambda$Fn5	Lgnu/expr/ModuleMethod;
      //   1537: invokevirtual 299	gnu/kawa/slib/pregexp$frame:lambda3sub	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   1540: astore 8
      //   1542: aload 8
      //   1544: invokestatic 103	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
      //   1547: ifeq +22 -> 1569
      //   1550: getstatic 51	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
      //   1553: aload 6
      //   1555: getfield 20	gnu/kawa/slib/pregexp$frame0:sk	Ljava/lang/Object;
      //   1558: aload 6
      //   1560: getfield 17	gnu/kawa/slib/pregexp$frame0:i	Ljava/lang/Object;
      //   1563: invokevirtual 57	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   1566: goto +762 -> 2328
      //   1569: getstatic 51	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
      //   1572: aload 6
      //   1574: getfield 23	gnu/kawa/slib/pregexp$frame0:fk	Ljava/lang/Object;
      //   1577: invokevirtual 61	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
      //   1580: goto +748 -> 2328
      //   1583: aload 7
      //   1585: getstatic 314	gnu/kawa/slib/pregexp:Lit61	Lgnu/mapping/SimpleSymbol;
      //   1588: invokestatic 35	gnu/kawa/functions/IsEqv:apply	(Ljava/lang/Object;Ljava/lang/Object;)Z
      //   1591: ifeq +674 -> 2265
      //   1594: aload 6
      //   1596: getfield 14	gnu/kawa/slib/pregexp$frame0:re$1	Ljava/lang/Object;
      //   1599: invokestatic 183	kawa/lib/lists:cadr	(Ljava/lang/Object;)Ljava/lang/Object;
      //   1602: aload 6
      //   1604: getfield 17	gnu/kawa/slib/pregexp$frame0:i	Ljava/lang/Object;
      //   1607: aload 6
      //   1609: getfield 317	gnu/kawa/slib/pregexp$frame0:lambda$Fn6	Lgnu/expr/ModuleMethod;
      //   1612: aload 6
      //   1614: getfield 23	gnu/kawa/slib/pregexp$frame0:fk	Ljava/lang/Object;
      //   1617: astore 5
      //   1619: astore 4
      //   1621: astore_3
      //   1622: astore_2
      //   1623: goto -1623 -> 0
      //   1626: aload 7
      //   1628: getstatic 320	gnu/kawa/slib/pregexp:Lit32	Lgnu/mapping/SimpleSymbol;
      //   1631: invokestatic 35	gnu/kawa/functions/IsEqv:apply	(Ljava/lang/Object;Ljava/lang/Object;)Z
      //   1634: ifeq +631 -> 2265
      //   1637: aload_0
      //   1638: getfield 98	gnu/kawa/slib/pregexp$frame:case$Mnsensitive$Qu	Ljava/lang/Object;
      //   1641: aload 6
      //   1643: swap
      //   1644: putfield 323	gnu/kawa/slib/pregexp$frame0:old	Ljava/lang/Object;
      //   1647: aload_0
      //   1648: aload 6
      //   1650: getfield 14	gnu/kawa/slib/pregexp$frame0:re$1	Ljava/lang/Object;
      //   1653: ldc -90
      //   1655: invokestatic 120	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   1658: dup
      //   1659: astore 8
      //   1661: checkcast 166	gnu/lists/Pair
      //   1664: invokestatic 171	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
      //   1667: getstatic 218	gnu/kawa/slib/pregexp:Lit31	Lgnu/mapping/SimpleSymbol;
      //   1670: invokestatic 35	gnu/kawa/functions/IsEqv:apply	(Ljava/lang/Object;Ljava/lang/Object;)Z
      //   1673: ifeq +9 -> 1682
      //   1676: getstatic 259	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
      //   1679: goto +6 -> 1685
      //   1682: getstatic 262	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   1685: putfield 98	gnu/kawa/slib/pregexp$frame:case$Mnsensitive$Qu	Ljava/lang/Object;
      //   1688: aload 6
      //   1690: getfield 14	gnu/kawa/slib/pregexp$frame0:re$1	Ljava/lang/Object;
      //   1693: invokestatic 183	kawa/lib/lists:cadr	(Ljava/lang/Object;)Ljava/lang/Object;
      //   1696: aload 6
      //   1698: getfield 17	gnu/kawa/slib/pregexp$frame0:i	Ljava/lang/Object;
      //   1701: aload 6
      //   1703: getfield 326	gnu/kawa/slib/pregexp$frame0:lambda$Fn7	Lgnu/expr/ModuleMethod;
      //   1706: aload 6
      //   1708: getfield 329	gnu/kawa/slib/pregexp$frame0:lambda$Fn8	Lgnu/expr/ModuleMethod;
      //   1711: astore 5
      //   1713: astore 4
      //   1715: astore_3
      //   1716: astore_2
      //   1717: goto -1717 -> 0
      //   1720: aload 7
      //   1722: getstatic 278	gnu/kawa/slib/pregexp:Lit2	Lgnu/mapping/SimpleSymbol;
      //   1725: invokestatic 35	gnu/kawa/functions/IsEqv:apply	(Ljava/lang/Object;Ljava/lang/Object;)Z
      //   1728: ifeq +537 -> 2265
      //   1731: aload 6
      //   1733: aload_1
      //   1734: aload 6
      //   1736: getfield 14	gnu/kawa/slib/pregexp$frame0:re$1	Ljava/lang/Object;
      //   1739: ldc -90
      //   1741: invokestatic 120	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   1744: dup
      //   1745: astore 8
      //   1747: checkcast 166	gnu/lists/Pair
      //   1750: invokestatic 225	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
      //   1753: aload 6
      //   1755: getfield 17	gnu/kawa/slib/pregexp$frame0:i	Ljava/lang/Object;
      //   1758: invokevirtual 333	gnu/kawa/slib/pregexp$frame0:lambda15loupSeq	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   1761: goto +567 -> 2328
      //   1764: aload 7
      //   1766: getstatic 336	gnu/kawa/slib/pregexp:Lit66	Lgnu/mapping/SimpleSymbol;
      //   1769: invokestatic 35	gnu/kawa/functions/IsEqv:apply	(Ljava/lang/Object;Ljava/lang/Object;)Z
      //   1772: ifeq +493 -> 2265
      //   1775: aload_0
      //   1776: aload_1
      //   1777: aload 6
      //   1779: getfield 14	gnu/kawa/slib/pregexp$frame0:re$1	Ljava/lang/Object;
      //   1782: invokestatic 183	kawa/lib/lists:cadr	(Ljava/lang/Object;)Ljava/lang/Object;
      //   1785: aload 6
      //   1787: getfield 17	gnu/kawa/slib/pregexp$frame0:i	Ljava/lang/Object;
      //   1790: aload_0
      //   1791: getfield 292	gnu/kawa/slib/pregexp$frame:identity	Lgnu/mapping/Procedure;
      //   1794: getstatic 339	gnu/kawa/slib/pregexp:lambda$Fn9	Lgnu/expr/ModuleMethod;
      //   1797: invokevirtual 299	gnu/kawa/slib/pregexp$frame:lambda3sub	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   1800: astore 8
      //   1802: aload 8
      //   1804: invokestatic 103	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
      //   1807: ifeq +19 -> 1826
      //   1810: getstatic 51	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
      //   1813: aload 6
      //   1815: getfield 20	gnu/kawa/slib/pregexp$frame0:sk	Ljava/lang/Object;
      //   1818: aload 8
      //   1820: invokevirtual 57	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   1823: goto +505 -> 2328
      //   1826: getstatic 51	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
      //   1829: aload 6
      //   1831: getfield 23	gnu/kawa/slib/pregexp$frame0:fk	Ljava/lang/Object;
      //   1834: invokevirtual 61	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
      //   1837: goto +491 -> 2328
      //   1840: aload 7
      //   1842: getstatic 342	gnu/kawa/slib/pregexp:Lit67	Lgnu/mapping/SimpleSymbol;
      //   1845: invokestatic 35	gnu/kawa/functions/IsEqv:apply	(Ljava/lang/Object;Ljava/lang/Object;)Z
      //   1848: ifeq +417 -> 2265
      //   1851: aload_0
      //   1852: aload_1
      //   1853: aload 6
      //   1855: getfield 14	gnu/kawa/slib/pregexp$frame0:re$1	Ljava/lang/Object;
      //   1858: invokestatic 183	kawa/lib/lists:cadr	(Ljava/lang/Object;)Ljava/lang/Object;
      //   1861: aload 6
      //   1863: getfield 17	gnu/kawa/slib/pregexp$frame0:i	Ljava/lang/Object;
      //   1866: aload_0
      //   1867: getfield 292	gnu/kawa/slib/pregexp$frame:identity	Lgnu/mapping/Procedure;
      //   1870: getstatic 345	gnu/kawa/slib/pregexp:lambda$Fn10	Lgnu/expr/ModuleMethod;
      //   1873: invokevirtual 299	gnu/kawa/slib/pregexp$frame:lambda3sub	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   1876: astore 8
      //   1878: aload 8
      //   1880: invokestatic 103	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
      //   1883: ifeq +17 -> 1900
      //   1886: getstatic 51	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
      //   1889: aload 6
      //   1891: getfield 23	gnu/kawa/slib/pregexp$frame0:fk	Ljava/lang/Object;
      //   1894: invokevirtual 61	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
      //   1897: goto +431 -> 2328
      //   1900: getstatic 51	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
      //   1903: aload 6
      //   1905: getfield 20	gnu/kawa/slib/pregexp$frame0:sk	Ljava/lang/Object;
      //   1908: aload 6
      //   1910: getfield 17	gnu/kawa/slib/pregexp$frame0:i	Ljava/lang/Object;
      //   1913: invokevirtual 57	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   1916: goto +412 -> 2328
      //   1919: aload 7
      //   1921: getstatic 348	gnu/kawa/slib/pregexp:Lit68	Lgnu/mapping/SimpleSymbol;
      //   1924: invokestatic 35	gnu/kawa/functions/IsEqv:apply	(Ljava/lang/Object;Ljava/lang/Object;)Z
      //   1927: ifeq +338 -> 2265
      //   1930: aload_0
      //   1931: getfield 67	gnu/kawa/slib/pregexp$frame:n	Ljava/lang/Object;
      //   1934: astore 8
      //   1936: aload_0
      //   1937: getfield 275	gnu/kawa/slib/pregexp$frame:sn	Ljava/lang/Object;
      //   1940: astore 9
      //   1942: aload_0
      //   1943: aload 6
      //   1945: getfield 17	gnu/kawa/slib/pregexp$frame0:i	Ljava/lang/Object;
      //   1948: putfield 67	gnu/kawa/slib/pregexp$frame:n	Ljava/lang/Object;
      //   1951: aload_0
      //   1952: aload 6
      //   1954: getfield 17	gnu/kawa/slib/pregexp$frame0:i	Ljava/lang/Object;
      //   1957: putfield 275	gnu/kawa/slib/pregexp$frame:sn	Ljava/lang/Object;
      //   1960: aload_0
      //   1961: aload_1
      //   1962: getstatic 278	gnu/kawa/slib/pregexp:Lit2	Lgnu/mapping/SimpleSymbol;
      //   1965: getstatic 282	gnu/kawa/slib/pregexp:Lit64	Lgnu/lists/PairWithPosition;
      //   1968: aload 6
      //   1970: getfield 14	gnu/kawa/slib/pregexp$frame0:re$1	Ljava/lang/Object;
      //   1973: invokestatic 183	kawa/lib/lists:cadr	(Ljava/lang/Object;)Ljava/lang/Object;
      //   1976: getstatic 64	gnu/kawa/slib/pregexp:Lit4	Lgnu/mapping/SimpleSymbol;
      //   1979: invokestatic 288	gnu/lists/LList:list4	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
      //   1982: getstatic 265	gnu/kawa/slib/pregexp:Lit40	Lgnu/math/IntNum;
      //   1985: aload_0
      //   1986: getfield 292	gnu/kawa/slib/pregexp$frame:identity	Lgnu/mapping/Procedure;
      //   1989: getstatic 351	gnu/kawa/slib/pregexp:lambda$Fn11	Lgnu/expr/ModuleMethod;
      //   1992: invokevirtual 299	gnu/kawa/slib/pregexp$frame:lambda3sub	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   1995: astore 10
      //   1997: aload_0
      //   1998: aload 8
      //   2000: putfield 67	gnu/kawa/slib/pregexp$frame:n	Ljava/lang/Object;
      //   2003: aload_0
      //   2004: aload 9
      //   2006: putfield 275	gnu/kawa/slib/pregexp$frame:sn	Ljava/lang/Object;
      //   2009: aload 10
      //   2011: invokestatic 103	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
      //   2014: ifeq +22 -> 2036
      //   2017: getstatic 51	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
      //   2020: aload 6
      //   2022: getfield 20	gnu/kawa/slib/pregexp$frame0:sk	Ljava/lang/Object;
      //   2025: aload 6
      //   2027: getfield 17	gnu/kawa/slib/pregexp$frame0:i	Ljava/lang/Object;
      //   2030: invokevirtual 57	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   2033: goto +295 -> 2328
      //   2036: getstatic 51	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
      //   2039: aload 6
      //   2041: getfield 23	gnu/kawa/slib/pregexp$frame0:fk	Ljava/lang/Object;
      //   2044: invokevirtual 61	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
      //   2047: goto +281 -> 2328
      //   2050: aload 7
      //   2052: getstatic 354	gnu/kawa/slib/pregexp:Lit5	Lgnu/mapping/SimpleSymbol;
      //   2055: invokestatic 35	gnu/kawa/functions/IsEqv:apply	(Ljava/lang/Object;Ljava/lang/Object;)Z
      //   2058: ifeq +207 -> 2265
      //   2061: aload_1
      //   2062: aload 6
      //   2064: getfield 14	gnu/kawa/slib/pregexp$frame0:re$1	Ljava/lang/Object;
      //   2067: invokestatic 183	kawa/lib/lists:cadr	(Ljava/lang/Object;)Ljava/lang/Object;
      //   2070: invokestatic 357	gnu/kawa/slib/pregexp:pregexpListRef	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   2073: astore 8
      //   2075: aload 8
      //   2077: invokestatic 103	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
      //   2080: ifeq +22 -> 2102
      //   2083: aload 8
      //   2085: ldc -90
      //   2087: invokestatic 120	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   2090: dup
      //   2091: astore 10
      //   2093: checkcast 166	gnu/lists/Pair
      //   2096: invokestatic 225	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
      //   2099: goto +34 -> 2133
      //   2102: iconst_3
      //   2103: anewarray 188	java/lang/Object
      //   2106: dup
      //   2107: iconst_0
      //   2108: getstatic 194	gnu/kawa/slib/pregexp:Lit62	Lgnu/mapping/SimpleSymbol;
      //   2111: aastore
      //   2112: dup
      //   2113: iconst_1
      //   2114: getstatic 360	gnu/kawa/slib/pregexp:Lit69	Lgnu/mapping/SimpleSymbol;
      //   2117: aastore
      //   2118: dup
      //   2119: iconst_2
      //   2120: aload 6
      //   2122: getfield 14	gnu/kawa/slib/pregexp$frame0:re$1	Ljava/lang/Object;
      //   2125: aastore
      //   2126: invokestatic 200	kawa/lib/exceptions:error	([Ljava/lang/Object;)Lgnu/bytecode/Type$NeverReturns;
      //   2129: getstatic 206	gnu/expr/Special:reachedUnexpected	Ljava/lang/RuntimeException;
      //   2132: athrow
      //   2133: astore 9
      //   2135: aload 9
      //   2137: invokestatic 103	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
      //   2140: ifeq +106 -> 2246
      //   2143: aload_0
      //   2144: getfield 79	gnu/kawa/slib/pregexp$frame:s	Ljava/lang/Object;
      //   2147: ldc 114
      //   2149: invokestatic 120	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   2152: dup
      //   2153: astore 10
      //   2155: checkcast 114	java/lang/CharSequence
      //   2158: aload 9
      //   2160: ldc -90
      //   2162: invokestatic 120	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   2165: dup
      //   2166: astore 10
      //   2168: checkcast 166	gnu/lists/Pair
      //   2171: invokestatic 171	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
      //   2174: invokestatic 131	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
      //   2177: dup
      //   2178: astore 10
      //   2180: checkcast 133	java/lang/Number
      //   2183: invokevirtual 137	java/lang/Number:intValue	()I
      //   2186: aload 9
      //   2188: ldc -90
      //   2190: invokestatic 120	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   2193: dup
      //   2194: astore 10
      //   2196: checkcast 166	gnu/lists/Pair
      //   2199: invokestatic 225	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
      //   2202: invokestatic 131	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
      //   2205: dup
      //   2206: astore 10
      //   2208: checkcast 133	java/lang/Number
      //   2211: invokevirtual 137	java/lang/Number:intValue	()I
      //   2214: invokestatic 365	kawa/lib/strings:substring	(Ljava/lang/CharSequence;II)Ljava/lang/CharSequence;
      //   2217: aload_0
      //   2218: getfield 79	gnu/kawa/slib/pregexp$frame:s	Ljava/lang/Object;
      //   2221: aload 6
      //   2223: getfield 17	gnu/kawa/slib/pregexp$frame0:i	Ljava/lang/Object;
      //   2226: aload_0
      //   2227: getfield 67	gnu/kawa/slib/pregexp$frame:n	Ljava/lang/Object;
      //   2230: aload 6
      //   2232: getfield 368	gnu/kawa/slib/pregexp$frame0:lambda$Fn12	Lgnu/expr/ModuleMethod;
      //   2235: aload 6
      //   2237: getfield 23	gnu/kawa/slib/pregexp$frame0:fk	Ljava/lang/Object;
      //   2240: invokestatic 372	gnu/kawa/slib/pregexp:pregexpStringMatch	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   2243: goto +85 -> 2328
      //   2246: getstatic 51	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
      //   2249: aload 6
      //   2251: getfield 20	gnu/kawa/slib/pregexp$frame0:sk	Ljava/lang/Object;
      //   2254: aload 6
      //   2256: getfield 17	gnu/kawa/slib/pregexp$frame0:i	Ljava/lang/Object;
      //   2259: invokevirtual 57	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   2262: goto +66 -> 2328
      //   2265: iconst_1
      //   2266: anewarray 188	java/lang/Object
      //   2269: dup
      //   2270: iconst_0
      //   2271: getstatic 194	gnu/kawa/slib/pregexp:Lit62	Lgnu/mapping/SimpleSymbol;
      //   2274: aastore
      //   2275: invokestatic 200	kawa/lib/exceptions:error	([Ljava/lang/Object;)Lgnu/bytecode/Type$NeverReturns;
      //   2278: getstatic 206	gnu/expr/Special:reachedUnexpected	Ljava/lang/RuntimeException;
      //   2281: athrow
      //   2282: aload 6
      //   2284: getfield 17	gnu/kawa/slib/pregexp$frame0:i	Ljava/lang/Object;
      //   2287: aload_0
      //   2288: getfield 67	gnu/kawa/slib/pregexp$frame:n	Ljava/lang/Object;
      //   2291: invokestatic 70	gnu/kawa/functions/NumberCompare:$Gr$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
      //   2294: ifeq +17 -> 2311
      //   2297: getstatic 51	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
      //   2300: aload 6
      //   2302: getfield 23	gnu/kawa/slib/pregexp$frame0:fk	Ljava/lang/Object;
      //   2305: invokevirtual 61	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
      //   2308: goto +20 -> 2328
      //   2311: iconst_1
      //   2312: anewarray 188	java/lang/Object
      //   2315: dup
      //   2316: iconst_0
      //   2317: getstatic 194	gnu/kawa/slib/pregexp:Lit62	Lgnu/mapping/SimpleSymbol;
      //   2320: aastore
      //   2321: invokestatic 200	kawa/lib/exceptions:error	([Ljava/lang/Object;)Lgnu/bytecode/Type$NeverReturns;
      //   2324: getstatic 206	gnu/expr/Special:reachedUnexpected	Ljava/lang/RuntimeException;
      //   2327: athrow
      //   2328: areturn
      //   2329: new 124	gnu/mapping/WrongType
      //   2332: dup_x1
      //   2333: swap
      //   2334: ldc 126
      //   2336: iconst_1
      //   2337: aload 7
      //   2339: invokespecial 129	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   2342: athrow
      //   2343: new 124	gnu/mapping/WrongType
      //   2346: dup_x1
      //   2347: swap
      //   2348: ldc 126
      //   2350: iconst_2
      //   2351: aload 7
      //   2353: invokespecial 129	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   2356: athrow
      //   2357: new 124	gnu/mapping/WrongType
      //   2360: dup_x1
      //   2361: swap
      //   2362: ldc 126
      //   2364: iconst_1
      //   2365: aload 7
      //   2367: invokespecial 129	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   2370: athrow
      //   2371: new 124	gnu/mapping/WrongType
      //   2374: dup_x1
      //   2375: swap
      //   2376: ldc 126
      //   2378: iconst_2
      //   2379: aload 7
      //   2381: invokespecial 129	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   2384: athrow
      //   2385: new 124	gnu/mapping/WrongType
      //   2388: dup_x1
      //   2389: swap
      //   2390: ldc -88
      //   2392: iconst_1
      //   2393: aload 7
      //   2395: invokespecial 129	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   2398: athrow
      //   2399: new 124	gnu/mapping/WrongType
      //   2402: dup_x1
      //   2403: swap
      //   2404: ldc 126
      //   2406: iconst_1
      //   2407: aload 8
      //   2409: invokespecial 129	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   2412: athrow
      //   2413: new 124	gnu/mapping/WrongType
      //   2416: dup_x1
      //   2417: swap
      //   2418: ldc 126
      //   2420: iconst_2
      //   2421: aload 8
      //   2423: invokespecial 129	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   2426: athrow
      //   2427: new 124	gnu/mapping/WrongType
      //   2430: dup_x1
      //   2431: swap
      //   2432: ldc -88
      //   2434: iconst_1
      //   2435: aload 8
      //   2437: invokespecial 129	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   2440: athrow
      //   2441: new 124	gnu/mapping/WrongType
      //   2444: dup_x1
      //   2445: swap
      //   2446: ldc -33
      //   2448: iconst_1
      //   2449: aload 8
      //   2451: invokespecial 129	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   2454: athrow
      //   2455: new 124	gnu/mapping/WrongType
      //   2458: dup_x1
      //   2459: swap
      //   2460: ldc -88
      //   2462: iconst_1
      //   2463: aload 8
      //   2465: invokespecial 129	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   2468: athrow
      //   2469: new 124	gnu/mapping/WrongType
      //   2472: dup_x1
      //   2473: swap
      //   2474: ldc -33
      //   2476: iconst_1
      //   2477: aload 8
      //   2479: invokespecial 129	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   2482: athrow
      //   2483: new 124	gnu/mapping/WrongType
      //   2486: dup_x1
      //   2487: swap
      //   2488: ldc -88
      //   2490: iconst_1
      //   2491: aload 8
      //   2493: invokespecial 129	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   2496: athrow
      //   2497: new 124	gnu/mapping/WrongType
      //   2500: dup_x1
      //   2501: swap
      //   2502: ldc -33
      //   2504: iconst_1
      //   2505: aload 8
      //   2507: invokespecial 129	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   2510: athrow
      //   2511: new 124	gnu/mapping/WrongType
      //   2514: dup_x1
      //   2515: swap
      //   2516: ldc -33
      //   2518: iconst_1
      //   2519: aload 10
      //   2521: invokespecial 129	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   2524: athrow
      //   2525: new 124	gnu/mapping/WrongType
      //   2528: dup_x1
      //   2529: swap
      //   2530: ldc_w 362
      //   2533: iconst_1
      //   2534: aload 10
      //   2536: invokespecial 129	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   2539: athrow
      //   2540: new 124	gnu/mapping/WrongType
      //   2543: dup_x1
      //   2544: swap
      //   2545: ldc -88
      //   2547: iconst_1
      //   2548: aload 10
      //   2550: invokespecial 129	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   2553: athrow
      //   2554: new 124	gnu/mapping/WrongType
      //   2557: dup_x1
      //   2558: swap
      //   2559: ldc_w 362
      //   2562: iconst_2
      //   2563: aload 10
      //   2565: invokespecial 129	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   2568: athrow
      //   2569: new 124	gnu/mapping/WrongType
      //   2572: dup_x1
      //   2573: swap
      //   2574: ldc -33
      //   2576: iconst_1
      //   2577: aload 10
      //   2579: invokespecial 129	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   2582: athrow
      //   2583: new 124	gnu/mapping/WrongType
      //   2586: dup_x1
      //   2587: swap
      //   2588: ldc_w 362
      //   2591: iconst_3
      //   2592: aload 10
      //   2594: invokespecial 129	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   2597: athrow
      // Line number table:
      //   Java source line #470	-> byte code offset #40
      //   Java source line #472	-> byte code offset #54
      //   Java source line #474	-> byte code offset #102
      //   Java source line #476	-> byte code offset #116
      //   Java source line #478	-> byte code offset #164
      //   Java source line #479	-> byte code offset #178
      //   Java source line #480	-> byte code offset #197
      //   Java source line #481	-> byte code offset #211
      //   Java source line #482	-> byte code offset #230
      //   Java source line #483	-> byte code offset #249
      //   Java source line #484	-> byte code offset #263
      //   Java source line #485	-> byte code offset #277
      //   Java source line #486	-> byte code offset #296
      //   Java source line #487	-> byte code offset #310
      //   Java source line #488	-> byte code offset #329
      //   Java source line #490	-> byte code offset #355
      //   Java source line #491	-> byte code offset #374
      //   Java source line #492	-> byte code offset #426
      //   Java source line #493	-> byte code offset #466
      //   Java source line #494	-> byte code offset #492
      //   Java source line #495	-> byte code offset #492
      //   Java source line #496	-> byte code offset #541
      //   Java source line #497	-> byte code offset #581
      //   Java source line #498	-> byte code offset #635
      //   Java source line #499	-> byte code offset #672
      //   Java source line #500	-> byte code offset #695
      //   Java source line #501	-> byte code offset #717
      //   Java source line #502	-> byte code offset #741
      //   Java source line #503	-> byte code offset #781
      //   Java source line #504	-> byte code offset #792
      //   Java source line #506	-> byte code offset #959
      //   Java source line #507	-> byte code offset #988
      //   Java source line #516	-> byte code offset #1016
      //   Java source line #517	-> byte code offset #1045
      //   Java source line #518	-> byte code offset #1058
      //   Java source line #519	-> byte code offset #1063
      //   Java source line #528	-> byte code offset #1102
      //   Java source line #598	-> byte code offset #1141
      //   Java source line #599	-> byte code offset #1166
      //   Java source line #598	-> byte code offset #1180
      //   Java source line #600	-> byte code offset #1180
      //   Java source line #598	-> byte code offset #1194
      //   Java source line #601	-> byte code offset #1194
      //   Java source line #598	-> byte code offset #1228
      //   Java source line #602	-> byte code offset #1228
      //   Java source line #603	-> byte code offset #1256
      //   Java source line #572	-> byte code offset #1316
      //   Java source line #573	-> byte code offset #1328
      //   Java source line #574	-> byte code offset #1346
      //   Java source line #575	-> byte code offset #1346
      //   Java source line #576	-> byte code offset #1354
      //   Java source line #577	-> byte code offset #1371
      //   Java source line #578	-> byte code offset #1383
      //   Java source line #579	-> byte code offset #1395
      //   Java source line #509	-> byte code offset #1447
      //   Java source line #510	-> byte code offset #1476
      //   Java source line #554	-> byte code offset #1515
      //   Java source line #555	-> byte code offset #1530
      //   Java source line #556	-> byte code offset #1542
      //   Java source line #548	-> byte code offset #1594
      //   Java source line #549	-> byte code offset #1607
      //   Java source line #551	-> byte code offset #1612
      //   Java source line #587	-> byte code offset #1637
      //   Java source line #588	-> byte code offset #1647
      //   Java source line #589	-> byte code offset #1648
      //   Java source line #590	-> byte code offset #1688
      //   Java source line #591	-> byte code offset #1701
      //   Java source line #594	-> byte code offset #1706
      //   Java source line #521	-> byte code offset #1731
      //   Java source line #581	-> byte code offset #1775
      //   Java source line #582	-> byte code offset #1790
      //   Java source line #583	-> byte code offset #1802
      //   Java source line #584	-> byte code offset #1810
      //   Java source line #585	-> byte code offset #1826
      //   Java source line #559	-> byte code offset #1851
      //   Java source line #560	-> byte code offset #1866
      //   Java source line #561	-> byte code offset #1878
      //   Java source line #563	-> byte code offset #1930
      //   Java source line #564	-> byte code offset #1942
      //   Java source line #565	-> byte code offset #1960
      //   Java source line #566	-> byte code offset #1960
      //   Java source line #567	-> byte code offset #1968
      //   Java source line #568	-> byte code offset #1985
      //   Java source line #569	-> byte code offset #1997
      //   Java source line #570	-> byte code offset #2009
      //   Java source line #536	-> byte code offset #2061
      //   Java source line #538	-> byte code offset #2075
      //   Java source line #540	-> byte code offset #2102
      //   Java source line #542	-> byte code offset #2135
      //   Java source line #543	-> byte code offset #2143
      //   Java source line #544	-> byte code offset #2143
      //   Java source line #545	-> byte code offset #2217
      //   Java source line #546	-> byte code offset #2246
      //   Java source line #636	-> byte code offset #2282
      //   Java source line #637	-> byte code offset #2311
      //   Java source line #491	-> byte code offset #2329
      //   Java source line #495	-> byte code offset #2357
      //   Java source line #497	-> byte code offset #2385
      //   Java source line #498	-> byte code offset #2399
      //   Java source line #504	-> byte code offset #2427
      //   Java source line #528	-> byte code offset #2441
      //   Java source line #602	-> byte code offset #2455
      //   Java source line #510	-> byte code offset #2469
      //   Java source line #589	-> byte code offset #2483
      //   Java source line #521	-> byte code offset #2497
      //   Java source line #538	-> byte code offset #2511
      //   Java source line #544	-> byte code offset #2525
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	2329	0	this	frame
      //   0	2328	1	backrefs	Object
      //   0	2328	2	re	Object
      //   0	2328	3	i	Object
      //   0	2328	4	sk	Object
      //   0	2328	5	fk	Object
      //   12	2289	6	$heapFrame	pregexp.frame0
      //   384	220	7	localObject1	Object
      //   670	50	7	c	int
      //   811	1583	7	tmp	Object
      //   645	15	8	localObject2	Object
      //   691	630	8	c$Ls	Object
      //   1328	163	8	n$Mnactual	Object
      //   1540	206	8	found$Mnit$Qu	Object
      //   1800	19	8	found$Mnit$Qu	Object
      //   1876	59	8	found$Mnit$Qu	Object
      //   1942	57	8	n$Mnactual	Object
      //   2073	433	8	c	Object
      //   1326	65	9	sn$Mnactual	Object
      //   1940	65	9	sn$Mnactual	Object
      //   2133	54	9	backref	Object
      //   1381	15	10	found$Mnit$Qu	Object
      //   1995	598	10	found$Mnit$Qu	Object
      //   2329	1	23	localClassCastException1	ClassCastException
      //   2343	1	24	localClassCastException2	ClassCastException
      //   2357	1	25	localClassCastException3	ClassCastException
      //   2371	1	26	localClassCastException4	ClassCastException
      //   2385	1	27	localClassCastException5	ClassCastException
      //   2399	1	28	localClassCastException6	ClassCastException
      //   2413	1	29	localClassCastException7	ClassCastException
      //   2427	1	30	localClassCastException8	ClassCastException
      //   2441	1	31	localClassCastException9	ClassCastException
      //   2455	1	32	localClassCastException10	ClassCastException
      //   2469	1	33	localClassCastException11	ClassCastException
      //   2483	1	34	localClassCastException12	ClassCastException
      //   2497	1	35	localClassCastException13	ClassCastException
      //   2511	1	36	localClassCastException14	ClassCastException
      //   2525	1	37	localClassCastException15	ClassCastException
      //   2540	1	38	localClassCastException16	ClassCastException
      //   2554	1	39	localClassCastException17	ClassCastException
      //   2569	1	40	localClassCastException18	ClassCastException
      //   2583	1	41	localClassCastException19	ClassCastException
      // Exception table:
      //   from	to	target	type
      //   386	389	2329	java/lang/ClassCastException
      //   400	406	2343	java/lang/ClassCastException
      //   504	507	2357	java/lang/ClassCastException
      //   518	524	2371	java/lang/ClassCastException
      //   605	608	2385	java/lang/ClassCastException
      //   647	650	2399	java/lang/ClassCastException
      //   661	667	2413	java/lang/ClassCastException
      //   805	808	2427	java/lang/ClassCastException
      //   1118	1121	2441	java/lang/ClassCastException
      //   1244	1247	2455	java/lang/ClassCastException
      //   1492	1495	2469	java/lang/ClassCastException
      //   1661	1664	2483	java/lang/ClassCastException
      //   1747	1750	2497	java/lang/ClassCastException
      //   2093	2096	2511	java/lang/ClassCastException
      //   2155	2158	2525	java/lang/ClassCastException
      //   2168	2171	2540	java/lang/ClassCastException
      //   2180	2186	2554	java/lang/ClassCastException
      //   2196	2199	2569	java/lang/ClassCastException
      //   2208	2214	2583	java/lang/ClassCastException
    }
    
    public void apply(CallContext paramCallContext)
    {
      ModuleMethod.applyError();
    }
  }
  
  public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
  {
    switch (selector) {case 40:  proc = paramModuleMethod;pc = 0;return 0;
    case 39: 
      proc = paramModuleMethod;pc = 0;return 0;
    



















    case 38: 
      proc = paramModuleMethod;pc = 0;return 0;
    case 37: 
      proc = paramModuleMethod;pc = 0;return 0;
    



















    case 36: 
      proc = paramModuleMethod;pc = 0;return 0;
    case 35: 
      proc = paramModuleMethod;pc = 0;return 0; } return super.match0(paramModuleMethod, paramCallContext); } public Object apply0(ModuleMethod paramModuleMethod) { switch (selector) {case 35:  return frame.lambda4() ? Boolean.TRUE : Boolean.FALSE;
    










































































































    case 36: 
      return frame0.lambda9() ? Boolean.TRUE : Boolean.FALSE;
    case 37: 
      return frame0.lambda11() ? Boolean.TRUE : Boolean.FALSE;
    
























    case 38: 
      return frame0.lambda16() ? Boolean.TRUE : Boolean.FALSE;
    case 39: 
      return frame0.lambda17() ? Boolean.TRUE : Boolean.FALSE;
    





    case 40: 
      return frame0.lambda18() ? Boolean.TRUE : Boolean.FALSE; } return super.apply0(paramModuleMethod);
  }
  
  public class frame0
    extends ModuleBody
  {
    boolean maximal$Qu;
    Object q;
    boolean could$Mnloop$Mninfinitely$Qu;
    Object re;
    Object p;
    Object old;
    @SourceName(name="re")
    Object re$1;
    Object sk;
    Object i;
    Object fk;
    pregexp.frame staticLink;
    final ModuleMethod lambda$Fn2;
    final ModuleMethod lambda$Fn3;
    final ModuleMethod lambda$Fn6;
    final ModuleMethod lambda$Fn7;
    final ModuleMethod lambda$Fn8;
    final ModuleMethod lambda$Fn12;
    
    public Object lambda10loupOneOfChars(Object backrefs, Object chars)
    {
      void tmp7_4 = new pregexp.frame1();74staticLink = this;pregexp.frame1 $heapFrame = tmp7_4;chars = chars;
      try {
        return lists.isNull(chars) ? Scheme.applyToArgs.apply1(fk) : staticLink.lambda3sub(backrefs, lists.car((Pair)(localObject = Promise.force(chars, Pair.class))), i, sk, lambda$Fn13);
      }
      catch (ClassCastException localClassCastException)
      {
        Object localObject;
        throw new WrongType(
          localClassCastException, "car", 1, localObject);
      }
    }
    
    Object lambda5(Object i1) {
      return Scheme.applyToArgs.apply1(fk);
    }
    






















    public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
    {
      switch (selector) {case 14:  value1 = paramObject;proc = paramModuleMethod;pc = 1;return 0;
      











































      case 12: 
        value1 = paramObject;proc = paramModuleMethod;pc = 1;return 0;
      case 11: 
        value1 = paramObject;proc = paramModuleMethod;pc = 1;return 0;
      case 9: 
        value1 = paramObject;proc = paramModuleMethod;pc = 1;return 0; } return super.match1(paramModuleMethod, paramObject, paramCallContext); }
    Object lambda6() { return Scheme.applyToArgs.apply2(sk, AddOp.apply2(1, i, pregexp.Lit3)); }
    







































































    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      switch (selector) {case 13:  proc = paramModuleMethod;pc = 0;return 0;
      case 10: 
        proc = paramModuleMethod;pc = 0;return 0; } return super.match0(paramModuleMethod, paramCallContext);
    }
    
    public Object lambda15loupSeq(Object backrefs, Object res, Object i) { void tmp7_4 = new pregexp.frame2();74staticLink = this;pregexp.frame2 $heapFrame = tmp7_4;res = res;
      
      try
      {
        return lists.isNull(res) ? Scheme.applyToArgs.apply2(sk, i) : staticLink.lambda3sub(backrefs, lists.car((Pair)(localObject = Promise.force(res, Pair.class))), i, lambda$Fn14, fk);
      }
      catch (ClassCastException localClassCastException)
      {
        Object localObject;
        throw new WrongType(
        

          localClassCastException, "car", 1, localObject);
      } }
    
    public Object lambda7loupOr(Object backrefs, Object res) { void tmp7_4 = new pregexp.frame3();74staticLink = this;pregexp.frame3 $heapFrame = tmp7_4;res = res;
      

      try
      {
        return lists.isNull(res) ? Scheme.applyToArgs.apply1(fk) : staticLink.lambda3sub(backrefs, lists.car((Pair)(localObject = Promise.force(res, Pair.class))), i, lambda$Fn15, lambda$Fn16);
      }
      catch (ClassCastException localClassCastException)
      {
        Object localObject;
        throw new WrongType(
        


          localClassCastException, "car", 1, localObject);
      }
    }
    





    Object lambda19(Object i)
    {
      return Scheme.applyToArgs.apply2(sk, i);
    }
    
    public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
    {
      switch (selector) {case 9:  return lambda5(paramObject);
      




























      case 11: 
        return lambda12(paramObject);
      







































      case 12: 
        return lambda13(paramObject);
      case 14: 
        return lambda19(paramObject); } return super.apply1(paramModuleMethod, paramObject);
    }
    
    Object lambda12(Object i1) {
      try {
        lists.setCdr$Ex((Pair)(localObject = Promise.force(lists.assv(re$1, staticLink.backrefs), Pair.class)), lists.cons(i, i1));
        return Scheme.applyToArgs.apply2(sk, i1);
      }
      catch (ClassCastException localClassCastException)
      {
        Object localObject;
        throw new WrongType(
          localClassCastException, "set-cdr!", 1, localObject);
      }
    }
    
    static boolean lambda11() { return false; }
    

    static boolean lambda17()
    {
      return false;
    }
    



    static boolean lambda18()
    {
      return false;
    }
    




    static boolean lambda9()
    {
      return false;
    }
    
    static boolean lambda16()
    {
      return false;
    }
    





    Object lambda13(Object i1)
    {
      staticLink.case$Mnsensitive$Qu = old;
      return Scheme.applyToArgs.apply2(sk, i1);
    }
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      switch (selector) {case 10:  return lambda6();
      








































































      case 13: 
        return lambda14(); } return super.apply0(paramModuleMethod); }
    Object lambda14() { staticLink.case$Mnsensitive$Qu = old;
      return Scheme.applyToArgs.apply1(fk);
    }
    



    public Object lambda8loupP(Object maximal$Qu, Object q, Object re, Object p, Object backrefs, IntNum k, Object i)
    {
      void tmp7_4 = new pregexp.frame4();74staticLink = this;pregexp.frame4 $heapFrame = tmp7_4;k = k;i = i;
      








      q = (KawaConvert.isTrue(q) ? AddOp.apply2(-1, q, p) : Boolean.FALSE);
      return NumberCompare.$Ls(k, p) ? staticLink.lambda3sub(backrefs, re, i, lambda$Fn17, fk) : $heapFrame.lambda25loupQ(re, maximal$Qu, q, backrefs, pregexp.Lit40, i);
    }
    




    public frame0()
    {
      void tmp19_16 = new ModuleMethod(this, 9, null, 4097);
      tmp19_16.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm:518");
      lambda$Fn2 = tmp19_16;
      void tmp43_40 = new ModuleMethod(this, 10, null, 0);
      tmp43_40.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm:519");
      lambda$Fn3 = tmp43_40;
      void tmp69_66 = new ModuleMethod(this, 11, null, 4097);
      tmp69_66.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm:549");
      lambda$Fn6 = tmp69_66;
      void tmp95_92 = new ModuleMethod(this, 12, null, 4097);
      tmp95_92.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm:591");
      lambda$Fn7 = tmp95_92;
      void tmp119_116 = new ModuleMethod(this, 13, null, 0);
      tmp119_116.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm:594");
      lambda$Fn8 = tmp119_116;
      void tmp145_142 = new ModuleMethod(this, 14, null, 4097);
      tmp145_142.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm:545");
      lambda$Fn12 = tmp145_142;
    }
    




    public void apply(CallContext paramCallContext)
    {
      ModuleMethod.applyError();
    }
  }
  




  public int match4(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, CallContext paramCallContext)
  {
    if (selector == 42) { value1 = paramObject1;value2 = paramObject2;value3 = paramObject3;value4 = paramObject4;proc = paramModuleMethod;pc = 4;return 0; } return super.match4(paramModuleMethod, paramObject1, paramObject2, paramObject3, paramObject4, paramCallContext); } public Object apply4(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4) { if (selector == 42) return pregexpReplaceAux(paramObject1, paramObject2, paramObject3, paramObject4); return super.apply4(paramModuleMethod, paramObject1, paramObject2, paramObject3, paramObject4);
  }
  
  public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
  {
    switch (selector) {case 32:  return isPregexpCheckIfInCharClass(paramObject1, paramObject2) ? Boolean.TRUE : Boolean.FALSE;
    



























    case 33: 
      return pregexpListRef(paramObject1, paramObject2);
    











































































































































































































































































    case 46: 
      return pregexpSplit(paramObject1, paramObject2); } return super.apply2(paramModuleMethod, paramObject1, paramObject2);
  }
  
  public Object apply3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    switch (selector) {case 17:  return pregexpReadPattern(paramObject1, paramObject2, paramObject3);
    











    case 18: 
      return pregexpReadBranch(paramObject1, paramObject2, paramObject3);
    









    case 19: 
      return pregexpReadPiece(paramObject1, paramObject2, paramObject3);
    












































    case 20: 
      return pregexpReadEscapedNumber(paramObject1, paramObject2, paramObject3);
    














    case 21: 
      return pregexpReadEscapedChar(paramObject1, paramObject2, paramObject3);
    
















    case 22: 
      return pregexpReadPosixCharClass(paramObject1, paramObject2, paramObject3);
    























    case 23: 
      return pregexpReadClusterType(paramObject1, paramObject2, paramObject3);
    






























    case 24: 
      return pregexpReadSubpattern(paramObject1, paramObject2, paramObject3);
    


















    case 25: 
      return pregexpWrapQuantifierIfAny(paramObject1, paramObject2, paramObject3);
    











































    case 26: 
      return pregexpReadNums(paramObject1, paramObject2, paramObject3);
    



























    case 28: 
      return pregexpReadCharList(paramObject1, paramObject2, paramObject3);
    






















































    case 31: 
      return isPregexpAtWordBoundary(paramObject1, paramObject2, paramObject3) ? Boolean.TRUE : Boolean.FALSE;
    












































































































































































































































































































































    case 47: 
      return pregexpReplace(paramObject1, paramObject2, paramObject3);
    










    case 48: 
      return pregexpReplace$St(paramObject1, paramObject2, paramObject3); } return super.apply3(paramModuleMethod, paramObject1, paramObject2, paramObject3);
  }
  
  public static Object pregexpReplace$St(Object pat, Object str, Object ins) { Object localObject1 = strings.isString(pat) ? pregexp(pat) : pat;
    for (;;) { Object i; Object localObject4; try { Object localObject2; int i = strings.stringLength((CharSequence)(localObject2 = Promise.force(str, CharSequence.class))); } catch (ClassCastException localClassCastException1) { Object localObject3; int ins$Mnlen; int n; Object pat; String str; Object r; Object pp; throw new WrongType(
        



















          localClassCastException1, "string-length", 1, ins$Mnlen);
      }
      try
      {
        ins$Mnlen = strings.stringLength((CharSequence)(localObject3 = Promise.force(ins, CharSequence.class)));
        str = "";i = Lit40;
        


        pp = pregexpMatchPositions$V(pat, str, new Object[] { i, Integer.valueOf(n) });
        if (!KawaConvert.isTrue(pp))
        {







          localObject4 = Promise.force(str, CharSequence.class);
        }
      }
      catch (ClassCastException localClassCastException2)
      {
        throw new WrongType(localClassCastException2, "string-length", 1, i);
      }
      










      try
      {
        localObject4 = Promise.force(i); } catch (ClassCastException localClassCastException3) { throw new WrongType(localClassCastException3, "substring", 1, localObject4); } try { tmp134_129[1] = strings.substring((CharSequence)tmp142_139, ((Number)tmp153_150).intValue(), n);tmpTernaryOp = strings.stringAppend(tmp134_129); continue;
        


        localObject4 = Promise.force(str, CharSequence.class);
      }
      catch (ClassCastException localClassCastException4)
      {
        throw new WrongType(localClassCastException4, "substring", 2, localObject4);
      }
      try
      {
        localObject4 = Promise.force(i); } catch (ClassCastException localClassCastException5) { throw new WrongType(localClassCastException5, "substring", 1, localObject4); } try { localObject4 = Promise.force(lists.caar(pp)); } catch (ClassCastException localClassCastException6) { throw new WrongType(localClassCastException6, "substring", 2, localObject4); } try { tmp188_183[1] = strings.substring((CharSequence)tmp196_193, ((Number)tmp207_204).intValue(), ((Number)tmp224_221).intValue()); Object[] tmp237_188 = tmp188_183;tmp237_188[2] = 
          pregexpReplaceAux(str, ins, Integer.valueOf(ins$Mnlen), pp);tmpTernaryOp = strings.stringAppend(tmp237_188);
      }
      catch (ClassCastException localClassCastException7)
      {
        throw new WrongType(localClassCastException7, "substring", 3, localObject4); } }
    return lists.cdar(pp);
  }
  
  public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
  {
    switch (selector) {case 16:  return pregexpReverse$Ex(paramObject);
    






















































































































































































































































































    case 27: 
      return pregexpInvertCharList(paramObject);
    





















































    case 30: 
      return isPregexpCharWord(paramObject) ? Boolean.TRUE : Boolean.FALSE;
    


































































    case 34: 
      return pregexpMakeBackrefList(paramObject);
    





















































































































































































































    case 43: 
      return pregexp(paramObject);
    
































































































    case 49: 
      return pregexpQuote(paramObject); } return super.apply1(paramModuleMethod, paramObject);
  }
  
  /* Error */
  public static Object pregexpReadPattern(Object s, Object i, Object n)
  {
    // Byte code:
    //   0: aload_1
    //   1: aload_2
    //   2: invokestatic 96	gnu/kawa/functions/NumberCompare:$Gr$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   5: ifeq +22 -> 27
    //   8: getstatic 100	gnu/kawa/slib/pregexp:Lit1	Lgnu/mapping/SimpleSymbol;
    //   11: getstatic 103	gnu/kawa/slib/pregexp:Lit2	Lgnu/mapping/SimpleSymbol;
    //   14: invokestatic 107	gnu/lists/LList:list1	(Ljava/lang/Object;)Lgnu/lists/Pair;
    //   17: invokestatic 111	gnu/lists/LList:list2	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   20: aload_1
    //   21: invokestatic 111	gnu/lists/LList:list2	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   24: goto +166 -> 190
    //   27: getstatic 48	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
    //   30: aload_1
    //   31: astore 4
    //   33: astore_3
    //   34: aload 4
    //   36: aload_2
    //   37: invokestatic 96	gnu/kawa/functions/NumberCompare:$Gr$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   40: istore 5
    //   42: iload 5
    //   44: ifeq +11 -> 55
    //   47: iload 5
    //   49: ifeq +58 -> 107
    //   52: goto +37 -> 89
    //   55: aload_0
    //   56: ldc 113
    //   58: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   61: dup
    //   62: astore 6
    //   64: checkcast 113	java/lang/CharSequence
    //   67: aload 4
    //   69: invokestatic 118	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   72: dup
    //   73: astore 6
    //   75: checkcast 120	java/lang/Number
    //   78: invokevirtual 124	java/lang/Number:intValue	()I
    //   81: invokestatic 130	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)I
    //   84: bipush 41
    //   86: if_icmpne +21 -> 107
    //   89: getstatic 100	gnu/kawa/slib/pregexp:Lit1	Lgnu/mapping/SimpleSymbol;
    //   92: aload_3
    //   93: invokestatic 133	gnu/kawa/slib/pregexp:pregexpReverse$Ex	(Ljava/lang/Object;)Ljava/lang/Object;
    //   96: invokestatic 136	kawa/lib/lists:cons	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   99: aload 4
    //   101: invokestatic 111	gnu/lists/LList:list2	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   104: goto +86 -> 190
    //   107: aload_0
    //   108: aload_0
    //   109: ldc 113
    //   111: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   114: dup
    //   115: astore 7
    //   117: checkcast 113	java/lang/CharSequence
    //   120: aload 4
    //   122: invokestatic 118	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   125: dup
    //   126: astore 7
    //   128: checkcast 120	java/lang/Number
    //   131: invokevirtual 124	java/lang/Number:intValue	()I
    //   134: invokestatic 130	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)I
    //   137: bipush 124
    //   139: if_icmpne +15 -> 154
    //   142: iconst_1
    //   143: aload 4
    //   145: getstatic 139	gnu/kawa/slib/pregexp:Lit3	Lgnu/math/IntNum;
    //   148: invokestatic 145	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   151: goto +5 -> 156
    //   154: aload 4
    //   156: aload_2
    //   157: invokestatic 149	gnu/kawa/slib/pregexp:pregexpReadBranch	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   160: astore 6
    //   162: aload 6
    //   164: ldc 56
    //   166: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   169: dup
    //   170: astore 7
    //   172: checkcast 56	gnu/lists/Pair
    //   175: invokestatic 153	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   178: aload_3
    //   179: invokestatic 136	kawa/lib/lists:cons	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   182: aload 6
    //   184: invokestatic 156	kawa/lib/lists:cadr	(Ljava/lang/Object;)Ljava/lang/Object;
    //   187: goto -156 -> 31
    //   190: areturn
    //   191: new 66	gnu/mapping/WrongType
    //   194: dup_x1
    //   195: swap
    //   196: ldc 115
    //   198: iconst_1
    //   199: aload 6
    //   201: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   204: athrow
    //   205: new 66	gnu/mapping/WrongType
    //   208: dup_x1
    //   209: swap
    //   210: ldc 115
    //   212: iconst_2
    //   213: aload 6
    //   215: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   218: athrow
    //   219: new 66	gnu/mapping/WrongType
    //   222: dup_x1
    //   223: swap
    //   224: ldc 115
    //   226: iconst_1
    //   227: aload 7
    //   229: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   232: athrow
    //   233: new 66	gnu/mapping/WrongType
    //   236: dup_x1
    //   237: swap
    //   238: ldc 115
    //   240: iconst_2
    //   241: aload 7
    //   243: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   246: athrow
    //   247: new 66	gnu/mapping/WrongType
    //   250: dup_x1
    //   251: swap
    //   252: ldc -105
    //   254: iconst_1
    //   255: aload 7
    //   257: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   260: athrow
    // Line number table:
    //   Java source line #70	-> byte code offset #0
    //   Java source line #71	-> byte code offset #0
    //   Java source line #72	-> byte code offset #8
    //   Java source line #74	-> byte code offset #27
    //   Java source line #75	-> byte code offset #34
    //   Java source line #76	-> byte code offset #55
    //   Java source line #77	-> byte code offset #89
    //   Java source line #78	-> byte code offset #107
    //   Java source line #79	-> byte code offset #107
    //   Java source line #80	-> byte code offset #108
    //   Java source line #81	-> byte code offset #162
    //   Java source line #76	-> byte code offset #191
    //   Java source line #80	-> byte code offset #219
    //   Java source line #81	-> byte code offset #247
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	190	0	s	Object
    //   0	190	1	i	Object
    //   0	190	2	n	Object
    //   33	146	3	branches	Object
    //   31	1	4	localObject1	Object
    //   34	121	4	i	Object
    //   40	8	5	x	boolean
    //   62	12	6	localObject2	Object
    //   160	54	6	vv	Object
    //   115	141	7	localObject3	Object
    //   191	1	10	localClassCastException1	ClassCastException
    //   205	1	11	localClassCastException2	ClassCastException
    //   219	1	12	localClassCastException3	ClassCastException
    //   233	1	13	localClassCastException4	ClassCastException
    //   247	1	14	localClassCastException5	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   64	67	191	java/lang/ClassCastException
    //   75	81	205	java/lang/ClassCastException
    //   117	120	219	java/lang/ClassCastException
    //   128	134	233	java/lang/ClassCastException
    //   172	175	247	java/lang/ClassCastException
  }
  
  /* Error */
  public static Object pregexpReadBranch(Object s, Object i, Object n)
  {
    // Byte code:
    //   0: getstatic 48	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
    //   3: aload_1
    //   4: astore 4
    //   6: astore_3
    //   7: aload 4
    //   9: aload_2
    //   10: invokestatic 96	gnu/kawa/functions/NumberCompare:$Gr$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   13: ifeq +21 -> 34
    //   16: getstatic 103	gnu/kawa/slib/pregexp:Lit2	Lgnu/mapping/SimpleSymbol;
    //   19: aload_3
    //   20: invokestatic 133	gnu/kawa/slib/pregexp:pregexpReverse$Ex	(Ljava/lang/Object;)Ljava/lang/Object;
    //   23: invokestatic 136	kawa/lib/lists:cons	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   26: aload 4
    //   28: invokestatic 111	gnu/lists/LList:list2	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   31: goto +123 -> 154
    //   34: aload_0
    //   35: ldc 113
    //   37: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   40: dup
    //   41: astore 6
    //   43: checkcast 113	java/lang/CharSequence
    //   46: aload 4
    //   48: invokestatic 118	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   51: dup
    //   52: astore 6
    //   54: checkcast 120	java/lang/Number
    //   57: invokevirtual 124	java/lang/Number:intValue	()I
    //   60: invokestatic 130	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)I
    //   63: istore 5
    //   65: iload 5
    //   67: bipush 124
    //   69: if_icmpne +7 -> 76
    //   72: iconst_1
    //   73: goto +4 -> 77
    //   76: iconst_0
    //   77: istore 6
    //   79: iload 6
    //   81: ifeq +11 -> 92
    //   84: iload 6
    //   86: ifeq +31 -> 117
    //   89: goto +10 -> 99
    //   92: iload 5
    //   94: bipush 41
    //   96: if_icmpne +21 -> 117
    //   99: getstatic 103	gnu/kawa/slib/pregexp:Lit2	Lgnu/mapping/SimpleSymbol;
    //   102: aload_3
    //   103: invokestatic 133	gnu/kawa/slib/pregexp:pregexpReverse$Ex	(Ljava/lang/Object;)Ljava/lang/Object;
    //   106: invokestatic 136	kawa/lib/lists:cons	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   109: aload 4
    //   111: invokestatic 111	gnu/lists/LList:list2	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   114: goto +40 -> 154
    //   117: aload_0
    //   118: aload 4
    //   120: aload_2
    //   121: invokestatic 159	gnu/kawa/slib/pregexp:pregexpReadPiece	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   124: astore 7
    //   126: aload 7
    //   128: ldc 56
    //   130: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   133: dup
    //   134: astore 8
    //   136: checkcast 56	gnu/lists/Pair
    //   139: invokestatic 153	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   142: aload_3
    //   143: invokestatic 136	kawa/lib/lists:cons	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   146: aload 7
    //   148: invokestatic 156	kawa/lib/lists:cadr	(Ljava/lang/Object;)Ljava/lang/Object;
    //   151: goto -147 -> 4
    //   154: areturn
    //   155: new 66	gnu/mapping/WrongType
    //   158: dup_x1
    //   159: swap
    //   160: ldc 115
    //   162: iconst_1
    //   163: aload 6
    //   165: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   168: athrow
    //   169: new 66	gnu/mapping/WrongType
    //   172: dup_x1
    //   173: swap
    //   174: ldc 115
    //   176: iconst_2
    //   177: aload 6
    //   179: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   182: athrow
    //   183: new 66	gnu/mapping/WrongType
    //   186: dup_x1
    //   187: swap
    //   188: ldc -105
    //   190: iconst_1
    //   191: aload 8
    //   193: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   196: athrow
    // Line number table:
    //   Java source line #84	-> byte code offset #0
    //   Java source line #85	-> byte code offset #0
    //   Java source line #86	-> byte code offset #7
    //   Java source line #87	-> byte code offset #16
    //   Java source line #88	-> byte code offset #34
    //   Java source line #89	-> byte code offset #65
    //   Java source line #90	-> byte code offset #92
    //   Java source line #91	-> byte code offset #99
    //   Java source line #92	-> byte code offset #117
    //   Java source line #93	-> byte code offset #126
    //   Java source line #88	-> byte code offset #155
    //   Java source line #93	-> byte code offset #183
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	154	0	s	Object
    //   0	154	1	i	Object
    //   0	154	2	n	Object
    //   6	137	3	pieces	Object
    //   4	1	4	localObject1	Object
    //   7	112	4	i	Object
    //   63	30	5	c	int
    //   41	12	6	localObject2	Object
    //   77	101	6	x	boolean
    //   124	23	7	vv	Object
    //   134	58	8	localObject3	Object
    //   155	1	11	localClassCastException1	ClassCastException
    //   169	1	12	localClassCastException2	ClassCastException
    //   183	1	13	localClassCastException3	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   43	46	155	java/lang/ClassCastException
    //   54	60	169	java/lang/ClassCastException
    //   136	139	183	java/lang/ClassCastException
  }
  
  /* Error */
  public static Object pregexpReadPiece(Object s, Object i, Object n)
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc 113
    //   3: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   6: dup
    //   7: astore 4
    //   9: checkcast 113	java/lang/CharSequence
    //   12: aload_1
    //   13: invokestatic 118	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   16: dup
    //   17: astore 4
    //   19: checkcast 120	java/lang/Number
    //   22: invokevirtual 124	java/lang/Number:intValue	()I
    //   25: invokestatic 130	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)I
    //   28: istore_3
    //   29: iload_3
    //   30: lookupswitch	default:+407->437, 36:+58->88, 40:+198->228, 46:+236->266, 91:+258->288, 92:+75->105, 94:+219->249
    //   88: getstatic 162	gnu/kawa/slib/pregexp:Lit4	Lgnu/mapping/SimpleSymbol;
    //   91: iconst_1
    //   92: aload_1
    //   93: getstatic 139	gnu/kawa/slib/pregexp:Lit3	Lgnu/math/IntNum;
    //   96: invokestatic 145	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   99: invokestatic 111	gnu/lists/LList:list2	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   102: goto +546 -> 648
    //   105: aload_0
    //   106: aload_1
    //   107: aload_2
    //   108: invokestatic 165	gnu/kawa/slib/pregexp:pregexpReadEscapedNumber	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   111: astore 4
    //   113: aload 4
    //   115: invokestatic 170	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   118: ifeq +36 -> 154
    //   121: getstatic 173	gnu/kawa/slib/pregexp:Lit5	Lgnu/mapping/SimpleSymbol;
    //   124: aload 4
    //   126: ldc 56
    //   128: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   131: dup
    //   132: astore 5
    //   134: checkcast 56	gnu/lists/Pair
    //   137: invokestatic 153	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   140: invokestatic 111	gnu/lists/LList:list2	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   143: aload 4
    //   145: invokestatic 156	kawa/lib/lists:cadr	(Ljava/lang/Object;)Ljava/lang/Object;
    //   148: invokestatic 111	gnu/lists/LList:list2	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   151: goto +69 -> 220
    //   154: aload_0
    //   155: aload_1
    //   156: aload_2
    //   157: invokestatic 176	gnu/kawa/slib/pregexp:pregexpReadEscapedChar	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   160: astore 5
    //   162: aload 5
    //   164: invokestatic 170	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   167: ifeq +30 -> 197
    //   170: aload 5
    //   172: ldc 56
    //   174: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   177: dup
    //   178: astore 6
    //   180: checkcast 56	gnu/lists/Pair
    //   183: invokestatic 153	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   186: aload 5
    //   188: invokestatic 156	kawa/lib/lists:cadr	(Ljava/lang/Object;)Ljava/lang/Object;
    //   191: invokestatic 111	gnu/lists/LList:list2	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   194: goto +26 -> 220
    //   197: iconst_2
    //   198: anewarray 178	java/lang/Object
    //   201: dup
    //   202: iconst_0
    //   203: getstatic 181	gnu/kawa/slib/pregexp:Lit6	Lgnu/mapping/SimpleSymbol;
    //   206: aastore
    //   207: dup
    //   208: iconst_1
    //   209: getstatic 184	gnu/kawa/slib/pregexp:Lit7	Lgnu/mapping/SimpleSymbol;
    //   212: aastore
    //   213: invokestatic 187	kawa/lib/exceptions:error	([Ljava/lang/Object;)Lgnu/bytecode/Type$NeverReturns;
    //   216: getstatic 193	gnu/expr/Special:reachedUnexpected	Ljava/lang/RuntimeException;
    //   219: athrow
    //   220: aload_0
    //   221: aload_2
    //   222: invokestatic 196	gnu/kawa/slib/pregexp:pregexpWrapQuantifierIfAny	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   225: goto +423 -> 648
    //   228: aload_0
    //   229: iconst_1
    //   230: aload_1
    //   231: getstatic 139	gnu/kawa/slib/pregexp:Lit3	Lgnu/math/IntNum;
    //   234: invokestatic 145	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   237: aload_2
    //   238: invokestatic 199	gnu/kawa/slib/pregexp:pregexpReadSubpattern	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   241: aload_0
    //   242: aload_2
    //   243: invokestatic 196	gnu/kawa/slib/pregexp:pregexpWrapQuantifierIfAny	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   246: goto +402 -> 648
    //   249: getstatic 202	gnu/kawa/slib/pregexp:Lit8	Lgnu/mapping/SimpleSymbol;
    //   252: iconst_1
    //   253: aload_1
    //   254: getstatic 139	gnu/kawa/slib/pregexp:Lit3	Lgnu/math/IntNum;
    //   257: invokestatic 145	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   260: invokestatic 111	gnu/lists/LList:list2	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   263: goto +385 -> 648
    //   266: getstatic 205	gnu/kawa/slib/pregexp:Lit9	Lgnu/mapping/SimpleSymbol;
    //   269: iconst_1
    //   270: aload_1
    //   271: getstatic 139	gnu/kawa/slib/pregexp:Lit3	Lgnu/math/IntNum;
    //   274: invokestatic 145	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   277: invokestatic 111	gnu/lists/LList:list2	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   280: aload_0
    //   281: aload_2
    //   282: invokestatic 196	gnu/kawa/slib/pregexp:pregexpWrapQuantifierIfAny	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   285: goto +363 -> 648
    //   288: iconst_1
    //   289: aload_1
    //   290: getstatic 139	gnu/kawa/slib/pregexp:Lit3	Lgnu/math/IntNum;
    //   293: invokestatic 145	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   296: astore 4
    //   298: aload 4
    //   300: aload_2
    //   301: invokestatic 208	gnu/kawa/functions/NumberCompare:$Ls	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   304: ifeq +38 -> 342
    //   307: aload_0
    //   308: ldc 113
    //   310: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   313: dup
    //   314: astore 6
    //   316: checkcast 113	java/lang/CharSequence
    //   319: aload 4
    //   321: invokestatic 118	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   324: dup
    //   325: astore 6
    //   327: checkcast 120	java/lang/Number
    //   330: invokevirtual 124	java/lang/Number:intValue	()I
    //   333: invokestatic 130	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)I
    //   336: invokestatic 214	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   339: goto +6 -> 345
    //   342: getstatic 217	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   345: astore 5
    //   347: aload 5
    //   349: invokevirtual 220	java/lang/Object:hashCode	()I
    //   352: bipush 94
    //   354: if_icmpne +65 -> 419
    //   357: goto +3 -> 360
    //   360: aload 5
    //   362: getstatic 224	gnu/kawa/slib/pregexp:Lit10	Lgnu/text/Char;
    //   365: invokestatic 229	gnu/kawa/functions/IsEqv:apply	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   368: ifeq +51 -> 419
    //   371: aload_0
    //   372: iconst_1
    //   373: aload_1
    //   374: getstatic 232	gnu/kawa/slib/pregexp:Lit11	Lgnu/math/IntNum;
    //   377: invokestatic 145	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   380: aload_2
    //   381: invokestatic 235	gnu/kawa/slib/pregexp:pregexpReadCharList	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   384: astore 6
    //   386: getstatic 238	gnu/kawa/slib/pregexp:Lit12	Lgnu/mapping/SimpleSymbol;
    //   389: aload 6
    //   391: ldc 56
    //   393: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   396: dup
    //   397: astore 7
    //   399: checkcast 56	gnu/lists/Pair
    //   402: invokestatic 153	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   405: invokestatic 111	gnu/lists/LList:list2	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   408: aload 6
    //   410: invokestatic 156	kawa/lib/lists:cadr	(Ljava/lang/Object;)Ljava/lang/Object;
    //   413: invokestatic 111	gnu/lists/LList:list2	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   416: goto +13 -> 429
    //   419: aload_0
    //   420: aload 4
    //   422: aload_2
    //   423: invokestatic 235	gnu/kawa/slib/pregexp:pregexpReadCharList	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   426: goto +3 -> 429
    //   429: aload_0
    //   430: aload_2
    //   431: invokestatic 196	gnu/kawa/slib/pregexp:pregexpWrapQuantifierIfAny	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   434: goto +214 -> 648
    //   437: getstatic 42	gnu/kawa/slib/pregexp:$Stpregexp$Mnspace$Mnsensitive$Qu$St	Ljava/lang/Object;
    //   440: astore 4
    //   442: aload 4
    //   444: invokestatic 170	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   447: ifeq +14 -> 461
    //   450: aload 4
    //   452: invokestatic 170	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   455: ifeq +42 -> 497
    //   458: goto +16 -> 474
    //   461: iload_3
    //   462: invokestatic 244	kawa/lib/rnrs/unicode:isCharWhitespace	(I)Z
    //   465: ifne +32 -> 497
    //   468: iload_3
    //   469: bipush 59
    //   471: if_icmpeq +26 -> 497
    //   474: iload_3
    //   475: invokestatic 214	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   478: iconst_1
    //   479: aload_1
    //   480: getstatic 139	gnu/kawa/slib/pregexp:Lit3	Lgnu/math/IntNum;
    //   483: invokestatic 145	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   486: invokestatic 111	gnu/lists/LList:list2	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   489: aload_0
    //   490: aload_2
    //   491: invokestatic 196	gnu/kawa/slib/pregexp:pregexpWrapQuantifierIfAny	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   494: goto +154 -> 648
    //   497: aload_1
    //   498: getstatic 217	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   501: astore 6
    //   503: astore 5
    //   505: aload 5
    //   507: aload_2
    //   508: invokestatic 96	gnu/kawa/functions/NumberCompare:$Gr$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   511: ifeq +14 -> 525
    //   514: getstatic 247	gnu/kawa/slib/pregexp:Lit13	Lgnu/mapping/SimpleSymbol;
    //   517: aload 5
    //   519: invokestatic 111	gnu/lists/LList:list2	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   522: goto +126 -> 648
    //   525: aload_0
    //   526: ldc 113
    //   528: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   531: dup
    //   532: astore 8
    //   534: checkcast 113	java/lang/CharSequence
    //   537: aload 5
    //   539: invokestatic 118	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   542: dup
    //   543: astore 8
    //   545: checkcast 120	java/lang/Number
    //   548: invokevirtual 124	java/lang/Number:intValue	()I
    //   551: invokestatic 130	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)I
    //   554: istore 7
    //   556: aload 6
    //   558: invokestatic 170	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   561: ifeq +31 -> 592
    //   564: iconst_1
    //   565: aload 5
    //   567: getstatic 139	gnu/kawa/slib/pregexp:Lit3	Lgnu/math/IntNum;
    //   570: invokestatic 145	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   573: iload 7
    //   575: bipush 10
    //   577: if_icmpne +9 -> 586
    //   580: getstatic 217	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   583: goto -82 -> 501
    //   586: getstatic 38	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   589: goto -88 -> 501
    //   592: iload 7
    //   594: invokestatic 244	kawa/lib/rnrs/unicode:isCharWhitespace	(I)Z
    //   597: ifeq +18 -> 615
    //   600: iconst_1
    //   601: aload 5
    //   603: getstatic 139	gnu/kawa/slib/pregexp:Lit3	Lgnu/math/IntNum;
    //   606: invokestatic 145	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   609: getstatic 217	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   612: goto -111 -> 501
    //   615: iload 7
    //   617: bipush 59
    //   619: if_icmpne +18 -> 637
    //   622: iconst_1
    //   623: aload 5
    //   625: getstatic 139	gnu/kawa/slib/pregexp:Lit3	Lgnu/math/IntNum;
    //   628: invokestatic 145	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   631: getstatic 38	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   634: goto -133 -> 501
    //   637: getstatic 247	gnu/kawa/slib/pregexp:Lit13	Lgnu/mapping/SimpleSymbol;
    //   640: aload 5
    //   642: invokestatic 111	gnu/lists/LList:list2	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   645: goto +3 -> 648
    //   648: areturn
    //   649: new 66	gnu/mapping/WrongType
    //   652: dup_x1
    //   653: swap
    //   654: ldc 115
    //   656: iconst_1
    //   657: aload 4
    //   659: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   662: athrow
    //   663: new 66	gnu/mapping/WrongType
    //   666: dup_x1
    //   667: swap
    //   668: ldc 115
    //   670: iconst_2
    //   671: aload 4
    //   673: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   676: athrow
    //   677: new 66	gnu/mapping/WrongType
    //   680: dup_x1
    //   681: swap
    //   682: ldc -105
    //   684: iconst_1
    //   685: aload 5
    //   687: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   690: athrow
    //   691: new 66	gnu/mapping/WrongType
    //   694: dup_x1
    //   695: swap
    //   696: ldc -105
    //   698: iconst_1
    //   699: aload 6
    //   701: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   704: athrow
    //   705: new 66	gnu/mapping/WrongType
    //   708: dup_x1
    //   709: swap
    //   710: ldc 115
    //   712: iconst_1
    //   713: aload 6
    //   715: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   718: athrow
    //   719: new 66	gnu/mapping/WrongType
    //   722: dup_x1
    //   723: swap
    //   724: ldc 115
    //   726: iconst_2
    //   727: aload 6
    //   729: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   732: athrow
    //   733: new 66	gnu/mapping/WrongType
    //   736: dup_x1
    //   737: swap
    //   738: ldc -105
    //   740: iconst_1
    //   741: aload 7
    //   743: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   746: athrow
    //   747: new 66	gnu/mapping/WrongType
    //   750: dup_x1
    //   751: swap
    //   752: ldc 115
    //   754: iconst_1
    //   755: aload 8
    //   757: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   760: athrow
    //   761: new 66	gnu/mapping/WrongType
    //   764: dup_x1
    //   765: swap
    //   766: ldc 115
    //   768: iconst_2
    //   769: aload 8
    //   771: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   774: athrow
    // Line number table:
    //   Java source line #96	-> byte code offset #0
    //   Java source line #97	-> byte code offset #0
    //   Java source line #98	-> byte code offset #29
    //   Java source line #116	-> byte code offset #105
    //   Java source line #10000	-> byte code offset #121
    //   Java source line #118	-> byte code offset #121
    //   Java source line #119	-> byte code offset #154
    //   Java source line #116	-> byte code offset #162
    //   Java source line #10000	-> byte code offset #170
    //   Java source line #121	-> byte code offset #170
    //   Java source line #122	-> byte code offset #197
    //   Java source line #123	-> byte code offset #220
    //   Java source line #113	-> byte code offset #228
    //   Java source line #102	-> byte code offset #266
    //   Java source line #103	-> byte code offset #288
    //   Java source line #104	-> byte code offset #298
    //   Java source line #105	-> byte code offset #298
    //   Java source line #107	-> byte code offset #371
    //   Java source line #108	-> byte code offset #386
    //   Java source line #109	-> byte code offset #419
    //   Java source line #110	-> byte code offset #429
    //   Java source line #125	-> byte code offset #437
    //   Java source line #126	-> byte code offset #461
    //   Java source line #127	-> byte code offset #468
    //   Java source line #128	-> byte code offset #474
    //   Java source line #129	-> byte code offset #474
    //   Java source line #130	-> byte code offset #497
    //   Java source line #131	-> byte code offset #505
    //   Java source line #132	-> byte code offset #525
    //   Java source line #133	-> byte code offset #556
    //   Java source line #134	-> byte code offset #564
    //   Java source line #135	-> byte code offset #573
    //   Java source line #136	-> byte code offset #592
    //   Java source line #137	-> byte code offset #600
    //   Java source line #139	-> byte code offset #622
    //   Java source line #140	-> byte code offset #637
    //   Java source line #97	-> byte code offset #649
    //   Java source line #118	-> byte code offset #677
    //   Java source line #121	-> byte code offset #691
    //   Java source line #105	-> byte code offset #705
    //   Java source line #108	-> byte code offset #733
    //   Java source line #132	-> byte code offset #747
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	648	0	s	Object
    //   0	648	1	i	Object
    //   0	648	2	n	Object
    //   29	619	3	c	int
    //   113	107	4	temp	Object
    //   298	136	4	i$Pl1	Object
    //   442	203	4	x	Object
    //   162	58	5	temp	Object
    //   347	82	5	tmp	Object
    //   505	140	5	i	Object
    //   386	30	6	vv	Object
    //   505	140	6	in$Mncomment$Qu	Object
    //   556	89	7	c	int
    // Exception table:
    //   from	to	target	type
    //   9	12	649	java/lang/ClassCastException
    //   19	25	663	java/lang/ClassCastException
    //   134	137	677	java/lang/ClassCastException
    //   180	183	691	java/lang/ClassCastException
    //   316	319	705	java/lang/ClassCastException
    //   327	333	719	java/lang/ClassCastException
    //   399	402	733	java/lang/ClassCastException
    //   534	537	747	java/lang/ClassCastException
    //   545	551	761	java/lang/ClassCastException
  }
  
  /* Error */
  public static Object pregexpWrapQuantifierIfAny(Object vv, Object s, Object n)
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc 56
    //   3: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   6: dup
    //   7: astore 4
    //   9: checkcast 56	gnu/lists/Pair
    //   12: invokestatic 153	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   15: astore_3
    //   16: aload_0
    //   17: invokestatic 156	kawa/lib/lists:cadr	(Ljava/lang/Object;)Ljava/lang/Object;
    //   20: astore 4
    //   22: aload 4
    //   24: aload_2
    //   25: invokestatic 96	gnu/kawa/functions/NumberCompare:$Gr$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   28: ifeq +7 -> 35
    //   31: aload_0
    //   32: goto +679 -> 711
    //   35: aload_1
    //   36: ldc 113
    //   38: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   41: dup
    //   42: astore 6
    //   44: checkcast 113	java/lang/CharSequence
    //   47: aload 4
    //   49: invokestatic 118	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   52: dup
    //   53: astore 6
    //   55: checkcast 120	java/lang/Number
    //   58: invokevirtual 124	java/lang/Number:intValue	()I
    //   61: invokestatic 130	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)I
    //   64: istore 5
    //   66: iload 5
    //   68: invokestatic 244	kawa/lib/rnrs/unicode:isCharWhitespace	(I)Z
    //   71: ifeq +24 -> 95
    //   74: getstatic 42	gnu/kawa/slib/pregexp:$Stpregexp$Mnspace$Mnsensitive$Qu$St	Ljava/lang/Object;
    //   77: invokestatic 170	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   80: ifne +15 -> 95
    //   83: iconst_1
    //   84: aload 4
    //   86: getstatic 139	gnu/kawa/slib/pregexp:Lit3	Lgnu/math/IntNum;
    //   89: invokestatic 145	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   92: goto -72 -> 20
    //   95: iload 5
    //   97: lookupswitch	default:+610->707, 42:+43->140, 43:+43->140, 63:+43->140, 123:+43->140
    //   140: getstatic 344	gnu/kawa/slib/pregexp:Lit35	Lgnu/mapping/SimpleSymbol;
    //   143: invokestatic 107	gnu/lists/LList:list1	(Ljava/lang/Object;)Lgnu/lists/Pair;
    //   146: dup
    //   147: getstatic 347	gnu/kawa/slib/pregexp:Lit36	Lgnu/mapping/SimpleSymbol;
    //   150: getstatic 350	gnu/kawa/slib/pregexp:Lit37	Lgnu/mapping/SimpleSymbol;
    //   153: getstatic 353	gnu/kawa/slib/pregexp:Lit38	Lgnu/mapping/SimpleSymbol;
    //   156: aload_3
    //   157: invokestatic 357	gnu/lists/LList:chain4	(Lgnu/lists/Pair;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   160: pop
    //   161: astore 6
    //   163: aload 6
    //   165: getstatic 360	gnu/kawa/slib/pregexp:Lit39	Lgnu/mapping/SimpleSymbol;
    //   168: invokestatic 111	gnu/lists/LList:list2	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   171: astore 7
    //   173: iload 5
    //   175: lookupswitch	default:+298->473, 42:+41->216, 43:+88->263, 63:+251->426, 123:+135->310
    //   216: aload 6
    //   218: invokestatic 363	kawa/lib/lists:cddr	(Ljava/lang/Object;)Ljava/lang/Object;
    //   221: ldc 56
    //   223: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   226: dup
    //   227: astore 8
    //   229: checkcast 56	gnu/lists/Pair
    //   232: getstatic 368	gnu/kawa/slib/pregexp:Lit40	Lgnu/math/IntNum;
    //   235: invokestatic 371	kawa/lib/lists:setCar$Ex	(Lgnu/lists/Pair;Ljava/lang/Object;)V
    //   238: aload 6
    //   240: invokestatic 374	kawa/lib/lists:cdddr	(Ljava/lang/Object;)Ljava/lang/Object;
    //   243: ldc 56
    //   245: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   248: dup
    //   249: astore 8
    //   251: checkcast 56	gnu/lists/Pair
    //   254: getstatic 217	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   257: invokestatic 371	kawa/lib/lists:setCar$Ex	(Lgnu/lists/Pair;Ljava/lang/Object;)V
    //   260: goto +213 -> 473
    //   263: aload 6
    //   265: invokestatic 363	kawa/lib/lists:cddr	(Ljava/lang/Object;)Ljava/lang/Object;
    //   268: ldc 56
    //   270: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   273: dup
    //   274: astore 8
    //   276: checkcast 56	gnu/lists/Pair
    //   279: getstatic 139	gnu/kawa/slib/pregexp:Lit3	Lgnu/math/IntNum;
    //   282: invokestatic 371	kawa/lib/lists:setCar$Ex	(Lgnu/lists/Pair;Ljava/lang/Object;)V
    //   285: aload 6
    //   287: invokestatic 374	kawa/lib/lists:cdddr	(Ljava/lang/Object;)Ljava/lang/Object;
    //   290: ldc 56
    //   292: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   295: dup
    //   296: astore 8
    //   298: checkcast 56	gnu/lists/Pair
    //   301: getstatic 217	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   304: invokestatic 371	kawa/lib/lists:setCar$Ex	(Lgnu/lists/Pair;Ljava/lang/Object;)V
    //   307: goto +166 -> 473
    //   310: aload_1
    //   311: iconst_1
    //   312: aload 4
    //   314: getstatic 139	gnu/kawa/slib/pregexp:Lit3	Lgnu/math/IntNum;
    //   317: invokestatic 145	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   320: aload_2
    //   321: invokestatic 377	gnu/kawa/slib/pregexp:pregexpReadNums	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   324: astore 8
    //   326: aload 8
    //   328: invokestatic 170	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   331: ifne +26 -> 357
    //   334: iconst_2
    //   335: anewarray 178	java/lang/Object
    //   338: dup
    //   339: iconst_0
    //   340: getstatic 380	gnu/kawa/slib/pregexp:Lit41	Lgnu/mapping/SimpleSymbol;
    //   343: aastore
    //   344: dup
    //   345: iconst_1
    //   346: getstatic 383	gnu/kawa/slib/pregexp:Lit42	Lgnu/mapping/SimpleSymbol;
    //   349: aastore
    //   350: invokestatic 187	kawa/lib/exceptions:error	([Ljava/lang/Object;)Lgnu/bytecode/Type$NeverReturns;
    //   353: getstatic 193	gnu/expr/Special:reachedUnexpected	Ljava/lang/RuntimeException;
    //   356: athrow
    //   357: aload 6
    //   359: invokestatic 363	kawa/lib/lists:cddr	(Ljava/lang/Object;)Ljava/lang/Object;
    //   362: ldc 56
    //   364: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   367: dup
    //   368: astore 9
    //   370: checkcast 56	gnu/lists/Pair
    //   373: aload 8
    //   375: ldc 56
    //   377: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   380: dup
    //   381: astore 9
    //   383: checkcast 56	gnu/lists/Pair
    //   386: invokestatic 153	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   389: invokestatic 371	kawa/lib/lists:setCar$Ex	(Lgnu/lists/Pair;Ljava/lang/Object;)V
    //   392: aload 6
    //   394: invokestatic 374	kawa/lib/lists:cdddr	(Ljava/lang/Object;)Ljava/lang/Object;
    //   397: ldc 56
    //   399: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   402: dup
    //   403: astore 9
    //   405: checkcast 56	gnu/lists/Pair
    //   408: aload 8
    //   410: invokestatic 156	kawa/lib/lists:cadr	(Ljava/lang/Object;)Ljava/lang/Object;
    //   413: invokestatic 371	kawa/lib/lists:setCar$Ex	(Lgnu/lists/Pair;Ljava/lang/Object;)V
    //   416: aload 8
    //   418: invokestatic 386	kawa/lib/lists:caddr	(Ljava/lang/Object;)Ljava/lang/Object;
    //   421: astore 4
    //   423: goto +50 -> 473
    //   426: aload 6
    //   428: invokestatic 363	kawa/lib/lists:cddr	(Ljava/lang/Object;)Ljava/lang/Object;
    //   431: ldc 56
    //   433: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   436: dup
    //   437: astore 8
    //   439: checkcast 56	gnu/lists/Pair
    //   442: getstatic 368	gnu/kawa/slib/pregexp:Lit40	Lgnu/math/IntNum;
    //   445: invokestatic 371	kawa/lib/lists:setCar$Ex	(Lgnu/lists/Pair;Ljava/lang/Object;)V
    //   448: aload 6
    //   450: invokestatic 374	kawa/lib/lists:cdddr	(Ljava/lang/Object;)Ljava/lang/Object;
    //   453: ldc 56
    //   455: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   458: dup
    //   459: astore 8
    //   461: checkcast 56	gnu/lists/Pair
    //   464: getstatic 139	gnu/kawa/slib/pregexp:Lit3	Lgnu/math/IntNum;
    //   467: invokestatic 371	kawa/lib/lists:setCar$Ex	(Lgnu/lists/Pair;Ljava/lang/Object;)V
    //   470: goto +3 -> 473
    //   473: iconst_1
    //   474: aload 4
    //   476: getstatic 139	gnu/kawa/slib/pregexp:Lit3	Lgnu/math/IntNum;
    //   479: invokestatic 145	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   482: astore 8
    //   484: aload 8
    //   486: aload_2
    //   487: invokestatic 96	gnu/kawa/functions/NumberCompare:$Gr$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   490: ifeq +49 -> 539
    //   493: aload 6
    //   495: invokestatic 75	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   498: ldc 56
    //   500: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   503: dup
    //   504: astore 9
    //   506: checkcast 56	gnu/lists/Pair
    //   509: getstatic 217	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   512: invokestatic 371	kawa/lib/lists:setCar$Ex	(Lgnu/lists/Pair;Ljava/lang/Object;)V
    //   515: aload 7
    //   517: invokestatic 75	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   520: ldc 56
    //   522: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   525: dup
    //   526: astore 9
    //   528: checkcast 56	gnu/lists/Pair
    //   531: aload 8
    //   533: invokestatic 371	kawa/lib/lists:setCar$Ex	(Lgnu/lists/Pair;Ljava/lang/Object;)V
    //   536: goto +166 -> 702
    //   539: aload_1
    //   540: ldc 113
    //   542: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   545: dup
    //   546: astore 10
    //   548: checkcast 113	java/lang/CharSequence
    //   551: aload 8
    //   553: invokestatic 118	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   556: dup
    //   557: astore 10
    //   559: checkcast 120	java/lang/Number
    //   562: invokevirtual 124	java/lang/Number:intValue	()I
    //   565: invokestatic 130	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)I
    //   568: istore 9
    //   570: iload 9
    //   572: invokestatic 244	kawa/lib/rnrs/unicode:isCharWhitespace	(I)Z
    //   575: ifeq +24 -> 599
    //   578: getstatic 42	gnu/kawa/slib/pregexp:$Stpregexp$Mnspace$Mnsensitive$Qu$St	Ljava/lang/Object;
    //   581: invokestatic 170	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   584: ifne +15 -> 599
    //   587: iconst_1
    //   588: aload 8
    //   590: getstatic 139	gnu/kawa/slib/pregexp:Lit3	Lgnu/math/IntNum;
    //   593: invokestatic 145	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   596: goto -114 -> 482
    //   599: iload 9
    //   601: bipush 63
    //   603: if_icmpne +56 -> 659
    //   606: aload 6
    //   608: invokestatic 75	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   611: ldc 56
    //   613: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   616: dup
    //   617: astore 10
    //   619: checkcast 56	gnu/lists/Pair
    //   622: getstatic 38	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   625: invokestatic 371	kawa/lib/lists:setCar$Ex	(Lgnu/lists/Pair;Ljava/lang/Object;)V
    //   628: aload 7
    //   630: invokestatic 75	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   633: ldc 56
    //   635: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   638: dup
    //   639: astore 10
    //   641: checkcast 56	gnu/lists/Pair
    //   644: iconst_1
    //   645: aload 8
    //   647: getstatic 139	gnu/kawa/slib/pregexp:Lit3	Lgnu/math/IntNum;
    //   650: invokestatic 145	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   653: invokestatic 371	kawa/lib/lists:setCar$Ex	(Lgnu/lists/Pair;Ljava/lang/Object;)V
    //   656: goto +46 -> 702
    //   659: aload 6
    //   661: invokestatic 75	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   664: ldc 56
    //   666: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   669: dup
    //   670: astore 10
    //   672: checkcast 56	gnu/lists/Pair
    //   675: getstatic 217	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   678: invokestatic 371	kawa/lib/lists:setCar$Ex	(Lgnu/lists/Pair;Ljava/lang/Object;)V
    //   681: aload 7
    //   683: invokestatic 75	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   686: ldc 56
    //   688: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   691: dup
    //   692: astore 10
    //   694: checkcast 56	gnu/lists/Pair
    //   697: aload 8
    //   699: invokestatic 371	kawa/lib/lists:setCar$Ex	(Lgnu/lists/Pair;Ljava/lang/Object;)V
    //   702: aload 7
    //   704: goto +7 -> 711
    //   707: aload_0
    //   708: goto +3 -> 711
    //   711: areturn
    //   712: new 66	gnu/mapping/WrongType
    //   715: dup_x1
    //   716: swap
    //   717: ldc -105
    //   719: iconst_1
    //   720: aload 4
    //   722: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   725: athrow
    //   726: new 66	gnu/mapping/WrongType
    //   729: dup_x1
    //   730: swap
    //   731: ldc 115
    //   733: iconst_1
    //   734: aload 6
    //   736: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   739: athrow
    //   740: new 66	gnu/mapping/WrongType
    //   743: dup_x1
    //   744: swap
    //   745: ldc 115
    //   747: iconst_2
    //   748: aload 6
    //   750: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   753: athrow
    //   754: new 66	gnu/mapping/WrongType
    //   757: dup_x1
    //   758: swap
    //   759: ldc_w 365
    //   762: iconst_1
    //   763: aload 8
    //   765: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   768: athrow
    //   769: new 66	gnu/mapping/WrongType
    //   772: dup_x1
    //   773: swap
    //   774: ldc_w 365
    //   777: iconst_1
    //   778: aload 8
    //   780: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   783: athrow
    //   784: new 66	gnu/mapping/WrongType
    //   787: dup_x1
    //   788: swap
    //   789: ldc_w 365
    //   792: iconst_1
    //   793: aload 8
    //   795: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   798: athrow
    //   799: new 66	gnu/mapping/WrongType
    //   802: dup_x1
    //   803: swap
    //   804: ldc_w 365
    //   807: iconst_1
    //   808: aload 8
    //   810: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   813: athrow
    //   814: new 66	gnu/mapping/WrongType
    //   817: dup_x1
    //   818: swap
    //   819: ldc_w 365
    //   822: iconst_1
    //   823: aload 9
    //   825: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   828: athrow
    //   829: new 66	gnu/mapping/WrongType
    //   832: dup_x1
    //   833: swap
    //   834: ldc -105
    //   836: iconst_1
    //   837: aload 9
    //   839: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   842: athrow
    //   843: new 66	gnu/mapping/WrongType
    //   846: dup_x1
    //   847: swap
    //   848: ldc_w 365
    //   851: iconst_1
    //   852: aload 9
    //   854: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   857: athrow
    //   858: new 66	gnu/mapping/WrongType
    //   861: dup_x1
    //   862: swap
    //   863: ldc_w 365
    //   866: iconst_1
    //   867: aload 8
    //   869: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   872: athrow
    //   873: new 66	gnu/mapping/WrongType
    //   876: dup_x1
    //   877: swap
    //   878: ldc_w 365
    //   881: iconst_1
    //   882: aload 8
    //   884: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   887: athrow
    //   888: new 66	gnu/mapping/WrongType
    //   891: dup_x1
    //   892: swap
    //   893: ldc_w 365
    //   896: iconst_1
    //   897: aload 9
    //   899: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   902: athrow
    //   903: new 66	gnu/mapping/WrongType
    //   906: dup_x1
    //   907: swap
    //   908: ldc_w 365
    //   911: iconst_1
    //   912: aload 9
    //   914: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   917: athrow
    //   918: new 66	gnu/mapping/WrongType
    //   921: dup_x1
    //   922: swap
    //   923: ldc 115
    //   925: iconst_1
    //   926: aload 10
    //   928: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   931: athrow
    //   932: new 66	gnu/mapping/WrongType
    //   935: dup_x1
    //   936: swap
    //   937: ldc 115
    //   939: iconst_2
    //   940: aload 10
    //   942: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   945: athrow
    //   946: new 66	gnu/mapping/WrongType
    //   949: dup_x1
    //   950: swap
    //   951: ldc_w 365
    //   954: iconst_1
    //   955: aload 10
    //   957: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   960: athrow
    //   961: new 66	gnu/mapping/WrongType
    //   964: dup_x1
    //   965: swap
    //   966: ldc_w 365
    //   969: iconst_1
    //   970: aload 10
    //   972: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   975: athrow
    //   976: new 66	gnu/mapping/WrongType
    //   979: dup_x1
    //   980: swap
    //   981: ldc_w 365
    //   984: iconst_1
    //   985: aload 10
    //   987: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   990: athrow
    //   991: new 66	gnu/mapping/WrongType
    //   994: dup_x1
    //   995: swap
    //   996: ldc_w 365
    //   999: iconst_1
    //   1000: aload 10
    //   1002: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1005: athrow
    // Line number table:
    //   Java source line #259	-> byte code offset #0
    //   Java source line #260	-> byte code offset #0
    //   Java source line #261	-> byte code offset #16
    //   Java source line #262	-> byte code offset #22
    //   Java source line #263	-> byte code offset #35
    //   Java source line #264	-> byte code offset #66
    //   Java source line #265	-> byte code offset #83
    //   Java source line #266	-> byte code offset #95
    //   Java source line #268	-> byte code offset #140
    //   Java source line #270	-> byte code offset #163
    //   Java source line #271	-> byte code offset #173
    //   Java source line #272	-> byte code offset #216
    //   Java source line #273	-> byte code offset #238
    //   Java source line #274	-> byte code offset #263
    //   Java source line #275	-> byte code offset #285
    //   Java source line #278	-> byte code offset #310
    //   Java source line #279	-> byte code offset #326
    //   Java source line #280	-> byte code offset #334
    //   Java source line #283	-> byte code offset #357
    //   Java source line #284	-> byte code offset #392
    //   Java source line #285	-> byte code offset #416
    //   Java source line #276	-> byte code offset #426
    //   Java source line #277	-> byte code offset #448
    //   Java source line #286	-> byte code offset #473
    //   Java source line #287	-> byte code offset #484
    //   Java source line #288	-> byte code offset #493
    //   Java source line #289	-> byte code offset #515
    //   Java source line #290	-> byte code offset #539
    //   Java source line #291	-> byte code offset #570
    //   Java source line #293	-> byte code offset #587
    //   Java source line #295	-> byte code offset #606
    //   Java source line #296	-> byte code offset #628
    //   Java source line #297	-> byte code offset #659
    //   Java source line #298	-> byte code offset #681
    //   Java source line #299	-> byte code offset #702
    //   Java source line #260	-> byte code offset #712
    //   Java source line #263	-> byte code offset #726
    //   Java source line #272	-> byte code offset #754
    //   Java source line #273	-> byte code offset #769
    //   Java source line #274	-> byte code offset #784
    //   Java source line #275	-> byte code offset #799
    //   Java source line #283	-> byte code offset #814
    //   Java source line #284	-> byte code offset #843
    //   Java source line #276	-> byte code offset #858
    //   Java source line #277	-> byte code offset #873
    //   Java source line #288	-> byte code offset #888
    //   Java source line #289	-> byte code offset #903
    //   Java source line #290	-> byte code offset #918
    //   Java source line #295	-> byte code offset #946
    //   Java source line #296	-> byte code offset #961
    //   Java source line #297	-> byte code offset #976
    //   Java source line #298	-> byte code offset #991
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	711	0	vv	Object
    //   0	711	1	s	Object
    //   0	711	2	n	Object
    //   16	695	3	re	Object
    //   22	689	4	i	Object
    //   66	645	5	c	int
    //   163	541	6	new$Mnre	Pair
    //   173	531	7	new$Mnvv	Pair
    //   326	97	8	pq	Object
    //   484	218	8	i	Object
    //   570	132	9	c	int
    // Exception table:
    //   from	to	target	type
    //   9	12	712	java/lang/ClassCastException
    //   44	47	726	java/lang/ClassCastException
    //   55	61	740	java/lang/ClassCastException
    //   229	232	754	java/lang/ClassCastException
    //   251	254	769	java/lang/ClassCastException
    //   276	279	784	java/lang/ClassCastException
    //   298	301	799	java/lang/ClassCastException
    //   370	373	814	java/lang/ClassCastException
    //   383	386	829	java/lang/ClassCastException
    //   405	408	843	java/lang/ClassCastException
    //   439	442	858	java/lang/ClassCastException
    //   461	464	873	java/lang/ClassCastException
    //   506	509	888	java/lang/ClassCastException
    //   528	531	903	java/lang/ClassCastException
    //   548	551	918	java/lang/ClassCastException
    //   559	565	932	java/lang/ClassCastException
    //   619	622	946	java/lang/ClassCastException
    //   641	644	961	java/lang/ClassCastException
    //   672	675	976	java/lang/ClassCastException
    //   694	697	991	java/lang/ClassCastException
  }
  
  /* Error */
  public static Object pregexpReadEscapedNumber(Object s, Object i, Object n)
  {
    // Byte code:
    //   0: iconst_1
    //   1: aload_1
    //   2: getstatic 139	gnu/kawa/slib/pregexp:Lit3	Lgnu/math/IntNum;
    //   5: invokestatic 145	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   8: aload_2
    //   9: invokestatic 208	gnu/kawa/functions/NumberCompare:$Ls	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   12: ifeq +201 -> 213
    //   15: aload_0
    //   16: ldc 113
    //   18: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   21: dup
    //   22: astore 4
    //   24: checkcast 113	java/lang/CharSequence
    //   27: iconst_1
    //   28: aload_1
    //   29: getstatic 139	gnu/kawa/slib/pregexp:Lit3	Lgnu/math/IntNum;
    //   32: invokestatic 145	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   35: invokestatic 118	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   38: dup
    //   39: astore 4
    //   41: checkcast 120	java/lang/Number
    //   44: invokevirtual 124	java/lang/Number:intValue	()I
    //   47: invokestatic 130	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)I
    //   50: istore_3
    //   51: iload_3
    //   52: invokestatic 250	kawa/lib/rnrs/unicode:isCharNumeric	(I)Z
    //   55: ifeq +152 -> 207
    //   58: iconst_1
    //   59: aload_1
    //   60: getstatic 232	gnu/kawa/slib/pregexp:Lit11	Lgnu/math/IntNum;
    //   63: invokestatic 145	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   66: iload_3
    //   67: invokestatic 214	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   70: invokestatic 107	gnu/lists/LList:list1	(Ljava/lang/Object;)Lgnu/lists/Pair;
    //   73: astore 5
    //   75: astore 4
    //   77: aload 4
    //   79: aload_2
    //   80: invokestatic 96	gnu/kawa/functions/NumberCompare:$Gr$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   83: ifeq +33 -> 116
    //   86: aload 5
    //   88: invokestatic 133	gnu/kawa/slib/pregexp:pregexpReverse$Ex	(Ljava/lang/Object;)Ljava/lang/Object;
    //   91: ldc 44
    //   93: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   96: dup
    //   97: astore 6
    //   99: checkcast 44	gnu/lists/LList
    //   102: invokestatic 256	kawa/lib/strings:list$To$String	(Lgnu/lists/LList;)Ljava/lang/CharSequence;
    //   105: invokestatic 262	kawa/lib/numbers:string$To$Number	(Ljava/lang/CharSequence;)Ljava/lang/Object;
    //   108: aload 4
    //   110: invokestatic 111	gnu/lists/LList:list2	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   113: goto +103 -> 216
    //   116: aload_0
    //   117: ldc 113
    //   119: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   122: dup
    //   123: astore 7
    //   125: checkcast 113	java/lang/CharSequence
    //   128: aload 4
    //   130: invokestatic 118	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   133: dup
    //   134: astore 7
    //   136: checkcast 120	java/lang/Number
    //   139: invokevirtual 124	java/lang/Number:intValue	()I
    //   142: invokestatic 130	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)I
    //   145: istore 6
    //   147: iload 6
    //   149: invokestatic 250	kawa/lib/rnrs/unicode:isCharNumeric	(I)Z
    //   152: ifeq +25 -> 177
    //   155: iconst_1
    //   156: aload 4
    //   158: getstatic 139	gnu/kawa/slib/pregexp:Lit3	Lgnu/math/IntNum;
    //   161: invokestatic 145	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   164: iload 6
    //   166: invokestatic 214	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   169: aload 5
    //   171: invokestatic 136	kawa/lib/lists:cons	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   174: goto -101 -> 73
    //   177: aload 5
    //   179: invokestatic 133	gnu/kawa/slib/pregexp:pregexpReverse$Ex	(Ljava/lang/Object;)Ljava/lang/Object;
    //   182: ldc 44
    //   184: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   187: dup
    //   188: astore 7
    //   190: checkcast 44	gnu/lists/LList
    //   193: invokestatic 256	kawa/lib/strings:list$To$String	(Lgnu/lists/LList;)Ljava/lang/CharSequence;
    //   196: invokestatic 262	kawa/lib/numbers:string$To$Number	(Ljava/lang/CharSequence;)Ljava/lang/Object;
    //   199: aload 4
    //   201: invokestatic 111	gnu/lists/LList:list2	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   204: goto +12 -> 216
    //   207: getstatic 217	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   210: goto +6 -> 216
    //   213: getstatic 217	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   216: areturn
    //   217: new 66	gnu/mapping/WrongType
    //   220: dup_x1
    //   221: swap
    //   222: ldc 115
    //   224: iconst_1
    //   225: aload 4
    //   227: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   230: athrow
    //   231: new 66	gnu/mapping/WrongType
    //   234: dup_x1
    //   235: swap
    //   236: ldc 115
    //   238: iconst_2
    //   239: aload 4
    //   241: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   244: athrow
    //   245: new 66	gnu/mapping/WrongType
    //   248: dup_x1
    //   249: swap
    //   250: ldc -4
    //   252: iconst_1
    //   253: aload 6
    //   255: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   258: athrow
    //   259: new 66	gnu/mapping/WrongType
    //   262: dup_x1
    //   263: swap
    //   264: ldc 115
    //   266: iconst_1
    //   267: aload 7
    //   269: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   272: athrow
    //   273: new 66	gnu/mapping/WrongType
    //   276: dup_x1
    //   277: swap
    //   278: ldc 115
    //   280: iconst_2
    //   281: aload 7
    //   283: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   286: athrow
    //   287: new 66	gnu/mapping/WrongType
    //   290: dup_x1
    //   291: swap
    //   292: ldc -4
    //   294: iconst_1
    //   295: aload 7
    //   297: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   300: athrow
    // Line number table:
    //   Java source line #143	-> byte code offset #0
    //   Java source line #145	-> byte code offset #0
    //   Java source line #146	-> byte code offset #15
    //   Java source line #147	-> byte code offset #51
    //   Java source line #148	-> byte code offset #58
    //   Java source line #149	-> byte code offset #77
    //   Java source line #150	-> byte code offset #86
    //   Java source line #151	-> byte code offset #86
    //   Java source line #152	-> byte code offset #116
    //   Java source line #153	-> byte code offset #147
    //   Java source line #154	-> byte code offset #155
    //   Java source line #155	-> byte code offset #177
    //   Java source line #156	-> byte code offset #177
    //   Java source line #146	-> byte code offset #217
    //   Java source line #151	-> byte code offset #245
    //   Java source line #152	-> byte code offset #259
    //   Java source line #156	-> byte code offset #287
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	216	0	s	Object
    //   0	216	1	i	Object
    //   0	216	2	n	Object
    //   50	17	3	c	int
    //   22	18	4	localObject1	Object
    //   75	165	4	i	Object
    //   73	1	5	localPair	Pair
    //   77	101	5	r	Object
    //   97	1	6	localObject2	Object
    //   145	109	6	c	int
    //   123	173	7	localObject3	Object
    //   217	1	11	localClassCastException1	ClassCastException
    //   231	1	12	localClassCastException2	ClassCastException
    //   245	1	13	localClassCastException3	ClassCastException
    //   259	1	14	localClassCastException4	ClassCastException
    //   273	1	15	localClassCastException5	ClassCastException
    //   287	1	16	localClassCastException6	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   24	27	217	java/lang/ClassCastException
    //   41	47	231	java/lang/ClassCastException
    //   99	102	245	java/lang/ClassCastException
    //   125	128	259	java/lang/ClassCastException
    //   136	142	273	java/lang/ClassCastException
    //   190	193	287	java/lang/ClassCastException
  }
  
  /* Error */
  public static Object pregexpReadEscapedChar(Object s, Object i, Object n)
  {
    // Byte code:
    //   0: iconst_1
    //   1: aload_1
    //   2: getstatic 139	gnu/kawa/slib/pregexp:Lit3	Lgnu/math/IntNum;
    //   5: invokestatic 145	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   8: aload_2
    //   9: invokestatic 208	gnu/kawa/functions/NumberCompare:$Ls	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   12: ifeq +351 -> 363
    //   15: aload_0
    //   16: ldc 113
    //   18: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   21: dup
    //   22: astore 4
    //   24: checkcast 113	java/lang/CharSequence
    //   27: iconst_1
    //   28: aload_1
    //   29: getstatic 139	gnu/kawa/slib/pregexp:Lit3	Lgnu/math/IntNum;
    //   32: invokestatic 145	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   35: invokestatic 118	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   38: dup
    //   39: astore 4
    //   41: checkcast 120	java/lang/Number
    //   44: invokevirtual 124	java/lang/Number:intValue	()I
    //   47: invokestatic 130	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)I
    //   50: istore_3
    //   51: iload_3
    //   52: lookupswitch	default:+293->345, 66:+259->311, 68:+117->169, 83:+242->294, 87:+134->186, 98:+205->257, 100:+151->203, 110:+276->328, 114:+222->274, 115:+188->240, 116:+168->220, 119:+100->152
    //   152: getstatic 265	gnu/kawa/slib/pregexp:Lit14	Lgnu/mapping/SimpleSymbol;
    //   155: iconst_1
    //   156: aload_1
    //   157: getstatic 232	gnu/kawa/slib/pregexp:Lit11	Lgnu/math/IntNum;
    //   160: invokestatic 145	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   163: invokestatic 111	gnu/lists/LList:list2	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   166: goto +200 -> 366
    //   169: getstatic 269	gnu/kawa/slib/pregexp:Lit15	Lgnu/lists/PairWithPosition;
    //   172: iconst_1
    //   173: aload_1
    //   174: getstatic 232	gnu/kawa/slib/pregexp:Lit11	Lgnu/math/IntNum;
    //   177: invokestatic 145	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   180: invokestatic 111	gnu/lists/LList:list2	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   183: goto +183 -> 366
    //   186: getstatic 272	gnu/kawa/slib/pregexp:Lit16	Lgnu/lists/PairWithPosition;
    //   189: iconst_1
    //   190: aload_1
    //   191: getstatic 232	gnu/kawa/slib/pregexp:Lit11	Lgnu/math/IntNum;
    //   194: invokestatic 145	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   197: invokestatic 111	gnu/lists/LList:list2	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   200: goto +166 -> 366
    //   203: getstatic 275	gnu/kawa/slib/pregexp:Lit17	Lgnu/mapping/SimpleSymbol;
    //   206: iconst_1
    //   207: aload_1
    //   208: getstatic 232	gnu/kawa/slib/pregexp:Lit11	Lgnu/math/IntNum;
    //   211: invokestatic 145	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   214: invokestatic 111	gnu/lists/LList:list2	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   217: goto +149 -> 366
    //   220: getstatic 32	gnu/kawa/slib/pregexp:$Stpregexp$Mntab$Mnchar$St	I
    //   223: invokestatic 214	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   226: iconst_1
    //   227: aload_1
    //   228: getstatic 232	gnu/kawa/slib/pregexp:Lit11	Lgnu/math/IntNum;
    //   231: invokestatic 145	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   234: invokestatic 111	gnu/lists/LList:list2	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   237: goto +129 -> 366
    //   240: getstatic 278	gnu/kawa/slib/pregexp:Lit18	Lgnu/mapping/SimpleSymbol;
    //   243: iconst_1
    //   244: aload_1
    //   245: getstatic 232	gnu/kawa/slib/pregexp:Lit11	Lgnu/math/IntNum;
    //   248: invokestatic 145	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   251: invokestatic 111	gnu/lists/LList:list2	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   254: goto +112 -> 366
    //   257: getstatic 281	gnu/kawa/slib/pregexp:Lit19	Lgnu/mapping/SimpleSymbol;
    //   260: iconst_1
    //   261: aload_1
    //   262: getstatic 232	gnu/kawa/slib/pregexp:Lit11	Lgnu/math/IntNum;
    //   265: invokestatic 145	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   268: invokestatic 111	gnu/lists/LList:list2	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   271: goto +95 -> 366
    //   274: getstatic 29	gnu/kawa/slib/pregexp:$Stpregexp$Mnreturn$Mnchar$St	I
    //   277: invokestatic 214	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   280: iconst_1
    //   281: aload_1
    //   282: getstatic 232	gnu/kawa/slib/pregexp:Lit11	Lgnu/math/IntNum;
    //   285: invokestatic 145	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   288: invokestatic 111	gnu/lists/LList:list2	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   291: goto +75 -> 366
    //   294: getstatic 284	gnu/kawa/slib/pregexp:Lit20	Lgnu/lists/PairWithPosition;
    //   297: iconst_1
    //   298: aload_1
    //   299: getstatic 232	gnu/kawa/slib/pregexp:Lit11	Lgnu/math/IntNum;
    //   302: invokestatic 145	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   305: invokestatic 111	gnu/lists/LList:list2	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   308: goto +58 -> 366
    //   311: getstatic 287	gnu/kawa/slib/pregexp:Lit21	Lgnu/mapping/SimpleSymbol;
    //   314: iconst_1
    //   315: aload_1
    //   316: getstatic 232	gnu/kawa/slib/pregexp:Lit11	Lgnu/math/IntNum;
    //   319: invokestatic 145	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   322: invokestatic 111	gnu/lists/LList:list2	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   325: goto +41 -> 366
    //   328: getstatic 290	gnu/kawa/slib/pregexp:Lit22	Lgnu/text/Char;
    //   331: iconst_1
    //   332: aload_1
    //   333: getstatic 232	gnu/kawa/slib/pregexp:Lit11	Lgnu/math/IntNum;
    //   336: invokestatic 145	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   339: invokestatic 111	gnu/lists/LList:list2	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   342: goto +24 -> 366
    //   345: iload_3
    //   346: invokestatic 214	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   349: iconst_1
    //   350: aload_1
    //   351: getstatic 232	gnu/kawa/slib/pregexp:Lit11	Lgnu/math/IntNum;
    //   354: invokestatic 145	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   357: invokestatic 111	gnu/lists/LList:list2	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   360: goto +6 -> 366
    //   363: getstatic 217	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   366: areturn
    //   367: new 66	gnu/mapping/WrongType
    //   370: dup_x1
    //   371: swap
    //   372: ldc 115
    //   374: iconst_1
    //   375: aload 4
    //   377: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   380: athrow
    //   381: new 66	gnu/mapping/WrongType
    //   384: dup_x1
    //   385: swap
    //   386: ldc 115
    //   388: iconst_2
    //   389: aload 4
    //   391: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   394: athrow
    // Line number table:
    //   Java source line #160	-> byte code offset #0
    //   Java source line #162	-> byte code offset #0
    //   Java source line #163	-> byte code offset #15
    //   Java source line #164	-> byte code offset #51
    //   Java source line #163	-> byte code offset #367
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	366	0	s	Object
    //   0	366	1	i	Object
    //   0	366	2	n	Object
    //   50	296	3	c	int
    //   22	368	4	localObject	Object
    //   367	1	5	localClassCastException1	ClassCastException
    //   381	1	6	localClassCastException2	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   24	27	367	java/lang/ClassCastException
    //   41	47	381	java/lang/ClassCastException
  }
  
  /* Error */
  public static Object pregexpReadSubpattern(Object s, Object i, Object n)
  {
    // Byte code:
    //   0: getstatic 42	gnu/kawa/slib/pregexp:$Stpregexp$Mnspace$Mnsensitive$Qu$St	Ljava/lang/Object;
    //   3: astore_3
    //   4: aload_0
    //   5: aload_1
    //   6: aload_2
    //   7: invokestatic 335	gnu/kawa/slib/pregexp:pregexpReadClusterType	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   10: astore 4
    //   12: aload 4
    //   14: ldc 56
    //   16: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   19: dup
    //   20: astore 6
    //   22: checkcast 56	gnu/lists/Pair
    //   25: invokestatic 153	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   28: astore 5
    //   30: aload 4
    //   32: invokestatic 156	kawa/lib/lists:cadr	(Ljava/lang/Object;)Ljava/lang/Object;
    //   35: astore 6
    //   37: aload_0
    //   38: aload 6
    //   40: aload_2
    //   41: invokestatic 338	gnu/kawa/slib/pregexp:pregexpReadPattern	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   44: astore 7
    //   46: aload_3
    //   47: putstatic 42	gnu/kawa/slib/pregexp:$Stpregexp$Mnspace$Mnsensitive$Qu$St	Ljava/lang/Object;
    //   50: aload 7
    //   52: ldc 56
    //   54: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   57: dup
    //   58: astore 9
    //   60: checkcast 56	gnu/lists/Pair
    //   63: invokestatic 153	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   66: astore 8
    //   68: aload 7
    //   70: invokestatic 156	kawa/lib/lists:cadr	(Ljava/lang/Object;)Ljava/lang/Object;
    //   73: astore 9
    //   75: aload 9
    //   77: aload_2
    //   78: invokestatic 208	gnu/kawa/functions/NumberCompare:$Ls	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   81: ifeq +113 -> 194
    //   84: aload_0
    //   85: ldc 113
    //   87: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   90: dup
    //   91: astore 10
    //   93: checkcast 113	java/lang/CharSequence
    //   96: aload 9
    //   98: invokestatic 118	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   101: dup
    //   102: astore 10
    //   104: checkcast 120	java/lang/Number
    //   107: invokevirtual 124	java/lang/Number:intValue	()I
    //   110: invokestatic 130	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)I
    //   113: bipush 41
    //   115: if_icmpne +79 -> 194
    //   118: aload 5
    //   120: aload 8
    //   122: astore 11
    //   124: astore 10
    //   126: aload 10
    //   128: invokestatic 54	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
    //   131: ifeq +8 -> 139
    //   134: aload 11
    //   136: goto +43 -> 179
    //   139: aload 10
    //   141: ldc 56
    //   143: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   146: dup
    //   147: astore 12
    //   149: checkcast 56	gnu/lists/Pair
    //   152: invokestatic 75	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   155: aload 10
    //   157: ldc 56
    //   159: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   162: dup
    //   163: astore 12
    //   165: checkcast 56	gnu/lists/Pair
    //   168: invokestatic 153	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   171: aload 11
    //   173: invokestatic 111	gnu/lists/LList:list2	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   176: goto -54 -> 122
    //   179: iconst_1
    //   180: aload 9
    //   182: getstatic 139	gnu/kawa/slib/pregexp:Lit3	Lgnu/math/IntNum;
    //   185: invokestatic 145	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   188: invokestatic 111	gnu/lists/LList:list2	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   191: goto +20 -> 211
    //   194: iconst_1
    //   195: anewarray 178	java/lang/Object
    //   198: dup
    //   199: iconst_0
    //   200: getstatic 341	gnu/kawa/slib/pregexp:Lit34	Lgnu/mapping/SimpleSymbol;
    //   203: aastore
    //   204: invokestatic 187	kawa/lib/exceptions:error	([Ljava/lang/Object;)Lgnu/bytecode/Type$NeverReturns;
    //   207: getstatic 193	gnu/expr/Special:reachedUnexpected	Ljava/lang/RuntimeException;
    //   210: athrow
    //   211: areturn
    //   212: new 66	gnu/mapping/WrongType
    //   215: dup_x1
    //   216: swap
    //   217: ldc -105
    //   219: iconst_1
    //   220: aload 6
    //   222: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   225: athrow
    //   226: new 66	gnu/mapping/WrongType
    //   229: dup_x1
    //   230: swap
    //   231: ldc -105
    //   233: iconst_1
    //   234: aload 9
    //   236: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   239: athrow
    //   240: new 66	gnu/mapping/WrongType
    //   243: dup_x1
    //   244: swap
    //   245: ldc 115
    //   247: iconst_1
    //   248: aload 10
    //   250: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   253: athrow
    //   254: new 66	gnu/mapping/WrongType
    //   257: dup_x1
    //   258: swap
    //   259: ldc 115
    //   261: iconst_2
    //   262: aload 10
    //   264: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   267: athrow
    //   268: new 66	gnu/mapping/WrongType
    //   271: dup_x1
    //   272: swap
    //   273: ldc 68
    //   275: iconst_1
    //   276: aload 12
    //   278: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   281: athrow
    //   282: new 66	gnu/mapping/WrongType
    //   285: dup_x1
    //   286: swap
    //   287: ldc -105
    //   289: iconst_1
    //   290: aload 12
    //   292: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   295: athrow
    // Line number table:
    //   Java source line #238	-> byte code offset #0
    //   Java source line #239	-> byte code offset #0
    //   Java source line #240	-> byte code offset #4
    //   Java source line #239	-> byte code offset #12
    //   Java source line #241	-> byte code offset #12
    //   Java source line #239	-> byte code offset #30
    //   Java source line #242	-> byte code offset #30
    //   Java source line #239	-> byte code offset #37
    //   Java source line #243	-> byte code offset #37
    //   Java source line #244	-> byte code offset #46
    //   Java source line #245	-> byte code offset #50
    //   Java source line #246	-> byte code offset #68
    //   Java source line #247	-> byte code offset #75
    //   Java source line #248	-> byte code offset #84
    //   Java source line #250	-> byte code offset #118
    //   Java source line #251	-> byte code offset #118
    //   Java source line #252	-> byte code offset #126
    //   Java source line #253	-> byte code offset #139
    //   Java source line #254	-> byte code offset #155
    //   Java source line #256	-> byte code offset #194
    //   Java source line #241	-> byte code offset #212
    //   Java source line #245	-> byte code offset #226
    //   Java source line #248	-> byte code offset #240
    //   Java source line #253	-> byte code offset #268
    //   Java source line #254	-> byte code offset #282
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	211	0	s	Object
    //   0	211	1	i	Object
    //   0	211	2	n	Object
    //   3	44	3	remember$Mnspace$Mnsensitive$Qu	Object
    //   10	21	4	ctyp$Mni	Object
    //   28	91	5	ctyp	Object
    //   20	1	6	localObject1	Object
    //   35	186	6	i	Object
    //   44	25	7	vv	Object
    //   66	1	8	localObject2	Object
    //   75	46	8	vv$Mnre	Object
    //   58	1	9	localObject3	Object
    //   73	162	9	vv$Mni	Object
    //   91	12	10	localObject4	Object
    //   124	139	10	ctyp	Object
    //   122	1	11	localObject5	Object
    //   126	46	11	re	Object
    //   147	144	12	localObject6	Object
    //   212	1	18	localClassCastException1	ClassCastException
    //   226	1	19	localClassCastException2	ClassCastException
    //   240	1	20	localClassCastException3	ClassCastException
    //   254	1	21	localClassCastException4	ClassCastException
    //   268	1	22	localClassCastException5	ClassCastException
    //   282	1	23	localClassCastException6	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   22	25	212	java/lang/ClassCastException
    //   60	63	226	java/lang/ClassCastException
    //   93	96	240	java/lang/ClassCastException
    //   104	110	254	java/lang/ClassCastException
    //   149	152	268	java/lang/ClassCastException
    //   165	168	282	java/lang/ClassCastException
  }
  
  /* Error */
  public static Object pregexpReadCharList(Object s, Object i, Object n)
  {
    // Byte code:
    //   0: getstatic 48	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
    //   3: aload_1
    //   4: astore 4
    //   6: astore_3
    //   7: aload 4
    //   9: aload_2
    //   10: invokestatic 96	gnu/kawa/functions/NumberCompare:$Gr$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   13: ifeq +26 -> 39
    //   16: iconst_2
    //   17: anewarray 178	java/lang/Object
    //   20: dup
    //   21: iconst_0
    //   22: getstatic 402	gnu/kawa/slib/pregexp:Lit45	Lgnu/mapping/SimpleSymbol;
    //   25: aastore
    //   26: dup
    //   27: iconst_1
    //   28: getstatic 405	gnu/kawa/slib/pregexp:Lit46	Lgnu/mapping/SimpleSymbol;
    //   31: aastore
    //   32: invokestatic 187	kawa/lib/exceptions:error	([Ljava/lang/Object;)Lgnu/bytecode/Type$NeverReturns;
    //   35: getstatic 193	gnu/expr/Special:reachedUnexpected	Ljava/lang/RuntimeException;
    //   38: athrow
    //   39: aload_0
    //   40: ldc 113
    //   42: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   45: dup
    //   46: astore 6
    //   48: checkcast 113	java/lang/CharSequence
    //   51: aload 4
    //   53: invokestatic 118	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   56: dup
    //   57: astore 6
    //   59: checkcast 120	java/lang/Number
    //   62: invokevirtual 124	java/lang/Number:intValue	()I
    //   65: invokestatic 130	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)I
    //   68: istore 5
    //   70: iload 5
    //   72: lookupswitch	default:+488->560, 45:+271->343, 91:+165->237, 92:+97->169, 93:+44->116
    //   116: aload_3
    //   117: invokestatic 54	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
    //   120: ifeq +24 -> 144
    //   123: iload 5
    //   125: invokestatic 214	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   128: aload_3
    //   129: invokestatic 136	kawa/lib/lists:cons	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   132: iconst_1
    //   133: aload 4
    //   135: getstatic 139	gnu/kawa/slib/pregexp:Lit3	Lgnu/math/IntNum;
    //   138: invokestatic 145	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   141: goto -137 -> 4
    //   144: getstatic 408	gnu/kawa/slib/pregexp:Lit47	Lgnu/mapping/SimpleSymbol;
    //   147: aload_3
    //   148: invokestatic 133	gnu/kawa/slib/pregexp:pregexpReverse$Ex	(Ljava/lang/Object;)Ljava/lang/Object;
    //   151: invokestatic 136	kawa/lib/lists:cons	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   154: iconst_1
    //   155: aload 4
    //   157: getstatic 139	gnu/kawa/slib/pregexp:Lit3	Lgnu/math/IntNum;
    //   160: invokestatic 145	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   163: invokestatic 111	gnu/lists/LList:list2	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   166: goto +415 -> 581
    //   169: aload_0
    //   170: aload 4
    //   172: aload_2
    //   173: invokestatic 176	gnu/kawa/slib/pregexp:pregexpReadEscapedChar	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   176: astore 6
    //   178: aload 6
    //   180: invokestatic 170	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   183: ifeq +31 -> 214
    //   186: aload 6
    //   188: ldc 56
    //   190: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   193: dup
    //   194: astore 7
    //   196: checkcast 56	gnu/lists/Pair
    //   199: invokestatic 153	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   202: aload_3
    //   203: invokestatic 136	kawa/lib/lists:cons	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   206: aload 6
    //   208: invokestatic 156	kawa/lib/lists:cadr	(Ljava/lang/Object;)Ljava/lang/Object;
    //   211: goto -207 -> 4
    //   214: iconst_2
    //   215: anewarray 178	java/lang/Object
    //   218: dup
    //   219: iconst_0
    //   220: getstatic 402	gnu/kawa/slib/pregexp:Lit45	Lgnu/mapping/SimpleSymbol;
    //   223: aastore
    //   224: dup
    //   225: iconst_1
    //   226: getstatic 184	gnu/kawa/slib/pregexp:Lit7	Lgnu/mapping/SimpleSymbol;
    //   229: aastore
    //   230: invokestatic 187	kawa/lib/exceptions:error	([Ljava/lang/Object;)Lgnu/bytecode/Type$NeverReturns;
    //   233: getstatic 193	gnu/expr/Special:reachedUnexpected	Ljava/lang/RuntimeException;
    //   236: athrow
    //   237: aload_0
    //   238: ldc 113
    //   240: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   243: dup
    //   244: astore 6
    //   246: checkcast 113	java/lang/CharSequence
    //   249: iconst_1
    //   250: aload 4
    //   252: getstatic 139	gnu/kawa/slib/pregexp:Lit3	Lgnu/math/IntNum;
    //   255: invokestatic 145	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   258: invokestatic 118	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   261: dup
    //   262: astore 6
    //   264: checkcast 120	java/lang/Number
    //   267: invokevirtual 124	java/lang/Number:intValue	()I
    //   270: invokestatic 130	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)I
    //   273: bipush 58
    //   275: if_icmpne +47 -> 322
    //   278: aload_0
    //   279: iconst_1
    //   280: aload 4
    //   282: getstatic 232	gnu/kawa/slib/pregexp:Lit11	Lgnu/math/IntNum;
    //   285: invokestatic 145	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   288: aload_2
    //   289: invokestatic 411	gnu/kawa/slib/pregexp:pregexpReadPosixCharClass	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   292: astore 6
    //   294: aload 6
    //   296: ldc 56
    //   298: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   301: dup
    //   302: astore 7
    //   304: checkcast 56	gnu/lists/Pair
    //   307: invokestatic 153	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   310: aload_3
    //   311: invokestatic 136	kawa/lib/lists:cons	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   314: aload 6
    //   316: invokestatic 156	kawa/lib/lists:cadr	(Ljava/lang/Object;)Ljava/lang/Object;
    //   319: goto -315 -> 4
    //   322: iload 5
    //   324: invokestatic 214	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   327: aload_3
    //   328: invokestatic 136	kawa/lib/lists:cons	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   331: iconst_1
    //   332: aload 4
    //   334: getstatic 139	gnu/kawa/slib/pregexp:Lit3	Lgnu/math/IntNum;
    //   337: invokestatic 145	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   340: goto -336 -> 4
    //   343: aload_3
    //   344: invokestatic 54	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
    //   347: istore 6
    //   349: iload 6
    //   351: ifeq +11 -> 362
    //   354: iload 6
    //   356: ifeq +81 -> 437
    //   359: goto +57 -> 416
    //   362: iconst_1
    //   363: aload 4
    //   365: getstatic 139	gnu/kawa/slib/pregexp:Lit3	Lgnu/math/IntNum;
    //   368: invokestatic 145	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   371: astore 7
    //   373: aload 7
    //   375: aload_2
    //   376: invokestatic 208	gnu/kawa/functions/NumberCompare:$Ls	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   379: ifeq +58 -> 437
    //   382: aload_0
    //   383: ldc 113
    //   385: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   388: dup
    //   389: astore 8
    //   391: checkcast 113	java/lang/CharSequence
    //   394: aload 7
    //   396: invokestatic 118	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   399: dup
    //   400: astore 8
    //   402: checkcast 120	java/lang/Number
    //   405: invokevirtual 124	java/lang/Number:intValue	()I
    //   408: invokestatic 130	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)I
    //   411: bipush 93
    //   413: if_icmpne +24 -> 437
    //   416: iload 5
    //   418: invokestatic 214	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   421: aload_3
    //   422: invokestatic 136	kawa/lib/lists:cons	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   425: iconst_1
    //   426: aload 4
    //   428: getstatic 139	gnu/kawa/slib/pregexp:Lit3	Lgnu/math/IntNum;
    //   431: invokestatic 145	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   434: goto -430 -> 4
    //   437: aload_3
    //   438: ldc 56
    //   440: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   443: dup
    //   444: astore 8
    //   446: checkcast 56	gnu/lists/Pair
    //   449: invokestatic 153	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   452: astore 7
    //   454: aload 7
    //   456: invokestatic 416	kawa/lib/characters:isChar	(Ljava/lang/Object;)Z
    //   459: ifeq +80 -> 539
    //   462: getstatic 419	gnu/kawa/slib/pregexp:Lit48	Lgnu/mapping/SimpleSymbol;
    //   465: aload 7
    //   467: aload_0
    //   468: ldc 113
    //   470: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   473: dup
    //   474: astore 8
    //   476: checkcast 113	java/lang/CharSequence
    //   479: iconst_1
    //   480: aload 4
    //   482: getstatic 139	gnu/kawa/slib/pregexp:Lit3	Lgnu/math/IntNum;
    //   485: invokestatic 145	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   488: invokestatic 118	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   491: dup
    //   492: astore 8
    //   494: checkcast 120	java/lang/Number
    //   497: invokevirtual 124	java/lang/Number:intValue	()I
    //   500: invokestatic 130	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)I
    //   503: invokestatic 214	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   506: invokestatic 396	gnu/lists/LList:list3	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   509: aload_3
    //   510: ldc 56
    //   512: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   515: dup
    //   516: astore 8
    //   518: checkcast 56	gnu/lists/Pair
    //   521: invokestatic 75	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   524: invokestatic 136	kawa/lib/lists:cons	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   527: iconst_1
    //   528: aload 4
    //   530: getstatic 232	gnu/kawa/slib/pregexp:Lit11	Lgnu/math/IntNum;
    //   533: invokestatic 145	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   536: goto -532 -> 4
    //   539: iload 5
    //   541: invokestatic 214	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   544: aload_3
    //   545: invokestatic 136	kawa/lib/lists:cons	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   548: iconst_1
    //   549: aload 4
    //   551: getstatic 139	gnu/kawa/slib/pregexp:Lit3	Lgnu/math/IntNum;
    //   554: invokestatic 145	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   557: goto -553 -> 4
    //   560: iload 5
    //   562: invokestatic 214	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   565: aload_3
    //   566: invokestatic 136	kawa/lib/lists:cons	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   569: iconst_1
    //   570: aload 4
    //   572: getstatic 139	gnu/kawa/slib/pregexp:Lit3	Lgnu/math/IntNum;
    //   575: invokestatic 145	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   578: goto -574 -> 4
    //   581: areturn
    //   582: new 66	gnu/mapping/WrongType
    //   585: dup_x1
    //   586: swap
    //   587: ldc 115
    //   589: iconst_1
    //   590: aload 6
    //   592: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   595: athrow
    //   596: new 66	gnu/mapping/WrongType
    //   599: dup_x1
    //   600: swap
    //   601: ldc 115
    //   603: iconst_2
    //   604: aload 6
    //   606: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   609: athrow
    //   610: new 66	gnu/mapping/WrongType
    //   613: dup_x1
    //   614: swap
    //   615: ldc -105
    //   617: iconst_1
    //   618: aload 7
    //   620: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   623: athrow
    //   624: new 66	gnu/mapping/WrongType
    //   627: dup_x1
    //   628: swap
    //   629: ldc 115
    //   631: iconst_1
    //   632: aload 6
    //   634: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   637: athrow
    //   638: new 66	gnu/mapping/WrongType
    //   641: dup_x1
    //   642: swap
    //   643: ldc 115
    //   645: iconst_2
    //   646: aload 6
    //   648: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   651: athrow
    //   652: new 66	gnu/mapping/WrongType
    //   655: dup_x1
    //   656: swap
    //   657: ldc -105
    //   659: iconst_1
    //   660: aload 7
    //   662: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   665: athrow
    //   666: new 66	gnu/mapping/WrongType
    //   669: dup_x1
    //   670: swap
    //   671: ldc 115
    //   673: iconst_1
    //   674: aload 8
    //   676: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   679: athrow
    //   680: new 66	gnu/mapping/WrongType
    //   683: dup_x1
    //   684: swap
    //   685: ldc 115
    //   687: iconst_2
    //   688: aload 8
    //   690: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   693: athrow
    //   694: new 66	gnu/mapping/WrongType
    //   697: dup_x1
    //   698: swap
    //   699: ldc -105
    //   701: iconst_1
    //   702: aload 8
    //   704: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   707: athrow
    //   708: new 66	gnu/mapping/WrongType
    //   711: dup_x1
    //   712: swap
    //   713: ldc 115
    //   715: iconst_1
    //   716: aload 8
    //   718: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   721: athrow
    //   722: new 66	gnu/mapping/WrongType
    //   725: dup_x1
    //   726: swap
    //   727: ldc 115
    //   729: iconst_2
    //   730: aload 8
    //   732: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   735: athrow
    //   736: new 66	gnu/mapping/WrongType
    //   739: dup_x1
    //   740: swap
    //   741: ldc 68
    //   743: iconst_1
    //   744: aload 8
    //   746: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   749: athrow
    // Line number table:
    //   Java source line #335	-> byte code offset #0
    //   Java source line #336	-> byte code offset #0
    //   Java source line #337	-> byte code offset #7
    //   Java source line #338	-> byte code offset #16
    //   Java source line #340	-> byte code offset #39
    //   Java source line #341	-> byte code offset #70
    //   Java source line #342	-> byte code offset #116
    //   Java source line #343	-> byte code offset #123
    //   Java source line #344	-> byte code offset #144
    //   Java source line #347	-> byte code offset #169
    //   Java source line #348	-> byte code offset #178
    //   Java source line #349	-> byte code offset #214
    //   Java source line #361	-> byte code offset #237
    //   Java source line #362	-> byte code offset #278
    //   Java source line #363	-> byte code offset #278
    //   Java source line #364	-> byte code offset #294
    //   Java source line #365	-> byte code offset #314
    //   Java source line #366	-> byte code offset #322
    //   Java source line #350	-> byte code offset #343
    //   Java source line #351	-> byte code offset #362
    //   Java source line #352	-> byte code offset #373
    //   Java source line #353	-> byte code offset #382
    //   Java source line #354	-> byte code offset #416
    //   Java source line #355	-> byte code offset #437
    //   Java source line #356	-> byte code offset #454
    //   Java source line #357	-> byte code offset #462
    //   Java source line #358	-> byte code offset #467
    //   Java source line #359	-> byte code offset #527
    //   Java source line #360	-> byte code offset #539
    //   Java source line #367	-> byte code offset #560
    //   Java source line #340	-> byte code offset #582
    //   Java source line #348	-> byte code offset #610
    //   Java source line #361	-> byte code offset #624
    //   Java source line #364	-> byte code offset #652
    //   Java source line #353	-> byte code offset #666
    //   Java source line #355	-> byte code offset #694
    //   Java source line #358	-> byte code offset #708
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	581	0	s	Object
    //   0	581	1	i	Object
    //   0	581	2	n	Object
    //   6	560	3	r	Object
    //   4	1	4	localObject1	Object
    //   7	564	4	i	Object
    //   68	493	5	c	int
    //   46	12	6	localObject2	Object
    //   176	87	6	char$Mni	Object
    //   292	23	6	posix$Mnchar$Mnclass$Mni	Object
    //   347	300	6	x	boolean
    //   194	109	7	localObject3	Object
    //   371	24	7	i$Pl1	Object
    //   452	209	7	c$Mnprev	Object
    //   389	356	8	localObject4	Object
    //   582	1	15	localClassCastException1	ClassCastException
    //   596	1	16	localClassCastException2	ClassCastException
    //   610	1	17	localClassCastException3	ClassCastException
    //   624	1	18	localClassCastException4	ClassCastException
    //   638	1	19	localClassCastException5	ClassCastException
    //   652	1	20	localClassCastException6	ClassCastException
    //   666	1	21	localClassCastException7	ClassCastException
    //   680	1	22	localClassCastException8	ClassCastException
    //   694	1	23	localClassCastException9	ClassCastException
    //   708	1	24	localClassCastException10	ClassCastException
    //   722	1	25	localClassCastException11	ClassCastException
    //   736	1	26	localClassCastException12	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   48	51	582	java/lang/ClassCastException
    //   59	65	596	java/lang/ClassCastException
    //   196	199	610	java/lang/ClassCastException
    //   246	249	624	java/lang/ClassCastException
    //   264	270	638	java/lang/ClassCastException
    //   304	307	652	java/lang/ClassCastException
    //   391	394	666	java/lang/ClassCastException
    //   402	408	680	java/lang/ClassCastException
    //   446	449	694	java/lang/ClassCastException
    //   476	479	708	java/lang/ClassCastException
    //   494	500	722	java/lang/ClassCastException
    //   518	521	736	java/lang/ClassCastException
  }
  
  /* Error */
  public static Object pregexpReadPosixCharClass(Object s, Object i, Object n)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aload_1
    //   3: getstatic 293	gnu/kawa/slib/pregexp:Lit23	Lgnu/text/Char;
    //   6: invokestatic 107	gnu/lists/LList:list1	(Ljava/lang/Object;)Lgnu/lists/Pair;
    //   9: astore 5
    //   11: astore 4
    //   13: aload 4
    //   15: aload_2
    //   16: invokestatic 96	gnu/kawa/functions/NumberCompare:$Gr$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   19: ifeq +20 -> 39
    //   22: iconst_1
    //   23: anewarray 178	java/lang/Object
    //   26: dup
    //   27: iconst_0
    //   28: getstatic 296	gnu/kawa/slib/pregexp:Lit24	Lgnu/mapping/SimpleSymbol;
    //   31: aastore
    //   32: invokestatic 187	kawa/lib/exceptions:error	([Ljava/lang/Object;)Lgnu/bytecode/Type$NeverReturns;
    //   35: getstatic 193	gnu/expr/Special:reachedUnexpected	Ljava/lang/RuntimeException;
    //   38: athrow
    //   39: aload_0
    //   40: ldc 113
    //   42: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   45: dup
    //   46: astore 7
    //   48: checkcast 113	java/lang/CharSequence
    //   51: aload 4
    //   53: invokestatic 118	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   56: dup
    //   57: astore 7
    //   59: checkcast 120	java/lang/Number
    //   62: invokevirtual 124	java/lang/Number:intValue	()I
    //   65: invokestatic 130	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)I
    //   68: istore 6
    //   70: iload 6
    //   72: bipush 94
    //   74: if_icmpne +19 -> 93
    //   77: iconst_1
    //   78: istore_3
    //   79: iconst_1
    //   80: aload 4
    //   82: getstatic 139	gnu/kawa/slib/pregexp:Lit3	Lgnu/math/IntNum;
    //   85: invokestatic 145	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   88: astore 4
    //   90: goto -77 -> 13
    //   93: iload 6
    //   95: invokestatic 299	kawa/lib/rnrs/unicode:isCharAlphabetic	(I)Z
    //   98: ifeq +25 -> 123
    //   101: iconst_1
    //   102: aload 4
    //   104: getstatic 139	gnu/kawa/slib/pregexp:Lit3	Lgnu/math/IntNum;
    //   107: invokestatic 145	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   110: iload 6
    //   112: invokestatic 214	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   115: aload 5
    //   117: invokestatic 136	kawa/lib/lists:cons	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   120: goto -111 -> 9
    //   123: iload 6
    //   125: bipush 58
    //   127: if_icmpne +145 -> 272
    //   130: iconst_1
    //   131: aload 4
    //   133: getstatic 139	gnu/kawa/slib/pregexp:Lit3	Lgnu/math/IntNum;
    //   136: invokestatic 145	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   139: aload_2
    //   140: invokestatic 96	gnu/kawa/functions/NumberCompare:$Gr$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   143: istore 7
    //   145: iload 7
    //   147: ifeq +11 -> 158
    //   150: iload 7
    //   152: ifeq +64 -> 216
    //   155: goto +44 -> 199
    //   158: aload_0
    //   159: ldc 113
    //   161: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   164: dup
    //   165: astore 8
    //   167: checkcast 113	java/lang/CharSequence
    //   170: iconst_1
    //   171: aload 4
    //   173: getstatic 139	gnu/kawa/slib/pregexp:Lit3	Lgnu/math/IntNum;
    //   176: invokestatic 145	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   179: invokestatic 118	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   182: dup
    //   183: astore 8
    //   185: checkcast 120	java/lang/Number
    //   188: invokevirtual 124	java/lang/Number:intValue	()I
    //   191: invokestatic 130	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)I
    //   194: bipush 93
    //   196: if_icmpeq +20 -> 216
    //   199: iconst_1
    //   200: anewarray 178	java/lang/Object
    //   203: dup
    //   204: iconst_0
    //   205: getstatic 296	gnu/kawa/slib/pregexp:Lit24	Lgnu/mapping/SimpleSymbol;
    //   208: aastore
    //   209: invokestatic 187	kawa/lib/exceptions:error	([Ljava/lang/Object;)Lgnu/bytecode/Type$NeverReturns;
    //   212: getstatic 193	gnu/expr/Special:reachedUnexpected	Ljava/lang/RuntimeException;
    //   215: athrow
    //   216: aload 5
    //   218: invokestatic 133	gnu/kawa/slib/pregexp:pregexpReverse$Ex	(Ljava/lang/Object;)Ljava/lang/Object;
    //   221: ldc 44
    //   223: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   226: dup
    //   227: astore 9
    //   229: checkcast 44	gnu/lists/LList
    //   232: invokestatic 256	kawa/lib/strings:list$To$String	(Lgnu/lists/LList;)Ljava/lang/CharSequence;
    //   235: invokestatic 305	kawa/lib/misc:string$To$Symbol	(Ljava/lang/CharSequence;)Lgnu/mapping/SimpleSymbol;
    //   238: astore 8
    //   240: iload_3
    //   241: ifeq +14 -> 255
    //   244: getstatic 238	gnu/kawa/slib/pregexp:Lit12	Lgnu/mapping/SimpleSymbol;
    //   247: aload 8
    //   249: invokestatic 111	gnu/lists/LList:list2	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   252: goto +5 -> 257
    //   255: aload 8
    //   257: iconst_1
    //   258: aload 4
    //   260: getstatic 232	gnu/kawa/slib/pregexp:Lit11	Lgnu/math/IntNum;
    //   263: invokestatic 145	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   266: invokestatic 111	gnu/lists/LList:list2	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   269: goto +20 -> 289
    //   272: iconst_1
    //   273: anewarray 178	java/lang/Object
    //   276: dup
    //   277: iconst_0
    //   278: getstatic 296	gnu/kawa/slib/pregexp:Lit24	Lgnu/mapping/SimpleSymbol;
    //   281: aastore
    //   282: invokestatic 187	kawa/lib/exceptions:error	([Ljava/lang/Object;)Lgnu/bytecode/Type$NeverReturns;
    //   285: getstatic 193	gnu/expr/Special:reachedUnexpected	Ljava/lang/RuntimeException;
    //   288: athrow
    //   289: areturn
    //   290: new 66	gnu/mapping/WrongType
    //   293: dup_x1
    //   294: swap
    //   295: ldc 115
    //   297: iconst_1
    //   298: aload 7
    //   300: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   303: athrow
    //   304: new 66	gnu/mapping/WrongType
    //   307: dup_x1
    //   308: swap
    //   309: ldc 115
    //   311: iconst_2
    //   312: aload 7
    //   314: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   317: athrow
    //   318: new 66	gnu/mapping/WrongType
    //   321: dup_x1
    //   322: swap
    //   323: ldc 115
    //   325: iconst_1
    //   326: aload 8
    //   328: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   331: athrow
    //   332: new 66	gnu/mapping/WrongType
    //   335: dup_x1
    //   336: swap
    //   337: ldc 115
    //   339: iconst_2
    //   340: aload 8
    //   342: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   345: athrow
    //   346: new 66	gnu/mapping/WrongType
    //   349: dup_x1
    //   350: swap
    //   351: ldc -4
    //   353: iconst_1
    //   354: aload 9
    //   356: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   359: athrow
    // Line number table:
    //   Java source line #179	-> byte code offset #0
    //   Java source line #181	-> byte code offset #0
    //   Java source line #182	-> byte code offset #2
    //   Java source line #183	-> byte code offset #13
    //   Java source line #184	-> byte code offset #22
    //   Java source line #185	-> byte code offset #39
    //   Java source line #186	-> byte code offset #70
    //   Java source line #187	-> byte code offset #77
    //   Java source line #188	-> byte code offset #79
    //   Java source line #189	-> byte code offset #93
    //   Java source line #190	-> byte code offset #101
    //   Java source line #192	-> byte code offset #130
    //   Java source line #193	-> byte code offset #158
    //   Java source line #194	-> byte code offset #199
    //   Java source line #195	-> byte code offset #216
    //   Java source line #196	-> byte code offset #216
    //   Java source line #197	-> byte code offset #216
    //   Java source line #198	-> byte code offset #240
    //   Java source line #202	-> byte code offset #272
    //   Java source line #185	-> byte code offset #290
    //   Java source line #193	-> byte code offset #318
    //   Java source line #197	-> byte code offset #346
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	289	0	s	Object
    //   0	289	1	i	Object
    //   0	289	2	n	Object
    //   1	240	3	neg$Qu	boolean
    //   11	248	4	i	Object
    //   9	1	5	localPair	Pair
    //   13	204	5	r	Object
    //   68	56	6	c	int
    //   46	12	7	localObject1	Object
    //   143	170	7	x	boolean
    //   165	19	8	localObject2	Object
    //   238	103	8	posix$Mnclass	SimpleSymbol
    //   227	128	9	localObject3	Object
    //   290	1	13	localClassCastException1	ClassCastException
    //   304	1	14	localClassCastException2	ClassCastException
    //   318	1	15	localClassCastException3	ClassCastException
    //   332	1	16	localClassCastException4	ClassCastException
    //   346	1	17	localClassCastException5	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   48	51	290	java/lang/ClassCastException
    //   59	65	304	java/lang/ClassCastException
    //   167	170	318	java/lang/ClassCastException
    //   185	191	332	java/lang/ClassCastException
    //   229	232	346	java/lang/ClassCastException
  }
  
  /* Error */
  public static Object pregexpReadClusterType(Object s, Object i, Object n)
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc 113
    //   3: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   6: dup
    //   7: astore 4
    //   9: checkcast 113	java/lang/CharSequence
    //   12: aload_1
    //   13: invokestatic 118	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   16: dup
    //   17: astore 4
    //   19: checkcast 120	java/lang/Number
    //   22: invokevirtual 124	java/lang/Number:intValue	()I
    //   25: invokestatic 130	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)I
    //   28: istore_3
    //   29: iload_3
    //   30: bipush 63
    //   32: if_icmpne +489 -> 521
    //   35: goto +3 -> 38
    //   38: iconst_1
    //   39: aload_1
    //   40: getstatic 139	gnu/kawa/slib/pregexp:Lit3	Lgnu/math/IntNum;
    //   43: invokestatic 145	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   46: astore 4
    //   48: aload_0
    //   49: ldc 113
    //   51: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   54: dup
    //   55: astore 6
    //   57: checkcast 113	java/lang/CharSequence
    //   60: aload 4
    //   62: invokestatic 118	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   65: dup
    //   66: astore 6
    //   68: checkcast 120	java/lang/Number
    //   71: invokevirtual 124	java/lang/Number:intValue	()I
    //   74: invokestatic 130	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)I
    //   77: istore 5
    //   79: iload 5
    //   81: lookupswitch	default:+235->316, 33:+51->132, 58:+69->150, 60:+123->204, 61:+105->186, 62:+87->168
    //   132: getstatic 308	gnu/kawa/slib/pregexp:Lit25	Lgnu/lists/PairWithPosition;
    //   135: iconst_1
    //   136: aload 4
    //   138: getstatic 139	gnu/kawa/slib/pregexp:Lit3	Lgnu/math/IntNum;
    //   141: invokestatic 145	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   144: invokestatic 111	gnu/lists/LList:list2	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   147: goto +384 -> 531
    //   150: getstatic 48	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
    //   153: iconst_1
    //   154: aload 4
    //   156: getstatic 139	gnu/kawa/slib/pregexp:Lit3	Lgnu/math/IntNum;
    //   159: invokestatic 145	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   162: invokestatic 111	gnu/lists/LList:list2	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   165: goto +366 -> 531
    //   168: getstatic 311	gnu/kawa/slib/pregexp:Lit26	Lgnu/lists/PairWithPosition;
    //   171: iconst_1
    //   172: aload 4
    //   174: getstatic 139	gnu/kawa/slib/pregexp:Lit3	Lgnu/math/IntNum;
    //   177: invokestatic 145	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   180: invokestatic 111	gnu/lists/LList:list2	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   183: goto +348 -> 531
    //   186: getstatic 314	gnu/kawa/slib/pregexp:Lit27	Lgnu/lists/PairWithPosition;
    //   189: iconst_1
    //   190: aload 4
    //   192: getstatic 139	gnu/kawa/slib/pregexp:Lit3	Lgnu/math/IntNum;
    //   195: invokestatic 145	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   198: invokestatic 111	gnu/lists/LList:list2	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   201: goto +330 -> 531
    //   204: aload_0
    //   205: ldc 113
    //   207: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   210: dup
    //   211: astore 7
    //   213: checkcast 113	java/lang/CharSequence
    //   216: iconst_1
    //   217: aload 4
    //   219: getstatic 139	gnu/kawa/slib/pregexp:Lit3	Lgnu/math/IntNum;
    //   222: invokestatic 145	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   225: invokestatic 118	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   228: dup
    //   229: astore 7
    //   231: checkcast 120	java/lang/Number
    //   234: invokevirtual 124	java/lang/Number:intValue	()I
    //   237: invokestatic 130	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)I
    //   240: istore 6
    //   242: iload 6
    //   244: lookupswitch	default:+40->284, 33:+28->272, 61:+34->278
    //   272: getstatic 317	gnu/kawa/slib/pregexp:Lit28	Lgnu/lists/PairWithPosition;
    //   275: goto +26 -> 301
    //   278: getstatic 320	gnu/kawa/slib/pregexp:Lit29	Lgnu/lists/PairWithPosition;
    //   281: goto +20 -> 301
    //   284: iconst_1
    //   285: anewarray 178	java/lang/Object
    //   288: dup
    //   289: iconst_0
    //   290: getstatic 323	gnu/kawa/slib/pregexp:Lit30	Lgnu/mapping/SimpleSymbol;
    //   293: aastore
    //   294: invokestatic 187	kawa/lib/exceptions:error	([Ljava/lang/Object;)Lgnu/bytecode/Type$NeverReturns;
    //   297: getstatic 193	gnu/expr/Special:reachedUnexpected	Ljava/lang/RuntimeException;
    //   300: athrow
    //   301: iconst_1
    //   302: aload 4
    //   304: getstatic 232	gnu/kawa/slib/pregexp:Lit11	Lgnu/math/IntNum;
    //   307: invokestatic 145	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   310: invokestatic 111	gnu/lists/LList:list2	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   313: goto +218 -> 531
    //   316: aload 4
    //   318: getstatic 48	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
    //   321: iconst_0
    //   322: istore 8
    //   324: astore 7
    //   326: astore 6
    //   328: aload_0
    //   329: ldc 113
    //   331: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   334: dup
    //   335: astore 10
    //   337: checkcast 113	java/lang/CharSequence
    //   340: aload 6
    //   342: invokestatic 118	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   345: dup
    //   346: astore 10
    //   348: checkcast 120	java/lang/Number
    //   351: invokevirtual 124	java/lang/Number:intValue	()I
    //   354: invokestatic 130	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)I
    //   357: istore 9
    //   359: iload 9
    //   361: lookupswitch	default:+143->504, 45:+126->487, 58:+43->404, 105:+94->455, 120:+60->421
    //   404: aload 7
    //   406: iconst_1
    //   407: aload 6
    //   409: getstatic 139	gnu/kawa/slib/pregexp:Lit3	Lgnu/math/IntNum;
    //   412: invokestatic 145	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   415: invokestatic 111	gnu/lists/LList:list2	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   418: goto +113 -> 531
    //   421: iload 8
    //   423: ifeq +9 -> 432
    //   426: getstatic 38	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   429: goto +6 -> 435
    //   432: getstatic 217	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   435: putstatic 42	gnu/kawa/slib/pregexp:$Stpregexp$Mnspace$Mnsensitive$Qu$St	Ljava/lang/Object;
    //   438: iconst_1
    //   439: aload 6
    //   441: getstatic 139	gnu/kawa/slib/pregexp:Lit3	Lgnu/math/IntNum;
    //   444: invokestatic 145	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   447: iconst_0
    //   448: istore 8
    //   450: astore 6
    //   452: goto -124 -> 328
    //   455: iconst_1
    //   456: aload 6
    //   458: getstatic 139	gnu/kawa/slib/pregexp:Lit3	Lgnu/math/IntNum;
    //   461: invokestatic 145	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   464: iload 8
    //   466: ifeq +9 -> 475
    //   469: getstatic 326	gnu/kawa/slib/pregexp:Lit31	Lgnu/mapping/SimpleSymbol;
    //   472: goto +6 -> 478
    //   475: getstatic 329	gnu/kawa/slib/pregexp:Lit32	Lgnu/mapping/SimpleSymbol;
    //   478: aload 7
    //   480: invokestatic 136	kawa/lib/lists:cons	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   483: iconst_0
    //   484: goto -162 -> 322
    //   487: iconst_1
    //   488: aload 6
    //   490: getstatic 139	gnu/kawa/slib/pregexp:Lit3	Lgnu/math/IntNum;
    //   493: invokestatic 145	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   496: iconst_1
    //   497: istore 8
    //   499: astore 6
    //   501: goto -173 -> 328
    //   504: iconst_1
    //   505: anewarray 178	java/lang/Object
    //   508: dup
    //   509: iconst_0
    //   510: getstatic 323	gnu/kawa/slib/pregexp:Lit30	Lgnu/mapping/SimpleSymbol;
    //   513: aastore
    //   514: invokestatic 187	kawa/lib/exceptions:error	([Ljava/lang/Object;)Lgnu/bytecode/Type$NeverReturns;
    //   517: getstatic 193	gnu/expr/Special:reachedUnexpected	Ljava/lang/RuntimeException;
    //   520: athrow
    //   521: getstatic 332	gnu/kawa/slib/pregexp:Lit33	Lgnu/lists/PairWithPosition;
    //   524: aload_1
    //   525: invokestatic 111	gnu/lists/LList:list2	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   528: goto +3 -> 531
    //   531: areturn
    //   532: new 66	gnu/mapping/WrongType
    //   535: dup_x1
    //   536: swap
    //   537: ldc 115
    //   539: iconst_1
    //   540: aload 4
    //   542: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   545: athrow
    //   546: new 66	gnu/mapping/WrongType
    //   549: dup_x1
    //   550: swap
    //   551: ldc 115
    //   553: iconst_2
    //   554: aload 4
    //   556: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   559: athrow
    //   560: new 66	gnu/mapping/WrongType
    //   563: dup_x1
    //   564: swap
    //   565: ldc 115
    //   567: iconst_1
    //   568: aload 6
    //   570: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   573: athrow
    //   574: new 66	gnu/mapping/WrongType
    //   577: dup_x1
    //   578: swap
    //   579: ldc 115
    //   581: iconst_2
    //   582: aload 6
    //   584: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   587: athrow
    //   588: new 66	gnu/mapping/WrongType
    //   591: dup_x1
    //   592: swap
    //   593: ldc 115
    //   595: iconst_1
    //   596: aload 7
    //   598: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   601: athrow
    //   602: new 66	gnu/mapping/WrongType
    //   605: dup_x1
    //   606: swap
    //   607: ldc 115
    //   609: iconst_2
    //   610: aload 7
    //   612: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   615: athrow
    //   616: new 66	gnu/mapping/WrongType
    //   619: dup_x1
    //   620: swap
    //   621: ldc 115
    //   623: iconst_1
    //   624: aload 10
    //   626: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   629: athrow
    //   630: new 66	gnu/mapping/WrongType
    //   633: dup_x1
    //   634: swap
    //   635: ldc 115
    //   637: iconst_2
    //   638: aload 10
    //   640: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   643: athrow
    // Line number table:
    //   Java source line #205	-> byte code offset #0
    //   Java source line #207	-> byte code offset #0
    //   Java source line #208	-> byte code offset #29
    //   Java source line #210	-> byte code offset #38
    //   Java source line #211	-> byte code offset #48
    //   Java source line #217	-> byte code offset #204
    //   Java source line #222	-> byte code offset #316
    //   Java source line #223	-> byte code offset #328
    //   Java source line #224	-> byte code offset #359
    //   Java source line #230	-> byte code offset #421
    //   Java source line #231	-> byte code offset #438
    //   Java source line #226	-> byte code offset #455
    //   Java source line #227	-> byte code offset #464
    //   Java source line #228	-> byte code offset #478
    //   Java source line #225	-> byte code offset #487
    //   Java source line #207	-> byte code offset #532
    //   Java source line #211	-> byte code offset #560
    //   Java source line #217	-> byte code offset #588
    //   Java source line #223	-> byte code offset #616
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	531	0	s	Object
    //   0	531	1	i	Object
    //   0	531	2	n	Object
    //   28	2	3	c	int
    //   7	11	4	localObject1	Object
    //   46	509	4	i	Object
    //   77	3	5	tmp	int
    //   55	12	6	localObject2	Object
    //   240	3	6	tmp	int
    //   326	257	6	i	Object
    //   211	114	7	localObject3	Object
    //   328	283	7	r	Object
    //   322	1	8	i	int
    //   328	170	8	inv$Qu	boolean
    //   357	3	9	c	int
    //   335	304	10	localObject4	Object
    //   532	1	16	localClassCastException1	ClassCastException
    //   546	1	17	localClassCastException2	ClassCastException
    //   560	1	18	localClassCastException3	ClassCastException
    //   574	1	19	localClassCastException4	ClassCastException
    //   588	1	20	localClassCastException5	ClassCastException
    //   602	1	21	localClassCastException6	ClassCastException
    //   616	1	22	localClassCastException7	ClassCastException
    //   630	1	23	localClassCastException8	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   9	12	532	java/lang/ClassCastException
    //   19	25	546	java/lang/ClassCastException
    //   57	60	560	java/lang/ClassCastException
    //   68	74	574	java/lang/ClassCastException
    //   213	216	588	java/lang/ClassCastException
    //   231	237	602	java/lang/ClassCastException
    //   337	340	616	java/lang/ClassCastException
    //   348	354	630	java/lang/ClassCastException
  }
  
  /* Error */
  public static Object pregexpReadNums(Object s, Object i, Object n)
  {
    // Byte code:
    //   0: getstatic 48	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
    //   3: getstatic 48	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
    //   6: aload_1
    //   7: getstatic 139	gnu/kawa/slib/pregexp:Lit3	Lgnu/math/IntNum;
    //   10: astore 6
    //   12: astore 5
    //   14: astore 4
    //   16: astore_3
    //   17: aload 5
    //   19: aload_2
    //   20: invokestatic 96	gnu/kawa/functions/NumberCompare:$Gr$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   23: ifeq +20 -> 43
    //   26: iconst_1
    //   27: anewarray 178	java/lang/Object
    //   30: dup
    //   31: iconst_0
    //   32: getstatic 389	gnu/kawa/slib/pregexp:Lit43	Lgnu/mapping/SimpleSymbol;
    //   35: aastore
    //   36: invokestatic 187	kawa/lib/exceptions:error	([Ljava/lang/Object;)Lgnu/bytecode/Type$NeverReturns;
    //   39: getstatic 193	gnu/expr/Special:reachedUnexpected	Ljava/lang/RuntimeException;
    //   42: athrow
    //   43: aload_0
    //   44: ldc 113
    //   46: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   49: dup
    //   50: astore 8
    //   52: checkcast 113	java/lang/CharSequence
    //   55: aload 5
    //   57: invokestatic 118	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   60: dup
    //   61: astore 8
    //   63: checkcast 120	java/lang/Number
    //   66: invokevirtual 124	java/lang/Number:intValue	()I
    //   69: invokestatic 130	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)I
    //   72: istore 7
    //   74: iload 7
    //   76: invokestatic 250	kawa/lib/rnrs/unicode:isCharNumeric	(I)Z
    //   79: ifeq +74 -> 153
    //   82: aload 6
    //   84: getstatic 139	gnu/kawa/slib/pregexp:Lit3	Lgnu/math/IntNum;
    //   87: invokestatic 392	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   90: ifeq +32 -> 122
    //   93: iload 7
    //   95: invokestatic 214	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   98: aload_3
    //   99: invokestatic 136	kawa/lib/lists:cons	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   102: iconst_1
    //   103: aload 5
    //   105: getstatic 139	gnu/kawa/slib/pregexp:Lit3	Lgnu/math/IntNum;
    //   108: invokestatic 145	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   111: getstatic 139	gnu/kawa/slib/pregexp:Lit3	Lgnu/math/IntNum;
    //   114: astore 6
    //   116: astore 5
    //   118: astore_3
    //   119: goto -102 -> 17
    //   122: iload 7
    //   124: invokestatic 214	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   127: aload 4
    //   129: invokestatic 136	kawa/lib/lists:cons	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   132: iconst_1
    //   133: aload 5
    //   135: getstatic 139	gnu/kawa/slib/pregexp:Lit3	Lgnu/math/IntNum;
    //   138: invokestatic 145	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   141: getstatic 232	gnu/kawa/slib/pregexp:Lit11	Lgnu/math/IntNum;
    //   144: astore 6
    //   146: astore 5
    //   148: astore 4
    //   150: goto -133 -> 17
    //   153: iload 7
    //   155: invokestatic 244	kawa/lib/rnrs/unicode:isCharWhitespace	(I)Z
    //   158: ifeq +26 -> 184
    //   161: getstatic 42	gnu/kawa/slib/pregexp:$Stpregexp$Mnspace$Mnsensitive$Qu$St	Ljava/lang/Object;
    //   164: invokestatic 170	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   167: ifne +17 -> 184
    //   170: iconst_1
    //   171: aload 5
    //   173: getstatic 139	gnu/kawa/slib/pregexp:Lit3	Lgnu/math/IntNum;
    //   176: invokestatic 145	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   179: astore 5
    //   181: goto -164 -> 17
    //   184: iload 7
    //   186: bipush 44
    //   188: if_icmpne +33 -> 221
    //   191: aload 6
    //   193: getstatic 139	gnu/kawa/slib/pregexp:Lit3	Lgnu/math/IntNum;
    //   196: invokestatic 392	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   199: ifeq +22 -> 221
    //   202: iconst_1
    //   203: aload 5
    //   205: getstatic 139	gnu/kawa/slib/pregexp:Lit3	Lgnu/math/IntNum;
    //   208: invokestatic 145	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   211: getstatic 232	gnu/kawa/slib/pregexp:Lit11	Lgnu/math/IntNum;
    //   214: astore 6
    //   216: astore 5
    //   218: goto -201 -> 17
    //   221: iload 7
    //   223: bipush 125
    //   225: if_icmpne +118 -> 343
    //   228: aload_3
    //   229: invokestatic 133	gnu/kawa/slib/pregexp:pregexpReverse$Ex	(Ljava/lang/Object;)Ljava/lang/Object;
    //   232: ldc 44
    //   234: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   237: dup
    //   238: astore 9
    //   240: checkcast 44	gnu/lists/LList
    //   243: invokestatic 256	kawa/lib/strings:list$To$String	(Lgnu/lists/LList;)Ljava/lang/CharSequence;
    //   246: invokestatic 262	kawa/lib/numbers:string$To$Number	(Ljava/lang/CharSequence;)Ljava/lang/Object;
    //   249: astore 8
    //   251: aload 4
    //   253: invokestatic 133	gnu/kawa/slib/pregexp:pregexpReverse$Ex	(Ljava/lang/Object;)Ljava/lang/Object;
    //   256: ldc 44
    //   258: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   261: dup
    //   262: astore 10
    //   264: checkcast 44	gnu/lists/LList
    //   267: invokestatic 256	kawa/lib/strings:list$To$String	(Lgnu/lists/LList;)Ljava/lang/CharSequence;
    //   270: invokestatic 262	kawa/lib/numbers:string$To$Number	(Ljava/lang/CharSequence;)Ljava/lang/Object;
    //   273: astore 9
    //   275: aload 8
    //   277: invokestatic 170	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   280: ifne +28 -> 308
    //   283: aload 6
    //   285: getstatic 139	gnu/kawa/slib/pregexp:Lit3	Lgnu/math/IntNum;
    //   288: invokestatic 392	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   291: ifeq +17 -> 308
    //   294: getstatic 368	gnu/kawa/slib/pregexp:Lit40	Lgnu/math/IntNum;
    //   297: getstatic 217	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   300: aload 5
    //   302: invokestatic 396	gnu/lists/LList:list3	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   305: goto +41 -> 346
    //   308: aload 6
    //   310: getstatic 139	gnu/kawa/slib/pregexp:Lit3	Lgnu/math/IntNum;
    //   313: invokestatic 392	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   316: ifeq +15 -> 331
    //   319: aload 8
    //   321: aload 8
    //   323: aload 5
    //   325: invokestatic 396	gnu/lists/LList:list3	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   328: goto +18 -> 346
    //   331: aload 8
    //   333: aload 9
    //   335: aload 5
    //   337: invokestatic 396	gnu/lists/LList:list3	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   340: goto +6 -> 346
    //   343: getstatic 217	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   346: areturn
    //   347: new 66	gnu/mapping/WrongType
    //   350: dup_x1
    //   351: swap
    //   352: ldc 115
    //   354: iconst_1
    //   355: aload 8
    //   357: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   360: athrow
    //   361: new 66	gnu/mapping/WrongType
    //   364: dup_x1
    //   365: swap
    //   366: ldc 115
    //   368: iconst_2
    //   369: aload 8
    //   371: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   374: athrow
    //   375: new 66	gnu/mapping/WrongType
    //   378: dup_x1
    //   379: swap
    //   380: ldc -4
    //   382: iconst_1
    //   383: aload 9
    //   385: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   388: athrow
    //   389: new 66	gnu/mapping/WrongType
    //   392: dup_x1
    //   393: swap
    //   394: ldc -4
    //   396: iconst_1
    //   397: aload 10
    //   399: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   402: athrow
    // Line number table:
    //   Java source line #305	-> byte code offset #0
    //   Java source line #308	-> byte code offset #0
    //   Java source line #309	-> byte code offset #17
    //   Java source line #310	-> byte code offset #43
    //   Java source line #311	-> byte code offset #74
    //   Java source line #312	-> byte code offset #82
    //   Java source line #313	-> byte code offset #93
    //   Java source line #314	-> byte code offset #122
    //   Java source line #315	-> byte code offset #153
    //   Java source line #316	-> byte code offset #170
    //   Java source line #317	-> byte code offset #191
    //   Java source line #318	-> byte code offset #202
    //   Java source line #320	-> byte code offset #228
    //   Java source line #321	-> byte code offset #251
    //   Java source line #322	-> byte code offset #275
    //   Java source line #323	-> byte code offset #308
    //   Java source line #324	-> byte code offset #331
    //   Java source line #310	-> byte code offset #347
    //   Java source line #320	-> byte code offset #375
    //   Java source line #321	-> byte code offset #389
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	346	0	s	Object
    //   0	346	1	i	Object
    //   0	346	2	n	Object
    //   16	213	3	p	Object
    //   14	1	4	localEmptyList	EmptyList
    //   17	235	4	q	Object
    //   12	1	5	localObject1	Object
    //   17	319	5	k	Object
    //   10	1	6	localIntNum	IntNum
    //   17	292	6	reading	Object
    //   72	150	7	c	int
    //   50	200	8	localObject2	Object
    //   275	95	8	p	Object
    //   238	1	9	localObject3	Object
    //   273	111	9	q	Object
    //   262	136	10	localObject4	Object
    //   347	1	16	localClassCastException1	ClassCastException
    //   361	1	17	localClassCastException2	ClassCastException
    //   375	1	18	localClassCastException3	ClassCastException
    //   389	1	19	localClassCastException4	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   52	55	347	java/lang/ClassCastException
    //   63	69	361	java/lang/ClassCastException
    //   240	243	375	java/lang/ClassCastException
    //   264	267	389	java/lang/ClassCastException
  }
  
  /* Error */
  public static Object pregexpInvertCharList(Object vv)
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc 56
    //   3: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   6: dup
    //   7: astore_1
    //   8: checkcast 56	gnu/lists/Pair
    //   11: invokestatic 153	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   14: ldc 56
    //   16: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   19: dup
    //   20: astore_1
    //   21: checkcast 56	gnu/lists/Pair
    //   24: getstatic 399	gnu/kawa/slib/pregexp:Lit44	Lgnu/mapping/SimpleSymbol;
    //   27: invokestatic 371	kawa/lib/lists:setCar$Ex	(Lgnu/lists/Pair;Ljava/lang/Object;)V
    //   30: aload_0
    //   31: areturn
    //   32: new 66	gnu/mapping/WrongType
    //   35: dup_x1
    //   36: swap
    //   37: ldc -105
    //   39: iconst_1
    //   40: aload_1
    //   41: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   44: athrow
    //   45: new 66	gnu/mapping/WrongType
    //   48: dup_x1
    //   49: swap
    //   50: ldc_w 365
    //   53: iconst_1
    //   54: aload_1
    //   55: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   58: athrow
    // Line number table:
    //   Java source line #328	-> byte code offset #0
    //   Java source line #329	-> byte code offset #0
    //   Java source line #330	-> byte code offset #30
    //   Java source line #329	-> byte code offset #32
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	31	0	vv	Object
    //   7	48	1	localObject	Object
    //   32	1	2	localClassCastException1	ClassCastException
    //   45	1	3	localClassCastException2	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   8	11	32	java/lang/ClassCastException
    //   21	24	45	java/lang/ClassCastException
  }
  
  /* Error */
  public static Object pregexpStringMatch(Object s1, Object s, Object i, Object n, Object sk, Object fk)
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc 113
    //   3: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   6: dup
    //   7: astore 7
    //   9: checkcast 113	java/lang/CharSequence
    //   12: invokestatic 425	kawa/lib/strings:stringLength	(Ljava/lang/CharSequence;)I
    //   15: istore 6
    //   17: iload 6
    //   19: invokestatic 431	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   22: aload_3
    //   23: invokestatic 434	gnu/kawa/functions/NumberCompare:$Gr	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   26: ifeq +14 -> 40
    //   29: getstatic 440	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   32: aload 5
    //   34: invokevirtual 445	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   37: goto +136 -> 173
    //   40: getstatic 368	gnu/kawa/slib/pregexp:Lit40	Lgnu/math/IntNum;
    //   43: aload_2
    //   44: astore 8
    //   46: astore 7
    //   48: aload 7
    //   50: iload 6
    //   52: i2l
    //   53: invokestatic 451	gnu/math/IntNum:compare	(Lgnu/math/IntNum;J)I
    //   56: iflt +16 -> 72
    //   59: getstatic 440	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   62: aload 4
    //   64: aload 8
    //   66: invokevirtual 454	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   69: goto +104 -> 173
    //   72: aload 8
    //   74: aload_3
    //   75: invokestatic 96	gnu/kawa/functions/NumberCompare:$Gr$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   78: ifeq +14 -> 92
    //   81: getstatic 440	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   84: aload 5
    //   86: invokevirtual 445	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   89: goto +84 -> 173
    //   92: aload_0
    //   93: ldc 113
    //   95: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   98: dup
    //   99: astore 9
    //   101: checkcast 113	java/lang/CharSequence
    //   104: aload 7
    //   106: dup
    //   107: astore 9
    //   109: invokevirtual 124	java/lang/Number:intValue	()I
    //   112: invokestatic 130	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)I
    //   115: aload_1
    //   116: ldc 113
    //   118: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   121: dup
    //   122: astore 9
    //   124: checkcast 113	java/lang/CharSequence
    //   127: aload 8
    //   129: invokestatic 118	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   132: dup
    //   133: astore 9
    //   135: checkcast 120	java/lang/Number
    //   138: invokevirtual 124	java/lang/Number:intValue	()I
    //   141: invokestatic 130	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)I
    //   144: if_icmpne +21 -> 165
    //   147: aload 7
    //   149: iconst_1
    //   150: invokestatic 458	gnu/math/IntNum:add	(Lgnu/math/IntNum;I)Lgnu/math/IntNum;
    //   153: iconst_1
    //   154: aload 8
    //   156: getstatic 139	gnu/kawa/slib/pregexp:Lit3	Lgnu/math/IntNum;
    //   159: invokestatic 145	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   162: goto -118 -> 44
    //   165: getstatic 440	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   168: aload 5
    //   170: invokevirtual 445	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   173: areturn
    //   174: new 66	gnu/mapping/WrongType
    //   177: dup_x1
    //   178: swap
    //   179: ldc_w 421
    //   182: iconst_1
    //   183: aload 7
    //   185: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   188: athrow
    //   189: new 66	gnu/mapping/WrongType
    //   192: dup_x1
    //   193: swap
    //   194: ldc 115
    //   196: iconst_1
    //   197: aload 9
    //   199: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   202: athrow
    //   203: new 66	gnu/mapping/WrongType
    //   206: dup_x1
    //   207: swap
    //   208: ldc 115
    //   210: iconst_2
    //   211: aload 9
    //   213: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   216: athrow
    //   217: new 66	gnu/mapping/WrongType
    //   220: dup_x1
    //   221: swap
    //   222: ldc 115
    //   224: iconst_1
    //   225: aload 9
    //   227: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   230: athrow
    //   231: new 66	gnu/mapping/WrongType
    //   234: dup_x1
    //   235: swap
    //   236: ldc 115
    //   238: iconst_2
    //   239: aload 9
    //   241: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   244: athrow
    // Line number table:
    //   Java source line #373	-> byte code offset #0
    //   Java source line #374	-> byte code offset #0
    //   Java source line #375	-> byte code offset #17
    //   Java source line #376	-> byte code offset #40
    //   Java source line #377	-> byte code offset #48
    //   Java source line #378	-> byte code offset #72
    //   Java source line #379	-> byte code offset #92
    //   Java source line #380	-> byte code offset #147
    //   Java source line #381	-> byte code offset #165
    //   Java source line #374	-> byte code offset #174
    //   Java source line #379	-> byte code offset #189
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	173	0	s1	Object
    //   0	173	1	s	Object
    //   0	173	2	i	Object
    //   0	173	3	n	Object
    //   0	173	4	sk	Object
    //   0	173	5	fk	Object
    //   15	36	6	n1	int
    //   7	1	7	localObject1	Object
    //   46	138	7	j	IntNum
    //   44	1	8	localObject2	Object
    //   48	107	8	k	Object
    //   99	141	9	localObject3	Object
    //   174	1	12	localClassCastException1	ClassCastException
    //   189	1	13	localClassCastException2	ClassCastException
    //   203	1	14	localClassCastException3	ClassCastException
    //   217	1	15	localClassCastException4	ClassCastException
    //   231	1	16	localClassCastException5	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   9	12	174	java/lang/ClassCastException
    //   101	104	189	java/lang/ClassCastException
    //   109	112	203	java/lang/ClassCastException
    //   124	127	217	java/lang/ClassCastException
    //   135	141	231	java/lang/ClassCastException
  }
  
  /* Error */
  public static boolean isPregexpCharWord(Object c)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 118	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   4: dup
    //   5: astore_2
    //   6: invokestatic 462	gnu/text/Char:castToCharacter	(Ljava/lang/Object;)I
    //   9: invokestatic 299	kawa/lib/rnrs/unicode:isCharAlphabetic	(I)Z
    //   12: istore_1
    //   13: iload_1
    //   14: ifeq +7 -> 21
    //   17: iload_1
    //   18: goto +41 -> 59
    //   21: aload_0
    //   22: invokestatic 118	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   25: dup
    //   26: astore_3
    //   27: invokestatic 462	gnu/text/Char:castToCharacter	(Ljava/lang/Object;)I
    //   30: invokestatic 250	kawa/lib/rnrs/unicode:isCharNumeric	(I)Z
    //   33: istore_2
    //   34: iload_2
    //   35: ifeq +7 -> 42
    //   38: iload_2
    //   39: goto +20 -> 59
    //   42: aload_0
    //   43: invokestatic 118	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   46: invokestatic 462	gnu/text/Char:castToCharacter	(Ljava/lang/Object;)I
    //   49: bipush 95
    //   51: if_icmpne +7 -> 58
    //   54: iconst_1
    //   55: goto +4 -> 59
    //   58: iconst_0
    //   59: ireturn
    //   60: new 66	gnu/mapping/WrongType
    //   63: dup_x1
    //   64: swap
    //   65: ldc_w 464
    //   68: iconst_1
    //   69: aload_2
    //   70: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   73: athrow
    //   74: new 66	gnu/mapping/WrongType
    //   77: dup_x1
    //   78: swap
    //   79: ldc_w 466
    //   82: iconst_1
    //   83: aload_3
    //   84: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   87: athrow
    // Line number table:
    //   Java source line #384	-> byte code offset #0
    //   Java source line #387	-> byte code offset #0
    //   Java source line #388	-> byte code offset #21
    //   Java source line #387	-> byte code offset #34
    //   Java source line #389	-> byte code offset #42
    //   Java source line #387	-> byte code offset #60
    //   Java source line #388	-> byte code offset #74
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	59	0	c	Object
    //   12	6	1	x	boolean
    //   5	1	2	localObject1	Object
    //   33	37	2	x	boolean
    //   26	58	3	localObject2	Object
    //   60	1	5	localClassCastException1	ClassCastException
    //   74	1	6	localClassCastException2	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   6	9	60	java/lang/ClassCastException
    //   27	30	74	java/lang/ClassCastException
  }
  
  /* Error */
  public static boolean isPregexpAtWordBoundary(Object s, Object i, Object n)
  {
    // Byte code:
    //   0: aload_1
    //   1: getstatic 368	gnu/kawa/slib/pregexp:Lit40	Lgnu/math/IntNum;
    //   4: invokestatic 392	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   7: istore_3
    //   8: iload_3
    //   9: ifeq +7 -> 16
    //   12: iload_3
    //   13: goto +155 -> 168
    //   16: aload_1
    //   17: aload_2
    //   18: invokestatic 96	gnu/kawa/functions/NumberCompare:$Gr$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   21: istore 4
    //   23: iload 4
    //   25: ifeq +8 -> 33
    //   28: iload 4
    //   30: goto +138 -> 168
    //   33: aload_0
    //   34: ldc 113
    //   36: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   39: dup
    //   40: astore 6
    //   42: checkcast 113	java/lang/CharSequence
    //   45: aload_1
    //   46: invokestatic 118	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   49: dup
    //   50: astore 6
    //   52: checkcast 120	java/lang/Number
    //   55: invokevirtual 124	java/lang/Number:intValue	()I
    //   58: invokestatic 130	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)I
    //   61: istore 5
    //   63: aload_0
    //   64: ldc 113
    //   66: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   69: dup
    //   70: astore 7
    //   72: checkcast 113	java/lang/CharSequence
    //   75: iconst_m1
    //   76: aload_1
    //   77: getstatic 139	gnu/kawa/slib/pregexp:Lit3	Lgnu/math/IntNum;
    //   80: invokestatic 145	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   83: invokestatic 118	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   86: dup
    //   87: astore 7
    //   89: checkcast 120	java/lang/Number
    //   92: invokevirtual 124	java/lang/Number:intValue	()I
    //   95: invokestatic 130	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)I
    //   98: istore 6
    //   100: iload 5
    //   102: invokestatic 214	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   105: getstatic 265	gnu/kawa/slib/pregexp:Lit14	Lgnu/mapping/SimpleSymbol;
    //   108: invokestatic 469	gnu/kawa/slib/pregexp:isPregexpCheckIfInCharClass	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   111: istore 7
    //   113: iload 6
    //   115: invokestatic 214	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   118: getstatic 265	gnu/kawa/slib/pregexp:Lit14	Lgnu/mapping/SimpleSymbol;
    //   121: invokestatic 469	gnu/kawa/slib/pregexp:isPregexpCheckIfInCharClass	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   124: istore 8
    //   126: iload 7
    //   128: ifeq +16 -> 144
    //   131: iload 8
    //   133: ifeq +7 -> 140
    //   136: iconst_0
    //   137: goto +8 -> 145
    //   140: iconst_1
    //   141: goto +4 -> 145
    //   144: iconst_0
    //   145: istore 9
    //   147: iload 9
    //   149: ifeq +8 -> 157
    //   152: iload 9
    //   154: goto +14 -> 168
    //   157: iload 7
    //   159: ifne +8 -> 167
    //   162: iload 8
    //   164: goto +4 -> 168
    //   167: iconst_0
    //   168: ireturn
    //   169: new 66	gnu/mapping/WrongType
    //   172: dup_x1
    //   173: swap
    //   174: ldc 115
    //   176: iconst_1
    //   177: aload 6
    //   179: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   182: athrow
    //   183: new 66	gnu/mapping/WrongType
    //   186: dup_x1
    //   187: swap
    //   188: ldc 115
    //   190: iconst_2
    //   191: aload 6
    //   193: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   196: athrow
    //   197: new 66	gnu/mapping/WrongType
    //   200: dup_x1
    //   201: swap
    //   202: ldc 115
    //   204: iconst_1
    //   205: aload 7
    //   207: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   210: athrow
    //   211: new 66	gnu/mapping/WrongType
    //   214: dup_x1
    //   215: swap
    //   216: ldc 115
    //   218: iconst_2
    //   219: aload 7
    //   221: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   224: athrow
    // Line number table:
    //   Java source line #392	-> byte code offset #0
    //   Java source line #393	-> byte code offset #0
    //   Java source line #394	-> byte code offset #33
    //   Java source line #395	-> byte code offset #63
    //   Java source line #396	-> byte code offset #100
    //   Java source line #397	-> byte code offset #100
    //   Java source line #398	-> byte code offset #113
    //   Java source line #399	-> byte code offset #113
    //   Java source line #400	-> byte code offset #126
    //   Java source line #401	-> byte code offset #157
    //   Java source line #394	-> byte code offset #169
    //   Java source line #395	-> byte code offset #197
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	168	0	s	Object
    //   0	168	1	i	Object
    //   0	168	2	n	Object
    //   7	6	3	x	boolean
    //   21	8	4	x	boolean
    //   61	1	5	i	int
    //   100	1	5	c$Sli	int
    //   40	11	6	localObject1	Object
    //   98	94	6	c$Sli$Mn1	int
    //   70	18	7	localObject2	Object
    //   111	1	7	bool1	boolean
    //   126	94	7	c$Sli$Slw$Qu	boolean
    //   124	39	8	c$Sli$Mn1$Slw$Qu	boolean
    //   145	8	9	x	boolean
    //   169	1	14	localClassCastException1	ClassCastException
    //   183	1	15	localClassCastException2	ClassCastException
    //   197	1	16	localClassCastException3	ClassCastException
    //   211	1	17	localClassCastException4	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   42	45	169	java/lang/ClassCastException
    //   52	58	183	java/lang/ClassCastException
    //   72	75	197	java/lang/ClassCastException
    //   89	95	211	java/lang/ClassCastException
  }
  
  /* Error */
  public static Object lambda1sub(Object re)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 529	kawa/lib/lists:isPair	(Ljava/lang/Object;)Z
    //   4: ifeq +81 -> 85
    //   7: aload_0
    //   8: ldc 56
    //   10: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   13: dup
    //   14: astore_2
    //   15: checkcast 56	gnu/lists/Pair
    //   18: invokestatic 153	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   21: astore_1
    //   22: aload_0
    //   23: ldc 56
    //   25: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   28: dup
    //   29: astore_3
    //   30: checkcast 56	gnu/lists/Pair
    //   33: invokestatic 75	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   36: invokestatic 526	gnu/kawa/slib/pregexp:lambda1sub	(Ljava/lang/Object;)Ljava/lang/Object;
    //   39: astore_2
    //   40: aload_1
    //   41: getstatic 532	gnu/kawa/slib/pregexp:Lit61	Lgnu/mapping/SimpleSymbol;
    //   44: invokestatic 229	gnu/kawa/functions/IsEqv:apply	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   47: ifeq +17 -> 64
    //   50: aload_0
    //   51: getstatic 217	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   54: invokestatic 136	kawa/lib/lists:cons	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   57: aload_2
    //   58: invokestatic 136	kawa/lib/lists:cons	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   61: goto +27 -> 88
    //   64: iconst_2
    //   65: anewarray 178	java/lang/Object
    //   68: dup
    //   69: iconst_0
    //   70: aload_1
    //   71: invokestatic 526	gnu/kawa/slib/pregexp:lambda1sub	(Ljava/lang/Object;)Ljava/lang/Object;
    //   74: aastore
    //   75: dup
    //   76: iconst_1
    //   77: aload_2
    //   78: aastore
    //   79: invokestatic 538	kawa/standard/append:append$V	([Ljava/lang/Object;)Ljava/lang/Object;
    //   82: goto +6 -> 88
    //   85: getstatic 48	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
    //   88: areturn
    //   89: new 66	gnu/mapping/WrongType
    //   92: dup_x1
    //   93: swap
    //   94: ldc -105
    //   96: iconst_1
    //   97: aload_2
    //   98: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   101: athrow
    //   102: new 66	gnu/mapping/WrongType
    //   105: dup_x1
    //   106: swap
    //   107: ldc 68
    //   109: iconst_1
    //   110: aload_3
    //   111: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   114: athrow
    // Line number table:
    //   Java source line #455	-> byte code offset #0
    //   Java source line #456	-> byte code offset #7
    //   Java source line #457	-> byte code offset #22
    //   Java source line #458	-> byte code offset #40
    //   Java source line #459	-> byte code offset #50
    //   Java source line #460	-> byte code offset #64
    //   Java source line #456	-> byte code offset #89
    //   Java source line #457	-> byte code offset #102
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	88	0	re	Object
    //   21	1	1	localObject1	Object
    //   40	31	1	car$Mnre	Object
    //   14	1	2	localObject2	Object
    //   39	59	2	sub$Mncdr$Mnre	Object
    //   29	82	3	localObject3	Object
    //   89	1	6	localClassCastException1	ClassCastException
    //   102	1	7	localClassCastException2	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   15	18	89	java/lang/ClassCastException
    //   30	33	102	java/lang/ClassCastException
  }
  
  /* Error */
  public static Object pregexpMatchPositionsAux(Object re, Object s, Object sn, Object start, Object n, Object i)
  {
    // Byte code:
    //   0: new 540	gnu/kawa/slib/pregexp$frame
    //   3: dup
    //   4: invokespecial 543	gnu/kawa/slib/pregexp$frame:<init>	()V
    //   7: astore 6
    //   9: aload 6
    //   11: aload_1
    //   12: putfield 546	gnu/kawa/slib/pregexp$frame:s	Ljava/lang/Object;
    //   15: aload 6
    //   17: aload_2
    //   18: putfield 549	gnu/kawa/slib/pregexp$frame:sn	Ljava/lang/Object;
    //   21: aload 6
    //   23: aload_3
    //   24: putfield 552	gnu/kawa/slib/pregexp$frame:start	Ljava/lang/Object;
    //   27: aload 6
    //   29: aload 4
    //   31: putfield 555	gnu/kawa/slib/pregexp$frame:n	Ljava/lang/Object;
    //   34: aload 6
    //   36: getfield 559	gnu/kawa/slib/pregexp$frame:identity	Lgnu/mapping/Procedure;
    //   39: aload 6
    //   41: swap
    //   42: putfield 559	gnu/kawa/slib/pregexp$frame:identity	Lgnu/mapping/Procedure;
    //   45: aload_0
    //   46: invokestatic 562	gnu/kawa/slib/pregexp:pregexpMakeBackrefList	(Ljava/lang/Object;)Ljava/lang/Object;
    //   49: aload 6
    //   51: swap
    //   52: putfield 565	gnu/kawa/slib/pregexp$frame:backrefs	Ljava/lang/Object;
    //   55: getstatic 38	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   58: aload 6
    //   60: swap
    //   61: putfield 568	gnu/kawa/slib/pregexp$frame:case$Mnsensitive$Qu	Ljava/lang/Object;
    //   64: aload 6
    //   66: aload 6
    //   68: getfield 565	gnu/kawa/slib/pregexp$frame:backrefs	Ljava/lang/Object;
    //   71: aload_0
    //   72: aload 5
    //   74: aload 6
    //   76: getfield 559	gnu/kawa/slib/pregexp$frame:identity	Lgnu/mapping/Procedure;
    //   79: getstatic 571	gnu/kawa/slib/pregexp:lambda$Fn1	Lgnu/expr/ModuleMethod;
    //   82: invokevirtual 575	gnu/kawa/slib/pregexp$frame:lambda3sub	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   85: pop
    //   86: aload 6
    //   88: getfield 565	gnu/kawa/slib/pregexp$frame:backrefs	Ljava/lang/Object;
    //   91: invokestatic 581	gnu/lists/Sequences:getIterator	(Ljava/lang/Object;)Ljava/util/Iterator;
    //   94: astore 8
    //   96: getstatic 48	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
    //   99: astore 9
    //   101: aconst_null
    //   102: astore 10
    //   104: aload 8
    //   106: invokeinterface 587 1 0
    //   111: ifeq +61 -> 172
    //   114: aload 8
    //   116: invokeinterface 591 1 0
    //   121: astore 11
    //   123: new 56	gnu/lists/Pair
    //   126: dup
    //   127: aload 11
    //   129: ldc 56
    //   131: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   134: dup
    //   135: astore 13
    //   137: checkcast 56	gnu/lists/Pair
    //   140: invokestatic 75	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   143: getstatic 48	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
    //   146: invokespecial 594	gnu/lists/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   149: aload 10
    //   151: ifnonnull +9 -> 160
    //   154: dup
    //   155: astore 9
    //   157: goto +10 -> 167
    //   160: aload 10
    //   162: swap
    //   163: dup_x1
    //   164: invokevirtual 598	gnu/lists/Pair:setCdr	(Ljava/lang/Object;)V
    //   167: astore 10
    //   169: goto -65 -> 104
    //   172: aload 9
    //   174: astore 7
    //   176: aload 7
    //   178: dup
    //   179: astore 8
    //   181: checkcast 56	gnu/lists/Pair
    //   184: invokestatic 153	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   187: invokestatic 170	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   190: ifeq +8 -> 198
    //   193: aload 7
    //   195: goto +6 -> 201
    //   198: getstatic 217	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   201: areturn
    //   202: new 66	gnu/mapping/WrongType
    //   205: dup_x1
    //   206: swap
    //   207: ldc 68
    //   209: iconst_1
    //   210: aload 13
    //   212: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   215: athrow
    //   216: new 66	gnu/mapping/WrongType
    //   219: dup_x1
    //   220: swap
    //   221: ldc -105
    //   223: iconst_1
    //   224: aload 8
    //   226: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   229: athrow
    // Line number table:
    //   Java source line #464	-> byte code offset #0
    //   Java source line #465	-> byte code offset #34
    //   Java source line #466	-> byte code offset #45
    //   Java source line #468	-> byte code offset #64
    //   Java source line #639	-> byte code offset #86
    //   Java source line #640	-> byte code offset #176
    //   Java source line #639	-> byte code offset #202
    //   Java source line #640	-> byte code offset #216
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	201	0	re	Object
    //   0	201	1	s	Object
    //   0	201	2	sn	Object
    //   0	201	3	start	Object
    //   0	201	4	n	Object
    //   0	201	5	i	Object
    //   9	192	6	$heapFrame	frame
    //   176	25	7	backrefs	LList
    // Exception table:
    //   from	to	target	type
    //   137	140	202	java/lang/ClassCastException
    //   181	184	216	java/lang/ClassCastException
  }
  
  /* Error */
  public static Object pregexpReplaceAux(Object str, Object ins, Object n, Object backrefs)
  {
    // Byte code:
    //   0: getstatic 368	gnu/kawa/slib/pregexp:Lit40	Lgnu/math/IntNum;
    //   3: ldc_w 600
    //   6: astore 5
    //   8: astore 4
    //   10: aload 4
    //   12: aload_2
    //   13: invokestatic 96	gnu/kawa/functions/NumberCompare:$Gr$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   16: ifeq +8 -> 24
    //   19: aload 5
    //   21: goto +423 -> 444
    //   24: aload_1
    //   25: ldc 113
    //   27: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   30: dup
    //   31: astore 7
    //   33: checkcast 113	java/lang/CharSequence
    //   36: aload 4
    //   38: invokestatic 118	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   41: dup
    //   42: astore 7
    //   44: checkcast 120	java/lang/Number
    //   47: invokevirtual 124	java/lang/Number:intValue	()I
    //   50: invokestatic 130	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)I
    //   53: istore 6
    //   55: iload 6
    //   57: bipush 92
    //   59: if_icmpne +343 -> 402
    //   62: aload_1
    //   63: aload 4
    //   65: aload_2
    //   66: invokestatic 165	gnu/kawa/slib/pregexp:pregexpReadEscapedNumber	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   69: astore 7
    //   71: aload 7
    //   73: invokestatic 170	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   76: ifeq +22 -> 98
    //   79: aload 7
    //   81: ldc 56
    //   83: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   86: dup
    //   87: astore 9
    //   89: checkcast 56	gnu/lists/Pair
    //   92: invokestatic 153	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   95: goto +53 -> 148
    //   98: aload_1
    //   99: ldc 113
    //   101: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   104: dup
    //   105: astore 9
    //   107: checkcast 113	java/lang/CharSequence
    //   110: iconst_1
    //   111: aload 4
    //   113: getstatic 139	gnu/kawa/slib/pregexp:Lit3	Lgnu/math/IntNum;
    //   116: invokestatic 145	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   119: invokestatic 118	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   122: dup
    //   123: astore 9
    //   125: checkcast 120	java/lang/Number
    //   128: invokevirtual 124	java/lang/Number:intValue	()I
    //   131: invokestatic 130	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)I
    //   134: bipush 38
    //   136: if_icmpne +9 -> 145
    //   139: getstatic 368	gnu/kawa/slib/pregexp:Lit40	Lgnu/math/IntNum;
    //   142: goto +6 -> 148
    //   145: getstatic 217	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   148: astore 8
    //   150: aload 7
    //   152: invokestatic 170	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   155: ifeq +11 -> 166
    //   158: aload 7
    //   160: invokestatic 156	kawa/lib/lists:cadr	(Ljava/lang/Object;)Ljava/lang/Object;
    //   163: goto +32 -> 195
    //   166: aload 8
    //   168: invokestatic 170	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   171: ifeq +15 -> 186
    //   174: iconst_1
    //   175: aload 4
    //   177: getstatic 232	gnu/kawa/slib/pregexp:Lit11	Lgnu/math/IntNum;
    //   180: invokestatic 145	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   183: goto +12 -> 195
    //   186: iconst_1
    //   187: aload 4
    //   189: getstatic 139	gnu/kawa/slib/pregexp:Lit3	Lgnu/math/IntNum;
    //   192: invokestatic 145	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   195: astore 9
    //   197: aload 8
    //   199: invokestatic 170	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   202: ifne +88 -> 290
    //   205: aload_1
    //   206: ldc 113
    //   208: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   211: dup
    //   212: astore 11
    //   214: checkcast 113	java/lang/CharSequence
    //   217: aload 9
    //   219: invokestatic 118	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   222: dup
    //   223: astore 11
    //   225: checkcast 120	java/lang/Number
    //   228: invokevirtual 124	java/lang/Number:intValue	()I
    //   231: invokestatic 130	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)I
    //   234: istore 10
    //   236: iconst_1
    //   237: aload 9
    //   239: getstatic 139	gnu/kawa/slib/pregexp:Lit3	Lgnu/math/IntNum;
    //   242: invokestatic 145	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   245: iload 10
    //   247: bipush 36
    //   249: if_icmpne +8 -> 257
    //   252: aload 5
    //   254: goto -248 -> 6
    //   257: iconst_2
    //   258: anewarray 178	java/lang/Object
    //   261: dup
    //   262: iconst_0
    //   263: aload 5
    //   265: aastore
    //   266: dup
    //   267: iconst_1
    //   268: iconst_1
    //   269: anewarray 178	java/lang/Object
    //   272: dup
    //   273: iconst_0
    //   274: iload 10
    //   276: invokestatic 214	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   279: aastore
    //   280: invokestatic 604	kawa/lib/strings:$make$string$	([Ljava/lang/Object;)Ljava/lang/CharSequence;
    //   283: aastore
    //   284: invokestatic 608	kawa/lib/strings:stringAppend	([Ljava/lang/Object;)Lgnu/lists/FString;
    //   287: goto -281 -> 6
    //   290: aload 9
    //   292: aload_3
    //   293: aload 8
    //   295: invokestatic 611	gnu/kawa/slib/pregexp:pregexpListRef	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   298: astore 10
    //   300: aload 10
    //   302: invokestatic 170	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   305: ifeq +92 -> 397
    //   308: iconst_2
    //   309: anewarray 178	java/lang/Object
    //   312: dup
    //   313: iconst_0
    //   314: aload 5
    //   316: aastore
    //   317: dup
    //   318: iconst_1
    //   319: aload_0
    //   320: ldc 113
    //   322: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   325: dup
    //   326: astore 11
    //   328: checkcast 113	java/lang/CharSequence
    //   331: aload 10
    //   333: ldc 56
    //   335: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   338: dup
    //   339: astore 11
    //   341: checkcast 56	gnu/lists/Pair
    //   344: invokestatic 153	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   347: invokestatic 118	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   350: dup
    //   351: astore 11
    //   353: checkcast 120	java/lang/Number
    //   356: invokevirtual 124	java/lang/Number:intValue	()I
    //   359: aload 10
    //   361: ldc 56
    //   363: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   366: dup
    //   367: astore 11
    //   369: checkcast 56	gnu/lists/Pair
    //   372: invokestatic 75	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   375: invokestatic 118	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   378: dup
    //   379: astore 11
    //   381: checkcast 120	java/lang/Number
    //   384: invokevirtual 124	java/lang/Number:intValue	()I
    //   387: invokestatic 616	kawa/lib/strings:substring	(Ljava/lang/CharSequence;II)Ljava/lang/CharSequence;
    //   390: aastore
    //   391: invokestatic 608	kawa/lib/strings:stringAppend	([Ljava/lang/Object;)Lgnu/lists/FString;
    //   394: goto -388 -> 6
    //   397: aload 5
    //   399: goto -393 -> 6
    //   402: iconst_1
    //   403: aload 4
    //   405: getstatic 139	gnu/kawa/slib/pregexp:Lit3	Lgnu/math/IntNum;
    //   408: invokestatic 145	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   411: iconst_2
    //   412: anewarray 178	java/lang/Object
    //   415: dup
    //   416: iconst_0
    //   417: aload 5
    //   419: aastore
    //   420: dup
    //   421: iconst_1
    //   422: iconst_1
    //   423: anewarray 178	java/lang/Object
    //   426: dup
    //   427: iconst_0
    //   428: iload 6
    //   430: invokestatic 214	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   433: aastore
    //   434: invokestatic 604	kawa/lib/strings:$make$string$	([Ljava/lang/Object;)Ljava/lang/CharSequence;
    //   437: aastore
    //   438: invokestatic 608	kawa/lib/strings:stringAppend	([Ljava/lang/Object;)Lgnu/lists/FString;
    //   441: goto -435 -> 6
    //   444: areturn
    //   445: new 66	gnu/mapping/WrongType
    //   448: dup_x1
    //   449: swap
    //   450: ldc 115
    //   452: iconst_1
    //   453: aload 7
    //   455: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   458: athrow
    //   459: new 66	gnu/mapping/WrongType
    //   462: dup_x1
    //   463: swap
    //   464: ldc 115
    //   466: iconst_2
    //   467: aload 7
    //   469: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   472: athrow
    //   473: new 66	gnu/mapping/WrongType
    //   476: dup_x1
    //   477: swap
    //   478: ldc -105
    //   480: iconst_1
    //   481: aload 9
    //   483: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   486: athrow
    //   487: new 66	gnu/mapping/WrongType
    //   490: dup_x1
    //   491: swap
    //   492: ldc 115
    //   494: iconst_1
    //   495: aload 9
    //   497: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   500: athrow
    //   501: new 66	gnu/mapping/WrongType
    //   504: dup_x1
    //   505: swap
    //   506: ldc 115
    //   508: iconst_2
    //   509: aload 9
    //   511: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   514: athrow
    //   515: new 66	gnu/mapping/WrongType
    //   518: dup_x1
    //   519: swap
    //   520: ldc 115
    //   522: iconst_1
    //   523: aload 11
    //   525: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   528: athrow
    //   529: new 66	gnu/mapping/WrongType
    //   532: dup_x1
    //   533: swap
    //   534: ldc 115
    //   536: iconst_2
    //   537: aload 11
    //   539: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   542: athrow
    //   543: new 66	gnu/mapping/WrongType
    //   546: dup_x1
    //   547: swap
    //   548: ldc_w 613
    //   551: iconst_1
    //   552: aload 11
    //   554: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   557: athrow
    //   558: new 66	gnu/mapping/WrongType
    //   561: dup_x1
    //   562: swap
    //   563: ldc -105
    //   565: iconst_1
    //   566: aload 11
    //   568: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   571: athrow
    //   572: new 66	gnu/mapping/WrongType
    //   575: dup_x1
    //   576: swap
    //   577: ldc_w 613
    //   580: iconst_2
    //   581: aload 11
    //   583: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   586: athrow
    //   587: new 66	gnu/mapping/WrongType
    //   590: dup_x1
    //   591: swap
    //   592: ldc 68
    //   594: iconst_1
    //   595: aload 11
    //   597: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   600: athrow
    //   601: new 66	gnu/mapping/WrongType
    //   604: dup_x1
    //   605: swap
    //   606: ldc_w 613
    //   609: iconst_3
    //   610: aload 11
    //   612: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   615: athrow
    // Line number table:
    //   Java source line #643	-> byte code offset #0
    //   Java source line #644	-> byte code offset #0
    //   Java source line #645	-> byte code offset #10
    //   Java source line #646	-> byte code offset #24
    //   Java source line #647	-> byte code offset #55
    //   Java source line #648	-> byte code offset #62
    //   Java source line #649	-> byte code offset #71
    //   Java source line #650	-> byte code offset #98
    //   Java source line #648	-> byte code offset #150
    //   Java source line #652	-> byte code offset #150
    //   Java source line #653	-> byte code offset #166
    //   Java source line #654	-> byte code offset #186
    //   Java source line #655	-> byte code offset #197
    //   Java source line #656	-> byte code offset #205
    //   Java source line #657	-> byte code offset #236
    //   Java source line #658	-> byte code offset #245
    //   Java source line #659	-> byte code offset #257
    //   Java source line #660	-> byte code offset #290
    //   Java source line #661	-> byte code offset #292
    //   Java source line #662	-> byte code offset #300
    //   Java source line #663	-> byte code offset #308
    //   Java source line #664	-> byte code offset #319
    //   Java source line #662	-> byte code offset #397
    //   Java source line #666	-> byte code offset #402
    //   Java source line #646	-> byte code offset #445
    //   Java source line #649	-> byte code offset #473
    //   Java source line #650	-> byte code offset #487
    //   Java source line #656	-> byte code offset #515
    //   Java source line #664	-> byte code offset #543
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	444	0	str	Object
    //   0	444	1	ins	Object
    //   0	444	2	n	Object
    //   0	444	3	backrefs	Object
    //   8	396	4	i	Object
    //   6	1	5	str	String
    //   10	408	5	r	Object
    //   53	376	6	c	int
    //   31	12	7	localObject1	Object
    //   69	399	7	br$Mni	Object
    //   148	146	8	br	Object
    //   87	37	9	localObject2	Object
    //   195	315	9	i	Object
    //   234	41	10	c2	int
    //   298	62	10	backref	Object
    //   212	399	11	localObject3	Object
    //   445	1	16	localClassCastException1	ClassCastException
    //   459	1	17	localClassCastException2	ClassCastException
    //   473	1	18	localClassCastException3	ClassCastException
    //   487	1	19	localClassCastException4	ClassCastException
    //   501	1	20	localClassCastException5	ClassCastException
    //   515	1	21	localClassCastException6	ClassCastException
    //   529	1	22	localClassCastException7	ClassCastException
    //   543	1	23	localClassCastException8	ClassCastException
    //   558	1	24	localClassCastException9	ClassCastException
    //   572	1	25	localClassCastException10	ClassCastException
    //   587	1	26	localClassCastException11	ClassCastException
    //   601	1	27	localClassCastException12	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   33	36	445	java/lang/ClassCastException
    //   44	50	459	java/lang/ClassCastException
    //   89	92	473	java/lang/ClassCastException
    //   107	110	487	java/lang/ClassCastException
    //   125	131	501	java/lang/ClassCastException
    //   214	217	515	java/lang/ClassCastException
    //   225	231	529	java/lang/ClassCastException
    //   328	331	543	java/lang/ClassCastException
    //   341	344	558	java/lang/ClassCastException
    //   353	359	572	java/lang/ClassCastException
    //   369	372	587	java/lang/ClassCastException
    //   381	387	601	java/lang/ClassCastException
  }
  
  /* Error */
  public static Pair pregexp(Object s)
  {
    // Byte code:
    //   0: getstatic 38	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   3: putstatic 42	gnu/kawa/slib/pregexp:$Stpregexp$Mnspace$Mnsensitive$Qu$St	Ljava/lang/Object;
    //   6: getstatic 532	gnu/kawa/slib/pregexp:Lit61	Lgnu/mapping/SimpleSymbol;
    //   9: aload_0
    //   10: getstatic 368	gnu/kawa/slib/pregexp:Lit40	Lgnu/math/IntNum;
    //   13: aload_0
    //   14: ldc 113
    //   16: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   19: dup
    //   20: astore_1
    //   21: checkcast 113	java/lang/CharSequence
    //   24: invokestatic 425	kawa/lib/strings:stringLength	(Ljava/lang/CharSequence;)I
    //   27: invokestatic 431	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   30: invokestatic 338	gnu/kawa/slib/pregexp:pregexpReadPattern	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   33: ldc 56
    //   35: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   38: dup
    //   39: astore_1
    //   40: checkcast 56	gnu/lists/Pair
    //   43: invokestatic 153	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   46: invokestatic 111	gnu/lists/LList:list2	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   49: areturn
    //   50: new 66	gnu/mapping/WrongType
    //   53: dup_x1
    //   54: swap
    //   55: ldc_w 421
    //   58: iconst_1
    //   59: aload_1
    //   60: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   63: athrow
    //   64: new 66	gnu/mapping/WrongType
    //   67: dup_x1
    //   68: swap
    //   69: ldc -105
    //   71: iconst_1
    //   72: aload_1
    //   73: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   76: athrow
    // Line number table:
    //   Java source line #669	-> byte code offset #0
    //   Java source line #670	-> byte code offset #0
    //   Java source line #671	-> byte code offset #6
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	49	0	s	Object
    //   20	53	1	localObject	Object
    //   50	1	2	localClassCastException1	ClassCastException
    //   64	1	3	localClassCastException2	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   21	24	50	java/lang/ClassCastException
    //   40	43	64	java/lang/ClassCastException
  }
  
  /* Error */
  public static Object pregexpMatchPositions$V(Object pat, Object str, Object[] argsArray)
  {
    // Byte code:
    //   0: aload_2
    //   1: iconst_0
    //   2: invokestatic 620	gnu/lists/LList:makeList	([Ljava/lang/Object;I)Lgnu/lists/LList;
    //   5: dup
    //   6: astore 4
    //   8: astore_3
    //   9: aload_0
    //   10: invokestatic 623	kawa/lib/strings:isString	(Ljava/lang/Object;)Z
    //   13: ifeq +11 -> 24
    //   16: aload_0
    //   17: invokestatic 626	gnu/kawa/slib/pregexp:pregexp	(Ljava/lang/Object;)Lgnu/lists/Pair;
    //   20: astore_0
    //   21: goto +40 -> 61
    //   24: aload_0
    //   25: invokestatic 529	kawa/lib/lists:isPair	(Ljava/lang/Object;)Z
    //   28: ifeq +6 -> 34
    //   31: goto +30 -> 61
    //   34: iconst_3
    //   35: anewarray 178	java/lang/Object
    //   38: dup
    //   39: iconst_0
    //   40: getstatic 629	gnu/kawa/slib/pregexp:Lit71	Lgnu/mapping/SimpleSymbol;
    //   43: aastore
    //   44: dup
    //   45: iconst_1
    //   46: getstatic 632	gnu/kawa/slib/pregexp:Lit72	Lgnu/mapping/SimpleSymbol;
    //   49: aastore
    //   50: dup
    //   51: iconst_2
    //   52: aload_0
    //   53: aastore
    //   54: invokestatic 187	kawa/lib/exceptions:error	([Ljava/lang/Object;)Lgnu/bytecode/Type$NeverReturns;
    //   57: getstatic 193	gnu/expr/Special:reachedUnexpected	Ljava/lang/RuntimeException;
    //   60: athrow
    //   61: aload_1
    //   62: ldc 113
    //   64: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   67: dup
    //   68: astore 5
    //   70: checkcast 113	java/lang/CharSequence
    //   73: invokestatic 425	kawa/lib/strings:stringLength	(Ljava/lang/CharSequence;)I
    //   76: istore 4
    //   78: aload_3
    //   79: invokestatic 54	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
    //   82: ifeq +9 -> 91
    //   85: getstatic 368	gnu/kawa/slib/pregexp:Lit40	Lgnu/math/IntNum;
    //   88: goto +39 -> 127
    //   91: aload_3
    //   92: dup
    //   93: astore 7
    //   95: checkcast 56	gnu/lists/Pair
    //   98: invokestatic 153	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   101: astore 6
    //   103: aload_3
    //   104: dup
    //   105: astore 7
    //   107: checkcast 56	gnu/lists/Pair
    //   110: invokestatic 75	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   113: ldc 44
    //   115: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   118: dup
    //   119: astore 7
    //   121: checkcast 44	gnu/lists/LList
    //   124: astore_3
    //   125: aload 6
    //   127: astore 5
    //   129: aload_3
    //   130: invokestatic 54	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
    //   133: ifeq +11 -> 144
    //   136: iload 4
    //   138: invokestatic 431	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   141: goto +13 -> 154
    //   144: aload_3
    //   145: dup
    //   146: astore 7
    //   148: checkcast 56	gnu/lists/Pair
    //   151: invokestatic 153	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   154: astore 6
    //   156: aload 5
    //   158: astore 7
    //   160: aload 7
    //   162: aload 6
    //   164: invokestatic 637	gnu/kawa/functions/NumberCompare:$Ls$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   167: ifeq +46 -> 213
    //   170: aload_0
    //   171: aload_1
    //   172: iload 4
    //   174: invokestatic 431	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   177: aload 5
    //   179: aload 6
    //   181: aload 7
    //   183: invokestatic 641	gnu/kawa/slib/pregexp:pregexpMatchPositionsAux	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   186: astore 8
    //   188: aload 8
    //   190: invokestatic 170	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   193: ifeq +8 -> 201
    //   196: aload 8
    //   198: goto +18 -> 216
    //   201: iconst_1
    //   202: aload 7
    //   204: getstatic 139	gnu/kawa/slib/pregexp:Lit3	Lgnu/math/IntNum;
    //   207: invokestatic 145	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   210: goto -52 -> 158
    //   213: getstatic 217	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   216: areturn
    //   217: new 66	gnu/mapping/WrongType
    //   220: dup_x1
    //   221: swap
    //   222: ldc_w 421
    //   225: iconst_1
    //   226: aload 5
    //   228: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   231: athrow
    //   232: new 66	gnu/mapping/WrongType
    //   235: dup_x1
    //   236: swap
    //   237: ldc -105
    //   239: iconst_1
    //   240: aload 7
    //   242: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   245: athrow
    //   246: new 66	gnu/mapping/WrongType
    //   249: dup_x1
    //   250: swap
    //   251: ldc 68
    //   253: iconst_1
    //   254: aload 7
    //   256: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   259: athrow
    //   260: new 66	gnu/mapping/WrongType
    //   263: dup_x1
    //   264: swap
    //   265: ldc_w 634
    //   268: bipush -2
    //   270: aload 7
    //   272: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   275: athrow
    //   276: new 66	gnu/mapping/WrongType
    //   279: dup_x1
    //   280: swap
    //   281: ldc -105
    //   283: iconst_1
    //   284: aload 7
    //   286: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   289: athrow
    // Line number table:
    //   Java source line #674	-> byte code offset #0
    //   Java source line #675	-> byte code offset #9
    //   Java source line #676	-> byte code offset #24
    //   Java source line #677	-> byte code offset #34
    //   Java source line #680	-> byte code offset #61
    //   Java source line #681	-> byte code offset #78
    //   Java source line #682	-> byte code offset #91
    //   Java source line #683	-> byte code offset #103
    //   Java source line #684	-> byte code offset #125
    //   Java source line #680	-> byte code offset #129
    //   Java source line #685	-> byte code offset #129
    //   Java source line #686	-> byte code offset #144
    //   Java source line #687	-> byte code offset #156
    //   Java source line #688	-> byte code offset #160
    //   Java source line #689	-> byte code offset #170
    //   Java source line #690	-> byte code offset #170
    //   Java source line #689	-> byte code offset #188
    //   Java source line #691	-> byte code offset #201
    //   Java source line #680	-> byte code offset #217
    //   Java source line #682	-> byte code offset #232
    //   Java source line #683	-> byte code offset #246
    //   Java source line #686	-> byte code offset #276
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	216	0	pat	Object
    //   0	216	1	str	Object
    //   0	216	2	argsArray	Object[]
    //   0	145	3	opt$Mnargs	LList
    //   6	1	4	localLList1	LList
    //   76	97	4	str$Mnlen	int
    //   68	1	5	localObject1	Object
    //   127	100	5	start	Object
    //   101	25	6	start	Object
    //   154	26	6	end	Object
    //   93	54	7	localObject2	Object
    //   158	127	7	i	Object
    //   186	11	8	x	Object
    //   217	1	13	localClassCastException1	ClassCastException
    //   232	1	14	localClassCastException2	ClassCastException
    //   246	1	15	localClassCastException3	ClassCastException
    //   260	1	16	localClassCastException4	ClassCastException
    //   276	1	17	localClassCastException5	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   70	73	217	java/lang/ClassCastException
    //   95	98	232	java/lang/ClassCastException
    //   107	110	246	java/lang/ClassCastException
    //   121	124	260	java/lang/ClassCastException
    //   148	151	276	java/lang/ClassCastException
  }
  
  /* Error */
  public static Object pregexpMatch$V(Object pat, Object str, Object[] argsArray)
  {
    // Byte code:
    //   0: aload_2
    //   1: iconst_0
    //   2: invokestatic 620	gnu/lists/LList:makeList	([Ljava/lang/Object;I)Lgnu/lists/LList;
    //   5: dup
    //   6: astore 4
    //   8: astore_3
    //   9: getstatic 644	kawa/standard/Scheme:apply	Lgnu/kawa/functions/Apply;
    //   12: getstatic 647	gnu/kawa/slib/pregexp:pregexp$Mnmatch$Mnpositions	Lgnu/expr/ModuleMethod;
    //   15: aload_0
    //   16: aload_1
    //   17: aload_3
    //   18: invokevirtual 651	gnu/mapping/Procedure:apply4	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   21: astore 4
    //   23: aload 4
    //   25: invokestatic 170	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   28: ifeq +160 -> 188
    //   31: aload 4
    //   33: invokestatic 581	gnu/lists/Sequences:getIterator	(Ljava/lang/Object;)Ljava/util/Iterator;
    //   36: astore 5
    //   38: getstatic 48	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
    //   41: astore 6
    //   43: aconst_null
    //   44: astore 7
    //   46: aload 5
    //   48: invokeinterface 587 1 0
    //   53: ifeq +130 -> 183
    //   56: aload 5
    //   58: invokeinterface 591 1 0
    //   63: astore 8
    //   65: new 56	gnu/lists/Pair
    //   68: dup
    //   69: aload 8
    //   71: invokestatic 170	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   74: ifeq +77 -> 151
    //   77: aload_1
    //   78: ldc 113
    //   80: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   83: dup
    //   84: astore 10
    //   86: checkcast 113	java/lang/CharSequence
    //   89: aload 8
    //   91: ldc 56
    //   93: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   96: dup
    //   97: astore 10
    //   99: checkcast 56	gnu/lists/Pair
    //   102: invokestatic 153	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   105: invokestatic 118	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   108: dup
    //   109: astore 10
    //   111: checkcast 120	java/lang/Number
    //   114: invokevirtual 124	java/lang/Number:intValue	()I
    //   117: aload 8
    //   119: ldc 56
    //   121: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   124: dup
    //   125: astore 10
    //   127: checkcast 56	gnu/lists/Pair
    //   130: invokestatic 75	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   133: invokestatic 118	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   136: dup
    //   137: astore 10
    //   139: checkcast 120	java/lang/Number
    //   142: invokevirtual 124	java/lang/Number:intValue	()I
    //   145: invokestatic 616	kawa/lib/strings:substring	(Ljava/lang/CharSequence;II)Ljava/lang/CharSequence;
    //   148: goto +6 -> 154
    //   151: getstatic 217	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   154: getstatic 48	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
    //   157: invokespecial 594	gnu/lists/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   160: aload 7
    //   162: ifnonnull +9 -> 171
    //   165: dup
    //   166: astore 6
    //   168: goto +10 -> 178
    //   171: aload 7
    //   173: swap
    //   174: dup_x1
    //   175: invokevirtual 598	gnu/lists/Pair:setCdr	(Ljava/lang/Object;)V
    //   178: astore 7
    //   180: goto -134 -> 46
    //   183: aload 6
    //   185: goto +6 -> 191
    //   188: getstatic 217	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   191: areturn
    //   192: new 66	gnu/mapping/WrongType
    //   195: dup_x1
    //   196: swap
    //   197: ldc_w 613
    //   200: iconst_1
    //   201: aload 10
    //   203: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   206: athrow
    //   207: new 66	gnu/mapping/WrongType
    //   210: dup_x1
    //   211: swap
    //   212: ldc -105
    //   214: iconst_1
    //   215: aload 10
    //   217: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   220: athrow
    //   221: new 66	gnu/mapping/WrongType
    //   224: dup_x1
    //   225: swap
    //   226: ldc_w 613
    //   229: iconst_2
    //   230: aload 10
    //   232: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   235: athrow
    //   236: new 66	gnu/mapping/WrongType
    //   239: dup_x1
    //   240: swap
    //   241: ldc 68
    //   243: iconst_1
    //   244: aload 10
    //   246: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   249: athrow
    //   250: new 66	gnu/mapping/WrongType
    //   253: dup_x1
    //   254: swap
    //   255: ldc_w 613
    //   258: iconst_3
    //   259: aload 10
    //   261: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   264: athrow
    // Line number table:
    //   Java source line #694	-> byte code offset #0
    //   Java source line #695	-> byte code offset #9
    //   Java source line #696	-> byte code offset #23
    //   Java source line #697	-> byte code offset #31
    //   Java source line #701	-> byte code offset #31
    //   Java source line #699	-> byte code offset #69
    //   Java source line #700	-> byte code offset #77
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	191	0	pat	Object
    //   0	191	1	str	Object
    //   0	191	2	argsArray	Object[]
    //   0	191	3	opt$Mnargs	LList
    //   23	168	4	ix$Mnprs	Object
    // Exception table:
    //   from	to	target	type
    //   86	89	192	java/lang/ClassCastException
    //   99	102	207	java/lang/ClassCastException
    //   111	117	221	java/lang/ClassCastException
    //   127	130	236	java/lang/ClassCastException
    //   139	145	250	java/lang/ClassCastException
  }
  
  /* Error */
  public static Object pregexpSplit(Object pat, Object str)
  {
    // Byte code:
    //   0: aload_1
    //   1: ldc 113
    //   3: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   6: dup
    //   7: astore_3
    //   8: checkcast 113	java/lang/CharSequence
    //   11: invokestatic 425	kawa/lib/strings:stringLength	(Ljava/lang/CharSequence;)I
    //   14: istore_2
    //   15: getstatic 368	gnu/kawa/slib/pregexp:Lit40	Lgnu/math/IntNum;
    //   18: getstatic 48	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
    //   21: iconst_0
    //   22: istore 5
    //   24: astore 4
    //   26: astore_3
    //   27: aload_3
    //   28: iload_2
    //   29: invokestatic 431	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   32: invokestatic 96	gnu/kawa/functions/NumberCompare:$Gr$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   35: ifeq +11 -> 46
    //   38: aload 4
    //   40: invokestatic 133	gnu/kawa/slib/pregexp:pregexpReverse$Ex	(Ljava/lang/Object;)Ljava/lang/Object;
    //   43: goto +282 -> 325
    //   46: aload_0
    //   47: aload_1
    //   48: iconst_2
    //   49: anewarray 178	java/lang/Object
    //   52: dup
    //   53: iconst_0
    //   54: aload_3
    //   55: aastore
    //   56: dup
    //   57: iconst_1
    //   58: iload_2
    //   59: invokestatic 431	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   62: aastore
    //   63: invokestatic 655	gnu/kawa/slib/pregexp:pregexpMatchPositions$V	(Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   66: astore 6
    //   68: aload 6
    //   70: invokestatic 170	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   73: ifeq +210 -> 283
    //   76: aload 6
    //   78: ldc 56
    //   80: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   83: dup
    //   84: astore 8
    //   86: checkcast 56	gnu/lists/Pair
    //   89: invokestatic 153	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   92: astore 7
    //   94: aload 7
    //   96: ldc 56
    //   98: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   101: dup
    //   102: astore 9
    //   104: checkcast 56	gnu/lists/Pair
    //   107: invokestatic 153	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   110: astore 8
    //   112: aload 7
    //   114: ldc 56
    //   116: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   119: dup
    //   120: astore 10
    //   122: checkcast 56	gnu/lists/Pair
    //   125: invokestatic 75	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   128: astore 9
    //   130: aload 8
    //   132: aload 9
    //   134: invokestatic 392	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   137: ifeq +70 -> 207
    //   140: iconst_1
    //   141: aload 9
    //   143: getstatic 139	gnu/kawa/slib/pregexp:Lit3	Lgnu/math/IntNum;
    //   146: invokestatic 145	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   149: aload_1
    //   150: ldc 113
    //   152: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   155: dup
    //   156: astore 10
    //   158: checkcast 113	java/lang/CharSequence
    //   161: aload_3
    //   162: invokestatic 118	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   165: dup
    //   166: astore 10
    //   168: checkcast 120	java/lang/Number
    //   171: invokevirtual 124	java/lang/Number:intValue	()I
    //   174: iconst_1
    //   175: aload 8
    //   177: getstatic 139	gnu/kawa/slib/pregexp:Lit3	Lgnu/math/IntNum;
    //   180: invokestatic 145	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   183: invokestatic 118	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   186: dup
    //   187: astore 10
    //   189: checkcast 120	java/lang/Number
    //   192: invokevirtual 124	java/lang/Number:intValue	()I
    //   195: invokestatic 616	kawa/lib/strings:substring	(Ljava/lang/CharSequence;II)Ljava/lang/CharSequence;
    //   198: aload 4
    //   200: invokestatic 136	kawa/lib/lists:cons	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   203: iconst_1
    //   204: goto -182 -> 22
    //   207: aload 8
    //   209: aload_3
    //   210: invokestatic 392	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   213: ifeq +17 -> 230
    //   216: iload 5
    //   218: ifeq +12 -> 230
    //   221: aload 9
    //   223: iconst_0
    //   224: istore 5
    //   226: astore_3
    //   227: goto -200 -> 27
    //   230: aload 9
    //   232: aload_1
    //   233: ldc 113
    //   235: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   238: dup
    //   239: astore 10
    //   241: checkcast 113	java/lang/CharSequence
    //   244: aload_3
    //   245: invokestatic 118	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   248: dup
    //   249: astore 10
    //   251: checkcast 120	java/lang/Number
    //   254: invokevirtual 124	java/lang/Number:intValue	()I
    //   257: aload 8
    //   259: invokestatic 118	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   262: dup
    //   263: astore 10
    //   265: checkcast 120	java/lang/Number
    //   268: invokevirtual 124	java/lang/Number:intValue	()I
    //   271: invokestatic 616	kawa/lib/strings:substring	(Ljava/lang/CharSequence;II)Ljava/lang/CharSequence;
    //   274: aload 4
    //   276: invokestatic 136	kawa/lib/lists:cons	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   279: iconst_0
    //   280: goto -258 -> 22
    //   283: iload_2
    //   284: invokestatic 431	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   287: aload_1
    //   288: ldc 113
    //   290: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   293: dup
    //   294: astore 7
    //   296: checkcast 113	java/lang/CharSequence
    //   299: aload_3
    //   300: invokestatic 118	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   303: dup
    //   304: astore 7
    //   306: checkcast 120	java/lang/Number
    //   309: invokevirtual 124	java/lang/Number:intValue	()I
    //   312: iload_2
    //   313: invokestatic 616	kawa/lib/strings:substring	(Ljava/lang/CharSequence;II)Ljava/lang/CharSequence;
    //   316: aload 4
    //   318: invokestatic 136	kawa/lib/lists:cons	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   321: iconst_0
    //   322: goto -300 -> 22
    //   325: areturn
    //   326: new 66	gnu/mapping/WrongType
    //   329: dup_x1
    //   330: swap
    //   331: ldc_w 421
    //   334: iconst_1
    //   335: aload_3
    //   336: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   339: athrow
    //   340: new 66	gnu/mapping/WrongType
    //   343: dup_x1
    //   344: swap
    //   345: ldc -105
    //   347: iconst_1
    //   348: aload 8
    //   350: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   353: athrow
    //   354: new 66	gnu/mapping/WrongType
    //   357: dup_x1
    //   358: swap
    //   359: ldc -105
    //   361: iconst_1
    //   362: aload 9
    //   364: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   367: athrow
    //   368: new 66	gnu/mapping/WrongType
    //   371: dup_x1
    //   372: swap
    //   373: ldc 68
    //   375: iconst_1
    //   376: aload 10
    //   378: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   381: athrow
    //   382: new 66	gnu/mapping/WrongType
    //   385: dup_x1
    //   386: swap
    //   387: ldc_w 613
    //   390: iconst_1
    //   391: aload 10
    //   393: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   396: athrow
    //   397: new 66	gnu/mapping/WrongType
    //   400: dup_x1
    //   401: swap
    //   402: ldc_w 613
    //   405: iconst_2
    //   406: aload 10
    //   408: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   411: athrow
    //   412: new 66	gnu/mapping/WrongType
    //   415: dup_x1
    //   416: swap
    //   417: ldc_w 613
    //   420: iconst_3
    //   421: aload 10
    //   423: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   426: athrow
    //   427: new 66	gnu/mapping/WrongType
    //   430: dup_x1
    //   431: swap
    //   432: ldc_w 613
    //   435: iconst_1
    //   436: aload 10
    //   438: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   441: athrow
    //   442: new 66	gnu/mapping/WrongType
    //   445: dup_x1
    //   446: swap
    //   447: ldc_w 613
    //   450: iconst_2
    //   451: aload 10
    //   453: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   456: athrow
    //   457: new 66	gnu/mapping/WrongType
    //   460: dup_x1
    //   461: swap
    //   462: ldc_w 613
    //   465: iconst_3
    //   466: aload 10
    //   468: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   471: athrow
    //   472: new 66	gnu/mapping/WrongType
    //   475: dup_x1
    //   476: swap
    //   477: ldc_w 613
    //   480: iconst_1
    //   481: aload 7
    //   483: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   486: athrow
    //   487: new 66	gnu/mapping/WrongType
    //   490: dup_x1
    //   491: swap
    //   492: ldc_w 613
    //   495: iconst_2
    //   496: aload 7
    //   498: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   501: athrow
    // Line number table:
    //   Java source line #704	-> byte code offset #0
    //   Java source line #706	-> byte code offset #0
    //   Java source line #707	-> byte code offset #15
    //   Java source line #708	-> byte code offset #27
    //   Java source line #709	-> byte code offset #46
    //   Java source line #708	-> byte code offset #68
    //   Java source line #10000	-> byte code offset #76
    //   Java source line #712	-> byte code offset #76
    //   Java source line #713	-> byte code offset #94
    //   Java source line #715	-> byte code offset #130
    //   Java source line #717	-> byte code offset #140
    //   Java source line #718	-> byte code offset #149
    //   Java source line #719	-> byte code offset #207
    //   Java source line #720	-> byte code offset #221
    //   Java source line #723	-> byte code offset #230
    //   Java source line #724	-> byte code offset #283
    //   Java source line #706	-> byte code offset #326
    //   Java source line #712	-> byte code offset #340
    //   Java source line #713	-> byte code offset #354
    //   Java source line #718	-> byte code offset #382
    //   Java source line #723	-> byte code offset #427
    //   Java source line #724	-> byte code offset #472
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	325	0	pat	Object
    //   0	325	1	str	Object
    //   14	299	2	n	int
    //   7	1	3	localObject1	Object
    //   26	310	3	i	Object
    //   24	1	4	localEmptyList	EmptyList
    //   27	290	4	r	Object
    //   22	1	5	i	int
    //   27	198	5	picked$Mnup$Mnone$Mnundelimited$Mnchar$Qu	boolean
    //   66	11	6	temp	Object
    //   92	405	7	jk	Object
    //   84	27	8	localObject2	Object
    //   130	219	8	j	Object
    //   102	1	9	localObject3	Object
    //   128	235	9	k	Object
    //   120	347	10	localObject4	Object
    //   326	1	16	localClassCastException1	ClassCastException
    //   340	1	17	localClassCastException2	ClassCastException
    //   354	1	18	localClassCastException3	ClassCastException
    //   368	1	19	localClassCastException4	ClassCastException
    //   382	1	20	localClassCastException5	ClassCastException
    //   397	1	21	localClassCastException6	ClassCastException
    //   412	1	22	localClassCastException7	ClassCastException
    //   427	1	23	localClassCastException8	ClassCastException
    //   442	1	24	localClassCastException9	ClassCastException
    //   457	1	25	localClassCastException10	ClassCastException
    //   472	1	26	localClassCastException11	ClassCastException
    //   487	1	27	localClassCastException12	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   8	11	326	java/lang/ClassCastException
    //   86	89	340	java/lang/ClassCastException
    //   104	107	354	java/lang/ClassCastException
    //   122	125	368	java/lang/ClassCastException
    //   158	161	382	java/lang/ClassCastException
    //   168	174	397	java/lang/ClassCastException
    //   189	195	412	java/lang/ClassCastException
    //   241	244	427	java/lang/ClassCastException
    //   251	257	442	java/lang/ClassCastException
    //   265	271	457	java/lang/ClassCastException
    //   296	299	472	java/lang/ClassCastException
    //   306	312	487	java/lang/ClassCastException
  }
  
  /* Error */
  public static Object pregexpReplace(Object pat, Object str, Object ins)
  {
    // Byte code:
    //   0: aload_1
    //   1: ldc 113
    //   3: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   6: dup
    //   7: astore 4
    //   9: checkcast 113	java/lang/CharSequence
    //   12: invokestatic 425	kawa/lib/strings:stringLength	(Ljava/lang/CharSequence;)I
    //   15: istore_3
    //   16: aload_0
    //   17: aload_1
    //   18: iconst_2
    //   19: anewarray 178	java/lang/Object
    //   22: dup
    //   23: iconst_0
    //   24: getstatic 368	gnu/kawa/slib/pregexp:Lit40	Lgnu/math/IntNum;
    //   27: aastore
    //   28: dup
    //   29: iconst_1
    //   30: iload_3
    //   31: invokestatic 431	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   34: aastore
    //   35: invokestatic 655	gnu/kawa/slib/pregexp:pregexpMatchPositions$V	(Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   38: astore 4
    //   40: aload 4
    //   42: invokestatic 170	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   45: ifne +7 -> 52
    //   48: aload_1
    //   49: goto +122 -> 171
    //   52: aload_2
    //   53: ldc 113
    //   55: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   58: dup
    //   59: astore 6
    //   61: checkcast 113	java/lang/CharSequence
    //   64: invokestatic 425	kawa/lib/strings:stringLength	(Ljava/lang/CharSequence;)I
    //   67: istore 5
    //   69: aload 4
    //   71: invokestatic 658	kawa/lib/lists:caar	(Ljava/lang/Object;)Ljava/lang/Object;
    //   74: astore 6
    //   76: aload 4
    //   78: invokestatic 661	kawa/lib/lists:cdar	(Ljava/lang/Object;)Ljava/lang/Object;
    //   81: astore 7
    //   83: iconst_3
    //   84: anewarray 178	java/lang/Object
    //   87: dup
    //   88: iconst_0
    //   89: aload_1
    //   90: ldc 113
    //   92: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   95: dup
    //   96: astore 8
    //   98: checkcast 113	java/lang/CharSequence
    //   101: iconst_0
    //   102: aload 6
    //   104: invokestatic 118	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   107: dup
    //   108: astore 8
    //   110: checkcast 120	java/lang/Number
    //   113: invokevirtual 124	java/lang/Number:intValue	()I
    //   116: invokestatic 616	kawa/lib/strings:substring	(Ljava/lang/CharSequence;II)Ljava/lang/CharSequence;
    //   119: aastore
    //   120: dup
    //   121: iconst_1
    //   122: aload_1
    //   123: aload_2
    //   124: iload 5
    //   126: invokestatic 431	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   129: aload 4
    //   131: invokestatic 664	gnu/kawa/slib/pregexp:pregexpReplaceAux	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   134: aastore
    //   135: dup
    //   136: iconst_2
    //   137: aload_1
    //   138: ldc 113
    //   140: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   143: dup
    //   144: astore 8
    //   146: checkcast 113	java/lang/CharSequence
    //   149: aload 7
    //   151: invokestatic 118	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   154: dup
    //   155: astore 8
    //   157: checkcast 120	java/lang/Number
    //   160: invokevirtual 124	java/lang/Number:intValue	()I
    //   163: iload_3
    //   164: invokestatic 616	kawa/lib/strings:substring	(Ljava/lang/CharSequence;II)Ljava/lang/CharSequence;
    //   167: aastore
    //   168: invokestatic 608	kawa/lib/strings:stringAppend	([Ljava/lang/Object;)Lgnu/lists/FString;
    //   171: areturn
    //   172: new 66	gnu/mapping/WrongType
    //   175: dup_x1
    //   176: swap
    //   177: ldc_w 421
    //   180: iconst_1
    //   181: aload 4
    //   183: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   186: athrow
    //   187: new 66	gnu/mapping/WrongType
    //   190: dup_x1
    //   191: swap
    //   192: ldc_w 421
    //   195: iconst_1
    //   196: aload 6
    //   198: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   201: athrow
    //   202: new 66	gnu/mapping/WrongType
    //   205: dup_x1
    //   206: swap
    //   207: ldc_w 613
    //   210: iconst_1
    //   211: aload 8
    //   213: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   216: athrow
    //   217: new 66	gnu/mapping/WrongType
    //   220: dup_x1
    //   221: swap
    //   222: ldc_w 613
    //   225: iconst_3
    //   226: aload 8
    //   228: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   231: athrow
    //   232: new 66	gnu/mapping/WrongType
    //   235: dup_x1
    //   236: swap
    //   237: ldc_w 613
    //   240: iconst_1
    //   241: aload 8
    //   243: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   246: athrow
    //   247: new 66	gnu/mapping/WrongType
    //   250: dup_x1
    //   251: swap
    //   252: ldc_w 613
    //   255: iconst_2
    //   256: aload 8
    //   258: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   261: athrow
    // Line number table:
    //   Java source line #727	-> byte code offset #0
    //   Java source line #728	-> byte code offset #0
    //   Java source line #729	-> byte code offset #16
    //   Java source line #730	-> byte code offset #40
    //   Java source line #731	-> byte code offset #52
    //   Java source line #732	-> byte code offset #69
    //   Java source line #733	-> byte code offset #76
    //   Java source line #734	-> byte code offset #83
    //   Java source line #735	-> byte code offset #89
    //   Java source line #736	-> byte code offset #122
    //   Java source line #737	-> byte code offset #137
    //   Java source line #728	-> byte code offset #172
    //   Java source line #731	-> byte code offset #187
    //   Java source line #735	-> byte code offset #202
    //   Java source line #737	-> byte code offset #232
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	171	0	pat	Object
    //   0	171	1	str	Object
    //   0	171	2	ins	Object
    //   15	149	3	n	int
    //   7	1	4	localObject1	Object
    //   38	144	4	pp	Object
    //   67	1	5	i	int
    //   83	42	5	ins$Mnlen	int
    //   59	16	6	localObject2	Object
    //   83	114	6	m$Mni	Object
    //   81	69	7	m$Mnn	Object
    //   96	161	8	localObject3	Object
    //   172	1	12	localClassCastException1	ClassCastException
    //   187	1	13	localClassCastException2	ClassCastException
    //   202	1	14	localClassCastException3	ClassCastException
    //   217	1	15	localClassCastException4	ClassCastException
    //   232	1	16	localClassCastException5	ClassCastException
    //   247	1	17	localClassCastException6	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   9	12	172	java/lang/ClassCastException
    //   61	64	187	java/lang/ClassCastException
    //   98	101	202	java/lang/ClassCastException
    //   110	116	217	java/lang/ClassCastException
    //   146	149	232	java/lang/ClassCastException
    //   157	163	247	java/lang/ClassCastException
  }
  
  /* Error */
  public static Object pregexpQuote(Object s)
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc 113
    //   3: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   6: dup
    //   7: astore_1
    //   8: checkcast 113	java/lang/CharSequence
    //   11: invokestatic 425	kawa/lib/strings:stringLength	(Ljava/lang/CharSequence;)I
    //   14: iconst_1
    //   15: isub
    //   16: invokestatic 431	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   19: getstatic 48	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
    //   22: astore_2
    //   23: astore_1
    //   24: aload_1
    //   25: getstatic 368	gnu/kawa/slib/pregexp:Lit40	Lgnu/math/IntNum;
    //   28: invokestatic 208	gnu/kawa/functions/NumberCompare:$Ls	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   31: ifeq +20 -> 51
    //   34: aload_2
    //   35: ldc 44
    //   37: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   40: dup
    //   41: astore_3
    //   42: checkcast 44	gnu/lists/LList
    //   45: invokestatic 256	kawa/lib/strings:list$To$String	(Lgnu/lists/LList;)Ljava/lang/CharSequence;
    //   48: goto +84 -> 132
    //   51: iconst_m1
    //   52: aload_1
    //   53: getstatic 139	gnu/kawa/slib/pregexp:Lit3	Lgnu/math/IntNum;
    //   56: invokestatic 145	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   59: aload_0
    //   60: ldc 113
    //   62: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   65: dup
    //   66: astore 4
    //   68: checkcast 113	java/lang/CharSequence
    //   71: aload_1
    //   72: invokestatic 118	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   75: dup
    //   76: astore 4
    //   78: checkcast 120	java/lang/Number
    //   81: invokevirtual 124	java/lang/Number:intValue	()I
    //   84: invokestatic 130	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)I
    //   87: istore_3
    //   88: iload_3
    //   89: invokestatic 214	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   92: getstatic 667	gnu/kawa/slib/pregexp:Lit73	Lgnu/lists/PairWithPosition;
    //   95: invokestatic 670	kawa/lib/lists:memv	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   98: invokestatic 170	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   101: ifeq +20 -> 121
    //   104: getstatic 673	gnu/kawa/slib/pregexp:Lit74	Lgnu/text/Char;
    //   107: iload_3
    //   108: invokestatic 214	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   111: aload_2
    //   112: invokestatic 136	kawa/lib/lists:cons	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   115: invokestatic 136	kawa/lib/lists:cons	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   118: goto -96 -> 22
    //   121: iload_3
    //   122: invokestatic 214	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   125: aload_2
    //   126: invokestatic 136	kawa/lib/lists:cons	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   129: goto -107 -> 22
    //   132: areturn
    //   133: new 66	gnu/mapping/WrongType
    //   136: dup_x1
    //   137: swap
    //   138: ldc_w 421
    //   141: iconst_1
    //   142: aload_1
    //   143: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   146: athrow
    //   147: new 66	gnu/mapping/WrongType
    //   150: dup_x1
    //   151: swap
    //   152: ldc -4
    //   154: iconst_1
    //   155: aload_3
    //   156: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   159: athrow
    //   160: new 66	gnu/mapping/WrongType
    //   163: dup_x1
    //   164: swap
    //   165: ldc 115
    //   167: iconst_1
    //   168: aload 4
    //   170: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   173: athrow
    //   174: new 66	gnu/mapping/WrongType
    //   177: dup_x1
    //   178: swap
    //   179: ldc 115
    //   181: iconst_2
    //   182: aload 4
    //   184: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   187: athrow
    // Line number table:
    //   Java source line #768	-> byte code offset #0
    //   Java source line #769	-> byte code offset #0
    //   Java source line #770	-> byte code offset #24
    //   Java source line #771	-> byte code offset #51
    //   Java source line #772	-> byte code offset #59
    //   Java source line #773	-> byte code offset #88
    //   Java source line #775	-> byte code offset #104
    //   Java source line #776	-> byte code offset #121
    //   Java source line #769	-> byte code offset #133
    //   Java source line #770	-> byte code offset #147
    //   Java source line #772	-> byte code offset #160
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	132	0	s	Object
    //   7	1	1	localObject1	Object
    //   23	120	1	i	Object
    //   22	1	2	localEmptyList	EmptyList
    //   24	102	2	r	Object
    //   41	1	3	localObject2	Object
    //   87	69	3	c	int
    //   66	117	4	localObject3	Object
    //   133	1	8	localClassCastException1	ClassCastException
    //   147	1	9	localClassCastException2	ClassCastException
    //   160	1	10	localClassCastException3	ClassCastException
    //   174	1	11	localClassCastException4	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   8	11	133	java/lang/ClassCastException
    //   42	45	147	java/lang/ClassCastException
    //   68	71	160	java/lang/ClassCastException
    //   78	84	174	java/lang/ClassCastException
  }
  
  static
  {
    Lit73 = PairWithPosition.make(Lit74, PairWithPosition.make(Char.valueOf(46), PairWithPosition.make(Char.valueOf(63), PairWithPosition.make(Char.valueOf(42), PairWithPosition.make(Char.valueOf(43), PairWithPosition.make(Char.valueOf(124), PairWithPosition.make(pregexp.Lit10 = Char.valueOf(94), PairWithPosition.make(Char.valueOf(36), PairWithPosition.make(Char.valueOf(91), PairWithPosition.make(Char.valueOf(93), PairWithPosition.make(Char.valueOf(123), PairWithPosition.make(Char.valueOf(125), PairWithPosition.make(Char.valueOf(40), PairWithPosition.make(Char.valueOf(41), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm", 3170361), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm", 3170357), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm", 3170353), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm", 3170349), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm", 3170345), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm", 3170341), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm", 3166269), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm", 3166265), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm", 3166261), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm", 3166257), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm", 3166253), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm", 3166249), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm", 3166245), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm", 3166240);
    Lit72 = Symbol.valueOf("pattern-must-be-compiled-or-string-regexp");
    Lit71 = Symbol.valueOf("pregexp-match-positions");
    Lit70 = Symbol.valueOf("greedy-quantifier-operand-could-be-empty");
    Lit69 = Symbol.valueOf("non-existent-backref");
    Lit68 = Symbol.valueOf(":lookbehind");
    Lit67 = Symbol.valueOf(":neg-lookahead");
    Lit66 = Symbol.valueOf(":no-backtrack");
    Lit65 = Symbol.valueOf(":lookahead");
    Lit64 = PairWithPosition.make(pregexp.Lit35 = Symbol.valueOf(":between"), PairWithPosition.make(Boolean.FALSE, PairWithPosition.make(pregexp.Lit40 = IntNum.valueOf(0), PairWithPosition.make(Boolean.FALSE, PairWithPosition.make(pregexp.Lit9 = Symbol.valueOf(":any"), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm", 2355265), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm", 2355262), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm", 2355260), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm", 2355257), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm", 2355247);
    Lit63 = Symbol.valueOf(":neg-lookbehind");
    Lit62 = Symbol.valueOf("pregexp-match-positions-aux");
    Lit61 = Symbol.valueOf(":sub");
    Lit60 = Symbol.valueOf("pregexp-check-if-in-char-class?");
    Lit59 = Symbol.valueOf(":punct");
    Lit58 = Symbol.valueOf(":graph");
    Lit57 = Symbol.valueOf(":print");
    Lit56 = Symbol.valueOf(":cntrl");
    Lit55 = Symbol.valueOf(":xdigit");
    Lit54 = Symbol.valueOf(":lower");
    Lit53 = Symbol.valueOf(":alnum");
    Lit52 = Symbol.valueOf(":upper");
    Lit51 = Symbol.valueOf(":alpha");
    Lit50 = Symbol.valueOf(":blank");
    Lit49 = Symbol.valueOf(":ascii");
    Lit48 = Symbol.valueOf(":char-range");
    Lit47 = Symbol.valueOf(":one-of-chars");
    Lit46 = Symbol.valueOf("character-class-ended-too-soon");
    Lit45 = Symbol.valueOf("pregexp-read-char-list");
    Lit44 = Symbol.valueOf(":none-of-chars");
    Lit43 = Symbol.valueOf("pregexp-read-nums");
    Lit42 = Symbol.valueOf("left-brace-must-be-followed-by-number");
    Lit41 = Symbol.valueOf("pregexp-wrap-quantifier-if-any");
    Lit39 = Symbol.valueOf("next-i");
    Lit38 = Symbol.valueOf("at-most");
    Lit37 = Symbol.valueOf("at-least");
    Lit36 = Symbol.valueOf("minimal?");
    Lit34 = Symbol.valueOf("pregexp-read-subpattern");
    Lit33 = PairWithPosition.make(Lit61, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm", 962582);
    Lit32 = Symbol.valueOf(":case-insensitive");
    Lit31 = Symbol.valueOf(":case-sensitive");
    Lit30 = Symbol.valueOf("pregexp-read-cluster-type");
    Lit29 = PairWithPosition.make(Lit68, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm", 892959);
    Lit28 = PairWithPosition.make(Lit63, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm", 897055);
    Lit27 = PairWithPosition.make(Lit65, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm", 872476);
    Lit26 = PairWithPosition.make(Lit66, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm", 880668);
    Lit25 = PairWithPosition.make(Lit67, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm", 876572);
    Lit24 = Symbol.valueOf("pregexp-read-posix-char-class");
    Lit23 = Char.valueOf(58);
    Lit22 = Char.valueOf(10);
    Lit21 = Symbol.valueOf(":not-wbdry");
    Lit20 = PairWithPosition.make(pregexp.Lit12 = Symbol.valueOf(":neg-char"), PairWithPosition.make(pregexp.Lit18 = Symbol.valueOf(":space"), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm", 704551), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm", 704540);
    Lit19 = Symbol.valueOf(":wbdry");
    Lit17 = Symbol.valueOf(":digit");
    Lit16 = PairWithPosition.make(Lit12, PairWithPosition.make(pregexp.Lit14 = Symbol.valueOf(":word"), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm", 716839), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm", 716828);
    Lit15 = PairWithPosition.make(Lit12, PairWithPosition.make(Lit17, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm", 688167), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm", 688156);
    Lit13 = Symbol.valueOf(":empty");
    Lit11 = IntNum.valueOf(2);
    Lit8 = Symbol.valueOf(":bos");
    Lit7 = Symbol.valueOf("backslash");
    Lit6 = Symbol.valueOf("pregexp-read-piece");
    Lit5 = Symbol.valueOf(":backref");
    Lit4 = Symbol.valueOf(":eos");
    Lit3 = IntNum.valueOf(1);
    Lit2 = Symbol.valueOf(":seq");
    Lit1 = Symbol.valueOf(":or");
    Lit0 = IntNum.valueOf(20050502);
    $instance = new pregexp();
    pregexp localPregexp = $instance;
    void tmp1044_1041 = new ModuleMethod(localPregexp, 16, "pregexp-reverse!", 4097);
    tmp1044_1041.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm:47");
    pregexp$Mnreverse$Ex = tmp1044_1041;
    void tmp1073_1070 = new ModuleMethod(localPregexp, 17, "pregexp-read-pattern", 12291);
    tmp1073_1070.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm:70");
    pregexp$Mnread$Mnpattern = tmp1073_1070;
    void tmp1102_1099 = new ModuleMethod(localPregexp, 18, "pregexp-read-branch", 12291);
    tmp1102_1099.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm:84");
    pregexp$Mnread$Mnbranch = tmp1102_1099;
    void tmp1131_1128 = new ModuleMethod(localPregexp, 19, "pregexp-read-piece", 12291);
    tmp1131_1128.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm:96");
    pregexp$Mnread$Mnpiece = tmp1131_1128;
    void tmp1160_1157 = new ModuleMethod(localPregexp, 20, "pregexp-read-escaped-number", 12291);
    tmp1160_1157.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm:143");
    pregexp$Mnread$Mnescaped$Mnnumber = tmp1160_1157;
    void tmp1189_1186 = new ModuleMethod(localPregexp, 21, "pregexp-read-escaped-char", 12291);
    tmp1189_1186.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm:160");
    pregexp$Mnread$Mnescaped$Mnchar = tmp1189_1186;
    void tmp1218_1215 = new ModuleMethod(localPregexp, 22, "pregexp-read-posix-char-class", 12291);
    tmp1218_1215.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm:179");
    pregexp$Mnread$Mnposix$Mnchar$Mnclass = tmp1218_1215;
    void tmp1247_1244 = new ModuleMethod(localPregexp, 23, "pregexp-read-cluster-type", 12291);
    tmp1247_1244.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm:205");
    pregexp$Mnread$Mncluster$Mntype = tmp1247_1244;
    void tmp1276_1273 = new ModuleMethod(localPregexp, 24, "pregexp-read-subpattern", 12291);
    tmp1276_1273.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm:238");
    pregexp$Mnread$Mnsubpattern = tmp1276_1273;
    void tmp1305_1302 = new ModuleMethod(localPregexp, 25, "pregexp-wrap-quantifier-if-any", 12291);
    tmp1305_1302.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm:259");
    pregexp$Mnwrap$Mnquantifier$Mnif$Mnany = tmp1305_1302;
    void tmp1334_1331 = new ModuleMethod(localPregexp, 26, "pregexp-read-nums", 12291);
    tmp1334_1331.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm:305");
    pregexp$Mnread$Mnnums = tmp1334_1331;
    void tmp1363_1360 = new ModuleMethod(localPregexp, 27, "pregexp-invert-char-list", 4097);
    tmp1363_1360.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm:328");
    pregexp$Mninvert$Mnchar$Mnlist = tmp1363_1360;
    void tmp1392_1389 = new ModuleMethod(localPregexp, 28, "pregexp-read-char-list", 12291);
    tmp1392_1389.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm:335");
    pregexp$Mnread$Mnchar$Mnlist = tmp1392_1389;
    void tmp1421_1418 = new ModuleMethod(localPregexp, 29, "pregexp-string-match", 24582);
    tmp1421_1418.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm:373");
    pregexp$Mnstring$Mnmatch = tmp1421_1418;
    void tmp1450_1447 = new ModuleMethod(localPregexp, 30, "pregexp-char-word?", 4097);
    tmp1450_1447.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm:384");
    pregexp$Mnchar$Mnword$Qu = tmp1450_1447;
    void tmp1479_1476 = new ModuleMethod(localPregexp, 31, "pregexp-at-word-boundary?", 12291);
    tmp1479_1476.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm:392");
    pregexp$Mnat$Mnword$Mnboundary$Qu = tmp1479_1476;
    void tmp1508_1505 = new ModuleMethod(localPregexp, 32, "pregexp-check-if-in-char-class?", 8194);
    tmp1508_1505.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm:404");
    pregexp$Mncheck$Mnif$Mnin$Mnchar$Mnclass$Qu = tmp1508_1505;
    void tmp1537_1534 = new ModuleMethod(localPregexp, 33, "pregexp-list-ref", 8194);
    tmp1537_1534.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm:434");
    pregexp$Mnlist$Mnref = tmp1537_1534;
    void tmp1566_1563 = new ModuleMethod(localPregexp, 34, "pregexp-make-backref-list", 4097);
    tmp1566_1563.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm:453");
    pregexp$Mnmake$Mnbackref$Mnlist = tmp1566_1563;
    void tmp1591_1588 = new ModuleMethod(localPregexp, 35, null, 0);
    tmp1591_1588.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm:468");
    lambda$Fn1 = tmp1591_1588;
    void tmp1616_1613 = new ModuleMethod(localPregexp, 36, null, 0);
    tmp1616_1613.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm:577");
    lambda$Fn4 = tmp1616_1613;
    void tmp1641_1638 = new ModuleMethod(localPregexp, 37, null, 0);
    tmp1641_1638.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm:555");
    lambda$Fn5 = tmp1641_1638;
    void tmp1666_1663 = new ModuleMethod(localPregexp, 38, null, 0);
    tmp1666_1663.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm:582");
    lambda$Fn9 = tmp1666_1663;
    void tmp1691_1688 = new ModuleMethod(localPregexp, 39, null, 0);
    tmp1691_1688.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm:560");
    lambda$Fn10 = tmp1691_1688;
    void tmp1716_1713 = new ModuleMethod(localPregexp, 40, null, 0);
    tmp1716_1713.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm:568");
    lambda$Fn11 = tmp1716_1713;
    void tmp1745_1742 = new ModuleMethod(localPregexp, 41, "pregexp-match-positions-aux", 24582);
    tmp1745_1742.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm:464");
    pregexp$Mnmatch$Mnpositions$Mnaux = tmp1745_1742;
    void tmp1774_1771 = new ModuleMethod(localPregexp, 42, "pregexp-replace-aux", 16388);
    tmp1774_1771.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm:643");
    pregexp$Mnreplace$Mnaux = tmp1774_1771;
    void tmp1803_1800 = new ModuleMethod(localPregexp, 43, "pregexp", 4097);
    tmp1803_1800.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm:669");
    pregexp = tmp1803_1800;
    void tmp1832_1829 = new ModuleMethod(localPregexp, 44, "pregexp-match-positions", 61442);
    tmp1832_1829.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm:674");
    pregexp$Mnmatch$Mnpositions = tmp1832_1829;
    void tmp1861_1858 = new ModuleMethod(localPregexp, 45, "pregexp-match", 61442);
    tmp1861_1858.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm:694");
    pregexp$Mnmatch = tmp1861_1858;
    void tmp1890_1887 = new ModuleMethod(localPregexp, 46, "pregexp-split", 8194);
    tmp1890_1887.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm:704");
    pregexp$Mnsplit = tmp1890_1887;
    void tmp1919_1916 = new ModuleMethod(localPregexp, 47, "pregexp-replace", 12291);
    tmp1919_1916.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm:727");
    pregexp$Mnreplace = tmp1919_1916;
    void tmp1948_1945 = new ModuleMethod(localPregexp, 48, "pregexp-replace*", 12291);
    tmp1948_1945.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm:740");
    pregexp$Mnreplace$St = tmp1948_1945;
    void tmp1977_1974 = new ModuleMethod(localPregexp, 49, "pregexp-quote", 4097);
    tmp1977_1974.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm:768");
    pregexp$Mnquote = tmp1977_1974;
    $runBody$();
  }
  
  public pregexp()
  {
    ModuleInfo.register(this);
  }
  
  public void apply(CallContext paramCallContext)
  {
    ModuleMethod.applyError();
  }
  
  /* Error */
  public Object applyN(ModuleMethod arg1, Object[] arg2)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 922	gnu/expr/ModuleMethod:selector	I
    //   4: lookupswitch	default:+162->166, 29:+44->48, 41:+66->70, 44:+88->92, 45:+125->129
    //   48: aload_2
    //   49: iconst_0
    //   50: aaload
    //   51: aload_2
    //   52: iconst_1
    //   53: aaload
    //   54: aload_2
    //   55: iconst_2
    //   56: aaload
    //   57: aload_2
    //   58: iconst_3
    //   59: aaload
    //   60: aload_2
    //   61: iconst_4
    //   62: aaload
    //   63: aload_2
    //   64: iconst_5
    //   65: aaload
    //   66: invokestatic 1033	gnu/kawa/slib/pregexp:pregexpStringMatch	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   69: areturn
    //   70: aload_2
    //   71: iconst_0
    //   72: aaload
    //   73: aload_2
    //   74: iconst_1
    //   75: aaload
    //   76: aload_2
    //   77: iconst_2
    //   78: aaload
    //   79: aload_2
    //   80: iconst_3
    //   81: aaload
    //   82: aload_2
    //   83: iconst_4
    //   84: aaload
    //   85: aload_2
    //   86: iconst_5
    //   87: aaload
    //   88: invokestatic 641	gnu/kawa/slib/pregexp:pregexpMatchPositionsAux	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   91: areturn
    //   92: aload_2
    //   93: iconst_0
    //   94: aaload
    //   95: aload_2
    //   96: iconst_1
    //   97: aaload
    //   98: aload_2
    //   99: arraylength
    //   100: iconst_2
    //   101: isub
    //   102: istore_3
    //   103: iload_3
    //   104: anewarray 178	java/lang/Object
    //   107: goto +11 -> 118
    //   110: dup
    //   111: iload_3
    //   112: aload_2
    //   113: iload_3
    //   114: iconst_2
    //   115: iadd
    //   116: aaload
    //   117: aastore
    //   118: iinc 3 -1
    //   121: iload_3
    //   122: ifge -12 -> 110
    //   125: invokestatic 655	gnu/kawa/slib/pregexp:pregexpMatchPositions$V	(Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   128: areturn
    //   129: aload_2
    //   130: iconst_0
    //   131: aaload
    //   132: aload_2
    //   133: iconst_1
    //   134: aaload
    //   135: aload_2
    //   136: arraylength
    //   137: iconst_2
    //   138: isub
    //   139: istore_3
    //   140: iload_3
    //   141: anewarray 178	java/lang/Object
    //   144: goto +11 -> 155
    //   147: dup
    //   148: iload_3
    //   149: aload_2
    //   150: iload_3
    //   151: iconst_2
    //   152: iadd
    //   153: aaload
    //   154: aastore
    //   155: iinc 3 -1
    //   158: iload_3
    //   159: ifge -12 -> 147
    //   162: invokestatic 1036	gnu/kawa/slib/pregexp:pregexpMatch$V	(Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   165: areturn
    //   166: aload_0
    //   167: aload_1
    //   168: aload_2
    //   169: invokespecial 1040	gnu/expr/ModuleBody:applyN	(Lgnu/expr/ModuleMethod;[Ljava/lang/Object;)Ljava/lang/Object;
    //   172: areturn
    // Line number table:
    //   Java source line #373	-> byte code offset #48
    //   Java source line #464	-> byte code offset #70
    //   Java source line #674	-> byte code offset #92
    //   Java source line #694	-> byte code offset #129
  }
}
